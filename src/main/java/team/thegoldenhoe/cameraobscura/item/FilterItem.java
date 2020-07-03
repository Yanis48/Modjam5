package team.thegoldenhoe.cameraobscura.item;

import net.minecraft.item.Item;
import team.thegoldenhoe.cameraobscura.client.PhotoFilter;

public class FilterItem extends Item {
	private PhotoFilter filter;

	public FilterItem(PhotoFilter filter, Settings settings) {
		super(settings);
		this.filter = filter;
	}

	public PhotoFilter getFilter() {
		return this.filter;
	}
}
