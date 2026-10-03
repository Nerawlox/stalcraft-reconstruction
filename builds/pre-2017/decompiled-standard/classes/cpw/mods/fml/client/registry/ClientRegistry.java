/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.client.registry;

import cpw.mods.fml.common.registry.GameRegistry;

public class ClientRegistry {
    public static void registerTileEntity(Class<? extends hurg> clazz, String string, htys htys2) {
        GameRegistry.registerTileEntity(clazz, string);
        ClientRegistry.bindTileEntitySpecialRenderer(clazz, htys2);
    }

    public static void bindTileEntitySpecialRenderer(Class<? extends hurg> clazz, htys htys2) {
        cekh._b._a.put(clazz, htys2);
        htys2.func_76893_a(cekh._b);
    }
}

