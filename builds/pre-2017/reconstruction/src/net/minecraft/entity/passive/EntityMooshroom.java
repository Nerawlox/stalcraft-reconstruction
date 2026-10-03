/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class EntityMooshroom
extends EntityCow
implements IShearable {
    public EntityMooshroom(World world) {
        super(world);
        this.setSize(0.9f, 1.3f);
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack != null && itemStack._d == Item.bowlEmpty.itemID && this.getGrowingAge() >= 0) {
            if (itemStack._b == 1) {
                entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, new ItemStack(Item.bowlSoup));
                return true;
            }
            if (entityPlayer.inventory._c(new ItemStack(Item.bowlSoup)) && !entityPlayer.capabilities._d) {
                entityPlayer.inventory.decrStackSize(entityPlayer.inventory._c, 1);
                return true;
            }
        }
        return super.interact(entityPlayer);
    }

    public EntityMooshroom func_94900_c(EntityAgeable entityAgeable) {
        return new EntityMooshroom(this.worldObj);
    }

    @Override
    public EntityCow spawnBabyAnimal(EntityAgeable entityAgeable) {
        return this.func_94900_c(entityAgeable);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entityAgeable) {
        return this.func_94900_c(entityAgeable);
    }

    @Override
    public boolean isShearable(ItemStack itemStack, World world, int n, int n2, int n3) {
        return this.getGrowingAge() >= 0;
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack itemStack, World world, int n, int n2, int n3, int n4) {
        this.setDead();
        EntityCow entityCow = new EntityCow(this.worldObj);
        entityCow.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        entityCow.setHealth(this.getHealth());
        entityCow.renderYawOffset = this.renderYawOffset;
        this.worldObj.spawnEntityInWorld(entityCow);
        this.worldObj.spawnParticle("largeexplode", this.posX, this.posY + (double)(this.height / 2.0f), this.posZ, 0.0, 0.0, 0.0);
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        for (int i = 0; i < 5; ++i) {
            arrayList.add(new ItemStack(Block.mushroomRed));
        }
        return arrayList;
    }
}

