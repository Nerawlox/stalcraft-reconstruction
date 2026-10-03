/*
 * Decompiled with CFR 0.152.
 */
import java.util.Map;
import net.minecraft.stats.StatsSyncher;

public class gang
extends Thread {
    public final /* synthetic */ Map _a;
    public final /* synthetic */ StatsSyncher _b;

    public gang(StatsSyncher statsSyncher, Map map) {
        this._b = statsSyncher;
        this._a = map;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            StatsSyncher._a(this._b, this._a, StatsSyncher._e(this._b), StatsSyncher._f(this._b), StatsSyncher._g(this._b));
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        finally {
            StatsSyncher._a(this._b, false);
        }
    }
}

