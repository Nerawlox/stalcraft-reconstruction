/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.bundle.pidb;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.common.DimensionManager;

public abstract class WorldProvider {
    public static final float[] _a = new float[]{1.0f, 0.75f, 0.5f, 0.25f, 0.0f, 0.25f, 0.5f, 0.75f};
    public World _b;
    public nwix _c;
    public String _d;
    public WorldChunkManager _e;
    public boolean _f;
    public boolean _g;
    public float[] _h = new float[16];
    public int _i;
    public float[] _j = new float[4];
    public IRenderHandler _k = null;
    public IRenderHandler _l = null;

    public final void _a(World world) {
        this._b = world;
        this._c = world.getWorldInfo()._u();
        this._d = world.getWorldInfo()._y();
        this._b();
        this._a();
    }

    public void _a() {
        float f = 0.0f;
        for (int i = 0; i <= 15; ++i) {
            float f2 = 1.0f - (float)i / 15.0f;
            this._h[i] = (1.0f - f2) / (f2 * 3.0f + 1.0f) * (1.0f - f) + f;
        }
    }

    public void _b() {
        this._e = this._c._a(this._b);
    }

    public IChunkProvider _c() {
        IChunkProvider iChunkProvider = GloomyHooks.createChunkGenerator(this);
        if (iChunkProvider != null) {
            return iChunkProvider;
        }
        return this._c._a(this._b, this._d);
    }

    public boolean _a(int n, int n2) {
        int n3 = this._b.getFirstUncoveredBlock(n, n2);
        return n3 == Block.grass.blockID;
    }

    public float _a(long l, float f) {
        float f2 = pidb._a(this, l, f);
        return f2;
    }

    public int _a(long l) {
        int n = pidb._a(this, l);
        return n;
    }

    public boolean _d() {
        return true;
    }

    @SideOnly(value=Side.CLIENT)
    public float[] _a(float f, float f2) {
        float f3;
        float f4 = 0.4f;
        float f5 = sajh._b(f * (float)Math.PI * 2.0f) - 0.0f;
        if (f5 >= (f3 = -0.0f) - f4 && f5 <= f3 + f4) {
            float f6 = (f5 - f3) / f4 * 0.5f + 0.5f;
            float f7 = 1.0f - (1.0f - sajh._a(f6 * (float)Math.PI)) * 0.99f;
            f7 *= f7;
            this._j[0] = f6 * 0.3f + 0.7f;
            this._j[1] = f6 * f6 * 0.7f + 0.2f;
            this._j[2] = f6 * f6 * 0.0f + 0.2f;
            this._j[3] = f7;
            return this._j;
        }
        return null;
    }

