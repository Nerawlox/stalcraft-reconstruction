/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

public class zwaw
implements Callable {
    public final /* synthetic */ Minecraft _a;

    public zwaw(Minecraft minecraft) {
        this._a = minecraft;
    }

    public String _a() {
        return Minecraft._a(this._a);
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

