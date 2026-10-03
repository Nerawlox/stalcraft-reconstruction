/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
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
    public boolean processStatePacket(jjqf jjqf2, IEntityPlayerMP iEntityPlayerMP, int n, long l) {
        Entity entity = xpzm._E()._r.func_73045_a(n);
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
        jjqf jjqf2 = new jjqf();
        jjqf2.field_73630_a = SmartMovingPacketStream.Id;
        jjqf2.field_73629_c = byArray;
        jjqf2.field_73628_b = byArray.length;
        xpzm._E()._z()._b(jjqf2);
    }
}

