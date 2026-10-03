/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  ad
 *  at
 *  atl
 *  ay
 *  bb
 *  bd
 *  com.google.common.collect.Lists
 *  com.google.common.collect.Maps
 *  com.google.common.collect.Sets
 *  net.minecraft.server.MinecraftServer
 */
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import net.minecraft.server.MinecraftServer;

public class as
extends z {
    public String c() {
        return "spreadplayers";
    }

    @Override
    public int a() {
        return 2;
    }

    public String c(ad par1ICommandSender) {
        return "commands.spreadplayers.usage";
    }

    public void b(ad par1ICommandSender, String[] par2ArrayOfStr) {
        if (par2ArrayOfStr.length < 6) {
            throw new bd("commands.spreadplayers.usage", new Object[0]);
        }
        int b0 = 0;
        int i = b0 + 1;
        double d0 = as.a(par1ICommandSender, Double.NaN, par2ArrayOfStr[b0]);
        double d1 = as.a(par1ICommandSender, Double.NaN, par2ArrayOfStr[i++]);
        double d2 = as.a(par1ICommandSender, par2ArrayOfStr[i++], 0.0);
        double d3 = as.a(par1ICommandSender, par2ArrayOfStr[i++], d2 + 1.0);
        boolean flag = as.c(par1ICommandSender, par2ArrayOfStr[i++]);
        ArrayList arraylist = Lists.newArrayList();
        while (i < par2ArrayOfStr.length) {
            String s2;
            if (ae.b(s2 = par2ArrayOfStr[i++])) {
                jv[] aentityplayermp = ae.c(par1ICommandSender, s2);
                if (aentityplayermp == null || aentityplayermp.length == 0) {
                    throw new bb();
                }
                Collections.addAll(arraylist, aentityplayermp);
                continue;
            }
            jv entityplayermp = MinecraftServer.F().af().f(s2);
            if (entityplayermp == null) {
                throw new bb();
            }
            arraylist.add(entityplayermp);
        }
        if (arraylist.isEmpty()) {
            throw new bb();
        }
        par1ICommandSender.a(cv.b("commands.spreadplayers.spreading." + (flag ? "teams" : "players"), as.b(arraylist), d0, d1, d2, d3));
        this.a(par1ICommandSender, arraylist, new at(d0, d1), d2, d3, ((of)arraylist.get((int)0)).q, flag);
    }

    private void a(ad par1ICommandSender, List par2List, at par3CommandSpreadPlayersPosition, double par4, double par6, abw par8World, boolean par9) {
        Random random = new Random();
        double d2 = par3CommandSpreadPlayersPosition.a - par6;
        double d3 = par3CommandSpreadPlayersPosition.b - par6;
        double d4 = par3CommandSpreadPlayersPosition.a + par6;
        double d5 = par3CommandSpreadPlayersPosition.b + par6;
        at[] acommandspreadplayersposition = this.a(random, par9 ? this.a(par2List) : par2List.size(), d2, d3, d4, d5);
        int i = this.a(par3CommandSpreadPlayersPosition, par4, par8World, random, d2, d3, d4, d5, acommandspreadplayersposition, par9);
        double d6 = this.a(par2List, par8World, acommandspreadplayersposition, par9);
        as.a(par1ICommandSender, "commands.spreadplayers.success." + (par9 ? "teams" : "players"), acommandspreadplayersposition.length, par3CommandSpreadPlayersPosition.a, par3CommandSpreadPlayersPosition.b);
        if (acommandspreadplayersposition.length > 1) {
            par1ICommandSender.a(cv.b("commands.spreadplayers.info." + (par9 ? "teams" : "players"), String.format("%.2f", d6), i));
        }
    }

    private int a(List par1List) {
        HashSet hashset = Sets.newHashSet();
        for (of entitylivingbase : par1List) {
            if (entitylivingbase instanceof uf) {
                hashset.add(((uf)entitylivingbase).bo());
                continue;
            }
            hashset.add(null);
        }
        return hashset.size();
    }

    private int a(at par1CommandSpreadPlayersPosition, double par2, abw par4World, Random par5Random, double par6, double par8, double par10, double par12, at[] par14ArrayOfCommandSpreadPlayersPosition, boolean par15) {
        int i;
        boolean flag1 = true;
        double d5 = 3.4028234663852886E38;
        for (i = 0; i < 10000 && flag1; ++i) {
            at commandspreadplayersposition1;
            int j2;
            flag1 = false;
            d5 = 3.4028234663852886E38;
            for (int k = 0; k < par14ArrayOfCommandSpreadPlayersPosition.length; ++k) {
                at commandspreadplayersposition2 = par14ArrayOfCommandSpreadPlayersPosition[k];
                j2 = 0;
                commandspreadplayersposition1 = new at();
                for (int l = 0; l < par14ArrayOfCommandSpreadPlayersPosition.length; ++l) {
                    if (k == l) continue;
                    at commandspreadplayersposition3 = par14ArrayOfCommandSpreadPlayersPosition[l];
                    double d6 = commandspreadplayersposition2.a(commandspreadplayersposition3);
                    d5 = Math.min(d6, d5);
                    if (!(d6 < par2)) continue;
                    ++j2;
                    commandspreadplayersposition1.a += commandspreadplayersposition3.a - commandspreadplayersposition2.a;
                    commandspreadplayersposition1.b += commandspreadplayersposition3.b - commandspreadplayersposition2.b;
                }
                if (j2 > 0) {
                    commandspreadplayersposition1.a /= (double)j2;
                    commandspreadplayersposition1.b /= (double)j2;
                    double d7 = commandspreadplayersposition1.b();
                    if (d7 > 0.0) {
                        commandspreadplayersposition1.a();
                        commandspreadplayersposition2.b(commandspreadplayersposition1);
                    } else {
                        commandspreadplayersposition2.a(par5Random, par6, par8, par10, par12);
                    }
                    flag1 = true;
                }
                if (!commandspreadplayersposition2.a(par6, par8, par10, par12)) continue;
                flag1 = true;
            }
            if (flag1) continue;
            at[] acommandspreadplayersposition1 = par14ArrayOfCommandSpreadPlayersPosition;
            int i1 = par14ArrayOfCommandSpreadPlayersPosition.length;
            for (j2 = 0; j2 < i1; ++j2) {
                commandspreadplayersposition1 = acommandspreadplayersposition1[j2];
                if (commandspreadplayersposition1.b(par4World)) continue;
                commandspreadplayersposition1.a(par5Random, par6, par8, par10, par12);
                flag1 = true;
            }
        }
        if (i >= 10000) {
            throw new ay("commands.spreadplayers.failure." + (par15 ? "teams" : "players"), new Object[]{par14ArrayOfCommandSpreadPlayersPosition.length, par1CommandSpreadPlayersPosition.a, par1CommandSpreadPlayersPosition.b, String.format("%.2f", d5)});
        }
        return i;
    }

    private double a(List par1List, abw par2World, at[] par3ArrayOfCommandSpreadPlayersPosition, boolean par4) {
        double d0 = 0.0;
        int i = 0;
        HashMap hashmap = Maps.newHashMap();
        for (int j2 = 0; j2 < par1List.size(); ++j2) {
            at commandspreadplayersposition;
            of entitylivingbase = (of)par1List.get(j2);
            if (par4) {
                atl team;
                atl atl2 = team = entitylivingbase instanceof uf ? ((uf)entitylivingbase).bo() : null;
                if (!hashmap.containsKey(team)) {
                    hashmap.put(team, par3ArrayOfCommandSpreadPlayersPosition[i++]);
                }
                commandspreadplayersposition = (at)hashmap.get(team);
            } else {
                commandspreadplayersposition = par3ArrayOfCommandSpreadPlayersPosition[i++];
            }
            entitylivingbase.a((double)((float)ls.c(commandspreadplayersposition.a) + 0.5f), (double)commandspreadplayersposition.a(par2World), (double)ls.c(commandspreadplayersposition.b) + 0.5);
            double d1 = Double.MAX_VALUE;
            for (int k = 0; k < par3ArrayOfCommandSpreadPlayersPosition.length; ++k) {
                if (commandspreadplayersposition == par3ArrayOfCommandSpreadPlayersPosition[k]) continue;
                double d2 = commandspreadplayersposition.a(par3ArrayOfCommandSpreadPlayersPosition[k]);
                d1 = Math.min(d2, d1);
            }
            d0 += d1;
        }
        return d0 /= (double)par1List.size();
    }

    private at[] a(Random par1Random, int par2, double par3, double par5, double par7, double par9) {
        at[] acommandspreadplayersposition = new at[par2];
        for (int j2 = 0; j2 < acommandspreadplayersposition.length; ++j2) {
            at commandspreadplayersposition = new at();
            commandspreadplayersposition.a(par1Random, par3, par5, par7, par9);
            acommandspreadplayersposition[j2] = commandspreadplayersposition;
        }
        return acommandspreadplayersposition;
    }
}

