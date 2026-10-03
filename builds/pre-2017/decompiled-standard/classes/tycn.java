/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.util.turb;

public abstract class tycn
extends yfis {
    public zzts _j;
    public Map _k = new HashMap();

    public abstract String _a();

    @Override
    public final void _a(ozlu ozlu2, int n, int n2, int n3, int n4, byte[] byArray) {
        this._a(ozlu2);
        if (!this._k.containsKey(jjym._a(n, n2))) {
            this._b.nextInt();
            try {
                if (this._a(n, n2)) {
                    tycc tycc2 = this._b(n, n2);
                    this._k.put(jjym._a(n, n2), tycc2);
                    this._a(n, n2, tycc2);
                }
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception preparing structure feature");
                jxsn jxsn2 = crashReport.func_85058_a("Feature being prepared");
                jxsn2._a("Is feature chunk", new nwlw(this, n, n2));
                jxsn2._a("Chunk location", String.format("%d,%d", n, n2));
                jxsn2._a("Chunk pos hash", new elqr(this, n, n2));
                jxsn2._a("Structure type", new gavt(this));
                throw new turb(crashReport);
            }
        }
    }

    public boolean _a(ozlu ozlu2, Random random, int n, int n2) {
        this._a(ozlu2);
        int n3 = (n << 4) + 8;
        int n4 = (n2 << 4) + 8;
        boolean bl = false;
        for (tycc tycc2 : this._k.values()) {
            if (!tycc2._d() || !tycc2._a()._a(n3, n4, n3 + 15, n4 + 15)) continue;
            tycc2._a(ozlu2, random, new uken(n3, n4, n3 + 15, n4 + 15));
            bl = true;
            this._a(tycc2._e(), tycc2._f(), tycc2);
        }
        return bl;
    }

    public boolean _b(int n, int n2, int n3) {
        this._a(this._c);
        return this._c(n, n2, n3) != null;
    }

    public tycc _c(int n, int n2, int n3) {
        for (tycc tycc2 : this._k.values()) {
            if (!tycc2._d() || !tycc2._a()._a(n, n3, n, n3)) continue;
            for (zztd zztd2 : tycc2._b()) {
                if (!zztd2._d()._b(n, n2, n3)) continue;
                return tycc2;
            }
        }
        return null;
    }

    public boolean _d(int n, int n2, int n3) {
        tycc tycc2;
        this._a(this._c);
        Iterator iterator2 = this._k.values().iterator();
        do {
            if (iterator2.hasNext()) continue;
            return false;
        } while (!(tycc2 = (tycc)iterator2.next())._d());
        return tycc2._a()._a(n, n3, n, n3);
    }

    public xtcd _a(ozlu ozlu2, int n, int n2, int n3) {
        double d;
        int n4;
        int n5;
        int n6;
        xtcd xtcd2;
        Object object;
        Object object22;
        this._c = ozlu2;
        this._a(ozlu2);
        this._b.setSeed(ozlu2.func_72905_C());
        long l = this._b.nextLong();
        long l2 = this._b.nextLong();
        long l3 = (long)(n >> 4) * l;
        long l4 = (long)(n3 >> 4) * l2;
        this._b.setSeed(l3 ^ l4 ^ ozlu2.func_72905_C());
        this._a(ozlu2, n >> 4, n3 >> 4, 0, 0, null);
        double d2 = Double.MAX_VALUE;
        xtcd xtcd3 = null;
        for (Object object22 : this._k.values()) {
            if (!((tycc)object22)._d()) continue;
            object = (zztd)((tycc)object22)._b().get(0);
            xtcd2 = ((zztd)object)._a();
            n6 = xtcd2._d - n;
            n5 = xtcd2._e - n2;
            n4 = xtcd2._f - n3;
            d = n6 * n6 + n5 * n5 + n4 * n4;
            if (!(d < d2)) continue;
            d2 = d;
            xtcd3 = xtcd2;
        }
        if (xtcd3 != null) {
            return xtcd3;
        }
        object22 = this._b();
        if (object22 != null) {
            object = null;
            Iterator iterator2 = object22.iterator();
            while (iterator2.hasNext()) {
                xtcd2 = (xtcd)iterator2.next();
                n6 = xtcd2._d - n;
                n5 = xtcd2._e - n2;
                n4 = xtcd2._f - n3;
                d = n6 * n6 + n5 * n5 + n4 * n4;
                if (!(d < d2)) continue;
                d2 = d;
                object = xtcd2;
            }
            return object;
        }
        return null;
    }

    public List _b() {
        return null;
    }

    public void _a(ozlu ozlu2) {
        if (this._j == null) {
            this._j = (zzts)ozlu2.perWorldStorage._a(zzts.class, this._a());
            if (this._j == null) {
                this._j = new zzts(this._a());
                ozlu2.perWorldStorage._a(this._a(), this._j);
            } else {
                qoac qoac2 = this._j._a();
                for (huhy huhy2 : qoac2._d()) {
                    qoac qoac3;
                    if (huhy2._a() != 10 || !(qoac3 = (qoac)huhy2)._c("ChunkX") || !qoac3._c("ChunkZ")) continue;
                    int n = qoac3._f("ChunkX");
                    int n2 = qoac3._f("ChunkZ");
                    tycc tycc2 = cfps._a(qoac3, ozlu2);
                    this._k.put(jjym._a(n, n2), tycc2);
                }
            }
        }
    }

    public void _a(int n, int n2, tycc tycc2) {
        this._j._a(tycc2._a(n, n2), n, n2);
        this._j.func_76185_a();
    }

    public abstract boolean _a(int var1, int var2);

    public abstract tycc _b(int var1, int var2);
}

