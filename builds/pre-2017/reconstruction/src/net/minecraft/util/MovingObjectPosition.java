/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Vec3;

public class MovingObjectPosition {
    public EnumMovingObjectType _c;
    public int _d;
    public int _e;
    public int _f;
    public int _g;
    public Vec3 _h;
    public Entity _i;
    public int _j = -1;
    public Object _k = null;

    public MovingObjectPosition(int n, int n2, int n3, int n4, Vec3 vec3) {
        this._c = EnumMovingObjectType._a;
        this._d = n;
        this._e = n2;
        this._f = n3;
        this._g = n4;
        this._h = vec3._b._a(vec3._c, vec3._d, vec3._e);
    }

    public MovingObjectPosition(Entity entity) {
        this._c = EnumMovingObjectType._b;
        this._i = entity;
        this._h = entity.worldObj.getWorldVec3Pool()._a(entity.posX, entity.posY, entity.posZ);
    }
}

