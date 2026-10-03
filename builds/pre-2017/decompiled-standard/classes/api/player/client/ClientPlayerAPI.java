/*
 * Decompiled with CFR 0.152.
 */
package api.player.client;

import api.player.client.ClientPlayerBase;
import api.player.client.ClientPlayerBaseSorter;
import api.player.client.ClientPlayerBaseSorting;
import api.player.client.IClientPlayerAPI;
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

public final class ClientPlayerAPI {
    private static final Class<?>[] Class = new Class[]{ClientPlayerAPI.class};
    private static final Class<?>[] Classes = new Class[]{ClientPlayerAPI.class, String.class};
    private static boolean isCreated;
    private static final Logger logger;
    private static final Map<String, String[]> EmptySortMap;
    private static final List<String> beforeAddExhaustionHookTypes;
    private static final List<String> overrideAddExhaustionHookTypes;
    private static final List<String> afterAddExhaustionHookTypes;
    private ClientPlayerBase[] beforeAddExhaustionHooks;
    private ClientPlayerBase[] overrideAddExhaustionHooks;
    private ClientPlayerBase[] afterAddExhaustionHooks;
    public boolean isAddExhaustionModded;
    private static final Map<String, String[]> allBaseBeforeAddExhaustionSuperiors;
    private static final Map<String, String[]> allBaseBeforeAddExhaustionInferiors;
    private static final Map<String, String[]> allBaseOverrideAddExhaustionSuperiors;
    private static final Map<String, String[]> allBaseOverrideAddExhaustionInferiors;
    private static final Map<String, String[]> allBaseAfterAddExhaustionSuperiors;
    private static final Map<String, String[]> allBaseAfterAddExhaustionInferiors;
    private static final List<String> beforeAddMovementStatHookTypes;
    private static final List<String> overrideAddMovementStatHookTypes;
    private static final List<String> afterAddMovementStatHookTypes;
    private ClientPlayerBase[] beforeAddMovementStatHooks;
    private ClientPlayerBase[] overrideAddMovementStatHooks;
    private ClientPlayerBase[] afterAddMovementStatHooks;
    public boolean isAddMovementStatModded;
    private static final Map<String, String[]> allBaseBeforeAddMovementStatSuperiors;
    private static final Map<String, String[]> allBaseBeforeAddMovementStatInferiors;
    private static final Map<String, String[]> allBaseOverrideAddMovementStatSuperiors;
    private static final Map<String, String[]> allBaseOverrideAddMovementStatInferiors;
    private static final Map<String, String[]> allBaseAfterAddMovementStatSuperiors;
    private static final Map<String, String[]> allBaseAfterAddMovementStatInferiors;
    private static final List<String> beforeAddStatHookTypes;
    private static final List<String> overrideAddStatHookTypes;
    private static final List<String> afterAddStatHookTypes;
    private ClientPlayerBase[] beforeAddStatHooks;
    private ClientPlayerBase[] overrideAddStatHooks;
    private ClientPlayerBase[] afterAddStatHooks;
    public boolean isAddStatModded;
    private static final Map<String, String[]> allBaseBeforeAddStatSuperiors;
    private static final Map<String, String[]> allBaseBeforeAddStatInferiors;
    private static final Map<String, String[]> allBaseOverrideAddStatSuperiors;
    private static final Map<String, String[]> allBaseOverrideAddStatInferiors;
    private static final Map<String, String[]> allBaseAfterAddStatSuperiors;
    private static final Map<String, String[]> allBaseAfterAddStatInferiors;
    private static final List<String> beforeAttackEntityFromHookTypes;
    private static final List<String> overrideAttackEntityFromHookTypes;
    private static final List<String> afterAttackEntityFromHookTypes;
    private ClientPlayerBase[] beforeAttackEntityFromHooks;
    private ClientPlayerBase[] overrideAttackEntityFromHooks;
    private ClientPlayerBase[] afterAttackEntityFromHooks;
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
    private ClientPlayerBase[] beforeAttackTargetEntityWithCurrentItemHooks;
    private ClientPlayerBase[] overrideAttackTargetEntityWithCurrentItemHooks;
    private ClientPlayerBase[] afterAttackTargetEntityWithCurrentItemHooks;
    public boolean isAttackTargetEntityWithCurrentItemModded;
    private static final Map<String, String[]> allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors;
    private static final Map<String, String[]> allBaseBeforeAttackTargetEntityWithCurrentItemInferiors;
    private static final Map<String, String[]> allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors;
    private static final Map<String, String[]> allBaseOverrideAttackTargetEntityWithCurrentItemInferiors;
    private static final Map<String, String[]> allBaseAfterAttackTargetEntityWithCurrentItemSuperiors;
    private static final Map<String, String[]> allBaseAfterAttackTargetEntityWithCurrentItemInferiors;
    private static final List<String> beforeCanBreatheUnderwaterHookTypes;
    private static final List<String> overrideCanBreatheUnderwaterHookTypes;
    private static final List<String> afterCanBreatheUnderwaterHookTypes;
    private ClientPlayerBase[] beforeCanBreatheUnderwaterHooks;
    private ClientPlayerBase[] overrideCanBreatheUnderwaterHooks;
    private ClientPlayerBase[] afterCanBreatheUnderwaterHooks;
    public boolean isCanBreatheUnderwaterModded;
    private static final Map<String, String[]> allBaseBeforeCanBreatheUnderwaterSuperiors;
    private static final Map<String, String[]> allBaseBeforeCanBreatheUnderwaterInferiors;
    private static final Map<String, String[]> allBaseOverrideCanBreatheUnderwaterSuperiors;
    private static final Map<String, String[]> allBaseOverrideCanBreatheUnderwaterInferiors;
    private static final Map<String, String[]> allBaseAfterCanBreatheUnderwaterSuperiors;
    private static final Map<String, String[]> allBaseAfterCanBreatheUnderwaterInferiors;
    private static final List<String> beforeCanHarvestBlockHookTypes;
    private static final List<String> overrideCanHarvestBlockHookTypes;
    private static final List<String> afterCanHarvestBlockHookTypes;
    private ClientPlayerBase[] beforeCanHarvestBlockHooks;
    private ClientPlayerBase[] overrideCanHarvestBlockHooks;
    private ClientPlayerBase[] afterCanHarvestBlockHooks;
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
    private ClientPlayerBase[] beforeCanPlayerEditHooks;
    private ClientPlayerBase[] overrideCanPlayerEditHooks;
    private ClientPlayerBase[] afterCanPlayerEditHooks;
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
    private ClientPlayerBase[] beforeCanTriggerWalkingHooks;
    private ClientPlayerBase[] overrideCanTriggerWalkingHooks;
    private ClientPlayerBase[] afterCanTriggerWalkingHooks;
    public boolean isCanTriggerWalkingModded;
    private static final Map<String, String[]> allBaseBeforeCanTriggerWalkingSuperiors;
    private static final Map<String, String[]> allBaseBeforeCanTriggerWalkingInferiors;
    private static final Map<String, String[]> allBaseOverrideCanTriggerWalkingSuperiors;
    private static final Map<String, String[]> allBaseOverrideCanTriggerWalkingInferiors;
    private static final Map<String, String[]> allBaseAfterCanTriggerWalkingSuperiors;
    private static final Map<String, String[]> allBaseAfterCanTriggerWalkingInferiors;
    private static final List<String> beforeCloseScreenHookTypes;
    private static final List<String> overrideCloseScreenHookTypes;
    private static final List<String> afterCloseScreenHookTypes;
    private ClientPlayerBase[] beforeCloseScreenHooks;
    private ClientPlayerBase[] overrideCloseScreenHooks;
    private ClientPlayerBase[] afterCloseScreenHooks;
    public boolean isCloseScreenModded;
    private static final Map<String, String[]> allBaseBeforeCloseScreenSuperiors;
    private static final Map<String, String[]> allBaseBeforeCloseScreenInferiors;
    private static final Map<String, String[]> allBaseOverrideCloseScreenSuperiors;
    private static final Map<String, String[]> allBaseOverrideCloseScreenInferiors;
    private static final Map<String, String[]> allBaseAfterCloseScreenSuperiors;
    private static final Map<String, String[]> allBaseAfterCloseScreenInferiors;
    private static final List<String> beforeDamageEntityHookTypes;
    private static final List<String> overrideDamageEntityHookTypes;
    private static final List<String> afterDamageEntityHookTypes;
    private ClientPlayerBase[] beforeDamageEntityHooks;
    private ClientPlayerBase[] overrideDamageEntityHooks;
    private ClientPlayerBase[] afterDamageEntityHooks;
    public boolean isDamageEntityModded;
    private static final Map<String, String[]> allBaseBeforeDamageEntitySuperiors;
    private static final Map<String, String[]> allBaseBeforeDamageEntityInferiors;
    private static final Map<String, String[]> allBaseOverrideDamageEntitySuperiors;
    private static final Map<String, String[]> allBaseOverrideDamageEntityInferiors;
    private static final Map<String, String[]> allBaseAfterDamageEntitySuperiors;
    private static final Map<String, String[]> allBaseAfterDamageEntityInferiors;
    private static final List<String> beforeDisplayGUIBrewingStandHookTypes;
    private static final List<String> overrideDisplayGUIBrewingStandHookTypes;
    private static final List<String> afterDisplayGUIBrewingStandHookTypes;
    private ClientPlayerBase[] beforeDisplayGUIBrewingStandHooks;
    private ClientPlayerBase[] overrideDisplayGUIBrewingStandHooks;
    private ClientPlayerBase[] afterDisplayGUIBrewingStandHooks;
    public boolean isDisplayGUIBrewingStandModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIBrewingStandSuperiors;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIBrewingStandInferiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIBrewingStandSuperiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIBrewingStandInferiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIBrewingStandSuperiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIBrewingStandInferiors;
    private static final List<String> beforeDisplayGUIChestHookTypes;
    private static final List<String> overrideDisplayGUIChestHookTypes;
    private static final List<String> afterDisplayGUIChestHookTypes;
    private ClientPlayerBase[] beforeDisplayGUIChestHooks;
    private ClientPlayerBase[] overrideDisplayGUIChestHooks;
    private ClientPlayerBase[] afterDisplayGUIChestHooks;
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
    private ClientPlayerBase[] beforeDisplayGUIDispenserHooks;
    private ClientPlayerBase[] overrideDisplayGUIDispenserHooks;
    private ClientPlayerBase[] afterDisplayGUIDispenserHooks;
    public boolean isDisplayGUIDispenserModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIDispenserSuperiors;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIDispenserInferiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIDispenserSuperiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIDispenserInferiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIDispenserSuperiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIDispenserInferiors;
    private static final List<String> beforeDisplayGUIEditSignHookTypes;
    private static final List<String> overrideDisplayGUIEditSignHookTypes;
    private static final List<String> afterDisplayGUIEditSignHookTypes;
    private ClientPlayerBase[] beforeDisplayGUIEditSignHooks;
    private ClientPlayerBase[] overrideDisplayGUIEditSignHooks;
    private ClientPlayerBase[] afterDisplayGUIEditSignHooks;
    public boolean isDisplayGUIEditSignModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIEditSignSuperiors;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIEditSignInferiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIEditSignSuperiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIEditSignInferiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIEditSignSuperiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIEditSignInferiors;
    private static final List<String> beforeDisplayGUIEnchantmentHookTypes;
    private static final List<String> overrideDisplayGUIEnchantmentHookTypes;
    private static final List<String> afterDisplayGUIEnchantmentHookTypes;
    private ClientPlayerBase[] beforeDisplayGUIEnchantmentHooks;
    private ClientPlayerBase[] overrideDisplayGUIEnchantmentHooks;
    private ClientPlayerBase[] afterDisplayGUIEnchantmentHooks;
    public boolean isDisplayGUIEnchantmentModded;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIEnchantmentSuperiors;
    private static final Map<String, String[]> allBaseBeforeDisplayGUIEnchantmentInferiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIEnchantmentSuperiors;
    private static final Map<String, String[]> allBaseOverrideDisplayGUIEnchantmentInferiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIEnchantmentSuperiors;
    private static final Map<String, String[]> allBaseAfterDisplayGUIEnchantmentInferiors;
    private static final List<String> beforeDisplayGUIFurnaceHookTypes;
    private static final List<String> overrideDisplayGUIFurnaceHookTypes;
    private static final List<String> afterDisplayGUIFurnaceHookTypes;
    private ClientPlayerBase[] beforeDisplayGUIFurnaceHooks;
    private ClientPlayerBase[] overrideDisplayGUIFurnaceHooks;
    private ClientPlayerBase[] afterDisplayGUIFurnaceHooks;
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
    private ClientPlayerBase[] beforeDisplayGUIWorkbenchHooks;
    private ClientPlayerBase[] overrideDisplayGUIWorkbenchHooks;
    private ClientPlayerBase[] afterDisplayGUIWorkbenchHooks;
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
    private ClientPlayerBase[] beforeDropOneItemHooks;
    private ClientPlayerBase[] overrideDropOneItemHooks;
    private ClientPlayerBase[] afterDropOneItemHooks;
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
    private ClientPlayerBase[] beforeDropPlayerItemHooks;
    private ClientPlayerBase[] overrideDropPlayerItemHooks;
    private ClientPlayerBase[] afterDropPlayerItemHooks;
    public boolean isDropPlayerItemModded;
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemSuperiors;
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemInferiors;
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemSuperiors;
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemInferiors;
    private static final Map<String, String[]> allBaseAfterDropPlayerItemSuperiors;
    private static final Map<String, String[]> allBaseAfterDropPlayerItemInferiors;
    private static final List<String> beforeDropPlayerItemWithRandomChoiceHookTypes;
    private static final List<String> overrideDropPlayerItemWithRandomChoiceHookTypes;
    private static final List<String> afterDropPlayerItemWithRandomChoiceHookTypes;
    private ClientPlayerBase[] beforeDropPlayerItemWithRandomChoiceHooks;
    private ClientPlayerBase[] overrideDropPlayerItemWithRandomChoiceHooks;
    private ClientPlayerBase[] afterDropPlayerItemWithRandomChoiceHooks;
    public boolean isDropPlayerItemWithRandomChoiceModded;
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemWithRandomChoiceSuperiors;
    private static final Map<String, String[]> allBaseBeforeDropPlayerItemWithRandomChoiceInferiors;
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemWithRandomChoiceSuperiors;
    private static final Map<String, String[]> allBaseOverrideDropPlayerItemWithRandomChoiceInferiors;
    private static final Map<String, String[]> allBaseAfterDropPlayerItemWithRandomChoiceSuperiors;
    private static final Map<String, String[]> allBaseAfterDropPlayerItemWithRandomChoiceInferiors;
    private static final List<String> beforeFallHookTypes;
    private static final List<String> overrideFallHookTypes;
    private static final List<String> afterFallHookTypes;
    private ClientPlayerBase[] beforeFallHooks;
    private ClientPlayerBase[] overrideFallHooks;
    private ClientPlayerBase[] afterFallHooks;
    public boolean isFallModded;
    private static final Map<String, String[]> allBaseBeforeFallSuperiors;
    private static final Map<String, String[]> allBaseBeforeFallInferiors;
    private static final Map<String, String[]> allBaseOverrideFallSuperiors;
    private static final Map<String, String[]> allBaseOverrideFallInferiors;
    private static final Map<String, String[]> allBaseAfterFallSuperiors;
    private static final Map<String, String[]> allBaseAfterFallInferiors;
    private static final List<String> beforeGetBrightnessHookTypes;
    private static final List<String> overrideGetBrightnessHookTypes;
    private static final List<String> afterGetBrightnessHookTypes;
    private ClientPlayerBase[] beforeGetBrightnessHooks;
    private ClientPlayerBase[] overrideGetBrightnessHooks;
    private ClientPlayerBase[] afterGetBrightnessHooks;
    public boolean isGetBrightnessModded;
    private static final Map<String, String[]> allBaseBeforeGetBrightnessSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetBrightnessInferiors;
    private static final Map<String, String[]> allBaseOverrideGetBrightnessSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetBrightnessInferiors;
    private static final Map<String, String[]> allBaseAfterGetBrightnessSuperiors;
    private static final Map<String, String[]> allBaseAfterGetBrightnessInferiors;
    private static final List<String> beforeGetBrightnessForRenderHookTypes;
    private static final List<String> overrideGetBrightnessForRenderHookTypes;
    private static final List<String> afterGetBrightnessForRenderHookTypes;
    private ClientPlayerBase[] beforeGetBrightnessForRenderHooks;
    private ClientPlayerBase[] overrideGetBrightnessForRenderHooks;
    private ClientPlayerBase[] afterGetBrightnessForRenderHooks;
    public boolean isGetBrightnessForRenderModded;
    private static final Map<String, String[]> allBaseBeforeGetBrightnessForRenderSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetBrightnessForRenderInferiors;
    private static final Map<String, String[]> allBaseOverrideGetBrightnessForRenderSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetBrightnessForRenderInferiors;
    private static final Map<String, String[]> allBaseAfterGetBrightnessForRenderSuperiors;
    private static final Map<String, String[]> allBaseAfterGetBrightnessForRenderInferiors;
    private static final List<String> beforeGetCurrentPlayerStrVsBlockHookTypes;
    private static final List<String> overrideGetCurrentPlayerStrVsBlockHookTypes;
    private static final List<String> afterGetCurrentPlayerStrVsBlockHookTypes;
    private ClientPlayerBase[] beforeGetCurrentPlayerStrVsBlockHooks;
    private ClientPlayerBase[] overrideGetCurrentPlayerStrVsBlockHooks;
    private ClientPlayerBase[] afterGetCurrentPlayerStrVsBlockHooks;
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
    private ClientPlayerBase[] beforeGetCurrentPlayerStrVsBlockForgeHooks;
    private ClientPlayerBase[] overrideGetCurrentPlayerStrVsBlockForgeHooks;
    private ClientPlayerBase[] afterGetCurrentPlayerStrVsBlockForgeHooks;
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
    private ClientPlayerBase[] beforeGetDistanceSqHooks;
    private ClientPlayerBase[] overrideGetDistanceSqHooks;
    private ClientPlayerBase[] afterGetDistanceSqHooks;
    public boolean isGetDistanceSqModded;
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqInferiors;
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqInferiors;
    private static final Map<String, String[]> allBaseAfterGetDistanceSqSuperiors;
    private static final Map<String, String[]> allBaseAfterGetDistanceSqInferiors;
    private static final List<String> beforeGetDistanceSqToEntityHookTypes;
    private static final List<String> overrideGetDistanceSqToEntityHookTypes;
    private static final List<String> afterGetDistanceSqToEntityHookTypes;
    private ClientPlayerBase[] beforeGetDistanceSqToEntityHooks;
    private ClientPlayerBase[] overrideGetDistanceSqToEntityHooks;
    private ClientPlayerBase[] afterGetDistanceSqToEntityHooks;
    public boolean isGetDistanceSqToEntityModded;
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqToEntitySuperiors;
    private static final Map<String, String[]> allBaseBeforeGetDistanceSqToEntityInferiors;
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqToEntitySuperiors;
    private static final Map<String, String[]> allBaseOverrideGetDistanceSqToEntityInferiors;
    private static final Map<String, String[]> allBaseAfterGetDistanceSqToEntitySuperiors;
    private static final Map<String, String[]> allBaseAfterGetDistanceSqToEntityInferiors;
    private static final List<String> beforeGetFOVMultiplierHookTypes;
    private static final List<String> overrideGetFOVMultiplierHookTypes;
    private static final List<String> afterGetFOVMultiplierHookTypes;
    private ClientPlayerBase[] beforeGetFOVMultiplierHooks;
    private ClientPlayerBase[] overrideGetFOVMultiplierHooks;
    private ClientPlayerBase[] afterGetFOVMultiplierHooks;
    public boolean isGetFOVMultiplierModded;
    private static final Map<String, String[]> allBaseBeforeGetFOVMultiplierSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetFOVMultiplierInferiors;
    private static final Map<String, String[]> allBaseOverrideGetFOVMultiplierSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetFOVMultiplierInferiors;
    private static final Map<String, String[]> allBaseAfterGetFOVMultiplierSuperiors;
    private static final Map<String, String[]> allBaseAfterGetFOVMultiplierInferiors;
    private static final List<String> beforeGetHurtSoundHookTypes;
    private static final List<String> overrideGetHurtSoundHookTypes;
    private static final List<String> afterGetHurtSoundHookTypes;
    private ClientPlayerBase[] beforeGetHurtSoundHooks;
    private ClientPlayerBase[] overrideGetHurtSoundHooks;
    private ClientPlayerBase[] afterGetHurtSoundHooks;
    public boolean isGetHurtSoundModded;
    private static final Map<String, String[]> allBaseBeforeGetHurtSoundSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetHurtSoundInferiors;
    private static final Map<String, String[]> allBaseOverrideGetHurtSoundSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetHurtSoundInferiors;
    private static final Map<String, String[]> allBaseAfterGetHurtSoundSuperiors;
    private static final Map<String, String[]> allBaseAfterGetHurtSoundInferiors;
    private static final List<String> beforeGetItemIconHookTypes;
    private static final List<String> overrideGetItemIconHookTypes;
    private static final List<String> afterGetItemIconHookTypes;
    private ClientPlayerBase[] beforeGetItemIconHooks;
    private ClientPlayerBase[] overrideGetItemIconHooks;
    private ClientPlayerBase[] afterGetItemIconHooks;
    public boolean isGetItemIconModded;
    private static final Map<String, String[]> allBaseBeforeGetItemIconSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetItemIconInferiors;
    private static final Map<String, String[]> allBaseOverrideGetItemIconSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetItemIconInferiors;
    private static final Map<String, String[]> allBaseAfterGetItemIconSuperiors;
    private static final Map<String, String[]> allBaseAfterGetItemIconInferiors;
    private static final List<String> beforeGetSleepTimerHookTypes;
    private static final List<String> overrideGetSleepTimerHookTypes;
    private static final List<String> afterGetSleepTimerHookTypes;
    private ClientPlayerBase[] beforeGetSleepTimerHooks;
    private ClientPlayerBase[] overrideGetSleepTimerHooks;
    private ClientPlayerBase[] afterGetSleepTimerHooks;
    public boolean isGetSleepTimerModded;
    private static final Map<String, String[]> allBaseBeforeGetSleepTimerSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetSleepTimerInferiors;
    private static final Map<String, String[]> allBaseOverrideGetSleepTimerSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetSleepTimerInferiors;
    private static final Map<String, String[]> allBaseAfterGetSleepTimerSuperiors;
    private static final Map<String, String[]> allBaseAfterGetSleepTimerInferiors;
    private static final List<String> beforeHandleLavaMovementHookTypes;
    private static final List<String> overrideHandleLavaMovementHookTypes;
    private static final List<String> afterHandleLavaMovementHookTypes;
    private ClientPlayerBase[] beforeHandleLavaMovementHooks;
    private ClientPlayerBase[] overrideHandleLavaMovementHooks;
    private ClientPlayerBase[] afterHandleLavaMovementHooks;
    public boolean isHandleLavaMovementModded;
    private static final Map<String, String[]> allBaseBeforeHandleLavaMovementSuperiors;
    private static final Map<String, String[]> allBaseBeforeHandleLavaMovementInferiors;
    private static final Map<String, String[]> allBaseOverrideHandleLavaMovementSuperiors;
    private static final Map<String, String[]> allBaseOverrideHandleLavaMovementInferiors;
    private static final Map<String, String[]> allBaseAfterHandleLavaMovementSuperiors;
    private static final Map<String, String[]> allBaseAfterHandleLavaMovementInferiors;
    private static final List<String> beforeHandleWaterMovementHookTypes;
    private static final List<String> overrideHandleWaterMovementHookTypes;
    private static final List<String> afterHandleWaterMovementHookTypes;
    private ClientPlayerBase[] beforeHandleWaterMovementHooks;
    private ClientPlayerBase[] overrideHandleWaterMovementHooks;
    private ClientPlayerBase[] afterHandleWaterMovementHooks;
    public boolean isHandleWaterMovementModded;
    private static final Map<String, String[]> allBaseBeforeHandleWaterMovementSuperiors;
    private static final Map<String, String[]> allBaseBeforeHandleWaterMovementInferiors;
    private static final Map<String, String[]> allBaseOverrideHandleWaterMovementSuperiors;
    private static final Map<String, String[]> allBaseOverrideHandleWaterMovementInferiors;
    private static final Map<String, String[]> allBaseAfterHandleWaterMovementSuperiors;
    private static final Map<String, String[]> allBaseAfterHandleWaterMovementInferiors;
    private static final List<String> beforeHealHookTypes;
    private static final List<String> overrideHealHookTypes;
    private static final List<String> afterHealHookTypes;
    private ClientPlayerBase[] beforeHealHooks;
    private ClientPlayerBase[] overrideHealHooks;
    private ClientPlayerBase[] afterHealHooks;
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
    private ClientPlayerBase[] beforeIsEntityInsideOpaqueBlockHooks;
    private ClientPlayerBase[] overrideIsEntityInsideOpaqueBlockHooks;
    private ClientPlayerBase[] afterIsEntityInsideOpaqueBlockHooks;
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
    private ClientPlayerBase[] beforeIsInWaterHooks;
    private ClientPlayerBase[] overrideIsInWaterHooks;
    private ClientPlayerBase[] afterIsInWaterHooks;
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
    private ClientPlayerBase[] beforeIsInsideOfMaterialHooks;
    private ClientPlayerBase[] overrideIsInsideOfMaterialHooks;
    private ClientPlayerBase[] afterIsInsideOfMaterialHooks;
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
    private ClientPlayerBase[] beforeIsOnLadderHooks;
    private ClientPlayerBase[] overrideIsOnLadderHooks;
    private ClientPlayerBase[] afterIsOnLadderHooks;
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
    private ClientPlayerBase[] beforeIsPlayerSleepingHooks;
    private ClientPlayerBase[] overrideIsPlayerSleepingHooks;
    private ClientPlayerBase[] afterIsPlayerSleepingHooks;
    public boolean isIsPlayerSleepingModded;
    private static final Map<String, String[]> allBaseBeforeIsPlayerSleepingSuperiors;
    private static final Map<String, String[]> allBaseBeforeIsPlayerSleepingInferiors;
    private static final Map<String, String[]> allBaseOverrideIsPlayerSleepingSuperiors;
    private static final Map<String, String[]> allBaseOverrideIsPlayerSleepingInferiors;
    private static final Map<String, String[]> allBaseAfterIsPlayerSleepingSuperiors;
    private static final Map<String, String[]> allBaseAfterIsPlayerSleepingInferiors;
    private static final List<String> beforeIsSneakingHookTypes;
    private static final List<String> overrideIsSneakingHookTypes;
    private static final List<String> afterIsSneakingHookTypes;
    private ClientPlayerBase[] beforeIsSneakingHooks;
    private ClientPlayerBase[] overrideIsSneakingHooks;
    private ClientPlayerBase[] afterIsSneakingHooks;
    public boolean isIsSneakingModded;
    private static final Map<String, String[]> allBaseBeforeIsSneakingSuperiors;
    private static final Map<String, String[]> allBaseBeforeIsSneakingInferiors;
    private static final Map<String, String[]> allBaseOverrideIsSneakingSuperiors;
    private static final Map<String, String[]> allBaseOverrideIsSneakingInferiors;
    private static final Map<String, String[]> allBaseAfterIsSneakingSuperiors;
    private static final Map<String, String[]> allBaseAfterIsSneakingInferiors;
    private static final List<String> beforeIsSprintingHookTypes;
    private static final List<String> overrideIsSprintingHookTypes;
    private static final List<String> afterIsSprintingHookTypes;
    private ClientPlayerBase[] beforeIsSprintingHooks;
    private ClientPlayerBase[] overrideIsSprintingHooks;
    private ClientPlayerBase[] afterIsSprintingHooks;
    public boolean isIsSprintingModded;
    private static final Map<String, String[]> allBaseBeforeIsSprintingSuperiors;
    private static final Map<String, String[]> allBaseBeforeIsSprintingInferiors;
    private static final Map<String, String[]> allBaseOverrideIsSprintingSuperiors;
    private static final Map<String, String[]> allBaseOverrideIsSprintingInferiors;
    private static final Map<String, String[]> allBaseAfterIsSprintingSuperiors;
    private static final Map<String, String[]> allBaseAfterIsSprintingInferiors;
    private static final List<String> beforeJumpHookTypes;
    private static final List<String> overrideJumpHookTypes;
    private static final List<String> afterJumpHookTypes;
    private ClientPlayerBase[] beforeJumpHooks;
    private ClientPlayerBase[] overrideJumpHooks;
    private ClientPlayerBase[] afterJumpHooks;
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
    private ClientPlayerBase[] beforeKnockBackHooks;
    private ClientPlayerBase[] overrideKnockBackHooks;
    private ClientPlayerBase[] afterKnockBackHooks;
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
    private ClientPlayerBase[] beforeMoveEntityHooks;
    private ClientPlayerBase[] overrideMoveEntityHooks;
    private ClientPlayerBase[] afterMoveEntityHooks;
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
    private ClientPlayerBase[] beforeMoveEntityWithHeadingHooks;
    private ClientPlayerBase[] overrideMoveEntityWithHeadingHooks;
    private ClientPlayerBase[] afterMoveEntityWithHeadingHooks;
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
    private ClientPlayerBase[] beforeMoveFlyingHooks;
    private ClientPlayerBase[] overrideMoveFlyingHooks;
    private ClientPlayerBase[] afterMoveFlyingHooks;
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
    private ClientPlayerBase[] beforeOnDeathHooks;
    private ClientPlayerBase[] overrideOnDeathHooks;
    private ClientPlayerBase[] afterOnDeathHooks;
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
    private ClientPlayerBase[] beforeOnLivingUpdateHooks;
    private ClientPlayerBase[] overrideOnLivingUpdateHooks;
    private ClientPlayerBase[] afterOnLivingUpdateHooks;
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
    private ClientPlayerBase[] beforeOnKillEntityHooks;
    private ClientPlayerBase[] overrideOnKillEntityHooks;
    private ClientPlayerBase[] afterOnKillEntityHooks;
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
    private ClientPlayerBase[] beforeOnStruckByLightningHooks;
    private ClientPlayerBase[] overrideOnStruckByLightningHooks;
    private ClientPlayerBase[] afterOnStruckByLightningHooks;
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
    private ClientPlayerBase[] beforeOnUpdateHooks;
    private ClientPlayerBase[] overrideOnUpdateHooks;
    private ClientPlayerBase[] afterOnUpdateHooks;
    public boolean isOnUpdateModded;
    private static final Map<String, String[]> allBaseBeforeOnUpdateSuperiors;
    private static final Map<String, String[]> allBaseBeforeOnUpdateInferiors;
    private static final Map<String, String[]> allBaseOverrideOnUpdateSuperiors;
    private static final Map<String, String[]> allBaseOverrideOnUpdateInferiors;
    private static final Map<String, String[]> allBaseAfterOnUpdateSuperiors;
    private static final Map<String, String[]> allBaseAfterOnUpdateInferiors;
    private static final List<String> beforePlayStepSoundHookTypes;
    private static final List<String> overridePlayStepSoundHookTypes;
    private static final List<String> afterPlayStepSoundHookTypes;
    private ClientPlayerBase[] beforePlayStepSoundHooks;
    private ClientPlayerBase[] overridePlayStepSoundHooks;
    private ClientPlayerBase[] afterPlayStepSoundHooks;
    public boolean isPlayStepSoundModded;
    private static final Map<String, String[]> allBaseBeforePlayStepSoundSuperiors;
    private static final Map<String, String[]> allBaseBeforePlayStepSoundInferiors;
    private static final Map<String, String[]> allBaseOverridePlayStepSoundSuperiors;
    private static final Map<String, String[]> allBaseOverridePlayStepSoundInferiors;
    private static final Map<String, String[]> allBaseAfterPlayStepSoundSuperiors;
    private static final Map<String, String[]> allBaseAfterPlayStepSoundInferiors;
    private static final List<String> beforePushOutOfBlocksHookTypes;
    private static final List<String> overridePushOutOfBlocksHookTypes;
    private static final List<String> afterPushOutOfBlocksHookTypes;
    private ClientPlayerBase[] beforePushOutOfBlocksHooks;
    private ClientPlayerBase[] overridePushOutOfBlocksHooks;
    private ClientPlayerBase[] afterPushOutOfBlocksHooks;
    public boolean isPushOutOfBlocksModded;
    private static final Map<String, String[]> allBaseBeforePushOutOfBlocksSuperiors;
    private static final Map<String, String[]> allBaseBeforePushOutOfBlocksInferiors;
    private static final Map<String, String[]> allBaseOverridePushOutOfBlocksSuperiors;
    private static final Map<String, String[]> allBaseOverridePushOutOfBlocksInferiors;
    private static final Map<String, String[]> allBaseAfterPushOutOfBlocksSuperiors;
    private static final Map<String, String[]> allBaseAfterPushOutOfBlocksInferiors;
    private static final List<String> beforeRayTraceHookTypes;
    private static final List<String> overrideRayTraceHookTypes;
    private static final List<String> afterRayTraceHookTypes;
    private ClientPlayerBase[] beforeRayTraceHooks;
    private ClientPlayerBase[] overrideRayTraceHooks;
    private ClientPlayerBase[] afterRayTraceHooks;
    public boolean isRayTraceModded;
    private static final Map<String, String[]> allBaseBeforeRayTraceSuperiors;
    private static final Map<String, String[]> allBaseBeforeRayTraceInferiors;
    private static final Map<String, String[]> allBaseOverrideRayTraceSuperiors;
    private static final Map<String, String[]> allBaseOverrideRayTraceInferiors;
    private static final Map<String, String[]> allBaseAfterRayTraceSuperiors;
    private static final Map<String, String[]> allBaseAfterRayTraceInferiors;
    private static final List<String> beforeReadEntityFromNBTHookTypes;
    private static final List<String> overrideReadEntityFromNBTHookTypes;
    private static final List<String> afterReadEntityFromNBTHookTypes;
    private ClientPlayerBase[] beforeReadEntityFromNBTHooks;
    private ClientPlayerBase[] overrideReadEntityFromNBTHooks;
    private ClientPlayerBase[] afterReadEntityFromNBTHooks;
    public boolean isReadEntityFromNBTModded;
    private static final Map<String, String[]> allBaseBeforeReadEntityFromNBTSuperiors;
    private static final Map<String, String[]> allBaseBeforeReadEntityFromNBTInferiors;
    private static final Map<String, String[]> allBaseOverrideReadEntityFromNBTSuperiors;
    private static final Map<String, String[]> allBaseOverrideReadEntityFromNBTInferiors;
    private static final Map<String, String[]> allBaseAfterReadEntityFromNBTSuperiors;
    private static final Map<String, String[]> allBaseAfterReadEntityFromNBTInferiors;
    private static final List<String> beforeRespawnPlayerHookTypes;
    private static final List<String> overrideRespawnPlayerHookTypes;
    private static final List<String> afterRespawnPlayerHookTypes;
    private ClientPlayerBase[] beforeRespawnPlayerHooks;
    private ClientPlayerBase[] overrideRespawnPlayerHooks;
    private ClientPlayerBase[] afterRespawnPlayerHooks;
    public boolean isRespawnPlayerModded;
    private static final Map<String, String[]> allBaseBeforeRespawnPlayerSuperiors;
    private static final Map<String, String[]> allBaseBeforeRespawnPlayerInferiors;
    private static final Map<String, String[]> allBaseOverrideRespawnPlayerSuperiors;
    private static final Map<String, String[]> allBaseOverrideRespawnPlayerInferiors;
    private static final Map<String, String[]> allBaseAfterRespawnPlayerSuperiors;
    private static final Map<String, String[]> allBaseAfterRespawnPlayerInferiors;
    private static final List<String> beforeSetDeadHookTypes;
    private static final List<String> overrideSetDeadHookTypes;
    private static final List<String> afterSetDeadHookTypes;
    private ClientPlayerBase[] beforeSetDeadHooks;
    private ClientPlayerBase[] overrideSetDeadHooks;
    private ClientPlayerBase[] afterSetDeadHooks;
    public boolean isSetDeadModded;
    private static final Map<String, String[]> allBaseBeforeSetDeadSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetDeadInferiors;
    private static final Map<String, String[]> allBaseOverrideSetDeadSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetDeadInferiors;
    private static final Map<String, String[]> allBaseAfterSetDeadSuperiors;
    private static final Map<String, String[]> allBaseAfterSetDeadInferiors;
    private static final List<String> beforeSetPlayerSPHealthHookTypes;
    private static final List<String> overrideSetPlayerSPHealthHookTypes;
    private static final List<String> afterSetPlayerSPHealthHookTypes;
    private ClientPlayerBase[] beforeSetPlayerSPHealthHooks;
    private ClientPlayerBase[] overrideSetPlayerSPHealthHooks;
    private ClientPlayerBase[] afterSetPlayerSPHealthHooks;
    public boolean isSetPlayerSPHealthModded;
    private static final Map<String, String[]> allBaseBeforeSetPlayerSPHealthSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetPlayerSPHealthInferiors;
    private static final Map<String, String[]> allBaseOverrideSetPlayerSPHealthSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetPlayerSPHealthInferiors;
    private static final Map<String, String[]> allBaseAfterSetPlayerSPHealthSuperiors;
    private static final Map<String, String[]> allBaseAfterSetPlayerSPHealthInferiors;
    private static final List<String> beforeSetPositionAndRotationHookTypes;
    private static final List<String> overrideSetPositionAndRotationHookTypes;
    private static final List<String> afterSetPositionAndRotationHookTypes;
    private ClientPlayerBase[] beforeSetPositionAndRotationHooks;
    private ClientPlayerBase[] overrideSetPositionAndRotationHooks;
    private ClientPlayerBase[] afterSetPositionAndRotationHooks;
    public boolean isSetPositionAndRotationModded;
    private static final Map<String, String[]> allBaseBeforeSetPositionAndRotationSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetPositionAndRotationInferiors;
    private static final Map<String, String[]> allBaseOverrideSetPositionAndRotationSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetPositionAndRotationInferiors;
    private static final Map<String, String[]> allBaseAfterSetPositionAndRotationSuperiors;
    private static final Map<String, String[]> allBaseAfterSetPositionAndRotationInferiors;
    private static final List<String> beforeSleepInBedAtHookTypes;
    private static final List<String> overrideSleepInBedAtHookTypes;
    private static final List<String> afterSleepInBedAtHookTypes;
    private ClientPlayerBase[] beforeSleepInBedAtHooks;
    private ClientPlayerBase[] overrideSleepInBedAtHooks;
    private ClientPlayerBase[] afterSleepInBedAtHooks;
    public boolean isSleepInBedAtModded;
    private static final Map<String, String[]> allBaseBeforeSleepInBedAtSuperiors;
    private static final Map<String, String[]> allBaseBeforeSleepInBedAtInferiors;
    private static final Map<String, String[]> allBaseOverrideSleepInBedAtSuperiors;
    private static final Map<String, String[]> allBaseOverrideSleepInBedAtInferiors;
    private static final Map<String, String[]> allBaseAfterSleepInBedAtSuperiors;
    private static final Map<String, String[]> allBaseAfterSleepInBedAtInferiors;
    private static final List<String> beforeSwingItemHookTypes;
    private static final List<String> overrideSwingItemHookTypes;
    private static final List<String> afterSwingItemHookTypes;
    private ClientPlayerBase[] beforeSwingItemHooks;
    private ClientPlayerBase[] overrideSwingItemHooks;
    private ClientPlayerBase[] afterSwingItemHooks;
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
    private ClientPlayerBase[] beforeUpdateEntityActionStateHooks;
    private ClientPlayerBase[] overrideUpdateEntityActionStateHooks;
    private ClientPlayerBase[] afterUpdateEntityActionStateHooks;
    public boolean isUpdateEntityActionStateModded;
    private static final Map<String, String[]> allBaseBeforeUpdateEntityActionStateSuperiors;
    private static final Map<String, String[]> allBaseBeforeUpdateEntityActionStateInferiors;
    private static final Map<String, String[]> allBaseOverrideUpdateEntityActionStateSuperiors;
    private static final Map<String, String[]> allBaseOverrideUpdateEntityActionStateInferiors;
    private static final Map<String, String[]> allBaseAfterUpdateEntityActionStateSuperiors;
    private static final Map<String, String[]> allBaseAfterUpdateEntityActionStateInferiors;
    private static final List<String> beforeUpdateRiddenHookTypes;
    private static final List<String> overrideUpdateRiddenHookTypes;
    private static final List<String> afterUpdateRiddenHookTypes;
    private ClientPlayerBase[] beforeUpdateRiddenHooks;
    private ClientPlayerBase[] overrideUpdateRiddenHooks;
    private ClientPlayerBase[] afterUpdateRiddenHooks;
    public boolean isUpdateRiddenModded;
    private static final Map<String, String[]> allBaseBeforeUpdateRiddenSuperiors;
    private static final Map<String, String[]> allBaseBeforeUpdateRiddenInferiors;
    private static final Map<String, String[]> allBaseOverrideUpdateRiddenSuperiors;
    private static final Map<String, String[]> allBaseOverrideUpdateRiddenInferiors;
    private static final Map<String, String[]> allBaseAfterUpdateRiddenSuperiors;
    private static final Map<String, String[]> allBaseAfterUpdateRiddenInferiors;
    private static final List<String> beforeWriteEntityToNBTHookTypes;
    private static final List<String> overrideWriteEntityToNBTHookTypes;
    private static final List<String> afterWriteEntityToNBTHookTypes;
    private ClientPlayerBase[] beforeWriteEntityToNBTHooks;
    private ClientPlayerBase[] overrideWriteEntityToNBTHooks;
    private ClientPlayerBase[] afterWriteEntityToNBTHooks;
    public boolean isWriteEntityToNBTModded;
    private static final Map<String, String[]> allBaseBeforeWriteEntityToNBTSuperiors;
    private static final Map<String, String[]> allBaseBeforeWriteEntityToNBTInferiors;
    private static final Map<String, String[]> allBaseOverrideWriteEntityToNBTSuperiors;
    private static final Map<String, String[]> allBaseOverrideWriteEntityToNBTInferiors;
    private static final Map<String, String[]> allBaseAfterWriteEntityToNBTSuperiors;
    private static final Map<String, String[]> allBaseAfterWriteEntityToNBTInferiors;
    protected final IClientPlayerAPI player;
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
    private ClientPlayerBase[] beforeLocalConstructingHooks;
    private ClientPlayerBase[] afterLocalConstructingHooks;
    private final Map<ClientPlayerBase, String> baseObjectsToId = new Hashtable<ClientPlayerBase, String>();
    private final Map<String, ClientPlayerBase> allBaseObjects = new Hashtable<String, ClientPlayerBase>();
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
        ClientPlayerAPI.register(string, clazz, null);
    }

    public static void register(String string, Class<?> clazz, ClientPlayerBaseSorting clientPlayerBaseSorting) {
        try {
            ClientPlayerAPI.register(clazz, string, clientPlayerBaseSorting);
        }
        catch (RuntimeException runtimeException) {
            if (string != null) {
                ClientPlayerAPI.log("Client Player: failed to register id '" + string + "'");
            } else {
                ClientPlayerAPI.log("Client Player: failed to register ClientPlayerBase");
            }
            throw runtimeException;
        }
    }

    /*
     * WARNING - void declaration
     */
    private static void register(Class<?> clazz, String string, ClientPlayerBaseSorting clientPlayerBaseSorting) {
        Constructor<?> constructor;
        Executable executable;
        if (!isCreated) {
            try {
                executable = EntityPlayerSP.class.getMethod("getClientPlayerBase", String.class);
                if (((Method)executable).getReturnType() != ClientPlayerBase.class) {
                    throw new NoSuchMethodException(ClientPlayerBase.class.getName() + " " + EntityPlayerSP.class.getName() + ".getClientPlayerBase(" + String.class.getName() + ")");
                }
            }
            catch (NoSuchMethodException noSuchMethodException) {
                void var9_20;
                void object;
                String[] stringArray = new String[]{"========================================", "The API \"Client Player\" version 1.1 of the mod \"Player API core 1.1\" can not be created!", "----------------------------------------", "Mandatory member method \"{0} getClientPlayerBase({3})\" not found in class \"{1}\".", "There are three scenarios this can happen:", "* Minecraft Forge is missing a Player API core which Minecraft version matches its own.", "  Download and install the latest Player API core for the Minecraft version you were trying to run.", "* The code of the class \"{2}\" of Player API core has been modified beyond recognition by another Minecraft Forge coremod.", "  Try temporary deinstallation of other core mods to find the culprit and deinstall it permanently to fix this specific problem.", "* Player API core has not been installed correctly.", "  Deinstall Player API core and install it again following the installation instructions in the readme file.", "========================================"};
                String string2 = ClientPlayerBase.class.getName();
                String string3 = EntityPlayerSP.class.getName();
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
            ClientPlayerAPI.log("Client Player 1.1 Created");
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
                throw new IllegalArgumentException("Can not find necessary constructor with one argument of type '" + ClientPlayerAPI.class.getName() + "' and eventually a second argument of type 'String' in the class '" + clazz.getName() + "'", throwable);
            }
        }
        allBaseConstructors.put(string, constructor);
        if (clientPlayerBaseSorting != null) {
            ClientPlayerAPI.addSorting(string, allBaseBeforeLocalConstructingSuperiors, clientPlayerBaseSorting.getBeforeLocalConstructingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeLocalConstructingInferiors, clientPlayerBaseSorting.getBeforeLocalConstructingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterLocalConstructingSuperiors, clientPlayerBaseSorting.getAfterLocalConstructingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterLocalConstructingInferiors, clientPlayerBaseSorting.getAfterLocalConstructingInferiors());
            ClientPlayerAPI.addDynamicSorting(string, allBaseBeforeDynamicSuperiors, clientPlayerBaseSorting.getDynamicBeforeSuperiors());
            ClientPlayerAPI.addDynamicSorting(string, allBaseBeforeDynamicInferiors, clientPlayerBaseSorting.getDynamicBeforeInferiors());
            ClientPlayerAPI.addDynamicSorting(string, allBaseOverrideDynamicSuperiors, clientPlayerBaseSorting.getDynamicOverrideSuperiors());
            ClientPlayerAPI.addDynamicSorting(string, allBaseOverrideDynamicInferiors, clientPlayerBaseSorting.getDynamicOverrideInferiors());
            ClientPlayerAPI.addDynamicSorting(string, allBaseAfterDynamicSuperiors, clientPlayerBaseSorting.getDynamicAfterSuperiors());
            ClientPlayerAPI.addDynamicSorting(string, allBaseAfterDynamicInferiors, clientPlayerBaseSorting.getDynamicAfterInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeAddExhaustionSuperiors, clientPlayerBaseSorting.getBeforeAddExhaustionSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeAddExhaustionInferiors, clientPlayerBaseSorting.getBeforeAddExhaustionInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideAddExhaustionSuperiors, clientPlayerBaseSorting.getOverrideAddExhaustionSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideAddExhaustionInferiors, clientPlayerBaseSorting.getOverrideAddExhaustionInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterAddExhaustionSuperiors, clientPlayerBaseSorting.getAfterAddExhaustionSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterAddExhaustionInferiors, clientPlayerBaseSorting.getAfterAddExhaustionInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeAddMovementStatSuperiors, clientPlayerBaseSorting.getBeforeAddMovementStatSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeAddMovementStatInferiors, clientPlayerBaseSorting.getBeforeAddMovementStatInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideAddMovementStatSuperiors, clientPlayerBaseSorting.getOverrideAddMovementStatSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideAddMovementStatInferiors, clientPlayerBaseSorting.getOverrideAddMovementStatInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterAddMovementStatSuperiors, clientPlayerBaseSorting.getAfterAddMovementStatSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterAddMovementStatInferiors, clientPlayerBaseSorting.getAfterAddMovementStatInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeAddStatSuperiors, clientPlayerBaseSorting.getBeforeAddStatSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeAddStatInferiors, clientPlayerBaseSorting.getBeforeAddStatInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideAddStatSuperiors, clientPlayerBaseSorting.getOverrideAddStatSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideAddStatInferiors, clientPlayerBaseSorting.getOverrideAddStatInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterAddStatSuperiors, clientPlayerBaseSorting.getAfterAddStatSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterAddStatInferiors, clientPlayerBaseSorting.getAfterAddStatInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeAttackEntityFromSuperiors, clientPlayerBaseSorting.getBeforeAttackEntityFromSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeAttackEntityFromInferiors, clientPlayerBaseSorting.getBeforeAttackEntityFromInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideAttackEntityFromSuperiors, clientPlayerBaseSorting.getOverrideAttackEntityFromSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideAttackEntityFromInferiors, clientPlayerBaseSorting.getOverrideAttackEntityFromInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterAttackEntityFromSuperiors, clientPlayerBaseSorting.getAfterAttackEntityFromSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterAttackEntityFromInferiors, clientPlayerBaseSorting.getAfterAttackEntityFromInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors, clientPlayerBaseSorting.getBeforeAttackTargetEntityWithCurrentItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeAttackTargetEntityWithCurrentItemInferiors, clientPlayerBaseSorting.getBeforeAttackTargetEntityWithCurrentItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors, clientPlayerBaseSorting.getOverrideAttackTargetEntityWithCurrentItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideAttackTargetEntityWithCurrentItemInferiors, clientPlayerBaseSorting.getOverrideAttackTargetEntityWithCurrentItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterAttackTargetEntityWithCurrentItemSuperiors, clientPlayerBaseSorting.getAfterAttackTargetEntityWithCurrentItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterAttackTargetEntityWithCurrentItemInferiors, clientPlayerBaseSorting.getAfterAttackTargetEntityWithCurrentItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeCanBreatheUnderwaterSuperiors, clientPlayerBaseSorting.getBeforeCanBreatheUnderwaterSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeCanBreatheUnderwaterInferiors, clientPlayerBaseSorting.getBeforeCanBreatheUnderwaterInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideCanBreatheUnderwaterSuperiors, clientPlayerBaseSorting.getOverrideCanBreatheUnderwaterSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideCanBreatheUnderwaterInferiors, clientPlayerBaseSorting.getOverrideCanBreatheUnderwaterInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterCanBreatheUnderwaterSuperiors, clientPlayerBaseSorting.getAfterCanBreatheUnderwaterSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterCanBreatheUnderwaterInferiors, clientPlayerBaseSorting.getAfterCanBreatheUnderwaterInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeCanHarvestBlockSuperiors, clientPlayerBaseSorting.getBeforeCanHarvestBlockSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeCanHarvestBlockInferiors, clientPlayerBaseSorting.getBeforeCanHarvestBlockInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideCanHarvestBlockSuperiors, clientPlayerBaseSorting.getOverrideCanHarvestBlockSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideCanHarvestBlockInferiors, clientPlayerBaseSorting.getOverrideCanHarvestBlockInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterCanHarvestBlockSuperiors, clientPlayerBaseSorting.getAfterCanHarvestBlockSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterCanHarvestBlockInferiors, clientPlayerBaseSorting.getAfterCanHarvestBlockInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeCanPlayerEditSuperiors, clientPlayerBaseSorting.getBeforeCanPlayerEditSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeCanPlayerEditInferiors, clientPlayerBaseSorting.getBeforeCanPlayerEditInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideCanPlayerEditSuperiors, clientPlayerBaseSorting.getOverrideCanPlayerEditSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideCanPlayerEditInferiors, clientPlayerBaseSorting.getOverrideCanPlayerEditInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterCanPlayerEditSuperiors, clientPlayerBaseSorting.getAfterCanPlayerEditSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterCanPlayerEditInferiors, clientPlayerBaseSorting.getAfterCanPlayerEditInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeCanTriggerWalkingSuperiors, clientPlayerBaseSorting.getBeforeCanTriggerWalkingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeCanTriggerWalkingInferiors, clientPlayerBaseSorting.getBeforeCanTriggerWalkingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideCanTriggerWalkingSuperiors, clientPlayerBaseSorting.getOverrideCanTriggerWalkingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideCanTriggerWalkingInferiors, clientPlayerBaseSorting.getOverrideCanTriggerWalkingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterCanTriggerWalkingSuperiors, clientPlayerBaseSorting.getAfterCanTriggerWalkingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterCanTriggerWalkingInferiors, clientPlayerBaseSorting.getAfterCanTriggerWalkingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeCloseScreenSuperiors, clientPlayerBaseSorting.getBeforeCloseScreenSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeCloseScreenInferiors, clientPlayerBaseSorting.getBeforeCloseScreenInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideCloseScreenSuperiors, clientPlayerBaseSorting.getOverrideCloseScreenSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideCloseScreenInferiors, clientPlayerBaseSorting.getOverrideCloseScreenInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterCloseScreenSuperiors, clientPlayerBaseSorting.getAfterCloseScreenSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterCloseScreenInferiors, clientPlayerBaseSorting.getAfterCloseScreenInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDamageEntitySuperiors, clientPlayerBaseSorting.getBeforeDamageEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDamageEntityInferiors, clientPlayerBaseSorting.getBeforeDamageEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDamageEntitySuperiors, clientPlayerBaseSorting.getOverrideDamageEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDamageEntityInferiors, clientPlayerBaseSorting.getOverrideDamageEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDamageEntitySuperiors, clientPlayerBaseSorting.getAfterDamageEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDamageEntityInferiors, clientPlayerBaseSorting.getAfterDamageEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIBrewingStandSuperiors, clientPlayerBaseSorting.getBeforeDisplayGUIBrewingStandSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIBrewingStandInferiors, clientPlayerBaseSorting.getBeforeDisplayGUIBrewingStandInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIBrewingStandSuperiors, clientPlayerBaseSorting.getOverrideDisplayGUIBrewingStandSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIBrewingStandInferiors, clientPlayerBaseSorting.getOverrideDisplayGUIBrewingStandInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIBrewingStandSuperiors, clientPlayerBaseSorting.getAfterDisplayGUIBrewingStandSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIBrewingStandInferiors, clientPlayerBaseSorting.getAfterDisplayGUIBrewingStandInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIChestSuperiors, clientPlayerBaseSorting.getBeforeDisplayGUIChestSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIChestInferiors, clientPlayerBaseSorting.getBeforeDisplayGUIChestInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIChestSuperiors, clientPlayerBaseSorting.getOverrideDisplayGUIChestSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIChestInferiors, clientPlayerBaseSorting.getOverrideDisplayGUIChestInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIChestSuperiors, clientPlayerBaseSorting.getAfterDisplayGUIChestSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIChestInferiors, clientPlayerBaseSorting.getAfterDisplayGUIChestInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIDispenserSuperiors, clientPlayerBaseSorting.getBeforeDisplayGUIDispenserSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIDispenserInferiors, clientPlayerBaseSorting.getBeforeDisplayGUIDispenserInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIDispenserSuperiors, clientPlayerBaseSorting.getOverrideDisplayGUIDispenserSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIDispenserInferiors, clientPlayerBaseSorting.getOverrideDisplayGUIDispenserInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIDispenserSuperiors, clientPlayerBaseSorting.getAfterDisplayGUIDispenserSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIDispenserInferiors, clientPlayerBaseSorting.getAfterDisplayGUIDispenserInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIEditSignSuperiors, clientPlayerBaseSorting.getBeforeDisplayGUIEditSignSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIEditSignInferiors, clientPlayerBaseSorting.getBeforeDisplayGUIEditSignInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIEditSignSuperiors, clientPlayerBaseSorting.getOverrideDisplayGUIEditSignSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIEditSignInferiors, clientPlayerBaseSorting.getOverrideDisplayGUIEditSignInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIEditSignSuperiors, clientPlayerBaseSorting.getAfterDisplayGUIEditSignSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIEditSignInferiors, clientPlayerBaseSorting.getAfterDisplayGUIEditSignInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIEnchantmentSuperiors, clientPlayerBaseSorting.getBeforeDisplayGUIEnchantmentSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIEnchantmentInferiors, clientPlayerBaseSorting.getBeforeDisplayGUIEnchantmentInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIEnchantmentSuperiors, clientPlayerBaseSorting.getOverrideDisplayGUIEnchantmentSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIEnchantmentInferiors, clientPlayerBaseSorting.getOverrideDisplayGUIEnchantmentInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIEnchantmentSuperiors, clientPlayerBaseSorting.getAfterDisplayGUIEnchantmentSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIEnchantmentInferiors, clientPlayerBaseSorting.getAfterDisplayGUIEnchantmentInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIFurnaceSuperiors, clientPlayerBaseSorting.getBeforeDisplayGUIFurnaceSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIFurnaceInferiors, clientPlayerBaseSorting.getBeforeDisplayGUIFurnaceInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIFurnaceSuperiors, clientPlayerBaseSorting.getOverrideDisplayGUIFurnaceSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIFurnaceInferiors, clientPlayerBaseSorting.getOverrideDisplayGUIFurnaceInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIFurnaceSuperiors, clientPlayerBaseSorting.getAfterDisplayGUIFurnaceSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIFurnaceInferiors, clientPlayerBaseSorting.getAfterDisplayGUIFurnaceInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIWorkbenchSuperiors, clientPlayerBaseSorting.getBeforeDisplayGUIWorkbenchSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDisplayGUIWorkbenchInferiors, clientPlayerBaseSorting.getBeforeDisplayGUIWorkbenchInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIWorkbenchSuperiors, clientPlayerBaseSorting.getOverrideDisplayGUIWorkbenchSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDisplayGUIWorkbenchInferiors, clientPlayerBaseSorting.getOverrideDisplayGUIWorkbenchInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIWorkbenchSuperiors, clientPlayerBaseSorting.getAfterDisplayGUIWorkbenchSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDisplayGUIWorkbenchInferiors, clientPlayerBaseSorting.getAfterDisplayGUIWorkbenchInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDropOneItemSuperiors, clientPlayerBaseSorting.getBeforeDropOneItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDropOneItemInferiors, clientPlayerBaseSorting.getBeforeDropOneItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDropOneItemSuperiors, clientPlayerBaseSorting.getOverrideDropOneItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDropOneItemInferiors, clientPlayerBaseSorting.getOverrideDropOneItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDropOneItemSuperiors, clientPlayerBaseSorting.getAfterDropOneItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDropOneItemInferiors, clientPlayerBaseSorting.getAfterDropOneItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDropPlayerItemSuperiors, clientPlayerBaseSorting.getBeforeDropPlayerItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDropPlayerItemInferiors, clientPlayerBaseSorting.getBeforeDropPlayerItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDropPlayerItemSuperiors, clientPlayerBaseSorting.getOverrideDropPlayerItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDropPlayerItemInferiors, clientPlayerBaseSorting.getOverrideDropPlayerItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDropPlayerItemSuperiors, clientPlayerBaseSorting.getAfterDropPlayerItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDropPlayerItemInferiors, clientPlayerBaseSorting.getAfterDropPlayerItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDropPlayerItemWithRandomChoiceSuperiors, clientPlayerBaseSorting.getBeforeDropPlayerItemWithRandomChoiceSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeDropPlayerItemWithRandomChoiceInferiors, clientPlayerBaseSorting.getBeforeDropPlayerItemWithRandomChoiceInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDropPlayerItemWithRandomChoiceSuperiors, clientPlayerBaseSorting.getOverrideDropPlayerItemWithRandomChoiceSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideDropPlayerItemWithRandomChoiceInferiors, clientPlayerBaseSorting.getOverrideDropPlayerItemWithRandomChoiceInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDropPlayerItemWithRandomChoiceSuperiors, clientPlayerBaseSorting.getAfterDropPlayerItemWithRandomChoiceSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterDropPlayerItemWithRandomChoiceInferiors, clientPlayerBaseSorting.getAfterDropPlayerItemWithRandomChoiceInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeFallSuperiors, clientPlayerBaseSorting.getBeforeFallSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeFallInferiors, clientPlayerBaseSorting.getBeforeFallInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideFallSuperiors, clientPlayerBaseSorting.getOverrideFallSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideFallInferiors, clientPlayerBaseSorting.getOverrideFallInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterFallSuperiors, clientPlayerBaseSorting.getAfterFallSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterFallInferiors, clientPlayerBaseSorting.getAfterFallInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetBrightnessSuperiors, clientPlayerBaseSorting.getBeforeGetBrightnessSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetBrightnessInferiors, clientPlayerBaseSorting.getBeforeGetBrightnessInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetBrightnessSuperiors, clientPlayerBaseSorting.getOverrideGetBrightnessSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetBrightnessInferiors, clientPlayerBaseSorting.getOverrideGetBrightnessInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetBrightnessSuperiors, clientPlayerBaseSorting.getAfterGetBrightnessSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetBrightnessInferiors, clientPlayerBaseSorting.getAfterGetBrightnessInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetBrightnessForRenderSuperiors, clientPlayerBaseSorting.getBeforeGetBrightnessForRenderSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetBrightnessForRenderInferiors, clientPlayerBaseSorting.getBeforeGetBrightnessForRenderInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetBrightnessForRenderSuperiors, clientPlayerBaseSorting.getOverrideGetBrightnessForRenderSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetBrightnessForRenderInferiors, clientPlayerBaseSorting.getOverrideGetBrightnessForRenderInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetBrightnessForRenderSuperiors, clientPlayerBaseSorting.getAfterGetBrightnessForRenderSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetBrightnessForRenderInferiors, clientPlayerBaseSorting.getAfterGetBrightnessForRenderInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors, clientPlayerBaseSorting.getBeforeGetCurrentPlayerStrVsBlockSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetCurrentPlayerStrVsBlockInferiors, clientPlayerBaseSorting.getBeforeGetCurrentPlayerStrVsBlockInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors, clientPlayerBaseSorting.getOverrideGetCurrentPlayerStrVsBlockSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetCurrentPlayerStrVsBlockInferiors, clientPlayerBaseSorting.getOverrideGetCurrentPlayerStrVsBlockInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetCurrentPlayerStrVsBlockSuperiors, clientPlayerBaseSorting.getAfterGetCurrentPlayerStrVsBlockSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetCurrentPlayerStrVsBlockInferiors, clientPlayerBaseSorting.getAfterGetCurrentPlayerStrVsBlockInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors, clientPlayerBaseSorting.getBeforeGetCurrentPlayerStrVsBlockForgeSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors, clientPlayerBaseSorting.getBeforeGetCurrentPlayerStrVsBlockForgeInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors, clientPlayerBaseSorting.getOverrideGetCurrentPlayerStrVsBlockForgeSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors, clientPlayerBaseSorting.getOverrideGetCurrentPlayerStrVsBlockForgeInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors, clientPlayerBaseSorting.getAfterGetCurrentPlayerStrVsBlockForgeSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors, clientPlayerBaseSorting.getAfterGetCurrentPlayerStrVsBlockForgeInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetDistanceSqSuperiors, clientPlayerBaseSorting.getBeforeGetDistanceSqSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetDistanceSqInferiors, clientPlayerBaseSorting.getBeforeGetDistanceSqInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetDistanceSqSuperiors, clientPlayerBaseSorting.getOverrideGetDistanceSqSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetDistanceSqInferiors, clientPlayerBaseSorting.getOverrideGetDistanceSqInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetDistanceSqSuperiors, clientPlayerBaseSorting.getAfterGetDistanceSqSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetDistanceSqInferiors, clientPlayerBaseSorting.getAfterGetDistanceSqInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetDistanceSqToEntitySuperiors, clientPlayerBaseSorting.getBeforeGetDistanceSqToEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetDistanceSqToEntityInferiors, clientPlayerBaseSorting.getBeforeGetDistanceSqToEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetDistanceSqToEntitySuperiors, clientPlayerBaseSorting.getOverrideGetDistanceSqToEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetDistanceSqToEntityInferiors, clientPlayerBaseSorting.getOverrideGetDistanceSqToEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetDistanceSqToEntitySuperiors, clientPlayerBaseSorting.getAfterGetDistanceSqToEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetDistanceSqToEntityInferiors, clientPlayerBaseSorting.getAfterGetDistanceSqToEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetFOVMultiplierSuperiors, clientPlayerBaseSorting.getBeforeGetFOVMultiplierSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetFOVMultiplierInferiors, clientPlayerBaseSorting.getBeforeGetFOVMultiplierInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetFOVMultiplierSuperiors, clientPlayerBaseSorting.getOverrideGetFOVMultiplierSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetFOVMultiplierInferiors, clientPlayerBaseSorting.getOverrideGetFOVMultiplierInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetFOVMultiplierSuperiors, clientPlayerBaseSorting.getAfterGetFOVMultiplierSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetFOVMultiplierInferiors, clientPlayerBaseSorting.getAfterGetFOVMultiplierInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetHurtSoundSuperiors, clientPlayerBaseSorting.getBeforeGetHurtSoundSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetHurtSoundInferiors, clientPlayerBaseSorting.getBeforeGetHurtSoundInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetHurtSoundSuperiors, clientPlayerBaseSorting.getOverrideGetHurtSoundSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetHurtSoundInferiors, clientPlayerBaseSorting.getOverrideGetHurtSoundInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetHurtSoundSuperiors, clientPlayerBaseSorting.getAfterGetHurtSoundSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetHurtSoundInferiors, clientPlayerBaseSorting.getAfterGetHurtSoundInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetItemIconSuperiors, clientPlayerBaseSorting.getBeforeGetItemIconSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetItemIconInferiors, clientPlayerBaseSorting.getBeforeGetItemIconInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetItemIconSuperiors, clientPlayerBaseSorting.getOverrideGetItemIconSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetItemIconInferiors, clientPlayerBaseSorting.getOverrideGetItemIconInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetItemIconSuperiors, clientPlayerBaseSorting.getAfterGetItemIconSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetItemIconInferiors, clientPlayerBaseSorting.getAfterGetItemIconInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetSleepTimerSuperiors, clientPlayerBaseSorting.getBeforeGetSleepTimerSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeGetSleepTimerInferiors, clientPlayerBaseSorting.getBeforeGetSleepTimerInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetSleepTimerSuperiors, clientPlayerBaseSorting.getOverrideGetSleepTimerSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideGetSleepTimerInferiors, clientPlayerBaseSorting.getOverrideGetSleepTimerInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetSleepTimerSuperiors, clientPlayerBaseSorting.getAfterGetSleepTimerSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterGetSleepTimerInferiors, clientPlayerBaseSorting.getAfterGetSleepTimerInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeHandleLavaMovementSuperiors, clientPlayerBaseSorting.getBeforeHandleLavaMovementSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeHandleLavaMovementInferiors, clientPlayerBaseSorting.getBeforeHandleLavaMovementInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideHandleLavaMovementSuperiors, clientPlayerBaseSorting.getOverrideHandleLavaMovementSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideHandleLavaMovementInferiors, clientPlayerBaseSorting.getOverrideHandleLavaMovementInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterHandleLavaMovementSuperiors, clientPlayerBaseSorting.getAfterHandleLavaMovementSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterHandleLavaMovementInferiors, clientPlayerBaseSorting.getAfterHandleLavaMovementInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeHandleWaterMovementSuperiors, clientPlayerBaseSorting.getBeforeHandleWaterMovementSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeHandleWaterMovementInferiors, clientPlayerBaseSorting.getBeforeHandleWaterMovementInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideHandleWaterMovementSuperiors, clientPlayerBaseSorting.getOverrideHandleWaterMovementSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideHandleWaterMovementInferiors, clientPlayerBaseSorting.getOverrideHandleWaterMovementInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterHandleWaterMovementSuperiors, clientPlayerBaseSorting.getAfterHandleWaterMovementSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterHandleWaterMovementInferiors, clientPlayerBaseSorting.getAfterHandleWaterMovementInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeHealSuperiors, clientPlayerBaseSorting.getBeforeHealSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeHealInferiors, clientPlayerBaseSorting.getBeforeHealInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideHealSuperiors, clientPlayerBaseSorting.getOverrideHealSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideHealInferiors, clientPlayerBaseSorting.getOverrideHealInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterHealSuperiors, clientPlayerBaseSorting.getAfterHealSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterHealInferiors, clientPlayerBaseSorting.getAfterHealInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsEntityInsideOpaqueBlockSuperiors, clientPlayerBaseSorting.getBeforeIsEntityInsideOpaqueBlockSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsEntityInsideOpaqueBlockInferiors, clientPlayerBaseSorting.getBeforeIsEntityInsideOpaqueBlockInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsEntityInsideOpaqueBlockSuperiors, clientPlayerBaseSorting.getOverrideIsEntityInsideOpaqueBlockSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsEntityInsideOpaqueBlockInferiors, clientPlayerBaseSorting.getOverrideIsEntityInsideOpaqueBlockInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsEntityInsideOpaqueBlockSuperiors, clientPlayerBaseSorting.getAfterIsEntityInsideOpaqueBlockSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsEntityInsideOpaqueBlockInferiors, clientPlayerBaseSorting.getAfterIsEntityInsideOpaqueBlockInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsInWaterSuperiors, clientPlayerBaseSorting.getBeforeIsInWaterSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsInWaterInferiors, clientPlayerBaseSorting.getBeforeIsInWaterInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsInWaterSuperiors, clientPlayerBaseSorting.getOverrideIsInWaterSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsInWaterInferiors, clientPlayerBaseSorting.getOverrideIsInWaterInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsInWaterSuperiors, clientPlayerBaseSorting.getAfterIsInWaterSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsInWaterInferiors, clientPlayerBaseSorting.getAfterIsInWaterInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsInsideOfMaterialSuperiors, clientPlayerBaseSorting.getBeforeIsInsideOfMaterialSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsInsideOfMaterialInferiors, clientPlayerBaseSorting.getBeforeIsInsideOfMaterialInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsInsideOfMaterialSuperiors, clientPlayerBaseSorting.getOverrideIsInsideOfMaterialSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsInsideOfMaterialInferiors, clientPlayerBaseSorting.getOverrideIsInsideOfMaterialInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsInsideOfMaterialSuperiors, clientPlayerBaseSorting.getAfterIsInsideOfMaterialSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsInsideOfMaterialInferiors, clientPlayerBaseSorting.getAfterIsInsideOfMaterialInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsOnLadderSuperiors, clientPlayerBaseSorting.getBeforeIsOnLadderSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsOnLadderInferiors, clientPlayerBaseSorting.getBeforeIsOnLadderInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsOnLadderSuperiors, clientPlayerBaseSorting.getOverrideIsOnLadderSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsOnLadderInferiors, clientPlayerBaseSorting.getOverrideIsOnLadderInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsOnLadderSuperiors, clientPlayerBaseSorting.getAfterIsOnLadderSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsOnLadderInferiors, clientPlayerBaseSorting.getAfterIsOnLadderInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsPlayerSleepingSuperiors, clientPlayerBaseSorting.getBeforeIsPlayerSleepingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsPlayerSleepingInferiors, clientPlayerBaseSorting.getBeforeIsPlayerSleepingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsPlayerSleepingSuperiors, clientPlayerBaseSorting.getOverrideIsPlayerSleepingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsPlayerSleepingInferiors, clientPlayerBaseSorting.getOverrideIsPlayerSleepingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsPlayerSleepingSuperiors, clientPlayerBaseSorting.getAfterIsPlayerSleepingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsPlayerSleepingInferiors, clientPlayerBaseSorting.getAfterIsPlayerSleepingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsSneakingSuperiors, clientPlayerBaseSorting.getBeforeIsSneakingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsSneakingInferiors, clientPlayerBaseSorting.getBeforeIsSneakingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsSneakingSuperiors, clientPlayerBaseSorting.getOverrideIsSneakingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsSneakingInferiors, clientPlayerBaseSorting.getOverrideIsSneakingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsSneakingSuperiors, clientPlayerBaseSorting.getAfterIsSneakingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsSneakingInferiors, clientPlayerBaseSorting.getAfterIsSneakingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsSprintingSuperiors, clientPlayerBaseSorting.getBeforeIsSprintingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeIsSprintingInferiors, clientPlayerBaseSorting.getBeforeIsSprintingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsSprintingSuperiors, clientPlayerBaseSorting.getOverrideIsSprintingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideIsSprintingInferiors, clientPlayerBaseSorting.getOverrideIsSprintingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsSprintingSuperiors, clientPlayerBaseSorting.getAfterIsSprintingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterIsSprintingInferiors, clientPlayerBaseSorting.getAfterIsSprintingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeJumpSuperiors, clientPlayerBaseSorting.getBeforeJumpSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeJumpInferiors, clientPlayerBaseSorting.getBeforeJumpInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideJumpSuperiors, clientPlayerBaseSorting.getOverrideJumpSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideJumpInferiors, clientPlayerBaseSorting.getOverrideJumpInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterJumpSuperiors, clientPlayerBaseSorting.getAfterJumpSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterJumpInferiors, clientPlayerBaseSorting.getAfterJumpInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeKnockBackSuperiors, clientPlayerBaseSorting.getBeforeKnockBackSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeKnockBackInferiors, clientPlayerBaseSorting.getBeforeKnockBackInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideKnockBackSuperiors, clientPlayerBaseSorting.getOverrideKnockBackSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideKnockBackInferiors, clientPlayerBaseSorting.getOverrideKnockBackInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterKnockBackSuperiors, clientPlayerBaseSorting.getAfterKnockBackSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterKnockBackInferiors, clientPlayerBaseSorting.getAfterKnockBackInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeMoveEntitySuperiors, clientPlayerBaseSorting.getBeforeMoveEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeMoveEntityInferiors, clientPlayerBaseSorting.getBeforeMoveEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideMoveEntitySuperiors, clientPlayerBaseSorting.getOverrideMoveEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideMoveEntityInferiors, clientPlayerBaseSorting.getOverrideMoveEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterMoveEntitySuperiors, clientPlayerBaseSorting.getAfterMoveEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterMoveEntityInferiors, clientPlayerBaseSorting.getAfterMoveEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeMoveEntityWithHeadingSuperiors, clientPlayerBaseSorting.getBeforeMoveEntityWithHeadingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeMoveEntityWithHeadingInferiors, clientPlayerBaseSorting.getBeforeMoveEntityWithHeadingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideMoveEntityWithHeadingSuperiors, clientPlayerBaseSorting.getOverrideMoveEntityWithHeadingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideMoveEntityWithHeadingInferiors, clientPlayerBaseSorting.getOverrideMoveEntityWithHeadingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterMoveEntityWithHeadingSuperiors, clientPlayerBaseSorting.getAfterMoveEntityWithHeadingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterMoveEntityWithHeadingInferiors, clientPlayerBaseSorting.getAfterMoveEntityWithHeadingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeMoveFlyingSuperiors, clientPlayerBaseSorting.getBeforeMoveFlyingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeMoveFlyingInferiors, clientPlayerBaseSorting.getBeforeMoveFlyingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideMoveFlyingSuperiors, clientPlayerBaseSorting.getOverrideMoveFlyingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideMoveFlyingInferiors, clientPlayerBaseSorting.getOverrideMoveFlyingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterMoveFlyingSuperiors, clientPlayerBaseSorting.getAfterMoveFlyingSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterMoveFlyingInferiors, clientPlayerBaseSorting.getAfterMoveFlyingInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeOnDeathSuperiors, clientPlayerBaseSorting.getBeforeOnDeathSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeOnDeathInferiors, clientPlayerBaseSorting.getBeforeOnDeathInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideOnDeathSuperiors, clientPlayerBaseSorting.getOverrideOnDeathSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideOnDeathInferiors, clientPlayerBaseSorting.getOverrideOnDeathInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterOnDeathSuperiors, clientPlayerBaseSorting.getAfterOnDeathSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterOnDeathInferiors, clientPlayerBaseSorting.getAfterOnDeathInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeOnLivingUpdateSuperiors, clientPlayerBaseSorting.getBeforeOnLivingUpdateSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeOnLivingUpdateInferiors, clientPlayerBaseSorting.getBeforeOnLivingUpdateInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideOnLivingUpdateSuperiors, clientPlayerBaseSorting.getOverrideOnLivingUpdateSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideOnLivingUpdateInferiors, clientPlayerBaseSorting.getOverrideOnLivingUpdateInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterOnLivingUpdateSuperiors, clientPlayerBaseSorting.getAfterOnLivingUpdateSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterOnLivingUpdateInferiors, clientPlayerBaseSorting.getAfterOnLivingUpdateInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeOnKillEntitySuperiors, clientPlayerBaseSorting.getBeforeOnKillEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeOnKillEntityInferiors, clientPlayerBaseSorting.getBeforeOnKillEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideOnKillEntitySuperiors, clientPlayerBaseSorting.getOverrideOnKillEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideOnKillEntityInferiors, clientPlayerBaseSorting.getOverrideOnKillEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterOnKillEntitySuperiors, clientPlayerBaseSorting.getAfterOnKillEntitySuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterOnKillEntityInferiors, clientPlayerBaseSorting.getAfterOnKillEntityInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeOnStruckByLightningSuperiors, clientPlayerBaseSorting.getBeforeOnStruckByLightningSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeOnStruckByLightningInferiors, clientPlayerBaseSorting.getBeforeOnStruckByLightningInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideOnStruckByLightningSuperiors, clientPlayerBaseSorting.getOverrideOnStruckByLightningSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideOnStruckByLightningInferiors, clientPlayerBaseSorting.getOverrideOnStruckByLightningInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterOnStruckByLightningSuperiors, clientPlayerBaseSorting.getAfterOnStruckByLightningSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterOnStruckByLightningInferiors, clientPlayerBaseSorting.getAfterOnStruckByLightningInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeOnUpdateSuperiors, clientPlayerBaseSorting.getBeforeOnUpdateSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeOnUpdateInferiors, clientPlayerBaseSorting.getBeforeOnUpdateInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideOnUpdateSuperiors, clientPlayerBaseSorting.getOverrideOnUpdateSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideOnUpdateInferiors, clientPlayerBaseSorting.getOverrideOnUpdateInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterOnUpdateSuperiors, clientPlayerBaseSorting.getAfterOnUpdateSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterOnUpdateInferiors, clientPlayerBaseSorting.getAfterOnUpdateInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforePlayStepSoundSuperiors, clientPlayerBaseSorting.getBeforePlayStepSoundSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforePlayStepSoundInferiors, clientPlayerBaseSorting.getBeforePlayStepSoundInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverridePlayStepSoundSuperiors, clientPlayerBaseSorting.getOverridePlayStepSoundSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverridePlayStepSoundInferiors, clientPlayerBaseSorting.getOverridePlayStepSoundInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterPlayStepSoundSuperiors, clientPlayerBaseSorting.getAfterPlayStepSoundSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterPlayStepSoundInferiors, clientPlayerBaseSorting.getAfterPlayStepSoundInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforePushOutOfBlocksSuperiors, clientPlayerBaseSorting.getBeforePushOutOfBlocksSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforePushOutOfBlocksInferiors, clientPlayerBaseSorting.getBeforePushOutOfBlocksInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverridePushOutOfBlocksSuperiors, clientPlayerBaseSorting.getOverridePushOutOfBlocksSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverridePushOutOfBlocksInferiors, clientPlayerBaseSorting.getOverridePushOutOfBlocksInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterPushOutOfBlocksSuperiors, clientPlayerBaseSorting.getAfterPushOutOfBlocksSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterPushOutOfBlocksInferiors, clientPlayerBaseSorting.getAfterPushOutOfBlocksInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeRayTraceSuperiors, clientPlayerBaseSorting.getBeforeRayTraceSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeRayTraceInferiors, clientPlayerBaseSorting.getBeforeRayTraceInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideRayTraceSuperiors, clientPlayerBaseSorting.getOverrideRayTraceSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideRayTraceInferiors, clientPlayerBaseSorting.getOverrideRayTraceInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterRayTraceSuperiors, clientPlayerBaseSorting.getAfterRayTraceSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterRayTraceInferiors, clientPlayerBaseSorting.getAfterRayTraceInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeReadEntityFromNBTSuperiors, clientPlayerBaseSorting.getBeforeReadEntityFromNBTSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeReadEntityFromNBTInferiors, clientPlayerBaseSorting.getBeforeReadEntityFromNBTInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideReadEntityFromNBTSuperiors, clientPlayerBaseSorting.getOverrideReadEntityFromNBTSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideReadEntityFromNBTInferiors, clientPlayerBaseSorting.getOverrideReadEntityFromNBTInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterReadEntityFromNBTSuperiors, clientPlayerBaseSorting.getAfterReadEntityFromNBTSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterReadEntityFromNBTInferiors, clientPlayerBaseSorting.getAfterReadEntityFromNBTInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeRespawnPlayerSuperiors, clientPlayerBaseSorting.getBeforeRespawnPlayerSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeRespawnPlayerInferiors, clientPlayerBaseSorting.getBeforeRespawnPlayerInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideRespawnPlayerSuperiors, clientPlayerBaseSorting.getOverrideRespawnPlayerSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideRespawnPlayerInferiors, clientPlayerBaseSorting.getOverrideRespawnPlayerInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterRespawnPlayerSuperiors, clientPlayerBaseSorting.getAfterRespawnPlayerSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterRespawnPlayerInferiors, clientPlayerBaseSorting.getAfterRespawnPlayerInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeSetDeadSuperiors, clientPlayerBaseSorting.getBeforeSetDeadSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeSetDeadInferiors, clientPlayerBaseSorting.getBeforeSetDeadInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideSetDeadSuperiors, clientPlayerBaseSorting.getOverrideSetDeadSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideSetDeadInferiors, clientPlayerBaseSorting.getOverrideSetDeadInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterSetDeadSuperiors, clientPlayerBaseSorting.getAfterSetDeadSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterSetDeadInferiors, clientPlayerBaseSorting.getAfterSetDeadInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeSetPlayerSPHealthSuperiors, clientPlayerBaseSorting.getBeforeSetPlayerSPHealthSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeSetPlayerSPHealthInferiors, clientPlayerBaseSorting.getBeforeSetPlayerSPHealthInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideSetPlayerSPHealthSuperiors, clientPlayerBaseSorting.getOverrideSetPlayerSPHealthSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideSetPlayerSPHealthInferiors, clientPlayerBaseSorting.getOverrideSetPlayerSPHealthInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterSetPlayerSPHealthSuperiors, clientPlayerBaseSorting.getAfterSetPlayerSPHealthSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterSetPlayerSPHealthInferiors, clientPlayerBaseSorting.getAfterSetPlayerSPHealthInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeSetPositionAndRotationSuperiors, clientPlayerBaseSorting.getBeforeSetPositionAndRotationSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeSetPositionAndRotationInferiors, clientPlayerBaseSorting.getBeforeSetPositionAndRotationInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideSetPositionAndRotationSuperiors, clientPlayerBaseSorting.getOverrideSetPositionAndRotationSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideSetPositionAndRotationInferiors, clientPlayerBaseSorting.getOverrideSetPositionAndRotationInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterSetPositionAndRotationSuperiors, clientPlayerBaseSorting.getAfterSetPositionAndRotationSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterSetPositionAndRotationInferiors, clientPlayerBaseSorting.getAfterSetPositionAndRotationInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeSleepInBedAtSuperiors, clientPlayerBaseSorting.getBeforeSleepInBedAtSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeSleepInBedAtInferiors, clientPlayerBaseSorting.getBeforeSleepInBedAtInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideSleepInBedAtSuperiors, clientPlayerBaseSorting.getOverrideSleepInBedAtSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideSleepInBedAtInferiors, clientPlayerBaseSorting.getOverrideSleepInBedAtInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterSleepInBedAtSuperiors, clientPlayerBaseSorting.getAfterSleepInBedAtSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterSleepInBedAtInferiors, clientPlayerBaseSorting.getAfterSleepInBedAtInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeSwingItemSuperiors, clientPlayerBaseSorting.getBeforeSwingItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeSwingItemInferiors, clientPlayerBaseSorting.getBeforeSwingItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideSwingItemSuperiors, clientPlayerBaseSorting.getOverrideSwingItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideSwingItemInferiors, clientPlayerBaseSorting.getOverrideSwingItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterSwingItemSuperiors, clientPlayerBaseSorting.getAfterSwingItemSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterSwingItemInferiors, clientPlayerBaseSorting.getAfterSwingItemInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeUpdateEntityActionStateSuperiors, clientPlayerBaseSorting.getBeforeUpdateEntityActionStateSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeUpdateEntityActionStateInferiors, clientPlayerBaseSorting.getBeforeUpdateEntityActionStateInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideUpdateEntityActionStateSuperiors, clientPlayerBaseSorting.getOverrideUpdateEntityActionStateSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideUpdateEntityActionStateInferiors, clientPlayerBaseSorting.getOverrideUpdateEntityActionStateInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterUpdateEntityActionStateSuperiors, clientPlayerBaseSorting.getAfterUpdateEntityActionStateSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterUpdateEntityActionStateInferiors, clientPlayerBaseSorting.getAfterUpdateEntityActionStateInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeUpdateRiddenSuperiors, clientPlayerBaseSorting.getBeforeUpdateRiddenSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeUpdateRiddenInferiors, clientPlayerBaseSorting.getBeforeUpdateRiddenInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideUpdateRiddenSuperiors, clientPlayerBaseSorting.getOverrideUpdateRiddenSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideUpdateRiddenInferiors, clientPlayerBaseSorting.getOverrideUpdateRiddenInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterUpdateRiddenSuperiors, clientPlayerBaseSorting.getAfterUpdateRiddenSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterUpdateRiddenInferiors, clientPlayerBaseSorting.getAfterUpdateRiddenInferiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeWriteEntityToNBTSuperiors, clientPlayerBaseSorting.getBeforeWriteEntityToNBTSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseBeforeWriteEntityToNBTInferiors, clientPlayerBaseSorting.getBeforeWriteEntityToNBTInferiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideWriteEntityToNBTSuperiors, clientPlayerBaseSorting.getOverrideWriteEntityToNBTSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseOverrideWriteEntityToNBTInferiors, clientPlayerBaseSorting.getOverrideWriteEntityToNBTInferiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterWriteEntityToNBTSuperiors, clientPlayerBaseSorting.getAfterWriteEntityToNBTSuperiors());
            ClientPlayerAPI.addSorting(string, allBaseAfterWriteEntityToNBTInferiors, clientPlayerBaseSorting.getAfterWriteEntityToNBTInferiors());
        }
        ClientPlayerAPI.addMethod(string, clazz, beforeLocalConstructingHookTypes, "beforeLocalConstructing", xpzm.class, ozlu.class, hanr.class, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterLocalConstructingHookTypes, "afterLocalConstructing", xpzm.class, ozlu.class, hanr.class, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeAddExhaustionHookTypes, "beforeAddExhaustion", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideAddExhaustionHookTypes, "addExhaustion", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterAddExhaustionHookTypes, "afterAddExhaustion", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeAddMovementStatHookTypes, "beforeAddMovementStat", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideAddMovementStatHookTypes, "addMovementStat", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterAddMovementStatHookTypes, "afterAddMovementStat", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeAddStatHookTypes, "beforeAddStat", rann.class, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideAddStatHookTypes, "addStat", rann.class, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterAddStatHookTypes, "afterAddStat", rann.class, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeAttackEntityFromHookTypes, "beforeAttackEntityFrom", jxtc.class, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideAttackEntityFromHookTypes, "attackEntityFrom", jxtc.class, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterAttackEntityFromHookTypes, "afterAttackEntityFrom", jxtc.class, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeAttackTargetEntityWithCurrentItemHookTypes, "beforeAttackTargetEntityWithCurrentItem", Entity.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideAttackTargetEntityWithCurrentItemHookTypes, "attackTargetEntityWithCurrentItem", Entity.class);
        ClientPlayerAPI.addMethod(string, clazz, afterAttackTargetEntityWithCurrentItemHookTypes, "afterAttackTargetEntityWithCurrentItem", Entity.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeCanBreatheUnderwaterHookTypes, "beforeCanBreatheUnderwater", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideCanBreatheUnderwaterHookTypes, "canBreatheUnderwater", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterCanBreatheUnderwaterHookTypes, "afterCanBreatheUnderwater", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeCanHarvestBlockHookTypes, "beforeCanHarvestBlock", twgu.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideCanHarvestBlockHookTypes, "canHarvestBlock", twgu.class);
        ClientPlayerAPI.addMethod(string, clazz, afterCanHarvestBlockHookTypes, "afterCanHarvestBlock", twgu.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeCanPlayerEditHookTypes, "beforeCanPlayerEdit", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, cvzo.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideCanPlayerEditHookTypes, "canPlayerEdit", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, cvzo.class);
        ClientPlayerAPI.addMethod(string, clazz, afterCanPlayerEditHookTypes, "afterCanPlayerEdit", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, cvzo.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeCanTriggerWalkingHookTypes, "beforeCanTriggerWalking", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideCanTriggerWalkingHookTypes, "canTriggerWalking", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterCanTriggerWalkingHookTypes, "afterCanTriggerWalking", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeCloseScreenHookTypes, "beforeCloseScreen", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideCloseScreenHookTypes, "closeScreen", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterCloseScreenHookTypes, "afterCloseScreen", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeDamageEntityHookTypes, "beforeDamageEntity", jxtc.class, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideDamageEntityHookTypes, "damageEntity", jxtc.class, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterDamageEntityHookTypes, "afterDamageEntity", jxtc.class, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeDisplayGUIBrewingStandHookTypes, "beforeDisplayGUIBrewingStand", nfbs.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideDisplayGUIBrewingStandHookTypes, "displayGUIBrewingStand", nfbs.class);
        ClientPlayerAPI.addMethod(string, clazz, afterDisplayGUIBrewingStandHookTypes, "afterDisplayGUIBrewingStand", nfbs.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeDisplayGUIChestHookTypes, "beforeDisplayGUIChest", mssh.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideDisplayGUIChestHookTypes, "displayGUIChest", mssh.class);
        ClientPlayerAPI.addMethod(string, clazz, afterDisplayGUIChestHookTypes, "afterDisplayGUIChest", mssh.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeDisplayGUIDispenserHookTypes, "beforeDisplayGUIDispenser", jjzo.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideDisplayGUIDispenserHookTypes, "displayGUIDispenser", jjzo.class);
        ClientPlayerAPI.addMethod(string, clazz, afterDisplayGUIDispenserHookTypes, "afterDisplayGUIDispenser", jjzo.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeDisplayGUIEditSignHookTypes, "beforeDisplayGUIEditSign", hurg.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideDisplayGUIEditSignHookTypes, "displayGUIEditSign", hurg.class);
        ClientPlayerAPI.addMethod(string, clazz, afterDisplayGUIEditSignHookTypes, "afterDisplayGUIEditSign", hurg.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeDisplayGUIEnchantmentHookTypes, "beforeDisplayGUIEnchantment", Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideDisplayGUIEnchantmentHookTypes, "displayGUIEnchantment", Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class);
        ClientPlayerAPI.addMethod(string, clazz, afterDisplayGUIEnchantmentHookTypes, "afterDisplayGUIEnchantment", Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeDisplayGUIFurnaceHookTypes, "beforeDisplayGUIFurnace", nwgz.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideDisplayGUIFurnaceHookTypes, "displayGUIFurnace", nwgz.class);
        ClientPlayerAPI.addMethod(string, clazz, afterDisplayGUIFurnaceHookTypes, "afterDisplayGUIFurnace", nwgz.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeDisplayGUIWorkbenchHookTypes, "beforeDisplayGUIWorkbench", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideDisplayGUIWorkbenchHookTypes, "displayGUIWorkbench", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterDisplayGUIWorkbenchHookTypes, "afterDisplayGUIWorkbench", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeDropOneItemHookTypes, "beforeDropOneItem", Boolean.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideDropOneItemHookTypes, "dropOneItem", Boolean.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterDropOneItemHookTypes, "afterDropOneItem", Boolean.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeDropPlayerItemHookTypes, "beforeDropPlayerItem", cvzo.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideDropPlayerItemHookTypes, "dropPlayerItem", cvzo.class);
        ClientPlayerAPI.addMethod(string, clazz, afterDropPlayerItemHookTypes, "afterDropPlayerItem", cvzo.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeDropPlayerItemWithRandomChoiceHookTypes, "beforeDropPlayerItemWithRandomChoice", cvzo.class, Boolean.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideDropPlayerItemWithRandomChoiceHookTypes, "dropPlayerItemWithRandomChoice", cvzo.class, Boolean.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterDropPlayerItemWithRandomChoiceHookTypes, "afterDropPlayerItemWithRandomChoice", cvzo.class, Boolean.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeFallHookTypes, "beforeFall", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideFallHookTypes, "fall", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterFallHookTypes, "afterFall", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeGetBrightnessHookTypes, "beforeGetBrightness", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideGetBrightnessHookTypes, "getBrightness", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterGetBrightnessHookTypes, "afterGetBrightness", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeGetBrightnessForRenderHookTypes, "beforeGetBrightnessForRender", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideGetBrightnessForRenderHookTypes, "getBrightnessForRender", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterGetBrightnessForRenderHookTypes, "afterGetBrightnessForRender", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeGetCurrentPlayerStrVsBlockHookTypes, "beforeGetCurrentPlayerStrVsBlock", twgu.class, Boolean.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideGetCurrentPlayerStrVsBlockHookTypes, "getCurrentPlayerStrVsBlock", twgu.class, Boolean.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterGetCurrentPlayerStrVsBlockHookTypes, "afterGetCurrentPlayerStrVsBlock", twgu.class, Boolean.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeGetCurrentPlayerStrVsBlockForgeHookTypes, "beforeGetCurrentPlayerStrVsBlockForge", twgu.class, Boolean.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideGetCurrentPlayerStrVsBlockForgeHookTypes, "getCurrentPlayerStrVsBlockForge", twgu.class, Boolean.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterGetCurrentPlayerStrVsBlockForgeHookTypes, "afterGetCurrentPlayerStrVsBlockForge", twgu.class, Boolean.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeGetDistanceSqHookTypes, "beforeGetDistanceSq", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideGetDistanceSqHookTypes, "getDistanceSq", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterGetDistanceSqHookTypes, "afterGetDistanceSq", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeGetDistanceSqToEntityHookTypes, "beforeGetDistanceSqToEntity", Entity.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideGetDistanceSqToEntityHookTypes, "getDistanceSqToEntity", Entity.class);
        ClientPlayerAPI.addMethod(string, clazz, afterGetDistanceSqToEntityHookTypes, "afterGetDistanceSqToEntity", Entity.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeGetFOVMultiplierHookTypes, "beforeGetFOVMultiplier", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideGetFOVMultiplierHookTypes, "getFOVMultiplier", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterGetFOVMultiplierHookTypes, "afterGetFOVMultiplier", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeGetHurtSoundHookTypes, "beforeGetHurtSound", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideGetHurtSoundHookTypes, "getHurtSound", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterGetHurtSoundHookTypes, "afterGetHurtSound", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeGetItemIconHookTypes, "beforeGetItemIcon", cvzo.class, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideGetItemIconHookTypes, "getItemIcon", cvzo.class, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterGetItemIconHookTypes, "afterGetItemIcon", cvzo.class, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeGetSleepTimerHookTypes, "beforeGetSleepTimer", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideGetSleepTimerHookTypes, "getSleepTimer", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterGetSleepTimerHookTypes, "afterGetSleepTimer", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeHandleLavaMovementHookTypes, "beforeHandleLavaMovement", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideHandleLavaMovementHookTypes, "handleLavaMovement", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterHandleLavaMovementHookTypes, "afterHandleLavaMovement", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeHandleWaterMovementHookTypes, "beforeHandleWaterMovement", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideHandleWaterMovementHookTypes, "handleWaterMovement", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterHandleWaterMovementHookTypes, "afterHandleWaterMovement", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeHealHookTypes, "beforeHeal", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideHealHookTypes, "heal", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterHealHookTypes, "afterHeal", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeIsEntityInsideOpaqueBlockHookTypes, "beforeIsEntityInsideOpaqueBlock", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideIsEntityInsideOpaqueBlockHookTypes, "isEntityInsideOpaqueBlock", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterIsEntityInsideOpaqueBlockHookTypes, "afterIsEntityInsideOpaqueBlock", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeIsInWaterHookTypes, "beforeIsInWater", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideIsInWaterHookTypes, "isInWater", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterIsInWaterHookTypes, "afterIsInWater", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeIsInsideOfMaterialHookTypes, "beforeIsInsideOfMaterial", tflj.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideIsInsideOfMaterialHookTypes, "isInsideOfMaterial", tflj.class);
        ClientPlayerAPI.addMethod(string, clazz, afterIsInsideOfMaterialHookTypes, "afterIsInsideOfMaterial", tflj.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeIsOnLadderHookTypes, "beforeIsOnLadder", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideIsOnLadderHookTypes, "isOnLadder", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterIsOnLadderHookTypes, "afterIsOnLadder", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeIsPlayerSleepingHookTypes, "beforeIsPlayerSleeping", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideIsPlayerSleepingHookTypes, "isPlayerSleeping", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterIsPlayerSleepingHookTypes, "afterIsPlayerSleeping", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeIsSneakingHookTypes, "beforeIsSneaking", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideIsSneakingHookTypes, "isSneaking", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterIsSneakingHookTypes, "afterIsSneaking", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeIsSprintingHookTypes, "beforeIsSprinting", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideIsSprintingHookTypes, "isSprinting", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterIsSprintingHookTypes, "afterIsSprinting", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeJumpHookTypes, "beforeJump", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideJumpHookTypes, "jump", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterJumpHookTypes, "afterJump", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeKnockBackHookTypes, "beforeKnockBack", Entity.class, Float.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideKnockBackHookTypes, "knockBack", Entity.class, Float.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterKnockBackHookTypes, "afterKnockBack", Entity.class, Float.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeMoveEntityHookTypes, "beforeMoveEntity", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideMoveEntityHookTypes, "moveEntity", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterMoveEntityHookTypes, "afterMoveEntity", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeMoveEntityWithHeadingHookTypes, "beforeMoveEntityWithHeading", Float.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideMoveEntityWithHeadingHookTypes, "moveEntityWithHeading", Float.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterMoveEntityWithHeadingHookTypes, "afterMoveEntityWithHeading", Float.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeMoveFlyingHookTypes, "beforeMoveFlying", Float.TYPE, Float.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideMoveFlyingHookTypes, "moveFlying", Float.TYPE, Float.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterMoveFlyingHookTypes, "afterMoveFlying", Float.TYPE, Float.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeOnDeathHookTypes, "beforeOnDeath", jxtc.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideOnDeathHookTypes, "onDeath", jxtc.class);
        ClientPlayerAPI.addMethod(string, clazz, afterOnDeathHookTypes, "afterOnDeath", jxtc.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeOnLivingUpdateHookTypes, "beforeOnLivingUpdate", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideOnLivingUpdateHookTypes, "onLivingUpdate", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterOnLivingUpdateHookTypes, "afterOnLivingUpdate", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeOnKillEntityHookTypes, "beforeOnKillEntity", EntityLivingBase.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideOnKillEntityHookTypes, "onKillEntity", EntityLivingBase.class);
        ClientPlayerAPI.addMethod(string, clazz, afterOnKillEntityHookTypes, "afterOnKillEntity", EntityLivingBase.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeOnStruckByLightningHookTypes, "beforeOnStruckByLightning", EntityLightningBolt.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideOnStruckByLightningHookTypes, "onStruckByLightning", EntityLightningBolt.class);
        ClientPlayerAPI.addMethod(string, clazz, afterOnStruckByLightningHookTypes, "afterOnStruckByLightning", EntityLightningBolt.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeOnUpdateHookTypes, "beforeOnUpdate", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideOnUpdateHookTypes, "onUpdate", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterOnUpdateHookTypes, "afterOnUpdate", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforePlayStepSoundHookTypes, "beforePlayStepSound", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overridePlayStepSoundHookTypes, "playStepSound", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterPlayStepSoundHookTypes, "afterPlayStepSound", Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforePushOutOfBlocksHookTypes, "beforePushOutOfBlocks", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overridePushOutOfBlocksHookTypes, "pushOutOfBlocks", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterPushOutOfBlocksHookTypes, "afterPushOutOfBlocks", Double.TYPE, Double.TYPE, Double.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeRayTraceHookTypes, "beforeRayTrace", Double.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideRayTraceHookTypes, "rayTrace", Double.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterRayTraceHookTypes, "afterRayTrace", Double.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeReadEntityFromNBTHookTypes, "beforeReadEntityFromNBT", qoac.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideReadEntityFromNBTHookTypes, "readEntityFromNBT", qoac.class);
        ClientPlayerAPI.addMethod(string, clazz, afterReadEntityFromNBTHookTypes, "afterReadEntityFromNBT", qoac.class);
        ClientPlayerAPI.addMethod(string, clazz, beforeRespawnPlayerHookTypes, "beforeRespawnPlayer", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideRespawnPlayerHookTypes, "respawnPlayer", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterRespawnPlayerHookTypes, "afterRespawnPlayer", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeSetDeadHookTypes, "beforeSetDead", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideSetDeadHookTypes, "setDead", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterSetDeadHookTypes, "afterSetDead", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeSetPlayerSPHealthHookTypes, "beforeSetPlayerSPHealth", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideSetPlayerSPHealthHookTypes, "setPlayerSPHealth", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterSetPlayerSPHealthHookTypes, "afterSetPlayerSPHealth", Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeSetPositionAndRotationHookTypes, "beforeSetPositionAndRotation", Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideSetPositionAndRotationHookTypes, "setPositionAndRotation", Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterSetPositionAndRotationHookTypes, "afterSetPositionAndRotation", Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeSleepInBedAtHookTypes, "beforeSleepInBedAt", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, overrideSleepInBedAtHookTypes, "sleepInBedAt", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, afterSleepInBedAtHookTypes, "afterSleepInBedAt", Integer.TYPE, Integer.TYPE, Integer.TYPE);
        ClientPlayerAPI.addMethod(string, clazz, beforeSwingItemHookTypes, "beforeSwingItem", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideSwingItemHookTypes, "swingItem", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterSwingItemHookTypes, "afterSwingItem", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeUpdateEntityActionStateHookTypes, "beforeUpdateEntityActionState", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideUpdateEntityActionStateHookTypes, "updateEntityActionState", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterUpdateEntityActionStateHookTypes, "afterUpdateEntityActionState", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeUpdateRiddenHookTypes, "beforeUpdateRidden", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, overrideUpdateRiddenHookTypes, "updateRidden", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, afterUpdateRiddenHookTypes, "afterUpdateRidden", new Class[0]);
        ClientPlayerAPI.addMethod(string, clazz, beforeWriteEntityToNBTHookTypes, "beforeWriteEntityToNBT", qoac.class);
        ClientPlayerAPI.addMethod(string, clazz, overrideWriteEntityToNBTHookTypes, "writeEntityToNBT", qoac.class);
        ClientPlayerAPI.addMethod(string, clazz, afterWriteEntityToNBTHookTypes, "afterWriteEntityToNBT", qoac.class);
        ClientPlayerAPI.addDynamicMethods(string, clazz);
        ClientPlayerAPI.addDynamicKeys(string, clazz, beforeDynamicHookMethods, beforeDynamicHookTypes);
        ClientPlayerAPI.addDynamicKeys(string, clazz, overrideDynamicHookMethods, overrideDynamicHookTypes);
        ClientPlayerAPI.addDynamicKeys(string, clazz, afterDynamicHookMethods, afterDynamicHookTypes);
        ClientPlayerAPI.initialize();
        for (IClientPlayerAPI iClientPlayerAPI : ClientPlayerAPI.getAllInstancesList()) {
            iClientPlayerAPI.getClientPlayerAPI().attachClientPlayerBase(string);
        }
        System.out.println("Client Player: registered " + string);
        logger.fine("Client Player: registered class '" + clazz.getName() + "' with id '" + string + "'");
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
        for (IClientPlayerAPI object : ClientPlayerAPI.getAllInstancesList()) {
            object.getClientPlayerAPI().detachClientPlayerBase(string);
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
        allBaseBeforeAddMovementStatSuperiors.remove(string);
        allBaseBeforeAddMovementStatInferiors.remove(string);
        allBaseOverrideAddMovementStatSuperiors.remove(string);
        allBaseOverrideAddMovementStatInferiors.remove(string);
        allBaseAfterAddMovementStatSuperiors.remove(string);
        allBaseAfterAddMovementStatInferiors.remove(string);
        beforeAddMovementStatHookTypes.remove(string);
        overrideAddMovementStatHookTypes.remove(string);
        afterAddMovementStatHookTypes.remove(string);
        allBaseBeforeAddStatSuperiors.remove(string);
        allBaseBeforeAddStatInferiors.remove(string);
        allBaseOverrideAddStatSuperiors.remove(string);
        allBaseOverrideAddStatInferiors.remove(string);
        allBaseAfterAddStatSuperiors.remove(string);
        allBaseAfterAddStatInferiors.remove(string);
        beforeAddStatHookTypes.remove(string);
        overrideAddStatHookTypes.remove(string);
        afterAddStatHookTypes.remove(string);
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
        allBaseBeforeCanBreatheUnderwaterSuperiors.remove(string);
        allBaseBeforeCanBreatheUnderwaterInferiors.remove(string);
        allBaseOverrideCanBreatheUnderwaterSuperiors.remove(string);
        allBaseOverrideCanBreatheUnderwaterInferiors.remove(string);
        allBaseAfterCanBreatheUnderwaterSuperiors.remove(string);
        allBaseAfterCanBreatheUnderwaterInferiors.remove(string);
        beforeCanBreatheUnderwaterHookTypes.remove(string);
        overrideCanBreatheUnderwaterHookTypes.remove(string);
        afterCanBreatheUnderwaterHookTypes.remove(string);
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
        allBaseBeforeCloseScreenSuperiors.remove(string);
        allBaseBeforeCloseScreenInferiors.remove(string);
        allBaseOverrideCloseScreenSuperiors.remove(string);
        allBaseOverrideCloseScreenInferiors.remove(string);
        allBaseAfterCloseScreenSuperiors.remove(string);
        allBaseAfterCloseScreenInferiors.remove(string);
        beforeCloseScreenHookTypes.remove(string);
        overrideCloseScreenHookTypes.remove(string);
        afterCloseScreenHookTypes.remove(string);
        allBaseBeforeDamageEntitySuperiors.remove(string);
        allBaseBeforeDamageEntityInferiors.remove(string);
        allBaseOverrideDamageEntitySuperiors.remove(string);
        allBaseOverrideDamageEntityInferiors.remove(string);
        allBaseAfterDamageEntitySuperiors.remove(string);
        allBaseAfterDamageEntityInferiors.remove(string);
        beforeDamageEntityHookTypes.remove(string);
        overrideDamageEntityHookTypes.remove(string);
        afterDamageEntityHookTypes.remove(string);
        allBaseBeforeDisplayGUIBrewingStandSuperiors.remove(string);
        allBaseBeforeDisplayGUIBrewingStandInferiors.remove(string);
        allBaseOverrideDisplayGUIBrewingStandSuperiors.remove(string);
        allBaseOverrideDisplayGUIBrewingStandInferiors.remove(string);
        allBaseAfterDisplayGUIBrewingStandSuperiors.remove(string);
        allBaseAfterDisplayGUIBrewingStandInferiors.remove(string);
        beforeDisplayGUIBrewingStandHookTypes.remove(string);
        overrideDisplayGUIBrewingStandHookTypes.remove(string);
        afterDisplayGUIBrewingStandHookTypes.remove(string);
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
        allBaseBeforeDisplayGUIEditSignSuperiors.remove(string);
        allBaseBeforeDisplayGUIEditSignInferiors.remove(string);
        allBaseOverrideDisplayGUIEditSignSuperiors.remove(string);
        allBaseOverrideDisplayGUIEditSignInferiors.remove(string);
        allBaseAfterDisplayGUIEditSignSuperiors.remove(string);
        allBaseAfterDisplayGUIEditSignInferiors.remove(string);
        beforeDisplayGUIEditSignHookTypes.remove(string);
        overrideDisplayGUIEditSignHookTypes.remove(string);
        afterDisplayGUIEditSignHookTypes.remove(string);
        allBaseBeforeDisplayGUIEnchantmentSuperiors.remove(string);
        allBaseBeforeDisplayGUIEnchantmentInferiors.remove(string);
        allBaseOverrideDisplayGUIEnchantmentSuperiors.remove(string);
        allBaseOverrideDisplayGUIEnchantmentInferiors.remove(string);
        allBaseAfterDisplayGUIEnchantmentSuperiors.remove(string);
        allBaseAfterDisplayGUIEnchantmentInferiors.remove(string);
        beforeDisplayGUIEnchantmentHookTypes.remove(string);
        overrideDisplayGUIEnchantmentHookTypes.remove(string);
        afterDisplayGUIEnchantmentHookTypes.remove(string);
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
        allBaseBeforeDropPlayerItemWithRandomChoiceSuperiors.remove(string);
        allBaseBeforeDropPlayerItemWithRandomChoiceInferiors.remove(string);
        allBaseOverrideDropPlayerItemWithRandomChoiceSuperiors.remove(string);
        allBaseOverrideDropPlayerItemWithRandomChoiceInferiors.remove(string);
        allBaseAfterDropPlayerItemWithRandomChoiceSuperiors.remove(string);
        allBaseAfterDropPlayerItemWithRandomChoiceInferiors.remove(string);
        beforeDropPlayerItemWithRandomChoiceHookTypes.remove(string);
        overrideDropPlayerItemWithRandomChoiceHookTypes.remove(string);
        afterDropPlayerItemWithRandomChoiceHookTypes.remove(string);
        allBaseBeforeFallSuperiors.remove(string);
        allBaseBeforeFallInferiors.remove(string);
        allBaseOverrideFallSuperiors.remove(string);
        allBaseOverrideFallInferiors.remove(string);
        allBaseAfterFallSuperiors.remove(string);
        allBaseAfterFallInferiors.remove(string);
        beforeFallHookTypes.remove(string);
        overrideFallHookTypes.remove(string);
        afterFallHookTypes.remove(string);
        allBaseBeforeGetBrightnessSuperiors.remove(string);
        allBaseBeforeGetBrightnessInferiors.remove(string);
        allBaseOverrideGetBrightnessSuperiors.remove(string);
        allBaseOverrideGetBrightnessInferiors.remove(string);
        allBaseAfterGetBrightnessSuperiors.remove(string);
        allBaseAfterGetBrightnessInferiors.remove(string);
        beforeGetBrightnessHookTypes.remove(string);
        overrideGetBrightnessHookTypes.remove(string);
        afterGetBrightnessHookTypes.remove(string);
        allBaseBeforeGetBrightnessForRenderSuperiors.remove(string);
        allBaseBeforeGetBrightnessForRenderInferiors.remove(string);
        allBaseOverrideGetBrightnessForRenderSuperiors.remove(string);
        allBaseOverrideGetBrightnessForRenderInferiors.remove(string);
        allBaseAfterGetBrightnessForRenderSuperiors.remove(string);
        allBaseAfterGetBrightnessForRenderInferiors.remove(string);
        beforeGetBrightnessForRenderHookTypes.remove(string);
        overrideGetBrightnessForRenderHookTypes.remove(string);
        afterGetBrightnessForRenderHookTypes.remove(string);
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
        allBaseBeforeGetDistanceSqToEntitySuperiors.remove(string);
        allBaseBeforeGetDistanceSqToEntityInferiors.remove(string);
        allBaseOverrideGetDistanceSqToEntitySuperiors.remove(string);
        allBaseOverrideGetDistanceSqToEntityInferiors.remove(string);
        allBaseAfterGetDistanceSqToEntitySuperiors.remove(string);
        allBaseAfterGetDistanceSqToEntityInferiors.remove(string);
        beforeGetDistanceSqToEntityHookTypes.remove(string);
        overrideGetDistanceSqToEntityHookTypes.remove(string);
        afterGetDistanceSqToEntityHookTypes.remove(string);
        allBaseBeforeGetFOVMultiplierSuperiors.remove(string);
        allBaseBeforeGetFOVMultiplierInferiors.remove(string);
        allBaseOverrideGetFOVMultiplierSuperiors.remove(string);
        allBaseOverrideGetFOVMultiplierInferiors.remove(string);
        allBaseAfterGetFOVMultiplierSuperiors.remove(string);
        allBaseAfterGetFOVMultiplierInferiors.remove(string);
        beforeGetFOVMultiplierHookTypes.remove(string);
        overrideGetFOVMultiplierHookTypes.remove(string);
        afterGetFOVMultiplierHookTypes.remove(string);
        allBaseBeforeGetHurtSoundSuperiors.remove(string);
        allBaseBeforeGetHurtSoundInferiors.remove(string);
        allBaseOverrideGetHurtSoundSuperiors.remove(string);
        allBaseOverrideGetHurtSoundInferiors.remove(string);
        allBaseAfterGetHurtSoundSuperiors.remove(string);
        allBaseAfterGetHurtSoundInferiors.remove(string);
        beforeGetHurtSoundHookTypes.remove(string);
        overrideGetHurtSoundHookTypes.remove(string);
        afterGetHurtSoundHookTypes.remove(string);
        allBaseBeforeGetItemIconSuperiors.remove(string);
        allBaseBeforeGetItemIconInferiors.remove(string);
        allBaseOverrideGetItemIconSuperiors.remove(string);
        allBaseOverrideGetItemIconInferiors.remove(string);
        allBaseAfterGetItemIconSuperiors.remove(string);
        allBaseAfterGetItemIconInferiors.remove(string);
        beforeGetItemIconHookTypes.remove(string);
        overrideGetItemIconHookTypes.remove(string);
        afterGetItemIconHookTypes.remove(string);
        allBaseBeforeGetSleepTimerSuperiors.remove(string);
        allBaseBeforeGetSleepTimerInferiors.remove(string);
        allBaseOverrideGetSleepTimerSuperiors.remove(string);
        allBaseOverrideGetSleepTimerInferiors.remove(string);
        allBaseAfterGetSleepTimerSuperiors.remove(string);
        allBaseAfterGetSleepTimerInferiors.remove(string);
        beforeGetSleepTimerHookTypes.remove(string);
        overrideGetSleepTimerHookTypes.remove(string);
        afterGetSleepTimerHookTypes.remove(string);
        allBaseBeforeHandleLavaMovementSuperiors.remove(string);
        allBaseBeforeHandleLavaMovementInferiors.remove(string);
        allBaseOverrideHandleLavaMovementSuperiors.remove(string);
        allBaseOverrideHandleLavaMovementInferiors.remove(string);
        allBaseAfterHandleLavaMovementSuperiors.remove(string);
        allBaseAfterHandleLavaMovementInferiors.remove(string);
        beforeHandleLavaMovementHookTypes.remove(string);
        overrideHandleLavaMovementHookTypes.remove(string);
        afterHandleLavaMovementHookTypes.remove(string);
        allBaseBeforeHandleWaterMovementSuperiors.remove(string);
        allBaseBeforeHandleWaterMovementInferiors.remove(string);
        allBaseOverrideHandleWaterMovementSuperiors.remove(string);
        allBaseOverrideHandleWaterMovementInferiors.remove(string);
        allBaseAfterHandleWaterMovementSuperiors.remove(string);
        allBaseAfterHandleWaterMovementInferiors.remove(string);
        beforeHandleWaterMovementHookTypes.remove(string);
        overrideHandleWaterMovementHookTypes.remove(string);
        afterHandleWaterMovementHookTypes.remove(string);
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
        allBaseBeforeIsSneakingSuperiors.remove(string);
        allBaseBeforeIsSneakingInferiors.remove(string);
        allBaseOverrideIsSneakingSuperiors.remove(string);
        allBaseOverrideIsSneakingInferiors.remove(string);
        allBaseAfterIsSneakingSuperiors.remove(string);
        allBaseAfterIsSneakingInferiors.remove(string);
        beforeIsSneakingHookTypes.remove(string);
        overrideIsSneakingHookTypes.remove(string);
        afterIsSneakingHookTypes.remove(string);
        allBaseBeforeIsSprintingSuperiors.remove(string);
        allBaseBeforeIsSprintingInferiors.remove(string);
        allBaseOverrideIsSprintingSuperiors.remove(string);
        allBaseOverrideIsSprintingInferiors.remove(string);
        allBaseAfterIsSprintingSuperiors.remove(string);
        allBaseAfterIsSprintingInferiors.remove(string);
        beforeIsSprintingHookTypes.remove(string);
        overrideIsSprintingHookTypes.remove(string);
        afterIsSprintingHookTypes.remove(string);
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
        allBaseBeforePlayStepSoundSuperiors.remove(string);
        allBaseBeforePlayStepSoundInferiors.remove(string);
        allBaseOverridePlayStepSoundSuperiors.remove(string);
        allBaseOverridePlayStepSoundInferiors.remove(string);
        allBaseAfterPlayStepSoundSuperiors.remove(string);
        allBaseAfterPlayStepSoundInferiors.remove(string);
        beforePlayStepSoundHookTypes.remove(string);
        overridePlayStepSoundHookTypes.remove(string);
        afterPlayStepSoundHookTypes.remove(string);
        allBaseBeforePushOutOfBlocksSuperiors.remove(string);
        allBaseBeforePushOutOfBlocksInferiors.remove(string);
        allBaseOverridePushOutOfBlocksSuperiors.remove(string);
        allBaseOverridePushOutOfBlocksInferiors.remove(string);
        allBaseAfterPushOutOfBlocksSuperiors.remove(string);
        allBaseAfterPushOutOfBlocksInferiors.remove(string);
        beforePushOutOfBlocksHookTypes.remove(string);
        overridePushOutOfBlocksHookTypes.remove(string);
        afterPushOutOfBlocksHookTypes.remove(string);
        allBaseBeforeRayTraceSuperiors.remove(string);
        allBaseBeforeRayTraceInferiors.remove(string);
        allBaseOverrideRayTraceSuperiors.remove(string);
        allBaseOverrideRayTraceInferiors.remove(string);
        allBaseAfterRayTraceSuperiors.remove(string);
        allBaseAfterRayTraceInferiors.remove(string);
        beforeRayTraceHookTypes.remove(string);
        overrideRayTraceHookTypes.remove(string);
        afterRayTraceHookTypes.remove(string);
        allBaseBeforeReadEntityFromNBTSuperiors.remove(string);
        allBaseBeforeReadEntityFromNBTInferiors.remove(string);
        allBaseOverrideReadEntityFromNBTSuperiors.remove(string);
        allBaseOverrideReadEntityFromNBTInferiors.remove(string);
        allBaseAfterReadEntityFromNBTSuperiors.remove(string);
        allBaseAfterReadEntityFromNBTInferiors.remove(string);
        beforeReadEntityFromNBTHookTypes.remove(string);
        overrideReadEntityFromNBTHookTypes.remove(string);
        afterReadEntityFromNBTHookTypes.remove(string);
        allBaseBeforeRespawnPlayerSuperiors.remove(string);
        allBaseBeforeRespawnPlayerInferiors.remove(string);
        allBaseOverrideRespawnPlayerSuperiors.remove(string);
        allBaseOverrideRespawnPlayerInferiors.remove(string);
        allBaseAfterRespawnPlayerSuperiors.remove(string);
        allBaseAfterRespawnPlayerInferiors.remove(string);
        beforeRespawnPlayerHookTypes.remove(string);
        overrideRespawnPlayerHookTypes.remove(string);
        afterRespawnPlayerHookTypes.remove(string);
        allBaseBeforeSetDeadSuperiors.remove(string);
        allBaseBeforeSetDeadInferiors.remove(string);
        allBaseOverrideSetDeadSuperiors.remove(string);
        allBaseOverrideSetDeadInferiors.remove(string);
        allBaseAfterSetDeadSuperiors.remove(string);
        allBaseAfterSetDeadInferiors.remove(string);
        beforeSetDeadHookTypes.remove(string);
        overrideSetDeadHookTypes.remove(string);
        afterSetDeadHookTypes.remove(string);
        allBaseBeforeSetPlayerSPHealthSuperiors.remove(string);
        allBaseBeforeSetPlayerSPHealthInferiors.remove(string);
        allBaseOverrideSetPlayerSPHealthSuperiors.remove(string);
        allBaseOverrideSetPlayerSPHealthInferiors.remove(string);
        allBaseAfterSetPlayerSPHealthSuperiors.remove(string);
        allBaseAfterSetPlayerSPHealthInferiors.remove(string);
        beforeSetPlayerSPHealthHookTypes.remove(string);
        overrideSetPlayerSPHealthHookTypes.remove(string);
        afterSetPlayerSPHealthHookTypes.remove(string);
        allBaseBeforeSetPositionAndRotationSuperiors.remove(string);
        allBaseBeforeSetPositionAndRotationInferiors.remove(string);
        allBaseOverrideSetPositionAndRotationSuperiors.remove(string);
        allBaseOverrideSetPositionAndRotationInferiors.remove(string);
        allBaseAfterSetPositionAndRotationSuperiors.remove(string);
        allBaseAfterSetPositionAndRotationInferiors.remove(string);
        beforeSetPositionAndRotationHookTypes.remove(string);
        overrideSetPositionAndRotationHookTypes.remove(string);
        afterSetPositionAndRotationHookTypes.remove(string);
        allBaseBeforeSleepInBedAtSuperiors.remove(string);
        allBaseBeforeSleepInBedAtInferiors.remove(string);
        allBaseOverrideSleepInBedAtSuperiors.remove(string);
        allBaseOverrideSleepInBedAtInferiors.remove(string);
        allBaseAfterSleepInBedAtSuperiors.remove(string);
        allBaseAfterSleepInBedAtInferiors.remove(string);
        beforeSleepInBedAtHookTypes.remove(string);
        overrideSleepInBedAtHookTypes.remove(string);
        afterSleepInBedAtHookTypes.remove(string);
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
        allBaseBeforeUpdateRiddenSuperiors.remove(string);
        allBaseBeforeUpdateRiddenInferiors.remove(string);
        allBaseOverrideUpdateRiddenSuperiors.remove(string);
        allBaseOverrideUpdateRiddenInferiors.remove(string);
        allBaseAfterUpdateRiddenSuperiors.remove(string);
        allBaseAfterUpdateRiddenInferiors.remove(string);
        beforeUpdateRiddenHookTypes.remove(string);
        overrideUpdateRiddenHookTypes.remove(string);
        afterUpdateRiddenHookTypes.remove(string);
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
        ClientPlayerAPI.removeDynamicHookTypes(string, beforeDynamicHookTypes);
        ClientPlayerAPI.removeDynamicHookTypes(string, overrideDynamicHookTypes);
        ClientPlayerAPI.removeDynamicHookTypes(string, afterDynamicHookTypes);
        allBaseBeforeDynamicSuperiors.remove(string);
        allBaseBeforeDynamicInferiors.remove(string);
        allBaseOverrideDynamicSuperiors.remove(string);
        allBaseOverrideDynamicInferiors.remove(string);
        allBaseAfterDynamicSuperiors.remove(string);
        allBaseAfterDynamicInferiors.remove(string);
        ClientPlayerAPI.log("ClientPlayerAPI: unregistered id '" + string + "'");
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
            boolean bl2 = bl = method.getDeclaringClass() != ClientPlayerBase.class;
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
                map = ClientPlayerAPI.addDynamicMethod(string2, method, map);
                continue;
            }
            if (bl) {
                map2 = ClientPlayerAPI.addDynamicMethod(string2, method, map2);
                continue;
            }
            if (bl4) {
                map4 = ClientPlayerAPI.addDynamicMethod(string2, method, map4);
                continue;
            }
            map3 = ClientPlayerAPI.addDynamicMethod(string2, method, map3);
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

    public static ClientPlayerAPI create(IClientPlayerAPI iClientPlayerAPI) {
        if (allBaseConstructors.size() > 0 && !initialized) {
            ClientPlayerAPI.initialize();
        }
        return new ClientPlayerAPI(iClientPlayerAPI);
    }

    private static void initialize() {
        ClientPlayerAPI.sortBases(beforeLocalConstructingHookTypes, allBaseBeforeLocalConstructingSuperiors, allBaseBeforeLocalConstructingInferiors, "beforeLocalConstructing");
        ClientPlayerAPI.sortBases(afterLocalConstructingHookTypes, allBaseAfterLocalConstructingSuperiors, allBaseAfterLocalConstructingInferiors, "afterLocalConstructing");
        for (String string : keys) {
            ClientPlayerAPI.sortDynamicBases(beforeDynamicHookTypes, allBaseBeforeDynamicSuperiors, allBaseBeforeDynamicInferiors, string);
            ClientPlayerAPI.sortDynamicBases(overrideDynamicHookTypes, allBaseOverrideDynamicSuperiors, allBaseOverrideDynamicInferiors, string);
            ClientPlayerAPI.sortDynamicBases(afterDynamicHookTypes, allBaseAfterDynamicSuperiors, allBaseAfterDynamicInferiors, string);
        }
        ClientPlayerAPI.sortBases(beforeAddExhaustionHookTypes, allBaseBeforeAddExhaustionSuperiors, allBaseBeforeAddExhaustionInferiors, "beforeAddExhaustion");
        ClientPlayerAPI.sortBases(overrideAddExhaustionHookTypes, allBaseOverrideAddExhaustionSuperiors, allBaseOverrideAddExhaustionInferiors, "overrideAddExhaustion");
        ClientPlayerAPI.sortBases(afterAddExhaustionHookTypes, allBaseAfterAddExhaustionSuperiors, allBaseAfterAddExhaustionInferiors, "afterAddExhaustion");
        ClientPlayerAPI.sortBases(beforeAddMovementStatHookTypes, allBaseBeforeAddMovementStatSuperiors, allBaseBeforeAddMovementStatInferiors, "beforeAddMovementStat");
        ClientPlayerAPI.sortBases(overrideAddMovementStatHookTypes, allBaseOverrideAddMovementStatSuperiors, allBaseOverrideAddMovementStatInferiors, "overrideAddMovementStat");
        ClientPlayerAPI.sortBases(afterAddMovementStatHookTypes, allBaseAfterAddMovementStatSuperiors, allBaseAfterAddMovementStatInferiors, "afterAddMovementStat");
        ClientPlayerAPI.sortBases(beforeAddStatHookTypes, allBaseBeforeAddStatSuperiors, allBaseBeforeAddStatInferiors, "beforeAddStat");
        ClientPlayerAPI.sortBases(overrideAddStatHookTypes, allBaseOverrideAddStatSuperiors, allBaseOverrideAddStatInferiors, "overrideAddStat");
        ClientPlayerAPI.sortBases(afterAddStatHookTypes, allBaseAfterAddStatSuperiors, allBaseAfterAddStatInferiors, "afterAddStat");
        ClientPlayerAPI.sortBases(beforeAttackEntityFromHookTypes, allBaseBeforeAttackEntityFromSuperiors, allBaseBeforeAttackEntityFromInferiors, "beforeAttackEntityFrom");
        ClientPlayerAPI.sortBases(overrideAttackEntityFromHookTypes, allBaseOverrideAttackEntityFromSuperiors, allBaseOverrideAttackEntityFromInferiors, "overrideAttackEntityFrom");
        ClientPlayerAPI.sortBases(afterAttackEntityFromHookTypes, allBaseAfterAttackEntityFromSuperiors, allBaseAfterAttackEntityFromInferiors, "afterAttackEntityFrom");
        ClientPlayerAPI.sortBases(beforeAttackTargetEntityWithCurrentItemHookTypes, allBaseBeforeAttackTargetEntityWithCurrentItemSuperiors, allBaseBeforeAttackTargetEntityWithCurrentItemInferiors, "beforeAttackTargetEntityWithCurrentItem");
        ClientPlayerAPI.sortBases(overrideAttackTargetEntityWithCurrentItemHookTypes, allBaseOverrideAttackTargetEntityWithCurrentItemSuperiors, allBaseOverrideAttackTargetEntityWithCurrentItemInferiors, "overrideAttackTargetEntityWithCurrentItem");
        ClientPlayerAPI.sortBases(afterAttackTargetEntityWithCurrentItemHookTypes, allBaseAfterAttackTargetEntityWithCurrentItemSuperiors, allBaseAfterAttackTargetEntityWithCurrentItemInferiors, "afterAttackTargetEntityWithCurrentItem");
        ClientPlayerAPI.sortBases(beforeCanBreatheUnderwaterHookTypes, allBaseBeforeCanBreatheUnderwaterSuperiors, allBaseBeforeCanBreatheUnderwaterInferiors, "beforeCanBreatheUnderwater");
        ClientPlayerAPI.sortBases(overrideCanBreatheUnderwaterHookTypes, allBaseOverrideCanBreatheUnderwaterSuperiors, allBaseOverrideCanBreatheUnderwaterInferiors, "overrideCanBreatheUnderwater");
        ClientPlayerAPI.sortBases(afterCanBreatheUnderwaterHookTypes, allBaseAfterCanBreatheUnderwaterSuperiors, allBaseAfterCanBreatheUnderwaterInferiors, "afterCanBreatheUnderwater");
        ClientPlayerAPI.sortBases(beforeCanHarvestBlockHookTypes, allBaseBeforeCanHarvestBlockSuperiors, allBaseBeforeCanHarvestBlockInferiors, "beforeCanHarvestBlock");
        ClientPlayerAPI.sortBases(overrideCanHarvestBlockHookTypes, allBaseOverrideCanHarvestBlockSuperiors, allBaseOverrideCanHarvestBlockInferiors, "overrideCanHarvestBlock");
        ClientPlayerAPI.sortBases(afterCanHarvestBlockHookTypes, allBaseAfterCanHarvestBlockSuperiors, allBaseAfterCanHarvestBlockInferiors, "afterCanHarvestBlock");
        ClientPlayerAPI.sortBases(beforeCanPlayerEditHookTypes, allBaseBeforeCanPlayerEditSuperiors, allBaseBeforeCanPlayerEditInferiors, "beforeCanPlayerEdit");
        ClientPlayerAPI.sortBases(overrideCanPlayerEditHookTypes, allBaseOverrideCanPlayerEditSuperiors, allBaseOverrideCanPlayerEditInferiors, "overrideCanPlayerEdit");
        ClientPlayerAPI.sortBases(afterCanPlayerEditHookTypes, allBaseAfterCanPlayerEditSuperiors, allBaseAfterCanPlayerEditInferiors, "afterCanPlayerEdit");
        ClientPlayerAPI.sortBases(beforeCanTriggerWalkingHookTypes, allBaseBeforeCanTriggerWalkingSuperiors, allBaseBeforeCanTriggerWalkingInferiors, "beforeCanTriggerWalking");
        ClientPlayerAPI.sortBases(overrideCanTriggerWalkingHookTypes, allBaseOverrideCanTriggerWalkingSuperiors, allBaseOverrideCanTriggerWalkingInferiors, "overrideCanTriggerWalking");
        ClientPlayerAPI.sortBases(afterCanTriggerWalkingHookTypes, allBaseAfterCanTriggerWalkingSuperiors, allBaseAfterCanTriggerWalkingInferiors, "afterCanTriggerWalking");
        ClientPlayerAPI.sortBases(beforeCloseScreenHookTypes, allBaseBeforeCloseScreenSuperiors, allBaseBeforeCloseScreenInferiors, "beforeCloseScreen");
        ClientPlayerAPI.sortBases(overrideCloseScreenHookTypes, allBaseOverrideCloseScreenSuperiors, allBaseOverrideCloseScreenInferiors, "overrideCloseScreen");
        ClientPlayerAPI.sortBases(afterCloseScreenHookTypes, allBaseAfterCloseScreenSuperiors, allBaseAfterCloseScreenInferiors, "afterCloseScreen");
        ClientPlayerAPI.sortBases(beforeDamageEntityHookTypes, allBaseBeforeDamageEntitySuperiors, allBaseBeforeDamageEntityInferiors, "beforeDamageEntity");
        ClientPlayerAPI.sortBases(overrideDamageEntityHookTypes, allBaseOverrideDamageEntitySuperiors, allBaseOverrideDamageEntityInferiors, "overrideDamageEntity");
        ClientPlayerAPI.sortBases(afterDamageEntityHookTypes, allBaseAfterDamageEntitySuperiors, allBaseAfterDamageEntityInferiors, "afterDamageEntity");
        ClientPlayerAPI.sortBases(beforeDisplayGUIBrewingStandHookTypes, allBaseBeforeDisplayGUIBrewingStandSuperiors, allBaseBeforeDisplayGUIBrewingStandInferiors, "beforeDisplayGUIBrewingStand");
        ClientPlayerAPI.sortBases(overrideDisplayGUIBrewingStandHookTypes, allBaseOverrideDisplayGUIBrewingStandSuperiors, allBaseOverrideDisplayGUIBrewingStandInferiors, "overrideDisplayGUIBrewingStand");
        ClientPlayerAPI.sortBases(afterDisplayGUIBrewingStandHookTypes, allBaseAfterDisplayGUIBrewingStandSuperiors, allBaseAfterDisplayGUIBrewingStandInferiors, "afterDisplayGUIBrewingStand");
        ClientPlayerAPI.sortBases(beforeDisplayGUIChestHookTypes, allBaseBeforeDisplayGUIChestSuperiors, allBaseBeforeDisplayGUIChestInferiors, "beforeDisplayGUIChest");
        ClientPlayerAPI.sortBases(overrideDisplayGUIChestHookTypes, allBaseOverrideDisplayGUIChestSuperiors, allBaseOverrideDisplayGUIChestInferiors, "overrideDisplayGUIChest");
        ClientPlayerAPI.sortBases(afterDisplayGUIChestHookTypes, allBaseAfterDisplayGUIChestSuperiors, allBaseAfterDisplayGUIChestInferiors, "afterDisplayGUIChest");
        ClientPlayerAPI.sortBases(beforeDisplayGUIDispenserHookTypes, allBaseBeforeDisplayGUIDispenserSuperiors, allBaseBeforeDisplayGUIDispenserInferiors, "beforeDisplayGUIDispenser");
        ClientPlayerAPI.sortBases(overrideDisplayGUIDispenserHookTypes, allBaseOverrideDisplayGUIDispenserSuperiors, allBaseOverrideDisplayGUIDispenserInferiors, "overrideDisplayGUIDispenser");
        ClientPlayerAPI.sortBases(afterDisplayGUIDispenserHookTypes, allBaseAfterDisplayGUIDispenserSuperiors, allBaseAfterDisplayGUIDispenserInferiors, "afterDisplayGUIDispenser");
        ClientPlayerAPI.sortBases(beforeDisplayGUIEditSignHookTypes, allBaseBeforeDisplayGUIEditSignSuperiors, allBaseBeforeDisplayGUIEditSignInferiors, "beforeDisplayGUIEditSign");
        ClientPlayerAPI.sortBases(overrideDisplayGUIEditSignHookTypes, allBaseOverrideDisplayGUIEditSignSuperiors, allBaseOverrideDisplayGUIEditSignInferiors, "overrideDisplayGUIEditSign");
        ClientPlayerAPI.sortBases(afterDisplayGUIEditSignHookTypes, allBaseAfterDisplayGUIEditSignSuperiors, allBaseAfterDisplayGUIEditSignInferiors, "afterDisplayGUIEditSign");
        ClientPlayerAPI.sortBases(beforeDisplayGUIEnchantmentHookTypes, allBaseBeforeDisplayGUIEnchantmentSuperiors, allBaseBeforeDisplayGUIEnchantmentInferiors, "beforeDisplayGUIEnchantment");
        ClientPlayerAPI.sortBases(overrideDisplayGUIEnchantmentHookTypes, allBaseOverrideDisplayGUIEnchantmentSuperiors, allBaseOverrideDisplayGUIEnchantmentInferiors, "overrideDisplayGUIEnchantment");
        ClientPlayerAPI.sortBases(afterDisplayGUIEnchantmentHookTypes, allBaseAfterDisplayGUIEnchantmentSuperiors, allBaseAfterDisplayGUIEnchantmentInferiors, "afterDisplayGUIEnchantment");
        ClientPlayerAPI.sortBases(beforeDisplayGUIFurnaceHookTypes, allBaseBeforeDisplayGUIFurnaceSuperiors, allBaseBeforeDisplayGUIFurnaceInferiors, "beforeDisplayGUIFurnace");
        ClientPlayerAPI.sortBases(overrideDisplayGUIFurnaceHookTypes, allBaseOverrideDisplayGUIFurnaceSuperiors, allBaseOverrideDisplayGUIFurnaceInferiors, "overrideDisplayGUIFurnace");
        ClientPlayerAPI.sortBases(afterDisplayGUIFurnaceHookTypes, allBaseAfterDisplayGUIFurnaceSuperiors, allBaseAfterDisplayGUIFurnaceInferiors, "afterDisplayGUIFurnace");
        ClientPlayerAPI.sortBases(beforeDisplayGUIWorkbenchHookTypes, allBaseBeforeDisplayGUIWorkbenchSuperiors, allBaseBeforeDisplayGUIWorkbenchInferiors, "beforeDisplayGUIWorkbench");
        ClientPlayerAPI.sortBases(overrideDisplayGUIWorkbenchHookTypes, allBaseOverrideDisplayGUIWorkbenchSuperiors, allBaseOverrideDisplayGUIWorkbenchInferiors, "overrideDisplayGUIWorkbench");
        ClientPlayerAPI.sortBases(afterDisplayGUIWorkbenchHookTypes, allBaseAfterDisplayGUIWorkbenchSuperiors, allBaseAfterDisplayGUIWorkbenchInferiors, "afterDisplayGUIWorkbench");
        ClientPlayerAPI.sortBases(beforeDropOneItemHookTypes, allBaseBeforeDropOneItemSuperiors, allBaseBeforeDropOneItemInferiors, "beforeDropOneItem");
        ClientPlayerAPI.sortBases(overrideDropOneItemHookTypes, allBaseOverrideDropOneItemSuperiors, allBaseOverrideDropOneItemInferiors, "overrideDropOneItem");
        ClientPlayerAPI.sortBases(afterDropOneItemHookTypes, allBaseAfterDropOneItemSuperiors, allBaseAfterDropOneItemInferiors, "afterDropOneItem");
        ClientPlayerAPI.sortBases(beforeDropPlayerItemHookTypes, allBaseBeforeDropPlayerItemSuperiors, allBaseBeforeDropPlayerItemInferiors, "beforeDropPlayerItem");
        ClientPlayerAPI.sortBases(overrideDropPlayerItemHookTypes, allBaseOverrideDropPlayerItemSuperiors, allBaseOverrideDropPlayerItemInferiors, "overrideDropPlayerItem");
        ClientPlayerAPI.sortBases(afterDropPlayerItemHookTypes, allBaseAfterDropPlayerItemSuperiors, allBaseAfterDropPlayerItemInferiors, "afterDropPlayerItem");
        ClientPlayerAPI.sortBases(beforeDropPlayerItemWithRandomChoiceHookTypes, allBaseBeforeDropPlayerItemWithRandomChoiceSuperiors, allBaseBeforeDropPlayerItemWithRandomChoiceInferiors, "beforeDropPlayerItemWithRandomChoice");
        ClientPlayerAPI.sortBases(overrideDropPlayerItemWithRandomChoiceHookTypes, allBaseOverrideDropPlayerItemWithRandomChoiceSuperiors, allBaseOverrideDropPlayerItemWithRandomChoiceInferiors, "overrideDropPlayerItemWithRandomChoice");
        ClientPlayerAPI.sortBases(afterDropPlayerItemWithRandomChoiceHookTypes, allBaseAfterDropPlayerItemWithRandomChoiceSuperiors, allBaseAfterDropPlayerItemWithRandomChoiceInferiors, "afterDropPlayerItemWithRandomChoice");
        ClientPlayerAPI.sortBases(beforeFallHookTypes, allBaseBeforeFallSuperiors, allBaseBeforeFallInferiors, "beforeFall");
        ClientPlayerAPI.sortBases(overrideFallHookTypes, allBaseOverrideFallSuperiors, allBaseOverrideFallInferiors, "overrideFall");
        ClientPlayerAPI.sortBases(afterFallHookTypes, allBaseAfterFallSuperiors, allBaseAfterFallInferiors, "afterFall");
        ClientPlayerAPI.sortBases(beforeGetBrightnessHookTypes, allBaseBeforeGetBrightnessSuperiors, allBaseBeforeGetBrightnessInferiors, "beforeGetBrightness");
        ClientPlayerAPI.sortBases(overrideGetBrightnessHookTypes, allBaseOverrideGetBrightnessSuperiors, allBaseOverrideGetBrightnessInferiors, "overrideGetBrightness");
        ClientPlayerAPI.sortBases(afterGetBrightnessHookTypes, allBaseAfterGetBrightnessSuperiors, allBaseAfterGetBrightnessInferiors, "afterGetBrightness");
        ClientPlayerAPI.sortBases(beforeGetBrightnessForRenderHookTypes, allBaseBeforeGetBrightnessForRenderSuperiors, allBaseBeforeGetBrightnessForRenderInferiors, "beforeGetBrightnessForRender");
        ClientPlayerAPI.sortBases(overrideGetBrightnessForRenderHookTypes, allBaseOverrideGetBrightnessForRenderSuperiors, allBaseOverrideGetBrightnessForRenderInferiors, "overrideGetBrightnessForRender");
        ClientPlayerAPI.sortBases(afterGetBrightnessForRenderHookTypes, allBaseAfterGetBrightnessForRenderSuperiors, allBaseAfterGetBrightnessForRenderInferiors, "afterGetBrightnessForRender");
        ClientPlayerAPI.sortBases(beforeGetCurrentPlayerStrVsBlockHookTypes, allBaseBeforeGetCurrentPlayerStrVsBlockSuperiors, allBaseBeforeGetCurrentPlayerStrVsBlockInferiors, "beforeGetCurrentPlayerStrVsBlock");
        ClientPlayerAPI.sortBases(overrideGetCurrentPlayerStrVsBlockHookTypes, allBaseOverrideGetCurrentPlayerStrVsBlockSuperiors, allBaseOverrideGetCurrentPlayerStrVsBlockInferiors, "overrideGetCurrentPlayerStrVsBlock");
        ClientPlayerAPI.sortBases(afterGetCurrentPlayerStrVsBlockHookTypes, allBaseAfterGetCurrentPlayerStrVsBlockSuperiors, allBaseAfterGetCurrentPlayerStrVsBlockInferiors, "afterGetCurrentPlayerStrVsBlock");
        ClientPlayerAPI.sortBases(beforeGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseBeforeGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseBeforeGetCurrentPlayerStrVsBlockForgeInferiors, "beforeGetCurrentPlayerStrVsBlockForge");
        ClientPlayerAPI.sortBases(overrideGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseOverrideGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseOverrideGetCurrentPlayerStrVsBlockForgeInferiors, "overrideGetCurrentPlayerStrVsBlockForge");
        ClientPlayerAPI.sortBases(afterGetCurrentPlayerStrVsBlockForgeHookTypes, allBaseAfterGetCurrentPlayerStrVsBlockForgeSuperiors, allBaseAfterGetCurrentPlayerStrVsBlockForgeInferiors, "afterGetCurrentPlayerStrVsBlockForge");
        ClientPlayerAPI.sortBases(beforeGetDistanceSqHookTypes, allBaseBeforeGetDistanceSqSuperiors, allBaseBeforeGetDistanceSqInferiors, "beforeGetDistanceSq");
        ClientPlayerAPI.sortBases(overrideGetDistanceSqHookTypes, allBaseOverrideGetDistanceSqSuperiors, allBaseOverrideGetDistanceSqInferiors, "overrideGetDistanceSq");
        ClientPlayerAPI.sortBases(afterGetDistanceSqHookTypes, allBaseAfterGetDistanceSqSuperiors, allBaseAfterGetDistanceSqInferiors, "afterGetDistanceSq");
        ClientPlayerAPI.sortBases(beforeGetDistanceSqToEntityHookTypes, allBaseBeforeGetDistanceSqToEntitySuperiors, allBaseBeforeGetDistanceSqToEntityInferiors, "beforeGetDistanceSqToEntity");
        ClientPlayerAPI.sortBases(overrideGetDistanceSqToEntityHookTypes, allBaseOverrideGetDistanceSqToEntitySuperiors, allBaseOverrideGetDistanceSqToEntityInferiors, "overrideGetDistanceSqToEntity");
        ClientPlayerAPI.sortBases(afterGetDistanceSqToEntityHookTypes, allBaseAfterGetDistanceSqToEntitySuperiors, allBaseAfterGetDistanceSqToEntityInferiors, "afterGetDistanceSqToEntity");
        ClientPlayerAPI.sortBases(beforeGetFOVMultiplierHookTypes, allBaseBeforeGetFOVMultiplierSuperiors, allBaseBeforeGetFOVMultiplierInferiors, "beforeGetFOVMultiplier");
        ClientPlayerAPI.sortBases(overrideGetFOVMultiplierHookTypes, allBaseOverrideGetFOVMultiplierSuperiors, allBaseOverrideGetFOVMultiplierInferiors, "overrideGetFOVMultiplier");
        ClientPlayerAPI.sortBases(afterGetFOVMultiplierHookTypes, allBaseAfterGetFOVMultiplierSuperiors, allBaseAfterGetFOVMultiplierInferiors, "afterGetFOVMultiplier");
        ClientPlayerAPI.sortBases(beforeGetHurtSoundHookTypes, allBaseBeforeGetHurtSoundSuperiors, allBaseBeforeGetHurtSoundInferiors, "beforeGetHurtSound");
        ClientPlayerAPI.sortBases(overrideGetHurtSoundHookTypes, allBaseOverrideGetHurtSoundSuperiors, allBaseOverrideGetHurtSoundInferiors, "overrideGetHurtSound");
        ClientPlayerAPI.sortBases(afterGetHurtSoundHookTypes, allBaseAfterGetHurtSoundSuperiors, allBaseAfterGetHurtSoundInferiors, "afterGetHurtSound");
        ClientPlayerAPI.sortBases(beforeGetItemIconHookTypes, allBaseBeforeGetItemIconSuperiors, allBaseBeforeGetItemIconInferiors, "beforeGetItemIcon");
        ClientPlayerAPI.sortBases(overrideGetItemIconHookTypes, allBaseOverrideGetItemIconSuperiors, allBaseOverrideGetItemIconInferiors, "overrideGetItemIcon");
        ClientPlayerAPI.sortBases(afterGetItemIconHookTypes, allBaseAfterGetItemIconSuperiors, allBaseAfterGetItemIconInferiors, "afterGetItemIcon");
        ClientPlayerAPI.sortBases(beforeGetSleepTimerHookTypes, allBaseBeforeGetSleepTimerSuperiors, allBaseBeforeGetSleepTimerInferiors, "beforeGetSleepTimer");
        ClientPlayerAPI.sortBases(overrideGetSleepTimerHookTypes, allBaseOverrideGetSleepTimerSuperiors, allBaseOverrideGetSleepTimerInferiors, "overrideGetSleepTimer");
        ClientPlayerAPI.sortBases(afterGetSleepTimerHookTypes, allBaseAfterGetSleepTimerSuperiors, allBaseAfterGetSleepTimerInferiors, "afterGetSleepTimer");
        ClientPlayerAPI.sortBases(beforeHandleLavaMovementHookTypes, allBaseBeforeHandleLavaMovementSuperiors, allBaseBeforeHandleLavaMovementInferiors, "beforeHandleLavaMovement");
        ClientPlayerAPI.sortBases(overrideHandleLavaMovementHookTypes, allBaseOverrideHandleLavaMovementSuperiors, allBaseOverrideHandleLavaMovementInferiors, "overrideHandleLavaMovement");
        ClientPlayerAPI.sortBases(afterHandleLavaMovementHookTypes, allBaseAfterHandleLavaMovementSuperiors, allBaseAfterHandleLavaMovementInferiors, "afterHandleLavaMovement");
        ClientPlayerAPI.sortBases(beforeHandleWaterMovementHookTypes, allBaseBeforeHandleWaterMovementSuperiors, allBaseBeforeHandleWaterMovementInferiors, "beforeHandleWaterMovement");
        ClientPlayerAPI.sortBases(overrideHandleWaterMovementHookTypes, allBaseOverrideHandleWaterMovementSuperiors, allBaseOverrideHandleWaterMovementInferiors, "overrideHandleWaterMovement");
        ClientPlayerAPI.sortBases(afterHandleWaterMovementHookTypes, allBaseAfterHandleWaterMovementSuperiors, allBaseAfterHandleWaterMovementInferiors, "afterHandleWaterMovement");
        ClientPlayerAPI.sortBases(beforeHealHookTypes, allBaseBeforeHealSuperiors, allBaseBeforeHealInferiors, "beforeHeal");
        ClientPlayerAPI.sortBases(overrideHealHookTypes, allBaseOverrideHealSuperiors, allBaseOverrideHealInferiors, "overrideHeal");
        ClientPlayerAPI.sortBases(afterHealHookTypes, allBaseAfterHealSuperiors, allBaseAfterHealInferiors, "afterHeal");
        ClientPlayerAPI.sortBases(beforeIsEntityInsideOpaqueBlockHookTypes, allBaseBeforeIsEntityInsideOpaqueBlockSuperiors, allBaseBeforeIsEntityInsideOpaqueBlockInferiors, "beforeIsEntityInsideOpaqueBlock");
        ClientPlayerAPI.sortBases(overrideIsEntityInsideOpaqueBlockHookTypes, allBaseOverrideIsEntityInsideOpaqueBlockSuperiors, allBaseOverrideIsEntityInsideOpaqueBlockInferiors, "overrideIsEntityInsideOpaqueBlock");
        ClientPlayerAPI.sortBases(afterIsEntityInsideOpaqueBlockHookTypes, allBaseAfterIsEntityInsideOpaqueBlockSuperiors, allBaseAfterIsEntityInsideOpaqueBlockInferiors, "afterIsEntityInsideOpaqueBlock");
        ClientPlayerAPI.sortBases(beforeIsInWaterHookTypes, allBaseBeforeIsInWaterSuperiors, allBaseBeforeIsInWaterInferiors, "beforeIsInWater");
        ClientPlayerAPI.sortBases(overrideIsInWaterHookTypes, allBaseOverrideIsInWaterSuperiors, allBaseOverrideIsInWaterInferiors, "overrideIsInWater");
        ClientPlayerAPI.sortBases(afterIsInWaterHookTypes, allBaseAfterIsInWaterSuperiors, allBaseAfterIsInWaterInferiors, "afterIsInWater");
        ClientPlayerAPI.sortBases(beforeIsInsideOfMaterialHookTypes, allBaseBeforeIsInsideOfMaterialSuperiors, allBaseBeforeIsInsideOfMaterialInferiors, "beforeIsInsideOfMaterial");
        ClientPlayerAPI.sortBases(overrideIsInsideOfMaterialHookTypes, allBaseOverrideIsInsideOfMaterialSuperiors, allBaseOverrideIsInsideOfMaterialInferiors, "overrideIsInsideOfMaterial");
        ClientPlayerAPI.sortBases(afterIsInsideOfMaterialHookTypes, allBaseAfterIsInsideOfMaterialSuperiors, allBaseAfterIsInsideOfMaterialInferiors, "afterIsInsideOfMaterial");
        ClientPlayerAPI.sortBases(beforeIsOnLadderHookTypes, allBaseBeforeIsOnLadderSuperiors, allBaseBeforeIsOnLadderInferiors, "beforeIsOnLadder");
        ClientPlayerAPI.sortBases(overrideIsOnLadderHookTypes, allBaseOverrideIsOnLadderSuperiors, allBaseOverrideIsOnLadderInferiors, "overrideIsOnLadder");
        ClientPlayerAPI.sortBases(afterIsOnLadderHookTypes, allBaseAfterIsOnLadderSuperiors, allBaseAfterIsOnLadderInferiors, "afterIsOnLadder");
        ClientPlayerAPI.sortBases(beforeIsPlayerSleepingHookTypes, allBaseBeforeIsPlayerSleepingSuperiors, allBaseBeforeIsPlayerSleepingInferiors, "beforeIsPlayerSleeping");
        ClientPlayerAPI.sortBases(overrideIsPlayerSleepingHookTypes, allBaseOverrideIsPlayerSleepingSuperiors, allBaseOverrideIsPlayerSleepingInferiors, "overrideIsPlayerSleeping");
        ClientPlayerAPI.sortBases(afterIsPlayerSleepingHookTypes, allBaseAfterIsPlayerSleepingSuperiors, allBaseAfterIsPlayerSleepingInferiors, "afterIsPlayerSleeping");
        ClientPlayerAPI.sortBases(beforeIsSneakingHookTypes, allBaseBeforeIsSneakingSuperiors, allBaseBeforeIsSneakingInferiors, "beforeIsSneaking");
        ClientPlayerAPI.sortBases(overrideIsSneakingHookTypes, allBaseOverrideIsSneakingSuperiors, allBaseOverrideIsSneakingInferiors, "overrideIsSneaking");
        ClientPlayerAPI.sortBases(afterIsSneakingHookTypes, allBaseAfterIsSneakingSuperiors, allBaseAfterIsSneakingInferiors, "afterIsSneaking");
        ClientPlayerAPI.sortBases(beforeIsSprintingHookTypes, allBaseBeforeIsSprintingSuperiors, allBaseBeforeIsSprintingInferiors, "beforeIsSprinting");
        ClientPlayerAPI.sortBases(overrideIsSprintingHookTypes, allBaseOverrideIsSprintingSuperiors, allBaseOverrideIsSprintingInferiors, "overrideIsSprinting");
        ClientPlayerAPI.sortBases(afterIsSprintingHookTypes, allBaseAfterIsSprintingSuperiors, allBaseAfterIsSprintingInferiors, "afterIsSprinting");
        ClientPlayerAPI.sortBases(beforeJumpHookTypes, allBaseBeforeJumpSuperiors, allBaseBeforeJumpInferiors, "beforeJump");
        ClientPlayerAPI.sortBases(overrideJumpHookTypes, allBaseOverrideJumpSuperiors, allBaseOverrideJumpInferiors, "overrideJump");
        ClientPlayerAPI.sortBases(afterJumpHookTypes, allBaseAfterJumpSuperiors, allBaseAfterJumpInferiors, "afterJump");
        ClientPlayerAPI.sortBases(beforeKnockBackHookTypes, allBaseBeforeKnockBackSuperiors, allBaseBeforeKnockBackInferiors, "beforeKnockBack");
        ClientPlayerAPI.sortBases(overrideKnockBackHookTypes, allBaseOverrideKnockBackSuperiors, allBaseOverrideKnockBackInferiors, "overrideKnockBack");
        ClientPlayerAPI.sortBases(afterKnockBackHookTypes, allBaseAfterKnockBackSuperiors, allBaseAfterKnockBackInferiors, "afterKnockBack");
        ClientPlayerAPI.sortBases(beforeMoveEntityHookTypes, allBaseBeforeMoveEntitySuperiors, allBaseBeforeMoveEntityInferiors, "beforeMoveEntity");
        ClientPlayerAPI.sortBases(overrideMoveEntityHookTypes, allBaseOverrideMoveEntitySuperiors, allBaseOverrideMoveEntityInferiors, "overrideMoveEntity");
        ClientPlayerAPI.sortBases(afterMoveEntityHookTypes, allBaseAfterMoveEntitySuperiors, allBaseAfterMoveEntityInferiors, "afterMoveEntity");
        ClientPlayerAPI.sortBases(beforeMoveEntityWithHeadingHookTypes, allBaseBeforeMoveEntityWithHeadingSuperiors, allBaseBeforeMoveEntityWithHeadingInferiors, "beforeMoveEntityWithHeading");
        ClientPlayerAPI.sortBases(overrideMoveEntityWithHeadingHookTypes, allBaseOverrideMoveEntityWithHeadingSuperiors, allBaseOverrideMoveEntityWithHeadingInferiors, "overrideMoveEntityWithHeading");
        ClientPlayerAPI.sortBases(afterMoveEntityWithHeadingHookTypes, allBaseAfterMoveEntityWithHeadingSuperiors, allBaseAfterMoveEntityWithHeadingInferiors, "afterMoveEntityWithHeading");
        ClientPlayerAPI.sortBases(beforeMoveFlyingHookTypes, allBaseBeforeMoveFlyingSuperiors, allBaseBeforeMoveFlyingInferiors, "beforeMoveFlying");
        ClientPlayerAPI.sortBases(overrideMoveFlyingHookTypes, allBaseOverrideMoveFlyingSuperiors, allBaseOverrideMoveFlyingInferiors, "overrideMoveFlying");
        ClientPlayerAPI.sortBases(afterMoveFlyingHookTypes, allBaseAfterMoveFlyingSuperiors, allBaseAfterMoveFlyingInferiors, "afterMoveFlying");
        ClientPlayerAPI.sortBases(beforeOnDeathHookTypes, allBaseBeforeOnDeathSuperiors, allBaseBeforeOnDeathInferiors, "beforeOnDeath");
        ClientPlayerAPI.sortBases(overrideOnDeathHookTypes, allBaseOverrideOnDeathSuperiors, allBaseOverrideOnDeathInferiors, "overrideOnDeath");
        ClientPlayerAPI.sortBases(afterOnDeathHookTypes, allBaseAfterOnDeathSuperiors, allBaseAfterOnDeathInferiors, "afterOnDeath");
        ClientPlayerAPI.sortBases(beforeOnLivingUpdateHookTypes, allBaseBeforeOnLivingUpdateSuperiors, allBaseBeforeOnLivingUpdateInferiors, "beforeOnLivingUpdate");
        ClientPlayerAPI.sortBases(overrideOnLivingUpdateHookTypes, allBaseOverrideOnLivingUpdateSuperiors, allBaseOverrideOnLivingUpdateInferiors, "overrideOnLivingUpdate");
        ClientPlayerAPI.sortBases(afterOnLivingUpdateHookTypes, allBaseAfterOnLivingUpdateSuperiors, allBaseAfterOnLivingUpdateInferiors, "afterOnLivingUpdate");
        ClientPlayerAPI.sortBases(beforeOnKillEntityHookTypes, allBaseBeforeOnKillEntitySuperiors, allBaseBeforeOnKillEntityInferiors, "beforeOnKillEntity");
        ClientPlayerAPI.sortBases(overrideOnKillEntityHookTypes, allBaseOverrideOnKillEntitySuperiors, allBaseOverrideOnKillEntityInferiors, "overrideOnKillEntity");
        ClientPlayerAPI.sortBases(afterOnKillEntityHookTypes, allBaseAfterOnKillEntitySuperiors, allBaseAfterOnKillEntityInferiors, "afterOnKillEntity");
        ClientPlayerAPI.sortBases(beforeOnStruckByLightningHookTypes, allBaseBeforeOnStruckByLightningSuperiors, allBaseBeforeOnStruckByLightningInferiors, "beforeOnStruckByLightning");
        ClientPlayerAPI.sortBases(overrideOnStruckByLightningHookTypes, allBaseOverrideOnStruckByLightningSuperiors, allBaseOverrideOnStruckByLightningInferiors, "overrideOnStruckByLightning");
        ClientPlayerAPI.sortBases(afterOnStruckByLightningHookTypes, allBaseAfterOnStruckByLightningSuperiors, allBaseAfterOnStruckByLightningInferiors, "afterOnStruckByLightning");
        ClientPlayerAPI.sortBases(beforeOnUpdateHookTypes, allBaseBeforeOnUpdateSuperiors, allBaseBeforeOnUpdateInferiors, "beforeOnUpdate");
        ClientPlayerAPI.sortBases(overrideOnUpdateHookTypes, allBaseOverrideOnUpdateSuperiors, allBaseOverrideOnUpdateInferiors, "overrideOnUpdate");
        ClientPlayerAPI.sortBases(afterOnUpdateHookTypes, allBaseAfterOnUpdateSuperiors, allBaseAfterOnUpdateInferiors, "afterOnUpdate");
        ClientPlayerAPI.sortBases(beforePlayStepSoundHookTypes, allBaseBeforePlayStepSoundSuperiors, allBaseBeforePlayStepSoundInferiors, "beforePlayStepSound");
        ClientPlayerAPI.sortBases(overridePlayStepSoundHookTypes, allBaseOverridePlayStepSoundSuperiors, allBaseOverridePlayStepSoundInferiors, "overridePlayStepSound");
        ClientPlayerAPI.sortBases(afterPlayStepSoundHookTypes, allBaseAfterPlayStepSoundSuperiors, allBaseAfterPlayStepSoundInferiors, "afterPlayStepSound");
        ClientPlayerAPI.sortBases(beforePushOutOfBlocksHookTypes, allBaseBeforePushOutOfBlocksSuperiors, allBaseBeforePushOutOfBlocksInferiors, "beforePushOutOfBlocks");
        ClientPlayerAPI.sortBases(overridePushOutOfBlocksHookTypes, allBaseOverridePushOutOfBlocksSuperiors, allBaseOverridePushOutOfBlocksInferiors, "overridePushOutOfBlocks");
        ClientPlayerAPI.sortBases(afterPushOutOfBlocksHookTypes, allBaseAfterPushOutOfBlocksSuperiors, allBaseAfterPushOutOfBlocksInferiors, "afterPushOutOfBlocks");
        ClientPlayerAPI.sortBases(beforeRayTraceHookTypes, allBaseBeforeRayTraceSuperiors, allBaseBeforeRayTraceInferiors, "beforeRayTrace");
        ClientPlayerAPI.sortBases(overrideRayTraceHookTypes, allBaseOverrideRayTraceSuperiors, allBaseOverrideRayTraceInferiors, "overrideRayTrace");
        ClientPlayerAPI.sortBases(afterRayTraceHookTypes, allBaseAfterRayTraceSuperiors, allBaseAfterRayTraceInferiors, "afterRayTrace");
        ClientPlayerAPI.sortBases(beforeReadEntityFromNBTHookTypes, allBaseBeforeReadEntityFromNBTSuperiors, allBaseBeforeReadEntityFromNBTInferiors, "beforeReadEntityFromNBT");
        ClientPlayerAPI.sortBases(overrideReadEntityFromNBTHookTypes, allBaseOverrideReadEntityFromNBTSuperiors, allBaseOverrideReadEntityFromNBTInferiors, "overrideReadEntityFromNBT");
        ClientPlayerAPI.sortBases(afterReadEntityFromNBTHookTypes, allBaseAfterReadEntityFromNBTSuperiors, allBaseAfterReadEntityFromNBTInferiors, "afterReadEntityFromNBT");
        ClientPlayerAPI.sortBases(beforeRespawnPlayerHookTypes, allBaseBeforeRespawnPlayerSuperiors, allBaseBeforeRespawnPlayerInferiors, "beforeRespawnPlayer");
        ClientPlayerAPI.sortBases(overrideRespawnPlayerHookTypes, allBaseOverrideRespawnPlayerSuperiors, allBaseOverrideRespawnPlayerInferiors, "overrideRespawnPlayer");
        ClientPlayerAPI.sortBases(afterRespawnPlayerHookTypes, allBaseAfterRespawnPlayerSuperiors, allBaseAfterRespawnPlayerInferiors, "afterRespawnPlayer");
        ClientPlayerAPI.sortBases(beforeSetDeadHookTypes, allBaseBeforeSetDeadSuperiors, allBaseBeforeSetDeadInferiors, "beforeSetDead");
        ClientPlayerAPI.sortBases(overrideSetDeadHookTypes, allBaseOverrideSetDeadSuperiors, allBaseOverrideSetDeadInferiors, "overrideSetDead");
        ClientPlayerAPI.sortBases(afterSetDeadHookTypes, allBaseAfterSetDeadSuperiors, allBaseAfterSetDeadInferiors, "afterSetDead");
        ClientPlayerAPI.sortBases(beforeSetPlayerSPHealthHookTypes, allBaseBeforeSetPlayerSPHealthSuperiors, allBaseBeforeSetPlayerSPHealthInferiors, "beforeSetPlayerSPHealth");
        ClientPlayerAPI.sortBases(overrideSetPlayerSPHealthHookTypes, allBaseOverrideSetPlayerSPHealthSuperiors, allBaseOverrideSetPlayerSPHealthInferiors, "overrideSetPlayerSPHealth");
        ClientPlayerAPI.sortBases(afterSetPlayerSPHealthHookTypes, allBaseAfterSetPlayerSPHealthSuperiors, allBaseAfterSetPlayerSPHealthInferiors, "afterSetPlayerSPHealth");
        ClientPlayerAPI.sortBases(beforeSetPositionAndRotationHookTypes, allBaseBeforeSetPositionAndRotationSuperiors, allBaseBeforeSetPositionAndRotationInferiors, "beforeSetPositionAndRotation");
        ClientPlayerAPI.sortBases(overrideSetPositionAndRotationHookTypes, allBaseOverrideSetPositionAndRotationSuperiors, allBaseOverrideSetPositionAndRotationInferiors, "overrideSetPositionAndRotation");
        ClientPlayerAPI.sortBases(afterSetPositionAndRotationHookTypes, allBaseAfterSetPositionAndRotationSuperiors, allBaseAfterSetPositionAndRotationInferiors, "afterSetPositionAndRotation");
        ClientPlayerAPI.sortBases(beforeSleepInBedAtHookTypes, allBaseBeforeSleepInBedAtSuperiors, allBaseBeforeSleepInBedAtInferiors, "beforeSleepInBedAt");
        ClientPlayerAPI.sortBases(overrideSleepInBedAtHookTypes, allBaseOverrideSleepInBedAtSuperiors, allBaseOverrideSleepInBedAtInferiors, "overrideSleepInBedAt");
        ClientPlayerAPI.sortBases(afterSleepInBedAtHookTypes, allBaseAfterSleepInBedAtSuperiors, allBaseAfterSleepInBedAtInferiors, "afterSleepInBedAt");
        ClientPlayerAPI.sortBases(beforeSwingItemHookTypes, allBaseBeforeSwingItemSuperiors, allBaseBeforeSwingItemInferiors, "beforeSwingItem");
        ClientPlayerAPI.sortBases(overrideSwingItemHookTypes, allBaseOverrideSwingItemSuperiors, allBaseOverrideSwingItemInferiors, "overrideSwingItem");
        ClientPlayerAPI.sortBases(afterSwingItemHookTypes, allBaseAfterSwingItemSuperiors, allBaseAfterSwingItemInferiors, "afterSwingItem");
        ClientPlayerAPI.sortBases(beforeUpdateEntityActionStateHookTypes, allBaseBeforeUpdateEntityActionStateSuperiors, allBaseBeforeUpdateEntityActionStateInferiors, "beforeUpdateEntityActionState");
        ClientPlayerAPI.sortBases(overrideUpdateEntityActionStateHookTypes, allBaseOverrideUpdateEntityActionStateSuperiors, allBaseOverrideUpdateEntityActionStateInferiors, "overrideUpdateEntityActionState");
        ClientPlayerAPI.sortBases(afterUpdateEntityActionStateHookTypes, allBaseAfterUpdateEntityActionStateSuperiors, allBaseAfterUpdateEntityActionStateInferiors, "afterUpdateEntityActionState");
        ClientPlayerAPI.sortBases(beforeUpdateRiddenHookTypes, allBaseBeforeUpdateRiddenSuperiors, allBaseBeforeUpdateRiddenInferiors, "beforeUpdateRidden");
        ClientPlayerAPI.sortBases(overrideUpdateRiddenHookTypes, allBaseOverrideUpdateRiddenSuperiors, allBaseOverrideUpdateRiddenInferiors, "overrideUpdateRidden");
        ClientPlayerAPI.sortBases(afterUpdateRiddenHookTypes, allBaseAfterUpdateRiddenSuperiors, allBaseAfterUpdateRiddenInferiors, "afterUpdateRidden");
        ClientPlayerAPI.sortBases(beforeWriteEntityToNBTHookTypes, allBaseBeforeWriteEntityToNBTSuperiors, allBaseBeforeWriteEntityToNBTInferiors, "beforeWriteEntityToNBT");
        ClientPlayerAPI.sortBases(overrideWriteEntityToNBTHookTypes, allBaseOverrideWriteEntityToNBTSuperiors, allBaseOverrideWriteEntityToNBTInferiors, "overrideWriteEntityToNBT");
        ClientPlayerAPI.sortBases(afterWriteEntityToNBTHookTypes, allBaseAfterWriteEntityToNBTSuperiors, allBaseAfterWriteEntityToNBTInferiors, "afterWriteEntityToNBT");
        initialized = true;
    }

    private static List<IClientPlayerAPI> getAllInstancesList() {
        Object object;
        ArrayList<IClientPlayerAPI> arrayList = new ArrayList<IClientPlayerAPI>();
        try {
            Object object2 = xpzm.class.getMethod("_E", new Class[0]).invoke(null, new Object[0]);
            object = object2 != null ? xpzm.class.getField("_t").get(object2) : null;
        }
        catch (Exception exception) {
            try {
                Object object3 = xpzm.class.getMethod("getMinecraft", new Class[0]).invoke(null, new Object[0]);
                object = object3 != null ? xpzm.class.getField("thePlayer").get(object3) : null;
            }
            catch (Exception exception2) {
                throw new RuntimeException("Unable to aquire list of current server players.", exception);
            }
        }
        if (object != null) {
            arrayList.add((IClientPlayerAPI)object);
        }
        return arrayList;
    }

    public static EntityPlayerSP[] getAllInstances() {
        List<IClientPlayerAPI> list2 = ClientPlayerAPI.getAllInstancesList();
        return list2.toArray(new EntityPlayerSP[list2.size()]);
    }

    public static void beforeLocalConstructing(IClientPlayerAPI iClientPlayerAPI, xpzm xpzm2, ozlu ozlu2, hanr hanr2, int n) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null) {
            clientPlayerAPI.load();
        }
        if (clientPlayerAPI != null) {
            clientPlayerAPI.beforeLocalConstructing(xpzm2, ozlu2, hanr2, n);
        }
    }

    public static void afterLocalConstructing(IClientPlayerAPI iClientPlayerAPI, xpzm xpzm2, ozlu ozlu2, hanr hanr2, int n) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null) {
            clientPlayerAPI.afterLocalConstructing(xpzm2, ozlu2, hanr2, n);
        }
    }

    public static ClientPlayerBase getClientPlayerBase(IClientPlayerAPI iClientPlayerAPI, String string) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null) {
            return clientPlayerAPI.getClientPlayerBase(string);
        }
        return null;
    }

    public static Set<String> getClientPlayerBaseIds(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        Set<String> set = null;
        set = clientPlayerAPI != null ? clientPlayerAPI.getClientPlayerBaseIds() : Collections.emptySet();
        return set;
    }

    public static Object dynamic(IClientPlayerAPI iClientPlayerAPI, String string, Object[] objectArray) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null) {
            return clientPlayerAPI.dynamic(string, objectArray);
        }
        return null;
    }

    private static void sortBases(List<String> list2, Map<String, String[]> map, Map<String, String[]> map2, String string) {
        new ClientPlayerBaseSorter(list2, map, map2, string).Sort();
    }

    private static void sortDynamicBases(Map<String, List<String>> map, Map<String, Map<String, String[]>> map2, Map<String, Map<String, String[]>> map3, String string) {
        List<String> list2 = map.get(string);
        if (list2 != null && list2.size() > 1) {
            ClientPlayerAPI.sortBases(list2, ClientPlayerAPI.getDynamicSorters(string, list2, map2), ClientPlayerAPI.getDynamicSorters(string, list2, map3), string);
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

    private ClientPlayerAPI(IClientPlayerAPI iClientPlayerAPI) {
        this.player = iClientPlayerAPI;
    }

    private void load() {
        for (String string : allBaseConstructors.keySet()) {
            ClientPlayerBase clientPlayerBase = this.createClientPlayerBase(string);
            clientPlayerBase.beforeBaseAttach(false);
            this.allBaseObjects.put(string, clientPlayerBase);
            this.baseObjectsToId.put(clientPlayerBase, string);
        }
        this.beforeLocalConstructingHooks = this.create(beforeLocalConstructingHookTypes);
        this.afterLocalConstructingHooks = this.create(afterLocalConstructingHookTypes);
        this.updateClientPlayerBases();
        Iterator<String> iterator2 = this.allBaseObjects.keySet().iterator();
        while (iterator2.hasNext()) {
            this.allBaseObjects.get(iterator2.next()).afterBaseAttach(false);
        }
    }

    private ClientPlayerBase createClientPlayerBase(String string) {
        ClientPlayerBase clientPlayerBase;
        Constructor<?> constructor = allBaseConstructors.get(string);
        try {
            clientPlayerBase = constructor.getParameterTypes().length == 1 ? (ClientPlayerBase)constructor.newInstance(this) : (ClientPlayerBase)constructor.newInstance(this, string);
        }
        catch (Exception exception) {
            throw new RuntimeException("Exception while creating a ClientPlayerBase of type '" + constructor.getDeclaringClass() + "'", exception);
        }
        return clientPlayerBase;
    }

    private void updateClientPlayerBases() {
        this.beforeAddExhaustionHooks = this.create(beforeAddExhaustionHookTypes);
        this.overrideAddExhaustionHooks = this.create(overrideAddExhaustionHookTypes);
        this.afterAddExhaustionHooks = this.create(afterAddExhaustionHookTypes);
        this.isAddExhaustionModded = this.beforeAddExhaustionHooks != null || this.overrideAddExhaustionHooks != null || this.afterAddExhaustionHooks != null;
        this.beforeAddMovementStatHooks = this.create(beforeAddMovementStatHookTypes);
        this.overrideAddMovementStatHooks = this.create(overrideAddMovementStatHookTypes);
        this.afterAddMovementStatHooks = this.create(afterAddMovementStatHookTypes);
        this.isAddMovementStatModded = this.beforeAddMovementStatHooks != null || this.overrideAddMovementStatHooks != null || this.afterAddMovementStatHooks != null;
        this.beforeAddStatHooks = this.create(beforeAddStatHookTypes);
        this.overrideAddStatHooks = this.create(overrideAddStatHookTypes);
        this.afterAddStatHooks = this.create(afterAddStatHookTypes);
        this.isAddStatModded = this.beforeAddStatHooks != null || this.overrideAddStatHooks != null || this.afterAddStatHooks != null;
        this.beforeAttackEntityFromHooks = this.create(beforeAttackEntityFromHookTypes);
        this.overrideAttackEntityFromHooks = this.create(overrideAttackEntityFromHookTypes);
        this.afterAttackEntityFromHooks = this.create(afterAttackEntityFromHookTypes);
        this.isAttackEntityFromModded = this.beforeAttackEntityFromHooks != null || this.overrideAttackEntityFromHooks != null || this.afterAttackEntityFromHooks != null;
        this.beforeAttackTargetEntityWithCurrentItemHooks = this.create(beforeAttackTargetEntityWithCurrentItemHookTypes);
        this.overrideAttackTargetEntityWithCurrentItemHooks = this.create(overrideAttackTargetEntityWithCurrentItemHookTypes);
        this.afterAttackTargetEntityWithCurrentItemHooks = this.create(afterAttackTargetEntityWithCurrentItemHookTypes);
        this.isAttackTargetEntityWithCurrentItemModded = this.beforeAttackTargetEntityWithCurrentItemHooks != null || this.overrideAttackTargetEntityWithCurrentItemHooks != null || this.afterAttackTargetEntityWithCurrentItemHooks != null;
        this.beforeCanBreatheUnderwaterHooks = this.create(beforeCanBreatheUnderwaterHookTypes);
        this.overrideCanBreatheUnderwaterHooks = this.create(overrideCanBreatheUnderwaterHookTypes);
        this.afterCanBreatheUnderwaterHooks = this.create(afterCanBreatheUnderwaterHookTypes);
        this.isCanBreatheUnderwaterModded = this.beforeCanBreatheUnderwaterHooks != null || this.overrideCanBreatheUnderwaterHooks != null || this.afterCanBreatheUnderwaterHooks != null;
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
        this.beforeCloseScreenHooks = this.create(beforeCloseScreenHookTypes);
        this.overrideCloseScreenHooks = this.create(overrideCloseScreenHookTypes);
        this.afterCloseScreenHooks = this.create(afterCloseScreenHookTypes);
        this.isCloseScreenModded = this.beforeCloseScreenHooks != null || this.overrideCloseScreenHooks != null || this.afterCloseScreenHooks != null;
        this.beforeDamageEntityHooks = this.create(beforeDamageEntityHookTypes);
        this.overrideDamageEntityHooks = this.create(overrideDamageEntityHookTypes);
        this.afterDamageEntityHooks = this.create(afterDamageEntityHookTypes);
        this.isDamageEntityModded = this.beforeDamageEntityHooks != null || this.overrideDamageEntityHooks != null || this.afterDamageEntityHooks != null;
        this.beforeDisplayGUIBrewingStandHooks = this.create(beforeDisplayGUIBrewingStandHookTypes);
        this.overrideDisplayGUIBrewingStandHooks = this.create(overrideDisplayGUIBrewingStandHookTypes);
        this.afterDisplayGUIBrewingStandHooks = this.create(afterDisplayGUIBrewingStandHookTypes);
        this.isDisplayGUIBrewingStandModded = this.beforeDisplayGUIBrewingStandHooks != null || this.overrideDisplayGUIBrewingStandHooks != null || this.afterDisplayGUIBrewingStandHooks != null;
        this.beforeDisplayGUIChestHooks = this.create(beforeDisplayGUIChestHookTypes);
        this.overrideDisplayGUIChestHooks = this.create(overrideDisplayGUIChestHookTypes);
        this.afterDisplayGUIChestHooks = this.create(afterDisplayGUIChestHookTypes);
        this.isDisplayGUIChestModded = this.beforeDisplayGUIChestHooks != null || this.overrideDisplayGUIChestHooks != null || this.afterDisplayGUIChestHooks != null;
        this.beforeDisplayGUIDispenserHooks = this.create(beforeDisplayGUIDispenserHookTypes);
        this.overrideDisplayGUIDispenserHooks = this.create(overrideDisplayGUIDispenserHookTypes);
        this.afterDisplayGUIDispenserHooks = this.create(afterDisplayGUIDispenserHookTypes);
        this.isDisplayGUIDispenserModded = this.beforeDisplayGUIDispenserHooks != null || this.overrideDisplayGUIDispenserHooks != null || this.afterDisplayGUIDispenserHooks != null;
        this.beforeDisplayGUIEditSignHooks = this.create(beforeDisplayGUIEditSignHookTypes);
        this.overrideDisplayGUIEditSignHooks = this.create(overrideDisplayGUIEditSignHookTypes);
        this.afterDisplayGUIEditSignHooks = this.create(afterDisplayGUIEditSignHookTypes);
        this.isDisplayGUIEditSignModded = this.beforeDisplayGUIEditSignHooks != null || this.overrideDisplayGUIEditSignHooks != null || this.afterDisplayGUIEditSignHooks != null;
        this.beforeDisplayGUIEnchantmentHooks = this.create(beforeDisplayGUIEnchantmentHookTypes);
        this.overrideDisplayGUIEnchantmentHooks = this.create(overrideDisplayGUIEnchantmentHookTypes);
        this.afterDisplayGUIEnchantmentHooks = this.create(afterDisplayGUIEnchantmentHookTypes);
        this.isDisplayGUIEnchantmentModded = this.beforeDisplayGUIEnchantmentHooks != null || this.overrideDisplayGUIEnchantmentHooks != null || this.afterDisplayGUIEnchantmentHooks != null;
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
        this.beforeDropPlayerItemWithRandomChoiceHooks = this.create(beforeDropPlayerItemWithRandomChoiceHookTypes);
        this.overrideDropPlayerItemWithRandomChoiceHooks = this.create(overrideDropPlayerItemWithRandomChoiceHookTypes);
        this.afterDropPlayerItemWithRandomChoiceHooks = this.create(afterDropPlayerItemWithRandomChoiceHookTypes);
        this.isDropPlayerItemWithRandomChoiceModded = this.beforeDropPlayerItemWithRandomChoiceHooks != null || this.overrideDropPlayerItemWithRandomChoiceHooks != null || this.afterDropPlayerItemWithRandomChoiceHooks != null;
        this.beforeFallHooks = this.create(beforeFallHookTypes);
        this.overrideFallHooks = this.create(overrideFallHookTypes);
        this.afterFallHooks = this.create(afterFallHookTypes);
        this.isFallModded = this.beforeFallHooks != null || this.overrideFallHooks != null || this.afterFallHooks != null;
        this.beforeGetBrightnessHooks = this.create(beforeGetBrightnessHookTypes);
        this.overrideGetBrightnessHooks = this.create(overrideGetBrightnessHookTypes);
        this.afterGetBrightnessHooks = this.create(afterGetBrightnessHookTypes);
        this.isGetBrightnessModded = this.beforeGetBrightnessHooks != null || this.overrideGetBrightnessHooks != null || this.afterGetBrightnessHooks != null;
        this.beforeGetBrightnessForRenderHooks = this.create(beforeGetBrightnessForRenderHookTypes);
        this.overrideGetBrightnessForRenderHooks = this.create(overrideGetBrightnessForRenderHookTypes);
        this.afterGetBrightnessForRenderHooks = this.create(afterGetBrightnessForRenderHookTypes);
        this.isGetBrightnessForRenderModded = this.beforeGetBrightnessForRenderHooks != null || this.overrideGetBrightnessForRenderHooks != null || this.afterGetBrightnessForRenderHooks != null;
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
        this.beforeGetDistanceSqToEntityHooks = this.create(beforeGetDistanceSqToEntityHookTypes);
        this.overrideGetDistanceSqToEntityHooks = this.create(overrideGetDistanceSqToEntityHookTypes);
        this.afterGetDistanceSqToEntityHooks = this.create(afterGetDistanceSqToEntityHookTypes);
        this.isGetDistanceSqToEntityModded = this.beforeGetDistanceSqToEntityHooks != null || this.overrideGetDistanceSqToEntityHooks != null || this.afterGetDistanceSqToEntityHooks != null;
        this.beforeGetFOVMultiplierHooks = this.create(beforeGetFOVMultiplierHookTypes);
        this.overrideGetFOVMultiplierHooks = this.create(overrideGetFOVMultiplierHookTypes);
        this.afterGetFOVMultiplierHooks = this.create(afterGetFOVMultiplierHookTypes);
        this.isGetFOVMultiplierModded = this.beforeGetFOVMultiplierHooks != null || this.overrideGetFOVMultiplierHooks != null || this.afterGetFOVMultiplierHooks != null;
        this.beforeGetHurtSoundHooks = this.create(beforeGetHurtSoundHookTypes);
        this.overrideGetHurtSoundHooks = this.create(overrideGetHurtSoundHookTypes);
        this.afterGetHurtSoundHooks = this.create(afterGetHurtSoundHookTypes);
        this.isGetHurtSoundModded = this.beforeGetHurtSoundHooks != null || this.overrideGetHurtSoundHooks != null || this.afterGetHurtSoundHooks != null;
        this.beforeGetItemIconHooks = this.create(beforeGetItemIconHookTypes);
        this.overrideGetItemIconHooks = this.create(overrideGetItemIconHookTypes);
        this.afterGetItemIconHooks = this.create(afterGetItemIconHookTypes);
        this.isGetItemIconModded = this.beforeGetItemIconHooks != null || this.overrideGetItemIconHooks != null || this.afterGetItemIconHooks != null;
        this.beforeGetSleepTimerHooks = this.create(beforeGetSleepTimerHookTypes);
        this.overrideGetSleepTimerHooks = this.create(overrideGetSleepTimerHookTypes);
        this.afterGetSleepTimerHooks = this.create(afterGetSleepTimerHookTypes);
        this.isGetSleepTimerModded = this.beforeGetSleepTimerHooks != null || this.overrideGetSleepTimerHooks != null || this.afterGetSleepTimerHooks != null;
        this.beforeHandleLavaMovementHooks = this.create(beforeHandleLavaMovementHookTypes);
        this.overrideHandleLavaMovementHooks = this.create(overrideHandleLavaMovementHookTypes);
        this.afterHandleLavaMovementHooks = this.create(afterHandleLavaMovementHookTypes);
        this.isHandleLavaMovementModded = this.beforeHandleLavaMovementHooks != null || this.overrideHandleLavaMovementHooks != null || this.afterHandleLavaMovementHooks != null;
        this.beforeHandleWaterMovementHooks = this.create(beforeHandleWaterMovementHookTypes);
        this.overrideHandleWaterMovementHooks = this.create(overrideHandleWaterMovementHookTypes);
        this.afterHandleWaterMovementHooks = this.create(afterHandleWaterMovementHookTypes);
        this.isHandleWaterMovementModded = this.beforeHandleWaterMovementHooks != null || this.overrideHandleWaterMovementHooks != null || this.afterHandleWaterMovementHooks != null;
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
        this.beforeIsSneakingHooks = this.create(beforeIsSneakingHookTypes);
        this.overrideIsSneakingHooks = this.create(overrideIsSneakingHookTypes);
        this.afterIsSneakingHooks = this.create(afterIsSneakingHookTypes);
        this.isIsSneakingModded = this.beforeIsSneakingHooks != null || this.overrideIsSneakingHooks != null || this.afterIsSneakingHooks != null;
        this.beforeIsSprintingHooks = this.create(beforeIsSprintingHookTypes);
        this.overrideIsSprintingHooks = this.create(overrideIsSprintingHookTypes);
        this.afterIsSprintingHooks = this.create(afterIsSprintingHookTypes);
        this.isIsSprintingModded = this.beforeIsSprintingHooks != null || this.overrideIsSprintingHooks != null || this.afterIsSprintingHooks != null;
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
        this.beforePlayStepSoundHooks = this.create(beforePlayStepSoundHookTypes);
        this.overridePlayStepSoundHooks = this.create(overridePlayStepSoundHookTypes);
        this.afterPlayStepSoundHooks = this.create(afterPlayStepSoundHookTypes);
        this.isPlayStepSoundModded = this.beforePlayStepSoundHooks != null || this.overridePlayStepSoundHooks != null || this.afterPlayStepSoundHooks != null;
        this.beforePushOutOfBlocksHooks = this.create(beforePushOutOfBlocksHookTypes);
        this.overridePushOutOfBlocksHooks = this.create(overridePushOutOfBlocksHookTypes);
        this.afterPushOutOfBlocksHooks = this.create(afterPushOutOfBlocksHookTypes);
        this.isPushOutOfBlocksModded = this.beforePushOutOfBlocksHooks != null || this.overridePushOutOfBlocksHooks != null || this.afterPushOutOfBlocksHooks != null;
        this.beforeRayTraceHooks = this.create(beforeRayTraceHookTypes);
        this.overrideRayTraceHooks = this.create(overrideRayTraceHookTypes);
        this.afterRayTraceHooks = this.create(afterRayTraceHookTypes);
        this.isRayTraceModded = this.beforeRayTraceHooks != null || this.overrideRayTraceHooks != null || this.afterRayTraceHooks != null;
        this.beforeReadEntityFromNBTHooks = this.create(beforeReadEntityFromNBTHookTypes);
        this.overrideReadEntityFromNBTHooks = this.create(overrideReadEntityFromNBTHookTypes);
        this.afterReadEntityFromNBTHooks = this.create(afterReadEntityFromNBTHookTypes);
        this.isReadEntityFromNBTModded = this.beforeReadEntityFromNBTHooks != null || this.overrideReadEntityFromNBTHooks != null || this.afterReadEntityFromNBTHooks != null;
        this.beforeRespawnPlayerHooks = this.create(beforeRespawnPlayerHookTypes);
        this.overrideRespawnPlayerHooks = this.create(overrideRespawnPlayerHookTypes);
        this.afterRespawnPlayerHooks = this.create(afterRespawnPlayerHookTypes);
        this.isRespawnPlayerModded = this.beforeRespawnPlayerHooks != null || this.overrideRespawnPlayerHooks != null || this.afterRespawnPlayerHooks != null;
        this.beforeSetDeadHooks = this.create(beforeSetDeadHookTypes);
        this.overrideSetDeadHooks = this.create(overrideSetDeadHookTypes);
        this.afterSetDeadHooks = this.create(afterSetDeadHookTypes);
        this.isSetDeadModded = this.beforeSetDeadHooks != null || this.overrideSetDeadHooks != null || this.afterSetDeadHooks != null;
        this.beforeSetPlayerSPHealthHooks = this.create(beforeSetPlayerSPHealthHookTypes);
        this.overrideSetPlayerSPHealthHooks = this.create(overrideSetPlayerSPHealthHookTypes);
        this.afterSetPlayerSPHealthHooks = this.create(afterSetPlayerSPHealthHookTypes);
        this.isSetPlayerSPHealthModded = this.beforeSetPlayerSPHealthHooks != null || this.overrideSetPlayerSPHealthHooks != null || this.afterSetPlayerSPHealthHooks != null;
        this.beforeSetPositionAndRotationHooks = this.create(beforeSetPositionAndRotationHookTypes);
        this.overrideSetPositionAndRotationHooks = this.create(overrideSetPositionAndRotationHookTypes);
        this.afterSetPositionAndRotationHooks = this.create(afterSetPositionAndRotationHookTypes);
        this.isSetPositionAndRotationModded = this.beforeSetPositionAndRotationHooks != null || this.overrideSetPositionAndRotationHooks != null || this.afterSetPositionAndRotationHooks != null;
        this.beforeSleepInBedAtHooks = this.create(beforeSleepInBedAtHookTypes);
        this.overrideSleepInBedAtHooks = this.create(overrideSleepInBedAtHookTypes);
        this.afterSleepInBedAtHooks = this.create(afterSleepInBedAtHookTypes);
        this.isSleepInBedAtModded = this.beforeSleepInBedAtHooks != null || this.overrideSleepInBedAtHooks != null || this.afterSleepInBedAtHooks != null;
        this.beforeSwingItemHooks = this.create(beforeSwingItemHookTypes);
        this.overrideSwingItemHooks = this.create(overrideSwingItemHookTypes);
        this.afterSwingItemHooks = this.create(afterSwingItemHookTypes);
        this.isSwingItemModded = this.beforeSwingItemHooks != null || this.overrideSwingItemHooks != null || this.afterSwingItemHooks != null;
        this.beforeUpdateEntityActionStateHooks = this.create(beforeUpdateEntityActionStateHookTypes);
        this.overrideUpdateEntityActionStateHooks = this.create(overrideUpdateEntityActionStateHookTypes);
        this.afterUpdateEntityActionStateHooks = this.create(afterUpdateEntityActionStateHookTypes);
        this.isUpdateEntityActionStateModded = this.beforeUpdateEntityActionStateHooks != null || this.overrideUpdateEntityActionStateHooks != null || this.afterUpdateEntityActionStateHooks != null;
        this.beforeUpdateRiddenHooks = this.create(beforeUpdateRiddenHookTypes);
        this.overrideUpdateRiddenHooks = this.create(overrideUpdateRiddenHookTypes);
        this.afterUpdateRiddenHooks = this.create(afterUpdateRiddenHookTypes);
        this.isUpdateRiddenModded = this.beforeUpdateRiddenHooks != null || this.overrideUpdateRiddenHooks != null || this.afterUpdateRiddenHooks != null;
        this.beforeWriteEntityToNBTHooks = this.create(beforeWriteEntityToNBTHookTypes);
        this.overrideWriteEntityToNBTHooks = this.create(overrideWriteEntityToNBTHookTypes);
        this.afterWriteEntityToNBTHooks = this.create(afterWriteEntityToNBTHookTypes);
        this.isWriteEntityToNBTModded = this.beforeWriteEntityToNBTHooks != null || this.overrideWriteEntityToNBTHooks != null || this.afterWriteEntityToNBTHooks != null;
    }

    private void attachClientPlayerBase(String string) {
        ClientPlayerBase clientPlayerBase = this.createClientPlayerBase(string);
        clientPlayerBase.beforeBaseAttach(true);
        this.allBaseObjects.put(string, clientPlayerBase);
        this.updateClientPlayerBases();
        clientPlayerBase.afterBaseAttach(true);
    }

    private void detachClientPlayerBase(String string) {
        ClientPlayerBase clientPlayerBase = this.allBaseObjects.get(string);
        clientPlayerBase.beforeBaseDetach(true);
        this.allBaseObjects.remove(string);
        this.updateClientPlayerBases();
        clientPlayerBase.afterBaseDetach(true);
    }

    private ClientPlayerBase[] create(List<String> list2) {
        if (list2.isEmpty()) {
            return null;
        }
        ClientPlayerBase[] clientPlayerBaseArray = new ClientPlayerBase[list2.size()];
        for (int i = 0; i < clientPlayerBaseArray.length; ++i) {
            clientPlayerBaseArray[i] = this.getClientPlayerBase(list2.get(i));
        }
        return clientPlayerBaseArray;
    }

    private void beforeLocalConstructing(xpzm xpzm2, ozlu ozlu2, hanr hanr2, int n) {
        if (this.beforeLocalConstructingHooks != null) {
            for (int i = this.beforeLocalConstructingHooks.length - 1; i >= 0; --i) {
                this.beforeLocalConstructingHooks[i].beforeLocalConstructing(xpzm2, ozlu2, hanr2, n);
            }
        }
        this.beforeLocalConstructingHooks = null;
    }

    private void afterLocalConstructing(xpzm xpzm2, ozlu ozlu2, hanr hanr2, int n) {
        if (this.afterLocalConstructingHooks != null) {
            for (int i = 0; i < this.afterLocalConstructingHooks.length; ++i) {
                this.afterLocalConstructingHooks[i].afterLocalConstructing(xpzm2, ozlu2, hanr2, n);
            }
        }
        this.afterLocalConstructingHooks = null;
    }

    public ClientPlayerBase getClientPlayerBase(String string) {
        return this.allBaseObjects.get(string);
    }

    public Set<String> getClientPlayerBaseIds() {
        return this.unmodifiableAllBaseIds;
    }

    public Object dynamic(String string, Object[] objectArray) {
        string = string.replace('.', '_').replace(' ', '_');
        this.executeAll(string, objectArray, beforeDynamicHookTypes, beforeDynamicHookMethods, true);
        Object object = this.dynamicOverwritten(string, objectArray, null);
        this.executeAll(string, objectArray, afterDynamicHookTypes, afterDynamicHookMethods, false);
        return object;
    }

    public Object dynamicOverwritten(String string, Object[] objectArray, ClientPlayerBase clientPlayerBase) {
        Map<Class<?>, Map<String, Method>> map;
        List<String> list2 = overrideDynamicHookTypes.get(string);
        String string2 = null;
        if (list2 != null) {
            if (clientPlayerBase != null) {
                string2 = this.baseObjectsToId.get(clientPlayerBase);
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
        return this.execute(this.getClientPlayerBase(string2), method, objectArray);
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
            ClientPlayerBase clientPlayerBase = this.getClientPlayerBase(string2);
            Class<?> clazz = clientPlayerBase.getClass();
            Map<String, Method> map3 = map2.get(clazz);
            if (map3 != null && (method = map3.get(string)) != null) {
                this.execute(clientPlayerBase, method, objectArray);
            }
            n += bl ? -1 : 1;
        }
    }

    private Object execute(ClientPlayerBase clientPlayerBase, Method method, Object[] objectArray) {
        try {
            return method.invoke(clientPlayerBase, objectArray);
        }
        catch (Exception exception) {
            throw new RuntimeException("Exception while invoking dynamic method", exception);
        }
    }

    public static void addExhaustion(IClientPlayerAPI iClientPlayerAPI, float f) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isAddExhaustionModded) {
            clientPlayerAPI.addExhaustion(f);
        } else {
            iClientPlayerAPI.localAddExhaustion(f);
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

    protected ClientPlayerBase GetOverwrittenAddExhaustion(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideAddExhaustionHooks.length; ++i) {
            if (this.overrideAddExhaustionHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideAddExhaustionHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void addMovementStat(IClientPlayerAPI iClientPlayerAPI, double d, double d2, double d3) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isAddMovementStatModded) {
            clientPlayerAPI.addMovementStat(d, d2, d3);
        } else {
            iClientPlayerAPI.localAddMovementStat(d, d2, d3);
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

    protected ClientPlayerBase GetOverwrittenAddMovementStat(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideAddMovementStatHooks.length; ++i) {
            if (this.overrideAddMovementStatHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideAddMovementStatHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void addStat(IClientPlayerAPI iClientPlayerAPI, rann rann2, int n) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isAddStatModded) {
            clientPlayerAPI.addStat(rann2, n);
        } else {
            iClientPlayerAPI.localAddStat(rann2, n);
        }
    }

    private void addStat(rann rann2, int n) {
        int n2;
        if (this.beforeAddStatHooks != null) {
            for (n2 = this.beforeAddStatHooks.length - 1; n2 >= 0; --n2) {
                this.beforeAddStatHooks[n2].beforeAddStat(rann2, n);
            }
        }
        if (this.overrideAddStatHooks != null) {
            this.overrideAddStatHooks[this.overrideAddStatHooks.length - 1].addStat(rann2, n);
        } else {
            this.player.localAddStat(rann2, n);
        }
        if (this.afterAddStatHooks != null) {
            for (n2 = 0; n2 < this.afterAddStatHooks.length; ++n2) {
                this.afterAddStatHooks[n2].afterAddStat(rann2, n);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenAddStat(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideAddStatHooks.length; ++i) {
            if (this.overrideAddStatHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideAddStatHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean attackEntityFrom(IClientPlayerAPI iClientPlayerAPI, jxtc jxtc2, float f) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isAttackEntityFromModded ? clientPlayerAPI.attackEntityFrom(jxtc2, f) : iClientPlayerAPI.localAttackEntityFrom(jxtc2, f);
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

    protected ClientPlayerBase GetOverwrittenAttackEntityFrom(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideAttackEntityFromHooks.length; ++i) {
            if (this.overrideAttackEntityFromHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideAttackEntityFromHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void attackTargetEntityWithCurrentItem(IClientPlayerAPI iClientPlayerAPI, Entity entity) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isAttackTargetEntityWithCurrentItemModded) {
            clientPlayerAPI.attackTargetEntityWithCurrentItem(entity);
        } else {
            iClientPlayerAPI.localAttackTargetEntityWithCurrentItem(entity);
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

    protected ClientPlayerBase GetOverwrittenAttackTargetEntityWithCurrentItem(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideAttackTargetEntityWithCurrentItemHooks.length; ++i) {
            if (this.overrideAttackTargetEntityWithCurrentItemHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideAttackTargetEntityWithCurrentItemHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean canBreatheUnderwater(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isCanBreatheUnderwaterModded ? clientPlayerAPI.canBreatheUnderwater() : iClientPlayerAPI.localCanBreatheUnderwater();
        return bl;
    }

    private boolean canBreatheUnderwater() {
        int n;
        if (this.beforeCanBreatheUnderwaterHooks != null) {
            for (n = this.beforeCanBreatheUnderwaterHooks.length - 1; n >= 0; --n) {
                this.beforeCanBreatheUnderwaterHooks[n].beforeCanBreatheUnderwater();
            }
        }
        n = this.overrideCanBreatheUnderwaterHooks != null ? this.overrideCanBreatheUnderwaterHooks[this.overrideCanBreatheUnderwaterHooks.length - 1].canBreatheUnderwater() : (int)(this.player.localCanBreatheUnderwater() ? 1 : 0);
        if (this.afterCanBreatheUnderwaterHooks != null) {
            for (int i = 0; i < this.afterCanBreatheUnderwaterHooks.length; ++i) {
                this.afterCanBreatheUnderwaterHooks[i].afterCanBreatheUnderwater();
            }
        }
        return n != 0;
    }

    protected ClientPlayerBase GetOverwrittenCanBreatheUnderwater(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideCanBreatheUnderwaterHooks.length; ++i) {
            if (this.overrideCanBreatheUnderwaterHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideCanBreatheUnderwaterHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean canHarvestBlock(IClientPlayerAPI iClientPlayerAPI, twgu twgu2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isCanHarvestBlockModded ? clientPlayerAPI.canHarvestBlock(twgu2) : iClientPlayerAPI.localCanHarvestBlock(twgu2);
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

    protected ClientPlayerBase GetOverwrittenCanHarvestBlock(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideCanHarvestBlockHooks.length; ++i) {
            if (this.overrideCanHarvestBlockHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideCanHarvestBlockHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean canPlayerEdit(IClientPlayerAPI iClientPlayerAPI, int n, int n2, int n3, int n4, cvzo cvzo2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isCanPlayerEditModded ? clientPlayerAPI.canPlayerEdit(n, n2, n3, n4, cvzo2) : iClientPlayerAPI.localCanPlayerEdit(n, n2, n3, n4, cvzo2);
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

    protected ClientPlayerBase GetOverwrittenCanPlayerEdit(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideCanPlayerEditHooks.length; ++i) {
            if (this.overrideCanPlayerEditHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideCanPlayerEditHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean canTriggerWalking(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isCanTriggerWalkingModded ? clientPlayerAPI.canTriggerWalking() : iClientPlayerAPI.localCanTriggerWalking();
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

    protected ClientPlayerBase GetOverwrittenCanTriggerWalking(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideCanTriggerWalkingHooks.length; ++i) {
            if (this.overrideCanTriggerWalkingHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideCanTriggerWalkingHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void closeScreen(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isCloseScreenModded) {
            clientPlayerAPI.closeScreen();
        } else {
            iClientPlayerAPI.localCloseScreen();
        }
    }

    private void closeScreen() {
        int n;
        if (this.beforeCloseScreenHooks != null) {
            for (n = this.beforeCloseScreenHooks.length - 1; n >= 0; --n) {
                this.beforeCloseScreenHooks[n].beforeCloseScreen();
            }
        }
        if (this.overrideCloseScreenHooks != null) {
            this.overrideCloseScreenHooks[this.overrideCloseScreenHooks.length - 1].closeScreen();
        } else {
            this.player.localCloseScreen();
        }
        if (this.afterCloseScreenHooks != null) {
            for (n = 0; n < this.afterCloseScreenHooks.length; ++n) {
                this.afterCloseScreenHooks[n].afterCloseScreen();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenCloseScreen(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideCloseScreenHooks.length; ++i) {
            if (this.overrideCloseScreenHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideCloseScreenHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void damageEntity(IClientPlayerAPI iClientPlayerAPI, jxtc jxtc2, float f) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isDamageEntityModded) {
            clientPlayerAPI.damageEntity(jxtc2, f);
        } else {
            iClientPlayerAPI.localDamageEntity(jxtc2, f);
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

    protected ClientPlayerBase GetOverwrittenDamageEntity(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideDamageEntityHooks.length; ++i) {
            if (this.overrideDamageEntityHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDamageEntityHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void displayGUIBrewingStand(IClientPlayerAPI iClientPlayerAPI, nfbs nfbs2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isDisplayGUIBrewingStandModded) {
            clientPlayerAPI.displayGUIBrewingStand(nfbs2);
        } else {
            iClientPlayerAPI.localDisplayGUIBrewingStand(nfbs2);
        }
    }

    private void displayGUIBrewingStand(nfbs nfbs2) {
        int n;
        if (this.beforeDisplayGUIBrewingStandHooks != null) {
            for (n = this.beforeDisplayGUIBrewingStandHooks.length - 1; n >= 0; --n) {
                this.beforeDisplayGUIBrewingStandHooks[n].beforeDisplayGUIBrewingStand(nfbs2);
            }
        }
        if (this.overrideDisplayGUIBrewingStandHooks != null) {
            this.overrideDisplayGUIBrewingStandHooks[this.overrideDisplayGUIBrewingStandHooks.length - 1].displayGUIBrewingStand(nfbs2);
        } else {
            this.player.localDisplayGUIBrewingStand(nfbs2);
        }
        if (this.afterDisplayGUIBrewingStandHooks != null) {
            for (n = 0; n < this.afterDisplayGUIBrewingStandHooks.length; ++n) {
                this.afterDisplayGUIBrewingStandHooks[n].afterDisplayGUIBrewingStand(nfbs2);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenDisplayGUIBrewingStand(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideDisplayGUIBrewingStandHooks.length; ++i) {
            if (this.overrideDisplayGUIBrewingStandHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDisplayGUIBrewingStandHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void displayGUIChest(IClientPlayerAPI iClientPlayerAPI, mssh mssh2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isDisplayGUIChestModded) {
            clientPlayerAPI.displayGUIChest(mssh2);
        } else {
            iClientPlayerAPI.localDisplayGUIChest(mssh2);
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

    protected ClientPlayerBase GetOverwrittenDisplayGUIChest(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideDisplayGUIChestHooks.length; ++i) {
            if (this.overrideDisplayGUIChestHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDisplayGUIChestHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void displayGUIDispenser(IClientPlayerAPI iClientPlayerAPI, jjzo jjzo2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isDisplayGUIDispenserModded) {
            clientPlayerAPI.displayGUIDispenser(jjzo2);
        } else {
            iClientPlayerAPI.localDisplayGUIDispenser(jjzo2);
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

    protected ClientPlayerBase GetOverwrittenDisplayGUIDispenser(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideDisplayGUIDispenserHooks.length; ++i) {
            if (this.overrideDisplayGUIDispenserHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDisplayGUIDispenserHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void displayGUIEditSign(IClientPlayerAPI iClientPlayerAPI, hurg hurg2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isDisplayGUIEditSignModded) {
            clientPlayerAPI.displayGUIEditSign(hurg2);
        } else {
            iClientPlayerAPI.localDisplayGUIEditSign(hurg2);
        }
    }

    private void displayGUIEditSign(hurg hurg2) {
        int n;
        if (this.beforeDisplayGUIEditSignHooks != null) {
            for (n = this.beforeDisplayGUIEditSignHooks.length - 1; n >= 0; --n) {
                this.beforeDisplayGUIEditSignHooks[n].beforeDisplayGUIEditSign(hurg2);
            }
        }
        if (this.overrideDisplayGUIEditSignHooks != null) {
            this.overrideDisplayGUIEditSignHooks[this.overrideDisplayGUIEditSignHooks.length - 1].displayGUIEditSign(hurg2);
        } else {
            this.player.localDisplayGUIEditSign(hurg2);
        }
        if (this.afterDisplayGUIEditSignHooks != null) {
            for (n = 0; n < this.afterDisplayGUIEditSignHooks.length; ++n) {
                this.afterDisplayGUIEditSignHooks[n].afterDisplayGUIEditSign(hurg2);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenDisplayGUIEditSign(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideDisplayGUIEditSignHooks.length; ++i) {
            if (this.overrideDisplayGUIEditSignHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDisplayGUIEditSignHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void displayGUIEnchantment(IClientPlayerAPI iClientPlayerAPI, int n, int n2, int n3, String string) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isDisplayGUIEnchantmentModded) {
            clientPlayerAPI.displayGUIEnchantment(n, n2, n3, string);
        } else {
            iClientPlayerAPI.localDisplayGUIEnchantment(n, n2, n3, string);
        }
    }

    private void displayGUIEnchantment(int n, int n2, int n3, String string) {
        int n4;
        if (this.beforeDisplayGUIEnchantmentHooks != null) {
            for (n4 = this.beforeDisplayGUIEnchantmentHooks.length - 1; n4 >= 0; --n4) {
                this.beforeDisplayGUIEnchantmentHooks[n4].beforeDisplayGUIEnchantment(n, n2, n3, string);
            }
        }
        if (this.overrideDisplayGUIEnchantmentHooks != null) {
            this.overrideDisplayGUIEnchantmentHooks[this.overrideDisplayGUIEnchantmentHooks.length - 1].displayGUIEnchantment(n, n2, n3, string);
        } else {
            this.player.localDisplayGUIEnchantment(n, n2, n3, string);
        }
        if (this.afterDisplayGUIEnchantmentHooks != null) {
            for (n4 = 0; n4 < this.afterDisplayGUIEnchantmentHooks.length; ++n4) {
                this.afterDisplayGUIEnchantmentHooks[n4].afterDisplayGUIEnchantment(n, n2, n3, string);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenDisplayGUIEnchantment(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideDisplayGUIEnchantmentHooks.length; ++i) {
            if (this.overrideDisplayGUIEnchantmentHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDisplayGUIEnchantmentHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void displayGUIFurnace(IClientPlayerAPI iClientPlayerAPI, nwgz nwgz2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isDisplayGUIFurnaceModded) {
            clientPlayerAPI.displayGUIFurnace(nwgz2);
        } else {
            iClientPlayerAPI.localDisplayGUIFurnace(nwgz2);
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

    protected ClientPlayerBase GetOverwrittenDisplayGUIFurnace(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideDisplayGUIFurnaceHooks.length; ++i) {
            if (this.overrideDisplayGUIFurnaceHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDisplayGUIFurnaceHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void displayGUIWorkbench(IClientPlayerAPI iClientPlayerAPI, int n, int n2, int n3) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isDisplayGUIWorkbenchModded) {
            clientPlayerAPI.displayGUIWorkbench(n, n2, n3);
        } else {
            iClientPlayerAPI.localDisplayGUIWorkbench(n, n2, n3);
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

    protected ClientPlayerBase GetOverwrittenDisplayGUIWorkbench(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideDisplayGUIWorkbenchHooks.length; ++i) {
            if (this.overrideDisplayGUIWorkbenchHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDisplayGUIWorkbenchHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static EntityItem dropOneItem(IClientPlayerAPI iClientPlayerAPI, boolean bl) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        EntityItem entityItem = clientPlayerAPI != null && clientPlayerAPI.isDropOneItemModded ? clientPlayerAPI.dropOneItem(bl) : iClientPlayerAPI.localDropOneItem(bl);
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

    protected ClientPlayerBase GetOverwrittenDropOneItem(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideDropOneItemHooks.length; ++i) {
            if (this.overrideDropOneItemHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDropOneItemHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static EntityItem dropPlayerItem(IClientPlayerAPI iClientPlayerAPI, cvzo cvzo2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        EntityItem entityItem = clientPlayerAPI != null && clientPlayerAPI.isDropPlayerItemModded ? clientPlayerAPI.dropPlayerItem(cvzo2) : iClientPlayerAPI.localDropPlayerItem(cvzo2);
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

    protected ClientPlayerBase GetOverwrittenDropPlayerItem(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideDropPlayerItemHooks.length; ++i) {
            if (this.overrideDropPlayerItemHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDropPlayerItemHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static EntityItem dropPlayerItemWithRandomChoice(IClientPlayerAPI iClientPlayerAPI, cvzo cvzo2, boolean bl) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        EntityItem entityItem = clientPlayerAPI != null && clientPlayerAPI.isDropPlayerItemWithRandomChoiceModded ? clientPlayerAPI.dropPlayerItemWithRandomChoice(cvzo2, bl) : iClientPlayerAPI.localDropPlayerItemWithRandomChoice(cvzo2, bl);
        return entityItem;
    }

    private EntityItem dropPlayerItemWithRandomChoice(cvzo cvzo2, boolean bl) {
        if (this.beforeDropPlayerItemWithRandomChoiceHooks != null) {
            for (int i = this.beforeDropPlayerItemWithRandomChoiceHooks.length - 1; i >= 0; --i) {
                this.beforeDropPlayerItemWithRandomChoiceHooks[i].beforeDropPlayerItemWithRandomChoice(cvzo2, bl);
            }
        }
        EntityItem entityItem = this.overrideDropPlayerItemWithRandomChoiceHooks != null ? this.overrideDropPlayerItemWithRandomChoiceHooks[this.overrideDropPlayerItemWithRandomChoiceHooks.length - 1].dropPlayerItemWithRandomChoice(cvzo2, bl) : this.player.localDropPlayerItemWithRandomChoice(cvzo2, bl);
        if (this.afterDropPlayerItemWithRandomChoiceHooks != null) {
            for (int i = 0; i < this.afterDropPlayerItemWithRandomChoiceHooks.length; ++i) {
                this.afterDropPlayerItemWithRandomChoiceHooks[i].afterDropPlayerItemWithRandomChoice(cvzo2, bl);
            }
        }
        return entityItem;
    }

    protected ClientPlayerBase GetOverwrittenDropPlayerItemWithRandomChoice(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideDropPlayerItemWithRandomChoiceHooks.length; ++i) {
            if (this.overrideDropPlayerItemWithRandomChoiceHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDropPlayerItemWithRandomChoiceHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void fall(IClientPlayerAPI iClientPlayerAPI, float f) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isFallModded) {
            clientPlayerAPI.fall(f);
        } else {
            iClientPlayerAPI.localFall(f);
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

    protected ClientPlayerBase GetOverwrittenFall(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideFallHooks.length; ++i) {
            if (this.overrideFallHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideFallHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static float getBrightness(IClientPlayerAPI iClientPlayerAPI, float f) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        float f2 = clientPlayerAPI != null && clientPlayerAPI.isGetBrightnessModded ? clientPlayerAPI.getBrightness(f) : iClientPlayerAPI.localGetBrightness(f);
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

    protected ClientPlayerBase GetOverwrittenGetBrightness(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideGetBrightnessHooks.length; ++i) {
            if (this.overrideGetBrightnessHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetBrightnessHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static int getBrightnessForRender(IClientPlayerAPI iClientPlayerAPI, float f) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        int n = clientPlayerAPI != null && clientPlayerAPI.isGetBrightnessForRenderModded ? clientPlayerAPI.getBrightnessForRender(f) : iClientPlayerAPI.localGetBrightnessForRender(f);
        return n;
    }

    private int getBrightnessForRender(float f) {
        int n;
        if (this.beforeGetBrightnessForRenderHooks != null) {
            for (n = this.beforeGetBrightnessForRenderHooks.length - 1; n >= 0; --n) {
                this.beforeGetBrightnessForRenderHooks[n].beforeGetBrightnessForRender(f);
            }
        }
        n = this.overrideGetBrightnessForRenderHooks != null ? this.overrideGetBrightnessForRenderHooks[this.overrideGetBrightnessForRenderHooks.length - 1].getBrightnessForRender(f) : this.player.localGetBrightnessForRender(f);
        if (this.afterGetBrightnessForRenderHooks != null) {
            for (int i = 0; i < this.afterGetBrightnessForRenderHooks.length; ++i) {
                this.afterGetBrightnessForRenderHooks[i].afterGetBrightnessForRender(f);
            }
        }
        return n;
    }

    protected ClientPlayerBase GetOverwrittenGetBrightnessForRender(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideGetBrightnessForRenderHooks.length; ++i) {
            if (this.overrideGetBrightnessForRenderHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetBrightnessForRenderHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static float getCurrentPlayerStrVsBlock(IClientPlayerAPI iClientPlayerAPI, twgu twgu2, boolean bl) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        float f = clientPlayerAPI != null && clientPlayerAPI.isGetCurrentPlayerStrVsBlockModded ? clientPlayerAPI.getCurrentPlayerStrVsBlock(twgu2, bl) : iClientPlayerAPI.localGetCurrentPlayerStrVsBlock(twgu2, bl);
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

    protected ClientPlayerBase GetOverwrittenGetCurrentPlayerStrVsBlock(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideGetCurrentPlayerStrVsBlockHooks.length; ++i) {
            if (this.overrideGetCurrentPlayerStrVsBlockHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetCurrentPlayerStrVsBlockHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static float getCurrentPlayerStrVsBlockForge(IClientPlayerAPI iClientPlayerAPI, twgu twgu2, boolean bl, int n) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        float f = clientPlayerAPI != null && clientPlayerAPI.isGetCurrentPlayerStrVsBlockForgeModded ? clientPlayerAPI.getCurrentPlayerStrVsBlockForge(twgu2, bl, n) : iClientPlayerAPI.localGetCurrentPlayerStrVsBlockForge(twgu2, bl, n);
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

    protected ClientPlayerBase GetOverwrittenGetCurrentPlayerStrVsBlockForge(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideGetCurrentPlayerStrVsBlockForgeHooks.length; ++i) {
            if (this.overrideGetCurrentPlayerStrVsBlockForgeHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetCurrentPlayerStrVsBlockForgeHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static double getDistanceSq(IClientPlayerAPI iClientPlayerAPI, double d, double d2, double d3) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        double d4 = clientPlayerAPI != null && clientPlayerAPI.isGetDistanceSqModded ? clientPlayerAPI.getDistanceSq(d, d2, d3) : iClientPlayerAPI.localGetDistanceSq(d, d2, d3);
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

    protected ClientPlayerBase GetOverwrittenGetDistanceSq(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideGetDistanceSqHooks.length; ++i) {
            if (this.overrideGetDistanceSqHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetDistanceSqHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static double getDistanceSqToEntity(IClientPlayerAPI iClientPlayerAPI, Entity entity) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        double d = clientPlayerAPI != null && clientPlayerAPI.isGetDistanceSqToEntityModded ? clientPlayerAPI.getDistanceSqToEntity(entity) : iClientPlayerAPI.localGetDistanceSqToEntity(entity);
        return d;
    }

    private double getDistanceSqToEntity(Entity entity) {
        if (this.beforeGetDistanceSqToEntityHooks != null) {
            for (int i = this.beforeGetDistanceSqToEntityHooks.length - 1; i >= 0; --i) {
                this.beforeGetDistanceSqToEntityHooks[i].beforeGetDistanceSqToEntity(entity);
            }
        }
        double d = this.overrideGetDistanceSqToEntityHooks != null ? this.overrideGetDistanceSqToEntityHooks[this.overrideGetDistanceSqToEntityHooks.length - 1].getDistanceSqToEntity(entity) : this.player.localGetDistanceSqToEntity(entity);
        if (this.afterGetDistanceSqToEntityHooks != null) {
            for (int i = 0; i < this.afterGetDistanceSqToEntityHooks.length; ++i) {
                this.afterGetDistanceSqToEntityHooks[i].afterGetDistanceSqToEntity(entity);
            }
        }
        return d;
    }

    protected ClientPlayerBase GetOverwrittenGetDistanceSqToEntity(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideGetDistanceSqToEntityHooks.length; ++i) {
            if (this.overrideGetDistanceSqToEntityHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetDistanceSqToEntityHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static float getFOVMultiplier(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        float f = clientPlayerAPI != null && clientPlayerAPI.isGetFOVMultiplierModded ? clientPlayerAPI.getFOVMultiplier() : iClientPlayerAPI.localGetFOVMultiplier();
        return f;
    }

    private float getFOVMultiplier() {
        if (this.beforeGetFOVMultiplierHooks != null) {
            for (int i = this.beforeGetFOVMultiplierHooks.length - 1; i >= 0; --i) {
                this.beforeGetFOVMultiplierHooks[i].beforeGetFOVMultiplier();
            }
        }
        float f = this.overrideGetFOVMultiplierHooks != null ? this.overrideGetFOVMultiplierHooks[this.overrideGetFOVMultiplierHooks.length - 1].getFOVMultiplier() : this.player.localGetFOVMultiplier();
        if (this.afterGetFOVMultiplierHooks != null) {
            for (int i = 0; i < this.afterGetFOVMultiplierHooks.length; ++i) {
                this.afterGetFOVMultiplierHooks[i].afterGetFOVMultiplier();
            }
        }
        return f;
    }

    protected ClientPlayerBase GetOverwrittenGetFOVMultiplier(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideGetFOVMultiplierHooks.length; ++i) {
            if (this.overrideGetFOVMultiplierHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetFOVMultiplierHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static String getHurtSound(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        String string = clientPlayerAPI != null && clientPlayerAPI.isGetHurtSoundModded ? clientPlayerAPI.getHurtSound() : iClientPlayerAPI.localGetHurtSound();
        return string;
    }

    private String getHurtSound() {
        if (this.beforeGetHurtSoundHooks != null) {
            for (int i = this.beforeGetHurtSoundHooks.length - 1; i >= 0; --i) {
                this.beforeGetHurtSoundHooks[i].beforeGetHurtSound();
            }
        }
        String string = this.overrideGetHurtSoundHooks != null ? this.overrideGetHurtSoundHooks[this.overrideGetHurtSoundHooks.length - 1].getHurtSound() : this.player.localGetHurtSound();
        if (this.afterGetHurtSoundHooks != null) {
            for (int i = 0; i < this.afterGetHurtSoundHooks.length; ++i) {
                this.afterGetHurtSoundHooks[i].afterGetHurtSound();
            }
        }
        return string;
    }

    protected ClientPlayerBase GetOverwrittenGetHurtSound(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideGetHurtSoundHooks.length; ++i) {
            if (this.overrideGetHurtSoundHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetHurtSoundHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static dwan getItemIcon(IClientPlayerAPI iClientPlayerAPI, cvzo cvzo2, int n) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        dwan dwan2 = clientPlayerAPI != null && clientPlayerAPI.isGetItemIconModded ? clientPlayerAPI.getItemIcon(cvzo2, n) : iClientPlayerAPI.localGetItemIcon(cvzo2, n);
        return dwan2;
    }

    private dwan getItemIcon(cvzo cvzo2, int n) {
        if (this.beforeGetItemIconHooks != null) {
            for (int i = this.beforeGetItemIconHooks.length - 1; i >= 0; --i) {
                this.beforeGetItemIconHooks[i].beforeGetItemIcon(cvzo2, n);
            }
        }
        dwan dwan2 = this.overrideGetItemIconHooks != null ? this.overrideGetItemIconHooks[this.overrideGetItemIconHooks.length - 1].getItemIcon(cvzo2, n) : this.player.localGetItemIcon(cvzo2, n);
        if (this.afterGetItemIconHooks != null) {
            for (int i = 0; i < this.afterGetItemIconHooks.length; ++i) {
                this.afterGetItemIconHooks[i].afterGetItemIcon(cvzo2, n);
            }
        }
        return dwan2;
    }

    protected ClientPlayerBase GetOverwrittenGetItemIcon(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideGetItemIconHooks.length; ++i) {
            if (this.overrideGetItemIconHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetItemIconHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static int getSleepTimer(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        int n = clientPlayerAPI != null && clientPlayerAPI.isGetSleepTimerModded ? clientPlayerAPI.getSleepTimer() : iClientPlayerAPI.localGetSleepTimer();
        return n;
    }

    private int getSleepTimer() {
        int n;
        if (this.beforeGetSleepTimerHooks != null) {
            for (n = this.beforeGetSleepTimerHooks.length - 1; n >= 0; --n) {
                this.beforeGetSleepTimerHooks[n].beforeGetSleepTimer();
            }
        }
        n = this.overrideGetSleepTimerHooks != null ? this.overrideGetSleepTimerHooks[this.overrideGetSleepTimerHooks.length - 1].getSleepTimer() : this.player.localGetSleepTimer();
        if (this.afterGetSleepTimerHooks != null) {
            for (int i = 0; i < this.afterGetSleepTimerHooks.length; ++i) {
                this.afterGetSleepTimerHooks[i].afterGetSleepTimer();
            }
        }
        return n;
    }

    protected ClientPlayerBase GetOverwrittenGetSleepTimer(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideGetSleepTimerHooks.length; ++i) {
            if (this.overrideGetSleepTimerHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetSleepTimerHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean handleLavaMovement(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isHandleLavaMovementModded ? clientPlayerAPI.handleLavaMovement() : iClientPlayerAPI.localHandleLavaMovement();
        return bl;
    }

    private boolean handleLavaMovement() {
        int n;
        if (this.beforeHandleLavaMovementHooks != null) {
            for (n = this.beforeHandleLavaMovementHooks.length - 1; n >= 0; --n) {
                this.beforeHandleLavaMovementHooks[n].beforeHandleLavaMovement();
            }
        }
        n = this.overrideHandleLavaMovementHooks != null ? this.overrideHandleLavaMovementHooks[this.overrideHandleLavaMovementHooks.length - 1].handleLavaMovement() : (int)(this.player.localHandleLavaMovement() ? 1 : 0);
        if (this.afterHandleLavaMovementHooks != null) {
            for (int i = 0; i < this.afterHandleLavaMovementHooks.length; ++i) {
                this.afterHandleLavaMovementHooks[i].afterHandleLavaMovement();
            }
        }
        return n != 0;
    }

    protected ClientPlayerBase GetOverwrittenHandleLavaMovement(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideHandleLavaMovementHooks.length; ++i) {
            if (this.overrideHandleLavaMovementHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideHandleLavaMovementHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean handleWaterMovement(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isHandleWaterMovementModded ? clientPlayerAPI.handleWaterMovement() : iClientPlayerAPI.localHandleWaterMovement();
        return bl;
    }

    private boolean handleWaterMovement() {
        int n;
        if (this.beforeHandleWaterMovementHooks != null) {
            for (n = this.beforeHandleWaterMovementHooks.length - 1; n >= 0; --n) {
                this.beforeHandleWaterMovementHooks[n].beforeHandleWaterMovement();
            }
        }
        n = this.overrideHandleWaterMovementHooks != null ? this.overrideHandleWaterMovementHooks[this.overrideHandleWaterMovementHooks.length - 1].handleWaterMovement() : (int)(this.player.localHandleWaterMovement() ? 1 : 0);
        if (this.afterHandleWaterMovementHooks != null) {
            for (int i = 0; i < this.afterHandleWaterMovementHooks.length; ++i) {
                this.afterHandleWaterMovementHooks[i].afterHandleWaterMovement();
            }
        }
        return n != 0;
    }

    protected ClientPlayerBase GetOverwrittenHandleWaterMovement(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideHandleWaterMovementHooks.length; ++i) {
            if (this.overrideHandleWaterMovementHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideHandleWaterMovementHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void heal(IClientPlayerAPI iClientPlayerAPI, float f) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isHealModded) {
            clientPlayerAPI.heal(f);
        } else {
            iClientPlayerAPI.localHeal(f);
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

    protected ClientPlayerBase GetOverwrittenHeal(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideHealHooks.length; ++i) {
            if (this.overrideHealHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideHealHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean isEntityInsideOpaqueBlock(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isIsEntityInsideOpaqueBlockModded ? clientPlayerAPI.isEntityInsideOpaqueBlock() : iClientPlayerAPI.localIsEntityInsideOpaqueBlock();
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

    protected ClientPlayerBase GetOverwrittenIsEntityInsideOpaqueBlock(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideIsEntityInsideOpaqueBlockHooks.length; ++i) {
            if (this.overrideIsEntityInsideOpaqueBlockHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsEntityInsideOpaqueBlockHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean isInWater(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isIsInWaterModded ? clientPlayerAPI.isInWater() : iClientPlayerAPI.localIsInWater();
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

    protected ClientPlayerBase GetOverwrittenIsInWater(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideIsInWaterHooks.length; ++i) {
            if (this.overrideIsInWaterHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsInWaterHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean isInsideOfMaterial(IClientPlayerAPI iClientPlayerAPI, tflj tflj2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isIsInsideOfMaterialModded ? clientPlayerAPI.isInsideOfMaterial(tflj2) : iClientPlayerAPI.localIsInsideOfMaterial(tflj2);
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

    protected ClientPlayerBase GetOverwrittenIsInsideOfMaterial(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideIsInsideOfMaterialHooks.length; ++i) {
            if (this.overrideIsInsideOfMaterialHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsInsideOfMaterialHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean isOnLadder(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isIsOnLadderModded ? clientPlayerAPI.isOnLadder() : iClientPlayerAPI.localIsOnLadder();
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

    protected ClientPlayerBase GetOverwrittenIsOnLadder(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideIsOnLadderHooks.length; ++i) {
            if (this.overrideIsOnLadderHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsOnLadderHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean isPlayerSleeping(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isIsPlayerSleepingModded ? clientPlayerAPI.isPlayerSleeping() : iClientPlayerAPI.localIsPlayerSleeping();
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

    protected ClientPlayerBase GetOverwrittenIsPlayerSleeping(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideIsPlayerSleepingHooks.length; ++i) {
            if (this.overrideIsPlayerSleepingHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsPlayerSleepingHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean isSneaking(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isIsSneakingModded ? clientPlayerAPI.isSneaking() : iClientPlayerAPI.localIsSneaking();
        return bl;
    }

    private boolean isSneaking() {
        int n;
        if (this.beforeIsSneakingHooks != null) {
            for (n = this.beforeIsSneakingHooks.length - 1; n >= 0; --n) {
                this.beforeIsSneakingHooks[n].beforeIsSneaking();
            }
        }
        n = this.overrideIsSneakingHooks != null ? this.overrideIsSneakingHooks[this.overrideIsSneakingHooks.length - 1].isSneaking() : (int)(this.player.localIsSneaking() ? 1 : 0);
        if (this.afterIsSneakingHooks != null) {
            for (int i = 0; i < this.afterIsSneakingHooks.length; ++i) {
                this.afterIsSneakingHooks[i].afterIsSneaking();
            }
        }
        return n != 0;
    }

    protected ClientPlayerBase GetOverwrittenIsSneaking(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideIsSneakingHooks.length; ++i) {
            if (this.overrideIsSneakingHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsSneakingHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean isSprinting(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isIsSprintingModded ? clientPlayerAPI.isSprinting() : iClientPlayerAPI.localIsSprinting();
        return bl;
    }

    private boolean isSprinting() {
        int n;
        if (this.beforeIsSprintingHooks != null) {
            for (n = this.beforeIsSprintingHooks.length - 1; n >= 0; --n) {
                this.beforeIsSprintingHooks[n].beforeIsSprinting();
            }
        }
        n = this.overrideIsSprintingHooks != null ? this.overrideIsSprintingHooks[this.overrideIsSprintingHooks.length - 1].isSprinting() : (int)(this.player.localIsSprinting() ? 1 : 0);
        if (this.afterIsSprintingHooks != null) {
            for (int i = 0; i < this.afterIsSprintingHooks.length; ++i) {
                this.afterIsSprintingHooks[i].afterIsSprinting();
            }
        }
        return n != 0;
    }

    protected ClientPlayerBase GetOverwrittenIsSprinting(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideIsSprintingHooks.length; ++i) {
            if (this.overrideIsSprintingHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideIsSprintingHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void jump(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isJumpModded) {
            clientPlayerAPI.jump();
        } else {
            iClientPlayerAPI.localJump();
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

    protected ClientPlayerBase GetOverwrittenJump(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideJumpHooks.length; ++i) {
            if (this.overrideJumpHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideJumpHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void knockBack(IClientPlayerAPI iClientPlayerAPI, Entity entity, float f, double d, double d2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isKnockBackModded) {
            clientPlayerAPI.knockBack(entity, f, d, d2);
        } else {
            iClientPlayerAPI.localKnockBack(entity, f, d, d2);
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

    protected ClientPlayerBase GetOverwrittenKnockBack(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideKnockBackHooks.length; ++i) {
            if (this.overrideKnockBackHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideKnockBackHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void moveEntity(IClientPlayerAPI iClientPlayerAPI, double d, double d2, double d3) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isMoveEntityModded) {
            clientPlayerAPI.moveEntity(d, d2, d3);
        } else {
            iClientPlayerAPI.localMoveEntity(d, d2, d3);
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

    protected ClientPlayerBase GetOverwrittenMoveEntity(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideMoveEntityHooks.length; ++i) {
            if (this.overrideMoveEntityHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideMoveEntityHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void moveEntityWithHeading(IClientPlayerAPI iClientPlayerAPI, float f, float f2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isMoveEntityWithHeadingModded) {
            clientPlayerAPI.moveEntityWithHeading(f, f2);
        } else {
            iClientPlayerAPI.localMoveEntityWithHeading(f, f2);
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

    protected ClientPlayerBase GetOverwrittenMoveEntityWithHeading(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideMoveEntityWithHeadingHooks.length; ++i) {
            if (this.overrideMoveEntityWithHeadingHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideMoveEntityWithHeadingHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void moveFlying(IClientPlayerAPI iClientPlayerAPI, float f, float f2, float f3) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isMoveFlyingModded) {
            clientPlayerAPI.moveFlying(f, f2, f3);
        } else {
            iClientPlayerAPI.localMoveFlying(f, f2, f3);
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

    protected ClientPlayerBase GetOverwrittenMoveFlying(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideMoveFlyingHooks.length; ++i) {
            if (this.overrideMoveFlyingHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideMoveFlyingHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void onDeath(IClientPlayerAPI iClientPlayerAPI, jxtc jxtc2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isOnDeathModded) {
            clientPlayerAPI.onDeath(jxtc2);
        } else {
            iClientPlayerAPI.localOnDeath(jxtc2);
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

    protected ClientPlayerBase GetOverwrittenOnDeath(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideOnDeathHooks.length; ++i) {
            if (this.overrideOnDeathHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideOnDeathHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void onLivingUpdate(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isOnLivingUpdateModded) {
            clientPlayerAPI.onLivingUpdate();
        } else {
            iClientPlayerAPI.localOnLivingUpdate();
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

    protected ClientPlayerBase GetOverwrittenOnLivingUpdate(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideOnLivingUpdateHooks.length; ++i) {
            if (this.overrideOnLivingUpdateHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideOnLivingUpdateHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void onKillEntity(IClientPlayerAPI iClientPlayerAPI, EntityLivingBase entityLivingBase) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isOnKillEntityModded) {
            clientPlayerAPI.onKillEntity(entityLivingBase);
        } else {
            iClientPlayerAPI.localOnKillEntity(entityLivingBase);
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

    protected ClientPlayerBase GetOverwrittenOnKillEntity(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideOnKillEntityHooks.length; ++i) {
            if (this.overrideOnKillEntityHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideOnKillEntityHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void onStruckByLightning(IClientPlayerAPI iClientPlayerAPI, EntityLightningBolt entityLightningBolt) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isOnStruckByLightningModded) {
            clientPlayerAPI.onStruckByLightning(entityLightningBolt);
        } else {
            iClientPlayerAPI.localOnStruckByLightning(entityLightningBolt);
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

    protected ClientPlayerBase GetOverwrittenOnStruckByLightning(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideOnStruckByLightningHooks.length; ++i) {
            if (this.overrideOnStruckByLightningHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideOnStruckByLightningHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void onUpdate(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isOnUpdateModded) {
            clientPlayerAPI.onUpdate();
        } else {
            iClientPlayerAPI.localOnUpdate();
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

    protected ClientPlayerBase GetOverwrittenOnUpdate(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideOnUpdateHooks.length; ++i) {
            if (this.overrideOnUpdateHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideOnUpdateHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void playStepSound(IClientPlayerAPI iClientPlayerAPI, int n, int n2, int n3, int n4) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isPlayStepSoundModded) {
            clientPlayerAPI.playStepSound(n, n2, n3, n4);
        } else {
            iClientPlayerAPI.localPlayStepSound(n, n2, n3, n4);
        }
    }

    private void playStepSound(int n, int n2, int n3, int n4) {
        int n5;
        if (this.beforePlayStepSoundHooks != null) {
            for (n5 = this.beforePlayStepSoundHooks.length - 1; n5 >= 0; --n5) {
                this.beforePlayStepSoundHooks[n5].beforePlayStepSound(n, n2, n3, n4);
            }
        }
        if (this.overridePlayStepSoundHooks != null) {
            this.overridePlayStepSoundHooks[this.overridePlayStepSoundHooks.length - 1].playStepSound(n, n2, n3, n4);
        } else {
            this.player.localPlayStepSound(n, n2, n3, n4);
        }
        if (this.afterPlayStepSoundHooks != null) {
            for (n5 = 0; n5 < this.afterPlayStepSoundHooks.length; ++n5) {
                this.afterPlayStepSoundHooks[n5].afterPlayStepSound(n, n2, n3, n4);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenPlayStepSound(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overridePlayStepSoundHooks.length; ++i) {
            if (this.overridePlayStepSoundHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overridePlayStepSoundHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static boolean pushOutOfBlocks(IClientPlayerAPI iClientPlayerAPI, double d, double d2, double d3) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        boolean bl = clientPlayerAPI != null && clientPlayerAPI.isPushOutOfBlocksModded ? clientPlayerAPI.pushOutOfBlocks(d, d2, d3) : iClientPlayerAPI.localPushOutOfBlocks(d, d2, d3);
        return bl;
    }

    private boolean pushOutOfBlocks(double d, double d2, double d3) {
        int n;
        if (this.beforePushOutOfBlocksHooks != null) {
            for (n = this.beforePushOutOfBlocksHooks.length - 1; n >= 0; --n) {
                this.beforePushOutOfBlocksHooks[n].beforePushOutOfBlocks(d, d2, d3);
            }
        }
        n = this.overridePushOutOfBlocksHooks != null ? this.overridePushOutOfBlocksHooks[this.overridePushOutOfBlocksHooks.length - 1].pushOutOfBlocks(d, d2, d3) : (int)(this.player.localPushOutOfBlocks(d, d2, d3) ? 1 : 0);
        if (this.afterPushOutOfBlocksHooks != null) {
            for (int i = 0; i < this.afterPushOutOfBlocksHooks.length; ++i) {
                this.afterPushOutOfBlocksHooks[i].afterPushOutOfBlocks(d, d2, d3);
            }
        }
        return n != 0;
    }

    protected ClientPlayerBase GetOverwrittenPushOutOfBlocks(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overridePushOutOfBlocksHooks.length; ++i) {
            if (this.overridePushOutOfBlocksHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overridePushOutOfBlocksHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static hank rayTrace(IClientPlayerAPI iClientPlayerAPI, double d, float f) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        hank hank2 = clientPlayerAPI != null && clientPlayerAPI.isRayTraceModded ? clientPlayerAPI.rayTrace(d, f) : iClientPlayerAPI.localRayTrace(d, f);
        return hank2;
    }

    private hank rayTrace(double d, float f) {
        if (this.beforeRayTraceHooks != null) {
            for (int i = this.beforeRayTraceHooks.length - 1; i >= 0; --i) {
                this.beforeRayTraceHooks[i].beforeRayTrace(d, f);
            }
        }
        hank hank2 = this.overrideRayTraceHooks != null ? this.overrideRayTraceHooks[this.overrideRayTraceHooks.length - 1].rayTrace(d, f) : this.player.localRayTrace(d, f);
        if (this.afterRayTraceHooks != null) {
            for (int i = 0; i < this.afterRayTraceHooks.length; ++i) {
                this.afterRayTraceHooks[i].afterRayTrace(d, f);
            }
        }
        return hank2;
    }

    protected ClientPlayerBase GetOverwrittenRayTrace(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideRayTraceHooks.length; ++i) {
            if (this.overrideRayTraceHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRayTraceHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void readEntityFromNBT(IClientPlayerAPI iClientPlayerAPI, qoac qoac2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isReadEntityFromNBTModded) {
            clientPlayerAPI.readEntityFromNBT(qoac2);
        } else {
            iClientPlayerAPI.localReadEntityFromNBT(qoac2);
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

    protected ClientPlayerBase GetOverwrittenReadEntityFromNBT(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideReadEntityFromNBTHooks.length; ++i) {
            if (this.overrideReadEntityFromNBTHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideReadEntityFromNBTHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void respawnPlayer(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isRespawnPlayerModded) {
            clientPlayerAPI.respawnPlayer();
        } else {
            iClientPlayerAPI.localRespawnPlayer();
        }
    }

    private void respawnPlayer() {
        int n;
        if (this.beforeRespawnPlayerHooks != null) {
            for (n = this.beforeRespawnPlayerHooks.length - 1; n >= 0; --n) {
                this.beforeRespawnPlayerHooks[n].beforeRespawnPlayer();
            }
        }
        if (this.overrideRespawnPlayerHooks != null) {
            this.overrideRespawnPlayerHooks[this.overrideRespawnPlayerHooks.length - 1].respawnPlayer();
        } else {
            this.player.localRespawnPlayer();
        }
        if (this.afterRespawnPlayerHooks != null) {
            for (n = 0; n < this.afterRespawnPlayerHooks.length; ++n) {
                this.afterRespawnPlayerHooks[n].afterRespawnPlayer();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenRespawnPlayer(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideRespawnPlayerHooks.length; ++i) {
            if (this.overrideRespawnPlayerHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRespawnPlayerHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void setDead(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isSetDeadModded) {
            clientPlayerAPI.setDead();
        } else {
            iClientPlayerAPI.localSetDead();
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

    protected ClientPlayerBase GetOverwrittenSetDead(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideSetDeadHooks.length; ++i) {
            if (this.overrideSetDeadHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetDeadHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void setPlayerSPHealth(IClientPlayerAPI iClientPlayerAPI, float f) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isSetPlayerSPHealthModded) {
            clientPlayerAPI.setPlayerSPHealth(f);
        } else {
            iClientPlayerAPI.localSetPlayerSPHealth(f);
        }
    }

    private void setPlayerSPHealth(float f) {
        int n;
        if (this.beforeSetPlayerSPHealthHooks != null) {
            for (n = this.beforeSetPlayerSPHealthHooks.length - 1; n >= 0; --n) {
                this.beforeSetPlayerSPHealthHooks[n].beforeSetPlayerSPHealth(f);
            }
        }
        if (this.overrideSetPlayerSPHealthHooks != null) {
            this.overrideSetPlayerSPHealthHooks[this.overrideSetPlayerSPHealthHooks.length - 1].setPlayerSPHealth(f);
        } else {
            this.player.localSetPlayerSPHealth(f);
        }
        if (this.afterSetPlayerSPHealthHooks != null) {
            for (n = 0; n < this.afterSetPlayerSPHealthHooks.length; ++n) {
                this.afterSetPlayerSPHealthHooks[n].afterSetPlayerSPHealth(f);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenSetPlayerSPHealth(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideSetPlayerSPHealthHooks.length; ++i) {
            if (this.overrideSetPlayerSPHealthHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetPlayerSPHealthHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void setPositionAndRotation(IClientPlayerAPI iClientPlayerAPI, double d, double d2, double d3, float f, float f2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isSetPositionAndRotationModded) {
            clientPlayerAPI.setPositionAndRotation(d, d2, d3, f, f2);
        } else {
            iClientPlayerAPI.localSetPositionAndRotation(d, d2, d3, f, f2);
        }
    }

    private void setPositionAndRotation(double d, double d2, double d3, float f, float f2) {
        int n;
        if (this.beforeSetPositionAndRotationHooks != null) {
            for (n = this.beforeSetPositionAndRotationHooks.length - 1; n >= 0; --n) {
                this.beforeSetPositionAndRotationHooks[n].beforeSetPositionAndRotation(d, d2, d3, f, f2);
            }
        }
        if (this.overrideSetPositionAndRotationHooks != null) {
            this.overrideSetPositionAndRotationHooks[this.overrideSetPositionAndRotationHooks.length - 1].setPositionAndRotation(d, d2, d3, f, f2);
        } else {
            this.player.localSetPositionAndRotation(d, d2, d3, f, f2);
        }
        if (this.afterSetPositionAndRotationHooks != null) {
            for (n = 0; n < this.afterSetPositionAndRotationHooks.length; ++n) {
                this.afterSetPositionAndRotationHooks[n].afterSetPositionAndRotation(d, d2, d3, f, f2);
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenSetPositionAndRotation(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideSetPositionAndRotationHooks.length; ++i) {
            if (this.overrideSetPositionAndRotationHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetPositionAndRotationHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static pidb sleepInBedAt(IClientPlayerAPI iClientPlayerAPI, int n, int n2, int n3) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        pidb pidb2 = clientPlayerAPI != null && clientPlayerAPI.isSleepInBedAtModded ? clientPlayerAPI.sleepInBedAt(n, n2, n3) : iClientPlayerAPI.localSleepInBedAt(n, n2, n3);
        return pidb2;
    }

    private pidb sleepInBedAt(int n, int n2, int n3) {
        if (this.beforeSleepInBedAtHooks != null) {
            for (int i = this.beforeSleepInBedAtHooks.length - 1; i >= 0; --i) {
                this.beforeSleepInBedAtHooks[i].beforeSleepInBedAt(n, n2, n3);
            }
        }
        pidb pidb2 = this.overrideSleepInBedAtHooks != null ? this.overrideSleepInBedAtHooks[this.overrideSleepInBedAtHooks.length - 1].sleepInBedAt(n, n2, n3) : this.player.localSleepInBedAt(n, n2, n3);
        if (this.afterSleepInBedAtHooks != null) {
            for (int i = 0; i < this.afterSleepInBedAtHooks.length; ++i) {
                this.afterSleepInBedAtHooks[i].afterSleepInBedAt(n, n2, n3);
            }
        }
        return pidb2;
    }

    protected ClientPlayerBase GetOverwrittenSleepInBedAt(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideSleepInBedAtHooks.length; ++i) {
            if (this.overrideSleepInBedAtHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSleepInBedAtHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void swingItem(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isSwingItemModded) {
            clientPlayerAPI.swingItem();
        } else {
            iClientPlayerAPI.localSwingItem();
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

    protected ClientPlayerBase GetOverwrittenSwingItem(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideSwingItemHooks.length; ++i) {
            if (this.overrideSwingItemHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSwingItemHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void updateEntityActionState(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isUpdateEntityActionStateModded) {
            clientPlayerAPI.updateEntityActionState();
        } else {
            iClientPlayerAPI.localUpdateEntityActionState();
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

    protected ClientPlayerBase GetOverwrittenUpdateEntityActionState(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideUpdateEntityActionStateHooks.length; ++i) {
            if (this.overrideUpdateEntityActionStateHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideUpdateEntityActionStateHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void updateRidden(IClientPlayerAPI iClientPlayerAPI) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isUpdateRiddenModded) {
            clientPlayerAPI.updateRidden();
        } else {
            iClientPlayerAPI.localUpdateRidden();
        }
    }

    private void updateRidden() {
        int n;
        if (this.beforeUpdateRiddenHooks != null) {
            for (n = this.beforeUpdateRiddenHooks.length - 1; n >= 0; --n) {
                this.beforeUpdateRiddenHooks[n].beforeUpdateRidden();
            }
        }
        if (this.overrideUpdateRiddenHooks != null) {
            this.overrideUpdateRiddenHooks[this.overrideUpdateRiddenHooks.length - 1].updateRidden();
        } else {
            this.player.localUpdateRidden();
        }
        if (this.afterUpdateRiddenHooks != null) {
            for (n = 0; n < this.afterUpdateRiddenHooks.length; ++n) {
                this.afterUpdateRiddenHooks[n].afterUpdateRidden();
            }
        }
    }

    protected ClientPlayerBase GetOverwrittenUpdateRidden(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideUpdateRiddenHooks.length; ++i) {
            if (this.overrideUpdateRiddenHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideUpdateRiddenHooks[i - 1];
        }
        return clientPlayerBase;
    }

    public static void writeEntityToNBT(IClientPlayerAPI iClientPlayerAPI, qoac qoac2) {
        ClientPlayerAPI clientPlayerAPI = iClientPlayerAPI.getClientPlayerAPI();
        if (clientPlayerAPI != null && clientPlayerAPI.isWriteEntityToNBTModded) {
            clientPlayerAPI.writeEntityToNBT(qoac2);
        } else {
            iClientPlayerAPI.localWriteEntityToNBT(qoac2);
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

    protected ClientPlayerBase GetOverwrittenWriteEntityToNBT(ClientPlayerBase clientPlayerBase) {
        for (int i = 0; i < this.overrideWriteEntityToNBTHooks.length; ++i) {
            if (this.overrideWriteEntityToNBTHooks[i] != clientPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideWriteEntityToNBTHooks[i - 1];
        }
        return clientPlayerBase;
    }

    static {
        logger = Logger.getLogger("ClientPlayerAPI");
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
        beforeAddMovementStatHookTypes = new LinkedList<String>();
        overrideAddMovementStatHookTypes = new LinkedList<String>();
        afterAddMovementStatHookTypes = new LinkedList<String>();
        allBaseBeforeAddMovementStatSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeAddMovementStatInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddMovementStatSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddMovementStatInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddMovementStatSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddMovementStatInferiors = new Hashtable<String, String[]>(0);
        beforeAddStatHookTypes = new LinkedList<String>();
        overrideAddStatHookTypes = new LinkedList<String>();
        afterAddStatHookTypes = new LinkedList<String>();
        allBaseBeforeAddStatSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeAddStatInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddStatSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideAddStatInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddStatSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterAddStatInferiors = new Hashtable<String, String[]>(0);
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
        beforeCanBreatheUnderwaterHookTypes = new LinkedList<String>();
        overrideCanBreatheUnderwaterHookTypes = new LinkedList<String>();
        afterCanBreatheUnderwaterHookTypes = new LinkedList<String>();
        allBaseBeforeCanBreatheUnderwaterSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeCanBreatheUnderwaterInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideCanBreatheUnderwaterSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideCanBreatheUnderwaterInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterCanBreatheUnderwaterSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterCanBreatheUnderwaterInferiors = new Hashtable<String, String[]>(0);
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
        beforeCloseScreenHookTypes = new LinkedList<String>();
        overrideCloseScreenHookTypes = new LinkedList<String>();
        afterCloseScreenHookTypes = new LinkedList<String>();
        allBaseBeforeCloseScreenSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeCloseScreenInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideCloseScreenSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideCloseScreenInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterCloseScreenSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterCloseScreenInferiors = new Hashtable<String, String[]>(0);
        beforeDamageEntityHookTypes = new LinkedList<String>();
        overrideDamageEntityHookTypes = new LinkedList<String>();
        afterDamageEntityHookTypes = new LinkedList<String>();
        allBaseBeforeDamageEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDamageEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDamageEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDamageEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDamageEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDamageEntityInferiors = new Hashtable<String, String[]>(0);
        beforeDisplayGUIBrewingStandHookTypes = new LinkedList<String>();
        overrideDisplayGUIBrewingStandHookTypes = new LinkedList<String>();
        afterDisplayGUIBrewingStandHookTypes = new LinkedList<String>();
        allBaseBeforeDisplayGUIBrewingStandSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDisplayGUIBrewingStandInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIBrewingStandSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIBrewingStandInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIBrewingStandSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIBrewingStandInferiors = new Hashtable<String, String[]>(0);
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
        beforeDisplayGUIEditSignHookTypes = new LinkedList<String>();
        overrideDisplayGUIEditSignHookTypes = new LinkedList<String>();
        afterDisplayGUIEditSignHookTypes = new LinkedList<String>();
        allBaseBeforeDisplayGUIEditSignSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDisplayGUIEditSignInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIEditSignSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIEditSignInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIEditSignSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIEditSignInferiors = new Hashtable<String, String[]>(0);
        beforeDisplayGUIEnchantmentHookTypes = new LinkedList<String>();
        overrideDisplayGUIEnchantmentHookTypes = new LinkedList<String>();
        afterDisplayGUIEnchantmentHookTypes = new LinkedList<String>();
        allBaseBeforeDisplayGUIEnchantmentSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDisplayGUIEnchantmentInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIEnchantmentSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDisplayGUIEnchantmentInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIEnchantmentSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDisplayGUIEnchantmentInferiors = new Hashtable<String, String[]>(0);
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
        beforeDropPlayerItemWithRandomChoiceHookTypes = new LinkedList<String>();
        overrideDropPlayerItemWithRandomChoiceHookTypes = new LinkedList<String>();
        afterDropPlayerItemWithRandomChoiceHookTypes = new LinkedList<String>();
        allBaseBeforeDropPlayerItemWithRandomChoiceSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDropPlayerItemWithRandomChoiceInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDropPlayerItemWithRandomChoiceSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDropPlayerItemWithRandomChoiceInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDropPlayerItemWithRandomChoiceSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDropPlayerItemWithRandomChoiceInferiors = new Hashtable<String, String[]>(0);
        beforeFallHookTypes = new LinkedList<String>();
        overrideFallHookTypes = new LinkedList<String>();
        afterFallHookTypes = new LinkedList<String>();
        allBaseBeforeFallSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeFallInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideFallSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideFallInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterFallSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterFallInferiors = new Hashtable<String, String[]>(0);
        beforeGetBrightnessHookTypes = new LinkedList<String>();
        overrideGetBrightnessHookTypes = new LinkedList<String>();
        afterGetBrightnessHookTypes = new LinkedList<String>();
        allBaseBeforeGetBrightnessSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetBrightnessInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetBrightnessSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetBrightnessInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetBrightnessSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetBrightnessInferiors = new Hashtable<String, String[]>(0);
        beforeGetBrightnessForRenderHookTypes = new LinkedList<String>();
        overrideGetBrightnessForRenderHookTypes = new LinkedList<String>();
        afterGetBrightnessForRenderHookTypes = new LinkedList<String>();
        allBaseBeforeGetBrightnessForRenderSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetBrightnessForRenderInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetBrightnessForRenderSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetBrightnessForRenderInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetBrightnessForRenderSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetBrightnessForRenderInferiors = new Hashtable<String, String[]>(0);
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
        beforeGetDistanceSqToEntityHookTypes = new LinkedList<String>();
        overrideGetDistanceSqToEntityHookTypes = new LinkedList<String>();
        afterGetDistanceSqToEntityHookTypes = new LinkedList<String>();
        allBaseBeforeGetDistanceSqToEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetDistanceSqToEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetDistanceSqToEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetDistanceSqToEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetDistanceSqToEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetDistanceSqToEntityInferiors = new Hashtable<String, String[]>(0);
        beforeGetFOVMultiplierHookTypes = new LinkedList<String>();
        overrideGetFOVMultiplierHookTypes = new LinkedList<String>();
        afterGetFOVMultiplierHookTypes = new LinkedList<String>();
        allBaseBeforeGetFOVMultiplierSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetFOVMultiplierInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetFOVMultiplierSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetFOVMultiplierInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetFOVMultiplierSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetFOVMultiplierInferiors = new Hashtable<String, String[]>(0);
        beforeGetHurtSoundHookTypes = new LinkedList<String>();
        overrideGetHurtSoundHookTypes = new LinkedList<String>();
        afterGetHurtSoundHookTypes = new LinkedList<String>();
        allBaseBeforeGetHurtSoundSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetHurtSoundInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetHurtSoundSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetHurtSoundInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetHurtSoundSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetHurtSoundInferiors = new Hashtable<String, String[]>(0);
        beforeGetItemIconHookTypes = new LinkedList<String>();
        overrideGetItemIconHookTypes = new LinkedList<String>();
        afterGetItemIconHookTypes = new LinkedList<String>();
        allBaseBeforeGetItemIconSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetItemIconInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetItemIconSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetItemIconInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetItemIconSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetItemIconInferiors = new Hashtable<String, String[]>(0);
        beforeGetSleepTimerHookTypes = new LinkedList<String>();
        overrideGetSleepTimerHookTypes = new LinkedList<String>();
        afterGetSleepTimerHookTypes = new LinkedList<String>();
        allBaseBeforeGetSleepTimerSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetSleepTimerInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetSleepTimerSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetSleepTimerInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetSleepTimerSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetSleepTimerInferiors = new Hashtable<String, String[]>(0);
        beforeHandleLavaMovementHookTypes = new LinkedList<String>();
        overrideHandleLavaMovementHookTypes = new LinkedList<String>();
        afterHandleLavaMovementHookTypes = new LinkedList<String>();
        allBaseBeforeHandleLavaMovementSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeHandleLavaMovementInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideHandleLavaMovementSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideHandleLavaMovementInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterHandleLavaMovementSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterHandleLavaMovementInferiors = new Hashtable<String, String[]>(0);
        beforeHandleWaterMovementHookTypes = new LinkedList<String>();
        overrideHandleWaterMovementHookTypes = new LinkedList<String>();
        afterHandleWaterMovementHookTypes = new LinkedList<String>();
        allBaseBeforeHandleWaterMovementSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeHandleWaterMovementInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideHandleWaterMovementSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideHandleWaterMovementInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterHandleWaterMovementSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterHandleWaterMovementInferiors = new Hashtable<String, String[]>(0);
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
        beforeIsSneakingHookTypes = new LinkedList<String>();
        overrideIsSneakingHookTypes = new LinkedList<String>();
        afterIsSneakingHookTypes = new LinkedList<String>();
        allBaseBeforeIsSneakingSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeIsSneakingInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsSneakingSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsSneakingInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsSneakingSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsSneakingInferiors = new Hashtable<String, String[]>(0);
        beforeIsSprintingHookTypes = new LinkedList<String>();
        overrideIsSprintingHookTypes = new LinkedList<String>();
        afterIsSprintingHookTypes = new LinkedList<String>();
        allBaseBeforeIsSprintingSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeIsSprintingInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsSprintingSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideIsSprintingInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsSprintingSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterIsSprintingInferiors = new Hashtable<String, String[]>(0);
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
        beforePlayStepSoundHookTypes = new LinkedList<String>();
        overridePlayStepSoundHookTypes = new LinkedList<String>();
        afterPlayStepSoundHookTypes = new LinkedList<String>();
        allBaseBeforePlayStepSoundSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforePlayStepSoundInferiors = new Hashtable<String, String[]>(0);
        allBaseOverridePlayStepSoundSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverridePlayStepSoundInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterPlayStepSoundSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterPlayStepSoundInferiors = new Hashtable<String, String[]>(0);
        beforePushOutOfBlocksHookTypes = new LinkedList<String>();
        overridePushOutOfBlocksHookTypes = new LinkedList<String>();
        afterPushOutOfBlocksHookTypes = new LinkedList<String>();
        allBaseBeforePushOutOfBlocksSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforePushOutOfBlocksInferiors = new Hashtable<String, String[]>(0);
        allBaseOverridePushOutOfBlocksSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverridePushOutOfBlocksInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterPushOutOfBlocksSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterPushOutOfBlocksInferiors = new Hashtable<String, String[]>(0);
        beforeRayTraceHookTypes = new LinkedList<String>();
        overrideRayTraceHookTypes = new LinkedList<String>();
        afterRayTraceHookTypes = new LinkedList<String>();
        allBaseBeforeRayTraceSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRayTraceInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRayTraceSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRayTraceInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRayTraceSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRayTraceInferiors = new Hashtable<String, String[]>(0);
        beforeReadEntityFromNBTHookTypes = new LinkedList<String>();
        overrideReadEntityFromNBTHookTypes = new LinkedList<String>();
        afterReadEntityFromNBTHookTypes = new LinkedList<String>();
        allBaseBeforeReadEntityFromNBTSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeReadEntityFromNBTInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideReadEntityFromNBTSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideReadEntityFromNBTInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterReadEntityFromNBTSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterReadEntityFromNBTInferiors = new Hashtable<String, String[]>(0);
        beforeRespawnPlayerHookTypes = new LinkedList<String>();
        overrideRespawnPlayerHookTypes = new LinkedList<String>();
        afterRespawnPlayerHookTypes = new LinkedList<String>();
        allBaseBeforeRespawnPlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRespawnPlayerInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRespawnPlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRespawnPlayerInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRespawnPlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRespawnPlayerInferiors = new Hashtable<String, String[]>(0);
        beforeSetDeadHookTypes = new LinkedList<String>();
        overrideSetDeadHookTypes = new LinkedList<String>();
        afterSetDeadHookTypes = new LinkedList<String>();
        allBaseBeforeSetDeadSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetDeadInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetDeadSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetDeadInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetDeadSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetDeadInferiors = new Hashtable<String, String[]>(0);
        beforeSetPlayerSPHealthHookTypes = new LinkedList<String>();
        overrideSetPlayerSPHealthHookTypes = new LinkedList<String>();
        afterSetPlayerSPHealthHookTypes = new LinkedList<String>();
        allBaseBeforeSetPlayerSPHealthSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetPlayerSPHealthInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetPlayerSPHealthSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetPlayerSPHealthInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetPlayerSPHealthSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetPlayerSPHealthInferiors = new Hashtable<String, String[]>(0);
        beforeSetPositionAndRotationHookTypes = new LinkedList<String>();
        overrideSetPositionAndRotationHookTypes = new LinkedList<String>();
        afterSetPositionAndRotationHookTypes = new LinkedList<String>();
        allBaseBeforeSetPositionAndRotationSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetPositionAndRotationInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetPositionAndRotationSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetPositionAndRotationInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetPositionAndRotationSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetPositionAndRotationInferiors = new Hashtable<String, String[]>(0);
        beforeSleepInBedAtHookTypes = new LinkedList<String>();
        overrideSleepInBedAtHookTypes = new LinkedList<String>();
        afterSleepInBedAtHookTypes = new LinkedList<String>();
        allBaseBeforeSleepInBedAtSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSleepInBedAtInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSleepInBedAtSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSleepInBedAtInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSleepInBedAtSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSleepInBedAtInferiors = new Hashtable<String, String[]>(0);
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
        beforeUpdateRiddenHookTypes = new LinkedList<String>();
        overrideUpdateRiddenHookTypes = new LinkedList<String>();
        afterUpdateRiddenHookTypes = new LinkedList<String>();
        allBaseBeforeUpdateRiddenSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeUpdateRiddenInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideUpdateRiddenSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideUpdateRiddenInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterUpdateRiddenSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterUpdateRiddenInferiors = new Hashtable<String, String[]>(0);
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

