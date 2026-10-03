/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anticheat.pidb;
import java.io.DataInput;
import java.io.DataOutput;
import net.minecraft.entity.Entity;

public class fofa
extends cezg {
    public int _a;
    public int _b;
    public int _c;
    public int _d;

    public fofa() {
    }

    public fofa(Entity entity) {
        this(entity.field_70157_k, entity.field_70159_w, entity.field_70181_x, entity.field_70179_y);
    }

    public fofa(int n, double d, double d2, double d3) {
        this._a = n;
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
        this._b = (int)(d * 8000.0);
        this._c = (int)(d2 * 8000.0);
        this._d = (int)(d3 * 8000.0);
    }

    @Override
    public void func_73267_a(DataInput dataInput) {
        this._a = dataInput.readInt();
        this._b = dataInput.readShort();
        this._c = dataInput.readShort();
        this._d = dataInput.readShort();
    }

    @Override
    public void func_73273_a(DataOutput dataOutput) {
        dataOutput.writeInt(this._a);
        dataOutput.writeShort(this._b);
        dataOutput.writeShort(this._c);
        dataOutput.writeShort(this._d);
    }

    @Override
    public void func_73279_a(elai elai2) {
        elai2.func_72520_a(this);
    }

    @Override
    public int func_73284_a() {
        return 10;
    }

    @Override
    public boolean func_73278_e() {
        return true;
    }

    @Override
    public boolean func_73268_a(cezg cezg2) {
        pidb._a(this, cezg2);
        return false;
    }
}

