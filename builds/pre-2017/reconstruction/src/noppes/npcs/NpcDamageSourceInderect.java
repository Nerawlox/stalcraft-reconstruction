/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSourceIndirect;

public class NpcDamageSourceInderect
extends EntityDamageSourceIndirect {
    public NpcDamageSourceInderect(String string, Entity entity, Entity entity2) {
        super(string, entity, entity2);
    }

    @Override
    public boolean isDifficultyScaled() {
        return false;
    }
}

