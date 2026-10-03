/*
 * Decompiled with CFR 0.152.
 */
package mods.chat;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.hooklib.asm.Hook;
import gloomyfolken.hooklib.asm.ReturnCondition;
import mods.chat.ChatMod;

public class ChatHooks {
    @ezey(_a={eidj.CLIENT})
    @Hook(returnCondition=ReturnCondition.ON_TRUE)
    public static boolean processPacket(hdkt hdkt2, elai elai2) {
        if (elai2 instanceof bscn) {
            String[] stringArray = hdkt2._a().split("\u0000");
            ChatMod.instance.chatHud.getChat().handleCompletionData(stringArray);
            return true;
        }
        return false;
    }
}

