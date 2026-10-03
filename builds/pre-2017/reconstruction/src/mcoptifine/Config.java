/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import mcoptifine.TextureUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.EnumOS;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ezhm;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;

public class Config {
    public static final String OF_NAME = "OptiFine";
    public static final String MC_VERSION = "1.6.4";
    public static final String OF_EDITION = "HD_U";
    public static final String OF_RELEASE = "C8";
    public static final String VERSION = "OptiFine_1.6.4_HD_U_C8";
    private static String newRelease = null;
    private static GameSettings gameSettings = null;
    private static Minecraft minecraft = null;
    private static boolean initialized = false;
    private static Thread minecraftThread = null;
    private static DisplayMode desktopDisplayMode = null;
    private static int antialiasingLevel = 0;
    private static int availableProcessors = 0;
    public static boolean zoomMode = false;
    private static int texturePackClouds = 0;
    public static boolean waterOpacityChanged = false;
    private static boolean fullscreenModeChecked = false;
    private static boolean desktopModeChecked = false;
    private static PrintStream systemOut = new PrintStream(new FileOutputStream(FileDescriptor.out));
    public static final Boolean DEF_FOG_FANCY = true;
    public static final Float DEF_FOG_START = Float.valueOf(0.2f);
    public static final Boolean DEF_OPTIMIZE_RENDER_DISTANCE = false;
    public static final Boolean DEF_OCCLUSION_ENABLED = false;
    public static final Integer DEF_MIPMAP_LEVEL = 0;
    public static final Integer DEF_MIPMAP_TYPE = 9984;
    public static final Float DEF_ALPHA_FUNC_LEVEL = Float.valueOf(0.1f);
    public static final Boolean DEF_LOAD_CHUNKS_FAR = false;
    public static final Integer DEF_PRELOADED_CHUNKS = 0;
    public static final Integer DEF_CHUNKS_LIMIT = 25;
    public static final Integer DEF_UPDATES_PER_FRAME = 3;
    public static final Boolean DEF_DYNAMIC_UPDATES = false;

    public static String getVersion() {
        return VERSION;
    }

    public static void initGameSettings(GameSettings gameSettings) {
        Config.gameSettings = gameSettings;
        minecraft = Minecraft._E();
        desktopDisplayMode = Display.getDesktopDisplayMode();
    }

    public static void initDisplay() {
        Config.checkInitialized();
        antialiasingLevel = Config.gameSettings.ofAaLevel;
        Config.checkDisplayMode();
        minecraftThread = Thread.currentThread();
        Config.updateThreadPriorities();
    }

    public static void checkInitialized() {
        if (!initialized && Display.isCreated()) {
            initialized = true;
            Config.checkOpenGlCaps();
        }
    }

