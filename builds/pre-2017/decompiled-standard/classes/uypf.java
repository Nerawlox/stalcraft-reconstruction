/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

public class uypf
implements Comparator<ncyh> {
    public int _a(ncyh ncyh2, ncyh ncyh3) {
        return Float.compare(ncyh3.distanceSq, ncyh2.distanceSq);
    }

    @Override
    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((ncyh)object, (ncyh)object2);
    }
}

