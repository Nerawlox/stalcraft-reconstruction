/*
 * Decompiled with CFR 0.152.
 */
package api.player.client;

import java.util.HashMap;
import java.util.Map;

public final class ClientPlayerBaseSorting {
    private String[] beforeLocalConstructingSuperiors = null;
    private String[] beforeLocalConstructingInferiors = null;
    private String[] afterLocalConstructingSuperiors = null;
    private String[] afterLocalConstructingInferiors = null;
    private Map<String, String[]> dynamicBeforeSuperiors = null;
    private Map<String, String[]> dynamicBeforeInferiors = null;
    private Map<String, String[]> dynamicOverrideSuperiors = null;
    private Map<String, String[]> dynamicOverrideInferiors = null;
    private Map<String, String[]> dynamicAfterSuperiors = null;
    private Map<String, String[]> dynamicAfterInferiors = null;
    private String[] beforeAddExhaustionSuperiors = null;
    private String[] beforeAddExhaustionInferiors = null;
    private String[] overrideAddExhaustionSuperiors = null;
    private String[] overrideAddExhaustionInferiors = null;
    private String[] afterAddExhaustionSuperiors = null;
    private String[] afterAddExhaustionInferiors = null;
    private String[] beforeAddMovementStatSuperiors = null;
    private String[] beforeAddMovementStatInferiors = null;
    private String[] overrideAddMovementStatSuperiors = null;
    private String[] overrideAddMovementStatInferiors = null;
    private String[] afterAddMovementStatSuperiors = null;
    private String[] afterAddMovementStatInferiors = null;
    private String[] beforeAddStatSuperiors = null;
    private String[] beforeAddStatInferiors = null;
    private String[] overrideAddStatSuperiors = null;
    private String[] overrideAddStatInferiors = null;
    private String[] afterAddStatSuperiors = null;
    private String[] afterAddStatInferiors = null;
    private String[] beforeAttackEntityFromSuperiors = null;
    private String[] beforeAttackEntityFromInferiors = null;
    private String[] overrideAttackEntityFromSuperiors = null;
    private String[] overrideAttackEntityFromInferiors = null;
    private String[] afterAttackEntityFromSuperiors = null;
    private String[] afterAttackEntityFromInferiors = null;
    private String[] beforeAttackTargetEntityWithCurrentItemSuperiors = null;
    private String[] beforeAttackTargetEntityWithCurrentItemInferiors = null;
    private String[] overrideAttackTargetEntityWithCurrentItemSuperiors = null;
    private String[] overrideAttackTargetEntityWithCurrentItemInferiors = null;
    private String[] afterAttackTargetEntityWithCurrentItemSuperiors = null;
    private String[] afterAttackTargetEntityWithCurrentItemInferiors = null;
    private String[] beforeCanBreatheUnderwaterSuperiors = null;
    private String[] beforeCanBreatheUnderwaterInferiors = null;
    private String[] overrideCanBreatheUnderwaterSuperiors = null;
    private String[] overrideCanBreatheUnderwaterInferiors = null;
    private String[] afterCanBreatheUnderwaterSuperiors = null;
    private String[] afterCanBreatheUnderwaterInferiors = null;
    private String[] beforeCanHarvestBlockSuperiors = null;
    private String[] beforeCanHarvestBlockInferiors = null;
    private String[] overrideCanHarvestBlockSuperiors = null;
    private String[] overrideCanHarvestBlockInferiors = null;
    private String[] afterCanHarvestBlockSuperiors = null;
    private String[] afterCanHarvestBlockInferiors = null;
    private String[] beforeCanPlayerEditSuperiors = null;
    private String[] beforeCanPlayerEditInferiors = null;
    private String[] overrideCanPlayerEditSuperiors = null;
    private String[] overrideCanPlayerEditInferiors = null;
    private String[] afterCanPlayerEditSuperiors = null;
    private String[] afterCanPlayerEditInferiors = null;
    private String[] beforeCanTriggerWalkingSuperiors = null;
    private String[] beforeCanTriggerWalkingInferiors = null;
    private String[] overrideCanTriggerWalkingSuperiors = null;
    private String[] overrideCanTriggerWalkingInferiors = null;
    private String[] afterCanTriggerWalkingSuperiors = null;
    private String[] afterCanTriggerWalkingInferiors = null;
    private String[] beforeCloseScreenSuperiors = null;
    private String[] beforeCloseScreenInferiors = null;
    private String[] overrideCloseScreenSuperiors = null;
    private String[] overrideCloseScreenInferiors = null;
    private String[] afterCloseScreenSuperiors = null;
    private String[] afterCloseScreenInferiors = null;
    private String[] beforeDamageEntitySuperiors = null;
    private String[] beforeDamageEntityInferiors = null;
    private String[] overrideDamageEntitySuperiors = null;
    private String[] overrideDamageEntityInferiors = null;
    private String[] afterDamageEntitySuperiors = null;
    private String[] afterDamageEntityInferiors = null;
    private String[] beforeDisplayGUIBrewingStandSuperiors = null;
    private String[] beforeDisplayGUIBrewingStandInferiors = null;
    private String[] overrideDisplayGUIBrewingStandSuperiors = null;
    private String[] overrideDisplayGUIBrewingStandInferiors = null;
    private String[] afterDisplayGUIBrewingStandSuperiors = null;
    private String[] afterDisplayGUIBrewingStandInferiors = null;
    private String[] beforeDisplayGUIChestSuperiors = null;
    private String[] beforeDisplayGUIChestInferiors = null;
    private String[] overrideDisplayGUIChestSuperiors = null;
    private String[] overrideDisplayGUIChestInferiors = null;
    private String[] afterDisplayGUIChestSuperiors = null;
    private String[] afterDisplayGUIChestInferiors = null;
    private String[] beforeDisplayGUIDispenserSuperiors = null;
    private String[] beforeDisplayGUIDispenserInferiors = null;
    private String[] overrideDisplayGUIDispenserSuperiors = null;
    private String[] overrideDisplayGUIDispenserInferiors = null;
    private String[] afterDisplayGUIDispenserSuperiors = null;
    private String[] afterDisplayGUIDispenserInferiors = null;
    private String[] beforeDisplayGUIEditSignSuperiors = null;
    private String[] beforeDisplayGUIEditSignInferiors = null;
    private String[] overrideDisplayGUIEditSignSuperiors = null;
    private String[] overrideDisplayGUIEditSignInferiors = null;
    private String[] afterDisplayGUIEditSignSuperiors = null;
    private String[] afterDisplayGUIEditSignInferiors = null;
    private String[] beforeDisplayGUIEnchantmentSuperiors = null;
    private String[] beforeDisplayGUIEnchantmentInferiors = null;
    private String[] overrideDisplayGUIEnchantmentSuperiors = null;
    private String[] overrideDisplayGUIEnchantmentInferiors = null;
    private String[] afterDisplayGUIEnchantmentSuperiors = null;
    private String[] afterDisplayGUIEnchantmentInferiors = null;
    private String[] beforeDisplayGUIFurnaceSuperiors = null;
    private String[] beforeDisplayGUIFurnaceInferiors = null;
    private String[] overrideDisplayGUIFurnaceSuperiors = null;
    private String[] overrideDisplayGUIFurnaceInferiors = null;
    private String[] afterDisplayGUIFurnaceSuperiors = null;
    private String[] afterDisplayGUIFurnaceInferiors = null;
    private String[] beforeDisplayGUIWorkbenchSuperiors = null;
    private String[] beforeDisplayGUIWorkbenchInferiors = null;
    private String[] overrideDisplayGUIWorkbenchSuperiors = null;
    private String[] overrideDisplayGUIWorkbenchInferiors = null;
    private String[] afterDisplayGUIWorkbenchSuperiors = null;
    private String[] afterDisplayGUIWorkbenchInferiors = null;
    private String[] beforeDropOneItemSuperiors = null;
    private String[] beforeDropOneItemInferiors = null;
    private String[] overrideDropOneItemSuperiors = null;
    private String[] overrideDropOneItemInferiors = null;
    private String[] afterDropOneItemSuperiors = null;
    private String[] afterDropOneItemInferiors = null;
    private String[] beforeDropPlayerItemSuperiors = null;
    private String[] beforeDropPlayerItemInferiors = null;
    private String[] overrideDropPlayerItemSuperiors = null;
    private String[] overrideDropPlayerItemInferiors = null;
    private String[] afterDropPlayerItemSuperiors = null;
    private String[] afterDropPlayerItemInferiors = null;
    private String[] beforeDropPlayerItemWithRandomChoiceSuperiors = null;
    private String[] beforeDropPlayerItemWithRandomChoiceInferiors = null;
    private String[] overrideDropPlayerItemWithRandomChoiceSuperiors = null;
    private String[] overrideDropPlayerItemWithRandomChoiceInferiors = null;
    private String[] afterDropPlayerItemWithRandomChoiceSuperiors = null;
    private String[] afterDropPlayerItemWithRandomChoiceInferiors = null;
    private String[] beforeFallSuperiors = null;
    private String[] beforeFallInferiors = null;
    private String[] overrideFallSuperiors = null;
    private String[] overrideFallInferiors = null;
    private String[] afterFallSuperiors = null;
    private String[] afterFallInferiors = null;
    private String[] beforeGetBrightnessSuperiors = null;
    private String[] beforeGetBrightnessInferiors = null;
    private String[] overrideGetBrightnessSuperiors = null;
    private String[] overrideGetBrightnessInferiors = null;
    private String[] afterGetBrightnessSuperiors = null;
    private String[] afterGetBrightnessInferiors = null;
    private String[] beforeGetBrightnessForRenderSuperiors = null;
    private String[] beforeGetBrightnessForRenderInferiors = null;
    private String[] overrideGetBrightnessForRenderSuperiors = null;
    private String[] overrideGetBrightnessForRenderInferiors = null;
    private String[] afterGetBrightnessForRenderSuperiors = null;
    private String[] afterGetBrightnessForRenderInferiors = null;
    private String[] beforeGetCurrentPlayerStrVsBlockSuperiors = null;
    private String[] beforeGetCurrentPlayerStrVsBlockInferiors = null;
    private String[] overrideGetCurrentPlayerStrVsBlockSuperiors = null;
    private String[] overrideGetCurrentPlayerStrVsBlockInferiors = null;
    private String[] afterGetCurrentPlayerStrVsBlockSuperiors = null;
    private String[] afterGetCurrentPlayerStrVsBlockInferiors = null;
    private String[] beforeGetCurrentPlayerStrVsBlockForgeSuperiors = null;
    private String[] beforeGetCurrentPlayerStrVsBlockForgeInferiors = null;
    private String[] overrideGetCurrentPlayerStrVsBlockForgeSuperiors = null;
    private String[] overrideGetCurrentPlayerStrVsBlockForgeInferiors = null;
    private String[] afterGetCurrentPlayerStrVsBlockForgeSuperiors = null;
    private String[] afterGetCurrentPlayerStrVsBlockForgeInferiors = null;
    private String[] beforeGetDistanceSqSuperiors = null;
    private String[] beforeGetDistanceSqInferiors = null;
    private String[] overrideGetDistanceSqSuperiors = null;
    private String[] overrideGetDistanceSqInferiors = null;
    private String[] afterGetDistanceSqSuperiors = null;
    private String[] afterGetDistanceSqInferiors = null;
    private String[] beforeGetDistanceSqToEntitySuperiors = null;
    private String[] beforeGetDistanceSqToEntityInferiors = null;
    private String[] overrideGetDistanceSqToEntitySuperiors = null;
    private String[] overrideGetDistanceSqToEntityInferiors = null;
    private String[] afterGetDistanceSqToEntitySuperiors = null;
    private String[] afterGetDistanceSqToEntityInferiors = null;
    private String[] beforeGetFOVMultiplierSuperiors = null;
    private String[] beforeGetFOVMultiplierInferiors = null;
    private String[] overrideGetFOVMultiplierSuperiors = null;
    private String[] overrideGetFOVMultiplierInferiors = null;
    private String[] afterGetFOVMultiplierSuperiors = null;
    private String[] afterGetFOVMultiplierInferiors = null;
    private String[] beforeGetHurtSoundSuperiors = null;
    private String[] beforeGetHurtSoundInferiors = null;
    private String[] overrideGetHurtSoundSuperiors = null;
    private String[] overrideGetHurtSoundInferiors = null;
    private String[] afterGetHurtSoundSuperiors = null;
    private String[] afterGetHurtSoundInferiors = null;
    private String[] beforeGetItemIconSuperiors = null;
    private String[] beforeGetItemIconInferiors = null;
    private String[] overrideGetItemIconSuperiors = null;
    private String[] overrideGetItemIconInferiors = null;
    private String[] afterGetItemIconSuperiors = null;
    private String[] afterGetItemIconInferiors = null;
    private String[] beforeGetSleepTimerSuperiors = null;
    private String[] beforeGetSleepTimerInferiors = null;
    private String[] overrideGetSleepTimerSuperiors = null;
    private String[] overrideGetSleepTimerInferiors = null;
    private String[] afterGetSleepTimerSuperiors = null;
    private String[] afterGetSleepTimerInferiors = null;
    private String[] beforeHandleLavaMovementSuperiors = null;
    private String[] beforeHandleLavaMovementInferiors = null;
    private String[] overrideHandleLavaMovementSuperiors = null;
    private String[] overrideHandleLavaMovementInferiors = null;
    private String[] afterHandleLavaMovementSuperiors = null;
    private String[] afterHandleLavaMovementInferiors = null;
    private String[] beforeHandleWaterMovementSuperiors = null;
    private String[] beforeHandleWaterMovementInferiors = null;
    private String[] overrideHandleWaterMovementSuperiors = null;
    private String[] overrideHandleWaterMovementInferiors = null;
    private String[] afterHandleWaterMovementSuperiors = null;
    private String[] afterHandleWaterMovementInferiors = null;
    private String[] beforeHealSuperiors = null;
    private String[] beforeHealInferiors = null;
    private String[] overrideHealSuperiors = null;
    private String[] overrideHealInferiors = null;
    private String[] afterHealSuperiors = null;
    private String[] afterHealInferiors = null;
    private String[] beforeIsEntityInsideOpaqueBlockSuperiors = null;
    private String[] beforeIsEntityInsideOpaqueBlockInferiors = null;
    private String[] overrideIsEntityInsideOpaqueBlockSuperiors = null;
    private String[] overrideIsEntityInsideOpaqueBlockInferiors = null;
    private String[] afterIsEntityInsideOpaqueBlockSuperiors = null;
    private String[] afterIsEntityInsideOpaqueBlockInferiors = null;
    private String[] beforeIsInWaterSuperiors = null;
    private String[] beforeIsInWaterInferiors = null;
    private String[] overrideIsInWaterSuperiors = null;
    private String[] overrideIsInWaterInferiors = null;
    private String[] afterIsInWaterSuperiors = null;
    private String[] afterIsInWaterInferiors = null;
    private String[] beforeIsInsideOfMaterialSuperiors = null;
    private String[] beforeIsInsideOfMaterialInferiors = null;
    private String[] overrideIsInsideOfMaterialSuperiors = null;
    private String[] overrideIsInsideOfMaterialInferiors = null;
    private String[] afterIsInsideOfMaterialSuperiors = null;
    private String[] afterIsInsideOfMaterialInferiors = null;
    private String[] beforeIsOnLadderSuperiors = null;
    private String[] beforeIsOnLadderInferiors = null;
    private String[] overrideIsOnLadderSuperiors = null;
    private String[] overrideIsOnLadderInferiors = null;
    private String[] afterIsOnLadderSuperiors = null;
    private String[] afterIsOnLadderInferiors = null;
    private String[] beforeIsPlayerSleepingSuperiors = null;
    private String[] beforeIsPlayerSleepingInferiors = null;
    private String[] overrideIsPlayerSleepingSuperiors = null;
    private String[] overrideIsPlayerSleepingInferiors = null;
    private String[] afterIsPlayerSleepingSuperiors = null;
    private String[] afterIsPlayerSleepingInferiors = null;
    private String[] beforeIsSneakingSuperiors = null;
    private String[] beforeIsSneakingInferiors = null;
    private String[] overrideIsSneakingSuperiors = null;
    private String[] overrideIsSneakingInferiors = null;
    private String[] afterIsSneakingSuperiors = null;
    private String[] afterIsSneakingInferiors = null;
    private String[] beforeIsSprintingSuperiors = null;
    private String[] beforeIsSprintingInferiors = null;
    private String[] overrideIsSprintingSuperiors = null;
    private String[] overrideIsSprintingInferiors = null;
    private String[] afterIsSprintingSuperiors = null;
    private String[] afterIsSprintingInferiors = null;
    private String[] beforeJumpSuperiors = null;
    private String[] beforeJumpInferiors = null;
    private String[] overrideJumpSuperiors = null;
    private String[] overrideJumpInferiors = null;
    private String[] afterJumpSuperiors = null;
    private String[] afterJumpInferiors = null;
    private String[] beforeKnockBackSuperiors = null;
    private String[] beforeKnockBackInferiors = null;
    private String[] overrideKnockBackSuperiors = null;
    private String[] overrideKnockBackInferiors = null;
    private String[] afterKnockBackSuperiors = null;
    private String[] afterKnockBackInferiors = null;
    private String[] beforeMoveEntitySuperiors = null;
    private String[] beforeMoveEntityInferiors = null;
    private String[] overrideMoveEntitySuperiors = null;
    private String[] overrideMoveEntityInferiors = null;
    private String[] afterMoveEntitySuperiors = null;
    private String[] afterMoveEntityInferiors = null;
    private String[] beforeMoveEntityWithHeadingSuperiors = null;
    private String[] beforeMoveEntityWithHeadingInferiors = null;
    private String[] overrideMoveEntityWithHeadingSuperiors = null;
    private String[] overrideMoveEntityWithHeadingInferiors = null;
    private String[] afterMoveEntityWithHeadingSuperiors = null;
    private String[] afterMoveEntityWithHeadingInferiors = null;
    private String[] beforeMoveFlyingSuperiors = null;
    private String[] beforeMoveFlyingInferiors = null;
    private String[] overrideMoveFlyingSuperiors = null;
    private String[] overrideMoveFlyingInferiors = null;
    private String[] afterMoveFlyingSuperiors = null;
    private String[] afterMoveFlyingInferiors = null;
    private String[] beforeOnDeathSuperiors = null;
    private String[] beforeOnDeathInferiors = null;
    private String[] overrideOnDeathSuperiors = null;
    private String[] overrideOnDeathInferiors = null;
    private String[] afterOnDeathSuperiors = null;
    private String[] afterOnDeathInferiors = null;
    private String[] beforeOnLivingUpdateSuperiors = null;
    private String[] beforeOnLivingUpdateInferiors = null;
    private String[] overrideOnLivingUpdateSuperiors = null;
    private String[] overrideOnLivingUpdateInferiors = null;
    private String[] afterOnLivingUpdateSuperiors = null;
    private String[] afterOnLivingUpdateInferiors = null;
    private String[] beforeOnKillEntitySuperiors = null;
    private String[] beforeOnKillEntityInferiors = null;
    private String[] overrideOnKillEntitySuperiors = null;
    private String[] overrideOnKillEntityInferiors = null;
    private String[] afterOnKillEntitySuperiors = null;
    private String[] afterOnKillEntityInferiors = null;
    private String[] beforeOnStruckByLightningSuperiors = null;
    private String[] beforeOnStruckByLightningInferiors = null;
    private String[] overrideOnStruckByLightningSuperiors = null;
    private String[] overrideOnStruckByLightningInferiors = null;
    private String[] afterOnStruckByLightningSuperiors = null;
    private String[] afterOnStruckByLightningInferiors = null;
    private String[] beforeOnUpdateSuperiors = null;
    private String[] beforeOnUpdateInferiors = null;
    private String[] overrideOnUpdateSuperiors = null;
    private String[] overrideOnUpdateInferiors = null;
    private String[] afterOnUpdateSuperiors = null;
    private String[] afterOnUpdateInferiors = null;
    private String[] beforePlayStepSoundSuperiors = null;
    private String[] beforePlayStepSoundInferiors = null;
    private String[] overridePlayStepSoundSuperiors = null;
    private String[] overridePlayStepSoundInferiors = null;
    private String[] afterPlayStepSoundSuperiors = null;
    private String[] afterPlayStepSoundInferiors = null;
    private String[] beforePushOutOfBlocksSuperiors = null;
    private String[] beforePushOutOfBlocksInferiors = null;
    private String[] overridePushOutOfBlocksSuperiors = null;
    private String[] overridePushOutOfBlocksInferiors = null;
    private String[] afterPushOutOfBlocksSuperiors = null;
    private String[] afterPushOutOfBlocksInferiors = null;
    private String[] beforeRayTraceSuperiors = null;
    private String[] beforeRayTraceInferiors = null;
    private String[] overrideRayTraceSuperiors = null;
    private String[] overrideRayTraceInferiors = null;
    private String[] afterRayTraceSuperiors = null;
    private String[] afterRayTraceInferiors = null;
    private String[] beforeReadEntityFromNBTSuperiors = null;
    private String[] beforeReadEntityFromNBTInferiors = null;
    private String[] overrideReadEntityFromNBTSuperiors = null;
    private String[] overrideReadEntityFromNBTInferiors = null;
    private String[] afterReadEntityFromNBTSuperiors = null;
    private String[] afterReadEntityFromNBTInferiors = null;
    private String[] beforeRespawnPlayerSuperiors = null;
    private String[] beforeRespawnPlayerInferiors = null;
    private String[] overrideRespawnPlayerSuperiors = null;
    private String[] overrideRespawnPlayerInferiors = null;
    private String[] afterRespawnPlayerSuperiors = null;
    private String[] afterRespawnPlayerInferiors = null;
    private String[] beforeSetDeadSuperiors = null;
    private String[] beforeSetDeadInferiors = null;
    private String[] overrideSetDeadSuperiors = null;
    private String[] overrideSetDeadInferiors = null;
    private String[] afterSetDeadSuperiors = null;
    private String[] afterSetDeadInferiors = null;
    private String[] beforeSetPlayerSPHealthSuperiors = null;
    private String[] beforeSetPlayerSPHealthInferiors = null;
    private String[] overrideSetPlayerSPHealthSuperiors = null;
    private String[] overrideSetPlayerSPHealthInferiors = null;
    private String[] afterSetPlayerSPHealthSuperiors = null;
    private String[] afterSetPlayerSPHealthInferiors = null;
    private String[] beforeSetPositionAndRotationSuperiors = null;
    private String[] beforeSetPositionAndRotationInferiors = null;
    private String[] overrideSetPositionAndRotationSuperiors = null;
    private String[] overrideSetPositionAndRotationInferiors = null;
    private String[] afterSetPositionAndRotationSuperiors = null;
    private String[] afterSetPositionAndRotationInferiors = null;
    private String[] beforeSleepInBedAtSuperiors = null;
    private String[] beforeSleepInBedAtInferiors = null;
    private String[] overrideSleepInBedAtSuperiors = null;
    private String[] overrideSleepInBedAtInferiors = null;
    private String[] afterSleepInBedAtSuperiors = null;
    private String[] afterSleepInBedAtInferiors = null;
    private String[] beforeSwingItemSuperiors = null;
    private String[] beforeSwingItemInferiors = null;
    private String[] overrideSwingItemSuperiors = null;
    private String[] overrideSwingItemInferiors = null;
    private String[] afterSwingItemSuperiors = null;
    private String[] afterSwingItemInferiors = null;
    private String[] beforeUpdateEntityActionStateSuperiors = null;
    private String[] beforeUpdateEntityActionStateInferiors = null;
    private String[] overrideUpdateEntityActionStateSuperiors = null;
    private String[] overrideUpdateEntityActionStateInferiors = null;
    private String[] afterUpdateEntityActionStateSuperiors = null;
    private String[] afterUpdateEntityActionStateInferiors = null;
    private String[] beforeUpdateRiddenSuperiors = null;
    private String[] beforeUpdateRiddenInferiors = null;
    private String[] overrideUpdateRiddenSuperiors = null;
    private String[] overrideUpdateRiddenInferiors = null;
    private String[] afterUpdateRiddenSuperiors = null;
    private String[] afterUpdateRiddenInferiors = null;
    private String[] beforeWriteEntityToNBTSuperiors = null;
    private String[] beforeWriteEntityToNBTInferiors = null;
    private String[] overrideWriteEntityToNBTSuperiors = null;
    private String[] overrideWriteEntityToNBTInferiors = null;
    private String[] afterWriteEntityToNBTSuperiors = null;
    private String[] afterWriteEntityToNBTInferiors = null;

