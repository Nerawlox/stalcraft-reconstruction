/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.network.FMLNetworkHandler;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class txpf
extends cezg {
    public int _a;
    public nwix _b;
    public boolean _c;
    public xtby _d;
    public int _e;
    public byte _f;
    public byte _g;
    public byte _h;
    public boolean _i;

    public txpf() {
        this._i = FMLNetworkHandler.vanillaLoginPacketCompatibility();
    }

    public txpf(int n, nwix nwix2, xtby xtby2, boolean bl, int n2, int n3, int n4, int n5) {
        this._a = n;
        this._b = nwix2;
        this._e = n2;
        this._f = (byte)n3;
        this._d = xtby2;
        this._g = (byte)n4;
        this._h = (byte)n5;
        this._c = bl;
        this._i = false;
    }

    @Override
    public void func_73267_a(DataInput dataInput) throws IOException {
        byte by;
        this._a = dataInput.readInt();
        String string = txpf.func_73282_a(dataInput, 16);
        this._b = nwix._a(string);
        if (this._b == null) {
            this._b = nwix._d;
        }
        this._c = ((by = dataInput.readByte()) & 8) == 8;
        int n = by & 0xFFFFFFF7;
        this._d = xtby._a(n);
        this._e = this._i ? (int)dataInput.readByte() : dataInput.readInt();
        this._f = dataInput.readByte();
        this._g = dataInput.readByte();
        this._h = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this._a);
        txpf.func_73271_a(this._b == null ? "" : this._b._a(), dataOutput);
        int n = this._d._a();
        if (this._c) {
            n |= 8;
        }
        dataOutput.writeByte(n);
        if (this._i) {
            dataOutput.writeByte(this._e);
        } else {
            dataOutput.writeInt(this._e);
        }
        dataOutput.writeByte(this._f);
        dataOutput.writeByte(this._g);
        dataOutput.writeByte(this._h);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72455_a(this);
    }

    @Override
    public int func_73284_a() {
        int n = 0;
        if (this._b != null) {
            n = this._b._a().length();
        }
        return 6 + 2 * n + 4 + 4 + 1 + 1 + 1 + (this._i ? 0 : 3);
    }
}

