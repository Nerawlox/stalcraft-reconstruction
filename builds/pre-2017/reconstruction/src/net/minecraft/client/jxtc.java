/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

public class jxtc
implements Callable {
    public final /* synthetic */ Minecraft _a;

    public jxtc(Minecraft minecraft) {
        this._a = minecraft;
    }

    public String _a() {
        return "Client (map_client.txt)";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

