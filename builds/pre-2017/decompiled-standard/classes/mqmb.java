/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;

public class mqmb
extends iekw {
    private static final int _c = 275;
    public static final int _a = 20;
    public ivaa _b;
    private int _d;

    public mqmb(ivaa ivaa2) {
        super(ivaa2.field_70331_k, ivaa2);
        this._b = ivaa2;
        this.setCenter((double)this._b.field_70329_l + 0.5, (float)this._b.field_70330_m + 0.25f, (double)this._b.field_70327_n + 0.5);
        this.setSize(1.5, 1.0, 4.0);
    }

    @Override
    public void tick() {
        super.tick();
        if (this._b._c > 0) {
            int n = this._b._c > 4 ? 1 : 5 - this._b._c;
            int n2 = 13 / n;
            for (int i = 0; i < n2; ++i) {
                this.particles.add(new uhco(this, dwpk._c[this.world.field_73012_v.nextInt(dwpk._c.length)]));
            }
        }
        if (--this._d <= 0) {
            this._d = 8;
            this.particles.add(new zfpt(this, dwpk._q));
        }
        this.renderDistanceSq = ClientProxy.particleRenderDistance.value * ClientProxy.particleRenderDistance.value;
    }
}

