/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.brushedit;

import gloomyfolken.mods.brushedit.eidj;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;

public class pidb
extends tehy {
    public static final String _a = "brush";
    public HashMap<String, eidj> _b = new HashMap();
    public eidj _c;
    public einh _d;
    public einh _e;

    public pidb(ccxr ccxr2) {
        super(ccxr2);
    }

    public static pidb _a(EntityPlayer entityPlayer) {
        return (pidb)ncwh._a((EntityPlayer)entityPlayer)._h.get(_a);
    }
}

