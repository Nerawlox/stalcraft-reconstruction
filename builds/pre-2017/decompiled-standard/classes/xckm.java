/*
 * Decompiled with CFR 0.152.
 */
import java.util.concurrent.Callable;

public class xckm
implements Callable {
    public final /* synthetic */ iyev _a;

    public xckm(iyev iyev2) {
        this._a = iyev2;
    }

    public String _a() {
        String string = "Unknown?";
        try {
            switch (iyev._j(this._a)) {
                case 19133: {
                    string = "Anvil";
                    break;
                }
                case 19132: {
                    string = "McRegion";
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return String.format("0x%05X - %s", iyev._j(this._a), string);
    }

    public /* synthetic */ Object call() {
        return this._a();
    }
}

