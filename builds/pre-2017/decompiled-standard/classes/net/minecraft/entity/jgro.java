/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity;

import cpw.mods.fml.common.FMLLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLeashKnot;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityEnderEye;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.item.EntityMinecartFurnace;
import net.minecraft.entity.item.EntityMinecartHopper;
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
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
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
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.entity.zwaw;

public class jgro {
    public static Map _a = new HashMap();
    public static Map _b = new HashMap();
    public static Map _c = new HashMap();
    public static Map _d = new HashMap();
    public static Map _e = new HashMap();
    public static HashMap _f = new LinkedHashMap();

    public static void _a(Class clazz, String string, int n) {
        _a.put(string, clazz);
        _b.put(clazz, string);
        _c.put(n, clazz);
        _d.put(clazz, n);
        _e.put(string, n);
    }

    public static void _a(Class clazz, String string, int n, int n2, int n3) {
        jgro._a(clazz, string, n);
        _f.put(n, new zwaw(n, n2, n3));
    }

    public static Entity _a(String string, ozlu ozlu2) {
        Entity entity = null;
        try {
            Class clazz = (Class)_a.get(string);
            if (clazz != null) {
                entity = (Entity)clazz.getConstructor(ozlu.class).newInstance(ozlu2);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return entity;
    }

    public static Entity _a(qoac qoac2, ozlu ozlu2) {
        Entity entity = null;
        if ("Minecart".equals(qoac2._j("id"))) {
            switch (qoac2._f("Type")) {
                case 0: {
                    qoac2._a("id", "MinecartRideable");
                    break;
                }
                case 1: {
                    qoac2._a("id", "MinecartChest");
                    break;
                }
                case 2: {
                    qoac2._a("id", "MinecartFurnace");
                }
            }
            qoac2._p("Type");
        }
        Class clazz = null;
        try {
            clazz = (Class)_a.get(qoac2._j("id"));
            if (clazz != null) {
                entity = (Entity)clazz.getConstructor(ozlu.class).newInstance(ozlu2);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (entity != null) {
            try {
                entity.func_70020_e(qoac2);
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "An Entity %s(%s) has thrown an exception during loading, its state cannot be restored. Report this to the mod author", qoac2._j("id"), clazz.getName());
                entity = null;
            }
        } else {
            ozlu2.func_98180_V()._b("Skipping Entity with id " + qoac2._j("id"));
        }
        return entity;
    }

    public static Entity _a(int n, ozlu ozlu2) {
        Entity entity = null;
        try {
            Class clazz = jgro._a(n);
            if (clazz != null) {
                entity = (Entity)clazz.getConstructor(ozlu.class).newInstance(ozlu2);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (entity == null) {
            ozlu2.func_98180_V()._b("Skipping Entity with id " + n);
        }
        return entity;
    }

    public static int _a(Entity entity) {
        Class<?> clazz = entity.getClass();
        return _d.containsKey(clazz) ? (Integer)_d.get(clazz) : 0;
    }

    public static Class _a(int n) {
        return (Class)_c.get(n);
    }

    public static String _b(Entity entity) {
        return (String)_b.get(entity.getClass());
    }

    public static String _b(int n) {
        Class clazz = jgro._a(n);
        return clazz != null ? (String)_b.get(clazz) : null;
    }

    static {
        jgro._a(EntityItem.class, "Item", 1);
        jgro._a(EntityXPOrb.class, "XPOrb", 2);
        jgro._a(EntityLeashKnot.class, "LeashKnot", 8);
        jgro._a(EntityPainting.class, "Painting", 9);
        jgro._a(EntityArrow.class, "Arrow", 10);
        jgro._a(EntitySnowball.class, "Snowball", 11);
        jgro._a(EntityLargeFireball.class, "Fireball", 12);
        jgro._a(EntitySmallFireball.class, "SmallFireball", 13);
        jgro._a(EntityEnderPearl.class, "ThrownEnderpearl", 14);
        jgro._a(EntityEnderEye.class, "EyeOfEnderSignal", 15);
        jgro._a(EntityPotion.class, "ThrownPotion", 16);
        jgro._a(EntityExpBottle.class, "ThrownExpBottle", 17);
        jgro._a(EntityItemFrame.class, "ItemFrame", 18);
        jgro._a(EntityWitherSkull.class, "WitherSkull", 19);
        jgro._a(EntityTNTPrimed.class, "PrimedTnt", 20);
        jgro._a(EntityFallingSand.class, "FallingSand", 21);
        jgro._a(EntityFireworkRocket.class, "FireworksRocketEntity", 22);
        jgro._a(EntityBoat.class, "Boat", 41);
        jgro._a(EntityMinecartEmpty.class, "MinecartRideable", 42);
        jgro._a(EntityMinecartChest.class, "MinecartChest", 43);
        jgro._a(EntityMinecartFurnace.class, "MinecartFurnace", 44);
        jgro._a(EntityMinecartTNT.class, "MinecartTNT", 45);
        jgro._a(EntityMinecartHopper.class, "MinecartHopper", 46);
        jgro._a(EntityMinecartMobSpawner.class, "MinecartSpawner", 47);
        jgro._a(EntityLiving.class, "Mob", 48);
        jgro._a(EntityMob.class, "Monster", 49);
        jgro._a(EntityCreeper.class, "Creeper", 50, 894731, 0);
        jgro._a(EntitySkeleton.class, "Skeleton", 51, 0xC1C1C1, 0x494949);
        jgro._a(EntitySpider.class, "Spider", 52, 3419431, 11013646);
        jgro._a(EntityGiantZombie.class, "Giant", 53);
        jgro._a(EntityZombie.class, "Zombie", 54, 44975, 7969893);
        jgro._a(EntitySlime.class, "Slime", 55, 5349438, 8306542);
        jgro._a(EntityGhast.class, "Ghast", 56, 0xF9F9F9, 0xBCBCBC);
        jgro._a(EntityPigZombie.class, "PigZombie", 57, 15373203, 5009705);
        jgro._a(EntityEnderman.class, "Enderman", 58, 0x161616, 0);
        jgro._a(EntityCaveSpider.class, "CaveSpider", 59, 803406, 11013646);
        jgro._a(EntitySilverfish.class, "Silverfish", 60, 0x6E6E6E, 0x303030);
        jgro._a(EntityBlaze.class, "Blaze", 61, 16167425, 16775294);
        jgro._a(EntityMagmaCube.class, "LavaSlime", 62, 0x340000, 0xFCFC00);
        jgro._a(EntityDragon.class, "EnderDragon", 63);
        jgro._a(EntityWither.class, "WitherBoss", 64);
        jgro._a(EntityBat.class, "Bat", 65, 4996656, 986895);
        jgro._a(EntityWitch.class, "Witch", 66, 0x340000, 5349438);
        jgro._a(EntityPig.class, "Pig", 90, 15771042, 14377823);
        jgro._a(EntitySheep.class, "Sheep", 91, 0xE7E7E7, 0xFFB5B5);
        jgro._a(EntityCow.class, "Cow", 92, 4470310, 0xA1A1A1);
        jgro._a(EntityChicken.class, "Chicken", 93, 0xA1A1A1, 0xFF0000);
        jgro._a(EntitySquid.class, "Squid", 94, 2243405, 7375001);
        jgro._a(EntityWolf.class, "Wolf", 95, 0xD7D3D3, 13545366);
        jgro._a(EntityMooshroom.class, "MushroomCow", 96, 10489616, 0xB7B7B7);
        jgro._a(EntitySnowman.class, "SnowMan", 97);
        jgro._a(EntityOcelot.class, "Ozelot", 98, 15720061, 5653556);
        jgro._a(EntityIronGolem.class, "VillagerGolem", 99);
        jgro._a(EntityHorse.class, "EntityHorse", 100, 12623485, 0xEEE500);
        jgro._a(EntityVillager.class, "Villager", 120, 5651507, 12422002);
        jgro._a(EntityEnderCrystal.class, "EnderCrystal", 200);
    }
}

