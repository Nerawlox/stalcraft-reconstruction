/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.core;

import com.mcf.davidee.guilib.core.Widget;

public abstract class Button
extends Widget {
    protected ButtonHandler handler;

    public Button(int n, int n2, ButtonHandler buttonHandler) {
        super(n, n2);
        this.handler = buttonHandler;
    }

    @Override
    public boolean click(int n, int n2) {
        return this.enabled && this.inBounds(n, n2);
    }

    @Override
    public void handleClick(int n, int n2) {
        if (this.handler != null) {
            this.handler.buttonClicked(this);
        }
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }

    public String getText() {
        return "";
    }

    public void setText(String string) {
    }

    public static interface ButtonHandler {
        public void buttonClicked(Button var1);
    }
}

