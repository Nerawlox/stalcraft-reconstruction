/*
 * Decompiled with CFR 0.152.
 */
import java.util.List;
import net.minecraft.entity.jxsn;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.zwaw;

public class rapl {
    public ozlu _a;
    public boolean _b;
    public int _c = -1;
    public int _d;
    public int _e;
    public mtdg _f;
    public int _g;
    public int _h;
    public int _i;

    public rapl(ozlu ozlu2) {
        this._a = ozlu2;
    }

    public void _a() {
        boolean bl = false;
        if (bl) {
            if (this._c == 2) {
                this._d = 100;
                return;
            }
        } else {
            if (this._a.func_72935_r()) {
                this._c = 0;
                return;
            }
            if (this._c == 2) {
                return;
            }
            if (this._c == 0) {
                float f = this._a.func_72826_c(0.0f);
                if ((double)f < 0.5 || (double)f > 0.501) {
                    return;
                }
                this._c = this._a.field_73012_v.nextInt(10) == 0 ? 1 : 2;
                this._b = false;
                if (this._c == 2) {
                    return;
                }
            }
        }
        if (!this._b) {
            if (this._b()) {
                this._b = true;
            } else {
                return;
            }
        }
        if (this._e > 0) {
            --this._e;
            return;
        }
        this._e = 2;
        if (this._d > 0) {
            this._c();
            --this._d;
        } else {
            this._c = 2;
        }
    }

    public boolean _b() {
        List list2 = this._a.field_73010_i;
        for (EntityPlayer entityPlayer : list2) {
            this._f = this._a.field_72982_D._a((int)entityPlayer.field_70165_t, (int)entityPlayer.field_70163_u, (int)entityPlayer.field_70161_v, 1);
            if (this._f == null || this._f._e() < 10 || this._f._f() < 20 || this._f._g() < 20) continue;
            zwaw zwaw2 = this._f._c();
            float f = this._f._d();
            boolean bl = false;
            for (int i = 0; i < 10; ++i) {
                this._g = zwaw2._a + (int)((double)(sajh._b(this._a.field_73012_v.nextFloat() * (float)Math.PI * 2.0f) * f) * 0.9);
                this._h = zwaw2._b;
                this._i = zwaw2._c + (int)((double)(sajh._a(this._a.field_73012_v.nextFloat() * (float)Math.PI * 2.0f) * f) * 0.9);
                bl = false;
                for (mtdg mtdg2 : this._a.field_72982_D._c()) {
                    if (mtdg2 == this._f || !mtdg2._a(this._g, this._h, this._i)) continue;
                    bl = true;
                    break;
                }
                if (!bl) break;
            }
            if (bl) {
                return false;
            }
            ofbx ofbx2 = this._a(this._g, this._h, this._i);
            if (ofbx2 == null) continue;
            this._e = 0;
            this._d = 20;
            return true;
        }
        return false;
    }

    public boolean _c() {
        EntityZombie entityZombie;
        ofbx ofbx2 = this._a(this._g, this._h, this._i);
        if (ofbx2 == null) {
            return false;
        }
        try {
            entityZombie = new EntityZombie(this._a);
            entityZombie.func_110161_a(null);
            entityZombie.func_82229_g(false);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        entityZombie.func_70012_b(ofbx2._c, ofbx2._d, ofbx2._e, this._a.field_73012_v.nextFloat() * 360.0f, 0.0f);
        this._a.func_72838_d(entityZombie);
        zwaw zwaw2 = this._f._c();
        entityZombie.func_110171_b(zwaw2._a, zwaw2._b, zwaw2._c, this._f._d());
        return true;
    }

    public ofbx _a(int n, int n2, int n3) {
        for (int i = 0; i < 10; ++i) {
            int n4;
            int n5;
            int n6 = n + this._a.field_73012_v.nextInt(16) - 8;
            if (!this._f._a(n6, n5 = n2 + this._a.field_73012_v.nextInt(6) - 3, n4 = n3 + this._a.field_73012_v.nextInt(16) - 8) || !xtbl._a(jxsn._a, this._a, n6, n5, n4)) continue;
            this._a.func_82732_R()._a(n6, n5, n4);
        }
        return null;
    }
}

