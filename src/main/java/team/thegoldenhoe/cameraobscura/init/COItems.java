package team.thegoldenhoe.cameraobscura.init;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.thegoldenhoe.cameraobscura.Info;
import team.thegoldenhoe.cameraobscura.client.PhotoFilter;
import team.thegoldenhoe.cameraobscura.client.PhotoFilters;
import team.thegoldenhoe.cameraobscura.item.FilterItem;
import team.thegoldenhoe.cameraobscura.item.FrameBrushItem;
import team.thegoldenhoe.cameraobscura.item.PolaroidPhotoItem;
import team.thegoldenhoe.cameraobscura.item.PolaroidStackItem;
import team.thegoldenhoe.cameraobscura.item.SdCardItem;
import team.thegoldenhoe.cameraobscura.item.VintagePhotoItem;
import team.thegoldenhoe.cameraobscura.item.camera.DigitalCameraItem;
import team.thegoldenhoe.cameraobscura.item.camera.PolaroidCameraItem;
import team.thegoldenhoe.cameraobscura.item.camera.VintageCameraItem;

public class COItems {

	public static final Item DIGITAL_CAMERA = register("digital_camera", new DigitalCameraItem(new Settings().maxCount(1).group(COItemGroups.MAIN)));
	public static final Item POLAROID_CAMERA = register("polaroid_camera", new PolaroidCameraItem(new Settings().maxCount(1).group(COItemGroups.MAIN)));
	public static final Item VINTAGE_CAMERA = register("vintage_camera", new VintageCameraItem(new Settings().maxCount(1).group(COItemGroups.MAIN)));

	public static final Item SD_CARD = register("sd_card", new SdCardItem(new Settings().maxCount(1).group(COItemGroups.MAIN)));
	public static final Item POLAROID_STACK = register("polaroid_stack", new PolaroidStackItem(new Settings().maxCount(1).group(COItemGroups.MAIN)));
	public static final Item POLAROID_PHOTO = register("polaroid_photo", new PolaroidPhotoItem(new Settings().maxCount(1).group(COItemGroups.MAIN)));
	public static final Item VINTAGE_PHOTO = register("vintage_photo", new VintagePhotoItem(new Settings().maxCount(1).group(COItemGroups.MAIN)));

	public static final Item SEPIA_FILTER = registerFilter("sepia_filter", PhotoFilters.SEPIA);
	public static final Item GLOOMY_FILTER = registerFilter("gloomy_filter", PhotoFilters.BLACK_AND_WHITE);
	public static final Item BRIGHT_AND_HAPPY_FILTER = registerFilter("bright_and_happy_filter", PhotoFilters.BRIGHT_AND_HAPPY);
	public static final Item RETRO_FILTER = registerFilter("retro_filter", PhotoFilters.VINTAGE);
	public static final Item HIGH_CONTRAST_FILTER = registerFilter("high_contrast_filter", PhotoFilters.HIGH_CONTRAST);
	public static final Item LOW_SOBEL_FILTER = registerFilter("low_sobel_filter", PhotoFilters.LOW_SOBEL);
	public static final Item HIGH_SOBEL_FILTER = registerFilter("high_sobel_filter", PhotoFilters.HIGH_SOBEL);

	public static final Item FRAME_BRUSH = register("frame_brush", new FrameBrushItem(new Settings().maxCount(1).group(COItemGroups.MAIN)));

	private static Item registerFilter(String name, PhotoFilter filter) {
		return register(name, new FilterItem(filter, new Settings().maxCount(1).group(COItemGroups.MAIN)));
	}

	private static Item registerFrame(Block block) {
		return register(Registry.BLOCK.getId(block).getPath(), new BlockItem(block, new Settings().group(COItemGroups.MAIN)));
	}

	private static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(Info.MODID, name), item);
	}

	static {
		registerFrame(COBlocks.FRAME);
		registerFrame(COBlocks.WHITE_FRAME);
		registerFrame(COBlocks.ORANGE_FRAME);
		registerFrame(COBlocks.MAGENTA_FRAME);
		registerFrame(COBlocks.LIGHT_BLUE_FRAME);
		registerFrame(COBlocks.YELLOW_FRAME);
		registerFrame(COBlocks.LIME_FRAME);
		registerFrame(COBlocks.PINK_FRAME);
		registerFrame(COBlocks.GRAY_FRAME);
		registerFrame(COBlocks.LIGHT_GRAY_FRAME);
		registerFrame(COBlocks.CYAN_FRAME);
		registerFrame(COBlocks.PURPLE_FRAME);
		registerFrame(COBlocks.BLUE_FRAME);
		registerFrame(COBlocks.BROWN_FRAME);
		registerFrame(COBlocks.GREEN_FRAME);
		registerFrame(COBlocks.RED_FRAME);
		registerFrame(COBlocks.BLACK_FRAME);
		registerFrame(COBlocks.HORIZONTAL_FRAME);
		registerFrame(COBlocks.WHITE_HORIZONTAL_FRAME);
		registerFrame(COBlocks.ORANGE_HORIZONTAL_FRAME);
		registerFrame(COBlocks.MAGENTA_HORIZONTAL_FRAME);
		registerFrame(COBlocks.LIGHT_BLUE_HORIZONTAL_FRAME);
		registerFrame(COBlocks.YELLOW_HORIZONTAL_FRAME);
		registerFrame(COBlocks.LIME_HORIZONTAL_FRAME);
		registerFrame(COBlocks.PINK_HORIZONTAL_FRAME);
		registerFrame(COBlocks.GRAY_HORIZONTAL_FRAME);
		registerFrame(COBlocks.LIGHT_GRAY_HORIZONTAL_FRAME);
		registerFrame(COBlocks.CYAN_HORIZONTAL_FRAME);
		registerFrame(COBlocks.PURPLE_HORIZONTAL_FRAME);
		registerFrame(COBlocks.BLUE_HORIZONTAL_FRAME);
		registerFrame(COBlocks.BROWN_HORIZONTAL_FRAME);
		registerFrame(COBlocks.GREEN_HORIZONTAL_FRAME);
		registerFrame(COBlocks.RED_HORIZONTAL_FRAME);
		registerFrame(COBlocks.BLACK_HORIZONTAL_FRAME);
		registerFrame(COBlocks.HANGING_FRAME);
	}
}
