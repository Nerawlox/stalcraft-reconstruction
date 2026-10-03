/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.style;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;

public class ComponentSliderBarStyle
extends ComponentButtonStyle {
    @SerializedName(value="horizontalBar")
    protected ComponentButtonStyle horizontalBarStyle = new ComponentButtonStyle();
    @SerializedName(value="verticalBar")
    protected ComponentButtonStyle verticalBarStyle = new ComponentButtonStyle();

    public ComponentSliderBarStyle() {
        this.horizontalBarStyle.borderThickness = 2;
        this.verticalBarStyle.borderThickness = 2;
    }

    public ComponentButtonStyle getStyleForDirection(McScrollBar.ScrollBarType scrollBarType) {
        switch (scrollBarType) {
            case VERTICAL: {
                return this.getVerticalBarStyle();
            }
            case HORIZONTAL: {
                return this.getHorizontalBarStyle();
            }
        }
        return this.verticalBarStyle;
    }

    public ComponentButtonStyle getHorizontalBarStyle() {
        return this.horizontalBarStyle;
    }

    public ComponentButtonStyle getVerticalBarStyle() {
        return this.verticalBarStyle;
    }
}