    private static void checkOpenGlCaps() {
        Config.log("");
        Config.log(Config.getVersion());
        Config.log("" + new Date());
        Config.log("OS: " + System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version"));
        Config.log("Java: " + System.getProperty("java.version") + ", " + System.getProperty("java.vendor"));
        Config.log("VM: " + System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor"));
        Config.log("LWJGL: " + Sys.getVersion());
        Config.log("OpenGL: " + GL11.glGetString(7937) + " version " + GL11.glGetString(7938) + ", " + GL11.glGetString(7936));
        int n = Config.getOpenGlVersion();
        String string = "" + n / 10 + "." + n % 10;
        Config.log("OpenGL Version: " + string);
        if (!GLContext.getCapabilities().OpenGL12) {
            Config.log("OpenGL Mipmap levels: Not available (GL12.GL_TEXTURE_MAX_LEVEL)");
        }
        if (!GLContext.getCapabilities().GL_NV_fog_distance) {
            Config.log("OpenGL Fancy fog: Not available (GL_NV_fog_distance)");
        }
        if (!GLContext.getCapabilities().GL_ARB_occlusion_query) {
            Config.log("OpenGL Occlussion culling: Not available (GL_ARB_occlusion_query)");
        }
        int n2 = Minecraft._F();
        Config.dbg("Maximum texture size: " + n2 + "x" + n2);
    }

    public static boolean isFancyFogAvailable() {
        return GLContext.getCapabilities().GL_NV_fog_distance;
    }

    public static boolean isOcclusionAvailable() {
        return GLContext.getCapabilities().GL_ARB_occlusion_query;
    }

    private static int getOpenGlVersion() {
        return !GLContext.getCapabilities().OpenGL11 ? 10 : (!GLContext.getCapabilities().OpenGL12 ? 11 : (!GLContext.getCapabilities().OpenGL13 ? 12 : (!GLContext.getCapabilities().OpenGL14 ? 13 : (!GLContext.getCapabilities().OpenGL15 ? 14 : (!GLContext.getCapabilities().OpenGL20 ? 15 : (!GLContext.getCapabilities().OpenGL21 ? 20 : (!GLContext.getCapabilities().OpenGL30 ? 21 : (!GLContext.getCapabilities().OpenGL31 ? 30 : (!GLContext.getCapabilities().OpenGL32 ? 31 : (!GLContext.getCapabilities().OpenGL33 ? 32 : (!GLContext.getCapabilities().OpenGL40 ? 33 : 40)))))))))));
    }

    public static void updateThreadPriorities() {
        try {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            if (threadGroup == null) {
                return;
            }
            int n = (threadGroup.activeCount() + 10) * 2;
            Thread[] threadArray = new Thread[n];
            threadGroup.enumerate(threadArray, false);
            int n2 = 5;
            int n3 = 5;
            if (Config.isSmoothWorld()) {
                n3 = 3;
            }
            minecraftThread.setPriority(n2);
            for (int i = 0; i < threadArray.length; ++i) {
                Thread thread = threadArray[i];
                if (thread == null || !(thread instanceof vmwi)) continue;
                thread.setPriority(n3);
            }
        }
        catch (Throwable throwable) {
            Config.dbg(throwable.getClass().getName() + ": " + throwable.getMessage());
        }
    }

    public static boolean isMinecraftThread() {
        return Thread.currentThread() == minecraftThread;
    }

    public static boolean isUseMipmaps() {
        int n = Config.getMipmapLevel();
        return n > 0;
    }

    public static int getMipmapLevel() {
        return gameSettings == null ? DEF_MIPMAP_LEVEL : Config.gameSettings.ofMipmapLevel;
    }

    public static int getMipmapType() {
        if (gameSettings == null) {
            return DEF_MIPMAP_TYPE;
        }
        switch (Config.gameSettings.ofMipmapType) {
            case 0: {
                return 9984;
            }
            case 1: {
                return 9986;
            }
            case 2: {
                return 9985;
            }
            case 3: {
                return 9987;
            }
        }
        return 9984;
    }

    public static boolean isUseAlphaFunc() {
        float f = Config.getAlphaFuncLevel();
        return f > DEF_ALPHA_FUNC_LEVEL.floatValue() + 1.0E-5f;
    }

    public static float getAlphaFuncLevel() {
        return DEF_ALPHA_FUNC_LEVEL.floatValue();
    }

    public static boolean isFogFancy() {
        return !Config.isFancyFogAvailable() ? false : (gameSettings == null ? false : Config.gameSettings.ofFogType == 2);
    }

    public static boolean isFogFast() {
        return gameSettings == null ? false : Config.gameSettings.ofFogType == 1;
    }

    public static boolean isFogOff() {
        return gameSettings == null ? false : Config.gameSettings.ofFogType == 3;
    }

    public static float getFogStart() {
        return gameSettings == null ? DEF_FOG_START.floatValue() : Config.gameSettings.ofFogStart;
    }

    public static boolean isOcclusionEnabled() {
        return gameSettings == null ? DEF_OCCLUSION_ENABLED : Config.gameSettings.advancedOpengl;
    }

    public static boolean isOcclusionFancy() {
        return !Config.isOcclusionEnabled() ? false : (gameSettings == null ? false : Config.gameSettings.ofOcclusionFancy);
    }

    public static boolean isLoadChunksFar() {
        return gameSettings == null ? DEF_LOAD_CHUNKS_FAR : Config.gameSettings.ofLoadFar;
    }

    public static int getPreloadedChunks() {
        return gameSettings == null ? DEF_PRELOADED_CHUNKS : Config.gameSettings.ofPreloadedChunks;
    }

    public static void dbg(String string) {
        systemOut.print("[OptiFine] ");
        systemOut.println(string);
    }

    public static void warn(String string) {
        systemOut.print("[OptiFine] [WARN] ");
        systemOut.println(string);
    }

    public static void error(String string) {
        systemOut.print("[OptiFine] [ERROR] ");
        systemOut.println(string);
    }

    public static void log(String string) {
        Config.dbg(string);
    }

    public static int getUpdatesPerFrame() {
        return gameSettings != null ? Config.gameSettings.ofChunkUpdates : 1;
    }

    public static boolean isDynamicUpdates() {
        return gameSettings != null ? Config.gameSettings.ofChunkUpdatesDynamic : true;
    }

    public static boolean isRainFancy() {
        return Config.gameSettings.ofRain == 0 ? Config.gameSettings.fancyGraphics : Config.gameSettings.ofRain == 2;
    }

    public static boolean isWaterFancy() {
        return Config.gameSettings.ofWater == 0 ? Config.gameSettings.fancyGraphics : Config.gameSettings.ofWater == 2;
    }

    public static boolean isRainOff() {
        return Config.gameSettings.ofRain == 3;
    }

    public static boolean isCloudsFancy() {
        return Config.gameSettings.ofClouds != 0 ? Config.gameSettings.ofClouds == 2 : (texturePackClouds != 0 ? texturePackClouds == 2 : Config.gameSettings.fancyGraphics);
    }

    public static boolean isCloudsOff() {
        return Config.gameSettings.ofClouds == 3;
    }

    public static void updateTexturePackClouds() {
        texturePackClouds = 0;
        ResourceManager resourceManager = Config.getResourceManager();
        if (resourceManager != null) {
            try {
                InputStream inputStream = resourceManager._a(new ResourceLocation("color.properties"))._a();
                if (inputStream == null) {
                    return;
                }
                Properties properties = new Properties();
                properties.load(inputStream);
                inputStream.close();
                String string = properties.getProperty("clouds");
                if (string == null) {
                    return;
                }
                Config.dbg("Texture pack clouds: " + string);
                string = string.toLowerCase();
                if (string.equals("fast")) {
                    texturePackClouds = 1;
                }
                if (string.equals("fancy")) {
                    texturePackClouds = 2;
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static boolean isTreesFancy() {
        return Config.gameSettings.ofTrees == 0 ? Config.gameSettings.fancyGraphics : Config.gameSettings.ofTrees == 2;
    }

    public static boolean isGrassFancy() {
        return Config.gameSettings.ofGrass == 0 ? Config.gameSettings.fancyGraphics : Config.gameSettings.ofGrass == 2;
    }

    public static boolean isDroppedItemsFancy() {
        return Config.gameSettings.ofDroppedItems == 0 ? Config.gameSettings.fancyGraphics : Config.gameSettings.ofDroppedItems == 2;
    }

    public static int limit(int n, int n2, int n3) {
        return n < n2 ? n2 : (n > n3 ? n3 : n);
    }

    public static float limit(float f, float f2, float f3) {
        return f < f2 ? f2 : (f > f3 ? f3 : f);
    }

    public static float limitTo1(float f) {
        return f < 0.0f ? 0.0f : (f > 1.0f ? 1.0f : f);
    }

    public static boolean isAnimatedWater() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedWater != 2 : true;
    }

    public static boolean isGeneratedWater() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedWater == 1 : true;
    }

    public static boolean isAnimatedPortal() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedPortal : true;
    }

    public static boolean isAnimatedLava() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedLava != 2 : true;
    }

    public static boolean isGeneratedLava() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedLava == 1 : true;
    }

    public static boolean isAnimatedFire() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedFire : true;
    }

