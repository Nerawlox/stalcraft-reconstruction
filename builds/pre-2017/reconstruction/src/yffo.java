/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.util.piet;

public class yffo
extends piet {
    public Class _a;
    public int _b;
    public int _c;

    public yffo(Class clazz, int n, int n2, int n3) {
        super(n);
        this._a = clazz;
        this._b = n2;
        this._c = n3;
    }

    public String toString() {
        return this._a.getSimpleName() + "*(" + this._b + "-" + this._c + "):" + this.itemWeight;
    }
}

