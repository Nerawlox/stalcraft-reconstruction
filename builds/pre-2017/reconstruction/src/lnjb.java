/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.anomaly.entity.EntityKisselWave;
import gloomyfolken.mods.core.main.ClientProxy;

public class lnjb
extends iekw {
    public pztv _a;

    public lnjb(pztv pztv2) {
        super(pztv2.worldObj, pztv2);
        this._a = pztv2;
        this.setCenter((double)this._a.xCoord + 0.5, (float)this._a.yCoord + 0.1f, (double)this._a.zCoord + 0.5);
        this.setSize(1.0, 1.0, 2.0);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.lastDistanceSq < 256.0 && this.world.rand.nextFloat() < 0.03f) {
            bqmd bqmd2 = new bqmd(this, 0.2f + this.world.rand.nextFloat() * 0.1f, dwpk._n, dwpk._o);
            this.particles.add(bqmd2);
            EntityKisselWave entityKisselWave = new EntityKisselWave(this.world, bqmd2.posX, this.centerY + 0.1, bqmd2.posZ);
            this.world.spawnEntityInWorld(entityKisselWave);
        }
        this.renderDistanceSq = ClientProxy.particleRenderDistance.value * ClientProxy.particleRenderDistance.value;
    }

    public void _a() {
        for (int i = 0; i < 4; ++i) {
            bqmd bqmd2 = new bqmd(this, 0.1f + this.world.rand.nextFloat() * 0.05f, dwpk._n, dwpk._o);
            this.particles.add(bqmd2);
        }
    }

    @Override
    public boolean ignoreFrustrumTickCheck() {
        return true;
    }
}

