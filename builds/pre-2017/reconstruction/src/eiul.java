/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.core.main.ClientProxy;
import net.minecraft.client.renderer.texture.IconRegister;

public class eiul
extends iekw {
    private static final int _b = 250;
    private static final int _c = 50;
    public hsai _a;
    private uhci _d;

    public eiul(hsai hsai2) {
        super(hsai2.worldObj, hsai2);
        this._a = hsai2;
        this.setCenter((double)this._a.xCoord + 0.5, this._a.yCoord, (double)this._a.zCoord + 0.5);
        this.setSize(2.0, 2.0, 3.0);
        this._d = new uhci(this, dwpk._e);
        this.particles.add(this._d);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.world.rand.nextFloat() < 0.07f) {
            this.particles.add(new tvac(this, dwpk._f));
        }
        this.renderDistanceSq = ClientProxy.particleRenderDistance.value * ClientProxy.particleRenderDistance.value;
    }

    @Override
    public void reset() {
        super.reset();
        this.particles.add(this._d);
    }

    public static void _a(IconRegister iconRegister) {
    }

    public void _a() {
        int n;
        for (n = 0; n < 250; ++n) {
            this.particles.add(new dfqo(this, false, dwpk._a[this.world.rand.nextInt(dwpk._a.length)]));
        }
        for (n = 0; n < 50; ++n) {
            this.particles.add(new dfqo(this, true, dwpk._b[this.world.rand.nextInt(dwpk._b.length)]));
        }
    }
}

