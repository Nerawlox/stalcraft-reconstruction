/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Point;

public interface IScrollable {
    public int getWidthPerPage();

    public int getTotalWidth();

    public int getHeightPerPage();

    public int getTotalHeight();

    public int getMinScroll();

    public boolean isMouseInBounds(Point var1);
}

