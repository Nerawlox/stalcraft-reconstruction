/*
 * Decompiled with CFR 0.152.
 */
public class uyot
extends hsjl {
    public uyot() {
        super("burn", 1);
    }

    @Override
    public void _a(ncyh ncyh2, int n, float f) {
        this._e.put(ncyh2.prevBurn + (ncyh2.burn - ncyh2.prevBurn) * f);
    }
}

