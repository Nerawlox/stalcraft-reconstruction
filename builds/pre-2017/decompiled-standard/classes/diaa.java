/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;

public class diaa
extends cezg {
    public int _a;
    public int _b;
    public int _c;

    public diaa() {
    }

    public diaa(Entity entity, int n) {
        this(entity, n, 0);
    }

    public diaa(Entity entity, int n, int n2) {
        this._a = entity.field_70157_k;
        this._b = n;
        this._c = n2;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte();
        this._c = dataInput.readInt();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b);
        dataOutput.writeInt(this._c);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72473_a(this);
    }

    @Override
    public int func_73284_a() {
        return 9;
    }
}

