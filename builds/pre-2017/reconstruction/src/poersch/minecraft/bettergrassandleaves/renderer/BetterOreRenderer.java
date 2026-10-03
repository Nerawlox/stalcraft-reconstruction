/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.awt.image.BufferedImage;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.ResourceHelper;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterOreRenderer
extends BlockRenderer
implements ITextureLoadingCallback {
    public static Icon iconBetterIronOre;
    public static boolean[][] segments;

    @Override
    public void onRegisterIcons(IconRegister iconRegister) {
        segments = null;
        iconBetterIronOre = ResourceHelper.registerIconCallback(iconRegister, "bettergrassandleaves", "textures/blocks/", "better_iron_ore", "bettergrassandleaves", "textures/blocks/", "better_iron_ore", this);
    }

    @Override
    public boolean onRenderBlock(Block block, IBlockAccess iBlockAccess, int n, int n2, int n3, RenderBlocks renderBlocks) {
        Icon icon = iconBetterIronOre;
        if (Block.lightOpacity[iBlockAccess.getBlockId(n - 1, n2, n3)] == 0) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n - 1, n2, n3));
            BetterOreRenderer.render3DFaceX(icon, (double)n - 0.03125, (double)n2 + 0.5, (double)n3 + 0.5, segments, 0.0625, 1.0f, 1.0f, 1.0f, true, false);
        }
        if (Block.lightOpacity[iBlockAccess.getBlockId(n + 1, n2, n3)] == 0) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n + 1, n2, n3));
            BetterOreRenderer.render3DFaceX(icon, (double)n + 1.03125, (double)n2 + 0.5, (double)n3 + 0.5, segments, 0.0625, 1.0f, 1.0f, 1.0f, false, false);
        }
        if (Block.lightOpacity[iBlockAccess.getBlockId(n, n2, n3 - 1)] == 0) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3 - 1));
            BetterOreRenderer.render3DFaceZ(icon, (double)n + 0.5, (double)n2 + 0.5, (double)n3 - 0.03125, segments, 0.0625, 1.0f, 1.0f, 1.0f, true, false);
        }
        if (Block.lightOpacity[iBlockAccess.getBlockId(n, n2, n3 + 1)] == 0) {
            BlockRenderer.tessellator.get().setBrightness(block.getMixedBrightnessForBlock(iBlockAccess, n, n2, n3 + 1));
            BetterOreRenderer.render3DFaceZ(icon, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 1.03125, segments, 0.0625, 1.0f, 1.0f, 1.0f, false, false);
        }
        return false;
    }

    @Override
    public BufferedImage onTextureLoading(TextureAtlasSprite textureAtlasSprite, BufferedImage bufferedImage) {
        int n;
        int n2;
        int n3;
        int[] nArray = new int[bufferedImage.getHeight() * bufferedImage.getWidth()];
        bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), nArray, 0, bufferedImage.getWidth());
        int n4 = bufferedImage.getWidth();
        if (segments == null) {
            segments = new boolean[n4][4];
        }
        int n5 = 2;
        int n6 = 0;
        int n7 = n4 - 1;
        block0: for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                n = nArray[n3 * n4 + n2] >> 24 & 0xFF;
                if (n <= 0 || n3 != n6 && (nArray[(n3 - 1) * n4 + n2] >> 24 & 0xFF) == n) continue;
                BetterOreRenderer.segments[n3][0] = true;
                ++n5;
                continue block0;
            }
        }
        block2: for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                n = nArray[n3 * n4 + n2] >> 24 & 0xFF;
                if (n <= 0 || n3 != n7 && (nArray[(n3 + 1) * n4 + n2] >> 24 & 0xFF) == n) continue;
                BetterOreRenderer.segments[n7 - n3][1] = true;
                ++n5;
                continue block2;
            }
        }
        block4: for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                n = nArray[n2 * n4 + n3] >> 24 & 0xFF;
                if (n <= 0 || n3 != n6 && (nArray[n2 * n4 + n3 - 1] >> 24 & 0xFF) == n) continue;
                BetterOreRenderer.segments[n3][2] = true;
                ++n5;
                continue block4;
            }
        }
        block6: for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                n = nArray[n2 * n4 + n3] >> 24 & 0xFF;
                if (n <= 0 || n3 != n7 && (nArray[n2 * n4 + n3 + 1] >> 24 & 0xFF) == n) continue;
                BetterOreRenderer.segments[n7 - n3][3] = true;
                ++n5;
                continue block6;
            }
        }
        return bufferedImage;
    }
}

