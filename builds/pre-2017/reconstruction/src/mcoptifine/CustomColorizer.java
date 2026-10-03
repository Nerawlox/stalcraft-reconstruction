/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import javax.imageio.ImageIO;
import mcoptifine.Config;
import mcoptifine.TextureUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class CustomColorizer {
    private static int[] grassColors = null;
    private static int[] waterColors = null;
    private static int[] foliageColors = null;
    private static int[] foliagePineColors = null;
    private static int[] foliageBirchColors = null;
    private static int[] swampFoliageColors = null;
    private static int[] swampGrassColors = null;
    private static int[][] blockPalettes = null;
    private static int[][] paletteColors = null;
    private static int[] skyColors = null;
    private static int[] fogColors = null;
    private static int[] underwaterColors = null;
    private static float[][][] lightMapsColorsRgb = null;
    private static int[] lightMapsHeight = null;
    private static float[][] sunRgbs = new float[16][3];
    private static float[][] torchRgbs = new float[16][3];
    private static int[] redstoneColors = null;
    private static int[] stemColors = null;
    private static int[] myceliumParticleColors = null;
    private static boolean useDefaultColorMultiplier = true;
    private static int particleWaterColor = -1;
    private static int particlePortalColor = -1;
    private static int lilyPadColor = -1;
    private static Vec3 fogColorNether = null;
    private static Vec3 fogColorEnd = null;
    private static Vec3 skyColorEnd = null;
    private static final int TYPE_NONE = 0;
    private static final int TYPE_GRASS = 1;
    private static final int TYPE_FOLIAGE = 2;
    private static Random random = new Random();

    public static void update() {
        grassColors = null;
        waterColors = null;
        foliageColors = null;
        foliageBirchColors = null;
        foliagePineColors = null;
        swampGrassColors = null;
        swampFoliageColors = null;
        skyColors = null;
        fogColors = null;
        underwaterColors = null;
        redstoneColors = null;
        stemColors = null;
        myceliumParticleColors = null;
        lightMapsColorsRgb = null;
        lightMapsHeight = null;
        lilyPadColor = -1;
        particleWaterColor = -1;
        particlePortalColor = -1;
        fogColorNether = null;
        fogColorEnd = null;
        skyColorEnd = null;
        blockPalettes = null;
        paletteColors = null;
        useDefaultColorMultiplier = true;
        String string = "mcpatcher/colormap/";
        grassColors = CustomColorizer.getCustomColors("textures/colormap/grass.png", 65536);
        foliageColors = CustomColorizer.getCustomColors("textures/colormap/foliage.png", 65536);
        String[] stringArray = new String[]{"water.png", "watercolorX.png"};
        waterColors = CustomColorizer.getCustomColors(string, stringArray, 65536);
        if (Config.isCustomColors()) {
            String[] stringArray2 = new String[]{"pine.png", "pinecolor.png"};
            foliagePineColors = CustomColorizer.getCustomColors(string, stringArray2, 65536);
            String[] stringArray3 = new String[]{"birch.png", "birchcolor.png"};
            foliageBirchColors = CustomColorizer.getCustomColors(string, stringArray3, 65536);
            String[] stringArray4 = new String[]{"swampgrass.png", "swampgrasscolor.png"};
            swampGrassColors = CustomColorizer.getCustomColors(string, stringArray4, 65536);
            String[] stringArray5 = new String[]{"swampfoliage.png", "swampfoliagecolor.png"};
            swampFoliageColors = CustomColorizer.getCustomColors(string, stringArray5, 65536);
            String[] stringArray6 = new String[]{"sky0.png", "skycolor0.png"};
            skyColors = CustomColorizer.getCustomColors(string, stringArray6, 65536);
            String[] stringArray7 = new String[]{"fog0.png", "fogcolor0.png"};
            fogColors = CustomColorizer.getCustomColors(string, stringArray7, 65536);
            String[] stringArray8 = new String[]{"underwater.png", "underwatercolor.png"};
            underwaterColors = CustomColorizer.getCustomColors(string, stringArray8, 65536);
            String[] stringArray9 = new String[]{"redstone.png", "redstonecolor.png"};
            redstoneColors = CustomColorizer.getCustomColors(string, stringArray9, 16);
            String[] stringArray10 = new String[]{"stem.png", "stemcolor.png"};
            stemColors = CustomColorizer.getCustomColors(string, stringArray10, 8);
            String[] stringArray11 = new String[]{"myceliumparticle.png", "myceliumparticlecolor.png"};
            myceliumParticleColors = CustomColorizer.getCustomColors(string, stringArray11, -1);
            int[][] nArrayArray = new int[3][];
            lightMapsColorsRgb = new float[3][][];
            lightMapsHeight = new int[3];
            for (int i = 0; i < nArrayArray.length; ++i) {
                String string2 = "mcpatcher/lightmap/world" + (i - 1) + ".png";
                nArrayArray[i] = CustomColorizer.getCustomColors(string2, -1);
                if (nArrayArray[i] != null) {
                    CustomColorizer.lightMapsColorsRgb[i] = CustomColorizer.toRgb(nArrayArray[i]);
                }
                CustomColorizer.lightMapsHeight[i] = CustomColorizer.getTextureHeight(string2, 32);
            }
            CustomColorizer.readColorProperties("mcpatcher/color.properties");
            CustomColorizer.updateUseDefaultColorMultiplier();
        }
    }

    private static int getTextureHeight(String string, int n) {
        try {
            InputStream inputStream = Config.getResourceStream(new ResourceLocation(string));
            if (inputStream == null) {
                return n;
            }
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            return bufferedImage == null ? n : bufferedImage.getHeight();
        }
        catch (IOException iOException) {
            return n;
        }
    }

    private static float[][] toRgb(int[] nArray) {
        float[][] fArray = new float[nArray.length][3];
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            float f = (float)(n >> 16 & 0xFF) / 255.0f;
            float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
            float f3 = (float)(n & 0xFF) / 255.0f;
            float[] fArray2 = fArray[i];
            fArray2[0] = f;
            fArray2[1] = f2;
            fArray2[2] = f3;
        }
        return fArray;
    }

    private static void readColorProperties(String string) {
        try {
            ResourceLocation resourceLocation = new ResourceLocation(string);
            InputStream inputStream = Config.getResourceStream(resourceLocation);
            if (inputStream == null) {
                return;
            }
            Config.log("Loading " + string);
            Properties properties = new Properties();
            properties.load(inputStream);
            lilyPadColor = CustomColorizer.readColor(properties, "lilypad");
            particleWaterColor = CustomColorizer.readColor(properties, new String[]{"particle.water", "drop.water"});
            particlePortalColor = CustomColorizer.readColor(properties, "particle.portal");
            fogColorNether = CustomColorizer.readColorVec3(properties, "fog.nether");
            fogColorEnd = CustomColorizer.readColorVec3(properties, "fog.end");
            skyColorEnd = CustomColorizer.readColorVec3(properties, "sky.end");
            CustomColorizer.readCustomPalettes(properties, string);
        }
        catch (FileNotFoundException fileNotFoundException) {
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private static void readCustomPalettes(Properties properties, String string) {
        String string2;
        blockPalettes = new int[256][1];
        for (int i = 0; i < 256; ++i) {
            CustomColorizer.blockPalettes[i][0] = -1;
        }
        String string3 = "palette.block.";
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Set<Object> set = properties.keySet();
        for (String stringArray2 : set) {
            string2 = properties.getProperty(stringArray2);
            if (!stringArray2.startsWith(string3)) continue;
            hashMap.put(stringArray2, string2);
        }
        String[] stringArray = hashMap.keySet().toArray(new String[hashMap.size()]);
        paletteColors = new int[stringArray.length][];
        for (int i = 0; i < stringArray.length; ++i) {
            string2 = stringArray[i];
            String string4 = properties.getProperty(string2);
            Config.log("Block palette: " + string2 + " = " + string4);
            String string5 = string2.substring(string3.length());
            String string6 = TextureUtils.getBasePath(string);
            string5 = TextureUtils.fixResourcePath(string5, string6);
            int[] nArray = CustomColorizer.getCustomColors(string5, 65536);
            CustomColorizer.paletteColors[i] = nArray;
            String[] stringArray2 = Config.tokenize(string4, " ,;");
            for (int j = 0; j < stringArray2.length; ++j) {
                int n;
                String string7 = stringArray2[j];
                int n2 = -1;
                if (string7.contains(":")) {
                    String[] n3 = Config.tokenize(string7, ":");
                    string7 = n3[0];
                    String string8 = n3[1];
                    n2 = Config.parseInt(string8, -1);
                    if (n2 < 0 || n2 > 15) {
                        Config.log("Invalid block metadata: " + string7 + " in palette: " + string2);
                        continue;
                    }
                }
                if ((n = Config.parseInt(string7, -1)) >= 0 && n <= 255) {
                    if (n == Block.grass.blockID || n == Block.tallGrass.blockID || n == Block.leaves.blockID || n == Block.vine.blockID) continue;
                    if (n2 == -1) {
                        CustomColorizer.blockPalettes[n][0] = i;
                        continue;
                    }
                    if (blockPalettes[n].length < 16) {
                        CustomColorizer.blockPalettes[n] = new int[16];
                        Arrays.fill(blockPalettes[n], -1);
                    }
                    CustomColorizer.blockPalettes[n][n2] = i;
                    continue;
                }
                Config.log("Invalid block index: " + n + " in palette: " + string2);
            }
        }
    }

    private static int readColor(Properties properties, String[] stringArray) {
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            int n = CustomColorizer.readColor(properties, string);
            if (n < 0) continue;
            return n;
        }
        return -1;
    }

    private static int readColor(Properties properties, String string) {
        String string2 = properties.getProperty(string);
        if (string2 == null) {
            return -1;
        }
        try {
            int n = Integer.parseInt(string2, 16) & 0xFFFFFF;
            Config.log("Custom color: " + string + " = " + string2);
            return n;
        }
        catch (NumberFormatException numberFormatException) {
            Config.log("Invalid custom color: " + string + " = " + string2);
            return -1;
        }
    }

    private static Vec3 readColorVec3(Properties properties, String string) {
        int n = CustomColorizer.readColor(properties, string);
        if (n < 0) {
            return null;
        }
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        float f = (float)n2 / 255.0f;
        float f2 = (float)n3 / 255.0f;
        float f3 = (float)n4 / 255.0f;
        return Vec3._a(f, f2, f3);
    }

    private static int[] getCustomColors(String string, String[] stringArray, int n) {
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            string2 = string + string2;
            int[] nArray = CustomColorizer.getCustomColors(string2, n);
            if (nArray == null) continue;
            return nArray;
        }
        return null;
    }

    private static int[] getCustomColors(String string, int n) {
        try {
            ResourceLocation resourceLocation = new ResourceLocation(string);
            InputStream inputStream = Config.getResourceStream(resourceLocation);
            if (inputStream == null) {
                return null;
            }
            int[] nArray = bsfn._a(Config.getResourceManager(), resourceLocation);
            if (nArray == null) {
                return null;
            }
            if (n > 0 && nArray.length != n) {
                Config.log("Invalid custom colors length: " + nArray.length + ", path: " + string);
                return null;
            }
            Config.log("Loading custom colors: " + string);
            return nArray;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public static void updateUseDefaultColorMultiplier() {
        useDefaultColorMultiplier = foliageBirchColors == null && foliagePineColors == null && swampGrassColors == null && swampFoliageColors == null && blockPalettes == null && Config.isSwampColors() && Config.isSmoothBiomes();
    }

    public static int getColorMultiplier(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        if (useDefaultColorMultiplier) {
            return block.colorMultiplier(iBlockAccess, n, n2, n3);
        }
        int[] nArray = null;
        int[] nArray2 = null;
        if (blockPalettes != null) {
            n6 = block.blockID;
            if (n6 >= 0 && n6 < 256) {
                int n7;
                int[] nArray3 = blockPalettes[n6];
                n5 = 1;
                if (nArray3.length > 1) {
                    n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
                    n7 = nArray3[n4];
                } else {
                    n7 = nArray3[0];
                }
                if (n7 >= 0) {
                    nArray = paletteColors[n7];
                }
            }
            if (nArray != null) {
                if (Config.isSmoothBiomes()) {
                    return CustomColorizer.getSmoothColorMultiplier(block, iBlockAccess, n, n2, n3, nArray, nArray, 0, 0);
                }
                return CustomColorizer.getCustomColor(nArray, iBlockAccess, n, n2, n3);
            }
        }
        n6 = Config.isSwampColors();
        boolean bl = false;
        n5 = 0;
        n4 = 0;
        if (block != Block.grass && block != Block.tallGrass) {
            if (block == Block.leaves) {
                n5 = 2;
                bl = Config.isSmoothBiomes();
                n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
                if ((n4 & 3) == 1) {
                    nArray = foliagePineColors;
                } else if ((n4 & 3) == 2) {
                    nArray = foliageBirchColors;
                } else {
                    nArray = foliageColors;
                    nArray2 = n6 != 0 ? swampFoliageColors : nArray;
                }
            } else if (block == Block.vine) {
                n5 = 2;
                bl = Config.isSmoothBiomes();
                nArray = foliageColors;
                nArray2 = n6 != 0 ? swampFoliageColors : nArray;
            }
        } else {
            n5 = 1;
            bl = Config.isSmoothBiomes();
            nArray = grassColors;
            nArray2 = n6 != 0 ? swampGrassColors : nArray;
        }
        if (bl) {
            return CustomColorizer.getSmoothColorMultiplier(block, iBlockAccess, n, n2, n3, nArray, nArray2, n5, n4);
        }
        if (nArray2 != nArray && iBlockAccess.getBiomeGenForCoords(n, n3) == BiomeGenBase._h) {
            nArray = nArray2;
        }
        return nArray != null ? CustomColorizer.getCustomColor(nArray, iBlockAccess, n, n2, n3) : block.colorMultiplier(iBlockAccess, n, n2, n3);
    }

    private static int getSmoothColorMultiplier(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, int[] nArray, int[] nArray2, int n4, int n5) {
        int n6;
        int n7;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        for (n7 = n - 1; n7 <= n + 1; ++n7) {
            for (n6 = n3 - 1; n6 <= n3 + 1; ++n6) {
                int n11;
                int[] nArray3 = nArray;
                if (nArray2 != nArray && iBlockAccess.getBiomeGenForCoords(n7, n6) == BiomeGenBase._h) {
                    nArray3 = nArray2;
                }
                boolean bl = false;
                if (nArray3 == null) {
                    switch (n4) {
                        case 1: {
                            n11 = iBlockAccess.getBiomeGenForCoords(n7, n6)._l();
                            break;
                        }
                        case 2: {
                            if ((n5 & 3) == 1) {
                                n11 = igvq._a();
                                break;
                            }
                            if ((n5 & 3) == 2) {
                                n11 = igvq._b();
                                break;
                            }
                            n11 = iBlockAccess.getBiomeGenForCoords(n7, n6)._m();
                            break;
                        }
                        default: {
                            n11 = block.colorMultiplier(iBlockAccess, n7, n2, n6);
                            break;
                        }
                    }
                } else {
                    n11 = CustomColorizer.getCustomColor(nArray3, iBlockAccess, n7, n2, n6);
                }
                n8 += n11 >> 16 & 0xFF;
                n9 += n11 >> 8 & 0xFF;
                n10 += n11 & 0xFF;
            }
        }
        n7 = n8 / 9;
        n6 = n9 / 9;
        int n12 = n10 / 9;
        return n7 << 16 | n6 << 8 | n12;
    }

    public static int getFluidColor(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3) {
        return block.blockMaterial != Material._h ? block.colorMultiplier(iBlockAccess, n, n2, n3) : (waterColors != null ? (Config.isSmoothBiomes() ? CustomColorizer.getSmoothColor(waterColors, iBlockAccess, n, n2, n3, 3, 1) : CustomColorizer.getCustomColor(waterColors, iBlockAccess, n, n2, n3)) : (!Config.isSwampColors() ? 0xFFFFFF : block.colorMultiplier(iBlockAccess, n, n2, n3)));
    }

    private static int getCustomColor(int[] nArray, IBlockAccess iBlockAccess, int n, int n2, int n3) {
        BiomeGenBase biomeGenBase = iBlockAccess.getBiomeGenForCoords(n, n3);
        double d = sajh._a(biomeGenBase._k(), 0.0f, 1.0f);
        double d2 = sajh._a(biomeGenBase._j(), 0.0f, 1.0f);
        int n4 = (int)((1.0 - d) * 255.0);
        int n5 = (int)((1.0 - (d2 *= d)) * 255.0);
        return nArray[n5 << 8 | n4] & 0xFFFFFF;
    }

    public static void updatePortalFX(EntityFX entityFX) {
        if (particlePortalColor >= 0) {
            int n = particlePortalColor;
            int n2 = n >> 16 & 0xFF;
            int n3 = n >> 8 & 0xFF;
            int n4 = n & 0xFF;
            float f = (float)n2 / 255.0f;
            float f2 = (float)n3 / 255.0f;
            float f3 = (float)n4 / 255.0f;
            entityFX.particleRed = f;
            entityFX.particleGreen = f2;
            entityFX.particleBlue = f3;
        }
    }

    public static void updateMyceliumFX(EntityFX entityFX) {
        if (myceliumParticleColors != null) {
            int n = myceliumParticleColors[random.nextInt(myceliumParticleColors.length)];
            int n2 = n >> 16 & 0xFF;
            int n3 = n >> 8 & 0xFF;
            int n4 = n & 0xFF;
            float f = (float)n2 / 255.0f;
            float f2 = (float)n3 / 255.0f;
            float f3 = (float)n4 / 255.0f;
            entityFX.particleRed = f;
            entityFX.particleGreen = f2;
            entityFX.particleBlue = f3;
        }
    }

    public static void updateReddustFX(EntityFX entityFX, IBlockAccess iBlockAccess, double d, double d2, double d3) {
        int n;
        int n2;
        if (redstoneColors != null && (n2 = CustomColorizer.getRedstoneColor(n = iBlockAccess.getBlockMetadata((int)d, (int)d2, (int)d3))) != -1) {
            int n3 = n2 >> 16 & 0xFF;
            int n4 = n2 >> 8 & 0xFF;
            int n5 = n2 & 0xFF;
            float f = (float)n3 / 255.0f;
            float f2 = (float)n4 / 255.0f;
            float f3 = (float)n5 / 255.0f;
            entityFX.particleRed = f;
            entityFX.particleGreen = f2;
            entityFX.particleBlue = f3;
        }
    }

    public static int getRedstoneColor(int n) {
        return redstoneColors == null ? -1 : (n >= 0 && n <= 15 ? redstoneColors[n] & 0xFFFFFF : -1);
    }

    public static void updateWaterFX(EntityFX entityFX, IBlockAccess iBlockAccess) {
        if (waterColors != null) {
            int n = (int)entityFX.posX;
            int n2 = (int)entityFX.posY;
            int n3 = (int)entityFX.posZ;
            int n4 = CustomColorizer.getFluidColor(Block.waterStill, iBlockAccess, n, n2, n3);
            int n5 = n4 >> 16 & 0xFF;
            int n6 = n4 >> 8 & 0xFF;
            int n7 = n4 & 0xFF;
            float f = (float)n5 / 255.0f;
            float f2 = (float)n6 / 255.0f;
            float f3 = (float)n7 / 255.0f;
            if (particleWaterColor >= 0) {
                int n8 = particleWaterColor >> 16 & 0xFF;
                int n9 = particleWaterColor >> 8 & 0xFF;
                int n10 = particleWaterColor & 0xFF;
                f *= (float)n8 / 255.0f;
                f2 *= (float)n9 / 255.0f;
                f3 *= (float)n10 / 255.0f;
            }
            entityFX.particleRed = f;
            entityFX.particleGreen = f2;
            entityFX.particleBlue = f3;
        }
    }

    public static int getLilypadColor() {
        return lilyPadColor < 0 ? Block.waterlily.getBlockColor() : lilyPadColor;
    }

    public static Vec3 getFogColorNether(Vec3 vec3) {
        return fogColorNether == null ? vec3 : fogColorNether;
    }

    public static Vec3 getFogColorEnd(Vec3 vec3) {
        return fogColorEnd == null ? vec3 : fogColorEnd;
    }

    public static Vec3 getSkyColorEnd(Vec3 vec3) {
        return skyColorEnd == null ? vec3 : skyColorEnd;
    }

    public static Vec3 getSkyColor(Vec3 vec3, IBlockAccess iBlockAccess, double d, double d2, double d3) {
        if (skyColors == null) {
            return vec3;
        }
        int n = CustomColorizer.getSmoothColor(skyColors, iBlockAccess, d, d2, d3, 10, 1);
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        float f = (float)n2 / 255.0f;
        float f2 = (float)n3 / 255.0f;
        float f3 = (float)n4 / 255.0f;
        float f4 = (float)vec3._c / 0.5f;
        float f5 = (float)vec3._d / 0.66275f;
        float f6 = (float)vec3._e;
        return Vec3._a(f *= f4, f2 *= f5, f3 *= f6);
    }

    public static Vec3 getFogColor(Vec3 vec3, IBlockAccess iBlockAccess, double d, double d2, double d3) {
        if (fogColors == null) {
            return vec3;
        }
        int n = CustomColorizer.getSmoothColor(fogColors, iBlockAccess, d, d2, d3, 10, 1);
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        float f = (float)n2 / 255.0f;
        float f2 = (float)n3 / 255.0f;
        float f3 = (float)n4 / 255.0f;
        float f4 = (float)vec3._c / 0.753f;
        float f5 = (float)vec3._d / 0.8471f;
        float f6 = (float)vec3._e;
        return Vec3._a(f *= f4, f2 *= f5, f3 *= f6);
    }

    public static Vec3 getUnderwaterColor(IBlockAccess iBlockAccess, double d, double d2, double d3) {
        if (underwaterColors == null) {
            return null;
        }
        int n = CustomColorizer.getSmoothColor(underwaterColors, iBlockAccess, d, d2, d3, 10, 1);
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        float f = (float)n2 / 255.0f;
        float f2 = (float)n3 / 255.0f;
        float f3 = (float)n4 / 255.0f;
        return Vec3._a(f, f2, f3);
    }

    public static int getSmoothColor(int[] nArray, IBlockAccess iBlockAccess, double d, double d2, double d3, int n, int n2) {
        int n3;
        int n4;
        int n5;
        if (nArray == null) {
            return -1;
        }
        int n6 = (int)Math.floor(d);
        int n7 = (int)Math.floor(d2);
        int n8 = (int)Math.floor(d3);
        int n9 = n * n2 / 2;
        int n10 = 0;
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        for (n5 = n6 - n9; n5 <= n6 + n9; n5 += n2) {
            for (n4 = n8 - n9; n4 <= n8 + n9; n4 += n2) {
                n3 = CustomColorizer.getCustomColor(nArray, iBlockAccess, n5, n7, n4);
                n10 += n3 >> 16 & 0xFF;
                n11 += n3 >> 8 & 0xFF;
                n12 += n3 & 0xFF;
                ++n13;
            }
        }
        n5 = n10 / n13;
        n4 = n11 / n13;
        n3 = n12 / n13;
        return n5 << 16 | n4 << 8 | n3;
    }

    public static int mixColors(int n, int n2, float f) {
        if (f <= 0.0f) {
            return n2;
        }
        if (f >= 1.0f) {
            return n;
        }
        float f2 = 1.0f - f;
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        int n6 = n2 >> 16 & 0xFF;
        int n7 = n2 >> 8 & 0xFF;
        int n8 = n2 & 0xFF;
        int n9 = (int)((float)n3 * f + (float)n6 * f2);
        int n10 = (int)((float)n4 * f + (float)n7 * f2);
        int n11 = (int)((float)n5 * f + (float)n8 * f2);
        return n9 << 16 | n10 << 8 | n11;
    }

    private static int averageColor(int n, int n2) {
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        int n6 = n2 >> 16 & 0xFF;
        int n7 = n2 >> 8 & 0xFF;
        int n8 = n2 & 0xFF;
        int n9 = (n3 + n6) / 2;
        int n10 = (n4 + n7) / 2;
        int n11 = (n5 + n8) / 2;
        return n9 << 16 | n10 << 8 | n11;
    }

    public static int getStemColorMultiplier(xati xati2, IBlockAccess iBlockAccess, int n, int n2, int n3) {
        if (stemColors == null) {
            return xati2.colorMultiplier(iBlockAccess, n, n2, n3);
        }
        int n4 = iBlockAccess.getBlockMetadata(n, n2, n3);
        if (n4 < 0) {
            n4 = 0;
        }
        if (n4 >= stemColors.length) {
            n4 = stemColors.length - 1;
        }
        return stemColors[n4];
    }

    public static boolean updateLightmap(World world, float f, int[] nArray, boolean bl) {
        if (world == null) {
            return false;
        }
        if (lightMapsColorsRgb == null) {
            return false;
        }
        if (!Config.isCustomColors()) {
            return false;
        }
        int n = world.provider._i;
        if (n >= -1 && n <= 1) {
            int n2 = n + 1;
            float[][] fArray = lightMapsColorsRgb[n2];
            if (fArray == null) {
                return false;
            }
            int n3 = lightMapsHeight[n2];
            if (bl && n3 < 64) {
                return false;
            }
            int n4 = fArray.length / n3;
            if (n4 < 16) {
                Config.warn("Invalid lightmap width: " + n4 + " for: /environment/lightmap" + n + ".png");
                CustomColorizer.lightMapsColorsRgb[n2] = null;
                return false;
            }
            int n5 = 0;
            if (bl) {
                n5 = n4 * 16 * 2;
            }
            float f2 = 1.1666666f * (world.getSunBrightness(1.0f) - 0.2f);
            if (world.lastLightningBolt > 0) {
                f2 = 1.0f;
            }
            f2 = Config.limitTo1(f2);
            float f3 = f2 * (float)(n4 - 1);
            float f4 = Config.limitTo1(f + 0.5f) * (float)(n4 - 1);
            float f5 = Config.limitTo1(Config.getGameSettings().gammaSetting);
            boolean bl2 = f5 > 1.0E-4f;
            CustomColorizer.getLightMapColumn(fArray, f3, n5, n4, sunRgbs);
            CustomColorizer.getLightMapColumn(fArray, f4, n5 + 16 * n4, n4, torchRgbs);
            float[] fArray2 = new float[3];
            for (int i = 0; i < 16; ++i) {
                for (int j = 0; j < 16; ++j) {
                    int n6;
                    for (n6 = 0; n6 < 3; ++n6) {
                        float f6 = Config.limitTo1(sunRgbs[i][n6] + torchRgbs[j][n6]);
                        if (bl2) {
                            float f7 = 1.0f - f6;
                            f7 = 1.0f - f7 * f7 * f7 * f7;
                            f6 = f5 * f7 + (1.0f - f5) * f6;
                        }
                        fArray2[n6] = f6;
                    }
                    n6 = (int)(fArray2[0] * 255.0f);
                    int n7 = (int)(fArray2[1] * 255.0f);
                    int n8 = (int)(fArray2[2] * 255.0f);
                    nArray[i * 16 + j] = 0xFF000000 | n6 << 16 | n7 << 8 | n8;
                }
            }
            return true;
        }
        return false;
    }

    private static void getLightMapColumn(float[][] fArray, float f, int n, int n2, float[][] fArray2) {
        int n3;
        int n4 = (int)Math.floor(f);
        if (n4 == (n3 = (int)Math.ceil(f))) {
            for (int i = 0; i < 16; ++i) {
                float[] fArray3 = fArray[n + i * n2 + n4];
                float[] fArray4 = fArray2[i];
                for (int j = 0; j < 3; ++j) {
                    fArray4[j] = fArray3[j];
                }
            }
        } else {
            float f2 = 1.0f - (f - (float)n4);
            float f3 = 1.0f - ((float)n3 - f);
            for (int i = 0; i < 16; ++i) {
                float[] fArray5 = fArray[n + i * n2 + n4];
                float[] fArray6 = fArray[n + i * n2 + n3];
                float[] fArray7 = fArray2[i];
                for (int j = 0; j < 3; ++j) {
                    fArray7[j] = fArray5[j] * f2 + fArray6[j] * f3;
                }
            }
        }
    }
}

