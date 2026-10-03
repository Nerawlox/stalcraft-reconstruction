/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollBar;
import gloomyfolken.mods.core.client.gui.engine.component.McScrollButton;
import gloomyfolken.mods.core.client.gui.engine.component.McViewport;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentScrollButtonStyle;
import gloomyfolken.mods.core.client.gui.engine.style.ComponentSliderBarStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class McScrollPane
extends GuiComponentsList {
    protected boolean hideSliders = true;
    private ComponentSliderBarStyle barStyle;
    private ComponentScrollButtonStyle scrollButtonStyle;
    private McViewport viewport;
    private McScrollBar verticalScrollBar;
    private McScrollBar horizontalScrollBar;
    private McScrollButton topButton;
    private McScrollButton bottomButton;
    private McScrollButton leftButton;
    private McScrollButton rightButton;

    public McScrollPane(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, Dimension dimension2, boolean bl) {
        super(iAdvancedGui, point, dimension);
        this.viewport = new McViewport(iAdvancedGui, Point.zeroPoint, dimension, dimension2);
        this.hideSliders = bl;
    }

    @Override
    public void drawComponent(Point point, float f) {
        if (this.viewport != null) {
            float f2 = this.horizontalScrollBar == null ? 0.0f : this.horizontalScrollBar.pos;
            float f3 = this.verticalScrollBar == null ? 0.0f : this.verticalScrollBar.pos;
            this.viewport.setOffsetFromSliders(f2, f3);
        }
        super.drawComponent(point, f);
    }

    public void setScrollBarStyle(ComponentSliderBarStyle componentSliderBarStyle) {
        this.barStyle = componentSliderBarStyle;
    }

    public void setScrollButtonStyle(ComponentScrollButtonStyle componentScrollButtonStyle) {
        this.scrollButtonStyle = componentScrollButtonStyle;
    }

    public void initControls() {
        boolean bl;
        this.clearElements();
        int n = this.getHorizontalPanelHeight();
        int n2 = this.getVerticalPanelWidth();
        boolean bl2 = this.viewport.getTotalHeight() > this.getSize().height || !this.hideSliders;
        boolean bl3 = bl = this.viewport.getTotalWidth() > this.getSize().width || !this.hideSliders;
        if (bl2 && !bl && this.getSize().width - n2 > this.viewport.getTotalWidth()) {
            bl = true;
        }
        if (bl && !bl2 && this.getSize().height - n > this.viewport.getTotalHeight()) {
            bl2 = true;
        }
        if (!bl) {
            n = 0;
        }
        if (!bl2) {
            n2 = 0;
        }
        this.updateViewportSize(bl2, bl, n2, n);
        this.updateVerticalBar(bl2, n);
        this.updateHorizontalBar(bl, n2);
        this.updateTopButton();
        this.updateBottomButton();
        this.updateLeftButton();
        this.updateRightButton();
        this.addAll(this.removeNulls(Arrays.asList(this.viewport, this.verticalScrollBar, this.horizontalScrollBar, this.topButton, this.bottomButton, this.leftButton, this.rightButton)));
    }

    private void updateViewportSize(boolean bl, boolean bl2, int n, int n2) {
        int n3 = this.getSize().width;
        if (bl) {
            n3 -= n;
        }
        int n4 = this.getSize().height;
        if (bl2) {
            n4 -= n2;
        }
        this.viewport.setSize(new Dimension(n3, n4));
    }

    private void updateVerticalBar(boolean bl, int n) {
        if (bl) {
            int n2 = this.getSize().width - this.barStyle.getVerticalBarStyle().getSize().width;
            int n3 = this.scrollButtonStyle.getTopArrowStyle().getSize().height;
            int n4 = this.getSize().height - n;
            n4 -= this.scrollButtonStyle.getTopArrowStyle().getSize().height;
            this.verticalScrollBar = new McScrollBar(this.parent, (IScrollable)this.viewport, McScrollBar.ScrollBarType.VERTICAL, n2, n3, n4 -= this.scrollButtonStyle.getBottomArrowStyle().getSize().height, this.barStyle.getVerticalBarStyle());
        } else {
            this.verticalScrollBar = null;
        }
    }

    private void updateHorizontalBar(boolean bl, int n) {
        if (bl) {
            int n2 = this.scrollButtonStyle.getLeftArrowStyle().getSize().height;
            int n3 = this.getSize().height - this.barStyle.getHorizontalBarStyle().getSize().height;
            int n4 = this.getSize().width - n;
            n4 -= this.scrollButtonStyle.getLeftArrowStyle().getSize().width;
            this.horizontalScrollBar = new McScrollBar(this.parent, (IScrollable)this.viewport, McScrollBar.ScrollBarType.HORIZONTAL, n2, n3, n4 -= this.scrollButtonStyle.getRightArrowStyle().getSize().width, this.barStyle.getHorizontalBarStyle());
        } else {
            this.horizontalScrollBar = null;
        }
    }

    private void updateTopButton() {
        if (this.verticalScrollBar != null && this.scrollButtonStyle != null) {
            int n = this.getSize().width - this.scrollButtonStyle.getTopArrowStyle().getSize().width;
            int n2 = 0;
            this.topButton = new McScrollButton(this.parent, this.verticalScrollBar, McScrollButton.ScrollButtonDirection.TOP, n, n2, this.scrollButtonStyle);
        } else {
            this.topButton = null;
        }
    }

    private void updateBottomButton() {
        if (this.verticalScrollBar != null && this.scrollButtonStyle != null) {
            int n = this.getSize().width - this.scrollButtonStyle.getBottomArrowStyle().getSize().width;
            int n2 = this.verticalScrollBar.getLength() + this.scrollButtonStyle.getTopArrowStyle().getSize().height;
            this.bottomButton = new McScrollButton(this.parent, this.verticalScrollBar, McScrollButton.ScrollButtonDirection.BOTTOM, n, n2, this.scrollButtonStyle);
        } else {
            this.bottomButton = null;
        }
    }

    private void updateLeftButton() {
        if (this.horizontalScrollBar != null && this.scrollButtonStyle != null) {
            int n = 0;
            int n2 = this.getSize().height - this.scrollButtonStyle.getLeftArrowStyle().getSize().height;
            this.leftButton = new McScrollButton(this.parent, this.horizontalScrollBar, McScrollButton.ScrollButtonDirection.LEFT, n, n2, this.scrollButtonStyle);
        } else {
            this.leftButton = null;
        }
    }

    private void updateRightButton() {
        if (this.horizontalScrollBar != null && this.scrollButtonStyle != null) {
            int n = this.horizontalScrollBar.getLength() + this.scrollButtonStyle.getLeftArrowStyle().getSize().width;
            int n2 = this.getSize().height - this.scrollButtonStyle.getRightArrowStyle().getSize().height;
            this.rightButton = new McScrollButton(this.parent, this.horizontalScrollBar, McScrollButton.ScrollButtonDirection.RIGHT, n, n2, this.scrollButtonStyle);
        } else {
            this.rightButton = null;
        }
    }

    private int getVerticalPanelWidth() {
        int n = 0;
        if (this.barStyle != null) {
            n = this.barStyle.getVerticalBarStyle().getSize().width;
            if (this.scrollButtonStyle != null) {
                n = Math.max(n, this.scrollButtonStyle.getTopArrowStyle().getSize().width);
                n = Math.max(n, this.scrollButtonStyle.getBottomArrowStyle().getSize().width);
            }
        }
        return n;
    }

    private int getHorizontalPanelHeight() {
        int n = 0;
        if (this.barStyle != null) {
            n = this.barStyle.getHorizontalBarStyle().getSize().height;
            if (this.scrollButtonStyle != null) {
                n = Math.max(n, this.scrollButtonStyle.getLeftArrowStyle().getSize().height);
                n = Math.max(n, this.scrollButtonStyle.getRightArrowStyle().getSize().height);
            }
        }
        return n;
    }

    private <T> List<T> removeNulls(Collection<T> collection) {
        ArrayList<T> arrayList = new ArrayList<T>();
        for (T t : collection) {
            if (t == null) continue;
            arrayList.add(t);
        }
        return arrayList;
    }

    public void setHideSliders(boolean bl) {
        this.hideSliders = bl;
        this.initControls();
    }

    public McViewport getViewport() {
        return this.viewport;
    }

    public McScrollBar getVerticalScrollBar() {
        return this.verticalScrollBar;
    }

    public McScrollBar getHorizontalScrollBar() {
        return this.horizontalScrollBar;
    }

    public McScrollButton getTopButton() {
        return this.topButton;
    }

    public McScrollButton getBottomButton() {
        return this.bottomButton;
    }

    public McScrollButton getLeftButton() {
        return this.leftButton;
    }

    public McScrollButton getRightButton() {
        return this.rightButton;
    }
}

