/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.Property;
import gloomyfolken.mods.core.client.gui.engine.component.ButtonState;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;

public abstract class McAbstractButton
extends GuiComponent {
    public boolean isPressed = false;
    @Property
    protected boolean active;

    public McAbstractButton(IAdvancedGui iAdvancedGui, Point point, ComponentButtonStyle componentButtonStyle) {
        super(iAdvancedGui, point, componentButtonStyle.getSize());
        this.setStyle(componentButtonStyle);
    }

    public ButtonState getButtonState() {
        if (!this.getEnabled()) {
            return ButtonState.DISABLED;
        }
        if (this.active) {
            return ButtonState.ACTIVE;
        }
        if (this.isMouseOver()) {
            return ButtonState.MOUSE_OVER;
        }
        return ButtonState.DEFAULT;
    }

    @Override
    public void setStyle(ComponentStyle componentStyle) {
        if (componentStyle instanceof ComponentButtonStyle) {
            super.setStyle(componentStyle);
        }
    }

    @Override
    public ComponentButtonStyle getStyle() {
        return (ComponentButtonStyle)super.getStyle();
    }

    @Override
    public void setSize(Dimension dimension) {
        super.setSize(dimension);
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.getStyle().isVisibleBackground()) {
            this.renderer.drawButton(this.getLocation(), this.getSize(), this.getStyle(), this.getButtonState());
        }
    }

    @Override
    public void mouseClicked(Point point, int n) {
        if (this.getEnabled() && n == 0 && this.isMouseOver()) {
            this.isPressed = true;
            this.actionPerformed();
        }
    }

    @Override
    public void mouseUp(Point point, int n) {
        if (this.isPressed && n == 0) {
            this.isPressed = false;
        }
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean bl) {
        this.active = bl;
    }

    protected abstract void actionPerformed();
}

