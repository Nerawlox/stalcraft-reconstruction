/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.concurrent.Callable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.jgro;

public class eidj
implements Callable {
    public final /* synthetic */ Entity _a;

    public eidj(Entity entity) {
        this._a = entity;
    }

    public String _a() {
        return jgro._b(this._a) + " (" + this._a.getClass().getCanonicalName() + ")";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

