/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;

public class eiul
extends iekw {
    private static final int _b = 250;
    private static final int _c = 50;
    public hsai _a;
    private uhci _d;

    public eiul(hsai hsai2) {
        super(hsai2.field_70331_k, hsai2);
        this._a = hsai2;
        this.setCenter((double)this._a.field_70329_l + 0.5, this._a.field_70330_m, (double)this._a.field_70327_n + 0.5);
        this.setSize(2.0, 2.0, 3.0);
        this._d = new uhci(this, dwpk._e);
        this.particles.add(this._d);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.world.field_73012_v.nextFloat() < 0.07f) {
            this.particles.add(new tvac(this, dwpk._f));
        }
        this.renderDistanceSq = ClientProxy.particleRenderDistance.value * ClientProxy.particleRenderDistance.value;
    }

    @Override
    public void reset() {
        super.reset();
        this.particles.add(this._d);
    }

    public static void _a(nege nege2) {
    }

    public void _a() {
        int n;
        for (n = 0; n < 250; ++n) {
            this.particles.add(new dfqo(this, false, dwpk._a[this.world.field_73012_v.nextInt(dwpk._a.length)]));
        }
        for (n = 0; n < 50; ++n) {
            this.particles.add(new dfqo(this, true, dwpk._b[this.world.field_73012_v.nextInt(dwpk._b.length)]));
        }
    }
}

