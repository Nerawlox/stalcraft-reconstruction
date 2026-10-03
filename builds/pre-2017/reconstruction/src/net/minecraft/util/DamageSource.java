/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import gloomyfolken.mods.stalker.misc.qlgf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.tdpx;
import net.minecraft.world.Explosion;

public class DamageSource {
    public static DamageSource inFire = new DamageSource("inFire").setFireDamage();
    public static DamageSource onFire = new DamageSource("onFire").setDamageBypassesArmor().setFireDamage();
    public static DamageSource lava = new DamageSource("lava").setFireDamage();
    public static DamageSource inWall = new DamageSource("inWall").setDamageBypassesArmor();
    public static DamageSource drown = new DamageSource("drown").setDamageBypassesArmor();
    public static DamageSource starve = new DamageSource("starve").setDamageBypassesArmor();
    public static DamageSource cactus = new DamageSource("cactus");
    public static DamageSource fall = new DamageSource("fall").setDamageBypassesArmor();
    public static DamageSource outOfWorld = new DamageSource("outOfWorld").setDamageBypassesArmor().setDamageAllowedInCreativeMode();
    public static DamageSource generic = new DamageSource("generic").setDamageBypassesArmor();
    public static DamageSource magic = new DamageSource("magic").setDamageBypassesArmor().setMagicDamage();
    public static DamageSource wither = new DamageSource("wither").setDamageBypassesArmor();
    public static DamageSource anvil = new DamageSource("anvil");
    public static DamageSource fallingBlock = new DamageSource("fallingBlock");
    public boolean isUnblockable;
    public boolean isDamageAllowedInCreativeMode;
    public float hungerDamage = 0.3f;
    public boolean fireDamage;
    public boolean projectile;
    public boolean difficultyScaled;
    public boolean magicDamage;
    public boolean explosion;
    public String damageType;

    public static DamageSource causeMobDamage(EntityLivingBase entityLivingBase) {
        return new EntityDamageSource("mob", entityLivingBase);
    }

    public static DamageSource causePlayerDamage(EntityPlayer entityPlayer) {
        return new EntityDamageSource("player", entityPlayer);
    }

    public static DamageSource causeArrowDamage(EntityArrow entityArrow, Entity entity) {
        return new EntityDamageSourceIndirect("arrow", entityArrow, entity).setProjectile();
    }

    public static DamageSource causeFireballDamage(EntityFireball entityFireball, Entity entity) {
        if (entity == null) {
            return new EntityDamageSourceIndirect("onFire", entityFireball, entityFireball).setFireDamage().setProjectile();
        }
        return new EntityDamageSourceIndirect("fireball", entityFireball, entity).setFireDamage().setProjectile();
    }

    public static DamageSource causeThrownDamage(Entity entity, Entity entity2) {
        return new EntityDamageSourceIndirect("thrown", entity, entity2).setProjectile();
    }

    public static DamageSource causeIndirectMagicDamage(Entity entity, Entity entity2) {
        return new EntityDamageSourceIndirect("indirectMagic", entity, entity2).setDamageBypassesArmor().setMagicDamage();
    }

    public static DamageSource causeThornsDamage(Entity entity) {
        return new EntityDamageSource("thorns", entity).setMagicDamage();
    }

    public static DamageSource setExplosionSource(Explosion explosion) {
        if (explosion != null && explosion._c() != null) {
            return new EntityDamageSource("explosion.player", explosion._c()).setDifficultyScaled().setExplosion();
        }
        return new DamageSource("explosion").setDifficultyScaled().setExplosion();
    }

    public boolean isProjectile() {
        return this.projectile;
    }

    public DamageSource setProjectile() {
        this.projectile = true;
        return this;
    }

    public boolean isExplosion() {
        return this.explosion;
    }

    public DamageSource setExplosion() {
        this.explosion = true;
        return this;
    }

    public boolean isUnblockable() {
        return this.isUnblockable;
    }

    public float getHungerDamage() {
        float f = qlgf._a(this);
        return f;
    }

    public boolean canHarmInCreative() {
        return this.isDamageAllowedInCreativeMode;
    }

    public DamageSource(String string) {
        this.damageType = string;
    }

    public Entity getSourceOfDamage() {
        return this.getEntity();
    }

    public Entity getEntity() {
        return null;
    }

    public DamageSource setDamageBypassesArmor() {
        this.isUnblockable = true;
        this.hungerDamage = 0.0f;
        return this;
    }

    public DamageSource setDamageAllowedInCreativeMode() {
        this.isDamageAllowedInCreativeMode = true;
        return this;
    }

    public DamageSource setFireDamage() {
        this.fireDamage = true;
        return this;
    }

    public ChatMessageComponent getDeathMessage(EntityLivingBase entityLivingBase) {
        EntityLivingBase entityLivingBase2 = entityLivingBase.func_94060_bK();
        String string = "death.attack." + this.damageType;
        String string2 = string + ".player";
        if (entityLivingBase2 != null && tdpx._b(string2)) {
            return ChatMessageComponent._b(string2, entityLivingBase.getTranslatedEntityName(), entityLivingBase2.getTranslatedEntityName());
        }
        return ChatMessageComponent._b(string, entityLivingBase.getTranslatedEntityName());
    }

    public boolean isFireDamage() {
        return this.fireDamage;
    }

    public String getDamageType() {
        return this.damageType;
    }

    public DamageSource setDifficultyScaled() {
        this.difficultyScaled = true;
        return this;
    }

    public boolean isDifficultyScaled() {
        return this.difficultyScaled;
    }

    public boolean isMagicDamage() {
        return this.magicDamage;
    }

    public DamageSource setMagicDamage() {
        this.magicDamage = true;
        return this;
    }
}

