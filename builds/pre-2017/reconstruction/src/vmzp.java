/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.stats.IStatType;
import net.minecraft.stats.StatBase;

public class vmzp
extends StatBase {
    public vmzp(int n, String string, IStatType iStatType) {
        super(n, string, iStatType);
    }

    public vmzp(int n, String string) {
        super(n, string);
    }

    @Override
    public StatBase registerStat() {
        super.registerStat();
        dzif._c.add(this);
        return this;
    }
}

