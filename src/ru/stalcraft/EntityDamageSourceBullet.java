/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nc
 */
package ru.stalcraft;

public class EntityDamageSourceBullet
extends nc {
    public EntityDamageSourceBullet(String name, nn shooter) {
        super(name, shooter);
        this.b();
    }

    public cv b(of entity) {
        return new cv().a(entity.an() + " \u0431\u044b\u043b \u0437\u0430\u0441\u0442\u0440\u0435\u043b\u0435\u043d " + (this.i() == null ? "\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u043c" : this.i().an()));
    }
}

