/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jgro;
import net.minecraft.util.eidj;
import net.minecraft.util.iurq;

public abstract class qokq {
    public int _b = 20;
    public String _c = "Pig";
    public List _d;
    public rrqs _e;
    public double _f;
    public double _g;
    public int _h = 200;
    public int _i = 800;
    public int _j = 4;
    public Entity _k;
    public int _l = 6;
    public int _m = 16;
    public int _n = 4;

    public String _e() {
        if (this._j() == null) {
            if (this._c.equals("Minecart")) {
                this._c = "MinecartRideable";
            }
            return this._c;
        }
        return this._j()._b;
    }

    public void _a(String string) {
        this._c = string;
    }

    public boolean _f() {
        return this._a().func_72977_a((double)this._b() + 0.5, (double)this._c() + 0.5, (double)this._d() + 0.5, this._m) != null;
    }

    public void _g() {
        if (!this._f()) {
            return;
        }
        if (this._a().field_72995_K) {
            double d = (float)this._b() + this._a().field_73012_v.nextFloat();
            double d2 = (float)this._c() + this._a().field_73012_v.nextFloat();
            double d3 = (float)this._d() + this._a().field_73012_v.nextFloat();
            this._a().func_72869_a("smoke", d, d2, d3, 0.0, 0.0, 0.0);
            this._a().func_72869_a("flame", d, d2, d3, 0.0, 0.0, 0.0);
            if (this._b > 0) {
                --this._b;
            }
            this._g = this._f;
            this._f = (this._f + (double)(1000.0f / ((float)this._b + 200.0f))) % 360.0;
        } else {
            if (this._b == -1) {
                this._h();
            }
            if (this._b > 0) {
                --this._b;
                return;
            }
            boolean bl = false;
            for (int i = 0; i < this._j; ++i) {
                Entity entity = jgro._a(this._e(), this._a());
                if (entity == null) {
                    return;
                }
                int n = this._a().func_72872_a(entity.getClass(), eidj._a()._a(this._b(), this._c(), this._d(), this._b() + 1, this._c() + 1, this._d() + 1)._b(this._n * 2, 4.0, this._n * 2)).size();
                if (n >= this._l) {
                    this._h();
                    return;
                }
                double d = (double)this._b() + (this._a().field_73012_v.nextDouble() - this._a().field_73012_v.nextDouble()) * (double)this._n;
                double d4 = this._c() + this._a().field_73012_v.nextInt(3) - 1;
                double d5 = (double)this._d() + (this._a().field_73012_v.nextDouble() - this._a().field_73012_v.nextDouble()) * (double)this._n;
                EntityLiving entityLiving = entity instanceof EntityLiving ? (EntityLiving)entity : null;
                entity.func_70012_b(d, d4, d5, this._a().field_73012_v.nextFloat() * 360.0f, 0.0f);
                if (entityLiving != null && !entityLiving.func_70601_bi()) continue;
                this._a(entity);
                this._a().func_72926_e(2004, this._b(), this._c(), this._d(), 0);
                if (entityLiving != null) {
                    entityLiving.func_70656_aK();
                }
                bl = true;
            }
            if (bl) {
                this._h();
            }
        }
    }

    public Entity _a(Entity entity) {
        if (this._j() != null) {
            huhy huhy2 = new qoac();
            entity.func_70039_c((qoac)huhy2);
            for (huhy huhy3 : this._j()._a._d()) {
                huhy2._a(huhy3._b(), huhy3._c());
            }
            entity.func_70020_e((qoac)huhy2);
            if (entity.field_70170_p != null) {
                entity.field_70170_p.func_72838_d(entity);
            }
            Object object = entity;
            while (huhy2._c("Riding")) {
                huhy huhy3;
                huhy3 = huhy2._m("Riding");
                Entity entity2 = jgro._a(((qoac)huhy3)._j("id"), entity.field_70170_p);
                if (entity2 != null) {
                    qoac qoac2 = new qoac();
                    entity2.func_70039_c(qoac2);
                    for (huhy huhy4 : ((qoac)huhy3)._d()) {
                        qoac2._a(huhy4._b(), huhy4._c());
                    }
                    entity2.func_70020_e(qoac2);
                    entity2.func_70012_b(((Entity)object).field_70165_t, ((Entity)object).field_70163_u, ((Entity)object).field_70161_v, ((Entity)object).field_70177_z, ((Entity)object).field_70125_A);
                    if (entity.field_70170_p != null) {
                        entity.field_70170_p.func_72838_d(entity2);
                    }
                    ((Entity)object).func_70078_a(entity2);
                }
                object = entity2;
                huhy2 = huhy3;
            }
        } else if (entity instanceof EntityLivingBase && entity.field_70170_p != null) {
            ((EntityLiving)entity).func_110161_a(null);
            this._a().func_72838_d(entity);
        }
        return entity;
    }

