/*
 * Decompiled with CFR 0.152.
 */
package mods.pda.client.component.option;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.GuiComponentsList;
import gloomyfolken.mods.core.client.gui.engine.component.McButton;
import java.util.function.Consumer;
import org.lwjgl.opengl.GL11;

public class PdaSelection
extends GuiComponentsList {
    private String[] titles;
    private int index;
    private Consumer<PdaSelection> onSelected = pdaSelection -> {};

    public PdaSelection(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, String[] stringArray, int n) {
        super(iAdvancedGui, point, dimension);
        this.titles = stringArray;
        this.index = n;
        this.addElement(new McButton(iAdvancedGui, new Point(0, 0), iedw._c, "").onClick(guiActionButtonClick -> this.setIndex((this.index + 1) % this.titles.length)));
        this.addElement(new McButton(iAdvancedGui, new Point(dimension.width - iedw._d.getSize().width, 0), iedw._d, "").onClick(guiActionButtonClick -> this.setIndex(this.index > 0 ? this.index - 1 : this.titles.length - 1)));
    }

    @Override
    public void drawComponent(Point point, float f) {
        super.drawComponent(point, f);
        if (!this.getEnabled()) {
            GL11.glEnable(3042);
            GL11.glColor4f(1.0f, 0.5f, 0.5f, 0.5f);
        }
        this.renderer.bindTexture(iedw._a);
        Point point2 = this.getAbsoluteLocation();
        this.renderer.drawTiledRect(point2.add(14, 0), new Point(288, 952), this.getSize().add(-28, 0), new Dimension(18, 23), 1, 3);
        this.renderer.drawCenteredString(this.titles[this.index], point2.add(this.getSize().width / 2, this.renderer.getFontHeight() / 2), -1);
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int n) {
        this.index = Math.max(n, 0);
        this.onSelected.accept(this);
    }

    public PdaSelection onSelected(Consumer<PdaSelection> consumer) {
        this.onSelected = consumer;
        return this;
    }
}

