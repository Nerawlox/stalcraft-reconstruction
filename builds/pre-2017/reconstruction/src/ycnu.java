/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.brushedit.pidb;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class ycnu
extends CommandBase {
    @Override
    public String getCommandName() {
        return "select";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        if (!(iCommandSender instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer entityPlayer = (EntityPlayer)iCommandSender;
        if (stringArray.length != 1 || !stringArray[0].equals("1") && !stringArray[0].equals("2")) {
            entityPlayer.addChatMessage("Usage: /select <1/2>");
            return;
        }
        pidb pidb2 = pidb._a(entityPlayer);
        einh einh2 = new einh(entityPlayer)._k();
        if (stringArray[0].equals("1")) {
            pidb2._d = einh2;
        } else {
            pidb2._e = einh2;
        }
        entityPlayer.addChatMessage("\u0422\u043e\u0447\u043a\u0430 " + stringArray[0] + " \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d\u0430 \u043d\u0430 " + einh2);
        if (pidb2._d != null && pidb2._e != null) {
            long l = pidb2._d._a(pidb2._e);
            entityPlayer.addChatMessage("\u0412\u044b\u0434\u0435\u043b\u0435\u043d\u043e \u0431\u043b\u043e\u043a\u043e\u0432: " + l);
        }
    }
}

