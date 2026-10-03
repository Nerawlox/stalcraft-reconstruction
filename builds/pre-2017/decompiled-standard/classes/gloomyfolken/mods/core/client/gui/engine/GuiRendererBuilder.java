/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.font.IFontRenderer;
import gloomyfolken.mods.core.client.gui.font.VanillaFontRenderer;
import net.minecraft.client.xpzm;

public class GuiRendererBuilder {
    private int texWidth = 512;
    private int texHeight = 512;
    private float scale = 0.5f;
    private float zLevel = 0.0f;
    private IFontRenderer fontRenderer;

    public GuiRendererBuilder() {
        this.fontRenderer = new VanillaFontRenderer(xpzm._E()._z);
    }

    public GuiRendererBuilder(GuiRenderer guiRenderer) {
        this.fontRenderer = new VanillaFontRenderer(xpzm._E()._z);
        this.texWidth = guiRenderer.texWidth;
        this.texHeight = guiRenderer.texHeight;
        this.scale = guiRenderer.scale;
        this.zLevel = guiRenderer.zLevel;
        this.fontRenderer = guiRenderer.fr;
    }

    public GuiRendererBuilder setTextureSize(int n, int n2) {
        this.texWidth = n;
        this.texHeight = n2;
        return this;
    }

    public GuiRendererBuilder setScale(float f) {
        this.scale = f;
        return this;
    }

    public GuiRendererBuilder setZLevel(float f) {
        this.zLevel = f;
        return this;
    }

    public GuiRendererBuilder setFontRenderer(IFontRenderer iFontRenderer) {
        this.fontRenderer = iFontRenderer;
        return this;
    }

    public GuiRenderer create() {
        return new GuiRenderer(this.texWidth, this.texHeight, this.scale, this.zLevel, this.fontRenderer);
    }
}

