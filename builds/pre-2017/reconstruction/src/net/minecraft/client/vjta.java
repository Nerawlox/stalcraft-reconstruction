/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import java.util.concurrent.Callable;
import net.minecraft.client.Minecraft;

public class vjta
implements Callable {
    public final /* synthetic */ Minecraft _a;

    public vjta(Minecraft minecraft) {
        this._a = minecraft;
    }

    public String _a() {
        int n = this._a._r.getWorldVec3Pool()._c();
        int n2 = 56 * n;
        int n3 = n2 / 1024 / 1024;
        int n4 = this._a._r.getWorldVec3Pool()._d();
        int n5 = 56 * n4;
        int n6 = n5 / 1024 / 1024;
        return n + " (" + n2 + " bytes; " + n3 + " MB) allocated, " + n4 + " (" + n5 + " bytes; " + n6 + " MB) used";
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

