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
import net.minecraft.entity.player.eidj;

public class NEIController
implements IContainerInputHandler,
IContainerSlotClickHandler {
    private static NEIController instance = new NEIController();
    cvzo firstheld;
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

    public static void load(zybc zybc2) {
        manager = zybc2.manager;
        deleteMode = false;
        GuiInfo.clearGuiHandlers();
        fastTransferManager = null;
        if (!NEIClientConfig.isEnabled()) {
            return;
        }
        fastTransferManager = new FastTransferManager();
        if (zybc2 instanceof INEIGuiHandler) {
            API.registerNEIGuiHandler((INEIGuiHandler)((Object)zybc2));
        }
    }

    public static void updateUnlimitedItems(eidj eidj2) {
        cvzo cvzo2;
        int n;
        if (!NEIClientConfig.canPerformAction("item") || !NEIClientConfig.hasSMPCounterPart()) {
            return;
        }
        LinkedList<cvzo> linkedList = new LinkedList<cvzo>();
        for (n = 0; n < eidj2.func_70302_i_(); ++n) {
            linkedList.add(NEIServerUtils.copyStack(eidj2.func_70301_a(n)));
        }
        for (n = 0; n < eidj2.func_70302_i_(); ++n) {
            cvzo2 = eidj2.func_70301_a(n);
            if (cvzo2 == null) continue;
            for (IInfiniteItemHandler iInfiniteItemHandler : ItemInfo.infiniteHandlers) {
                if (!iInfiniteItemHandler.canHandleItem(cvzo2) || !iInfiniteItemHandler.isItemInfinite(cvzo2)) continue;
                iInfiniteItemHandler.replenishInfiniteStack(eidj2, n);
            }
        }
        for (n = 0; n < eidj2.func_70302_i_(); ++n) {
            cvzo2 = eidj2.func_70301_a(n);
            if (NEIServerUtils.areStacksIdentical((cvzo)linkedList.get(n), cvzo2)) continue;
            eidj2.func_70299_a(n, (cvzo)linkedList.get(n));
            NEIClientUtils.setSlotContents(n, cvzo2, false);
        }
    }

    public static void processCreativeCycling(eidj eidj2) {
        if (NEIClientConfig.invCreativeMode() && NEIClientUtils.controlKey() && selectedItem != eidj2._c) {
            if (eidj2._c == selectedItem + 1 || eidj2._c == 0 && selectedItem == 8) {
                NEICPH.sendCreativeScroll(1);
                eidj2._c = selectedItem;
            } else if (eidj2._c == selectedItem - 1 || eidj2._c == 8 && selectedItem == 0) {
                NEICPH.sendCreativeScroll(-1);
                eidj2._c = selectedItem;
            }
        }
        selectedItem = eidj2._c;
    }

    @Override
    public void beforeSlotClick(zybc zybc2, int n, int n2, yeso yeso2, int n3) {
        if (!NEIClientConfig.isEnabled()) {
            return;
        }
        this.firstheld = NEIClientUtils.getHeldItem();
    }

    @Override
    public boolean handleSlotClick(zybc zybc2, int n, int n2, yeso yeso2, int n3, boolean bl) {
        if (bl || !NEIClientConfig.isEnabled()) {
            return bl;
        }
        if (deleteMode && n >= 0 && yeso2 != null) {
            if (NEIClientUtils.shiftKey() && n2 == 0) {
                cvzo cvzo2 = yeso2.func_75211_c();
                if (cvzo2 != null) {
                    NEIClientUtils.deleteItemsOfType(cvzo2);
                }
            } else if (n2 == 1) {
                NEIClientUtils.decreaseSlotStack(yeso2.field_75222_d);
            } else {
                NEIClientUtils.deleteSlotStack(yeso2.field_75222_d);
            }
            return true;
        }
        if (n2 == 1 && yeso2 instanceof pkzb) {
            for (int i = 0; i < 64; ++i) {
                zybc2.sendMouseClick(yeso2, n, n2, 0);
            }
            return true;
        }
        if (n >= 0 && NEIClientUtils.shiftKey() && NEIClientUtils.getHeldItem() != null && !yeso2.func_75216_d()) {
            cvzo cvzo3 = NEIClientUtils.getHeldItem();
            zybc2.sendMouseClick(yeso2, n, n2, 0);
            if (yeso2.func_75214_a(cvzo3) && !ItemInfo.fastTransferExemptions.contains(yeso2.getClass())) {
                fastTransferManager.performMassTransfer(zybc2, pickedUpFromSlot, n, cvzo3);
            }
            return true;
        }
        if (NEIClientUtils.controlKey() && yeso2 != null && yeso2.func_75211_c() != null && NEIClientConfig.canPerformAction("item") && yeso2.func_75214_a(yeso2.func_75211_c())) {
            NEIClientUtils.cheatItem(yeso2.func_75211_c(), n2, 1);
            return true;
        }
        if (n == -999 && NEIClientUtils.shiftKey() && n2 == 0) {
            fastTransferManager.throwAll(zybc2, pickedUpFromSlot);
            return true;
        }
        return false;
    }

    @Override
    public void afterSlotClick(zybc zybc2, int n, int n2, yeso yeso2, int n3) {
        if (!NEIClientConfig.isEnabled()) {
            return;
        }
        cvzo cvzo2 = NEIClientUtils.getHeldItem();
        if (this.firstheld != cvzo2) {
            pickedUpFromSlot = n;
        }
        if (NEIClientConfig.canPerformAction("item") && NEIClientConfig.hasSMPCounterPart()) {
            if (heldStackInfinite != null && yeso2 != null && yeso2.field_75224_c == NEIClientUtils.mc()._t.field_71071_by) {
                cvzo cvzo3 = yeso2.func_75211_c();
                if (cvzo3 != null) {
                    heldStackInfinite.onPlaceInfinite(cvzo3);
                }
                NEIClientUtils.setSlotContents(n, cvzo3, true);
            }
            if (this.firstheld != cvzo2) {
                heldStackInfinite = null;
            }
            if (this.firstheld != cvzo2 && cvzo2 != null) {
                for (IInfiniteItemHandler iInfiniteItemHandler : ItemInfo.infiniteHandlers) {
                    if (!iInfiniteItemHandler.canHandleItem(cvzo2) || !iInfiniteItemHandler.isItemInfinite(cvzo2)) continue;
                    iInfiniteItemHandler.onPickup(cvzo2);
                    NEIClientUtils.setSlotContents(-999, cvzo2, true);
                    heldStackInfinite = iInfiniteItemHandler;
                    break;
                }
            }
        }
    }

    @Override
    public boolean lastKeyTyped(zybc zybc2, char c, int n) {
        if (!NEIClientConfig.isEnabled()) {
            return false;
        }
        yeso yeso2 = zybc2.manager.getSlotMouseOver();
        if (yeso2 == null) {
            return false;
        }
        int n2 = yeso2.field_75222_d;
        if (n == NEIClientUtils.mc()._M.field_74316_C._d && NEIClientUtils.shiftKey()) {
            FastTransferManager.clickSlot(zybc2, n2);
            fastTransferManager.throwAll(zybc2, n2);
            FastTransferManager.clickSlot(zybc2, n2);
            return true;
        }
        return false;
    }

    @Override
    public boolean mouseScrolled(zybc zybc2, int n, int n2, int n3) {
        if (!NEIClientConfig.isEnabled()) {
            return false;
        }
        Point point = GuiDraw.getMousePosition();
        yeso yeso2 = NEIController.manager.window.func_74187_b(point.x, point.y);
        if (yeso2 != null && yeso2.func_75216_d()) {
            if (n3 > 0) {
                fastTransferManager.transferItem(NEIController.manager.window, yeso2.field_75222_d);
            } else {
                fastTransferManager.retrieveItem(NEIController.manager.window, yeso2.field_75222_d);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean keyTyped(zybc zybc2, char c, int n) {
        return false;
    }

    @Override
    public boolean mouseClicked(zybc zybc2, int n, int n2, int n3) {
        return false;
    }

    @Override
    public void onKeyTyped(zybc zybc2, char c, int n) {
    }

    @Override
    public void onMouseClicked(zybc zybc2, int n, int n2, int n3) {
    }

    @Override
    public void onMouseDragged(zybc zybc2, int n, int n2, int n3, long l) {
    }

    @Override
    public void onMouseScrolled(zybc zybc2, int n, int n2, int n3) {
    }

    @Override
    public void onMouseUp(zybc zybc2, int n, int n2, int n3) {
    }
}

