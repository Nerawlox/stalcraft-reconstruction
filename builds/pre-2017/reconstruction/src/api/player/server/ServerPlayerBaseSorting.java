/*
 * Decompiled with CFR 0.152.
 */
package api.player.server;

import java.util.HashMap;
import java.util.Map;

public final class ServerPlayerBaseSorting {
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
    private String[] beforeAddExperienceSuperiors = null;
    private String[] beforeAddExperienceInferiors = null;
    private String[] overrideAddExperienceSuperiors = null;
    private String[] overrideAddExperienceInferiors = null;
    private String[] afterAddExperienceSuperiors = null;
    private String[] afterAddExperienceInferiors = null;
    private String[] beforeAddExperienceLevelSuperiors = null;
    private String[] beforeAddExperienceLevelInferiors = null;
    private String[] overrideAddExperienceLevelSuperiors = null;
    private String[] overrideAddExperienceLevelInferiors = null;
    private String[] afterAddExperienceLevelSuperiors = null;
    private String[] afterAddExperienceLevelInferiors = null;
    private String[] beforeAddMovementStatSuperiors = null;
    private String[] beforeAddMovementStatInferiors = null;
    private String[] overrideAddMovementStatSuperiors = null;
    private String[] overrideAddMovementStatInferiors = null;
    private String[] afterAddMovementStatSuperiors = null;
    private String[] afterAddMovementStatInferiors = null;
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
    private String[] beforeClonePlayerSuperiors = null;
    private String[] beforeClonePlayerInferiors = null;
    private String[] overrideClonePlayerSuperiors = null;
    private String[] overrideClonePlayerInferiors = null;
    private String[] afterClonePlayerSuperiors = null;
    private String[] afterClonePlayerInferiors = null;
    private String[] beforeDamageEntitySuperiors = null;
    private String[] beforeDamageEntityInferiors = null;
    private String[] overrideDamageEntitySuperiors = null;
    private String[] overrideDamageEntityInferiors = null;
    private String[] afterDamageEntitySuperiors = null;
    private String[] afterDamageEntityInferiors = null;
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
    private String[] beforeFallSuperiors = null;
    private String[] beforeFallInferiors = null;
    private String[] overrideFallSuperiors = null;
    private String[] overrideFallInferiors = null;
    private String[] afterFallSuperiors = null;
    private String[] afterFallInferiors = null;
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
    private String[] beforeGetBrightnessSuperiors = null;
    private String[] beforeGetBrightnessInferiors = null;
    private String[] overrideGetBrightnessSuperiors = null;
    private String[] overrideGetBrightnessInferiors = null;
    private String[] afterGetBrightnessSuperiors = null;
    private String[] afterGetBrightnessInferiors = null;
    private String[] beforeGetEyeHeightSuperiors = null;
    private String[] beforeGetEyeHeightInferiors = null;
    private String[] overrideGetEyeHeightSuperiors = null;
    private String[] overrideGetEyeHeightInferiors = null;
    private String[] afterGetEyeHeightSuperiors = null;
    private String[] afterGetEyeHeightInferiors = null;
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
    private String[] beforeOnUpdateEntitySuperiors = null;
    private String[] beforeOnUpdateEntityInferiors = null;
    private String[] overrideOnUpdateEntitySuperiors = null;
    private String[] overrideOnUpdateEntityInferiors = null;
    private String[] afterOnUpdateEntitySuperiors = null;
    private String[] afterOnUpdateEntityInferiors = null;
    private String[] beforeReadEntityFromNBTSuperiors = null;
    private String[] beforeReadEntityFromNBTInferiors = null;
    private String[] overrideReadEntityFromNBTSuperiors = null;
    private String[] overrideReadEntityFromNBTInferiors = null;
    private String[] afterReadEntityFromNBTSuperiors = null;
    private String[] afterReadEntityFromNBTInferiors = null;
    private String[] beforeSetDeadSuperiors = null;
    private String[] beforeSetDeadInferiors = null;
    private String[] overrideSetDeadSuperiors = null;
    private String[] overrideSetDeadInferiors = null;
    private String[] afterSetDeadSuperiors = null;
    private String[] afterSetDeadInferiors = null;
    private String[] beforeSetPositionSuperiors = null;
    private String[] beforeSetPositionInferiors = null;
    private String[] overrideSetPositionSuperiors = null;
    private String[] overrideSetPositionInferiors = null;
    private String[] afterSetPositionSuperiors = null;
    private String[] afterSetPositionInferiors = null;
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
    private String[] beforeUpdatePotionEffectsSuperiors = null;
    private String[] beforeUpdatePotionEffectsInferiors = null;
    private String[] overrideUpdatePotionEffectsSuperiors = null;
    private String[] overrideUpdatePotionEffectsInferiors = null;
    private String[] afterUpdatePotionEffectsSuperiors = null;
    private String[] afterUpdatePotionEffectsInferiors = null;
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

