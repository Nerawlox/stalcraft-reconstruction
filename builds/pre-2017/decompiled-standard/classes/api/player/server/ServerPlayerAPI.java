/*
 * Decompiled with CFR 0.152.
 */
package api.player.server;

import api.player.server.IServerPlayerAPI;
import api.player.server.ServerPlayerBase;
import api.player.server.ServerPlayerBaseSorter;
import api.player.server.ServerPlayerBaseSorting;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.jxtc;

public final class ServerPlayerAPI {
    private static final Class<?>[] Class = new Class[]{ServerPlayerAPI.class};
    private static final Class<?>[] Classes = new Class[]{ServerPlayerAPI.class, String.class};
    private static boolean isCreated;
    private static final Logger logger;
    private static final Map<String, String[]> EmptySortMap;
    private static final List<String> beforeAddExhaustionHookTypes;
    private static final List<String> overrideAddExhaustionHookTypes;
    private static final List<String> afterAddExhaustionHookTypes;
    private ServerPlayerBase[] beforeAddExhaustionHooks;
    private ServerPlayerBase[] overrideAddExhaustionHooks;
    private ServerPlayerBase[] afterAddExhaustionHooks;
    public boolean isAddExhaustionModded;
    private static final Map<String, String[]> allBaseBeforeAddExhaustionSuperiors;
    private static final Map<String, String[]> allBaseBeforeAddExhaustionInferiors;
    private static final Map<String, String[]> allBaseOverrideAddExhaustionSuperiors;
    private static final Map<String, String[]> allBaseOverrideAddExhaustionInferiors;
    private static final Map<String, String[]> allBaseAfterAddExhaustionSuperiors;
    private static final Map<String, String[]> allBaseAfterAddExhaustionInferiors;
    private static final List<String> beforeAddExperienceHookTypes;
    private static final List<String> overrideAddExperienceHookTypes;
    private static final List<String> afterAddExperienceHookTypes;
    private ServerPlayerBase[] beforeAddExperienceHooks;
    private ServerPlayerBase[] overrideAddExperienceHooks;
    private ServerPlayerBase[] afterAddExperienceHooks;
    public boolean isAddExperienceModded;
    private static final Map<String, String[]> allBaseBeforeAddExperienceSuperiors;
    private static final Map<String, String[]> allBaseBeforeAddExperienceInferiors;
    private static final Map<String, String[]> allBaseOverrideAddExperienceSuperiors;
    private static final Map<String, String[]> allBaseOverrideAddExperienceInferiors;
    private static final Map<String, String[]> allBaseAfterAddExperienceSuperiors;
    private static final Map<String, String[]> allBaseAfterAddExperienceInferiors;
    private static final List<String> beforeAddExperienceLevelHookTypes;
    private static final List<String> overrideAddExperienceLevelHookTypes;
    private static final List<String> afterAddExperienceLevelHookTypes;
    private ServerPlayerBase[] beforeAddExperienceLevelHooks;
    private ServerPlayerBase[] overrideAddExperienceLevelHooks;
    private ServerPlayerBase[] afterAddExperienceLevelHooks;
    public boolean isAddExperienceLevelModded;
    private static final Map<String, String[]> allBaseBeforeAddExperienceLevelSuperiors;
    private static final Map<String, String[]> allBaseBeforeAddExperienceLevelInferiors;
    private static final Map<String, String[]> allBaseOverrideAddExperienceLevelSuperiors;
    private static final Map<String, String[]> allBaseOverrideAddExperienceLevelInferiors;
    private static final Map<String, String[]> allBaseAfterAddExperienceLevelSuperiors;
    private static final Map<String, String[]> allBaseAfterAddExperienceLevelInferiors;
    private static final List<String> beforeAddMovementStatHookTypes;
    private static final List<String> overrideAddMovementStatHookTypes;
    private static final List<String> afterAddMovementStatHookTypes;
    private ServerPlayerBase[] beforeAddMovementStatHooks;
    private ServerPlayerBase[] overrideAddMovementStatHooks;
    private ServerPlayerBase[] afterAddMovementStatHooks;
    public boolean isAddMovementStatModded;
    private static final Map<String, String[]> allBaseBeforeAddMovementStatSuperiors;
    private static final Map<String, String[]> allBaseBeforeAddMovementStatInferiors;
    private static final Map<String, String[]> allBaseOverrideAddMovementStatSuperiors;
    private static final Map<String, String[]> allBaseOverrideAddMovementStatInferiors;
    private static final Map<String, String[]> allBaseAfterAddMovementStatSuperiors;
    private static final Map<String, String[]> allBaseAfterAddMovementStatInferiors;
    private static final List<String> beforeAttackEntityFromHookTypes;
    private static final List<String> overrideAttackEntityFromHookTypes;
    private static final List<String> afterAttackEntityFromHookTypes;
    private ServerPlayerBase[] beforeAttackEntityFromHooks;
    private ServerPlayerBase[] overrideAttackEntityFromHooks;
    private ServerPlayerBase[] afterAttackEntityFromHooks;
    public boolean isAttackEntityFromModded;
    private static final Map<String, String[]> allBaseBeforeAttackEntityFromSuperiors;
    private static final Map<String, String[]> allBaseBeforeAttackEntityFromInferiors;
    private static final Map<String, String[]> allBaseOverrideAttackEntityFromSuperiors;
    private static final Map<String, String[]> allBaseOverrideAttackEntityFromInferiors;
    private static final Map<String, String[]> allBaseAfterAttackEntityFromSuperiors;
    private static final Map<String, String[]> allBaseAfterAttackEntityFromInferiors;
    private static final List<String> beforeAttackTargetEntityWithCurrentItemHookTypes;
    private static final List<String> overrideAttackTargetEntityWithCurrentItemHookTypes;
    private static final List<String> afterAttackTargetEntityWithCurrentItemHookTypes;
    private ServerPlayerBase[] beforeAttackTargetEntityWithCurrentItemHooks;
    private ServerPlayerBase[] overrideAttackTargetEntityWithCurrentItemHooks;
    private ServerPlayerBase[] afterAttackTargetEntityWithCurrentItemHooks;
    public boolean isAttackTargetEntityWithCurrentItemModded;
    private static final Map<String, String[]> allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors;
    private static final Map<String, String[]> allBaseBeforeAttackTargetEntityWithCurrentItemInferiors;
    private static final Map<String, String[]> allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors;
    private static final Map<String, String[]> allBaseOverrideAttackTargetEntityWithCurrentItemInferiors;
    private static final Map<String, String[]> allBaseAfterAttackTargetEntityWithCurrentItemSuperiors;
    private static final Map<String, String[]> allBaseAfterAttackTargetEntityWithCurrentItemInferiors;
    private static final List<String> beforeCanHarvestBlockHookTypes;
    private static final List<String> overrideCanHarvestBlockHookTypes;
    private static final List<String> afterCanHarvestBlockHookTypes;
    private ServerPlayerBase[] beforeCanHarvestBlockHooks;
    private ServerPlayerBase[] overrideCanHarvestBlockHooks;
    private ServerPlayerBase[] afterCanHarvestBlockHooks;
    public boolean isCanHarvestBlockModded;
    private static final Map<String, String[]> allBaseBeforeCanHarvestBlockSuperiors;
    private static final Map<String, String[]> allBaseBeforeCanHarvestBlockInferiors;
    private static final Map<String, String[]> allBaseOverrideCanHarvestBlockSuperiors;
    private static final Map<String, String[]> allBaseOverrideCanHarvestBlockInferiors;
    private static final Map<String, String[]> allBaseAfterCanHarvestBlockSuperiors;
    private static final Map<String, String[]> allBaseAfterCanHarvestBlockInferiors;
    private static final List<String> beforeCanPlayerEditHookTypes;
    private static final List<String> overrideCanPlayerEditHookTypes;
    private static final List<String> afterCanPlayerEditHookTypes;
    private ServerPlayerBase[] beforeCanPlayerEditHooks;
    private ServerPlayerBase[] overrideCanPlayerEditHooks;
    private ServerPlayerBase[] afterCanPlayerEditHooks;
    public boolean isCanPlayerEditModded;
    private static final Map<String, String[]> allBaseBeforeCanPlayerEditSuperiors;
    private static final Map<String, String[]> allBaseBeforeCanPlayerEditInferiors;
    private static final Map<String, String[]> allBaseOverrideCanPlayerEditSuperiors;
    private static final Map<String, String[]> allBaseOverrideCanPlayerEditInferiors;
    private static final Map<String, String[]> allBaseAfterCanPlayerEditSuperiors;
    private static final Map<String, String[]> allBaseAfterCanPlayerEditInferiors;
    private static final List<String> beforeCanTriggerWalkingHookTypes;
    private static final List<String> overrideCanTriggerWalkingHookTypes;
    private static final List<String> afterCanTriggerWalkingHookTypes;
    private ServerPlayerBase[] beforeCanTriggerWalkingHooks;
    private ServerPlayerBase[] overrideCanTriggerWalkingHooks;
    private ServerPlayerBase[] afterCanTriggerWalkingHooks;
    public boolean isCanTriggerWalkingModded;
    private static final Map<String, String[]> allBaseBeforeCanTriggerWalkingSuperiors;
    private static final Map<String, String[]> allBaseBeforeCanTriggerWalkingInferiors;
    private static final Map<String, String[]> allBaseOverrideCanTriggerWalkingSuperiors;
    private static final Map<String, String[]> allBaseOverrideCanTriggerWalkingInferiors;
    private static final Map<String, String[]> allBaseAfterCanTriggerWalkingSuperiors;
    private static final Map<String, String[]> allBaseAfterCanTriggerWalkingInferiors;
    private static final List<String> beforeClonePlayerHookTypes;
    private static final List<String> overrideClonePlayerHookTypes;
    private static final List<String> afterClonePlayerHookTypes;
    private ServerPlayerBase[] beforeClonePlayerHooks;
    private ServerPlayerBase[] overrideClonePlayerHooks;
    private ServerPlayerBase[] afterClonePlayerHooks;
    public boolean isClonePlayerModded;
    private static final Map<String, String[]> allBaseBeforeClonePlayerSuperiors;
    private static final Map<String, String[]> allBaseBeforeClonePlayerInferiors;
    private static final Map<String, String[]> allBaseOverrideClonePlayerSuperiors;
    private static final Map<String, String[]> allBaseOverrideClonePlayerInferiors;
    private static final Map<String, String[]> allBaseAfterClonePlayerSuperiors;
    private static final Map<String, String[]> allBaseAfterClonePlayerInferiors;
    private static final List<String> beforeDamageEntityHookTypes;
    private static final List<String> overrideDamageEntityHookTypes;
    private static final List<String> afterDamageEntityHookTypes;
    private ServerPlayerBase[] beforeDamageEntityHooks;
    private ServerPlayerBase[] overrideDamageEntityHooks;
    private ServerPlayerBase[] afterDamageEntityHooks;
    public boolean isDamageEntityModded;
    private static final Map<String, String[]> allBaseBeforeDamageEntitySuperiors;
    private static final Map<String, String[]> allBaseBeforeDamageEntityInferiors;
    private static final Map<String, String[]> allBaseOverrideDamageEntitySuperiors;
    private static final Map<String, String[]> allBaseOverrideDamageEntityInferiors;
    private static final Map<String, String[]> allBaseAfterDamageEntitySuperiors;
    private static final Map<String, String[]> allBaseAfterDamageEntityInferiors;
    private static final List<String> beforeDisplayGUIChestHookTypes;
    private static final List<String> overrideDisplayGUIChestHookTypes;
    private static final List<String> afterDisplayGUIChestHookTypes;
    private ServerPlayerBase[] beforeDisplayGUIChestHooks;
    private ServerPlayerBase[] overrideDisplayGUIChestHooks;
    private ServerPlayerBase[] afterDisplayGUIChestHooks;
    public boolean isDisplayGUIChestModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIChestSuperiors;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIChestInferiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIChestSuperiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIChestInferiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIChestSuperiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIChestInferiors;
    private static final List<String> beforeDisplayGUIDispenserHookTypes;
    private static final List<String> overrideDisplayGUIDispenserHookTypes;
    private static final List<String> afterDisplayGUIDispenserHookTypes;
    private ServerPlayerBase[] beforeDisplayGUIDispenserHooks;
    private ServerPlayerBase[] overrideDisplayGUIDispenserHooks;
    private ServerPlayerBase[] afterDisplayGUIDispenserHooks;
    public boolean isDisplayGUIDispenserModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIDispenserSuperiors;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIDispenserInferiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIDispenserSuperiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIDispenserInferiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIDispenserSuperiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIDispenserInferiors;
    private static final List<String> beforeDisplayGUIFurnaceHookTypes;
    private static final List<String> overrideDisplayGUIFurnaceHookTypes;
    private static final List<String> afterDisplayGUIFurnaceHookTypes;
    private ServerPlayerBase[] beforeDisplayGUIFurnaceHooks;
    private ServerPlayerBase[] overrideDisplayGUIFurnaceHooks;
    private ServerPlayerBase[] afterDisplayGUIFurnaceHooks;
    public boolean isDisplayGUIFurnaceModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIFurnaceSuperiors;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIFurnaceInferiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIFurnaceSuperiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIFurnaceInferiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIFurnaceSuperiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIFurnaceInferiors;
    private static final List<String> beforeDisplayGUIWorkbenchHookTypes;
    private static final List<String> overrideDisplayGUIWorkbenchHookTypes;
    private static final List<String> afterDisplayGUIWorkbenchHookTypes;
    private ServerPlayerBase[] beforeDisplayGUIWorkbenchHooks;
    private ServerPlayerBase[] overrideDisplayGUIWorkbenchHooks;
    private ServerPlayerBase[] afterDisplayGUIWorkbenchHooks;
    public boolean isDisplayGUIWorkbenchModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIWorkbenchSuperiors;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIWorkbenchInferiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIWorkbenchSuperiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIWorkbenchInferiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIWorkbenchSuperiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIWorkbenchInferiors;
    private static final List<String> beforeDropOneItemHookTypes;
    private static final List<String> overrideDropOneItemHookTypes;
    private static final List<String> afterDropOneItemHookTypes;
    private ServerPlayerBase[] beforeDropOneItemHooks;
    private ServerPlayerBase[] overrideDropOneItemHooks;
    private ServerPlayerBase[] afterDropOneItemHooks;
    public boolean isDropOneItemModded;
    private static final Map<String, String[]> allBaseBeforeDropOneItemSuperiors;
    private static final Map<String, String[]> allBaseBeforeDropOneItemInferiors;
    private static final Map<String, String[]> allBaseOverrideDropOneItemSuperiors;
    private static final Map<String, String[]> allBaseOverrideDropOneItemInferiors;
    private static final Map<String, String[]> allBaseAfterDropOneItemSuperiors;
    private static final Map<String, String[]> allBaseAfterDropOneItemInferiors;
    private static final List<String> beforeDropPlayerItemHookTypes;
    private static final List<String> overrideDropPlayerItemHookTypes;
    private static final List<String> afterDropPlayerItemHookTypes;
    private ServerPlayerBase[] beforeDropPlayerItemHooks;
    private ServerPlayerBase[] overrideDropPlayerItemHooks;
    private ServerPlayerBase[] afterDropPlayerItemHooks;
    public boolean isDropPlayerItemModded;
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemSuperiors;
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemInferiors;
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemSuperiors;
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemInferiors;
    private static final Map<String, String[]> allBaseAfterDropPlayerItemSuperiors;
    private static final Map<String, String[]> allBaseAfterDropPlayerItemInferiors;
    private static final List<String> beforeFallHookTypes;
    private static final List<String> overrideFallHookTypes;
    private static final List<String> afterFallHookTypes;
    private ServerPlayerBase[] beforeFallHooks;
    private ServerPlayerBase[] overrideFallHooks;
    private ServerPlayerBase[] afterFallHooks;
    public boolean isFallModded;
    private static final Map<String, String[]> allBaseBeforeFallSuperiors;
    private static final Map<String, String[]> allBaseBeforeFallInferiors;
    private static final Map<String, String[]> allBaseOverrideFallSuperiors;
    private static final Map<String, String[]> allBaseOverrideFallInferiors;
    private static final Map<String, String[]> allBaseAfterFallSuperiors;
    private static final Map<String, String[]> allBaseAfterFallInferiors;
    private static final List<String> beforeGetCurrentPlayerStrVsBlockHookTypes;
    private static final List<String> overrideGetCurrentPlayerStrVsBlockHookTypes;
    private static final List<String> afterGetCurrentPlayerStrVsBlockHookTypes;
    private ServerPlayerBase[] beforeGetCurrentPlayerStrVsBlockHooks;
    private ServerPlayerBase[] overrideGetCurrentPlayerStrVsBlockHooks;
    private ServerPlayerBase[] afterGetCurrentPlayerStrVsBlockHooks;
    public boolean isGetCurrentPlayerStrVsBlockModded;
    private static final Map<String, String[]> allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetCurrentPlayerStrVsBlockInferiors;
    private static final Map<String, String[]> allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetCurrentPlayerStrVsBlockInferiors;
    private static final Map<String, String[]> allBaseAfterGetCurrentPlayerStrVsBlockSuperiors;
    private static final Map<String, String[]> allBaseAfterGetCurrentPlayerStrVsBlockInferiors;
    private static final List<String> beforeGetCurrentPlayerStrVsBlockForgeHookTypes;
    private static final List<String> overrideGetCurrentPlayerStrVsBlockForgeHookTypes;
    private static final List<String> afterGetCurrentPlayerStrVsBlockForgeHookTypes;
    private ServerPlayerBase[] beforeGetCurrentPlayerStrVsBlockForgeHooks;
    private ServerPlayerBase[] overrideGetCurrentPlayerStrVsBlockForgeHooks;
    private ServerPlayerBase[] afterGetCurrentPlayerStrVsBlockForgeHooks;
    public boolean isGetCurrentPlayerStrVsBlockForgeModded;
    private static final Map<String, String[]> allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors;
    private static final Map<String, String[]> allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors;
    private static final Map<String, String[]> allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors;
    private static final Map<String, String[]> allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors;
    private static final List<String> beforeGetDistanceSqHookTypes;
    private static final List<String> overrideGetDistanceSqHookTypes;
    private static final List<String> afterGetDistanceSqHookTypes;
    private ServerPlayerBase[] beforeGetDistanceSqHooks;
    private ServerPlayerBase[] overrideGetDistanceSqHooks;
    private ServerPlayerBase[] afterGetDistanceSqHooks;
    public boolean isGetDistanceSqModded;
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqInferiors;
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqInferiors;
    private static final Map<String, String[]> allBaseAfterGetDistanceSqSuperiors;
    private static final Map<String, String[]> allBaseAfterGetDistanceSqInferiors;
    private static final List<String> beforeGetBrightnessHookTypes;
    private static final List<String> overrideGetBrightnessHookTypes;
    private static final List<String> afterGetBrightnessHookTypes;
    private ServerPlayerBase[] beforeGetBrightnessHooks;
    private ServerPlayerBase[] overrideGetBrightnessHooks;
    private ServerPlayerBase[] afterGetBrightnessHooks;
    public boolean isGetBrightnessModded;
    private static final Map<String, String[]> allBaseBeforeGetBrightnessSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetBrightnessInferiors;
    private static final Map<String, String[]> allBaseOverrideGetBrightnessSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetBrightnessInferiors;
    private static final Map<String, String[]> allBaseAfterGetBrightnessSuperiors;
    private static final Map<String, String[]> allBaseAfterGetBrightnessInferiors;
    private static final List<String> beforeGetEyeHeightHookTypes;
    private static final List<String> overrideGetEyeHeightHookTypes;
    private static final List<String> afterGetEyeHeightHookTypes;
    private ServerPlayerBase[] beforeGetEyeHeightHooks;
    private ServerPlayerBase[] overrideGetEyeHeightHooks;
    private ServerPlayerBase[] afterGetEyeHeightHooks;
    public boolean isGetEyeHeightModded;
    private static final Map<String, String[]> allBaseBeforeGetEyeHeightSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetEyeHeightInferiors;
    private static final Map<String, String[]> allBaseOverrideGetEyeHeightSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetEyeHeightInferiors;
    private static final Map<String, String[]> allBaseAfterGetEyeHeightSuperiors;
    private static final Map<String, String[]> allBaseAfterGetEyeHeightInferiors;
    private static final List<String> beforeHealHookTypes;
    private static final List<String> overrideHealHookTypes;
    private static final List<String> afterHealHookTypes;
    private ServerPlayerBase[] beforeHealHooks;
    private ServerPlayerBase[] overrideHealHooks;
    private ServerPlayerBase[] afterHealHooks;
    public boolean isHealModded;
    private static final Map<String, String[]> allBaseBeforeHealSuperiors;
    private static final Map<String, String[]> allBaseBeforeHealInferiors;
    private static final Map<String, String[]> allBaseOverrideHealSuperiors;
    private static final Map<String, String[]> allBaseOverrideHealInferiors;
    private static final Map<String, String[]> allBaseAfterHealSuperiors;
    private static final Map<String, String[]> allBaseAfterHealInferiors;
    private static final List<String> beforeIsEntityInsideOpaqueBlockHookTypes;
    private static final List<String> overrideIsEntityInsideOpaqueBlockHookTypes;
    private static final List<String> afterIsEntityInsideOpaqueBlockHookTypes;
    private ServerPlayerBase[] beforeIsEntityInsideOpaqueBlockHooks;
    private ServerPlayerBase[] overrideIsEntityInsideOpaqueBlockHooks;
    private ServerPlayerBase[] afterIsEntityInsideOpaqueBlockHooks;
    public boolean isIsEntityInsideOpaqueBlockModded;
    private static final Map<String, String[]> allBaseBeforeIsEntityInsideOpaqueBlockSuperiors;
    private static final Map<String, String[]> allBaseBeforeIsEntityInsideOpaqueBlockInferiors;
    private static final Map<String, String[]> allBaseOverrideIsEntityInsideOpaqueBlockSuperiors;
    private static final Map<String, String[]> allBaseOverrideIsEntityInsideOpaqueBlockInferiors;
    private static final Map<String, String[]> allBaseAfterIsEntityInsideOpaqueBlockSuperiors;
    private static final Map<String, String[]> allBaseAfterIsEntityInsideOpaqueBlockInferiors;
    private static final List<String> beforeIsInWaterHookTypes;
    private static final List<String> overrideIsInWaterHookTypes;
    private static final List<String> afterIsInWaterHookTypes;
    private ServerPlayerBase[] beforeIsInWaterHooks;
    private ServerPlayerBase[] overrideIsInWaterHooks;
    private ServerPlayerBase[] afterIsInWaterHooks;
    public boolean isIsInWaterModded;
    private static final Map<String, String[]> allBaseBeforeIsInWaterSuperiors;
    private static final Map<String, String[]> allBaseBeforeIsInWaterInferiors;
    private static final Map<String, String[]> allBaseOverrideIsInWaterSuperiors;
    private static final Map<String, String[]> allBaseOverrideIsInWaterInferiors;
    private static final Map<String, String[]> allBaseAfterIsInWaterSuperiors;
    private static final Map<String, String[]> allBaseAfterIsInWaterInferiors;
    private static final List<String> beforeIsInsideOfMaterialHookTypes;
    private static final List<String> overrideIsInsideOfMaterialHookTypes;
    private static final List<String> afterIsInsideOfMaterialHookTypes;
    private ServerPlayerBase[] beforeIsInsideOfMaterialHooks;
    private ServerPlayerBase[] overrideIsInsideOfMaterialHooks;
    private ServerPlayerBase[] afterIsInsideOfMaterialHooks;
    public boolean isIsInsideOfMaterialModded;
    private static final Map<String, String[]> allBaseBeforeIsInsideOfMaterialSuperiors;
    private static final Map<String, String[]> allBaseBeforeIsInsideOfMaterialInferiors;
    private static final Map<String, String[]> allBaseOverrideIsInsideOfMaterialSuperiors;
    private static final Map<String, String[]> allBaseOverrideIsInsideOfMaterialInferiors;
    private static final Map<String, String[]> allBaseAfterIsInsideOfMaterialSuperiors;
    private static final Map<String, String[]> allBaseAfterIsInsideOfMaterialInferiors;
    private static final List<String> beforeIsOnLadderHookTypes;
    private static final List<String> overrideIsOnLadderHookTypes;
    private static final List<String> afterIsOnLadderHookTypes;
    private ServerPlayerBase[] beforeIsOnLadderHooks;
    private ServerPlayerBase[] overrideIsOnLadderHooks;
    private ServerPlayerBase[] afterIsOnLadderHooks;
    public boolean isIsOnLadderModded;
    private static final Map<String, String[]> allBaseBeforeIsOnLadderSuperiors;
    private static final Map<String, String[]> allBaseBeforeIsOnLadderInferiors;
    private static final Map<String, String[]> allBaseOverrideIsOnLadderSuperiors;
    private static final Map<String, String[]> allBaseOverrideIsOnLadderInferiors;
    private static final Map<String, String[]> allBaseAfterIsOnLadderSuperiors;
    private static final Map<String, String[]> allBaseAfterIsOnLadderInferiors;
    private static final List<String> beforeIsPlayerSleepingHookTypes;
    private static final List<String> overrideIsPlayerSleepingHookTypes;
    private static final List<String> afterIsPlayerSleepingHookTypes;
    private ServerPlayerBase[] beforeIsPlayerSleepingHooks;
    private ServerPlayerBase[] overrideIsPlayerSleepingHooks;
    private ServerPlayerBase[] afterIsPlayerSleepingHooks;
    public boolean isIsPlayerSleepingModded;
    private static final Map<String, String[]> allBaseBeforeIsPlayerSleepingSuperiors;
    private static final Map<String, String[]> allBaseBeforeIsPlayerSleepingInferiors;
    private static final Map<String, String[]> allBaseOverrideIsPlayerSleepingSuperiors;
    private static final Map<String, String[]> allBaseOverrideIsPlayerSleepingInferiors;
    private static final Map<String, String[]> allBaseAfterIsPlayerSleepingSuperiors;
    private static final Map<String, String[]> allBaseAfterIsPlayerSleepingInferiors;
    private static final List<String> beforeJumpHookTypes;
    private static final List<String> overrideJumpHookTypes;
    private static final List<String> afterJumpHookTypes;
    private ServerPlayerBase[] beforeJumpHooks;
    private ServerPlayerBase[] overrideJumpHooks;
    private ServerPlayerBase[] afterJumpHooks;
    public boolean isJumpModded;
    private static final Map<String, String[]> allBaseBeforeJumpSuperiors;
    private static final Map<String, String[]> allBaseBeforeJumpInferiors;
    private static final Map<String, String[]> allBaseOverrideJumpSuperiors;
    private static final Map<String, String[]> allBaseOverrideJumpInferiors;
    private static final Map<String, String[]> allBaseAfterJumpSuperiors;
    private static final Map<String, String[]> allBaseAfterJumpInferiors;
    private static final List<String> beforeKnockBackHookTypes;
    private static final List<String> overrideKnockBackHookTypes;
    private static final List<String> afterKnockBackHookTypes;
    private ServerPlayerBase[] beforeKnockBackHooks;
    private ServerPlayerBase[] overrideKnockBackHooks;
    private ServerPlayerBase[] afterKnockBackHooks;
    public boolean isKnockBackModded;
    private static final Map<String, String[]> allBaseBeforeKnockBackSuperiors;
    private static final Map<String, String[]> allBaseBeforeKnockBackInferiors;
    private static final Map<String, String[]> allBaseOverrideKnockBackSuperiors;
    private static final Map<String, String[]> allBaseOverrideKnockBackInferiors;
    private static final Map<String, String[]> allBaseAfterKnockBackSuperiors;
    private static final Map<String, String[]> allBaseAfterKnockBackInferiors;
    private static final List<String> beforeMoveEntityHookTypes;
    private static final List<String> overrideMoveEntityHookTypes;
    private static final List<String> afterMoveEntityHookTypes;
    private ServerPlayerBase[] beforeMoveEntityHooks;
    private ServerPlayerBase[] overrideMoveEntityHooks;
    private ServerPlayerBase[] afterMoveEntityHooks;
    public boolean isMoveEntityModded;
    private static final Map<String, String[]> allBaseBeforeMoveEntitySuperiors;
    private static final Map<String, String[]> allBaseBeforeMoveEntityInferiors;
    private static final Map<String, String[]> allBaseOverrideMoveEntitySuperiors;
    private static final Map<String, String[]> allBaseOverrideMoveEntityInferiors;
    private static final Map<String, String[]> allBaseAfterMoveEntitySuperiors;
    private static final Map<String, String[]> allBaseAfterMoveEntityInferiors;
    private static final List<String> beforeMoveEntityWithHeadingHookTypes;
    private static final List<String> overrideMoveEntityWithHeadingHookTypes;
    private static final List<String> afterMoveEntityWithHeadingHookTypes;
    private ServerPlayerBase[] beforeMoveEntityWithHeadingHooks;
    private ServerPlayerBase[] overrideMoveEntityWithHeadingHooks;
    private ServerPlayerBase[] afterMoveEntityWithHeadingHooks;
    public boolean isMoveEntityWithHeadingModded;
    private static final Map<String, String[]> allBaseBeforeMoveEntityWithHeadingSuperiors;
    private static final Map<String, String[]> allBaseBeforeMoveEntityWithHeadingInferiors;
    private static final Map<String, String[]> allBaseOverrideMoveEntityWithHeadingSuperiors;
    private static final Map<String, String[]> allBaseOverrideMoveEntityWithHeadingInferiors;
    private static final Map<String, String[]> allBaseAfterMoveEntityWithHeadingSuperiors;
    private static final Map<String, String[]> allBaseAfterMoveEntityWithHeadingInferiors;
    private static final List<String> beforeMoveFlyingHookTypes;
    private static final List<String> overrideMoveFlyingHookTypes;
    private static final List<String> afterMoveFlyingHookTypes;
    private ServerPlayerBase[] beforeMoveFlyingHooks;
    private ServerPlayerBase[] overrideMoveFlyingHooks;
    private ServerPlayerBase[] afterMoveFlyingHooks;
    public boolean isMoveFlyingModded;
    private static final Map<String, String[]> allBaseBeforeMoveFlyingSuperiors;
    private static final Map<String, String[]> allBaseBeforeMoveFlyingInferiors;
    private static final Map<String, String[]> allBaseOverrideMoveFlyingSuperiors;
    private static final Map<String, String[]> allBaseOverrideMoveFlyingInferiors;
    private static final Map<String, String[]> allBaseAfterMoveFlyingSuperiors;
    private static final Map<String, String[]> allBaseAfterMoveFlyingInferiors;
    private static final List<String> beforeOnDeathHookTypes;
    private static final List<String> overrideOnDeathHookTypes;
    private static final List<String> afterOnDeathHookTypes;
    private ServerPlayerBase[] beforeOnDeathHooks;
    private ServerPlayerBase[] overrideOnDeathHooks;
    private ServerPlayerBase[] afterOnDeathHooks;
    public boolean isOnDeathModded;
    private static final Map<String, String[]> allBaseBeforeOnDeathSuperiors;
    private static final Map<String, String[]> allBaseBeforeOnDeathInferiors;
    private static final Map<String, String[]> allBaseOverrideOnDeathSuperiors;
    private static final Map<String, String[]> allBaseOverrideOnDeathInferiors;
    private static final Map<String, String[]> allBaseAfterOnDeathSuperiors;
    private static final Map<String, String[]> allBaseAfterOnDeathInferiors;
    private static final List<String> beforeOnLivingUpdateHookTypes;
    private static final List<String> overrideOnLivingUpdateHookTypes;
    private static final List<String> afterOnLivingUpdateHookTypes;
    private ServerPlayerBase[] beforeOnLivingUpdateHooks;
    private ServerPlayerBase[] overrideOnLivingUpdateHooks;
    private ServerPlayerBase[] afterOnLivingUpdateHooks;
    public boolean isOnLivingUpdateModded;
    private static final Map<String, String[]> allBaseBeforeOnLivingUpdateSuperiors;
    private static final Map<String, String[]> allBaseBeforeOnLivingUpdateInferiors;
    private static final Map<String, String[]> allBaseOverrideOnLivingUpdateSuperiors;
    private static final Map<String, String[]> allBaseOverrideOnLivingUpdateInferiors;
    private static final Map<String, String[]> allBaseAfterOnLivingUpdateSuperiors;
    private static final Map<String, String[]> allBaseAfterOnLivingUpdateInferiors;
    private static final List<String> beforeOnKillEntityHookTypes;
    private static final List<String> overrideOnKillEntityHookTypes;
    private static final List<String> afterOnKillEntityHookTypes;
    private ServerPlayerBase[] beforeOnKillEntityHooks;
    private ServerPlayerBase[] overrideOnKillEntityHooks;
    private ServerPlayerBase[] afterOnKillEntityHooks;
    public boolean isOnKillEntityModded;
    private static final Map<String, String[]> allBaseBeforeOnKillEntitySuperiors;
    private static final Map<String, String[]> allBaseBeforeOnKillEntityInferiors;
    private static final Map<String, String[]> allBaseOverrideOnKillEntitySuperiors;
    private static final Map<String, String[]> allBaseOverrideOnKillEntityInferiors;
    private static final Map<String, String[]> allBaseAfterOnKillEntitySuperiors;
    private static final Map<String, String[]> allBaseAfterOnKillEntityInferiors;
    private static final List<String> beforeOnStruckByLightningHookTypes;
    private static final List<String> overrideOnStruckByLightningHookTypes;
    private static final List<String> afterOnStruckByLightningHookTypes;
    private ServerPlayerBase[] beforeOnStruckByLightningHooks;
    private ServerPlayerBase[] overrideOnStruckByLightningHooks;
    private ServerPlayerBase[] afterOnStruckByLightningHooks;
    public boolean isOnStruckByLightningModded;
    private static final Map<String, String[]> allBaseBeforeOnStruckByLightningSuperiors;
    private static final Map<String, String[]> allBaseBeforeOnStruckByLightningInferiors;
    private static final Map<String, String[]> allBaseOverrideOnStruckByLightningSuperiors;
    private static final Map<String, String[]> allBaseOverrideOnStruckByLightningInferiors;
    private static final Map<String, String[]> allBaseAfterOnStruckByLightningSuperiors;
    private static final Map<String, String[]> allBaseAfterOnStruckByLightningInferiors;
    private static final List<String> beforeOnUpdateHookTypes;
    private static final List<String> overrideOnUpdateHookTypes;
    private static final List<String> afterOnUpdateHookTypes;
    private ServerPlayerBase[] beforeOnUpdateHooks;
    private ServerPlayerBase[] overrideOnUpdateHooks;
    private ServerPlayerBase[] afterOnUpdateHooks;
    public boolean isOnUpdateModded;
    private static final Map<String, String[]> allBaseBeforeOnUpdateSuperiors;
    private static final Map<String, String[]> allBaseBeforeOnUpdateInferiors;
    private static final Map<String, String[]> allBaseOverrideOnUpdateSuperiors;
    private static final Map<String, String[]> allBaseOverrideOnUpdateInferiors;
    private static final Map<String, String[]> allBaseAfterOnUpdateSuperiors;
    private static final Map<String, String[]> allBaseAfterOnUpdateInferiors;
    private static final List<String> beforeOnUpdateEntityHookTypes;
    private static final List<String> overrideOnUpdateEntityHookTypes;
    private static final List<String> afterOnUpdateEntityHookTypes;
    private ServerPlayerBase[] beforeOnUpdateEntityHooks;
    private ServerPlayerBase[] overrideOnUpdateEntityHooks;
    private ServerPlayerBase[] afterOnUpdateEntityHooks;
    public boolean isOnUpdateEntityModded;
    private static final Map<String, String[]> allBaseBeforeOnUpdateEntitySuperiors;
    private static final Map<String, String[]> allBaseBeforeOnUpdateEntityInferiors;
    private static final Map<String, String[]> allBaseOverrideOnUpdateEntitySuperiors;
    private static final Map<String, String[]> allBaseOverrideOnUpdateEntityInferiors;
    private static final Map<String, String[]> allBaseAfterOnUpdateEntitySuperiors;
    private static final Map<String, String[]> allBaseAfterOnUpdateEntityInferiors;
    private static final List<String> beforeReadEntityFromNBTHookTypes;
    private static final List<String> overrideReadEntityFromNBTHookTypes;
    private static final List<String> afterReadEntityFromNBTHookTypes;
    private ServerPlayerBase[] beforeReadEntityFromNBTHooks;
    private ServerPlayerBase[] overrideReadEntityFromNBTHooks;
    private ServerPlayerBase[] afterReadEntityFromNBTHooks;
    public boolean isReadEntityFromNBTModded;
    private static final Map<String, String[]> allBaseBeforeReadEntityFromNBTSuperiors;
    private static final Map<String, String[]> allBaseBeforeReadEntityFromNBTInferiors;
    private static final Map<String, String[]> allBaseOverrideReadEntityFromNBTSuperiors;
    private static final Map<String, String[]> allBaseOverrideReadEntityFromNBTInferiors;
    private static final Map<String, String[]> allBaseAfterReadEntityFromNBTSuperiors;
    private static final Map<String, String[]> allBaseAfterReadEntityFromNBTInferiors;
    private static final List<String> beforeSetDeadHookTypes;
    private static final List<String> overrideSetDeadHookTypes;
    private static final List<String> afterSetDeadHookTypes;
    private ServerPlayerBase[] beforeSetDeadHooks;
    private ServerPlayerBase[] overrideSetDeadHooks;
    private ServerPlayerBase[] afterSetDeadHooks;
    public boolean isSetDeadModded;
    private static final Map<String, String[]> allBaseBeforeSetDeadSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetDeadInferiors;
    private static final Map<String, String[]> allBaseOverrideSetDeadSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetDeadInferiors;
    private static final Map<String, String[]> allBaseAfterSetDeadSuperiors;
    private static final Map<String, String[]> allBaseAfterSetDeadInferiors;
    private static final List<String> beforeSetPositionHookTypes;
    private static final List<String> overrideSetPositionHookTypes;
    private static final List<String> afterSetPositionHookTypes;
    private ServerPlayerBase[] beforeSetPositionHooks;
    private ServerPlayerBase[] overrideSetPositionHooks;
    private ServerPlayerBase[] afterSetPositionHooks;
    public boolean isSetPositionModded;
    private static final Map<String, String[]> allBaseBeforeSetPositionSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetPositionInferiors;
    private static final Map<String, String[]> allBaseOverrideSetPositionSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetPositionInferiors;
    private static final Map<String, String[]> allBaseAfterSetPositionSuperiors;
    private static final Map<String, String[]> allBaseAfterSetPositionInferiors;
    private static final List<String> beforeSwingItemHookTypes;
    private static final List<String> overrideSwingItemHookTypes;
    private static final List<String> afterSwingItemHookTypes;
    private ServerPlayerBase[] beforeSwingItemHooks;
    private ServerPlayerBase[] overrideSwingItemHooks;
    private ServerPlayerBase[] afterSwingItemHooks;
    public boolean isSwingItemModded;
    private static final Map<String, String[]> allBaseBeforeSwingItemSuperiors;
    private static final Map<String, String[]> allBaseBeforeSwingItemInferiors;
    private static final Map<String, String[]> allBaseOverrideSwingItemSuperiors;
    private static final Map<String, String[]> allBaseOverrideSwingItemInferiors;
    private static final Map<String, String[]> allBaseAfterSwingItemSuperiors;
    private static final Map<String, String[]> allBaseAfterSwingItemInferiors;
    private static final List<String> beforeUpdateEntityActionStateHookTypes;
    private static final List<String> overrideUpdateEntityActionStateHookTypes;
    private static final List<String> afterUpdateEntityActionStateHookTypes;
    private ServerPlayerBase[] beforeUpdateEntityActionStateHooks;
    private ServerPlayerBase[] overrideUpdateEntityActionStateHooks;
    private ServerPlayerBase[] afterUpdateEntityActionStateHooks;
    public boolean isUpdateEntityActionStateModded;
    private static final Map<String, String[]> allBaseBeforeUpdateEntityActionStateSuperiors;
    private static final Map<String, String[]> allBaseBeforeUpdateEntityActionStateInferiors;
    private static final Map<String, String[]> allBaseOverrideUpdateEntityActionStateSuperiors;
    private static final Map<String, String[]> allBaseOverrideUpdateEntityActionStateInferiors;
    private static final Map<String, String[]> allBaseAfterUpdateEntityActionStateSuperiors;
    private static final Map<String, String[]> allBaseAfterUpdateEntityActionStateInferiors;
    private static final List<String> beforeUpdatePotionEffectsHookTypes;
    private static final List<String> overrideUpdatePotionEffectsHookTypes;
    private static final List<String> afterUpdatePotionEffectsHookTypes;
    private ServerPlayerBase[] beforeUpdatePotionEffectsHooks;
    private ServerPlayerBase[] overrideUpdatePotionEffectsHooks;
    private ServerPlayerBase[] afterUpdatePotionEffectsHooks;
    public boolean isUpdatePotionEffectsModded;
    private static final Map<String, String[]> allBaseBeforeUpdatePotionEffectsSuperiors;
    private static final Map<String, String[]> allBaseBeforeUpdatePotionEffectsInferiors;
    private static final Map<String, String[]> allBaseOverrideUpdatePotionEffectsSuperiors;
    private static final Map<String, String[]> allBaseOverrideUpdatePotionEffectsInferiors;
    private static final Map<String, String[]> allBaseAfterUpdatePotionEffectsSuperiors;
    private static final Map<String, String[]> allBaseAfterUpdatePotionEffectsInferiors;
    private static final List<String> beforeWriteEntityToNBTHookTypes;
    private static final List<String> overrideWriteEntityToNBTHookTypes;
    private static final List<String> afterWriteEntityToNBTHookTypes;
    private ServerPlayerBase[] beforeWriteEntityToNBTHooks;
    private ServerPlayerBase[] overrideWriteEntityToNBTHooks;
    private ServerPlayerBase[] afterWriteEntityToNBTHooks;
    public boolean isWriteEntityToNBTModded;
    private static final Map<String, String[]> allBaseBeforeWriteEntityToNBTSuperiors;
    private static final Map<String, String[]> allBaseBeforeWriteEntityToNBTInferiors;
    private static final Map<String, String[]> allBaseOverrideWriteEntityToNBTSuperiors;
    private static final Map<String, String[]> allBaseOverrideWriteEntityToNBTInferiors;
    private static final Map<String, String[]> allBaseAfterWriteEntityToNBTSuperiors;
    private static final Map<String, String[]> allBaseAfterWriteEntityToNBTInferiors;
    protected final IServerPlayerAPI player;
    private static final Set<String> keys;
    private static final Map<String, String> keysToVirtualIds;
    private static final Set<Class<?>> dynamicTypes;
    private static final Map<Class<?>, Map<String, Method>> virtualDynamicHookMethods;
    private static final Map<Class<?>, Map<String, Method>> beforeDynamicHookMethods;
    private static final Map<Class<?>, Map<String, Method>> overrideDynamicHookMethods;
    private static final Map<Class<?>, Map<String, Method>> afterDynamicHookMethods;
    private static final List<String> beforeLocalConstructingHookTypes;
    private static final List<String> afterLocalConstructingHookTypes;
    private static final Map<String, List<String>> beforeDynamicHookTypes;
    private static final Map<String, List<String>> overrideDynamicHookTypes;
    private static final Map<String, List<String>> afterDynamicHookTypes;
    private ServerPlayerBase[] beforeLocalConstructingHooks;
    private ServerPlayerBase[] afterLocalConstructingHooks;
    private final Map<ServerPlayerBase, String> baseObjectsToId = new Hashtable<ServerPlayerBase, String>();
    private final Map<String, ServerPlayerBase> allBaseObjects = new Hashtable<String, ServerPlayerBase>();
    private final Set<String> unmodifiableAllBaseIds = Collections.unmodifiableSet(this.allBaseObjects.keySet());
    private static final Map<String, Constructor<?>> allBaseConstructors;
    private static final Set<String> unmodifiableAllIds;
    private static final Map<String, String[]> allBaseBeforeLocalConstructingSuperiors;
    private static final Map<String, String[]> allBaseBeforeLocalConstructingInferiors;
    private static final Map<String, String[]> allBaseAfterLocalConstructingSuperiors;
    private static final Map<String, String[]> allBaseAfterLocalConstructingInferiors;
    private static final Map<String, Map<String, String[]>> allBaseBeforeDynamicSuperiors;
    private static final Map<String, Map<String, String[]>> allBaseBeforeDynamicInferiors;
    private static final Map<String, Map<String, String[]>> allBaseOverrideDynamicSuperiors;
    private static final Map<String, Map<String, String[]>> allBaseOverrideDynamicInferiors;
    private static final Map<String, Map<String, String[]>> allBaseAfterDynamicSuperiors;
    private static final Map<String, Map<String, String[]>> allBaseAfterDynamicInferiors;
    private static boolean initialized;

