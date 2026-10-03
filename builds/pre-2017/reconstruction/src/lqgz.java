/*
 * Decompiled with CFR 0.152.
 */
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

public abstract class lqgz {
    public long _a;
    public lqgz _b;
    public long _c;
    public long _d;

    public static lqgz[] _a(long l, nwix nwix2) {
        rrwz rrwz2 = new rrwz(1L);
        fouo fouo2 = new fouo(2000L, rrwz2);
        xchs xchs2 = new xchs(1L, fouo2);
        ywlj ywlj2 = new ywlj(2001L, xchs2);
        xchs2 = new xchs(2L, ywlj2);
        nfkt nfkt2 = new nfkt(2L, xchs2);
        ywlj2 = new ywlj(2002L, nfkt2);
        xchs2 = new xchs(3L, ywlj2);
        ywlj2 = new ywlj(2003L, xchs2);
        xchs2 = new xchs(4L, ywlj2);
        btjx btjx2 = new btjx(5L, xchs2);
        int n = 4;
        if (nwix2 == nwix._f) {
            n = 6;
        }
        n = lqgz._a(nwix2, (byte)n);
        lqgz lqgz2 = ywlj._a(1000L, btjx2, 0);
        elsb elsb2 = new elsb(100L, lqgz2);
        lqgz2 = ywlj._a(1000L, elsb2, n + 2);
        fouu fouu2 = new fouu(1L, lqgz2);
        mtjq mtjq2 = new mtjq(1000L, fouu2);
        lqgz lqgz3 = ywlj._a(1000L, btjx2, 0);
        cwnw cwnw2 = new cwnw(200L, lqgz3, nwix2);
        lqgz3 = ywlj._a(1000L, cwnw2, 2);
        lqgz lqgz4 = new nwmj(1000L, lqgz3);
        for (int i = 0; i < n; ++i) {
            lqgz4 = new ywlj(1000 + i, lqgz4);
            if (i == 0) {
                lqgz4 = new xchs(3L, lqgz4);
            }
            if (i == 1) {
                lqgz4 = new gawj(1000L, lqgz4);
            }
            if (i != 1) continue;
            lqgz4 = new mtjp(1000L, lqgz4);
        }
        mtjq mtjq3 = new mtjq(1000L, lqgz4);
        jkam jkam2 = new jkam(100L, mtjq3, mtjq2);
        rauz rauz2 = new rauz(10L, jkam2);
        jkam2._a(l);
        rauz2._a(l);
        return new lqgz[]{jkam2, rauz2, jkam2};
    }

    public lqgz(long l) {
        this._d = l;
        this._d *= this._d * 6364136223846793005L + 1442695040888963407L;
        this._d += l;
        this._d *= this._d * 6364136223846793005L + 1442695040888963407L;
        this._d += l;
        this._d *= this._d * 6364136223846793005L + 1442695040888963407L;
        this._d += l;
    }

    public void _a(long l) {
        this._a = l;
        if (this._b != null) {
            this._b._a(l);
        }
        this._a *= this._a * 6364136223846793005L + 1442695040888963407L;
        this._a += this._d;
        this._a *= this._a * 6364136223846793005L + 1442695040888963407L;
        this._a += this._d;
        this._a *= this._a * 6364136223846793005L + 1442695040888963407L;
        this._a += this._d;
    }

    public void _a(long l, long l2) {
        this._c = this._a;
        this._c *= this._c * 6364136223846793005L + 1442695040888963407L;
        this._c += l;
        this._c *= this._c * 6364136223846793005L + 1442695040888963407L;
        this._c += l2;
        this._c *= this._c * 6364136223846793005L + 1442695040888963407L;
        this._c += l;
        this._c *= this._c * 6364136223846793005L + 1442695040888963407L;
        this._c += l2;
    }

    public int _a(int n) {
        int n2 = (int)((this._c >> 24) % (long)n);
        if (n2 < 0) {
            n2 += n;
        }
        this._c *= this._c * 6364136223846793005L + 1442695040888963407L;
        this._c += this._a;
        return n2;
    }

    public abstract int[] _a(int var1, int var2, int var3, int var4);

    public static byte _a(nwix nwix2, byte by) {
        WorldTypeEvent.BiomeSize biomeSize = new WorldTypeEvent.BiomeSize(nwix2, by);
        MinecraftForge.TERRAIN_GEN_BUS.post(biomeSize);
        return biomeSize.newSize;
    }
}

