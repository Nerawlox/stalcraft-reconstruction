/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import java.util.Collection;
import java.util.UUID;

public class sajz {
    public static final txei _a = new bbnt("generic.maxHealth", 20.0, 0.0, Double.MAX_VALUE)._a("Max Health")._a(true);
    public static final txei _b = new bbnt("generic.followRange", 32.0, 0.0, 2048.0)._a("Follow Range");
    public static final txei _c = new bbnt("generic.knockbackResistance", 0.0, 0.0, 1.0)._a("Knockback Resistance");
    public static final txei _d = new bbnt("generic.movementSpeed", 0.7f, 0.0, Double.MAX_VALUE)._a("Movement Speed")._a(true);
    public static final txei _e = new bbnt("generic.attackDamage", 2.0, 0.0, Double.MAX_VALUE);

    public static bsyv _a(mbno mbno2) {
        bsyv bsyv2 = new bsyv();
        for (hubf hubf2 : mbno2._a()) {
            bsyv2._a(sajz._a(hubf2));
        }
        return bsyv2;
    }

    public static qoac _a(hubf hubf2) {
        qoac qoac2 = new qoac();
        txei txei2 = hubf2._a();
        qoac2._a("Name", txei2._a());
        qoac2._a("Base", hubf2._b());
        Collection collection = hubf2._c();
        if (collection != null && !collection.isEmpty()) {
            bsyv bsyv2 = new bsyv();
            for (xson xson2 : collection) {
                if (!xson2._e()) continue;
                bsyv2._a(sajz._a(xson2));
            }
            qoac2._a("Modifiers", bsyv2);
        }
        return qoac2;
    }

    public static qoac _a(xson xson2) {
        qoac qoac2 = new qoac();
        qoac2._a("Name", xson2._b());
        qoac2._a("Amount", xson2._d());
        qoac2._a("Operation", xson2._c());
        qoac2._a("UUIDMost", xson2._a().getMostSignificantBits());
        qoac2._a("UUIDLeast", xson2._a().getLeastSignificantBits());
        return qoac2;
    }

    public static void _a(mbno mbno2, bsyv bsyv2, jjmf jjmf2) {
        for (int i = 0; i < bsyv2._d(); ++i) {
            qoac qoac2 = (qoac)bsyv2._b(i);
            hubf hubf2 = mbno2._a(qoac2._j("Name"));
            if (hubf2 != null) {
                sajz._a(hubf2, qoac2);
                continue;
            }
            if (jjmf2 == null) continue;
            jjmf2._b("Ignoring unknown attribute '" + qoac2._j("Name") + "'");
        }
    }

    public static void _a(hubf hubf2, qoac qoac2) {
        hubf2._a(qoac2._i("Base"));
        if (qoac2._c("Modifiers")) {
            bsyv bsyv2 = qoac2._n("Modifiers");
            for (int i = 0; i < bsyv2._d(); ++i) {
                xson xson2 = sajz._a((qoac)bsyv2._b(i));
                xson xson3 = hubf2._a(xson2._a());
                if (xson3 != null) {
                    hubf2._b(xson3);
                }
                hubf2._a(xson2);
            }
        }
    }

    public static xson _a(qoac qoac2) {
        UUID uUID = new UUID(qoac2._g("UUIDMost"), qoac2._g("UUIDLeast"));
        return new xson(uUID, qoac2._j("Name"), qoac2._i("Amount"), qoac2._f("Operation"));
    }
}

