/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.iurq;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;

public final class xtbl {
    public HashMap _a = new HashMap();

    public static xtcd _a(World world, int n, int n2) {
        Chunk chunk = world.getChunkFromChunkCoords(n, n2);
        int n3 = n * 16 + world.rand.nextInt(16);
        int n4 = n2 * 16 + world.rand.nextInt(16);
        int n5 = world.rand.nextInt(chunk == null ? world.getActualHeight() : chunk._a() + 16 - 1);
        return new xtcd(n3, n5, n4);
    }

    public int _a(WorldServer worldServer, boolean bl, boolean bl2, boolean bl3) {
        Object object;
        int n;
        if (!bl && !bl2) {
            return 0;
        }
        this._a.clear();
        for (n = 0; n < worldServer.playerEntities.size(); ++n) {
            object = (EntityPlayer)worldServer.playerEntities.get(n);
            int n2 = sajh._c(((EntityPlayer)object).posX / 16.0);
            int n3 = sajh._c(((EntityPlayer)object).posZ / 16.0);
            int n4 = 8;
            for (int i = -n4; i <= n4; ++i) {
                for (int j = -n4; j <= n4; ++j) {
                    boolean bl4 = i == -n4 || i == n4 || j == -n4 || j == n4;
                    jjym jjym2 = new jjym(i + n2, j + n3);
                    if (!bl4) {
                        this._a.put(jjym2, false);
                        continue;
                    }
                    if (this._a.containsKey(jjym2)) continue;
                    this._a.put(jjym2, true);
                }
            }
        }
        n = 0;
        object = worldServer.getSpawnPoint();
        for (EnumCreatureType enumCreatureType : EnumCreatureType.values()) {
            if (enumCreatureType._d() && !bl2 || !enumCreatureType._d() && !bl || enumCreatureType._e() && !bl3 || worldServer.countEntities(enumCreatureType, true) > enumCreatureType._b() * this._a.size() / 256) continue;
            Iterator iterator2 = this._a.keySet().iterator();
            ArrayList arrayList = new ArrayList(this._a.keySet());
            Collections.shuffle(arrayList);
            block6: for (jjym jjym2 : arrayList) {
                if (((Boolean)this._a.get(jjym2)).booleanValue()) continue;
                xtcd xtcd2 = xtbl._a(worldServer, jjym2._a, jjym2._b);
                int n5 = xtcd2._d;
                int n6 = xtcd2._e;
                int n7 = xtcd2._f;
                if (worldServer.isBlockNormalCube(n5, n6, n7) || worldServer.getBlockMaterial(n5, n6, n7) != enumCreatureType._c()) continue;
                int n8 = 0;
                block7: for (int i = 0; i < 3; ++i) {
                    int n9 = n5;
                    int n10 = n6;
                    int n11 = n7;
                    int n12 = 6;
                    yffo yffo2 = null;
                    EntityLivingData entityLivingData = null;
                    for (int j = 0; j < 4; ++j) {
                        EntityLiving entityLiving;
                        float f;
                        float f2;
                        float f3;
                        float f4;
                        float f5;
                        float f6;
                        float f7;
                        if (!xtbl._a(enumCreatureType, worldServer, n9 += worldServer.rand.nextInt(n12) - worldServer.rand.nextInt(n12), n10 += worldServer.rand.nextInt(1) - worldServer.rand.nextInt(1), n11 += worldServer.rand.nextInt(n12) - worldServer.rand.nextInt(n12)) || worldServer.getClosestPlayer(f7 = (float)n9 + 0.5f, f6 = (float)n10, f5 = (float)n11 + 0.5f, 24.0) != null || !((f4 = (f3 = f7 - (float)((ChunkCoordinates)object)._a) * f3 + (f2 = f6 - (float)((ChunkCoordinates)object)._b) * f2 + (f = f5 - (float)((ChunkCoordinates)object)._c) * f) >= 576.0f)) continue;
                        if (yffo2 == null && (yffo2 = worldServer.spawnRandomCreature(enumCreatureType, n9, n10, n11)) == null) continue block7;
                        try {
                            entityLiving = (EntityLiving)yffo2._a.getConstructor(World.class).newInstance(worldServer);
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            return n;
                        }
                        entityLiving.setLocationAndAngles(f7, f6, f5, worldServer.rand.nextFloat() * 360.0f, 0.0f);
                        Event.Result result = ForgeEventFactory.canEntitySpawn(entityLiving, worldServer, f7, f6, f5);
                        if (result == Event.Result.ALLOW || result == Event.Result.DEFAULT && entityLiving.getCanSpawnHere()) {
                            ++n8;
                            worldServer.spawnEntityInWorld(entityLiving);
                            if (!ForgeEventFactory.doSpecialSpawn(entityLiving, worldServer, f7, f6, f5)) {
                                entityLivingData = entityLiving.onSpawnWithEgg(entityLivingData);
                            }
                            if (n8 >= ForgeEventFactory.getMaxSpawnPackSize(entityLiving)) continue block6;
                        }
                        n += n8;
                    }
                }
            }
        }
        return n;
    }

