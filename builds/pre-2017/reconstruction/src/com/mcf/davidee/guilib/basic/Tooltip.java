/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.basic;

import com.mcf.davidee.guilib.core.Widget;
import net.minecraft.client.Minecraft;

public class Tooltip
extends Widget {
    protected int color;
    protected int txtColor;
    private String str;

    public Tooltip(String string) {
        super(Minecraft._E()._z._b(string) + 4, 12);
        this.zLevel = 1.0f;
        this.str = string;
        this.color = -16777216;
        this.txtColor = 0xFFFFFF;
    }

    public Tooltip(String string, int n, int n2) {
        super(Minecraft._E()._z._b(string) + 4, 12);
        this.zLevel = 1.0f;
        this.str = string;
        this.color = n;
        this.txtColor = n2;
    }

    public void setBackgroundColor(int n) {
        this.color = n;
    }

    public void setTextColor(int n) {
        this.txtColor = n;
    }

    @Override
    public void draw(int n, int n2) {
        Tooltip.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, this.color);
        this.drawCenteredString(this.mc._z, this.str, this.x + this.width / 2, this.y + (this.height - 8) / 2, this.txtColor);
    }

    @Override
    public boolean click(int n, int n2) {
        return false;
    }
}

