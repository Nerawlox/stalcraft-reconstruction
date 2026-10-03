/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class vmsc
extends cezg {
    public String _a;

    public vmsc() {
    }

    public vmsc(String string) {
        this._a = string;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = vmsc.func_73282_a(dataInput, 256);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        vmsc.func_73271_a(this._a, dataOutput);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72492_a(this);
    }

    @Override
    public int func_73284_a() {
        return this._a.length();
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

