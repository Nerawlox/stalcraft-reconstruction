/*
 * Decompiled with CFR 0.152.
 */
public class fmdl
extends hsjl {
    public fmdl() {
        super("pcolor", 3);
    }

    @Override
    public void _a(ncyh ncyh2, int n, float f) {
        this._e.put(ncyh2.prevRed + (ncyh2.red - ncyh2.prevRed) * f);
        this._e.put(ncyh2.prevGreen + (ncyh2.green - ncyh2.prevGreen) * f);
        this._e.put(ncyh2.prevBlue + (ncyh2.blue - ncyh2.prevBlue) * f);
    }
}

