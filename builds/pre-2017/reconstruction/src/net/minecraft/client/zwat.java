/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;
import org.lwjgl.Sys;

public class zwat
implements Callable {
    public final /* synthetic */ Minecraft _a;

    public zwat(Minecraft minecraft) {
        this._a = minecraft;
    }

    public String _a() {
        return Sys.getVersion();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

