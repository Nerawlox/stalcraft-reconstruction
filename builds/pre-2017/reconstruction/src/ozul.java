/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class ozul
extends tydk {
    public static final byte _a = 0;
    public static final byte _b = 1;
    public static final byte _c = 2;
    public static final byte _d = 3;
    public static final byte _e = 4;
    public static final byte _f = 5;
    private String _g;
    private ArrayList<String> _h;
    private int _i;
    private int _j;
    private long _k;
    private long _o;
    private long _p;
    private String _q;
    private String _r;
    private jgro _s;
    private int _t;
    private int _u;
    private boolean _v;
    private int _w;

    public ozul _a(String string, jgro jgro2, int n, boolean bl, int n2) {
        this._n = (byte)2;
        this._q = string;
        this._t = n;
        this._s = jgro2;
        this._v = bl;
        this._w = n2;
        return this;
    }

    public ozul _a(long l, long l2, int n, String string) {
        this._n = 0;
        this._o = l;
        this._p = l2;
        this._i = n;
        this._r = string;
        return this;
    }

    public ozul _a(int n, long l) {
        this._n = 1;
        this._j = n;
        this._k = l;
        return this;
    }

    public ozul _a(ArrayList<String> arrayList, int n) {
        this._n = (byte)3;
        this._h = arrayList;
        this._u = n;
        return this;
    }

    public ozul _a(int n) {
        this._n = (byte)4;
        this._j = n;
        return this;
    }

    public ozul _a(String string) {
        this._n = (byte)5;
        this._g = string;
        return this;
    }

    @Override
    public void read(DataInput dataInput) throws IOException {
        this._n = dataInput.readByte();
        switch (this._n) {
            case 2: {
                this._t = dataInput.readInt();
                this._q = dataInput.readUTF();
                this._s = jgro.values()[dataInput.readInt()];
                this._v = dataInput.readBoolean();
                this._w = dataInput.readInt();
                break;
            }
            case 0: {
                this._o = dataInput.readLong();
                this._p = dataInput.readLong();
                this._i = dataInput.readInt();
                this._r = dataInput.readUTF();
                break;
            }
            case 1: {
                this._j = dataInput.readInt();
                this._k = dataInput.readLong();
                break;
            }
            case 3: {
                int n = dataInput.readInt();
                this._h = new ArrayList();
                for (int i = 0; i < n; ++i) {
                    this._h.add(dataInput.readUTF());
                }
                this._u = dataInput.readInt();
                break;
            }
            case 5: {
                this._g = dataInput.readUTF();
                break;
            }
            case 4: {
                this._j = dataInput.readInt();
            }
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this._n);
        switch (this._n) {
            case 2: {
                dataOutput.writeInt(this._t);
                dataOutput.writeUTF(this._q);
                dataOutput.writeInt(this._s.ordinal());
                dataOutput.writeBoolean(this._v);
                dataOutput.writeInt(this._w);
                break;
            }
            case 0: {
                dataOutput.writeLong(this._o);
                dataOutput.writeLong(this._p);
                dataOutput.writeInt(this._i);
                dataOutput.writeUTF(this._r);
                break;
            }
            case 1: {
                dataOutput.writeInt(this._j);
                dataOutput.writeLong(this._k);
                break;
            }
            case 3: {
                dataOutput.writeInt(this._h.size());
                for (int i = 0; i < this._h.size(); ++i) {
                    dataOutput.writeUTF(this._h.get(i));
                }
                dataOutput.writeInt(this._u);
                break;
            }
            case 5: {
                dataOutput.writeUTF(this._g);
                break;
            }
            case 4: {
                dataOutput.writeInt(this._j);
            }
        }
    }

    @Override
    public void _b() {
        GuiScreen guiScreen = Minecraft._E()._B;
        wqly wqly2 = null;
        if (guiScreen instanceof wqly) {
            wqly2 = (wqly)guiScreen;
        }
        switch (this._n) {
            case 3: {
                if (this._h == null || wqly2 == null) break;
                wqly2._a(this._h, this._u);
                break;
            }
            case 5: {
                if (!(guiScreen instanceof ywry)) break;
                ((ywry)guiScreen)._a(this._g);
            }
        }
    }
}

