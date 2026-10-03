/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine.component;

import gloomyfolken.mods.core.client.gui.engine.Dimension;
import gloomyfolken.mods.core.client.gui.engine.IAdvancedGui;
import gloomyfolken.mods.core.client.gui.engine.Point;
import gloomyfolken.mods.core.client.gui.engine.Property;
import gloomyfolken.mods.core.client.gui.engine.component.McTextField;

public class McNumberField
extends McTextField {
    @Property
    private long maxValue = Long.MAX_VALUE;
    @Property
    private long minValue = Long.MIN_VALUE;

    public McNumberField(IAdvancedGui iAdvancedGui, Point point, Dimension dimension) {
        super(iAdvancedGui, point, dimension);
        this.setNumber(0);
    }

    public McNumberField(IAdvancedGui iAdvancedGui, int n, int n2, int n3, int n4) {
        super(iAdvancedGui, new Point(n, n2), new Dimension(n3, n4));
        this.setNumber(0);
    }

    @Override
    public void setText(String string) {
        String string2 = this.getText();
        super.setText(string);
        this.confirmNumber(string2, this.getText());
    }

    @Override
    public void deleteFromCursor(int n) {
        String string = this.getText();
        super.deleteFromCursor(n);
        this.confirmNumber(string, this.getText());
    }

    @Override
    public void deleteWords(int n) {
        String string = this.getText();
        super.deleteWords(n);
        this.confirmNumber(string, this.getText());
    }

    @Override
    public void writeText(String string) {
        String string2 = this.getText();
        super.writeText(string);
        this.confirmNumber(string2, this.getText());
    }

    protected void confirmNumber(String string, String string2) {
        if (string2.isEmpty()) {
            this.setNumber(0);
        } else {
            try {
                long l = Long.parseLong(string2);
                if (l > this.maxValue) {
                    l = this.maxValue;
                }
                if (l < this.minValue) {
                    l = this.minValue;
                }
                this.setNumber(l);
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

    protected void updateText(String string) {
        super.setText(string);
    }

    public void setNumber(int n) {
        this.setNumber((long)n);
    }

    public void setNumber(long l) {
        if (l > this.maxValue) {
            l = this.maxValue;
        }
        if (l < this.minValue) {
            l = this.minValue;
        }
        this.updateText(String.valueOf(l));
    }

    public void setMinValue(long l) {
        this.minValue = l;
        this.setNumber(this.getValue());
    }

    public void setMaxValue(long l) {
        this.maxValue = l;
        this.setNumber(this.getValue());
    }

    public long getValue() {
        try {
            return Long.parseLong(this.getText());
        }
        catch (NumberFormatException numberFormatException) {
            this.setNumber(0);
            return Long.parseLong(this.getText());
        }
    }
}

