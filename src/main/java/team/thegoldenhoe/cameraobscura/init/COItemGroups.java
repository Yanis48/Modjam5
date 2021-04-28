package team.thegoldenhoe.cameraobscura.init;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import team.thegoldenhoe.cameraobscura.CameraObscura;

public class COItemGroups {

	public static final ItemGroup MAIN = register("main", COItems.POLAROID_CAMERA);

	private static ItemGroup register(String name, ItemConvertible icon) {
		return FabricItemGroupBuilder.build(CameraObscura.id(name), () -> new ItemStack(icon));
	}
}
