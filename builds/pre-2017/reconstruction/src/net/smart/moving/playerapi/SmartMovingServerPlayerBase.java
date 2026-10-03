/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.playerapi;

import api.player.server.ServerPlayerAPI;
import api.player.server.ServerPlayerBase;
import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.AxisAlignedBB;
import net.smart.moving.IEntityPlayerMP;
import net.smart.moving.SmartMovingPacketStream;
import net.smart.moving.SmartMovingServer;
import net.smart.utilities.Install;
import net.smart.utilities.Reflect;

public class SmartMovingServerPlayerBase
extends ServerPlayerBase
implements IEntityPlayerMP {
    private boolean _hasReplacedNetServerHandler;
    public final SmartMovingServer moving;
    private static final Field _ticksForFloatKick = Reflect.GetField(NetServerHandler.class, Install.NetServerHandler_ticksForFloatKick);

    public static void registerPlayerBase() {
        ServerPlayerAPI.register("Smart Moving", SmartMovingServerPlayerBase.class);
    }

    public static SmartMovingServerPlayerBase getPlayerBase(Object object) {
        return (SmartMovingServerPlayerBase)((EntityPlayerMP)object).getServerPlayerBase("Smart Moving");
    }

    public SmartMovingServerPlayerBase(ServerPlayerAPI serverPlayerAPI) {
        super(serverPlayerAPI);
        this.moving = new SmartMovingServer(this, this.player, false);
    }

    @Override
    public float getHeight() {
        return this.player.height;
    }

    @Override
    public double getMinY() {
        return this.player.boundingBox._c;
    }

    @Override
    public void setMaxY(double d) {
        this.player.boundingBox._f = d;
    }

    @Override
    public void afterSetPosition(double d, double d2, double d3) {
        this.moving.afterSetPosition(d, d2, d3);
    }

    @Override
    public void beforeIsPlayerSleeping() {
    }

    public void onPlayerJoin() {
        this.moving.onPlayerJoin();
    }

    @Override
    public void beforeOnUpdate() {
        ogfj._a(this);
    }

    @Override
    public void afterOnUpdate() {
        this.moving.afterOnUpdate();
    }

    @Override
    public void beforeOnLivingUpdate() {
        this.moving.beforeOnLivingUpdate();
    }

    @Override
    public void afterOnLivingUpdate() {
        this.moving.afterOnLivingUpdate();
    }

    @Override
    public float doGetHealth() {
        return this.player.getHealth();
    }

    @Override
    public AxisAlignedBB getBox() {
        return this.player.boundingBox;
    }

    @Override
    public AxisAlignedBB expandBox(AxisAlignedBB axisAlignedBB, double d, double d2, double d3) {
        return axisAlignedBB._b(d, d2, d3);
    }

    @Override
    public List getEntitiesExcludingPlayer(AxisAlignedBB axisAlignedBB) {
        return this.player.worldObj.getEntitiesWithinAABBExcludingEntity(this.player, axisAlignedBB);
    }

    @Override
    public boolean isDeadEntity(Entity entity) {
        return entity.isDead;
    }

    @Override
    public void onCollideWithPlayer(Entity entity) {
        entity.onCollideWithPlayer(this.player);
    }

    @Override
    public float getEyeHeight() {
        return this.player.height - 0.18f;
    }

    @Override
    public boolean isEntityInsideOpaqueBlock() {
        return this.moving.isEntityInsideOpaqueBlock();
    }

    @Override
    public boolean localIsEntityInsideOpaqueBlock() {
        return super.isEntityInsideOpaqueBlock();
    }

    @Override
    public void addExhaustion(float f) {
        this.moving.addExhaustion(f);
    }

    @Override
    public void localAddExhaustion(float f) {
        super.addExhaustion(f);
    }

    @Override
    public void addMovementStat(double d, double d2, double d3) {
        this.moving.addMovementStat(d, d2, d3);
    }

    @Override
    public void localAddMovementStat(double d, double d2, double d3) {
        super.addMovementStat(d, d2, d3);
    }

    @Override
    public void localPlaySound(String string, float f, float f2) {
        this.player.playSound(string, f, f2);
    }

    @Override
    public void beforeUpdatePotionEffects() {
        this.moving.afterAddMovingHungerBatch();
    }

    @Override
    public void afterUpdatePotionEffects() {
        this.moving.beforeAddMovingHungerBatch();
    }

    @Override
    public void setHeight(float f) {
        this.player.height = f;
    }

    @Override
    public void sendPacket(byte[] byArray) {
        Packet250CustomPayload packet250CustomPayload = new Packet250CustomPayload();
        packet250CustomPayload.channel = SmartMovingPacketStream.Id;
        packet250CustomPayload.data = byArray;
        packet250CustomPayload.length = byArray.length;
        this.sendPacket(packet250CustomPayload);
    }

    public void sendPacket(Packet250CustomPayload packet250CustomPayload) {
        this.player.playerNetServerHandler.func_72567_b(packet250CustomPayload);
    }

    @Override
    public String getUsername() {
        return this.player.getEntityName();
    }

    @Override
    public void resetFallDistance() {
        this.player.fallDistance = 0.0f;
        this.player.motionY = 0.08;
    }

    @Override
    public void resetTicksForFloatKick() {
        Reflect.SetField(_ticksForFloatKick, this.player.playerNetServerHandler, 0);
    }

    @Override
    public void sendPacketToTrackedPlayers(Packet250CustomPayload packet250CustomPayload) {
        this.player.mcServer._a(this.player.dimension).getEntityTracker()._a((Entity)this.player, packet250CustomPayload);
    }

    @Override
    public Logger getLogger() {
        return Install.getLogger(MinecraftServer._I()._O());
    }

    @Override
    public SmartMovingServer getMoving() {
        return this.moving;
    }

    @Override
    public IEntityPlayerMP[] getAllPlayers() {
        List list = this.player.mcServer.__ag()._e;
        IEntityPlayerMP[] iEntityPlayerMPArray = new IEntityPlayerMP[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            iEntityPlayerMPArray[i] = (IEntityPlayerMP)((Object)((EntityPlayerMP)list.get(i)).getServerPlayerBase("Smart Moving"));
        }
        return iEntityPlayerMPArray;
    }
}

