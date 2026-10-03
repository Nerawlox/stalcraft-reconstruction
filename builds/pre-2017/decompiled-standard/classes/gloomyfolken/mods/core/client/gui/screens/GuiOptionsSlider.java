/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.screens;

import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

public class GuiOptionsSlider
extends jiok {
    public float sliderValue = 1.0f;
    public boolean dragging;
    private hbdd option;

    public GuiOptionsSlider(int n, int n2, int n3, String string, float f, hbdd hbdd2) {
        super(n, n2, n3, 150, 20, string);
        this.sliderValue = f;
        this.option = hbdd2;
    }

    @Override
    protected int func_73738_a(boolean bl) {
        return 0;
    }

    @Override
    protected void func_73739_b(xpzm xpzm2, int n, int n2) {
        if (this.field_73748_h) {
            if (this.dragging) {
                this.sliderValue = (float)(n - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
                if (this.sliderValue < 0.0f) {
                    this.sliderValue = 0.0f;
                }
                if (this.sliderValue > 1.0f) {
                    this.sliderValue = 1.0f;
                }
                this.option.onSliderChanged(this);
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.func_73729_b(this.field_73746_c + (int)(this.sliderValue * (float)(this.field_73747_a - 8)), this.field_73743_d, 0, 66, 4, 20);
            this.func_73729_b(this.field_73746_c + (int)(this.sliderValue * (float)(this.field_73747_a - 8)) + 4, this.field_73743_d, 196, 66, 4, 20);
        }
    }

    @Override
    public boolean func_73736_c(xpzm xpzm2, int n, int n2) {
        if (super.func_73736_c(xpzm2, n, n2)) {
            this.sliderValue = (float)(n - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
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
    public void func_73740_a(int n, int n2) {
        this.dragging = false;
    }
}

