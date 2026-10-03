/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class qodo
extends Thread {
    public final /* synthetic */ hdip _a;

    public qodo(hdip hdip2, String string) {
        this._a = hdip2;
        super(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        block12: {
            hdip._b.getAndIncrement();
            block7: while (true) {
                while (hdip._a(this._a)) {
                    boolean bl = false;
                    while (hdip._d(this._a)) {
                        bl = true;
                    }
                    try {
                        if (bl && hdip._e(this._a) != null) {
                            hdip._e(this._a).flush();
                        }
                    }
                    catch (IOException iOException) {
                        if (!hdip._f(this._a)) {
                            hdip._a(this._a, iOException);
                        }
                        iOException.printStackTrace();
                    }
                    try {
                        qodo.sleep(2L);
                        continue block7;
                    }
                    catch (InterruptedException interruptedException) {
                    }
                }
                break block12;
                {
                    continue block7;
                    break;
                }
                break;
            }
            finally {
                hdip._b.getAndDecrement();
            }
        }
    }
}

