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

public class CommandNoDrop
extends z {
    public String c() {
        return "givenodrop";
    }

    public String c(ad par1) {
        return "";
    }

    public void b(ad par1, String[] par2) {
        ye par8;
        Object par7;
        jv par3 = MinecraftServer.F().af().f(par1.c_());
        if (par3 != null && !MinecraftServer.F().af().e(par3.bu)) {
            return;
        }
        int par4 = 0;
        int par5 = 1;
        boolean par6 = false;
        if (par2.length == 0) {
            if (par3.bn.h() != null) {
                PlayerUtils.getTag(par3.bn.h()).a("no_drop", 1);
                par1.a(new cv().a("\u041f\u0440\u0435\u0434\u043c\u0435\u0442 \u043d\u0435 \u0432\u044b\u043f\u0430\u0434\u0430\u0439\u044e\u0449\u0438\u0439!"));
                return;
            }
            par1.a(new cv().a("\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u0432\u0432\u043e\u0434 \u043a\u043e\u043c\u0430\u043d\u0434\u044b!"));
            return;
        }
        if (par2.length == 1) {
            if (par3.bn.h() != null && par2[0].equals("personal")) {
                PlayerUtils.getTag(par3.bn.h()).a("no_drop", 1);
                PlayerUtils.getTag(par3.bn.h()).a("personal", 1);
                par1.a(new cv().a("\u041f\u0440\u0435\u0434\u043c\u0435\u0442 \u043d\u0435 \u0432\u044b\u043f\u0430\u0434\u0430\u0439\u044e\u0449\u0438\u0439 \u0438 \u043f\u0435\u0440\u0441\u043e\u043d\u0430\u043b\u044c\u043d\u044b\u0439!"));
                return;
            }
            par1.a(new cv().a("\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u0432\u0432\u043e\u0434 \u043a\u043e\u043c\u0430\u043d\u0434\u044b!"));
            return;
        }
        if (par2.length >= 1) {
            try {
                par4 = Integer.parseInt(par2[0]);
                if (par4 <= 0 || par4 >= 43000 || yc.g[par4] == null) {
                    throw new Exception();
                }
            }
            catch (Exception e2) {
                par1.a(new cv().a("\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 id!"));
                return;
            }
        }
        if (par2.length >= 2) {
            try {
                par5 = Integer.parseInt(par2[1]);
                if (par5 < 1 || par5 > 64) {
                    throw new Exception();
                }
            }
            catch (Exception e3) {
                par1.a(new cv().a("\u041d\u0435\u0432\u0435\u0440\u043d\u043e\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e!"));
                return;
            }
            if (par2.length == 2) {
                par7 = new ye(par4, par5, 0);
                PlayerUtils.getTag((ye)par7).a("no_drop", 1);
                if (!par3.bn.a((ye)par7)) {
                    par1.a(new cv().a("\u0423 \u0432\u0430\u0441 \u043f\u0435\u0440\u0435\u043f\u043e\u043b\u043d\u0435\u043d \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c!"));
                    return;
                }
                par1.a(new cv().a("\u041f\u0440\u0435\u0434\u043c\u0435\u0442 \u0432\u044b\u0434\u0430\u043d!"));
            }
        }
        if (par2.length >= 3) {
            par6 = Boolean.valueOf(par2[2]);
            if (par6) {
                ye par82 = new ye(par4, par5, 0);
                PlayerUtils.getTag(par82).a("no_drop", 1);
                PlayerUtils.getTag(par82).a("personal", 1);
                if (!par3.bn.a(par82)) {
                    par1.a(new cv().a("\u0423 \u0432\u0430\u0441 \u043f\u0435\u0440\u0435\u043f\u043e\u043b\u043d\u0435\u043d \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c!"));
                    return;
                }
            } else {
                par7 = MinecraftServer.F().af().f(par2[2]);
                if (par7 == null) {
                    par1.a(new cv().a("\u041d\u0435 \u043f\u0440\u0430\u0432\u0438\u043b\u044c\u043d\u043e\u0435 \u0438\u043c\u044f \u0438\u0433\u0440\u043e\u043a\u0430 \u0438\u043b\u0438 \u0435\u0433\u043e \u043d\u0435\u0442!"));
                    return;
                }
                par8 = new ye(par4, par5, 0);
                PlayerUtils.getTag(par8).a("no_drop", 1);
                if (!((jv)par7).bn.a(par8)) {
                    par1.a(new cv().a("\u0423 \u0438\u0433\u0440\u043e\u043a\u0430 \u043f\u0435\u0440\u0435\u043f\u043e\u043b\u043d\u0435\u043d \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c!"));
                    return;
                }
            }
        }
        if (par2.length == 4) {
            par7 = MinecraftServer.F().af().f(par2[2]);
            if (par7 == null) {
                par1.a(new cv().a("\u041d\u0435 \u043f\u0440\u0430\u0432\u0438\u043b\u044c\u043d\u043e\u0435 \u0438\u043c\u044f \u0438\u0433\u0440\u043e\u043a\u0430 \u0438\u043b\u0438 \u0435\u0433\u043e \u043d\u0435\u0442!"));
                return;
            }
            par8 = new ye(par4, par5, 0);
            PlayerUtils.getTag(par8).a("no_drop", 1);
            PlayerUtils.getTag(par8).a("personal", 1);
            if (!((jv)par7).bn.a(par8)) {
                par1.a(new cv().a("\u0423 \u0438\u0433\u0440\u043e\u043a\u0430 \u043f\u0435\u0440\u0435\u043f\u043e\u043b\u043d\u0435\u043d \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c!"));
                return;
            }
        }
    }
}

