/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

public class eidj
implements Callable {
    public final /* synthetic */ Minecraft _a;

    public eidj(Minecraft minecraft) {
        this._a = minecraft;
    }

    public String _a() {
        return Minecraft._b(this._a)._c().toString();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

