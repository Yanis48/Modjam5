package team.thegoldenhoe.cameraobscura.item.camera;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import team.thegoldenhoe.cameraobscura.item.VintagePhotoItem;
import team.thegoldenhoe.cameraobscura.screen.VintageCameraScreenHandler;
import team.thegoldenhoe.cameraobscura.util.CameraType;

import java.util.UUID;

public class VintageCameraItem extends CameraItem {

    public VintageCameraItem(Settings settings) {
        super(CameraType.VINTAGE, settings);
    }

    @Override
    protected boolean canTakePhoto(ItemStack camera, PlayerEntity user) {
        ItemStack stack = CameraStorage.getItem(camera);
        if (stack.getItem() instanceof VintagePhotoItem) {
            if (VintagePhotoItem.getPhoto(stack) == null) {
                return true;
            } else {
                user.sendMessage(new TranslatableText("cameraobscura.chat.full_paper"), true);
                return false;
            }
        }
        user.sendMessage(new TranslatableText("cameraobscura.chat.missing_paper"), true);
        return false;
    }

    @Override
    protected void onTakePicture(ItemStack camera, PlayerEntity user, UUID photoName) {
        super.onTakePicture(camera, user, photoName);
        ItemStack stack = CameraStorage.getItem(camera);
        if (stack.getItem() instanceof VintagePhotoItem) {
            VintagePhotoItem.setPhoto(stack, photoName);
            camera.setTag(CameraStorage.setItem(camera, 0, stack));
        }
    }

    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(ItemStack camera) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) -> {
            return new VintageCameraScreenHandler(syncId, inventory, camera);
        }, new LiteralText(""));
    }
}
