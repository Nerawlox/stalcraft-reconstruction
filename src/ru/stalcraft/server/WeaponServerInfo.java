/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.server;

import ru.stalcraft.StalkerMain;
import ru.stalcraft.WeaponInfo;
import ru.stalcraft.items.IFlashlight;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.network.ServerPacketSender;

public class WeaponServerInfo
extends WeaponInfo {
    private int cooldown = 0;
    private int reloadTime = -1;

    public WeaponServerInfo(uf player) {
        super(player);
    }

    @Override
    public void tick() {
        ye stack = this.player.bn.a[this.player.bn.c];
        yc item = null;
        if (stack != null && (item = yc.g[stack.d]) instanceof ItemWeapon) {
            if (this.currentWeapon != stack) {
                this.currentWeapon = stack;
            }
            if (!PlayerUtils.getTag(stack).n("weaponInfo")) {
                PlayerUtils.getTag(stack).a("reloadTime", ((ItemWeapon)item).reloadTime);
                PlayerUtils.getTag(stack).a("cooldown", ((ItemWeapon)item).cooldown);
                PlayerUtils.getTag(stack).a("fireModeLength", 0);
                PlayerUtils.getTag(stack).a("fireMode", ((ItemWeapon)item).fireMods[0].ordinal());
                PlayerUtils.getTag(stack).a("weaponInfo", true);
            }
            if (this.cooldown > 0) {
                --this.cooldown;
            }
            if (this.reloadTime > 0) {
                --this.reloadTime;
            } else if (this.reloadTime == 0) {
                this.reloadFinish(stack);
                this.reloadTime = -1;
            } else if (super.isReloading(stack)) {
                PlayerUtils.getTag(stack).a("reloading", false);
            }
        } else {
            if (this.flashlightOn) {
                this.flashlightToggleRequest(null);
            }
            this.reloadTime = -1;
            this.reloadingWeapon = null;
            this.cooldown = 0;
        }
        this.updateEquippedWeapons();
    }

    public boolean canShoot(ye stack) {
        return yc.g[stack.d] instanceof ItemWeapon && !PlayerUtils.getInfo(this.player).getHandcuffs() && this.cooldown <= 0 && super.getCage(stack) > 0 && this.reloadTime <= 0 && (!StalkerMain.instance.smHelper.isPlayerRunning(this.player) || ((ItemWeapon)yc.g[stack.d]).isPistol);
    }

    @Override
    public boolean canLaunchGrenade(ItemWeapon weapon) {
        return !PlayerUtils.getInfo(this.player).getHandcuffs() && this.cooldown <= 0 && PlayerUtils.hasItem(this.player, weapon.grenadeId) && this.reloadTime <= 0;
    }

    @Override
    public void onGrenadeLaunch(ItemWeapon weapon) {
        this.cooldown = weapon.grenadeLaunchCooldown;
        PlayerUtils.consumeItems(this.player, weapon.grenadeId, 1, true);
    }

    @Override
    public void onShoot(ye stack) {
        PlayerUtils.getTag(stack).a("cage", PlayerUtils.getTag(stack).e("cage") - 1);
        this.cooldown = ((ItemWeapon)yc.g[stack.d]).cooldown / 2;
    }

    public void flashlightToggleRequest(ye stack) {
        if (this.flashlightOn) {
            this.flashlightOn = false;
        } else if (stack != null && yc.g[stack.d] instanceof IFlashlight && ((IFlashlight)((Object)yc.g[stack.d])).canShine(stack)) {
            this.flashlightOn = true;
        }
        ServerPacketSender.sendFlashlight(this.player, this.flashlightOn);
    }

    @Override
    public void reloadRequest(ye stack) {
        if (!super.isReloading(stack) && this.reloadTime == -1 && super.getCage(stack) < ((ItemWeapon)yc.g[stack.d]).cageSize && PlayerUtils.hasItem(this.player, ((ItemWeapon)yc.g[stack.d]).bulletId) && !PlayerUtils.getInfo(this.player).getHandcuffs()) {
            this.reloadTime = ((ItemWeapon)yc.g[stack.d]).reloadTime;
            this.reloadingWeapon = stack;
            PlayerUtils.getTag(stack).a("reloading", true);
            ServerPacketSender.sendReloadStart(this.player);
        }
    }

    @Override
    public void reloadFinish(ye stack) {
        int bulletsInCage = PlayerUtils.getTag(stack).e("cage");
        int bulletCount = PlayerUtils.consumeItems(this.player, ((ItemWeapon)yc.g[stack.d]).bulletId, ((ItemWeapon)yc.g[stack.d]).cageSize - bulletsInCage, true);
        PlayerUtils.getTag(stack).a("cage", bulletCount + bulletsInCage);
        PlayerUtils.getTag(stack).a("reloading", false);
    }

    public void updateEquippedWeapons() {
        ye newPistol = null;
        ye newRifle = null;
        ye stack = null;
        ItemWeapon itemWeapon = null;
        for (int item = 0; item < 4; ++item) {
            stack = this.player.bn.a[item];
            if (item == this.player.bn.c || stack == null || !(yc.g[stack.d] instanceof ItemWeapon)) continue;
            itemWeapon = (ItemWeapon)yc.g[stack.d];
            if (!itemWeapon.renderEquipped) continue;
            if (itemWeapon.isPistol) {
                newPistol = stack;
                continue;
            }
            newRifle = stack;
        }
        if (this.pistol != newPistol || this.rifle != newRifle) {
            ServerPacketSender.sendEquippedWeapons(this.player, newRifle, newPistol);
        }
        this.pistol = newPistol;
        this.rifle = newRifle;
    }

    public void readNBT(by tag) {
    }

    public void writeNBT(by tag) {
    }

    public void updateFireMode(ye stack) {
        int fireModeLength;
        int preFireModeLength = fireModeLength = PlayerUtils.getTag(stack).e("fireModeLength");
        ItemWeapon itemWeapon = (ItemWeapon)yc.g[stack.d];
        if (fireModeLength < itemWeapon.fireMods.length - 1) {
            ++fireModeLength;
        } else if (fireModeLength == itemWeapon.fireMods.length - 1) {
            fireModeLength = 0;
        }
        PlayerUtils.getTag(stack).a("fireModeLength", fireModeLength);
        PlayerUtils.getTag(stack).a("fireMode", itemWeapon.fireMods[fireModeLength].ordinal());
        if (preFireModeLength != fireModeLength) {
            this.player.q.a((nn)this.player, "stalker:firemode", 1.0f, 0.9f + this.player.q.s.nextFloat() * 0.1f);
        }
    }
}

