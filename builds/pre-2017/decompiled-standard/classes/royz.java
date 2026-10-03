/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.common.FMLCommonHandler;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anomaly.entity.EntityBolt;
import gloomyfolken.mods.effects.client.main.eidj;
import gloomyfolken.mods.effects.client.main.pidb;
import java.lang.reflect.Constructor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public abstract class royz
extends hurg {
    public long _a = -1L;
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public iekw _b;
    private boolean _c = true;

    @Override
    public boolean canUpdate() {
        return FMLCommonHandler.instance().getSide().isClient();
    }

    @Override
    public void func_70307_a(qoac qoac2) {
        super.func_70307_a(qoac2);
        this._a = qoac2._g("last_ejection");
    }

    @Override
    public void func_70310_b(qoac qoac2) {
        super.func_70310_b(qoac2);
        qoac2._a("last_ejection", this._a);
    }

    @Override
    public void func_70316_g() {
        if (this._c) {
            if (this.field_70331_k.field_72995_K) {
                InvokeSideOnly.client(() -> this._b());
            }
            this._c = false;
        }
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    protected boolean _b() {
        Class<? extends iekw> clazz = this._d();
        if (eidj._a != null && clazz != null) {
            try {
                Constructor<? extends iekw> constructor = clazz.getConstructor(this.getClass());
                this._b = constructor.newInstance(this);
                pidb._a(this._c());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public iekw _c() {
        if (this._b == null) {
            this._b();
            this._c = false;
        }
        return this._b;
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    protected abstract Class<? extends iekw> _d();

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void onChunkUnload() {
        if (this._b != null) {
            this._b.isValid = false;
        }
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public void func_70313_j() {
        super.func_70313_j();
        if (this._b != null) {
            this._b.isValid = false;
        }
    }

    public void _a(EntityLivingBase entityLivingBase) {
    }

    public void _e() {
    }

    public EntityLivingBase _f() {
        return null;
    }

    @Override
    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    public boolean func_70315_b(int n, int n2) {
        if (n == 0) {
            Entity entity = this.field_70331_k.func_73045_a(n2);
            if (entity instanceof EntityBolt) {
                this._a((EntityBolt)entity);
            }
            return true;
        }
        if (n == 1) {
            Entity entity = this.field_70331_k.func_73045_a(n2);
            if (entity instanceof EntityLivingBase) {
                this._a((EntityLivingBase)entity);
            }
            return true;
        }
        if (n == 2) {
            this._e();
            return true;
        }
        return super.func_70315_b(n, n2);
    }

    @ezey(_a={gloomyfolken.bundle.common.core.eidj.CLIENT})
    protected void _a(EntityBolt entityBolt) {
        iekw iekw2 = this._c();
        iekw2.particles.add(new goxf(iekw2, entityBolt));
        iekw2.particles.add(new wnfb(iekw2, entityBolt));
    }

    protected void _b(EntityBolt entityBolt) {
    }
}

