/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.FastTransferManager;
import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.api.API;
import codechicken.nei.api.GuiInfo;
import codechicken.nei.api.IInfiniteItemHandler;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.ItemInfo;
import codechicken.nei.forge.GuiContainerManager;
import codechicken.nei.forge.IContainerInputHandler;
import codechicken.nei.forge.IContainerSlotClickHandler;
import java.awt.Point;
import java.util.LinkedList;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class NEIController
implements IContainerInputHandler,
IContainerSlotClickHandler {
    private static NEIController instance = new NEIController();
    ItemStack firstheld;
    public static GuiContainerManager manager;
    public static FastTransferManager fastTransferManager;
    public static boolean deleteMode;
    private static int pickedUpFromSlot;
    private static IInfiniteItemHandler heldStackInfinite;
    private static int selectedItem;

    public static void load() {
        GuiContainerManager.addSlotClickHandler(instance);
        GuiContainerManager.addInputHandler(instance);
    }

    public static void load(GuiContainer guiContainer) {
        manager = guiContainer.manager;
        deleteMode = false;
        GuiInfo.clearGuiHandlers();
        fastTransferManager = null;
        if (!NEIClientConfig.isEnabled()) {
            return;
        }
        fastTransferManager = new FastTransferManager();
        if (guiContainer instanceof INEIGuiHandler) {
            API.registerNEIGuiHandler((INEIGuiHandler)((Object)guiContainer));
        }
    }

    public static void updateUnlimitedItems(InventoryPlayer inventoryPlayer) {
        ItemStack itemStack;
        int n;
        if (!NEIClientConfig.canPerformAction("item") || !NEIClientConfig.hasSMPCounterPart()) {
            return;
        }
        LinkedList<ItemStack> linkedList = new LinkedList<ItemStack>();
        for (n = 0; n < inventoryPlayer.getSizeInventory(); ++n) {
            linkedList.add(NEIServerUtils.copyStack(inventoryPlayer.getStackInSlot(n)));
        }
        for (n = 0; n < inventoryPlayer.getSizeInventory(); ++n) {
            itemStack = inventoryPlayer.getStackInSlot(n);
            if (itemStack == null) continue;
            for (IInfiniteItemHandler iInfiniteItemHandler : ItemInfo.infiniteHandlers) {
                if (!iInfiniteItemHandler.canHandleItem(itemStack) || !iInfiniteItemHandler.isItemInfinite(itemStack)) continue;
                iInfiniteItemHandler.replenishInfiniteStack(inventoryPlayer, n);
            }
        }
        for (n = 0; n < inventoryPlayer.getSizeInventory(); ++n) {
            itemStack = inventoryPlayer.getStackInSlot(n);
            if (NEIServerUtils.areStacksIdentical((ItemStack)linkedList.get(n), itemStack)) continue;
            inventoryPlayer.setInventorySlotContents(n, (ItemStack)linkedList.get(n));
            NEIClientUtils.setSlotContents(n, itemStack, false);
        }
    }

    public static void processCreativeCycling(InventoryPlayer inventoryPlayer) {
        if (NEIClientConfig.invCreativeMode() && NEIClientUtils.controlKey() && selectedItem != inventoryPlayer._c) {
            if (inventoryPlayer._c == selectedItem + 1 || inventoryPlayer._c == 0 && selectedItem == 8) {
                NEICPH.sendCreativeScroll(1);
                inventoryPlayer._c = selectedItem;
            } else if (inventoryPlayer._c == selectedItem - 1 || inventoryPlayer._c == 8 && selectedItem == 0) {
                NEICPH.sendCreativeScroll(-1);
                inventoryPlayer._c = selectedItem;
            }
        }
        selectedItem = inventoryPlayer._c;
    }

    @Override
    public void beforeSlotClick(GuiContainer guiContainer, int n, int n2, Slot slot, int n3) {
        if (!NEIClientConfig.isEnabled()) {
            return;
        }
        this.firstheld = NEIClientUtils.getHeldItem();
    }

    @Override
    public boolean handleSlotClick(GuiContainer guiContainer, int n, int n2, Slot slot, int n3, boolean bl) {
        if (bl || !NEIClientConfig.isEnabled()) {
            return bl;
        }
        if (deleteMode && n >= 0 && slot != null) {
            if (NEIClientUtils.shiftKey() && n2 == 0) {
                ItemStack itemStack = slot.getStack();
                if (itemStack != null) {
                    NEIClientUtils.deleteItemsOfType(itemStack);
                }
            } else if (n2 == 1) {
                NEIClientUtils.decreaseSlotStack(slot.slotNumber);
            } else {
                NEIClientUtils.deleteSlotStack(slot.slotNumber);
            }
            return true;
        }
        if (n2 == 1 && slot instanceof pkzb) {
            for (int i = 0; i < 64; ++i) {
                guiContainer.sendMouseClick(slot, n, n2, 0);
            }
            return true;
        }
        if (n >= 0 && NEIClientUtils.shiftKey() && NEIClientUtils.getHeldItem() != null && !slot.getHasStack()) {
            ItemStack itemStack = NEIClientUtils.getHeldItem();
            guiContainer.sendMouseClick(slot, n, n2, 0);
            if (slot.isItemValid(itemStack) && !ItemInfo.fastTransferExemptions.contains(slot.getClass())) {
                fastTransferManager.performMassTransfer(guiContainer, pickedUpFromSlot, n, itemStack);
            }
            return true;
        }
        if (NEIClientUtils.controlKey() && slot != null && slot.getStack() != null && NEIClientConfig.canPerformAction("item") && slot.isItemValid(slot.getStack())) {
            NEIClientUtils.cheatItem(slot.getStack(), n2, 1);
            return true;
        }
        if (n == -999 && NEIClientUtils.shiftKey() && n2 == 0) {
            fastTransferManager.throwAll(guiContainer, pickedUpFromSlot);
            return true;
        }
        return false;
    }

    @Override
    public void afterSlotClick(GuiContainer guiContainer, int n, int n2, Slot slot, int n3) {
        if (!NEIClientConfig.isEnabled()) {
            return;
        }
        ItemStack itemStack = NEIClientUtils.getHeldItem();
        if (this.firstheld != itemStack) {
            pickedUpFromSlot = n;
        }
        if (NEIClientConfig.canPerformAction("item") && NEIClientConfig.hasSMPCounterPart()) {
            if (heldStackInfinite != null && slot != null && slot.inventory == NEIClientUtils.mc()._t.inventory) {
                ItemStack itemStack2 = slot.getStack();
                if (itemStack2 != null) {
                    heldStackInfinite.onPlaceInfinite(itemStack2);
                }
                NEIClientUtils.setSlotContents(n, itemStack2, true);
            }
            if (this.firstheld != itemStack) {
                heldStackInfinite = null;
            }
            if (this.firstheld != itemStack && itemStack != null) {
                for (IInfiniteItemHandler iInfiniteItemHandler : ItemInfo.infiniteHandlers) {
                    if (!iInfiniteItemHandler.canHandleItem(itemStack) || !iInfiniteItemHandler.isItemInfinite(itemStack)) continue;
                    iInfiniteItemHandler.onPickup(itemStack);
                    NEIClientUtils.setSlotContents(-999, itemStack, true);
                    heldStackInfinite = iInfiniteItemHandler;
                    break;
                }
            }
        }
    }

    @Override
    public boolean lastKeyTyped(GuiContainer guiContainer, char c, int n) {
        if (!NEIClientConfig.isEnabled()) {
            return false;
        }
        Slot slot = guiContainer.manager.getSlotMouseOver();
        if (slot == null) {
            return false;
        }
        int n2 = slot.slotNumber;
        if (n == NEIClientUtils.mc()._M.keyBindDrop._d && NEIClientUtils.shiftKey()) {
            FastTransferManager.clickSlot(guiContainer, n2);
            fastTransferManager.throwAll(guiContainer, n2);
            FastTransferManager.clickSlot(guiContainer, n2);
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseScrolled(GuiContainer guiContainer, int n, int n2, int n3) {
        if (!NEIClientConfig.isEnabled()) {
            return false;
        }
        Point point = GuiDraw.getMousePosition();
        Slot slot = NEIController.manager.window.getSlotAtPosition(point.x, point.y);
        if (slot != null && slot.getHasStack()) {
            if (n3 > 0) {
                fastTransferManager.transferItem(NEIController.manager.window, slot.slotNumber);
            } else {
                fastTransferManager.retrieveItem(NEIController.manager.window, slot.slotNumber);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean keyTyped(GuiContainer guiContainer, char c, int n) {
        return false;
    }

    @Override
    public boolean mouseClicked(GuiContainer guiContainer, int n, int n2, int n3) {
        return false;
    }

    @Override
    public void onKeyTyped(GuiContainer guiContainer, char c, int n) {
    }

    @Override
    public void onMouseClicked(GuiContainer guiContainer, int n, int n2, int n3) {
    }

    @Override
    public void onMouseDragged(GuiContainer guiContainer, int n, int n2, int n3, long l) {
    }

    @Override
    public void onMouseScrolled(GuiContainer guiContainer, int n, int n2, int n3) {
    }

    @Override
    public void onMouseUp(GuiContainer guiContainer, int n, int n2, int n3) {
    }
}

