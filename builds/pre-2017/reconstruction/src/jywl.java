/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.lwjgl.util.vector.Vector3f;

public class jywl {
    public final int _a;
    public final int _b;
    final kjui[] _c;
    final kjui[] _d;
    private HashMap<String, kjui> _f;
    public ivtm _e;

    public jywl(kjui[] kjuiArray, kjui[] kjuiArray2) {
        this._a = kjuiArray.length;
        this._b = kjuiArray2.length;
        this._c = kjuiArray;
        this._d = kjuiArray2;
    }

    public HashMap<String, kjui> _a() {
        if (this._f == null) {
            this._f = new HashMap(this._a);
            for (kjui kjui2 : this._c) {
                this._f.put(kjui2._d, kjui2);
            }
        }
        return this._f;
    }

    public kjui _a(String string) {
        return this._a().get(string);
    }

    public kjui _a(int n) {
        return this._c[n];
    }

    public kjui _b(int n) {
        return this._d[n];
    }

    public static class kjui {
        public kjui _a;
        public List<kjui> _b = new ArrayList<kjui>();
        public int _c;
        public String _d;
        public Vector3f _e;
        public Vector3f _f;
    }
}

