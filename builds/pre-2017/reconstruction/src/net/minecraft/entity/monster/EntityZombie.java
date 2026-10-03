/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.monster;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.amxi;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.ai.dwan;
import net.minecraft.entity.ai.ezfa;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.jgro;
import net.minecraft.entity.ai.pibk;
import net.minecraft.entity.ai.pidb;
import net.minecraft.entity.ai.tdmn;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.kjui;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.sajh;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDummyContainer;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.living.ZombieEvent;

public class EntityZombie
extends EntityMob {
    public static final Attribute field_110186_bp = new RangedAttribute("zombie.spawnReinforcements", 0.0, 0.0, 1.0)._a("Spawn Reinforcements Chance");
    public static final UUID babySpeedBoostUUID = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
    public static final AttributeModifier babySpeedBoostModifier = new AttributeModifier(babySpeedBoostUUID, "Baby speed boost", 0.5, 1);
    public int conversionTime;

    public EntityZombie(World world) {
        super(world);
        this.getNavigator()._b(true);
        this.tasks._a(0, new tdpx(this));
        this.tasks._a(1, new jgro(this));
        this.tasks._a(2, new pidb(this, EntityPlayer.class, 1.0, false));
        this.tasks._a(3, new pidb(this, EntityVillager.class, 1.0, true));
        this.tasks._a(4, new amxi(this, 1.0));
        this.tasks._a(5, new dwan(this, 1.0, false));
        this.tasks._a(6, new iurn(this, 1.0));
        this.tasks._a(7, new iurq(this, EntityPlayer.class, 8.0f));
        this.tasks._a(7, new tdmn(this));
        this.targetTasks._a(1, new ezfa(this, true));
        this.targetTasks._a(2, new pibk(this, EntityPlayer.class, 0, true));
        this.targetTasks._a(2, new pibk(this, EntityVillager.class, 0, false));
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._b)._a(40.0);
        this.getEntityAttribute(sajz._d)._a(0.23f);
        this.getEntityAttribute(sajz._e)._a(3.0);
        this.getAttributeMap()._b(field_110186_bp)._a(this.rand.nextDouble() * ForgeDummyContainer.zombieSummonBaseChance);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.getDataWatcher()._a(12, (Object)0);
        this.getDataWatcher()._a(13, (Object)0);
        this.getDataWatcher()._a(14, (Object)0);
    }

    @Override
    public int getTotalArmorValue() {
        int n = super.getTotalArmorValue() + 2;
        if (n > 20) {
            n = 20;
        }
        return n;
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public boolean isChild() {
        return this.getDataWatcher()._a(12) == 1;
    }

    public void setChild(boolean bl) {
        this.getDataWatcher()._b(12, (byte)(bl ? 1 : 0));
        if (this.worldObj != null && !this.worldObj.isRemote) {
            hubf hubf2 = this.getEntityAttribute(sajz._d);
            hubf2._b(babySpeedBoostModifier);
            if (bl) {
                hubf2._a(babySpeedBoostModifier);
            }
        }
    }

    public boolean isVillager() {
        return this.getDataWatcher()._a(13) == 1;
    }

    public void setVillager(boolean bl) {
        this.getDataWatcher()._b(13, (byte)(bl ? 1 : 0));
    }

    @Override
    public void onLivingUpdate() {
        float f;
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild() && (f = this.getBrightness(1.0f)) > 0.5f && this.rand.nextFloat() * 30.0f < (f - 0.4f) * 2.0f && this.worldObj.canBlockSeeTheSky(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ))) {
            boolean bl = true;
            ItemStack itemStack = this.func_71124_b(4);
            if (itemStack != null) {
                if (itemStack._f()) {
                    itemStack._b(itemStack._i() + this.rand.nextInt(2));
                    if (itemStack._i() >= itemStack._k()) {
                        this.renderBrokenItemStack(itemStack);
                        this.setCurrentItemOrArmor(4, null);
                    }
                }
                bl = false;
            }
            if (bl) {
                this.setFire(8);
            }
        }
        super.onLivingUpdate();
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        int n;
        int n2;
        int n3;
        ZombieEvent.SummonAidEvent summonAidEvent;
        if (!super.attackEntityFrom(damageSource, f)) {
            return false;
        }
        EntityLivingBase entityLivingBase = this.getAttackTarget();
        if (entityLivingBase == null && this.getEntityToAttack() instanceof EntityLivingBase) {
            entityLivingBase = (EntityLivingBase)this.getEntityToAttack();
        }
        if (entityLivingBase == null && damageSource.getEntity() instanceof EntityLivingBase) {
            entityLivingBase = (EntityLivingBase)damageSource.getEntity();
        }
        if ((summonAidEvent = ForgeEventFactory.fireZombieSummonAid(this, this.worldObj, n3 = sajh._c(this.posX), n2 = sajh._c(this.posY), n = sajh._c(this.posZ), entityLivingBase, this.getEntityAttribute(field_110186_bp)._e())).getResult() == Event.Result.DENY) {
            return true;
        }
        if (summonAidEvent.getResult() == Event.Result.ALLOW || entityLivingBase != null && this.worldObj.difficultySetting >= 3 && (double)this.rand.nextFloat() < this.getEntityAttribute(field_110186_bp)._e()) {
            EntityZombie entityZombie = summonAidEvent.customSummonedAid != null && summonAidEvent.getResult() == Event.Result.ALLOW ? summonAidEvent.customSummonedAid : new EntityZombie(this.worldObj);
            for (int i = 0; i < 50; ++i) {
                int n4;
                int n5;
                int n6 = n3 + sajh._a(this.rand, 7, 40) * sajh._a(this.rand, -1, 1);
                if (!this.worldObj.doesBlockHaveSolidTopSurface(n6, (n5 = n2 + sajh._a(this.rand, 7, 40) * sajh._a(this.rand, -1, 1)) - 1, n4 = n + sajh._a(this.rand, 7, 40) * sajh._a(this.rand, -1, 1)) || this.worldObj.getBlockLightValue(n6, n5, n4) >= 10) continue;
                entityZombie.setPosition(n6, n5, n4);
                if (!this.worldObj.checkNoEntityCollision(entityZombie.boundingBox) || !this.worldObj.getCollidingBoundingBoxes(entityZombie, entityZombie.boundingBox).isEmpty() || this.worldObj.isAnyLiquid(entityZombie.boundingBox)) continue;
                this.worldObj.spawnEntityInWorld(entityZombie);
                if (entityLivingBase != null) {
                    entityZombie.setAttackTarget(entityLivingBase);
                }
                entityZombie.onSpawnWithEgg(null);
                this.getEntityAttribute(field_110186_bp)._a(new AttributeModifier("Zombie reinforcement caller charge", -0.05f, 0));
                entityZombie.getEntityAttribute(field_110186_bp)._a(new AttributeModifier("Zombie reinforcement callee charge", -0.05f, 0));
                break;
            }
        }
        return true;
    }

    @Override
    public void onUpdate() {
        if (!this.worldObj.isRemote && this.isConverting()) {
            int n = this.getConversionTimeBoost();
            this.conversionTime -= n;
            if (this.conversionTime <= 0) {
                this.convertToVillager();
            }
        }
        super.onUpdate();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        boolean bl = super.attackEntityAsMob(entity);
        if (bl && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < (float)this.worldObj.difficultySetting * 0.3f) {
            entity.setFire(2 * this.worldObj.difficultySetting);
        }
        return bl;
    }

    @Override
    public String getLivingSound() {
        return "mob.zombie.say";
    }

    @Override
    public String getHurtSound() {
        return "mob.zombie.hurt";
    }

    @Override
    public String getDeathSound() {
        return "mob.zombie.death";
    }

    @Override
    public void playStepSound(int n, int n2, int n3, int n4) {
        this.playSound("mob.zombie.step", 0.15f, 1.0f);
    }

    @Override
    public int getDropItemId() {
        return Item.rottenFlesh.itemID;
    }

    @Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute._b;
    }

    @Override
    public void dropRareDrop(int n) {
        switch (this.rand.nextInt(3)) {
            case 0: {
                this.dropItem(Item.ingotIron.itemID, 1);
                break;
            }
            case 1: {
                this.dropItem(Item.carrot.itemID, 1);
                break;
            }
            case 2: {
                this.dropItem(Item.potato.itemID, 1);
            }
        }
    }

    @Override
    public void addRandomArmor() {
        super.addRandomArmor();
        float f = this.rand.nextFloat();
        float f2 = this.worldObj.difficultySetting == 3 ? 0.05f : 0.01f;
        if (f < f2) {
            int n = this.rand.nextInt(3);
            if (n == 0) {
                this.setCurrentItemOrArmor(0, new ItemStack(Item.swordIron));
            } else {
                this.setCurrentItemOrArmor(0, new ItemStack(Item.shovelIron));
            }
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        if (this.isChild()) {
            nBTTagCompound._a("IsBaby", true);
        }
        if (this.isVillager()) {
            nBTTagCompound._a("IsVillager", true);
        }
        nBTTagCompound._a("ConversionTime", this.isConverting() ? this.conversionTime : -1);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        if (nBTTagCompound._o("IsBaby")) {
            this.setChild(true);
        }
        if (nBTTagCompound._o("IsVillager")) {
            this.setVillager(true);
        }
        if (nBTTagCompound._c("ConversionTime") && nBTTagCompound._f("ConversionTime") > -1) {
            this.startConversion(nBTTagCompound._f("ConversionTime"));
        }
    }

    @Override
    public void onKillEntity(EntityLivingBase entityLivingBase) {
        super.onKillEntity(entityLivingBase);
        if (this.worldObj.difficultySetting >= 2 && entityLivingBase instanceof EntityVillager) {
            if (this.worldObj.difficultySetting == 2 && this.rand.nextBoolean()) {
                return;
            }
            EntityZombie entityZombie = new EntityZombie(this.worldObj);
            entityZombie.copyLocationAndAnglesFrom(entityLivingBase);
            this.worldObj.removeEntity(entityLivingBase);
            entityZombie.onSpawnWithEgg(null);
            entityZombie.setVillager(true);
            if (entityLivingBase.isChild()) {
                entityZombie.setChild(true);
            }
            this.worldObj.spawnEntityInWorld(entityZombie);
            this.worldObj.playAuxSFXAtEntity(null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
        }
    }

    @Override
    public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
        Object object;
        EntityLivingData entityLivingData2 = super.onSpawnWithEgg(entityLivingData);
        float f = this.worldObj.getLocationTensionFactor(this.posX, this.posY, this.posZ);
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55f * f);
        if (entityLivingData2 == null) {
            entityLivingData2 = new kjui(this, this.worldObj.rand.nextFloat() < ForgeDummyContainer.zombieBabyChance, this.worldObj.rand.nextFloat() < 0.05f, null);
        }
        if (entityLivingData2 instanceof kjui) {
            object = (kjui)entityLivingData2;
            if (((kjui)object)._b) {
                this.setVillager(true);
            }
            if (((kjui)object)._a) {
                this.setChild(true);
            }
        }
        this.addRandomArmor();
        this.enchantEquipment();
        if (this.func_71124_b(4) == null && ((Calendar)(object = this.worldObj.getCurrentDate())).get(2) + 1 == 10 && ((Calendar)object).get(5) == 31 && this.rand.nextFloat() < 0.25f) {
            this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1f ? Block.pumpkinLantern : Block.pumpkin));
            this.equipmentDropChances[4] = 0.0f;
        }
        this.getEntityAttribute(sajz._c)._a(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * (double)0.05f, 0));
        this.getEntityAttribute(sajz._b)._a(new AttributeModifier("Random zombie-spawn bonus", this.rand.nextDouble() * 1.5, 2));
        if (this.rand.nextFloat() < f * 0.05f) {
            this.getEntityAttribute(field_110186_bp)._a(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 0.25 + 0.5, 0));
            this.getEntityAttribute(sajz._a)._a(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0 + 1.0, 2));
        }
        return entityLivingData2;
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.getCurrentEquippedItem();
        if (itemStack != null && itemStack._a() == Item.appleGold && itemStack._j() == 0 && this.isVillager() && this.isPotionActive(Potion._t)) {
            if (!entityPlayer.capabilities._d) {
                --itemStack._b;
            }
            if (itemStack._b <= 0) {
                entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory._c, null);
            }
            if (!this.worldObj.isRemote) {
                this.startConversion(this.rand.nextInt(2401) + 3600);
            }
            return true;
        }
        return false;
    }

    public void startConversion(int n) {
        this.conversionTime = n;
        this.getDataWatcher()._b(14, (byte)1);
        this.removePotionEffect(Potion._t._H);
        this.addPotionEffect(new PotionEffect(Potion._g._H, n, Math.min(this.worldObj.difficultySetting - 1, 0)));
        this.worldObj.setEntityState(this, (byte)16);
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void handleHealthUpdate(byte by) {
        if (by == 16) {
            this.worldObj.playSound(this.posX + 0.5, this.posY + 0.5, this.posZ + 0.5, "mob.zombie.remedy", 1.0f + this.rand.nextFloat(), this.rand.nextFloat() * 0.7f + 0.3f, false);
        } else {
            super.handleHealthUpdate(by);
        }
    }

    @Override
    public boolean canDespawn() {
        return !this.isConverting();
    }

    public boolean isConverting() {
        return this.getDataWatcher()._a(14) == 1;
    }

    public void convertToVillager() {
        EntityVillager entityVillager = new EntityVillager(this.worldObj);
        entityVillager.copyLocationAndAnglesFrom(this);
        entityVillager.onSpawnWithEgg(null);
        entityVillager.func_82187_q();
        if (this.isChild()) {
            entityVillager.setGrowingAge(-24000);
        }
        this.worldObj.removeEntity(this);
        this.worldObj.spawnEntityInWorld(entityVillager);
        entityVillager.addPotionEffect(new PotionEffect(Potion._k._H, 200, 0));
        this.worldObj.playAuxSFXAtEntity(null, 1017, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
    }

    public int getConversionTimeBoost() {
        int n = 1;
        if (this.rand.nextFloat() < 0.01f) {
            int n2 = 0;
            for (int i = (int)this.posX - 4; i < (int)this.posX + 4 && n2 < 14; ++i) {
                for (int j = (int)this.posY - 4; j < (int)this.posY + 4 && n2 < 14; ++j) {
                    for (int k = (int)this.posZ - 4; k < (int)this.posZ + 4 && n2 < 14; ++k) {
                        int n3 = this.worldObj.getBlockId(i, j, k);
                        if (n3 != Block.fenceIron.blockID && n3 != Block.bed.blockID) continue;
                        if (this.rand.nextFloat() < 0.3f) {
                            ++n;
                        }
                        ++n2;
                    }
                }
            }
        }
        return n;
    }
}

