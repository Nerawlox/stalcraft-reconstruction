/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving;

import net.smart.moving.IEntityPlayerMP;
import net.smart.moving.ILocalUserNameProvider;
import net.smart.moving.IPacketReceiver;

public class SmartMovingServerComm
implements IPacketReceiver {
    public static ILocalUserNameProvider localUserNameProvider = null;
    public static final SmartMovingServerComm instance = new SmartMovingServerComm();

    @Override
    public boolean processStatePacket(jjqf jjqf2, IEntityPlayerMP iEntityPlayerMP, int n, long l) {
        return true;
    }

    public boolean processConfigInfoPacket(jjqf jjqf2, IEntityPlayerMP iEntityPlayerMP, String string) {
        return true;
    }

    public boolean processConfigContentPacket(jjqf jjqf2, IEntityPlayerMP iEntityPlayerMP, String[] stringArray, String string) {
        return false;
    }

    public boolean processConfigChangePacket(jjqf jjqf2, IEntityPlayerMP iEntityPlayerMP) {
        return true;
    }

    public boolean processSpeedChangePacket(jjqf jjqf2, IEntityPlayerMP iEntityPlayerMP, int n, String string) {
        return true;
    }

    public boolean processHungerChangePacket(jjqf jjqf2, IEntityPlayerMP iEntityPlayerMP, float f) {
        return true;
    }

    public boolean processSoundPacket(jjqf jjqf2, IEntityPlayerMP iEntityPlayerMP, String string, float f, float f2) {
        return true;
    }
}

