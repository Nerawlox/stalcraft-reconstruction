/*
 * Decompiled with CFR 0.152.
 */
package eu.ha3.matmos.game.data;

import eu.ha3.mc.haddon.PrivateAccessException;
import eu.ha3.mc.haddon.Utility;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPool;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class MAtAccessors {
    public static FoodStats getFoodStatsOf(EntityPlayerSP entityPlayerSP) {
        return entityPlayerSP.getFoodStats();
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

    public static WorldInfo getWorldInfoOf(World world) {
        return world.getWorldInfo();
    }

    public static SoundPool getSoundPoolSounds(Utility utility) {
        try {
            return (SoundPool)utility.getPrivate(Minecraft._E()._N, "soundPoolSounds");
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

