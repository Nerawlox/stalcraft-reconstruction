/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

public class xsvg
implements Comparator {
    public final /* synthetic */ igjl _a;

    public xsvg(igjl igjl2) {
        this._a = igjl2;
    }

    public int _a(lpso lpso2, lpso lpso3) {
        if (lpso2 instanceof vmoj && lpso3 instanceof xbtf) {
            return 1;
        }
        if (lpso3 instanceof vmoj && lpso2 instanceof xbtf) {
            return -1;
        }
        if (lpso3.func_77570_a() < lpso2.func_77570_a()) {
            return -1;
        }
        if (lpso3.func_77570_a() > lpso2.func_77570_a()) {
            return 1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((lpso)object, (lpso)object2);
    }
}

