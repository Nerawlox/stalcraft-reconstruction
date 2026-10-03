/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import cpw.mods.fml.common.network.PacketDispatcher;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.sajh;
import noppes.npcs.CustomTeleporter;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.QuestLogData;
import noppes.npcs.client.NoppesUtil;
import noppes.npcs.constants.EnumOptionType;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.constants.EnumRoleType;
import noppes.npcs.containers.ContainerNPCBankInterface;
import noppes.npcs.containers.ContainerNPCFollower;
import noppes.npcs.containers.ContainerNPCFollowerHire;
import noppes.npcs.controllers.Bank;
import noppes.npcs.controllers.BankController;
import noppes.npcs.controllers.BankData;
import noppes.npcs.controllers.Dialog;
import noppes.npcs.controllers.DialogController;
import noppes.npcs.controllers.DialogOption;
import noppes.npcs.controllers.Line;
import noppes.npcs.controllers.PlayerBankData;
import noppes.npcs.controllers.PlayerData;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerQuestController;
import noppes.npcs.controllers.PlayerTransportData;
import noppes.npcs.controllers.TransportController;
import noppes.npcs.controllers.TransportLocation;
import noppes.npcs.roles.RoleFollower;

public class NoppesUtilPlayer {
    public static void changeFollowerState(EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface) {
        RoleFollower roleFollower;
        EntityPlayer entityPlayer;
        if (entityNPCInterface.advanced.role == EnumRoleType.Follower && (entityPlayer = (roleFollower = (RoleFollower)entityNPCInterface.roleInterface).getOwner()) != null && entityPlayer.field_71092_bJ.equals(entityPlayerMP.field_71092_bJ)) {
            roleFollower.isFollowing = !roleFollower.isFollowing;
        }
    }

    public static void hireFollower(EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface) {
        jjgc jjgc2;
        if (entityNPCInterface.advanced.role == EnumRoleType.Follower && (jjgc2 = entityPlayerMP.field_71070_bA) != null && jjgc2 instanceof ContainerNPCFollowerHire) {
            ContainerNPCFollowerHire containerNPCFollowerHire = (ContainerNPCFollowerHire)jjgc2;
            RoleFollower roleFollower = (RoleFollower)entityNPCInterface.roleInterface;
            NoppesUtilPlayer.followerBuy(roleFollower, containerNPCFollowerHire.currencyMatrix, entityPlayerMP, entityNPCInterface);
        }
    }

    public static void extendFollower(EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface) {
        jjgc jjgc2;
        if (entityNPCInterface.advanced.role == EnumRoleType.Follower && (jjgc2 = entityPlayerMP.field_71070_bA) != null && jjgc2 instanceof ContainerNPCFollower) {
            ContainerNPCFollower containerNPCFollower = (ContainerNPCFollower)jjgc2;
            RoleFollower roleFollower = (RoleFollower)entityNPCInterface.roleInterface;
            NoppesUtilPlayer.followerBuy(roleFollower, containerNPCFollower.currencyMatrix, entityPlayerMP, entityNPCInterface);
        }
    }

