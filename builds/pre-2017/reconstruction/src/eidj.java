/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;

public class eidj {
    private String[] _a;
    private long _b;

    public eidj() {
        this._a = new String[0];
    }

    public eidj(long l, String ... stringArray) {
        this._a = stringArray;
        this._b = l;
    }

    public eidj(long l, List<String> list) {
        this(l, list.toArray(new String[list.size()]));
    }

    public String _a() {
        return kjui._a(this);
    }

    public String[] _b() {
        return this._a;
    }

    public void _a(String[] stringArray) {
        this._a = stringArray;
    }

    public long _c() {
        return this._b;
    }

    public void _a(long l) {
        this._b = l;
    }
}

