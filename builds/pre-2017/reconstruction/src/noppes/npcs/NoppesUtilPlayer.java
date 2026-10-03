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
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.util.sajh;
import net.minecraft.world.WorldServer;
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
        if (entityNPCInterface.advanced.role == EnumRoleType.Follower && (entityPlayer = (roleFollower = (RoleFollower)entityNPCInterface.roleInterface).getOwner()) != null && entityPlayer.username.equals(entityPlayerMP.username)) {
            roleFollower.isFollowing = !roleFollower.isFollowing;
        }
    }

    public static void hireFollower(EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface) {
        Container container;
        if (entityNPCInterface.advanced.role == EnumRoleType.Follower && (container = entityPlayerMP.openContainer) != null && container instanceof ContainerNPCFollowerHire) {
            ContainerNPCFollowerHire containerNPCFollowerHire = (ContainerNPCFollowerHire)container;
            RoleFollower roleFollower = (RoleFollower)entityNPCInterface.roleInterface;
            NoppesUtilPlayer.followerBuy(roleFollower, containerNPCFollowerHire.currencyMatrix, entityPlayerMP, entityNPCInterface);
        }
    }

    public static void extendFollower(EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface) {
        Container container;
        if (entityNPCInterface.advanced.role == EnumRoleType.Follower && (container = entityPlayerMP.openContainer) != null && container instanceof ContainerNPCFollower) {
            ContainerNPCFollower containerNPCFollower = (ContainerNPCFollower)container;
            RoleFollower roleFollower = (RoleFollower)entityNPCInterface.roleInterface;
            NoppesUtilPlayer.followerBuy(roleFollower, containerNPCFollower.currencyMatrix, entityPlayerMP, entityNPCInterface);
        }
    }

    public static void transport(EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface, String string) {
        TransportLocation transportLocation = TransportController.getInstance().getTransport(string);
        PlayerTransportData playerTransportData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayerMP).transportData;
        if (transportLocation != null && (transportLocation.isDefault() || playerTransportData.transports.contains(transportLocation.id))) {
            if (entityPlayerMP.dimension != transportLocation.dimension) {
                System.out.println(transportLocation.dimension + " transfering");
                int n = entityPlayerMP.dimension;
                MinecraftServer minecraftServer = MinecraftServer._I();
                WorldServer worldServer = minecraftServer._a(entityPlayerMP.dimension);
                entityPlayerMP.playerNetServerHandler.setPlayerLocation(transportLocation.posX, transportLocation.posY, transportLocation.posZ, entityPlayerMP.rotationYaw, entityPlayerMP.rotationPitch);
                minecraftServer.__ag()._a(entityPlayerMP, transportLocation.dimension, new CustomTeleporter(worldServer));
                if (n == 1 && entityPlayerMP.isEntityAlive()) {
                    entityPlayerMP.setLocationAndAngles(transportLocation.posX, transportLocation.posY, transportLocation.posZ, entityPlayerMP.rotationYaw, entityPlayerMP.rotationPitch);
                    worldServer.spawnEntityInWorld(entityPlayerMP);
                }
                entityPlayerMP.worldObj.updateEntityWithOptionalForce(entityPlayerMP, false);
            } else {
                entityPlayerMP.playerNetServerHandler.setPlayerLocation(transportLocation.posX, transportLocation.posY, transportLocation.posZ, entityPlayerMP.rotationYaw, entityPlayerMP.rotationPitch);
                entityPlayerMP.worldObj.updateEntityWithOptionalForce(entityPlayerMP, false);
            }
        }
    }

    private static void followerBuy(RoleFollower roleFollower, IInventory iInventory, EntityPlayerMP entityPlayerMP, EntityNPCInterface entityNPCInterface) {
        ItemStack itemStack = iInventory.getStackInSlot(0);
        if (itemStack != null) {
            int n;
            HashMap<ItemStack, Integer> hashMap = new HashMap<ItemStack, Integer>();
            for (int n2 : roleFollower.inventory.items.keySet()) {
                ItemStack itemStack2 = roleFollower.inventory.items.get(n2);
                if (itemStack2 == null || itemStack2._d != itemStack._d || itemStack2._g() && itemStack2._j() != itemStack._j()) continue;
                n = 1;
                if (roleFollower.rates.containsKey(n2)) {
                    n = (Integer)roleFollower.rates.get(n2);
                }
                hashMap.put(itemStack2, n);
            }
            if (hashMap.size() != 0) {
                int n2;
                int n3 = itemStack._b;
                n2 = 0;
                int n4 = 0;
                n = n3;
                while (true) {
                    for (ItemStack itemStack3 : hashMap.keySet()) {
                        int n5;
                        int n6;
                        int n7;
                        int n8 = (Integer)hashMap.get(itemStack3);
                        int n9 = itemStack3._b;
                        if (n9 > n3 || n4 > (n7 = (n6 = n3 - (n5 = n3 % n9)) / n9 * n8)) continue;
                        n4 = n7;
                        n = n5;
                    }
                    if (n3 == n) {
                        if (n2 == 0) {
                            return;
                        }
                        if (n3 <= 0) {
                            iInventory.setInventorySlotContents(0, null);
                        } else {
                            itemStack._a(n3);
                        }
                        entityNPCInterface.say(entityPlayerMP, new Line(roleFollower.dialogHire.replaceAll("\\{days\\}", n2 + "")));
                        roleFollower.setOwner(entityPlayerMP.username);
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
        Container container;
        if (entityNPCInterface.advanced.role == EnumRoleType.Bank && (container = entityPlayerMP.openContainer) != null && container instanceof ContainerNPCBankInterface) {
            ContainerNPCBankInterface containerNPCBankInterface = (ContainerNPCBankInterface)container;
            Bank bank = BankController.getInstance().getBank(containerNPCBankInterface.bankid);
            ItemStack itemStack = bank.upgradeInventory.getStackInSlot(containerNPCBankInterface.slot);
            if (itemStack != null) {
                int n = itemStack._b;
                ItemStack itemStack2 = containerNPCBankInterface.currencyMatrix.getStackInSlot(0);
                if (itemStack2 != null && n <= itemStack2._b) {
                    if (itemStack2._b - n == 0) {
                        containerNPCBankInterface.currencyMatrix.setInventorySlotContents(0, null);
                    } else {
                        itemStack2._a(n);
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
        Container container;
        if (entityNPCInterface.advanced.role == EnumRoleType.Bank && (container = entityPlayerMP.openContainer) != null && container instanceof ContainerNPCBankInterface) {
            ContainerNPCBankInterface containerNPCBankInterface = (ContainerNPCBankInterface)container;
            Bank bank = BankController.getInstance().getBank(containerNPCBankInterface.bankid);
            ItemStack itemStack = bank.currencyInventory.getStackInSlot(containerNPCBankInterface.slot);
            if (itemStack != null) {
                int n = itemStack._b;
                ItemStack itemStack2 = containerNPCBankInterface.currencyMatrix.getStackInSlot(0);
                if (itemStack2 != null && n <= itemStack2._b) {
                    if (itemStack2._b - n == 0) {
                        containerNPCBankInterface.currencyMatrix.setInventorySlotContents(0, null);
                    } else {
                        itemStack2._a(n);
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
                    if (!(object instanceof NBTTagCompound)) continue;
                    bsvf._a((NBTTagCompound)object, dataOutputStream);
                }
                dataOutputStream.close();
                PacketDispatcher.sendPacketToServer(new Packet250CustomPayload("CNPCs Player", byteArrayOutputStream.toByteArray()));
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
                    NoppesUtilPlayer.runCommand(entityNPCInterface, dialogOption.command.replaceAll("@dp", entityPlayer.username));
                }
            }
        }
    }

    public static void runCommand(EntityNPCInterface entityNPCInterface, String string) {
        TileEntityCommandBlock tileEntityCommandBlock = new TileEntityCommandBlock();
        tileEntityCommandBlock.worldObj = entityNPCInterface.worldObj;
        tileEntityCommandBlock._a(string);
        tileEntityCommandBlock._b("@" + entityNPCInterface.getCommandSenderName());
        tileEntityCommandBlock.xCoord = sajh._c(entityNPCInterface.posX);
        tileEntityCommandBlock.yCoord = sajh._c(entityNPCInterface.posY);
        tileEntityCommandBlock.zCoord = sajh._c(entityNPCInterface.posZ);
        tileEntityCommandBlock._a(entityNPCInterface.worldObj);
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

