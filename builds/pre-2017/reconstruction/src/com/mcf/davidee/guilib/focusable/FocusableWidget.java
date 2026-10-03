/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.focusable;

import com.mcf.davidee.guilib.core.Widget;

public abstract class FocusableWidget
extends Widget {
    public FocusableWidget(int n, int n2) {
        super(n, n2);
    }

    public FocusableWidget(int n, int n2, int n3, int n4) {
        super(n, n2, n3, n4);
    }

    public abstract void focusGained();

    public abstract void focusLost();
}

