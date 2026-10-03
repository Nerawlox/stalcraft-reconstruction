/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
package ru.stalcraft.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import ru.stalcraft.Config;
import ru.stalcraft.StalkerDamage;
import ru.stalcraft.client.particles.CarouselParticleEmitter;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.network.ServerPacketSender;
import ru.stalcraft.tile.IPlayerQuitListener;
import ru.stalcraft.tile.TileEntityAnomaly;
import ru.stalcraft.tile.TileEntityExtendedAnomaly;

public class TileEntityCarousel
extends TileEntityExtendedAnomaly
implements IPlayerQuitListener {
    public of target;
    private boolean isSoundActive;
    private String activeSound = "stalker:carousel_active";
    private static Random rand = new Random();
    public int activeTimer = -1;
    public int ticksSinceActive;

    @Override
    public void h() {
        super.h();
        if (this.k.I) {
            ++this.ticksSinceActive;
        } else if (this.activeTimer == -1) {
            return;
        }
        if (this.activeTimer != -1) {
            ++this.activeTimer;
            if (this.target != null && !this.k.I && this.target.q != this.k && this.target.M) {
                this.removeTarget();
            } else if (this.target != null && !this.k.I && (this.target.aN() <= 0.0f || this.target.e((double)this.l + 0.5, (double)this.m + 0.5, (double)this.n + 0.5) > 25.0)) {
                this.removeTarget();
            } else if (this.target != null && this.target instanceof uf && ((uf)this.target).bG.d) {
                this.removeTarget();
            } else if (this.target != null) {
                atc motionVec = atc.a((double)((double)this.l + 0.5 - this.target.u), (double)((double)(this.m + 5) - this.target.v), (double)((double)this.n + 0.5 - this.target.w)).a();
                float velocity = 0.012f + (float)this.activeTimer / 9000.0f;
                this.target.A += (float)((int)((float)this.activeTimer / 40.0f) + 3);
                double x2 = Math.abs(motionVec.c * (double)velocity) > Math.abs((double)this.l + 0.5 - this.target.u) ? (double)this.l + 0.5 - this.target.u : motionVec.c * (double)velocity;
                double y2 = Math.min(motionVec.d * (double)velocity, (double)this.m + 3.38 - this.target.v + (double)this.target.N);
                double z2 = Math.abs(motionVec.e * (double)velocity) > Math.abs((double)this.n + 0.5 - this.target.w) ? (double)this.n + 0.5 - this.target.w : motionVec.e * (double)velocity;
                this.target.g(x2, y2 - this.target.y, z2);
                if (this.activeTimer >= 120 && !this.az().I) {
                    TileEntityAnomaly.damageEntityForce(this.target, StalkerDamage.carousel, Config.carouselDamage, true);
                    this.removeTarget();
                    this.reloadTime = 80;
                }
            }
            if (this.activeTimer >= 300) {
                this.removeTarget();
            }
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void spawnSplashParticle() {
        ((CarouselParticleEmitter)this.particleEmitter).spawnSplashParticle(this.target);
    }

    @Override
    public void addTarget(of entity) {
        if (this.target == null && this.reloadTime == 0 && this.activeTimer == -1 && !entity.M && entity.aN() > 0.0f && !entity.ar() || this.k.I) {
            if (!this.k.I) {
                ServerPacketSender.sendTileEntityEvent(this, 1, entity.k);
                if (entity instanceof uf) {
                    PlayerUtils.getInfo((uf)((uf)entity)).quitListeners.add(this);
                }
            } else {
                if (this.particleEmitter != null) {
                    this.getParticleEmitter().reset();
                }
                this.playSound();
            }
            this.target = entity;
            this.activeTimer = 0;
        }
    }

    @SideOnly(value=Side.CLIENT)
    private void playSound() {
        float var10002 = (float)this.l + 0.5f;
        float var10003 = (float)this.m + 0.5f;
        atv.w().v.a(this.activeSound, var10002, var10003, (float)this.n + 0.5f, 1.0f, 1.0f);
    }

    @Override
    public void removeTarget() {
        if (!this.k.I) {
            ServerPacketSender.sendTileEntityEvent(this, 2, 0);
        } else if (this.target != null && this.target.aN() <= 0.0f && this.k.I) {
            this.spawnSplashParticle();
        }
        this.activeTimer = -1;
        this.ticksSinceActive = 0;
        this.target = null;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void onPlayerExit() {
        if (this.target != null) {
            TileEntityAnomaly.damageEntityForce(this.target, StalkerDamage.carousel, 1.0E7f, true);
        }
    }

    @Override
    protected Class getEmitterClass() {
        return CarouselParticleEmitter.class;
    }

    @Override
    public of getTarget() {
        return this.target;
    }
}

