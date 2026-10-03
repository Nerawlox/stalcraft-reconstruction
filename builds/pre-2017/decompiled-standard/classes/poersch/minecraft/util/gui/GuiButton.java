/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class GuiButton
extends jiok {
    protected String toolTipString;

    public GuiButton(int n, int n2, int n3, String string) {
        this(n, n2, n3, 200, 20, string);
    }

    public GuiButton(int n, int n2, int n3, int n4, int n5, String string) {
        super(n, n2, n3, n4, n5, string);
    }

    public int getWidth() {
        return this.field_73747_a;
    }

    public int getHeight() {
        return this.field_73745_b;
    }

    public GuiButton setToolTip(String string) {
        this.toolTipString = string;
        return this;
    }

    public String getToolTip() {
        return this.toolTipString;
    }

    public GuiButton mouseOver() {
        return this.field_73748_h && this.field_82253_i ? this : null;
    }

    @Override
    public void func_73737_a(xpzm xpzm2, int n, int n2) {
        if (this.field_73748_h) {
            qncw qncw2 = xpzm2._z;
            xpzm2._R()._a(jiok.field_110332_a);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_82253_i = n >= this.field_73746_c && n2 >= this.field_73743_d && n < this.field_73746_c + this.field_73747_a && n2 < this.field_73743_d + this.field_73745_b;
            int n3 = this.func_73738_a(this.field_82253_i);
            this.func_73729_b(this.field_73746_c, this.field_73743_d, 0, 46 + n3 * 20, this.field_73747_a / 2, this.field_73745_b);
            this.func_73729_b(this.field_73746_c + this.field_73747_a / 2, this.field_73743_d, 200 - this.field_73747_a / 2, 46 + n3 * 20, this.field_73747_a / 2, this.field_73745_b);
            this.func_73739_b(xpzm2, n, n2);
            int n4 = 0xE0E0E0;
            if (!this.field_73742_g) {
                n4 = -6250336;
            } else if (this.field_82253_i) {
                n4 = 0xFFFFA0;
            }
            int n5 = qncw2._b(this.field_73744_e);
            if (n5 > this.field_73747_a - 8) {
                float f = (float)(this.field_73747_a - 8) / (float)n5;
                GL11.glPushMatrix();
                GL11.glScalef(f, 1.0f, 1.0f);
                this.func_73732_a(qncw2, this.field_73744_e, (int)((float)(this.field_73746_c + this.field_73747_a / 2) / f), this.field_73743_d + (this.field_73745_b - 8) / 2, n4);
                GL11.glPopMatrix();
            } else {
                this.func_73732_a(qncw2, this.field_73744_e, this.field_73746_c + this.field_73747_a / 2, this.field_73743_d + (this.field_73745_b - 8) / 2, n4);
            }
        }
    }
}

