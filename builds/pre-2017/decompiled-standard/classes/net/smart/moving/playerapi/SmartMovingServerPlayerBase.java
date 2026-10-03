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
import net.minecraft.util.eidj;
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
    private static final Field _ticksForFloatKick = Reflect.GetField(xbvu.class, Install.NetServerHandler_ticksForFloatKick);

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
        return this.player.field_70131_O;
    }

    @Override
    public double getMinY() {
        return this.player.field_70121_D._c;
    }

    @Override
    public void setMaxY(double d) {
        this.player.field_70121_D._f = d;
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
        return this.player.func_110143_aJ();
    }

    @Override
    public eidj getBox() {
        return this.player.field_70121_D;
    }

    @Override
    public eidj expandBox(eidj eidj2, double d, double d2, double d3) {
        return eidj2._b(d, d2, d3);
    }

    @Override
    public List getEntitiesExcludingPlayer(eidj eidj2) {
        return this.player.field_70170_p.func_72839_b(this.player, eidj2);
    }

    @Override
    public boolean isDeadEntity(Entity entity) {
        return entity.field_70128_L;
    }

    @Override
    public void onCollideWithPlayer(Entity entity) {
        entity.func_70100_b_(this.player);
    }

    @Override
    public float getEyeHeight() {
        return this.player.field_70131_O - 0.18f;
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
        this.player.func_85030_a(string, f, f2);
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
        this.player.field_70131_O = f;
    }

    @Override
    public void sendPacket(byte[] byArray) {
        jjqf jjqf2 = new jjqf();
        jjqf2.field_73630_a = SmartMovingPacketStream.Id;
        jjqf2.field_73629_c = byArray;
        jjqf2.field_73628_b = byArray.length;
        this.sendPacket(jjqf2);
    }

    public void sendPacket(jjqf jjqf2) {
        this.player.field_71135_a.func_72567_b(jjqf2);
    }

    @Override
    public String getUsername() {
        return this.player.func_70023_ak();
    }

    @Override
    public void resetFallDistance() {
        this.player.field_70143_R = 0.0f;
        this.player.field_70181_x = 0.08;
    }

    @Override
    public void resetTicksForFloatKick() {
        Reflect.SetField(_ticksForFloatKick, this.player.field_71135_a, 0);
    }

    @Override
    public void sendPacketToTrackedPlayers(jjqf jjqf2) {
        this.player.field_71133_b._a(this.player.field_71093_bK).func_73039_n()._a((Entity)this.player, jjqf2);
    }

    @Override
    public Logger getLogger() {
        return Install.getLogger(dzfd._I()._O());
    }

    @Override
    public SmartMovingServer getMoving() {
        return this.moving;
    }

    @Override
    public IEntityPlayerMP[] getAllPlayers() {
        List list = this.player.field_71133_b.__ag()._e;
        IEntityPlayerMP[] iEntityPlayerMPArray = new IEntityPlayerMP[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            iEntityPlayerMPArray[i] = (IEntityPlayerMP)((Object)((EntityPlayerMP)list.get(i)).getServerPlayerBase("Smart Moving"));
        }
        return iEntityPlayerMPArray;
    }
}

