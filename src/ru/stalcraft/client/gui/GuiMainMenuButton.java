/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 */
package ru.stalcraft.client.gui;

import ru.stalcraft.client.gui.GuiStalkerMenu;

public class GuiMainMenuButton
extends avk {
    public final int id;
    public GuiStalkerMenu parent;
    public int x;
    public int y;
    public int width;
    public int height;
    public int textureX;
    public int textureY;
    public bjo texture;
    public bjo highlightedTexture;

    public GuiMainMenuButton(int id, GuiStalkerMenu parent, int x2, int y2, int width, int height, int textureX, int textureY, bjo texture, bjo highlightedTexture) {
        this.id = id;
        this.parent = parent;
        this.x = x2;
        this.y = y2;
        this.width = width;
        this.height = height;
        this.textureX = textureX;
        this.textureY = textureY;
        this.texture = texture;
        this.highlightedTexture = highlightedTexture;
    }

    public void mouseClick(int mouseX, int mouseY, int button) {
        if (button == 0 && this.isMouseOver(mouseX, mouseY)) {
            this.parent.buttonClick(this);
        }
    }

    public void drawButton(int mouseX, int mouseY) {
        if (this.isMouseOver(mouseX, mouseY)) {
            atv.w().N.a(this.highlightedTexture);
        } else {
            atv.w().N.a(this.texture);
        }
        this.drawButtonScaled();
    }

    public void drawButtonScaled() {
        float f2 = 0.00390625f;
        float f1 = 0.00390625f;
        double scale = Math.min((float)this.parent.h / 500.0f, 1.0f);
        double x2 = (double)this.parent.g - (double)(20 + this.width) * scale;
        double y2 = (double)this.y * scale;
        bfq tessellator = bfq.a;
        tessellator.b();
        tessellator.a(x2, y2 + (double)this.height * scale, this.n, (float)(this.textureX + 0) * f2, (float)(this.textureY + this.height) * f1);
        tessellator.a(x2 + (double)this.width * scale, y2 + (double)this.height * scale, this.n, (float)(this.textureX + this.width) * f2, (float)(this.textureY + this.height) * f1);
        tessellator.a(x2 + (double)this.width * scale, y2, this.n, (float)(this.textureX + this.width) * f2, (float)this.textureY * f1);
        tessellator.a(x2, y2, this.n, (float)this.textureX * f2, (float)this.textureY * f1);
        tessellator.a();
    }

    private boolean isMouseOver(int mouseX, int mouseY) {
        double scale = Math.min((float)this.parent.h / 500.0f, 1.0f);
        double x2 = (double)this.parent.g - (double)(20 + this.width) * scale;
        double y2 = (double)this.y * scale;
        return (double)mouseX >= x2 && (double)mouseX < x2 + (double)this.width * scale && (double)mouseY >= y2 && (double)mouseY < y2 + (double)this.height * scale;
    }
}

