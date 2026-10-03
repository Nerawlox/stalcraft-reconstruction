/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.hud;

import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import gloomyfolken.mods.core.main.ClientProxy;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import mods.pda.client.PdaClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

public class NotificationHud {
    public static ResourceLocation NOTIFICATIONS = new ResourceLocation("pda", "textures/gui/notifications.png");
    private static long SHOW_TIME = TimeUnit.SECONDS.toMillis(10L);
    private static long FADE_OUT = TimeUnit.SECONDS.toMillis(2L);
    private static GuiRenderer iconRenderer = new GuiRendererBuilder().setTextureSize(256, 256).create();
    private static qlzo move = new ycpw()._a(new ivew(zftb._g, 2000L, false))._a(new ivew(zftb._a, 10000L, true))._a();
    private static qlzo alpha = new ycpw()._a(new ivew(zftb._g, 2000L, false))._a(new ivew(zftb._a, 8000L, true))._a(new ivew(zftb._e, 2000L, true))._a();

    @ForgeSubscribe
    public void onRender(RenderGameOverlayEvent.Post post) {
        if (post.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        xpzm xpzm2 = xpzm._E();
        LinkedList<bqdo> linkedList = ClientProxy.notifications;
        if (linkedList.isEmpty()) {
            return;
        }
        int n = linkedList.size();
        List list = linkedList.subList(Math.max(0, n - 3), n);
        boolean bl = PdaClient.invertedHud.enabled;
        Point point = bl ? new Point(xpzm2._n - 60, 200) : new Point(20, 200);
        int n2 = 0;
        for (int i = 0; i < list.size(); ++i) {
            bqdo bqdo2 = (bqdo)list.get(i);
            n2 += this.drawNotification(bqdo2, point.add(0, n2), i == list.size() - 1, bl);
        }
    }

    private int drawNotification(bqdo bqdo2, Point point, boolean bl, boolean bl2) {
        int n;
        int n2 = 0;
        long l = System.currentTimeMillis() - bqdo2._a;
        iuww iuww2 = ycdg._a().get(bqdo2._a());
        iuww.kjui kjui2 = iuww2.getViewType(bqdo2);
        if (l > SHOW_TIME + FADE_OUT) {
            return 0;
        }
        String string = iuww2.getTitle(bqdo2);
        String string2 = iuww2.getInfoText(bqdo2);
        float f = alpha._a(l);
        float f2 = move._a(l);
        int n3 = n = (double)f > 0.2 ? (int)(f * 255.0f) : 0;
        if (n > 1) {
            n <<= 24;
            int n4 = (int)((float)point.x + (float)(bl2 ? 200 : -200) * (1.0f - f2));
            int n5 = n4 + (bl2 ? -20 : 60);
            Point point2 = iuww2.getIcon(bqdo2);
            GL11.glEnable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
            iconRenderer.bindTexture(NOTIFICATIONS);
            iconRenderer.drawTexturedModalRect(n4, point.y + n2, point2.x, point2.y, 48, 48);
            n2 = (int)((float)n2 + this.drawNotificationText(kjui2, string, string2, n5, point.y + n2, n, bl, bl2));
            n2 += 10;
        }
        return n2;
    }

    private float drawNotificationText(iuww.kjui kjui2, String string, String string2, float f, float f2, int n, boolean bl, boolean bl2) {
        String string3;
        float f3 = 0.0f;
        int n2 = 0xFFFF00 + n;
        int n3 = -1 + n;
        float f4 = f / 2.0f - (float)(bl2 ? ExternalFont.tahoma14.getStringWidth(string) : 0);
        ExternalFont.tahoma14.drawString(string, (double)f4, (double)((f2 + f3) / 2.0f), n2, true);
        float f5 = f / 2.0f - (float)(bl2 ? ExternalFont.tahoma12.getStringWidth(string2) : 0);
        ExternalFont.tahoma12.drawString(string2, (double)f5, (double)((f2 + (f3 += 25.0f)) / 2.0f), n3, true);
        f3 += 20.0f;
        if (bl && (string3 = this.getTypeInteraction(kjui2)) != null) {
            float f6 = f / 2.0f - (float)(bl2 ? ExternalFont.tahoma9.getStringWidth(string3) : 0);
            ExternalFont.tahoma9.drawString(string3, (double)f6, (double)((f2 + f3) / 2.0f), n3, true);
            f3 += 20.0f;
        }
        return f3;
    }

    private String getTypeInteraction(iuww.kjui kjui2) {
        if (kjui2 == iuww.kjui._a) {
            return String.format("\u041d\u0430\u0436\u043c\u0438\u0442\u0435 [%s] \u0434\u043b\u044f \u0432\u0437\u0430\u0438\u043c\u043e\u0434\u0435\u0439\u0441\u0442\u0432\u0438\u044f", GameSettings.func_74298_c(ClientProxy.answerBinding._d));
        }
        if (kjui2 == iuww.kjui._b) {
            return String.format("\u041d\u0430\u0436\u043c\u0438\u0442\u0435 [%s] \u0434\u043b\u044f \u043f\u0440\u043e\u0441\u043c\u043e\u0442\u0440\u0430", GameSettings.func_74298_c(ClientProxy.viewNotification._d));
        }
        return null;
    }
}

