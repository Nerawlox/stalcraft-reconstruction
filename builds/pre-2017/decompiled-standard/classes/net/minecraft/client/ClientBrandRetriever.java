/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class ClientBrandRetriever {
    public static String getClientModName() {
        return FMLCommonHandler.instance().getModName();
    }
}

