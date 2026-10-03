/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.misc.StalkerMiscMod;
import net.minecraft.item.ItemStack;

public interface oxnm {
    default public int _e(ItemStack itemStack) {
        int n = itemStack._k();
        int n2 = n - itemStack._j();
        double d = StalkerMiscMod._U;
        int n3 = this._h_(itemStack);
        if (n3 <= 0) {
            return 0;
        }
        if (n == 0) {
            return n3;
        }
        double d2 = (double)n3 * d + (double)n3 * (1.0 - d) * ((double)n2 / (double)n);
        return (int)Math.round(d2);
    }

    public int _h_(ItemStack var1);

    default public String _a() {
        return "stalker:disassembly";
    }
}

