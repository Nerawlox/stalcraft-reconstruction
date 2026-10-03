/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

public class hbdx
implements Comparator<cvzo> {
    public int _a(cvzo cvzo2, cvzo cvzo3) {
        if (cvzo2 == null && cvzo3 == null) {
            return 0;
        }
        if (cvzo2 == null) {
            return 1;
        }
        if (cvzo3 == null) {
            return -1;
        }
        if (cvzo2._d == cvzo3._d) {
            return 0;
        }
        if (cvzo2._d > cvzo3._d) {
            return 1;
        }
        return -1;
    }

    @Override
    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((cvzo)object, (cvzo)object2);
    }
}

