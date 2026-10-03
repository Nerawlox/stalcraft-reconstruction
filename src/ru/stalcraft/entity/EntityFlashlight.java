/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ata
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
package ru.stalcraft.entity;

import atomicstryker.dynamiclights.client.DynamicLights;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.stalcraft.WeaponInfo;
import ru.stalcraft.client.ClientWeaponInfo;
import ru.stalcraft.client.FlashlightLight;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.player.PlayerUtils;

@SideOnly(value=Side.CLIENT)
public class EntityFlashlight
extends nn {
    private uf player;

    public EntityFlashlight(uf player) {
        super(player.q);
        this.player = player;
        this.a(0.0f, 0.0f);
        this.Z = true;
        ((ClientWeaponInfo)PlayerUtils.getInfo((uf)player).weaponInfo).spawnedEntityFlashlight = true;
        this.updatePos();
        DynamicLights.addLightSource(new FlashlightLight(this));
    }

    @Override
    public void l_() {
        super.l_();
        WeaponInfo wi2 = PlayerUtils.getInfo((uf)this.player).weaponInfo;
        if (!this.player.M && this.player.aN() > 0.0f && GuiSettingsStalker.dynamicLights && wi2.isFlashlightEnabled()) {
            this.updatePos();
        } else {
            this.x();
        }
    }

    @Override
    public void x() {
        super.x();
        ((ClientWeaponInfo)PlayerUtils.getInfo((uf)this.player).weaponInfo).spawnedEntityFlashlight = false;
    }

    private void updatePos() {
        ata obj = ((ClientWeaponInfo)PlayerUtils.getInfo((uf)this.player).weaponInfo).getLightPos();
        boolean x2 = false;
        boolean y2 = false;
        boolean z2 = false;
        if (obj != null) {
            int var5 = obj.b;
            int var6 = obj.c;
            int var7 = obj.d;
            if (obj.e == 0) {
                --var6;
            }
            if (obj.e == 1) {
                ++var6;
            }
            if (obj.e == 2) {
                --var7;
            }
            if (obj.e == 3) {
                ++var7;
            }
            if (obj.e == 4) {
                --var5;
            }
            if (obj.e == 5) {
                ++var5;
            }
            this.b((double)var5 + 0.5, (double)var6 + 0.5, (double)var7 + 0.5);
        } else {
            this.x();
        }
    }

    @Override
    protected void a() {
    }

    @Override
    protected void a(by nbttagcompound) {
    }

    @Override
    protected void b(by nbttagcompound) {
    }
}

