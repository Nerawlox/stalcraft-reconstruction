/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.zwat;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;

public class piet
extends zwat {
    public static final byte _a = 0;
    public static final byte _b = 1;
    public static final byte _c = 2;
    public static final byte _d = 3;
    public static final byte _e = 4;
    public static final byte _f = 5;
    public static final byte _g = 6;
    public static final byte _h = 7;
    public static final byte _i = 8;
    public static final byte _j = 9;
    public static final byte _k = 10;
    public byte _l;
    public int[] _m;
    public int _n;
    public int _o;
    public String _p;
    public String _q;
    public String _r;
    public String _s;
    public String _t;
    public String _u;
    public String _v;
    public String _w;
    public int _x;
    public ArrayList<String> _y;
    public boolean _z;

    public piet(String string) {
        this._v = string;
    }

    public piet _a(String string, String string2, String string3, String string4) {
        this._l = (byte)4;
        this._q = string;
        this._r = string2;
        this._s = string3;
        this._p = string4;
        return this;
    }

    public piet _a(int n, boolean bl) {
        this._l = 0;
        this._o = n;
        this._z = bl;
        return this;
    }

    public piet _a(int[] nArray) {
        this._l = (byte)2;
        this._m = nArray;
        return this;
    }

    public piet _a_() {
        this._l = (byte)10;
        return this;
    }

    public piet _b(int n, boolean bl) {
        this._l = (byte)6;
        this._n = n;
        this._z = bl;
        return this;
    }

    public piet _a(int n) {
        this._l = (byte)8;
        this._n = n;
        return this;
    }

    public piet _a(ArrayList<String> arrayList, int n, boolean bl) {
        this._l = 1;
        this._y = arrayList;
        this._x = n;
        this._z = bl;
        return this;
    }

    public piet _a(String string) {
        this._l = (byte)3;
        this._u = string;
        return this;
    }

    public piet _a(String string, String string2) {
        this._l = (byte)5;
        this._w = string;
        this._u = string2;
        return this;
    }

    public piet _b(String string) {
        this._l = (byte)7;
        this._w = string;
        return this;
    }

    public piet _b(String string, String string2) {
        this._l = (byte)9;
        this._w = string;
        this._u = string2;
        return this;
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._l = dataInput.readByte();
        this._v = dataInput.readUTF();
        int n = 0;
        switch (this._l) {
            case 0: {
                this._o = dataInput.readInt();
                this._z = dataInput.readBoolean();
                break;
            }
            case 2: {
                n = dataInput.readInt();
                this._m = new int[n];
                for (int i = 0; i < n; ++i) {
                    this._m[i] = dataInput.readInt();
                }
                break;
            }
            case 4: {
                this._q = dataInput.readUTF();
                this._r = dataInput.readUTF();
                this._s = dataInput.readUTF();
                this._p = dataInput.readUTF();
                break;
            }
            case 8: {
                this._n = dataInput.readInt();
                break;
            }
            case 6: {
                this._n = dataInput.readInt();
                this._z = dataInput.readBoolean();
                break;
            }
            case 1: {
                n = dataInput.readInt();
                this._y = new ArrayList();
                for (int i = 0; i < n; ++i) {
                    this._y.add(dataInput.readUTF());
                }
                this._x = dataInput.readInt();
                this._z = dataInput.readBoolean();
                break;
            }
            case 3: {
                this._u = dataInput.readUTF();
                break;
            }
            case 5: 
            case 9: {
                this._w = dataInput.readUTF();
                this._u = dataInput.readUTF();
                break;
            }
            case 7: {
                this._w = dataInput.readUTF();
            }
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this._l);
        dataOutput.writeUTF(this._v);
        switch (this._l) {
            case 0: {
                dataOutput.writeInt(this._o);
                dataOutput.writeBoolean(this._z);
                break;
            }
            case 2: {
                dataOutput.writeInt(this._m.length);
                for (int i = 0; i < this._m.length; ++i) {
                    dataOutput.writeInt(this._m[i]);
                }
                break;
            }
            case 4: {
                dataOutput.writeUTF(this._q);
                dataOutput.writeUTF(this._r);
                dataOutput.writeUTF(this._s);
                dataOutput.writeUTF(this._p);
                break;
            }
            case 8: {
                dataOutput.writeInt(this._n);
                break;
            }
            case 6: {
                dataOutput.writeInt(this._n);
                dataOutput.writeBoolean(this._z);
                break;
            }
            case 1: {
                dataOutput.writeInt(this._y.size());
                for (String string : this._y) {
                    dataOutput.writeUTF(string);
                }
                dataOutput.writeInt(this._x);
                dataOutput.writeBoolean(this._z);
                break;
            }
            case 3: {
                dataOutput.writeUTF(this._u);
                break;
            }
            case 5: 
            case 9: {
                dataOutput.writeUTF(this._w);
                dataOutput.writeUTF(this._u);
                break;
            }
            case 7: {
                dataOutput.writeUTF(this._w);
            }
        }
    }

    public piet() {
    }
}

