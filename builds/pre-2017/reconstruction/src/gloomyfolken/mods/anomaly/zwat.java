/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingSelf;

public interface zwat {
    public boolean _a(EntityPlayer var1);

    default public float _a(int n) {
        return 0.0f;
    }

    default public void _a() {
    }

    default public Vec3 _a(Vec3 vec3, Vec3 vec32, int n) {
        float f = this._a(n);
        royz royz2 = this._s_();
        Vec3 vec33 = Vec3._a((double)royz2.xCoord + 0.5 - vec3._c, (double)royz2.yCoord + 3.38 - vec3._d, (double)royz2.zCoord + 0.5 - vec3._e)._a();
        return Vec3._a(vec32._c + (Math.abs(vec33._c * (double)f) > Math.abs((double)royz2.xCoord + 0.5 - vec3._c) ? (double)royz2.xCoord + 0.5 - vec3._c : vec33._c * (double)f), Math.min(vec33._d * (double)f, (double)royz2.yCoord + 3.38 - vec3._d), vec32._e + (Math.abs(vec33._e * (double)f) > Math.abs((double)royz2.zCoord + 0.5 - vec3._e) ? (double)royz2.zCoord + 0.5 - vec3._e : vec33._e * (double)f));
    }

    default public royz _s_() {
        return (royz)((Object)this);
    }

    default public void _a(EntityLivingBase entityLivingBase, int n) {
        Vec3 vec3 = entityLivingBase.worldObj.getWorldVec3Pool()._a(entityLivingBase.posX, entityLivingBase.posY, entityLivingBase.posZ);
        Vec3 vec32 = entityLivingBase.worldObj.getWorldVec3Pool()._a(entityLivingBase.motionX, entityLivingBase.motionY, entityLivingBase.motionZ);
        Vec3 vec33 = this._a(vec3, vec32, n);
        entityLivingBase.motionX = vec33._c;
        entityLivingBase.motionY = vec33._d;
        entityLivingBase.motionZ = vec33._e;
    }

    @ezey(_a={eidj.CLIENT})
    default public void _b(EntityLivingBase entityLivingBase, int n) {
        if (entityLivingBase == Minecraft._E()._t) {
            royz royz2 = this._s_();
            SmartMovingSelf smartMovingSelf = (SmartMovingSelf)SmartMovingFactory.getInstance(Minecraft._E()._t);
            smartMovingSelf.anticheat._a(this, n);
            new jygo(royz2.xCoord, royz2.yCoord, royz2.zCoord, n).sendToServer();
        }
    }

    default public void _c(EntityLivingBase entityLivingBase, int n) {
        royz royz2 = this._s_();
        if (royz2.worldObj.isRemote) {
            InvokeSideOnly.client(() -> this._b(entityLivingBase, n));
        } else if (!(entityLivingBase instanceof EntityPlayer)) {
            this._a(entityLivingBase, n);
        }
    }
}

