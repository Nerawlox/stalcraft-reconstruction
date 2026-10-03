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
import ru.stalcraft.clans.ClanRank;
import ru.stalcraft.clans.IClan;
import ru.stalcraft.player.PlayerUtils;

public class ItemFlag
extends zh {
    public ItemFlag(int par1) {
        super(par1);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:flag");
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

    @Override
    public boolean a(ye par1ItemStack, uf player, abw par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
        int x2 = par4;
        int z2 = par6;
        if (par7 == 2) {
            z2 = par6 - 1;
        }
        if (par7 == 3) {
            ++z2;
        }
        if (par7 == 4) {
            x2 = par4 - 1;
        }
        if (par7 == 5) {
            ++x2;
        }
        if (!player.q.I) {
            jv p2 = (jv)player;
            IClan clan = PlayerUtils.getInfo(player).getClan();
            if (clan == null) {
                player.a("\u0412\u044b \u043d\u0435 \u0441\u043e\u0441\u0442\u043e\u0438\u0442\u0435 \u0432 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0435!");
                p2.a(p2.bo);
                return false;
            }
            if (clan.getClanMember(player).getRank() == ClanRank.MEMBER) {
                player.a("\u0412\u044b \u043d\u0435 \u0438\u043c\u0435\u0435\u0442\u0435 \u043f\u0440\u0430\u0432\u0430 \u0443\u0441\u0442\u0430\u043d\u0430\u0432\u043b\u0438\u0432\u0430\u0442\u044c \u0444\u043b\u0430\u0433!");
                p2.a(p2.bo);
                return false;
            }
            if (clan.getMaxLandsCount() <= StalkerMain.flagManager.getClanFlags(clan).size() && !clan.isAdminClan()) {
                player.a("\u0412\u0430\u0448\u0430 \u0433\u0440\u0443\u043f\u043f\u0438\u0440\u043e\u0432\u043a\u0430 \u0443\u0436\u0435 \u0437\u0430\u0445\u0432\u0430\u0442\u0438\u043b\u0430 \u043c\u0430\u043a\u0441\u0438\u043c\u0430\u043b\u044c\u043d\u043e\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0442\u0435\u0440\u0440\u0438\u0442\u043e\u0440\u0438\u0439. \u0414\u043b\u044f \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043a\u0438 \u043d\u043e\u0432\u043e\u0433\u043e \u0444\u043b\u0430\u0433\u0430 \u043d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e \u0443\u0432\u0435\u043b\u0438\u0447\u0438\u0442\u044c \u0440\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u044e.");
                p2.a(p2.bo);
                return false;
            }
            if (!StalkerMain.flagManager.canPlaceFlagHere(player.q.t.i, x2, z2)) {
                player.a("\u041d\u0435\u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u044c \u0444\u043b\u0430\u0433 \u0432 \u0434\u0430\u043d\u043d\u043e\u043c \u043c\u0435\u0441\u0442\u0435.");
                p2.a(p2.bo);
                return false;
            }
            return super.a(par1ItemStack, player, par3World, par4, par5, par6, par7, par8, par9, par10);
        }
        return false;
    }
}