    public static void transport(EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface, String string) {
        TransportLocation transportLocation = TransportController.getInstance().getTransport(string);
        PlayerTransportData playerTransportData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayerMP).transportData;
        if (transportLocation != null && (transportLocation.isDefault() || playerTransportData.transports.contains(transportLocation.id))) {
            if (entityPlayerMP.field_71093_bK != transportLocation.dimension) {
                System.out.println(transportLocation.dimension + " transfering");
                int n = entityPlayerMP.field_71093_bK;
                dzfd dzfd2 = dzfd._I();
                yfgy yfgy2 = dzfd2._a(entityPlayerMP.field_71093_bK);
                entityPlayerMP.field_71135_a.func_72569_a(transportLocation.posX, transportLocation.posY, transportLocation.posZ, entityPlayerMP.field_70177_z, entityPlayerMP.field_70125_A);
                dzfd2.__ag()._a(entityPlayerMP, transportLocation.dimension, new CustomTeleporter(yfgy2));
                if (n == 1 && entityPlayerMP.func_70089_S()) {
                    entityPlayerMP.func_70012_b(transportLocation.posX, transportLocation.posY, transportLocation.posZ, entityPlayerMP.field_70177_z, entityPlayerMP.field_70125_A);
                    yfgy2.func_72838_d(entityPlayerMP);
                }
                entityPlayerMP.field_70170_p.func_72866_a(entityPlayerMP, false);
            } else {
                entityPlayerMP.field_71135_a.func_72569_a(transportLocation.posX, transportLocation.posY, transportLocation.posZ, entityPlayerMP.field_70177_z, entityPlayerMP.field_70125_A);
                entityPlayerMP.field_70170_p.func_72866_a(entityPlayerMP, false);
            }
        }
    }

    private static void followerBuy(RoleFollower roleFollower, mssh mssh2, EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface) {
        cvzo cvzo2 = mssh2.func_70301_a(0);
        if (cvzo2 != null) {
            int n;
            HashMap<cvzo, Integer> hashMap = new HashMap<cvzo, Integer>();
            for (int n2 : roleFollower.inventory.items.keySet()) {
                cvzo cvzo3 = roleFollower.inventory.items.get(n2);
                if (cvzo3 == null || cvzo3._d != cvzo2._d || cvzo3._g() && cvzo3._j() != cvzo2._j()) continue;
                n = 1;
                if (roleFollower.rates.containsKey(n2)) {
                    n = (Integer)roleFollower.rates.get(n2);
                }
                hashMap.put(cvzo3, n);
            }
            if (hashMap.size() != 0) {
                int n2;
                int n3 = cvzo2._b;
                n2 = 0;
                int n4 = 0;
                n = n3;
                while (true) {
                    for (cvzo cvzo4 : hashMap.keySet()) {
                        int n5;
                        int n6;
                        int n7;
                        int n8 = (Integer)hashMap.get(cvzo4);
                        int n9 = cvzo4._b;
                        if (n9 > n3 || n4 > (n7 = (n6 = n3 - (n5 = n3 % n9)) / n9 * n8)) continue;
                        n4 = n7;
                        n = n5;
                    }
                    if (n3 == n) {
                        if (n2 == 0) {
                            return;
                        }
                        if (n3 <= 0) {
                            mssh2.func_70299_a(0, null);
                        } else {
                            cvzo2._a(n3);
                        }
                        entityNPCInterface.say(entityPlayerMP, new Line(roleFollower.dialogHire.replaceAll("\\{days\\}", n2 + "")));
                        roleFollower.setOwner(entityPlayerMP.field_71092_bJ);
                        roleFollower.addDays(n2);
                        return;
                    }
                    n3 = n;
                    n2 += n4;
                    n4 = 0;
                }
            }
        }
    }

    public static void bankUpgrade(EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface) {
        jjgc jjgc2;
        if (entityNPCInterface.advanced.role == EnumRoleType.Bank && (jjgc2 = entityPlayerMP.field_71070_bA) != null && jjgc2 instanceof ContainerNPCBankInterface) {
            ContainerNPCBankInterface containerNPCBankInterface = (ContainerNPCBankInterface)jjgc2;
            Bank bank = BankController.getInstance().getBank(containerNPCBankInterface.bankid);
            cvzo cvzo2 = bank.upgradeInventory.func_70301_a(containerNPCBankInterface.slot);
            if (cvzo2 != null) {
                int n = cvzo2._b;
                cvzo cvzo3 = containerNPCBankInterface.currencyMatrix.func_70301_a(0);
                if (cvzo3 != null && n <= cvzo3._b) {
                    if (cvzo3._b - n == 0) {
                        containerNPCBankInterface.currencyMatrix.func_70299_a(0, null);
                    } else {
                        cvzo3._a(n);
                    }
                    PlayerBankData playerBankData = PlayerDataController.instance.getBankData(entityPlayerMP, bank.id);
                    BankData bankData = playerBankData.getBank(bank.id);
                    bankData.upgradedSlots.put(containerNPCBankInterface.slot, true);
                    bankData.openBankGui(entityPlayerMP, entityNPCInterface, bank.id, containerNPCBankInterface.slot);
                }
            }
        }
    }

    public static void bankUnlock(EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface) {
        jjgc jjgc2;
        if (entityNPCInterface.advanced.role == EnumRoleType.Bank && (jjgc2 = entityPlayerMP.field_71070_bA) != null && jjgc2 instanceof ContainerNPCBankInterface) {
            ContainerNPCBankInterface containerNPCBankInterface = (ContainerNPCBankInterface)jjgc2;
            Bank bank = BankController.getInstance().getBank(containerNPCBankInterface.bankid);
            cvzo cvzo2 = bank.currencyInventory.func_70301_a(containerNPCBankInterface.slot);
            if (cvzo2 != null) {
                int n = cvzo2._b;
                cvzo cvzo3 = containerNPCBankInterface.currencyMatrix.func_70301_a(0);
                if (cvzo3 != null && n <= cvzo3._b) {
                    if (cvzo3._b - n == 0) {
                        containerNPCBankInterface.currencyMatrix.func_70299_a(0, null);
                    } else {
                        cvzo3._a(n);
                    }
                    PlayerBankData playerBankData = PlayerDataController.instance.getBankData(entityPlayerMP, bank.id);
                    BankData bankData = playerBankData.getBank(bank.id);
                    if (bankData.unlockedSlots + 1 <= bank.maxSlots) {
                        ++bankData.unlockedSlots;
                    }
                    bankData.openBankGui(entityPlayerMP, entityNPCInterface, bank.id, containerNPCBankInterface.slot);
                }
            }
        }
    }

    public static void sendData(EnumPlayerPacket enumPlayerPacket, Object ... objectArray) {
        InvokeSideOnly.client(() -> {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = NoppesUtil.getDataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(enumPlayerPacket.ordinal());
                Object[] objectArray2 = objectArray;
                int n = objectArray.length;
                for (int i = 0; i < n; ++i) {
                    Object object = objectArray2[i];
                    if (object instanceof Integer) {
                        dataOutputStream.writeInt((Integer)object);
                        continue;
                    }
                    if (object instanceof String) {
                        dataOutputStream.writeUTF((String)object);
                        continue;
                    }
                    if (object instanceof Long) {
                        dataOutputStream.writeLong((Long)object);
                        continue;
                    }
                    if (!(object instanceof qoac)) continue;
                    bsvf._a((qoac)object, dataOutputStream);
                }
                dataOutputStream.close();
                PacketDispatcher.sendPacketToServer(new jjqf("CNPCs Player", byteArrayOutputStream.toByteArray()));
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        });
    }

    public static void dialogSelected(int n, int n2, EntityPlayer entityPlayer, EntityNPCInterface entityNPCInterface) {
        Dialog dialog = DialogController.instance.dialogs.get(n);
        if (dialog != null && (dialog.hasDialogs(entityPlayer) || dialog.hasOtherOptions())) {
            DialogOption dialogOption = dialog.options.get(n2);
            if (dialogOption == null) {
                return;
            }
            if (dialogOption.shouldClose()) {
                NoppesUtilServer.closeCurrentDialog(entityPlayer, entityNPCInterface);
            }
            if ((dialogOption.optionType != EnumOptionType.DialogOption || dialogOption.isAvailable(entityPlayer) && dialogOption.hasDialog()) && dialogOption.optionType != EnumOptionType.Disabled) {
                if (dialogOption.optionType == EnumOptionType.RoleOption) {
                    if (entityNPCInterface.roleInterface != null) {
                        entityNPCInterface.roleInterface.interact(entityPlayer);
                    }
                    if (entityNPCInterface.jobInterface != null) {
                        entityNPCInterface.jobInterface.onDialogInteract(entityPlayer);
                    }
                } else if (dialogOption.optionType == EnumOptionType.DialogOption) {
                    PlayerData.getData((EntityPlayer)entityPlayer).dialogData.lastRead.put(dialogOption.getDialog().id, System.currentTimeMillis());
                    NoppesUtilServer.openDialog(entityPlayer, entityNPCInterface, dialogOption.getDialog());
                } else if (dialogOption.optionType == EnumOptionType.CommandBlock) {
                    NoppesUtilPlayer.runCommand(entityNPCInterface, dialogOption.command.replaceAll("@dp", entityPlayer.field_71092_bJ));
                }
            }
        }
    }

    public static void runCommand(EntityNPCInterface entityNPCInterface, String string) {
        oiid oiid2 = new oiid();
        oiid2.field_70331_k = entityNPCInterface.field_70170_p;
        oiid2._a(string);
        oiid2._b("@" + entityNPCInterface.func_70005_c_());
        oiid2.field_70329_l = sajh._c(entityNPCInterface.field_70165_t);
        oiid2.field_70330_m = sajh._c(entityNPCInterface.field_70163_u);
        oiid2.field_70327_n = sajh._c(entityNPCInterface.field_70161_v);
        oiid2._a(entityNPCInterface.field_70170_p);
    }

    public static void sendQuestLogData(EntityPlayerMP entityPlayerMP) {
        if (PlayerQuestController.hasActiveQuests(entityPlayerMP)) {
            QuestLogData questLogData = new QuestLogData();
            questLogData.setData(entityPlayerMP);
            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, questLogData.writeNBT());
        }
    }

    public static void questCompletion(EntityPlayerMP entityPlayerMP, int n) {
        InvokeSideOnly.frontend(() -> {});
    }
}

