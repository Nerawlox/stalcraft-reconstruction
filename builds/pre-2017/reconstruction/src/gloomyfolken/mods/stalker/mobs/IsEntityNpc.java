/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs;

import net.minecraft.entity.Entity;
import noppes.npcs.entity.EntityNPCHumanMale;

public class IsEntityNpc {
    public static boolean andIsMale(Entity entity) {
        return entity instanceof EntityNPCHumanMale;
    }
}

