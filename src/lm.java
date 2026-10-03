/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ln
 */
import java.util.HashSet;
import java.util.Set;

public class lm {
    private transient ln[] a = new ln[16];
    private transient int b;
    private int c = 12;
    private final float d = 0.75f;
    private volatile transient int e;
    private Set f = new HashSet();

    private static int g(int par0) {
        par0 ^= par0 >>> 20 ^ par0 >>> 12;
        return par0 ^ par0 >>> 7 ^ par0 >>> 4;
    }

    private static int a(int par0, int par1) {
        return par0 & par1 - 1;
    }

    public Object a(int par1) {
        int j2 = lm.g(par1);
        ln inthashmapentry = this.a[lm.a(j2, this.a.length)];
        while (inthashmapentry != null) {
            if (inthashmapentry.a == par1) {
                return inthashmapentry.b;
            }
            inthashmapentry = inthashmapentry.c;
        }
        return null;
    }

    public boolean b(int par1) {
        return this.c(par1) != null;
    }

    final ln c(int par1) {
        int j2 = lm.g(par1);
        ln inthashmapentry = this.a[lm.a(j2, this.a.length)];
        while (inthashmapentry != null) {
            if (inthashmapentry.a == par1) {
                return inthashmapentry;
            }
            inthashmapentry = inthashmapentry.c;
        }
        return null;
    }

    public void a(int par1, Object par2Obj) {
        this.f.add(par1);
        int j2 = lm.g(par1);
        int k2 = lm.a(j2, this.a.length);
        ln inthashmapentry = this.a[k2];
        while (inthashmapentry != null) {
            if (inthashmapentry.a == par1) {
                inthashmapentry.b = par2Obj;
                return;
            }
            inthashmapentry = inthashmapentry.c;
        }
        ++this.e;
        this.a(j2, par1, par2Obj, k2);
    }

    private void h(int par1) {
        ln[] ainthashmapentry = this.a;
        int j2 = ainthashmapentry.length;
        if (j2 == 0x40000000) {
            this.c = Integer.MAX_VALUE;
        } else {
            ln[] ainthashmapentry1 = new ln[par1];
            this.a(ainthashmapentry1);
            this.a = ainthashmapentry1;
            this.c = (int)((float)par1 * this.d);
        }
    }

    private void a(ln[] par1ArrayOfIntHashMapEntry) {
        ln[] ainthashmapentry1 = this.a;
        int i2 = par1ArrayOfIntHashMapEntry.length;
        for (int j2 = 0; j2 < ainthashmapentry1.length; ++j2) {
            ln inthashmapentry1;
            ln inthashmapentry = ainthashmapentry1[j2];
            if (inthashmapentry == null) continue;
            ainthashmapentry1[j2] = null;
            do {
                inthashmapentry1 = inthashmapentry.c;
                int k2 = lm.a(inthashmapentry.d, i2);
                inthashmapentry.c = par1ArrayOfIntHashMapEntry[k2];
                par1ArrayOfIntHashMapEntry[k2] = inthashmapentry;
                inthashmapentry = inthashmapentry1;
            } while (inthashmapentry1 != null);
        }
    }

    public Object d(int par1) {
        this.f.remove(par1);
        ln inthashmapentry = this.e(par1);
        return inthashmapentry == null ? null : inthashmapentry.b;
    }

    final ln e(int par1) {
        ln inthashmapentry;
        int j2 = lm.g(par1);
        int k2 = lm.a(j2, this.a.length);
        ln inthashmapentry1 = inthashmapentry = this.a[k2];
        while (inthashmapentry1 != null) {
            ln inthashmapentry2 = inthashmapentry1.c;
            if (inthashmapentry1.a == par1) {
                ++this.e;
                --this.b;
                if (inthashmapentry == inthashmapentry1) {
                    this.a[k2] = inthashmapentry2;
                } else {
                    inthashmapentry.c = inthashmapentry2;
                }
                return inthashmapentry1;
            }
            inthashmapentry = inthashmapentry1;
            inthashmapentry1 = inthashmapentry2;
        }
        return inthashmapentry1;
    }

    public void c() {
        ++this.e;
        ln[] ainthashmapentry = this.a;
        for (int i2 = 0; i2 < ainthashmapentry.length; ++i2) {
            ainthashmapentry[i2] = null;
        }
        this.b = 0;
    }

    private void a(int par1, int par2, Object par3Obj, int par4) {
        ln inthashmapentry = this.a[par4];
        this.a[par4] = new ln(par1, par2, par3Obj, inthashmapentry);
        if (this.b++ >= this.c) {
            this.h(2 * this.a.length);
        }
    }

    static int f(int par0) {
        return lm.g(par0);
    }
}

