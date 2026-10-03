/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server.command;

import net.minecraft.server.MinecraftServer;
import ru.stalcraft.player.PlayerUtils;
import ru.stalcraft.server.player.PlayerServerInfo;

public class ReputationCommand
extends z {
    public String c() {
        return "reputation";
    }

    public String c(ad icommandsender) {
        return "";
    }

    public void b(ad cs2, String[] args) {
        jv par3 = MinecraftServer.F().af().f(cs2.c_());
        if (par3 != null && !MinecraftServer.F().af().e(par3.bu)) {
            return;
        }
        if (args.length != 2) {
            cs2.a(new cv().a("\u0424\u043e\u0440\u043c\u0430\u0442 \u0432\u0432\u043e\u0434\u0430 \u043a\u043e\u043c\u0430\u043d\u0434\u044b: /reputation <player> <value>"));
        } else {
            jv player = MinecraftServer.F().af().f(args[0]);
            if (player == null) {
                cs2.a(new cv().a("\u0418\u0433\u0440\u043e\u043a \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d!"));
            } else if (!args[1].matches("[\\-0-9][0-9]*")) {
                cs2.a(new cv().a("\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u0444\u043e\u0440\u043c\u0430\u0442 \u0447\u0438\u0441\u043b\u0430!"));
            } else {
                int newValue = Integer.parseInt(args[1]);
                if (newValue >= -10 && newValue <= 10) {
                    PlayerServerInfo info = (PlayerServerInfo)PlayerUtils.getInfo(player);
                    info.addReputation(newValue - info.getReputation());
                    cs2.a(new cv().a("\u0420\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u044f \u0438\u0433\u0440\u043e\u043a\u0430 " + player.bu + " \u0438\u0437\u043c\u0435\u043d\u0435\u043d\u0430 \u043d\u0430 " + newValue));
                } else {
                    cs2.a(new cv().a("\u0420\u0435\u043f\u0443\u0442\u0430\u0446\u0438\u044f \u0434\u043e\u043b\u0436\u043d\u0430 \u0431\u044b\u0442\u044c \u043e\u0442 -10 \u0434\u043e 10!"));
                }
            }
        }
    }
}

