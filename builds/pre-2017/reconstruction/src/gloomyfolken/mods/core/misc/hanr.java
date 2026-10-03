/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.core.misc.sajh;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;

public enum hanr {
    _a("COMMON", "\u041e\u0431\u044b\u0447\u043d\u044b\u0439", EnumChatFormatting._p),
    _b("UNCOMMON", "\u041d\u0435\u043e\u0431\u044b\u0447\u043d\u044b\u0439", EnumChatFormatting._l),
    _c("SPECIAL", "\u041e\u0441\u043e\u0431\u044b\u0439", EnumChatFormatting._j),
    _d("RARE", "\u0420\u0435\u0434\u043a\u0438\u0439", EnumChatFormatting._n),
    _e("EXCLUSIVE", "\u0418\u0441\u043a\u043b\u044e\u0447\u0438\u0442\u0435\u043b\u044c\u043d\u044b\u0439", EnumChatFormatting._f),
    _f("LEGENDARY", "\u041b\u0435\u0433\u0435\u043d\u0434\u0430\u0440\u043d\u044b\u0439", EnumChatFormatting._m),
    _g("UNIQUE", "\u0423\u043d\u0438\u043a\u0430\u043b\u044c\u043d\u044b\u0439", EnumChatFormatting._g);

    public static final Map<String, hanr> _h;
    public final String _i;
    public final String _j;
    public final EnumChatFormatting _k;
    public final int _l;
    public static final String _m = "rar";
    public static final hanr[] _n;

    private hanr(String string2, String string3, EnumChatFormatting enumChatFormatting) {
        this._i = string2;
        this._j = string3;
        this._k = enumChatFormatting;
        this._l = hanr._a(enumChatFormatting);
    }

    public static boolean _a(ItemStack itemStack) {
        return itemStack != null && itemStack._e != null && itemStack._e._c(_m);
    }

    public static hanr _b(ItemStack itemStack) {
        if (!hanr._a(itemStack)) {
            return _a;
        }
        return _n[Math.min(_n.length, itemStack._e._d(_m))];
    }

    public static int _a(NBTTagCompound nBTTagCompound) {
        return nBTTagCompound != null ? (int)nBTTagCompound._d(_m) : 0;
    }

    public static EnumChatFormatting _c(ItemStack itemStack) {
        return hanr._b((ItemStack)itemStack)._k;
    }

    public static ItemStack _a(ItemStack itemStack, hanr hanr2) {
        sajh._c((ItemStack)itemStack)._e._a(_m, (byte)hanr2.ordinal());
        return itemStack;
    }

    public static NBTTagCompound _a(NBTTagCompound nBTTagCompound, hanr hanr2) {
        nBTTagCompound._a(_m, (byte)hanr2.ordinal());
        return nBTTagCompound;
    }

    private static int _a(EnumChatFormatting enumChatFormatting) {
        int n = enumChatFormatting.ordinal();
        int n2 = (n >> 3 & 1) * 85;
        int n3 = (n >> 2 & 1) * 170 + n2;
        int n4 = (n >> 1 & 1) * 170 + n2;
        int n5 = (n >> 0 & 1) * 170 + n2;
        if (n == 6) {
            n3 += 85;
        }
        return (n3 & 0xFF) << 16 | (n4 & 0xFF) << 8 | n5 & 0xFF;
    }

    static {
        _h = new HashMap<String, hanr>();
        for (hanr hanr2 : hanr.values()) {
            _h.put(hanr2._i, hanr2);
        }
        _n = hanr.values();
    }
}

