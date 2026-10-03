/*
 * Decompiled with CFR 0.152.
 */
public class dign
extends Thread {
    public final /* synthetic */ ujth _a;

    public dign(ujth ujth2) {
        this._a = ujth2;
        this.setDaemon(true);
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (true) {
                    Thread.sleep(Integer.MAX_VALUE);
                }
            }
            catch (InterruptedException interruptedException) {
                continue;
            }
            break;
        }
    }
}

