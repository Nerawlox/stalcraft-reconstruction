/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;

public class eifc
extends zwat {
    public static final byte _a = 0;
    public static final byte _b = 1;
    public static final byte _c = 2;
    public static final byte _d = 3;
    public static final byte _e = 4;
    public static final byte _f = 5;
    public byte _g;
    public String _h;
    public ArrayList<String> _i;
    public int _j;
    public int _k;
    public int _l;
    public int _m;
    public long _n;
    public long _o;
    public long _p;
    public long _q;
    public boolean _r;
    public String _s;
    public String _t;
    public String _u;
    public jgro _v;
    public boolean _w;
    public int _x;
    public String _y;

    public eifc(String string) {
        this._h = string;
    }

    public eifc _a(String string, jgro jgro2, int n, boolean bl, int n2) {
        this._g = (byte)2;
        this._u = string;
        this._l = n;
        this._v = jgro2;
        this._w = bl;
        this._x = n2;
        return this;
    }

    public eifc _a(long l, long l2, long l3, int n, String string, String string2) {
        this._g = 0;
        this._n = l;
        this._o = l2;
        this._p = l3;
        this._j = n;
        this._s = string;
        this._t = string2;
        return this;
    }

    public eifc _a(int n, long l) {
        this._g = 1;
        this._k = n;
        this._q = l;
        return this;
    }

    public eifc _a(ArrayList<String> arrayList, int n) {
        this._g = (byte)3;
        this._i = arrayList;
        this._m = n;
        return this;
    }

    public eifc _a(String string) {
        this._g = (byte)4;
        this._y = string;
        return this;
    }

    public eifc _a(int n) {
        this._g = (byte)5;
        this._k = n;
        return this;
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._g = dataInput.readByte();
        this._h = dataInput.readUTF();
        switch (this._g) {
            case 2: {
                this._l = dataInput.readInt();
                this._u = dataInput.readUTF();
                this._v = jgro.values()[dataInput.readInt()];
                this._w = dataInput.readBoolean();
                this._x = dataInput.readInt();
                break;
            }
            case 0: {
                this._n = dataInput.readLong();
                this._o = dataInput.readLong();
                this._p = dataInput.readLong();
                this._j = dataInput.readInt();
                this._s = dataInput.readUTF();
                this._t = dataInput.readUTF();
                break;
            }
            case 1: {
                this._k = dataInput.readInt();
                this._q = dataInput.readLong();
                break;
            }
            case 3: {
                int n = dataInput.readInt();
                this._i = new ArrayList();
                for (int i = 0; i < n; ++i) {
                    this._i.add(dataInput.readUTF());
                }
                this._m = dataInput.readInt();
                break;
            }
            case 4: {
                this._y = dataInput.readUTF();
                break;
            }
            case 5: {
                this._k = dataInput.readInt();
            }
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this._g);
        dataOutput.writeUTF(this._h);
        switch (this._g) {
            case 2: {
                dataOutput.writeInt(this._l);
                dataOutput.writeUTF(this._u);
                dataOutput.writeInt(this._v.ordinal());
                dataOutput.writeBoolean(this._w);
                dataOutput.writeInt(this._x);
                break;
            }
            case 0: {
                dataOutput.writeLong(this._n);
                dataOutput.writeLong(this._o);
                dataOutput.writeLong(this._p);
                dataOutput.writeInt(this._j);
                dataOutput.writeUTF(this._s);
                dataOutput.writeUTF(this._t);
                break;
            }
            case 1: {
                dataOutput.writeInt(this._k);
                dataOutput.writeLong(this._q);
                break;
            }
            case 3: {
                dataOutput.writeInt(this._i.size());
                for (int i = 0; i < this._i.size(); ++i) {
                    dataOutput.writeUTF(this._i.get(i));
                }
                dataOutput.writeInt(this._m);
                break;
            }
            case 4: {
                dataOutput.writeUTF(this._y);
                break;
            }
            case 5: {
                dataOutput.writeInt(this._k);
            }
        }
    }

    public eifc() {
    }
}

