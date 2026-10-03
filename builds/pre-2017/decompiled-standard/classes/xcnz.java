/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class xcnz
implements Runnable {
    public static final xcnz _a = new xcnz();
    public List _b = Collections.synchronizedList(new ArrayList());
    public volatile long _c;
    public volatile long _d;
    public volatile boolean _e;

    public xcnz() {
        Thread thread = new Thread((Runnable)this, "File IO Thread");
        thread.setPriority(1);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            this._a();
        }
    }

    public void _a() {
        for (int i = 0; i < this._b.size(); ++i) {
            kngp kngp2 = (kngp)this._b.get(i);
            boolean bl = kngp2._a();
            if (!bl) {
                this._b.remove(i--);
                ++this._d;
            }
            try {
                Thread.sleep(this._e ? 0L : 10L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        if (this._b.isEmpty()) {
            try {
                Thread.sleep(25L);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    public void _a(kngp kngp2) {
        if (this._b.contains(kngp2)) {
            return;
        }
        ++this._c;
        this._b.add(kngp2);
    }

    public void _b() {
        this._e = true;
        while (this._c != this._d) {
            Thread.sleep(10L);
        }
        this._e = false;
    }
}

