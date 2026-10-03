/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.antirelog;

import gloomyfolken.mods.core.main.GloomyCore;
import net.minecraft.entity.player.EntityPlayer;

public class eidj
extends tehy {
    public static final String _a = "AntiRelog";
    private static int _c = GloomyCore.config._a("relog_timer", 1200);
    public bqwg<Boolean> _b;
    private int _d = _c;

    public eidj(ccxr ccxr2) {
        super(ccxr2);
        this._b = new bqwg.kjui<Boolean>(ccxr2, "qt", false)._a()._f();
    }

    public static eidj _a(EntityPlayer entityPlayer) {
        return (eidj)ncwh._a((EntityPlayer)entityPlayer)._h.get(_a);
    }
}

