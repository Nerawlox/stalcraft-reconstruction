/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.entity.EntityFallingLeavesFancyFX;
import poersch.minecraft.bettergrassandleaves.entity.EntityFallingLeavesFastFX;
import poersch.minecraft.bettergrassandleaves.interfaces.IBetterLeaves;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.ResourceHelper;
import poersch.minecraft.util.StringHelper;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterLeavesRenderer
extends BlockRenderer
implements IBetterLeaves,
ITextureLoadingCallback {
    public static Icon[][] iconBetterLeaves;
    public static Icon[] iconFallingLeaves;
    public static Icon[] iconBetterLeavesSnowed;
    public static Icon[] iconRoundedLeaves;
    protected static Map<String, Icon[]> iconMap;
    public static HashSet<Block> leafBlocks;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        marn marn2 = Block.leaves;
        iconRoundedLeaves = new Icon[marn._a.length];
        int n = 0;
        while (true) {
            marn marn3 = Block.leaves;
            if (n >= marn._a.length) {
                marn2 = Block.leaves;
                iconFallingLeaves = new Icon[marn._a.length];
                n = 0;
                while (true) {
                    marn marn4;
                    StringBuilder stringBuilder;
                    marn3 = Block.leaves;
                    if (n >= marn._a.length) {
                        marn2 = Block.leaves;
                        iconBetterLeaves = new Icon[marn._a.length][];
                        for (n = 0; n < iconBetterLeaves.length; ++n) {
                            Icon[][] iconArray = iconBetterLeaves;
                            stringBuilder = new StringBuilder().append("better_leaves_");
                            marn4 = Block.leaves;
                            String string = stringBuilder.append(marn._a[n]).toString();
                            StringBuilder stringBuilder2 = new StringBuilder().append("leaves_");
                            marn marn5 = Block.leaves;
                            iconArray[n] = BetterLeavesRenderer.registerBlockIconsOrCallbackIfAllowed(string, stringBuilder2.append(marn._a[n]).toString(), this);
                            if (iconArray[n] != null) continue;
                            BetterLeavesRenderer.iconBetterLeaves[n] = new Icon[]{null};
                        }
                        iconBetterLeavesSnowed = BetterLeavesRenderer.registerBlockIcons("better_leaves_snowed");
                        for (Block block : leafBlocks) {
                            BlockRenderer.leavesRenderer.assignToBlockID(block.blockID);
                        }
                        return;
                    }
                    Icon[] iconArray = iconFallingLeaves;
                    stringBuilder = new StringBuilder().append("falling_leaves_");
                    marn4 = Block.leaves;
                    iconArray[n] = BetterLeavesRenderer.registerBlockIcon(stringBuilder.append(marn._a[n]).toString());
                    ++n;
                }
            }
            ++n;
        }
    }

    public static void resetBetterLeavesLinkage() {
        iconMap.clear();
    }

    public static void linkBetterLeavesTo(IconRegister iconRegister, String string) {
        List<String> list2 = StringHelper.splitTrimToList(string, ':');
        Icon[] iconArray = null;
        if (list2.size() > 1 && (iconArray = ResourceHelper.registerIconsOrCallback(iconRegister, list2.get(0), "textures/blocks/", "better_" + list2.get(1), "textures/blocks/", list2.get(1), (ITextureLoadingCallback)BlockRenderer.leavesRenderer.get(0))) != null) {
            iconMap.put(list2.get(0).equals("minecraft") ? list2.get(1).toLowerCase() : (list2.get(0) + ":" + list2.get(1)).toLowerCase(), iconArray);
        }
    }

    protected static Icon getIconFromMap(String string, float f) {
        Icon[] iconArray = iconMap.get(string.toLowerCase());
        return iconArray != null ? iconArray[(int)(f * (float)(iconArray.length - 1) + 0.5f)] : null;
    }

    @Override
    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        if (!((Boolean)BetterGrassAndLeavesMod.renderBetterLeaves.value).booleanValue()) {
            return false;
        }
        block.setBlockBoundsBasedOnState(iBlockAccess, n, n2, n3);
        renderBlocks._a(block);
        renderBlocks._q(block, n, n2, n3);
        int n4 = BetterLeavesRenderer.blockHasVisibleSide(block, iBlockAccess, n, n2, n3);
        if (n4 > -1) {
            IBetterLeaves iBetterLeaves = block instanceof IBetterLeaves ? (IBetterLeaves)((Object)block) : this;
            long l = BetterLeavesRenderer.getRandomOffsetForPosition(n, n2, n3);
            int n5 = iBlockAccess.getBlockMetadata(n, n2, n3);
            float f = (float)(l >> 12 & 0xFL) / 15.0f;
            Icon icon = iBetterLeaves.getIconBetterLeaves(n5, f);
            if (icon == null && (icon = BetterLeavesRenderer.getIconFromMap(block.getIcon(0, n5).getIconName(), f)) == null) {
                icon = block.getIcon(0, n5);
            }
            double d = (double)n + 0.5 + ((double)((float)(l >> 16 & 0xFL) / 15.0f) - 0.5) * 0.45;
            double d2 = (double)n2 + 0.5 + ((double)((float)(l >> 20 & 0xFL) / 15.0f) - 0.5) * 0.3;
            double d3 = (double)n3 + 0.5 + ((double)((float)(l >> 24 & 0xFL) / 15.0f) - 0.5) * 0.45;
            int n6 = block.colorMultiplier(iBlockAccess, n, n2, n3);
            float f2 = (float)(n6 >> 16 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            float f3 = (float)(n6 >> 8 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            float f4 = (float)(n6 & 0xFF) * 0.00392f * ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue();
            boolean bl = (float)(l >> 8 & 0xFL) / 15.0f < 0.5f;
            boolean bl2 = (float)(l >> 4 & 0xFL) / 15.0f < 0.5f;
            BetterLeavesRenderer.setRotationalOffsetMap(BlockRenderer.offsetMap32px, n, n2, n3);
            if (!block.isOpaqueCube()) {
                BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3));
            } else {
                BlockRenderer.tessellator.get().setBrightness(n4);
            }
            Minecraft minecraft = this.minecraft;
            if (Minecraft._C()) {
                this.renderCrossedQuadsShadedY(icon, d, d2, d3, bl, bl2, f2, f3, f4, f2 * 0.58f, f3 * 0.58f, f4 * 0.58f);
            } else {
                BlockRenderer.tessellator.get().setColorOpaque_F(f2 * 0.78f, f3 * 0.78f, f4 * 0.78f);
                this.renderCrossedQuadsY(icon, d, d2, d3, bl, bl2);
            }
            if (((Boolean)BetterGrassAndLeavesMod.renderSnowedLeaves.value).booleanValue() && iBlockAccess.getBlockId(n, n2 + 1, n3) == Block.snow.blockID) {
                icon = iBetterLeaves.getIconBetterLeavesSnowed(0, (float)(l >> 12 & 0xFL) / 15.0f);
                if (icon == null) {
                    return false;
                }
                BlockRenderer.tessellator.get().setColorOpaque_F(1.0f, 1.0f, 1.0f);
                minecraft = this.minecraft;
                if (Minecraft._C()) {
                    this.renderCrossedQuadsShadedY(icon, d, d2, d3, bl, false, 1.0f, 1.0f, 1.0f, 0.58f, 0.58f, 0.58f);
                } else {
                    BlockRenderer.tessellator.get().setColorOpaque_F(0.78f, 0.78f, 0.78f);
                    this.renderCrossedQuadsY(icon, d, d2, d3, bl, false);
                }
            }
            return true;
        }
        return (Boolean)BetterGrassAndLeavesMod.renderOnlyOuterLeaves.value;
    }

    @Override
    public boolean onRandomDisplayTick(Block block, World world, int n, int n2, int n3, Random random) {
        if ((Integer)BetterGrassAndLeavesMod.renderLeavesFX.value == 0) {
            return false;
        }
        if (world.isAirBlock(n, n2 - 1, n3)) {
            IBetterLeaves iBetterLeaves = block instanceof IBetterLeaves ? (IBetterLeaves)((Object)block) : this;
            int n4 = world.getBlockMetadata(n, n2, n3);
            if (random.nextFloat() > 1.0f - BetterLeavesRenderer.combineSpawnRates(iBetterLeaves.getSpawnChanceFallingLeaves(n4), ((Float)BetterGrassAndLeavesMod.leavesFXSpawnRate.value).floatValue())) {
                Icon icon = iBetterLeaves.getIconFallingLeaves(n4);
                if (icon == null && (icon = block.getIcon(0, n4)) == null) {
                    return false;
                }
                double d = (double)n + 0.1 + random.nextDouble() * 0.8;
                double d2 = (double)n2 + 0.16;
                double d3 = (double)n3 + 0.1 + random.nextDouble() * 0.8;
                float f = (float)icon.getIconWidth() / (float)block.getIcon(0, n4).getIconWidth();
                if ((Integer)BetterGrassAndLeavesMod.renderLeavesFX.value == 1) {
                    this.minecraft._w._a(new EntityFallingLeavesFastFX(world, d, d2, d3, f, ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue(), block.colorMultiplier(world, n, n2, n3), icon));
                } else {
                    this.minecraft._w._a(new EntityFallingLeavesFancyFX(world, d, d2, d3, f, ((Float)BetterGrassAndLeavesMod.betterLeavesBrightness.value).floatValue(), block.colorMultiplier(world, n, n2, n3), icon));
                }
            }
        }
        return false;
    }

    public static int blockHasVisibleSide(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3) {
        int n4 = iBlockAccess.getBlockId(n, n2 + 1, n3);
        if (n4 != block.blockID && !Block.opaqueCubeLookup[n4]) {
            return block.getMixedBrightnessForBlock(iBlockAccess, n, n2 + 1, n3);
        }
        n4 = iBlockAccess.getBlockId(n + 1, n2, n3);
        if (n4 != block.blockID && !Block.opaqueCubeLookup[n4]) {
            return block.getMixedBrightnessForBlock(iBlockAccess, n + 1, n2, n3);
        }
        n4 = iBlockAccess.getBlockId(n - 1, n2, n3);
        if (n4 != block.blockID && !Block.opaqueCubeLookup[n4]) {
            return block.getMixedBrightnessForBlock(iBlockAccess, n - 1, n2, n3);
        }
        n4 = iBlockAccess.getBlockId(n, n2, n3 + 1);
        if (n4 != block.blockID && !Block.opaqueCubeLookup[n4]) {
            return block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3 + 1);
        }
        n4 = iBlockAccess.getBlockId(n, n2, n3 - 1);
        if (n4 != block.blockID && !Block.opaqueCubeLookup[n4]) {
            return block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3 - 1);
        }
        n4 = iBlockAccess.getBlockId(n, n2 - 1, n3);
        return n4 != block.blockID && !Block.opaqueCubeLookup[n4] ? block.getMixedBrightnessForBlock(iBlockAccess, n, n2 - 1, n3) : -1;
    }

    @Override
    public BufferedImage onTextureLoading(TextureAtlasSprite textureAtlasSprite, BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        int n2 = textureAtlasSprite.getIconName().startsWith("better_") ? n * 2 : n;
        BufferedImage bufferedImage2 = new BufferedImage(n2, n2, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.setClip(new Ellipse2D.Double(0.0, 0.0, n2, n2));
        for (int i = 0; i < n2; i += n) {
            for (int j = 0; j < n2; j += n) {
                graphics2D.drawImage(bufferedImage, null, j, i);
            }
        }
        graphics2D.dispose();
        return bufferedImage2;
    }

    @Override
    public Icon getIconBetterLeaves(int n, float f) {
        return null;
    }

    @Override
    public Icon getIconBetterLeavesSnowed(int n, float f) {
        return iconBetterLeavesSnowed == null ? null : iconBetterLeavesSnowed[(int)(f * (float)(iconBetterLeavesSnowed.length - 1) + 0.5f)];
    }

    @Override
    public Icon getIconFallingLeaves(int n) {
        return null;
    }

    @Override
    public float getSpawnChanceFallingLeaves(int n) {
        return 0.008f;
    }

    static {
        iconMap = new HashMap<String, Icon[]>();
        leafBlocks = new HashSet();
    }
}

