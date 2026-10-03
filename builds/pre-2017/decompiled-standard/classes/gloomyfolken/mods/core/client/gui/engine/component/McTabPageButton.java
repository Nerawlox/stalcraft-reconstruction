/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.Property;
import gloomyfolken.mods.core.client.gui.engine.component.ButtonState;
import gloomyfolken.mods.core.client.gui.engine.component.McTabButton;
import gloomyfolken.mods.core.client.gui.engine.component.McTabPane;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;

public class McTabPageButton
extends McTabButton {
    @Property
    private int direction;
    @Property
    private boolean enabled = true;

    public McTabPageButton(McTabPane mcTabPane, ComponentButtonStyle componentButtonStyle, int n) {
        super(mcTabPane, n > 0 ? "->" : "<-", componentButtonStyle);
        this.direction = n;
    }

    @Override
    public void setEnabled(boolean bl) {
        this.enabled = bl;
        this.textColor = bl ? 0xFFFFFF : 0xAAAAAA;
    }

    @Override
    public ButtonState getButtonState() {
        if (!this.enabled) {
            return ButtonState.DISABLED;
        }
        return super.getButtonState();
    }

    @Override
    public void mouseClicked(Point point, int n) {
        if (this.enabled && n == 0 && this.isMouseOver()) {
            if (this.direction > 0) {
                this.pane.nextPage();
            } else {
                this.pane.prevPage();
            }
            McTabPageButton.playClickSound();
        }
    }
}

