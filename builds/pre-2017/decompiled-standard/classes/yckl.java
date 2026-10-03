/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import java.util.HashSet;
import net.minecraft.entity.Entity;

public abstract class yckl
extends kkdx {
    public static HashSet<Integer> _c = new HashSet();

    public yckl(int n, tflj tflj2, qlgf qlgf2, String string, float f) {
        super(n, tflj2, qlgf2, string, f);
        _c.add(n);
    }

    public static boolean _a(int n) {
        return _c.contains(n);
    }

    public static double _a(int n, int n2, int n3, Entity entity) {
        return entity.func_70092_e((double)n + 0.5, n2, (double)n3 + 0.5);
    }
}

