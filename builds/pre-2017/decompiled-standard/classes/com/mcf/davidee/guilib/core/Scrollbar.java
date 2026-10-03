/*
 * Decompiled with CFR 0.152.
 */
package com.mcf.davidee.guilib.core;

import com.mcf.davidee.guilib.core.Container;
import com.mcf.davidee.guilib.core.Widget;
import org.lwjgl.input.Mouse;

public abstract class Scrollbar
extends Widget {
    protected int yClick = -1;
    protected Container container;
    private int topY;
    private int bottomY;
    private int offset;

    public Scrollbar(int n) {
        super(n, 0);
    }

    protected abstract void shiftChildren(int var1);

    protected abstract void drawBoundary(int var1, int var2, int var3, int var4);

    protected abstract void drawScrollbar(int var1, int var2, int var3, int var4);

    public void revalidate(int n, int n2) {
        this.topY = n;
        this.bottomY = n2;
        this.height = n2 - n;
        int n3 = this.getHeightDifference();
        if (this.offset != 0 && n3 <= 0) {
            this.offset = 0;
        }
        if (n3 > 0 && this.offset < -n3) {
            this.offset = -n3;
        }
        if (this.offset != 0) {
            this.shiftChildren(this.offset);
        }
    }

    public void onChildRemoved() {
        int n = this.getHeightDifference();
        if (this.offset != 0) {
            if (n <= 0) {
                this.shiftChildren(-this.offset);
                this.offset = 0;
            } else if (this.offset < -n) {
                this.shiftChildren(-n - this.offset);
                this.offset = -n;
            }
        }
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    protected int getHeightDifference() {
        return this.container.getContentHeight() - (this.bottomY - this.topY);
    }

    protected int getLength() {
        if (this.container.getContentHeight() == 0) {
            return 0;
        }
        int n = (this.bottomY - this.topY) * (this.bottomY - this.topY) / this.container.getContentHeight();
        if (n < 32) {
            n = 32;
        }
        if (n > this.bottomY - this.topY - 8) {
            n = this.bottomY - this.topY - 8;
        }
        return n;
    }

    @Override
    public void draw(int n, int n2) {
        int n3 = this.getLength();
        if (Mouse.isButtonDown(0)) {
            if (this.yClick == -1) {
                if (this.inBounds(n, n2)) {
                    this.yClick = n2;
                }
            } else {
                float f = 1.0f;
                int n4 = this.getHeightDifference();
                if (n4 < 1) {
                    n4 = 1;
                }
                this.shift((int)((float)(this.yClick - n2) * (f /= (float)(this.bottomY - this.topY - n3) / (float)n4)));
                this.yClick = n2;
            }
        } else {
            this.yClick = -1;
        }
        this.drawBoundary(this.x, this.topY, this.width, this.height);
        int n5 = -this.offset * (this.bottomY - this.topY - n3) / this.getHeightDifference() + this.topY;
        if (n5 < this.topY) {
            n5 = this.topY;
        }
        this.drawScrollbar(this.x, n5, this.width, n3);
    }

    @Override
    public boolean click(int n, int n2) {
        return false;
    }

    @Override
    public boolean shouldRender(int n, int n2) {
        return this.getHeightDifference() > 0;
    }

    public void shiftRelative(int n) {
        int n2 = this.getHeightDifference();
        if (n2 > 0) {
            int n3;
            int n4 = this.offset + (n = (int)((float)n * (1.0f + (float)n2 / (float)(this.bottomY - this.topY))));
            if (n4 > 0) {
                n4 = 0;
            }
            if (n4 < -n2) {
                n4 = -n2;
            }
            if ((n3 = n4 - this.offset) != 0) {
                this.shiftChildren(n3);
            }
            this.offset = n4;
        }
    }

    public void shift(int n) {
        int n2 = this.getHeightDifference();
        if (n2 > 0) {
            int n3;
            int n4 = this.offset + n;
            if (n4 > 0) {
                n4 = 0;
            }
            if (n4 < -n2) {
                n4 = -n2;
            }
            if ((n3 = n4 - this.offset) != 0) {
                this.shiftChildren(n3);
            }
            this.offset = n4;
        }
    }

    public static interface Shiftable {
        public void shiftY(int var1);
    }
}

