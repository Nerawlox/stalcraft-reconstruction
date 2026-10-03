/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.sajz;

public class ywad
implements sajz {
    public long _a = dzfd.__aq();
    public final /* synthetic */ dzfd _b;

    public ywad(dzfd dzfd2) {
        this._b = dzfd2;
    }

    @Override
    public void _b(String string) {
    }

    @Override
    public void _a(int n) {
        if (dzfd.__aq() - this._a >= 1000L) {
            this._a = dzfd.__aq();
            this._b._O()._a("Converting... " + n + "%");
        }
    }

    @Override
    public void _d(String string) {
    }
}

