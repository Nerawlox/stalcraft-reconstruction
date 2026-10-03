/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.entity.ai.EntityMinecartMobSpawner;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class piev
extends MobSpawnerBaseLogic {
    public final /* synthetic */ EntityMinecartMobSpawner _a;

    public piev(EntityMinecartMobSpawner entityMinecartMobSpawner) {
        this._a = entityMinecartMobSpawner;
    }

    @Override
    public void _a(int n) {
        this._a.worldObj.setEntityState(this._a, (byte)n);
    }

    @Override
    public World _a() {
        return this._a.worldObj;
    }

    @Override
    public int _b() {
        return sajh._c(this._a.posX);
    }

    @Override
    public int _c() {
        return sajh._c(this._a.posY);
    }

    @Override
    public int _d() {
        return sajh._c(this._a.posZ);
    }
}

