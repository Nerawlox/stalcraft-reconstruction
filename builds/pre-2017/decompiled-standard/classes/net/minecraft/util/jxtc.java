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
import net.minecraft.util.jxsn;
import net.minecraft.util.tdpx;
import net.minecraft.util.vjta;
import net.minecraft.util.zwat;

public class jxtc {
    public static jxtc field_76372_a = new jxtc("inFire").func_76361_j();
    public static jxtc field_76370_b = new jxtc("onFire").func_76348_h().func_76361_j();
    public static jxtc field_76371_c = new jxtc("lava").func_76361_j();
    public static jxtc field_76368_d = new jxtc("inWall").func_76348_h();
    public static jxtc field_76369_e = new jxtc("drown").func_76348_h();
    public static jxtc field_76366_f = new jxtc("starve").func_76348_h();
    public static jxtc field_76367_g = new jxtc("cactus");
    public static jxtc field_76379_h = new jxtc("fall").func_76348_h();
    public static jxtc field_76380_i = new jxtc("outOfWorld").func_76348_h().func_76359_i();
    public static jxtc field_76377_j = new jxtc("generic").func_76348_h();
    public static jxtc field_76376_m = new jxtc("magic").func_76348_h().func_82726_p();
    public static jxtc field_82727_n = new jxtc("wither").func_76348_h();
    public static jxtc field_82728_o = new jxtc("anvil");
    public static jxtc field_82729_p = new jxtc("fallingBlock");
    public boolean field_76374_o;
    public boolean field_76385_p;
    public float field_76384_q = 0.3f;
    public boolean field_76383_r;
    public boolean field_76382_s;
    public boolean field_76381_t;
    public boolean field_82730_x;
    public boolean field_76378_k;
    public String field_76373_n;

    public static jxtc func_76358_a(EntityLivingBase entityLivingBase) {
        return new vjta("mob", entityLivingBase);
    }

    public static jxtc func_76365_a(EntityPlayer entityPlayer) {
        return new vjta("player", entityPlayer);
    }

    public static jxtc func_76353_a(EntityArrow entityArrow, Entity entity) {
        return new jxsn("arrow", entityArrow, entity).func_76349_b();
    }

    public static jxtc func_76362_a(EntityFireball entityFireball, Entity entity) {
        if (entity == null) {
            return new jxsn("onFire", entityFireball, entityFireball).func_76361_j().func_76349_b();
        }
        return new jxsn("fireball", entityFireball, entity).func_76361_j().func_76349_b();
    }

    public static jxtc func_76356_a(Entity entity, Entity entity2) {
        return new jxsn("thrown", entity, entity2).func_76349_b();
    }

    public static jxtc func_76354_b(Entity entity, Entity entity2) {
        return new jxsn("indirectMagic", entity, entity2).func_76348_h().func_82726_p();
    }

    public static jxtc func_92087_a(Entity entity) {
        return new vjta("thorns", entity).func_82726_p();
    }

    public static jxtc func_94539_a(elkd elkd2) {
        if (elkd2 != null && elkd2._c() != null) {
            return new vjta("explosion.player", elkd2._c()).func_76351_m().func_94540_d();
        }
        return new jxtc("explosion").func_76351_m().func_94540_d();
    }

    public boolean func_76352_a() {
        return this.field_76382_s;
    }

    public jxtc func_76349_b() {
        this.field_76382_s = true;
        return this;
    }

    public boolean func_94541_c() {
        return this.field_76378_k;
    }

    public jxtc func_94540_d() {
        this.field_76378_k = true;
        return this;
    }

    public boolean func_76363_c() {
        return this.field_76374_o;
    }

    public float func_76345_d() {
        float f = qlgf._a(this);
        return f;
    }

    public boolean func_76357_e() {
        return this.field_76385_p;
    }

    public jxtc(String string) {
        this.field_76373_n = string;
    }

    public Entity func_76364_f() {
        return this.func_76346_g();
    }

    public Entity func_76346_g() {
        return null;
    }

    public jxtc func_76348_h() {
        this.field_76374_o = true;
        this.field_76384_q = 0.0f;
        return this;
    }

    public jxtc func_76359_i() {
        this.field_76385_p = true;
        return this;
    }

    public jxtc func_76361_j() {
        this.field_76383_r = true;
        return this;
    }

    public zwat func_76360_b(EntityLivingBase entityLivingBase) {
        EntityLivingBase entityLivingBase2 = entityLivingBase.func_94060_bK();
        String string = "death.attack." + this.field_76373_n;
        String string2 = string + ".player";
        if (entityLivingBase2 != null && tdpx._b(string2)) {
            return zwat._b(string2, entityLivingBase.func_96090_ax(), entityLivingBase2.func_96090_ax());
        }
        return zwat._b(string, entityLivingBase.func_96090_ax());
    }

    public boolean func_76347_k() {
        return this.field_76383_r;
    }

    public String func_76355_l() {
        return this.field_76373_n;
    }

    public jxtc func_76351_m() {
        this.field_76381_t = true;
        return this;
    }

    public boolean func_76350_n() {
        return this.field_76381_t;
    }

    public boolean func_82725_o() {
        return this.field_82730_x;
    }

    public jxtc func_82726_p() {
        this.field_82730_x = true;
        return this;
    }
}

