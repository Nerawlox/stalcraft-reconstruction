/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLCommonHandler
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  nb
 */
package ru.stalcraft.tile;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.lang.reflect.Constructor;
import ru.stalcraft.client.effects.EffectsEngine;
import ru.stalcraft.client.effects.particles.ParticleEmitter;
import ru.stalcraft.client.particles.KisselParticleEmitter;
import ru.stalcraft.tile.IParticleEmmiter;

public abstract class TileEntityAnomaly
extends asp
implements IParticleEmmiter {
    public int lastEjectionId = -1;
    public Object particleEmitter;
    private boolean firstTick = true;
    public int reloadTime;
    public int tickTile;

    @Override
    public boolean canUpdate() {
        return FMLCommonHandler.instance().getEffectiveSide().isClient();
    }

    @Override
    public void h() {
        if (this.firstTick) {
            if (this.k.I) {
                this.addParticleEmitter();
            }
            this.firstTick = false;
        }
    }

    public static void damageEntityForce(of entity, nb source, float damage, boolean hurtEffect) {
        int savedResistantTime = entity.af;
        entity.af = 0;
        entity.a(source, damage);
        entity.af = savedResistantTime;
    }

    @SideOnly(value=Side.CLIENT)
    private boolean addParticleEmitter() {
        Class clazz = this.getEmitterClass();
        if (EffectsEngine.instance != null && clazz != null) {
            try {
                Constructor e2 = clazz.getConstructor(this.getClass());
                this.particleEmitter = e2.newInstance(this);
                EffectsEngine.instance.addParticleEmitter(this.getParticleEmitter());
            }
            catch (Exception var3) {
                var3.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @SideOnly(value=Side.CLIENT)
    public ParticleEmitter getParticleEmitter() {
        if (this.particleEmitter == null) {
            this.addParticleEmitter();
            this.firstTick = false;
        }
        return (ParticleEmitter)this.particleEmitter;
    }

    @SideOnly(value=Side.CLIENT)
    protected abstract Class getEmitterClass();

    @SideOnly(value=Side.CLIENT)
    public void spawnActiveParticles() {
        if (this.particleEmitter != null) {
            ((KisselParticleEmitter)this.particleEmitter).spawnActiveParticles();
        }
    }

    public void addTarget(of entity) {
    }

    public void removeTarget() {
    }

    public of getTarget() {
        return null;
    }

    @Override
    public boolean b(int par1, int par2) {
        if (par1 == 1) {
            nn entity = this.k.a(par2);
            if (entity instanceof of) {
                this.addTarget((of)entity);
            }
            return true;
        }
        if (par1 == 2) {
            this.removeTarget();
            return true;
        }
        return super.b(par1, par2);
    }

    @Override
    public int getPosX() {
        return this.l;
    }

    @Override
    public int getPosY() {
        return this.m;
    }

    @Override
    public int getPosZ() {
        return this.n;
    }

    @Override
    public abw getWorld() {
        return this.k;
    }
}

