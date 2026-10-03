/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.crash;

import java.util.concurrent.Callable;
import net.minecraft.block.Block;

public final class eidj
implements Callable {
    public final /* synthetic */ int _a;

    public eidj(int n) {
        this._a = n;
    }

    public String _a() {
        try {
            return String.format("ID #%d (%s // %s)", this._a, Block.blocksList[this._a].getUnlocalizedName(), Block.blocksList[this._a].getClass().getCanonicalName());
        }
        catch (Throwable throwable) {
            return "ID #" + this._a;
        }
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

