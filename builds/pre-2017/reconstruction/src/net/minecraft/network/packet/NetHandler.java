/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet102WindowClick;
import net.minecraft.network.packet.Packet106Transaction;
import net.minecraft.network.packet.Packet107CreativeSetSlot;
import net.minecraft.network.packet.Packet108EnchantItem;
import net.minecraft.network.packet.Packet10Flying;
import net.minecraft.network.packet.Packet130UpdateSign;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.network.packet.Packet16BlockItemSwitch;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet19EntityAction;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet203AutoComplete;
import net.minecraft.network.packet.Packet204ClientInfo;
import net.minecraft.network.packet.Packet205ClientCommand;
import net.minecraft.network.packet.Packet209SetPlayerTeam;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet252SharedKey;
import net.minecraft.network.packet.Packet254ServerPing;
import net.minecraft.network.packet.Packet255KickDisconnect;
import net.minecraft.network.packet.Packet27PlayerInput;
import net.minecraft.network.packet.Packet30Entity;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet44UpdateAttributes;
import net.minecraft.network.packet.Packet52MultiBlockChange;
import net.minecraft.network.packet.Packet56MapChunks;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.network.packet.Packet7UseEntity;
import net.minecraft.network.packet.Packet9Respawn;

public abstract class NetHandler {
    public abstract boolean isServerHandler();

    public void handleMapChunk(ujsv ujsv2) {
    }

    public void unexpectedPacket(Packet packet) {
    }

    public void handleErrorMessage(String string, Object[] objectArray) {
    }

    public void handleKickDisconnect(Packet255KickDisconnect packet255KickDisconnect) {
        this.unexpectedPacket(packet255KickDisconnect);
    }

    public void handleLogin(txpf txpf2) {
        this.unexpectedPacket(txpf2);
    }

    public void handleFlying(Packet10Flying packet10Flying) {
        this.unexpectedPacket(packet10Flying);
    }

    public void handleMultiBlockChange(Packet52MultiBlockChange packet52MultiBlockChange) {
        this.unexpectedPacket(packet52MultiBlockChange);
    }

    public void handleBlockDig(Packet14BlockDig packet14BlockDig) {
        this.unexpectedPacket(packet14BlockDig);
    }

    public void handleBlockChange(cwan cwan2) {
        this.unexpectedPacket(cwan2);
    }

    public void handleNamedEntitySpawn(xsze xsze2) {
        this.unexpectedPacket(xsze2);
    }

    public void handleEntity(Packet30Entity packet30Entity) {
        this.unexpectedPacket(packet30Entity);
    }

    public void handleEntityTeleport(txnr txnr2) {
        this.unexpectedPacket(txnr2);
    }

    public void handlePlace(Packet15Place packet15Place) {
        this.unexpectedPacket(packet15Place);
    }

    public void handleBlockItemSwitch(Packet16BlockItemSwitch packet16BlockItemSwitch) {
        this.unexpectedPacket(packet16BlockItemSwitch);
    }

    public void handleDestroyEntity(ixod ixod2) {
        this.unexpectedPacket(ixod2);
    }

    public void handleCollect(bbyg bbyg2) {
        this.unexpectedPacket(bbyg2);
    }

    public void handleChat(Packet3Chat packet3Chat) {
        this.unexpectedPacket(packet3Chat);
    }

    public void handleVehicleSpawn(ixor ixor2) {
        this.unexpectedPacket(ixor2);
    }

    public void handleAnimation(Packet18Animation packet18Animation) {
        this.unexpectedPacket(packet18Animation);
    }

    public void handleEntityAction(Packet19EntityAction packet19EntityAction) {
        this.unexpectedPacket(packet19EntityAction);
    }

    public void handleClientProtocol(yezn yezn2) {
        this.unexpectedPacket(yezn2);
    }

    public void handleServerAuthData(ujpx ujpx2) {
        this.unexpectedPacket(ujpx2);
    }

    public void handleSharedKey(Packet252SharedKey packet252SharedKey) {
        this.unexpectedPacket(packet252SharedKey);
    }

    public void handleMobSpawn(tgmo tgmo2) {
        this.unexpectedPacket(tgmo2);
    }

    public void handleUpdateTime(rrld rrld2) {
        this.unexpectedPacket(rrld2);
    }

    public void handleSpawnPosition(xbzt xbzt2) {
        this.unexpectedPacket(xbzt2);
    }

    public void handleEntityVelocity(fofa fofa2) {
        this.unexpectedPacket(fofa2);
    }

    public void handleEntityMetadata(qoia qoia2) {
        this.unexpectedPacket(qoia2);
    }

    public void handleAttachEntity(nwaj nwaj2) {
        this.unexpectedPacket(nwaj2);
    }

    public void handleUseEntity(Packet7UseEntity packet7UseEntity) {
        this.unexpectedPacket(packet7UseEntity);
    }

    public void handleEntityStatus(bszz bszz2) {
        this.unexpectedPacket(bszz2);
    }

    public void handleUpdateHealth(sdlz sdlz2) {
        this.unexpectedPacket(sdlz2);
    }

    public void handleRespawn(Packet9Respawn packet9Respawn) {
        this.unexpectedPacket(packet9Respawn);
    }

    public void handleExplosion(ozcz ozcz2) {
        this.unexpectedPacket(ozcz2);
    }

    public void handleOpenWindow(lpub lpub2) {
        this.unexpectedPacket(lpub2);
    }

