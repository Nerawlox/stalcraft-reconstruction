/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.projectile;

import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPotion
extends EntityThrowable {
    public ItemStack potionDamage;

    public EntityPotion(World world) {
        super(world);
    }

    public EntityPotion(World world, EntityLivingBase entityLivingBase, int n) {
        this(world, entityLivingBase, new ItemStack(Item.potion, 1, n));
    }

    public EntityPotion(World world, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        super(world, entityLivingBase);
        this.potionDamage = itemStack;
    }

    public EntityPotion(World world, double d, double d2, double d3, int n) {
        this(world, d, d2, d3, new ItemStack(Item.potion, 1, n));
    }

    public EntityPotion(World world, double d, double d2, double d3, ItemStack itemStack) {
        super(world, d, d2, d3);
        this.potionDamage = itemStack;
    }

    @Override
    public float getGravityVelocity() {
        return 0.05f;
    }

    @Override
    public float func_70182_d() {
        return 0.5f;
    }

    @Override
    public float func_70183_g() {
        return -20.0f;
    }

    public void setPotionDamage(int n) {
        if (this.potionDamage == null) {
            this.potionDamage = new ItemStack(Item.potion, 1, 0);
        }
        this.potionDamage._b(n);
    }

    public int getPotionDamage() {
        if (this.potionDamage == null) {
            this.potionDamage = new ItemStack(Item.potion, 1, 0);
        }
        return this.potionDamage._j();
    }

    @Override
    public void onImpact(MovingObjectPosition movingObjectPosition) {
        if (!this.worldObj.isRemote) {
            AxisAlignedBB axisAlignedBB;
            List list2;
            List list3 = Item.potion._a(this.potionDamage);
            if (list3 != null && !list3.isEmpty() && (list2 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisAlignedBB = this.boundingBox._b(4.0, 2.0, 4.0))) != null && !list2.isEmpty()) {
                for (EntityLivingBase entityLivingBase : list2) {
                    double d = this.getDistanceSqToEntity(entityLivingBase);
                    if (!(d < 16.0)) continue;
                    double d2 = 1.0 - Math.sqrt(d) / 4.0;
                    if (entityLivingBase == movingObjectPosition._i) {
                        d2 = 1.0;
                    }
                    for (PotionEffect potionEffect : list3) {
                        int n = potionEffect._a();
                        if (Potion._a[n]._b()) {
                            Potion._a[n]._a(this.getThrower(), entityLivingBase, potionEffect._c(), d2);
                            continue;
                        }
                        int n2 = (int)(d2 * (double)potionEffect._b() + 0.5);
                        if (n2 <= 20) continue;
                        entityLivingBase.addPotionEffect(new PotionEffect(n, n2, potionEffect._c()));
                    }
                }
            }
            this.worldObj.playAuxSFX(2002, (int)Math.round(this.posX), (int)Math.round(this.posY), (int)Math.round(this.posZ), this.getPotionDamage());
            this.setDead();
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        if (nBTTagCompound._c("Potion")) {
            this.potionDamage = ItemStack._a(nBTTagCompound._m("Potion"));
        } else {
            this.setPotionDamage(nBTTagCompound._f("potionValue"));
        }
        if (this.potionDamage == null) {
            this.setDead();
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        if (this.potionDamage != null) {
            nBTTagCompound._a("Potion", this.potionDamage._b(new NBTTagCompound()));
        }
    }
}

