/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.eidj;

public class ezey
implements zhos {
    public final /* synthetic */ eidj _c;

    public ezey(eidj eidj2) {
        this._c = eidj2;
    }

    @Override
    public boolean func_82704_a(Entity entity) {
        return entity.func_70089_S() && eidj._a(this._c).func_70635_at()._a(entity);
    }
}

