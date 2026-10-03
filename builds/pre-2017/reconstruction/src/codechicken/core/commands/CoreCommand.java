/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core.commands;

import codechicken.core.ServerUtils;
import java.util.List;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public abstract class CoreCommand
implements ICommand {
    public abstract boolean OPOnly();

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "/" + this.getCommandName() + " help";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) {
        WCommandSender wCommandSender = new WCommandSender(iCommandSender);
        if (stringArray.length < this.minimumParameters() || stringArray.length == 1 && stringArray[0].equals("help")) {
            this.printHelp(wCommandSender);
            return;
        }
        String string = this.getCommandName();
        for (String string2 : stringArray) {
            string = string + " " + string2;
        }
        this.handleCommand(string, wCommandSender.getCommandSenderName(), stringArray, wCommandSender);
    }

    public abstract void handleCommand(String var1, String var2, String[] var3, WCommandSender var4);

    public abstract void printHelp(WCommandSender var1);

    public final EntityPlayerMP getPlayer(String string) {
        return ServerUtils.getPlayer(string);
    }

    public WorldServer getWorld(int n) {
        return DimensionManager.getWorld(n);
    }

    public WorldServer getWorld(EntityPlayer entityPlayer) {
        return (WorldServer)entityPlayer.worldObj;
    }

    public Integer parseInteger(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    public int compareTo(Object object) {
        return this.getCommandName().compareTo(((ICommand)object).getCommandName());
    }

    @Override
    public List<?> getCommandAliases() {
        return null;
    }

    @Override
    public List<?> addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return false;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        if (this.OPOnly()) {
            if (iCommandSender instanceof EntityPlayer) {
                return ServerUtils.isPlayerOP(iCommandSender.getCommandSenderName());
            }
            return iCommandSender instanceof MinecraftServer;
        }
        return true;
    }

    public abstract int minimumParameters();

    public class WCommandSender
    implements ICommandSender {
        public ICommandSender wrapped;

        public WCommandSender(ICommandSender iCommandSender) {
            this.wrapped = iCommandSender;
        }

        @Override
        public String getCommandSenderName() {
            return this.wrapped.getCommandSenderName();
        }

        @Override
        public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
            this.wrapped.sendChatToPlayer(chatMessageComponent);
        }

        public void sendChatToPlayer(String string) {
            this.wrapped.sendChatToPlayer(ChatMessageComponent._d(string));
        }

        @Override
        public boolean canCommandSenderUseCommand(int n, String string) {
            return this.wrapped.canCommandSenderUseCommand(n, string);
        }

        @Override
        public ChunkCoordinates func_82114_b() {
            return this.wrapped.func_82114_b();
        }

        @Override
        public World getEntityWorld() {
            return this.wrapped.getEntityWorld();
        }
    }
}

