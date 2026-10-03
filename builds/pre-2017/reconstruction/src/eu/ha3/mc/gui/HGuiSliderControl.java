/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.gui;

import eu.ha3.mc.gui.HDisplayStringHolder;
import eu.ha3.mc.gui.HDisplayStringProvider;
import eu.ha3.mc.gui.HSliderListener;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import org.lwjgl.opengl.GL11;

public class HGuiSliderControl
extends GuiButton
implements HDisplayStringHolder {
    protected float value = 1.0f;
    protected boolean isBeingDragged = false;
    protected HSliderListener listener;
    private HDisplayStringProvider dsProvider;

    public HGuiSliderControl(int n, int n2, int n3, String string, float f) {
        this(n, n2, n3, 150, 20, string, f);
    }

    public HGuiSliderControl(int n, int n2, int n3, int n4, int n5, String string, float f) {
        super(n, n2, n3, n4, n5, string);
        this.value = f;
    }

    public void setListener(HSliderListener hSliderListener) {
        this.listener = hSliderListener;
    }

    @Override
    protected int getHoverState(boolean bl) {
        return 0;
    }

    @Override
    protected void mouseDragged(Minecraft minecraft, int n, int n2) {
        if (this.drawButton) {
            if (this.isBeingDragged) {
                float f = (float)(n - (this.xPosition + 4)) / (float)(this.width - 8);
                if (f < 0.0f) {
                    f = 0.0f;
                }
                if (f > 1.0f) {
                    f = 1.0f;
                }
                if (this.value != f) {
                    this.value = f;
                    this.listener.sliderValueChanged(this, f);
                }
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(this.xPosition + (int)(this.value * (float)(this.width - 8)), this.yPosition, 0, 66, 4, this.height);
            this.drawTexturedModalRect(this.xPosition + (int)(this.value * (float)(this.width - 8)) + 4, this.yPosition, 196, 66, 4, this.height);
        }
    }

    @Override
    public boolean mousePressed(Minecraft minecraft, int n, int n2) {
        if (super.mousePressed(minecraft, n, n2)) {
            float f = (float)(n - (this.xPosition + 4)) / (float)(this.width - 8);
            if (f < 0.0f) {
                f = 0.0f;
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            if (this.value != f) {
                this.value = f;
                this.listener.sliderValueChanged(this, f);
            }
            this.isBeingDragged = true;
            this.listener.sliderPressed(this);
            return true;
        }
        return false;
    }

    @Override
    public void mouseReleased(int n, int n2) {
        this.isBeingDragged = false;
        this.listener.sliderReleased(this);
    }

    @Override
    public void updateDisplayString() {
        if (this.dsProvider == null) {
            return;
        }
        this.displayString = this.dsProvider.provideDisplayString();
    }

    @Override
    public void setDisplayStringProvider(HDisplayStringProvider hDisplayStringProvider) {
        this.dsProvider = hDisplayStringProvider;
    }
}

