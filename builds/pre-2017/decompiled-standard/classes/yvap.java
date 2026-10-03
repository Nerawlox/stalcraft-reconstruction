/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;

public class yvap
implements Comparator {
    public final String _a;
    public final /* synthetic */ qnim _b;

    public yvap(qnim qnim2, String string) {
        this._b = qnim2;
        this._a = string;
    }

    public int _a(rqmh rqmh2, rqmh rqmh3) {
        if (rqmh2._e.equals(rqmh3._e)) {
            if (rqmh2._a < rqmh3._a) {
                return 1;
            }
            if (rqmh2._a > rqmh3._a) {
                return -1;
            }
            return 0;
        }
        if (rqmh2._e.equals(this._a)) {
            return -1;
        }
        if (rqmh3._e.equals(this._a)) {
            return 1;
        }
        if (rqmh2._d.equals("CLOSED") || rqmh3._d.equals("CLOSED")) {
            if (rqmh2._d.equals("CLOSED")) {
                return 1;
            }
            if (rqmh3._d.equals("CLOSED")) {
                return 0;
            }
        }
        if (rqmh2._a < rqmh3._a) {
            return 1;
        }
        if (rqmh2._a > rqmh3._a) {
            return -1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((rqmh)object, (rqmh)object2);
    }

    public /* synthetic */ yvap(qnim qnim2, String string, dyfm dyfm2) {
        this(qnim2, string);
    }
}

