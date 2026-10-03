/*
 * Decompiled with CFR 0.152.
 */
package net.smart.moving.playerapi;

import api.player.client.ClientPlayerBase;
import java.lang.reflect.Field;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.smart.moving.config.SmartMovingOptions;
import net.smart.moving.playerapi.SmartMovingPlayerBase;
import net.smart.utilities.Name;
import net.smart.utilities.Reflect;

public class SmartMovingSelf
extends net.smart.moving.SmartMovingSelf {
    private static Field playerHelperField = null;
    private static Field flyingField = null;

    public SmartMovingSelf(EntityPlayer entityPlayer, SmartMovingPlayerBase smartMovingPlayerBase) {
        super(entityPlayer, smartMovingPlayerBase);
    }

    @Override
    public boolean doFlyingAnimation() {
        return SmartMovingOptions.hasSinglePlayerCommands && SmartMovingSelf.isSPCFlying(this.esp) || super.doFlyingAnimation();
    }

    public static boolean isSPCFlying(EntityPlayerSP entityPlayerSP) {
        if (!SmartMovingOptions.hasSinglePlayerCommands) {
            return false;
        }
        ClientPlayerBase clientPlayerBase = entityPlayerSP.getClientPlayerBase("Single Player Commands");
        if (clientPlayerBase == null) {
            return false;
        }
        if (playerHelperField == null) {
            playerHelperField = Reflect.GetField(clientPlayerBase.getClass(), new Name("ph"), false);
        }
        if (playerHelperField == null) {
            return false;
        }
        Object object = Reflect.GetField(playerHelperField, clientPlayerBase);
        if (object == null) {
            return false;
        }
        if (flyingField == null) {
            flyingField = Reflect.GetField(object.getClass(), new Name("flying"), false);
        }
        if (flyingField == null) {
            return false;
        }
        Object object2 = Reflect.GetField(flyingField, object);
        return object2 == null ? false : object2 instanceof Boolean && (Boolean)object2 != false;
    }
}