    public String[] getBeforeLocalConstructingSuperiors() {
        return this.beforeLocalConstructingSuperiors;
    }

    public String[] getBeforeLocalConstructingInferiors() {
        return this.beforeLocalConstructingInferiors;
    }

    public String[] getAfterLocalConstructingSuperiors() {
        return this.afterLocalConstructingSuperiors;
    }

    public String[] getAfterLocalConstructingInferiors() {
        return this.afterLocalConstructingInferiors;
    }

    public void setBeforeLocalConstructingSuperiors(String[] stringArray) {
        this.beforeLocalConstructingSuperiors = stringArray;
    }

    public void setBeforeLocalConstructingInferiors(String[] stringArray) {
        this.beforeLocalConstructingInferiors = stringArray;
    }

    public void setAfterLocalConstructingSuperiors(String[] stringArray) {
        this.afterLocalConstructingSuperiors = stringArray;
    }

    public void setAfterLocalConstructingInferiors(String[] stringArray) {
        this.afterLocalConstructingInferiors = stringArray;
    }

    public Map<String, String[]> getDynamicBeforeSuperiors() {
        return this.dynamicBeforeSuperiors;
    }

    public Map<String, String[]> getDynamicBeforeInferiors() {
        return this.dynamicBeforeInferiors;
    }

    public Map<String, String[]> getDynamicOverrideSuperiors() {
        return this.dynamicOverrideSuperiors;
    }

    public Map<String, String[]> getDynamicOverrideInferiors() {
        return this.dynamicOverrideInferiors;
    }

    public Map<String, String[]> getDynamicAfterSuperiors() {
        return this.dynamicAfterSuperiors;
    }

    public Map<String, String[]> getDynamicAfterInferiors() {
        return this.dynamicAfterInferiors;
    }

    public void setDynamicBeforeSuperiors(String string, String[] stringArray) {
        this.dynamicBeforeSuperiors = this.setDynamic(string, stringArray, this.dynamicBeforeSuperiors);
    }

    public void setDynamicBeforeInferiors(String string, String[] stringArray) {
        this.dynamicBeforeInferiors = this.setDynamic(string, stringArray, this.dynamicBeforeInferiors);
    }

    public void setDynamicOverrideSuperiors(String string, String[] stringArray) {
        this.dynamicOverrideSuperiors = this.setDynamic(string, stringArray, this.dynamicOverrideSuperiors);
    }

    public void setDynamicOverrideInferiors(String string, String[] stringArray) {
        this.dynamicOverrideInferiors = this.setDynamic(string, stringArray, this.dynamicOverrideInferiors);
    }

    public void setDynamicAfterSuperiors(String string, String[] stringArray) {
        this.dynamicAfterSuperiors = this.setDynamic(string, stringArray, this.dynamicAfterSuperiors);
    }

    public void setDynamicAfterInferiors(String string, String[] stringArray) {
        this.dynamicAfterInferiors = this.setDynamic(string, stringArray, this.dynamicAfterInferiors);
    }

    private Map<String, String[]> setDynamic(String string, String[] stringArray, Map<String, String[]> map) {
        if (string == null) {
            throw new IllegalArgumentException("Parameter 'name' may not be null");
        }
        if (stringArray == null) {
            if (map != null) {
                map.remove(string);
            }
            return map;
        }
        if (map == null) {
            map = new HashMap<String, String[]>();
        }
        map.put(string, stringArray);
        return map;
    }

    public String[] getBeforeAddExhaustionSuperiors() {
        return this.beforeAddExhaustionSuperiors;
    }

    public String[] getBeforeAddExhaustionInferiors() {
        return this.beforeAddExhaustionInferiors;
    }

    public String[] getOverrideAddExhaustionSuperiors() {
        return this.overrideAddExhaustionSuperiors;
    }

    public String[] getOverrideAddExhaustionInferiors() {
        return this.overrideAddExhaustionInferiors;
    }

    public String[] getAfterAddExhaustionSuperiors() {
        return this.afterAddExhaustionSuperiors;
    }

    public String[] getAfterAddExhaustionInferiors() {
        return this.afterAddExhaustionInferiors;
    }

    public void setBeforeAddExhaustionSuperiors(String[] stringArray) {
        this.beforeAddExhaustionSuperiors = stringArray;
    }

    public void setBeforeAddExhaustionInferiors(String[] stringArray) {
        this.beforeAddExhaustionInferiors = stringArray;
    }

    public void setOverrideAddExhaustionSuperiors(String[] stringArray) {
        this.overrideAddExhaustionSuperiors = stringArray;
    }

    public void setOverrideAddExhaustionInferiors(String[] stringArray) {
        this.overrideAddExhaustionInferiors = stringArray;
    }

    public void setAfterAddExhaustionSuperiors(String[] stringArray) {
        this.afterAddExhaustionSuperiors = stringArray;
    }

    public void setAfterAddExhaustionInferiors(String[] stringArray) {
        this.afterAddExhaustionInferiors = stringArray;
    }

    public String[] getBeforeAddMovementStatSuperiors() {
        return this.beforeAddMovementStatSuperiors;
    }

    public String[] getBeforeAddMovementStatInferiors() {
        return this.beforeAddMovementStatInferiors;
    }

    public String[] getOverrideAddMovementStatSuperiors() {
        return this.overrideAddMovementStatSuperiors;
    }

    public String[] getOverrideAddMovementStatInferiors() {
        return this.overrideAddMovementStatInferiors;
    }

    public String[] getAfterAddMovementStatSuperiors() {
        return this.afterAddMovementStatSuperiors;
    }

    public String[] getAfterAddMovementStatInferiors() {
        return this.afterAddMovementStatInferiors;
    }

    public void setBeforeAddMovementStatSuperiors(String[] stringArray) {
        this.beforeAddMovementStatSuperiors = stringArray;
    }

    public void setBeforeAddMovementStatInferiors(String[] stringArray) {
        this.beforeAddMovementStatInferiors = stringArray;
    }

    public void setOverrideAddMovementStatSuperiors(String[] stringArray) {
        this.overrideAddMovementStatSuperiors = stringArray;
    }

    public void setOverrideAddMovementStatInferiors(String[] stringArray) {
        this.overrideAddMovementStatInferiors = stringArray;
    }

    public void setAfterAddMovementStatSuperiors(String[] stringArray) {
        this.afterAddMovementStatSuperiors = stringArray;
    }

    public void setAfterAddMovementStatInferiors(String[] stringArray) {
        this.afterAddMovementStatInferiors = stringArray;
    }

    public String[] getBeforeAddStatSuperiors() {
        return this.beforeAddStatSuperiors;
    }

    public String[] getBeforeAddStatInferiors() {
        return this.beforeAddStatInferiors;
    }

    public String[] getOverrideAddStatSuperiors() {
        return this.overrideAddStatSuperiors;
    }

    public String[] getOverrideAddStatInferiors() {
        return this.overrideAddStatInferiors;
    }

    public String[] getAfterAddStatSuperiors() {
        return this.afterAddStatSuperiors;
    }

    public String[] getAfterAddStatInferiors() {
        return this.afterAddStatInferiors;
    }

    public void setBeforeAddStatSuperiors(String[] stringArray) {
        this.beforeAddStatSuperiors = stringArray;
    }

    public void setBeforeAddStatInferiors(String[] stringArray) {
        this.beforeAddStatInferiors = stringArray;
    }

    public void setOverrideAddStatSuperiors(String[] stringArray) {
        this.overrideAddStatSuperiors = stringArray;
    }

    public void setOverrideAddStatInferiors(String[] stringArray) {
        this.overrideAddStatInferiors = stringArray;
    }

    public void setAfterAddStatSuperiors(String[] stringArray) {
        this.afterAddStatSuperiors = stringArray;
    }

    public void setAfterAddStatInferiors(String[] stringArray) {
        this.afterAddStatInferiors = stringArray;
    }

    public String[] getBeforeAttackEntityFromSuperiors() {
        return this.beforeAttackEntityFromSuperiors;
    }

    public String[] getBeforeAttackEntityFromInferiors() {
        return this.beforeAttackEntityFromInferiors;
    }

    public String[] getOverrideAttackEntityFromSuperiors() {
        return this.overrideAttackEntityFromSuperiors;
    }

    public String[] getOverrideAttackEntityFromInferiors() {
        return this.overrideAttackEntityFromInferiors;
    }

    public String[] getAfterAttackEntityFromSuperiors() {
        return this.afterAttackEntityFromSuperiors;
    }

    public String[] getAfterAttackEntityFromInferiors() {
        return this.afterAttackEntityFromInferiors;
    }

    public void setBeforeAttackEntityFromSuperiors(String[] stringArray) {
        this.beforeAttackEntityFromSuperiors = stringArray;
    }

    public void setBeforeAttackEntityFromInferiors(String[] stringArray) {
        this.beforeAttackEntityFromInferiors = stringArray;
    }

    public void setOverrideAttackEntityFromSuperiors(String[] stringArray) {
        this.overrideAttackEntityFromSuperiors = stringArray;
    }

    public void setOverrideAttackEntityFromInferiors(String[] stringArray) {
        this.overrideAttackEntityFromInferiors = stringArray;
    }

