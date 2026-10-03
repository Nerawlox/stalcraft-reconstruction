/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.stats.StatsSyncher;

public class hdqh
extends Thread {
    public final /* synthetic */ StatsSyncher _a;

    public hdqh(StatsSyncher statsSyncher) {
        this._a = statsSyncher;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            if (StatsSyncher._a(this._a) != null) {
                StatsSyncher._a(this._a, StatsSyncher._a(this._a), StatsSyncher._b(this._a), StatsSyncher._c(this._a), StatsSyncher._d(this._a));
            } else if (StatsSyncher._b(this._a).exists()) {
                StatsSyncher._a(this._a, StatsSyncher._a(this._a, StatsSyncher._b(this._a), StatsSyncher._c(this._a), StatsSyncher._d(this._a)));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            StatsSyncher._a(this._a, false);
        }
    }
}

