/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  abp
 *  aco
 *  acr
 *  akc
 *  mi
 *  net.minecraftforge.event.Event$Result
 *  net.minecraftforge.event.ForgeEventFactory
 *  oi
 *  t
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;

public final class aci {
    private HashMap a = new HashMap();

    protected static aco a(abw par0World, int par1, int par2) {
        adr chunk = par0World.e(par1, par2);
        int k = par1 * 16 + par0World.s.nextInt(16);
        int l = par2 * 16 + par0World.s.nextInt(16);
        int i1 = par0World.s.nextInt(chunk == null ? par0World.S() : chunk.h() + 16 - 1);
        return new aco(k, i1, l);
    }

    public int a(js par1WorldServer, boolean par2, boolean par3, boolean par4) {
        int i;
        if (!par2 && !par3) {
            return 0;
        }
        this.a.clear();
        for (i = 0; i < par1WorldServer.h.size(); ++i) {
            uf entityplayer = (uf)par1WorldServer.h.get(i);
            int k = ls.c(entityplayer.u / 16.0);
            int j2 = ls.c(entityplayer.w / 16.0);
            int b0 = 8;
            for (int l = -b0; l <= b0; ++l) {
                for (int i1 = -b0; i1 <= b0; ++i1) {
                    boolean flag3 = l == -b0 || l == b0 || i1 == -b0 || i1 == b0;
                    abp chunkcoordintpair = new abp(l + k, i1 + j2);
                    if (!flag3) {
                        this.a.put(chunkcoordintpair, false);
                        continue;
                    }
                    if (this.a.containsKey(chunkcoordintpair)) continue;
                    this.a.put(chunkcoordintpair, true);
                }
            }
        }
        i = 0;
        t chunkcoordinates = par1WorldServer.K();
        for (oh enumcreaturetype : oh.values()) {
            if (enumcreaturetype.d() && !par3 || !enumcreaturetype.d() && !par2 || enumcreaturetype.e() && !par4 || par1WorldServer.countEntities(enumcreaturetype, true) > enumcreaturetype.b() * this.a.size() / 256) continue;
            Iterator iterator = this.a.keySet().iterator();
            ArrayList tmp = new ArrayList(this.a.keySet());
            Collections.shuffle(tmp);
            block6: for (abp chunkcoordintpair1 : tmp) {
                if (((Boolean)this.a.get(chunkcoordintpair1)).booleanValue()) continue;
                aco chunkposition = aci.a(par1WorldServer, chunkcoordintpair1.a, chunkcoordintpair1.b);
                int k1 = chunkposition.a;
                int l1 = chunkposition.b;
                int i2 = chunkposition.c;
                if (par1WorldServer.u(k1, l1, i2) || par1WorldServer.g(k1, l1, i2) != enumcreaturetype.c()) continue;
                int j2 = 0;
                block7: for (int k2 = 0; k2 < 3; ++k2) {
                    int l2 = k1;
                    int i3 = l1;
                    int j3 = i2;
                    int b1 = 6;
                    acr spawnlistentry = null;
                    oi entitylivingdata = null;
                    for (int k3 = 0; k3 < 4; ++k3) {
                        og entityliving;
                        float f5;
                        float f4;
                        float f3;
                        float f6;
                        float f2;
                        float f1;
                        float f;
                        if (!aci.a(enumcreaturetype, par1WorldServer, l2 += par1WorldServer.s.nextInt(b1) - par1WorldServer.s.nextInt(b1), i3 += par1WorldServer.s.nextInt(1) - par1WorldServer.s.nextInt(1), j3 += par1WorldServer.s.nextInt(b1) - par1WorldServer.s.nextInt(b1)) || par1WorldServer.a(f = (float)l2 + 0.5f, f1 = (float)i3, (double)(f2 = (float)j3 + 0.5f), 24.0) != null || !((f6 = (f3 = f - (float)chunkcoordinates.a) * f3 + (f4 = f1 - (float)chunkcoordinates.b) * f4 + (f5 = f2 - (float)chunkcoordinates.c) * f5) >= 576.0f)) continue;
                        if (spawnlistentry == null && (spawnlistentry = par1WorldServer.a(enumcreaturetype, l2, i3, j3)) == null) continue block7;
                        try {
                            entityliving = (og)spawnlistentry.b.getConstructor(abw.class).newInstance(par1WorldServer);
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            return i;
                        }
                        entityliving.b(f, f1, f2, par1WorldServer.s.nextFloat() * 360.0f, 0.0f);
                        Event.Result canSpawn = ForgeEventFactory.canEntitySpawn((og)entityliving, (abw)par1WorldServer, (float)f, (float)f1, (float)f2);
                        if (canSpawn == Event.Result.ALLOW || canSpawn == Event.Result.DEFAULT && entityliving.bs()) {
                            ++j2;
                            par1WorldServer.d(entityliving);
                            if (!ForgeEventFactory.doSpecialSpawn((og)entityliving, (abw)par1WorldServer, (float)f, (float)f1, (float)f2)) {
                                entitylivingdata = entityliving.a(entitylivingdata);
                            }
                            if (j2 >= ForgeEventFactory.getMaxSpawnPackSize((og)entityliving)) continue block6;
                        }
                        i += j2;
                    }
                }
            }
        }
        return i;
    }

