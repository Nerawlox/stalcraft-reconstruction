/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.settings;

import gloomyfolken.mods.asm.GloomyHooks;
import gloomyfolken.mods.stalker.misc.qlgf;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import mcoptifine.Config;
import mcoptifine.CustomColorizer;
import mcoptifine.CustomSky;
import mcoptifine.NaturalTextures;
import mcoptifine.RandomMobs;
import mcoptifine.Reflector;
import mcoptifine.TextureUtils;
import mcoptifine.WrUpdaterThreaded;
import mcoptifine.WrUpdates;
import net.minecraft.client.settings.eidj;
import net.minecraft.client.settings.kjui;
import net.minecraft.client.xpzm;
import net.minecraft.util.sajh;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class GameSettings {
    public static final String[] field_74360_ac = new String[]{"options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"};
    public static final String[] field_74361_ad = new String[]{"options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"};
    public static final String[] field_74367_ae = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
    public static final String[] field_74369_af = new String[]{"options.chat.visibility.full", "options.chat.visibility.system", "options.chat.visibility.hidden"};
    public static final String[] field_74364_ag = new String[]{"options.particles.all", "options.particles.decreased", "options.particles.minimal"};
    public static final String[] field_74365_ah = new String[]{"performance.max", "performance.balanced", "performance.powersaver"};
    public static final String[] field_98303_au = new String[]{"options.ao.off", "options.ao.min", "options.ao.max"};
    public float field_74342_a = 1.0f;
    public float field_74340_b = 1.0f;
    public float field_74341_c = 0.5f;
    public boolean field_74338_d;
    public int field_74339_e = 1;
    public boolean field_74336_f = true;
    public boolean field_74337_g;
    public boolean field_74349_h;
    public int field_74350_i = 0;
    public boolean field_74347_j = true;
    public int field_74348_k = 2;
    public boolean field_74345_l = false;
    public int ofRenderDistanceFine = 128;
    public int ofLimitFramerateFine = 0;
    public int ofFogType = 3;
    public float ofFogStart = 0.8f;
    public int ofMipmapLevel = 4;
    public int ofMipmapType = 3;
    public boolean ofLoadFar = false;
    public int ofPreloadedChunks = 0;
    public boolean ofOcclusionFancy = false;
    public boolean ofSmoothFps = false;
    public boolean ofSmoothWorld = false;
    public boolean ofLazyChunkLoading = false;
    public float ofAoLevel = 1.0f;
    public int ofAaLevel = 0;
    public int ofAfLevel = 1;
    public int ofClouds = 3;
    public float ofCloudsHeight = 0.0f;
    public int ofTrees = 1;
    public int ofGrass = 1;
    public int ofRain = 0;
    public int ofWater = 0;
    public int ofDroppedItems = 0;
    public int ofBetterGrass = 2;
    public int ofAutoSaveTicks = 36000;
    public boolean ofLagometer = true;
    public boolean ofProfiler = true;
    public boolean ofWeather = true;
    public boolean ofSky = true;
    public boolean ofStars = true;
    public boolean ofSunMoon = true;
    public int ofChunkUpdates = 1;
    public int ofChunkLoading = 0;
    public boolean ofChunkUpdatesDynamic = false;
    public int ofTime = 0;
    public boolean ofClearWater = false;
    public boolean ofDepthFog = false;
    public boolean ofBetterSnow = false;
    public String ofFullscreenMode = "Default";
    public boolean ofSwampColors = true;
    public boolean ofRandomMobs = false;
    public boolean ofSmoothBiomes = true;
    public boolean ofCustomFonts = true;
    public boolean ofCustomColors = true;
    public boolean ofCustomSky = true;
    public boolean ofShowCapes = false;
    public int ofConnectedTextures = 2;
    public boolean ofNaturalTextures = false;
    public boolean ofFastMath = false;
    public int ofAnimatedWater = 0;
    public int ofAnimatedLava = 0;
    public boolean ofAnimatedFire = true;
    public boolean ofAnimatedPortal = true;
    public boolean ofAnimatedRedstone = true;
    public boolean ofAnimatedExplosion = true;
    public boolean ofAnimatedFlame = true;
    public boolean ofAnimatedSmoke = true;
    public boolean ofVoidParticles = true;
    public boolean ofWaterParticles = true;
    public boolean ofRainSplash = true;
    public boolean ofPortalParticles = true;
    public boolean ofPotionParticles = true;
    public boolean ofDrippingWaterLava = true;
    public boolean ofAnimatedTerrain = true;
    public boolean ofAnimatedItems = true;
    public boolean ofAnimatedTextures = true;
    public static final int DEFAULT = 0;
    public static final int FAST = 1;
    public static final int FANCY = 2;
    public static final int OFF = 3;
    public static final int ANIM_ON = 0;
    public static final int ANIM_GENERATED = 1;
    public static final int ANIM_OFF = 2;
    public static final int CL_DEFAULT = 0;
    public static final int CL_SMOOTH = 1;
    public static final int CL_THREADED = 2;
    public static final String DEFAULT_STR = "Default";
    public eidj ofKeyBindZoom;
    public String field_74346_m = "Default";
    public int field_74343_n;
    public boolean field_74344_o = true;
    public boolean field_74359_p = true;
    public boolean field_74358_q = true;
    public float field_74357_r = 1.0f;
    public boolean field_74356_s = true;
    public boolean field_74355_t = true;
    public boolean field_74353_u;
    public boolean field_74352_v = false;
    public boolean field_80005_w;
    public boolean field_82882_x;
    public boolean field_82881_y = true;
    public boolean field_82880_z = true;
    public boolean field_85185_A;
    public int field_92118_B;
    public int field_92119_C;
    public boolean field_92117_D = true;
    public float field_96691_E = 1.0f;
    public float field_96692_F = 1.0f;
    public float field_96693_G = 0.44366196f;
    public float field_96694_H = 1.0f;
    public eidj field_74351_w = new eidj("key.forward", 17);
    public eidj field_74370_x = new eidj("key.left", 30);
    public eidj field_74368_y = new eidj("key.back", 31);
    public eidj field_74366_z = new eidj("key.right", 32);
    public eidj field_74314_A = new eidj("key.jump", 57);
    public eidj field_74315_B = new eidj("key.inventory", 18);
    public eidj field_74316_C = new eidj("key.drop", 16);
    public eidj field_74310_D = new eidj("key.chat", 20);
    public eidj field_74311_E = new eidj("key.sneak", 42);
    public eidj field_74312_F = new eidj("key.attack", -100);
    public eidj field_74313_G = new eidj("key.use", -99);
    public eidj field_74321_H = new eidj("key.playerlist", 15);
    public eidj field_74322_I = new eidj("key.pickItem", -98);
    public eidj field_74323_J = new eidj("key.command", 53);
    public eidj[] field_74324_K;
    public xpzm field_74317_L;
    public File field_74354_ai;
    public int field_74318_M = 2;
    public boolean field_74319_N;
    public int field_74320_O;
    public boolean field_74330_P;
    public boolean field_74329_Q;
    public String field_74332_R = "";
    public boolean field_74331_S;
    public boolean field_74326_T;
    public boolean field_74325_U;
    public float field_74328_V = 1.0f;
    public float field_74327_W = 1.0f;
    public float field_74334_X;
    public float field_74333_Y;
    public int field_74335_Z;
    public int field_74362_aa;
    public String field_74363_ab = "en_US";
    public File optionsFileOF;

    public GameSettings(xpzm xpzm2, File file) {
        this.ofKeyBindZoom = new eidj("Zoom", 29);
        this.field_74324_K = new eidj[]{this.field_74312_F, this.field_74313_G, this.field_74351_w, this.field_74370_x, this.field_74368_y, this.field_74366_z, this.field_74314_A, this.field_74311_E, this.field_74316_C, this.field_74315_B, this.field_74310_D, this.field_74321_H, this.field_74322_I, this.ofKeyBindZoom, this.field_74323_J};
        this.field_74317_L = xpzm2;
        this.field_74354_ai = new File(file, "options.txt");
        this.optionsFileOF = new File(file, "optionsof_new1.txt");
        this.func_74300_a();
        Config.initGameSettings(this);
    }

    public GameSettings() {
        this.ofKeyBindZoom = new eidj("Zoom", 29);
        this.field_74324_K = new eidj[]{this.field_74312_F, this.field_74313_G, this.field_74351_w, this.field_74370_x, this.field_74368_y, this.field_74366_z, this.field_74314_A, this.field_74311_E, this.field_74316_C, this.field_74315_B, this.field_74310_D, this.field_74321_H, this.field_74322_I, this.ofKeyBindZoom, this.field_74323_J};
    }

    public String func_74302_a(int n) {
        return wpcz._a(this.field_74324_K[n]._c);
    }

    public String func_74301_b(int n) {
        int n2 = this.field_74324_K[n]._d;
        return GameSettings.func_74298_c(n2);
    }

    public static String func_74298_c(int n) {
        return n < 0 ? wpcz._a("key.mouseButton", n + 101) : Keyboard.getKeyName(n);
    }

    public static boolean func_100015_a(eidj eidj2) {
        return eidj2._d < 0 ? Mouse.isButtonDown(eidj2._d + 100) : Keyboard.isKeyDown(eidj2._d);
    }

    public void func_74307_a(int n, int n2) {
        this.field_74324_K[n]._d = n2;
        this.func_74303_b();
    }

    public void setOfRenderDistanceFine(int n) {
        int n2 = this.ofRenderDistanceFine;
        this.ofRenderDistanceFine = n >> 4 << 4;
        this.ofRenderDistanceFine = Config.limit(this.ofRenderDistanceFine, 32, 512);
        this.field_74339_e = GameSettings.fineToRenderDistance(this.ofRenderDistanceFine);
        if (this.ofRenderDistanceFine != n2) {
            this.field_74317_L._s._b();
        }
    }

    public void func_74304_a(kjui kjui2, float f) {
        if (kjui2 == kjui._a) {
            this.field_74342_a = f;
            this.field_74317_L._N._c();
        }
        if (kjui2 == kjui._b) {
            this.field_74340_b = f;
            this.field_74317_L._N._c();
        }
        if (kjui2 == kjui._d) {
            this.field_74341_c = f;
        }
        if (kjui2 == kjui._e) {
            this.field_74334_X = f;
        }
        if (kjui2 == kjui._f) {
            this.field_74333_Y = f;
        }
        if (kjui2 == kjui._O) {
            this.ofCloudsHeight = f;
        }
        if (kjui2 == kjui._X) {
            this.ofAoLevel = f;
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui.__aJ) {
            this.setOfRenderDistanceFine(32 + (int)(f * 480.0f));
        }
        if (kjui2 == kjui.__aN) {
            this.ofLimitFramerateFine = 30 + (int)(f * 170.0f);
            if (this.ofLimitFramerateFine > 199) {
                this.ofLimitFramerateFine = 0;
            }
            if (this.ofLimitFramerateFine > 30) {
                this.ofLimitFramerateFine = this.ofLimitFramerateFine / 5 * 5;
            }
            if (this.ofLimitFramerateFine > 100) {
                this.ofLimitFramerateFine = this.ofLimitFramerateFine / 10 * 10;
            }
            this.field_74350_i = GameSettings.fineToLimitFramerate(this.ofLimitFramerateFine);
        }
        if (kjui2 == kjui._u) {
            this.field_74357_r = f;
            this.field_74317_L._J.func_73827_b()._b();
        }
        if (kjui2 == kjui._E) {
            this.field_96694_H = f;
            this.field_74317_L._J.func_73827_b()._b();
        }
        if (kjui2 == kjui._F) {
            this.field_96693_G = f;
            this.field_74317_L._J.func_73827_b()._b();
        }
        if (kjui2 == kjui._D) {
            this.field_96692_F = f;
            this.field_74317_L._J.func_73827_b()._b();
        }
        if (kjui2 == kjui._C) {
            this.field_96691_E = f;
            this.field_74317_L._J.func_73827_b()._b();
        }
    }

    public void updateWaterOpacity() {
        mccn mccn2;
        if (this.field_74317_L._J() != null) {
            Config.waterOpacityChanged = true;
        }
        int n = 3;
        if (this.ofClearWater) {
            n = 1;
        }
        twgu.field_71943_B.func_71868_h(n);
        twgu.field_71942_A.func_71868_h(n);
        if (this.field_74317_L._r != null && (mccn2 = this.field_74317_L._r.field_73020_y) != null) {
            for (int i = -512; i < 512; ++i) {
                for (int j = -512; j < 512; ++j) {
                    ixzi ixzi2;
                    if (!mccn2._c(i, j) || (ixzi2 = mccn2._b(i, j)) == null || ixzi2 instanceof raqi) continue;
                    ujzm[] ujzmArray = ixzi2._b();
                    for (int k = 0; k < ujzmArray.length; ++k) {
                        wqak wqak2;
                        ujzm ujzm2 = ujzmArray[k];
                        if (ujzm2 == null || (wqak2 = ujzm2._j()) == null) continue;
                        byte[] byArray = wqak2._a;
                        for (int i2 = 0; i2 < byArray.length; ++i2) {
                            byArray[i2] = 0;
                        }
                    }
                    ixzi2._d();
                }
            }
            this.field_74317_L._s._b();
        }
    }

    public void updateChunkLoading() {
        switch (this.ofChunkLoading) {
            case 1: {
                WrUpdates.setWrUpdater(new WrUpdaterThreaded());
                break;
            }
            default: {
                WrUpdates.setWrUpdater(null);
            }
        }
        if (this.field_74317_L._s != null) {
            this.field_74317_L._s._b();
        }
    }

    public void setAllAnimations(boolean bl) {
        int n;
        this.ofAnimatedWater = n = bl ? 0 : 2;
        this.ofAnimatedLava = n;
        this.ofAnimatedFire = bl;
        this.ofAnimatedPortal = bl;
        this.ofAnimatedRedstone = bl;
        this.ofAnimatedExplosion = bl;
        this.ofAnimatedFlame = bl;
        this.ofAnimatedSmoke = bl;
        this.ofVoidParticles = bl;
        this.ofWaterParticles = bl;
        this.ofRainSplash = bl;
        this.ofPortalParticles = bl;
        this.ofPotionParticles = bl;
        this.field_74362_aa = bl ? 0 : 2;
        this.ofDrippingWaterLava = bl;
        this.ofAnimatedTerrain = bl;
        this.ofAnimatedItems = bl;
        this.ofAnimatedTextures = bl;
    }

    public void func_74306_a(kjui kjui2, int n) {
        int n2;
        Object object;
        if (kjui2 == kjui._c) {
            boolean bl = this.field_74338_d = !this.field_74338_d;
        }
        if (kjui2 == kjui._g) {
            this.field_74339_e = this.field_74339_e + n & 3;
            this.ofRenderDistanceFine = GameSettings.renderDistanceToFine(this.field_74339_e);
        }
        if (kjui2 == kjui._o) {
            this.field_74335_Z = this.field_74335_Z + n & 3;
        }
        if (kjui2 == kjui._q) {
            this.field_74362_aa = (this.field_74362_aa + n) % 3;
        }
        if (kjui2 == kjui._h) {
            boolean bl = this.field_74336_f = !this.field_74336_f;
        }
        if (kjui2 == kjui._p) {
            boolean bl = this.field_74345_l = !this.field_74345_l;
        }
        if (kjui2 == kjui._j) {
            if (!Config.isOcclusionAvailable()) {
                this.ofOcclusionFancy = false;
                this.field_74349_h = false;
            } else if (!this.field_74349_h) {
                this.field_74349_h = true;
                this.ofOcclusionFancy = false;
            } else if (!this.ofOcclusionFancy) {
                this.ofOcclusionFancy = true;
            } else {
                this.ofOcclusionFancy = false;
                this.field_74349_h = false;
            }
            this.field_74317_L._s._g();
        }
        if (kjui2 == kjui._i) {
            this.field_74337_g = !this.field_74337_g;
            this.field_74317_L._c();
        }
        if (kjui2 == kjui._k) {
            this.field_74350_i = (this.field_74350_i + n + 3) % 3;
            this.ofLimitFramerateFine = GameSettings.limitFramerateToFine(this.field_74350_i);
        }
        if (kjui2 == kjui._l) {
            this.field_74318_M = this.field_74318_M + n & 3;
        }
        if (kjui2 == kjui._m) {
            this.field_74347_j = !this.field_74347_j;
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui._n) {
            this.field_74348_k = (this.field_74348_k + n) % 3;
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui._G) {
            switch (this.ofFogType) {
                case 1: {
                    this.ofFogType = 2;
                    if (Config.isFancyFogAvailable()) break;
                    this.ofFogType = 3;
                    break;
                }
                case 2: {
                    this.ofFogType = 3;
                    break;
                }
                case 3: {
                    this.ofFogType = 1;
                    break;
                }
                default: {
                    this.ofFogType = 1;
                }
            }
        }
        if (kjui2 == kjui._H) {
            this.ofFogStart += 0.2f;
            if (this.ofFogStart > 0.81f) {
                this.ofFogStart = 0.2f;
            }
        }
        if (kjui2 == kjui._I) {
            ++this.ofMipmapLevel;
            if (this.ofMipmapLevel > 4) {
                this.ofMipmapLevel = 0;
            }
            TextureUtils.refreshBlockTextures();
        }
        if (kjui2 == kjui._J) {
            ++this.ofMipmapType;
            if (this.ofMipmapType > 3) {
                this.ofMipmapType = 0;
            }
            TextureUtils.refreshBlockTextures();
        }
        if (kjui2 == kjui._K) {
            this.ofLoadFar = !this.ofLoadFar;
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui._L) {
            this.ofPreloadedChunks += 2;
            if (this.ofPreloadedChunks > 8) {
                this.ofPreloadedChunks = 0;
            }
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui._M) {
            boolean bl = this.ofSmoothFps = !this.ofSmoothFps;
        }
        if (kjui2 == kjui.__an) {
            this.ofSmoothWorld = !this.ofSmoothWorld;
            Config.updateThreadPriorities();
        }
        if (kjui2 == kjui._N) {
            ++this.ofClouds;
            if (this.ofClouds > 3) {
                this.ofClouds = 0;
            }
        }
        if (kjui2 == kjui._P) {
            ++this.ofTrees;
            if (this.ofTrees > 2) {
                this.ofTrees = 0;
            }
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui._Q) {
            ++this.ofGrass;
            if (this.ofGrass > 2) {
                this.ofGrass = 0;
            }
            htvc._e = Config.isGrassFancy();
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui.__aP) {
            ++this.ofDroppedItems;
            if (this.ofDroppedItems > 2) {
                this.ofDroppedItems = 0;
            }
        }
        if (kjui2 == kjui._R) {
            ++this.ofRain;
            if (this.ofRain > 3) {
                this.ofRain = 0;
            }
        }
        if (kjui2 == kjui._S) {
            ++this.ofWater;
            if (this.ofWater > 2) {
                this.ofWater = 0;
            }
        }
        if (kjui2 == kjui._T) {
            ++this.ofAnimatedWater;
            if (this.ofAnimatedWater > 2) {
                this.ofAnimatedWater = 0;
            }
        }
        if (kjui2 == kjui._U) {
            ++this.ofAnimatedLava;
            if (this.ofAnimatedLava > 2) {
                this.ofAnimatedLava = 0;
            }
        }
        if (kjui2 == kjui._V) {
            boolean bl = this.ofAnimatedFire = !this.ofAnimatedFire;
        }
        if (kjui2 == kjui._W) {
            boolean bl = this.ofAnimatedPortal = !this.ofAnimatedPortal;
        }
        if (kjui2 == kjui.__ab) {
            boolean bl = this.ofAnimatedRedstone = !this.ofAnimatedRedstone;
        }
        if (kjui2 == kjui.__ac) {
            boolean bl = this.ofAnimatedExplosion = !this.ofAnimatedExplosion;
        }
        if (kjui2 == kjui.__ad) {
            boolean bl = this.ofAnimatedFlame = !this.ofAnimatedFlame;
        }
        if (kjui2 == kjui.__ae) {
            boolean bl = this.ofAnimatedSmoke = !this.ofAnimatedSmoke;
        }
        if (kjui2 == kjui.__ap) {
            boolean bl = this.ofVoidParticles = !this.ofVoidParticles;
        }
        if (kjui2 == kjui.__aq) {
            boolean bl = this.ofWaterParticles = !this.ofWaterParticles;
        }
        if (kjui2 == kjui.__as) {
            boolean bl = this.ofPortalParticles = !this.ofPortalParticles;
        }
        if (kjui2 == kjui.__at) {
            boolean bl = this.ofPotionParticles = !this.ofPotionParticles;
        }
        if (kjui2 == kjui.__av) {
            boolean bl = this.ofDrippingWaterLava = !this.ofDrippingWaterLava;
        }
        if (kjui2 == kjui.__ay) {
            boolean bl = this.ofAnimatedTerrain = !this.ofAnimatedTerrain;
        }
        if (kjui2 == kjui.__aK) {
            boolean bl = this.ofAnimatedTextures = !this.ofAnimatedTextures;
        }
        if (kjui2 == kjui.__az) {
            boolean bl = this.ofAnimatedItems = !this.ofAnimatedItems;
        }
        if (kjui2 == kjui.__ar) {
            boolean bl = this.ofRainSplash = !this.ofRainSplash;
        }
        if (kjui2 == kjui._Y) {
            boolean bl = this.ofLagometer = !this.ofLagometer;
        }
        if (kjui2 == kjui._Z) {
            this.ofAutoSaveTicks *= 10;
            if (this.ofAutoSaveTicks > 40000) {
                this.ofAutoSaveTicks = 40;
            }
        }
        if (kjui2 == kjui.__aa) {
            ++this.ofBetterGrass;
            if (this.ofBetterGrass > 3) {
                this.ofBetterGrass = 1;
            }
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui.__aG) {
            ++this.ofConnectedTextures;
            if (this.ofConnectedTextures > 3) {
                this.ofConnectedTextures = 1;
            }
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui.__af) {
            boolean bl = this.ofWeather = !this.ofWeather;
        }
        if (kjui2 == kjui.__ag) {
            boolean bl = this.ofSky = !this.ofSky;
        }
        if (kjui2 == kjui.__ah) {
            boolean bl = this.ofStars = !this.ofStars;
        }
        if (kjui2 == kjui.__ai) {
            boolean bl = this.ofSunMoon = !this.ofSunMoon;
        }
        if (kjui2 == kjui.__aj) {
            ++this.ofChunkUpdates;
            if (this.ofChunkUpdates > 5) {
                this.ofChunkUpdates = 1;
            }
        }
        if (kjui2 == kjui.__aM) {
            ++this.ofChunkLoading;
            if (this.ofChunkLoading > 2) {
                this.ofChunkLoading = 0;
            }
            this.updateChunkLoading();
        }
        if (kjui2 == kjui.__ak) {
            boolean bl = this.ofChunkUpdatesDynamic = !this.ofChunkUpdatesDynamic;
        }
        if (kjui2 == kjui.__al) {
            ++this.ofTime;
            if (this.ofTime > 3) {
                this.ofTime = 0;
            }
        }
        if (kjui2 == kjui.__am) {
            this.ofClearWater = !this.ofClearWater;
            this.updateWaterOpacity();
        }
        if (kjui2 == kjui.__ao) {
            boolean bl = this.ofDepthFog = !this.ofDepthFog;
        }
        if (kjui2 == kjui.__aH) {
            object = new int[]{0, 2, 4, 6, 8, 12, 16};
            n2 = 0;
            for (int i = 0; i < ((int[])object).length - 1; ++i) {
                if (this.ofAaLevel != object[i]) continue;
                this.ofAaLevel = object[i + 1];
                n2 = 1;
                break;
            }
            if (n2 == 0) {
                this.ofAaLevel = 0;
            }
        }
        if (kjui2 == kjui.__aI) {
            this.ofAfLevel *= 2;
            if (this.ofAfLevel > 16) {
                this.ofAfLevel = 1;
            }
            this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
            TextureUtils.refreshBlockTextures();
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui.__au) {
            boolean bl = this.ofProfiler = !this.ofProfiler;
        }
        if (kjui2 == kjui.__aw) {
            this.ofBetterSnow = !this.ofBetterSnow;
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui.__aA) {
            this.ofSwampColors = !this.ofSwampColors;
            CustomColorizer.updateUseDefaultColorMultiplier();
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui.__aB) {
            this.ofRandomMobs = !this.ofRandomMobs;
            RandomMobs.resetTextures();
        }
        if (kjui2 == kjui.__aC) {
            this.ofSmoothBiomes = !this.ofSmoothBiomes;
            CustomColorizer.updateUseDefaultColorMultiplier();
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui.__aD) {
            this.ofCustomFonts = !this.ofCustomFonts;
            this.field_74317_L._z.func_110549_a(Config.getResourceManager());
            this.field_74317_L._A.func_110549_a(Config.getResourceManager());
        }
        if (kjui2 == kjui.__aE) {
            this.ofCustomColors = !this.ofCustomColors;
            CustomColorizer.update();
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui.__aR) {
            this.ofCustomSky = !this.ofCustomSky;
            CustomSky.update();
        }
        if (kjui2 == kjui.__aF) {
            this.ofShowCapes = !this.ofShowCapes;
            this.field_74317_L._s._j();
        }
        if (kjui2 == kjui.__aL) {
            this.ofNaturalTextures = !this.ofNaturalTextures;
            NaturalTextures.update();
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui.__aS) {
            sajh._m = this.ofFastMath = !this.ofFastMath;
        }
        if (kjui2 == kjui.__aQ) {
            this.ofLazyChunkLoading = !this.ofLazyChunkLoading;
            this.field_74317_L._s._b();
        }
        if (kjui2 == kjui.__ax) {
            object = Arrays.asList(Config.getFullscreenModes());
            this.ofFullscreenMode = this.ofFullscreenMode.equals(DEFAULT_STR) ? (String)object.get(0) : ((n2 = object.indexOf(this.ofFullscreenMode)) < 0 ? DEFAULT_STR : (++n2 >= object.size() ? DEFAULT_STR : (String)object.get(n2)));
        }
        if (kjui2 == kjui.__aO) {
            boolean bl = this.field_92117_D = !this.field_92117_D;
        }
        if (kjui2 == kjui._r) {
            this.field_74343_n = (this.field_74343_n + n) % 3;
        }
        if (kjui2 == kjui._s) {
            boolean bl = this.field_74344_o = !this.field_74344_o;
        }
        if (kjui2 == kjui._t) {
            boolean bl = this.field_74359_p = !this.field_74359_p;
        }
        if (kjui2 == kjui._v) {
            boolean bl = this.field_74358_q = !this.field_74358_q;
        }
        if (kjui2 == kjui._w) {
            boolean bl = this.field_74356_s = !this.field_74356_s;
        }
        if (kjui2 == kjui._x) {
            boolean bl = this.field_74355_t = !this.field_74355_t;
        }
        if (kjui2 == kjui._A) {
            boolean bl = this.field_82880_z = !this.field_82880_z;
        }
        if (kjui2 == kjui._B) {
            boolean bl = this.field_85185_A = !this.field_85185_A;
        }
        if (kjui2 == kjui._y) {
            boolean bl = this.field_74353_u = !this.field_74353_u;
            if (this.field_74317_L._N() != this.field_74353_u) {
                this.field_74317_L._r();
            }
        }
        if (kjui2 == kjui._z) {
            this.field_74352_v = !this.field_74352_v;
            Display.setVSyncEnabled(this.field_74352_v);
        }
        this.func_74303_b();
    }

    public float func_74296_a(kjui kjui2) {
        return kjui2 == kjui._O ? this.ofCloudsHeight : (kjui2 == kjui._X ? this.ofAoLevel : (kjui2 == kjui.__aJ ? (float)(this.ofRenderDistanceFine - 32) / 480.0f : (kjui2 == kjui.__aN ? (this.ofLimitFramerateFine > 0 && this.ofLimitFramerateFine < 200 ? (float)this.ofLimitFramerateFine / 200.0f : (this.field_74352_v ? 0.0f : 1.0f)) : (kjui2 == kjui._e ? this.field_74334_X : (kjui2 == kjui._f ? this.field_74333_Y : (kjui2 == kjui._a ? this.field_74342_a : (kjui2 == kjui._b ? this.field_74340_b : (kjui2 == kjui._d ? this.field_74341_c : (kjui2 == kjui._u ? this.field_74357_r : (kjui2 == kjui._E ? this.field_96694_H : (kjui2 == kjui._F ? this.field_96693_G : (kjui2 == kjui._C ? this.field_96691_E : (kjui2 == kjui._D ? this.field_96692_F : 0.0f)))))))))))));
    }

    public boolean func_74308_b(kjui kjui2) {
        switch (kjui2) {
            case _c: {
                return this.field_74338_d;
            }
            case _h: {
                return this.field_74336_f;
            }
            case _i: {
                return this.field_74337_g;
            }
            case _j: {
                return this.field_74349_h;
            }
            case _p: {
                return this.field_74345_l;
            }
            case _s: {
                return this.field_74344_o;
            }
            case _t: {
                return this.field_74359_p;
            }
            case _v: {
                return this.field_74358_q;
            }
            case _w: {
                return this.field_74356_s;
            }
            case _x: {
                return this.field_74355_t;
            }
            case _y: {
                return this.field_74353_u;
            }
            case _z: {
                return this.field_74352_v;
            }
            case _A: {
                return this.field_82880_z;
            }
            case _B: {
                return this.field_85185_A;
            }
        }
        return false;
    }

    public static String func_74299_a(String[] stringArray, int n) {
        if (n < 0 || n >= stringArray.length) {
            n = 0;
        }
        return wpcz._a(stringArray[n]);
    }

    public String func_74297_c(kjui kjui2) {
        String string = wpcz._a(kjui2._d());
        if (string == null) {
            string = kjui2._d();
        }
        String string2 = string + ": ";
        if (kjui2 == kjui.__aJ) {
            int n;
            String string3 = "Tiny";
            int n2 = 32;
            if (this.ofRenderDistanceFine >= 64) {
                string3 = "Short";
                n2 = 64;
            }
            if (this.ofRenderDistanceFine >= 128) {
                string3 = "Normal";
                n2 = 128;
            }
            if (this.ofRenderDistanceFine >= 256) {
                string3 = "Far";
                n2 = 256;
            }
            if (this.ofRenderDistanceFine >= 512) {
                string3 = "Extreme";
                n2 = 512;
            }
            return (n = this.ofRenderDistanceFine - n2) == 0 ? string2 + string3 : string2 + string3 + " +" + n;
        }
        if (kjui2 == kjui.__aN) {
            return this.ofLimitFramerateFine > 0 && this.ofLimitFramerateFine < 200 ? string2 + " " + this.ofLimitFramerateFine + " FPS" : (this.field_74352_v ? string2 + " VSync" : string2 + " MaxFPS");
        }
        if (kjui2 == kjui._j) {
            return !this.field_74349_h ? string2 + "OFF" : (this.ofOcclusionFancy ? string2 + "Fancy" : string2 + "Fast");
        }
        if (kjui2 == kjui._G) {
            switch (this.ofFogType) {
                case 1: {
                    return string2 + "Fast";
                }
                case 2: {
                    return string2 + "Fancy";
                }
                case 3: {
                    return string2 + "OFF";
                }
            }
            return string2 + "OFF";
        }
        if (kjui2 == kjui._H) {
            return string2 + this.ofFogStart;
        }
        if (kjui2 == kjui._I) {
            return this.ofMipmapLevel == 0 ? string2 + "OFF" : (this.ofMipmapLevel == 4 ? string2 + "Max" : string2 + this.ofMipmapLevel);
        }
        if (kjui2 == kjui._J) {
            switch (this.ofMipmapType) {
                case 0: {
                    return string2 + "Nearest";
                }
                case 1: {
                    return string2 + "Linear";
                }
                case 2: {
                    return string2 + "Bilinear";
                }
                case 3: {
                    return string2 + "Trilinear";
                }
            }
            return string2 + "Nearest";
        }
        if (kjui2 == kjui._K) {
            return this.ofLoadFar ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui._L) {
            return this.ofPreloadedChunks == 0 ? string2 + "OFF" : string2 + this.ofPreloadedChunks;
        }
        if (kjui2 == kjui._M) {
            return this.ofSmoothFps ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__an) {
            return this.ofSmoothWorld ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui._N) {
            switch (this.ofClouds) {
                case 1: {
                    return string2 + "Fast";
                }
                case 2: {
                    return string2 + "Fancy";
                }
                case 3: {
                    return string2 + "OFF";
                }
            }
            return string2 + DEFAULT_STR;
        }
        if (kjui2 == kjui._Q) {
            switch (this.ofGrass) {
                case 1: {
                    return string2 + "Fast";
                }
                case 2: {
                    return string2 + "Fancy";
                }
            }
            return string2 + DEFAULT_STR;
        }
        if (kjui2 == kjui.__aP) {
            switch (this.ofDroppedItems) {
                case 1: {
                    return string2 + "Fast";
                }
                case 2: {
                    return string2 + "Fancy";
                }
            }
            return string2 + DEFAULT_STR;
        }
        if (kjui2 == kjui._R) {
            switch (this.ofRain) {
                case 1: {
                    return string2 + "Fast";
                }
                case 2: {
                    return string2 + "Fancy";
                }
                case 3: {
                    return string2 + "OFF";
                }
            }
            return string2 + DEFAULT_STR;
        }
        if (kjui2 == kjui._S) {
            switch (this.ofWater) {
                case 1: {
                    return string2 + "Fast";
                }
                case 2: {
                    return string2 + "Fancy";
                }
                case 3: {
                    return string2 + "OFF";
                }
            }
            return string2 + DEFAULT_STR;
        }
        if (kjui2 == kjui._T) {
            switch (this.ofAnimatedWater) {
                case 1: {
                    return string2 + "Dynamic";
                }
                case 2: {
                    return string2 + "OFF";
                }
            }
            return string2 + "ON";
        }
        if (kjui2 == kjui._U) {
            switch (this.ofAnimatedLava) {
                case 1: {
                    return string2 + "Dynamic";
                }
                case 2: {
                    return string2 + "OFF";
                }
            }
            return string2 + "ON";
        }
        if (kjui2 == kjui._V) {
            return this.ofAnimatedFire ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui._W) {
            return this.ofAnimatedPortal ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ab) {
            return this.ofAnimatedRedstone ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ac) {
            return this.ofAnimatedExplosion ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ad) {
            return this.ofAnimatedFlame ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ae) {
            return this.ofAnimatedSmoke ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ap) {
            return this.ofVoidParticles ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aq) {
            return this.ofWaterParticles ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__as) {
            return this.ofPortalParticles ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__at) {
            return this.ofPotionParticles ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__av) {
            return this.ofDrippingWaterLava ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ay) {
            return this.ofAnimatedTerrain ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aK) {
            return this.ofAnimatedTextures ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__az) {
            return this.ofAnimatedItems ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ar) {
            return this.ofRainSplash ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui._Y) {
            return this.ofLagometer ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui._Z) {
            return this.ofAutoSaveTicks <= 40 ? string2 + "Default (2s)" : (this.ofAutoSaveTicks <= 400 ? string2 + "20s" : (this.ofAutoSaveTicks <= 4000 ? string2 + "3min" : string2 + "30min"));
        }
        if (kjui2 == kjui.__aa) {
            switch (this.ofBetterGrass) {
                case 1: {
                    return string2 + "Fast";
                }
                case 2: {
                    return string2 + "Fancy";
                }
            }
            return string2 + "OFF";
        }
        if (kjui2 == kjui.__aG) {
            switch (this.ofConnectedTextures) {
                case 1: {
                    return string2 + "Fast";
                }
                case 2: {
                    return string2 + "Fancy";
                }
            }
            return string2 + "OFF";
        }
        if (kjui2 == kjui.__af) {
            return this.ofWeather ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ag) {
            return this.ofSky ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ah) {
            return this.ofStars ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ai) {
            return this.ofSunMoon ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aj) {
            return string2 + this.ofChunkUpdates;
        }
        if (kjui2 == kjui.__aM) {
            return this.ofChunkLoading == 1 ? string2 + "Smooth" : (this.ofChunkLoading == 2 ? string2 + "Multi-Core" : string2 + DEFAULT_STR);
        }
        if (kjui2 == kjui.__ak) {
            return this.ofChunkUpdatesDynamic ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__al) {
            return this.ofTime == 1 ? string2 + "Day Only" : (this.ofTime == 3 ? string2 + "Night Only" : string2 + DEFAULT_STR);
        }
        if (kjui2 == kjui.__am) {
            return this.ofClearWater ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ao) {
            return this.ofDepthFog ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aH) {
            return this.ofAaLevel == 0 ? string2 + "OFF" : string2 + this.ofAaLevel;
        }
        if (kjui2 == kjui.__aI) {
            return this.ofAfLevel == 1 ? string2 + "OFF" : string2 + this.ofAfLevel;
        }
        if (kjui2 == kjui.__au) {
            return this.ofProfiler ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aw) {
            return this.ofBetterSnow ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aA) {
            return this.ofSwampColors ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aB) {
            return this.ofRandomMobs ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aC) {
            return this.ofSmoothBiomes ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aD) {
            return this.ofCustomFonts ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aE) {
            return this.ofCustomColors ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aR) {
            return this.ofCustomSky ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aF) {
            return this.ofShowCapes ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aL) {
            return this.ofNaturalTextures ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aS) {
            return this.ofFastMath ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__aQ) {
            return this.ofLazyChunkLoading ? string2 + "ON" : string2 + "OFF";
        }
        if (kjui2 == kjui.__ax) {
            return string2 + this.ofFullscreenMode;
        }
        if (kjui2 == kjui.__aO) {
            return this.field_92117_D ? string2 + "ON" : string2 + "OFF";
        }
        String string4 = wpcz._a(kjui2._d()) + ": ";
        if (kjui2._a()) {
            float f = this.func_74296_a(kjui2);
            return kjui2 == kjui._d ? (f == 0.0f ? string4 + wpcz._a("options.sensitivity.min") : (f == 1.0f ? string4 + wpcz._a("options.sensitivity.max") : string4 + (int)(f * 200.0f) + "%")) : (kjui2 == kjui._e ? (f == 0.0f ? string4 + wpcz._a("options.fov.min") : (f == 1.0f ? string4 + wpcz._a("options.fov.max") : string4 + (int)(70.0f + f * 40.0f))) : (kjui2 == kjui._f ? (f == 0.0f ? string4 + wpcz._a("options.gamma.min") : (f == 1.0f ? string4 + wpcz._a("options.gamma.max") : string4 + "+" + (int)(f * 100.0f) + "%")) : (kjui2 == kjui._u ? string4 + (int)(f * 90.0f + 10.0f) + "%" : (kjui2 == kjui._F ? string4 + wowp._b(f) + "px" : (kjui2 == kjui._E ? string4 + wowp._b(f) + "px" : (kjui2 == kjui._D ? string4 + wowp._a(f) + "px" : (f == 0.0f ? string4 + wpcz._a("options.off") : string4 + (int)(f * 100.0f) + "%")))))));
        }
        if (kjui2._b()) {
            boolean bl = this.func_74308_b(kjui2);
            return bl ? string4 + wpcz._a("options.on") : string4 + wpcz._a("options.off");
        }
        if (kjui2 == kjui._g) {
            return string4 + GameSettings.func_74299_a(field_74360_ac, this.field_74339_e);
        }
        if (kjui2 == kjui._l) {
            return string4 + GameSettings.func_74299_a(field_74361_ad, this.field_74318_M);
        }
        if (kjui2 == kjui._o) {
            return string4 + GameSettings.func_74299_a(field_74367_ae, this.field_74335_Z);
        }
        if (kjui2 == kjui._r) {
            return string4 + GameSettings.func_74299_a(field_74369_af, this.field_74343_n);
        }
        if (kjui2 == kjui._q) {
            return string4 + GameSettings.func_74299_a(field_74364_ag, this.field_74362_aa);
        }
        if (kjui2 == kjui._k) {
            return string4 + GameSettings.func_74299_a(field_74365_ah, this.field_74350_i);
        }
        if (kjui2 == kjui._n) {
            return string4 + GameSettings.func_74299_a(field_98303_au, this.field_74348_k);
        }
        if (kjui2 == kjui._m) {
            if (this.field_74347_j) {
                return string4 + wpcz._a("options.graphics.fancy");
            }
            String string5 = "options.graphics.fast";
            return string4 + wpcz._a("options.graphics.fast");
        }
        return string4;
    }

    public void func_74300_a() {
        Object object;
        Object object2;
        Object object3;
        block121: {
            block120: {
                if (this.field_74354_ai.exists()) break block120;
                qlgf._a(this);
                GloomyHooks.loadOptions(this);
                return;
            }
            try {
                object3 = new BufferedReader(new FileReader(this.field_74354_ai));
                object2 = "";
                while ((object2 = ((BufferedReader)object3).readLine()) != null) {
                    try {
                        object = ((String)object2).split(":");
                        if (object[0].equals("music")) {
                            this.field_74342_a = this.func_74305_a(object[1]);
                        }
                        if (object[0].equals("sound")) {
                            this.field_74340_b = this.func_74305_a((String)object[1]);
                        }
                        if (((String)object[0]).equals("mouseSensitivity")) {
                            this.field_74341_c = this.func_74305_a((String)object[1]);
                        }
                        if (((String)object[0]).equals("fov")) {
                            this.field_74334_X = this.func_74305_a((String)object[1]);
                        }
                        if (((String)object[0]).equals("gamma")) {
                            this.field_74333_Y = this.func_74305_a((String)object[1]);
                        }
                        if (((String)object[0]).equals("invertYMouse")) {
                            this.field_74338_d = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("viewDistance")) {
                            this.field_74339_e = Integer.parseInt((String)object[1]);
                            this.ofRenderDistanceFine = GameSettings.renderDistanceToFine(this.field_74339_e);
                        }
                        if (((String)object[0]).equals("guiScale")) {
                            this.field_74335_Z = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("particles")) {
                            this.field_74362_aa = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("anaglyph3d")) {
                            this.field_74337_g = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("advancedOpengl")) {
                            this.field_74349_h = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("fpsLimit")) {
                            this.field_74350_i = Integer.parseInt((String)object[1]);
                            this.ofLimitFramerateFine = GameSettings.limitFramerateToFine(this.field_74350_i);
                        }
                        if (((String)object[0]).equals("difficulty")) {
                            this.field_74318_M = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("fancyGraphics")) {
                            this.field_74347_j = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("ao")) {
                            this.field_74348_k = ((String)object[1]).equals("true") ? 2 : (((String)object[1]).equals("false") ? 0 : Integer.parseInt((String)object[1]));
                        }
                        if (((String)object[0]).equals("clouds")) {
                            this.field_74345_l = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("skin")) {
                            this.field_74346_m = object[1];
                        }
                        if (((String)object[0]).equals("lastServer") && ((Object)object).length >= 2) {
                            this.field_74332_R = ((String)object2).substring(((String)object2).indexOf(58) + 1);
                        }
                        if (((String)object[0]).equals("lang") && ((Object)object).length >= 2) {
                            this.field_74363_ab = object[1];
                        }
                        if (((String)object[0]).equals("chatVisibility")) {
                            this.field_74343_n = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("chatColors")) {
                            this.field_74344_o = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("chatLinks")) {
                            this.field_74359_p = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("chatLinksPrompt")) {
                            this.field_74358_q = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("chatOpacity")) {
                            this.field_74357_r = this.func_74305_a((String)object[1]);
                        }
                        if (((String)object[0]).equals("serverTextures")) {
                            this.field_74356_s = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("snooperEnabled")) {
                            this.field_74355_t = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("fullscreen")) {
                            this.field_74353_u = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("enableVsync")) {
                            this.field_74352_v = ((String)object[1]).equals("true");
                            this.updateVSync();
                        }
                        if (((String)object[0]).equals("hideServerAddress")) {
                            this.field_80005_w = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("advancedItemTooltips")) {
                            this.field_82882_x = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("pauseOnLostFocus")) {
                            this.field_82881_y = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("showCape")) {
                            this.field_82880_z = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("touchscreen")) {
                            this.field_85185_A = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("overrideHeight")) {
                            this.field_92119_C = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("overrideWidth")) {
                            this.field_92118_B = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("heldItemTooltips")) {
                            this.field_92117_D = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("chatHeightFocused")) {
                            this.field_96694_H = this.func_74305_a((String)object[1]);
                        }
                        if (((String)object[0]).equals("chatHeightUnfocused")) {
                            this.field_96693_G = this.func_74305_a((String)object[1]);
                        }
                        if (((String)object[0]).equals("chatScale")) {
                            this.field_96691_E = this.func_74305_a((String)object[1]);
                        }
                        if (((String)object[0]).equals("chatWidth")) {
                            this.field_96692_F = this.func_74305_a((String)object[1]);
                        }
                        for (int i = 0; i < this.field_74324_K.length; ++i) {
                            if (!((String)object[0]).equals("key_" + this.field_74324_K[i]._c)) continue;
                            this.field_74324_K[i]._d = Integer.parseInt((String)object[1]);
                        }
                    }
                    catch (Exception exception) {
                        this.field_74317_L._O()._b("Skipping bad option: " + (String)object2);
                        exception.printStackTrace();
                    }
                }
                eidj._b();
                ((BufferedReader)object3).close();
            }
            catch (Exception exception) {
                this.field_74317_L._O()._b("Failed to load options");
                exception.printStackTrace();
            }
            object3 = this.optionsFileOF;
            if (!((File)object3).exists()) {
                object3 = this.field_74354_ai;
            }
            if (((File)object3).exists()) break block121;
            qlgf._a(this);
            GloomyHooks.loadOptions(this);
            return;
        }
        try {
            object2 = new BufferedReader(new FileReader((File)object3));
            object = "";
            while ((object = ((BufferedReader)object2).readLine()) != null) {
                try {
                    String[] stringArray = ((String)object).split(":");
                    if (stringArray[0].equals("ofRenderDistanceFine") && stringArray.length >= 2) {
                        this.ofRenderDistanceFine = Integer.valueOf(stringArray[1]);
                        this.ofRenderDistanceFine = Config.limit(this.ofRenderDistanceFine, 32, 512);
                        this.field_74339_e = GameSettings.fineToRenderDistance(this.ofRenderDistanceFine);
                    }
                    if (stringArray[0].equals("ofLimitFramerateFine") && stringArray.length >= 2) {
                        this.ofLimitFramerateFine = Integer.valueOf(stringArray[1]);
                        this.ofLimitFramerateFine = Config.limit(this.ofLimitFramerateFine, 0, 199);
                        this.field_74350_i = GameSettings.fineToLimitFramerate(this.ofLimitFramerateFine);
                    }
                    if (stringArray[0].equals("ofFogType") && stringArray.length >= 2) {
                        this.ofFogType = Integer.valueOf(stringArray[1]);
                        this.ofFogType = Config.limit(this.ofFogType, 1, 3);
                    }
                    if (stringArray[0].equals("ofFogStart") && stringArray.length >= 2) {
                        this.ofFogStart = Float.valueOf(stringArray[1]).floatValue();
                        if (this.ofFogStart < 0.2f) {
                            this.ofFogStart = 0.2f;
                        }
                        if (this.ofFogStart > 0.81f) {
                            this.ofFogStart = 0.8f;
                        }
                    }
                    if (stringArray[0].equals("ofMipmapType_new") && stringArray.length >= 2) {
                        this.ofMipmapType = Integer.valueOf(stringArray[1]);
                        this.ofMipmapType = Config.limit(this.ofMipmapType, 0, 3);
                    }
                    if (stringArray[0].equals("ofLoadFar") && stringArray.length >= 2) {
                        this.ofLoadFar = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofPreloadedChunks") && stringArray.length >= 2) {
                        this.ofPreloadedChunks = Integer.valueOf(stringArray[1]);
                        if (this.ofPreloadedChunks < 0) {
                            this.ofPreloadedChunks = 0;
                        }
                        if (this.ofPreloadedChunks > 8) {
                            this.ofPreloadedChunks = 8;
                        }
                    }
                    if (stringArray[0].equals("ofOcclusionFancy") && stringArray.length >= 2) {
                        this.ofOcclusionFancy = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSmoothFps") && stringArray.length >= 2) {
                        this.ofSmoothFps = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSmoothWorld") && stringArray.length >= 2) {
                        this.ofSmoothWorld = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAoLevel") && stringArray.length >= 2) {
                        this.ofAoLevel = Float.valueOf(stringArray[1]).floatValue();
                        this.ofAoLevel = Config.limit(this.ofAoLevel, 0.0f, 1.0f);
                    }
                    if (stringArray[0].equals("ofClouds") && stringArray.length >= 2) {
                        this.ofClouds = Integer.valueOf(stringArray[1]);
                        this.ofClouds = Config.limit(this.ofClouds, 0, 3);
                    }
                    if (stringArray[0].equals("ofCloudsHeight") && stringArray.length >= 2) {
                        this.ofCloudsHeight = Float.valueOf(stringArray[1]).floatValue();
                        this.ofCloudsHeight = Config.limit(this.ofCloudsHeight, 0.0f, 1.0f);
                    }
                    if (stringArray[0].equals("ofTrees") && stringArray.length >= 2) {
                        this.ofTrees = Integer.valueOf(stringArray[1]);
                        this.ofTrees = Config.limit(this.ofTrees, 0, 2);
                    }
                    if (stringArray[0].equals("ofGrass") && stringArray.length >= 2) {
                        this.ofGrass = Integer.valueOf(stringArray[1]);
                        this.ofGrass = Config.limit(this.ofGrass, 0, 2);
                    }
                    if (stringArray[0].equals("ofDroppedItems") && stringArray.length >= 2) {
                        this.ofDroppedItems = Integer.valueOf(stringArray[1]);
                        this.ofDroppedItems = Config.limit(this.ofDroppedItems, 0, 2);
                    }
                    if (stringArray[0].equals("ofRain") && stringArray.length >= 2) {
                        this.ofRain = Integer.valueOf(stringArray[1]);
                        this.ofRain = Config.limit(this.ofRain, 0, 3);
                    }
                    if (stringArray[0].equals("ofWater") && stringArray.length >= 2) {
                        this.ofWater = Integer.valueOf(stringArray[1]);
                        this.ofWater = Config.limit(this.ofWater, 0, 3);
                    }
                    if (stringArray[0].equals("ofAnimatedWater") && stringArray.length >= 2) {
                        this.ofAnimatedWater = Integer.valueOf(stringArray[1]);
                        this.ofAnimatedWater = Config.limit(this.ofAnimatedWater, 0, 2);
                    }
                    if (stringArray[0].equals("ofAnimatedLava") && stringArray.length >= 2) {
                        this.ofAnimatedLava = Integer.valueOf(stringArray[1]);
                        this.ofAnimatedLava = Config.limit(this.ofAnimatedLava, 0, 2);
                    }
                    if (stringArray[0].equals("ofAnimatedFire") && stringArray.length >= 2) {
                        this.ofAnimatedFire = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedPortal") && stringArray.length >= 2) {
                        this.ofAnimatedPortal = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedRedstone") && stringArray.length >= 2) {
                        this.ofAnimatedRedstone = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedExplosion") && stringArray.length >= 2) {
                        this.ofAnimatedExplosion = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedFlame") && stringArray.length >= 2) {
                        this.ofAnimatedFlame = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedSmoke") && stringArray.length >= 2) {
                        this.ofAnimatedSmoke = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofVoidParticles") && stringArray.length >= 2) {
                        this.ofVoidParticles = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofWaterParticles") && stringArray.length >= 2) {
                        this.ofWaterParticles = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofPortalParticles") && stringArray.length >= 2) {
                        this.ofPortalParticles = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofPotionParticles") && stringArray.length >= 2) {
                        this.ofPotionParticles = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofDrippingWaterLava") && stringArray.length >= 2) {
                        this.ofDrippingWaterLava = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedTerrain") && stringArray.length >= 2) {
                        this.ofAnimatedTerrain = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedTextures") && stringArray.length >= 2) {
                        this.ofAnimatedTextures = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAnimatedItems") && stringArray.length >= 2) {
                        this.ofAnimatedItems = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofRainSplash") && stringArray.length >= 2) {
                        this.ofRainSplash = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofLagometer") && stringArray.length >= 2) {
                        this.ofLagometer = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAutoSaveTicks") && stringArray.length >= 2) {
                        this.ofAutoSaveTicks = Integer.valueOf(stringArray[1]);
                        this.ofAutoSaveTicks = Config.limit(this.ofAutoSaveTicks, 40, 40000);
                    }
                    if (stringArray[0].equals("ofConnectedTextures") && stringArray.length >= 2) {
                        this.ofConnectedTextures = Integer.valueOf(stringArray[1]);
                        this.ofConnectedTextures = Config.limit(this.ofConnectedTextures, 1, 3);
                    }
                    if (stringArray[0].equals("ofWeather") && stringArray.length >= 2) {
                        this.ofWeather = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSky") && stringArray.length >= 2) {
                        this.ofSky = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofStars") && stringArray.length >= 2) {
                        this.ofStars = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSunMoon") && stringArray.length >= 2) {
                        this.ofSunMoon = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofChunkUpdates") && stringArray.length >= 2) {
                        this.ofChunkUpdates = Integer.valueOf(stringArray[1]);
                        this.ofChunkUpdates = Config.limit(this.ofChunkUpdates, 1, 5);
                    }
                    if (stringArray[0].equals("ofChunkLoading") && stringArray.length >= 2) {
                        this.ofChunkLoading = Integer.valueOf(stringArray[1]);
                        this.ofChunkLoading = Config.limit(this.ofChunkLoading, 0, 2);
                        this.updateChunkLoading();
                    }
                    if (stringArray[0].equals("ofChunkUpdatesDynamic") && stringArray.length >= 2) {
                        this.ofChunkUpdatesDynamic = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofTime") && stringArray.length >= 2) {
                        this.ofTime = Integer.valueOf(stringArray[1]);
                        this.ofTime = Config.limit(this.ofTime, 0, 3);
                    }
                    if (stringArray[0].equals("ofClearWater") && stringArray.length >= 2) {
                        this.ofClearWater = Boolean.valueOf(stringArray[1]);
                        this.updateWaterOpacity();
                    }
                    if (stringArray[0].equals("ofDepthFog") && stringArray.length >= 2) {
                        this.ofDepthFog = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofAaLevel") && stringArray.length >= 2) {
                        this.ofAaLevel = Integer.valueOf(stringArray[1]);
                        this.ofAaLevel = Config.limit(this.ofAaLevel, 0, 16);
                    }
                    if (stringArray[0].equals("ofAfLevel") && stringArray.length >= 2) {
                        this.ofAfLevel = Integer.valueOf(stringArray[1]);
                        this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
                    }
                    if (stringArray[0].equals("ofProfiler") && stringArray.length >= 2) {
                        this.ofProfiler = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofBetterSnow") && stringArray.length >= 2) {
                        this.ofBetterSnow = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSwampColors") && stringArray.length >= 2) {
                        this.ofSwampColors = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofRandomMobs") && stringArray.length >= 2) {
                        this.ofRandomMobs = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofSmoothBiomes") && stringArray.length >= 2) {
                        this.ofSmoothBiomes = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofCustomFonts") && stringArray.length >= 2) {
                        this.ofCustomFonts = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofCustomColors") && stringArray.length >= 2) {
                        this.ofCustomColors = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofCustomSky") && stringArray.length >= 2) {
                        this.ofCustomSky = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofShowCapes") && stringArray.length >= 2) {
                        this.ofShowCapes = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofNaturalTextures") && stringArray.length >= 2) {
                        this.ofNaturalTextures = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofLazyChunkLoading") && stringArray.length >= 2) {
                        this.ofLazyChunkLoading = Boolean.valueOf(stringArray[1]);
                    }
                    if (stringArray[0].equals("ofFullscreenMode") && stringArray.length >= 2) {
                        this.ofFullscreenMode = stringArray[1];
                    }
                    if (!stringArray[0].equals("ofFastMath") || stringArray.length < 2) continue;
                    sajh._m = this.ofFastMath = Boolean.valueOf(stringArray[1]).booleanValue();
                }
                catch (Exception exception) {
                    Config.dbg("Skipping bad option: " + (String)object);
                    exception.printStackTrace();
                }
            }
            eidj._b();
            ((BufferedReader)object2).close();
        }
        catch (Exception exception) {
            Config.warn("Failed to load options");
            exception.printStackTrace();
        }
        qlgf._a(this);
        GloomyHooks.loadOptions(this);
    }

    public float func_74305_a(String string) {
        return string.equals("true") ? 1.0f : (string.equals("false") ? 0.0f : Float.parseFloat(string));
    }

    public void func_74303_b() {
        this.saveOptions(false);
    }

    public void saveOptions(boolean bl) {
        Object object;
        if (Reflector.FMLClientHandler.exists()) {
            object = Reflector.call(Reflector.FMLClientHandler_instance, new Object[0]);
            if (!bl && object != null && Reflector.callBoolean(object, Reflector.FMLClientHandler_isLoading, new Object[0])) {
                return;
            }
        }
        try {
            object = new PrintWriter(new FileWriter(this.field_74354_ai));
            ((PrintWriter)object).println("music:" + this.field_74342_a);
            ((PrintWriter)object).println("sound:" + this.field_74340_b);
            ((PrintWriter)object).println("invertYMouse:" + this.field_74338_d);
            ((PrintWriter)object).println("mouseSensitivity:" + this.field_74341_c);
            ((PrintWriter)object).println("fov:" + this.field_74334_X);
            ((PrintWriter)object).println("gamma:" + this.field_74333_Y);
            ((PrintWriter)object).println("viewDistance:" + this.field_74339_e);
            ((PrintWriter)object).println("guiScale:" + this.field_74335_Z);
            ((PrintWriter)object).println("particles:" + this.field_74362_aa);
            ((PrintWriter)object).println("bobView:" + this.field_74336_f);
            ((PrintWriter)object).println("anaglyph3d:" + this.field_74337_g);
            ((PrintWriter)object).println("advancedOpengl:" + this.field_74349_h);
            ((PrintWriter)object).println("fpsLimit:" + this.field_74350_i);
            ((PrintWriter)object).println("difficulty:" + this.field_74318_M);
            ((PrintWriter)object).println("fancyGraphics:" + this.field_74347_j);
            ((PrintWriter)object).println("ao:" + this.field_74348_k);
            ((PrintWriter)object).println("clouds:" + this.field_74345_l);
            ((PrintWriter)object).println("skin:" + this.field_74346_m);
            ((PrintWriter)object).println("lastServer:" + this.field_74332_R);
            ((PrintWriter)object).println("lang:" + this.field_74363_ab);
            ((PrintWriter)object).println("chatVisibility:" + this.field_74343_n);
            ((PrintWriter)object).println("chatColors:" + this.field_74344_o);
            ((PrintWriter)object).println("chatLinks:" + this.field_74359_p);
            ((PrintWriter)object).println("chatLinksPrompt:" + this.field_74358_q);
            ((PrintWriter)object).println("chatOpacity:" + this.field_74357_r);
            ((PrintWriter)object).println("serverTextures:" + this.field_74356_s);
            ((PrintWriter)object).println("snooperEnabled:" + this.field_74355_t);
            ((PrintWriter)object).println("fullscreen:" + this.field_74353_u);
            ((PrintWriter)object).println("enableVsync:" + this.field_74352_v);
            ((PrintWriter)object).println("hideServerAddress:" + this.field_80005_w);
            ((PrintWriter)object).println("advancedItemTooltips:" + this.field_82882_x);
            ((PrintWriter)object).println("pauseOnLostFocus:" + this.field_82881_y);
            ((PrintWriter)object).println("showCape:" + this.field_82880_z);
            ((PrintWriter)object).println("touchscreen:" + this.field_85185_A);
            ((PrintWriter)object).println("overrideWidth:" + this.field_92118_B);
            ((PrintWriter)object).println("overrideHeight:" + this.field_92119_C);
            ((PrintWriter)object).println("heldItemTooltips:" + this.field_92117_D);
            ((PrintWriter)object).println("chatHeightFocused:" + this.field_96694_H);
            ((PrintWriter)object).println("chatHeightUnfocused:" + this.field_96693_G);
            ((PrintWriter)object).println("chatScale:" + this.field_96691_E);
            ((PrintWriter)object).println("chatWidth:" + this.field_96692_F);
            for (int i = 0; i < this.field_74324_K.length; ++i) {
                ((PrintWriter)object).println("key_" + this.field_74324_K[i]._c + ":" + this.field_74324_K[i]._d);
            }
            ((PrintWriter)object).close();
        }
        catch (Exception exception) {
            this.field_74317_L._O()._b("Failed to save options");
            exception.printStackTrace();
        }
        try {
            object = new PrintWriter(new FileWriter(this.optionsFileOF));
            ((PrintWriter)object).println("ofRenderDistanceFine:" + this.ofRenderDistanceFine);
            ((PrintWriter)object).println("ofLimitFramerateFine:" + this.ofLimitFramerateFine);
            ((PrintWriter)object).println("ofFogType:" + this.ofFogType);
            ((PrintWriter)object).println("ofFogStart:" + this.ofFogStart);
            ((PrintWriter)object).println("ofMipmapLevel:" + this.ofMipmapLevel);
            ((PrintWriter)object).println("ofMipmapType:" + this.ofMipmapType);
            ((PrintWriter)object).println("ofLoadFar:" + this.ofLoadFar);
            ((PrintWriter)object).println("ofPreloadedChunks:" + this.ofPreloadedChunks);
            ((PrintWriter)object).println("ofOcclusionFancy:" + this.ofOcclusionFancy);
            ((PrintWriter)object).println("ofSmoothFps:" + this.ofSmoothFps);
            ((PrintWriter)object).println("ofSmoothWorld:" + this.ofSmoothWorld);
            ((PrintWriter)object).println("ofAoLevel:" + this.ofAoLevel);
            ((PrintWriter)object).println("ofClouds:" + this.ofClouds);
            ((PrintWriter)object).println("ofCloudsHeight:" + this.ofCloudsHeight);
            ((PrintWriter)object).println("ofTrees:" + this.ofTrees);
            ((PrintWriter)object).println("ofGrass:" + this.ofGrass);
            ((PrintWriter)object).println("ofDroppedItems:" + this.ofDroppedItems);
            ((PrintWriter)object).println("ofRain:" + this.ofRain);
            ((PrintWriter)object).println("ofWater:" + this.ofWater);
            ((PrintWriter)object).println("ofAnimatedWater:" + this.ofAnimatedWater);
            ((PrintWriter)object).println("ofAnimatedLava:" + this.ofAnimatedLava);
            ((PrintWriter)object).println("ofAnimatedFire:" + this.ofAnimatedFire);
            ((PrintWriter)object).println("ofAnimatedPortal:" + this.ofAnimatedPortal);
            ((PrintWriter)object).println("ofAnimatedRedstone:" + this.ofAnimatedRedstone);
            ((PrintWriter)object).println("ofAnimatedExplosion:" + this.ofAnimatedExplosion);
            ((PrintWriter)object).println("ofAnimatedFlame:" + this.ofAnimatedFlame);
            ((PrintWriter)object).println("ofAnimatedSmoke:" + this.ofAnimatedSmoke);
            ((PrintWriter)object).println("ofVoidParticles:" + this.ofVoidParticles);
            ((PrintWriter)object).println("ofWaterParticles:" + this.ofWaterParticles);
            ((PrintWriter)object).println("ofPortalParticles:" + this.ofPortalParticles);
            ((PrintWriter)object).println("ofPotionParticles:" + this.ofPotionParticles);
            ((PrintWriter)object).println("ofDrippingWaterLava:" + this.ofDrippingWaterLava);
            ((PrintWriter)object).println("ofAnimatedTerrain:" + this.ofAnimatedTerrain);
            ((PrintWriter)object).println("ofAnimatedTextures:" + this.ofAnimatedTextures);
            ((PrintWriter)object).println("ofAnimatedItems:" + this.ofAnimatedItems);
            ((PrintWriter)object).println("ofRainSplash:" + this.ofRainSplash);
            ((PrintWriter)object).println("ofLagometer:" + this.ofLagometer);
            ((PrintWriter)object).println("ofAutoSaveTicks:" + this.ofAutoSaveTicks);
            ((PrintWriter)object).println("ofBetterGrass:" + this.ofBetterGrass);
            ((PrintWriter)object).println("ofConnectedTextures:" + this.ofConnectedTextures);
            ((PrintWriter)object).println("ofWeather:" + this.ofWeather);
            ((PrintWriter)object).println("ofSky:" + this.ofSky);
            ((PrintWriter)object).println("ofStars:" + this.ofStars);
            ((PrintWriter)object).println("ofSunMoon:" + this.ofSunMoon);
            ((PrintWriter)object).println("ofChunkUpdates:" + this.ofChunkUpdates);
            ((PrintWriter)object).println("ofChunkLoading:" + this.ofChunkLoading);
            ((PrintWriter)object).println("ofChunkUpdatesDynamic:" + this.ofChunkUpdatesDynamic);
            ((PrintWriter)object).println("ofTime:" + this.ofTime);
            ((PrintWriter)object).println("ofClearWater:" + this.ofClearWater);
            ((PrintWriter)object).println("ofDepthFog:" + this.ofDepthFog);
            ((PrintWriter)object).println("ofAaLevel:" + this.ofAaLevel);
            ((PrintWriter)object).println("ofAfLevel:" + this.ofAfLevel);
            ((PrintWriter)object).println("ofProfiler:" + this.ofProfiler);
            ((PrintWriter)object).println("ofBetterSnow:" + this.ofBetterSnow);
            ((PrintWriter)object).println("ofSwampColors:" + this.ofSwampColors);
            ((PrintWriter)object).println("ofRandomMobs:" + this.ofRandomMobs);
            ((PrintWriter)object).println("ofSmoothBiomes:" + this.ofSmoothBiomes);
            ((PrintWriter)object).println("ofCustomFonts:" + this.ofCustomFonts);
            ((PrintWriter)object).println("ofCustomColors:" + this.ofCustomColors);
            ((PrintWriter)object).println("ofCustomSky:" + this.ofCustomSky);
            ((PrintWriter)object).println("ofShowCapes:" + this.ofShowCapes);
            ((PrintWriter)object).println("ofNaturalTextures:" + this.ofNaturalTextures);
            ((PrintWriter)object).println("ofLazyChunkLoading:" + this.ofLazyChunkLoading);
            ((PrintWriter)object).println("ofFullscreenMode:" + this.ofFullscreenMode);
            ((PrintWriter)object).println("ofFastMath:" + this.ofFastMath);
            ((PrintWriter)object).close();
        }
        catch (Exception exception) {
            Config.warn("Failed to save options");
            exception.printStackTrace();
        }
        this.func_82879_c();
    }

    public void func_82879_c() {
        if (this.field_74317_L._t != null) {
            this.field_74317_L._t.field_71174_a._b(new grje(this.field_74363_ab, this.field_74339_e, this.field_74343_n, this.field_74344_o, this.field_74318_M, this.field_82880_z));
        }
    }

    public void resetSettings() {
    }

    public void updateVSync() {
        Display.setVSyncEnabled(this.field_74352_v);
    }

    public static int fineToRenderDistance(int n) {
        int n2 = 3;
        if (n > 32) {
            n2 = 2;
        }
        if (n > 64) {
            n2 = 1;
        }
        if (n > 128) {
            n2 = 0;
        }
        return n2;
    }

    public static int renderDistanceToFine(int n) {
        return 32 << 3 - n;
    }

    public static int fineToLimitFramerate(int n) {
        int n2 = 2;
        if (n > 35) {
            n2 = 1;
        }
        if (n >= 200) {
            n2 = 0;
        }
        if (n <= 0) {
            n2 = 0;
        }
        return n2;
    }

    public static int limitFramerateToFine(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 120;
            }
            case 2: {
                return 35;
            }
        }
        return 0;
    }

    public boolean func_74309_c() {
        return this.ofRenderDistanceFine > 64 && this.field_74345_l;
    }
}

