/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  hn
 *  nb
 *  net.minecraft.server.MinecraftServer
 *  net.minecraftforge.common.ForgeHooks
 */
package ru.stalcraft.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.ForgeHooks;
import ru.stalcraft.StalkerDamage;
import ru.stalcraft.client.particles.FunnelParticleEmitter;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.network.ServerPacketSender;
import ru.stalcraft.tile.IPlayerQuitListener;
import ru.stalcraft.tile.TileEntityAnomaly;

public class TileEntityFunnel
extends TileEntityAnomaly
implements IPlayerQuitListener {
    public of target;
    private boolean isSoundActive;
    private String activeSound = "stalker:blackhole_active";
    private static Random rand = new Random();
    public int activeTimer = -1;

    @Override
    public void h() {
        super.h();
        List par1 = this.k.a(of.class, asx.a().a((double)this.l - 1.0, (double)this.m - 1.5, (double)this.n - 1.0, (double)this.l + 2.0, (double)this.m + 3.0, (double)this.n + 2.0));
        for (of par2 : par1) {
            if (this.k.I) continue;
            if (par2 instanceof uf && !((uf)par2).bG.d) {
                this.addTarget(par2);
                continue;
            }
            if (!(par2 instanceof of) || par2 instanceof uf) continue;
            this.addTarget(par2);
        }
        if (this.activeTimer != -1) {
            ++this.activeTimer;
            if (this.activeTimer == 119 && this.k.I) {
                --this.activeTimer;
            }
            if (this.target != null && !this.k.I && this.target.q != this.k) {
                this.removeTarget();
            } else if (this.target != null && this.target instanceof uf && ((uf)this.target).bG.d) {
                this.removeTarget();
            } else if (this.target != null && !this.k.I && this.target.e((double)this.l + 0.5, (double)this.m + 0.5, (double)this.n + 0.5) > 25.0) {
                this.removeTarget();
            } else if (this.target != null) {
                atc motionVec = atc.a((double)((double)this.l + 0.5 - this.target.u), (double)((double)(this.m + 5) - this.target.v), (double)((double)this.n + 0.5 - this.target.w)).a();
                float velocity = 0.05f + (float)this.activeTimer / 2400.0f;
                double x2 = Math.abs(motionVec.c * (double)velocity) > Math.abs((double)this.l + 0.5 - this.target.u) ? (double)this.l + 0.5 - this.target.u : motionVec.c * (double)velocity;
                double y2 = Math.min(motionVec.d * (double)velocity, (double)this.m + 3.38 - this.target.v + (double)this.target.N);
                double z2 = Math.abs(motionVec.e * (double)velocity) > Math.abs((double)this.n + 0.5 - this.target.w) ? (double)this.n + 0.5 - this.target.w : motionVec.e * (double)velocity;
                this.target.g(x2, y2 - this.target.y, z2);
                if (this.activeTimer >= 120 && this.target != null && !this.k.I) {
                    this.doActivation(false);
                }
            }
            if (this.activeTimer == 200) {
                if (this.particleEmitter != null) {
                    this.getParticleEmitter().reset();
                }
                this.activeTimer = -1;
            }
        }
    }

    public void doActivation(boolean exit) {
        if (!this.k.I) {
            ServerPacketSender.sendTileEntityEvent(this, 3, 0);
            if (this.target instanceof uf) {
                jv playerMP = (jv)this.target;
                if (!exit) {
                    PlayerUtils.getInfo((uf)playerMP).quitListeners.remove(this);
                }
                if (!playerMP.c.d() && ForgeHooks.onLivingAttack((of)this.target, (nb)StalkerDamage.blackhole, (float)1000000.0f)) {
                    ArrayList<ye> stacks = new ArrayList<ye>();
                    for (ye item : playerMP.bn.a) {
                        if (item == null) continue;
                        stacks.add(item);
                    }
                    for (ye item : playerMP.bn.b) {
                        if (item == null) continue;
                        stacks.add(item);
                    }
                    for (ye item : PlayerUtils.getInfo((uf)playerMP).stInv.mainInventory) {
                        if (item == null) continue;
                        stacks.add(item);
                    }
                    playerMP.bn.b(-1, -1);
                    PlayerUtils.getInfo((uf)playerMP).stInv.clearInventory(-1, -1);
                    hn var10 = MinecraftServer.F().af();
                    for (ye var12 : stacks) {
                        ss var13 = new ss(this.target.q, this.target.u, this.target.v + 1.0, this.target.w, var12);
                        var13.b = 10;
                        atc itemMotionVec = atc.a((double)(rand.nextDouble() - 0.5), (double)(rand.nextDouble() / 2.0), (double)(rand.nextDouble() - 0.5)).a();
                        float speedFactor = 0.4f + rand.nextFloat() / 10.0f;
                        var13.x = itemMotionVec.c * (double)speedFactor;
                        var13.y = itemMotionVec.d * (double)speedFactor;
                        var13.z = itemMotionVec.e * (double)speedFactor;
                        this.target.q.d(var13);
                    }
                }
            }
            TileEntityAnomaly.damageEntityForce(this.target, StalkerDamage.blackhole, 1000000.0f, true);
        }
        this.target = null;
        this.activeTimer = 120;
    }

    @Override
    public void addTarget(of entity) {
        if (this.target == null && this.activeTimer == -1 && !entity.M && entity.aN() > 0.0f && !entity.ar() || this.k.I) {
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
        } else if (this.particleEmitter != null) {
            this.getParticleEmitter().reset();
        }
        this.activeTimer = -1;
        this.target = null;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    @Override
    public void onPlayerExit() {
        if (this.target != null) {
            this.doActivation(true);
        }
    }

    @Override
    protected Class getEmitterClass() {
        return FunnelParticleEmitter.class;
    }

    @Override
    public of getTarget() {
        return this.target;
    }

    @Override
    public boolean b(int par1, int par2) {
        if (par1 == 3) {
            this.doActivation(false);
            return true;
        }
        return super.b(par1, par2);
    }
}

