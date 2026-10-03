/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anomaly.entity.EntityBolt;
import gloomyfolken.mods.anomaly.zwat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class mqkr
extends royz
implements zwat {
    public EntityLivingBase _c;
    private String _e = "anomalies:blackhole_active";
    public int _d = -1;

    @Override
    public void func_70316_g() {
        super.func_70316_g();
        if (!this.field_70331_k.field_72995_K && this._d == -1) {
            InvokeSideOnly.frontend(() -> {});
        }
        if (this._d != -1) {
            ++this._d;
            if (this._d == 119 && this.field_70331_k.field_72995_K) {
                --this._d;
            }
            if (this._c != null && !this.field_70331_k.field_72995_K && this._c.field_70170_p != this.field_70331_k) {
                this._e();
            } else if (this._c != null) {
                this._c(this._c, this._d);
                if (this._d >= 120 && this._c != null && !this.field_70331_k.field_72995_K) {
                    InvokeSideOnly.frontend(() -> {});
                }
            }
            if (this._d == 200) {
                if (this.field_70331_k.field_72995_K) {
                    InvokeSideOnly.client(() -> this._b.reset());
                }
                this._d = -1;
            }
        }
    }

    public void _a(boolean bl) {
        InvokeSideOnly.frontend(!this.field_70331_k.field_72995_K, () -> {});
        this._c = null;
        this._d = 120;
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
            InvokeSideOnly.client(() -> {
                this._c().reset();
                this._g();
            });
        }
        this._c = entityLivingBase;
        this._d = 0;
    }

    @ezey(_a={eidj.CLIENT})
    private void _g() {
        this.field_70331_k.func_72980_b((float)this.field_70329_l + 0.5f, (float)this.field_70330_m + 0.5f, (float)this.field_70327_n + 0.5f, this._e, 1.0f, 1.0f, false);
    }

    @Override
    public void _e() {
        if (!this.field_70331_k.field_72995_K) {
            InvokeSideOnly.frontend(() -> {});
        } else {
            InvokeSideOnly.client(() -> {
                if (this._b != null) {
                    this._c().reset();
                }
            });
        }
        this._d = -1;
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
        return 0.05f + (float)n / 2400.0f;
    }

    @Override
    protected Class<? extends iekw> _d() {
        return kkfz.class;
    }

    @Override
    public EntityLivingBase _f() {
        return this._c;
    }

    @Override
    public boolean func_70315_b(int n, int n2) {
        if (n == 3) {
            this._a(false);
            return true;
        }
        return super.func_70315_b(n, n2);
    }

    @Override
    protected void _b(EntityBolt entityBolt) {
        this.field_70331_k.func_72956_a(entityBolt, "stalker:funnel_bolt", 1.0f, 1.0f);
    }
}

