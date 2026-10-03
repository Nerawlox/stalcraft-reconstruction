/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.faction;

import gloomyfolken.bundle.common.core.tupg;
import net.minecraft.entity.player.EntityPlayer;

public class pidb
extends tehy {
    private bqwg<tupg> _b;
    public static final String _a = "faction_handler";

    public pidb(ccxr ccxr2) {
        super(ccxr2);
        this._b = new bqwg.kjui<tupg>(ccxr2, "faction", tupg._a)._b()._a()._f();
    }

    public static pidb _a(ccxr ccxr2) {
        return (pidb)ccxr2._h.get(_a);
    }

    public static pidb _a(EntityPlayer entityPlayer) {
        return pidb._a(ncwh._a(entityPlayer));
    }

    public tupg _a() {
        return this._b._b();
    }
}

