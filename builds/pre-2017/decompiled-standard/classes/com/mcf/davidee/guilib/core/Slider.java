/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.core;

import com.mcf.davidee.guilib.core.Widget;
import net.minecraft.util.sajh;

public abstract class Slider
extends Widget {
    protected SliderFormat format;
    protected float value;
    protected boolean dragging;

    public Slider(int n, int n2, float f, SliderFormat sliderFormat) {
        super(n, n2);
        this.value = sajh._a(f, 0.0f, 1.0f);
        this.format = sliderFormat;
    }

    @Override
    public boolean click(int n, int n2) {
        if (this.inBounds(n, n2)) {
            this.value = (float)(n - (this.x + 4)) / (float)(this.width - 8);
            this.value = sajh._a(this.value, 0.0f, 1.0f);
            this.dragging = true;
            return true;
        }
        return false;
    }

    @Override
    public void handleClick(int n, int n2) {
        this.value = (float)(n - (this.x + 4)) / (float)(this.width - 8);
        this.value = sajh._a(this.value, 0.0f, 1.0f);
        this.dragging = true;
    }

    @Override
    public void mouseReleased(int n, int n2) {
        this.dragging = false;
    }

    public float getValue() {
        return this.value;
    }

    public static interface SliderFormat {
        public String format(Slider var1);
    }
}

