/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.lib.vec.Rectangle4i;
import codechicken.nei.ItemPanelStack;
import codechicken.nei.NEICPH;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIController;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.Widget;
import codechicken.nei.api.GuiInfo;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.forge.GuiContainerManager;
import codechicken.nei.recipe.GuiCraftingRecipe;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ItemPanel
extends Widget {
    public static ArrayList<ItemPanelObject> visibleitems = new ArrayList();
    public ItemStack draggedStack;
    public int mouseDownSlot = -1;
    private int marginLeft;
    private int marginTop;
    private int rows;
    private int columns;
    private boolean[] validSlotMap;
    private int firstIndex;
    private int itemsPerPage;
    private int page;
    private int numPages;

    @Override
    public void resize() {
        this.marginLeft = this.x + this.width % 18 / 2;
        this.marginTop = this.y + this.height % 18 / 2;
        this.columns = this.width / 18;
        this.rows = this.height / 18;
        this.calculatePage();
        this.updateValidSlots();
    }

    private void calculatePage() {
        this.numPages = this.itemsPerPage == 0 ? 0 : (int)Math.ceil((float)visibleitems.size() / (float)this.itemsPerPage);
        if (this.firstIndex >= visibleitems.size()) {
            this.firstIndex = 0;
        }
        this.page = this.numPages == 0 ? 0 : this.firstIndex / this.itemsPerPage + 1;
    }

    private void updateValidSlots() {
        GuiContainer guiContainer = NEIClientUtils.getGuiContainer();
        this.validSlotMap = new boolean[this.rows * this.columns];
        this.itemsPerPage = 0;
        for (int i = 0; i < this.validSlotMap.length; ++i) {
            if (!this.slotValid(guiContainer, i)) continue;
            this.validSlotMap[i] = true;
            ++this.itemsPerPage;
        }
    }

    private boolean slotValid(GuiContainer guiContainer, int n) {
        Rectangle4i rectangle4i = this.getSlotRect(n);
        for (INEIGuiHandler iNEIGuiHandler : GuiInfo.guiHandlers) {
            if (!iNEIGuiHandler.hideItemPanelSlot(guiContainer, rectangle4i.x, rectangle4i.y, rectangle4i.w, rectangle4i.h)) continue;
            return false;
        }
        return true;
    }

    public Rectangle4i getSlotRect(int n) {
        return this.getSlotRect(n / this.columns, n % this.columns);
    }

    public Rectangle4i getSlotRect(int n, int n2) {
        return new Rectangle4i(this.marginLeft + n2 * 18, this.marginTop + n * 18, 18, 18);
    }

    @Override
    public void draw(int n, int n2) {
        if (this.itemsPerPage == 0) {
            return;
        }
        GuiContainerManager.enableMatrixStackLogging();
        int n3 = this.firstIndex;
        for (int i = 0; i < this.rows * this.columns && n3 < visibleitems.size(); ++i) {
            if (!this.validSlotMap[i]) continue;
            Rectangle4i rectangle4i = this.getSlotRect(i);
            if (rectangle4i.contains(n, n2)) {
                GuiDraw.drawRect(rectangle4i.x, rectangle4i.y, rectangle4i.w, rectangle4i.h, -296397483);
            }
            visibleitems.get(n3).draw(rectangle4i.x, rectangle4i.y);
            ++n3;
        }
        GuiContainerManager.disableMatrixStackLogging();
    }

    @Override
    public void postDraw(int n, int n2) {
        if (this.draggedStack != null) {
            GuiContainerManager.drawItems.zLevel += 100.0f;
            GuiContainerManager.drawItem(n - 8, n2 - 8, this.draggedStack);
            GuiContainerManager.drawItems.zLevel -= 100.0f;
        }
    }

    @Override
    public void mouseDragged(int n, int n2, int n3, long l) {
        if (this.mouseDownSlot >= 0 && this.draggedStack == null && NEIClientUtils.getHeldItem() == null) {
            ItemPanelSlot itemPanelSlot = this.getSlotMouseOver(n, n2);
            ItemStack itemStack = new ItemPanelSlot(this.mouseDownSlot).getItemStack();
            if (itemStack != null && (itemPanelSlot == null || itemPanelSlot.slotIndex != this.mouseDownSlot || l > 500L)) {
                int n4 = NEIClientConfig.getItemQuantity();
                if (n4 == 0) {
                    n4 = itemStack._d();
                }
                this.draggedStack = NEIServerUtils.copyStack(itemStack, n4);
            }
        }
    }

    @Override
    public boolean handleClick(int n, int n2, int n3) {
        if (this.handleDraggedClick(n, n2, n3)) {
            return true;
        }
        if (NEIClientUtils.getHeldItem() != null) {
            for (INEIGuiHandler iNEIGuiHandler : GuiInfo.guiHandlers) {
                if (!iNEIGuiHandler.hideItemPanelSlot(NEIClientUtils.getGuiContainer(), n, n2, 1, 1)) continue;
                return false;
            }
            if (NEIClientConfig.canPerformAction("delete") && NEIClientConfig.canPerformAction("item")) {
                if (n3 == 1) {
                    NEIClientUtils.decreaseSlotStack(-999);
                } else {
                    NEIClientUtils.deleteHeldItem();
                }
            } else {
                NEIClientUtils.dropHeldItem();
            }
            return true;
        }
        ItemPanelSlot itemPanelSlot = this.getSlotMouseOver(n, n2);
        if (itemPanelSlot != null) {
            if (n3 == 2) {
                ItemStack itemStack = itemPanelSlot.getItemStack();
                if (itemStack != null) {
                    int n4 = NEIClientConfig.getItemQuantity();
                    if (n4 == 0) {
                        n4 = itemStack._d();
                    }
                    this.draggedStack = NEIServerUtils.copyStack(itemStack, n4);
                }
            } else {
                this.mouseDownSlot = itemPanelSlot.slotIndex;
            }
            return true;
        }
        return false;
    }

    private boolean handleDraggedClick(int n, int n2, int n3) {
        if (this.draggedStack == null) {
            return false;
        }
        GuiContainer guiContainer = NEIClientUtils.getGuiContainer();
        boolean bl = false;
        for (INEIGuiHandler iNEIGuiHandler : GuiInfo.guiHandlers) {
            if (!iNEIGuiHandler.handleDragNDrop(guiContainer, n, n2, this.draggedStack, n3)) continue;
            bl = true;
            if (this.draggedStack._b != 0) continue;
            this.draggedStack = null;
            return true;
        }
        if (bl) {
            return true;
        }
        Slot slot = guiContainer.getSlotAtPosition(n, n2);
        if (slot != null && slot.isItemValid(this.draggedStack)) {
            if (NEIClientConfig.canPerformAction("item")) {
                int n4;
                int n5;
                int n6 = slot.getHasStack() ? slot.getStack()._b : 0;
                int n7 = n5 = n3 == 0 ? this.draggedStack._b : 1;
                if (slot.getHasStack() && !NEIServerUtils.areStacksSameType(this.draggedStack, slot.getStack())) {
                    n6 = 0;
                }
                if ((n4 = Math.min(n6 + n5, Math.min(slot.getSlotStackLimit(), this.draggedStack._d()))) > n6) {
                    NEIClientUtils.setSlotContents(slot.slotNumber, NEIServerUtils.copyStack(this.draggedStack, n4), true);
                    NEICPH.sendSpawnItem(NEIServerUtils.copyStack(this.draggedStack, n4), false, false);
                    this.draggedStack._b -= n4 - n6;
                }
                if (this.draggedStack._b == 0) {
                    this.draggedStack = null;
                }
            } else {
                this.draggedStack = null;
            }
        } else if (n < guiContainer.guiLeft || n2 < guiContainer.guiTop || n >= guiContainer.guiLeft + guiContainer.xSize || n2 >= guiContainer.guiTop + guiContainer.ySize) {
            this.draggedStack = null;
        }
        return true;
    }

    @Override
    public boolean handleClickExt(int n, int n2, int n3) {
        return this.handleDraggedClick(n, n2, n3);
    }

    @Override
    public void mouseUp(int n, int n2, int n3) {
        ItemPanelSlot itemPanelSlot = this.getSlotMouseOver(n, n2);
        if (itemPanelSlot != null && itemPanelSlot.slotIndex == this.mouseDownSlot && itemPanelSlot.getItemStack() != null && this.draggedStack == null) {
            ItemStack itemStack = itemPanelSlot.getItemStack();
            if (NEIController.manager.window instanceof GuiRecipe || !NEIClientConfig.canPerformAction("item")) {
                if (n3 == 0) {
                    GuiCraftingRecipe.openRecipeGui("item", itemStack);
                } else if (n3 == 1) {
                    GuiUsageRecipe.openRecipeGui("item", itemStack);
                }
                this.draggedStack = null;
                this.mouseDownSlot = -1;
                return;
            }
            NEIClientUtils.cheatItem(itemStack, n3, -1);
        }
        this.mouseDownSlot = -1;
    }

    @Override
    public boolean onMouseWheel(int n, int n2, int n3) {
        if (!this.contains(n2, n3)) {
            return false;
        }
        this.scroll(-n);
        return true;
    }

    @Override
    public boolean handleKeyPress(int n, char c) {
        if (n == NEIClientConfig.getKeyBinding("gui.next")) {
            this.scroll(1);
            return true;
        }
        if (n == NEIClientConfig.getKeyBinding("gui.prev")) {
            this.scroll(-1);
            return true;
        }
        return false;
    }

    @Override
    public ItemStack getStackMouseOver(int n, int n2) {
        ItemPanelSlot itemPanelSlot = this.getSlotMouseOver(n, n2);
        return itemPanelSlot == null ? null : itemPanelSlot.getItemStack();
    }

    public ItemPanelSlot getSlotMouseOver(int n, int n2) {
        int n3 = this.firstIndex;
        for (int i = 0; i < this.rows * this.columns && n3 < visibleitems.size(); ++i) {
            if (!this.validSlotMap[i]) continue;
            if (this.getSlotRect(i).contains(n, n2)) {
                return new ItemPanelSlot(n3);
            }
            ++n3;
        }
        return null;
    }

    @Override
    public List<String> handleTooltip(int n, int n2, List<String> list2) {
        if (this.getSlotMouseOver(n, n2) == null) {
            return list2;
        }
        return this.getSlotMouseOver((int)n, (int)n2).contents.handleTooltip(list2);
    }

    public void scroll(int n) {
        if (this.itemsPerPage != 0) {
            int n2 = this.firstIndex;
            this.firstIndex += n * this.itemsPerPage;
            if (this.firstIndex >= visibleitems.size()) {
                this.firstIndex = 0;
            }
            if (this.firstIndex < 0) {
                this.firstIndex = n2 > 0 ? 0 : (visibleitems.size() - 1) / this.itemsPerPage * this.itemsPerPage;
            }
            this.calculatePage();
        }
    }

    public int getPage() {
        return this.page;
    }

    public int getNumPages() {
        return this.numPages;
    }

    public static interface ItemPanelObject {
        public void draw(int var1, int var2);

        public List<String> handleTooltip(List<String> var1);
    }

    public class ItemPanelSlot {
        public ItemPanelObject contents;
        public int slotIndex;

        public ItemPanelSlot(int n) {
            this.contents = visibleitems.get(n);
            this.slotIndex = n;
        }

        public ItemStack getItemStack() {
            return this.contents instanceof ItemPanelStack ? ((ItemPanelStack)this.contents).item : null;
        }
    }
}

