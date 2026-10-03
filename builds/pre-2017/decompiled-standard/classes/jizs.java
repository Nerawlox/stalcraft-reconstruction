/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import net.minecraft.entity.EntityLivingBase;

public class jizs
implements Comparator {
    public EntityLivingBase _a;

    public jizs(EntityLivingBase entityLivingBase) {
        this._a = entityLivingBase;
    }

    public int _a(nvgj nvgj2, nvgj nvgj3) {
        double d;
        if (nvgj2.field_78927_l && !nvgj3.field_78927_l) {
            return 1;
        }
        if (nvgj3.field_78927_l && !nvgj2.field_78927_l) {
            return -1;
        }
        double d2 = nvgj2.func_78912_a(this._a);
        if (d2 < (d = (double)nvgj3.func_78912_a(this._a))) {
            return 1;
        }
        if (d2 > d) {
            return -1;
        }
        return nvgj2.field_78937_s < nvgj3.field_78937_s ? 1 : -1;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((nvgj)object, (nvgj)object2);
    }
}

