/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.opengl.GL11;
import poersch.minecraft.util.gui.GuiButton;

@SideOnly(value=Side.CLIENT)
public class GuiSlider
extends GuiButton {
    public String caption;
    public boolean dragging;
    protected float value;
    protected float sliderValue;
    protected float minValue;
    protected float maxValue;
    protected Float defaultValue;

    public GuiSlider(int n, int n2, int n3, String string, float f) {
        this(n, n2, n3, string, f, 0.0f, 1.0f, null);
    }

    public GuiSlider(int n, int n2, int n3, String string, float f, float f2, float f3, Float f4) {
        super(n, n2, n3, 150, 20, string);
        this.caption = string;
        this.minValue = f2;
        this.maxValue = f3;
        this.setValue(f);
        this.defaultValue = f4 != null ? Float.valueOf((f4.floatValue() - f2) / (f3 - f2)) : null;
    }

    public void setValue(float f) {
        this.value = f;
        this.sliderValue = (this.value - this.minValue) / (this.maxValue - this.minValue);
        this.updateCaption();
    }

    public String getValue() {
        return Float.toString(this.value);
    }

    protected void updateCaption() {
        this.displayString = this.caption + ": " + (Object)((Object)EnumChatFormatting._o) + (this.maxValue - this.minValue < 20.0f ? Double.valueOf((double)Math.round((double)this.value * 100.0) / 100.0) : String.valueOf(Math.round(this.value)));
    }

    @Override
    protected int getHoverState(boolean bl) {
        return 0;
    }

    @Override
    protected void mouseDragged(Minecraft minecraft, int n, int n2) {
        if (this.dragging) {
            this.sliderValue = (float)(n - (this.xPosition + 4)) / (float)(this.width - 8);
            if (this.sliderValue < 0.0f) {
                this.sliderValue = 0.0f;
            } else if (this.sliderValue > 1.0f) {
                this.sliderValue = 1.0f;
            }
            if (this.defaultValue != null && this.sliderValue > this.defaultValue.floatValue() - 0.05f && this.sliderValue < this.defaultValue.floatValue() + 0.05f) {
                this.sliderValue = this.defaultValue.floatValue();
            }
            this.value = this.minValue + (this.maxValue - this.minValue) * this.sliderValue;
            this.updateCaption();
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
            } else if (this.sliderValue > 1.0f) {
                this.sliderValue = 1.0f;
            }
            this.value = this.minValue + (this.maxValue - this.minValue) * this.sliderValue;
            this.updateCaption();
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

