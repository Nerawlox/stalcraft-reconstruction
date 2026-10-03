/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;

public class jkjg
extends cfum {
    protected cvzo _a;
    protected boolean _b = false;
    protected boolean _c = false;
    protected boolean _d = false;
    protected Entity _e;

    private jkjg() {
    }

    public static jkjg _a() {
        return new jkjg();
    }

    public jkjg _a(cvzo cvzo2) {
        this._a = cvzo2;
        return this;
    }

    public jkjg _a(Entity entity) {
        if (entity == null) {
            this._d = true;
        }
        this._e = entity;
        return this;
    }

    public jkjg _b() {
        this._c = false;
        this._b = true;
        return this;
    }

    public jkjg _c() {
        this._b = false;
        this._c = true;
        return this;
    }

    @Override
    public ywts _a(dzyj dzyj2) {
        this._i = new ukhi.kjui(dzyj2){

            @Override
            public void _a(cvzo cvzo2) {
                if (!jkjg.this._c || jkjg.this._a == null || cvzo2 == null) {
                    return;
                }
                if (cvzo2._b(jkjg.this._a)) {
                    jkjg.this._a(jkjg.this, this);
                }
            }

            @Override
            public void _a(ozlu ozlu2, Entity entity, cvzo cvzo2) {
                if (!jkjg.this._b || jkjg.this._a == null || cvzo2 == null) {
                    return;
                }
                if (cvzo2._a() == jkjg.this._a._a()) {
                    if (jkjg.this._e != null && entity != null) {
                        if (jkjg.this._e.field_70157_k == entity.field_70157_k) {
                            jkjg.this._a(jkjg.this, this);
                        }
                    } else if (!jkjg.this._d || jkjg.this._d && entity == null) {
                        jkjg.this._a(jkjg.this, this);
                    }
                }
            }
        };
        return this._i;
    }
}

