/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.ezey;

public final class eidj
implements IEntitySelector {
    @Override
    public boolean isEntityApplicable(Entity entity) {
        return entity instanceof ezey;
    }
}