    public static boolean _a(EnumCreatureType enumCreatureType, World world, int n, int n2, int n3) {
        if (enumCreatureType._c() == Material._h) {
            return world.getBlockMaterial(n, n2, n3)._d() && world.getBlockMaterial(n, n2 - 1, n3)._d() && !world.isBlockNormalCube(n, n2 + 1, n3);
        }
        if (!world.doesBlockHaveSolidTopSurface(n, n2 - 1, n3)) {
            return false;
        }
        int n4 = world.getBlockId(n, n2 - 1, n3);
        boolean bl = Block.blocksList[n4] != null && Block.blocksList[n4].canCreatureSpawn(enumCreatureType, world, n, n2 - 1, n3);
        return bl && n4 != Block.bedrock.blockID && !world.isBlockNormalCube(n, n2, n3) && !world.getBlockMaterial(n, n2, n3)._d() && !world.isBlockNormalCube(n, n2 + 1, n3);
    }

    public static void _a(World world, BiomeGenBase biomeGenBase, int n, int n2, int n3, int n4, Random random) {
        List list2 = biomeGenBase._a(EnumCreatureType._b);
        if (!list2.isEmpty()) {
            while (random.nextFloat() < biomeGenBase._g()) {
                yffo yffo2 = (yffo)iurq._a(world.rand, list2);
                EntityLivingData entityLivingData = null;
                int n5 = yffo2._b + random.nextInt(1 + yffo2._c - yffo2._b);
                int n6 = n + random.nextInt(n3);
                int n7 = n2 + random.nextInt(n4);
                int n8 = n6;
                int n9 = n7;
                for (int i = 0; i < n5; ++i) {
                    boolean bl = false;
                    for (int j = 0; !bl && j < 4; ++j) {
                        int n10 = world.getTopSolidOrLiquidBlock(n6, n7);
                        if (xtbl._a(EnumCreatureType._b, world, n6, n10, n7)) {
                            EntityLiving entityLiving;
                            float f = (float)n6 + 0.5f;
                            float f2 = n10;
                            float f3 = (float)n7 + 0.5f;
                            try {
                                entityLiving = (EntityLiving)yffo2._a.getConstructor(World.class).newInstance(world);
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                                continue;
                            }
                            entityLiving.setLocationAndAngles(f, f2, f3, random.nextFloat() * 360.0f, 0.0f);
                            world.spawnEntityInWorld(entityLiving);
                            entityLivingData = entityLiving.onSpawnWithEgg(entityLivingData);
                            bl = true;
                        }
                        n6 += random.nextInt(5) - random.nextInt(5);
                        n7 += random.nextInt(5) - random.nextInt(5);
                        while (n6 < n || n6 >= n + n3 || n7 < n2 || n7 >= n2 + n3) {
                            n6 = n8 + random.nextInt(5) - random.nextInt(5);
                            n7 = n9 + random.nextInt(5) - random.nextInt(5);
                        }
                    }
                }
            }
        }
    }
}

