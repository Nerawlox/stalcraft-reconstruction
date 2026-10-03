/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.world.ChunkEvent;

public class Chunk {
    public static boolean _a;
    public ujzm[] _b = new ujzm[16];
    public byte[] _c = new byte[256];
    public int[] _d = new int[256];
    public boolean[] _e = new boolean[256];
    public boolean _f;
    public World _g;
    public int[] _h;
    public final int _i;
    public final int _j;
    public boolean _k;
    public Map _l = new HashMap();
    public List[] _m = new List[16];
    public boolean _n;
    public boolean _o;
    public boolean _p;
    public long _q;
    public boolean _r;
    public int _s;
    public long _t;
    public int _u = 4096;

    public Chunk(World world, int n, int n2) {
        this._g = world;
        this._i = n;
        this._j = n2;
        this._h = new int[256];
        for (int i = 0; i < this._m.length; ++i) {
            this._m[i] = new ArrayList();
        }
        Arrays.fill(this._d, -999);
        Arrays.fill(this._c, (byte)-1);
    }

    public Chunk(World world, byte[] byArray, int n, int n2) {
        this(world, n, n2);
        int n3 = byArray.length / 256;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < n3; ++k) {
                    int n4 = byArray[i << 11 | j << 7 | k] & 0xFF;
                    if (n4 == 0) continue;
                    int n5 = k >> 4;
                    if (this._b[n5] == null) {
                        this._b[n5] = new ujzm(n5 << 4, !world.provider._g);
                    }
                    this._b[n5]._a(i, k & 0xF, j, n4);
                }
            }
        }
    }

    public Chunk(World world, byte[] byArray, byte[] byArray2, int n, int n2) {
        this(world, n, n2);
        int n3 = byArray.length / 256;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < n3; ++k) {
                    int n4 = i << 11 | j << 7 | k;
                    int n5 = byArray[n4] & 0xFF;
                    byte by = byArray2[n4];
                    if (n5 == 0) continue;
                    int n6 = k >> 4;
                    if (this._b[n6] == null) {
                        this._b[n6] = new ujzm(n6 << 4, !world.provider._g);
                    }
                    this._b[n6]._a(i, k & 0xF, j, n5);
                    this._b[n6]._b(i, k & 0xF, j, by);
                }
            }
        }
    }

    public Chunk(World world, short[] sArray, byte[] byArray, int n, int n2) {
        this(world, n, n2);
        int n3 = sArray.length / 256;
        for (int i = 0; i < n3; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    int n4 = i << 8 | j << 4 | k;
                    int n5 = sArray[n4] & 0xFFFFFF;
                    byte by = byArray[n4];
                    if (n5 == 0) continue;
                    int n6 = i >> 4;
                    if (this._b[n6] == null) {
                        this._b[n6] = new ujzm(n6 << 4, !world.provider._g);
                    }
                    this._b[n6]._a(k, i & 0xF, j, n5);
                    this._b[n6]._b(k, i & 0xF, j, by);
                }
            }
        }
    }

    public boolean _a(int n, int n2) {
        return n == this._i && n2 == this._j;
    }

    public int _b(int n, int n2) {
        return this._h[n2 << 4 | n];
    }

    public int _a() {
        for (int i = this._b.length - 1; i >= 0; --i) {
            if (this._b[i] == null) continue;
            return this._b[i]._c();
        }
        return 0;
    }

    public ujzm[] _b() {
        return this._b;
    }

    @SideOnly(value=Side.CLIENT)
    public void _c() {
        int n = this._a();
        for (int i = 0; i < 16; ++i) {
            block1: for (int j = 0; j < 16; ++j) {
                this._d[i + (j << 4)] = -999;
                for (int k = n + 16 - 1; k > 0; --k) {
                    int n2 = this._d(i, k - 1, j);
                    if (this._c(i, k - 1, j) == 0) {
                        continue;
                    }
                    this._h[j << 4 | i] = k;
                    continue block1;
                }
            }
        }
        this._o = true;
    }

    public void _d() {
        int n;
        int n2;
        int n3 = this._a();
        this._s = Integer.MAX_VALUE;
        for (n2 = 0; n2 < 16; ++n2) {
            for (n = 0; n < 16; ++n) {
                int n4;
                this._d[n2 + (n << 4)] = -999;
                for (n4 = n3 + 16 - 1; n4 > 0; --n4) {
                    if (this._c(n2, n4 - 1, n) == 0) {
                        continue;
                    }
                    this._h[n << 4 | n2] = n4;
                    if (n4 >= this._s) break;
                    this._s = n4;
                    break;
                }
                if (this._g.provider._g) continue;
                n4 = 15;
                int n5 = n3 + 16 - 1;
                do {
                    ujzm ujzm2;
                    if ((n4 -= this._c(n2, n5, n)) <= 0 || (ujzm2 = this._b[n5 >> 4]) == null) continue;
                    ujzm2._c(n2, n5 & 0xF, n, n4);
                    this._g.markBlockForRenderUpdate((this._i << 4) + n2, n5, (this._j << 4) + n);
                } while (--n5 > 0 && n4 > 0);
            }
        }
        this._o = true;
        for (n2 = 0; n2 < 16; ++n2) {
            for (n = 0; n < 16; ++n) {
                this._c(n2, n);
            }
        }
    }

    public void _c(int n, int n2) {
        this._e[n + n2 * 16] = true;
        this._k = true;
    }

    public void _e() {
        this._g.theProfiler._a("recheckGaps");
        if (this._g.doChunksNearChunkExist(this._i * 16 + 8, 0, this._j * 16 + 8, 16)) {
            for (int i = 0; i < 16; ++i) {
                for (int j = 0; j < 16; ++j) {
                    if (!this._e[i + j * 16]) continue;
                    this._e[i + j * 16] = false;
                    int n = this._b(i, j);
                    int n2 = this._i * 16 + i;
                    int n3 = this._j * 16 + j;
                    int n4 = this._g.getChunkHeightMapMinimum(n2 - 1, n3);
                    int n5 = this._g.getChunkHeightMapMinimum(n2 + 1, n3);
                    int n6 = this._g.getChunkHeightMapMinimum(n2, n3 - 1);
                    int n7 = this._g.getChunkHeightMapMinimum(n2, n3 + 1);
                    if (n5 < n4) {
                        n4 = n5;
                    }
                    if (n6 < n4) {
                        n4 = n6;
                    }
                    if (n7 < n4) {
                        n4 = n7;
                    }
                    this._a(n2, n3, n4);
                    this._a(n2 - 1, n3, n);
                    this._a(n2 + 1, n3, n);
                    this._a(n2, n3 - 1, n);
                    this._a(n2, n3 + 1, n);
                }
            }
            this._k = false;
        }
        this._g.theProfiler._b();
    }

    public void _a(int n, int n2, int n3) {
        int n4 = this._g.getHeightValue(n, n2);
        if (n4 > n3) {
            this._a(n, n2, n3, n4 + 1);
        } else if (n4 < n3) {
            this._a(n, n2, n4, n3 + 1);
        }
    }

    public void _a(int n, int n2, int n3, int n4) {
        if (n4 > n3 && this._g.doChunksNearChunkExist(n, 0, n2, 16)) {
            for (int i = n3; i < n4; ++i) {
                this._g.updateLightByType(EnumSkyBlock._a, n, i, n2);
            }
            this._o = true;
        }
    }

    public void _b(int n, int n2, int n3) {
        int n4;
        int n5 = n4 = this._h[n3 << 4 | n] & 0xFF;
        if (n2 > n4) {
            n5 = n2;
        }
        while (n5 > 0 && this._c(n, n5 - 1, n3) == 0) {
            --n5;
        }
        if (n5 != n4) {
            int n6;
            int n7;
            this._g.markBlocksDirtyVertical(n + this._i * 16, n3 + this._j * 16, n5, n4);
            this._h[n3 << 4 | n] = n5;
            int n8 = this._i * 16 + n;
            int n9 = this._j * 16 + n3;
            if (!this._g.provider._g) {
                ujzm ujzm2;
                if (n5 < n4) {
                    for (n7 = n5; n7 < n4; ++n7) {
                        ujzm2 = this._b[n7 >> 4];
                        if (ujzm2 == null) continue;
                        ujzm2._c(n, n7 & 0xF, n3, 15);
                        this._g.markBlockForRenderUpdate((this._i << 4) + n, n7, (this._j << 4) + n3);
                    }
                } else {
                    for (n7 = n4; n7 < n5; ++n7) {
                        ujzm2 = this._b[n7 >> 4];
                        if (ujzm2 == null) continue;
                        ujzm2._c(n, n7 & 0xF, n3, 0);
                        this._g.markBlockForRenderUpdate((this._i << 4) + n, n7, (this._j << 4) + n3);
                    }
                }
                n7 = 15;
                while (n5 > 0 && n7 > 0) {
                    ujzm ujzm3;
                    if ((n6 = this._c(n, --n5, n3)) == 0) {
                        n6 = 1;
                    }
                    if ((n7 -= n6) < 0) {
                        n7 = 0;
                    }
                    if ((ujzm3 = this._b[n5 >> 4]) == null) continue;
                    ujzm3._c(n, n5 & 0xF, n3, n7);
                }
            }
            n7 = this._h[n3 << 4 | n];
            n6 = n4;
            int n10 = n7;
            if (n7 < n4) {
                n6 = n7;
                n10 = n4;
            }
            if (n7 < this._s) {
                this._s = n7;
            }
            if (!this._g.provider._g) {
                this._a(n8 - 1, n9, n6, n10);
                this._a(n8 + 1, n9, n6, n10);
                this._a(n8, n9 - 1, n6, n10);
                this._a(n8, n9 + 1, n6, n10);
                this._a(n8, n9, n6, n10);
            }
            this._o = true;
        }
    }

    public int _c(int n, int n2, int n3) {
        int n4 = (this._i << 4) + n;
        int n5 = (this._j << 4) + n3;
        Block block = Block.blocksList[this._d(n, n2, n3)];
        return block == null ? 0 : block.getLightOpacity(this._g, n4, n2, n5);
    }

    public int _d(int n, int n2, int n3) {
        if (n2 >> 4 >= this._b.length) {
            return 0;
        }
        ujzm ujzm2 = this._b[n2 >> 4];
        return ujzm2 != null ? ujzm2._a(n, n2 & 0xF, n3) : 0;
    }

    public int _e(int n, int n2, int n3) {
        if (n2 >> 4 >= this._b.length) {
            return 0;
        }
        ujzm ujzm2 = this._b[n2 >> 4];
        return ujzm2 != null ? ujzm2._b(n, n2 & 0xF, n3) : 0;
    }

    public boolean _a(int n, int n2, int n3, int n4, int n5) {
        TileEntity tileEntity;
        int n6 = n3 << 4 | n;
        if (n2 >= this._d[n6] - 1) {
            this._d[n6] = -999;
        }
        int n7 = this._h[n6];
        int n8 = this._d(n, n2, n3);
        int n9 = this._e(n, n2, n3);
        if (n8 == n4 && n9 == n5) {
            return false;
        }
        ujzm ujzm2 = this._b[n2 >> 4];
        boolean bl = false;
        if (ujzm2 == null) {
            if (n4 == 0) {
                return false;
            }
            ujzm ujzm3 = new ujzm(n2 >> 4 << 4, !this._g.provider._g);
            this._b[n2 >> 4] = ujzm3;
            ujzm2 = ujzm3;
            bl = n2 >= n7;
        }
        int n10 = this._i * 16 + n;
        int n11 = this._j * 16 + n3;
        if (n8 != 0 && !this._g.isRemote) {
            Block.blocksList[n8].onBlockPreDestroy(this._g, n10, n2, n11, n9);
        }
        ujzm2._a(n, n2 & 0xF, n3, n4);
        if (n8 != 0) {
            if (!this._g.isRemote) {
                Block.blocksList[n8].breakBlock(this._g, n10, n2, n11, n8, n9);
            } else if (Block.blocksList[n8] != null && Block.blocksList[n8].hasTileEntity(n9) && (tileEntity = this._j(n10 & 0xF, n2, n11 & 0xF)) != null && tileEntity.shouldRefresh(n8, n4, n9, n5, this._g, n10, n2, n11)) {
                this._g.removeBlockTileEntity(n10, n2, n11);
            }
        }
        if (ujzm2._a(n, n2 & 0xF, n3) != n4) {
            return false;
        }
        ujzm2._b(n, n2 & 0xF, n3, n5);
        if (bl) {
            this._d();
        } else {
            if (this._c(n, n2, n3) > 0) {
                if (n2 >= n7) {
                    this._b(n, n2 + 1, n3);
                }
            } else if (n2 == n7 - 1) {
                this._b(n, n2, n3);
            }
            this._c(n, n3);
        }
        if (n4 != 0) {
            if (!this._g.isRemote) {
                Block.blocksList[n4].onBlockAdded(this._g, n10, n2, n11);
            }
            if (Block.blocksList[n4] != null && Block.blocksList[n4].hasTileEntity(n5)) {
                tileEntity = this._g(n, n2, n3);
                if (tileEntity == null) {
                    tileEntity = Block.blocksList[n4].createTileEntity(this._g, n5);
                    this._g.setBlockTileEntity(n10, n2, n11, tileEntity);
                }
                if (tileEntity != null) {
                    tileEntity.updateContainingBlockInfo();
                    tileEntity.blockMetadata = n5;
                }
            }
        }
        this._o = true;
        return true;
    }

    public boolean _b(int n, int n2, int n3, int n4) {
        TileEntity tileEntity;
        ujzm ujzm2 = this._b[n2 >> 4];
        if (ujzm2 == null) {
            return false;
        }
        int n5 = ujzm2._b(n, n2 & 0xF, n3);
        if (n5 == n4) {
            return false;
        }
        this._o = true;
        ujzm2._b(n, n2 & 0xF, n3, n4);
        int n6 = ujzm2._a(n, n2 & 0xF, n3);
        if (n6 > 0 && Block.blocksList[n6] != null && Block.blocksList[n6].hasTileEntity(n4) && (tileEntity = this._g(n, n2, n3)) != null) {
            tileEntity.updateContainingBlockInfo();
            tileEntity.blockMetadata = n4;
        }
        return true;
    }

    public int _a(EnumSkyBlock enumSkyBlock, int n, int n2, int n3) {
        ujzm ujzm2 = this._b[n2 >> 4];
        return ujzm2 == null ? (this._f(n, n2, n3) ? enumSkyBlock._c : 0) : (enumSkyBlock == EnumSkyBlock._a ? (this._g.provider._g ? 0 : ujzm2._c(n, n2 & 0xF, n3)) : (enumSkyBlock == EnumSkyBlock._b ? ujzm2._d(n, n2 & 0xF, n3) : enumSkyBlock._c));
    }

    public void _a(EnumSkyBlock enumSkyBlock, int n, int n2, int n3, int n4) {
        ujzm ujzm2 = this._b[n2 >> 4];
        if (ujzm2 == null) {
            ujzm ujzm3 = new ujzm(n2 >> 4 << 4, !this._g.provider._g);
            this._b[n2 >> 4] = ujzm3;
            ujzm2 = ujzm3;
            this._d();
        }
        this._o = true;
        if (enumSkyBlock == EnumSkyBlock._a) {
            if (!this._g.provider._g) {
                ujzm2._c(n, n2 & 0xF, n3, n4);
            }
        } else if (enumSkyBlock == EnumSkyBlock._b) {
            ujzm2._d(n, n2 & 0xF, n3, n4);
        }
    }

    public int _c(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        ujzm ujzm2 = this._b[n2 >> 4];
        if (ujzm2 == null) {
            return !this._g.provider._g && n4 < EnumSkyBlock._a._c ? EnumSkyBlock._a._c - n4 : 0;
        }
        int n7 = n6 = this._g.provider._g ? 0 : ujzm2._c(n, n2 & 0xF, n3);
        if (n6 > 0) {
            _a = true;
        }
        if ((n5 = ujzm2._d(n, n2 & 0xF, n3)) > (n6 -= n4)) {
            n6 = n5;
        }
        return n6;
    }

    public void _a(Entity entity) {
        int n;
        this._p = true;
        int n2 = sajh._c(entity.posX / 16.0);
        int n3 = sajh._c(entity.posZ / 16.0);
        if (n2 != this._i || n3 != this._j) {
            this._g.getWorldLogAgent()._c("Wrong location! " + entity);
            Thread.dumpStack();
        }
        if ((n = sajh._c(entity.posY / 16.0)) < 0) {
            n = 0;
        }
        if (n >= this._m.length) {
            n = this._m.length - 1;
        }
        MinecraftForge.EVENT_BUS.post(new EntityEvent.EnteringChunk(entity, this._i, this._j, entity.chunkCoordX, entity.chunkCoordZ));
        entity.addedToChunk = true;
        entity.chunkCoordX = this._i;
        entity.chunkCoordY = n;
        entity.chunkCoordZ = this._j;
        this._m[n].add(entity);
    }

    public void _b(Entity entity) {
        this._a(entity, entity.chunkCoordY);
    }

    public void _a(Entity entity, int n) {
        if (n < 0) {
            n = 0;
        }
        if (n >= this._m.length) {
            n = this._m.length - 1;
        }
        this._m[n].remove(entity);
    }

    public boolean _f(int n, int n2, int n3) {
        return n2 >= this._h[n3 << 4 | n];
    }

    public TileEntity _g(int n, int n2, int n3) {
        TileEntity tileEntity = GloomyHooks.getChunkBlockTileEntity(this, n, n2, n3);
        return tileEntity;
    }

    public void _a(TileEntity tileEntity) {
        int n = tileEntity.xCoord - this._i * 16;
        int n2 = tileEntity.yCoord;
        int n3 = tileEntity.zCoord - this._j * 16;
        this._a(n, n2, n3, tileEntity);
        if (this._f) {
            this._g.addTileEntity(tileEntity);
        }
    }

    public void _a(int n, int n2, int n3, TileEntity tileEntity) {
        xtcd xtcd2 = new xtcd(n, n2, n3);
        tileEntity.setWorldObj(this._g);
        tileEntity.xCoord = this._i * 16 + n;
        tileEntity.yCoord = n2;
        tileEntity.zCoord = this._j * 16 + n3;
        Block block = Block.blocksList[this._d(n, n2, n3)];
        if (block != null && block.hasTileEntity(this._e(n, n2, n3))) {
            if (this._l.containsKey(xtcd2)) {
                ((TileEntity)this._l.get(xtcd2)).invalidate();
            }
            tileEntity.validate();
            this._l.put(xtcd2, tileEntity);
        }
    }

    public void _h(int n, int n2, int n3) {
        TileEntity tileEntity;
        xtcd xtcd2 = new xtcd(n, n2, n3);
        if (this._f && (tileEntity = (TileEntity)this._l.remove(xtcd2)) != null) {
            tileEntity.invalidate();
        }
    }

    public void _f() {
        this._f = true;
        this._g.addTileEntity(this._l.values());
        for (int i = 0; i < this._m.length; ++i) {
            for (Entity entity : this._m[i]) {
                entity.onChunkLoad();
            }
            this._g.addLoadedEntities(this._m[i]);
        }
        MinecraftForge.EVENT_BUS.post(new ChunkEvent.Load(this));
    }

    public void _g() {
        this._f = false;
        for (TileEntity tileEntity : this._l.values()) {
            this._g.markTileEntityForDespawn(tileEntity);
        }
        for (int i = 0; i < this._m.length; ++i) {
            this._g.unloadEntities(this._m[i]);
        }
        MinecraftForge.EVENT_BUS.post(new ChunkEvent.Unload(this));
    }

    public void _h() {
        this._o = true;
    }

    public void _a(Entity entity, AxisAlignedBB axisAlignedBB, List list, IEntitySelector iEntitySelector) {
        int n = sajh._c((axisAlignedBB._c - World.MAX_ENTITY_RADIUS) / 16.0);
        int n2 = sajh._c((axisAlignedBB._f + World.MAX_ENTITY_RADIUS) / 16.0);
        if (n < 0) {
            n = 0;
            n2 = Math.max(n, n2);
        }
        if (n2 >= this._m.length) {
            n2 = this._m.length - 1;
            n = Math.min(n, n2);
        }
        for (int i = n; i <= n2; ++i) {
            List list2 = this._m[i];
            for (int j = 0; j < list2.size(); ++j) {
                Entity entity2 = (Entity)list2.get(j);
                if (entity2 == entity || !entity2.boundingBox._b(axisAlignedBB) || iEntitySelector != null && !iEntitySelector.isEntityApplicable(entity2)) continue;
                list.add(entity2);
                Entity[] entityArray = entity2.getParts();
                if (entityArray == null) continue;
                for (int k = 0; k < entityArray.length; ++k) {
                    entity2 = entityArray[k];
                    if (entity2 == entity || !entity2.boundingBox._b(axisAlignedBB) || iEntitySelector != null && !iEntitySelector.isEntityApplicable(entity2)) continue;
                    list.add(entity2);
                }
            }
        }
    }

    public void _a(Class clazz, AxisAlignedBB axisAlignedBB, List list, IEntitySelector iEntitySelector) {
        int n = sajh._c((axisAlignedBB._c - World.MAX_ENTITY_RADIUS) / 16.0);
        int n2 = sajh._c((axisAlignedBB._f + World.MAX_ENTITY_RADIUS) / 16.0);
        if (n < 0) {
            n = 0;
        } else if (n >= this._m.length) {
            n = this._m.length - 1;
        }
        if (n2 >= this._m.length) {
            n2 = this._m.length - 1;
        } else if (n2 < 0) {
            n2 = 0;
        }
        for (int i = n; i <= n2; ++i) {
            List list2 = this._m[i];
            for (int j = 0; j < list2.size(); ++j) {
                Entity entity = (Entity)list2.get(j);
                if (!clazz.isAssignableFrom(entity.getClass()) || !entity.boundingBox._b(axisAlignedBB) || iEntitySelector != null && !iEntitySelector.isEntityApplicable(entity)) continue;
                list.add(entity);
            }
        }
    }

    public boolean _a(boolean bl) {
        if (bl ? this._p && this._g.getTotalWorldTime() != this._q || this._o : this._p && this._g.getTotalWorldTime() >= this._q + 600L) {
            return true;
        }
        return this._o;
    }

    public Random _a(long l) {
        return new Random(this._g.getSeed() + (long)(this._i * this._i * 4987142) + (long)(this._i * 5947611) + (long)(this._j * this._j) * 4392871L + (long)(this._j * 389711) ^ l);
    }

    public boolean _i() {
        return false;
    }

    public void _a(IChunkProvider iChunkProvider, IChunkProvider iChunkProvider2, int n, int n2) {
        if (!this._n && iChunkProvider._c(n + 1, n2 + 1) && iChunkProvider._c(n, n2 + 1) && iChunkProvider._c(n + 1, n2)) {
            iChunkProvider._a(iChunkProvider2, n, n2);
        }
        if (iChunkProvider._c(n - 1, n2) && !iChunkProvider._b((int)(n - 1), (int)n2)._n && iChunkProvider._c(n - 1, n2 + 1) && iChunkProvider._c(n, n2 + 1) && iChunkProvider._c(n - 1, n2 + 1)) {
            iChunkProvider._a(iChunkProvider2, n - 1, n2);
        }
        if (iChunkProvider._c(n, n2 - 1) && !iChunkProvider._b((int)n, (int)(n2 - 1))._n && iChunkProvider._c(n + 1, n2 - 1) && iChunkProvider._c(n + 1, n2 - 1) && iChunkProvider._c(n + 1, n2)) {
            iChunkProvider._a(iChunkProvider2, n, n2 - 1);
        }
        if (iChunkProvider._c(n - 1, n2 - 1) && !iChunkProvider._b((int)(n - 1), (int)(n2 - 1))._n && iChunkProvider._c(n, n2 - 1) && iChunkProvider._c(n - 1, n2)) {
            iChunkProvider._a(iChunkProvider2, n - 1, n2 - 1);
        }
    }

    public int _d(int n, int n2) {
        int n3 = n | n2 << 4;
        int n4 = this._d[n3];
        if (n4 == -999) {
            int n5 = this._a() + 15;
            n4 = -1;
            while (n5 > 0 && n4 == -1) {
                Material material;
                int n6 = this._d(n, n5, n2);
                Material material2 = material = n6 == 0 ? Material._a : Block.blocksList[n6].blockMaterial;
                if (!material._c() && !material._d()) {
                    --n5;
                    continue;
                }
                n4 = n5 + 1;
            }
            this._d[n3] = n4;
        }
        return n4;
    }

    public void _j() {
        if (this._k && !this._g.provider._g) {
            this._e();
        }
    }

    public jjym _k() {
        return new jjym(this._i, this._j);
    }

    public boolean _e(int n, int n2) {
        if (n < 0) {
            n = 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        for (int i = n; i <= n2; i += 16) {
            ujzm ujzm2 = this._b[i >> 4];
            if (ujzm2 == null || ujzm2._a()) continue;
            return false;
        }
        return true;
    }

    public void _a(ujzm[] ujzmArray) {
        this._b = ujzmArray;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(byte[] byArray, int n, int n2, boolean bl) {
        Object object;
        int n3;
        for (TileEntity tileEntity : this._l.values()) {
            tileEntity.updateContainingBlockInfo();
            tileEntity.getBlockMetadata();
            tileEntity.getBlockType();
        }
        int n4 = 0;
        boolean bl2 = !this._g.provider._g;
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n & 1 << n3) != 0) {
                if (this._b[n3] == null) {
                    this._b[n3] = new ujzm(n3 << 4, bl2);
                }
                object = this._b[n3]._e();
                System.arraycopy(byArray, n4, object, 0, ((byte[])object).length);
                n4 += ((byte[])object).length;
                continue;
            }
            if (!bl || this._b[n3] == null) continue;
            this._b[n3] = null;
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n & 1 << n3) == 0 || this._b[n3] == null) continue;
            object = this._b[n3]._h();
            System.arraycopy(byArray, n4, object._a, 0, object._a.length);
            n4 += object._a.length;
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n & 1 << n3) == 0 || this._b[n3] == null) continue;
            object = this._b[n3]._i();
            System.arraycopy(byArray, n4, object._a, 0, object._a.length);
            n4 += object._a.length;
        }
        if (bl2) {
            for (n3 = 0; n3 < this._b.length; ++n3) {
                if ((n & 1 << n3) == 0 || this._b[n3] == null) continue;
                object = this._b[n3]._j();
                System.arraycopy(byArray, n4, object._a, 0, object._a.length);
                n4 += object._a.length;
            }
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if ((n2 & 1 << n3) != 0) {
                if (this._b[n3] == null) {
                    n4 += 2048;
                    continue;
                }
                object = this._b[n3]._g();
                if (object == null) {
                    object = this._b[n3]._k();
                }
                System.arraycopy(byArray, n4, object._a, 0, object._a.length);
                n4 += object._a.length;
                continue;
            }
            if (!bl || this._b[n3] == null || this._b[n3]._g() == null) continue;
            this._b[n3]._f();
        }
        if (bl) {
            System.arraycopy(byArray, n4, this._c, 0, this._c.length);
            int n5 = n4 + this._c.length;
        }
        for (n3 = 0; n3 < this._b.length; ++n3) {
            if (this._b[n3] == null || (n & 1 << n3) == 0) continue;
            this._b[n3]._d();
        }
        this._c();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Object object2 : this._l.values()) {
            int n6 = ((TileEntity)object2).xCoord & 0xF;
            int n7 = ((TileEntity)object2).yCoord;
            int n8 = ((TileEntity)object2).zCoord & 0xF;
            Block block = ((TileEntity)object2).getBlockType();
            if (block == null || block.blockID != this._d(n6, n7, n8) || ((TileEntity)object2).getBlockMetadata() != this._e(n6, n7, n8)) {
                arrayList.add(object2);
            }
            ((TileEntity)object2).updateContainingBlockInfo();
        }
        for (TileEntity tileEntity : arrayList) {
            tileEntity.invalidate();
        }
    }

    public BiomeGenBase _a(int n, int n2, WorldChunkManager worldChunkManager) {
        int n3 = this._c[n2 << 4 | n] & 0xFF;
        if (n3 == 255) {
            BiomeGenBase biomeGenBase = worldChunkManager._a((this._i << 4) + n, (this._j << 4) + n2);
            n3 = biomeGenBase._P;
            this._c[n2 << 4 | n] = (byte)(n3 & 0xFF);
        }
        return BiomeGenBase._a[n3] == null ? BiomeGenBase._c : BiomeGenBase._a[n3];
    }

    public byte[] _l() {
        return this._c;
    }

    public void _a(byte[] byArray) {
        this._c = byArray;
    }

    public void _m() {
        this._u = 0;
    }

    public void _n() {
        for (int i = 0; i < 8; ++i) {
            if (this._u >= 4096) {
                return;
            }
            int n = this._u % 16;
            int n2 = this._u / 16 % 16;
            int n3 = this._u / 256;
            ++this._u;
            int n4 = (this._i << 4) + n2;
            int n5 = (this._j << 4) + n3;
            for (int j = 0; j < 16; ++j) {
                int n6 = (n << 4) + j;
                if ((this._b[n] != null || j != 0 && j != 15 && n2 != 0 && n2 != 15 && n3 != 0 && n3 != 15) && (this._b[n] == null || this._b[n]._a(n2, j, n3) != 0)) continue;
                if (Block.lightValue[this._g.getBlockId(n4, n6 - 1, n5)] > 0) {
                    this._g.updateAllLightTypes(n4, n6 - 1, n5);
                }
                if (Block.lightValue[this._g.getBlockId(n4, n6 + 1, n5)] > 0) {
                    this._g.updateAllLightTypes(n4, n6 + 1, n5);
                }
                if (Block.lightValue[this._g.getBlockId(n4 - 1, n6, n5)] > 0) {
                    this._g.updateAllLightTypes(n4 - 1, n6, n5);
                }
                if (Block.lightValue[this._g.getBlockId(n4 + 1, n6, n5)] > 0) {
                    this._g.updateAllLightTypes(n4 + 1, n6, n5);
                }
                if (Block.lightValue[this._g.getBlockId(n4, n6, n5 - 1)] > 0) {
                    this._g.updateAllLightTypes(n4, n6, n5 - 1);
                }
                if (Block.lightValue[this._g.getBlockId(n4, n6, n5 + 1)] > 0) {
                    this._g.updateAllLightTypes(n4, n6, n5 + 1);
                }
                this._g.updateAllLightTypes(n4, n6, n5);
            }
        }
    }

    public void _i(int n, int n2, int n3) {
        TileEntity tileEntity;
        xtcd xtcd2 = new xtcd(n, n2, n3);
        if (this._f && (tileEntity = (TileEntity)this._l.get(xtcd2)) != null && tileEntity.isInvalid()) {
            this._l.remove(xtcd2);
        }
    }

    public TileEntity _j(int n, int n2, int n3) {
        xtcd xtcd2 = new xtcd(n, n2, n3);
        TileEntity tileEntity = (TileEntity)this._l.get(xtcd2);
        if (tileEntity != null && tileEntity.isInvalid()) {
            this._l.remove(xtcd2);
            tileEntity = null;
        }
        return tileEntity;
    }
}

