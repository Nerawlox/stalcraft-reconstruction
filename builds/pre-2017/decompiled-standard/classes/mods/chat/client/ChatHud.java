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
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;

@ezey(_a={eidj.CLIENT})
public class ChatHud {
    private static final List<Class<? extends gqjz>> supportedGuis = Arrays.asList(pidb.class);
    public static final ResourceLocation texture = new ResourceLocation("chat", "textures/gui/chat.png");
    public htou screen;
    private GuiChatActive chatGui;
    public boolean active = false;

    @ForgeSubscribe
    public void onChatRenderer(RenderGameOverlayEvent renderGameOverlayEvent) {
        if (renderGameOverlayEvent.type == RenderGameOverlayEvent.ElementType.CHAT) {
            renderGameOverlayEvent.setCanceled(true);
            xpzm._E().__ah._b();
        }
    }

    @ForgeSubscribe
    public void onTick(lnrm.kjui kjui2) {
        if (kjui2._c == lnrm.pidb._b) {
            boolean bl;
            xpzm xpzm2 = xpzm._E();
            if (this.active && xpzm2._B == null) {
                this.active = false;
            }
            boolean bl2 = bl = xpzm2._B != null && supportedGuis.contains(xpzm2._B.getClass());
            if (ChatMod.instance.chatKeyBinding._c() && !this.active && (xpzm2._B == null || bl)) {
                this.displayActiveChat();
            }
            if (this.active && xpzm2._B != this.getChat()) {
                this.getChat().func_73862_m();
                this.getChat().func_73876_c();
            }
        }
    }

    @ForgeSubscribe
    public void render(RenderGameOverlayEvent.Post post) {
        if (post.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        xpzm xpzm2 = xpzm._E();
        if (this.active && xpzm2._B == this.getChat()) {
            return;
        }
        htou htou2 = new htou(xpzm2._M, xpzm2._n, xpzm2._o);
        if (this.screen == null || this.screen._a() != htou2._a() || this.screen._b() != htou2._b()) {
            this.screen = htou2;
            this.getChat().func_73872_a(xpzm2, this.screen._a(), this.screen._b());
        }
        if (this.active && xpzm2._B != this.getChat()) {
            this.getChat().func_73863_a(post.mouseX, post.mouseY, post.partialTicks);
        } else if (!this.active) {
            this.getChat().drawMessages();
        }
    }

    public void displayActiveChat() {
        xpzm xpzm2 = xpzm._E();
        gqjz gqjz2 = xpzm2._B;
        if (!this.active) {
            if (gqjz2 != null) {
                if (gqjz2 != this.getChat() && supportedGuis.contains(gqjz2.getClass())) {
                    this.getChat().func_73872_a(xpzm2, this.screen._a(), this.screen._b());
                    this.active = true;
                }
            } else {
                xpzm2._a(this.getChat());
                this.active = true;
            }
        }
    }

    public void updateChat() {
        xpzm xpzm2 = xpzm._E();
        this.screen = new htou(xpzm2._M, xpzm2._n, xpzm2._o);
        this.chatGui.func_73872_a(xpzm2, this.screen._a(), this.screen._b());
    }

    public GuiChatActive getChat() {
        if (this.chatGui == null) {
            this.chatGui = new GuiChatActive();
            this.updateChat();
        }
        return this.chatGui;
    }
}

