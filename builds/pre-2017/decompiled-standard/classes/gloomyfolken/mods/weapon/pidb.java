/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.core.misc.tdpf;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.physics.ragdolls.RagdollsHooks;
import gloomyfolken.mods.stalker.mobs.packet.PacketClientNoise;
import gloomyfolken.mods.weapon.WeaponMod;
import gloomyfolken.mods.weapon.entity.EntityBulletHole;
import gloomyfolken.mods.weapon.jgro;
import gloomyfolken.mods.weapon.trace.EntityTracer;
import gloomyfolken.mods.weapon.ugqx;
import gloomyfolken.mods.weapon.zwat;
import java.util.List;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ezfc;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraftforge.common.MinecraftForge;

public class pidb {
    private static final boolean _a = false;
    private static boolean _b;

    public static float _a(Entity entity, float f, float f2) {
        float f3 = f + (1.0f - f2) * 30.0f;
        if (entity != null) {
            float f4 = (entity.field_70140_Q - entity.field_70141_P) / 0.6f;
            f3 += f4 * (1.0f - f2) * 200.0f;
        }
        return f3;
    }

    private static double _a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d7 - d4;
        double d11 = d8 - d5;
        double d12 = d9 - d6;
        double d13 = d - d4;
        double d14 = d2 - d5;
        double d15 = d3 - d6;
        double d16 = (d13 * d10 + d14 * d11 + d15 * d12) / (d10 * d10 + d11 * d11 + d12 * d12);
        double d17 = d13 - d16 * d10;
        double d18 = d14 - d16 * d11;
        double d19 = d15 - d16 * d12;
        return Math.sqrt(d17 * d17 + d18 * d18 + d19 * d19);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @ezey(_a={eidj.CLIENT})
    public static void _a(Entity entity, float f) {
        zwat zwat2;
        if (entity instanceof zwat) {
            zwat2 = (zwat)((Object)entity);
        } else if (entity instanceof EntityPlayer && ugqx._a((EntityPlayer)((EntityPlayer)entity))._f != null) {
            zwat2 = ugqx._a((EntityPlayer)((EntityPlayer)entity))._f;
        } else {
            if (!(entity instanceof EntityLivingBase)) return;
            cvzo cvzo2 = ((EntityLivingBase)entity).func_70694_bm();
            if (cvzo2 == null || !(cvzo2._a() instanceof wolf)) return;
            zwat2 = (wolf)cvzo2._a();
        }
        if (sbzn._g.enabled && xpzm._E()._t.func_70032_d(entity) < 16.0f) {
            zwat2.spawnShell(entity);
        }
        pidb._a(entity, zwat2.getShootSoundName(entity), 8.0f, f);
        zwat2.onShootClient(entity);
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(Entity entity, String string, float f, float f2) {
        boolean bl = entity == xpzm._E()._t;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        if (!bl) {
            ofbx ofbx2 = entity.func_70040_Z();
            tdpf._a(ofbx2, 0.3);
            f3 = (float)ofbx2._c;
            f4 = (float)ofbx2._d;
            f5 = (float)ofbx2._e;
        }
        dwwh._a._a(f2, entity.field_70165_t + (double)f3, entity.field_70163_u + (double)f4, entity.field_70161_v + (double)f5, string, f, entity.field_70170_p.field_73012_v.nextFloat() * 0.1f + 0.9f, bl);
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(ofbx ofbx2, ofbx ofbx3, int n, byte by, boolean bl, float f) {
        Object object;
        if (by == -1) {
            return;
        }
        xpzm xpzm2 = xpzm._E();
        twgu twgu2 = twgu.field_71973_m[n];
        ofbx ofbx4 = ofbx._a(ofbx3._c, ofbx3._d, ofbx3._e);
        switch (by) {
            case 0: {
                ofbx4._d += 0.1;
                break;
            }
            case 1: {
                ofbx4._d -= 0.1;
                break;
            }
            case 2: {
                ofbx4._e += 0.1;
                break;
            }
            case 3: {
                ofbx4._e -= 0.1;
                break;
            }
            case 4: {
                ofbx4._c += 0.1;
                break;
            }
            case 5: {
                ofbx4._c -= 0.1;
            }
        }
        int n2 = sajh._c(ofbx4._c);
        int n3 = sajh._c(ofbx4._d);
        int n4 = sajh._c(ofbx4._e);
        ndrq.kjui kjui2 = sbzn._c._a(xpzm2._r, n2, n3, n4);
        if (kjui2 != null && sbzn._i.enabled) {
            if (xpzm2._t.func_70011_f(ofbx3._c, ofbx3._d, ofbx3._e) < 32.0) {
                object = new EntityBulletHole(xpzm2._r, ofbx3._c, ofbx3._d, ofbx3._e, by, kjui2._b);
                if (twgu2 == null || !twgu2.func_71926_d() && twgu2 != twgu.field_71946_M) {
                    ((EntityBulletHole)object).sideHit = -1;
                }
                ((EntityBulletHole)object).isKnifeHole = bl;
                xpzm2._r.func_72838_d((Entity)object);
            }
            gloomyfolken.mods.effects.client.main.pidb._a(new broz(xpzm2._r, null, false, by, ofbx2, ofbx3));
        }
        if (kjui2 != null) {
            object = bl ? kjui2._d : kjui2._c;
            dwwh._a._a(f, ofbx3._c, ofbx3._d, ofbx3._e, (String)object, 1.0f, xpzm2._r.field_73012_v.nextFloat() * 0.1f + 0.9f, false);
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(ofbx ofbx2, ofbx ofbx3, Entity entity, boolean bl, float f) {
        xpzm xpzm2 = xpzm._E();
        if (entity instanceof EntityLivingBase && (entity != xpzm2._t || xpzm2._M.field_74320_O != 0)) {
            gloomyfolken.mods.effects.client.main.pidb._a(new broz(xpzm2._r, entity, true, -1, ofbx2, ofbx3));
        }
        String string = bl ? "weapons:melee.hit" : "weapons:bullet.hit";
        dwwh._a._a(f, ofbx3._c, ofbx3._d, ofbx3._e, string, 1.0f, xpzm2._r.field_73012_v.nextFloat() * 0.1f + 0.9f, false);
    }

    @ezey(_a={eidj.CLIENT})
    public static void _a(ofbx ofbx2, ofbx ofbx3, float f) {
        xpzm xpzm2 = xpzm._E();
        EntityClientPlayerMP entityClientPlayerMP = xpzm2._t;
        if (((Entity)entityClientPlayerMP).func_70092_e(ofbx2._c, ofbx2._d, ofbx2._e) > 256.0 && ((Entity)entityClientPlayerMP).func_70092_e(ofbx3._c, ofbx3._d, ofbx3._e) > 256.0) {
            ofbx ofbx4 = ofbx._a(entityClientPlayerMP.field_70165_t - ofbx2._c, entityClientPlayerMP.field_70163_u - ofbx2._d, entityClientPlayerMP.field_70161_v - ofbx2._e);
            ofbx ofbx5 = ofbx2._a(ofbx3);
            ofbx ofbx6 = ofbx._a(entityClientPlayerMP.field_70165_t - ofbx3._c, entityClientPlayerMP.field_70163_u - ofbx3._d, entityClientPlayerMP.field_70161_v - ofbx3._e);
            ofbx ofbx7 = ofbx4._c(ofbx5);
            ofbx ofbx8 = ofbx7._c(ofbx5)._a();
            double d = ofbx4._c(ofbx6)._b() / ofbx5._b();
            double d2 = entityClientPlayerMP.field_70165_t + ofbx8._c * d;
            double d3 = entityClientPlayerMP.field_70163_u + ofbx8._d * d;
            double d4 = entityClientPlayerMP.field_70161_v + ofbx8._e * d;
            if (d2 > Math.min(ofbx2._c, ofbx3._c) && d2 < Math.max(ofbx2._c, ofbx3._c) && d3 > Math.min(ofbx2._d, ofbx3._d) && d3 < Math.max(ofbx2._d, ofbx3._d) && d4 > Math.min(ofbx2._e, ofbx3._e) && d4 < Math.max(ofbx2._e, ofbx3._e)) {
                dwwh._a._a(f, d2, d3, d4, "weapons:bullet.whine", 1.0f, xpzm2._r.field_73012_v.nextFloat() * 0.1f + 0.9f, false);
            }
        }
    }

    @ezey(_a={eidj.CLIENT})
    public static ugqx.pidb _a(boolean bl) {
        EntityClientPlayerMP entityClientPlayerMP = xpzm._E()._t;
        ugqx ugqx2 = ugqx._a(entityClientPlayerMP);
        if (ugqx2._f != null) {
            pidb._a(entityClientPlayerMP, ugqx2._f, 0.0f);
            return ugqx.pidb._a;
        }
        cvzo cvzo2 = entityClientPlayerMP.func_71045_bC();
        if (cvzo2 == null || !(cvzo2._a() instanceof wolf)) {
            return ugqx.pidb._b;
        }
        wolf wolf2 = (wolf)cvzo2._a();
        ugqx.pidb pidb2 = ugqx2._b(cvzo2);
        switch (pidb2) {
            case _a: {
                MinecraftForge.EVENT_BUS.post(new yund.jgro.pidb(entityClientPlayerMP));
                float f = ugqx2._q();
                pidb._a(entityClientPlayerMP, (wolf)cvzo2._a(), f);
                ugqx2._a(cvzo2, f);
                pidb._a(entityClientPlayerMP, f);
                cvzo2._a(1, (EntityLivingBase)entityClientPlayerMP);
                return pidb2;
            }
            case _c: {
                if (bl) {
                    pidb._a((Entity)entityClientPlayerMP, wolf2._a(wolf2._N, (EntityLivingBase)entityClientPlayerMP, cvzo2), 1.0f, 0.0f);
                }
                return pidb2;
            }
            case _d: {
                ugqx2._a((Object)((Object)ezfc._m) + "\u0417\u0430\u043a\u043b\u0438\u043d\u0438\u043b\u043e, \u043d\u0430\u0436\u043c\u0438\u0442\u0435 " + GameSettings.func_74298_c(WeaponMod.instance._y._d));
                if (bl) {
                    new PacketClientNoise(30.0f).sendToServer();
                    pidb._a((Entity)entityClientPlayerMP, wolf2._a(wolf2._M, (EntityLivingBase)entityClientPlayerMP, cvzo2), 1.0f, 0.0f);
                }
                return pidb2;
            }
        }
        return pidb2;
    }

    @ezey(_a={eidj.CLIENT})
    private static void _a(EntityPlayer entityPlayer, zwat zwat2, float f) {
        ugqx ugqx2 = ugqx._a(entityPlayer);
        float f2 = zwat2.getMaxDistance(entityPlayer);
        int n = zwat2.getNumBullets(entityPlayer);
        ofbx ofbx2 = ofbx._a(entityPlayer.field_70165_t, entityPlayer.field_70163_u, entityPlayer.field_70161_v);
        ofbx ofbx3 = VecExtensionsKt.addVector(ofbx2, EntityTracer._a(entityPlayer.field_70759_as, entityPlayer.field_70125_A, 0.0f, f2));
        List<Entity> list2 = EntityTracer._a(entityPlayer.field_70170_p, ofbx2, ofbx3, (float)(Math.toRadians(zwat2.getSpread(entityPlayer)) * 3.0), entityPlayer);
        for (int i = 0; i < n; ++i) {
            EntityTracer.kjui kjui2 = EntityTracer._a(entityPlayer.field_70170_p, ofbx2, ofbx3, (Entity)entityPlayer, null, true);
            if (kjui2 == null || kjui2._i == null) continue;
            pidb._a(kjui2._i, kjui2, ofbx2, f);
        }
        ugqx ugqx3 = ugqx._a(entityPlayer);
        if (ugqx3 != null) {
            new xams(new jgro(ofbx2, ofbx3, n, list2, ugqx3._m(), ugqx3._q(), pidb._a(zwat2))).sendToServer();
        }
    }

    @ezey(_a={eidj.CLIENT})
    private static int _a(zwat zwat2) {
        if (_b) {
            // empty if block
        }
        int n = 0;
        n |= xpzm._E()._t.field_71075_bZ._d ? 1 : 0;
        n |= xpzm._E()._M.field_74333_Y != 0.0f ? 2 : 0;
        if (zwat2 instanceof wolf) {
            wolf wolf2 = (wolf)zwat2;
            if (wolf2.__an != (Float.floatToIntBits(wolf2._h) ^ Float.floatToIntBits(wolf2._i) ^ 0x936A2B0E)) {
                n |= 4;
            }
        }
        if (wnja._a()) {
            n |= 8;
        }
        if (n != 0) {
            _b = true;
        }
        return n;
    }

    @ezey(_a={eidj.CLIENT})
    private static void _a(Entity entity, EntityTracer.kjui kjui2, ofbx ofbx2, float f) {
        znw.mods.stalkerguide.pidb._a(null, entity, kjui2, ofbx2, f);
        RagdollsHooks.onClientShot(null, entity, kjui2, ofbx2, f);
    }
}

