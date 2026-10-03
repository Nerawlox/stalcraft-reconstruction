/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.options;

import cpw.mods.fml.common.Loader;
import gloomyfolken.mods.asm.Logger;
import gloomyfolken.mods.core.main.ClientProxy;
import gloomyfolken.mods.core.main.GloomyCore;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;

public class OptionsSet {
    public static OptionsSet[] optionsSets = new OptionsSet[5];
    private static boolean optifineFound;
    private static boolean betterGrassFound;
    private static Class bgClass;
    private static Class optionClass;
    public boolean fancyGraphics;
    public int ambientOcclusion;
    public int renderDistance;
    public boolean clouds;
    public String skin;
    public int particleSetting;
    public int ofRenderDistanceFine;
    public int ofMipmapLevel;
    public int ofMipmapType;
    public boolean ofLoadFar = false;
    public int ofPreloadedChunks = 0;
    public boolean ofOcclusionFancy;
    public boolean ofSmoothFps = true;
    public boolean ofSmoothWorld = false;
    public boolean ofLazyChunkLoading = false;
    public float ofAoLevel;
    public int ofAaLevel;
    public int ofAfLevel;
    public int ofClouds;
    public int ofTrees;
    public int ofGrass;
    public int ofRain;
    public int ofWater;
    public int ofBetterGrass;
    public boolean ofWeather = true;
    public boolean ofSky = true;
    public boolean ofStars = true;
    public boolean ofSunMoon = true;
    public int ofChunkUpdates;
    public int ofChunkLoading;
    public boolean ofChunkUpdatesDynamic;
    public boolean ofClearWater;
    public boolean ofBetterSnow;
    public boolean ofSwampColors;
    public boolean ofSmoothBiomes;
    public boolean ofFastMath = true;
    public int ofAnimatedWater = 0;
    public int ofAnimatedLava = 0;
    public boolean ofAnimatedSmoke;
    public boolean ofVoidParticles = false;
    public boolean ofWaterParticles;
    public boolean ofRainSplash;
    public boolean stSleeves;
    public boolean stWeaponsOnPlayers;
    public boolean stDymamicLighting;
    public boolean stHighRenderDistance;
    public boolean stBulletHoles;
    public int stParticlesDistance;
    public int stBlocksDistance;
    public int stFiltering;
    public int stWeaponLods;
    public boolean stMapping;
    public boolean bgGrass;
    public int bgGrassSides;
    public int bgMovingGrass;
    public boolean bgLeaves;
    public int bgLeavesRenderer = 0;
    public boolean bgLeavesRoundedTextures;
    public int bgFallingLeavesFX;
    public boolean bgOnlyOuterLeaves = true;
    public boolean bgSeaweed;
    public boolean bgCorals;
    public boolean bgLilyPads;
    public boolean bgCacti;
    public boolean bgNetherrack;
    public boolean bgLadders;
    public int bgFootprints;
    public int bgWaterSuspend;
    public int bgBlood;

