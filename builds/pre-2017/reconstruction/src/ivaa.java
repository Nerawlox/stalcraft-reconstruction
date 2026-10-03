/*
 * Decompiled with CFR 0.152.
 */
import atomicstryker.dynamiclights.client.DynamicLights;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.anomaly.AnomalyMod;
import gloomyfolken.mods.anomaly.entity.EntityLighterLight;
import gloomyfolken.mods.anomaly.pidb;
import gloomyfolken.mods.anomaly.tupg;
import gloomyfolken.mods.core.main.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;

public class ivaa
extends zfoo {
    public int _c = 0;
    private String _d = "";

    @Override
    public void updateEntity() {
        super.updateEntity();
        if (this._c > 0) {
            --this._c;
        }
        if (this.worldObj.isRemote) {
            InvokeSideOnly.client(() -> this._h());
        }
    }

    @ezey(_a={eidj.CLIENT})
    public void _h() {
        if (this._c > 0) {
            --this._c;
        }
    }

    @ezey(_a={eidj.CLIENT})
    public void _i() {
        jzqf jzqf2 = Minecraft._E()._N;
        if (this._c == 0) {
            this.worldObj.playSound((float)this.xCoord + 0.5f, (float)this.yCoord + 0.5f, (float)this.zCoord + 0.5f, AnomalyMod._H._a, 1.0f, 1.0f, false);
            this._d = "sound_" + jzqf2._h;
        }
        if (this._c <= 0 && ClientProxy.dynamicLights.enabled) {
            EntityLighterLight entityLighterLight = new EntityLighterLight(this);
            Minecraft._E()._r.spawnEntityInWorld(entityLighterLight);
            DynamicLights.addLightSource(new tupg(entityLighterLight));
        }
        this._c = 410;
    }

    public void _b(EntityLivingBase entityLivingBase) {
        this._c = 210;
        gloomyfolken.mods.core.misc.ezey._a(entityLivingBase, pidb._h, 1.0f, true);
        entityLivingBase.setFire(10);
    }

    @Override
    @ezey(_a={eidj.CLIENT})
    public boolean receiveClientEvent(int n, int n2) {
        if (n == 3) {
            this._i();
            return true;
        }
        return super.receiveClientEvent(n, n2);
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    protected Class<? extends iekw> _d() {
        return mqmb.class;
    }

    @Override
    public int _a() {
        return 2;
    }
}

