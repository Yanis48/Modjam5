package team.thegoldenhoe.cameraobscura.util;

import net.minecraft.sound.SoundEvent;
import team.thegoldenhoe.cameraobscura.registry.COSounds;

public enum CameraType {
	DIGITAL("digital_camera", COSounds.DIGITAL),
	POLAROID("polaroid_camera", COSounds.POLAROID),
	VINTAGE("vintage_camera", COSounds.VINTAGE);

	private String textureName;
	private SoundEvent sound;
	public static CameraType[] VALUES = values();

	CameraType(String textureName, SoundEvent sound) {
		this.textureName = textureName;
		this.sound = sound;
	}

	public String getTextureName() {
		return this.textureName;
	}

	public SoundEvent getSound() {
		return this.sound;
	}
}
