/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Mouse
 */
package ru.stalcraft.client.clans;

import org.lwjgl.input.Mouse;
import ru.stalcraft.client.clans.GuiClans;
import ru.stalcraft.client.clans.GuiElement;
import ru.stalcraft.client.clans.IScrollable;

public class GuiElementSlider
extends GuiElement {
    private final GuiClans parent;
    private final IScrollable content;
    private final int x;
    private final int topY;
    private final int bottomY;
    private final int xSize;
    private final int ySize;
    float pos = 0.0f;
    private boolean mouseDown;
    private int pressY;

    public GuiElementSlider(GuiClans parent, IScrollable content, int x2, int topY, int bottomY, int xSize, int ySize) {
        this.parent = parent;
        this.content = content;
        this.x = x2;
        this.topY = topY;
        this.bottomY = bottomY;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    void draw(int x2, int y2) {
        if (this.enabled()) {
            if (this.mouseDown) {
                this.mouseMove(Mouse.getX(), atv.w().e - Mouse.getY());
            }
            atv.w().N.a(GuiClans.buttonsTexture);
            int curY = this.getCurrentY();
            if (this.mouseDown) {
                this.parent.drawTexturedModalRect(this.x, curY, 36, 240, this.xSize, this.ySize, 512);
            } else if (x2 >= this.x && x2 < this.x + this.xSize && y2 >= curY && y2 < curY + this.ySize) {
                this.parent.drawTexturedModalRect(this.x, curY, 18, 240, this.xSize, this.ySize, 512);
            } else {
                this.parent.drawTexturedModalRect(this.x, curY, 0, 240, this.xSize, this.ySize, 512);
            }
        }
    }

    void mouseClicked(int x2, int y2, int button) {
        if (button == 0 && this.enabled() && x2 >= this.x && x2 < this.x + this.xSize && y2 >= this.topY && y2 <= this.bottomY + this.ySize) {
            int currentY = this.getCurrentY();
            if (y2 >= currentY && y2 < currentY + this.ySize) {
                this.mouseDown = true;
                this.pressY = atv.w().e - Mouse.getY() - currentY;
            } else if (y2 < currentY) {
                this.scrollUp(10);
            } else {
                this.scrollDown(10);
            }
        }
    }

    void mouseUp(int x2, int y2) {
        this.mouseDown = false;
        this.pressY = 0;
    }

    void mouseMove(int x2, int y2) {
        if (this.enabled() && this.mouseDown) {
            this.pos = (float)(y2 - this.pressY - this.topY) / (float)(this.bottomY - this.topY);
            if (this.pos < 0.0f) {
                this.pos = 0.0f;
            }
            if (this.pos > 1.0f) {
                this.pos = 1.0f;
            }
        }
    }

    void keyTyped(char par1, int par2) {
        if (this.enabled()) {
            if (par2 == 201) {
                this.scrollUp(15);
            } else if (par2 == 209) {
                this.scrollDown(15);
            }
        }
    }

    private boolean enabled() {
        return this.content.getHeightPerPage() < this.content.getTotalHeight();
    }

    private int getCurrentY() {
        return !this.enabled() ? 0 : Math.min(this.topY + Math.round((float)(this.bottomY - this.topY) * this.pos), this.bottomY);
    }

    void updateScreen() {
        if (!this.enabled()) {
            this.pos = 0.0f;
        }
    }

    void scrollUp(int weight) {
        if (this.enabled() && this.content.getTotalHeight() > this.content.getHeightPerPage()) {
            this.pos = Math.max(0.0f, this.pos - (float)(this.content.getMinScroll() * weight) / (float)(this.content.getTotalHeight() - this.content.getHeightPerPage()));
        }
    }

    void scrollDown(int weight) {
        if (this.enabled() && this.content.getTotalHeight() > this.content.getHeightPerPage()) {
            this.pos = Math.min(1.0f, this.pos + (float)(this.content.getMinScroll() * weight) / (float)(this.content.getTotalHeight() - this.content.getHeightPerPage()));
        }
    }
}