    private static void log(String string) {
        System.out.println(string);
        logger.fine(string);
    }

    public static void register(String string, Class<?> clazz) {
        ServerPlayerAPI.register(string, clazz, null);
    }

    public static void register(String string, Class<?> clazz, ServerPlayerBaseSorting serverPlayerBaseSorting) {
        try {
            ServerPlayerAPI.register(clazz, string, serverPlayerBaseSorting);
        }
        catch (RuntimeException runtimeException) {
            if (string != null) {
                ServerPlayerAPI.log("Server Player: failed to register id '" + string + "'");
            } else {
                ServerPlayerAPI.log("Server Player: failed to register ServerPlayerBase");
            }
            throw runtimeException;
        }
    }

    /*
     * WARNING - void declaration
     */
    private static void register(Class<?> clazz, String string, ServerPlayerBaseSorting serverPlayerBaseSorting) {
        Constructor<?> constructor;
        Executable executable;
        if (!isCreated) {
            try {
                executable = EntityPlayerMP.class.getMethod("getServerPlayerBase", String.class);
                if (((Method)executable).getReturnType() != ServerPlayerBase.class) {
                    throw new NoSuchMethodException(ServerPlayerBase.class.getName() + " " + EntityPlayerMP.class.getName() + ".getServerPlayerBase(" + String.class.getName() + ")");
                }
            }
            catch (NoSuchMethodException noSuchMethodException) {
                void var9_20;
                void object;
                String[] stringArray = new String[]{"========================================", "The API \"Server Player\" version 1.1 of the mod \"Player API core 1.1\" can not be created!", "----------------------------------------", "Mandatory member method \"{0} getServerPlayerBase({3})\" not found in class \"{1}\".", "There are three scenarios this can happen:", "* Minecraft Forge is missing a Player API core which Minecraft version matches its own.", "  Download and install the latest Player API core for the Minecraft version you were trying to run.", "* The code of the class \"{2}\" of Player API core has been modified beyond recognition by another Minecraft Forge coremod.", "  Try temporary deinstallation of other core mods to find the culprit and deinstall it permanently to fix this specific problem.", "* Player API core has not been installed correctly.", "  Deinstall Player API core and install it again following the installation instructions in the readme file.", "========================================"};
                String string2 = ServerPlayerBase.class.getName();
                String string3 = EntityPlayerMP.class.getName();
                String string4 = string3.replace(".", File.separator);
                String string5 = String.class.getName();
                boolean i = false;
                while (object < stringArray.length) {
                    stringArray[object] = MessageFormat.format(stringArray[object], string2, string3, string4, string5);
                    ++object;
                }
                for (String string6 : stringArray) {
                    logger.severe(string6);
                }
                for (String string6 : stringArray) {
                    System.err.println(string6);
                }
                String string7 = "\n\n";
                for (String string8 : stringArray) {
                    String string9 = (String)var9_20 + "\t" + string8 + "\n";
                }
                throw new RuntimeException((String)var9_20, noSuchMethodException);
            }
            ServerPlayerAPI.log("Server Player 1.1 Created");
            isCreated = true;
        }
        if (string == null) {
            throw new NullPointerException("Argument 'id' can not be null");
        }
        if (clazz == null) {
            throw new NullPointerException("Argument 'baseClass' can not be null");
        }
        executable = allBaseConstructors.get(string);
        if (executable != null) {
            throw new IllegalArgumentException("The class '" + clazz.getName() + "' can not be registered with the id '" + string + "' because the class '" + ((Constructor)executable).getDeclaringClass().getName() + "' has allready been registered with the same id");
        }
        try {
            constructor = clazz.getDeclaredConstructor(Classes);
        }
        catch (Throwable throwable) {
            try {
                constructor = clazz.getDeclaredConstructor(Class);
            }
            catch (Throwable throwable2) {
                throw new IllegalArgumentException("Can not find necessary constructor with one argument of type '" + ServerPlayerAPI.class.getName() + "' and eventually a second argument of type 'String' in the class '" + clazz.getName() + "'", throwable);
            }
        }
        allBaseConstructors.put(string, constructor);
        if (serverPlayerBaseSorting != null) {
            ServerPlayerAPI.addSorting(string, allBaseBeforeLocalConstructingSuperiors, serverPlayerBaseSorting.getBeforeLocalConstructingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeLocalConstructingInferiors, serverPlayerBaseSorting.getBeforeLocalConstructingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterLocalConstructingSuperiors, serverPlayerBaseSorting.getAfterLocalConstructingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterLocalConstructingInferiors, serverPlayerBaseSorting.getAfterLocalConstructingInferiors());
            ServerPlayerAPI.addDynamicSorting(string, allBaseBeforeDynamicSuperiors, serverPlayerBaseSorting.getDynamicBeforeSuperiors());
            ServerPlayerAPI.addDynamicSorting(string, allBaseBeforeDynamicInferiors, serverPlayerBaseSorting.getDynamicBeforeInferiors());
            ServerPlayerAPI.addDynamicSorting(string, allBaseOverrideDynamicSuperiors, serverPlayerBaseSorting.getDynamicOverrideSuperiors());
            ServerPlayerAPI.addDynamicSorting(string, allBaseOverrideDynamicInferiors, serverPlayerBaseSorting.getDynamicOverrideInferiors());
            ServerPlayerAPI.addDynamicSorting(string, allBaseAfterDynamicSuperiors, serverPlayerBaseSorting.getDynamicAfterSuperiors());
            ServerPlayerAPI.addDynamicSorting(string, allBaseAfterDynamicInferiors, serverPlayerBaseSorting.getDynamicAfterInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAddExhaustionSuperiors, serverPlayerBaseSorting.getBeforeAddExhaustionSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAddExhaustionInferiors, serverPlayerBaseSorting.getBeforeAddExhaustionInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAddExhaustionSuperiors, serverPlayerBaseSorting.getOverrideAddExhaustionSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAddExhaustionInferiors, serverPlayerBaseSorting.getOverrideAddExhaustionInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAddExhaustionSuperiors, serverPlayerBaseSorting.getAfterAddExhaustionSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAddExhaustionInferiors, serverPlayerBaseSorting.getAfterAddExhaustionInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAddExperienceSuperiors, serverPlayerBaseSorting.getBeforeAddExperienceSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAddExperienceInferiors, serverPlayerBaseSorting.getBeforeAddExperienceInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAddExperienceSuperiors, serverPlayerBaseSorting.getOverrideAddExperienceSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAddExperienceInferiors, serverPlayerBaseSorting.getOverrideAddExperienceInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAddExperienceSuperiors, serverPlayerBaseSorting.getAfterAddExperienceSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAddExperienceInferiors, serverPlayerBaseSorting.getAfterAddExperienceInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAddExperienceLevelSuperiors, serverPlayerBaseSorting.getBeforeAddExperienceLevelSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAddExperienceLevelInferiors, serverPlayerBaseSorting.getBeforeAddExperienceLevelInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAddExperienceLevelSuperiors, serverPlayerBaseSorting.getOverrideAddExperienceLevelSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAddExperienceLevelInferiors, serverPlayerBaseSorting.getOverrideAddExperienceLevelInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAddExperienceLevelSuperiors, serverPlayerBaseSorting.getAfterAddExperienceLevelSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAddExperienceLevelInferiors, serverPlayerBaseSorting.getAfterAddExperienceLevelInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAddMovementStatSuperiors, serverPlayerBaseSorting.getBeforeAddMovementStatSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAddMovementStatInferiors, serverPlayerBaseSorting.getBeforeAddMovementStatInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAddMovementStatSuperiors, serverPlayerBaseSorting.getOverrideAddMovementStatSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAddMovementStatInferiors, serverPlayerBaseSorting.getOverrideAddMovementStatInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAddMovementStatSuperiors, serverPlayerBaseSorting.getAfterAddMovementStatSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAddMovementStatInferiors, serverPlayerBaseSorting.getAfterAddMovementStatInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAttackEntityFromSuperiors, serverPlayerBaseSorting.getBeforeAttackEntityFromSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAttackEntityFromInferiors, serverPlayerBaseSorting.getBeforeAttackEntityFromInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAttackEntityFromSuperiors, serverPlayerBaseSorting.getOverrideAttackEntityFromSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAttackEntityFromInferiors, serverPlayerBaseSorting.getOverrideAttackEntityFromInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAttackEntityFromSuperiors, serverPlayerBaseSorting.getAfterAttackEntityFromSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAttackEntityFromInferiors, serverPlayerBaseSorting.getAfterAttackEntityFromInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors, serverPlayerBaseSorting.getBeforeAttackTargetEntityWithCurrentItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeAttackTargetEntityWithCurrentItemInferiors, serverPlayerBaseSorting.getBeforeAttackTargetEntityWithCurrentItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors, serverPlayerBaseSorting.getOverrideAttackTargetEntityWithCurrentItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideAttackTargetEntityWithCurrentItemInferiors, serverPlayerBaseSorting.getOverrideAttackTargetEntityWithCurrentItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAttackTargetEntityWithCurrentItemSuperiors, serverPlayerBaseSorting.getAfterAttackTargetEntityWithCurrentItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterAttackTargetEntityWithCurrentItemInferiors, serverPlayerBaseSorting.getAfterAttackTargetEntityWithCurrentItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeCanHarvestBlockSuperiors, serverPlayerBaseSorting.getBeforeCanHarvestBlockSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeCanHarvestBlockInferiors, serverPlayerBaseSorting.getBeforeCanHarvestBlockInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideCanHarvestBlockSuperiors, serverPlayerBaseSorting.getOverrideCanHarvestBlockSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideCanHarvestBlockInferiors, serverPlayerBaseSorting.getOverrideCanHarvestBlockInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterCanHarvestBlockSuperiors, serverPlayerBaseSorting.getAfterCanHarvestBlockSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterCanHarvestBlockInferiors, serverPlayerBaseSorting.getAfterCanHarvestBlockInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeCanPlayerEditSuperiors, serverPlayerBaseSorting.getBeforeCanPlayerEditSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeCanPlayerEditInferiors, serverPlayerBaseSorting.getBeforeCanPlayerEditInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideCanPlayerEditSuperiors, serverPlayerBaseSorting.getOverrideCanPlayerEditSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideCanPlayerEditInferiors, serverPlayerBaseSorting.getOverrideCanPlayerEditInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterCanPlayerEditSuperiors, serverPlayerBaseSorting.getAfterCanPlayerEditSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterCanPlayerEditInferiors, serverPlayerBaseSorting.getAfterCanPlayerEditInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeCanTriggerWalkingSuperiors, serverPlayerBaseSorting.getBeforeCanTriggerWalkingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeCanTriggerWalkingInferiors, serverPlayerBaseSorting.getBeforeCanTriggerWalkingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideCanTriggerWalkingSuperiors, serverPlayerBaseSorting.getOverrideCanTriggerWalkingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideCanTriggerWalkingInferiors, serverPlayerBaseSorting.getOverrideCanTriggerWalkingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterCanTriggerWalkingSuperiors, serverPlayerBaseSorting.getAfterCanTriggerWalkingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterCanTriggerWalkingInferiors, serverPlayerBaseSorting.getAfterCanTriggerWalkingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeClonePlayerSuperiors, serverPlayerBaseSorting.getBeforeClonePlayerSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeClonePlayerInferiors, serverPlayerBaseSorting.getBeforeClonePlayerInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideClonePlayerSuperiors, serverPlayerBaseSorting.getOverrideClonePlayerSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideClonePlayerInferiors, serverPlayerBaseSorting.getOverrideClonePlayerInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterClonePlayerSuperiors, serverPlayerBaseSorting.getAfterClonePlayerSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterClonePlayerInferiors, serverPlayerBaseSorting.getAfterClonePlayerInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDamageEntitySuperiors, serverPlayerBaseSorting.getBeforeDamageEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDamageEntityInferiors, serverPlayerBaseSorting.getBeforeDamageEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDamageEntitySuperiors, serverPlayerBaseSorting.getOverrideDamageEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDamageEntityInferiors, serverPlayerBaseSorting.getOverrideDamageEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDamageEntitySuperiors, serverPlayerBaseSorting.getAfterDamageEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDamageEntityInferiors, serverPlayerBaseSorting.getAfterDamageEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIChestSuperiors, serverPlayerBaseSorting.getBeforeDisplayGUIChestSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIChestInferiors, serverPlayerBaseSorting.getBeforeDisplayGUIChestInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIChestSuperiors, serverPlayerBaseSorting.getOverrideDisplayGUIChestSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIChestInferiors, serverPlayerBaseSorting.getOverrideDisplayGUIChestInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDisplayGUIChestSuperiors, serverPlayerBaseSorting.getAfterDisplayGUIChestSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDisplayGUIChestInferiors, serverPlayerBaseSorting.getAfterDisplayGUIChestInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIDispenserSuperiors, serverPlayerBaseSorting.getBeforeDisplayGUIDispenserSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIDispenserInferiors, serverPlayerBaseSorting.getBeforeDisplayGUIDispenserInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIDispenserSuperiors, serverPlayerBaseSorting.getOverrideDisplayGUIDispenserSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIDispenserInferiors, serverPlayerBaseSorting.getOverrideDisplayGUIDispenserInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDisplayGUIDispenserSuperiors, serverPlayerBaseSorting.getAfterDisplayGUIDispenserSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDisplayGUIDispenserInferiors, serverPlayerBaseSorting.getAfterDisplayGUIDispenserInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIFurnaceSuperiors, serverPlayerBaseSorting.getBeforeDisplayGUIFurnaceSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIFurnaceInferiors, serverPlayerBaseSorting.getBeforeDisplayGUIFurnaceInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIFurnaceSuperiors, serverPlayerBaseSorting.getOverrideDisplayGUIFurnaceSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIFurnaceInferiors, serverPlayerBaseSorting.getOverrideDisplayGUIFurnaceInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDisplayGUIFurnaceSuperiors, serverPlayerBaseSorting.getAfterDisplayGUIFurnaceSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDisplayGUIFurnaceInferiors, serverPlayerBaseSorting.getAfterDisplayGUIFurnaceInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIWorkbenchSuperiors, serverPlayerBaseSorting.getBeforeDisplayGUIWorkbenchSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIWorkbenchInferiors, serverPlayerBaseSorting.getBeforeDisplayGUIWorkbenchInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIWorkbenchSuperiors, serverPlayerBaseSorting.getOverrideDisplayGUIWorkbenchSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIWorkbenchInferiors, serverPlayerBaseSorting.getOverrideDisplayGUIWorkbenchInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDisplayGUIWorkbenchSuperiors, serverPlayerBaseSorting.getAfterDisplayGUIWorkbenchSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDisplayGUIWorkbenchInferiors, serverPlayerBaseSorting.getAfterDisplayGUIWorkbenchInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDropOneItemSuperiors, serverPlayerBaseSorting.getBeforeDropOneItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDropOneItemInferiors, serverPlayerBaseSorting.getBeforeDropOneItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDropOneItemSuperiors, serverPlayerBaseSorting.getOverrideDropOneItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDropOneItemInferiors, serverPlayerBaseSorting.getOverrideDropOneItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDropOneItemSuperiors, serverPlayerBaseSorting.getAfterDropOneItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDropOneItemInferiors, serverPlayerBaseSorting.getAfterDropOneItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDropPlayerItemSuperiors, serverPlayerBaseSorting.getBeforeDropPlayerItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeDropPlayerItemInferiors, serverPlayerBaseSorting.getBeforeDropPlayerItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDropPlayerItemSuperiors, serverPlayerBaseSorting.getOverrideDropPlayerItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideDropPlayerItemInferiors, serverPlayerBaseSorting.getOverrideDropPlayerItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDropPlayerItemSuperiors, serverPlayerBaseSorting.getAfterDropPlayerItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterDropPlayerItemInferiors, serverPlayerBaseSorting.getAfterDropPlayerItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeFallSuperiors, serverPlayerBaseSorting.getBeforeFallSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeFallInferiors, serverPlayerBaseSorting.getBeforeFallInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideFallSuperiors, serverPlayerBaseSorting.getOverrideFallSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideFallInferiors, serverPlayerBaseSorting.getOverrideFallInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterFallSuperiors, serverPlayerBaseSorting.getAfterFallSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterFallInferiors, serverPlayerBaseSorting.getAfterFallInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors, serverPlayerBaseSorting.getBeforeGetCurrentPlayerStrVsBlockSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeGetCurrentPlayerStrVsBlockInferiors, serverPlayerBaseSorting.getBeforeGetCurrentPlayerStrVsBlockInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors, serverPlayerBaseSorting.getOverrideGetCurrentPlayerStrVsBlockSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideGetCurrentPlayerStrVsBlockInferiors, serverPlayerBaseSorting.getOverrideGetCurrentPlayerStrVsBlockInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterGetCurrentPlayerStrVsBlockSuperiors, serverPlayerBaseSorting.getAfterGetCurrentPlayerStrVsBlockSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterGetCurrentPlayerStrVsBlockInferiors, serverPlayerBaseSorting.getAfterGetCurrentPlayerStrVsBlockInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors, serverPlayerBaseSorting.getBeforeGetCurrentPlayerStrVsBlockForgeSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors, serverPlayerBaseSorting.getBeforeGetCurrentPlayerStrVsBlockForgeInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors, serverPlayerBaseSorting.getOverrideGetCurrentPlayerStrVsBlockForgeSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors, serverPlayerBaseSorting.getOverrideGetCurrentPlayerStrVsBlockForgeInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors, serverPlayerBaseSorting.getAfterGetCurrentPlayerStrVsBlockForgeSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors, serverPlayerBaseSorting.getAfterGetCurrentPlayerStrVsBlockForgeInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeGetDistanceSqSuperiors, serverPlayerBaseSorting.getBeforeGetDistanceSqSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeGetDistanceSqInferiors, serverPlayerBaseSorting.getBeforeGetDistanceSqInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideGetDistanceSqSuperiors, serverPlayerBaseSorting.getOverrideGetDistanceSqSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideGetDistanceSqInferiors, serverPlayerBaseSorting.getOverrideGetDistanceSqInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterGetDistanceSqSuperiors, serverPlayerBaseSorting.getAfterGetDistanceSqSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterGetDistanceSqInferiors, serverPlayerBaseSorting.getAfterGetDistanceSqInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeGetBrightnessSuperiors, serverPlayerBaseSorting.getBeforeGetBrightnessSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeGetBrightnessInferiors, serverPlayerBaseSorting.getBeforeGetBrightnessInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideGetBrightnessSuperiors, serverPlayerBaseSorting.getOverrideGetBrightnessSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideGetBrightnessInferiors, serverPlayerBaseSorting.getOverrideGetBrightnessInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterGetBrightnessSuperiors, serverPlayerBaseSorting.getAfterGetBrightnessSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterGetBrightnessInferiors, serverPlayerBaseSorting.getAfterGetBrightnessInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeGetEyeHeightSuperiors, serverPlayerBaseSorting.getBeforeGetEyeHeightSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeGetEyeHeightInferiors, serverPlayerBaseSorting.getBeforeGetEyeHeightInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideGetEyeHeightSuperiors, serverPlayerBaseSorting.getOverrideGetEyeHeightSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideGetEyeHeightInferiors, serverPlayerBaseSorting.getOverrideGetEyeHeightInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterGetEyeHeightSuperiors, serverPlayerBaseSorting.getAfterGetEyeHeightSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterGetEyeHeightInferiors, serverPlayerBaseSorting.getAfterGetEyeHeightInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeHealSuperiors, serverPlayerBaseSorting.getBeforeHealSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeHealInferiors, serverPlayerBaseSorting.getBeforeHealInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideHealSuperiors, serverPlayerBaseSorting.getOverrideHealSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideHealInferiors, serverPlayerBaseSorting.getOverrideHealInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterHealSuperiors, serverPlayerBaseSorting.getAfterHealSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterHealInferiors, serverPlayerBaseSorting.getAfterHealInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeIsEntityInsideOpaqueBlockSuperiors, serverPlayerBaseSorting.getBeforeIsEntityInsideOpaqueBlockSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeIsEntityInsideOpaqueBlockInferiors, serverPlayerBaseSorting.getBeforeIsEntityInsideOpaqueBlockInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideIsEntityInsideOpaqueBlockSuperiors, serverPlayerBaseSorting.getOverrideIsEntityInsideOpaqueBlockSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideIsEntityInsideOpaqueBlockInferiors, serverPlayerBaseSorting.getOverrideIsEntityInsideOpaqueBlockInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterIsEntityInsideOpaqueBlockSuperiors, serverPlayerBaseSorting.getAfterIsEntityInsideOpaqueBlockSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterIsEntityInsideOpaqueBlockInferiors, serverPlayerBaseSorting.getAfterIsEntityInsideOpaqueBlockInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeIsInWaterSuperiors, serverPlayerBaseSorting.getBeforeIsInWaterSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeIsInWaterInferiors, serverPlayerBaseSorting.getBeforeIsInWaterInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideIsInWaterSuperiors, serverPlayerBaseSorting.getOverrideIsInWaterSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideIsInWaterInferiors, serverPlayerBaseSorting.getOverrideIsInWaterInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterIsInWaterSuperiors, serverPlayerBaseSorting.getAfterIsInWaterSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterIsInWaterInferiors, serverPlayerBaseSorting.getAfterIsInWaterInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeIsInsideOfMaterialSuperiors, serverPlayerBaseSorting.getBeforeIsInsideOfMaterialSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeIsInsideOfMaterialInferiors, serverPlayerBaseSorting.getBeforeIsInsideOfMaterialInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideIsInsideOfMaterialSuperiors, serverPlayerBaseSorting.getOverrideIsInsideOfMaterialSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideIsInsideOfMaterialInferiors, serverPlayerBaseSorting.getOverrideIsInsideOfMaterialInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterIsInsideOfMaterialSuperiors, serverPlayerBaseSorting.getAfterIsInsideOfMaterialSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterIsInsideOfMaterialInferiors, serverPlayerBaseSorting.getAfterIsInsideOfMaterialInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeIsOnLadderSuperiors, serverPlayerBaseSorting.getBeforeIsOnLadderSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeIsOnLadderInferiors, serverPlayerBaseSorting.getBeforeIsOnLadderInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideIsOnLadderSuperiors, serverPlayerBaseSorting.getOverrideIsOnLadderSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideIsOnLadderInferiors, serverPlayerBaseSorting.getOverrideIsOnLadderInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterIsOnLadderSuperiors, serverPlayerBaseSorting.getAfterIsOnLadderSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterIsOnLadderInferiors, serverPlayerBaseSorting.getAfterIsOnLadderInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeIsPlayerSleepingSuperiors, serverPlayerBaseSorting.getBeforeIsPlayerSleepingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeIsPlayerSleepingInferiors, serverPlayerBaseSorting.getBeforeIsPlayerSleepingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideIsPlayerSleepingSuperiors, serverPlayerBaseSorting.getOverrideIsPlayerSleepingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideIsPlayerSleepingInferiors, serverPlayerBaseSorting.getOverrideIsPlayerSleepingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterIsPlayerSleepingSuperiors, serverPlayerBaseSorting.getAfterIsPlayerSleepingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterIsPlayerSleepingInferiors, serverPlayerBaseSorting.getAfterIsPlayerSleepingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeJumpSuperiors, serverPlayerBaseSorting.getBeforeJumpSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeJumpInferiors, serverPlayerBaseSorting.getBeforeJumpInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideJumpSuperiors, serverPlayerBaseSorting.getOverrideJumpSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideJumpInferiors, serverPlayerBaseSorting.getOverrideJumpInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterJumpSuperiors, serverPlayerBaseSorting.getAfterJumpSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterJumpInferiors, serverPlayerBaseSorting.getAfterJumpInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeKnockBackSuperiors, serverPlayerBaseSorting.getBeforeKnockBackSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeKnockBackInferiors, serverPlayerBaseSorting.getBeforeKnockBackInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideKnockBackSuperiors, serverPlayerBaseSorting.getOverrideKnockBackSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideKnockBackInferiors, serverPlayerBaseSorting.getOverrideKnockBackInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterKnockBackSuperiors, serverPlayerBaseSorting.getAfterKnockBackSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterKnockBackInferiors, serverPlayerBaseSorting.getAfterKnockBackInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeMoveEntitySuperiors, serverPlayerBaseSorting.getBeforeMoveEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeMoveEntityInferiors, serverPlayerBaseSorting.getBeforeMoveEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideMoveEntitySuperiors, serverPlayerBaseSorting.getOverrideMoveEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideMoveEntityInferiors, serverPlayerBaseSorting.getOverrideMoveEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterMoveEntitySuperiors, serverPlayerBaseSorting.getAfterMoveEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterMoveEntityInferiors, serverPlayerBaseSorting.getAfterMoveEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeMoveEntityWithHeadingSuperiors, serverPlayerBaseSorting.getBeforeMoveEntityWithHeadingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeMoveEntityWithHeadingInferiors, serverPlayerBaseSorting.getBeforeMoveEntityWithHeadingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideMoveEntityWithHeadingSuperiors, serverPlayerBaseSorting.getOverrideMoveEntityWithHeadingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideMoveEntityWithHeadingInferiors, serverPlayerBaseSorting.getOverrideMoveEntityWithHeadingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterMoveEntityWithHeadingSuperiors, serverPlayerBaseSorting.getAfterMoveEntityWithHeadingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterMoveEntityWithHeadingInferiors, serverPlayerBaseSorting.getAfterMoveEntityWithHeadingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeMoveFlyingSuperiors, serverPlayerBaseSorting.getBeforeMoveFlyingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeMoveFlyingInferiors, serverPlayerBaseSorting.getBeforeMoveFlyingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideMoveFlyingSuperiors, serverPlayerBaseSorting.getOverrideMoveFlyingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideMoveFlyingInferiors, serverPlayerBaseSorting.getOverrideMoveFlyingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterMoveFlyingSuperiors, serverPlayerBaseSorting.getAfterMoveFlyingSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterMoveFlyingInferiors, serverPlayerBaseSorting.getAfterMoveFlyingInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnDeathSuperiors, serverPlayerBaseSorting.getBeforeOnDeathSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnDeathInferiors, serverPlayerBaseSorting.getBeforeOnDeathInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnDeathSuperiors, serverPlayerBaseSorting.getOverrideOnDeathSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnDeathInferiors, serverPlayerBaseSorting.getOverrideOnDeathInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnDeathSuperiors, serverPlayerBaseSorting.getAfterOnDeathSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnDeathInferiors, serverPlayerBaseSorting.getAfterOnDeathInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnLivingUpdateSuperiors, serverPlayerBaseSorting.getBeforeOnLivingUpdateSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnLivingUpdateInferiors, serverPlayerBaseSorting.getBeforeOnLivingUpdateInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnLivingUpdateSuperiors, serverPlayerBaseSorting.getOverrideOnLivingUpdateSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnLivingUpdateInferiors, serverPlayerBaseSorting.getOverrideOnLivingUpdateInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnLivingUpdateSuperiors, serverPlayerBaseSorting.getAfterOnLivingUpdateSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnLivingUpdateInferiors, serverPlayerBaseSorting.getAfterOnLivingUpdateInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnKillEntitySuperiors, serverPlayerBaseSorting.getBeforeOnKillEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnKillEntityInferiors, serverPlayerBaseSorting.getBeforeOnKillEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnKillEntitySuperiors, serverPlayerBaseSorting.getOverrideOnKillEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnKillEntityInferiors, serverPlayerBaseSorting.getOverrideOnKillEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnKillEntitySuperiors, serverPlayerBaseSorting.getAfterOnKillEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnKillEntityInferiors, serverPlayerBaseSorting.getAfterOnKillEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnStruckByLightningSuperiors, serverPlayerBaseSorting.getBeforeOnStruckByLightningSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnStruckByLightningInferiors, serverPlayerBaseSorting.getBeforeOnStruckByLightningInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnStruckByLightningSuperiors, serverPlayerBaseSorting.getOverrideOnStruckByLightningSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnStruckByLightningInferiors, serverPlayerBaseSorting.getOverrideOnStruckByLightningInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnStruckByLightningSuperiors, serverPlayerBaseSorting.getAfterOnStruckByLightningSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnStruckByLightningInferiors, serverPlayerBaseSorting.getAfterOnStruckByLightningInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnUpdateSuperiors, serverPlayerBaseSorting.getBeforeOnUpdateSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnUpdateInferiors, serverPlayerBaseSorting.getBeforeOnUpdateInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnUpdateSuperiors, serverPlayerBaseSorting.getOverrideOnUpdateSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnUpdateInferiors, serverPlayerBaseSorting.getOverrideOnUpdateInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnUpdateSuperiors, serverPlayerBaseSorting.getAfterOnUpdateSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnUpdateInferiors, serverPlayerBaseSorting.getAfterOnUpdateInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnUpdateEntitySuperiors, serverPlayerBaseSorting.getBeforeOnUpdateEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeOnUpdateEntityInferiors, serverPlayerBaseSorting.getBeforeOnUpdateEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnUpdateEntitySuperiors, serverPlayerBaseSorting.getOverrideOnUpdateEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideOnUpdateEntityInferiors, serverPlayerBaseSorting.getOverrideOnUpdateEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnUpdateEntitySuperiors, serverPlayerBaseSorting.getAfterOnUpdateEntitySuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterOnUpdateEntityInferiors, serverPlayerBaseSorting.getAfterOnUpdateEntityInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeReadEntityFromNBTSuperiors, serverPlayerBaseSorting.getBeforeReadEntityFromNBTSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeReadEntityFromNBTInferiors, serverPlayerBaseSorting.getBeforeReadEntityFromNBTInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideReadEntityFromNBTSuperiors, serverPlayerBaseSorting.getOverrideReadEntityFromNBTSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideReadEntityFromNBTInferiors, serverPlayerBaseSorting.getOverrideReadEntityFromNBTInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterReadEntityFromNBTSuperiors, serverPlayerBaseSorting.getAfterReadEntityFromNBTSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterReadEntityFromNBTInferiors, serverPlayerBaseSorting.getAfterReadEntityFromNBTInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeSetDeadSuperiors, serverPlayerBaseSorting.getBeforeSetDeadSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeSetDeadInferiors, serverPlayerBaseSorting.getBeforeSetDeadInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideSetDeadSuperiors, serverPlayerBaseSorting.getOverrideSetDeadSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideSetDeadInferiors, serverPlayerBaseSorting.getOverrideSetDeadInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterSetDeadSuperiors, serverPlayerBaseSorting.getAfterSetDeadSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterSetDeadInferiors, serverPlayerBaseSorting.getAfterSetDeadInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeSetPositionSuperiors, serverPlayerBaseSorting.getBeforeSetPositionSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeSetPositionInferiors, serverPlayerBaseSorting.getBeforeSetPositionInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideSetPositionSuperiors, serverPlayerBaseSorting.getOverrideSetPositionSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideSetPositionInferiors, serverPlayerBaseSorting.getOverrideSetPositionInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterSetPositionSuperiors, serverPlayerBaseSorting.getAfterSetPositionSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterSetPositionInferiors, serverPlayerBaseSorting.getAfterSetPositionInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeSwingItemSuperiors, serverPlayerBaseSorting.getBeforeSwingItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeSwingItemInferiors, serverPlayerBaseSorting.getBeforeSwingItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideSwingItemSuperiors, serverPlayerBaseSorting.getOverrideSwingItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideSwingItemInferiors, serverPlayerBaseSorting.getOverrideSwingItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterSwingItemSuperiors, serverPlayerBaseSorting.getAfterSwingItemSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterSwingItemInferiors, serverPlayerBaseSorting.getAfterSwingItemInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeUpdateEntityActionStateSuperiors, serverPlayerBaseSorting.getBeforeUpdateEntityActionStateSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeUpdateEntityActionStateInferiors, serverPlayerBaseSorting.getBeforeUpdateEntityActionStateInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideUpdateEntityActionStateSuperiors, serverPlayerBaseSorting.getOverrideUpdateEntityActionStateSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideUpdateEntityActionStateInferiors, serverPlayerBaseSorting.getOverrideUpdateEntityActionStateInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterUpdateEntityActionStateSuperiors, serverPlayerBaseSorting.getAfterUpdateEntityActionStateSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterUpdateEntityActionStateInferiors, serverPlayerBaseSorting.getAfterUpdateEntityActionStateInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeUpdatePotionEffectsSuperiors, serverPlayerBaseSorting.getBeforeUpdatePotionEffectsSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeUpdatePotionEffectsInferiors, serverPlayerBaseSorting.getBeforeUpdatePotionEffectsInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideUpdatePotionEffectsSuperiors, serverPlayerBaseSorting.getOverrideUpdatePotionEffectsSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideUpdatePotionEffectsInferiors, serverPlayerBaseSorting.getOverrideUpdatePotionEffectsInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterUpdatePotionEffectsSuperiors, serverPlayerBaseSorting.getAfterUpdatePotionEffectsSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterUpdatePotionEffectsInferiors, serverPlayerBaseSorting.getAfterUpdatePotionEffectsInferiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeWriteEntityToNBTSuperiors, serverPlayerBaseSorting.getBeforeWriteEntityToNBTSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseBeforeWriteEntityToNBTInferiors, serverPlayerBaseSorting.getBeforeWriteEntityToNBTInferiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideWriteEntityToNBTSuperiors, serverPlayerBaseSorting.getOverrideWriteEntityToNBTSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseOverrideWriteEntityToNBTInferiors, serverPlayerBaseSorting.getOverrideWriteEntityToNBTInferiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterWriteEntityToNBTSuperiors, serverPlayerBaseSorting.getAfterWriteEntityToNBTSuperiors());
            ServerPlayerAPI.addSorting(string, allBaseAfterWriteEntityToNBTInferiors, serverPlayerBaseSorting.getAfterWriteEntityToNBTInferiors());
        }
        ServerPlayerAPI.addMethod(string, clazz, beforeLocalConstructingHookTypes, "beforeLocalConstructing", dzfd.class, ozlu.class, String.class, mbsl.class);
        ServerPlayerAPI.addMethod(string, clazz, afterLocalConstructingHookTypes, "afterLocalConstructing", dzfd.class, ozlu.class, String.class, mbsl.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeAddExhaustionHookTypes, "beforeAddExhaustion", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideAddExhaustionHookTypes, "addExhaustion", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterAddExhaustionHookTypes, "afterAddExhaustion", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeAddExperienceHookTypes, "beforeAddExperience", Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideAddExperienceHookTypes, "addExperience", Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterAddExperienceHookTypes, "afterAddExperience", Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeAddExperienceLevelHookTypes, "beforeAddExperienceLevel", Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideAddExperienceLevelHookTypes, "addExperienceLevel", Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterAddExperienceLevelHookTypes, "afterAddExperienceLevel", Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeAddMovementStatHookTypes, "beforeAddMovementStat", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideAddMovementStatHookTypes, "addMovementStat", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterAddMovementStatHookTypes, "afterAddMovementStat", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeAttackEntityFromHookTypes, "beforeAttackEntityFrom", jxtc.class, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideAttackEntityFromHookTypes, "attackEntityFrom", jxtc.class, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterAttackEntityFromHookTypes, "afterAttackEntityFrom", jxtc.class, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeAttackTargetEntityWithCurrentItemHookTypes, "beforeAttackTargetEntityWithCurrentItem", Entity.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideAttackTargetEntityWithCurrentItemHookTypes, "attackTargetEntityWithCurrentItem", Entity.class);
        ServerPlayerAPI.addMethod(string, clazz, afterAttackTargetEntityWithCurrentItemHookTypes, "afterAttackTargetEntityWithCurrentItem", Entity.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeCanHarvestBlockHookTypes, "beforeCanHarvestBlock", twgu.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideCanHarvestBlockHookTypes, "canHarvestBlock", twgu.class);
        ServerPlayerAPI.addMethod(string, clazz, afterCanHarvestBlockHookTypes, "afterCanHarvestBlock", twgu.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeCanPlayerEditHookTypes, "beforeCanPlayerEdit", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, cvzo.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideCanPlayerEditHookTypes, "canPlayerEdit", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, cvzo.class);
        ServerPlayerAPI.addMethod(string, clazz, afterCanPlayerEditHookTypes, "afterCanPlayerEdit", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, cvzo.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeCanTriggerWalkingHookTypes, "beforeCanTriggerWalking", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideCanTriggerWalkingHookTypes, "canTriggerWalking", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterCanTriggerWalkingHookTypes, "afterCanTriggerWalking", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeClonePlayerHookTypes, "beforeClonePlayer", EntityPlayer.class, Boolean.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideClonePlayerHookTypes, "clonePlayer", EntityPlayer.class, Boolean.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterClonePlayerHookTypes, "afterClonePlayer", EntityPlayer.class, Boolean.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeDamageEntityHookTypes, "beforeDamageEntity", jxtc.class, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideDamageEntityHookTypes, "damageEntity", jxtc.class, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterDamageEntityHookTypes, "afterDamageEntity", jxtc.class, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeDisplayGUIChestHookTypes, "beforeDisplayGUIChest", mssh.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideDisplayGUIChestHookTypes, "displayGUIChest", mssh.class);
        ServerPlayerAPI.addMethod(string, clazz, afterDisplayGUIChestHookTypes, "afterDisplayGUIChest", mssh.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeDisplayGUIDispenserHookTypes, "beforeDisplayGUIDispenser", jjzo.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideDisplayGUIDispenserHookTypes, "displayGUIDispenser", jjzo.class);
        ServerPlayerAPI.addMethod(string, clazz, afterDisplayGUIDispenserHookTypes, "afterDisplayGUIDispenser", jjzo.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeDisplayGUIFurnaceHookTypes, "beforeDisplayGUIFurnace", nwgz.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideDisplayGUIFurnaceHookTypes, "displayGUIFurnace", nwgz.class);
        ServerPlayerAPI.addMethod(string, clazz, afterDisplayGUIFurnaceHookTypes, "afterDisplayGUIFurnace", nwgz.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeDisplayGUIWorkbenchHookTypes, "beforeDisplayGUIWorkbench", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideDisplayGUIWorkbenchHookTypes, "displayGUIWorkbench", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterDisplayGUIWorkbenchHookTypes, "afterDisplayGUIWorkbench", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeDropOneItemHookTypes, "beforeDropOneItem", Boolean.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideDropOneItemHookTypes, "dropOneItem", Boolean.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterDropOneItemHookTypes, "afterDropOneItem", Boolean.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeDropPlayerItemHookTypes, "beforeDropPlayerItem", cvzo.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideDropPlayerItemHookTypes, "dropPlayerItem", cvzo.class);
        ServerPlayerAPI.addMethod(string, clazz, afterDropPlayerItemHookTypes, "afterDropPlayerItem", cvzo.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeFallHookTypes, "beforeFall", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideFallHookTypes, "fall", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterFallHookTypes, "afterFall", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeGetCurrentPlayerStrVsBlockHookTypes, "beforeGetCurrentPlayerStrVsBlock", twgu.class, Boolean.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideGetCurrentPlayerStrVsBlockHookTypes, "getCurrentPlayerStrVsBlock", twgu.class, Boolean.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterGetCurrentPlayerStrVsBlockHookTypes, "afterGetCurrentPlayerStrVsBlock", twgu.class, Boolean.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeGetCurrentPlayerStrVsBlockForgeHookTypes, "beforeGetCurrentPlayerStrVsBlockForge", twgu.class, Boolean.TYPE, Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideGetCurrentPlayerStrVsBlockForgeHookTypes, "getCurrentPlayerStrVsBlockForge", twgu.class, Boolean.TYPE, Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterGetCurrentPlayerStrVsBlockForgeHookTypes, "afterGetCurrentPlayerStrVsBlockForge", twgu.class, Boolean.TYPE, Integer.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeGetDistanceSqHookTypes, "beforeGetDistanceSq", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideGetDistanceSqHookTypes, "getDistanceSq", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterGetDistanceSqHookTypes, "afterGetDistanceSq", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeGetBrightnessHookTypes, "beforeGetBrightness", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideGetBrightnessHookTypes, "getBrightness", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterGetBrightnessHookTypes, "afterGetBrightness", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeGetEyeHeightHookTypes, "beforeGetEyeHeight", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideGetEyeHeightHookTypes, "getEyeHeight", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterGetEyeHeightHookTypes, "afterGetEyeHeight", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeHealHookTypes, "beforeHeal", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideHealHookTypes, "heal", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterHealHookTypes, "afterHeal", Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeIsEntityInsideOpaqueBlockHookTypes, "beforeIsEntityInsideOpaqueBlock", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideIsEntityInsideOpaqueBlockHookTypes, "isEntityInsideOpaqueBlock", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterIsEntityInsideOpaqueBlockHookTypes, "afterIsEntityInsideOpaqueBlock", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeIsInWaterHookTypes, "beforeIsInWater", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideIsInWaterHookTypes, "isInWater", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterIsInWaterHookTypes, "afterIsInWater", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeIsInsideOfMaterialHookTypes, "beforeIsInsideOfMaterial", tflj.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideIsInsideOfMaterialHookTypes, "isInsideOfMaterial", tflj.class);
        ServerPlayerAPI.addMethod(string, clazz, afterIsInsideOfMaterialHookTypes, "afterIsInsideOfMaterial", tflj.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeIsOnLadderHookTypes, "beforeIsOnLadder", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideIsOnLadderHookTypes, "isOnLadder", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterIsOnLadderHookTypes, "afterIsOnLadder", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeIsPlayerSleepingHookTypes, "beforeIsPlayerSleeping", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideIsPlayerSleepingHookTypes, "isPlayerSleeping", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterIsPlayerSleepingHookTypes, "afterIsPlayerSleeping", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeJumpHookTypes, "beforeJump", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideJumpHookTypes, "jump", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterJumpHookTypes, "afterJump", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeKnockBackHookTypes, "beforeKnockBack", Entity.class, Float.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideKnockBackHookTypes, "knockBack", Entity.class, Float.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterKnockBackHookTypes, "afterKnockBack", Entity.class, Float.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeMoveEntityHookTypes, "beforeMoveEntity", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideMoveEntityHookTypes, "moveEntity", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterMoveEntityHookTypes, "afterMoveEntity", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeMoveEntityWithHeadingHookTypes, "beforeMoveEntityWithHeading", Float.TYPE, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideMoveEntityWithHeadingHookTypes, "moveEntityWithHeading", Float.TYPE, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterMoveEntityWithHeadingHookTypes, "afterMoveEntityWithHeading", Float.TYPE, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeMoveFlyingHookTypes, "beforeMoveFlying", Float.TYPE, Float.TYPE, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideMoveFlyingHookTypes, "moveFlying", Float.TYPE, Float.TYPE, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterMoveFlyingHookTypes, "afterMoveFlying", Float.TYPE, Float.TYPE, Float.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeOnDeathHookTypes, "beforeOnDeath", jxtc.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideOnDeathHookTypes, "onDeath", jxtc.class);
        ServerPlayerAPI.addMethod(string, clazz, afterOnDeathHookTypes, "afterOnDeath", jxtc.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeOnLivingUpdateHookTypes, "beforeOnLivingUpdate", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideOnLivingUpdateHookTypes, "onLivingUpdate", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterOnLivingUpdateHookTypes, "afterOnLivingUpdate", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeOnKillEntityHookTypes, "beforeOnKillEntity", EntityLivingBase.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideOnKillEntityHookTypes, "onKillEntity", EntityLivingBase.class);
        ServerPlayerAPI.addMethod(string, clazz, afterOnKillEntityHookTypes, "afterOnKillEntity", EntityLivingBase.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeOnStruckByLightningHookTypes, "beforeOnStruckByLightning", EntityLightningBolt.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideOnStruckByLightningHookTypes, "onStruckByLightning", EntityLightningBolt.class);
        ServerPlayerAPI.addMethod(string, clazz, afterOnStruckByLightningHookTypes, "afterOnStruckByLightning", EntityLightningBolt.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeOnUpdateHookTypes, "beforeOnUpdate", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideOnUpdateHookTypes, "onUpdate", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterOnUpdateHookTypes, "afterOnUpdate", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeOnUpdateEntityHookTypes, "beforeOnUpdateEntity", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideOnUpdateEntityHookTypes, "onUpdateEntity", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterOnUpdateEntityHookTypes, "afterOnUpdateEntity", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeReadEntityFromNBTHookTypes, "beforeReadEntityFromNBT", qoac.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideReadEntityFromNBTHookTypes, "readEntityFromNBT", qoac.class);
        ServerPlayerAPI.addMethod(string, clazz, afterReadEntityFromNBTHookTypes, "afterReadEntityFromNBT", qoac.class);
        ServerPlayerAPI.addMethod(string, clazz, beforeSetDeadHookTypes, "beforeSetDead", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideSetDeadHookTypes, "setDead", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterSetDeadHookTypes, "afterSetDead", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeSetPositionHookTypes, "beforeSetPosition", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, overrideSetPositionHookTypes, "setPosition", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, afterSetPositionHookTypes, "afterSetPosition", Double.TYPE, Double.TYPE, Double.TYPE);
        ServerPlayerAPI.addMethod(string, clazz, beforeSwingItemHookTypes, "beforeSwingItem", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideSwingItemHookTypes, "swingItem", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterSwingItemHookTypes, "afterSwingItem", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeUpdateEntityActionStateHookTypes, "beforeUpdateEntityActionState", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideUpdateEntityActionStateHookTypes, "updateEntityActionState", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterUpdateEntityActionStateHookTypes, "afterUpdateEntityActionState", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeUpdatePotionEffectsHookTypes, "beforeUpdatePotionEffects", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, overrideUpdatePotionEffectsHookTypes, "updatePotionEffects", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, afterUpdatePotionEffectsHookTypes, "afterUpdatePotionEffects", new Class[0]);
        ServerPlayerAPI.addMethod(string, clazz, beforeWriteEntityToNBTHookTypes, "beforeWriteEntityToNBT", qoac.class);
        ServerPlayerAPI.addMethod(string, clazz, overrideWriteEntityToNBTHookTypes, "writeEntityToNBT", qoac.class);
        ServerPlayerAPI.addMethod(string, clazz, afterWriteEntityToNBTHookTypes, "afterWriteEntityToNBT", qoac.class);
        ServerPlayerAPI.addDynamicMethods(string, clazz);
        ServerPlayerAPI.addDynamicKeys(string, clazz, beforeDynamicHookMethods, beforeDynamicHookTypes);
        ServerPlayerAPI.addDynamicKeys(string, clazz, overrideDynamicHookMethods, overrideDynamicHookTypes);
        ServerPlayerAPI.addDynamicKeys(string, clazz, afterDynamicHookMethods, afterDynamicHookTypes);
        ServerPlayerAPI.initialize();
        for (IServerPlayerAPI iServerPlayerAPI : ServerPlayerAPI.getAllInstancesList()) {
            iServerPlayerAPI.getServerPlayerAPI().attachServerPlayerBase(string);
        }
        System.out.println("Server Player: registered " + string);
        logger.fine("Server Player: registered class '" + clazz.getName() + "' with id '" + string + "'");
        initialized = false;
    }

