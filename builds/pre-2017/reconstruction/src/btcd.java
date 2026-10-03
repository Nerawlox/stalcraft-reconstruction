/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.stats.IStatType;
import net.minecraft.stats.StatBase;

public final class btcd
implements IStatType {
    @Override
    public String _a(int n) {
        double d = (double)n / 100.0;
        double d2 = d / 1000.0;
        if (d2 > 0.5) {
            return StatBase.getDecimalFormat().format(d2) + " km";
        }
        if (d > 0.5) {
            return StatBase.getDecimalFormat().format(d) + " m";
        }
        return n + " cm";
    }
}

