/*
 * Decompiled with CFR 0.152.
 */
package api.player.client;

import api.player.client.ClientPlayerBase;
import java.util.Random;
import java.util.Set;
import net.minecraft.client.xpzm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.ezey;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.pidb;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.ugqi;
import net.minecraft.util.dwan;
import net.minecraft.util.eidj;
import net.minecraft.util.hank;
import net.minecraft.util.jxtc;
import net.minecraft.util.kjwj;
import net.minecraft.util.tdmn;
import net.minecraft.util.wmvj;
import net.minecraft.util.zwaw;

public interface IClientPlayer {
    public ClientPlayerBase getClientPlayerBase(String var1);

    public Set<String> getClientPlayerBaseIds();

    public Object dynamic(String var1, Object[] var2);

    public void realAddExhaustion(float var1);

    public void superAddExhaustion(float var1);

    public void localAddExhaustion(float var1);

    public void realAddMovementStat(double var1, double var3, double var5);

    public void superAddMovementStat(double var1, double var3, double var5);

    public void localAddMovementStat(double var1, double var3, double var5);

    public void realAddStat(rann var1, int var2);

    public void superAddStat(rann var1, int var2);

    public void localAddStat(rann var1, int var2);

    public boolean realAttackEntityFrom(jxtc var1, float var2);

    public boolean superAttackEntityFrom(jxtc var1, float var2);

    public boolean localAttackEntityFrom(jxtc var1, float var2);

    public void realAttackTargetEntityWithCurrentItem(Entity var1);

    public void superAttackTargetEntityWithCurrentItem(Entity var1);

    public void localAttackTargetEntityWithCurrentItem(Entity var1);

    public boolean realCanBreatheUnderwater();

    public boolean superCanBreatheUnderwater();

    public boolean localCanBreatheUnderwater();

    public boolean realCanHarvestBlock(twgu var1);

    public boolean superCanHarvestBlock(twgu var1);

    public boolean localCanHarvestBlock(twgu var1);

    public boolean realCanPlayerEdit(int var1, int var2, int var3, int var4, cvzo var5);

    public boolean superCanPlayerEdit(int var1, int var2, int var3, int var4, cvzo var5);

    public boolean localCanPlayerEdit(int var1, int var2, int var3, int var4, cvzo var5);

    public boolean realCanTriggerWalking();

    public boolean superCanTriggerWalking();

    public boolean localCanTriggerWalking();

    public void realCloseScreen();

    public void superCloseScreen();

    public void localCloseScreen();

    public void realDamageEntity(jxtc var1, float var2);

    public void superDamageEntity(jxtc var1, float var2);

    public void localDamageEntity(jxtc var1, float var2);

    public void realDisplayGUIBrewingStand(nfbs var1);

    public void superDisplayGUIBrewingStand(nfbs var1);

    public void localDisplayGUIBrewingStand(nfbs var1);

    public void realDisplayGUIChest(mssh var1);

    public void superDisplayGUIChest(mssh var1);

    public void localDisplayGUIChest(mssh var1);

    public void realDisplayGUIDispenser(jjzo var1);

    public void superDisplayGUIDispenser(jjzo var1);

    public void localDisplayGUIDispenser(jjzo var1);

    public void realDisplayGUIEditSign(hurg var1);

    public void superDisplayGUIEditSign(hurg var1);

    public void localDisplayGUIEditSign(hurg var1);

    public void realDisplayGUIEnchantment(int var1, int var2, int var3, String var4);

    public void superDisplayGUIEnchantment(int var1, int var2, int var3, String var4);

    public void localDisplayGUIEnchantment(int var1, int var2, int var3, String var4);

    public void realDisplayGUIFurnace(nwgz var1);

    public void superDisplayGUIFurnace(nwgz var1);

    public void localDisplayGUIFurnace(nwgz var1);

    public void realDisplayGUIWorkbench(int var1, int var2, int var3);

    public void superDisplayGUIWorkbench(int var1, int var2, int var3);

    public void localDisplayGUIWorkbench(int var1, int var2, int var3);

