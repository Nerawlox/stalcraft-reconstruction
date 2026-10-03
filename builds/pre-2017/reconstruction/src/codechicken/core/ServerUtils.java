/*
 * Decompiled with CFR 0.152.
 */
package codechicken.core;

import codechicken.core.CommonUtils;
import codechicken.core.IGuiPacketSender;
import codechicken.lib.packet.PacketCustom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;

public class ServerUtils
extends CommonUtils {
    public static MinecraftServer mc() {
        return MinecraftServer._I();
    }

    public static EntityPlayerMP getPlayer(String string) {
        return ServerUtils.mc().__ag()._h(string);
    }

    public static ArrayList<EntityPlayer> getAllPlayers() {
        return new ArrayList<EntityPlayer>(ServerUtils.mc().__ag()._e);
    }

    public static ArrayList<EntityPlayer> getPlayersInDimension(int n) {
        ArrayList<EntityPlayer> arrayList = ServerUtils.getAllPlayers();
        Iterator<EntityPlayer> iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next().dimension == n) continue;
            iterator2.remove();
        }
        return arrayList;
    }

    public static void sendChatToOps(String string) {
        List<String> list2 = ServerUtils.splitChat(string);
        for (String string2 : list2) {
            PacketCustom.sendToOps(new Packet3Chat(ChatMessageComponent._d(string2)));
        }
    }

    public static void sendChatToAll(String string) {
        List<String> list2 = ServerUtils.splitChat(string);
        for (String string2 : list2) {
            PacketCustom.sendToClients(new Packet3Chat(ChatMessageComponent._d(string2)));
        }
    }

    public static void sendChatTo(EntityPlayerMP entityPlayerMP, String string) {
        List<String> list2 = ServerUtils.splitChat(string);
        for (String string2 : list2) {
            PacketCustom.sendToPlayer(new Packet3Chat(ChatMessageComponent._d(string2)), entityPlayerMP);
        }
    }

    public static void openSMPContainer(EntityPlayerMP entityPlayerMP, Container container, IGuiPacketSender iGuiPacketSender) {
        entityPlayerMP.func_71117_bO();
        entityPlayerMP.closeContainer();
        iGuiPacketSender.sendPacket(entityPlayerMP, entityPlayerMP.currentWindowId);
        entityPlayerMP.openContainer = container;
        entityPlayerMP.openContainer.windowId = entityPlayerMP.currentWindowId;
        entityPlayerMP.openContainer.func_75132_a(entityPlayerMP);
    }

    public static boolean isPlayerOP(String string) {
        return ServerUtils.mc().__ag()._g(string);
    }

    public static boolean isPlayerOwner(String string) {
        return ServerUtils.mc()._N() && ServerUtils.mc()._M().equalsIgnoreCase(string);
    }

    public static void registerCommand(ICommand iCommand) {
        ((CommandHandler)ServerUtils.mc()._J()).registerCommand(iCommand);
    }
}

