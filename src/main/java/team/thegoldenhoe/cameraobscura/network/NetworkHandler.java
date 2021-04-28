package team.thegoldenhoe.cameraobscura.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import team.thegoldenhoe.cameraobscura.CameraObscura;

import java.io.IOException;

public class NetworkHandler {
    public static final Identifier SEND_PHOTO_CHANNEL = new Identifier("cameraobscura", "send_photo");

    public static void init() {
        ServerPlayNetworking.registerGlobalReceiver(SEND_PHOTO_CHANNEL, (server, player, handler, b, responseSender) -> {
            try {
                CameraObscura.photoManager.put(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
