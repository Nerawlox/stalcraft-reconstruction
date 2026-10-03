/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lr
 */
public class lq {
    private transient lr[] a = new lr[16];
    private transient int b;
    private int c = 12;
    private final float d = 0.75f;
    private volatile transient int e;

    private static int g(long par0) {
        return lq.a((int)(par0 ^ par0 >>> 32));
    }

    private static int a(int par0) {
        par0 ^= par0 >>> 20 ^ par0 >>> 12;
        return par0 ^ par0 >>> 7 ^ par0 >>> 4;
    }

    private static int a(int par0, int par1) {
        return par0 & par1 - 1;
    }

    public int a() {
        return this.b;
    }

    public Object a(long par1) {
        int j2 = lq.g(par1);
        lr longhashmapentry = this.a[lq.a(j2, this.a.length)];
        while (longhashmapentry != null) {
            if (longhashmapentry.a == par1) {
                return longhashmapentry.b;
            }
            longhashmapentry = longhashmapentry.c;
        }
        return null;
    }

    public boolean b(long par1) {
        return this.c(par1) != null;
    }

    final lr c(long par1) {
        int j2 = lq.g(par1);
        lr longhashmapentry = this.a[lq.a(j2, this.a.length)];
        while (longhashmapentry != null) {
            if (longhashmapentry.a == par1) {
                return longhashmapentry;
            }
            longhashmapentry = longhashmapentry.c;
        }
        return null;
    }

    public void a(long par1, Object par3Obj) {
        int j2 = lq.g(par1);
        int k2 = lq.a(j2, this.a.length);
        lr longhashmapentry = this.a[k2];
        while (longhashmapentry != null) {
            if (longhashmapentry.a == par1) {
                longhashmapentry.b = par3Obj;
                return;
            }
            longhashmapentry = longhashmapentry.c;
        }
        ++this.e;
        this.a(j2, par1, par3Obj, k2);
    }

    private void b(int par1) {
        lr[] alonghashmapentry = this.a;
        int j2 = alonghashmapentry.length;
        if (j2 == 0x40000000) {
            this.c = Integer.MAX_VALUE;
        } else {
            lr[] alonghashmapentry1 = new lr[par1];
            this.a(alonghashmapentry1);
            this.a = alonghashmapentry1;
            this.c = (int)((float)par1 * this.d);
        }
    }

    private void a(lr[] par1ArrayOfLongHashMapEntry) {
        lr[] alonghashmapentry1 = this.a;
        int i2 = par1ArrayOfLongHashMapEntry.length;
        for (int j2 = 0; j2 < alonghashmapentry1.length; ++j2) {
            lr longhashmapentry1;
            lr longhashmapentry = alonghashmapentry1[j2];
            if (longhashmapentry == null) continue;
            alonghashmapentry1[j2] = null;
            do {
                longhashmapentry1 = longhashmapentry.c;
                int k2 = lq.a(longhashmapentry.d, i2);
                longhashmapentry.c = par1ArrayOfLongHashMapEntry[k2];
                par1ArrayOfLongHashMapEntry[k2] = longhashmapentry;
                longhashmapentry = longhashmapentry1;
            } while (longhashmapentry1 != null);
        }
    }

    public Object d(long par1) {
        lr longhashmapentry = this.e(par1);
        return longhashmapentry == null ? null : longhashmapentry.b;
    }

    final lr e(long par1) {
        lr longhashmapentry;
        int j2 = lq.g(par1);
        int k2 = lq.a(j2, this.a.length);
        lr longhashmapentry1 = longhashmapentry = this.a[k2];
        while (longhashmapentry1 != null) {
            lr longhashmapentry2 = longhashmapentry1.c;
            if (longhashmapentry1.a == par1) {
                ++this.e;
                --this.b;
                if (longhashmapentry == longhashmapentry1) {
                    this.a[k2] = longhashmapentry2;
                } else {
                    longhashmapentry.c = longhashmapentry2;
                }
                return longhashmapentry1;
            }
            longhashmapentry = longhashmapentry1;
            longhashmapentry1 = longhashmapentry2;
        }
        return longhashmapentry1;
    }

    private void a(int par1, long par2, Object par4Obj, int par5) {
        lr longhashmapentry = this.a[par5];
        this.a[par5] = new lr(par1, par2, par4Obj, longhashmapentry);
        if (this.b++ >= this.c) {
            this.b(2 * this.a.length);
        }
    }

    static int f(long par0) {
        return lq.g(par0);
    }
}

