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
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.entity.EntityClientPlayerMP;
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
import net.minecraft.client.xpzm;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.amww;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.turb;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;

public class cvgz
implements aqaj {
    public static final ResourceLocation _a = new ResourceLocation("textures/environment/moon_phases.png");
    public static final ResourceLocation _b = new ResourceLocation("textures/environment/sun.png");
    public static final ResourceLocation _c = new ResourceLocation("textures/environment/clouds.png");
    public static final ResourceLocation _d = new ResourceLocation("textures/environment/end_sky.png");
    public List _e = new ArrayList();
    public pkix _f;
    public final apbu _g;
    public CompactArrayList _h = new CompactArrayList(100, 0.8f);
    public nvgj[] _i;
    public nvgj[] _j;
    public List<nvgj> _k = new ArrayList<nvgj>();
    public List<nvgj> _l = new ArrayList<nvgj>();
    public List<nvgj> _m = new ArrayList<nvgj>();
    public int _n;
    public int _o;
    public int _p;
    public int _q;
    public xpzm _r;
    public htvc _s;
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
    public dwan[] _J;
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
    public static eidj __ai = eidj._a(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
    public ixzi[] __aj = new ixzi[4];

    public cvgz(xpzm xpzm2) {
        int n;
        int n2;
        this._r = xpzm2;
        this._g = xpzm2._R();
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
        htvf htvf2 = htvf.field_78398_a;
        this._x = this._w + 1;
        GL11.glNewList(this._x, 4864);
        int n5 = 64;
        int n6 = 256 / n5 + 2;
        float f = 16.0f;
        for (n2 = -n5 * n6; n2 <= n5 * n6; n2 += n5) {
            for (n = -n5 * n6; n <= n5 * n6; n += n5) {
                htvf2.func_78382_b();
                htvf2.func_78377_a(n2 + 0, f, n + 0);
                htvf2.func_78377_a(n2 + n5, f, n + 0);
                htvf2.func_78377_a(n2 + n5, f, n + n5);
                htvf2.func_78377_a(n2 + 0, f, n + n5);
                htvf2.func_78381_a();
            }
        }
        GL11.glEndList();
        this._y = this._w + 2;
        GL11.glNewList(this._y, 4864);
        f = -16.0f;
        htvf2.func_78382_b();
        for (n2 = -n5 * n6; n2 <= n5 * n6; n2 += n5) {
            for (n = -n5 * n6; n <= n5 * n6; n += n5) {
                htvf2.func_78377_a(n2 + n5, f, n + 0);
                htvf2.func_78377_a(n2 + 0, f, n + 0);
                htvf2.func_78377_a(n2 + 0, f, n + n5);
                htvf2.func_78377_a(n2 + n5, f, n + n5);
            }
        }
        htvf2.func_78381_a();
        GL11.glEndList();
    }

    public void _a() {
        Random random = new Random(10842L);
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78382_b();
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
                htvf2.func_78377_a(d6 + d25, d7 + d23, d8 + d26);
            }
        }
        htvf2.func_78381_a();
    }

    public void _a(pkix pkix2) {
        if (this._f != null) {
            this._f.func_72848_b(this);
        }
        this._Y = -9999.0;
        this._Z = -9999.0;
        this.__aa = -9999.0;
        gqqu._b._a(pkix2);
        this._f = pkix2;
        this._s = new htvc(pkix2);
        if (pkix2 != null) {
            pkix2.func_72954_a(this);
            this._b();
        }
    }

    public void _b() {
        if (this._f != null) {
            int n;
            int n2;
            twgu.field_71952_K._a(Config.isTreesFancy());
            this._K = this._r._M.field_74339_e;
            if (this._j != null) {
                for (n2 = 0; n2 < this._j.length; ++n2) {
                    this._j[n2].func_78911_c();
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
            this._j = new nvgj[this._n * this._o * this._p];
            this._i = new nvgj[this._n * this._o * this._p];
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
                nvgj nvgj2 = (nvgj)this._h.get(n);
                if (nvgj2 == null) continue;
                nvgj2.field_78939_q = false;
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
                            this._j[n7].field_78934_v = this._t.get(n6);
                        }
                        this._j[n7].field_78935_u = false;
                        this._j[n7].field_78936_t = true;
                        this._j[n7].field_78927_l = false;
                        this._j[n7].field_78937_s = n6++;
                        this._i[n7] = this._j[n7];
                        if (this._f.func_72916_c(n, j)) {
                            this._j[n7].func_78914_f();
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
                    this._a(sajh._c(((Entity)entityLivingBase).field_70165_t), sajh._c(((Entity)entityLivingBase).field_70163_u), sajh._c(((Entity)entityLivingBase).field_70161_v));
                    Arrays.sort(this._i, new yvgb(entityLivingBase));
                }
            }
            this._L = 2;
        }
    }

    public void _a(ofbx ofbx2, lpai lpai2, float f) {
        int n = MinecraftForgeClient.getRenderPass();
        if (this._L > 0) {
            if (n > 0) {
                fmej._a(this, ofbx2, lpai2, f);
                return;
            }
            --this._L;
        } else {
            Entity entity;
            int n2;
            Object object;
            this._f.field_72984_F._a("prepare");
            cekh._b._a(this._f, this._r._R(), this._r._z, this._r._u, f);
            gqqu._b._a(this._f, this._r._R(), this._r._z, this._r._u, this._r._v, this._r._M, f);
            if (n == 0) {
                this._M = 0;
                this._N = 0;
                this._O = 0;
                object = this._r._u;
                gqqu._d = ((Entity)object).field_70142_S + (((Entity)object).field_70165_t - ((Entity)object).field_70142_S) * (double)f;
                gqqu._e = ((Entity)object).field_70137_T + (((Entity)object).field_70163_u - ((Entity)object).field_70137_T) * (double)f;
                gqqu._f = ((Entity)object).field_70136_U + (((Entity)object).field_70161_v - ((Entity)object).field_70136_U) * (double)f;
                cekh._d = ((Entity)object).field_70142_S + (((Entity)object).field_70165_t - ((Entity)object).field_70142_S) * (double)f;
                cekh._e = ((Entity)object).field_70137_T + (((Entity)object).field_70163_u - ((Entity)object).field_70137_T) * (double)f;
                cekh._f = ((Entity)object).field_70136_U + (((Entity)object).field_70161_v - ((Entity)object).field_70136_U) * (double)f;
            }
            this._r._D.func_78463_b(f);
            this._f.field_72984_F._c("global");
            object = this._f.func_72910_y();
            if (n == 0) {
                this._M = object.size();
            }
            if (Config.isFogOff() && this._r._D.fogStandard) {
                GL11.glDisable(2912);
            }
            for (n2 = 0; n2 < this._f.field_73007_j.size(); ++n2) {
                entity = (Entity)this._f.field_73007_j.get(n2);
                if (!entity.shouldRenderInPass(n)) continue;
                ++this._N;
                if (!entity.func_70102_a(ofbx2)) continue;
                gqqu._b._a(entity, f);
            }
            this._f.field_72984_F._c("entities");
            n2 = this._r._M.field_74347_j ? 1 : 0;
            this._r._M.field_74347_j = Config.isDroppedItemsFancy();
            for (int i = 0; i < object.size(); ++i) {
                boolean bl;
                EntityLiving entityLiving;
                boolean bl2;
                entity = (Entity)object.get(i);
                if (!entity.shouldRenderInPass(n)) continue;
                boolean bl3 = bl2 = entity.func_70102_a(ofbx2) && this._a(entity) && (entity.field_70158_ak || lpai2._a(entity.field_70121_D) || entity.field_70153_n == this._r._t);
                if (!bl2 && entity instanceof EntityLiving && (entityLiving = (EntityLiving)entity).func_110167_bD() && entityLiving.func_110166_bE() != null) {
                    Entity entity2 = entityLiving.func_110166_bE();
                    bl2 = lpai2._a(entity2.field_70121_D);
                }
                boolean bl4 = bl = entity != this._r._u || this._r._M.field_74320_O != 0 || this._r._u.func_70608_bn();
                if (!bl2 || !bl || !this._f.func_72899_e(sajh._c(entity.field_70165_t), 0, sajh._c(entity.field_70161_v))) continue;
                ++this._N;
                if (entity.getClass() == EntityItemFrame.class) {
                    entity.field_70155_l = 0.06;
                }
                this.__af = entity;
                gqqu._b._a(entity, f);
                this.__af = null;
            }
            this._r._M.field_74347_j = n2;
            this._f.field_72984_F._c("tileentities");
            qnon._b();
            double d = cekh._b._l;
            double d2 = cekh._b._m;
            double d3 = cekh._b._n;
            for (int i = 0; i < this._e.size(); ++i) {
                int n3;
                twgu twgu2;
                eidj eidj2;
                hurg hurg2 = (hurg)this._e.get(i);
                if (!hurg2.shouldRenderInPass(n) || !(hurg2.func_70318_a(d, d2, d3) < hurg2.func_82115_m()) || !this._a(hurg2.field_70329_l >> 4, hurg2.field_70330_m >> 4, hurg2.field_70327_n >> 4, false, true) || !lpai2._a(eidj2 = this._a(hurg2))) continue;
                Class<?> clazz = hurg2.getClass();
                if (clazz == jjza.class && !Config.zoomMode) {
                    EntityClientPlayerMP entityClientPlayerMP = this._r._t;
                    double d4 = hurg2.func_70318_a(entityClientPlayerMP.field_70165_t, entityClientPlayerMP.field_70163_u, entityClientPlayerMP.field_70161_v);
                    if (d4 > 256.0) {
                        qncw qncw2 = cekh._b._a();
                        qncw2._y = false;
                        cekh._b._a(hurg2, f);
                        qncw2._y = true;
                        continue;
                    }
                }
                if (clazz == yfav.class && !((twgu2 = twgu.field_71973_m[n3 = this._f.func_72798_a(hurg2.field_70329_l, hurg2.field_70330_m, hurg2.field_70327_n)]) instanceof ydso)) continue;
                cekh._b._a(hurg2, f);
            }
            this._r._D.func_78483_a(f);
            this._f.field_72984_F._b();
        }
        fmej._a(this, ofbx2, lpai2, f);
    }

    public boolean _a(Entity entity) {
        return this._a(entity.field_70176_ah, sajh._c(entity.field_70163_u / 16.0), entity.field_70164_aj, true, true);
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
        nvgj nvgj2 = this._j[n7];
        if (!nvgj2.field_78915_A) {
            return false;
        }
        if (!nvgj2.skipAllRenderPasses) {
            if (bl && !nvgj2.field_78927_l) {
                return false;
            }
            if (bl2 && this._u && !nvgj2.field_78936_t) {
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
                    nvgj nvgj2 = this._j[(j * this._o + k) * this._n + i];
                    boolean bl = nvgj2.field_78939_q;
                    nvgj2.func_78913_a(n6, n10, n8);
                    if (bl || !nvgj2.field_78939_q) continue;
                    this._h.add(nvgj2);
                }
            }
        }
    }

    public int _a(EntityLivingBase entityLivingBase, int n, double d) {
        int n2;
        GloomyHooks.sortAndRender(this, entityLivingBase, n, d);
        fokl fokl2 = this._f.field_72984_F;
        fokl2._a("sortchunks");
        if (this._h.size() < 10) {
            int n3 = 10;
            for (int i = 0; i < n3; ++i) {
                this._W = (this._W + 1) % this._j.length;
                nvgj nvgj2 = this._j[this._W];
                if (!nvgj2.field_78939_q || this._h.contains(nvgj2)) continue;
                this._h.add(nvgj2);
            }
        }
        if (this._r._M.field_74339_e != this._K && !Config.isLoadChunksFar()) {
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
        double d2 = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * d;
        double d3 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * d;
        double d4 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * d;
        double d5 = entityLivingBase.field_70165_t - this._Y;
        double d6 = entityLivingBase.field_70163_u - this._Z;
        double d7 = entityLivingBase.field_70161_v - this.__aa;
        double d8 = d5 * d5 + d6 * d6 + d7 * d7;
        if (d8 > 16.0) {
            this._Y = entityLivingBase.field_70165_t;
            this._Z = entityLivingBase.field_70163_u;
            this.__aa = entityLivingBase.field_70161_v;
            double d9 = entityLivingBase.field_70165_t - this.__ac;
            double d10 = entityLivingBase.field_70163_u - this.__ad;
            double d11 = entityLivingBase.field_70161_v - this.__ae;
            double d12 = d9 * d9 + d10 * d10 + d11 * d11;
            n2 = Config.getPreloadedChunks() * 16;
            if (d12 > (double)(n2 * n2) + 16.0) {
                this.__ac = entityLivingBase.field_70165_t;
                this.__ad = entityLivingBase.field_70163_u;
                this.__ae = entityLivingBase.field_70161_v;
                this._a(sajh._c(entityLivingBase.field_70165_t), sajh._c(entityLivingBase.field_70163_u), sajh._c(entityLivingBase.field_70161_v));
            }
            this._k.sort(new yvgb(entityLivingBase));
        }
        qnon._a();
        WrUpdates.preRender(this, entityLivingBase);
        int n4 = 0;
        int n5 = 0;
        if (this._u && this._r._M.field_74349_h && !this._r._M.field_74337_g && n == 0) {
            int n6;
            int n7 = 0;
            int n8 = Math.min(20, this._k.size());
            this._a(n7, n8, entityLivingBase.field_70165_t, entityLivingBase.field_70163_u, entityLivingBase.field_70161_v);
            for (n6 = n7; n6 < n8; ++n6) {
                this._k.get((int)n6).field_78936_t = true;
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
                this._a(n12, n6, entityLivingBase.field_70165_t, entityLivingBase.field_70163_u, entityLivingBase.field_70161_v);
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
                    nvgj nvgj3 = this._k.get(i);
                    if (nvgj3.func_78906_e()) {
                        nvgj3.field_78927_l = false;
                        continue;
                    }
                    if (nvgj3.isUpdating) {
                        nvgj3.field_78936_t = true;
                        continue;
                    }
                    if (!nvgj3.field_78927_l) continue;
                    if (Config.isOcclusionFancy() && !nvgj3.isInFrustrumFully) {
                        nvgj3.field_78936_t = true;
                        continue;
                    }
                    if (!nvgj3.field_78927_l || nvgj3.field_78935_u) continue;
                    if (nvgj3.isVisibleFromPosition) {
                        f7 = Math.abs((float)(nvgj3.visibleFromX - entityLivingBase.field_70165_t));
                        f4 = f7 + (f6 = Math.abs((float)(nvgj3.visibleFromY - entityLivingBase.field_70163_u))) + (f5 = Math.abs((float)(nvgj3.visibleFromZ - entityLivingBase.field_70161_v)));
                        if ((double)f4 < 10.0 + (double)i / 1000.0) {
                            nvgj3.field_78936_t = true;
                            continue;
                        }
                        nvgj3.isVisibleFromPosition = false;
                    }
                    f7 = (float)((double)nvgj3.field_78918_f - d2);
                    f6 = (float)((double)nvgj3.field_78919_g - d3);
                    f5 = (float)((double)nvgj3.field_78931_h - d4);
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
                    ARBOcclusionQuery.glBeginQueryARB(35092, nvgj3.field_78934_v);
                    tfsl.disableTerrainShader();
                    nvgj3.drawOcclusionQueryAABB();
                    tfsl.enableTerrainShader(n);
                    ARBOcclusionQuery.glEndQueryARB(35092);
                    fokl2._b();
                    nvgj3.field_78935_u = true;
                    ++n5;
                }
                GL11.glPopMatrix();
                if (this._r._M.field_74337_g) {
                    if (tfsl.field_78515_b == 0) {
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
            nvgj nvgj2 = this._k.get(i);
            if (!nvgj2.field_78935_u) continue;
            this._P.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(nvgj2.field_78934_v, 34919, this._P);
            if (this._P.get(0) == 0) continue;
            nvgj2.field_78935_u = false;
            this._P.clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(nvgj2.field_78934_v, 34918, this._P);
            boolean bl = nvgj2.field_78936_t;
            boolean bl2 = nvgj2.field_78936_t = this._P.get(0) > 0;
            if (!bl || !nvgj2.field_78936_t) continue;
            nvgj2.isVisibleFromPosition = true;
            nvgj2.visibleFromX = d;
            nvgj2.visibleFromY = d2;
            nvgj2.visibleFromZ = d3;
        }
    }

    public int _a(int n, int n2, int n3, double d) {
        if (n3 == 0) {
            GL11.glAlphaFunc(516, 0.4f);
        } else {
            GL11.glAlphaFunc(516, 0.01f);
        }
        int n4 = 0;
        boolean bl = this._r._M.field_74330_P;
        if (Config.isFogOff() && this._r._D.fogStandard) {
            GL11.glDisable(2912);
        }
        EntityLivingBase entityLivingBase = this._r._u;
        double d2 = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * d;
        double d3 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * d;
        double d4 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * d;
        this._r._D.func_78463_b(d);
        for (int i = n; i < n2; ++i) {
            nvgj nvgj2 = this._k.get(i);
            if (bl && n3 == 0) {
                ++this._Q;
                if (nvgj2.field_78928_m[n3]) {
                    ++this._U;
                } else if (!nvgj2.field_78927_l) {
                    ++this._R;
                } else if (this._u && !nvgj2.field_78936_t) {
                    ++this._S;
                } else {
                    ++this._T;
                }
            }
            if (!nvgj2.field_78927_l || nvgj2.field_78928_m[n3] || this._u && !nvgj2.field_78936_t) continue;
            double d5 = d2 - (double)nvgj2.field_78923_c;
            double d6 = d3 - (double)nvgj2.field_78920_d;
            double d7 = d4 - (double)nvgj2.field_78921_e;
            if (tfsl.useShader) {
                GL20.glUniform3f(tfsl.chunkPosLoc, (float)d5, (float)d6, (float)d7);
            } else {
                GL11.glPushMatrix();
                GL11.glTranslated(-d5, -d6, -d7);
            }
            nvgj2.callForRenderPass(n3);
            if (!tfsl.useShader) {
                GL11.glPopMatrix();
            }
            ++n4;
        }
        if (n4 > 0) {
            ChunkVboRenderer.disableVertexAttribsDirectly();
            GL15.glBindBuffer(34962, 0);
        }
        this._r._D.func_78483_a(d);
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
            rrte rrte2;
            Object object;
            if (Reflector.ForgeWorldProvider_getCloudRenderer.exists() && (object = Reflector.call(rrte2 = this._r._r.field_73011_w, Reflector.ForgeWorldProvider_getCloudRenderer, new Object[0])) != null) {
                Reflector.callVoid(object, Reflector.IRenderHandler_render, Float.valueOf(f), this._f, this._r);
                return;
            }
            if (this._r._r.field_73011_w._d()) {
                if (Config.isCloudsFancy()) {
                    this._c(f);
                } else {
                    float f2;
                    GL11.glDisable(2884);
                    float f3 = (float)(this._r._u.field_70137_T + (this._r._u.field_70163_u - this._r._u.field_70137_T) * (double)f);
                    int n = 32;
                    int n2 = 256 / n;
                    htvf htvf2 = htvf.field_78398_a;
                    this._g._a(_c);
                    GL11.glEnable(3042);
                    GL11.glBlendFunc(770, 771);
                    ofbx ofbx2 = this._f.func_72824_f(f);
                    float f4 = (float)ofbx2._c;
                    float f5 = (float)ofbx2._d;
                    float f6 = (float)ofbx2._e;
                    if (this._r._M.field_74337_g) {
                        f2 = (f4 * 30.0f + f5 * 59.0f + f6 * 11.0f) / 100.0f;
                        float f7 = (f4 * 30.0f + f5 * 70.0f) / 100.0f;
                        float f8 = (f4 * 30.0f + f6 * 70.0f) / 100.0f;
                        f4 = f2;
                        f5 = f7;
                        f6 = f8;
                    }
                    f2 = 4.8828125E-4f;
                    double d = (float)this._v + f;
                    double d2 = this._r._u.field_70169_q + (this._r._u.field_70165_t - this._r._u.field_70169_q) * (double)f + d * (double)0.03f;
                    double d3 = this._r._u.field_70166_s + (this._r._u.field_70161_v - this._r._u.field_70166_s) * (double)f;
                    int n3 = sajh._c(d2 / 2048.0);
                    int n4 = sajh._c(d3 / 2048.0);
                    float f9 = this._f.field_73011_w._f() - f3 + 0.33f;
                    f9 += this._r._M.ofCloudsHeight * 128.0f;
                    float f10 = (float)((d2 -= (double)(n3 * 2048)) * (double)f2);
                    float f11 = (float)((d3 -= (double)(n4 * 2048)) * (double)f2);
                    htvf2.func_78382_b();
                    htvf2.func_78369_a(f4, f5, f6, 0.8f);
                    for (int i = -n * n2; i < n * n2; i += n) {
                        for (int j = -n * n2; j < n * n2; j += n) {
                            htvf2.func_78374_a(i + 0, f9, j + n, (float)(i + 0) * f2 + f10, (float)(j + n) * f2 + f11);
                            htvf2.func_78374_a(i + n, f9, j + n, (float)(i + n) * f2 + f10, (float)(j + n) * f2 + f11);
                            htvf2.func_78374_a(i + n, f9, j + 0, (float)(i + n) * f2 + f10, (float)(j + 0) * f2 + f11);
                            htvf2.func_78374_a(i + 0, f9, j + 0, (float)(i + 0) * f2 + f10, (float)(j + 0) * f2 + f11);
                        }
                    }
                    htvf2.func_78381_a();
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
        float f5 = (float)(this._r._u.field_70137_T + (this._r._u.field_70163_u - this._r._u.field_70137_T) * (double)f);
        htvf htvf2 = htvf.field_78398_a;
        float f6 = 12.0f;
        float f7 = 4.0f;
        double d = (float)this._v + f;
        double d2 = (this._r._u.field_70169_q + (this._r._u.field_70165_t - this._r._u.field_70169_q) * (double)f + d * (double)0.03f) / (double)f6;
        double d3 = (this._r._u.field_70166_s + (this._r._u.field_70161_v - this._r._u.field_70166_s) * (double)f) / (double)f6 + (double)0.33f;
        float f8 = this._f.field_73011_w._f() - f5 + 0.33f;
        f8 += this._r._M.ofCloudsHeight * 128.0f;
        int n = sajh._c(d2 / 2048.0);
        int n2 = sajh._c(d3 / 2048.0);
        d2 -= (double)(n * 2048);
        d3 -= (double)(n2 * 2048);
        this._g._a(_c);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        ofbx ofbx2 = this._f.func_72824_f(f);
        float f9 = (float)ofbx2._c;
        float f10 = (float)ofbx2._d;
        float f11 = (float)ofbx2._e;
        if (this._r._M.field_74337_g) {
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
            } else if (this._r._M.field_74337_g) {
                if (tfsl.field_78515_b == 0) {
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
                    htvf2.func_78382_b();
                    float f15 = j * n3;
                    float f16 = k * n3;
                    float f17 = f15 - f12;
                    float f18 = f16 - f13;
                    if (f8 > -f7 - 1.0f) {
                        htvf2.func_78369_a(f9 * 0.7f, f10 * 0.7f, f11 * 0.7f, 0.8f);
                        htvf2.func_78375_b(0.0f, -1.0f, 0.0f);
                        htvf2.func_78374_a(f17 + 0.0f, f8 + 0.0f, f18 + (float)n3, (f15 + 0.0f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                        htvf2.func_78374_a(f17 + (float)n3, f8 + 0.0f, f18 + (float)n3, (f15 + (float)n3) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                        htvf2.func_78374_a(f17 + (float)n3, f8 + 0.0f, f18 + 0.0f, (f15 + (float)n3) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                        htvf2.func_78374_a(f17 + 0.0f, f8 + 0.0f, f18 + 0.0f, (f15 + 0.0f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                    }
                    if (f8 <= f7 + 1.0f) {
                        htvf2.func_78369_a(f9, f10, f11, 0.8f);
                        htvf2.func_78375_b(0.0f, 1.0f, 0.0f);
                        htvf2.func_78374_a(f17 + 0.0f, f8 + f7 - f14, f18 + (float)n3, (f15 + 0.0f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                        htvf2.func_78374_a(f17 + (float)n3, f8 + f7 - f14, f18 + (float)n3, (f15 + (float)n3) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                        htvf2.func_78374_a(f17 + (float)n3, f8 + f7 - f14, f18 + 0.0f, (f15 + (float)n3) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                        htvf2.func_78374_a(f17 + 0.0f, f8 + f7 - f14, f18 + 0.0f, (f15 + 0.0f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                    }
                    htvf2.func_78369_a(f9 * 0.9f, f10 * 0.9f, f11 * 0.9f, 0.8f);
                    if (j > -1) {
                        htvf2.func_78375_b(-1.0f, 0.0f, 0.0f);
                        for (n5 = 0; n5 < n3; ++n5) {
                            htvf2.func_78374_a(f17 + (float)n5 + 0.0f, f8 + 0.0f, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                            htvf2.func_78374_a(f17 + (float)n5 + 0.0f, f8 + f7, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                            htvf2.func_78374_a(f17 + (float)n5 + 0.0f, f8 + f7, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                            htvf2.func_78374_a(f17 + (float)n5 + 0.0f, f8 + 0.0f, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                        }
                    }
                    if (j <= 1) {
                        htvf2.func_78375_b(1.0f, 0.0f, 0.0f);
                        for (n5 = 0; n5 < n3; ++n5) {
                            htvf2.func_78374_a(f17 + (float)n5 + 1.0f - f14, f8 + 0.0f, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                            htvf2.func_78374_a(f17 + (float)n5 + 1.0f - f14, f8 + f7, f18 + (float)n3, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + (float)n3) * f2 + f3);
                            htvf2.func_78374_a(f17 + (float)n5 + 1.0f - f14, f8 + f7, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                            htvf2.func_78374_a(f17 + (float)n5 + 1.0f - f14, f8 + 0.0f, f18 + 0.0f, (f15 + (float)n5 + 0.5f) * f2 + f4, (f16 + 0.0f) * f2 + f3);
                        }
                    }
                    htvf2.func_78369_a(f9 * 0.8f, f10 * 0.8f, f11 * 0.8f, 0.8f);
                    if (k > -1) {
                        htvf2.func_78375_b(0.0f, 0.0f, -1.0f);
                        for (n5 = 0; n5 < n3; ++n5) {
                            htvf2.func_78374_a(f17 + 0.0f, f8 + f7, f18 + (float)n5 + 0.0f, (f15 + 0.0f) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            htvf2.func_78374_a(f17 + (float)n3, f8 + f7, f18 + (float)n5 + 0.0f, (f15 + (float)n3) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            htvf2.func_78374_a(f17 + (float)n3, f8 + 0.0f, f18 + (float)n5 + 0.0f, (f15 + (float)n3) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            htvf2.func_78374_a(f17 + 0.0f, f8 + 0.0f, f18 + (float)n5 + 0.0f, (f15 + 0.0f) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                        }
                    }
                    if (k <= 1) {
                        htvf2.func_78375_b(0.0f, 0.0f, 1.0f);
                        for (n5 = 0; n5 < n3; ++n5) {
                            htvf2.func_78374_a(f17 + 0.0f, f8 + f7, f18 + (float)n5 + 1.0f - f14, (f15 + 0.0f) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            htvf2.func_78374_a(f17 + (float)n3, f8 + f7, f18 + (float)n5 + 1.0f - f14, (f15 + (float)n3) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            htvf2.func_78374_a(f17 + (float)n3, f8 + 0.0f, f18 + (float)n5 + 1.0f - f14, (f15 + (float)n3) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                            htvf2.func_78374_a(f17 + 0.0f, f8 + 0.0f, f18 + (float)n5 + 1.0f - f14, (f15 + 0.0f) * f2 + f4, (f16 + (float)n5 + 0.5f) * f2 + f3);
                        }
                    }
                    htvf2.func_78381_a();
                }
            }
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3042);
        GL11.glEnable(2884);
    }

    public boolean _a(nvgj nvgj2) {
        boolean bl = true;
        this.__aj[0] = this._f.func_72964_e(nvgj2.field_78923_c / 16, nvgj2.field_78921_e / 16 + 1);
        this.__aj[1] = this._f.func_72964_e(nvgj2.field_78923_c / 16, nvgj2.field_78921_e / 16 - 1);
        this.__aj[2] = this._f.func_72964_e(nvgj2.field_78923_c / 16 - 1, nvgj2.field_78921_e / 16);
        this.__aj[3] = this._f.func_72964_e(nvgj2.field_78923_c / 16 + 1, nvgj2.field_78921_e / 16);
        for (int i = 0; i < 4; ++i) {
            ixzi ixzi2 = this.__aj[i];
            if (ixzi2 != null && ixzi2._f) continue;
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
        nvgj nvgj2 = null;
        float f = Float.MAX_VALUE;
        int n5 = -1;
        for (int i = 0; i < this._h.size(); ++i) {
            nvgj nvgj3 = (nvgj)this._h.get(i);
            if (nvgj3 == null) continue;
            ++n4;
            if (!nvgj3.field_78939_q) {
                this._h.set(i, null);
                continue;
            }
            float f2 = nvgj3.func_78912_a(entityLivingBase);
            if (!this._a(nvgj3)) continue;
            if (f2 <= 256.0f && this._i()) {
                nvgj3.func_78907_a();
                nvgj3.field_78939_q = false;
                this._h.set(i, null);
                ++n;
                continue;
            }
            if (f2 > 256.0f && n >= n2) break;
            if (!nvgj3.field_78927_l) {
                f2 *= (float)n3;
            }
            if (nvgj2 == null) {
                nvgj2 = nvgj3;
                f = f2;
                n5 = i;
                continue;
            }
            if (!(f2 < f)) continue;
            nvgj2 = nvgj3;
            f = f2;
            n5 = i;
        }
        if (nvgj2 != null) {
            nvgj2.func_78907_a();
            nvgj2.field_78939_q = false;
            this._h.set(n5, null);
            ++n;
            float f3 = f / 5.0f;
            for (int i = 0; i < this._h.size() && n < n2; ++i) {
                float f4;
                nvgj nvgj4 = (nvgj)this._h.get(i);
                if (nvgj4 == null) continue;
                float f5 = nvgj4.func_78912_a(entityLivingBase);
                if (!nvgj4.field_78927_l) {
                    f5 *= (float)n3;
                }
                if (!((f4 = Math.abs(f5 - f)) < f3)) continue;
                nvgj4.func_78907_a();
                nvgj4.field_78939_q = false;
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

    public void _a(htvf htvf2, EntityPlayer entityPlayer, float f) {
        this._a(htvf2, (EntityLivingBase)entityPlayer, f);
    }

    public void _a(htvf htvf2, EntityLivingBase entityLivingBase, float f) {
        double d = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * (double)f;
        double d2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * (double)f;
        double d3 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * (double)f;
        if (!this._I.isEmpty()) {
            GL11.glBlendFunc(774, 768);
            this._g._a(sctd._c);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            GL11.glPushMatrix();
            GL11.glDisable(3008);
            GL11.glPolygonOffset(-3.0f, -3.0f);
            GL11.glEnable(32823);
            GL11.glEnable(3008);
            htvf2.func_78382_b();
            htvf2.func_78373_b(-d, -d2, -d3);
            htvf2.func_78383_c();
            Iterator iterator2 = this._I.values().iterator();
            while (iterator2.hasNext()) {
                twgu twgu2;
                double d4;
                double d5;
                yeay yeay2 = (yeay)iterator2.next();
                double d6 = (double)yeay2._a() - d;
                if (d6 * d6 + (d5 = (double)yeay2._b() - d2) * d5 + (d4 = (double)yeay2._c() - d3) * d4 > 1024.0) {
                    iterator2.remove();
                    continue;
                }
                int n = this._f.func_72798_a(yeay2._a(), yeay2._b(), yeay2._c());
                twgu twgu3 = twgu2 = n > 0 ? twgu.field_71973_m[n] : null;
                if (twgu2 == null) {
                    twgu2 = twgu.field_71981_t;
                }
                this._s._a(twgu2, yeay2._a(), yeay2._b(), yeay2._c(), this._J[yeay2._d()]);
            }
            htvf2.func_78381_a();
            htvf2.func_78373_b(0.0, 0.0, 0.0);
            GL11.glDisable(3008);
            GL11.glPolygonOffset(0.0f, 0.0f);
            GL11.glDisable(32823);
            GL11.glEnable(3008);
            GL11.glDepthMask(true);
            GL11.glPopMatrix();
        }
    }

    public void _a(EntityPlayer entityPlayer, hank hank2, int n, float f) {
        if (n == 0 && hank2._c == amww._a) {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.4f);
            GL11.glLineWidth(2.0f);
            GL11.glDisable(3553);
            GL11.glDepthMask(false);
            float f2 = 0.002f;
            int n2 = this._f.func_72798_a(hank2._d, hank2._e, hank2._f);
            if (n2 > 0) {
                twgu.field_71973_m[n2].func_71902_a(this._f, hank2._d, hank2._e, hank2._f);
                double d = entityPlayer.field_70142_S + (entityPlayer.field_70165_t - entityPlayer.field_70142_S) * (double)f;
                double d2 = entityPlayer.field_70137_T + (entityPlayer.field_70163_u - entityPlayer.field_70137_T) * (double)f;
                double d3 = entityPlayer.field_70136_U + (entityPlayer.field_70161_v - entityPlayer.field_70136_U) * (double)f;
                this._a(twgu.field_71973_m[n2].func_71911_a_(this._f, hank2._d, hank2._e, hank2._f)._b(f2, f2, f2)._c(-d, -d2, -d3));
            }
            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glDisable(3042);
        }
    }

    public void _a(eidj eidj2) {
        htvf htvf2 = htvf.field_78398_a;
        htvf2.func_78371_b(3);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._d);
        htvf2.func_78381_a();
        htvf2.func_78371_b(3);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._d);
        htvf2.func_78381_a();
        htvf2.func_78371_b(1);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._d);
        htvf2.func_78377_a(eidj2._e, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._e, eidj2._f, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._c, eidj2._g);
        htvf2.func_78377_a(eidj2._b, eidj2._f, eidj2._g);
        htvf2.func_78381_a();
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
                    nvgj nvgj2;
                    int n16 = k % this._p;
                    if (n16 < 0) {
                        n16 += this._p;
                    }
                    if ((nvgj2 = this._j[n15 = (n16 * this._o + n14) * this._n + n13]) == null || nvgj2.field_78939_q) continue;
                    int n17 = nvgj2.field_78923_c / 16;
                    int n18 = nvgj2.field_78921_e / 16;
                    if (n17 < n7 || n17 > n10 || n18 < n9 || n18 > n12) continue;
                    this._h.add(nvgj2);
                    nvgj2.func_78914_f();
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
            nvgj nvgj2 = this._k.get(i);
            nvgj2.func_78908_a(lpai2);
        }
        ++this.__ab;
    }

    @Override
    public void _a(String string, int n, int n2, int n3) {
        kmmn kmmn2 = kmmn._a(string);
        if (string != null && kmmn2 != null) {
            this._r._J.func_73833_a(kmmn2._a());
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
            CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception while adding particle");
            jxsn jxsn2 = crashReport.func_85058_a("Particle being added");
            jxsn2._a("Name", string);
            jxsn2._a("Position", new nvdp(this, d, d2, d3));
            throw new turb(crashReport);
        }
    }

    public EntityFX _b(String string, double d, double d2, double d3, double d4, double d5, double d6) {
        if (this._r != null && this._r._u != null && this._r._w != null) {
            int n = this._r._M.field_74362_aa;
            if (n == 1 && this._f.field_73012_v.nextInt(3) == 0) {
                n = 2;
            }
            double d7 = this._r._u.field_70165_t - d;
            double d8 = this._r._u.field_70163_u - d2;
            double d9 = this._r._u.field_70161_v - d3;
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
                entityFX.func_70538_b(entityFX.func_70534_d() * 0.3f, entityFX.func_70542_f() * 0.8f, entityFX.func_70535_g());
                entityFX.func_94053_h();
            } else if (string.equals("smoke")) {
                if (Config.isAnimatedSmoke()) {
                    entityFX = new EntitySmokeFX(this._f, d, d2, d3, d4, d5, d6);
                }
            } else if (string.equals("mobSpell")) {
                if (Config.isPotionParticles()) {
                    entityFX = new EntitySpellParticleFX(this._f, d, d2, d3, 0.0, 0.0, 0.0);
                    entityFX.func_70538_b((float)d4, (float)d5, (float)d6);
                }
            } else if (string.equals("mobSpellAmbient")) {
                if (Config.isPotionParticles()) {
                    entityFX = new EntitySpellParticleFX(this._f, d, d2, d3, 0.0, 0.0, 0.0);
                    entityFX.func_82338_g(0.15f);
                    entityFX.func_70538_b((float)d4, (float)d5, (float)d6);
                }
            } else if (string.equals("spell")) {
                if (Config.isPotionParticles()) {
                    entityFX = new EntitySpellParticleFX(this._f, d, d2, d3, d4, d5, d6);
                }
            } else if (string.equals("instantSpell")) {
                if (Config.isPotionParticles()) {
                    entityFX = new EntitySpellParticleFX(this._f, d, d2, d3, d4, d5, d6);
                    ((EntitySpellParticleFX)entityFX).func_70589_b(144);
                }
            } else if (string.equals("witchMagic")) {
                if (Config.isPotionParticles()) {
                    entityFX = new EntitySpellParticleFX(this._f, d, d2, d3, d4, d5, d6);
                    ((EntitySpellParticleFX)entityFX).func_70589_b(144);
                    float f = this._f.field_73012_v.nextFloat() * 0.5f + 0.35f;
                    entityFX.func_70538_b(1.0f * f, 0.0f * f, 1.0f * f);
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
                    entityFX = new EntityReddustFX((ozlu)this._f, d, d2, d3, (float)d4, (float)d5, (float)d6);
                    CustomColorizer.updateReddustFX(entityFX, this._f, d7, d8, d9);
                }
            } else if (string.equals("snowballpoof")) {
                entityFX = new EntityBreakingFX(this._f, d, d2, d3, tgdv.field_77768_aD);
            } else if (string.equals("dripWater")) {
                if (Config.isDrippingWaterLava()) {
                    entityFX = new EntityDropParticleFX(this._f, d, d2, d3, tflj._h);
                }
            } else if (string.equals("dripLava")) {
                if (Config.isDrippingWaterLava()) {
                    entityFX = new EntityDropParticleFX(this._f, d, d2, d3, tflj._i);
                }
            } else if (string.equals("snowshovel")) {
                entityFX = new EntitySnowShovelFX(this._f, d, d2, d3, d4, d5, d6);
            } else if (string.equals("slime")) {
                entityFX = new EntityBreakingFX(this._f, d, d2, d3, tgdv.field_77761_aM);
            } else if (string.equals("heart")) {
                entityFX = new EntityHeartFX(this._f, d, d2, d3, d4, d5, d6);
            } else if (string.equals("angryVillager")) {
                entityFX = new EntityHeartFX(this._f, d, d2 + 0.5, d3, d4, d5, d6);
                entityFX.func_70536_a(81);
                entityFX.func_70538_b(1.0f, 1.0f, 1.0f);
            } else if (string.equals("happyVillager")) {
                entityFX = new EntityAuraFX(this._f, d, d2, d3, d4, d5, d6);
                entityFX.func_70536_a(82);
                entityFX.func_70538_b(1.0f, 1.0f, 1.0f);
            } else if (string.startsWith("iconcrack_")) {
                String[] stringArray = string.split("_", 3);
                int n2 = Integer.parseInt(stringArray[1]);
                if (stringArray.length > 2) {
                    int n3 = Integer.parseInt(stringArray[2]);
                    entityFX = new EntityBreakingFX(this._f, d, d2, d3, d4, d5, d6, tgdv.field_77698_e[n2], n3);
                } else {
                    entityFX = new EntityBreakingFX(this._f, d, d2, d3, d4, d5, d6, tgdv.field_77698_e[n2], 0);
                }
            } else if (string.startsWith("tilecrack_")) {
                String[] stringArray = string.split("_", 3);
                int n4 = Integer.parseInt(stringArray[1]);
                int n5 = Integer.parseInt(stringArray[2]);
                entityFX = new EntityDiggingFX(this._f, d, d2, d3, d4, d5, d6, twgu.field_71973_m[n4], n5).func_90019_g(n5);
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
        Random random = this._f.field_73012_v;
        switch (n) {
            case 1013: 
            case 1018: {
                if (this._r._u == null) break;
                double d = (double)n2 - this._r._u.field_70165_t;
                double d2 = (double)n3 - this._r._u.field_70163_u;
                double d3 = (double)n4 - this._r._u.field_70161_v;
                double d4 = Math.sqrt(d * d + d2 * d2 + d3 * d3);
                double d5 = this._r._u.field_70165_t;
                double d6 = this._r._u.field_70163_u;
                double d7 = this._r._u.field_70161_v;
                if (d4 > 0.0) {
                    d5 += d / d4 * 2.0;
                    d6 += d2 / d4 * 2.0;
                    d7 += d3 / d4 * 2.0;
                }
                if (n == 1013) {
                    this._f.func_72980_b(d5, d6, d7, "mob.wither.spawn", 1.0f, 1.0f, false);
                    break;
                }
                if (n != 1018) break;
                this._f.func_72980_b(d5, d6, d7, "mob.enderdragon.end", 5.0f, 1.0f, false);
            }
        }
    }

    @Override
    public void _a(EntityPlayer entityPlayer, int n, int n2, int n3, int n4, int n5) {
        Random random = this._f.field_73012_v;
        switch (n) {
            case 1000: {
                this._f.func_72980_b(n2, n3, n4, "random.click", 1.0f, 1.0f, false);
                break;
            }
            case 1001: {
                this._f.func_72980_b(n2, n3, n4, "random.click", 1.0f, 1.2f, false);
                break;
            }
            case 1002: {
                this._f.func_72980_b(n2, n3, n4, "random.bow", 1.0f, 1.2f, false);
                break;
            }
            case 1003: {
                if (Math.random() < 0.5) {
                    this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.door_open", 1.0f, this._f.field_73012_v.nextFloat() * 0.1f + 0.9f, false);
                    break;
                }
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.door_close", 1.0f, this._f.field_73012_v.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1004: {
                this._f.func_72980_b((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, "random.fizz", 0.5f, 2.6f + (random.nextFloat() - random.nextFloat()) * 0.8f, false);
                break;
            }
            case 1005: {
                if (tgdv.field_77698_e[n5] instanceof kmmn) {
                    this._f.func_72934_a(((kmmn)tgdv.field_77698_e[n5])._b, n2, n3, n4);
                    break;
                }
                this._f.func_72934_a(null, n2, n3, n4);
                break;
            }
            case 1007: {
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.ghast.charge", 10.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1008: {
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.ghast.fireball", 10.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1009: {
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.ghast.fireball", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1010: {
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.zombie.wood", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1011: {
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.zombie.metal", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1012: {
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.zombie.woodbreak", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1014: {
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.wither.shoot", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1015: {
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.bat.takeoff", 0.05f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1016: {
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.zombie.infect", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1017: {
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "mob.zombie.unfect", 2.0f, (random.nextFloat() - random.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1020: {
                this._f.func_72980_b((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, "random.anvil_break", 1.0f, this._f.field_73012_v.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1021: {
                this._f.func_72980_b((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, "random.anvil_use", 1.0f, this._f.field_73012_v.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1022: {
                this._f.func_72980_b((float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, "random.anvil_land", 0.3f, this._f.field_73012_v.nextFloat() * 0.1f + 0.9f, false);
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
                    twgu twgu2 = twgu.field_71973_m[n8];
                    this._r._N._a(twgu2.field_72020_cn._c(), (float)n2 + 0.5f, (float)n3 + 0.5f, (float)n4 + 0.5f, (twgu2.field_72020_cn._a() + 1.0f) / 2.0f, twgu2.field_72020_cn._b() * 0.8f);
                }
                this._r._w._a(n2, n3, n4, n5 & 0xFFF, n5 >> 12 & 0xFF);
                break;
            }
            case 2002: {
                int n9;
                double d = n2;
                double d11 = n3;
                double d12 = n4;
                String string = "iconcrack_" + tgdv.field_77726_bs.field_77779_bT + "_" + n5;
                for (n9 = 0; n9 < 8; ++n9) {
                    this._a(string, d, d11, d12, random.nextGaussian() * 0.15, random.nextDouble() * 0.2, random.nextGaussian() * 0.15);
                }
                n9 = tgdv.field_77726_bs._c(n5);
                float f = (float)(n9 >> 16 & 0xFF) / 255.0f;
                float f2 = (float)(n9 >> 8 & 0xFF) / 255.0f;
                float f3 = (float)(n9 >> 0 & 0xFF) / 255.0f;
                String string2 = "spell";
                if (tgdv.field_77726_bs._d(n5)) {
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
                    entityFX.func_70538_b(f * f4, f2 * f4, f3 * f4);
                    entityFX.func_70543_e((float)d13);
                }
                this._f.func_72980_b((double)n2 + 0.5, (double)n3 + 0.5, (double)n4 + 0.5, "random.glass", 1.0f, this._f.field_73012_v.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2003: {
                double d = (double)n2 + 0.5;
                double d18 = n3;
                double d19 = (double)n4 + 0.5;
                String string = "iconcrack_" + tgdv.field_77748_bA.field_77779_bT;
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
                    double d = (double)n2 + 0.5 + ((double)this._f.field_73012_v.nextFloat() - 0.5) * 2.0;
                    double d21 = (double)n3 + 0.5 + ((double)this._f.field_73012_v.nextFloat() - 0.5) * 2.0;
                    double d22 = (double)n4 + 0.5 + ((double)this._f.field_73012_v.nextFloat() - 0.5) * 2.0;
                    this._f.func_72869_a("smoke", d, d21, d22, 0.0, 0.0, 0.0);
                    this._f.func_72869_a("flame", d, d21, d22, 0.0, 0.0, 0.0);
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

    public void _a(nege nege2) {
        this._J = new dwan[10];
        for (int i = 0; i < this._J.length; ++i) {
            this._J[i] = nege2._b("destroy_stage_" + i);
        }
    }

    public void _g() {
        if (this._j != null) {
            for (int i = 0; i < this._j.length; ++i) {
                this._j[i].field_78936_t = true;
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
        return entityLivingBase.field_70703_bu || entityLivingBase.func_70093_af() || (double)entityLivingBase.field_70732_aI > d || this._r._O._a != 0 || this._r._O._b != 0 || Math.abs(entityLivingBase.field_70165_t - entityLivingBase.field_70169_q) > d || Math.abs(entityLivingBase.field_70163_u - entityLivingBase.field_70167_r) > d || Math.abs(entityLivingBase.field_70161_v - entityLivingBase.field_70166_s) > d;
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
            List list = this._f.field_73010_i;
            for (int i = 0; i < list.size(); ++i) {
                Entity entity = (Entity)list.get(i);
                if (!(entity instanceof AbstractClientPlayer)) continue;
                AbstractClientPlayer abstractClientPlayer = (AbstractClientPlayer)entity;
                abstractClientPlayer.func_110310_o()._g = bl;
            }
        }
    }

    public eidj _a(hurg hurg2) {
        twgu twgu2 = hurg2.func_70311_o();
        if (twgu2 == null) {
            return hurg.INFINITE_EXTENT_AABB;
        }
        return eidj._a()._a((double)hurg2.field_70329_l + twgu2.field_72026_ch - 2.0, (double)hurg2.field_70330_m + twgu2.field_72023_ci - 2.0, (double)hurg2.field_70327_n + twgu2.field_72024_cj - 2.0, (double)hurg2.field_70329_l + twgu2.field_72021_ck + 2.0, (double)hurg2.field_70330_m + twgu2.field_72022_cl + 2.0, (double)hurg2.field_70327_n + twgu2.field_72019_cm + 2.0);
    }
}

