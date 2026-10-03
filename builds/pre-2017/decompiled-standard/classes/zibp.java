/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class zibp
extends cezg {
    public int _a;
    public byte _b;

    public zibp() {
    }

    public zibp(int n, supr supr2) {
        this._a = n;
        this._b = (byte)(supr2._a() & 0xFF);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72452_a(this);
    }

    @Override
    public int func_73284_a() {
        return 5;
    }
}

