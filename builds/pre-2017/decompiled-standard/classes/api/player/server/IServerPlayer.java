/*
 * Decompiled with CFR 0.152.
 */
package api.player.server;

import api.player.server.ServerPlayerBase;
import java.util.List;
import java.util.Random;
import java.util.Set;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.ezey;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.entity.ugqi;
import net.minecraft.util.eidj;
import net.minecraft.util.jxtc;
import net.minecraft.util.tdmn;
import net.minecraft.util.zwaw;

public interface IServerPlayer {
    public ServerPlayerBase getServerPlayerBase(String var1);

    public Set<String> getServerPlayerBaseIds();

    public Object dynamic(String var1, Object[] var2);

    public void realAddExhaustion(float var1);

    public void superAddExhaustion(float var1);

    public void localAddExhaustion(float var1);

    public void realAddExperience(int var1);

    public void superAddExperience(int var1);

    public void localAddExperience(int var1);

    public void realAddExperienceLevel(int var1);

    public void superAddExperienceLevel(int var1);

    public void localAddExperienceLevel(int var1);

    public void realAddMovementStat(double var1, double var3, double var5);

    public void superAddMovementStat(double var1, double var3, double var5);

    public void localAddMovementStat(double var1, double var3, double var5);

    public boolean realAttackEntityFrom(jxtc var1, float var2);

    public boolean superAttackEntityFrom(jxtc var1, float var2);

    public boolean localAttackEntityFrom(jxtc var1, float var2);

    public void realAttackTargetEntityWithCurrentItem(Entity var1);

    public void superAttackTargetEntityWithCurrentItem(Entity var1);

    public void localAttackTargetEntityWithCurrentItem(Entity var1);

    public boolean realCanHarvestBlock(twgu var1);

    public boolean superCanHarvestBlock(twgu var1);

    public boolean localCanHarvestBlock(twgu var1);

    public boolean realCanPlayerEdit(int var1, int var2, int var3, int var4, cvzo var5);

    public boolean superCanPlayerEdit(int var1, int var2, int var3, int var4, cvzo var5);

    public boolean localCanPlayerEdit(int var1, int var2, int var3, int var4, cvzo var5);

    public boolean realCanTriggerWalking();

    public boolean superCanTriggerWalking();

    public boolean localCanTriggerWalking();

    public void realClonePlayer(EntityPlayer var1, boolean var2);

    public void superClonePlayer(EntityPlayer var1, boolean var2);

    public void localClonePlayer(EntityPlayer var1, boolean var2);

    public void realDamageEntity(jxtc var1, float var2);

    public void superDamageEntity(jxtc var1, float var2);

    public void localDamageEntity(jxtc var1, float var2);

    public void realDisplayGUIChest(mssh var1);

    public void superDisplayGUIChest(mssh var1);

    public void localDisplayGUIChest(mssh var1);

    public void realDisplayGUIDispenser(jjzo var1);

    public void superDisplayGUIDispenser(jjzo var1);

    public void localDisplayGUIDispenser(jjzo var1);

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

    public void realFall(float var1);

    public void superFall(float var1);

    public void localFall(float var1);

    public float realGetCurrentPlayerStrVsBlock(twgu var1, boolean var2);

    public float superGetCurrentPlayerStrVsBlock(twgu var1, boolean var2);

    public float localGetCurrentPlayerStrVsBlock(twgu var1, boolean var2);

    public float realGetCurrentPlayerStrVsBlockForge(twgu var1, boolean var2, int var3);

    public float superGetCurrentPlayerStrVsBlockForge(twgu var1, boolean var2, int var3);

    public float localGetCurrentPlayerStrVsBlockForge(twgu var1, boolean var2, int var3);

    public double realGetDistanceSq(double var1, double var3, double var5);

    public double superGetDistanceSq(double var1, double var3, double var5);

    public double localGetDistanceSq(double var1, double var3, double var5);

    public float realGetBrightness(float var1);

    public float superGetBrightness(float var1);

    public float localGetBrightness(float var1);

    public float realGetEyeHeight();

    public float superGetEyeHeight();

    public float localGetEyeHeight();

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

    public void realOnUpdateEntity();

    public void localOnUpdateEntity();

    public void realReadEntityFromNBT(qoac var1);

