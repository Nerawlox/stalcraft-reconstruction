/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ydgy
extends bawa {
    public final int _a;
    public bafe _b;
    private final Point _d;
    private final Dimension _e;
    private final Point _f;
    private final Point _g;
    public ResourceLocation _c;
    private boolean _h = true;
    private int _i = 15;

    public ydgy(int n, bafe bafe2, Point point, Dimension dimension, Point point2, Point point3, ResourceLocation resourceLocation) {
        this._a = n;
        this._b = bafe2;
        this._d = point;
        this._e = dimension;
        this._f = point2;
        this._g = point3;
        this._c = resourceLocation;
    }

    public void _a(int n, int n2, int n3) {
        if (n3 == 0 && this._b(n, n2)) {
            this._b._a(this);
        }
    }

    public void _a(int n, int n2) {
        xpzm._E()._h._a(this._c);
        boolean bl = this._b(n, n2);
        if (this._h == bl) {
            boolean bl2 = this._h = !this._h;
            if (!this._h) {
                xpzm._E()._N._a("stalker:hover", 1.0f, 1.0f);
            }
            this._i = 0;
        }
        ++this._i;
        float f = (float)this._i / 15.0f;
        Point point = this._h ? this._g : this._f;
        Point point2 = this._h ? this._f : this._g;
        this._a(point, 1.0f - f);
        this._a(point2, f);
    }

    private float _a() {
        return this._b.field_73881_g > 400 ? 0.5f : 0.25f;
    }

    public void _a(Point point, float f) {
        double d = 9.765625E-4;
        double d2 = 9.765625E-4;
        double d3 = this._a();
        int n = this._e.width;
        int n2 = this._e.height;
        int n3 = point.x;
        int n4 = point.y;
        double d4 = (double)this._b.field_73880_f - (double)this._e.width * d3;
        double d5 = (double)this._d.y * d3;
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78374_a(d4, d5 + (double)n2 * d3, this.field_73735_i, (double)n3 * d, (double)(n4 + n2) * d2);
        htvf2.func_78374_a(d4 + (double)n * d3, d5 + (double)n2 * d3, this.field_73735_i, (double)(n3 + n) * d, (double)(n4 + n2) * d2);
        htvf2.func_78374_a(d4 + (double)n * d3, d5, this.field_73735_i, (double)(n3 + n) * d, (double)n4 * d2);
        htvf2.func_78374_a(d4, d5, this.field_73735_i, (double)n3 * d, (double)n4 * d2);
        htvf2.func_78381_a();
    }

    private boolean _b(int n, int n2) {
        double d = this._a();
        double d2 = (double)this._b.field_73880_f - (double)(20 + this._e.width) * d;
        double d3 = (double)this._d.y * d;
        return (double)n >= d2 && (double)n < d2 + (double)this._e.width * d && (double)n2 >= d3 && (double)n2 < d3 + (double)this._e.height * d;
    }
}