    public static boolean isAnimatedRedstone() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedRedstone : true;
    }

    public static boolean isAnimatedExplosion() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedExplosion : true;
    }

    public static boolean isAnimatedFlame() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedFlame : true;
    }

    public static boolean isAnimatedSmoke() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedSmoke : true;
    }

    public static boolean isVoidParticles() {
        return gameSettings != null ? Config.gameSettings.ofVoidParticles : true;
    }

    public static boolean isWaterParticles() {
        return gameSettings != null ? Config.gameSettings.ofWaterParticles : true;
    }

    public static boolean isRainSplash() {
        return gameSettings != null ? Config.gameSettings.ofRainSplash : true;
    }

    public static boolean isPortalParticles() {
        return gameSettings != null ? Config.gameSettings.ofPortalParticles : true;
    }

    public static boolean isPotionParticles() {
        return gameSettings != null ? Config.gameSettings.ofPotionParticles : true;
    }

    public static boolean isDepthFog() {
        return gameSettings != null ? Config.gameSettings.ofDepthFog : true;
    }

    public static float getAmbientOcclusionLevel() {
        return gameSettings != null ? Config.gameSettings.ofAoLevel : 0.0f;
    }

    private static Method getMethod(Class clazz, String string, Object[] objectArray) {
        Method[] methodArray = clazz.getMethods();
        for (int i = 0; i < methodArray.length; ++i) {
            Method method = methodArray[i];
            if (!method.getName().equals(string) || method.getParameterTypes().length != objectArray.length) continue;
            return method;
        }
        Config.warn("No method found for: " + clazz.getName() + "." + string + "(" + Config.arrayToString(objectArray) + ")");
        return null;
    }

    public static String arrayToString(Object[] objectArray) {
        if (objectArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(objectArray.length * 5);
        for (int i = 0; i < objectArray.length; ++i) {
            Object object = objectArray[i];
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(String.valueOf(object));
        }
        return stringBuffer.toString();
    }

    public static String arrayToString(int[] nArray) {
        if (nArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(nArray.length * 5);
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(String.valueOf(n));
        }
        return stringBuffer.toString();
    }

    public static Minecraft getMinecraft() {
        return minecraft;
    }

    public static TextureManager getTextureManager() {
        return minecraft._R();
    }

    public static ResourceManager getResourceManager() {
        return minecraft._S();
    }

    public static htyg getResource(ResourceLocation resourceLocation) throws IOException {
        return minecraft._S()._a(resourceLocation);
    }

    public static InputStream getResourceStream(ResourceLocation resourceLocation) throws IOException {
        return Config.getResourceStream(minecraft._S(), resourceLocation);
    }

    public static InputStream getResourceStream(ResourceManager resourceManager, ResourceLocation resourceLocation) throws IOException {
        htyg htyg2 = resourceManager._a(resourceLocation);
        return htyg2 == null ? null : htyg2._a();
    }

    public static htyg getResource(ResourceLocation resourceLocation, boolean bl) throws IOException {
        return !bl && !Config.getResourcePack().resourceExists(resourceLocation) ? null : minecraft._S()._a(resourceLocation);
    }

    public static boolean hasResource(ResourceLocation resourceLocation) {
        return Config.hasResource(resourceLocation, true);
    }

    public static boolean hasResource(ResourceLocation resourceLocation, boolean bl) {
        try {
            htyg htyg2 = Config.getResource(resourceLocation, bl);
            return htyg2 != null;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public static boolean hasResource(ResourceManager resourceManager, ResourceLocation resourceLocation) {
        try {
            htyg htyg2 = resourceManager._a(resourceLocation);
            return htyg2 != null;
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public static fnrl getResourcePack() {
        pknz pknz2 = minecraft._T();
        List list2 = pknz2._e();
        if (list2 != null && list2.size() > 0) {
            yehh yehh2 = (yehh)list2.get(0);
            if (yehh2 == null) {
                return pknz2._c;
            }
            fnrl fnrl2 = yehh2._c();
            return fnrl2;
        }
        return pknz2._c;
    }

    public static fnrl getDefaultResourcePack() {
        return Config.minecraft._T()._c;
    }

    public static cvgz getRenderGlobal() {
        return minecraft == null ? null : Config.minecraft._s;
    }

    public static int getMaxDynamicTileWidth() {
        return 64;
    }

    public static Icon getSideGrassTexture(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4, Icon icon) {
        if (!Config.isBetterGrass()) {
            return icon;
        }
        Icon icon2 = TextureUtils.iconGrassTop;
        if (icon == TextureUtils.iconMyceliumSide) {
            icon2 = TextureUtils.iconMyceliumTop;
        }
        return icon2;
    }

    public static Icon getSideSnowGrassTexture(IBlockAccess iBlockAccess, int n, int n2, int n3, int n4) {
        if (!Config.isBetterGrass()) {
            return TextureUtils.iconGrassSideSnowed;
        }
        if (Config.isBetterGrassFancy()) {
            switch (n4) {
                case 2: {
                    --n3;
                    break;
                }
                case 3: {
                    ++n3;
                    break;
                }
                case 4: {
                    --n;
                    break;
                }
                case 5: {
                    ++n;
                }
            }
            int n5 = iBlockAccess.getBlockId(n, n2, n3);
            if (n5 != 78 && n5 != 80) {
                return TextureUtils.iconGrassSideSnowed;
            }
        }
        return TextureUtils.iconSnow;
    }

    public static boolean isBetterGrass() {
        return gameSettings == null ? false : Config.gameSettings.ofBetterGrass != 3;
    }

    public static boolean isBetterGrassFancy() {
        return gameSettings == null ? false : Config.gameSettings.ofBetterGrass == 2;
    }

    public static boolean isWeatherEnabled() {
        return gameSettings == null ? true : Config.gameSettings.ofWeather;
    }

    public static boolean isSkyEnabled() {
        return gameSettings == null ? true : Config.gameSettings.ofSky;
    }

    public static boolean isSunMoonEnabled() {
        return gameSettings == null ? true : Config.gameSettings.ofSunMoon;
    }

    public static boolean isStarsEnabled() {
        return gameSettings == null ? true : Config.gameSettings.ofStars;
    }

    public static void sleep(long l) {
        try {
            Thread.currentThread();
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public static boolean isTimeDayOnly() {
        return gameSettings == null ? false : Config.gameSettings.ofTime == 1;
    }

    public static boolean isTimeDefault() {
        return gameSettings == null ? false : Config.gameSettings.ofTime == 0 || Config.gameSettings.ofTime == 2;
    }

    public static boolean isTimeNightOnly() {
        return gameSettings == null ? false : Config.gameSettings.ofTime == 3;
    }

    public static boolean isClearWater() {
        return gameSettings == null ? false : Config.gameSettings.ofClearWater;
    }

    public static int getAnisotropicFilterLevel() {
        return gameSettings == null ? 1 : Config.gameSettings.ofAfLevel;
    }

    public static int getAntialiasingLevel() {
        return antialiasingLevel;
    }

    public static boolean between(int n, int n2, int n3) {
        return n >= n2 && n <= n3;
    }

    public static boolean isMultiTexture() {
        return Config.getAnisotropicFilterLevel() > 1 ? true : Config.getAntialiasingLevel() > 0;
    }

    public static boolean isDrippingWaterLava() {
        return gameSettings == null ? false : Config.gameSettings.ofDrippingWaterLava;
    }

    public static boolean isBetterSnow() {
        return gameSettings == null ? false : Config.gameSettings.ofBetterSnow;
    }

    public static Dimension getFullscreenDimension() {
        if (desktopDisplayMode == null) {
            return null;
        }
        if (gameSettings == null) {
            return new Dimension(desktopDisplayMode.getWidth(), desktopDisplayMode.getHeight());
        }
        String string = Config.gameSettings.ofFullscreenMode;
        if (string.equals("Default")) {
            return new Dimension(desktopDisplayMode.getWidth(), desktopDisplayMode.getHeight());
        }
        String[] stringArray = Config.tokenize(string, " x");
        return stringArray.length < 2 ? new Dimension(desktopDisplayMode.getWidth(), desktopDisplayMode.getHeight()) : new Dimension(Config.parseInt(stringArray[0], -1), Config.parseInt(stringArray[1], -1));
    }

    public static int parseInt(String string, int n) {
        try {
            return string == null ? n : Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public static float parseFloat(String string, float f) {
        try {
            return string == null ? f : Float.parseFloat(string);
        }
        catch (NumberFormatException numberFormatException) {
            return f;
        }
    }

    public static String[] tokenize(String string, String string2) {
        String[] stringArray;
        StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        while (stringTokenizer.hasMoreTokens()) {
            stringArray = stringTokenizer.nextToken();
            arrayList.add(stringArray);
        }
        stringArray = arrayList.toArray(new String[arrayList.size()]);
        return stringArray;
    }

    public static DisplayMode getDesktopDisplayMode() {
        return desktopDisplayMode;
    }

    public static DisplayMode[] getFullscreenDisplayModes() {
        try {
            Object object;
            DisplayMode[] displayModeArray = Display.getAvailableDisplayModes();
            ArrayList<DisplayMode> arrayList = new ArrayList<DisplayMode>();
            for (int i = 0; i < displayModeArray.length; ++i) {
                object = displayModeArray[i];
                if (desktopDisplayMode != null && (((DisplayMode)object).getBitsPerPixel() != desktopDisplayMode.getBitsPerPixel() || ((DisplayMode)object).getFrequency() != desktopDisplayMode.getFrequency())) continue;
                arrayList.add((DisplayMode)object);
            }
            DisplayMode[] displayModeArray2 = arrayList.toArray(new DisplayMode[arrayList.size()]);
            object = new Comparator(){

                public int compare(Object object, Object object2) {
                    DisplayMode displayMode = (DisplayMode)object;
                    DisplayMode displayMode2 = (DisplayMode)object2;
                    return displayMode.getWidth() != displayMode2.getWidth() ? displayMode2.getWidth() - displayMode.getWidth() : (displayMode.getHeight() != displayMode2.getHeight() ? displayMode2.getHeight() - displayMode.getHeight() : 0);
                }
            };
            Arrays.sort(displayModeArray2, object);
            return displayModeArray2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return new DisplayMode[]{desktopDisplayMode};
        }
    }

    public static String[] getFullscreenModes() {
        DisplayMode[] displayModeArray = Config.getFullscreenDisplayModes();
        String[] stringArray = new String[displayModeArray.length];
        for (int i = 0; i < displayModeArray.length; ++i) {
            String string;
            DisplayMode displayMode = displayModeArray[i];
            stringArray[i] = string = "" + displayMode.getWidth() + "x" + displayMode.getHeight();
        }
        return stringArray;
    }

    public static DisplayMode getDisplayMode(Dimension dimension) throws LWJGLException {
        DisplayMode[] displayModeArray = Display.getAvailableDisplayModes();
        for (int i = 0; i < displayModeArray.length; ++i) {
            DisplayMode displayMode = displayModeArray[i];
            if (displayMode.getWidth() != dimension.width || displayMode.getHeight() != dimension.height || desktopDisplayMode != null && (displayMode.getBitsPerPixel() != desktopDisplayMode.getBitsPerPixel() || displayMode.getFrequency() != desktopDisplayMode.getFrequency())) continue;
            return displayMode;
        }
        return desktopDisplayMode;
    }

    public static boolean isAnimatedTerrain() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedTerrain : true;
    }

    public static boolean isAnimatedItems() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedItems : true;
    }

    public static boolean isAnimatedTextures() {
        return gameSettings != null ? Config.gameSettings.ofAnimatedTextures : true;
    }

    public static boolean isSwampColors() {
        return gameSettings != null ? Config.gameSettings.ofSwampColors : true;
    }

    public static boolean isRandomMobs() {
        return gameSettings != null ? Config.gameSettings.ofRandomMobs : true;
    }

    public static void checkGlError(String string) {
        int n = GL11.glGetError();
        if (n != 0) {
            String string2 = GLU.gluErrorString(n);
            Config.dbg("OpenGlError: " + n + " (" + string2 + "), at: " + string);
        }
    }

    public static boolean isSmoothBiomes() {
        return gameSettings != null ? Config.gameSettings.ofSmoothBiomes : true;
    }

    public static boolean isCustomColors() {
        return gameSettings != null ? Config.gameSettings.ofCustomColors : true;
    }

    public static boolean isCustomSky() {
        return gameSettings != null ? Config.gameSettings.ofCustomSky : true;
    }

    public static boolean isCustomFonts() {
        return gameSettings != null ? Config.gameSettings.ofCustomFonts : true;
    }

    public static boolean isShowCapes() {
        return gameSettings != null ? Config.gameSettings.ofShowCapes : true;
    }

    public static boolean isConnectedTextures() {
        return gameSettings != null ? Config.gameSettings.ofConnectedTextures != 3 : false;
    }

    public static boolean isNaturalTextures() {
        return gameSettings != null ? Config.gameSettings.ofNaturalTextures : false;
    }

    public static boolean isConnectedTexturesFancy() {
        return gameSettings != null ? Config.gameSettings.ofConnectedTextures == 2 : false;
    }

    public static String[] readLines(File file) throws IOException {
        ArrayList<String> arrayList = new ArrayList<String>();
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream)fileInputStream, "ASCII");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String string;
            if ((string = bufferedReader.readLine()) == null) {
                String[] stringArray = arrayList.toArray(new String[arrayList.size()]);
                return stringArray;
            }
            arrayList.add(string);
        }
    }

    public static String readFile(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        return Config.readInputStream(fileInputStream, "ASCII");
    }

    public static String readInputStream(InputStream inputStream) throws IOException {
        return Config.readInputStream(inputStream, "ASCII");
    }

    public static String readInputStream(InputStream inputStream, String string) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, string);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuffer stringBuffer = new StringBuffer();
        String string2;
        while ((string2 = bufferedReader.readLine()) != null) {
            stringBuffer.append(string2);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public static GameSettings getGameSettings() {
        return gameSettings;
    }

    public static String getNewRelease() {
        return newRelease;
    }

    public static void setNewRelease(String string) {
    }

    public static int compareRelease(String string, String string2) {
        int n;
        String[] stringArray;
        String string3;
        String[] stringArray2 = Config.splitRelease(string);
        String string4 = stringArray2[0];
        if (!string4.equals(string3 = (stringArray = Config.splitRelease(string2))[0])) {
            return string4.compareTo(string3);
        }
        int n2 = Config.parseInt(stringArray2[1], -1);
        if (n2 != (n = Config.parseInt(stringArray[1], -1))) {
            return n2 - n;
        }
        String string5 = stringArray2[2];
        String string6 = stringArray[2];
        return string5.compareTo(string6);
    }

    private static String[] splitRelease(String string) {
        if (string != null && string.length() > 0) {
            int n;
            String string2 = string.substring(0, 1);
            if (string.length() <= 1) {
                return new String[]{string2, "", ""};
            }
            for (n = 1; n < string.length() && Character.isDigit(string.charAt(n)); ++n) {
            }
            String string3 = string.substring(1, n);
            if (n >= string.length()) {
                return new String[]{string2, string3, ""};
            }
            String string4 = string.substring(n);
            return new String[]{string2, string3, string4};
        }
        return new String[]{"", "", ""};
    }

    public static int intHash(int n) {
        n = n ^ 0x3D ^ n >> 16;
        n += n << 3;
        n ^= n >> 4;
        n *= 668265261;
        n ^= n >> 15;
        return n;
    }

    public static int getRandom(int n, int n2, int n3, int n4) {
        int n5 = Config.intHash(n4 + 37);
        n5 = Config.intHash(n5 + n);
        n5 = Config.intHash(n5 + n3);
        n5 = Config.intHash(n5 + n2);
        return n5;
    }

    public static WorldServer getWorldServer() {
        if (minecraft == null) {
            return null;
        }
        pkix pkix2 = Config.minecraft._r;
        if (pkix2 == null) {
            return null;
        }
        yfci yfci2 = minecraft._J();
        if (yfci2 == null) {
            return null;
        }
        WorldProvider worldProvider = pkix2.provider;
        if (worldProvider == null) {
            return null;
        }
        int n = worldProvider._i;
        WorldServer worldServer = yfci2._a(n);
        return worldServer;
    }

    public static int getAvailableProcessors() {
        if (availableProcessors < 1) {
            availableProcessors = Runtime.getRuntime().availableProcessors();
        }
        return availableProcessors;
    }

    public static boolean isSingleProcessor() {
        return Config.getAvailableProcessors() <= 1;
    }

    public static boolean isSmoothWorld() {
        return Config.getAvailableProcessors() > 1 ? false : (gameSettings == null ? true : Config.gameSettings.ofSmoothWorld);
    }

    public static boolean isLazyChunkLoading() {
        return Config.getAvailableProcessors() > 1 ? false : (gameSettings == null ? true : Config.gameSettings.ofLazyChunkLoading);
    }

    public static int getChunkViewDistance() {
        if (gameSettings == null) {
            return 10;
        }
        int n = Config.gameSettings.ofRenderDistanceFine / 16;
        return n <= 16 ? 10 : n;
    }

    public static boolean equals(Object object, Object object2) {
        return object == object2 ? true : (object == null ? false : object.equals(object2));
    }

    public static void checkDisplaySettings() {
        if (Config.getAntialiasingLevel() > 0) {
            int n = Config.getAntialiasingLevel();
            DisplayMode displayMode = Display.getDisplayMode();
            Config.dbg("FSAA Samples: " + n);
            try {
                Display.destroy();
                Display.setDisplayMode(displayMode);
                Display.create(new PixelFormat().withDepthBits(24).withSamples(n));
            }
            catch (LWJGLException lWJGLException) {
                Config.warn("Error setting FSAA: " + n + "x");
                lWJGLException.printStackTrace();
                try {
                    Display.setDisplayMode(displayMode);
                    Display.create(new PixelFormat().withDepthBits(24));
                }
                catch (LWJGLException lWJGLException2) {
                    lWJGLException2.printStackTrace();
                    try {
                        Display.setDisplayMode(displayMode);
                        Display.create();
                    }
                    catch (LWJGLException lWJGLException3) {
                        lWJGLException3.printStackTrace();
                    }
                }
            }
            if (ezhm._a() != EnumOS._d) {
                try {
                    File file = new File(Config.minecraft._P, "assets");
                    ByteBuffer byteBuffer = Config.readIconImage(new File(file, "/icons/icon_16x16.png"));
                    ByteBuffer byteBuffer2 = Config.readIconImage(new File(file, "/icons/icon_32x32.png"));
                    ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer, byteBuffer2};
                    Display.setIcon(byteBufferArray);
                }
                catch (IOException iOException) {
                    Config.dbg(iOException.getClass().getName() + ": " + iOException.getMessage());
                }
            }
        }
    }

    private static ByteBuffer readIconImage(File file) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(file);
        int[] nArray = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());
        ByteBuffer byteBuffer = ByteBuffer.allocate(4 * nArray.length);
        int[] nArray2 = nArray;
        int n = nArray.length;
        for (int i = 0; i < n; ++i) {
            int n2 = nArray2[i];
            byteBuffer.putInt(n2 << 8 | n2 >> 24 & 0xFF);
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    public static void checkDisplayMode() {
        try {
            if (minecraft._N()) {
                if (fullscreenModeChecked) {
                    return;
                }
                fullscreenModeChecked = true;
                desktopModeChecked = false;
                DisplayMode displayMode = Display.getDisplayMode();
                Dimension dimension = Config.getFullscreenDimension();
                if (dimension == null) {
                    return;
                }
                if (displayMode.getWidth() == dimension.width && displayMode.getHeight() == dimension.height) {
                    return;
                }
                DisplayMode displayMode2 = Config.getDisplayMode(dimension);
                if (displayMode2 == null) {
                    return;
                }
                Display.setDisplayModeAndFullscreen(displayMode2);
                Config.minecraft._n = Display.getDisplayMode().getWidth();
                Config.minecraft._o = Display.getDisplayMode().getHeight();
                if (Config.minecraft._n <= 0) {
                    Config.minecraft._n = 1;
                }
                if (Config.minecraft._o <= 0) {
                    Config.minecraft._o = 1;
                }
                if (Config.minecraft._B != null) {
                    htou htou2 = new htou(Config.minecraft._M, Config.minecraft._n, Config.minecraft._o);
                    int n = htou2._a();
                    int n2 = htou2._b();
                    Config.minecraft._B.setWorldAndResolution(minecraft, n, n2);
                }
                Config.minecraft._M.updateVSync();
                Display.update();
                GL11.glEnable(3553);
            } else {
                if (desktopModeChecked) {
                    return;
                }
                desktopModeChecked = true;
                fullscreenModeChecked = false;
                Config.minecraft._M.updateVSync();
                Display.update();
                GL11.glEnable(3553);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

