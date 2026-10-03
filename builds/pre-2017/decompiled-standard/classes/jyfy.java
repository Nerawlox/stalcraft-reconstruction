/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.eidj;
import net.minecraft.util.sajh;

public class jyfy {
    public final eidj _a = eidj._a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    public float _b;
    public float _c;
    public float _d;
    public float _e = 1.62f;
    public float _f = 0.5f;
    public double _g;
    public double _h;
    public double _i;
    public double _j;
    public double _k;
    public double _l;
    public double _m;
    public double _n;
    public double _o;
    public float _p = 0.02f;
    public float _q;
    public float _r;
    public float _s;
    int _t = 1;
    private float _G;
    public boolean _u;
    public boolean _v;
    public boolean _w;
    public boolean _x;
    public boolean _y;
    public boolean _z;
    public int _A;
    public float _B;
    public float _C;
    public float _D;
    public float _E;
    public boolean _F;
    private boolean _H;
    private boolean _I;
    private boolean _J;
    private boolean _K;
    private EntityPlayer _L;

    public jyfy(EntityPlayer entityPlayer) {
        this._L = entityPlayer;
        this._a();
    }

    public void _a() {
        this._B = this._L.field_70177_z;
        this._C = this._L.field_70125_A;
        this._b = 1.8f;
        this._c = this._L.field_70130_N;
        this._a(this._L.field_70165_t, this._L.field_70163_u, this._L.field_70161_v);
    }

    public void _a(DataOutput dataOutput) throws IOException {
        dataOutput.writeDouble(this._a._b);
        dataOutput.writeDouble(this._a._c);
        dataOutput.writeDouble(this._a._d);
        dataOutput.writeDouble(this._a._e);
        dataOutput.writeDouble(this._a._f);
        dataOutput.writeDouble(this._a._g);
        dataOutput.writeFloat(this._b);
        dataOutput.writeFloat(this._c);
        dataOutput.writeFloat(this._d);
        dataOutput.writeFloat(this._e);
        dataOutput.writeFloat(this._f);
        dataOutput.writeDouble(this._g);
        dataOutput.writeDouble(this._h);
        dataOutput.writeDouble(this._i);
        dataOutput.writeDouble(this._j);
        dataOutput.writeDouble(this._k);
        dataOutput.writeDouble(this._l);
        dataOutput.writeDouble(this._m);
        dataOutput.writeDouble(this._n);
        dataOutput.writeDouble(this._o);
        dataOutput.writeFloat(this._p);
        dataOutput.writeFloat(this._q);
        dataOutput.writeFloat(this._r);
        dataOutput.writeFloat(this._s);
        dataOutput.writeInt(this._t);
        dataOutput.writeFloat(this._G);
        dataOutput.writeBoolean(this._u);
        dataOutput.writeBoolean(this._v);
        dataOutput.writeBoolean(this._w);
        dataOutput.writeBoolean(this._x);
        dataOutput.writeBoolean(this._y);
        dataOutput.writeBoolean(this._z);
        dataOutput.writeInt(this._A);
    }

    public void _a(DataInput dataInput) throws IOException {
        this._a._b = dataInput.readDouble();
        this._a._c = dataInput.readDouble();
        this._a._d = dataInput.readDouble();
        this._a._e = dataInput.readDouble();
        this._a._f = dataInput.readDouble();
        this._a._g = dataInput.readDouble();
        this._b = dataInput.readFloat();
        this._c = dataInput.readFloat();
        this._d = dataInput.readFloat();
        this._e = dataInput.readFloat();
        this._f = dataInput.readFloat();
        this._g = dataInput.readDouble();
        this._h = dataInput.readDouble();
        this._i = dataInput.readDouble();
        this._j = dataInput.readDouble();
        this._k = dataInput.readDouble();
        this._l = dataInput.readDouble();
        this._m = dataInput.readDouble();
        this._n = dataInput.readDouble();
        this._o = dataInput.readDouble();
        this._p = dataInput.readFloat();
        this._q = dataInput.readFloat();
        this._r = dataInput.readFloat();
        this._s = dataInput.readFloat();
        this._t = dataInput.readInt();
        this._G = dataInput.readFloat();
        this._u = dataInput.readBoolean();
        this._v = dataInput.readBoolean();
        this._w = dataInput.readBoolean();
        this._x = dataInput.readBoolean();
        this._y = dataInput.readBoolean();
        this._z = dataInput.readBoolean();
        this._A = dataInput.readInt();
    }

