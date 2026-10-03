/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mcoptifine.ChunkVboRenderer;
import mcoptifine.CompactArrayList;
import mcoptifine.Config;
import mcoptifine.CustomColorizer;
import mcoptifine.RandomMobs;
import mcoptifine.Reflector;
import mcoptifine.WrUpdates;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.client.particle.EntityCloudFX;
import net.minecraft.client.particle.EntityCritFX;
import net.minecraft.client.particle.EntityDiggingFX;
import net.minecraft.client.particle.EntityDropParticleFX;
import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFireworkSparkFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntityFootStepFX;
import net.minecraft.client.particle.EntityHeartFX;
import net.minecraft.client.particle.EntityHugeExplodeFX;
import net.minecraft.client.particle.EntityLargeExplodeFX;
import net.minecraft.client.particle.EntityLavaFX;
import net.minecraft.client.particle.EntityNoteFX;
import net.minecraft.client.particle.EntityPortalFX;
import net.minecraft.client.particle.EntityReddustFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.particle.EntitySnowShovelFX;
import net.minecraft.client.particle.EntitySpellParticleFX;
import net.minecraft.client.particle.EntitySplashFX;
import net.minecraft.client.particle.EntitySuspendFX;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.util.turb;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;

public class cvgz
implements IWorldAccess {
    public static final ResourceLocation _a = new ResourceLocation("textures/environment/moon_phases.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/environment/sun.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/environment/clouds.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/environment/end_sky.png");
    public List _e = new ArrayList();
    public pkix _f;
    public final TextureManager _g;
    public CompactArrayList _h = new CompactArrayList(100, 0.8f);
    public WorldRenderer[] _i;
    public WorldRenderer[] _j;
    public List<WorldRenderer> _k = new ArrayList<WorldRenderer>();
    public List<WorldRenderer> _l = new ArrayList<WorldRenderer>();
    public List<WorldRenderer> _m = new ArrayList<WorldRenderer>();
    public int _n;
    public int _o;
    public int _p;
    public int _q;
    public Minecraft _r;
    public RenderBlocks _s;
    public IntBuffer _t;
    public boolean _u;
    public int _v;
    public int _w;
    public int _x;
    public int _y;
    public int _z;
    public int _A;
    public int _B;
    public int _C;
    public int _D;
    public int _E;
    public int _F;
    public int _G;
    public int _H;
    public Map _I = new HashMap();
    public Icon[] _J;
    public int _K = -1;
    public int _L = 2;
    public int _M;
    public int _N;
    public int _O;
    public IntBuffer _P = pklh._d(64);
    public int _Q;
    public int _R;
    public int _S;
    public int _T;
    public int _U;
    public int _V;
    public int _W;
    public IntBuffer _X = BufferUtils.createIntBuffer(65536);
    public double _Y = -9999.0;
    public double _Z = -9999.0;
    public double __aa = -9999.0;
    public int __ab;
    public double __ac;
    public double __ad;
    public double __ae;
    public Entity __af;
    public long __ag = System.currentTimeMillis();
    public long __ah = System.currentTimeMillis();
    public static AxisAlignedBB __ai = AxisAlignedBB._a(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    public Chunk[] __aj = new Chunk[4];

    public cvgz(Minecraft minecraft) {
        int n;
        int n2;
        this._r = minecraft;
        this._g = minecraft._R();
        int n3 = 65;
        int n4 = 16;
        this._q = pklh._a(n3 * n3 * n4 * 3);
        this._u = yeex._a();
        if (this._u) {
            this._P.clear();
            this._t = pklh._d(n3 * n3 * n4);
            this._t.clear();
            this._t.position(0);
            this._t.limit(n3 * n3 * n4);
            ARBOcclusionQuery.glGenQueriesARB(this._t);
        }
        this._w = pklh._a(3);
        GL11.glPushMatrix();
        GL11.glNewList(this._w, 4864);
        this._a();
        GL11.glEndList();
        GL11.glPopMatrix();
        Tessellator tessellator = Tessellator.instance;
        this._x = this._w + 1;
        GL11.glNewList(this._x, 4864);
        int n5 = 64;
        int n6 = 256 / n5 + 2;
        float f = 16.0f;
        for (n2 = -n5 * n6; n2 <= n5 * n6; n2 += n5) {
            for (n = -n5 * n6; n <= n5 * n6; n += n5) {
                tessellator.startDrawingQuads();
                tessellator.addVertex(n2 + 0, f, n + 0);
                tessellator.addVertex(n2 + n5, f, n + 0);
                tessellator.addVertex(n2 + n5, f, n + n5);
                tessellator.addVertex(n2 + 0, f, n + n5);
                tessellator.draw();
            }
        }
        GL11.glEndList();
        this._y = this._w + 2;
        GL11.glNewList(this._y, 4864);
        f = -16.0f;
        tessellator.startDrawingQuads();
        for (n2 = -n5 * n6; n2 <= n5 * n6; n2 += n5) {
            for (n = -n5 * n6; n <= n5 * n6; n += n5) {
                tessellator.addVertex(n2 + n5, f, n + 0);
                tessellator.addVertex(n2 + 0, f, n + 0);
                tessellator.addVertex(n2 + 0, f, n + n5);
                tessellator.addVertex(n2 + n5, f, n + n5);
            }
        }
        tessellator.draw();
        GL11.glEndList();
    }

    public void _a() {
        Random random = new Random(10842L);
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        for (int i = 0; i < 1500; ++i) {
            double d = random.nextFloat() * 2.0f - 1.0f;
            double d2 = random.nextFloat() * 2.0f - 1.0f;
            double d3 = random.nextFloat() * 2.0f - 1.0f;
            double d4 = 0.15f + random.nextFloat() * 0.1f;
            double d5 = d * d + d2 * d2 + d3 * d3;
            if (!(d5 < 1.0) || !(d5 > 0.01)) continue;
            d5 = 1.0 / Math.sqrt(d5);
            double d6 = (d *= d5) * 100.0;
            double d7 = (d2 *= d5) * 100.0;
            double d8 = (d3 *= d5) * 100.0;
            double d9 = Math.atan2(d, d3);
            double d10 = Math.sin(d9);
            double d11 = Math.cos(d9);
            double d12 = Math.atan2(Math.sqrt(d * d + d3 * d3), d2);
            double d13 = Math.sin(d12);
            double d14 = Math.cos(d12);
            double d15 = random.nextDouble() * Math.PI * 2.0;
            double d16 = Math.sin(d15);
            double d17 = Math.cos(d15);
            for (int j = 0; j < 4; ++j) {
                double d18 = 0.0;
                double d19 = (double)((j & 2) - 1) * d4;
                double d20 = (double)((j + 1 & 2) - 1) * d4;
                double d21 = d19 * d17 - d20 * d16;
                double d22 = d20 * d17 + d19 * d16;
                double d23 = d21 * d13 + d18 * d14;
                double d24 = d18 * d13 - d21 * d14;
                double d25 = d24 * d10 - d22 * d11;
                double d26 = d22 * d10 + d24 * d11;
                tessellator.addVertex(d6 + d25, d7 + d23, d8 + d26);
            }
        }
        tessellator.draw();
    }

    public void _a(pkix pkix2) {
        if (this._f != null) {
            this._f.removeWorldAccess(this);
        }
        this._Y = -9999.0;
        this._Z = -9999.0;
        this.__aa = -9999.0;
        RenderManager._b._a(pkix2);
        this._f = pkix2;
        this._s = new RenderBlocks(pkix2);
        if (pkix2 != null) {
            pkix2.addWorldAccess(this);
            this._b();
        }
    }

    public void _b() {
        if (this._f != null) {
            int n;
            int n2;
            Block.leaves._a(Config.isTreesFancy());
            this._K = this._r._M.renderDistance;
            if (this._j != null) {
                for (n2 = 0; n2 < this._j.length; ++n2) {
                    this._j[n2].stopRendering();
                }
            }
            n2 = 64 << 3 - this._K;
            int n3 = 512;
            n2 = 2 * this._r._M.ofRenderDistanceFine;
            if (Config.isLoadChunksFar() && n2 < n3) {
                n2 = n3;
            }
            n2 += Config.getPreloadedChunks() * 2 * 16;
            int n4 = 400;
            if (this._r._M.ofRenderDistanceFine > 256) {
                n4 = 1024;
            }
            if (n2 > n4) {
                n2 = n4;
            }
            this.__ac = -9999.0;
            this.__ad = -9999.0;
            this.__ae = -9999.0;
            this._n = n2 / 16 + 1;
            this._o = 16;
            this._p = n2 / 16 + 1;
            this._j = new WorldRenderer[this._n * this._o * this._p];
            this._i = new WorldRenderer[this._n * this._o * this._p];
            int n5 = 0;
            int n6 = 0;
            this._z = 0;
            this._A = 0;
            this._B = 0;
            this._H = 0;
            this._G = 0;
            this._F = 0;
            this._C = this._n;
            this._D = this._o;
            this._E = this._p;
            for (n = 0; n < this._h.size(); ++n) {
                WorldRenderer worldRenderer = (WorldRenderer)this._h.get(n);
                if (worldRenderer == null) continue;
                worldRenderer.needsUpdate = false;
            }
            this._h.clear();
            this._e.clear();
            this._k.clear();
            for (n = 0; n < this._n; ++n) {
                for (int i = 0; i < this._o; ++i) {
                    for (int j = 0; j < this._p; ++j) {
                        int n7 = (j * this._o + i) * this._n + n;
                        this._j[n7] = WrUpdates.makeWorldRenderer(this._f, this._e, n * 16, i * 16, j * 16, this._q + n5);
                        if (this._u) {
                            this._j[n7].glOcclusionQuery = this._t.get(n6);
                        }
                        this._j[n7].isWaitingOnOcclusionQuery = false;
                        this._j[n7].isVisible = true;
                        this._j[n7].isInFrustum = false;
                        this._j[n7].chunkIndex = n6++;
                        this._i[n7] = this._j[n7];
                        if (this._f.chunkExists(n, j)) {
                            this._j[n7].markDirty();
                            this._h.add(this._j[n7]);
                        }
                        n5 += 3;
                    }
                }
            }
            if (this._f != null) {
                EntityLivingBase entityLivingBase = this._r._u;
                if (entityLivingBase == null) {
                    entityLivingBase = this._r._t;
                }
                if (entityLivingBase != null) {
                    this._a(sajh._c(((Entity)entityLivingBase).posX), sajh._c(((Entity)entityLivingBase).posY), sajh._c(((Entity)entityLivingBase).posZ));
                    Arrays.sort(this._i, new yvgb(entityLivingBase));
                }
            }
            this._L = 2;
        }
    }

    public void _a(Vec3 vec3, lpai lpai2, float f) {
        int n = MinecraftForgeClient.getRenderPass();
        if (this._L > 0) {
            if (n > 0) {
                fmej._a(this, vec3, lpai2, f);
                return;
            }
            --this._L;
        } else {
            Entity entity;
            int n2;
            Object object;
            this._f.theProfiler._a("prepare");
            TileEntityRenderer._b._a(this._f, this._r._R(), this._r._z, this._r._u, f);
            RenderManager._b._a(this._f, this._r._R(), this._r._z, this._r._u, this._r._v, this._r._M, f);
            if (n == 0) {
                this._M = 0;
                this._N = 0;
                this._O = 0;
                object = this._r._u;
                RenderManager._d = ((Entity)object).lastTickPosX + (((Entity)object).posX - ((Entity)object).lastTickPosX) * (double)f;
                RenderManager._e = ((Entity)object).lastTickPosY + (((Entity)object).posY - ((Entity)object).lastTickPosY) * (double)f;
                RenderManager._f = ((Entity)object).lastTickPosZ + (((Entity)object).posZ - ((Entity)object).lastTickPosZ) * (double)f;
                TileEntityRenderer._d = ((Entity)object).lastTickPosX + (((Entity)object).posX - ((Entity)object).lastTickPosX) * (double)f;
                TileEntityRenderer._e = ((Entity)object).lastTickPosY + (((Entity)object).posY - ((Entity)object).lastTickPosY) * (double)f;
                TileEntityRenderer._f = ((Entity)object).lastTickPosZ + (((Entity)object).posZ - ((Entity)object).lastTickPosZ) * (double)f;
            }
            this._r._D.enableLightmap(f);
            this._f.theProfiler._c("global");
            object = this._f.getLoadedEntityList();
            if (n == 0) {
                this._M = object.size();
            }
            if (Config.isFogOff() && this._r._D.fogStandard) {
                GL11.glDisable(2912);
            }
            for (n2 = 0; n2 < this._f.weatherEffects.size(); ++n2) {
                entity = (Entity)this._f.weatherEffects.get(n2);
                if (!entity.shouldRenderInPass(n)) continue;
                ++this._N;
                if (!entity.isInRangeToRenderVec3D(vec3)) continue;
                RenderManager._b._a(entity, f);
            }
            this._f.theProfiler._c("entities");
            n2 = this._r._M.fancyGraphics ? 1 : 0;
            this._r._M.fancyGraphics = Config.isDroppedItemsFancy();
            for (int i = 0; i < object.size(); ++i) {
                boolean bl;
                EntityLiving entityLiving;
                boolean bl2;
                entity = (Entity)object.get(i);
                if (!entity.shouldRenderInPass(n)) continue;
                boolean bl3 = bl2 = entity.isInRangeToRenderVec3D(vec3) && this._a(entity) && (entity.ignoreFrustumCheck || lpai2._a(entity.boundingBox) || entity.riddenByEntity == this._r._t);
                if (!bl2 && entity instanceof EntityLiving && (entityLiving = (EntityLiving)entity).getLeashed() && entityLiving.getLeashedToEntity() != null) {
                    Entity entity2 = entityLiving.getLeashedToEntity();
                    bl2 = lpai2._a(entity2.boundingBox);
                }
                boolean bl4 = bl = entity != this._r._u || this._r._M.thirdPersonView != 0 || this._r._u.isPlayerSleeping();
                if (!bl2 || !bl || !this._f.blockExists(sajh._c(entity.posX), 0, sajh._c(entity.posZ))) continue;
                ++this._N;
                if (entity.getClass() == EntityItemFrame.class) {
                    entity.renderDistanceWeight = 0.06;
                }
                this.__af = entity;
                RenderManager._b._a(entity, f);
                this.__af = null;
            }
            this._r._M.fancyGraphics = n2;
            this._f.theProfiler._c("tileentities");
            qnon._b();
            double d = TileEntityRenderer._b._l;
            double d2 = TileEntityRenderer._b._m;
            double d3 = TileEntityRenderer._b._n;
            for (int i = 0; i < this._e.size(); ++i) {
                int n3;
                Block block;
                AxisAlignedBB axisAlignedBB;
                TileEntity tileEntity = (TileEntity)this._e.get(i);
                if (!tileEntity.shouldRenderInPass(n) || !(tileEntity.getDistanceFrom(d, d2, d3) < tileEntity.getMaxRenderDistanceSquared()) || !this._a(tileEntity.xCoord >> 4, tileEntity.yCoord >> 4, tileEntity.zCoord >> 4, false, true) || !lpai2._a(axisAlignedBB = this._a(tileEntity))) continue;
                Class<?> clazz = tileEntity.getClass();
                if (clazz == TileEntitySign.class && !Config.zoomMode) {
                    EntityClientPlayerMP entityClientPlayerMP = this._r._t;
                    double d4 = tileEntity.getDistanceFrom(entityClientPlayerMP.posX, entityClientPlayerMP.posY, entityClientPlayerMP.posZ);
                    if (d4 > 256.0) {
                        FontRenderer fontRenderer = TileEntityRenderer._b._a();
                        fontRenderer._y = false;
                        TileEntityRenderer._b._a(tileEntity, f);
                        fontRenderer._y = true;
                        continue;
                    }
                }
                if (clazz == TileEntityChest.class && !((block = Block.blocksList[n3 = this._f.getBlockId(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord)]) instanceof BlockChest)) continue;
                TileEntityRenderer._b._a(tileEntity, f);
            }
            this._r._D.disableLightmap(f);
            this._f.theProfiler._b();
        }
        fmej._a(this, vec3, lpai2, f);
    }

    public boolean _a(Entity entity) {
        return this._a(entity.chunkCoordX, sajh._c(entity.posY / 16.0), entity.chunkCoordZ, true, true);
    }

    public boolean _a(int n, int n2, int n3, boolean bl, boolean bl2) {
        if (n < this._F || n >= this._F + this._n || n3 < this._H || n3 >= this._H + this._p) {
            return false;
        }
        int n4 = n - this._F;
        int n5 = n2 - this._G;
        int n6 = n3 - this._H;
        n4 += this._F % this._n;
        n6 += this._H % this._p;
        n4 = Math.floorMod(n4, this._n);
        int n7 = ((n6 = Math.floorMod(n6, this._p)) * this._o + n5) * this._n + n4;
        if (n7 < 0 || n7 >= this._j.length) {
            return false;
        }
        WorldRenderer worldRenderer = this._j[n7];
        if (!worldRenderer.isInitialized) {
            return false;
        }
        if (!worldRenderer.skipAllRenderPasses) {
            if (bl && !worldRenderer.isInFrustum) {
                return false;
            }
            if (bl2 && this._u && !worldRenderer.isVisible) {
                return false;
            }
        }
        return true;
    }

    public String _c() {
        return "C: " + this._T + "/" + this._Q + ". F: " + this._R + ", O: " + this._S + ", E: " + this._U;
    }

    public String _d() {
        return "E: " + this._N + "/" + this._M + ". B: " + this._O + ", I: " + (this._M - this._O - this._N) + ", " + Config.getVersion();
    }

    public void _a(int n, int n2, int n3) {
        n -= 8;
        n2 -= 8;
        n3 -= 8;
        this._z = Integer.MAX_VALUE;
        this._A = Integer.MAX_VALUE;
        this._B = Integer.MAX_VALUE;
        this._C = Integer.MIN_VALUE;
        this._D = Integer.MIN_VALUE;
        this._E = Integer.MIN_VALUE;
        int n4 = this._n * 16;
        int n5 = n4 / 2;
        for (int i = 0; i < this._n; ++i) {
            int n6 = i * 16;
            int n7 = n6 + n5 - n;
            if (n7 < 0) {
                n7 -= n4 - 1;
            }
            if ((n6 -= (n7 /= n4) * n4) < this._z) {
                this._z = n6;
                this._F = sajh._c((double)this._z / 16.0);
            }
            if (n6 > this._C) {
                this._C = n6;
            }
            for (int j = 0; j < this._p; ++j) {
                int n8 = j * 16;
                int n9 = n8 + n5 - n3;
                if (n9 < 0) {
                    n9 -= n4 - 1;
                }
                if ((n8 -= (n9 /= n4) * n4) < this._B) {
                    this._B = n8;
                    this._H = sajh._c((double)this._B / 16.0);
                }
                if (n8 > this._E) {
                    this._E = n8;
                }
                for (int k = 0; k < this._o; ++k) {
                    int n10 = k * 16;
                    if (n10 < this._A) {
                        this._A = n10;
                        this._G = sajh._c((double)this._A / 16.0);
                    }
                    if (n10 > this._D) {
                        this._D = n10;
                    }
                    WorldRenderer worldRenderer = this._j[(j * this._o + k) * this._n + i];
                    boolean bl = worldRenderer.needsUpdate;
                    worldRenderer.setPosition(n6, n10, n8);
                    if (bl || !worldRenderer.needsUpdate) continue;
                    this._h.add(worldRenderer);
                }
            }
        }
    }

    public int _a(EntityLivingBase entityLivingBase, int n, double d) {
        int n2;
        GloomyHooks.sortAndRender(this, entityLivingBase, n, d);
        fokl fokl2 = this._f.theProfiler;
        fokl2._a("sortchunks");
        if (this._h.size() < 10) {
            int n3 = 10;
            for (int i = 0; i < n3; ++i) {
                this._W = (this._W + 1) % this._j.length;
                WorldRenderer worldRenderer = this._j[this._W];
                if (!worldRenderer.needsUpdate || this._h.contains(worldRenderer)) continue;
                this._h.add(worldRenderer);
            }
        }
        if (this._r._M.renderDistance != this._K && !Config.isLoadChunksFar()) {
            this._b();
        }
        if (n == 0) {
            this._Q = 0;
            this._V = 0;
            this._R = 0;
            this._S = 0;
            this._T = 0;
            this._U = 0;
        }
        double d2 = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * d;
        double d3 = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * d;
        double d4 = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * d;
        double d5 = entityLivingBase.posX - this._Y;
        double d6 = entityLivingBase.posY - this._Z;
        double d7 = entityLivingBase.posZ - this.__aa;
        double d8 = d5 * d5 + d6 * d6 + d7 * d7;
        if (d8 > 16.0) {
            this._Y = entityLivingBase.posX;
            this._Z = entityLivingBase.posY;
            this.__aa = entityLivingBase.posZ;
            double d9 = entityLivingBase.posX - this.__ac;
            double d10 = entityLivingBase.posY - this.__ad;
            double d11 = entityLivingBase.posZ - this.__ae;
            double d12 = d9 * d9 + d10 * d10 + d11 * d11;
            n2 = Config.getPreloadedChunks() * 16;
            if (d12 > (double)(n2 * n2) + 16.0) {
                this.__ac = entityLivingBase.posX;
                this.__ad = entityLivingBase.posY;
                this.__ae = entityLivingBase.posZ;
                this._a(sajh._c(entityLivingBase.posX), sajh._c(entityLivingBase.posY), sajh._c(entityLivingBase.posZ));
            }
            this._k.sort(new yvgb(entityLivingBase));
        }
        qnon._a();
        WrUpdates.preRender(this, entityLivingBase);
        int n4 = 0;
        int n5 = 0;
        if (this._u && this._r._M.advancedOpengl && !this._r._M.anaglyph && n == 0) {
            int n6;
            int n7 = 0;
            int n8 = Math.min(20, this._k.size());
            this._a(n7, n8, entityLivingBase.posX, entityLivingBase.posY, entityLivingBase.posZ);
            for (n6 = n7; n6 < n8; ++n6) {
                this._k.get((int)n6).isVisible = true;
            }
            fokl2._c("render");
            n2 = n4 + this._a(n7, n8, n, d);
            n6 = n8;
            int n9 = 0;
            int n10 = 10;
            int n11 = this._n;
            while (n6 < this._k.size()) {
                fokl2._c("occ");
                int n12 = n6;
                n9 = n9 < n11 ? ++n9 : --n9;
                if ((n6 += n9 * n10) <= n12) {
                    n6 = n12 + 10;
                }
                if (n6 > this._k.size()) {
                    n6 = this._k.size();
                }
                GL11.glDisable(3553);
                GL11.glDisable(2896);
                GL11.glDisable(3008);
                GL11.glColorMask(false, false, false, false);
                GL11.glDepthMask(false);
                fokl2._a("check");
                this._a(n12, n6, entityLivingBase.posX, entityLivingBase.posY, entityLivingBase.posZ);
                fokl2._b();
                GL11.glPushMatrix();
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                for (int i = n12; i < n6; ++i) {
                    float f4;
                    float f5;
                    float f6;
                    float f7;
                    WorldRenderer worldRenderer = this._k.get(i);
                    if (worldRenderer.skipAllRenderPasses()) {
                        worldRenderer.isInFrustum = false;
                        continue;
                    }
                    if (worldRenderer.isUpdating) {
                        worldRenderer.isVisible = true;
                        continue;
                    }
                    if (!worldRenderer.isInFrustum) continue;
                    if (Config.isOcclusionFancy() && !worldRenderer.isInFrustrumFully) {
                        worldRenderer.isVisible = true;
                        continue;
                    }
                    if (!worldRenderer.isInFrustum || worldRenderer.isWaitingOnOcclusionQuery) continue;
                    if (worldRenderer.isVisibleFromPosition) {
                        f7 = Math.abs((float)(worldRenderer.visibleFromX - entityLivingBase.posX));
                        f4 = f7 + (f6 = Math.abs((float)(worldRenderer.visibleFromY - entityLivingBase.posY))) + (f5 = Math.abs((float)(worldRenderer.visibleFromZ - entityLivingBase.posZ)));
                        if ((double)f4 < 10.0 + (double)i / 1000.0) {
                            worldRenderer.isVisible = true;
                            continue;
                        }
                        worldRenderer.isVisibleFromPosition = false;
                    }
                    f7 = (float)((double)worldRenderer.posXMinus - d2);
                    f6 = (float)((double)worldRenderer.posYMinus - d3);
                    f5 = (float)((double)worldRenderer.posZMinus - d4);
                    f4 = f7 - f;
                    float f8 = f6 - f2;
                    float f9 = f5 - f3;
                    if (f4 != 0.0f || f8 != 0.0f || f9 != 0.0f) {
                        GL11.glTranslatef(f4, f8, f9);
                        f += f4;
                        f2 += f8;
                        f3 += f9;
                    }
                    fokl2._a("bb");
                    ARBOcclusionQuery.glBeginQueryARB(35092, worldRenderer.glOcclusionQuery);
                    EntityRenderer.disableTerrainShader();
                    worldRenderer.drawOcclusionQueryAABB();
                    EntityRenderer.enableTerrainShader(n);
                    ARBOcclusionQuery.glEndQueryARB(35092);
                    fokl2._b();
                    worldRenderer.isWaitingOnOcclusionQuery = true;
                    ++n5;
                }
                GL11.glPopMatrix();
                if (this._r._M.anaglyph) {
                    if (EntityRenderer.anaglyphField == 0) {
                        GL11.glColorMask(false, true, true, true);
                    } else {
                        GL11.glColorMask(true, false, false, true);
                    }
                } else {
                    GL11.glColorMask(true, true, true, true);
                }
                GL11.glDepthMask(true);
                GL11.glEnable(3553);
                GL11.glEnable(3008);
                fokl2._c("render");
                n2 += this._a(n12, n6, n, d);
            }
        } else {
            fokl2._c("render");
            n2 = n4 + this._a(0, this._k.size(), n, d);
        }
        if (n == 0) {
            // empty if block
        }
        fokl2._b();
        WrUpdates.postRender();
        this._k.removeAll(this._m);
        this._m.clear();
        if (!this._l.isEmpty()) {
            this._k.addAll(this._l);
            this._l.clear();
            this._k.sort(new yvgb(this._r._u));
        }
        return n2;
    }

    public void _a(int n, int n2, double d, double d2, double d3) {
        for (int i = n; i < n2 && i < this._k.size(); ++i) {
            WorldRenderer worldRenderer = this._k.get(i);
            if (!worldRenderer.isWaitingOnOcclusionQuery) continue;
            this._P.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(worldRenderer.glOcclusionQuery, 34919, this._P);
            if (this._P.get(0) == 0) continue;
            worldRenderer.isWaitingOnOcclusionQuery = false;
            this._P.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(worldRenderer.glOcclusionQuery, 34918, this._P);
            boolean bl = worldRenderer.isVisible;
            boolean bl2 = worldRenderer.isVisible = this._P.get(0) > 0;
            if (!bl || !worldRenderer.isVisible) continue;
            worldRenderer.isVisibleFromPosition = true;
            worldRenderer.visibleFromX = d;
            worldRenderer.visibleFromY = d2;
            worldRenderer.visibleFromZ = d3;
        }
    }

    public int _a(int n, int n2, int n3, double d) {
        if (n3 == 0) {
            GL11.glAlphaFunc(516, 0.4f);
        } else {
            GL11.glAlphaFunc(516, 0.01f);
        }
        int n4 = 0;
        boolean bl = this._r._M.showDebugInfo;
        if (Config.isFogOff() && this._r._D.fogStandard) {
            GL11.glDisable(2912);
        }
        EntityLivingBase entityLivingBase = this._r._u;
        double d2 = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * d;
        double d3 = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * d;
        double d4 = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * d;
        this._r._D.enableLightmap(d);
        for (int i = n; i < n2; ++i) {
            WorldRenderer worldRenderer = this._k.get(i);
            if (bl && n3 == 0) {
                ++this._Q;
                if (worldRenderer.skipRenderPass[n3]) {
                    ++this._U;
                } else if (!worldRenderer.isInFrustum) {
                    ++this._R;
                } else if (this._u && !worldRenderer.isVisible) {
                    ++this._S;
                } else {
                    ++this._T;
                }
            }
            if (!worldRenderer.isInFrustum || worldRenderer.skipRenderPass[n3] || this._u && !worldRenderer.isVisible) continue;
            double d5 = d2 - (double)worldRenderer.posX;
            double d6 = d3 - (double)worldRenderer.posY;
            double d7 = d4 - (double)worldRenderer.posZ;
            if (EntityRenderer.useShader) {
                GL20.glUniform3f(EntityRenderer.chunkPosLoc, (float)d5, (float)d6, (float)d7);
            } else {
                GL11.glPushMatrix();
                GL11.glTranslated(-d5, -d6, -d7);
            }
            worldRenderer.callForRenderPass(n3);
            if (!EntityRenderer.useShader) {
                GL11.glPopMatrix();
            }
            ++n4;
        }
        if (n4 > 0) {
            ChunkVboRenderer.disableVertexAttribsDirectly();
            GL15.glBindBuffer(34962, 0);
        }
        this._r._D.disableLightmap(d);
        GL11.glAlphaFunc(516, 0.1f);
        return n4;
    }

    public void _a(int n, double d) {
    }

    public void _e() {
        ++this._v;
        if (this._v % 20 == 0) {
            Iterator iterator2 = this._I.values().iterator();
            while (iterator2.hasNext()) {
                yeay yeay2 = (yeay)iterator2.next();
                int n = yeay2._e();
                if (this._v - n <= 400) continue;
                iterator2.remove();
            }
        }
    }

    public void _a(float f) {
        GloomyHooks.renderSky(this, f);
    }

    public void _b(float f) {
        if (!Config.isCloudsOff()) {
            WorldProvider worldProvider;
            Object object;
            if (Reflector.ForgeWorldProvider_getCloudRenderer.exists() && (object = Reflector.call(worldProvider = this._r._r.provider, Reflector.ForgeWorldProvider_getCloudRenderer, new Object[0])) != null) {
                Reflector.callVoid(object, Reflector.IRenderHandler_render, Float.valueOf(f), this._f, this._r);
                return;
            }
            if (this._r._r.provider._d()) {
                if (Config.isCloudsFancy()) {
                    this._c(f);
                } else {
                    float f2;
                    GL11.glDisable(2884);
                    float f3 = (float)(this._r._u.lastTickPosY + (this._r._u.posY - this._r._u.lastTickPosY) * (double)f);
                    int n = 32;
                    int n2 = 256 / n;
                    Tessellator tessellator = Tessellator.instance;
                    this._g._a(_c);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    Vec3 vec3 = this._f.getCloudColour(f);
                    float f4 = (float)vec3._c;
                    float f5 = (float)vec3._d;
                    float f6 = (float)vec3._e;
                    if (this._r._M.anaglyph) {
                        f2 = (f4 * 30.0f + f5 * 59.0f + f6 * 11.0f) / 100.0f;
                        float f7 = (f4 * 30.0f + f5 * 70.0f) / 100.0f;
                        float f8 = (f4 * 30.0f + f6 * 70.0f) / 100.0f;
                        f4 = f2;
                        f5 = f7;
                        f6 = f8;
                    }
                    f2 = 4.8828125E-4f;
                    double d = (float)this._v + f;
                    double d2 = this._r._u.prevPosX + (this._r._u.posX - this._r._u.prevPosX) * (double)f + d * (double)0.03f;
                    double d3 = this._r._u.prevPosZ + (this._r._u.posZ - this._r._u.prevPosZ) * (double)f;
                    int n3 = sajh._c(d2 / 2048.0);
                    int n4 = sajh._c(d3 / 2048.0);
                    float f9 = this._f.provider._f() - f3 + 0.33f;
                    f9 += this._r._M.ofCloudsHeight * 128.0f;
                    float f10 = (float)((d2 -= (double)(n3 * 2048)) * (double)f2);
                    float f11 = (float)((d3 -= (double)(n4 * 2048)) * (double)f2);
                    tessellator.startDrawingQuads();
                    tessellator.setColorRGBA_F(f4, f5, f6, 0.8f);
                    for (int i = -n * n2; i < n * n2; i += n) {
                        for (int j = -n * n2; j < n * n2; j += n) {
                            tessellator.addVertexWithUV(i + 0, f9, j + n, (float)(i + 0) * f2 + f10, (float)(j + n) * f2 + f11);
                            tessellator.addVertexWithUV(i + n, f9, j + n, (float)(i + n) * f2 + f10, (float)(j + n) * f2 + f11);
                            tessellator.addVertexWithUV(i + n, f9, j + 0, (float)(i + n) * f2 + f10, (float)(j + 0) * f2 + f11);
                            tessellator.addVertexWithUV(i + 0, f9, j + 0, (float)(i + 0) * f2 + f10, (float)(j + 0) * f2 + f11);
                        }
                    }
                    tessellator.draw();
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    GL11.glDisable(3042);
                    GL11.glEnable(2884);
                }
            }
        }
    }

    public boolean _a(double d, double d2, double d3, float f) {
        return false;
    }

    public void _c(float f) {
        float f2;
        float f3;
        float f4;
        GL11.glDisable(2884);
        float f5 = (float)(this._r._u.lastTickPosY + (this._r._u.posY - this._r._u.lastTickPosY) * (double)f);
        Tessellator tessellator = Tessellator.instance;
        float f6 = 12.0f;
        float f7 = 4.0f;
        double d = (float)this._v + f;
        double d2 = (this._r._u.prevPosX + (this._r._u.posX - this._r._u.prevPosX) * (double)f + d * (double)0.03f) / (double)f6;
        double d3 = (this._r._u.prevPosZ + (this._r._u.posZ - this._r._u.prevPosZ) * (double)f) / (double)f6 + (double)0.33f;
        float f8 = this._f.provider._f() - f5 + 0.33f;
        f8 += this._r._M.ofCloudsHeight * 128.0f;
        int n = sajh._c(d2 / 2048.0);
        int n2 = sajh._c(d3 / 2048.0);
        d2 -= (double)(n * 2048);
        d3 -= (double)(n2 * 2048);
        this._g._a(_c);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        Vec3 vec3 = this._f.getCloudColour(f);
        float f9 = (float)vec3._c;
        float f10 = (float)vec3._d;
        float f11 = (float)vec3._e;
        if (this._r._M.anaglyph) {
            f4 = (f9 * 30.0f + f10 * 59.0f + f11 * 11.0f) / 100.0f;
            f3 = (f9 * 30.0f + f10 * 70.0f) / 100.0f;
            f2 = (f9 * 30.0f + f11 * 70.0f) / 100.0f;
            f9 = f4;
            f10 = f3;
            f11 = f2;
        }
        f4 = (float)(d2 * 0.0);
        f3 = (float)(d3 * 0.0);
        f2 = 0.00390625f;
        f4 = (float)sajh._c(d2) * f2;
        f3 = (float)sajh._c(d3) * f2;
        float f12 = (float)(d2 - (double)sajh._c(d2));
        float f13 = (float)(d3 - (double)sajh._c(d3));
        int n3 = 8;
        int n4 = 4;
        float f14 = 9.765625E-4f;
        GL11.glScalef(f6, 1.0f, f6);
        for (int i = 0; i < 2; ++i) {
            if (i == 0) {
                GL11.glColorMask(false, false, false, false);
            } else if (this._r._M.anaglyph) {
                if (EntityRenderer.anaglyphField == 0) {
                    GL11.glColorMask(false, true, true, true);
                } else {
                    GL11.glColorMask(true, false, false, true);
                }
            } else {
                GL11.glColorMask(true, true, true, true);
            }
            for (int j = -n4 + 1; j <= n4; ++j) {
                for (int k = -n4 + 1; k <= n4; ++k) {
                    int n5;
                    tessellator.startDrawingQuads();
                    float f15 = j * n3;
                    float f16 = k * n3;
                    float f17 = f15 - f12;
                    float f18 = f16 - f13;
                    if (f8 > -f7 - 1.0f) {
                        tessellator.setColorRGBA_F(f9 * 0.7f, f10 * 0.7f, f11 * 0.7f, 0.8f);
                        tessellator.setNormal(0.0f, -1.0f, 0.0f);
                        tessellator.addVertexWithUV(f17 + 0.0f, f8 + 0.0f, f18 + (float)n3, (f15 + 0.0f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                        tessellator.addVertexWithUV(f17 + (float)n3, f8 + 0.0f, f18 + (float)n3, (f15 + (float)n3) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                        tessellator.addVertexWithUV(f17 + (float)n3, f8 + 0.0f, f18 + 0.0f, (f15 + (float)n3) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                        tessellator.addVertexWithUV(f17 + 0.0f, f8 + 0.0f, f18 + 0.0f, (f15 + 0.0f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                    }
                    if (f8 <= f7 + 1.0f) {
                        tessellator.setColorRGBA_F(f9, f10, f11, 0.8f);
                        tessellator.setNormal(0.0f, 1.0f, 0.0f);
                        tessellator.addVertexWithUV(f17 + 0.0f, f8 + f7 - f14, f18 + (float)n3, (f15 + 0.0f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                        tessellator.addVertexWithUV(f17 + (float)n3, f8 + f7 - f14, f18 + (float)n3, (f15 + (float)n3) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                        tessellator.addVertexWithUV(f17 + (float)n3, f8 + f7 - f14, f18 + 0.0f, (f15 + (float)n3) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                        tessellator.addVertexWithUV(f17 + 0.0f, f8 + f7 - f14, f18 + 0.0f, (f15 + 0.0f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                    }
                    tessellator.setColorRGBA_F(f9 * 0.9f, f10 * 0.9f, f11 * 0.9f, 0.8f);
                    if (j > -1) {
                        tessellator.setNormal(-1.0f, 0.0f, 0.0f);
                        for (n5 = 0; n5 < n3; ++n5) {
                            tessellator.addVertexWithUV(f17 + (float)n5 + 0.0f, f8 + 0.0f, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + (float)n5 + 0.0f, f8 + f7, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + (float)n5 + 0.0f, f8 + f7, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + (float)n5 + 0.0f, f8 + 0.0f, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                        }
                    }
                    if (j <= 1) {
                        tessellator.setNormal(1.0f, 0.0f, 0.0f);
                        for (n5 = 0; n5 < n3; ++n5) {
                            tessellator.addVertexWithUV(f17 + (float)n5 + 1.0f - f14, f8 + 0.0f, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + (float)n5 + 1.0f - f14, f8 + f7, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + (float)n5 + 1.0f - f14, f8 + f7, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + (float)n5 + 1.0f - f14, f8 + 0.0f, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                        }
                    }
                    tessellator.setColorRGBA_F(f9 * 0.8f, f10 * 0.8f, f11 * 0.8f, 0.8f);
                    if (k > -1) {
                        tessellator.setNormal(0.0f, 0.0f, -1.0f);
                        for (n5 = 0; n5 < n3; ++n5) {
                            tessellator.addVertexWithUV(f17 + 0.0f, f8 + f7, f18 + (float)n5 + 0.0f, (f15 + 0.0f) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + (float)n3, f8 + f7, f18 + (float)n5 + 0.0f, (f15 + (float)n3) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + (float)n3, f8 + 0.0f, f18 + (float)n5 + 0.0f, (f15 + (float)n3) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + 0.0f, f8 + 0.0f, f18 + (float)n5 + 0.0f, (f15 + 0.0f) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                        }
                    }
                    if (k <= 1) {
                        tessellator.setNormal(0.0f, 0.0f, 1.0f);
                        for (n5 = 0; n5 < n3; ++n5) {
                            tessellator.addVertexWithUV(f17 + 0.0f, f8 + f7, f18 + (float)n5 + 1.0f - f14, (f15 + 0.0f) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + (float)n3, f8 + f7, f18 + (float)n5 + 1.0f - f14, (f15 + (float)n3) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + (float)n3, f8 + 0.0f, f18 + (float)n5 + 1.0f - f14, (f15 + (float)n3) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            tessellator.addVertexWithUV(f17 + 0.0f, f8 + 0.0f, f18 + (float)n5 + 1.0f - f14, (f15 + 0.0f) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                        }
                    }
                    tessellator.draw();
                }
            }
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }

    public boolean _a(WorldRenderer worldRenderer) {
        boolean bl = true;
        this.__aj[0] = this._f.getChunkFromChunkCoords(worldRenderer.posX / 16, worldRenderer.posZ / 16 + 1);
        this.__aj[1] = this._f.getChunkFromChunkCoords(worldRenderer.posX / 16, worldRenderer.posZ / 16 - 1);
        this.__aj[2] = this._f.getChunkFromChunkCoords(worldRenderer.posX / 16 - 1, worldRenderer.posZ / 16);
        this.__aj[3] = this._f.getChunkFromChunkCoords(worldRenderer.posX / 16 + 1, worldRenderer.posZ / 16);
        for (int i = 0; i < 4; ++i) {
            Chunk chunk = this.__aj[i];
            if (chunk != null && chunk._f) continue;
            bl = false;
        }
        return bl;
    }

    public boolean _a(EntityLivingBase entityLivingBase, boolean bl) {
        GloomyHooks.updateRenderers(this, entityLivingBase, bl);
        if (WrUpdates.hasWrUpdater()) {
            return WrUpdates.updateRenderers(this, entityLivingBase, bl);
        }
        if (this._h.size() <= 0) {
            return false;
        }
        int n = 0;
        int n2 = Config.getUpdatesPerFrame();
        if (Config.isDynamicUpdates() && !this._a(entityLivingBase)) {
            n2 *= 3;
        }
        int n3 = 4;
        int n4 = 0;
        WorldRenderer worldRenderer = null;
        float f = Float.MAX_VALUE;
        int n5 = -1;
        for (int i = 0; i < this._h.size(); ++i) {
            WorldRenderer worldRenderer2 = (WorldRenderer)this._h.get(i);
            if (worldRenderer2 == null) continue;
            ++n4;
            if (!worldRenderer2.needsUpdate) {
                this._h.set(i, null);
                continue;
            }
            float f2 = worldRenderer2.distanceToEntitySquared(entityLivingBase);
            if (!this._a(worldRenderer2)) continue;
            if (f2 <= 256.0f && this._i()) {
                worldRenderer2.updateRenderer();
                worldRenderer2.needsUpdate = false;
                this._h.set(i, null);
                ++n;
                continue;
            }
            if (f2 > 256.0f && n >= n2) break;
            if (!worldRenderer2.isInFrustum) {
                f2 *= (float)n3;
            }
            if (worldRenderer == null) {
                worldRenderer = worldRenderer2;
                f = f2;
                n5 = i;
                continue;
            }
            if (!(f2 < f)) continue;
            worldRenderer = worldRenderer2;
            f = f2;
            n5 = i;
        }
        if (worldRenderer != null) {
            worldRenderer.updateRenderer();
            worldRenderer.needsUpdate = false;
            this._h.set(n5, null);
            ++n;
            float f3 = f / 5.0f;
            for (int i = 0; i < this._h.size() && n < n2; ++i) {
                float f4;
                WorldRenderer worldRenderer3 = (WorldRenderer)this._h.get(i);
                if (worldRenderer3 == null) continue;
                float f5 = worldRenderer3.distanceToEntitySquared(entityLivingBase);
                if (!worldRenderer3.isInFrustum) {
                    f5 *= (float)n3;
                }
                if (!((f4 = Math.abs(f5 - f)) < f3)) continue;
                worldRenderer3.updateRenderer();
                worldRenderer3.needsUpdate = false;
                this._h.set(i, null);
                ++n;
            }
        }
        if (n4 == 0) {
            this._h.clear();
        }
        this._h.compact();
        return true;
    }

    public void _a(Tessellator tessellator, EntityPlayer entityPlayer, float f) {
        this._a(tessellator, (EntityLivingBase)entityPlayer, f);
    }

    public void _a(Tessellator tessellator, EntityLivingBase entityLivingBase, float f) {
        double d = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * (double)f;
        double d2 = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * (double)f;
        double d3 = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * (double)f;
        if (!this._I.isEmpty()) {
            GL11.glBlendFunc(774, 768);
            this._g._a(sctd._c);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            GL11.glPushMatrix();
            GL11.glDisable(3008);
            GL11.glPolygonOffset(-3.0f, -3.0f);
            GL11.glEnable(32823);
            GL11.glEnable(3008);
            tessellator.startDrawingQuads();
            tessellator.setTranslation(-d, -d2, -d3);
            tessellator.disableColor();
            Iterator iterator2 = this._I.values().iterator();
            while (iterator2.hasNext()) {
                Block block;
                double d4;
                double d5;
                yeay yeay2 = (yeay)iterator2.next();
                double d6 = (double)yeay2._a() - d;
                if (d6 * d6 + (d5 = (double)yeay2._b() - d2) * d5 + (d4 = (double)yeay2._c() - d3) * d4 > 1024.0) {
                    iterator2.remove();
                    continue;
                }
                int n = this._f.getBlockId(yeay2._a(), yeay2._b(), yeay2._c());
                Block block2 = block = n > 0 ? Block.blocksList[n] : null;
                if (block == null) {
                    block = Block.stone;
                }
                this._s._a(block, yeay2._a(), yeay2._b(), yeay2._c(), this._J[yeay2._d()]);
            }
            tessellator.draw();
            tessellator.setTranslation(0.0, 0.0, 0.0);
            GL11.glDisable(3008);
            GL11.glPolygonOffset(0.0f, 0.0f);
            GL11.glDisable(32823);
            GL11.glEnable(3008);
            GL11.glDepthMask(true);
            GL11.glPopMatrix();
        }
    }

    public void _a(EntityPlayer entityPlayer, MovingObjectPosition movingObjectPosition, int n, float f) {
        if (n == 0 && movingObjectPosition._c == EnumMovingObjectType._a) {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.4f);
            GL11.glLineWidth(2.0f);
            GL11.glDisable(3553);
            GL11.glDepthMask(false);
            float f2 = 0.002f;
            int n2 = this._f.getBlockId(movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f);
            if (n2 > 0) {
                Block.blocksList[n2].setBlockBoundsBasedOnState(this._f, movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f);
                double d = entityPlayer.lastTickPosX + (entityPlayer.posX - entityPlayer.lastTickPosX) * (double)f;
                double d2 = entityPlayer.lastTickPosY + (entityPlayer.posY - entityPlayer.lastTickPosY) * (double)f;
                double d3 = entityPlayer.lastTickPosZ + (entityPlayer.posZ - entityPlayer.lastTickPosZ) * (double)f;
                this._a(Block.blocksList[n2].getSelectedBoundingBoxFromPool(this._f, movingObjectPosition._d, movingObjectPosition._e, movingObjectPosition._f)._b(f2, f2, f2)._c(-d, -d2, -d3));
            }
            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
        }
    }

    public void _a(AxisAlignedBB axisAlignedBB) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawing(3);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.draw();
        tessellator.startDrawing(3);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.draw();
        tessellator.startDrawing(1);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._d);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._e, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._c, axisAlignedBB._g);
        tessellator.addVertex(axisAlignedBB._b, axisAlignedBB._f, axisAlignedBB._g);
        tessellator.draw();
    }

    public void _a(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = sajh._a(n, 16);
        int n8 = sajh._a(n2, 16);
        int n9 = sajh._a(n3, 16);
        int n10 = sajh._a(n4, 16);
        int n11 = sajh._a(n5, 16);
        int n12 = sajh._a(n6, 16);
        for (int i = n7; i <= n10; ++i) {
            int n13 = i % this._n;
            if (n13 < 0) {
                n13 += this._n;
            }
            for (int j = n8; j <= n11; ++j) {
                int n14 = j % this._o;
                if (n14 < 0) {
                    n14 += this._o;
                }
                for (int k = n9; k <= n12; ++k) {
                    int n15;
                    WorldRenderer worldRenderer;
                    int n16 = k % this._p;
                    if (n16 < 0) {
                        n16 += this._p;
                    }
                    if ((worldRenderer = this._j[n15 = (n16 * this._o + n14) * this._n + n13]) == null || worldRenderer.needsUpdate) continue;
                    int n17 = worldRenderer.posX / 16;
                    int n18 = worldRenderer.posZ / 16;
                    if (n17 < n7 || n17 > n10 || n18 < n9 || n18 > n12) continue;
                    this._h.add(worldRenderer);
                    worldRenderer.markDirty();
                }
            }
        }
    }

    @Override
    public void _b(int n, int n2, int n3) {
        this._a(n - 1, n2 - 1, n3 - 1, n + 1, n2 + 1, n3 + 1);
    }

    @Override
    public void _c(int n, int n2, int n3) {
        this._a(n - 1, n2 - 1, n3 - 1, n + 1, n2 + 1, n3 + 1);
    }

    @Override
    public void _b(int n, int n2, int n3, int n4, int n5, int n6) {
        this._a(n, n2, n3, n4, n5, n6);
    }

    public void _a(lpai lpai2, float f) {
        for (int i = 0; i < this._k.size(); ++i) {
            WorldRenderer worldRenderer = this._k.get(i);
            worldRenderer.updateInFrustum(lpai2);
        }
        ++this.__ab;
    }

    @Override
    public void _a(String string, int n, int n2, int n3) {
        ItemRecord itemRecord = ItemRecord._a(string);
        if (string != null && itemRecord != null) {
            this._r._J.setRecordPlayingMessage(itemRecord._a());
        }
        this._r._N._a(string, n, n2, n3);
    }

    @Override
    public void _a(String string, double d, double d2, double d3, float f, float f2) {
    }

    @Override
    public void _a(EntityPlayer entityPlayer, String string, double d, double d2, double d3, float f, float f2) {
    }

    @Override
    public void _a(String string, double d, double d2, double d3, double d4, double d5, double d6) {
        try {
            this._b(string, d, d2, d3, d4, d5, d6);
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception while adding particle");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Particle being added");
            crashReportCategory._a("Name", string);
            crashReportCategory._a("Position", new nvdp(this, d, d2, d3));
            throw new turb(crashReport);
        }
    }

    public EntityFX _b(String string, double d, double d2, double d3, double d4, double d5, double d6) {
        if (this._r != null && this._r._u != null && this._r._w != null) {
            int n = this._r._M.particleSetting;
            if (n == 1 && this._f.rand.nextInt(3) == 0) {
                n = 2;
            }
            double d7 = this._r._u.posX - d;
            double d8 = this._r._u.posY - d2;
            double d9 = this._r._u.posZ - d3;
            EntityFX entityFX = null;
            if (string.equals("hugeexplosion")) {
                if (Config.isAnimatedExplosion()) {
                    entityFX = new EntityHugeExplodeFX(this._f, d, d2, d3, d4, d5, d6);
                    this._r._w._a(entityFX);
                }
            } else if (string.equals("largeexplode")) {
                if (Config.isAnimatedExplosion()) {
                    entityFX = new EntityLargeExplodeFX(this._g, this._f, d, d2, d3, d4, d5, d6);
                    this._r._w._a(entityFX);
                }
            } else if (string.equals("fireworksSpark")) {
                entityFX = new EntityFireworkSparkFX(this._f, d, d2, d3, d4, d5, d6, this._r._w);
                this._r._w._a(entityFX);
            }
            if (entityFX != null) {
                return entityFX;
            }
            double d10 = 16.0;
            double d11 = 16.0;
            if (string.equals("crit")) {
                d10 = 196.0;
            }
            if (d7 * d7 + d8 * d8 + d9 * d9 > d10 * d10) {
                return null;
            }
            if (n > 1) {
                return null;
            }
            if (string.equals("bubble")) {
                entityFX = new EntityBubbleFX(this._f, d, d2, d3, d4, d5, d6);
                CustomColorizer.updateWaterFX(entityFX, this._f);
            } else if (string.equals("suspended")) {
                if (Config.isWaterParticles()) {
                    entityFX = new EntitySuspendFX(this._f, d, d2, d3, d4, d5, d6);
                }
            } else if (string.equals("depthsuspend")) {
                if (Config.isVoidParticles()) {
                    entityFX = new EntityAuraFX(this._f, d, d2, d3, d4, d5, d6);
                }
            } else if (string.equals("townaura")) {
                entityFX = new EntityAuraFX(this._f, d, d2, d3, d4, d5, d6);
                CustomColorizer.updateMyceliumFX(entityFX);
            } else if (string.equals("crit")) {
                entityFX = new EntityCritFX(this._f, d, d2, d3, d4, d5, d6);
            } else if (string.equals("magicCrit")) {
                entityFX = new EntityCritFX(this._f, d, d2, d3, d4, d5, d6);
                entityFX.setRBGColorF(entityFX.getRedColorF() * 0.3f, entityFX.getGreenColorF() * 0.8f, entityFX.getBlueColorF());
                entityFX.nextTextureIndexX();
            } else if (string.equals("smoke")) {
                if (Config.isAnimatedSmoke()) {
                    entityFX = new EntitySmokeFX(this._f, d, d2, d3, d4, d5, d6);
                }
            } else if (string.equals("mobSpell")) {
                if (Config.isPotionParticles()) {
                    entityFX = new EntitySpellParticleFX(this._f, d, d2, d3, 0.0, 0.0, 0.0);
                    entityFX.setRBGColorF((float)d4, (float)d5, (float)d6);
                }
            } else if (string.equals("mobSpellAmbient")) {
                if (Config.isPotionParticles()) {
                    entityFX = new EntitySpellParticleFX(this._f, d, d2, d3, 0.0, 0.0, 0.0);
                    entityFX.setAlphaF(0.15f);
                    entityFX.setRBGColorF((float)d4, (float)d5, (float)d6);
                }
            } else if (string.equals("spell")) {
                if (Config.isPotionParticles()) {
                    entityFX = new EntitySpellParticleFX(this._f, d, d2, d3, d4, d5, d6);
                }
            } else if (string.equals("instantSpell")) {
                if (Config.isPotionParticles()) {
                    entityFX = new EntitySpellParticleFX(this._f, d, d2, d3, d4, d5, d6);
                    ((EntitySpellParticleFX)entityFX).setBaseSpellTextureIndex(144);
                }
            } else if (string.equals("witchMagic")) {
                if (Config.isPotionParticles()) {
                    entityFX = new EntitySpellParticleFX(this._f, d, d2, d3, d4, d5, d6);
                    ((EntitySpellParticleFX)entityFX).setBaseSpellTextureIndex(144);
                    float f = this._f.rand.nextFloat() * 0.5f + 0.35f;
                    entityFX.setRBGColorF(1.0f * f, 0.0f * f, 1.0f * f);
                }
            } else if (string.equals("note")) {
                entityFX = new EntityNoteFX(this._f, d, d2, d3, d4, d5, d6);
            } else if (string.equals("portal")) {
                if (Config.isPortalParticles()) {
                    entityFX = new EntityPortalFX(this._f, d, d2, d3, d4, d5, d6);
                    CustomColorizer.updatePortalFX(entityFX);
                }
            } else if (string.equals("enchantmenttable")) {
                entityFX = new EntityEnchantmentTableParticleFX(this._f, d, d2, d3, d4, d5, d6);
            } else if (string.equals("explode")) {
                if (Config.isAnimatedExplosion()) {
                    entityFX = new EntityExplodeFX(this._f, d, d2, d3, d4, d5, d6);
                }
            } else if (string.equals("flame")) {
                if (Config.isAnimatedFlame()) {
                    entityFX = new EntityFlameFX(this._f, d, d2, d3, d4, d5, d6);
                }
            } else if (string.equals("lava")) {
                entityFX = new EntityLavaFX(this._f, d, d2, d3);
            } else if (string.equals("footstep")) {
                entityFX = new EntityFootStepFX(this._g, this._f, d, d2, d3);
            } else if (string.equals("splash")) {
                entityFX = new EntitySplashFX(this._f, d, d2, d3, d4, d5, d6);
                CustomColorizer.updateWaterFX(entityFX, this._f);
            } else if (string.equals("largesmoke")) {
                if (Config.isAnimatedSmoke()) {
                    entityFX = new EntitySmokeFX(this._f, d, d2, d3, d4, d5, d6, 2.5f);
                }
            } else if (string.equals("cloud")) {
                entityFX = new EntityCloudFX(this._f, d, d2, d3, d4, d5, d6);
            } else if (string.equals("reddust")) {
                if (Config.isAnimatedRedstone()) {
                    entityFX = new EntityReddustFX((World)this._f, d, d2, d3, (float)d4, (float)d5, (float)d6);
                    CustomColorizer.updateReddustFX(entityFX, this._f, d7, d8, d9);
                }
            } else if (string.equals("snowballpoof")) {
                entityFX = new EntityBreakingFX(this._f, d, d2, d3, Item.snowball);
            } else if (string.equals("dripWater")) {
                if (Config.isDrippingWaterLava()) {
                    entityFX = new EntityDropParticleFX(this._f, d, d2, d3, Material._h);
                }
            } else if (string.equals("dripLava")) {
                if (Config.isDrippingWaterLava()) {
                    entityFX = new EntityDropParticleFX(this._f, d, d2, d3, Material._i);
                }
            } else if (string.equals("snowshovel")) {
                entityFX = new EntitySnowShovelFX(this._f, d, d2, d3, d4, d5, d6);
            } else if (string.equals("slime")) {
                entityFX = new EntityBreakingFX(this._f, d, d2, d3, Item.slimeBall);
            } else if (string.equals("heart")) {
                entityFX = new EntityHeartFX(this._f, d, d2, d3, d4, d5, d6);
            } else if (string.equals("angryVillager")) {
                entityFX = new EntityHeartFX(this._f, d, d2 + 0.5, d3, d4, d5, d6);
                entityFX.setParticleTextureIndex(81);
                entityFX.setRBGColorF(1.0f, 1.0f, 1.0f);
            } else if (string.equals("happyVillager")) {
                entityFX = new EntityAuraFX(this._f, d, d2, d3, d4, d5, d6);
                entityFX.setParticleTextureIndex(82);
                entityFX.setRBGColorF(1.0f, 1.0f, 1.0f);
            } else if (string.startsWith("iconcrack_")) {
                String[] stringArray = string.split("_", 3);
                int n2 = Integer.parseInt(stringArray[1]);
                if (stringArray.length > 2) {
                    int n3 = Integer.parseInt(stringArray[2]);
                    entityFX = new EntityBreakingFX(this._f, d, d2, d3, d4, d5, d6, Item.itemsList[n2], n3);
                } else {
                    entityFX = new EntityBreakingFX(this._f, d, d2, d3, d4, d5, d6, Item.itemsList[n2], 0);
                }
            } else if (string.startsWith("tilecrack_")) {
                String[] stringArray = string.split("_", 3);
                int n4 = Integer.parseInt(stringArray[1]);
                int n5 = Integer.parseInt(stringArray[2]);
                entityFX = new EntityDiggingFX(this._f, d, d2, d3, d4, d5, d6, Block.blocksList[n4], n5).applyRenderColor(n5);
            }
            if (entityFX != null) {
                this._r._w._a(entityFX);
            }
            return entityFX;
        }
        return null;
    }

    @Override
    public void _b(Entity entity) {
        RandomMobs.entityLoaded(entity);
    }

    @Override
    public void _c(Entity entity) {
    }

    public void _f() {
        pklh._b(this._q);
    }

    @Override
    public void _a(int n, int n2, int n3, int n4, int n5) {
        Random random = this._f.rand;
        switch (n) {
            case 1013: 
            case 1018: {
                if (this._r._u == null) break;
                double d = (double)n2 - this._r._u.posX;
                double d2 = (double)n3 - this._r._u.posY;
                double d3 = (double)n4 - this._r._u.posZ;
                double d4 = Math.sqrt(d * d + d2 * d2 + d3 * d3);
                double d5 = this._r._u.posX;
                double d6 = this._r._u.posY;
                double d7 = this._r._u.posZ;
                if (d4 > 0.0) {
                    d5 += d / d4 * 2.0;
                    d6 += d2 / d4 * 2.0;
                    d7 += d3 / d4 * 2.0;
                }
                if (n == 1013) {
                    this._f.playSound(d5, d6, d7, "mob.wither.spawn", 1.0f, 1.0f, false);
                    break;
                }
                if (n != 1018) break;
                this._f.playSound(d5, d6, d7, "mob.enderdragon.end", 5.0f, 1.0f, false);
            }
        }
    }

    @Override
    public void _a(EntityPlayer entityPlayer, int n, int n2, int n3, int n4, int n5) {
        Random random = this._f.rand;
        switch (n) {
            case 1000: {
                this._f.playSound(n2, n3, n4, "random.click", 1.0f, 1.0f, false);
                break;
            }
            case 1001: {
                this._f.playSound(n2, n3, n4, "random.click", 1.0f, 1.2f, false);
                break;
            }
            case 1002: {
                this._f.playSound(n2, n3, n4, "random.bow", 1.0f, 1.2f, false);
                break;
            }
            case 1003: {
                if (Math.random() < 0.5) {
                    this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.door_open", 1.0f, this._f.rand.nextFloat() * 0.1f + 0.9f, false);
                    break;
                }
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.door_close", 1.0f, this._f.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1004: {
                this._f.playSound((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, "random.fizz", 0.5f, 2.6f + (random.nextFloat() - random.nextFloat()) * 0.8f, false);
                break;
            }
            case 1005: {
                if (Item.itemsList[n5] instanceof ItemRecord) {
                    this._f.playRecord(((ItemRecord)Item.itemsList[n5])._b, n2, n3, n4);
                    break;
                }
                this._f.playRecord(null, n2, n3, n4);
                break;
            }
            case 1007: {
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.ghast.charge", 10.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1008: {
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.ghast.fireball", 10.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1009: {
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.ghast.fireball", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1010: {
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.zombie.wood", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1011: {
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.zombie.metal", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1012: {
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.zombie.woodbreak", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1014: {
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.wither.shoot", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1015: {
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.bat.takeoff", 0.05f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1016: {
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.zombie.infect", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1017: {
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.zombie.unfect", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1020: {
                this._f.playSound((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, "random.anvil_break", 1.0f, this._f.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1021: {
                this._f.playSound((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, "random.anvil_use", 1.0f, this._f.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1022: {
                this._f.playSound((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, "random.anvil_land", 0.3f, this._f.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2000: {
                int n6 = n5 % 3 - 1;
                int n7 = n5 / 3 % 3 - 1;
                double d = (double)n2 + (double)n6 * 0.6 + 0.5;
                double d2 = (double)n3 + 0.5;
                double d3 = (double)n4 + (double)n7 * 0.6 + 0.5;
                for (int i = 0; i < 10; ++i) {
                    double d4 = random.nextDouble() * 0.2 + 0.01;
                    double d5 = d + (double)n6 * 0.01 + (random.nextDouble() - 0.5) * (double)n7 * 0.5;
                    double d6 = d2 + (random.nextDouble() - 0.5) * 0.5;
                    double d7 = d3 + (double)n7 * 0.01 + (random.nextDouble() - 0.5) * (double)n6 * 0.5;
                    double d8 = (double)n6 * d4 + random.nextGaussian() * 0.01;
                    double d9 = -0.03 + random.nextGaussian() * 0.01;
                    double d10 = (double)n7 * d4 + random.nextGaussian() * 0.01;
                    this._a("smoke", d5, d6, d7, d8, d9, d10);
                }
                return;
            }
            case 2001: {
                int n8 = n5 & 0xFFF;
                if (n8 > 0) {
                    Block block = Block.blocksList[n8];
                    this._r._N._a(block.stepSound._c(), (float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, (block.stepSound._a() + 1.0f) / 2.0f, block.stepSound._b() * 0.8f);
                }
                this._r._w._a(n2, n3, n4, n5 & 0xFFF, n5 >> 12 & 0xFF);
                break;
            }
            case 2002: {
                int n9;
                double d = n2;
                double d11 = n3;
                double d12 = n4;
                String string = "iconcrack_" + Item.potion.itemID + "_" + n5;
                for (n9 = 0; n9 < 8; ++n9) {
                    this._a(string, d, d11, d12, random.nextGaussian() * 0.15, random.nextDouble() * 0.2, random.nextGaussian() * 0.15);
                }
                n9 = Item.potion._c(n5);
                float f = (float)(n9 >> 16 & 0xFF) / 255.0f;
                float f2 = (float)(n9 >> 8 & 0xFF) / 255.0f;
                float f3 = (float)(n9 >> 0 & 0xFF) / 255.0f;
                String string2 = "spell";
                if (Item.potion._d(n5)) {
                    string2 = "instantSpell";
                }
                for (int i = 0; i < 100; ++i) {
                    double d13 = random.nextDouble() * 4.0;
                    double d14 = random.nextDouble() * Math.PI * 2.0;
                    double d15 = Math.cos(d14) * d13;
                    double d16 = 0.01 + random.nextDouble() * 0.5;
                    double d17 = Math.sin(d14) * d13;
                    EntityFX entityFX = this._b(string2, d + d15 * 0.1, d11 + 0.3, d12 + d17 * 0.1, d15, d16, d17);
                    if (entityFX == null) continue;
                    float f4 = 0.75f + random.nextFloat() * 0.25f;
                    entityFX.setRBGColorF(f * f4, f2 * f4, f3 * f4);
                    entityFX.multiplyVelocity((float)d13);
                }
                this._f.playSound((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.glass", 1.0f, this._f.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2003: {
                double d = (double)n2 + 0.5;
                double d18 = n3;
                double d19 = (double)n4 + 0.5;
                String string = "iconcrack_" + Item.eyeOfEnder.itemID;
                for (int i = 0; i < 8; ++i) {
                    this._a(string, d, d18, d19, random.nextGaussian() * 0.15, random.nextDouble() * 0.2, random.nextGaussian() * 0.15);
                }
                for (double d20 = 0.0; d20 < Math.PI * 2; d20 += 0.15707963267948966) {
                    this._a("portal", d + Math.cos(d20) * 5.0, d18 - 0.4, d19 + Math.sin(d20) * 5.0, Math.cos(d20) * -5.0, 0.0, Math.sin(d20) * -5.0);
                    this._a("portal", d + Math.cos(d20) * 5.0, d18 - 0.4, d19 + Math.sin(d20) * 5.0, Math.cos(d20) * -7.0, 0.0, Math.sin(d20) * -7.0);
                }
                return;
            }
            case 2004: {
                for (int i = 0; i < 20; ++i) {
                    double d = (double)n2 + 0.5 + ((double)this._f.rand.nextFloat() - 0.5) * 2.0;
                    double d21 = (double)n3 + 0.5 + ((double)this._f.rand.nextFloat() - 0.5) * 2.0;
                    double d22 = (double)n4 + 0.5 + ((double)this._f.rand.nextFloat() - 0.5) * 2.0;
                    this._f.spawnParticle("smoke", d, d21, d22, 0.0, 0.0, 0.0);
                    this._f.spawnParticle("flame", d, d21, d22, 0.0, 0.0, 0.0);
                }
                return;
            }
            case 2005: {
                hugs._a(this._f, n2, n3, n4, n5);
            }
        }
    }

    @Override
    public void _b(int n, int n2, int n3, int n4, int n5) {
        if (n5 >= 0 && n5 < 10) {
            yeay yeay2 = (yeay)this._I.get(n);
            if (yeay2 == null || yeay2._a() != n2 || yeay2._b() != n3 || yeay2._c() != n4) {
                yeay2 = new yeay(n, n2, n3, n4);
                this._I.put(n, yeay2);
            }
            yeay2._a(n5);
            yeay2._b(this._v);
        } else {
            this._I.remove(n);
        }
    }

    public void _a(IconRegister iconRegister) {
        this._J = new Icon[10];
        for (int i = 0; i < this._J.length; ++i) {
            this._J[i] = iconRegister._b("destroy_stage_" + i);
        }
    }

    public void _g() {
        if (this._j != null) {
            for (int i = 0; i < this._j.length; ++i) {
                this._j[i].isVisible = true;
            }
        }
    }

    public boolean _a(EntityLivingBase entityLivingBase) {
        boolean bl = this._b(entityLivingBase);
        if (bl) {
            this.__ag = System.currentTimeMillis();
            return true;
        }
        return System.currentTimeMillis() - this.__ag < 2000L;
    }

    public boolean _b(EntityLivingBase entityLivingBase) {
        double d = 0.001;
        return entityLivingBase.isJumping || entityLivingBase.isSneaking() || (double)entityLivingBase.prevSwingProgress > d || this._r._O._a != 0 || this._r._O._b != 0 || Math.abs(entityLivingBase.posX - entityLivingBase.prevPosX) > d || Math.abs(entityLivingBase.posY - entityLivingBase.prevPosY) > d || Math.abs(entityLivingBase.posZ - entityLivingBase.prevPosZ) > d;
    }

    public boolean _h() {
        boolean bl = this._i();
        if (bl) {
            this.__ah = System.currentTimeMillis();
            return true;
        }
        return System.currentTimeMillis() - this.__ah < 500L;
    }

    public boolean _i() {
        return Mouse.isButtonDown(0) ? true : Mouse.isButtonDown(1);
    }

    public int _b(int n, double d) {
        GloomyHooks.renderAllSortedRenderers(this, n, d);
        return this._a(0, this._k.size(), n, d);
    }

    public void _j() {
        if (this._f != null) {
            boolean bl = Config.isShowCapes();
            List list = this._f.playerEntities;
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (!(entity instanceof AbstractClientPlayer)) continue;
                AbstractClientPlayer abstractClientPlayer = (AbstractClientPlayer)entity;
                abstractClientPlayer.getTextureCape()._g = bl;
            }
        }
    }

    public AxisAlignedBB _a(TileEntity tileEntity) {
        Block block = tileEntity.getBlockType();
        if (block == null) {
            return TileEntity.INFINITE_EXTENT_AABB;
        }
        return AxisAlignedBB._a()._a((double)tileEntity.xCoord + block.minX - 2.0, (double)tileEntity.yCoord + block.minY - 2.0, (double)tileEntity.zCoord + block.minZ - 2.0, (double)tileEntity.xCoord + block.maxX + 2.0, (double)tileEntity.yCoord + block.maxY + 2.0, (double)tileEntity.zCoord + block.maxZ + 2.0);
    }
}