    public void setAfterAttackEntityFromSuperiors(String[] stringArray) {
        this.afterAttackEntityFromSuperiors = stringArray;
    }

    public void setAfterAttackEntityFromInferiors(String[] stringArray) {
        this.afterAttackEntityFromInferiors = stringArray;
    }

    public String[] getBeforeAttackTargetEntityWithCurrentItemSuperiors() {
        return this.beforeAttackTargetEntityWithCurrentItemSuperiors;
    }

    public String[] getBeforeAttackTargetEntityWithCurrentItemInferiors() {
        return this.beforeAttackTargetEntityWithCurrentItemInferiors;
    }

    public String[] getOverrideAttackTargetEntityWithCurrentItemSuperiors() {
        return this.overrideAttackTargetEntityWithCurrentItemSuperiors;
    }

    public String[] getOverrideAttackTargetEntityWithCurrentItemInferiors() {
        return this.overrideAttackTargetEntityWithCurrentItemInferiors;
    }

    public String[] getAfterAttackTargetEntityWithCurrentItemSuperiors() {
        return this.afterAttackTargetEntityWithCurrentItemSuperiors;
    }

    public String[] getAfterAttackTargetEntityWithCurrentItemInferiors() {
        return this.afterAttackTargetEntityWithCurrentItemInferiors;
    }

    public void setBeforeAttackTargetEntityWithCurrentItemSuperiors(String[] stringArray) {
        this.beforeAttackTargetEntityWithCurrentItemSuperiors = stringArray;
    }

    public void setBeforeAttackTargetEntityWithCurrentItemInferiors(String[] stringArray) {
        this.beforeAttackTargetEntityWithCurrentItemInferiors = stringArray;
    }

    public void setOverrideAttackTargetEntityWithCurrentItemSuperiors(String[] stringArray) {
        this.overrideAttackTargetEntityWithCurrentItemSuperiors = stringArray;
    }

    public void setOverrideAttackTargetEntityWithCurrentItemInferiors(String[] stringArray) {
        this.overrideAttackTargetEntityWithCurrentItemInferiors = stringArray;
    }

    public void setAfterAttackTargetEntityWithCurrentItemSuperiors(String[] stringArray) {
        this.afterAttackTargetEntityWithCurrentItemSuperiors = stringArray;
    }

    public void setAfterAttackTargetEntityWithCurrentItemInferiors(String[] stringArray) {
        this.afterAttackTargetEntityWithCurrentItemInferiors = stringArray;
    }

    public String[] getBeforeCanBreatheUnderwaterSuperiors() {
        return this.beforeCanBreatheUnderwaterSuperiors;
    }

    public String[] getBeforeCanBreatheUnderwaterInferiors() {
        return this.beforeCanBreatheUnderwaterInferiors;
    }

    public String[] getOverrideCanBreatheUnderwaterSuperiors() {
        return this.overrideCanBreatheUnderwaterSuperiors;
    }

    public String[] getOverrideCanBreatheUnderwaterInferiors() {
        return this.overrideCanBreatheUnderwaterInferiors;
    }

    public String[] getAfterCanBreatheUnderwaterSuperiors() {
        return this.afterCanBreatheUnderwaterSuperiors;
    }

    public String[] getAfterCanBreatheUnderwaterInferiors() {
        return this.afterCanBreatheUnderwaterInferiors;
    }

    public void setBeforeCanBreatheUnderwaterSuperiors(String[] stringArray) {
        this.beforeCanBreatheUnderwaterSuperiors = stringArray;
    }

    public void setBeforeCanBreatheUnderwaterInferiors(String[] stringArray) {
        this.beforeCanBreatheUnderwaterInferiors = stringArray;
    }

    public void setOverrideCanBreatheUnderwaterSuperiors(String[] stringArray) {
        this.overrideCanBreatheUnderwaterSuperiors = stringArray;
    }

    public void setOverrideCanBreatheUnderwaterInferiors(String[] stringArray) {
        this.overrideCanBreatheUnderwaterInferiors = stringArray;
    }

    public void setAfterCanBreatheUnderwaterSuperiors(String[] stringArray) {
        this.afterCanBreatheUnderwaterSuperiors = stringArray;
    }

    public void setAfterCanBreatheUnderwaterInferiors(String[] stringArray) {
        this.afterCanBreatheUnderwaterInferiors = stringArray;
    }

    public String[] getBeforeCanHarvestBlockSuperiors() {
        return this.beforeCanHarvestBlockSuperiors;
    }

    public String[] getBeforeCanHarvestBlockInferiors() {
        return this.beforeCanHarvestBlockInferiors;
    }

    public String[] getOverrideCanHarvestBlockSuperiors() {
        return this.overrideCanHarvestBlockSuperiors;
    }

    public String[] getOverrideCanHarvestBlockInferiors() {
        return this.overrideCanHarvestBlockInferiors;
    }

    public String[] getAfterCanHarvestBlockSuperiors() {
        return this.afterCanHarvestBlockSuperiors;
    }

    public String[] getAfterCanHarvestBlockInferiors() {
        return this.afterCanHarvestBlockInferiors;
    }

    public void setBeforeCanHarvestBlockSuperiors(String[] stringArray) {
        this.beforeCanHarvestBlockSuperiors = stringArray;
    }

    public void setBeforeCanHarvestBlockInferiors(String[] stringArray) {
        this.beforeCanHarvestBlockInferiors = stringArray;
    }

    public void setOverrideCanHarvestBlockSuperiors(String[] stringArray) {
        this.overrideCanHarvestBlockSuperiors = stringArray;
    }

    public void setOverrideCanHarvestBlockInferiors(String[] stringArray) {
        this.overrideCanHarvestBlockInferiors = stringArray;
    }

    public void setAfterCanHarvestBlockSuperiors(String[] stringArray) {
        this.afterCanHarvestBlockSuperiors = stringArray;
    }

    public void setAfterCanHarvestBlockInferiors(String[] stringArray) {
        this.afterCanHarvestBlockInferiors = stringArray;
    }

    public String[] getBeforeCanPlayerEditSuperiors() {
        return this.beforeCanPlayerEditSuperiors;
    }

    public String[] getBeforeCanPlayerEditInferiors() {
        return this.beforeCanPlayerEditInferiors;
    }

    public String[] getOverrideCanPlayerEditSuperiors() {
        return this.overrideCanPlayerEditSuperiors;
    }

    public String[] getOverrideCanPlayerEditInferiors() {
        return this.overrideCanPlayerEditInferiors;
    }

    public String[] getAfterCanPlayerEditSuperiors() {
        return this.afterCanPlayerEditSuperiors;
    }

    public String[] getAfterCanPlayerEditInferiors() {
        return this.afterCanPlayerEditInferiors;
    }

    public void setBeforeCanPlayerEditSuperiors(String[] stringArray) {
        this.beforeCanPlayerEditSuperiors = stringArray;
    }

    public void setBeforeCanPlayerEditInferiors(String[] stringArray) {
        this.beforeCanPlayerEditInferiors = stringArray;
    }

    public void setOverrideCanPlayerEditSuperiors(String[] stringArray) {
        this.overrideCanPlayerEditSuperiors = stringArray;
    }

    public void setOverrideCanPlayerEditInferiors(String[] stringArray) {
        this.overrideCanPlayerEditInferiors = stringArray;
    }

    public void setAfterCanPlayerEditSuperiors(String[] stringArray) {
        this.afterCanPlayerEditSuperiors = stringArray;
    }

    public void setAfterCanPlayerEditInferiors(String[] stringArray) {
        this.afterCanPlayerEditInferiors = stringArray;
    }

    public String[] getBeforeCanTriggerWalkingSuperiors() {
        return this.beforeCanTriggerWalkingSuperiors;
    }

    public String[] getBeforeCanTriggerWalkingInferiors() {
        return this.beforeCanTriggerWalkingInferiors;
    }

    public String[] getOverrideCanTriggerWalkingSuperiors() {
        return this.overrideCanTriggerWalkingSuperiors;
    }

    public String[] getOverrideCanTriggerWalkingInferiors() {
        return this.overrideCanTriggerWalkingInferiors;
    }

    public String[] getAfterCanTriggerWalkingSuperiors() {
        return this.afterCanTriggerWalkingSuperiors;
    }

    public String[] getAfterCanTriggerWalkingInferiors() {
        return this.afterCanTriggerWalkingInferiors;
    }

    public void setBeforeCanTriggerWalkingSuperiors(String[] stringArray) {
        this.beforeCanTriggerWalkingSuperiors = stringArray;
    }

    public void setBeforeCanTriggerWalkingInferiors(String[] stringArray) {
        this.beforeCanTriggerWalkingInferiors = stringArray;
    }

    public void setOverrideCanTriggerWalkingSuperiors(String[] stringArray) {
        this.overrideCanTriggerWalkingSuperiors = stringArray;
    }

    public void setOverrideCanTriggerWalkingInferiors(String[] stringArray) {
        this.overrideCanTriggerWalkingInferiors = stringArray;
    }

    public void setAfterCanTriggerWalkingSuperiors(String[] stringArray) {
        this.afterCanTriggerWalkingSuperiors = stringArray;
    }

    public void setAfterCanTriggerWalkingInferiors(String[] stringArray) {
        this.afterCanTriggerWalkingInferiors = stringArray;
    }

    public String[] getBeforeCloseScreenSuperiors() {
        return this.beforeCloseScreenSuperiors;
    }

    public String[] getBeforeCloseScreenInferiors() {
        return this.beforeCloseScreenInferiors;
    }

    public String[] getOverrideCloseScreenSuperiors() {
        return this.overrideCloseScreenSuperiors;
    }

    public String[] getOverrideCloseScreenInferiors() {
        return this.overrideCloseScreenInferiors;
    }

    public String[] getAfterCloseScreenSuperiors() {
        return this.afterCloseScreenSuperiors;
    }

    public String[] getAfterCloseScreenInferiors() {
        return this.afterCloseScreenInferiors;
    }

    public void setBeforeCloseScreenSuperiors(String[] stringArray) {
        this.beforeCloseScreenSuperiors = stringArray;
    }

    public void setBeforeCloseScreenInferiors(String[] stringArray) {
        this.beforeCloseScreenInferiors = stringArray;
    }

    public void setOverrideCloseScreenSuperiors(String[] stringArray) {
        this.overrideCloseScreenSuperiors = stringArray;
    }

    public void setOverrideCloseScreenInferiors(String[] stringArray) {
        this.overrideCloseScreenInferiors = stringArray;
    }

    public void setAfterCloseScreenSuperiors(String[] stringArray) {
        this.afterCloseScreenSuperiors = stringArray;
    }

    public void setAfterCloseScreenInferiors(String[] stringArray) {
        this.afterCloseScreenInferiors = stringArray;
    }

    public String[] getBeforeDamageEntitySuperiors() {
        return this.beforeDamageEntitySuperiors;
    }

    public String[] getBeforeDamageEntityInferiors() {
        return this.beforeDamageEntityInferiors;
    }

    public String[] getOverrideDamageEntitySuperiors() {
        return this.overrideDamageEntitySuperiors;
    }

    public String[] getOverrideDamageEntityInferiors() {
        return this.overrideDamageEntityInferiors;
    }

    public String[] getAfterDamageEntitySuperiors() {
        return this.afterDamageEntitySuperiors;
    }

    public String[] getAfterDamageEntityInferiors() {
        return this.afterDamageEntityInferiors;
    }

    public void setBeforeDamageEntitySuperiors(String[] stringArray) {
        this.beforeDamageEntitySuperiors = stringArray;
    }

    public void setBeforeDamageEntityInferiors(String[] stringArray) {
        this.beforeDamageEntityInferiors = stringArray;
    }

    public void setOverrideDamageEntitySuperiors(String[] stringArray) {
        this.overrideDamageEntitySuperiors = stringArray;
    }

    public void setOverrideDamageEntityInferiors(String[] stringArray) {
        this.overrideDamageEntityInferiors = stringArray;
    }

    public void setAfterDamageEntitySuperiors(String[] stringArray) {
        this.afterDamageEntitySuperiors = stringArray;
    }

    public void setAfterDamageEntityInferiors(String[] stringArray) {
        this.afterDamageEntityInferiors = stringArray;
    }

    public String[] getBeforeDisplayGUIBrewingStandSuperiors() {
        return this.beforeDisplayGUIBrewingStandSuperiors;
    }

    public String[] getBeforeDisplayGUIBrewingStandInferiors() {
        return this.beforeDisplayGUIBrewingStandInferiors;
    }

    public String[] getOverrideDisplayGUIBrewingStandSuperiors() {
        return this.overrideDisplayGUIBrewingStandSuperiors;
    }

    public String[] getOverrideDisplayGUIBrewingStandInferiors() {
        return this.overrideDisplayGUIBrewingStandInferiors;
    }

    public String[] getAfterDisplayGUIBrewingStandSuperiors() {
        return this.afterDisplayGUIBrewingStandSuperiors;
    }

    public String[] getAfterDisplayGUIBrewingStandInferiors() {
        return this.afterDisplayGUIBrewingStandInferiors;
    }

    public void setBeforeDisplayGUIBrewingStandSuperiors(String[] stringArray) {
        this.beforeDisplayGUIBrewingStandSuperiors = stringArray;
    }

    public void setBeforeDisplayGUIBrewingStandInferiors(String[] stringArray) {
        this.beforeDisplayGUIBrewingStandInferiors = stringArray;
    }

    public void setOverrideDisplayGUIBrewingStandSuperiors(String[] stringArray) {
        this.overrideDisplayGUIBrewingStandSuperiors = stringArray;
    }

    public void setOverrideDisplayGUIBrewingStandInferiors(String[] stringArray) {
        this.overrideDisplayGUIBrewingStandInferiors = stringArray;
    }

    public void setAfterDisplayGUIBrewingStandSuperiors(String[] stringArray) {
        this.afterDisplayGUIBrewingStandSuperiors = stringArray;
    }

    public void setAfterDisplayGUIBrewingStandInferiors(String[] stringArray) {
        this.afterDisplayGUIBrewingStandInferiors = stringArray;
    }

    public String[] getBeforeDisplayGUIChestSuperiors() {
        return this.beforeDisplayGUIChestSuperiors;
    }

    public String[] getBeforeDisplayGUIChestInferiors() {
        return this.beforeDisplayGUIChestInferiors;
    }

    public String[] getOverrideDisplayGUIChestSuperiors() {
        return this.overrideDisplayGUIChestSuperiors;
    }

    public String[] getOverrideDisplayGUIChestInferiors() {
        return this.overrideDisplayGUIChestInferiors;
    }

    public String[] getAfterDisplayGUIChestSuperiors() {
        return this.afterDisplayGUIChestSuperiors;
    }

    public String[] getAfterDisplayGUIChestInferiors() {
        return this.afterDisplayGUIChestInferiors;
    }

    public void setBeforeDisplayGUIChestSuperiors(String[] stringArray) {
        this.beforeDisplayGUIChestSuperiors = stringArray;
    }

    public void setBeforeDisplayGUIChestInferiors(String[] stringArray) {
        this.beforeDisplayGUIChestInferiors = stringArray;
    }

    public void setOverrideDisplayGUIChestSuperiors(String[] stringArray) {
        this.overrideDisplayGUIChestSuperiors = stringArray;
    }

    public void setOverrideDisplayGUIChestInferiors(String[] stringArray) {
        this.overrideDisplayGUIChestInferiors = stringArray;
    }

    public void setAfterDisplayGUIChestSuperiors(String[] stringArray) {
        this.afterDisplayGUIChestSuperiors = stringArray;
    }

    public void setAfterDisplayGUIChestInferiors(String[] stringArray) {
        this.afterDisplayGUIChestInferiors = stringArray;
    }

    public String[] getBeforeDisplayGUIDispenserSuperiors() {
        return this.beforeDisplayGUIDispenserSuperiors;
    }

    public String[] getBeforeDisplayGUIDispenserInferiors() {
        return this.beforeDisplayGUIDispenserInferiors;
    }

    public String[] getOverrideDisplayGUIDispenserSuperiors() {
        return this.overrideDisplayGUIDispenserSuperiors;
    }

    public String[] getOverrideDisplayGUIDispenserInferiors() {
        return this.overrideDisplayGUIDispenserInferiors;
    }

    public String[] getAfterDisplayGUIDispenserSuperiors() {
        return this.afterDisplayGUIDispenserSuperiors;
    }

    public String[] getAfterDisplayGUIDispenserInferiors() {
        return this.afterDisplayGUIDispenserInferiors;
    }

    public void setBeforeDisplayGUIDispenserSuperiors(String[] stringArray) {
        this.beforeDisplayGUIDispenserSuperiors = stringArray;
    }

    public void setBeforeDisplayGUIDispenserInferiors(String[] stringArray) {
        this.beforeDisplayGUIDispenserInferiors = stringArray;
    }

