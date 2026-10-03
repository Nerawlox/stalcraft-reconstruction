/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponent;

public class McRect
extends GuiComponent {
    private int color;

    public McRect(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, int n) {
        super(iAdvancedGui, point, dimension);
        this.color = n;
    }

    @Override
    public void drawComponent(Point point, float f) {
        super.drawComponent(point, f);
        this.renderer.drawRect(this.getLocation(), this.getSize(), this.color);
    }
}

