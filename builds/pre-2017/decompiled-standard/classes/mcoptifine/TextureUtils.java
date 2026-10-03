/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.Set;
import mcoptifine.Config;
import mcoptifine.CustomColorizer;
import mcoptifine.CustomSky;
import mcoptifine.Mipmaps;
import mcoptifine.NaturalTextures;
import mcoptifine.RandomMobs;
import mcoptifine.TextureAnimations;
import mcoptifine.WrUpdates;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class TextureUtils {
    public static final String texGrassTop = "grass_top";
    public static final String texStone = "stone";
    public static final String texDirt = "dirt";
    public static final String texGrassSide = "grass_side";
    public static final String texStoneslabSide = "stone_slab_side";
    public static final String texStoneslabTop = "stone_slab_top";
    public static final String texBedrock = "bedrock";
    public static final String texSand = "sand";
    public static final String texGravel = "gravel";
    public static final String texLogOak = "log_oak";
    public static final String texLogOakTop = "log_oak_top";
    public static final String texGoldOre = "gold_ore";
    public static final String texIronOre = "iron_ore";
    public static final String texCoalOre = "coal_ore";
    public static final String texObsidian = "obsidian";
    public static final String texGrassSideOverlay = "grass_side_overlay";
    public static final String texSnow = "snow";
    public static final String texGrassSideSnowed = "grass_side_snowed";
    public static final String texMyceliumSide = "mycelium_side";
    public static final String texMyceliumTop = "mycelium_top";
    public static final String texDiamondOre = "diamond_ore";
    public static final String texRedstoneOre = "redstone_ore";
    public static final String texLapisOre = "lapis_ore";
    public static final String texLeavesOak = "leaves_oak";
    public static final String texLeavesOakOpaque = "leaves_oak_opaque";
    public static final String texLeavesJungle = "leaves_jungle";
    public static final String texLeavesJungleOpaque = "leaves_jungle_opaque";
    public static final String texCactusSide = "cactus_side";
    public static final String texClay = "clay";
    public static final String texFarmlandWet = "farmland_wet";
    public static final String texFarmlandDry = "farmland_dry";
    public static final String texNetherrack = "netherrack";
    public static final String texSoulSand = "soul_sand";
    public static final String texGlowstone = "glowstone";
    public static final String texLogSpruce = "log_spruce";
    public static final String texLogBirch = "log_birch";
    public static final String texLeavesSpruce = "leaves_spruce";
    public static final String texLeavesSpruceOpaque = "leaves_spruce_opaque";
    public static final String texLogJungle = "log_jungle";
    public static final String texEndStone = "end_stone";
    public static final String texSandstoneTop = "sandstone_top";
    public static final String texSandstoneBottom = "sandstone_bottom";
    public static final String texRedstoneLampOff = "redstone_lamp_off";
    public static final String texRedstoneLampOn = "redstone_lamp_on";
    public static final String texWaterStill = "water_still";
    public static final String texWaterFlow = "water_flow";
    public static final String texLavaStill = "lava_still";
    public static final String texLavaFlow = "lava_flow";
    public static final String texFireLayer0 = "fire_layer_0";
    public static final String texFireLayer1 = "fire_layer_1";
    public static final String texPortal = "portal";
    public static dwan iconGrassTop;
    public static dwan iconGrassSide;
    public static dwan iconGrassSideOverlay;
    public static dwan iconSnow;
    public static dwan iconGrassSideSnowed;
    public static dwan iconMyceliumSide;
    public static dwan iconMyceliumTop;
    public static dwan iconWaterStill;
    public static dwan iconWaterFlow;
    public static dwan iconLavaStill;
    public static dwan iconLavaFlow;
    public static dwan iconPortal;
    public static dwan iconFireLayer0;
    public static dwan iconFireLayer1;
    private static IntBuffer staticBuffer;

    private static Set makeAtlasNames() {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("/terrain.png");
        hashSet.add("/gui/items.png");
        hashSet.add("/ctm.png");
        hashSet.add("/eloraam/world/world1.png");
        hashSet.add("/gfx/buildcraft/blocks/blocks.png");
        return hashSet;
    }

    public static void update() {
        sctd sctd2 = sctd._f;
        if (sctd2 != null) {
            iconGrassTop = sctd2._f(texGrassTop);
            iconGrassSide = sctd2._f(texGrassSide);
            iconGrassSideOverlay = sctd2._f(texGrassSideOverlay);
            iconSnow = sctd2._f(texSnow);
            iconGrassSideSnowed = sctd2._f(texGrassSideSnowed);
            iconMyceliumSide = sctd2._f(texMyceliumSide);
            iconMyceliumTop = sctd2._f(texMyceliumTop);
            iconWaterStill = sctd2._f(texWaterStill);
            iconWaterFlow = sctd2._f(texWaterFlow);
            iconLavaStill = sctd2._f(texLavaStill);
            iconLavaFlow = sctd2._f(texLavaFlow);
            iconFireLayer0 = sctd2._f(texFireLayer0);
            iconFireLayer1 = sctd2._f(texFireLayer1);
            iconPortal = sctd2._f(texPortal);
        }
    }

    public static BufferedImage fixTextureDimensions(String string, BufferedImage bufferedImage) {
        int n;
        int n2;
        if ((string.startsWith("/mob/zombie") || string.startsWith("/mob/pigzombie")) && (n2 = bufferedImage.getWidth()) == (n = bufferedImage.getHeight()) * 2) {
            BufferedImage bufferedImage2 = new BufferedImage(n2, n * 2, 2);
            Graphics2D graphics2D = bufferedImage2.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            graphics2D.drawImage(bufferedImage, 0, 0, n2, n, null);
            return bufferedImage2;
        }
        return bufferedImage;
    }

    public static dhji getTextureAtlasSprite(dwan dwan2) {
        return dwan2 instanceof dhji ? (dhji)dwan2 : null;
    }

    public static int ceilPowerOfTwo(int n) {
        int n2;
        for (n2 = 1; n2 < n; n2 *= 2) {
        }
        return n2;
    }

    public static int getPowerOfTwo(int n) {
        int n2 = 1;
        int n3 = 0;
        while (n2 < n) {
            n2 *= 2;
            ++n3;
        }
        return n3;
    }

    public static int twoToPower(int n) {
        int n2 = 1;
        for (int i = 0; i < n; ++i) {
            n2 *= 2;
        }
        return n2;
    }

    public static void refreshBlockTextures() {
        Config.dbg("*** Reloading block textures ***");
        WrUpdates.finishCurrentUpdate();
        sctd._f._b(Config.getResourceManager());
        TextureUtils.update();
        NaturalTextures.update();
        sctd._f._i();
    }

    public static sctg getTexture(String string) {
        return TextureUtils.getTexture(new ResourceLocation(string));
    }

    public static sctg getTexture(ResourceLocation resourceLocation) {
        sctg sctg2 = Config.getTextureManager()._b(resourceLocation);
        if (sctg2 != null) {
            return sctg2;
        }
        if (!Config.hasResource(resourceLocation)) {
            return null;
        }
        cegk cegk2 = new cegk(resourceLocation);
        Config.getTextureManager()._a(resourceLocation, cegk2);
        return cegk2;
    }

    public static void resourcesReloaded(xsfs xsfs2) {
        if (sctd._f != null) {
            Config.dbg("*** Reloading custom textures ***");
            CustomSky.reset();
            TextureAnimations.reset();
            WrUpdates.finishCurrentUpdate();
            TextureUtils.update();
            NaturalTextures.update();
            TextureAnimations.update();
            CustomColorizer.update();
            CustomSky.update();
            RandomMobs.resetTextures();
            Config.updateTexturePackClouds();
            Config.getTextureManager().func_110550_d();
        }
    }

    public static void refreshTextureMaps(xsfs xsfs2) {
        sctd._f._b(xsfs2);
        sctd._g._b(xsfs2);
        TextureUtils.update();
        NaturalTextures.update();
    }

    public static void registerResourceListener() {
        Object object;
        Object object2;
        xsfs xsfs2 = Config.getResourceManager();
        if (xsfs2 instanceof ifzx) {
            object2 = (ifzx)xsfs2;
            object = new cvkw(){

                @Override
                public void func_110549_a(xsfs xsfs2) {
                    TextureUtils.resourcesReloaded(xsfs2);
                }
            };
            object2._a((cvkw)object);
        }
        object2 = new cegw(){

            @Override
            public void func_110550_d() {
                TextureAnimations.updateCustomAnimations();
            }

            @Override
            public void func_110551_a(xsfs xsfs2) throws IOException {
            }

            @Override
            public int func_110552_b() {
                return 0;
            }
        };
        object = new ResourceLocation("optifine/TickableTextures");
        Config.getTextureManager()._a((ResourceLocation)object, (cegw)object2);
    }

    public static String fixResourcePath(String string, String string2) {
        String string3 = "assets/minecraft/";
        if (string.startsWith(string3)) {
            string = string.substring(string3.length());
            return string;
        }
        if (string.startsWith("./")) {
            string = string.substring(2);
            if (!string2.endsWith("/")) {
                string2 = string2 + "/";
            }
            string = string2 + string;
            return string;
        }
        String string4 = "mcpatcher/";
        if (string.startsWith("~/")) {
            string = string.substring(2);
            string = string4 + string;
            return string;
        }
        if (string.startsWith("/")) {
            string = string4 + string.substring(1);
            return string;
        }
        return string;
    }

    public static String getBasePath(String string) {
        int n = string.lastIndexOf(47);
        return n < 0 ? "" : string.substring(0, n);
    }

    public static void setupTexture(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4;
        int n3 = 9728;
        int n4 = 9728;
        boolean bl5 = bl4 = bl && Config.isUseMipmaps();
        if (bl4) {
            n3 = Config.getMipmapType();
        }
        if (bl3) {
            n4 = 9729;
        }
        GL11.glTexParameteri(3553, 10241, n3);
        GL11.glTexParameteri(3553, 10240, n4);
        int n5 = 33071;
        GL11.glTexParameteri(3553, 10242, n5);
        GL11.glTexParameteri(3553, 10243, n5);
        if (bl4) {
            TextureUtils.updateMaxMipmapLevel(n, n2);
            if (bl2) {
                Mipmaps.allocateMipmapTextures(n, n2, "");
            }
        }
        TextureUtils.updateAnisotropicLevel();
    }

    public static void updateMaxMipmapLevel(int n, int n2) {
        if (Config.getMipmapLevel() > 0 && GLContext.getCapabilities().OpenGL12) {
            GL11.glTexParameteri(3553, 33084, 0);
            int n3 = Config.getMipmapLevel();
            if (n3 >= 4) {
                n3 = 4;
            }
            GL11.glTexParameteri(3553, 33085, n3 - 1);
        }
    }

    public static void updateAnisotropicLevel() {
        if (GLContext.getCapabilities().GL_EXT_texture_filter_anisotropic) {
            float f = GL11.glGetInteger(34047);
            int n = Config.getAnisotropicFilterLevel();
            n = (int)Math.min((float)n, f);
            GL11.glTexParameteri(3553, 34046, n);
        }
    }

    private static int getMaxMipmapLevel(int n) {
        int n2 = 0;
        while (n > 0) {
            n /= 2;
            ++n2;
        }
        return n2 - 1;
    }

    public static IntBuffer getStaticBuffer(int n, int n2) {
        int n3 = n * n2;
        if (staticBuffer == null || staticBuffer.capacity() < n3) {
            n3 = TextureUtils.ceilPowerOfTwo(n3);
            staticBuffer = pklh._d(n3);
        }
        return staticBuffer;
    }

    public static IntBuffer getStaticBufferNpot(int n, int n2) {
        int n3 = n * n2;
        if (staticBuffer == null || staticBuffer.capacity() < n3) {
            staticBuffer = pklh._d(n3);
        }
        return staticBuffer;
    }

    static {
        staticBuffer = pklh._d(256);
    }
}

