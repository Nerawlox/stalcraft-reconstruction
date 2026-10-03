/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class McImage
extends GuiComponent {
    private Runnable textureBinder;
    public Point uv;
    public boolean blending;
    public boolean noMouseInteraction;
    public int color = -1;

    public McImage(IAdvancedGui iAdvancedGui, Point point, Point point2, Dimension dimension, ResourceLocation resourceLocation) {
        this(iAdvancedGui, point, point2, dimension, () -> Minecraft._E()._h._a(resourceLocation));
    }

    public McImage(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4, int n5, int n6, ResourceLocation resourceLocation) {
        this(iAdvancedGui, new Point(n, n2), new Point(n3, n4), new Dimension(n5, n6), resourceLocation);
    }

    public McImage(IAdvancedGui iAdvancedGui, Point point, Point point2, Dimension dimension, temw temw2) {
        this(iAdvancedGui, point, point2, dimension, temw2::_g);
    }

    public McImage(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4, int n5, int n6, temw temw2) {
        this(iAdvancedGui, new Point(n, n2), new Point(n3, n4), new Dimension(n5, n6), temw2);
    }

    public McImage(IAdvancedGui iAdvancedGui, Point point, Point point2, Dimension dimension, Runnable runnable) {
        super(iAdvancedGui, point, dimension);
        this.textureBinder = runnable;
        this.uv = point2;
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.textureBinder.run();
        if (this.blending) {
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
        }
        GL11.glColor4f((float)(this.color >> 16 & 0xFF) / 255.0f, (float)(this.color >> 8 & 0xFF) / 255.0f, (float)(this.color & 0xFF) / 255.0f, (float)(this.color >> 24 & 0xFF) / 255.0f);
        this.renderer.drawTexturedModalRect(this.getLocation(), this.uv, this.getSize());
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.blending) {
            GL11.glDisable(3042);
        }
    }

    @Override
    public boolean isMouseInBounds(Point point) {
        return this.noMouseInteraction ? false : super.isMouseInBounds(point);
    }
}

