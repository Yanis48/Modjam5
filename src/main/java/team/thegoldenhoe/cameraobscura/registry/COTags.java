package team.thegoldenhoe.cameraobscura.registry;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import team.thegoldenhoe.cameraobscura.Info;

public class COTags {

	public static class Blocks {
		public static final Tag<Block> FRAMES = register("frames");
		public static final Tag<Block> HORIZONTAL_FRAMES = register("horizontal_frames");
		public static final Tag<Block> HANGING_FRAMES = register("hanging_frames");

		private static Tag<Block> register(String name) {
			return TagRegistry.block(new Identifier(Info.MODID, name));
		}
	}

	public static class Items {
		public static final Tag<Item> FRAMES = register("frames");
		public static final Tag<Item> HORIZONTAL_FRAMES = register("horizontal_frames");
		public static final Tag<Item> HANGING_FRAMES = register("hanging_frames");
		public static final Tag<Item> FILTERS = register("filters");

		private static Tag<Item> register(String name) {
			return TagRegistry.item(new Identifier(Info.MODID, name));
		}
	}
}
