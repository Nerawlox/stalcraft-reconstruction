/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server.command;

import net.minecraft.server.MinecraftServer;
import ru.stalcraft.server.clans.Clan;
import ru.stalcraft.server.clans.ClanManager;

public class SyncCommand
extends z {
    public String c() {
        return "clansync";
    }

    public void b(ad icommandsender, String[] astring) {
        jv par3 = MinecraftServer.F().af().f(icommandsender.c_());
        if (par3 != null && !MinecraftServer.F().af().e(par3.bu)) {
            return;
        }
        if (astring.length == 0) {
            for (Clan clan : ClanManager.instance().getClans()) {
                clan.syncReputation(true);
            }
        } else {
            String var5 = "";
            for (int var6 = 0; var6 < astring.length; ++var6) {
                var5 = var5 + astring[var6];
                if (var6 + 1 >= astring.length) continue;
                var5 = var5 + " ";
            }
            Clan clan = ClanManager.instance().getClan(var5);
            if (clan == null) {
                icommandsender.a(new cv().a("Clan not found!"));
                return;
            }
            clan.syncReputation(true);
        }
    }

    public String c(ad icommandsender) {
        return "";
    }
}

