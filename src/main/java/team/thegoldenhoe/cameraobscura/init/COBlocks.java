package team.thegoldenhoe.cameraobscura.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import team.thegoldenhoe.cameraobscura.Info;
import team.thegoldenhoe.cameraobscura.block.HorizontalFrameBlock;
import team.thegoldenhoe.cameraobscura.block.FrameBlock;
import team.thegoldenhoe.cameraobscura.block.HangingFrameBlock;

public class COBlocks {

	public static final Block FRAME = registerFrame("frame", null);
	public static final Block WHITE_FRAME = registerFrame("white_frame", DyeColor.WHITE);
	public static final Block ORANGE_FRAME = registerFrame("orange_frame", DyeColor.ORANGE);
	public static final Block MAGENTA_FRAME = registerFrame("magenta_frame", DyeColor.MAGENTA);
	public static final Block LIGHT_BLUE_FRAME = registerFrame("light_blue_frame", DyeColor.LIGHT_BLUE);
	public static final Block YELLOW_FRAME = registerFrame("yellow_frame", DyeColor.YELLOW);
	public static final Block LIME_FRAME = registerFrame("lime_frame", DyeColor.LIME);
	public static final Block PINK_FRAME = registerFrame("pink_frame", DyeColor.PINK);
	public static final Block GRAY_FRAME = registerFrame("gray_frame", DyeColor.GRAY);
	public static final Block LIGHT_GRAY_FRAME = registerFrame("light_gray_frame", DyeColor.LIGHT_GRAY);
	public static final Block CYAN_FRAME = registerFrame("cyan_frame", DyeColor.CYAN);
	public static final Block PURPLE_FRAME = registerFrame("purple_frame", DyeColor.PURPLE);
	public static final Block BLUE_FRAME = registerFrame("blue_frame", DyeColor.BLUE);
	public static final Block BROWN_FRAME = registerFrame("brown_frame", DyeColor.BROWN);
	public static final Block GREEN_FRAME = registerFrame("green_frame", DyeColor.GREEN);
	public static final Block RED_FRAME = registerFrame("red_frame", DyeColor.RED);
	public static final Block BLACK_FRAME = registerFrame("black_frame", DyeColor.BLACK);

	public static final Block HORIZONTAL_FRAME = registerHorizontalFrame("horizontal_frame", null);
	public static final Block WHITE_HORIZONTAL_FRAME = registerHorizontalFrame("white_horizontal_frame", DyeColor.WHITE);
	public static final Block ORANGE_HORIZONTAL_FRAME = registerHorizontalFrame("orange_horizontal_frame", DyeColor.ORANGE);
	public static final Block MAGENTA_HORIZONTAL_FRAME = registerHorizontalFrame("magenta_horizontal_frame", DyeColor.MAGENTA);
	public static final Block LIGHT_BLUE_HORIZONTAL_FRAME = registerHorizontalFrame("light_blue_horizontal_frame", DyeColor.LIGHT_BLUE);
	public static final Block YELLOW_HORIZONTAL_FRAME = registerHorizontalFrame("yellow_horizontal_frame", DyeColor.YELLOW);
	public static final Block LIME_HORIZONTAL_FRAME = registerHorizontalFrame("lime_horizontal_frame", DyeColor.LIME);
	public static final Block PINK_HORIZONTAL_FRAME = registerHorizontalFrame("pink_horizontal_frame", DyeColor.PINK);
	public static final Block GRAY_HORIZONTAL_FRAME = registerHorizontalFrame("gray_horizontal_frame", DyeColor.GRAY);
	public static final Block LIGHT_GRAY_HORIZONTAL_FRAME = registerHorizontalFrame("light_gray_horizontal_frame", DyeColor.LIGHT_GRAY);
	public static final Block CYAN_HORIZONTAL_FRAME = registerHorizontalFrame("cyan_horizontal_frame", DyeColor.CYAN);
	public static final Block PURPLE_HORIZONTAL_FRAME = registerHorizontalFrame("purple_horizontal_frame", DyeColor.PURPLE);
	public static final Block BLUE_HORIZONTAL_FRAME = registerHorizontalFrame("blue_horizontal_frame", DyeColor.BLUE);
	public static final Block BROWN_HORIZONTAL_FRAME = registerHorizontalFrame("brown_horizontal_frame", DyeColor.BROWN);
	public static final Block GREEN_HORIZONTAL_FRAME = registerHorizontalFrame("green_horizontal_frame", DyeColor.GREEN);
	public static final Block RED_HORIZONTAL_FRAME = registerHorizontalFrame("red_horizontal_frame", DyeColor.RED);
	public static final Block BLACK_HORIZONTAL_FRAME = registerHorizontalFrame("black_horizontal_frame", DyeColor.BLACK);

	public static final Block HANGING_FRAME = register("hanging_frame", new HangingFrameBlock(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES)));

	private static Block registerFrame(String name, DyeColor color) {
		return register(name, new FrameBlock(color, FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES)));
	}

	private static Block registerHorizontalFrame(String name, DyeColor color) {
		return register(name, new HorizontalFrameBlock(color, FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES)));
	}

	private static Block register(String name, Block block) {
		return Registry.register(Registry.BLOCK, new Identifier(Info.MODID, name), block);
	}
}