    public static boolean unregister(String string) {
        boolean bl;
        if (string == null) {
            return false;
        }
        Constructor<?> constructor = allBaseConstructors.remove(string);
        if (constructor == null) {
            return false;
        }
        for (IServerPlayerAPI object : ServerPlayerAPI.getAllInstancesList()) {
            object.getServerPlayerAPI().detachServerPlayerBase(string);
        }
        beforeLocalConstructingHookTypes.remove(string);
        afterLocalConstructingHookTypes.remove(string);
        allBaseBeforeAddExhaustionSuperiors.remove(string);
        allBaseBeforeAddExhaustionInferiors.remove(string);
        allBaseOverrideAddExhaustionSuperiors.remove(string);
        allBaseOverrideAddExhaustionInferiors.remove(string);
        allBaseAfterAddExhaustionSuperiors.remove(string);
        allBaseAfterAddExhaustionInferiors.remove(string);
        beforeAddExhaustionHookTypes.remove(string);
        overrideAddExhaustionHookTypes.remove(string);
        afterAddExhaustionHookTypes.remove(string);
        allBaseBeforeAddExperienceSuperiors.remove(string);
        allBaseBeforeAddExperienceInferiors.remove(string);
        allBaseOverrideAddExperienceSuperiors.remove(string);
        allBaseOverrideAddExperienceInferiors.remove(string);
        allBaseAfterAddExperienceSuperiors.remove(string);
        allBaseAfterAddExperienceInferiors.remove(string);
        beforeAddExperienceHookTypes.remove(string);
        overrideAddExperienceHookTypes.remove(string);
        afterAddExperienceHookTypes.remove(string);
        allBaseBeforeAddExperienceLevelSuperiors.remove(string);
        allBaseBeforeAddExperienceLevelInferiors.remove(string);
        allBaseOverrideAddExperienceLevelSuperiors.remove(string);
        allBaseOverrideAddExperienceLevelInferiors.remove(string);
        allBaseAfterAddExperienceLevelSuperiors.remove(string);
        allBaseAfterAddExperienceLevelInferiors.remove(string);
        beforeAddExperienceLevelHookTypes.remove(string);
        overrideAddExperienceLevelHookTypes.remove(string);
        afterAddExperienceLevelHookTypes.remove(string);
        allBaseBeforeAddMovementStatSuperiors.remove(string);
        allBaseBeforeAddMovementStatInferiors.remove(string);
        allBaseOverrideAddMovementStatSuperiors.remove(string);
        allBaseOverrideAddMovementStatInferiors.remove(string);
        allBaseAfterAddMovementStatSuperiors.remove(string);
        allBaseAfterAddMovementStatInferiors.remove(string);
        beforeAddMovementStatHookTypes.remove(string);
        overrideAddMovementStatHookTypes.remove(string);
        afterAddMovementStatHookTypes.remove(string);
        allBaseBeforeAttackEntityFromSuperiors.remove(string);
        allBaseBeforeAttackEntityFromInferiors.remove(string);
        allBaseOverrideAttackEntityFromSuperiors.remove(string);
        allBaseOverrideAttackEntityFromInferiors.remove(string);
        allBaseAfterAttackEntityFromSuperiors.remove(string);
        allBaseAfterAttackEntityFromInferiors.remove(string);
        beforeAttackEntityFromHookTypes.remove(string);
        overrideAttackEntityFromHookTypes.remove(string);
        afterAttackEntityFromHookTypes.remove(string);
        allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors.remove(string);
        allBaseBeforeAttackTargetEntityWithCurrentItemInferiors.remove(string);
        allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors.remove(string);
        allBaseOverrideAttackTargetEntityWithCurrentItemInferiors.remove(string);
        allBaseAfterAttackTargetEntityWithCurrentItemSuperiors.remove(string);
        allBaseAfterAttackTargetEntityWithCurrentItemInferiors.remove(string);
        beforeAttackTargetEntityWithCurrentItemHookTypes.remove(string);
        overrideAttackTargetEntityWithCurrentItemHookTypes.remove(string);
        afterAttackTargetEntityWithCurrentItemHookTypes.remove(string);
        allBaseBeforeCanHarvestBlockSuperiors.remove(string);
        allBaseBeforeCanHarvestBlockInferiors.remove(string);
        allBaseOverrideCanHarvestBlockSuperiors.remove(string);
        allBaseOverrideCanHarvestBlockInferiors.remove(string);
        allBaseAfterCanHarvestBlockSuperiors.remove(string);
        allBaseAfterCanHarvestBlockInferiors.remove(string);
        beforeCanHarvestBlockHookTypes.remove(string);
        overrideCanHarvestBlockHookTypes.remove(string);
        afterCanHarvestBlockHookTypes.remove(string);
        allBaseBeforeCanPlayerEditSuperiors.remove(string);
        allBaseBeforeCanPlayerEditInferiors.remove(string);
        allBaseOverrideCanPlayerEditSuperiors.remove(string);
        allBaseOverrideCanPlayerEditInferiors.remove(string);
        allBaseAfterCanPlayerEditSuperiors.remove(string);
        allBaseAfterCanPlayerEditInferiors.remove(string);
        beforeCanPlayerEditHookTypes.remove(string);
        overrideCanPlayerEditHookTypes.remove(string);
        afterCanPlayerEditHookTypes.remove(string);
        allBaseBeforeCanTriggerWalkingSuperiors.remove(string);
        allBaseBeforeCanTriggerWalkingInferiors.remove(string);
        allBaseOverrideCanTriggerWalkingSuperiors.remove(string);
        allBaseOverrideCanTriggerWalkingInferiors.remove(string);
        allBaseAfterCanTriggerWalkingSuperiors.remove(string);
        allBaseAfterCanTriggerWalkingInferiors.remove(string);
        beforeCanTriggerWalkingHookTypes.remove(string);
        overrideCanTriggerWalkingHookTypes.remove(string);
        afterCanTriggerWalkingHookTypes.remove(string);
        allBaseBeforeClonePlayerSuperiors.remove(string);
        allBaseBeforeClonePlayerInferiors.remove(string);
        allBaseOverrideClonePlayerSuperiors.remove(string);
        allBaseOverrideClonePlayerInferiors.remove(string);
        allBaseAfterClonePlayerSuperiors.remove(string);
        allBaseAfterClonePlayerInferiors.remove(string);
        beforeClonePlayerHookTypes.remove(string);
        overrideClonePlayerHookTypes.remove(string);
        afterClonePlayerHookTypes.remove(string);
        allBaseBeforeDamageEntitySuperiors.remove(string);
        allBaseBeforeDamageEntityInferiors.remove(string);
        allBaseOverrideDamageEntitySuperiors.remove(string);
        allBaseOverrideDamageEntityInferiors.remove(string);
        allBaseAfterDamageEntitySuperiors.remove(string);
        allBaseAfterDamageEntityInferiors.remove(string);
        beforeDamageEntityHookTypes.remove(string);
        overrideDamageEntityHookTypes.remove(string);
        afterDamageEntityHookTypes.remove(string);
        allBaseBeforeDisplayGUIChestSuperiors.remove(string);
        allBaseBeforeDisplayGUIChestInferiors.remove(string);
        allBaseOverrideDisplayGUIChestSuperiors.remove(string);
        allBaseOverrideDisplayGUIChestInferiors.remove(string);
        allBaseAfterDisplayGUIChestSuperiors.remove(string);
        allBaseAfterDisplayGUIChestInferiors.remove(string);
        beforeDisplayGUIChestHookTypes.remove(string);
        overrideDisplayGUIChestHookTypes.remove(string);
        afterDisplayGUIChestHookTypes.remove(string);
        allBaseBeforeDisplayGUIDispenserSuperiors.remove(string);
        allBaseBeforeDisplayGUIDispenserInferiors.remove(string);
        allBaseOverrideDisplayGUIDispenserSuperiors.remove(string);
        allBaseOverrideDisplayGUIDispenserInferiors.remove(string);
        allBaseAfterDisplayGUIDispenserSuperiors.remove(string);
        allBaseAfterDisplayGUIDispenserInferiors.remove(string);
        beforeDisplayGUIDispenserHookTypes.remove(string);
        overrideDisplayGUIDispenserHookTypes.remove(string);
        afterDisplayGUIDispenserHookTypes.remove(string);
        allBaseBeforeDisplayGUIFurnaceSuperiors.remove(string);
        allBaseBeforeDisplayGUIFurnaceInferiors.remove(string);
        allBaseOverrideDisplayGUIFurnaceSuperiors.remove(string);
        allBaseOverrideDisplayGUIFurnaceInferiors.remove(string);
        allBaseAfterDisplayGUIFurnaceSuperiors.remove(string);
        allBaseAfterDisplayGUIFurnaceInferiors.remove(string);
        beforeDisplayGUIFurnaceHookTypes.remove(string);
        overrideDisplayGUIFurnaceHookTypes.remove(string);
        afterDisplayGUIFurnaceHookTypes.remove(string);
        allBaseBeforeDisplayGUIWorkbenchSuperiors.remove(string);
        allBaseBeforeDisplayGUIWorkbenchInferiors.remove(string);
        allBaseOverrideDisplayGUIWorkbenchSuperiors.remove(string);
        allBaseOverrideDisplayGUIWorkbenchInferiors.remove(string);
        allBaseAfterDisplayGUIWorkbenchSuperiors.remove(string);
        allBaseAfterDisplayGUIWorkbenchInferiors.remove(string);
        beforeDisplayGUIWorkbenchHookTypes.remove(string);
        overrideDisplayGUIWorkbenchHookTypes.remove(string);
        afterDisplayGUIWorkbenchHookTypes.remove(string);
        allBaseBeforeDropOneItemSuperiors.remove(string);
        allBaseBeforeDropOneItemInferiors.remove(string);
        allBaseOverrideDropOneItemSuperiors.remove(string);
        allBaseOverrideDropOneItemInferiors.remove(string);
        allBaseAfterDropOneItemSuperiors.remove(string);
        allBaseAfterDropOneItemInferiors.remove(string);
        beforeDropOneItemHookTypes.remove(string);
        overrideDropOneItemHookTypes.remove(string);
        afterDropOneItemHookTypes.remove(string);
        allBaseBeforeDropPlayerItemSuperiors.remove(string);
        allBaseBeforeDropPlayerItemInferiors.remove(string);
        allBaseOverrideDropPlayerItemSuperiors.remove(string);
        allBaseOverrideDropPlayerItemInferiors.remove(string);
        allBaseAfterDropPlayerItemSuperiors.remove(string);
        allBaseAfterDropPlayerItemInferiors.remove(string);
        beforeDropPlayerItemHookTypes.remove(string);
        overrideDropPlayerItemHookTypes.remove(string);
        afterDropPlayerItemHookTypes.remove(string);
        allBaseBeforeFallSuperiors.remove(string);
        allBaseBeforeFallInferiors.remove(string);
        allBaseOverrideFallSuperiors.remove(string);
        allBaseOverrideFallInferiors.remove(string);
        allBaseAfterFallSuperiors.remove(string);
        allBaseAfterFallInferiors.remove(string);
        beforeFallHookTypes.remove(string);
        overrideFallHookTypes.remove(string);
        afterFallHookTypes.remove(string);
        allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors.remove(string);
        allBaseBeforeGetCurrentPlayerStrVsBlockInferiors.remove(string);
        allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors.remove(string);
        allBaseOverrideGetCurrentPlayerStrVsBlockInferiors.remove(string);
        allBaseAfterGetCurrentPlayerStrVsBlockSuperiors.remove(string);
        allBaseAfterGetCurrentPlayerStrVsBlockInferiors.remove(string);
        beforeGetCurrentPlayerStrVsBlockHookTypes.remove(string);
        overrideGetCurrentPlayerStrVsBlockHookTypes.remove(string);
        afterGetCurrentPlayerStrVsBlockHookTypes.remove(string);
        allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors.remove(string);
        allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors.remove(string);
        allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors.remove(string);
        allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors.remove(string);
        allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors.remove(string);
        allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors.remove(string);
        beforeGetCurrentPlayerStrVsBlockForgeHookTypes.remove(string);
        overrideGetCurrentPlayerStrVsBlockForgeHookTypes.remove(string);
        afterGetCurrentPlayerStrVsBlockForgeHookTypes.remove(string);
        allBaseBeforeGetDistanceSqSuperiors.remove(string);
        allBaseBeforeGetDistanceSqInferiors.remove(string);
        allBaseOverrideGetDistanceSqSuperiors.remove(string);
        allBaseOverrideGetDistanceSqInferiors.remove(string);
        allBaseAfterGetDistanceSqSuperiors.remove(string);
        allBaseAfterGetDistanceSqInferiors.remove(string);
        beforeGetDistanceSqHookTypes.remove(string);
        overrideGetDistanceSqHookTypes.remove(string);
        afterGetDistanceSqHookTypes.remove(string);
        allBaseBeforeGetBrightnessSuperiors.remove(string);
        allBaseBeforeGetBrightnessInferiors.remove(string);
        allBaseOverrideGetBrightnessSuperiors.remove(string);
        allBaseOverrideGetBrightnessInferiors.remove(string);
        allBaseAfterGetBrightnessSuperiors.remove(string);
        allBaseAfterGetBrightnessInferiors.remove(string);
        beforeGetBrightnessHookTypes.remove(string);
        overrideGetBrightnessHookTypes.remove(string);
        afterGetBrightnessHookTypes.remove(string);
        allBaseBeforeGetEyeHeightSuperiors.remove(string);
        allBaseBeforeGetEyeHeightInferiors.remove(string);
        allBaseOverrideGetEyeHeightSuperiors.remove(string);
        allBaseOverrideGetEyeHeightInferiors.remove(string);
        allBaseAfterGetEyeHeightSuperiors.remove(string);
        allBaseAfterGetEyeHeightInferiors.remove(string);
        beforeGetEyeHeightHookTypes.remove(string);
        overrideGetEyeHeightHookTypes.remove(string);
        afterGetEyeHeightHookTypes.remove(string);
        allBaseBeforeHealSuperiors.remove(string);
        allBaseBeforeHealInferiors.remove(string);
        allBaseOverrideHealSuperiors.remove(string);
        allBaseOverrideHealInferiors.remove(string);
        allBaseAfterHealSuperiors.remove(string);
        allBaseAfterHealInferiors.remove(string);
        beforeHealHookTypes.remove(string);
        overrideHealHookTypes.remove(string);
        afterHealHookTypes.remove(string);
        allBaseBeforeIsEntityInsideOpaqueBlockSuperiors.remove(string);
        allBaseBeforeIsEntityInsideOpaqueBlockInferiors.remove(string);
        allBaseOverrideIsEntityInsideOpaqueBlockSuperiors.remove(string);
        allBaseOverrideIsEntityInsideOpaqueBlockInferiors.remove(string);
        allBaseAfterIsEntityInsideOpaqueBlockSuperiors.remove(string);
        allBaseAfterIsEntityInsideOpaqueBlockInferiors.remove(string);
        beforeIsEntityInsideOpaqueBlockHookTypes.remove(string);
        overrideIsEntityInsideOpaqueBlockHookTypes.remove(string);
        afterIsEntityInsideOpaqueBlockHookTypes.remove(string);
        allBaseBeforeIsInWaterSuperiors.remove(string);
        allBaseBeforeIsInWaterInferiors.remove(string);
        allBaseOverrideIsInWaterSuperiors.remove(string);
        allBaseOverrideIsInWaterInferiors.remove(string);
        allBaseAfterIsInWaterSuperiors.remove(string);
        allBaseAfterIsInWaterInferiors.remove(string);
        beforeIsInWaterHookTypes.remove(string);
        overrideIsInWaterHookTypes.remove(string);
        afterIsInWaterHookTypes.remove(string);
        allBaseBeforeIsInsideOfMaterialSuperiors.remove(string);
        allBaseBeforeIsInsideOfMaterialInferiors.remove(string);
        allBaseOverrideIsInsideOfMaterialSuperiors.remove(string);
        allBaseOverrideIsInsideOfMaterialInferiors.remove(string);
        allBaseAfterIsInsideOfMaterialSuperiors.remove(string);
        allBaseAfterIsInsideOfMaterialInferiors.remove(string);
        beforeIsInsideOfMaterialHookTypes.remove(string);
        overrideIsInsideOfMaterialHookTypes.remove(string);
        afterIsInsideOfMaterialHookTypes.remove(string);
        allBaseBeforeIsOnLadderSuperiors.remove(string);
        allBaseBeforeIsOnLadderInferiors.remove(string);
        allBaseOverrideIsOnLadderSuperiors.remove(string);
        allBaseOverrideIsOnLadderInferiors.remove(string);
        allBaseAfterIsOnLadderSuperiors.remove(string);
        allBaseAfterIsOnLadderInferiors.remove(string);
        beforeIsOnLadderHookTypes.remove(string);
        overrideIsOnLadderHookTypes.remove(string);
        afterIsOnLadderHookTypes.remove(string);
        allBaseBeforeIsPlayerSleepingSuperiors.remove(string);
        allBaseBeforeIsPlayerSleepingInferiors.remove(string);
        allBaseOverrideIsPlayerSleepingSuperiors.remove(string);
        allBaseOverrideIsPlayerSleepingInferiors.remove(string);
        allBaseAfterIsPlayerSleepingSuperiors.remove(string);
        allBaseAfterIsPlayerSleepingInferiors.remove(string);
        beforeIsPlayerSleepingHookTypes.remove(string);
        overrideIsPlayerSleepingHookTypes.remove(string);
        afterIsPlayerSleepingHookTypes.remove(string);
        allBaseBeforeJumpSuperiors.remove(string);
        allBaseBeforeJumpInferiors.remove(string);
        allBaseOverrideJumpSuperiors.remove(string);
        allBaseOverrideJumpInferiors.remove(string);
        allBaseAfterJumpSuperiors.remove(string);
        allBaseAfterJumpInferiors.remove(string);
        beforeJumpHookTypes.remove(string);
        overrideJumpHookTypes.remove(string);
        afterJumpHookTypes.remove(string);
        allBaseBeforeKnockBackSuperiors.remove(string);
        allBaseBeforeKnockBackInferiors.remove(string);
        allBaseOverrideKnockBackSuperiors.remove(string);
        allBaseOverrideKnockBackInferiors.remove(string);
        allBaseAfterKnockBackSuperiors.remove(string);
        allBaseAfterKnockBackInferiors.remove(string);
        beforeKnockBackHookTypes.remove(string);
        overrideKnockBackHookTypes.remove(string);
        afterKnockBackHookTypes.remove(string);
        allBaseBeforeMoveEntitySuperiors.remove(string);
        allBaseBeforeMoveEntityInferiors.remove(string);
        allBaseOverrideMoveEntitySuperiors.remove(string);
        allBaseOverrideMoveEntityInferiors.remove(string);
        allBaseAfterMoveEntitySuperiors.remove(string);
        allBaseAfterMoveEntityInferiors.remove(string);
        beforeMoveEntityHookTypes.remove(string);
        overrideMoveEntityHookTypes.remove(string);
        afterMoveEntityHookTypes.remove(string);
        allBaseBeforeMoveEntityWithHeadingSuperiors.remove(string);
        allBaseBeforeMoveEntityWithHeadingInferiors.remove(string);
        allBaseOverrideMoveEntityWithHeadingSuperiors.remove(string);
        allBaseOverrideMoveEntityWithHeadingInferiors.remove(string);
        allBaseAfterMoveEntityWithHeadingSuperiors.remove(string);
        allBaseAfterMoveEntityWithHeadingInferiors.remove(string);
        beforeMoveEntityWithHeadingHookTypes.remove(string);
        overrideMoveEntityWithHeadingHookTypes.remove(string);
        afterMoveEntityWithHeadingHookTypes.remove(string);
        allBaseBeforeMoveFlyingSuperiors.remove(string);
        allBaseBeforeMoveFlyingInferiors.remove(string);
        allBaseOverrideMoveFlyingSuperiors.remove(string);
        allBaseOverrideMoveFlyingInferiors.remove(string);
        allBaseAfterMoveFlyingSuperiors.remove(string);
        allBaseAfterMoveFlyingInferiors.remove(string);
        beforeMoveFlyingHookTypes.remove(string);
        overrideMoveFlyingHookTypes.remove(string);
        afterMoveFlyingHookTypes.remove(string);
        allBaseBeforeOnDeathSuperiors.remove(string);
        allBaseBeforeOnDeathInferiors.remove(string);
        allBaseOverrideOnDeathSuperiors.remove(string);
        allBaseOverrideOnDeathInferiors.remove(string);
        allBaseAfterOnDeathSuperiors.remove(string);
        allBaseAfterOnDeathInferiors.remove(string);
        beforeOnDeathHookTypes.remove(string);
        overrideOnDeathHookTypes.remove(string);
        afterOnDeathHookTypes.remove(string);
        allBaseBeforeOnLivingUpdateSuperiors.remove(string);
        allBaseBeforeOnLivingUpdateInferiors.remove(string);
        allBaseOverrideOnLivingUpdateSuperiors.remove(string);
        allBaseOverrideOnLivingUpdateInferiors.remove(string);
        allBaseAfterOnLivingUpdateSuperiors.remove(string);
        allBaseAfterOnLivingUpdateInferiors.remove(string);
        beforeOnLivingUpdateHookTypes.remove(string);
        overrideOnLivingUpdateHookTypes.remove(string);
        afterOnLivingUpdateHookTypes.remove(string);
        allBaseBeforeOnKillEntitySuperiors.remove(string);
        allBaseBeforeOnKillEntityInferiors.remove(string);
        allBaseOverrideOnKillEntitySuperiors.remove(string);
        allBaseOverrideOnKillEntityInferiors.remove(string);
        allBaseAfterOnKillEntitySuperiors.remove(string);
        allBaseAfterOnKillEntityInferiors.remove(string);
        beforeOnKillEntityHookTypes.remove(string);
        overrideOnKillEntityHookTypes.remove(string);
        afterOnKillEntityHookTypes.remove(string);
        allBaseBeforeOnStruckByLightningSuperiors.remove(string);
        allBaseBeforeOnStruckByLightningInferiors.remove(string);
        allBaseOverrideOnStruckByLightningSuperiors.remove(string);
        allBaseOverrideOnStruckByLightningInferiors.remove(string);
        allBaseAfterOnStruckByLightningSuperiors.remove(string);
        allBaseAfterOnStruckByLightningInferiors.remove(string);
        beforeOnStruckByLightningHookTypes.remove(string);
        overrideOnStruckByLightningHookTypes.remove(string);
        afterOnStruckByLightningHookTypes.remove(string);
        allBaseBeforeOnUpdateSuperiors.remove(string);
        allBaseBeforeOnUpdateInferiors.remove(string);
        allBaseOverrideOnUpdateSuperiors.remove(string);
        allBaseOverrideOnUpdateInferiors.remove(string);
        allBaseAfterOnUpdateSuperiors.remove(string);
        allBaseAfterOnUpdateInferiors.remove(string);
        beforeOnUpdateHookTypes.remove(string);
        overrideOnUpdateHookTypes.remove(string);
        afterOnUpdateHookTypes.remove(string);
        allBaseBeforeOnUpdateEntitySuperiors.remove(string);
        allBaseBeforeOnUpdateEntityInferiors.remove(string);
        allBaseOverrideOnUpdateEntitySuperiors.remove(string);
        allBaseOverrideOnUpdateEntityInferiors.remove(string);
        allBaseAfterOnUpdateEntitySuperiors.remove(string);
        allBaseAfterOnUpdateEntityInferiors.remove(string);
        beforeOnUpdateEntityHookTypes.remove(string);
        overrideOnUpdateEntityHookTypes.remove(string);
        afterOnUpdateEntityHookTypes.remove(string);
        allBaseBeforeReadEntityFromNBTSuperiors.remove(string);
        allBaseBeforeReadEntityFromNBTInferiors.remove(string);
        allBaseOverrideReadEntityFromNBTSuperiors.remove(string);
        allBaseOverrideReadEntityFromNBTInferiors.remove(string);
        allBaseAfterReadEntityFromNBTSuperiors.remove(string);
        allBaseAfterReadEntityFromNBTInferiors.remove(string);
        beforeReadEntityFromNBTHookTypes.remove(string);
        overrideReadEntityFromNBTHookTypes.remove(string);
        afterReadEntityFromNBTHookTypes.remove(string);
        allBaseBeforeSetDeadSuperiors.remove(string);
        allBaseBeforeSetDeadInferiors.remove(string);
        allBaseOverrideSetDeadSuperiors.remove(string);
        allBaseOverrideSetDeadInferiors.remove(string);
        allBaseAfterSetDeadSuperiors.remove(string);
        allBaseAfterSetDeadInferiors.remove(string);
        beforeSetDeadHookTypes.remove(string);
        overrideSetDeadHookTypes.remove(string);
        afterSetDeadHookTypes.remove(string);
        allBaseBeforeSetPositionSuperiors.remove(string);
        allBaseBeforeSetPositionInferiors.remove(string);
        allBaseOverrideSetPositionSuperiors.remove(string);
        allBaseOverrideSetPositionInferiors.remove(string);
        allBaseAfterSetPositionSuperiors.remove(string);
        allBaseAfterSetPositionInferiors.remove(string);
        beforeSetPositionHookTypes.remove(string);
        overrideSetPositionHookTypes.remove(string);
        afterSetPositionHookTypes.remove(string);
        allBaseBeforeSwingItemSuperiors.remove(string);
        allBaseBeforeSwingItemInferiors.remove(string);
        allBaseOverrideSwingItemSuperiors.remove(string);
        allBaseOverrideSwingItemInferiors.remove(string);
        allBaseAfterSwingItemSuperiors.remove(string);
        allBaseAfterSwingItemInferiors.remove(string);
        beforeSwingItemHookTypes.remove(string);
        overrideSwingItemHookTypes.remove(string);
        afterSwingItemHookTypes.remove(string);
        allBaseBeforeUpdateEntityActionStateSuperiors.remove(string);
        allBaseBeforeUpdateEntityActionStateInferiors.remove(string);
        allBaseOverrideUpdateEntityActionStateSuperiors.remove(string);
        allBaseOverrideUpdateEntityActionStateInferiors.remove(string);
        allBaseAfterUpdateEntityActionStateSuperiors.remove(string);
        allBaseAfterUpdateEntityActionStateInferiors.remove(string);
        beforeUpdateEntityActionStateHookTypes.remove(string);
        overrideUpdateEntityActionStateHookTypes.remove(string);
        afterUpdateEntityActionStateHookTypes.remove(string);
        allBaseBeforeUpdatePotionEffectsSuperiors.remove(string);
        allBaseBeforeUpdatePotionEffectsInferiors.remove(string);
        allBaseOverrideUpdatePotionEffectsSuperiors.remove(string);
        allBaseOverrideUpdatePotionEffectsInferiors.remove(string);
        allBaseAfterUpdatePotionEffectsSuperiors.remove(string);
        allBaseAfterUpdatePotionEffectsInferiors.remove(string);
        beforeUpdatePotionEffectsHookTypes.remove(string);
        overrideUpdatePotionEffectsHookTypes.remove(string);
        afterUpdatePotionEffectsHookTypes.remove(string);
        allBaseBeforeWriteEntityToNBTSuperiors.remove(string);
        allBaseBeforeWriteEntityToNBTInferiors.remove(string);
        allBaseOverrideWriteEntityToNBTSuperiors.remove(string);
        allBaseOverrideWriteEntityToNBTInferiors.remove(string);
        allBaseAfterWriteEntityToNBTSuperiors.remove(string);
        allBaseAfterWriteEntityToNBTInferiors.remove(string);
        beforeWriteEntityToNBTHookTypes.remove(string);
        overrideWriteEntityToNBTHookTypes.remove(string);
        afterWriteEntityToNBTHookTypes.remove(string);
        for (String string2 : keysToVirtualIds.keySet()) {
            if (!keysToVirtualIds.get(string2).equals(string)) continue;
            keysToVirtualIds.remove(string2);
        }
        boolean bl2 = false;
        Class<?> clazz = constructor.getDeclaringClass();
        for (String string3 : allBaseConstructors.keySet()) {
            Class<?> clazz2 = allBaseConstructors.get(string3).getDeclaringClass();
            if (string3.equals(string) || !clazz2.equals(clazz)) continue;
            bl = true;
            break;
        }
        if (!bl) {
            dynamicTypes.remove(clazz);
            virtualDynamicHookMethods.remove(clazz);
            beforeDynamicHookMethods.remove(clazz);
            overrideDynamicHookMethods.remove(clazz);
            afterDynamicHookMethods.remove(clazz);
        }
        ServerPlayerAPI.removeDynamicHookTypes(string, beforeDynamicHookTypes);
        ServerPlayerAPI.removeDynamicHookTypes(string, overrideDynamicHookTypes);
        ServerPlayerAPI.removeDynamicHookTypes(string, afterDynamicHookTypes);
        allBaseBeforeDynamicSuperiors.remove(string);
        allBaseBeforeDynamicInferiors.remove(string);
        allBaseOverrideDynamicSuperiors.remove(string);
        allBaseOverrideDynamicInferiors.remove(string);
        allBaseAfterDynamicSuperiors.remove(string);
        allBaseAfterDynamicInferiors.remove(string);
        ServerPlayerAPI.log("ServerPlayerAPI: unregistered id '" + string + "'");
        return true;
    }

