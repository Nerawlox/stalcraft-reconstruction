/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

public class cvaz
extends Thread {
    public final /* synthetic */ fngq _a;

    public cvaz(fngq fngq2) {
        this._a = fngq2;
    }

    @Override
    public void run() {
        rqmi rqmi2 = new rqmi(fngq._a(this._a)._P());
        boolean bl = false;
        for (int i = 0; i < 3; ++i) {
            try {
                Boolean bl2 = rqmi2._b();
                if (bl2.booleanValue()) {
                    fngq._b(this._a);
                }
                fngq._a(bl2);
            }
            catch (dhdd dhdd2) {
                bl = true;
            }
            catch (twsl twsl2) {
                fngq._c(this._a)._O()._c(twsl2.toString());
            }
            catch (IOException iOException) {
                fngq._d(this._a)._O()._b("Realms: could not parse response");
            }
            if (!bl) break;
            try {
                Thread.sleep(10000L);
                continue;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

