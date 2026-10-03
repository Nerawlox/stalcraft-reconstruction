/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.tupg;
import java.util.EnumSet;
import net.minecraft.entity.player.EntityPlayer;

public class jgro
extends tehy {
    public static final String _a = "respawn";
    private static final int _j = 600;
    public static final int _b = 10;
    public static final int _c = -10;
    public bqwg<Integer> _d;
    public int _e = -1;
    public double _f = -1.0;
    public int _g = -1;
    private boolean _k = false;
    public int _h = -1;
    public kjui _i;
    private boolean _l = true;

    public jgro(ccxr ccxr2) {
        super(ccxr2);
        this._d = new bqwg.kjui<Integer>(ccxr2, "dc", 0)._b()._f();
        if (!ccxr2._a.worldObj.isRemote) {
            InvokeSideOnly.frontend(() -> {});
        }
    }

    public int _a() {
        return this._d._b();
    }

    public static jgro _a(ccxr ccxr2) {
        return (jgro)ccxr2._h.get(_a);
    }

    public static jgro _a(EntityPlayer entityPlayer) {
        return jgro._a(ncwh._a(entityPlayer));
    }

    public static class kjui {
        public String _a = "\u0437\u0430\u0431\u044b\u043b\u0438 \u0438\u043c\u044f";
        public hrvl _b;
        public int _c = 30;
        public boolean _d;
        public boolean _e = true;
        public EnumSet<tupg> _f = EnumSet.allOf(tupg.class);

        public String toString() {
            return "SavepointProps{name='" + this._a + '\'' + ", respawnLoc=" + this._b + ", radius=" + this._c + ", force=" + this._d + ", showIcon=" + this._e + ", factions=" + this._f + '}';
        }
    }
}

