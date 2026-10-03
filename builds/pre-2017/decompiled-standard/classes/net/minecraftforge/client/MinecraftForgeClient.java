/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client;

import java.util.BitSet;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;

public class MinecraftForgeClient {
    private static IItemRenderer[] customItemRenderers = new IItemRenderer[tgdv.field_77698_e.length];
    private static BitSet stencilBits = new BitSet(MinecraftForgeClient.getStencilBits());

    public static void registerItemRenderer(int n, IItemRenderer iItemRenderer) {
        MinecraftForgeClient.customItemRenderers[n] = iItemRenderer;
    }

    public static IItemRenderer getItemRenderer(cvzo cvzo2, IItemRenderer.ItemRenderType itemRenderType) {
        IItemRenderer iItemRenderer = customItemRenderers[cvzo2._d];
        if (iItemRenderer != null && iItemRenderer.handleRenderType(cvzo2, itemRenderType)) {
            return customItemRenderers[cvzo2._d];
        }
        return null;
    }

    public static int getRenderPass() {
        return ForgeHooksClient.renderPass;
    }

    public static int getStencilBits() {
        return ForgeHooksClient.stencilBits;
    }

    public static int reserveStencilBit() {
        int n = stencilBits.nextSetBit(0);
        if (n >= 0) {
            stencilBits.clear(n);
        }
        return n;
    }

    public static void releaseStencilBit(int n) {
        if (n >= 0 && n < MinecraftForgeClient.getStencilBits()) {
            stencilBits.set(n);
        }
    }

    static {
        stencilBits.set(0, MinecraftForgeClient.getStencilBits());
    }
}

