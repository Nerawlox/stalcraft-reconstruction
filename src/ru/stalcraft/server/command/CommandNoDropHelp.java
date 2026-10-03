/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server.command;

import net.minecraft.server.MinecraftServer;

public class CommandNoDropHelp
extends z {
    public String c() {
        return "helpgivenodrop";
    }

    public String c(ad par1) {
        return "";
    }

    public void b(ad par1, String[] par2) {
        jv par3 = MinecraftServer.F().af().f(par1.c_());
        if (par3.bG.d) {
            par1.a(new cv().a("\u041a\u043e\u043c\u0430\u043d\u0434\u044b ItemHelper: /givenodrop <id> <\u043a\u043e\u043b-\u0432\u043e> <\u043d\u0438\u043a>(\u0435\u0441\u043b\u0438 \u043d\u0443\u0436\u043d\u043e \u0437\u0430\u0441\u043f\u0430\u0432\u043d\u0438\u0442\u044c \u0438\u0433\u0440\u043e\u043a\u0443 \u043f\u0440\u0438\u0434\u043c\u0435\u0442), personal(\u0435\u0441\u043b\u0438 \u043d\u0443\u0436\u043d\u0435\u043d \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439 \u043f\u0440\u0438\u0434\u043c\u0435\u0442), /givenodrop <id> <\u043a\u043e\u043b-\u0432\u043e> (\u0417\u0430\u0441\u043f\u0430\u0432\u043d\u0438\u0442\u044c \u0441\u0435\u0431\u0435 \u043f\u0440\u0438\u0434\u043c\u0435\u0442), /givenodrop personal (\u0417\u0430\u0441\u043f\u0430\u0432\u043d\u0438\u0442\u044c \u0441\u0435\u0431\u0435 \u043f\u0440\u0438\u0434\u043c\u0435\u0442 \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439)"));
        }
    }
}

