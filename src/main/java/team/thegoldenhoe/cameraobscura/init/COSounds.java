package team.thegoldenhoe.cameraobscura.init;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.thegoldenhoe.cameraobscura.Info;

public class COSounds {
	public static final SoundEvent DIGITAL = register("digital");
	public static final SoundEvent POLAROID = register("polaroid");
	public static final SoundEvent VINTAGE = register("vintage");

	private static SoundEvent register(String name) {
		Identifier id = new Identifier(Info.MODID, name);
		return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
	}
}
