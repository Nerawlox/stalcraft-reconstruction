/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet10Flying;
import net.smart.moving.playerapi.SmartMovingServerPlayerBase;

public class ogfj {
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(SmartMovingServerPlayerBase smartMovingServerPlayerBase) {
        smartMovingServerPlayerBase.moving.beforeOnUpdate();
    }

    @Hook(targetMethod="handleFlying")
    public static void _a(NetServerHandler netServerHandler, Packet10Flying packet10Flying) {
        SmartMovingServerPlayerBase smartMovingServerPlayerBase = SmartMovingServerPlayerBase.getPlayerBase(netServerHandler.playerEntity);
        if (smartMovingServerPlayerBase != null) {
            smartMovingServerPlayerBase.moving.beforeAddMovingHungerBatch();
        }
    }

    @Hook(targetMethod="handleFlying", injectOnExit=true)
    public static void _b(NetServerHandler netServerHandler, Packet10Flying packet10Flying) {
        SmartMovingServerPlayerBase smartMovingServerPlayerBase = SmartMovingServerPlayerBase.getPlayerBase(netServerHandler.playerEntity);
        if (smartMovingServerPlayerBase != null) {
            smartMovingServerPlayerBase.moving.afterAddMovingHungerBatch();
        }
    }
}

