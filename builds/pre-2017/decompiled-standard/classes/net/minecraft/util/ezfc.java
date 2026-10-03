/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public enum ezfc {
    _a('0'),
    _b('1'),
    _c('2'),
    _d('3'),
    _e('4'),
    _f('5'),
    _g('6'),
    _h('7'),
    _i('8'),
    _j('9'),
    _k('a'),
    _l('b'),
    _m('c'),
    _n('d'),
    _o('e'),
    _p('f'),
    _q('k', true),
    _r('l', true),
    _s('m', true),
    _t('n', true),
    _u('o', true),
    _v('r');

    public static final Map _w;
    public static final Map _x;
    public static final Pattern _y;
    public final char _z;
    public final boolean _A;
    public final String _B;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public ezfc() {
        this((String)var1_-1, (int)var2_-1, (char)var3_1, false);
        void var3_1;
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - void declaration
     */
    public ezfc() {
        void var4_2;
        void var3_1;
        this._z = var3_1;
        this._A = var4_2;
        this._B = "\u00a7" + (char)var3_1;
    }

    public char _a() {
        return this._z;
    }

    public boolean _b() {
        return this._A;
    }

    public boolean _c() {
        return !this._A && this != _v;
    }

    public String _d() {
        return this.name().toLowerCase();
    }

    public String toString() {
        return this._B;
    }

    public static String _a(String string) {
        return string == null ? null : _y.matcher(string).replaceAll("");
    }

    public static ezfc _b(String string) {
        if (string == null) {
            return null;
        }
        return (ezfc)((Object)_x.get(string.toLowerCase()));
    }

    public static Collection _a(boolean bl, boolean bl2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (ezfc ezfc2 : ezfc.values()) {
            if (ezfc2._c() && !bl || ezfc2._b() && !bl2) continue;
            arrayList.add(ezfc2._d());
        }
        return arrayList;
    }

    static {
        _w = new HashMap();
        _x = new HashMap();
        _y = Pattern.compile("(?i)" + String.valueOf('\u00a7') + "[0-9A-FK-OR]");
        for (ezfc ezfc2 : ezfc.values()) {
            _w.put(Character.valueOf(ezfc2._a()), ezfc2);
            _x.put(ezfc2._d(), ezfc2);
        }
    }
}

