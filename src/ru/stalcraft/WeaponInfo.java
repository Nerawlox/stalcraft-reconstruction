/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft;

import ru.stalcraft.items.FireMode;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.tile.TileEntityMachineGun;

public abstract class WeaponInfo {
    protected uf player;
    private int lastCurrentItem = -1;
    protected boolean flashlightOn = false;
    private boolean shouldSync = false;
    public TileEntityMachineGun currentGun = null;
    protected ye pistol = null;
    protected ye rifle = null;
    protected ye reloadingWeapon = null;
    protected ye currentWeapon = null;

    public WeaponInfo(uf player) {
        this.player = player;
    }

    public ye getPistol() {
        return this.pistol;
    }

    public ye getRifle() {
        return this.rifle;
    }

    public boolean isReloading(ye par1) {
        return PlayerUtils.getTag(par1).n("reloading");
    }

    public boolean isCooldowning(ye par1) {
        return PlayerUtils.getTag(par1).n("cooldowning");
    }

    public int getCage(ye par1) {
        return PlayerUtils.getTag(par1).e("cage");
    }

    public FireMode getFireMode(ye stack) {
        return FireMode.values()[PlayerUtils.getTag(stack).e("fireMode")];
    }

    public boolean isFlashlightEnabled() {
        return this.flashlightOn;
    }

    public boolean isUsingMachineGun() {
        return this.currentGun != null;
    }

    public abstract void tick();

    public abstract void reloadRequest(ye var1);

    public abstract void reloadFinish(ye var1);

    public abstract void onShoot(ye var1);

    public abstract void onGrenadeLaunch(ItemWeapon var1);

    public abstract boolean canLaunchGrenade(ItemWeapon var1);
}

