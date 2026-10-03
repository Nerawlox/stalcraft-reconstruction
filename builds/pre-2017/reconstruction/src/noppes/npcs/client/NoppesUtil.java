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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.village.MerchantRecipeList;
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
            PacketDispatcher.sendPacketToServer(new Packet250CustomPayload("CNPCs Server", byteArrayOutputStream.toByteArray()));
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
            pkix pkix2 = Minecraft._E()._r;
            Random random = pkix2.rand;
            if (string.equals("heal")) {
                for (int i = 0; i < 6; ++i) {
                    pkix2.spawnParticle("instantSpell", d + (random.nextDouble() - 0.5) * (double)f2, d2 + random.nextDouble() * (double)f - (double)f3, d3 + (random.nextDouble() - 0.5) * (double)f2, 0.0, 0.0, 0.0);
                    pkix2.spawnParticle("spell", d + (random.nextDouble() - 0.5) * (double)f2, d2 + random.nextDouble() * (double)f - (double)f3, d3 + (random.nextDouble() - 0.5) * (double)f2, 0.0, 0.0, 0.0);
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
        GuiScreen guiScreen = Minecraft._E()._B;
        if (guiScreen != null && guiScreen instanceof IScrollData) {
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
            ((IScrollData)((Object)guiScreen)).setData(vector, null);
        }
    }

    public static void setScrollData(DataInputStream dataInputStream) {
        block6: {
            GuiScreen guiScreen = Minecraft._E()._B;
            if (guiScreen != null) {
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
                    if (guiScreen instanceof GuiNPCInterface2 && ((GuiNPCInterface2)guiScreen).hasSubGui()) {
                        guiScreen = ((GuiNPCInterface2)guiScreen).getSubGui();
                    }
                    if (guiScreen instanceof GuiContainerNPCInterface2 && ((GuiContainerNPCInterface2)guiScreen).hasSubGui()) {
                        guiScreen = ((GuiContainerNPCInterface2)guiScreen).getSubGui();
                    }
                    if (!(guiScreen instanceof IScrollData)) break block6;
                    ((IScrollData)((Object)guiScreen)).setData(vector, hashMap);
                }
            }
        }
    }

    public static void guiQuestCompletion(EntityPlayer entityPlayer, DataInputStream dataInputStream) throws IOException {
        Quest quest = new Quest();
        quest.readNBT(bsvf._a(dataInputStream));
        if (!quest.completeText.equals("")) {
            Collection<ItemStack> collection;
            Object object;
            if (quest.reward.isRandom()) {
                object = bsvf._a(dataInputStream);
                collection = Arrays.asList(NBTTags.getItemStackArray(((NBTTagCompound)object)._n("Items")));
            } else {
                collection = quest.reward.items.items.values();
            }
            object = new GuiQuestCompleted(quest, new ArrayList<ItemStack>(collection));
            NoppesUtil.openChainedGUI((GuiScreen)object);
        } else {
            NoppesUtilPlayer.sendData(EnumPlayerPacket.QuestCompletion, quest.id);
        }
    }

    public static void openChainedGUI(GuiScreen guiScreen) {
        Minecraft minecraft = Minecraft._E();
        GuiScreen guiScreen2 = minecraft._B;
        if (guiScreen2 instanceof IGuiChained) {
            IGuiChained iGuiChained = (IGuiChained)((Object)guiScreen2);
            while (iGuiChained.getNextGui() instanceof IGuiChained) {
                iGuiChained = (IGuiChained)((Object)iGuiChained.getNextGui());
            }
            guiScreen.mc = minecraft;
            iGuiChained.setNextGui(guiScreen);
        } else {
            minecraft._a(guiScreen);
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
        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
        Dialog dialog = new Dialog();
        dialog.readNBT(nBTTagCompound);
        Minecraft minecraft = Minecraft._E();
        if (minecraft._B instanceof GuiDialogTalk) {
            ((GuiDialogTalk)minecraft._B).handleDialog(dialog);
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
                if (object instanceof NBTTagCompound) {
                    bsvf._a((NBTTagCompound)object, dataOutputStream);
                    continue;
                }
                if (!(object instanceof MerchantRecipeList)) continue;
                ((MerchantRecipeList)object)._a(dataOutputStream);
            }
            dataOutputStream.close();
            PacketDispatcher.sendPacketToServer(new Packet250CustomPayload("CNPCs Server", byteArrayOutputStream.toByteArray()));
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void bankData(DataInputStream dataInputStream) throws IOException {
        BankController bankController = BankController.getInstance();
        bankController.loadBanks(dataInputStream);
        GuiScreen guiScreen = Minecraft._E()._B;
        if (guiScreen != null) {
            guiScreen.initGui();
        }
    }

    public static void spawnEnderchibi(EntityNpcEnderchibi entityNpcEnderchibi) {
        Random random = entityNpcEnderchibi.worldObj.rand;
        EntityEnderFX entityEnderFX = new EntityEnderFX(entityNpcEnderchibi, entityNpcEnderchibi.posX + (random.nextDouble() - 0.5) * (double)entityNpcEnderchibi.width, entityNpcEnderchibi.posY + random.nextDouble() * (double)entityNpcEnderchibi.height, entityNpcEnderchibi.posZ + (random.nextDouble() - 0.5) * (double)entityNpcEnderchibi.width, (random.nextDouble() - 0.5) * 2.0, -random.nextDouble(), (random.nextDouble() - 0.5) * 2.0);
        Minecraft._E()._w._a(entityEnderFX);
    }

    public static void saveRedstoneBlock(EntityPlayer entityPlayer, DataInputStream dataInputStream) throws IOException {
        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
        int n = nBTTagCompound._f("x");
        int n2 = nBTTagCompound._f("y");
        int n3 = nBTTagCompound._f("z");
        TileEntity tileEntity = entityPlayer.worldObj.getBlockTileEntity(n, n2, n3);
        tileEntity.readFromNBT(nBTTagCompound);
        CustomNpcs.proxy.openGui(n, n2, n3, EnumGuiType.RedstoneBlock, entityPlayer);
    }

    public static void saveWayPointBlock(EntityPlayer entityPlayer, DataInputStream dataInputStream) throws IOException {
        NBTTagCompound nBTTagCompound = bsvf._a(dataInputStream);
        int n = nBTTagCompound._f("x");
        int n2 = nBTTagCompound._f("y");
        int n3 = nBTTagCompound._f("z");
        TileEntity tileEntity = entityPlayer.worldObj.getBlockTileEntity(n, n2, n3);
        tileEntity.readFromNBT(nBTTagCompound);
        CustomNpcs.proxy.openGui(n, n2, n3, EnumGuiType.Waypoint, entityPlayer);
    }
}

