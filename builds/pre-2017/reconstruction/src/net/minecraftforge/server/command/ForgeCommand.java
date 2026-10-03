/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.server.command;

import java.text.DecimalFormat;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.server.ForgeTimeTracker;

public class ForgeCommand
extends CommandBase {
    private MinecraftServer server;
    private static final DecimalFormat timeFormatter = new DecimalFormat("########0.000");

    public ForgeCommand(MinecraftServer minecraftServer) {
        this.server = minecraftServer;
    }

    @Override
    public String getCommandName() {
        return "forge";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.forge.usage";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length == 0) {
            throw new pksd("commands.forge.usage", new Object[0]);
        }
        if ("help".equals(stringArray[0])) {
            throw new pksd("commands.forge.usage", new Object[0]);
        }
        if ("tps".equals(stringArray[0])) {
            this.displayTPS(iCommandSender, stringArray);
        } else if ("tpslog".equals(stringArray[0])) {
            this.doTPSLog(iCommandSender, stringArray);
        } else if ("track".equals(stringArray[0])) {
            this.handleTracking(iCommandSender, stringArray);
        } else {
            throw new pksd("commands.forge.usage", new Object[0]);
        }
    }

    private void handleTracking(ICommandSender iCommandSender, String[] stringArray) {
        if (stringArray.length != 3) {
            throw new pksd("commands.forge.usage.tracking", new Object[0]);
        }
        String string = stringArray[1];
        int n = ForgeCommand.parseIntBounded(iCommandSender, stringArray[2], 1, 60);
        if (!"te".equals(string)) {
            throw new pksd("commands.forge.usage.tracking", new Object[0]);
        }
        this.doTurnOnTileEntityTracking(iCommandSender, n);
    }

    private void doTurnOnTileEntityTracking(ICommandSender iCommandSender, int n) {
        ForgeTimeTracker.tileEntityTrackingDuration = n;
        ForgeTimeTracker.tileEntityTracking = true;
        iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.forge.tracking.te.enabled", n));
    }

    private void doTPSLog(ICommandSender iCommandSender, String[] stringArray) {
    }

    private void displayTPS(ICommandSender iCommandSender, String[] stringArray) {
        int n = 0;
        boolean bl = true;
        if (stringArray.length > 1) {
            n = ForgeCommand.parseInt(iCommandSender, stringArray[1]);
            bl = false;
        }
        if (bl) {
            for (Integer n2 : DimensionManager.getIDs()) {
                double d = (double)ForgeCommand.mean(this.server._I.get(n2)) * 1.0E-6;
                double d2 = Math.min(1000.0 / d, 20.0);
                iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.forge.tps.summary", String.format("Dim %d", n2), timeFormatter.format(d), timeFormatter.format(d2)));
            }
            double d = (double)ForgeCommand.mean(this.server._H) * 1.0E-6;
            double d3 = Math.min(1000.0 / d, 20.0);
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.forge.tps.summary", "Overall", timeFormatter.format(d), timeFormatter.format(d3)));
        } else {
            double d = (double)ForgeCommand.mean(this.server._I.get(n)) * 1.0E-6;
            double d4 = Math.min(1000.0 / d, 20.0);
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.forge.tps.summary", String.format("Dim %d", n), timeFormatter.format(d), timeFormatter.format(d4)));
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

