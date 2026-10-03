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
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import org.jetbrains.annotations.NotNull;

public class pidb {
    public static ArrayList<gloomyfolken.mods.core.misc.kjui> _a = new ArrayList();

    public static boolean _a(ItemStack itemStack) {
        return pidb._a(itemStack, null);
    }

    public static boolean _a(ItemStack itemStack, EntityPlayer entityPlayer) {
        return pidb._a(itemStack, entityPlayer, -1);
    }

    public static boolean _a(ItemStack itemStack, EntityPlayer entityPlayer, int n) {
        if (pidb._b(itemStack)) {
            return true;
        }
        return _a.stream().anyMatch(kjui2 -> kjui2.getBindState(itemStack, entityPlayer, n) != kjui.kjui._a);
    }

    public static kjui.kjui _b(@NotNull ItemStack itemStack, EntityPlayer entityPlayer, int n) {
        if (itemStack == null) {
            pidb._a(0);
        }
        kjui.kjui kjui2 = kjui.kjui._a;
        for (gloomyfolken.mods.core.misc.kjui kjui3 : _a) {
            kjui.kjui kjui4 = kjui3.getBindState(itemStack, entityPlayer, n);
            if (kjui4.ordinal() <= kjui2.ordinal()) continue;
            kjui2 = kjui4;
        }
        return kjui2;
    }

    public static boolean _b(ItemStack itemStack, EntityPlayer entityPlayer) {
        return pidb._b(itemStack, entityPlayer, 1) == kjui.kjui._c;
    }

    public static void _c(ItemStack itemStack, EntityPlayer entityPlayer) {
        if (itemStack == null) {
            return;
        }
        kjui.kjui kjui2 = pidb._b(itemStack, entityPlayer, 1);
        if (kjui2 == kjui.kjui._f) {
            long l = pidb._c(itemStack);
            itemStack._e._p("personal_until");
            if (l < 0L || l < System.currentTimeMillis()) {
                itemStack._e._p("owner");
            }
        } else if (!pidb._b(itemStack) && pidb._b(itemStack, entityPlayer)) {
            pidb._a(itemStack, entityPlayer.username);
        }
    }

    public static boolean _b(ItemStack itemStack) {
        return pidb._e(itemStack) != null;
    }

    public static long _c(ItemStack itemStack) {
        NBTTagCompound nBTTagCompound = itemStack._e;
        return nBTTagCompound != null && nBTTagCompound._c("personal_until") ? nBTTagCompound._g("personal_until") : -1L;
    }

    public static boolean _d(ItemStack itemStack) {
        long l = pidb._c(itemStack);
        if (l > 0L && l < System.currentTimeMillis()) {
            itemStack._e._p("personal_until");
            itemStack._e._p("owner");
            return true;
        }
        return false;
    }

    public static String _e(ItemStack itemStack) {
        String string;
        if (itemStack._a() instanceof xpzm && (string = ((xpzm)((Object)itemStack._a()))._f(itemStack)) != null) {
            return string;
        }
        return itemStack._e == null || !itemStack._e._c("owner") ? null : itemStack._e._j("owner");
    }

    public static void _a(ItemStack itemStack, String string) {
        NBTTagCompound nBTTagCompound = ncwh._b(itemStack);
        nBTTagCompound._p("no_drop");
        nBTTagCompound._p("personal_on_use");
        nBTTagCompound._p("personal_on_get");
        nBTTagCompound._a("owner", string);
    }

    public static boolean _a(IInventory iInventory) {
        for (gloomyfolken.mods.core.misc.kjui kjui2 : _a) {
            if (!kjui2.isInventoryPersonal(iInventory)) continue;
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
        public boolean isInventoryPersonal(IInventory iInventory) {
            return iInventory instanceof InventoryPlayer || iInventory instanceof InventoryEnderChest;
        }
    }

    private static class eidj
    extends gloomyfolken.mods.core.misc.kjui {
        private eidj() {
        }

        @Override
        public kjui.kjui getBindState(ItemStack itemStack, EntityPlayer entityPlayer, int n) {
            if (itemStack._a() instanceof tdmn) {
                return ((tdmn)((Object)itemStack._a()))._c(itemStack);
            }
            return kjui.kjui._a;
        }
    }

    private static class ezey
    extends gloomyfolken.mods.core.misc.kjui {
        private ezey() {
        }

        @Override
        public kjui.kjui getBindState(ItemStack itemStack, EntityPlayer entityPlayer, int n) {
            if (pidb._c(itemStack) > 0L) {
                return kjui.kjui._f;
            }
            if (pidb._e(itemStack) != null) {
                return kjui.kjui._e;
            }
            if (itemStack._e != null) {
                for (int i = kjui.kjui._g.length - 1; i >= 0; --i) {
                    kjui.kjui kjui2 = kjui.kjui._g[i];
                    if (kjui2._h == null || !itemStack._q()._o(kjui2._h)) continue;
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
        public kjui.kjui getBindState(ItemStack itemStack, EntityPlayer entityPlayer, int n) {
            hbbj hbbj2 = GloomyCore.config;
            return !GloomyCore.enableItemDrop || hbbj2._b.contains(itemStack._d) ? kjui.kjui._b : kjui.kjui._a;
        }
    }
}

