/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.GuiRenderer;
import gloomyfolken.mods.core.client.gui.engine.GuiRendererBuilder;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.Property;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import gloomyfolken.mods.core.client.gui.font.IFontRenderer;
import java.util.function.Supplier;

public class McLabel
extends GuiComponent {
    @Property
    protected String text;
    protected String textToRender;
    @Property
    protected int maxWidth;
    @Property
    public int color = 0xFFFFFF;
    @Property
    public boolean noMouseInteraction = true;
    private Supplier<String> textSupplier;

    public McLabel(IAdvancedGui iAdvancedGui, String string, int n, int n2) {
        this(iAdvancedGui, string, new Point(n, n2));
    }

    public McLabel(IAdvancedGui iAdvancedGui, String string, Point point) {
        this(iAdvancedGui, string, point, 0xFFFFFF);
    }

    public McLabel(IAdvancedGui iAdvancedGui, String string, Point point, int n) {
        super(iAdvancedGui, point, Dimension.zeroDimension);
        this.setText(string);
        this.color = n;
    }

    public McLabel(IAdvancedGui iAdvancedGui, Supplier<String> supplier, Point point, int n) {
        super(iAdvancedGui, point, Dimension.zeroDimension);
        this.textSupplier = supplier;
        this.color = n;
        this.setText(this.textSupplier.get());
    }

    public McLabel setCentered() {
        this.setLocation(this.getLocation().add(-this.renderer.getStringWidth(this.text) / 2, 0));
        return this;
    }

    public McLabel setMaxWidth(int n) {
        this.maxWidth = n;
        this.updateTextToRender();
        return this;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String string) {
        this.text = string;
        this.updateSize();
        this.updateTextToRender();
    }

    protected void updateTextToRender() {
        this.textToRender = this.text;
        if (this.maxWidth != 0 && this.renderer.getStringWidth(this.text) > this.maxWidth) {
            this.textToRender = this.renderer.trimToWidth(this.text, this.maxWidth, true);
        }
    }

    @Override
    public boolean isMouseInBounds(Point point) {
        return this.noMouseInteraction ? false : super.isMouseInBounds(point);
    }

    public McLabel setFontRenderer(IFontRenderer iFontRenderer) {
        this.renderer = new GuiRendererBuilder(this.renderer).setFontRenderer(iFontRenderer).create();
        this.updateSize();
        return this;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.textSupplier != null) {
            this.setText(this.textSupplier.get());
        }
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.drawLabel(this.color);
    }

    public void drawLabel(int n) {
        this.renderer.drawString(this.textToRender, this.getLocation(), n);
    }

    @Override
    public GuiComponent setRenderer(GuiRenderer guiRenderer) {
        super.setRenderer(guiRenderer);
        this.updateSize();
        return this;
    }

    protected void updateSize() {
        int n;
        int n2 = n = this.text != null ? this.renderer.getStringWidth(this.text) : 0;
        if (this.maxWidth != 0) {
            n = Math.min(n, this.maxWidth);
        }
        this.setSize(new Dimension(n, this.renderer.getFontHeight()));
    }

    @Override
    public void setStyle(ComponentStyle componentStyle) {
        super.setStyle(componentStyle);
        this.color = componentStyle.getFontColor().getRGB();
    }
}

