/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.awt.image.BufferedImage;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.BetterGrassAndLeavesMod;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.ResourceHelper;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterLadderRenderer
extends BlockRenderer
implements ITextureLoadingCallback {
    public static boolean[][] segments;

    @Override
    public void onRegisterIcons(nege nege2) {
        segments = null;
        ResourceHelper.registerIconCallback(nege2, "minecraft", "textures/blocks/", "ladder", "minecraft", "textures/blocks/", "ladder", this);
    }

    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        if (((Boolean)BetterGrassAndLeavesMod.renderBetterLadders.value).booleanValue() && segments != null) {
            dwan dwan2 = twgu2.func_71851_a(0);
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3));
            switch (sdrg2.func_72805_g(n, n2, n3)) {
                case 2: {
                    BetterLadderRenderer.render3DFaceZ(dwan2, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.96875, segments, 0.0625, 1.0f, 1.0f, 1.0f, true, false);
                    return true;
                }
                case 3: {
                    BetterLadderRenderer.render3DFaceZ(dwan2, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.03125, segments, 0.0625, 1.0f, 1.0f, 1.0f, false, false);
                    return true;
                }
                case 4: {
                    BetterLadderRenderer.render3DFaceX(dwan2, (double)n + 0.96875, (double)n2 + 0.5, (double)n3 + 0.5, segments, 0.0625, 1.0f, 1.0f, 1.0f, true, false);
                    return true;
                }
                case 5: {
                    BetterLadderRenderer.render3DFaceX(dwan2, (double)n + 0.03125, (double)n2 + 0.5, (double)n3 + 0.5, segments, 0.0625, 1.0f, 1.0f, 1.0f, false, false);
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public BufferedImage onTextureLoading(dhji dhji2, BufferedImage bufferedImage) {
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
                BetterLadderRenderer.segments[n3][0] = true;
                ++n5;
                continue block0;
            }
        }
        block2: for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                n = nArray[n3 * n4 + n2] >> 24 & 0xFF;
                if (n <= 0 || n3 != n7 && (nArray[(n3 + 1) * n4 + n2] >> 24 & 0xFF) == n) continue;
                BetterLadderRenderer.segments[n7 - n3][1] = true;
                ++n5;
                continue block2;
            }
        }
        block4: for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                n = nArray[n2 * n4 + n3] >> 24 & 0xFF;
                if (n <= 0 || n3 != n6 && (nArray[n2 * n4 + n3 - 1] >> 24 & 0xFF) == n) continue;
                BetterLadderRenderer.segments[n3][2] = true;
                ++n5;
                continue block4;
            }
        }
        block6: for (n3 = 0; n3 < n4; ++n3) {
            for (n2 = 0; n2 < n4; ++n2) {
                n = nArray[n2 * n4 + n3] >> 24 & 0xFF;
                if (n <= 0 || n3 != n7 && (nArray[n2 * n4 + n3 + 1] >> 24 & 0xFF) == n) continue;
                BetterLadderRenderer.segments[n7 - n3][3] = true;
                ++n5;
                continue block6;
            }
        }
        return bufferedImage;
    }
}

