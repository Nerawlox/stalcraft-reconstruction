/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSource;

public class NpcDamageSource
extends EntityDamageSource {
    public NpcDamageSource(String string, Entity entity) {
        super(string, entity);
    }

    @Override
    public boolean isDifficultyScaled() {
        return false;
    }
}

