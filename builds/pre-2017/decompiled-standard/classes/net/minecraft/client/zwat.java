/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.xpzm;
import org.lwjgl.Sys;

public class zwat
implements Callable {
    public final /* synthetic */ xpzm _a;

    public zwat(xpzm xpzm2) {
        this._a = xpzm2;
    }

    public String _a() {
        return Sys.getVersion();
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

