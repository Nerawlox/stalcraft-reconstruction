/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class ixmg
extends yvzj {
    public ixmg() {
        this._i = true;
    }

    public ixmg(float f, float f2, boolean bl) {
        this._e = f;
        this._f = f2;
        this._g = bl;
        this._i = true;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._e = dataInput.readFloat();
        this._f = dataInput.readFloat();
        super.func_73267_a(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
        super.func_73273_a(dataOutput);
    }

    @Override
    public int func_73284_a() {
        return 9;
    }
}

