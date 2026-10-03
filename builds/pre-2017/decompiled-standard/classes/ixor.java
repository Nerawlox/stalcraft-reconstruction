/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;
import net.minecraft.util.sajh;

public class ixor
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;
    public int _i;
    public int _j;
    public int _k;

    public ixor() {
    }

    public ixor(Entity entity, int n) {
        this(entity, n, 0);
    }

    public ixor(Entity entity, int n, int n2) {
        this._a = entity.field_70157_k;
        this._b = sajh._c(entity.field_70165_t * 32.0);
        this._c = sajh._c(entity.field_70163_u * 32.0);
        this._d = sajh._c(entity.field_70161_v * 32.0);
        this._h = sajh._d(entity.field_70125_A * 256.0f / 360.0f);
        this._i = sajh._d(entity.field_70177_z * 256.0f / 360.0f);
        this._j = n;
        this._k = n2;
        if (n2 > 0) {
            double d = entity.field_70159_w;
            double d2 = entity.field_70181_x;
            double d3 = entity.field_70179_y;
            double d4 = 3.9;
            if (d < -d4) {
                d = -d4;
            }
            if (d2 < -d4) {
                d2 = -d4;
            }
            if (d3 < -d4) {
                d3 = -d4;
            }
            if (d > d4) {
                d = d4;
            }
            if (d2 > d4) {
                d2 = d4;
            }
            if (d3 > d4) {
                d3 = d4;
            }
            this._e = (int)(d * 8000.0);
            this._f = (int)(d2 * 8000.0);
            this._g = (int)(d3 * 8000.0);
        }
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._j = dataInput.readByte();
        this._b = dataInput.readInt();
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._h = dataInput.readByte();
        this._i = dataInput.readByte();
        this._k = dataInput.readInt();
        if (this._k > 0) {
            this._e = dataInput.readShort();
            this._f = dataInput.readShort();
            this._g = dataInput.readShort();
        }
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._j);
        dataOutput.writeInt(this._b);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeByte(this._h);
        dataOutput.writeByte(this._i);
        dataOutput.writeInt(this._k);
        if (this._k > 0) {
            dataOutput.writeShort(this._e);
            dataOutput.writeShort(this._f);
            dataOutput.writeShort(this._g);
        }
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72511_a(this);
    }

    @Override
    public int func_73284_a() {
        return 21 + this._k > 0 ? 6 : 0;
    }
}

