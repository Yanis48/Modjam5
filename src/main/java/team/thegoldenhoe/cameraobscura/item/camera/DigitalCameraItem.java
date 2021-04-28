package team.thegoldenhoe.cameraobscura.item.camera;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import team.thegoldenhoe.cameraobscura.item.SdCardItem;
import team.thegoldenhoe.cameraobscura.screen.DigitalCameraScreenHandler;
import team.thegoldenhoe.cameraobscura.util.CameraType;

import java.util.UUID;

public class DigitalCameraItem extends CameraItem {

    public DigitalCameraItem(Settings settings) {
        super(CameraType.DIGITAL, settings);
    }

    @Override
    protected boolean canTakePhoto(ItemStack camera, PlayerEntity user) {
        ItemStack stack = CameraStorage.getItems(camera).get(0);
        if (stack.getItem() instanceof SdCardItem) {
            if (SdCardItem.getRemainingUses(stack) > 0) {
                return true;
            } else {
                user.sendMessage(new TranslatableText("cameraobscura.chat.full_sd"), true);
                return false;
            }
        }
        user.sendMessage(new TranslatableText("cameraobscura.chat.missing_sd"), true);
        return false;
    }

    @Override
    protected void onTakePicture(ItemStack camera, PlayerEntity user, UUID photoName) {
        super.onTakePicture(camera, user, photoName);
        ItemStack stack = CameraStorage.getItems(camera).get(0);
        if (stack.getItem() instanceof SdCardItem) {
            SdCardItem.savePhoto(stack, photoName);
            camera.setTag(CameraStorage.setItem(camera, 0, stack));
        }
    }

    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(ItemStack camera) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> {
            return new DigitalCameraScreenHandler(syncId, inventory, camera);
        }, new LiteralText(""));
    }
}
