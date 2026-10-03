/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anomaly.entity.EntityBolt;
import gloomyfolken.mods.anomaly.pidb;
import gloomyfolken.mods.anomaly.zwat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ofbx;

public class ncmp
extends mqld
implements zwat {
    public EntityLivingBase _c;
    private String _f = "anomalies:carousel_active";
    public int _d = -1;
    public int _e = 80;

    @Override
    public void func_70316_g() {
        super.func_70316_g();
        if (this.field_70331_k.field_72995_K) {
            ++this._e;
        } else if (this._d == -1) {
            return;
        }
        if (this._d != -1) {
            ++this._d;
            if (this._c != null && !this.field_70331_k.field_72995_K && this._c.field_70170_p != this.field_70331_k) {
                this._e();
            } else if (this._c != null && !this.field_70331_k.field_72995_K && (this._c.func_110143_aJ() <= 0.0f || this._c.func_70092_e((double)this.field_70329_l + 0.5, (double)this.field_70330_m + 0.5, (double)this.field_70327_n + 0.5) > 25.0)) {
                this._e();
            } else if (this._c != null) {
                if (!this.field_70331_k.field_72995_K && this._d % 20 == 0) {
                    gloomyfolken.mods.core.misc.ezey._a(this._c, pidb._b, this._d / 20, true);
                }
                if (ofbx._a(this._c.field_70165_t, this._c.field_70121_D._c, this._c.field_70161_v)._d((double)this.field_70329_l + 0.5, (double)this.field_70330_m + 0.5, (double)this.field_70327_n + 0.5) <= 25.0) {
                    this._c(this._c, this._d);
                }
            }
            if (this._d >= 300) {
                this._e();
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    private void _h() {
        ((eiqn)this._b)._a(this._c);
    }

    @Override
    public void _a(EntityLivingBase entityLivingBase) {
        if (!this.field_70331_k.field_72995_K) {
            if (this._c != null) {
                return;
            }
            if (this._d != -1) {
                return;
            }
            if (entityLivingBase.field_70128_L || entityLivingBase.func_110143_aJ() <= 0.0f) {
                return;
            }
            if (entityLivingBase.func_85032_ar()) {
                return;
            }
            if (entityLivingBase instanceof EntityPlayer && ((EntityPlayer)entityLivingBase).field_71075_bZ._a) {
                return;
            }
        }
        if (!this.field_70331_k.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        } else {
            InvokeSideOnly.client(() -> this._i());
        }
        this._c = entityLivingBase;
        this._d = 0;
    }

    @ezey(_a={eidj.CLIENT})
    private void _i() {
        if (this._b != null) {
            this._c().reset();
        }
        this.field_70331_k.func_72980_b((float)this.field_70329_l + 0.5f, (float)this.field_70330_m + 0.5f, (float)this.field_70327_n + 0.5f, this._f, 1.0f, 1.0f, false);
    }

    @Override
    public void _e() {
        if (this._c == null) {
            return;
        }
        if (!this.field_70331_k.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        } else if (this._c.func_110143_aJ() <= 0.0f) {
            InvokeSideOnly.client(() -> this._h());
        }
        this._d = -1;
        this._e = 0;
        this._c = null;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public boolean _a(EntityPlayer entityPlayer) {
        return entityPlayer == this._c;
    }

    @Override
    public float _a(int n) {
        return 0.01f + (float)n / 12000.0f;
    }

    @Override
    public void _a() {
        if (this._c != null) {
            gloomyfolken.mods.core.misc.ezey._a(this._c, pidb._b, 1.0E7f, true);
        }
    }

    @Override
    protected Class<? extends iekw> _d() {
        return eiqn.class;
    }

    @Override
    public EntityLivingBase _f() {
        return this._c;
    }

    @Override
    protected void _b(EntityBolt entityBolt) {
        this.field_70331_k.func_72956_a(entityBolt, "stalker:carousel_bolt", 1.0f, 1.0f);
    }
}

