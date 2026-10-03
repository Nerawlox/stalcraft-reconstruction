/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.PacketDispatcher;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.zwat;
import noppes.npcs.CustomNpcs;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.constants.EnumGuiType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumPlayerData;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.containers.ContainerManageBanks;
import noppes.npcs.containers.ContainerManageRecipes;
import noppes.npcs.controllers.Bank;
import noppes.npcs.controllers.BankController;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogCategory;
import noppes.npcs.controllers.DialogController;
import noppes.npcs.controllers.DialogOption;
import noppes.npcs.controllers.Faction;
import noppes.npcs.controllers.FactionController;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerDialogData;
import noppes.npcs.controllers.PlayerQuestController;
import noppes.npcs.controllers.PlayerTransportData;
import noppes.npcs.controllers.Quest;
import noppes.npcs.controllers.QuestCategory;
import noppes.npcs.controllers.RecipeCarpentry;
import noppes.npcs.controllers.RecipeController;
import noppes.npcs.controllers.TransportCategory;
import noppes.npcs.controllers.TransportController;
import noppes.npcs.controllers.TransportLocation;
import noppes.npcs.roles.RoleTransporter;

public class NoppesUtilServer {
    private static HashMap selectedNpcs = new HashMap();
    private static HashMap editingQuests = new HashMap();

    public static byte[] CompoundToBytes(qoac qoac2, EnumPacketType enumPacketType) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = NoppesUtilServer.getDataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(enumPacketType.ordinal());
            if (qoac2 != null) {
                bsvf._a(qoac2, dataOutputStream);
            }
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public static void setEditingNpc(EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface) {
        selectedNpcs.put(entityPlayer.field_71092_bJ, entityNPCInterface);
        if (entityNPCInterface != null) {
            NoppesUtilServer.sendData(entityPlayer, EnumPacketType.EditingNpc, entityNPCInterface.field_70157_k);
        }
    }

    public static EntityNPCInterface getEditingNpc(EntityPlayer entityPlayer) {
        return (EntityNPCInterface)selectedNpcs.get(entityPlayer.field_71092_bJ);
    }

    public static void setEditingQuest(EntityPlayer entityPlayer, Quest quest) {
        editingQuests.put(entityPlayer.field_71092_bJ, quest);
    }

    public static Quest getEditingQuest(EntityPlayer entityPlayer) {
        return (Quest)editingQuests.get(entityPlayer.field_71092_bJ);
    }

    private static void sendRoleData(EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface) {
        if (entityNPCInterface.advanced.role != EnumRoleType.None) {
            qoac qoac2 = new qoac();
            entityNPCInterface.roleInterface.writeEntityToNBT(qoac2);
            qoac2._a("EntityId", entityNPCInterface.field_70157_k);
            qoac2._a("Role", entityNPCInterface.advanced.role.ordinal());
            byte[] byArray = NoppesUtilServer.CompoundToBytes(qoac2, EnumPacketType.SaveRole);
            PacketDispatcher.sendPacketToPlayer(new jjqf("CNPCs Client", byArray), entityPlayer);
        }
    }

