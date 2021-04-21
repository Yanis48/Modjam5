package team.thegoldenhoe.cameraobscura.item.nbt;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;

import java.util.ArrayList;
import java.util.List;

public class CameraData {

    public static int getUses(ItemStack stack) {
        CompoundTag root = stack.getTag();
        if (root != null && root.contains("Uses", 99)) {
            return root.getInt("Uses");
        }
        return 0;
    }

    public static void incrementUses(ItemStack stack) {
        CompoundTag root = stack.getTag();
        if (root != null) {
            int uses = getUses(stack);
            root.putInt("Uses", uses + 1);
        }
    }

    public static List<String> getSavedPaths(ItemStack stack) {
        CompoundTag root = stack.getTag();
        if (root != null && root.contains("SavedPaths", 9)) {
            ListTag tag = root.getList("SavedPaths", 9);
            List<String> savedPaths = new ArrayList<>();

            for (int i = 0; i < tag.size(); i++) {
                savedPaths.add(tag.getString(i));
            }

            return savedPaths;
        }
        return new ArrayList<>();
    }

    public static void savePath(ItemStack stack, String path) {
        CompoundTag root = stack.getTag();
        if (root != null) {
            if (!root.contains("SavedPaths", 9)) {
                root.put("SavedPaths", new ListTag());
            }

            root.getList("SavedPaths", 9).add(StringTag.of(path));
        }
    }

    public static String getPhoto(ItemStack stack) {
        CompoundTag root = stack.getTag();
        if (root != null && root.contains("Photo", 8)) {
            return root.getString("Photo");
        }
        return null;
    }

    public static void setPhoto(ItemStack stack, String photo) {
        CompoundTag root = stack.getTag();
        if (root != null) {
            root.putString("Photo", photo);
        }
    }
}
