/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.qlgf;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.vecmath.Vector3f;

public class ofgy
extends qlgf {
    public static final int _a = 5;
    private static int _f = 0;
    private int _g = 0;
    private int _h;
    List<String> _b = new ArrayList<String>();
    List<String> _c = new ArrayList<String>();
    public Map<Integer, qlqj> _d = new HashMap<Integer, qlqj>();
    static final int _e = 600;

    public ofgy() {
    }

    @ezey(_a={eidj.FRONTEND, eidj.CLIENT})
    public ofgy(int n, List<String> list2, List<String> list3) {
        this._h = n;
        this._b.addAll(list2);
        this._c.addAll(list3);
    }

    public String _a() {
        return this._b.get(0);
    }

    public qlqj _a(String string, String string2, Vector3f vector3f) {
        qlqj qlqj2 = new qlqj(this._g++, string, vector3f, string2);
        this._d.put(qlqj2._a(), qlqj2);
        return qlqj2;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._b());
        ofgy.writeStringList(this._c(), dataOutput);
        ofgy.writeStringList(this._d(), dataOutput);
        dataOutput.writeInt(this._d.size());
        for (qlqj qlqj2 : this._d.values()) {
            qlqj2.write(dataOutput);
        }
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._h = dataInput.readInt();
        this._b.clear();
        this._b.addAll(ofgy.readStringList(dataInput));
        this._c.clear();
        this._c.addAll(ofgy.readStringList(dataInput));
        this._d = new HashMap<Integer, qlqj>();
        int n = dataInput.readInt();
        for (int i = 0; i < n; ++i) {
            qlqj qlqj2 = new qlqj();
            qlqj2.read(dataInput);
            this._d.put(qlqj2._a(), qlqj2);
        }
    }

    public int _b() {
        return this._h;
    }

    public List<String> _c() {
        return this._b;
    }

    public List<String> _d() {
        return this._c;
    }

    boolean _e() {
        return this._b.size() + this._c.size() < 5;
    }
}

