/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  akc
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  xk
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import ru.stalcraft.StalkerMain;

public class ItemStalkerDoor
extends xk {
    public ItemStalkerDoor(int par1) {
        super(par1, akc.d);
        this.cw = 1;
        this.a(StalkerMain.tab);
        this.b("stalker_door");
        this.d("stalker:item_door");
        LanguageRegistry.addName((Object)((Object)this), (String)"\u0414\u0432\u0435\u0440\u044c");
    }

    public boolean a(ye par1ItemStack, uf par2EntityPlayer, abw par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        if (par7 != 1) {
            return false;
        }
        aqz block = StalkerMain.stalkerDoor;
        if (par2EntityPlayer.a(par4, ++par5, par6, par7, par1ItemStack) && par2EntityPlayer.a(par4, par5 + 1, par6, par7, par1ItemStack)) {
            if (!block.c(par3World, par4, par5, par6)) {
                return false;
            }
            int i1 = ls.c((double)((par2EntityPlayer.A + 180.0f) * 4.0f / 360.0f) - 0.5) & 3;
            ItemStalkerDoor.a((abw)par3World, (int)par4, (int)par5, (int)par6, (int)i1, (aqz)block);
            --par1ItemStack.b;
            return true;
        }
        return false;
    }
}

