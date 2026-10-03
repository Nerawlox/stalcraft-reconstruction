/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.tupg;
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;

public class saoy
extends zwat {
    public ArrayList<kjui> _a;

    @Override
    @ezey(_a={eidj.CLIENT})
    public void read(DataInput dataInput) throws IOException {
        int n = dataInput.readInt();
        this._a = new ArrayList(n);
        for (int i = 0; i < n; ++i) {
            String string = dataInput.readUTF();
            String string2 = dataInput.readUTF();
            owak owak2 = owak.values()[dataInput.readByte()];
            int n2 = dataInput.readInt();
            int n3 = dataInput.readInt();
            tupg tupg2 = tupg.values()[dataInput.readByte()];
            int n4 = dataInput.readInt();
            this._a.add(new kjui(string, string2, owak2, n2, n3, tupg2, n4));
        }
    }

    @Override
    public void processClient(boolean bl) {
        yuch._a._a(this._a);
    }

    public static class kjui {
        public String _a;
        public String _b;
        public owak _c;
        public int _d;
        public int _e;
        public tupg _f;
        public int _g;

        public kjui(String string, String string2, owak owak2, int n, int n2, tupg tupg2, int n3) {
            this._a = string;
            this._b = string2;
            this._c = owak2;
            this._d = n;
            this._e = n2;
            this._f = tupg2;
            this._g = n3;
        }
    }
}

