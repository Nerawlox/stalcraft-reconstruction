/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.util.sajh;

public class dibg
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;

    public dibg() {
    }

    public dibg(Entity entity) {
        this._a = entity.field_70157_k;
        this._b = sajh._c(entity.field_70165_t * 32.0);
        this._c = sajh._c(entity.field_70163_u * 32.0);
        this._d = sajh._c(entity.field_70161_v * 32.0);
        if (entity instanceof EntityLightningBolt) {
            this._e = 1;
        }
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._e = dataInput.readByte();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._e);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72508_a(this);
    }

    @Override
    public int func_73284_a() {
        return 17;
    }
}

