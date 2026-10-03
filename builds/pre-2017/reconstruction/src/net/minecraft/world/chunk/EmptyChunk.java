/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk;

import java.util.List;
import java.util.Random;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class EmptyChunk
extends Chunk {
    public EmptyChunk(World world, int n, int n2) {
        super(world, n, n2);
    }

    @Override
    public boolean _a(int n, int n2) {
        return n == this._i && n2 == this._j;
    }

    @Override
    public int _b(int n, int n2) {
        return 0;
    }

    @Override
    public void _c() {
    }

    @Override
    public void _d() {
    }

    @Override
    public int _d(int n, int n2, int n3) {
        return 0;
    }

    @Override
    public int _c(int n, int n2, int n3) {
        return 255;
    }

    @Override
    public boolean _a(int n, int n2, int n3, int n4, int n5) {
        return true;
    }

    @Override
    public int _e(int n, int n2, int n3) {
        return 0;
    }

    @Override
    public boolean _b(int n, int n2, int n3, int n4) {
        return false;
    }

    @Override
    public int _a(EnumSkyBlock enumSkyBlock, int n, int n2, int n3) {
        return 0;
    }

    @Override
    public void _a(EnumSkyBlock enumSkyBlock, int n, int n2, int n3, int n4) {
    }

    @Override
    public int _c(int n, int n2, int n3, int n4) {
        return 0;
    }

    @Override
    public void _a(Entity entity) {
    }

    @Override
    public void _b(Entity entity) {
    }

    @Override
    public void _a(Entity entity, int n) {
    }

    @Override
    public boolean _f(int n, int n2, int n3) {
        return false;
    }

    @Override
    public TileEntity _g(int n, int n2, int n3) {
        return null;
    }

    @Override
    public void _a(TileEntity tileEntity) {
    }

    @Override
    public void _a(int n, int n2, int n3, TileEntity tileEntity) {
    }

    @Override
    public void _h(int n, int n2, int n3) {
    }

    @Override
    public void _f() {
    }

    @Override
    public void _g() {
    }

    @Override
    public void _h() {
    }

    @Override
    public void _a(Entity entity, AxisAlignedBB axisAlignedBB, List list2, IEntitySelector iEntitySelector) {
    }

    @Override
    public void _a(Class clazz, AxisAlignedBB axisAlignedBB, List list2, IEntitySelector iEntitySelector) {
    }

    @Override
    public boolean _a(boolean bl) {
        return false;
    }

    @Override
    public Random _a(long l) {
        return new Random(this._g.getSeed() + (long)(this._i * this._i * 4987142) + (long)(this._i * 5947611) + (long)(this._j * this._j) * 4392871L + (long)(this._j * 389711) ^ l);
    }

    @Override
    public boolean _i() {
        return true;
    }

    @Override
    public boolean _e(int n, int n2) {
        return true;
    }
}

