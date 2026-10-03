/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.commands;

import java.util.List;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import noppes.npcs.EntityNPCInterface;

public class CommandCrashNpc
extends CommandBase {
    @Override
    public String getCommandName() {
        return "crashnpc";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/crashnpc <crash mode>";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        EntityPlayer entityPlayer = (EntityPlayer)iCommandSender;
        List list = entityPlayer.worldObj.getEntitiesWithinAABB(EntityNPCInterface.class, entityPlayer.boundingBox._b(5.0, 5.0, 5.0));
        EntityNPCInterface entityNPCInterface = null;
        double d = 100000.0;
        for (EntityNPCInterface entityNPCInterface2 : list) {
            double d2 = entityNPCInterface2.getDistanceToEntity(entityPlayer);
            if (!(d2 < d)) continue;
            d = d2;
            entityNPCInterface = entityNPCInterface2;
        }
        if (entityNPCInterface == null) {
            iCommandSender.sendChatToPlayer(ChatMessageComponent._d("NPC not found"));
            return;
        }
        int n = Integer.parseInt(stringArray[0]);
        iCommandSender.sendChatToPlayer(ChatMessageComponent._d("Crash mode for " + entityNPCInterface.display.name + " set to " + n));
        entityNPCInterface.crashMode = n;
    }
}

