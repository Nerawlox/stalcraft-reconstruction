/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  cpw.mods.fml.common.network.PacketDispatcher
 *  ea
 */
package ru.stalcraft.client.network;

import cpw.mods.fml.common.network.PacketDispatcher;
import java.nio.charset.Charset;
import ru.stalcraft.client.network.ServerOpcodes;

public class ClientPacketSender {
    public static void sendMachineGunShooter(int xCoord, int yCoord, int zCoord) {
        ClientPacketSender.send(ServerOpcodes.MACHINE_GUN_SHOOTER, xCoord, yCoord, zCoord);
    }

    public static void sendWeaponFireMode() {
        ClientPacketSender.send(ServerOpcodes.WEAPON_FIRE_MODE, new Object[0]);
    }

    public static void sendExtractAmmoRequest() {
        ClientPacketSender.send(ServerOpcodes.EXTRACT_AMMO_REQUEST, new Object[0]);
    }

    public static void sendSyncReputationRequest() {
        ClientPacketSender.send(ServerOpcodes.CLAN_SYNC_REPUTATION_REQUEST, new Object[0]);
    }

    public static void sendWithdrawRequest() {
        ClientPacketSender.send(ServerOpcodes.CLAN_GET_MONEY_REQUEST, new Object[0]);
    }

    public static void sendLandRenameRequest(int landId, String newName) {
        ClientPacketSender.send(ServerOpcodes.CLAN_LAND_RENAME_REQUEST, landId, newName);
    }

    public static void sendClanSetRulesRequest(String newRules) {
        ClientPacketSender.send(ServerOpcodes.CLAN_CLEAR_RULES_REQUEST, new Object[0]);
        for (int part = 0; part < (newRules.length() - 1) / 1000 + 1; ++part) {
            ClientPacketSender.send(ServerOpcodes.CLAN_ADD_RULES_REQUEST, newRules.substring(part * 1000, Math.min(newRules.length(), part * 1000 + 1000)));
        }
    }

    public static void sendClanJoinRequest(String clan) {
        ClientPacketSender.send(ServerOpcodes.CLAN_JOIN_REQUEST, clan);
    }

    public static void sendSetLeaderRequest(String username) {
        ClientPacketSender.send(ServerOpcodes.CLAN_SET_LEADER_REQUEST, username);
    }

    public static void sendRankUpRequest(String username) {
        ClientPacketSender.send(ServerOpcodes.CLAN_RANK_UP_REQUEST, username);
    }

    public static void sendRankDownRequest(String username) {
        ClientPacketSender.send(ServerOpcodes.CLAN_RANK_DOWN_REQUEST, username);
    }

    public static void sendClanInfoRequest() {
        ClientPacketSender.send(ServerOpcodes.CLAN_INFO_REQUEST, new Object[0]);
    }

    public static void sendClanRulesRequest() {
        ClientPacketSender.send(ServerOpcodes.CLAN_RULES_REQUEST, new Object[0]);
    }

    public static void sendClanListRequest() {
        ClientPacketSender.send(ServerOpcodes.CLAN_LIST_REQUEST, new Object[0]);
    }

    public static void sendClanMembersRequest() {
        ClientPacketSender.send(ServerOpcodes.CLAN_MEMBERS_REQUEST, new Object[0]);
    }

    public static void sendClanLandsRequest() {
        ClientPacketSender.send(ServerOpcodes.CLAN_LANDS_REQUEST, new Object[0]);
    }

    public static void sendClanCreateRequest(String clanName) {
        ClientPacketSender.send(ServerOpcodes.CLAN_CREATE_REQUEST, clanName);
    }

    public static void sendClanDeleteRequest() {
        ClientPacketSender.send(ServerOpcodes.CLAN_DELETE_REQUEST, new Object[0]);
    }

    public static void sendClanWarRequest(String clan) {
        ClientPacketSender.send(ServerOpcodes.CLAN_WAR_REQUEST, clan);
    }

    public static void sendClanPeaceRequest(String clan) {
        ClientPacketSender.send(ServerOpcodes.CLAN_PEACE_OFFER_REQUEST, clan);
    }

    public static void sendClanPeaceOfferCancelRequest(String clan) {
        ClientPacketSender.send(ServerOpcodes.CLAN_PEACE_OFFER_CANCEL_REQUEST, clan);
    }

    public static void sendClanInviteRequest(String username) {
        ClientPacketSender.send(ServerOpcodes.CLAN_INVITE_CLIENT_REQUEST, username);
    }

    public static void sendClanKickRequest(String username) {
        ClientPacketSender.send(ServerOpcodes.CLAN_KICK_REQUEST, username);
    }

    public static void sendClanLeaveRequest() {
        ClientPacketSender.send(ServerOpcodes.CLAN_LEAVE_REQUEST, new Object[0]);
    }

    public static void sendHandcuffsAnswer(uf handcuffer, boolean confirmed) {
        ClientPacketSender.send(ServerOpcodes.HANDCUFFS_ANSWER, handcuffer.k, confirmed ? "1" : "0");
    }

    public static void sendRightClickRequest(uf player) {
        ClientPacketSender.send(ServerOpcodes.RIGHT_CLICK_PLAYER_REQUEST, player.bu);
    }

    public static void sendRightClickBlock(int par1, int par2, int par3) {
        ClientPacketSender.send(ServerOpcodes.RIGHT_CLICK_BLOCK, par1, par2, par3);
    }

    public static void sendUseMedicine(int slotNumber) {
        ClientPacketSender.send(ServerOpcodes.USE_HEALING_REQUEST, slotNumber);
    }

    public static void sendReloadRequest() {
        ClientPacketSender.send(ServerOpcodes.RELOAD_REQUEST, new Object[0]);
    }

    public static void sendShootRequest(int currentItem, int type) {
        ClientPacketSender.send(ServerOpcodes.SHOOT_REQUEST, type);
    }

    public static void sendFlashlightRequest() {
        ClientPacketSender.send(ServerOpcodes.FLASHLIGHT_TOGGLE_REQUEST, new Object[0]);
    }

    public static void sendMachineGunReloadRequest() {
        ClientPacketSender.send(ServerOpcodes.MACHINE_GUN_RELOAD_REQUEST, new Object[0]);
    }

    public static void sendMachineGunShootRequest() {
        ClientPacketSender.send(ServerOpcodes.MACHINE_GUN_SHOOT_REQUEST, new Object[0]);
    }

    public static void sendOpenGuiInventory() {
        ClientPacketSender.send(ServerOpcodes.GUI_OPEN_INVENTORY, new Object[0]);
    }

    public static void sendRightClickBlockClan(int par1, int par2, int par3, int par4) {
        ClientPacketSender.send(ServerOpcodes.RIGHT_CLICK_BLOCK, par1, par2, par3, par4);
    }

    private static void send(ServerOpcodes opcode, Object ... data) {
        PacketDispatcher.sendPacketToServer((ey)ClientPacketSender.createPacket(opcode, data));
    }

    private static ea createPacket(ServerOpcodes opcode, Object ... data) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(opcode.getOrdinal()).append(":").append(data.length);
        for (int str = 0; str < data.length; ++str) {
            buffer.append(":");
            buffer.append(data[str].toString().replaceAll("\\\\", "\\\\\\\\").replaceAll(":", "\\\\:"));
        }
        String var5 = buffer.toString();
        ea packet = new ea();
        packet.a = "modST";
        packet.c = var5.getBytes(Charset.forName("UTF-8"));
        packet.b = packet.c.length;
        return packet;
    }
}

