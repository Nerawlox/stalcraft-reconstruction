/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 */
package ru.stalcraft.inventory;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StalkerTab
extends ww {
    public StalkerTab() {
        super("Stalker mod");
    }

    @Override
    public String c() {
        return this.b();
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public yc d() {
        return yc.n;
    }
}

