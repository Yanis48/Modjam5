package team.thegoldenhoe.cameraobscura.init;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import team.thegoldenhoe.cameraobscura.CameraObscura;

public class COTags {

	public static class Blocks {
		public static final Tag<Block> FRAMES = register("frames");
		public static final Tag<Block> HORIZONTAL_FRAMES = register("horizontal_frames");
		public static final Tag<Block> HANGING_FRAMES = register("hanging_frames");

		private static Tag<Block> register(String name) {
			return TagRegistry.block(CameraObscura.id(name));
		}
	}

	public static class Items {
		public static final Tag<Item> FRAMES = register("frames");
		public static final Tag<Item> HORIZONTAL_FRAMES = register("horizontal_frames");
		public static final Tag<Item> HANGING_FRAMES = register("hanging_frames");
		public static final Tag<Item> FILTERS = register("filters");

		private static Tag<Item> register(String name) {
			return TagRegistry.item(CameraObscura.id(name));
		}
	}
}
