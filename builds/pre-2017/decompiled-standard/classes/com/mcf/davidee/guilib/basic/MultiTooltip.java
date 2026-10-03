/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.basic;

import com.mcf.davidee.guilib.core.Widget;
import java.util.List;
import net.minecraft.client.xpzm;

public class MultiTooltip
extends Widget {
    protected int color;
    protected int txtColor;
    private List<String> text;

    public MultiTooltip(List<String> list2) {
        super(MultiTooltip.getMaxStringWidth(list2) + 4, list2.size() * 12);
        this.text = list2;
        this.field_73735_i = 1.0f;
        this.color = -16777216;
        this.txtColor = 0xFFFFFF;
    }

    public MultiTooltip(List<String> list2, int n, int n2) {
        super(MultiTooltip.getMaxStringWidth(list2) + 4, list2.size() * 12);
        this.text = list2;
        this.field_73735_i = 1.0f;
        this.color = n;
        this.txtColor = n2;
    }

    @Override
    public void draw(int n, int n2) {
        MultiTooltip.func_73734_a(this.x, this.y, this.x + this.width, this.y + this.height, this.color);
        int n3 = this.y + 2;
        for (String string : this.text) {
            this.mc._z._a(string, this.x + 2, n3, this.txtColor);
            n3 += 11;
        }
    }

    @Override
    public boolean click(int n, int n2) {
        return false;
    }

    public void setBackgroundColor(int n) {
        this.color = n;
    }

    public void setTextColor(int n) {
        this.txtColor = n;
    }

    public static int getMaxStringWidth(List<String> list2) {
        xpzm xpzm2 = xpzm._E();
        int n = 0;
        for (String string : list2) {
            int n2 = xpzm2._z._b(string);
            if (n2 <= n) continue;
            n = n2;
        }
        return n;
    }
}

