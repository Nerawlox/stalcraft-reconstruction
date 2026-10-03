/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityRisingBubbleSpawnerFX;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterCorals;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterCoralsRenderer
extends BlockRenderer
implements IBetterCorals {
    public static Icon[] iconBetterCorals;
    public static Icon[] iconBetterCrust;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        iconBetterCorals = BetterCoralsRenderer.registerBlockIcons("better_coral");
        iconBetterCrust = BetterCoralsRenderer.registerBlockIcons("better_crust");
    }

    @Override
    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        if (((Boolean)BetterGrassAndLeavesMod.renderBetterCorals.value).booleanValue() && ((Float)BetterGrassAndLeavesMod.coralPopulation.value).floatValue() != 0.0f && ((Boolean[])BetterGrassAndLeavesMod.coralHostingBiomes.value)[iBlockAccess.getBiomeGenForCoords((int)n, (int)n3)._P].booleanValue() && (float)n2 >= ((Float)BetterGrassAndLeavesMod.maximumCoralDepth.value).floatValue() && (float)n2 <= ((Float)BetterGrassAndLeavesMod.minimumCoralDepth.value).floatValue()) {
            IBetterCorals iBetterCorals;
            IBetterCorals iBetterCorals2 = iBetterCorals = block instanceof IBetterCorals ? (IBetterCorals)((Object)block) : this;
            if (!iBlockAccess.isAirBlock(n, n2 + 1, n3)) {
                long l = BetterCoralsRenderer.getRandomOffsetForPosition(n, n2, n3);
                if ((float)(l >> 24 & 0xFL) / 15.0f > ((Float)BetterGrassAndLeavesMod.coralPopulation.value).floatValue()) {
                    return false;
                }
                Icon icon = iBetterCorals.getIconBetterCoral(0, (float)(l >> 20 & 0xFL) / 15.0f);
                Icon icon2 = iBetterCorals.getIconBetterCrust(0, (float)(l >> 24 & 0xFL) / 15.0f);
                if (icon == null || icon2 == null) {
                    return false;
                }
                BlockRenderer.tessellator.get().setColorOpaque_F(((Float)BetterGrassAndLeavesMod.betterCoralsBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterCoralsBrightness.value).floatValue(), ((Float)BetterGrassAndLeavesMod.betterCoralsBrightness.value).floatValue());
                double d = ((double)((float)(l & 0xFL) / 15.0f) - 0.5) * 0.3;
                double d2 = (double)((float)(l >> 4 & 0xFL) / 15.0f) * 0.16;
                double d3 = ((double)((float)(l >> 8 & 0xFL) / 15.0f) - 0.5) * 0.3;
                boolean bl = (float)(l >> 12 & 0xFL) / 15.0f < 0.5f;
                boolean bl2 = (float)(l >> 16 & 0xFL) / 15.0f < 0.5f;
                BetterCoralsRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap16px, n, n2, n3);
                if (iBlockAccess.getBlockMaterial(n, n2 + 1, n3) == Material._h) {
                    BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 + 1, n3));
                    BetterCoralsRenderer.setHeightOffsetMap(0.707, n, n3);
                    BetterCoralsRenderer.renderFaceYPos(icon2, (double)n + d, n2, (double)n3 + d3, bl, bl2);
                    this.renderCrossedQuadsY(icon, (double)n + 0.5 + d, (double)n2 + 1.4714 - d2, (double)n3 + 0.5 + d, bl, false);
                }
                if (iBlockAccess.getBlockMaterial(n - 1, n2, n3) == Material._h) {
                    BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n - 1, n2, n3));
                    BetterCoralsRenderer.setHeightOffsetMap(0.707, n3, n2);
                    BetterCoralsRenderer.renderFaceXNeg(icon2, n, (double)n2 + d3, (double)n3 - d, bl, bl2);
                    this.renderCrossedQuadsX(icon, (double)n - 0.4714 + d2, (double)n2 + 0.5 + d3, (double)n3 + 0.5 + d, bl, true);
                }
                if (iBlockAccess.getBlockMaterial(n + 1, n2, n3) == Material._h) {
                    BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n + 1, n2, n3));
                    BetterCoralsRenderer.setHeightOffsetMap(0.707, n3, n2);
                    BetterCoralsRenderer.renderFaceXPos(icon2, n, (double)n2 - d, (double)n3 - d3, bl, bl2);
                    this.renderCrossedQuadsX(icon, (double)n + 1.4714 - d2, (double)n2 + 0.5 + d3, (double)n3 + 0.5 + d, bl, false);
                }
                if (iBlockAccess.getBlockMaterial(n, n2, n3 - 1) == Material._h) {
                    BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3 - 1));
                    BetterCoralsRenderer.setHeightOffsetMap(0.707, n, n2);
                    BetterCoralsRenderer.renderFaceZNeg(icon2, (double)n + d3, (double)n2 + d, n3, bl, bl2);
                    this.renderCrossedQuadsZ(icon, (double)n + 0.5 + d, (double)n2 + 0.5 + d3, (double)n3 - 0.4714 + d2, bl, true);
                }
                if (iBlockAccess.getBlockMaterial(n, n2, n3 + 1) == Material._h) {
                    BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3 + 1));
                    BetterCoralsRenderer.setHeightOffsetMap(0.707, n, n2);
                    BetterCoralsRenderer.renderFaceZPos(icon2, (double)n + d, (double)n2 - d3, n3, bl, bl2);
                    this.renderCrossedQuadsZ(icon, (double)n + 0.5 + d, (double)n2 + 0.5 + d3, (double)n3 + 1.4714 - d2, bl, false);
                }
                if (iBlockAccess.getBlockMaterial(n, n2 - 1, n3) == Material._h) {
                    BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 - 1, n3));
                    BetterCoralsRenderer.setHeightOffsetMap(0.707, n, n3);
                    BetterCoralsRenderer.renderFaceYNeg(icon2, (double)n - d, n2, (double)n3 + d3, bl, bl2);
                    this.renderCrossedQuadsY(icon, (double)n + 0.5 + d, (double)n2 - 0.4714 + d2, (double)n3 + 0.5 + d, bl, true);
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean onRandomDisplayTick(Block block, World world, int n, int n2, int n3, Random random) {
        if (((Boolean)BetterGrassAndLeavesMod.renderBetterCorals.value).booleanValue() && ((Float)BetterGrassAndLeavesMod.coralPopulation.value).floatValue() != 0.0f && ((Boolean[])BetterGrassAndLeavesMod.coralHostingBiomes.value)[world.getBiomeGenForCoords((int)n, (int)n3)._P].booleanValue() && (float)n2 >= ((Float)BetterGrassAndLeavesMod.maximumCoralDepth.value).floatValue()) {
            if (world.getBlockMaterial(n, n2 + 1, n3) == Material._h) {
                long l = BetterCoralsRenderer.getRandomOffsetForPosition(n, n2, n3);
                if ((float)(l >> 24 & 0xFL) / 15.0f > ((Float)BetterGrassAndLeavesMod.coralPopulation.value).floatValue() || (float)(l >> 12 & 0xFL) / 15.0f <= 0.7f) {
                    return false;
                }
                if (random.nextFloat() > 1.0f - ((Float)BetterGrassAndLeavesMod.bubblesFXSpawnRate.value).floatValue() && ((int)(world.getTotalWorldTime() / 60L) & 4) == (int)((float)(l >> 8 & 0xFL) / 15.0f * 7.0f + 0.5f)) {
                    double d = (double)n + 0.4 + random.nextDouble() * 0.2 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.4;
                    double d2 = (double)n2 + 1.2;
                    double d3 = (double)n3 + 0.4 + random.nextDouble() * 0.2 + ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 0.5) * 0.4;
                    float f = (float)(l >> 24 & 0xFL) / 15.0f * 6.0f;
                    this.minecraft._w._a(new EntityRisingBubbleSpawnerFX(world, d, d2, d3, f, 9));
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public Icon getIconBetterCoral(int n, float f) {
        return iconBetterCorals == null ? null : iconBetterCorals[(int)(f * (float)(iconBetterCorals.length - 1) + 0.5f)];
    }

    @Override
    public Icon getIconBetterCrust(int n, float f) {
        return iconBetterCrust == null ? null : iconBetterCrust[(int)(f * (float)(iconBetterCrust.length - 1) + 0.5f)];
    }
}

