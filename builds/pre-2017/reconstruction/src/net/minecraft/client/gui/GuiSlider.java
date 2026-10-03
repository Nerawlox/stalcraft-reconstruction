/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import gloomyfolken.mods.asm.GloomyHooks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.settings.EnumOptions;
import org.lwjgl.opengl.GL11;

public class GuiSlider
extends GuiButton {
    public float sliderValue = 1.0f;
    public boolean dragging;
    public EnumOptions idFloat;

    public GuiSlider(int n, int n2, int n3, EnumOptions enumOptions, String string, float f) {
        super(n, n2, n3, 150, 20, string);
        this.idFloat = enumOptions;
        this.sliderValue = f;
        GloomyHooks.onGuiSliderInit(this, n, n2, n3, enumOptions, string, f);
    }

    @Override
    public int getHoverState(boolean bl) {
        return 0;
    }

    @Override
    public void mouseDragged(Minecraft minecraft, int n, int n2) {
        if (!this.drawButton) {
            return;
        }
        if (this.dragging) {
            this.sliderValue = (float)(n - (this.xPosition + 4)) / (float)(this.width - 8);
            if (this.sliderValue < 0.0f) {
                this.sliderValue = 0.0f;
            }
            if (this.sliderValue > 1.0f) {
                this.sliderValue = 1.0f;
            }
            minecraft._M.setOptionFloatValue(this.idFloat, this.sliderValue);
            this.displayString = minecraft._M.getKeyBinding(this.idFloat);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)), this.yPosition, 0, 66, 4, 20);
        this.drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
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
            minecraft._M.setOptionFloatValue(this.idFloat, this.sliderValue);
            this.displayString = minecraft._M.getKeyBinding(this.idFloat);
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

