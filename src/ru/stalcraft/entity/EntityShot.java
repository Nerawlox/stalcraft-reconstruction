/*
 * Decompiled with CFR 0.152.
 */
package ru.stalcraft.entity;

import ru.stalcraft.client.ClientWeaponInfo;
import ru.stalcraft.client.ShotLightManager;
import ru.stalcraft.client.gui.GuiSettingsStalker;
import ru.stalcraft.items.ItemWeapon;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.tile.IParticleEmmiter;

public class EntityShot
extends nn
implements IParticleEmmiter {
    public final of shooter;
    public final ItemWeapon weapon;
    public final float size;
    public final float distance;
    public final float rotationRoll;
    public boolean spawnedParticles = false;

    public EntityShot(of shooter, ItemWeapon weapon, boolean isShooterPlayer) {
        super(shooter.q);
        this.shooter = shooter;
        this.weapon = weapon;
        float distance = weapon.lightDistance;
        if (!isShooterPlayer || shooter != atv.w().h || atv.w().u.aa != 0) {
            // empty if block
        }
        float size = weapon.lightSize;
        super.a(0.5f, 0.5f);
        super.b(shooter.u, shooter.v + (double)0.05f + (double)shooter.f() - (shooter.ah() ? 0.29 : 0.2) + (isShooterPlayer ? 0.0 : 0.27), shooter.w, shooter.aP, shooter.B);
        if (shooter == atv.w().h && ((ClientWeaponInfo)PlayerUtils.getInfo((uf)atv.w().h).weaponInfo).isAiming()) {
            distance += weapon.aimPosZ;
            distance *= weapon.zoom;
        }
        this.u += (double)(-ls.a(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * distance);
        this.w += (double)(ls.b(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * distance);
        this.v += (double)(-ls.a(this.B / 180.0f * (float)Math.PI) * distance);
        if (shooter == atv.w().h && atv.w().u.aa == 0) {
            if (!((ClientWeaponInfo)PlayerUtils.getInfo((uf)atv.w().h).weaponInfo).isAiming()) {
                this.u -= (double)ls.b(this.A / 180.0f * (float)Math.PI) * 0.16;
                this.w -= (double)ls.a(this.A / 180.0f * (float)Math.PI) * 0.16;
            }
        } else {
            this.u -= (double)ls.b(this.A / 180.0f * (float)Math.PI) * (isShooterPlayer ? 0.16 : 0.25);
            this.w -= (double)ls.a(this.A / 180.0f * (float)Math.PI) * (isShooterPlayer ? 0.16 : 0.25);
        }
        if (shooter != atv.w().h) {
            this.v -= 0.1;
        }
        this.size = size;
        super.b(this.u, this.v, this.w);
        this.rotationRoll = (float)Math.random() * 360.0f;
        this.distance = distance;
        ShotLightManager.addLight(this);
    }

    public EntityShot(abw w2, double posX, double posY, double posZ, float yaw, float pitch, float size, float distance) {
        super(w2);
        this.shooter = null;
        this.weapon = null;
        super.a(0.5f, 0.5f);
        super.b(posX, posY, posZ, yaw, pitch);
        this.u += (double)(-ls.a(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * distance);
        this.w += (double)(ls.b(this.A / 180.0f * (float)Math.PI) * ls.b(this.B / 180.0f * (float)Math.PI) * distance);
        this.v += (double)(-ls.a(this.B / 180.0f * (float)Math.PI) * distance);
        this.size = size;
        this.rotationRoll = (float)Math.random() * 360.0f;
        this.distance = distance;
        ShotLightManager.addLight(this);
    }

    @Override
    public void l_() {
        super.l_();
        float par1 = 0.0f;
        if (this.ac > 4 || !GuiSettingsStalker.advancedShot && this.ac > 2) {
            super.x();
        }
    }

    @Override
    protected void a() {
        this.ah.a(10, (Object)0);
    }

    @Override
    protected void a(by nbttagcompound) {
    }

    @Override
    protected void b(by nbttagcompound) {
    }

    @Override
    public int c(float par1) {
        return 0xF000F0;
    }

    @Override
    public float d(float par1) {
        return 1.0f;
    }

    @Override
    public int getPosX() {
        return (int)this.u;
    }

    @Override
    public int getPosY() {
        return (int)this.v;
    }

    @Override
    public int getPosZ() {
        return (int)this.w;
    }

    @Override
    public abw getWorld() {
        return this.q;
    }
}

