/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.piev;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.world.World;

public class EntityMinecartMobSpawner
extends EntityMinecart {
    public final MobSpawnerBaseLogic mobSpawnerLogic = new piev(this);

    public EntityMinecartMobSpawner(World world) {
        super(world);
    }

    public EntityMinecartMobSpawner(World world, double d, double d2, double d3) {
        super(world, d, d2, d3);
    }

    @Override
    public int getMinecartType() {
        return 4;
    }

    @Override
    public Block getDefaultDisplayTile() {
        return Block.mobSpawner;
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.mobSpawnerLogic._a(nBTTagCompound);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        this.mobSpawnerLogic._b(nBTTagCompound);
    }

    @Override
    public void handleHealthUpdate(byte by) {
        this.mobSpawnerLogic._b(by);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.mobSpawnerLogic._g();
    }

    public MobSpawnerBaseLogic func_98039_d() {
        return this.mobSpawnerLogic;
    }
}

