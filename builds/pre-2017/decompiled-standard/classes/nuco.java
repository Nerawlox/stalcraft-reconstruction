/*
 * Decompiled with CFR 0.152.
 */
public class nuco
implements Comparable<nuco> {
    public final int _a;
    float _b;

    public nuco() {
        this(0);
    }

    public nuco(int n) {
        this._a = n;
    }

    public int _a(nuco nuco2) {
        if (this._a > nuco2._a) {
            return 1;
        }
        if (this._a < nuco2._a) {
            return -1;
        }
        return 0;
    }

    public boolean _a(jywl.kjui kjui2) {
        return true;
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this._a((nuco)object);
    }
}

