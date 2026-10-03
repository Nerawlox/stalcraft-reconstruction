/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.gui.GuiDraw;
import codechicken.nei.Button;
import codechicken.nei.Image;
import codechicken.nei.LayoutManager;
import codechicken.nei.LayoutStyleDefault;
import codechicken.nei.NEIClientConfig;
import org.lwjgl.opengl.GL11;

public class LayoutStyleMinecraft
extends LayoutStyleDefault {
    int stateButtonCount;
    int clickButtonCount;

    @Override
    public String getName() {
        return "minecraft";
    }

    @Override
    public void init() {
        LayoutManager.delete.icon = new Image(144, 12, 12, 12);
        LayoutManager.gamemode.icons[0] = new Image(132, 12, 12, 12);
        LayoutManager.gamemode.icons[1] = new Image(156, 12, 12, 12);
        LayoutManager.gamemode.icons[2] = new Image(168, 12, 12, 12);
        LayoutManager.rain.icon = new Image(120, 12, 12, 12);
        LayoutManager.magnet.icon = new Image(180, 24, 12, 12);
        LayoutManager.timeButtons[0].icon = new Image(132, 24, 12, 12);
        LayoutManager.timeButtons[1].icon = new Image(120, 24, 12, 12);
        LayoutManager.timeButtons[2].icon = new Image(144, 24, 12, 12);
        LayoutManager.timeButtons[3].icon = new Image(156, 24, 12, 12);
        LayoutManager.heal.icon = new Image(168, 24, 12, 12);
        LayoutManager.dropDown.x = 90;
    }

    @Override
    public void reset() {
        this.clickButtonCount = 0;
        this.stateButtonCount = 0;
    }

    @Override
    public void layoutButton(Button button) {
        int n;
        boolean bl = NEIClientConfig.getBooleanSetting("options.edge-align buttons");
        int n2 = bl ? 0 : 6;
        int n3 = n = bl ? 0 : 3;
        if ((button.state & 4) != 0) {
            button.x = n2 + this.stateButtonCount * 20;
            button.y = n;
            ++this.stateButtonCount;
        } else {
            button.x = n2 + this.clickButtonCount % 4 * 20;
            button.y = n + (1 + this.clickButtonCount / 4) * 18;
            ++this.clickButtonCount;
        }
        button.height = 17;
        button.width = button.contentWidth() + 6;
    }

    @Override
    public void drawButton(Button button, int n, int n2) {
        GL11.glDisable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        int n3 = (button.state & 3) == 2 ? 0 : ((button.state & 4) == 0 && button.contains(n, n2) || (button.state & 3) == 1 ? 2 : 1);
        LayoutManager.drawButtonBackground(button.x, button.y, button.width, button.height, true, n3);
        Image image = button.getRenderIcon();
        if (image == null) {
            int n4 = n3 == 2 ? 0xFFFFA0 : (n3 == 0 ? 0x601010 : 0xE0E0E0);
            GuiDraw.drawStringC(button.getRenderLabel(), button.x + button.width / 2, button.y + (button.height - 8) / 2, n4);
        } else {
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            int n5 = button.x + (button.width - image.width) / 2;
            int n6 = button.y + (button.height - image.height) / 2;
            LayoutManager.drawIcon(n5, n6, image);
        }
    }

    @Override
    public boolean texturedButtons() {
        return true;
    }
}

