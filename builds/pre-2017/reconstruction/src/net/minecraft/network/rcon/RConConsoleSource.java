/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.rcon;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class RConConsoleSource
implements ICommandSender {
    public static final RConConsoleSource _a = new RConConsoleSource();
    public StringBuffer _b = new StringBuffer();

    public void _a() {
        this._b.setLength(0);
    }

    public String _b() {
        return this._b.toString();
    }

    @Override
    public String getCommandSenderName() {
        return "Rcon";
    }

    @Override
    public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
        this._b.append(chatMessageComponent.toString());
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return true;
    }

    @Override
    public ChunkCoordinates func_82114_b() {
        return new ChunkCoordinates(0, 0, 0);
    }

    @Override
    public World getEntityWorld() {
        return MinecraftServer._I().getEntityWorld();
    }
}

