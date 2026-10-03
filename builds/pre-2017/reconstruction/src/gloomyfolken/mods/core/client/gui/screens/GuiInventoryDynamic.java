/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiInventoryDynamic
extends GuiContainer {
    private static final ResourceLocation field_110421_t = new ResourceLocation("textures/gui/container/generic_54.png");
    private IInventory playerInventory;
    private xqsf dynInventory;
    private int inventoryRows;
    private int numPages = 1;

    public GuiInventoryDynamic(tego tego2, int n) {
        super(tego2);
        this.playerInventory = tego2._b;
        this.dynInventory = tego2._a;
        this.numPages = n;
        this.allowUserInput = false;
        int n2 = 222;
        int n3 = n2 - 108;
        this.inventoryRows = 3;
        this.ySize = n3 + this.inventoryRows * 18;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(1, this.guiLeft + 5, this.guiTop - 20 - 5, 40, 20, wpcz._a("<")));
        this.buttonList.add(new GuiButton(2, this.guiLeft + this.xSize - 40 - 5, this.guiTop - 20 - 5, 40, 20, wpcz._a(">")));
        this.buttonList.add(new GuiButton(3, this.guiLeft + this.xSize / 2 - 40, this.guiTop - 20 - 5, 80, 20, wpcz._a("\u0421\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043f\u043e ID")));
        this.checkButtons();
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRenderer._b(this.dynInventory.isInvNameLocalized() ? this.dynInventory.getInvName() : wpcz._a(this.dynInventory.getInvName()), 8, 6, 0x404040);
        this.fontRenderer._b(this.playerInventory.isInvNameLocalized() ? this.playerInventory.getInvName() : wpcz._a(this.playerInventory.getInvName()), 8, this.ySize - 96 + 2, 0x404040);
        String string = "\u0421\u0442\u0440\u0430\u043d\u0438\u0446\u0430: " + this.getPage();
        this.fontRenderer._b(string, this.xSize - this.fontRenderer._b(string) - 8, 6, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(field_110421_t);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.drawTexturedModalRect(n3, n4 + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton.id == 1) {
            this.changeButton(0);
        } else if (guiButton.id == 2) {
            this.changeButton(1);
        } else if (guiButton.id == 3) {
            this.changeButton(2);
        }
    }

    private int getPage() {
        return this.getDynInv()._c();
    }

    private void setPage(int n) {
        this.getDynInv()._a(n);
    }

    private void removePageItems(int n) {
        int n2 = (n - 1) * this.dynInventory.getSizeInventory();
        for (int i = 0; i < this.dynInventory.getSizeInventory(); ++i) {
            if (!this.dynInventory._a().containsKey(n2 + i)) continue;
            this.dynInventory._a().remove(n2 + i);
        }
    }

    private void changeButton(int n) {
        if (n == 1) {
            if (this.getPage() < this.numPages) {
                this.setPage(this.getPage() + 1);
                this.removePageItems(this.getPage());
                new ncxz(n).sendToServer();
            }
        } else if (this.getPage() > 0 && n == 0) {
            this.setPage(this.getPage() - 1);
            this.removePageItems(this.getPage());
            new ncxz(n).sendToServer();
        } else if (n == 2) {
            this.getDynInv()._a();
            this.getDynInv()._b();
            new ncxz(n).sendToServer();
        }
        this.checkButtons();
    }

    private void checkButtons() {
        ((GuiButton)this.buttonList.get((int)0)).enabled = this.getPage() != 1;
        ((GuiButton)this.buttonList.get((int)1)).enabled = this.getPage() < this.numPages;
    }

    private tego getDynInv() {
        return (tego)this.inventorySlots;
    }
}

