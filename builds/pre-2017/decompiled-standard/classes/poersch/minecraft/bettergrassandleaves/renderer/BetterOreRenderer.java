/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.bettergrassandleaves.renderer;

import java.awt.image.BufferedImage;
import net.minecraft.util.dwan;
import poersch.minecraft.bettergrassandleaves.renderer.BlockRenderer;
import poersch.minecraft.util.ResourceHelper;
import poersch.minecraft.util.texture.ITextureLoadingCallback;

public class BetterOreRenderer
extends BlockRenderer
implements ITextureLoadingCallback {
    public static dwan iconBetterIronOre;
    public static boolean[][] segments;

    @Override
    public void onRegisterIcons(nege nege2) {
        segments = null;
        iconBetterIronOre = ResourceHelper.registerIconCallback(nege2, "bettergrassandleaves", "textures/blocks/", "better_iron_ore", "bettergrassandleaves", "textures/blocks/", "better_iron_ore", this);
    }

    @Override
    public boolean onRenderBlock(twgu twgu2, sdrg sdrg2, int n, int n2, int n3, htvc htvc2) {
        dwan dwan2 = iconBetterIronOre;
        if (twgu.field_71971_o[sdrg2.func_72798_a(n - 1, n2, n3)] == 0) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n - 1, n2, n3));
            BetterOreRenderer.render3DFaceX(dwan2, (double)n - 0.03125, (double)n2 + 0.5, (double)n3 + 0.5, segments, 0.0625, 1.0f, 1.0f, 1.0f, true, false);
        }
        if (twgu.field_71971_o[sdrg2.func_72798_a(n + 1, n2, n3)] == 0) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n + 1, n2, n3));
            BetterOreRenderer.render3DFaceX(dwan2, (double)n + 1.03125, (double)n2 + 0.5, (double)n3 + 0.5, segments, 0.0625, 1.0f, 1.0f, 1.0f, false, false);
        }
        if (twgu.field_71971_o[sdrg2.func_72798_a(n, n2, n3 - 1)] == 0) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3 - 1));
            BetterOreRenderer.render3DFaceZ(dwan2, (double)n + 0.5, (double)n2 + 0.5, (double)n3 - 0.03125, segments, 0.0625, 1.0f, 1.0f, 1.0f, true, false);
        }
        if (twgu.field_71971_o[sdrg2.func_72798_a(n, n2, n3 + 1)] == 0) {
            BlockRenderer.tessellator.get().func_78380_c(twgu2.func_71874_e(sdrg2, n, n2, n3 + 1));
            BetterOreRenderer.render3DFaceZ(dwan2, (double)n + 0.5, (double)n2 + 0.5, (double)n3 + 1.03125, segments, 0.0625, 1.0f, 1.0f, 1.0f, false, false);
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

