/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.anomaly.entity;

import gloomyfolken.mods.anomaly.AnomalyMod;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityKisselWave
extends Entity {
    public float size;
    public float prevSize;
    public float alpha;
    private double localX;
    private double localY;
    private double localZ;
    private boolean canExpand = true;
    private boolean isKisselAtMinusX;
    private boolean isKisselAtPlusX;
    private boolean isKisselAtMinusZ;
    private boolean isKisselAtPlusZ;
    private static final int BLOCK_ID = AnomalyMod._M.blockID;

    public EntityKisselWave(World world) {
        super(world);
        this.setSize(0.5f, 0.5f);
    }

    public EntityKisselWave(World world, double d, double d2, double d3) {
        this(world);
        this.setPosition(d, d2, d3);
        int n = sajh._c(d);
        int n2 = sajh._c(d2);
        int n3 = sajh._c(d3);
        this.localX = d - (double)n;
        this.localY = d2 - (double)n2;
        this.localZ = d3 - (double)n3;
        this.isKisselAtMinusX = world.getBlockId(n - 1, n2, n3) == BLOCK_ID;
        this.isKisselAtPlusX = world.getBlockId(n + 1, n2, n3) == BLOCK_ID;
        this.isKisselAtMinusZ = world.getBlockId(n, n2, n3 - 1) == BLOCK_ID;
        this.isKisselAtPlusZ = world.getBlockId(n, n2, n3 + 1) == BLOCK_ID;
        this.alpha = 1.0f;
    }

    @Override
    public void onUpdate() {
        this.prevSize = this.size;
        if (this.canExpand) {
            boolean bl = false;
            float f = (this.size + 0.035f) / 2.0f;
            if (!this.isKisselAtMinusX && this.localX - (double)f < 0.0) {
                bl = true;
            }
            if (!this.isKisselAtPlusX && this.localX + (double)f > 1.0) {
                bl = true;
            }
            if (!this.isKisselAtMinusZ && this.localZ - (double)f < 0.0) {
                bl = true;
            }
            if (!this.isKisselAtPlusZ && this.localZ + (double)f > 1.0) {
                bl = true;
            }
            if (!bl) {
                this.size += 0.07f;
            } else {
                this.canExpand = false;
            }
        }
        if (this.ticksExisted >= 5) {
            this.alpha = (float)((double)this.alpha * 0.85);
            this.alpha = (float)((double)this.alpha - 0.02);
        }
        if (this.ticksExisted > 40) {
            this.setDead();
        }
    }

    @Override
    public boolean shouldRenderInPass(int n) {
        return n == 2;
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
    }
}

