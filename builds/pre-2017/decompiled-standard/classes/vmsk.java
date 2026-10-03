/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class vmsk
extends cezg {
    public int _a;
    public byte _b;
    public byte _c;
    public byte _d;
    public byte _e;
    public byte _f;
    public boolean _g;

    public vmsk() {
    }

    public vmsk(int n) {
        this._a = n;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72482_a(this);
    }

    @Override
    public int func_73284_a() {
        return 4;
    }

    @Override
    public String toString() {
        return "Entity_" + super.toString();
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        vmsk vmsk2 = (vmsk)cezg2;
        return vmsk2._a == this._a;
    }
}

