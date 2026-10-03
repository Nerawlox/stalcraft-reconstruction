/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.shop;

import gloomyfolken.mods.shop.kjui;
import gloomyfolken.mods.shop.pidb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

public class eidj {
    public static boolean _a(EntityPlayer entityPlayer) {
        return !MinecraftForge.EVENT_BUS.post(new pidb(entityPlayer));
    }

    public static boolean _b(EntityPlayer entityPlayer) {
        return !MinecraftForge.EVENT_BUS.post(new kjui(entityPlayer));
    }
}