    public void setOverrideDisplayGUIDispenserSuperiors(String[] stringArray) {
        this.overrideDisplayGUIDispenserSuperiors = stringArray;
    }

    public void setOverrideDisplayGUIDispenserInferiors(String[] stringArray) {
        this.overrideDisplayGUIDispenserInferiors = stringArray;
    }

    public void setAfterDisplayGUIDispenserSuperiors(String[] stringArray) {
        this.afterDisplayGUIDispenserSuperiors = stringArray;
    }

    public void setAfterDisplayGUIDispenserInferiors(String[] stringArray) {
        this.afterDisplayGUIDispenserInferiors = stringArray;
    }

    public String[] getBeforeDisplayGUIEditSignSuperiors() {
        return this.beforeDisplayGUIEditSignSuperiors;
    }

    public String[] getBeforeDisplayGUIEditSignInferiors() {
        return this.beforeDisplayGUIEditSignInferiors;
    }

    public String[] getOverrideDisplayGUIEditSignSuperiors() {
        return this.overrideDisplayGUIEditSignSuperiors;
    }

    public String[] getOverrideDisplayGUIEditSignInferiors() {
        return this.overrideDisplayGUIEditSignInferiors;
    }

    public String[] getAfterDisplayGUIEditSignSuperiors() {
        return this.afterDisplayGUIEditSignSuperiors;
    }

    public String[] getAfterDisplayGUIEditSignInferiors() {
        return this.afterDisplayGUIEditSignInferiors;
    }

    public void setBeforeDisplayGUIEditSignSuperiors(String[] stringArray) {
        this.beforeDisplayGUIEditSignSuperiors = stringArray;
    }

    public void setBeforeDisplayGUIEditSignInferiors(String[] stringArray) {
        this.beforeDisplayGUIEditSignInferiors = stringArray;
    }

    public void setOverrideDisplayGUIEditSignSuperiors(String[] stringArray) {
        this.overrideDisplayGUIEditSignSuperiors = stringArray;
    }

    public void setOverrideDisplayGUIEditSignInferiors(String[] stringArray) {
        this.overrideDisplayGUIEditSignInferiors = stringArray;
    }

    public void setAfterDisplayGUIEditSignSuperiors(String[] stringArray) {
        this.afterDisplayGUIEditSignSuperiors = stringArray;
    }

    public void setAfterDisplayGUIEditSignInferiors(String[] stringArray) {
        this.afterDisplayGUIEditSignInferiors = stringArray;
    }

    public String[] getBeforeDisplayGUIEnchantmentSuperiors() {
        return this.beforeDisplayGUIEnchantmentSuperiors;
    }

    public String[] getBeforeDisplayGUIEnchantmentInferiors() {
        return this.beforeDisplayGUIEnchantmentInferiors;
    }

    public String[] getOverrideDisplayGUIEnchantmentSuperiors() {
        return this.overrideDisplayGUIEnchantmentSuperiors;
    }

    public String[] getOverrideDisplayGUIEnchantmentInferiors() {
        return this.overrideDisplayGUIEnchantmentInferiors;
    }

    public String[] getAfterDisplayGUIEnchantmentSuperiors() {
        return this.afterDisplayGUIEnchantmentSuperiors;
    }

    public String[] getAfterDisplayGUIEnchantmentInferiors() {
        return this.afterDisplayGUIEnchantmentInferiors;
    }

    public void setBeforeDisplayGUIEnchantmentSuperiors(String[] stringArray) {
        this.beforeDisplayGUIEnchantmentSuperiors = stringArray;
    }

    public void setBeforeDisplayGUIEnchantmentInferiors(String[] stringArray) {
        this.beforeDisplayGUIEnchantmentInferiors = stringArray;
    }

    public void setOverrideDisplayGUIEnchantmentSuperiors(String[] stringArray) {
        this.overrideDisplayGUIEnchantmentSuperiors = stringArray;
    }

    public void setOverrideDisplayGUIEnchantmentInferiors(String[] stringArray) {
        this.overrideDisplayGUIEnchantmentInferiors = stringArray;
    }

    public void setAfterDisplayGUIEnchantmentSuperiors(String[] stringArray) {
        this.afterDisplayGUIEnchantmentSuperiors = stringArray;
    }

    public void setAfterDisplayGUIEnchantmentInferiors(String[] stringArray) {
        this.afterDisplayGUIEnchantmentInferiors = stringArray;
    }

    public String[] getBeforeDisplayGUIFurnaceSuperiors() {
        return this.beforeDisplayGUIFurnaceSuperiors;
    }

    public String[] getBeforeDisplayGUIFurnaceInferiors() {
        return this.beforeDisplayGUIFurnaceInferiors;
    }

    public String[] getOverrideDisplayGUIFurnaceSuperiors() {
        return this.overrideDisplayGUIFurnaceSuperiors;
    }

    public String[] getOverrideDisplayGUIFurnaceInferiors() {
        return this.overrideDisplayGUIFurnaceInferiors;
    }

    public String[] getAfterDisplayGUIFurnaceSuperiors() {
        return this.afterDisplayGUIFurnaceSuperiors;
    }

    public String[] getAfterDisplayGUIFurnaceInferiors() {
        return this.afterDisplayGUIFurnaceInferiors;
    }

    public void setBeforeDisplayGUIFurnaceSuperiors(String[] stringArray) {
        this.beforeDisplayGUIFurnaceSuperiors = stringArray;
    }

    public void setBeforeDisplayGUIFurnaceInferiors(String[] stringArray) {
        this.beforeDisplayGUIFurnaceInferiors = stringArray;
    }

    public void setOverrideDisplayGUIFurnaceSuperiors(String[] stringArray) {
        this.overrideDisplayGUIFurnaceSuperiors = stringArray;
    }

    public void setOverrideDisplayGUIFurnaceInferiors(String[] stringArray) {
        this.overrideDisplayGUIFurnaceInferiors = stringArray;
    }

    public void setAfterDisplayGUIFurnaceSuperiors(String[] stringArray) {
        this.afterDisplayGUIFurnaceSuperiors = stringArray;
    }

    public void setAfterDisplayGUIFurnaceInferiors(String[] stringArray) {
        this.afterDisplayGUIFurnaceInferiors = stringArray;
    }

    public String[] getBeforeDisplayGUIWorkbenchSuperiors() {
        return this.beforeDisplayGUIWorkbenchSuperiors;
    }

    public String[] getBeforeDisplayGUIWorkbenchInferiors() {
        return this.beforeDisplayGUIWorkbenchInferiors;
    }

    public String[] getOverrideDisplayGUIWorkbenchSuperiors() {
        return this.overrideDisplayGUIWorkbenchSuperiors;
    }

    public String[] getOverrideDisplayGUIWorkbenchInferiors() {
        return this.overrideDisplayGUIWorkbenchInferiors;
    }

    public String[] getAfterDisplayGUIWorkbenchSuperiors() {
        return this.afterDisplayGUIWorkbenchSuperiors;
    }

    public String[] getAfterDisplayGUIWorkbenchInferiors() {
        return this.afterDisplayGUIWorkbenchInferiors;
    }

    public void setBeforeDisplayGUIWorkbenchSuperiors(String[] stringArray) {
        this.beforeDisplayGUIWorkbenchSuperiors = stringArray;
    }

    public void setBeforeDisplayGUIWorkbenchInferiors(String[] stringArray) {
        this.beforeDisplayGUIWorkbenchInferiors = stringArray;
    }

    public void setOverrideDisplayGUIWorkbenchSuperiors(String[] stringArray) {
        this.overrideDisplayGUIWorkbenchSuperiors = stringArray;
    }

    public void setOverrideDisplayGUIWorkbenchInferiors(String[] stringArray) {
        this.overrideDisplayGUIWorkbenchInferiors = stringArray;
    }

    public void setAfterDisplayGUIWorkbenchSuperiors(String[] stringArray) {
        this.afterDisplayGUIWorkbenchSuperiors = stringArray;
    }

    public void setAfterDisplayGUIWorkbenchInferiors(String[] stringArray) {
        this.afterDisplayGUIWorkbenchInferiors = stringArray;
    }

    public String[] getBeforeDropOneItemSuperiors() {
        return this.beforeDropOneItemSuperiors;
    }

    public String[] getBeforeDropOneItemInferiors() {
        return this.beforeDropOneItemInferiors;
    }

    public String[] getOverrideDropOneItemSuperiors() {
        return this.overrideDropOneItemSuperiors;
    }

    public String[] getOverrideDropOneItemInferiors() {
        return this.overrideDropOneItemInferiors;
    }

    public String[] getAfterDropOneItemSuperiors() {
        return this.afterDropOneItemSuperiors;
    }

    public String[] getAfterDropOneItemInferiors() {
        return this.afterDropOneItemInferiors;
    }

    public void setBeforeDropOneItemSuperiors(String[] stringArray) {
        this.beforeDropOneItemSuperiors = stringArray;
    }

    public void setBeforeDropOneItemInferiors(String[] stringArray) {
        this.beforeDropOneItemInferiors = stringArray;
    }

    public void setOverrideDropOneItemSuperiors(String[] stringArray) {
        this.overrideDropOneItemSuperiors = stringArray;
    }

    public void setOverrideDropOneItemInferiors(String[] stringArray) {
        this.overrideDropOneItemInferiors = stringArray;
    }

    public void setAfterDropOneItemSuperiors(String[] stringArray) {
        this.afterDropOneItemSuperiors = stringArray;
    }

    public void setAfterDropOneItemInferiors(String[] stringArray) {
        this.afterDropOneItemInferiors = stringArray;
    }

    public String[] getBeforeDropPlayerItemSuperiors() {
        return this.beforeDropPlayerItemSuperiors;
    }

    public String[] getBeforeDropPlayerItemInferiors() {
        return this.beforeDropPlayerItemInferiors;
    }

    public String[] getOverrideDropPlayerItemSuperiors() {
        return this.overrideDropPlayerItemSuperiors;
    }

    public String[] getOverrideDropPlayerItemInferiors() {
        return this.overrideDropPlayerItemInferiors;
    }

    public String[] getAfterDropPlayerItemSuperiors() {
        return this.afterDropPlayerItemSuperiors;
    }

    public String[] getAfterDropPlayerItemInferiors() {
        return this.afterDropPlayerItemInferiors;
    }

    public void setBeforeDropPlayerItemSuperiors(String[] stringArray) {
        this.beforeDropPlayerItemSuperiors = stringArray;
    }

    public void setBeforeDropPlayerItemInferiors(String[] stringArray) {
        this.beforeDropPlayerItemInferiors = stringArray;
    }

    public void setOverrideDropPlayerItemSuperiors(String[] stringArray) {
        this.overrideDropPlayerItemSuperiors = stringArray;
    }

    public void setOverrideDropPlayerItemInferiors(String[] stringArray) {
        this.overrideDropPlayerItemInferiors = stringArray;
    }

    public void setAfterDropPlayerItemSuperiors(String[] stringArray) {
        this.afterDropPlayerItemSuperiors = stringArray;
    }

    public void setAfterDropPlayerItemInferiors(String[] stringArray) {
        this.afterDropPlayerItemInferiors = stringArray;
    }

    public String[] getBeforeDropPlayerItemWithRandomChoiceSuperiors() {
        return this.beforeDropPlayerItemWithRandomChoiceSuperiors;
    }

    public String[] getBeforeDropPlayerItemWithRandomChoiceInferiors() {
        return this.beforeDropPlayerItemWithRandomChoiceInferiors;
    }

    public String[] getOverrideDropPlayerItemWithRandomChoiceSuperiors() {
        return this.overrideDropPlayerItemWithRandomChoiceSuperiors;
    }

    public String[] getOverrideDropPlayerItemWithRandomChoiceInferiors() {
        return this.overrideDropPlayerItemWithRandomChoiceInferiors;
    }

    public String[] getAfterDropPlayerItemWithRandomChoiceSuperiors() {
        return this.afterDropPlayerItemWithRandomChoiceSuperiors;
    }

    public String[] getAfterDropPlayerItemWithRandomChoiceInferiors() {
        return this.afterDropPlayerItemWithRandomChoiceInferiors;
    }

    public void setBeforeDropPlayerItemWithRandomChoiceSuperiors(String[] stringArray) {
        this.beforeDropPlayerItemWithRandomChoiceSuperiors = stringArray;
    }

    public void setBeforeDropPlayerItemWithRandomChoiceInferiors(String[] stringArray) {
        this.beforeDropPlayerItemWithRandomChoiceInferiors = stringArray;
    }

    public void setOverrideDropPlayerItemWithRandomChoiceSuperiors(String[] stringArray) {
        this.overrideDropPlayerItemWithRandomChoiceSuperiors = stringArray;
    }

    public void setOverrideDropPlayerItemWithRandomChoiceInferiors(String[] stringArray) {
        this.overrideDropPlayerItemWithRandomChoiceInferiors = stringArray;
    }

    public void setAfterDropPlayerItemWithRandomChoiceSuperiors(String[] stringArray) {
        this.afterDropPlayerItemWithRandomChoiceSuperiors = stringArray;
    }

    public void setAfterDropPlayerItemWithRandomChoiceInferiors(String[] stringArray) {
        this.afterDropPlayerItemWithRandomChoiceInferiors = stringArray;
    }

    public String[] getBeforeFallSuperiors() {
        return this.beforeFallSuperiors;
    }

    public String[] getBeforeFallInferiors() {
        return this.beforeFallInferiors;
    }

    public String[] getOverrideFallSuperiors() {
        return this.overrideFallSuperiors;
    }

    public String[] getOverrideFallInferiors() {
        return this.overrideFallInferiors;
    }

    public String[] getAfterFallSuperiors() {
        return this.afterFallSuperiors;
    }

    public String[] getAfterFallInferiors() {
        return this.afterFallInferiors;
    }

    public void setBeforeFallSuperiors(String[] stringArray) {
        this.beforeFallSuperiors = stringArray;
    }

    public void setBeforeFallInferiors(String[] stringArray) {
        this.beforeFallInferiors = stringArray;
    }

    public void setOverrideFallSuperiors(String[] stringArray) {
        this.overrideFallSuperiors = stringArray;
    }

    public void setOverrideFallInferiors(String[] stringArray) {
        this.overrideFallInferiors = stringArray;
    }

    public void setAfterFallSuperiors(String[] stringArray) {
        this.afterFallSuperiors = stringArray;
    }

    public void setAfterFallInferiors(String[] stringArray) {
        this.afterFallInferiors = stringArray;
    }

    public String[] getBeforeGetBrightnessSuperiors() {
        return this.beforeGetBrightnessSuperiors;
    }

    public String[] getBeforeGetBrightnessInferiors() {
        return this.beforeGetBrightnessInferiors;
    }

    public String[] getOverrideGetBrightnessSuperiors() {
        return this.overrideGetBrightnessSuperiors;
    }

    public String[] getOverrideGetBrightnessInferiors() {
        return this.overrideGetBrightnessInferiors;
    }

    public String[] getAfterGetBrightnessSuperiors() {
        return this.afterGetBrightnessSuperiors;
    }

    public String[] getAfterGetBrightnessInferiors() {
        return this.afterGetBrightnessInferiors;
    }

    public void setBeforeGetBrightnessSuperiors(String[] stringArray) {
        this.beforeGetBrightnessSuperiors = stringArray;
    }

    public void setBeforeGetBrightnessInferiors(String[] stringArray) {
        this.beforeGetBrightnessInferiors = stringArray;
    }

    public void setOverrideGetBrightnessSuperiors(String[] stringArray) {
        this.overrideGetBrightnessSuperiors = stringArray;
    }

    public void setOverrideGetBrightnessInferiors(String[] stringArray) {
        this.overrideGetBrightnessInferiors = stringArray;
    }

    public void setAfterGetBrightnessSuperiors(String[] stringArray) {
        this.afterGetBrightnessSuperiors = stringArray;
    }

    public void setAfterGetBrightnessInferiors(String[] stringArray) {
        this.afterGetBrightnessInferiors = stringArray;
    }

    public String[] getBeforeGetBrightnessForRenderSuperiors() {
        return this.beforeGetBrightnessForRenderSuperiors;
    }

    public String[] getBeforeGetBrightnessForRenderInferiors() {
        return this.beforeGetBrightnessForRenderInferiors;
    }

    public String[] getOverrideGetBrightnessForRenderSuperiors() {
        return this.overrideGetBrightnessForRenderSuperiors;
    }

    public String[] getOverrideGetBrightnessForRenderInferiors() {
        return this.overrideGetBrightnessForRenderInferiors;
    }

    public String[] getAfterGetBrightnessForRenderSuperiors() {
        return this.afterGetBrightnessForRenderSuperiors;
    }

    public String[] getAfterGetBrightnessForRenderInferiors() {
        return this.afterGetBrightnessForRenderInferiors;
    }

