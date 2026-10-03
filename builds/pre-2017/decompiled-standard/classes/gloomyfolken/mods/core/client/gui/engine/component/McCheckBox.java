/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.action.GuiActionCheckboxToggle;
import gloomyfolken.mods.core.client.gui.engine.component.McToggleButton;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentCheckboxStyle;

public class McCheckBox
extends McToggleButton {
    public McCheckBox(IAdvancedGui iAdvancedGui, String string, int n, int n2, ComponentCheckboxStyle componentCheckboxStyle) {
        this(iAdvancedGui, string, new Point(n, n2), componentCheckboxStyle);
    }

    public McCheckBox(IAdvancedGui iAdvancedGui, String string, Point point, ComponentCheckboxStyle componentCheckboxStyle) {
        super(iAdvancedGui, string, point, componentCheckboxStyle);
    }

    @Override
    public void setActive(boolean bl) {
        super.setActive(bl);
        new GuiActionCheckboxToggle(this).process();
    }
}

