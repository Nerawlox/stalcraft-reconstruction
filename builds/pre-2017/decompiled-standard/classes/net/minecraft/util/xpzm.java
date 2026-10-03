/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import java.util.Random;

public class xpzm {
    public static final xpzm _a = new xpzm();
    public Random _b = new Random();
    public String[] _c = "the elder scrolls klaatu berata niktu xyzzy bless curse light darkness fire air earth water hot dry cold wet ignite snuff embiggen twist shorten stretch fiddle destroy imbue galvanize enchant free limited range of towards inside sphere cube self other ball mental physical grow shrink demon elemental spirit animal creature beast humanoid undead fresh stale ".split(" ");

    public String _a() {
        int n = this._b.nextInt(2) + 3;
        String string = "";
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                string = string + " ";
            }
            string = string + this._c[this._b.nextInt(this._c.length)];
        }
        return string;
    }

    public void _a(long l) {
        this._b.setSeed(l);
    }
}

