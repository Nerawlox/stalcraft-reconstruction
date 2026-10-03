/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

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
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityRainFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.client.renderer.CallableMouseLocation;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.kjui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.MouseFilter;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.util.turb;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.ForgeHooksClient;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.Project;
import znw.mods.stalkerguide.pidb;

public class EntityRenderer {
    public static final ResourceLocation locationRainPng = new ResourceLocation("textures/environment/rain.png");
    public static final ResourceLocation locationSnowPng = new ResourceLocation("textures/environment/snow.png");
    public static boolean anaglyphEnable;
    public static int anaglyphField;
    public Minecraft mc;
    public float farPlaneDistance;
    public ItemRenderer itemRenderer;
    public int rendererUpdateCount;
    public Entity pointedEntity;
    public MouseFilter mouseFilterXAxis = new MouseFilter();
    public MouseFilter mouseFilterYAxis = new MouseFilter();
    public MouseFilter mouseFilterDummy1 = new MouseFilter();
    public MouseFilter mouseFilterDummy2 = new MouseFilter();
    public MouseFilter mouseFilterDummy3 = new MouseFilter();
    public MouseFilter mouseFilterDummy4 = new MouseFilter();
    public float thirdPersonDistance = 4.0f;
    public float thirdPersonDistanceTemp = 4.0f;
    public float debugCamYaw;
    public float prevDebugCamYaw;
    public float debugCamPitch;
    public float prevDebugCamPitch;
    public float smoothCamYaw;
    public float smoothCamPitch;
    public float smoothCamFilterX;
    public float smoothCamFilterY;
    public float smoothCamPartialTicks;
    public float debugCamFOV;
    public float prevDebugCamFOV;
    public float camRoll;
    public float prevCamRoll;
    public final sctt lightmapTexture;
    public final int[] lightmapColors;
    public final ResourceLocation locationLightMap;
    public float fovModifierHand;
    public float fovModifierHandPrev;
    public float fovMultiplierTemp;
    public float field_82831_U;
    public float field_82832_V;
    public boolean cloudFog;
    public double cameraZoom = 1.0;
    public double cameraYaw;
    public double cameraPitch;
    public long prevFrameTime = Minecraft._M();
    public long renderEndNanoTime;
    public boolean lightmapUpdateNeeded;
    public float torchFlickerX;
    public float torchFlickerDX;
    public float torchFlickerY;
    public float torchFlickerDY;
    public Random random = new Random();
    public int rainSoundCounter;
    public float[] rainXCoords;
    public float[] rainYCoords;
    public FloatBuffer fogColorBuffer = pklh._e(16);
    public float fogColorRed;
    public float fogColorGreen;
    public float fogColorBlue;
    public float fogColor2;
    public float fogColor1;
    public int debugViewDirection;
    public boolean initialized = false;
    public World updatedWorld = null;
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
    public static Vec3 throwHintPos;
    public static int chunkPosLoc;

    public EntityRenderer(Minecraft minecraft) {
        this.mc = minecraft;
        this.itemRenderer = new ItemRenderer(minecraft);
        this.lightmapTexture = new sctt(16, 16);
        this.locationLightMap = minecraft._R()._a("lightMap", this.lightmapTexture);
        this.lightmapColors = this.lightmapTexture._b();
    }

    public void updateRenderer() {
        float f;
        float f2;
        this.updateFovModifierHand();
        this.updateTorchFlicker();
        this.fogColor2 = this.fogColor1;
        this.thirdPersonDistanceTemp = this.thirdPersonDistance;
        this.prevDebugCamYaw = this.debugCamYaw;
        this.prevDebugCamPitch = this.debugCamPitch;
        this.prevDebugCamFOV = this.debugCamFOV;
        this.prevCamRoll = this.camRoll;
        if (this.mc._M.smoothCamera) {
            f2 = this.mc._M.mouseSensitivity * 0.6f + 0.2f;
            f = f2 * f2 * f2 * 8.0f;
            this.smoothCamFilterX = this.mouseFilterXAxis._a(this.smoothCamYaw, 0.05f * f);
            this.smoothCamFilterY = this.mouseFilterYAxis._a(this.smoothCamPitch, 0.05f * f);
            this.smoothCamPartialTicks = 0.0f;
            this.smoothCamYaw = 0.0f;
            this.smoothCamPitch = 0.0f;
        }
        if (this.mc._u == null) {
            this.mc._u = this.mc._t;
        }
        f2 = this.mc._r.getLightBrightness(sajh._c(this.mc._u.posX), sajh._c(this.mc._u.posY), sajh._c(this.mc._u.posZ));
        f = (float)(3 - this.mc._M.renderDistance) / 3.0f;
        float f3 = f2 * (1.0f - f) + f;
        this.fogColor1 += (f3 - this.fogColor1) * 0.1f;
        ++this.rendererUpdateCount;
        this.itemRenderer.updateEquippedItem();
        this.addRainParticles();
        this.field_82832_V = this.field_82831_U;
        if (kjui._d) {
            this.field_82831_U += 0.05f;
            if (this.field_82831_U > 1.0f) {
                this.field_82831_U = 1.0f;
            }
            kjui._d = false;
        } else if (this.field_82831_U > 0.0f) {
            this.field_82831_U -= 0.0125f;
        }
    }

    public void getMouseOver(float f) {
        qlgf._a(this, f);
    }

    public void updateFovModifierHand() {
        if (this.mc._u instanceof EntityPlayerSP) {
            EntityPlayerSP entityPlayerSP = (EntityPlayerSP)this.mc._u;
            this.fovMultiplierTemp = entityPlayerSP.getFOVMultiplier();
        } else {
            this.fovMultiplierTemp = this.mc._t.getFOVMultiplier();
        }
        this.fovModifierHandPrev = this.fovModifierHand;
        this.fovModifierHand += (this.fovMultiplierTemp - this.fovModifierHand) * 0.5f;
        if (this.fovModifierHand > 1.5f) {
            this.fovModifierHand = 1.5f;
        }
        if (this.fovModifierHand < 0.1f) {
            this.fovModifierHand = 0.1f;
        }
    }

    public float getFOVModifier(float f, boolean bl) {
        float f2 = ogqb._a(this, f, bl);
        return f2;
    }

    public void hurtCameraEffect(float f) {
        ogqb._a(this, f);
    }

    public void setupViewBobbing(float f) {
        if (this.mc._u instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)this.mc._u;
            float f2 = entityPlayer.distanceWalkedModified - entityPlayer.prevDistanceWalkedModified;
            float f3 = -(entityPlayer.distanceWalkedModified + f2 * f);
            float f4 = entityPlayer.prevCameraYaw + (entityPlayer.cameraYaw - entityPlayer.prevCameraYaw) * f;
            float f5 = entityPlayer.prevCameraPitch + (entityPlayer.cameraPitch - entityPlayer.prevCameraPitch) * f;
            GL11.glTranslatef(sajh._a(f3 * (float)Math.PI) * f4 * 0.5f, -Math.abs(sajh._b(f3 * (float)Math.PI) * f4), 0.0f);
            GL11.glRotatef(sajh._a(f3 * (float)Math.PI) * f4 * 3.0f, 0.0f, 0.0f, 1.0f);
            GL11.glRotatef(Math.abs(sajh._b(f3 * (float)Math.PI - 0.2f) * f4) * 5.0f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(f5, 1.0f, 0.0f, 0.0f);
        }
    }

