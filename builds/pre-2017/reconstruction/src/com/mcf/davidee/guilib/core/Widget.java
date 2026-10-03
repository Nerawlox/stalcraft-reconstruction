/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.core;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public abstract class Widget
extends Gui {
    protected Minecraft mc = Minecraft._E();
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean enabled;

    public Widget(int n, int n2) {
        this.width = n;
        this.height = n2;
        this.enabled = true;
    }

    public Widget(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
        this.enabled = true;
    }

    public abstract void draw(int var1, int var2);

    public abstract boolean click(int var1, int var2);

    public void handleClick(int n, int n2) {
    }

    public void update() {
    }

    public void mouseReleased(int n, int n2) {
    }

    public boolean keyTyped(char c, int n) {
        return false;
    }

    public boolean mouseWheel(int n) {
        return false;
    }

    public List<Widget> getTooltips() {
        return Collections.emptyList();
    }

    public boolean inBounds(int n, int n2) {
        return n >= this.x && n2 >= this.y && n < this.x + this.width && n2 < this.y + this.height;
    }

    public boolean shouldRender(int n, int n2) {
        return this.y + this.height >= n && this.y <= n2;
    }

    public void setPosition(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}

