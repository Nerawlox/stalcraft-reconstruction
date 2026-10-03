/*
 * Decompiled with CFR 0.152.
 */
package com.stalcraft.renderer;

import com.stalcraft.StalcraftMod;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import gloomyfolken.mods.core.misc.srok;
import net.minecraft.util.dwan;

public class RenderTallGrass
implements ISimpleBlockRenderingHandler {
    public static RenderTallGrass instance = new RenderTallGrass();

    @Override
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
    }

    @Override
    public boolean renderWorldBlock(sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4, htvc htvc2) {
        long l = srok._a(n, n2, n3);
        float f = srok._a(l) - 0.5f;
        float f2 = srok._b(l) - 0.5f;
        htvf htvf2 = htvc2.__aF;
        htvf2.func_78372_c(f, 0.0f, f2);
        htvc2._l(twgu2, n, n2 + 1, n3);
        htvc2._a(StalcraftMod.tallGrass.bottomIcon);
        htvc2._l(twgu2, n, n2, n3);
        htvc2._a((dwan)null);
        htvf2.func_78372_c(-f, 0.0f, -f2);
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return false;
    }

    @Override
    public int getRenderId() {
        return 265;
    }
}

