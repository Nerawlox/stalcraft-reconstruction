/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anticheat.pidb;
import java.io.DataInput;
import java.io.DataOutput;

public class yvzj
extends cezg {
    public double _a;
    public double _b;
    public double _c;
    public double _d;
    public float _e;
    public float _f;
    public boolean _g;
    public boolean _h;
    public boolean _i;

    public yvzj() {
    }

    public yvzj(boolean bl) {
        this._g = bl;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72498_a(this);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._g = dataInput.readUnsignedByte() != 0;
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.write(this._g ? 1 : 0);
    }

    @Override
    public int func_73284_a() {
        return 1;
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        pidb._a(this, cezg2);
        return false;
    }
}

