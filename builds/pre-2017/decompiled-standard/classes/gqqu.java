/*
 * Decompiled with CFR 0.152.
 */
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.model.ModelOcelot;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.model.ModelSheep2;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.model.ModelSquid;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartTNT;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.util.sajh;
import net.minecraft.util.turb;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class gqqu {
    public Map _a = new HashMap();
    public static gqqu _b = new gqqu();
    public qncw _c;
    public static double _d;
    public static double _e;
    public static double _f;
    public apbu _g;
    public jizq _h;
    public ozlu _i;
    public EntityLivingBase _j;
    public EntityLivingBase _k;
    public float _l;
    public float _m;
    public GameSettings _n;
    public double _o;
    public double _p;
    public double _q;
    public static boolean _r;

    public gqqu() {
        this._a.put(EntityCaveSpider.class, new pkkm());
        this._a.put(EntitySpider.class, new yvic());
        this._a.put(EntityPig.class, new ohkb(new ModelPig(), new ModelPig(0.5f), 0.7f));
        this._a.put(EntitySheep.class, new fnrd(new ModelSheep2(), new ModelSheep1(), 0.7f));
        this._a.put(EntityCow.class, new dhhf(new ModelCow(), 0.7f));
        this._a.put(EntityMooshroom.class, new pknh(new ModelCow(), 0.7f));
        this._a.put(EntityWolf.class, new oyku(new ModelWolf(), new ModelWolf(), 0.5f));
        this._a.put(EntityChicken.class, new mscu(new ModelChicken(), 0.3f));
        this._a.put(EntityOcelot.class, new cvjc(new ModelOcelot(), 0.4f));
        this._a.put(EntitySilverfish.class, new pknr());
        this._a.put(EntityCreeper.class, new qnnk());
        this._a.put(EntityEnderman.class, new gqqi());
        this._a.put(EntitySnowman.class, new wpcc());
        this._a.put(EntitySkeleton.class, new zhjn());
        this._a.put(EntityWitch.class, new oyll());
        this._a.put(EntityBlaze.class, new nvfu());
        this._a.put(EntityZombie.class, new rqsk());
        this._a.put(EntitySlime.class, new twzo(new ModelSlime(16), new ModelSlime(0), 0.25f));
        this._a.put(EntityMagmaCube.class, new tfun());
        this._a.put(EntityPlayer.class, new xbdy());
        this._a.put(EntityGiantZombie.class, new dyjm(new ModelZombie(), 0.5f, 6.0f));
        this._a.put(EntityGhast.class, new xsbv());
        this._a.put(EntitySquid.class, new gqtk(new ModelSquid(), 0.7f));
        this._a.put(EntityVillager.class, new wpbs());
        this._a.put(EntityIronGolem.class, new bbbv());
        this._a.put(EntityBat.class, new dyja());
        this._a.put(EntityDragon.class, new tfui());
        this._a.put(EntityEnderCrystal.class, new bsfh());
        this._a.put(EntityWither.class, new yvhr());
        this._a.put(Entity.class, new apap());
        this._a.put(EntityPainting.class, new tfxx());
        this._a.put(EntityItemFrame.class, new bbdt());
        this._a.put(EntityLeashKnot.class, new yvek());
        this._a.put(EntityArrow.class, new dyjb());
        this._a.put(EntitySnowball.class, new apcv(tgdv.field_77768_aD));
        this._a.put(EntityEnderPearl.class, new apcv(tgdv.field_77730_bn));
        this._a.put(EntityEnderEye.class, new apcv(tgdv.field_77748_bA));
        this._a.put(EntityEgg.class, new apcv(tgdv.field_77764_aP));
        this._a.put(EntityPotion.class, new apcv(tgdv.field_77726_bs, 16384));
        this._a.put(EntityExpBottle.class, new apcv(tgdv.field_77809_bD));
        this._a.put(EntityFireworkRocket.class, new apcv(tgdv.field_92104_bU));
        this._a.put(EntityLargeFireball.class, new iwwn(2.0f));
        this._a.put(EntitySmallFireball.class, new iwwn(0.5f));
        this._a.put(EntityWitherSkull.class, new zhlw());
        this._a.put(EntityItem.class, new xsbj());
        this._a.put(EntityXPOrb.class, new yeft());
        this._a.put(EntityTNTPrimed.class, new bbfe());
        this._a.put(EntityFallingSand.class, new zyhv());
        this._a.put(EntityMinecartTNT.class, new fnqt());
        this._a.put(EntityMinecartMobSpawner.class, new gqqv());
        this._a.put(EntityMinecart.class, new scrm());
        this._a.put(EntityBoat.class, new hcsl());
        this._a.put(EntityFishHook.class, new bbbz());
        this._a.put(EntityHorse.class, new xbaf(new ModelHorse(), 0.75f));
        this._a.put(EntityLightningBolt.class, new tfup());
        for (tfvm tfvm2 : this._a.values()) {
            tfvm2.func_76976_a(this);
        }
    }

    public tfvm _a(Class clazz) {
        tfvm tfvm2 = (tfvm)this._a.get(clazz);
        if (tfvm2 == null && clazz != Entity.class) {
            tfvm2 = this._a(clazz.getSuperclass());
            this._a.put(clazz, tfvm2);
        }
        return tfvm2;
    }

    public tfvm _a(Entity entity) {
        return this._a(entity.getClass());
    }

    public void _a(ozlu ozlu2, apbu apbu2, qncw qncw2, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2, GameSettings gameSettings, float f) {
        this._i = ozlu2;
        this._g = apbu2;
        this._n = gameSettings;
        this._j = entityLivingBase;
        this._k = entityLivingBase2;
        this._c = qncw2;
        if (entityLivingBase.func_70608_bn()) {
            int n;
            int n2;
            int n3 = sajh._c(entityLivingBase.field_70165_t);
            twgu twgu2 = twgu.field_71973_m[ozlu2.func_72798_a(n3, n2 = sajh._c(entityLivingBase.field_70163_u), n = sajh._c(entityLivingBase.field_70161_v))];
            if (twgu2 != null && twgu2.isBed(ozlu2, n3, n2, n, entityLivingBase)) {
                int n4 = twgu2.getBedDirection(ozlu2, n3, n2, n);
                this._l = n4 * 90 + 180;
                this._m = 0.0f;
            }
        } else {
            this._l = entityLivingBase.field_70126_B + (entityLivingBase.field_70177_z - entityLivingBase.field_70126_B) * f;
            this._m = entityLivingBase.field_70127_C + (entityLivingBase.field_70125_A - entityLivingBase.field_70127_C) * f;
        }
        if (gameSettings.field_74320_O == 2) {
            this._l += 180.0f;
        }
        this._o = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * (double)f;
        this._p = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * (double)f;
        this._q = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * (double)f;
    }

    public void _a(Entity entity, float f) {
        if (entity.field_70173_aa == 0) {
            entity.field_70142_S = entity.field_70165_t;
            entity.field_70137_T = entity.field_70163_u;
            entity.field_70136_U = entity.field_70161_v;
        }
        double d = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * (double)f;
        double d2 = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * (double)f;
        double d3 = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * (double)f;
        float f2 = entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * f;
        int n = entity.func_70070_b(f);
        if (entity.func_70027_ad()) {
            n = 0xF000F0;
        }
        int n2 = n % 65536;
        int n3 = n / 65536;
        iwya._a(iwya._b, (float)n2 / 1.0f, (float)n3 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this._a(entity, d - _d, d2 - _e, d3 - _f, f2, f);
    }

    public void _a(Entity entity, double d, double d2, double d3, float f, float f2) {
        block9: {
            tfvm tfvm2 = null;
            try {
                tfvm2 = this._a(entity);
                if (tfvm2 == null || this._g == null) break block9;
                if (_r && !entity.func_82150_aj()) {
                    try {
                        this._b(entity, d, d2, d3, f, f2);
                    }
                    catch (Throwable throwable) {
                        throw new turb(CrashReport.func_85055_a(throwable, "Rendering entity hitbox in world"));
                    }
                }
                try {
                    tfvm2.func_76986_a(entity, d, d2, d3, f, f2);
                }
                catch (Throwable throwable) {
                    throw new turb(CrashReport.func_85055_a(throwable, "Rendering entity in world"));
                }
                try {
                    tfvm2.func_76979_b(entity, d, d2, d3, f, f2);
                }
                catch (Throwable throwable) {
                    throw new turb(CrashReport.func_85055_a(throwable, "Post-rendering entity in world"));
                }
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.func_85055_a(throwable, "Rendering entity in world");
                jxsn jxsn2 = crashReport.func_85058_a("Entity being rendered");
                entity.func_85029_a(jxsn2);
                jxsn jxsn3 = crashReport.func_85058_a("Renderer details");
                jxsn3._a("Assigned renderer", tfvm2);
                jxsn3._a("Location", jxsn._a(d, d2, d3));
                jxsn3._a("Rotation", Float.valueOf(f));
                jxsn3._a("Delta", Float.valueOf(f2));
                throw new turb(crashReport);
            }
        }
    }

    public void _b(Entity entity, double d, double d2, double d3, float f, float f2) {
        GL11.glDepthMask(false);
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glDisable(2884);
        GL11.glDisable(3042);
        GL11.glPushMatrix();
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
        htvf2.func_78370_a(255, 255, 255, 32);
        double d4 = -entity.field_70130_N / 2.0f;
        double d5 = -entity.field_70130_N / 2.0f;
        double d6 = entity.field_70130_N / 2.0f;
        double d7 = -entity.field_70130_N / 2.0f;
        double d8 = -entity.field_70130_N / 2.0f;
        double d9 = entity.field_70130_N / 2.0f;
        double d10 = entity.field_70130_N / 2.0f;
        double d11 = entity.field_70130_N / 2.0f;
        double d12 = entity.field_70131_O;
        htvf2.func_78377_a(d + d4, d2 + d12, d3 + d5);
        htvf2.func_78377_a(d + d4, d2, d3 + d5);
        htvf2.func_78377_a(d + d6, d2, d3 + d7);
        htvf2.func_78377_a(d + d6, d2 + d12, d3 + d7);
        htvf2.func_78377_a(d + d10, d2 + d12, d3 + d11);
        htvf2.func_78377_a(d + d10, d2, d3 + d11);
        htvf2.func_78377_a(d + d8, d2, d3 + d9);
        htvf2.func_78377_a(d + d8, d2 + d12, d3 + d9);
        htvf2.func_78377_a(d + d6, d2 + d12, d3 + d7);
        htvf2.func_78377_a(d + d6, d2, d3 + d7);
        htvf2.func_78377_a(d + d10, d2, d3 + d11);
        htvf2.func_78377_a(d + d10, d2 + d12, d3 + d11);
        htvf2.func_78377_a(d + d8, d2 + d12, d3 + d9);
        htvf2.func_78377_a(d + d8, d2, d3 + d9);
        htvf2.func_78377_a(d + d4, d2, d3 + d5);
        htvf2.func_78377_a(d + d4, d2 + d12, d3 + d5);
        htvf2.func_78381_a();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glEnable(2896);
        GL11.glEnable(2884);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
    }

    public void _a(ozlu ozlu2) {
        this._i = ozlu2;
    }

    public double _a(double d, double d2, double d3) {
        double d4 = d - this._o;
        double d5 = d2 - this._p;
        double d6 = d3 - this._q;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public qncw _a() {
        return this._c;
    }

    public void _a(nege nege2) {
        for (tfvm tfvm2 : this._a.values()) {
            tfvm2.func_94143_a(nege2);
        }
    }
}

