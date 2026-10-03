/*
 * Decompiled with CFR 0.152.
 */
package noppes.npcs;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.network.packet.Packet250CustomPayload;
import noppes.npcs.EntityNPCInterface;
import noppes.npcs.NoppesUtilPlayer;
import noppes.npcs.NoppesUtilServer;
import noppes.npcs.constants.EnumPacketType;
import noppes.npcs.constants.EnumPlayerPacket;
import noppes.npcs.containers.ContainerNpcResearcher;
import noppes.npcs.controllers.BankData;
import noppes.npcs.controllers.PlayerDataController;
import noppes.npcs.controllers.PlayerFactionData;
import noppes.npcs.controllers.PlayerQuestData;

public class PacketHandlerPlayer
implements IPacketHandler {
    @Override
    public void onPacketData(jjpj jjpj2, Packet250CustomPayload packet250CustomPayload, Player player) {
        if (packet250CustomPayload.channel.equals("CNPCs Player")) {
            try {
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new GZIPInputStream(new ByteArrayInputStream(packet250CustomPayload.data))));
                this.player(dataInputStream, (EntityPlayerMP)player, EnumPlayerPacket.values()[dataInputStream.readInt()]);
                dataInputStream.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private void player(DataInputStream dataInputStream, EntityPlayerMP entityPlayerMP, EnumPlayerPacket enumPlayerPacket) throws IOException {
        if (enumPlayerPacket == EnumPlayerPacket.FollowerHire) {
            EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayerMP);
            if (entityNPCInterface == null) {
                return;
            }
            NoppesUtilPlayer.hireFollower(entityPlayerMP, entityNPCInterface);
        } else if (enumPlayerPacket == EnumPlayerPacket.FollowerExtend) {
            EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayerMP);
            if (entityNPCInterface == null) {
                return;
            }
            NoppesUtilPlayer.extendFollower(entityPlayerMP, entityNPCInterface);
        } else if (enumPlayerPacket == EnumPlayerPacket.FollowerState) {
            EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayerMP);
            if (entityNPCInterface == null) {
                return;
            }
            NoppesUtilPlayer.changeFollowerState(entityPlayerMP, entityNPCInterface);
        } else if (enumPlayerPacket == EnumPlayerPacket.Transport) {
            EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayerMP);
            if (entityNPCInterface == null) {
                return;
            }
            NoppesUtilPlayer.transport(entityPlayerMP, entityNPCInterface, dataInputStream.readUTF());
        } else if (enumPlayerPacket == EnumPlayerPacket.BankUpgrade) {
            EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayerMP);
            if (entityNPCInterface == null) {
                return;
            }
            NoppesUtilPlayer.bankUpgrade(entityPlayerMP, entityNPCInterface);
        } else if (enumPlayerPacket == EnumPlayerPacket.BankUnlock) {
            EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayerMP);
            if (entityNPCInterface == null) {
                return;
            }
            NoppesUtilPlayer.bankUnlock(entityPlayerMP, entityNPCInterface);
        } else if (enumPlayerPacket == EnumPlayerPacket.BankSlotOpen) {
            EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayerMP);
            if (entityNPCInterface == null) {
                return;
            }
            int n = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            BankData bankData = PlayerDataController.instance.getBankData(entityPlayerMP, n2).getBankOrDefault(n2);
            bankData.openBankGui(entityPlayerMP, entityNPCInterface, n2, n);
        } else if (enumPlayerPacket == EnumPlayerPacket.Dialog) {
            EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayerMP);
            if (entityNPCInterface == null) {
                return;
            }
            NoppesUtilPlayer.dialogSelected(dataInputStream.readInt(), dataInputStream.readInt(), entityPlayerMP, entityNPCInterface);
        } else if (enumPlayerPacket == EnumPlayerPacket.CheckQuestCompletion) {
            PlayerQuestData playerQuestData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayerMP).questData;
            playerQuestData.checkQuestCompletion(entityPlayerMP, null);
        } else if (enumPlayerPacket == EnumPlayerPacket.QuestLog) {
            NoppesUtilPlayer.sendQuestLogData(entityPlayerMP);
        } else if (enumPlayerPacket == EnumPlayerPacket.AdvancedQuestLog) {
            InvokeSideOnly.frontend(!entityPlayerMP.worldObj.isRemote, () -> {});
        } else if (enumPlayerPacket == EnumPlayerPacket.CompletedQuestLog) {
            InvokeSideOnly.frontend(!entityPlayerMP.worldObj.isRemote, () -> {});
        } else if (enumPlayerPacket == EnumPlayerPacket.FactionsGet) {
            PlayerFactionData playerFactionData = PlayerDataController.instance.getPlayerData((EntityPlayer)entityPlayerMP).factionData;
            NoppesUtilServer.sendData(entityPlayerMP, EnumPacketType.GuiData, playerFactionData.getPlayerGuiData());
        } else if (enumPlayerPacket == EnumPlayerPacket.ProbeItem) {
            Container container = entityPlayerMP.openContainer;
            if (container instanceof ContainerNpcResearcher) {
                ((ContainerNpcResearcher)container).probeItem();
            }
        } else if (enumPlayerPacket == EnumPlayerPacket.CloseDialog) {
            EntityNPCInterface entityNPCInterface = NoppesUtilServer.getEditingNpc(entityPlayerMP);
            NoppesUtilServer.closeCurrentDialog(entityPlayerMP, entityNPCInterface);
        }
    }
}

