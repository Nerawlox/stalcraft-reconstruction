/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;

public class kkfz
extends iekw {
    private static final int _c = 750;
    private static final int _d = 100;
    public static final float _a = 1.0f;
    public mqkr _b;
    private int _e = 750;
    private int _f = 100;
    private int _g = 0;
    private int _h = 0;

    public kkfz(mqkr mqkr2) {
        super(mqkr2.field_70331_k, mqkr2);
        this._b = mqkr2;
        this.setCenter((double)this._b.field_70329_l + 0.5, (float)this._b.field_70330_m + 4.5f, (double)this._b.field_70327_n + 0.5);
        this.setSize(3.0, 5.0, 4.0);
    }

    @Override
    public void tick() {
        if (this._b._d >= 0 && this._b._d < 120) {
            int n;
            int n2 = this._e / 15 + this._e % 15;
            for (n = 0; n < n2; ++n) {
                this.particles.add(new kkcn(this, dwpk._a[this.world.field_73012_v.nextInt(dwpk._a.length)], false, 0.5f));
            }
            this._e -= n2;
            n = this._f / 15 + this._f % 15;
            for (int i = 0; i < n; ++i) {
                this.particles.add(new kkcn(this, dwpk._b[this.world.field_73012_v.nextInt(dwpk._b.length)], true, 0.5f));
            }
            this._f -= n;
        } else if (this._b._d == 120) {
            this.particles.add(new ezvi(this, dwpk._k));
        }
        this.renderDistanceSq = ClientProxy.particleRenderDistance.value * ClientProxy.particleRenderDistance.value;
        if (this._b._d < 0 && --this._g <= 0 && this.world.field_73012_v.nextFloat() < 0.05f) {
            this.particles.add(new uyag(this, dwpk._l));
            this._g = 35;
        }
        if (this._b._d < 0 && --this._h <= 0 && this.world.field_73012_v.nextFloat() < 0.05f) {
            this.particles.add(new ycja(this, dwpk._m));
            this._h = 50;
        }
        if (this._b._d < 0 && this.lastDistanceSq < 256.0 && this.world.field_73012_v.nextFloat() < 0.5f) {
            this.particles.add(new zwrn(this, dwpk._b[this.world.field_73012_v.nextInt(dwpk._b.length)]));
        }
        super.tick();
    }

    @Override
    public void reset() {
        super.reset();
        this._e = 750;
        this._f = 100;
    }

    @Override
    public boolean ignoreFrustrumTickCheck() {
        return this._b._d >= 0;
    }
}

