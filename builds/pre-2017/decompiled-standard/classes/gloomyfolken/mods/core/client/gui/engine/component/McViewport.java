/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.ScissorHelper;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.IScrollable;

public class McViewport
extends GuiComponentsList<GuiComponent>
implements IScrollable {
    protected Point viewportLocation;
    protected Dimension viewSize;
    public int minScroll = 20;
    private int offsetX;
    private int offsetY;

    public McViewport(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, Dimension dimension2) {
        super(iAdvancedGui, point, dimension);
        this.viewportLocation = point;
        this.viewSize = dimension2;
        this.updateBottomRightCorner();
    }

    public void setOffsetFromSliders(float f, float f2) {
        this.offsetX = (int)((float)(this.viewSize.width - this.getSize().width) * f);
        this.offsetY = (int)((float)(this.viewSize.height - this.getSize().height) * f2);
    }

    public void setOffset(int n, int n2) {
        this.offsetX = n;
        this.offsetY = n2;
    }

    @Override
    public boolean isMouseInBounds(Point point) {
        return McViewport.isMouseInBounds(point, this.viewportLocation, this.bottomRightCorner);
    }

    @Override
    public void mouseClicked(Point point, int n) {
        if (this.isMouseInBounds(point)) {
            super.mouseClicked(point, n);
        }
    }

    @Override
    protected void updateBottomRightCorner() {
        Point point = this.viewportLocation == null ? this.getLocation() : this.viewportLocation;
        this.bottomRightCorner = new Point(point.x + this.getSize().width, point.y + this.getSize().height);
    }

    @Override
    public void drawComponent(Point point, float f) {
        this.setLocation(this.viewportLocation.add(-this.offsetX, -this.offsetY));
        this.renderer.scaledScissor(this.viewportLocation.add(this.origin), this.getSize());
        super.drawComponent(point, f);
        ScissorHelper.popScissor();
    }

    @Override
    public int getWidthPerPage() {
        return this.getSize().width;
    }

    @Override
    public int getTotalWidth() {
        return this.viewSize.width;
    }

    @Override
    public int getHeightPerPage() {
        return this.getSize().height;
    }

    @Override
    public int getTotalHeight() {
        return this.viewSize.height;
    }

    @Override
    public int getMinScroll() {
        return this.minScroll;
    }

    public Dimension getViewSize() {
        return this.viewSize;
    }

    public McViewport setViewSize(Dimension dimension) {
        this.viewSize = dimension;
        return this;
    }

    public Point getViewportLocation() {
        return this.viewportLocation;
    }

    public McViewport setViewportLocation(Point point) {
        this.viewportLocation = point;
        return this;
    }

    @Override
    public GuiComponent getElementMouseOver(Point point) {
        if (this.isMouseInBounds(point)) {
            return super.getElementMouseOver(point);
        }
        return null;
    }
}

