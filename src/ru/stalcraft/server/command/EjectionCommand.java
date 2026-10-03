/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  net.minecraft.server.MinecraftServer
 */
package ru.stalcraft.server.command;

import net.minecraft.server.MinecraftServer;
import ru.stalcraft.server.CommonProxy;
import ru.stalcraft.server.ejection.ServerEjection;

public class EjectionCommand
extends z {
    public String c() {
        return "ejection";
    }

    public void b(ad icommandsender, String[] astring) {
        jv par3 = MinecraftServer.F().af().f(icommandsender.c_());
        if (par3 != null && !MinecraftServer.F().af().e(par3.bu)) {
            return;
        }
        if (astring.length != 1) {
            icommandsender.a(new cv().a("\u0424\u043e\u0440\u043c\u0430\u0442 \u0432\u0432\u043e\u0434\u0430 \u043a\u043e\u043c\u0430\u043d\u0434\u044b: /ejection <start/stop/enable/disable>"));
        } else if (astring[0].equals("start")) {
            new ServerEjection().start();
            icommandsender.a(new cv().a("\u0412\u044b\u0431\u0440\u043e\u0441 \u0437\u0430\u043f\u0443\u0449\u0435\u043d."));
        } else if (astring[0].equals("stop")) {
            ServerEjection ejection = (ServerEjection)CommonProxy.serverEjectionManager.getEjection();
            if (ejection == null) {
                icommandsender.a(new cv().a("\u0412 \u0434\u0430\u043d\u043d\u044b\u0439 \u043c\u043e\u043c\u0435\u043d\u0442 \u0432\u044b\u0431\u0440\u043e\u0441\u0430 \u043d\u0435\u0442."));
            } else {
                ejection.end();
                icommandsender.a(new cv().a("\u0412\u044b\u0431\u0440\u043e\u0441 \u043e\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d."));
            }
        } else if (astring[0].equals("enable")) {
            CommonProxy.serverEjectionManager.setRandomStart(true);
            icommandsender.a(new cv().a("\u0421\u043b\u0443\u0447\u0430\u0439\u043d\u044b\u0439 \u0437\u0430\u043f\u0443\u0441\u043a \u0432\u044b\u0431\u0440\u043e\u0441\u0430 \u0432\u043a\u043b\u044e\u0447\u0435\u043d."));
        } else if (astring[0].equals("disable")) {
            CommonProxy.serverEjectionManager.setRandomStart(false);
            icommandsender.a(new cv().a("\u0421\u043b\u0443\u0447\u0430\u0439\u043d\u044b\u0439 \u0437\u0430\u043f\u0443\u0441\u043a \u0432\u044b\u0431\u0440\u043e\u0441\u0430 \u043e\u0442\u043a\u043b\u044e\u0447\u0435\u043d."));
        } else {
            icommandsender.a(new cv().a("\u0424\u043e\u0440\u043c\u0430\u0442 \u0432\u0432\u043e\u0434\u0430 \u043a\u043e\u043c\u0430\u043d\u0434\u044b: /ejection <start/stop/enable/disable>"));
        }
    }

    public String c(ad icommandsender) {
        return "";
    }
}

