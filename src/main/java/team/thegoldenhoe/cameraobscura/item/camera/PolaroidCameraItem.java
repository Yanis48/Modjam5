package team.thegoldenhoe.cameraobscura.item.camera;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import team.thegoldenhoe.cameraobscura.item.PolaroidStackItem;
import team.thegoldenhoe.cameraobscura.screen.PolaroidCameraScreenHandler;
import team.thegoldenhoe.cameraobscura.util.CameraType;

import java.util.UUID;

public class PolaroidCameraItem extends CameraItem {

    public PolaroidCameraItem(Settings settings) {
        super(CameraType.POLAROID, settings);
    }

    @Override
    protected boolean canTakePhoto(ItemStack camera, PlayerEntity user) {
        ItemStack stack = CameraStorage.getItem(camera);
        if (stack.getItem() instanceof PolaroidStackItem) {
            if (PolaroidStackItem.getRemainingUses(stack) > 0) {
                return true;
            } else {
                // should never happen without commands, as polaroid stacks are removed once totally used
                user.sendMessage(new TranslatableText("cameraobscura.chat.full_stacks"), true);
                return false;
            }
        }
        user.sendMessage(new TranslatableText("cameraobscura.chat.missing_stacks"), true);
        return false;
    }

    @Override
    protected void onTakePicture(ItemStack camera, PlayerEntity user, UUID photoName) {
        super.onTakePicture(camera, user, photoName);
        ItemStack stack = CameraStorage.getItem(camera);
        if (stack.getItem() instanceof PolaroidStackItem) {
            PolaroidStackItem.savePhoto(stack, user, photoName);
            camera.setTag(CameraStorage.setItem(camera, 0, stack));
        }
    }

    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(ItemStack camera) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> {
            return new PolaroidCameraScreenHandler(syncId, inventory, camera);
        }, new LiteralText(""));
    }
}
