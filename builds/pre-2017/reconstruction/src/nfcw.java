/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.stats.IStatType;
import net.minecraft.stats.StatBase;

public final class nfcw
implements IStatType {
    @Override
    public String _a(int n) {
        return StatBase.getDecimalFormat().format((double)n * 0.1);
    }
}

