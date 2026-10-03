/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;

public class ixod
extends cezg {
    public int[] _a;

    public ixod() {
    }

    public ixod(int ... nArray) {
        this._a = nArray;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = new int[dataInput.readByte()];
        for (int i = 0; i < this._a.length; ++i) {
            this._a[i] = dataInput.readInt();
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeByte(this._a.length);
        for (int i = 0; i < this._a.length; ++i) {
            dataOutput.writeInt(this._a[i]);
        }
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72491_a(this);
    }

    @Override
    public int func_73284_a() {
        return 1 + this._a.length * 4;
    }
}

