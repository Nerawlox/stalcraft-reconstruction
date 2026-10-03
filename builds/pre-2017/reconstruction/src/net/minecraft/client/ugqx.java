/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

public class ugqx
implements Callable {
    public final /* synthetic */ Minecraft _a;

    public ugqx(Minecraft minecraft) {
        this._a = minecraft;
    }

    public String _a() {
        return this._a._B.getClass().getCanonicalName();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

