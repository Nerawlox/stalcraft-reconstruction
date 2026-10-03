/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client.gui.util;

import net.minecraft.client.settings.kjui;
import net.minecraft.client.xpzm;
import noppes.npcs.client.gui.util.ISliderListener;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiNpcSlider
extends dyaq {
    private ISliderListener listener;

    public GuiNpcSlider(gqjz gqjz2, int n, int n2, int n3, kjui kjui2, String string, float f) {
        super(n, n2, n3, kjui2, string, f);
        if (gqjz2 instanceof ISliderListener) {
            this.listener = (ISliderListener)((Object)gqjz2);
        }
    }

    @Override
    protected void func_73739_b(xpzm xpzm2, int n, int n2) {
        if (this.field_73748_h) {
            if (this.field_73752_k) {
                this.field_73751_j = (float)(n - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
                if (this.field_73751_j < 0.0f) {
                    this.field_73751_j = 0.0f;
                }
                if (this.field_73751_j > 1.0f) {
                    this.field_73751_j = 1.0f;
                }
                if (this.listener != null) {
                    this.listener.mouseDragged(this);
                }
                if (!Mouse.isButtonDown(0)) {
                    this.func_73740_a(0, 0);
                }
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.func_73729_b(this.field_73746_c + (int)(this.field_73751_j * (float)(this.field_73747_a - 8)), this.field_73743_d, 0, 66, 4, 20);
            this.func_73729_b(this.field_73746_c + (int)(this.field_73751_j * (float)(this.field_73747_a - 8)) + 4, this.field_73743_d, 196, 66, 4, 20);
        }
    }

    @Override
    public boolean func_73736_c(xpzm xpzm2, int n, int n2) {
        if (this.field_73742_g && this.field_73748_h && n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b) {
            this.field_73751_j = (float)(n - (this.field_73746_c + 4)) / (float)(this.field_73747_a - 8);
            if (this.field_73751_j < 0.0f) {
                this.field_73751_j = 0.0f;
            }
            if (this.field_73751_j > 1.0f) {
                this.field_73751_j = 1.0f;
            }
            if (this.listener != null) {
                this.listener.mousePressed(this);
            }
            this.field_73752_k = true;
            return true;
        }
        return false;
    }

    @Override
    public void func_73740_a(int n, int n2) {
        this.field_73752_k = false;
        if (this.listener != null) {
            this.listener.mouseReleased(this);
        }
    }
}