    public void orientCamera(float f) {
        GloomyHooks.orientCameraPre(f);
        EntityLivingBase entityLivingBase = this.mc._u;
        float f2 = entityLivingBase.yOffset - 1.62f;
        double d = entityLivingBase.prevPosX + (entityLivingBase.posX - entityLivingBase.prevPosX) * (double)f;
        double d2 = entityLivingBase.prevPosY + (entityLivingBase.posY - entityLivingBase.prevPosY) * (double)f - (double)f2;
        double d3 = entityLivingBase.prevPosZ + (entityLivingBase.posZ - entityLivingBase.prevPosZ) * (double)f;
        GL11.glRotatef(this.prevCamRoll + (this.camRoll - this.prevCamRoll) * f, 0.0f, 0.0f, 1.0f);
        if (entityLivingBase.isPlayerSleeping()) {
            f2 = (float)((double)f2 + 1.0);
            GL11.glTranslatef(0.0f, 0.3f, 0.0f);
            if (!this.mc._M.debugCamEnable) {
                int n = this.mc._r.getBlockId(sajh._c(entityLivingBase.posX), sajh._c(entityLivingBase.posY), sajh._c(entityLivingBase.posZ));
                if (Reflector.ForgeHooksClient_orientBedCamera.exists()) {
                    Reflector.callVoid(Reflector.ForgeHooksClient_orientBedCamera, this.mc, entityLivingBase);
                } else if (n == Block.bed.blockID) {
                    int n2 = this.mc._r.getBlockMetadata(sajh._c(entityLivingBase.posX), sajh._c(entityLivingBase.posY), sajh._c(entityLivingBase.posZ));
                    int n3 = n2 & 3;
                    GL11.glRotatef(n3 * 90, 0.0f, 1.0f, 0.0f);
                }
                GL11.glRotatef(entityLivingBase.prevRotationYaw + (entityLivingBase.rotationYaw - entityLivingBase.prevRotationYaw) * f + 180.0f, 0.0f, -1.0f, 0.0f);
                GL11.glRotatef(entityLivingBase.prevRotationPitch + (entityLivingBase.rotationPitch - entityLivingBase.prevRotationPitch) * f, -1.0f, 0.0f, 0.0f);
            }
        } else if (this.mc._M.thirdPersonView > 0) {
            double d4 = this.thirdPersonDistanceTemp + (this.thirdPersonDistance - this.thirdPersonDistanceTemp) * f;
            if (this.mc._M.debugCamEnable) {
                float f3 = this.prevDebugCamYaw + (this.debugCamYaw - this.prevDebugCamYaw) * f;
                float f4 = this.prevDebugCamPitch + (this.debugCamPitch - this.prevDebugCamPitch) * f;
                GL11.glTranslatef(0.0f, 0.0f, (float)(-d4));
                GL11.glRotatef(f4, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(f3, 0.0f, 1.0f, 0.0f);
            } else {
                float f5 = entityLivingBase.rotationYaw;
                float f6 = entityLivingBase.rotationPitch;
                if (this.mc._M.thirdPersonView == 2) {
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
                    MovingObjectPosition movingObjectPosition = this.mc._r.func_72933_a(this.mc._r.getWorldVec3Pool()._a(d + (double)(f7 *= 0.1f), d2 + (double)(f8 *= 0.1f), d3 + (double)(f9 *= 0.1f)), this.mc._r.getWorldVec3Pool()._a(d - d5 + (double)f7 + (double)f9, d2 - d7 + (double)f8, d3 - d6 + (double)f9));
                    if (movingObjectPosition == null || !((d8 = movingObjectPosition._h._d(this.mc._r.getWorldVec3Pool()._a(d, d2, d3))) < d4)) continue;
                    d4 = d8;
                }
                if (this.mc._M.thirdPersonView == 2) {
                    GL11.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
                }
                GL11.glRotatef(entityLivingBase.rotationPitch - f6, 1.0f, 0.0f, 0.0f);
                GL11.glRotatef(entityLivingBase.rotationYaw - f5, 0.0f, 1.0f, 0.0f);
                GL11.glTranslatef(0.0f, 0.0f, (float)(-d4));
                GL11.glRotatef(f5 - entityLivingBase.rotationYaw, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(f6 - entityLivingBase.rotationPitch, 1.0f, 0.0f, 0.0f);
            }
        } else {
            GL11.glTranslatef(0.0f, 0.0f, -0.1f);
        }
        if (!this.mc._M.debugCamEnable) {
            GL11.glRotatef(entityLivingBase.prevRotationPitch + (entityLivingBase.rotationPitch - entityLivingBase.prevRotationPitch) * f, 1.0f, 0.0f, 0.0f);
            GL11.glRotatef(entityLivingBase.prevRotationYaw + (entityLivingBase.rotationYaw - entityLivingBase.prevRotationYaw) * f + 180.0f, 0.0f, 1.0f, 0.0f);
        }
        GL11.glTranslatef(0.0f, f2, 0.0f);
        d = entityLivingBase.prevPosX + (entityLivingBase.posX - entityLivingBase.prevPosX) * (double)f;
        d2 = entityLivingBase.prevPosY + (entityLivingBase.posY - entityLivingBase.prevPosY) * (double)f - (double)f2;
        d3 = entityLivingBase.prevPosZ + (entityLivingBase.posZ - entityLivingBase.prevPosZ) * (double)f;
        this.cloudFog = this.mc._s._a(d, d2, d3, f);
        GloomyHooks.orientCameraPost(f);
    }

    public void setupCameraTransform(float f, int n) {
        int n2;
        float f2;
        float f3;
        this.farPlaneDistance = 32 << 3 - this.mc._M.renderDistance;
        this.farPlaneDistance = this.mc._M.ofRenderDistanceFine;
        if (Config.isFogFancy()) {
            this.farPlaneDistance *= 0.95f;
        }
        if (Config.isFogFast()) {
            this.farPlaneDistance *= 0.83f;
        }
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        float f4 = 0.07f;
        if (this.mc._M.anaglyph) {
            GL11.glTranslatef((float)(-(n * 2 - 1)) * f4, 0.0f, 0.0f);
        }
        if ((f3 = this.farPlaneDistance * 2.0f) < 128.0f) {
            f3 = 128.0f;
        }
        if (this.cameraZoom != 1.0) {
            GL11.glTranslatef((float)this.cameraYaw, (float)(-this.cameraPitch), 0.0f);
            GL11.glScaled(this.cameraZoom, this.cameraZoom, 1.0);
        }
        Project.gluPerspective(this.getFOVModifier(f, true), (float)this.mc._n / (float)this.mc._o, 0.05f, f3);
        if (this.mc._j._a()) {
            f2 = 0.6666667f;
            GL11.glScalef(1.0f, f2, 1.0f);
        }
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        if (this.mc._M.anaglyph) {
            GL11.glTranslatef((float)(n * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        this.hurtCameraEffect(f);
        if (this.mc._M.viewBobbing) {
            this.setupViewBobbing(f);
        }
        if ((f2 = this.mc._t.prevTimeInPortal + (this.mc._t.timeInPortal - this.mc._t.prevTimeInPortal) * f) > 0.0f) {
            n2 = 20;
            if (this.mc._t.isPotionActive(Potion._k)) {
                n2 = 7;
            }
            float f5 = 5.0f / (f2 * f2 + 5.0f) - f2 * 0.04f;
            f5 *= f5;
            GL11.glRotatef(((float)this.rendererUpdateCount + f) * (float)n2, 0.0f, 1.0f, 1.0f);
            GL11.glScalef(1.0f / f5, 1.0f, 1.0f);
            GL11.glRotatef(-((float)this.rendererUpdateCount + f) * (float)n2, 0.0f, 1.0f, 1.0f);
        }
        this.orientCamera(f);
        if (this.debugViewDirection > 0) {
            n2 = this.debugViewDirection - 1;
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

    public void renderHand(float f, int n) {
        fmej._a(this, f, n);
        GloomyHooks.renderHand(this, f, n);
        if (GloomyHooks.onRenderHand(this, f, n)) {
            fmej._b(this, f, n);
            GloomyHooks.renderHandPost(this, f, n);
            return;
        }
        if (this.debugViewDirection <= 0) {
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            float f2 = 0.07f;
            if (this.mc._M.anaglyph) {
                GL11.glTranslatef((float)(-(n * 2 - 1)) * f2, 0.0f, 0.0f);
            }
            if (this.cameraZoom != 1.0) {
                GL11.glTranslatef((float)this.cameraYaw, (float)(-this.cameraPitch), 0.0f);
                GL11.glScaled(this.cameraZoom, this.cameraZoom, 1.0);
            }
            Project.gluPerspective(this.getFOVModifier(f, false), (float)this.mc._n / (float)this.mc._o, 0.05f, this.farPlaneDistance * 2.0f);
            if (this.mc._j._a()) {
                float f3 = 0.6666667f;
                GL11.glScalef(1.0f, f3, 1.0f);
            }
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            if (this.mc._M.anaglyph) {
                GL11.glTranslatef((float)(n * 2 - 1) * 0.1f, 0.0f, 0.0f);
            }
            GL11.glPushMatrix();
            this.hurtCameraEffect(f);
            if (this.mc._M.viewBobbing) {
                this.setupViewBobbing(f);
            }
            if (!(this.mc._M.thirdPersonView != 0 || this.mc._u.isPlayerSleeping() || this.mc._M.hideGUI || this.mc._j._a())) {
                this.enableLightmap(f);
                this.itemRenderer.renderItemInFirstPerson(f);
                this.disableLightmap(f);
            }
            GL11.glPopMatrix();
            if (this.mc._M.thirdPersonView == 0 && !this.mc._u.isPlayerSleeping()) {
                this.itemRenderer.renderOverlays(f);
                this.hurtCameraEffect(f);
            }
            if (this.mc._M.viewBobbing) {
                this.setupViewBobbing(f);
            }
        }
        fmej._b(this, f, n);
        GloomyHooks.renderHandPost(this, f, n);
    }

    public void disableLightmap(double d) {
        iwya._a(iwya._b);
        GL11.glDisable(3553);
        iwya._a(iwya._a);
    }

    public void enableLightmap(double d) {
        iwya._a(iwya._b);
        GL11.glMatrixMode(5890);
        GL11.glLoadIdentity();
        float f = 0.00390625f;
        GL11.glScalef(f, f, f);
        GL11.glTranslatef(8.0f, 8.0f, 8.0f);
        GL11.glMatrixMode(5888);
        this.mc._R()._a(this.locationLightMap);
        GL11.glTexParameteri(3553, 10241, 9729);
        GL11.glTexParameteri(3553, 10240, 9729);
        GL11.glTexParameteri(3553, 10242, 10496);
        GL11.glTexParameteri(3553, 10243, 10496);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glEnable(3553);
        iwya._a(iwya._a);
    }

    public void updateTorchFlicker() {
        this.torchFlickerDX = (float)((double)this.torchFlickerDX + (Math.random() - Math.random()) * Math.random() * Math.random());
        this.torchFlickerDY = (float)((double)this.torchFlickerDY + (Math.random() - Math.random()) * Math.random() * Math.random());
        this.torchFlickerDX = (float)((double)this.torchFlickerDX * 0.9);
        this.torchFlickerDY = (float)((double)this.torchFlickerDY * 0.9);
        this.torchFlickerX += (this.torchFlickerDX - this.torchFlickerX) * 1.0f;
        this.torchFlickerY += (this.torchFlickerDY - this.torchFlickerY) * 1.0f;
        this.lightmapUpdateNeeded = true;
    }

    public void updateLightmap(float f) {
        pkix pkix2 = this.mc._r;
        if (pkix2 != null) {
            if (CustomColorizer.updateLightmap(pkix2, this.torchFlickerX, this.lightmapColors, this.mc._t.isPotionActive(Potion._r))) {
                this.lightmapTexture._a();
                this.lightmapUpdateNeeded = false;
                return;
            }
            for (int i = 0; i < 256; ++i) {
                float f2;
                float f3;
                float f4 = pkix2.getSunBrightness(1.0f) * 0.95f + 0.05f;
                float f5 = pkix2.provider._h[i / 16] * f4;
                float f6 = pkix2.provider._h[i % 16] * (this.torchFlickerX * 0.1f + 1.5f);
                if (pkix2.lastLightningBolt > 0) {
                    f5 = pkix2.provider._h[i / 16];
                }
                float f7 = f5 * (pkix2.getSunBrightness(1.0f) * 0.65f + 0.35f);
                float f8 = f5 * (pkix2.getSunBrightness(1.0f) * 0.65f + 0.35f);
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
                if (pkix2.provider._i == 1) {
                    f11 = 0.22f + f6 * 0.75f;
                    f12 = 0.28f + f9 * 0.75f;
                    f13 = 0.25f + f10 * 0.75f;
                }
                if (this.mc._t.isPotionActive(Potion._r)) {
                    f3 = this.getNightVisionBrightness(this.mc._t, f);
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
                f3 = this.mc._M.gammaSetting;
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
                this.lightmapColors[i] = n << 24 | n2 << 16 | n3 << 8 | n4;
            }
            this.lightmapTexture._a();
            this.lightmapUpdateNeeded = false;
        }
        GloomyHooks.updateLightmap(f);
    }

    public float getNightVisionBrightness(EntityPlayer entityPlayer, float f) {
        int n = entityPlayer.getActivePotionEffect(Potion._r)._b();
        return n > 200 ? 1.0f : 0.7f + sajh._a(((float)n - f) * (float)Math.PI * 0.2f) * 0.3f;
    }

    public void updateCameraAndRender(float f) {
        int n;
        this.mc.__ah._a("lightTex");
        if (!this.initialized) {
            TextureUtils.registerResourceListener();
            this.initialized = true;
        }
        Config.checkDisplayMode();
        pkix pkix2 = this.mc._r;
        if (pkix2 != null && Config.getNewRelease() != null) {
            String string = "HD_U " + Config.getNewRelease();
            this.mc._J.getChatGUI()._a("A new \u00a7eOptiFine\u00a7f version is available: \u00a7e" + string + "\u00a7f");
            Config.setNewRelease(null);
        }
        if (this.mc._B instanceof fngq) {
            this.updateMainMenu((fngq)this.mc._B);
        }
        if (this.updatedWorld != pkix2) {
            RandomMobs.worldChanged(this.updatedWorld, pkix2);
            Config.updateThreadPriorities();
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
            this.updatedWorld = pkix2;
        }
        RenderBlocks._e = Config.isGrassFancy() || Config.isBetterGrassFancy();
        Block.leaves._a(Config.isTreesFancy());
        if (this.lightmapUpdateNeeded) {
            this.updateLightmap(f);
        }
        this.mc.__ah._b();
        boolean bl = Display.isActive();
        if (!(bl || !this.mc._M.pauseOnLostFocus || this.mc._M.touchscreen && Mouse.isButtonDown(1))) {
            if (Minecraft._M() - this.prevFrameTime > 500L) {
                this.mc._q();
            }
        } else {
            this.prevFrameTime = Minecraft._M();
        }
        this.mc.__ah._a("mouse");
        if (this.mc.__ab && bl) {
            wnja._a(this.mc._t);
            this.mc._O._c();
            float f2 = this.mc._M.mouseSensitivity * 0.6f + 0.2f;
            float f3 = f2 * f2 * f2 * 8.0f;
            float f4 = (float)this.mc._O._a * f3;
            float f5 = (float)this.mc._O._b * f3;
            n = 1;
            if (this.mc._M.invertMouse) {
                n = -1;
            }
            if (this.mc._M.smoothCamera) {
                this.smoothCamYaw += f4;
                this.smoothCamPitch += f5;
                float f6 = f - this.smoothCamPartialTicks;
                this.smoothCamPartialTicks = f;
                f4 = this.smoothCamFilterX * f6;
                f5 = this.smoothCamFilterY * f6;
                this.mc._t.setAngles(f4, f5 * (float)n);
            } else {
                this.mc._t.setAngles(f4, f5 * (float)n);
            }
            wnja._b(this.mc._t);
        }
        this.mc.__ah._b();
        if (!this.mc._K) {
            anaglyphEnable = this.mc._M.anaglyph;
            htou htou2 = new htou(this.mc._M, this.mc._n, this.mc._o);
            int n2 = htou2._a();
            int n3 = htou2._b();
            int n4 = Mouse.getX() * n2 / this.mc._n;
            n = n3 - Mouse.getY() * n3 / this.mc._o - 1;
            int n5 = EntityRenderer.performanceToFps(this.mc._M.limitFramerate);
            if (this.mc._r != null) {
                this.mc.__ah._a("level");
                if (this.mc._M.limitFramerate == 0) {
                    this.renderWorld(f, 0L);
                } else {
                    this.renderWorld(f, this.renderEndNanoTime + (long)(1000000000 / n5));
                }
                this.renderEndNanoTime = System.nanoTime();
                this.mc.__ah._c("gui");
                if (!this.mc._M.hideGUI || this.mc._B != null) {
                    this.mc._J.renderGameOverlay(f, this.mc._B != null, n4, n);
                }
                this.mc.__ah._b();
            } else {
                GL11.glViewport(0, 0, this.mc._n, this.mc._o);
                GL11.glMatrixMode(5889);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888);
                GL11.glLoadIdentity();
                this.setupOverlayRendering();
                this.renderEndNanoTime = System.nanoTime();
            }
            if (this.mc._B != null) {
                GL11.glClear(256);
                try {
                    this.mc._B.drawScreen(n4, n, f);
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Rendering screen");
                    CrashReportCategory crashReportCategory = crashReport.makeCategory("Screen render details");
                    crashReportCategory._a("Screen name", new cecj(this));
                    crashReportCategory._a("Mouse location", new CallableMouseLocation(this, n4, n));
                    crashReportCategory._a("Screen size", new zhec(this, htou2));
                    throw new turb(crashReport);
                }
            }
        }
        this.waitForServerThread();
        if (this.mc._M.showDebugInfo != this.lastShowDebugInfo) {
            this.showExtendedDebugInfo = this.mc._M.showDebugProfilerChart;
            this.lastShowDebugInfo = this.mc._M.showDebugInfo;
        }
        if (this.mc._M.showDebugInfo) {
            this.showLagometer(this.mc.__ah._i, this.mc.__ah._k);
        }
        if (this.mc._M.ofProfiler) {
            this.mc._M.showDebugProfilerChart = true;
        }
    }

    public void waitForServerThread() {
        this.serverWaitTimeCurrent = 0;
        if (!Config.isSmoothWorld()) {
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
        } else if (this.mc._J() != null) {
            yfci yfci2 = this.mc._J();
            boolean bl = yfci2._a()._f();
            if (bl) {
                if (this.mc._B instanceof iwmg) {
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
        if (this.mc._M.ofLagometer || this.showExtendedDebugInfo) {
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
            GL11.glOrtho(0.0, this.mc._n, this.mc._o, 0.0, 1000.0, 3000.0);
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
            GL11.glLineWidth(1.0f);
            GL11.glDisable(3553);
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawing(1);
            for (int i = 0; i < this.frameTimes.length; ++i) {
                int n2 = (i - this.numRecordedFrameTimes & this.frameTimes.length - 1) * 255 / this.frameTimes.length;
                long l4 = this.frameTimes[i] / 200000L;
                float f = this.mc._o;
                tessellator.setColorOpaque_I(-16777216 + n2 * 256);
                tessellator.addVertex((float)i + 0.5f, f - (float)l4 + 0.5f, 0.0);
                tessellator.addVertex((float)i + 0.5f, f + 0.5f, 0.0);
                long l5 = this.tickTimes[i] / 200000L;
                tessellator.setColorOpaque_I(-16777216 + n2 * 65536 + n2 * 256 + n2 * 1);
                tessellator.addVertex((float)i + 0.5f, (f -= (float)l4) + 0.5f, 0.0);
                tessellator.addVertex((float)i + 0.5f, f + (float)l5 + 0.5f, 0.0);
                long l6 = this.chunkTimes[i] / 200000L;
                tessellator.setColorOpaque_I(-16777216 + n2 * 65536);
                tessellator.addVertex((float)i + 0.5f, (f += (float)l5) + 0.5f, 0.0);
                tessellator.addVertex((float)i + 0.5f, f + (float)l6 + 0.5f, 0.0);
                f += (float)l6;
                long l7 = this.serverTimes[i];
                if (l7 <= 0L) continue;
                long l8 = l7 * 1000000L / 200000L;
                tessellator.setColorOpaque_I(-16777216 + n2 * 1);
                tessellator.addVertex((float)i + 0.5f, f + 0.5f, 0.0);
                tessellator.addVertex((float)i + 0.5f, f + (float)l8 + 0.5f, 0.0);
            }
            tessellator.draw();
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
        Minecraft minecraft = Minecraft._E();
        if (useShader) {
            int n2 = (int)(ntte._b / (long)interpTicks);
            int n3 = n2 + 1;
            float f = (float)(((double)ntte._b + (double)minecraft._p._d) / (double)interpTicks - (double)n2);
            int n4 = (int)((float)sctd._e()._r * sctd._e()._s * 16.0f);
            float f2 = (float)n4 / (float)sctd._e()._p;
            GL13.glActiveTexture(33986);
            minecraft._R()._a(sctd._d);
            GL13.glActiveTexture(33984);
            EntityLivingBase entityLivingBase = minecraft._u;
            double d = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * (double)minecraft._p._d;
            double d2 = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * (double)minecraft._p._d;
            double d3 = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * (double)minecraft._p._d;
            Vec3 vec3 = VecExtensionsKt.vec3();
            jxtc jxtc2 = jxtc._a(minecraft._t);
            if (jxtc2 != null && jxtc2._m() > 0 && !ClientProxy.hideThrowMarker.enabled) {
                VecExtensionsKt.set(vec3, throwHintPos);
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
                terrainShader._a("throwCirclePos", (float)vec3._c, (float)vec3._d, (float)vec3._e);
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

    public void renderWorld(float f, long l) {
        pidb._a(this, f, l);
        gloomyfolken.mods.anticheat.pidb._a(this, f, l);
        this.mc.__ah._a("lightTex");
        if (this.lightmapUpdateNeeded) {
            this.updateLightmap(f);
        }
        GL11.glEnable(2884);
        GL11.glEnable(2929);
        if (this.mc._u == null) {
            this.mc._u = this.mc._t;
        }
        this.mc.__ah._c("pick");
        this.getMouseOver(f);
        EntityLivingBase entityLivingBase = this.mc._u;
        cvgz cvgz2 = this.mc._s;
        EffectRenderer effectRenderer = this.mc._w;
        double d = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * (double)f;
        double d2 = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * (double)f;
        double d3 = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * (double)f;
        this.mc.__ah._c("center");
        for (int i = 0; i < 2; ++i) {
            EntityPlayer entityPlayer;
            if (this.mc._M.anaglyph) {
                anaglyphField = i;
                if (anaglyphField == 0) {
                    GL11.glColorMask(false, true, true, false);
                } else {
                    GL11.glColorMask(true, false, false, false);
                }
            }
            this.mc.__ah._c("clear");
            GL11.glViewport(0, 0, this.mc._n, this.mc._o);
            this.updateFogColor(f);
            GL11.glClear(16640);
            GL11.glEnable(2884);
            this.mc.__ah._c("camera");
            this.setupCameraTransform(f, i);
            tfss._a(this.mc._t, this.mc._M.thirdPersonView == 2);
            this.mc.__ah._c("frustrum");
            qnnz._a();
            if (!(Config.isSkyEnabled() || Config.isSunMoonEnabled() || Config.isStarsEnabled())) {
                GL11.glDisable(3042);
            } else {
                this.setupFog(-1, f);
                this.mc.__ah._c("sky");
                cvgz2._a(f);
            }
            GL11.glEnable(2912);
            this.setupFog(1, f);
            if (this.mc._M.ambientOcclusion != 0) {
                GL11.glShadeModel(7425);
            }
            this.mc.__ah._c("culling");
            bseg bseg2 = new bseg();
            bseg2._a(d, d2, d3);
            this.mc._s._a(bseg2, f);
            if (i == 0) {
                long l2;
                this.mc.__ah._c("updatechunks");
                while (!this.mc._s._a(entityLivingBase, false) && l != 0L && (l2 = l - System.nanoTime()) >= 0L && l2 <= 1000000000L) {
                }
            }
            if (entityLivingBase.posY < 128.0) {
                this.renderCloudsCheck(cvgz2, f);
            }
            this.mc.__ah._c("prepareterrain");
            this.setupFog(0, f);
            GL11.glEnable(2912);
            this.mc._R()._a(sctd._c);
            qnon._a();
            this.mc.__ah._c("terrain");
            EntityRenderer.enableTerrainShader(0);
            cvgz2._a(entityLivingBase, 0, (double)f);
            EntityRenderer.disableTerrainShader();
            GL11.glShadeModel(7424);
            boolean bl = Reflector.ForgeHooksClient.exists();
            if (this.debugViewDirection == 0) {
                qnon._b();
                this.mc.__ah._c("entities");
                ForgeHooksClient.setRenderPass(0);
                cvgz2._a(entityLivingBase.getPosition(f), bseg2, f);
                ForgeHooksClient.setRenderPass(-1);
                qnon._a();
                if (this.mc._L != null && entityLivingBase.isInsideOfMaterial(Material._h) && entityLivingBase instanceof EntityPlayer && !this.mc._M.hideGUI) {
                    entityPlayer = (EntityPlayer)entityLivingBase;
                    GL11.glDisable(3008);
                    this.mc.__ah._c("outline");
                    if (!(bl && Reflector.callBoolean(Reflector.ForgeHooksClient_onDrawBlockHighlight, cvgz2, entityPlayer, this.mc._L, 0, entityPlayer.inventory._a(), Float.valueOf(f)) || this.mc._M.hideGUI)) {
                        cvgz2._a(entityPlayer, this.mc._L, 0, f);
                    }
                    GL11.glEnable(3008);
                }
            }
            GL11.glDisable(3042);
            GL11.glEnable(2884);
            GL11.glBlendFunc(770, 771);
            GL11.glDepthMask(true);
            this.setupFog(0, f);
            GL11.glEnable(3042);
            GL11.glDisable(2884);
            this.mc._R()._a(sctd._c);
            WrUpdates.resumeBackgroundUpdates();
            EntityRenderer.enableTerrainShader(1);
            if (Config.isWaterFancy()) {
                this.mc.__ah._c("water");
                if (this.mc._M.ambientOcclusion != 0) {
                    GL11.glShadeModel(7425);
                }
                GL11.glColorMask(false, false, false, false);
                int n = cvgz2._b(1, f);
                if (this.mc._M.anaglyph) {
                    if (anaglyphField == 0) {
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
                this.mc.__ah._c("water");
                cvgz2._b(1, f);
            }
            EntityRenderer.disableTerrainShader();
            WrUpdates.pauseBackgroundUpdates();
            McChunkCommandQueue.runTasks();
            if (bl && this.debugViewDirection == 0) {
                qnon._b();
                this.mc.__ah._c("entities");
                ForgeHooksClient.setRenderPass(1);
                this.mc._s._a(entityLivingBase.getPosition(f), bseg2, f);
                ForgeHooksClient.setRenderPass(-1);
                qnon._a();
            }
            GL11.glDepthMask(true);
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            if (this.cameraZoom == 1.0 && entityLivingBase instanceof EntityPlayer && !this.mc._M.hideGUI && this.mc._L != null && !entityLivingBase.isInsideOfMaterial(Material._h)) {
                entityPlayer = (EntityPlayer)entityLivingBase;
                GL11.glDisable(3008);
                this.mc.__ah._c("outline");
                if (!(bl && Reflector.callBoolean(Reflector.ForgeHooksClient_onDrawBlockHighlight, cvgz2, entityPlayer, this.mc._L, 0, entityPlayer.inventory._a(), Float.valueOf(f)) || this.mc._M.hideGUI)) {
                    cvgz2._a(entityPlayer, this.mc._L, 0, f);
                }
                GL11.glEnable(3008);
            }
            this.mc.__ah._c("destroyProgress");
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 1);
            cvgz2._a(Tessellator.instance, entityLivingBase, f);
            GL11.glDisable(3042);
            this.mc.__ah._c("weather");
            this.renderRainSnow(f);
            GL11.glDisable(2912);
            if (entityLivingBase.posY >= 128.0) {
                this.renderCloudsCheck(cvgz2, f);
            }
            this.enableLightmap(f);
            this.mc.__ah._c("litParticles");
            qnon._b();
            effectRenderer._b(entityLivingBase, f);
            qnon._a();
            this.setupFog(0, f);
            this.mc.__ah._c("particles");
            effectRenderer._a(entityLivingBase, f);
            this.disableLightmap(f);
            if (bl) {
                this.mc.__ah._c("FRenderLast");
                Reflector.callVoid(Reflector.ForgeHooksClient_dispatchRenderLast, cvgz2, Float.valueOf(f));
            }
            this.mc.__ah._c("hand");
            if (this.cameraZoom == 1.0) {
                GL11.glClear(256);
                this.renderHand(f, i);
            }
            if (this.mc._M.anaglyph) continue;
            this.mc.__ah._b();
            gloomyfolken.mods.anticheat.pidb._b(this, f, l);
            fmej._a(this, f, l);
            return;
        }
        GL11.glColorMask(true, true, true, false);
        this.mc.__ah._b();
        gloomyfolken.mods.anticheat.pidb._b(this, f, l);
        fmej._a(this, f, l);
    }

    public void renderCloudsCheck(cvgz cvgz2, float f) {
        if (this.mc._M.shouldRenderClouds()) {
            this.mc.__ah._c("clouds");
            GL11.glPushMatrix();
            this.setupFog(0, f);
            GL11.glEnable(2912);
            cvgz2._b(f);
            GL11.glDisable(2912);
            this.setupFog(1, f);
            GL11.glPopMatrix();
        }
    }

    public void addRainParticles() {
        float f = this.mc._r.getRainStrength(1.0f);
        if (!Config.isRainFancy()) {
            f /= 2.0f;
        }
        if (Config.isRainSplash()) {
            this.random.setSeed((long)this.rendererUpdateCount * 312987231L);
            EntityLivingBase entityLivingBase = this.mc._u;
            pkix pkix2 = this.mc._r;
            int n = sajh._c(entityLivingBase.posX);
            int n2 = sajh._c(entityLivingBase.posY);
            int n3 = sajh._c(entityLivingBase.posZ);
            int n4 = 10;
            double d = 0.0;
            double d2 = 0.0;
            double d3 = 0.0;
            int n5 = 0;
            int n6 = (int)(100.0f * f * f);
            if (this.mc._M.particleSetting == 1) {
                n6 >>= 1;
            } else if (this.mc._M.particleSetting == 2) {
                n6 = 0;
            }
            for (int i = 0; i < n6; ++i) {
                int n7 = n + this.random.nextInt(n4) - this.random.nextInt(n4);
                int n8 = n3 + this.random.nextInt(n4) - this.random.nextInt(n4);
                int n9 = pkix2.getPrecipitationHeight(n7, n8);
                int n10 = pkix2.getBlockId(n7, n9 - 1, n8);
                BiomeGenBase biomeGenBase = pkix2.getBiomeGenForCoords(n7, n8);
                if (n9 > n2 + n4 || n9 < n2 - n4 || !biomeGenBase._e() || !(biomeGenBase._k() >= 0.2f)) continue;
                float f2 = this.random.nextFloat();
                float f3 = this.random.nextFloat();
                if (n10 <= 0) continue;
                if (Block.blocksList[n10].blockMaterial == Material._i) {
                    this.mc._w._a(new EntitySmokeFX(pkix2, (float)n7 + f2, (double)((float)n9 + 0.1f) - Block.blocksList[n10].getBlockBoundsMinY(), (float)n8 + f3, 0.0, 0.0, 0.0));
                    continue;
                }
                if (this.random.nextInt(++n5) == 0) {
                    d = (float)n7 + f2;
                    d2 = (double)((float)n9 + 0.1f) - Block.blocksList[n10].getBlockBoundsMinY();
                    d3 = (float)n8 + f3;
                }
                EntityRainFX entityRainFX = new EntityRainFX(pkix2, (float)n7 + f2, (double)((float)n9 + 0.1f) - Block.blocksList[n10].getBlockBoundsMinY(), (float)n8 + f3);
                CustomColorizer.updateWaterFX(entityRainFX, pkix2);
                this.mc._w._a(entityRainFX);
            }
            if (n5 > 0 && this.random.nextInt(3) < this.rainSoundCounter++) {
                this.rainSoundCounter = 0;
                if (d2 > entityLivingBase.posY + 1.0 && pkix2.getPrecipitationHeight(sajh._c(entityLivingBase.posX), sajh._c(entityLivingBase.posZ)) > sajh._c(entityLivingBase.posY)) {
                    this.mc._r.playSound(d, d2, d3, "ambient.weather.rain", 0.1f, 0.5f, false);
                } else {
                    this.mc._r.playSound(d, d2, d3, "ambient.weather.rain", 0.2f, 1.0f, false);
                }
            }
        }
    }

    public void renderRainSnow(float f) {
        boolean bl = fmej._a(this, f);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        float f2 = this.mc._r.getRainStrength(f);
        if (f2 > 0.0f) {
            this.enableLightmap(f);
            if (this.rainXCoords == null) {
                this.rainXCoords = new float[1024];
                this.rainYCoords = new float[1024];
                for (int i = 0; i < 32; ++i) {
                    for (int j = 0; j < 32; ++j) {
                        float f3 = j - 16;
                        float f4 = i - 16;
                        float f5 = sajh._c(f3 * f3 + f4 * f4);
                        this.rainXCoords[i << 5 | j] = -f4 / f5;
                        this.rainYCoords[i << 5 | j] = f3 / f5;
                    }
                }
            }
            if (Config.isRainOff()) {
                return;
            }
            EntityLivingBase entityLivingBase = this.mc._u;
            pkix pkix2 = this.mc._r;
            int n = sajh._c(entityLivingBase.posX);
            int n2 = sajh._c(entityLivingBase.posY);
            int n3 = sajh._c(entityLivingBase.posZ);
            Tessellator tessellator = Tessellator.instance;
            GL11.glDisable(2884);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glAlphaFunc(516, 0.01f);
            this.mc._R()._a(locationSnowPng);
            double d = entityLivingBase.lastTickPosX + (entityLivingBase.posX - entityLivingBase.lastTickPosX) * (double)f;
            double d2 = entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * (double)f;
            double d3 = entityLivingBase.lastTickPosZ + (entityLivingBase.posZ - entityLivingBase.lastTickPosZ) * (double)f;
            int n4 = sajh._c(d2);
            int n5 = 5;
            if (Config.isRainFancy()) {
                n5 = 10;
            }
            boolean bl3 = false;
            int n6 = -1;
            float f6 = (float)this.rendererUpdateCount + f;
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
                    float f8 = this.rainXCoords[n7] * 0.5f;
                    float f9 = this.rainYCoords[n7] * 0.5f;
                    BiomeGenBase biomeGenBase = pkix2.getBiomeGenForCoords(j, i);
                    if (!biomeGenBase._e() && !biomeGenBase._d()) continue;
                    int n8 = pkix2.getPrecipitationHeight(j, i);
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
                    this.random.setSeed(j * j * 3121 + j * 45238971 ^ i * i * 418711 + i * 13761);
                    float f11 = biomeGenBase._k();
                    if (pkix2.getWorldChunkManager()._a(f11, n8) >= 0.15f) {
                        if (n6 != 0) {
                            if (n6 >= 0) {
                                tessellator.draw();
                            }
                            n6 = 0;
                            this.mc._R()._a(locationRainPng);
                            tessellator.startDrawingQuads();
                        }
                        f7 = ((float)(this.rendererUpdateCount + j * j * 3121 + j * 45238971 + i * i * 418711 + i * 13761 & 0x1F) + f) / 32.0f * (3.0f + this.random.nextFloat());
                        double d5 = (double)((float)j + 0.5f) - entityLivingBase.posX;
                        d4 = (double)((float)i + 0.5f) - entityLivingBase.posZ;
                        float f12 = sajh._a(d5 * d5 + d4 * d4) / (float)n5;
                        float f13 = 1.0f;
                        tessellator.setBrightness(pkix2.getLightBrightnessForSkyBlocks(j, n11, i, 0));
                        tessellator.setColorRGBA_F(f13, f13, f13, ((1.0f - f12 * f12) * 0.5f + 0.5f) * f2);
                        tessellator.setTranslation(-d * 1.0, -d2 * 1.0, -d3 * 1.0);
                        tessellator.addVertexWithUV((double)((float)j - f8) + 0.5, n9, (double)((float)i - f9) + 0.5, 0.0f * f10, (float)n9 * f10 / 4.0f + f7 * f10);
                        tessellator.addVertexWithUV((double)((float)j + f8) + 0.5, n9, (double)((float)i + f9) + 0.5, 1.0f * f10, (float)n9 * f10 / 4.0f + f7 * f10);
                        tessellator.addVertexWithUV((double)((float)j + f8) + 0.5, n10, (double)((float)i + f9) + 0.5, 1.0f * f10, (float)n10 * f10 / 4.0f + f7 * f10);
                        tessellator.addVertexWithUV((double)((float)j - f8) + 0.5, n10, (double)((float)i - f9) + 0.5, 0.0f * f10, (float)n10 * f10 / 4.0f + f7 * f10);
                        tessellator.setTranslation(0.0, 0.0, 0.0);
                        continue;
                    }
                    if (n6 != 1) {
                        if (n6 >= 0) {
                            tessellator.draw();
                        }
                        n6 = 1;
                        this.mc._R()._a(new ResourceLocation("textures/environment/snow.png"));
                        tessellator.startDrawingQuads();
                    }
                    f7 = ((float)(this.rendererUpdateCount & 0x1FF) + f) / 512.0f;
                    float f14 = this.random.nextFloat() + f6 * 0.01f * (float)this.random.nextGaussian();
                    float f15 = this.random.nextFloat() + f6 * (float)this.random.nextGaussian() * 0.001f;
                    d4 = (double)((float)j + 0.5f) - entityLivingBase.posX;
                    double d6 = (double)((float)i + 0.5f) - entityLivingBase.posZ;
                    float f16 = sajh._a(d4 * d4 + d6 * d6) / (float)n5;
                    float f17 = 1.0f;
                    tessellator.setBrightness((pkix2.getLightBrightnessForSkyBlocks(j, n11, i, 0) * 3 + 0xF000F0) / 4);
                    tessellator.setColorRGBA_F(f17, f17, f17, ((1.0f - f16 * f16) * 0.3f + 0.5f) * f2);
                    tessellator.setTranslation(-d * 1.0, -d2 * 1.0, -d3 * 1.0);
                    tessellator.addVertexWithUV((double)((float)j - f8) + 0.5, n9, (double)((float)i - f9) + 0.5, 0.0f * f10 + f14, (float)n9 * f10 / 4.0f + f7 * f10 + f15);
                    tessellator.addVertexWithUV((double)((float)j + f8) + 0.5, n9, (double)((float)i + f9) + 0.5, 1.0f * f10 + f14, (float)n9 * f10 / 4.0f + f7 * f10 + f15);
                    tessellator.addVertexWithUV((double)((float)j + f8) + 0.5, n10, (double)((float)i + f9) + 0.5, 1.0f * f10 + f14, (float)n10 * f10 / 4.0f + f7 * f10 + f15);
                    tessellator.addVertexWithUV((double)((float)j - f8) + 0.5, n10, (double)((float)i - f9) + 0.5, 0.0f * f10 + f14, (float)n10 * f10 / 4.0f + f7 * f10 + f15);
                    tessellator.setTranslation(0.0, 0.0, 0.0);
                }
            }
            if (n6 >= 0) {
                tessellator.draw();
            }
            GL11.glEnable(2884);
            GL11.glDisable(3042);
            GL11.glAlphaFunc(516, 0.1f);
            this.disableLightmap(f);
        }
    }

    public void setupOverlayRendering() {
        htou htou2 = new htou(this.mc._M, this.mc._n, this.mc._o);
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, htou2._c(), htou2._d(), 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
    }

    public void updateFogColor(float f) {
        float f2;
        float f3;
        float f4;
        pkix pkix2 = this.mc._r;
        EntityLivingBase entityLivingBase = this.mc._u;
        float f5 = 1.0f / (float)(4 - this.mc._M.renderDistance);
        f5 = 1.0f - (float)Math.pow(f5, 0.25);
        Vec3 vec3 = pkix2.getSkyColor(this.mc._u, f);
        int n = pkix2.provider._i;
        switch (n) {
            case 0: {
                vec3 = CustomColorizer.getSkyColor(vec3, this.mc._r, this.mc._u.posX, this.mc._u.posY + 1.0, this.mc._u.posZ);
                break;
            }
            case 1: {
                vec3 = CustomColorizer.getSkyColorEnd(vec3);
            }
        }
        float f6 = (float)vec3._c;
        float f7 = (float)vec3._d;
        float f8 = (float)vec3._e;
        Vec3 vec32 = pkix2.getFogColor(f);
        switch (n) {
            case -1: {
                vec32 = CustomColorizer.getFogColorNether(vec32);
                break;
            }
            case 0: {
                vec32 = CustomColorizer.getFogColor(vec32, this.mc._r, this.mc._u.posX, this.mc._u.posY + 1.0, this.mc._u.posZ);
                break;
            }
            case 1: {
                vec32 = CustomColorizer.getFogColorEnd(vec32);
            }
        }
        this.fogColorRed = (float)vec32._c;
        this.fogColorGreen = (float)vec32._d;
        this.fogColorBlue = (float)vec32._e;
        if (this.mc._M.renderDistance < 2) {
            float[] fArray;
            Vec3 vec33 = sajh._a(pkix2.getCelestialAngleRadians(f)) > 0.0f ? pkix2.getWorldVec3Pool()._a(-1.0, 0.0, 0.0) : pkix2.getWorldVec3Pool()._a(1.0, 0.0, 0.0);
            f4 = (float)entityLivingBase.getLook(f)._b(vec33);
            if (f4 < 0.0f) {
                f4 = 0.0f;
            }
            if (f4 > 0.0f && (fArray = pkix2.provider._a(pkix2.getCelestialAngle(f), f)) != null) {
                this.fogColorRed = this.fogColorRed * (1.0f - (f4 *= fArray[3])) + fArray[0] * f4;
                this.fogColorGreen = this.fogColorGreen * (1.0f - f4) + fArray[1] * f4;
                this.fogColorBlue = this.fogColorBlue * (1.0f - f4) + fArray[2] * f4;
            }
        }
        this.fogColorRed += (f6 - this.fogColorRed) * f5;
        this.fogColorGreen += (f7 - this.fogColorGreen) * f5;
        this.fogColorBlue += (f8 - this.fogColorBlue) * f5;
        float f9 = pkix2.getRainStrength(f);
        if (f9 > 0.0f) {
            f4 = 1.0f - f9 * 0.5f;
            float f10 = 1.0f - f9 * 0.4f;
            this.fogColorRed *= f4;
            this.fogColorGreen *= f4;
            this.fogColorBlue *= f10;
        }
        if ((f4 = pkix2.getWeightedThunderStrength(f)) > 0.0f) {
            float f11 = 1.0f - f4 * 0.5f;
            this.fogColorRed *= f11;
            this.fogColorGreen *= f11;
            this.fogColorBlue *= f11;
        }
        int n2 = tfss._a(this.mc._r, entityLivingBase, f);
        if (this.cloudFog) {
            Vec3 vec34 = pkix2.getCloudColour(f);
            this.fogColorRed = (float)vec34._c;
            this.fogColorGreen = (float)vec34._d;
            this.fogColorBlue = (float)vec34._e;
        } else if (n2 != 0 && Block.blocksList[n2].blockMaterial == Material._h) {
            f3 = (float)zhty._b(entityLivingBase) * 0.2f;
            this.fogColorRed = 0.02f + f3;
            this.fogColorGreen = 0.02f + f3;
            this.fogColorBlue = 0.2f + f3;
            Vec3 vec35 = CustomColorizer.getUnderwaterColor(this.mc._r, this.mc._u.posX, this.mc._u.posY + 1.0, this.mc._u.posZ);
            if (vec35 != null) {
                this.fogColorRed = (float)vec35._c;
                this.fogColorGreen = (float)vec35._d;
                this.fogColorBlue = (float)vec35._e;
            }
        } else if (n2 != 0 && Block.blocksList[n2].blockMaterial == Material._i) {
            this.fogColorRed = 0.6f;
            this.fogColorGreen = 0.1f;
            this.fogColorBlue = 0.0f;
        }
        f3 = this.fogColor2 + (this.fogColor1 - this.fogColor2) * f;
        this.fogColorRed *= f3;
        this.fogColorGreen *= f3;
        this.fogColorBlue *= f3;
        double d = pkix2.provider._k();
        if (!Config.isDepthFog()) {
            d = 1.0;
        }
        double d2 = (entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * (double)f) * d;
        if (entityLivingBase.isPotionActive(Potion._q)) {
            int n3 = entityLivingBase.getActivePotionEffect(Potion._q)._b();
            d2 = n3 < 20 ? (d2 *= (double)(1.0f - (float)n3 / 20.0f)) : 0.0;
        }
        if (d2 < 1.0) {
            if (d2 < 0.0) {
                d2 = 0.0;
            }
            d2 *= d2;
            this.fogColorRed = (float)((double)this.fogColorRed * d2);
            this.fogColorGreen = (float)((double)this.fogColorGreen * d2);
            this.fogColorBlue = (float)((double)this.fogColorBlue * d2);
        }
        if (this.field_82831_U > 0.0f) {
            float f12 = this.field_82832_V + (this.field_82831_U - this.field_82832_V) * f;
            this.fogColorRed = this.fogColorRed * (1.0f - f12) + this.fogColorRed * 0.7f * f12;
            this.fogColorGreen = this.fogColorGreen * (1.0f - f12) + this.fogColorGreen * 0.6f * f12;
            this.fogColorBlue = this.fogColorBlue * (1.0f - f12) + this.fogColorBlue * 0.6f * f12;
        }
        if (entityLivingBase.isPotionActive(Potion._r)) {
            float f13 = this.getNightVisionBrightness(this.mc._t, f);
            f2 = 1.0f / this.fogColorRed;
            if (f2 > 1.0f / this.fogColorGreen) {
                f2 = 1.0f / this.fogColorGreen;
            }
            if (f2 > 1.0f / this.fogColorBlue) {
                f2 = 1.0f / this.fogColorBlue;
            }
            this.fogColorRed = this.fogColorRed * (1.0f - f13) + this.fogColorRed * f2 * f13;
            this.fogColorGreen = this.fogColorGreen * (1.0f - f13) + this.fogColorGreen * f2 * f13;
            this.fogColorBlue = this.fogColorBlue * (1.0f - f13) + this.fogColorBlue * f2 * f13;
        }
        if (this.mc._M.anaglyph) {
            float f14 = (this.fogColorRed * 30.0f + this.fogColorGreen * 59.0f + this.fogColorBlue * 11.0f) / 100.0f;
            f2 = (this.fogColorRed * 30.0f + this.fogColorGreen * 70.0f) / 100.0f;
            float f15 = (this.fogColorRed * 30.0f + this.fogColorBlue * 70.0f) / 100.0f;
            this.fogColorRed = f14;
            this.fogColorGreen = f2;
            this.fogColorBlue = f15;
        }
        GL11.glClearColor(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 0.0f);
        ezey._a();
    }

    public void setupFog(int n, float f) {
        boolean bl = fmej._a(this, n, f);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        EntityLivingBase entityLivingBase = this.mc._u;
        boolean bl3 = false;
        this.fogStandard = false;
        if (entityLivingBase instanceof EntityPlayer) {
            bl3 = ((EntityPlayer)entityLivingBase).capabilities._d;
        }
        if (n == 999) {
            GL11.glFog(2918, this.setFogColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
            GL11.glFogi(2917, 9729);
            GL11.glFogf(2915, 0.0f);
            GL11.glFogf(2916, 8.0f);
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                GL11.glFogi(34138, 34139);
            }
            GL11.glFogf(2915, 0.0f);
        } else {
            GL11.glFog(2918, this.setFogColorBuffer(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 1.0f));
            GL11.glNormal3f(0.0f, -1.0f, 0.0f);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            int n2 = tfss._a(this.mc._r, entityLivingBase, f);
            if (entityLivingBase.isPotionActive(Potion._q)) {
                float f2 = 5.0f;
                int n3 = entityLivingBase.getActivePotionEffect(Potion._q)._b();
                if (n3 < 20) {
                    f2 = 5.0f + (this.farPlaneDistance - 5.0f) * (1.0f - (float)n3 / 20.0f);
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
            } else if (this.cloudFog) {
                GL11.glFogi(2917, 2048);
                GL11.glFogf(2914, 0.1f);
            } else if (n2 > 0 && Block.blocksList[n2].blockMaterial == Material._h) {
                GL11.glFogi(2917, 2048);
                if (entityLivingBase.isPotionActive(Potion._o)) {
                    GL11.glFogf(2914, 0.05f);
                } else {
                    GL11.glFogf(2914, 0.1f - (float)zhty._b(entityLivingBase) * 0.03f);
                }
                if (Config.isClearWater()) {
                    GL11.glFogf(2914, 0.02f);
                }
            } else if (n2 > 0 && Block.blocksList[n2].blockMaterial == Material._i) {
                GL11.glFogi(2917, 2048);
                GL11.glFogf(2914, 2.0f);
            } else {
                double d;
                float f3 = this.farPlaneDistance;
                this.fogStandard = true;
                if (Config.isDepthFog() && this.mc._r.provider._j() && !bl3 && (d = (double)((entityLivingBase.getBrightnessForRender(f) & 0xF00000) >> 20) / 16.0 + (entityLivingBase.lastTickPosY + (entityLivingBase.posY - entityLivingBase.lastTickPosY) * (double)f + 4.0) / 32.0) < 1.0) {
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
                if (this.mc._r.provider._b((int)entityLivingBase.posX, (int)entityLivingBase.posZ)) {
                    f5 = 0.05f;
                    f6 = 1.0f;
                    f3 = this.farPlaneDistance;
                }
                GL11.glFogf(2915, f3 * f5);
                GL11.glFogf(2916, f3 * f6);
            }
            GL11.glEnable(2903);
            GL11.glColorMaterial(1028, 4608);
        }
    }

    public FloatBuffer setFogColorBuffer(float f, float f2, float f3, float f4) {
        this.fogColorBuffer.clear();
        this.fogColorBuffer.put(f).put(f2).put(f3).put(f4);
        this.fogColorBuffer.flip();
        return this.fogColorBuffer;
    }

    public static int performanceToFps(int n) {
        Minecraft minecraft = Config.getMinecraft();
        if (minecraft._B != null && minecraft._B instanceof fngq) {
            return 35;
        }
        if (minecraft._r == null) {
            return 35;
        }
        int n2 = Config.getGameSettings().ofLimitFramerateFine;
        if (n2 <= 0) {
            n2 = 10000;
        }
        return n2;
    }

    public static Minecraft getRendererMinecraft(EntityRenderer entityRenderer) {
        return entityRenderer.mc;
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

