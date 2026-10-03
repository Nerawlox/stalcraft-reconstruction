/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class jxtc
implements zhos {
    public final cvzo _c;

    public jxtc(cvzo cvzo2) {
        this._c = cvzo2;
    }

    @Override
    public boolean func_82704_a(Entity entity) {
        if (!entity.func_70089_S()) {
            return false;
        }
        if (!(entity instanceof EntityLivingBase)) {
            return false;
        }
        EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
        if (entityLivingBase.func_71124_b(EntityLiving.func_82159_b(this._c)) != null) {
            return false;
        }
        if (entityLivingBase instanceof EntityLiving) {
            return ((EntityLiving)entityLivingBase).func_98052_bS();
        }
        return entityLivingBase instanceof EntityPlayer;
    }
}

