/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.sajh;

public class kmst
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public kmst() {
    }

    public kmst(EntityXPOrb entityXPOrb) {
        this._a = entityXPOrb.field_70157_k;
        this._b = sajh._c(entityXPOrb.field_70165_t * 32.0);
        this._c = sajh._c(entityXPOrb.field_70163_u * 32.0);
        this._d = sajh._c(entityXPOrb.field_70161_v * 32.0);
        this._e = entityXPOrb.func_70526_d();
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readShort();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeShort(this._e);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72514_a(this);
    }

    @Override
    public int func_73284_a() {
        return 18;
    }
}

