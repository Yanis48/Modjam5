package team.thegoldenhoe.cameraobscura.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import team.thegoldenhoe.cameraobscura.Info;

public class COItemGroups {

	public static final ItemGroup MAIN = register("main", COItems.POLAROID_CAMERA);

	private static ItemGroup register(String name, ItemConvertible icon) {
		return FabricItemGroupBuilder.build(new Identifier(Info.MODID, name), () -> new ItemStack(icon));
	}
}
