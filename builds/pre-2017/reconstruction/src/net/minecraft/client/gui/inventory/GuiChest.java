/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiChest
extends GuiContainer {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/generic_54.png");
    public IInventory _b;
    public IInventory _c;
    public int _d;

    public GuiChest(IInventory iInventory, IInventory iInventory2) {
        super(new wpkx(iInventory, iInventory2));
        this._b = iInventory;
        this._c = iInventory2;
        this.allowUserInput = false;
        int n = 222;
        int n2 = n - 108;
        this._d = iInventory2.getSizeInventory() / 9;
        this.ySize = n2 + this._d * 18;
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
        this.drawTexturedModalRect(n3, n4, 0, 0, this.xSize, this._d * 18 + 17);
        this.drawTexturedModalRect(n3, n4 + this._d * 18 + 17, 0, 126, this.xSize, 96);
    }
}

