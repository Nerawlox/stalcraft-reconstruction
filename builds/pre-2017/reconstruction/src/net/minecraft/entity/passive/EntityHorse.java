/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.StepSound;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.ai.ezfc;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.kjwj;
import net.minecraft.entity.ai.srli;
import net.minecraft.entity.ai.srok;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.eidj;
import net.minecraft.entity.passive.pidb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;

public class EntityHorse
extends EntityAnimal
implements suea {
    public static final IEntitySelector horseBreedingSelector = new pidb();
    public static final Attribute horseJumpStrength = new RangedAttribute("horse.jumpStrength", 0.7, 0.0, 2.0)._a("Jump Strength")._a(true);
    public static final String[] horseArmorTextures = new String[]{null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png"};
    public static final String[] field_110273_bx = new String[]{"", "meo", "goo", "dio"};
    public static final int[] armorValues = new int[]{0, 5, 7, 11};
    public static final String[] horseTextures = new String[]{"textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png"};
    public static final String[] field_110269_bA = new String[]{"hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb"};
    public static final String[] horseMarkingTextures = new String[]{null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png"};
    public static final String[] field_110292_bC = new String[]{"", "wo_", "wmo", "wdo", "bdo"};
    public int eatingHaystackCounter;
    public int openMouthCounter;
    public int jumpRearingCounter;
    public int field_110278_bp;
    public int field_110279_bq;
    public boolean horseJumping;
    public AnimalChest horseChest;
    public boolean hasReproduced;
    public int temper;
    public float jumpPower;
    public boolean field_110294_bI;
    public float headLean;
    public float prevHeadLean;
    public float rearingAmount;
    public float prevRearingAmount;
    public float mouthOpenness;
    public float prevMouthOpenness;
    public int field_110285_bP;
    public String field_110286_bQ;
    public String[] field_110280_bR = new String[3];

    public EntityHorse(World world) {
        super(world);
        this.setSize(1.4f, 1.6f);
        this.isImmuneToFire = false;
        this.setChested(false);
        this.getNavigator()._a(true);
        this.tasks._a(0, new tdpx(this));
        this.tasks._a(1, new kjwj(this, 1.2));
        this.tasks._a(1, new srok(this, 1.2));
        this.tasks._a(2, new srli(this, 1.0));
        this.tasks._a(4, new ezfc(this, 1.0));
        this.tasks._a(6, new iurn(this, 0.7));
        this.tasks._a(7, new iurq(this, EntityPlayer.class, 6.0f));
        this.tasks._a(8, new tdmn(this));
        this.func_110226_cD();
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, (Object)0);
        this.dataWatcher._a(19, (Object)0);
        this.dataWatcher._a(20, (Object)0);
        this.dataWatcher._a(21, String.valueOf(""));
        this.dataWatcher._a(22, (Object)0);
    }

    public void setHorseType(int n) {
        this.dataWatcher._b(19, (byte)n);
        this.func_110230_cF();
    }

    public int getHorseType() {
        return this.dataWatcher._a(19);
    }

    public void setHorseVariant(int n) {
        this.dataWatcher._b(20, n);
        this.func_110230_cF();
    }

    public int getHorseVariant() {
        return this.dataWatcher._c(20);
    }

    @Override
    public String getEntityName() {
        if (this.hasCustomNameTag()) {
            return this.getCustomNameTag();
        }
        int n = this.getHorseType();
        switch (n) {
            default: {
                return net.minecraft.util.tdpx._a("entity.horse.name");
            }
            case 1: {
                return net.minecraft.util.tdpx._a("entity.donkey.name");
            }
            case 2: {
                return net.minecraft.util.tdpx._a("entity.mule.name");
            }
            case 4: {
                return net.minecraft.util.tdpx._a("entity.skeletonhorse.name");
            }
            case 3: 
        }
        return net.minecraft.util.tdpx._a("entity.zombiehorse.name");
    }

    public boolean getHorseWatchableBoolean(int n) {
        return (this.dataWatcher._c(16) & n) != 0;
    }

    public void setHorseWatchableBoolean(int n, boolean bl) {
        int n2 = this.dataWatcher._c(16);
        if (bl) {
            this.dataWatcher._b(16, n2 | n);
        } else {
            this.dataWatcher._b(16, n2 & ~n);
        }
    }

    public boolean isAdultHorse() {
        return !this.isChild();
    }

    public boolean isTame() {
        return this.getHorseWatchableBoolean(2);
    }

    public boolean func_110253_bW() {
        return this.isAdultHorse();
    }

    public String getOwnerName() {
        return this.dataWatcher._e(21);
    }

    public void setOwnerName(String string) {
        this.dataWatcher._b(21, string);
    }

    public float getHorseSize() {
        int n = this.getGrowingAge();
        if (n >= 0) {
            return 1.0f;
        }
        return 0.5f + (float)(-24000 - n) / -24000.0f * 0.5f;
    }

    @Override
    public void setScaleForAge(boolean bl) {
        if (bl) {
            this.setScale(this.getHorseSize());
        } else {
            this.setScale(1.0f);
        }
    }

    public boolean isHorseJumping() {
        return this.horseJumping;
    }

    public void setHorseTamed(boolean bl) {
        this.setHorseWatchableBoolean(2, bl);
    }

    public void setHorseJumping(boolean bl) {
        this.horseJumping = bl;
    }

    @Override
    public boolean allowLeashing() {
        return !this.func_110256_cu() && super.allowLeashing();
    }

    @Override
    public void func_142017_o(float f) {
        if (f > 6.0f && this.isEatingHaystack()) {
            this.setEatingHaystack(false);
        }
    }

    public boolean isChested() {
        return this.getHorseWatchableBoolean(8);
    }

    public int func_110241_cb() {
        return this.dataWatcher._c(22);
    }

    public int getHorseArmorIndex(ItemStack itemStack) {
        if (itemStack == null) {
            return 0;
        }
        if (itemStack._d == Item.horseArmorIron.itemID) {
            return 1;
        }
        if (itemStack._d == Item.horseArmorGold.itemID) {
            return 2;
        }
        if (itemStack._d == Item.horseArmorDiamond.itemID) {
            return 3;
        }
        return 0;
    }

    public boolean isEatingHaystack() {
        return this.getHorseWatchableBoolean(32);
    }

    public boolean isRearing() {
        return this.getHorseWatchableBoolean(64);
    }

    public boolean func_110205_ce() {
        return this.getHorseWatchableBoolean(16);
    }

    public boolean getHasReproduced() {
        return this.hasReproduced;
    }

    public void func_110236_r(int n) {
        this.dataWatcher._b(22, n);
        this.func_110230_cF();
    }

    public void func_110242_l(boolean bl) {
        this.setHorseWatchableBoolean(16, bl);
    }

    public void setChested(boolean bl) {
        this.setHorseWatchableBoolean(8, bl);
    }

    public void setHasReproduced(boolean bl) {
        this.hasReproduced = bl;
    }

    public void setHorseSaddled(boolean bl) {
        this.setHorseWatchableBoolean(4, bl);
    }

    public int getTemper() {
        return this.temper;
    }

    public void setTemper(int n) {
        this.temper = n;
    }

    public int increaseTemper(int n) {
        int n2 = sajh._a(this.getTemper() + n, 0, this.getMaxTemper());
        this.setTemper(n2);
        return n2;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        Entity entity = damageSource.getEntity();
        if (this.riddenByEntity != null && this.riddenByEntity.equals(entity)) {
            return false;
        }
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public int getTotalArmorValue() {
        return armorValues[this.func_110241_cb()];
    }

    @Override
    public boolean canBePushed() {
        return this.riddenByEntity == null;
    }

    public boolean prepareChunkForSpawn() {
        int n = sajh._c(this.posX);
        int n2 = sajh._c(this.posZ);
        this.worldObj.getBiomeGenForCoords(n, n2);
        return true;
    }

    public void dropChests() {
        if (this.worldObj.isRemote || !this.isChested()) {
            return;
        }
        this.dropItem(Block.chest.blockID, 1);
        this.setChested(false);
    }

    public void func_110266_cB() {
        this.openHorseMouth();
        this.worldObj.playSoundAtEntity(this, "eating", 1.0f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f);
    }

    @Override
    public void fall(float f) {
        int n;
        int n2;
        if (f > 1.0f) {
            this.playSound("mob.horse.land", 0.4f, 1.0f);
        }
        if ((n2 = sajh._f(f * 0.5f - 3.0f)) <= 0) {
            return;
        }
        this.attackEntityFrom(DamageSource.fall, n2);
        if (this.riddenByEntity != null) {
            this.riddenByEntity.attackEntityFrom(DamageSource.fall, n2);
        }
        if ((n = this.worldObj.getBlockId(sajh._c(this.posX), sajh._c(this.posY - 0.2 - (double)this.prevRotationYaw), sajh._c(this.posZ))) > 0) {
            StepSound stepSound = Block.blocksList[n].stepSound;
            this.worldObj.playSoundAtEntity(this, stepSound._d(), stepSound._a() * 0.5f, stepSound._b() * 0.75f);
        }
    }

    public int func_110225_cC() {
        int n = this.getHorseType();
        if (this.isChested() && (n == 1 || n == 2)) {
            return 17;
        }
        return 2;
    }

    public void func_110226_cD() {
        AnimalChest animalChest = this.horseChest;
        this.horseChest = new AnimalChest("HorseChest", this.func_110225_cC());
        this.horseChest._a(this.getEntityName());
        if (animalChest != null) {
            animalChest._b(this);
            int n = Math.min(animalChest.getSizeInventory(), this.horseChest.getSizeInventory());
            for (int i = 0; i < n; ++i) {
                ItemStack itemStack = animalChest.getStackInSlot(i);
                if (itemStack == null) continue;
                this.horseChest.setInventorySlotContents(i, itemStack._l());
            }
            animalChest = null;
        }
        this.horseChest._a(this);
        this.func_110232_cE();
    }

    public void func_110232_cE() {
        if (!this.worldObj.isRemote) {
            this.setHorseSaddled(this.horseChest.getStackInSlot(0) != null);
            if (this.func_110259_cr()) {
                this.func_110236_r(this.getHorseArmorIndex(this.horseChest.getStackInSlot(1)));
            }
        }
    }

    @Override
    public void onInventoryChanged(InventoryBasic inventoryBasic) {
        int n = this.func_110241_cb();
        boolean bl = this.isHorseSaddled();
        this.func_110232_cE();
        if (this.ticksExisted > 20) {
            if (n == 0 && n != this.func_110241_cb()) {
                this.playSound("mob.horse.armor", 0.5f, 1.0f);
            }
            if (!bl && this.isHorseSaddled()) {
                this.playSound("mob.horse.leather", 0.5f, 1.0f);
            }
        }
    }

    @Override
    public boolean getCanSpawnHere() {
        this.prepareChunkForSpawn();
        return super.getCanSpawnHere();
    }

    public EntityHorse getClosestHorse(Entity entity, double d) {
        double d2 = Double.MAX_VALUE;
        Entity entity2 = null;
        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(entity, entity.boundingBox._a(d, d, d), horseBreedingSelector);
        for (Entity entity3 : list) {
            double d3 = entity3.getDistanceSq(entity.posX, entity.posY, entity.posZ);
            if (!(d3 < d2)) continue;
            entity2 = entity3;
            d2 = d3;
        }
        return (EntityHorse)entity2;
    }

    public double getHorseJumpStrength() {
        return this.getEntityAttribute(horseJumpStrength)._e();
    }

    @Override
    public String getDeathSound() {
        this.openHorseMouth();
        int n = this.getHorseType();
        if (n == 3) {
            return "mob.horse.zombie.death";
        }
        if (n == 4) {
            return "mob.horse.skeleton.death";
        }
        if (n == 1 || n == 2) {
            return "mob.horse.donkey.death";
        }
        return "mob.horse.death";
    }

    @Override
    public int getDropItemId() {
        boolean bl = this.rand.nextInt(4) == 0;
        int n = this.getHorseType();
        if (n == 4) {
            return Item.bone.itemID;
        }
        if (n == 3) {
            if (bl) {
                return 0;
            }
            return Item.rottenFlesh.itemID;
        }
        return Item.leather.itemID;
    }

    @Override
    public String getHurtSound() {
        int n;
        this.openHorseMouth();
        if (this.rand.nextInt(3) == 0) {
            this.makeHorseRear();
        }
        if ((n = this.getHorseType()) == 3) {
            return "mob.horse.zombie.hit";
        }
        if (n == 4) {
            return "mob.horse.skeleton.hit";
        }
        if (n == 1 || n == 2) {
            return "mob.horse.donkey.hit";
        }
        return "mob.horse.hit";
    }

    public boolean isHorseSaddled() {
        return this.getHorseWatchableBoolean(4);
    }

    @Override
    public String getLivingSound() {
        int n;
        this.openHorseMouth();
        if (this.rand.nextInt(10) == 0 && !this.isMovementBlocked()) {
            this.makeHorseRear();
        }
        if ((n = this.getHorseType()) == 3) {
            return "mob.horse.zombie.idle";
        }
        if (n == 4) {
            return "mob.horse.skeleton.idle";
        }
        if (n == 1 || n == 2) {
            return "mob.horse.donkey.idle";
        }
        return "mob.horse.idle";
    }

    public String getAngrySoundName() {
        this.openHorseMouth();
        this.makeHorseRear();
        int n = this.getHorseType();
        if (n == 3 || n == 4) {
            return null;
        }
        if (n == 1 || n == 2) {
            return "mob.horse.donkey.angry";
        }
        return "mob.horse.angry";
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        StepSound stepSound = Block.blocksList[n4].stepSound;
        if (this.worldObj.getBlockId(n, n2 + 1, n3) == Block.snow.blockID) {
            stepSound = Block.snow.stepSound;
        }
        if (!Block.blocksList[n4].blockMaterial._d()) {
            int n5 = this.getHorseType();
            if (this.riddenByEntity != null && n5 != 1 && n5 != 2) {
                ++this.field_110285_bP;
                if (this.field_110285_bP > 5 && this.field_110285_bP % 3 == 0) {
                    this.playSound("mob.horse.gallop", stepSound._a() * 0.15f, stepSound._b());
                    if (n5 == 0 && this.rand.nextInt(10) == 0) {
                        this.playSound("mob.horse.breathe", stepSound._a() * 0.6f, stepSound._b());
                    }
                } else if (this.field_110285_bP <= 5) {
                    this.playSound("mob.horse.wood", stepSound._a() * 0.15f, stepSound._b());
                }
            } else if (stepSound == Block.soundWoodFootstep) {
                this.playSound("mob.horse.soft", stepSound._a() * 0.15f, stepSound._b());
            } else {
                this.playSound("mob.horse.wood", stepSound._a() * 0.15f, stepSound._b());
            }
        }
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap()._b(horseJumpStrength);
        this.getEntityAttribute(sajz._a)._a(53.0);
        this.getEntityAttribute(sajz._d)._a(0.225f);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 6;
    }

    public int getMaxTemper() {
        return 100;
    }

    @Override
    public float getSoundVolume() {
        return 0.8f;
    }

    @Override
    public int getTalkInterval() {
        return 400;
    }

    public boolean func_110239_cn() {
        return this.getHorseType() == 0 || this.func_110241_cb() > 0;
    }

    public void func_110230_cF() {
        this.field_110286_bQ = null;
    }

    public void setHorseTexturePaths() {
        int n;
        this.field_110286_bQ = "horse/";
        this.field_110280_bR[0] = null;
        this.field_110280_bR[1] = null;
        this.field_110280_bR[2] = null;
        int n2 = this.getHorseType();
        int n3 = this.getHorseVariant();
        if (n2 == 0) {
            n = n3 & 0xFF;
            int n4 = (n3 & 0xFF00) >> 8;
            this.field_110280_bR[0] = horseTextures[n];
            this.field_110286_bQ = this.field_110286_bQ + field_110269_bA[n];
            this.field_110280_bR[1] = horseMarkingTextures[n4];
            this.field_110286_bQ = this.field_110286_bQ + field_110292_bC[n4];
        } else {
            this.field_110280_bR[0] = "";
            this.field_110286_bQ = this.field_110286_bQ + "_" + n2 + "_";
        }
        n = this.func_110241_cb();
        this.field_110280_bR[2] = horseArmorTextures[n];
        this.field_110286_bQ = this.field_110286_bQ + field_110273_bx[n];
    }

    public String getHorseTexture() {
        if (this.field_110286_bQ == null) {
            this.setHorseTexturePaths();
        }
        return this.field_110286_bQ;
    }

    public String[] getVariantTexturePaths() {
        if (this.field_110286_bQ == null) {
            this.setHorseTexturePaths();
        }
        return this.field_110280_bR;
    }

    public void openGUI(EntityPlayer entityPlayer) {
        if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == entityPlayer) && this.isTame()) {
            this.horseChest._a(this.getEntityName());
            entityPlayer.displayGUIHorse(this, this.horseChest);
        }
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory._a();
        if (itemStack != null && itemStack._d == Item.monsterPlacer.itemID) {
            return super.interact(entityPlayer);
        }
        if (!this.isTame() && this.func_110256_cu()) {
            return false;
        }
        if (this.isTame() && this.isAdultHorse() && entityPlayer.isSneaking()) {
            this.openGUI(entityPlayer);
            return true;
        }
        if (this.func_110253_bW() && this.riddenByEntity != null) {
            return super.interact(entityPlayer);
        }
        if (itemStack != null) {
            boolean bl = false;
            if (this.func_110259_cr()) {
                int n = -1;
                if (itemStack._d == Item.horseArmorIron.itemID) {
                    n = 1;
                } else if (itemStack._d == Item.horseArmorGold.itemID) {
                    n = 2;
                } else if (itemStack._d == Item.horseArmorDiamond.itemID) {
                    n = 3;
                }
                if (n >= 0) {
                    if (!this.isTame()) {
                        this.makeHorseRearWithSound();
                        return true;
                    }
                    this.openGUI(entityPlayer);
                    return true;
                }
            }
            if (!bl && !this.func_110256_cu()) {
                float f = 0.0f;
                int n = 0;
                int n2 = 0;
                if (itemStack._d == Item.wheat.itemID) {
                    f = 2.0f;
                    n = 60;
                    n2 = 3;
                } else if (itemStack._d == Item.sugar.itemID) {
                    f = 1.0f;
                    n = 30;
                    n2 = 3;
                } else if (itemStack._d == Item.bread.itemID) {
                    f = 7.0f;
                    n = 180;
                    n2 = 3;
                } else if (itemStack._d == Block.hay.blockID) {
                    f = 20.0f;
                    n = 180;
                } else if (itemStack._d == Item.appleRed.itemID) {
                    f = 3.0f;
                    n = 60;
                    n2 = 3;
                } else if (itemStack._d == Item.goldenCarrot.itemID) {
                    f = 4.0f;
                    n = 60;
                    n2 = 5;
                    if (this.isTame() && this.getGrowingAge() == 0) {
                        bl = true;
                        this.func_110196_bT();
                    }
                } else if (itemStack._d == Item.appleGold.itemID) {
                    f = 10.0f;
                    n = 240;
                    n2 = 10;
                    if (this.isTame() && this.getGrowingAge() == 0) {
                        bl = true;
                        this.func_110196_bT();
                    }
                }
                if (this.getHealth() < this.getMaxHealth() && f > 0.0f) {
                    this.heal(f);
                    bl = true;
                }
                if (!this.isAdultHorse() && n > 0) {
                    this.addGrowth(n);
                    bl = true;
                }
                if (n2 > 0 && (bl || !this.isTame()) && n2 < this.getMaxTemper()) {
                    bl = true;
                    this.increaseTemper(n2);
                }
                if (bl) {
                    this.func_110266_cB();
                }
            }
            if (!this.isTame() && !bl) {
                if (itemStack != null && itemStack._a(entityPlayer, (EntityLivingBase)this)) {
                    return true;
                }
                this.makeHorseRearWithSound();
                return true;
            }
            if (!bl && this.func_110229_cs() && !this.isChested() && itemStack._d == Block.chest.blockID) {
                this.setChested(true);
                this.playSound("mob.chickenplop", 1.0f, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
                bl = true;
                this.func_110226_cD();
            }
            if (!bl && this.func_110253_bW() && !this.isHorseSaddled() && itemStack._d == Item.saddle.itemID) {
                this.openGUI(entityPlayer);
                return true;
            }
            if (bl) {
                if (!entityPlayer.capabilities._d && --itemStack._b == 0) {
                    entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
                }
                return true;
            }
        }
        if (this.func_110253_bW() && this.riddenByEntity == null) {
            if (itemStack != null && itemStack._a(entityPlayer, (EntityLivingBase)this)) {
                return true;
            }
            this.func_110237_h(entityPlayer);
            return true;
        }
        return super.interact(entityPlayer);
    }

    public void func_110237_h(EntityPlayer entityPlayer) {
        entityPlayer.rotationYaw = this.rotationYaw;
        entityPlayer.rotationPitch = this.rotationPitch;
        this.setEatingHaystack(false);
        this.setRearing(false);
        if (!this.worldObj.isRemote) {
            entityPlayer.mountEntity(this);
        }
    }

    public boolean func_110259_cr() {
        return this.getHorseType() == 0;
    }

    public boolean func_110229_cs() {
        int n = this.getHorseType();
        return n == 2 || n == 1;
    }

    @Override
    public boolean isMovementBlocked() {
        if (this.riddenByEntity != null && this.isHorseSaddled()) {
            return true;
        }
        return this.isEatingHaystack() || this.isRearing();
    }

    public boolean func_110256_cu() {
        int n = this.getHorseType();
        return n == 3 || n == 4;
    }

    public boolean func_110222_cv() {
        return this.func_110256_cu() || this.getHorseType() == 2;
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack) {
        return false;
    }

    public void func_110210_cH() {
        this.field_110278_bp = 1;
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        if (!this.worldObj.isRemote) {
            this.dropChestItems();
        }
    }

    @Override
    public void onLivingUpdate() {
        if (this.rand.nextInt(200) == 0) {
            this.func_110210_cH();
        }
        super.onLivingUpdate();
        if (!this.worldObj.isRemote) {
            EntityHorse entityHorse;
            if (this.rand.nextInt(900) == 0 && this.deathTime == 0) {
                this.heal(1.0f);
            }
            if (!this.isEatingHaystack() && this.riddenByEntity == null && this.rand.nextInt(300) == 0 && this.worldObj.getBlockId(sajh._c(this.posX), sajh._c(this.posY) - 1, sajh._c(this.posZ)) == Block.grass.blockID) {
                this.setEatingHaystack(true);
            }
            if (this.isEatingHaystack() && ++this.eatingHaystackCounter > 50) {
                this.eatingHaystackCounter = 0;
                this.setEatingHaystack(false);
            }
            if (this.func_110205_ce() && !this.isAdultHorse() && !this.isEatingHaystack() && (entityHorse = this.getClosestHorse(this, 16.0)) != null && this.getDistanceSqToEntity(entityHorse) > 4.0) {
                PathEntity pathEntity = this.worldObj.getPathEntityToEntity(this, entityHorse, 16.0f, true, false, false, true);
                this.setPathToEntity(pathEntity);
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (this.worldObj.isRemote && this.dataWatcher._a()) {
            this.dataWatcher._e();
            this.func_110230_cF();
        }
        if (this.openMouthCounter > 0 && ++this.openMouthCounter > 30) {
            this.openMouthCounter = 0;
            this.setHorseWatchableBoolean(128, false);
        }
        if (!this.worldObj.isRemote && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20) {
            this.jumpRearingCounter = 0;
            this.setRearing(false);
        }
        if (this.field_110278_bp > 0 && ++this.field_110278_bp > 8) {
            this.field_110278_bp = 0;
        }
        if (this.field_110279_bq > 0) {
            ++this.field_110279_bq;
            if (this.field_110279_bq > 300) {
                this.field_110279_bq = 0;
            }
        }
        this.prevHeadLean = this.headLean;
        if (this.isEatingHaystack()) {
            this.headLean += (1.0f - this.headLean) * 0.4f + 0.05f;
            if (this.headLean > 1.0f) {
                this.headLean = 1.0f;
            }
        } else {
            this.headLean += (0.0f - this.headLean) * 0.4f - 0.05f;
            if (this.headLean < 0.0f) {
                this.headLean = 0.0f;
            }
        }
        this.prevRearingAmount = this.rearingAmount;
        if (this.isRearing()) {
            this.headLean = 0.0f;
            this.prevHeadLean = 0.0f;
            this.rearingAmount += (1.0f - this.rearingAmount) * 0.4f + 0.05f;
            if (this.rearingAmount > 1.0f) {
                this.rearingAmount = 1.0f;
            }
        } else {
            this.field_110294_bI = false;
            this.rearingAmount += (0.8f * this.rearingAmount * this.rearingAmount * this.rearingAmount - this.rearingAmount) * 0.6f - 0.05f;
            if (this.rearingAmount < 0.0f) {
                this.rearingAmount = 0.0f;
            }
        }
        this.prevMouthOpenness = this.mouthOpenness;
        if (this.getHorseWatchableBoolean(128)) {
            this.mouthOpenness += (1.0f - this.mouthOpenness) * 0.7f + 0.05f;
            if (this.mouthOpenness > 1.0f) {
                this.mouthOpenness = 1.0f;
            }
        } else {
            this.mouthOpenness += (0.0f - this.mouthOpenness) * 0.7f - 0.05f;
            if (this.mouthOpenness < 0.0f) {
                this.mouthOpenness = 0.0f;
            }
        }
    }

    public void openHorseMouth() {
        if (!this.worldObj.isRemote) {
            this.openMouthCounter = 1;
            this.setHorseWatchableBoolean(128, true);
        }
    }

    public boolean func_110200_cJ() {
        return this.riddenByEntity == null && this.ridingEntity == null && this.isTame() && this.isAdultHorse() && !this.func_110222_cv() && this.getHealth() >= this.getMaxHealth();
    }

    @Override
    public void setEating(boolean bl) {
        this.setHorseWatchableBoolean(32, bl);
    }

    public void setEatingHaystack(boolean bl) {
        this.setEating(bl);
    }

    public void setRearing(boolean bl) {
        if (bl) {
            this.setEatingHaystack(false);
        }
        this.setHorseWatchableBoolean(64, bl);
    }

    public void makeHorseRear() {
        if (!this.worldObj.isRemote) {
            this.jumpRearingCounter = 1;
            this.setRearing(true);
        }
    }

    public void makeHorseRearWithSound() {
        this.makeHorseRear();
        String string = this.getAngrySoundName();
        if (string != null) {
            this.playSound(string, this.getSoundVolume(), this.getSoundPitch());
        }
    }

    public void dropChestItems() {
        this.dropItemsInChest(this, this.horseChest);
        this.dropChests();
    }

    public void dropItemsInChest(Entity entity, AnimalChest animalChest) {
        if (animalChest == null || this.worldObj.isRemote) {
            return;
        }
        for (int i = 0; i < animalChest.getSizeInventory(); ++i) {
            ItemStack itemStack = animalChest.getStackInSlot(i);
            if (itemStack == null) continue;
            this.entityDropItem(itemStack, 0.0f);
        }
    }

    public boolean setTamedBy(EntityPlayer entityPlayer) {
        this.setOwnerName(entityPlayer.getCommandSenderName());
        this.setHorseTamed(true);
        return true;
    }

    @Override
    public void moveEntityWithHeading(float f, float f2) {
        if (this.riddenByEntity == null || !this.isHorseSaddled()) {
            this.stepHeight = 0.5f;
            this.jumpMovementFactor = 0.02f;
            super.moveEntityWithHeading(f, f2);
            return;
        }
        this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
        this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5f;
        this.setRotation(this.rotationYaw, this.rotationPitch);
        this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
        f = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5f;
        f2 = ((EntityLivingBase)this.riddenByEntity).moveForward;
        if (f2 <= 0.0f) {
            f2 *= 0.25f;
            this.field_110285_bP = 0;
        }
        if (this.onGround && this.jumpPower == 0.0f && this.isRearing() && !this.field_110294_bI) {
            f = 0.0f;
            f2 = 0.0f;
        }
        if (this.jumpPower > 0.0f && !this.isHorseJumping() && this.onGround) {
            this.motionY = this.getHorseJumpStrength() * (double)this.jumpPower;
            if (this.isPotionActive(Potion._j)) {
                this.motionY += (double)((float)(this.getActivePotionEffect(Potion._j)._c() + 1) * 0.1f);
            }
            this.setHorseJumping(true);
            this.isAirBorne = true;
            if (f2 > 0.0f) {
                float f3 = sajh._a(this.rotationYaw * (float)Math.PI / 180.0f);
                float f4 = sajh._b(this.rotationYaw * (float)Math.PI / 180.0f);
                this.motionX += (double)(-0.4f * f3 * this.jumpPower);
                this.motionZ += (double)(0.4f * f4 * this.jumpPower);
                this.playSound("mob.horse.jump", 0.4f, 1.0f);
            }
            this.jumpPower = 0.0f;
        }
        this.stepHeight = 1.0f;
        this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1f;
        if (!this.worldObj.isRemote) {
            this.setAIMoveSpeed((float)this.getEntityAttribute(sajz._d)._e());
            super.moveEntityWithHeading(f, f2);
        }
        if (this.onGround) {
            this.jumpPower = 0.0f;
            this.setHorseJumping(false);
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d = this.posX - this.prevPosX;
        double d2 = this.posZ - this.prevPosZ;
        float f5 = sajh._a(d * d + d2 * d2) * 4.0f;
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        this.limbSwingAmount += (f5 - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwingAmount;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("EatingHaystack", this.isEatingHaystack());
        nBTTagCompound._a("ChestedHorse", this.isChested());
        nBTTagCompound._a("HasReproduced", this.getHasReproduced());
        nBTTagCompound._a("Bred", this.func_110205_ce());
        nBTTagCompound._a("Type", this.getHorseType());
        nBTTagCompound._a("Variant", this.getHorseVariant());
        nBTTagCompound._a("Temper", this.getTemper());
        nBTTagCompound._a("Tame", this.isTame());
        nBTTagCompound._a("OwnerName", this.getOwnerName());
        if (this.isChested()) {
            NBTTagList nBTTagList = new NBTTagList();
            for (int i = 2; i < this.horseChest.getSizeInventory(); ++i) {
                ItemStack itemStack = this.horseChest.getStackInSlot(i);
                if (itemStack == null) continue;
                NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
                nBTTagCompound2._a("Slot", (byte)i);
                itemStack._b(nBTTagCompound2);
                nBTTagList._a(nBTTagCompound2);
            }
            nBTTagCompound._a("Items", nBTTagList);
        }
        if (this.horseChest.getStackInSlot(1) != null) {
            nBTTagCompound._a("ArmorItem", (NBTBase)this.horseChest.getStackInSlot(1)._b(new NBTTagCompound("ArmorItem")));
        }
        if (this.horseChest.getStackInSlot(0) != null) {
            nBTTagCompound._a("SaddleItem", (NBTBase)this.horseChest.getStackInSlot(0)._b(new NBTTagCompound("SaddleItem")));
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        Object object;
        hubf hubf2;
        super.readEntityFromNBT(nBTTagCompound);
        this.setEatingHaystack(nBTTagCompound._o("EatingHaystack"));
        this.func_110242_l(nBTTagCompound._o("Bred"));
        this.setChested(nBTTagCompound._o("ChestedHorse"));
        this.setHasReproduced(nBTTagCompound._o("HasReproduced"));
        this.setHorseType(nBTTagCompound._f("Type"));
        this.setHorseVariant(nBTTagCompound._f("Variant"));
        this.setTemper(nBTTagCompound._f("Temper"));
        this.setHorseTamed(nBTTagCompound._o("Tame"));
        if (nBTTagCompound._c("OwnerName")) {
            this.setOwnerName(nBTTagCompound._j("OwnerName"));
        }
        if ((hubf2 = this.getAttributeMap()._a("Speed")) != null) {
            this.getEntityAttribute(sajz._d)._a(hubf2._b() * 0.25);
        }
        if (this.isChested()) {
            object = nBTTagCompound._n("Items");
            this.func_110226_cD();
            for (int i = 0; i < ((NBTTagList)object)._d(); ++i) {
                NBTTagCompound nBTTagCompound2 = (NBTTagCompound)((NBTTagList)object)._b(i);
                int n = nBTTagCompound2._d("Slot") & 0xFF;
                if (n < 2 || n >= this.horseChest.getSizeInventory()) continue;
                this.horseChest.setInventorySlotContents(n, ItemStack._a(nBTTagCompound2));
            }
        }
        if (nBTTagCompound._c("ArmorItem") && (object = ItemStack._a(nBTTagCompound._m("ArmorItem"))) != null && EntityHorse.func_110211_v(((ItemStack)object)._d)) {
            this.horseChest.setInventorySlotContents(1, (ItemStack)object);
        }
        if (nBTTagCompound._c("SaddleItem")) {
            object = ItemStack._a(nBTTagCompound._m("SaddleItem"));
            if (object != null && ((ItemStack)object)._d == Item.saddle.itemID) {
                this.horseChest.setInventorySlotContents(0, (ItemStack)object);
            }
        } else if (nBTTagCompound._o("Saddle")) {
            this.horseChest.setInventorySlotContents(0, new ItemStack(Item.saddle));
        }
        this.func_110232_cE();
    }

    @Override
    public boolean canMateWith(EntityAnimal entityAnimal) {
        int n;
        if (entityAnimal == this) {
            return false;
        }
        if (entityAnimal.getClass() != this.getClass()) {
            return false;
        }
        EntityHorse entityHorse = (EntityHorse)entityAnimal;
        if (!this.func_110200_cJ() || !entityHorse.func_110200_cJ()) {
            return false;
        }
        int n2 = this.getHorseType();
        return n2 == (n = entityHorse.getHorseType()) || n2 == 0 && n == 1 || n2 == 1 && n == 0;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entityAgeable) {
        EntityHorse entityHorse = (EntityHorse)entityAgeable;
        EntityHorse entityHorse2 = new EntityHorse(this.worldObj);
        int n = this.getHorseType();
        int n2 = entityHorse.getHorseType();
        int n3 = 0;
        if (n == n2) {
            n3 = n;
        } else if (n == 0 && n2 == 1 || n == 1 && n2 == 0) {
            n3 = 2;
        }
        if (n3 == 0) {
            int n4 = this.rand.nextInt(9);
            int n5 = n4 < 4 ? this.getHorseVariant() & 0xFF : (n4 < 8 ? entityHorse.getHorseVariant() & 0xFF : this.rand.nextInt(7));
            int n6 = this.rand.nextInt(5);
            n5 = n6 < 4 ? (n5 |= this.getHorseVariant() & 0xFF00) : (n6 < 8 ? (n5 |= entityHorse.getHorseVariant() & 0xFF00) : (n5 |= this.rand.nextInt(5) << 8 & 0xFF00));
            entityHorse2.setHorseVariant(n5);
        }
        entityHorse2.setHorseType(n3);
        double d = this.getEntityAttribute(sajz._a)._b() + entityAgeable.getEntityAttribute(sajz._a)._b() + (double)this.func_110267_cL();
        entityHorse2.getEntityAttribute(sajz._a)._a(d / 3.0);
        double d2 = this.getEntityAttribute(horseJumpStrength)._b() + entityAgeable.getEntityAttribute(horseJumpStrength)._b() + this.func_110245_cM();
        entityHorse2.getEntityAttribute(horseJumpStrength)._a(d2 / 3.0);
        double d3 = this.getEntityAttribute(sajz._d)._b() + entityAgeable.getEntityAttribute(sajz._d)._b() + this.func_110203_cN();
        entityHorse2.getEntityAttribute(sajz._d)._a(d3 / 3.0);
        return entityHorse2;
    }

    @Override
    public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
        entityLivingData = super.onSpawnWithEgg(entityLivingData);
        int n = 0;
        int n2 = 0;
        if (entityLivingData instanceof eidj) {
            n = ((eidj)entityLivingData)._a;
            n2 = ((eidj)entityLivingData)._b & 0xFF | this.rand.nextInt(5) << 8;
        } else {
            if (this.rand.nextInt(10) == 0) {
                n = 1;
            } else {
                int n3 = this.rand.nextInt(7);
                int n4 = this.rand.nextInt(5);
                n = 0;
                n2 = n3 | n4 << 8;
            }
            entityLivingData = new eidj(n, n2);
        }
        this.setHorseType(n);
        this.setHorseVariant(n2);
        if (this.rand.nextInt(5) == 0) {
            this.setGrowingAge(-24000);
        }
        if (n == 4 || n == 3) {
            this.getEntityAttribute(sajz._a)._a(15.0);
            this.getEntityAttribute(sajz._d)._a(0.2f);
        } else {
            this.getEntityAttribute(sajz._a)._a(this.func_110267_cL());
            if (n == 0) {
                this.getEntityAttribute(sajz._d)._a(this.func_110203_cN());
            } else {
                this.getEntityAttribute(sajz._d)._a(0.175f);
            }
        }
        if (n == 2 || n == 1) {
            this.getEntityAttribute(horseJumpStrength)._a(0.5);
        } else {
            this.getEntityAttribute(horseJumpStrength)._a(this.func_110245_cM());
        }
        this.setHealth(this.getMaxHealth());
        return entityLivingData;
    }

    public float getGrassEatingAmount(float f) {
        return this.prevHeadLean + (this.headLean - this.prevHeadLean) * f;
    }

    public float getRearingAmount(float f) {
        return this.prevRearingAmount + (this.rearingAmount - this.prevRearingAmount) * f;
    }

    public float func_110201_q(float f) {
        return this.prevMouthOpenness + (this.mouthOpenness - this.prevMouthOpenness) * f;
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    public void setJumpPower(int n) {
        if (this.isHorseSaddled()) {
            if (n < 0) {
                n = 0;
            } else {
                this.field_110294_bI = true;
                this.makeHorseRear();
            }
            this.jumpPower = n >= 90 ? 1.0f : 0.4f + 0.4f * (float)n / 90.0f;
        }
    }

    public void spawnHorseParticles(boolean bl) {
        String string = bl ? "heart" : "smoke";
        for (int i = 0; i < 7; ++i) {
            double d = this.rand.nextGaussian() * 0.02;
            double d2 = this.rand.nextGaussian() * 0.02;
            double d3 = this.rand.nextGaussian() * 0.02;
            this.worldObj.spawnParticle(string, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + 0.5 + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d, d2, d3);
        }
    }

    @Override
    public void handleHealthUpdate(byte by) {
        if (by == 7) {
            this.spawnHorseParticles(true);
        } else if (by == 6) {
            this.spawnHorseParticles(false);
        } else {
            super.handleHealthUpdate(by);
        }
    }

    @Override
    public void updateRiderPosition() {
        super.updateRiderPosition();
        if (this.prevRearingAmount > 0.0f) {
            float f = sajh._a(this.renderYawOffset * (float)Math.PI / 180.0f);
            float f2 = sajh._b(this.renderYawOffset * (float)Math.PI / 180.0f);
            float f3 = 0.7f * this.prevRearingAmount;
            float f4 = 0.15f * this.prevRearingAmount;
            this.riddenByEntity.setPosition(this.posX + (double)(f3 * f), this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + (double)f4, this.posZ - (double)(f3 * f2));
            if (this.riddenByEntity instanceof EntityLivingBase) {
                ((EntityLivingBase)this.riddenByEntity).renderYawOffset = this.renderYawOffset;
            }
        }
    }

    public float func_110267_cL() {
        return 15.0f + (float)this.rand.nextInt(8) + (float)this.rand.nextInt(9);
    }

    public double func_110245_cM() {
        return (double)0.4f + this.rand.nextDouble() * 0.2 + this.rand.nextDouble() * 0.2 + this.rand.nextDouble() * 0.2;
    }

    public double func_110203_cN() {
        return ((double)0.45f + this.rand.nextDouble() * 0.3 + this.rand.nextDouble() * 0.3 + this.rand.nextDouble() * 0.3) * 0.25;
    }

    public static boolean func_110211_v(int n) {
        return n == Item.horseArmorIron.itemID || n == Item.horseArmorGold.itemID || n == Item.horseArmorDiamond.itemID;
    }

    @Override
    public boolean isOnLadder() {
        return false;
    }
}

