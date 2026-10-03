/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.tdpx;
import noppes.npcs.client.gui.util.IButtonListener;
import org.lwjgl.opengl.GL11;

public class GuiMenuTopButton
extends GuiButton {
    public static final ResourceLocation resource = new ResourceLocation("customnpcs", "textures/gui/menutopbutton.png");
    public boolean active = false;
    public boolean hover = false;
    public boolean rotated = false;
    public IButtonListener listener;
    protected int height;

    public GuiMenuTopButton(int n, int n2, int n3, String string) {
        super(n, n2, n3, tdpx._a(string));
        this.width = Minecraft._E()._z._b(this.displayString) + 12;
        this.height = 20;
    }

    public GuiMenuTopButton(int n, GuiMenuTopButton guiMenuTopButton, String string) {
        this(n, guiMenuTopButton.xPosition + guiMenuTopButton.width, guiMenuTopButton.yPosition, string);
    }

    public GuiMenuTopButton(int n, GuiMenuTopButton guiMenuTopButton, String string, IButtonListener iButtonListener) {
        this(n, guiMenuTopButton, string);
        this.listener = iButtonListener;
    }

    @Override
    protected int getHoverState(boolean bl) {
        int n = 1;
        if (this.active) {
            n = 0;
        } else if (bl) {
            n = 2;
        }
        return n;
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (this.drawButton) {
            GL11.glPushMatrix();
            minecraft._h._a(resource);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            int n3 = this.height - (this.active ? 0 : 2);
            this.hover = n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + n3;
            int n4 = this.getHoverState(this.hover);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, n4 * 20, this.width / 2, n3);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, n4 * 20, this.width / 2, n3);
            this.mouseDragged(minecraft, n, n2);
            FontRenderer fontRenderer = minecraft._z;
            if (this.rotated) {
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            }
            if (this.active) {
                this.drawCenteredString(fontRenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (n3 - 8) / 2, 0xFFFFA0);
            } else if (this.hover) {
                this.drawCenteredString(fontRenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (n3 - 8) / 2, 0xFFFFA0);
            } else {
                this.drawCenteredString(fontRenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (n3 - 8) / 2, 0xE0E0E0);
            }
            GL11.glPopMatrix();
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
        boolean bl;
        boolean bl2 = bl = !this.active && this.drawButton && this.hover;
        if (bl && this.listener != null) {
            this.listener.actionPerformed(this);
            return false;
        }
        return bl;
    }

    public int getWidth() {
        return this.width;
    }
}

