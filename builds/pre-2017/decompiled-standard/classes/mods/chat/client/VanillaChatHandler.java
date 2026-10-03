/*
 * Decompiled with CFR 0.152.
 */
package mods.chat.client;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.tupg;
import mods.chat.ChatMod;
import mods.chat.client.screen.GuiChatActive;
import net.minecraft.util.zwat;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.ForgeSubscribe;

@ezey(_a={eidj.CLIENT})
public class VanillaChatHandler {
    @ForgeSubscribe
    public void onClientMessage(ClientChatReceivedEvent clientChatReceivedEvent) {
        clientChatReceivedEvent.setCanceled(true);
        zwat zwat2 = zwat._c(clientChatReceivedEvent.message);
        jxsn jxsn2 = new jxsn(ugqi._a, "", "", zwat2._a(true), System.currentTimeMillis(), tupg._a);
        new ofaz(jxsn2).processClient(false);
    }

    @ForgeSubscribe
    public void onVanillaChatOpen(GuiOpenEvent guiOpenEvent) {
        if (guiOpenEvent.gui != null && guiOpenEvent.gui.getClass() == fndz.class) {
            guiOpenEvent.setCanceled(true);
            GuiChatActive guiChatActive = ChatMod.instance.chatHud.getChat();
            String string = ((fndz)guiOpenEvent.gui)._i;
            if (string != null && !string.isEmpty()) {
                guiChatActive.defaultText = string;
            }
            ChatMod.instance.chatHud.displayActiveChat();
        }
    }
}

