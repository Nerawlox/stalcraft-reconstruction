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
import net.minecraft.util.Vec3;

public class ncmp
extends mqld
implements zwat {
    public EntityLivingBase _c;
    private String _f = "anomalies:carousel_active";
    public int _d = -1;
    public int _e = 80;

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (this.worldObj.isRemote) {
            ++this._e;
        } else if (this._d == -1) {
            return;
        }
        if (this._d != -1) {
            ++this._d;
            if (this._c != null && !this.worldObj.isRemote && this._c.worldObj != this.worldObj) {
                this._e();
            } else if (this._c != null && !this.worldObj.isRemote && (this._c.getHealth() <= 0.0f || this._c.getDistanceSq((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) > 25.0)) {
                this._e();
            } else if (this._c != null) {
                if (!this.worldObj.isRemote && this._d % 20 == 0) {
                    gloomyfolken.mods.core.misc.ezey._a(this._c, pidb._b, this._d / 20, true);
                }
                if (Vec3._a(this._c.posX, this._c.boundingBox._c, this._c.posZ)._d((double)this.xCoord + 0.5, (double)this.yCoord + 0.5, (double)this.zCoord + 0.5) <= 25.0) {
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
        if (!this.worldObj.isRemote) {
            if (this._c != null) {
                return;
            }
            if (this._d != -1) {
                return;
            }
            if (entityLivingBase.isDead || entityLivingBase.getHealth() <= 0.0f) {
                return;
            }
            if (entityLivingBase.isEntityInvulnerable()) {
                return;
            }
            if (entityLivingBase instanceof EntityPlayer && ((EntityPlayer)entityLivingBase).capabilities._a) {
                return;
            }
        }
        if (!this.worldObj.isRemote) {
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
        this.worldObj.playSound((float)this.xCoord + 0.5f, (float)this.yCoord + 0.5f, (float)this.zCoord + 0.5f, this._f, 1.0f, 1.0f, false);
    }

    @Override
    public void _e() {
        if (this._c == null) {
            return;
        }
        if (!this.worldObj.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        } else if (this._c.getHealth() <= 0.0f) {
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
        this.worldObj.playSoundAtEntity(entityBolt, "stalker:carousel_bolt", 1.0f, 1.0f);
    }
}

