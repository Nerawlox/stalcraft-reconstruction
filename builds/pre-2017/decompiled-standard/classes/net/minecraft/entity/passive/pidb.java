/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;

public final class pidb
implements zhos {
    @Override
    public boolean func_82704_a(Entity entity) {
        return entity instanceof EntityHorse && ((EntityHorse)entity).func_110205_ce();
    }
}

