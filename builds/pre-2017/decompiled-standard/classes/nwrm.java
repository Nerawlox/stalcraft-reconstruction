/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.client.xpzm;

public class nwrm
extends tydk {
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
    private boolean _o;
    private int[] _p;
    private int _q;
    private int _r;
    private int _s;
    private int _t;
    private long _u;
    private String _v;
    private String _w;
    private String _x;
    private String _y;
    private String _z;
    private String _A;
    private String _B;
    private ArrayList<String> _C;

    public nwrm _a(int n, boolean bl) {
        this._r = 0;
        this._s = n;
        this._o = bl;
        return this;
    }

    public nwrm _a(int[] nArray) {
        this._r = 2;
        this._p = nArray;
        return this;
    }

    public nwrm _c() {
        this._r = 9;
        return this;
    }

    public nwrm _a(String string, String string2, String string3, long l) {
        this._r = 3;
        this._v = string;
        this._w = string2;
        this._x = string3;
        this._u = l;
        return this;
    }

    public nwrm _b(int n, boolean bl) {
        this._r = 4;
        this._q = n;
        this._o = bl;
        return this;
    }

    public nwrm _a(int n) {
        this._r = 6;
        this._q = n;
        return this;
    }

    public nwrm _a(boolean bl) {
        this._r = bl ? 8 : 7;
        return this;
    }

    public nwrm _a(ArrayList<String> arrayList, int n, boolean bl) {
        this._r = 1;
        this._C = arrayList;
        this._t = n;
        this._o = bl;
        return this;
    }

    public nwrm _a(String string) {
        this._r = 10;
        this._A = string;
        return this;
    }

    public nwrm _b(String string) {
        this._r = 5;
        this._B = string;
        return this;
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._r = dataInput.readByte();
        int n = 0;
        switch (this._r) {
            case 0: {
                this._s = dataInput.readInt();
                this._o = dataInput.readBoolean();
                break;
            }
            case 2: {
                n = dataInput.readInt();
                this._p = new int[n];
                for (int i = 0; i < n; ++i) {
                    this._p[i] = dataInput.readInt();
                }
                break;
            }
            case 3: {
                this._v = dataInput.readUTF();
                this._w = dataInput.readUTF();
                this._x = dataInput.readUTF();
                this._u = dataInput.readLong();
                break;
            }
            case 6: {
                this._q = dataInput.readInt();
                break;
            }
            case 4: {
                this._q = dataInput.readInt();
                this._o = dataInput.readBoolean();
                break;
            }
            case 1: {
                n = dataInput.readInt();
                this._C = new ArrayList();
                for (int i = 0; i < n; ++i) {
                    this._C.add(dataInput.readUTF());
                }
                this._t = dataInput.readInt();
                this._o = dataInput.readBoolean();
                break;
            }
            case 10: {
                this._A = dataInput.readUTF();
                break;
            }
            case 5: {
                this._B = dataInput.readUTF();
            }
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this._r);
        switch (this._r) {
            case 0: {
                dataOutput.writeInt(this._s);
                dataOutput.writeBoolean(this._o);
                break;
            }
            case 2: {
                dataOutput.writeInt(this._p.length);
                for (int i = 0; i < this._p.length; ++i) {
                    dataOutput.writeInt(this._p[i]);
                }
                break;
            }
            case 3: {
                dataOutput.writeUTF(this._v);
                dataOutput.writeUTF(this._w);
                dataOutput.writeUTF(this._x);
                dataOutput.writeLong(this._u);
                break;
            }
            case 6: {
                dataOutput.writeInt(this._q);
                break;
            }
            case 4: {
                dataOutput.writeInt(this._q);
                dataOutput.writeBoolean(this._o);
                break;
            }
            case 1: {
                dataOutput.writeInt(this._C.size());
                for (String string : this._C) {
                    dataOutput.writeUTF(string);
                }
                dataOutput.writeInt(this._t);
                dataOutput.writeBoolean(this._o);
                break;
            }
            case 10: {
                dataOutput.writeUTF(this._A);
                break;
            }
            case 5: {
                dataOutput.writeUTF(this._B);
            }
        }
    }

    @Override
    public void _b() {
        gqjz gqjz2 = xpzm._E()._B;
        mcnh mcnh2 = null;
        oitm oitm2 = null;
        if (gqjz2 instanceof mcnh) {
            mcnh2 = (mcnh)gqjz2;
        } else if (gqjz2 instanceof oitm) {
            oitm2 = (oitm)gqjz2;
        }
        switch (this._r) {
            case 1: {
                if (mcnh2 == null) break;
                mcnh2._a(this._C, this._t, this._o);
                break;
            }
            case 5: {
                if (oitm2 == null) break;
                oitm2._b(this._B);
                break;
            }
            case 10: {
                if (!(gqjz2 instanceof ywry)) break;
                ((ywry)gqjz2)._a(this._A);
            }
        }
    }
}

