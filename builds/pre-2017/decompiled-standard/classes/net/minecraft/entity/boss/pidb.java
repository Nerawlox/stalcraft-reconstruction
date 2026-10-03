/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.boss;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.vjta;

public final class pidb
implements zhos {
    @Override
    public boolean func_82704_a(Entity entity) {
        return entity instanceof EntityLivingBase && ((EntityLivingBase)entity).func_70668_bt() != vjta._b;
    }
}

