/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

public class tupg
implements Callable {
    public final /* synthetic */ Minecraft _a;

    public tupg(Minecraft minecraft) {
        this._a = minecraft;
    }

    public String _a() {
        return this._a._B.getClass().getCanonicalName();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

