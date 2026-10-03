/*
 * Decompiled with CFR 0.152.
 */
public class iyhq
extends cfum {
    protected gqjz _a;
    protected Class<? extends gqjz> _b;
    protected boolean _c;

    private iyhq() {
    }

    public static iyhq _a() {
        return new iyhq();
    }

    public iyhq _a(gqjz gqjz2) {
        this._a = gqjz2;
        return this;
    }

    public iyhq _a(Class<? extends gqjz> clazz) {
        this._b = clazz;
        return this;
    }

    public iyhq _b() {
        this._c = false;
        return this;
    }

    public iyhq _c() {
        this._c = true;
        return this;
    }

    public gqjz _d() {
        return this._a;
    }

    public Class<? extends gqjz> _e() {
        return this._a != null ? this._a.getClass() : this._b;
    }

    @Override
    public ywts _a(dzyj dzyj2) {
        this._i = new svcw.kjui(dzyj2){

            @Override
            public void _a(gqjz gqjz2) {
                if (!iyhq.this._c && gqjz2 != null) {
                    if (iyhq.this._b != null && iyhq.this._b.isInstance(gqjz2)) {
                        iyhq.this._a(iyhq.this, this);
                    } else if (iyhq.this._a != null && iyhq.this._a == gqjz2) {
                        iyhq.this._a(iyhq.this, this);
                    }
                }
            }

            @Override
            public void _b(gqjz gqjz2) {
                if (iyhq.this._c && gqjz2 != null) {
                    if (iyhq.this._b != null && iyhq.this._b.isInstance(gqjz2)) {
                        iyhq.this._a(iyhq.this, this);
                    } else if (iyhq.this._a != null && iyhq.this._a == gqjz2) {
                        iyhq.this._a(iyhq.this, this);
                    }
                }
            }
        };
        return this._i;
    }
}

