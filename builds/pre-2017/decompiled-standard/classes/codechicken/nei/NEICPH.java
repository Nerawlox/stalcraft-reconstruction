/*
 * Decompiled with CFR 0.152.
 */
package codechicken.nei;

import codechicken.core.ClientUtils;
import codechicken.lib.inventory.InventoryUtils;
import codechicken.lib.inventory.ItemKey;
import codechicken.lib.packet.PacketCustom;
import codechicken.nei.ClientHandler;
import codechicken.nei.ContainerCreativeInv;
import codechicken.nei.ExtendedCreativeInv;
import codechicken.nei.GuiEnchantmentModifier;
import codechicken.nei.GuiExtendedCreativeInv;
import codechicken.nei.LayoutManager;
import codechicken.nei.NEIClientConfig;
import codechicken.nei.NEIClientUtils;
import codechicken.nei.NEIServerUtils;
import codechicken.nei.forge.GuiContainerManager;
import cpw.mods.fml.relauncher.Side;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.xpzm;

public class NEICPH
implements PacketCustom.IClientPacketHandler {
    public static final String channel = "NEI";

    @Override
    public void handlePacket(PacketCustom packetCustom, bscn bscn2, xpzm xpzm2) {
        switch (packetCustom.getType()) {
            case 1: {
                this.handleSMPCheck(packetCustom.readUByte(), packetCustom.readString(), xpzm2._r);
                break;
            }
            case 10: {
                this.handleLoginState(packetCustom);
                break;
            }
            case 11: {
                this.handleActionDisabled(packetCustom);
                break;
            }
            case 12: {
                this.handleActionEnabled(packetCustom);
                break;
            }
            case 13: {
                ClientHandler.instance().addSMPMagneticItem(packetCustom.readInt(), xpzm2._r);
                break;
            }
            case 14: {
                this.handleGamemode(xpzm2, packetCustom.readUByte());
                break;
            }
            case 21: {
                ClientUtils.openSMPGui(packetCustom.readUByte(), new GuiEnchantmentModifier(xpzm2._t.field_71071_by, xpzm2._r, 0, 0, 0));
                break;
            }
            case 23: {
                if (packetCustom.readBoolean()) {
                    ClientUtils.openSMPGui(packetCustom.readUByte(), new GuiExtendedCreativeInv(new ContainerCreativeInv(xpzm2._t, new ExtendedCreativeInv(null, Side.CLIENT))));
                    break;
                }
                xpzm2._a(new cebg(xpzm2._t));
            }
        }
    }

    private void handleGamemode(xpzm xpzm2, int n) {
        xpzm2._j._a(NEIServerUtils.getGameType(n));
    }

    private void handleActionEnabled(PacketCustom packetCustom) {
        String string = packetCustom.readString();
        if (packetCustom.readBoolean()) {
            NEIClientConfig.enabledActions.add(string);
        } else {
            NEIClientConfig.enabledActions.remove(string);
        }
    }

    private void handleActionDisabled(PacketCustom packetCustom) {
        String string = packetCustom.readString();
        if (packetCustom.readBoolean()) {
            NEIClientConfig.disabledActions.add(string);
        } else {
            NEIClientConfig.disabledActions.remove(string);
        }
    }

    private void handleLoginState(PacketCustom packetCustom) {
        int n;
        NEIClientConfig.permissableActions.clear();
        int n2 = packetCustom.readUByte();
        for (n = 0; n < n2; ++n) {
            NEIClientConfig.permissableActions.add(packetCustom.readString());
        }
        NEIClientConfig.disabledActions.clear();
        n2 = packetCustom.readUByte();
        for (n = 0; n < n2; ++n) {
            NEIClientConfig.disabledActions.add(packetCustom.readString());
        }
        NEIClientConfig.enabledActions.clear();
        n2 = packetCustom.readUByte();
        for (n = 0; n < n2; ++n) {
            NEIClientConfig.enabledActions.add(packetCustom.readString());
        }
        n2 = packetCustom.readInt();
        ArrayList<ItemKey> arrayList = new ArrayList<ItemKey>(n2);
        for (int i = 0; i < n2; ++i) {
            arrayList.add(new ItemKey(packetCustom.readUShort(), packetCustom.readUShort()));
        }
        NEIClientConfig.setBannedBlocks(arrayList);
        if (NEIClientUtils.getGuiContainer() != null) {
            LayoutManager.instance().refresh(NEIClientUtils.getGuiContainer());
        }
    }

    private void handleSMPCheck(int n, String string, ozlu ozlu2) {
        if (n > 0) {
            NEIClientUtils.addChatMessage("NEI version mismatch: Outdated Client");
        } else if (n < 0) {
            NEIClientUtils.addChatMessage("NEI version mismatch: Outdated Server");
        } else {
            try {
                ClientHandler.instance().loadWorld(ozlu2, true);
                NEIClientConfig.loadWorld(NEICPH.getSaveName(string));
                NEIClientConfig.setHasSMPCounterPart(true);
                NEICPH.sendRequestLoginInfo();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private static String getSaveName(String string) {
        if (ClientUtils.isLocal()) {
            return "local/" + ClientUtils.getWorldSaveName(string);
        }
        return "remote/" + ClientUtils.getServerIP().replace(':', '~') + "/" + string;
    }

    public static void sendSpawnItem(cvzo cvzo2, boolean bl, boolean bl2) {
        PacketCustom packetCustom = new PacketCustom(channel, 1);
        packetCustom.writeBoolean(bl);
        packetCustom.writeBoolean(bl2);
        List<String> list = GuiContainerManager.itemDisplayNameMultiline(cvzo2, null, false);
        packetCustom.writeByte(list.size());
        for (String string : list) {
            packetCustom.writeString(string);
        }
        packetCustom.writeItemStack(cvzo2);
        packetCustom.writeInt(cvzo2._b);
        packetCustom.sendToServer();
    }

    public static void sendDeleteAllItems() {
        PacketCustom packetCustom = new PacketCustom(channel, 4);
        packetCustom.sendToServer();
    }

    public static void sendStateLoad(cvzo[] cvzoArray) {
        NEICPH.sendDeleteAllItems();
        for (int i = 0; i < cvzoArray.length; ++i) {
            cvzo cvzo2 = cvzoArray[i];
            if (cvzo2 == null) continue;
            NEICPH.sendSetSlot(i, cvzo2, false);
        }
        PacketCustom packetCustom = new PacketCustom(channel, 11);
        packetCustom.sendToServer();
    }

    public static void sendSetSlot(int n, cvzo cvzo2, boolean bl) {
        PacketCustom packetCustom = new PacketCustom(channel, 5);
        packetCustom.writeBoolean(bl);
        packetCustom.writeShort(n);
        packetCustom.writeItemStack(cvzo2);
        packetCustom.sendToServer();
    }

    private static void sendRequestLoginInfo() {
        PacketCustom packetCustom = new PacketCustom(channel, 10);
        packetCustom.sendToServer();
    }

    public static void sendToggleMagnetMode() {
        PacketCustom packetCustom = new PacketCustom(channel, 6);
        packetCustom.sendToServer();
    }

    public static void sendSetTime(int n) {
        PacketCustom packetCustom = new PacketCustom(channel, 7);
        packetCustom.writeByte(n);
        packetCustom.sendToServer();
    }

    public static void sendHeal() {
        PacketCustom packetCustom = new PacketCustom(channel, 8);
        packetCustom.sendToServer();
    }

    public static void sendToggleRain() {
        PacketCustom packetCustom = new PacketCustom(channel, 9);
        packetCustom.sendToServer();
    }

    public static void sendOpenEnchantmentWindow() {
        PacketCustom packetCustom = new PacketCustom(channel, 21);
        packetCustom.sendToServer();
    }

    public static void sendModifyEnchantment(int n, int n2, boolean bl) {
        PacketCustom packetCustom = new PacketCustom(channel, 22);
        packetCustom.writeByte(n);
        packetCustom.writeByte(n2);
        packetCustom.writeBoolean(bl);
        packetCustom.sendToServer();
    }

    public static void sendSetPropertyDisabled(String string, boolean bl) {
        PacketCustom packetCustom = new PacketCustom(channel, 12);
        packetCustom.writeString(string);
        packetCustom.writeBoolean(bl);
        packetCustom.sendToServer();
    }

    public static void sendGamemode(int n) {
        new PacketCustom(channel, 13).writeByte(n).sendToServer();
    }

    public static void sendCreativeInv(boolean bl) {
        PacketCustom packetCustom = new PacketCustom(channel, 23);
        packetCustom.writeBoolean(bl);
        packetCustom.sendToServer();
    }

    public static void sendCreativeScroll(int n) {
        PacketCustom packetCustom = new PacketCustom(channel, 14);
        packetCustom.writeInt(n);
        packetCustom.sendToServer();
    }

    public static void sendMobSpawnerID(int n, int n2, int n3, String string) {
        PacketCustom packetCustom = new PacketCustom(channel, 15);
        packetCustom.writeCoord(n, n2, n3);
        packetCustom.writeString(string);
        packetCustom.sendToServer();
    }

    public static PacketCustom createContainerPacket() {
        return new PacketCustom(channel, 20);
    }

    public static void sendOpenPotionWindow() {
        cvzo[] cvzoArray = new cvzo[9];
        InventoryUtils.readItemStacksFromTag(cvzoArray, NEIClientConfig.global.nbt._m("potionStore")._n("items"));
        PacketCustom packetCustom = new PacketCustom(channel, 24);
        for (int i = 0; i < cvzoArray.length; ++i) {
            packetCustom.writeItemStack(cvzoArray[i]);
        }
        packetCustom.sendToServer();
    }

    public static void sendDummySlotSet(int n, cvzo cvzo2) {
        PacketCustom packetCustom = new PacketCustom(channel, 25);
        packetCustom.writeShort(n);
        packetCustom.writeItemStack(cvzo2, true);
        packetCustom.sendToServer();
    }
}

