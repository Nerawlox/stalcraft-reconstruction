/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ata
 *  atc
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
package ru.stalcraft.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.stalcraft.Logger;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.entity.EntityShot;
import ru.stalcraft.entity.EntitySleeve;
import ru.stalcraft.player.IPlayerServerInfo;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.network.ServerPacketSender;

public class TileEntityMachineGun
extends asp {
    private static final int CAGE_SIZE = 300;
    private static final int MAX_COOLDOWN = 2;
    private static final int MAX_RELOAD_TIME = 100;
    private static final int BULLET_ID = 14955;
    private static final String RELOAD_SOUND = "stalker:machinegun_reload";
    private static final String SHOOT_SOUND = "stalker:machinegun_shoot";
    private static final String HIT_SOUND = "stalker:machinegun_hit";
    public int bulletsInCage = 0;
    private uf shooter = null;
    public int cooldown = 0;
    public int reloadTime = -1;
    public float yaw = 0.0f;
    public float pitch = 0.0f;
    public float prevYaw = 0.0f;
    public float prevPitch = 0.0f;

    public void onRightClick(uf par1) {
        if (PlayerUtils.getInfo(par1) != null && PlayerUtils.getInfo(par1) instanceof IPlayerServerInfo) {
            ((IPlayerServerInfo)((Object)PlayerUtils.getInfo(par1))).shooterMachineGun(this);
            Logger.console("shooterGun!");
        }
    }

    public void shootRequest() {
        if (this.shooter != null && PlayerUtils.getInfo(this.shooter) != null && PlayerUtils.getInfo(this.shooter) instanceof IPlayerServerInfo) {
            ((IPlayerServerInfo)((Object)PlayerUtils.getInfo(this.shooter))).shootMachineGun(this);
        }
    }

    public void reloadRequest() {
        if (PlayerUtils.getInfo(this.shooter) != null && PlayerUtils.getInfo(this.shooter) instanceof IPlayerServerInfo) {
            ((IPlayerServerInfo)((Object)PlayerUtils.getInfo(this.shooter))).reloadRequestMachineGun(this);
        }
    }

    public void removeShooter() {
        if (this.shooter != null) {
            ServerPacketSender.sendMachinegunState(this.shooter, this, false);
            PlayerUtils.getInfo((uf)this.shooter).weaponInfo.currentGun = null;
        }
        this.shooter = null;
        this.yaw = 0.0f;
        this.pitch = 0.0f;
    }

    @Override
    public void h() {
        if (this.cooldown > 0) {
            --this.cooldown;
        }
        if (this.reloadTime > 0) {
            --this.reloadTime;
        }
        if (this.shooter != null && !this.k.I && this.shooter.bn.h() != null) {
            this.removeShooter();
        }
        if (this.shooter != null && this.reloadTime == 0) {
            if (!this.az().I) {
                this.reloadFinish();
            }
            this.reloadTime = -1;
        } else if (this.shooter == null && this.reloadTime == 0) {
            this.reloadTime = -1;
        }
        this.updatePlayerPos();
        this.updateRotation();
    }

    @SideOnly(value=Side.CLIENT)
    private uf getThePlayer() {
        return atv.w().h;
    }

    private void reloadFinish() {
        if (this.shooter != null && PlayerUtils.getInfo(this.shooter) != null && PlayerUtils.getInfo(this.shooter) instanceof IPlayerServerInfo) {
            ((IPlayerServerInfo)((Object)PlayerUtils.getInfo(this.shooter))).reloadFinishMachineGun(this);
        }
    }

    public boolean isBlocked(float yaw, float pitch) {
        atc lookVec;
        float length = 1.5f;
        double lookX = -ls.a((yaw += (float)(this.p() * 90)) / 180.0f * (float)Math.PI) * ls.b(pitch / 180.0f * (float)Math.PI) * length;
        double lookZ = ls.b(yaw / 180.0f * (float)Math.PI) * ls.b(pitch / 180.0f * (float)Math.PI) * length;
        double lookY = -ls.a(pitch / 180.0f * (float)Math.PI) * length;
        atc posVec = this.k.V().a((double)this.l + 0.5 + lookX * 0.5, (double)this.m + 0.4 + lookY * 0.5, (double)this.n + 0.5 + lookZ * 0.5);
        ata obj = this.k.a(posVec, lookVec = this.k.V().a(posVec.c + lookX, posVec.d + lookY, posVec.e + lookZ), false, true);
        return obj != null;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }

    public void updateRotation() {
        this.prevYaw = this.yaw;
        this.prevPitch = this.pitch;
        uf shooter = this.getShooter();
        if (shooter != null) {
            float tempPitch = Math.max(-60.0f, Math.min(shooter.B, 60.0f));
            float tempYaw = (shooter.A - (float)(this.p() * 90)) % 360.0f;
            if (tempYaw < -180.0f) {
                tempYaw += 360.0f;
            }
            if (tempYaw > 180.0f) {
                tempYaw -= 360.0f;
            }
            if (tempYaw > 90.0f) {
                tempYaw = 90.0f;
            }
            if (tempYaw < -90.0f) {
                tempYaw = -90.0f;
            }
            if (this.yaw == -90.0f && tempYaw == 90.0f || this.yaw == 90.0f && tempYaw == -90.0f) {
                return;
            }
            if (tempYaw != this.yaw || tempPitch != this.pitch) {
                if (!this.isBlocked(this.yaw, this.pitch) && this.isBlocked(tempYaw, tempPitch)) {
                    if (!this.isBlocked(tempYaw, this.pitch)) {
                        this.yaw = tempYaw;
                    } else if (!this.isBlocked(this.yaw, tempPitch)) {
                        this.pitch = tempPitch;
                    }
                } else {
                    this.pitch = tempPitch;
                    this.yaw = tempYaw;
                }
            }
        }
    }

    public void updatePlayerPos() {
        uf shooter = this.getShooter();
        if (shooter != null) {
            float realYaw = this.yaw + (float)(this.p() * 90);
            double newX = (double)(-(-ls.a(realYaw / 180.0f * (float)Math.PI))) * 1.2 + (double)this.l + 0.5;
            double newZ = (double)(-ls.b(realYaw / 180.0f * (float)Math.PI)) * 1.2 + (double)this.n + 0.5;
            if (Math.abs(shooter.u - newX) > 0.01 || Math.abs(shooter.w - newZ) > 0.01) {
                shooter.d(newX - shooter.u, -0.5, newZ - shooter.w);
            }
        }
    }

    public uf getShooter() {
        if (this.k.I && this.shooter != null && PlayerUtils.getInfo((uf)this.shooter).weaponInfo.currentGun == null) {
            this.shooter = null;
        }
        return this.shooter;
    }

    public void setShooter(uf shooter) {
        this.shooter = shooter;
    }

    @Override
    public void a(by tag) {
        super.a(tag);
        this.bulletsInCage = tag.e("bullets_in_cage");
        this.yaw = this.prevYaw = tag.g("rot_yaw");
        this.pitch = this.prevPitch = tag.g("rot_pitch");
    }

    @Override
    public void b(by tag) {
        super.b(tag);
        tag.a("bullets_in_cage", this.bulletsInCage);
        tag.a("rot_yaw", this.yaw);
        tag.a("rot_pitch", this.pitch);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean b(int par1, int par2) {
        if (par1 == 1) {
            this.bulletsInCage = par2;
            return true;
        }
        if (par1 == 2) {
            atv mc = atv.w();
            this.prevPitch = Math.max(-45.0f, this.prevPitch - 3.0f);
            if (GuiSettingsStalker.renderSleeves) {
                mc.f.d((nn)new EntitySleeve((abw)mc.f, (double)this.l + 0.5, (double)this.m + 0.5, (double)this.n + 0.5, this.yaw + (float)(this.p() * 90), this.pitch, 0.0f, "machinegun_sleeve"));
            }
            mc.f.d((nn)new EntityShot((abw)mc.f, (double)this.l + 0.5, (double)this.m + 0.5, (double)this.n + 0.5, this.yaw + (float)(this.p() * 90), this.pitch, 1.0f, 1.5f));
            return true;
        }
        if (par1 == 3) {
            this.reloadTime = par2;
            return true;
        }
        if (par1 == 4) {
            return true;
        }
        return super.b(par1, par2);
    }
}

