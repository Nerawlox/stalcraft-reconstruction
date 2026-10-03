/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import java.util.UUID;
import java.util.function.Function;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public enum sajh {
    _a(string -> "\u041a\u0443\u043f\u0438\u043b: " + string, false),
    _b(string -> "\u041f\u043e\u043b\u0443\u0447\u0435\u043d \u0438\u0437 \u043a\u0435\u0439\u0441\u0430 \"" + string + "\"", true),
    _c(string -> "\u041f\u0440\u0438\u043e\u0431\u0440\u0435\u043b \u0443: " + string, false),
    _d(string -> "\u041f\u043e\u043b\u0443\u0447\u0438\u043b \u0437\u0430: " + string, false),
    _e(string -> "\u0412\u044b\u043f\u0430\u043b \u0438\u0437: " + string, false),
    _f(string -> "\u0412\u044b\u043f\u0430\u043b \u0438\u0437: " + string, false),
    _g,
    _h(string -> "\u0412\u044b\u0434\u0430\u043d: " + string, false),
    _i,
    _j(string -> "\u0417\u0430\u0441\u043f\u0430\u0432\u043d\u0435\u043d \u043d\u0430: " + string, false),
    _k(string -> "\u041e\u0442\u043a\u0440\u044b\u043b \u043a\u0435\u0439\u0441 \u0437\u0430\u0445\u0432\u0430\u0442\u0430: " + string, false),
    _l(string -> "\u041f\u043e\u043b\u0443\u0447\u0435\u043d \u0443: " + string, false),
    _m(string -> "\u041e\u0431\u043c\u0435\u043d\u0435\u043d \u0443: " + string, false),
    _n;

    public static sajh[] _o;
    private Function<String, String> _q = Function.identity();
    public final boolean _p;

    private sajh() {
        this._p = false;
    }

    private sajh(Function<String, String> function, boolean bl) {
        this._q = function;
        this._p = bl;
    }

    public String _a(String string) {
        if (string == null) {
            return "";
        }
        return this._q.apply(string);
    }

    public ItemStack _a(ItemStack itemStack, String string, boolean bl) {
        if (itemStack == null || !bl && itemStack._e()) {
            return itemStack;
        }
        this._a(itemStack);
        itemStack._e._a("src", (byte)this.ordinal());
        if (string != null) {
            itemStack._e._a("sm", string);
        }
        return itemStack;
    }

    public ItemStack _a(ItemStack itemStack) {
        sajh._c(itemStack);
        UUID uUID = UUID.randomUUID();
        itemStack._e._a("u1", uUID.getMostSignificantBits());
        itemStack._e._a("u2", uUID.getLeastSignificantBits());
        return itemStack;
    }

    public static sajh _b(ItemStack itemStack) {
        if (itemStack._q() == null || !itemStack._q()._c("src")) {
            return null;
        }
        return sajh.values()[itemStack._q()._d("src")];
    }

    public static ItemStack _c(ItemStack itemStack) {
        if (itemStack._e == null) {
            itemStack._d(new NBTTagCompound());
        }
        return itemStack;
    }

    static {
        _o = sajh.values();
    }
}

