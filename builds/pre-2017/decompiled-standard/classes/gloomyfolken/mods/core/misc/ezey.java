/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.asm.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.jxtc;
import net.minecraft.util.vjta;
import net.minecraft.util.zwat;
import net.minecraftforge.common.ForgeHooks;

public class ezey
extends jxtc {
    protected String _j;
    public kjui _k;
    public static jxtc _l = new ezey("radiation", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0440\u0430\u0434\u0438\u0430\u0446\u0438\u0438", kjui._g).func_76348_h();
    public static jxtc _m = new ezey("biological", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0431\u0438\u043e\u043b\u043e\u0433\u0438\u0447\u0435\u0441\u043a\u043e\u0433\u043e \u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u044f", kjui._g).func_76348_h();
    public static jxtc _n = new ezey("psycho", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u043f\u0441\u0438-\u0430\u0442\u0430\u043a\u0438", kjui._i).func_76348_h();
    public static jxtc _o = new ezey("bleeding", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u043a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u044f", kjui._i).func_76348_h();
    public static jxtc _p = new ezey("thermal", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0442\u0435\u0440\u043c\u0438\u0447\u0435\u0441\u043a\u043e\u0433\u043e \u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u044f", kjui._i).func_76348_h();
    public static jxtc _q = new ezey("web", " \u043f\u043e\u0433\u0438\u0431 \u0432 \u043a\u043e\u043b\u044e\u0447\u0435\u0439 \u043f\u0440\u043e\u0432\u043e\u043b\u043e\u043a\u0435", kjui._d);
    public static jxtc _r = new ezey("artefakt", " \u043f\u043e\u0433\u0438\u0431 \u0438\u0437-\u0437\u0430 \u0432\u043e\u0437\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f \u0430\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u0430", kjui._i).func_76348_h();

    public ezey(String string, String string2, kjui kjui2) {
        super(string);
        this._j = string2;
        this._k = kjui2;
    }

    @Override
    public zwat func_76360_b(EntityLivingBase entityLivingBase) {
        return new zwat()._a(entityLivingBase.func_70023_ak() + this._j);
    }

    public static void _a(Entity entity, jxtc jxtc2, float f, boolean bl) {
        if (bl && entity instanceof EntityPlayerMP) {
            ((EntityPlayerMP)entity).field_71145_cl = 0;
        }
        if (entity.field_70128_L) {
            return;
        }
        int n = entity.field_70172_ad;
        entity.field_70172_ad = 0;
        entity.func_70097_a(jxtc2, f);
        entity.field_70172_ad = n;
    }

    public static void _b(Entity entity, jxtc jxtc2, float f, boolean bl) {
        if (entity.func_85032_ar() || entity.field_70128_L) {
            return;
        }
        if (!(entity instanceof EntityLivingBase)) {
            entity.func_70097_a(jxtc2, f);
            return;
        }
        if (entity instanceof EntityPlayer && ((EntityPlayer)entity).field_71075_bZ._a) {
            return;
        }
        EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
        if (entityLivingBase.func_110143_aJ() <= 0.0f) {
            return;
        }
        if (bl && entity instanceof EntityPlayerMP) {
            ((EntityPlayerMP)entity).field_71145_cl = 0;
        }
        if ((f = ForgeHooks.onLivingHurt(entityLivingBase, jxtc2, f)) <= 0.0f) {
            return;
        }
        float f2 = entityLivingBase.func_110143_aJ();
        entityLivingBase.func_70606_j(f2 - f);
        entityLivingBase.func_110142_aN()._a(jxtc2, f2, f);
        if (entityLivingBase.func_110143_aJ() <= 0.0f) {
            entityLivingBase.func_70645_a(jxtc2);
        }
        if (GloomyHooks.checkNanHealth(entityLivingBase)) {
            Logger.severe("Entity " + entity + " got NaN hp after silent attack from " + jxtc2.func_76355_l() + "/" + jxtc2.func_76346_g() + ", damage = " + f, new Object[0]);
            Thread.dumpStack();
        }
    }

    public static kjui _a(jxtc jxtc2) {
        if (jxtc2 instanceof ezey) {
            return ((ezey)jxtc2)._k;
        }
        if (jxtc2 == jxtc.field_76372_a || jxtc2 == jxtc.field_76370_b) {
            return kjui._b;
        }
        if (jxtc2.func_76355_l().startsWith("explosion")) {
            return kjui._e;
        }
        if (jxtc2 == jxtc.field_76379_h) {
            return kjui._d;
        }
        if (jxtc2 instanceof gloomyfolken.mods.weapon.kjui) {
            return kjui._f;
        }
        if (jxtc2 instanceof vjta) {
            return kjui._d;
        }
        return kjui._i;
    }

    public static enum kjui {
        _a,
        _b,
        _c,
        _d,
        _e,
        _f,
        _g,
        _h,
        _i;

    }
}

