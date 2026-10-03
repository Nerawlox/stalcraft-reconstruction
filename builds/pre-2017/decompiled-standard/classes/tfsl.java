/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.core.entity.jxtc;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.effects.client.main.ugqx;
import gloomyfolken.mods.ejection.ezey;
import gloomyfolken.mods.ktcore.VecExtensionsKt;
import gloomyfolken.mods.stalker.misc.qlgf;
import java.lang.reflect.Field;
import java.nio.FloatBuffer;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import mcoptifine.Config;
import mcoptifine.CustomColorizer;
import mcoptifine.McChunkCommandQueue;
import mcoptifine.RandomMobs;
import mcoptifine.Reflector;
import mcoptifine.TextureUtils;
import mcoptifine.WrUpdates;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.particle.EntityRainFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.particle.kjui;
import net.minecraft.client.xpzm;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.jxsn;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.hank;
import net.minecraft.util.ofbx;
import net.minecraft.util.sajh;
import net.minecraft.util.turb;
import net.minecraft.util.wmvj;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.Project;
import znw.mods.stalkerguide.pidb;

public class tfsl {
    public static final ResourceLocation field_110924_q = new ResourceLocation("textures/environment/rain.png");
    public static final ResourceLocation field_110923_r = new ResourceLocation("textures/environment/snow.png");
    public static boolean field_78517_a;
    public static int field_78515_b;
    public xpzm field_78531_r;
    public float field_78530_s;
    public jizq field_78516_c;
    public int field_78529_t;
    public Entity field_78528_u;
    public wmvj field_78527_v = new wmvj();
    public wmvj field_78526_w = new wmvj();
    public wmvj field_78541_x = new wmvj();
    public wmvj field_78540_y = new wmvj();
    public wmvj field_78538_z = new wmvj();
    public wmvj field_78489_A = new wmvj();
    public float field_78490_B = 4.0f;
    public float field_78491_C = 4.0f;
    public float field_78485_D;
    public float field_78486_E;
    public float field_78487_F;
    public float field_78488_G;
    public float field_78496_H;
    public float field_78497_I;
    public float field_78498_J;
    public float field_78499_K;
    public float field_78492_L;
    public float field_78493_M;
    public float field_78494_N;
    public float field_78495_O;
    public float field_78505_P;
    public final sctt field_78513_d;
    public final int[] field_78504_Q;
    public final ResourceLocation field_110922_T;
    public float field_78507_R;
    public float field_78506_S;
    public float field_78501_T;
    public float field_82831_U;
    public float field_82832_V;
    public boolean field_78500_U;
    public double field_78503_V = 1.0;
    public double field_78502_W;
    public double field_78509_X;
    public long field_78508_Y = xpzm._M();
    public long field_78510_Z;
    public boolean field_78536_aa;
    public float field_78514_e;
    public float field_78511_f;
    public float field_78512_g;
    public float field_78524_h;
    public Random field_78537_ab = new Random();
    public int field_78534_ac;
    public float[] field_78525_i;
    public float[] field_78522_j;
    public FloatBuffer field_78521_m = pklh._e(16);
    public float field_78518_n;
    public float field_78519_o;
    public float field_78533_p;
    public float field_78535_ad;
    public float field_78539_ae;
    public int field_78532_q;
    public boolean initialized = false;
    public ozlu updatedWorld = null;
    public boolean showDebugInfo = false;
    public boolean fogStandard = false;
    public long lastServerTime = 0L;
    public int lastServerTicks = 0;
    public int serverWaitTime = 0;
    public int serverWaitTimeCurrent = 0;
    public float avgServerTimeDiff = 0.0f;
    public float avgServerTickDiff = 0.0f;
    public long[] frameTimes = new long[512];
    public long[] tickTimes = new long[512];
    public long[] chunkTimes = new long[512];
    public long[] serverTimes = new long[512];
    public int numRecordedFrameTimes = 0;
    public long prevFrameTimeNano = -1L;
    public boolean lastShowDebugInfo = false;
    public boolean showExtendedDebugInfo = false;
    public static ugqx terrainShader;
    public static boolean useShader;
    public static int interpTicks;
    public static int posLightLoc;
    public static int colorLoc;
    public static int uvLoc;
    public static int normalLoc;
    public static ofbx throwHintPos;
    public static int chunkPosLoc;

    public tfsl(xpzm xpzm2) {
        this.field_78531_r = xpzm2;
        this.field_78516_c = new jizq(xpzm2);
        this.field_78513_d = new sctt(16, 16);
        this.field_110922_T = xpzm2._R()._a("lightMap", this.field_78513_d);
        this.field_78504_Q = this.field_78513_d._b();
    }

    public void func_78464_a() {
        float f;
        float f2;
        this.func_78477_e();
        this.func_78470_f();
        this.field_78535_ad = this.field_78539_ae;
        this.field_78491_C = this.field_78490_B;
        this.field_78486_E = this.field_78485_D;
        this.field_78488_G = this.field_78487_F;
        this.field_78494_N = this.field_78493_M;
        this.field_78505_P = this.field_78495_O;
        if (this.field_78531_r._M.field_74326_T) {
            f2 = this.field_78531_r._M.field_74341_c * 0.6f + 0.2f;
            f = f2 * f2 * f2 * 8.0f;
            this.field_78498_J = this.field_78527_v._a(this.field_78496_H, 0.05f * f);
            this.field_78499_K = this.field_78526_w._a(this.field_78497_I, 0.05f * f);
            this.field_78492_L = 0.0f;
            this.field_78496_H = 0.0f;
            this.field_78497_I = 0.0f;
        }
        if (this.field_78531_r._u == null) {
            this.field_78531_r._u = this.field_78531_r._t;
        }
        f2 = this.field_78531_r._r.func_72801_o(sajh._c(this.field_78531_r._u.field_70165_t), sajh._c(this.field_78531_r._u.field_70163_u), sajh._c(this.field_78531_r._u.field_70161_v));
        f = (float)(3 - this.field_78531_r._M.field_74339_e) / 3.0f;
        float f3 = f2 * (1.0f - f) + f;
        this.field_78539_ae += (f3 - this.field_78539_ae) * 0.1f;
        ++this.field_78529_t;
        this.field_78516_c.func_78441_a();
        this.func_78484_h();
        this.field_82832_V = this.field_82831_U;
        if (net.minecraft.entity.boss.kjui._d) {
            this.field_82831_U += 0.05f;
            if (this.field_82831_U > 1.0f) {
                this.field_82831_U = 1.0f;
            }
            net.minecraft.entity.boss.kjui._d = false;
        } else if (this.field_82831_U > 0.0f) {
            this.field_82831_U -= 0.0125f;
        }
    }

    public void func_78473_a(float f) {
        qlgf._a(this, f);
    }

    public void func_78477_e() {
        if (this.field_78531_r._u instanceof EntityPlayerSP) {
            EntityPlayerSP entityPlayerSP = (EntityPlayerSP)this.field_78531_r._u;
            this.field_78501_T = entityPlayerSP.func_71151_f();
        } else {
            this.field_78501_T = this.field_78531_r._t.func_71151_f();
        }
        this.field_78506_S = this.field_78507_R;
        this.field_78507_R += (this.field_78501_T - this.field_78507_R) * 0.5f;
        if (this.field_78507_R > 1.5f) {
            this.field_78507_R = 1.5f;
        }
        if (this.field_78507_R < 0.1f) {
            this.field_78507_R = 0.1f;
        }
    }

    public float func_78481_a(float f, boolean bl) {
        float f2 = ogqb._a(this, f, bl);
        return f2;
    }

    public void func_78482_e(float f) {
        ogqb._a(this, f);
    }

