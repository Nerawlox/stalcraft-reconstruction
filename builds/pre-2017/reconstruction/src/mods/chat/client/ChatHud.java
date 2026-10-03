/*
 * Decompiled with CFR 0.152.
 */
package mods.chat.client;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import gloomyfolken.mods.trade.pidb;
import java.util.Arrays;
import java.util.List;
import mods.chat.ChatMod;
import mods.chat.client.screen.GuiChatActive;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;

@ezey(_a={eidj.CLIENT})
public class ChatHud {
    private static final List<Class<? extends GuiScreen>> supportedGuis = Arrays.asList(pidb.class);
    public static final ResourceLocation texture = new ResourceLocation("chat", "textures/gui/chat.png");
    public htou screen;
    private GuiChatActive chatGui;
    public boolean active = false;

    @ForgeSubscribe
    public void onChatRenderer(RenderGameOverlayEvent renderGameOverlayEvent) {
        if (renderGameOverlayEvent.type == RenderGameOverlayEvent.ElementType.CHAT) {
            renderGameOverlayEvent.setCanceled(true);
            Minecraft._E().__ah._b();
        }
    }

    @ForgeSubscribe
    public void onTick(lnrm.kjui kjui2) {
        if (kjui2._c == lnrm.pidb._b) {
            boolean bl;
            Minecraft minecraft = Minecraft._E();
            if (this.active && minecraft._B == null) {
                this.active = false;
            }
            boolean bl2 = bl = minecraft._B != null && supportedGuis.contains(minecraft._B.getClass());
            if (ChatMod.instance.chatKeyBinding._c() && !this.active && (minecraft._B == null || bl)) {
                this.displayActiveChat();
            }
            if (this.active && minecraft._B != this.getChat()) {
                this.getChat().handleInput();
                this.getChat().updateScreen();
            }
        }
    }

    @ForgeSubscribe
    public void render(RenderGameOverlayEvent.Post post) {
        if (post.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        Minecraft minecraft = Minecraft._E();
        if (this.active && minecraft._B == this.getChat()) {
            return;
        }
        htou htou2 = new htou(minecraft._M, minecraft._n, minecraft._o);
        if (this.screen == null || this.screen._a() != htou2._a() || this.screen._b() != htou2._b()) {
            this.screen = htou2;
            this.getChat().setWorldAndResolution(minecraft, this.screen._a(), this.screen._b());
        }
        if (this.active && minecraft._B != this.getChat()) {
            this.getChat().drawScreen(post.mouseX, post.mouseY, post.partialTicks);
        } else if (!this.active) {
            this.getChat().drawMessages();
        }
    }

    public void displayActiveChat() {
        Minecraft minecraft = Minecraft._E();
        GuiScreen guiScreen = minecraft._B;
        if (!this.active) {
            if (guiScreen != null) {
                if (guiScreen != this.getChat() && supportedGuis.contains(guiScreen.getClass())) {
                    this.getChat().setWorldAndResolution(minecraft, this.screen._a(), this.screen._b());
                    this.active = true;
                }
            } else {
                minecraft._a(this.getChat());
                this.active = true;
            }
        }
    }

    public void updateChat() {
        Minecraft minecraft = Minecraft._E();
        this.screen = new htou(minecraft._M, minecraft._n, minecraft._o);
        this.chatGui.setWorldAndResolution(minecraft, this.screen._a(), this.screen._b());
    }

    public GuiChatActive getChat() {
        if (this.chatGui == null) {
            this.chatGui = new GuiChatActive();
            this.updateChat();
        }
        return this.chatGui;
    }
}

