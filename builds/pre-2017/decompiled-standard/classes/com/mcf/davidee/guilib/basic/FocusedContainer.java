/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.basic;

import com.mcf.davidee.guilib.core.Container;
import com.mcf.davidee.guilib.core.Scrollbar;
import com.mcf.davidee.guilib.core.Widget;
import com.mcf.davidee.guilib.focusable.FocusableWidget;

public class FocusedContainer
extends Container {
    public FocusedContainer() {
    }

    public FocusedContainer(Scrollbar scrollbar, int n, int n2) {
        super(scrollbar, n, n2);
    }

    @Override
    public void setFocused(FocusableWidget focusableWidget) {
        if (focusableWidget != null) {
            super.setFocused(focusableWidget);
        }
    }

    @Override
    public void addWidgets(Widget ... widgetArray) {
        super.addWidgets(widgetArray);
        if (this.focusIndex == -1 && this.focusList.size() > 0) {
            this.focusIndex = 0;
            ((FocusableWidget)this.focusList.get(this.focusIndex)).focusGained();
        }
    }
}

