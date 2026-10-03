/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  bjo
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
package ru.stalcraft.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(value=Side.CLIENT)
public class RenderNull
extends bgm {
    @Override
    public void a(nn par1Entity, double par2, double par4, double par6, float par8, float par9) {
    }

    @Override
    protected bjo a(nn entity) {
        return null;
    }
}

