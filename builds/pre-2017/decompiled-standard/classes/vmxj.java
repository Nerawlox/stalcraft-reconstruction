/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

public final class vmxj
implements Comparator {
    public int _a(cwdc cwdc2, cwdc cwdc3) {
        if (cwdc2._b() > cwdc3._b()) {
            return 1;
        }
        if (cwdc2._b() < cwdc3._b()) {
            return -1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((cwdc)object, (cwdc)object2);
    }
}