    public void _a(double d, double d2, double d3) {
        this._o = 0.0;
        this._n = 0.0;
        this._m = 0.0;
        this._j = d;
        this._k = d2;
        this._l = d3;
        float f = this._c / 2.0f;
        float f2 = this._b;
        this._a._b(d - (double)f, d2 - (double)this._e + (double)this._d, d3 - (double)f, d + (double)f, d2 - (double)this._e + (double)this._d + (double)f2, d3 + (double)f);
    }

    public void _a(EntityPlayer entityPlayer) {
        this._I = entityPlayer.field_71075_bZ._b;
        this._J = entityPlayer.field_71075_bZ._a;
        this._K = entityPlayer.func_70115_ae();
        this._B = entityPlayer.field_70177_z;
        this._C = entityPlayer.field_70125_A;
        this._E = entityPlayer.field_70761_aq;
    }

    public void _b() {
        this._g = this._j;
        this._h = this._k;
        this._i = this._l;
        this._q = this._r;
        this._D = this._E;
    }

    public void _c() {
        this._L.field_70165_t = this._j;
        this._L.field_70163_u = this._k;
        this._L.field_70161_v = this._l;
        this._L.field_70121_D._c(this._a);
        this._L.field_70131_O = this._b;
        this._L.field_70130_N = this._c;
        this._L.field_70139_V = this._d;
        this._L.field_70129_M = this._e;
        this._L.field_70138_W = this._f;
        this._L.field_70159_w = this._m;
        this._L.field_70181_x = this._n;
        this._L.field_70179_y = this._o;
        if (this._L.field_70170_p.field_72995_K) {
            this._L.field_70143_R = this._G;
        }
        this._L.field_70761_aq = this._E;
        this._L.field_70747_aH = this._p;
        this._L.field_70140_Q = this._r;
        this._L.field_70123_F = this._u;
        this._L.field_70124_G = this._v;
        this._L.field_70132_H = this._w;
        this._L.field_70122_E = this._x;
        this._L.field_70160_al = this._y;
        this._L.field_70703_bu = this._z;
        if (!this._L.field_70170_p.field_72995_K) {
            this._L.field_70163_u = this._a._c;
            this._L.field_70129_M = 0.0f;
        }
    }

    public boolean _d() {
        return this._I;
    }

    public void _a(boolean bl) {
    }

    public boolean _e() {
        return this._K;
    }

    public boolean _f() {
        return this._J;
    }

    public void _b(boolean bl) {
    }

    public boolean _g() {
        return false;
    }

    public void _c(boolean bl) {
        this._H = bl;
    }

    public boolean _h() {
        return this._H;
    }

    public void _a(float f, float f2, float f3) {
        float f4 = f * f + f2 * f2;
        if (f4 >= 1.0E-4f) {
            if ((f4 = sajh._c(f4)) < 1.0f) {
                f4 = 1.0f;
            }
            f4 = f3 / f4;
            float f5 = sajh._a(this._B * (float)Math.PI / 180.0f);
            float f6 = sajh._b(this._B * (float)Math.PI / 180.0f);
            this._m += (double)((f *= f4) * f6 - (f2 *= f4) * f5);
            this._o += (double)(f2 * f6 + f * f5);
        }
    }

    public void _a(double d, boolean bl) {
        if (bl) {
            if (this._G > 0.0f) {
                this._G = 0.0f;
            }
        } else if (d < 0.0) {
            this._G = (float)((double)this._G - d);
        }
    }

    public boolean _i() {
        return false;
    }

    public float _j() {
        return this._G;
    }

    public void _k() {
        this._L.field_70143_R = 0.0f;
        this._G = 0.0f;
    }

    public void _a(float f) {
        this._G = f;
    }
}

