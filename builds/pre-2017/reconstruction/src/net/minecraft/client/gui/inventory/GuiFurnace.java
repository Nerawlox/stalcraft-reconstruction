/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiFurnace
extends GuiContainer {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/furnace.png");
    public TileEntityFurnace _b;

    public GuiFurnace(InventoryPlayer inventoryPlayer, TileEntityFurnace tileEntityFurnace) {
        super(new lplm(inventoryPlayer, tileEntityFurnace));
        this._b = tileEntityFurnace;
    }

    @Override
    public void drawGuiContainerForegroundLayer(int n, int n2) {
        String string = this._b.isInvNameLocalized() ? this._b.getInvName() : wpcz._a(this._b.getInvName());
        this.fontRenderer._b(string, this.xSize / 2 - this.fontRenderer._b(string) / 2, 6, 0x404040);
        this.fontRenderer._b(wpcz._a("container.inventory"), 8, this.ySize - 96 + 2, 0x404040);
    }

    @Override
    public void drawGuiContainerBackgroundLayer(float f, int n, int n2) {
        int n3;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc._R()._a(_a);
        int n4 = (this.width - this.xSize) / 2;
        int n5 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(n4, n5, 0, 0, this.xSize, this.ySize);
        if (this._b._a()) {
            n3 = this._b._c(12);
            this.drawTexturedModalRect(n4 + 56, n5 + 36 + 12 - n3, 176, 12 - n3, 14, n3 + 2);
        }
        n3 = this._b._b(24);
        this.drawTexturedModalRect(n4 + 79, n5 + 34, 176, 14, n3 + 1, 16);
    }
}