    public static void removeDynamicHookTypes(String string, Map<String, List<String>> map) {
        Iterator<String> iterator2 = map.keySet().iterator();
        while (iterator2.hasNext()) {
            map.get(iterator2.next()).remove(string);
        }
    }

    public static Set<String> getRegisteredIds() {
        return unmodifiableAllIds;
    }

    private static void addSorting(String string, Map<String, String[]> map, String[] stringArray) {
        if (stringArray != null && stringArray.length > 0) {
            map.put(string, stringArray);
        }
    }

    private static void addDynamicSorting(String string, Map<String, Map<String, String[]>> map, Map<String, String[]> map2) {
        if (map2 != null && map2.size() > 0) {
            map.put(string, map2);
        }
    }

    private static boolean addMethod(String string, Class<?> clazz, List<String> list2, String string2, Class<?> ... classArray) {
        try {
            boolean bl;
            Method method = clazz.getMethod(string2, classArray);
            boolean bl2 = bl = method.getDeclaringClass() != ServerPlayerBase.class;
            if (bl) {
                list2.add(string);
            }
            return bl;
        }
        catch (Exception exception) {
            throw new RuntimeException("Can not reflect method '" + string2 + "' of class '" + clazz.getName() + "'", exception);
        }
    }

    private static void addDynamicMethods(String string, Class<?> clazz) {
        if (!dynamicTypes.add(clazz)) {
            return;
        }
        Map<String, Method> map = null;
        Map<String, Method> map2 = null;
        Map<String, Method> map3 = null;
        Map<String, Method> map4 = null;
        Method[] methodArray = clazz.getDeclaredMethods();
        for (int i = 0; i < methodArray.length; ++i) {
            String string2;
            int n;
            Method method = methodArray[i];
            if (method.getDeclaringClass() != clazz || Modifier.isAbstract(n = method.getModifiers()) || Modifier.isStatic(n) || (string2 = method.getName()).length() < 7 || !string2.substring(0, 7).equalsIgnoreCase("dynamic")) continue;
            string2 = string2.substring(7);
            while (string2.charAt(0) == '_') {
                string2 = string2.substring(1);
            }
            boolean bl = false;
            boolean bl2 = false;
            boolean bl3 = false;
            boolean bl4 = false;
            if (string2.substring(0, 7).equalsIgnoreCase("virtual")) {
                bl2 = true;
                string2 = string2.substring(7);
            } else if (string2.length() >= 8 && string2.substring(0, 8).equalsIgnoreCase("override")) {
                string2 = string2.substring(8);
                bl3 = true;
            } else if (string2.length() >= 6 && string2.substring(0, 6).equalsIgnoreCase("before")) {
                bl = true;
                string2 = string2.substring(6);
            } else if (string2.length() >= 5 && string2.substring(0, 5).equalsIgnoreCase("after")) {
                bl4 = true;
                string2 = string2.substring(5);
            }
            if (string2.length() >= 1 && (bl || bl2 || bl3 || bl4)) {
                string2 = string2.substring(0, 1).toLowerCase() + string2.substring(1);
            }
            while (string2.charAt(0) == '_') {
                string2 = string2.substring(1);
            }
            if (string2.length() == 0) {
                throw new RuntimeException("Can not process dynamic hook method with no key");
            }
            keys.add(string2);
            if (bl2) {
                if (keysToVirtualIds.containsKey(string2)) {
                    throw new RuntimeException("Can not process more than one dynamic virtual method");
                }
                keysToVirtualIds.put(string2, string);
                map = ServerPlayerAPI.addDynamicMethod(string2, method, map);
                continue;
            }
            if (bl) {
                map2 = ServerPlayerAPI.addDynamicMethod(string2, method, map2);
                continue;
            }
            if (bl4) {
                map4 = ServerPlayerAPI.addDynamicMethod(string2, method, map4);
                continue;
            }
            map3 = ServerPlayerAPI.addDynamicMethod(string2, method, map3);
        }
        if (map != null) {
            virtualDynamicHookMethods.put(clazz, map);
        }
        if (map2 != null) {
            beforeDynamicHookMethods.put(clazz, map2);
        }
        if (map3 != null) {
            overrideDynamicHookMethods.put(clazz, map3);
        }
        if (map4 != null) {
            afterDynamicHookMethods.put(clazz, map4);
        }
    }

    private static void addDynamicKeys(String string, Class<?> clazz, Map<Class<?>, Map<String, Method>> map, Map<String, List<String>> map2) {
        Map<String, Method> map3 = map.get(clazz);
        if (map3 == null || map3.size() == 0) {
            return;
        }
        for (String string2 : map3.keySet()) {
            if (!map2.containsKey(string2)) {
                map2.put(string2, new ArrayList(1));
            }
            map2.get(string2).add(string);
        }
    }

    private static Map<String, Method> addDynamicMethod(String string, Method method, Map<String, Method> map) {
        if (map == null) {
            map = new HashMap<String, Method>();
        }
        if (map.containsKey(string)) {
            throw new RuntimeException("method with key '" + string + "' allready exists");
        }
        map.put(string, method);
        return map;
    }

    public static ServerPlayerAPI create(IServerPlayerAPI iServerPlayerAPI) {
        if (allBaseConstructors.size() > 0 && !initialized) {
            ServerPlayerAPI.initialize();
        }
        return new ServerPlayerAPI(iServerPlayerAPI);
    }

