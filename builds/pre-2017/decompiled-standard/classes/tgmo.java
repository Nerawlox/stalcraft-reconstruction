/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ezey;
import net.minecraft.entity.jgro;
import net.minecraft.util.sajh;

public class tgmo
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public int _h;
    public byte _i;
    public byte _j;
    public byte _k;
    public ezey _l;
    public List _m;

    public tgmo() {
    }

    public tgmo(EntityLivingBase entityLivingBase) {
        this._a = entityLivingBase.field_70157_k;
        this._b = (byte)jgro._a(entityLivingBase);
        this._c = entityLivingBase.field_70168_am._a(entityLivingBase.field_70165_t);
        this._d = sajh._c(entityLivingBase.field_70163_u * 32.0);
        this._e = entityLivingBase.field_70168_am._a(entityLivingBase.field_70161_v);
        this._i = (byte)(entityLivingBase.field_70177_z * 256.0f / 360.0f);
        this._j = (byte)(entityLivingBase.field_70125_A * 256.0f / 360.0f);
        this._k = (byte)(entityLivingBase.field_70759_as * 256.0f / 360.0f);
        double d = 3.9;
        double d2 = entityLivingBase.field_70159_w;
        double d3 = entityLivingBase.field_70181_x;
        double d4 = entityLivingBase.field_70179_y;
        if (d2 < -d) {
            d2 = -d;
        }
        if (d3 < -d) {
            d3 = -d;
        }
        if (d4 < -d) {
            d4 = -d;
        }
        if (d2 > d) {
            d2 = d;
        }
        if (d3 > d) {
            d3 = d;
        }
        if (d4 > d) {
            d4 = d;
        }
        this._f = (int)(d2 * 8000.0);
        this._g = (int)(d3 * 8000.0);
        this._h = (int)(d4 * 8000.0);
        this._l = entityLivingBase.func_70096_w();
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readByte() & 0xFF;
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readInt();
        this._i = dataInput.readByte();
        this._j = dataInput.readByte();
        this._k = dataInput.readByte();
        this._f = dataInput.readShort();
        this._g = dataInput.readShort();
        this._h = dataInput.readShort();
        this._m = ezey._a(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeByte(this._b & 0xFF);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeInt(this._e);
        dataOutput.writeByte(this._i);
        dataOutput.writeByte(this._j);
        dataOutput.writeByte(this._k);
        dataOutput.writeShort(this._f);
        dataOutput.writeShort(this._g);
        dataOutput.writeShort(this._h);
        this._l._a(dataOutput);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72519_a(this);
    }

    @Override
    public int func_73284_a() {
        return 26;
    }

    public List _a() {
        if (this._m == null) {
            this._m = this._l._c();
        }
        return this._m;
    }
}

