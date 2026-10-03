/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.server.command;

import java.text.DecimalFormat;
import net.minecraft.util.zwat;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.server.ForgeTimeTracker;

public class ForgeCommand
extends ohnk {
    private dzfd server;
    private static final DecimalFormat timeFormatter = new DecimalFormat("########0.000");

    public ForgeCommand(dzfd dzfd2) {
        this.server = dzfd2;
    }

    @Override
    public String func_71517_b() {
        return "forge";
    }

    @Override
    public String func_71518_a(nemo nemo2) {
        return "commands.forge.usage";
    }

    @Override
    public int func_82362_a() {
        return 2;
    }

    @Override
    public void func_71515_b(nemo nemo2, String[] stringArray) {
        if (stringArray.length == 0) {
            throw new pksd("commands.forge.usage", new Object[0]);
        }
        if ("help".equals(stringArray[0])) {
            throw new pksd("commands.forge.usage", new Object[0]);
        }
        if ("tps".equals(stringArray[0])) {
            this.displayTPS(nemo2, stringArray);
        } else if ("tpslog".equals(stringArray[0])) {
            this.doTPSLog(nemo2, stringArray);
        } else if ("track".equals(stringArray[0])) {
            this.handleTracking(nemo2, stringArray);
        } else {
            throw new pksd("commands.forge.usage", new Object[0]);
        }
    }

    private void handleTracking(nemo nemo2, String[] stringArray) {
        if (stringArray.length != 3) {
            throw new pksd("commands.forge.usage.tracking", new Object[0]);
        }
        String string = stringArray[1];
        int n = ForgeCommand.func_71532_a(nemo2, stringArray[2], 1, 60);
        if (!"te".equals(string)) {
            throw new pksd("commands.forge.usage.tracking", new Object[0]);
        }
        this.doTurnOnTileEntityTracking(nemo2, n);
    }

    private void doTurnOnTileEntityTracking(nemo nemo2, int n) {
        ForgeTimeTracker.tileEntityTrackingDuration = n;
        ForgeTimeTracker.tileEntityTracking = true;
        nemo2.func_70006_a(zwat._b("commands.forge.tracking.te.enabled", n));
    }

    private void doTPSLog(nemo nemo2, String[] stringArray) {
    }

    private void displayTPS(nemo nemo2, String[] stringArray) {
        int n = 0;
        boolean bl = true;
        if (stringArray.length > 1) {
            n = ForgeCommand.func_71526_a(nemo2, stringArray[1]);
            bl = false;
        }
        if (bl) {
            for (Integer n2 : DimensionManager.getIDs()) {
                double d = (double)ForgeCommand.mean(this.server._I.get(n2)) * 1.0E-6;
                double d2 = Math.min(1000.0 / d, 20.0);
                nemo2.func_70006_a(zwat._b("commands.forge.tps.summary", String.format("Dim %d", n2), timeFormatter.format(d), timeFormatter.format(d2)));
            }
            double d = (double)ForgeCommand.mean(this.server._H) * 1.0E-6;
            double d3 = Math.min(1000.0 / d, 20.0);
            nemo2.func_70006_a(zwat._b("commands.forge.tps.summary", "Overall", timeFormatter.format(d), timeFormatter.format(d3)));
        } else {
            double d = (double)ForgeCommand.mean(this.server._I.get(n)) * 1.0E-6;
            double d4 = Math.min(1000.0 / d, 20.0);
            nemo2.func_70006_a(zwat._b("commands.forge.tps.summary", String.format("Dim %d", n), timeFormatter.format(d), timeFormatter.format(d4)));
        }
    }

    private static long mean(long[] lArray) {
        long l = 0L;
        for (long l2 : lArray) {
            l += l2;
        }
        return l / (long)lArray.length;
    }
}

