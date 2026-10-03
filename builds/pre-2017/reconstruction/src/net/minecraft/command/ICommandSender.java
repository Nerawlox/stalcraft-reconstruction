/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public interface ICommandSender {
    public String getCommandSenderName();

    public void sendChatToPlayer(ChatMessageComponent var1);

    public boolean canCommandSenderUseCommand(int var1, String var2);

    public ChunkCoordinates func_82114_b();

    public World getEntityWorld();
}

