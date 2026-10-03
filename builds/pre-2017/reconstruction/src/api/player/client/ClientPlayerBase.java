/*
 * Decompiled with CFR 0.152.
 */
package api.player.client;

import api.player.client.ClientPlayerAPI;
import api.player.client.IClientPlayer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EnumStatus;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.hanr;
import net.minecraft.world.World;

public abstract class ClientPlayerBase {
    protected final EntityPlayerSP player;
    protected final IClientPlayer playerAPI;
    private final ClientPlayerAPI internalClientPlayerAPI;

    public ClientPlayerBase(ClientPlayerAPI clientPlayerAPI) {
        this.internalClientPlayerAPI = clientPlayerAPI;
        this.playerAPI = clientPlayerAPI.player;
        this.player = clientPlayerAPI.player.getEntityPlayerSP();
    }

    public void beforeBaseAttach(boolean bl) {
    }

    public void afterBaseAttach(boolean bl) {
    }

    public void beforeLocalConstructing(Minecraft minecraft, World world, hanr hanr2, int n) {
    }

    public void afterLocalConstructing(Minecraft minecraft, World world, hanr hanr2, int n) {
    }

    public void beforeBaseDetach(boolean bl) {
    }

    public void afterBaseDetach(boolean bl) {
    }

    public Object dynamic(String string, Object[] objectArray) {
        return this.internalClientPlayerAPI.dynamicOverwritten(string, objectArray, this);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void beforeAddExhaustion(float f) {
    }

    public void addExhaustion(float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenAddExhaustion(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localAddExhaustion(f);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.addExhaustion(f);
        }
    }

    public void afterAddExhaustion(float f) {
    }

    public void beforeAddMovementStat(double d, double d2, double d3) {
    }

    public void addMovementStat(double d, double d2, double d3) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenAddMovementStat(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localAddMovementStat(d, d2, d3);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.addMovementStat(d, d2, d3);
        }
    }

    public void afterAddMovementStat(double d, double d2, double d3) {
    }

    public void beforeAddStat(StatBase statBase, int n) {
    }