    public String[] getBeforeAddExperienceSuperiors() {
        return this.beforeAddExperienceSuperiors;
    }

    public String[] getBeforeAddExperienceInferiors() {
        return this.beforeAddExperienceInferiors;
    }

    public String[] getOverrideAddExperienceSuperiors() {
        return this.overrideAddExperienceSuperiors;
    }

    public String[] getOverrideAddExperienceInferiors() {
        return this.overrideAddExperienceInferiors;
    }

    public String[] getAfterAddExperienceSuperiors() {
        return this.afterAddExperienceSuperiors;
    }

    public String[] getAfterAddExperienceInferiors() {
        return this.afterAddExperienceInferiors;
    }

    public void setBeforeAddExperienceSuperiors(String[] stringArray) {
        this.beforeAddExperienceSuperiors = stringArray;
    }

    public void setBeforeAddExperienceInferiors(String[] stringArray) {
        this.beforeAddExperienceInferiors = stringArray;
    }

    public void setOverrideAddExperienceSuperiors(String[] stringArray) {
        this.overrideAddExperienceSuperiors = stringArray;
    }

    public void setOverrideAddExperienceInferiors(String[] stringArray) {
        this.overrideAddExperienceInferiors = stringArray;
    }

    public void setAfterAddExperienceSuperiors(String[] stringArray) {
        this.afterAddExperienceSuperiors = stringArray;
    }

    public void setAfterAddExperienceInferiors(String[] stringArray) {
        this.afterAddExperienceInferiors = stringArray;
    }

    public String[] getBeforeAddExperienceLevelSuperiors() {
        return this.beforeAddExperienceLevelSuperiors;
    }

    public String[] getBeforeAddExperienceLevelInferiors() {
        return this.beforeAddExperienceLevelInferiors;
    }

    public String[] getOverrideAddExperienceLevelSuperiors() {
        return this.overrideAddExperienceLevelSuperiors;
    }

    public String[] getOverrideAddExperienceLevelInferiors() {
        return this.overrideAddExperienceLevelInferiors;
    }

    public String[] getAfterAddExperienceLevelSuperiors() {
        return this.afterAddExperienceLevelSuperiors;
    }

    public String[] getAfterAddExperienceLevelInferiors() {
        return this.afterAddExperienceLevelInferiors;
    }

    public void setBeforeAddExperienceLevelSuperiors(String[] stringArray) {
        this.beforeAddExperienceLevelSuperiors = stringArray;
    }

    public void setBeforeAddExperienceLevelInferiors(String[] stringArray) {
        this.beforeAddExperienceLevelInferiors = stringArray;
    }

    public void setOverrideAddExperienceLevelSuperiors(String[] stringArray) {
        this.overrideAddExperienceLevelSuperiors = stringArray;
    }

    public void setOverrideAddExperienceLevelInferiors(String[] stringArray) {
        this.overrideAddExperienceLevelInferiors = stringArray;
    }

    public void setAfterAddExperienceLevelSuperiors(String[] stringArray) {
        this.afterAddExperienceLevelSuperiors = stringArray;
    }

