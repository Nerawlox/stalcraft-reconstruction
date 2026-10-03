/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;

public class PdaTabButton
extends McButton {
    private static final Dimension ICON_SIZE = new Dimension(9, 11);
    public boolean selected;

    public PdaTabButton(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, ComponentButtonStyle componentButtonStyle, String string) {
        super(iAdvancedGui, point, componentButtonStyle, string);
        this.setSize(dimension);
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.getStyle().isVisibleBackground()) {
            this.renderer.drawButton(this.getLocation(), this.getSize(), this.getStyle(), this.getButtonState());
            this.renderer.drawTexturedModalRect(this.getLocation().add(5, this.getSize().height / 2 - 5), this.getIconUV(), ICON_SIZE);
        }
        if (this.text != null) {
            this.renderer.drawString(this.text, this.getLocation().x + 17, this.getLocation().y + this.getSize().height / 2 - this.renderer.getFontHeight() / 2 - 1, this.selected ? 0x109101 : 0x939393);
        }
    }

    protected Point getIconUV() {
        if (this.selected) {
            return new Point(84, 821);
        }
        return new Point(64, 821);
    }
}

