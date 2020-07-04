package team.thegoldenhoe.cameraobscura.registry;

import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.thegoldenhoe.cameraobscura.Info;
import team.thegoldenhoe.cameraobscura.client.PhotoFilter;
import team.thegoldenhoe.cameraobscura.client.PhotoFilters;
import team.thegoldenhoe.cameraobscura.item.CameraItem;
import team.thegoldenhoe.cameraobscura.item.FilterItem;
import team.thegoldenhoe.cameraobscura.item.FrameBrushItem;
import team.thegoldenhoe.cameraobscura.item.PolaroidPhotoItem;
import team.thegoldenhoe.cameraobscura.item.PolaroidStackItem;
import team.thegoldenhoe.cameraobscura.item.SdCardItem;
import team.thegoldenhoe.cameraobscura.item.VintagePhotoItem;
import team.thegoldenhoe.cameraobscura.util.CameraType;

public class COItems {

	public static final Item DIGITAL_CAMERA = register("digital_camera", new CameraItem(CameraType.DIGITAL, new Settings().maxCount(1).group(COItemGroups.MAIN)));
	public static final Item POLAROID_CAMERA = register("polaroid_camera", new CameraItem(CameraType.POLAROID, new Settings().maxCount(1).group(COItemGroups.MAIN)));
	public static final Item VINTAGE_CAMERA = register("vintage_camera", new CameraItem(CameraType.VINTAGE, new Settings().maxCount(1).group(COItemGroups.MAIN)));

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

	private static Item register(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(Info.MODID, name), item);
	}
}
