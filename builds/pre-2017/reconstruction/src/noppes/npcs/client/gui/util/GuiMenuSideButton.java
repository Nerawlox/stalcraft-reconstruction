/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.ResourceLocation;
import noppes.npcs.client.gui.util.GuiNpcButton;
import org.lwjgl.opengl.GL11;

public class GuiMenuSideButton
extends GuiNpcButton {
    public static final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/menusidebutton.png");
    public int xPosition;
    public int yPosition;
    public String displayString;
    public int id;
    public boolean active = false;
    public boolean drawButton = true;
    public boolean hover = false;
    protected int width = 200;
    protected int height = 20;

    public GuiMenuSideButton(int n, int n2, int n3, String string) {
        this(n, n2, n3, 200, 20, string);
    }

    public GuiMenuSideButton(int n, int n2, int n3, int n4, int n5, String string) {
        super(n, n2, n3, n4, n5, string);
        this.id = n;
        this.xPosition = n2;
        this.yPosition = n3;
        this.width = n4;
        this.height = n5;
        this.displayString = string;
    }

    @Override
    protected int getHoverState(boolean bl) {
        int n = 1;
        if (this.active) {
            n = 0;
        } else if (bl) {
            n = 1;
        }
        return n;
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (this.drawButton) {
            FontRenderer fontRenderer = minecraft._z;
            minecraft._h._a(resource);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            int n3 = this.width + (this.active ? 2 : 0);
            this.hover = n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + n3 && n2 < this.yPosition + this.height;
            int n4 = this.getHoverState(this.hover);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, n4 * 22, n3, this.height);
            this.mouseDragged(minecraft, n, n2);
            if (this.active) {
                this.drawCenteredString(fontRenderer, this.displayString, this.xPosition + n3 / 2, this.yPosition + (this.height - 8) / 2, 0xFFFFA0);
            } else if (this.hover) {
                this.drawCenteredString(fontRenderer, this.displayString, this.xPosition + n3 / 2, this.yPosition + (this.height - 8) / 2, 0xFFFFA0);
            } else {
                this.drawCenteredString(fontRenderer, this.displayString, this.xPosition + n3 / 2, this.yPosition + (this.height - 8) / 2, 0xE0E0E0);
            }
        }
    }

    @Override
    protected void mouseDragged(Minecraft minecraft, int n, int n2) {
    }

    @Override
    public void mouseReleased(int n, int n2) {
    }

    @Override
    public boolean mousePressed(Minecraft minecraft, int n, int n2) {
        return !this.active && this.drawButton && this.hover;
    }
}

