/*
 * Decompiled with CFR 0.152.
 */
import java.util.Comparator;
import net.minecraft.client.mco.McoServer;

public class yvap
implements Comparator {
    public final String _a;
    public final /* synthetic */ qnim _b;

    public yvap(qnim qnim2, String string) {
        this._b = qnim2;
        this._a = string;
    }

    public int _a(McoServer mcoServer, McoServer mcoServer2) {
        if (mcoServer._e.equals(mcoServer2._e)) {
            if (mcoServer._a < mcoServer2._a) {
                return 1;
            }
            if (mcoServer._a > mcoServer2._a) {
                return -1;
            }
            return 0;
        }
        if (mcoServer._e.equals(this._a)) {
            return -1;
        }
        if (mcoServer2._e.equals(this._a)) {
            return 1;
        }
        if (mcoServer._d.equals("CLOSED") || mcoServer2._d.equals("CLOSED")) {
            if (mcoServer._d.equals("CLOSED")) {
                return 1;
            }
            if (mcoServer2._d.equals("CLOSED")) {
                return 0;
            }
        }
        if (mcoServer._a < mcoServer2._a) {
            return 1;
        }
        if (mcoServer._a > mcoServer2._a) {
            return -1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((McoServer)object, (McoServer)object2);
    }

    public /* synthetic */ yvap(qnim qnim2, String string, dyfm dyfm2) {
        this(qnim2, string);
    }
}

