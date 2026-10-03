/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mt
 *  xx
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.player.PlayerUtils;

public class ItemVodka
extends xx {
    public ItemVodka(int id) {
        super(id, 0, false);
        this.a(StalkerMain.tab);
        this.b("vodka");
        LanguageRegistry.addName((Object)((Object)this), (String)"\u0412\u043e\u0434\u043a\u0430");
    }

    public int d_(ye par1ItemStack) {
        return 32;
    }

    public zj c_(ye par1ItemStack) {
        return zj.c;
    }

    public ye a(ye par1ItemStack, abw par2World, uf par3EntityPlayer) {
        par3EntityPlayer.a(par1ItemStack, this.d_(par1ItemStack));
        return par1ItemStack;
    }

    public ye b(ye stack, abw world, uf player) {
        if (!player.bG.d) {
            --stack.b;
        }
        if (!world.I) {
            player.c(new nj(9, 400));
            PlayerUtils.getInfo((uf)player).cont.removeEffect(0, -1);
        }
        return stack.b <= 0 ? new ye(StalkerMain.emptyBottle) : stack;
    }

    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:vodka");
    }
}

