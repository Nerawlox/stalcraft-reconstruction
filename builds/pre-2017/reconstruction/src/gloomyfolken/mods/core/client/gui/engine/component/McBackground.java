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

public class McBackground
extends GuiComponent {
    private ResourceLocation texture;
    private boolean hasBackground;
    private int color;
    private Point uv = Point.zeroPoint;
    private Dimension textureSize;
    public int borderX = 8;
    public int borderY = 8;

    public McBackground(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        super(iAdvancedGui, point, dimension);
        this.textureSize = dimension;
    }

    public McBackground setTexture(ResourceLocation resourceLocation) {
        this.texture = resourceLocation;
        return this;
    }

    public McBackground setHasBackground(boolean bl) {
        this.hasBackground = bl;
        return this;
    }

    public McBackground setBackgroundColor(int n) {
        this.color = n;
        return this;
    }

    public McBackground setBackgroundSize(Dimension dimension) {
        super.setSize(dimension);
        return this;
    }

    public McBackground setTextureCoords(Point point) {
        this.uv = point;
        return this;
    }

    public McBackground setTextureSize(Dimension dimension) {
        this.textureSize = dimension;
        return this;
    }

    public McBackground setResizeBorder(int n) {
        return this.setResizeBorder(n, n);
    }

    public McBackground setResizeBorder(int n, int n2) {
        this.borderX = n;
        this.borderY = n2;
        return this;
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.hasBackground) {
            this.parent.getGui().drawWorldBackground(this.color);
        }
        if (this.texture != null) {
            Minecraft._E()._h._a(this.texture);
            if (this.textureSize.equals(this.getSize())) {
                this.renderer.drawTexturedModalRect(this.getLocation(), this.uv, this.getSize());
            } else {
                this.renderer.drawTiledRect(this.getLocation(), this.uv, this.getSize(), this.textureSize, this.borderX, this.borderY);
            }
        }
    }
}

