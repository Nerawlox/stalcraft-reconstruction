/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.util.amww;
import net.minecraft.util.hank;
import noppes.npcs.EntityNPCInterface;

public class gsax
extends cfum {
    private Entity _a;
    private Class<? extends Entity> _b;
    private int _c = -1;
    private String _d;

    private gsax() {
    }

    public static gsax _a() {
        return new gsax();
    }

    public gsax _a(Entity entity) {
        this._a = entity;
        return this;
    }

    public gsax _a(Class<? extends Entity> clazz) {
        this._b = clazz;
        return this;
    }

    public gsax _a(String string) {
        this._d = string;
        return this;
    }

    public gsax _a(int n) {
        this._c = n;
        return this;
    }

    public boolean _a(hank hank2) {
        pkix pkix2;
        if (hank2 == null) {
            return false;
        }
        if (hank2._c == amww._b && hank2._i != null) {
            if (this._d != null && hank2._i instanceof EntityNPCInterface) {
                return hank2._i.func_70023_ak().equals(this._d);
            }
            if (this._b != null && this._b.isInstance(hank2._i)) {
                return true;
            }
            if (this._a != null && hank2 != null) {
                return this._a.field_70157_k == hank2._i.field_70157_k;
            }
        } else if (hank2._c == amww._a && (pkix2 = xpzm._E()._r).func_72798_a(hank2._d, hank2._e, hank2._f) == this._c) {
            return true;
        }
        return false;
    }

    @Override
    public ywts _a(dzyj dzyj2) {
        this._i = new hebv.kjui(dzyj2){

            @Override
            public void _a(Entity entity) {
            }

            @Override
            public void _b(Entity entity) {
            }

            @Override
            public void _a(hank hank2) {
                if (gsax.this._a(hank2)) {
                    gsax.this._a(gsax.this, this);
                }
            }
        };
        return this._i;
    }
}

