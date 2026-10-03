/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class cezd
extends cezg {
    public int _a;

    public cezd() {
    }

    public cezd(int n) {
        this._a = n;
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72477_a(this);
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
    public int func_73284_a() {
        return 4;
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        return true;
    }

    @Override
    public boolean func_73277_a_() {
        return true;
    }
}