    public void setBeforeGetBrightnessForRenderSuperiors(String[] stringArray) {
        this.beforeGetBrightnessForRenderSuperiors = stringArray;
    }

    public void setBeforeGetBrightnessForRenderInferiors(String[] stringArray) {
        this.beforeGetBrightnessForRenderInferiors = stringArray;
    }

    public void setOverrideGetBrightnessForRenderSuperiors(String[] stringArray) {
        this.overrideGetBrightnessForRenderSuperiors = stringArray;
    }

    public void setOverrideGetBrightnessForRenderInferiors(String[] stringArray) {
        this.overrideGetBrightnessForRenderInferiors = stringArray;
    }

    public void setAfterGetBrightnessForRenderSuperiors(String[] stringArray) {
        this.afterGetBrightnessForRenderSuperiors = stringArray;
    }

    public void setAfterGetBrightnessForRenderInferiors(String[] stringArray) {
        this.afterGetBrightnessForRenderInferiors = stringArray;
    }

    public String[] getBeforeGetCurrentPlayerStrVsBlockSuperiors() {
        return this.beforeGetCurrentPlayerStrVsBlockSuperiors;
    }

    public String[] getBeforeGetCurrentPlayerStrVsBlockInferiors() {
        return this.beforeGetCurrentPlayerStrVsBlockInferiors;
    }

    public String[] getOverrideGetCurrentPlayerStrVsBlockSuperiors() {
        return this.overrideGetCurrentPlayerStrVsBlockSuperiors;
    }

    public String[] getOverrideGetCurrentPlayerStrVsBlockInferiors() {
        return this.overrideGetCurrentPlayerStrVsBlockInferiors;
    }

    public String[] getAfterGetCurrentPlayerStrVsBlockSuperiors() {
        return this.afterGetCurrentPlayerStrVsBlockSuperiors;
    }

    public String[] getAfterGetCurrentPlayerStrVsBlockInferiors() {
        return this.afterGetCurrentPlayerStrVsBlockInferiors;
    }

    public void setBeforeGetCurrentPlayerStrVsBlockSuperiors(String[] stringArray) {
        this.beforeGetCurrentPlayerStrVsBlockSuperiors = stringArray;
    }

    public void setBeforeGetCurrentPlayerStrVsBlockInferiors(String[] stringArray) {
        this.beforeGetCurrentPlayerStrVsBlockInferiors = stringArray;
    }

    public void setOverrideGetCurrentPlayerStrVsBlockSuperiors(String[] stringArray) {
        this.overrideGetCurrentPlayerStrVsBlockSuperiors = stringArray;
    }

    public void setOverrideGetCurrentPlayerStrVsBlockInferiors(String[] stringArray) {
        this.overrideGetCurrentPlayerStrVsBlockInferiors = stringArray;
    }

    public void setAfterGetCurrentPlayerStrVsBlockSuperiors(String[] stringArray) {
        this.afterGetCurrentPlayerStrVsBlockSuperiors = stringArray;
    }

    public void setAfterGetCurrentPlayerStrVsBlockInferiors(String[] stringArray) {
        this.afterGetCurrentPlayerStrVsBlockInferiors = stringArray;
    }

    public String[] getBeforeGetCurrentPlayerStrVsBlockForgeSuperiors() {
        return this.beforeGetCurrentPlayerStrVsBlockForgeSuperiors;
    }

    public String[] getBeforeGetCurrentPlayerStrVsBlockForgeInferiors() {
        return this.beforeGetCurrentPlayerStrVsBlockForgeInferiors;
    }

    public String[] getOverrideGetCurrentPlayerStrVsBlockForgeSuperiors() {
        return this.overrideGetCurrentPlayerStrVsBlockForgeSuperiors;
    }

    public String[] getOverrideGetCurrentPlayerStrVsBlockForgeInferiors() {
        return this.overrideGetCurrentPlayerStrVsBlockForgeInferiors;
    }

    public String[] getAfterGetCurrentPlayerStrVsBlockForgeSuperiors() {
        return this.afterGetCurrentPlayerStrVsBlockForgeSuperiors;
    }

    public String[] getAfterGetCurrentPlayerStrVsBlockForgeInferiors() {
        return this.afterGetCurrentPlayerStrVsBlockForgeInferiors;
    }

    public void setBeforeGetCurrentPlayerStrVsBlockForgeSuperiors(String[] stringArray) {
        this.beforeGetCurrentPlayerStrVsBlockForgeSuperiors = stringArray;
    }

    public void setBeforeGetCurrentPlayerStrVsBlockForgeInferiors(String[] stringArray) {
        this.beforeGetCurrentPlayerStrVsBlockForgeInferiors = stringArray;
    }

    public void setOverrideGetCurrentPlayerStrVsBlockForgeSuperiors(String[] stringArray) {
        this.overrideGetCurrentPlayerStrVsBlockForgeSuperiors = stringArray;
    }

    public void setOverrideGetCurrentPlayerStrVsBlockForgeInferiors(String[] stringArray) {
        this.overrideGetCurrentPlayerStrVsBlockForgeInferiors = stringArray;
    }

    public void setAfterGetCurrentPlayerStrVsBlockForgeSuperiors(String[] stringArray) {
        this.afterGetCurrentPlayerStrVsBlockForgeSuperiors = stringArray;
    }

    public void setAfterGetCurrentPlayerStrVsBlockForgeInferiors(String[] stringArray) {
        this.afterGetCurrentPlayerStrVsBlockForgeInferiors = stringArray;
    }

    public String[] getBeforeGetDistanceSqSuperiors() {
        return this.beforeGetDistanceSqSuperiors;
    }

    public String[] getBeforeGetDistanceSqInferiors() {
        return this.beforeGetDistanceSqInferiors;
    }

    public String[] getOverrideGetDistanceSqSuperiors() {
        return this.overrideGetDistanceSqSuperiors;
    }

    public String[] getOverrideGetDistanceSqInferiors() {
        return this.overrideGetDistanceSqInferiors;
    }

    public String[] getAfterGetDistanceSqSuperiors() {
        return this.afterGetDistanceSqSuperiors;
    }

    public String[] getAfterGetDistanceSqInferiors() {
        return this.afterGetDistanceSqInferiors;
    }

    public void setBeforeGetDistanceSqSuperiors(String[] stringArray) {
        this.beforeGetDistanceSqSuperiors = stringArray;
    }

    public void setBeforeGetDistanceSqInferiors(String[] stringArray) {
        this.beforeGetDistanceSqInferiors = stringArray;
    }

    public void setOverrideGetDistanceSqSuperiors(String[] stringArray) {
        this.overrideGetDistanceSqSuperiors = stringArray;
    }

    public void setOverrideGetDistanceSqInferiors(String[] stringArray) {
        this.overrideGetDistanceSqInferiors = stringArray;
    }

    public void setAfterGetDistanceSqSuperiors(String[] stringArray) {
        this.afterGetDistanceSqSuperiors = stringArray;
    }

    public void setAfterGetDistanceSqInferiors(String[] stringArray) {
        this.afterGetDistanceSqInferiors = stringArray;
    }

    public String[] getBeforeGetDistanceSqToEntitySuperiors() {
        return this.beforeGetDistanceSqToEntitySuperiors;
    }

    public String[] getBeforeGetDistanceSqToEntityInferiors() {
        return this.beforeGetDistanceSqToEntityInferiors;
    }

    public String[] getOverrideGetDistanceSqToEntitySuperiors() {
        return this.overrideGetDistanceSqToEntitySuperiors;
    }

    public String[] getOverrideGetDistanceSqToEntityInferiors() {
        return this.overrideGetDistanceSqToEntityInferiors;
    }

    public String[] getAfterGetDistanceSqToEntitySuperiors() {
        return this.afterGetDistanceSqToEntitySuperiors;
    }

    public String[] getAfterGetDistanceSqToEntityInferiors() {
        return this.afterGetDistanceSqToEntityInferiors;
    }

    public void setBeforeGetDistanceSqToEntitySuperiors(String[] stringArray) {
        this.beforeGetDistanceSqToEntitySuperiors = stringArray;
    }

    public void setBeforeGetDistanceSqToEntityInferiors(String[] stringArray) {
        this.beforeGetDistanceSqToEntityInferiors = stringArray;
    }

    public void setOverrideGetDistanceSqToEntitySuperiors(String[] stringArray) {
        this.overrideGetDistanceSqToEntitySuperiors = stringArray;
    }

    public void setOverrideGetDistanceSqToEntityInferiors(String[] stringArray) {
        this.overrideGetDistanceSqToEntityInferiors = stringArray;
    }

    public void setAfterGetDistanceSqToEntitySuperiors(String[] stringArray) {
        this.afterGetDistanceSqToEntitySuperiors = stringArray;
    }

    public void setAfterGetDistanceSqToEntityInferiors(String[] stringArray) {
        this.afterGetDistanceSqToEntityInferiors = stringArray;
    }

    public String[] getBeforeGetFOVMultiplierSuperiors() {
        return this.beforeGetFOVMultiplierSuperiors;
    }

    public String[] getBeforeGetFOVMultiplierInferiors() {
        return this.beforeGetFOVMultiplierInferiors;
    }

    public String[] getOverrideGetFOVMultiplierSuperiors() {
        return this.overrideGetFOVMultiplierSuperiors;
    }

    public String[] getOverrideGetFOVMultiplierInferiors() {
        return this.overrideGetFOVMultiplierInferiors;
    }

    public String[] getAfterGetFOVMultiplierSuperiors() {
        return this.afterGetFOVMultiplierSuperiors;
    }

    public String[] getAfterGetFOVMultiplierInferiors() {
        return this.afterGetFOVMultiplierInferiors;
    }

    public void setBeforeGetFOVMultiplierSuperiors(String[] stringArray) {
        this.beforeGetFOVMultiplierSuperiors = stringArray;
    }

    public void setBeforeGetFOVMultiplierInferiors(String[] stringArray) {
        this.beforeGetFOVMultiplierInferiors = stringArray;
    }

    public void setOverrideGetFOVMultiplierSuperiors(String[] stringArray) {
        this.overrideGetFOVMultiplierSuperiors = stringArray;
    }

    public void setOverrideGetFOVMultiplierInferiors(String[] stringArray) {
        this.overrideGetFOVMultiplierInferiors = stringArray;
    }

    public void setAfterGetFOVMultiplierSuperiors(String[] stringArray) {
        this.afterGetFOVMultiplierSuperiors = stringArray;
    }

    public void setAfterGetFOVMultiplierInferiors(String[] stringArray) {
        this.afterGetFOVMultiplierInferiors = stringArray;
    }

    public String[] getBeforeGetHurtSoundSuperiors() {
        return this.beforeGetHurtSoundSuperiors;
    }

    public String[] getBeforeGetHurtSoundInferiors() {
        return this.beforeGetHurtSoundInferiors;
    }

    public String[] getOverrideGetHurtSoundSuperiors() {
        return this.overrideGetHurtSoundSuperiors;
    }

    public String[] getOverrideGetHurtSoundInferiors() {
        return this.overrideGetHurtSoundInferiors;
    }

    public String[] getAfterGetHurtSoundSuperiors() {
        return this.afterGetHurtSoundSuperiors;
    }

    public String[] getAfterGetHurtSoundInferiors() {
        return this.afterGetHurtSoundInferiors;
    }

    public void setBeforeGetHurtSoundSuperiors(String[] stringArray) {
        this.beforeGetHurtSoundSuperiors = stringArray;
    }

    public void setBeforeGetHurtSoundInferiors(String[] stringArray) {
        this.beforeGetHurtSoundInferiors = stringArray;
    }

    public void setOverrideGetHurtSoundSuperiors(String[] stringArray) {
        this.overrideGetHurtSoundSuperiors = stringArray;
    }

    public void setOverrideGetHurtSoundInferiors(String[] stringArray) {
        this.overrideGetHurtSoundInferiors = stringArray;
    }

    public void setAfterGetHurtSoundSuperiors(String[] stringArray) {
        this.afterGetHurtSoundSuperiors = stringArray;
    }

    public void setAfterGetHurtSoundInferiors(String[] stringArray) {
        this.afterGetHurtSoundInferiors = stringArray;
    }

    public String[] getBeforeGetItemIconSuperiors() {
        return this.beforeGetItemIconSuperiors;
    }

    public String[] getBeforeGetItemIconInferiors() {
        return this.beforeGetItemIconInferiors;
    }

    public String[] getOverrideGetItemIconSuperiors() {
        return this.overrideGetItemIconSuperiors;
    }

    public String[] getOverrideGetItemIconInferiors() {
        return this.overrideGetItemIconInferiors;
    }

    public String[] getAfterGetItemIconSuperiors() {
        return this.afterGetItemIconSuperiors;
    }

    public String[] getAfterGetItemIconInferiors() {
        return this.afterGetItemIconInferiors;
    }

    public void setBeforeGetItemIconSuperiors(String[] stringArray) {
        this.beforeGetItemIconSuperiors = stringArray;
    }

    public void setBeforeGetItemIconInferiors(String[] stringArray) {
        this.beforeGetItemIconInferiors = stringArray;
    }

    public void setOverrideGetItemIconSuperiors(String[] stringArray) {
        this.overrideGetItemIconSuperiors = stringArray;
    }

    public void setOverrideGetItemIconInferiors(String[] stringArray) {
        this.overrideGetItemIconInferiors = stringArray;
    }

    public void setAfterGetItemIconSuperiors(String[] stringArray) {
        this.afterGetItemIconSuperiors = stringArray;
    }

    public void setAfterGetItemIconInferiors(String[] stringArray) {
        this.afterGetItemIconInferiors = stringArray;
    }

    public String[] getBeforeGetSleepTimerSuperiors() {
        return this.beforeGetSleepTimerSuperiors;
    }

    public String[] getBeforeGetSleepTimerInferiors() {
        return this.beforeGetSleepTimerInferiors;
    }

    public String[] getOverrideGetSleepTimerSuperiors() {
        return this.overrideGetSleepTimerSuperiors;
    }

    public String[] getOverrideGetSleepTimerInferiors() {
        return this.overrideGetSleepTimerInferiors;
    }

    public String[] getAfterGetSleepTimerSuperiors() {
        return this.afterGetSleepTimerSuperiors;
    }

    public String[] getAfterGetSleepTimerInferiors() {
        return this.afterGetSleepTimerInferiors;
    }

    public void setBeforeGetSleepTimerSuperiors(String[] stringArray) {
        this.beforeGetSleepTimerSuperiors = stringArray;
    }

    public void setBeforeGetSleepTimerInferiors(String[] stringArray) {
        this.beforeGetSleepTimerInferiors = stringArray;
    }

    public void setOverrideGetSleepTimerSuperiors(String[] stringArray) {
        this.overrideGetSleepTimerSuperiors = stringArray;
    }

    public void setOverrideGetSleepTimerInferiors(String[] stringArray) {
        this.overrideGetSleepTimerInferiors = stringArray;
    }

    public void setAfterGetSleepTimerSuperiors(String[] stringArray) {
        this.afterGetSleepTimerSuperiors = stringArray;
    }

    public void setAfterGetSleepTimerInferiors(String[] stringArray) {
        this.afterGetSleepTimerInferiors = stringArray;
    }

    public String[] getBeforeHandleLavaMovementSuperiors() {
        return this.beforeHandleLavaMovementSuperiors;
    }

    public String[] getBeforeHandleLavaMovementInferiors() {
        return this.beforeHandleLavaMovementInferiors;
    }

    public String[] getOverrideHandleLavaMovementSuperiors() {
        return this.overrideHandleLavaMovementSuperiors;
    }

    public String[] getOverrideHandleLavaMovementInferiors() {
        return this.overrideHandleLavaMovementInferiors;
    }

    public String[] getAfterHandleLavaMovementSuperiors() {
        return this.afterHandleLavaMovementSuperiors;
    }

    public String[] getAfterHandleLavaMovementInferiors() {
        return this.afterHandleLavaMovementInferiors;
    }

    public void setBeforeHandleLavaMovementSuperiors(String[] stringArray) {
        this.beforeHandleLavaMovementSuperiors = stringArray;
    }

    public void setBeforeHandleLavaMovementInferiors(String[] stringArray) {
        this.beforeHandleLavaMovementInferiors = stringArray;
    }

    public void setOverrideHandleLavaMovementSuperiors(String[] stringArray) {
        this.overrideHandleLavaMovementSuperiors = stringArray;
    }

    public void setOverrideHandleLavaMovementInferiors(String[] stringArray) {
        this.overrideHandleLavaMovementInferiors = stringArray;
    }

    public void setAfterHandleLavaMovementSuperiors(String[] stringArray) {
        this.afterHandleLavaMovementSuperiors = stringArray;
    }

    public void setAfterHandleLavaMovementInferiors(String[] stringArray) {
        this.afterHandleLavaMovementInferiors = stringArray;
    }

    public String[] getBeforeHandleWaterMovementSuperiors() {
        return this.beforeHandleWaterMovementSuperiors;
    }

