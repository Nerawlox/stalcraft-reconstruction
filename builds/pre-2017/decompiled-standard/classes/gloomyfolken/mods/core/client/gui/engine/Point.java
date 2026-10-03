/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

import org.lwjgl.util.vector.Vector2f;

public class Point {
    public static final Point zeroPoint = new Point(0, 0);
    public final int x;
    public final int y;

    public Point(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    public Point(double d, double d2) {
        this.x = (int)(d + 0.5);
        this.y = (int)(d2 + 0.5);
    }

    public Point(Vector2f vector2f) {
        this(vector2f.x, vector2f.y);
    }

    public Point add(Point point) {
        return this.add(point.x, point.y);
    }

    public Point subtract(Point point) {
        return this.add(-point.x, -point.y);
    }

    public Point add(int n, int n2) {
        return new Point(this.x + n, this.y + n2);
    }

    public Point multiply(float f) {
        return new Point((float)this.x * f, (float)this.y * f);
    }

    public Point multiply(float f, float f2) {
        return new Point((float)this.x * f, (float)this.y * f2);
    }

    public Vector2f toVec() {
        return new Vector2f(this.x, this.y);
    }

    public String toString() {
        return "Point{x=" + this.x + ", y=" + this.y + '}';
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Point point = (Point)object;
        if (this.x != point.x) {
            return false;
        }
        return this.y == point.y;
    }

    public int hashCode() {
        int n = this.x;
        n = 31 * n + this.y;
        return n;
    }
}

