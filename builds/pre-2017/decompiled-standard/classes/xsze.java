/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.util.List;
import net.minecraft.entity.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.sajh;

public class xsze
extends cezg {
    public int _a;
    public String _b;
    public int _c;
    public int _d;
    public int _e;
    public byte _f;
    public byte _g;
    public int _h;
    public ezey _i;
    public List _j;

    public xsze() {
    }

    public xsze(EntityPlayer entityPlayer) {
        this._a = entityPlayer.field_70157_k;
        this._b = entityPlayer.func_70005_c_();
        this._c = sajh._c(entityPlayer.field_70165_t * 32.0);
        this._d = sajh._c(entityPlayer.field_70163_u * 32.0);
        this._e = sajh._c(entityPlayer.field_70161_v * 32.0);
        this._f = (byte)(entityPlayer.field_70177_z * 256.0f / 360.0f);
        this._g = (byte)(entityPlayer.field_70125_A * 256.0f / 360.0f);
        cvzo cvzo2 = entityPlayer.field_71071_by._a();
        this._h = cvzo2 == null ? 0 : cvzo2._d;
        this._i = entityPlayer.func_70096_w();
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = xsze.func_73282_a(dataInput, 16);
        this._c = dataInput.readInt();
        this._d = dataInput.readInt();
        this._e = dataInput.readInt();
        this._f = dataInput.readByte();
        this._g = dataInput.readByte();
        this._h = dataInput.readShort();
        this._j = ezey._a(dataInput);
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        xsze.func_73271_a(this._b, dataOutput);
        dataOutput.writeInt(this._c);
        dataOutput.writeInt(this._d);
        dataOutput.writeInt(this._e);
        dataOutput.writeByte(this._f);
        dataOutput.writeByte(this._g);
        dataOutput.writeShort(this._h);
        this._i._a(dataOutput);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72518_a(this);
    }

    @Override
    public int func_73284_a() {
        return 28;
    }

    public List _a() {
        if (this._j == null) {
            this._j = this._i._c();
        }
        return this._j;
    }
}

