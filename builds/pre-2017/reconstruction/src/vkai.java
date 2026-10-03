/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class vkai {
    public final String _a;
    public Logger _b;
    public final srxg _c;
    private ychq _g;
    public static final int _d = 100;
    public final long[] _e = new long[100];
    private int _h;
    private final List<Runnable> _i = new ArrayList<Runnable>();
    List<String> _f = Collections.synchronizedList(new ArrayList());
    private boolean _j;

    public vkai(String string) {
        this._a = string;
        this._c = new srxg(this);
    }

    private void _j() {
        this._b = this._a(this._a);
        this._b.info("Logging set up");
    }

    protected Logger _a(String string) {
        Logger logger = Logger.getLogger(string);
        logger.setLevel(Level.ALL);
        try {
            logger.setUseParentHandlers(false);
            this._a(logger, new FileHandler(string + ".log", true));
            this._a(logger, new FileHandler(string + "_last.log", false));
            this._a(logger, new ConsoleHandler());
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
        return logger;
    }

    private void _a(Logger logger, Handler handler) {
        handler.setLevel(Level.ALL);
        handler.setFormatter(new hryi());
        logger.addHandler(handler);
    }

    protected ychq _a() {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void _b() {
        try {
            this._k();
        }
        catch (Throwable throwable) {
            this._b.log(Level.SEVERE, "Unhandled exception during server start: ", throwable);
            System.exit(0);
        }
        try {
            while (!this._j) {
                long l = System.currentTimeMillis();
                this._l();
                try {
                    long l2 = System.currentTimeMillis() - l;
                    long l3 = 1000 / this._g();
                    long l4 = l3 - l2;
                    if (l4 <= 0L) continue;
                    Thread.sleep(l4);
                }
                catch (InterruptedException interruptedException) {
                }
            }
            return;
        }
        catch (Throwable throwable) {
            this._b.log(Level.SEVERE, "Unhandled exception:", throwable);
            return;
        }
        finally {
            try {
                this._m();
            }
            catch (Throwable throwable) {
                this._b.log(Level.SEVERE, "Unhandled exception during server stop:", throwable);
            }
            finally {
                System.exit(0);
            }
        }
    }

    private void _k() {
        this._j();
        new roup(this).start();
        this._d();
        this._g = this._a();
        if (this._g != null) {
            this._b.info("Metrics for " + this._a + " set up");
        }
        this._b.info("Service " + this._a + " started");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void _l() {
        Object object;
        long l = System.nanoTime();
        while (!this._f.isEmpty()) {
            object = this._f.remove(0);
            this._c._a((String)object);
        }
        object = this._i;
        synchronized (object) {
            for (Runnable runnable : this._i) {
                runnable.run();
            }
            this._i.clear();
        }
        this._e();
        long l2 = System.nanoTime() - l;
        this._e[this._h++ % 100] = l2;
        if (this._g != null && this._h % 100 == 0) {
            this._g._a(this._e, this._g());
        }
    }

    private void _m() {
        this._f();
        this._b.info("Service " + this._a + " stopped");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(Runnable runnable) {
        List<Runnable> list2 = this._i;
        synchronized (list2) {
            this._i.add(runnable);
        }
    }

    public void _b(String string) {
        this._c._a(string);
    }

    public void _c() {
        this._j = true;
    }

    protected void _d() {
    }

    protected void _e() {
    }

    protected void _f() {
    }

    public int _g() {
        return 20;
    }

    public int _h() {
        return this._h;
    }

    public ychq _i() {
        return this._g;
    }
}