    public EntityItem realDropOneItem(boolean var1);

    public EntityItem superDropOneItem(boolean var1);

    public EntityItem localDropOneItem(boolean var1);

    public EntityItem realDropPlayerItem(cvzo var1);

    public EntityItem superDropPlayerItem(cvzo var1);

    public EntityItem localDropPlayerItem(cvzo var1);

    public EntityItem realDropPlayerItemWithRandomChoice(cvzo var1, boolean var2);

    public EntityItem superDropPlayerItemWithRandomChoice(cvzo var1, boolean var2);

    public EntityItem localDropPlayerItemWithRandomChoice(cvzo var1, boolean var2);

    public void realFall(float var1);

    public void superFall(float var1);

    public void localFall(float var1);

    public float realGetBrightness(float var1);

    public float superGetBrightness(float var1);

    public float localGetBrightness(float var1);

    public int realGetBrightnessForRender(float var1);

    public int superGetBrightnessForRender(float var1);

    public int localGetBrightnessForRender(float var1);

    public float realGetCurrentPlayerStrVsBlock(twgu var1, boolean var2);

    public float superGetCurrentPlayerStrVsBlock(twgu var1, boolean var2);

    public float localGetCurrentPlayerStrVsBlock(twgu var1, boolean var2);

    public float realGetCurrentPlayerStrVsBlockForge(twgu var1, boolean var2, int var3);

    public float superGetCurrentPlayerStrVsBlockForge(twgu var1, boolean var2, int var3);

    public float localGetCurrentPlayerStrVsBlockForge(twgu var1, boolean var2, int var3);

    public double realGetDistanceSq(double var1, double var3, double var5);

    public double superGetDistanceSq(double var1, double var3, double var5);

    public double localGetDistanceSq(double var1, double var3, double var5);

    public double realGetDistanceSqToEntity(Entity var1);

    public double superGetDistanceSqToEntity(Entity var1);

    public double localGetDistanceSqToEntity(Entity var1);

    public float realGetFOVMultiplier();

    public float localGetFOVMultiplier();

    public String realGetHurtSound();

    public String superGetHurtSound();

    public String localGetHurtSound();

    public dwan realGetItemIcon(cvzo var1, int var2);

    public dwan superGetItemIcon(cvzo var1, int var2);

    public dwan localGetItemIcon(cvzo var1, int var2);

    public int realGetSleepTimer();

    public int superGetSleepTimer();

    public int localGetSleepTimer();

    public boolean realHandleLavaMovement();

    public boolean superHandleLavaMovement();

    public boolean localHandleLavaMovement();

    public boolean realHandleWaterMovement();

    public boolean superHandleWaterMovement();

    public boolean localHandleWaterMovement();

    public void realHeal(float var1);

    public void superHeal(float var1);

    public void localHeal(float var1);

    public boolean realIsEntityInsideOpaqueBlock();

    public boolean superIsEntityInsideOpaqueBlock();

    public boolean localIsEntityInsideOpaqueBlock();

    public boolean realIsInWater();

    public boolean superIsInWater();

    public boolean localIsInWater();

    public boolean realIsInsideOfMaterial(tflj var1);

    public boolean superIsInsideOfMaterial(tflj var1);

    public boolean localIsInsideOfMaterial(tflj var1);

    public boolean realIsOnLadder();

    public boolean superIsOnLadder();

    public boolean localIsOnLadder();

    public boolean realIsPlayerSleeping();

    public boolean superIsPlayerSleeping();

    public boolean localIsPlayerSleeping();

    public boolean realIsSneaking();

    public boolean superIsSneaking();

    public boolean localIsSneaking();

    public boolean realIsSprinting();

    public boolean superIsSprinting();

    public boolean localIsSprinting();

    public void realJump();

    public void superJump();

    public void localJump();

    public void realKnockBack(Entity var1, float var2, double var3, double var5);

    public void superKnockBack(Entity var1, float var2, double var3, double var5);

    public void localKnockBack(Entity var1, float var2, double var3, double var5);

