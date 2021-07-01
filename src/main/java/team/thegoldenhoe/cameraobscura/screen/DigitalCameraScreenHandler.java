package team.thegoldenhoe.cameraobscura.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;
import team.thegoldenhoe.cameraobscura.item.FilterItem;
import team.thegoldenhoe.cameraobscura.item.SdCardItem;
import team.thegoldenhoe.cameraobscura.init.COScreenHandlers;
import team.thegoldenhoe.cameraobscura.item.camera.CameraStorage;

public class DigitalCameraScreenHandler extends CameraScreenHandler {
	private static final String DIGITAL_CAMERA_TEXTURE = "digital_camera";
	private final ItemStack camera;
	private final Inventory inventory;

	public DigitalCameraScreenHandler(int syncId, PlayerInventory playerInv) {
		this(syncId, playerInv, ItemStack.EMPTY);
	}

	public DigitalCameraScreenHandler(int syncId, PlayerInventory playerInv, ItemStack camera) {
		super(COScreenHandlers.DIGITAL_CAMERA, syncId);
		this.camera = camera;
		this.inventory = new SimpleInventory(3);

		// SD Card Slot
		this.addSlot(new Slot(this.inventory, 0, 41, 53) {
			/**
			 * Check if the stack is allowed to be placed in this slot.
			 */
			@Override
			public boolean canInsert(ItemStack stack) {
				return super.canInsert(stack) && stack.getItem() instanceof SdCardItem && !this.hasStack();
			}
		});

		// Filter Slot 1
		this.addSlot(new Slot(this.inventory, 1, 93, 53) {
			/**
			 * Check if the stack is allowed to be placed in this slot.
			 */
			@Override
			public boolean canInsert(ItemStack stack) {
				return super.canInsert(stack) && stack.getItem() instanceof FilterItem && !this.hasStack();
			}
		});

		// Filter Slot 2
		this.addSlot(new Slot(this.inventory, 2, 119, 53) {
			/**
			 * Check if the stack is allowed to be placed in this slot.
			 */
			@Override
			public boolean canInsert(ItemStack stack) {
				return super.canInsert(stack) && stack.getItem() instanceof FilterItem && !this.hasStack();
			}
		});

		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int i = 0; i < 9; ++i) {
			this.addSlot(new Slot(playerInv, i, 8 + i * 18, 142));
		}

		DefaultedList<ItemStack> items = CameraStorage.getItems(this.camera);
		for (int i = 0; i < items.size(); i++) {
			this.inventory.setStack(i, items.get(i));
		}
	}

	@Override
	public void close(PlayerEntity player) {
		CameraStorage.setItems(this.camera, this.inventory);
		super.close(player);
	}

	@Override
	public boolean canUse(PlayerEntity player) {
		return this.inventory.canPlayerUse(player);
	}

	/**
	 * Take a stack from the specified inventory slot.
	 */
	@Override
	public ItemStack transferSlot(PlayerEntity player, int index) {
		ItemStack stack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasStack()) {
			ItemStack stack_1 = slot.getStack();
			stack = stack_1.copy();

			// TODO - shift click

			if (stack_1.isEmpty()) {
				slot.setStack(ItemStack.EMPTY);
			} else {
				slot.onQuickTransfer(stack, stack_1);
			}

			if (stack_1.getCount() == stack.getCount()) {
				return ItemStack.EMPTY;
            }

			slot.onTakeItem(player, stack_1);
		}

		return stack;
	}

	@Override
	public String getScreenBackground() {
		return DIGITAL_CAMERA_TEXTURE;
	}
}
