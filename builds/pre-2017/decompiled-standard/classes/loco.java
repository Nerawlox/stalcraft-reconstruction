/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;

public class loco
extends iekw {
    public maao _a;
    private static final int _d = 100;
    private static final int _e = 320;
    public static final int _b = 10;
    public static final int _c = 40;

    public loco(maao maao2) {
        super(maao2.field_70331_k, maao2);
        this._a = maao2;
        this.setCenter((double)maao2.field_70329_l + 0.5, (float)maao2.field_70330_m + 0.25f, (double)maao2.field_70327_n + 0.5);
        this.setSize(2.0, 1.0, 5.0);
    }

    @Override
    public void tick() {
        int n;
        super.tick();
        for (n = 0; n < 10; ++n) {
            this.particles.add(new hbvh(this, cujo._b[this.world.field_73012_v.nextInt(cujo._b.length)]));
        }
        for (n = 0; n < 8; ++n) {
            this.particles.add(new brgj(this, cujo._a[this.world.field_73012_v.nextInt(cujo._a.length)]));
        }
        this.renderDistanceSq = ClientProxy.particleRenderDistance.value * ClientProxy.particleRenderDistance.value;
    }

    @Override
    public boolean ignoreFrustrumTickCheck() {
        return false;
    }
}

