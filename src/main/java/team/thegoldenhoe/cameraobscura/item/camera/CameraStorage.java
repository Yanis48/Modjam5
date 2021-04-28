package team.thegoldenhoe.cameraobscura.item.camera;

import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;

public class CameraStorage {

    public static ItemStack getItem(ItemStack camera) {
        DefaultedList<ItemStack> stacks = DefaultedList.ofSize(1, ItemStack.EMPTY);
        if (camera.getTag() != null) {
            Inventories.fromTag(camera.getTag(), stacks);
        }
        return stacks.get(0);
    }

    public static DefaultedList<ItemStack> getItems(ItemStack camera) {
        DefaultedList<ItemStack> stacks = DefaultedList.ofSize(3, ItemStack.EMPTY);
        if (camera.getTag() != null) {
            Inventories.fromTag(camera.getTag(), stacks);
        }
        return stacks;
    }

    public static CompoundTag setItem(ItemStack camera, int index, ItemStack stack) {
        DefaultedList<ItemStack> stacks = getItems(camera);
        if (camera.getTag() != null) {
            stacks.set(index, stack);
        }
        return Inventories.toTag(camera.getOrCreateSubTag("Items"), stacks);
    }

    public static CompoundTag setItems(ItemStack camera, Inventory inventory) {
        DefaultedList<ItemStack> stacks = DefaultedList.of();
        for (int i = 0; i < inventory.size(); i++) {
            stacks.add(inventory.getStack(i));
        }
        return Inventories.toTag(camera.getOrCreateSubTag("Items"), stacks);
    }
}
