/*
 * Decompiled with CFR 0.152.
 */
package api.player.server;

import api.player.server.IServerPlayer;
import api.player.server.ServerPlayerAPI;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemInWorldManager;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class ServerPlayerBase {
    protected final EntityPlayerMP player;
    protected final IServerPlayer playerAPI;
    private final ServerPlayerAPI internalServerPlayerAPI;

    public ServerPlayerBase(ServerPlayerAPI serverPlayerAPI) {
        this.internalServerPlayerAPI = serverPlayerAPI;
        this.playerAPI = serverPlayerAPI.player;
        this.player = serverPlayerAPI.player.getEntityPlayerMP();
    }

    public void beforeBaseAttach(boolean bl) {
    }

    public void afterBaseAttach(boolean bl) {
    }

    public void beforeLocalConstructing(MinecraftServer minecraftServer, World world, String string, ItemInWorldManager itemInWorldManager) {
    }

    public void afterLocalConstructing(MinecraftServer minecraftServer, World world, String string, ItemInWorldManager itemInWorldManager) {
    }

    public void beforeBaseDetach(boolean bl) {
    }

    public void afterBaseDetach(boolean bl) {
    }

    public Object dynamic(String string, Object[] objectArray) {
        return this.internalServerPlayerAPI.dynamicOverwritten(string, objectArray, this);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void beforeAddExhaustion(float f) {
    }

    public void addExhaustion(float f) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenAddExhaustion(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localAddExhaustion(f);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.addExhaustion(f);
        }
    }

    public void afterAddExhaustion(float f) {
    }

    public void beforeAddExperience(int n) {
    }

    public void addExperience(int n) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenAddExperience(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localAddExperience(n);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.addExperience(n);
        }
    }

    public void afterAddExperience(int n) {
    }

    public void beforeAddExperienceLevel(int n) {
    }

    public void addExperienceLevel(int n) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenAddExperienceLevel(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localAddExperienceLevel(n);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.addExperienceLevel(n);
        }
    }

    public void afterAddExperienceLevel(int n) {
    }

    public void beforeAddMovementStat(double d, double d2, double d3) {
    }

    public void addMovementStat(double d, double d2, double d3) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenAddMovementStat(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localAddMovementStat(d, d2, d3);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.addMovementStat(d, d2, d3);
        }
    }

    public void afterAddMovementStat(double d, double d2, double d3) {
    }

    public void beforeAttackEntityFrom(DamageSource damageSource, float f) {
    }

    public boolean attackEntityFrom(DamageSource damageSource, float f) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenAttackEntityFrom(this);
        boolean bl = serverPlayerBase == null ? this.playerAPI.localAttackEntityFrom(damageSource, f) : (serverPlayerBase != this ? serverPlayerBase.attackEntityFrom(damageSource, f) : false);
        return bl;
    }

    public void afterAttackEntityFrom(DamageSource damageSource, float f) {
    }

    public void beforeAttackTargetEntityWithCurrentItem(Entity entity) {
    }

    public void attackTargetEntityWithCurrentItem(Entity entity) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenAttackTargetEntityWithCurrentItem(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localAttackTargetEntityWithCurrentItem(entity);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.attackTargetEntityWithCurrentItem(entity);
        }
    }

    public void afterAttackTargetEntityWithCurrentItem(Entity entity) {
    }

    public void beforeCanHarvestBlock(Block block) {
    }

    public boolean canHarvestBlock(Block block) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenCanHarvestBlock(this);
        boolean bl = serverPlayerBase == null ? this.playerAPI.localCanHarvestBlock(block) : (serverPlayerBase != this ? serverPlayerBase.canHarvestBlock(block) : false);
        return bl;
    }

    public void afterCanHarvestBlock(Block block) {
    }

    public void beforeCanPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
    }

    public boolean canPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenCanPlayerEdit(this);
        boolean bl = serverPlayerBase == null ? this.playerAPI.localCanPlayerEdit(n, n2, n3, n4, itemStack) : (serverPlayerBase != this ? serverPlayerBase.canPlayerEdit(n, n2, n3, n4, itemStack) : false);
        return bl;
    }

    public void afterCanPlayerEdit(int n, int n2, int n3, int n4, ItemStack itemStack) {
    }

    public void beforeCanTriggerWalking() {
    }

    public boolean canTriggerWalking() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenCanTriggerWalking(this);
        boolean bl = serverPlayerBase == null ? this.playerAPI.localCanTriggerWalking() : (serverPlayerBase != this ? serverPlayerBase.canTriggerWalking() : false);
        return bl;
    }

    public void afterCanTriggerWalking() {
    }

    public void beforeClonePlayer(EntityPlayer entityPlayer, boolean bl) {
    }

    public void clonePlayer(EntityPlayer entityPlayer, boolean bl) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenClonePlayer(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localClonePlayer(entityPlayer, bl);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.clonePlayer(entityPlayer, bl);
        }
    }

    public void afterClonePlayer(EntityPlayer entityPlayer, boolean bl) {
    }

    public void beforeDamageEntity(DamageSource damageSource, float f) {
    }

    public void damageEntity(DamageSource damageSource, float f) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenDamageEntity(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localDamageEntity(damageSource, f);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.damageEntity(damageSource, f);
        }
    }

    public void afterDamageEntity(DamageSource damageSource, float f) {
    }

    public void beforeDisplayGUIChest(IInventory iInventory) {
    }

    public void displayGUIChest(IInventory iInventory) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenDisplayGUIChest(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localDisplayGUIChest(iInventory);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.displayGUIChest(iInventory);
        }
    }

    public void afterDisplayGUIChest(IInventory iInventory) {
    }

    public void beforeDisplayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
    }

    public void displayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenDisplayGUIDispenser(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localDisplayGUIDispenser(tileEntityDispenser);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.displayGUIDispenser(tileEntityDispenser);
        }
    }

    public void afterDisplayGUIDispenser(TileEntityDispenser tileEntityDispenser) {
    }

    public void beforeDisplayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
    }

    public void displayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenDisplayGUIFurnace(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localDisplayGUIFurnace(tileEntityFurnace);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.displayGUIFurnace(tileEntityFurnace);
        }
    }

    public void afterDisplayGUIFurnace(TileEntityFurnace tileEntityFurnace) {
    }

    public void beforeDisplayGUIWorkbench(int n, int n2, int n3) {
    }

    public void displayGUIWorkbench(int n, int n2, int n3) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenDisplayGUIWorkbench(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localDisplayGUIWorkbench(n, n2, n3);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.displayGUIWorkbench(n, n2, n3);
        }
    }

    public void afterDisplayGUIWorkbench(int n, int n2, int n3) {
    }

    public void beforeDropOneItem(boolean bl) {
    }

    public EntityItem dropOneItem(boolean bl) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenDropOneItem(this);
        EntityItem entityItem = serverPlayerBase == null ? this.playerAPI.localDropOneItem(bl) : (serverPlayerBase != this ? serverPlayerBase.dropOneItem(bl) : null);
        return entityItem;
    }

    public void afterDropOneItem(boolean bl) {
    }

    public void beforeDropPlayerItem(ItemStack itemStack) {
    }

    public EntityItem dropPlayerItem(ItemStack itemStack) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenDropPlayerItem(this);
        EntityItem entityItem = serverPlayerBase == null ? this.playerAPI.localDropPlayerItem(itemStack) : (serverPlayerBase != this ? serverPlayerBase.dropPlayerItem(itemStack) : null);
        return entityItem;
    }

    public void afterDropPlayerItem(ItemStack itemStack) {
    }

    public void beforeFall(float f) {
    }

    public void fall(float f) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenFall(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localFall(f);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.fall(f);
        }
    }

    public void afterFall(float f) {
    }

    public void beforeGetCurrentPlayerStrVsBlock(Block block, boolean bl) {
    }

    public float getCurrentPlayerStrVsBlock(Block block, boolean bl) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenGetCurrentPlayerStrVsBlock(this);
        float f = serverPlayerBase == null ? this.playerAPI.localGetCurrentPlayerStrVsBlock(block, bl) : (serverPlayerBase != this ? serverPlayerBase.getCurrentPlayerStrVsBlock(block, bl) : 0.0f);
        return f;
    }

    public void afterGetCurrentPlayerStrVsBlock(Block block, boolean bl) {
    }

    public void beforeGetCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
    }

    public float getCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenGetCurrentPlayerStrVsBlockForge(this);
        float f = serverPlayerBase == null ? this.playerAPI.localGetCurrentPlayerStrVsBlockForge(block, bl, n) : (serverPlayerBase != this ? serverPlayerBase.getCurrentPlayerStrVsBlockForge(block, bl, n) : 0.0f);
        return f;
    }

    public void afterGetCurrentPlayerStrVsBlockForge(Block block, boolean bl, int n) {
    }

    public void beforeGetDistanceSq(double d, double d2, double d3) {
    }

    public double getDistanceSq(double d, double d2, double d3) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenGetDistanceSq(this);
        double d4 = serverPlayerBase == null ? this.playerAPI.localGetDistanceSq(d, d2, d3) : (serverPlayerBase != this ? serverPlayerBase.getDistanceSq(d, d2, d3) : 0.0);
        return d4;
    }

    public void afterGetDistanceSq(double d, double d2, double d3) {
    }

    public void beforeGetBrightness(float f) {
    }

    public float getBrightness(float f) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenGetBrightness(this);
        float f2 = serverPlayerBase == null ? this.playerAPI.localGetBrightness(f) : (serverPlayerBase != this ? serverPlayerBase.getBrightness(f) : 0.0f);
        return f2;
    }

    public void afterGetBrightness(float f) {
    }

    public void beforeGetEyeHeight() {
    }

    public float getEyeHeight() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenGetEyeHeight(this);
        float f = serverPlayerBase == null ? this.playerAPI.localGetEyeHeight() : (serverPlayerBase != this ? serverPlayerBase.getEyeHeight() : 0.0f);
        return f;
    }

    public void afterGetEyeHeight() {
    }

    public void beforeHeal(float f) {
    }

    public void heal(float f) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenHeal(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localHeal(f);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.heal(f);
        }
    }

    public void afterHeal(float f) {
    }

    public void beforeIsEntityInsideOpaqueBlock() {
    }

    public boolean isEntityInsideOpaqueBlock() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenIsEntityInsideOpaqueBlock(this);
        boolean bl = serverPlayerBase == null ? this.playerAPI.localIsEntityInsideOpaqueBlock() : (serverPlayerBase != this ? serverPlayerBase.isEntityInsideOpaqueBlock() : false);
        return bl;
    }

    public void afterIsEntityInsideOpaqueBlock() {
    }

    public void beforeIsInWater() {
    }

    public boolean isInWater() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenIsInWater(this);
        boolean bl = serverPlayerBase == null ? this.playerAPI.localIsInWater() : (serverPlayerBase != this ? serverPlayerBase.isInWater() : false);
        return bl;
    }

    public void afterIsInWater() {
    }

    public void beforeIsInsideOfMaterial(Material material) {
    }

    public boolean isInsideOfMaterial(Material material) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenIsInsideOfMaterial(this);
        boolean bl = serverPlayerBase == null ? this.playerAPI.localIsInsideOfMaterial(material) : (serverPlayerBase != this ? serverPlayerBase.isInsideOfMaterial(material) : false);
        return bl;
    }

    public void afterIsInsideOfMaterial(Material material) {
    }

    public void beforeIsOnLadder() {
    }

    public boolean isOnLadder() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenIsOnLadder(this);
        boolean bl = serverPlayerBase == null ? this.playerAPI.localIsOnLadder() : (serverPlayerBase != this ? serverPlayerBase.isOnLadder() : false);
        return bl;
    }

    public void afterIsOnLadder() {
    }

    public void beforeIsPlayerSleeping() {
    }

    public boolean isPlayerSleeping() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenIsPlayerSleeping(this);
        boolean bl = serverPlayerBase == null ? this.playerAPI.localIsPlayerSleeping() : (serverPlayerBase != this ? serverPlayerBase.isPlayerSleeping() : false);
        return bl;
    }

    public void afterIsPlayerSleeping() {
    }

    public void beforeJump() {
    }

    public void jump() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenJump(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localJump();
        } else if (serverPlayerBase != this) {
            serverPlayerBase.jump();
        }
    }

    public void afterJump() {
    }

    public void beforeKnockBack(Entity entity, float f, double d, double d2) {
    }

    public void knockBack(Entity entity, float f, double d, double d2) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenKnockBack(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localKnockBack(entity, f, d, d2);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.knockBack(entity, f, d, d2);
        }
    }

    public void afterKnockBack(Entity entity, float f, double d, double d2) {
    }

    public void beforeMoveEntity(double d, double d2, double d3) {
    }

    public void moveEntity(double d, double d2, double d3) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenMoveEntity(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localMoveEntity(d, d2, d3);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.moveEntity(d, d2, d3);
        }
    }

    public void afterMoveEntity(double d, double d2, double d3) {
    }

    public void beforeMoveEntityWithHeading(float f, float f2) {
    }

    public void moveEntityWithHeading(float f, float f2) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenMoveEntityWithHeading(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localMoveEntityWithHeading(f, f2);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.moveEntityWithHeading(f, f2);
        }
    }

    public void afterMoveEntityWithHeading(float f, float f2) {
    }

    public void beforeMoveFlying(float f, float f2, float f3) {
    }

    public void moveFlying(float f, float f2, float f3) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenMoveFlying(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localMoveFlying(f, f2, f3);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.moveFlying(f, f2, f3);
        }
    }

    public void afterMoveFlying(float f, float f2, float f3) {
    }

    public void beforeOnDeath(DamageSource damageSource) {
    }

    public void onDeath(DamageSource damageSource) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenOnDeath(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localOnDeath(damageSource);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.onDeath(damageSource);
        }
    }

    public void afterOnDeath(DamageSource damageSource) {
    }

    public void beforeOnLivingUpdate() {
    }

    public void onLivingUpdate() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenOnLivingUpdate(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localOnLivingUpdate();
        } else if (serverPlayerBase != this) {
            serverPlayerBase.onLivingUpdate();
        }
    }

    public void afterOnLivingUpdate() {
    }

    public void beforeOnKillEntity(EntityLivingBase entityLivingBase) {
    }

    public void onKillEntity(EntityLivingBase entityLivingBase) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenOnKillEntity(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localOnKillEntity(entityLivingBase);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.onKillEntity(entityLivingBase);
        }
    }

    public void afterOnKillEntity(EntityLivingBase entityLivingBase) {
    }

    public void beforeOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
    }

    public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenOnStruckByLightning(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localOnStruckByLightning(entityLightningBolt);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.onStruckByLightning(entityLightningBolt);
        }
    }

    public void afterOnStruckByLightning(EntityLightningBolt entityLightningBolt) {
    }

    public void beforeOnUpdate() {
    }

    public void onUpdate() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenOnUpdate(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localOnUpdate();
        } else if (serverPlayerBase != this) {
            serverPlayerBase.onUpdate();
        }
    }

    public void afterOnUpdate() {
    }

    public void beforeOnUpdateEntity() {
    }

    public void onUpdateEntity() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenOnUpdateEntity(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localOnUpdateEntity();
        } else if (serverPlayerBase != this) {
            serverPlayerBase.onUpdateEntity();
        }
    }

    public void afterOnUpdateEntity() {
    }

    public void beforeReadEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    public void readEntityFromNBT(NBTTagCompound nBTTagCompound) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenReadEntityFromNBT(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localReadEntityFromNBT(nBTTagCompound);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.readEntityFromNBT(nBTTagCompound);
        }
    }

    public void afterReadEntityFromNBT(NBTTagCompound nBTTagCompound) {
    }

    public void beforeSetDead() {
    }

    public void setDead() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenSetDead(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localSetDead();
        } else if (serverPlayerBase != this) {
            serverPlayerBase.setDead();
        }
    }

    public void afterSetDead() {
    }

    public void beforeSetPosition(double d, double d2, double d3) {
    }

    public void setPosition(double d, double d2, double d3) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenSetPosition(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localSetPosition(d, d2, d3);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.setPosition(d, d2, d3);
        }
    }

    public void afterSetPosition(double d, double d2, double d3) {
    }

    public void beforeSwingItem() {
    }

    public void swingItem() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenSwingItem(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localSwingItem();
        } else if (serverPlayerBase != this) {
            serverPlayerBase.swingItem();
        }
    }

    public void afterSwingItem() {
    }

    public void beforeUpdateEntityActionState() {
    }

    public void updateEntityActionState() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenUpdateEntityActionState(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localUpdateEntityActionState();
        } else if (serverPlayerBase != this) {
            serverPlayerBase.updateEntityActionState();
        }
    }

    public void afterUpdateEntityActionState() {
    }

    public void beforeUpdatePotionEffects() {
    }

    public void updatePotionEffects() {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenUpdatePotionEffects(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localUpdatePotionEffects();
        } else if (serverPlayerBase != this) {
            serverPlayerBase.updatePotionEffects();
        }
    }

    public void afterUpdatePotionEffects() {
    }

    public void beforeWriteEntityToNBT(NBTTagCompound nBTTagCompound) {
    }

    public void writeEntityToNBT(NBTTagCompound nBTTagCompound) {
        ServerPlayerBase serverPlayerBase = this.internalServerPlayerAPI.GetOverwrittenWriteEntityToNBT(this);
        if (serverPlayerBase == null) {
            this.playerAPI.localWriteEntityToNBT(nBTTagCompound);
        } else if (serverPlayerBase != this) {
            serverPlayerBase.writeEntityToNBT(nBTTagCompound);
        }
    }

    public void afterWriteEntityToNBT(NBTTagCompound nBTTagCompound) {
    }
}

