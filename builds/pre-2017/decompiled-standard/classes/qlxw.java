/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;

public class qlxw
implements nttf {
    public static String _a;
    public static rotc _b;
    public static rotc _c;

    public qlxw() {
        eivd._a();
    }

    @Override
    public void onGameLeft() {
        _a = null;
        ClientProxy.notifications.removeIf(bqdo2 -> bqdo2._e() instanceof tuwc);
    }

    static {
        _b = new rotc();
        _c = new rotc();
    }
}

