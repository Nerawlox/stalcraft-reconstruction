/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.IActionHandler;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.Property;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionButtonClick;
import gloomyfolken.mods.core.client.gui.engine.component.McAbstractButton;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;

public class McButton
extends McAbstractButton {
    @Property
    public String text;
    @Property
    public int textColor = this.getStyle().getFontColor().getRGB();
    public int mouseOverTextColor = -1;

    public McButton(IAdvancedGui iAdvancedGui, int n, int n2, String string) {
        this(iAdvancedGui, new Point(n, n2), (ComponentButtonStyle)ComponentStyle.VANILLA.getComponentStyle(McButton.class), string);
    }

    public McButton(IAdvancedGui iAdvancedGui, int n, int n2, ComponentButtonStyle componentButtonStyle, String string) {
        this(iAdvancedGui, new Point(n, n2), componentButtonStyle, string);
    }

    public McButton(IAdvancedGui iAdvancedGui, Point point, ComponentButtonStyle componentButtonStyle, String string) {
        super(iAdvancedGui, point, componentButtonStyle);
        this.text = string;
        this.textColor = this.getStyle().getFontColor().getRGB();
    }

    @Override
    public void drawComponent(Point point, float f) {
        super.drawComponent(point, f);
        if (this.text != null) {
            this.renderer.drawCenteredString(this.text, this.getLocation().x + this.getSize().width / 2, this.getLocation().y + this.getSize().height / 2, this.getEnabled() && this.mouseOverTextColor != -1 && this.isMouseInBounds(point) ? this.mouseOverTextColor : this.textColor);
        }
    }

    @Override
    protected void actionPerformed() {
        McButton.playClickSound();
        new GuiActionButtonClick(this).process();
    }

    @Override
    public ComponentButtonStyle getStyle() {
        return super.getStyle();
    }

    public int getMouseOverTextColor() {
        return this.mouseOverTextColor;
    }

    public void setMouseOverTextColor(int n) {
        this.mouseOverTextColor = n;
    }

    public McButton onClick(IActionHandler<GuiActionButtonClick> iActionHandler) {
        this.parent.getActionManager().registerActionHandler(this, GuiActionButtonClick.class, iActionHandler);
        return this;
    }
}

