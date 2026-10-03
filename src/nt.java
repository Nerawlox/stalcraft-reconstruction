/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.FMLLog
 *  nu
 *  oa
 *  od
 *  ol
 *  rw
 *  sj
 *  sr
 *  su
 *  sw
 *  sy
 *  sz
 *  tb
 *  te
 *  tg
 *  tk
 *  tl
 *  tn
 *  tq
 *  um
 *  uo
 *  up
 *  us
 *  ut
 *  uv
 */
import cpw.mods.fml.common.FMLLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;

public class nt {
    public static Map b = new HashMap();
    public static Map c = new HashMap();
    public static Map d = new HashMap();
    private static Map e = new HashMap();
    private static Map f = new HashMap();
    public static HashMap a = new LinkedHashMap();

    public static void a(Class par0Class, String par1Str, int par2) {
        b.put(par1Str, par0Class);
        c.put(par0Class, par1Str);
        d.put(par2, par0Class);
        e.put(par0Class, par2);
        f.put(par1Str, par2);
    }

    public static void a(Class par0Class, String par1Str, int par2, int par3, int par4) {
        nt.a(par0Class, par1Str, par2);
        a.put(par2, new nu(par2, par3, par4));
    }

    public static nn a(String par0Str, abw par1World) {
        nn entity = null;
        try {
            Class oclass = (Class)b.get(par0Str);
            if (oclass != null) {
                entity = (nn)oclass.getConstructor(abw.class).newInstance(par1World);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return entity;
    }

    public static nn a(by par0NBTTagCompound, abw par1World) {
        nn entity = null;
        if ("Minecart".equals(par0NBTTagCompound.i("id"))) {
            switch (par0NBTTagCompound.e("Type")) {
                case 0: {
                    par0NBTTagCompound.a("id", "MinecartRideable");
                    break;
                }
                case 1: {
                    par0NBTTagCompound.a("id", "MinecartChest");
                    break;
                }
                case 2: {
                    par0NBTTagCompound.a("id", "MinecartFurnace");
                }
            }
            par0NBTTagCompound.o("Type");
        }
        Class oclass = null;
        try {
            oclass = (Class)b.get(par0NBTTagCompound.i("id"));
            if (oclass != null) {
                entity = (nn)oclass.getConstructor(abw.class).newInstance(par1World);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (entity != null) {
            try {
                entity.f(par0NBTTagCompound);
            }
            catch (Exception e2) {
                FMLLog.log((Level)Level.SEVERE, (Throwable)e2, (String)"An Entity %s(%s) has thrown an exception during loading, its state cannot be restored. Report this to the mod author", (Object[])new Object[]{par0NBTTagCompound.i("id"), oclass.getName()});
                entity = null;
            }
        } else {
            par1World.Y().b("Skipping Entity with id " + par0NBTTagCompound.i("id"));
        }
        return entity;
    }

    public static nn a(int par0, abw par1World) {
        nn entity = null;
        try {
            Class oclass = nt.a(par0);
            if (oclass != null) {
                entity = (nn)oclass.getConstructor(abw.class).newInstance(par1World);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (entity == null) {
            par1World.Y().b("Skipping Entity with id " + par0);
        }
        return entity;
    }

    public static int a(nn par0Entity) {
        Class<?> oclass = par0Entity.getClass();
        return e.containsKey(oclass) ? (Integer)e.get(oclass) : 0;
    }

    public static Class a(int par0) {
        return (Class)d.get(par0);
    }

    public static String b(nn par0Entity) {
        return (String)c.get(par0Entity.getClass());
    }

    public static String b(int par0) {
        Class oclass = nt.a(par0);
        return oclass != null ? (String)c.get(oclass) : null;
    }

    static {
        nt.a(ss.class, "Item", 1);
        nt.a(oa.class, "XPOrb", 2);
        nt.a(oe.class, "LeashKnot", 8);
        nt.a(ol.class, "Painting", 9);
        nt.a(uh.class, "Arrow", 10);
        nt.a(up.class, "Snowball", 11);
        nt.a(um.class, "Fireball", 12);
        nt.a(uo.class, "SmallFireball", 13);
        nt.a(us.class, "ThrownEnderpearl", 14);
        nt.a(ui.class, "EyeOfEnderSignal", 15);
        nt.a(uu.class, "ThrownPotion", 16);
        nt.a(ut.class, "ThrownExpBottle", 17);
        nt.a(od.class, "ItemFrame", 18);
        nt.a(uv.class, "WitherSkull", 19);
        nt.a(tc.class, "PrimedTnt", 20);
        nt.a(sr.class, "FallingSand", 21);
        nt.a(uk.class, "FireworksRocketEntity", 22);
        nt.a(sq.class, "Boat", 41);
        nt.a(sy.class, "MinecartRideable", 42);
        nt.a(su.class, "MinecartChest", 43);
        nt.a(sw.class, "MinecartFurnace", 44);
        nt.a(tb.class, "MinecartTNT", 45);
        nt.a(sx.class, "MinecartHopper", 46);
        nt.a(sz.class, "MinecartSpawner", 47);
        nt.a(og.class, "Mob", 48);
        nt.a(tm.class, "Monster", 49);
        nt.a(tf.class, "Creeper", 50, 894731, 0);
        nt.a(tr.class, "Skeleton", 51, 0xC1C1C1, 0x494949);
        nt.a(tt.class, "Spider", 52, 3419431, 11013646);
        nt.a(tk.class, "Giant", 53);
        nt.a(tw.class, "Zombie", 54, 44975, 7969893);
        nt.a(ts.class, "Slime", 55, 5349438, 8306542);
        nt.a(tj.class, "Ghast", 56, 0xF9F9F9, 0xBCBCBC);
        nt.a(tn.class, "PigZombie", 57, 15373203, 5009705);
        nt.a(tg.class, "Enderman", 58, 0x161616, 0);
        nt.a(te.class, "CaveSpider", 59, 803406, 11013646);
        nt.a(tq.class, "Silverfish", 60, 0x6E6E6E, 0x303030);
        nt.a(td.class, "Blaze", 61, 16167425, 16775294);
        nt.a(tl.class, "LavaSlime", 62, 0x340000, 0xFCFC00);
        nt.a(sk.class, "EnderDragon", 63);
        nt.a(sm.class, "WitherBoss", 64);
        nt.a(ro.class, "Bat", 65, 4996656, 986895);
        nt.a(tv.class, "Witch", 66, 0x340000, 5349438);
        nt.a(ry.class, "Pig", 90, 15771042, 14377823);
        nt.a(rz.class, "Sheep", 91, 0xE7E7E7, 0xFFB5B5);
        nt.a(rr.class, "Cow", 92, 4470310, 0xA1A1A1);
        nt.a(rq.class, "Chicken", 93, 0xA1A1A1, 0xFF0000);
        nt.a(sc.class, "Squid", 94, 2243405, 7375001);
        nt.a(sf.class, "Wolf", 95, 0xD7D3D3, 13545366);
        nt.a(rw.class, "MushroomCow", 96, 10489616, 0xB7B7B7);
        nt.a(sb.class, "SnowMan", 97);
        nt.a(rx.class, "Ozelot", 98, 15720061, 5653556);
        nt.a(sd.class, "VillagerGolem", 99);
        nt.a(rs.class, "EntityHorse", 100, 12623485, 0xEEE500);
        nt.a(ub.class, "Villager", 120, 5651507, 12422002);
        nt.a(sj.class, "EnderCrystal", 200);
    }
}

