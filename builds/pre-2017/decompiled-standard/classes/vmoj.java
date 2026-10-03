/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class vmoj
implements lpso {
    public final cvzo _a;
    public final List _b;

    public vmoj(cvzo cvzo2, List list2) {
        this._a = cvzo2;
        this._b = list2;
    }

    @Override
    public cvzo func_77571_b() {
        return this._a;
    }

    @Override
    public boolean func_77569_a(bsse bsse2, ozlu ozlu2) {
        ArrayList arrayList = new ArrayList(this._b);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                cvzo cvzo2 = bsse2.func_70463_b(j, i);
                if (cvzo2 == null) continue;
                boolean bl = false;
                for (cvzo cvzo3 : arrayList) {
                    if (cvzo2._d != cvzo3._d || cvzo3._j() != Short.MAX_VALUE && cvzo2._j() != cvzo3._j()) continue;
                    bl = true;
                    arrayList.remove(cvzo3);
                    break;
                }
                if (bl) continue;
                return false;
            }
        }
        return arrayList.isEmpty();
    }

    @Override
    public cvzo func_77572_b(bsse bsse2) {
        return this._a._l();
    }

    @Override
    public int func_77570_a() {
        return this._b.size();
    }
}

