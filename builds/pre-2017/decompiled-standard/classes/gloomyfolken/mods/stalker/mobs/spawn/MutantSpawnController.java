/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.spawn;

import gloomyfolken.mods.stalker.mobs.entity.EntityMutant;
import net.minecraft.entity.EntityLiving;

public interface MutantSpawnController
extends ivki {
    default public void onEntitySpawned(EntityLiving entityLiving) {
        if (entityLiving != null) {
            ((EntityMutant)entityLiving).setNightCreature(this.getConfiguration().getDayOfTimeType() == 2);
        }
    }
}

