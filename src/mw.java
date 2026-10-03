/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  mv
 */
import java.util.HashMap;
import java.util.TimerTask;

class mw
extends TimerTask {
    final mv a;

    mw(mv par1PlayerUsageSnooper) {
        this.a = par1PlayerUsageSnooper;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        if (mv.a((mv)this.a).T()) {
            HashMap<String, Integer> hashmap;
            Object object = mv.b((mv)this.a);
            synchronized (object) {
                hashmap = new HashMap<String, Integer>(mv.c((mv)this.a));
                hashmap.put("snooper_count", mv.d((mv)this.a));
            }
            li.a(mv.a((mv)this.a).an(), mv.e((mv)this.a), hashmap, true);
        }
    }
}

