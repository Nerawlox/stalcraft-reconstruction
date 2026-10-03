/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;

public class flxo
extends iekw {
    private static final int _c = 250;
    public static final int _a = 40;
    public qlvd _b;

    public flxo(qlvd qlvd2) {
        super(qlvd2.field_70331_k, qlvd2);
        this._b = qlvd2;
        this.setCenter((double)this._b.field_70329_l + 0.5, (float)this._b.field_70330_m + 0.25f, (double)this._b.field_70327_n + 0.5);
        this.setSize(2.0, 3.0, 6.0);
    }

    @Override
    public void tick() {
        super.tick();
        int n = 6;
        for (int i = 0; i < n; ++i) {
            this.particles.add(new flxm(this, dwpk._g));
        }
        this.renderDistanceSq = ClientProxy.particleRenderDistance.value * ClientProxy.particleRenderDistance.value;
    }

    @Override
    public boolean ignoreFrustrumTickCheck() {
        return false;
    }
}

