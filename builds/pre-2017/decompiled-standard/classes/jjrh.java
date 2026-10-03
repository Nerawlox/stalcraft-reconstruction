/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;

public class jjrh
extends cezg {
    public int _a;
    public int _b;

    public jjrh() {
    }

    public jjrh(Entity entity, int n) {
        this._a = entity.field_70157_k;
        this._b = n;
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
        elai2.func_72524_a(this);
    }

    @Override
    public int func_73284_a() {
        return 5;
    }
}