    public void func_78475_f(float f) {
        if (this.field_78531_r._u instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)this.field_78531_r._u;
            float f2 = entityPlayer.field_70140_Q - entityPlayer.field_70141_P;
            float f3 = -(entityPlayer.field_70140_Q + f2 * f);
            float f4 = entityPlayer.field_71107_bF + (entityPlayer.field_71109_bG - entityPlayer.field_71107_bF) * f;
            float f5 = entityPlayer.field_70727_aS + (entityPlayer.field_70726_aT - entityPlayer.field_70727_aS) * f;
            GL11.glTranslatef(sajh._a(f3 * (float)Math.PI) * f4 * 0.5f, -Math.abs(sajh._b(f3 * (float)Math.PI) * f4), 0.0f);
            GL11.glRotatef(sajh._a(f3 * (float)Math.PI) * f4 * 3.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(Math.abs(sajh._b(f3 * (float)Math.PI - 0.2f) * f4) * 5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(f5, 1.0f, 0.0f, 0.0f);
        }
    }

    public void func_78467_g(float f) {
        GloomyHooks.orientCameraPre(f);
        EntityLivingBase entityLivingBase = this.field_78531_r._u;
        float f2 = entityLivingBase.field_70129_M - 1.62f;
        double d = entityLivingBase.field_70169_q + (entityLivingBase.field_70165_t - entityLivingBase.field_70169_q) * (double)f;
        double d2 = entityLivingBase.field_70167_r + (entityLivingBase.field_70163_u - entityLivingBase.field_70167_r) * (double)f - (double)f2;
        double d3 = entityLivingBase.field_70166_s + (entityLivingBase.field_70161_v - entityLivingBase.field_70166_s) * (double)f;
        GL11.glRotatef(this.field_78505_P + (this.field_78495_O - this.field_78505_P) * f, 0.0f, 0.0f, 1.0f);
        if (entityLivingBase.func_70608_bn()) {
            f2 = (float)((double)f2 + 1.0);
            GL11.glTranslatef(0.0f, 0.3f, 0.0f);
            if (!this.field_78531_r._M.field_74325_U) {
                int n = this.field_78531_r._r.func_72798_a(sajh._c(entityLivingBase.field_70165_t), sajh._c(entityLivingBase.field_70163_u), sajh._c(entityLivingBase.field_70161_v));
                if (Reflector.ForgeHooksClient_orientBedCamera.exists()) {
                    Reflector.callVoid(Reflector.ForgeHooksClient_orientBedCamera, this.field_78531_r, entityLivingBase);
                } else if (n == twgu.field_71959_S.field_71990_ca) {
                    int n2 = this.field_78531_r._r.func_72805_g(sajh._c(entityLivingBase.field_70165_t), sajh._c(entityLivingBase.field_70163_u), sajh._c(entityLivingBase.field_70161_v));
                    int n3 = n2 & 3;
                    GL11.glRotatef(n3 * 90, 0.0f, 1.0f, 0.0f);
                }
                GL11.glRotatef(entityLivingBase.field_70126_B + (entityLivingBase.field_70177_z - entityLivingBase.field_70126_B) * f + 180.0f, 0.0f, -1.0f, 0.0f);
                GL11.glRotatef(entityLivingBase.field_70127_C + (entityLivingBase.field_70125_A - entityLivingBase.field_70127_C) * f, -1.0f, 0.0f, 0.0f);
            }
        } else if (this.field_78531_r._M.field_74320_O > 0) {
            double d4 = this.field_78491_C + (this.field_78490_B - this.field_78491_C) * f;
            if (this.field_78531_r._M.field_74325_U) {
                float f3 = this.field_78486_E + (this.field_78485_D - this.field_78486_E) * f;
                float f4 = this.field_78488_G + (this.field_78487_F - this.field_78488_G) * f;
                GL11.glTranslatef(0.0f, 0.0f, (float)(-d4));
                GL11.glRotatef(f4, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(f3, 0.0f, 1.0f, 0.0f);
            } else {
                float f5 = entityLivingBase.field_70177_z;
                float f6 = entityLivingBase.field_70125_A;
                if (this.field_78531_r._M.field_74320_O == 2) {
                    f6 += 180.0f;
                }
                double d5 = (double)(-sajh._a(f5 / 180.0f * (float)Math.PI) * sajh._b(f6 / 180.0f * (float)Math.PI)) * d4;
                double d6 = (double)(sajh._b(f5 / 180.0f * (float)Math.PI) * sajh._b(f6 / 180.0f * (float)Math.PI)) * d4;
                double d7 = (double)(-sajh._a(f6 / 180.0f * (float)Math.PI)) * d4;
                for (int i = 0; i < 8; ++i) {
                    double d8;
                    float f7 = (i & 1) * 2 - 1;
                    float f8 = (i >> 1 & 1) * 2 - 1;
                    float f9 = (i >> 2 & 1) * 2 - 1;
                    hank hank2 = this.field_78531_r._r.func_72933_a(this.field_78531_r._r.func_82732_R()._a(d + (double)(f7 *= 0.1f), d2 + (double)(f8 *= 0.1f), d3 + (double)(f9 *= 0.1f)), this.field_78531_r._r.func_82732_R()._a(d - d5 + (double)f7 + (double)f9, d2 - d7 + (double)f8, d3 - d6 + (double)f9));
                    if (hank2 == null || !((d8 = hank2._h._d(this.field_78531_r._r.func_82732_R()._a(d, d2, d3))) < d4)) continue;
                    d4 = d8;
                }
                if (this.field_78531_r._M.field_74320_O == 2) {
                    GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                }
                GL11.glRotatef(entityLivingBase.field_70125_A - f6, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(entityLivingBase.field_70177_z - f5, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(0.0f, 0.0f, (float)(-d4));
                GL11.glRotatef(f5 - entityLivingBase.field_70177_z, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(f6 - entityLivingBase.field_70125_A, 1.0f, 0.0f, 0.0f);
            }
        } else {
            GL11.glTranslatef(0.0f, 0.0f, -0.1f);
        }
        if (!this.field_78531_r._M.field_74325_U) {
            GL11.glRotatef(entityLivingBase.field_70127_C + (entityLivingBase.field_70125_A - entityLivingBase.field_70127_C) * f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(entityLivingBase.field_70126_B + (entityLivingBase.field_70177_z - entityLivingBase.field_70126_B) * f + 180.0f, 0.0f, 1.0f, 0.0f);
        }
        GL11.glTranslatef(0.0f, f2, 0.0f);
        d = entityLivingBase.field_70169_q + (entityLivingBase.field_70165_t - entityLivingBase.field_70169_q) * (double)f;
        d2 = entityLivingBase.field_70167_r + (entityLivingBase.field_70163_u - entityLivingBase.field_70167_r) * (double)f - (double)f2;
        d3 = entityLivingBase.field_70166_s + (entityLivingBase.field_70161_v - entityLivingBase.field_70166_s) * (double)f;
        this.field_78500_U = this.field_78531_r._s._a(d, d2, d3, f);
        GloomyHooks.orientCameraPost(f);
    }

    public void func_78479_a(float f, int n) {
        int n2;
        float f2;
        float f3;
        this.field_78530_s = 32 << 3 - this.field_78531_r._M.field_74339_e;
        this.field_78530_s = this.field_78531_r._M.ofRenderDistanceFine;
        if (Config.isFogFancy()) {
            this.field_78530_s *= 0.95f;
        }
        if (Config.isFogFast()) {
            this.field_78530_s *= 0.83f;
        }
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        float f4 = 0.07f;
        if (this.field_78531_r._M.field_74337_g) {
            GL11.glTranslatef((float)(-(n * 2 - 1)) * f4, 0.0f, 0.0f);
        }
        if ((f3 = this.field_78530_s * 2.0f) < 128.0f) {
            f3 = 128.0f;
        }
        if (this.field_78503_V != 1.0) {
            GL11.glTranslatef((float)this.field_78502_W, (float)(-this.field_78509_X), 0.0f);
            GL11.glScaled(this.field_78503_V, this.field_78503_V, 1.0);
        }
        Project.gluPerspective(this.func_78481_a(f, true), (float)this.field_78531_r._n / (float)this.field_78531_r._o, 0.05f, f3);
        if (this.field_78531_r._j._a()) {
            f2 = 0.6666667f;
            GL11.glScalef(1.0f, f2, 1.0f);
        }
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        if (this.field_78531_r._M.field_74337_g) {
            GL11.glTranslatef((float)(n * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        this.func_78482_e(f);
        if (this.field_78531_r._M.field_74336_f) {
            this.func_78475_f(f);
        }
        if ((f2 = this.field_78531_r._t.field_71080_cy + (this.field_78531_r._t.field_71086_bY - this.field_78531_r._t.field_71080_cy) * f) > 0.0f) {
            n2 = 20;
            if (this.field_78531_r._t.func_70644_a(hdpq._k)) {
                n2 = 7;
            }
            float f5 = 5.0f / (f2 * f2 + 5.0f) - f2 * 0.04f;
            f5 *= f5;
            GL11.glRotatef(((float)this.field_78529_t + f) * (float)n2, 0.0f, 1.0f, 1.0f);
            GL11.glScalef(1.0f / f5, 1.0f, 1.0f);
            GL11.glRotatef(-((float)this.field_78529_t + f) * (float)n2, 0.0f, 1.0f, 1.0f);
        }
        this.func_78467_g(f);
        if (this.field_78532_q > 0) {
            n2 = this.field_78532_q - 1;
            if (n2 == 1) {
                GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
            }
            if (n2 == 2) {
                GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
            }
            if (n2 == 3) {
                GL11.glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);
            }
            if (n2 == 4) {
                GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            }
            if (n2 == 5) {
                GL11.glRotatef(-90.0f, 1.0f, 0.0f, 0.0f);
            }
        }
        fmej._c(this, f, n);
    }

    public void func_78476_b(float f, int n) {
        fmej._a(this, f, n);
        GloomyHooks.renderHand(this, f, n);
        if (GloomyHooks.onRenderHand(this, f, n)) {
            fmej._b(this, f, n);
            GloomyHooks.renderHandPost(this, f, n);
            return;
        }
        if (this.field_78532_q <= 0) {
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            float f2 = 0.07f;
            if (this.field_78531_r._M.field_74337_g) {
                GL11.glTranslatef((float)(-(n * 2 - 1)) * f2, 0.0f, 0.0f);
            }
            if (this.field_78503_V != 1.0) {
                GL11.glTranslatef((float)this.field_78502_W, (float)(-this.field_78509_X), 0.0f);
                GL11.glScaled(this.field_78503_V, this.field_78503_V, 1.0);
            }
            Project.gluPerspective(this.func_78481_a(f, false), (float)this.field_78531_r._n / (float)this.field_78531_r._o, 0.05f, this.field_78530_s * 2.0f);
            if (this.field_78531_r._j._a()) {
                float f3 = 0.6666667f;
                GL11.glScalef(1.0f, f3, 1.0f);
            }
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            if (this.field_78531_r._M.field_74337_g) {
                GL11.glTranslatef((float)(n * 2 - 1) * 0.1f, 0.0f, 0.0f);
            }
            GL11.glPushMatrix();
            this.func_78482_e(f);
            if (this.field_78531_r._M.field_74336_f) {
                this.func_78475_f(f);
            }
            if (!(this.field_78531_r._M.field_74320_O != 0 || this.field_78531_r._u.func_70608_bn() || this.field_78531_r._M.field_74319_N || this.field_78531_r._j._a())) {
                this.func_78463_b(f);
                this.field_78516_c.func_78440_a(f);
                this.func_78483_a(f);
            }
            GL11.glPopMatrix();
            if (this.field_78531_r._M.field_74320_O == 0 && !this.field_78531_r._u.func_70608_bn()) {
                this.field_78516_c.func_78447_b(f);
                this.func_78482_e(f);
            }
            if (this.field_78531_r._M.field_74336_f) {
                this.func_78475_f(f);
            }
        }
        fmej._b(this, f, n);
        GloomyHooks.renderHandPost(this, f, n);
    }

    public void func_78483_a(double d) {
        iwya._a(iwya._b);
        GL11.glDisable(3553);
        iwya._a(iwya._a);
    }

    public void func_78463_b(double d) {
        iwya._a(iwya._b);
        GL11.glMatrixMode(5890);
        GL11.glLoadIdentity();
        float f = 0.00390625f;
        GL11.glScalef(f, f, f);
        GL11.glTranslatef(8.0f, 8.0f, 8.0f);
        GL11.glMatrixMode(5888);
        this.field_78531_r._R()._a(this.field_110922_T);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10242, 10496);
        GL11.glTexParameteri(3553, 10243, 10496);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(3553);
        iwya._a(iwya._a);
    }

    public void func_78470_f() {
        this.field_78511_f = (float)((double)this.field_78511_f + (Math.random() - Math.random()) * Math.random() * Math.random());
        this.field_78524_h = (float)((double)this.field_78524_h + (Math.random() - Math.random()) * Math.random() * Math.random());
        this.field_78511_f = (float)((double)this.field_78511_f * 0.9);
        this.field_78524_h = (float)((double)this.field_78524_h * 0.9);
        this.field_78514_e += (this.field_78511_f - this.field_78514_e) * 1.0f;
        this.field_78512_g += (this.field_78524_h - this.field_78512_g) * 1.0f;
        this.field_78536_aa = true;
    }

    public void func_78472_g(float f) {
        pkix pkix2 = this.field_78531_r._r;
        if (pkix2 != null) {
            if (CustomColorizer.updateLightmap(pkix2, this.field_78514_e, this.field_78504_Q, this.field_78531_r._t.func_70644_a(hdpq._r))) {
                this.field_78513_d._a();
                this.field_78536_aa = false;
                return;
            }
            for (int i = 0; i < 256; ++i) {
                float f2;
                float f3;
                float f4 = pkix2.func_72971_b(1.0f) * 0.95f + 0.05f;
                float f5 = pkix2.field_73011_w._h[i / 16] * f4;
                float f6 = pkix2.field_73011_w._h[i % 16] * (this.field_78514_e * 0.1f + 1.5f);
                if (pkix2.field_73016_r > 0) {
                    f5 = pkix2.field_73011_w._h[i / 16];
                }
                float f7 = f5 * (pkix2.func_72971_b(1.0f) * 0.65f + 0.35f);
                float f8 = f5 * (pkix2.func_72971_b(1.0f) * 0.65f + 0.35f);
                float f9 = f6 * ((f6 * 0.6f + 0.4f) * 0.6f + 0.4f);
                float f10 = f6 * (f6 * f6 * 0.6f + 0.4f);
                float f11 = f7 + f6;
                float f12 = f8 + f9;
                float f13 = f5 + f10;
                f11 = f11 * 0.96f + 0.03f;
                f12 = f12 * 0.96f + 0.03f;
                f13 = f13 * 0.96f + 0.03f;
                if (this.field_82831_U > 0.0f) {
                    f3 = this.field_82832_V + (this.field_82831_U - this.field_82832_V) * f;
                    f11 = f11 * (1.0f - f3) + f11 * 0.7f * f3;
                    f12 = f12 * (1.0f - f3) + f12 * 0.6f * f3;
                    f13 = f13 * (1.0f - f3) + f13 * 0.6f * f3;
                }
                if (pkix2.field_73011_w._i == 1) {
                    f11 = 0.22f + f6 * 0.75f;
                    f12 = 0.28f + f9 * 0.75f;
                    f13 = 0.25f + f10 * 0.75f;
                }
                if (this.field_78531_r._t.func_70644_a(hdpq._r)) {
                    f3 = this.func_82830_a(this.field_78531_r._t, f);
                    f2 = 1.0f / f11;
                    if (f2 > 1.0f / f12) {
                        f2 = 1.0f / f12;
                    }
                    if (f2 > 1.0f / f13) {
                        f2 = 1.0f / f13;
                    }
                    f11 = f11 * (1.0f - f3) + f11 * f2 * f3;
                    f12 = f12 * (1.0f - f3) + f12 * f2 * f3;
                    f13 = f13 * (1.0f - f3) + f13 * f2 * f3;
                }
                if (f11 > 1.0f) {
                    f11 = 1.0f;
                }
                if (f12 > 1.0f) {
                    f12 = 1.0f;
                }
                if (f13 > 1.0f) {
                    f13 = 1.0f;
                }
                f3 = this.field_78531_r._M.field_74333_Y;
                f2 = 1.0f - f11;
                float f14 = 1.0f - f12;
                float f15 = 1.0f - f13;
                f2 = 1.0f - f2 * f2 * f2 * f2;
                f14 = 1.0f - f14 * f14 * f14 * f14;
                f15 = 1.0f - f15 * f15 * f15 * f15;
                f11 = f11 * (1.0f - f3) + f2 * f3;
                f12 = f12 * (1.0f - f3) + f14 * f3;
                f13 = f13 * (1.0f - f3) + f15 * f3;
                f11 = f11 * 0.96f + 0.03f;
                f12 = f12 * 0.96f + 0.03f;
                f13 = f13 * 0.96f + 0.03f;
                if (f11 > 1.0f) {
                    f11 = 1.0f;
                }
                if (f12 > 1.0f) {
                    f12 = 1.0f;
                }
                if (f13 > 1.0f) {
                    f13 = 1.0f;
                }
                if (f11 < 0.0f) {
                    f11 = 0.0f;
                }
                if (f12 < 0.0f) {
                    f12 = 0.0f;
                }
                if (f13 < 0.0f) {
                    f13 = 0.0f;
                }
                int n = 255;
                int n2 = (int)(f11 * 255.0f);
                int n3 = (int)(f12 * 255.0f);
                int n4 = (int)(f13 * 255.0f);
                this.field_78504_Q[i] = n << 24 | n2 << 16 | n3 << 8 | n4;
            }
            this.field_78513_d._a();
            this.field_78536_aa = false;
        }
        GloomyHooks.updateLightmap(f);
    }

    public float func_82830_a(EntityPlayer entityPlayer, float f) {
        int n = entityPlayer.func_70660_b(hdpq._r)._b();
        return n > 200 ? 1.0f : 0.7f + sajh._a(((float)n - f) * (float)Math.PI * 0.2f) * 0.3f;
    }

    public void func_78480_b(float f) {
        int n;
        this.field_78531_r.__ah._a("lightTex");
        if (!this.initialized) {
            TextureUtils.registerResourceListener();
            this.initialized = true;
        }
        Config.checkDisplayMode();
        pkix pkix2 = this.field_78531_r._r;
        if (pkix2 != null && Config.getNewRelease() != null) {
            String string = "HD_U " + Config.getNewRelease();
            this.field_78531_r._J.func_73827_b()._a("A new \u00a7eOptiFine\u00a7f version is available: \u00a7e" + string + "\u00a7f");
            Config.setNewRelease(null);
        }
        if (this.field_78531_r._B instanceof fngq) {
            this.updateMainMenu((fngq)this.field_78531_r._B);
        }
        if (this.updatedWorld != pkix2) {
            RandomMobs.worldChanged(this.updatedWorld, pkix2);
            Config.updateThreadPriorities();
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
            this.updatedWorld = pkix2;
        }
        htvc._e = Config.isGrassFancy() || Config.isBetterGrassFancy();
        twgu.field_71952_K._a(Config.isTreesFancy());
        if (this.field_78536_aa) {
            this.func_78472_g(f);
        }
        this.field_78531_r.__ah._b();
        boolean bl = Display.isActive();
        if (!(bl || !this.field_78531_r._M.field_82881_y || this.field_78531_r._M.field_85185_A && Mouse.isButtonDown(1))) {
            if (xpzm._M() - this.field_78508_Y > 500L) {
                this.field_78531_r._q();
            }
        } else {
            this.field_78508_Y = xpzm._M();
        }
        this.field_78531_r.__ah._a("mouse");
        if (this.field_78531_r.__ab && bl) {
            wnja._a(this.field_78531_r._t);
            this.field_78531_r._O._c();
            float f2 = this.field_78531_r._M.field_74341_c * 0.6f + 0.2f;
            float f3 = f2 * f2 * f2 * 8.0f;
            float f4 = (float)this.field_78531_r._O._a * f3;
            float f5 = (float)this.field_78531_r._O._b * f3;
            n = 1;
            if (this.field_78531_r._M.field_74338_d) {
                n = -1;
            }
            if (this.field_78531_r._M.field_74326_T) {
                this.field_78496_H += f4;
                this.field_78497_I += f5;
                float f6 = f - this.field_78492_L;
                this.field_78492_L = f;
                f4 = this.field_78498_J * f6;
                f5 = this.field_78499_K * f6;
                this.field_78531_r._t.func_70082_c(f4, f5 * (float)n);
            } else {
                this.field_78531_r._t.func_70082_c(f4, f5 * (float)n);
            }
            wnja._b(this.field_78531_r._t);
        }
        this.field_78531_r.__ah._b();
        if (!this.field_78531_r._K) {
            field_78517_a = this.field_78531_r._M.field_74337_g;
            htou htou2 = new htou(this.field_78531_r._M, this.field_78531_r._n, this.field_78531_r._o);
            int n2 = htou2._a();
            int n3 = htou2._b();
            int n4 = Mouse.getX() * n2 / this.field_78531_r._n;
            n = n3 - Mouse.getY() * n3 / this.field_78531_r._o - 1;
            int n5 = tfsl.func_78465_a(this.field_78531_r._M.field_74350_i);
            if (this.field_78531_r._r != null) {
                this.field_78531_r.__ah._a("level");
                if (this.field_78531_r._M.field_74350_i == 0) {
                    this.func_78471_a(f, 0L);
                } else {
                    this.func_78471_a(f, this.field_78510_Z + (long)(1000000000 / n5));
                }
                this.field_78510_Z = System.nanoTime();
                this.field_78531_r.__ah._c("gui");
                if (!this.field_78531_r._M.field_74319_N || this.field_78531_r._B != null) {
                    this.field_78531_r._J.func_73830_a(f, this.field_78531_r._B != null, n4, n);
                }
                this.field_78531_r.__ah._b();
            } else {
                GL11.glViewport(0, 0, this.field_78531_r._n, this.field_78531_r._o);
                GL11.glMatrixMode(5889);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888);
                GL11.glLoadIdentity();
                this.func_78478_c();
                this.field_78510_Z = System.nanoTime();
            }
            if (this.field_78531_r._B != null) {
                GL11.glClear(256);
                try {
                    this.field_78531_r._B.func_73863_a(n4, n, f);
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.func_85055_a(throwable, "Rendering screen");
                    jxsn jxsn2 = crashReport.func_85058_a("Screen render details");
                    jxsn2._a("Screen name", new cecj(this));
                    jxsn2._a("Mouse location", new yebt(this, n4, n));
                    jxsn2._a("Screen size", new zhec(this, htou2));
                    throw new turb(crashReport);
                }
            }
        }
        this.waitForServerThread();
        if (this.field_78531_r._M.field_74330_P != this.lastShowDebugInfo) {
            this.showExtendedDebugInfo = this.field_78531_r._M.field_74329_Q;
            this.lastShowDebugInfo = this.field_78531_r._M.field_74330_P;
        }
        if (this.field_78531_r._M.field_74330_P) {
            this.showLagometer(this.field_78531_r.__ah._i, this.field_78531_r.__ah._k);
        }
        if (this.field_78531_r._M.ofProfiler) {
            this.field_78531_r._M.field_74329_Q = true;
        }
    }

    public void waitForServerThread() {
        this.serverWaitTimeCurrent = 0;
        if (!Config.isSmoothWorld()) {
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
        } else if (this.field_78531_r._J() != null) {
            yfci yfci2 = this.field_78531_r._J();
            boolean bl = yfci2._a()._f();
            if (bl) {
                if (this.field_78531_r._B instanceof iwmg) {
                    Config.sleep(20L);
                }
                this.lastServerTime = 0L;
                this.lastServerTicks = 0;
            } else {
                if (this.serverWaitTime > 0) {
                    Config.sleep(this.serverWaitTime);
                    this.serverWaitTimeCurrent = this.serverWaitTime;
                }
                long l = System.nanoTime() / 1000000L;
                if (this.lastServerTime != 0L && this.lastServerTicks != 0) {
                    long l2 = l - this.lastServerTime;
                    if (l2 < 0L) {
                        this.lastServerTime = l;
                        l2 = 0L;
                    }
                    if (l2 >= 50L) {
                        this.lastServerTime = l;
                        int n = yfci2.__ak();
                        int n2 = n - this.lastServerTicks;
                        if (n2 < 0) {
                            this.lastServerTicks = n;
                            n2 = 0;
                        }
                        if (n2 < 1 && this.serverWaitTime < 100) {
                            this.serverWaitTime += 2;
                        }
                        if (n2 > 1 && this.serverWaitTime > 0) {
                            --this.serverWaitTime;
                        }
                        this.lastServerTicks = n;
                    }
                } else {
                    this.lastServerTime = l;
                    this.lastServerTicks = yfci2.__ak();
                    this.avgServerTickDiff = 1.0f;
                    this.avgServerTimeDiff = 50.0f;
                }
            }
        }
    }

    public void showLagometer(long l, long l2) {
        if (this.field_78531_r._M.ofLagometer || this.showExtendedDebugInfo) {
            if (this.prevFrameTimeNano == -1L) {
                this.prevFrameTimeNano = System.nanoTime();
            }
            long l3 = System.nanoTime();
            int n = this.numRecordedFrameTimes & this.frameTimes.length - 1;
            this.tickTimes[n] = l;
            this.chunkTimes[n] = l2;
            this.serverTimes[n] = this.serverWaitTimeCurrent;
            this.frameTimes[n] = l3 - this.prevFrameTimeNano;
            ++this.numRecordedFrameTimes;
            this.prevFrameTimeNano = l3;
            GL11.glClear(256);
            GL11.glMatrixMode(5889);
            GL11.glEnable(2903);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0, this.field_78531_r._n, this.field_78531_r._o, 0.0, 1000.0, 3000.0);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
            GL11.glLineWidth(1.0f);
            GL11.glDisable(3553);
            htvf htvf2 = htvf.field_78398_a;
            htvf2.func_78371_b(1);
            for (int i = 0; i < this.frameTimes.length; ++i) {
                int n2 = (i - this.numRecordedFrameTimes & this.frameTimes.length - 1) * 255 / this.frameTimes.length;
                long l4 = this.frameTimes[i] / 200000L;
                float f = this.field_78531_r._o;
                htvf2.func_78378_d(-16777216 + n2 * 256);
                htvf2.func_78377_a((float)i + 0.5f, f - (float)l4 + 0.5f, 0.0);
                htvf2.func_78377_a((float)i + 0.5f, f + 0.5f, 0.0);
                long l5 = this.tickTimes[i] / 200000L;
                htvf2.func_78378_d(-16777216 + n2 * 65536 + n2 * 256 + n2 * 1);
                htvf2.func_78377_a((float)i + 0.5f, (f -= (float)l4) + 0.5f, 0.0);
                htvf2.func_78377_a((float)i + 0.5f, f + (float)l5 + 0.5f, 0.0);
                long l6 = this.chunkTimes[i] / 200000L;
                htvf2.func_78378_d(-16777216 + n2 * 65536);
                htvf2.func_78377_a((float)i + 0.5f, (f += (float)l5) + 0.5f, 0.0);
                htvf2.func_78377_a((float)i + 0.5f, f + (float)l6 + 0.5f, 0.0);
                f += (float)l6;
                long l7 = this.serverTimes[i];
                if (l7 <= 0L) continue;
                long l8 = l7 * 1000000L / 200000L;
                htvf2.func_78378_d(-16777216 + n2 * 1);
                htvf2.func_78377_a((float)i + 0.5f, f + 0.5f, 0.0);
                htvf2.func_78377_a((float)i + 0.5f, f + (float)l8 + 0.5f, 0.0);
            }
            htvf2.func_78381_a();
        }
    }

    public void updateMainMenu(fngq fngq2) {
        try {
            String string = null;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            int n = calendar.get(5);
            int n2 = calendar.get(2) + 1;
            if (n == 8 && n2 == 4) {
                string = "Happy birthday, OptiFine!";
            }
            if (n == 14 && n2 == 8) {
                string = "Happy birthday, sp614x!";
            }
            if (string == null) {
                return;
            }
            Field[] fieldArray = fngq.class.getDeclaredFields();
            for (int i = 0; i < fieldArray.length; ++i) {
                if (fieldArray[i].getType() != String.class) continue;
                fieldArray[i].setAccessible(true);
                fieldArray[i].set(fngq2, string);
                break;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static int getPosLightLoc() {
        if (posLightLoc == -1) {
            posLightLoc = GL20.glGetAttribLocation(terrainShader._f(), "posLightIn");
        }
        return posLightLoc;
    }

    public static int getColorLoc() {
        if (colorLoc == -1) {
            colorLoc = GL20.glGetAttribLocation(terrainShader._f(), "colorIn");
        }
        return colorLoc;
    }

    public static int getUvLoc() {
        if (uvLoc == -1) {
            uvLoc = GL20.glGetAttribLocation(terrainShader._f(), "uvIn");
        }
        return uvLoc;
    }

    public static int getNormalLoc() {
        if (normalLoc == -1) {
            normalLoc = GL20.glGetAttribLocation(terrainShader._f(), "normalIn");
        }
        return normalLoc;
    }

    public static void enableTerrainShader(int n) {
        xpzm xpzm2 = xpzm._E();
        if (useShader) {
            int n2 = (int)(ntte._b / (long)interpTicks);
            int n3 = n2 + 1;
            float f = (float)(((double)ntte._b + (double)xpzm2._p._d) / (double)interpTicks - (double)n2);
            int n4 = (int)((float)sctd._e()._r * sctd._e()._s * 16.0f);
            float f2 = (float)n4 / (float)sctd._e()._p;
            GL13.glActiveTexture(33986);
            xpzm2._R()._a(sctd._d);
            GL13.glActiveTexture(33984);
            EntityLivingBase entityLivingBase = xpzm2._u;
            double d = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * (double)xpzm2._p._d;
            double d2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * (double)xpzm2._p._d;
            double d3 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * (double)xpzm2._p._d;
            ofbx ofbx2 = VecExtensionsKt.vec3();
            jxtc jxtc2 = jxtc._a(xpzm2._t);
            if (jxtc2 != null && jxtc2._m() > 0 && !ClientProxy.hideThrowMarker.enabled) {
                VecExtensionsKt.set(ofbx2, throwHintPos);
            }
            terrainShader._e();
            terrainShader._a("atlasTextureId", 0);
            terrainShader._a("animationAtlasTextureId", 2);
            terrainShader._a("lightMapTextureId", 1);
            terrainShader._a("frameIndex", (float)(n2 % 16));
            terrainShader._a("nextFrameIndex", (float)(n3 % 16));
            terrainShader._a("partialFrame", f % 1.0f);
            terrainShader._a("frameWidth", 0.0625f * f2);
            terrainShader._a("playerPos", (float)d, (float)d2, (float)d3);
            if (n >= 0) {
                terrainShader._a("throwCirclePos", (float)ofbx2._c, (float)ofbx2._d, (float)ofbx2._e);
                terrainShader._a("throwCircleSize", 0.5f, 1.25f);
            } else {
                terrainShader._a("throwCirclePos", 0.0f, 0.0f, 0.0f);
                terrainShader._a("throwCircleSize", 0.01f, 0.01f);
            }
            chunkPosLoc = terrainShader._a("chunkPos");
        }
    }

    public static void disableTerrainShader() {
        if (useShader) {
            GL20.glUseProgram(0);
        }
    }

    public void func_78471_a(float f, long l) {
        pidb._a(this, f, l);
        gloomyfolken.mods.anticheat.pidb._a(this, f, l);
        this.field_78531_r.__ah._a("lightTex");
        if (this.field_78536_aa) {
            this.func_78472_g(f);
        }
        GL11.glEnable(2884);
        GL11.glEnable(2929);
        if (this.field_78531_r._u == null) {
            this.field_78531_r._u = this.field_78531_r._t;
        }
        this.field_78531_r.__ah._c("pick");
        this.func_78473_a(f);
        EntityLivingBase entityLivingBase = this.field_78531_r._u;
        cvgz cvgz2 = this.field_78531_r._s;
        kjui kjui2 = this.field_78531_r._w;
        double d = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * (double)f;
        double d2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * (double)f;
        double d3 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * (double)f;
        this.field_78531_r.__ah._c("center");
        for (int i = 0; i < 2; ++i) {
            EntityPlayer entityPlayer;
            if (this.field_78531_r._M.field_74337_g) {
                field_78515_b = i;
                if (field_78515_b == 0) {
                    GL11.glColorMask(false, true, true, false);
                } else {
                    GL11.glColorMask(true, false, false, false);
                }
            }
            this.field_78531_r.__ah._c("clear");
            GL11.glViewport(0, 0, this.field_78531_r._n, this.field_78531_r._o);
            this.func_78466_h(f);
            GL11.glClear(16640);
            GL11.glEnable(2884);
            this.field_78531_r.__ah._c("camera");
            this.func_78479_a(f, i);
            tfss._a(this.field_78531_r._t, this.field_78531_r._M.field_74320_O == 2);
            this.field_78531_r.__ah._c("frustrum");
            qnnz._a();
            if (!(Config.isSkyEnabled() || Config.isSunMoonEnabled() || Config.isStarsEnabled())) {
                GL11.glDisable(3042);
            } else {
                this.func_78468_a(-1, f);
                this.field_78531_r.__ah._c("sky");
                cvgz2._a(f);
            }
            GL11.glEnable(2912);
            this.func_78468_a(1, f);
            if (this.field_78531_r._M.field_74348_k != 0) {
                GL11.glShadeModel(7425);
            }
            this.field_78531_r.__ah._c("culling");
            bseg bseg2 = new bseg();
            bseg2._a(d, d2, d3);
            this.field_78531_r._s._a(bseg2, f);
            if (i == 0) {
                long l2;
                this.field_78531_r.__ah._c("updatechunks");
                while (!this.field_78531_r._s._a(entityLivingBase, false) && l != 0L && (l2 = l - System.nanoTime()) >= 0L && l2 <= 1000000000L) {
                }
            }
            if (entityLivingBase.field_70163_u < 128.0) {
                this.func_82829_a(cvgz2, f);
            }
            this.field_78531_r.__ah._c("prepareterrain");
            this.func_78468_a(0, f);
            GL11.glEnable(2912);
            this.field_78531_r._R()._a(sctd._c);
            qnon._a();
            this.field_78531_r.__ah._c("terrain");
            tfsl.enableTerrainShader(0);
            cvgz2._a(entityLivingBase, 0, (double)f);
            tfsl.disableTerrainShader();
            GL11.glShadeModel(7424);
            boolean bl = Reflector.ForgeHooksClient.exists();
            if (this.field_78532_q == 0) {
                qnon._b();
                this.field_78531_r.__ah._c("entities");
                ForgeHooksClient.setRenderPass(0);
                cvgz2._a(entityLivingBase.func_70666_h(f), bseg2, f);
                ForgeHooksClient.setRenderPass(-1);
                qnon._a();
                if (this.field_78531_r._L != null && entityLivingBase.func_70055_a(tflj._h) && entityLivingBase instanceof EntityPlayer && !this.field_78531_r._M.field_74319_N) {
                    entityPlayer = (EntityPlayer)entityLivingBase;
                    GL11.glDisable(3008);
                    this.field_78531_r.__ah._c("outline");
                    if (!(bl && Reflector.callBoolean(Reflector.ForgeHooksClient_onDrawBlockHighlight, cvgz2, entityPlayer, this.field_78531_r._L, 0, entityPlayer.field_71071_by._a(), Float.valueOf(f)) || this.field_78531_r._M.field_74319_N)) {
                        cvgz2._a(entityPlayer, this.field_78531_r._L, 0, f);
                    }
                    GL11.glEnable(3008);
                }
            }
            GL11.glDisable(3042);
            GL11.glEnable(2884);
            GL11.glBlendFunc(770, 771);
            GL11.glDepthMask(true);
            this.func_78468_a(0, f);
            GL11.glEnable(3042);
            GL11.glDisable(2884);
            this.field_78531_r._R()._a(sctd._c);
            WrUpdates.resumeBackgroundUpdates();
            tfsl.enableTerrainShader(1);
            if (Config.isWaterFancy()) {
                this.field_78531_r.__ah._c("water");
                if (this.field_78531_r._M.field_74348_k != 0) {
                    GL11.glShadeModel(7425);
                }
                GL11.glColorMask(false, false, false, false);
                int n = cvgz2._b(1, f);
                if (this.field_78531_r._M.field_74337_g) {
                    if (field_78515_b == 0) {
                        GL11.glColorMask(false, true, true, true);
                    } else {
                        GL11.glColorMask(true, false, false, true);
                    }
                } else {
                    GL11.glColorMask(true, true, true, true);
                }
                if (n > 0) {
                    cvgz2._b(1, f);
                }
                GL11.glShadeModel(7424);
            } else {
                this.field_78531_r.__ah._c("water");
                cvgz2._b(1, f);
            }
            tfsl.disableTerrainShader();
            WrUpdates.pauseBackgroundUpdates();
            McChunkCommandQueue.runTasks();
            if (bl && this.field_78532_q == 0) {
                qnon._b();
                this.field_78531_r.__ah._c("entities");
                ForgeHooksClient.setRenderPass(1);
                this.field_78531_r._s._a(entityLivingBase.func_70666_h(f), bseg2, f);
                ForgeHooksClient.setRenderPass(-1);
                qnon._a();
            }
            GL11.glDepthMask(true);
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            if (this.field_78503_V == 1.0 && entityLivingBase instanceof EntityPlayer && !this.field_78531_r._M.field_74319_N && this.field_78531_r._L != null && !entityLivingBase.func_70055_a(tflj._h)) {
                entityPlayer = (EntityPlayer)entityLivingBase;
                GL11.glDisable(3008);
                this.field_78531_r.__ah._c("outline");
                if (!(bl && Reflector.callBoolean(Reflector.ForgeHooksClient_onDrawBlockHighlight, cvgz2, entityPlayer, this.field_78531_r._L, 0, entityPlayer.field_71071_by._a(), Float.valueOf(f)) || this.field_78531_r._M.field_74319_N)) {
                    cvgz2._a(entityPlayer, this.field_78531_r._L, 0, f);
                }
                GL11.glEnable(3008);
            }
            this.field_78531_r.__ah._c("destroyProgress");
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            cvgz2._a(htvf.field_78398_a, entityLivingBase, f);
            GL11.glDisable(3042);
            this.field_78531_r.__ah._c("weather");
            this.func_78474_d(f);
            GL11.glDisable(2912);
            if (entityLivingBase.field_70163_u >= 128.0) {
                this.func_82829_a(cvgz2, f);
            }
            this.func_78463_b(f);
            this.field_78531_r.__ah._c("litParticles");
            qnon._b();
            kjui2._b(entityLivingBase, f);
            qnon._a();
            this.func_78468_a(0, f);
            this.field_78531_r.__ah._c("particles");
            kjui2._a(entityLivingBase, f);
            this.func_78483_a(f);
            if (bl) {
                this.field_78531_r.__ah._c("FRenderLast");
                Reflector.callVoid(Reflector.ForgeHooksClient_dispatchRenderLast, cvgz2, Float.valueOf(f));
            }
            this.field_78531_r.__ah._c("hand");
            if (this.field_78503_V == 1.0) {
                GL11.glClear(256);
                this.func_78476_b(f, i);
            }
            if (this.field_78531_r._M.field_74337_g) continue;
            this.field_78531_r.__ah._b();
            gloomyfolken.mods.anticheat.pidb._b(this, f, l);
            fmej._a(this, f, l);
            return;
        }
        GL11.glColorMask(true, true, true, false);
        this.field_78531_r.__ah._b();
        gloomyfolken.mods.anticheat.pidb._b(this, f, l);
        fmej._a(this, f, l);
    }

    public void func_82829_a(cvgz cvgz2, float f) {
        if (this.field_78531_r._M.func_74309_c()) {
            this.field_78531_r.__ah._c("clouds");
            GL11.glPushMatrix();
            this.func_78468_a(0, f);
            GL11.glEnable(2912);
            cvgz2._b(f);
            GL11.glDisable(2912);
            this.func_78468_a(1, f);
            GL11.glPopMatrix();
        }
    }

    public void func_78484_h() {
        float f = this.field_78531_r._r.func_72867_j(1.0f);
        if (!Config.isRainFancy()) {
            f /= 2.0f;
        }
        if (Config.isRainSplash()) {
            this.field_78537_ab.setSeed((long)this.field_78529_t * 312987231L);
            EntityLivingBase entityLivingBase = this.field_78531_r._u;
            pkix pkix2 = this.field_78531_r._r;
            int n = sajh._c(entityLivingBase.field_70165_t);
            int n2 = sajh._c(entityLivingBase.field_70163_u);
            int n3 = sajh._c(entityLivingBase.field_70161_v);
            int n4 = 10;
            double d = 0.0;
            double d2 = 0.0;
            double d3 = 0.0;
            int n5 = 0;
            int n6 = (int)(100.0f * f * f);
            if (this.field_78531_r._M.field_74362_aa == 1) {
                n6 >>= 1;
            } else if (this.field_78531_r._M.field_74362_aa == 2) {
                n6 = 0;
            }
            for (int i = 0; i < n6; ++i) {
                int n7 = n + this.field_78537_ab.nextInt(n4) - this.field_78537_ab.nextInt(n4);
                int n8 = n3 + this.field_78537_ab.nextInt(n4) - this.field_78537_ab.nextInt(n4);
                int n9 = pkix2.func_72874_g(n7, n8);
                int n10 = pkix2.func_72798_a(n7, n9 - 1, n8);
                foqh foqh2 = pkix2.func_72807_a(n7, n8);
                if (n9 > n2 + n4 || n9 < n2 - n4 || !foqh2._e() || !(foqh2._k() >= 0.2f)) continue;
                float f2 = this.field_78537_ab.nextFloat();
                float f3 = this.field_78537_ab.nextFloat();
                if (n10 <= 0) continue;
                if (twgu.field_71973_m[n10].field_72018_cp == tflj._i) {
                    this.field_78531_r._w._a(new EntitySmokeFX(pkix2, (float)n7 + f2, (double)((float)n9 + 0.1f) - twgu.field_71973_m[n10].func_83008_x(), (float)n8 + f3, 0.0, 0.0, 0.0));
                    continue;
                }
                if (this.field_78537_ab.nextInt(++n5) == 0) {
                    d = (float)n7 + f2;
                    d2 = (double)((float)n9 + 0.1f) - twgu.field_71973_m[n10].func_83008_x();
                    d3 = (float)n8 + f3;
                }
                EntityRainFX entityRainFX = new EntityRainFX(pkix2, (float)n7 + f2, (double)((float)n9 + 0.1f) - twgu.field_71973_m[n10].func_83008_x(), (float)n8 + f3);
                CustomColorizer.updateWaterFX(entityRainFX, pkix2);
                this.field_78531_r._w._a(entityRainFX);
            }
            if (n5 > 0 && this.field_78537_ab.nextInt(3) < this.field_78534_ac++) {
                this.field_78534_ac = 0;
                if (d2 > entityLivingBase.field_70163_u + 1.0 && pkix2.func_72874_g(sajh._c(entityLivingBase.field_70165_t), sajh._c(entityLivingBase.field_70161_v)) > sajh._c(entityLivingBase.field_70163_u)) {
                    this.field_78531_r._r.func_72980_b(d, d2, d3, "ambient.weather.rain", 0.1f, 0.5f, false);
                } else {
                    this.field_78531_r._r.func_72980_b(d, d2, d3, "ambient.weather.rain", 0.2f, 1.0f, false);
                }
            }
        }
    }

    public void func_78474_d(float f) {
        boolean bl = fmej._a(this, f);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        float f2 = this.field_78531_r._r.func_72867_j(f);
        if (f2 > 0.0f) {
            this.func_78463_b(f);
            if (this.field_78525_i == null) {
                this.field_78525_i = new float[1024];
                this.field_78522_j = new float[1024];
                for (int i = 0; i < 32; ++i) {
                    for (int j = 0; j < 32; ++j) {
                        float f3 = j - 16;
                        float f4 = i - 16;
                        float f5 = sajh._c(f3 * f3 + f4 * f4);
                        this.field_78525_i[i << 5 | j] = -f4 / f5;
                        this.field_78522_j[i << 5 | j] = f3 / f5;
                    }
                }
            }
            if (Config.isRainOff()) {
                return;
            }
            EntityLivingBase entityLivingBase = this.field_78531_r._u;
            pkix pkix2 = this.field_78531_r._r;
            int n = sajh._c(entityLivingBase.field_70165_t);
            int n2 = sajh._c(entityLivingBase.field_70163_u);
            int n3 = sajh._c(entityLivingBase.field_70161_v);
            htvf htvf2 = htvf.field_78398_a;
            GL11.glDisable(2884);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glAlphaFunc(516, 0.01f);
            this.field_78531_r._R()._a(field_110923_r);
            double d = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * (double)f;
            double d2 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * (double)f;
            double d3 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * (double)f;
            int n4 = sajh._c(d2);
            int n5 = 5;
            if (Config.isRainFancy()) {
                n5 = 10;
            }
            boolean bl3 = false;
            int n6 = -1;
            float f6 = (float)this.field_78529_t + f;
            if (Config.isRainFancy()) {
                n5 = 10;
            }
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            bl3 = false;
            for (int i = n3 - n5; i <= n3 + n5; ++i) {
                for (int j = n - n5; j <= n + n5; ++j) {
                    double d4;
                    float f7;
                    int n7 = (i - n3 + 16) * 32 + j - n + 16;
                    float f8 = this.field_78525_i[n7] * 0.5f;
                    float f9 = this.field_78522_j[n7] * 0.5f;
                    foqh foqh2 = pkix2.func_72807_a(j, i);
                    if (!foqh2._e() && !foqh2._d()) continue;
                    int n8 = pkix2.func_72874_g(j, i);
                    int n9 = n2 - n5;
                    int n10 = n2 + n5;
                    if (n9 < n8) {
                        n9 = n8;
                    }
                    if (n10 < n8) {
                        n10 = n8;
                    }
                    float f10 = 1.0f;
                    int n11 = n8;
                    if (n8 < n4) {
                        n11 = n4;
                    }
                    if (n9 == n10) continue;
                    this.field_78537_ab.setSeed(j * j * 3121 + j * 45238971 ^ i * i * 418711 + i * 13761);
                    float f11 = foqh2._k();
                    if (pkix2.func_72959_q()._a(f11, n8) >= 0.15f) {
                        if (n6 != 0) {
                            if (n6 >= 0) {
                                htvf2.func_78381_a();
                            }
                            n6 = 0;
                            this.field_78531_r._R()._a(field_110924_q);
                            htvf2.func_78382_b();
                        }
                        f7 = ((float)(this.field_78529_t + j * j * 3121 + j * 45238971 + i * i * 418711 + i * 13761 & 0x1F) + f) / 32.0f * (3.0f + this.field_78537_ab.nextFloat());
                        double d5 = (double)((float)j + 0.5f) - entityLivingBase.field_70165_t;
                        d4 = (double)((float)i + 0.5f) - entityLivingBase.field_70161_v;
                        float f12 = sajh._a(d5 * d5 + d4 * d4) / (float)n5;
                        float f13 = 1.0f;
                        htvf2.func_78380_c(pkix2.func_72802_i(j, n11, i, 0));
                        htvf2.func_78369_a(f13, f13, f13, ((1.0f - f12 * f12) * 0.5f + 0.5f) * f2);
                        htvf2.func_78373_b(-d * 1.0, -d2 * 1.0, -d3 * 1.0);
                        htvf2.func_78374_a((double)((float)j - f8) + 0.5, n9, (double)((float)i - f9) + 0.5, 0.0f * f10, (float)n9 * f10 / 4.0f + f7 * f10);
                        htvf2.func_78374_a((double)((float)j + f8) + 0.5, n9, (double)((float)i + f9) + 0.5, 1.0f * f10, (float)n9 * f10 / 4.0f + f7 * f10);
                        htvf2.func_78374_a((double)((float)j + f8) + 0.5, n10, (double)((float)i + f9) + 0.5, 1.0f * f10, (float)n10 * f10 / 4.0f + f7 * f10);
                        htvf2.func_78374_a((double)((float)j - f8) + 0.5, n10, (double)((float)i - f9) + 0.5, 0.0f * f10, (float)n10 * f10 / 4.0f + f7 * f10);
                        htvf2.func_78373_b(0.0, 0.0, 0.0);
                        continue;
                    }
                    if (n6 != 1) {
                        if (n6 >= 0) {
                            htvf2.func_78381_a();
                        }
                        n6 = 1;
                        this.field_78531_r._R()._a(new ResourceLocation("textures/environment/snow.png"));
                        htvf2.func_78382_b();
                    }
                    f7 = ((float)(this.field_78529_t & 0x1FF) + f) / 512.0f;
                    float f14 = this.field_78537_ab.nextFloat() + f6 * 0.01f * (float)this.field_78537_ab.nextGaussian();
                    float f15 = this.field_78537_ab.nextFloat() + f6 * (float)this.field_78537_ab.nextGaussian() * 0.001f;
                    d4 = (double)((float)j + 0.5f) - entityLivingBase.field_70165_t;
                    double d6 = (double)((float)i + 0.5f) - entityLivingBase.field_70161_v;
                    float f16 = sajh._a(d4 * d4 + d6 * d6) / (float)n5;
                    float f17 = 1.0f;
                    htvf2.func_78380_c((pkix2.func_72802_i(j, n11, i, 0) * 3 + 0xF000F0) / 4);
                    htvf2.func_78369_a(f17, f17, f17, ((1.0f - f16 * f16) * 0.3f + 0.5f) * f2);
                    htvf2.func_78373_b(-d * 1.0, -d2 * 1.0, -d3 * 1.0);
                    htvf2.func_78374_a((double)((float)j - f8) + 0.5, n9, (double)((float)i - f9) + 0.5, 0.0f * f10 + f14, (float)n9 * f10 / 4.0f + f7 * f10 + f15);
                    htvf2.func_78374_a((double)((float)j + f8) + 0.5, n9, (double)((float)i + f9) + 0.5, 1.0f * f10 + f14, (float)n9 * f10 / 4.0f + f7 * f10 + f15);
                    htvf2.func_78374_a((double)((float)j + f8) + 0.5, n10, (double)((float)i + f9) + 0.5, 1.0f * f10 + f14, (float)n10 * f10 / 4.0f + f7 * f10 + f15);
                    htvf2.func_78374_a((double)((float)j - f8) + 0.5, n10, (double)((float)i - f9) + 0.5, 0.0f * f10 + f14, (float)n10 * f10 / 4.0f + f7 * f10 + f15);
                    htvf2.func_78373_b(0.0, 0.0, 0.0);
                }
            }
            if (n6 >= 0) {
                htvf2.func_78381_a();
            }
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            GL11.glAlphaFunc(516, 0.1f);
            this.func_78483_a(f);
        }
    }

    public void func_78478_c() {
        htou htou2 = new htou(this.field_78531_r._M, this.field_78531_r._n, this.field_78531_r._o);
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, htou2._c(), htou2._d(), 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
    }

    public void func_78466_h(float f) {
        float f2;
        float f3;
        float f4;
        pkix pkix2 = this.field_78531_r._r;
        EntityLivingBase entityLivingBase = this.field_78531_r._u;
        float f5 = 1.0f / (float)(4 - this.field_78531_r._M.field_74339_e);
        f5 = 1.0f - (float)Math.pow(f5, 0.25);
        ofbx ofbx2 = pkix2.func_72833_a(this.field_78531_r._u, f);
        int n = pkix2.field_73011_w._i;
        switch (n) {
            case 0: {
                ofbx2 = CustomColorizer.getSkyColor(ofbx2, this.field_78531_r._r, this.field_78531_r._u.field_70165_t, this.field_78531_r._u.field_70163_u + 1.0, this.field_78531_r._u.field_70161_v);
                break;
            }
            case 1: {
                ofbx2 = CustomColorizer.getSkyColorEnd(ofbx2);
            }
        }
        float f6 = (float)ofbx2._c;
        float f7 = (float)ofbx2._d;
        float f8 = (float)ofbx2._e;
        ofbx ofbx3 = pkix2.func_72948_g(f);
        switch (n) {
            case -1: {
                ofbx3 = CustomColorizer.getFogColorNether(ofbx3);
                break;
            }
            case 0: {
                ofbx3 = CustomColorizer.getFogColor(ofbx3, this.field_78531_r._r, this.field_78531_r._u.field_70165_t, this.field_78531_r._u.field_70163_u + 1.0, this.field_78531_r._u.field_70161_v);
                break;
            }
            case 1: {
                ofbx3 = CustomColorizer.getFogColorEnd(ofbx3);
            }
        }
        this.field_78518_n = (float)ofbx3._c;
        this.field_78519_o = (float)ofbx3._d;
        this.field_78533_p = (float)ofbx3._e;
        if (this.field_78531_r._M.field_74339_e < 2) {
            float[] fArray;
            ofbx ofbx4 = sajh._a(pkix2.func_72929_e(f)) > 0.0f ? pkix2.func_82732_R()._a(-1.0, 0.0, 0.0) : pkix2.func_82732_R()._a(1.0, 0.0, 0.0);
            f4 = (float)entityLivingBase.func_70676_i(f)._b(ofbx4);
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            if (f4 > 0.0f && (fArray = pkix2.field_73011_w._a(pkix2.func_72826_c(f), f)) != null) {
                this.field_78518_n = this.field_78518_n * (1.0f - (f4 *= fArray[3])) + fArray[0] * f4;
                this.field_78519_o = this.field_78519_o * (1.0f - f4) + fArray[1] * f4;
                this.field_78533_p = this.field_78533_p * (1.0f - f4) + fArray[2] * f4;
            }
        }
        this.field_78518_n += (f6 - this.field_78518_n) * f5;
        this.field_78519_o += (f7 - this.field_78519_o) * f5;
        this.field_78533_p += (f8 - this.field_78533_p) * f5;
        float f9 = pkix2.func_72867_j(f);
        if (f9 > 0.0f) {
            f4 = 1.0f - f9 * 0.5f;
            float f10 = 1.0f - f9 * 0.4f;
            this.field_78518_n *= f4;
            this.field_78519_o *= f4;
            this.field_78533_p *= f10;
        }
        if ((f4 = pkix2.func_72819_i(f)) > 0.0f) {
            float f11 = 1.0f - f4 * 0.5f;
            this.field_78518_n *= f11;
            this.field_78519_o *= f11;
            this.field_78533_p *= f11;
        }
        int n2 = tfss._a(this.field_78531_r._r, entityLivingBase, f);
        if (this.field_78500_U) {
            ofbx ofbx5 = pkix2.func_72824_f(f);
            this.field_78518_n = (float)ofbx5._c;
            this.field_78519_o = (float)ofbx5._d;
            this.field_78533_p = (float)ofbx5._e;
        } else if (n2 != 0 && twgu.field_71973_m[n2].field_72018_cp == tflj._h) {
            f3 = (float)zhty._b(entityLivingBase) * 0.2f;
            this.field_78518_n = 0.02f + f3;
            this.field_78519_o = 0.02f + f3;
            this.field_78533_p = 0.2f + f3;
            ofbx ofbx6 = CustomColorizer.getUnderwaterColor(this.field_78531_r._r, this.field_78531_r._u.field_70165_t, this.field_78531_r._u.field_70163_u + 1.0, this.field_78531_r._u.field_70161_v);
            if (ofbx6 != null) {
                this.field_78518_n = (float)ofbx6._c;
                this.field_78519_o = (float)ofbx6._d;
                this.field_78533_p = (float)ofbx6._e;
            }
        } else if (n2 != 0 && twgu.field_71973_m[n2].field_72018_cp == tflj._i) {
            this.field_78518_n = 0.6f;
            this.field_78519_o = 0.1f;
            this.field_78533_p = 0.0f;
        }
        f3 = this.field_78535_ad + (this.field_78539_ae - this.field_78535_ad) * f;
        this.field_78518_n *= f3;
        this.field_78519_o *= f3;
        this.field_78533_p *= f3;
        double d = pkix2.field_73011_w._k();
        if (!Config.isDepthFog()) {
            d = 1.0;
        }
        double d2 = (entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * (double)f) * d;
        if (entityLivingBase.func_70644_a(hdpq._q)) {
            int n3 = entityLivingBase.func_70660_b(hdpq._q)._b();
            d2 = n3 < 20 ? (d2 *= (double)(1.0f - (float)n3 / 20.0f)) : 0.0;
        }
        if (d2 < 1.0) {
            if (d2 < 0.0) {
                d2 = 0.0;
            }
            d2 *= d2;
            this.field_78518_n = (float)((double)this.field_78518_n * d2);
            this.field_78519_o = (float)((double)this.field_78519_o * d2);
            this.field_78533_p = (float)((double)this.field_78533_p * d2);
        }
        if (this.field_82831_U > 0.0f) {
            float f12 = this.field_82832_V + (this.field_82831_U - this.field_82832_V) * f;
            this.field_78518_n = this.field_78518_n * (1.0f - f12) + this.field_78518_n * 0.7f * f12;
            this.field_78519_o = this.field_78519_o * (1.0f - f12) + this.field_78519_o * 0.6f * f12;
            this.field_78533_p = this.field_78533_p * (1.0f - f12) + this.field_78533_p * 0.6f * f12;
        }
        if (entityLivingBase.func_70644_a(hdpq._r)) {
            float f13 = this.func_82830_a(this.field_78531_r._t, f);
            f2 = 1.0f / this.field_78518_n;
            if (f2 > 1.0f / this.field_78519_o) {
                f2 = 1.0f / this.field_78519_o;
            }
            if (f2 > 1.0f / this.field_78533_p) {
                f2 = 1.0f / this.field_78533_p;
            }
            this.field_78518_n = this.field_78518_n * (1.0f - f13) + this.field_78518_n * f2 * f13;
            this.field_78519_o = this.field_78519_o * (1.0f - f13) + this.field_78519_o * f2 * f13;
            this.field_78533_p = this.field_78533_p * (1.0f - f13) + this.field_78533_p * f2 * f13;
        }
        if (this.field_78531_r._M.field_74337_g) {
            float f14 = (this.field_78518_n * 30.0f + this.field_78519_o * 59.0f + this.field_78533_p * 11.0f) / 100.0f;
            f2 = (this.field_78518_n * 30.0f + this.field_78519_o * 70.0f) / 100.0f;
            float f15 = (this.field_78518_n * 30.0f + this.field_78533_p * 70.0f) / 100.0f;
            this.field_78518_n = f14;
            this.field_78519_o = f2;
            this.field_78533_p = f15;
        }
        GL11.glClearColor(this.field_78518_n, this.field_78519_o, this.field_78533_p, 0.0f);
        ezey._a();
    }

    public void func_78468_a(int n, float f) {
        boolean bl = fmej._a(this, n, f);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        EntityLivingBase entityLivingBase = this.field_78531_r._u;
        boolean bl3 = false;
        this.fogStandard = false;
        if (entityLivingBase instanceof EntityPlayer) {
            bl3 = ((EntityPlayer)entityLivingBase).field_71075_bZ._d;
        }
        if (n == 999) {
            GL11.glFog(2918, this.func_78469_a(0.0f, 0.0f, 0.0f, 1.0f));
            GL11.glFogi(2917, 9729);
            GL11.glFogf(2915, 0.0f);
            GL11.glFogf(2916, 8.0f);
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                GL11.glFogi(34138, 34139);
            }
            GL11.glFogf(2915, 0.0f);
        } else {
            GL11.glFog(2918, this.func_78469_a(this.field_78518_n, this.field_78519_o, this.field_78533_p, 1.0f));
            GL11.glNormal3f(0.0f, -1.0f, 0.0f);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            int n2 = tfss._a(this.field_78531_r._r, entityLivingBase, f);
            if (entityLivingBase.func_70644_a(hdpq._q)) {
                float f2 = 5.0f;
                int n3 = entityLivingBase.func_70660_b(hdpq._q)._b();
                if (n3 < 20) {
                    f2 = 5.0f + (this.field_78530_s - 5.0f) * (1.0f - (float)n3 / 20.0f);
                }
                GL11.glFogi(2917, 9729);
                if (n < 0) {
                    GL11.glFogf(2915, 0.0f);
                    GL11.glFogf(2916, f2 * 0.8f);
                } else {
                    GL11.glFogf(2915, f2 * 0.25f);
                    GL11.glFogf(2916, f2);
                }
                if (Config.isFogFancy()) {
                    GL11.glFogi(34138, 34139);
                }
            } else if (this.field_78500_U) {
                GL11.glFogi(2917, 2048);
                GL11.glFogf(2914, 0.1f);
            } else if (n2 > 0 && twgu.field_71973_m[n2].field_72018_cp == tflj._h) {
                GL11.glFogi(2917, 2048);
                if (entityLivingBase.func_70644_a(hdpq._o)) {
                    GL11.glFogf(2914, 0.05f);
                } else {
                    GL11.glFogf(2914, 0.1f - (float)zhty._b(entityLivingBase) * 0.03f);
                }
                if (Config.isClearWater()) {
                    GL11.glFogf(2914, 0.02f);
                }
            } else if (n2 > 0 && twgu.field_71973_m[n2].field_72018_cp == tflj._i) {
                GL11.glFogi(2917, 2048);
                GL11.glFogf(2914, 2.0f);
            } else {
                double d;
                float f3 = this.field_78530_s;
                this.fogStandard = true;
                if (Config.isDepthFog() && this.field_78531_r._r.field_73011_w._j() && !bl3 && (d = (double)((entityLivingBase.func_70070_b(f) & 0xF00000) >> 20) / 16.0 + (entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * (double)f + 4.0) / 32.0) < 1.0) {
                    float f4;
                    if (d < 0.0) {
                        d = 0.0;
                    }
                    if ((f4 = 100.0f * (float)(d *= d)) < 5.0f) {
                        f4 = 5.0f;
                    }
                    if (f3 > f4) {
                        f3 = f4;
                    }
                }
                GL11.glFogi(2917, 9729);
                if (GLContext.getCapabilities().GL_NV_fog_distance) {
                    if (Config.isFogFancy()) {
                        GL11.glFogi(34138, 34139);
                    }
                    if (Config.isFogFast()) {
                        GL11.glFogi(34138, 34140);
                    }
                }
                float f5 = Config.getFogStart();
                float f6 = 1.0f;
                if (n < 0) {
                    f5 = 0.0f;
                    f6 = 0.8f;
                }
                if (this.field_78531_r._r.field_73011_w._b((int)entityLivingBase.field_70165_t, (int)entityLivingBase.field_70161_v)) {
                    f5 = 0.05f;
                    f6 = 1.0f;
                    f3 = this.field_78530_s;
                }
                GL11.glFogf(2915, f3 * f5);
                GL11.glFogf(2916, f3 * f6);
            }
            GL11.glEnable(2903);
            GL11.glColorMaterial(1028, 4608);
        }
    }

    public FloatBuffer func_78469_a(float f, float f2, float f3, float f4) {
        this.field_78521_m.clear();
        this.field_78521_m.put(f).put(f2).put(f3).put(f4);
        this.field_78521_m.flip();
        return this.field_78521_m;
    }

    public static int func_78465_a(int n) {
        xpzm xpzm2 = Config.getMinecraft();
        if (xpzm2._B != null && xpzm2._B instanceof fngq) {
            return 35;
        }
        if (xpzm2._r == null) {
            return 35;
        }
        int n2 = Config.getGameSettings().ofLimitFramerateFine;
        if (n2 <= 0) {
            n2 = 10000;
        }
        return n2;
    }

    public static xpzm func_90030_a(tfsl tfsl2) {
        return tfsl2.field_78531_r;
    }

    static {
        terrainShader = new ugqx.kjui("effects", "blocks")._a("ANIMATED", true)._a();
        useShader = true;
        interpTicks = 4;
        posLightLoc = -1;
        colorLoc = -1;
        uvLoc = -1;
        normalLoc = -1;
        throwHintPos = VecExtensionsKt.vec3();
        chunkPosLoc = -1;
    }
}

