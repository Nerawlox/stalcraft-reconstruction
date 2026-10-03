/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McLabel;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioElement;
import gloomyfolken.mods.core.client.gui.engine.component.McRadioGroup;

public class McRadioLabel
extends McLabel
implements McRadioElement {
    protected boolean selected;
    public final McRadioGroup pane;
    public int selectedColor = 0x808080;
    public int mouseOverColor = 0xE0E0E0;

    public McRadioLabel(McRadioGroup mcRadioGroup, String string, Point point) {
        super(mcRadioGroup.parent, string, point);
        this.pane = mcRadioGroup;
        this.noMouseInteraction = false;
    }

    public McRadioLabel(McRadioGroup mcRadioGroup, String string, Point point, int n) {
        super(mcRadioGroup.parent, string, point, n);
        this.pane = mcRadioGroup;
        this.noMouseInteraction = false;
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.isSelected()) {
            this.drawLabel(this.selectedColor);
        } else if (this.isMouseOver()) {
            this.drawLabel(this.mouseOverColor);
        } else {
            this.drawLabel(this.color);
        }
    }

    @Override
    public void mouseClicked(Point point, int n) {
        if (n == 0 && this.isMouseOver()) {
            this.pane.setActiveButton(this);
            McRadioLabel.playClickSound();
        }
    }

    @Override
    public boolean isSelected() {
        return this.selected;
    }

    @Override
    public void setSelected(boolean bl) {
        this.selected = bl;
    }
}

