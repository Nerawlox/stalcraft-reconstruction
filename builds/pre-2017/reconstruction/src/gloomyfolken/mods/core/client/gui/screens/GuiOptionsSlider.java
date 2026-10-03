/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

public class GuiOptionsSlider
extends GuiButton {
    public float sliderValue = 1.0f;
    public boolean dragging;
    private hbdd option;

    public GuiOptionsSlider(int n, int n2, int n3, String string, float f, hbdd hbdd2) {
        super(n, n2, n3, 150, 20, string);
        this.sliderValue = f;
        this.option = hbdd2;
    }

    @Override
    protected int getHoverState(boolean bl) {
        return 0;
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
                this.option.onSliderChanged(this);
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)), this.yPosition, 0, 66, 4, 20);
            this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
        }
    }

    @Override
    public boolean mousePressed(Minecraft minecraft, int n, int n2) {
        if (super.mousePressed(minecraft, n, n2)) {
            this.sliderValue = (float)(n - (this.xPosition + 4)) / (float)(this.width - 8);
            if (this.sliderValue < 0.0f) {
                this.sliderValue = 0.0f;
            }
            if (this.sliderValue > 1.0f) {
                this.sliderValue = 1.0f;
            }
            this.option.onSliderChanged(this);
            this.dragging = true;
            return true;
        }
        return false;
    }

    @Override
    public void mouseReleased(int n, int n2) {
        this.dragging = false;
    }
}

