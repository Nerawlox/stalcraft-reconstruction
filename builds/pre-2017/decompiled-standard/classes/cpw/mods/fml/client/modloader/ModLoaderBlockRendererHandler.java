/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client.modloader;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.src.BaseMod;

public class ModLoaderBlockRendererHandler
implements ISimpleBlockRenderingHandler {
    private int renderId;
    private boolean render3dInInventory;
    private BaseMod mod;

    public ModLoaderBlockRendererHandler(int n, boolean bl, BaseMod baseMod) {
        this.renderId = n;
        this.render3dInInventory = bl;
        this.mod = baseMod;
    }

    @Override
    public int getRenderId() {
        return this.renderId;
    }

    @Override
    public boolean shouldRender3DInInventory() {
        return this.render3dInInventory;
    }

    @Override
    public boolean renderWorldBlock(sdrg sdrg2, int n, int n2, int n3, twgu twgu2, int n4, htvc htvc2) {
        return this.mod.renderWorldBlock(htvc2, sdrg2, n, n2, n3, twgu2, n4);
    }

    @Override
    public void renderInventoryBlock(twgu twgu2, int n, int n2, htvc htvc2) {
        this.mod.renderInvBlock(htvc2, twgu2, n, n2);
    }
}