    public void setAfterAddExperienceLevelInferiors(String[] stringArray) {
        this.afterAddExperienceLevelInferiors = stringArray;
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

    public String[] getBeforeClonePlayerSuperiors() {
        return this.beforeClonePlayerSuperiors;
    }

    public String[] getBeforeClonePlayerInferiors() {
        return this.beforeClonePlayerInferiors;
    }

    public String[] getOverrideClonePlayerSuperiors() {
        return this.overrideClonePlayerSuperiors;
    }

    public String[] getOverrideClonePlayerInferiors() {
        return this.overrideClonePlayerInferiors;
    }

    public String[] getAfterClonePlayerSuperiors() {
        return this.afterClonePlayerSuperiors;
    }

    public String[] getAfterClonePlayerInferiors() {
        return this.afterClonePlayerInferiors;
    }

    public void setBeforeClonePlayerSuperiors(String[] stringArray) {
        this.beforeClonePlayerSuperiors = stringArray;
    }

    public void setBeforeClonePlayerInferiors(String[] stringArray) {
        this.beforeClonePlayerInferiors = stringArray;
    }

    public void setOverrideClonePlayerSuperiors(String[] stringArray) {
        this.overrideClonePlayerSuperiors = stringArray;
    }

    public void setOverrideClonePlayerInferiors(String[] stringArray) {
        this.overrideClonePlayerInferiors = stringArray;
    }

    public void setAfterClonePlayerSuperiors(String[] stringArray) {
        this.afterClonePlayerSuperiors = stringArray;
    }

    public void setAfterClonePlayerInferiors(String[] stringArray) {
        this.afterClonePlayerInferiors = stringArray;
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

    public String[] getBeforeGetEyeHeightSuperiors() {
        return this.beforeGetEyeHeightSuperiors;
    }

    public String[] getBeforeGetEyeHeightInferiors() {
        return this.beforeGetEyeHeightInferiors;
    }

    public String[] getOverrideGetEyeHeightSuperiors() {
        return this.overrideGetEyeHeightSuperiors;
    }

    public String[] getOverrideGetEyeHeightInferiors() {
        return this.overrideGetEyeHeightInferiors;
    }

    public String[] getAfterGetEyeHeightSuperiors() {
        return this.afterGetEyeHeightSuperiors;
    }

    public String[] getAfterGetEyeHeightInferiors() {
        return this.afterGetEyeHeightInferiors;
    }

    public void setBeforeGetEyeHeightSuperiors(String[] stringArray) {
        this.beforeGetEyeHeightSuperiors = stringArray;
    }

    public void setBeforeGetEyeHeightInferiors(String[] stringArray) {
        this.beforeGetEyeHeightInferiors = stringArray;
    }

    public void setOverrideGetEyeHeightSuperiors(String[] stringArray) {
        this.overrideGetEyeHeightSuperiors = stringArray;
    }

    public void setOverrideGetEyeHeightInferiors(String[] stringArray) {
        this.overrideGetEyeHeightInferiors = stringArray;
    }

    public void setAfterGetEyeHeightSuperiors(String[] stringArray) {
        this.afterGetEyeHeightSuperiors = stringArray;
    }

    public void setAfterGetEyeHeightInferiors(String[] stringArray) {
        this.afterGetEyeHeightInferiors = stringArray;
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

    public String[] getBeforeOnUpdateEntitySuperiors() {
        return this.beforeOnUpdateEntitySuperiors;
    }

    public String[] getBeforeOnUpdateEntityInferiors() {
        return this.beforeOnUpdateEntityInferiors;
    }

    public String[] getOverrideOnUpdateEntitySuperiors() {
        return this.overrideOnUpdateEntitySuperiors;
    }

    public String[] getOverrideOnUpdateEntityInferiors() {
        return this.overrideOnUpdateEntityInferiors;
    }

    public String[] getAfterOnUpdateEntitySuperiors() {
        return this.afterOnUpdateEntitySuperiors;
    }

    public String[] getAfterOnUpdateEntityInferiors() {
        return this.afterOnUpdateEntityInferiors;
    }

    public void setBeforeOnUpdateEntitySuperiors(String[] stringArray) {
        this.beforeOnUpdateEntitySuperiors = stringArray;
    }

    public void setBeforeOnUpdateEntityInferiors(String[] stringArray) {
        this.beforeOnUpdateEntityInferiors = stringArray;
    }

    public void setOverrideOnUpdateEntitySuperiors(String[] stringArray) {
        this.overrideOnUpdateEntitySuperiors = stringArray;
    }

    public void setOverrideOnUpdateEntityInferiors(String[] stringArray) {
        this.overrideOnUpdateEntityInferiors = stringArray;
    }

    public void setAfterOnUpdateEntitySuperiors(String[] stringArray) {
        this.afterOnUpdateEntitySuperiors = stringArray;
    }

    public void setAfterOnUpdateEntityInferiors(String[] stringArray) {
        this.afterOnUpdateEntityInferiors = stringArray;
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

    public String[] getBeforeSetPositionSuperiors() {
        return this.beforeSetPositionSuperiors;
    }

    public String[] getBeforeSetPositionInferiors() {
        return this.beforeSetPositionInferiors;
    }

    public String[] getOverrideSetPositionSuperiors() {
        return this.overrideSetPositionSuperiors;
    }

    public String[] getOverrideSetPositionInferiors() {
        return this.overrideSetPositionInferiors;
    }

    public String[] getAfterSetPositionSuperiors() {
        return this.afterSetPositionSuperiors;
    }

    public String[] getAfterSetPositionInferiors() {
        return this.afterSetPositionInferiors;
    }

    public void setBeforeSetPositionSuperiors(String[] stringArray) {
        this.beforeSetPositionSuperiors = stringArray;
    }

    public void setBeforeSetPositionInferiors(String[] stringArray) {
        this.beforeSetPositionInferiors = stringArray;
    }

    public void setOverrideSetPositionSuperiors(String[] stringArray) {
        this.overrideSetPositionSuperiors = stringArray;
    }

    public void setOverrideSetPositionInferiors(String[] stringArray) {
        this.overrideSetPositionInferiors = stringArray;
    }

    public void setAfterSetPositionSuperiors(String[] stringArray) {
        this.afterSetPositionSuperiors = stringArray;
    }

    public void setAfterSetPositionInferiors(String[] stringArray) {
        this.afterSetPositionInferiors = stringArray;
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

    public String[] getBeforeUpdatePotionEffectsSuperiors() {
        return this.beforeUpdatePotionEffectsSuperiors;
    }

    public String[] getBeforeUpdatePotionEffectsInferiors() {
        return this.beforeUpdatePotionEffectsInferiors;
    }

    public String[] getOverrideUpdatePotionEffectsSuperiors() {
        return this.overrideUpdatePotionEffectsSuperiors;
    }

    public String[] getOverrideUpdatePotionEffectsInferiors() {
        return this.overrideUpdatePotionEffectsInferiors;
    }

    public String[] getAfterUpdatePotionEffectsSuperiors() {
        return this.afterUpdatePotionEffectsSuperiors;
    }

    public String[] getAfterUpdatePotionEffectsInferiors() {
        return this.afterUpdatePotionEffectsInferiors;
    }

    public void setBeforeUpdatePotionEffectsSuperiors(String[] stringArray) {
        this.beforeUpdatePotionEffectsSuperiors = stringArray;
    }

    public void setBeforeUpdatePotionEffectsInferiors(String[] stringArray) {
        this.beforeUpdatePotionEffectsInferiors = stringArray;
    }

    public void setOverrideUpdatePotionEffectsSuperiors(String[] stringArray) {
        this.overrideUpdatePotionEffectsSuperiors = stringArray;
    }

    public void setOverrideUpdatePotionEffectsInferiors(String[] stringArray) {
        this.overrideUpdatePotionEffectsInferiors = stringArray;
    }

    public void setAfterUpdatePotionEffectsSuperiors(String[] stringArray) {
        this.afterUpdatePotionEffectsSuperiors = stringArray;
    }

    public void setAfterUpdatePotionEffectsInferiors(String[] stringArray) {
        this.afterUpdatePotionEffectsInferiors = stringArray;
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

