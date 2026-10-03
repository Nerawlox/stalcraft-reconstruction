/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.gui.FontRenderer;
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
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
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
import net.minecraft.item.Item;
import net.minecraft.util.sajh;
import net.minecraft.util.turb;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

@SideOnly(value=Side.CLIENT)
public class RenderManager {
    public Map _a = new HashMap();
    public static RenderManager _b = new RenderManager();
    public FontRenderer _c;
    public static double _d;
    public static double _e;
    public static double _f;
    public TextureManager _g;
    public ItemRenderer _h;
    public World _i;
    public EntityLivingBase _j;
    public EntityLivingBase _k;
    public float _l;
    public float _m;
    public GameSettings _n;
    public double _o;
    public double _p;
    public double _q;
    public static boolean _r;

    public RenderManager() {
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
        this._a.put(EntityPlayer.class, new RenderPlayer());
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
        this._a.put(EntitySnowball.class, new apcv(Item.snowball));
        this._a.put(EntityEnderPearl.class, new apcv(Item.enderPearl));
        this._a.put(EntityEnderEye.class, new apcv(Item.eyeOfEnder));
        this._a.put(EntityEgg.class, new apcv(Item.egg));
        this._a.put(EntityPotion.class, new apcv(Item.potion, 16384));
        this._a.put(EntityExpBottle.class, new apcv(Item.expBottle));
        this._a.put(EntityFireworkRocket.class, new apcv(Item.firework));
        this._a.put(EntityLargeFireball.class, new iwwn(2.0f));
        this._a.put(EntitySmallFireball.class, new iwwn(0.5f));
        this._a.put(EntityWitherSkull.class, new zhlw());
        this._a.put(EntityItem.class, new RenderItem());
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
        for (Render render : this._a.values()) {
            render.setRenderManager(this);
        }
    }

    public Render _a(Class clazz) {
        Render render = (Render)this._a.get(clazz);
        if (render == null && clazz != Entity.class) {
            render = this._a(clazz.getSuperclass());
            this._a.put(clazz, render);
        }
        return render;
    }

    public Render _a(Entity entity) {
        return this._a(entity.getClass());
    }

    public void _a(World world, TextureManager textureManager, FontRenderer fontRenderer, EntityLivingBase entityLivingBase, EntityLivingBase entityLivingBase2, GameSettings gameSettings, float f) {
        this._i = world;
        this._g = textureManager;
        this._n = gameSettings;
        this._j = entityLivingBase;
        this._k = entityLivingBase2;
        this._c = fontRenderer;
        if (entityLivingBase.isPlayerSleeping()) {
            int n;
            int n2;
            int n3 = sajh._c(entityLivingBase.posX);
            Block block = Block.blocksList[world.getBlockId(n3, n2 = sajh._c(entityLivingBase.posY), n = sajh._c(entityLivingBase.posZ))];
            if (block != null && block.isBed(world, n3, n2, n, entityLivingBase)) {
                int n4 = block.getBedDirection(world, n3, n2, n);
                this._l = n4 * 90 + 180;
                this._m = 0.0f;
            }
        } else {
            this._l = entityLivingBase.prevRotationYaw + (entityLivingBase.rotationYaw - entityLivingBase.prevRotationYaw) * f;
            this._m = entityLivingBase.prevRotationPitch + (entityLivingBase.rotationPitch - entityLivingBase.prevRotationPitch) * f;
        }
        if (gameSettings.thirdPersonView == 2) {
            this._l += 180.0f;
        }
        this._o = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * (double)f;
        this._p = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * (double)f;
        this._q = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * (double)f;
    }

    public void _a(Entity entity, float f) {
        if (entity.ticksExisted == 0) {
            entity.lastTickPosX = entity.posX;
            entity.lastTickPosY = entity.posY;
            entity.lastTickPosZ = entity.posZ;
        }
        double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f;
        double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f;
        double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f;
        float f2 = entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * f;
        int n = entity.getBrightnessForRender(f);
        if (entity.isBurning()) {
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
            Render render = null;
            try {
                render = this._a(entity);
                if (render == null || this._g == null) break block9;
                if (_r && !entity.isInvisible()) {
                    try {
                        this._b(entity, d, d2, d3, f, f2);
                    }
                    catch (Throwable throwable) {
                        throw new turb(CrashReport.makeCrashReport(throwable, "Rendering entity hitbox in world"));
                    }
                }
                try {
                    render.doRender(entity, d, d2, d3, f, f2);
                }
                catch (Throwable throwable) {
                    throw new turb(CrashReport.makeCrashReport(throwable, "Rendering entity in world"));
                }
                try {
                    render.doRenderShadowAndFire(entity, d, d2, d3, f, f2);
                }
                catch (Throwable throwable) {
                    throw new turb(CrashReport.makeCrashReport(throwable, "Post-rendering entity in world"));
                }
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Rendering entity in world");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Entity being rendered");
                entity.addEntityCrashInfo(crashReportCategory);
                CrashReportCategory crashReportCategory2 = crashReport.makeCategory("Renderer details");
                crashReportCategory2._a("Assigned renderer", render);
                crashReportCategory2._a("Location", CrashReportCategory._a(d, d2, d3));
                crashReportCategory2._a("Rotation", Float.valueOf(f));
                crashReportCategory2._a("Delta", Float.valueOf(f2));
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
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.setColorRGBA(255, 255, 255, 32);
        double d4 = -entity.width / 2.0f;
        double d5 = -entity.width / 2.0f;
        double d6 = entity.width / 2.0f;
        double d7 = -entity.width / 2.0f;
        double d8 = -entity.width / 2.0f;
        double d9 = entity.width / 2.0f;
        double d10 = entity.width / 2.0f;
        double d11 = entity.width / 2.0f;
        double d12 = entity.height;
        tessellator.addVertex(d + d4, d2 + d12, d3 + d5);
        tessellator.addVertex(d + d4, d2, d3 + d5);
        tessellator.addVertex(d + d6, d2, d3 + d7);
        tessellator.addVertex(d + d6, d2 + d12, d3 + d7);
        tessellator.addVertex(d + d10, d2 + d12, d3 + d11);
        tessellator.addVertex(d + d10, d2, d3 + d11);
        tessellator.addVertex(d + d8, d2, d3 + d9);
        tessellator.addVertex(d + d8, d2 + d12, d3 + d9);
        tessellator.addVertex(d + d6, d2 + d12, d3 + d7);
        tessellator.addVertex(d + d6, d2, d3 + d7);
        tessellator.addVertex(d + d10, d2, d3 + d11);
        tessellator.addVertex(d + d10, d2 + d12, d3 + d11);
        tessellator.addVertex(d + d8, d2 + d12, d3 + d9);
        tessellator.addVertex(d + d8, d2, d3 + d9);
        tessellator.addVertex(d + d4, d2, d3 + d5);
        tessellator.addVertex(d + d4, d2 + d12, d3 + d5);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glEnable(2896);
        GL11.glEnable(2884);
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
    }

    public void _a(World world) {
        this._i = world;
    }

    public double _a(double d, double d2, double d3) {
        double d4 = d - this._o;
        double d5 = d2 - this._p;
        double d6 = d3 - this._q;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public FontRenderer _a() {
        return this._c;
    }

    public void _a(IconRegister iconRegister) {
        for (Render render : this._a.values()) {
            render.updateIcons(iconRegister);
        }
    }
}