    public void applyOptions() {
        GameSettings gameSettings = Minecraft._E()._M;
        gameSettings.fancyGraphics = this.fancyGraphics;
        gameSettings.ambientOcclusion = this.ambientOcclusion;
        gameSettings.renderDistance = this.renderDistance;
        gameSettings.clouds = this.clouds;
        gameSettings.particleSetting = this.particleSetting;
        if (!gameSettings.skin.equals(this.skin)) {
            try {
                pknz pknz2 = Minecraft._E()._T();
                File file = null;
                for (File file2 : pknz2._b()) {
                    if (!file2.getName().equals(this.skin)) continue;
                    file = file2;
                }
                if (file != null) {
                    yehh yehh2 = new yehh(pknz2, file, null);
                    yehh2._a();
                    pknz2._a(yehh2);
                    gameSettings.skin = this.skin;
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        this.applyOptifine();
        this.applyBetterGrass();
        this.applyStalker();
        gameSettings.saveOptions();
        fmib._a(false);
        Minecraft._E()._c();
    }

    public boolean equalsToGameSettings() {
        if (!this.checkMc()) {
            return false;
        }
        if (!this.checkOptifine()) {
            return false;
        }
        if (!this.checkBetterGrass()) {
            return false;
        }
        return this.checkStalker();
    }

    private boolean checkMc() {
        GameSettings gameSettings = Minecraft._E()._M;
        if (gameSettings.fancyGraphics != this.fancyGraphics) {
            return false;
        }
        if (gameSettings.ambientOcclusion != this.ambientOcclusion) {
            return false;
        }
        if (!optifineFound && gameSettings.renderDistance != this.renderDistance) {
            return false;
        }
        if (gameSettings.clouds != this.clouds) {
            return false;
        }
        if (!gameSettings.skin.equals(this.skin)) {
            return false;
        }
        return gameSettings.particleSetting == this.particleSetting;
    }

    private boolean checkOptifine() {
        if (!optifineFound) {
            return true;
        }
        GameSettings gameSettings = Minecraft._E()._M;
        Class<GameSettings> clazz = GameSettings.class;
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                if (!field.getName().startsWith("of")) continue;
                Field field2 = clazz.getDeclaredField(field.getName());
                field2.setAccessible(true);
                if (field2.getType().equals(Integer.TYPE)) {
                    if (field.getInt(this) == field2.getInt(gameSettings)) continue;
                    return false;
                }
                if (field2.getType().equals(Boolean.TYPE)) {
                    if (field.getBoolean(this) == field2.getBoolean(gameSettings)) continue;
                    return false;
                }
                if (field2.getType().equals(Float.TYPE)) {
                    if (field.getFloat(this) == field2.getFloat(gameSettings)) continue;
                    return false;
                }
                Logger.finest("Undefined type " + field2.getType() + " for option " + field2.getName(), new Object[0]);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return true;
    }

    private void applyOptifine() {
        if (!optifineFound) {
            return;
        }
        int n = 0;
        GameSettings gameSettings = Minecraft._E()._M;
        Class<GameSettings> clazz = GameSettings.class;
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                if (!field.getName().startsWith("of")) continue;
                Field field2 = clazz.getDeclaredField(field.getName());
                field2.setAccessible(true);
                if (field2.getType().equals(Integer.TYPE)) {
                    field2.setInt(gameSettings, field.getInt(this));
                } else if (field2.getType().equals(Boolean.TYPE)) {
                    field2.setBoolean(gameSettings, field.getBoolean(this));
                } else if (field2.getType().equals(Float.TYPE)) {
                    field2.setFloat(gameSettings, field.getFloat(this));
                } else {
                    Logger.finest("Undefined type " + field2.getType() + " for option " + field2.getName(), new Object[0]);
                }
                ++n;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        Logger.finest("Found " + n + " OF fields!", new Object[0]);
        try {
            Class<?> clazz2 = Class.forName("TextureUtils");
            Method method = clazz2.getDeclaredMethod("refreshBlockTextures", new Class[0]);
            method.invoke(null, new Object[0]);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private boolean checkBetterGrass() {
        if (!betterGrassFound) {
            return true;
        }
        try {
            if (this.getBooleanBgOption("renderBetterGrass") != this.bgGrass) {
                return false;
            }
            if (this.getIntBgOption("renderGrassSides") != this.bgGrassSides) {
                return false;
            }
            if (this.getIntBgOption("renderGrassFX") != this.bgMovingGrass) {
                return false;
            }
            if (this.getBooleanBgOption("renderBetterLeaves") != this.bgLeaves) {
                return false;
            }
            if (this.getIntBgOption("currentLeavesRenderer") != this.bgLeavesRenderer) {
                return false;
            }
            if (this.getBooleanBgOption("useRoundedVanillaLeaves") != this.bgLeavesRoundedTextures) {
                return false;
            }
            if (this.getIntBgOption("renderLeavesFX") != this.bgFallingLeavesFX) {
                return false;
            }
            if (this.getBooleanBgOption("renderOnlyOuterLeaves") != this.bgOnlyOuterLeaves) {
                return false;
            }
            if (this.getBooleanBgOption("renderBetterSeaweed") != this.bgSeaweed) {
                return false;
            }
            if (this.getBooleanBgOption("renderBetterCorals") != this.bgCorals) {
                return false;
            }
            if (this.getBooleanBgOption("renderBetterLilyPads") != this.bgLilyPads) {
                return false;
            }
            if (this.getBooleanBgOption("renderBetterCacti") != this.bgCacti) {
                return false;
            }
            if (this.getBooleanBgOption("renderBetterNetherrack") != this.bgNetherrack) {
                return false;
            }
            if (this.getBooleanBgOption("renderBetterLadders") != this.bgLadders) {
                return false;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }

    private void applyBetterGrass() {
        if (!betterGrassFound) {
            return;
        }
        try {
            this.setBgOption("renderBetterGrass", this.bgGrass);
            this.setBgOption("renderGrassSides", this.bgGrassSides);
            this.setBgOption("renderGrassFX", this.bgMovingGrass);
            this.setBgOption("renderBetterLeaves", this.bgLeaves);
            this.setBgOption("useRoundedVanillaLeaves", this.bgLeavesRoundedTextures);
            this.setBgOption("currentLeavesRenderer", this.bgLeavesRenderer);
            this.setBgOption("renderBetterSeaweed", this.bgSeaweed);
            this.setBgOption("renderLeavesFX", this.bgFallingLeavesFX);
            this.setBgOption("renderBetterCorals", this.bgCorals);
            this.setBgOption("renderBetterLilyPads", this.bgLilyPads);
            this.setBgOption("renderBetterCacti", this.bgCacti);
            this.setBgOption("renderBetterNetherrack", this.bgNetherrack);
            this.setBgOption("renderBetterLadders", this.bgLadders);
            Field field = bgClass.getDeclaredField("modConfig");
            Object object = field.get(null);
            Method method = object.getClass().getDeclaredMethod("save", new Class[0]);
            method.invoke(object, new Object[0]);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void setBgOption(String string, Object object) {
        try {
            Field field = bgClass.getDeclaredField(string);
            Object object2 = field.get(null);
            Field field2 = optionClass.getField("value");
            field2.set(object2, object);
            Method method = optionClass.getMethod("write", new Class[0]);
            method.invoke(object2, new Object[0]);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private boolean getBooleanBgOption(String string) {
        try {
            Field field = bgClass.getDeclaredField(string);
            Object object = field.get(null);
            Field field2 = optionClass.getField("value");
            return (Boolean)field2.get(object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    private int getIntBgOption(String string) {
        try {
            Field field = bgClass.getDeclaredField(string);
            Object object = field.get(null);
            Field field2 = optionClass.getField("value");
            return (Integer)field2.get(object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return 0;
        }
    }

    private boolean checkStalker() {
        if (!this.checkIntValue("filtering_mode", this.stFiltering)) {
            return false;
        }
        if (!this.checkBooleanValue("mapping", this.stMapping)) {
            return false;
        }
        if (!this.checkBooleanValue("use_flashlight", this.stDymamicLighting)) {
            return false;
        }
        if (!this.checkIntValue("particle_render_distance", this.stParticlesDistance)) {
            return false;
        }
        if (!this.checkIntValue("tiles_render_distance", this.stBlocksDistance)) {
            return false;
        }
        if (Loader.isModLoaded("GloomyWeapons")) {
            if (!this.checkBooleanValue("render_sleeves", this.stSleeves)) {
                return false;
            }
            if (!this.checkBooleanValue("render_equipped_items", this.stWeaponsOnPlayers)) {
                return false;
            }
            if (!this.checkBooleanValue("bullet_holes", this.stBulletHoles)) {
                return false;
            }
            if (!this.checkIntValue("lod_distance", this.stWeaponLods)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBooleanValue(String string, boolean bl) {
        return GloomyCore.mcconfig.get("general", string, bl).getBoolean(bl) == bl;
    }

    private boolean checkIntValue(String string, int n) {
        return GloomyCore.mcconfig.get("general", string, n).getInt() == n;
    }

    private void applyStalker() {
        this.setInt("filtering_mode", this.stFiltering);
        this.setBoolean("mapping", this.stMapping);
        this.setBoolean("use_flashlight", this.stDymamicLighting);
        this.setInt("particle_render_distance", this.stParticlesDistance);
        this.setInt("tiles_render_distance", this.stBlocksDistance);
        if (Loader.isModLoaded("GloomyWeapons")) {
            this.setBoolean("render_sleeves", this.stSleeves);
            this.setBoolean("render_equipped_items", this.stWeaponsOnPlayers);
            this.setBoolean("bullet_holes", this.stBulletHoles);
            this.setInt("lod_distance", this.stWeaponLods);
        }
        GloomyCore.mcconfig.save();
        ClientProxy.loadOptions();
    }

    private void setInt(String string, int n) {
        GloomyCore.mcconfig.get("general", string, n).set(n);
    }

    private void setBoolean(String string, boolean bl) {
        GloomyCore.mcconfig.get("general", string, bl).set(bl);
    }

    static {
        try {
            Class.forName("optifine.Utils");
            Logger.finest("Optifine found!", new Object[0]);
            optifineFound = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            bgClass = Class.forName("poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod");
            optionClass = Class.forName("poersch.minecraft.util.options.Option");
            Logger.finest("BetterGrass found!", new Object[0]);
            betterGrassFound = true;
        }
        catch (Exception exception) {
            // empty catch block
        }
        OptionsSet.optionsSets[0] = new OptionsSet();
        OptionsSet.optionsSets[0].fancyGraphics = false;
        OptionsSet.optionsSets[0].ambientOcclusion = 0;
        OptionsSet.optionsSets[0].renderDistance = 3;
        OptionsSet.optionsSets[0].clouds = false;
        OptionsSet.optionsSets[0].skin = GloomyCore.config._a("graphics_1_texturepack", "Default");
        OptionsSet.optionsSets[0].particleSetting = 2;
        OptionsSet.optionsSets[0].ofRenderDistanceFine = 32;
        OptionsSet.optionsSets[0].ofMipmapLevel = 0;
        OptionsSet.optionsSets[0].ofMipmapType = 0;
        OptionsSet.optionsSets[0].ofOcclusionFancy = false;
        OptionsSet.optionsSets[0].ofAoLevel = 0.0f;
        OptionsSet.optionsSets[0].ofAfLevel = 1;
        OptionsSet.optionsSets[0].ofAaLevel = 0;
        OptionsSet.optionsSets[0].ofClouds = 3;
        OptionsSet.optionsSets[0].ofTrees = 1;
        OptionsSet.optionsSets[0].ofGrass = 1;
        OptionsSet.optionsSets[0].ofRain = 1;
        OptionsSet.optionsSets[0].ofWater = 1;
        OptionsSet.optionsSets[0].ofBetterGrass = 3;
        OptionsSet.optionsSets[0].ofChunkUpdates = 1;
        OptionsSet.optionsSets[0].ofChunkLoading = 0;
        OptionsSet.optionsSets[0].ofChunkUpdatesDynamic = false;
        OptionsSet.optionsSets[0].ofClearWater = false;
        OptionsSet.optionsSets[0].ofBetterSnow = false;
        OptionsSet.optionsSets[0].ofSwampColors = false;
        OptionsSet.optionsSets[0].ofSmoothBiomes = false;
        OptionsSet.optionsSets[0].ofAnimatedWater = 2;
        OptionsSet.optionsSets[0].ofAnimatedLava = 2;
        OptionsSet.optionsSets[0].ofAnimatedSmoke = false;
        OptionsSet.optionsSets[0].ofWaterParticles = false;
        OptionsSet.optionsSets[0].ofRainSplash = false;
        OptionsSet.optionsSets[0].stSleeves = false;
        OptionsSet.optionsSets[0].stWeaponsOnPlayers = false;
        OptionsSet.optionsSets[0].stDymamicLighting = false;
        OptionsSet.optionsSets[0].stHighRenderDistance = false;
        OptionsSet.optionsSets[0].stBulletHoles = false;
        OptionsSet.optionsSets[0].stParticlesDistance = 32;
        OptionsSet.optionsSets[0].stBlocksDistance = 32;
        OptionsSet.optionsSets[0].stFiltering = 0;
        OptionsSet.optionsSets[0].stWeaponLods = 0;
        OptionsSet.optionsSets[0].stMapping = false;
        OptionsSet.optionsSets[0].bgGrass = false;
        OptionsSet.optionsSets[0].bgGrassSides = 0;
        OptionsSet.optionsSets[0].bgMovingGrass = 0;
        OptionsSet.optionsSets[0].bgLeaves = false;
        OptionsSet.optionsSets[0].bgLeavesRoundedTextures = false;
        OptionsSet.optionsSets[0].bgFallingLeavesFX = 0;
        OptionsSet.optionsSets[0].bgSeaweed = false;
        OptionsSet.optionsSets[0].bgCorals = false;
        OptionsSet.optionsSets[0].bgLilyPads = false;
        OptionsSet.optionsSets[0].bgCacti = false;
        OptionsSet.optionsSets[0].bgNetherrack = false;
        OptionsSet.optionsSets[0].bgLadders = false;
        OptionsSet.optionsSets[0].bgFootprints = 0;
        OptionsSet.optionsSets[0].bgWaterSuspend = 0;
        OptionsSet.optionsSets[0].bgBlood = 0;
        OptionsSet.optionsSets[1] = new OptionsSet();
        OptionsSet.optionsSets[1].fancyGraphics = false;
        OptionsSet.optionsSets[1].ambientOcclusion = 0;
        OptionsSet.optionsSets[1].renderDistance = 2;
        OptionsSet.optionsSets[1].clouds = false;
        OptionsSet.optionsSets[1].skin = GloomyCore.config._a("graphics_2_texturepack", "Default");
        OptionsSet.optionsSets[1].particleSetting = 2;
        OptionsSet.optionsSets[1].ofRenderDistanceFine = 64;
        OptionsSet.optionsSets[1].ofMipmapLevel = 0;
        OptionsSet.optionsSets[1].ofMipmapType = 0;
        OptionsSet.optionsSets[1].ofOcclusionFancy = false;
        OptionsSet.optionsSets[1].ofAoLevel = 0.0f;
        OptionsSet.optionsSets[1].ofAaLevel = 0;
        OptionsSet.optionsSets[1].ofAfLevel = 1;
        OptionsSet.optionsSets[1].ofClouds = 3;
        OptionsSet.optionsSets[1].ofTrees = 1;
        OptionsSet.optionsSets[1].ofGrass = 1;
        OptionsSet.optionsSets[1].ofRain = 1;
        OptionsSet.optionsSets[1].ofWater = 1;
        OptionsSet.optionsSets[1].ofBetterGrass = 3;
        OptionsSet.optionsSets[1].ofChunkUpdates = 1;
        OptionsSet.optionsSets[1].ofChunkLoading = 0;
        OptionsSet.optionsSets[1].ofChunkUpdatesDynamic = false;
        OptionsSet.optionsSets[1].ofClearWater = false;
        OptionsSet.optionsSets[1].ofBetterSnow = false;
        OptionsSet.optionsSets[1].ofSwampColors = false;
        OptionsSet.optionsSets[1].ofSmoothBiomes = false;
        OptionsSet.optionsSets[1].ofAnimatedWater = 2;
        OptionsSet.optionsSets[1].ofAnimatedLava = 2;
        OptionsSet.optionsSets[1].ofAnimatedSmoke = false;
        OptionsSet.optionsSets[1].ofWaterParticles = false;
        OptionsSet.optionsSets[1].ofRainSplash = false;
        OptionsSet.optionsSets[1].stSleeves = false;
        OptionsSet.optionsSets[1].stWeaponsOnPlayers = false;
        OptionsSet.optionsSets[1].stDymamicLighting = false;
        OptionsSet.optionsSets[1].stHighRenderDistance = false;
        OptionsSet.optionsSets[1].stBulletHoles = false;
        OptionsSet.optionsSets[1].stParticlesDistance = 32;
        OptionsSet.optionsSets[1].stBlocksDistance = 32;
        OptionsSet.optionsSets[1].stFiltering = 1;
        OptionsSet.optionsSets[1].stWeaponLods = 1;
        OptionsSet.optionsSets[1].stMapping = false;
        OptionsSet.optionsSets[1].bgGrass = false;
        OptionsSet.optionsSets[1].bgGrassSides = 0;
        OptionsSet.optionsSets[1].bgMovingGrass = 0;
        OptionsSet.optionsSets[1].bgLeaves = false;
        OptionsSet.optionsSets[1].bgLeavesRoundedTextures = false;
        OptionsSet.optionsSets[1].bgFallingLeavesFX = 0;
        OptionsSet.optionsSets[1].bgSeaweed = false;
        OptionsSet.optionsSets[1].bgCorals = false;
        OptionsSet.optionsSets[1].bgLilyPads = false;
        OptionsSet.optionsSets[1].bgCacti = false;
        OptionsSet.optionsSets[1].bgNetherrack = false;
        OptionsSet.optionsSets[1].bgLadders = false;
        OptionsSet.optionsSets[1].bgFootprints = 0;
        OptionsSet.optionsSets[1].bgWaterSuspend = 0;
        OptionsSet.optionsSets[1].bgBlood = 0;
        OptionsSet.optionsSets[2] = new OptionsSet();
        OptionsSet.optionsSets[2].fancyGraphics = true;
        OptionsSet.optionsSets[2].ambientOcclusion = 1;
        OptionsSet.optionsSets[2].renderDistance = 2;
        OptionsSet.optionsSets[2].clouds = true;
        OptionsSet.optionsSets[2].skin = GloomyCore.config._a("graphics_3_texturepack", "Default");
        OptionsSet.optionsSets[2].particleSetting = 1;
        OptionsSet.optionsSets[2].ofRenderDistanceFine = 112;
        OptionsSet.optionsSets[2].ofMipmapLevel = 0;
        OptionsSet.optionsSets[2].ofMipmapType = 0;
        OptionsSet.optionsSets[2].ofOcclusionFancy = false;
        OptionsSet.optionsSets[2].ofAoLevel = 0.1f;
        OptionsSet.optionsSets[2].ofAaLevel = 0;
        OptionsSet.optionsSets[2].ofAfLevel = 1;
        OptionsSet.optionsSets[2].ofClouds = 3;
        OptionsSet.optionsSets[2].ofTrees = 1;
        OptionsSet.optionsSets[2].ofGrass = 1;
        OptionsSet.optionsSets[2].ofRain = 1;
        OptionsSet.optionsSets[2].ofWater = 1;
        OptionsSet.optionsSets[2].ofBetterGrass = 3;
        OptionsSet.optionsSets[2].ofChunkUpdates = 1;
        OptionsSet.optionsSets[2].ofChunkLoading = 0;
        OptionsSet.optionsSets[2].ofChunkUpdatesDynamic = false;
        OptionsSet.optionsSets[2].ofClearWater = true;
        OptionsSet.optionsSets[2].ofBetterSnow = true;
        OptionsSet.optionsSets[2].ofSwampColors = true;
        OptionsSet.optionsSets[2].ofSmoothBiomes = true;
        OptionsSet.optionsSets[2].ofAnimatedWater = 0;
        OptionsSet.optionsSets[2].ofAnimatedLava = 0;
        OptionsSet.optionsSets[2].ofAnimatedSmoke = true;
        OptionsSet.optionsSets[2].ofWaterParticles = true;
        OptionsSet.optionsSets[2].ofRainSplash = false;
        OptionsSet.optionsSets[2].stSleeves = false;
        OptionsSet.optionsSets[2].stWeaponsOnPlayers = false;
        OptionsSet.optionsSets[2].stDymamicLighting = true;
        OptionsSet.optionsSets[2].stHighRenderDistance = true;
        OptionsSet.optionsSets[2].stBulletHoles = false;
        OptionsSet.optionsSets[2].stParticlesDistance = 64;
        OptionsSet.optionsSets[2].stBlocksDistance = 64;
        OptionsSet.optionsSets[2].stFiltering = 2;
        OptionsSet.optionsSets[2].stWeaponLods = 1;
        OptionsSet.optionsSets[2].stMapping = false;
        OptionsSet.optionsSets[2].bgGrass = true;
        OptionsSet.optionsSets[2].bgGrassSides = 1;
        OptionsSet.optionsSets[2].bgMovingGrass = 1;
        OptionsSet.optionsSets[2].bgLeaves = true;
        OptionsSet.optionsSets[2].bgLeavesRoundedTextures = true;
        OptionsSet.optionsSets[2].bgFallingLeavesFX = 0;
        OptionsSet.optionsSets[2].bgSeaweed = false;
        OptionsSet.optionsSets[2].bgCorals = false;
        OptionsSet.optionsSets[2].bgLilyPads = false;
        OptionsSet.optionsSets[2].bgCacti = false;
        OptionsSet.optionsSets[2].bgNetherrack = false;
        OptionsSet.optionsSets[2].bgLadders = false;
        OptionsSet.optionsSets[2].bgFootprints = 0;
        OptionsSet.optionsSets[2].bgWaterSuspend = 0;
        OptionsSet.optionsSets[2].bgBlood = 1;
        OptionsSet.optionsSets[3] = new OptionsSet();
        OptionsSet.optionsSets[3].fancyGraphics = true;
        OptionsSet.optionsSets[3].ambientOcclusion = 2;
        OptionsSet.optionsSets[3].renderDistance = 1;
        OptionsSet.optionsSets[3].clouds = true;
        OptionsSet.optionsSets[3].skin = GloomyCore.config._a("graphics_4_texturepack", "Default");
        OptionsSet.optionsSets[3].particleSetting = 2;
        OptionsSet.optionsSets[3].ofRenderDistanceFine = 128;
        OptionsSet.optionsSets[3].ofMipmapLevel = 4;
        OptionsSet.optionsSets[3].ofMipmapType = 1;
        OptionsSet.optionsSets[3].ofOcclusionFancy = true;
        OptionsSet.optionsSets[3].ofAoLevel = 1.0f;
        OptionsSet.optionsSets[3].ofAaLevel = 4;
        OptionsSet.optionsSets[3].ofAfLevel = 4;
        OptionsSet.optionsSets[3].ofClouds = 3;
        OptionsSet.optionsSets[3].ofTrees = 2;
        OptionsSet.optionsSets[3].ofGrass = 2;
        OptionsSet.optionsSets[3].ofRain = 2;
        OptionsSet.optionsSets[3].ofWater = 2;
        OptionsSet.optionsSets[3].ofBetterGrass = 2;
        OptionsSet.optionsSets[3].ofChunkUpdates = 1;
        OptionsSet.optionsSets[3].ofChunkLoading = 0;
        OptionsSet.optionsSets[3].ofChunkUpdatesDynamic = true;
        OptionsSet.optionsSets[3].ofClearWater = true;
        OptionsSet.optionsSets[3].ofBetterSnow = true;
        OptionsSet.optionsSets[3].ofSwampColors = true;
        OptionsSet.optionsSets[3].ofSmoothBiomes = true;
        OptionsSet.optionsSets[3].ofAnimatedWater = 0;
        OptionsSet.optionsSets[3].ofAnimatedLava = 0;
        OptionsSet.optionsSets[3].ofAnimatedSmoke = true;
        OptionsSet.optionsSets[3].ofWaterParticles = true;
        OptionsSet.optionsSets[3].ofRainSplash = false;
        OptionsSet.optionsSets[3].stSleeves = true;
        OptionsSet.optionsSets[3].stWeaponsOnPlayers = true;
        OptionsSet.optionsSets[3].stDymamicLighting = true;
        OptionsSet.optionsSets[3].stHighRenderDistance = true;
        OptionsSet.optionsSets[3].stBulletHoles = true;
        OptionsSet.optionsSets[3].stParticlesDistance = 64;
        OptionsSet.optionsSets[3].stBlocksDistance = 64;
        OptionsSet.optionsSets[3].stFiltering = 3;
        OptionsSet.optionsSets[3].stWeaponLods = 2;
        OptionsSet.optionsSets[3].stMapping = true;
        OptionsSet.optionsSets[3].bgGrass = true;
        OptionsSet.optionsSets[3].bgGrassSides = 2;
        OptionsSet.optionsSets[3].bgMovingGrass = 2;
        OptionsSet.optionsSets[3].bgLeaves = true;
        OptionsSet.optionsSets[3].bgLeavesRoundedTextures = true;
        OptionsSet.optionsSets[3].bgFallingLeavesFX = 2;
        OptionsSet.optionsSets[3].bgSeaweed = true;
        OptionsSet.optionsSets[3].bgCorals = true;
        OptionsSet.optionsSets[3].bgLilyPads = true;
        OptionsSet.optionsSets[3].bgCacti = true;
        OptionsSet.optionsSets[3].bgNetherrack = true;
        OptionsSet.optionsSets[3].bgLadders = true;
        OptionsSet.optionsSets[3].bgFootprints = 2;
        OptionsSet.optionsSets[3].bgWaterSuspend = 2;
        OptionsSet.optionsSets[3].bgBlood = 2;
        OptionsSet.optionsSets[4] = new OptionsSet();
        OptionsSet.optionsSets[4].fancyGraphics = true;
        OptionsSet.optionsSets[4].ambientOcclusion = 2;
        OptionsSet.optionsSets[4].renderDistance = 0;
        OptionsSet.optionsSets[4].clouds = true;
        OptionsSet.optionsSets[4].skin = GloomyCore.config._a("graphics_5_texturepack", "Default");
        OptionsSet.optionsSets[4].particleSetting = 2;
        OptionsSet.optionsSets[4].ofRenderDistanceFine = 128;
        OptionsSet.optionsSets[4].ofMipmapLevel = 4;
        OptionsSet.optionsSets[4].ofMipmapType = 3;
        OptionsSet.optionsSets[4].ofOcclusionFancy = true;
        OptionsSet.optionsSets[4].ofAoLevel = 1.0f;
        OptionsSet.optionsSets[4].ofAaLevel = 8;
        OptionsSet.optionsSets[4].ofAfLevel = 8;
        OptionsSet.optionsSets[4].ofClouds = 3;
        OptionsSet.optionsSets[4].ofTrees = 2;
        OptionsSet.optionsSets[4].ofGrass = 2;
        OptionsSet.optionsSets[4].ofRain = 2;
        OptionsSet.optionsSets[4].ofWater = 2;
        OptionsSet.optionsSets[4].ofBetterGrass = 2;
        OptionsSet.optionsSets[4].ofChunkUpdates = 1;
        OptionsSet.optionsSets[4].ofChunkLoading = 0;
        OptionsSet.optionsSets[4].ofChunkUpdatesDynamic = true;
        OptionsSet.optionsSets[4].ofClearWater = true;
        OptionsSet.optionsSets[4].ofBetterSnow = true;
        OptionsSet.optionsSets[4].ofSwampColors = true;
        OptionsSet.optionsSets[4].ofSmoothBiomes = true;
        OptionsSet.optionsSets[4].ofAnimatedWater = 0;
        OptionsSet.optionsSets[4].ofAnimatedLava = 0;
        OptionsSet.optionsSets[4].ofAnimatedSmoke = true;
        OptionsSet.optionsSets[4].ofWaterParticles = true;
        OptionsSet.optionsSets[4].ofRainSplash = false;
        OptionsSet.optionsSets[4].stSleeves = true;
        OptionsSet.optionsSets[4].stWeaponsOnPlayers = true;
        OptionsSet.optionsSets[4].stDymamicLighting = true;
        OptionsSet.optionsSets[4].stHighRenderDistance = true;
        OptionsSet.optionsSets[4].stBulletHoles = true;
        OptionsSet.optionsSets[4].stParticlesDistance = 96;
        OptionsSet.optionsSets[4].stBlocksDistance = 96;
        OptionsSet.optionsSets[4].stFiltering = 4;
        OptionsSet.optionsSets[4].stWeaponLods = 3;
        OptionsSet.optionsSets[4].stMapping = true;
        OptionsSet.optionsSets[4].bgGrass = true;
        OptionsSet.optionsSets[4].bgGrassSides = 2;
        OptionsSet.optionsSets[4].bgMovingGrass = 2;
        OptionsSet.optionsSets[4].bgLeaves = true;
        OptionsSet.optionsSets[4].bgLeavesRoundedTextures = true;
        OptionsSet.optionsSets[4].bgFallingLeavesFX = 2;
        OptionsSet.optionsSets[4].bgSeaweed = true;
        OptionsSet.optionsSets[4].bgCorals = true;
        OptionsSet.optionsSets[4].bgLilyPads = true;
        OptionsSet.optionsSets[4].bgCacti = true;
        OptionsSet.optionsSets[4].bgNetherrack = true;
        OptionsSet.optionsSets[4].bgLadders = true;
        OptionsSet.optionsSets[4].bgFootprints = 2;
        OptionsSet.optionsSets[4].bgWaterSuspend = 2;
        OptionsSet.optionsSets[4].bgBlood = 2;
    }
}

