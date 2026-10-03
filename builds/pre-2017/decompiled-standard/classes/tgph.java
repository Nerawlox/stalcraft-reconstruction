/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class tgph
extends cezg {
    public static final String[] _a = new String[]{"tile.bed.notValid", null, null, "gameMode.changed"};
    public int _b;
    public int _c;

    public tgph() {
    }

    public tgph(int n, int n2) {
        this._b = n;
        this._c = n2;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._b = dataInput.readByte();
        this._c = dataInput.readByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._b);
        dataOutput.writeByte(this._c);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72488_a(this);
    }

    @Override
    public int func_73284_a() {
        return 2;
    }
}

