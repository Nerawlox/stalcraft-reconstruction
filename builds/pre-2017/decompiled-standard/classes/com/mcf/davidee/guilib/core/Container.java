/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.core;

import com.mcf.davidee.guilib.core.Scrollbar;
import com.mcf.davidee.guilib.core.Widget;
import com.mcf.davidee.guilib.focusable.FocusableWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.xpzm;
import net.minecraft.util.sajh;
import org.lwjgl.opengl.GL11;

public class Container {
    protected final xpzm mc = xpzm._E();
    protected List<FocusableWidget> focusList;
    protected List<Widget> widgets;
    protected int left;
    protected int right;
    protected int top;
    protected int bottom;
    protected int shiftAmount;
    protected int extraScrollHeight;
    protected int scrollbarWidth;
    protected int cHeight;
    protected int focusIndex;
    protected Scrollbar scrollbar;
    protected Widget lastSelected;
    protected boolean clip;

    public Container(Scrollbar scrollbar, int n, int n2) {
        this.scrollbar = scrollbar;
        this.shiftAmount = n;
        this.extraScrollHeight = n2;
        this.widgets = new ArrayList<Widget>();
        this.focusList = new ArrayList<FocusableWidget>();
        this.focusIndex = -1;
        this.clip = true;
        if (scrollbar != null) {
            scrollbar.setContainer(this);
            this.scrollbarWidth = scrollbar.width;
        }
    }

    public Container() {
        this(null, 0, 0);
    }

    public void revalidate(int n, int n2, int n3, int n4) {
        this.left = n;
        this.right = n + n3;
        this.top = n2;
        this.bottom = n2 + n4;
        this.calculateContentHeight();
        if (this.scrollbar != null) {
            this.scrollbar.revalidate(this.top, this.bottom);
            this.scrollbarWidth = this.scrollbar.width;
        }
    }

    public List<Widget> getWidgets() {
        return this.widgets;
    }

    public List<FocusableWidget> getFocusableWidgets() {
        return this.focusList;
    }

    public void addWidgets(Widget ... widgetArray) {
        for (Widget widget : widgetArray) {
            this.widgets.add(widget);
            if (!(widget instanceof FocusableWidget)) continue;
            this.focusList.add((FocusableWidget)widget);
        }
        this.calculateContentHeight();
    }

    private void calculateContentHeight() {
        int n = Integer.MAX_VALUE;
        int n2 = Integer.MIN_VALUE;
        for (Widget widget : this.widgets) {
            if (!(widget instanceof Scrollbar.Shiftable)) continue;
            if (widget.y < n) {
                n = widget.y;
            }
            if (widget.y + widget.height <= n2) continue;
            n2 = widget.y + widget.height;
        }
        this.cHeight = n > n2 ? 0 : n2 - n + this.extraScrollHeight;
    }

    public int getContentHeight() {
        return this.cHeight;
    }

    public void update() {
        for (Widget widget : this.widgets) {
            widget.update();
        }
    }

    public List<Widget> draw(int n, int n2, int n3) {
        if (this.clip) {
            GL11.glEnable(3089);
            GL11.glScissor(this.left * n3, this.mc._o - this.bottom * n3, (this.right - this.left - this.scrollbarWidth) * n3, (this.bottom - this.top) * n3);
        }
        ArrayList<Widget> arrayList = new ArrayList<Widget>();
        boolean bl = this.inBounds(n, n2);
        int n4 = bl || !this.clip ? n : -1;
        int n5 = bl || !this.clip ? n2 : -1;
        for (Widget widget : this.widgets) {
            if (!widget.shouldRender(this.top, this.bottom)) continue;
            widget.draw(n4, n5);
            arrayList.addAll(widget.getTooltips());
        }
        if (this.clip) {
            GL11.glDisable(3089);
        }
        if (this.scrollbar != null && this.scrollbar.shouldRender(this.top, this.bottom)) {
            this.scrollbar.draw(n, n2);
        }
        return arrayList;
    }

    public void setFocused(FocusableWidget focusableWidget) {
        int n;
        int n2 = n = focusableWidget == null ? -1 : this.focusList.indexOf(focusableWidget);
        if (this.focusIndex != n) {
            if (this.focusIndex != -1) {
                this.focusList.get(this.focusIndex).focusLost();
            }
            if (n != -1) {
                this.focusList.get(n).focusGained();
            }
            this.focusIndex = n;
        }
    }

    public boolean inBounds(int n, int n2) {
        return n >= this.left && n2 >= this.top && n < this.right && n2 < this.bottom;
    }

    public boolean mouseClicked(int n, int n2) {
        if (this.inBounds(n, n2)) {
            boolean bl = true;
            if (this.scrollbar != null && this.scrollbar.shouldRender(this.top, this.bottom) && this.scrollbar.inBounds(n, n2)) {
                return true;
            }
            for (Widget widget : this.widgets) {
                if (!widget.shouldRender(this.top, this.bottom) || !widget.click(n, n2)) continue;
                this.lastSelected = widget;
                if (widget instanceof FocusableWidget) {
                    this.setFocused((FocusableWidget)widget);
                    bl = false;
                }
                widget.handleClick(n, n2);
                break;
            }
            if (bl) {
                this.setFocused(null);
            }
            return true;
        }
        return false;
    }

