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
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.common.ForgeHooks;

public class ezey
extends DamageSource {
    protected String _j;
    public kjui _k;
    public static DamageSource _l = new ezey("radiation", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0440\u0430\u0434\u0438\u0430\u0446\u0438\u0438", kjui._g).setDamageBypassesArmor();
    public static DamageSource _m = new ezey("biological", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0431\u0438\u043e\u043b\u043e\u0433\u0438\u0447\u0435\u0441\u043a\u043e\u0433\u043e \u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u044f", kjui._g).setDamageBypassesArmor();
    public static DamageSource _n = new ezey("psycho", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u043f\u0441\u0438-\u0430\u0442\u0430\u043a\u0438", kjui._i).setDamageBypassesArmor();
    public static DamageSource _o = new ezey("bleeding", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u043a\u0440\u043e\u0432\u043e\u0442\u0435\u0447\u0435\u043d\u0438\u044f", kjui._i).setDamageBypassesArmor();
    public static DamageSource _p = new ezey("thermal", " \u043f\u043e\u0433\u0438\u0431 \u043e\u0442 \u0442\u0435\u0440\u043c\u0438\u0447\u0435\u0441\u043a\u043e\u0433\u043e \u0437\u0430\u0440\u0430\u0436\u0435\u043d\u0438\u044f", kjui._i).setDamageBypassesArmor();
    public static DamageSource _q = new ezey("web", " \u043f\u043e\u0433\u0438\u0431 \u0432 \u043a\u043e\u043b\u044e\u0447\u0435\u0439 \u043f\u0440\u043e\u0432\u043e\u043b\u043e\u043a\u0435", kjui._d);
    public static DamageSource _r = new ezey("artefakt", " \u043f\u043e\u0433\u0438\u0431 \u0438\u0437-\u0437\u0430 \u0432\u043e\u0437\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f \u0430\u0440\u0442\u0435\u0444\u0430\u043a\u0442\u0430", kjui._i).setDamageBypassesArmor();

    public ezey(String string, String string2, kjui kjui2) {
        super(string);
        this._j = string2;
        this._k = kjui2;
    }

    @Override
    public ChatMessageComponent getDeathMessage(EntityLivingBase entityLivingBase) {
        return new ChatMessageComponent()._a(entityLivingBase.getEntityName() + this._j);
    }

    public static void _a(Entity entity, DamageSource damageSource, float f, boolean bl) {
        if (bl && entity instanceof EntityPlayerMP) {
            ((EntityPlayerMP)entity).field_71145_cl = 0;
        }
        if (entity.isDead) {
            return;
        }
        int n = entity.hurtResistantTime;
        entity.hurtResistantTime = 0;
        entity.attackEntityFrom(damageSource, f);
        entity.hurtResistantTime = n;
    }

    public static void _b(Entity entity, DamageSource damageSource, float f, boolean bl) {
        if (entity.isEntityInvulnerable() || entity.isDead) {
            return;
        }
        if (!(entity instanceof EntityLivingBase)) {
            entity.attackEntityFrom(damageSource, f);
            return;
        }
        if (entity instanceof EntityPlayer && ((EntityPlayer)entity).capabilities._a) {
            return;
        }
        EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
        if (entityLivingBase.getHealth() <= 0.0f) {
            return;
        }
        if (bl && entity instanceof EntityPlayerMP) {
            ((EntityPlayerMP)entity).field_71145_cl = 0;
        }
        if ((f = ForgeHooks.onLivingHurt(entityLivingBase, damageSource, f)) <= 0.0f) {
            return;
        }
        float f2 = entityLivingBase.getHealth();
        entityLivingBase.setHealth(f2 - f);
        entityLivingBase.func_110142_aN()._a(damageSource, f2, f);
        if (entityLivingBase.getHealth() <= 0.0f) {
            entityLivingBase.onDeath(damageSource);
        }
        if (GloomyHooks.checkNanHealth(entityLivingBase)) {
            Logger.severe("Entity " + entity + " got NaN hp after silent attack from " + damageSource.getDamageType() + "/" + damageSource.getEntity() + ", damage = " + f, new Object[0]);
            Thread.dumpStack();
        }
    }

    public static kjui _a(DamageSource damageSource) {
        if (damageSource instanceof ezey) {
            return ((ezey)damageSource)._k;
        }
        if (damageSource == DamageSource.inFire || damageSource == DamageSource.onFire) {
            return kjui._b;
        }
        if (damageSource.getDamageType().startsWith("explosion")) {
            return kjui._e;
        }
        if (damageSource == DamageSource.fall) {
            return kjui._d;
        }
        if (damageSource instanceof gloomyfolken.mods.weapon.kjui) {
            return kjui._f;
        }
        if (damageSource instanceof EntityDamageSource) {
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

