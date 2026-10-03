/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.client.clans;

import ru.stalcraft.client.clans.GuiClans;
import ru.stalcraft.client.clans.GuiElement;
import ru.stalcraft.client.clans.GuiElementSlider;

public class GuiElementScrollButton
extends GuiElement {
    private final GuiClans parent;
    private final GuiElementSlider scroll;
    private final ScrollButtonDirection direction;
    private final int x;
    private final int y;
    private final int xSize;
    private final int ySize;
    private int ticksUsed = -1;

    public GuiElementScrollButton(GuiClans parent, GuiElementSlider scroll, ScrollButtonDirection direction, int x2, int y2, int xSize, int ySize) {
        this.parent = parent;
        this.scroll = scroll;
        this.direction = direction;
        this.x = x2;
        this.y = y2;
        this.xSize = xSize;
        this.ySize = ySize;
    }

    void draw(int x2, int y2) {
        int yPosOnTexture;
        atv.w().N.a(GuiClans.buttonsTexture);
        int n2 = yPosOnTexture = this.direction == ScrollButtonDirection.TOP ? 270 : 290;
        if (this.ticksUsed >= 0) {
            this.parent.drawTexturedModalRect(this.x, this.y, 36, yPosOnTexture, this.xSize, this.ySize, 512);
        } else if (x2 >= this.x && x2 < this.x + this.xSize && y2 >= this.y && y2 < this.y + this.ySize) {
            this.parent.drawTexturedModalRect(this.x, this.y, 18, yPosOnTexture, this.xSize, this.ySize, 512);
        } else {
            this.parent.drawTexturedModalRect(this.x, this.y, 0, yPosOnTexture, this.xSize, this.ySize, 512);
        }
    }

    void mouseClicked(int x2, int y2, int button) {
        if (button == 0 && x2 >= this.x && x2 < this.x + this.xSize && y2 >= this.y && y2 < this.y + this.ySize) {
            this.scroll();
            this.ticksUsed = 0;
        }
    }

    void mouseUp(int x2, int y2) {
        this.ticksUsed = -1;
    }

    void updateScreen() {
        if (this.ticksUsed >= 0) {
            ++this.ticksUsed;
        }
        if (this.ticksUsed > 5) {
            this.scroll();
        }
    }

    private void scroll() {
        if (this.direction == ScrollButtonDirection.TOP) {
            this.scroll.scrollUp(1);
        } else if (this.direction == ScrollButtonDirection.BOTTOM) {
            this.scroll.scrollDown(1);
        }
    }

    static enum ScrollButtonDirection {
        TOP("TOP", 0),
        BOTTOM("BOTTOM", 1);

        private static final ScrollButtonDirection[] $VALUES;

        private ScrollButtonDirection(String var1, int var2) {
        }

        static {
            $VALUES = new ScrollButtonDirection[]{TOP, BOTTOM};
        }
    }
}

