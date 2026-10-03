/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.focusable;

import com.mcf.davidee.guilib.core.Widget;
import com.mcf.davidee.guilib.focusable.FocusableLabel;

public class FocusableSpecialLabel
extends FocusableLabel {
    private String actualText;

    public FocusableSpecialLabel(String string, String string2, Widget ... widgetArray) {
        super(string, widgetArray);
        this.actualText = string2;
    }

    public FocusableSpecialLabel(int n, int n2, String string, String string2, Widget ... widgetArray) {
        this(string, string2, widgetArray);
        this.setPosition(n, n2);
    }

    public String getSpecialText() {
        return this.actualText;
    }

    public void setSpecialText(String string) {
        this.actualText = string;
    }
}

