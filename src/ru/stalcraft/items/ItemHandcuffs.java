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
import ru.stalcraft.server.network.ServerPacketSender;

public class ItemHandcuffs
extends yc {
    public ItemHandcuffs(int par1) {
        super(par1);
        this.a(StalkerMain.tab);
        this.b("handcuffs");
        LanguageRegistry.addName((Object)this, (String)"\u041d\u0430\u0440\u0443\u0447\u043d\u0438\u043a\u0438");
        this.d(1);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void a(mt par1IconRegister) {
        this.cz = par1IconRegister.a("stalker:handcuffs");
    }

    @Override
    public boolean a(ye stack, uf player, of entityLivingBase) {
        boolean isTargetPlayer = entityLivingBase instanceof uf;
        if (!player.q.I && isTargetPlayer) {
            ServerPacketSender.sendHandcuffsRequest(player, (uf)entityLivingBase);
        }
        return isTargetPlayer;
    }
}

