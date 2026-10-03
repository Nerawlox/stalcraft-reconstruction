/*
 * Decompiled with CFR 0.152.
 */
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import net.smart.moving.playerapi.SmartMovingServerPlayerBase;

public class ogfj {
    @Hook(returnCondition=ReturnCondition.ALWAYS)
    public static void _a(SmartMovingServerPlayerBase smartMovingServerPlayerBase) {
        smartMovingServerPlayerBase.moving.beforeOnUpdate();
    }

    @Hook(targetMethod="handleFlying")
    public static void _a(xbvu xbvu2, yvzj yvzj2) {
        SmartMovingServerPlayerBase smartMovingServerPlayerBase = SmartMovingServerPlayerBase.getPlayerBase(xbvu2.field_72574_e);
        if (smartMovingServerPlayerBase != null) {
            smartMovingServerPlayerBase.moving.beforeAddMovingHungerBatch();
        }
    }

    @Hook(targetMethod="handleFlying", injectOnExit=true)
    public static void _b(xbvu xbvu2, yvzj yvzj2) {
        SmartMovingServerPlayerBase smartMovingServerPlayerBase = SmartMovingServerPlayerBase.getPlayerBase(xbvu2.field_72574_e);
        if (smartMovingServerPlayerBase != null) {
            smartMovingServerPlayerBase.moving.afterAddMovingHungerBatch();
        }
    }
}

