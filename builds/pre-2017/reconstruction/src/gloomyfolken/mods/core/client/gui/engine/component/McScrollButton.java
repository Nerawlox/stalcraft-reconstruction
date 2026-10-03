/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.ButtonState;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentScrollButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;

public class McScrollButton
extends GuiComponent {
    private final McScrollBar scrollBar;
    private final ScrollButtonDirection direction;
    private int ticksUsed = -1;

    public McScrollButton(IAdvancedGui iAdvancedGui, McScrollBar mcScrollBar, ScrollButtonDirection scrollButtonDirection, int n, int n2, ComponentScrollButtonStyle componentScrollButtonStyle) {
        this(iAdvancedGui, mcScrollBar, scrollButtonDirection, new Point(n, n2), componentScrollButtonStyle);
    }

    public McScrollButton(IAdvancedGui iAdvancedGui, McScrollBar mcScrollBar, ScrollButtonDirection scrollButtonDirection, Point point, ComponentScrollButtonStyle componentScrollButtonStyle) {
        this(iAdvancedGui, mcScrollBar, scrollButtonDirection, point, componentScrollButtonStyle.getStyleForDirection(scrollButtonDirection));
    }

    public McScrollButton(IAdvancedGui iAdvancedGui, McScrollBar mcScrollBar, ScrollButtonDirection scrollButtonDirection, int n, int n2, ComponentButtonStyle componentButtonStyle) {
        this(iAdvancedGui, mcScrollBar, scrollButtonDirection, new Point(n, n2), componentButtonStyle);
    }

    public McScrollButton(IAdvancedGui iAdvancedGui, McScrollBar mcScrollBar, ScrollButtonDirection scrollButtonDirection, Point point, ComponentButtonStyle componentButtonStyle) {
        super(iAdvancedGui, point, componentButtonStyle.getSize());
        this.scrollBar = mcScrollBar;
        this.direction = scrollButtonDirection;
        this.setStyle(componentButtonStyle);
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
    public void drawComponent(Point point, float f) {
        this.renderer.drawButton(this.getLocation(), this.getSize(), this.getStyle(), this.getButtonState());
    }

    public ButtonState getButtonState() {
        if (this.scrollBar.pos == 0.0f && this.direction == ScrollButtonDirection.TOP) {
            return ButtonState.DISABLED;
        }
        if (this.scrollBar.pos == 1.0f && this.direction == ScrollButtonDirection.BOTTOM) {
            return ButtonState.DISABLED;
        }
        if (this.ticksUsed >= 0) {
            return ButtonState.ACTIVE;
        }
        if (this.isMouseOver()) {
            return ButtonState.MOUSE_OVER;
        }
        return ButtonState.DEFAULT;
    }

    @Override
    public void mouseClicked(Point point, int n) {
        if (n == 0 && this.isMouseOver()) {
            this.scroll();
            this.ticksUsed = 0;
        }
    }

    @Override
    public void mouseUp(Point point, int n) {
        if (n == 0) {
            this.ticksUsed = -1;
        }
    }

    @Override
    public void tick() {
        if (this.ticksUsed >= 0) {
            ++this.ticksUsed;
        }
        if (this.ticksUsed > 5) {
            this.scroll();
        }
    }

    private void scroll() {
        this.scrollBar.scroll(this.direction == ScrollButtonDirection.TOP || this.direction == ScrollButtonDirection.LEFT ? -1 : 1);
    }

    public static enum ScrollButtonDirection {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT;

    }
}