    public void addStat(StatBase statBase, int n) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenAddStat(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localAddStat(statBase, n);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.addStat(statBase, n);
        }
    }

    public void afterAddStat(StatBase statBase, int n) {
    }

    public void beforeAttackEntityFrom(DamageSource damageSource, float f) {
    }

    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenAttackEntityFrom(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localAttackEntityFrom(damageSource, f) : (clientPlayerBase != this ? clientPlayerBase.attackEntityFrom(damageSource, f) : false);
        return bl;
    }

    public void afterAttackEntityFrom(DamageSource damageSource, float f) {
    }

    public void beforeAttackTargetEntityWithCurrentItem(Entity entity) {
    }

    public void attackTargetEntityWithCurrentItem(Entity entity) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenAttackTargetEntityWithCurrentItem(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localAttackTargetEntityWithCurrentItem(entity);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.attackTargetEntityWithCurrentItem(entity);
        }
    }

    public void afterAttackTargetEntityWithCurrentItem(Entity entity) {
    }

    public void beforeCanBreatheUnderwater() {
    }

    public boolean canBreatheUnderwater() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenCanBreatheUnderwater(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localCanBreatheUnderwater() : (clientPlayerBase != this ? clientPlayerBase.canBreatheUnderwater() : false);
        return bl;
    }

    public void afterCanBreatheUnderwater() {
    }

    public void beforeCanHarvestBlock(Block block) {
    }

    public boolean canHarvestBlock(Block block) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenCanHarvestBlock(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localCanHarvestBlock(block) : (clientPlayerBase != this ? clientPlayerBase.canHarvestBlock(block) : false);
        return bl;
    }

    public void afterCanHarvestBlock(Block block) {
    }

    public void beforeCanPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
    }

    public boolean canPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenCanPlayerEdit(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localCanPlayerEdit(n, n2, n3, n4, itemStack) : (clientPlayerBase != this ? clientPlayerBase.canPlayerEdit(n, n2, n3, n4, itemStack) : false);
        return bl;
    }

    public void afterCanPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
    }

    public void beforeCanTriggerWalking() {
    }

    public boolean canTriggerWalking() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenCanTriggerWalking(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localCanTriggerWalking() : (clientPlayerBase != this ? clientPlayerBase.canTriggerWalking() : false);
        return bl;
    }

    public void afterCanTriggerWalking() {
    }

    public void beforeCloseScreen() {
    }

    public void closeScreen() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenCloseScreen(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localCloseScreen();
        } else if (clientPlayerBase != this) {
            clientPlayerBase.closeScreen();
        }
    }

    public void afterCloseScreen() {
    }

    public void beforeDamageEntity(DamageSource damageSource, float f) {
    }

    public void damageEntity(DamageSource damageSource, float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDamageEntity(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDamageEntity(damageSource, f);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.damageEntity(damageSource, f);
        }
    }

    public void afterDamageEntity(DamageSource damageSource, float f) {
    }

    public void beforeDisplayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
    }

    public void displayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIBrewingStand(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIBrewingStand(tileEntityBrewingStand);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIBrewingStand(tileEntityBrewingStand);
        }
    }

    public void afterDisplayGUIBrewingStand(TileEntityBrewingStand tileEntityBrewingStand) {
    }

    public void beforeDisplayGUIChest(IInventory iInventory) {
    }

    public void displayGUIChest(IInventory iInventory) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIChest(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIChest(iInventory);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIChest(iInventory);
        }
    }

    public void afterDisplayGUIChest(IInventory iInventory) {
    }

    public void beforeDisplayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
    }

    public void displayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIDispenser(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIDispenser(tileEntityDispenser);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIDispenser(tileEntityDispenser);
        }
    }

    public void afterDisplayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
    }

    public void beforeDisplayGUIEditSign(TileEntity tileEntity) {
    }

    public void displayGUIEditSign(TileEntity tileEntity) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIEditSign(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIEditSign(tileEntity);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIEditSign(tileEntity);
        }
    }

    public void afterDisplayGUIEditSign(TileEntity tileEntity) {
    }

    public void beforeDisplayGUIEnchantment(int n, int n2, int n3, String string) {
    }

    public void displayGUIEnchantment(int n, int n2, int n3, String string) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIEnchantment(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIEnchantment(n, n2, n3, string);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIEnchantment(n, n2, n3, string);
        }
    }

    public void afterDisplayGUIEnchantment(int n, int n2, int n3, String string) {
    }

    public void beforeDisplayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
    }

    public void displayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIFurnace(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIFurnace(tileEntityFurnace);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIFurnace(tileEntityFurnace);
        }
    }

    public void afterDisplayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
    }

    public void beforeDisplayGUIWorkbench(int n, int n2, int n3) {
    }

    public void displayGUIWorkbench(int n, int n2, int n3) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIWorkbench(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIWorkbench(n, n2, n3);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIWorkbench(n, n2, n3);
        }
    }

    public void afterDisplayGUIWorkbench(int n, int n2, int n3) {
    }

    public void beforeDropOneItem(boolean bl) {
    }

    public EntityItem dropOneItem(boolean bl) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDropOneItem(this);
        EntityItem entityItem = clientPlayerBase == null ? this.playerAPI.localDropOneItem(bl) : (clientPlayerBase != this ? clientPlayerBase.dropOneItem(bl) : null);
        return entityItem;
    }

    public void afterDropOneItem(boolean bl) {
    }

    public void beforeDropPlayerItem(ItemStack itemStack) {
    }

    public EntityItem dropPlayerItem(ItemStack itemStack) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDropPlayerItem(this);
        EntityItem entityItem = clientPlayerBase == null ? this.playerAPI.localDropPlayerItem(itemStack) : (clientPlayerBase != this ? clientPlayerBase.dropPlayerItem(itemStack) : null);
        return entityItem;
    }

    public void afterDropPlayerItem(ItemStack itemStack) {
    }

    public void beforeDropPlayerItemWithRandomChoice(ItemStack itemStack, boolean bl) {
    }

    public EntityItem dropPlayerItemWithRandomChoice(ItemStack itemStack, boolean bl) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDropPlayerItemWithRandomChoice(this);
        EntityItem entityItem = clientPlayerBase == null ? this.playerAPI.localDropPlayerItemWithRandomChoice(itemStack, bl) : (clientPlayerBase != this ? clientPlayerBase.dropPlayerItemWithRandomChoice(itemStack, bl) : null);
        return entityItem;
    }

    public void afterDropPlayerItemWithRandomChoice(ItemStack itemStack, boolean bl) {
    }

    public void beforeFall(float f) {
    }

    public void fall(float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenFall(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localFall(f);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.fall(f);
        }
    }

    public void afterFall(float f) {
    }

    public void beforeGetBrightness(float f) {
    }

    public float getBrightness(float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetBrightness(this);
        float f2 = clientPlayerBase == null ? this.playerAPI.localGetBrightness(f) : (clientPlayerBase != this ? clientPlayerBase.getBrightness(f) : 0.0f);
        return f2;
    }

    public void afterGetBrightness(float f) {
    }

    public void beforeGetBrightnessForRender(float f) {
    }

    public int getBrightnessForRender(float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetBrightnessForRender(this);
        int n = clientPlayerBase == null ? this.playerAPI.localGetBrightnessForRender(f) : (clientPlayerBase != this ? clientPlayerBase.getBrightnessForRender(f) : 0);
        return n;
    }

    public void afterGetBrightnessForRender(float f) {
    }

    public void beforeGetCurrentPlayerStrVsBlock(Block block, boolean bl) {
    }

    public float getCurrentPlayerStrVsBlock(Block block, boolean bl) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetCurrentPlayerStrVsBlock(this);
        float f = clientPlayerBase == null ? this.playerAPI.localGetCurrentPlayerStrVsBlock(block, bl) : (clientPlayerBase != this ? clientPlayerBase.getCurrentPlayerStrVsBlock(block, bl) : 0.0f);
        return f;
    }

    public void afterGetCurrentPlayerStrVsBlock(Block block, boolean bl) {
    }

    public void beforeGetCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
    }

    public float getCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetCurrentPlayerStrVsBlockForge(this);
        float f = clientPlayerBase == null ? this.playerAPI.localGetCurrentPlayerStrVsBlockForge(block, bl, n) : (clientPlayerBase != this ? clientPlayerBase.getCurrentPlayerStrVsBlockForge(block, bl, n) : 0.0f);
        return f;
    }

    public void afterGetCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
    }

    public void beforeGetDistanceSq(double d, double d2, double d3) {
    }

    public double getDistanceSq(double d, double d2, double d3) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetDistanceSq(this);
        double d4 = clientPlayerBase == null ? this.playerAPI.localGetDistanceSq(d, d2, d3) : (clientPlayerBase != this ? clientPlayerBase.getDistanceSq(d, d2, d3) : 0.0);
        return d4;
    }

    public void afterGetDistanceSq(double d, double d2, double d3) {
    }

    public void beforeGetDistanceSqToEntity(Entity entity) {
    }

    public double getDistanceSqToEntity(Entity entity) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetDistanceSqToEntity(this);
        double d = clientPlayerBase == null ? this.playerAPI.localGetDistanceSqToEntity(entity) : (clientPlayerBase != this ? clientPlayerBase.getDistanceSqToEntity(entity) : 0.0);
        return d;
    }

    public void afterGetDistanceSqToEntity(Entity entity) {
    }

    public void beforeGetFOVMultiplier() {
    }

    public float getFOVMultiplier() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetFOVMultiplier(this);
        float f = clientPlayerBase == null ? this.playerAPI.localGetFOVMultiplier() : (clientPlayerBase != this ? clientPlayerBase.getFOVMultiplier() : 0.0f);
        return f;
    }

    public void afterGetFOVMultiplier() {
    }

    public void beforeGetHurtSound() {
    }

    public String getHurtSound() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetHurtSound(this);
        String string = clientPlayerBase == null ? this.playerAPI.localGetHurtSound() : (clientPlayerBase != this ? clientPlayerBase.getHurtSound() : null);
        return string;
    }

    public void afterGetHurtSound() {
    }

    public void beforeGetItemIcon(ItemStack itemStack, int n) {
    }

    public Icon getItemIcon(ItemStack itemStack, int n) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetItemIcon(this);
        Icon icon = clientPlayerBase == null ? this.playerAPI.localGetItemIcon(itemStack, n) : (clientPlayerBase != this ? clientPlayerBase.getItemIcon(itemStack, n) : null);
        return icon;
    }

    public void afterGetItemIcon(ItemStack itemStack, int n) {
    }

    public void beforeGetSleepTimer() {
    }

    public int getSleepTimer() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetSleepTimer(this);
        int n = clientPlayerBase == null ? this.playerAPI.localGetSleepTimer() : (clientPlayerBase != this ? clientPlayerBase.getSleepTimer() : 0);
        return n;
    }

    public void afterGetSleepTimer() {
    }

    public void beforeHandleLavaMovement() {
    }

    public boolean handleLavaMovement() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenHandleLavaMovement(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localHandleLavaMovement() : (clientPlayerBase != this ? clientPlayerBase.handleLavaMovement() : false);
        return bl;
    }

    public void afterHandleLavaMovement() {
    }

    public void beforeHandleWaterMovement() {
    }

    public boolean handleWaterMovement() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenHandleWaterMovement(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localHandleWaterMovement() : (clientPlayerBase != this ? clientPlayerBase.handleWaterMovement() : false);
        return bl;
    }

    public void afterHandleWaterMovement() {
    }

    public void beforeHeal(float f) {
    }

    public void heal(float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenHeal(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localHeal(f);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.heal(f);
        }
    }

    public void afterHeal(float f) {
    }

    public void beforeIsEntityInsideOpaqueBlock() {
    }

    public boolean isEntityInsideOpaqueBlock() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenIsEntityInsideOpaqueBlock(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localIsEntityInsideOpaqueBlock() : (clientPlayerBase != this ? clientPlayerBase.isEntityInsideOpaqueBlock() : false);
        return bl;
    }

    public void afterIsEntityInsideOpaqueBlock() {
    }

    public void beforeIsInWater() {
    }

    public boolean isInWater() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenIsInWater(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localIsInWater() : (clientPlayerBase != this ? clientPlayerBase.isInWater() : false);
        return bl;
    }

    public void afterIsInWater() {
    }

    public void beforeIsInsideOfMaterial(Material material) {
    }

    public boolean isInsideOfMaterial(Material material) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenIsInsideOfMaterial(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localIsInsideOfMaterial(material) : (clientPlayerBase != this ? clientPlayerBase.isInsideOfMaterial(material) : false);
        return bl;
    }

    public void afterIsInsideOfMaterial(Material material) {
    }

    public void beforeIsOnLadder() {
    }

    public boolean isOnLadder() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenIsOnLadder(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localIsOnLadder() : (clientPlayerBase != this ? clientPlayerBase.isOnLadder() : false);
        return bl;
    }

    public void afterIsOnLadder() {
    }

    public void beforeIsPlayerSleeping() {
    }

    public boolean isPlayerSleeping() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenIsPlayerSleeping(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localIsPlayerSleeping() : (clientPlayerBase != this ? clientPlayerBase.isPlayerSleeping() : false);
        return bl;
    }

    public void afterIsPlayerSleeping() {
    }

    public void beforeIsSneaking() {
    }

    public boolean isSneaking() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenIsSneaking(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localIsSneaking() : (clientPlayerBase != this ? clientPlayerBase.isSneaking() : false);
        return bl;
    }

    public void afterIsSneaking() {
    }

    public void beforeIsSprinting() {
    }

    public boolean isSprinting() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenIsSprinting(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localIsSprinting() : (clientPlayerBase != this ? clientPlayerBase.isSprinting() : false);
        return bl;
    }

    public void afterIsSprinting() {
    }

    public void beforeJump() {
    }

    public void jump() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenJump(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localJump();
        } else if (clientPlayerBase != this) {
            clientPlayerBase.jump();
        }
    }

    public void afterJump() {
    }

    public void beforeKnockBack(Entity entity, float f, double d, double d2) {
    }

    public void knockBack(Entity entity, float f, double d, double d2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenKnockBack(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localKnockBack(entity, f, d, d2);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.knockBack(entity, f, d, d2);
        }
    }

    public void afterKnockBack(Entity entity, float f, double d, double d2) {
    }

    public void beforeMoveEntity(double d, double d2, double d3) {
    }

    public void moveEntity(double d, double d2, double d3) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenMoveEntity(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localMoveEntity(d, d2, d3);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.moveEntity(d, d2, d3);
        }
    }

    public void afterMoveEntity(double d, double d2, double d3) {
    }

    public void beforeMoveEntityWithHeading(float f, float f2) {
    }

    public void moveEntityWithHeading(float f, float f2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenMoveEntityWithHeading(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localMoveEntityWithHeading(f, f2);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.moveEntityWithHeading(f, f2);
        }
    }

    public void afterMoveEntityWithHeading(float f, float f2) {
    }

    public void beforeMoveFlying(float f, float f2, float f3) {
    }

    public void moveFlying(float f, float f2, float f3) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenMoveFlying(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localMoveFlying(f, f2, f3);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.moveFlying(f, f2, f3);
        }
    }

    public void afterMoveFlying(float f, float f2, float f3) {
    }

    public void beforeOnDeath(DamageSource damageSource) {
    }

    public void onDeath(DamageSource damageSource) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenOnDeath(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localOnDeath(damageSource);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.onDeath(damageSource);
        }
    }

    public void afterOnDeath(DamageSource damageSource) {
    }

    public void beforeOnLivingUpdate() {
    }

    public void onLivingUpdate() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenOnLivingUpdate(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localOnLivingUpdate();
        } else if (clientPlayerBase != this) {
            clientPlayerBase.onLivingUpdate();
        }
    }

    public void afterOnLivingUpdate() {
    }

    public void beforeOnKillEntity(EntityLivingBase entityLivingBase) {
    }

    public void onKillEntity(EntityLivingBase entityLivingBase) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenOnKillEntity(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localOnKillEntity(entityLivingBase);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.onKillEntity(entityLivingBase);
        }
    }

    public void afterOnKillEntity(EntityLivingBase entityLivingBase) {
    }

    public void beforeOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
    }

    public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenOnStruckByLightning(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localOnStruckByLightning(entityLightningBolt);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.onStruckByLightning(entityLightningBolt);
        }
    }

    public void afterOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
    }

    public void beforeOnUpdate() {
    }

    public void onUpdate() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenOnUpdate(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localOnUpdate();
        } else if (clientPlayerBase != this) {
            clientPlayerBase.onUpdate();
        }
    }

    public void afterOnUpdate() {
    }

    public void beforePlayStepSound(int n, int n2, int n3, int n4) {
    }

    public void playStepSound(int n, int n2, int n3, int n4) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenPlayStepSound(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localPlayStepSound(n, n2, n3, n4);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.playStepSound(n, n2, n3, n4);
        }
    }

    public void afterPlayStepSound(int n, int n2, int n3, int n4) {
    }

    public void beforePushOutOfBlocks(double d, double d2, double d3) {
    }

    public boolean pushOutOfBlocks(double d, double d2, double d3) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenPushOutOfBlocks(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localPushOutOfBlocks(d, d2, d3) : (clientPlayerBase != this ? clientPlayerBase.pushOutOfBlocks(d, d2, d3) : false);
        return bl;
    }

    public void afterPushOutOfBlocks(double d, double d2, double d3) {
    }

    public void beforeRayTrace(double d, float f) {
    }

    public MovingObjectPosition rayTrace(double d, float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenRayTrace(this);
        MovingObjectPosition movingObjectPosition = clientPlayerBase == null ? this.playerAPI.localRayTrace(d, f) : (clientPlayerBase != this ? clientPlayerBase.rayTrace(d, f) : null);
        return movingObjectPosition;
    }

    public void afterRayTrace(double d, float f) {
    }

    public void beforeReadEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenReadEntityFromNBT(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localReadEntityFromNBT(nBTTagCompound);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.readEntityFromNBT(nBTTagCompound);
        }
    }

    public void afterReadEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    public void beforeRespawnPlayer() {
    }

    public void respawnPlayer() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenRespawnPlayer(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localRespawnPlayer();
        } else if (clientPlayerBase != this) {
            clientPlayerBase.respawnPlayer();
        }
    }

    public void afterRespawnPlayer() {
    }

    public void beforeSetDead() {
    }

    public void setDead() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenSetDead(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localSetDead();
        } else if (clientPlayerBase != this) {
            clientPlayerBase.setDead();
        }
    }

    public void afterSetDead() {
    }

    public void beforeSetPlayerSPHealth(float f) {
    }

    public void setPlayerSPHealth(float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenSetPlayerSPHealth(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localSetPlayerSPHealth(f);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.setPlayerSPHealth(f);
        }
    }

    public void afterSetPlayerSPHealth(float f) {
    }

    public void beforeSetPositionAndRotation(double d, double d2, double d3, float f, float f2) {
    }

    public void setPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenSetPositionAndRotation(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localSetPositionAndRotation(d, d2, d3, f, f2);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.setPositionAndRotation(d, d2, d3, f, f2);
        }
    }

    public void afterSetPositionAndRotation(double d, double d2, double d3, float f, float f2) {
    }

    public void beforeSleepInBedAt(int n, int n2, int n3) {
    }

    public EnumStatus sleepInBedAt(int n, int n2, int n3) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenSleepInBedAt(this);
        EnumStatus enumStatus = clientPlayerBase == null ? this.playerAPI.localSleepInBedAt(n, n2, n3) : (clientPlayerBase != this ? clientPlayerBase.sleepInBedAt(n, n2, n3) : null);
        return enumStatus;
    }

    public void afterSleepInBedAt(int n, int n2, int n3) {
    }

    public void beforeSwingItem() {
    }

    public void swingItem() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenSwingItem(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localSwingItem();
        } else if (clientPlayerBase != this) {
            clientPlayerBase.swingItem();
        }
    }

    public void afterSwingItem() {
    }

    public void beforeUpdateEntityActionState() {
    }

    public void updateEntityActionState() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenUpdateEntityActionState(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localUpdateEntityActionState();
        } else if (clientPlayerBase != this) {
            clientPlayerBase.updateEntityActionState();
        }
    }

    public void afterUpdateEntityActionState() {
    }

    public void beforeUpdateRidden() {
    }

    public void updateRidden() {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenUpdateRidden(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localUpdateRidden();
        } else if (clientPlayerBase != this) {
            clientPlayerBase.updateRidden();
        }
    }

    public void afterUpdateRidden() {
    }

    public void beforeWriteEntityToNBT(NBTTagCompound nBTTagCompound) {
    }

    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenWriteEntityToNBT(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localWriteEntityToNBT(nBTTagCompound);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.writeEntityToNBT(nBTTagCompound);
        }
    }

    public void afterWriteEntityToNBT(NBTTagCompound nBTTagCompound) {
    }
}

