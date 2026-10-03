/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.potion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class PotionHelper {
    public static final String _a;
    public static final String _b;
    public static final String _c;
    public static final String _d;
    public static final String _e;
    public static final String _f;
    public static final String _g;
    public static final String _h;
    public static final String _i;
    public static final String _j;
    public static final String _k;
    public static final String _l;
    public static final HashMap _m;
    public static final HashMap _n;
    public static final HashMap _o;
    public static final String[] _p;

    public static boolean _a(int n, int n2) {
        return (n & 1 << n2) != 0;
    }

    public static int _b(int n, int n2) {
        return PotionHelper._a(n, n2) ? 1 : 0;
    }

    public static int _c(int n, int n2) {
        return PotionHelper._a(n, n2) ? 0 : 1;
    }

    public static int _a(int n) {
        return PotionHelper._a(n, 5, 4, 3, 2, 1);
    }

    public static int _a(Collection collection) {
        int n = 3694022;
        if (collection == null || collection.isEmpty()) {
            return n;
        }
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (PotionEffect potionEffect : collection) {
            int n2 = Potion._a[potionEffect._a()]._i();
            for (int i = 0; i <= potionEffect._c(); ++i) {
                f += (float)(n2 >> 16 & 0xFF) / 255.0f;
                f2 += (float)(n2 >> 8 & 0xFF) / 255.0f;
                f3 += (float)(n2 >> 0 & 0xFF) / 255.0f;
                f4 += 1.0f;
            }
        }
        f = f / f4 * 255.0f;
        f2 = f2 / f4 * 255.0f;
        f3 = f3 / f4 * 255.0f;
        return (int)f << 16 | (int)f2 << 8 | (int)f3;
    }

    public static boolean _b(Collection collection) {
        for (PotionEffect potionEffect : collection) {
            if (potionEffect._e()) continue;
            return false;
        }
        return true;
    }

    public static int _a(int n, boolean bl) {
        if (!bl) {
            if (_o.containsKey(n)) {
                return (Integer)_o.get(n);
            }
            int n2 = PotionHelper._a(PotionHelper._b(n, false));
            _o.put(n, n2);
            return n2;
        }
        return PotionHelper._a(PotionHelper._b(n, bl));
    }

    public static String _b(int n) {
        int n2 = PotionHelper._a(n);
        return _p[n2];
    }

    public static int _a(boolean bl, boolean bl2, boolean bl3, int n, int n2, int n3, int n4) {
        int n5 = 0;
        if (bl) {
            n5 = PotionHelper._c(n4, n2);
        } else if (n != -1) {
            if (n == 0 && PotionHelper._c(n4) == n2) {
                n5 = 1;
            } else if (n == 1 && PotionHelper._c(n4) > n2) {
                n5 = 1;
            } else if (n == 2 && PotionHelper._c(n4) < n2) {
                n5 = 1;
            }
        } else {
            n5 = PotionHelper._b(n4, n2);
        }
        if (bl2) {
            n5 *= n3;
        }
        if (bl3) {
            n5 *= -1;
        }
        return n5;
    }

    public static int _c(int n) {
        int n2 = 0;
        while (n > 0) {
            n &= n - 1;
            ++n2;
        }
        return n2;
    }

    public static int _a(String string, int n, int n2, int n3) {
        if (n >= string.length() || n2 < 0 || n >= n2) {
            return 0;
        }
        int n4 = string.indexOf(124, n);
        if (n4 >= 0 && n4 < n2) {
            int n5 = PotionHelper._a(string, n, n4 - 1, n3);
            if (n5 > 0) {
                return n5;
            }
            int n6 = PotionHelper._a(string, n4 + 1, n2, n3);
            if (n6 > 0) {
                return n6;
            }
            return 0;
        }
        int n7 = string.indexOf(38, n);
        if (n7 >= 0 && n7 < n2) {
            int n8 = PotionHelper._a(string, n, n7 - 1, n3);
            if (n8 <= 0) {
                return 0;
            }
            int n9 = PotionHelper._a(string, n7 + 1, n2, n3);
            if (n9 <= 0) {
                return 0;
            }
            if (n8 > n9) {
                return n8;
            }
            return n9;
        }
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        int n10 = -1;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        for (int i = n; i < n2; ++i) {
            char c = string.charAt(i);
            if (c >= '0' && c <= '9') {
                if (bl) {
                    n12 = c - 48;
                    bl2 = true;
                    continue;
                }
                n11 *= 10;
                n11 += c - 48;
                bl3 = true;
                continue;
            }
            if (c == '*') {
                bl = true;
                continue;
            }
            if (c == '!') {
                if (bl3) {
                    n13 += PotionHelper._a(bl4, bl2, bl5, n10, n11, n12, n3);
                    bl4 = false;
                    bl5 = false;
                    bl = false;
                    bl2 = false;
                    bl3 = false;
                    n12 = 0;
                    n11 = 0;
                    n10 = -1;
                }
                bl4 = true;
                continue;
            }
            if (c == '-') {
                if (bl3) {
                    n13 += PotionHelper._a(bl4, bl2, bl5, n10, n11, n12, n3);
                    bl4 = false;
                    bl5 = false;
                    bl = false;
                    bl2 = false;
                    bl3 = false;
                    n12 = 0;
                    n11 = 0;
                    n10 = -1;
                }
                bl5 = true;
                continue;
            }
            if (c == '=' || c == '<' || c == '>') {
                if (bl3) {
                    n13 += PotionHelper._a(bl4, bl2, bl5, n10, n11, n12, n3);
                    bl4 = false;
                    bl5 = false;
                    bl = false;
                    bl2 = false;
                    bl3 = false;
                    n12 = 0;
                    n11 = 0;
                    n10 = -1;
                }
                if (c == '=') {
                    n10 = 0;
                    continue;
                }
                if (c == '<') {
                    n10 = 2;
                    continue;
                }
                if (c != '>') continue;
                n10 = 1;
                continue;
            }
            if (c != '+' || !bl3) continue;
            n13 += PotionHelper._a(bl4, bl2, bl5, n10, n11, n12, n3);
            bl4 = false;
            bl5 = false;
            bl = false;
            bl2 = false;
            bl3 = false;
            n12 = 0;
            n11 = 0;
            n10 = -1;
        }
        if (bl3) {
            n13 += PotionHelper._a(bl4, bl2, bl5, n10, n11, n12, n3);
        }
        return n13;
    }

    public static List _b(int n, boolean bl) {
        ArrayList<PotionEffect> arrayList = null;
        for (Potion potion : Potion._a) {
            int n2;
            String string;
            if (potion == null || potion._h() && !bl || (string = (String)_m.get(potion._a())) == null || (n2 = PotionHelper._a(string, 0, string.length(), n)) <= 0) continue;
            int n3 = 0;
            String string2 = (String)_n.get(potion._a());
            if (string2 != null && (n3 = PotionHelper._a(string2, 0, string2.length(), n)) < 0) {
                n3 = 0;
            }
            if (potion._b()) {
                n2 = 1;
            } else {
                n2 = 1200 * (n2 * 3 + (n2 - 1) * 2);
                n2 >>= n3;
                n2 = (int)Math.round((double)n2 * potion._g());
                if ((n & 0x4000) != 0) {
                    n2 = (int)Math.round((double)n2 * 0.75 + 0.5);
                }
            }
            if (arrayList == null) {
                arrayList = new ArrayList<PotionEffect>();
            }
            PotionEffect potionEffect = new PotionEffect(potion._a(), n2, n3);
            if ((n & 0x4000) != 0) {
                potionEffect._a(true);
            }
            arrayList.add(potionEffect);
        }
        return arrayList;
    }

    public static int _a(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        if (bl3) {
            if (!PotionHelper._a(n, n2)) {
                return 0;
            }
        } else {
            n = bl ? (n &= ~(1 << n2)) : (bl2 ? ((n & 1 << n2) == 0 ? (n |= 1 << n2) : (n &= ~(1 << n2))) : (n |= 1 << n2));
        }
        return n;
    }

    public static int _a(int n, String string) {
        int n2 = 0;
        int n3 = string.length();
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        int n4 = 0;
        for (int i = n2; i < n3; ++i) {
            char c = string.charAt(i);
            if (c >= '0' && c <= '9') {
                n4 *= 10;
                n4 += c - 48;
                bl = true;
                continue;
            }
            if (c == '!') {
                if (bl) {
                    n = PotionHelper._a(n, n4, bl3, bl2, bl4);
                    bl4 = false;
                    bl2 = false;
                    bl3 = false;
                    bl = false;
                    n4 = 0;
                }
                bl2 = true;
                continue;
            }
            if (c == '-') {
                if (bl) {
                    n = PotionHelper._a(n, n4, bl3, bl2, bl4);
                    bl4 = false;
                    bl2 = false;
                    bl3 = false;
                    bl = false;
                    n4 = 0;
                }
                bl3 = true;
                continue;
            }
            if (c == '+') {
                if (!bl) continue;
                n = PotionHelper._a(n, n4, bl3, bl2, bl4);
                bl4 = false;
                bl2 = false;
                bl3 = false;
                bl = false;
                n4 = 0;
                continue;
            }
            if (c != '&') continue;
            if (bl) {
                n = PotionHelper._a(n, n4, bl3, bl2, bl4);
                bl4 = false;
                bl2 = false;
                bl3 = false;
                bl = false;
                n4 = 0;
            }
            bl4 = true;
        }
        if (bl) {
            n = PotionHelper._a(n, n4, bl3, bl2, bl4);
        }
        return n & Short.MAX_VALUE;
    }

    public static int _a(int n, int n2, int n3, int n4, int n5, int n6) {
        return (PotionHelper._a(n, n2) ? 16 : 0) | (PotionHelper._a(n, n3) ? 8 : 0) | (PotionHelper._a(n, n4) ? 4 : 0) | (PotionHelper._a(n, n5) ? 2 : 0) | (PotionHelper._a(n, n6) ? 1 : 0);
    }

    static {
        _m = new HashMap();
        _n = new HashMap();
        _a = null;
        _c = "+0-1-2-3&4-4+13";
        _m.put(Potion._l._a(), "0 & !1 & !2 & !3 & 0+6");
        _b = "-0+1-2-3&4-4+13";
        _m.put(Potion._c._a(), "!0 & 1 & !2 & !3 & 1+6");
        _h = "+0+1-2-3&4-4+13";
        _m.put(Potion._n._a(), "0 & 1 & !2 & !3 & 0+6");
        _f = "+0-1+2-3&4-4+13";
        _m.put(Potion._h._a(), "0 & !1 & 2 & !3");
        _d = "-0-1+2-3&4-4+13";
        _m.put(Potion._u._a(), "!0 & !1 & 2 & !3 & 2+6");
        _e = "-0+3-4+13";
        _m.put(Potion._t._a(), "!0 & !1 & !2 & 3 & 3+6");
        _m.put(Potion._i._a(), "!0 & !1 & 2 & 3");
        _m.put(Potion._d._a(), "!0 & 1 & !2 & 3 & 3+6");
        _g = "+0-1-2+3&4-4+13";
        _m.put(Potion._g._a(), "0 & !1 & !2 & 3 & 3+6");
        _l = "-0+1+2-3+13&4-4";
        _m.put(Potion._r._a(), "!0 & 1 & 2 & !3 & 2+6");
        _m.put(Potion._p._a(), "!0 & 1 & 2 & 3 & 2+6");
        _j = "+5-6-7";
        _n.put(Potion._c._a(), "5");
        _n.put(Potion._e._a(), "5");
        _n.put(Potion._g._a(), "5");
        _n.put(Potion._l._a(), "5");
        _n.put(Potion._i._a(), "5");
        _n.put(Potion._h._a(), "5");
        _n.put(Potion._m._a(), "5");
        _n.put(Potion._u._a(), "5");
        _i = "-5+6-7";
        _k = "+14&13-13";
        _o = new HashMap();
        _p = new String[]{"potion.prefix.mundane", "potion.prefix.uninteresting", "potion.prefix.bland", "potion.prefix.clear", "potion.prefix.milky", "potion.prefix.diffuse", "potion.prefix.artless", "potion.prefix.thin", "potion.prefix.awkward", "potion.prefix.flat", "potion.prefix.bulky", "potion.prefix.bungling", "potion.prefix.buttered", "potion.prefix.smooth", "potion.prefix.suave", "potion.prefix.debonair", "potion.prefix.thick", "potion.prefix.elegant", "potion.prefix.fancy", "potion.prefix.charming", "potion.prefix.dashing", "potion.prefix.refined", "potion.prefix.cordial", "potion.prefix.sparkling", "potion.prefix.potent", "potion.prefix.foul", "potion.prefix.odorless", "potion.prefix.rank", "potion.prefix.harsh", "potion.prefix.acrid", "potion.prefix.gross", "potion.prefix.stinky"};
    }
}