    public static boolean a(oh par0EnumCreatureType, abw par1World, int par2, int par3, int par4) {
        if (par0EnumCreatureType.c() == akc.h) {
            return par1World.g(par2, par3, par4).d() && par1World.g(par2, par3 - 1, par4).d() && !par1World.u(par2, par3 + 1, par4);
        }
        if (!par1World.w(par2, par3 - 1, par4)) {
            return false;
        }
        int l = par1World.a(par2, par3 - 1, par4);
        boolean spawnBlock = aqz.s[l] != null && aqz.s[l].canCreatureSpawn(par0EnumCreatureType, par1World, par2, par3 - 1, par4);
        return spawnBlock && l != aqz.E.cF && !par1World.u(par2, par3, par4) && !par1World.g(par2, par3, par4).d() && !par1World.u(par2, par3 + 1, par4);
    }

    public static void a(abw par0World, acq par1BiomeGenBase, int par2, int par3, int par4, int par5, Random par6Random) {
        List list = par1BiomeGenBase.a(oh.b);
        if (!list.isEmpty()) {
            while (par6Random.nextFloat() < par1BiomeGenBase.f()) {
                acr spawnlistentry = (acr)mi.a((Random)par0World.s, (Collection)list);
                oi entitylivingdata = null;
                int i1 = spawnlistentry.c + par6Random.nextInt(1 + spawnlistentry.d - spawnlistentry.c);
                int j1 = par2 + par6Random.nextInt(par4);
                int k1 = par3 + par6Random.nextInt(par5);
                int l1 = j1;
                int i2 = k1;
                for (int j2 = 0; j2 < i1; ++j2) {
                    boolean flag = false;
                    for (int k2 = 0; !flag && k2 < 4; ++k2) {
                        int l2 = par0World.i(j1, k1);
                        if (aci.a(oh.b, par0World, j1, l2, k1)) {
                            og entityliving;
                            float f = (float)j1 + 0.5f;
                            float f1 = l2;
                            float f2 = (float)k1 + 0.5f;
                            try {
                                entityliving = (og)spawnlistentry.b.getConstructor(abw.class).newInstance(par0World);
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                                continue;
                            }
                            entityliving.b(f, f1, f2, par6Random.nextFloat() * 360.0f, 0.0f);
                            par0World.d(entityliving);
                            entitylivingdata = entityliving.a(entitylivingdata);
                            flag = true;
                        }
                        j1 += par6Random.nextInt(5) - par6Random.nextInt(5);
                        k1 += par6Random.nextInt(5) - par6Random.nextInt(5);
                        while (j1 < par2 || j1 >= par2 + par4 || k1 < par3 || k1 >= par3 + par4) {
                            j1 = l1 + par6Random.nextInt(5) - par6Random.nextInt(5);
                            k1 = i2 + par6Random.nextInt(5) - par6Random.nextInt(5);
                        }
                    }
                }
            }
        }
    }
}

