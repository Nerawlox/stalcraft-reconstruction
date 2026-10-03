/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiBrewingStand
extends GuiContainer {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/container/brewing_stand.png");
    public TileEntityBrewingStand _b;

    public GuiBrewingStand(InventoryPlayer inventoryPlayer, TileEntityBrewingStand tileEntityBrewingStand) {
        super(new tgbu(inventoryPlayer, tileEntityBrewingStand));
        this._b = tileEntityBrewingStand;
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
        int n5 = this._b._a();
        if (n5 > 0) {
            int n6 = (int)(28.0f * (1.0f - (float)n5 / 400.0f));
            if (n6 > 0) {
                this.drawTexturedModalRect(n3 + 97, n4 + 16, 176, 0, 9, n6);
            }
            int n7 = n5 / 2 % 7;
            switch (n7) {
                case 6: {
                    n6 = 0;
                    break;
                }
                case 5: {
                    n6 = 6;
                    break;
                }
                case 4: {
                    n6 = 11;
                    break;
                }
                case 3: {
                    n6 = 16;
                    break;
                }
                case 2: {
                    n6 = 20;
                    break;
                }
                case 1: {
                    n6 = 24;
                    break;
                }
                case 0: {
                    n6 = 29;
                }
            }
            if (n6 > 0) {
                this.drawTexturedModalRect(n3 + 65, n4 + 14 + 29 - n6, 185, 29 - n6, 12, n6);
            }
        }
    }
}

