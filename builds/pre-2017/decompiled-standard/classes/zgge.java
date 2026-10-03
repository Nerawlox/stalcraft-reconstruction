/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.InvokeWithResult;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.weapon.entity.EntityShell;
import gloomyfolken.mods.weapon.ugqx;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;

public class zgge
extends hurg
implements gloomyfolken.mods.weapon.eidj {
    private static final int _f = 300;
    private static final int _g = 100;
    private static final int _h = 2000;
    private static final int _i = 14955;
    private static final String _j = "stalker:machinegun_reload";
    private static final String _k = "stalker:machinegun_shoot";
    public int _a = 0;
    private EntityPlayer _l = null;
    private long _m = 0L;
    private long _n = 0L;
    public float _b = 0.0f;
    public float _c = 0.0f;
    public float _d = 0.0f;
    public float _e = 0.0f;

    public void _a() {
        if (this._l != null) {
            ugqx._a((EntityPlayer)this._l)._f = null;
            if (!this._l.field_70170_p.field_72995_K) {
                InvokeSideOnly.frontend(() -> {});
            }
        }
        this._l = null;
        this._b = 0.0f;
        this._c = 0.0f;
    }

    @Override
    public void func_70316_g() {
        if (!this.field_70331_k.field_72995_K && this._l != null) {
            InvokeSideOnly.frontend(() -> {});
        }
        if (!this.field_70331_k.field_72995_K || InvokeWithResult.client(() -> this._l == this._j()).booleanValue()) {
            this._l();
        }
        if (this.field_70331_k.field_72995_K) {
            this._k();
        } else {
            this._k();
        }
    }

    @ezey(_a={eidj.CLIENT})
    private EntityPlayer _j() {
        return xpzm._E()._t;
    }

    private void _k() {
        EntityPlayer entityPlayer = this._b();
        this._d = this._b;
        this._e = this._c;
        if (entityPlayer != null) {
            float f = Math.max(-60.0f, Math.min(entityPlayer.field_70125_A, 60.0f));
            float f2 = (entityPlayer.field_70177_z - (float)(this.func_70322_n() * 90)) % 360.0f;
            if (f2 < -180.0f) {
                f2 += 360.0f;
            }
            if (f2 > 180.0f) {
                f2 -= 360.0f;
            }
            if (f2 > 90.0f) {
                f2 = 90.0f;
            }
            if (f2 < -90.0f) {
                f2 = -90.0f;
            }
            if (this._b == -90.0f && f2 == 90.0f || this._b == 90.0f && f2 == -90.0f) {
                return;
            }
            if (f2 != this._b || f != this._c) {
                if (this._a(this._b, this._c) || !this._a(f2, f)) {
                    this._c = f;
                    this._b = f2;
                } else if (!this._a(f2, this._c)) {
                    this._b = f2;
                } else if (!this._a(this._b, f)) {
                    this._c = f;
                }
            }
        }
    }

    private void _l() {
        EntityPlayer entityPlayer = this._b();
        if (entityPlayer != null) {
            float f = this._b + (float)(this.func_70322_n() * 90);
            double d = (double)(-(-sajh._a(f / 180.0f * (float)Math.PI))) * 1.2 + (double)this.field_70329_l + 0.5;
            double d2 = (double)(-sajh._b(f / 180.0f * (float)Math.PI)) * 1.2 + (double)this.field_70327_n + 0.5;
            if (Math.abs(entityPlayer.field_70165_t - d) > 0.01 || Math.abs(entityPlayer.field_70161_v - d2) > 0.01) {
                entityPlayer.func_70091_d(d - entityPlayer.field_70165_t, -0.5, d2 - entityPlayer.field_70161_v);
            }
        }
    }

    private boolean _a(float f, float f2) {
        ofbx ofbx2;
        float f3 = 1.5f;
        double d = -sajh._a((f += (float)(this.func_70322_n() * 90)) / 180.0f * (float)Math.PI) * sajh._b(f2 / 180.0f * (float)Math.PI) * f3;
        double d2 = sajh._b(f / 180.0f * (float)Math.PI) * sajh._b(f2 / 180.0f * (float)Math.PI) * f3;
        double d3 = -sajh._a(f2 / 180.0f * (float)Math.PI) * f3;
        ofbx ofbx3 = this.field_70331_k.func_82732_R()._a((double)this.field_70329_l + 0.5 + d * 0.5, (double)this.field_70330_m + 0.4 + d3 * 0.5, (double)this.field_70327_n + 0.5 + d2 * 0.5);
        hank hank2 = this.field_70331_k.func_72831_a(ofbx3, ofbx2 = this.field_70331_k.func_82732_R()._a(ofbx3._c + d, ofbx3._d + d3, ofbx3._e + d2), false, true);
        return hank2 != null;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    public EntityPlayer _b() {
        if (this.field_70331_k.field_72995_K && this._l != null && ugqx._a((EntityPlayer)this._l)._f == null) {
            this._l = null;
        }
        return this._l;
    }

    @ezey(_a={eidj.CLIENT})
    public void _a(EntityPlayer entityPlayer) {
        this._l = entityPlayer;
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._a = qoac2._f("bullets_in_cage");
        this._b = this._d = qoac2._h("rot_yaw");
        this._c = this._e = qoac2._h("rot_pitch");
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("bullets_in_cage", this._a);
        qoac2._a("rot_yaw", this._b);
        qoac2._a("rot_pitch", this._c);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean func_70315_b(int n, int n2) {
        if (n == 1) {
            this._a = n2;
            this._l = this._j();
            ugqx._a((EntityPlayer)this._j())._f = this;
            return true;
        }
        if (n == 2) {
            this._a();
            return true;
        }
        return super.func_70315_b(n, n2);
    }

    public float _b(EntityPlayer entityPlayer) {
        return 96.0f;
    }

    public int _c(EntityPlayer entityPlayer) {
        return 1;
    }

    public float _a(EntityPlayer entityPlayer, float f) {
        return 10.0f - f * 0.01f;
    }

    public float _d(EntityPlayer entityPlayer) {
        return 1.0f;
    }

    public float _e(EntityPlayer entityPlayer) {
        return 0.0f;
    }

    public float _f(EntityPlayer entityPlayer) {
        return 0.0f;
    }

    public float _g(EntityPlayer entityPlayer) {
        return 0.0f;
    }

    public String _h(EntityPlayer entityPlayer) {
        return _k;
    }

    public boolean _i(EntityPlayer entityPlayer) {
        return this._a > 0 && System.currentTimeMillis() > this._m + 100L;
    }

    @ezey(_a={eidj.CLIENT})
    public void _j(EntityPlayer entityPlayer) {
        this.field_70331_k.func_72838_d(new EntityShell(this.field_70331_k, (double)this.field_70329_l + 0.5, (double)this.field_70330_m + 0.5, (double)this.field_70327_n + 0.5, this._b + (float)(this.func_70322_n() * 90), this._c, 0.0f, "gilza5.mcsa", "sleeve.dds"));
    }

    @ezey(_a={eidj.CLIENT})
    public void _k(EntityPlayer entityPlayer) {
        this._e = Math.max(-45.0f, this._e - 3.0f);
        sbzn._a._a(this, 5, -1.2f, 3.0f, false);
    }

    @Override
    public EntityPlayer _c() {
        return this._l;
    }

    @Override
    public int _d() {
        return 300;
    }

    @Override
    public int _e() {
        return this._a;
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ void onShootClient(Entity entity) {
        this._k((EntityPlayer)entity);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public /* synthetic */ void spawnShell(Entity entity) {
        this._j((EntityPlayer)entity);
    }

    @Override
    public /* synthetic */ boolean canShoot(Entity entity) {
        return this._i((EntityPlayer)entity);
    }

    @Override
    public /* synthetic */ String getShootSoundName(Entity entity) {
        return this._h((EntityPlayer)entity);
    }

    @Override
    public /* synthetic */ float getBleedingProbability(Entity entity) {
        return this._g((EntityPlayer)entity);
    }

    @Override
    public /* synthetic */ float getIncendiaryProbability(Entity entity) {
        return this._f((EntityPlayer)entity);
    }

    @Override
    public /* synthetic */ float getPiercingFactor(Entity entity) {
        return this._e((EntityPlayer)entity);
    }

    @Override
    public /* synthetic */ float getSpread(Entity entity) {
        return this._d((EntityPlayer)entity);
    }

    @Override
    public /* synthetic */ float getDamage(Entity entity, float f) {
        return this._a((EntityPlayer)entity, f);
    }

    @Override
    public /* synthetic */ int getNumBullets(Entity entity) {
        return this._c((EntityPlayer)entity);
    }

    @Override
    public /* synthetic */ float getMaxDistance(Entity entity) {
        return this._b((EntityPlayer)entity);
    }
}

