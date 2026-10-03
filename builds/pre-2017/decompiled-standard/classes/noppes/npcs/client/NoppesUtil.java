/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs.client;

import cpw.mods.fml.common.network.PacketDispatcher;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.zip.GZIPOutputStream;
import net.minecraft.client.xpzm;
import net.minecraft.entity.player.EntityPlayer;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NBTTags;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.client.EntityEnderFX;
import noppes.npcs.client.gui.player.GuiDialogTalk;
import noppes.npcs.client.gui.player.GuiQuestCompleted;
import noppes.npcs.client.gui.player.IGuiChained;
import noppes.npcs.client.gui.util.GuiContainerNPCInterface2;
import noppes.npcs.client.gui.util.GuiNPCInterface2;
import noppes.npcs.client.gui.util.IScrollData;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.controllers.BankController;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogController;
import noppes.npcs.controllers.Quest;
import noppes.npcs.entity.EntityNpcEnderchibi;
import znw.mods.stalkerguide.pidb;

public class NoppesUtil {
    private static EntityNPCInterface lastNpc;

    public static void requestOpenGUI(EnumGuiType enumGuiType) {
        NoppesUtil.requestOpenGUI(enumGuiType, 0, 0, 0);
    }

    public static void requestOpenGUI(EnumGuiType enumGuiType, int n, int n2, int n3) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = NoppesUtil.getDataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(EnumPacketType.Gui.ordinal());
            dataOutputStream.writeInt(enumGuiType.ordinal());
            dataOutputStream.writeInt(n);
            dataOutputStream.writeInt(n2);
            dataOutputStream.writeInt(n3);
            dataOutputStream.close();
            PacketDispatcher.sendPacketToServer(new jjqf("CNPCs Server", byteArrayOutputStream.toByteArray()));
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static DataOutputStream getDataOutputStream(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        return new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream));
    }

    public static void spawnParticle(DataInputStream dataInputStream) {
        try {
            double d = dataInputStream.readDouble();
            double d2 = dataInputStream.readDouble();
            double d3 = dataInputStream.readDouble();
            float f = dataInputStream.readFloat();
            float f2 = dataInputStream.readFloat();
            float f3 = dataInputStream.readFloat();
            String string = dataInputStream.readUTF();
            pkix pkix2 = xpzm._E()._r;
            Random random = pkix2.field_73012_v;
            if (string.equals("heal")) {
                for (int i = 0; i < 6; ++i) {
                    pkix2.func_72869_a("instantSpell", d + (random.nextDouble() - 0.5) * (double)f2, d2 + random.nextDouble() * (double)f - (double)f3, d3 + (random.nextDouble() - 0.5) * (double)f2, 0.0, 0.0, 0.0);
                    pkix2.func_72869_a("spell", d + (random.nextDouble() - 0.5) * (double)f2, d2 + random.nextDouble() * (double)f - (double)f3, d3 + (random.nextDouble() - 0.5) * (double)f2, 0.0, 0.0, 0.0);
                }
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static EntityNPCInterface getLastNpc() {
        return lastNpc;
    }

    public static void setLastNpc(EntityNPCInterface entityNPCInterface) {
        lastNpc = entityNPCInterface;
    }

    public static void openGUI(EntityPlayer entityPlayer, Object object) {
        CustomNpcs.proxy.openGui(entityPlayer, object);
    }

    public static void setScrollList(DataInputStream dataInputStream) {
        gqjz gqjz2 = xpzm._E()._B;
        if (gqjz2 != null && gqjz2 instanceof IScrollData) {
            Vector<String> vector = new Vector<String>();
            try {
                String string;
                while ((string = dataInputStream.readUTF()) != null) {
                    vector.add(string);
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
            ((IScrollData)((Object)gqjz2)).setData(vector, null);
        }
    }

    public static void setScrollData(DataInputStream dataInputStream) {
        block6: {
            gqjz gqjz2 = xpzm._E()._B;
            if (gqjz2 != null) {
                Vector<String> vector = new Vector<String>();
                HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
                try {
                    while (true) {
                        int n = dataInputStream.readInt();
                        String string = dataInputStream.readUTF();
                        hashMap.put(string, n);
                        vector.add(string);
                    }
                }
                catch (Exception exception) {
                    if (gqjz2 instanceof GuiNPCInterface2 && ((GuiNPCInterface2)gqjz2).hasSubGui()) {
                        gqjz2 = ((GuiNPCInterface2)gqjz2).getSubGui();
                    }
                    if (gqjz2 instanceof GuiContainerNPCInterface2 && ((GuiContainerNPCInterface2)gqjz2).hasSubGui()) {
                        gqjz2 = ((GuiContainerNPCInterface2)gqjz2).getSubGui();
                    }
                    if (!(gqjz2 instanceof IScrollData)) break block6;
                    ((IScrollData)((Object)gqjz2)).setData(vector, hashMap);
                }
            }
        }
    }

    public static void guiQuestCompletion(EntityPlayer entityPlayer, DataInputStream dataInputStream) throws IOException {
        Quest quest = new Quest();
        quest.readNBT(bsvf._a(dataInputStream));
        if (!quest.completeText.equals("")) {
            Collection<cvzo> collection;
            Object object;
            if (quest.reward.isRandom()) {
                object = bsvf._a(dataInputStream);
                collection = Arrays.asList(NBTTags.getItemStackArray(((qoac)object)._n("Items")));
            } else {
                collection = quest.reward.items.items.values();
            }
            object = new GuiQuestCompleted(quest, new ArrayList<cvzo>(collection));
            NoppesUtil.openChainedGUI((gqjz)object);
        } else {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.QuestCompletion, quest.id);
        }
    }

    public static void openChainedGUI(gqjz gqjz2) {
        xpzm xpzm2 = xpzm._E();
        gqjz gqjz3 = xpzm2._B;
        if (gqjz3 instanceof IGuiChained) {
            IGuiChained iGuiChained = (IGuiChained)((Object)gqjz3);
            while (iGuiChained.getNextGui() instanceof IGuiChained) {
                iGuiChained = (IGuiChained)((Object)iGuiChained.getNextGui());
            }
            gqjz2.field_73882_e = xpzm2;
            iGuiChained.setNextGui(gqjz2);
        } else {
            xpzm2._a(gqjz2);
        }
    }

    public static void openDialog(DataInputStream dataInputStream, EntityNPCInterface entityNPCInterface, EntityPlayer entityPlayer) throws IOException {
        boolean bl = pidb._a(null, dataInputStream, entityNPCInterface, entityPlayer);
        if (bl) {
            boolean bl2 = bl;
            return;
        }
        if (DialogController.instance == null) {
            DialogController.instance = new DialogController();
        }
        qoac qoac2 = bsvf._a(dataInputStream);
        Dialog dialog = new Dialog();
        dialog.readNBT(qoac2);
        xpzm xpzm2 = xpzm._E();
        if (xpzm2._B instanceof GuiDialogTalk) {
            ((GuiDialogTalk)xpzm2._B).handleDialog(dialog);
        } else {
            NoppesUtil.openChainedGUI(new GuiDialogTalk(entityNPCInterface, dialog));
        }
    }

    public static void sendData(EnumPacketType enumPacketType, Object ... objectArray) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = NoppesUtil.getDataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(enumPacketType.ordinal());
            Object[] objectArray2 = objectArray;
            int n = objectArray.length;
            for (int i = 0; i < n; ++i) {
                Object object = objectArray2[i];
                if (object == null) continue;
                if (object instanceof Map) {
                    Map map = (Map)object;
                    for (String string : map.keySet()) {
                        int n2 = (Integer)map.get(string);
                        dataOutputStream.writeInt(n2);
                        dataOutputStream.writeUTF(string);
                    }
                    continue;
                }
                if (object instanceof Enum) {
                    dataOutputStream.writeInt(((Enum)object).ordinal());
                    continue;
                }
                if (object instanceof Double) {
                    dataOutputStream.writeDouble((Double)object);
                    continue;
                }
                if (object instanceof Float) {
                    dataOutputStream.writeFloat(((Float)object).floatValue());
                    continue;
                }
                if (object instanceof Integer) {
                    dataOutputStream.writeInt((Integer)object);
                    continue;
                }
                if (object instanceof String) {
                    dataOutputStream.writeUTF((String)object);
                    continue;
                }
                if (object instanceof Boolean) {
                    dataOutputStream.writeBoolean((Boolean)object);
                    continue;
                }
                if (object instanceof qoac) {
                    bsvf._a((qoac)object, dataOutputStream);
                    continue;
                }
                if (!(object instanceof ywfi)) continue;
                ((ywfi)object)._a(dataOutputStream);
            }
            dataOutputStream.close();
            PacketDispatcher.sendPacketToServer(new jjqf("CNPCs Server", byteArrayOutputStream.toByteArray()));
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void bankData(DataInputStream dataInputStream) throws IOException {
        BankController bankController = BankController.getInstance();
        bankController.loadBanks(dataInputStream);
        gqjz gqjz2 = xpzm._E()._B;
        if (gqjz2 != null) {
            gqjz2.func_73866_w_();
        }
    }

    public static void spawnEnderchibi(EntityNpcEnderchibi entityNpcEnderchibi) {
        Random random = entityNpcEnderchibi.field_70170_p.field_73012_v;
        EntityEnderFX entityEnderFX = new EntityEnderFX(entityNpcEnderchibi, entityNpcEnderchibi.field_70165_t + (random.nextDouble() - 0.5) * (double)entityNpcEnderchibi.field_70130_N, entityNpcEnderchibi.field_70163_u + random.nextDouble() * (double)entityNpcEnderchibi.field_70131_O, entityNpcEnderchibi.field_70161_v + (random.nextDouble() - 0.5) * (double)entityNpcEnderchibi.field_70130_N, (random.nextDouble() - 0.5) * 2.0, -random.nextDouble(), (random.nextDouble() - 0.5) * 2.0);
        xpzm._E()._w._a(entityEnderFX);
    }

    public static void saveRedstoneBlock(EntityPlayer entityPlayer, DataInputStream dataInputStream) throws IOException {
        qoac qoac2 = bsvf._a(dataInputStream);
        int n = qoac2._f("x");
        int n2 = qoac2._f("y");
        int n3 = qoac2._f("z");
        hurg hurg2 = entityPlayer.field_70170_p.func_72796_p(n, n2, n3);
        hurg2.func_70307_a(qoac2);
        CustomNpcs.proxy.openGui(n, n2, n3, EnumGuiType.RedstoneBlock, entityPlayer);
    }

    public static void saveWayPointBlock(EntityPlayer entityPlayer, DataInputStream dataInputStream) throws IOException {
        qoac qoac2 = bsvf._a(dataInputStream);
        int n = qoac2._f("x");
        int n2 = qoac2._f("y");
        int n3 = qoac2._f("z");
        hurg hurg2 = entityPlayer.field_70170_p.func_72796_p(n, n2, n3);
        hurg2.func_70307_a(qoac2);
        CustomNpcs.proxy.openGui(n, n2, n3, EnumGuiType.Waypoint, entityPlayer);
    }
}

