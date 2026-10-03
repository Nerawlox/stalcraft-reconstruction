/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiHopper
extends GuiContainer {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/hopper.png");
    public IInventory _b;
    public IInventory _c;

    public GuiHopper(InventoryPlayer inventoryPlayer, IInventory iInventory) {
        super(new xsns(inventoryPlayer, iInventory));
        this._b = inventoryPlayer;
        this._c = iInventory;
        this.allowUserInput = false;
        this.ySize = 133;
    }

    @Override
    public void drawGuiContainerForegroundLayer(int n, int n2) {
        this.fontRenderer._b(this._c.isInvNameLocalized() ? this._c.getInvName() : wpcz._a(this._c.getInvName()), 8, 6, 0x404040);
        this.fontRenderer._b(this._b.isInvNameLocalized() ? this._b.getInvName() : wpcz._a(this._b.getInvName()), 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(_a);
        int n3 = (this.width - this.xSize) / 2;
        int n4 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this.ySize);
    }
}

