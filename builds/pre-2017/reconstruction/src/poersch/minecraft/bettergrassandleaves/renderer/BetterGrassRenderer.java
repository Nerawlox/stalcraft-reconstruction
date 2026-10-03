/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.util.sajh;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingGrassFancyFX;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingGrassFastFX;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingTallGrassFancyFX;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingTallGrassFastFX;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterGrass;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterGrassBiome;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterGrassRenderer
extends BlockRenderer
implements IBetterGrass,
ITextureLoadingCallback {
    public static Icon[] iconBetterGrass;
    public static Icon[] iconBetterGrassSide;
    public static Icon[] iconBetterGrassSnowed;
    private static final boolean USE_GRASS_MODEL = true;
    private hsdi[] models;
    private static final int MIN_INSTANCES = 1;
    private static final int MAX_INSTANCES = 3;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        iconBetterGrass = BetterGrassRenderer.registerBlockIcons("better_grass");
        iconBetterGrassSnowed = BetterGrassRenderer.registerBlockIcons("better_grass_snowed");
        iconBetterGrassSide = BetterGrassRenderer.registerBlockIcons("better_grass_side");
        this.models = new hsdi[iconBetterGrass.length];
        for (int i = 0; i < this.models.length; ++i) {
            try {
                this.models[i] = new hsdi("/assets/bettergrassandleaves/models/grass_" + i + ".obj", true, true, 0.4f, 0.8f, 1.3f, 1, 1, new float[]{0.8f, 0.8f, 0.8f}, new float[]{0.2f, 0.2f, 0.2f});
                continue;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterGrass.value).booleanValue()) {
            return false;
        }
        int n4 = iBlockAccess.getBlockId(n, n2 + 1, n3);
        if (n4 != Block.snow.blockID) {
            long l = BetterGrassRenderer.getRandomOffsetForPosition(n, n2, n3);
            int n5 = block.colorMultiplier(iBlockAccess, n, n2, n3);
            float f = (float)(n5 >> 16 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue();
            float f2 = (float)(n5 >> 8 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue();
            float f3 = (float)(n5 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue();
            int n6 = block.getMixedBrightnessForBlock(iBlockAccess, n, n2 + 1, n3);
            if (((Boolean[])BetterGrassAndLeavesMod.allowBetterGrass.value)[n4].booleanValue()) {
                int n7 = 1 + ((int)l >> 16 & 2);
                for (int i = 0; i < n7; ++i) {
                    int n8 = (int)(l >> i * 4 & 0xFL) % iconBetterGrass.length;
                    hsdi hsdi2 = this.models[n8];
                    Icon icon = iconBetterGrass[n8];
                    if (hsdi2 == null || icon == null) continue;
                    hsdi2.setColor(f, f2, f3);
                    int n9 = n * 31 + n2 * 23 + n3 * 37 + n8 * 49;
                    hsdi2.renderBlock(n, n2 + 1, n3, n9, n6, 0, iconBetterGrass[n8], renderBlocks);
                }
            }
        } else if (((Boolean)BetterGrassAndLeavesMod.renderSnowedGrass.value).booleanValue()) {
            long l;
            IBetterGrass iBetterGrass = block instanceof IBetterGrass ? (IBetterGrass)((Object)block) : this;
            Icon icon = ((IBetterGrass)iBetterGrass).getIconBetterGrassSnowed(0, (float)((l = BetterGrassRenderer.getRandomOffsetForPosition(n, n2, n3)) >> 12 & 0xFL) / 15.0f);
            if (icon == null) {
                return false;
            }
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 + 1, n3));
            BlockRenderer.tessellator.get().setColorOpaque_F(1.0f, 1.0f, 1.0f);
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d2 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
            double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
            boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            BetterGrassRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
            this.renderCrossedQuadsY(icon, d, d2, d3, bl, false);
        }
        return false;
    }

    @Override
    public boolean onEntityWalking(Block block, World world, int n, int n2, int n3, Entity entity) {
        if ((Integer)BetterGrassAndLeavesMod.renderGrassFX.value == 0) {
            return false;
        }
        if (world.isAirBlock(n, n2 + 1, n3)) {
            boolean bl;
            BiomeGenBase biomeGenBase;
            float f;
            long l;
            IBetterGrass iBetterGrass = block instanceof IBetterGrass ? (IBetterGrass)((Object)block) : this;
            Icon icon = iBetterGrass.getIconBetterGrass((float)((l = BetterGrassRenderer.getRandomOffsetForPosition(n, n2, n3)) >> 4 & 0xFL) / 15.0f > (f = BetterGrassRenderer.combineSpawnRates((biomeGenBase = world.getBiomeGenForCoords(n, n3)) instanceof IBetterGrassBiome ? ((IBetterGrassBiome)((Object)biomeGenBase)).getHeightBetterGrass() : biomeGenBase._G * 0.9f + 0.05f, ((Float)BetterGrassAndLeavesMod.averageGrassHeight.value).floatValue())) ? 0 : 1, (float)(l >> 12 & 0xFL) / 15.0f);
            if (icon == null) {
                return false;
            }
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d2 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
            double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
            boolean bl2 = bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            if ((Integer)BetterGrassAndLeavesMod.renderGrassFX.value == 1) {
                this.minecraft._w._a(new EntityMovingGrassFastFX(world, d, d2, d3, 0.46f, Math.abs(n & 1 + (n3 & 1) * 2 + (n2 & 1) * 4), block.getMixedBrightnessForBlock(world, n, n2 + 1, n3), ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue(), block.colorMultiplier(world, n, n2, n3), icon, bl));
            } else {
                this.minecraft._w._a(new EntityMovingGrassFancyFX(world, entity.posX, d2, entity.posZ, 0.46f, Math.abs(n & 1 + (n3 & 1) * 2 + (n2 & 1) * 4), block.getMixedBrightnessForBlock(world, n, n2 + 1, n3), ((Float)BetterGrassAndLeavesMod.betterGrassBrightness.value).floatValue(), block.colorMultiplier(world, n, n2, n3), icon, bl, entity, block.blockID));
            }
        } else if (world.getBlockId(n, n2 + 1, n3) == Block.tallGrass.blockID) {
            long l = BetterGrassRenderer.getRandomOffsetForPosition(n, n2 + 1, n3);
            Icon icon = Block.tallGrass.getIcon(0, world.getBlockMetadata(n, n2 + 1, n3));
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.5;
            double d4 = (double)n2 + 1.5 + ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 1.0) * 0.2;
            double d5 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.5;
            if ((Integer)BetterGrassAndLeavesMod.renderGrassFX.value == 1) {
                this.minecraft._w._a(new EntityMovingTallGrassFastFX(world, d, d4, d5, -0.4f, Block.tallGrass.getMixedBrightnessForBlock(world, n, n2 + 1, n3), block.colorMultiplier(world, n, n2 + 1, n3), icon));
            } else {
                this.minecraft._w._a(new EntityMovingTallGrassFancyFX(world, entity.posX, d4, entity.posZ, -0.4f, Block.tallGrass.getMixedBrightnessForBlock(world, n, n2 + 1, n3), Block.tallGrass.colorMultiplier(world, n, n2 + 1, n3), icon, entity, block.blockID));
            }
        }
        return false;
    }

    public static void renderBetterGrassSidesFast(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks, Icon icon) {
        float f = (float)Math.abs((n & 1) + (n3 & 1) * 2) * 0.08f;
        if (Block.lightOpacity[iBlockAccess.getBlockId(n, n2, n3 - 1)] == 0 && iBlockAccess.getBlockId(n, n2 - 1, n3 - 1) == block.blockID) {
            BetterGrassRenderer.renderOvergrowthZNeg(icon, (double)n + 0.5, (double)n2 + 1.0, n3, 0.5, f - 3.1f, false, true);
        }
        if (Block.lightOpacity[iBlockAccess.getBlockId(n, n2, n3 + 1)] == 0 && iBlockAccess.getBlockId(n, n2 - 1, n3 + 1) == block.blockID) {
            BetterGrassRenderer.renderOvergrowthZPos(icon, (double)n + 0.5, (double)n2 + 1.0, (double)n3 + 1.0, 0.5, f - 3.1f, false, true);
        }
        if (Block.lightOpacity[iBlockAccess.getBlockId(n - 1, n2, n3)] == 0 && iBlockAccess.getBlockId(n - 1, n2 - 1, n3) == block.blockID) {
            BetterGrassRenderer.renderOvergrowthXNeg(icon, n, (double)n2 + 1.0, (double)n3 + 0.5, 0.5, f - 3.1f, false, true);
        }
        if (Block.lightOpacity[iBlockAccess.getBlockId(n + 1, n2, n3)] == 0 && iBlockAccess.getBlockId(n + 1, n2 - 1, n3) == block.blockID) {
            BetterGrassRenderer.renderOvergrowthXPos(icon, (double)n + 1.0, (double)n2 + 1.0, (double)n3 + 0.5, 0.5, f - 3.1f, false, true);
        }
    }

    public static void renderBetterGrassSidesFancy(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, Icon icon) {
        float f = (float)Math.abs((n & 1) + (n3 & 1) * 2) * 0.2f;
        int n4 = iBlockAccess.getBlockId(n, n2, n3 - 1);
        if (n4 != block.blockID && !Block.opaqueCubeLookup[iBlockAccess.getBlockId(n, n2 + 1, n3 - 1)]) {
            BetterGrassRenderer.renderOvergrowthZNeg(icon, (double)n + 0.5, (double)n2 + 1.0, n3, 0.707, f - 0.8f, false, false);
            if (!Block.opaqueCubeLookup[n4]) {
                BetterGrassRenderer.renderOvergrowthZNeg(icon, (double)n + 0.5, (double)n2 + 1.0, n3, 0.707, f - 2.8f, true, false);
            }
        }
        if ((n4 = iBlockAccess.getBlockId(n, n2, n3 + 1)) != block.blockID && !Block.opaqueCubeLookup[iBlockAccess.getBlockId(n, n2 + 1, n3 + 1)]) {
            BetterGrassRenderer.renderOvergrowthZPos(icon, (double)n + 0.5, (double)n2 + 1.0, (double)n3 + 1.0, 0.707, f - 0.8f, false, false);
            if (!Block.opaqueCubeLookup[n4]) {
                BetterGrassRenderer.renderOvergrowthZPos(icon, (double)n + 0.5, (double)n2 + 1.0, (double)n3 + 1.0, 0.707, f - 2.8f, true, false);
            }
        }
        if ((n4 = iBlockAccess.getBlockId(n - 1, n2, n3)) != block.blockID && !Block.opaqueCubeLookup[iBlockAccess.getBlockId(n - 1, n2 + 1, n3)]) {
            BetterGrassRenderer.renderOvergrowthXNeg(icon, n, (double)n2 + 1.0, (double)n3 + 0.5, 0.707, f - 0.8f, false, false);
            if (!Block.opaqueCubeLookup[n4]) {
                BetterGrassRenderer.renderOvergrowthXNeg(icon, n, (double)n2 + 1.0, (double)n3 + 0.5, 0.707, f - 2.8f, true, false);
            }
        }
        if ((n4 = iBlockAccess.getBlockId(n + 1, n2, n3)) != block.blockID && !Block.opaqueCubeLookup[iBlockAccess.getBlockId(n + 1, n2 + 1, n3)]) {
            BetterGrassRenderer.renderOvergrowthXPos(icon, (double)n + 1.0, (double)n2 + 1.0, (double)n3 + 0.5, 0.707, f - 0.8f, false, false);
            if (!Block.opaqueCubeLookup[n4]) {
                BetterGrassRenderer.renderOvergrowthXPos(icon, (double)n + 1.0, (double)n2 + 1.0, (double)n3 + 0.5, 0.707, f - 2.8f, true, false);
            }
        }
    }

    public static void renderOvergrowthXNeg(Icon icon, double d, double d2, double d3, double d4, float f, boolean bl, boolean bl2) {
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
        double d9 = d + (double)sajh._a(f) * d4 * 2.0;
        double d10 = d2 + (double)sajh._b(f) * d4 * 2.0;
        double d11 = d3 - d4;
        double d12 = d3 + d4;
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d10, d12, d7, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d, d2, d12, d7, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d, d2, d11, d8, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d10, d11, d8, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d10, d11, d8, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d, d2, d11, d8, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d, d2, d12, d7, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d10, d12, d7, d6);
    }

    public static void renderOvergrowthXPos(Icon icon, double d, double d2, double d3, double d4, float f, boolean bl, boolean bl2) {
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
        double d9 = d - (double)sajh._a(f) * d4 * 2.0;
        double d10 = d2 + (double)sajh._b(f) * d4 * 2.0;
        double d11 = d3 - d4;
        double d12 = d3 + d4;
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d10, d12, d7, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d, d2, d12, d7, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d, d2, d11, d8, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d10, d11, d8, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d10, d11, d8, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d, d2, d11, d8, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d, d2, d12, d7, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d10, d12, d7, d6);
    }

    public static void renderOvergrowthZNeg(Icon icon, double d, double d2, double d3, double d4, float f, boolean bl, boolean bl2) {
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
        double d11 = d2 + (double)sajh._b(f) * d4 * 2.0;
        double d12 = d3 + (double)sajh._a(f) * d4 * 2.0;
        BlockRenderer.tessellator.get().addVertexWithUV(d10, d11, d12, d7, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d10, d2, d3, d7, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d2, d3, d8, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d11, d12, d8, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d11, d12, d8, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d2, d3, d8, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d10, d2, d3, d7, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d10, d11, d12, d7, d6);
    }

    public static void renderOvergrowthZPos(Icon icon, double d, double d2, double d3, double d4, float f, boolean bl, boolean bl2) {
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
        double d11 = d2 + (double)sajh._b(f) * d4 * 2.0;
        double d12 = d3 - (double)sajh._a(f) * d4 * 2.0;
        BlockRenderer.tessellator.get().addVertexWithUV(d10, d11, d12, d7, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d10, d2, d3, d7, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d2, d3, d8, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d11, d12, d8, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d11, d12, d8, d6);
        BlockRenderer.tessellator.get().addVertexWithUV(d9, d2, d3, d8, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d10, d2, d3, d7, d5);
        BlockRenderer.tessellator.get().addVertexWithUV(d10, d11, d12, d7, d6);
    }

    protected int getTextureHeight(BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (bufferedImage.getRGB(j, i) >> 24 == 0) continue;
                return n - i;
            }
        }
        return 0;
    }

    @Override
    public BufferedImage onTextureLoading(TextureAtlasSprite textureAtlasSprite, BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        BufferedImage bufferedImage2 = new BufferedImage(n, n, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.drawImage(bufferedImage, null, 0, (int)((float)this.getTextureHeight(bufferedImage) * (textureAtlasSprite.getIconName().endsWith("_short") ? 0.7f : 0.5f)));
        graphics2D.dispose();
        return bufferedImage2;
    }

    @Override
    public Icon getIconBetterGrass(int n, float f) {
        return iconBetterGrass != null ? iconBetterGrass[(int)(f * (float)(iconBetterGrass.length - 1) + 0.5f)] : null;
    }

    @Override
    public Icon getIconBetterGrassSnowed(int n, float f) {
        return iconBetterGrassSnowed == null ? null : iconBetterGrassSnowed[(int)(f * (float)(iconBetterGrassSnowed.length - 1) + 0.5f)];
    }

    @Override
    public Icon getIconBetterGrassSide(int n, float f) {
        return iconBetterGrassSide == null ? null : iconBetterGrassSide[(int)(f * (float)(iconBetterGrassSide.length - 1) + 0.5f)];
    }
}

