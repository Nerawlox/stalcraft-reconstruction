/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.brushedit.eidj;
import gloomyfolken.mods.brushedit.pidb;
import java.util.Map;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class ntqb
extends CommandBase {
    @Override
    public String getCommandName() {
        return "brushlist";
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
        pidb pidb2 = pidb._a(entityPlayer);
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, eidj> entry : pidb2._b.entrySet()) {
            stringBuffer.append(entry.getKey()).append(", ");
        }
        entityPlayer.addChatMessage("\u0421\u043e\u0437\u0434\u0430\u043d\u043d\u044b\u0435 \u043a\u0438\u0441\u0442\u0438:");
        entityPlayer.addChatMessage(stringBuffer.toString());
    }
}

