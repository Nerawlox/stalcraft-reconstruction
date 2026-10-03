/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.smart.moving.IEntityPlayerMP;
import net.smart.moving.IPacketReceiver;
import net.smart.moving.IPacketSender;
import net.smart.moving.SmartMovingContext;
import net.smart.moving.SmartMovingFactory;
import net.smart.moving.SmartMovingOther;
import net.smart.moving.SmartMovingPacketStream;

public class SmartMovingComm
extends SmartMovingContext
implements IPacketReceiver,
IPacketSender {
    public static final SmartMovingComm instance = new SmartMovingComm();

    @Override
    public boolean processStatePacket(Packet250CustomPayload packet250CustomPayload, IEntityPlayerMP iEntityPlayerMP, int n, long l) {
        Entity entity = Minecraft._E()._r.getEntityByID(n);
        if (entity == null) {
            return true;
        }
        SmartMovingOther smartMovingOther = SmartMovingFactory.getOtherSmartMoving((EntityOtherPlayerMP)entity);
        if (smartMovingOther != null) {
            smartMovingOther.processStatePacket(l);
        }
        return true;
    }

    @Override
    public void sendPacket(byte[] byArray) {
        Packet250CustomPayload packet250CustomPayload = new Packet250CustomPayload();
        packet250CustomPayload.channel = SmartMovingPacketStream.Id;
        packet250CustomPayload.data = byArray;
        packet250CustomPayload.length = byArray.length;
        Minecraft._E()._z()._b(packet250CustomPayload);
    }
}

