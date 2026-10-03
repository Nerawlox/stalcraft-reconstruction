/*
 * Decompiled with CFR 0.152.
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import net.minecraft.client.Minecraft;
import net.minecraft.client.mco.McoServer;
import net.minecraft.util.hanr;

public class ifqv {
    public volatile boolean _a;
    public qnim _b;
    public Timer _c = new Timer();
    public Set _d = Sets.newHashSet();
    public List _e = Lists.newArrayList();
    public int _f;
    public boolean _g;
    public hanr _h;
    public int _i;

    public ifqv() {
        this._b = new qnim(this, null);
        this._c.schedule((TimerTask)this._b, 0L, 10000L);
        this._h = Minecraft._E()._P();
    }

    public synchronized void _a(hanr hanr2) {
        this._h = hanr2;
        if (this._a) {
            this._a = false;
            this._b = new qnim(this, null);
            this._c = new Timer();
            this._c.schedule((TimerTask)this._b, 0L, 10000L);
        }
    }

    public synchronized boolean _a() {
        return this._g;
    }

    public synchronized void _b() {
        this._g = false;
    }

    public synchronized List _c() {
        return Lists.newArrayList(this._e);
    }

    public int _d() {
        return this._f;
    }

    public int _e() {
        return this._i;
    }

    public synchronized void _f() {
        this._a = true;
        this._b.cancel();
        this._c.cancel();
    }

    public synchronized void _a(List list2) {
        int n = 0;
        for (McoServer mcoServer : this._d) {
            if (!list2.remove(mcoServer)) continue;
            ++n;
        }
        if (n == 0) {
            this._d.clear();
        }
        this._e = list2;
        this._g = true;
    }

    public synchronized void _a(McoServer mcoServer) {
        this._e.remove(mcoServer);
        this._d.add(mcoServer);
    }

    public void _a(int n) {
        this._f = n;
    }

    public static /* synthetic */ boolean _a(ifqv ifqv2) {
        return ifqv2._a;
    }

    public static /* synthetic */ hanr _b(ifqv ifqv2) {
        return ifqv2._h;
    }

    public static /* synthetic */ void _a(ifqv ifqv2, List list2) {
        ifqv2._a(list2);
    }

    public static /* synthetic */ void _a(ifqv ifqv2, int n) {
        ifqv2._a(n);
    }

    public static /* synthetic */ int _b(ifqv ifqv2, int n) {
        ifqv2._i = n;
        return ifqv2._i;
    }
}

