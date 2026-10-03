/*
 * Decompiled with CFR 0.152.
 */
public class ieog
extends hsjl {
    public ieog() {
        super("stretch", 3);
    }

    @Override
    public void _a(ncyh ncyh2, int n, float f) {
        this._e.put(ncyh2.stretchX + (ncyh2.stretchX - ncyh2.prevStretchX) * f);
        this._e.put(ncyh2.stretchY + (ncyh2.stretchY - ncyh2.prevStretchY) * f);
        this._e.put(ncyh2.stretchZ + (ncyh2.stretchZ - ncyh2.prevStretchZ) * f);
    }
}

