/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.registry.LanguageRegistry
 *  cpw.mods.fml.relauncher.Side
 *  cpw.mods.fml.relauncher.SideOnly
 *  mt
 */
package ru.stalcraft.items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ru.stalcraft.StalkerMain;
import ru.stalcraft.player.PlayerInfo;
import ru.stalcraft.player.PlayerUtils;

public class ItemKey
extends yc {
    public ItemKey(int par1) {
        super(par1);
        this.a(StalkerMain.tab);
        this.b("key");
        LanguageRegistry.addName((Object)this, (String)"\u041a\u043b\u044e\u0447");
        this.d(1);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:key");
    }

    @Override
    public boolean a(ye stack, uf player, of entityLivingBase) {
        uf target;
        PlayerInfo info;
        boolean isTargetPlayer = entityLivingBase instanceof uf;
        if (!player.q.I && isTargetPlayer && (info = PlayerUtils.getInfo(target = (uf)entityLivingBase)).getHandcuffs()) {
            target.a("\u0421 \u0432\u0430\u0441 \u0441\u043d\u044f\u043b \u043d\u0430\u0440\u0443\u0447\u043d\u0438\u043a\u0438 \u0438\u0433\u0440\u043e\u043a " + player.bu);
            player.a("\u0412\u044b \u0441\u043d\u044f\u043b\u0438 \u043d\u0430\u0440\u0443\u0447\u043d\u0438\u043a\u0438 \u0441 \u0438\u0433\u0440\u043e\u043a\u0430 " + target.bu);
            info.setHandcuffs(false);
            player.c(0, null);
        }
        return isTargetPlayer;
    }
}

