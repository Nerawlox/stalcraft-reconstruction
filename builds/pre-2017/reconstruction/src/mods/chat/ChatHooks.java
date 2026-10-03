/*
 * Decompiled with CFR 0.152.
 */
package mods.chat;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import mods.chat.ChatMod;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet203AutoComplete;

public class ChatHooks {
    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean processPacket(Packet203AutoComplete packet203AutoComplete, NetHandler netHandler) {
        if (netHandler instanceof bscn) {
            String[] stringArray = packet203AutoComplete._a().split("\u0000");
            ChatMod.instance.chatHud.getChat().handleCompletionData(stringArray);
            return true;
        }
        return false;
    }
}

