package io.github.scaredsmods.metallicmc.block.machine.metalcombiner.blockentity;

import io.github.scaredsmods.metallicmc.block.machine.ModBlockEntities;
import io.github.scaredsmods.metallicmc.api.recipe.metalcombiner.MetalCombiningRecipe;
import io.github.scaredsmods.metallicmc.screen.metalcombiner.MetalCombiningScreenHandler;
import io.github.scaredsmods.metallicmc.util.ImplementedInventory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MetalCombinerBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);


    public static final int INPUT_SLOT_1 = 0;
    public static final int INPUT_SLOT_2 = 1;
    public static final int OUTPUT_SLOT = 2;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;


    public MetalCombinerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.METAL_COMBINER_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> MetalCombinerBlockEntity.this.progress;
                    case 1 -> MetalCombinerBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                 switch (index) {
                    case 0 -> MetalCombinerBlockEntity.this.progress = value;
                    case 1 -> MetalCombinerBlockEntity.this.maxProgress = value;

                }
            }

            @Override
            public int size() {
                return 3;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("metallicmc.gui.title.metal_combiner");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MetalCombiningScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("metal_combiner.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("metal_combiner.progress");
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()){
            return;
        }
        if (isOutputSlotEmptyOrReceiveable()) {
            if (this.hasRecipe()) {
                this.increaseCraftProgress();
                markDirty(world, pos, state);

                if (hasCraftingFinished()) {
                    this.craftItem();
                    this.resetProgress();
                }
            } else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {

        Optional<RecipeEntry<MetalCombiningRecipe>> recipe = getCurrentRecipe();
        this.removeStack(INPUT_SLOT_1, 1);
        this.removeStack(INPUT_SLOT_2, 1);





        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<MetalCombiningRecipe>> recipe = getCurrentRecipe();


        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null))
                && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    private Optional<RecipeEntry<MetalCombiningRecipe>> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            inv.setStack(i, this.getStack(i));
        }
        return getWorld().getRecipeManager().getFirstMatch(MetalCombiningRecipe.Type.INSTANCE, inv, getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean isOutputSlotEmptyOrReceiveable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }
    public ItemStack getRenderStack(){
        if (!this.getStack(OUTPUT_SLOT).isEmpty() ){
            return this.getStack(OUTPUT_SLOT);
        } else if (!this.getStack(INPUT_SLOT_1).isEmpty()){
            return this.getStack(INPUT_SLOT_1);
        } else if (!this.getStack(INPUT_SLOT_2).isEmpty()) {
            return this.getStack(INPUT_SLOT_2);
        }else {
            return this.getStack(OUTPUT_SLOT);
        }

    }

    @Override
    public void markDirty() {
        world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        super.markDirty();
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