    public static void sendFactionDataAll(EntityPlayerMP entityPlayerMP) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (Faction faction : FactionController.getInstance().factions.values()) {
            hashMap.put(faction.name, faction.id);
        }
        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.ScrollData, hashMap);
    }

    public static void sendBankDataAll(EntityPlayerMP entityPlayerMP) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (Bank bank : BankController.getInstance().banks.values()) {
            hashMap.put(bank.name, bank.id);
        }
        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.ScrollData, hashMap);
    }

    public static void openDialog(EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface, Dialog dialog) {
        tdpx tdpx2;
        Dialog dialog2 = dialog.copy(entityPlayer);
        NoppesUtilServer.openDialogSilent(entityPlayer, entityNPCInterface, dialog2);
        dialog.factionOptions.addPoints(entityPlayer);
        if (dialog2.hasQuest()) {
            PlayerQuestController.addActiveQuest(dialog2.getQuest(), entityPlayer);
        }
        if (dialog2.mail.isValid()) {
            PlayerDataController.instance.addPlayerMessage(entityPlayer.field_71092_bJ, dialog2.mail);
        }
        PlayerData playerData = PlayerDataController.instance.getPlayerData(entityPlayer);
        PlayerDialogData playerDialogData = playerData.dialogData;
        if (playerDialogData.dialogsRead.add(dialog2.id)) {
            playerData.onDialogStatusUpdate(dialog2.id);
        }
        if ((tdpx2 = wmvj._g.get(dialog2.id)) != null) {
            ncwh._a(entityPlayer)._a(tdpx2)._e();
        }
        if (!dialog2.command.isEmpty()) {
            NoppesUtilPlayer.runCommand(entityNPCInterface, dialog2.command.replaceAll("@dp", entityPlayer.field_71092_bJ));
        }
    }

    public static void openDialogSilent(EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface, Dialog dialog) {
        Object object;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            object = NoppesUtilServer.getDataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)object).writeInt(EnumPacketType.Dialog.ordinal());
            ((DataOutputStream)object).writeInt(entityNPCInterface.field_70157_k);
            bsvf._a(dialog.writeToNBT(new qoac()), (DataOutput)object);
            ((FilterOutputStream)object).close();
            PacketDispatcher.sendPacketToPlayer(new jjqf("CNPCs Client", byteArrayOutputStream.toByteArray()), entityPlayer);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        NoppesUtilServer.setEditingNpc(entityPlayer, entityNPCInterface);
        object = PlayerDataController.instance.getPlayerData(entityPlayer);
        ((PlayerData)object).currentDialogNpc = entityNPCInterface.func_110124_au();
        ((PlayerData)object).storedDialogs.put(entityNPCInterface.func_110124_au(), dialog.id);
        FMLLog.info("Setting stored dialog for %s: NPC %s -> Dialog %d", entityPlayer.field_71092_bJ, entityNPCInterface.func_110124_au(), dialog.id);
    }

    public static boolean openStoredDialog(EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface) {
        PlayerData playerData = PlayerDataController.instance.getPlayerData(entityPlayer);
        Map<UUID, Integer> map = playerData.storedDialogs;
        if (map.containsKey(entityNPCInterface.func_110124_au())) {
            int n = map.get(entityNPCInterface.func_110124_au());
            FMLLog.info("Opening stored dialog of %s from npc %s with dialog id %d", entityPlayer.field_71092_bJ, entityNPCInterface.func_110124_au(), n);
            Dialog dialog = DialogController.instance.dialogs.get(n);
            playerData.clearStoredDialog(entityNPCInterface.func_110124_au());
            if (dialog == null) {
                FMLLog.info("Stored dialog with id %d not found", n);
                return false;
            }
            NoppesUtilServer.openDialogSilent(entityPlayer, entityNPCInterface, dialog);
            return true;
        }
        return false;
    }

    public static void closeCurrentDialog(EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface) {
        System.out.println("Clearing stored dialog for " + entityPlayer.field_71092_bJ + " with npc " + entityNPCInterface.func_110124_au());
        PlayerData playerData = PlayerDataController.instance.getPlayerData(entityPlayer);
        playerData.currentDialogNpc = null;
        playerData.clearStoredDialog(entityNPCInterface.func_110124_au());
    }

    public static DataOutputStream getDataOutputStream(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
        return new DataOutputStream(new GZIPOutputStream(byteArrayOutputStream));
    }

    public static void sendOpenGui(EntityPlayer entityPlayer, EnumGuiType enumGuiType, EntityNPCInterface entityNPCInterface) {
        NoppesUtilServer.sendOpenGui(entityPlayer, enumGuiType, entityNPCInterface, 0, 0, 0);
    }

    public static void sendOpenGui(EntityPlayer entityPlayer, EnumGuiType enumGuiType, EntityNPCInterface entityNPCInterface, int n, int n2, int n3) {
        if (entityPlayer instanceof EntityPlayerMP) {
            NoppesUtilServer.setEditingNpc(entityPlayer, entityNPCInterface);
            NoppesUtilServer.sendExtraData(entityPlayer, entityNPCInterface, enumGuiType, n, n2, n3);
            jjgc jjgc2 = CustomNpcs.proxy.getServerGuiElement(enumGuiType, entityPlayer, n, n2, n3);
            if (jjgc2 != null) {
                InvokeSideOnly.frontend(() -> {});
            } else {
                OutputStream outputStream;
                Object object;
                try {
                    object = new ByteArrayOutputStream();
                    outputStream = NoppesUtilServer.getDataOutputStream((ByteArrayOutputStream)object);
                    ((DataOutputStream)outputStream).writeInt(EnumPacketType.Gui.ordinal());
                    ((DataOutputStream)outputStream).writeInt(enumGuiType.ordinal());
                    ((FilterOutputStream)outputStream).close();
                    PacketDispatcher.sendPacketToPlayer(new jjqf("CNPCs Client", ((ByteArrayOutputStream)object).toByteArray()), entityPlayer);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
                object = NoppesUtilServer.getScrollData(entityPlayer, enumGuiType, entityNPCInterface);
                if (object != null && !((ArrayList)object).isEmpty()) {
                    try {
                        outputStream = new ByteArrayOutputStream();
                        DataOutputStream dataOutputStream = NoppesUtilServer.getDataOutputStream((ByteArrayOutputStream)outputStream);
                        dataOutputStream.writeInt(EnumPacketType.ScrollList.ordinal());
                        Iterator iterator2 = ((ArrayList)object).iterator();
                        while (iterator2.hasNext()) {
                            String string = (String)iterator2.next();
                            dataOutputStream.writeUTF(string);
                        }
                        dataOutputStream.close();
                        PacketDispatcher.sendPacketToPlayer(new jjqf("CNPCs Client", ((ByteArrayOutputStream)outputStream).toByteArray()), entityPlayer);
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                    }
                }
            }
        }
    }

    private static void sendExtraData(EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface, EnumGuiType enumGuiType, int n, int n2, int n3) {
        if (enumGuiType == EnumGuiType.PlayerFollower || enumGuiType == EnumGuiType.PlayerFollowerHire || enumGuiType == EnumGuiType.PlayerTrader || enumGuiType == EnumGuiType.PlayerExchanger || enumGuiType == EnumGuiType.PlayerTransporter) {
            NoppesUtilServer.sendRoleData(entityPlayer, entityNPCInterface);
        }
    }

    private static ArrayList getScrollData(EntityPlayer entityPlayer, EnumGuiType enumGuiType, EntityNPCInterface entityNPCInterface) {
        if (enumGuiType == EnumGuiType.PlayerTransporter) {
            Object object2;
            RoleTransporter roleTransporter = (RoleTransporter)entityNPCInterface.roleInterface;
            ArrayList<String> arrayList = new ArrayList<String>();
            TransportLocation transportLocation = roleTransporter.getLocation();
            String string = roleTransporter.getLocation().name;
            for (Object object2 : transportLocation.category.getDefaultLocations()) {
                if (arrayList.contains(((TransportLocation)object2).name)) continue;
                arrayList.add(((TransportLocation)object2).name);
            }
            object2 = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayer).transportData;
            Iterator iterator2 = ((PlayerTransportData)object2).transports.iterator();
            while (iterator2.hasNext()) {
                int n = (Integer)iterator2.next();
                TransportLocation transportLocation2 = TransportController.getInstance().getTransport(n);
                if (transportLocation2 == null || !transportLocation.category.locations.containsKey(transportLocation2.id) || arrayList.contains(transportLocation2.name)) continue;
                arrayList.add(transportLocation2.name);
            }
            arrayList.remove(string);
            return arrayList;
        }
        return null;
    }

    public static void spawnParticle(Entity entity, String string, int n) {
        Object object;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            object = NoppesUtilServer.getDataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)object).writeInt(EnumPacketType.Particle.ordinal());
            ((DataOutputStream)object).writeDouble(entity.field_70165_t);
            ((DataOutputStream)object).writeDouble(entity.field_70163_u);
            ((DataOutputStream)object).writeDouble(entity.field_70161_v);
            ((DataOutputStream)object).writeFloat(entity.field_70131_O);
            ((DataOutputStream)object).writeFloat(entity.field_70130_N);
            ((DataOutputStream)object).writeFloat(entity.field_70129_M);
            ((DataOutputStream)object).writeUTF(string);
            ((FilterOutputStream)object).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        object = new jjqf("CNPCs Client", byteArrayOutputStream.toByteArray());
        PacketDispatcher.sendPacketToAllAround(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 60.0, n, (cezg)object);
    }

    public static void deleteNpc(EntityNPCInterface entityNPCInterface) {
        Object object;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            object = NoppesUtilServer.getDataOutputStream(byteArrayOutputStream);
            ((DataOutputStream)object).writeInt(EnumPacketType.Delete.ordinal());
            ((DataOutputStream)object).writeInt(entityNPCInterface.field_70157_k);
            ((FilterOutputStream)object).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        object = new jjqf("CNPCs Client", byteArrayOutputStream.toByteArray());
        PacketDispatcher.sendPacketToAllAround(entityNPCInterface.field_70165_t, entityNPCInterface.field_70163_u, entityNPCInterface.field_70161_v, 256.0, entityNPCInterface.field_71093_bK, (cezg)object);
    }

    public static void createMobSpawner(DataInputStream dataInputStream, EntityPlayer entityPlayer) {
        try {
            int n = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            int n3 = dataInputStream.readInt();
            qoac qoac2 = bsvf._a(dataInputStream);
            if (qoac2._j("id").equalsIgnoreCase("entityhorse")) {
                entityPlayer.func_70006_a(zwat._d("Currently you cant create horse spawner, its a minecraft bug"));
                return;
            }
            entityPlayer.field_70170_p.func_94575_c(n, n2, n3, twgu.field_72065_as.field_71990_ca);
            xtcq xtcq2 = (xtcq)entityPlayer.field_70170_p.func_72796_p(n, n2, n3);
            qokq qokq2 = xtcq2._a();
            qokq2._a(new rrqs(qokq2, qoac2, qoac2._j("id")));
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void sendDialogCategoryData(EntityPlayerMP entityPlayerMP) {
        InvokeSideOnly.frontend(() -> {});
    }

    public static void sendQuestCategoryData(EntityPlayerMP entityPlayerMP) {
        InvokeSideOnly.frontend(() -> {});
    }

    public static void sendPlayerData(EnumPlayerData enumPlayerData, EntityPlayerMP entityPlayerMP, String string) {
        InvokeSideOnly.frontend(() -> {});
    }

    public static void removePlayerData(DataInputStream dataInputStream, EntityPlayerMP entityPlayerMP) {
        InvokeSideOnly.frontend(() -> {});
    }

    public static void sendRecipeData(EntityPlayerMP entityPlayerMP, int n) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        if (n == 3) {
            for (RecipeCarpentry recipeCarpentry : RecipeController.instance.globalRecipes.values()) {
                hashMap.put(recipeCarpentry.name, recipeCarpentry.id);
            }
        } else {
            for (RecipeCarpentry recipeCarpentry : RecipeController.instance.anvilRecipes.values()) {
                hashMap.put(recipeCarpentry.name, recipeCarpentry.id);
            }
        }
        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.ScrollData, hashMap);
    }

    public static void sendDialogData(EntityPlayerMP entityPlayerMP, DialogCategory dialogCategory) {
        if (dialogCategory != null) {
            HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
            for (Dialog dialog : dialogCategory.dialogs.values()) {
                hashMap.put(dialog.title, dialog.id);
            }
            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.ScrollData, hashMap);
        }
    }

    public static void sendQuestData(EntityPlayerMP entityPlayerMP, QuestCategory questCategory) {
        InvokeSideOnly.frontend(() -> {});
    }

    public static void sendTransportCategoryData(EntityPlayerMP entityPlayerMP) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (TransportCategory transportCategory : TransportController.getInstance().categories.values()) {
            hashMap.put(transportCategory.title, transportCategory.id);
        }
        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.ScrollData, hashMap);
    }

    public static void sendTransportData(EntityPlayerMP entityPlayerMP, int n) {
        TransportCategory transportCategory = (TransportCategory)TransportController.getInstance().categories.get(n);
        if (transportCategory != null) {
            HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
            for (TransportLocation transportLocation : transportCategory.locations.values()) {
                hashMap.put(transportLocation.name, transportLocation.id);
            }
            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.ScrollData, hashMap);
        }
    }

    public static void sendData(EntityPlayer entityPlayer, EnumPacketType enumPacketType, Object ... objectArray) {
        PacketDispatcher.sendPacketToPlayer(NoppesUtilServer.getPacket(enumPacketType, objectArray), entityPlayer);
    }

    public static void sendDataToAll(Entity entity, EnumPacketType enumPacketType, Object ... objectArray) {
        jjqf jjqf2 = NoppesUtilServer.getPacket(enumPacketType, objectArray);
        ((yfgy)entity.field_70170_p).func_73039_n()._b(entity, jjqf2);
    }

    public static jjqf getPacket(EnumPacketType enumPacketType, Object ... objectArray) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = NoppesUtilServer.getDataOutputStream(byteArrayOutputStream);
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
                if (object instanceof qoac) {
                    bsvf._a((qoac)object, dataOutputStream);
                    continue;
                }
                if (!(object instanceof ywfi)) continue;
                ((ywfi)object)._a(dataOutputStream);
            }
            dataOutputStream.close();
            byteArrayOutputStream.close();
            return new jjqf("CNPCs Client", byteArrayOutputStream.toByteArray());
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return null;
        }
    }

    public static void sendNpcDialogs(EntityPlayer entityPlayer) {
        EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayer);
        if (entityNPCInterface != null) {
            for (int n : entityNPCInterface.dialogs.keySet()) {
                DialogOption dialogOption = entityNPCInterface.dialogs.get(n);
                if (dialogOption == null || !dialogOption.hasDialog()) continue;
                qoac qoac2 = dialogOption.writeNBT();
                qoac2._a("Position", n);
                NoppesUtilServer.sendData(entityPlayer, EnumPacketType.GuiData, qoac2);
            }
        }
    }

    public static DialogOption setNpcDialog(int n, int n2, EntityPlayer entityPlayer) throws IOException {
        EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayer);
        if (entityNPCInterface == null) {
            return null;
        }
        if (!entityNPCInterface.dialogs.containsKey(n)) {
            entityNPCInterface.dialogs.put(n, new DialogOption());
        }
        DialogOption dialogOption = entityNPCInterface.dialogs.get(n);
        dialogOption.dialogId = n2;
        if (dialogOption.hasDialog()) {
            dialogOption.title = dialogOption.getDialog().title;
        }
        return dialogOption;
    }

    public static void saveTileEntity(EntityPlayerMP entityPlayerMP, DataInputStream dataInputStream) throws IOException {
        int n;
        int n2;
        qoac qoac2 = bsvf._a(dataInputStream);
        int n3 = qoac2._f("x");
        hurg hurg2 = entityPlayerMP.field_70170_p.func_72796_p(n3, n2 = qoac2._f("y"), n = qoac2._f("z"));
        if (hurg2 != null) {
            hurg2.func_70307_a(qoac2);
        }
    }

    public static void setRecipeGui(EntityPlayerMP entityPlayerMP, RecipeCarpentry recipeCarpentry) {
        if (recipeCarpentry != null && entityPlayerMP.field_71070_bA instanceof ContainerManageRecipes) {
            ContainerManageRecipes containerManageRecipes = (ContainerManageRecipes)entityPlayerMP.field_71070_bA;
            containerManageRecipes.setRecipe(recipeCarpentry);
            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, recipeCarpentry.writeNBT());
        }
    }

    public static void sendBank(EntityPlayerMP entityPlayerMP, Bank bank) {
        qoac qoac2 = new qoac();
        bank.writeEntityToNBT(qoac2);
        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, qoac2);
        if (entityPlayerMP.field_71070_bA instanceof ContainerManageBanks) {
            ((ContainerManageBanks)entityPlayerMP.field_71070_bA).setBank(bank);
        }
        entityPlayerMP.func_71110_a(entityPlayerMP.field_71070_bA, entityPlayerMP.field_71070_bA.func_75138_a());
    }

    public static void sendNearbyNpcs(EntityPlayerMP entityPlayerMP) {
        List list2 = entityPlayerMP.field_70170_p.func_72872_a(EntityNPCInterface.class, entityPlayerMP.field_70121_D._b(64.0, 64.0, 64.0));
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (EntityNPCInterface entityNPCInterface : list2) {
            if (entityNPCInterface.field_70128_L) continue;
            float f = entityPlayerMP.func_70032_d(entityNPCInterface);
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            String string = decimalFormat.format(f);
            if (f < 10.0f) {
                string = "0" + string;
            }
            hashMap.put(string + " : " + entityNPCInterface.display.name, entityNPCInterface.field_70157_k);
        }
        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.ScrollData, hashMap);
    }

    public static void sendGuiError(EntityPlayer entityPlayer, int n) {
        NoppesUtilServer.sendData(entityPlayer, EnumPacketType.GuiError, n, new qoac());
    }

    public static void sendGuiClose(EntityPlayerMP entityPlayerMP, int n, qoac qoac2) {
        NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiClose, n, qoac2);
    }
}

