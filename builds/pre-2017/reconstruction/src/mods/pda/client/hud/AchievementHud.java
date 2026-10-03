/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.hud;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.font.ExternalFont;
import java.util.concurrent.TimeUnit;
import mods.pda.client.tab.PdaAchievements;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.ForgeSubscribe;
import org.lwjgl.opengl.GL11;

public class AchievementHud {
    public static final AchievementHud instance = new AchievementHud();
    private final long DISPLAY_TIME = TimeUnit.SECONDS.toMillis(3L);
    private final long FADE_OUT_TIME = TimeUnit.SECONDS.toMillis(2L);
    private final Dimension NOTIFICATION = new Dimension(355, 75);
    private static qlzo move = new owvh()._a(new ivew(zftb._g, 3000L, false))._a(new ivew(zftb._a, 2000L, true))._a();
    private static qlzo alpha = new owvh()._a(new ivew(zftb._a, 3000L, true))._a(new ivew(zftb._e, 2000L, true))._a();
    private GuiRenderer renderer = new GuiRendererBuilder().setTextureSize(1024, 1024).create();
    private turb completed;

    @ForgeSubscribe
    public void onScreenRender(RenderGameOverlayEvent.Post post) {
        if (post.type != RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        Minecraft minecraft = Minecraft._E();
        long l = System.currentTimeMillis();
        long l2 = l - move._c();
        if (this.completed == null || l2 > this.DISPLAY_TIME + this.FADE_OUT_TIME) {
            return;
        }
        float f = alpha._b();
        float f2 = move._b();
        GL11.glTranslated(0.0, 0.0, 1.0);
        this.drawNotification(minecraft._n, this.completed._c(), f, f2, (int)(f * 255.0f));
        GL11.glTranslated(0.0, 0.0, -1.0);
    }

    private void drawNotification(int n, String string, float f, float f2, int n2) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, f);
        GL11.glEnable(3042);
        Dimension dimension = new Dimension((int)((float)this.NOTIFICATION.width * f2), this.NOTIFICATION.height);
        Point point = new Point(n - dimension.width - 10, 10);
        this.renderer.bindTexture(iedw._a);
        this.renderer.drawTiledRect(point, new Point(128, 959), dimension, new Dimension(64, 64), 20);
        this.renderer.bindTexture(PdaAchievements.ACHIEVEMENTS);
        this.renderer.drawTexturedModalRect(point.add(15, 5), new Point(713, 544), new Dimension(64, 64));
        float f3 = (float)n - (float)this.NOTIFICATION.width * f2 + 16.0f + (float)(this.NOTIFICATION.width / 2);
        int n3 = -1 + (n2 << 24);
        if (n2 > 4) {
            ExternalFont.tahoma14.drawCenteredString("\u041f\u043e\u043b\u0443\u0447\u0435\u043d\u043e \u0434\u043e\u0441\u0442\u0438\u0436\u0435\u043d\u0438\u0435", f3 / 2.0f, 10.0, n3);
            ExternalFont.tahoma14.drawCenteredString(this.renderer.trimToWidth(this.completed._c(), this.NOTIFICATION.width / 2, true), f3 / 2.0f, 25.0, n3);
        }
        GL11.glDisable(3042);
    }

    public void displayCompletion(turb turb2) {
        this.completed = turb2;
        move._a();
        alpha._a();
    }
}

