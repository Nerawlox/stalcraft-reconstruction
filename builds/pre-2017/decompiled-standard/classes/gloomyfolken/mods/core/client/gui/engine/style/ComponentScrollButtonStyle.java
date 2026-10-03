/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.style;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentButtonStyle;

public class ComponentScrollButtonStyle
extends ComponentButtonStyle {
    @SerializedName(value="topArrow")
    protected ComponentButtonStyle topArrowStyle = new ComponentButtonStyle();
    @SerializedName(value="bottomArrow")
    protected ComponentButtonStyle bottomArrowStyle = new ComponentButtonStyle();
    @SerializedName(value="leftArrow")
    protected ComponentButtonStyle leftArrowStyle = new ComponentButtonStyle();
    @SerializedName(value="rightArrow")
    protected ComponentButtonStyle rightArrowStyle = new ComponentButtonStyle();

    public ComponentButtonStyle getStyleForDirection(McScrollButton.ScrollButtonDirection scrollButtonDirection) {
        switch (scrollButtonDirection) {
            case TOP: {
                return this.getTopArrowStyle();
            }
            case BOTTOM: {
                return this.getBottomArrowStyle();
            }
            case LEFT: {
                return this.getLeftArrowStyle();
            }
            case RIGHT: {
                return this.getRightArrowStyle();
            }
        }
        return this.topArrowStyle;
    }

    public ComponentButtonStyle getTopArrowStyle() {
        return this.topArrowStyle;
    }

    public ComponentButtonStyle getBottomArrowStyle() {
        return this.bottomArrowStyle;
    }

    public ComponentButtonStyle getLeftArrowStyle() {
        return this.leftArrowStyle;
    }

    public ComponentButtonStyle getRightArrowStyle() {
        return this.rightArrowStyle;
    }
}

