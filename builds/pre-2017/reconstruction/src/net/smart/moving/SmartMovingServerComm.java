/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.minecraft.network.packet.Packet250CustomPayload;
import net.smart.moving.IEntityPlayerMP;
import net.smart.moving.ILocalUserNameProvider;
import net.smart.moving.IPacketReceiver;

public class SmartMovingServerComm
implements IPacketReceiver {
    public static ILocalUserNameProvider localUserNameProvider = null;
    public static final SmartMovingServerComm instance = new SmartMovingServerComm();

    @Override
    public boolean processStatePacket(Packet250CustomPayload packet250CustomPayload, IEntityPlayerMP iEntityPlayerMP, int n, long l) {
        return true;
    }

    public boolean processConfigInfoPacket(Packet250CustomPayload packet250CustomPayload, IEntityPlayerMP iEntityPlayerMP, String string) {
        return true;
    }

    public boolean processConfigContentPacket(Packet250CustomPayload packet250CustomPayload, IEntityPlayerMP iEntityPlayerMP, String[] stringArray, String string) {
        return false;
    }

    public boolean processConfigChangePacket(Packet250CustomPayload packet250CustomPayload, IEntityPlayerMP iEntityPlayerMP) {
        return true;
    }

    public boolean processSpeedChangePacket(Packet250CustomPayload packet250CustomPayload, IEntityPlayerMP iEntityPlayerMP, int n, String string) {
        return true;
    }

    public boolean processHungerChangePacket(Packet250CustomPayload packet250CustomPayload, IEntityPlayerMP iEntityPlayerMP, float f) {
        return true;
    }

    public boolean processSoundPacket(Packet250CustomPayload packet250CustomPayload, IEntityPlayerMP iEntityPlayerMP, String string, float f, float f2) {
        return true;
    }
}

