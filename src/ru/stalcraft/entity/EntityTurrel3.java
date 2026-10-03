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

public class EntityTurrel3
extends EntityTurrel {
    public EntityTurrel3(abw world) {
        super(world, Config.turrel3Cooldown, Config.turrel3Damage, 5.0f, -90.0f, 5.0f, StalkerMain.turrel2.cv, "stalker:heavyturrel_hit", "stalker:heavyturrel_shoot");
        this.a(2.8f, 1.2f);
        this.health = Config.turrel3Health;
    }

    public EntityTurrel3(abw world, String clanName, asx agroZone) {
        super(world, Config.turrel3Cooldown, Config.turrel3Damage, 5.0f, -90.0f, 5.0f, StalkerMain.turrel2.cv, "stalker:heavyturrel_hit", "stalker:heavyturrel_shoot", clanName, agroZone);
        this.a(2.8f, 1.2f);
        this.health = Config.turrel3Health;
    }

    @Override
    public String getSleeveModelName() {
        return "turrel3";
    }

    @Override
    public float getLightDistance() {
        return 5.5f;
    }

    @Override
    public float getSleeveDistance() {
        return 0.5f;
    }

    @Override
    public float f() {
        return 1.12f;
    }

    @Override
    public float getRotationPointZ() {
        return -1.12f;
    }
}

