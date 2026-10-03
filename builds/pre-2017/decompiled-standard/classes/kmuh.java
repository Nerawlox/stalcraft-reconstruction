/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;

public class kmuh
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public kmuh() {
    }

    public kmuh(Entity entity, int n, int n2, int n3, int n4) {
        this._e = n;
        this._b = n2;
        this._c = n3;
        this._d = n4;
        this._a = entity.field_70157_k;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._e = dataInput.readByte();
        this._b = dataInput.readInt();
        this._c = dataInput.readByte();
        this._d = dataInput.readInt();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._e);
        dataOutput.writeInt(this._b);
        dataOutput.writeByte(this._c);
        dataOutput.writeInt(this._d);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72460_a(this);
    }

    @Override
    public int func_73284_a() {
        return 14;
    }
}

