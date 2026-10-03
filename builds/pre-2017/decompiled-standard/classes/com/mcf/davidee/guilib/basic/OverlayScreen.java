/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.basic;

import com.mcf.davidee.guilib.basic.BasicScreen;

public abstract class OverlayScreen
extends BasicScreen {
    protected BasicScreen bg;

    public OverlayScreen(BasicScreen basicScreen) {
        super(basicScreen);
        this.bg = basicScreen;
    }

    @Override
    public void drawBackground() {
        this.bg.func_73863_a(-1, -1, 0.0f);
    }

    @Override
    protected void revalidateGui() {
        this.bg.field_73880_f = this.field_73880_f;
        this.bg.field_73881_g = this.field_73881_g;
        this.bg.revalidateGui();
    }

    @Override
    protected void reopenedGui() {
    }
}

