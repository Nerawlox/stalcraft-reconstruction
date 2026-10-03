/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;
import net.minecraft.entity.EntityLivingBase;

public class eiqn
extends iekw {
    private static final int _b = 125;
    private static final int _c = 750;
    private static final int _d = 100;
    public ncmp _a;
    private int _e = 750;
    private int _f = 100;

    public eiqn(ncmp ncmp2) {
        super(ncmp2.field_70331_k, ncmp2);
        this._a = ncmp2;
        this.setCenter((double)this._a.field_70329_l + 0.5, (float)this._a.field_70330_m + 4.5f, (double)this._a.field_70327_n + 0.5);
        this.setSize(3.0, 5.0, 4.0);
    }

    @Override
    public void tick() {
        int n;
        if (this._a._d >= 0) {
            int n2;
            n = this._e / 15 + this._e % 15;
            for (n2 = 0; n2 < n; ++n2) {
                this.particles.add(new ezsf(this, dwpk._a[this.world.field_73012_v.nextInt(dwpk._a.length)], false, 1.8f));
            }
            this._e -= n;
            n2 = this._f / 15 + this._f % 15;
            for (int i = 0; i < n2; ++i) {
                this.particles.add(new ezsf(this, dwpk._b[this.world.field_73012_v.nextInt(dwpk._b.length)], true, 1.8f));
            }
            this._f -= n2;
        } else if (this._a._e == 80) {
            this.reset();
        }
        if (this._a._d < 0) {
            for (n = 0; n < 1 && this.particles.size() < 125; ++n) {
                if (this.world.field_73012_v.nextFloat() < 0.15f) {
                    this.particles.add(new owpf(this, true, dwpk._b[this.world.field_73012_v.nextInt(dwpk._b.length)]));
                    continue;
                }
                this.particles.add(new owpf(this, false, dwpk._a[this.world.field_73012_v.nextInt(dwpk._a.length)]));
            }
        }
        this.renderDistanceSq = ClientProxy.particleRenderDistance.value * ClientProxy.particleRenderDistance.value;
        super.tick();
    }

    @Override
    public void reset() {
        super.reset();
        this._e = 750;
        this._f = 100;
    }

    public void _a(EntityLivingBase entityLivingBase) {
        ezvi ezvi2 = new ezvi(this, dwpk._k);
        this.particles.add(ezvi2);
        ezvi2.setPosition(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + (double)(entityLivingBase.field_70131_O / 2.0f), entityLivingBase.field_70161_v);
    }

    @Override
    public boolean ignoreFrustrumTickCheck() {
        return this._a._d >= 0;
    }
}