    public void _h() {
        this._b = this._i <= this._h ? this._h : this._h + this._a().field_73012_v.nextInt(this._i - this._h);
        if (this._d != null && this._d.size() > 0) {
            this._a((rrqs)iurq._a(this._a().field_73012_v, this._d));
        }
        this._a(1);
    }

    public void _a(qoac qoac2) {
        this._c = qoac2._j("EntityId");
        this._b = qoac2._e("Delay");
        if (qoac2._c("SpawnPotentials")) {
            this._d = new ArrayList();
            bsyv bsyv2 = qoac2._n("SpawnPotentials");
            for (int i = 0; i < bsyv2._d(); ++i) {
                this._d.add(new rrqs(this, (qoac)bsyv2._b(i)));
            }
        } else {
            this._d = null;
        }
        if (qoac2._c("SpawnData")) {
            this._a(new rrqs(this, qoac2._m("SpawnData"), this._c));
        } else {
            this._a((rrqs)null);
        }
        if (qoac2._c("MinSpawnDelay")) {
            this._h = qoac2._e("MinSpawnDelay");
            this._i = qoac2._e("MaxSpawnDelay");
            this._j = qoac2._e("SpawnCount");
        }
        if (qoac2._c("MaxNearbyEntities")) {
            this._l = qoac2._e("MaxNearbyEntities");
            this._m = qoac2._e("RequiredPlayerRange");
        }
        if (qoac2._c("SpawnRange")) {
            this._n = qoac2._e("SpawnRange");
        }
        if (this._a() != null && this._a().field_72995_K) {
            this._k = null;
        }
    }

    public void _b(qoac qoac2) {
        qoac2._a("EntityId", this._e());
        qoac2._a("Delay", (short)this._b);
        qoac2._a("MinSpawnDelay", (short)this._h);
        qoac2._a("MaxSpawnDelay", (short)this._i);
        qoac2._a("SpawnCount", (short)this._j);
        qoac2._a("MaxNearbyEntities", (short)this._l);
        qoac2._a("RequiredPlayerRange", (short)this._m);
        qoac2._a("SpawnRange", (short)this._n);
        if (this._j() != null) {
            qoac2._a("SpawnData", (qoac)this._j()._a._c());
        }
        if (this._j() != null || this._d != null && this._d.size() > 0) {
            bsyv bsyv2 = new bsyv();
            if (this._d != null && this._d.size() > 0) {
                for (rrqs rrqs2 : this._d) {
                    bsyv2._a(rrqs2._a());
                }
            } else {
                bsyv2._a(this._j()._a());
            }
            qoac2._a("SpawnPotentials", bsyv2);
        }
    }

    public Entity _i() {
        if (this._k == null) {
            Entity entity = jgro._a(this._e(), this._a());
            this._k = entity = this._a(entity);
        }
        return this._k;
    }

    public boolean _b(int n) {
        if (n == 1 && this._a().field_72995_K) {
            this._b = this._h;
            return true;
        }
        return false;
    }

    public rrqs _j() {
        return this._e;
    }

    public void _a(rrqs rrqs2) {
        this._e = rrqs2;
    }

    public abstract void _a(int var1);

    public abstract ozlu _a();

    public abstract int _b();

    public abstract int _c();

    public abstract int _d();
}

