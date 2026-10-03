/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import net.minecraft.entity.Entity;
import noppes.npcs.EntityNPCInterface;

public class CustomHooks {
    public static boolean onSpawnParticle(String string, Entity entity) {
        return string.equals("blood") && entity instanceof EntityNPCInterface && !((EntityNPCInterface)entity).display.bloodStains;
    }
}

