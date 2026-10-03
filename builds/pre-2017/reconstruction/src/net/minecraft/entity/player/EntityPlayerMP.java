/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.player;

import api.player.server.IServerPlayerAPI;
import api.player.server.ServerPlayerAPI;
import api.player.server.ServerPlayerBase;
import carpentersblocks.CarpentersHooks;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumEntitySize;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecartHopper;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerEnchantment;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetServerHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet101CloseWindow;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet202PlayerAbilities;
import net.minecraft.network.packet.Packet204ClientInfo;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.network.packet.Packet56MapChunks;
import net.minecraft.network.packet.Packet70GameEvent;
import net.minecraft.potion.PotionEffect;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScoreObjectiveCriteria;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.FoodStats;
import net.minecraft.util.sajh;
import net.minecraft.util.turb;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.EnumGameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.world.ChunkWatchEvent;

public class EntityPlayerMP
extends EntityPlayer
implements IServerPlayerAPI,
ICrafting {
    public String translator;
    public NetServerHandler playerNetServerHandler;
    public MinecraftServer mcServer;
    public ItemInWorldManager theItemInWorldManager;
    public double managedPosX;
    public double managedPosZ;
    public final List loadedChunks;
    public final List destroyedItemsNetCache;
    public float field_130068_bO;
    public float lastHealth;
    public int lastFoodLevel;
    public boolean wasHungry;
    public int lastExperience;
    public int field_71145_cl;
    public int renderDistance;
    public int chatVisibility;
    public boolean chatColours;
    public long field_143005_bX;
    public int currentWindowId;
    public boolean field_71137_h;
    public int ping;
    public boolean playerConqueredTheEnd;
    private final ServerPlayerAPI serverPlayerAPI = ServerPlayerAPI.create(this);

    public EntityPlayerMP(MinecraftServer minecraftServer, World world, String string, ItemInWorldManager itemInWorldManager) {
        super(world, string);
        ServerPlayerAPI.beforeLocalConstructing(this, minecraftServer, world, string, itemInWorldManager);
        this.translator = "en_US";
        this.loadedChunks = new LinkedList();
        this.destroyedItemsNetCache = new LinkedList();
        this.field_130068_bO = Float.MIN_VALUE;
        this.lastHealth = -1.0E8f;
        this.lastFoodLevel = -99999999;
        this.wasHungry = true;
        this.lastExperience = -99999999;
        this.field_71145_cl = 60;
        this.chatColours = true;
        this.field_143005_bX = 0L;
        itemInWorldManager._c = this;
        this.theItemInWorldManager = itemInWorldManager;
        this.renderDistance = minecraftServer == null ? 0 : minecraftServer.__ag()._u();
        ChunkCoordinates chunkCoordinates = world.provider._s();
        int n = chunkCoordinates._a;
        int n2 = chunkCoordinates._c;
        int n3 = chunkCoordinates._b;
        this.mcServer = minecraftServer;
        this.stepHeight = 0.0f;
        this.yOffset = 0.0f;
        this.setLocationAndAngles((double)n + 0.5, n3, (double)n2 + 0.5, 0.0f, 0.0f);
        while (!world.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty()) {
            this.setPosition(this.posX, this.posY + 1.0, this.posZ);
        }
        ServerPlayerAPI.afterLocalConstructing(this, minecraftServer, world, string, itemInWorldManager);
    }

    @Override
    public final void localReadEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
        if (nBTTagCompound._c("playerGameType")) {
            if (MinecraftServer._I().__ao()) {
                this.theItemInWorldManager._a(MinecraftServer._I()._r());
            } else {
                this.theItemInWorldManager._a(EnumGameType._a(nBTTagCompound._f("playerGameType")));
            }
        }
    }

    @Override
    public final void localWriteEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
        nBTTagCompound._a("playerGameType", this.theItemInWorldManager._a()._a());
    }

    @Override
    public final void localAddExperienceLevel(int n) {
        super.addExperienceLevel(n);
        this.lastExperience = -1;
    }

    public void addSelfToInternalCraftingInventory() {
        this.openContainer.func_75132_a(this);
    }

    @Override
    public void resetHeight() {
        this.yOffset = 0.0f;
    }

    @Override
    public final void localOnUpdate() {
        Object object;
        Object object2;
        this.theItemInWorldManager._c();
        --this.field_71145_cl;
        this.openContainer.detectAndSendChanges();
        if (!this.worldObj.isRemote && !ForgeHooks.canInteractWith(this, this.openContainer)) {
            this.closeScreen();
            this.openContainer = this.inventoryContainer;
        }
        while (!this.destroyedItemsNetCache.isEmpty()) {
            int n = Math.min(this.destroyedItemsNetCache.size(), 127);
            object2 = new int[n];
            object = this.destroyedItemsNetCache.iterator();
            int n2 = 0;
            while (object.hasNext() && n2 < n) {
                object2[n2++] = (Integer)object.next();
                object.remove();
            }
            this.playerNetServerHandler.func_72567_b(new ixod((int[])object2));
        }
        if (!this.loadedChunks.isEmpty()) {
            ArrayList<Chunk> arrayList = new ArrayList<Chunk>();
            object2 = this.loadedChunks.iterator();
            object = new ArrayList();
            while (object2.hasNext() && arrayList.size() < 5) {
                jjym jjym2 = (jjym)object2.next();
                object2.remove();
                if (jjym2 == null || !this.worldObj.blockExists(jjym2._a << 4, 0, jjym2._b << 4)) continue;
                arrayList.add(this.worldObj.getChunkFromChunkCoords(jjym2._a, jjym2._b));
                ((ArrayList)object).addAll(((WorldServer)this.worldObj).func_73049_a(jjym2._a * 16, 0, jjym2._b * 16, jjym2._a * 16 + 15, 256, jjym2._b * 16 + 15));
            }
            if (!arrayList.isEmpty()) {
                this.playerNetServerHandler.func_72567_b(new Packet56MapChunks(arrayList));
                Iterator iterator2 = ((ArrayList)object).iterator();
                while (iterator2.hasNext()) {
                    TileEntity object3 = (TileEntity)iterator2.next();
                    this.func_71119_a(object3);
                }
                for (Chunk chunk : arrayList) {
                    this.getServerForPlayer().getEntityTracker()._a(this, chunk);
                    MinecraftForge.EVENT_BUS.post(new ChunkWatchEvent.Watch(chunk._k(), this));
                }
            }
        }
        if (this.field_143005_bX > 0L && this.mcServer.__ar() > 0 && MinecraftServer.__aq() - this.field_143005_bX > (long)(this.mcServer.__ar() * 1000 * 60)) {
            this.playerNetServerHandler.func_72565_c("You have been idle for too long!");
        }
    }

    @Override
    public final void localOnUpdateEntity() {
        try {
            super.onUpdate();
            for (int i = 0; i < this.inventory.getSizeInventory(); ++i) {
                Object object;
                ItemStack itemStack = this.inventory.getStackInSlot(i);
                if (itemStack == null || !Item.itemsList[itemStack._d].isMap() || this.playerNetServerHandler.func_72568_e() > 5 || (object = ((nvwc)Item.itemsList[itemStack._d])._a(itemStack, this.worldObj, this)) == null) continue;
                this.playerNetServerHandler.func_72567_b((Packet)object);
            }
            if (this.getHealth() != this.lastHealth || this.lastFoodLevel != this.foodStats._a() || this.foodStats._d() == 0.0f != this.wasHungry) {
                this.playerNetServerHandler.func_72567_b(new sdlz(this.getHealth(), this.foodStats._a(), this.foodStats._d()));
                this.lastHealth = this.getHealth();
                this.lastFoodLevel = this.foodStats._a();
                boolean bl = this.wasHungry = this.foodStats._d() == 0.0f;
            }
            if (this.getHealth() + this.getAbsorptionAmount() != this.field_130068_bO) {
                this.field_130068_bO = this.getHealth() + this.getAbsorptionAmount();
                Collection collection = this.getWorldScoreboard()._a(ScoreObjectiveCriteria._g);
                for (Object object : collection) {
                    this.getWorldScoreboard()._a(this.getEntityName(), (ScoreObjective)object)._a(Arrays.asList(this));
                }
            }
            if (this.experienceTotal != this.lastExperience) {
                this.lastExperience = this.experienceTotal;
                this.playerNetServerHandler.func_72567_b(new rajk(this.experience, this.experienceTotal, this.experienceLevel));
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Ticking player");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Player being ticked");
            this.addEntityCrashInfo(crashReportCategory);
            throw new turb(crashReport);
        }
    }

    @Override
    public final void localOnDeath(DamageSource damageSource) {
        Object object3;
        Object object2;
        if (ForgeHooks.onLivingDeath(this, damageSource)) {
            return;
        }
        this.mcServer.__ag()._a(this.func_110142_aN()._b());
        if (!this.worldObj.getGameRules()._b("keepInventory")) {
            this.captureDrops = true;
            this.capturedDrops.clear();
            this.inventory._f();
            this.captureDrops = false;
            object2 = new PlayerDropsEvent(this, damageSource, this.capturedDrops, this.recentlyHit > 0);
            if (!MinecraftForge.EVENT_BUS.post((Event)object2)) {
                for (Object object3 : this.capturedDrops) {
                    this.joinEntityItemWithWorld((EntityItem)object3);
                }
            }
        }
        object2 = this.worldObj.getScoreboard()._a(ScoreObjectiveCriteria._d);
        Iterator iterator2 = object2.iterator();
        while (iterator2.hasNext()) {
            object3 = (ScoreObjective)iterator2.next();
            Score score = this.getWorldScoreboard()._a(this.getEntityName(), (ScoreObjective)object3);
            score._a();
        }
        object3 = this.func_94060_bK();
        if (object3 != null) {
            ((Entity)object3).addToPlayerScore(this, this.scoreValue);
        }
        this.addStat(dzif._y, 1);
    }

    @Override
    public final boolean localAttackEntityFrom(DamageSource damageSource, float f) {
        boolean bl;
        if (this.isEntityInvulnerable()) {
            return false;
        }
        boolean bl2 = bl = this.mcServer._W() && this.mcServer.__aa() && "fall".equals(damageSource.damageType);
        if (!bl && this.field_71145_cl > 0 && damageSource != DamageSource.outOfWorld) {
            return false;
        }
        if (damageSource instanceof EntityDamageSource) {
            Entity entity = damageSource.getEntity();
            if (entity instanceof EntityPlayer && !this.canAttackPlayer((EntityPlayer)entity)) {
                return false;
            }
            if (entity instanceof EntityArrow) {
                EntityArrow entityArrow = (EntityArrow)entity;
                if (entityArrow.shootingEntity instanceof EntityPlayer && !this.canAttackPlayer((EntityPlayer)entityArrow.shootingEntity)) {
                    return false;
                }
            }
        }
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public boolean canAttackPlayer(EntityPlayer entityPlayer) {
        return !this.mcServer.__aa() ? false : super.canAttackPlayer(entityPlayer);
    }

    @Override
    public void travelToDimension(int n) {
        if (this.dimension == 1 && n == 1) {
            this.triggerAchievement(AchievementList._C);
            this.worldObj.removeEntity(this);
            this.playerConqueredTheEnd = true;
            this.playerNetServerHandler.func_72567_b(new Packet70GameEvent(4, 0));
        } else {
            if (this.dimension == 0 && n == 1) {
                this.triggerAchievement(AchievementList._B);
                ChunkCoordinates chunkCoordinates = this.mcServer._a(n).getEntrancePortalLocation();
                if (chunkCoordinates != null) {
                    this.playerNetServerHandler.setPlayerLocation(chunkCoordinates._a, chunkCoordinates._b, chunkCoordinates._c, 0.0f, 0.0f);
                }
                n = 1;
            } else {
                this.triggerAchievement(AchievementList._x);
            }
            this.mcServer.__ag()._a(this, n);
            this.lastExperience = -1;
            this.lastHealth = -1.0f;
            this.lastFoodLevel = -1;
        }
    }

    public void func_71119_a(TileEntity tileEntity) {
        Packet packet;
        if (tileEntity != null && (packet = tileEntity.getDescriptionPacket()) != null) {
            this.playerNetServerHandler.func_72567_b(packet);
        }
    }

    @Override
    public void onItemPickup(Entity entity, int n) {
        super.onItemPickup(entity, n);
        this.openContainer.detectAndSendChanges();
    }

    @Override
    public EnumStatus sleepInBedAt(int n, int n2, int n3) {
        EnumStatus enumStatus = super.sleepInBedAt(n, n2, n3);
        if (enumStatus == EnumStatus._a) {
            kmuh kmuh2 = new kmuh(this, 0, n, n2, n3);
            this.getServerForPlayer().getEntityTracker()._a((Entity)this, kmuh2);
            this.playerNetServerHandler.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.playerNetServerHandler.func_72567_b(kmuh2);
        }
        return enumStatus;
    }

    @Override
    public void wakeUpPlayer(boolean bl, boolean bl2, boolean bl3) {
        if (this.isPlayerSleeping()) {
            this.getServerForPlayer().getEntityTracker()._b(this, new Packet18Animation(this, 3));
        }
        super.wakeUpPlayer(bl, bl2, bl3);
        if (this.playerNetServerHandler != null) {
            this.playerNetServerHandler.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        }
    }

    @Override
    public void mountEntity(Entity entity) {
        super.mountEntity(entity);
        this.playerNetServerHandler.func_72567_b(new nwaj(0, this, this.ridingEntity));
        this.playerNetServerHandler.setPlayerLocation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
    }

    @Override
    public void updateFallState(double d, boolean bl) {
    }

    public void func_71122_b(double d, boolean bl) {
        super.updateFallState(d, bl);
    }

    @Override
    public void displayGUIEditSign(TileEntity tileEntity) {
        if (tileEntity instanceof TileEntitySign) {
            ((TileEntitySign)tileEntity)._a(this);
            this.playerNetServerHandler.func_72567_b(new wpwt(0, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord));
        }
    }

    public void func_71117_bO() {
        this.currentWindowId = this.currentWindowId % 100 + 1;
    }

    @Override
    public final void localDisplayGUIWorkbench(int n, int n2, int n3) {
        this.func_71117_bO();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, 1, "Crafting", 9, true));
        this.openContainer = new ContainerWorkbench(this.inventory, this.worldObj, n, n2, n3);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
    }

    @Override
    public void displayGUIEnchantment(int n, int n2, int n3, String string) {
        this.func_71117_bO();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, 4, string == null ? "" : string, 9, string != null));
        this.openContainer = new ContainerEnchantment(this.inventory, this.worldObj, n, n2, n3);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
    }

    @Override
    public void displayGUIAnvil(int n, int n2, int n3) {
        this.func_71117_bO();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, 8, "Repairing", 9, true));
        this.openContainer = new ContainerRepair(this.inventory, this.worldObj, n, n2, n3, this);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
    }

    @Override
    public final void localDisplayGUIChest(IInventory iInventory) {
        if (this.openContainer != this.inventoryContainer) {
            this.closeScreen();
        }
        this.func_71117_bO();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, 0, iInventory.getInvName(), iInventory.getSizeInventory(), iInventory.isInvNameLocalized()));
        this.openContainer = new wpkx(this.inventory, iInventory);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
    }

    @Override
    public void displayGUIHopper(TileEntityHopper tileEntityHopper) {
        this.func_71117_bO();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, 9, tileEntityHopper.getInvName(), tileEntityHopper.getSizeInventory(), tileEntityHopper.isInvNameLocalized()));
        this.openContainer = new xsns(this.inventory, tileEntityHopper);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
    }

    @Override
    public void displayGUIHopperMinecart(EntityMinecartHopper entityMinecartHopper) {
        this.func_71117_bO();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, 9, entityMinecartHopper.getInvName(), entityMinecartHopper.getSizeInventory(), entityMinecartHopper.isInvNameLocalized()));
        this.openContainer = new xsns(this.inventory, entityMinecartHopper);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
    }

    @Override
    public final void localDisplayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
        this.func_71117_bO();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, 2, tileEntityFurnace.getInvName(), tileEntityFurnace.getSizeInventory(), tileEntityFurnace.isInvNameLocalized()));
        this.openContainer = new lplm(this.inventory, tileEntityFurnace);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
    }

    @Override
    public final void localDisplayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
        this.func_71117_bO();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, tileEntityDispenser instanceof hdtl ? 10 : 3, tileEntityDispenser.getInvName(), tileEntityDispenser.getSizeInventory(), tileEntityDispenser.isInvNameLocalized()));
        this.openContainer = new bbok(this.inventory, tileEntityDispenser);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
    }

    @Override
    public void displayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
        this.func_71117_bO();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, 5, tileEntityBrewingStand.getInvName(), tileEntityBrewingStand.getSizeInventory(), tileEntityBrewingStand.isInvNameLocalized()));
        this.openContainer = new tgbu(this.inventory, tileEntityBrewingStand);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
    }

    @Override
    public void displayGUIBeacon(TileEntityBeacon tileEntityBeacon) {
        this.func_71117_bO();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, 7, tileEntityBeacon.getInvName(), tileEntityBeacon.getSizeInventory(), tileEntityBeacon.isInvNameLocalized()));
        this.openContainer = new ixdv(this.inventory, tileEntityBeacon);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
    }

    @Override
    public void displayGUIMerchant(IMerchant iMerchant, String string) {
        this.func_71117_bO();
        this.openContainer = new ContainerMerchant(this.inventory, iMerchant, this.worldObj);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
        InventoryMerchant inventoryMerchant = ((ContainerMerchant)this.openContainer)._a();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, 6, string == null ? "" : string, inventoryMerchant.getSizeInventory(), string != null));
        MerchantRecipeList merchantRecipeList = iMerchant.getRecipes(this);
        if (merchantRecipeList != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(this.currentWindowId);
                merchantRecipeList._a(dataOutputStream);
                this.playerNetServerHandler.func_72567_b(new Packet250CustomPayload("MC|TrList", byteArrayOutputStream.toByteArray()));
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    @Override
    public void displayGUIHorse(EntityHorse entityHorse, IInventory iInventory) {
        if (this.openContainer != this.inventoryContainer) {
            this.closeScreen();
        }
        this.func_71117_bO();
        this.playerNetServerHandler.func_72567_b(new lpub(this.currentWindowId, 11, iInventory.getInvName(), iInventory.getSizeInventory(), iInventory.isInvNameLocalized(), entityHorse.entityId));
        this.openContainer = new qnzl(this.inventory, iInventory, entityHorse);
        this.openContainer.windowId = this.currentWindowId;
        this.openContainer.func_75132_a(this);
    }

    @Override
    public void sendSlotContents(Container container, int n, ItemStack itemStack) {
        if (!(container.getSlot(n) instanceof pkzb) && !this.field_71137_h) {
            this.playerNetServerHandler.func_72567_b(new ixmv(container.windowId, n, itemStack));
        }
    }

    public void sendContainerToPlayer(Container container) {
        this.func_71110_a(container, container.getInventory());
    }

    @Override
    public void func_71110_a(Container container, List list) {
        this.playerNetServerHandler.func_72567_b(new wptu(container.windowId, list));
        this.playerNetServerHandler.func_72567_b(new ixmv(-1, -1, this.inventory._g()));
    }

    @Override
    public void sendProgressBarUpdate(Container container, int n, int n2) {
        this.playerNetServerHandler.func_72567_b(new neyc(container.windowId, n, n2));
    }

    @Override
    public void closeScreen() {
        this.playerNetServerHandler.func_72567_b(new Packet101CloseWindow(this.openContainer.windowId));
        this.closeContainer();
    }

    public void updateHeldItem() {
        if (!this.field_71137_h) {
            this.playerNetServerHandler.func_72567_b(new ixmv(-1, -1, this.inventory._g()));
        }
    }

    public void closeContainer() {
        this.openContainer.onContainerClosed(this);
        this.openContainer = this.inventoryContainer;
    }

    public void setEntityActionState(float f, float f2, boolean bl, boolean bl2) {
        if (this.ridingEntity != null) {
            if (f >= -1.0f && f <= 1.0f) {
                this.moveStrafing = f;
            }
            if (f2 >= -1.0f && f2 <= 1.0f) {
                this.moveForward = f2;
            }
            this.isJumping = bl;
            this.setSneaking(bl2);
        }
    }

    @Override
    public void addStat(StatBase statBase, int n) {
        if (statBase != null && !statBase.isIndependent) {
            this.playerNetServerHandler.func_72567_b(new dzcl(statBase.statId, n));
        }
    }

    public void mountEntityAndWakeUp() {
        if (this.riddenByEntity != null) {
            this.riddenByEntity.mountEntity(this);
        }
        if (this.sleeping) {
            this.wakeUpPlayer(true, false, false);
        }
    }

    public void setPlayerHealthUpdated() {
        this.lastHealth = -1.0E8f;
    }

    @Override
    public void addChatMessage(String string) {
        this.playerNetServerHandler.func_72567_b(new Packet3Chat(ChatMessageComponent._e(string)));
    }

    @Override
    public void onItemUseFinish() {
        this.playerNetServerHandler.func_72567_b(new bszz(this.entityId, 9));
        super.onItemUseFinish();
    }

    @Override
    public void setItemInUse(ItemStack itemStack, int n) {
        super.setItemInUse(itemStack, n);
        if (itemStack != null && itemStack._a() != null && itemStack._a().getItemUseAction(itemStack) == EnumAction._b) {
            this.getServerForPlayer().getEntityTracker()._b(this, new Packet18Animation(this, 5));
        }
    }

    @Override
    public final void localClonePlayer(EntityPlayer entityPlayer, boolean bl) {
        super.clonePlayer(entityPlayer, bl);
        this.lastExperience = -1;
        this.lastHealth = -1.0f;
        this.lastFoodLevel = -1;
        this.destroyedItemsNetCache.addAll(((EntityPlayerMP)entityPlayer).destroyedItemsNetCache);
    }

    @Override
    public void onNewPotionEffect(PotionEffect potionEffect) {
        super.onNewPotionEffect(potionEffect);
        this.playerNetServerHandler.func_72567_b(new cwaw(this.entityId, potionEffect));
    }

    @Override
    public void onChangedPotionEffect(PotionEffect potionEffect, boolean bl) {
        super.onChangedPotionEffect(potionEffect, bl);
        this.playerNetServerHandler.func_72567_b(new cwaw(this.entityId, potionEffect));
    }

    @Override
    public void onFinishedPotionEffect(PotionEffect potionEffect) {
        super.onFinishedPotionEffect(potionEffect);
        this.playerNetServerHandler.func_72567_b(new zibp(this.entityId, potionEffect));
    }

    @Override
    public void setPositionAndUpdate(double d, double d2, double d3) {
        this.playerNetServerHandler.setPlayerLocation(d, d2, d3, this.rotationYaw, this.rotationPitch);
    }

    @Override
    public void onCriticalHit(Entity entity) {
        this.getServerForPlayer().getEntityTracker()._b(this, new Packet18Animation(entity, 6));
    }

    @Override
    public void onEnchantmentCritical(Entity entity) {
        this.getServerForPlayer().getEntityTracker()._b(this, new Packet18Animation(entity, 7));
    }

    @Override
    public void sendPlayerAbilities() {
        if (this.playerNetServerHandler != null) {
            this.playerNetServerHandler.func_72567_b(new Packet202PlayerAbilities(this.capabilities));
        }
    }

    public WorldServer getServerForPlayer() {
        return (WorldServer)this.worldObj;
    }

    @Override
    public void setGameType(EnumGameType enumGameType) {
        this.theItemInWorldManager._a(enumGameType);
        this.playerNetServerHandler.func_72567_b(new Packet70GameEvent(3, enumGameType._a()));
    }

    @Override
    public void sendChatToPlayer(ChatMessageComponent chatMessageComponent) {
        this.playerNetServerHandler.func_72567_b(new Packet3Chat(chatMessageComponent));
    }

    @Override
    public boolean canCommandSenderUseCommand(int n, String string) {
        return "seed".equals(string) && !this.mcServer._W() ? true : (!("tell".equals(string) || "help".equals(string) || "me".equals(string)) ? (this.mcServer.__ag()._g(this.username) ? this.mcServer._u() >= n : false) : true);
    }

    public String getPlayerIP() {
        String string = this.playerNetServerHandler.netManager._c().toString();
        string = string.substring(string.indexOf("/") + 1);
        string = string.substring(0, string.indexOf(":"));
        return string;
    }

    public void updateClientInfo(Packet204ClientInfo packet204ClientInfo) {
        this.translator = packet204ClientInfo._a();
        int n = 256 >> packet204ClientInfo._b();
        if (n > 3 && n < 15) {
            this.renderDistance = n;
        }
        this.chatVisibility = packet204ClientInfo._c();
        this.chatColours = packet204ClientInfo._d();
        if (this.mcServer._N() && this.mcServer._M().equals(this.username)) {
            this.mcServer._c(packet204ClientInfo._e());
        }
        this.setHideCape(1, !packet204ClientInfo._f());
    }

    public int getChatVisibility() {
        return this.chatVisibility;
    }

    public void requestTexturePackLoad(String string, int n) {
        String string2 = string + "\u0000" + n;
        this.playerNetServerHandler.func_72567_b(new Packet250CustomPayload("MC|TPack", string2.getBytes()));
    }

    @Override
    public ChunkCoordinates func_82114_b() {
        return new ChunkCoordinates(sajh._c(this.posX), sajh._c(this.posY + 0.5), sajh._c(this.posZ));
    }

    public void func_143004_u() {
        this.field_143005_bX = MinecraftServer.__aq();
    }

    @Override
    public float getDefaultEyeHeight() {
        return 1.62f;
    }

    @Override
    public void addExhaustion(float f) {
        ServerPlayerAPI.addExhaustion(this, f);
    }

    @Override
    public final void realAddExhaustion(float f) {
        this.addExhaustion(f);
    }

    @Override
    public final void superAddExhaustion(float f) {
        super.addExhaustion(f);
    }

    @Override
    public final void localAddExhaustion(float f) {
        super.addExhaustion(f);
    }

    @Override
    public void addExperience(int n) {
        ServerPlayerAPI.addExperience(this, n);
    }

    @Override
    public final void realAddExperience(int n) {
        this.addExperience(n);
    }

    @Override
    public final void superAddExperience(int n) {
        super.addExperience(n);
    }

    @Override
    public final void localAddExperience(int n) {
        super.addExperience(n);
    }

    @Override
    public void addExperienceLevel(int n) {
        ServerPlayerAPI.addExperienceLevel(this, n);
    }

    @Override
    public final void realAddExperienceLevel(int n) {
        this.addExperienceLevel(n);
    }

    @Override
    public final void superAddExperienceLevel(int n) {
        super.addExperienceLevel(n);
    }

    @Override
    public void addMovementStat(double d, double d2, double d3) {
        ServerPlayerAPI.addMovementStat(this, d, d2, d3);
    }

    @Override
    public final void realAddMovementStat(double d, double d2, double d3) {
        this.addMovementStat(d, d2, d3);
    }

    @Override
    public final void superAddMovementStat(double d, double d2, double d3) {
        super.addMovementStat(d, d2, d3);
    }

    @Override
    public final void localAddMovementStat(double d, double d2, double d3) {
        super.addMovementStat(d, d2, d3);
    }

    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        return ServerPlayerAPI.attackEntityFrom(this, damageSource, f);
    }

    @Override
    public final boolean realAttackEntityFrom(DamageSource damageSource, float f) {
        return this.attackEntityFrom(damageSource, f);
    }

    @Override
    public final boolean superAttackEntityFrom(DamageSource damageSource, float f) {
        return super.attackEntityFrom(damageSource, f);
    }

    @Override
    public void attackTargetEntityWithCurrentItem(Entity entity) {
        ServerPlayerAPI.attackTargetEntityWithCurrentItem(this, entity);
    }

    @Override
    public final void realAttackTargetEntityWithCurrentItem(Entity entity) {
        this.attackTargetEntityWithCurrentItem(entity);
    }

    @Override
    public final void superAttackTargetEntityWithCurrentItem(Entity entity) {
        super.attackTargetEntityWithCurrentItem(entity);
    }

    @Override
    public final void localAttackTargetEntityWithCurrentItem(Entity entity) {
        super.attackTargetEntityWithCurrentItem(entity);
    }

    @Override
    public boolean canHarvestBlock(Block block) {
        return ServerPlayerAPI.canHarvestBlock(this, block);
    }

    @Override
    public final boolean realCanHarvestBlock(Block block) {
        return this.canHarvestBlock(block);
    }

    @Override
    public final boolean superCanHarvestBlock(Block block) {
        return super.canHarvestBlock(block);
    }

    @Override
    public final boolean localCanHarvestBlock(Block block) {
        return super.canHarvestBlock(block);
    }

    @Override
    public boolean canPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
        return ServerPlayerAPI.canPlayerEdit(this, n, n2, n3, n4, itemStack);
    }

    @Override
    public final boolean realCanPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
        return this.canPlayerEdit(n, n2, n3, n4, itemStack);
    }

    @Override
    public final boolean superCanPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
        return super.canPlayerEdit(n, n2, n3, n4, itemStack);
    }

    @Override
    public final boolean localCanPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
        return super.canPlayerEdit(n, n2, n3, n4, itemStack);
    }

    @Override
    public boolean canTriggerWalking() {
        return ServerPlayerAPI.canTriggerWalking(this);
    }

    @Override
    public final boolean realCanTriggerWalking() {
        return this.canTriggerWalking();
    }

    @Override
    public final boolean superCanTriggerWalking() {
        return super.canTriggerWalking();
    }

    @Override
    public final boolean localCanTriggerWalking() {
        return super.canTriggerWalking();
    }

    @Override
    public void clonePlayer(EntityPlayer entityPlayer, boolean bl) {
        ServerPlayerAPI.clonePlayer(this, entityPlayer, bl);
    }

    @Override
    public final void realClonePlayer(EntityPlayer entityPlayer, boolean bl) {
        this.clonePlayer(entityPlayer, bl);
    }

    @Override
    public final void superClonePlayer(EntityPlayer entityPlayer, boolean bl) {
        super.clonePlayer(entityPlayer, bl);
    }

    @Override
    public void damageEntity(DamageSource damageSource, float f) {
        ServerPlayerAPI.damageEntity(this, damageSource, f);
    }

    @Override
    public final void realDamageEntity(DamageSource damageSource, float f) {
        this.damageEntity(damageSource, f);
    }

    @Override
    public final void superDamageEntity(DamageSource damageSource, float f) {
        super.damageEntity(damageSource, f);
    }

    @Override
    public final void localDamageEntity(DamageSource damageSource, float f) {
        super.damageEntity(damageSource, f);
    }

    @Override
    public void displayGUIChest(IInventory iInventory) {
        ServerPlayerAPI.displayGUIChest(this, iInventory);
    }

    @Override
    public final void realDisplayGUIChest(IInventory iInventory) {
        this.displayGUIChest(iInventory);
    }

    @Override
    public final void superDisplayGUIChest(IInventory iInventory) {
        super.displayGUIChest(iInventory);
    }

    @Override
    public void displayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
        ServerPlayerAPI.displayGUIDispenser(this, tileEntityDispenser);
    }

    @Override
    public final void realDisplayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
        this.displayGUIDispenser(tileEntityDispenser);
    }

    @Override
    public final void superDisplayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
        super.displayGUIDispenser(tileEntityDispenser);
    }

    @Override
    public void displayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
        ServerPlayerAPI.displayGUIFurnace(this, tileEntityFurnace);
    }

    @Override
    public final void realDisplayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
        this.displayGUIFurnace(tileEntityFurnace);
    }

    @Override
    public final void superDisplayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
        super.displayGUIFurnace(tileEntityFurnace);
    }

    @Override
    public void displayGUIWorkbench(int n, int n2, int n3) {
        ServerPlayerAPI.displayGUIWorkbench(this, n, n2, n3);
    }

    @Override
    public final void realDisplayGUIWorkbench(int n, int n2, int n3) {
        this.displayGUIWorkbench(n, n2, n3);
    }

    @Override
    public final void superDisplayGUIWorkbench(int n, int n2, int n3) {
        super.displayGUIWorkbench(n, n2, n3);
    }

    @Override
    public EntityItem dropOneItem(boolean bl) {
        return ServerPlayerAPI.dropOneItem(this, bl);
    }

    @Override
    public final EntityItem realDropOneItem(boolean bl) {
        return this.dropOneItem(bl);
    }

    @Override
    public final EntityItem superDropOneItem(boolean bl) {
        return super.dropOneItem(bl);
    }

    @Override
    public final EntityItem localDropOneItem(boolean bl) {
        return super.dropOneItem(bl);
    }

    @Override
    public EntityItem dropPlayerItem(ItemStack itemStack) {
        return ServerPlayerAPI.dropPlayerItem(this, itemStack);
    }

    @Override
    public final EntityItem realDropPlayerItem(ItemStack itemStack) {
        return this.dropPlayerItem(itemStack);
    }

    @Override
    public final EntityItem superDropPlayerItem(ItemStack itemStack) {
        return super.dropPlayerItem(itemStack);
    }

    @Override
    public final EntityItem localDropPlayerItem(ItemStack itemStack) {
        return super.dropPlayerItem(itemStack);
    }

    @Override
    public void fall(float f) {
        ServerPlayerAPI.fall(this, f);
    }

    @Override
    public final void realFall(float f) {
        this.fall(f);
    }

    @Override
    public final void superFall(float f) {
        super.fall(f);
    }

    @Override
    public final void localFall(float f) {
        super.fall(f);
    }

    @Override
    public float getCurrentPlayerStrVsBlock(Block block, boolean bl) {
        return ServerPlayerAPI.getCurrentPlayerStrVsBlock(this, block, bl);
    }

    @Override
    public final float realGetCurrentPlayerStrVsBlock(Block block, boolean bl) {
        return this.getCurrentPlayerStrVsBlock(block, bl);
    }

    @Override
    public final float superGetCurrentPlayerStrVsBlock(Block block, boolean bl) {
        return super.getCurrentPlayerStrVsBlock(block, bl);
    }

    @Override
    public final float localGetCurrentPlayerStrVsBlock(Block block, boolean bl) {
        return super.getCurrentPlayerStrVsBlock(block, bl);
    }

    @Override
    public float getCurrentPlayerStrVsBlock(Block block, boolean bl, int n) {
        return ServerPlayerAPI.getCurrentPlayerStrVsBlockForge(this, block, bl, n);
    }

    @Override
    public final float realGetCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
        return this.getCurrentPlayerStrVsBlock(block, bl, n);
    }

    @Override
    public final float superGetCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
        return super.getCurrentPlayerStrVsBlock(block, bl, n);
    }

    @Override
    public final float localGetCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
        return super.getCurrentPlayerStrVsBlock(block, bl, n);
    }

    @Override
    public double getDistanceSq(double d, double d2, double d3) {
        return ServerPlayerAPI.getDistanceSq(this, d, d2, d3);
    }

    @Override
    public final double realGetDistanceSq(double d, double d2, double d3) {
        return this.getDistanceSq(d, d2, d3);
    }

    @Override
    public final double superGetDistanceSq(double d, double d2, double d3) {
        return super.getDistanceSq(d, d2, d3);
    }

    @Override
    public final double localGetDistanceSq(double d, double d2, double d3) {
        return super.getDistanceSq(d, d2, d3);
    }

    @Override
    public float getBrightness(float f) {
        return ServerPlayerAPI.getBrightness(this, f);
    }

    @Override
    public final float realGetBrightness(float f) {
        return this.getBrightness(f);
    }

    @Override
    public final float superGetBrightness(float f) {
        return super.getBrightness(f);
    }

    @Override
    public final float localGetBrightness(float f) {
        return super.getBrightness(f);
    }

    @Override
    public float getEyeHeight() {
        return ServerPlayerAPI.getEyeHeight(this);
    }

    @Override
    public final float realGetEyeHeight() {
        return this.getEyeHeight();
    }

    @Override
    public final float superGetEyeHeight() {
        return super.getEyeHeight();
    }

    @Override
    public final float localGetEyeHeight() {
        return super.getEyeHeight();
    }

    @Override
    public void heal(float f) {
        ServerPlayerAPI.heal(this, f);
    }

    @Override
    public final void realHeal(float f) {
        this.heal(f);
    }

    @Override
    public final void superHeal(float f) {
        super.heal(f);
    }

    @Override
    public final void localHeal(float f) {
        super.heal(f);
    }

    @Override
    public boolean isEntityInsideOpaqueBlock() {
        return ServerPlayerAPI.isEntityInsideOpaqueBlock(this);
    }

    @Override
    public final boolean realIsEntityInsideOpaqueBlock() {
        return this.isEntityInsideOpaqueBlock();
    }

    @Override
    public final boolean superIsEntityInsideOpaqueBlock() {
        return super.isEntityInsideOpaqueBlock();
    }

    @Override
    public final boolean localIsEntityInsideOpaqueBlock() {
        return super.isEntityInsideOpaqueBlock();
    }

    @Override
    public boolean isInWater() {
        return ServerPlayerAPI.isInWater(this);
    }

    @Override
    public final boolean realIsInWater() {
        return this.isInWater();
    }

    @Override
    public final boolean superIsInWater() {
        return super.isInWater();
    }

    @Override
    public final boolean localIsInWater() {
        return super.isInWater();
    }

    @Override
    public boolean isInsideOfMaterial(Material material) {
        return ServerPlayerAPI.isInsideOfMaterial(this, material);
    }

    @Override
    public final boolean realIsInsideOfMaterial(Material material) {
        return this.isInsideOfMaterial(material);
    }

    @Override
    public final boolean superIsInsideOfMaterial(Material material) {
        return super.isInsideOfMaterial(material);
    }

    @Override
    public final boolean localIsInsideOfMaterial(Material material) {
        return super.isInsideOfMaterial(material);
    }

    @Override
    public boolean isOnLadder() {
        return ServerPlayerAPI.isOnLadder(this);
    }

    @Override
    public final boolean realIsOnLadder() {
        return this.isOnLadder();
    }

    @Override
    public final boolean superIsOnLadder() {
        return super.isOnLadder();
    }

    @Override
    public final boolean localIsOnLadder() {
        return super.isOnLadder();
    }

    @Override
    public boolean isPlayerSleeping() {
        return ServerPlayerAPI.isPlayerSleeping(this);
    }

    @Override
    public final boolean realIsPlayerSleeping() {
        return this.isPlayerSleeping();
    }

    @Override
    public final boolean superIsPlayerSleeping() {
        return super.isPlayerSleeping();
    }

    @Override
    public final boolean localIsPlayerSleeping() {
        return super.isPlayerSleeping();
    }

    @Override
    public void jump() {
        ServerPlayerAPI.jump(this);
    }

    @Override
    public final void realJump() {
        this.jump();
    }

    @Override
    public final void superJump() {
        super.jump();
    }

    @Override
    public final void localJump() {
        super.jump();
    }

    @Override
    public void knockBack(Entity entity, float f, double d, double d2) {
        ServerPlayerAPI.knockBack(this, entity, f, d, d2);
    }

    @Override
    public final void realKnockBack(Entity entity, float f, double d, double d2) {
        this.knockBack(entity, f, d, d2);
    }

    @Override
    public final void superKnockBack(Entity entity, float f, double d, double d2) {
        super.knockBack(entity, f, d, d2);
    }

    @Override
    public final void localKnockBack(Entity entity, float f, double d, double d2) {
        super.knockBack(entity, f, d, d2);
    }

    @Override
    public void moveEntity(double d, double d2, double d3) {
        ServerPlayerAPI.moveEntity(this, d, d2, d3);
    }

    @Override
    public final void realMoveEntity(double d, double d2, double d3) {
        this.moveEntity(d, d2, d3);
    }

    @Override
    public final void superMoveEntity(double d, double d2, double d3) {
        super.moveEntity(d, d2, d3);
    }

    @Override
    public final void localMoveEntity(double d, double d2, double d3) {
        super.moveEntity(d, d2, d3);
    }

    @Override
    public void moveEntityWithHeading(float f, float f2) {
        ServerPlayerAPI.moveEntityWithHeading(this, f, f2);
    }

    @Override
    public final void realMoveEntityWithHeading(float f, float f2) {
        this.moveEntityWithHeading(f, f2);
    }

    @Override
    public final void superMoveEntityWithHeading(float f, float f2) {
        super.moveEntityWithHeading(f, f2);
    }

    @Override
    public final void localMoveEntityWithHeading(float f, float f2) {
        super.moveEntityWithHeading(f, f2);
    }

    @Override
    public void moveFlying(float f, float f2, float f3) {
        ServerPlayerAPI.moveFlying(this, f, f2, f3);
    }

    @Override
    public final void realMoveFlying(float f, float f2, float f3) {
        this.moveFlying(f, f2, f3);
    }

    @Override
    public final void superMoveFlying(float f, float f2, float f3) {
        super.moveFlying(f, f2, f3);
    }

    @Override
    public final void localMoveFlying(float f, float f2, float f3) {
        super.moveFlying(f, f2, f3);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        ServerPlayerAPI.onDeath(this, damageSource);
    }

    @Override
    public final void realOnDeath(DamageSource damageSource) {
        this.onDeath(damageSource);
    }

    @Override
    public final void superOnDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
    }

    @Override
    public void onLivingUpdate() {
        ServerPlayerAPI.onLivingUpdate(this);
    }

    @Override
    public final void realOnLivingUpdate() {
        this.onLivingUpdate();
    }

    @Override
    public final void superOnLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    public final void localOnLivingUpdate() {
        super.onLivingUpdate();
    }

    @Override
    public void onKillEntity(EntityLivingBase entityLivingBase) {
        ServerPlayerAPI.onKillEntity(this, entityLivingBase);
    }

    @Override
    public final void realOnKillEntity(EntityLivingBase entityLivingBase) {
        this.onKillEntity(entityLivingBase);
    }

    @Override
    public final void superOnKillEntity(EntityLivingBase entityLivingBase) {
        super.onKillEntity(entityLivingBase);
    }

    @Override
    public final void localOnKillEntity(EntityLivingBase entityLivingBase) {
        super.onKillEntity(entityLivingBase);
    }

    @Override
    public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
        ServerPlayerAPI.onStruckByLightning(this, entityLightningBolt);
    }

    @Override
    public final void realOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
        this.onStruckByLightning(entityLightningBolt);
    }

    @Override
    public final void superOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
        super.onStruckByLightning(entityLightningBolt);
    }

    @Override
    public final void localOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
        super.onStruckByLightning(entityLightningBolt);
    }

    @Override
    public void onUpdate() {
        CarpentersHooks.onUpdate(this);
    }

    @Override
    public final void realOnUpdate() {
        this.onUpdate();
    }

    @Override
    public final void superOnUpdate() {
        super.onUpdate();
    }

    public void onUpdateEntity() {
        ServerPlayerAPI.onUpdateEntity(this);
    }

    @Override
    public final void realOnUpdateEntity() {
        this.onUpdateEntity();
    }

    public final void superOnUpdateEntity() {
        super.h();
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        ServerPlayerAPI.readEntityFromNBT(this, nBTTagCompound);
    }

    @Override
    public final void realReadEntityFromNBT(NBTTagCompound nBTTagCompound) {
        this.readEntityFromNBT(nBTTagCompound);
    }

    @Override
    public final void superReadEntityFromNBT(NBTTagCompound nBTTagCompound) {
        super.readEntityFromNBT(nBTTagCompound);
    }

    @Override
    public void setDead() {
        ServerPlayerAPI.setDead(this);
    }

    @Override
    public final void realSetDead() {
        this.setDead();
    }

    @Override
    public final void superSetDead() {
        super.setDead();
    }

    @Override
    public final void localSetDead() {
        super.setDead();
    }

    @Override
    public void setPosition(double d, double d2, double d3) {
        ServerPlayerAPI.setPosition(this, d, d2, d3);
    }

    @Override
    public final void realSetPosition(double d, double d2, double d3) {
        this.setPosition(d, d2, d3);
    }

    @Override
    public final void superSetPosition(double d, double d2, double d3) {
        super.setPosition(d, d2, d3);
    }

    @Override
    public final void localSetPosition(double d, double d2, double d3) {
        super.setPosition(d, d2, d3);
    }

    @Override
    public void swingItem() {
        ServerPlayerAPI.swingItem(this);
    }

    @Override
    public final void realSwingItem() {
        this.swingItem();
    }

    @Override
    public final void superSwingItem() {
        super.swingItem();
    }

    @Override
    public final void localSwingItem() {
        super.swingItem();
    }

    @Override
    public void updateEntityActionState() {
        ServerPlayerAPI.updateEntityActionState(this);
    }

    @Override
    public final void realUpdateEntityActionState() {
        this.updateEntityActionState();
    }

    @Override
    public final void superUpdateEntityActionState() {
        super.updateEntityActionState();
    }

    @Override
    public final void localUpdateEntityActionState() {
        super.updateEntityActionState();
    }

    @Override
    public void updatePotionEffects() {
        ServerPlayerAPI.updatePotionEffects(this);
    }

    @Override
    public final void realUpdatePotionEffects() {
        this.updatePotionEffects();
    }

    @Override
    public final void superUpdatePotionEffects() {
        super.updatePotionEffects();
    }

    @Override
    public final void localUpdatePotionEffects() {
        super.updatePotionEffects();
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        ServerPlayerAPI.writeEntityToNBT(this, nBTTagCompound);
    }

    @Override
    public final void realWriteEntityToNBT(NBTTagCompound nBTTagCompound) {
        this.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public final void superWriteEntityToNBT(NBTTagCompound nBTTagCompound) {
        super.writeEntityToNBT(nBTTagCompound);
    }

    @Override
    public final boolean getAddedToChunkField() {
        return this.addedToChunk;
    }

    @Override
    public final void setAddedToChunkField(boolean bl) {
        this.addedToChunk = bl;
    }

    @Override
    public final int getArrowHitTimerField() {
        return this.arrowHitTimer;
    }

    @Override
    public final void setArrowHitTimerField(int n) {
        this.arrowHitTimer = n;
    }

    @Override
    public final int getAttackTimeField() {
        return this.attackTime;
    }

    @Override
    public final void setAttackTimeField(int n) {
        this.attackTime = n;
    }

    @Override
    public final float getAttackedAtYawField() {
        return this.attackedAtYaw;
    }

    @Override
    public final void setAttackedAtYawField(float f) {
        this.attackedAtYaw = f;
    }

    @Override
    public final EntityPlayer getAttackingPlayerField() {
        return this.attackingPlayer;
    }

    @Override
    public final void setAttackingPlayerField(EntityPlayer entityPlayer) {
        this.attackingPlayer = entityPlayer;
    }

    @Override
    public final AxisAlignedBB getBoundingBoxField() {
        return this.boundingBox;
    }

    @Override
    public final float getCameraPitchField() {
        return this.cameraPitch;
    }

    @Override
    public final void setCameraPitchField(float f) {
        this.cameraPitch = f;
    }

    @Override
    public final float getCameraYawField() {
        return this.cameraYaw;
    }

    @Override
    public final void setCameraYawField(float f) {
        this.cameraYaw = f;
    }

    @Override
    public final PlayerCapabilities getCapabilitiesField() {
        return this.capabilities;
    }

    @Override
    public final void setCapabilitiesField(PlayerCapabilities playerCapabilities) {
        this.capabilities = playerCapabilities;
    }

    @Override
    public final boolean getChatColoursField() {
        return this.chatColours;
    }

    @Override
    public final void setChatColoursField(boolean bl) {
        this.chatColours = bl;
    }

    @Override
    public final int getChatVisibilityField() {
        return this.chatVisibility;
    }

    @Override
    public final void setChatVisibilityField(int n) {
        this.chatVisibility = n;
    }

    @Override
    public final int getChunkCoordXField() {
        return this.chunkCoordX;
    }

    @Override
    public final void setChunkCoordXField(int n) {
        this.chunkCoordX = n;
    }

    @Override
    public final int getChunkCoordYField() {
        return this.chunkCoordY;
    }

    @Override
    public final void setChunkCoordYField(int n) {
        this.chunkCoordY = n;
    }

    @Override
    public final int getChunkCoordZField() {
        return this.chunkCoordZ;
    }

    @Override
    public final void setChunkCoordZField(int n) {
        this.chunkCoordZ = n;
    }

    @Override
    public final int getCurrentWindowIdField() {
        return this.currentWindowId;
    }

    @Override
    public final void setCurrentWindowIdField(int n) {
        this.currentWindowId = n;
    }

    @Override
    public final DataWatcher getDataWatcherField() {
        return this.dataWatcher;
    }

    @Override
    public final void setDataWatcherField(DataWatcher dataWatcher) {
        this.dataWatcher = dataWatcher;
    }

    @Override
    public final boolean getDeadField() {
        return this.dead;
    }

    @Override
    public final void setDeadField(boolean bl) {
        this.dead = bl;
    }

    @Override
    public final int getDeathTimeField() {
        return this.deathTime;
    }

    @Override
    public final void setDeathTimeField(int n) {
        this.deathTime = n;
    }

    public final List getDestroyedItemsNetCacheField() {
        return this.destroyedItemsNetCache;
    }

    @Override
    public final int getDimensionField() {
        return this.dimension;
    }

    @Override
    public final void setDimensionField(int n) {
        this.dimension = n;
    }

    @Override
    public final float getDistanceWalkedModifiedField() {
        return this.distanceWalkedModified;
    }

    @Override
    public final void setDistanceWalkedModifiedField(float f) {
        this.distanceWalkedModified = f;
    }

    @Override
    public final float getDistanceWalkedOnStepModifiedField() {
        return this.distanceWalkedOnStepModified;
    }

    @Override
    public final void setDistanceWalkedOnStepModifiedField(float f) {
        this.distanceWalkedOnStepModified = f;
    }

    @Override
    public final int getEntityAgeField() {
        return this.entityAge;
    }

    @Override
    public final void setEntityAgeField(int n) {
        this.entityAge = n;
    }

    @Override
    public final float getEntityCollisionReductionField() {
        return this.entityCollisionReduction;
    }

    @Override
    public final void setEntityCollisionReductionField(float f) {
        this.entityCollisionReduction = f;
    }

    @Override
    public final int getEntityIdField() {
        return this.entityId;
    }

    @Override
    public final void setEntityIdField(int n) {
        this.entityId = n;
    }

    @Override
    public final float getExperienceField() {
        return this.experience;
    }

    @Override
    public final void setExperienceField(float f) {
        this.experience = f;
    }

    @Override
    public final int getExperienceLevelField() {
        return this.experienceLevel;
    }

    @Override
    public final void setExperienceLevelField(int n) {
        this.experienceLevel = n;
    }

    @Override
    public final int getExperienceTotalField() {
        return this.experienceTotal;
    }

    @Override
    public final void setExperienceTotalField(int n) {
        this.experienceTotal = n;
    }

    @Override
    public final float getFallDistanceField() {
        return this.fallDistance;
    }

    @Override
    public final void setFallDistanceField(float f) {
        this.fallDistance = f;
    }

    @Override
    public final float getField_110154_aXField() {
        return this.field_110154_aX;
    }

    @Override
    public final void setField_110154_aXField(float f) {
        this.field_110154_aX = f;
    }

    @Override
    public final float getField_130068_bOField() {
        return this.field_130068_bO;
    }

    @Override
    public final void setField_130068_bOField(float f) {
        this.field_130068_bO = f;
    }

    @Override
    public final long getField_143005_bXField() {
        return this.field_143005_bX;
    }

    @Override
    public final void setField_143005_bXField(long l) {
        this.field_143005_bX = l;
    }

    @Override
    public final boolean getField_70135_KField() {
        return this.field_70135_K;
    }

    @Override
    public final void setField_70135_KField(boolean bl) {
        this.field_70135_K = bl;
    }

    @Override
    public final float getField_70741_aBField() {
        return this.field_70741_aB;
    }

    @Override
    public final void setField_70741_aBField(float f) {
        this.field_70741_aB = f;
    }

    @Override
    public final float getField_70763_axField() {
        return this.field_70763_ax;
    }

    @Override
    public final void setField_70763_axField(float f) {
        this.field_70763_ax = f;
    }

    @Override
    public final float getField_70764_awField() {
        return this.field_70764_aw;
    }

    @Override
    public final void setField_70764_awField(float f) {
        this.field_70764_aw = f;
    }

    @Override
    public final float getField_70768_auField() {
        return this.field_70768_au;
    }

    @Override
    public final void setField_70768_auField(float f) {
        this.field_70768_au = f;
    }

    @Override
    public final float getField_70769_aoField() {
        return this.field_70769_ao;
    }

    @Override
    public final void setField_70769_aoField(float f) {
        this.field_70769_ao = f;
    }

    @Override
    public final float getField_70770_apField() {
        return this.field_70770_ap;
    }

    @Override
    public final void setField_70770_apField(float f) {
        this.field_70770_ap = f;
    }

    @Override
    public final float getField_71079_bUField() {
        return this.field_71079_bU;
    }

    @Override
    public final void setField_71079_bUField(float f) {
        this.field_71079_bU = f;
    }

    @Override
    public final float getField_71082_cxField() {
        return this.field_71082_cx;
    }

    @Override
    public final void setField_71082_cxField(float f) {
        this.field_71082_cx = f;
    }

    @Override
    public final double getField_71085_bRField() {
        return this.field_71085_bR;
    }

    @Override
    public final void setField_71085_bRField(double d) {
        this.field_71085_bR = d;
    }

    @Override
    public final float getField_71089_bVField() {
        return this.field_71089_bV;
    }

    @Override
    public final void setField_71089_bVField(float f) {
        this.field_71089_bV = f;
    }

    @Override
    public final double getField_71091_bMField() {
        return this.field_71091_bM;
    }

    @Override
    public final void setField_71091_bMField(double d) {
        this.field_71091_bM = d;
    }

    @Override
    public final double getField_71094_bPField() {
        return this.field_71094_bP;
    }

    @Override
    public final void setField_71094_bPField(double d) {
        this.field_71094_bP = d;
    }

    @Override
    public final double getField_71095_bQField() {
        return this.field_71095_bQ;
    }

    @Override
    public final void setField_71095_bQField(double d) {
        this.field_71095_bQ = d;
    }

    @Override
    public final double getField_71096_bNField() {
        return this.field_71096_bN;
    }

    @Override
    public final void setField_71096_bNField(double d) {
        this.field_71096_bN = d;
    }

    @Override
    public final double getField_71097_bOField() {
        return this.field_71097_bO;
    }

    @Override
    public final void setField_71097_bOField(double d) {
        this.field_71097_bO = d;
    }

    @Override
    public final int getFireResistanceField() {
        return this.fireResistance;
    }

    @Override
    public final void setFireResistanceField(int n) {
        this.fireResistance = n;
    }

    @Override
    public final EntityFishHook getFishEntityField() {
        return this.fishEntity;
    }

    @Override
    public final void setFishEntityField(EntityFishHook entityFishHook) {
        this.fishEntity = entityFishHook;
    }

    @Override
    public final int getFlyToggleTimerField() {
        return this.flyToggleTimer;
    }

    @Override
    public final void setFlyToggleTimerField(int n) {
        this.flyToggleTimer = n;
    }

    @Override
    public final FoodStats getFoodStatsField() {
        return this.foodStats;
    }

    @Override
    public final void setFoodStatsField(FoodStats foodStats) {
        this.foodStats = foodStats;
    }

    @Override
    public final boolean getForceSpawnField() {
        return this.forceSpawn;
    }

    @Override
    public final void setForceSpawnField(boolean bl) {
        this.forceSpawn = bl;
    }

    @Override
    public final float getHeightField() {
        return this.height;
    }

    @Override
    public final void setHeightField(float f) {
        this.height = f;
    }

    @Override
    public final int getHurtResistantTimeField() {
        return this.hurtResistantTime;
    }

    @Override
    public final void setHurtResistantTimeField(int n) {
        this.hurtResistantTime = n;
    }

    @Override
    public final int getHurtTimeField() {
        return this.hurtTime;
    }

    @Override
    public final void setHurtTimeField(int n) {
        this.hurtTime = n;
    }

    @Override
    public final boolean getIgnoreFrustumCheckField() {
        return this.ignoreFrustumCheck;
    }

    @Override
    public final void setIgnoreFrustumCheckField(boolean bl) {
        this.ignoreFrustumCheck = bl;
    }

    @Override
    public final boolean getInPortalField() {
        return this.inPortal;
    }

    @Override
    public final void setInPortalField(boolean bl) {
        this.inPortal = bl;
    }

    @Override
    public final boolean getInWaterField() {
        return this.inWater;
    }

    @Override
    public final void setInWaterField(boolean bl) {
        this.inWater = bl;
    }

    @Override
    public final int getInitialInvulnerabilityField() {
        return this.field_71145_cl;
    }

    @Override
    public final void setInitialInvulnerabilityField(int n) {
        this.field_71145_cl = n;
    }

    @Override
    public final InventoryPlayer getInventoryField() {
        return this.inventory;
    }

    @Override
    public final void setInventoryField(InventoryPlayer inventoryPlayer) {
        this.inventory = inventoryPlayer;
    }

    @Override
    public final Container getInventoryContainerField() {
        return this.inventoryContainer;
    }

    @Override
    public final void setInventoryContainerField(Container container) {
        this.inventoryContainer = container;
    }

    @Override
    public final boolean getIsAirBorneField() {
        return this.isAirBorne;
    }

    @Override
    public final void setIsAirBorneField(boolean bl) {
        this.isAirBorne = bl;
    }

    @Override
    public final boolean getIsCollidedField() {
        return this.isCollided;
    }

    @Override
    public final void setIsCollidedField(boolean bl) {
        this.isCollided = bl;
    }

    @Override
    public final boolean getIsCollidedHorizontallyField() {
        return this.isCollidedHorizontally;
    }

    @Override
    public final void setIsCollidedHorizontallyField(boolean bl) {
        this.isCollidedHorizontally = bl;
    }

    @Override
    public final boolean getIsCollidedVerticallyField() {
        return this.isCollidedVertically;
    }

    @Override
    public final void setIsCollidedVerticallyField(boolean bl) {
        this.isCollidedVertically = bl;
    }

    @Override
    public final boolean getIsDeadField() {
        return this.isDead;
    }

    @Override
    public final void setIsDeadField(boolean bl) {
        this.isDead = bl;
    }

    @Override
    public final boolean getIsImmuneToFireField() {
        return this.isImmuneToFire;
    }

    @Override
    public final void setIsImmuneToFireField(boolean bl) {
        this.isImmuneToFire = bl;
    }

    @Override
    public final boolean getIsInWebField() {
        return this.isInWeb;
    }

    @Override
    public final void setIsInWebField(boolean bl) {
        this.isInWeb = bl;
    }

    @Override
    public final boolean getIsJumpingField() {
        return this.isJumping;
    }

    @Override
    public final void setIsJumpingField(boolean bl) {
        this.isJumping = bl;
    }

    @Override
    public final boolean getIsSwingInProgressField() {
        return this.isSwingInProgress;
    }

    @Override
    public final void setIsSwingInProgressField(boolean bl) {
        this.isSwingInProgress = bl;
    }

    @Override
    public final float getJumpMovementFactorField() {
        return this.jumpMovementFactor;
    }

    @Override
    public final void setJumpMovementFactorField(float f) {
        this.jumpMovementFactor = f;
    }

    @Override
    public final float getLastDamageField() {
        return this.lastDamage;
    }

    @Override
    public final void setLastDamageField(float f) {
        this.lastDamage = f;
    }

    @Override
    public final int getLastExperienceField() {
        return this.lastExperience;
    }

    @Override
    public final void setLastExperienceField(int n) {
        this.lastExperience = n;
    }

    @Override
    public final int getLastFoodLevelField() {
        return this.lastFoodLevel;
    }

    @Override
    public final void setLastFoodLevelField(int n) {
        this.lastFoodLevel = n;
    }

    @Override
    public final float getLastHealthField() {
        return this.lastHealth;
    }

    @Override
    public final void setLastHealthField(float f) {
        this.lastHealth = f;
    }

    @Override
    public final double getLastTickPosXField() {
        return this.lastTickPosX;
    }

    @Override
    public final void setLastTickPosXField(double d) {
        this.lastTickPosX = d;
    }

    @Override
    public final double getLastTickPosYField() {
        return this.lastTickPosY;
    }

    @Override
    public final void setLastTickPosYField(double d) {
        this.lastTickPosY = d;
    }

    @Override
    public final double getLastTickPosZField() {
        return this.lastTickPosZ;
    }

    @Override
    public final void setLastTickPosZField(double d) {
        this.lastTickPosZ = d;
    }

    @Override
    public final float getLimbSwingField() {
        return this.limbSwing;
    }

    @Override
    public final void setLimbSwingField(float f) {
        this.limbSwing = f;
    }

    @Override
    public final float getLimbSwingAmountField() {
        return this.limbSwingAmount;
    }

    @Override
    public final void setLimbSwingAmountField(float f) {
        this.limbSwingAmount = f;
    }

    public final List getLoadedChunksField() {
        return this.loadedChunks;
    }

    @Override
    public final double getManagedPosXField() {
        return this.managedPosX;
    }

    @Override
    public final void setManagedPosXField(double d) {
        this.managedPosX = d;
    }

    @Override
    public final double getManagedPosZField() {
        return this.managedPosZ;
    }

    @Override
    public final void setManagedPosZField(double d) {
        this.managedPosZ = d;
    }

    @Override
    public final int getMaxHurtResistantTimeField() {
        return this.maxHurtResistantTime;
    }

    @Override
    public final void setMaxHurtResistantTimeField(int n) {
        this.maxHurtResistantTime = n;
    }

    @Override
    public final int getMaxHurtTimeField() {
        return this.maxHurtTime;
    }

    @Override
    public final void setMaxHurtTimeField(int n) {
        this.maxHurtTime = n;
    }

    @Override
    public final MinecraftServer getMcServerField() {
        return this.mcServer;
    }

    @Override
    public final void setMcServerField(MinecraftServer minecraftServer) {
        this.mcServer = minecraftServer;
    }

    @Override
    public final double getMotionXField() {
        return this.motionX;
    }

    @Override
    public final void setMotionXField(double d) {
        this.motionX = d;
    }

    @Override
    public final double getMotionYField() {
        return this.motionY;
    }

    @Override
    public final void setMotionYField(double d) {
        this.motionY = d;
    }

    @Override
    public final double getMotionZField() {
        return this.motionZ;
    }

    @Override
    public final void setMotionZField(double d) {
        this.motionZ = d;
    }

    @Override
    public final float getMoveForwardField() {
        return this.moveForward;
    }

    @Override
    public final void setMoveForwardField(float f) {
        this.moveForward = f;
    }

    @Override
    public final float getMoveStrafingField() {
        return this.moveStrafing;
    }

    @Override
    public final void setMoveStrafingField(float f) {
        this.moveStrafing = f;
    }

    @Override
    public final EnumEntitySize getMyEntitySizeField() {
        return this.myEntitySize;
    }

    @Override
    public final void setMyEntitySizeField(EnumEntitySize enumEntitySize) {
        this.myEntitySize = enumEntitySize;
    }

    @Override
    public final int getNewPosRotationIncrementsField() {
        return this.newPosRotationIncrements;
    }

    @Override
    public final void setNewPosRotationIncrementsField(int n) {
        this.newPosRotationIncrements = n;
    }

    @Override
    public final double getNewPosXField() {
        return this.newPosX;
    }

    @Override
    public final void setNewPosXField(double d) {
        this.newPosX = d;
    }

    @Override
    public final double getNewPosYField() {
        return this.newPosY;
    }

    @Override
    public final void setNewPosYField(double d) {
        this.newPosY = d;
    }

    @Override
    public final double getNewPosZField() {
        return this.newPosZ;
    }

    @Override
    public final void setNewPosZField(double d) {
        this.newPosZ = d;
    }

    @Override
    public final double getNewRotationPitchField() {
        return this.newRotationPitch;
    }

    @Override
    public final void setNewRotationPitchField(double d) {
        this.newRotationPitch = d;
    }

    @Override
    public final double getNewRotationYawField() {
        return this.newRotationYaw;
    }

    @Override
    public final void setNewRotationYawField(double d) {
        this.newRotationYaw = d;
    }

    @Override
    public final boolean getNoClipField() {
        return this.noClip;
    }

    @Override
    public final void setNoClipField(boolean bl) {
        this.noClip = bl;
    }

    @Override
    public final boolean getOnGroundField() {
        return this.onGround;
    }

    @Override
    public final void setOnGroundField(boolean bl) {
        this.onGround = bl;
    }

    @Override
    public final Container getOpenContainerField() {
        return this.openContainer;
    }

    @Override
    public final void setOpenContainerField(Container container) {
        this.openContainer = container;
    }

    @Override
    public final int getPingField() {
        return this.ping;
    }

    @Override
    public final void setPingField(int n) {
        this.ping = n;
    }

    @Override
    public final boolean getPlayerConqueredTheEndField() {
        return this.playerConqueredTheEnd;
    }

    @Override
    public final void setPlayerConqueredTheEndField(boolean bl) {
        this.playerConqueredTheEnd = bl;
    }

    @Override
    public final boolean getPlayerInventoryBeingManipulatedField() {
        return this.field_71137_h;
    }

    @Override
    public final void setPlayerInventoryBeingManipulatedField(boolean bl) {
        this.field_71137_h = bl;
    }

    @Override
    public final ChunkCoordinates getPlayerLocationField() {
        return this.playerLocation;
    }

    @Override
    public final void setPlayerLocationField(ChunkCoordinates chunkCoordinates) {
        this.playerLocation = chunkCoordinates;
    }

    @Override
    public final NetServerHandler getPlayerNetServerHandlerField() {
        return this.playerNetServerHandler;
    }

    @Override
    public final void setPlayerNetServerHandlerField(NetServerHandler netServerHandler) {
        this.playerNetServerHandler = netServerHandler;
    }

    @Override
    public final int getPortalCounterField() {
        return this.portalCounter;
    }

    @Override
    public final void setPortalCounterField(int n) {
        this.portalCounter = n;
    }

    @Override
    public final double getPosXField() {
        return this.posX;
    }

    @Override
    public final void setPosXField(double d) {
        this.posX = d;
    }

    @Override
    public final double getPosYField() {
        return this.posY;
    }

    @Override
    public final void setPosYField(double d) {
        this.posY = d;
    }

    @Override
    public final double getPosZField() {
        return this.posZ;
    }

    @Override
    public final void setPosZField(double d) {
        this.posZ = d;
    }

    @Override
    public final float getPrevCameraPitchField() {
        return this.prevCameraPitch;
    }

    @Override
    public final void setPrevCameraPitchField(float f) {
        this.prevCameraPitch = f;
    }

    @Override
    public final float getPrevCameraYawField() {
        return this.prevCameraYaw;
    }

    @Override
    public final void setPrevCameraYawField(float f) {
        this.prevCameraYaw = f;
    }

    @Override
    public final float getPrevDistanceWalkedModifiedField() {
        return this.prevDistanceWalkedModified;
    }

    @Override
    public final void setPrevDistanceWalkedModifiedField(float f) {
        this.prevDistanceWalkedModified = f;
    }

    @Override
    public final float getPrevHealthField() {
        return this.prevHealth;
    }

    @Override
    public final void setPrevHealthField(float f) {
        this.prevHealth = f;
    }

    @Override
    public final float getPrevLimbSwingAmountField() {
        return this.prevLimbSwingAmount;
    }

    @Override
    public final void setPrevLimbSwingAmountField(float f) {
        this.prevLimbSwingAmount = f;
    }

    @Override
    public final double getPrevPosXField() {
        return this.prevPosX;
    }

    @Override
    public final void setPrevPosXField(double d) {
        this.prevPosX = d;
    }

    @Override
    public final double getPrevPosYField() {
        return this.prevPosY;
    }

    @Override
    public final void setPrevPosYField(double d) {
        this.prevPosY = d;
    }

    @Override
    public final double getPrevPosZField() {
        return this.prevPosZ;
    }

    @Override
    public final void setPrevPosZField(double d) {
        this.prevPosZ = d;
    }

    @Override
    public final float getPrevRenderYawOffsetField() {
        return this.prevRenderYawOffset;
    }

    @Override
    public final void setPrevRenderYawOffsetField(float f) {
        this.prevRenderYawOffset = f;
    }

    @Override
    public final float getPrevRotationPitchField() {
        return this.prevRotationPitch;
    }

    @Override
    public final void setPrevRotationPitchField(float f) {
        this.prevRotationPitch = f;
    }

    @Override
    public final float getPrevRotationYawField() {
        return this.prevRotationYaw;
    }

    @Override
    public final void setPrevRotationYawField(float f) {
        this.prevRotationYaw = f;
    }

    @Override
    public final float getPrevRotationYawHeadField() {
        return this.prevRotationYawHead;
    }

    @Override
    public final void setPrevRotationYawHeadField(float f) {
        this.prevRotationYawHead = f;
    }

    @Override
    public final float getPrevSwingProgressField() {
        return this.prevSwingProgress;
    }

    @Override
    public final void setPrevSwingProgressField(float f) {
        this.prevSwingProgress = f;
    }

    @Override
    public final boolean getPreventEntitySpawningField() {
        return this.preventEntitySpawning;
    }

    @Override
    public final void setPreventEntitySpawningField(boolean bl) {
        this.preventEntitySpawning = bl;
    }

    @Override
    public final Random getRandField() {
        return this.rand;
    }

    @Override
    public final void setRandField(Random random) {
        this.rand = random;
    }

    @Override
    public final float getRandomYawVelocityField() {
        return this.randomYawVelocity;
    }

    @Override
    public final void setRandomYawVelocityField(float f) {
        this.randomYawVelocity = f;
    }

    @Override
    public final int getRecentlyHitField() {
        return this.recentlyHit;
    }

    @Override
    public final void setRecentlyHitField(int n) {
        this.recentlyHit = n;
    }

    @Override
    public final int getRenderDistanceField() {
        return this.renderDistance;
    }

    @Override
    public final void setRenderDistanceField(int n) {
        this.renderDistance = n;
    }

    @Override
    public final double getRenderDistanceWeightField() {
        return this.renderDistanceWeight;
    }

    @Override
    public final void setRenderDistanceWeightField(double d) {
        this.renderDistanceWeight = d;
    }

    @Override
    public final float getRenderYawOffsetField() {
        return this.renderYawOffset;
    }

    @Override
    public final void setRenderYawOffsetField(float f) {
        this.renderYawOffset = f;
    }

    @Override
    public final Entity getRiddenByEntityField() {
        return this.riddenByEntity;
    }

    @Override
    public final void setRiddenByEntityField(Entity entity) {
        this.riddenByEntity = entity;
    }

    @Override
    public final Entity getRidingEntityField() {
        return this.ridingEntity;
    }

    @Override
    public final void setRidingEntityField(Entity entity) {
        this.ridingEntity = entity;
    }

    @Override
    public final float getRotationPitchField() {
        return this.rotationPitch;
    }

    @Override
    public final void setRotationPitchField(float f) {
        this.rotationPitch = f;
    }

    @Override
    public final float getRotationYawField() {
        return this.rotationYaw;
    }

    @Override
    public final void setRotationYawField(float f) {
        this.rotationYaw = f;
    }

    @Override
    public final float getRotationYawHeadField() {
        return this.rotationYawHead;
    }

    @Override
    public final void setRotationYawHeadField(float f) {
        this.rotationYawHead = f;
    }

    @Override
    public final int getScoreValueField() {
        return this.scoreValue;
    }

    @Override
    public final void setScoreValueField(int n) {
        this.scoreValue = n;
    }

    @Override
    public final int getServerPosXField() {
        return this.serverPosX;
    }

    @Override
    public final void setServerPosXField(int n) {
        this.serverPosX = n;
    }

    @Override
    public final int getServerPosYField() {
        return this.serverPosY;
    }

    @Override
    public final void setServerPosYField(int n) {
        this.serverPosY = n;
    }

    @Override
    public final int getServerPosZField() {
        return this.serverPosZ;
    }

    @Override
    public final void setServerPosZField(int n) {
        this.serverPosZ = n;
    }

    @Override
    public final int getSleepTimerField() {
        return this.sleepTimer;
    }

    @Override
    public final void setSleepTimerField(int n) {
        this.sleepTimer = n;
    }

    @Override
    public final boolean getSleepingField() {
        return this.sleeping;
    }

    @Override
    public final void setSleepingField(boolean bl) {
        this.sleeping = bl;
    }

    @Override
    public final float getSpeedInAirField() {
        return this.speedInAir;
    }

    @Override
    public final void setSpeedInAirField(float f) {
        this.speedInAir = f;
    }

    @Override
    public final float getSpeedOnGroundField() {
        return this.speedOnGround;
    }

    @Override
    public final void setSpeedOnGroundField(float f) {
        this.speedOnGround = f;
    }

    @Override
    public final float getStepHeightField() {
        return this.stepHeight;
    }

    @Override
    public final void setStepHeightField(float f) {
        this.stepHeight = f;
    }

    @Override
    public final float getSwingProgressField() {
        return this.swingProgress;
    }

    @Override
    public final void setSwingProgressField(float f) {
        this.swingProgress = f;
    }

    @Override
    public final int getSwingProgressIntField() {
        return this.swingProgressInt;
    }

    @Override
    public final void setSwingProgressIntField(int n) {
        this.swingProgressInt = n;
    }

    @Override
    public final int getTeleportDirectionField() {
        return this.teleportDirection;
    }

    @Override
    public final void setTeleportDirectionField(int n) {
        this.teleportDirection = n;
    }

    @Override
    public final ItemInWorldManager getTheItemInWorldManagerField() {
        return this.theItemInWorldManager;
    }

    @Override
    public final void setTheItemInWorldManagerField(ItemInWorldManager itemInWorldManager) {
        this.theItemInWorldManager = itemInWorldManager;
    }

    @Override
    public final int getTicksExistedField() {
        return this.ticksExisted;
    }

    @Override
    public final void setTicksExistedField(int n) {
        this.ticksExisted = n;
    }

    @Override
    public final int getTimeUntilPortalField() {
        return this.timeUntilPortal;
    }

    @Override
    public final void setTimeUntilPortalField(int n) {
        this.timeUntilPortal = n;
    }

    @Override
    public final String getTranslatorField() {
        return this.translator;
    }

    @Override
    public final void setTranslatorField(String string) {
        this.translator = string;
    }

    @Override
    public final String getUsernameField() {
        return this.username;
    }

    @Override
    public final boolean getVelocityChangedField() {
        return this.velocityChanged;
    }

    @Override
    public final void setVelocityChangedField(boolean bl) {
        this.velocityChanged = bl;
    }

    @Override
    public final boolean getWasHungryField() {
        return this.wasHungry;
    }

    @Override
    public final void setWasHungryField(boolean bl) {
        this.wasHungry = bl;
    }

    @Override
    public final float getWidthField() {
        return this.width;
    }

    @Override
    public final void setWidthField(float f) {
        this.width = f;
    }

    @Override
    public final World getWorldObjField() {
        return this.worldObj;
    }

    @Override
    public final void setWorldObjField(World world) {
        this.worldObj = world;
    }

    @Override
    public final int getXpCooldownField() {
        return this.xpCooldown;
    }

    @Override
    public final void setXpCooldownField(int n) {
        this.xpCooldown = n;
    }

    @Override
    public final float getYOffsetField() {
        return this.yOffset;
    }

    @Override
    public final void setYOffsetField(float f) {
        this.yOffset = f;
    }

    @Override
    public final float getYSizeField() {
        return this.ySize;
    }

    @Override
    public final void setYSizeField(float f) {
        this.ySize = f;
    }

    @Override
    public final ServerPlayerBase getServerPlayerBase(String string) {
        return ServerPlayerAPI.getServerPlayerBase(this, string);
    }

    public final Set getServerPlayerBaseIds() {
        return ServerPlayerAPI.getServerPlayerBaseIds(this);
    }

    @Override
    public final Object dynamic(String string, Object[] objectArray) {
        return ServerPlayerAPI.dynamic(this, string, objectArray);
    }

    @Override
    public final ServerPlayerAPI getServerPlayerAPI() {
        return this.serverPlayerAPI;
    }

    @Override
    public final EntityPlayerMP getEntityPlayerMP() {
        return this;
    }
}

