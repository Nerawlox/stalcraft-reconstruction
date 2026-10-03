/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.world.World;
import net.minecraftforge.common.FakePlayer;

public class FakePlayerFactory {
    private static Map<String, FakePlayer> fakePlayers = new HashMap<String, FakePlayer>();
    private static FakePlayer MINECRAFT_PLAYER = null;

    public static FakePlayer getMinecraft(World world) {
        if (MINECRAFT_PLAYER == null) {
            MINECRAFT_PLAYER = FakePlayerFactory.get(world, "[Minecraft]");
        }
        return MINECRAFT_PLAYER;
    }

    public static FakePlayer get(World world, String string) {
        if (!fakePlayers.containsKey(string)) {
            FakePlayer fakePlayer = new FakePlayer(world, string);
            fakePlayers.put(string, fakePlayer);
        }
        return fakePlayers.get(string);
    }
}

