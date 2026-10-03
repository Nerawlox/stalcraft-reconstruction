/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.vanilla.sliders;

import com.mcf.davidee.guilib.core.Slider;
import com.mcf.davidee.guilib.vanilla.SliderVanilla;
import net.minecraft.util.sajh;

public class IntSlider
extends SliderVanilla {
    protected final int minVal;
    protected final int maxVal;
    protected final String nameFormat;
    protected boolean hover;

    public IntSlider(int n, int n2, String string, int n3, int n4, int n5) {
        super(n, n2, IntSlider.getFloatValue(n3, n4, n5), null);
        this.format = new IntSliderFormat();
        this.nameFormat = string;
        this.minVal = n4;
        this.maxVal = n5;
    }

    public IntSlider(String string, int n, int n2, int n3) {
        this(150, 20, string, n, n2, n3);
    }

    @Override
    public void draw(int n, int n2) {
        this.hover = this.inBounds(n, n2);
        super.draw(n, n2);
    }

    @Override
    public boolean mouseWheel(int n) {
        if (this.hover && !this.dragging) {
            this.value = IntSlider.getFloatValue(this.getIntValue() + (int)Math.signum(n), this.minVal, this.maxVal);
            return true;
        }
        return false;
    }

    public static float getFloatValue(int n, int n2, int n3) {
        n = sajh._a(n, n2, n3);
        return (float)(n - n2) / (float)(n3 - n2);
    }

    public void setIntValue(int n) {
        this.value = sajh._a(IntSlider.getFloatValue(n, this.minVal, this.maxVal), 0.0f, 1.0f);
    }

    public int getIntValue() {
        return Math.round(this.value * (float)(this.maxVal - this.minVal) + (float)this.minVal);
    }

    protected class IntSliderFormat
    implements Slider.SliderFormat {
        protected IntSliderFormat() {
        }

        @Override
        public String format(Slider slider) {
            return String.format(IntSlider.this.nameFormat, IntSlider.this.getIntValue());
        }
    }
}

