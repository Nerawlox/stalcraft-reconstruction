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

public class EntityTurrel2
extends EntityTurrel {
    public EntityTurrel2(abw world) {
        super(world, Config.turrel2Cooldown, Config.turrel2Damage, 5.0f, -75.0f, 5.0f, StalkerMain.turrel2.cv, "stalker:middleturrel_hit", "stalker:middleturrel_shoot");
        this.a(2.8f, 0.8f);
        this.health = Config.turrel2Health;
    }

    public EntityTurrel2(abw world, String clanName, asx agroZone) {
        super(world, Config.turrel2Cooldown, Config.turrel2Damage, 5.0f, -75.0f, 5.0f, StalkerMain.turrel2.cv, "stalker:middleturrel_hit", "stalker:middleturrel_shoot", clanName, agroZone);
        this.a(2.8f, 0.8f);
        this.health = Config.turrel2Health;
    }

    @Override
    public String getSleeveModelName() {
        return "turrel2";
    }

    @Override
    public float getLightDistance() {
        return 2.7f;
    }

    @Override
    public float getSleeveDistance() {
        return 1.2f;
    }

    @Override
    public float f() {
        return 0.36f;
    }

    @Override
    public float getRotationPointZ() {
        return 1.0f;
    }
}

