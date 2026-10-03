/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.respawn;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.EnumGameType;

public class eidj
extends CommandBase {
    @Override
    public String getCommandName() {
        return "setspawn";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/setspawn <x> <y> <z>";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        try {
            int n;
            int n2;
            int n3;
            if (stringArray.length > 0) {
                n3 = Integer.parseInt(stringArray[0]);
                n2 = Integer.parseInt(stringArray[1]);
                n = Integer.parseInt(stringArray[2]);
            } else {
                ChunkCoordinates chunkCoordinates = iCommandSender.func_82114_b();
                n3 = chunkCoordinates._a;
                n2 = chunkCoordinates._b;
                n = chunkCoordinates._c;
            }
            iCommandSender.getEntityWorld().provider._b(n3, n2, n);
            iCommandSender.sendChatToPlayer(new ChatMessageComponent()._a("\u0421\u043f\u0430\u0432\u043d\u043f\u043e\u0438\u043d\u0442 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d."));
            if (iCommandSender.getEntityWorld().getWorldInfo()._r() != EnumGameType._d) {
                iCommandSender.sendChatToPlayer(new ChatMessageComponent()._a("\u0423\u0441\u0442\u0430\u043d\u043e\u0432\u0438\u0442\u0435 \u0438\u0433\u0440\u043e\u0432\u043e\u0439 \u0440\u0435\u0436\u0438\u043c \u043d\u0430 2!"));
            }
        }
        catch (ArrayIndexOutOfBoundsException | NumberFormatException runtimeException) {
            throw new cene(this.getCommandUsage(iCommandSender), new Object[0]);
        }
    }
}

