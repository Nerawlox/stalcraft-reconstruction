/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class flht {
    public EntityLiving _a;
    public List _b = new ArrayList();
    public List _c = new ArrayList();

    public flht(EntityLiving entityLiving) {
        this._a = entityLiving;
    }

    public void _a() {
        this._b.clear();
        this._c.clear();
    }

    public boolean _a(Entity entity) {
        if (this._b.contains(entity)) {
            return true;
        }
        if (this._c.contains(entity)) {
            return false;
        }
        this._a.field_70170_p.field_72984_F._a("canSee");
        boolean bl = this._a.func_70685_l(entity);
        this._a.field_70170_p.field_72984_F._b();
        if (bl) {
            this._b.add(entity);
        } else {
            this._c.add(entity);
        }
        return bl;
    }
}

