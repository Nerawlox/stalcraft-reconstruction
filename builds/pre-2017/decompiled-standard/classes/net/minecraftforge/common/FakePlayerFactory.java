/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.common;

import java.util.HashMap;
import java.util.Map;
import net.minecraftforge.common.FakePlayer;

public class FakePlayerFactory {
    private static Map<String, FakePlayer> fakePlayers = new HashMap<String, FakePlayer>();
    private static FakePlayer MINECRAFT_PLAYER = null;

    public static FakePlayer getMinecraft(ozlu ozlu2) {
        if (MINECRAFT_PLAYER == null) {
            MINECRAFT_PLAYER = FakePlayerFactory.get(ozlu2, "[Minecraft]");
        }
        return MINECRAFT_PLAYER;
    }

    public static FakePlayer get(ozlu ozlu2, String string) {
        if (!fakePlayers.containsKey(string)) {
            FakePlayer fakePlayer = new FakePlayer(ozlu2, string);
            fakePlayers.put(string, fakePlayer);
        }
        return fakePlayers.get(string);
    }
}