    private static void initialize() {
        ServerPlayerAPI.sortBases(beforeLocalConstructingHookTypes, allBaseBeforeLocalConstructingSuperiors, allBaseBeforeLocalConstructingInferiors, "beforeLocalConstructing");
        ServerPlayerAPI.sortBases(afterLocalConstructingHookTypes, allBaseAfterLocalConstructingSuperiors, allBaseAfterLocalConstructingInferiors, "afterLocalConstructing");
        for (String string : keys) {
            ServerPlayerAPI.sortDynamicBases(beforeDynamicHookTypes, allBaseBeforeDynamicSuperiors, allBaseBeforeDynamicInferiors, string);
            ServerPlayerAPI.sortDynamicBases(overrideDynamicHookTypes, allBaseOverrideDynamicSuperiors, allBaseOverrideDynamicInferiors, string);
            ServerPlayerAPI.sortDynamicBases(afterDynamicHookTypes, allBaseAfterDynamicSuperiors, allBaseAfterDynamicInferiors, string);
        }
        ServerPlayerAPI.sortBases(beforeAddExhaustionHookTypes, allBaseBeforeAddExhaustionSuperiors, allBaseBeforeAddExhaustionInferiors, "beforeAddExhaustion");
        ServerPlayerAPI.sortBases(overrideAddExhaustionHookTypes, allBaseOverrideAddExhaustionSuperiors, allBaseOverrideAddExhaustionInferiors, "overrideAddExhaustion");
        ServerPlayerAPI.sortBases(afterAddExhaustionHookTypes, allBaseAfterAddExhaustionSuperiors, allBaseAfterAddExhaustionInferiors, "afterAddExhaustion");
        ServerPlayerAPI.sortBases(beforeAddExperienceHookTypes, allBaseBeforeAddExperienceSuperiors, allBaseBeforeAddExperienceInferiors, "beforeAddExperience");
        ServerPlayerAPI.sortBases(overrideAddExperienceHookTypes, allBaseOverrideAddExperienceSuperiors, allBaseOverrideAddExperienceInferiors, "overrideAddExperience");
        ServerPlayerAPI.sortBases(afterAddExperienceHookTypes, allBaseAfterAddExperienceSuperiors, allBaseAfterAddExperienceInferiors, "afterAddExperience");
        ServerPlayerAPI.sortBases(beforeAddExperienceLevelHookTypes, allBaseBeforeAddExperienceLevelSuperiors, allBaseBeforeAddExperienceLevelInferiors, "beforeAddExperienceLevel");
        ServerPlayerAPI.sortBases(overrideAddExperienceLevelHookTypes, allBaseOverrideAddExperienceLevelSuperiors, allBaseOverrideAddExperienceLevelInferiors, "overrideAddExperienceLevel");
        ServerPlayerAPI.sortBases(afterAddExperienceLevelHookTypes, allBaseAfterAddExperienceLevelSuperiors, allBaseAfterAddExperienceLevelInferiors, "afterAddExperienceLevel");
        ServerPlayerAPI.sortBases(beforeAddMovementStatHookTypes, allBaseBeforeAddMovementStatSuperiors, allBaseBeforeAddMovementStatInferiors, "beforeAddMovementStat");
        ServerPlayerAPI.sortBases(overrideAddMovementStatHookTypes, allBaseOverrideAddMovementStatSuperiors, allBaseOverrideAddMovementStatInferiors, "overrideAddMovementStat");
        ServerPlayerAPI.sortBases(afterAddMovementStatHookTypes, allBaseAfterAddMovementStatSuperiors, allBaseAfterAddMovementStatInferiors, "afterAddMovementStat");
        ServerPlayerAPI.sortBases(beforeAttackEntityFromHookTypes, allBaseBeforeAttackEntityFromSuperiors, allBaseBeforeAttackEntityFromInferiors, "beforeAttackEntityFrom");
        ServerPlayerAPI.sortBases(overrideAttackEntityFromHookTypes, allBaseOverrideAttackEntityFromSuperiors, allBaseOverrideAttackEntityFromInferiors, "overrideAttackEntityFrom");
        ServerPlayerAPI.sortBases(afterAttackEntityFromHookTypes, allBaseAfterAttackEntityFromSuperiors, allBaseAfterAttackEntityFromInferiors, "afterAttackEntityFrom");
        ServerPlayerAPI.sortBases(beforeAttackTargetEntityWithCurrentItemHookTypes, allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors, allBaseBeforeAttackTargetEntityWithCurrentItemInferiors, "beforeAttackTargetEntityWithCurrentItem");
        ServerPlayerAPI.sortBases(overrideAttackTargetEntityWithCurrentItemHookTypes, allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors, allBaseOverrideAttackTargetEntityWithCurrentItemInferiors, "overrideAttackTargetEntityWithCurrentItem");
        ServerPlayerAPI.sortBases(afterAttackTargetEntityWithCurrentItemHookTypes, allBaseAfterAttackTargetEntityWithCurrentItemSuperiors, allBaseAfterAttackTargetEntityWithCurrentItemInferiors, "afterAttackTargetEntityWithCurrentItem");
        ServerPlayerAPI.sortBases(beforeCanHarvestBlockHookTypes, allBaseBeforeCanHarvestBlockSuperiors, allBaseBeforeCanHarvestBlockInferiors, "beforeCanHarvestBlock");
        ServerPlayerAPI.sortBases(overrideCanHarvestBlockHookTypes, allBaseOverrideCanHarvestBlockSuperiors, allBaseOverrideCanHarvestBlockInferiors, "overrideCanHarvestBlock");
        ServerPlayerAPI.sortBases(afterCanHarvestBlockHookTypes, allBaseAfterCanHarvestBlockSuperiors, allBaseAfterCanHarvestBlockInferiors, "afterCanHarvestBlock");
        ServerPlayerAPI.sortBases(beforeCanPlayerEditHookTypes, allBaseBeforeCanPlayerEditSuperiors, allBaseBeforeCanPlayerEditInferiors, "beforeCanPlayerEdit");
        ServerPlayerAPI.sortBases(overrideCanPlayerEditHookTypes, allBaseOverrideCanPlayerEditSuperiors, allBaseOverrideCanPlayerEditInferiors, "overrideCanPlayerEdit");
        ServerPlayerAPI.sortBases(afterCanPlayerEditHookTypes, allBaseAfterCanPlayerEditSuperiors, allBaseAfterCanPlayerEditInferiors, "afterCanPlayerEdit");
        ServerPlayerAPI.sortBases(beforeCanTriggerWalkingHookTypes, allBaseBeforeCanTriggerWalkingSuperiors, allBaseBeforeCanTriggerWalkingInferiors, "beforeCanTriggerWalking");
        ServerPlayerAPI.sortBases(overrideCanTriggerWalkingHookTypes, allBaseOverrideCanTriggerWalkingSuperiors, allBaseOverrideCanTriggerWalkingInferiors, "overrideCanTriggerWalking");
        ServerPlayerAPI.sortBases(afterCanTriggerWalkingHookTypes, allBaseAfterCanTriggerWalkingSuperiors, allBaseAfterCanTriggerWalkingInferiors, "afterCanTriggerWalking");
        ServerPlayerAPI.sortBases(beforeClonePlayerHookTypes, allBaseBeforeClonePlayerSuperiors, allBaseBeforeClonePlayerInferiors, "beforeClonePlayer");
        ServerPlayerAPI.sortBases(overrideClonePlayerHookTypes, allBaseOverrideClonePlayerSuperiors, allBaseOverrideClonePlayerInferiors, "overrideClonePlayer");
        ServerPlayerAPI.sortBases(afterClonePlayerHookTypes, allBaseAfterClonePlayerSuperiors, allBaseAfterClonePlayerInferiors, "afterClonePlayer");
        ServerPlayerAPI.sortBases(beforeDamageEntityHookTypes, allBaseBeforeDamageEntitySuperiors, allBaseBeforeDamageEntityInferiors, "beforeDamageEntity");
        ServerPlayerAPI.sortBases(overrideDamageEntityHookTypes, allBaseOverrideDamageEntitySuperiors, allBaseOverrideDamageEntityInferiors, "overrideDamageEntity");
        ServerPlayerAPI.sortBases(afterDamageEntityHookTypes, allBaseAfterDamageEntitySuperiors, allBaseAfterDamageEntityInferiors, "afterDamageEntity");
        ServerPlayerAPI.sortBases(beforeDisplayGUIChestHookTypes, allBaseBeforeDisplayGUIChestSuperiors, allBaseBeforeDisplayGUIChestInferiors, "beforeDisplayGUIChest");
        ServerPlayerAPI.sortBases(overrideDisplayGUIChestHookTypes, allBaseOverrideDisplayGUIChestSuperiors, allBaseOverrideDisplayGUIChestInferiors, "overrideDisplayGUIChest");
        ServerPlayerAPI.sortBases(afterDisplayGUIChestHookTypes, allBaseAfterDisplayGUIChestSuperiors, allBaseAfterDisplayGUIChestInferiors, "afterDisplayGUIChest");
        ServerPlayerAPI.sortBases(beforeDisplayGUIDispenserHookTypes, allBaseBeforeDisplayGUIDispenserSuperiors, allBaseBeforeDisplayGUIDispenserInferiors, "beforeDisplayGUIDispenser");
        ServerPlayerAPI.sortBases(overrideDisplayGUIDispenserHookTypes, allBaseOverrideDisplayGUIDispenserSuperiors, allBaseOverrideDisplayGUIDispenserInferiors, "overrideDisplayGUIDispenser");
        ServerPlayerAPI.sortBases(afterDisplayGUIDispenserHookTypes, allBaseAfterDisplayGUIDispenserSuperiors, allBaseAfterDisplayGUIDispenserInferiors, "afterDisplayGUIDispenser");
        ServerPlayerAPI.sortBases(beforeDisplayGUIFurnaceHookTypes, allBaseBeforeDisplayGUIFurnaceSuperiors, allBaseBeforeDisplayGUIFurnaceInferiors, "beforeDisplayGUIFurnace");
        ServerPlayerAPI.sortBases(overrideDisplayGUIFurnaceHookTypes, allBaseOverrideDisplayGUIFurnaceSuperiors, allBaseOverrideDisplayGUIFurnaceInferiors, "overrideDisplayGUIFurnace");
        ServerPlayerAPI.sortBases(afterDisplayGUIFurnaceHookTypes, allBaseAfterDisplayGUIFurnaceSuperiors, allBaseAfterDisplayGUIFurnaceInferiors, "afterDisplayGUIFurnace");
        ServerPlayerAPI.sortBases(beforeDisplayGUIWorkbenchHookTypes, allBaseBeforeDisplayGUIWorkbenchSuperiors, allBaseBeforeDisplayGUIWorkbenchInferiors, "beforeDisplayGUIWorkbench");
        ServerPlayerAPI.sortBases(overrideDisplayGUIWorkbenchHookTypes, allBaseOverrideDisplayGUIWorkbenchSuperiors, allBaseOverrideDisplayGUIWorkbenchInferiors, "overrideDisplayGUIWorkbench");
        ServerPlayerAPI.sortBases(afterDisplayGUIWorkbenchHookTypes, allBaseAfterDisplayGUIWorkbenchSuperiors, allBaseAfterDisplayGUIWorkbenchInferiors, "afterDisplayGUIWorkbench");
        ServerPlayerAPI.sortBases(beforeDropOneItemHookTypes, allBaseBeforeDropOneItemSuperiors, allBaseBeforeDropOneItemInferiors, "beforeDropOneItem");
        ServerPlayerAPI.sortBases(overrideDropOneItemHookTypes, allBaseOverrideDropOneItemSuperiors, allBaseOverrideDropOneItemInferiors, "overrideDropOneItem");
        ServerPlayerAPI.sortBases(afterDropOneItemHookTypes, allBaseAfterDropOneItemSuperiors, allBaseAfterDropOneItemInferiors, "afterDropOneItem");
        ServerPlayerAPI.sortBases(beforeDropPlayerItemHookTypes, allBaseBeforeDropPlayerItemSuperiors, allBaseBeforeDropPlayerItemInferiors, "beforeDropPlayerItem");
        ServerPlayerAPI.sortBases(overrideDropPlayerItemHookTypes, allBaseOverrideDropPlayerItemSuperiors, allBaseOverrideDropPlayerItemInferiors, "overrideDropPlayerItem");
        ServerPlayerAPI.sortBases(afterDropPlayerItemHookTypes, allBaseAfterDropPlayerItemSuperiors, allBaseAfterDropPlayerItemInferiors, "afterDropPlayerItem");
        ServerPlayerAPI.sortBases(beforeFallHookTypes, allBaseBeforeFallSuperiors, allBaseBeforeFallInferiors, "beforeFall");
        ServerPlayerAPI.sortBases(overrideFallHookTypes, allBaseOverrideFallSuperiors, allBaseOverrideFallInferiors, "overrideFall");
        ServerPlayerAPI.sortBases(afterFallHookTypes, allBaseAfterFallSuperiors, allBaseAfterFallInferiors, "afterFall");
        ServerPlayerAPI.sortBases(beforeGetCurrentPlayerStrVsBlockHookTypes, allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors, allBaseBeforeGetCurrentPlayerStrVsBlockInferiors, "beforeGetCurrentPlayerStrVsBlock");
        ServerPlayerAPI.sortBases(overrideGetCurrentPlayerStrVsBlockHookTypes, allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors, allBaseOverrideGetCurrentPlayerStrVsBlockInferiors, "overrideGetCurrentPlayerStrVsBlock");
        ServerPlayerAPI.sortBases(afterGetCurrentPlayerStrVsBlockHookTypes, allBaseAfterGetCurrentPlayerStrVsBlockSuperiors, allBaseAfterGetCurrentPlayerStrVsBlockInferiors, "afterGetCurrentPlayerStrVsBlock");
        ServerPlayerAPI.sortBases(beforeGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors, "beforeGetCurrentPlayerStrVsBlockForge");
        ServerPlayerAPI.sortBases(overrideGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors, "overrideGetCurrentPlayerStrVsBlockForge");
        ServerPlayerAPI.sortBases(afterGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors, "afterGetCurrentPlayerStrVsBlockForge");
        ServerPlayerAPI.sortBases(beforeGetDistanceSqHookTypes, allBaseBeforeGetDistanceSqSuperiors, allBaseBeforeGetDistanceSqInferiors, "beforeGetDistanceSq");
        ServerPlayerAPI.sortBases(overrideGetDistanceSqHookTypes, allBaseOverrideGetDistanceSqSuperiors, allBaseOverrideGetDistanceSqInferiors, "overrideGetDistanceSq");
        ServerPlayerAPI.sortBases(afterGetDistanceSqHookTypes, allBaseAfterGetDistanceSqSuperiors, allBaseAfterGetDistanceSqInferiors, "afterGetDistanceSq");
        ServerPlayerAPI.sortBases(beforeGetBrightnessHookTypes, allBaseBeforeGetBrightnessSuperiors, allBaseBeforeGetBrightnessInferiors, "beforeGetBrightness");
        ServerPlayerAPI.sortBases(overrideGetBrightnessHookTypes, allBaseOverrideGetBrightnessSuperiors, allBaseOverrideGetBrightnessInferiors, "overrideGetBrightness");
        ServerPlayerAPI.sortBases(afterGetBrightnessHookTypes, allBaseAfterGetBrightnessSuperiors, allBaseAfterGetBrightnessInferiors, "afterGetBrightness");
        ServerPlayerAPI.sortBases(beforeGetEyeHeightHookTypes, allBaseBeforeGetEyeHeightSuperiors, allBaseBeforeGetEyeHeightInferiors, "beforeGetEyeHeight");
        ServerPlayerAPI.sortBases(overrideGetEyeHeightHookTypes, allBaseOverrideGetEyeHeightSuperiors, allBaseOverrideGetEyeHeightInferiors, "overrideGetEyeHeight");
        ServerPlayerAPI.sortBases(afterGetEyeHeightHookTypes, allBaseAfterGetEyeHeightSuperiors, allBaseAfterGetEyeHeightInferiors, "afterGetEyeHeight");
        ServerPlayerAPI.sortBases(beforeHealHookTypes, allBaseBeforeHealSuperiors, allBaseBeforeHealInferiors, "beforeHeal");
        ServerPlayerAPI.sortBases(overrideHealHookTypes, allBaseOverrideHealSuperiors, allBaseOverrideHealInferiors, "overrideHeal");
        ServerPlayerAPI.sortBases(afterHealHookTypes, allBaseAfterHealSuperiors, allBaseAfterHealInferiors, "afterHeal");
        ServerPlayerAPI.sortBases(beforeIsEntityInsideOpaqueBlockHookTypes, allBaseBeforeIsEntityInsideOpaqueBlockSuperiors, allBaseBeforeIsEntityInsideOpaqueBlockInferiors, "beforeIsEntityInsideOpaqueBlock");
        ServerPlayerAPI.sortBases(overrideIsEntityInsideOpaqueBlockHookTypes, allBaseOverrideIsEntityInsideOpaqueBlockSuperiors, allBaseOverrideIsEntityInsideOpaqueBlockInferiors, "overrideIsEntityInsideOpaqueBlock");
        ServerPlayerAPI.sortBases(afterIsEntityInsideOpaqueBlockHookTypes, allBaseAfterIsEntityInsideOpaqueBlockSuperiors, allBaseAfterIsEntityInsideOpaqueBlockInferiors, "afterIsEntityInsideOpaqueBlock");
        ServerPlayerAPI.sortBases(beforeIsInWaterHookTypes, allBaseBeforeIsInWaterSuperiors, allBaseBeforeIsInWaterInferiors, "beforeIsInWater");
        ServerPlayerAPI.sortBases(overrideIsInWaterHookTypes, allBaseOverrideIsInWaterSuperiors, allBaseOverrideIsInWaterInferiors, "overrideIsInWater");
        ServerPlayerAPI.sortBases(afterIsInWaterHookTypes, allBaseAfterIsInWaterSuperiors, allBaseAfterIsInWaterInferiors, "afterIsInWater");
        ServerPlayerAPI.sortBases(beforeIsInsideOfMaterialHookTypes, allBaseBeforeIsInsideOfMaterialSuperiors, allBaseBeforeIsInsideOfMaterialInferiors, "beforeIsInsideOfMaterial");
        ServerPlayerAPI.sortBases(overrideIsInsideOfMaterialHookTypes, allBaseOverrideIsInsideOfMaterialSuperiors, allBaseOverrideIsInsideOfMaterialInferiors, "overrideIsInsideOfMaterial");
        ServerPlayerAPI.sortBases(afterIsInsideOfMaterialHookTypes, allBaseAfterIsInsideOfMaterialSuperiors, allBaseAfterIsInsideOfMaterialInferiors, "afterIsInsideOfMaterial");
        ServerPlayerAPI.sortBases(beforeIsOnLadderHookTypes, allBaseBeforeIsOnLadderSuperiors, allBaseBeforeIsOnLadderInferiors, "beforeIsOnLadder");
        ServerPlayerAPI.sortBases(overrideIsOnLadderHookTypes, allBaseOverrideIsOnLadderSuperiors, allBaseOverrideIsOnLadderInferiors, "overrideIsOnLadder");
        ServerPlayerAPI.sortBases(afterIsOnLadderHookTypes, allBaseAfterIsOnLadderSuperiors, allBaseAfterIsOnLadderInferiors, "afterIsOnLadder");
        ServerPlayerAPI.sortBases(beforeIsPlayerSleepingHookTypes, allBaseBeforeIsPlayerSleepingSuperiors, allBaseBeforeIsPlayerSleepingInferiors, "beforeIsPlayerSleeping");
        ServerPlayerAPI.sortBases(overrideIsPlayerSleepingHookTypes, allBaseOverrideIsPlayerSleepingSuperiors, allBaseOverrideIsPlayerSleepingInferiors, "overrideIsPlayerSleeping");
        ServerPlayerAPI.sortBases(afterIsPlayerSleepingHookTypes, allBaseAfterIsPlayerSleepingSuperiors, allBaseAfterIsPlayerSleepingInferiors, "afterIsPlayerSleeping");
        ServerPlayerAPI.sortBases(beforeJumpHookTypes, allBaseBeforeJumpSuperiors, allBaseBeforeJumpInferiors, "beforeJump");
        ServerPlayerAPI.sortBases(overrideJumpHookTypes, allBaseOverrideJumpSuperiors, allBaseOverrideJumpInferiors, "overrideJump");
        ServerPlayerAPI.sortBases(afterJumpHookTypes, allBaseAfterJumpSuperiors, allBaseAfterJumpInferiors, "afterJump");
        ServerPlayerAPI.sortBases(beforeKnockBackHookTypes, allBaseBeforeKnockBackSuperiors, allBaseBeforeKnockBackInferiors, "beforeKnockBack");
        ServerPlayerAPI.sortBases(overrideKnockBackHookTypes, allBaseOverrideKnockBackSuperiors, allBaseOverrideKnockBackInferiors, "overrideKnockBack");
        ServerPlayerAPI.sortBases(afterKnockBackHookTypes, allBaseAfterKnockBackSuperiors, allBaseAfterKnockBackInferiors, "afterKnockBack");
        ServerPlayerAPI.sortBases(beforeMoveEntityHookTypes, allBaseBeforeMoveEntitySuperiors, allBaseBeforeMoveEntityInferiors, "beforeMoveEntity");
        ServerPlayerAPI.sortBases(overrideMoveEntityHookTypes, allBaseOverrideMoveEntitySuperiors, allBaseOverrideMoveEntityInferiors, "overrideMoveEntity");
        ServerPlayerAPI.sortBases(afterMoveEntityHookTypes, allBaseAfterMoveEntitySuperiors, allBaseAfterMoveEntityInferiors, "afterMoveEntity");
        ServerPlayerAPI.sortBases(beforeMoveEntityWithHeadingHookTypes, allBaseBeforeMoveEntityWithHeadingSuperiors, allBaseBeforeMoveEntityWithHeadingInferiors, "beforeMoveEntityWithHeading");
        ServerPlayerAPI.sortBases(overrideMoveEntityWithHeadingHookTypes, allBaseOverrideMoveEntityWithHeadingSuperiors, allBaseOverrideMoveEntityWithHeadingInferiors, "overrideMoveEntityWithHeading");
        ServerPlayerAPI.sortBases(afterMoveEntityWithHeadingHookTypes, allBaseAfterMoveEntityWithHeadingSuperiors, allBaseAfterMoveEntityWithHeadingInferiors, "afterMoveEntityWithHeading");
        ServerPlayerAPI.sortBases(beforeMoveFlyingHookTypes, allBaseBeforeMoveFlyingSuperiors, allBaseBeforeMoveFlyingInferiors, "beforeMoveFlying");
        ServerPlayerAPI.sortBases(overrideMoveFlyingHookTypes, allBaseOverrideMoveFlyingSuperiors, allBaseOverrideMoveFlyingInferiors, "overrideMoveFlying");
        ServerPlayerAPI.sortBases(afterMoveFlyingHookTypes, allBaseAfterMoveFlyingSuperiors, allBaseAfterMoveFlyingInferiors, "afterMoveFlying");
        ServerPlayerAPI.sortBases(beforeOnDeathHookTypes, allBaseBeforeOnDeathSuperiors, allBaseBeforeOnDeathInferiors, "beforeOnDeath");
        ServerPlayerAPI.sortBases(overrideOnDeathHookTypes, allBaseOverrideOnDeathSuperiors, allBaseOverrideOnDeathInferiors, "overrideOnDeath");
        ServerPlayerAPI.sortBases(afterOnDeathHookTypes, allBaseAfterOnDeathSuperiors, allBaseAfterOnDeathInferiors, "afterOnDeath");
        ServerPlayerAPI.sortBases(beforeOnLivingUpdateHookTypes, allBaseBeforeOnLivingUpdateSuperiors, allBaseBeforeOnLivingUpdateInferiors, "beforeOnLivingUpdate");
        ServerPlayerAPI.sortBases(overrideOnLivingUpdateHookTypes, allBaseOverrideOnLivingUpdateSuperiors, allBaseOverrideOnLivingUpdateInferiors, "overrideOnLivingUpdate");
        ServerPlayerAPI.sortBases(afterOnLivingUpdateHookTypes, allBaseAfterOnLivingUpdateSuperiors, allBaseAfterOnLivingUpdateInferiors, "afterOnLivingUpdate");
        ServerPlayerAPI.sortBases(beforeOnKillEntityHookTypes, allBaseBeforeOnKillEntitySuperiors, allBaseBeforeOnKillEntityInferiors, "beforeOnKillEntity");
        ServerPlayerAPI.sortBases(overrideOnKillEntityHookTypes, allBaseOverrideOnKillEntitySuperiors, allBaseOverrideOnKillEntityInferiors, "overrideOnKillEntity");
        ServerPlayerAPI.sortBases(afterOnKillEntityHookTypes, allBaseAfterOnKillEntitySuperiors, allBaseAfterOnKillEntityInferiors, "afterOnKillEntity");
        ServerPlayerAPI.sortBases(beforeOnStruckByLightningHookTypes, allBaseBeforeOnStruckByLightningSuperiors, allBaseBeforeOnStruckByLightningInferiors, "beforeOnStruckByLightning");
        ServerPlayerAPI.sortBases(overrideOnStruckByLightningHookTypes, allBaseOverrideOnStruckByLightningSuperiors, allBaseOverrideOnStruckByLightningInferiors, "overrideOnStruckByLightning");
        ServerPlayerAPI.sortBases(afterOnStruckByLightningHookTypes, allBaseAfterOnStruckByLightningSuperiors, allBaseAfterOnStruckByLightningInferiors, "afterOnStruckByLightning");
        ServerPlayerAPI.sortBases(beforeOnUpdateHookTypes, allBaseBeforeOnUpdateSuperiors, allBaseBeforeOnUpdateInferiors, "beforeOnUpdate");
        ServerPlayerAPI.sortBases(overrideOnUpdateHookTypes, allBaseOverrideOnUpdateSuperiors, allBaseOverrideOnUpdateInferiors, "overrideOnUpdate");
        ServerPlayerAPI.sortBases(afterOnUpdateHookTypes, allBaseAfterOnUpdateSuperiors, allBaseAfterOnUpdateInferiors, "afterOnUpdate");
        ServerPlayerAPI.sortBases(beforeOnUpdateEntityHookTypes, allBaseBeforeOnUpdateEntitySuperiors, allBaseBeforeOnUpdateEntityInferiors, "beforeOnUpdateEntity");
        ServerPlayerAPI.sortBases(overrideOnUpdateEntityHookTypes, allBaseOverrideOnUpdateEntitySuperiors, allBaseOverrideOnUpdateEntityInferiors, "overrideOnUpdateEntity");
        ServerPlayerAPI.sortBases(afterOnUpdateEntityHookTypes, allBaseAfterOnUpdateEntitySuperiors, allBaseAfterOnUpdateEntityInferiors, "afterOnUpdateEntity");
        ServerPlayerAPI.sortBases(beforeReadEntityFromNBTHookTypes, allBaseBeforeReadEntityFromNBTSuperiors, allBaseBeforeReadEntityFromNBTInferiors, "beforeReadEntityFromNBT");
        ServerPlayerAPI.sortBases(overrideReadEntityFromNBTHookTypes, allBaseOverrideReadEntityFromNBTSuperiors, allBaseOverrideReadEntityFromNBTInferiors, "overrideReadEntityFromNBT");
        ServerPlayerAPI.sortBases(afterReadEntityFromNBTHookTypes, allBaseAfterReadEntityFromNBTSuperiors, allBaseAfterReadEntityFromNBTInferiors, "afterReadEntityFromNBT");
        ServerPlayerAPI.sortBases(beforeSetDeadHookTypes, allBaseBeforeSetDeadSuperiors, allBaseBeforeSetDeadInferiors, "beforeSetDead");
        ServerPlayerAPI.sortBases(overrideSetDeadHookTypes, allBaseOverrideSetDeadSuperiors, allBaseOverrideSetDeadInferiors, "overrideSetDead");
        ServerPlayerAPI.sortBases(afterSetDeadHookTypes, allBaseAfterSetDeadSuperiors, allBaseAfterSetDeadInferiors, "afterSetDead");
        ServerPlayerAPI.sortBases(beforeSetPositionHookTypes, allBaseBeforeSetPositionSuperiors, allBaseBeforeSetPositionInferiors, "beforeSetPosition");
        ServerPlayerAPI.sortBases(overrideSetPositionHookTypes, allBaseOverrideSetPositionSuperiors, allBaseOverrideSetPositionInferiors, "overrideSetPosition");
        ServerPlayerAPI.sortBases(afterSetPositionHookTypes, allBaseAfterSetPositionSuperiors, allBaseAfterSetPositionInferiors, "afterSetPosition");
        ServerPlayerAPI.sortBases(beforeSwingItemHookTypes, allBaseBeforeSwingItemSuperiors, allBaseBeforeSwingItemInferiors, "beforeSwingItem");
        ServerPlayerAPI.sortBases(overrideSwingItemHookTypes, allBaseOverrideSwingItemSuperiors, allBaseOverrideSwingItemInferiors, "overrideSwingItem");
        ServerPlayerAPI.sortBases(afterSwingItemHookTypes, allBaseAfterSwingItemSuperiors, allBaseAfterSwingItemInferiors, "afterSwingItem");
        ServerPlayerAPI.sortBases(beforeUpdateEntityActionStateHookTypes, allBaseBeforeUpdateEntityActionStateSuperiors, allBaseBeforeUpdateEntityActionStateInferiors, "beforeUpdateEntityActionState");
        ServerPlayerAPI.sortBases(overrideUpdateEntityActionStateHookTypes, allBaseOverrideUpdateEntityActionStateSuperiors, allBaseOverrideUpdateEntityActionStateInferiors, "overrideUpdateEntityActionState");
        ServerPlayerAPI.sortBases(afterUpdateEntityActionStateHookTypes, allBaseAfterUpdateEntityActionStateSuperiors, allBaseAfterUpdateEntityActionStateInferiors, "afterUpdateEntityActionState");
        ServerPlayerAPI.sortBases(beforeUpdatePotionEffectsHookTypes, allBaseBeforeUpdatePotionEffectsSuperiors, allBaseBeforeUpdatePotionEffectsInferiors, "beforeUpdatePotionEffects");
        ServerPlayerAPI.sortBases(overrideUpdatePotionEffectsHookTypes, allBaseOverrideUpdatePotionEffectsSuperiors, allBaseOverrideUpdatePotionEffectsInferiors, "overrideUpdatePotionEffects");
        ServerPlayerAPI.sortBases(afterUpdatePotionEffectsHookTypes, allBaseAfterUpdatePotionEffectsSuperiors, allBaseAfterUpdatePotionEffectsInferiors, "afterUpdatePotionEffects");
        ServerPlayerAPI.sortBases(beforeWriteEntityToNBTHookTypes, allBaseBeforeWriteEntityToNBTSuperiors, allBaseBeforeWriteEntityToNBTInferiors, "beforeWriteEntityToNBT");
        ServerPlayerAPI.sortBases(overrideWriteEntityToNBTHookTypes, allBaseOverrideWriteEntityToNBTSuperiors, allBaseOverrideWriteEntityToNBTInferiors, "overrideWriteEntityToNBT");
        ServerPlayerAPI.sortBases(afterWriteEntityToNBTHookTypes, allBaseAfterWriteEntityToNBTSuperiors, allBaseAfterWriteEntityToNBTInferiors, "afterWriteEntityToNBT");
        initialized = true;
    }

    private static List<IServerPlayerAPI> getAllInstancesList() {
        Object object;
        Object object22;
        ArrayList<IServerPlayerAPI> arrayList = new ArrayList<IServerPlayerAPI>();
        try {
            Iterator iterator2 = dzfd.class.getMethod("_I", new Class[0]).invoke(null, new Object[0]);
            object22 = iterator2 != null ? dzfd.class.getMethod("__ag", new Class[0]).invoke(iterator2, new Object[0]) : null;
            object = object22 != null ? object22.getClass().getField("_e").get(object22) : null;
        }
        catch (Exception exception) {
            try {
                object22 = dzfd.class.getMethod("getServer", new Class[0]).invoke(null, new Object[0]);
                Object object3 = object22 != null ? dzfd.class.getMethod("getConfigurationManager", new Class[0]).invoke(object22, new Object[0]) : null;
                object = object3 != null ? object3.getClass().getField("playerEntityList").get(object3) : null;
            }
            catch (Exception exception2) {
                throw new RuntimeException("Unable to aquire list of current server players.", exception);
            }
        }
        if (object != null) {
            for (Object object22 : (List)object) {
                arrayList.add((IServerPlayerAPI)object22);
            }
        }
        return arrayList;
    }

    public static EntityPlayerMP[] getAllInstances() {
        List<IServerPlayerAPI> list2 = ServerPlayerAPI.getAllInstancesList();
        return list2.toArray(new EntityPlayerMP[list2.size()]);
    }

