/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.focusable;

import com.mcf.davidee.guilib.core.Scrollbar;
import com.mcf.davidee.guilib.core.Widget;
import com.mcf.davidee.guilib.focusable.FocusableWidget;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;

public class FocusableLabel
extends FocusableWidget
implements Scrollbar.Shiftable {
    private String str;
    private int color;
    private int hoverColor;
    private int focusColor;
    private List<Widget> tooltips;
    private boolean hover;
    private boolean center;
    private boolean focused;
    private Object userData;

    public FocusableLabel(String string, int n, int n2, int n3, Widget ... widgetArray) {
        this(string, n, n2, n3, true, widgetArray);
    }

    public FocusableLabel(String string, Widget ... widgetArray) {
        this(string, 0xFFFFFF, 0xFFFFA0, 0x22AAFF, true, widgetArray);
    }

    public FocusableLabel(String string, int n, int n2, int n3, boolean bl, Widget ... widgetArray) {
        super(FocusableLabel.getStringWidth(string), 11);
        this.center = bl;
        this.str = string;
        this.color = n;
        this.hoverColor = n2;
        this.focusColor = n3;
        this.tooltips = new ArrayList<Widget>();
        for (Widget widget : widgetArray) {
            this.tooltips.add(widget);
        }
    }

    public FocusableLabel(String string, boolean bl, Widget ... widgetArray) {
        this(string, 0xFFFFFF, 0xFFFFA0, 0x22AAFF, bl, widgetArray);
    }

    public FocusableLabel(int n, int n2, String string, Widget ... widgetArray) {
        this(string, 0xFFFFFF, 0xFFFFA0, 0x22AAFF, true, widgetArray);
        this.setPosition(n, n2);
    }

    public void setColors(int n, int n2, int n3) {
        this.color = n;
        this.hoverColor = n2;
        this.focusColor = n3;
    }

    public void setColor(int n) {
        this.color = n;
    }

    public void setHoverColor(int n) {
        this.hoverColor = n;
    }

    public void setFocusColor(int n) {
        this.focusColor = n;
    }

    public String getText() {
        return this.str;
    }

    public void setText(String string) {
        if (this.center) {
            this.x += this.width / 2;
        }
        this.str = string;
        this.width = FocusableLabel.getStringWidth(string);
        if (this.center) {
            this.x -= this.width / 2;
        }
    }

    public void setUserData(Object object) {
        this.userData = object;
    }

    public Object getUserData() {
        return this.userData;
    }

    @Override
    public void draw(int n, int n2) {
        boolean bl = this.inBounds(n, n2);
        if (bl && !this.hover) {
            for (Widget widget : this.tooltips) {
                widget.setPosition(n + 3, this.y + this.height);
            }
        }
        this.hover = bl;
        if (this.focused) {
            FocusableLabel.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, -1717986919);
        }
        this.mc._z._a(this.str, this.x, this.y + 2, this.focused ? this.focusColor : (this.hover ? this.hoverColor : this.color));
    }

    @Override
    public List<Widget> getTooltips() {
        return this.hover ? this.tooltips : super.getTooltips();
    }

    @Override
    public boolean click(int n, int n2) {
        return this.inBounds(n, n2);
    }

    private static int getStringWidth(String string) {
        return Minecraft._E()._z._b(string);
    }

    @Override
    public void setPosition(int n, int n2) {
        this.x = this.center ? n - this.width / 2 : n;
        this.y = n2;
    }

    @Override
    public void shiftY(int n) {
        this.y += n;
    }

    @Override
    public void focusGained() {
        this.focused = true;
    }

    @Override
    public void focusLost() {
        this.focused = false;
    }
}

