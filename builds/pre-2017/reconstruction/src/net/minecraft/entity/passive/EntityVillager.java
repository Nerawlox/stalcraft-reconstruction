/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.passive;

import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.amxi;
import net.minecraft.entity.ai.hank;
import net.minecraft.entity.ai.iurn;
import net.minecraft.entity.ai.iurq;
import net.minecraft.entity.ai.jxsn;
import net.minecraft.entity.ai.ntaf;
import net.minecraft.entity.ai.ofbx;
import net.minecraft.entity.ai.samo;
import net.minecraft.entity.ai.tdpx;
import net.minecraft.entity.ai.uxqz;
import net.minecraft.entity.ai.vjvn;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.sajz;
import net.minecraft.entity.vjsq;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.idpz;
import net.minecraft.util.sajh;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class EntityVillager
extends EntityAgeable
implements IMerchant,
vjsq {
    public int randomTickDivider;
    public boolean isMating;
    public boolean isPlaying;
    public Village villageObj;
    public EntityPlayer buyingPlayer;
    public MerchantRecipeList buyingList;
    public int timeUntilReset;
    public boolean needsInitilization;
    public int wealth;
    public String lastBuyingPlayer;
    public boolean field_82190_bM;
    public float field_82191_bN;
    public static final Map field_70958_bB = new HashMap();
    public static final Map blacksmithSellingList = new HashMap();

    public EntityVillager(World world) {
        this(world, 0);
    }

    public EntityVillager(World world, int n) {
        super(world);
        this.setProfession(n);
        this.setSize(0.6f, 1.8f);
        this.getNavigator()._b(true);
        this.getNavigator()._a(true);
        this.tasks._a(0, new tdpx(this));
        this.tasks._a(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0f, 0.6, 0.6));
        this.tasks._a(1, new ntaf(this));
        this.tasks._a(1, new net.minecraft.entity.ai.vjsq(this));
        this.tasks._a(2, new net.minecraft.entity.ai.sajz(this));
        this.tasks._a(3, new hank(this));
        this.tasks._a(4, new uxqz(this, true));
        this.tasks._a(5, new amxi(this, 0.6));
        this.tasks._a(6, new ofbx(this));
        this.tasks._a(7, new jxsn(this));
        this.tasks._a(8, new samo(this, 0.32));
        this.tasks._a(9, new vjvn(this, EntityPlayer.class, 3.0f, 1.0f));
        this.tasks._a(9, new vjvn(this, EntityVillager.class, 5.0f, 0.02f));
        this.tasks._a(9, new iurn(this, 0.6));
        this.tasks._a(10, new iurq(this, EntityLiving.class, 8.0f));
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(sajz._d)._a(0.5);
    }

    @Override
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    public void updateAITick() {
        if (--this.randomTickDivider <= 0) {
            this.worldObj.villageCollectionObj._a(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ));
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj._a(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ), 32);
            if (this.villageObj == null) {
                this.detachHome();
            } else {
                ChunkCoordinates chunkCoordinates = this.villageObj._c();
                this.setHomeArea(chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c, (int)((float)this.villageObj._d() * 0.6f));
                if (this.field_82190_bM) {
                    this.field_82190_bM = false;
                    this.villageObj._b(5);
                }
            }
        }
        if (!this.isTrading() && this.timeUntilReset > 0) {
            --this.timeUntilReset;
            if (this.timeUntilReset <= 0) {
                if (this.needsInitilization) {
                    if (this.buyingList.size() > 1) {
                        for (MerchantRecipe merchantRecipe : this.buyingList) {
                            if (!merchantRecipe._f()) continue;
                            merchantRecipe._a(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                        }
                    }
                    this.addDefaultEquipmentAndRecipies(1);
                    this.needsInitilization = false;
                    if (this.villageObj != null && this.lastBuyingPlayer != null) {
                        this.worldObj.setEntityState(this, (byte)14);
                        this.villageObj._a(this.lastBuyingPlayer, 1);
                    }
                }
                this.addPotionEffect(new PotionEffect(Potion._l._H, 200, 0));
            }
        }
        super.updateAITick();
    }

    @Override
    public boolean interact(EntityPlayer entityPlayer) {
        boolean bl;
        ItemStack itemStack = entityPlayer.inventory._a();
        boolean bl2 = bl = itemStack != null && itemStack._d == Item.monsterPlacer.itemID;
        if (!(bl || !this.isEntityAlive() || this.isTrading() || this.isChild() || entityPlayer.isSneaking())) {
            if (!this.worldObj.isRemote) {
                this.setCustomer(entityPlayer);
                entityPlayer.displayGUIMerchant(this, this.getCustomNameTag());
            }
            return true;
        }
        return super.interact(entityPlayer);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, (Object)0);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("Profession", this.getProfession());
        nBTTagCompound._a("Riches", this.wealth);
        if (this.buyingList != null) {
            nBTTagCompound._a("Offers", this.buyingList._a());
        }
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        this.setProfession(nBTTagCompound._f("Profession"));
        this.wealth = nBTTagCompound._f("Riches");
        if (nBTTagCompound._c("Offers")) {
            NBTTagCompound nBTTagCompound2 = nBTTagCompound._m("Offers");
            this.buyingList = new MerchantRecipeList(nBTTagCompound2);
        }
    }

    @Override
    public boolean canDespawn() {
        return false;
    }

    @Override
    public String getLivingSound() {
        return this.isTrading() ? "mob.villager.haggle" : "mob.villager.idle";
    }

    @Override
    public String getHurtSound() {
        return "mob.villager.hit";
    }

    @Override
    public String getDeathSound() {
        return "mob.villager.death";
    }

    public void setProfession(int n) {
        this.dataWatcher._b(16, n);
    }

    public int getProfession() {
        return this.dataWatcher._c(16);
    }

    public boolean isMating() {
        return this.isMating;
    }

    public void setMating(boolean bl) {
        this.isMating = bl;
    }

    public void setPlaying(boolean bl) {
        this.isPlaying = bl;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    @Override
    public void setRevengeTarget(EntityLivingBase entityLivingBase) {
        super.setRevengeTarget(entityLivingBase);
        if (this.villageObj != null && entityLivingBase != null) {
            this.villageObj._a(entityLivingBase);
            if (entityLivingBase instanceof EntityPlayer) {
                int n = -1;
                if (this.isChild()) {
                    n = -3;
                }
                this.villageObj._a(((EntityPlayer)entityLivingBase).getCommandSenderName(), n);
                if (this.isEntityAlive()) {
                    this.worldObj.setEntityState(this, (byte)13);
                }
            }
        }
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        if (this.villageObj != null) {
            EntityPlayer entityPlayer;
            Entity entity = damageSource.getEntity();
            if (entity != null) {
                if (entity instanceof EntityPlayer) {
                    this.villageObj._a(((EntityPlayer)entity).getCommandSenderName(), -2);
                } else if (entity instanceof ezey) {
                    this.villageObj._m();
                }
            } else if (entity == null && (entityPlayer = this.worldObj.getClosestPlayerToEntity(this, 16.0)) != null) {
                this.villageObj._m();
            }
        }
        super.onDeath(damageSource);
    }

    @Override
    public void setCustomer(EntityPlayer entityPlayer) {
        this.buyingPlayer = entityPlayer;
    }

    @Override
    public EntityPlayer getCustomer() {
        return this.buyingPlayer;
    }

    public boolean isTrading() {
        return this.buyingPlayer != null;
    }

    @Override
    public void useRecipe(MerchantRecipe merchantRecipe) {
        merchantRecipe._e();
        this.livingSoundTime = -this.getTalkInterval();
        this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());
        if (merchantRecipe._a((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1))) {
            this.timeUntilReset = 40;
            this.needsInitilization = true;
            this.lastBuyingPlayer = this.buyingPlayer != null ? this.buyingPlayer.getCommandSenderName() : null;
        }
        if (merchantRecipe._a()._d == Item.emerald.itemID) {
            this.wealth += merchantRecipe._a()._b;
        }
    }

    @Override
    public void func_110297_a_(ItemStack itemStack) {
        if (!this.worldObj.isRemote && this.livingSoundTime > -this.getTalkInterval() + 20) {
            this.livingSoundTime = -this.getTalkInterval();
            if (itemStack != null) {
                this.playSound("mob.villager.yes", this.getSoundVolume(), this.getSoundPitch());
            } else {
                this.playSound("mob.villager.no", this.getSoundVolume(), this.getSoundPitch());
            }
        }
    }

    @Override
    public MerchantRecipeList getRecipes(EntityPlayer entityPlayer) {
        if (this.buyingList == null) {
            this.addDefaultEquipmentAndRecipies(1);
        }
        return this.buyingList;
    }

    public float adjustProbability(float f) {
        float f2 = f + this.field_82191_bN;
        return f2 > 0.9f ? 0.9f - (f2 - 0.9f) : f2;
    }

    public void addDefaultEquipmentAndRecipies(int n) {
        this.field_82191_bN = this.buyingList != null ? sajh._c(this.buyingList.size()) * 0.2f : 0.0f;
        MerchantRecipeList merchantRecipeList = new MerchantRecipeList();
        VillagerRegistry.manageVillagerTrades(merchantRecipeList, this, this.getProfession(), this.rand);
        switch (this.getProfession()) {
            case 0: {
                EntityVillager.addMerchantItem(merchantRecipeList, Item.wheat.itemID, this.rand, this.adjustProbability(0.9f));
                EntityVillager.addMerchantItem(merchantRecipeList, Block.cloth.blockID, this.rand, this.adjustProbability(0.5f));
                EntityVillager.addMerchantItem(merchantRecipeList, Item.chickenRaw.itemID, this.rand, this.adjustProbability(0.5f));
                EntityVillager.addMerchantItem(merchantRecipeList, Item.fishCooked.itemID, this.rand, this.adjustProbability(0.4f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.bread.itemID, this.rand, this.adjustProbability(0.9f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.melon.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.appleRed.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.cookie.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.shears.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.flintAndSteel.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.chickenCooked.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.arrow.itemID, this.rand, this.adjustProbability(0.5f));
                if (!(this.rand.nextFloat() < this.adjustProbability(0.5f))) break;
                merchantRecipeList.add(new MerchantRecipe(new ItemStack(Block.gravel, 10), new ItemStack(Item.emerald), new ItemStack(Item.flint.itemID, 4 + this.rand.nextInt(2), 0)));
                break;
            }
            case 1: {
                EntityVillager.addMerchantItem(merchantRecipeList, Item.paper.itemID, this.rand, this.adjustProbability(0.8f));
                EntityVillager.addMerchantItem(merchantRecipeList, Item.book.itemID, this.rand, this.adjustProbability(0.8f));
                EntityVillager.addMerchantItem(merchantRecipeList, Item.writtenBook.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Block.bookShelf.blockID, this.rand, this.adjustProbability(0.8f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Block.glass.blockID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.compass.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.pocketSundial.itemID, this.rand, this.adjustProbability(0.2f));
                if (!(this.rand.nextFloat() < this.adjustProbability(0.07f))) break;
                Object object = Enchantment._b[this.rand.nextInt(Enchantment._b.length)];
                int n2 = sajh._a(this.rand, ((Enchantment)object)._b(), ((Enchantment)object)._c());
                ItemStack itemStack = Item.enchantedBook._a(new ixcc((Enchantment)object, n2));
                int n3 = 2 + this.rand.nextInt(5 + n2 * 10) + 3 * n2;
                merchantRecipeList.add(new MerchantRecipe(new ItemStack(Item.book), new ItemStack(Item.emerald, n3), itemStack));
                break;
            }
            case 2: {
                int n3;
                Object object;
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.eyeOfEnder.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.expBottle.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.redstone.itemID, this.rand, this.adjustProbability(0.4f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Block.glowStone.blockID, this.rand, this.adjustProbability(0.3f));
                Object object2 = object = (Object)new int[]{Item.swordIron.itemID, Item.swordDiamond.itemID, Item.plateIron.itemID, Item.plateDiamond.itemID, Item.axeIron.itemID, Item.axeDiamond.itemID, Item.pickaxeIron.itemID, Item.pickaxeDiamond.itemID};
                int n4 = ((Object)object).length;
                for (n3 = 0; n3 < n4; ++n3) {
                    Object object3 = object2[n3];
                    if (!(this.rand.nextFloat() < this.adjustProbability(0.05f))) continue;
                    merchantRecipeList.add(new MerchantRecipe(new ItemStack((int)object3, 1, 0), new ItemStack(Item.emerald, 2 + this.rand.nextInt(3), 0), zhty._a(this.rand, new ItemStack((int)object3, 1, 0), 5 + this.rand.nextInt(15))));
                }
                break;
            }
            case 3: {
                EntityVillager.addMerchantItem(merchantRecipeList, Item.coal.itemID, this.rand, this.adjustProbability(0.7f));
                EntityVillager.addMerchantItem(merchantRecipeList, Item.ingotIron.itemID, this.rand, this.adjustProbability(0.5f));
                EntityVillager.addMerchantItem(merchantRecipeList, Item.ingotGold.itemID, this.rand, this.adjustProbability(0.5f));
                EntityVillager.addMerchantItem(merchantRecipeList, Item.diamond.itemID, this.rand, this.adjustProbability(0.5f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.swordIron.itemID, this.rand, this.adjustProbability(0.5f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.swordDiamond.itemID, this.rand, this.adjustProbability(0.5f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.axeIron.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.axeDiamond.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.pickaxeIron.itemID, this.rand, this.adjustProbability(0.5f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.pickaxeDiamond.itemID, this.rand, this.adjustProbability(0.5f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.shovelIron.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.shovelDiamond.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.hoeIron.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.hoeDiamond.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.bootsIron.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.bootsDiamond.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.helmetIron.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.helmetDiamond.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.plateIron.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.plateDiamond.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.legsIron.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.legsDiamond.itemID, this.rand, this.adjustProbability(0.2f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.bootsChain.itemID, this.rand, this.adjustProbability(0.1f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.helmetChain.itemID, this.rand, this.adjustProbability(0.1f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.plateChain.itemID, this.rand, this.adjustProbability(0.1f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.legsChain.itemID, this.rand, this.adjustProbability(0.1f));
                break;
            }
            case 4: {
                EntityVillager.addMerchantItem(merchantRecipeList, Item.coal.itemID, this.rand, this.adjustProbability(0.7f));
                EntityVillager.addMerchantItem(merchantRecipeList, Item.porkRaw.itemID, this.rand, this.adjustProbability(0.5f));
                EntityVillager.addMerchantItem(merchantRecipeList, Item.beefRaw.itemID, this.rand, this.adjustProbability(0.5f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.saddle.itemID, this.rand, this.adjustProbability(0.1f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.plateLeather.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.bootsLeather.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.helmetLeather.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.legsLeather.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.porkCooked.itemID, this.rand, this.adjustProbability(0.3f));
                EntityVillager.addBlacksmithItem(merchantRecipeList, Item.beefCooked.itemID, this.rand, this.adjustProbability(0.3f));
            }
        }
        if (merchantRecipeList.isEmpty()) {
            EntityVillager.addMerchantItem(merchantRecipeList, Item.ingotGold.itemID, this.rand, 1.0f);
        }
        Collections.shuffle(merchantRecipeList);
        if (this.buyingList == null) {
            this.buyingList = new MerchantRecipeList();
        }
        for (int i = 0; i < n && i < merchantRecipeList.size(); ++i) {
            this.buyingList._a((MerchantRecipe)merchantRecipeList.get(i));
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void setRecipes(MerchantRecipeList merchantRecipeList) {
    }

    public static void addMerchantItem(MerchantRecipeList merchantRecipeList, int n, Random random, float f) {
        if (random.nextFloat() < f) {
            merchantRecipeList.add(new MerchantRecipe(EntityVillager.getRandomSizedStack(n, random), Item.emerald));
        }
    }

    public static ItemStack getRandomSizedStack(int n, Random random) {
        return new ItemStack(n, EntityVillager.getRandomCountForItem(n, random), 0);
    }

    public static int getRandomCountForItem(int n, Random random) {
        idpz idpz2 = (idpz)field_70958_bB.get(n);
        return idpz2 == null ? 1 : ((Integer)idpz2._a() >= (Integer)idpz2._b() ? (Integer)idpz2._a() : (Integer)idpz2._a() + random.nextInt((Integer)idpz2._b() - (Integer)idpz2._a()));
    }

    public static void addBlacksmithItem(MerchantRecipeList merchantRecipeList, int n, Random random, float f) {
        if (random.nextFloat() < f) {
            ItemStack itemStack;
            ItemStack itemStack2;
            int n2 = EntityVillager.getRandomCountForBlacksmithItem(n, random);
            if (n2 < 0) {
                itemStack2 = new ItemStack(Item.emerald.itemID, 1, 0);
                itemStack = new ItemStack(n, -n2, 0);
            } else {
                itemStack2 = new ItemStack(Item.emerald.itemID, n2, 0);
                itemStack = new ItemStack(n, 1, 0);
            }
            merchantRecipeList.add(new MerchantRecipe(itemStack2, itemStack));
        }
    }

    public static int getRandomCountForBlacksmithItem(int n, Random random) {
        idpz idpz2 = (idpz)blacksmithSellingList.get(n);
        return idpz2 == null ? 1 : ((Integer)idpz2._a() >= (Integer)idpz2._b() ? (Integer)idpz2._a() : (Integer)idpz2._a() + random.nextInt((Integer)idpz2._b() - (Integer)idpz2._a()));
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void handleHealthUpdate(byte by) {
        if (by == 12) {
            this.generateRandomParticles("heart");
        } else if (by == 13) {
            this.generateRandomParticles("angryVillager");
        } else if (by == 14) {
            this.generateRandomParticles("happyVillager");
        } else {
            super.handleHealthUpdate(by);
        }
    }

    @Override
    public EntityLivingData onSpawnWithEgg(EntityLivingData entityLivingData) {
        entityLivingData = super.onSpawnWithEgg(entityLivingData);
        VillagerRegistry.applyRandomTrade(this, this.worldObj.rand);
        return entityLivingData;
    }

    @SideOnly(value=Side.CLIENT)
    public void generateRandomParticles(String string) {
        for (int i = 0; i < 5; ++i) {
            double d = this.rand.nextGaussian() * 0.02;
            double d2 = this.rand.nextGaussian() * 0.02;
            double d3 = this.rand.nextGaussian() * 0.02;
            this.worldObj.spawnParticle(string, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, this.posY + 1.0 + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0f) - (double)this.width, d, d2, d3);
        }
    }

    public void func_82187_q() {
        this.field_82190_bM = true;
    }

    public EntityVillager func_90012_b(EntityAgeable entityAgeable) {
        EntityVillager entityVillager = new EntityVillager(this.worldObj);
        entityVillager.onSpawnWithEgg(null);
        return entityVillager;
    }

    @Override
    public boolean allowLeashing() {
        return false;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entityAgeable) {
        return this.func_90012_b(entityAgeable);
    }

    static {
        field_70958_bB.put(Item.coal.itemID, new idpz(16, 24));
        field_70958_bB.put(Item.ingotIron.itemID, new idpz(8, 10));
        field_70958_bB.put(Item.ingotGold.itemID, new idpz(8, 10));
        field_70958_bB.put(Item.diamond.itemID, new idpz(4, 6));
        field_70958_bB.put(Item.paper.itemID, new idpz(24, 36));
        field_70958_bB.put(Item.book.itemID, new idpz(11, 13));
        field_70958_bB.put(Item.writtenBook.itemID, new idpz(1, 1));
        field_70958_bB.put(Item.enderPearl.itemID, new idpz(3, 4));
        field_70958_bB.put(Item.eyeOfEnder.itemID, new idpz(2, 3));
        field_70958_bB.put(Item.porkRaw.itemID, new idpz(14, 18));
        field_70958_bB.put(Item.beefRaw.itemID, new idpz(14, 18));
        field_70958_bB.put(Item.chickenRaw.itemID, new idpz(14, 18));
        field_70958_bB.put(Item.fishCooked.itemID, new idpz(9, 13));
        field_70958_bB.put(Item.seeds.itemID, new idpz(34, 48));
        field_70958_bB.put(Item.melonSeeds.itemID, new idpz(30, 38));
        field_70958_bB.put(Item.pumpkinSeeds.itemID, new idpz(30, 38));
        field_70958_bB.put(Item.wheat.itemID, new idpz(18, 22));
        field_70958_bB.put(Block.cloth.blockID, new idpz(14, 22));
        field_70958_bB.put(Item.rottenFlesh.itemID, new idpz(36, 64));
        blacksmithSellingList.put(Item.flintAndSteel.itemID, new idpz(3, 4));
        blacksmithSellingList.put(Item.shears.itemID, new idpz(3, 4));
        blacksmithSellingList.put(Item.swordIron.itemID, new idpz(7, 11));
        blacksmithSellingList.put(Item.swordDiamond.itemID, new idpz(12, 14));
        blacksmithSellingList.put(Item.axeIron.itemID, new idpz(6, 8));
        blacksmithSellingList.put(Item.axeDiamond.itemID, new idpz(9, 12));
        blacksmithSellingList.put(Item.pickaxeIron.itemID, new idpz(7, 9));
        blacksmithSellingList.put(Item.pickaxeDiamond.itemID, new idpz(10, 12));
        blacksmithSellingList.put(Item.shovelIron.itemID, new idpz(4, 6));
        blacksmithSellingList.put(Item.shovelDiamond.itemID, new idpz(7, 8));
        blacksmithSellingList.put(Item.hoeIron.itemID, new idpz(4, 6));
        blacksmithSellingList.put(Item.hoeDiamond.itemID, new idpz(7, 8));
        blacksmithSellingList.put(Item.bootsIron.itemID, new idpz(4, 6));
        blacksmithSellingList.put(Item.bootsDiamond.itemID, new idpz(7, 8));
        blacksmithSellingList.put(Item.helmetIron.itemID, new idpz(4, 6));
        blacksmithSellingList.put(Item.helmetDiamond.itemID, new idpz(7, 8));
        blacksmithSellingList.put(Item.plateIron.itemID, new idpz(10, 14));
        blacksmithSellingList.put(Item.plateDiamond.itemID, new idpz(16, 19));
        blacksmithSellingList.put(Item.legsIron.itemID, new idpz(8, 10));
        blacksmithSellingList.put(Item.legsDiamond.itemID, new idpz(11, 14));
        blacksmithSellingList.put(Item.bootsChain.itemID, new idpz(5, 7));
        blacksmithSellingList.put(Item.helmetChain.itemID, new idpz(5, 7));
        blacksmithSellingList.put(Item.plateChain.itemID, new idpz(11, 15));
        blacksmithSellingList.put(Item.legsChain.itemID, new idpz(9, 11));
        blacksmithSellingList.put(Item.bread.itemID, new idpz(-4, -2));
        blacksmithSellingList.put(Item.melon.itemID, new idpz(-8, -4));
        blacksmithSellingList.put(Item.appleRed.itemID, new idpz(-8, -4));
        blacksmithSellingList.put(Item.cookie.itemID, new idpz(-10, -7));
        blacksmithSellingList.put(Block.glass.blockID, new idpz(-5, -3));
        blacksmithSellingList.put(Block.bookShelf.blockID, new idpz(3, 4));
        blacksmithSellingList.put(Item.plateLeather.itemID, new idpz(4, 5));
        blacksmithSellingList.put(Item.bootsLeather.itemID, new idpz(2, 4));
        blacksmithSellingList.put(Item.helmetLeather.itemID, new idpz(2, 4));
        blacksmithSellingList.put(Item.legsLeather.itemID, new idpz(2, 4));
        blacksmithSellingList.put(Item.saddle.itemID, new idpz(6, 8));
        blacksmithSellingList.put(Item.expBottle.itemID, new idpz(-4, -1));
        blacksmithSellingList.put(Item.redstone.itemID, new idpz(-4, -1));
        blacksmithSellingList.put(Item.compass.itemID, new idpz(10, 12));
        blacksmithSellingList.put(Item.pocketSundial.itemID, new idpz(10, 12));
        blacksmithSellingList.put(Block.glowStone.blockID, new idpz(-3, -1));
        blacksmithSellingList.put(Item.porkCooked.itemID, new idpz(-7, -5));
        blacksmithSellingList.put(Item.beefCooked.itemID, new idpz(-7, -5));
        blacksmithSellingList.put(Item.chickenCooked.itemID, new idpz(-8, -6));
        blacksmithSellingList.put(Item.eyeOfEnder.itemID, new idpz(7, 11));
        blacksmithSellingList.put(Item.arrow.itemID, new idpz(-12, -8));
    }
}

