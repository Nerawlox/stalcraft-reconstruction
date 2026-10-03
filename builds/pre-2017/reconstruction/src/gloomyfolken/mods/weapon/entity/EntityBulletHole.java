/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.weapon.entity;

import gloomyfolken.bundle.common.core.eidj;
import gloomyfolken.bundle.common.core.ezey;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

@ezey(_a={eidj.CLIENT})
public class EntityBulletHole
extends Entity {
    public static final int LIFETIME = 200;
    protected static final float ENTITY_SIZE = 0.1f;
    public int sideHit = -1;
    public long lastRenderedFrame;
    public int atlasRow;
    public boolean isKnifeHole = false;

    public EntityBulletHole(World world) {
        super(world);
        this.setSize(0.1f, 0.1f);
    }

    public EntityBulletHole(World world, double d, double d2, double d3, int n, int n2) {
        super(world);
        this.setPosition(d, d2, d3);
        this.sideHit = n;
        this.setSize(0.6f, 0.6f);
        this.atlasRow = n2;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.ticksExisted >= 200 && piuf._c > this.lastRenderedFrame + 15L) {
            this.setDead();
        }
    }

    @Override
    protected void entityInit() {
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.sideHit = nBTTagCompound._f("side_hit");
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("side_hit", this.sideHit);
    }
}

