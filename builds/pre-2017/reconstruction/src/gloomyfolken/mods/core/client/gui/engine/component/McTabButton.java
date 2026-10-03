/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.Property;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionTabSwitch;
import gloomyfolken.mods.core.client.gui.engine.component.McAbstractButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTabPane;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;

public class McTabButton
extends McAbstractButton {
    public final McTabPane pane;
    @Property
    public int textColor = 0xFFFFFF;
    @Property
    public String text;
    @Property
    public int textOffsetX;
    @Property
    public int textOffsetY;
    @Property
    public boolean drawTabBackground = true;

    public McTabButton(McTabPane mcTabPane, String string, ComponentButtonStyle componentButtonStyle) {
        this(mcTabPane, string, componentButtonStyle, Point.zeroPoint);
    }

    public McTabButton(McTabPane mcTabPane, String string, ComponentButtonStyle componentButtonStyle, Point point) {
        super(mcTabPane.parent, point, componentButtonStyle);
        this.text = string;
        this.pane = mcTabPane;
    }

    public void textToWidth(int n) {
        this.setWidth(this.renderer.getStringWidth(this.text) + n * 2);
    }

    public void setWidth(int n) {
        this.setSize(new Dimension(n, this.getStyle().getSize().height));
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.drawTabBackground) {
            super.drawComponent(point, f);
        }
        this.renderer.drawCenteredString(this.text, this.getLocation().x + this.getSize().width / 2, this.getLocation().y + this.getSize().height / 2, this.textColor);
    }

    @Override
    protected void actionPerformed() {
        this.pane.setActiveTab(this);
        new GuiActionTabSwitch(this.pane).process();
        McTabButton.playClickSound();
    }

    @Override
    public void setActive(boolean bl) {
        this.active = bl;
    }
}

