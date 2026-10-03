/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.pathfinding;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.sajz;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class PathNavigate {
    public EntityLiving _a;
    public World _b;
    public PathEntity _c;
    public double _d;
    public hubf _e;
    public boolean _f;
    public int _g;
    public int _h;
    public Vec3 _i = Vec3._a(0.0, 0.0, 0.0);
    public boolean _j = true;
    public boolean _k;
    public boolean _l;
    public boolean _m;

    public PathNavigate(EntityLiving entityLiving, World world) {
        this._a = entityLiving;
        this._b = world;
        this._e = entityLiving.getEntityAttribute(sajz._b);
    }

    public void _a(boolean bl) {
        this._l = bl;
    }

    public boolean _a() {
        return this._l;
    }

    public void _b(boolean bl) {
        this._k = bl;
    }

    public void _c(boolean bl) {
        this._j = bl;
    }

    public boolean _b() {
        return this._k;
    }

    public void _d(boolean bl) {
        this._f = bl;
    }

    public void _a(double d) {
        this._d = d;
    }

    public void _e(boolean bl) {
        this._m = bl;
    }

    public float _c() {
        return (float)this._e._e();
    }

    public PathEntity _a(double d, double d2, double d3) {
        if (!this._k()) {
            return null;
        }
        return this._b.getEntityPathToXYZ(this._a, sajh._c(d), (int)d2, sajh._c(d3), this._c(), this._j, this._k, this._l, this._m);
    }

    public boolean _a(double d, double d2, double d3, double d4) {
        PathEntity pathEntity = this._a(sajh._c(d), (int)d2, sajh._c(d3));
        return this._a(pathEntity, d4);
    }

    public PathEntity _a(Entity entity) {
        if (!this._k()) {
            return null;
        }
        return this._b.getPathEntityToEntity(this._a, entity, this._c(), this._j, this._k, this._l, this._m);
    }

    public boolean _a(Entity entity, double d) {
        PathEntity pathEntity = this._a(entity);
        if (pathEntity != null) {
            return this._a(pathEntity, d);
        }
        return false;
    }

    public boolean _a(PathEntity pathEntity, double d) {
        if (pathEntity == null) {
            this._c = null;
            return false;
        }
        if (!pathEntity._a(this._c)) {
            this._c = pathEntity;
        }
        if (this._f) {
            this._m();
        }
        if (this._c._g() == 0) {
            return false;
        }
        this._d = d;
        Vec3 vec3 = this._i();
        this._h = this._g;
        this._i._c = vec3._c;
        this._i._d = vec3._d;
        this._i._e = vec3._e;
        return true;
    }

    public PathEntity _d() {
        return this._c;
    }

    public void _e() {
        ++this._g;
        if (this._g()) {
            return;
        }
        if (this._k()) {
            this._f();
        }
        if (this._g()) {
            return;
        }
        Vec3 vec3 = this._c._a(this._a);
        if (vec3 == null) {
            return;
        }
        this._a.getMoveHelper()._a(vec3._c, vec3._d, vec3._e, this._d);
    }

    public void _f() {
        int n;
        Vec3 vec3 = this._i();
        int n2 = this._c._g();
        for (int i = this._c._h(); i < this._c._g(); ++i) {
            if (this._c._c((int)i)._b == (int)vec3._d) continue;
            n2 = i;
            break;
        }
        float f = this._a.width * this._a.width;
        for (n = this._c._h(); n < n2; ++n) {
            if (!(vec3._e(this._c._a(this._a, n)) < (double)f)) continue;
            this._c._e(n + 1);
        }
        n = sajh._f(this._a.width);
        int n3 = (int)this._a.height + 1;
        int n4 = n;
        for (int i = n2 - 1; i >= this._c._h(); --i) {
            if (!this._a(vec3, this._c._a(this._a, i), n, n3, n4)) continue;
            this._c._e(i);
            break;
        }
        if (this._g - this._h > 100) {
            if (vec3._e(this._i) < 2.25) {
                this._h();
            }
            this._h = this._g;
            this._i._c = vec3._c;
            this._i._d = vec3._d;
            this._i._e = vec3._e;
        }
    }

    public boolean _g() {
        return this._c == null || this._c._e();
    }

    public void _h() {
        this._c = null;
    }

    public Vec3 _i() {
        return this._b.getWorldVec3Pool()._a(this._a.posX, this._j(), this._a.posZ);
    }

    public int _j() {
        if (!this._a.isInWater() || !this._m) {
            return (int)(this._a.boundingBox._c + 0.5);
        }
        int n = (int)this._a.boundingBox._c;
        int n2 = this._b.getBlockId(sajh._c(this._a.posX), n, sajh._c(this._a.posZ));
        int n3 = 0;
        while (n2 == Block.waterMoving.blockID || n2 == Block.waterStill.blockID) {
            n2 = this._b.getBlockId(sajh._c(this._a.posX), ++n, sajh._c(this._a.posZ));
            if (++n3 <= 16) continue;
            return (int)this._a.boundingBox._c;
        }
        return n;
    }

    public boolean _k() {
        return this._a.onGround || this._m && this._l();
    }

    public boolean _l() {
        return this._a.isInWater() || this._a.handleLavaMovement();
    }

    public void _m() {
        if (this._b.canBlockSeeTheSky(sajh._c(this._a.posX), (int)(this._a.boundingBox._c + 0.5), sajh._c(this._a.posZ))) {
            return;
        }
        for (int i = 0; i < this._c._g(); ++i) {
            elhc elhc2 = this._c._c(i);
            if (!this._b.canBlockSeeTheSky(elhc2._a, elhc2._b, elhc2._c)) continue;
            this._c._d(i - 1);
            return;
        }
    }

    public boolean _a(Vec3 vec3, Vec3 vec32, int n, int n2, int n3) {
        int n4 = sajh._c(vec3._c);
        int n5 = sajh._c(vec3._e);
        double d = vec32._c - vec3._c;
        double d2 = vec32._e - vec3._e;
        double d3 = d * d + d2 * d2;
        if (d3 < 1.0E-8) {
            return false;
        }
        double d4 = 1.0 / Math.sqrt(d3);
        if (!this._a(n4, (int)vec3._d, n5, n += 2, n2, n3 += 2, vec3, d *= d4, d2 *= d4)) {
            return false;
        }
        n -= 2;
        n3 -= 2;
        double d5 = 1.0 / Math.abs(d);
        double d6 = 1.0 / Math.abs(d2);
        double d7 = (double)(n4 * 1) - vec3._c;
        double d8 = (double)(n5 * 1) - vec3._e;
        if (d >= 0.0) {
            d7 += 1.0;
        }
        if (d2 >= 0.0) {
            d8 += 1.0;
        }
        d7 /= d;
        d8 /= d2;
        int n6 = d < 0.0 ? -1 : 1;
        int n7 = d2 < 0.0 ? -1 : 1;
        int n8 = sajh._c(vec32._c);
        int n9 = sajh._c(vec32._e);
        int n10 = n8 - n4;
        int n11 = n9 - n5;
        while (n10 * n6 > 0 || n11 * n7 > 0) {
            if (d7 < d8) {
                d7 += d5;
                n10 = n8 - (n4 += n6);
            } else {
                d8 += d6;
                n11 = n9 - (n5 += n7);
            }
            if (this._a(n4, (int)vec3._d, n5, n, n2, n3, vec3, d, d2)) continue;
            return false;
        }
        return true;
    }

    public boolean _a(int n, int n2, int n3, int n4, int n5, int n6, Vec3 vec3, double d, double d2) {
        int n7 = n - n4 / 2;
        int n8 = n3 - n6 / 2;
        if (!this._b(n7, n2, n8, n4, n5, n6, vec3, d, d2)) {
            return false;
        }
        for (int i = n7; i < n7 + n4; ++i) {
            for (int j = n8; j < n8 + n6; ++j) {
                double d3 = (double)i + 0.5 - vec3._c;
                double d4 = (double)j + 0.5 - vec3._e;
                if (d3 * d + d4 * d2 < 0.0) continue;
                int n9 = this._b.getBlockId(i, n2 - 1, j);
                if (n9 <= 0) {
                    return false;
                }
                Material material = Block.blocksList[n9].blockMaterial;
                if (material == Material._h && !this._a.isInWater()) {
                    return false;
                }
                if (material != Material._i) continue;
                return false;
            }
        }
        return true;
    }

    public boolean _b(int n, int n2, int n3, int n4, int n5, int n6, Vec3 vec3, double d, double d2) {
        for (int i = n; i < n + n4; ++i) {
            for (int j = n2; j < n2 + n5; ++j) {
                for (int k = n3; k < n3 + n6; ++k) {
                    int n7;
                    double d3 = (double)i + 0.5 - vec3._c;
                    double d4 = (double)k + 0.5 - vec3._e;
                    if (d3 * d + d4 * d2 < 0.0 || (n7 = this._b.getBlockId(i, j, k)) <= 0 || Block.blocksList[n7].getBlocksMovement(this._b, i, j, k)) continue;
                    return false;
                }
            }
        }
        return true;
    }
}

