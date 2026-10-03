/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class ezey
implements IEntitySelector {
    public final /* synthetic */ EntityAIAvoidEntity _c;

    public ezey(EntityAIAvoidEntity entityAIAvoidEntity) {
        this._c = entityAIAvoidEntity;
    }

    @Override
    public boolean isEntityApplicable(Entity entity) {
        return entity.isEntityAlive() && EntityAIAvoidEntity._a(this._c).getEntitySenses()._a(entity);
    }
}

