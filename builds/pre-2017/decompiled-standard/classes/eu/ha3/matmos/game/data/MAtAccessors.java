/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.mc.haddon.PrivateAccessException;
import eu.ha3.mc.haddon.Utility;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.xpzm;
import net.minecraft.util.tdmn;

public class MAtAccessors {
    public static tdmn getFoodStatsOf(EntityPlayerSP entityPlayerSP) {
        return entityPlayerSP.func_71024_bL();
    }

    public static boolean getIsJumpingOf(Utility utility, EntityPlayerSP entityPlayerSP) {
        try {
            return (Boolean)utility.getPrivate(entityPlayerSP, "isJumping");
        }
        catch (PrivateAccessException privateAccessException) {
            privateAccessException.printStackTrace();
            throw new RuntimeException(privateAccessException);
        }
    }

    public static boolean getIsInWebOf(Utility utility, EntityPlayerSP entityPlayerSP) {
        try {
            return (Boolean)utility.getPrivate(entityPlayerSP, "isInWeb");
        }
        catch (PrivateAccessException privateAccessException) {
            privateAccessException.printStackTrace();
            throw new RuntimeException(privateAccessException);
        }
    }

    public static iyev getWorldInfoOf(ozlu ozlu2) {
        return ozlu2.func_72912_H();
    }

    public static uiog getSoundPoolSounds(Utility utility) {
        try {
            return (uiog)utility.getPrivate(xpzm._E()._N, "soundPoolSounds");
        }
        catch (PrivateAccessException privateAccessException) {
            MAtAccessors.throwMismatchingReflection(privateAccessException);
            return null;
        }
    }

    private static void throwMismatchingReflection(Exception exception) {
        throw new RuntimeException("Mismatching reflection " + exception.getMessage());
    }
}

