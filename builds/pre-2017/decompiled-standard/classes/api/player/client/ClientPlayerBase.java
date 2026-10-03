/*
 * Decompiled with CFR 0.152.
 */
package api.player.client;

import api.player.client.ClientPlayerAPI;
import api.player.client.IClientPlayer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.pidb;
import net.minecraft.util.dwan;
import net.minecraft.util.hank;
import net.minecraft.util.hanr;
import net.minecraft.util.jxtc;

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

    public void beforeLocalConstructing(xpzm xpzm2, ozlu ozlu2, hanr hanr2, int n) {
    }

    public void afterLocalConstructing(xpzm xpzm2, ozlu ozlu2, hanr hanr2, int n) {
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

    public void beforeAddStat(rann rann2, int n) {
    }

    public void addStat(rann rann2, int n) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenAddStat(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localAddStat(rann2, n);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.addStat(rann2, n);
        }
    }

    public void afterAddStat(rann rann2, int n) {
    }

    public void beforeAttackEntityFrom(jxtc jxtc2, float f) {
    }

    public boolean attackEntityFrom(jxtc jxtc2, float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenAttackEntityFrom(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localAttackEntityFrom(jxtc2, f) : (clientPlayerBase != this ? clientPlayerBase.attackEntityFrom(jxtc2, f) : false);
        return bl;
    }

    public void afterAttackEntityFrom(jxtc jxtc2, float f) {
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

    public void beforeCanHarvestBlock(twgu twgu2) {
    }

    public boolean canHarvestBlock(twgu twgu2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenCanHarvestBlock(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localCanHarvestBlock(twgu2) : (clientPlayerBase != this ? clientPlayerBase.canHarvestBlock(twgu2) : false);
        return bl;
    }

    public void afterCanHarvestBlock(twgu twgu2) {
    }

    public void beforeCanPlayerEdit(int n, int n2, int n3, int n4, cvzo cvzo2) {
    }

    public boolean canPlayerEdit(int n, int n2, int n3, int n4, cvzo cvzo2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenCanPlayerEdit(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localCanPlayerEdit(n, n2, n3, n4, cvzo2) : (clientPlayerBase != this ? clientPlayerBase.canPlayerEdit(n, n2, n3, n4, cvzo2) : false);
        return bl;
    }

    public void afterCanPlayerEdit(int n, int n2, int n3, int n4, cvzo cvzo2) {
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

    public void beforeDamageEntity(jxtc jxtc2, float f) {
    }

    public void damageEntity(jxtc jxtc2, float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDamageEntity(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDamageEntity(jxtc2, f);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.damageEntity(jxtc2, f);
        }
    }

    public void afterDamageEntity(jxtc jxtc2, float f) {
    }

    public void beforeDisplayGUIBrewingStand(nfbs nfbs2) {
    }

    public void displayGUIBrewingStand(nfbs nfbs2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIBrewingStand(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIBrewingStand(nfbs2);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIBrewingStand(nfbs2);
        }
    }

    public void afterDisplayGUIBrewingStand(nfbs nfbs2) {
    }

    public void beforeDisplayGUIChest(mssh mssh2) {
    }

    public void displayGUIChest(mssh mssh2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIChest(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIChest(mssh2);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIChest(mssh2);
        }
    }

    public void afterDisplayGUIChest(mssh mssh2) {
    }

    public void beforeDisplayGUIDispenser(jjzo jjzo2) {
    }

    public void displayGUIDispenser(jjzo jjzo2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIDispenser(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIDispenser(jjzo2);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIDispenser(jjzo2);
        }
    }

    public void afterDisplayGUIDispenser(jjzo jjzo2) {
    }

    public void beforeDisplayGUIEditSign(hurg hurg2) {
    }

    public void displayGUIEditSign(hurg hurg2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIEditSign(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIEditSign(hurg2);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIEditSign(hurg2);
        }
    }

    public void afterDisplayGUIEditSign(hurg hurg2) {
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

    public void beforeDisplayGUIFurnace(nwgz nwgz2) {
    }

    public void displayGUIFurnace(nwgz nwgz2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDisplayGUIFurnace(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localDisplayGUIFurnace(nwgz2);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.displayGUIFurnace(nwgz2);
        }
    }

    public void afterDisplayGUIFurnace(nwgz nwgz2) {
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

    public void beforeDropPlayerItem(cvzo cvzo2) {
    }

    public EntityItem dropPlayerItem(cvzo cvzo2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDropPlayerItem(this);
        EntityItem entityItem = clientPlayerBase == null ? this.playerAPI.localDropPlayerItem(cvzo2) : (clientPlayerBase != this ? clientPlayerBase.dropPlayerItem(cvzo2) : null);
        return entityItem;
    }

    public void afterDropPlayerItem(cvzo cvzo2) {
    }

    public void beforeDropPlayerItemWithRandomChoice(cvzo cvzo2, boolean bl) {
    }

    public EntityItem dropPlayerItemWithRandomChoice(cvzo cvzo2, boolean bl) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenDropPlayerItemWithRandomChoice(this);
        EntityItem entityItem = clientPlayerBase == null ? this.playerAPI.localDropPlayerItemWithRandomChoice(cvzo2, bl) : (clientPlayerBase != this ? clientPlayerBase.dropPlayerItemWithRandomChoice(cvzo2, bl) : null);
        return entityItem;
    }

    public void afterDropPlayerItemWithRandomChoice(cvzo cvzo2, boolean bl) {
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

    public void beforeGetCurrentPlayerStrVsBlock(twgu twgu2, boolean bl) {
    }

    public float getCurrentPlayerStrVsBlock(twgu twgu2, boolean bl) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetCurrentPlayerStrVsBlock(this);
        float f = clientPlayerBase == null ? this.playerAPI.localGetCurrentPlayerStrVsBlock(twgu2, bl) : (clientPlayerBase != this ? clientPlayerBase.getCurrentPlayerStrVsBlock(twgu2, bl) : 0.0f);
        return f;
    }

    public void afterGetCurrentPlayerStrVsBlock(twgu twgu2, boolean bl) {
    }

    public void beforeGetCurrentPlayerStrVsBlockForge(twgu twgu2, boolean bl, int n) {
    }

    public float getCurrentPlayerStrVsBlockForge(twgu twgu2, boolean bl, int n) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetCurrentPlayerStrVsBlockForge(this);
        float f = clientPlayerBase == null ? this.playerAPI.localGetCurrentPlayerStrVsBlockForge(twgu2, bl, n) : (clientPlayerBase != this ? clientPlayerBase.getCurrentPlayerStrVsBlockForge(twgu2, bl, n) : 0.0f);
        return f;
    }

    public void afterGetCurrentPlayerStrVsBlockForge(twgu twgu2, boolean bl, int n) {
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

    public void beforeGetItemIcon(cvzo cvzo2, int n) {
    }

    public dwan getItemIcon(cvzo cvzo2, int n) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenGetItemIcon(this);
        dwan dwan2 = clientPlayerBase == null ? this.playerAPI.localGetItemIcon(cvzo2, n) : (clientPlayerBase != this ? clientPlayerBase.getItemIcon(cvzo2, n) : null);
        return dwan2;
    }

    public void afterGetItemIcon(cvzo cvzo2, int n) {
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

    public void beforeIsInsideOfMaterial(tflj tflj2) {
    }

    public boolean isInsideOfMaterial(tflj tflj2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenIsInsideOfMaterial(this);
        boolean bl = clientPlayerBase == null ? this.playerAPI.localIsInsideOfMaterial(tflj2) : (clientPlayerBase != this ? clientPlayerBase.isInsideOfMaterial(tflj2) : false);
        return bl;
    }

    public void afterIsInsideOfMaterial(tflj tflj2) {
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

    public void beforeOnDeath(jxtc jxtc2) {
    }

    public void onDeath(jxtc jxtc2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenOnDeath(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localOnDeath(jxtc2);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.onDeath(jxtc2);
        }
    }

    public void afterOnDeath(jxtc jxtc2) {
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

    public hank rayTrace(double d, float f) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenRayTrace(this);
        hank hank2 = clientPlayerBase == null ? this.playerAPI.localRayTrace(d, f) : (clientPlayerBase != this ? clientPlayerBase.rayTrace(d, f) : null);
        return hank2;
    }

    public void afterRayTrace(double d, float f) {
    }

    public void beforeReadEntityFromNBT(qoac qoac2) {
    }

    public void readEntityFromNBT(qoac qoac2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenReadEntityFromNBT(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localReadEntityFromNBT(qoac2);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.readEntityFromNBT(qoac2);
        }
    }

    public void afterReadEntityFromNBT(qoac qoac2) {
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

    public pidb sleepInBedAt(int n, int n2, int n3) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenSleepInBedAt(this);
        pidb pidb2 = clientPlayerBase == null ? this.playerAPI.localSleepInBedAt(n, n2, n3) : (clientPlayerBase != this ? clientPlayerBase.sleepInBedAt(n, n2, n3) : null);
        return pidb2;
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

    public void beforeWriteEntityToNBT(qoac qoac2) {
    }

    public void writeEntityToNBT(qoac qoac2) {
        ClientPlayerBase clientPlayerBase = this.internalClientPlayerAPI.GetOverwrittenWriteEntityToNBT(this);
        if (clientPlayerBase == null) {
            this.playerAPI.localWriteEntityToNBT(qoac2);
        } else if (clientPlayerBase != this) {
            clientPlayerBase.writeEntityToNBT(qoac2);
        }
    }

    public void afterWriteEntityToNBT(qoac qoac2) {
    }
}

