/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.Entity;

public class kjui
implements Callable {
    public final /* synthetic */ Entity _a;

    public kjui(Entity entity) {
        this._a = entity;
    }

    public String _a() {
        return this._a.getEntityName();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

