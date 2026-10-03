/*
 * Decompiled with CFR 0.152.
 */
package codechicken.lib.vec;

public class Rectangle4i {
    public int x;
    public int y;
    public int w;
    public int h;

    public Rectangle4i() {
    }

    public Rectangle4i(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.w = n3;
        this.h = n4;
    }

    public int x1() {
        return this.x;
    }

    public int y1() {
        return this.y;
    }

    public int x2() {
        return this.x + this.w - 1;
    }

    public int y2() {
        return this.y + this.h - 1;
    }

    public Rectangle4i offset(int n, int n2) {
        this.x += n;
        this.y += n2;
        return this;
    }

    @Deprecated
    public Rectangle4i with(int n, int n2) {
        return this.include(n, n2);
    }

    public Rectangle4i include(int n, int n2) {
        if (n < this.x) {
            this.expand(n - this.x, 0);
        }
        if (n >= this.x + this.w) {
            this.expand(n - this.x - this.w + 1, 0);
        }
        if (n2 < this.y) {
            this.expand(0, n2 - this.y);
        }
        if (n2 >= this.y + this.h) {
            this.expand(0, n2 - this.y - this.h + 1);
        }
        return this;
    }

    public Rectangle4i include(Rectangle4i rectangle4i) {
        this.include(rectangle4i.x, rectangle4i.y);
        return this.include(rectangle4i.x2(), rectangle4i.y2());
    }

    public Rectangle4i expand(int n, int n2) {
        if (n > 0) {
            this.w += n;
        } else {
            this.x += n;
            this.w -= n;
        }
        if (n2 > 0) {
            this.h += n2;
        } else {
            this.y += n2;
            this.h -= n2;
        }
        return this;
    }

    public boolean contains(int n, int n2) {
        return this.x <= n && n < this.x + this.w && this.y <= n2 && n2 < this.y + this.h;
    }

    public boolean intersects(Rectangle4i rectangle4i) {
        return rectangle4i.x + rectangle4i.w > this.x && rectangle4i.x < this.x + this.w && rectangle4i.y + rectangle4i.h > this.y && rectangle4i.y < this.y + this.h;
    }

    public int area() {
        return this.w * this.h;
    }
}

