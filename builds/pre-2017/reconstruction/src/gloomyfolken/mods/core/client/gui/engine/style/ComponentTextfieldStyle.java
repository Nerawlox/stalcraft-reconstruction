/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.style;

import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;
import java.awt.Color;

public class ComponentTextfieldStyle
extends ComponentStyle {
    protected Color enabledTextColor = new Color(0xE0E0E0);
    protected Color disabledTextColor = new Color(0x707070);

    public Color getEnabledTextColor() {
        return this.enabledTextColor;
    }

    public void setEnabledTextColor(Color color) {
        this.enabledTextColor = color;
    }

    public Color getDisabledTextColor() {
        return this.disabledTextColor;
    }

    public void setDisabledTextColor(Color color) {
        this.disabledTextColor = color;
    }
}

