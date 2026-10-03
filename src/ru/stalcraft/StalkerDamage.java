/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  nb
 */
package ru.stalcraft;

import ru.stalcraft.EntityDamageSourceBullet;

public class StalkerDamage
extends nb {
    protected String deathMessage;
    public static nb radiation = new StalkerDamage("radiation", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0440\u0430\u0434\u0438\u0430\u0446\u0438\u0438").j();
    public static nb chemical = new StalkerDamage("chemical", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0442\u0435\u0440\u043c\u0438\u0447\u0435\u0441\u043a\u043e\u0433\u043e \u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u044f").j();
    public static nb biological = new StalkerDamage("biological", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0431\u0438\u043e\u043b\u043e\u0433\u0438\u0447\u0435\u0441\u043a\u043e\u0433\u043e \u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u044f").j();
    public static nb psy = new StalkerDamage("psy", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u041f\u0421\u0418-\u0438\u0437\u043b\u0443\u0447\u0435\u043d\u0438\u044f").j();
    public static nb blackhole = new StalkerDamage("blackhole", " \u0440\u0430\u0437\u043e\u0440\u0432\u0430\u043b\u043e \u0432\u043e\u0440\u043e\u043d\u043a\u043e\u0439").j();
    public static nb web = new StalkerDamage("web", " \u043f\u043e\u0433\u0438\u0431 \u0432 \u043a\u043e\u043b\u044e\u0447\u0435\u0439 \u043f\u0440\u043e\u0432\u043e\u043b\u043e\u043a\u0435").j();
    public static nb ejection = new StalkerDamage("ejection", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0432\u044b\u0431\u0440\u043e\u0441\u0430").j();
    public static nb electra = new StalkerDamage("electra", " \u0443\u0431\u0438\u043b\u043e \u044d\u043b\u0435\u043a\u0442\u0440\u043e\u0439").j();
    public static nb carousel = new StalkerDamage("carousel", " \u0440\u0430\u0437\u043e\u0440\u0432\u0430\u043b\u043e \u043a\u0430\u0440\u0443\u0441\u0435\u043b\u044c\u044e").j();
    public static nb coach = new StalkerDamage("coach", " \u043f\u043e\u0433\u0438\u0431 \u0438\u0437-\u0437\u0430 \u0442\u0440\u0435\u043d\u0435\u0440\u0430").j();
    public static nb kissel = new StalkerDamage("kissel", " \u0440\u0430\u0441\u0442\u0432\u043e\u0440\u0438\u043b\u0441\u044f \u0432 \u043a\u0438\u0441\u0435\u043b\u0435").j();
    public static nb steam = new StalkerDamage("steam", " \u0441\u0432\u0430\u0440\u0438\u043b\u0441\u044f \u0432 \u043f\u0430\u0440\u0435").j();
    public static nb trampoline = new StalkerDamage("steam", " \u0440\u0430\u0437\u043e\u0440\u0432\u0430\u043b\u043e \u0431\u0430\u0442\u0443\u0442\u043e\u043c").j();

    protected StalkerDamage(String name, String message) {
        super(name);
        this.deathMessage = message;
    }

    public static nb causeBulletDamage(nn par1) {
        return new EntityDamageSourceBullet("bullet", par1);
    }

    public cv b(of par1) {
        return new cv().a(par1.an() + this.deathMessage);
    }
}