    public String[] getBeforeHandleWaterMovementInferiors() {
        return this.beforeHandleWaterMovementInferiors;
    }

    public String[] getOverrideHandleWaterMovementSuperiors() {
        return this.overrideHandleWaterMovementSuperiors;
    }

    public String[] getOverrideHandleWaterMovementInferiors() {
        return this.overrideHandleWaterMovementInferiors;
    }

    public String[] getAfterHandleWaterMovementSuperiors() {
        return this.afterHandleWaterMovementSuperiors;
    }

    public String[] getAfterHandleWaterMovementInferiors() {
        return this.afterHandleWaterMovementInferiors;
    }

    public void setBeforeHandleWaterMovementSuperiors(String[] stringArray) {
        this.beforeHandleWaterMovementSuperiors = stringArray;
    }

    public void setBeforeHandleWaterMovementInferiors(String[] stringArray) {
        this.beforeHandleWaterMovementInferiors = stringArray;
    }

    public void setOverrideHandleWaterMovementSuperiors(String[] stringArray) {
        this.overrideHandleWaterMovementSuperiors = stringArray;
    }

    public void setOverrideHandleWaterMovementInferiors(String[] stringArray) {
        this.overrideHandleWaterMovementInferiors = stringArray;
    }

    public void setAfterHandleWaterMovementSuperiors(String[] stringArray) {
        this.afterHandleWaterMovementSuperiors = stringArray;
    }

    public void setAfterHandleWaterMovementInferiors(String[] stringArray) {
        this.afterHandleWaterMovementInferiors = stringArray;
    }

    public String[] getBeforeHealSuperiors() {
        return this.beforeHealSuperiors;
    }

    public String[] getBeforeHealInferiors() {
        return this.beforeHealInferiors;
    }

    public String[] getOverrideHealSuperiors() {
        return this.overrideHealSuperiors;
    }

    public String[] getOverrideHealInferiors() {
        return this.overrideHealInferiors;
    }

    public String[] getAfterHealSuperiors() {
        return this.afterHealSuperiors;
    }

    public String[] getAfterHealInferiors() {
        return this.afterHealInferiors;
    }

    public void setBeforeHealSuperiors(String[] stringArray) {
        this.beforeHealSuperiors = stringArray;
    }

    public void setBeforeHealInferiors(String[] stringArray) {
        this.beforeHealInferiors = stringArray;
    }

    public void setOverrideHealSuperiors(String[] stringArray) {
        this.overrideHealSuperiors = stringArray;
    }

    public void setOverrideHealInferiors(String[] stringArray) {
        this.overrideHealInferiors = stringArray;
    }

    public void setAfterHealSuperiors(String[] stringArray) {
        this.afterHealSuperiors = stringArray;
    }

    public void setAfterHealInferiors(String[] stringArray) {
        this.afterHealInferiors = stringArray;
    }

    public String[] getBeforeIsEntityInsideOpaqueBlockSuperiors() {
        return this.beforeIsEntityInsideOpaqueBlockSuperiors;
    }

    public String[] getBeforeIsEntityInsideOpaqueBlockInferiors() {
        return this.beforeIsEntityInsideOpaqueBlockInferiors;
    }

    public String[] getOverrideIsEntityInsideOpaqueBlockSuperiors() {
        return this.overrideIsEntityInsideOpaqueBlockSuperiors;
    }

    public String[] getOverrideIsEntityInsideOpaqueBlockInferiors() {
        return this.overrideIsEntityInsideOpaqueBlockInferiors;
    }

    public String[] getAfterIsEntityInsideOpaqueBlockSuperiors() {
        return this.afterIsEntityInsideOpaqueBlockSuperiors;
    }

    public String[] getAfterIsEntityInsideOpaqueBlockInferiors() {
        return this.afterIsEntityInsideOpaqueBlockInferiors;
    }

    public void setBeforeIsEntityInsideOpaqueBlockSuperiors(String[] stringArray) {
        this.beforeIsEntityInsideOpaqueBlockSuperiors = stringArray;
    }

    public void setBeforeIsEntityInsideOpaqueBlockInferiors(String[] stringArray) {
        this.beforeIsEntityInsideOpaqueBlockInferiors = stringArray;
    }

    public void setOverrideIsEntityInsideOpaqueBlockSuperiors(String[] stringArray) {
        this.overrideIsEntityInsideOpaqueBlockSuperiors = stringArray;
    }

    public void setOverrideIsEntityInsideOpaqueBlockInferiors(String[] stringArray) {
        this.overrideIsEntityInsideOpaqueBlockInferiors = stringArray;
    }

    public void setAfterIsEntityInsideOpaqueBlockSuperiors(String[] stringArray) {
        this.afterIsEntityInsideOpaqueBlockSuperiors = stringArray;
    }

    public void setAfterIsEntityInsideOpaqueBlockInferiors(String[] stringArray) {
        this.afterIsEntityInsideOpaqueBlockInferiors = stringArray;
    }

    public String[] getBeforeIsInWaterSuperiors() {
        return this.beforeIsInWaterSuperiors;
    }

    public String[] getBeforeIsInWaterInferiors() {
        return this.beforeIsInWaterInferiors;
    }

    public String[] getOverrideIsInWaterSuperiors() {
        return this.overrideIsInWaterSuperiors;
    }

    public String[] getOverrideIsInWaterInferiors() {
        return this.overrideIsInWaterInferiors;
    }

    public String[] getAfterIsInWaterSuperiors() {
        return this.afterIsInWaterSuperiors;
    }

    public String[] getAfterIsInWaterInferiors() {
        return this.afterIsInWaterInferiors;
    }

    public void setBeforeIsInWaterSuperiors(String[] stringArray) {
        this.beforeIsInWaterSuperiors = stringArray;
    }

    public void setBeforeIsInWaterInferiors(String[] stringArray) {
        this.beforeIsInWaterInferiors = stringArray;
    }

    public void setOverrideIsInWaterSuperiors(String[] stringArray) {
        this.overrideIsInWaterSuperiors = stringArray;
    }

    public void setOverrideIsInWaterInferiors(String[] stringArray) {
        this.overrideIsInWaterInferiors = stringArray;
    }

    public void setAfterIsInWaterSuperiors(String[] stringArray) {
        this.afterIsInWaterSuperiors = stringArray;
    }

    public void setAfterIsInWaterInferiors(String[] stringArray) {
        this.afterIsInWaterInferiors = stringArray;
    }

    public String[] getBeforeIsInsideOfMaterialSuperiors() {
        return this.beforeIsInsideOfMaterialSuperiors;
    }

    public String[] getBeforeIsInsideOfMaterialInferiors() {
        return this.beforeIsInsideOfMaterialInferiors;
    }

    public String[] getOverrideIsInsideOfMaterialSuperiors() {
        return this.overrideIsInsideOfMaterialSuperiors;
    }

    public String[] getOverrideIsInsideOfMaterialInferiors() {
        return this.overrideIsInsideOfMaterialInferiors;
    }

    public String[] getAfterIsInsideOfMaterialSuperiors() {
        return this.afterIsInsideOfMaterialSuperiors;
    }

    public String[] getAfterIsInsideOfMaterialInferiors() {
        return this.afterIsInsideOfMaterialInferiors;
    }

    public void setBeforeIsInsideOfMaterialSuperiors(String[] stringArray) {
        this.beforeIsInsideOfMaterialSuperiors = stringArray;
    }

    public void setBeforeIsInsideOfMaterialInferiors(String[] stringArray) {
        this.beforeIsInsideOfMaterialInferiors = stringArray;
    }

    public void setOverrideIsInsideOfMaterialSuperiors(String[] stringArray) {
        this.overrideIsInsideOfMaterialSuperiors = stringArray;
    }

    public void setOverrideIsInsideOfMaterialInferiors(String[] stringArray) {
        this.overrideIsInsideOfMaterialInferiors = stringArray;
    }

    public void setAfterIsInsideOfMaterialSuperiors(String[] stringArray) {
        this.afterIsInsideOfMaterialSuperiors = stringArray;
    }

    public void setAfterIsInsideOfMaterialInferiors(String[] stringArray) {
        this.afterIsInsideOfMaterialInferiors = stringArray;
    }

    public String[] getBeforeIsOnLadderSuperiors() {
        return this.beforeIsOnLadderSuperiors;
    }

    public String[] getBeforeIsOnLadderInferiors() {
        return this.beforeIsOnLadderInferiors;
    }

    public String[] getOverrideIsOnLadderSuperiors() {
        return this.overrideIsOnLadderSuperiors;
    }

    public String[] getOverrideIsOnLadderInferiors() {
        return this.overrideIsOnLadderInferiors;
    }

    public String[] getAfterIsOnLadderSuperiors() {
        return this.afterIsOnLadderSuperiors;
    }

    public String[] getAfterIsOnLadderInferiors() {
        return this.afterIsOnLadderInferiors;
    }

    public void setBeforeIsOnLadderSuperiors(String[] stringArray) {
        this.beforeIsOnLadderSuperiors = stringArray;
    }

    public void setBeforeIsOnLadderInferiors(String[] stringArray) {
        this.beforeIsOnLadderInferiors = stringArray;
    }

    public void setOverrideIsOnLadderSuperiors(String[] stringArray) {
        this.overrideIsOnLadderSuperiors = stringArray;
    }

    public void setOverrideIsOnLadderInferiors(String[] stringArray) {
        this.overrideIsOnLadderInferiors = stringArray;
    }

    public void setAfterIsOnLadderSuperiors(String[] stringArray) {
        this.afterIsOnLadderSuperiors = stringArray;
    }

    public void setAfterIsOnLadderInferiors(String[] stringArray) {
        this.afterIsOnLadderInferiors = stringArray;
    }

    public String[] getBeforeIsPlayerSleepingSuperiors() {
        return this.beforeIsPlayerSleepingSuperiors;
    }

    public String[] getBeforeIsPlayerSleepingInferiors() {
        return this.beforeIsPlayerSleepingInferiors;
    }

    public String[] getOverrideIsPlayerSleepingSuperiors() {
        return this.overrideIsPlayerSleepingSuperiors;
    }

    public String[] getOverrideIsPlayerSleepingInferiors() {
        return this.overrideIsPlayerSleepingInferiors;
    }

    public String[] getAfterIsPlayerSleepingSuperiors() {
        return this.afterIsPlayerSleepingSuperiors;
    }

    public String[] getAfterIsPlayerSleepingInferiors() {
        return this.afterIsPlayerSleepingInferiors;
    }

    public void setBeforeIsPlayerSleepingSuperiors(String[] stringArray) {
        this.beforeIsPlayerSleepingSuperiors = stringArray;
    }

    public void setBeforeIsPlayerSleepingInferiors(String[] stringArray) {
        this.beforeIsPlayerSleepingInferiors = stringArray;
    }

    public void setOverrideIsPlayerSleepingSuperiors(String[] stringArray) {
        this.overrideIsPlayerSleepingSuperiors = stringArray;
    }

    public void setOverrideIsPlayerSleepingInferiors(String[] stringArray) {
        this.overrideIsPlayerSleepingInferiors = stringArray;
    }

    public void setAfterIsPlayerSleepingSuperiors(String[] stringArray) {
        this.afterIsPlayerSleepingSuperiors = stringArray;
    }

    public void setAfterIsPlayerSleepingInferiors(String[] stringArray) {
        this.afterIsPlayerSleepingInferiors = stringArray;
    }

    public String[] getBeforeIsSneakingSuperiors() {
        return this.beforeIsSneakingSuperiors;
    }

    public String[] getBeforeIsSneakingInferiors() {
        return this.beforeIsSneakingInferiors;
    }

    public String[] getOverrideIsSneakingSuperiors() {
        return this.overrideIsSneakingSuperiors;
    }

    public String[] getOverrideIsSneakingInferiors() {
        return this.overrideIsSneakingInferiors;
    }

    public String[] getAfterIsSneakingSuperiors() {
        return this.afterIsSneakingSuperiors;
    }

    public String[] getAfterIsSneakingInferiors() {
        return this.afterIsSneakingInferiors;
    }

    public void setBeforeIsSneakingSuperiors(String[] stringArray) {
        this.beforeIsSneakingSuperiors = stringArray;
    }

    public void setBeforeIsSneakingInferiors(String[] stringArray) {
        this.beforeIsSneakingInferiors = stringArray;
    }

    public void setOverrideIsSneakingSuperiors(String[] stringArray) {
        this.overrideIsSneakingSuperiors = stringArray;
    }

    public void setOverrideIsSneakingInferiors(String[] stringArray) {
        this.overrideIsSneakingInferiors = stringArray;
    }

    public void setAfterIsSneakingSuperiors(String[] stringArray) {
        this.afterIsSneakingSuperiors = stringArray;
    }

    public void setAfterIsSneakingInferiors(String[] stringArray) {
        this.afterIsSneakingInferiors = stringArray;
    }

    public String[] getBeforeIsSprintingSuperiors() {
        return this.beforeIsSprintingSuperiors;
    }

    public String[] getBeforeIsSprintingInferiors() {
        return this.beforeIsSprintingInferiors;
    }

    public String[] getOverrideIsSprintingSuperiors() {
        return this.overrideIsSprintingSuperiors;
    }

    public String[] getOverrideIsSprintingInferiors() {
        return this.overrideIsSprintingInferiors;
    }

    public String[] getAfterIsSprintingSuperiors() {
        return this.afterIsSprintingSuperiors;
    }

    public String[] getAfterIsSprintingInferiors() {
        return this.afterIsSprintingInferiors;
    }

    public void setBeforeIsSprintingSuperiors(String[] stringArray) {
        this.beforeIsSprintingSuperiors = stringArray;
    }

    public void setBeforeIsSprintingInferiors(String[] stringArray) {
        this.beforeIsSprintingInferiors = stringArray;
    }

    public void setOverrideIsSprintingSuperiors(String[] stringArray) {
        this.overrideIsSprintingSuperiors = stringArray;
    }

    public void setOverrideIsSprintingInferiors(String[] stringArray) {
        this.overrideIsSprintingInferiors = stringArray;
    }

    public void setAfterIsSprintingSuperiors(String[] stringArray) {
        this.afterIsSprintingSuperiors = stringArray;
    }

    public void setAfterIsSprintingInferiors(String[] stringArray) {
        this.afterIsSprintingInferiors = stringArray;
    }

    public String[] getBeforeJumpSuperiors() {
        return this.beforeJumpSuperiors;
    }

    public String[] getBeforeJumpInferiors() {
        return this.beforeJumpInferiors;
    }

    public String[] getOverrideJumpSuperiors() {
        return this.overrideJumpSuperiors;
    }

    public String[] getOverrideJumpInferiors() {
        return this.overrideJumpInferiors;
    }

    public String[] getAfterJumpSuperiors() {
        return this.afterJumpSuperiors;
    }

    public String[] getAfterJumpInferiors() {
        return this.afterJumpInferiors;
    }

    public void setBeforeJumpSuperiors(String[] stringArray) {
        this.beforeJumpSuperiors = stringArray;
    }

    public void setBeforeJumpInferiors(String[] stringArray) {
        this.beforeJumpInferiors = stringArray;
    }

    public void setOverrideJumpSuperiors(String[] stringArray) {
        this.overrideJumpSuperiors = stringArray;
    }

    public void setOverrideJumpInferiors(String[] stringArray) {
        this.overrideJumpInferiors = stringArray;
    }

    public void setAfterJumpSuperiors(String[] stringArray) {
        this.afterJumpSuperiors = stringArray;
    }

    public void setAfterJumpInferiors(String[] stringArray) {
        this.afterJumpInferiors = stringArray;
    }

    public String[] getBeforeKnockBackSuperiors() {
        return this.beforeKnockBackSuperiors;
    }

    public String[] getBeforeKnockBackInferiors() {
        return this.beforeKnockBackInferiors;
    }

    public String[] getOverrideKnockBackSuperiors() {
        return this.overrideKnockBackSuperiors;
    }

    public String[] getOverrideKnockBackInferiors() {
        return this.overrideKnockBackInferiors;
    }

    public String[] getAfterKnockBackSuperiors() {
        return this.afterKnockBackSuperiors;
    }

    public String[] getAfterKnockBackInferiors() {
        return this.afterKnockBackInferiors;
    }

    public void setBeforeKnockBackSuperiors(String[] stringArray) {
        this.beforeKnockBackSuperiors = stringArray;
    }

    public void setBeforeKnockBackInferiors(String[] stringArray) {
        this.beforeKnockBackInferiors = stringArray;
    }

    public void setOverrideKnockBackSuperiors(String[] stringArray) {
        this.overrideKnockBackSuperiors = stringArray;
    }

    public void setOverrideKnockBackInferiors(String[] stringArray) {
        this.overrideKnockBackInferiors = stringArray;
    }

