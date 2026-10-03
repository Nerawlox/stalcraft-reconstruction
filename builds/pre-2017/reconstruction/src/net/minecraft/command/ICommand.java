/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.List;
import net.minecraft.command.ICommandSender;

public interface ICommand
extends Comparable {
    public String getCommandName();

    public String getCommandUsage(ICommandSender var1);

    public List getCommandAliases();

    public void processCommand(ICommandSender var1, String[] var2);

    public boolean canCommandSenderUseCommand(ICommandSender var1);

    public List addTabCompletionOptions(ICommandSender var1, String[] var2);

    public boolean isUsernameIndex(String[] var1, int var2);
}

