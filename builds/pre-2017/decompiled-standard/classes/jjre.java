/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class jjre
extends cezg {
    public int _a;

    public jjre() {
    }

    public jjre(int n) {
        this._a = n;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readShort();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeShort(this._a);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72502_a(this);
    }

    @Override
    public int func_73284_a() {
        return 2;
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

