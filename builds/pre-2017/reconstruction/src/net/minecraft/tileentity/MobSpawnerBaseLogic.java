/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.jgro;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.WeightedRandomMinecart;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.iurq;
import net.minecraft.world.World;

public abstract class MobSpawnerBaseLogic {
    public int _b = 20;
    public String _c = "Pig";
    public List _d;
    public WeightedRandomMinecart _e;
    public double _f;
    public double _g;
    public int _h = 200;
    public int _i = 800;
    public int _j = 4;
    public Entity _k;
    public int _l = 6;
    public int _m = 16;
    public int _n = 4;

    public String _e() {
        if (this._j() == null) {
            if (this._c.equals("Minecart")) {
                this._c = "MinecartRideable";
            }
            return this._c;
        }
        return this._j()._b;
    }

    public void _a(String string) {
        this._c = string;
    }

    public boolean _f() {
        return this._a().getClosestPlayer((double)this._b() + 0.5, (double)this._c() + 0.5, (double)this._d() + 0.5, this._m) != null;
    }

    public void _g() {
        if (!this._f()) {
            return;
        }
        if (this._a().isRemote) {
            double d = (float)this._b() + this._a().rand.nextFloat();
            double d2 = (float)this._c() + this._a().rand.nextFloat();
            double d3 = (float)this._d() + this._a().rand.nextFloat();
            this._a().spawnParticle("smoke", d, d2, d3, 0.0, 0.0, 0.0);
            this._a().spawnParticle("flame", d, d2, d3, 0.0, 0.0, 0.0);
            if (this._b > 0) {
                --this._b;
            }
            this._g = this._f;
            this._f = (this._f + (double)(1000.0f / ((float)this._b + 200.0f))) % 360.0;
        } else {
            if (this._b == -1) {
                this._h();
            }
            if (this._b > 0) {
                --this._b;
                return;
            }
            boolean bl = false;
            for (int i = 0; i < this._j; ++i) {
                Entity entity = jgro._a(this._e(), this._a());
                if (entity == null) {
                    return;
                }
                int n = this._a().getEntitiesWithinAABB(entity.getClass(), AxisAlignedBB._a()._a(this._b(), this._c(), this._d(), this._b() + 1, this._c() + 1, this._d() + 1)._b(this._n * 2, 4.0, this._n * 2)).size();
                if (n >= this._l) {
                    this._h();
                    return;
                }
                double d = (double)this._b() + (this._a().rand.nextDouble() - this._a().rand.nextDouble()) * (double)this._n;
                double d4 = this._c() + this._a().rand.nextInt(3) - 1;
                double d5 = (double)this._d() + (this._a().rand.nextDouble() - this._a().rand.nextDouble()) * (double)this._n;
                EntityLiving entityLiving = entity instanceof EntityLiving ? (EntityLiving)entity : null;
                entity.setLocationAndAngles(d, d4, d5, this._a().rand.nextFloat() * 360.0f, 0.0f);
                if (entityLiving != null && !entityLiving.getCanSpawnHere()) continue;
                this._a(entity);
                this._a().playAuxSFX(2004, this._b(), this._c(), this._d(), 0);
                if (entityLiving != null) {
                    entityLiving.spawnExplosionParticle();
                }
                bl = true;
            }
            if (bl) {
                this._h();
            }
        }
    }

    public Entity _a(Entity entity) {
        if (this._j() != null) {
            NBTBase nBTBase = new NBTTagCompound();
            entity.writeToNBTOptional((NBTTagCompound)nBTBase);
            for (NBTBase nBTBase2 : this._j()._a._d()) {
                nBTBase._a(nBTBase2._b(), nBTBase2._c());
            }
            entity.readFromNBT((NBTTagCompound)nBTBase);
            if (entity.worldObj != null) {
                entity.worldObj.spawnEntityInWorld(entity);
            }
            Object object = entity;
            while (nBTBase._c("Riding")) {
                NBTBase nBTBase2;
                nBTBase2 = nBTBase._m("Riding");
                Entity entity2 = jgro._a(((NBTTagCompound)nBTBase2)._j("id"), entity.worldObj);
                if (entity2 != null) {
                    NBTTagCompound nBTTagCompound = new NBTTagCompound();
                    entity2.writeToNBTOptional(nBTTagCompound);
                    for (NBTBase nBTBase3 : ((NBTTagCompound)nBTBase2)._d()) {
                        nBTTagCompound._a(nBTBase3._b(), nBTBase3._c());
                    }
                    entity2.readFromNBT(nBTTagCompound);
                    entity2.setLocationAndAngles(((Entity)object).posX, ((Entity)object).posY, ((Entity)object).posZ, ((Entity)object).rotationYaw, ((Entity)object).rotationPitch);
                    if (entity.worldObj != null) {
                        entity.worldObj.spawnEntityInWorld(entity2);
                    }
                    ((Entity)object).mountEntity(entity2);
                }
                object = entity2;
                nBTBase = nBTBase2;
            }
        } else if (entity instanceof EntityLivingBase && entity.worldObj != null) {
            ((EntityLiving)entity).onSpawnWithEgg(null);
            this._a().spawnEntityInWorld(entity);
        }
        return entity;
    }

