/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.pibk;

public class pzdf
implements zhos {
    public final /* synthetic */ zhos _c;
    public final /* synthetic */ pibk _d;

    public pzdf(pibk pibk2, zhos zhos2) {
        this._d = pibk2;
        this._c = zhos2;
    }

    @Override
    public boolean func_82704_a(Entity entity) {
        if (!(entity instanceof EntityLivingBase)) {
            return false;
        }
        if (this._c != null && !this._c.func_82704_a(entity)) {
            return false;
        }
        return this._d.func_75296_a((EntityLivingBase)entity, false);
    }
}

