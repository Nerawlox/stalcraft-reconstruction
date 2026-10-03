/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.util.concurrent.Callable;

public final class kjui
implements Callable {
    public final /* synthetic */ int _a;

    public kjui(int n) {
        this._a = n;
    }

    public String _a() {
        if (this._a < 0) {
            return "Unknown? (Got " + this._a + ")";
        }
        String string = String.format("%4s", Integer.toBinaryString(this._a)).replace(" ", "0");
        return String.format("%1$d / 0x%1$X / 0b%2$s", this._a, string);
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