    public void realMoveEntity(double var1, double var3, double var5);

    public void superMoveEntity(double var1, double var3, double var5);

    public void localMoveEntity(double var1, double var3, double var5);

    public void realMoveEntityWithHeading(float var1, float var2);

    public void superMoveEntityWithHeading(float var1, float var2);

    public void localMoveEntityWithHeading(float var1, float var2);

    public void realMoveFlying(float var1, float var2, float var3);

    public void superMoveFlying(float var1, float var2, float var3);

    public void localMoveFlying(float var1, float var2, float var3);

    public void realOnDeath(jxtc var1);

    public void superOnDeath(jxtc var1);

    public void localOnDeath(jxtc var1);

    public void realOnLivingUpdate();

    public void superOnLivingUpdate();

    public void localOnLivingUpdate();

    public void realOnKillEntity(EntityLivingBase var1);

    public void superOnKillEntity(EntityLivingBase var1);

    public void localOnKillEntity(EntityLivingBase var1);

    public void realOnStruckByLightning(EntityLightningBolt var1);

    public void superOnStruckByLightning(EntityLightningBolt var1);

    public void localOnStruckByLightning(EntityLightningBolt var1);

    public void realOnUpdate();

    public void superOnUpdate();

    public void localOnUpdate();

    public void realPlayStepSound(int var1, int var2, int var3, int var4);

    public void superPlayStepSound(int var1, int var2, int var3, int var4);

    public void localPlayStepSound(int var1, int var2, int var3, int var4);

    public boolean realPushOutOfBlocks(double var1, double var3, double var5);

    public boolean superPushOutOfBlocks(double var1, double var3, double var5);

    public boolean localPushOutOfBlocks(double var1, double var3, double var5);

    public hank realRayTrace(double var1, float var3);

    public hank superRayTrace(double var1, float var3);

    public hank localRayTrace(double var1, float var3);

    public void realReadEntityFromNBT(qoac var1);

    public void superReadEntityFromNBT(qoac var1);

    public void localReadEntityFromNBT(qoac var1);

    public void realRespawnPlayer();

    public void superRespawnPlayer();

    public void localRespawnPlayer();

    public void realSetDead();

    public void superSetDead();

    public void localSetDead();

    public void realSetPlayerSPHealth(float var1);

    public void localSetPlayerSPHealth(float var1);

    public void realSetPositionAndRotation(double var1, double var3, double var5, float var7, float var8);

    public void superSetPositionAndRotation(double var1, double var3, double var5, float var7, float var8);

    public void localSetPositionAndRotation(double var1, double var3, double var5, float var7, float var8);

    public pidb realSleepInBedAt(int var1, int var2, int var3);

    public pidb superSleepInBedAt(int var1, int var2, int var3);

    public pidb localSleepInBedAt(int var1, int var2, int var3);

    public void realSwingItem();

    public void superSwingItem();

    public void localSwingItem();

    public void realUpdateEntityActionState();

    public void superUpdateEntityActionState();

    public void localUpdateEntityActionState();

    public void realUpdateRidden();

    public void superUpdateRidden();

    public void localUpdateRidden();

    public void realWriteEntityToNBT(qoac var1);

    public void superWriteEntityToNBT(qoac var1);

    public void localWriteEntityToNBT(qoac var1);

    public boolean getAddedToChunkField();

    public void setAddedToChunkField(boolean var1);

    public int getArrowHitTimerField();

    public void setArrowHitTimerField(int var1);

    public int getAttackTimeField();

    public void setAttackTimeField(int var1);

    public float getAttackedAtYawField();

    public void setAttackedAtYawField(float var1);

    public EntityPlayer getAttackingPlayerField();

    public void setAttackingPlayerField(EntityPlayer var1);

    public eidj getBoundingBoxField();

    public float getCameraPitchField();

    public void setCameraPitchField(float var1);

    public float getCameraYawField();

    public void setCameraYawField(float var1);

    public net.minecraft.entity.player.ezey getCapabilitiesField();

