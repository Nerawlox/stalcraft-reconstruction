/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingGrassFancyFX;
import poersch.minecraft.bettergrassandleaves.entity.EntityMovingGrassFastFX;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterMycelium;
import poersch.minecraft.bettergrassandleaves.renderer.BetterGrassRenderer;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;

public class BetterMyceliumRenderer
extends BlockRenderer
implements IBetterMycelium {
    public static Icon[] iconBetterMycelium;
    public static Icon[] iconBetterMyceliumSide;
    public static Icon[] iconBetterMyceliumSnowed;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        iconBetterMycelium = BetterMyceliumRenderer.registerBlockIcons("better_mycel");
        iconBetterMyceliumSide = BetterMyceliumRenderer.registerBlockIcons("better_mycel_side");
        iconBetterMyceliumSnowed = BetterMyceliumRenderer.registerBlockIcons("better_mycel_snowed");
    }

    @Override
    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterGrass.value).booleanValue()) {
            return false;
        }
        int n4 = iBlockAccess.getBlockId(n, n2 + 1, n3);
        if (n4 != Block.snow.blockID) {
            long l;
            IBetterMycelium iBetterMycelium = block instanceof IBetterMycelium ? (IBetterMycelium)((Object)block) : this;
            Icon icon = ((IBetterMycelium)iBetterMycelium).getIconBetterMycelium(0, (float)((l = BetterMyceliumRenderer.getRandomOffsetForPosition(n, n2, n3)) >> 12 & 0xFL) / 15.0f);
            if (icon == null) {
                return false;
            }
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 + 1, n3));
            BlockRenderer.tessellator.get().setColorOpaque_F(1.0f, 1.0f, 1.0f);
            if (!iBlockAccess.isBlockOpaqueCube(n, n2 + 1, n3) && (Integer)BetterGrassAndLeavesMod.renderGrassSides.value > 0) {
                if ((Integer)BetterGrassAndLeavesMod.renderGrassSides.value == 1) {
                    Icon icon2 = ((IBetterMycelium)iBetterMycelium).getIconBetterMyceliumSide(iBlockAccess.getBlockMetadata(n, n2, n3), (float)(l >> 4 & 0xFL) / 15.0f);
                    if (icon2 != null) {
                        BetterGrassRenderer.renderBetterGrassSidesFast(block, iBlockAccess, n, n2, n3, renderBlocks, icon2);
                    }
                } else {
                    BetterGrassRenderer.renderBetterGrassSidesFancy(block, iBlockAccess, n, n2, n3, icon);
                }
            }
            if (((Boolean[])BetterGrassAndLeavesMod.allowBetterGrass.value)[n4].booleanValue()) {
                double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
                double d2 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
                double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
                boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
                BetterMyceliumRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
                this.renderCrossedQuadsY(icon, d, d2, d3, bl, false);
            }
        } else if (((Boolean)BetterGrassAndLeavesMod.renderSnowedGrass.value).booleanValue()) {
            long l;
            IBetterMycelium iBetterMycelium = block instanceof IBetterMycelium ? (IBetterMycelium)((Object)block) : this;
            Icon icon = ((IBetterMycelium)iBetterMycelium).getIconBetterMyceliumSnowed(0, (float)((l = BetterMyceliumRenderer.getRandomOffsetForPosition(n, n2, n3)) >> 12 & 0xFL) / 15.0f);
            if (icon == null) {
                return false;
            }
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2 + 1, n3));
            BlockRenderer.tessellator.get().setColorOpaque_F(1.0f, 1.0f, 1.0f);
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d4 = (double)n2 + 1.707 - (double)((float)(l >> 20 & 0xFL) / 15.0f) * 0.16;
            double d5 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.3;
            boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            BetterMyceliumRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap24px, n, n2, n3);
            this.renderCrossedQuadsY(icon, d, d4, d5, bl, false);
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
            long l;
            IBetterMycelium iBetterMycelium = block instanceof IBetterMycelium ? (IBetterMycelium)((Object)block) : this;
            Icon icon = iBetterMycelium.getIconBetterMycelium(0, (float)((l = BetterMyceliumRenderer.getRandomOffsetForPosition(n, n2, n3)) >> 12 & 0xFL) / 15.0f);
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
        }
        return false;
    }

    @Override
    public Icon getIconBetterMyceliumSide(int n, float f) {
        return iconBetterMyceliumSide == null ? null : iconBetterMyceliumSide[(int)(f * (float)(iconBetterMyceliumSide.length - 1) + 0.5f)];
    }

    @Override
    public Icon getIconBetterMycelium(int n, float f) {
        return iconBetterMycelium == null ? null : iconBetterMycelium[(int)(f * (float)(iconBetterMycelium.length - 1) + 0.5f)];
    }

    @Override
    public Icon getIconBetterMyceliumSnowed(int n, float f) {
        return iconBetterMyceliumSnowed == null ? null : iconBetterMyceliumSnowed[(int)(f * (float)(iconBetterMyceliumSnowed.length - 1) + 0.5f)];
    }
}

