/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.vanilla;

import com.mcf.davidee.guilib.core.Scrollbar;
import com.mcf.davidee.guilib.core.Widget;

public class ScrollbarVanilla
extends Scrollbar {
    public ScrollbarVanilla(int n) {
        super(n);
    }

    @Override
    protected void drawBoundary(int n, int n2, int n3, int n4) {
        ScrollbarVanilla.func_73734_a(n, n2, n + n3, n2 + n4, Integer.MIN_VALUE);
    }

    @Override
    protected void drawScrollbar(int n, int n2, int n3, int n4) {
        this.func_73733_a(n, n2, n + n3, n2 + n4, -2130706433, -2145246686);
    }

    @Override
    protected void shiftChildren(int n) {
        for (Widget widget : this.container.getWidgets()) {
            if (!(widget instanceof Scrollbar.Shiftable)) continue;
            ((Scrollbar.Shiftable)((Object)widget)).shiftY(n);
        }
    }
}

