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
import net.minecraft.util.sajh;

public class PdaNumberPicker
extends GuiComponentsList {
    private int value;
    private int max;
    private int min;
    private int step;
    private Consumer<PdaNumberPicker> onChange = pdaNumberPicker -> {};

    public PdaNumberPicker(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, int n, int n2, int n3, int n4) {
        super(iAdvancedGui, point, dimension);
        this.value = n;
        this.min = n2;
        this.max = n3;
        this.step = n4;
        this.addElement(new McButton(iAdvancedGui, new Point(0, 0), iedw._c, "").onClick(guiActionButtonClick -> this.setValue(sajh._a(this.value - this.step, this.min, this.max))));
        this.addElement(new McButton(iAdvancedGui, new Point(dimension.width - iedw._d.getSize().width, 0), iedw._d, "").onClick(guiActionButtonClick -> this.setValue(sajh._a(this.value + this.step, this.min, this.max))));
    }

    @Override
    public void drawComponent(Point point, float f) {
        super.drawComponent(point, f);
        this.renderer.bindTexture(iedw._a);
        Point point2 = this.getAbsoluteLocation();
        this.renderer.drawTiledRect(point2.add(14, 0), new Point(288, 952), this.getSize().add(-28, 0), new Dimension(18, 23), 1, 3);
        this.renderer.drawCenteredString(String.valueOf(this.value), point2.add(this.getSize().width / 2, this.renderer.getFontHeight() / 2), -1);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int n) {
        this.value = n;
        if (this.onChange != null) {
            this.onChange.accept(this);
        }
    }

    public PdaNumberPicker onChange(Consumer<PdaNumberPicker> consumer) {
        this.onChange = consumer;
        return this;
    }
}

