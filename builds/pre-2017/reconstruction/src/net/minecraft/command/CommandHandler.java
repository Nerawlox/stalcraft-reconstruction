/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerSelector;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;

public class CommandHandler
implements zyqp {
    public final Map commandMap = new HashMap();
    public final Set commandSet = new HashSet();

    @Override
    public int executeCommand(ICommandSender iCommandSender, String string) {
        if ((string = string.trim()).startsWith("/")) {
            string = string.substring(1);
        }
        String[] stringArray = string.split(" ");
        String string2 = stringArray[0];
        stringArray = CommandHandler.dropFirstString(stringArray);
        ICommand iCommand = (ICommand)this.commandMap.get(string2);
        int n = this.getUsernameIndex(iCommand, stringArray);
        int n2 = 0;
        try {
            if (iCommand == null) {
                throw new dhob();
            }
            if (iCommand.canCommandSenderUseCommand(iCommandSender)) {
                CommandEvent commandEvent = new CommandEvent(iCommand, iCommandSender, stringArray);
                if (MinecraftForge.EVENT_BUS.post(commandEvent)) {
                    if (commandEvent.exception != null) {
                        throw commandEvent.exception;
                    }
                    return 1;
                }
                if (n > -1) {
                    EntityPlayerMP[] entityPlayerMPArray = PlayerSelector._c(iCommandSender, stringArray[n]);
                    String string3 = stringArray[n];
                    EntityPlayerMP[] entityPlayerMPArray2 = entityPlayerMPArray;
                    int n3 = entityPlayerMPArray.length;
                    for (int i = 0; i < n3; ++i) {
                        EntityPlayerMP entityPlayerMP = entityPlayerMPArray2[i];
                        stringArray[n] = entityPlayerMP.getEntityName();
                        try {
                            iCommand.processCommand(iCommandSender, stringArray);
                            ++n2;
                            continue;
                        }
                        catch (cekk cekk2) {
                            iCommandSender.sendChatToPlayer(ChatMessageComponent._b(cekk2.getMessage(), cekk2._a())._a(EnumChatFormatting._m));
                        }
                    }
                    stringArray[n] = string3;
                } else {
                    iCommand.processCommand(iCommandSender, stringArray);
                    ++n2;
                }
            } else {
                iCommandSender.sendChatToPlayer(ChatMessageComponent._e("commands.generic.permission")._a(EnumChatFormatting._m));
            }
        }
        catch (pksd pksd2) {
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b("commands.generic.usage", ChatMessageComponent._b(pksd2.getMessage(), pksd2._a()))._a(EnumChatFormatting._m));
        }
        catch (cekk cekk3) {
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b(cekk3.getMessage(), cekk3._a())._a(EnumChatFormatting._m));
        }
        catch (Throwable throwable) {
            iCommandSender.sendChatToPlayer(ChatMessageComponent._e("commands.generic.exception")._a(EnumChatFormatting._m));
            throwable.printStackTrace();
        }
        return n2;
    }

    public ICommand registerCommand(ICommand iCommand) {
        List list2 = iCommand.getCommandAliases();
        this.commandMap.put(iCommand.getCommandName(), iCommand);
        this.commandSet.add(iCommand);
        if (list2 != null) {
            for (String string : list2) {
                ICommand iCommand2 = (ICommand)this.commandMap.get(string);
                if (iCommand2 != null && iCommand2.getCommandName().equals(string)) continue;
                this.commandMap.put(string, iCommand);
            }
        }
        return iCommand;
    }

    public static String[] dropFirstString(String[] stringArray) {
        String[] stringArray2 = new String[stringArray.length - 1];
        for (int i = 1; i < stringArray.length; ++i) {
            stringArray2[i - 1] = stringArray[i];
        }
        return stringArray2;
    }

    @Override
    public List getPossibleCommands(ICommandSender iCommandSender, String string) {
        ICommand iCommand;
        String[] stringArray = string.split(" ", -1);
        String string2 = stringArray[0];
        if (stringArray.length == 1) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : this.commandMap.entrySet()) {
                if (!CommandBase.doesStringStartWith(string2, (String)entry.getKey()) || !((ICommand)entry.getValue()).canCommandSenderUseCommand(iCommandSender)) continue;
                arrayList.add(entry.getKey());
            }
            return arrayList;
        }
        if (stringArray.length > 1 && (iCommand = (ICommand)this.commandMap.get(string2)) != null) {
            return iCommand.addTabCompletionOptions(iCommandSender, CommandHandler.dropFirstString(stringArray));
        }
        return null;
    }

    @Override
    public List getPossibleCommands(ICommandSender iCommandSender) {
        ArrayList<ICommand> arrayList = new ArrayList<ICommand>();
        for (ICommand iCommand : this.commandSet) {
            if (!iCommand.canCommandSenderUseCommand(iCommandSender)) continue;
            arrayList.add(iCommand);
        }
        return arrayList;
    }

    @Override
    public Map getCommands() {
        return this.commandMap;
    }

    public int getUsernameIndex(ICommand iCommand, String[] stringArray) {
        if (iCommand == null) {
            return -1;
        }
        for (int i = 0; i < stringArray.length; ++i) {
            if (!iCommand.isUsernameIndex(stringArray, i) || !PlayerSelector._a(stringArray[i])) continue;
            return i;
        }
        return -1;
    }
}

