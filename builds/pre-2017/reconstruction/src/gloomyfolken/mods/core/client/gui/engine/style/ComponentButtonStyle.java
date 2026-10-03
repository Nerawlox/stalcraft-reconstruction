/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.style;

import com.google.gson.annotations.SerializedName;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentStyle;

public class ComponentButtonStyle
extends ComponentStyle {
    @SerializedName(value="mouseOverUv")
    protected Point mouseOverUv = new Point(0, 0);
    @SerializedName(value="activeUv")
    protected Point activeUv = new Point(0, 0);
    @SerializedName(value="disabledUv")
    protected Point disabledUv = new Point(0, 0);
    protected boolean visibleBackground = true;
    @SerializedName(value="borderSizeX")
    protected int borderSizeX = -1;
    @SerializedName(value="borderSizeY")
    protected int borderSizeY = -1;

    public int getBorderSizeX() {
        return this.borderSizeX != -1 ? this.borderSizeX : this.borderThickness;
    }

    public void setBorderSizeX(int n) {
        this.borderSizeX = n;
    }

    public int getBorderSizeY() {
        return this.borderSizeY != -1 ? this.borderSizeY : this.borderThickness;
    }

    public void setBorderSizeY(int n) {
        this.borderSizeY = n;
    }

    public Point getActiveUv() {
        return this.activeUv;
    }

    public Point getMouseOverUv() {
        return this.mouseOverUv;
    }

    public Point getDisabledUv() {
        return this.disabledUv;
    }

    protected void setActiveUv(int n, int n2) {
        this.activeUv = new Point(n, n2);
    }

    protected void setActiveUv(Point point) {
        this.activeUv = point;
    }

    protected void setMouseOverUv(int n, int n2) {
        this.mouseOverUv = new Point(n, n2);
    }

    protected void setMouseOverUv(Point point) {
        this.mouseOverUv = point;
    }

    protected void setDisabledUv(int n, int n2) {
        this.disabledUv = new Point(n, n2);
    }

    protected void setDisabledUv(Point point) {
        this.disabledUv = point;
    }

    public boolean isVisibleBackground() {
        return this.visibleBackground;
    }

    public void setVisibleBackground(boolean bl) {
        this.visibleBackground = bl;
    }
}