    public void _h() {
        this._b = this._i <= this._h ? this._h : this._h + this._a().rand.nextInt(this._i - this._h);
        if (this._d != null && this._d.size() > 0) {
            this._a((WeightedRandomMinecart)iurq._a(this._a().rand, this._d));
        }
        this._a(1);
    }

    public void _a(NBTTagCompound nBTTagCompound) {
        this._c = nBTTagCompound._j("EntityId");
        this._b = nBTTagCompound._e("Delay");
        if (nBTTagCompound._c("SpawnPotentials")) {
            this._d = new ArrayList();
            NBTTagList nBTTagList = nBTTagCompound._n("SpawnPotentials");
            for (int i = 0; i < nBTTagList._d(); ++i) {
                this._d.add(new WeightedRandomMinecart(this, (NBTTagCompound)nBTTagList._b(i)));
            }
        } else {
            this._d = null;
        }
        if (nBTTagCompound._c("SpawnData")) {
            this._a(new WeightedRandomMinecart(this, nBTTagCompound._m("SpawnData"), this._c));
        } else {
            this._a((WeightedRandomMinecart)null);
        }
        if (nBTTagCompound._c("MinSpawnDelay")) {
            this._h = nBTTagCompound._e("MinSpawnDelay");
            this._i = nBTTagCompound._e("MaxSpawnDelay");
            this._j = nBTTagCompound._e("SpawnCount");
        }
        if (nBTTagCompound._c("MaxNearbyEntities")) {
            this._l = nBTTagCompound._e("MaxNearbyEntities");
            this._m = nBTTagCompound._e("RequiredPlayerRange");
        }
        if (nBTTagCompound._c("SpawnRange")) {
            this._n = nBTTagCompound._e("SpawnRange");
        }
        if (this._a() != null && this._a().isRemote) {
            this._k = null;
        }
    }

    public void _b(NBTTagCompound nBTTagCompound) {
        nBTTagCompound._a("EntityId", this._e());
        nBTTagCompound._a("Delay", (short)this._b);
        nBTTagCompound._a("MinSpawnDelay", (short)this._h);
        nBTTagCompound._a("MaxSpawnDelay", (short)this._i);
        nBTTagCompound._a("SpawnCount", (short)this._j);
        nBTTagCompound._a("MaxNearbyEntities", (short)this._l);
        nBTTagCompound._a("RequiredPlayerRange", (short)this._m);
        nBTTagCompound._a("SpawnRange", (short)this._n);
        if (this._j() != null) {
            nBTTagCompound._a("SpawnData", (NBTTagCompound)this._j()._a._c());
        }
        if (this._j() != null || this._d != null && this._d.size() > 0) {
            NBTTagList nBTTagList = new NBTTagList();
            if (this._d != null && this._d.size() > 0) {
                for (WeightedRandomMinecart weightedRandomMinecart : this._d) {
                    nBTTagList._a(weightedRandomMinecart._a());
                }
            } else {
                nBTTagList._a(this._j()._a());
            }
            nBTTagCompound._a("SpawnPotentials", nBTTagList);
        }
    }

    public Entity _i() {
        if (this._k == null) {
            Entity entity = jgro._a(this._e(), this._a());
            this._k = entity = this._a(entity);
        }
        return this._k;
    }

    public boolean _b(int n) {
        if (n == 1 && this._a().isRemote) {
            this._b = this._h;
            return true;
        }
        return false;
    }

    public WeightedRandomMinecart _j() {
        return this._e;
    }

    public void _a(WeightedRandomMinecart weightedRandomMinecart) {
        this._e = weightedRandomMinecart;
    }

    public abstract void _a(int var1);

    public abstract World _a();

    public abstract int _b();

    public abstract int _c();

    public abstract int _d();
}

