/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import net.minecraft.entity.Entity;

public class yvgb
implements Comparator {
    public double _a;
    public double _b;
    public double _c;

    public yvgb(Entity entity) {
        this._a = -entity.field_70165_t;
        this._b = -entity.field_70163_u;
        this._c = -entity.field_70161_v;
    }

    public int _a(nvgj nvgj2, nvgj nvgj3) {
        double d = (double)nvgj2.field_78925_n + this._a;
        double d2 = (double)nvgj2.field_78926_o + this._b;
        double d3 = (double)nvgj2.field_78940_p + this._c;
        double d4 = (double)nvgj3.field_78925_n + this._a;
        double d5 = (double)nvgj3.field_78926_o + this._b;
        double d6 = (double)nvgj3.field_78940_p + this._c;
        return (int)((d * d + d2 * d2 + d3 * d3 - (d4 * d4 + d5 * d5 + d6 * d6)) * 1024.0);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((nvgj)object, (nvgj)object2);
    }
}

