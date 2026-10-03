/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public abstract class GuiSlot {
    public final Minecraft mc;
    public int width;
    public int height;
    public int top;
    public int bottom;
    public int right;
    public int left;
    public final int slotHeight;
    public int scrollUpButtonID;
    public int scrollDownButtonID;
    public int mouseX;
    public int mouseY;
    public float initialClickY = -2.0f;
    public float scrollMultiplier;
    public float amountScrolled;
    public int selectedElement = -1;
    public long lastClicked;
    public boolean showSelectionBox = true;
    public boolean field_77243_s;
    public int field_77242_t;

    public GuiSlot(Minecraft minecraft, int n, int n2, int n3, int n4, int n5) {
        this.mc = minecraft;
        this.width = n;
        this.height = n2;
        this.top = n3;
        this.bottom = n4;
        this.slotHeight = n5;
        this.left = 0;
        this.right = n;
    }

    public void func_77207_a(int n, int n2, int n3, int n4) {
        this.width = n;
        this.height = n2;
        this.top = n3;
        this.bottom = n4;
        this.left = 0;
        this.right = n;
    }

    public void setShowSelectionBox(boolean bl) {
        this.showSelectionBox = bl;
    }

    public void func_77223_a(boolean bl, int n) {
        this.field_77243_s = bl;
        this.field_77242_t = n;
        if (!bl) {
            this.field_77242_t = 0;
        }
    }

    public abstract int getSize();

    public abstract void elementClicked(int var1, boolean var2);

    public abstract boolean isSelected(int var1);

    public int getContentHeight() {
        return this.getSize() * this.slotHeight + this.field_77242_t;
    }

    public abstract void drawBackground();

    public abstract void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5);

    public void func_77222_a(int n, int n2, Tessellator tessellator) {
    }

    public void func_77224_a(int n, int n2) {
    }

    public void func_77215_b(int n, int n2) {
    }

    public int func_77210_c(int n, int n2) {
        int n3 = this.width / 2 - 110;
        int n4 = this.width / 2 + 110;
        int n5 = n2 - this.top - this.field_77242_t + (int)this.amountScrolled - 4;
        int n6 = n5 / this.slotHeight;
        return n >= n3 && n <= n4 && n6 >= 0 && n5 >= 0 && n6 < this.getSize() ? n6 : -1;
    }

    public void registerScrollButtons(int n, int n2) {
        this.scrollUpButtonID = n;
        this.scrollDownButtonID = n2;
    }

    public void bindAmountScrolled() {
        int n = this.func_77209_d();
        if (n < 0) {
            n /= 2;
        }
        if (this.amountScrolled < 0.0f) {
            this.amountScrolled = 0.0f;
        }
        if (this.amountScrolled > (float)n) {
            this.amountScrolled = n;
        }
    }

    public int func_77209_d() {
        return this.getContentHeight() - (this.bottom - this.top - 4);
    }

    public void func_77208_b(int n) {
        this.amountScrolled += (float)n;
        this.bindAmountScrolled();
        this.initialClickY = -2.0f;
    }

    public void actionPerformed(GuiButton guiButton) {
        if (guiButton.enabled) {
            if (guiButton.id == this.scrollUpButtonID) {
                this.amountScrolled -= (float)(this.slotHeight * 2 / 3);
                this.initialClickY = -2.0f;
                this.bindAmountScrolled();
            } else if (guiButton.id == this.scrollDownButtonID) {
                this.amountScrolled += (float)(this.slotHeight * 2 / 3);
                this.initialClickY = -2.0f;
                this.bindAmountScrolled();
            }
        }
    }

    public void drawScreen(int n, int n2, float f) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        int n9;
        int n10;
        this.mouseX = n;
        this.mouseY = n2;
        this.drawBackground();
        int n11 = this.getSize();
        int n12 = this.getScrollBarX();
        int n13 = n12 + 6;
        if (Mouse.isButtonDown(0)) {
            if (this.initialClickY == -1.0f) {
                n10 = 1;
                if (n2 >= this.top && n2 <= this.bottom) {
                    n9 = this.width / 2 - 110;
                    n8 = this.width / 2 + 110;
                    n7 = n2 - this.top - this.field_77242_t + (int)this.amountScrolled - 4;
                    n6 = n7 / this.slotHeight;
                    if (n >= n9 && n <= n8 && n6 >= 0 && n7 >= 0 && n6 < n11) {
                        n5 = n6 == this.selectedElement && Minecraft._M() - this.lastClicked < 250L ? 1 : 0;
                        this.elementClicked(n6, n5 != 0);
                        this.selectedElement = n6;
                        this.lastClicked = Minecraft._M();
                    } else if (n >= n9 && n <= n8 && n7 < 0) {
                        this.func_77224_a(n - n9, n2 - this.top + (int)this.amountScrolled - 4);
                        n10 = 0;
                    }
                    if (n >= n12 && n <= n13) {
                        this.scrollMultiplier = -1.0f;
                        n4 = this.func_77209_d();
                        if (n4 < 1) {
                            n4 = 1;
                        }
                        if ((n3 = (int)((float)((this.bottom - this.top) * (this.bottom - this.top)) / (float)this.getContentHeight())) < 32) {
                            n3 = 32;
                        }
                        if (n3 > this.bottom - this.top - 8) {
                            n3 = this.bottom - this.top - 8;
                        }
                        this.scrollMultiplier /= (float)(this.bottom - this.top - n3) / (float)n4;
                    } else {
                        this.scrollMultiplier = 1.0f;
                    }
                    this.initialClickY = n10 != 0 ? (float)n2 : -2.0f;
                } else {
                    this.initialClickY = -2.0f;
                }
            } else if (this.initialClickY >= 0.0f) {
                this.amountScrolled -= ((float)n2 - this.initialClickY) * this.scrollMultiplier;
                this.initialClickY = n2;
            }
        } else {
            while (!this.mc._M.touchscreen && Mouse.next()) {
                n10 = Mouse.getEventDWheel();
                if (n10 == 0) continue;
                if (n10 > 0) {
                    n10 = -1;
                } else if (n10 < 0) {
                    n10 = 1;
                }
                this.amountScrolled += (float)(n10 * this.slotHeight / 2);
            }
            this.initialClickY = -1.0f;
        }
        this.bindAmountScrolled();
        GL11.glDisable(2896);
        GL11.glDisable(2912);
        Tessellator tessellator = Tessellator.instance;
        this.drawContainerBackground(tessellator);
        n8 = this.width / 2 - 92 - 16;
        n7 = this.top + 4 - (int)this.amountScrolled;
        if (this.field_77243_s) {
            this.func_77222_a(n8, n7, tessellator);
        }
        for (n6 = 0; n6 < n11; ++n6) {
            n4 = n7 + n6 * this.slotHeight + this.field_77242_t;
            n3 = this.slotHeight - 4;
            if (n4 > this.bottom || n4 + n3 < this.top) continue;
            if (this.showSelectionBox && this.isSelected(n6)) {
                n9 = this.width / 2 - 110;
                n5 = this.width / 2 + 110;
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glDisable(3553);
                tessellator.startDrawingQuads();
                tessellator.setColorOpaque_I(0x808080);
                tessellator.addVertexWithUV(n9, n4 + n3 + 2, 0.0, 0.0, 1.0);
                tessellator.addVertexWithUV(n5, n4 + n3 + 2, 0.0, 1.0, 1.0);
                tessellator.addVertexWithUV(n5, n4 - 2, 0.0, 1.0, 0.0);
                tessellator.addVertexWithUV(n9, n4 - 2, 0.0, 0.0, 0.0);
                tessellator.setColorOpaque_I(0);
                tessellator.addVertexWithUV(n9 + 1, n4 + n3 + 1, 0.0, 0.0, 1.0);
                tessellator.addVertexWithUV(n5 - 1, n4 + n3 + 1, 0.0, 1.0, 1.0);
                tessellator.addVertexWithUV(n5 - 1, n4 - 1, 0.0, 1.0, 0.0);
                tessellator.addVertexWithUV(n9 + 1, n4 - 1, 0.0, 0.0, 0.0);
                tessellator.draw();
                GL11.glEnable(3553);
            }
            this.drawSlot(n6, n8, n4, n3, tessellator);
        }
        GL11.glDisable(2929);
        n5 = 4;
        this.overlayBackground(0, this.top, 255, 255);
        this.overlayBackground(this.bottom, this.height, 255, 255);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3008);
        GL11.glShadeModel(7425);
        GL11.glDisable(3553);
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0, 0);
        tessellator.addVertexWithUV(this.left, this.top + n5, 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV(this.right, this.top + n5, 0.0, 1.0, 1.0);
        tessellator.setColorRGBA_I(0, 255);
        tessellator.addVertexWithUV(this.right, this.top, 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV(this.left, this.top, 0.0, 0.0, 0.0);
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0, 255);
        tessellator.addVertexWithUV(this.left, this.bottom, 0.0, 0.0, 1.0);
        tessellator.addVertexWithUV(this.right, this.bottom, 0.0, 1.0, 1.0);
        tessellator.setColorRGBA_I(0, 0);
        tessellator.addVertexWithUV(this.right, this.bottom - n5, 0.0, 1.0, 0.0);
        tessellator.addVertexWithUV(this.left, this.bottom - n5, 0.0, 0.0, 0.0);
        tessellator.draw();
        n4 = this.func_77209_d();
        if (n4 > 0) {
            n3 = (this.bottom - this.top) * (this.bottom - this.top) / this.getContentHeight();
            if (n3 < 32) {
                n3 = 32;
            }
            if (n3 > this.bottom - this.top - 8) {
                n3 = this.bottom - this.top - 8;
            }
            if ((n9 = (int)this.amountScrolled * (this.bottom - this.top - n3) / n4 + this.top) < this.top) {
                n9 = this.top;
            }
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_I(0, 255);
            tessellator.addVertexWithUV(n12, this.bottom, 0.0, 0.0, 1.0);
            tessellator.addVertexWithUV(n13, this.bottom, 0.0, 1.0, 1.0);
            tessellator.addVertexWithUV(n13, this.top, 0.0, 1.0, 0.0);
            tessellator.addVertexWithUV(n12, this.top, 0.0, 0.0, 0.0);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_I(0x808080, 255);
            tessellator.addVertexWithUV(n12, n9 + n3, 0.0, 0.0, 1.0);
            tessellator.addVertexWithUV(n13, n9 + n3, 0.0, 1.0, 1.0);
            tessellator.addVertexWithUV(n13, n9, 0.0, 1.0, 0.0);
            tessellator.addVertexWithUV(n12, n9, 0.0, 0.0, 0.0);
            tessellator.draw();
            tessellator.startDrawingQuads();
            tessellator.setColorRGBA_I(0xC0C0C0, 255);
            tessellator.addVertexWithUV(n12, n9 + n3 - 1, 0.0, 0.0, 1.0);
            tessellator.addVertexWithUV(n13 - 1, n9 + n3 - 1, 0.0, 1.0, 1.0);
            tessellator.addVertexWithUV(n13 - 1, n9, 0.0, 1.0, 0.0);
            tessellator.addVertexWithUV(n12, n9, 0.0, 0.0, 0.0);
            tessellator.draw();
        }
        this.func_77215_b(n, n2);
        GL11.glEnable(3553);
        GL11.glShadeModel(7424);
        GL11.glEnable(3008);
        GL11.glDisable(3042);
    }

    public int getScrollBarX() {
        return this.width / 2 + 124;
    }

    public void overlayBackground(int n, int n2, int n3, int n4) {
        Tessellator tessellator = Tessellator.instance;
        this.mc._R()._a(Gui.optionsBackground);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f = 32.0f;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_I(0x404040, n4);
        tessellator.addVertexWithUV(0.0, n2, 0.0, 0.0, (float)n2 / f);
        tessellator.addVertexWithUV(this.width, n2, 0.0, (float)this.width / f, (float)n2 / f);
        tessellator.setColorRGBA_I(0x404040, n3);
        tessellator.addVertexWithUV(this.width, n, 0.0, (float)this.width / f, (float)n / f);
        tessellator.addVertexWithUV(0.0, n, 0.0, 0.0, (float)n / f);
        tessellator.draw();
    }

    public void drawContainerBackground(Tessellator tessellator) {
        this.mc._R()._a(Gui.optionsBackground);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        float f = 32.0f;
        tessellator.startDrawingQuads();
        tessellator.setColorOpaque_I(0x202020);
        tessellator.addVertexWithUV(this.left, this.bottom, 0.0, (float)this.left / f, (float)(this.bottom + (int)this.amountScrolled) / f);
        tessellator.addVertexWithUV(this.right, this.bottom, 0.0, (float)this.right / f, (float)(this.bottom + (int)this.amountScrolled) / f);
        tessellator.addVertexWithUV(this.right, this.top, 0.0, (float)this.right / f, (float)(this.top + (int)this.amountScrolled) / f);
        tessellator.addVertexWithUV(this.left, this.top, 0.0, (float)this.left / f, (float)(this.top + (int)this.amountScrolled) / f);
        tessellator.draw();
    }
}

