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

public class MoneyCommand
extends z {
    public String c() {
        return "clanmoney";
    }

    public void b(ad icommandsender, String[] astring) {
        jv par3 = MinecraftServer.F().af().f(icommandsender.c_());
        if (par3 != null && !MinecraftServer.F().af().e(par3.bu)) {
            return;
        }
        if (astring.length == 2 && astring[1].matches("[0-9]*")) {
            Clan clan = ClanManager.instance().getClan(astring[0]);
            if (clan == null) {
                icommandsender.a(new cv().a("\u0422\u0430\u043a\u043e\u0433\u043e \u043a\u043b\u0430\u043d\u0430 \u043d\u0435 \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u0435\u0442!"));
            } else {
                icommandsender.a(new cv().a("\u0421\u0443\u043c\u043c\u0430 \u043d\u0430 \u0441\u0447\u0435\u0442\u0443 \u043a\u043b\u0430\u043d\u0430 " + clan.name + " \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0430 \u0441 " + clan.money + " \u043d\u0430 " + astring[1] + " \u0440\u0443\u0431."));
                clan.money = Integer.parseInt(astring[1]);
            }
        } else {
            icommandsender.a(new cv().a("\u0424\u043e\u0440\u043c\u0430\u0442 \u0432\u0432\u043e\u0434\u0430 \u043a\u043e\u043c\u0430\u043d\u0434\u044b: /clanmoney <\u043a\u043b\u0430\u043d> <\u0441\u0443\u043c\u043c\u0430>"));
        }
    }

    public String c(ad icommandsender) {
        return "";
    }
}

