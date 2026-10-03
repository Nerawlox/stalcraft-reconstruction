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
        super(qlvd2.worldObj, qlvd2);
        this._b = qlvd2;
        this.setCenter((double)this._b.xCoord + 0.5, (float)this._b.yCoord + 0.25f, (double)this._b.zCoord + 0.5);
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