    public FocusableWidget deleteFocused() {
        if (this.hasFocusedWidget()) {
            FocusableWidget focusableWidget = this.getFocusedWidget();
            if (this.lastSelected == focusableWidget) {
                this.lastSelected = null;
            }
            this.focusList.remove(this.focusIndex);
            if (this.focusList.size() == 0) {
                this.focusIndex = -1;
            } else {
                this.focusIndex = sajh._a(this.focusIndex, 0, this.focusList.size() - 1);
                this.focusList.get(this.focusIndex).focusGained();
            }
            int n = this.widgets.indexOf(focusableWidget);
            int n2 = Integer.MAX_VALUE;
            for (int i = n + 1; i < this.widgets.size(); ++i) {
                Widget widget = this.widgets.get(i);
                if (!(widget instanceof Scrollbar.Shiftable)) continue;
                if (n2 == Integer.MAX_VALUE) {
                    n2 = focusableWidget.getY() - widget.getY();
                }
                ((Scrollbar.Shiftable)((Object)widget)).shiftY(n2);
            }
            this.widgets.remove(focusableWidget);
            this.calculateContentHeight();
            if (this.scrollbar != null) {
                this.scrollbar.onChildRemoved();
            }
            return focusableWidget;
        }
        return null;
    }

    public void removeFocusableWidgets() {
        this.focusIndex = -1;
        if (this.lastSelected instanceof FocusableWidget) {
            this.lastSelected = null;
        }
        this.widgets.removeAll(this.focusList);
        this.focusList.clear();
        this.calculateContentHeight();
        if (this.scrollbar != null) {
            this.scrollbar.onChildRemoved();
        }
    }

    public void mouseReleased(int n, int n2) {
        if (this.lastSelected != null) {
            this.lastSelected.mouseReleased(n, n2);
            this.lastSelected = null;
        }
    }

    public boolean hasFocusedWidget() {
        return this.focusIndex != -1;
    }

    public FocusableWidget getFocusedWidget() {
        return this.focusList.get(this.focusIndex);
    }

    public boolean keyTyped(char c, int n) {
        boolean bl;
        boolean bl2 = bl = this.focusIndex != -1 ? this.focusList.get(this.focusIndex).keyTyped(c, n) : false;
        if (!bl) {
            switch (n) {
                case 200: {
                    this.shift(-1);
                    bl = true;
                    break;
                }
                case 208: {
                    this.shift(1);
                    bl = true;
                    break;
                }
                case 15: {
                    this.shiftFocusToNext();
                    bl = true;
                }
            }
        }
        return bl;
    }

    protected void shiftFocusToNext() {
        int n;
        if (this.focusIndex != -1 && this.focusList.size() > 1 && (n = (this.focusIndex + 1) % this.focusList.size()) != this.focusIndex) {
            this.focusList.get(this.focusIndex).focusLost();
            this.focusList.get(n).focusGained();
            if (this.scrollbar != null && this.scrollbar.shouldRender(this.top, this.bottom)) {
                this.scrollbar.shift((this.focusIndex - n) * this.shiftAmount);
            }
            this.focusIndex = n;
        }
    }

    protected void shiftFocus(int n) {
        if (this.focusIndex != n) {
            this.focusList.get(this.focusIndex).focusLost();
            this.focusList.get(n).focusGained();
            if (this.scrollbar != null && this.scrollbar.shouldRender(this.top, this.bottom)) {
                this.scrollbar.shift((this.focusIndex - n) * this.shiftAmount);
            }
            this.focusIndex = n;
        }
    }

    protected void shift(int n) {
        if (this.focusIndex != -1) {
            this.shiftFocus(sajh._a(this.focusIndex + n, 0, this.focusList.size() - 1));
        } else if (this.scrollbar != null && this.scrollbar.shouldRender(this.top, this.bottom)) {
            this.scrollbar.shiftRelative(n * -4);
        }
    }

    public void mouseWheel(int n) {
        if (this.scrollbar != null && this.scrollbar.shouldRender(this.top, this.bottom)) {
            this.scrollbar.shiftRelative(n);
        } else {
            boolean bl = false;
            if (this.focusIndex != -1) {
                bl = this.focusList.get(this.focusIndex).mouseWheel(n);
            } else {
                Iterator<Widget> iterator2 = this.widgets.iterator();
                while (iterator2.hasNext() && !bl) {
                    bl = iterator2.next().mouseWheel(n);
                }
            }
        }
    }

    public void setClipping(boolean bl) {
        this.clip = bl;
    }

    public boolean isClipping() {
        return this.clip;
    }

    public int left() {
        return this.left;
    }

    public int right() {
        return this.right;
    }

    public int top() {
        return this.top;
    }

    public int bottom() {
        return this.bottom;
    }
}

