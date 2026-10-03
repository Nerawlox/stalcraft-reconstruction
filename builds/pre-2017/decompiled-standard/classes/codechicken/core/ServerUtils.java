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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.zwat;

public class ServerUtils
extends CommonUtils {
    public static dzfd mc() {
        return dzfd._I();
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
            if (iterator2.next().field_71093_bK == n) continue;
            iterator2.remove();
        }
        return arrayList;
    }

    public static void sendChatToOps(String string) {
        List<String> list2 = ServerUtils.splitChat(string);
        for (String string2 : list2) {
            PacketCustom.sendToOps(new cwaz(zwat._d(string2)));
        }
    }

    public static void sendChatToAll(String string) {
        List<String> list2 = ServerUtils.splitChat(string);
        for (String string2 : list2) {
            PacketCustom.sendToClients(new cwaz(zwat._d(string2)));
        }
    }

    public static void sendChatTo(EntityPlayerMP entityPlayerMP, String string) {
        List<String> list2 = ServerUtils.splitChat(string);
        for (String string2 : list2) {
            PacketCustom.sendToPlayer(new cwaz(zwat._d(string2)), entityPlayerMP);
        }
    }

    public static void openSMPContainer(EntityPlayerMP entityPlayerMP, jjgc jjgc2, IGuiPacketSender iGuiPacketSender) {
        entityPlayerMP.func_71117_bO();
        entityPlayerMP.func_71128_l();
        iGuiPacketSender.sendPacket(entityPlayerMP, entityPlayerMP.field_71139_cq);
        entityPlayerMP.field_71070_bA = jjgc2;
        entityPlayerMP.field_71070_bA.field_75152_c = entityPlayerMP.field_71139_cq;
        entityPlayerMP.field_71070_bA.func_75132_a(entityPlayerMP);
    }

    public static boolean isPlayerOP(String string) {
        return ServerUtils.mc().__ag()._g(string);
    }

    public static boolean isPlayerOwner(String string) {
        return ServerUtils.mc()._N() && ServerUtils.mc()._M().equalsIgnoreCase(string);
    }

    public static void registerCommand(kmew kmew2) {
        ((ohmz)ServerUtils.mc()._J()).func_71560_a(kmew2);
    }
}

