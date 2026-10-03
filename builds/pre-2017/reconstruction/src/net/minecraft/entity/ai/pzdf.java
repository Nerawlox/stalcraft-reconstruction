/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.pibk;

public class pzdf
implements IEntitySelector {
    public final /* synthetic */ IEntitySelector _c;
    public final /* synthetic */ pibk _d;

    public pzdf(pibk pibk2, IEntitySelector iEntitySelector) {
        this._d = pibk2;
        this._c = iEntitySelector;
    }

    @Override
    public boolean isEntityApplicable(Entity entity) {
        if (!(entity instanceof EntityLivingBase)) {
            return false;
        }
        if (this._c != null && !this._c.isEntityApplicable(entity)) {
            return false;
        }
        return this._d.isSuitableTarget((EntityLivingBase)entity, false);
    }
}

