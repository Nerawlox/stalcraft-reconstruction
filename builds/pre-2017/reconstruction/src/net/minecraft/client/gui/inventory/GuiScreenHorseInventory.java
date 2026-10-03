/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiScreenHorseInventory
extends GuiContainer {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/horse.png");
    public IInventory _b;
    public IInventory _c;
    public EntityHorse _d;
    public float _e;
    public float _f;

    public GuiScreenHorseInventory(IInventory iInventory, IInventory iInventory2, EntityHorse entityHorse) {
        super(new qnzl(iInventory, iInventory2, entityHorse));
        this._b = iInventory;
        this._c = iInventory2;
        this._d = entityHorse;
        this.allowUserInput = false;
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
        if (this._d.isChested()) {
            this.drawTexturedModalRect(n3 + 79, n4 + 17, 0, this.ySize, 90, 54);
        }
        if (this._d.func_110259_cr()) {
            this.drawTexturedModalRect(n3 + 7, n4 + 35, 0, this.ySize + 54, 18, 18);
        }
        cebg._a(n3 + 51, n4 + 60, 17, (float)(n3 + 51) - this._e, (float)(n4 + 75 - 50) - this._f, this._d);
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this._e = n;
        this._f = n2;
        super.drawScreen(n, n2, f);
    }
}

