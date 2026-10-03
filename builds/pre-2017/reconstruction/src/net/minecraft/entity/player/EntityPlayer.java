/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.player;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import gloomyfolken.mods.asm.GloomyHooks;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.material.Material;
import net.minecraft.command.ICommandSender;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.ezfa;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.ezey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.sajz;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryEnderChest;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;
import net.minecraft.util.Icon;
import net.minecraft.util.Vec3;
import net.minecraft.util.sajh;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public abstract class EntityPlayer
extends EntityLivingBase
implements Player,
ICommandSender {
    public static final String PERSISTED_NBT_TAG = "PlayerPersisted";
    public InventoryPlayer inventory = new InventoryPlayer(this);
    public InventoryEnderChest theInventoryEnderChest = new InventoryEnderChest();
    public Container inventoryContainer;
    public Container openContainer;
    public FoodStats foodStats = new FoodStats();
    public int flyToggleTimer;
    public float prevCameraYaw;
    public float cameraYaw;
    public final String username;
    public int xpCooldown;
    public double field_71091_bM;
    public double field_71096_bN;
    public double field_71097_bO;
    public double field_71094_bP;
    public double field_71095_bQ;
    public double field_71085_bR;
    public boolean sleeping;
    public ChunkCoordinates playerLocation;
    public int sleepTimer;
    public float field_71079_bU;
    @SideOnly(value=Side.CLIENT)
    public float field_71082_cx;
    public float field_71089_bV;
    public ChunkCoordinates spawnChunk;
    public HashMap<Integer, ChunkCoordinates> spawnChunkMap = new HashMap();
    public boolean spawnForced;
    public HashMap<Integer, Boolean> spawnForcedMap = new HashMap();
    public ChunkCoordinates startMinecartRidingCoordinate;
    public PlayerCapabilities capabilities = new PlayerCapabilities();
    public int experienceLevel;
    public int experienceTotal;
    public float experience;
    public ItemStack itemInUse;
    public int itemInUseCount;
    public float speedOnGround = 0.1f;
    public float speedInAir = 0.02f;
    public int field_82249_h;
    public EntityFishHook fishEntity;
    public float eyeHeight;
    public String displayname;

    public EntityPlayer(World world, String string) {
        super(world);
        this.username = string;
        this.openContainer = this.inventoryContainer = new ContainerPlayer(this.inventory, !world.isRemote, this);
        this.yOffset = 1.62f;
        ChunkCoordinates chunkCoordinates = world.getSpawnPoint();
        this.setLocationAndAngles((double)chunkCoordinates._a + 0.5, chunkCoordinates._b + 1, (double)chunkCoordinates._c + 0.5, 0.0f, 0.0f);
        this.field_70741_aB = 180.0f;
        this.fireResistance = 20;
        this.eyeHeight = this.getDefaultEyeHeight();
        GloomyHooks.createInfo(this);
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getAttributeMap()._b(sajz._e)._a(1.0);
    }

    @Override
    public void entityInit() {
        super.entityInit();
        this.dataWatcher._a(16, (Object)0);
        this.dataWatcher._a(17, Float.valueOf(0.0f));
        this.dataWatcher._a(18, (Object)0);
    }

    @SideOnly(value=Side.CLIENT)
    public ItemStack getItemInUse() {
        return this.itemInUse;
    }

    @SideOnly(value=Side.CLIENT)
    public int getItemInUseCount() {
        return this.itemInUseCount;
    }

    public boolean isUsingItem() {
        return this.itemInUse != null;
    }

    @SideOnly(value=Side.CLIENT)
    public int getItemInUseDuration() {
        return this.isUsingItem() ? this.itemInUse._n() - this.itemInUseCount : 0;
    }

    public void stopUsingItem() {
        if (this.itemInUse != null) {
            this.itemInUse._b(this.worldObj, this, this.itemInUseCount);
        }
        this.clearItemInUse();
    }

    public void clearItemInUse() {
        this.itemInUse = null;
        this.itemInUseCount = 0;
        if (!this.worldObj.isRemote) {
            this.setEating(false);
        }
    }

    public boolean isBlocking() {
        return this.isUsingItem() && Item.itemsList[this.itemInUse._d].getItemUseAction(this.itemInUse) == EnumAction._d;
    }

    @Override
    public void onUpdate() {
        FMLCommonHandler.instance().onPlayerPreTick(this);
        if (this.itemInUse != null) {
            ItemStack itemStack = this.inventory._a();
            if (itemStack == this.itemInUse) {
                this.itemInUse._a().onUsingItemTick(this.itemInUse, this, this.itemInUseCount);
                if (this.itemInUseCount <= 25 && this.itemInUseCount % 4 == 0) {
                    this.updateItemUse(itemStack, 5);
                }
                if (--this.itemInUseCount == 0 && !this.worldObj.isRemote) {
                    this.onItemUseFinish();
                }
            } else {
                this.clearItemInUse();
            }
        }
        if (this.xpCooldown > 0) {
            --this.xpCooldown;
        }
        if (this.isPlayerSleeping()) {
            ++this.sleepTimer;
            if (this.sleepTimer > 100) {
                this.sleepTimer = 100;
            }
            if (!this.worldObj.isRemote) {
                if (!this.isInBed()) {
                    this.wakeUpPlayer(true, true, false);
                } else if (this.worldObj.isDaytime()) {
                    this.wakeUpPlayer(false, true, true);
                }
            }
        } else if (this.sleepTimer > 0) {
            ++this.sleepTimer;
            if (this.sleepTimer >= 110) {
                this.sleepTimer = 0;
            }
        }
        super.onUpdate();
        if (!this.worldObj.isRemote && this.openContainer != null && !ForgeHooks.canInteractWith(this, this.openContainer)) {
            this.closeScreen();
            this.openContainer = this.inventoryContainer;
        }
        if (this.isBurning() && this.capabilities._a) {
            this.extinguish();
        }
        this.field_71091_bM = this.field_71094_bP;
        this.field_71096_bN = this.field_71095_bQ;
        this.field_71097_bO = this.field_71085_bR;
        double d = this.posX - this.field_71094_bP;
        double d2 = this.posY - this.field_71095_bQ;
        double d3 = this.posZ - this.field_71085_bR;
        double d4 = 10.0;
        if (d > d4) {
            this.field_71091_bM = this.field_71094_bP = this.posX;
        }
        if (d3 > d4) {
            this.field_71097_bO = this.field_71085_bR = this.posZ;
        }
        if (d2 > d4) {
            this.field_71096_bN = this.field_71095_bQ = this.posY;
        }
        if (d < -d4) {
            this.field_71091_bM = this.field_71094_bP = this.posX;
        }
        if (d3 < -d4) {
            this.field_71097_bO = this.field_71085_bR = this.posZ;
        }
        if (d2 < -d4) {
            this.field_71096_bN = this.field_71095_bQ = this.posY;
        }
        this.field_71094_bP += d * 0.25;
        this.field_71085_bR += d3 * 0.25;
        this.field_71095_bQ += d2 * 0.25;
        this.addStat(dzif._k, 1);
        if (this.ridingEntity == null) {
            this.startMinecartRidingCoordinate = null;
        }
        if (!this.worldObj.isRemote) {
            this.foodStats._a(this);
        }
        FMLCommonHandler.instance().onPlayerPostTick(this);
    }

    @Override
    public int getMaxInPortalTime() {
        return this.capabilities._a ? 0 : 80;
    }

    @Override
    public int getPortalCooldown() {
        return 10;
    }

    @Override
    public void playSound(String string, float f, float f2) {
        this.worldObj.playSoundToNearExcept(this, string, f, f2);
    }

    public void updateItemUse(ItemStack itemStack, int n) {
        if (itemStack._o() == EnumAction._c) {
            this.playSound("random.drink", 0.5f, this.worldObj.rand.nextFloat() * 0.1f + 0.9f);
        }
        if (itemStack._o() == EnumAction._b) {
            for (int i = 0; i < n; ++i) {
                Vec3 vec3 = this.worldObj.getWorldVec3Pool()._a(((double)this.rand.nextFloat() - 0.5) * 0.1, Math.random() * 0.1 + 0.1, 0.0);
                vec3._a(-this.rotationPitch * (float)Math.PI / 180.0f);
                vec3._b(-this.rotationYaw * (float)Math.PI / 180.0f);
                Vec3 vec32 = this.worldObj.getWorldVec3Pool()._a(((double)this.rand.nextFloat() - 0.5) * 0.3, (double)(-this.rand.nextFloat()) * 0.6 - 0.3, 0.6);
                vec32._a(-this.rotationPitch * (float)Math.PI / 180.0f);
                vec32._b(-this.rotationYaw * (float)Math.PI / 180.0f);
                vec32 = vec32._c(this.posX, this.posY + (double)this.getEyeHeight(), this.posZ);
                this.worldObj.spawnParticle("iconcrack_" + itemStack._a().itemID + "_" + itemStack._j(), vec32._c, vec32._d, vec32._e, vec3._c, vec3._d + 0.05, vec3._e);
            }
            this.playSound("random.eat", 0.5f + 0.5f * (float)this.rand.nextInt(2), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
        }
    }

    public void onItemUseFinish() {
        if (this.itemInUse != null) {
            this.updateItemUse(this.itemInUse, 16);
            int n = this.itemInUse._b;
            ItemStack itemStack = this.itemInUse._b(this.worldObj, this);
            if (itemStack != this.itemInUse || itemStack != null && itemStack._b != n) {
                this.inventory._a[this.inventory._c] = itemStack;
                if (itemStack._b == 0) {
                    this.inventory._a[this.inventory._c] = null;
                }
            }
            this.clearItemInUse();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void handleHealthUpdate(byte by) {
        if (by == 9) {
            this.onItemUseFinish();
        } else {
            super.handleHealthUpdate(by);
        }
    }

    @Override
    public boolean isMovementBlocked() {
        return this.getHealth() <= 0.0f || this.isPlayerSleeping();
    }

    public void closeScreen() {
        this.openContainer = this.inventoryContainer;
    }

    @Override
    public void mountEntity(Entity entity) {
        if (this.ridingEntity != null && entity == null) {
            if (!this.worldObj.isRemote) {
                this.dismountEntity(this.ridingEntity);
            }
            if (this.ridingEntity != null) {
                this.ridingEntity.riddenByEntity = null;
            }
            this.ridingEntity = null;
        } else {
            super.mountEntity(entity);
        }
    }

    @Override
    public void updateRidden() {
        if (!this.worldObj.isRemote && this.isSneaking()) {
            this.mountEntity(null);
            this.setSneaking(false);
        } else {
            double d = this.posX;
            double d2 = this.posY;
            double d3 = this.posZ;
            float f = this.rotationYaw;
            float f2 = this.rotationPitch;
            super.updateRidden();
            this.prevCameraYaw = this.cameraYaw;
            this.cameraYaw = 0.0f;
            this.addMountedMovementStat(this.posX - d, this.posY - d2, this.posZ - d3);
            if (this.ridingEntity instanceof EntityLivingBase && ((EntityLivingBase)this.ridingEntity).shouldRiderFaceForward(this)) {
                this.rotationPitch = f2;
                this.rotationYaw = f;
                this.renderYawOffset = ((EntityLivingBase)this.ridingEntity).renderYawOffset;
            }
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public void preparePlayerToSpawn() {
        GloomyHooks.preparePlayerToSpawn(this);
        this.yOffset = 1.62f;
        this.setSize(0.6f, 1.8f);
        super.preparePlayerToSpawn();
        this.setHealth(this.getMaxHealth());
        this.deathTime = 0;
    }

    @Override
    public void updateEntityActionState() {
        super.updateEntityActionState();
        this.updateArmSwingProgress();
    }

    @Override
    public void onLivingUpdate() {
        if (this.flyToggleTimer > 0) {
            --this.flyToggleTimer;
        }
        if (this.worldObj.difficultySetting == 0 && this.getHealth() < this.getMaxHealth() && this.worldObj.getGameRules()._b("naturalRegeneration") && this.ticksExisted % 20 * 12 == 0) {
            this.heal(1.0f);
        }
        this.inventory._d();
        this.prevCameraYaw = this.cameraYaw;
        super.onLivingUpdate();
        hubf hubf2 = this.getEntityAttribute(sajz._d);
        if (!this.worldObj.isRemote) {
            hubf2._a(this.capabilities._b());
        }
        this.jumpMovementFactor = this.speedInAir;
        if (this.isSprinting()) {
            this.jumpMovementFactor = (float)((double)this.jumpMovementFactor + (double)this.speedInAir * 0.3);
        }
        this.setAIMoveSpeed((float)hubf2._e());
        float f = sajh._a(this.motionX * this.motionX + this.motionZ * this.motionZ);
        float f2 = (float)Math.atan(-this.motionY * (double)0.2f) * 15.0f;
        if (f > 0.1f) {
            f = 0.1f;
        }
        if (!this.onGround || this.getHealth() <= 0.0f) {
            f = 0.0f;
        }
        if (this.onGround || this.getHealth() <= 0.0f) {
            f2 = 0.0f;
        }
        this.cameraYaw += (f - this.cameraYaw) * 0.4f;
        this.cameraPitch += (f2 - this.cameraPitch) * 0.8f;
        if (this.getHealth() > 0.0f) {
            AxisAlignedBB axisAlignedBB = null;
            axisAlignedBB = this.ridingEntity != null && !this.ridingEntity.isDead ? this.boundingBox._a(this.ridingEntity.boundingBox)._b(1.0, 0.0, 1.0) : this.boundingBox._b(1.0, 0.5, 1.0);
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, axisAlignedBB);
            if (list != null) {
                for (int i = 0; i < list.size(); ++i) {
                    Entity entity = (Entity)list.get(i);
                    if (entity.isDead) continue;
                    this.collideWithPlayer(entity);
                }
            }
        }
    }

    public void collideWithPlayer(Entity entity) {
        entity.onCollideWithPlayer(this);
    }

    public int getScore() {
        return this.dataWatcher._c(18);
    }

    public void setScore(int n) {
        this.dataWatcher._b(18, n);
    }

    public void addScore(int n) {
        int n2 = this.getScore();
        this.dataWatcher._b(18, n2 + n);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        PlayerDropsEvent playerDropsEvent;
        if (ForgeHooks.onLivingDeath(this, damageSource)) {
            return;
        }
        super.onDeath(damageSource);
        this.setSize(0.2f, 0.2f);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.motionY = 0.1f;
        this.captureDrops = true;
        this.capturedDrops.clear();
        if (this.username.equals("Notch")) {
            this.dropPlayerItemWithRandomChoice(new ItemStack(Item.appleRed, 1), true);
        }
        if (!this.worldObj.getGameRules()._b("keepInventory")) {
            this.inventory._f();
        }
        this.captureDrops = false;
        if (!this.worldObj.isRemote && !MinecraftForge.EVENT_BUS.post(playerDropsEvent = new PlayerDropsEvent(this, damageSource, this.capturedDrops, this.recentlyHit > 0))) {
            for (EntityItem entityItem : this.capturedDrops) {
                this.joinEntityItemWithWorld(entityItem);
            }
        }
        if (damageSource != null) {
            this.motionX = -sajh._b((this.attackedAtYaw + this.rotationYaw) * (float)Math.PI / 180.0f) * 0.1f;
            this.motionZ = -sajh._a((this.attackedAtYaw + this.rotationYaw) * (float)Math.PI / 180.0f) * 0.1f;
        } else {
            this.motionZ = 0.0;
            this.motionX = 0.0;
        }
        this.yOffset = 0.1f;
        this.addStat(dzif._y, 1);
    }

    @Override
    public void addToPlayerScore(Entity entity, int n) {
        this.addScore(n);
        Collection collection = this.getWorldScoreboard()._a(ScoreObjectiveCriteria._f);
        if (entity instanceof EntityPlayer) {
            this.addStat(dzif._A, 1);
            collection.addAll(this.getWorldScoreboard()._a(ScoreObjectiveCriteria._e));
        } else {
            this.addStat(dzif._z, 1);
        }
        for (ScoreObjective scoreObjective : collection) {
            Score score = this.getWorldScoreboard()._a(this.getEntityName(), scoreObjective);
            score._a();
        }
    }

    public EntityItem dropOneItem(boolean bl) {
        ItemStack itemStack = this.inventory._a();
        if (itemStack == null) {
            return null;
        }
        if (itemStack._a().onDroppedByPlayer(itemStack, this)) {
            int n = bl && this.inventory._a() != null ? this.inventory._a()._b : 1;
            return ForgeHooks.onPlayerTossEvent(this, this.inventory.decrStackSize(this.inventory._c, n));
        }
        return null;
    }

    public EntityItem dropPlayerItem(ItemStack itemStack) {
        return ForgeHooks.onPlayerTossEvent(this, itemStack);
    }

    public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean bl) {
        if (itemStack == null) {
            return null;
        }
        if (itemStack._b == 0) {
            return null;
        }
        EntityItem entityItem = new EntityItem(this.worldObj, this.posX, this.posY - (double)0.3f + (double)this.getEyeHeight(), this.posZ, itemStack);
        entityItem.delayBeforeCanPickup = 40;
        float f = 0.1f;
        if (bl) {
            float f2 = this.rand.nextFloat() * 0.5f;
            float f3 = this.rand.nextFloat() * (float)Math.PI * 2.0f;
            entityItem.motionX = -sajh._a(f3) * f2;
            entityItem.motionZ = sajh._b(f3) * f2;
            entityItem.motionY = 0.2f;
        } else {
            f = 0.3f;
            entityItem.motionX = -sajh._a(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI) * f;
            entityItem.motionZ = sajh._b(this.rotationYaw / 180.0f * (float)Math.PI) * sajh._b(this.rotationPitch / 180.0f * (float)Math.PI) * f;
            entityItem.motionY = -sajh._a(this.rotationPitch / 180.0f * (float)Math.PI) * f + 0.1f;
            f = 0.02f;
            float f4 = this.rand.nextFloat() * (float)Math.PI * 2.0f;
            entityItem.motionX += Math.cos(f4) * (double)(f *= this.rand.nextFloat());
            entityItem.motionY += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f);
            entityItem.motionZ += Math.sin(f4) * (double)f;
        }
        this.joinEntityItemWithWorld(entityItem);
        this.addStat(dzif._v, 1);
        return entityItem;
    }

    public void joinEntityItemWithWorld(EntityItem entityItem) {
        if (this.captureDrops) {
            this.capturedDrops.add(entityItem);
            return;
        }
        this.worldObj.spawnEntityInWorld(entityItem);
    }

    @Deprecated
    public float getCurrentPlayerStrVsBlock(Block block, boolean bl) {
        return this.getCurrentPlayerStrVsBlock(block, bl, 0);
    }

    public float getCurrentPlayerStrVsBlock(Block block, boolean bl, int n) {
        float f;
        ItemStack itemStack = this.inventory._a();
        float f2 = f = itemStack == null ? 1.0f : itemStack._a().getStrVsBlock(itemStack, block, n);
        if (f > 1.0f) {
            int n2 = zhty._c(this);
            ItemStack itemStack2 = this.inventory._a();
            if (n2 > 0 && itemStack2 != null) {
                float f3 = n2 * n2 + 1;
                boolean bl2 = ForgeHooks.canToolHarvestBlock(block, n, itemStack2);
                f = !bl2 && f <= 1.0f ? (f += f3 * 0.08f) : (f += f3);
            }
        }
        if (this.isPotionActive(Potion._e)) {
            f *= 1.0f + (float)(this.getActivePotionEffect(Potion._e)._c() + 1) * 0.2f;
        }
        if (this.isPotionActive(Potion._f)) {
            f *= 1.0f - (float)(this.getActivePotionEffect(Potion._f)._c() + 1) * 0.2f;
        }
        if (this.isInsideOfMaterial(Material._h) && !zhty._g(this)) {
            f /= 5.0f;
        }
        if (!this.onGround) {
            f /= 5.0f;
        }
        return (f = ForgeEventFactory.getBreakSpeed(this, block, n, f)) < 0.0f ? 0.0f : f;
    }

    public boolean canHarvestBlock(Block block) {
        return ForgeEventFactory.doPlayerHarvestCheck(this, block, this.inventory._b(block));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        NBTTagList nBTTagList = nBTTagCompound._n("Inventory");
        this.inventory._b(nBTTagList);
        this.inventory._c = nBTTagCompound._f("SelectedItemSlot");
        this.sleeping = nBTTagCompound._o("Sleeping");
        this.sleepTimer = nBTTagCompound._e("SleepTimer");
        this.experience = nBTTagCompound._h("XpP");
        this.experienceLevel = nBTTagCompound._f("XpLevel");
        this.experienceTotal = nBTTagCompound._f("XpTotal");
        this.setScore(nBTTagCompound._f("Score"));
        if (this.sleeping) {
            this.playerLocation = new ChunkCoordinates(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ));
            this.wakeUpPlayer(true, true, false);
        }
        if (nBTTagCompound._c("SpawnX") && nBTTagCompound._c("SpawnY") && nBTTagCompound._c("SpawnZ")) {
            this.spawnChunk = new ChunkCoordinates(nBTTagCompound._f("SpawnX"), nBTTagCompound._f("SpawnY"), nBTTagCompound._f("SpawnZ"));
            this.spawnForced = nBTTagCompound._o("SpawnForced");
        }
        NBTTagList nBTTagList2 = null;
        nBTTagList2 = nBTTagCompound._n("Spawns");
        for (int i = 0; i < nBTTagList2._d(); ++i) {
            NBTTagCompound nBTTagCompound2 = (NBTTagCompound)nBTTagList2._b(i);
            int n = nBTTagCompound2._f("Dim");
            this.spawnChunkMap.put(n, new ChunkCoordinates(nBTTagCompound2._f("SpawnX"), nBTTagCompound2._f("SpawnY"), nBTTagCompound2._f("SpawnZ")));
            this.spawnForcedMap.put(n, nBTTagCompound2._o("SpawnForced"));
        }
        this.foodStats._a(nBTTagCompound);
        this.capabilities._b(nBTTagCompound);
        if (nBTTagCompound._c("EnderItems")) {
            NBTTagList nBTTagList3 = nBTTagCompound._n("EnderItems");
            this.theInventoryEnderChest._a(nBTTagList3);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("Inventory", this.inventory._a(new NBTTagList()));
        nBTTagCompound._a("SelectedItemSlot", this.inventory._c);
        nBTTagCompound._a("Sleeping", this.sleeping);
        nBTTagCompound._a("SleepTimer", (short)this.sleepTimer);
        nBTTagCompound._a("XpP", this.experience);
        nBTTagCompound._a("XpLevel", this.experienceLevel);
        nBTTagCompound._a("XpTotal", this.experienceTotal);
        nBTTagCompound._a("Score", this.getScore());
        if (this.spawnChunk != null) {
            nBTTagCompound._a("SpawnX", this.spawnChunk._a);
            nBTTagCompound._a("SpawnY", this.spawnChunk._b);
            nBTTagCompound._a("SpawnZ", this.spawnChunk._c);
            nBTTagCompound._a("SpawnForced", this.spawnForced);
        }
        NBTTagList nBTTagList = new NBTTagList();
        for (Map.Entry<Integer, ChunkCoordinates> entry : this.spawnChunkMap.entrySet()) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            ChunkCoordinates chunkCoordinates = entry.getValue();
            if (chunkCoordinates == null) continue;
            Boolean bl = this.spawnForcedMap.get(entry.getKey());
            if (bl == null) {
                bl = false;
            }
            nBTTagCompound2._a("Dim", (int)entry.getKey());
            nBTTagCompound2._a("SpawnX", chunkCoordinates._a);
            nBTTagCompound2._a("SpawnY", chunkCoordinates._b);
            nBTTagCompound2._a("SpawnZ", chunkCoordinates._c);
            nBTTagCompound2._a("SpawnForced", bl);
            nBTTagList._a(nBTTagCompound2);
        }
        nBTTagCompound._a("Spawns", nBTTagList);
        this.foodStats._b(nBTTagCompound);
        this.capabilities._a(nBTTagCompound);
        nBTTagCompound._a("EnderItems", this.theInventoryEnderChest._a());
    }

    public void displayGUIChest(IInventory iInventory) {
    }

    public void displayGUIHopper(TileEntityHopper tileEntityHopper) {
    }

    public void displayGUIHopperMinecart(EntityMinecartHopper entityMinecartHopper) {
    }

    public void displayGUIHorse(EntityHorse entityHorse, IInventory iInventory) {
    }

    public void displayGUIEnchantment(int n, int n2, int n3, String string) {
    }

    public void displayGUIAnvil(int n, int n2, int n3) {
    }

    public void displayGUIWorkbench(int n, int n2, int n3) {
    }

    @Override
    public float getEyeHeight() {
        return this.eyeHeight;
    }

    public void resetHeight() {
        this.yOffset = 1.62f;
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        if (ForgeHooks.onLivingAttack(this, damageSource, f)) {
            return false;
        }
        if (this.isEntityInvulnerable()) {
            return false;
        }
        if (this.capabilities._a && !damageSource.canHarmInCreative()) {
            return false;
        }
        this.entityAge = 0;
        if (this.getHealth() <= 0.0f) {
            return false;
        }
        if (this.isPlayerSleeping() && !this.worldObj.isRemote) {
            this.wakeUpPlayer(true, true, false);
        }
        if (damageSource.isDifficultyScaled()) {
            if (this.worldObj.difficultySetting == 0) {
                f = 0.0f;
            }
            if (this.worldObj.difficultySetting == 1) {
                f = f / 2.0f + 1.0f;
            }
            if (this.worldObj.difficultySetting == 3) {
                f = f * 3.0f / 2.0f;
            }
        }
        if (f == 0.0f) {
            return false;
        }
        Entity entity = damageSource.getEntity();
        if (entity instanceof EntityArrow && ((EntityArrow)entity).shootingEntity != null) {
            entity = ((EntityArrow)entity).shootingEntity;
        }
        this.addStat(dzif._x, Math.round(f * 10.0f));
        return super.attackEntityFrom(damageSource, f);
    }

    public boolean canAttackPlayer(EntityPlayer entityPlayer) {
        Team team = this.getTeam();
        Team team2 = entityPlayer.getTeam();
        return team == null ? true : (!team._a(team2) ? true : team._f());
    }

    @Override
    public void damageArmor(float f) {
        this.inventory._a(f);
    }

    @Override
    public int getTotalArmorValue() {
        return this.inventory._e();
    }

    public float getArmorVisibility() {
        int n = 0;
        for (ItemStack itemStack : this.inventory._b) {
            if (itemStack == null) continue;
            ++n;
        }
        return (float)n / (float)this.inventory._b.length;
    }

    @Override
    public void damageEntity(DamageSource damageSource, float f) {
        if (!this.isEntityInvulnerable()) {
            if ((f = ForgeHooks.onLivingHurt(this, damageSource, f)) <= 0.0f) {
                return;
            }
            if (!damageSource.isUnblockable() && this.isBlocking() && f > 0.0f) {
                f = (1.0f + f) * 0.5f;
            }
            if ((f = ISpecialArmor.ArmorProperties.ApplyArmor(this, this.inventory._b, damageSource, f)) <= 0.0f) {
                return;
            }
            float f2 = f = this.applyPotionDamageCalculations(damageSource, f);
            f = Math.max(f - this.getAbsorptionAmount(), 0.0f);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (f2 - f));
            if (f != 0.0f) {
                this.addExhaustion(damageSource.getHungerDamage());
                float f3 = this.getHealth();
                this.setHealth(this.getHealth() - f);
                this.func_110142_aN()._a(damageSource, f3, f);
            }
        }
    }

    public void displayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
    }

    public void displayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
    }

    public void displayGUIEditSign(TileEntity tileEntity) {
    }

    public void displayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
    }

    public void displayGUIBeacon(TileEntityBeacon tileEntityBeacon) {
    }

    public void displayGUIMerchant(IMerchant iMerchant, String string) {
    }

    public void displayGUIBook(ItemStack itemStack) {
    }

    public boolean interactWith(Entity entity) {
        ItemStack itemStack;
        if (MinecraftForge.EVENT_BUS.post(new EntityInteractEvent(this, entity))) {
            return false;
        }
        ItemStack itemStack2 = this.getCurrentEquippedItem();
        ItemStack itemStack3 = itemStack = itemStack2 != null ? itemStack2._l() : null;
        if (!entity.interactFirst(this)) {
            if (itemStack2 != null && entity instanceof EntityLivingBase) {
                if (this.capabilities._d) {
                    itemStack2 = itemStack;
                }
                if (itemStack2._a(this, (EntityLivingBase)entity)) {
                    if (itemStack2._b <= 0 && !this.capabilities._d) {
                        this.destroyCurrentEquippedItem();
                    }
                    return true;
                }
            }
            return false;
        }
        if (itemStack2 != null && itemStack2 == this.getCurrentEquippedItem()) {
            if (itemStack2._b <= 0 && !this.capabilities._d) {
                this.destroyCurrentEquippedItem();
            } else if (itemStack2._b < itemStack._b && this.capabilities._d) {
                itemStack2._b = itemStack._b;
            }
        }
        return true;
    }

    public ItemStack getCurrentEquippedItem() {
        return this.inventory._a();
    }

    public void destroyCurrentEquippedItem() {
        ItemStack itemStack = this.getCurrentEquippedItem();
        this.inventory.setInventorySlotContents(this.inventory._c, null);
        MinecraftForge.EVENT_BUS.post(new PlayerDestroyItemEvent(this, itemStack));
    }

    @Override
    public double getYOffset() {
        return this.yOffset - 0.5f;
    }

    public void attackTargetEntityWithCurrentItem(Entity entity) {
        if (MinecraftForge.EVENT_BUS.post(new AttackEntityEvent(this, entity))) {
            return;
        }
        ItemStack itemStack = this.getCurrentEquippedItem();
        if (itemStack != null && itemStack._a().onLeftClickEntity(itemStack, this, entity)) {
            return;
        }
        if (entity.canAttackWithItem() && !entity.hitByEntity(this)) {
            float f = (float)this.getEntityAttribute(sajz._e)._e();
            int n = 0;
            float f2 = 0.0f;
            if (entity instanceof EntityLivingBase) {
                f2 = zhty._a(this, (EntityLivingBase)entity);
                n += zhty._b(this, (EntityLivingBase)entity);
            }
            if (this.isSprinting()) {
                ++n;
            }
            if (f > 0.0f || f2 > 0.0f) {
                ezfa ezfa2;
                boolean bl;
                boolean bl2;
                boolean bl3 = bl2 = this.fallDistance > 0.0f && !this.onGround && !this.isOnLadder() && !this.isInWater() && !this.isPotionActive(Potion._q) && this.ridingEntity == null && entity instanceof EntityLivingBase;
                if (bl2 && f > 0.0f) {
                    f *= 1.5f;
                }
                f += f2;
                boolean bl4 = false;
                int n2 = zhty._a(this);
                if (entity instanceof EntityLivingBase && n2 > 0 && !entity.isBurning()) {
                    bl4 = true;
                    entity.setFire(1);
                }
                if (bl = entity.attackEntityFrom(DamageSource.causePlayerDamage(this), f)) {
                    if (n > 0) {
                        entity.addVelocity(-sajh._a(this.rotationYaw * (float)Math.PI / 180.0f) * (float)n * 0.5f, 0.1, sajh._b(this.rotationYaw * (float)Math.PI / 180.0f) * (float)n * 0.5f);
                        this.motionX *= 0.6;
                        this.motionZ *= 0.6;
                        this.setSprinting(false);
                    }
                    if (bl2) {
                        this.onCriticalHit(entity);
                    }
                    if (f2 > 0.0f) {
                        this.onEnchantmentCritical(entity);
                    }
                    if (f >= 18.0f) {
                        this.triggerAchievement(AchievementList._E);
                    }
                    this.setLastAttacker(entity);
                    if (entity instanceof EntityLivingBase) {
                        EnchantmentThorns._a(this, (EntityLivingBase)entity, this.rand);
                    }
                }
                ItemStack itemStack2 = this.getCurrentEquippedItem();
                Entity entity2 = entity;
                if (entity instanceof EntityDragonPart && (ezfa2 = ((EntityDragonPart)entity).entityDragonObj) != null && ezfa2 instanceof EntityLivingBase) {
                    entity2 = (EntityLivingBase)((Object)ezfa2);
                }
                if (itemStack2 != null && entity2 instanceof EntityLivingBase) {
                    itemStack2._a((EntityLivingBase)entity2, this);
                    if (itemStack2._b <= 0) {
                        this.destroyCurrentEquippedItem();
                    }
                }
                if (entity instanceof EntityLivingBase) {
                    this.addStat(dzif._w, Math.round(f * 10.0f));
                    if (n2 > 0 && bl) {
                        entity.setFire(n2 * 4);
                    } else if (bl4) {
                        entity.extinguish();
                    }
                }
                this.addExhaustion(0.3f);
            }
        }
    }

    public void onCriticalHit(Entity entity) {
    }

    public void onEnchantmentCritical(Entity entity) {
    }

    @SideOnly(value=Side.CLIENT)
    public void respawnPlayer() {
    }

    @Override
    public void setDead() {
        super.setDead();
        this.inventoryContainer.onContainerClosed(this);
        if (this.openContainer != null) {
            this.openContainer.onContainerClosed(this);
        }
    }

    @Override
    public boolean isEntityInsideOpaqueBlock() {
        return !this.sleeping && super.isEntityInsideOpaqueBlock();
    }

    public EnumStatus sleepInBedAt(int n, int n2, int n3) {
        PlayerSleepInBedEvent playerSleepInBedEvent = new PlayerSleepInBedEvent(this, n, n2, n3);
        MinecraftForge.EVENT_BUS.post(playerSleepInBedEvent);
        if (playerSleepInBedEvent.result != null) {
            return playerSleepInBedEvent.result;
        }
        if (!this.worldObj.isRemote) {
            if (this.isPlayerSleeping() || !this.isEntityAlive()) {
                return EnumStatus._e;
            }
            if (!this.worldObj.provider._d()) {
                return EnumStatus._b;
            }
            if (this.worldObj.isDaytime()) {
                return EnumStatus._c;
            }
            if (Math.abs(this.posX - (double)n) > 3.0 || Math.abs(this.posY - (double)n2) > 2.0 || Math.abs(this.posZ - (double)n3) > 3.0) {
                return EnumStatus._d;
            }
            double d = 8.0;
            double d2 = 5.0;
            List list = this.worldObj.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB._a()._a((double)n - d, (double)n2 - d2, (double)n3 - d, (double)n + d, (double)n2 + d2, (double)n3 + d));
            if (!list.isEmpty()) {
                return EnumStatus._f;
            }
        }
        if (this.isRiding()) {
            this.mountEntity(null);
        }
        this.setSize(0.2f, 0.2f);
        this.yOffset = 0.2f;
        if (this.worldObj.blockExists(n, n2, n3)) {
            int n4 = this.worldObj.getBlockMetadata(n, n2, n3);
            int n5 = BlockBed._d(n4);
            Block block = Block.blocksList[this.worldObj.getBlockId(n, n2, n3)];
            if (block != null) {
                n5 = block.getBedDirection(this.worldObj, n, n2, n3);
            }
            float f = 0.5f;
            float f2 = 0.5f;
            switch (n5) {
                case 0: {
                    f2 = 0.9f;
                    break;
                }
                case 1: {
                    f = 0.1f;
                    break;
                }
                case 2: {
                    f2 = 0.1f;
                    break;
                }
                case 3: {
                    f = 0.9f;
                }
            }
            this.func_71013_b(n5);
            this.setPosition((float)n + f, (float)n2 + 0.9375f, (float)n3 + f2);
        } else {
            this.setPosition((float)n + 0.5f, (float)n2 + 0.9375f, (float)n3 + 0.5f);
        }
        this.sleeping = true;
        this.sleepTimer = 0;
        this.playerLocation = new ChunkCoordinates(n, n2, n3);
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.motionX = 0.0;
        if (!this.worldObj.isRemote) {
            this.worldObj.updateAllPlayersSleepingFlag();
        }
        return EnumStatus._a;
    }

    public void func_71013_b(int n) {
        this.field_71079_bU = 0.0f;
        this.field_71089_bV = 0.0f;
        switch (n) {
            case 0: {
                this.field_71089_bV = -1.8f;
                break;
            }
            case 1: {
                this.field_71079_bU = 1.8f;
                break;
            }
            case 2: {
                this.field_71089_bV = 1.8f;
                break;
            }
            case 3: {
                this.field_71079_bU = -1.8f;
            }
        }
    }

    public void wakeUpPlayer(boolean bl, boolean bl2, boolean bl3) {
        Block block;
        this.setSize(0.6f, 1.8f);
        this.resetHeight();
        ChunkCoordinates chunkCoordinates = this.playerLocation;
        ChunkCoordinates chunkCoordinates2 = this.playerLocation;
        Block block2 = block = chunkCoordinates == null ? null : Block.blocksList[this.worldObj.getBlockId(chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c)];
        if (chunkCoordinates != null && block != null && block.isBed(this.worldObj, chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c, this)) {
            block.setBedOccupied(this.worldObj, chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c, this, false);
            chunkCoordinates2 = block.getBedSpawnPosition(this.worldObj, chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c, this);
            if (chunkCoordinates2 == null) {
                chunkCoordinates2 = new ChunkCoordinates(chunkCoordinates._a, chunkCoordinates._b + 1, chunkCoordinates._c);
            }
            this.setPosition((float)chunkCoordinates2._a + 0.5f, (float)chunkCoordinates2._b + this.yOffset + 0.1f, (float)chunkCoordinates2._c + 0.5f);
        }
        this.sleeping = false;
        if (!this.worldObj.isRemote && bl2) {
            this.worldObj.updateAllPlayersSleepingFlag();
        }
        this.sleepTimer = bl ? 0 : 100;
        if (bl3) {
            this.setSpawnChunk(this.playerLocation, false);
        }
    }

    public boolean isInBed() {
        ChunkCoordinates chunkCoordinates = this.playerLocation;
        int n = this.worldObj.getBlockId(chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c);
        return Block.blocksList[n] != null && Block.blocksList[n].isBed(this.worldObj, chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c, this);
    }

    public static ChunkCoordinates verifyRespawnCoordinates(World world, ChunkCoordinates chunkCoordinates, boolean bl) {
        IChunkProvider iChunkProvider = world.getChunkProvider();
        iChunkProvider._a(chunkCoordinates._a - 3 >> 4, chunkCoordinates._c - 3 >> 4);
        iChunkProvider._a(chunkCoordinates._a + 3 >> 4, chunkCoordinates._c - 3 >> 4);
        iChunkProvider._a(chunkCoordinates._a - 3 >> 4, chunkCoordinates._c + 3 >> 4);
        iChunkProvider._a(chunkCoordinates._a + 3 >> 4, chunkCoordinates._c + 3 >> 4);
        ChunkCoordinates chunkCoordinates2 = chunkCoordinates;
        Block block = Block.blocksList[world.getBlockId(chunkCoordinates2._a, chunkCoordinates2._b, chunkCoordinates2._c)];
        if (block != null && block.isBed(world, chunkCoordinates2._a, chunkCoordinates2._b, chunkCoordinates2._c, null)) {
            ChunkCoordinates chunkCoordinates3 = block.getBedSpawnPosition(world, chunkCoordinates2._a, chunkCoordinates2._b, chunkCoordinates2._c, null);
            return chunkCoordinates3;
        }
        Material material = world.getBlockMaterial(chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c);
        Material material2 = world.getBlockMaterial(chunkCoordinates._a, chunkCoordinates._b + 1, chunkCoordinates._c);
        boolean bl2 = !material._a() && !material._d();
        boolean bl3 = !material2._a() && !material2._d();
        return bl && bl2 && bl3 ? chunkCoordinates : null;
    }

    @SideOnly(value=Side.CLIENT)
    public float getBedOrientationInDegrees() {
        if (this.playerLocation != null) {
            int n = this.playerLocation._a;
            int n2 = this.playerLocation._b;
            int n3 = this.playerLocation._c;
            Block block = Block.blocksList[this.worldObj.getBlockId(n, n2, n3)];
            int n4 = block == null ? 0 : block.getBedDirection(this.worldObj, n, n2, n3);
            switch (n4) {
                case 0: {
                    return 90.0f;
                }
                case 1: {
                    return 0.0f;
                }
                case 2: {
                    return 270.0f;
                }
                case 3: {
                    return 180.0f;
                }
            }
        }
        return 0.0f;
    }

    @Override
    public boolean isPlayerSleeping() {
        return this.sleeping;
    }

    public boolean isPlayerFullyAsleep() {
        return this.sleeping && this.sleepTimer >= 100;
    }

    @SideOnly(value=Side.CLIENT)
    public int getSleepTimer() {
        return this.sleepTimer;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean getHideCape(int n) {
        return (this.dataWatcher._a(16) & 1 << n) != 0;
    }

    public void setHideCape(int n, boolean bl) {
        byte by = this.dataWatcher._a(16);
        if (bl) {
            this.dataWatcher._b(16, (byte)(by | 1 << n));
        } else {
            this.dataWatcher._b(16, (byte)(by & ~(1 << n)));
        }
    }

    public void addChatMessage(String string) {
    }

    @Deprecated
    public ChunkCoordinates getBedLocation() {
        return this.getBedLocation(this.dimension);
    }

    @Deprecated
    public boolean isSpawnForced() {
        return this.isSpawnForced(this.dimension);
    }

    public ChunkCoordinates getBedLocation(int n) {
        if (n == 0) {
            return this.spawnChunk;
        }
        return this.spawnChunkMap.get(n);
    }

    public boolean isSpawnForced(int n) {
        if (n == 0) {
            return this.spawnForced;
        }
        Boolean bl = this.spawnForcedMap.get(n);
        if (bl == null) {
            return false;
        }
        return bl;
    }

    public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean bl) {
        if (this.dimension != 0) {
            this.setSpawnChunk(chunkCoordinates, bl, this.dimension);
            return;
        }
        if (chunkCoordinates != null) {
            this.spawnChunk = new ChunkCoordinates(chunkCoordinates);
            this.spawnForced = bl;
        } else {
            this.spawnChunk = null;
            this.spawnForced = false;
        }
    }

    public void setSpawnChunk(ChunkCoordinates chunkCoordinates, boolean bl, int n) {
        if (n == 0) {
            if (chunkCoordinates != null) {
                this.spawnChunk = new ChunkCoordinates(chunkCoordinates);
                this.spawnForced = bl;
            } else {
                this.spawnChunk = null;
                this.spawnForced = false;
            }
            return;
        }
        if (chunkCoordinates != null) {
            this.spawnChunkMap.put(n, new ChunkCoordinates(chunkCoordinates));
            this.spawnForcedMap.put(n, bl);
        } else {
            this.spawnChunkMap.remove(n);
            this.spawnForcedMap.remove(n);
        }
    }

    public void triggerAchievement(StatBase statBase) {
        this.addStat(statBase, 1);
    }

    public void addStat(StatBase statBase, int n) {
    }

    @Override
    public void jump() {
        if (GloomyHooks.onJump(this)) {
            return;
        }
        super.jump();
        this.addStat(dzif._u, 1);
        if (this.isSprinting()) {
            this.addExhaustion(0.8f);
        } else {
            this.addExhaustion(0.2f);
        }
        GloomyHooks.afterJump(this);
    }

    @Override
    public void moveEntityWithHeading(float f, float f2) {
        double d = this.posX;
        double d2 = this.posY;
        double d3 = this.posZ;
        if (this.capabilities._b && this.ridingEntity == null) {
            double d4 = this.motionY;
            float f3 = this.jumpMovementFactor;
            this.jumpMovementFactor = this.capabilities._a();
            super.moveEntityWithHeading(f, f2);
            this.motionY = d4 * 0.6;
            this.jumpMovementFactor = f3;
        } else {
            super.moveEntityWithHeading(f, f2);
        }
        this.addMovementStat(this.posX - d, this.posY - d2, this.posZ - d3);
    }

    @Override
    public float getAIMoveSpeed() {
        return (float)this.getEntityAttribute(sajz._d)._e();
    }

    public void addMovementStat(double d, double d2, double d3) {
        if (this.ridingEntity == null) {
            if (this.isInsideOfMaterial(Material._h)) {
                int n = Math.round(sajh._a(d * d + d2 * d2 + d3 * d3) * 100.0f);
                if (n > 0) {
                    this.addStat(dzif._q, n);
                    this.addExhaustion(0.015f * (float)n * 0.01f);
                }
            } else if (this.isInWater()) {
                int n = Math.round(sajh._a(d * d + d3 * d3) * 100.0f);
                if (n > 0) {
                    this.addStat(dzif._m, n);
                    this.addExhaustion(0.015f * (float)n * 0.01f);
                }
            } else if (this.isOnLadder()) {
                if (d2 > 0.0) {
                    this.addStat(dzif._o, (int)Math.round(d2 * 100.0));
                }
            } else if (this.onGround) {
                int n = Math.round(sajh._a(d * d + d3 * d3) * 100.0f);
                if (n > 0) {
                    this.addStat(dzif._l, n);
                    if (this.isSprinting()) {
                        this.addExhaustion(0.099999994f * (float)n * 0.01f);
                    } else {
                        this.addExhaustion(0.01f * (float)n * 0.01f);
                    }
                }
            } else {
                int n = Math.round(sajh._a(d * d + d3 * d3) * 100.0f);
                if (n > 25) {
                    this.addStat(dzif._p, n);
                }
            }
        }
    }

    public void addMountedMovementStat(double d, double d2, double d3) {
        int n;
        if (this.ridingEntity != null && (n = Math.round(sajh._a(d * d + d2 * d2 + d3 * d3) * 100.0f)) > 0) {
            if (this.ridingEntity instanceof EntityMinecart) {
                this.addStat(dzif._r, n);
                if (this.startMinecartRidingCoordinate == null) {
                    this.startMinecartRidingCoordinate = new ChunkCoordinates(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ));
                } else if ((double)this.startMinecartRidingCoordinate._b(sajh._c(this.posX), sajh._c(this.posY), sajh._c(this.posZ)) >= 1000000.0) {
                    this.addStat(AchievementList._q, 1);
                }
            } else if (this.ridingEntity instanceof EntityBoat) {
                this.addStat(dzif._s, n);
            } else if (this.ridingEntity instanceof EntityPig) {
                this.addStat(dzif._t, n);
            }
        }
    }

    @Override
    public void fall(float f) {
        if (!this.capabilities._c) {
            if (f >= 2.0f) {
                this.addStat(dzif._n, (int)Math.round((double)f * 100.0));
            }
            super.fall(f);
        } else {
            MinecraftForge.EVENT_BUS.post(new PlayerFlyableFallEvent(this, f));
        }
    }

    @Override
    public void onKillEntity(EntityLivingBase entityLivingBase) {
        if (entityLivingBase instanceof ezey) {
            this.triggerAchievement(AchievementList._s);
        }
    }

    @Override
    public void setInWeb() {
        if (!this.capabilities._b) {
            super.setInWeb();
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public Icon getItemIcon(ItemStack itemStack, int n) {
        Icon icon = super.getItemIcon(itemStack, n);
        if (itemStack._d == Item.fishingRod.itemID && this.fishEntity != null) {
            icon = Item.fishingRod._a();
        } else {
            if (itemStack._a().requiresMultipleRenderPasses()) {
                return itemStack._a().getIcon(itemStack, n);
            }
            if (this.itemInUse != null && itemStack._d == Item.bow.itemID) {
                int n2 = itemStack._n() - this.itemInUseCount;
                if (n2 >= 18) {
                    return Item.bow._a(2);
                }
                if (n2 > 13) {
                    return Item.bow._a(1);
                }
                if (n2 > 0) {
                    return Item.bow._a(0);
                }
            }
            icon = itemStack._a().getIcon(itemStack, n, this, this.itemInUse, this.itemInUseCount);
        }
        return icon;
    }

    public ItemStack getCurrentArmor(int n) {
        return this.inventory._e(n);
    }

    public void addExperience(int n) {
        this.addScore(n);
        int n2 = Integer.MAX_VALUE - this.experienceTotal;
        if (n > n2) {
            n = n2;
        }
        this.experience += (float)n / (float)this.xpBarCap();
        this.experienceTotal += n;
        while (this.experience >= 1.0f) {
            this.experience = (this.experience - 1.0f) * (float)this.xpBarCap();
            this.addExperienceLevel(1);
            this.experience /= (float)this.xpBarCap();
        }
    }

    public void addExperienceLevel(int n) {
        this.experienceLevel += n;
        if (this.experienceLevel < 0) {
            this.experienceLevel = 0;
            this.experience = 0.0f;
            this.experienceTotal = 0;
        }
        if (n > 0 && this.experienceLevel % 5 == 0 && (float)this.field_82249_h < (float)this.ticksExisted - 100.0f) {
            float f = this.experienceLevel > 30 ? 1.0f : (float)this.experienceLevel / 30.0f;
            this.worldObj.playSoundAtEntity(this, "random.levelup", f * 0.75f, 1.0f);
            this.field_82249_h = this.ticksExisted;
        }
    }

    public int xpBarCap() {
        return this.experienceLevel >= 30 ? 62 + (this.experienceLevel - 30) * 7 : (this.experienceLevel >= 15 ? 17 + (this.experienceLevel - 15) * 3 : 17);
    }

    public void addExhaustion(float f) {
        if (!this.capabilities._a && !this.worldObj.isRemote) {
            this.foodStats._a(f);
        }
    }

    public FoodStats getFoodStats() {
        return this.foodStats;
    }

    public boolean canEat(boolean bl) {
        return (bl || this.foodStats._c()) && !this.capabilities._a;
    }

    public boolean shouldHeal() {
        return this.getHealth() > 0.0f && this.getHealth() < this.getMaxHealth();
    }

    public void setItemInUse(ItemStack itemStack, int n) {
        if (itemStack != this.itemInUse) {
            this.itemInUse = itemStack;
            this.itemInUseCount = n;
            if (!this.worldObj.isRemote) {
                this.setEating(true);
            }
        }
    }

    public boolean isCurrentToolAdventureModeExempt(int n, int n2, int n3) {
        if (GloomyHooks.cantDestroyBlock(this, n, n2, n3)) {
            return false;
        }
        if (this.capabilities._e) {
            return true;
        }
        int n4 = this.worldObj.getBlockId(n, n2, n3);
        if (n4 > 0) {
            ItemStack itemStack;
            Block block = Block.blocksList[n4];
            if (block.blockMaterial._q()) {
                return true;
            }
            if (this.getCurrentEquippedItem() != null && ((itemStack = this.getCurrentEquippedItem())._b(block) || itemStack._a(block) > 1.0f)) {
                return true;
            }
        }
        return false;
    }

    public boolean canPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
        return this.capabilities._e ? true : (itemStack != null ? itemStack._z() : false);
    }

    @Override
    public int getExperiencePoints(EntityPlayer entityPlayer) {
        if (this.worldObj.getGameRules()._b("keepInventory")) {
            return 0;
        }
        int n = this.experienceLevel * 7;
        return n > 100 ? 100 : n;
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    @Override
    public String getEntityName() {
        return this.username;
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean getAlwaysRenderNameTagForRender() {
        return true;
    }

    public void clonePlayer(EntityPlayer entityPlayer, boolean bl) {
        if (bl) {
            this.inventory._a(entityPlayer.inventory);
            this.setHealth(entityPlayer.getHealth());
            this.foodStats = entityPlayer.foodStats;
            this.experienceLevel = entityPlayer.experienceLevel;
            this.experienceTotal = entityPlayer.experienceTotal;
            this.experience = entityPlayer.experience;
            this.setScore(entityPlayer.getScore());
            this.teleportDirection = entityPlayer.teleportDirection;
        } else if (this.worldObj.getGameRules()._b("keepInventory")) {
            this.inventory._a(entityPlayer.inventory);
            this.experienceLevel = entityPlayer.experienceLevel;
            this.experienceTotal = entityPlayer.experienceTotal;
            this.experience = entityPlayer.experience;
            this.setScore(entityPlayer.getScore());
        }
        this.spawnChunkMap = entityPlayer.spawnChunkMap;
        this.spawnForcedMap = entityPlayer.spawnForcedMap;
        this.theInventoryEnderChest = entityPlayer.theInventoryEnderChest;
        NBTTagCompound nBTTagCompound = entityPlayer.getEntityData();
        if (nBTTagCompound._c(PERSISTED_NBT_TAG)) {
            this.getEntityData()._a(PERSISTED_NBT_TAG, nBTTagCompound._m(PERSISTED_NBT_TAG));
        }
    }

    @Override
    public boolean canTriggerWalking() {
        return !this.capabilities._b;
    }

    public void sendPlayerAbilities() {
    }

    public void setGameType(EnumGameType enumGameType) {
    }

    @Override
    public String getCommandSenderName() {
        return this.username;
    }

    @Override
    public World getEntityWorld() {
        return this.worldObj;
    }

    public InventoryEnderChest getInventoryEnderChest() {
        return this.theInventoryEnderChest;
    }

    @Override
    public ItemStack func_71124_b(int n) {
        return n == 0 ? this.inventory._a() : this.inventory._b[n - 1];
    }

    @Override
    public ItemStack getHeldItem() {
        return this.inventory._a();
    }

    @Override
    public void setCurrentItemOrArmor(int n, ItemStack itemStack) {
        if (n == 0) {
            this.inventory._a[this.inventory._c] = itemStack;
        } else {
            this.inventory._b[n - 1] = itemStack;
        }
    }

    @Override
    @SideOnly(value=Side.CLIENT)
    public boolean isInvisibleToPlayer(EntityPlayer entityPlayer) {
        if (!this.isInvisible()) {
            return false;
        }
        Team team = this.getTeam();
        return team == null || entityPlayer == null || entityPlayer.getTeam() != team || !team._g();
    }

    @Override
    public ItemStack[] func_70035_c() {
        return this.inventory._b;
    }

    @SideOnly(value=Side.CLIENT)
    public boolean getHideCape() {
        return this.getHideCape(1);
    }

    @Override
    public boolean isPushedByWater() {
        return !this.capabilities._b;
    }

    public Scoreboard getWorldScoreboard() {
        return this.worldObj.getScoreboard();
    }

    @Override
    public Team getTeam() {
        return this.getWorldScoreboard()._g(this.username);
    }

    @Override
    public String getTranslatedEntityName() {
        return ScorePlayerTeam._a(this.getTeam(), this.getDisplayName());
    }

    @Override
    public void setAbsorptionAmount(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        this.getDataWatcher()._b(17, Float.valueOf(f));
    }

    @Override
    public float getAbsorptionAmount() {
        return this.getDataWatcher()._d(17);
    }

    public void openGui(Object object, int n, World world, int n2, int n3, int n4) {
        FMLNetworkHandler.openGui(this, object, n, world, n2, n3, n4);
    }

    public float getDefaultEyeHeight() {
        return 0.12f;
    }

    public String getDisplayName() {
        if (this.displayname == null) {
            this.displayname = ForgeEventFactory.getPlayerDisplayName(this, this.username);
        }
        return this.displayname;
    }

    public void refreshDisplayName() {
        this.displayname = ForgeEventFactory.getPlayerDisplayName(this, this.username);
    }
}