    public void setCapabilitiesField(net.minecraft.entity.player.ezey var1);

    public int getChunkCoordXField();

    public void setChunkCoordXField(int var1);

    public int getChunkCoordYField();

    public void setChunkCoordYField(int var1);

    public int getChunkCoordZField();

    public void setChunkCoordZField(int var1);

    public ezey getDataWatcherField();

    public void setDataWatcherField(ezey var1);

    public boolean getDeadField();

    public void setDeadField(boolean var1);

    public int getDeathTimeField();

    public void setDeathTimeField(int var1);

    public int getDimensionField();

    public void setDimensionField(int var1);

    public float getDistanceWalkedModifiedField();

    public void setDistanceWalkedModifiedField(float var1);

    public float getDistanceWalkedOnStepModifiedField();

    public void setDistanceWalkedOnStepModifiedField(float var1);

    public int getEntityAgeField();

    public void setEntityAgeField(int var1);

    public float getEntityCollisionReductionField();

    public void setEntityCollisionReductionField(float var1);

    public int getEntityIdField();

    public void setEntityIdField(int var1);

    public float getExperienceField();

    public void setExperienceField(float var1);

    public int getExperienceLevelField();

    public void setExperienceLevelField(int var1);

    public int getExperienceTotalField();

    public void setExperienceTotalField(int var1);

    public float getFallDistanceField();

    public void setFallDistanceField(float var1);

    public float getField_110154_aXField();

    public void setField_110154_aXField(float var1);

    public boolean getField_70135_KField();

    public void setField_70135_KField(boolean var1);

    public float getField_70741_aBField();

    public void setField_70741_aBField(float var1);

    public float getField_70763_axField();

    public void setField_70763_axField(float var1);

    public float getField_70764_awField();

    public void setField_70764_awField(float var1);

    public float getField_70768_auField();

    public void setField_70768_auField(float var1);

    public float getField_70769_aoField();

    public void setField_70769_aoField(float var1);

    public float getField_70770_apField();

    public void setField_70770_apField(float var1);

    public float getField_71079_bUField();

    public void setField_71079_bUField(float var1);

    public float getField_71082_cxField();

    public void setField_71082_cxField(float var1);

    public double getField_71085_bRField();

    public void setField_71085_bRField(double var1);

    public float getField_71089_bVField();

    public void setField_71089_bVField(float var1);

    public double getField_71091_bMField();

    public void setField_71091_bMField(double var1);

    public double getField_71094_bPField();

    public void setField_71094_bPField(double var1);

    public double getField_71095_bQField();

    public void setField_71095_bQField(double var1);

    public double getField_71096_bNField();

    public void setField_71096_bNField(double var1);

    public double getField_71097_bOField();

    public void setField_71097_bOField(double var1);

    public wmvj getField_71160_ciField();

    public void setField_71160_ciField(wmvj var1);

    public wmvj getField_71161_cjField();

    public void setField_71161_cjField(wmvj var1);

    public wmvj getField_71162_chField();

    public void setField_71162_chField(wmvj var1);

    public int getFireResistanceField();

    public void setFireResistanceField(int var1);

    public EntityFishHook getFishEntityField();

    public void setFishEntityField(EntityFishHook var1);

    public int getFlyToggleTimerField();

    public void setFlyToggleTimerField(int var1);

    public tdmn getFoodStatsField();

    public void setFoodStatsField(tdmn var1);

    public boolean getForceSpawnField();

    public void setForceSpawnField(boolean var1);

    public float getHeightField();

    public void setHeightField(float var1);

    public float getHorseJumpPowerField();

    public void setHorseJumpPowerField(float var1);

    public int getHorseJumpPowerCounterField();

    public void setHorseJumpPowerCounterField(int var1);

    public int getHurtResistantTimeField();

    public void setHurtResistantTimeField(int var1);

    public int getHurtTimeField();

    public void setHurtTimeField(int var1);

    public boolean getIgnoreFrustumCheckField();

    public void setIgnoreFrustumCheckField(boolean var1);

    public boolean getInPortalField();

