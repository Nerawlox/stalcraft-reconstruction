/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.Button;
import codechicken.nei.Image;
import codechicken.nei.LayoutManager;
import codechicken.nei.LayoutStyleDefault;
import codechicken.nei.forge.GuiContainerManager;

public class LayoutStyleTMIOld
extends LayoutStyleDefault {
    public static final Image stateOff = new Image(48, 0, 8, 12);
    public static final Image stateOn = new Image(56, 0, 8, 12);
    public static final Image stateDisabled = new Image(64, 0, 8, 12);
    int stateButtonCount;
    int clickButtonCount;

    @Override
    public String getName() {
        return "oldtmi";
    }

    @Override
    public void init() {
        LayoutManager.delete.icon = new Image(24, 12, 12, 12);
        LayoutManager.gamemode.icons[0] = new Image(12, 12, 12, 12);
        LayoutManager.gamemode.icons[1] = new Image(36, 12, 12, 12);
        LayoutManager.gamemode.icons[2] = new Image(48, 12, 12, 12);
        LayoutManager.rain.icon = new Image(0, 12, 12, 12);
        LayoutManager.magnet.icon = new Image(60, 24, 12, 12);
        LayoutManager.timeButtons[0].icon = new Image(12, 24, 12, 12);
        LayoutManager.timeButtons[1].icon = new Image(0, 24, 12, 12);
        LayoutManager.timeButtons[2].icon = new Image(24, 24, 12, 12);
        LayoutManager.timeButtons[3].icon = new Image(36, 24, 12, 12);
        LayoutManager.heal.icon = new Image(48, 24, 12, 12);
        LayoutManager.dropDown.x = 93;
    }

    @Override
    public void reset() {
        this.clickButtonCount = 0;
        this.stateButtonCount = 0;
    }

    @Override
    public void layoutButton(Button button) {
        int n = 2;
        int n2 = 2;
        if ((button.state & 4) != 0) {
            button.x = n + this.stateButtonCount * 22;
            button.y = n2;
            ++this.stateButtonCount;
        } else {
            button.x = n + this.clickButtonCount % 4 * 22;
            button.y = n2 + (1 + this.clickButtonCount / 4) * 17;
            ++this.clickButtonCount;
        }
        button.height = 14;
        button.width = button.contentWidth() + 2;
        if ((button.state & 4) != 0) {
            button.width += LayoutStyleTMIOld.stateOff.width;
        }
    }

    @Override
    public void drawBackground(GuiContainerManager guiContainerManager) {
        if (this.clickButtonCount == 0 && this.stateButtonCount == 0) {
            return;
        }
        int n = Math.max(this.stateButtonCount, this.clickButtonCount);
        if (n > 4) {
            n = 4;
        }
        int n2 = this.clickButtonCount == 0 ? 1 : this.clickButtonCount / 4 + 2;
        GuiDraw.drawRect(0, 0, 2 + 22 * n, 1 + n2 * 17, -16777216);
    }

    @Override
    public void drawButton(Button button, int n, int n2) {
        int n3 = button.contentWidth();
        if ((button.state & 4) != 0) {
            n3 += LayoutStyleTMIOld.stateOff.width;
        }
        int n4 = button.x + (button.width - n3) / 2;
        int n5 = button.y + (button.height - 8) / 2;
        GuiDraw.drawRect(button.x, button.y, button.width, button.height, button.contains(n, n2) ? -297791480 : -301989888);
        Image image = button.getRenderIcon();
        if (image == null) {
            GuiDraw.drawString(button.getRenderLabel(), n4, n5, -1);
        } else {
            int n6 = button.y + (button.height - image.height) / 2;
            LayoutManager.drawIcon(n4, n6, image);
            if ((button.state & 3) == 2) {
                GuiDraw.drawRect(n4, n6, image.width, image.height, Integer.MIN_VALUE);
            }
            if ((button.state & 4) != 0) {
                Image image2 = (button.state & 3) == 1 ? stateOn : ((button.state & 3) == 2 ? stateDisabled : stateOff);
                LayoutManager.drawIcon(n4 + image.width, n6, image2);
            }
        }
    }

    @Override
    public boolean texturedButtons() {
        return false;
    }
}

