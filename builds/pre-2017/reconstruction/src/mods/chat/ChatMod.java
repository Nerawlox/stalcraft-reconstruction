/*
 * Decompiled with CFR 0.152.
 */
package mods.chat;

import com.google.common.collect.Sets;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import gloomyfolken.bundle.common.core.InvokeSideOnly;
import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.bundle.common.core.stats.Stat;
import gloomyfolken.bundle.common.core.stats.StatsType;
import gloomyfolken.mods.core.client.gui.screens.GuiPlayerInteract;
import gloomyfolken.mods.core.main.GloomyAPI;
import mods.chat.PlayerChatData;
import mods.chat.client.ChatHud;
import mods.chat.client.ChatSettings;
import mods.chat.client.VanillaChatHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import org.apache.commons.lang3.ArrayUtils;

@Mod(modid="ChatMod", name="Chat Mod", version="2.4.47_[1.6.4]", dependencies="required-after:GloomyCore;required-after:GloomyFactions;required-after:GloomyParty;required-after:StalkerClans")
public class ChatMod {
    public static final ChatSettings.ChatGroup CHAT_ALL = new ChatSettings.ChatGroup("\u0412\u0441\u0435", ugqi._c, Sets.newHashSet(ugqi._c, ugqi._d, ugqi._e, ugqi._f, ugqi._g, ugqi._a), false);
    public static final ChatSettings.ChatGroup CHAT_TRADE = new ChatSettings.ChatGroup("+\u0422\u043e\u0440\u0433\u043e\u0432\u043b\u044f", ugqi._d, Sets.newHashSet(ugqi._d, ugqi._a), false);
    public static final ChatSettings.ChatGroup CHAT_PARTY = new ChatSettings.ChatGroup("*\u041e\u0442\u0440\u044f\u0434", ugqi._f, Sets.newHashSet(ugqi._f, ugqi._a), true);
    public static final ChatSettings.ChatGroup CHAT_GUILD = new ChatSettings.ChatGroup("%\u041a\u043b\u0430\u043d", ugqi._e, Sets.newHashSet(ugqi._e, ugqi._a), true);
    public static final ChatSettings.ChatGroup CHAT_PRIVATE = new ChatSettings.ChatGroup("@\u041b\u0421", ugqi._g, Sets.newHashSet(ugqi._g, ugqi._a), true);
    public static final String MODID = "ChatMod";
    public static final Stat CHAT_MESSAGES_SENT = Stat.register("cha-mes-sen", "\u0421\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0439 \u0432 \u0447\u0430\u0442 \u043e\u0442\u043f\u0440\u0430\u0432\u043b\u0435\u043d\u043e", Stat.StatsCategory.EXPLORATION, StatsType.INTEGER);
    public static final tdpx KAPIBARA = wmvj._a("\u0437\u043e\u043d\u0430", "kapibara", 0);
    @ezey(_a={eidj.CLIENT})
    public ChatHud chatHud;
    @ezey(_a={eidj.CLIENT})
    public KeyBinding chatKeyBinding;
    @Mod.Instance(value="ChatMod")
    public static ChatMod instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        MinecraftForge.EVENT_BUS.register(this);
        InvokeSideOnly.client(fMLInitializationEvent.getSide().isClient(), () -> this.onClientLoad());
    }

    @ForgeSubscribe
    public void registerChatDataHandler(mquk mquk2) {
        mquk2._a("CHAT_PLAYER_DATA", new PlayerChatData(mquk2._a));
    }

    @ezey(_a={eidj.CLIENT})
    private void onClientLoad() {
        GameSettings gameSettings = Minecraft._E()._M;
        gameSettings.keyBindings = ArrayUtils.removeElement(gameSettings.keyBindings, gameSettings.keyBindChat);
        this.chatHud = new ChatHud();
        MinecraftForge.EVENT_BUS.register(this.chatHud);
        MinecraftForge.EVENT_BUS.register(new VanillaChatHandler());
        GloomyAPI.registerAssetsDir("chat", ChatMod.class);
        this.chatKeyBinding = new KeyBinding("\u041e\u0442\u043a\u0440\u044b\u0442\u044c \u0447\u0430\u0442", 28);
        GloomyAPI.registerKeyBinding(this.chatKeyBinding, null);
        this.initDefaultChatGroups();
        GuiPlayerInteract.registerProvider("\u041e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c \u0441\u043e\u043e\u0431\u0449\u0435\u043d\u0438\u0435", ChatMod::openChatWith);
    }

    @ezey(_a={eidj.CLIENT})
    public static void openChatWith(String string) {
        ChatMod.instance.chatHud.getChat().defaultText = "@" + string + ": ";
        Minecraft._E()._o();
        ChatMod.instance.chatHud.displayActiveChat();
    }

    @ezey(_a={eidj.CLIENT})
    public static void openChatWith(EntityPlayer entityPlayer) {
        ChatMod.openChatWith(entityPlayer.username);
    }

    @ezey(_a={eidj.CLIENT})
    private void initDefaultChatGroups() {
        ChatSettings.SETTINGS.add(CHAT_ALL);
        ChatSettings.SETTINGS.setGroup(CHAT_ALL);
        ChatSettings.SETTINGS.add(CHAT_TRADE);
        ChatSettings.SETTINGS.add(CHAT_PARTY);
        ChatSettings.SETTINGS.add(CHAT_GUILD);
        ChatSettings.SETTINGS.add(CHAT_PRIVATE);
    }
}

