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
        this.bg.drawScreen(-1, -1, 0.0f);
    }

    @Override
    protected void revalidateGui() {
        this.bg.width = this.width;
        this.bg.height = this.height;
        this.bg.revalidateGui();
    }

    @Override
    protected void reopenedGui() {
    }
}

