/*
 * Decompiled with CFR 0.152.
 */
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class jkjg
extends cfum {
    protected ItemStack _a;
    protected boolean _b = false;
    protected boolean _c = false;
    protected boolean _d = false;
    protected Entity _e;

    private jkjg() {
    }

    public static jkjg _a() {
        return new jkjg();
    }

    public jkjg _a(ItemStack itemStack) {
        this._a = itemStack;
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
            public void _a(ItemStack itemStack) {
                if (!jkjg.this._c || jkjg.this._a == null || itemStack == null) {
                    return;
                }
                if (itemStack._b(jkjg.this._a)) {
                    jkjg.this._a(jkjg.this, this);
                }
            }

            @Override
            public void _a(World world, Entity entity, ItemStack itemStack) {
                if (!jkjg.this._b || jkjg.this._a == null || itemStack == null) {
                    return;
                }
                if (itemStack._a() == jkjg.this._a._a()) {
                    if (jkjg.this._e != null && entity != null) {
                        if (jkjg.this._e.entityId == entity.entityId) {
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

