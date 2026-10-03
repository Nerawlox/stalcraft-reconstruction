/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  als
 */
import java.util.concurrent.Callable;

class alz
implements Callable {
    final als a;

    alz(als par1WorldInfo) {
        this.a = par1WorldInfo;
    }

    public String a() {
        String s2 = "Unknown?";
        try {
            switch (als.j((als)this.a)) {
                case 19132: {
                    s2 = "McRegion";
                    break;
                }
                case 19133: {
                    s2 = "Anvil";
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return String.format("0x%05X - %s", als.j((als)this.a), s2);
    }

    public Object call() {
        return this.a();
    }
}

