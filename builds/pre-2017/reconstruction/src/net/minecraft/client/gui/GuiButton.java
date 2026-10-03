/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiButton
extends Gui {
    public static final ResourceLocation buttonTextures = new ResourceLocation("textures/gui/widgets.png");
    public int width = 200;
    public int height = 20;
    public int xPosition;
    public int yPosition;
    public String displayString;
    public int id;
    public boolean enabled = true;
    public boolean drawButton = true;
    public boolean field_82253_i;

    public GuiButton(int n, int n2, int n3, String string) {
        this(n, n2, n3, 200, 20, string);
    }

    public GuiButton(int n, int n2, int n3, int n4, int n5, String string) {
        this.id = n;
        this.xPosition = n2;
        this.yPosition = n3;
        this.width = n4;
        this.height = n5;
        this.displayString = string;
    }

    public int getHoverState(boolean bl) {
        int n = 1;
        if (!this.enabled) {
            n = 0;
        } else if (bl) {
            n = 2;
        }
        return n;
    }

    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (!this.drawButton) {
            return;
        }
        FontRenderer fontRenderer = minecraft._z;
        minecraft._R()._a(buttonTextures);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_82253_i = n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height;
        int n3 = this.getHoverState(this.field_82253_i);
        this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + n3 * 20, this.width / 2, this.height);
        this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + n3 * 20, this.width / 2, this.height);
        this.mouseDragged(minecraft, n, n2);
        int n4 = 0xE0E0E0;
        if (!this.enabled) {
            n4 = -6250336;
        } else if (this.field_82253_i) {
            n4 = 0xFFFFA0;
        }
        this.drawCenteredString(fontRenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, n4);
    }

    public void mouseDragged(Minecraft minecraft, int n, int n2) {
    }

    public void mouseReleased(int n, int n2) {
    }

    public boolean mousePressed(Minecraft minecraft, int n, int n2) {
        return this.enabled && this.drawButton && n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height;
    }

    public boolean func_82252_a() {
        return this.field_82253_i;
    }

    public void func_82251_b(int n, int n2) {
    }
}

