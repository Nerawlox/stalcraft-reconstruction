/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 *  ata
 *  atc
 *  org.lwjgl.input.Mouse
 */
package ru.stalcraft.client;

import java.util.List;
import org.lwjgl.input.Mouse;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.WeaponInfo;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.client.network.ClientPacketSender;
import ru.stalcraft.entity.EntityFlashlight;
import ru.stalcraft.items.FireMode;
import ru.stalcraft.items.IFlashlight;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.PlayerUtils;

public class ClientWeaponInfo
extends WeaponInfo {
    public atv mc = atv.w();
    public boolean spawnedEntityFlashlight = false;
    public boolean isRecoil;
    private boolean isAiming = false;
    public int lastShoot = 100000;
    private int cooldown = 0;
    private int maxReloadTime = 0;
    private int reloadTime = -1;

    public ClientWeaponInfo(uf player) {
        super(player);
    }

    @Override
    public void tick() {
        ye stack;
        if (this.currentGun != null && FireMode.AUTO.isShoot(this.currentGun.cooldown > 0) && this.currentGun.reloadTime == -1 && this.currentGun.bulletsInCage > 0) {
            ClientPacketSender.sendMachineGunShootRequest();
            this.currentGun.cooldown = 3;
        }
        if (this.cooldown > 0) {
            --this.cooldown;
        }
        if ((stack = this.player.bn.a[this.player.bn.c]) != null && yc.g[stack.d] instanceof ItemWeapon) {
            if (super.getFireMode(stack).isShoot(this.cooldown > 0) && super.getCage(stack) > 0 && !super.isReloading(stack) && this.mc.n == null) {
                ClientPacketSender.sendShootRequest(0, this.isAiming() ? 0 : 1);
                this.onShoot(stack);
                this.cooldown = PlayerUtils.getTag(stack).e("cooldown");
            }
            if (StalkerMain.instance.smHelper.isPlayerRunning(this.player) && this.player != this.mc.h && !((ItemWeapon)yc.g[this.player.bn.a[this.player.bn.c].d]).isPistol) {
                this.player.bu();
            } else {
                this.player.a(stack, 21);
            }
            if (this.reloadTime > 0) {
                --this.reloadTime;
            } else if (super.isReloading(stack)) {
                this.reloadTime = -1;
                this.maxReloadTime = 0;
                this.reloadingWeapon = null;
            }
        } else {
            this.reloadTime = -1;
            this.maxReloadTime = 0;
            this.reloadingWeapon = null;
            if (this.spawnedEntityFlashlight) {
                ClientPacketSender.sendFlashlightRequest();
                this.spawnedEntityFlashlight = false;
            }
        }
        if (this.player.aN() > 0.0f && !this.player.M && this.flashlightOn && GuiSettingsStalker.dynamicLights && !this.spawnedEntityFlashlight && this.getLightPos() != null) {
            this.player.q.d(new EntityFlashlight(this.player));
        }
        ++this.lastShoot;
    }

    public ItemWeapon getReloadingWeapon() {
        return this.reloadingWeapon == null ? null : (ItemWeapon)this.reloadingWeapon.b();
    }

    public ata getLightPos() {
        atc playerVec = this.player.q.V().a(this.player.u, this.player.v + (double)this.player.f(), this.player.w);
        atc vec = this.player.j(0.0f);
        if (this.player.bn.a[this.player.bn.c] != null && yc.g[this.player.bn.a[this.player.bn.c].d] instanceof IFlashlight && ((IFlashlight)((Object)yc.g[this.player.bn.a[this.player.bn.c].d])).shouldRotateWhenSprinting() && StalkerMain.instance.smHelper.isPlayerRunning(this.player)) {
            vec.b((float)Math.toRadians(75.0));
        }
        atc lookVec = this.player.q.V().a(playerVec.c + vec.c * 50.0, playerVec.d + vec.d * 50.0, playerVec.e + vec.e * 50.0);
        return this.player.q.a(playerVec, lookVec);
    }

    public nn getEntityLookingAt() {
        atc vec3 = this.mc.i.l(0.0f);
        atc vec31 = this.mc.i.j(0.0f);
        atc vec32 = vec3.c(vec31.c * 50.0, vec31.d * 50.0, vec31.e * 50.0);
        List list = this.mc.f.b((nn)this.mc.i, this.mc.i.E.a(vec32.c, vec32.d, vec32.e).b(1.0, 1.0, 1.0));
        double d2 = 50.0;
        double d3 = 0.0;
        float f2 = 0.0f;
        nn pointedEntity = null;
        nn entity = null;
        asx axisalignedbb = null;
        ata movingobjectposition = null;
        for (int i2 = 0; i2 < list.size(); ++i2) {
            entity = (nn)list.get(i2);
            if (!entity.L()) continue;
            f2 = entity.Z();
            axisalignedbb = entity.E.b((double)f2, (double)f2, (double)f2);
            movingobjectposition = axisalignedbb.a(vec3, vec32);
            if (axisalignedbb.a(vec3)) {
                if (!(0.0 < d2) && d2 != 0.0) continue;
                pointedEntity = entity;
                d2 = 0.0;
                continue;
            }
            if (movingobjectposition == null || !((d3 = vec3.d(movingobjectposition.f)) < d2) && d2 != 0.0) continue;
            if (entity == this.mc.i.o && !entity.canRiderInteract()) {
                if (d2 != 0.0) continue;
                pointedEntity = entity;
                continue;
            }
            pointedEntity = entity;
            d2 = d3;
        }
        return pointedEntity;
    }

    public float getReloadRenderProgress(float frame) {
        return this.reloadTime <= 0 ? 0.0f : (this.reloadTime > this.maxReloadTime ? 1.0f : ((float)this.reloadTime > (float)this.maxReloadTime / 2.0f ? Math.min(1.0f, ((float)(this.maxReloadTime - this.reloadTime) + frame) / 5.0f) : Math.min(1.0f, ((float)this.reloadTime - frame) / 5.0f)));
    }

    public boolean isAiming() {
        return this.player != this.mc.h ? this.isAiming : Mouse.isButtonDown((int)1) && this.player.bn.a[this.player.bn.c] != null && !this.isReloading(this.player.bn.a[this.player.bn.c]) && this.mc.A && !StalkerMain.instance.smHelper.isPlayerRunning(this.player) && this.mc.u.aa == 0;
    }

    public void setPistol(ye stack) {
        this.pistol = stack;
    }

    public void setRifle(ye stack) {
        this.rifle = stack;
    }

    @Override
    public void reloadRequest(ye par1) {
        this.reloadTime = this.maxReloadTime = PlayerUtils.getTag(par1).e("reloadTime");
        this.reloadingWeapon = par1;
    }

    @Override
    public void reloadFinish(ye par1) {
    }

    public void setFlashlightOn(boolean flashlight) {
        this.flashlightOn = flashlight;
    }

    @Override
    public void onShoot(ye stack) {
        if (!this.isCooldowning(stack)) {
            this.lastShoot = 0;
        }
    }

    @Override
    public void onGrenadeLaunch(ItemWeapon par1) {
        this.lastShoot = 0;
    }

    @Override
    public boolean canLaunchGrenade(ItemWeapon par1) {
        return false;
    }

    public int getLastShot() {
        return this.lastShoot;
    }

    public int getCooldown() {
        return this.cooldown;
    }
}

