package team.thegoldenhoe.cameraobscura.util;

import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.sound.SoundEvent;
import team.thegoldenhoe.cameraobscura.registry.COScreenHandlers;
import team.thegoldenhoe.cameraobscura.registry.COSounds;

public enum CameraType {
	DIGITAL("digital_camera", COScreenHandlers.DIGITAL_CAMERA, COSounds.DIGITAL),
	POLAROID("polaroid_camera", COScreenHandlers.POLAROID_CAMERA, COSounds.POLAROID),
	VINTAGE("vintage_camera", COScreenHandlers.VINTAGE_CAMERA, COSounds.VINTAGE);

	private String textureName;
	private ScreenHandlerType<?> screenHandlerType;
	private SoundEvent sound;
	public static CameraType[] VALUES = values();

	CameraType(String textureName, ScreenHandlerType<?> screenHandlerType, SoundEvent sound) {
		this.textureName = textureName;
		this.sound = sound;
	}

	public String getTextureName() {
		return this.textureName;
	}

	public ScreenHandlerType<?> getScreenHandlerType() {
		return this.screenHandlerType;
	}

	public SoundEvent getSound() {
		return this.sound;
	}
}
