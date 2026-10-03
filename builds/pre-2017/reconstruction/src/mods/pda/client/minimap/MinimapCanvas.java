/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.minimap;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.Point;
import mods.pda.PdaMod;
import mods.pda.client.minimap.MapCanvas;
import mods.pda.client.minimap.MinimapHud;
import mods.pda.client.screens.GuiPda;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Vector2f;

public class MinimapCanvas
extends MapCanvas {
    public final boolean allowInterference;

    public MinimapCanvas(GuiRenderer guiRenderer, Point point, Dimension dimension, boolean bl) {
        super("minimap", guiRenderer, point, dimension);
        this.allowInterference = bl;
        this.boundsRestriction = false;
    }

    @Override
    protected void drawMap(int n, int n2, float f, float f2, Point point, float f3, float f4, int n3) {
        float f5 = this.renderer.scale;
        GL11.glPushMatrix();
        GL11.glAlphaFunc(515, 0.1f);
        ejef._c();
        ejef.kjui._c._a();
        GL11.glDepthMask(false);
        Minecraft._E()._R()._a(MinimapHud.MINIMAP_BG);
        qozx._a((float)this.location.x * f5, (float)this.location.y * f5, (float)this.size.width * f5, (float)this.size.height * f5, 768.0, 0.0, 1023.0, 255.0, 1024.0, 256.0);
        ejef.kjui._c._c();
        GL11.glAlphaFunc(516, 0.0f);
        GL11.glColorMask(true, true, true, true);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        super.drawMap(n, n2, f, f2, point, f3, f4, n3);
        if (PdaMod.isInterfering()) {
            GuiPda.drawInterferenceOverlay(this.renderer.scale, this.getLocation().x, this.getLocation().y, this.getSize().width, this.getSize().height, 0.9f, true);
        }
        ejef.kjui._c._d();
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glPopMatrix();
    }

    @Override
    public Vector2f worldCoordsToScreenSticky(Vector2f vector2f) {
        Vector2f vector2f2 = this.worldCoordsToScreen(vector2f);
        float f = this.size.width / 4 - 20;
        double d = Math.sqrt(Math.pow(vector2f2.x, 2.0) + Math.pow(vector2f2.y, 2.0));
        if ((double)f < d) {
            double d2 = Math.atan2(vector2f2.y, vector2f2.x);
            double d3 = Math.cos(d2) * (double)f;
            double d4 = Math.sin(d2) * (double)f;
            return new Vector2f((float)d3, (float)d4);
        }
        return vector2f2;
    }

    @Override
    public boolean worldCoordsVisible(Vector2f vector2f) {
        Vector2f vector2f2 = this.worldCoordsToScreen(vector2f);
        float f = this.size.width / 4 - 20;
        double d = Math.sqrt(Math.pow(vector2f2.x, 2.0) + Math.pow(vector2f2.y, 2.0));
        return (double)f > d;
    }
}

