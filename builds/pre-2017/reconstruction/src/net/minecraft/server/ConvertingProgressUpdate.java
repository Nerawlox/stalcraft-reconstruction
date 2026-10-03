/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.sajz;

public class ConvertingProgressUpdate
implements sajz {
    public long _a = MinecraftServer.__aq();
    public final /* synthetic */ MinecraftServer _b;

    public ConvertingProgressUpdate(MinecraftServer minecraftServer) {
        this._b = minecraftServer;
    }

    @Override
    public void _b(String string) {
    }

    @Override
    public void _a(int n) {
        if (MinecraftServer.__aq() - this._a >= 1000L) {
            this._a = MinecraftServer.__aq();
            this._b._O()._a("Converting... " + n + "%");
        }
    }

    @Override
    public void _d(String string) {
    }
}

