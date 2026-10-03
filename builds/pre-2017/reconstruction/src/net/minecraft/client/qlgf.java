/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

public class qlgf
implements Callable {
    public final /* synthetic */ Minecraft _a;

    public qlgf(Minecraft minecraft) {
        this._a = minecraft;
    }

    public String _a() {
        return this._a._M.skin;
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

