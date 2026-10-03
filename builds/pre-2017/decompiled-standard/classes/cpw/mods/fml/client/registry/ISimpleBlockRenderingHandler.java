/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client.registry;

public interface ISimpleBlockRenderingHandler {
    public void renderInventoryBlock(twgu var1, int var2, int var3, htvc var4);

    public boolean renderWorldBlock(sdrg var1, int var2, int var3, int var4, twgu var5, int var6, htvc var7);

    public boolean shouldRender3DInInventory();

    public int getRenderId();
}

