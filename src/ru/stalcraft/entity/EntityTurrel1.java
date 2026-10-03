/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  asx
 */
package ru.stalcraft.entity;

import ru.stalcraft.Config;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.entity.EntityTurrel;

public class EntityTurrel1
extends EntityTurrel {
    public EntityTurrel1(abw world) {
        super(world, Config.turrel1Cooldown, Config.turrel1Damage, 20.0f, -90.0f, 45.0f, StalkerMain.turrel1.cv, "stalker:lightturrel_hit", "stalker:lightturrel_shoot");
        this.a(0.7f, 0.8f);
        this.health = Config.turrel1Health;
    }

    public EntityTurrel1(abw world, String clanName, asx agroZone) {
        super(world, Config.turrel1Cooldown, Config.turrel1Damage, 20.0f, -90.0f, 45.0f, StalkerMain.turrel1.cv, "stalker:lightturrel_hit", "stalker:lightturrel_shoot", clanName, agroZone);
        this.a(0.7f, 0.8f);
        this.health = Config.turrel1Health;
    }

    @Override
    public void l_() {
        this.prevGunRoll = this.gunRoll;
        if (this.lastShot < Config.turrel2Cooldown) {
            this.gunRoll += (float)(360 / Config.turrel1Cooldown / 8);
            if (this.gunRoll > 360.0f) {
                this.gunRoll -= 360.0f;
            }
        }
        super.l_();
    }

    @Override
    public String getSleeveModelName() {
        return "turrel1";
    }

    @Override
    public float getLightDistance() {
        return 1.5f;
    }

    @Override
    public float getSleeveDistance() {
        return 0.1f;
    }

    @Override
    public float f() {
        return 0.425f;
    }

    @Override
    public float getRotationPointZ() {
        return 0.115f;
    }
}

