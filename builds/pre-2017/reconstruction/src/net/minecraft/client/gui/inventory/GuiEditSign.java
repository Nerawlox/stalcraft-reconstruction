/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.inventory;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.ChatAllowedCharacters;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiEditSign
extends GuiScreen {
    public static final String _a = ChatAllowedCharacters._a;
    public String _b = "Edit sign message:";
    public TileEntitySign _c;
    public int _d;
    public int _e;
    public GuiButton _f;

    public GuiEditSign(TileEntitySign tileEntitySign) {
        this._c = tileEntitySign;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this._f = new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120, "Done");
        this.buttonList.add(this._f);
        this._c._a(false);
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        bscn bscn2 = this.mc._z();
        if (bscn2 != null) {
            bscn2._b(new Packet130UpdateSign(this._c.xCoord, this._c.yCoord, this._c.zCoord, this._c._a));
        }
        this._c._a(true);
    }

    @Override
    public void updateScreen() {
        ++this._d;
    }

    @Override
    public void actionPerformed(GuiButton guiButton) {
        if (!guiButton.enabled) {
            return;
        }
        if (guiButton.id == 0) {
            this._c.onInventoryChanged();
            this.mc._a((GuiScreen)null);
        }
    }

    @Override
    public void keyTyped(char c, int n) {
        if (n == 200) {
            this._e = this._e - 1 & 3;
        }
        if (n == 208 || n == 28 || n == 156) {
            this._e = this._e + 1 & 3;
        }
        if (n == 14 && this._c._a[this._e].length() > 0) {
            this._c._a[this._e] = this._c._a[this._e].substring(0, this._c._a[this._e].length() - 1);
        }
        if (_a.indexOf(c) >= 0 && this._c._a[this._e].length() < 15) {
            int n2 = this._e;
            this._c._a[n2] = this._c._a[n2] + c;
        }
        if (n == 1) {
            this.actionPerformed(this._f);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this._b, this.width / 2, 40, 0xFFFFFF);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.width / 2, 0.0f, 50.0f);
        float f2 = 93.75f;
        GL11.glScalef(-f2, -f2, -f2);
        GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        Block block = this._c.getBlockType();
        if (block == Block.signPost) {
            float f3 = (float)(this._c.getBlockMetadata() * 360) / 16.0f;
            GL11.glRotatef(f3, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, -1.0625f, 0.0f);
        } else {
            int n3 = this._c.getBlockMetadata();
            float f4 = 0.0f;
            if (n3 == 2) {
                f4 = 180.0f;
            }
            if (n3 == 4) {
                f4 = 90.0f;
            }
            if (n3 == 5) {
                f4 = -90.0f;
            }
            GL11.glRotatef(f4, 0.0f, 1.0f, 0.0f);
            GL11.glTranslatef(0.0f, -1.0625f, 0.0f);
        }
        if (this._d / 6 % 2 == 0) {
            this._c._b = this._e;
        }
        TileEntityRenderer._b._a(this._c, -0.5, -0.75, -0.5, 0.0f);
        this._c._b = -1;
        GL11.glPopMatrix();
        super.drawScreen(n, n2, f);
    }
}

