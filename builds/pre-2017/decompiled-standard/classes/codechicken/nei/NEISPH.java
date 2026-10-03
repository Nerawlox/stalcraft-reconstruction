/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.CommonUtils;
import codechicken.core.IGuiPacketSender;
import codechicken.core.ServerUtils;
import codechicken.core.inventory.ContainerExtended;
import codechicken.core.inventory.SlotDummy;
import codechicken.lib.inventory.ItemKey;
import codechicken.lib.packet.PacketCustom;
import codechicken.lib.vec.BlockCoord;
import codechicken.nei.ContainerCreativeInv;
import codechicken.nei.ContainerEnchantmentModifier;
import codechicken.nei.ContainerPotionCreator;
import codechicken.nei.ExtendedCreativeInv;
import codechicken.nei.NEIActions;
import codechicken.nei.NEIServerConfig;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.PlayerSave;
import cpw.mods.fml.relauncher.Side;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;

public class NEISPH
implements PacketCustom.IServerPacketHandler {
    public static final String channel = "NEI";

    @Override
    public void handlePacket(PacketCustom packetCustom, xbvu xbvu2, EntityPlayerMP entityPlayerMP) {
        if (!NEIServerConfig.authenticatePacket(entityPlayerMP, packetCustom)) {
            return;
        }
        switch (packetCustom.getType()) {
            case 1: {
                this.handleGiveItem(entityPlayerMP, packetCustom);
                break;
            }
            case 4: {
                NEIServerUtils.deleteAllItems(entityPlayerMP);
                break;
            }
            case 5: {
                this.setInventorySlot(entityPlayerMP, packetCustom);
                break;
            }
            case 6: {
                NEIServerUtils.toggleMagnetMode(entityPlayerMP);
                break;
            }
            case 7: {
                NEIServerUtils.setHourForward(entityPlayerMP.field_70170_p, packetCustom.readUByte(), true);
                break;
            }
            case 8: {
                NEIServerUtils.healPlayer(entityPlayerMP);
                break;
            }
            case 9: {
                NEIServerUtils.toggleRaining(entityPlayerMP.field_70170_p, true);
                break;
            }
            case 10: {
                this.sendLoginState(entityPlayerMP);
                break;
            }
            case 11: {
                entityPlayerMP.func_71110_a(entityPlayerMP.field_71070_bA, entityPlayerMP.field_71070_bA.func_75138_a());
                break;
            }
            case 12: {
                this.handlePropertyChange(entityPlayerMP, packetCustom);
                break;
            }
            case 13: {
                NEIServerUtils.setGamemode(entityPlayerMP, packetCustom.readUByte());
                break;
            }
            case 14: {
                NEIServerUtils.cycleCreativeInv(entityPlayerMP, packetCustom.readInt());
                break;
            }
            case 15: {
                this.handleMobSpawnerID(entityPlayerMP.field_70170_p, packetCustom.readCoord(), packetCustom.readString());
                break;
            }
            case 20: {
                this.handleContainerPacket(entityPlayerMP, packetCustom);
                break;
            }
            case 21: {
                this.openEnchantmentGui(entityPlayerMP);
                break;
            }
            case 22: {
                this.modifyEnchantment(entityPlayerMP, packetCustom.readUByte(), packetCustom.readUByte(), packetCustom.readBoolean());
                break;
            }
            case 23: {
                this.processCreativeInv(entityPlayerMP, packetCustom.readBoolean());
                break;
            }
            case 24: {
                this.openPotionGui(entityPlayerMP, packetCustom);
                break;
            }
            case 25: {
                this.handleDummySlotSet(entityPlayerMP, packetCustom);
            }
        }
    }

    private void handleDummySlotSet(EntityPlayerMP entityPlayerMP, PacketCustom packetCustom) {
        short s = packetCustom.readShort();
        cvzo cvzo2 = packetCustom.readItemStack(true);
        yeso yeso2 = entityPlayerMP.field_71070_bA.func_75139_a(s);
        if (yeso2 instanceof SlotDummy) {
            yeso2.func_75215_d(cvzo2);
        }
    }

    private void handleContainerPacket(EntityPlayerMP entityPlayerMP, PacketCustom packetCustom) {
        if (entityPlayerMP.field_71070_bA instanceof ContainerExtended) {
            ((ContainerExtended)entityPlayerMP.field_71070_bA).handleInputPacket(packetCustom);
        }
    }

    private void handleMobSpawnerID(ozlu ozlu2, BlockCoord blockCoord, String string) {
        hurg hurg2 = ozlu2.func_72796_p(blockCoord.x, blockCoord.y, blockCoord.z);
        if (hurg2 instanceof xtcq) {
            ((xtcq)hurg2)._a()._a(string);
            hurg2.func_70296_d();
            ozlu2.func_72845_h(blockCoord.x, blockCoord.y, blockCoord.z);
        }
    }

    private void handlePropertyChange(EntityPlayerMP entityPlayerMP, PacketCustom packetCustom) {
        String string = packetCustom.readString();
        if (NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, string)) {
            NEIServerConfig.disableAction(entityPlayerMP.field_71093_bK, string, packetCustom.readBoolean());
        }
    }

    private void processCreativeInv(EntityPlayerMP entityPlayerMP, boolean bl) {
        if (bl) {
            ServerUtils.openSMPContainer(entityPlayerMP, new ContainerCreativeInv(entityPlayerMP, new ExtendedCreativeInv(NEIServerConfig.forPlayer(entityPlayerMP.field_71092_bJ), Side.SERVER)), new IGuiPacketSender(){

                @Override
                public void sendPacket(EntityPlayerMP entityPlayerMP, int n) {
                    PacketCustom packetCustom = new PacketCustom(NEISPH.channel, 23);
                    packetCustom.writeBoolean(true);
                    packetCustom.writeByte(n);
                    packetCustom.sendToPlayer(entityPlayerMP);
                }
            });
        } else {
            entityPlayerMP.func_71128_l();
            PacketCustom packetCustom = new PacketCustom(channel, 23);
            packetCustom.writeBoolean(false);
            packetCustom.sendToPlayer(entityPlayerMP);
        }
    }

    private void handleGiveItem(EntityPlayerMP entityPlayerMP, PacketCustom packetCustom) {
        boolean bl = packetCustom.readBoolean();
        boolean bl2 = packetCustom.readBoolean();
        int n = packetCustom.readUByte();
        LinkedList<String> linkedList = new LinkedList<String>();
        for (int i = 0; i < n; ++i) {
            linkedList.add(packetCustom.readString());
        }
        cvzo cvzo2 = packetCustom.readItemStack();
        if (cvzo2 == null) {
            ServerUtils.sendChatTo(entityPlayerMP, "\u00a7fNo such item.");
            return;
        }
        cvzo2._b = packetCustom.readInt();
        NEIServerUtils.givePlayerItem(entityPlayerMP, cvzo2, bl, linkedList, bl2);
    }

    private void setInventorySlot(EntityPlayerMP entityPlayerMP, PacketCustom packetCustom) {
        boolean bl = packetCustom.readBoolean();
        short s = packetCustom.readShort();
        cvzo cvzo2 = packetCustom.readItemStack();
        cvzo cvzo3 = NEIServerUtils.getSlotContents(entityPlayerMP, s, bl);
        boolean bl2 = cvzo2 == null || cvzo3 != null && NEIServerUtils.areStacksSameType(cvzo2, cvzo3) && cvzo2._b < cvzo3._b;
        if (NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, bl2 ? "delete" : "item")) {
            NEIServerUtils.setSlotContents(entityPlayerMP, s, cvzo2, bl);
        }
    }

    private void modifyEnchantment(EntityPlayerMP entityPlayerMP, int n, int n2, boolean bl) {
        ContainerEnchantmentModifier containerEnchantmentModifier = (ContainerEnchantmentModifier)entityPlayerMP.field_71070_bA;
        if (bl) {
            containerEnchantmentModifier.addEnchantment(n, n2);
        } else {
            containerEnchantmentModifier.removeEnchantment(n);
        }
    }

    private void openEnchantmentGui(EntityPlayerMP entityPlayerMP) {
        ServerUtils.openSMPContainer(entityPlayerMP, new ContainerEnchantmentModifier(entityPlayerMP.field_71071_by, entityPlayerMP.field_70170_p, 0, 0, 0), new IGuiPacketSender(){

            @Override
            public void sendPacket(EntityPlayerMP entityPlayerMP, int n) {
                PacketCustom packetCustom = new PacketCustom(NEISPH.channel, 21);
                packetCustom.writeByte(n);
                packetCustom.sendToPlayer(entityPlayerMP);
            }
        });
    }

    private void openPotionGui(EntityPlayerMP entityPlayerMP, PacketCustom packetCustom) {
        tgfo tgfo2 = new tgfo("potionStore", true, 9);
        for (int i = 0; i < tgfo2.func_70302_i_(); ++i) {
            tgfo2.func_70299_a(i, packetCustom.readItemStack());
        }
        ServerUtils.openSMPContainer(entityPlayerMP, new ContainerPotionCreator(entityPlayerMP.field_71071_by, tgfo2), new IGuiPacketSender(){

            @Override
            public void sendPacket(EntityPlayerMP entityPlayerMP, int n) {
                PacketCustom packetCustom = new PacketCustom(NEISPH.channel, 24);
                packetCustom.writeByte(n);
                packetCustom.sendToPlayer(entityPlayerMP);
            }
        });
    }

    public static void sendActionDisabled(int n, String string, boolean bl) {
        new PacketCustom(channel, 11).writeString(string).writeBoolean(bl).sendToDimension(n);
    }

    public static void sendActionEnabled(EntityPlayerMP entityPlayerMP, String string, boolean bl) {
        new PacketCustom(channel, 12).writeString(string).writeBoolean(bl).sendToPlayer(entityPlayerMP);
    }

    private void sendLoginState(EntityPlayerMP entityPlayerMP) {
        LinkedList<String> linkedList = new LinkedList<String>();
        LinkedList<String> linkedList2 = new LinkedList<String>();
        LinkedList<String> linkedList3 = new LinkedList<String>();
        PlayerSave playerSave = NEIServerConfig.forPlayer(entityPlayerMP.field_71092_bJ);
        for (String object22 : NEIActions.nameActionMap.keySet()) {
            if (NEIServerConfig.canPlayerPerformAction(entityPlayerMP.field_71092_bJ, object22)) {
                linkedList.add(object22);
            }
            if (NEIServerConfig.isActionDisabled(entityPlayerMP.field_71093_bK, object22)) {
                linkedList2.add(object22);
            }
            if (!playerSave.isActionEnabled(object22)) continue;
            linkedList3.add(object22);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<ItemKey, HashSet<String>> entry : NEIServerConfig.bannedblocks.entrySet()) {
            if (NEIServerConfig.isPlayerInList(entityPlayerMP.field_71092_bJ, entry.getValue(), true)) continue;
            arrayList.add(entry.getKey());
        }
        PacketCustom packetCustom = new PacketCustom(channel, 10);
        packetCustom.writeByte(linkedList.size());
        for (Object object : linkedList) {
            packetCustom.writeString((String)object);
        }
        packetCustom.writeByte(linkedList2.size());
        for (Object object : linkedList2) {
            packetCustom.writeString((String)object);
        }
        packetCustom.writeByte(linkedList3.size());
        for (Object object : linkedList3) {
            packetCustom.writeString((String)object);
        }
        packetCustom.writeInt(arrayList.size());
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            Object object;
            object = (ItemKey)iterator2.next();
            packetCustom.writeShort(((ItemKey)object).item._d);
            packetCustom.writeShort(((ItemKey)object).item._j());
        }
        packetCustom.sendToPlayer(entityPlayerMP);
    }

    public static void sendHasServerSideTo(EntityPlayerMP entityPlayerMP) {
        System.out.println("Sending serverside check to: " + entityPlayerMP.field_71092_bJ);
        PacketCustom packetCustom = new PacketCustom(channel, 1);
        packetCustom.writeByte(0);
        packetCustom.writeString(CommonUtils.getWorldName(entityPlayerMP.field_70170_p));
        packetCustom.sendToPlayer(entityPlayerMP);
    }

    public static void sendAddMagneticItemTo(EntityPlayerMP entityPlayerMP, EntityItem entityItem) {
        PacketCustom packetCustom = new PacketCustom(channel, 13);
        packetCustom.writeInt(entityItem.field_70157_k);
        packetCustom.sendToPlayer(entityPlayerMP);
    }
}

