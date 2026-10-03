/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.core;

import com.mcf.davidee.guilib.core.Widget;

public abstract class Checkbox
extends Widget {
    protected String str;
    protected boolean check;

    public Checkbox(int n, int n2, String string) {
        super(n, n2);
        this.str = string;
    }

    public Checkbox(int n, int n2, String string, boolean bl) {
        this(n, n2, string);
        this.check = bl;
    }

    @Override
    public boolean click(int n, int n2) {
        return this.inBounds(n, n2);
    }

    @Override
    public void handleClick(int n, int n2) {
        this.check = !this.check;
    }

    public boolean isChecked() {
        return this.check;
    }

    public void setChecked(boolean bl) {
        this.check = bl;
    }
}

