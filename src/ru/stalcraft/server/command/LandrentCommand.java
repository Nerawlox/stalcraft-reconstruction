/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server.command;

import net.minecraft.server.MinecraftServer;
import ru.stalcraft.server.clans.FlagManager;

public class LandrentCommand
extends z {
    public String c() {
        return "landrent";
    }

    public void b(ad icommandsender, String[] astring) {
        jv par3 = MinecraftServer.F().af().f(icommandsender.c_());
        if (par3 != null && !MinecraftServer.F().af().e(par3.bu)) {
            return;
        }
        if (astring.length == 2 && astring[0].matches("[0-9]*") && astring[1].matches("[0-9]*")) {
            FlagManager m2 = FlagManager.instance();
            m2.maxRentTimer = Integer.parseInt(astring[0]);
            m2.rent = Integer.parseInt(astring[1]);
            icommandsender.a(new cv().a("\u0422\u0435\u043f\u0435\u0440\u044c \u043d\u0430 \u0441\u0447\u0435\u0442\u0430 \u043a\u043b\u0430\u043d\u043e\u0432 \u0431\u0443\u0434\u0435\u0442 \u043d\u0430\u0447\u0438\u0441\u043b\u044f\u0442\u044c\u0441\u044f \u043f\u043e " + m2.rent + " \u0440\u0443\u0431. \u043a\u0430\u0436\u0434\u044b\u0435 " + m2.maxRentTimer + " \u0441\u0435\u043a. \u0437\u0430 \u043a\u0430\u0436\u0434\u044b\u0439 \u0444\u043b\u0430\u0433 \u043d\u0430 \u0442\u0435\u0440\u0440\u0438\u0442\u043e\u0440\u0438\u044f\u0445, \u043a\u043e\u0442\u043e\u0440\u044b\u0435 \u0432\u044b \u0441\u0435\u0439\u0447\u0430\u0441 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u0435"));
        } else {
            icommandsender.a(new cv().a("\u0424\u043e\u0440\u043c\u0430\u0442 \u0432\u0432\u043e\u0434\u0430 \u043a\u043e\u043c\u0430\u043d\u0434\u044b: /landrent <\u043f\u0440\u043e\u043c\u0435\u0436\u0443\u0442\u043e\u043a \u043c\u0435\u0436\u0434\u0443 \u0432\u044b\u043f\u043b\u0430\u0442\u0430\u043c\u0438 \u0432 \u0441\u0435\u043a\u0443\u043d\u0434\u0430\u0445> <\u0441\u0443\u043c\u043c\u0430 \u0437\u0430 \u0440\u0430\u0437>"));
        }
    }

    public String c(ad icommandsender) {
        return "";
    }
}

