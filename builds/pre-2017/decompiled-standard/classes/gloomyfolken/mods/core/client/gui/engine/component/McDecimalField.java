/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.component.McNumberField;

public class McDecimalField
extends McNumberField {
    private double min = Double.MIN_VALUE;
    private double max = Double.MAX_VALUE;

    public McDecimalField(IAdvancedGui iAdvancedGui, Point point, Dimension dimension, double d, double d2, double d3) {
        super(iAdvancedGui, point, dimension);
        this.min = d2;
        this.max = d3;
        this.setNumber(d);
    }

    @Override
    protected void confirmNumber(String string, String string2) {
        if (string2.isEmpty()) {
            this.setNumber(0.0);
        } else {
            try {
                this.setNumber(Double.parseDouble(string2));
            }
            catch (NumberFormatException numberFormatException) {
                try {
                    this.setNumber(Long.parseLong(string));
                }
                catch (NumberFormatException numberFormatException2) {
                    this.setNumber(0);
                }
            }
        }
    }

    public void setNumber(double d) {
        if (d > this.max) {
            d = this.max;
        }
        if (d < this.min) {
            d = this.min;
        }
        super.updateText(String.valueOf(d));
    }

    public double getDecimal() {
        try {
            return Double.parseDouble(this.getText());
        }
        catch (NumberFormatException numberFormatException) {
            this.setNumber(0.0);
            return Long.parseLong(this.getText());
        }
    }
}