    public void setInPortalField(boolean var1);

    public boolean getInWaterField();

    public void setInWaterField(boolean var1);

    public net.minecraft.entity.player.eidj getInventoryField();

    public void setInventoryField(net.minecraft.entity.player.eidj var1);

    public jjgc getInventoryContainerField();

    public void setInventoryContainerField(jjgc var1);

    public boolean getIsAirBorneField();

    public void setIsAirBorneField(boolean var1);

    public boolean getIsCollidedField();

    public void setIsCollidedField(boolean var1);

    public boolean getIsCollidedHorizontallyField();

    public void setIsCollidedHorizontallyField(boolean var1);

    public boolean getIsCollidedVerticallyField();

    public void setIsCollidedVerticallyField(boolean var1);

    public boolean getIsDeadField();

    public void setIsDeadField(boolean var1);

    public boolean getIsImmuneToFireField();

    public void setIsImmuneToFireField(boolean var1);

    public boolean getIsInWebField();

    public void setIsInWebField(boolean var1);

    public boolean getIsJumpingField();

    public void setIsJumpingField(boolean var1);

    public boolean getIsSwingInProgressField();

    public void setIsSwingInProgressField(boolean var1);

    public float getJumpMovementFactorField();

    public void setJumpMovementFactorField(float var1);

    public float getLastDamageField();

    public void setLastDamageField(float var1);

    public double getLastTickPosXField();

    public void setLastTickPosXField(double var1);

    public double getLastTickPosYField();

    public void setLastTickPosYField(double var1);

    public double getLastTickPosZField();

    public void setLastTickPosZField(double var1);

    public float getLimbSwingField();

    public void setLimbSwingField(float var1);

    public float getLimbSwingAmountField();

    public void setLimbSwingAmountField(float var1);

    public int getMaxHurtResistantTimeField();

    public void setMaxHurtResistantTimeField(int var1);

    public int getMaxHurtTimeField();

    public void setMaxHurtTimeField(int var1);

    public xpzm getMcField();

    public void setMcField(xpzm var1);

    public double getMotionXField();

    public void setMotionXField(double var1);

    public double getMotionYField();

    public void setMotionYField(double var1);

    public double getMotionZField();

    public void setMotionZField(double var1);

    public float getMoveForwardField();

    public void setMoveForwardField(float var1);

    public float getMoveStrafingField();

    public void setMoveStrafingField(float var1);

    public kjwj getMovementInputField();

    public void setMovementInputField(kjwj var1);

    public ugqi getMyEntitySizeField();

    public void setMyEntitySizeField(ugqi var1);

    public int getNewPosRotationIncrementsField();

    public void setNewPosRotationIncrementsField(int var1);

    public double getNewPosXField();

    public void setNewPosXField(double var1);

    public double getNewPosYField();

    public void setNewPosYField(double var1);

    public double getNewPosZField();

    public void setNewPosZField(double var1);

    public double getNewRotationPitchField();

    public void setNewRotationPitchField(double var1);

    public double getNewRotationYawField();

    public void setNewRotationYawField(double var1);

    public boolean getNoClipField();

    public void setNoClipField(boolean var1);

    public boolean getOnGroundField();

    public void setOnGroundField(boolean var1);

    public jjgc getOpenContainerField();

    public void setOpenContainerField(jjgc var1);

    public zwaw getPlayerLocationField();

    public void setPlayerLocationField(zwaw var1);

    public int getPortalCounterField();

    public void setPortalCounterField(int var1);

    public double getPosXField();

    public void setPosXField(double var1);

    public double getPosYField();

    public void setPosYField(double var1);

    public double getPosZField();

    public void setPosZField(double var1);

    public float getPrevCameraPitchField();

    public void setPrevCameraPitchField(float var1);

    public float getPrevCameraYawField();

    public void setPrevCameraYawField(float var1);

    public float getPrevDistanceWalkedModifiedField();

    public void setPrevDistanceWalkedModifiedField(float var1);

    public float getPrevHealthField();

    public void setPrevHealthField(float var1);

