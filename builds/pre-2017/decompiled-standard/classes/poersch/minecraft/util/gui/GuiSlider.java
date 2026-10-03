/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;
import net.minecraft.util.ezfc;
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
        this.field_73744_e = this.caption + ": " + (Object)((Object)ezfc._o) + (this.maxValue - this.minValue < 20.0f ? Double.valueOf((double)Math.round((double)this.value * 100.0) / 100.0) : String.valueOf(Math.round(this.value)));
    }

    @Override
    protected int func_73738_a(boolean bl) {
        return 0;
    }

    @Override
    protected void func_73739_b(xpzm xpzm2, int n, int n2) {
        if (this.dragging) {
            this.sliderValue = (float)(n - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
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
        this.func_73729_b(this.field_73746_c + (int)(this.sliderValue * (float)(this.field_73747_a - 8)), this.field_73743_d, 0, 66, 4, 20);
        this.func_73729_b(this.field_73746_c + (int)(this.sliderValue * (float)(this.field_73747_a - 8)) + 4, this.field_73743_d, 196, 66, 4, 20);
    }

    @Override
    public boolean func_73736_c(xpzm xpzm2, int n, int n2) {
        if (super.func_73736_c(xpzm2, n, n2)) {
            this.sliderValue = (float)(n - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
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
    public void func_73740_a(int n, int n2) {
        this.dragging = false;
    }
}

