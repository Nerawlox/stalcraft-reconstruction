/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.Property;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioElement;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioGroup;
import gloomyfolken.mods.core.client.gui.engine.component.McToggleButton;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;

public class McRadioButton
extends McToggleButton
implements McRadioElement {
    @Property
    public final McRadioGroup pane;

    public McRadioButton(McRadioGroup mcRadioGroup, String string, int n, int n2, ComponentCheckboxStyle componentCheckboxStyle) {
        this(mcRadioGroup, string, new Point(n, n2), componentCheckboxStyle);
    }

    public McRadioButton(McRadioGroup mcRadioGroup, String string, Point point, ComponentCheckboxStyle componentCheckboxStyle) {
        super(mcRadioGroup.parent, string, point, componentCheckboxStyle);
        this.pane = mcRadioGroup;
    }

    @Override
    public void mouseClicked(Point point, int n) {
        if (n == 0 && this.isMouseOver()) {
            this.pane.setActiveButton(this);
            McRadioButton.playClickSound();
        }
    }

    @Override
    public boolean isSelected() {
        return this.active;
    }

    @Override
    public void setSelected(boolean bl) {
        this.active = bl;
    }
}