    public static void beforeLocalConstructing(IServerPlayerAPI iServerPlayerAPI, dzfd dzfd2, ozlu ozlu2, String string, mbsl mbsl2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null) {
            serverPlayerAPI.load();
        }
        if (serverPlayerAPI != null) {
            serverPlayerAPI.beforeLocalConstructing(dzfd2, ozlu2, string, mbsl2);
        }
    }

    public static void afterLocalConstructing(IServerPlayerAPI iServerPlayerAPI, dzfd dzfd2, ozlu ozlu2, String string, mbsl mbsl2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null) {
            serverPlayerAPI.afterLocalConstructing(dzfd2, ozlu2, string, mbsl2);
        }
    }

    public static ServerPlayerBase getServerPlayerBase(IServerPlayerAPI iServerPlayerAPI, String string) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null) {
            return serverPlayerAPI.getServerPlayerBase(string);
        }
        return null;
    }

    public static Set<String> getServerPlayerBaseIds(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        Set<String> set = null;
        set = serverPlayerAPI != null ? serverPlayerAPI.getServerPlayerBaseIds() : Collections.emptySet();
        return set;
    }

    public static Object dynamic(IServerPlayerAPI iServerPlayerAPI, String string, Object[] objectArray) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null) {
            return serverPlayerAPI.dynamic(string, objectArray);
        }
        return null;
    }

    private static void sortBases(List<String> list2, Map<String, String[]> map, Map<String, String[]> map2, String string) {
        new ServerPlayerBaseSorter(list2, map, map2, string).Sort();
    }

    private static void sortDynamicBases(Map<String, List<String>> map, Map<String, Map<String, String[]>> map2, Map<String, Map<String, String[]>> map3, String string) {
        List<String> list2 = map.get(string);
        if (list2 != null && list2.size() > 1) {
            ServerPlayerAPI.sortBases(list2, ServerPlayerAPI.getDynamicSorters(string, list2, map2), ServerPlayerAPI.getDynamicSorters(string, list2, map3), string);
        }
    }

    private static Map<String, String[]> getDynamicSorters(String string, List<String> list2, Map<String, Map<String, String[]>> map) {
        Map<String, String[]> map2 = null;
        for (String string2 : list2) {
            String[] stringArray;
            Map<String, String[]> map3 = map.get(string2);
            if (map3 == null || (stringArray = map3.get(string)) == null || stringArray.length <= 0) continue;
            if (map2 == null) {
                map2 = new HashMap<String, String[]>(1);
            }
            map2.put(string2, stringArray);
        }
        return map2 != null ? map2 : EmptySortMap;
    }

    private ServerPlayerAPI(IServerPlayerAPI iServerPlayerAPI) {
        this.player = iServerPlayerAPI;
    }

    private void load() {
        for (String string : allBaseConstructors.keySet()) {
            ServerPlayerBase serverPlayerBase = this.createServerPlayerBase(string);
            serverPlayerBase.beforeBaseAttach(false);
            this.allBaseObjects.put(string, serverPlayerBase);
            this.baseObjectsToId.put(serverPlayerBase, string);
        }
        this.beforeLocalConstructingHooks = this.create(beforeLocalConstructingHookTypes);
        this.afterLocalConstructingHooks = this.create(afterLocalConstructingHookTypes);
        this.updateServerPlayerBases();
        Iterator<String> iterator2 = this.allBaseObjects.keySet().iterator();
        while (iterator2.hasNext()) {
            this.allBaseObjects.get(iterator2.next()).afterBaseAttach(false);
        }
    }

    private ServerPlayerBase createServerPlayerBase(String string) {
        ServerPlayerBase serverPlayerBase;
        Constructor<?> constructor = allBaseConstructors.get(string);
        try {
            serverPlayerBase = constructor.getParameterTypes().length == 1 ? (ServerPlayerBase)constructor.newInstance(this) : (ServerPlayerBase)constructor.newInstance(this, string);
        }
        catch (Exception exception) {
            throw new RuntimeException("Exception while creating a ServerPlayerBase of type '" + constructor.getDeclaringClass() + "'", exception);
        }
        return serverPlayerBase;
    }

    private void updateServerPlayerBases() {
        this.beforeAddExhaustionHooks = this.create(beforeAddExhaustionHookTypes);
        this.overrideAddExhaustionHooks = this.create(overrideAddExhaustionHookTypes);
        this.afterAddExhaustionHooks = this.create(afterAddExhaustionHookTypes);
        this.isAddExhaustionModded = this.beforeAddExhaustionHooks != null || this.overrideAddExhaustionHooks != null || this.afterAddExhaustionHooks != null;
        this.beforeAddExperienceHooks = this.create(beforeAddExperienceHookTypes);
        this.overrideAddExperienceHooks = this.create(overrideAddExperienceHookTypes);
        this.afterAddExperienceHooks = this.create(afterAddExperienceHookTypes);
        this.isAddExperienceModded = this.beforeAddExperienceHooks != null || this.overrideAddExperienceHooks != null || this.afterAddExperienceHooks != null;
        this.beforeAddExperienceLevelHooks = this.create(beforeAddExperienceLevelHookTypes);
        this.overrideAddExperienceLevelHooks = this.create(overrideAddExperienceLevelHookTypes);
        this.afterAddExperienceLevelHooks = this.create(afterAddExperienceLevelHookTypes);
        this.isAddExperienceLevelModded = this.beforeAddExperienceLevelHooks != null || this.overrideAddExperienceLevelHooks != null || this.afterAddExperienceLevelHooks != null;
        this.beforeAddMovementStatHooks = this.create(beforeAddMovementStatHookTypes);
        this.overrideAddMovementStatHooks = this.create(overrideAddMovementStatHookTypes);
        this.afterAddMovementStatHooks = this.create(afterAddMovementStatHookTypes);
        this.isAddMovementStatModded = this.beforeAddMovementStatHooks != null || this.overrideAddMovementStatHooks != null || this.afterAddMovementStatHooks != null;
        this.beforeAttackEntityFromHooks = this.create(beforeAttackEntityFromHookTypes);
        this.overrideAttackEntityFromHooks = this.create(overrideAttackEntityFromHookTypes);
        this.afterAttackEntityFromHooks = this.create(afterAttackEntityFromHookTypes);
        this.isAttackEntityFromModded = this.beforeAttackEntityFromHooks != null || this.overrideAttackEntityFromHooks != null || this.afterAttackEntityFromHooks != null;
        this.beforeAttackTargetEntityWithCurrentItemHooks = this.create(beforeAttackTargetEntityWithCurrentItemHookTypes);
        this.overrideAttackTargetEntityWithCurrentItemHooks = this.create(overrideAttackTargetEntityWithCurrentItemHookTypes);
        this.afterAttackTargetEntityWithCurrentItemHooks = this.create(afterAttackTargetEntityWithCurrentItemHookTypes);
        this.isAttackTargetEntityWithCurrentItemModded = this.beforeAttackTargetEntityWithCurrentItemHooks != null || this.overrideAttackTargetEntityWithCurrentItemHooks != null || this.afterAttackTargetEntityWithCurrentItemHooks != null;
        this.beforeCanHarvestBlockHooks = this.create(beforeCanHarvestBlockHookTypes);
        this.overrideCanHarvestBlockHooks = this.create(overrideCanHarvestBlockHookTypes);
        this.afterCanHarvestBlockHooks = this.create(afterCanHarvestBlockHookTypes);
        this.isCanHarvestBlockModded = this.beforeCanHarvestBlockHooks != null || this.overrideCanHarvestBlockHooks != null || this.afterCanHarvestBlockHooks != null;
        this.beforeCanPlayerEditHooks = this.create(beforeCanPlayerEditHookTypes);
        this.overrideCanPlayerEditHooks = this.create(overrideCanPlayerEditHookTypes);
        this.afterCanPlayerEditHooks = this.create(afterCanPlayerEditHookTypes);
        this.isCanPlayerEditModded = this.beforeCanPlayerEditHooks != null || this.overrideCanPlayerEditHooks != null || this.afterCanPlayerEditHooks != null;
        this.beforeCanTriggerWalkingHooks = this.create(beforeCanTriggerWalkingHookTypes);
        this.overrideCanTriggerWalkingHooks = this.create(overrideCanTriggerWalkingHookTypes);
        this.afterCanTriggerWalkingHooks = this.create(afterCanTriggerWalkingHookTypes);
        this.isCanTriggerWalkingModded = this.beforeCanTriggerWalkingHooks != null || this.overrideCanTriggerWalkingHooks != null || this.afterCanTriggerWalkingHooks != null;
        this.beforeClonePlayerHooks = this.create(beforeClonePlayerHookTypes);
        this.overrideClonePlayerHooks = this.create(overrideClonePlayerHookTypes);
        this.afterClonePlayerHooks = this.create(afterClonePlayerHookTypes);
        this.isClonePlayerModded = this.beforeClonePlayerHooks != null || this.overrideClonePlayerHooks != null || this.afterClonePlayerHooks != null;
        this.beforeDamageEntityHooks = this.create(beforeDamageEntityHookTypes);
        this.overrideDamageEntityHooks = this.create(overrideDamageEntityHookTypes);
        this.afterDamageEntityHooks = this.create(afterDamageEntityHookTypes);
        this.isDamageEntityModded = this.beforeDamageEntityHooks != null || this.overrideDamageEntityHooks != null || this.afterDamageEntityHooks != null;
        this.beforeDisplayGUIChestHooks = this.create(beforeDisplayGUIChestHookTypes);
        this.overrideDisplayGUIChestHooks = this.create(overrideDisplayGUIChestHookTypes);
        this.afterDisplayGUIChestHooks = this.create(afterDisplayGUIChestHookTypes);
        this.isDisplayGUIChestModded = this.beforeDisplayGUIChestHooks != null || this.overrideDisplayGUIChestHooks != null || this.afterDisplayGUIChestHooks != null;
        this.beforeDisplayGUIDispenserHooks = this.create(beforeDisplayGUIDispenserHookTypes);
        this.overrideDisplayGUIDispenserHooks = this.create(overrideDisplayGUIDispenserHookTypes);
        this.afterDisplayGUIDispenserHooks = this.create(afterDisplayGUIDispenserHookTypes);
        this.isDisplayGUIDispenserModded = this.beforeDisplayGUIDispenserHooks != null || this.overrideDisplayGUIDispenserHooks != null || this.afterDisplayGUIDispenserHooks != null;
        this.beforeDisplayGUIFurnaceHooks = this.create(beforeDisplayGUIFurnaceHookTypes);
        this.overrideDisplayGUIFurnaceHooks = this.create(overrideDisplayGUIFurnaceHookTypes);
        this.afterDisplayGUIFurnaceHooks = this.create(afterDisplayGUIFurnaceHookTypes);
        this.isDisplayGUIFurnaceModded = this.beforeDisplayGUIFurnaceHooks != null || this.overrideDisplayGUIFurnaceHooks != null || this.afterDisplayGUIFurnaceHooks != null;
        this.beforeDisplayGUIWorkbenchHooks = this.create(beforeDisplayGUIWorkbenchHookTypes);
        this.overrideDisplayGUIWorkbenchHooks = this.create(overrideDisplayGUIWorkbenchHookTypes);
        this.afterDisplayGUIWorkbenchHooks = this.create(afterDisplayGUIWorkbenchHookTypes);
        this.isDisplayGUIWorkbenchModded = this.beforeDisplayGUIWorkbenchHooks != null || this.overrideDisplayGUIWorkbenchHooks != null || this.afterDisplayGUIWorkbenchHooks != null;
        this.beforeDropOneItemHooks = this.create(beforeDropOneItemHookTypes);
        this.overrideDropOneItemHooks = this.create(overrideDropOneItemHookTypes);
        this.afterDropOneItemHooks = this.create(afterDropOneItemHookTypes);
        this.isDropOneItemModded = this.beforeDropOneItemHooks != null || this.overrideDropOneItemHooks != null || this.afterDropOneItemHooks != null;
        this.beforeDropPlayerItemHooks = this.create(beforeDropPlayerItemHookTypes);
        this.overrideDropPlayerItemHooks = this.create(overrideDropPlayerItemHookTypes);
        this.afterDropPlayerItemHooks = this.create(afterDropPlayerItemHookTypes);
        this.isDropPlayerItemModded = this.beforeDropPlayerItemHooks != null || this.overrideDropPlayerItemHooks != null || this.afterDropPlayerItemHooks != null;
        this.beforeFallHooks = this.create(beforeFallHookTypes);
        this.overrideFallHooks = this.create(overrideFallHookTypes);
        this.afterFallHooks = this.create(afterFallHookTypes);
        this.isFallModded = this.beforeFallHooks != null || this.overrideFallHooks != null || this.afterFallHooks != null;
        this.beforeGetCurrentPlayerStrVsBlockHooks = this.create(beforeGetCurrentPlayerStrVsBlockHookTypes);
        this.overrideGetCurrentPlayerStrVsBlockHooks = this.create(overrideGetCurrentPlayerStrVsBlockHookTypes);
        this.afterGetCurrentPlayerStrVsBlockHooks = this.create(afterGetCurrentPlayerStrVsBlockHookTypes);
        this.isGetCurrentPlayerStrVsBlockModded = this.beforeGetCurrentPlayerStrVsBlockHooks != null || this.overrideGetCurrentPlayerStrVsBlockHooks != null || this.afterGetCurrentPlayerStrVsBlockHooks != null;
        this.beforeGetCurrentPlayerStrVsBlockForgeHooks = this.create(beforeGetCurrentPlayerStrVsBlockForgeHookTypes);
        this.overrideGetCurrentPlayerStrVsBlockForgeHooks = this.create(overrideGetCurrentPlayerStrVsBlockForgeHookTypes);
        this.afterGetCurrentPlayerStrVsBlockForgeHooks = this.create(afterGetCurrentPlayerStrVsBlockForgeHookTypes);
        this.isGetCurrentPlayerStrVsBlockForgeModded = this.beforeGetCurrentPlayerStrVsBlockForgeHooks != null || this.overrideGetCurrentPlayerStrVsBlockForgeHooks != null || this.afterGetCurrentPlayerStrVsBlockForgeHooks != null;
        this.beforeGetDistanceSqHooks = this.create(beforeGetDistanceSqHookTypes);
        this.overrideGetDistanceSqHooks = this.create(overrideGetDistanceSqHookTypes);
        this.afterGetDistanceSqHooks = this.create(afterGetDistanceSqHookTypes);
        this.isGetDistanceSqModded = this.beforeGetDistanceSqHooks != null || this.overrideGetDistanceSqHooks != null || this.afterGetDistanceSqHooks != null;
        this.beforeGetBrightnessHooks = this.create(beforeGetBrightnessHookTypes);
        this.overrideGetBrightnessHooks = this.create(overrideGetBrightnessHookTypes);
        this.afterGetBrightnessHooks = this.create(afterGetBrightnessHookTypes);
        this.isGetBrightnessModded = this.beforeGetBrightnessHooks != null || this.overrideGetBrightnessHooks != null || this.afterGetBrightnessHooks != null;
        this.beforeGetEyeHeightHooks = this.create(beforeGetEyeHeightHookTypes);
        this.overrideGetEyeHeightHooks = this.create(overrideGetEyeHeightHookTypes);
        this.afterGetEyeHeightHooks = this.create(afterGetEyeHeightHookTypes);
        this.isGetEyeHeightModded = this.beforeGetEyeHeightHooks != null || this.overrideGetEyeHeightHooks != null || this.afterGetEyeHeightHooks != null;
        this.beforeHealHooks = this.create(beforeHealHookTypes);
        this.overrideHealHooks = this.create(overrideHealHookTypes);
        this.afterHealHooks = this.create(afterHealHookTypes);
        this.isHealModded = this.beforeHealHooks != null || this.overrideHealHooks != null || this.afterHealHooks != null;
        this.beforeIsEntityInsideOpaqueBlockHooks = this.create(beforeIsEntityInsideOpaqueBlockHookTypes);
        this.overrideIsEntityInsideOpaqueBlockHooks = this.create(overrideIsEntityInsideOpaqueBlockHookTypes);
        this.afterIsEntityInsideOpaqueBlockHooks = this.create(afterIsEntityInsideOpaqueBlockHookTypes);
        this.isIsEntityInsideOpaqueBlockModded = this.beforeIsEntityInsideOpaqueBlockHooks != null || this.overrideIsEntityInsideOpaqueBlockHooks != null || this.afterIsEntityInsideOpaqueBlockHooks != null;
        this.beforeIsInWaterHooks = this.create(beforeIsInWaterHookTypes);
        this.overrideIsInWaterHooks = this.create(overrideIsInWaterHookTypes);
        this.afterIsInWaterHooks = this.create(afterIsInWaterHookTypes);
        this.isIsInWaterModded = this.beforeIsInWaterHooks != null || this.overrideIsInWaterHooks != null || this.afterIsInWaterHooks != null;
        this.beforeIsInsideOfMaterialHooks = this.create(beforeIsInsideOfMaterialHookTypes);
        this.overrideIsInsideOfMaterialHooks = this.create(overrideIsInsideOfMaterialHookTypes);
        this.afterIsInsideOfMaterialHooks = this.create(afterIsInsideOfMaterialHookTypes);
        this.isIsInsideOfMaterialModded = this.beforeIsInsideOfMaterialHooks != null || this.overrideIsInsideOfMaterialHooks != null || this.afterIsInsideOfMaterialHooks != null;
        this.beforeIsOnLadderHooks = this.create(beforeIsOnLadderHookTypes);
        this.overrideIsOnLadderHooks = this.create(overrideIsOnLadderHookTypes);
        this.afterIsOnLadderHooks = this.create(afterIsOnLadderHookTypes);
        this.isIsOnLadderModded = this.beforeIsOnLadderHooks != null || this.overrideIsOnLadderHooks != null || this.afterIsOnLadderHooks != null;
        this.beforeIsPlayerSleepingHooks = this.create(beforeIsPlayerSleepingHookTypes);
        this.overrideIsPlayerSleepingHooks = this.create(overrideIsPlayerSleepingHookTypes);
        this.afterIsPlayerSleepingHooks = this.create(afterIsPlayerSleepingHookTypes);
        this.isIsPlayerSleepingModded = this.beforeIsPlayerSleepingHooks != null || this.overrideIsPlayerSleepingHooks != null || this.afterIsPlayerSleepingHooks != null;
        this.beforeJumpHooks = this.create(beforeJumpHookTypes);
        this.overrideJumpHooks = this.create(overrideJumpHookTypes);
        this.afterJumpHooks = this.create(afterJumpHookTypes);
        this.isJumpModded = this.beforeJumpHooks != null || this.overrideJumpHooks != null || this.afterJumpHooks != null;
        this.beforeKnockBackHooks = this.create(beforeKnockBackHookTypes);
        this.overrideKnockBackHooks = this.create(overrideKnockBackHookTypes);
        this.afterKnockBackHooks = this.create(afterKnockBackHookTypes);
        this.isKnockBackModded = this.beforeKnockBackHooks != null || this.overrideKnockBackHooks != null || this.afterKnockBackHooks != null;
        this.beforeMoveEntityHooks = this.create(beforeMoveEntityHookTypes);
        this.overrideMoveEntityHooks = this.create(overrideMoveEntityHookTypes);
        this.afterMoveEntityHooks = this.create(afterMoveEntityHookTypes);
        this.isMoveEntityModded = this.beforeMoveEntityHooks != null || this.overrideMoveEntityHooks != null || this.afterMoveEntityHooks != null;
        this.beforeMoveEntityWithHeadingHooks = this.create(beforeMoveEntityWithHeadingHookTypes);
        this.overrideMoveEntityWithHeadingHooks = this.create(overrideMoveEntityWithHeadingHookTypes);
        this.afterMoveEntityWithHeadingHooks = this.create(afterMoveEntityWithHeadingHookTypes);
        this.isMoveEntityWithHeadingModded = this.beforeMoveEntityWithHeadingHooks != null || this.overrideMoveEntityWithHeadingHooks != null || this.afterMoveEntityWithHeadingHooks != null;
        this.beforeMoveFlyingHooks = this.create(beforeMoveFlyingHookTypes);
        this.overrideMoveFlyingHooks = this.create(overrideMoveFlyingHookTypes);
        this.afterMoveFlyingHooks = this.create(afterMoveFlyingHookTypes);
        this.isMoveFlyingModded = this.beforeMoveFlyingHooks != null || this.overrideMoveFlyingHooks != null || this.afterMoveFlyingHooks != null;
        this.beforeOnDeathHooks = this.create(beforeOnDeathHookTypes);
        this.overrideOnDeathHooks = this.create(overrideOnDeathHookTypes);
        this.afterOnDeathHooks = this.create(afterOnDeathHookTypes);
        this.isOnDeathModded = this.beforeOnDeathHooks != null || this.overrideOnDeathHooks != null || this.afterOnDeathHooks != null;
        this.beforeOnLivingUpdateHooks = this.create(beforeOnLivingUpdateHookTypes);
        this.overrideOnLivingUpdateHooks = this.create(overrideOnLivingUpdateHookTypes);
        this.afterOnLivingUpdateHooks = this.create(afterOnLivingUpdateHookTypes);
        this.isOnLivingUpdateModded = this.beforeOnLivingUpdateHooks != null || this.overrideOnLivingUpdateHooks != null || this.afterOnLivingUpdateHooks != null;
        this.beforeOnKillEntityHooks = this.create(beforeOnKillEntityHookTypes);
        this.overrideOnKillEntityHooks = this.create(overrideOnKillEntityHookTypes);
        this.afterOnKillEntityHooks = this.create(afterOnKillEntityHookTypes);
        this.isOnKillEntityModded = this.beforeOnKillEntityHooks != null || this.overrideOnKillEntityHooks != null || this.afterOnKillEntityHooks != null;
        this.beforeOnStruckByLightningHooks = this.create(beforeOnStruckByLightningHookTypes);
        this.overrideOnStruckByLightningHooks = this.create(overrideOnStruckByLightningHookTypes);
        this.afterOnStruckByLightningHooks = this.create(afterOnStruckByLightningHookTypes);
        this.isOnStruckByLightningModded = this.beforeOnStruckByLightningHooks != null || this.overrideOnStruckByLightningHooks != null || this.afterOnStruckByLightningHooks != null;
        this.beforeOnUpdateHooks = this.create(beforeOnUpdateHookTypes);
        this.overrideOnUpdateHooks = this.create(overrideOnUpdateHookTypes);
        this.afterOnUpdateHooks = this.create(afterOnUpdateHookTypes);
        this.isOnUpdateModded = this.beforeOnUpdateHooks != null || this.overrideOnUpdateHooks != null || this.afterOnUpdateHooks != null;
        this.beforeOnUpdateEntityHooks = this.create(beforeOnUpdateEntityHookTypes);
        this.overrideOnUpdateEntityHooks = this.create(overrideOnUpdateEntityHookTypes);
        this.afterOnUpdateEntityHooks = this.create(afterOnUpdateEntityHookTypes);
        this.isOnUpdateEntityModded = this.beforeOnUpdateEntityHooks != null || this.overrideOnUpdateEntityHooks != null || this.afterOnUpdateEntityHooks != null;
        this.beforeReadEntityFromNBTHooks = this.create(beforeReadEntityFromNBTHookTypes);
        this.overrideReadEntityFromNBTHooks = this.create(overrideReadEntityFromNBTHookTypes);
        this.afterReadEntityFromNBTHooks = this.create(afterReadEntityFromNBTHookTypes);
        this.isReadEntityFromNBTModded = this.beforeReadEntityFromNBTHooks != null || this.overrideReadEntityFromNBTHooks != null || this.afterReadEntityFromNBTHooks != null;
        this.beforeSetDeadHooks = this.create(beforeSetDeadHookTypes);
        this.overrideSetDeadHooks = this.create(overrideSetDeadHookTypes);
        this.afterSetDeadHooks = this.create(afterSetDeadHookTypes);
        this.isSetDeadModded = this.beforeSetDeadHooks != null || this.overrideSetDeadHooks != null || this.afterSetDeadHooks != null;
        this.beforeSetPositionHooks = this.create(beforeSetPositionHookTypes);
        this.overrideSetPositionHooks = this.create(overrideSetPositionHookTypes);
        this.afterSetPositionHooks = this.create(afterSetPositionHookTypes);
        this.isSetPositionModded = this.beforeSetPositionHooks != null || this.overrideSetPositionHooks != null || this.afterSetPositionHooks != null;
        this.beforeSwingItemHooks = this.create(beforeSwingItemHookTypes);
        this.overrideSwingItemHooks = this.create(overrideSwingItemHookTypes);
        this.afterSwingItemHooks = this.create(afterSwingItemHookTypes);
        this.isSwingItemModded = this.beforeSwingItemHooks != null || this.overrideSwingItemHooks != null || this.afterSwingItemHooks != null;
        this.beforeUpdateEntityActionStateHooks = this.create(beforeUpdateEntityActionStateHookTypes);
        this.overrideUpdateEntityActionStateHooks = this.create(overrideUpdateEntityActionStateHookTypes);
        this.afterUpdateEntityActionStateHooks = this.create(afterUpdateEntityActionStateHookTypes);
        this.isUpdateEntityActionStateModded = this.beforeUpdateEntityActionStateHooks != null || this.overrideUpdateEntityActionStateHooks != null || this.afterUpdateEntityActionStateHooks != null;
        this.beforeUpdatePotionEffectsHooks = this.create(beforeUpdatePotionEffectsHookTypes);
        this.overrideUpdatePotionEffectsHooks = this.create(overrideUpdatePotionEffectsHookTypes);
        this.afterUpdatePotionEffectsHooks = this.create(afterUpdatePotionEffectsHookTypes);
        this.isUpdatePotionEffectsModded = this.beforeUpdatePotionEffectsHooks != null || this.overrideUpdatePotionEffectsHooks != null || this.afterUpdatePotionEffectsHooks != null;
        this.beforeWriteEntityToNBTHooks = this.create(beforeWriteEntityToNBTHookTypes);
        this.overrideWriteEntityToNBTHooks = this.create(overrideWriteEntityToNBTHookTypes);
        this.afterWriteEntityToNBTHooks = this.create(afterWriteEntityToNBTHookTypes);
        this.isWriteEntityToNBTModded = this.beforeWriteEntityToNBTHooks != null || this.overrideWriteEntityToNBTHooks != null || this.afterWriteEntityToNBTHooks != null;
    }

    private void attachServerPlayerBase(String string) {
        ServerPlayerBase serverPlayerBase = this.createServerPlayerBase(string);
        serverPlayerBase.beforeBaseAttach(true);
        this.allBaseObjects.put(string, serverPlayerBase);
        this.updateServerPlayerBases();
        serverPlayerBase.afterBaseAttach(true);
    }

    private void detachServerPlayerBase(String string) {
        ServerPlayerBase serverPlayerBase = this.allBaseObjects.get(string);
        serverPlayerBase.beforeBaseDetach(true);
        this.allBaseObjects.remove(string);
        this.updateServerPlayerBases();
        serverPlayerBase.afterBaseDetach(true);
    }

    private ServerPlayerBase[] create(List<String> list2) {
        if (list2.isEmpty()) {
            return null;
        }
        ServerPlayerBase[] serverPlayerBaseArray = new ServerPlayerBase[list2.size()];
        for (int i = 0; i < serverPlayerBaseArray.length; ++i) {
            serverPlayerBaseArray[i] = this.getServerPlayerBase(list2.get(i));
        }
        return serverPlayerBaseArray;
    }

    private void beforeLocalConstructing(dzfd dzfd2, ozlu ozlu2, String string, mbsl mbsl2) {
        if (this.beforeLocalConstructingHooks != null) {
            for (int i = this.beforeLocalConstructingHooks.length - 1; i >= 0; --i) {
                this.beforeLocalConstructingHooks[i].beforeLocalConstructing(dzfd2, ozlu2, string, mbsl2);
            }
        }
        this.beforeLocalConstructingHooks = null;
    }

    private void afterLocalConstructing(dzfd dzfd2, ozlu ozlu2, String string, mbsl mbsl2) {
        if (this.afterLocalConstructingHooks != null) {
            for (int i = 0; i < this.afterLocalConstructingHooks.length; ++i) {
                this.afterLocalConstructingHooks[i].afterLocalConstructing(dzfd2, ozlu2, string, mbsl2);
            }
        }
        this.afterLocalConstructingHooks = null;
    }

    public ServerPlayerBase getServerPlayerBase(String string) {
        return this.allBaseObjects.get(string);
    }

    public Set<String> getServerPlayerBaseIds() {
        return this.unmodifiableAllBaseIds;
    }

    public Object dynamic(String string, Object[] objectArray) {
        string = string.replace('.', '_').replace(' ', '_');
        this.executeAll(string, objectArray, beforeDynamicHookTypes, beforeDynamicHookMethods, true);
        Object object = this.dynamicOverwritten(string, objectArray, null);
        this.executeAll(string, objectArray, afterDynamicHookTypes, afterDynamicHookMethods, false);
        return object;
    }

    public Object dynamicOverwritten(String string, Object[] objectArray, ServerPlayerBase serverPlayerBase) {
        Map<Class<?>, Map<String, Method>> map;
        List<String> list2 = overrideDynamicHookTypes.get(string);
        String string2 = null;
        if (list2 != null) {
            if (serverPlayerBase != null) {
                string2 = this.baseObjectsToId.get(serverPlayerBase);
                int n = list2.indexOf(string2);
                string2 = n > 0 ? list2.get(n - 1) : null;
            } else if (list2.size() > 0) {
                string2 = list2.get(list2.size() - 1);
            }
        }
        if (string2 == null) {
            string2 = keysToVirtualIds.get(string);
            if (string2 == null) {
                return null;
            }
            map = virtualDynamicHookMethods;
        } else {
            map = overrideDynamicHookMethods;
        }
        Map<String, Method> map2 = map.get(allBaseConstructors.get(string2).getDeclaringClass());
        if (map2 == null) {
            return null;
        }
        Method method = map2.get(string);
        if (map2 == null) {
            return null;
        }
        return this.execute(this.getServerPlayerBase(string2), method, objectArray);
    }

    private void executeAll(String string, Object[] objectArray, Map<String, List<String>> map, Map<Class<?>, Map<String, Method>> map2, boolean bl) {
        int n;
        List<String> list2 = map.get(string);
        if (list2 == null) {
            return;
        }
        int n2 = n = bl ? list2.size() - 1 : 0;
        while (bl ? n >= 0 : n < list2.size()) {
            Method method;
            String string2 = list2.get(n);
            ServerPlayerBase serverPlayerBase = this.getServerPlayerBase(string2);
            Class<?> clazz = serverPlayerBase.getClass();
            Map<String, Method> map3 = map2.get(clazz);
            if (map3 != null && (method = map3.get(string)) != null) {
                this.execute(serverPlayerBase, method, objectArray);
            }
            n += bl ? -1 : 1;
        }
    }

    private Object execute(ServerPlayerBase serverPlayerBase, Method method, Object[] objectArray) {
        try {
            return method.invoke(serverPlayerBase, objectArray);
        }
        catch (Exception exception) {
            throw new RuntimeException("Exception while invoking dynamic method", exception);
        }
    }

    public static void addExhaustion(IServerPlayerAPI iServerPlayerAPI, float f) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isAddExhaustionModded) {
            serverPlayerAPI.addExhaustion(f);
        } else {
            iServerPlayerAPI.localAddExhaustion(f);
        }
    }

    private void addExhaustion(float f) {
        int n;
        if (this.beforeAddExhaustionHooks != null) {
            for (n = this.beforeAddExhaustionHooks.length - 1; n >= 0; --n) {
                this.beforeAddExhaustionHooks[n].beforeAddExhaustion(f);
            }
        }
        if (this.overrideAddExhaustionHooks != null) {
            this.overrideAddExhaustionHooks[this.overrideAddExhaustionHooks.length - 1].addExhaustion(f);
        } else {
            this.player.localAddExhaustion(f);
        }
        if (this.afterAddExhaustionHooks != null) {
            for (n = 0; n < this.afterAddExhaustionHooks.length; ++n) {
                this.afterAddExhaustionHooks[n].afterAddExhaustion(f);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenAddExhaustion(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideAddExhaustionHooks.length; ++i) {
            if (this.overrideAddExhaustionHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideAddExhaustionHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void addExperience(IServerPlayerAPI iServerPlayerAPI, int n) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isAddExperienceModded) {
            serverPlayerAPI.addExperience(n);
        } else {
            iServerPlayerAPI.localAddExperience(n);
        }
    }

    private void addExperience(int n) {
        int n2;
        if (this.beforeAddExperienceHooks != null) {
            for (n2 = this.beforeAddExperienceHooks.length - 1; n2 >= 0; --n2) {
                this.beforeAddExperienceHooks[n2].beforeAddExperience(n);
            }
        }
        if (this.overrideAddExperienceHooks != null) {
            this.overrideAddExperienceHooks[this.overrideAddExperienceHooks.length - 1].addExperience(n);
        } else {
            this.player.localAddExperience(n);
        }
        if (this.afterAddExperienceHooks != null) {
            for (n2 = 0; n2 < this.afterAddExperienceHooks.length; ++n2) {
                this.afterAddExperienceHooks[n2].afterAddExperience(n);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenAddExperience(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideAddExperienceHooks.length; ++i) {
            if (this.overrideAddExperienceHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideAddExperienceHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void addExperienceLevel(IServerPlayerAPI iServerPlayerAPI, int n) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isAddExperienceLevelModded) {
            serverPlayerAPI.addExperienceLevel(n);
        } else {
            iServerPlayerAPI.localAddExperienceLevel(n);
        }
    }

    private void addExperienceLevel(int n) {
        int n2;
        if (this.beforeAddExperienceLevelHooks != null) {
            for (n2 = this.beforeAddExperienceLevelHooks.length - 1; n2 >= 0; --n2) {
                this.beforeAddExperienceLevelHooks[n2].beforeAddExperienceLevel(n);
            }
        }
        if (this.overrideAddExperienceLevelHooks != null) {
            this.overrideAddExperienceLevelHooks[this.overrideAddExperienceLevelHooks.length - 1].addExperienceLevel(n);
        } else {
            this.player.localAddExperienceLevel(n);
        }
        if (this.afterAddExperienceLevelHooks != null) {
            for (n2 = 0; n2 < this.afterAddExperienceLevelHooks.length; ++n2) {
                this.afterAddExperienceLevelHooks[n2].afterAddExperienceLevel(n);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenAddExperienceLevel(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideAddExperienceLevelHooks.length; ++i) {
            if (this.overrideAddExperienceLevelHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideAddExperienceLevelHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void addMovementStat(IServerPlayerAPI iServerPlayerAPI, double d, double d2, double d3) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isAddMovementStatModded) {
            serverPlayerAPI.addMovementStat(d, d2, d3);
        } else {
            iServerPlayerAPI.localAddMovementStat(d, d2, d3);
        }
    }

    private void addMovementStat(double d, double d2, double d3) {
        int n;
        if (this.beforeAddMovementStatHooks != null) {
            for (n = this.beforeAddMovementStatHooks.length - 1; n >= 0; --n) {
                this.beforeAddMovementStatHooks[n].beforeAddMovementStat(d, d2, d3);
            }
        }
        if (this.overrideAddMovementStatHooks != null) {
            this.overrideAddMovementStatHooks[this.overrideAddMovementStatHooks.length - 1].addMovementStat(d, d2, d3);
        } else {
            this.player.localAddMovementStat(d, d2, d3);
        }
        if (this.afterAddMovementStatHooks != null) {
            for (n = 0; n < this.afterAddMovementStatHooks.length; ++n) {
                this.afterAddMovementStatHooks[n].afterAddMovementStat(d, d2, d3);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenAddMovementStat(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideAddMovementStatHooks.length; ++i) {
            if (this.overrideAddMovementStatHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideAddMovementStatHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static boolean attackEntityFrom(IServerPlayerAPI iServerPlayerAPI, jxtc jxtc2, float f) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        boolean bl = serverPlayerAPI != null && serverPlayerAPI.isAttackEntityFromModded ? serverPlayerAPI.attackEntityFrom(jxtc2, f) : iServerPlayerAPI.localAttackEntityFrom(jxtc2, f);
        return bl;
    }

    private boolean attackEntityFrom(jxtc jxtc2, float f) {
        int n;
        if (this.beforeAttackEntityFromHooks != null) {
            for (n = this.beforeAttackEntityFromHooks.length - 1; n >= 0; --n) {
                this.beforeAttackEntityFromHooks[n].beforeAttackEntityFrom(jxtc2, f);
            }
        }
        n = this.overrideAttackEntityFromHooks != null ? this.overrideAttackEntityFromHooks[this.overrideAttackEntityFromHooks.length - 1].attackEntityFrom(jxtc2, f) : (int)(this.player.localAttackEntityFrom(jxtc2, f) ? 1 : 0);
        if (this.afterAttackEntityFromHooks != null) {
            for (int i = 0; i < this.afterAttackEntityFromHooks.length; ++i) {
                this.afterAttackEntityFromHooks[i].afterAttackEntityFrom(jxtc2, f);
            }
        }
        return n != 0;
    }

    protected ServerPlayerBase GetOverwrittenAttackEntityFrom(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideAttackEntityFromHooks.length; ++i) {
            if (this.overrideAttackEntityFromHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideAttackEntityFromHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void attackTargetEntityWithCurrentItem(IServerPlayerAPI iServerPlayerAPI, Entity entity) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isAttackTargetEntityWithCurrentItemModded) {
            serverPlayerAPI.attackTargetEntityWithCurrentItem(entity);
        } else {
            iServerPlayerAPI.localAttackTargetEntityWithCurrentItem(entity);
        }
    }

    private void attackTargetEntityWithCurrentItem(Entity entity) {
        int n;
        if (this.beforeAttackTargetEntityWithCurrentItemHooks != null) {
            for (n = this.beforeAttackTargetEntityWithCurrentItemHooks.length - 1; n >= 0; --n) {
                this.beforeAttackTargetEntityWithCurrentItemHooks[n].beforeAttackTargetEntityWithCurrentItem(entity);
            }
        }
        if (this.overrideAttackTargetEntityWithCurrentItemHooks != null) {
            this.overrideAttackTargetEntityWithCurrentItemHooks[this.overrideAttackTargetEntityWithCurrentItemHooks.length - 1].attackTargetEntityWithCurrentItem(entity);
        } else {
            this.player.localAttackTargetEntityWithCurrentItem(entity);
        }
        if (this.afterAttackTargetEntityWithCurrentItemHooks != null) {
            for (n = 0; n < this.afterAttackTargetEntityWithCurrentItemHooks.length; ++n) {
                this.afterAttackTargetEntityWithCurrentItemHooks[n].afterAttackTargetEntityWithCurrentItem(entity);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenAttackTargetEntityWithCurrentItem(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideAttackTargetEntityWithCurrentItemHooks.length; ++i) {
            if (this.overrideAttackTargetEntityWithCurrentItemHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideAttackTargetEntityWithCurrentItemHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static boolean canHarvestBlock(IServerPlayerAPI iServerPlayerAPI, twgu twgu2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        boolean bl = serverPlayerAPI != null && serverPlayerAPI.isCanHarvestBlockModded ? serverPlayerAPI.canHarvestBlock(twgu2) : iServerPlayerAPI.localCanHarvestBlock(twgu2);
        return bl;
    }

    private boolean canHarvestBlock(twgu twgu2) {
        int n;
        if (this.beforeCanHarvestBlockHooks != null) {
            for (n = this.beforeCanHarvestBlockHooks.length - 1; n >= 0; --n) {
                this.beforeCanHarvestBlockHooks[n].beforeCanHarvestBlock(twgu2);
            }
        }
        n = this.overrideCanHarvestBlockHooks != null ? this.overrideCanHarvestBlockHooks[this.overrideCanHarvestBlockHooks.length - 1].canHarvestBlock(twgu2) : (int)(this.player.localCanHarvestBlock(twgu2) ? 1 : 0);
        if (this.afterCanHarvestBlockHooks != null) {
            for (int i = 0; i < this.afterCanHarvestBlockHooks.length; ++i) {
                this.afterCanHarvestBlockHooks[i].afterCanHarvestBlock(twgu2);
            }
        }
        return n != 0;
    }

    protected ServerPlayerBase GetOverwrittenCanHarvestBlock(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideCanHarvestBlockHooks.length; ++i) {
            if (this.overrideCanHarvestBlockHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideCanHarvestBlockHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static boolean canPlayerEdit(IServerPlayerAPI iServerPlayerAPI, int n, int n2, int n3, int n4, cvzo cvzo2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        boolean bl = serverPlayerAPI != null && serverPlayerAPI.isCanPlayerEditModded ? serverPlayerAPI.canPlayerEdit(n, n2, n3, n4, cvzo2) : iServerPlayerAPI.localCanPlayerEdit(n, n2, n3, n4, cvzo2);
        return bl;
    }

    private boolean canPlayerEdit(int n, int n2, int n3, int n4, cvzo cvzo2) {
        int n5;
        if (this.beforeCanPlayerEditHooks != null) {
            for (n5 = this.beforeCanPlayerEditHooks.length - 1; n5 >= 0; --n5) {
                this.beforeCanPlayerEditHooks[n5].beforeCanPlayerEdit(n, n2, n3, n4, cvzo2);
            }
        }
        n5 = this.overrideCanPlayerEditHooks != null ? this.overrideCanPlayerEditHooks[this.overrideCanPlayerEditHooks.length - 1].canPlayerEdit(n, n2, n3, n4, cvzo2) : (int)(this.player.localCanPlayerEdit(n, n2, n3, n4, cvzo2) ? 1 : 0);
        if (this.afterCanPlayerEditHooks != null) {
            for (int i = 0; i < this.afterCanPlayerEditHooks.length; ++i) {
                this.afterCanPlayerEditHooks[i].afterCanPlayerEdit(n, n2, n3, n4, cvzo2);
            }
        }
        return n5 != 0;
    }

    protected ServerPlayerBase GetOverwrittenCanPlayerEdit(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideCanPlayerEditHooks.length; ++i) {
            if (this.overrideCanPlayerEditHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideCanPlayerEditHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static boolean canTriggerWalking(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        boolean bl = serverPlayerAPI != null && serverPlayerAPI.isCanTriggerWalkingModded ? serverPlayerAPI.canTriggerWalking() : iServerPlayerAPI.localCanTriggerWalking();
        return bl;
    }

    private boolean canTriggerWalking() {
        int n;
        if (this.beforeCanTriggerWalkingHooks != null) {
            for (n = this.beforeCanTriggerWalkingHooks.length - 1; n >= 0; --n) {
                this.beforeCanTriggerWalkingHooks[n].beforeCanTriggerWalking();
            }
        }
        n = this.overrideCanTriggerWalkingHooks != null ? this.overrideCanTriggerWalkingHooks[this.overrideCanTriggerWalkingHooks.length - 1].canTriggerWalking() : (int)(this.player.localCanTriggerWalking() ? 1 : 0);
        if (this.afterCanTriggerWalkingHooks != null) {
            for (int i = 0; i < this.afterCanTriggerWalkingHooks.length; ++i) {
                this.afterCanTriggerWalkingHooks[i].afterCanTriggerWalking();
            }
        }
        return n != 0;
    }

    protected ServerPlayerBase GetOverwrittenCanTriggerWalking(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideCanTriggerWalkingHooks.length; ++i) {
            if (this.overrideCanTriggerWalkingHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideCanTriggerWalkingHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void clonePlayer(IServerPlayerAPI iServerPlayerAPI, EntityPlayer entityPlayer, boolean bl) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isClonePlayerModded) {
            serverPlayerAPI.clonePlayer(entityPlayer, bl);
        } else {
            iServerPlayerAPI.localClonePlayer(entityPlayer, bl);
        }
    }

    private void clonePlayer(EntityPlayer entityPlayer, boolean bl) {
        int n;
        if (this.beforeClonePlayerHooks != null) {
            for (n = this.beforeClonePlayerHooks.length - 1; n >= 0; --n) {
                this.beforeClonePlayerHooks[n].beforeClonePlayer(entityPlayer, bl);
            }
        }
        if (this.overrideClonePlayerHooks != null) {
            this.overrideClonePlayerHooks[this.overrideClonePlayerHooks.length - 1].clonePlayer(entityPlayer, bl);
        } else {
            this.player.localClonePlayer(entityPlayer, bl);
        }
        if (this.afterClonePlayerHooks != null) {
            for (n = 0; n < this.afterClonePlayerHooks.length; ++n) {
                this.afterClonePlayerHooks[n].afterClonePlayer(entityPlayer, bl);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenClonePlayer(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideClonePlayerHooks.length; ++i) {
            if (this.overrideClonePlayerHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideClonePlayerHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void damageEntity(IServerPlayerAPI iServerPlayerAPI, jxtc jxtc2, float f) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isDamageEntityModded) {
            serverPlayerAPI.damageEntity(jxtc2, f);
        } else {
            iServerPlayerAPI.localDamageEntity(jxtc2, f);
        }
    }

    private void damageEntity(jxtc jxtc2, float f) {
        int n;
        if (this.beforeDamageEntityHooks != null) {
            for (n = this.beforeDamageEntityHooks.length - 1; n >= 0; --n) {
                this.beforeDamageEntityHooks[n].beforeDamageEntity(jxtc2, f);
            }
        }
        if (this.overrideDamageEntityHooks != null) {
            this.overrideDamageEntityHooks[this.overrideDamageEntityHooks.length - 1].damageEntity(jxtc2, f);
        } else {
            this.player.localDamageEntity(jxtc2, f);
        }
        if (this.afterDamageEntityHooks != null) {
            for (n = 0; n < this.afterDamageEntityHooks.length; ++n) {
                this.afterDamageEntityHooks[n].afterDamageEntity(jxtc2, f);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenDamageEntity(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideDamageEntityHooks.length; ++i) {
            if (this.overrideDamageEntityHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDamageEntityHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void displayGUIChest(IServerPlayerAPI iServerPlayerAPI, mssh mssh2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isDisplayGUIChestModded) {
            serverPlayerAPI.displayGUIChest(mssh2);
        } else {
            iServerPlayerAPI.localDisplayGUIChest(mssh2);
        }
    }

    private void displayGUIChest(mssh mssh2) {
        int n;
        if (this.beforeDisplayGUIChestHooks != null) {
            for (n = this.beforeDisplayGUIChestHooks.length - 1; n >= 0; --n) {
                this.beforeDisplayGUIChestHooks[n].beforeDisplayGUIChest(mssh2);
            }
        }
        if (this.overrideDisplayGUIChestHooks != null) {
            this.overrideDisplayGUIChestHooks[this.overrideDisplayGUIChestHooks.length - 1].displayGUIChest(mssh2);
        } else {
            this.player.localDisplayGUIChest(mssh2);
        }
        if (this.afterDisplayGUIChestHooks != null) {
            for (n = 0; n < this.afterDisplayGUIChestHooks.length; ++n) {
                this.afterDisplayGUIChestHooks[n].afterDisplayGUIChest(mssh2);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenDisplayGUIChest(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideDisplayGUIChestHooks.length; ++i) {
            if (this.overrideDisplayGUIChestHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDisplayGUIChestHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void displayGUIDispenser(IServerPlayerAPI iServerPlayerAPI, jjzo jjzo2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isDisplayGUIDispenserModded) {
            serverPlayerAPI.displayGUIDispenser(jjzo2);
        } else {
            iServerPlayerAPI.localDisplayGUIDispenser(jjzo2);
        }
    }

    private void displayGUIDispenser(jjzo jjzo2) {
        int n;
        if (this.beforeDisplayGUIDispenserHooks != null) {
            for (n = this.beforeDisplayGUIDispenserHooks.length - 1; n >= 0; --n) {
                this.beforeDisplayGUIDispenserHooks[n].beforeDisplayGUIDispenser(jjzo2);
            }
        }
        if (this.overrideDisplayGUIDispenserHooks != null) {
            this.overrideDisplayGUIDispenserHooks[this.overrideDisplayGUIDispenserHooks.length - 1].displayGUIDispenser(jjzo2);
        } else {
            this.player.localDisplayGUIDispenser(jjzo2);
        }
        if (this.afterDisplayGUIDispenserHooks != null) {
            for (n = 0; n < this.afterDisplayGUIDispenserHooks.length; ++n) {
                this.afterDisplayGUIDispenserHooks[n].afterDisplayGUIDispenser(jjzo2);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenDisplayGUIDispenser(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideDisplayGUIDispenserHooks.length; ++i) {
            if (this.overrideDisplayGUIDispenserHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDisplayGUIDispenserHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void displayGUIFurnace(IServerPlayerAPI iServerPlayerAPI, nwgz nwgz2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isDisplayGUIFurnaceModded) {
            serverPlayerAPI.displayGUIFurnace(nwgz2);
        } else {
            iServerPlayerAPI.localDisplayGUIFurnace(nwgz2);
        }
    }

    private void displayGUIFurnace(nwgz nwgz2) {
        int n;
        if (this.beforeDisplayGUIFurnaceHooks != null) {
            for (n = this.beforeDisplayGUIFurnaceHooks.length - 1; n >= 0; --n) {
                this.beforeDisplayGUIFurnaceHooks[n].beforeDisplayGUIFurnace(nwgz2);
            }
        }
        if (this.overrideDisplayGUIFurnaceHooks != null) {
            this.overrideDisplayGUIFurnaceHooks[this.overrideDisplayGUIFurnaceHooks.length - 1].displayGUIFurnace(nwgz2);
        } else {
            this.player.localDisplayGUIFurnace(nwgz2);
        }
        if (this.afterDisplayGUIFurnaceHooks != null) {
            for (n = 0; n < this.afterDisplayGUIFurnaceHooks.length; ++n) {
                this.afterDisplayGUIFurnaceHooks[n].afterDisplayGUIFurnace(nwgz2);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenDisplayGUIFurnace(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideDisplayGUIFurnaceHooks.length; ++i) {
            if (this.overrideDisplayGUIFurnaceHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDisplayGUIFurnaceHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void displayGUIWorkbench(IServerPlayerAPI iServerPlayerAPI, int n, int n2, int n3) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isDisplayGUIWorkbenchModded) {
            serverPlayerAPI.displayGUIWorkbench(n, n2, n3);
        } else {
            iServerPlayerAPI.localDisplayGUIWorkbench(n, n2, n3);
        }
    }

    private void displayGUIWorkbench(int n, int n2, int n3) {
        int n4;
        if (this.beforeDisplayGUIWorkbenchHooks != null) {
            for (n4 = this.beforeDisplayGUIWorkbenchHooks.length - 1; n4 >= 0; --n4) {
                this.beforeDisplayGUIWorkbenchHooks[n4].beforeDisplayGUIWorkbench(n, n2, n3);
            }
        }
        if (this.overrideDisplayGUIWorkbenchHooks != null) {
            this.overrideDisplayGUIWorkbenchHooks[this.overrideDisplayGUIWorkbenchHooks.length - 1].displayGUIWorkbench(n, n2, n3);
        } else {
            this.player.localDisplayGUIWorkbench(n, n2, n3);
        }
        if (this.afterDisplayGUIWorkbenchHooks != null) {
            for (n4 = 0; n4 < this.afterDisplayGUIWorkbenchHooks.length; ++n4) {
                this.afterDisplayGUIWorkbenchHooks[n4].afterDisplayGUIWorkbench(n, n2, n3);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenDisplayGUIWorkbench(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideDisplayGUIWorkbenchHooks.length; ++i) {
            if (this.overrideDisplayGUIWorkbenchHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDisplayGUIWorkbenchHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static EntityItem dropOneItem(IServerPlayerAPI iServerPlayerAPI, boolean bl) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        EntityItem entityItem = serverPlayerAPI != null && serverPlayerAPI.isDropOneItemModded ? serverPlayerAPI.dropOneItem(bl) : iServerPlayerAPI.localDropOneItem(bl);
        return entityItem;
    }

    private EntityItem dropOneItem(boolean bl) {
        if (this.beforeDropOneItemHooks != null) {
            for (int i = this.beforeDropOneItemHooks.length - 1; i >= 0; --i) {
                this.beforeDropOneItemHooks[i].beforeDropOneItem(bl);
            }
        }
        EntityItem entityItem = this.overrideDropOneItemHooks != null ? this.overrideDropOneItemHooks[this.overrideDropOneItemHooks.length - 1].dropOneItem(bl) : this.player.localDropOneItem(bl);
        if (this.afterDropOneItemHooks != null) {
            for (int i = 0; i < this.afterDropOneItemHooks.length; ++i) {
                this.afterDropOneItemHooks[i].afterDropOneItem(bl);
            }
        }
        return entityItem;
    }

    protected ServerPlayerBase GetOverwrittenDropOneItem(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideDropOneItemHooks.length; ++i) {
            if (this.overrideDropOneItemHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDropOneItemHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static EntityItem dropPlayerItem(IServerPlayerAPI iServerPlayerAPI, cvzo cvzo2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        EntityItem entityItem = serverPlayerAPI != null && serverPlayerAPI.isDropPlayerItemModded ? serverPlayerAPI.dropPlayerItem(cvzo2) : iServerPlayerAPI.localDropPlayerItem(cvzo2);
        return entityItem;
    }

    private EntityItem dropPlayerItem(cvzo cvzo2) {
        if (this.beforeDropPlayerItemHooks != null) {
            for (int i = this.beforeDropPlayerItemHooks.length - 1; i >= 0; --i) {
                this.beforeDropPlayerItemHooks[i].beforeDropPlayerItem(cvzo2);
            }
        }
        EntityItem entityItem = this.overrideDropPlayerItemHooks != null ? this.overrideDropPlayerItemHooks[this.overrideDropPlayerItemHooks.length - 1].dropPlayerItem(cvzo2) : this.player.localDropPlayerItem(cvzo2);
        if (this.afterDropPlayerItemHooks != null) {
            for (int i = 0; i < this.afterDropPlayerItemHooks.length; ++i) {
                this.afterDropPlayerItemHooks[i].afterDropPlayerItem(cvzo2);
            }
        }
        return entityItem;
    }

    protected ServerPlayerBase GetOverwrittenDropPlayerItem(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideDropPlayerItemHooks.length; ++i) {
            if (this.overrideDropPlayerItemHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDropPlayerItemHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void fall(IServerPlayerAPI iServerPlayerAPI, float f) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isFallModded) {
            serverPlayerAPI.fall(f);
        } else {
            iServerPlayerAPI.localFall(f);
        }
    }

    private void fall(float f) {
        int n;
        if (this.beforeFallHooks != null) {
            for (n = this.beforeFallHooks.length - 1; n >= 0; --n) {
                this.beforeFallHooks[n].beforeFall(f);
            }
        }
        if (this.overrideFallHooks != null) {
            this.overrideFallHooks[this.overrideFallHooks.length - 1].fall(f);
        } else {
            this.player.localFall(f);
        }
        if (this.afterFallHooks != null) {
            for (n = 0; n < this.afterFallHooks.length; ++n) {
                this.afterFallHooks[n].afterFall(f);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenFall(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideFallHooks.length; ++i) {
            if (this.overrideFallHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideFallHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static float getCurrentPlayerStrVsBlock(IServerPlayerAPI iServerPlayerAPI, twgu twgu2, boolean bl) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        float f = serverPlayerAPI != null && serverPlayerAPI.isGetCurrentPlayerStrVsBlockModded ? serverPlayerAPI.getCurrentPlayerStrVsBlock(twgu2, bl) : iServerPlayerAPI.localGetCurrentPlayerStrVsBlock(twgu2, bl);
        return f;
    }

    private float getCurrentPlayerStrVsBlock(twgu twgu2, boolean bl) {
        if (this.beforeGetCurrentPlayerStrVsBlockHooks != null) {
            for (int i = this.beforeGetCurrentPlayerStrVsBlockHooks.length - 1; i >= 0; --i) {
                this.beforeGetCurrentPlayerStrVsBlockHooks[i].beforeGetCurrentPlayerStrVsBlock(twgu2, bl);
            }
        }
        float f = this.overrideGetCurrentPlayerStrVsBlockHooks != null ? this.overrideGetCurrentPlayerStrVsBlockHooks[this.overrideGetCurrentPlayerStrVsBlockHooks.length - 1].getCurrentPlayerStrVsBlock(twgu2, bl) : this.player.localGetCurrentPlayerStrVsBlock(twgu2, bl);
        if (this.afterGetCurrentPlayerStrVsBlockHooks != null) {
            for (int i = 0; i < this.afterGetCurrentPlayerStrVsBlockHooks.length; ++i) {
                this.afterGetCurrentPlayerStrVsBlockHooks[i].afterGetCurrentPlayerStrVsBlock(twgu2, bl);
            }
        }
        return f;
    }

    protected ServerPlayerBase GetOverwrittenGetCurrentPlayerStrVsBlock(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideGetCurrentPlayerStrVsBlockHooks.length; ++i) {
            if (this.overrideGetCurrentPlayerStrVsBlockHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetCurrentPlayerStrVsBlockHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static float getCurrentPlayerStrVsBlockForge(IServerPlayerAPI iServerPlayerAPI, twgu twgu2, boolean bl, int n) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        float f = serverPlayerAPI != null && serverPlayerAPI.isGetCurrentPlayerStrVsBlockForgeModded ? serverPlayerAPI.getCurrentPlayerStrVsBlockForge(twgu2, bl, n) : iServerPlayerAPI.localGetCurrentPlayerStrVsBlockForge(twgu2, bl, n);
        return f;
    }

    private float getCurrentPlayerStrVsBlockForge(twgu twgu2, boolean bl, int n) {
        if (this.beforeGetCurrentPlayerStrVsBlockForgeHooks != null) {
            for (int i = this.beforeGetCurrentPlayerStrVsBlockForgeHooks.length - 1; i >= 0; --i) {
                this.beforeGetCurrentPlayerStrVsBlockForgeHooks[i].beforeGetCurrentPlayerStrVsBlockForge(twgu2, bl, n);
            }
        }
        float f = this.overrideGetCurrentPlayerStrVsBlockForgeHooks != null ? this.overrideGetCurrentPlayerStrVsBlockForgeHooks[this.overrideGetCurrentPlayerStrVsBlockForgeHooks.length - 1].getCurrentPlayerStrVsBlockForge(twgu2, bl, n) : this.player.localGetCurrentPlayerStrVsBlockForge(twgu2, bl, n);
        if (this.afterGetCurrentPlayerStrVsBlockForgeHooks != null) {
            for (int i = 0; i < this.afterGetCurrentPlayerStrVsBlockForgeHooks.length; ++i) {
                this.afterGetCurrentPlayerStrVsBlockForgeHooks[i].afterGetCurrentPlayerStrVsBlockForge(twgu2, bl, n);
            }
        }
        return f;
    }

    protected ServerPlayerBase GetOverwrittenGetCurrentPlayerStrVsBlockForge(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideGetCurrentPlayerStrVsBlockForgeHooks.length; ++i) {
            if (this.overrideGetCurrentPlayerStrVsBlockForgeHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetCurrentPlayerStrVsBlockForgeHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static double getDistanceSq(IServerPlayerAPI iServerPlayerAPI, double d, double d2, double d3) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        double d4 = serverPlayerAPI != null && serverPlayerAPI.isGetDistanceSqModded ? serverPlayerAPI.getDistanceSq(d, d2, d3) : iServerPlayerAPI.localGetDistanceSq(d, d2, d3);
        return d4;
    }

    private double getDistanceSq(double d, double d2, double d3) {
        if (this.beforeGetDistanceSqHooks != null) {
            for (int i = this.beforeGetDistanceSqHooks.length - 1; i >= 0; --i) {
                this.beforeGetDistanceSqHooks[i].beforeGetDistanceSq(d, d2, d3);
            }
        }
        double d4 = this.overrideGetDistanceSqHooks != null ? this.overrideGetDistanceSqHooks[this.overrideGetDistanceSqHooks.length - 1].getDistanceSq(d, d2, d3) : this.player.localGetDistanceSq(d, d2, d3);
        if (this.afterGetDistanceSqHooks != null) {
            for (int i = 0; i < this.afterGetDistanceSqHooks.length; ++i) {
                this.afterGetDistanceSqHooks[i].afterGetDistanceSq(d, d2, d3);
            }
        }
        return d4;
    }

    protected ServerPlayerBase GetOverwrittenGetDistanceSq(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideGetDistanceSqHooks.length; ++i) {
            if (this.overrideGetDistanceSqHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetDistanceSqHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static float getBrightness(IServerPlayerAPI iServerPlayerAPI, float f) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        float f2 = serverPlayerAPI != null && serverPlayerAPI.isGetBrightnessModded ? serverPlayerAPI.getBrightness(f) : iServerPlayerAPI.localGetBrightness(f);
        return f2;
    }

    private float getBrightness(float f) {
        if (this.beforeGetBrightnessHooks != null) {
            for (int i = this.beforeGetBrightnessHooks.length - 1; i >= 0; --i) {
                this.beforeGetBrightnessHooks[i].beforeGetBrightness(f);
            }
        }
        float f2 = this.overrideGetBrightnessHooks != null ? this.overrideGetBrightnessHooks[this.overrideGetBrightnessHooks.length - 1].getBrightness(f) : this.player.localGetBrightness(f);
        if (this.afterGetBrightnessHooks != null) {
            for (int i = 0; i < this.afterGetBrightnessHooks.length; ++i) {
                this.afterGetBrightnessHooks[i].afterGetBrightness(f);
            }
        }
        return f2;
    }

    protected ServerPlayerBase GetOverwrittenGetBrightness(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideGetBrightnessHooks.length; ++i) {
            if (this.overrideGetBrightnessHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetBrightnessHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static float getEyeHeight(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        float f = serverPlayerAPI != null && serverPlayerAPI.isGetEyeHeightModded ? serverPlayerAPI.getEyeHeight() : iServerPlayerAPI.localGetEyeHeight();
        return f;
    }

    private float getEyeHeight() {
        if (this.beforeGetEyeHeightHooks != null) {
            for (int i = this.beforeGetEyeHeightHooks.length - 1; i >= 0; --i) {
                this.beforeGetEyeHeightHooks[i].beforeGetEyeHeight();
            }
        }
        float f = this.overrideGetEyeHeightHooks != null ? this.overrideGetEyeHeightHooks[this.overrideGetEyeHeightHooks.length - 1].getEyeHeight() : this.player.localGetEyeHeight();
        if (this.afterGetEyeHeightHooks != null) {
            for (int i = 0; i < this.afterGetEyeHeightHooks.length; ++i) {
                this.afterGetEyeHeightHooks[i].afterGetEyeHeight();
            }
        }
        return f;
    }

    protected ServerPlayerBase GetOverwrittenGetEyeHeight(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideGetEyeHeightHooks.length; ++i) {
            if (this.overrideGetEyeHeightHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetEyeHeightHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void heal(IServerPlayerAPI iServerPlayerAPI, float f) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isHealModded) {
            serverPlayerAPI.heal(f);
        } else {
            iServerPlayerAPI.localHeal(f);
        }
    }

    private void heal(float f) {
        int n;
        if (this.beforeHealHooks != null) {
            for (n = this.beforeHealHooks.length - 1; n >= 0; --n) {
                this.beforeHealHooks[n].beforeHeal(f);
            }
        }
        if (this.overrideHealHooks != null) {
            this.overrideHealHooks[this.overrideHealHooks.length - 1].heal(f);
        } else {
            this.player.localHeal(f);
        }
        if (this.afterHealHooks != null) {
            for (n = 0; n < this.afterHealHooks.length; ++n) {
                this.afterHealHooks[n].afterHeal(f);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenHeal(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideHealHooks.length; ++i) {
            if (this.overrideHealHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideHealHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static boolean isEntityInsideOpaqueBlock(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        boolean bl = serverPlayerAPI != null && serverPlayerAPI.isIsEntityInsideOpaqueBlockModded ? serverPlayerAPI.isEntityInsideOpaqueBlock() : iServerPlayerAPI.localIsEntityInsideOpaqueBlock();
        return bl;
    }

    private boolean isEntityInsideOpaqueBlock() {
        int n;
        if (this.beforeIsEntityInsideOpaqueBlockHooks != null) {
            for (n = this.beforeIsEntityInsideOpaqueBlockHooks.length - 1; n >= 0; --n) {
                this.beforeIsEntityInsideOpaqueBlockHooks[n].beforeIsEntityInsideOpaqueBlock();
            }
        }
        n = this.overrideIsEntityInsideOpaqueBlockHooks != null ? this.overrideIsEntityInsideOpaqueBlockHooks[this.overrideIsEntityInsideOpaqueBlockHooks.length - 1].isEntityInsideOpaqueBlock() : (int)(this.player.localIsEntityInsideOpaqueBlock() ? 1 : 0);
        if (this.afterIsEntityInsideOpaqueBlockHooks != null) {
            for (int i = 0; i < this.afterIsEntityInsideOpaqueBlockHooks.length; ++i) {
                this.afterIsEntityInsideOpaqueBlockHooks[i].afterIsEntityInsideOpaqueBlock();
            }
        }
        return n != 0;
    }

    protected ServerPlayerBase GetOverwrittenIsEntityInsideOpaqueBlock(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideIsEntityInsideOpaqueBlockHooks.length; ++i) {
            if (this.overrideIsEntityInsideOpaqueBlockHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsEntityInsideOpaqueBlockHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static boolean isInWater(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        boolean bl = serverPlayerAPI != null && serverPlayerAPI.isIsInWaterModded ? serverPlayerAPI.isInWater() : iServerPlayerAPI.localIsInWater();
        return bl;
    }

    private boolean isInWater() {
        int n;
        if (this.beforeIsInWaterHooks != null) {
            for (n = this.beforeIsInWaterHooks.length - 1; n >= 0; --n) {
                this.beforeIsInWaterHooks[n].beforeIsInWater();
            }
        }
        n = this.overrideIsInWaterHooks != null ? this.overrideIsInWaterHooks[this.overrideIsInWaterHooks.length - 1].isInWater() : (int)(this.player.localIsInWater() ? 1 : 0);
        if (this.afterIsInWaterHooks != null) {
            for (int i = 0; i < this.afterIsInWaterHooks.length; ++i) {
                this.afterIsInWaterHooks[i].afterIsInWater();
            }
        }
        return n != 0;
    }

    protected ServerPlayerBase GetOverwrittenIsInWater(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideIsInWaterHooks.length; ++i) {
            if (this.overrideIsInWaterHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsInWaterHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static boolean isInsideOfMaterial(IServerPlayerAPI iServerPlayerAPI, tflj tflj2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        boolean bl = serverPlayerAPI != null && serverPlayerAPI.isIsInsideOfMaterialModded ? serverPlayerAPI.isInsideOfMaterial(tflj2) : iServerPlayerAPI.localIsInsideOfMaterial(tflj2);
        return bl;
    }

    private boolean isInsideOfMaterial(tflj tflj2) {
        int n;
        if (this.beforeIsInsideOfMaterialHooks != null) {
            for (n = this.beforeIsInsideOfMaterialHooks.length - 1; n >= 0; --n) {
                this.beforeIsInsideOfMaterialHooks[n].beforeIsInsideOfMaterial(tflj2);
            }
        }
        n = this.overrideIsInsideOfMaterialHooks != null ? this.overrideIsInsideOfMaterialHooks[this.overrideIsInsideOfMaterialHooks.length - 1].isInsideOfMaterial(tflj2) : (int)(this.player.localIsInsideOfMaterial(tflj2) ? 1 : 0);
        if (this.afterIsInsideOfMaterialHooks != null) {
            for (int i = 0; i < this.afterIsInsideOfMaterialHooks.length; ++i) {
                this.afterIsInsideOfMaterialHooks[i].afterIsInsideOfMaterial(tflj2);
            }
        }
        return n != 0;
    }

    protected ServerPlayerBase GetOverwrittenIsInsideOfMaterial(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideIsInsideOfMaterialHooks.length; ++i) {
            if (this.overrideIsInsideOfMaterialHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsInsideOfMaterialHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static boolean isOnLadder(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        boolean bl = serverPlayerAPI != null && serverPlayerAPI.isIsOnLadderModded ? serverPlayerAPI.isOnLadder() : iServerPlayerAPI.localIsOnLadder();
        return bl;
    }

    private boolean isOnLadder() {
        int n;
        if (this.beforeIsOnLadderHooks != null) {
            for (n = this.beforeIsOnLadderHooks.length - 1; n >= 0; --n) {
                this.beforeIsOnLadderHooks[n].beforeIsOnLadder();
            }
        }
        n = this.overrideIsOnLadderHooks != null ? this.overrideIsOnLadderHooks[this.overrideIsOnLadderHooks.length - 1].isOnLadder() : (int)(this.player.localIsOnLadder() ? 1 : 0);
        if (this.afterIsOnLadderHooks != null) {
            for (int i = 0; i < this.afterIsOnLadderHooks.length; ++i) {
                this.afterIsOnLadderHooks[i].afterIsOnLadder();
            }
        }
        return n != 0;
    }

    protected ServerPlayerBase GetOverwrittenIsOnLadder(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideIsOnLadderHooks.length; ++i) {
            if (this.overrideIsOnLadderHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsOnLadderHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static boolean isPlayerSleeping(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        boolean bl = serverPlayerAPI != null && serverPlayerAPI.isIsPlayerSleepingModded ? serverPlayerAPI.isPlayerSleeping() : iServerPlayerAPI.localIsPlayerSleeping();
        return bl;
    }

    private boolean isPlayerSleeping() {
        int n;
        if (this.beforeIsPlayerSleepingHooks != null) {
            for (n = this.beforeIsPlayerSleepingHooks.length - 1; n >= 0; --n) {
                this.beforeIsPlayerSleepingHooks[n].beforeIsPlayerSleeping();
            }
        }
        n = this.overrideIsPlayerSleepingHooks != null ? this.overrideIsPlayerSleepingHooks[this.overrideIsPlayerSleepingHooks.length - 1].isPlayerSleeping() : (int)(this.player.localIsPlayerSleeping() ? 1 : 0);
        if (this.afterIsPlayerSleepingHooks != null) {
            for (int i = 0; i < this.afterIsPlayerSleepingHooks.length; ++i) {
                this.afterIsPlayerSleepingHooks[i].afterIsPlayerSleeping();
            }
        }
        return n != 0;
    }

    protected ServerPlayerBase GetOverwrittenIsPlayerSleeping(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideIsPlayerSleepingHooks.length; ++i) {
            if (this.overrideIsPlayerSleepingHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsPlayerSleepingHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void jump(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isJumpModded) {
            serverPlayerAPI.jump();
        } else {
            iServerPlayerAPI.localJump();
        }
    }

    private void jump() {
        int n;
        if (this.beforeJumpHooks != null) {
            for (n = this.beforeJumpHooks.length - 1; n >= 0; --n) {
                this.beforeJumpHooks[n].beforeJump();
            }
        }
        if (this.overrideJumpHooks != null) {
            this.overrideJumpHooks[this.overrideJumpHooks.length - 1].jump();
        } else {
            this.player.localJump();
        }
        if (this.afterJumpHooks != null) {
            for (n = 0; n < this.afterJumpHooks.length; ++n) {
                this.afterJumpHooks[n].afterJump();
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenJump(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideJumpHooks.length; ++i) {
            if (this.overrideJumpHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideJumpHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void knockBack(IServerPlayerAPI iServerPlayerAPI, Entity entity, float f, double d, double d2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isKnockBackModded) {
            serverPlayerAPI.knockBack(entity, f, d, d2);
        } else {
            iServerPlayerAPI.localKnockBack(entity, f, d, d2);
        }
    }

    private void knockBack(Entity entity, float f, double d, double d2) {
        int n;
        if (this.beforeKnockBackHooks != null) {
            for (n = this.beforeKnockBackHooks.length - 1; n >= 0; --n) {
                this.beforeKnockBackHooks[n].beforeKnockBack(entity, f, d, d2);
            }
        }
        if (this.overrideKnockBackHooks != null) {
            this.overrideKnockBackHooks[this.overrideKnockBackHooks.length - 1].knockBack(entity, f, d, d2);
        } else {
            this.player.localKnockBack(entity, f, d, d2);
        }
        if (this.afterKnockBackHooks != null) {
            for (n = 0; n < this.afterKnockBackHooks.length; ++n) {
                this.afterKnockBackHooks[n].afterKnockBack(entity, f, d, d2);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenKnockBack(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideKnockBackHooks.length; ++i) {
            if (this.overrideKnockBackHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideKnockBackHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void moveEntity(IServerPlayerAPI iServerPlayerAPI, double d, double d2, double d3) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isMoveEntityModded) {
            serverPlayerAPI.moveEntity(d, d2, d3);
        } else {
            iServerPlayerAPI.localMoveEntity(d, d2, d3);
        }
    }

    private void moveEntity(double d, double d2, double d3) {
        int n;
        if (this.beforeMoveEntityHooks != null) {
            for (n = this.beforeMoveEntityHooks.length - 1; n >= 0; --n) {
                this.beforeMoveEntityHooks[n].beforeMoveEntity(d, d2, d3);
            }
        }
        if (this.overrideMoveEntityHooks != null) {
            this.overrideMoveEntityHooks[this.overrideMoveEntityHooks.length - 1].moveEntity(d, d2, d3);
        } else {
            this.player.localMoveEntity(d, d2, d3);
        }
        if (this.afterMoveEntityHooks != null) {
            for (n = 0; n < this.afterMoveEntityHooks.length; ++n) {
                this.afterMoveEntityHooks[n].afterMoveEntity(d, d2, d3);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenMoveEntity(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideMoveEntityHooks.length; ++i) {
            if (this.overrideMoveEntityHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideMoveEntityHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void moveEntityWithHeading(IServerPlayerAPI iServerPlayerAPI, float f, float f2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isMoveEntityWithHeadingModded) {
            serverPlayerAPI.moveEntityWithHeading(f, f2);
        } else {
            iServerPlayerAPI.localMoveEntityWithHeading(f, f2);
        }
    }

    private void moveEntityWithHeading(float f, float f2) {
        int n;
        if (this.beforeMoveEntityWithHeadingHooks != null) {
            for (n = this.beforeMoveEntityWithHeadingHooks.length - 1; n >= 0; --n) {
                this.beforeMoveEntityWithHeadingHooks[n].beforeMoveEntityWithHeading(f, f2);
            }
        }
        if (this.overrideMoveEntityWithHeadingHooks != null) {
            this.overrideMoveEntityWithHeadingHooks[this.overrideMoveEntityWithHeadingHooks.length - 1].moveEntityWithHeading(f, f2);
        } else {
            this.player.localMoveEntityWithHeading(f, f2);
        }
        if (this.afterMoveEntityWithHeadingHooks != null) {
            for (n = 0; n < this.afterMoveEntityWithHeadingHooks.length; ++n) {
                this.afterMoveEntityWithHeadingHooks[n].afterMoveEntityWithHeading(f, f2);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenMoveEntityWithHeading(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideMoveEntityWithHeadingHooks.length; ++i) {
            if (this.overrideMoveEntityWithHeadingHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideMoveEntityWithHeadingHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void moveFlying(IServerPlayerAPI iServerPlayerAPI, float f, float f2, float f3) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isMoveFlyingModded) {
            serverPlayerAPI.moveFlying(f, f2, f3);
        } else {
            iServerPlayerAPI.localMoveFlying(f, f2, f3);
        }
    }

    private void moveFlying(float f, float f2, float f3) {
        int n;
        if (this.beforeMoveFlyingHooks != null) {
            for (n = this.beforeMoveFlyingHooks.length - 1; n >= 0; --n) {
                this.beforeMoveFlyingHooks[n].beforeMoveFlying(f, f2, f3);
            }
        }
        if (this.overrideMoveFlyingHooks != null) {
            this.overrideMoveFlyingHooks[this.overrideMoveFlyingHooks.length - 1].moveFlying(f, f2, f3);
        } else {
            this.player.localMoveFlying(f, f2, f3);
        }
        if (this.afterMoveFlyingHooks != null) {
            for (n = 0; n < this.afterMoveFlyingHooks.length; ++n) {
                this.afterMoveFlyingHooks[n].afterMoveFlying(f, f2, f3);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenMoveFlying(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideMoveFlyingHooks.length; ++i) {
            if (this.overrideMoveFlyingHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideMoveFlyingHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void onDeath(IServerPlayerAPI iServerPlayerAPI, jxtc jxtc2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isOnDeathModded) {
            serverPlayerAPI.onDeath(jxtc2);
        } else {
            iServerPlayerAPI.localOnDeath(jxtc2);
        }
    }

    private void onDeath(jxtc jxtc2) {
        int n;
        if (this.beforeOnDeathHooks != null) {
            for (n = this.beforeOnDeathHooks.length - 1; n >= 0; --n) {
                this.beforeOnDeathHooks[n].beforeOnDeath(jxtc2);
            }
        }
        if (this.overrideOnDeathHooks != null) {
            this.overrideOnDeathHooks[this.overrideOnDeathHooks.length - 1].onDeath(jxtc2);
        } else {
            this.player.localOnDeath(jxtc2);
        }
        if (this.afterOnDeathHooks != null) {
            for (n = 0; n < this.afterOnDeathHooks.length; ++n) {
                this.afterOnDeathHooks[n].afterOnDeath(jxtc2);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenOnDeath(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideOnDeathHooks.length; ++i) {
            if (this.overrideOnDeathHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideOnDeathHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void onLivingUpdate(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isOnLivingUpdateModded) {
            serverPlayerAPI.onLivingUpdate();
        } else {
            iServerPlayerAPI.localOnLivingUpdate();
        }
    }

    private void onLivingUpdate() {
        int n;
        if (this.beforeOnLivingUpdateHooks != null) {
            for (n = this.beforeOnLivingUpdateHooks.length - 1; n >= 0; --n) {
                this.beforeOnLivingUpdateHooks[n].beforeOnLivingUpdate();
            }
        }
        if (this.overrideOnLivingUpdateHooks != null) {
            this.overrideOnLivingUpdateHooks[this.overrideOnLivingUpdateHooks.length - 1].onLivingUpdate();
        } else {
            this.player.localOnLivingUpdate();
        }
        if (this.afterOnLivingUpdateHooks != null) {
            for (n = 0; n < this.afterOnLivingUpdateHooks.length; ++n) {
                this.afterOnLivingUpdateHooks[n].afterOnLivingUpdate();
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenOnLivingUpdate(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideOnLivingUpdateHooks.length; ++i) {
            if (this.overrideOnLivingUpdateHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideOnLivingUpdateHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void onKillEntity(IServerPlayerAPI iServerPlayerAPI, EntityLivingBase entityLivingBase) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isOnKillEntityModded) {
            serverPlayerAPI.onKillEntity(entityLivingBase);
        } else {
            iServerPlayerAPI.localOnKillEntity(entityLivingBase);
        }
    }

    private void onKillEntity(EntityLivingBase entityLivingBase) {
        int n;
        if (this.beforeOnKillEntityHooks != null) {
            for (n = this.beforeOnKillEntityHooks.length - 1; n >= 0; --n) {
                this.beforeOnKillEntityHooks[n].beforeOnKillEntity(entityLivingBase);
            }
        }
        if (this.overrideOnKillEntityHooks != null) {
            this.overrideOnKillEntityHooks[this.overrideOnKillEntityHooks.length - 1].onKillEntity(entityLivingBase);
        } else {
            this.player.localOnKillEntity(entityLivingBase);
        }
        if (this.afterOnKillEntityHooks != null) {
            for (n = 0; n < this.afterOnKillEntityHooks.length; ++n) {
                this.afterOnKillEntityHooks[n].afterOnKillEntity(entityLivingBase);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenOnKillEntity(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideOnKillEntityHooks.length; ++i) {
            if (this.overrideOnKillEntityHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideOnKillEntityHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void onStruckByLightning(IServerPlayerAPI iServerPlayerAPI, EntityLightningBolt entityLightningBolt) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isOnStruckByLightningModded) {
            serverPlayerAPI.onStruckByLightning(entityLightningBolt);
        } else {
            iServerPlayerAPI.localOnStruckByLightning(entityLightningBolt);
        }
    }

    private void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
        int n;
        if (this.beforeOnStruckByLightningHooks != null) {
            for (n = this.beforeOnStruckByLightningHooks.length - 1; n >= 0; --n) {
                this.beforeOnStruckByLightningHooks[n].beforeOnStruckByLightning(entityLightningBolt);
            }
        }
        if (this.overrideOnStruckByLightningHooks != null) {
            this.overrideOnStruckByLightningHooks[this.overrideOnStruckByLightningHooks.length - 1].onStruckByLightning(entityLightningBolt);
        } else {
            this.player.localOnStruckByLightning(entityLightningBolt);
        }
        if (this.afterOnStruckByLightningHooks != null) {
            for (n = 0; n < this.afterOnStruckByLightningHooks.length; ++n) {
                this.afterOnStruckByLightningHooks[n].afterOnStruckByLightning(entityLightningBolt);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenOnStruckByLightning(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideOnStruckByLightningHooks.length; ++i) {
            if (this.overrideOnStruckByLightningHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideOnStruckByLightningHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void onUpdate(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isOnUpdateModded) {
            serverPlayerAPI.onUpdate();
        } else {
            iServerPlayerAPI.localOnUpdate();
        }
    }

    private void onUpdate() {
        int n;
        if (this.beforeOnUpdateHooks != null) {
            for (n = this.beforeOnUpdateHooks.length - 1; n >= 0; --n) {
                this.beforeOnUpdateHooks[n].beforeOnUpdate();
            }
        }
        if (this.overrideOnUpdateHooks != null) {
            this.overrideOnUpdateHooks[this.overrideOnUpdateHooks.length - 1].onUpdate();
        } else {
            this.player.localOnUpdate();
        }
        if (this.afterOnUpdateHooks != null) {
            for (n = 0; n < this.afterOnUpdateHooks.length; ++n) {
                this.afterOnUpdateHooks[n].afterOnUpdate();
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenOnUpdate(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideOnUpdateHooks.length; ++i) {
            if (this.overrideOnUpdateHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideOnUpdateHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void onUpdateEntity(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isOnUpdateEntityModded) {
            serverPlayerAPI.onUpdateEntity();
        } else {
            iServerPlayerAPI.localOnUpdateEntity();
        }
    }

    private void onUpdateEntity() {
        int n;
        if (this.beforeOnUpdateEntityHooks != null) {
            for (n = this.beforeOnUpdateEntityHooks.length - 1; n >= 0; --n) {
                this.beforeOnUpdateEntityHooks[n].beforeOnUpdateEntity();
            }
        }
        if (this.overrideOnUpdateEntityHooks != null) {
            this.overrideOnUpdateEntityHooks[this.overrideOnUpdateEntityHooks.length - 1].onUpdateEntity();
        } else {
            this.player.localOnUpdateEntity();
        }
        if (this.afterOnUpdateEntityHooks != null) {
            for (n = 0; n < this.afterOnUpdateEntityHooks.length; ++n) {
                this.afterOnUpdateEntityHooks[n].afterOnUpdateEntity();
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenOnUpdateEntity(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideOnUpdateEntityHooks.length; ++i) {
            if (this.overrideOnUpdateEntityHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideOnUpdateEntityHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void readEntityFromNBT(IServerPlayerAPI iServerPlayerAPI, qoac qoac2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isReadEntityFromNBTModded) {
            serverPlayerAPI.readEntityFromNBT(qoac2);
        } else {
            iServerPlayerAPI.localReadEntityFromNBT(qoac2);
        }
    }

    private void readEntityFromNBT(qoac qoac2) {
        int n;
        if (this.beforeReadEntityFromNBTHooks != null) {
            for (n = this.beforeReadEntityFromNBTHooks.length - 1; n >= 0; --n) {
                this.beforeReadEntityFromNBTHooks[n].beforeReadEntityFromNBT(qoac2);
            }
        }
        if (this.overrideReadEntityFromNBTHooks != null) {
            this.overrideReadEntityFromNBTHooks[this.overrideReadEntityFromNBTHooks.length - 1].readEntityFromNBT(qoac2);
        } else {
            this.player.localReadEntityFromNBT(qoac2);
        }
        if (this.afterReadEntityFromNBTHooks != null) {
            for (n = 0; n < this.afterReadEntityFromNBTHooks.length; ++n) {
                this.afterReadEntityFromNBTHooks[n].afterReadEntityFromNBT(qoac2);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenReadEntityFromNBT(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideReadEntityFromNBTHooks.length; ++i) {
            if (this.overrideReadEntityFromNBTHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideReadEntityFromNBTHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void setDead(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isSetDeadModded) {
            serverPlayerAPI.setDead();
        } else {
            iServerPlayerAPI.localSetDead();
        }
    }

    private void setDead() {
        int n;
        if (this.beforeSetDeadHooks != null) {
            for (n = this.beforeSetDeadHooks.length - 1; n >= 0; --n) {
                this.beforeSetDeadHooks[n].beforeSetDead();
            }
        }
        if (this.overrideSetDeadHooks != null) {
            this.overrideSetDeadHooks[this.overrideSetDeadHooks.length - 1].setDead();
        } else {
            this.player.localSetDead();
        }
        if (this.afterSetDeadHooks != null) {
            for (n = 0; n < this.afterSetDeadHooks.length; ++n) {
                this.afterSetDeadHooks[n].afterSetDead();
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenSetDead(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideSetDeadHooks.length; ++i) {
            if (this.overrideSetDeadHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetDeadHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void setPosition(IServerPlayerAPI iServerPlayerAPI, double d, double d2, double d3) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isSetPositionModded) {
            serverPlayerAPI.setPosition(d, d2, d3);
        } else {
            iServerPlayerAPI.localSetPosition(d, d2, d3);
        }
    }

    private void setPosition(double d, double d2, double d3) {
        int n;
        if (this.beforeSetPositionHooks != null) {
            for (n = this.beforeSetPositionHooks.length - 1; n >= 0; --n) {
                this.beforeSetPositionHooks[n].beforeSetPosition(d, d2, d3);
            }
        }
        if (this.overrideSetPositionHooks != null) {
            this.overrideSetPositionHooks[this.overrideSetPositionHooks.length - 1].setPosition(d, d2, d3);
        } else {
            this.player.localSetPosition(d, d2, d3);
        }
        if (this.afterSetPositionHooks != null) {
            for (n = 0; n < this.afterSetPositionHooks.length; ++n) {
                this.afterSetPositionHooks[n].afterSetPosition(d, d2, d3);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenSetPosition(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideSetPositionHooks.length; ++i) {
            if (this.overrideSetPositionHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetPositionHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void swingItem(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isSwingItemModded) {
            serverPlayerAPI.swingItem();
        } else {
            iServerPlayerAPI.localSwingItem();
        }
    }

    private void swingItem() {
        int n;
        if (this.beforeSwingItemHooks != null) {
            for (n = this.beforeSwingItemHooks.length - 1; n >= 0; --n) {
                this.beforeSwingItemHooks[n].beforeSwingItem();
            }
        }
        if (this.overrideSwingItemHooks != null) {
            this.overrideSwingItemHooks[this.overrideSwingItemHooks.length - 1].swingItem();
        } else {
            this.player.localSwingItem();
        }
        if (this.afterSwingItemHooks != null) {
            for (n = 0; n < this.afterSwingItemHooks.length; ++n) {
                this.afterSwingItemHooks[n].afterSwingItem();
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenSwingItem(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideSwingItemHooks.length; ++i) {
            if (this.overrideSwingItemHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSwingItemHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void updateEntityActionState(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isUpdateEntityActionStateModded) {
            serverPlayerAPI.updateEntityActionState();
        } else {
            iServerPlayerAPI.localUpdateEntityActionState();
        }
    }

    private void updateEntityActionState() {
        int n;
        if (this.beforeUpdateEntityActionStateHooks != null) {
            for (n = this.beforeUpdateEntityActionStateHooks.length - 1; n >= 0; --n) {
                this.beforeUpdateEntityActionStateHooks[n].beforeUpdateEntityActionState();
            }
        }
        if (this.overrideUpdateEntityActionStateHooks != null) {
            this.overrideUpdateEntityActionStateHooks[this.overrideUpdateEntityActionStateHooks.length - 1].updateEntityActionState();
        } else {
            this.player.localUpdateEntityActionState();
        }
        if (this.afterUpdateEntityActionStateHooks != null) {
            for (n = 0; n < this.afterUpdateEntityActionStateHooks.length; ++n) {
                this.afterUpdateEntityActionStateHooks[n].afterUpdateEntityActionState();
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenUpdateEntityActionState(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideUpdateEntityActionStateHooks.length; ++i) {
            if (this.overrideUpdateEntityActionStateHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideUpdateEntityActionStateHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void updatePotionEffects(IServerPlayerAPI iServerPlayerAPI) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isUpdatePotionEffectsModded) {
            serverPlayerAPI.updatePotionEffects();
        } else {
            iServerPlayerAPI.localUpdatePotionEffects();
        }
    }

    private void updatePotionEffects() {
        int n;
        if (this.beforeUpdatePotionEffectsHooks != null) {
            for (n = this.beforeUpdatePotionEffectsHooks.length - 1; n >= 0; --n) {
                this.beforeUpdatePotionEffectsHooks[n].beforeUpdatePotionEffects();
            }
        }
        if (this.overrideUpdatePotionEffectsHooks != null) {
            this.overrideUpdatePotionEffectsHooks[this.overrideUpdatePotionEffectsHooks.length - 1].updatePotionEffects();
        } else {
            this.player.localUpdatePotionEffects();
        }
        if (this.afterUpdatePotionEffectsHooks != null) {
            for (n = 0; n < this.afterUpdatePotionEffectsHooks.length; ++n) {
                this.afterUpdatePotionEffectsHooks[n].afterUpdatePotionEffects();
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenUpdatePotionEffects(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideUpdatePotionEffectsHooks.length; ++i) {
            if (this.overrideUpdatePotionEffectsHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideUpdatePotionEffectsHooks[i - 1];
        }
        return serverPlayerBase;
    }

    public static void writeEntityToNBT(IServerPlayerAPI iServerPlayerAPI, qoac qoac2) {
        ServerPlayerAPI serverPlayerAPI = iServerPlayerAPI.getServerPlayerAPI();
        if (serverPlayerAPI != null && serverPlayerAPI.isWriteEntityToNBTModded) {
            serverPlayerAPI.writeEntityToNBT(qoac2);
        } else {
            iServerPlayerAPI.localWriteEntityToNBT(qoac2);
        }
    }

    private void writeEntityToNBT(qoac qoac2) {
        int n;
        if (this.beforeWriteEntityToNBTHooks != null) {
            for (n = this.beforeWriteEntityToNBTHooks.length - 1; n >= 0; --n) {
                this.beforeWriteEntityToNBTHooks[n].beforeWriteEntityToNBT(qoac2);
            }
        }
        if (this.overrideWriteEntityToNBTHooks != null) {
            this.overrideWriteEntityToNBTHooks[this.overrideWriteEntityToNBTHooks.length - 1].writeEntityToNBT(qoac2);
        } else {
            this.player.localWriteEntityToNBT(qoac2);
        }
        if (this.afterWriteEntityToNBTHooks != null) {
            for (n = 0; n < this.afterWriteEntityToNBTHooks.length; ++n) {
                this.afterWriteEntityToNBTHooks[n].afterWriteEntityToNBT(qoac2);
            }
        }
    }

    protected ServerPlayerBase GetOverwrittenWriteEntityToNBT(ServerPlayerBase serverPlayerBase) {
        for (int i = 0; i < this.overrideWriteEntityToNBTHooks.length; ++i) {
            if (this.overrideWriteEntityToNBTHooks[i] != serverPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideWriteEntityToNBTHooks[i - 1];
        }
        return serverPlayerBase;
    }

    static {
        logger = Logger.getLogger("ServerPlayerAPI");
        EmptySortMap = Collections.unmodifiableMap(new HashMap());
        beforeAddExhaustionHookTypes = new LinkedList<String>();
        overrideAddExhaustionHookTypes = new LinkedList<String>();
        afterAddExhaustionHookTypes = new LinkedList<String>();
        allBaseBeforeAddExhaustionSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeAddExhaustionInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddExhaustionSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddExhaustionInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddExhaustionSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddExhaustionInferiors = new Hashtable<String, String[]>(0);
        beforeAddExperienceHookTypes = new LinkedList<String>();
        overrideAddExperienceHookTypes = new LinkedList<String>();
        afterAddExperienceHookTypes = new LinkedList<String>();
        allBaseBeforeAddExperienceSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeAddExperienceInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddExperienceSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddExperienceInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddExperienceSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddExperienceInferiors = new Hashtable<String, String[]>(0);
        beforeAddExperienceLevelHookTypes = new LinkedList<String>();
        overrideAddExperienceLevelHookTypes = new LinkedList<String>();
        afterAddExperienceLevelHookTypes = new LinkedList<String>();
        allBaseBeforeAddExperienceLevelSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeAddExperienceLevelInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddExperienceLevelSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddExperienceLevelInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddExperienceLevelSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddExperienceLevelInferiors = new Hashtable<String, String[]>(0);
        beforeAddMovementStatHookTypes = new LinkedList<String>();
        overrideAddMovementStatHookTypes = new LinkedList<String>();
        afterAddMovementStatHookTypes = new LinkedList<String>();
        allBaseBeforeAddMovementStatSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeAddMovementStatInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddMovementStatSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddMovementStatInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddMovementStatSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddMovementStatInferiors = new Hashtable<String, String[]>(0);
        beforeAttackEntityFromHookTypes = new LinkedList<String>();
        overrideAttackEntityFromHookTypes = new LinkedList<String>();
        afterAttackEntityFromHookTypes = new LinkedList<String>();
        allBaseBeforeAttackEntityFromSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeAttackEntityFromInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAttackEntityFromSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAttackEntityFromInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterAttackEntityFromSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterAttackEntityFromInferiors = new Hashtable<String, String[]>(0);
        beforeAttackTargetEntityWithCurrentItemHookTypes = new LinkedList<String>();
        overrideAttackTargetEntityWithCurrentItemHookTypes = new LinkedList<String>();
        afterAttackTargetEntityWithCurrentItemHookTypes = new LinkedList<String>();
        allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeAttackTargetEntityWithCurrentItemInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAttackTargetEntityWithCurrentItemInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterAttackTargetEntityWithCurrentItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterAttackTargetEntityWithCurrentItemInferiors = new Hashtable<String, String[]>(0);
        beforeCanHarvestBlockHookTypes = new LinkedList<String>();
        overrideCanHarvestBlockHookTypes = new LinkedList<String>();
        afterCanHarvestBlockHookTypes = new LinkedList<String>();
        allBaseBeforeCanHarvestBlockSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeCanHarvestBlockInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideCanHarvestBlockSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideCanHarvestBlockInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterCanHarvestBlockSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterCanHarvestBlockInferiors = new Hashtable<String, String[]>(0);
        beforeCanPlayerEditHookTypes = new LinkedList<String>();
        overrideCanPlayerEditHookTypes = new LinkedList<String>();
        afterCanPlayerEditHookTypes = new LinkedList<String>();
        allBaseBeforeCanPlayerEditSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeCanPlayerEditInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideCanPlayerEditSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideCanPlayerEditInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterCanPlayerEditSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterCanPlayerEditInferiors = new Hashtable<String, String[]>(0);
        beforeCanTriggerWalkingHookTypes = new LinkedList<String>();
        overrideCanTriggerWalkingHookTypes = new LinkedList<String>();
        afterCanTriggerWalkingHookTypes = new LinkedList<String>();
        allBaseBeforeCanTriggerWalkingSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeCanTriggerWalkingInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideCanTriggerWalkingSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideCanTriggerWalkingInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterCanTriggerWalkingSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterCanTriggerWalkingInferiors = new Hashtable<String, String[]>(0);
        beforeClonePlayerHookTypes = new LinkedList<String>();
        overrideClonePlayerHookTypes = new LinkedList<String>();
        afterClonePlayerHookTypes = new LinkedList<String>();
        allBaseBeforeClonePlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeClonePlayerInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideClonePlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideClonePlayerInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterClonePlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterClonePlayerInferiors = new Hashtable<String, String[]>(0);
        beforeDamageEntityHookTypes = new LinkedList<String>();
        overrideDamageEntityHookTypes = new LinkedList<String>();
        afterDamageEntityHookTypes = new LinkedList<String>();
        allBaseBeforeDamageEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDamageEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDamageEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDamageEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDamageEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDamageEntityInferiors = new Hashtable<String, String[]>(0);
        beforeDisplayGUIChestHookTypes = new LinkedList<String>();
        overrideDisplayGUIChestHookTypes = new LinkedList<String>();
        afterDisplayGUIChestHookTypes = new LinkedList<String>();
        allBaseBeforeDisplayGUIChestSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDisplayGUIChestInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIChestSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIChestInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIChestSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIChestInferiors = new Hashtable<String, String[]>(0);
        beforeDisplayGUIDispenserHookTypes = new LinkedList<String>();
        overrideDisplayGUIDispenserHookTypes = new LinkedList<String>();
        afterDisplayGUIDispenserHookTypes = new LinkedList<String>();
        allBaseBeforeDisplayGUIDispenserSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDisplayGUIDispenserInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIDispenserSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIDispenserInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIDispenserSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIDispenserInferiors = new Hashtable<String, String[]>(0);
        beforeDisplayGUIFurnaceHookTypes = new LinkedList<String>();
        overrideDisplayGUIFurnaceHookTypes = new LinkedList<String>();
        afterDisplayGUIFurnaceHookTypes = new LinkedList<String>();
        allBaseBeforeDisplayGUIFurnaceSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDisplayGUIFurnaceInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIFurnaceSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIFurnaceInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIFurnaceSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIFurnaceInferiors = new Hashtable<String, String[]>(0);
        beforeDisplayGUIWorkbenchHookTypes = new LinkedList<String>();
        overrideDisplayGUIWorkbenchHookTypes = new LinkedList<String>();
        afterDisplayGUIWorkbenchHookTypes = new LinkedList<String>();
        allBaseBeforeDisplayGUIWorkbenchSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDisplayGUIWorkbenchInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIWorkbenchSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIWorkbenchInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIWorkbenchSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIWorkbenchInferiors = new Hashtable<String, String[]>(0);
        beforeDropOneItemHookTypes = new LinkedList<String>();
        overrideDropOneItemHookTypes = new LinkedList<String>();
        afterDropOneItemHookTypes = new LinkedList<String>();
        allBaseBeforeDropOneItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDropOneItemInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDropOneItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDropOneItemInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDropOneItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDropOneItemInferiors = new Hashtable<String, String[]>(0);
        beforeDropPlayerItemHookTypes = new LinkedList<String>();
        overrideDropPlayerItemHookTypes = new LinkedList<String>();
        afterDropPlayerItemHookTypes = new LinkedList<String>();
        allBaseBeforeDropPlayerItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDropPlayerItemInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDropPlayerItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDropPlayerItemInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDropPlayerItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDropPlayerItemInferiors = new Hashtable<String, String[]>(0);
        beforeFallHookTypes = new LinkedList<String>();
        overrideFallHookTypes = new LinkedList<String>();
        afterFallHookTypes = new LinkedList<String>();
        allBaseBeforeFallSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeFallInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideFallSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideFallInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterFallSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterFallInferiors = new Hashtable<String, String[]>(0);
        beforeGetCurrentPlayerStrVsBlockHookTypes = new LinkedList<String>();
        overrideGetCurrentPlayerStrVsBlockHookTypes = new LinkedList<String>();
        afterGetCurrentPlayerStrVsBlockHookTypes = new LinkedList<String>();
        allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetCurrentPlayerStrVsBlockInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetCurrentPlayerStrVsBlockInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetCurrentPlayerStrVsBlockSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetCurrentPlayerStrVsBlockInferiors = new Hashtable<String, String[]>(0);
        beforeGetCurrentPlayerStrVsBlockForgeHookTypes = new LinkedList<String>();
        overrideGetCurrentPlayerStrVsBlockForgeHookTypes = new LinkedList<String>();
        afterGetCurrentPlayerStrVsBlockForgeHookTypes = new LinkedList<String>();
        allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors = new Hashtable<String, String[]>(0);
        beforeGetDistanceSqHookTypes = new LinkedList<String>();
        overrideGetDistanceSqHookTypes = new LinkedList<String>();
        afterGetDistanceSqHookTypes = new LinkedList<String>();
        allBaseBeforeGetDistanceSqSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetDistanceSqInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetDistanceSqSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetDistanceSqInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetDistanceSqSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetDistanceSqInferiors = new Hashtable<String, String[]>(0);
        beforeGetBrightnessHookTypes = new LinkedList<String>();
        overrideGetBrightnessHookTypes = new LinkedList<String>();
        afterGetBrightnessHookTypes = new LinkedList<String>();
        allBaseBeforeGetBrightnessSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetBrightnessInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetBrightnessSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetBrightnessInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetBrightnessSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetBrightnessInferiors = new Hashtable<String, String[]>(0);
        beforeGetEyeHeightHookTypes = new LinkedList<String>();
        overrideGetEyeHeightHookTypes = new LinkedList<String>();
        afterGetEyeHeightHookTypes = new LinkedList<String>();
        allBaseBeforeGetEyeHeightSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetEyeHeightInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetEyeHeightSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetEyeHeightInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetEyeHeightSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetEyeHeightInferiors = new Hashtable<String, String[]>(0);
        beforeHealHookTypes = new LinkedList<String>();
        overrideHealHookTypes = new LinkedList<String>();
        afterHealHookTypes = new LinkedList<String>();
        allBaseBeforeHealSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeHealInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideHealSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideHealInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterHealSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterHealInferiors = new Hashtable<String, String[]>(0);
        beforeIsEntityInsideOpaqueBlockHookTypes = new LinkedList<String>();
        overrideIsEntityInsideOpaqueBlockHookTypes = new LinkedList<String>();
        afterIsEntityInsideOpaqueBlockHookTypes = new LinkedList<String>();
        allBaseBeforeIsEntityInsideOpaqueBlockSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeIsEntityInsideOpaqueBlockInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsEntityInsideOpaqueBlockSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsEntityInsideOpaqueBlockInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsEntityInsideOpaqueBlockSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsEntityInsideOpaqueBlockInferiors = new Hashtable<String, String[]>(0);
        beforeIsInWaterHookTypes = new LinkedList<String>();
        overrideIsInWaterHookTypes = new LinkedList<String>();
        afterIsInWaterHookTypes = new LinkedList<String>();
        allBaseBeforeIsInWaterSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeIsInWaterInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsInWaterSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsInWaterInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsInWaterSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsInWaterInferiors = new Hashtable<String, String[]>(0);
        beforeIsInsideOfMaterialHookTypes = new LinkedList<String>();
        overrideIsInsideOfMaterialHookTypes = new LinkedList<String>();
        afterIsInsideOfMaterialHookTypes = new LinkedList<String>();
        allBaseBeforeIsInsideOfMaterialSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeIsInsideOfMaterialInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsInsideOfMaterialSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsInsideOfMaterialInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsInsideOfMaterialSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsInsideOfMaterialInferiors = new Hashtable<String, String[]>(0);
        beforeIsOnLadderHookTypes = new LinkedList<String>();
        overrideIsOnLadderHookTypes = new LinkedList<String>();
        afterIsOnLadderHookTypes = new LinkedList<String>();
        allBaseBeforeIsOnLadderSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeIsOnLadderInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsOnLadderSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsOnLadderInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsOnLadderSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsOnLadderInferiors = new Hashtable<String, String[]>(0);
        beforeIsPlayerSleepingHookTypes = new LinkedList<String>();
        overrideIsPlayerSleepingHookTypes = new LinkedList<String>();
        afterIsPlayerSleepingHookTypes = new LinkedList<String>();
        allBaseBeforeIsPlayerSleepingSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeIsPlayerSleepingInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsPlayerSleepingSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsPlayerSleepingInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsPlayerSleepingSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsPlayerSleepingInferiors = new Hashtable<String, String[]>(0);
        beforeJumpHookTypes = new LinkedList<String>();
        overrideJumpHookTypes = new LinkedList<String>();
        afterJumpHookTypes = new LinkedList<String>();
        allBaseBeforeJumpSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeJumpInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideJumpSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideJumpInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterJumpSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterJumpInferiors = new Hashtable<String, String[]>(0);
        beforeKnockBackHookTypes = new LinkedList<String>();
        overrideKnockBackHookTypes = new LinkedList<String>();
        afterKnockBackHookTypes = new LinkedList<String>();
        allBaseBeforeKnockBackSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeKnockBackInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideKnockBackSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideKnockBackInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterKnockBackSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterKnockBackInferiors = new Hashtable<String, String[]>(0);
        beforeMoveEntityHookTypes = new LinkedList<String>();
        overrideMoveEntityHookTypes = new LinkedList<String>();
        afterMoveEntityHookTypes = new LinkedList<String>();
        allBaseBeforeMoveEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeMoveEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideMoveEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideMoveEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterMoveEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterMoveEntityInferiors = new Hashtable<String, String[]>(0);
        beforeMoveEntityWithHeadingHookTypes = new LinkedList<String>();
        overrideMoveEntityWithHeadingHookTypes = new LinkedList<String>();
        afterMoveEntityWithHeadingHookTypes = new LinkedList<String>();
        allBaseBeforeMoveEntityWithHeadingSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeMoveEntityWithHeadingInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideMoveEntityWithHeadingSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideMoveEntityWithHeadingInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterMoveEntityWithHeadingSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterMoveEntityWithHeadingInferiors = new Hashtable<String, String[]>(0);
        beforeMoveFlyingHookTypes = new LinkedList<String>();
        overrideMoveFlyingHookTypes = new LinkedList<String>();
        afterMoveFlyingHookTypes = new LinkedList<String>();
        allBaseBeforeMoveFlyingSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeMoveFlyingInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideMoveFlyingSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideMoveFlyingInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterMoveFlyingSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterMoveFlyingInferiors = new Hashtable<String, String[]>(0);
        beforeOnDeathHookTypes = new LinkedList<String>();
        overrideOnDeathHookTypes = new LinkedList<String>();
        afterOnDeathHookTypes = new LinkedList<String>();
        allBaseBeforeOnDeathSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeOnDeathInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnDeathSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnDeathInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnDeathSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnDeathInferiors = new Hashtable<String, String[]>(0);
        beforeOnLivingUpdateHookTypes = new LinkedList<String>();
        overrideOnLivingUpdateHookTypes = new LinkedList<String>();
        afterOnLivingUpdateHookTypes = new LinkedList<String>();
        allBaseBeforeOnLivingUpdateSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeOnLivingUpdateInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnLivingUpdateSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnLivingUpdateInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnLivingUpdateSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnLivingUpdateInferiors = new Hashtable<String, String[]>(0);
        beforeOnKillEntityHookTypes = new LinkedList<String>();
        overrideOnKillEntityHookTypes = new LinkedList<String>();
        afterOnKillEntityHookTypes = new LinkedList<String>();
        allBaseBeforeOnKillEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeOnKillEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnKillEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnKillEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnKillEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnKillEntityInferiors = new Hashtable<String, String[]>(0);
        beforeOnStruckByLightningHookTypes = new LinkedList<String>();
        overrideOnStruckByLightningHookTypes = new LinkedList<String>();
        afterOnStruckByLightningHookTypes = new LinkedList<String>();
        allBaseBeforeOnStruckByLightningSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeOnStruckByLightningInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnStruckByLightningSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnStruckByLightningInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnStruckByLightningSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnStruckByLightningInferiors = new Hashtable<String, String[]>(0);
        beforeOnUpdateHookTypes = new LinkedList<String>();
        overrideOnUpdateHookTypes = new LinkedList<String>();
        afterOnUpdateHookTypes = new LinkedList<String>();
        allBaseBeforeOnUpdateSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeOnUpdateInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnUpdateSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnUpdateInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnUpdateSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnUpdateInferiors = new Hashtable<String, String[]>(0);
        beforeOnUpdateEntityHookTypes = new LinkedList<String>();
        overrideOnUpdateEntityHookTypes = new LinkedList<String>();
        afterOnUpdateEntityHookTypes = new LinkedList<String>();
        allBaseBeforeOnUpdateEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeOnUpdateEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnUpdateEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideOnUpdateEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnUpdateEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterOnUpdateEntityInferiors = new Hashtable<String, String[]>(0);
        beforeReadEntityFromNBTHookTypes = new LinkedList<String>();
        overrideReadEntityFromNBTHookTypes = new LinkedList<String>();
        afterReadEntityFromNBTHookTypes = new LinkedList<String>();
        allBaseBeforeReadEntityFromNBTSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeReadEntityFromNBTInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideReadEntityFromNBTSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideReadEntityFromNBTInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterReadEntityFromNBTSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterReadEntityFromNBTInferiors = new Hashtable<String, String[]>(0);
        beforeSetDeadHookTypes = new LinkedList<String>();
        overrideSetDeadHookTypes = new LinkedList<String>();
        afterSetDeadHookTypes = new LinkedList<String>();
        allBaseBeforeSetDeadSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetDeadInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetDeadSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetDeadInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetDeadSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetDeadInferiors = new Hashtable<String, String[]>(0);
        beforeSetPositionHookTypes = new LinkedList<String>();
        overrideSetPositionHookTypes = new LinkedList<String>();
        afterSetPositionHookTypes = new LinkedList<String>();
        allBaseBeforeSetPositionSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetPositionInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetPositionSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetPositionInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetPositionSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetPositionInferiors = new Hashtable<String, String[]>(0);
        beforeSwingItemHookTypes = new LinkedList<String>();
        overrideSwingItemHookTypes = new LinkedList<String>();
        afterSwingItemHookTypes = new LinkedList<String>();
        allBaseBeforeSwingItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSwingItemInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSwingItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSwingItemInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSwingItemSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSwingItemInferiors = new Hashtable<String, String[]>(0);
        beforeUpdateEntityActionStateHookTypes = new LinkedList<String>();
        overrideUpdateEntityActionStateHookTypes = new LinkedList<String>();
        afterUpdateEntityActionStateHookTypes = new LinkedList<String>();
        allBaseBeforeUpdateEntityActionStateSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeUpdateEntityActionStateInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideUpdateEntityActionStateSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideUpdateEntityActionStateInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterUpdateEntityActionStateSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterUpdateEntityActionStateInferiors = new Hashtable<String, String[]>(0);
        beforeUpdatePotionEffectsHookTypes = new LinkedList<String>();
        overrideUpdatePotionEffectsHookTypes = new LinkedList<String>();
        afterUpdatePotionEffectsHookTypes = new LinkedList<String>();
        allBaseBeforeUpdatePotionEffectsSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeUpdatePotionEffectsInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideUpdatePotionEffectsSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideUpdatePotionEffectsInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterUpdatePotionEffectsSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterUpdatePotionEffectsInferiors = new Hashtable<String, String[]>(0);
        beforeWriteEntityToNBTHookTypes = new LinkedList<String>();
        overrideWriteEntityToNBTHookTypes = new LinkedList<String>();
        afterWriteEntityToNBTHookTypes = new LinkedList<String>();
        allBaseBeforeWriteEntityToNBTSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeWriteEntityToNBTInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideWriteEntityToNBTSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideWriteEntityToNBTInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterWriteEntityToNBTSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterWriteEntityToNBTInferiors = new Hashtable<String, String[]>(0);
        keys = new HashSet<String>();
        keysToVirtualIds = new HashMap<String, String>();
        dynamicTypes = new HashSet();
        virtualDynamicHookMethods = new HashMap();
        beforeDynamicHookMethods = new HashMap();
        overrideDynamicHookMethods = new HashMap();
        afterDynamicHookMethods = new HashMap();
        beforeLocalConstructingHookTypes = new LinkedList<String>();
        afterLocalConstructingHookTypes = new LinkedList<String>();
        beforeDynamicHookTypes = new Hashtable<String, List<String>>(0);
        overrideDynamicHookTypes = new Hashtable<String, List<String>>(0);
        afterDynamicHookTypes = new Hashtable<String, List<String>>(0);
        allBaseConstructors = new Hashtable();
        unmodifiableAllIds = Collections.unmodifiableSet(allBaseConstructors.keySet());
        allBaseBeforeLocalConstructingSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeLocalConstructingInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterLocalConstructingSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterLocalConstructingInferiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDynamicSuperiors = new Hashtable<String, Map<String, String[]>>(0);
        allBaseBeforeDynamicInferiors = new Hashtable<String, Map<String, String[]>>(0);
        allBaseOverrideDynamicSuperiors = new Hashtable<String, Map<String, String[]>>(0);
        allBaseOverrideDynamicInferiors = new Hashtable<String, Map<String, String[]>>(0);
        allBaseAfterDynamicSuperiors = new Hashtable<String, Map<String, String[]>>(0);
        allBaseAfterDynamicInferiors = new Hashtable<String, Map<String, String[]>>(0);
        initialized = false;
    }
}

