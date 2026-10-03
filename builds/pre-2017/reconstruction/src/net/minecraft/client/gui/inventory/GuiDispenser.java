/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiDispenser
extends GuiContainer {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/dispenser.png");
    public TileEntityDispenser _b;

    public GuiDispenser(InventoryPlayer inventoryPlayer, TileEntityDispenser tileEntityDispenser) {
        super(new bbok(inventoryPlayer, tileEntityDispenser));
        this._b = tileEntityDispenser;
    }

    @Override
    public void drawGuiContainerForegroundLayer(int n, int n2) {
        String string = this._b.isInvNameLocalized() ? this._b.getInvName() : wpcz._a(this._b.getInvName());
        this.fontRenderer._b(string, this.xSize / 2 - this.fontRenderer._b(string) / 2, 6, 0x404040);
        this.fontRenderer._b(wpcz._a("container.inventory"), 8, this.ySize - 96 + 2, 0x404040);
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

