/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import java.util.Comparator;
import net.minecraft.entity.Entity;

public class dwbf
implements Comparator {
    public final Entity _a;

    public dwbf(Entity entity) {
        this._a = entity;
    }

    public int _a(Entity entity, Entity entity2) {
        double d;
        double d2 = this._a.getDistanceSqToEntity(entity);
        if (d2 < (d = this._a.getDistanceSqToEntity(entity2))) {
            return -1;
        }
        if (d2 > d) {
            return 1;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this._a((Entity)object, (Entity)object2);
    }
}

