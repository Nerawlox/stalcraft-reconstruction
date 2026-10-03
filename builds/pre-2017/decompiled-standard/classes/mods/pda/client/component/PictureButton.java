/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class PictureButton
extends McButton {
    protected ResourceLocation picture;
    protected Point uv;
    protected int glColorEnabled = -1;
    protected int glColorDisabled = -1;
    protected int glCOlorMouseOver = 0;
    protected Dimension textureSize;

    public PictureButton(IAdvancedGui iAdvancedGui, ResourceLocation resourceLocation, Point point, Point point2, Dimension dimension) {
        super(iAdvancedGui, point.x, point.y, "");
        this.setSize(dimension);
        this.picture = resourceLocation;
        this.uv = point2;
        this.active = true;
        this.textureSize = dimension;
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.getStyle().isVisibleBackground()) {
            this.renderer.bindTexture(this.picture);
            boolean bl = this.isMouseInBounds(point);
            int n = bl && this.glCOlorMouseOver != 0 ? this.glCOlorMouseOver : (this.active ? this.glColorEnabled : this.glColorDisabled);
            float f2 = (float)(n >> 16 & 0xFF) / 255.0f;
            float f3 = (float)(n >> 8 & 0xFF) / 255.0f;
            float f4 = (float)(n & 0xFF) / 255.0f;
            float f5 = (float)(n >> 24 & 0xFF) / 255.0f;
            GL11.glColor4f(f2, f3, f4, f5);
            this.renderer.drawTexturedRect(this.getLocation(), this.uv, this.uv.add(this.textureSize.width, this.textureSize.height), this.getSize());
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }

    @Override
    protected void actionPerformed() {
        super.actionPerformed();
        this.active = !this.active;
    }

    public int getGlColorEnabled() {
        return this.glColorEnabled;
    }

    public PictureButton setGlColorEnabled(int n) {
        this.glColorEnabled = n;
        return this;
    }

    public int getGlColorMouseOver() {
        return this.glCOlorMouseOver;
    }

    public PictureButton setGlColorMouseOver(int n) {
        this.glCOlorMouseOver = n;
        return this;
    }

    public int getGlColorDisabled() {
        return this.glColorDisabled;
    }

    public PictureButton setGlColorDisabled(int n) {
        this.glColorDisabled = n;
        return this;
    }

    public Dimension getTextureSize() {
        return this.textureSize;
    }

    public PictureButton setTextureSize(Dimension dimension) {
        this.textureSize = dimension;
        return this;
    }
}

