/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.stalker.clans.pidb;
import net.minecraft.client.xpzm;

public class pjhv
implements ofux {
    @Override
    public void onKeyDown() {
        xpzm xpzm2 = xpzm._E();
        pidb pidb2 = yuch._c;
        if (pidb2 != null && xpzm2._B == null) {
            xpzm2._a(new baco(pidb2));
        }
    }

    @Override
    public void onKeyUp() {
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._B instanceof baco) {
            xpzm2._o();
        }
    }

    @Override
    public boolean processOnGui() {
        return true;
    }
}

