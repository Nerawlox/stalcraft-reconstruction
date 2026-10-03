/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.tupg;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class jxsn {
    public final ugqi _a;
    public final String _b;
    public final String _c;
    public final String _d;
    public final long _e;
    public final tupg _f;
    @ezey(_a={eidj.CLIENT})
    private boolean _g;

    public jxsn(ugqi ugqi2, String string) {
        this(ugqi2, "", string, tupg._a);
    }

    public jxsn(ugqi ugqi2, String string, String string2, tupg tupg2) {
        this(ugqi2, "", string, string2, System.currentTimeMillis(), tupg2);
    }

    public jxsn(ugqi ugqi2, String string, String string2, String string3, long l, tupg tupg2) {
        this._a = ugqi2;
        this._b = string;
        this._c = string2;
        this._d = string3;
        this._e = l;
        this._f = tupg2;
    }

    public void _a(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a.ordinal());
        dataOutput.writeUTF(this._b);
        dataOutput.writeUTF(this._c);
        dataOutput.writeUTF(this._d);
        dataOutput.writeLong(this._e);
        dataOutput.writeByte(this._f.ordinal());
    }

    public static jxsn _a(DataInput dataInput) throws IOException {
        ugqi ugqi2 = ugqi.values()[dataInput.readInt()];
        String string = dataInput.readUTF();
        String string2 = dataInput.readUTF();
        String string3 = dataInput.readUTF();
        long l = dataInput.readLong();
        tupg tupg2 = tupg.values()[dataInput.readByte()];
        return new jxsn(ugqi2, string, string2, string3, l, tupg2);
    }

    public jxsn _a(String string) {
        return new jxsn(this._a, string, this._c, this._d, this._e, this._f);
    }

    @ezey(_a={eidj.CLIENT})
    public boolean _a() {
        return this._a == ugqi._a || this._a == ugqi._h || this._g;
    }

    @ezey(_a={eidj.CLIENT})
    public void _a(boolean bl) {
        this._g = bl;
    }

    public static int _b(String string) {
        int n = string.indexOf(" ");
        int n2 = string.indexOf(":");
        int n3 = -1;
        if (n > -1 && n2 > -1) {
            n3 = n < n2 ? n : n2;
        } else if (n < 0 && n2 > 0) {
            n3 = n2;
        } else if (n2 < 0 && n > 0) {
            n3 = n;
        } else {
            return -1;
        }
        return n3;
    }
}

