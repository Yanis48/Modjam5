package team.thegoldenhoe.cameraobscura.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import team.thegoldenhoe.cameraobscura.item.PolaroidStackItem;
import team.thegoldenhoe.cameraobscura.item.VintagePhotoItem;
import team.thegoldenhoe.cameraobscura.util.CameraType;

public abstract class SingleSlotCameraScreenHandler extends CameraScreenHandler {
	protected final ScreenHandlerContext context;
	protected Inventory inventory;

	public SingleSlotCameraScreenHandler(ScreenHandlerType<?> screenType, int syncId, PlayerInventory playerInv, CameraType type) {
		this(screenType, syncId, playerInv, ScreenHandlerContext.EMPTY, type);
	}

	public SingleSlotCameraScreenHandler(ScreenHandlerType<?> screenType, int syncId, PlayerInventory playerInv, ScreenHandlerContext context, CameraType type) {
		super(screenType, syncId);
		this.context = context;
		this.inventory = new SimpleInventory(1);
		
		// Stacks slot
		this.addSlot(new Slot(this.inventory, 0, 80, 53) {
			/**
			 * Check if the stack is allowed to be placed in this slot.
			 */
			@Override
			public boolean canInsert(ItemStack stack) {
				// this is hacky, but...modjam!
				boolean initialReqs = super.canInsert(stack) && !this.hasStack();
				if (type == CameraType.POLAROID) {
					return initialReqs && stack.getItem() instanceof PolaroidStackItem;
				} else if (type == CameraType.VINTAGE) {
					return initialReqs && stack.getItem() instanceof VintagePhotoItem;
				}
				
				return false;
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
				slot.onStackChanged(stack, stack_1);
			}

			if (stack_1.getCount() == stack.getCount()) {
				return ItemStack.EMPTY;
			}

			slot.onTakeItem(player, stack_1);
		}

		return stack;
	}
}
