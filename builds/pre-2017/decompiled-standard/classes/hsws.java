/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.client.xpzm;

public class hsws
implements nttf {
    @Override
    public void onGameJoined() {
        jzqf jzqf2 = xpzm._E()._N;
        if (jzqf2._c.playing(bafe._a)) {
            jzqf2._c.stop(bafe._a);
        }
    }

    @Override
    public void onGameLeft() {
        jzqf jzqf2 = xpzm._E()._N;
        if (!jzqf2._c.playing(bafe._a)) {
            bafe._a();
        }
    }
}