    public void setAfterKnockBackSuperiors(String[] stringArray) {
        this.afterKnockBackSuperiors = stringArray;
    }

    public void setAfterKnockBackInferiors(String[] stringArray) {
        this.afterKnockBackInferiors = stringArray;
    }

    public String[] getBeforeMoveEntitySuperiors() {
        return this.beforeMoveEntitySuperiors;
    }

    public String[] getBeforeMoveEntityInferiors() {
        return this.beforeMoveEntityInferiors;
    }

    public String[] getOverrideMoveEntitySuperiors() {
        return this.overrideMoveEntitySuperiors;
    }

    public String[] getOverrideMoveEntityInferiors() {
        return this.overrideMoveEntityInferiors;
    }

    public String[] getAfterMoveEntitySuperiors() {
        return this.afterMoveEntitySuperiors;
    }

    public String[] getAfterMoveEntityInferiors() {
        return this.afterMoveEntityInferiors;
    }

    public void setBeforeMoveEntitySuperiors(String[] stringArray) {
        this.beforeMoveEntitySuperiors = stringArray;
    }

    public void setBeforeMoveEntityInferiors(String[] stringArray) {
        this.beforeMoveEntityInferiors = stringArray;
    }

    public void setOverrideMoveEntitySuperiors(String[] stringArray) {
        this.overrideMoveEntitySuperiors = stringArray;
    }

    public void setOverrideMoveEntityInferiors(String[] stringArray) {
        this.overrideMoveEntityInferiors = stringArray;
    }

    public void setAfterMoveEntitySuperiors(String[] stringArray) {
        this.afterMoveEntitySuperiors = stringArray;
    }

    public void setAfterMoveEntityInferiors(String[] stringArray) {
        this.afterMoveEntityInferiors = stringArray;
    }

    public String[] getBeforeMoveEntityWithHeadingSuperiors() {
        return this.beforeMoveEntityWithHeadingSuperiors;
    }

    public String[] getBeforeMoveEntityWithHeadingInferiors() {
        return this.beforeMoveEntityWithHeadingInferiors;
    }

    public String[] getOverrideMoveEntityWithHeadingSuperiors() {
        return this.overrideMoveEntityWithHeadingSuperiors;
    }

    public String[] getOverrideMoveEntityWithHeadingInferiors() {
        return this.overrideMoveEntityWithHeadingInferiors;
    }

    public String[] getAfterMoveEntityWithHeadingSuperiors() {
        return this.afterMoveEntityWithHeadingSuperiors;
    }

    public String[] getAfterMoveEntityWithHeadingInferiors() {
        return this.afterMoveEntityWithHeadingInferiors;
    }

    public void setBeforeMoveEntityWithHeadingSuperiors(String[] stringArray) {
        this.beforeMoveEntityWithHeadingSuperiors = stringArray;
    }

    public void setBeforeMoveEntityWithHeadingInferiors(String[] stringArray) {
        this.beforeMoveEntityWithHeadingInferiors = stringArray;
    }

    public void setOverrideMoveEntityWithHeadingSuperiors(String[] stringArray) {
        this.overrideMoveEntityWithHeadingSuperiors = stringArray;
    }

    public void setOverrideMoveEntityWithHeadingInferiors(String[] stringArray) {
        this.overrideMoveEntityWithHeadingInferiors = stringArray;
    }

    public void setAfterMoveEntityWithHeadingSuperiors(String[] stringArray) {
        this.afterMoveEntityWithHeadingSuperiors = stringArray;
    }

    public void setAfterMoveEntityWithHeadingInferiors(String[] stringArray) {
        this.afterMoveEntityWithHeadingInferiors = stringArray;
    }

    public String[] getBeforeMoveFlyingSuperiors() {
        return this.beforeMoveFlyingSuperiors;
    }

    public String[] getBeforeMoveFlyingInferiors() {
        return this.beforeMoveFlyingInferiors;
    }

    public String[] getOverrideMoveFlyingSuperiors() {
        return this.overrideMoveFlyingSuperiors;
    }

    public String[] getOverrideMoveFlyingInferiors() {
        return this.overrideMoveFlyingInferiors;
    }

    public String[] getAfterMoveFlyingSuperiors() {
        return this.afterMoveFlyingSuperiors;
    }

    public String[] getAfterMoveFlyingInferiors() {
        return this.afterMoveFlyingInferiors;
    }

    public void setBeforeMoveFlyingSuperiors(String[] stringArray) {
        this.beforeMoveFlyingSuperiors = stringArray;
    }

    public void setBeforeMoveFlyingInferiors(String[] stringArray) {
        this.beforeMoveFlyingInferiors = stringArray;
    }

    public void setOverrideMoveFlyingSuperiors(String[] stringArray) {
        this.overrideMoveFlyingSuperiors = stringArray;
    }

    public void setOverrideMoveFlyingInferiors(String[] stringArray) {
        this.overrideMoveFlyingInferiors = stringArray;
    }

    public void setAfterMoveFlyingSuperiors(String[] stringArray) {
        this.afterMoveFlyingSuperiors = stringArray;
    }

    public void setAfterMoveFlyingInferiors(String[] stringArray) {
        this.afterMoveFlyingInferiors = stringArray;
    }

    public String[] getBeforeOnDeathSuperiors() {
        return this.beforeOnDeathSuperiors;
    }

    public String[] getBeforeOnDeathInferiors() {
        return this.beforeOnDeathInferiors;
    }

    public String[] getOverrideOnDeathSuperiors() {
        return this.overrideOnDeathSuperiors;
    }

    public String[] getOverrideOnDeathInferiors() {
        return this.overrideOnDeathInferiors;
    }

    public String[] getAfterOnDeathSuperiors() {
        return this.afterOnDeathSuperiors;
    }

    public String[] getAfterOnDeathInferiors() {
        return this.afterOnDeathInferiors;
    }

    public void setBeforeOnDeathSuperiors(String[] stringArray) {
        this.beforeOnDeathSuperiors = stringArray;
    }

    public void setBeforeOnDeathInferiors(String[] stringArray) {
        this.beforeOnDeathInferiors = stringArray;
    }

    public void setOverrideOnDeathSuperiors(String[] stringArray) {
        this.overrideOnDeathSuperiors = stringArray;
    }

    public void setOverrideOnDeathInferiors(String[] stringArray) {
        this.overrideOnDeathInferiors = stringArray;
    }

    public void setAfterOnDeathSuperiors(String[] stringArray) {
        this.afterOnDeathSuperiors = stringArray;
    }

    public void setAfterOnDeathInferiors(String[] stringArray) {
        this.afterOnDeathInferiors = stringArray;
    }

    public String[] getBeforeOnLivingUpdateSuperiors() {
        return this.beforeOnLivingUpdateSuperiors;
    }

    public String[] getBeforeOnLivingUpdateInferiors() {
        return this.beforeOnLivingUpdateInferiors;
    }

    public String[] getOverrideOnLivingUpdateSuperiors() {
        return this.overrideOnLivingUpdateSuperiors;
    }

    public String[] getOverrideOnLivingUpdateInferiors() {
        return this.overrideOnLivingUpdateInferiors;
    }

    public String[] getAfterOnLivingUpdateSuperiors() {
        return this.afterOnLivingUpdateSuperiors;
    }

    public String[] getAfterOnLivingUpdateInferiors() {
        return this.afterOnLivingUpdateInferiors;
    }

    public void setBeforeOnLivingUpdateSuperiors(String[] stringArray) {
        this.beforeOnLivingUpdateSuperiors = stringArray;
    }

    public void setBeforeOnLivingUpdateInferiors(String[] stringArray) {
        this.beforeOnLivingUpdateInferiors = stringArray;
    }

    public void setOverrideOnLivingUpdateSuperiors(String[] stringArray) {
        this.overrideOnLivingUpdateSuperiors = stringArray;
    }

    public void setOverrideOnLivingUpdateInferiors(String[] stringArray) {
        this.overrideOnLivingUpdateInferiors = stringArray;
    }

    public void setAfterOnLivingUpdateSuperiors(String[] stringArray) {
        this.afterOnLivingUpdateSuperiors = stringArray;
    }

    public void setAfterOnLivingUpdateInferiors(String[] stringArray) {
        this.afterOnLivingUpdateInferiors = stringArray;
    }

    public String[] getBeforeOnKillEntitySuperiors() {
        return this.beforeOnKillEntitySuperiors;
    }

    public String[] getBeforeOnKillEntityInferiors() {
        return this.beforeOnKillEntityInferiors;
    }

    public String[] getOverrideOnKillEntitySuperiors() {
        return this.overrideOnKillEntitySuperiors;
    }

    public String[] getOverrideOnKillEntityInferiors() {
        return this.overrideOnKillEntityInferiors;
    }

    public String[] getAfterOnKillEntitySuperiors() {
        return this.afterOnKillEntitySuperiors;
    }

    public String[] getAfterOnKillEntityInferiors() {
        return this.afterOnKillEntityInferiors;
    }

    public void setBeforeOnKillEntitySuperiors(String[] stringArray) {
        this.beforeOnKillEntitySuperiors = stringArray;
    }

    public void setBeforeOnKillEntityInferiors(String[] stringArray) {
        this.beforeOnKillEntityInferiors = stringArray;
    }

    public void setOverrideOnKillEntitySuperiors(String[] stringArray) {
        this.overrideOnKillEntitySuperiors = stringArray;
    }

    public void setOverrideOnKillEntityInferiors(String[] stringArray) {
        this.overrideOnKillEntityInferiors = stringArray;
    }

    public void setAfterOnKillEntitySuperiors(String[] stringArray) {
        this.afterOnKillEntitySuperiors = stringArray;
    }

    public void setAfterOnKillEntityInferiors(String[] stringArray) {
        this.afterOnKillEntityInferiors = stringArray;
    }

    public String[] getBeforeOnStruckByLightningSuperiors() {
        return this.beforeOnStruckByLightningSuperiors;
    }

    public String[] getBeforeOnStruckByLightningInferiors() {
        return this.beforeOnStruckByLightningInferiors;
    }

    public String[] getOverrideOnStruckByLightningSuperiors() {
        return this.overrideOnStruckByLightningSuperiors;
    }

    public String[] getOverrideOnStruckByLightningInferiors() {
        return this.overrideOnStruckByLightningInferiors;
    }

    public String[] getAfterOnStruckByLightningSuperiors() {
        return this.afterOnStruckByLightningSuperiors;
    }

    public String[] getAfterOnStruckByLightningInferiors() {
        return this.afterOnStruckByLightningInferiors;
    }

    public void setBeforeOnStruckByLightningSuperiors(String[] stringArray) {
        this.beforeOnStruckByLightningSuperiors = stringArray;
    }

    public void setBeforeOnStruckByLightningInferiors(String[] stringArray) {
        this.beforeOnStruckByLightningInferiors = stringArray;
    }

    public void setOverrideOnStruckByLightningSuperiors(String[] stringArray) {
        this.overrideOnStruckByLightningSuperiors = stringArray;
    }

    public void setOverrideOnStruckByLightningInferiors(String[] stringArray) {
        this.overrideOnStruckByLightningInferiors = stringArray;
    }

    public void setAfterOnStruckByLightningSuperiors(String[] stringArray) {
        this.afterOnStruckByLightningSuperiors = stringArray;
    }

    public void setAfterOnStruckByLightningInferiors(String[] stringArray) {
        this.afterOnStruckByLightningInferiors = stringArray;
    }

    public String[] getBeforeOnUpdateSuperiors() {
        return this.beforeOnUpdateSuperiors;
    }

    public String[] getBeforeOnUpdateInferiors() {
        return this.beforeOnUpdateInferiors;
    }

    public String[] getOverrideOnUpdateSuperiors() {
        return this.overrideOnUpdateSuperiors;
    }

    public String[] getOverrideOnUpdateInferiors() {
        return this.overrideOnUpdateInferiors;
    }

    public String[] getAfterOnUpdateSuperiors() {
        return this.afterOnUpdateSuperiors;
    }

    public String[] getAfterOnUpdateInferiors() {
        return this.afterOnUpdateInferiors;
    }

    public void setBeforeOnUpdateSuperiors(String[] stringArray) {
        this.beforeOnUpdateSuperiors = stringArray;
    }

    public void setBeforeOnUpdateInferiors(String[] stringArray) {
        this.beforeOnUpdateInferiors = stringArray;
    }

    public void setOverrideOnUpdateSuperiors(String[] stringArray) {
        this.overrideOnUpdateSuperiors = stringArray;
    }

    public void setOverrideOnUpdateInferiors(String[] stringArray) {
        this.overrideOnUpdateInferiors = stringArray;
    }

    public void setAfterOnUpdateSuperiors(String[] stringArray) {
        this.afterOnUpdateSuperiors = stringArray;
    }

    public void setAfterOnUpdateInferiors(String[] stringArray) {
        this.afterOnUpdateInferiors = stringArray;
    }

    public String[] getBeforePlayStepSoundSuperiors() {
        return this.beforePlayStepSoundSuperiors;
    }

    public String[] getBeforePlayStepSoundInferiors() {
        return this.beforePlayStepSoundInferiors;
    }

    public String[] getOverridePlayStepSoundSuperiors() {
        return this.overridePlayStepSoundSuperiors;
    }

    public String[] getOverridePlayStepSoundInferiors() {
        return this.overridePlayStepSoundInferiors;
    }

    public String[] getAfterPlayStepSoundSuperiors() {
        return this.afterPlayStepSoundSuperiors;
    }

    public String[] getAfterPlayStepSoundInferiors() {
        return this.afterPlayStepSoundInferiors;
    }

    public void setBeforePlayStepSoundSuperiors(String[] stringArray) {
        this.beforePlayStepSoundSuperiors = stringArray;
    }

    public void setBeforePlayStepSoundInferiors(String[] stringArray) {
        this.beforePlayStepSoundInferiors = stringArray;
    }

    public void setOverridePlayStepSoundSuperiors(String[] stringArray) {
        this.overridePlayStepSoundSuperiors = stringArray;
    }

    public void setOverridePlayStepSoundInferiors(String[] stringArray) {
        this.overridePlayStepSoundInferiors = stringArray;
    }

    public void setAfterPlayStepSoundSuperiors(String[] stringArray) {
        this.afterPlayStepSoundSuperiors = stringArray;
    }

    public void setAfterPlayStepSoundInferiors(String[] stringArray) {
        this.afterPlayStepSoundInferiors = stringArray;
    }

    public String[] getBeforePushOutOfBlocksSuperiors() {
        return this.beforePushOutOfBlocksSuperiors;
    }

    public String[] getBeforePushOutOfBlocksInferiors() {
        return this.beforePushOutOfBlocksInferiors;
    }

    public String[] getOverridePushOutOfBlocksSuperiors() {
        return this.overridePushOutOfBlocksSuperiors;
    }

    public String[] getOverridePushOutOfBlocksInferiors() {
        return this.overridePushOutOfBlocksInferiors;
    }

    public String[] getAfterPushOutOfBlocksSuperiors() {
        return this.afterPushOutOfBlocksSuperiors;
    }

    public String[] getAfterPushOutOfBlocksInferiors() {
        return this.afterPushOutOfBlocksInferiors;
    }

    public void setBeforePushOutOfBlocksSuperiors(String[] stringArray) {
        this.beforePushOutOfBlocksSuperiors = stringArray;
    }

    public void setBeforePushOutOfBlocksInferiors(String[] stringArray) {
        this.beforePushOutOfBlocksInferiors = stringArray;
    }

    public void setOverridePushOutOfBlocksSuperiors(String[] stringArray) {
        this.overridePushOutOfBlocksSuperiors = stringArray;
    }

    public void setOverridePushOutOfBlocksInferiors(String[] stringArray) {
        this.overridePushOutOfBlocksInferiors = stringArray;
    }

    public void setAfterPushOutOfBlocksSuperiors(String[] stringArray) {
        this.afterPushOutOfBlocksSuperiors = stringArray;
    }

    public void setAfterPushOutOfBlocksInferiors(String[] stringArray) {
        this.afterPushOutOfBlocksInferiors = stringArray;
    }

    public String[] getBeforeRayTraceSuperiors() {
        return this.beforeRayTraceSuperiors;
    }

    public String[] getBeforeRayTraceInferiors() {
        return this.beforeRayTraceInferiors;
    }

    public String[] getOverrideRayTraceSuperiors() {
        return this.overrideRayTraceSuperiors;
    }

    public String[] getOverrideRayTraceInferiors() {
        return this.overrideRayTraceInferiors;
    }

    public String[] getAfterRayTraceSuperiors() {
        return this.afterRayTraceSuperiors;
    }

    public String[] getAfterRayTraceInferiors() {
        return this.afterRayTraceInferiors;
    }

    public void setBeforeRayTraceSuperiors(String[] stringArray) {
        this.beforeRayTraceSuperiors = stringArray;
    }

    public void setBeforeRayTraceInferiors(String[] stringArray) {
        this.beforeRayTraceInferiors = stringArray;
    }

