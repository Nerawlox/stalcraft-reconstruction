/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import gloomyfolken.mods.asm.GloomyHooks;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.util.pibn;

public class IntHashMap {
    public transient pibn[] _a;
    public transient int _b;
    public int _c = 12;
    public final float _d;
    public volatile transient int _e;
    public Set _f = new HashSet();

    public IntHashMap() {
        this._d = 0.75f;
        this._a = new pibn[16];
    }

    public static int _a(int n) {
        n ^= n >>> 20 ^ n >>> 12;
        return n ^ n >>> 7 ^ n >>> 4;
    }

    public static int _a(int n, int n2) {
        return n & n2 - 1;
    }

    public Object _b(int n) {
        int n2 = IntHashMap._a(n);
        pibn pibn2 = this._a[IntHashMap._a(n2, this._a.length)];
        while (pibn2 != null) {
            if (pibn2._a == n) {
                return pibn2._b;
            }
            pibn2 = pibn2._c;
        }
        return null;
    }

    public boolean _c(int n) {
        return this._d(n) != null;
    }

    public final pibn _d(int n) {
        int n2 = IntHashMap._a(n);
        pibn pibn2 = this._a[IntHashMap._a(n2, this._a.length)];
        while (pibn2 != null) {
            if (pibn2._a == n) {
                return pibn2;
            }
            pibn2 = pibn2._c;
        }
        return null;
    }

    public void _a(int n, Object object) {
        GloomyHooks.addKey(this, n, object);
    }

    public void _e(int n) {
        pibn[] pibnArray = this._a;
        int n2 = pibnArray.length;
        if (n2 == 0x40000000) {
            this._c = Integer.MAX_VALUE;
            return;
        }
        pibn[] pibnArray2 = new pibn[n];
        this._a(pibnArray2);
        this._a = pibnArray2;
        this._c = (int)((float)n * this._d);
    }

    public void _a(pibn[] pibnArray) {
        pibn[] pibnArray2 = this._a;
        int n = pibnArray.length;
        for (int i = 0; i < pibnArray2.length; ++i) {
            pibn pibn2;
            pibn pibn3 = pibnArray2[i];
            if (pibn3 == null) continue;
            pibnArray2[i] = null;
            do {
                pibn2 = pibn3._c;
                int n2 = IntHashMap._a(pibn3._d, n);
                pibn3._c = pibnArray[n2];
                pibnArray[n2] = pibn3;
            } while ((pibn3 = pibn2) != null);
        }
    }

    public Object _f(int n) {
        Object object = GloomyHooks.removeObject(this, n);
        return object;
    }

    public final pibn _g(int n) {
        pibn pibn2;
        int n2 = IntHashMap._a(n);
        int n3 = IntHashMap._a(n2, this._a.length);
        pibn pibn3 = pibn2 = this._a[n3];
        while (pibn3 != null) {
            pibn pibn4 = pibn3._c;
            if (pibn3._a == n) {
                ++this._e;
                --this._b;
                if (pibn2 == pibn3) {
                    this._a[n3] = pibn4;
                } else {
                    pibn2._c = pibn4;
                }
                return pibn3;
            }
            pibn2 = pibn3;
            pibn3 = pibn4;
        }
        return pibn3;
    }

    public void _a() {
        ++this._e;
        pibn[] pibnArray = this._a;
        for (int i = 0; i < pibnArray.length; ++i) {
            pibnArray[i] = null;
        }
        this._b = 0;
    }

    public void _a(int n, int n2, Object object, int n3) {
        pibn pibn2 = this._a[n3];
        this._a[n3] = new pibn(n, n2, object, pibn2);
        if (this._b++ >= this._c) {
            this._e(2 * this._a.length);
        }
    }

    public static /* synthetic */ int _h(int n) {
        return IntHashMap._a(n);
    }
}

