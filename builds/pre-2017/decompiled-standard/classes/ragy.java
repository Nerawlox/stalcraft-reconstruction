/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.player.ezey;

public class ragy
extends cezg {
    public boolean _a;
    public boolean _b;
    public boolean _c;
    public boolean _d;
    public float _e;
    public float _f;

    public ragy() {
    }

    public ragy(ezey ezey2) {
        this._a(ezey2._a);
        this._b(ezey2._b);
        this._c(ezey2._c);
        this._d(ezey2._d);
        this._a(ezey2._a());
        this._b(ezey2._b());
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        byte by = dataInput.readByte();
        this._a((by & 1) > 0);
        this._b((by & 2) > 0);
        this._c((by & 4) > 0);
        this._d((by & 8) > 0);
        this._a(dataInput.readFloat());
        this._b(dataInput.readFloat());
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        byte by = 0;
        if (this._a()) {
            by = (byte)(by | 1);
        }
        if (this._b()) {
            by = (byte)(by | 2);
        }
        if (this._c()) {
            by = (byte)(by | 4);
        }
        if (this._d()) {
            by = (byte)(by | 8);
        }
        dataOutput.writeByte(by);
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72471_a(this);
    }

    @Override
    public int func_73284_a() {
        return 2;
    }

    public boolean _a() {
        return this._a;
    }

    public void _a(boolean bl) {
        this._a = bl;
    }

    public boolean _b() {
        return this._b;
    }

    public void _b(boolean bl) {
        this._b = bl;
    }

    public boolean _c() {
        return this._c;
    }

    public void _c(boolean bl) {
        this._c = bl;
    }

    public boolean _d() {
        return this._d;
    }

    public void _d(boolean bl) {
        this._d = bl;
    }

    public float _e() {
        return this._e;
    }

    public void _a(float f) {
        this._e = f;
    }

    public float _f() {
        return this._f;
    }

    public void _b(float f) {
        this._f = f;
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        return true;
    }
}