    public void superReadEntityFromNBT(qoac var1);

    public void localReadEntityFromNBT(qoac var1);

    public void realSetDead();

    public void superSetDead();

    public void localSetDead();

    public void realSetPosition(double var1, double var3, double var5);

    public void superSetPosition(double var1, double var3, double var5);

    public void localSetPosition(double var1, double var3, double var5);

    public void realSwingItem();

    public void superSwingItem();

    public void localSwingItem();

    public void realUpdateEntityActionState();

    public void superUpdateEntityActionState();

    public void localUpdateEntityActionState();

    public void realUpdatePotionEffects();

    public void superUpdatePotionEffects();

    public void localUpdatePotionEffects();

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

    public boolean getChatColoursField();

    public void setChatColoursField(boolean var1);

    public int getChatVisibilityField();

    public void setChatVisibilityField(int var1);

    public int getChunkCoordXField();

    public void setChunkCoordXField(int var1);

    public int getChunkCoordYField();

    public void setChunkCoordYField(int var1);

    public int getChunkCoordZField();

    public void setChunkCoordZField(int var1);

    public int getCurrentWindowIdField();

    public void setCurrentWindowIdField(int var1);

    public ezey getDataWatcherField();

    public void setDataWatcherField(ezey var1);

    public boolean getDeadField();

    public void setDeadField(boolean var1);

    public int getDeathTimeField();

    public void setDeathTimeField(int var1);

    public List<?> getDestroyedItemsNetCacheField();

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

    public float getField_130068_bOField();

    public void setField_130068_bOField(float var1);

    public long getField_143005_bXField();

    public void setField_143005_bXField(long var1);

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

    public int getInitialInvulnerabilityField();

    public void setInitialInvulnerabilityField(int var1);

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

    public int getLastExperienceField();

    public void setLastExperienceField(int var1);

    public int getLastFoodLevelField();

    public void setLastFoodLevelField(int var1);

    public float getLastHealthField();

    public void setLastHealthField(float var1);

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

    public List<?> getLoadedChunksField();

    public double getManagedPosXField();

    public void setManagedPosXField(double var1);

    public double getManagedPosZField();

    public void setManagedPosZField(double var1);

    public int getMaxHurtResistantTimeField();

    public void setMaxHurtResistantTimeField(int var1);

    public int getMaxHurtTimeField();

    public void setMaxHurtTimeField(int var1);

    public dzfd getMcServerField();

    public void setMcServerField(dzfd var1);

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

    public int getPingField();

    public void setPingField(int var1);

    public boolean getPlayerConqueredTheEndField();

    public void setPlayerConqueredTheEndField(boolean var1);

    public boolean getPlayerInventoryBeingManipulatedField();

    public void setPlayerInventoryBeingManipulatedField(boolean var1);

    public zwaw getPlayerLocationField();

    public void setPlayerLocationField(zwaw var1);

    public xbvu getPlayerNetServerHandlerField();

    public void setPlayerNetServerHandlerField(xbvu var1);

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

    public boolean getPreventEntitySpawningField();

    public void setPreventEntitySpawningField(boolean var1);

    public Random getRandField();

    public void setRandField(Random var1);

    public float getRandomYawVelocityField();

    public void setRandomYawVelocityField(float var1);

    public int getRecentlyHitField();

    public void setRecentlyHitField(int var1);

    public int getRenderDistanceField();

    public void setRenderDistanceField(int var1);

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

    public float getStepHeightField();

    public void setStepHeightField(float var1);

    public float getSwingProgressField();

    public void setSwingProgressField(float var1);

    public int getSwingProgressIntField();

    public void setSwingProgressIntField(int var1);

    public int getTeleportDirectionField();

    public void setTeleportDirectionField(int var1);

    public mbsl getTheItemInWorldManagerField();

    public void setTheItemInWorldManagerField(mbsl var1);

    public int getTicksExistedField();

    public void setTicksExistedField(int var1);

    public int getTimeUntilPortalField();

    public void setTimeUntilPortalField(int var1);

    public String getTranslatorField();

    public void setTranslatorField(String var1);

    public String getUsernameField();

    public boolean getVelocityChangedField();

    public void setVelocityChangedField(boolean var1);

    public boolean getWasHungryField();

    public void setWasHungryField(boolean var1);

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

