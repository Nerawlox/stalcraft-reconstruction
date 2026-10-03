/*
 * Decompiled with CFR 0.152.
 */
public class dfso
extends fokl {
    public dfso() {
        this._c = true;
    }

    @Override
    public void _a(String string) {
        if (this._h == 0L && string.equals("tick")) {
            this._h = System.nanoTime();
        }
        if (this._h != 0L && string.equals("preRenderErrors")) {
            this._i = System.nanoTime() - this._h;
            this._h = 0L;
        }
        if (this._j == 0L && string.equals("updatechunks")) {
            this._j = System.nanoTime();
        }
        if (this._j != 0L && string.equals("terrain")) {
            this._k = System.nanoTime() - this._j;
            this._j = 0L;
        }
        if (this._g && this._c) {
            if (this._d.length() > 0) {
                this._d = this._d + ".";
            }
            this._d = this._d + string;
            this._a.add(this._d);
            this._b.add(System.nanoTime());
        }
    }
}

