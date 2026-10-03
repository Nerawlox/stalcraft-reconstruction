/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client;

import cpw.mods.fml.client.FMLClientHandler;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CommandEvent;

public class ClientCommandHandler
extends CommandHandler {
    public static final ClientCommandHandler instance = new ClientCommandHandler();
    public String[] latestAutoComplete = null;

    @Override
    public int executeCommand(ICommandSender iCommandSender, String string) {
        if ((string = string.trim()).startsWith("/")) {
            string = string.substring(1);
        }
        String[] stringArray = string.split(" ");
        String[] stringArray2 = new String[stringArray.length - 1];
        String string2 = stringArray[0];
        System.arraycopy(stringArray, 1, stringArray2, 0, stringArray2.length);
        ICommand iCommand = (ICommand)this.getCommands().get(string2);
        try {
            if (iCommand == null) {
                return 0;
            }
            if (iCommand.canCommandSenderUseCommand(iCommandSender)) {
                CommandEvent commandEvent = new CommandEvent(iCommand, iCommandSender, stringArray2);
                if (MinecraftForge.EVENT_BUS.post(commandEvent)) {
                    if (commandEvent.exception != null) {
                        throw commandEvent.exception;
                    }
                    return 0;
                }
                iCommand.processCommand(iCommandSender, stringArray2);
                return 1;
            }
            iCommandSender.sendChatToPlayer(this.format("commands.generic.permission")._a(EnumChatFormatting._m));
        }
        catch (pksd pksd2) {
            iCommandSender.sendChatToPlayer(this.format("commands.generic.usage", this.format(pksd2.getMessage(), pksd2._a()))._a(EnumChatFormatting._m));
        }
        catch (cekk cekk2) {
            iCommandSender.sendChatToPlayer(this.format(cekk2.getMessage(), cekk2._a())._a(EnumChatFormatting._m));
        }
        catch (Throwable throwable) {
            iCommandSender.sendChatToPlayer(this.format("commands.generic.exception")._a(EnumChatFormatting._m));
            throwable.printStackTrace();
        }
        return 0;
    }

    private ChatMessageComponent format(String string, Object ... objectArray) {
        return ChatMessageComponent._b(string, objectArray);
    }

    private ChatMessageComponent format(String string) {
        return ChatMessageComponent._e(string);
    }

    public void autoComplete(String string, String string2) {
        this.latestAutoComplete = null;
        if (string.charAt(0) == '/') {
            List list;
            string = string.substring(1);
            Minecraft minecraft = FMLClientHandler.instance().getClient();
            if (minecraft._B instanceof fndz && (list = this.getPossibleCommands(minecraft._t, string)) != null && !list.isEmpty()) {
                if (string.indexOf(32) == -1) {
                    for (int i = 0; i < list.size(); ++i) {
                        list.set(i, (Object)((Object)EnumChatFormatting._h) + "/" + (String)list.get(i) + (Object)((Object)EnumChatFormatting._v));
                    }
                } else {
                    for (int i = 0; i < list.size(); ++i) {
                        list.set(i, (Object)((Object)EnumChatFormatting._h) + (String)list.get(i) + (Object)((Object)EnumChatFormatting._v));
                    }
                }
                this.latestAutoComplete = list.toArray(new String[list.size()]);
            }
        }
    }
}

