/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.gui;

import codechicken.core.gui.IGuiActionListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class GuiWidget
extends Gui {
    protected static final ResourceLocation guiTex = new ResourceLocation("textures/gui/widgets.png");
    public GuiScreen parentScreen;
    public TextureManager renderEngine;
    public FontRenderer fontRenderer;
    public int x;
    public int y;
    public int width;
    public int height;

    public GuiWidget(int n, int n2, int n3, int n4) {
        this.setSize(n, n2, n3, n4);
    }

    public void setSize(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
    }

    public boolean pointInside(int n, int n2) {
        return n >= this.x && n < this.x + this.width && n2 >= this.y && n2 < this.y + this.height;
    }

    public void sendAction(String string, Object ... objectArray) {
        GuiWidget.sendAction(this.parentScreen, string, objectArray);
    }

    public static void sendAction(GuiScreen guiScreen, String string, Object ... objectArray) {
        if (string != null && guiScreen instanceof IGuiActionListener) {
            ((IGuiActionListener)((Object)guiScreen)).actionPerformed(string, objectArray);
        }
    }

    public void mouseClicked(int n, int n2, int n3) {
    }

    public void mouseMovedOrUp(int n, int n2, int n3) {
    }

    public void mouseDragged(int n, int n2, int n3, long l) {
    }

    public void update() {
    }

    public void draw(int n, int n2, float f) {
    }

    public void keyTyped(char c, int n) {
    }

    public void mouseScrolled(int n, int n2, int n3) {
    }

    public void onAdded(GuiScreen guiScreen) {
        Minecraft minecraft = Minecraft._E();
        this.parentScreen = guiScreen;
        this.renderEngine = minecraft._h;
        this.fontRenderer = minecraft._z;
    }
}

