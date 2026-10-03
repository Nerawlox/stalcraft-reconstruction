/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.pathfinding;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;

public class PathEntity {
    public final elhc[] _a;
    public int _b;
    public int _c;

    public PathEntity(elhc[] elhcArray) {
        this._a = elhcArray;
        this._c = elhcArray.length;
    }

    public void _d() {
        ++this._b;
    }

    public boolean _e() {
        return this._b >= this._c;
    }

    public elhc _f() {
        if (this._c > 0) {
            return this._a[this._c - 1];
        }
        return null;
    }

    public elhc _c(int n) {
        return this._a[n];
    }

    public int _g() {
        return this._c;
    }

    public void _d(int n) {
        this._c = n;
    }

    public int _h() {
        return this._b;
    }

    public void _e(int n) {
        this._b = n;
    }

    public Vec3 _a(Entity entity, int n) {
        double d = (double)this._a[n]._a + (double)((int)(entity.width + 1.0f)) * 0.5;
        double d2 = this._a[n]._b;
        double d3 = (double)this._a[n]._c + (double)((int)(entity.width + 1.0f)) * 0.5;
        return entity.worldObj.getWorldVec3Pool()._a(d, d2, d3);
    }

    public Vec3 _a(Entity entity) {
        return this._a(entity, this._b);
    }

    public boolean _a(PathEntity pathEntity) {
        if (pathEntity == null) {
            return false;
        }
        if (pathEntity._a.length != this._a.length) {
            return false;
        }
        for (int i = 0; i < this._a.length; ++i) {
            if (this._a[i]._a == pathEntity._a[i]._a && this._a[i]._b == pathEntity._a[i]._b && this._a[i]._c == pathEntity._a[i]._c) continue;
            return false;
        }
        return true;
    }

    public boolean _a(Vec3 vec3) {
        elhc elhc2 = this._f();
        if (elhc2 == null) {
            return false;
        }
        return elhc2._a == (int)vec3._c && elhc2._c == (int)vec3._e;
    }
}

