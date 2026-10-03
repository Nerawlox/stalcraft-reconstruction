/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;

public class nwaj
extends cezg {
    public int _a;
    public int _b;
    public int _c;

    public nwaj() {
    }

    public nwaj(int n, Entity entity, Entity entity2) {
        this._a = n;
        this._b = entity.field_70157_k;
        this._c = entity2 != null ? entity2.field_70157_k : -1;
    }

    @Override
    public int func_73284_a() {
        return 8;
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._a = dataInput.readUnsignedByte();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeByte(this._a);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72484_a(this);
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        nwaj nwaj2 = (nwaj)cezg2;
        return nwaj2._b == this._b;
    }
}

