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
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetServerHandler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class NEISPH
implements PacketCustom.IServerPacketHandler {
    public static final String channel = "NEI";

    @Override
    public void handlePacket(PacketCustom packetCustom, NetServerHandler netServerHandler, EntityPlayerMP entityPlayerMP) {
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
                NEIServerUtils.setHourForward(entityPlayerMP.worldObj, packetCustom.readUByte(), true);
                break;
            }
            case 8: {
                NEIServerUtils.healPlayer(entityPlayerMP);
                break;
            }
            case 9: {
                NEIServerUtils.toggleRaining(entityPlayerMP.worldObj, true);
                break;
            }
            case 10: {
                this.sendLoginState(entityPlayerMP);
                break;
            }
            case 11: {
                entityPlayerMP.func_71110_a(entityPlayerMP.openContainer, entityPlayerMP.openContainer.getInventory());
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
                this.handleMobSpawnerID(entityPlayerMP.worldObj, packetCustom.readCoord(), packetCustom.readString());
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
        ItemStack itemStack = packetCustom.readItemStack(true);
        Slot slot = entityPlayerMP.openContainer.getSlot(s);
        if (slot instanceof SlotDummy) {
            slot.putStack(itemStack);
        }
    }

    private void handleContainerPacket(EntityPlayerMP entityPlayerMP, PacketCustom packetCustom) {
        if (entityPlayerMP.openContainer instanceof ContainerExtended) {
            ((ContainerExtended)entityPlayerMP.openContainer).handleInputPacket(packetCustom);
        }
    }

    private void handleMobSpawnerID(World world, BlockCoord blockCoord, String string) {
        TileEntity tileEntity = world.getBlockTileEntity(blockCoord.x, blockCoord.y, blockCoord.z);
        if (tileEntity instanceof xtcq) {
            ((xtcq)tileEntity)._a()._a(string);
            tileEntity.onInventoryChanged();
            world.markBlockForUpdate(blockCoord.x, blockCoord.y, blockCoord.z);
        }
    }

    private void handlePropertyChange(EntityPlayerMP entityPlayerMP, PacketCustom packetCustom) {
        String string = packetCustom.readString();
        if (NEIServerConfig.canPlayerPerformAction(entityPlayerMP.username, string)) {
            NEIServerConfig.disableAction(entityPlayerMP.dimension, string, packetCustom.readBoolean());
        }
    }

    private void processCreativeInv(EntityPlayerMP entityPlayerMP, boolean bl) {
        if (bl) {
            ServerUtils.openSMPContainer(entityPlayerMP, new ContainerCreativeInv(entityPlayerMP, new ExtendedCreativeInv(NEIServerConfig.forPlayer(entityPlayerMP.username), Side.SERVER)), new IGuiPacketSender(){

                @Override
                public void sendPacket(EntityPlayerMP entityPlayerMP, int n) {
                    PacketCustom packetCustom = new PacketCustom(NEISPH.channel, 23);
                    packetCustom.writeBoolean(true);
                    packetCustom.writeByte(n);
                    packetCustom.sendToPlayer(entityPlayerMP);
                }
            });
        } else {
            entityPlayerMP.closeContainer();
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
        ItemStack itemStack = packetCustom.readItemStack();
        if (itemStack == null) {
            ServerUtils.sendChatTo(entityPlayerMP, "\u00a7fNo such item.");
            return;
        }
        itemStack._b = packetCustom.readInt();
        NEIServerUtils.givePlayerItem(entityPlayerMP, itemStack, bl, linkedList, bl2);
    }

    private void setInventorySlot(EntityPlayerMP entityPlayerMP, PacketCustom packetCustom) {
        boolean bl = packetCustom.readBoolean();
        short s = packetCustom.readShort();
        ItemStack itemStack = packetCustom.readItemStack();
        ItemStack itemStack2 = NEIServerUtils.getSlotContents(entityPlayerMP, s, bl);
        boolean bl2 = itemStack == null || itemStack2 != null && NEIServerUtils.areStacksSameType(itemStack, itemStack2) && itemStack._b < itemStack2._b;
        if (NEIServerConfig.canPlayerPerformAction(entityPlayerMP.username, bl2 ? "delete" : "item")) {
            NEIServerUtils.setSlotContents(entityPlayerMP, s, itemStack, bl);
        }
    }

    private void modifyEnchantment(EntityPlayerMP entityPlayerMP, int n, int n2, boolean bl) {
        ContainerEnchantmentModifier containerEnchantmentModifier = (ContainerEnchantmentModifier)entityPlayerMP.openContainer;
        if (bl) {
            containerEnchantmentModifier.addEnchantment(n, n2);
        } else {
            containerEnchantmentModifier.removeEnchantment(n);
        }
    }

    private void openEnchantmentGui(EntityPlayerMP entityPlayerMP) {
        ServerUtils.openSMPContainer(entityPlayerMP, new ContainerEnchantmentModifier(entityPlayerMP.inventory, entityPlayerMP.worldObj, 0, 0, 0), new IGuiPacketSender(){

            @Override
            public void sendPacket(EntityPlayerMP entityPlayerMP, int n) {
                PacketCustom packetCustom = new PacketCustom(NEISPH.channel, 21);
                packetCustom.writeByte(n);
                packetCustom.sendToPlayer(entityPlayerMP);
            }
        });
    }

    private void openPotionGui(EntityPlayerMP entityPlayerMP, PacketCustom packetCustom) {
        InventoryBasic inventoryBasic = new InventoryBasic("potionStore", true, 9);
        for (int i = 0; i < inventoryBasic.getSizeInventory(); ++i) {
            inventoryBasic.setInventorySlotContents(i, packetCustom.readItemStack());
        }
        ServerUtils.openSMPContainer(entityPlayerMP, new ContainerPotionCreator(entityPlayerMP.inventory, inventoryBasic), new IGuiPacketSender(){

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
        PlayerSave playerSave = NEIServerConfig.forPlayer(entityPlayerMP.username);
        for (String object22 : NEIActions.nameActionMap.keySet()) {
            if (NEIServerConfig.canPlayerPerformAction(entityPlayerMP.username, object22)) {
                linkedList.add(object22);
            }
            if (NEIServerConfig.isActionDisabled(entityPlayerMP.dimension, object22)) {
                linkedList2.add(object22);
            }
            if (!playerSave.isActionEnabled(object22)) continue;
            linkedList3.add(object22);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<ItemKey, HashSet<String>> entry : NEIServerConfig.bannedblocks.entrySet()) {
            if (NEIServerConfig.isPlayerInList(entityPlayerMP.username, entry.getValue(), true)) continue;
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
        System.out.println("Sending serverside check to: " + entityPlayerMP.username);
        PacketCustom packetCustom = new PacketCustom(channel, 1);
        packetCustom.writeByte(0);
        packetCustom.writeString(CommonUtils.getWorldName(entityPlayerMP.worldObj));
        packetCustom.sendToPlayer(entityPlayerMP);
    }

    public static void sendAddMagneticItemTo(EntityPlayerMP entityPlayerMP, EntityItem entityItem) {
        PacketCustom packetCustom = new PacketCustom(channel, 13);
        packetCustom.writeInt(entityItem.entityId);
        packetCustom.sendToPlayer(entityPlayerMP);
    }
}

