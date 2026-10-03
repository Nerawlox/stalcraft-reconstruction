/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McAbstractButton;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;

public class McToggleButton
extends McAbstractButton {
    public String text;

    public McToggleButton(IAdvancedGui iAdvancedGui, String string, Point point, ComponentButtonStyle componentButtonStyle) {
        super(iAdvancedGui, point, componentButtonStyle);
        this.text = string;
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.renderer.drawButton(this.getLocation(), this.getSize(), this.getStyle(), this.getButtonState());
        if (this.text != null) {
            this.renderer.drawString(this.text, this.getLocation().x + this.getStyle().getSize().width + 8, this.getLocation().y + 8 - this.renderer.getFontHeight() / 2, this.getStyle().getFontColor().getRGB());
        }
    }

    @Override
    protected void actionPerformed() {
        this.setActive(!this.active);
        McToggleButton.playClickSound();
    }

    @Override
    public void setActive(boolean bl) {
        this.active = bl;
    }
}

