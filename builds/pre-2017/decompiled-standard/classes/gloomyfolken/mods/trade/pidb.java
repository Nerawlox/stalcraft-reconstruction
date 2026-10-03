/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.trade;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiContainerAdvanced;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;
import gloomyfolken.mods.money.zwat;
import gloomyfolken.mods.trade.qlgf;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@ezey(_a={eidj.CLIENT})
public class pidb
extends GuiContainerAdvanced {
    protected int _a = 176;
    protected int _b = 222;
    public qlgf _c = qlgf._a;
    public qlgf _d = qlgf._a;
    public long _e;
    public final String _f;
    public static final ResourceLocation _g = new ResourceLocation("trade", "textures/gui/trade.png");
    private McNumberField _h;
    private jiok _i;

    public pidb(jjgc jjgc2, String string) {
        super(jjgc2);
        this.field_73882_e = xpzm._E();
        this._f = string;
    }

    @Override
    public void func_73866_w_() {
        super.func_73866_w_();
        this._i = new jiok(0, this.field_73880_f / 2 - 50, this.field_73881_g / 2 + 101, 48, 20, "");
        this.field_73887_h.add(this._i);
        this._a();
        this.field_73887_h.add(new jiok(1, this.field_73880_f / 2 + 2, this.field_73881_g / 2 + 101, 48, 20, "\u041e\u0442\u043c\u0435\u043d\u0430"));
        this._h = new McNumberField(this, new Point(this.field_73880_f - this._a + 16, this.field_73881_g - this._b + 208), new Dimension(142, 22));
        this.addElement(this._h);
        this._h.setMaxStringLength(16);
        this._h.setMaxValue(zwat._a(this.field_73882_e._t)._a());
        this._h.setMinValue(0L);
    }

    private void _a() {
        if (this._c == qlgf._a) {
            this._i.field_73744_e = "\u041f\u0440\u0435\u0434\u043b\u043e\u0436\u0438\u0442\u044c";
            this._i.field_73742_g = true;
        }
        if (this._c == qlgf._b) {
            this._i.field_73742_g = this._d != qlgf._a;
            this._i.field_73744_e = "\u0421\u043e\u0433\u043b\u0430\u0441\u0438\u0442\u044c\u0441\u044f";
        }
        if (this._c == qlgf._c) {
            this._i.field_73742_g = false;
            this._i.field_73744_e = "\u0421\u043e\u0433\u043b\u0430\u0441\u0438\u0442\u044c\u0441\u044f";
        }
    }

    @Override
    protected void func_74185_a(float f, int n, int n2) {
        GL11.glDisable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        xpzm xpzm2 = xpzm._E();
        htou htou2 = new htou(xpzm2._M, xpzm2._n, xpzm2._o);
        xpzm2._h._a(_g);
        this.func_73729_b(htou2._a() / 2 - this._a / 2, htou2._b() / 2 - this._b / 2 - 8, 0, 0, this._a, this._b);
        this.func_73732_a(this.field_73886_k, "\u0412\u044b", this.field_73880_f / 2 - this._a / 2 + 43, this.field_73881_g / 2 - 114, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, this._f, this.field_73880_f / 2 - this._a / 2 + 133, this.field_73881_g / 2 - 114, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, this._e + " \u0440\u0443\u0431.", this.field_73880_f / 2 - this._a / 2 + 133, this.field_73881_g / 2 - this._b / 2 + 112, 0xFFFFFF);
        this.func_73732_a(this.field_73886_k, "\u0421\u0447\u0435\u0442: " + zwat._a(xpzm2._t)._b(), this.field_73880_f / 2 - this._a / 2 + 43, this.field_73881_g / 2 - this._b / 2 + 119, 0xFFFFFF);
        super.func_74185_a(f, n, n2);
    }

    @Override
    public void func_73873_v_() {
    }

    @Override
    public boolean func_73868_f() {
        return false;
    }

    @Override
    protected void func_73869_a(char c, int n) {
        long l = this._h.getValue();
        super.func_73869_a(c, n);
        long l2 = this._h.getValue();
        if (l2 != l) {
            new aoid(l2).sendToServer();
        }
    }

    @Override
    protected void func_73864_a(int n, int n2, int n3) {
        super.func_73864_a(n, n2, n3);
    }

    @Override
    protected void func_73875_a(jiok jiok2) {
        if (jiok2.field_73741_f == 0) {
            if (this._c == qlgf._a) {
                new ydlr(qlgf._b).sendToServer();
            } else if (this._c == qlgf._b) {
                new ydlr(qlgf._c).sendToServer();
            }
        } else {
            xpzm._E()._t.func_71053_j();
            this.field_73882_e._a((gqjz)null);
        }
    }

    @Override
    public void func_73863_a(int n, int n2, float f) {
        super.func_73863_a(n, n2, f);
        GL11.glDisable(2896);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override
    protected void func_74189_g(int n, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.field_73882_e._h._a(_g);
        GL11.glEnable(3042);
        this._a(8, -32, this._c);
        this._a(98, -32, this._d);
        GL11.glDisable(3042);
    }

    private void _a(int n, int n2, qlgf qlgf2) {
        this.func_73729_b(n, n2, 244, qlgf2.ordinal() * 12, 12, 12);
    }

    @Override
    public void func_73876_c() {
        super.func_73876_c();
        this._a();
    }
}

