/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.renderer.BetterBloodRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterCactiRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterCoralsRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterFootprintsRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterGrassExperimentalRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterGrassRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLadderRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLeavesAdvancedRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLeavesExperimentalRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLeavesRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterLilyPadRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterMyceliumRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterNetherrackRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterOreRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterSeaweedRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterSoulsandRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BetterWaterRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRendererList;
import poersch.minecraft.util.ResourceHelper;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public abstract class BlockRenderer {
    public static BlockRendererList grassRenderer;
    public static BlockRendererList myceliumRenderer;
    public static BlockRendererList leavesRenderer;
    public static BlockRendererList cactusRenderer;
    public static BlockRendererList seaweedRenderer;
    public static BlockRendererList coralsRenderer;
    public static BlockRendererList soulsandRenderer;
    public static BlockRendererList footprintsRenderer;
    public static BlockRendererList lilyPadRenderer;
    public static BlockRendererList netherrackRenderer;
    public static BlockRendererList waterRenderer;
    public static BlockRendererList bloodRenderer;
    public static BlockRendererList ladderRenderer;
    public static BlockRendererList oreRenderer;
    private static final String[][] domains;
    private static int domainIndex;
    private static boolean textureGeneratorAllowed;
    private static IconRegister currentIconRegister;
    protected Minecraft minecraft = Minecraft._E();
    public static final double[][] offsetMap16px;
    public static final double[][] offsetMap24px;
    public static final double[][] offsetMap32px;
    private static double[][] currentRotationalOffsetMap;
    private static double[] currentHeightOffsetMap;
    private static int currentRotationalOffsetIndex;
    private static double currentPolyRadius;
    private static double currentHeightOffset;
    public static boolean registerIconsBlockWise;
    public static TesselatorInstance tessellator;

    public static void initiateIconRegistration(IconRegister iconRegister) {
        currentIconRegister = iconRegister;
        switch (ResourceHelper.getCurrentResourcepack().equals("Default") ? 4 : (Integer)BetterGrassAndLeavesMod.textureSource.value) {
            case 0: {
                domainIndex = 0;
                textureGeneratorAllowed = false;
                break;
            }
            default: {
                domainIndex = 0;
                textureGeneratorAllowed = true;
                break;
            }
            case 2: {
                domainIndex = 1;
                textureGeneratorAllowed = true;
                break;
            }
            case 3: {
                domainIndex = 1;
                textureGeneratorAllowed = false;
                break;
            }
            case 4: {
                domainIndex = 2;
                textureGeneratorAllowed = false;
            }
        }
    }

    private static double[][] getRotationalOffsetMap(double d, double d2) {
        double[][] dArray = new double[9][4];
        dArray[0][0] = d;
        double d3 = Math.PI * (0.25 - d2 * 4.0);
        for (int i = 1; i < 9; ++i) {
            dArray[i][0] = Math.sin(d3 += Math.PI * d2) * d;
            dArray[i][1] = Math.cos(d3) * d;
            dArray[i][2] = Math.sin(d3 + 1.5707963267948966) * d;
            dArray[i][3] = Math.cos(d3 + 1.5707963267948966) * d;
        }
        return dArray;
    }

    protected static void setRotationalOffsetMap(double[][] dArray, int n, int n2, int n3) {
        currentRotationalOffsetIndex = 1 + Math.abs((n & 1) + (n3 & 1) * 2 + (n2 & 1) * 4);
        currentRotationalOffsetMap = dArray;
    }

    private static double[] getHeightOffsetMap(double d, double d2) {
        double[] dArray = new double[5];
        dArray[0] = d;
        for (int i = 1; i < 5; ++i) {
            dArray[i] = d;
            System.out.println(dArray[i]);
            d += d2;
        }
        return dArray;
    }

    protected static void setHeightOffsetMap(double d, int n, int n2) {
        currentPolyRadius = d;
        currentHeightOffset = 0.06 + 0.03 * (double)Math.abs((n & 1) + (n2 & 1) * 2);
    }

    protected static long getRandomOffsetForPosition(int n, int n2, int n3) {
        long l = (long)(n * 3129871) ^ (long)n3 * 116129781L ^ (long)n2;
        return l * l * 42317861L + l * 11L;
    }

    public static float combineSpawnRates(float f, float f2) {
        float f3;
        f2 = f2 * 2.0f - 1.0f;
        if (f3 > 0.0f) {
            return f + (1.0f - f) * f2;
        }
        return f2 < 0.0f ? f + f * f2 - 0.001f : f;
    }

    public static String[] getDomains() {
        return domains[domainIndex];
    }

    public static Icon registerBlockIcon(String string) {
        return ResourceHelper.registerIcon(currentIconRegister, domains[domainIndex], "textures/blocks/", string);
    }

    public static Icon[] registerBlockIcons(String string) {
        return ResourceHelper.registerIcons(currentIconRegister, domains[domainIndex], "textures/blocks/", string);
    }

    public static Icon registerBlockIconOrCallback(String string, String string2, ITextureLoadingCallback iTextureLoadingCallback) {
        return ResourceHelper.registerIconOrCallback(currentIconRegister, domains[domainIndex], "textures/blocks/", string, "textures/blocks/", string2, iTextureLoadingCallback);
    }

    public static Icon registerBlockIconOrCallbackIfAllowed(String string, String string2, ITextureLoadingCallback iTextureLoadingCallback) {
        return textureGeneratorAllowed ? BlockRenderer.registerBlockIconOrCallback(string, string2, iTextureLoadingCallback) : BlockRenderer.registerBlockIcon(string);
    }

    public static Icon[] registerBlockIconsOrCallback(String string, String string2, ITextureLoadingCallback iTextureLoadingCallback) {
        return ResourceHelper.registerIconsOrCallback(currentIconRegister, domains[domainIndex], "textures/blocks/", string, "textures/blocks/", string2, iTextureLoadingCallback);
    }

    public static Icon[] registerBlockIconsOrCallbackIfAllowed(String string, String string2, ITextureLoadingCallback iTextureLoadingCallback) {
        return textureGeneratorAllowed ? BlockRenderer.registerBlockIconsOrCallback(string, string2, iTextureLoadingCallback) : BlockRenderer.registerBlockIcons(string);
    }

    public static Icon registerBlockIconCallback(String string, String string2, ITextureLoadingCallback iTextureLoadingCallback) {
        return ResourceHelper.registerIconCallback(currentIconRegister, domains[domainIndex], "textures/blocks/", string, "textures/blocks/", string2, iTextureLoadingCallback);
    }

    public static Icon[] registerBlockIconsCallback(String string, String string2, ITextureLoadingCallback iTextureLoadingCallback) {
        return ResourceHelper.registerIconsCallback(currentIconRegister, domains[domainIndex], "textures/blocks/", string, "textures/blocks/", string2, iTextureLoadingCallback);
    }

    public void onRegisterIcons(IconRegister iconRegister) {
    }

    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        return false;
    }

    public boolean onEntityWalking(Block block, World world, int n, int n2, int n3, Entity entity) {
        return false;
    }

    public boolean onRandomDisplayTick(Block block, World world, int n, int n2, int n3, Random random) {
        return false;
    }

    public boolean onSpawnParticle(String string, World world, double d, double d2, double d3, double d4, double d5, double d6, Entity entity) {
        return false;
    }

    protected void renderStandardBlock(RenderBlocks renderBlocks, Block block, int n, int n2, int n3, float f) {
        int n4 = block.colorMultiplier(renderBlocks._a, n, n2, n3);
        float f2 = (float)(n4 >> 16 & 0xFF) * 0.00392f * f;
        float f3 = (float)(n4 >> 8 & 0xFF) * 0.00392f * f;
        float f4 = (float)(n4 & 0xFF) * 0.00392f * f;
        Minecraft minecraft = this.minecraft;
        if (Minecraft._C() && Block.lightValue[block.blockID] == 0) {
            renderBlocks._a(block, n, n2, n3, f2, f3, f4);
        } else {
            renderBlocks._c(block, n, n2, n3, f2, f3, f4);
        }
    }

    protected void renderCrossedQuadsX(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d - currentRotationalOffsetMap[0][0];
        double d9 = d + currentRotationalOffsetMap[0][0];
        double d10 = d3 - currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d11 = d3 + currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d12 = d2 - currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        double d13 = d2 + currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        tessellator.get().addVertexWithUV(d9, d13, d11, d7, d5);
        tessellator.get().addVertexWithUV(d9, d12, d10, d6, d5);
        tessellator.get().addVertexWithUV(d8, d12, d10, d6, d4);
        tessellator.get().addVertexWithUV(d8, d13, d11, d7, d4);
        tessellator.get().addVertexWithUV(d9, d12, d10, d6, d5);
        tessellator.get().addVertexWithUV(d9, d13, d11, d7, d5);
        tessellator.get().addVertexWithUV(d8, d13, d11, d7, d4);
        tessellator.get().addVertexWithUV(d8, d12, d10, d6, d4);
        d10 = d3 - currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d11 = d3 + currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d12 = d2 - currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        d13 = d2 + currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        tessellator.get().addVertexWithUV(d9, d13, d11, d7, d5);
        tessellator.get().addVertexWithUV(d9, d12, d10, d6, d5);
        tessellator.get().addVertexWithUV(d8, d12, d10, d6, d4);
        tessellator.get().addVertexWithUV(d8, d13, d11, d7, d4);
        tessellator.get().addVertexWithUV(d9, d12, d10, d6, d5);
        tessellator.get().addVertexWithUV(d9, d13, d11, d7, d5);
        tessellator.get().addVertexWithUV(d8, d13, d11, d7, d4);
        tessellator.get().addVertexWithUV(d8, d12, d10, d6, d4);
    }

    protected void renderCrossedQuadsY(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d2 - currentRotationalOffsetMap[0][0];
        double d9 = d2 + currentRotationalOffsetMap[0][0];
        double d10 = d - currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d11 = d + currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d12 = d3 - currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        double d13 = d3 + currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        tessellator.get().addVertexWithUV(d11, d9, d13, d7, d5);
        tessellator.get().addVertexWithUV(d11, d8, d13, d7, d4);
        tessellator.get().addVertexWithUV(d10, d8, d12, d6, d4);
        tessellator.get().addVertexWithUV(d10, d9, d12, d6, d5);
        tessellator.get().addVertexWithUV(d10, d9, d12, d6, d5);
        tessellator.get().addVertexWithUV(d10, d8, d12, d6, d4);
        tessellator.get().addVertexWithUV(d11, d8, d13, d7, d4);
        tessellator.get().addVertexWithUV(d11, d9, d13, d7, d5);
        d10 = d - currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d11 = d + currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d12 = d3 - currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        d13 = d3 + currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        tessellator.get().addVertexWithUV(d11, d9, d13, d7, d5);
        tessellator.get().addVertexWithUV(d11, d8, d13, d7, d4);
        tessellator.get().addVertexWithUV(d10, d8, d12, d6, d4);
        tessellator.get().addVertexWithUV(d10, d9, d12, d6, d5);
        tessellator.get().addVertexWithUV(d10, d9, d12, d6, d5);
        tessellator.get().addVertexWithUV(d10, d8, d12, d6, d4);
        tessellator.get().addVertexWithUV(d11, d8, d13, d7, d4);
        tessellator.get().addVertexWithUV(d11, d9, d13, d7, d5);
    }

    protected void renderCrossedQuadsZ(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d3 - currentRotationalOffsetMap[0][0];
        double d9 = d3 + currentRotationalOffsetMap[0][0];
        double d10 = d - currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d11 = d + currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d12 = d2 - currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        double d13 = d2 + currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        tessellator.get().addVertexWithUV(d11, d13, d9, d7, d5);
        tessellator.get().addVertexWithUV(d10, d12, d9, d6, d5);
        tessellator.get().addVertexWithUV(d10, d12, d8, d6, d4);
        tessellator.get().addVertexWithUV(d11, d13, d8, d7, d4);
        tessellator.get().addVertexWithUV(d10, d12, d9, d6, d5);
        tessellator.get().addVertexWithUV(d11, d13, d9, d7, d5);
        tessellator.get().addVertexWithUV(d11, d13, d8, d7, d4);
        tessellator.get().addVertexWithUV(d10, d12, d8, d6, d4);
        d10 = d - currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d11 = d + currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d12 = d2 - currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        d13 = d2 + currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        tessellator.get().addVertexWithUV(d11, d13, d9, d7, d5);
        tessellator.get().addVertexWithUV(d10, d12, d9, d6, d5);
        tessellator.get().addVertexWithUV(d10, d12, d8, d6, d4);
        tessellator.get().addVertexWithUV(d11, d13, d8, d7, d4);
        tessellator.get().addVertexWithUV(d10, d12, d9, d6, d5);
        tessellator.get().addVertexWithUV(d11, d13, d9, d7, d5);
        tessellator.get().addVertexWithUV(d11, d13, d8, d7, d4);
        tessellator.get().addVertexWithUV(d10, d12, d8, d6, d4);
    }

    protected void renderCrossedQuadsShadedX(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2, float f, float f2, float f3, float f4, float f5, float f6) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d - currentRotationalOffsetMap[0][0];
        double d9 = d + currentRotationalOffsetMap[0][0];
        double d10 = d3 - currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d11 = d3 + currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d12 = d2 - currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        double d13 = d2 + currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        tessellator.get().setNormal(0.0f, 1.0f, 0.0f);
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d8, d13, d11, d7, d4);
        tessellator.get().addVertexWithUV(d9, d13, d11, d7, d5);
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d9, d12, d10, d6, d5);
        tessellator.get().addVertexWithUV(d8, d12, d10, d6, d4);
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d9, d13, d11, d7, d5);
        tessellator.get().addVertexWithUV(d8, d13, d11, d7, d4);
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d8, d12, d10, d6, d4);
        tessellator.get().addVertexWithUV(d9, d12, d10, d6, d5);
        d10 = d3 - currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d11 = d3 + currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d12 = d2 - currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        d13 = d2 + currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d8, d13, d11, d7, d4);
        tessellator.get().addVertexWithUV(d9, d13, d11, d7, d5);
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d9, d12, d10, d6, d5);
        tessellator.get().addVertexWithUV(d8, d12, d10, d6, d4);
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d9, d13, d11, d7, d5);
        tessellator.get().addVertexWithUV(d8, d13, d11, d7, d4);
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d8, d12, d10, d6, d4);
        tessellator.get().addVertexWithUV(d9, d12, d10, d6, d5);
    }

    protected void renderCrossedQuadsShadedY(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2, float f, float f2, float f3, float f4, float f5, float f6) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d2 - currentRotationalOffsetMap[0][0];
        double d9 = d2 + currentRotationalOffsetMap[0][0];
        double d10 = d - currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d11 = d + currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d12 = d3 - currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        double d13 = d3 + currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        tessellator.get().setNormal(0.0f, 1.0f, 0.0f);
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d10, d9, d12, d6, d5);
        tessellator.get().addVertexWithUV(d11, d9, d13, d7, d5);
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d11, d8, d13, d7, d4);
        tessellator.get().addVertexWithUV(d10, d8, d12, d6, d4);
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d11, d9, d13, d7, d5);
        tessellator.get().addVertexWithUV(d10, d9, d12, d6, d5);
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d10, d8, d12, d6, d4);
        tessellator.get().addVertexWithUV(d11, d8, d13, d7, d4);
        d10 = d - currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d11 = d + currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d12 = d3 - currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        d13 = d3 + currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d10, d9, d12, d6, d5);
        tessellator.get().addVertexWithUV(d11, d9, d13, d7, d5);
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d11, d8, d13, d7, d4);
        tessellator.get().addVertexWithUV(d10, d8, d12, d6, d4);
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d11, d9, d13, d7, d5);
        tessellator.get().addVertexWithUV(d10, d9, d12, d6, d5);
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d10, d8, d12, d6, d4);
        tessellator.get().addVertexWithUV(d11, d8, d13, d7, d4);
    }

    protected void renderCrossedQuadsShadedZ(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2, float f, float f2, float f3, float f4, float f5, float f6) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d3 - currentRotationalOffsetMap[0][0];
        double d9 = d3 + currentRotationalOffsetMap[0][0];
        double d10 = d - currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d11 = d + currentRotationalOffsetMap[currentRotationalOffsetIndex][0];
        double d12 = d2 - currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        double d13 = d2 + currentRotationalOffsetMap[currentRotationalOffsetIndex][1];
        tessellator.get().setNormal(0.0f, 1.0f, 0.0f);
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d11, d13, d8, d7, d4);
        tessellator.get().addVertexWithUV(d11, d13, d9, d7, d5);
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d10, d12, d9, d6, d5);
        tessellator.get().addVertexWithUV(d10, d12, d8, d6, d4);
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d11, d13, d9, d7, d5);
        tessellator.get().addVertexWithUV(d11, d13, d8, d7, d4);
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d10, d12, d8, d6, d4);
        tessellator.get().addVertexWithUV(d10, d12, d9, d6, d5);
        d10 = d - currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d11 = d + currentRotationalOffsetMap[currentRotationalOffsetIndex][2];
        d12 = d2 - currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        d13 = d2 + currentRotationalOffsetMap[currentRotationalOffsetIndex][3];
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d11, d13, d8, d7, d4);
        tessellator.get().addVertexWithUV(d11, d13, d9, d7, d5);
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d10, d12, d9, d6, d5);
        tessellator.get().addVertexWithUV(d10, d12, d8, d6, d4);
        tessellator.get().setColorOpaque_F(f4, f5, f6);
        tessellator.get().addVertexWithUV(d11, d13, d9, d7, d5);
        tessellator.get().addVertexWithUV(d11, d13, d8, d7, d4);
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().addVertexWithUV(d10, d12, d8, d6, d4);
        tessellator.get().addVertexWithUV(d10, d12, d9, d6, d5);
    }

    public static void renderFaceXNeg(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d - currentHeightOffset;
        double d9 = d3 + 0.5 - currentPolyRadius;
        double d10 = d3 + 0.5 + currentPolyRadius;
        double d11 = d2 + 0.5 - currentPolyRadius;
        double d12 = d2 + 0.5 + currentPolyRadius;
        tessellator.get().setNormal(-1.0f, 0.0f, 0.0f);
        tessellator.get().addVertexWithUV(d8, d12, d9, d7, d5);
        tessellator.get().addVertexWithUV(d8, d11, d9, d7, d4);
        tessellator.get().addVertexWithUV(d8, d11, d10, d6, d4);
        tessellator.get().addVertexWithUV(d8, d12, d10, d6, d5);
    }

    public static void renderFaceXPos(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d + 1.0 + currentHeightOffset;
        double d9 = d3 + 0.5 - currentPolyRadius;
        double d10 = d3 + 0.5 + currentPolyRadius;
        double d11 = d2 + 0.5 - currentPolyRadius;
        double d12 = d2 + 0.5 + currentPolyRadius;
        tessellator.get().setNormal(1.0f, 0.0f, 0.0f);
        tessellator.get().addVertexWithUV(d8, d12, d10, d7, d5);
        tessellator.get().addVertexWithUV(d8, d11, d10, d7, d4);
        tessellator.get().addVertexWithUV(d8, d11, d9, d6, d4);
        tessellator.get().addVertexWithUV(d8, d12, d9, d6, d5);
    }

    public static void renderFaceYNeg(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d + 0.5 - currentPolyRadius;
        double d9 = d + 0.5 + currentPolyRadius;
        double d10 = d3 + 0.5 - currentPolyRadius;
        double d11 = d3 + 0.5 + currentPolyRadius;
        double d12 = d2 - currentHeightOffset;
        tessellator.get().setNormal(0.0f, -1.0f, 0.0f);
        tessellator.get().addVertexWithUV(d9, d12, d10, d6, d5);
        tessellator.get().addVertexWithUV(d9, d12, d11, d6, d4);
        tessellator.get().addVertexWithUV(d8, d12, d11, d7, d4);
        tessellator.get().addVertexWithUV(d8, d12, d10, d7, d5);
    }

    public static void renderFaceYPos(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d + 0.5 - currentPolyRadius;
        double d9 = d + 0.5 + currentPolyRadius;
        double d10 = d3 + 0.5 - currentPolyRadius;
        double d11 = d3 + 0.5 + currentPolyRadius;
        double d12 = d2 + 1.0 + currentHeightOffset;
        tessellator.get().setNormal(0.0f, 1.0f, 0.0f);
        tessellator.get().addVertexWithUV(d8, d12, d10, d7, d5);
        tessellator.get().addVertexWithUV(d8, d12, d11, d7, d4);
        tessellator.get().addVertexWithUV(d9, d12, d11, d6, d4);
        tessellator.get().addVertexWithUV(d9, d12, d10, d6, d5);
    }

    public static void renderFaceZNeg(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d + 0.5 - currentPolyRadius;
        double d9 = d + 0.5 + currentPolyRadius;
        double d10 = d3 - currentHeightOffset;
        double d11 = d2 + 0.5 - currentPolyRadius;
        double d12 = d2 + 0.5 + currentPolyRadius;
        tessellator.get().setNormal(0.0f, 0.0f, -1.0f);
        tessellator.get().addVertexWithUV(d9, d12, d10, d7, d5);
        tessellator.get().addVertexWithUV(d9, d11, d10, d7, d4);
        tessellator.get().addVertexWithUV(d8, d11, d10, d6, d4);
        tessellator.get().addVertexWithUV(d8, d12, d10, d6, d5);
    }

    public static void renderFaceZPos(Icon icon, double d, double d2, double d3, boolean bl, boolean bl2) {
        double d4;
        double d5;
        double d6;
        double d7;
        if (!bl) {
            d7 = icon.getMinU();
            d6 = icon.getMaxU();
        } else {
            d7 = icon.getMaxU();
            d6 = icon.getMinU();
        }
        if (!bl2) {
            d5 = icon.getMinV();
            d4 = icon.getMaxV();
        } else {
            d5 = icon.getMaxV();
            d4 = icon.getMinV();
        }
        double d8 = d + 0.5 - currentPolyRadius;
        double d9 = d + 0.5 + currentPolyRadius;
        double d10 = d3 + 1.0 + currentHeightOffset;
        double d11 = d2 + 0.5 - currentPolyRadius;
        double d12 = d2 + 0.5 + currentPolyRadius;
        tessellator.get().setNormal(0.0f, 0.0f, 1.0f);
        tessellator.get().addVertexWithUV(d8, d12, d10, d7, d5);
        tessellator.get().addVertexWithUV(d8, d11, d10, d7, d4);
        tessellator.get().addVertexWithUV(d9, d11, d10, d6, d4);
        tessellator.get().addVertexWithUV(d9, d12, d10, d6, d5);
    }

    public static void renderBlock(Icon icon, double d, double d2, double d3, double d4, float f, float f2, float f3, float f4, boolean bl, boolean bl2) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (!bl) {
            d8 = icon.getMinU();
            d7 = icon.getMaxU();
        } else {
            d8 = icon.getMaxU();
            d7 = icon.getMinU();
        }
        if (!bl2) {
            d6 = icon.getMinV();
            d5 = icon.getMaxV();
        } else {
            d6 = icon.getMaxV();
            d5 = icon.getMinV();
        }
        double d9 = d - d4;
        double d10 = d + d4;
        double d11 = d2 - d4;
        double d12 = d2 + d4;
        double d13 = d3 - d4;
        double d14 = d3 + d4;
        tessellator.get().addVertexWithUV(d9, d12, d13, d8, d6);
        tessellator.get().addVertexWithUV(d9, d12, d14, d8, d5);
        tessellator.get().addVertexWithUV(d10, d12, d14, d7, d5);
        tessellator.get().addVertexWithUV(d10, d12, d13, d7, d6);
        tessellator.get().addVertexWithUV(d10, d11, d13, d7, d6);
        tessellator.get().addVertexWithUV(d10, d11, d14, d7, d5);
        tessellator.get().addVertexWithUV(d9, d11, d14, d8, d5);
        tessellator.get().addVertexWithUV(d9, d11, d13, d8, d6);
        tessellator.get().addVertexWithUV(d9, d12, d13, d8, d6);
        tessellator.get().addVertexWithUV(d9, d11, d13, d8, d5);
        tessellator.get().addVertexWithUV(d9, d11, d14, d7, d5);
        tessellator.get().addVertexWithUV(d9, d12, d14, d7, d6);
        tessellator.get().addVertexWithUV(d10, d12, d14, d8, d6);
        tessellator.get().addVertexWithUV(d10, d11, d14, d8, d5);
        tessellator.get().addVertexWithUV(d10, d11, d13, d7, d5);
        tessellator.get().addVertexWithUV(d10, d12, d13, d7, d6);
        tessellator.get().addVertexWithUV(d10, d12, d13, d8, d6);
        tessellator.get().addVertexWithUV(d10, d11, d13, d8, d5);
        tessellator.get().addVertexWithUV(d9, d11, d13, d7, d5);
        tessellator.get().addVertexWithUV(d9, d12, d13, d7, d6);
        tessellator.get().addVertexWithUV(d9, d12, d14, d8, d6);
        tessellator.get().addVertexWithUV(d9, d11, d14, d8, d5);
        tessellator.get().addVertexWithUV(d10, d11, d14, d7, d5);
        tessellator.get().addVertexWithUV(d10, d12, d14, d7, d6);
    }

    public static void render3DFaceYPos(Icon icon, double d, double d2, double d3, int n, int n2, double d4, float f, float f2, float f3, boolean bl, boolean bl2) {
        double d5;
        int n3;
        double d6;
        double d7;
        double d8;
        double d9;
        if (!bl) {
            d9 = icon.getMinU();
            d8 = icon.getMaxU();
        } else {
            d9 = icon.getMaxU();
            d8 = icon.getMinU();
        }
        if (!bl2) {
            d7 = icon.getMinV();
            d6 = icon.getMaxV();
        } else {
            d7 = icon.getMaxV();
            d6 = icon.getMinV();
        }
        double d10 = d;
        double d11 = d + 1.0;
        double d12 = d3;
        double d13 = d3 + 1.0;
        double d14 = d2;
        double d15 = d2 + d4;
        double d16 = (d8 - d9) / (double)n;
        double d17 = (d6 - d7) / (double)n2;
        double d18 = (d11 - d) / (double)n;
        double d19 = (d13 - d3) / (double)n2;
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().setNormal(0.0f, 1.0f, 0.0f);
        tessellator.get().addVertexWithUV(d, d15, d13, d9, d6);
        tessellator.get().addVertexWithUV(d11, d15, d13, d8, d6);
        tessellator.get().addVertexWithUV(d11, d15, d3, d8, d7);
        tessellator.get().addVertexWithUV(d, d15, d3, d9, d7);
        tessellator.get().setColorOpaque_F(f * 0.6f, f2 * 0.6f, f3 * 0.6f);
        tessellator.get().setNormal(-1.0f, 0.0f, 0.0f);
        for (n3 = 0; n3 < n; ++n3) {
            d = d10 + (double)n3 * d18;
            d5 = d9 + ((double)n3 + 0.5) * d16;
            tessellator.get().addVertexWithUV(d, d15, d12, d5, d7);
            tessellator.get().addVertexWithUV(d, d14, d12, d5, d7);
            tessellator.get().addVertexWithUV(d, d14, d13, d5, d6);
            tessellator.get().addVertexWithUV(d, d15, d13, d5, d6);
        }
        tessellator.get().setNormal(1.0f, 0.0f, 0.0f);
        for (n3 = 0; n3 < n; ++n3) {
            d = d11 - (double)n3 * d18;
            d5 = d8 - ((double)n3 + 0.5) * d16;
            tessellator.get().addVertexWithUV(d, d15, d13, d5, d6);
            tessellator.get().addVertexWithUV(d, d14, d13, d5, d6);
            tessellator.get().addVertexWithUV(d, d14, d12, d5, d7);
            tessellator.get().addVertexWithUV(d, d15, d12, d5, d7);
        }
        tessellator.get().setNormal(0.0f, 0.0f, -1.0f);
        for (n3 = 0; n3 < n2; ++n3) {
            d3 = d12 + (double)n3 * d19;
            d5 = d7 + ((double)n3 + 0.5) * d17;
            tessellator.get().addVertexWithUV(d11, d15, d3, d8, d5);
            tessellator.get().addVertexWithUV(d11, d14, d3, d8, d5);
            tessellator.get().addVertexWithUV(d10, d14, d3, d9, d5);
            tessellator.get().addVertexWithUV(d10, d15, d3, d9, d5);
        }
        tessellator.get().setNormal(0.0f, 0.0f, 1.0f);
        for (n3 = 0; n3 < n2; ++n3) {
            d3 = d13 - (double)n3 * d19;
            d5 = d6 - ((double)n3 + 0.5) * d17;
            tessellator.get().addVertexWithUV(d10, d15, d3, d9, d5);
            tessellator.get().addVertexWithUV(d10, d14, d3, d9, d5);
            tessellator.get().addVertexWithUV(d11, d14, d3, d8, d5);
            tessellator.get().addVertexWithUV(d11, d15, d3, d8, d5);
        }
    }

    public static void render3DFaceX(Icon icon, double d, double d2, double d3, boolean[][] blArray, double d4, float f, float f2, float f3, boolean bl, boolean bl2) {
        double d5;
        int n;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12 = icon.getMinU();
        double d13 = icon.getMaxU();
        double d14 = icon.getMinV();
        double d15 = icon.getMaxV();
        if (bl ^ bl2) {
            d11 = d + d4 * 0.5;
            d10 = d - d4 * 0.5;
        } else {
            d11 = d - d4 * 0.5;
            d10 = d + d4 * 0.5;
        }
        if (bl2) {
            d9 = d2 + 0.5;
            d8 = d2 - 0.5;
        } else {
            d9 = d2 - 0.5;
            d8 = d2 + 0.5;
        }
        if (bl) {
            d7 = d3 + 0.5;
            d6 = d3 - 0.5;
        } else {
            d7 = d3 - 0.5;
            d6 = d3 + 0.5;
        }
        int n2 = blArray.length;
        double d16 = (d13 - d12) / (double)n2;
        double d17 = (d15 - d14) / (double)n2;
        double d18 = (d6 - d7) / (double)n2;
        double d19 = (d8 - d9) / (double)n2;
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().setNormal(-1.0f, 0.0f, 0.0f);
        tessellator.get().addVertexWithUV(d11, d9, d6, d12, d15);
        tessellator.get().addVertexWithUV(d11, d8, d6, d12, d14);
        tessellator.get().addVertexWithUV(d11, d8, d7, d13, d14);
        tessellator.get().addVertexWithUV(d11, d9, d7, d13, d15);
        tessellator.get().setNormal(1.0f, 0.0f, 0.0f);
        tessellator.get().addVertexWithUV(d10, d9, d7, d13, d15);
        tessellator.get().addVertexWithUV(d10, d8, d7, d13, d14);
        tessellator.get().addVertexWithUV(d10, d8, d6, d12, d14);
        tessellator.get().addVertexWithUV(d10, d9, d6, d12, d15);
        tessellator.get().setColorOpaque_F(f * 0.8f, f2 * 0.8f, f3 * 0.8f);
        tessellator.get().setNormal(0.0f, 1.0f, 0.0f);
        for (n = 0; n < n2; ++n) {
            if (!blArray[n][0]) continue;
            d2 = d8 - (double)n * d19;
            d5 = d14 + ((double)n + 0.5) * d17;
            tessellator.get().addVertexWithUV(d11, d2, d6, d12, d5);
            tessellator.get().addVertexWithUV(d10, d2, d6, d12, d5);
            tessellator.get().addVertexWithUV(d10, d2, d7, d13, d5);
            tessellator.get().addVertexWithUV(d11, d2, d7, d13, d5);
        }
        tessellator.get().setColorOpaque_F(f * 0.56f, f2 * 0.56f, f3 * 0.56f);
        tessellator.get().setNormal(0.0f, -1.0f, 0.0f);
        for (n = 0; n < n2; ++n) {
            if (!blArray[n][1]) continue;
            d2 = d9 + (double)n * d19;
            d5 = d15 - ((double)n + 0.5) * d17;
            tessellator.get().addVertexWithUV(d11, d2, d7, d13, d5);
            tessellator.get().addVertexWithUV(d10, d2, d7, d13, d5);
            tessellator.get().addVertexWithUV(d10, d2, d6, d12, d5);
            tessellator.get().addVertexWithUV(d11, d2, d6, d12, d5);
        }
        tessellator.get().setColorOpaque_F(f * 0.7f, f2 * 0.7f, f3 * 0.7f);
        tessellator.get().setNormal(0.0f, 0.0f, 1.0f);
        for (n = 0; n < n2; ++n) {
            if (!blArray[n][2]) continue;
            d3 = d6 - (double)n * d18;
            d5 = d12 + ((double)n + 0.5) * d16;
            tessellator.get().addVertexWithUV(d11, d8, d3, d5, d14);
            tessellator.get().addVertexWithUV(d11, d9, d3, d5, d15);
            tessellator.get().addVertexWithUV(d10, d9, d3, d5, d15);
            tessellator.get().addVertexWithUV(d10, d8, d3, d5, d14);
        }
        tessellator.get().setNormal(0.0f, 0.0f, -1.0f);
        for (n = 0; n < n2; ++n) {
            if (!blArray[n][3]) continue;
            d3 = d7 + (double)n * d18;
            d5 = d13 - ((double)n + 0.5) * d16;
            tessellator.get().addVertexWithUV(d10, d8, d3, d5, d14);
            tessellator.get().addVertexWithUV(d10, d9, d3, d5, d15);
            tessellator.get().addVertexWithUV(d11, d9, d3, d5, d15);
            tessellator.get().addVertexWithUV(d11, d8, d3, d5, d14);
        }
    }

    public static void render3DFaceZ(Icon icon, double d, double d2, double d3, boolean[][] blArray, double d4, float f, float f2, float f3, boolean bl, boolean bl2) {
        double d5;
        int n;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12 = icon.getMinU();
        double d13 = icon.getMaxU();
        double d14 = icon.getMinV();
        double d15 = icon.getMaxV();
        if (bl) {
            d11 = d + 0.5;
            d10 = d - 0.5;
        } else {
            d11 = d - 0.5;
            d10 = d + 0.5;
        }
        if (bl2) {
            d9 = d2 + 0.5;
            d8 = d2 - 0.5;
        } else {
            d9 = d2 - 0.5;
            d8 = d2 + 0.5;
        }
        if (bl ^ bl2) {
            d7 = d3 + d4 * 0.5;
            d6 = d3 - d4 * 0.5;
        } else {
            d7 = d3 - d4 * 0.5;
            d6 = d3 + d4 * 0.5;
        }
        int n2 = blArray.length;
        double d16 = (d13 - d12) / (double)n2;
        double d17 = (d15 - d14) / (double)n2;
        double d18 = (d10 - d11) / (double)n2;
        double d19 = (d8 - d9) / (double)n2;
        tessellator.get().setColorOpaque_F(f, f2, f3);
        tessellator.get().setNormal(0.0f, 0.0f, -1.0f);
        tessellator.get().addVertexWithUV(d11, d9, d7, d12, d15);
        tessellator.get().addVertexWithUV(d11, d8, d7, d12, d14);
        tessellator.get().addVertexWithUV(d10, d8, d7, d13, d14);
        tessellator.get().addVertexWithUV(d10, d9, d7, d13, d15);
        tessellator.get().setNormal(0.0f, 0.0f, 1.0f);
        tessellator.get().addVertexWithUV(d10, d9, d6, d13, d15);
        tessellator.get().addVertexWithUV(d10, d8, d6, d13, d14);
        tessellator.get().addVertexWithUV(d11, d8, d6, d12, d14);
        tessellator.get().addVertexWithUV(d11, d9, d6, d12, d15);
        tessellator.get().setColorOpaque_F(f * 0.8f, f2 * 0.8f, f3 * 0.8f);
        tessellator.get().setNormal(0.0f, 1.0f, 0.0f);
        for (n = 0; n < n2; ++n) {
            if (!blArray[n][0]) continue;
            d2 = d8 - (double)n * d19;
            d5 = d14 + ((double)n + 0.5) * d17;
            tessellator.get().addVertexWithUV(d11, d2, d6, d12, d5);
            tessellator.get().addVertexWithUV(d10, d2, d6, d13, d5);
            tessellator.get().addVertexWithUV(d10, d2, d7, d13, d5);
            tessellator.get().addVertexWithUV(d11, d2, d7, d12, d5);
        }
        tessellator.get().setColorOpaque_F(f * 0.56f, f2 * 0.56f, f3 * 0.56f);
        tessellator.get().setNormal(0.0f, -1.0f, 0.0f);
        for (n = 0; n < n2; ++n) {
            if (!blArray[n][1]) continue;
            d2 = d9 + (double)n * d19;
            d5 = d15 - ((double)n + 0.5) * d17;
            tessellator.get().addVertexWithUV(d11, d2, d7, d12, d5);
            tessellator.get().addVertexWithUV(d10, d2, d7, d13, d5);
            tessellator.get().addVertexWithUV(d10, d2, d6, d13, d5);
            tessellator.get().addVertexWithUV(d11, d2, d6, d12, d5);
        }
        tessellator.get().setColorOpaque_F(f * 0.7f, f2 * 0.7f, f3 * 0.7f);
        tessellator.get().setNormal(1.0f, 0.0f, 0.0f);
        for (n = 0; n < n2; ++n) {
            if (!blArray[n][2]) continue;
            d = d11 + (double)n * d18;
            d5 = d12 + ((double)n + 0.5) * d16;
            tessellator.get().addVertexWithUV(d, d8, d7, d5, d14);
            tessellator.get().addVertexWithUV(d, d9, d7, d5, d15);
            tessellator.get().addVertexWithUV(d, d9, d6, d5, d15);
            tessellator.get().addVertexWithUV(d, d8, d6, d5, d14);
        }
        tessellator.get().setNormal(-1.0f, 0.0f, 0.0f);
        for (n = 0; n < n2; ++n) {
            if (!blArray[n][3]) continue;
            d = d10 - (double)n * d18;
            d5 = d13 - ((double)n + 0.5) * d16;
            tessellator.get().addVertexWithUV(d, d8, d6, d5, d14);
            tessellator.get().addVertexWithUV(d, d9, d6, d5, d15);
            tessellator.get().addVertexWithUV(d, d9, d7, d5, d15);
            tessellator.get().addVertexWithUV(d, d8, d7, d5, d14);
        }
    }

    static {
        tessellator = new TesselatorInstance();
        grassRenderer = new BlockRendererList("better-grass", 5).setRendererChoice(BetterGrassAndLeavesMod.currentGrassRenderer).addRenderer(new BetterGrassRenderer(), new BetterGrassExperimentalRenderer());
        myceliumRenderer = new BlockRendererList("better-mycelium", 5).addRenderer(new BetterMyceliumRenderer());
        leavesRenderer = new BlockRendererList("better-leaves", 3).setRendererChoice(BetterGrassAndLeavesMod.currentLeavesRenderer).addRenderer(new BetterLeavesRenderer(), new BetterLeavesAdvancedRenderer(), new BetterLeavesExperimentalRenderer());
        cactusRenderer = new BlockRendererList("better-cacti", 1).addRenderer(new BetterCactiRenderer());
        seaweedRenderer = new BlockRendererList("better-seaweed", 1).addRenderer(new BetterSeaweedRenderer());
        coralsRenderer = new BlockRendererList("better-corals", 3).addRenderer(new BetterCoralsRenderer());
        soulsandRenderer = new BlockRendererList("better-soulsand", 2).addRenderer(new BetterSoulsandRenderer());
        footprintsRenderer = new BlockRendererList("better-footprints", 4).addRenderer(new BetterFootprintsRenderer());
        lilyPadRenderer = new BlockRendererList("better-lily-pad", 1).addRenderer(new BetterLilyPadRenderer());
        netherrackRenderer = new BlockRendererList("better-netherrack", 1).addRenderer(new BetterNetherrackRenderer());
        waterRenderer = new BlockRendererList("better-water", 2).assignToParticleSpawner("suspended").addRenderer(new BetterWaterRenderer());
        bloodRenderer = new BlockRendererList("better-blood", 0).assignToParticleSpawner("blood").addRenderer(new BetterBloodRenderer());
        ladderRenderer = new BlockRendererList("better-ladder", 1).addRenderer(new BetterLadderRenderer());
        oreRenderer = new BlockRendererList("better-ore", 1).addRenderer(new BetterOreRenderer());
        domains = new String[][]{{"minecraft"}, {"minecraft", "bettergrassandleaves"}, {"bettergrassandleaves"}};
        domainIndex = 0;
        textureGeneratorAllowed = false;
        offsetMap16px = BlockRenderer.getRotationalOffsetMap(0.4714, 0.012);
        offsetMap24px = BlockRenderer.getRotationalOffsetMap(0.707, 0.012);
        offsetMap32px = BlockRenderer.getRotationalOffsetMap(0.9, 0.012);
        registerIconsBlockWise = true;
        tessellator.set(Tessellator.instance);
    }

    public static class TesselatorInstance {
        private Tessellator instance;

        public Tessellator get() {
            return this.instance;
        }

        public void set(Tessellator tessellator) {
            this.instance = tessellator;
        }
    }
}

