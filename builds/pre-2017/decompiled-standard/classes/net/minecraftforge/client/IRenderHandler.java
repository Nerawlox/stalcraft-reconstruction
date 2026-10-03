/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.xpzm;

public abstract class IRenderHandler {
    @SideOnly(value=Side.CLIENT)
    public abstract void render(float var1, pkix var2, xpzm var3);
}