    @SideOnly(value=Side.CLIENT)
    public Vec3 _b(float f, float f2) {
        float f3 = sajh._b(f * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        float f4 = 0.7529412f;
        float f5 = 0.84705883f;
        float f6 = 1.0f;
        return this._b.getWorldVec3Pool()._a(f4 *= f3 * 0.94f + 0.06f, f5 *= f3 * 0.94f + 0.06f, f6 *= f3 * 0.91f + 0.09f);
    }

    public boolean _e() {
        return true;
    }

    public static WorldProvider _a(int n) {
        return DimensionManager.createProviderFor(n);
    }

    @SideOnly(value=Side.CLIENT)
    public float _f() {
        return this._c._m();
    }

    @SideOnly(value=Side.CLIENT)
    public boolean _g() {
        return true;
    }

    public ChunkCoordinates _h() {
        return null;
    }

    public int _i() {
        return this._c._b(this._b);
    }

    @SideOnly(value=Side.CLIENT)
    public boolean _j() {
        return this._c._b(this._g);
    }

    @SideOnly(value=Side.CLIENT)
    public double _k() {
        return this._c._h();
    }

    @SideOnly(value=Side.CLIENT)
    public boolean _b(int n, int n2) {
        return false;
    }

    public abstract String _l();

    public void _b(int n) {
        this._i = n;
    }

    public String _m() {
        String string = pidb._a(this);
        return string;
    }

    public String _n() {
        if (this instanceof WorldProviderEnd) {
            return "Entering the End";
        }
        if (this instanceof WorldProviderHell) {
            return "Entering the Nether";
        }
        return null;
    }

    public String _o() {
        if (this instanceof WorldProviderEnd) {
            return "Leaving the End";
        }
        if (this instanceof WorldProviderHell) {
            return "Leaving the Nether";
        }
        return null;
    }

    public double _p() {
        if (this instanceof WorldProviderHell) {
            return 8.0;
        }
        return 1.0;
    }

    @SideOnly(value=Side.CLIENT)
    public IRenderHandler _q() {
        return this._k;
    }

    @SideOnly(value=Side.CLIENT)
    public void _a(IRenderHandler iRenderHandler) {
        this._k = iRenderHandler;
    }

    @SideOnly(value=Side.CLIENT)
    public IRenderHandler _r() {
        return this._l;
    }

    @SideOnly(value=Side.CLIENT)
    public void _b(IRenderHandler iRenderHandler) {
        this._l = iRenderHandler;
    }

    public ChunkCoordinates _s() {
        ChunkCoordinates chunkCoordinates = new ChunkCoordinates(this._b.getSpawnPoint());
        boolean bl = this._b.getWorldInfo()._r() == EnumGameType._d;
        int n = this._c._k();
        int n2 = n / 2;
        if (!this._g && !bl) {
            chunkCoordinates._a += this._b.rand.nextInt(n) - n2;
            chunkCoordinates._c += this._b.rand.nextInt(n) - n2;
            chunkCoordinates._b = this._b.getTopSolidOrLiquidBlock(chunkCoordinates._a, chunkCoordinates._c);
        }
        return chunkCoordinates;
    }

    public boolean _a(String string, double d, double d2, double d3) {
        return this._i < 0;
    }

    public int _a(EntityPlayerMP entityPlayerMP) {
        return 0;
    }

    public BiomeGenBase _c(int n, int n2) {
        return this._b.getBiomeGenForCoordsBody(n, n2);
    }

    public boolean _t() {
        return this._b.skylightSubtracted < 4;
    }

    @SideOnly(value=Side.CLIENT)
    public Vec3 _a(Entity entity, float f) {
        return this._b.getSkyColorBody(entity, f);
    }

    @SideOnly(value=Side.CLIENT)
    public Vec3 _a(float f) {
        return this._b.drawCloudsBody(f);
    }

    @SideOnly(value=Side.CLIENT)
    public float _b(float f) {
        return this._b.getStarBrightnessBody(f);
    }

    public void _a(boolean bl, boolean bl2) {
        this._b.spawnHostileMobs = bl;
        this._b.spawnPeacefulMobs = bl2;
    }

    public void _u() {
        this._b.calculateInitialWeatherBody();
    }

    public void _v() {
        this._b.updateWeatherBody();
    }

    public void _w() {
        this._b.worldInfo._f(1);
    }

    public boolean _a(int n, int n2, int n3, boolean bl) {
        return this._b.canBlockFreezeBody(n, n2, n3, bl);
    }

    public boolean _a(int n, int n2, int n3) {
        return this._b.canSnowAtBody(n, n2, n3);
    }

    public void _b(long l) {
        this._b.worldInfo._b(l);
    }

    public long _x() {
        return this._b.worldInfo._b();
    }

    public long _y() {
        return this._b.worldInfo._g();
    }

    public ChunkCoordinates _z() {
        WorldInfo worldInfo = this._b.worldInfo;
        return new ChunkCoordinates(worldInfo._c(), worldInfo._d(), worldInfo._e());
    }

    public void _b(int n, int n2, int n3) {
        this._b.worldInfo._a(n, n2, n3);
    }

    public boolean _a(EntityPlayer entityPlayer, int n, int n2, int n3) {
        return this._b.canMineBlockBody(entityPlayer, n, n2, n3);
    }

    public boolean _c(int n, int n2, int n3) {
        return this._b.getBiomeGenForCoords(n, n3)._f();
    }

    public int _A() {
        return 256;
    }

    public int _B() {
        return this._g ? 128 : 256;
    }

    public double _C() {
        return this._b.worldInfo._u()._c(this._b);
    }

    public void _D() {
        this._b.worldInfo._f(0);
        this._b.worldInfo._b(false);
        this._b.worldInfo._e(0);
        this._b.worldInfo._a(false);
    }

    public boolean _a(Chunk chunk) {
        return true;
    }

    public boolean _b(Chunk chunk) {
        return true;
    }
}

