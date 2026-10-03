/*
 * Decompiled with CFR 0.152.
 */
import java.util.HashMap;
import java.util.TimerTask;
import net.minecraft.util.srli;

public class rrmy
extends TimerTask {
    public final /* synthetic */ cfbu _a;

    public rrmy(cfbu cfbu2) {
        this._a = cfbu2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        HashMap<String, Integer> hashMap;
        if (!cfbu._a(this._a)._G()) {
            return;
        }
        Object object = cfbu._b(this._a);
        synchronized (object) {
            hashMap = new HashMap<String, Integer>(cfbu._c(this._a));
            hashMap.put("snooper_count", cfbu._d(this._a));
        }
        srli._a(cfbu._a(this._a)._O(), cfbu._e(this._a), hashMap, true);
    }
}

