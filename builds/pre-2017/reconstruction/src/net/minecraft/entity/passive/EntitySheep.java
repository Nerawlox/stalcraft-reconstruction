/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.ai.ezfc;
import net.minecraft.entity.ai.ezhm;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.kjwj;
import net.minecraft.entity.ai.srli;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.ai.xpzm;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.kjui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class EntitySheep
extends EntityAnimal
implements IShearable {
    public final InventoryCrafting field_90016_e = new InventoryCrafting(new kjui(this), 2, 1);
    public static final float[][] fleeceColorTable = new float[][]{{1.0f, 1.0f, 1.0f}, {0.85f, 0.5f, 0.2f}, {0.7f, 0.3f, 0.85f}, {0.4f, 0.6f, 0.85f}, {0.9f, 0.9f, 0.2f}, {0.5f, 0.8f, 0.1f}, {0.95f, 0.5f, 0.65f}, {0.3f, 0.3f, 0.3f}, {0.6f, 0.6f, 0.6f}, {0.3f, 0.5f, 0.6f}, {0.5f, 0.25f, 0.7f}, {0.2f, 0.3f, 0.7f}, {0.4f, 0.3f, 0.2f}, {0.4f, 0.5f, 0.2f}, {0.6f, 0.2f, 0.2f}, {0.1f, 0.1f, 0.1f}};
    public int sheepTimer;
    public xpzm aiEatGrass = new xpzm(this);

    public EntitySheep(World world) {
        super(world);
        this.setSize(0.9f, 1.3f);
        this.getNavigator()._a(true);
        this.tasks._a(0, new tdpx(this));
        this.tasks._a(1, new kjwj(this, 1.25));
        this.tasks._a(2, new srli(this, 1.0));
        this.tasks._a(3, new ezhm(this, 1.1, Item.wheat.itemID, false));
        this.tasks._a(4, new ezfc(this, 1.1));
        this.tasks._a(5, this.aiEatGrass);
        this.tasks._a(6, new iurn(this, 1.0));
        this.tasks._a(7, new iurq(this, EntityPlayer.class, 6.0f));
        this.tasks._a(8, new tdmn(this));
        this.field_90016_e.setInventorySlotContents(0, new ItemStack(Item.dyePowder, 1, 0));
        this.field_90016_e.setInventorySlotContents(1, new ItemStack(Item.dyePowder, 1, 0));
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public void updateAITasks() {
        this.sheepTimer = this.aiEatGrass._a();
        super.updateAITasks();
    }

    @Override
    public void onLivingUpdate() {
        if (this.worldObj.isRemote) {
            this.sheepTimer = Math.max(0, this.sheepTimer - 1);
        }
        super.onLivingUpdate();
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._a)._a(8.0);
        this.getEntityAttribute(sajz._d)._a(0.23f);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, new Byte(0));
    }

    @Override
    public void dropFewItems(boolean bl, int n) {
        if (!this.getSheared()) {
            this.entityDropItem(new ItemStack(Block.cloth.blockID, 1, this.getFleeceColor()), 0.0f);
        }
    }

    @Override
    public int getDropItemId() {
        return Block.cloth.blockID;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void handleHealthUpdate(byte by) {
        if (by == 10) {
            this.sheepTimer = 40;
        } else {
            super.handleHealthUpdate(by);
        }
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        return super.interact(entityPlayer);
    }

    @SideOnly(value=Side.CLIENT)
    public float func_70894_j(float f) {
        return this.sheepTimer <= 0 ? 0.0f : (this.sheepTimer >= 4 && this.sheepTimer <= 36 ? 1.0f : (this.sheepTimer < 4 ? ((float)this.sheepTimer - f) / 4.0f : -((float)(this.sheepTimer - 40) - f) / 4.0f));
    }

    @SideOnly(value=Side.CLIENT)
    public float func_70890_k(float f) {
        if (this.sheepTimer > 4 && this.sheepTimer <= 36) {
            float f2 = ((float)(this.sheepTimer - 4) - f) / 32.0f;
            return 0.62831855f + 0.2199115f * sajh._a(f2 * 28.7f);
        }
        return this.sheepTimer > 0 ? 0.62831855f : this.rotationPitch / 57.295776f;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("Sheared", this.getSheared());
        nBTTagCompound._a("Color", (byte)this.getFleeceColor());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.setSheared(nBTTagCompound._o("Sheared"));
        this.setFleeceColor(nBTTagCompound._d("Color"));
    }

    @Override
    public String getLivingSound() {
        return "mob.sheep.say";
    }

    @Override
    public String getHurtSound() {
        return "mob.sheep.say";
    }

    @Override
    public String getDeathSound() {
        return "mob.sheep.say";
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.sheep.step", 0.15f, 1.0f);
    }

    public int getFleeceColor() {
        return this.dataWatcher._a(16) & 0xF;
    }

    public void setFleeceColor(int n) {
        byte by = this.dataWatcher._a(16);
        this.dataWatcher._b(16, (byte)(by & 0xF0 | n & 0xF));
    }

    public boolean getSheared() {
        return (this.dataWatcher._a(16) & 0x10) != 0;
    }

    public void setSheared(boolean bl) {
        byte by = this.dataWatcher._a(16);
        if (bl) {
            this.dataWatcher._b(16, (byte)(by | 0x10));
        } else {
            this.dataWatcher._b(16, (byte)(by & 0xFFFFFFEF));
        }
    }

    public static int getRandomFleeceColor(Random random) {
        int n = random.nextInt(100);
        return n < 5 ? 15 : (n < 10 ? 7 : (n < 15 ? 8 : (n < 18 ? 12 : (random.nextInt(500) == 0 ? 6 : 0))));
    }

    public EntitySheep func_90015_b(EntityAgeable entityAgeable) {
        EntitySheep entitySheep = (EntitySheep)entityAgeable;
        EntitySheep entitySheep2 = new EntitySheep(this.worldObj);
        int n = this.func_90014_a(this, entitySheep);
        entitySheep2.setFleeceColor(15 - n);
        return entitySheep2;
    }

    @Override
    public void eatGrassBonus() {
        this.setSheared(false);
        if (this.isChild()) {
            this.addGrowth(60);
        }
    }

    @Override
    public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
        entityLivingData = super.onSpawnWithEgg(entityLivingData);
        this.setFleeceColor(EntitySheep.getRandomFleeceColor(this.worldObj.rand));
        return entityLivingData;
    }

    public int func_90014_a(EntityAnimal entityAnimal, EntityAnimal entityAnimal2) {
        int n = this.func_90013_b(entityAnimal);
        int n2 = this.func_90013_b(entityAnimal2);
        this.field_90016_e.getStackInSlot(0)._b(n);
        this.field_90016_e.getStackInSlot(1)._b(n2);
        ItemStack itemStack = CraftingManager._a()._a(this.field_90016_e, ((EntitySheep)entityAnimal).worldObj);
        int n3 = itemStack != null && itemStack._a().itemID == Item.dyePowder.itemID ? itemStack._j() : (this.worldObj.rand.nextBoolean() ? n : n2);
        return n3;
    }

    public int func_90013_b(EntityAnimal entityAnimal) {
        return 15 - ((EntitySheep)entityAnimal).getFleeceColor();
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entityAgeable) {
        return this.func_90015_b(entityAgeable);
    }

    @Override
    public boolean isShearable(ItemStack itemStack, World world, int n, int n2, int n3) {
        return !this.getSheared() && !this.isChild();
    }

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack itemStack, World world, int n, int n2, int n3, int n4) {
        ArrayList<ItemStack> arrayList = new ArrayList<ItemStack>();
        this.setSheared(true);
        int n5 = 1 + this.rand.nextInt(3);
        for (int i = 0; i < n5; ++i) {
            arrayList.add(new ItemStack(Block.cloth.blockID, 1, this.getFleeceColor()));
        }
        this.worldObj.playSoundAtEntity(this, "mob.sheep.shear", 1.0f, 1.0f);
        return arrayList;
    }
}

