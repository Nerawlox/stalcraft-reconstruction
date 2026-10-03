/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.core.main.GloomyCore;
import gloomyfolken.mods.core.misc.kjui;
import gloomyfolken.mods.core.misc.tdmn;
import gloomyfolken.mods.core.misc.xpzm;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import org.jetbrains.annotations.NotNull;

public class pidb {
    public static ArrayList<gloomyfolken.mods.core.misc.kjui> _a = new ArrayList();

    public static boolean _a(cvzo cvzo2) {
        return pidb._a(cvzo2, null);
    }

    public static boolean _a(cvzo cvzo2, EntityPlayer entityPlayer) {
        return pidb._a(cvzo2, entityPlayer, -1);
    }

    public static boolean _a(cvzo cvzo2, EntityPlayer entityPlayer, int n) {
        if (pidb._b(cvzo2)) {
            return true;
        }
        return _a.stream().anyMatch(kjui2 -> kjui2.getBindState(cvzo2, entityPlayer, n) != kjui.kjui._a);
    }

    public static kjui.kjui _b(@NotNull cvzo cvzo2, EntityPlayer entityPlayer, int n) {
        if (cvzo2 == null) {
            pidb._a(0);
        }
        kjui.kjui kjui2 = kjui.kjui._a;
        for (gloomyfolken.mods.core.misc.kjui kjui3 : _a) {
            kjui.kjui kjui4 = kjui3.getBindState(cvzo2, entityPlayer, n);
            if (kjui4.ordinal() <= kjui2.ordinal()) continue;
            kjui2 = kjui4;
        }
        return kjui2;
    }

    public static boolean _b(cvzo cvzo2, EntityPlayer entityPlayer) {
        return pidb._b(cvzo2, entityPlayer, 1) == kjui.kjui._c;
    }

    public static void _c(cvzo cvzo2, EntityPlayer entityPlayer) {
        if (cvzo2 == null) {
            return;
        }
        kjui.kjui kjui2 = pidb._b(cvzo2, entityPlayer, 1);
        if (kjui2 == kjui.kjui._f) {
            long l = pidb._c(cvzo2);
            cvzo2._e._p("personal_until");
            if (l < 0L || l < System.currentTimeMillis()) {
                cvzo2._e._p("owner");
            }
        } else if (!pidb._b(cvzo2) && pidb._b(cvzo2, entityPlayer)) {
            pidb._a(cvzo2, entityPlayer.field_71092_bJ);
        }
    }

    public static boolean _b(cvzo cvzo2) {
        return pidb._e(cvzo2) != null;
    }

    public static long _c(cvzo cvzo2) {
        qoac qoac2 = cvzo2._e;
        return qoac2 != null && qoac2._c("personal_until") ? qoac2._g("personal_until") : -1L;
    }

    public static boolean _d(cvzo cvzo2) {
        long l = pidb._c(cvzo2);
        if (l > 0L && l < System.currentTimeMillis()) {
            cvzo2._e._p("personal_until");
            cvzo2._e._p("owner");
            return true;
        }
        return false;
    }

    public static String _e(cvzo cvzo2) {
        String string;
        if (cvzo2._a() instanceof xpzm && (string = ((xpzm)((Object)cvzo2._a()))._f(cvzo2)) != null) {
            return string;
        }
        return cvzo2._e == null || !cvzo2._e._c("owner") ? null : cvzo2._e._j("owner");
    }

    public static void _a(cvzo cvzo2, String string) {
        qoac qoac2 = ncwh._b(cvzo2);
        qoac2._p("no_drop");
        qoac2._p("personal_on_use");
        qoac2._p("personal_on_get");
        qoac2._a("owner", string);
    }

    public static boolean _a(mssh mssh2) {
        for (gloomyfolken.mods.core.misc.kjui kjui2 : _a) {
            if (!kjui2.isInventoryPersonal(mssh2)) continue;
            return true;
        }
        return false;
    }

    static {
        _a.add(new ezey());
        _a.add(new kjui());
        _a.add(new pidb());
        if (!GloomyCore.ignoreDefaultNondrop) {
            _a.add(new eidj());
        }
    }

    private static /* synthetic */ void _a(int n) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "stack", "gloomyfolken/mods/core/misc/BindManager", "getBindState"));
    }

    private static class pidb
    extends gloomyfolken.mods.core.misc.kjui {
        private pidb() {
        }

        @Override
        public boolean isInventoryPersonal(mssh mssh2) {
            return mssh2 instanceof net.minecraft.entity.player.eidj || mssh2 instanceof tgfn;
        }
    }

    private static class eidj
    extends gloomyfolken.mods.core.misc.kjui {
        private eidj() {
        }

        @Override
        public kjui.kjui getBindState(cvzo cvzo2, EntityPlayer entityPlayer, int n) {
            if (cvzo2._a() instanceof tdmn) {
                return ((tdmn)((Object)cvzo2._a()))._c(cvzo2);
            }
            return kjui.kjui._a;
        }
    }

    private static class ezey
    extends gloomyfolken.mods.core.misc.kjui {
        private ezey() {
        }

        @Override
        public kjui.kjui getBindState(cvzo cvzo2, EntityPlayer entityPlayer, int n) {
            if (pidb._c(cvzo2) > 0L) {
                return kjui.kjui._f;
            }
            if (pidb._e(cvzo2) != null) {
                return kjui.kjui._e;
            }
            if (cvzo2._e != null) {
                for (int i = kjui.kjui._g.length - 1; i >= 0; --i) {
                    kjui.kjui kjui2 = kjui.kjui._g[i];
                    if (kjui2._h == null || !cvzo2._q()._o(kjui2._h)) continue;
                    return kjui2;
                }
            }
            return kjui.kjui._a;
        }
    }

    private static class kjui
    extends gloomyfolken.mods.core.misc.kjui {
        private kjui() {
        }

        @Override
        public kjui.kjui getBindState(cvzo cvzo2, EntityPlayer entityPlayer, int n) {
            hbbj hbbj2 = GloomyCore.config;
            return !GloomyCore.enableItemDrop || hbbj2._b.contains(cvzo2._d) ? kjui.kjui._b : kjui.kjui._a;
        }
    }
}

