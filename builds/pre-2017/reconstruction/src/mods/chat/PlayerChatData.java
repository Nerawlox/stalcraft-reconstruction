/*
 * Decompiled with CFR 0.152.
 */
package mods.chat;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;

public class PlayerChatData
extends tehy {
    public static final String ID = "CHAT_PLAYER_DATA";
    public Set<String> ignoredSenders = new HashSet<String>();

    public PlayerChatData(ccxr ccxr2) {
        super(ccxr2);
    }

    public boolean isIgnored(String string) {
        return this.ignoredSenders.contains(string);
    }

    public static PlayerChatData get(ccxr ccxr2) {
        return (PlayerChatData)ccxr2._h.get(ID);
    }

    public static PlayerChatData get(EntityPlayer entityPlayer) {
        return PlayerChatData.get(ncwh._a(entityPlayer));
    }
}