    public void setOverrideRayTraceSuperiors(String[] stringArray) {
        this.overrideRayTraceSuperiors = stringArray;
    }

    public void setOverrideRayTraceInferiors(String[] stringArray) {
        this.overrideRayTraceInferiors = stringArray;
    }

    public void setAfterRayTraceSuperiors(String[] stringArray) {
        this.afterRayTraceSuperiors = stringArray;
    }

    public void setAfterRayTraceInferiors(String[] stringArray) {
        this.afterRayTraceInferiors = stringArray;
    }

    public String[] getBeforeReadEntityFromNBTSuperiors() {
        return this.beforeReadEntityFromNBTSuperiors;
    }

    public String[] getBeforeReadEntityFromNBTInferiors() {
        return this.beforeReadEntityFromNBTInferiors;
    }

    public String[] getOverrideReadEntityFromNBTSuperiors() {
        return this.overrideReadEntityFromNBTSuperiors;
    }

    public String[] getOverrideReadEntityFromNBTInferiors() {
        return this.overrideReadEntityFromNBTInferiors;
    }

    public String[] getAfterReadEntityFromNBTSuperiors() {
        return this.afterReadEntityFromNBTSuperiors;
    }

    public String[] getAfterReadEntityFromNBTInferiors() {
        return this.afterReadEntityFromNBTInferiors;
    }

    public void setBeforeReadEntityFromNBTSuperiors(String[] stringArray) {
        this.beforeReadEntityFromNBTSuperiors = stringArray;
    }

    public void setBeforeReadEntityFromNBTInferiors(String[] stringArray) {
        this.beforeReadEntityFromNBTInferiors = stringArray;
    }

    public void setOverrideReadEntityFromNBTSuperiors(String[] stringArray) {
        this.overrideReadEntityFromNBTSuperiors = stringArray;
    }

    public void setOverrideReadEntityFromNBTInferiors(String[] stringArray) {
        this.overrideReadEntityFromNBTInferiors = stringArray;
    }

    public void setAfterReadEntityFromNBTSuperiors(String[] stringArray) {
        this.afterReadEntityFromNBTSuperiors = stringArray;
    }

    public void setAfterReadEntityFromNBTInferiors(String[] stringArray) {
        this.afterReadEntityFromNBTInferiors = stringArray;
    }

    public String[] getBeforeRespawnPlayerSuperiors() {
        return this.beforeRespawnPlayerSuperiors;
    }

    public String[] getBeforeRespawnPlayerInferiors() {
        return this.beforeRespawnPlayerInferiors;
    }

    public String[] getOverrideRespawnPlayerSuperiors() {
        return this.overrideRespawnPlayerSuperiors;
    }

    public String[] getOverrideRespawnPlayerInferiors() {
        return this.overrideRespawnPlayerInferiors;
    }

    public String[] getAfterRespawnPlayerSuperiors() {
        return this.afterRespawnPlayerSuperiors;
    }

    public String[] getAfterRespawnPlayerInferiors() {
        return this.afterRespawnPlayerInferiors;
    }

    public void setBeforeRespawnPlayerSuperiors(String[] stringArray) {
        this.beforeRespawnPlayerSuperiors = stringArray;
    }

    public void setBeforeRespawnPlayerInferiors(String[] stringArray) {
        this.beforeRespawnPlayerInferiors = stringArray;
    }

    public void setOverrideRespawnPlayerSuperiors(String[] stringArray) {
        this.overrideRespawnPlayerSuperiors = stringArray;
    }

    public void setOverrideRespawnPlayerInferiors(String[] stringArray) {
        this.overrideRespawnPlayerInferiors = stringArray;
    }

    public void setAfterRespawnPlayerSuperiors(String[] stringArray) {
        this.afterRespawnPlayerSuperiors = stringArray;
    }

    public void setAfterRespawnPlayerInferiors(String[] stringArray) {
        this.afterRespawnPlayerInferiors = stringArray;
    }

    public String[] getBeforeSetDeadSuperiors() {
        return this.beforeSetDeadSuperiors;
    }

    public String[] getBeforeSetDeadInferiors() {
        return this.beforeSetDeadInferiors;
    }

    public String[] getOverrideSetDeadSuperiors() {
        return this.overrideSetDeadSuperiors;
    }

    public String[] getOverrideSetDeadInferiors() {
        return this.overrideSetDeadInferiors;
    }

    public String[] getAfterSetDeadSuperiors() {
        return this.afterSetDeadSuperiors;
    }

    public String[] getAfterSetDeadInferiors() {
        return this.afterSetDeadInferiors;
    }

    public void setBeforeSetDeadSuperiors(String[] stringArray) {
        this.beforeSetDeadSuperiors = stringArray;
    }

    public void setBeforeSetDeadInferiors(String[] stringArray) {
        this.beforeSetDeadInferiors = stringArray;
    }

    public void setOverrideSetDeadSuperiors(String[] stringArray) {
        this.overrideSetDeadSuperiors = stringArray;
    }

    public void setOverrideSetDeadInferiors(String[] stringArray) {
        this.overrideSetDeadInferiors = stringArray;
    }

    public void setAfterSetDeadSuperiors(String[] stringArray) {
        this.afterSetDeadSuperiors = stringArray;
    }

    public void setAfterSetDeadInferiors(String[] stringArray) {
        this.afterSetDeadInferiors = stringArray;
    }

    public String[] getBeforeSetPlayerSPHealthSuperiors() {
        return this.beforeSetPlayerSPHealthSuperiors;
    }

    public String[] getBeforeSetPlayerSPHealthInferiors() {
        return this.beforeSetPlayerSPHealthInferiors;
    }

    public String[] getOverrideSetPlayerSPHealthSuperiors() {
        return this.overrideSetPlayerSPHealthSuperiors;
    }

    public String[] getOverrideSetPlayerSPHealthInferiors() {
        return this.overrideSetPlayerSPHealthInferiors;
    }

    public String[] getAfterSetPlayerSPHealthSuperiors() {
        return this.afterSetPlayerSPHealthSuperiors;
    }

    public String[] getAfterSetPlayerSPHealthInferiors() {
        return this.afterSetPlayerSPHealthInferiors;
    }

    public void setBeforeSetPlayerSPHealthSuperiors(String[] stringArray) {
        this.beforeSetPlayerSPHealthSuperiors = stringArray;
    }

    public void setBeforeSetPlayerSPHealthInferiors(String[] stringArray) {
        this.beforeSetPlayerSPHealthInferiors = stringArray;
    }

    public void setOverrideSetPlayerSPHealthSuperiors(String[] stringArray) {
        this.overrideSetPlayerSPHealthSuperiors = stringArray;
    }

    public void setOverrideSetPlayerSPHealthInferiors(String[] stringArray) {
        this.overrideSetPlayerSPHealthInferiors = stringArray;
    }

    public void setAfterSetPlayerSPHealthSuperiors(String[] stringArray) {
        this.afterSetPlayerSPHealthSuperiors = stringArray;
    }

    public void setAfterSetPlayerSPHealthInferiors(String[] stringArray) {
        this.afterSetPlayerSPHealthInferiors = stringArray;
    }

    public String[] getBeforeSetPositionAndRotationSuperiors() {
        return this.beforeSetPositionAndRotationSuperiors;
    }

    public String[] getBeforeSetPositionAndRotationInferiors() {
        return this.beforeSetPositionAndRotationInferiors;
    }

    public String[] getOverrideSetPositionAndRotationSuperiors() {
        return this.overrideSetPositionAndRotationSuperiors;
    }

    public String[] getOverrideSetPositionAndRotationInferiors() {
        return this.overrideSetPositionAndRotationInferiors;
    }

    public String[] getAfterSetPositionAndRotationSuperiors() {
        return this.afterSetPositionAndRotationSuperiors;
    }

    public String[] getAfterSetPositionAndRotationInferiors() {
        return this.afterSetPositionAndRotationInferiors;
    }

    public void setBeforeSetPositionAndRotationSuperiors(String[] stringArray) {
        this.beforeSetPositionAndRotationSuperiors = stringArray;
    }

    public void setBeforeSetPositionAndRotationInferiors(String[] stringArray) {
        this.beforeSetPositionAndRotationInferiors = stringArray;
    }

    public void setOverrideSetPositionAndRotationSuperiors(String[] stringArray) {
        this.overrideSetPositionAndRotationSuperiors = stringArray;
    }

    public void setOverrideSetPositionAndRotationInferiors(String[] stringArray) {
        this.overrideSetPositionAndRotationInferiors = stringArray;
    }

    public void setAfterSetPositionAndRotationSuperiors(String[] stringArray) {
        this.afterSetPositionAndRotationSuperiors = stringArray;
    }

    public void setAfterSetPositionAndRotationInferiors(String[] stringArray) {
        this.afterSetPositionAndRotationInferiors = stringArray;
    }

    public String[] getBeforeSleepInBedAtSuperiors() {
        return this.beforeSleepInBedAtSuperiors;
    }

    public String[] getBeforeSleepInBedAtInferiors() {
        return this.beforeSleepInBedAtInferiors;
    }

    public String[] getOverrideSleepInBedAtSuperiors() {
        return this.overrideSleepInBedAtSuperiors;
    }

    public String[] getOverrideSleepInBedAtInferiors() {
        return this.overrideSleepInBedAtInferiors;
    }

    public String[] getAfterSleepInBedAtSuperiors() {
        return this.afterSleepInBedAtSuperiors;
    }

    public String[] getAfterSleepInBedAtInferiors() {
        return this.afterSleepInBedAtInferiors;
    }

    public void setBeforeSleepInBedAtSuperiors(String[] stringArray) {
        this.beforeSleepInBedAtSuperiors = stringArray;
    }

    public void setBeforeSleepInBedAtInferiors(String[] stringArray) {
        this.beforeSleepInBedAtInferiors = stringArray;
    }

    public void setOverrideSleepInBedAtSuperiors(String[] stringArray) {
        this.overrideSleepInBedAtSuperiors = stringArray;
    }

    public void setOverrideSleepInBedAtInferiors(String[] stringArray) {
        this.overrideSleepInBedAtInferiors = stringArray;
    }

    public void setAfterSleepInBedAtSuperiors(String[] stringArray) {
        this.afterSleepInBedAtSuperiors = stringArray;
    }

    public void setAfterSleepInBedAtInferiors(String[] stringArray) {
        this.afterSleepInBedAtInferiors = stringArray;
    }

    public String[] getBeforeSwingItemSuperiors() {
        return this.beforeSwingItemSuperiors;
    }

    public String[] getBeforeSwingItemInferiors() {
        return this.beforeSwingItemInferiors;
    }

    public String[] getOverrideSwingItemSuperiors() {
        return this.overrideSwingItemSuperiors;
    }

    public String[] getOverrideSwingItemInferiors() {
        return this.overrideSwingItemInferiors;
    }

    public String[] getAfterSwingItemSuperiors() {
        return this.afterSwingItemSuperiors;
    }

    public String[] getAfterSwingItemInferiors() {
        return this.afterSwingItemInferiors;
    }

    public void setBeforeSwingItemSuperiors(String[] stringArray) {
        this.beforeSwingItemSuperiors = stringArray;
    }

    public void setBeforeSwingItemInferiors(String[] stringArray) {
        this.beforeSwingItemInferiors = stringArray;
    }

    public void setOverrideSwingItemSuperiors(String[] stringArray) {
        this.overrideSwingItemSuperiors = stringArray;
    }

    public void setOverrideSwingItemInferiors(String[] stringArray) {
        this.overrideSwingItemInferiors = stringArray;
    }

    public void setAfterSwingItemSuperiors(String[] stringArray) {
        this.afterSwingItemSuperiors = stringArray;
    }

    public void setAfterSwingItemInferiors(String[] stringArray) {
        this.afterSwingItemInferiors = stringArray;
    }

    public String[] getBeforeUpdateEntityActionStateSuperiors() {
        return this.beforeUpdateEntityActionStateSuperiors;
    }

    public String[] getBeforeUpdateEntityActionStateInferiors() {
        return this.beforeUpdateEntityActionStateInferiors;
    }

    public String[] getOverrideUpdateEntityActionStateSuperiors() {
        return this.overrideUpdateEntityActionStateSuperiors;
    }

    public String[] getOverrideUpdateEntityActionStateInferiors() {
        return this.overrideUpdateEntityActionStateInferiors;
    }

    public String[] getAfterUpdateEntityActionStateSuperiors() {
        return this.afterUpdateEntityActionStateSuperiors;
    }

    public String[] getAfterUpdateEntityActionStateInferiors() {
        return this.afterUpdateEntityActionStateInferiors;
    }

    public void setBeforeUpdateEntityActionStateSuperiors(String[] stringArray) {
        this.beforeUpdateEntityActionStateSuperiors = stringArray;
    }

    public void setBeforeUpdateEntityActionStateInferiors(String[] stringArray) {
        this.beforeUpdateEntityActionStateInferiors = stringArray;
    }

    public void setOverrideUpdateEntityActionStateSuperiors(String[] stringArray) {
        this.overrideUpdateEntityActionStateSuperiors = stringArray;
    }

    public void setOverrideUpdateEntityActionStateInferiors(String[] stringArray) {
        this.overrideUpdateEntityActionStateInferiors = stringArray;
    }

    public void setAfterUpdateEntityActionStateSuperiors(String[] stringArray) {
        this.afterUpdateEntityActionStateSuperiors = stringArray;
    }

    public void setAfterUpdateEntityActionStateInferiors(String[] stringArray) {
        this.afterUpdateEntityActionStateInferiors = stringArray;
    }

    public String[] getBeforeUpdateRiddenSuperiors() {
        return this.beforeUpdateRiddenSuperiors;
    }

    public String[] getBeforeUpdateRiddenInferiors() {
        return this.beforeUpdateRiddenInferiors;
    }

    public String[] getOverrideUpdateRiddenSuperiors() {
        return this.overrideUpdateRiddenSuperiors;
    }

    public String[] getOverrideUpdateRiddenInferiors() {
        return this.overrideUpdateRiddenInferiors;
    }

    public String[] getAfterUpdateRiddenSuperiors() {
        return this.afterUpdateRiddenSuperiors;
    }

    public String[] getAfterUpdateRiddenInferiors() {
        return this.afterUpdateRiddenInferiors;
    }

    public void setBeforeUpdateRiddenSuperiors(String[] stringArray) {
        this.beforeUpdateRiddenSuperiors = stringArray;
    }

    public void setBeforeUpdateRiddenInferiors(String[] stringArray) {
        this.beforeUpdateRiddenInferiors = stringArray;
    }

    public void setOverrideUpdateRiddenSuperiors(String[] stringArray) {
        this.overrideUpdateRiddenSuperiors = stringArray;
    }

    public void setOverrideUpdateRiddenInferiors(String[] stringArray) {
        this.overrideUpdateRiddenInferiors = stringArray;
    }

    public void setAfterUpdateRiddenSuperiors(String[] stringArray) {
        this.afterUpdateRiddenSuperiors = stringArray;
    }

    public void setAfterUpdateRiddenInferiors(String[] stringArray) {
        this.afterUpdateRiddenInferiors = stringArray;
    }

    public String[] getBeforeWriteEntityToNBTSuperiors() {
        return this.beforeWriteEntityToNBTSuperiors;
    }

    public String[] getBeforeWriteEntityToNBTInferiors() {
        return this.beforeWriteEntityToNBTInferiors;
    }

    public String[] getOverrideWriteEntityToNBTSuperiors() {
        return this.overrideWriteEntityToNBTSuperiors;
    }

    public String[] getOverrideWriteEntityToNBTInferiors() {
        return this.overrideWriteEntityToNBTInferiors;
    }

    public String[] getAfterWriteEntityToNBTSuperiors() {
        return this.afterWriteEntityToNBTSuperiors;
    }

    public String[] getAfterWriteEntityToNBTInferiors() {
        return this.afterWriteEntityToNBTInferiors;
    }

    public void setBeforeWriteEntityToNBTSuperiors(String[] stringArray) {
        this.beforeWriteEntityToNBTSuperiors = stringArray;
    }

    public void setBeforeWriteEntityToNBTInferiors(String[] stringArray) {
        this.beforeWriteEntityToNBTInferiors = stringArray;
    }

    public void setOverrideWriteEntityToNBTSuperiors(String[] stringArray) {
        this.overrideWriteEntityToNBTSuperiors = stringArray;
    }

    public void setOverrideWriteEntityToNBTInferiors(String[] stringArray) {
        this.overrideWriteEntityToNBTInferiors = stringArray;
    }

    public void setAfterWriteEntityToNBTSuperiors(String[] stringArray) {
        this.afterWriteEntityToNBTSuperiors = stringArray;
    }

    public void setAfterWriteEntityToNBTInferiors(String[] stringArray) {
        this.afterWriteEntityToNBTInferiors = stringArray;
    }
}

