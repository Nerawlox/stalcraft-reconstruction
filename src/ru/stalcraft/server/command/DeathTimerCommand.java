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
import ru.stalcraft.server.network.ServerPacketSender;
import ru.stalcraft.server.player.PlayerServerInfo;

public class DeathTimerCommand
extends z {
    public String c() {
        return "deathtimer";
    }

    public void b(ad par1, String[] par2) {
        jv par3 = MinecraftServer.F().af().f(par1.c_());
        if (par3 != null && !MinecraftServer.F().af().e(par3.bu)) {
            return;
        }
        try {
            jv par4 = MinecraftServer.F().af().f(par2[0]);
            if (par2.length == 2 && par4 != null) {
                PlayerServerInfo par5 = (PlayerServerInfo)PlayerUtils.getInfo(par4);
                par5.getPersistedTag().a("deathTimer", Boolean.valueOf(par2[1]));
                if (par5.getPersistedTag().n("deathTimer")) {
                    ServerPacketSender.sendForceCooldown(par4);
                    par1.a(new cv().a("\u0423 \u0438\u0433\u0440\u043e\u043a\u0430 " + par2[0] + " \u0432\u044b\u043a\u043b\u044e\u0447\u0435\u043d \u0442\u0430\u0439\u043c\u0435\u0440 \u0441\u043c\u0435\u0440\u0442\u0438"));
                } else {
                    par1.a(new cv().a("\u0423 \u0438\u0433\u0440\u043e\u043a\u0430 " + par2[0] + " \u0432\u043a\u043b\u044e\u0447\u0435\u043d \u0442\u0430\u0439\u043c\u0435\u0440 \u0441\u043c\u0435\u0440\u0442\u0438"));
                }
            } else if (par4 == null) {
                par1.a(new cv().a("\u0418\u0433\u0440\u043e\u043a\u0430 \u043d\u0435\u0442 \u043d\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0435 \u0438\u043b\u0438 \u0435\u0433\u043e \u043d\u0438\u043a \u043d\u0430\u0431\u0440\u0430\u043d \u043d\u0435 \u043f\u0440\u0430\u0432\u0438\u043b\u044c\u043d\u043e!"));
            } else {
                par1.a(new cv().a("\u0424\u043e\u0440\u043c\u0430\u0442 \u0432\u0432\u043e\u0434\u0430 \u043a\u043e\u043c\u0430\u043d\u0434\u044b: /deathtimer [Username] <false/true>"));
            }
        }
        catch (Exception e2) {
            par1.a(new cv().a("\u0424\u043e\u0440\u043c\u0430\u0442 \u0432\u0432\u043e\u0434\u0430 \u043a\u043e\u043c\u0430\u043d\u0434\u044b: /deathtimer [Username] <false/true>"));
        }
    }

    public String c(ad icommandsender) {
        return "";
    }
}

