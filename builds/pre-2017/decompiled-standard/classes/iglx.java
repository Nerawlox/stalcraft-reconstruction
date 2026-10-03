/*
 * Decompiled with CFR 0.152.
 */
public class iglx
extends Thread {
    public final /* synthetic */ hdip _a;

    public iglx(hdip hdip2, String string) {
        this._a = hdip2;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        hdip._a.getAndIncrement();
        try {
            while (hdip._a(this._a) && !hdip._b(this._a)) {
                while (hdip._c(this._a)) {
                }
                try {
                    iglx.sleep(2L);
                }
                catch (InterruptedException interruptedException) {}
            }
        }
        finally {
            hdip._a.getAndDecrement();
        }
    }
}

