/*
 * Decompiled with CFR 0.152.
 */
public class rrgv
extends Thread {
    public final /* synthetic */ hdip _a;

    public rrgv(hdip hdip2) {
        this._a = hdip2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000L);
            if (hdip._a(this._a)) {
                hdip._h(this._a).interrupt();
                this._a._a("disconnect.closed", new Object[0]);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

