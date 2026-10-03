/*
 * Decompiled with CFR 0.152.
 */
public class kmru
extends Thread {
    public final /* synthetic */ hdip _a;

    public kmru(hdip hdip2) {
        this._a = hdip2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000L);
            if (hdip._g(this._a).isAlive()) {
                try {
                    hdip._g(this._a).stop();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (hdip._h(this._a).isAlive()) {
                try {
                    hdip._h(this._a).stop();
                }
                catch (Throwable throwable) {}
            }
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}

