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
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.settings.EnumOptions;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.packet.Packet204ClientInfo;
import net.minecraft.util.sajh;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.EmptyChunk;
import net.minecraft.world.chunk.IChunkProvider;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class GameSettings {
    public static final String[] RENDER_DISTANCES = new String[]{"options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"};
    public static final String[] DIFFICULTIES = new String[]{"options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"};
    public static final String[] GUISCALES = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
    public static final String[] CHAT_VISIBILITIES = new String[]{"options.chat.visibility.full", "options.chat.visibility.system", "options.chat.visibility.hidden"};
    public static final String[] PARTICLES = new String[]{"options.particles.all", "options.particles.decreased", "options.particles.minimal"};
    public static final String[] LIMIT_FRAMERATES = new String[]{"performance.max", "performance.balanced", "performance.powersaver"};
    public static final String[] AMBIENT_OCCLUSIONS = new String[]{"options.ao.off", "options.ao.min", "options.ao.max"};
    public float musicVolume = 1.0f;
    public float soundVolume = 1.0f;
    public float mouseSensitivity = 0.5f;
    public boolean invertMouse;
    public int renderDistance = 1;
    public boolean viewBobbing = true;
    public boolean anaglyph;
    public boolean advancedOpengl;
    public int limitFramerate = 0;
    public boolean fancyGraphics = true;
    public int ambientOcclusion = 2;
    public boolean clouds = false;
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
    public KeyBinding ofKeyBindZoom;
    public String skin = "Default";
    public int chatVisibility;
    public boolean chatColours = true;
    public boolean chatLinks = true;
    public boolean chatLinksPrompt = true;
    public float chatOpacity = 1.0f;
    public boolean serverTextures = true;
    public boolean snooperEnabled = true;
    public boolean fullScreen;
    public boolean enableVsync = false;
    public boolean hideServerAddress;
    public boolean advancedItemTooltips;
    public boolean pauseOnLostFocus = true;
    public boolean showCape = true;
    public boolean touchscreen;
    public int overrideWidth;
    public int overrideHeight;
    public boolean heldItemTooltips = true;
    public float chatScale = 1.0f;
    public float chatWidth = 1.0f;
    public float chatHeightUnfocused = 0.44366196f;
    public float chatHeightFocused = 1.0f;
    public KeyBinding keyBindForward = new KeyBinding("key.forward", 17);
    public KeyBinding keyBindLeft = new KeyBinding("key.left", 30);
    public KeyBinding keyBindBack = new KeyBinding("key.back", 31);
    public KeyBinding keyBindRight = new KeyBinding("key.right", 32);
    public KeyBinding keyBindJump = new KeyBinding("key.jump", 57);
    public KeyBinding keyBindInventory = new KeyBinding("key.inventory", 18);
    public KeyBinding keyBindDrop = new KeyBinding("key.drop", 16);
    public KeyBinding keyBindChat = new KeyBinding("key.chat", 20);
    public KeyBinding keyBindSneak = new KeyBinding("key.sneak", 42);
    public KeyBinding keyBindAttack = new KeyBinding("key.attack", -100);
    public KeyBinding keyBindUseItem = new KeyBinding("key.use", -99);
    public KeyBinding keyBindPlayerList = new KeyBinding("key.playerlist", 15);
    public KeyBinding keyBindPickBlock = new KeyBinding("key.pickItem", -98);
    public KeyBinding keyBindCommand = new KeyBinding("key.command", 53);
    public KeyBinding[] keyBindings;
    public Minecraft mc;
    public File optionsFile;
    public int difficulty = 2;
    public boolean hideGUI;
    public int thirdPersonView;
    public boolean showDebugInfo;
    public boolean showDebugProfilerChart;
    public String lastServer = "";
    public boolean noclip;
    public boolean smoothCamera;
    public boolean debugCamEnable;
    public float noclipRate = 1.0f;
    public float debugCamRate = 1.0f;
    public float fovSetting;
    public float gammaSetting;
    public int guiScale;
    public int particleSetting;
    public String language = "en_US";
    public File optionsFileOF;

    public GameSettings(Minecraft minecraft, File file) {
        this.ofKeyBindZoom = new KeyBinding("Zoom", 29);
        this.keyBindings = new KeyBinding[]{this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.ofKeyBindZoom, this.keyBindCommand};
        this.mc = minecraft;
        this.optionsFile = new File(file, "options.txt");
        this.optionsFileOF = new File(file, "optionsof_new1.txt");
        this.loadOptions();
        Config.initGameSettings(this);
    }

    public GameSettings() {
        this.ofKeyBindZoom = new KeyBinding("Zoom", 29);
        this.keyBindings = new KeyBinding[]{this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.ofKeyBindZoom, this.keyBindCommand};
    }

    public String getKeyBindingDescription(int n) {
        return wpcz._a(this.keyBindings[n]._c);
    }

    public String getOptionDisplayString(int n) {
        int n2 = this.keyBindings[n]._d;
        return GameSettings.getKeyDisplayString(n2);
    }

    public static String getKeyDisplayString(int n) {
        return n < 0 ? wpcz._a("key.mouseButton", n + 101) : Keyboard.getKeyName(n);
    }

    public static boolean isKeyDown(KeyBinding keyBinding) {
        return keyBinding._d < 0 ? Mouse.isButtonDown(keyBinding._d + 100) : Keyboard.isKeyDown(keyBinding._d);
    }

    public void setKeyBinding(int n, int n2) {
        this.keyBindings[n]._d = n2;
        this.saveOptions();
    }

    public void setOfRenderDistanceFine(int n) {
        int n2 = this.ofRenderDistanceFine;
        this.ofRenderDistanceFine = n >> 4 << 4;
        this.ofRenderDistanceFine = Config.limit(this.ofRenderDistanceFine, 32, 512);
        this.renderDistance = GameSettings.fineToRenderDistance(this.ofRenderDistanceFine);
        if (this.ofRenderDistanceFine != n2) {
            this.mc._s._b();
        }
    }

    public void setOptionFloatValue(EnumOptions enumOptions, float f) {
        if (enumOptions == EnumOptions._a) {
            this.musicVolume = f;
            this.mc._N._c();
        }
        if (enumOptions == EnumOptions._b) {
            this.soundVolume = f;
            this.mc._N._c();
        }
        if (enumOptions == EnumOptions._d) {
            this.mouseSensitivity = f;
        }
        if (enumOptions == EnumOptions._e) {
            this.fovSetting = f;
        }
        if (enumOptions == EnumOptions._f) {
            this.gammaSetting = f;
        }
        if (enumOptions == EnumOptions._O) {
            this.ofCloudsHeight = f;
        }
        if (enumOptions == EnumOptions._X) {
            this.ofAoLevel = f;
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions.__aJ) {
            this.setOfRenderDistanceFine(32 + (int)(f * 480.0f));
        }
        if (enumOptions == EnumOptions.__aN) {
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
            this.limitFramerate = GameSettings.fineToLimitFramerate(this.ofLimitFramerateFine);
        }
        if (enumOptions == EnumOptions._u) {
            this.chatOpacity = f;
            this.mc._J.getChatGUI()._b();
        }
        if (enumOptions == EnumOptions._E) {
            this.chatHeightFocused = f;
            this.mc._J.getChatGUI()._b();
        }
        if (enumOptions == EnumOptions._F) {
            this.chatHeightUnfocused = f;
            this.mc._J.getChatGUI()._b();
        }
        if (enumOptions == EnumOptions._D) {
            this.chatWidth = f;
            this.mc._J.getChatGUI()._b();
        }
        if (enumOptions == EnumOptions._C) {
            this.chatScale = f;
            this.mc._J.getChatGUI()._b();
        }
    }

    public void updateWaterOpacity() {
        IChunkProvider iChunkProvider;
        if (this.mc._J() != null) {
            Config.waterOpacityChanged = true;
        }
        int n = 3;
        if (this.ofClearWater) {
            n = 1;
        }
        Block.waterStill.setLightOpacity(n);
        Block.waterMoving.setLightOpacity(n);
        if (this.mc._r != null && (iChunkProvider = this.mc._r.chunkProvider) != null) {
            for (int i = -512; i < 512; ++i) {
                for (int j = -512; j < 512; ++j) {
                    Chunk chunk;
                    if (!iChunkProvider._c(i, j) || (chunk = iChunkProvider._b(i, j)) == null || chunk instanceof EmptyChunk) continue;
                    ujzm[] ujzmArray = chunk._b();
                    for (int k = 0; k < ujzmArray.length; ++k) {
                        wqak wqak2;
                        ujzm ujzm2 = ujzmArray[k];
                        if (ujzm2 == null || (wqak2 = ujzm2._j()) == null) continue;
                        byte[] byArray = wqak2._a;
                        for (int i2 = 0; i2 < byArray.length; ++i2) {
                            byArray[i2] = 0;
                        }
                    }
                    chunk._d();
                }
            }
            this.mc._s._b();
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
        if (this.mc._s != null) {
            this.mc._s._b();
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
        this.particleSetting = bl ? 0 : 2;
        this.ofDrippingWaterLava = bl;
        this.ofAnimatedTerrain = bl;
        this.ofAnimatedItems = bl;
        this.ofAnimatedTextures = bl;
    }

    public void setOptionValue(EnumOptions enumOptions, int n) {
        int n2;
        Object object;
        if (enumOptions == EnumOptions._c) {
            boolean bl = this.invertMouse = !this.invertMouse;
        }
        if (enumOptions == EnumOptions._g) {
            this.renderDistance = this.renderDistance + n & 3;
            this.ofRenderDistanceFine = GameSettings.renderDistanceToFine(this.renderDistance);
        }
        if (enumOptions == EnumOptions._o) {
            this.guiScale = this.guiScale + n & 3;
        }
        if (enumOptions == EnumOptions._q) {
            this.particleSetting = (this.particleSetting + n) % 3;
        }
        if (enumOptions == EnumOptions._h) {
            boolean bl = this.viewBobbing = !this.viewBobbing;
        }
        if (enumOptions == EnumOptions._p) {
            boolean bl = this.clouds = !this.clouds;
        }
        if (enumOptions == EnumOptions._j) {
            if (!Config.isOcclusionAvailable()) {
                this.ofOcclusionFancy = false;
                this.advancedOpengl = false;
            } else if (!this.advancedOpengl) {
                this.advancedOpengl = true;
                this.ofOcclusionFancy = false;
            } else if (!this.ofOcclusionFancy) {
                this.ofOcclusionFancy = true;
            } else {
                this.ofOcclusionFancy = false;
                this.advancedOpengl = false;
            }
            this.mc._s._g();
        }
        if (enumOptions == EnumOptions._i) {
            this.anaglyph = !this.anaglyph;
            this.mc._c();
        }
        if (enumOptions == EnumOptions._k) {
            this.limitFramerate = (this.limitFramerate + n + 3) % 3;
            this.ofLimitFramerateFine = GameSettings.limitFramerateToFine(this.limitFramerate);
        }
        if (enumOptions == EnumOptions._l) {
            this.difficulty = this.difficulty + n & 3;
        }
        if (enumOptions == EnumOptions._m) {
            this.fancyGraphics = !this.fancyGraphics;
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions._n) {
            this.ambientOcclusion = (this.ambientOcclusion + n) % 3;
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions._G) {
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
        if (enumOptions == EnumOptions._H) {
            this.ofFogStart += 0.2f;
            if (this.ofFogStart > 0.81f) {
                this.ofFogStart = 0.2f;
            }
        }
        if (enumOptions == EnumOptions._I) {
            ++this.ofMipmapLevel;
            if (this.ofMipmapLevel > 4) {
                this.ofMipmapLevel = 0;
            }
            TextureUtils.refreshBlockTextures();
        }
        if (enumOptions == EnumOptions._J) {
            ++this.ofMipmapType;
            if (this.ofMipmapType > 3) {
                this.ofMipmapType = 0;
            }
            TextureUtils.refreshBlockTextures();
        }
        if (enumOptions == EnumOptions._K) {
            this.ofLoadFar = !this.ofLoadFar;
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions._L) {
            this.ofPreloadedChunks += 2;
            if (this.ofPreloadedChunks > 8) {
                this.ofPreloadedChunks = 0;
            }
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions._M) {
            boolean bl = this.ofSmoothFps = !this.ofSmoothFps;
        }
        if (enumOptions == EnumOptions.__an) {
            this.ofSmoothWorld = !this.ofSmoothWorld;
            Config.updateThreadPriorities();
        }
        if (enumOptions == EnumOptions._N) {
            ++this.ofClouds;
            if (this.ofClouds > 3) {
                this.ofClouds = 0;
            }
        }
        if (enumOptions == EnumOptions._P) {
            ++this.ofTrees;
            if (this.ofTrees > 2) {
                this.ofTrees = 0;
            }
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions._Q) {
            ++this.ofGrass;
            if (this.ofGrass > 2) {
                this.ofGrass = 0;
            }
            RenderBlocks._e = Config.isGrassFancy();
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions.__aP) {
            ++this.ofDroppedItems;
            if (this.ofDroppedItems > 2) {
                this.ofDroppedItems = 0;
            }
        }
        if (enumOptions == EnumOptions._R) {
            ++this.ofRain;
            if (this.ofRain > 3) {
                this.ofRain = 0;
            }
        }
        if (enumOptions == EnumOptions._S) {
            ++this.ofWater;
            if (this.ofWater > 2) {
                this.ofWater = 0;
            }
        }
        if (enumOptions == EnumOptions._T) {
            ++this.ofAnimatedWater;
            if (this.ofAnimatedWater > 2) {
                this.ofAnimatedWater = 0;
            }
        }
        if (enumOptions == EnumOptions._U) {
            ++this.ofAnimatedLava;
            if (this.ofAnimatedLava > 2) {
                this.ofAnimatedLava = 0;
            }
        }
        if (enumOptions == EnumOptions._V) {
            boolean bl = this.ofAnimatedFire = !this.ofAnimatedFire;
        }
        if (enumOptions == EnumOptions._W) {
            boolean bl = this.ofAnimatedPortal = !this.ofAnimatedPortal;
        }
        if (enumOptions == EnumOptions.__ab) {
            boolean bl = this.ofAnimatedRedstone = !this.ofAnimatedRedstone;
        }
        if (enumOptions == EnumOptions.__ac) {
            boolean bl = this.ofAnimatedExplosion = !this.ofAnimatedExplosion;
        }
        if (enumOptions == EnumOptions.__ad) {
            boolean bl = this.ofAnimatedFlame = !this.ofAnimatedFlame;
        }
        if (enumOptions == EnumOptions.__ae) {
            boolean bl = this.ofAnimatedSmoke = !this.ofAnimatedSmoke;
        }
        if (enumOptions == EnumOptions.__ap) {
            boolean bl = this.ofVoidParticles = !this.ofVoidParticles;
        }
        if (enumOptions == EnumOptions.__aq) {
            boolean bl = this.ofWaterParticles = !this.ofWaterParticles;
        }
        if (enumOptions == EnumOptions.__as) {
            boolean bl = this.ofPortalParticles = !this.ofPortalParticles;
        }
        if (enumOptions == EnumOptions.__at) {
            boolean bl = this.ofPotionParticles = !this.ofPotionParticles;
        }
        if (enumOptions == EnumOptions.__av) {
            boolean bl = this.ofDrippingWaterLava = !this.ofDrippingWaterLava;
        }
        if (enumOptions == EnumOptions.__ay) {
            boolean bl = this.ofAnimatedTerrain = !this.ofAnimatedTerrain;
        }
        if (enumOptions == EnumOptions.__aK) {
            boolean bl = this.ofAnimatedTextures = !this.ofAnimatedTextures;
        }
        if (enumOptions == EnumOptions.__az) {
            boolean bl = this.ofAnimatedItems = !this.ofAnimatedItems;
        }
        if (enumOptions == EnumOptions.__ar) {
            boolean bl = this.ofRainSplash = !this.ofRainSplash;
        }
        if (enumOptions == EnumOptions._Y) {
            boolean bl = this.ofLagometer = !this.ofLagometer;
        }
        if (enumOptions == EnumOptions._Z) {
            this.ofAutoSaveTicks *= 10;
            if (this.ofAutoSaveTicks > 40000) {
                this.ofAutoSaveTicks = 40;
            }
        }
        if (enumOptions == EnumOptions.__aa) {
            ++this.ofBetterGrass;
            if (this.ofBetterGrass > 3) {
                this.ofBetterGrass = 1;
            }
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions.__aG) {
            ++this.ofConnectedTextures;
            if (this.ofConnectedTextures > 3) {
                this.ofConnectedTextures = 1;
            }
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions.__af) {
            boolean bl = this.ofWeather = !this.ofWeather;
        }
        if (enumOptions == EnumOptions.__ag) {
            boolean bl = this.ofSky = !this.ofSky;
        }
        if (enumOptions == EnumOptions.__ah) {
            boolean bl = this.ofStars = !this.ofStars;
        }
        if (enumOptions == EnumOptions.__ai) {
            boolean bl = this.ofSunMoon = !this.ofSunMoon;
        }
        if (enumOptions == EnumOptions.__aj) {
            ++this.ofChunkUpdates;
            if (this.ofChunkUpdates > 5) {
                this.ofChunkUpdates = 1;
            }
        }
        if (enumOptions == EnumOptions.__aM) {
            ++this.ofChunkLoading;
            if (this.ofChunkLoading > 2) {
                this.ofChunkLoading = 0;
            }
            this.updateChunkLoading();
        }
        if (enumOptions == EnumOptions.__ak) {
            boolean bl = this.ofChunkUpdatesDynamic = !this.ofChunkUpdatesDynamic;
        }
        if (enumOptions == EnumOptions.__al) {
            ++this.ofTime;
            if (this.ofTime > 3) {
                this.ofTime = 0;
            }
        }
        if (enumOptions == EnumOptions.__am) {
            this.ofClearWater = !this.ofClearWater;
            this.updateWaterOpacity();
        }
        if (enumOptions == EnumOptions.__ao) {
            boolean bl = this.ofDepthFog = !this.ofDepthFog;
        }
        if (enumOptions == EnumOptions.__aH) {
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
        if (enumOptions == EnumOptions.__aI) {
            this.ofAfLevel *= 2;
            if (this.ofAfLevel > 16) {
                this.ofAfLevel = 1;
            }
            this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
            TextureUtils.refreshBlockTextures();
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions.__au) {
            boolean bl = this.ofProfiler = !this.ofProfiler;
        }
        if (enumOptions == EnumOptions.__aw) {
            this.ofBetterSnow = !this.ofBetterSnow;
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions.__aA) {
            this.ofSwampColors = !this.ofSwampColors;
            CustomColorizer.updateUseDefaultColorMultiplier();
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions.__aB) {
            this.ofRandomMobs = !this.ofRandomMobs;
            RandomMobs.resetTextures();
        }
        if (enumOptions == EnumOptions.__aC) {
            this.ofSmoothBiomes = !this.ofSmoothBiomes;
            CustomColorizer.updateUseDefaultColorMultiplier();
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions.__aD) {
            this.ofCustomFonts = !this.ofCustomFonts;
            this.mc._z.onResourceManagerReload(Config.getResourceManager());
            this.mc._A.onResourceManagerReload(Config.getResourceManager());
        }
        if (enumOptions == EnumOptions.__aE) {
            this.ofCustomColors = !this.ofCustomColors;
            CustomColorizer.update();
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions.__aR) {
            this.ofCustomSky = !this.ofCustomSky;
            CustomSky.update();
        }
        if (enumOptions == EnumOptions.__aF) {
            this.ofShowCapes = !this.ofShowCapes;
            this.mc._s._j();
        }
        if (enumOptions == EnumOptions.__aL) {
            this.ofNaturalTextures = !this.ofNaturalTextures;
            NaturalTextures.update();
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions.__aS) {
            sajh._m = this.ofFastMath = !this.ofFastMath;
        }
        if (enumOptions == EnumOptions.__aQ) {
            this.ofLazyChunkLoading = !this.ofLazyChunkLoading;
            this.mc._s._b();
        }
        if (enumOptions == EnumOptions.__ax) {
            object = Arrays.asList(Config.getFullscreenModes());
            this.ofFullscreenMode = this.ofFullscreenMode.equals(DEFAULT_STR) ? (String)object.get(0) : ((n2 = object.indexOf(this.ofFullscreenMode)) < 0 ? DEFAULT_STR : (++n2 >= object.size() ? DEFAULT_STR : (String)object.get(n2)));
        }
        if (enumOptions == EnumOptions.__aO) {
            boolean bl = this.heldItemTooltips = !this.heldItemTooltips;
        }
        if (enumOptions == EnumOptions._r) {
            this.chatVisibility = (this.chatVisibility + n) % 3;
        }
        if (enumOptions == EnumOptions._s) {
            boolean bl = this.chatColours = !this.chatColours;
        }
        if (enumOptions == EnumOptions._t) {
            boolean bl = this.chatLinks = !this.chatLinks;
        }
        if (enumOptions == EnumOptions._v) {
            boolean bl = this.chatLinksPrompt = !this.chatLinksPrompt;
        }
        if (enumOptions == EnumOptions._w) {
            boolean bl = this.serverTextures = !this.serverTextures;
        }
        if (enumOptions == EnumOptions._x) {
            boolean bl = this.snooperEnabled = !this.snooperEnabled;
        }
        if (enumOptions == EnumOptions._A) {
            boolean bl = this.showCape = !this.showCape;
        }
        if (enumOptions == EnumOptions._B) {
            boolean bl = this.touchscreen = !this.touchscreen;
        }
        if (enumOptions == EnumOptions._y) {
            boolean bl = this.fullScreen = !this.fullScreen;
            if (this.mc._N() != this.fullScreen) {
                this.mc._r();
            }
        }
        if (enumOptions == EnumOptions._z) {
            this.enableVsync = !this.enableVsync;
            Display.setVSyncEnabled(this.enableVsync);
        }
        this.saveOptions();
    }

    public float getOptionFloatValue(EnumOptions enumOptions) {
        return enumOptions == EnumOptions._O ? this.ofCloudsHeight : (enumOptions == EnumOptions._X ? this.ofAoLevel : (enumOptions == EnumOptions.__aJ ? (float)(this.ofRenderDistanceFine - 32) / 480.0f : (enumOptions == EnumOptions.__aN ? (this.ofLimitFramerateFine > 0 && this.ofLimitFramerateFine < 200 ? (float)this.ofLimitFramerateFine / 200.0f : (this.enableVsync ? 0.0f : 1.0f)) : (enumOptions == EnumOptions._e ? this.fovSetting : (enumOptions == EnumOptions._f ? this.gammaSetting : (enumOptions == EnumOptions._a ? this.musicVolume : (enumOptions == EnumOptions._b ? this.soundVolume : (enumOptions == EnumOptions._d ? this.mouseSensitivity : (enumOptions == EnumOptions._u ? this.chatOpacity : (enumOptions == EnumOptions._E ? this.chatHeightFocused : (enumOptions == EnumOptions._F ? this.chatHeightUnfocused : (enumOptions == EnumOptions._C ? this.chatScale : (enumOptions == EnumOptions._D ? this.chatWidth : 0.0f)))))))))))));
    }

    public boolean getOptionOrdinalValue(EnumOptions enumOptions) {
        switch (enumOptions) {
            case _c: {
                return this.invertMouse;
            }
            case _h: {
                return this.viewBobbing;
            }
            case _i: {
                return this.anaglyph;
            }
            case _j: {
                return this.advancedOpengl;
            }
            case _p: {
                return this.clouds;
            }
            case _s: {
                return this.chatColours;
            }
            case _t: {
                return this.chatLinks;
            }
            case _v: {
                return this.chatLinksPrompt;
            }
            case _w: {
                return this.serverTextures;
            }
            case _x: {
                return this.snooperEnabled;
            }
            case _y: {
                return this.fullScreen;
            }
            case _z: {
                return this.enableVsync;
            }
            case _A: {
                return this.showCape;
            }
            case _B: {
                return this.touchscreen;
            }
        }
        return false;
    }

    public static String getTranslation(String[] stringArray, int n) {
        if (n < 0 || n >= stringArray.length) {
            n = 0;
        }
        return wpcz._a(stringArray[n]);
    }

    public String getKeyBinding(EnumOptions enumOptions) {
        String string = wpcz._a(enumOptions._d());
        if (string == null) {
            string = enumOptions._d();
        }
        String string2 = string + ": ";
        if (enumOptions == EnumOptions.__aJ) {
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
        if (enumOptions == EnumOptions.__aN) {
            return this.ofLimitFramerateFine > 0 && this.ofLimitFramerateFine < 200 ? string2 + " " + this.ofLimitFramerateFine + " FPS" : (this.enableVsync ? string2 + " VSync" : string2 + " MaxFPS");
        }
        if (enumOptions == EnumOptions._j) {
            return !this.advancedOpengl ? string2 + "OFF" : (this.ofOcclusionFancy ? string2 + "Fancy" : string2 + "Fast");
        }
        if (enumOptions == EnumOptions._G) {
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
        if (enumOptions == EnumOptions._H) {
            return string2 + this.ofFogStart;
        }
        if (enumOptions == EnumOptions._I) {
            return this.ofMipmapLevel == 0 ? string2 + "OFF" : (this.ofMipmapLevel == 4 ? string2 + "Max" : string2 + this.ofMipmapLevel);
        }
        if (enumOptions == EnumOptions._J) {
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
        if (enumOptions == EnumOptions._K) {
            return this.ofLoadFar ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions._L) {
            return this.ofPreloadedChunks == 0 ? string2 + "OFF" : string2 + this.ofPreloadedChunks;
        }
        if (enumOptions == EnumOptions._M) {
            return this.ofSmoothFps ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__an) {
            return this.ofSmoothWorld ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions._N) {
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
        if (enumOptions == EnumOptions._Q) {
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
        if (enumOptions == EnumOptions.__aP) {
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
        if (enumOptions == EnumOptions._R) {
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
        if (enumOptions == EnumOptions._S) {
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
        if (enumOptions == EnumOptions._T) {
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
        if (enumOptions == EnumOptions._U) {
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
        if (enumOptions == EnumOptions._V) {
            return this.ofAnimatedFire ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions._W) {
            return this.ofAnimatedPortal ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ab) {
            return this.ofAnimatedRedstone ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ac) {
            return this.ofAnimatedExplosion ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ad) {
            return this.ofAnimatedFlame ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ae) {
            return this.ofAnimatedSmoke ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ap) {
            return this.ofVoidParticles ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aq) {
            return this.ofWaterParticles ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__as) {
            return this.ofPortalParticles ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__at) {
            return this.ofPotionParticles ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__av) {
            return this.ofDrippingWaterLava ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ay) {
            return this.ofAnimatedTerrain ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aK) {
            return this.ofAnimatedTextures ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__az) {
            return this.ofAnimatedItems ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ar) {
            return this.ofRainSplash ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions._Y) {
            return this.ofLagometer ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions._Z) {
            return this.ofAutoSaveTicks <= 40 ? string2 + "Default (2s)" : (this.ofAutoSaveTicks <= 400 ? string2 + "20s" : (this.ofAutoSaveTicks <= 4000 ? string2 + "3min" : string2 + "30min"));
        }
        if (enumOptions == EnumOptions.__aa) {
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
        if (enumOptions == EnumOptions.__aG) {
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
        if (enumOptions == EnumOptions.__af) {
            return this.ofWeather ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ag) {
            return this.ofSky ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ah) {
            return this.ofStars ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ai) {
            return this.ofSunMoon ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aj) {
            return string2 + this.ofChunkUpdates;
        }
        if (enumOptions == EnumOptions.__aM) {
            return this.ofChunkLoading == 1 ? string2 + "Smooth" : (this.ofChunkLoading == 2 ? string2 + "Multi-Core" : string2 + DEFAULT_STR);
        }
        if (enumOptions == EnumOptions.__ak) {
            return this.ofChunkUpdatesDynamic ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__al) {
            return this.ofTime == 1 ? string2 + "Day Only" : (this.ofTime == 3 ? string2 + "Night Only" : string2 + DEFAULT_STR);
        }
        if (enumOptions == EnumOptions.__am) {
            return this.ofClearWater ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ao) {
            return this.ofDepthFog ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aH) {
            return this.ofAaLevel == 0 ? string2 + "OFF" : string2 + this.ofAaLevel;
        }
        if (enumOptions == EnumOptions.__aI) {
            return this.ofAfLevel == 1 ? string2 + "OFF" : string2 + this.ofAfLevel;
        }
        if (enumOptions == EnumOptions.__au) {
            return this.ofProfiler ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aw) {
            return this.ofBetterSnow ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aA) {
            return this.ofSwampColors ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aB) {
            return this.ofRandomMobs ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aC) {
            return this.ofSmoothBiomes ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aD) {
            return this.ofCustomFonts ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aE) {
            return this.ofCustomColors ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aR) {
            return this.ofCustomSky ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aF) {
            return this.ofShowCapes ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aL) {
            return this.ofNaturalTextures ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aS) {
            return this.ofFastMath ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__aQ) {
            return this.ofLazyChunkLoading ? string2 + "ON" : string2 + "OFF";
        }
        if (enumOptions == EnumOptions.__ax) {
            return string2 + this.ofFullscreenMode;
        }
        if (enumOptions == EnumOptions.__aO) {
            return this.heldItemTooltips ? string2 + "ON" : string2 + "OFF";
        }
        String string4 = wpcz._a(enumOptions._d()) + ": ";
        if (enumOptions._a()) {
            float f = this.getOptionFloatValue(enumOptions);
            return enumOptions == EnumOptions._d ? (f == 0.0f ? string4 + wpcz._a("options.sensitivity.min") : (f == 1.0f ? string4 + wpcz._a("options.sensitivity.max") : string4 + (int)(f * 200.0f) + "%")) : (enumOptions == EnumOptions._e ? (f == 0.0f ? string4 + wpcz._a("options.fov.min") : (f == 1.0f ? string4 + wpcz._a("options.fov.max") : string4 + (int)(70.0f + f * 40.0f))) : (enumOptions == EnumOptions._f ? (f == 0.0f ? string4 + wpcz._a("options.gamma.min") : (f == 1.0f ? string4 + wpcz._a("options.gamma.max") : string4 + "+" + (int)(f * 100.0f) + "%")) : (enumOptions == EnumOptions._u ? string4 + (int)(f * 90.0f + 10.0f) + "%" : (enumOptions == EnumOptions._F ? string4 + GuiNewChat._b(f) + "px" : (enumOptions == EnumOptions._E ? string4 + GuiNewChat._b(f) + "px" : (enumOptions == EnumOptions._D ? string4 + GuiNewChat._a(f) + "px" : (f == 0.0f ? string4 + wpcz._a("options.off") : string4 + (int)(f * 100.0f) + "%")))))));
        }
        if (enumOptions._b()) {
            boolean bl = this.getOptionOrdinalValue(enumOptions);
            return bl ? string4 + wpcz._a("options.on") : string4 + wpcz._a("options.off");
        }
        if (enumOptions == EnumOptions._g) {
            return string4 + GameSettings.getTranslation(RENDER_DISTANCES, this.renderDistance);
        }
        if (enumOptions == EnumOptions._l) {
            return string4 + GameSettings.getTranslation(DIFFICULTIES, this.difficulty);
        }
        if (enumOptions == EnumOptions._o) {
            return string4 + GameSettings.getTranslation(GUISCALES, this.guiScale);
        }
        if (enumOptions == EnumOptions._r) {
            return string4 + GameSettings.getTranslation(CHAT_VISIBILITIES, this.chatVisibility);
        }
        if (enumOptions == EnumOptions._q) {
            return string4 + GameSettings.getTranslation(PARTICLES, this.particleSetting);
        }
        if (enumOptions == EnumOptions._k) {
            return string4 + GameSettings.getTranslation(LIMIT_FRAMERATES, this.limitFramerate);
        }
        if (enumOptions == EnumOptions._n) {
            return string4 + GameSettings.getTranslation(AMBIENT_OCCLUSIONS, this.ambientOcclusion);
        }
        if (enumOptions == EnumOptions._m) {
            if (this.fancyGraphics) {
                return string4 + wpcz._a("options.graphics.fancy");
            }
            String string5 = "options.graphics.fast";
            return string4 + wpcz._a("options.graphics.fast");
        }
        return string4;
    }

    public void loadOptions() {
        Object object;
        Object object2;
        Object object3;
        block121: {
            block120: {
                if (this.optionsFile.exists()) break block120;
                qlgf._a(this);
                GloomyHooks.loadOptions(this);
                return;
            }
            try {
                object3 = new BufferedReader(new FileReader(this.optionsFile));
                object2 = "";
                while ((object2 = ((BufferedReader)object3).readLine()) != null) {
                    try {
                        object = ((String)object2).split(":");
                        if (object[0].equals("music")) {
                            this.musicVolume = this.parseFloat(object[1]);
                        }
                        if (object[0].equals("sound")) {
                            this.soundVolume = this.parseFloat((String)object[1]);
                        }
                        if (((String)object[0]).equals("mouseSensitivity")) {
                            this.mouseSensitivity = this.parseFloat((String)object[1]);
                        }
                        if (((String)object[0]).equals("fov")) {
                            this.fovSetting = this.parseFloat((String)object[1]);
                        }
                        if (((String)object[0]).equals("gamma")) {
                            this.gammaSetting = this.parseFloat((String)object[1]);
                        }
                        if (((String)object[0]).equals("invertYMouse")) {
                            this.invertMouse = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("viewDistance")) {
                            this.renderDistance = Integer.parseInt((String)object[1]);
                            this.ofRenderDistanceFine = GameSettings.renderDistanceToFine(this.renderDistance);
                        }
                        if (((String)object[0]).equals("guiScale")) {
                            this.guiScale = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("particles")) {
                            this.particleSetting = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("anaglyph3d")) {
                            this.anaglyph = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("advancedOpengl")) {
                            this.advancedOpengl = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("fpsLimit")) {
                            this.limitFramerate = Integer.parseInt((String)object[1]);
                            this.ofLimitFramerateFine = GameSettings.limitFramerateToFine(this.limitFramerate);
                        }
                        if (((String)object[0]).equals("difficulty")) {
                            this.difficulty = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("fancyGraphics")) {
                            this.fancyGraphics = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("ao")) {
                            this.ambientOcclusion = ((String)object[1]).equals("true") ? 2 : (((String)object[1]).equals("false") ? 0 : Integer.parseInt((String)object[1]));
                        }
                        if (((String)object[0]).equals("clouds")) {
                            this.clouds = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("skin")) {
                            this.skin = object[1];
                        }
                        if (((String)object[0]).equals("lastServer") && ((Object)object).length >= 2) {
                            this.lastServer = ((String)object2).substring(((String)object2).indexOf(58) + 1);
                        }
                        if (((String)object[0]).equals("lang") && ((Object)object).length >= 2) {
                            this.language = object[1];
                        }
                        if (((String)object[0]).equals("chatVisibility")) {
                            this.chatVisibility = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("chatColors")) {
                            this.chatColours = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("chatLinks")) {
                            this.chatLinks = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("chatLinksPrompt")) {
                            this.chatLinksPrompt = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("chatOpacity")) {
                            this.chatOpacity = this.parseFloat((String)object[1]);
                        }
                        if (((String)object[0]).equals("serverTextures")) {
                            this.serverTextures = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("snooperEnabled")) {
                            this.snooperEnabled = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("fullscreen")) {
                            this.fullScreen = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("enableVsync")) {
                            this.enableVsync = ((String)object[1]).equals("true");
                            this.updateVSync();
                        }
                        if (((String)object[0]).equals("hideServerAddress")) {
                            this.hideServerAddress = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("advancedItemTooltips")) {
                            this.advancedItemTooltips = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("pauseOnLostFocus")) {
                            this.pauseOnLostFocus = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("showCape")) {
                            this.showCape = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("touchscreen")) {
                            this.touchscreen = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("overrideHeight")) {
                            this.overrideHeight = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("overrideWidth")) {
                            this.overrideWidth = Integer.parseInt((String)object[1]);
                        }
                        if (((String)object[0]).equals("heldItemTooltips")) {
                            this.heldItemTooltips = ((String)object[1]).equals("true");
                        }
                        if (((String)object[0]).equals("chatHeightFocused")) {
                            this.chatHeightFocused = this.parseFloat((String)object[1]);
                        }
                        if (((String)object[0]).equals("chatHeightUnfocused")) {
                            this.chatHeightUnfocused = this.parseFloat((String)object[1]);
                        }
                        if (((String)object[0]).equals("chatScale")) {
                            this.chatScale = this.parseFloat((String)object[1]);
                        }
                        if (((String)object[0]).equals("chatWidth")) {
                            this.chatWidth = this.parseFloat((String)object[1]);
                        }
                        for (int i = 0; i < this.keyBindings.length; ++i) {
                            if (!((String)object[0]).equals("key_" + this.keyBindings[i]._c)) continue;
                            this.keyBindings[i]._d = Integer.parseInt((String)object[1]);
                        }
                    }
                    catch (Exception exception) {
                        this.mc._O()._b("Skipping bad option: " + (String)object2);
                        exception.printStackTrace();
                    }
                }
                KeyBinding._b();
                ((BufferedReader)object3).close();
            }
            catch (Exception exception) {
                this.mc._O()._b("Failed to load options");
                exception.printStackTrace();
            }
            object3 = this.optionsFileOF;
            if (!((File)object3).exists()) {
                object3 = this.optionsFile;
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
                        this.renderDistance = GameSettings.fineToRenderDistance(this.ofRenderDistanceFine);
                    }
                    if (stringArray[0].equals("ofLimitFramerateFine") && stringArray.length >= 2) {
                        this.ofLimitFramerateFine = Integer.valueOf(stringArray[1]);
                        this.ofLimitFramerateFine = Config.limit(this.ofLimitFramerateFine, 0, 199);
                        this.limitFramerate = GameSettings.fineToLimitFramerate(this.ofLimitFramerateFine);
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
            KeyBinding._b();
            ((BufferedReader)object2).close();
        }
        catch (Exception exception) {
            Config.warn("Failed to load options");
            exception.printStackTrace();
        }
        qlgf._a(this);
        GloomyHooks.loadOptions(this);
    }

    public float parseFloat(String string) {
        return string.equals("true") ? 1.0f : (string.equals("false") ? 0.0f : Float.parseFloat(string));
    }

    public void saveOptions() {
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
            object = new PrintWriter(new FileWriter(this.optionsFile));
            ((PrintWriter)object).println("music:" + this.musicVolume);
            ((PrintWriter)object).println("sound:" + this.soundVolume);
            ((PrintWriter)object).println("invertYMouse:" + this.invertMouse);
            ((PrintWriter)object).println("mouseSensitivity:" + this.mouseSensitivity);
            ((PrintWriter)object).println("fov:" + this.fovSetting);
            ((PrintWriter)object).println("gamma:" + this.gammaSetting);
            ((PrintWriter)object).println("viewDistance:" + this.renderDistance);
            ((PrintWriter)object).println("guiScale:" + this.guiScale);
            ((PrintWriter)object).println("particles:" + this.particleSetting);
            ((PrintWriter)object).println("bobView:" + this.viewBobbing);
            ((PrintWriter)object).println("anaglyph3d:" + this.anaglyph);
            ((PrintWriter)object).println("advancedOpengl:" + this.advancedOpengl);
            ((PrintWriter)object).println("fpsLimit:" + this.limitFramerate);
            ((PrintWriter)object).println("difficulty:" + this.difficulty);
            ((PrintWriter)object).println("fancyGraphics:" + this.fancyGraphics);
            ((PrintWriter)object).println("ao:" + this.ambientOcclusion);
            ((PrintWriter)object).println("clouds:" + this.clouds);
            ((PrintWriter)object).println("skin:" + this.skin);
            ((PrintWriter)object).println("lastServer:" + this.lastServer);
            ((PrintWriter)object).println("lang:" + this.language);
            ((PrintWriter)object).println("chatVisibility:" + this.chatVisibility);
            ((PrintWriter)object).println("chatColors:" + this.chatColours);
            ((PrintWriter)object).println("chatLinks:" + this.chatLinks);
            ((PrintWriter)object).println("chatLinksPrompt:" + this.chatLinksPrompt);
            ((PrintWriter)object).println("chatOpacity:" + this.chatOpacity);
            ((PrintWriter)object).println("serverTextures:" + this.serverTextures);
            ((PrintWriter)object).println("snooperEnabled:" + this.snooperEnabled);
            ((PrintWriter)object).println("fullscreen:" + this.fullScreen);
            ((PrintWriter)object).println("enableVsync:" + this.enableVsync);
            ((PrintWriter)object).println("hideServerAddress:" + this.hideServerAddress);
            ((PrintWriter)object).println("advancedItemTooltips:" + this.advancedItemTooltips);
            ((PrintWriter)object).println("pauseOnLostFocus:" + this.pauseOnLostFocus);
            ((PrintWriter)object).println("showCape:" + this.showCape);
            ((PrintWriter)object).println("touchscreen:" + this.touchscreen);
            ((PrintWriter)object).println("overrideWidth:" + this.overrideWidth);
            ((PrintWriter)object).println("overrideHeight:" + this.overrideHeight);
            ((PrintWriter)object).println("heldItemTooltips:" + this.heldItemTooltips);
            ((PrintWriter)object).println("chatHeightFocused:" + this.chatHeightFocused);
            ((PrintWriter)object).println("chatHeightUnfocused:" + this.chatHeightUnfocused);
            ((PrintWriter)object).println("chatScale:" + this.chatScale);
            ((PrintWriter)object).println("chatWidth:" + this.chatWidth);
            for (int i = 0; i < this.keyBindings.length; ++i) {
                ((PrintWriter)object).println("key_" + this.keyBindings[i]._c + ":" + this.keyBindings[i]._d);
            }
            ((PrintWriter)object).close();
        }
        catch (Exception exception) {
            this.mc._O()._b("Failed to save options");
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
        this.sendSettingsToServer();
    }

    public void sendSettingsToServer() {
        if (this.mc._t != null) {
            this.mc._t.sendQueue._b(new Packet204ClientInfo(this.language, this.renderDistance, this.chatVisibility, this.chatColours, this.difficulty, this.showCape));
        }
    }

    public void resetSettings() {
    }

    public void updateVSync() {
        Display.setVSyncEnabled(this.enableVsync);
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

    public boolean shouldRenderClouds() {
        return this.ofRenderDistanceFine > 64 && this.clouds;
    }
}

