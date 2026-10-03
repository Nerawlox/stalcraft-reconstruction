/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

public class pidb
implements Callable {
    public final /* synthetic */ Minecraft _a;

    public pidb(Minecraft minecraft) {
        this._a = minecraft;
    }

    public String _a() {
        return this._a.__ah._c ? this._a.__ah._c() : "N/A (disabled)";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