    public void handleCloseWindow(Packet101CloseWindow packet101CloseWindow) {
        this.unexpectedPacket(packet101CloseWindow);
    }

    public void handleWindowClick(Packet102WindowClick packet102WindowClick) {
        this.unexpectedPacket(packet102WindowClick);
    }

    public void handleSetSlot(ixmv ixmv2) {
        this.unexpectedPacket(ixmv2);
    }

    public void handleWindowItems(wptu wptu2) {
        this.unexpectedPacket(wptu2);
    }

    public void handleUpdateSign(Packet130UpdateSign packet130UpdateSign) {
        this.unexpectedPacket(packet130UpdateSign);
    }

    public void handleUpdateProgressbar(neyc neyc2) {
        this.unexpectedPacket(neyc2);
    }

    public void handlePlayerInventory(hdms hdms2) {
        this.unexpectedPacket(hdms2);
    }

    public void handleTransaction(Packet106Transaction packet106Transaction) {
        this.unexpectedPacket(packet106Transaction);
    }

    public void handleEntityPainting(ixoa ixoa2) {
        this.unexpectedPacket(ixoa2);
    }

    public void handleBlockEvent(ujsb ujsb2) {
        this.unexpectedPacket(ujsb2);
    }

    public void handleStatistic(dzcl dzcl2) {
        this.unexpectedPacket(dzcl2);
    }

    public void handleSleep(kmuh kmuh2) {
        this.unexpectedPacket(kmuh2);
    }

    public void func_110774_a(Packet27PlayerInput packet27PlayerInput) {
        this.unexpectedPacket(packet27PlayerInput);
    }

    public void handleGameEvent(Packet70GameEvent packet70GameEvent) {
        this.unexpectedPacket(packet70GameEvent);
    }

    public void handleWeather(dibg dibg2) {
        this.unexpectedPacket(dibg2);
    }

    public void handleMapData(yexp yexp2) {
        this.unexpectedPacket(yexp2);
    }

    public void handleDoorChange(qohl qohl2) {
        this.unexpectedPacket(qohl2);
    }

    public void handleServerPing(Packet254ServerPing packet254ServerPing) {
        this.unexpectedPacket(packet254ServerPing);
    }

    public void handleEntityEffect(cwaw cwaw2) {
        this.unexpectedPacket(cwaw2);
    }

    public void handleRemoveEntityEffect(zibp zibp2) {
        this.unexpectedPacket(zibp2);
    }

    public void handlePlayerInfo(bbzw bbzw2) {
        this.unexpectedPacket(bbzw2);
    }

    public void handleKeepAlive(Packet0KeepAlive packet0KeepAlive) {
        this.unexpectedPacket(packet0KeepAlive);
    }

    public void handleExperience(rajk rajk2) {
        this.unexpectedPacket(rajk2);
    }

    public void handleCreativeSetSlot(Packet107CreativeSetSlot packet107CreativeSetSlot) {
        this.unexpectedPacket(packet107CreativeSetSlot);
    }

    public void handleEntityExpOrb(kmst kmst2) {
        this.unexpectedPacket(kmst2);
    }

    public void handleEnchantItem(Packet108EnchantItem packet108EnchantItem) {
    }

    public void handleCustomPayload(Packet250CustomPayload packet250CustomPayload) {
    }

    public void handleEntityHeadRotation(ragc ragc2) {
        this.unexpectedPacket(ragc2);
    }

    public void handleTileEntityData(wpte wpte2) {
        this.unexpectedPacket(wpte2);
    }

    public void handlePlayerAbilities(Packet202PlayerAbilities packet202PlayerAbilities) {
        this.unexpectedPacket(packet202PlayerAbilities);
    }

    public void handleAutoComplete(Packet203AutoComplete packet203AutoComplete) {
        this.unexpectedPacket(packet203AutoComplete);
    }

    public void handleClientInfo(Packet204ClientInfo packet204ClientInfo) {
        this.unexpectedPacket(packet204ClientInfo);
    }

    public void handleLevelSound(lpza lpza2) {
        this.unexpectedPacket(lpza2);
    }

    public void handleBlockDestroy(igpu igpu2) {
        this.unexpectedPacket(igpu2);
    }

    public void handleClientCommand(Packet205ClientCommand packet205ClientCommand) {
    }

    public void handleMapChunks(Packet56MapChunks packet56MapChunks) {
        this.unexpectedPacket(packet56MapChunks);
    }

    public boolean canProcessPacketsAsync() {
        return false;
    }

    public void handleSetObjective(sulv sulv2) {
        this.unexpectedPacket(sulv2);
    }

    public void handleSetScore(plcv plcv2) {
        this.unexpectedPacket(plcv2);
    }

    public void handleSetDisplayObjective(txou txou2) {
        this.unexpectedPacket(txou2);
    }

    public void handleSetPlayerTeam(Packet209SetPlayerTeam packet209SetPlayerTeam) {
        this.unexpectedPacket(packet209SetPlayerTeam);
    }

    public void handleWorldParticles(grll grll2) {
        this.unexpectedPacket(grll2);
    }

    public void func_110773_a(Packet44UpdateAttributes packet44UpdateAttributes) {
        this.unexpectedPacket(packet44UpdateAttributes);
    }

    public void func_142031_a(wpwt wpwt2) {
    }

    public boolean isConnectionClosed() {
        return false;
    }

    public abstract void handleVanilla250Packet(Packet250CustomPayload var1);

    public abstract EntityPlayer getPlayer();
}

