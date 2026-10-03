/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class ClientRegistry {
    public static void registerTileEntity(Class<? extends TileEntity> clazz, String string, TileEntitySpecialRenderer tileEntitySpecialRenderer) {
        GameRegistry.registerTileEntity(clazz, string);
        ClientRegistry.bindTileEntitySpecialRenderer(clazz, tileEntitySpecialRenderer);
    }

    public static void bindTileEntitySpecialRenderer(Class<? extends TileEntity> clazz, TileEntitySpecialRenderer tileEntitySpecialRenderer) {
        TileEntityRenderer._b._a.put(clazz, tileEntitySpecialRenderer);
        tileEntitySpecialRenderer.setTileEntityRenderer(TileEntityRenderer._b);
    }
}

