/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ogai {
    private static final ThreadLocal<ogai> _a = new ThreadLocal();
    protected static final int _b = 10;
    protected static final boolean _c = true;
    protected static final boolean _d = System.getProperty("reload_broken", "false").equals("true");
    protected ArrayList<hsnd> _e = new ArrayList();
    protected ArrayList<hsnd> _f = new ArrayList();
    protected int _g = -1;
    protected Thread _h;
    protected ssni _i;
    protected uhrd _j;
    protected final LinkedList<Runnable> _k = new LinkedList();
    protected static final int _l = 2000000;
    protected int _m = 2000000;

    protected void _a(int n) {
        this._m = n;
    }

    public ogai() {
        this._h = Thread.currentThread();
        this._j = this._g();
        this._r();
        this._k();
    }

    public void _j() {
        this._p();
        if (this._i != null) {
            this._i._a();
        }
        this._s();
    }

    public void _k() {
        boolean bl = this._e();
        if (bl) {
            if (this._i != null) {
                this._m();
                this._i._a();
            }
            this._i = this._f();
            this._i.start();
        }
    }

    protected boolean _e() {
        return this._i == null;
    }

    protected ssni _f() {
        return new ssni(this);
    }

    protected uhrd _g() {
        return new uhrd();
    }

    public void _b() {
        this._o();
        this._q();
    }

    public uhrd _l() {
        return this._j;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void _m() {
        kjui kjui2;
        do {
            kjui kjui3 = kjui2 = new kjui();
            this._d(() -> this._e(kjui3));
            while (!kjui2._a) {
                try {
                    LinkedList<Runnable> linkedList = this._k;
                    synchronized (linkedList) {
                        Runnable runnable = this._k.poll();
                        if (runnable == null) {
                            Thread.yield();
                        } else {
                            runnable.run();
                        }
                    }
                }
                catch (Exception exception) {
                    gpmu._b("Can not process main thread task", new Object[0]);
                    exception.printStackTrace();
                }
            }
        } while (!this._n() || !kjui2._b);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected boolean _n() {
        LinkedList<Runnable> linkedList = this._k;
        synchronized (linkedList) {
            return this._k.isEmpty();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void _o() {
        LinkedList<Runnable> linkedList = this._k;
        synchronized (linkedList) {
            long l = this._m;
            long l2 = System.nanoTime();
            while (l2 + l > System.nanoTime() && !this._k.isEmpty()) {
                try {
                    this._k.poll().run();
                }
                catch (Exception exception) {
                    gpmu._b("Can not process main thread task", new Object[0]);
                    exception.printStackTrace();
                }
            }
            long l3 = System.nanoTime() - l2;
            if (l3 > l * 2L) {
                gpmu._b("Too long async task! (" + l3 / 1000000L + " ms)", new Object[0]);
            }
        }
    }

    public void _p() {
        gpmu._d("Unloading all resources", new Object[0]);
        if (this._i != null) {
            this._m();
            gpmu._d("Background thread is waiting, can unload now...", new Object[0]);
        }
        this._d();
    }

    protected void _d() {
        for (hsnd object2 : this._e) {
            object2._n();
        }
        for (hsnd hsnd3 : this._f) {
            hsnd3._o();
        }
        this._e.removeIf(hsnd2 -> hsnd2._l() < 1);
        ArrayList<hsnd> arrayList = new ArrayList<hsnd>(this._e);
        arrayList.addAll(this._f);
        this._e.clear();
        this._f.clear();
        gpmu._d("Reloading required resources", new Object[0]);
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            hsnd hsnd4 = (hsnd)iterator2.next();
            hsnd4._m();
        }
        gpmu._d("Resource unloading done", new Object[0]);
    }

    protected synchronized void _q() {
        for (int i = 0; i < 10; ++i) {
            if (++this._g >= this._e.size()) {
                this._g = -1;
                break;
            }
            hsnd hsnd2 = this._e.get(this._g);
            if (!hsnd2._t_()) continue;
            hsnd hsnd3 = this._e.get(this._e.size() - 1);
            gpmu._f("Unloaded resource " + hsnd2, new Object[0]);
            this._e.set(this._g, hsnd3);
            this._e.remove(this._e.size() - 1);
            --this._g;
        }
    }

    public void _d(Runnable runnable) {
        if (this._i != null) {
            this._i._a(runnable);
        } else {
            try {
                runnable.run();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _e(Runnable runnable) {
        if (this._i != null) {
            LinkedList<Runnable> linkedList = this._k;
            synchronized (linkedList) {
                this._k.add(runnable);
            }
        }
        try {
            runnable.run();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void _a(Runnable runnable) {
        throw new UnsupportedOperationException("Can not run gl task in common streaming manager");
    }

    public void _b(Runnable runnable) {
        throw new UnsupportedOperationException("Can not run gl task in common streaming manager");
    }

    public void _c(Runnable runnable) {
        throw new UnsupportedOperationException("Can not run gl task in common streaming manager");
    }

    synchronized void _a(hsnd hsnd2) {
        this._e.add(hsnd2);
    }

    synchronized void _b(hsnd hsnd2) {
        if (_d) {
            this._f.add(hsnd2);
        }
    }

    public void _r() {
        _a.set(this);
    }

    public void _s() {
        _a.set(null);
    }

    public static ogai _t() {
        ogai ogai2 = _a.get();
        if (ogai2 == null) {
            throw new IllegalStateException("no ResourceStreamingManager was registered for current thread");
        }
        return _a.get();
    }

    public static ogai _u() {
        return _a.get();
    }

    public static boolean _v() {
        return Thread.currentThread() == ogai._t()._i;
    }

    public static boolean _w() {
        return Thread.currentThread() == ogai._t()._h;
    }

    public static void _x() {
        if (!ogai._v()) {
            throw new IllegalStateException("This should only happen in IO thread");
        }
    }

    public static void _y() {
        if (!ogai._w()) {
            throw new IllegalStateException("This should only happen in GL (main) thread");
        }
    }

    protected class kjui
    implements Runnable {
        volatile boolean _a = false;
        volatile boolean _b = false;

        protected kjui() {
        }

        @Override
        public void run() {
            this._a = true;
            this._b = ogai.this._i._b();
        }
    }
}

