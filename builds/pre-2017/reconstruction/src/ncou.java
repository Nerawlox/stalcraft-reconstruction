/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.mods.brushedit.pidb;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

public class ncou
extends CommandBase {
    @Override
    public String getCommandName() {
        return "newbrush";
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
        if (pidb2._c == null) {
            entityPlayer.addChatMessage("\u0421\u043d\u0430\u0447\u0430\u043b\u0430 \u0432\u044b\u0431\u0435\u0440\u0438\u0442\u0435 \u0431\u043b\u043e\u043a!");
            return;
        }
        if (stringArray.length != 1) {
            entityPlayer.addChatMessage("Usage: /newbrush <brush_name>");
            return;
        }
        String string = stringArray[0];
        if (pidb2._b.containsKey(string)) {
            entityPlayer.addChatMessage("\u042d\u0442\u043e \u043d\u0430\u0437\u0432\u0430\u043d\u0438\u0435 \u043a\u0438\u0441\u0442\u0438 \u0443\u0436\u0435 \u0437\u0430\u043d\u044f\u0442\u043e!");
            return;
        }
        pidb2._b.put(string, pidb2._c);
        pidb2._c = null;
        entityPlayer.addChatMessage("\u041a\u0438\u0441\u0442\u044c \u0441\u043e\u0437\u0434\u0430\u043d\u0430.");
    }
}

