/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.client.gui.engine;

public class Dimension {
    public static final Dimension zeroDimension = new Dimension(0, 0);
    public final int width;
    public final int height;

    public Dimension(int n, int n2) {
        this.width = n;
        this.height = n2;
    }

    public Dimension(Dimension dimension) {
        this.width = dimension.width;
        this.height = dimension.height;
    }

    public Dimension add(int n, int n2) {
        return new Dimension(this.width + n, this.height + n2);
    }

    public String toString() {
        return "Dimension{height=" + this.height + ", width=" + this.width + '}';
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Dimension dimension = (Dimension)object;
        if (this.height != dimension.height) {
            return false;
        }
        return this.width == dimension.width;
    }

    public int hashCode() {
        int n = this.width;
        n = 31 * n + this.height;
        return n;
    }
}

