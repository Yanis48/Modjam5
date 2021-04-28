package team.thegoldenhoe.cameraobscura.util;

import net.minecraft.sound.SoundEvent;
import team.thegoldenhoe.cameraobscura.init.COSounds;

public enum CameraType {
	DIGITAL(COSounds.DIGITAL),
	POLAROID(COSounds.POLAROID),
	VINTAGE(COSounds.VINTAGE);

	private SoundEvent sound;

	CameraType(SoundEvent sound) {
		this.sound = sound;
	}

	public SoundEvent getSound() {
		return this.sound;
	}
}
