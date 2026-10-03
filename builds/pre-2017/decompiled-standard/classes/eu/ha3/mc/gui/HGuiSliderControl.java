/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.mc.gui;

import eu.ha3.mc.gui.HDisplayStringHolder;
import eu.ha3.mc.gui.HDisplayStringProvider;
import eu.ha3.mc.gui.HSliderListener;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class HGuiSliderControl
extends jiok
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
    protected int func_73738_a(boolean bl) {
        return 0;
    }

    @Override
    protected void func_73739_b(xpzm xpzm2, int n, int n2) {
        if (this.field_73748_h) {
            if (this.isBeingDragged) {
                float f = (float)(n - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
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
            this.func_73729_b(this.field_73746_c + (int)(this.value * (float)(this.field_73747_a - 8)), this.field_73743_d, 0, 66, 4, this.field_73745_b);
            this.func_73729_b(this.field_73746_c + (int)(this.value * (float)(this.field_73747_a - 8)) + 4, this.field_73743_d, 196, 66, 4, this.field_73745_b);
        }
    }

    @Override
    public boolean func_73736_c(xpzm xpzm2, int n, int n2) {
        if (super.func_73736_c(xpzm2, n, n2)) {
            float f = (float)(n - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
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
    public void func_73740_a(int n, int n2) {
        this.isBeingDragged = false;
        this.listener.sliderReleased(this);
    }

    @Override
    public void updateDisplayString() {
        if (this.dsProvider == null) {
            return;
        }
        this.field_73744_e = this.dsProvider.provideDisplayString();
    }

    @Override
    public void setDisplayStringProvider(HDisplayStringProvider hDisplayStringProvider) {
        this.dsProvider = hDisplayStringProvider;
    }
}