    public float getPrevLimbSwingAmountField();

    public void setPrevLimbSwingAmountField(float var1);

    public double getPrevPosXField();

    public void setPrevPosXField(double var1);

    public double getPrevPosYField();

    public void setPrevPosYField(double var1);

    public double getPrevPosZField();

    public void setPrevPosZField(double var1);

    public float getPrevRenderArmPitchField();

    public void setPrevRenderArmPitchField(float var1);

    public float getPrevRenderArmYawField();

    public void setPrevRenderArmYawField(float var1);

    public float getPrevRenderYawOffsetField();

    public void setPrevRenderYawOffsetField(float var1);

    public float getPrevRotationPitchField();

    public void setPrevRotationPitchField(float var1);

    public float getPrevRotationYawField();

    public void setPrevRotationYawField(float var1);

    public float getPrevRotationYawHeadField();

    public void setPrevRotationYawHeadField(float var1);

    public float getPrevSwingProgressField();

    public void setPrevSwingProgressField(float var1);

    public float getPrevTimeInPortalField();

    public void setPrevTimeInPortalField(float var1);

    public boolean getPreventEntitySpawningField();

    public void setPreventEntitySpawningField(boolean var1);

    public Random getRandField();

    public void setRandField(Random var1);

    public float getRandomYawVelocityField();

    public void setRandomYawVelocityField(float var1);

    public int getRecentlyHitField();

    public void setRecentlyHitField(int var1);

    public float getRenderArmPitchField();

    public void setRenderArmPitchField(float var1);

    public float getRenderArmYawField();

    public void setRenderArmYawField(float var1);

    public double getRenderDistanceWeightField();

    public void setRenderDistanceWeightField(double var1);

    public float getRenderYawOffsetField();

    public void setRenderYawOffsetField(float var1);

    public Entity getRiddenByEntityField();

    public void setRiddenByEntityField(Entity var1);

    public Entity getRidingEntityField();

    public void setRidingEntityField(Entity var1);

    public float getRotationPitchField();

    public void setRotationPitchField(float var1);

    public float getRotationYawField();

    public void setRotationYawField(float var1);

    public float getRotationYawHeadField();

    public void setRotationYawHeadField(float var1);

    public int getScoreValueField();

    public void setScoreValueField(int var1);

    public int getServerPosXField();

    public void setServerPosXField(int var1);

    public int getServerPosYField();

    public void setServerPosYField(int var1);

    public int getServerPosZField();

    public void setServerPosZField(int var1);

    public int getSleepTimerField();

    public void setSleepTimerField(int var1);

    public boolean getSleepingField();

    public void setSleepingField(boolean var1);

    public float getSpeedInAirField();

    public void setSpeedInAirField(float var1);

    public float getSpeedOnGroundField();

    public void setSpeedOnGroundField(float var1);

    public int getSprintToggleTimerField();

    public void setSprintToggleTimerField(int var1);

    public int getSprintingTicksLeftField();

    public void setSprintingTicksLeftField(int var1);

    public float getStepHeightField();

    public void setStepHeightField(float var1);

    public float getSwingProgressField();

    public void setSwingProgressField(float var1);

    public int getSwingProgressIntField();

    public void setSwingProgressIntField(int var1);

    public int getTeleportDirectionField();

    public void setTeleportDirectionField(int var1);

    public int getTicksExistedField();

    public void setTicksExistedField(int var1);

    public float getTimeInPortalField();

    public void setTimeInPortalField(float var1);

    public int getTimeUntilPortalField();

    public void setTimeUntilPortalField(int var1);

    public String getUsernameField();

    public boolean getVelocityChangedField();

    public void setVelocityChangedField(boolean var1);

    public float getWidthField();

    public void setWidthField(float var1);

    public ozlu getWorldObjField();

    public void setWorldObjField(ozlu var1);

    public int getXpCooldownField();

    public void setXpCooldownField(int var1);

    public float getYOffsetField();

    public void setYOffsetField(float var1);

    public float getYSizeField();

    public void setYSizeField(float var1);
}

