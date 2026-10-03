/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.trade;

import java.util.concurrent.TimeUnit;
import net.minecraft.entity.player.EntityPlayer;

public class tupg
extends tehy {
    public static final String _a = "trade";
    public String _b;
    public long _c = -1L;

    public tupg(ccxr ccxr2) {
        super(ccxr2);
    }

    public static tupg _a(EntityPlayer entityPlayer) {
        return (tupg)ncwh._a((EntityPlayer)entityPlayer)._h.get(_a);
    }

    public boolean _a() {
        return this._c == -1L || System.currentTimeMillis() - this._c > TimeUnit.SECONDS.toMillis(10L);
    }
}

