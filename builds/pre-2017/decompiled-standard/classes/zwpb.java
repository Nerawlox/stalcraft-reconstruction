/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.qlgf;
import java.util.HashSet;

public abstract class zwpb
extends kkdx {
    public static HashSet<Integer> _c = new HashSet();

    public zwpb(int n, tflj tflj2, qlgf qlgf2, String string, float f) {
        super(n, tflj2, qlgf2, string, f);
        _c.add(n);
    }

    public static boolean _a(int n) {
        return _c.contains(n);
    }
}

