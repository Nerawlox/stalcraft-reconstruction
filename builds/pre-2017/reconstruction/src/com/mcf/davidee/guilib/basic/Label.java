/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.basic;

import com.mcf.davidee.guilib.core.Widget;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;

public class Label
extends Widget {
    private String str;
    private int color;
    private int hoverColor;
    private List<Widget> tooltips;
    private boolean hover;
    private boolean center;
    private boolean shadow;
    private long hoverStart;

    public Label(String string, int n, int n2, Widget ... widgetArray) {
        this(string, n, n2, true, widgetArray);
    }

    public Label(String string, Widget ... widgetArray) {
        this(string, 0xFFFFFF, 0xFFFFFF, true, widgetArray);
    }

    public Label(String string, int n, int n2, boolean bl, Widget ... widgetArray) {
        super(Label.getStringWidth(string), 11);
        this.center = bl;
        this.str = string;
        this.color = n;
        this.hoverColor = n2;
        this.shadow = true;
        this.tooltips = new ArrayList<Widget>();
        for (Widget widget : widgetArray) {
            this.tooltips.add(widget);
        }
    }

    public Label(String string, boolean bl, Widget ... widgetArray) {
        this(string, 0xFFFFFF, 0xFFFFFF, bl, widgetArray);
    }

    public void setColor(int n) {
        this.color = n;
    }

    public void setHoverColor(int n) {
        this.hoverColor = n;
    }

    public void setShadowedText(boolean bl) {
        this.shadow = bl;
    }

    public String getText() {
        return this.str;
    }

    public void setText(String string) {
        if (this.center) {
            this.x += this.width / 2;
        }
        this.str = string;
        this.width = Label.getStringWidth(string);
        if (this.center) {
            this.x -= this.width / 2;
        }
    }

    @Override
    public void draw(int n, int n2) {
        boolean bl = this.inBounds(n, n2);
        if (bl && !this.hover) {
            this.hoverStart = System.currentTimeMillis();
            for (Widget widget : this.tooltips) {
                widget.setPosition(n + 3, this.y + this.height);
            }
        }
        this.hover = bl;
        if (this.shadow) {
            this.mc._z._a(this.str, this.x, this.y + 2, this.hover ? this.hoverColor : this.color);
        } else {
            this.mc._z._b(this.str, this.x, this.y + 2, this.hover ? this.hoverColor : this.color);
        }
    }

    @Override
    public List<Widget> getTooltips() {
        return this.hover && System.currentTimeMillis() - this.hoverStart >= 500L ? this.tooltips : super.getTooltips();
    }

    @Override
    public boolean click(int n, int n2) {
        return false;
    }

    private static int getStringWidth(String string) {
        return Minecraft._E()._z._b(string);
    }

    @Override
    public void setPosition(int n, int n2) {
        this.x = this.center ? n - this.width / 2 : n;
        this.y = n2;
    }
}

