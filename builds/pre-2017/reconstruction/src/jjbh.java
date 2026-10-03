/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandClearInventory;
import net.minecraft.command.CommandDebug;
import net.minecraft.command.CommandDefaultGameMode;
import net.minecraft.command.CommandDifficulty;
import net.minecraft.command.CommandEffect;
import net.minecraft.command.CommandEnchant;
import net.minecraft.command.CommandGameMode;
import net.minecraft.command.CommandGameRule;
import net.minecraft.command.CommandGive;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.CommandHelp;
import net.minecraft.command.CommandKill;
import net.minecraft.command.CommandPlaySound;
import net.minecraft.command.CommandServerBan;
import net.minecraft.command.CommandServerBanIp;
import net.minecraft.command.CommandServerBanlist;
import net.minecraft.command.CommandServerDeop;
import net.minecraft.command.CommandServerEmote;
import net.minecraft.command.CommandServerKick;
import net.minecraft.command.CommandServerList;
import net.minecraft.command.CommandServerMessage;
import net.minecraft.command.CommandServerOp;
import net.minecraft.command.CommandServerPardon;
import net.minecraft.command.CommandServerPardonIp;
import net.minecraft.command.CommandServerPublishLocal;
import net.minecraft.command.CommandServerSaveAll;
import net.minecraft.command.CommandServerSaveOff;
import net.minecraft.command.CommandServerSaveOn;
import net.minecraft.command.CommandServerSay;
import net.minecraft.command.CommandServerStop;
import net.minecraft.command.CommandServerTp;
import net.minecraft.command.CommandServerWhitelist;
import net.minecraft.command.CommandSetPlayerTimeout;
import net.minecraft.command.CommandSetSpawnpoint;
import net.minecraft.command.CommandShowSeed;
import net.minecraft.command.CommandSpreadPlayers;
import net.minecraft.command.CommandTime;
import net.minecraft.command.CommandToggleDownfall;
import net.minecraft.command.CommandWeather;
import net.minecraft.command.CommandXP;
import net.minecraft.command.IAdminCommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.ServerCommandScoreboard;
import net.minecraft.scoreboard.ServerCommandTestFor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;

public class jjbh
extends CommandHandler
implements IAdminCommand {
    public jjbh() {
        this.registerCommand(new CommandTime());
        this.registerCommand(new CommandGameMode());
        this.registerCommand(new CommandDifficulty());
        this.registerCommand(new CommandDefaultGameMode());
        this.registerCommand(new CommandKill());
        this.registerCommand(new CommandToggleDownfall());
        this.registerCommand(new CommandWeather());
        this.registerCommand(new CommandXP());
        this.registerCommand(new CommandServerTp());
        this.registerCommand(new CommandGive());
        this.registerCommand(new CommandEffect());
        this.registerCommand(new CommandEnchant());
        this.registerCommand(new CommandServerEmote());
        this.registerCommand(new CommandShowSeed());
        this.registerCommand(new CommandHelp());
        this.registerCommand(new CommandDebug());
        this.registerCommand(new CommandServerMessage());
        this.registerCommand(new CommandServerSay());
        this.registerCommand(new CommandSetSpawnpoint());
        this.registerCommand(new CommandGameRule());
        this.registerCommand(new CommandClearInventory());
        this.registerCommand(new ServerCommandTestFor());
        this.registerCommand(new CommandSpreadPlayers());
        this.registerCommand(new CommandPlaySound());
        this.registerCommand(new ServerCommandScoreboard());
        if (MinecraftServer._I()._W()) {
            this.registerCommand(new CommandServerOp());
            this.registerCommand(new CommandServerDeop());
            this.registerCommand(new CommandServerStop());
            this.registerCommand(new CommandServerSaveAll());
            this.registerCommand(new CommandServerSaveOff());
            this.registerCommand(new CommandServerSaveOn());
            this.registerCommand(new CommandServerBanIp());
            this.registerCommand(new CommandServerPardonIp());
            this.registerCommand(new CommandServerBan());
            this.registerCommand(new CommandServerBanlist());
            this.registerCommand(new CommandServerPardon());
            this.registerCommand(new CommandServerKick());
            this.registerCommand(new CommandServerList());
            this.registerCommand(new CommandServerWhitelist());
            this.registerCommand(new CommandSetPlayerTimeout());
        } else {
            this.registerCommand(new CommandServerPublishLocal());
        }
        CommandBase.setAdminCommander(this);
    }

    @Override
    public void _a(ICommandSender iCommandSender, int n, String string, Object ... objectArray) {
        boolean bl = true;
        if (iCommandSender instanceof TileEntityCommandBlock && !MinecraftServer._I()._j[0].getGameRules()._b("commandBlockOutput")) {
            bl = false;
        }
        ChatMessageComponent chatMessageComponent = ChatMessageComponent._b("chat.type.admin", iCommandSender.getCommandSenderName(), ChatMessageComponent._b(string, objectArray));
        chatMessageComponent._a(EnumChatFormatting._h);
        chatMessageComponent._b(true);
        if (bl) {
            for (EntityPlayerMP entityPlayerMP : MinecraftServer._I().__ag()._e) {
                if (entityPlayerMP == iCommandSender || !MinecraftServer._I().__ag()._g(entityPlayerMP.getCommandSenderName())) continue;
                entityPlayerMP.sendChatToPlayer(chatMessageComponent);
            }
        }
        if (iCommandSender != MinecraftServer._I()) {
            MinecraftServer._I().sendChatToPlayer(chatMessageComponent);
        }
        if ((n & 1) != 1) {
            iCommandSender.sendChatToPlayer(ChatMessageComponent._b(string, objectArray));
        }
    }
}

