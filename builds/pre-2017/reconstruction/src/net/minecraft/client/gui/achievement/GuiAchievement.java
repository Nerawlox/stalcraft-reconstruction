/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.achievement;

import mods.pda.AchievementHooks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.stats.Achievement;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiAchievement
extends Gui {
    public static final ResourceLocation _a = new ResourceLocation("textures/gui/achievement/achievement_background.png");
    public Minecraft _b;
    public int _c;
    public int _d;
    public String _e;
    public String _f;
    public Achievement _g;
    public long _h;
    public RenderItem _i;
    public boolean _j;

    public GuiAchievement(Minecraft minecraft) {
        this._b = minecraft;
        this._i = new RenderItem();
    }

    public void _a(Achievement achievement) {
        this._e = wpcz._a("achievement.get");
        this._f = wpcz._a(achievement.getName());
        this._h = Minecraft._M();
        this._g = achievement;
        this._j = false;
    }

    public void _b(Achievement achievement) {
        this._e = wpcz._a(achievement.getName());
        this._f = achievement.getDescription();
        this._h = Minecraft._M() - 2500L;
        this._g = achievement;
        this._j = true;
    }

    public void _a() {
        GL11.glViewport(0, 0, this._b._n, this._b._o);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        this._c = this._b._n;
        this._d = this._b._o;
        htou htou2 = new htou(this._b._M, this._b._n, this._b._o);
        this._c = htou2._a();
        this._d = htou2._b();
        GL11.glClear(256);
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, this._c, this._d, 0.0, 1000.0, 3000.0);
        GL11.glMatrixMode(5888);
        GL11.glLoadIdentity();
        GL11.glTranslatef(0.0f, 0.0f, -2000.0f);
    }

    public void _b() {
        AchievementHooks.updateAchievementWindow(this);
    }
}

