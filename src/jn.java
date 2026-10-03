/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

class jn
implements Callable {
    final int a;
    final jm b;

    jn(jm par1EntityTracker, int par2) {
        this.b = par1EntityTracker;
        this.a = par2;
    }

    public String a() {
        String s2 = "Once per " + this.a + " ticks";
        if (this.a == Integer.MAX_VALUE) {
            s2 = "Maximum (" + s2 + ")";
        }
        return s2;
    }

    public Object call() {
        return this.a();
    }
}

