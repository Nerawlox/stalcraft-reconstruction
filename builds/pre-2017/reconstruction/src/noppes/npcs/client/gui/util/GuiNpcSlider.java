/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlider;
import net.minecraft.client.settings.EnumOptions;
import noppes.npcs.client.gui.util.ISliderListener;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiNpcSlider
extends GuiSlider {
    private ISliderListener listener;

    public GuiNpcSlider(GuiScreen guiScreen, int n, int n2, int n3, EnumOptions enumOptions, String string, float f) {
        super(n, n2, n3, enumOptions, string, f);
        if (guiScreen instanceof ISliderListener) {
            this.listener = (ISliderListener)((Object)guiScreen);
        }
    }

    @Override
    protected void mouseDragged(Minecraft minecraft, int n, int n2) {
        if (this.drawButton) {
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.xPosition + 4)) / (float)(this.width - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                if (this.listener != null) {
                    this.listener.mouseDragged(this);
                }
                if (!Mouse.isButtonDown(0)) {
                    this.mouseReleased(0, 0);
                }
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)), this.yPosition, 0, 66, 4, 20);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
        }
    }

    @Override
    public boolean mousePressed(Minecraft minecraft, int n, int n2) {
        if (this.enabled && this.drawButton && n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height) {
            this.sliderValue = (float)(n - (this.xPosition + 4)) / (float)(this.width - 8);
            if (this.sliderValue < 0.0f) {
                this.sliderValue = 0.0f;
            }
            if (this.sliderValue > 1.0f) {
                this.sliderValue = 1.0f;
            }
            if (this.listener != null) {
                this.listener.mousePressed(this);
            }
            this.dragging = true;
            return true;
        }
        return false;
    }

    @Override
    public void mouseReleased(int n, int n2) {
        this.dragging = false;
        if (this.listener != null) {
            this.listener.mouseReleased(this);
        }
    }
}

