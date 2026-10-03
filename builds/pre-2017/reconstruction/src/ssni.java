/*
 * Decompiled with CFR 0.152.
 */
import java.util.LinkedList;

public class ssni
extends Thread {
    public final ogai _b;
    private volatile boolean _a;
    private final Object _c = new Object();
    private LinkedList<Runnable> _d = new LinkedList();

    protected ssni(ogai ogai2) {
        this.setDaemon(true);
        this.setPriority(2);
        this.setName("Background loader");
        this._b = ogai2;
    }

    @Override
    public void run() {
        gpmu._d("Starting background resource loader", new Object[0]);
        this._b._r();
        try {
            while (!this._a) {
                this._c();
            }
        }
        finally {
            this._b._s();
        }
        gpmu._d("Stopping background resource loader...", new Object[0]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void _c() {
        Runnable runnable;
        Object object = this._c;
        synchronized (object) {
            if (this._d.size() == 0) {
                try {
                    this._c.wait();
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            runnable = this._d.poll();
        }
        if (runnable != null) {
            try {
                runnable.run();
            }
            catch (Exception exception) {
                gpmu._b("Can not process task " + runnable, new Object[0]);
                exception.printStackTrace();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void _a(Runnable runnable) {
        Object object = this._c;
        synchronized (object) {
            this._d.add(runnable);
            this._c.notify();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void _a() {
        Object object = this._c;
        synchronized (object) {
            this._a = true;
            this._c.notify();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean _b() {
        Object object = this._c;
        synchronized (object) {
            return this._d.isEmpty();
        }
    }
}

