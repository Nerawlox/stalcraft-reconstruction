/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  ms
 *  mt
 */
package ru.stalcraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.stalcraft.StalkerMain;

public class ItemMachineGun
extends zh {
    public ItemMachineGun(int par1) {
        super(par1);
        this.e(0);
        this.a(StalkerMain.tab);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:machinegun");
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public ms b_(int par1) {
        return this.cz;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public int l() {
        return 1;
    }
}

