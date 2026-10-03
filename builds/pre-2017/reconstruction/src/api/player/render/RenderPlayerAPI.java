/*
 * Decompiled with CFR 0.152.
 */
package api.player.render;

import api.player.render.RenderPlayerBase;
import api.player.render.RenderPlayerBaseSorter;
import api.player.render.RenderPlayerBaseSorting;
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
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public final class RenderPlayerAPI {
    private static final Class<?>[] Class = new Class[]{RenderPlayerAPI.class};
    private static final Class<?>[] Classes = new Class[]{RenderPlayerAPI.class, String.class};
    private static boolean isCreated;
    private static final Logger logger;
    private static final Map<String, String[]> EmptySortMap;
    private static final Object[] initializer;
    private static final Object[] initializers;
    private static final List<String> beforeDoRenderLabelHookTypes;
    private static final List<String> overrideDoRenderLabelHookTypes;
    private static final List<String> afterDoRenderLabelHookTypes;
    private RenderPlayerBase[] beforeDoRenderLabelHooks;
    private RenderPlayerBase[] overrideDoRenderLabelHooks;
    private RenderPlayerBase[] afterDoRenderLabelHooks;
    public boolean isDoRenderLabelModded;
    private static final Map<String, String[]> allBaseBeforeDoRenderLabelSuperiors;
    private static final Map<String, String[]> allBaseBeforeDoRenderLabelInferiors;
    private static final Map<String, String[]> allBaseOverrideDoRenderLabelSuperiors;
    private static final Map<String, String[]> allBaseOverrideDoRenderLabelInferiors;
    private static final Map<String, String[]> allBaseAfterDoRenderLabelSuperiors;
    private static final Map<String, String[]> allBaseAfterDoRenderLabelInferiors;
    private static final List<String> beforeDoRenderShadowAndFireHookTypes;
    private static final List<String> overrideDoRenderShadowAndFireHookTypes;
    private static final List<String> afterDoRenderShadowAndFireHookTypes;
    private RenderPlayerBase[] beforeDoRenderShadowAndFireHooks;
    private RenderPlayerBase[] overrideDoRenderShadowAndFireHooks;
    private RenderPlayerBase[] afterDoRenderShadowAndFireHooks;
    public boolean isDoRenderShadowAndFireModded;
    private static final Map<String, String[]> allBaseBeforeDoRenderShadowAndFireSuperiors;
    private static final Map<String, String[]> allBaseBeforeDoRenderShadowAndFireInferiors;
    private static final Map<String, String[]> allBaseOverrideDoRenderShadowAndFireSuperiors;
    private static final Map<String, String[]> allBaseOverrideDoRenderShadowAndFireInferiors;
    private static final Map<String, String[]> allBaseAfterDoRenderShadowAndFireSuperiors;
    private static final Map<String, String[]> allBaseAfterDoRenderShadowAndFireInferiors;
    private static final List<String> beforeGetColorMultiplierHookTypes;
    private static final List<String> overrideGetColorMultiplierHookTypes;
    private static final List<String> afterGetColorMultiplierHookTypes;
    private RenderPlayerBase[] beforeGetColorMultiplierHooks;
    private RenderPlayerBase[] overrideGetColorMultiplierHooks;
    private RenderPlayerBase[] afterGetColorMultiplierHooks;
    public boolean isGetColorMultiplierModded;
    private static final Map<String, String[]> allBaseBeforeGetColorMultiplierSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetColorMultiplierInferiors;
    private static final Map<String, String[]> allBaseOverrideGetColorMultiplierSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetColorMultiplierInferiors;
    private static final Map<String, String[]> allBaseAfterGetColorMultiplierSuperiors;
    private static final Map<String, String[]> allBaseAfterGetColorMultiplierInferiors;
    private static final List<String> beforeGetDeathMaxRotationHookTypes;
    private static final List<String> overrideGetDeathMaxRotationHookTypes;
    private static final List<String> afterGetDeathMaxRotationHookTypes;
    private RenderPlayerBase[] beforeGetDeathMaxRotationHooks;
    private RenderPlayerBase[] overrideGetDeathMaxRotationHooks;
    private RenderPlayerBase[] afterGetDeathMaxRotationHooks;
    public boolean isGetDeathMaxRotationModded;
    private static final Map<String, String[]> allBaseBeforeGetDeathMaxRotationSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetDeathMaxRotationInferiors;
    private static final Map<String, String[]> allBaseOverrideGetDeathMaxRotationSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetDeathMaxRotationInferiors;
    private static final Map<String, String[]> allBaseAfterGetDeathMaxRotationSuperiors;
    private static final Map<String, String[]> allBaseAfterGetDeathMaxRotationInferiors;
    private static final List<String> beforeGetFontRendererFromRenderManagerHookTypes;
    private static final List<String> overrideGetFontRendererFromRenderManagerHookTypes;
    private static final List<String> afterGetFontRendererFromRenderManagerHookTypes;
    private RenderPlayerBase[] beforeGetFontRendererFromRenderManagerHooks;
    private RenderPlayerBase[] overrideGetFontRendererFromRenderManagerHooks;
    private RenderPlayerBase[] afterGetFontRendererFromRenderManagerHooks;
    public boolean isGetFontRendererFromRenderManagerModded;
    private static final Map<String, String[]> allBaseBeforeGetFontRendererFromRenderManagerSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetFontRendererFromRenderManagerInferiors;
    private static final Map<String, String[]> allBaseOverrideGetFontRendererFromRenderManagerSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetFontRendererFromRenderManagerInferiors;
    private static final Map<String, String[]> allBaseAfterGetFontRendererFromRenderManagerSuperiors;
    private static final Map<String, String[]> allBaseAfterGetFontRendererFromRenderManagerInferiors;
    private static final List<String> beforeGetResourceLocationFromPlayerHookTypes;
    private static final List<String> overrideGetResourceLocationFromPlayerHookTypes;
    private static final List<String> afterGetResourceLocationFromPlayerHookTypes;
    private RenderPlayerBase[] beforeGetResourceLocationFromPlayerHooks;
    private RenderPlayerBase[] overrideGetResourceLocationFromPlayerHooks;
    private RenderPlayerBase[] afterGetResourceLocationFromPlayerHooks;
    public boolean isGetResourceLocationFromPlayerModded;
    private static final Map<String, String[]> allBaseBeforeGetResourceLocationFromPlayerSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetResourceLocationFromPlayerInferiors;
    private static final Map<String, String[]> allBaseOverrideGetResourceLocationFromPlayerSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetResourceLocationFromPlayerInferiors;
    private static final Map<String, String[]> allBaseAfterGetResourceLocationFromPlayerSuperiors;
    private static final Map<String, String[]> allBaseAfterGetResourceLocationFromPlayerInferiors;
    private static final List<String> beforeHandleRotationFloatHookTypes;
    private static final List<String> overrideHandleRotationFloatHookTypes;
    private static final List<String> afterHandleRotationFloatHookTypes;
    private RenderPlayerBase[] beforeHandleRotationFloatHooks;
    private RenderPlayerBase[] overrideHandleRotationFloatHooks;
    private RenderPlayerBase[] afterHandleRotationFloatHooks;
    public boolean isHandleRotationFloatModded;
    private static final Map<String, String[]> allBaseBeforeHandleRotationFloatSuperiors;
    private static final Map<String, String[]> allBaseBeforeHandleRotationFloatInferiors;
    private static final Map<String, String[]> allBaseOverrideHandleRotationFloatSuperiors;
    private static final Map<String, String[]> allBaseOverrideHandleRotationFloatInferiors;
    private static final Map<String, String[]> allBaseAfterHandleRotationFloatSuperiors;
    private static final Map<String, String[]> allBaseAfterHandleRotationFloatInferiors;
    private static final List<String> beforeInheritRenderPassHookTypes;
    private static final List<String> overrideInheritRenderPassHookTypes;
    private static final List<String> afterInheritRenderPassHookTypes;
    private RenderPlayerBase[] beforeInheritRenderPassHooks;
    private RenderPlayerBase[] overrideInheritRenderPassHooks;
    private RenderPlayerBase[] afterInheritRenderPassHooks;
    public boolean isInheritRenderPassModded;
    private static final Map<String, String[]> allBaseBeforeInheritRenderPassSuperiors;
    private static final Map<String, String[]> allBaseBeforeInheritRenderPassInferiors;
    private static final Map<String, String[]> allBaseOverrideInheritRenderPassSuperiors;
    private static final Map<String, String[]> allBaseOverrideInheritRenderPassInferiors;
    private static final Map<String, String[]> allBaseAfterInheritRenderPassSuperiors;
    private static final Map<String, String[]> allBaseAfterInheritRenderPassInferiors;
    private static final List<String> beforeLoadTextureHookTypes;
    private static final List<String> overrideLoadTextureHookTypes;
    private static final List<String> afterLoadTextureHookTypes;
    private RenderPlayerBase[] beforeLoadTextureHooks;
    private RenderPlayerBase[] overrideLoadTextureHooks;
    private RenderPlayerBase[] afterLoadTextureHooks;
    public boolean isLoadTextureModded;
    private static final Map<String, String[]> allBaseBeforeLoadTextureSuperiors;
    private static final Map<String, String[]> allBaseBeforeLoadTextureInferiors;
    private static final Map<String, String[]> allBaseOverrideLoadTextureSuperiors;
    private static final Map<String, String[]> allBaseOverrideLoadTextureInferiors;
    private static final Map<String, String[]> allBaseAfterLoadTextureSuperiors;
    private static final Map<String, String[]> allBaseAfterLoadTextureInferiors;
    private static final List<String> beforeLoadTextureOfEntityHookTypes;
    private static final List<String> overrideLoadTextureOfEntityHookTypes;
    private static final List<String> afterLoadTextureOfEntityHookTypes;
    private RenderPlayerBase[] beforeLoadTextureOfEntityHooks;
    private RenderPlayerBase[] overrideLoadTextureOfEntityHooks;
    private RenderPlayerBase[] afterLoadTextureOfEntityHooks;
    public boolean isLoadTextureOfEntityModded;
    private static final Map<String, String[]> allBaseBeforeLoadTextureOfEntitySuperiors;
    private static final Map<String, String[]> allBaseBeforeLoadTextureOfEntityInferiors;
    private static final Map<String, String[]> allBaseOverrideLoadTextureOfEntitySuperiors;
    private static final Map<String, String[]> allBaseOverrideLoadTextureOfEntityInferiors;
    private static final Map<String, String[]> allBaseAfterLoadTextureOfEntitySuperiors;
    private static final Map<String, String[]> allBaseAfterLoadTextureOfEntityInferiors;
    private static final List<String> beforePassSpecialRenderHookTypes;
    private static final List<String> overridePassSpecialRenderHookTypes;
    private static final List<String> afterPassSpecialRenderHookTypes;
    private RenderPlayerBase[] beforePassSpecialRenderHooks;
    private RenderPlayerBase[] overridePassSpecialRenderHooks;
    private RenderPlayerBase[] afterPassSpecialRenderHooks;
    public boolean isPassSpecialRenderModded;
    private static final Map<String, String[]> allBaseBeforePassSpecialRenderSuperiors;
    private static final Map<String, String[]> allBaseBeforePassSpecialRenderInferiors;
    private static final Map<String, String[]> allBaseOverridePassSpecialRenderSuperiors;
    private static final Map<String, String[]> allBaseOverridePassSpecialRenderInferiors;
    private static final Map<String, String[]> allBaseAfterPassSpecialRenderSuperiors;
    private static final Map<String, String[]> allBaseAfterPassSpecialRenderInferiors;
    private static final List<String> beforeRenderArrowsStuckInEntityHookTypes;
    private static final List<String> overrideRenderArrowsStuckInEntityHookTypes;
    private static final List<String> afterRenderArrowsStuckInEntityHookTypes;
    private RenderPlayerBase[] beforeRenderArrowsStuckInEntityHooks;
    private RenderPlayerBase[] overrideRenderArrowsStuckInEntityHooks;
    private RenderPlayerBase[] afterRenderArrowsStuckInEntityHooks;
    public boolean isRenderArrowsStuckInEntityModded;
    private static final Map<String, String[]> allBaseBeforeRenderArrowsStuckInEntitySuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderArrowsStuckInEntityInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderArrowsStuckInEntitySuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderArrowsStuckInEntityInferiors;
    private static final Map<String, String[]> allBaseAfterRenderArrowsStuckInEntitySuperiors;
    private static final Map<String, String[]> allBaseAfterRenderArrowsStuckInEntityInferiors;
    private static final List<String> beforeRenderFirstPersonArmHookTypes;
    private static final List<String> overrideRenderFirstPersonArmHookTypes;
    private static final List<String> afterRenderFirstPersonArmHookTypes;
    private RenderPlayerBase[] beforeRenderFirstPersonArmHooks;
    private RenderPlayerBase[] overrideRenderFirstPersonArmHooks;
    private RenderPlayerBase[] afterRenderFirstPersonArmHooks;
    public boolean isRenderFirstPersonArmModded;
    private static final Map<String, String[]> allBaseBeforeRenderFirstPersonArmSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderFirstPersonArmInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderFirstPersonArmSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderFirstPersonArmInferiors;
    private static final Map<String, String[]> allBaseAfterRenderFirstPersonArmSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderFirstPersonArmInferiors;
    private static final List<String> beforeRenderLivingLabelHookTypes;
    private static final List<String> overrideRenderLivingLabelHookTypes;
    private static final List<String> afterRenderLivingLabelHookTypes;
    private RenderPlayerBase[] beforeRenderLivingLabelHooks;
    private RenderPlayerBase[] overrideRenderLivingLabelHooks;
    private RenderPlayerBase[] afterRenderLivingLabelHooks;
    public boolean isRenderLivingLabelModded;
    private static final Map<String, String[]> allBaseBeforeRenderLivingLabelSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderLivingLabelInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderLivingLabelSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderLivingLabelInferiors;
    private static final Map<String, String[]> allBaseAfterRenderLivingLabelSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderLivingLabelInferiors;
    private static final List<String> beforeRenderModelHookTypes;
    private static final List<String> overrideRenderModelHookTypes;
    private static final List<String> afterRenderModelHookTypes;
    private RenderPlayerBase[] beforeRenderModelHooks;
    private RenderPlayerBase[] overrideRenderModelHooks;
    private RenderPlayerBase[] afterRenderModelHooks;
    public boolean isRenderModelModded;
    private static final Map<String, String[]> allBaseBeforeRenderModelSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderModelInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderModelSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderModelInferiors;
    private static final Map<String, String[]> allBaseAfterRenderModelSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderModelInferiors;
    private static final List<String> beforeRenderPlayerHookTypes;
    private static final List<String> overrideRenderPlayerHookTypes;
    private static final List<String> afterRenderPlayerHookTypes;
    private RenderPlayerBase[] beforeRenderPlayerHooks;
    private RenderPlayerBase[] overrideRenderPlayerHooks;
    private RenderPlayerBase[] afterRenderPlayerHooks;
    public boolean isRenderPlayerModded;
    private static final Map<String, String[]> allBaseBeforeRenderPlayerSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderPlayerInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderPlayerSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderPlayerInferiors;
    private static final Map<String, String[]> allBaseAfterRenderPlayerSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderPlayerInferiors;
    private static final List<String> beforeRenderPlayerNameAndScoreLabelHookTypes;
    private static final List<String> overrideRenderPlayerNameAndScoreLabelHookTypes;
    private static final List<String> afterRenderPlayerNameAndScoreLabelHookTypes;
    private RenderPlayerBase[] beforeRenderPlayerNameAndScoreLabelHooks;
    private RenderPlayerBase[] overrideRenderPlayerNameAndScoreLabelHooks;
    private RenderPlayerBase[] afterRenderPlayerNameAndScoreLabelHooks;
    public boolean isRenderPlayerNameAndScoreLabelModded;
    private static final Map<String, String[]> allBaseBeforeRenderPlayerNameAndScoreLabelSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderPlayerNameAndScoreLabelInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderPlayerNameAndScoreLabelSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderPlayerNameAndScoreLabelInferiors;
    private static final Map<String, String[]> allBaseAfterRenderPlayerNameAndScoreLabelSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderPlayerNameAndScoreLabelInferiors;
    private static final List<String> beforeRenderPlayerScaleHookTypes;
    private static final List<String> overrideRenderPlayerScaleHookTypes;
    private static final List<String> afterRenderPlayerScaleHookTypes;
    private RenderPlayerBase[] beforeRenderPlayerScaleHooks;
    private RenderPlayerBase[] overrideRenderPlayerScaleHooks;
    private RenderPlayerBase[] afterRenderPlayerScaleHooks;
    public boolean isRenderPlayerScaleModded;
    private static final Map<String, String[]> allBaseBeforeRenderPlayerScaleSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderPlayerScaleInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderPlayerScaleSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderPlayerScaleInferiors;
    private static final Map<String, String[]> allBaseAfterRenderPlayerScaleSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderPlayerScaleInferiors;
    private static final List<String> beforeRenderPlayerSleepHookTypes;
    private static final List<String> overrideRenderPlayerSleepHookTypes;
    private static final List<String> afterRenderPlayerSleepHookTypes;
    private RenderPlayerBase[] beforeRenderPlayerSleepHooks;
    private RenderPlayerBase[] overrideRenderPlayerSleepHooks;
    private RenderPlayerBase[] afterRenderPlayerSleepHooks;
    public boolean isRenderPlayerSleepModded;
    private static final Map<String, String[]> allBaseBeforeRenderPlayerSleepSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderPlayerSleepInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderPlayerSleepSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderPlayerSleepInferiors;
    private static final Map<String, String[]> allBaseAfterRenderPlayerSleepSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderPlayerSleepInferiors;
    private static final List<String> beforeRenderSpecialsHookTypes;
    private static final List<String> overrideRenderSpecialsHookTypes;
    private static final List<String> afterRenderSpecialsHookTypes;
    private RenderPlayerBase[] beforeRenderSpecialsHooks;
    private RenderPlayerBase[] overrideRenderSpecialsHooks;
    private RenderPlayerBase[] afterRenderSpecialsHooks;
    public boolean isRenderSpecialsModded;
    private static final Map<String, String[]> allBaseBeforeRenderSpecialsSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderSpecialsInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderSpecialsSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderSpecialsInferiors;
    private static final Map<String, String[]> allBaseAfterRenderSpecialsSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderSpecialsInferiors;
    private static final List<String> beforeRenderSwingProgressHookTypes;
    private static final List<String> overrideRenderSwingProgressHookTypes;
    private static final List<String> afterRenderSwingProgressHookTypes;
    private RenderPlayerBase[] beforeRenderSwingProgressHooks;
    private RenderPlayerBase[] overrideRenderSwingProgressHooks;
    private RenderPlayerBase[] afterRenderSwingProgressHooks;
    public boolean isRenderSwingProgressModded;
    private static final Map<String, String[]> allBaseBeforeRenderSwingProgressSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderSwingProgressInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderSwingProgressSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderSwingProgressInferiors;
    private static final Map<String, String[]> allBaseAfterRenderSwingProgressSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderSwingProgressInferiors;
    private static final List<String> beforeRotatePlayerHookTypes;
    private static final List<String> overrideRotatePlayerHookTypes;
    private static final List<String> afterRotatePlayerHookTypes;
    private RenderPlayerBase[] beforeRotatePlayerHooks;
    private RenderPlayerBase[] overrideRotatePlayerHooks;
    private RenderPlayerBase[] afterRotatePlayerHooks;
    public boolean isRotatePlayerModded;
    private static final Map<String, String[]> allBaseBeforeRotatePlayerSuperiors;
    private static final Map<String, String[]> allBaseBeforeRotatePlayerInferiors;
    private static final Map<String, String[]> allBaseOverrideRotatePlayerSuperiors;
    private static final Map<String, String[]> allBaseOverrideRotatePlayerInferiors;
    private static final Map<String, String[]> allBaseAfterRotatePlayerSuperiors;
    private static final Map<String, String[]> allBaseAfterRotatePlayerInferiors;
    private static final List<String> beforeSetArmorModelHookTypes;
    private static final List<String> overrideSetArmorModelHookTypes;
    private static final List<String> afterSetArmorModelHookTypes;
    private RenderPlayerBase[] beforeSetArmorModelHooks;
    private RenderPlayerBase[] overrideSetArmorModelHooks;
    private RenderPlayerBase[] afterSetArmorModelHooks;
    public boolean isSetArmorModelModded;
    private static final Map<String, String[]> allBaseBeforeSetArmorModelSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetArmorModelInferiors;
    private static final Map<String, String[]> allBaseOverrideSetArmorModelSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetArmorModelInferiors;
    private static final Map<String, String[]> allBaseAfterSetArmorModelSuperiors;
    private static final Map<String, String[]> allBaseAfterSetArmorModelInferiors;
    private static final List<String> beforeSetPassArmorModelHookTypes;
    private static final List<String> overrideSetPassArmorModelHookTypes;
    private static final List<String> afterSetPassArmorModelHookTypes;
    private RenderPlayerBase[] beforeSetPassArmorModelHooks;
    private RenderPlayerBase[] overrideSetPassArmorModelHooks;
    private RenderPlayerBase[] afterSetPassArmorModelHooks;
    public boolean isSetPassArmorModelModded;
    private static final Map<String, String[]> allBaseBeforeSetPassArmorModelSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetPassArmorModelInferiors;
    private static final Map<String, String[]> allBaseOverrideSetPassArmorModelSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetPassArmorModelInferiors;
    private static final Map<String, String[]> allBaseAfterSetPassArmorModelSuperiors;
    private static final Map<String, String[]> allBaseAfterSetPassArmorModelInferiors;
    private static final List<String> beforeSetRenderManagerHookTypes;
    private static final List<String> overrideSetRenderManagerHookTypes;
    private static final List<String> afterSetRenderManagerHookTypes;
    private RenderPlayerBase[] beforeSetRenderManagerHooks;
    private RenderPlayerBase[] overrideSetRenderManagerHooks;
    private RenderPlayerBase[] afterSetRenderManagerHooks;
    public boolean isSetRenderManagerModded;
    private static final Map<String, String[]> allBaseBeforeSetRenderManagerSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetRenderManagerInferiors;
    private static final Map<String, String[]> allBaseOverrideSetRenderManagerSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetRenderManagerInferiors;
    private static final Map<String, String[]> allBaseAfterSetRenderManagerSuperiors;
    private static final Map<String, String[]> allBaseAfterSetRenderManagerInferiors;
    private static final List<String> beforeSetRenderPassModelHookTypes;
    private static final List<String> overrideSetRenderPassModelHookTypes;
    private static final List<String> afterSetRenderPassModelHookTypes;
    private RenderPlayerBase[] beforeSetRenderPassModelHooks;
    private RenderPlayerBase[] overrideSetRenderPassModelHooks;
    private RenderPlayerBase[] afterSetRenderPassModelHooks;
    public boolean isSetRenderPassModelModded;
    private static final Map<String, String[]> allBaseBeforeSetRenderPassModelSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetRenderPassModelInferiors;
    private static final Map<String, String[]> allBaseOverrideSetRenderPassModelSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetRenderPassModelInferiors;
    private static final Map<String, String[]> allBaseAfterSetRenderPassModelSuperiors;
    private static final Map<String, String[]> allBaseAfterSetRenderPassModelInferiors;
    private static final List<String> beforeUpdateIconsHookTypes;
    private static final List<String> overrideUpdateIconsHookTypes;
    private static final List<String> afterUpdateIconsHookTypes;
    private RenderPlayerBase[] beforeUpdateIconsHooks;
    private RenderPlayerBase[] overrideUpdateIconsHooks;
    private RenderPlayerBase[] afterUpdateIconsHooks;
    public boolean isUpdateIconsModded;
    private static final Map<String, String[]> allBaseBeforeUpdateIconsSuperiors;
    private static final Map<String, String[]> allBaseBeforeUpdateIconsInferiors;
    private static final Map<String, String[]> allBaseOverrideUpdateIconsSuperiors;
    private static final Map<String, String[]> allBaseOverrideUpdateIconsInferiors;
    private static final Map<String, String[]> allBaseAfterUpdateIconsSuperiors;
    private static final Map<String, String[]> allBaseAfterUpdateIconsInferiors;
    private static final List<String> beforeRenderSpecialHeadArmorHookTypes;
    private static final List<String> overrideRenderSpecialHeadArmorHookTypes;
    private static final List<String> afterRenderSpecialHeadArmorHookTypes;
    private RenderPlayerBase[] beforeRenderSpecialHeadArmorHooks;
    private RenderPlayerBase[] overrideRenderSpecialHeadArmorHooks;
    private RenderPlayerBase[] afterRenderSpecialHeadArmorHooks;
    public boolean isRenderSpecialHeadArmorModded;
    private static final Map<String, String[]> allBaseBeforeRenderSpecialHeadArmorSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderSpecialHeadArmorInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderSpecialHeadArmorSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderSpecialHeadArmorInferiors;
    private static final Map<String, String[]> allBaseAfterRenderSpecialHeadArmorSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderSpecialHeadArmorInferiors;
    private static final List<String> beforeRenderSpecialHeadEarsHookTypes;
    private static final List<String> overrideRenderSpecialHeadEarsHookTypes;
    private static final List<String> afterRenderSpecialHeadEarsHookTypes;
    private RenderPlayerBase[] beforeRenderSpecialHeadEarsHooks;
    private RenderPlayerBase[] overrideRenderSpecialHeadEarsHooks;
    private RenderPlayerBase[] afterRenderSpecialHeadEarsHooks;
    public boolean isRenderSpecialHeadEarsModded;
    private static final Map<String, String[]> allBaseBeforeRenderSpecialHeadEarsSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderSpecialHeadEarsInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderSpecialHeadEarsSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderSpecialHeadEarsInferiors;
    private static final Map<String, String[]> allBaseAfterRenderSpecialHeadEarsSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderSpecialHeadEarsInferiors;
    private static final List<String> beforeRenderSpecialCloakHookTypes;
    private static final List<String> overrideRenderSpecialCloakHookTypes;
    private static final List<String> afterRenderSpecialCloakHookTypes;
    private RenderPlayerBase[] beforeRenderSpecialCloakHooks;
    private RenderPlayerBase[] overrideRenderSpecialCloakHooks;
    private RenderPlayerBase[] afterRenderSpecialCloakHooks;
    public boolean isRenderSpecialCloakModded;
    private static final Map<String, String[]> allBaseBeforeRenderSpecialCloakSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderSpecialCloakInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderSpecialCloakSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderSpecialCloakInferiors;
    private static final Map<String, String[]> allBaseAfterRenderSpecialCloakSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderSpecialCloakInferiors;
    private static final List<String> beforeRenderSpecialItemInHandHookTypes;
    private static final List<String> overrideRenderSpecialItemInHandHookTypes;
    private static final List<String> afterRenderSpecialItemInHandHookTypes;
    private RenderPlayerBase[] beforeRenderSpecialItemInHandHooks;
    private RenderPlayerBase[] overrideRenderSpecialItemInHandHooks;
    private RenderPlayerBase[] afterRenderSpecialItemInHandHooks;
    public boolean isRenderSpecialItemInHandModded;
    private static final Map<String, String[]> allBaseBeforeRenderSpecialItemInHandSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderSpecialItemInHandInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderSpecialItemInHandSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderSpecialItemInHandInferiors;
    private static final Map<String, String[]> allBaseAfterRenderSpecialItemInHandSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderSpecialItemInHandInferiors;
    private static final List<String> beforePositionSpecialItemInHandHookTypes;
    private static final List<String> overridePositionSpecialItemInHandHookTypes;
    private static final List<String> afterPositionSpecialItemInHandHookTypes;
    private RenderPlayerBase[] beforePositionSpecialItemInHandHooks;
    private RenderPlayerBase[] overridePositionSpecialItemInHandHooks;
    private RenderPlayerBase[] afterPositionSpecialItemInHandHooks;
    public boolean isPositionSpecialItemInHandModded;
    private static final Map<String, String[]> allBaseBeforePositionSpecialItemInHandSuperiors;
    private static final Map<String, String[]> allBaseBeforePositionSpecialItemInHandInferiors;
    private static final Map<String, String[]> allBaseOverridePositionSpecialItemInHandSuperiors;
    private static final Map<String, String[]> allBaseOverridePositionSpecialItemInHandInferiors;
    private static final Map<String, String[]> allBaseAfterPositionSpecialItemInHandSuperiors;
    private static final Map<String, String[]> allBaseAfterPositionSpecialItemInHandInferiors;
    protected final RenderPlayer renderPlayer;
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
    private RenderPlayerBase[] beforeLocalConstructingHooks;
    private RenderPlayerBase[] afterLocalConstructingHooks;
    private final Map<RenderPlayerBase, String> baseObjectsToId = new Hashtable<RenderPlayerBase, String>();
    private final Map<String, RenderPlayerBase> allBaseObjects = new Hashtable<String, RenderPlayerBase>();
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

    private static String error(String string) {
        logger.severe(string);
        return string;
    }

    public static void register(String string, Class<?> clazz) {
        RenderPlayerAPI.register(string, clazz, null);
    }

    public static void register(String string, Class<?> clazz, RenderPlayerBaseSorting renderPlayerBaseSorting) {
        try {
            RenderPlayerAPI.register(clazz, string, renderPlayerBaseSorting);
        }
        catch (RuntimeException runtimeException) {
            if (string != null) {
                RenderPlayerAPI.log("Render Player: failed to register id '" + string + "'");
            } else {
                RenderPlayerAPI.log("Render Player: failed to register RenderPlayerBase");
            }
            throw runtimeException;
        }
    }

    /*
     * WARNING - void declaration
     */
    private static void register(Class<?> clazz, String string, RenderPlayerBaseSorting renderPlayerBaseSorting) {
        Constructor<?> constructor;
        Executable executable;
        if (!isCreated) {
            try {
                executable = RenderPlayer.class.getMethod("getRenderPlayerBase", String.class);
                if (((Method)executable).getReturnType() != RenderPlayerBase.class) {
                    throw new NoSuchMethodException(RenderPlayerBase.class.getName() + " " + RenderPlayer.class.getName() + ".getRenderPlayerBase(" + String.class.getName() + ")");
                }
            }
            catch (NoSuchMethodException noSuchMethodException) {
                void var9_22;
                void object;
                String[] stringArray = new String[]{"========================================", "The API \"Render Player\" version 1.0 of the mod \"Render Player API forge 1.0\" can not be created!", "----------------------------------------", "Mandatory member method \"{0} getRenderPlayerBase({3})\" not found in class \"{1}\".", "There are three scenarios this can happen:", "* Minecraft Forge is missing a Render Player API forge which Minecraft version matches its own.", "  Download and install the latest Render Player API forge for the Minecraft version you were trying to run.", "* The code of the class \"{2}\" of Render Player API forge has been modified beyond recognition by another Minecraft Forge coremod.", "  Try temporary deinstallation of other core mods to find the culprit and deinstall it permanently to fix this specific problem.", "* Render Player API forge has not been installed correctly.", "  Deinstall Render Player API forge and install it again following the installation instructions in the readme file.", "========================================"};
                String string2 = RenderPlayerBase.class.getName();
                String string3 = RenderPlayer.class.getName();
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
                    String string9 = (String)var9_22 + "\t" + string8 + "\n";
                }
                throw new RuntimeException((String)var9_22, noSuchMethodException);
            }
            RenderPlayerAPI.log("Render Player 1.0 Created");
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
                throw new IllegalArgumentException("Can not find necessary constructor with one argument of type '" + RenderPlayerAPI.class.getName() + "' and eventually a second argument of type 'String' in the class '" + clazz.getName() + "'", throwable);
            }
        }
        allBaseConstructors.put(string, constructor);
        if (renderPlayerBaseSorting != null) {
            RenderPlayerAPI.addSorting(string, allBaseBeforeLocalConstructingSuperiors, renderPlayerBaseSorting.getBeforeLocalConstructingSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeLocalConstructingInferiors, renderPlayerBaseSorting.getBeforeLocalConstructingInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterLocalConstructingSuperiors, renderPlayerBaseSorting.getAfterLocalConstructingSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterLocalConstructingInferiors, renderPlayerBaseSorting.getAfterLocalConstructingInferiors());
            RenderPlayerAPI.addDynamicSorting(string, allBaseBeforeDynamicSuperiors, renderPlayerBaseSorting.getDynamicBeforeSuperiors());
            RenderPlayerAPI.addDynamicSorting(string, allBaseBeforeDynamicInferiors, renderPlayerBaseSorting.getDynamicBeforeInferiors());
            RenderPlayerAPI.addDynamicSorting(string, allBaseOverrideDynamicSuperiors, renderPlayerBaseSorting.getDynamicOverrideSuperiors());
            RenderPlayerAPI.addDynamicSorting(string, allBaseOverrideDynamicInferiors, renderPlayerBaseSorting.getDynamicOverrideInferiors());
            RenderPlayerAPI.addDynamicSorting(string, allBaseAfterDynamicSuperiors, renderPlayerBaseSorting.getDynamicAfterSuperiors());
            RenderPlayerAPI.addDynamicSorting(string, allBaseAfterDynamicInferiors, renderPlayerBaseSorting.getDynamicAfterInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeDoRenderLabelSuperiors, renderPlayerBaseSorting.getBeforeDoRenderLabelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeDoRenderLabelInferiors, renderPlayerBaseSorting.getBeforeDoRenderLabelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideDoRenderLabelSuperiors, renderPlayerBaseSorting.getOverrideDoRenderLabelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideDoRenderLabelInferiors, renderPlayerBaseSorting.getOverrideDoRenderLabelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterDoRenderLabelSuperiors, renderPlayerBaseSorting.getAfterDoRenderLabelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterDoRenderLabelInferiors, renderPlayerBaseSorting.getAfterDoRenderLabelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeDoRenderShadowAndFireSuperiors, renderPlayerBaseSorting.getBeforeDoRenderShadowAndFireSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeDoRenderShadowAndFireInferiors, renderPlayerBaseSorting.getBeforeDoRenderShadowAndFireInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideDoRenderShadowAndFireSuperiors, renderPlayerBaseSorting.getOverrideDoRenderShadowAndFireSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideDoRenderShadowAndFireInferiors, renderPlayerBaseSorting.getOverrideDoRenderShadowAndFireInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterDoRenderShadowAndFireSuperiors, renderPlayerBaseSorting.getAfterDoRenderShadowAndFireSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterDoRenderShadowAndFireInferiors, renderPlayerBaseSorting.getAfterDoRenderShadowAndFireInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeGetColorMultiplierSuperiors, renderPlayerBaseSorting.getBeforeGetColorMultiplierSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeGetColorMultiplierInferiors, renderPlayerBaseSorting.getBeforeGetColorMultiplierInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideGetColorMultiplierSuperiors, renderPlayerBaseSorting.getOverrideGetColorMultiplierSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideGetColorMultiplierInferiors, renderPlayerBaseSorting.getOverrideGetColorMultiplierInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterGetColorMultiplierSuperiors, renderPlayerBaseSorting.getAfterGetColorMultiplierSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterGetColorMultiplierInferiors, renderPlayerBaseSorting.getAfterGetColorMultiplierInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeGetDeathMaxRotationSuperiors, renderPlayerBaseSorting.getBeforeGetDeathMaxRotationSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeGetDeathMaxRotationInferiors, renderPlayerBaseSorting.getBeforeGetDeathMaxRotationInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideGetDeathMaxRotationSuperiors, renderPlayerBaseSorting.getOverrideGetDeathMaxRotationSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideGetDeathMaxRotationInferiors, renderPlayerBaseSorting.getOverrideGetDeathMaxRotationInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterGetDeathMaxRotationSuperiors, renderPlayerBaseSorting.getAfterGetDeathMaxRotationSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterGetDeathMaxRotationInferiors, renderPlayerBaseSorting.getAfterGetDeathMaxRotationInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeGetFontRendererFromRenderManagerSuperiors, renderPlayerBaseSorting.getBeforeGetFontRendererFromRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeGetFontRendererFromRenderManagerInferiors, renderPlayerBaseSorting.getBeforeGetFontRendererFromRenderManagerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideGetFontRendererFromRenderManagerSuperiors, renderPlayerBaseSorting.getOverrideGetFontRendererFromRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideGetFontRendererFromRenderManagerInferiors, renderPlayerBaseSorting.getOverrideGetFontRendererFromRenderManagerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterGetFontRendererFromRenderManagerSuperiors, renderPlayerBaseSorting.getAfterGetFontRendererFromRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterGetFontRendererFromRenderManagerInferiors, renderPlayerBaseSorting.getAfterGetFontRendererFromRenderManagerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeGetResourceLocationFromPlayerSuperiors, renderPlayerBaseSorting.getBeforeGetResourceLocationFromPlayerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeGetResourceLocationFromPlayerInferiors, renderPlayerBaseSorting.getBeforeGetResourceLocationFromPlayerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideGetResourceLocationFromPlayerSuperiors, renderPlayerBaseSorting.getOverrideGetResourceLocationFromPlayerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideGetResourceLocationFromPlayerInferiors, renderPlayerBaseSorting.getOverrideGetResourceLocationFromPlayerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterGetResourceLocationFromPlayerSuperiors, renderPlayerBaseSorting.getAfterGetResourceLocationFromPlayerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterGetResourceLocationFromPlayerInferiors, renderPlayerBaseSorting.getAfterGetResourceLocationFromPlayerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeHandleRotationFloatSuperiors, renderPlayerBaseSorting.getBeforeHandleRotationFloatSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeHandleRotationFloatInferiors, renderPlayerBaseSorting.getBeforeHandleRotationFloatInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideHandleRotationFloatSuperiors, renderPlayerBaseSorting.getOverrideHandleRotationFloatSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideHandleRotationFloatInferiors, renderPlayerBaseSorting.getOverrideHandleRotationFloatInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterHandleRotationFloatSuperiors, renderPlayerBaseSorting.getAfterHandleRotationFloatSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterHandleRotationFloatInferiors, renderPlayerBaseSorting.getAfterHandleRotationFloatInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeInheritRenderPassSuperiors, renderPlayerBaseSorting.getBeforeInheritRenderPassSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeInheritRenderPassInferiors, renderPlayerBaseSorting.getBeforeInheritRenderPassInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideInheritRenderPassSuperiors, renderPlayerBaseSorting.getOverrideInheritRenderPassSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideInheritRenderPassInferiors, renderPlayerBaseSorting.getOverrideInheritRenderPassInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterInheritRenderPassSuperiors, renderPlayerBaseSorting.getAfterInheritRenderPassSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterInheritRenderPassInferiors, renderPlayerBaseSorting.getAfterInheritRenderPassInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeLoadTextureSuperiors, renderPlayerBaseSorting.getBeforeLoadTextureSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeLoadTextureInferiors, renderPlayerBaseSorting.getBeforeLoadTextureInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideLoadTextureSuperiors, renderPlayerBaseSorting.getOverrideLoadTextureSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideLoadTextureInferiors, renderPlayerBaseSorting.getOverrideLoadTextureInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterLoadTextureSuperiors, renderPlayerBaseSorting.getAfterLoadTextureSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterLoadTextureInferiors, renderPlayerBaseSorting.getAfterLoadTextureInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeLoadTextureOfEntitySuperiors, renderPlayerBaseSorting.getBeforeLoadTextureOfEntitySuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeLoadTextureOfEntityInferiors, renderPlayerBaseSorting.getBeforeLoadTextureOfEntityInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideLoadTextureOfEntitySuperiors, renderPlayerBaseSorting.getOverrideLoadTextureOfEntitySuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideLoadTextureOfEntityInferiors, renderPlayerBaseSorting.getOverrideLoadTextureOfEntityInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterLoadTextureOfEntitySuperiors, renderPlayerBaseSorting.getAfterLoadTextureOfEntitySuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterLoadTextureOfEntityInferiors, renderPlayerBaseSorting.getAfterLoadTextureOfEntityInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforePassSpecialRenderSuperiors, renderPlayerBaseSorting.getBeforePassSpecialRenderSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforePassSpecialRenderInferiors, renderPlayerBaseSorting.getBeforePassSpecialRenderInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverridePassSpecialRenderSuperiors, renderPlayerBaseSorting.getOverridePassSpecialRenderSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverridePassSpecialRenderInferiors, renderPlayerBaseSorting.getOverridePassSpecialRenderInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterPassSpecialRenderSuperiors, renderPlayerBaseSorting.getAfterPassSpecialRenderSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterPassSpecialRenderInferiors, renderPlayerBaseSorting.getAfterPassSpecialRenderInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderArrowsStuckInEntitySuperiors, renderPlayerBaseSorting.getBeforeRenderArrowsStuckInEntitySuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderArrowsStuckInEntityInferiors, renderPlayerBaseSorting.getBeforeRenderArrowsStuckInEntityInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderArrowsStuckInEntitySuperiors, renderPlayerBaseSorting.getOverrideRenderArrowsStuckInEntitySuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderArrowsStuckInEntityInferiors, renderPlayerBaseSorting.getOverrideRenderArrowsStuckInEntityInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderArrowsStuckInEntitySuperiors, renderPlayerBaseSorting.getAfterRenderArrowsStuckInEntitySuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderArrowsStuckInEntityInferiors, renderPlayerBaseSorting.getAfterRenderArrowsStuckInEntityInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderFirstPersonArmSuperiors, renderPlayerBaseSorting.getBeforeRenderFirstPersonArmSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderFirstPersonArmInferiors, renderPlayerBaseSorting.getBeforeRenderFirstPersonArmInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderFirstPersonArmSuperiors, renderPlayerBaseSorting.getOverrideRenderFirstPersonArmSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderFirstPersonArmInferiors, renderPlayerBaseSorting.getOverrideRenderFirstPersonArmInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderFirstPersonArmSuperiors, renderPlayerBaseSorting.getAfterRenderFirstPersonArmSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderFirstPersonArmInferiors, renderPlayerBaseSorting.getAfterRenderFirstPersonArmInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderLivingLabelSuperiors, renderPlayerBaseSorting.getBeforeRenderLivingLabelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderLivingLabelInferiors, renderPlayerBaseSorting.getBeforeRenderLivingLabelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderLivingLabelSuperiors, renderPlayerBaseSorting.getOverrideRenderLivingLabelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderLivingLabelInferiors, renderPlayerBaseSorting.getOverrideRenderLivingLabelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderLivingLabelSuperiors, renderPlayerBaseSorting.getAfterRenderLivingLabelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderLivingLabelInferiors, renderPlayerBaseSorting.getAfterRenderLivingLabelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderModelSuperiors, renderPlayerBaseSorting.getBeforeRenderModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderModelInferiors, renderPlayerBaseSorting.getBeforeRenderModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderModelSuperiors, renderPlayerBaseSorting.getOverrideRenderModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderModelInferiors, renderPlayerBaseSorting.getOverrideRenderModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderModelSuperiors, renderPlayerBaseSorting.getAfterRenderModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderModelInferiors, renderPlayerBaseSorting.getAfterRenderModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderPlayerSuperiors, renderPlayerBaseSorting.getBeforeRenderPlayerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderPlayerInferiors, renderPlayerBaseSorting.getBeforeRenderPlayerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderPlayerSuperiors, renderPlayerBaseSorting.getOverrideRenderPlayerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderPlayerInferiors, renderPlayerBaseSorting.getOverrideRenderPlayerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderPlayerSuperiors, renderPlayerBaseSorting.getAfterRenderPlayerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderPlayerInferiors, renderPlayerBaseSorting.getAfterRenderPlayerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderPlayerNameAndScoreLabelSuperiors, renderPlayerBaseSorting.getBeforeRenderPlayerNameAndScoreLabelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderPlayerNameAndScoreLabelInferiors, renderPlayerBaseSorting.getBeforeRenderPlayerNameAndScoreLabelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderPlayerNameAndScoreLabelSuperiors, renderPlayerBaseSorting.getOverrideRenderPlayerNameAndScoreLabelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderPlayerNameAndScoreLabelInferiors, renderPlayerBaseSorting.getOverrideRenderPlayerNameAndScoreLabelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderPlayerNameAndScoreLabelSuperiors, renderPlayerBaseSorting.getAfterRenderPlayerNameAndScoreLabelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderPlayerNameAndScoreLabelInferiors, renderPlayerBaseSorting.getAfterRenderPlayerNameAndScoreLabelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderPlayerScaleSuperiors, renderPlayerBaseSorting.getBeforeRenderPlayerScaleSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderPlayerScaleInferiors, renderPlayerBaseSorting.getBeforeRenderPlayerScaleInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderPlayerScaleSuperiors, renderPlayerBaseSorting.getOverrideRenderPlayerScaleSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderPlayerScaleInferiors, renderPlayerBaseSorting.getOverrideRenderPlayerScaleInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderPlayerScaleSuperiors, renderPlayerBaseSorting.getAfterRenderPlayerScaleSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderPlayerScaleInferiors, renderPlayerBaseSorting.getAfterRenderPlayerScaleInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderPlayerSleepSuperiors, renderPlayerBaseSorting.getBeforeRenderPlayerSleepSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderPlayerSleepInferiors, renderPlayerBaseSorting.getBeforeRenderPlayerSleepInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderPlayerSleepSuperiors, renderPlayerBaseSorting.getOverrideRenderPlayerSleepSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderPlayerSleepInferiors, renderPlayerBaseSorting.getOverrideRenderPlayerSleepInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderPlayerSleepSuperiors, renderPlayerBaseSorting.getAfterRenderPlayerSleepSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderPlayerSleepInferiors, renderPlayerBaseSorting.getAfterRenderPlayerSleepInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSpecialsSuperiors, renderPlayerBaseSorting.getBeforeRenderSpecialsSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSpecialsInferiors, renderPlayerBaseSorting.getBeforeRenderSpecialsInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSpecialsSuperiors, renderPlayerBaseSorting.getOverrideRenderSpecialsSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSpecialsInferiors, renderPlayerBaseSorting.getOverrideRenderSpecialsInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSpecialsSuperiors, renderPlayerBaseSorting.getAfterRenderSpecialsSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSpecialsInferiors, renderPlayerBaseSorting.getAfterRenderSpecialsInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSwingProgressSuperiors, renderPlayerBaseSorting.getBeforeRenderSwingProgressSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSwingProgressInferiors, renderPlayerBaseSorting.getBeforeRenderSwingProgressInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSwingProgressSuperiors, renderPlayerBaseSorting.getOverrideRenderSwingProgressSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSwingProgressInferiors, renderPlayerBaseSorting.getOverrideRenderSwingProgressInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSwingProgressSuperiors, renderPlayerBaseSorting.getAfterRenderSwingProgressSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSwingProgressInferiors, renderPlayerBaseSorting.getAfterRenderSwingProgressInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRotatePlayerSuperiors, renderPlayerBaseSorting.getBeforeRotatePlayerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRotatePlayerInferiors, renderPlayerBaseSorting.getBeforeRotatePlayerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRotatePlayerSuperiors, renderPlayerBaseSorting.getOverrideRotatePlayerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRotatePlayerInferiors, renderPlayerBaseSorting.getOverrideRotatePlayerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRotatePlayerSuperiors, renderPlayerBaseSorting.getAfterRotatePlayerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRotatePlayerInferiors, renderPlayerBaseSorting.getAfterRotatePlayerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeSetArmorModelSuperiors, renderPlayerBaseSorting.getBeforeSetArmorModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeSetArmorModelInferiors, renderPlayerBaseSorting.getBeforeSetArmorModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideSetArmorModelSuperiors, renderPlayerBaseSorting.getOverrideSetArmorModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideSetArmorModelInferiors, renderPlayerBaseSorting.getOverrideSetArmorModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterSetArmorModelSuperiors, renderPlayerBaseSorting.getAfterSetArmorModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterSetArmorModelInferiors, renderPlayerBaseSorting.getAfterSetArmorModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeSetPassArmorModelSuperiors, renderPlayerBaseSorting.getBeforeSetPassArmorModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeSetPassArmorModelInferiors, renderPlayerBaseSorting.getBeforeSetPassArmorModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideSetPassArmorModelSuperiors, renderPlayerBaseSorting.getOverrideSetPassArmorModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideSetPassArmorModelInferiors, renderPlayerBaseSorting.getOverrideSetPassArmorModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterSetPassArmorModelSuperiors, renderPlayerBaseSorting.getAfterSetPassArmorModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterSetPassArmorModelInferiors, renderPlayerBaseSorting.getAfterSetPassArmorModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeSetRenderManagerSuperiors, renderPlayerBaseSorting.getBeforeSetRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeSetRenderManagerInferiors, renderPlayerBaseSorting.getBeforeSetRenderManagerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideSetRenderManagerSuperiors, renderPlayerBaseSorting.getOverrideSetRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideSetRenderManagerInferiors, renderPlayerBaseSorting.getOverrideSetRenderManagerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterSetRenderManagerSuperiors, renderPlayerBaseSorting.getAfterSetRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterSetRenderManagerInferiors, renderPlayerBaseSorting.getAfterSetRenderManagerInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeSetRenderPassModelSuperiors, renderPlayerBaseSorting.getBeforeSetRenderPassModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeSetRenderPassModelInferiors, renderPlayerBaseSorting.getBeforeSetRenderPassModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideSetRenderPassModelSuperiors, renderPlayerBaseSorting.getOverrideSetRenderPassModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideSetRenderPassModelInferiors, renderPlayerBaseSorting.getOverrideSetRenderPassModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterSetRenderPassModelSuperiors, renderPlayerBaseSorting.getAfterSetRenderPassModelSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterSetRenderPassModelInferiors, renderPlayerBaseSorting.getAfterSetRenderPassModelInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeUpdateIconsSuperiors, renderPlayerBaseSorting.getBeforeUpdateIconsSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeUpdateIconsInferiors, renderPlayerBaseSorting.getBeforeUpdateIconsInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideUpdateIconsSuperiors, renderPlayerBaseSorting.getOverrideUpdateIconsSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideUpdateIconsInferiors, renderPlayerBaseSorting.getOverrideUpdateIconsInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterUpdateIconsSuperiors, renderPlayerBaseSorting.getAfterUpdateIconsSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterUpdateIconsInferiors, renderPlayerBaseSorting.getAfterUpdateIconsInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSpecialHeadArmorSuperiors, renderPlayerBaseSorting.getBeforeRenderSpecialHeadArmorSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSpecialHeadArmorInferiors, renderPlayerBaseSorting.getBeforeRenderSpecialHeadArmorInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSpecialHeadArmorSuperiors, renderPlayerBaseSorting.getOverrideRenderSpecialHeadArmorSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSpecialHeadArmorInferiors, renderPlayerBaseSorting.getOverrideRenderSpecialHeadArmorInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSpecialHeadArmorSuperiors, renderPlayerBaseSorting.getAfterRenderSpecialHeadArmorSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSpecialHeadArmorInferiors, renderPlayerBaseSorting.getAfterRenderSpecialHeadArmorInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSpecialHeadEarsSuperiors, renderPlayerBaseSorting.getBeforeRenderSpecialHeadEarsSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSpecialHeadEarsInferiors, renderPlayerBaseSorting.getBeforeRenderSpecialHeadEarsInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSpecialHeadEarsSuperiors, renderPlayerBaseSorting.getOverrideRenderSpecialHeadEarsSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSpecialHeadEarsInferiors, renderPlayerBaseSorting.getOverrideRenderSpecialHeadEarsInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSpecialHeadEarsSuperiors, renderPlayerBaseSorting.getAfterRenderSpecialHeadEarsSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSpecialHeadEarsInferiors, renderPlayerBaseSorting.getAfterRenderSpecialHeadEarsInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSpecialCloakSuperiors, renderPlayerBaseSorting.getBeforeRenderSpecialCloakSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSpecialCloakInferiors, renderPlayerBaseSorting.getBeforeRenderSpecialCloakInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSpecialCloakSuperiors, renderPlayerBaseSorting.getOverrideRenderSpecialCloakSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSpecialCloakInferiors, renderPlayerBaseSorting.getOverrideRenderSpecialCloakInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSpecialCloakSuperiors, renderPlayerBaseSorting.getAfterRenderSpecialCloakSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSpecialCloakInferiors, renderPlayerBaseSorting.getAfterRenderSpecialCloakInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSpecialItemInHandSuperiors, renderPlayerBaseSorting.getBeforeRenderSpecialItemInHandSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforeRenderSpecialItemInHandInferiors, renderPlayerBaseSorting.getBeforeRenderSpecialItemInHandInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSpecialItemInHandSuperiors, renderPlayerBaseSorting.getOverrideRenderSpecialItemInHandSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverrideRenderSpecialItemInHandInferiors, renderPlayerBaseSorting.getOverrideRenderSpecialItemInHandInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSpecialItemInHandSuperiors, renderPlayerBaseSorting.getAfterRenderSpecialItemInHandSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterRenderSpecialItemInHandInferiors, renderPlayerBaseSorting.getAfterRenderSpecialItemInHandInferiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforePositionSpecialItemInHandSuperiors, renderPlayerBaseSorting.getBeforePositionSpecialItemInHandSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseBeforePositionSpecialItemInHandInferiors, renderPlayerBaseSorting.getBeforePositionSpecialItemInHandInferiors());
            RenderPlayerAPI.addSorting(string, allBaseOverridePositionSpecialItemInHandSuperiors, renderPlayerBaseSorting.getOverridePositionSpecialItemInHandSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseOverridePositionSpecialItemInHandInferiors, renderPlayerBaseSorting.getOverridePositionSpecialItemInHandInferiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterPositionSpecialItemInHandSuperiors, renderPlayerBaseSorting.getAfterPositionSpecialItemInHandSuperiors());
            RenderPlayerAPI.addSorting(string, allBaseAfterPositionSpecialItemInHandInferiors, renderPlayerBaseSorting.getAfterPositionSpecialItemInHandInferiors());
        }
        RenderPlayerAPI.addMethod(string, clazz, beforeLocalConstructingHookTypes, "beforeLocalConstructing", new Class[0]);
        RenderPlayerAPI.addMethod(string, clazz, afterLocalConstructingHookTypes, "afterLocalConstructing", new Class[0]);
        RenderPlayerAPI.addMethod(string, clazz, beforeDoRenderLabelHookTypes, "beforeDoRenderLabel", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(string, clazz, overrideDoRenderLabelHookTypes, "doRenderLabel", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(string, clazz, afterDoRenderLabelHookTypes, "afterDoRenderLabel", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(string, clazz, beforeDoRenderShadowAndFireHookTypes, "beforeDoRenderShadowAndFire", Entity.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideDoRenderShadowAndFireHookTypes, "doRenderShadowAndFire", Entity.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterDoRenderShadowAndFireHookTypes, "afterDoRenderShadowAndFire", Entity.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeGetColorMultiplierHookTypes, "beforeGetColorMultiplier", EntityLivingBase.class, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideGetColorMultiplierHookTypes, "getColorMultiplier", EntityLivingBase.class, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterGetColorMultiplierHookTypes, "afterGetColorMultiplier", EntityLivingBase.class, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeGetDeathMaxRotationHookTypes, "beforeGetDeathMaxRotation", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(string, clazz, overrideGetDeathMaxRotationHookTypes, "getDeathMaxRotation", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(string, clazz, afterGetDeathMaxRotationHookTypes, "afterGetDeathMaxRotation", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(string, clazz, beforeGetFontRendererFromRenderManagerHookTypes, "beforeGetFontRendererFromRenderManager", new Class[0]);
        RenderPlayerAPI.addMethod(string, clazz, overrideGetFontRendererFromRenderManagerHookTypes, "getFontRendererFromRenderManager", new Class[0]);
        RenderPlayerAPI.addMethod(string, clazz, afterGetFontRendererFromRenderManagerHookTypes, "afterGetFontRendererFromRenderManager", new Class[0]);
        RenderPlayerAPI.addMethod(string, clazz, beforeGetResourceLocationFromPlayerHookTypes, "beforeGetResourceLocationFromPlayer", AbstractClientPlayer.class);
        RenderPlayerAPI.addMethod(string, clazz, overrideGetResourceLocationFromPlayerHookTypes, "getResourceLocationFromPlayer", AbstractClientPlayer.class);
        RenderPlayerAPI.addMethod(string, clazz, afterGetResourceLocationFromPlayerHookTypes, "afterGetResourceLocationFromPlayer", AbstractClientPlayer.class);
        RenderPlayerAPI.addMethod(string, clazz, beforeHandleRotationFloatHookTypes, "beforeHandleRotationFloat", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideHandleRotationFloatHookTypes, "handleRotationFloat", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterHandleRotationFloatHookTypes, "afterHandleRotationFloat", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeInheritRenderPassHookTypes, "beforeInheritRenderPass", EntityLivingBase.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideInheritRenderPassHookTypes, "inheritRenderPass", EntityLivingBase.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterInheritRenderPassHookTypes, "afterInheritRenderPass", EntityLivingBase.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeLoadTextureHookTypes, "beforeLoadTexture", ResourceLocation.class);
        RenderPlayerAPI.addMethod(string, clazz, overrideLoadTextureHookTypes, "loadTexture", ResourceLocation.class);
        RenderPlayerAPI.addMethod(string, clazz, afterLoadTextureHookTypes, "afterLoadTexture", ResourceLocation.class);
        RenderPlayerAPI.addMethod(string, clazz, beforeLoadTextureOfEntityHookTypes, "beforeLoadTextureOfEntity", Entity.class);
        RenderPlayerAPI.addMethod(string, clazz, overrideLoadTextureOfEntityHookTypes, "loadTextureOfEntity", Entity.class);
        RenderPlayerAPI.addMethod(string, clazz, afterLoadTextureOfEntityHookTypes, "afterLoadTextureOfEntity", Entity.class);
        RenderPlayerAPI.addMethod(string, clazz, beforePassSpecialRenderHookTypes, "beforePassSpecialRender", EntityLivingBase.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overridePassSpecialRenderHookTypes, "passSpecialRender", EntityLivingBase.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterPassSpecialRenderHookTypes, "afterPassSpecialRender", EntityLivingBase.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderArrowsStuckInEntityHookTypes, "beforeRenderArrowsStuckInEntity", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderArrowsStuckInEntityHookTypes, "renderArrowsStuckInEntity", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderArrowsStuckInEntityHookTypes, "afterRenderArrowsStuckInEntity", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderFirstPersonArmHookTypes, "beforeRenderFirstPersonArm", EntityPlayer.class);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderFirstPersonArmHookTypes, "renderFirstPersonArm", EntityPlayer.class);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderFirstPersonArmHookTypes, "afterRenderFirstPersonArm", EntityPlayer.class);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderLivingLabelHookTypes, "beforeRenderLivingLabel", EntityLivingBase.class, String.class, Double.TYPE, Double.TYPE, Double.TYPE, Integer.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderLivingLabelHookTypes, "renderLivingLabel", EntityLivingBase.class, String.class, Double.TYPE, Double.TYPE, Double.TYPE, Integer.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderLivingLabelHookTypes, "afterRenderLivingLabel", EntityLivingBase.class, String.class, Double.TYPE, Double.TYPE, Double.TYPE, Integer.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderModelHookTypes, "beforeRenderModel", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderModelHookTypes, "renderModel", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderModelHookTypes, "afterRenderModel", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderPlayerHookTypes, "beforeRenderPlayer", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderPlayerHookTypes, "renderPlayer", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderPlayerHookTypes, "afterRenderPlayer", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderPlayerNameAndScoreLabelHookTypes, "beforeRenderPlayerNameAndScoreLabel", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, String.class, Float.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderPlayerNameAndScoreLabelHookTypes, "renderPlayerNameAndScoreLabel", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, String.class, Float.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderPlayerNameAndScoreLabelHookTypes, "afterRenderPlayerNameAndScoreLabel", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, String.class, Float.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderPlayerScaleHookTypes, "beforeRenderPlayerScale", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderPlayerScaleHookTypes, "renderPlayerScale", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderPlayerScaleHookTypes, "afterRenderPlayerScale", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderPlayerSleepHookTypes, "beforeRenderPlayerSleep", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderPlayerSleepHookTypes, "renderPlayerSleep", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderPlayerSleepHookTypes, "afterRenderPlayerSleep", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderSpecialsHookTypes, "beforeRenderSpecials", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderSpecialsHookTypes, "renderSpecials", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderSpecialsHookTypes, "afterRenderSpecials", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderSwingProgressHookTypes, "beforeRenderSwingProgress", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderSwingProgressHookTypes, "renderSwingProgress", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderSwingProgressHookTypes, "afterRenderSwingProgress", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRotatePlayerHookTypes, "beforeRotatePlayer", AbstractClientPlayer.class, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRotatePlayerHookTypes, "rotatePlayer", AbstractClientPlayer.class, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRotatePlayerHookTypes, "afterRotatePlayer", AbstractClientPlayer.class, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeSetArmorModelHookTypes, "beforeSetArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideSetArmorModelHookTypes, "setArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterSetArmorModelHookTypes, "afterSetArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeSetPassArmorModelHookTypes, "beforeSetPassArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideSetPassArmorModelHookTypes, "setPassArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterSetPassArmorModelHookTypes, "afterSetPassArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeSetRenderManagerHookTypes, "beforeSetRenderManager", RenderManager.class);
        RenderPlayerAPI.addMethod(string, clazz, overrideSetRenderManagerHookTypes, "setRenderManager", RenderManager.class);
        RenderPlayerAPI.addMethod(string, clazz, afterSetRenderManagerHookTypes, "afterSetRenderManager", RenderManager.class);
        RenderPlayerAPI.addMethod(string, clazz, beforeSetRenderPassModelHookTypes, "beforeSetRenderPassModel", ModelBase.class);
        RenderPlayerAPI.addMethod(string, clazz, overrideSetRenderPassModelHookTypes, "setRenderPassModel", ModelBase.class);
        RenderPlayerAPI.addMethod(string, clazz, afterSetRenderPassModelHookTypes, "afterSetRenderPassModel", ModelBase.class);
        RenderPlayerAPI.addMethod(string, clazz, beforeUpdateIconsHookTypes, "beforeUpdateIcons", IconRegister.class);
        RenderPlayerAPI.addMethod(string, clazz, overrideUpdateIconsHookTypes, "updateIcons", IconRegister.class);
        RenderPlayerAPI.addMethod(string, clazz, afterUpdateIconsHookTypes, "afterUpdateIcons", IconRegister.class);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderSpecialHeadArmorHookTypes, "beforeRenderSpecialHeadArmor", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderSpecialHeadArmorHookTypes, "renderSpecialHeadArmor", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderSpecialHeadArmorHookTypes, "afterRenderSpecialHeadArmor", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderSpecialHeadEarsHookTypes, "beforeRenderSpecialHeadEars", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderSpecialHeadEarsHookTypes, "renderSpecialHeadEars", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderSpecialHeadEarsHookTypes, "afterRenderSpecialHeadEars", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderSpecialCloakHookTypes, "beforeRenderSpecialCloak", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderSpecialCloakHookTypes, "renderSpecialCloak", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderSpecialCloakHookTypes, "afterRenderSpecialCloak", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforeRenderSpecialItemInHandHookTypes, "beforeRenderSpecialItemInHand", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, overrideRenderSpecialItemInHandHookTypes, "renderSpecialItemInHand", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, afterRenderSpecialItemInHandHookTypes, "afterRenderSpecialItemInHand", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(string, clazz, beforePositionSpecialItemInHandHookTypes, "beforePositionSpecialItemInHand", AbstractClientPlayer.class, Float.TYPE, EnumAction.class, ItemStack.class);
        RenderPlayerAPI.addMethod(string, clazz, overridePositionSpecialItemInHandHookTypes, "positionSpecialItemInHand", AbstractClientPlayer.class, Float.TYPE, EnumAction.class, ItemStack.class);
        RenderPlayerAPI.addMethod(string, clazz, afterPositionSpecialItemInHandHookTypes, "afterPositionSpecialItemInHand", AbstractClientPlayer.class, Float.TYPE, EnumAction.class, ItemStack.class);
        RenderPlayerAPI.addDynamicMethods(string, clazz);
        RenderPlayerAPI.addDynamicKeys(string, clazz, beforeDynamicHookMethods, beforeDynamicHookTypes);
        RenderPlayerAPI.addDynamicKeys(string, clazz, overrideDynamicHookMethods, overrideDynamicHookTypes);
        RenderPlayerAPI.addDynamicKeys(string, clazz, afterDynamicHookMethods, afterDynamicHookTypes);
        RenderPlayerAPI.initialize();
        for (RenderPlayer renderPlayer : RenderPlayer.getAllInstances()) {
            renderPlayer.renderPlayerAPI.attachRenderPlayerBase(string);
        }
        System.out.println("Render Player: registered " + string);
        logger.fine("Render Player: registered class '" + clazz.getName() + "' with id '" + string + "'");
        initialized = false;
    }

    public static boolean unregister(String string) {
        if (string == null) {
            return false;
        }
        Constructor<?> constructor = allBaseConstructors.remove(string);
        if (constructor == null) {
            return false;
        }
        for (RenderPlayer object : RenderPlayer.getAllInstances()) {
            object.renderPlayerAPI.detachRenderPlayerBase(string);
        }
        beforeLocalConstructingHookTypes.remove(string);
        afterLocalConstructingHookTypes.remove(string);
        allBaseBeforeDoRenderLabelSuperiors.remove(string);
        allBaseBeforeDoRenderLabelInferiors.remove(string);
        allBaseOverrideDoRenderLabelSuperiors.remove(string);
        allBaseOverrideDoRenderLabelInferiors.remove(string);
        allBaseAfterDoRenderLabelSuperiors.remove(string);
        allBaseAfterDoRenderLabelInferiors.remove(string);
        beforeDoRenderLabelHookTypes.remove(string);
        overrideDoRenderLabelHookTypes.remove(string);
        afterDoRenderLabelHookTypes.remove(string);
        allBaseBeforeDoRenderShadowAndFireSuperiors.remove(string);
        allBaseBeforeDoRenderShadowAndFireInferiors.remove(string);
        allBaseOverrideDoRenderShadowAndFireSuperiors.remove(string);
        allBaseOverrideDoRenderShadowAndFireInferiors.remove(string);
        allBaseAfterDoRenderShadowAndFireSuperiors.remove(string);
        allBaseAfterDoRenderShadowAndFireInferiors.remove(string);
        beforeDoRenderShadowAndFireHookTypes.remove(string);
        overrideDoRenderShadowAndFireHookTypes.remove(string);
        afterDoRenderShadowAndFireHookTypes.remove(string);
        allBaseBeforeGetColorMultiplierSuperiors.remove(string);
        allBaseBeforeGetColorMultiplierInferiors.remove(string);
        allBaseOverrideGetColorMultiplierSuperiors.remove(string);
        allBaseOverrideGetColorMultiplierInferiors.remove(string);
        allBaseAfterGetColorMultiplierSuperiors.remove(string);
        allBaseAfterGetColorMultiplierInferiors.remove(string);
        beforeGetColorMultiplierHookTypes.remove(string);
        overrideGetColorMultiplierHookTypes.remove(string);
        afterGetColorMultiplierHookTypes.remove(string);
        allBaseBeforeGetDeathMaxRotationSuperiors.remove(string);
        allBaseBeforeGetDeathMaxRotationInferiors.remove(string);
        allBaseOverrideGetDeathMaxRotationSuperiors.remove(string);
        allBaseOverrideGetDeathMaxRotationInferiors.remove(string);
        allBaseAfterGetDeathMaxRotationSuperiors.remove(string);
        allBaseAfterGetDeathMaxRotationInferiors.remove(string);
        beforeGetDeathMaxRotationHookTypes.remove(string);
        overrideGetDeathMaxRotationHookTypes.remove(string);
        afterGetDeathMaxRotationHookTypes.remove(string);
        allBaseBeforeGetFontRendererFromRenderManagerSuperiors.remove(string);
        allBaseBeforeGetFontRendererFromRenderManagerInferiors.remove(string);
        allBaseOverrideGetFontRendererFromRenderManagerSuperiors.remove(string);
        allBaseOverrideGetFontRendererFromRenderManagerInferiors.remove(string);
        allBaseAfterGetFontRendererFromRenderManagerSuperiors.remove(string);
        allBaseAfterGetFontRendererFromRenderManagerInferiors.remove(string);
        beforeGetFontRendererFromRenderManagerHookTypes.remove(string);
        overrideGetFontRendererFromRenderManagerHookTypes.remove(string);
        afterGetFontRendererFromRenderManagerHookTypes.remove(string);
        allBaseBeforeGetResourceLocationFromPlayerSuperiors.remove(string);
        allBaseBeforeGetResourceLocationFromPlayerInferiors.remove(string);
        allBaseOverrideGetResourceLocationFromPlayerSuperiors.remove(string);
        allBaseOverrideGetResourceLocationFromPlayerInferiors.remove(string);
        allBaseAfterGetResourceLocationFromPlayerSuperiors.remove(string);
        allBaseAfterGetResourceLocationFromPlayerInferiors.remove(string);
        beforeGetResourceLocationFromPlayerHookTypes.remove(string);
        overrideGetResourceLocationFromPlayerHookTypes.remove(string);
        afterGetResourceLocationFromPlayerHookTypes.remove(string);
        allBaseBeforeHandleRotationFloatSuperiors.remove(string);
        allBaseBeforeHandleRotationFloatInferiors.remove(string);
        allBaseOverrideHandleRotationFloatSuperiors.remove(string);
        allBaseOverrideHandleRotationFloatInferiors.remove(string);
        allBaseAfterHandleRotationFloatSuperiors.remove(string);
        allBaseAfterHandleRotationFloatInferiors.remove(string);
        beforeHandleRotationFloatHookTypes.remove(string);
        overrideHandleRotationFloatHookTypes.remove(string);
        afterHandleRotationFloatHookTypes.remove(string);
        allBaseBeforeInheritRenderPassSuperiors.remove(string);
        allBaseBeforeInheritRenderPassInferiors.remove(string);
        allBaseOverrideInheritRenderPassSuperiors.remove(string);
        allBaseOverrideInheritRenderPassInferiors.remove(string);
        allBaseAfterInheritRenderPassSuperiors.remove(string);
        allBaseAfterInheritRenderPassInferiors.remove(string);
        beforeInheritRenderPassHookTypes.remove(string);
        overrideInheritRenderPassHookTypes.remove(string);
        afterInheritRenderPassHookTypes.remove(string);
        allBaseBeforeLoadTextureSuperiors.remove(string);
        allBaseBeforeLoadTextureInferiors.remove(string);
        allBaseOverrideLoadTextureSuperiors.remove(string);
        allBaseOverrideLoadTextureInferiors.remove(string);
        allBaseAfterLoadTextureSuperiors.remove(string);
        allBaseAfterLoadTextureInferiors.remove(string);
        beforeLoadTextureHookTypes.remove(string);
        overrideLoadTextureHookTypes.remove(string);
        afterLoadTextureHookTypes.remove(string);
        allBaseBeforeLoadTextureOfEntitySuperiors.remove(string);
        allBaseBeforeLoadTextureOfEntityInferiors.remove(string);
        allBaseOverrideLoadTextureOfEntitySuperiors.remove(string);
        allBaseOverrideLoadTextureOfEntityInferiors.remove(string);
        allBaseAfterLoadTextureOfEntitySuperiors.remove(string);
        allBaseAfterLoadTextureOfEntityInferiors.remove(string);
        beforeLoadTextureOfEntityHookTypes.remove(string);
        overrideLoadTextureOfEntityHookTypes.remove(string);
        afterLoadTextureOfEntityHookTypes.remove(string);
        allBaseBeforePassSpecialRenderSuperiors.remove(string);
        allBaseBeforePassSpecialRenderInferiors.remove(string);
        allBaseOverridePassSpecialRenderSuperiors.remove(string);
        allBaseOverridePassSpecialRenderInferiors.remove(string);
        allBaseAfterPassSpecialRenderSuperiors.remove(string);
        allBaseAfterPassSpecialRenderInferiors.remove(string);
        beforePassSpecialRenderHookTypes.remove(string);
        overridePassSpecialRenderHookTypes.remove(string);
        afterPassSpecialRenderHookTypes.remove(string);
        allBaseBeforeRenderArrowsStuckInEntitySuperiors.remove(string);
        allBaseBeforeRenderArrowsStuckInEntityInferiors.remove(string);
        allBaseOverrideRenderArrowsStuckInEntitySuperiors.remove(string);
        allBaseOverrideRenderArrowsStuckInEntityInferiors.remove(string);
        allBaseAfterRenderArrowsStuckInEntitySuperiors.remove(string);
        allBaseAfterRenderArrowsStuckInEntityInferiors.remove(string);
        beforeRenderArrowsStuckInEntityHookTypes.remove(string);
        overrideRenderArrowsStuckInEntityHookTypes.remove(string);
        afterRenderArrowsStuckInEntityHookTypes.remove(string);
        allBaseBeforeRenderFirstPersonArmSuperiors.remove(string);
        allBaseBeforeRenderFirstPersonArmInferiors.remove(string);
        allBaseOverrideRenderFirstPersonArmSuperiors.remove(string);
        allBaseOverrideRenderFirstPersonArmInferiors.remove(string);
        allBaseAfterRenderFirstPersonArmSuperiors.remove(string);
        allBaseAfterRenderFirstPersonArmInferiors.remove(string);
        beforeRenderFirstPersonArmHookTypes.remove(string);
        overrideRenderFirstPersonArmHookTypes.remove(string);
        afterRenderFirstPersonArmHookTypes.remove(string);
        allBaseBeforeRenderLivingLabelSuperiors.remove(string);
        allBaseBeforeRenderLivingLabelInferiors.remove(string);
        allBaseOverrideRenderLivingLabelSuperiors.remove(string);
        allBaseOverrideRenderLivingLabelInferiors.remove(string);
        allBaseAfterRenderLivingLabelSuperiors.remove(string);
        allBaseAfterRenderLivingLabelInferiors.remove(string);
        beforeRenderLivingLabelHookTypes.remove(string);
        overrideRenderLivingLabelHookTypes.remove(string);
        afterRenderLivingLabelHookTypes.remove(string);
        allBaseBeforeRenderModelSuperiors.remove(string);
        allBaseBeforeRenderModelInferiors.remove(string);
        allBaseOverrideRenderModelSuperiors.remove(string);
        allBaseOverrideRenderModelInferiors.remove(string);
        allBaseAfterRenderModelSuperiors.remove(string);
        allBaseAfterRenderModelInferiors.remove(string);
        beforeRenderModelHookTypes.remove(string);
        overrideRenderModelHookTypes.remove(string);
        afterRenderModelHookTypes.remove(string);
        allBaseBeforeRenderPlayerSuperiors.remove(string);
        allBaseBeforeRenderPlayerInferiors.remove(string);
        allBaseOverrideRenderPlayerSuperiors.remove(string);
        allBaseOverrideRenderPlayerInferiors.remove(string);
        allBaseAfterRenderPlayerSuperiors.remove(string);
        allBaseAfterRenderPlayerInferiors.remove(string);
        beforeRenderPlayerHookTypes.remove(string);
        overrideRenderPlayerHookTypes.remove(string);
        afterRenderPlayerHookTypes.remove(string);
        allBaseBeforeRenderPlayerNameAndScoreLabelSuperiors.remove(string);
        allBaseBeforeRenderPlayerNameAndScoreLabelInferiors.remove(string);
        allBaseOverrideRenderPlayerNameAndScoreLabelSuperiors.remove(string);
        allBaseOverrideRenderPlayerNameAndScoreLabelInferiors.remove(string);
        allBaseAfterRenderPlayerNameAndScoreLabelSuperiors.remove(string);
        allBaseAfterRenderPlayerNameAndScoreLabelInferiors.remove(string);
        beforeRenderPlayerNameAndScoreLabelHookTypes.remove(string);
        overrideRenderPlayerNameAndScoreLabelHookTypes.remove(string);
        afterRenderPlayerNameAndScoreLabelHookTypes.remove(string);
        allBaseBeforeRenderPlayerScaleSuperiors.remove(string);
        allBaseBeforeRenderPlayerScaleInferiors.remove(string);
        allBaseOverrideRenderPlayerScaleSuperiors.remove(string);
        allBaseOverrideRenderPlayerScaleInferiors.remove(string);
        allBaseAfterRenderPlayerScaleSuperiors.remove(string);
        allBaseAfterRenderPlayerScaleInferiors.remove(string);
        beforeRenderPlayerScaleHookTypes.remove(string);
        overrideRenderPlayerScaleHookTypes.remove(string);
        afterRenderPlayerScaleHookTypes.remove(string);
        allBaseBeforeRenderPlayerSleepSuperiors.remove(string);
        allBaseBeforeRenderPlayerSleepInferiors.remove(string);
        allBaseOverrideRenderPlayerSleepSuperiors.remove(string);
        allBaseOverrideRenderPlayerSleepInferiors.remove(string);
        allBaseAfterRenderPlayerSleepSuperiors.remove(string);
        allBaseAfterRenderPlayerSleepInferiors.remove(string);
        beforeRenderPlayerSleepHookTypes.remove(string);
        overrideRenderPlayerSleepHookTypes.remove(string);
        afterRenderPlayerSleepHookTypes.remove(string);
        allBaseBeforeRenderSpecialsSuperiors.remove(string);
        allBaseBeforeRenderSpecialsInferiors.remove(string);
        allBaseOverrideRenderSpecialsSuperiors.remove(string);
        allBaseOverrideRenderSpecialsInferiors.remove(string);
        allBaseAfterRenderSpecialsSuperiors.remove(string);
        allBaseAfterRenderSpecialsInferiors.remove(string);
        beforeRenderSpecialsHookTypes.remove(string);
        overrideRenderSpecialsHookTypes.remove(string);
        afterRenderSpecialsHookTypes.remove(string);
        allBaseBeforeRenderSwingProgressSuperiors.remove(string);
        allBaseBeforeRenderSwingProgressInferiors.remove(string);
        allBaseOverrideRenderSwingProgressSuperiors.remove(string);
        allBaseOverrideRenderSwingProgressInferiors.remove(string);
        allBaseAfterRenderSwingProgressSuperiors.remove(string);
        allBaseAfterRenderSwingProgressInferiors.remove(string);
        beforeRenderSwingProgressHookTypes.remove(string);
        overrideRenderSwingProgressHookTypes.remove(string);
        afterRenderSwingProgressHookTypes.remove(string);
        allBaseBeforeRotatePlayerSuperiors.remove(string);
        allBaseBeforeRotatePlayerInferiors.remove(string);
        allBaseOverrideRotatePlayerSuperiors.remove(string);
        allBaseOverrideRotatePlayerInferiors.remove(string);
        allBaseAfterRotatePlayerSuperiors.remove(string);
        allBaseAfterRotatePlayerInferiors.remove(string);
        beforeRotatePlayerHookTypes.remove(string);
        overrideRotatePlayerHookTypes.remove(string);
        afterRotatePlayerHookTypes.remove(string);
        allBaseBeforeSetArmorModelSuperiors.remove(string);
        allBaseBeforeSetArmorModelInferiors.remove(string);
        allBaseOverrideSetArmorModelSuperiors.remove(string);
        allBaseOverrideSetArmorModelInferiors.remove(string);
        allBaseAfterSetArmorModelSuperiors.remove(string);
        allBaseAfterSetArmorModelInferiors.remove(string);
        beforeSetArmorModelHookTypes.remove(string);
        overrideSetArmorModelHookTypes.remove(string);
        afterSetArmorModelHookTypes.remove(string);
        allBaseBeforeSetPassArmorModelSuperiors.remove(string);
        allBaseBeforeSetPassArmorModelInferiors.remove(string);
        allBaseOverrideSetPassArmorModelSuperiors.remove(string);
        allBaseOverrideSetPassArmorModelInferiors.remove(string);
        allBaseAfterSetPassArmorModelSuperiors.remove(string);
        allBaseAfterSetPassArmorModelInferiors.remove(string);
        beforeSetPassArmorModelHookTypes.remove(string);
        overrideSetPassArmorModelHookTypes.remove(string);
        afterSetPassArmorModelHookTypes.remove(string);
        allBaseBeforeSetRenderManagerSuperiors.remove(string);
        allBaseBeforeSetRenderManagerInferiors.remove(string);
        allBaseOverrideSetRenderManagerSuperiors.remove(string);
        allBaseOverrideSetRenderManagerInferiors.remove(string);
        allBaseAfterSetRenderManagerSuperiors.remove(string);
        allBaseAfterSetRenderManagerInferiors.remove(string);
        beforeSetRenderManagerHookTypes.remove(string);
        overrideSetRenderManagerHookTypes.remove(string);
        afterSetRenderManagerHookTypes.remove(string);
        allBaseBeforeSetRenderPassModelSuperiors.remove(string);
        allBaseBeforeSetRenderPassModelInferiors.remove(string);
        allBaseOverrideSetRenderPassModelSuperiors.remove(string);
        allBaseOverrideSetRenderPassModelInferiors.remove(string);
        allBaseAfterSetRenderPassModelSuperiors.remove(string);
        allBaseAfterSetRenderPassModelInferiors.remove(string);
        beforeSetRenderPassModelHookTypes.remove(string);
        overrideSetRenderPassModelHookTypes.remove(string);
        afterSetRenderPassModelHookTypes.remove(string);
        allBaseBeforeUpdateIconsSuperiors.remove(string);
        allBaseBeforeUpdateIconsInferiors.remove(string);
        allBaseOverrideUpdateIconsSuperiors.remove(string);
        allBaseOverrideUpdateIconsInferiors.remove(string);
        allBaseAfterUpdateIconsSuperiors.remove(string);
        allBaseAfterUpdateIconsInferiors.remove(string);
        beforeUpdateIconsHookTypes.remove(string);
        overrideUpdateIconsHookTypes.remove(string);
        afterUpdateIconsHookTypes.remove(string);
        allBaseBeforeRenderSpecialHeadArmorSuperiors.remove(string);
        allBaseBeforeRenderSpecialHeadArmorInferiors.remove(string);
        allBaseOverrideRenderSpecialHeadArmorSuperiors.remove(string);
        allBaseOverrideRenderSpecialHeadArmorInferiors.remove(string);
        allBaseAfterRenderSpecialHeadArmorSuperiors.remove(string);
        allBaseAfterRenderSpecialHeadArmorInferiors.remove(string);
        beforeRenderSpecialHeadArmorHookTypes.remove(string);
        overrideRenderSpecialHeadArmorHookTypes.remove(string);
        afterRenderSpecialHeadArmorHookTypes.remove(string);
        allBaseBeforeRenderSpecialHeadEarsSuperiors.remove(string);
        allBaseBeforeRenderSpecialHeadEarsInferiors.remove(string);
        allBaseOverrideRenderSpecialHeadEarsSuperiors.remove(string);
        allBaseOverrideRenderSpecialHeadEarsInferiors.remove(string);
        allBaseAfterRenderSpecialHeadEarsSuperiors.remove(string);
        allBaseAfterRenderSpecialHeadEarsInferiors.remove(string);
        beforeRenderSpecialHeadEarsHookTypes.remove(string);
        overrideRenderSpecialHeadEarsHookTypes.remove(string);
        afterRenderSpecialHeadEarsHookTypes.remove(string);
        allBaseBeforeRenderSpecialCloakSuperiors.remove(string);
        allBaseBeforeRenderSpecialCloakInferiors.remove(string);
        allBaseOverrideRenderSpecialCloakSuperiors.remove(string);
        allBaseOverrideRenderSpecialCloakInferiors.remove(string);
        allBaseAfterRenderSpecialCloakSuperiors.remove(string);
        allBaseAfterRenderSpecialCloakInferiors.remove(string);
        beforeRenderSpecialCloakHookTypes.remove(string);
        overrideRenderSpecialCloakHookTypes.remove(string);
        afterRenderSpecialCloakHookTypes.remove(string);
        allBaseBeforeRenderSpecialItemInHandSuperiors.remove(string);
        allBaseBeforeRenderSpecialItemInHandInferiors.remove(string);
        allBaseOverrideRenderSpecialItemInHandSuperiors.remove(string);
        allBaseOverrideRenderSpecialItemInHandInferiors.remove(string);
        allBaseAfterRenderSpecialItemInHandSuperiors.remove(string);
        allBaseAfterRenderSpecialItemInHandInferiors.remove(string);
        beforeRenderSpecialItemInHandHookTypes.remove(string);
        overrideRenderSpecialItemInHandHookTypes.remove(string);
        afterRenderSpecialItemInHandHookTypes.remove(string);
        allBaseBeforePositionSpecialItemInHandSuperiors.remove(string);
        allBaseBeforePositionSpecialItemInHandInferiors.remove(string);
        allBaseOverridePositionSpecialItemInHandSuperiors.remove(string);
        allBaseOverridePositionSpecialItemInHandInferiors.remove(string);
        allBaseAfterPositionSpecialItemInHandSuperiors.remove(string);
        allBaseAfterPositionSpecialItemInHandInferiors.remove(string);
        beforePositionSpecialItemInHandHookTypes.remove(string);
        overridePositionSpecialItemInHandHookTypes.remove(string);
        afterPositionSpecialItemInHandHookTypes.remove(string);
        for (String string2 : keysToVirtualIds.keySet()) {
            if (!keysToVirtualIds.get(string2).equals(string)) continue;
            keysToVirtualIds.remove(string2);
        }
        int n = 0;
        Class<?> clazz = constructor.getDeclaringClass();
        for (String string2 : allBaseConstructors.keySet()) {
            Class<?> clazz2 = allBaseConstructors.get(string2).getDeclaringClass();
            if (string2.equals(string) || !clazz2.equals(clazz)) continue;
            n = 1;
            break;
        }
        if (n == 0) {
            dynamicTypes.remove(clazz);
            virtualDynamicHookMethods.remove(clazz);
            beforeDynamicHookMethods.remove(clazz);
            overrideDynamicHookMethods.remove(clazz);
            afterDynamicHookMethods.remove(clazz);
        }
        RenderPlayerAPI.removeDynamicHookTypes(string, beforeDynamicHookTypes);
        RenderPlayerAPI.removeDynamicHookTypes(string, overrideDynamicHookTypes);
        RenderPlayerAPI.removeDynamicHookTypes(string, afterDynamicHookTypes);
        allBaseBeforeDynamicSuperiors.remove(string);
        allBaseBeforeDynamicInferiors.remove(string);
        allBaseOverrideDynamicSuperiors.remove(string);
        allBaseOverrideDynamicInferiors.remove(string);
        allBaseAfterDynamicSuperiors.remove(string);
        allBaseAfterDynamicInferiors.remove(string);
        RenderPlayerAPI.log("RenderPlayerAPI: unregistered id '" + string + "'");
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
            boolean bl2 = bl = method.getDeclaringClass() != RenderPlayerBase.class;
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
                map = RenderPlayerAPI.addDynamicMethod(string2, method, map);
                continue;
            }
            if (bl) {
                map2 = RenderPlayerAPI.addDynamicMethod(string2, method, map2);
                continue;
            }
            if (bl4) {
                map4 = RenderPlayerAPI.addDynamicMethod(string2, method, map4);
                continue;
            }
            map3 = RenderPlayerAPI.addDynamicMethod(string2, method, map3);
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

    public static RenderPlayerAPI create(RenderPlayer renderPlayer) {
        if (allBaseConstructors.size() > 0 && !initialized) {
            RenderPlayerAPI.initialize();
        }
        return new RenderPlayerAPI(renderPlayer);
    }

    private static void initialize() {
        RenderPlayerAPI.sortBases(beforeLocalConstructingHookTypes, allBaseBeforeLocalConstructingSuperiors, allBaseBeforeLocalConstructingInferiors, "beforeLocalConstructing");
        RenderPlayerAPI.sortBases(afterLocalConstructingHookTypes, allBaseAfterLocalConstructingSuperiors, allBaseAfterLocalConstructingInferiors, "afterLocalConstructing");
        for (String string : keys) {
            RenderPlayerAPI.sortDynamicBases(beforeDynamicHookTypes, allBaseBeforeDynamicSuperiors, allBaseBeforeDynamicInferiors, string);
            RenderPlayerAPI.sortDynamicBases(overrideDynamicHookTypes, allBaseOverrideDynamicSuperiors, allBaseOverrideDynamicInferiors, string);
            RenderPlayerAPI.sortDynamicBases(afterDynamicHookTypes, allBaseAfterDynamicSuperiors, allBaseAfterDynamicInferiors, string);
        }
        RenderPlayerAPI.sortBases(beforeDoRenderLabelHookTypes, allBaseBeforeDoRenderLabelSuperiors, allBaseBeforeDoRenderLabelInferiors, "beforeDoRenderLabel");
        RenderPlayerAPI.sortBases(overrideDoRenderLabelHookTypes, allBaseOverrideDoRenderLabelSuperiors, allBaseOverrideDoRenderLabelInferiors, "overrideDoRenderLabel");
        RenderPlayerAPI.sortBases(afterDoRenderLabelHookTypes, allBaseAfterDoRenderLabelSuperiors, allBaseAfterDoRenderLabelInferiors, "afterDoRenderLabel");
        RenderPlayerAPI.sortBases(beforeDoRenderShadowAndFireHookTypes, allBaseBeforeDoRenderShadowAndFireSuperiors, allBaseBeforeDoRenderShadowAndFireInferiors, "beforeDoRenderShadowAndFire");
        RenderPlayerAPI.sortBases(overrideDoRenderShadowAndFireHookTypes, allBaseOverrideDoRenderShadowAndFireSuperiors, allBaseOverrideDoRenderShadowAndFireInferiors, "overrideDoRenderShadowAndFire");
        RenderPlayerAPI.sortBases(afterDoRenderShadowAndFireHookTypes, allBaseAfterDoRenderShadowAndFireSuperiors, allBaseAfterDoRenderShadowAndFireInferiors, "afterDoRenderShadowAndFire");
        RenderPlayerAPI.sortBases(beforeGetColorMultiplierHookTypes, allBaseBeforeGetColorMultiplierSuperiors, allBaseBeforeGetColorMultiplierInferiors, "beforeGetColorMultiplier");
        RenderPlayerAPI.sortBases(overrideGetColorMultiplierHookTypes, allBaseOverrideGetColorMultiplierSuperiors, allBaseOverrideGetColorMultiplierInferiors, "overrideGetColorMultiplier");
        RenderPlayerAPI.sortBases(afterGetColorMultiplierHookTypes, allBaseAfterGetColorMultiplierSuperiors, allBaseAfterGetColorMultiplierInferiors, "afterGetColorMultiplier");
        RenderPlayerAPI.sortBases(beforeGetDeathMaxRotationHookTypes, allBaseBeforeGetDeathMaxRotationSuperiors, allBaseBeforeGetDeathMaxRotationInferiors, "beforeGetDeathMaxRotation");
        RenderPlayerAPI.sortBases(overrideGetDeathMaxRotationHookTypes, allBaseOverrideGetDeathMaxRotationSuperiors, allBaseOverrideGetDeathMaxRotationInferiors, "overrideGetDeathMaxRotation");
        RenderPlayerAPI.sortBases(afterGetDeathMaxRotationHookTypes, allBaseAfterGetDeathMaxRotationSuperiors, allBaseAfterGetDeathMaxRotationInferiors, "afterGetDeathMaxRotation");
        RenderPlayerAPI.sortBases(beforeGetFontRendererFromRenderManagerHookTypes, allBaseBeforeGetFontRendererFromRenderManagerSuperiors, allBaseBeforeGetFontRendererFromRenderManagerInferiors, "beforeGetFontRendererFromRenderManager");
        RenderPlayerAPI.sortBases(overrideGetFontRendererFromRenderManagerHookTypes, allBaseOverrideGetFontRendererFromRenderManagerSuperiors, allBaseOverrideGetFontRendererFromRenderManagerInferiors, "overrideGetFontRendererFromRenderManager");
        RenderPlayerAPI.sortBases(afterGetFontRendererFromRenderManagerHookTypes, allBaseAfterGetFontRendererFromRenderManagerSuperiors, allBaseAfterGetFontRendererFromRenderManagerInferiors, "afterGetFontRendererFromRenderManager");
        RenderPlayerAPI.sortBases(beforeGetResourceLocationFromPlayerHookTypes, allBaseBeforeGetResourceLocationFromPlayerSuperiors, allBaseBeforeGetResourceLocationFromPlayerInferiors, "beforeGetResourceLocationFromPlayer");
        RenderPlayerAPI.sortBases(overrideGetResourceLocationFromPlayerHookTypes, allBaseOverrideGetResourceLocationFromPlayerSuperiors, allBaseOverrideGetResourceLocationFromPlayerInferiors, "overrideGetResourceLocationFromPlayer");
        RenderPlayerAPI.sortBases(afterGetResourceLocationFromPlayerHookTypes, allBaseAfterGetResourceLocationFromPlayerSuperiors, allBaseAfterGetResourceLocationFromPlayerInferiors, "afterGetResourceLocationFromPlayer");
        RenderPlayerAPI.sortBases(beforeHandleRotationFloatHookTypes, allBaseBeforeHandleRotationFloatSuperiors, allBaseBeforeHandleRotationFloatInferiors, "beforeHandleRotationFloat");
        RenderPlayerAPI.sortBases(overrideHandleRotationFloatHookTypes, allBaseOverrideHandleRotationFloatSuperiors, allBaseOverrideHandleRotationFloatInferiors, "overrideHandleRotationFloat");
        RenderPlayerAPI.sortBases(afterHandleRotationFloatHookTypes, allBaseAfterHandleRotationFloatSuperiors, allBaseAfterHandleRotationFloatInferiors, "afterHandleRotationFloat");
        RenderPlayerAPI.sortBases(beforeInheritRenderPassHookTypes, allBaseBeforeInheritRenderPassSuperiors, allBaseBeforeInheritRenderPassInferiors, "beforeInheritRenderPass");
        RenderPlayerAPI.sortBases(overrideInheritRenderPassHookTypes, allBaseOverrideInheritRenderPassSuperiors, allBaseOverrideInheritRenderPassInferiors, "overrideInheritRenderPass");
        RenderPlayerAPI.sortBases(afterInheritRenderPassHookTypes, allBaseAfterInheritRenderPassSuperiors, allBaseAfterInheritRenderPassInferiors, "afterInheritRenderPass");
        RenderPlayerAPI.sortBases(beforeLoadTextureHookTypes, allBaseBeforeLoadTextureSuperiors, allBaseBeforeLoadTextureInferiors, "beforeLoadTexture");
        RenderPlayerAPI.sortBases(overrideLoadTextureHookTypes, allBaseOverrideLoadTextureSuperiors, allBaseOverrideLoadTextureInferiors, "overrideLoadTexture");
        RenderPlayerAPI.sortBases(afterLoadTextureHookTypes, allBaseAfterLoadTextureSuperiors, allBaseAfterLoadTextureInferiors, "afterLoadTexture");
        RenderPlayerAPI.sortBases(beforeLoadTextureOfEntityHookTypes, allBaseBeforeLoadTextureOfEntitySuperiors, allBaseBeforeLoadTextureOfEntityInferiors, "beforeLoadTextureOfEntity");
        RenderPlayerAPI.sortBases(overrideLoadTextureOfEntityHookTypes, allBaseOverrideLoadTextureOfEntitySuperiors, allBaseOverrideLoadTextureOfEntityInferiors, "overrideLoadTextureOfEntity");
        RenderPlayerAPI.sortBases(afterLoadTextureOfEntityHookTypes, allBaseAfterLoadTextureOfEntitySuperiors, allBaseAfterLoadTextureOfEntityInferiors, "afterLoadTextureOfEntity");
        RenderPlayerAPI.sortBases(beforePassSpecialRenderHookTypes, allBaseBeforePassSpecialRenderSuperiors, allBaseBeforePassSpecialRenderInferiors, "beforePassSpecialRender");
        RenderPlayerAPI.sortBases(overridePassSpecialRenderHookTypes, allBaseOverridePassSpecialRenderSuperiors, allBaseOverridePassSpecialRenderInferiors, "overridePassSpecialRender");
        RenderPlayerAPI.sortBases(afterPassSpecialRenderHookTypes, allBaseAfterPassSpecialRenderSuperiors, allBaseAfterPassSpecialRenderInferiors, "afterPassSpecialRender");
        RenderPlayerAPI.sortBases(beforeRenderArrowsStuckInEntityHookTypes, allBaseBeforeRenderArrowsStuckInEntitySuperiors, allBaseBeforeRenderArrowsStuckInEntityInferiors, "beforeRenderArrowsStuckInEntity");
        RenderPlayerAPI.sortBases(overrideRenderArrowsStuckInEntityHookTypes, allBaseOverrideRenderArrowsStuckInEntitySuperiors, allBaseOverrideRenderArrowsStuckInEntityInferiors, "overrideRenderArrowsStuckInEntity");
        RenderPlayerAPI.sortBases(afterRenderArrowsStuckInEntityHookTypes, allBaseAfterRenderArrowsStuckInEntitySuperiors, allBaseAfterRenderArrowsStuckInEntityInferiors, "afterRenderArrowsStuckInEntity");
        RenderPlayerAPI.sortBases(beforeRenderFirstPersonArmHookTypes, allBaseBeforeRenderFirstPersonArmSuperiors, allBaseBeforeRenderFirstPersonArmInferiors, "beforeRenderFirstPersonArm");
        RenderPlayerAPI.sortBases(overrideRenderFirstPersonArmHookTypes, allBaseOverrideRenderFirstPersonArmSuperiors, allBaseOverrideRenderFirstPersonArmInferiors, "overrideRenderFirstPersonArm");
        RenderPlayerAPI.sortBases(afterRenderFirstPersonArmHookTypes, allBaseAfterRenderFirstPersonArmSuperiors, allBaseAfterRenderFirstPersonArmInferiors, "afterRenderFirstPersonArm");
        RenderPlayerAPI.sortBases(beforeRenderLivingLabelHookTypes, allBaseBeforeRenderLivingLabelSuperiors, allBaseBeforeRenderLivingLabelInferiors, "beforeRenderLivingLabel");
        RenderPlayerAPI.sortBases(overrideRenderLivingLabelHookTypes, allBaseOverrideRenderLivingLabelSuperiors, allBaseOverrideRenderLivingLabelInferiors, "overrideRenderLivingLabel");
        RenderPlayerAPI.sortBases(afterRenderLivingLabelHookTypes, allBaseAfterRenderLivingLabelSuperiors, allBaseAfterRenderLivingLabelInferiors, "afterRenderLivingLabel");
        RenderPlayerAPI.sortBases(beforeRenderModelHookTypes, allBaseBeforeRenderModelSuperiors, allBaseBeforeRenderModelInferiors, "beforeRenderModel");
        RenderPlayerAPI.sortBases(overrideRenderModelHookTypes, allBaseOverrideRenderModelSuperiors, allBaseOverrideRenderModelInferiors, "overrideRenderModel");
        RenderPlayerAPI.sortBases(afterRenderModelHookTypes, allBaseAfterRenderModelSuperiors, allBaseAfterRenderModelInferiors, "afterRenderModel");
        RenderPlayerAPI.sortBases(beforeRenderPlayerHookTypes, allBaseBeforeRenderPlayerSuperiors, allBaseBeforeRenderPlayerInferiors, "beforeRenderPlayer");
        RenderPlayerAPI.sortBases(overrideRenderPlayerHookTypes, allBaseOverrideRenderPlayerSuperiors, allBaseOverrideRenderPlayerInferiors, "overrideRenderPlayer");
        RenderPlayerAPI.sortBases(afterRenderPlayerHookTypes, allBaseAfterRenderPlayerSuperiors, allBaseAfterRenderPlayerInferiors, "afterRenderPlayer");
        RenderPlayerAPI.sortBases(beforeRenderPlayerNameAndScoreLabelHookTypes, allBaseBeforeRenderPlayerNameAndScoreLabelSuperiors, allBaseBeforeRenderPlayerNameAndScoreLabelInferiors, "beforeRenderPlayerNameAndScoreLabel");
        RenderPlayerAPI.sortBases(overrideRenderPlayerNameAndScoreLabelHookTypes, allBaseOverrideRenderPlayerNameAndScoreLabelSuperiors, allBaseOverrideRenderPlayerNameAndScoreLabelInferiors, "overrideRenderPlayerNameAndScoreLabel");
        RenderPlayerAPI.sortBases(afterRenderPlayerNameAndScoreLabelHookTypes, allBaseAfterRenderPlayerNameAndScoreLabelSuperiors, allBaseAfterRenderPlayerNameAndScoreLabelInferiors, "afterRenderPlayerNameAndScoreLabel");
        RenderPlayerAPI.sortBases(beforeRenderPlayerScaleHookTypes, allBaseBeforeRenderPlayerScaleSuperiors, allBaseBeforeRenderPlayerScaleInferiors, "beforeRenderPlayerScale");
        RenderPlayerAPI.sortBases(overrideRenderPlayerScaleHookTypes, allBaseOverrideRenderPlayerScaleSuperiors, allBaseOverrideRenderPlayerScaleInferiors, "overrideRenderPlayerScale");
        RenderPlayerAPI.sortBases(afterRenderPlayerScaleHookTypes, allBaseAfterRenderPlayerScaleSuperiors, allBaseAfterRenderPlayerScaleInferiors, "afterRenderPlayerScale");
        RenderPlayerAPI.sortBases(beforeRenderPlayerSleepHookTypes, allBaseBeforeRenderPlayerSleepSuperiors, allBaseBeforeRenderPlayerSleepInferiors, "beforeRenderPlayerSleep");
        RenderPlayerAPI.sortBases(overrideRenderPlayerSleepHookTypes, allBaseOverrideRenderPlayerSleepSuperiors, allBaseOverrideRenderPlayerSleepInferiors, "overrideRenderPlayerSleep");
        RenderPlayerAPI.sortBases(afterRenderPlayerSleepHookTypes, allBaseAfterRenderPlayerSleepSuperiors, allBaseAfterRenderPlayerSleepInferiors, "afterRenderPlayerSleep");
        RenderPlayerAPI.sortBases(beforeRenderSpecialsHookTypes, allBaseBeforeRenderSpecialsSuperiors, allBaseBeforeRenderSpecialsInferiors, "beforeRenderSpecials");
        RenderPlayerAPI.sortBases(overrideRenderSpecialsHookTypes, allBaseOverrideRenderSpecialsSuperiors, allBaseOverrideRenderSpecialsInferiors, "overrideRenderSpecials");
        RenderPlayerAPI.sortBases(afterRenderSpecialsHookTypes, allBaseAfterRenderSpecialsSuperiors, allBaseAfterRenderSpecialsInferiors, "afterRenderSpecials");
        RenderPlayerAPI.sortBases(beforeRenderSwingProgressHookTypes, allBaseBeforeRenderSwingProgressSuperiors, allBaseBeforeRenderSwingProgressInferiors, "beforeRenderSwingProgress");
        RenderPlayerAPI.sortBases(overrideRenderSwingProgressHookTypes, allBaseOverrideRenderSwingProgressSuperiors, allBaseOverrideRenderSwingProgressInferiors, "overrideRenderSwingProgress");
        RenderPlayerAPI.sortBases(afterRenderSwingProgressHookTypes, allBaseAfterRenderSwingProgressSuperiors, allBaseAfterRenderSwingProgressInferiors, "afterRenderSwingProgress");
        RenderPlayerAPI.sortBases(beforeRotatePlayerHookTypes, allBaseBeforeRotatePlayerSuperiors, allBaseBeforeRotatePlayerInferiors, "beforeRotatePlayer");
        RenderPlayerAPI.sortBases(overrideRotatePlayerHookTypes, allBaseOverrideRotatePlayerSuperiors, allBaseOverrideRotatePlayerInferiors, "overrideRotatePlayer");
        RenderPlayerAPI.sortBases(afterRotatePlayerHookTypes, allBaseAfterRotatePlayerSuperiors, allBaseAfterRotatePlayerInferiors, "afterRotatePlayer");
        RenderPlayerAPI.sortBases(beforeSetArmorModelHookTypes, allBaseBeforeSetArmorModelSuperiors, allBaseBeforeSetArmorModelInferiors, "beforeSetArmorModel");
        RenderPlayerAPI.sortBases(overrideSetArmorModelHookTypes, allBaseOverrideSetArmorModelSuperiors, allBaseOverrideSetArmorModelInferiors, "overrideSetArmorModel");
        RenderPlayerAPI.sortBases(afterSetArmorModelHookTypes, allBaseAfterSetArmorModelSuperiors, allBaseAfterSetArmorModelInferiors, "afterSetArmorModel");
        RenderPlayerAPI.sortBases(beforeSetPassArmorModelHookTypes, allBaseBeforeSetPassArmorModelSuperiors, allBaseBeforeSetPassArmorModelInferiors, "beforeSetPassArmorModel");
        RenderPlayerAPI.sortBases(overrideSetPassArmorModelHookTypes, allBaseOverrideSetPassArmorModelSuperiors, allBaseOverrideSetPassArmorModelInferiors, "overrideSetPassArmorModel");
        RenderPlayerAPI.sortBases(afterSetPassArmorModelHookTypes, allBaseAfterSetPassArmorModelSuperiors, allBaseAfterSetPassArmorModelInferiors, "afterSetPassArmorModel");
        RenderPlayerAPI.sortBases(beforeSetRenderManagerHookTypes, allBaseBeforeSetRenderManagerSuperiors, allBaseBeforeSetRenderManagerInferiors, "beforeSetRenderManager");
        RenderPlayerAPI.sortBases(overrideSetRenderManagerHookTypes, allBaseOverrideSetRenderManagerSuperiors, allBaseOverrideSetRenderManagerInferiors, "overrideSetRenderManager");
        RenderPlayerAPI.sortBases(afterSetRenderManagerHookTypes, allBaseAfterSetRenderManagerSuperiors, allBaseAfterSetRenderManagerInferiors, "afterSetRenderManager");
        RenderPlayerAPI.sortBases(beforeSetRenderPassModelHookTypes, allBaseBeforeSetRenderPassModelSuperiors, allBaseBeforeSetRenderPassModelInferiors, "beforeSetRenderPassModel");
        RenderPlayerAPI.sortBases(overrideSetRenderPassModelHookTypes, allBaseOverrideSetRenderPassModelSuperiors, allBaseOverrideSetRenderPassModelInferiors, "overrideSetRenderPassModel");
        RenderPlayerAPI.sortBases(afterSetRenderPassModelHookTypes, allBaseAfterSetRenderPassModelSuperiors, allBaseAfterSetRenderPassModelInferiors, "afterSetRenderPassModel");
        RenderPlayerAPI.sortBases(beforeUpdateIconsHookTypes, allBaseBeforeUpdateIconsSuperiors, allBaseBeforeUpdateIconsInferiors, "beforeUpdateIcons");
        RenderPlayerAPI.sortBases(overrideUpdateIconsHookTypes, allBaseOverrideUpdateIconsSuperiors, allBaseOverrideUpdateIconsInferiors, "overrideUpdateIcons");
        RenderPlayerAPI.sortBases(afterUpdateIconsHookTypes, allBaseAfterUpdateIconsSuperiors, allBaseAfterUpdateIconsInferiors, "afterUpdateIcons");
        RenderPlayerAPI.sortBases(beforeRenderSpecialHeadArmorHookTypes, allBaseBeforeRenderSpecialHeadArmorSuperiors, allBaseBeforeRenderSpecialHeadArmorInferiors, "beforeRenderSpecialHeadArmor");
        RenderPlayerAPI.sortBases(overrideRenderSpecialHeadArmorHookTypes, allBaseOverrideRenderSpecialHeadArmorSuperiors, allBaseOverrideRenderSpecialHeadArmorInferiors, "overrideRenderSpecialHeadArmor");
        RenderPlayerAPI.sortBases(afterRenderSpecialHeadArmorHookTypes, allBaseAfterRenderSpecialHeadArmorSuperiors, allBaseAfterRenderSpecialHeadArmorInferiors, "afterRenderSpecialHeadArmor");
        RenderPlayerAPI.sortBases(beforeRenderSpecialHeadEarsHookTypes, allBaseBeforeRenderSpecialHeadEarsSuperiors, allBaseBeforeRenderSpecialHeadEarsInferiors, "beforeRenderSpecialHeadEars");
        RenderPlayerAPI.sortBases(overrideRenderSpecialHeadEarsHookTypes, allBaseOverrideRenderSpecialHeadEarsSuperiors, allBaseOverrideRenderSpecialHeadEarsInferiors, "overrideRenderSpecialHeadEars");
        RenderPlayerAPI.sortBases(afterRenderSpecialHeadEarsHookTypes, allBaseAfterRenderSpecialHeadEarsSuperiors, allBaseAfterRenderSpecialHeadEarsInferiors, "afterRenderSpecialHeadEars");
        RenderPlayerAPI.sortBases(beforeRenderSpecialCloakHookTypes, allBaseBeforeRenderSpecialCloakSuperiors, allBaseBeforeRenderSpecialCloakInferiors, "beforeRenderSpecialCloak");
        RenderPlayerAPI.sortBases(overrideRenderSpecialCloakHookTypes, allBaseOverrideRenderSpecialCloakSuperiors, allBaseOverrideRenderSpecialCloakInferiors, "overrideRenderSpecialCloak");
        RenderPlayerAPI.sortBases(afterRenderSpecialCloakHookTypes, allBaseAfterRenderSpecialCloakSuperiors, allBaseAfterRenderSpecialCloakInferiors, "afterRenderSpecialCloak");
        RenderPlayerAPI.sortBases(beforeRenderSpecialItemInHandHookTypes, allBaseBeforeRenderSpecialItemInHandSuperiors, allBaseBeforeRenderSpecialItemInHandInferiors, "beforeRenderSpecialItemInHand");
        RenderPlayerAPI.sortBases(overrideRenderSpecialItemInHandHookTypes, allBaseOverrideRenderSpecialItemInHandSuperiors, allBaseOverrideRenderSpecialItemInHandInferiors, "overrideRenderSpecialItemInHand");
        RenderPlayerAPI.sortBases(afterRenderSpecialItemInHandHookTypes, allBaseAfterRenderSpecialItemInHandSuperiors, allBaseAfterRenderSpecialItemInHandInferiors, "afterRenderSpecialItemInHand");
        RenderPlayerAPI.sortBases(beforePositionSpecialItemInHandHookTypes, allBaseBeforePositionSpecialItemInHandSuperiors, allBaseBeforePositionSpecialItemInHandInferiors, "beforePositionSpecialItemInHand");
        RenderPlayerAPI.sortBases(overridePositionSpecialItemInHandHookTypes, allBaseOverridePositionSpecialItemInHandSuperiors, allBaseOverridePositionSpecialItemInHandInferiors, "overridePositionSpecialItemInHand");
        RenderPlayerAPI.sortBases(afterPositionSpecialItemInHandHookTypes, allBaseAfterPositionSpecialItemInHandSuperiors, allBaseAfterPositionSpecialItemInHandInferiors, "afterPositionSpecialItemInHand");
        initialized = true;
    }

    public static void beforeLocalConstructing(RenderPlayer renderPlayer) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.beforeLocalConstructing();
        }
    }

    public static void afterLocalConstructing(RenderPlayer renderPlayer) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.afterLocalConstructing();
        }
    }

    private static void sortBases(List<String> list2, Map<String, String[]> map, Map<String, String[]> map2, String string) {
        new RenderPlayerBaseSorter(list2, map, map2, string).Sort();
    }

    private static void sortDynamicBases(Map<String, List<String>> map, Map<String, Map<String, String[]>> map2, Map<String, Map<String, String[]>> map3, String string) {
        List<String> list2 = map.get(string);
        if (list2 != null && list2.size() > 1) {
            RenderPlayerAPI.sortBases(list2, RenderPlayerAPI.getDynamicSorters(string, list2, map2), RenderPlayerAPI.getDynamicSorters(string, list2, map3), string);
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

    private RenderPlayerAPI(RenderPlayer renderPlayer) {
        this.renderPlayer = renderPlayer;
        RenderPlayerAPI.initializer[0] = this;
        RenderPlayerAPI.initializers[0] = this;
        for (String string : allBaseConstructors.keySet()) {
            RenderPlayerBase renderPlayerBase = this.createRenderPlayerBase(string);
            renderPlayerBase.beforeBaseAttach(false);
            this.allBaseObjects.put(string, renderPlayerBase);
            this.baseObjectsToId.put(renderPlayerBase, string);
        }
        this.beforeLocalConstructingHooks = this.create(beforeLocalConstructingHookTypes);
        this.afterLocalConstructingHooks = this.create(afterLocalConstructingHookTypes);
        this.updateRenderPlayerBases();
        Iterator<String> iterator2 = this.allBaseObjects.keySet().iterator();
        while (iterator2.hasNext()) {
            this.allBaseObjects.get(iterator2.next()).afterBaseAttach(false);
        }
    }

    private RenderPlayerBase createRenderPlayerBase(String string) {
        RenderPlayerBase renderPlayerBase;
        Constructor<?> constructor = allBaseConstructors.get(string);
        RenderPlayerAPI.initializers[1] = string;
        try {
            renderPlayerBase = constructor.getParameterTypes().length == 1 ? (RenderPlayerBase)constructor.newInstance(initializer) : (RenderPlayerBase)constructor.newInstance(initializers);
        }
        catch (Exception exception) {
            throw new RuntimeException("Exception while creating a RenderPlayerBase of type '" + constructor.getDeclaringClass() + "'", exception);
        }
        return renderPlayerBase;
    }

    private void updateRenderPlayerBases() {
        this.beforeDoRenderLabelHooks = this.create(beforeDoRenderLabelHookTypes);
        this.overrideDoRenderLabelHooks = this.create(overrideDoRenderLabelHookTypes);
        this.afterDoRenderLabelHooks = this.create(afterDoRenderLabelHookTypes);
        this.isDoRenderLabelModded = this.beforeDoRenderLabelHooks != null || this.overrideDoRenderLabelHooks != null || this.afterDoRenderLabelHooks != null;
        this.beforeDoRenderShadowAndFireHooks = this.create(beforeDoRenderShadowAndFireHookTypes);
        this.overrideDoRenderShadowAndFireHooks = this.create(overrideDoRenderShadowAndFireHookTypes);
        this.afterDoRenderShadowAndFireHooks = this.create(afterDoRenderShadowAndFireHookTypes);
        this.isDoRenderShadowAndFireModded = this.beforeDoRenderShadowAndFireHooks != null || this.overrideDoRenderShadowAndFireHooks != null || this.afterDoRenderShadowAndFireHooks != null;
        this.beforeGetColorMultiplierHooks = this.create(beforeGetColorMultiplierHookTypes);
        this.overrideGetColorMultiplierHooks = this.create(overrideGetColorMultiplierHookTypes);
        this.afterGetColorMultiplierHooks = this.create(afterGetColorMultiplierHookTypes);
        this.isGetColorMultiplierModded = this.beforeGetColorMultiplierHooks != null || this.overrideGetColorMultiplierHooks != null || this.afterGetColorMultiplierHooks != null;
        this.beforeGetDeathMaxRotationHooks = this.create(beforeGetDeathMaxRotationHookTypes);
        this.overrideGetDeathMaxRotationHooks = this.create(overrideGetDeathMaxRotationHookTypes);
        this.afterGetDeathMaxRotationHooks = this.create(afterGetDeathMaxRotationHookTypes);
        this.isGetDeathMaxRotationModded = this.beforeGetDeathMaxRotationHooks != null || this.overrideGetDeathMaxRotationHooks != null || this.afterGetDeathMaxRotationHooks != null;
        this.beforeGetFontRendererFromRenderManagerHooks = this.create(beforeGetFontRendererFromRenderManagerHookTypes);
        this.overrideGetFontRendererFromRenderManagerHooks = this.create(overrideGetFontRendererFromRenderManagerHookTypes);
        this.afterGetFontRendererFromRenderManagerHooks = this.create(afterGetFontRendererFromRenderManagerHookTypes);
        this.isGetFontRendererFromRenderManagerModded = this.beforeGetFontRendererFromRenderManagerHooks != null || this.overrideGetFontRendererFromRenderManagerHooks != null || this.afterGetFontRendererFromRenderManagerHooks != null;
        this.beforeGetResourceLocationFromPlayerHooks = this.create(beforeGetResourceLocationFromPlayerHookTypes);
        this.overrideGetResourceLocationFromPlayerHooks = this.create(overrideGetResourceLocationFromPlayerHookTypes);
        this.afterGetResourceLocationFromPlayerHooks = this.create(afterGetResourceLocationFromPlayerHookTypes);
        this.isGetResourceLocationFromPlayerModded = this.beforeGetResourceLocationFromPlayerHooks != null || this.overrideGetResourceLocationFromPlayerHooks != null || this.afterGetResourceLocationFromPlayerHooks != null;
        this.beforeHandleRotationFloatHooks = this.create(beforeHandleRotationFloatHookTypes);
        this.overrideHandleRotationFloatHooks = this.create(overrideHandleRotationFloatHookTypes);
        this.afterHandleRotationFloatHooks = this.create(afterHandleRotationFloatHookTypes);
        this.isHandleRotationFloatModded = this.beforeHandleRotationFloatHooks != null || this.overrideHandleRotationFloatHooks != null || this.afterHandleRotationFloatHooks != null;
        this.beforeInheritRenderPassHooks = this.create(beforeInheritRenderPassHookTypes);
        this.overrideInheritRenderPassHooks = this.create(overrideInheritRenderPassHookTypes);
        this.afterInheritRenderPassHooks = this.create(afterInheritRenderPassHookTypes);
        this.isInheritRenderPassModded = this.beforeInheritRenderPassHooks != null || this.overrideInheritRenderPassHooks != null || this.afterInheritRenderPassHooks != null;
        this.beforeLoadTextureHooks = this.create(beforeLoadTextureHookTypes);
        this.overrideLoadTextureHooks = this.create(overrideLoadTextureHookTypes);
        this.afterLoadTextureHooks = this.create(afterLoadTextureHookTypes);
        this.isLoadTextureModded = this.beforeLoadTextureHooks != null || this.overrideLoadTextureHooks != null || this.afterLoadTextureHooks != null;
        this.beforeLoadTextureOfEntityHooks = this.create(beforeLoadTextureOfEntityHookTypes);
        this.overrideLoadTextureOfEntityHooks = this.create(overrideLoadTextureOfEntityHookTypes);
        this.afterLoadTextureOfEntityHooks = this.create(afterLoadTextureOfEntityHookTypes);
        this.isLoadTextureOfEntityModded = this.beforeLoadTextureOfEntityHooks != null || this.overrideLoadTextureOfEntityHooks != null || this.afterLoadTextureOfEntityHooks != null;
        this.beforePassSpecialRenderHooks = this.create(beforePassSpecialRenderHookTypes);
        this.overridePassSpecialRenderHooks = this.create(overridePassSpecialRenderHookTypes);
        this.afterPassSpecialRenderHooks = this.create(afterPassSpecialRenderHookTypes);
        this.isPassSpecialRenderModded = this.beforePassSpecialRenderHooks != null || this.overridePassSpecialRenderHooks != null || this.afterPassSpecialRenderHooks != null;
        this.beforeRenderArrowsStuckInEntityHooks = this.create(beforeRenderArrowsStuckInEntityHookTypes);
        this.overrideRenderArrowsStuckInEntityHooks = this.create(overrideRenderArrowsStuckInEntityHookTypes);
        this.afterRenderArrowsStuckInEntityHooks = this.create(afterRenderArrowsStuckInEntityHookTypes);
        this.isRenderArrowsStuckInEntityModded = this.beforeRenderArrowsStuckInEntityHooks != null || this.overrideRenderArrowsStuckInEntityHooks != null || this.afterRenderArrowsStuckInEntityHooks != null;
        this.beforeRenderFirstPersonArmHooks = this.create(beforeRenderFirstPersonArmHookTypes);
        this.overrideRenderFirstPersonArmHooks = this.create(overrideRenderFirstPersonArmHookTypes);
        this.afterRenderFirstPersonArmHooks = this.create(afterRenderFirstPersonArmHookTypes);
        this.isRenderFirstPersonArmModded = this.beforeRenderFirstPersonArmHooks != null || this.overrideRenderFirstPersonArmHooks != null || this.afterRenderFirstPersonArmHooks != null;
        this.beforeRenderLivingLabelHooks = this.create(beforeRenderLivingLabelHookTypes);
        this.overrideRenderLivingLabelHooks = this.create(overrideRenderLivingLabelHookTypes);
        this.afterRenderLivingLabelHooks = this.create(afterRenderLivingLabelHookTypes);
        this.isRenderLivingLabelModded = this.beforeRenderLivingLabelHooks != null || this.overrideRenderLivingLabelHooks != null || this.afterRenderLivingLabelHooks != null;
        this.beforeRenderModelHooks = this.create(beforeRenderModelHookTypes);
        this.overrideRenderModelHooks = this.create(overrideRenderModelHookTypes);
        this.afterRenderModelHooks = this.create(afterRenderModelHookTypes);
        this.isRenderModelModded = this.beforeRenderModelHooks != null || this.overrideRenderModelHooks != null || this.afterRenderModelHooks != null;
        this.beforeRenderPlayerHooks = this.create(beforeRenderPlayerHookTypes);
        this.overrideRenderPlayerHooks = this.create(overrideRenderPlayerHookTypes);
        this.afterRenderPlayerHooks = this.create(afterRenderPlayerHookTypes);
        this.isRenderPlayerModded = this.beforeRenderPlayerHooks != null || this.overrideRenderPlayerHooks != null || this.afterRenderPlayerHooks != null;
        this.beforeRenderPlayerNameAndScoreLabelHooks = this.create(beforeRenderPlayerNameAndScoreLabelHookTypes);
        this.overrideRenderPlayerNameAndScoreLabelHooks = this.create(overrideRenderPlayerNameAndScoreLabelHookTypes);
        this.afterRenderPlayerNameAndScoreLabelHooks = this.create(afterRenderPlayerNameAndScoreLabelHookTypes);
        this.isRenderPlayerNameAndScoreLabelModded = this.beforeRenderPlayerNameAndScoreLabelHooks != null || this.overrideRenderPlayerNameAndScoreLabelHooks != null || this.afterRenderPlayerNameAndScoreLabelHooks != null;
        this.beforeRenderPlayerScaleHooks = this.create(beforeRenderPlayerScaleHookTypes);
        this.overrideRenderPlayerScaleHooks = this.create(overrideRenderPlayerScaleHookTypes);
        this.afterRenderPlayerScaleHooks = this.create(afterRenderPlayerScaleHookTypes);
        this.isRenderPlayerScaleModded = this.beforeRenderPlayerScaleHooks != null || this.overrideRenderPlayerScaleHooks != null || this.afterRenderPlayerScaleHooks != null;
        this.beforeRenderPlayerSleepHooks = this.create(beforeRenderPlayerSleepHookTypes);
        this.overrideRenderPlayerSleepHooks = this.create(overrideRenderPlayerSleepHookTypes);
        this.afterRenderPlayerSleepHooks = this.create(afterRenderPlayerSleepHookTypes);
        this.isRenderPlayerSleepModded = this.beforeRenderPlayerSleepHooks != null || this.overrideRenderPlayerSleepHooks != null || this.afterRenderPlayerSleepHooks != null;
        this.beforeRenderSpecialsHooks = this.create(beforeRenderSpecialsHookTypes);
        this.overrideRenderSpecialsHooks = this.create(overrideRenderSpecialsHookTypes);
        this.afterRenderSpecialsHooks = this.create(afterRenderSpecialsHookTypes);
        this.isRenderSpecialsModded = this.beforeRenderSpecialsHooks != null || this.overrideRenderSpecialsHooks != null || this.afterRenderSpecialsHooks != null;
        this.beforeRenderSwingProgressHooks = this.create(beforeRenderSwingProgressHookTypes);
        this.overrideRenderSwingProgressHooks = this.create(overrideRenderSwingProgressHookTypes);
        this.afterRenderSwingProgressHooks = this.create(afterRenderSwingProgressHookTypes);
        this.isRenderSwingProgressModded = this.beforeRenderSwingProgressHooks != null || this.overrideRenderSwingProgressHooks != null || this.afterRenderSwingProgressHooks != null;
        this.beforeRotatePlayerHooks = this.create(beforeRotatePlayerHookTypes);
        this.overrideRotatePlayerHooks = this.create(overrideRotatePlayerHookTypes);
        this.afterRotatePlayerHooks = this.create(afterRotatePlayerHookTypes);
        this.isRotatePlayerModded = this.beforeRotatePlayerHooks != null || this.overrideRotatePlayerHooks != null || this.afterRotatePlayerHooks != null;
        this.beforeSetArmorModelHooks = this.create(beforeSetArmorModelHookTypes);
        this.overrideSetArmorModelHooks = this.create(overrideSetArmorModelHookTypes);
        this.afterSetArmorModelHooks = this.create(afterSetArmorModelHookTypes);
        this.isSetArmorModelModded = this.beforeSetArmorModelHooks != null || this.overrideSetArmorModelHooks != null || this.afterSetArmorModelHooks != null;
        this.beforeSetPassArmorModelHooks = this.create(beforeSetPassArmorModelHookTypes);
        this.overrideSetPassArmorModelHooks = this.create(overrideSetPassArmorModelHookTypes);
        this.afterSetPassArmorModelHooks = this.create(afterSetPassArmorModelHookTypes);
        this.isSetPassArmorModelModded = this.beforeSetPassArmorModelHooks != null || this.overrideSetPassArmorModelHooks != null || this.afterSetPassArmorModelHooks != null;
        this.beforeSetRenderManagerHooks = this.create(beforeSetRenderManagerHookTypes);
        this.overrideSetRenderManagerHooks = this.create(overrideSetRenderManagerHookTypes);
        this.afterSetRenderManagerHooks = this.create(afterSetRenderManagerHookTypes);
        this.isSetRenderManagerModded = this.beforeSetRenderManagerHooks != null || this.overrideSetRenderManagerHooks != null || this.afterSetRenderManagerHooks != null;
        this.beforeSetRenderPassModelHooks = this.create(beforeSetRenderPassModelHookTypes);
        this.overrideSetRenderPassModelHooks = this.create(overrideSetRenderPassModelHookTypes);
        this.afterSetRenderPassModelHooks = this.create(afterSetRenderPassModelHookTypes);
        this.isSetRenderPassModelModded = this.beforeSetRenderPassModelHooks != null || this.overrideSetRenderPassModelHooks != null || this.afterSetRenderPassModelHooks != null;
        this.beforeUpdateIconsHooks = this.create(beforeUpdateIconsHookTypes);
        this.overrideUpdateIconsHooks = this.create(overrideUpdateIconsHookTypes);
        this.afterUpdateIconsHooks = this.create(afterUpdateIconsHookTypes);
        this.isUpdateIconsModded = this.beforeUpdateIconsHooks != null || this.overrideUpdateIconsHooks != null || this.afterUpdateIconsHooks != null;
        this.beforeRenderSpecialHeadArmorHooks = this.create(beforeRenderSpecialHeadArmorHookTypes);
        this.overrideRenderSpecialHeadArmorHooks = this.create(overrideRenderSpecialHeadArmorHookTypes);
        this.afterRenderSpecialHeadArmorHooks = this.create(afterRenderSpecialHeadArmorHookTypes);
        this.isRenderSpecialHeadArmorModded = this.beforeRenderSpecialHeadArmorHooks != null || this.overrideRenderSpecialHeadArmorHooks != null || this.afterRenderSpecialHeadArmorHooks != null;
        this.beforeRenderSpecialHeadEarsHooks = this.create(beforeRenderSpecialHeadEarsHookTypes);
        this.overrideRenderSpecialHeadEarsHooks = this.create(overrideRenderSpecialHeadEarsHookTypes);
        this.afterRenderSpecialHeadEarsHooks = this.create(afterRenderSpecialHeadEarsHookTypes);
        this.isRenderSpecialHeadEarsModded = this.beforeRenderSpecialHeadEarsHooks != null || this.overrideRenderSpecialHeadEarsHooks != null || this.afterRenderSpecialHeadEarsHooks != null;
        this.beforeRenderSpecialCloakHooks = this.create(beforeRenderSpecialCloakHookTypes);
        this.overrideRenderSpecialCloakHooks = this.create(overrideRenderSpecialCloakHookTypes);
        this.afterRenderSpecialCloakHooks = this.create(afterRenderSpecialCloakHookTypes);
        this.isRenderSpecialCloakModded = this.beforeRenderSpecialCloakHooks != null || this.overrideRenderSpecialCloakHooks != null || this.afterRenderSpecialCloakHooks != null;
        this.beforeRenderSpecialItemInHandHooks = this.create(beforeRenderSpecialItemInHandHookTypes);
        this.overrideRenderSpecialItemInHandHooks = this.create(overrideRenderSpecialItemInHandHookTypes);
        this.afterRenderSpecialItemInHandHooks = this.create(afterRenderSpecialItemInHandHookTypes);
        this.isRenderSpecialItemInHandModded = this.beforeRenderSpecialItemInHandHooks != null || this.overrideRenderSpecialItemInHandHooks != null || this.afterRenderSpecialItemInHandHooks != null;
        this.beforePositionSpecialItemInHandHooks = this.create(beforePositionSpecialItemInHandHookTypes);
        this.overridePositionSpecialItemInHandHooks = this.create(overridePositionSpecialItemInHandHookTypes);
        this.afterPositionSpecialItemInHandHooks = this.create(afterPositionSpecialItemInHandHookTypes);
        this.isPositionSpecialItemInHandModded = this.beforePositionSpecialItemInHandHooks != null || this.overridePositionSpecialItemInHandHooks != null || this.afterPositionSpecialItemInHandHooks != null;
    }

    private void attachRenderPlayerBase(String string) {
        RenderPlayerAPI.initializer[0] = this;
        RenderPlayerAPI.initializers[0] = this;
        RenderPlayerBase renderPlayerBase = this.createRenderPlayerBase(string);
        renderPlayerBase.beforeBaseAttach(true);
        this.allBaseObjects.put(string, renderPlayerBase);
        this.updateRenderPlayerBases();
        renderPlayerBase.afterBaseAttach(true);
    }

    private void detachRenderPlayerBase(String string) {
        RenderPlayerBase renderPlayerBase = this.allBaseObjects.get(string);
        renderPlayerBase.beforeBaseDetach(true);
        this.allBaseObjects.remove(string);
        this.updateRenderPlayerBases();
        renderPlayerBase.afterBaseDetach(true);
    }

    private RenderPlayerBase[] create(List<String> list2) {
        if (list2.isEmpty()) {
            return null;
        }
        RenderPlayerBase[] renderPlayerBaseArray = new RenderPlayerBase[list2.size()];
        for (int i = 0; i < renderPlayerBaseArray.length; ++i) {
            renderPlayerBaseArray[i] = this.getRenderPlayerBase(list2.get(i));
        }
        return renderPlayerBaseArray;
    }

    private void beforeLocalConstructing() {
        if (this.beforeLocalConstructingHooks != null) {
            for (int i = this.beforeLocalConstructingHooks.length - 1; i >= 0; --i) {
                this.beforeLocalConstructingHooks[i].beforeLocalConstructing();
            }
        }
        this.beforeLocalConstructingHooks = null;
    }

    private void afterLocalConstructing() {
        if (this.afterLocalConstructingHooks != null) {
            for (int i = 0; i < this.afterLocalConstructingHooks.length; ++i) {
                this.afterLocalConstructingHooks[i].afterLocalConstructing();
            }
        }
        this.afterLocalConstructingHooks = null;
    }

    public RenderPlayerBase getRenderPlayerBase(String string) {
        return this.allBaseObjects.get(string);
    }

    public Set<String> getRenderPlayerBaseIds() {
        return this.unmodifiableAllBaseIds;
    }

    public Object dynamic(String string, Object[] objectArray) {
        string = string.replace('.', '_').replace(' ', '_');
        this.executeAll(string, objectArray, beforeDynamicHookTypes, beforeDynamicHookMethods, true);
        Object object = this.dynamicOverwritten(string, objectArray, null);
        this.executeAll(string, objectArray, afterDynamicHookTypes, afterDynamicHookMethods, false);
        return object;
    }

    public Object dynamicOverwritten(String string, Object[] objectArray, RenderPlayerBase renderPlayerBase) {
        Map<Class<?>, Map<String, Method>> map;
        List<String> list2 = overrideDynamicHookTypes.get(string);
        String string2 = null;
        if (list2 != null) {
            if (renderPlayerBase != null) {
                string2 = this.baseObjectsToId.get(renderPlayerBase);
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
        return this.execute(this.getRenderPlayerBase(string2), method, objectArray);
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
            RenderPlayerBase renderPlayerBase = this.getRenderPlayerBase(string2);
            Class<?> clazz = renderPlayerBase.getClass();
            Map<String, Method> map3 = map2.get(clazz);
            if (map3 != null && (method = map3.get(string)) != null) {
                this.execute(renderPlayerBase, method, objectArray);
            }
            n += bl ? -1 : 1;
        }
    }

    private Object execute(RenderPlayerBase renderPlayerBase, Method method, Object[] objectArray) {
        try {
            return method.invoke(renderPlayerBase, objectArray);
        }
        catch (Exception exception) {
            throw new RuntimeException("Exception while invoking dynamic method", exception);
        }
    }

    public static boolean doRenderLabel(RenderPlayer renderPlayer, EntityLivingBase entityLivingBase) {
        boolean bl = renderPlayer.renderPlayerAPI != null ? renderPlayer.renderPlayerAPI.doRenderLabel(entityLivingBase) : renderPlayer.localDoRenderLabel(entityLivingBase);
        return bl;
    }

    private boolean doRenderLabel(EntityLivingBase entityLivingBase) {
        int n;
        if (this.beforeDoRenderLabelHooks != null) {
            for (n = this.beforeDoRenderLabelHooks.length - 1; n >= 0; --n) {
                this.beforeDoRenderLabelHooks[n].beforeDoRenderLabel(entityLivingBase);
            }
        }
        n = this.overrideDoRenderLabelHooks != null ? this.overrideDoRenderLabelHooks[this.overrideDoRenderLabelHooks.length - 1].doRenderLabel(entityLivingBase) : (int)(this.renderPlayer.localDoRenderLabel(entityLivingBase) ? 1 : 0);
        if (this.afterDoRenderLabelHooks != null) {
            for (int i = 0; i < this.afterDoRenderLabelHooks.length; ++i) {
                this.afterDoRenderLabelHooks[i].afterDoRenderLabel(entityLivingBase);
            }
        }
        return n != 0;
    }

    protected RenderPlayerBase GetOverwrittenDoRenderLabel(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideDoRenderLabelHooks.length; ++i) {
            if (this.overrideDoRenderLabelHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDoRenderLabelHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void doRenderShadowAndFire(RenderPlayer renderPlayer, Entity entity, double d, double d2, double d3, float f, float f2) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.doRenderShadowAndFire(entity, d, d2, d3, f, f2);
        } else {
            renderPlayer.localDoRenderShadowAndFire(entity, d, d2, d3, f, f2);
        }
    }

    private void doRenderShadowAndFire(Entity entity, double d, double d2, double d3, float f, float f2) {
        int n;
        if (this.beforeDoRenderShadowAndFireHooks != null) {
            for (n = this.beforeDoRenderShadowAndFireHooks.length - 1; n >= 0; --n) {
                this.beforeDoRenderShadowAndFireHooks[n].beforeDoRenderShadowAndFire(entity, d, d2, d3, f, f2);
            }
        }
        if (this.overrideDoRenderShadowAndFireHooks != null) {
            this.overrideDoRenderShadowAndFireHooks[this.overrideDoRenderShadowAndFireHooks.length - 1].doRenderShadowAndFire(entity, d, d2, d3, f, f2);
        } else {
            this.renderPlayer.localDoRenderShadowAndFire(entity, d, d2, d3, f, f2);
        }
        if (this.afterDoRenderShadowAndFireHooks != null) {
            for (n = 0; n < this.afterDoRenderShadowAndFireHooks.length; ++n) {
                this.afterDoRenderShadowAndFireHooks[n].afterDoRenderShadowAndFire(entity, d, d2, d3, f, f2);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenDoRenderShadowAndFire(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideDoRenderShadowAndFireHooks.length; ++i) {
            if (this.overrideDoRenderShadowAndFireHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideDoRenderShadowAndFireHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static int getColorMultiplier(RenderPlayer renderPlayer, EntityLivingBase entityLivingBase, float f, float f2) {
        int n = renderPlayer.renderPlayerAPI != null ? renderPlayer.renderPlayerAPI.getColorMultiplier(entityLivingBase, f, f2) : renderPlayer.localGetColorMultiplier(entityLivingBase, f, f2);
        return n;
    }

    private int getColorMultiplier(EntityLivingBase entityLivingBase, float f, float f2) {
        int n;
        if (this.beforeGetColorMultiplierHooks != null) {
            for (n = this.beforeGetColorMultiplierHooks.length - 1; n >= 0; --n) {
                this.beforeGetColorMultiplierHooks[n].beforeGetColorMultiplier(entityLivingBase, f, f2);
            }
        }
        n = this.overrideGetColorMultiplierHooks != null ? this.overrideGetColorMultiplierHooks[this.overrideGetColorMultiplierHooks.length - 1].getColorMultiplier(entityLivingBase, f, f2) : this.renderPlayer.localGetColorMultiplier(entityLivingBase, f, f2);
        if (this.afterGetColorMultiplierHooks != null) {
            for (int i = 0; i < this.afterGetColorMultiplierHooks.length; ++i) {
                this.afterGetColorMultiplierHooks[i].afterGetColorMultiplier(entityLivingBase, f, f2);
            }
        }
        return n;
    }

    protected RenderPlayerBase GetOverwrittenGetColorMultiplier(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideGetColorMultiplierHooks.length; ++i) {
            if (this.overrideGetColorMultiplierHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetColorMultiplierHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static float getDeathMaxRotation(RenderPlayer renderPlayer, EntityLivingBase entityLivingBase) {
        float f = renderPlayer.renderPlayerAPI != null ? renderPlayer.renderPlayerAPI.getDeathMaxRotation(entityLivingBase) : renderPlayer.localGetDeathMaxRotation(entityLivingBase);
        return f;
    }

    private float getDeathMaxRotation(EntityLivingBase entityLivingBase) {
        if (this.beforeGetDeathMaxRotationHooks != null) {
            for (int i = this.beforeGetDeathMaxRotationHooks.length - 1; i >= 0; --i) {
                this.beforeGetDeathMaxRotationHooks[i].beforeGetDeathMaxRotation(entityLivingBase);
            }
        }
        float f = this.overrideGetDeathMaxRotationHooks != null ? this.overrideGetDeathMaxRotationHooks[this.overrideGetDeathMaxRotationHooks.length - 1].getDeathMaxRotation(entityLivingBase) : this.renderPlayer.localGetDeathMaxRotation(entityLivingBase);
        if (this.afterGetDeathMaxRotationHooks != null) {
            for (int i = 0; i < this.afterGetDeathMaxRotationHooks.length; ++i) {
                this.afterGetDeathMaxRotationHooks[i].afterGetDeathMaxRotation(entityLivingBase);
            }
        }
        return f;
    }

    protected RenderPlayerBase GetOverwrittenGetDeathMaxRotation(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideGetDeathMaxRotationHooks.length; ++i) {
            if (this.overrideGetDeathMaxRotationHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetDeathMaxRotationHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static FontRenderer getFontRendererFromRenderManager(RenderPlayer renderPlayer) {
        FontRenderer fontRenderer = renderPlayer.renderPlayerAPI != null ? renderPlayer.renderPlayerAPI.getFontRendererFromRenderManager() : renderPlayer.localGetFontRendererFromRenderManager();
        return fontRenderer;
    }

    private FontRenderer getFontRendererFromRenderManager() {
        if (this.beforeGetFontRendererFromRenderManagerHooks != null) {
            for (int i = this.beforeGetFontRendererFromRenderManagerHooks.length - 1; i >= 0; --i) {
                this.beforeGetFontRendererFromRenderManagerHooks[i].beforeGetFontRendererFromRenderManager();
            }
        }
        FontRenderer fontRenderer = this.overrideGetFontRendererFromRenderManagerHooks != null ? this.overrideGetFontRendererFromRenderManagerHooks[this.overrideGetFontRendererFromRenderManagerHooks.length - 1].getFontRendererFromRenderManager() : this.renderPlayer.localGetFontRendererFromRenderManager();
        if (this.afterGetFontRendererFromRenderManagerHooks != null) {
            for (int i = 0; i < this.afterGetFontRendererFromRenderManagerHooks.length; ++i) {
                this.afterGetFontRendererFromRenderManagerHooks[i].afterGetFontRendererFromRenderManager();
            }
        }
        return fontRenderer;
    }

    protected RenderPlayerBase GetOverwrittenGetFontRendererFromRenderManager(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideGetFontRendererFromRenderManagerHooks.length; ++i) {
            if (this.overrideGetFontRendererFromRenderManagerHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetFontRendererFromRenderManagerHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static ResourceLocation getResourceLocationFromPlayer(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer) {
        ResourceLocation resourceLocation = renderPlayer.renderPlayerAPI != null ? renderPlayer.renderPlayerAPI.getResourceLocationFromPlayer(abstractClientPlayer) : renderPlayer.localGetResourceLocationFromPlayer(abstractClientPlayer);
        return resourceLocation;
    }

    private ResourceLocation getResourceLocationFromPlayer(AbstractClientPlayer abstractClientPlayer) {
        if (this.beforeGetResourceLocationFromPlayerHooks != null) {
            for (int i = this.beforeGetResourceLocationFromPlayerHooks.length - 1; i >= 0; --i) {
                this.beforeGetResourceLocationFromPlayerHooks[i].beforeGetResourceLocationFromPlayer(abstractClientPlayer);
            }
        }
        ResourceLocation resourceLocation = this.overrideGetResourceLocationFromPlayerHooks != null ? this.overrideGetResourceLocationFromPlayerHooks[this.overrideGetResourceLocationFromPlayerHooks.length - 1].getResourceLocationFromPlayer(abstractClientPlayer) : this.renderPlayer.localGetResourceLocationFromPlayer(abstractClientPlayer);
        if (this.afterGetResourceLocationFromPlayerHooks != null) {
            for (int i = 0; i < this.afterGetResourceLocationFromPlayerHooks.length; ++i) {
                this.afterGetResourceLocationFromPlayerHooks[i].afterGetResourceLocationFromPlayer(abstractClientPlayer);
            }
        }
        return resourceLocation;
    }

    protected RenderPlayerBase GetOverwrittenGetResourceLocationFromPlayer(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideGetResourceLocationFromPlayerHooks.length; ++i) {
            if (this.overrideGetResourceLocationFromPlayerHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetResourceLocationFromPlayerHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static float handleRotationFloat(RenderPlayer renderPlayer, EntityLivingBase entityLivingBase, float f) {
        float f2 = renderPlayer.renderPlayerAPI != null ? renderPlayer.renderPlayerAPI.handleRotationFloat(entityLivingBase, f) : renderPlayer.localHandleRotationFloat(entityLivingBase, f);
        return f2;
    }

    private float handleRotationFloat(EntityLivingBase entityLivingBase, float f) {
        if (this.beforeHandleRotationFloatHooks != null) {
            for (int i = this.beforeHandleRotationFloatHooks.length - 1; i >= 0; --i) {
                this.beforeHandleRotationFloatHooks[i].beforeHandleRotationFloat(entityLivingBase, f);
            }
        }
        float f2 = this.overrideHandleRotationFloatHooks != null ? this.overrideHandleRotationFloatHooks[this.overrideHandleRotationFloatHooks.length - 1].handleRotationFloat(entityLivingBase, f) : this.renderPlayer.localHandleRotationFloat(entityLivingBase, f);
        if (this.afterHandleRotationFloatHooks != null) {
            for (int i = 0; i < this.afterHandleRotationFloatHooks.length; ++i) {
                this.afterHandleRotationFloatHooks[i].afterHandleRotationFloat(entityLivingBase, f);
            }
        }
        return f2;
    }

    protected RenderPlayerBase GetOverwrittenHandleRotationFloat(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideHandleRotationFloatHooks.length; ++i) {
            if (this.overrideHandleRotationFloatHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideHandleRotationFloatHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static int inheritRenderPass(RenderPlayer renderPlayer, EntityLivingBase entityLivingBase, int n, float f) {
        int n2 = renderPlayer.renderPlayerAPI != null ? renderPlayer.renderPlayerAPI.inheritRenderPass(entityLivingBase, n, f) : renderPlayer.localInheritRenderPass(entityLivingBase, n, f);
        return n2;
    }

    private int inheritRenderPass(EntityLivingBase entityLivingBase, int n, float f) {
        int n2;
        if (this.beforeInheritRenderPassHooks != null) {
            for (n2 = this.beforeInheritRenderPassHooks.length - 1; n2 >= 0; --n2) {
                this.beforeInheritRenderPassHooks[n2].beforeInheritRenderPass(entityLivingBase, n, f);
            }
        }
        n2 = this.overrideInheritRenderPassHooks != null ? this.overrideInheritRenderPassHooks[this.overrideInheritRenderPassHooks.length - 1].inheritRenderPass(entityLivingBase, n, f) : this.renderPlayer.localInheritRenderPass(entityLivingBase, n, f);
        if (this.afterInheritRenderPassHooks != null) {
            for (int i = 0; i < this.afterInheritRenderPassHooks.length; ++i) {
                this.afterInheritRenderPassHooks[i].afterInheritRenderPass(entityLivingBase, n, f);
            }
        }
        return n2;
    }

    protected RenderPlayerBase GetOverwrittenInheritRenderPass(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideInheritRenderPassHooks.length; ++i) {
            if (this.overrideInheritRenderPassHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideInheritRenderPassHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void loadTexture(RenderPlayer renderPlayer, ResourceLocation resourceLocation) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.loadTexture(resourceLocation);
        } else {
            renderPlayer.localLoadTexture(resourceLocation);
        }
    }

    private void loadTexture(ResourceLocation resourceLocation) {
        int n;
        if (this.beforeLoadTextureHooks != null) {
            for (n = this.beforeLoadTextureHooks.length - 1; n >= 0; --n) {
                this.beforeLoadTextureHooks[n].beforeLoadTexture(resourceLocation);
            }
        }
        if (this.overrideLoadTextureHooks != null) {
            this.overrideLoadTextureHooks[this.overrideLoadTextureHooks.length - 1].loadTexture(resourceLocation);
        } else {
            this.renderPlayer.localLoadTexture(resourceLocation);
        }
        if (this.afterLoadTextureHooks != null) {
            for (n = 0; n < this.afterLoadTextureHooks.length; ++n) {
                this.afterLoadTextureHooks[n].afterLoadTexture(resourceLocation);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenLoadTexture(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideLoadTextureHooks.length; ++i) {
            if (this.overrideLoadTextureHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideLoadTextureHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void loadTextureOfEntity(RenderPlayer renderPlayer, Entity entity) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.loadTextureOfEntity(entity);
        } else {
            renderPlayer.localLoadTextureOfEntity(entity);
        }
    }

    private void loadTextureOfEntity(Entity entity) {
        int n;
        if (this.beforeLoadTextureOfEntityHooks != null) {
            for (n = this.beforeLoadTextureOfEntityHooks.length - 1; n >= 0; --n) {
                this.beforeLoadTextureOfEntityHooks[n].beforeLoadTextureOfEntity(entity);
            }
        }
        if (this.overrideLoadTextureOfEntityHooks != null) {
            this.overrideLoadTextureOfEntityHooks[this.overrideLoadTextureOfEntityHooks.length - 1].loadTextureOfEntity(entity);
        } else {
            this.renderPlayer.localLoadTextureOfEntity(entity);
        }
        if (this.afterLoadTextureOfEntityHooks != null) {
            for (n = 0; n < this.afterLoadTextureOfEntityHooks.length; ++n) {
                this.afterLoadTextureOfEntityHooks[n].afterLoadTextureOfEntity(entity);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenLoadTextureOfEntity(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideLoadTextureOfEntityHooks.length; ++i) {
            if (this.overrideLoadTextureOfEntityHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideLoadTextureOfEntityHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void passSpecialRender(RenderPlayer renderPlayer, EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.passSpecialRender(entityLivingBase, d, d2, d3);
        } else {
            renderPlayer.localPassSpecialRender(entityLivingBase, d, d2, d3);
        }
    }

    private void passSpecialRender(EntityLivingBase entityLivingBase, double d, double d2, double d3) {
        int n;
        if (this.beforePassSpecialRenderHooks != null) {
            for (n = this.beforePassSpecialRenderHooks.length - 1; n >= 0; --n) {
                this.beforePassSpecialRenderHooks[n].beforePassSpecialRender(entityLivingBase, d, d2, d3);
            }
        }
        if (this.overridePassSpecialRenderHooks != null) {
            this.overridePassSpecialRenderHooks[this.overridePassSpecialRenderHooks.length - 1].passSpecialRender(entityLivingBase, d, d2, d3);
        } else {
            this.renderPlayer.localPassSpecialRender(entityLivingBase, d, d2, d3);
        }
        if (this.afterPassSpecialRenderHooks != null) {
            for (n = 0; n < this.afterPassSpecialRenderHooks.length; ++n) {
                this.afterPassSpecialRenderHooks[n].afterPassSpecialRender(entityLivingBase, d, d2, d3);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenPassSpecialRender(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overridePassSpecialRenderHooks.length; ++i) {
            if (this.overridePassSpecialRenderHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overridePassSpecialRenderHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderArrowsStuckInEntity(RenderPlayer renderPlayer, EntityLivingBase entityLivingBase, float f) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderArrowsStuckInEntity(entityLivingBase, f);
        } else {
            renderPlayer.localRenderArrowsStuckInEntity(entityLivingBase, f);
        }
    }

    private void renderArrowsStuckInEntity(EntityLivingBase entityLivingBase, float f) {
        int n;
        if (this.beforeRenderArrowsStuckInEntityHooks != null) {
            for (n = this.beforeRenderArrowsStuckInEntityHooks.length - 1; n >= 0; --n) {
                this.beforeRenderArrowsStuckInEntityHooks[n].beforeRenderArrowsStuckInEntity(entityLivingBase, f);
            }
        }
        if (this.overrideRenderArrowsStuckInEntityHooks != null) {
            this.overrideRenderArrowsStuckInEntityHooks[this.overrideRenderArrowsStuckInEntityHooks.length - 1].renderArrowsStuckInEntity(entityLivingBase, f);
        } else {
            this.renderPlayer.localRenderArrowsStuckInEntity(entityLivingBase, f);
        }
        if (this.afterRenderArrowsStuckInEntityHooks != null) {
            for (n = 0; n < this.afterRenderArrowsStuckInEntityHooks.length; ++n) {
                this.afterRenderArrowsStuckInEntityHooks[n].afterRenderArrowsStuckInEntity(entityLivingBase, f);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderArrowsStuckInEntity(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderArrowsStuckInEntityHooks.length; ++i) {
            if (this.overrideRenderArrowsStuckInEntityHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderArrowsStuckInEntityHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderFirstPersonArm(RenderPlayer renderPlayer, EntityPlayer entityPlayer) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderFirstPersonArm(entityPlayer);
        } else {
            renderPlayer.localRenderFirstPersonArm(entityPlayer);
        }
    }

    private void renderFirstPersonArm(EntityPlayer entityPlayer) {
        int n;
        if (this.beforeRenderFirstPersonArmHooks != null) {
            for (n = this.beforeRenderFirstPersonArmHooks.length - 1; n >= 0; --n) {
                this.beforeRenderFirstPersonArmHooks[n].beforeRenderFirstPersonArm(entityPlayer);
            }
        }
        if (this.overrideRenderFirstPersonArmHooks != null) {
            this.overrideRenderFirstPersonArmHooks[this.overrideRenderFirstPersonArmHooks.length - 1].renderFirstPersonArm(entityPlayer);
        } else {
            this.renderPlayer.localRenderFirstPersonArm(entityPlayer);
        }
        if (this.afterRenderFirstPersonArmHooks != null) {
            for (n = 0; n < this.afterRenderFirstPersonArmHooks.length; ++n) {
                this.afterRenderFirstPersonArmHooks[n].afterRenderFirstPersonArm(entityPlayer);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderFirstPersonArm(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderFirstPersonArmHooks.length; ++i) {
            if (this.overrideRenderFirstPersonArmHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderFirstPersonArmHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderLivingLabel(RenderPlayer renderPlayer, EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderLivingLabel(entityLivingBase, string, d, d2, d3, n);
        } else {
            renderPlayer.localRenderLivingLabel(entityLivingBase, string, d, d2, d3, n);
        }
    }

    private void renderLivingLabel(EntityLivingBase entityLivingBase, String string, double d, double d2, double d3, int n) {
        int n2;
        if (this.beforeRenderLivingLabelHooks != null) {
            for (n2 = this.beforeRenderLivingLabelHooks.length - 1; n2 >= 0; --n2) {
                this.beforeRenderLivingLabelHooks[n2].beforeRenderLivingLabel(entityLivingBase, string, d, d2, d3, n);
            }
        }
        if (this.overrideRenderLivingLabelHooks != null) {
            this.overrideRenderLivingLabelHooks[this.overrideRenderLivingLabelHooks.length - 1].renderLivingLabel(entityLivingBase, string, d, d2, d3, n);
        } else {
            this.renderPlayer.localRenderLivingLabel(entityLivingBase, string, d, d2, d3, n);
        }
        if (this.afterRenderLivingLabelHooks != null) {
            for (n2 = 0; n2 < this.afterRenderLivingLabelHooks.length; ++n2) {
                this.afterRenderLivingLabelHooks[n2].afterRenderLivingLabel(entityLivingBase, string, d, d2, d3, n);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderLivingLabel(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderLivingLabelHooks.length; ++i) {
            if (this.overrideRenderLivingLabelHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderLivingLabelHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderModel(RenderPlayer renderPlayer, EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
        } else {
            renderPlayer.localRenderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
        }
    }

    private void renderModel(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6) {
        int n;
        if (this.beforeRenderModelHooks != null) {
            for (n = this.beforeRenderModelHooks.length - 1; n >= 0; --n) {
                this.beforeRenderModelHooks[n].beforeRenderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
            }
        }
        if (this.overrideRenderModelHooks != null) {
            this.overrideRenderModelHooks[this.overrideRenderModelHooks.length - 1].renderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
        } else {
            this.renderPlayer.localRenderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
        }
        if (this.afterRenderModelHooks != null) {
            for (n = 0; n < this.afterRenderModelHooks.length; ++n) {
                this.afterRenderModelHooks[n].afterRenderModel(entityLivingBase, f, f2, f3, f4, f5, f6);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderModel(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderModelHooks.length; ++i) {
            if (this.overrideRenderModelHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderModelHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderPlayer(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
        } else {
            renderPlayer.localRenderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
        }
    }

    private void renderPlayer(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, float f, float f2) {
        int n;
        if (this.beforeRenderPlayerHooks != null) {
            for (n = this.beforeRenderPlayerHooks.length - 1; n >= 0; --n) {
                this.beforeRenderPlayerHooks[n].beforeRenderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
            }
        }
        if (this.overrideRenderPlayerHooks != null) {
            this.overrideRenderPlayerHooks[this.overrideRenderPlayerHooks.length - 1].renderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
        } else {
            this.renderPlayer.localRenderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
        }
        if (this.afterRenderPlayerHooks != null) {
            for (n = 0; n < this.afterRenderPlayerHooks.length; ++n) {
                this.afterRenderPlayerHooks[n].afterRenderPlayer(abstractClientPlayer, d, d2, d3, f, f2);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderPlayer(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderPlayerHooks.length; ++i) {
            if (this.overrideRenderPlayerHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderPlayerHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderPlayerNameAndScoreLabel(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, String string, float f, double d4) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderPlayerNameAndScoreLabel(abstractClientPlayer, d, d2, d3, string, f, d4);
        } else {
            renderPlayer.localRenderPlayerNameAndScoreLabel(abstractClientPlayer, d, d2, d3, string, f, d4);
        }
    }

    private void renderPlayerNameAndScoreLabel(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3, String string, float f, double d4) {
        int n;
        if (this.beforeRenderPlayerNameAndScoreLabelHooks != null) {
            for (n = this.beforeRenderPlayerNameAndScoreLabelHooks.length - 1; n >= 0; --n) {
                this.beforeRenderPlayerNameAndScoreLabelHooks[n].beforeRenderPlayerNameAndScoreLabel(abstractClientPlayer, d, d2, d3, string, f, d4);
            }
        }
        if (this.overrideRenderPlayerNameAndScoreLabelHooks != null) {
            this.overrideRenderPlayerNameAndScoreLabelHooks[this.overrideRenderPlayerNameAndScoreLabelHooks.length - 1].renderPlayerNameAndScoreLabel(abstractClientPlayer, d, d2, d3, string, f, d4);
        } else {
            this.renderPlayer.localRenderPlayerNameAndScoreLabel(abstractClientPlayer, d, d2, d3, string, f, d4);
        }
        if (this.afterRenderPlayerNameAndScoreLabelHooks != null) {
            for (n = 0; n < this.afterRenderPlayerNameAndScoreLabelHooks.length; ++n) {
                this.afterRenderPlayerNameAndScoreLabelHooks[n].afterRenderPlayerNameAndScoreLabel(abstractClientPlayer, d, d2, d3, string, f, d4);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderPlayerNameAndScoreLabel(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderPlayerNameAndScoreLabelHooks.length; ++i) {
            if (this.overrideRenderPlayerNameAndScoreLabelHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderPlayerNameAndScoreLabelHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderPlayerScale(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, float f) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderPlayerScale(abstractClientPlayer, f);
        } else {
            renderPlayer.localRenderPlayerScale(abstractClientPlayer, f);
        }
    }

    private void renderPlayerScale(AbstractClientPlayer abstractClientPlayer, float f) {
        int n;
        if (this.beforeRenderPlayerScaleHooks != null) {
            for (n = this.beforeRenderPlayerScaleHooks.length - 1; n >= 0; --n) {
                this.beforeRenderPlayerScaleHooks[n].beforeRenderPlayerScale(abstractClientPlayer, f);
            }
        }
        if (this.overrideRenderPlayerScaleHooks != null) {
            this.overrideRenderPlayerScaleHooks[this.overrideRenderPlayerScaleHooks.length - 1].renderPlayerScale(abstractClientPlayer, f);
        } else {
            this.renderPlayer.localRenderPlayerScale(abstractClientPlayer, f);
        }
        if (this.afterRenderPlayerScaleHooks != null) {
            for (n = 0; n < this.afterRenderPlayerScaleHooks.length; ++n) {
                this.afterRenderPlayerScaleHooks[n].afterRenderPlayerScale(abstractClientPlayer, f);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderPlayerScale(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderPlayerScaleHooks.length; ++i) {
            if (this.overrideRenderPlayerScaleHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderPlayerScaleHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderPlayerSleep(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderPlayerSleep(abstractClientPlayer, d, d2, d3);
        } else {
            renderPlayer.localRenderPlayerSleep(abstractClientPlayer, d, d2, d3);
        }
    }

    private void renderPlayerSleep(AbstractClientPlayer abstractClientPlayer, double d, double d2, double d3) {
        int n;
        if (this.beforeRenderPlayerSleepHooks != null) {
            for (n = this.beforeRenderPlayerSleepHooks.length - 1; n >= 0; --n) {
                this.beforeRenderPlayerSleepHooks[n].beforeRenderPlayerSleep(abstractClientPlayer, d, d2, d3);
            }
        }
        if (this.overrideRenderPlayerSleepHooks != null) {
            this.overrideRenderPlayerSleepHooks[this.overrideRenderPlayerSleepHooks.length - 1].renderPlayerSleep(abstractClientPlayer, d, d2, d3);
        } else {
            this.renderPlayer.localRenderPlayerSleep(abstractClientPlayer, d, d2, d3);
        }
        if (this.afterRenderPlayerSleepHooks != null) {
            for (n = 0; n < this.afterRenderPlayerSleepHooks.length; ++n) {
                this.afterRenderPlayerSleepHooks[n].afterRenderPlayerSleep(abstractClientPlayer, d, d2, d3);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderPlayerSleep(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderPlayerSleepHooks.length; ++i) {
            if (this.overrideRenderPlayerSleepHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderPlayerSleepHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderSpecials(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, float f) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderSpecials(abstractClientPlayer, f);
        } else {
            renderPlayer.localRenderSpecials(abstractClientPlayer, f);
        }
    }

    private void renderSpecials(AbstractClientPlayer abstractClientPlayer, float f) {
        int n;
        if (this.beforeRenderSpecialsHooks != null) {
            for (n = this.beforeRenderSpecialsHooks.length - 1; n >= 0; --n) {
                this.beforeRenderSpecialsHooks[n].beforeRenderSpecials(abstractClientPlayer, f);
            }
        }
        if (this.overrideRenderSpecialsHooks != null) {
            this.overrideRenderSpecialsHooks[this.overrideRenderSpecialsHooks.length - 1].renderSpecials(abstractClientPlayer, f);
        } else {
            this.renderPlayer.localRenderSpecials(abstractClientPlayer, f);
        }
        if (this.afterRenderSpecialsHooks != null) {
            for (n = 0; n < this.afterRenderSpecialsHooks.length; ++n) {
                this.afterRenderSpecialsHooks[n].afterRenderSpecials(abstractClientPlayer, f);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderSpecials(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderSpecialsHooks.length; ++i) {
            if (this.overrideRenderSpecialsHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderSpecialsHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static float renderSwingProgress(RenderPlayer renderPlayer, EntityLivingBase entityLivingBase, float f) {
        float f2 = renderPlayer.renderPlayerAPI != null ? renderPlayer.renderPlayerAPI.renderSwingProgress(entityLivingBase, f) : renderPlayer.localRenderSwingProgress(entityLivingBase, f);
        return f2;
    }

    private float renderSwingProgress(EntityLivingBase entityLivingBase, float f) {
        if (this.beforeRenderSwingProgressHooks != null) {
            for (int i = this.beforeRenderSwingProgressHooks.length - 1; i >= 0; --i) {
                this.beforeRenderSwingProgressHooks[i].beforeRenderSwingProgress(entityLivingBase, f);
            }
        }
        float f2 = this.overrideRenderSwingProgressHooks != null ? this.overrideRenderSwingProgressHooks[this.overrideRenderSwingProgressHooks.length - 1].renderSwingProgress(entityLivingBase, f) : this.renderPlayer.localRenderSwingProgress(entityLivingBase, f);
        if (this.afterRenderSwingProgressHooks != null) {
            for (int i = 0; i < this.afterRenderSwingProgressHooks.length; ++i) {
                this.afterRenderSwingProgressHooks[i].afterRenderSwingProgress(entityLivingBase, f);
            }
        }
        return f2;
    }

    protected RenderPlayerBase GetOverwrittenRenderSwingProgress(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderSwingProgressHooks.length; ++i) {
            if (this.overrideRenderSwingProgressHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderSwingProgressHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void rotatePlayer(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.rotatePlayer(abstractClientPlayer, f, f2, f3);
        } else {
            renderPlayer.localRotatePlayer(abstractClientPlayer, f, f2, f3);
        }
    }

    private void rotatePlayer(AbstractClientPlayer abstractClientPlayer, float f, float f2, float f3) {
        int n;
        if (this.beforeRotatePlayerHooks != null) {
            for (n = this.beforeRotatePlayerHooks.length - 1; n >= 0; --n) {
                this.beforeRotatePlayerHooks[n].beforeRotatePlayer(abstractClientPlayer, f, f2, f3);
            }
        }
        if (this.overrideRotatePlayerHooks != null) {
            this.overrideRotatePlayerHooks[this.overrideRotatePlayerHooks.length - 1].rotatePlayer(abstractClientPlayer, f, f2, f3);
        } else {
            this.renderPlayer.localRotatePlayer(abstractClientPlayer, f, f2, f3);
        }
        if (this.afterRotatePlayerHooks != null) {
            for (n = 0; n < this.afterRotatePlayerHooks.length; ++n) {
                this.afterRotatePlayerHooks[n].afterRotatePlayer(abstractClientPlayer, f, f2, f3);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRotatePlayer(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRotatePlayerHooks.length; ++i) {
            if (this.overrideRotatePlayerHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRotatePlayerHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static int setArmorModel(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, int n, float f) {
        int n2 = renderPlayer.renderPlayerAPI != null ? renderPlayer.renderPlayerAPI.setArmorModel(abstractClientPlayer, n, f) : renderPlayer.localSetArmorModel(abstractClientPlayer, n, f);
        return n2;
    }

    private int setArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        int n2;
        if (this.beforeSetArmorModelHooks != null) {
            for (n2 = this.beforeSetArmorModelHooks.length - 1; n2 >= 0; --n2) {
                this.beforeSetArmorModelHooks[n2].beforeSetArmorModel(abstractClientPlayer, n, f);
            }
        }
        n2 = this.overrideSetArmorModelHooks != null ? this.overrideSetArmorModelHooks[this.overrideSetArmorModelHooks.length - 1].setArmorModel(abstractClientPlayer, n, f) : this.renderPlayer.localSetArmorModel(abstractClientPlayer, n, f);
        if (this.afterSetArmorModelHooks != null) {
            for (int i = 0; i < this.afterSetArmorModelHooks.length; ++i) {
                this.afterSetArmorModelHooks[i].afterSetArmorModel(abstractClientPlayer, n, f);
            }
        }
        return n2;
    }

    protected RenderPlayerBase GetOverwrittenSetArmorModel(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideSetArmorModelHooks.length; ++i) {
            if (this.overrideSetArmorModelHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetArmorModelHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void setPassArmorModel(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, int n, float f) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.setPassArmorModel(abstractClientPlayer, n, f);
        } else {
            renderPlayer.localSetPassArmorModel(abstractClientPlayer, n, f);
        }
    }

    private void setPassArmorModel(AbstractClientPlayer abstractClientPlayer, int n, float f) {
        int n2;
        if (this.beforeSetPassArmorModelHooks != null) {
            for (n2 = this.beforeSetPassArmorModelHooks.length - 1; n2 >= 0; --n2) {
                this.beforeSetPassArmorModelHooks[n2].beforeSetPassArmorModel(abstractClientPlayer, n, f);
            }
        }
        if (this.overrideSetPassArmorModelHooks != null) {
            this.overrideSetPassArmorModelHooks[this.overrideSetPassArmorModelHooks.length - 1].setPassArmorModel(abstractClientPlayer, n, f);
        } else {
            this.renderPlayer.localSetPassArmorModel(abstractClientPlayer, n, f);
        }
        if (this.afterSetPassArmorModelHooks != null) {
            for (n2 = 0; n2 < this.afterSetPassArmorModelHooks.length; ++n2) {
                this.afterSetPassArmorModelHooks[n2].afterSetPassArmorModel(abstractClientPlayer, n, f);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenSetPassArmorModel(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideSetPassArmorModelHooks.length; ++i) {
            if (this.overrideSetPassArmorModelHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetPassArmorModelHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void setRenderManager(RenderPlayer renderPlayer, RenderManager renderManager) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.setRenderManager(renderManager);
        } else {
            renderPlayer.localSetRenderManager(renderManager);
        }
    }

    private void setRenderManager(RenderManager renderManager) {
        int n;
        if (this.beforeSetRenderManagerHooks != null) {
            for (n = this.beforeSetRenderManagerHooks.length - 1; n >= 0; --n) {
                this.beforeSetRenderManagerHooks[n].beforeSetRenderManager(renderManager);
            }
        }
        if (this.overrideSetRenderManagerHooks != null) {
            this.overrideSetRenderManagerHooks[this.overrideSetRenderManagerHooks.length - 1].setRenderManager(renderManager);
        } else {
            this.renderPlayer.localSetRenderManager(renderManager);
        }
        if (this.afterSetRenderManagerHooks != null) {
            for (n = 0; n < this.afterSetRenderManagerHooks.length; ++n) {
                this.afterSetRenderManagerHooks[n].afterSetRenderManager(renderManager);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenSetRenderManager(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideSetRenderManagerHooks.length; ++i) {
            if (this.overrideSetRenderManagerHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetRenderManagerHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void setRenderPassModel(RenderPlayer renderPlayer, ModelBase modelBase) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.setRenderPassModel(modelBase);
        } else {
            renderPlayer.localSetRenderPassModel(modelBase);
        }
    }

    private void setRenderPassModel(ModelBase modelBase) {
        int n;
        if (this.beforeSetRenderPassModelHooks != null) {
            for (n = this.beforeSetRenderPassModelHooks.length - 1; n >= 0; --n) {
                this.beforeSetRenderPassModelHooks[n].beforeSetRenderPassModel(modelBase);
            }
        }
        if (this.overrideSetRenderPassModelHooks != null) {
            this.overrideSetRenderPassModelHooks[this.overrideSetRenderPassModelHooks.length - 1].setRenderPassModel(modelBase);
        } else {
            this.renderPlayer.localSetRenderPassModel(modelBase);
        }
        if (this.afterSetRenderPassModelHooks != null) {
            for (n = 0; n < this.afterSetRenderPassModelHooks.length; ++n) {
                this.afterSetRenderPassModelHooks[n].afterSetRenderPassModel(modelBase);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenSetRenderPassModel(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideSetRenderPassModelHooks.length; ++i) {
            if (this.overrideSetRenderPassModelHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetRenderPassModelHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void updateIcons(RenderPlayer renderPlayer, IconRegister iconRegister) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.updateIcons(iconRegister);
        } else {
            renderPlayer.localUpdateIcons(iconRegister);
        }
    }

    private void updateIcons(IconRegister iconRegister) {
        int n;
        if (this.beforeUpdateIconsHooks != null) {
            for (n = this.beforeUpdateIconsHooks.length - 1; n >= 0; --n) {
                this.beforeUpdateIconsHooks[n].beforeUpdateIcons(iconRegister);
            }
        }
        if (this.overrideUpdateIconsHooks != null) {
            this.overrideUpdateIconsHooks[this.overrideUpdateIconsHooks.length - 1].updateIcons(iconRegister);
        } else {
            this.renderPlayer.localUpdateIcons(iconRegister);
        }
        if (this.afterUpdateIconsHooks != null) {
            for (n = 0; n < this.afterUpdateIconsHooks.length; ++n) {
                this.afterUpdateIconsHooks[n].afterUpdateIcons(iconRegister);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenUpdateIcons(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideUpdateIconsHooks.length; ++i) {
            if (this.overrideUpdateIconsHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideUpdateIconsHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderSpecialHeadArmor(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, float f) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderSpecialHeadArmor(abstractClientPlayer, f);
        } else {
            renderPlayer.localRenderSpecialHeadArmor(abstractClientPlayer, f);
        }
    }

    private void renderSpecialHeadArmor(AbstractClientPlayer abstractClientPlayer, float f) {
        int n;
        if (this.beforeRenderSpecialHeadArmorHooks != null) {
            for (n = this.beforeRenderSpecialHeadArmorHooks.length - 1; n >= 0; --n) {
                this.beforeRenderSpecialHeadArmorHooks[n].beforeRenderSpecialHeadArmor(abstractClientPlayer, f);
            }
        }
        if (this.overrideRenderSpecialHeadArmorHooks != null) {
            this.overrideRenderSpecialHeadArmorHooks[this.overrideRenderSpecialHeadArmorHooks.length - 1].renderSpecialHeadArmor(abstractClientPlayer, f);
        } else {
            this.renderPlayer.localRenderSpecialHeadArmor(abstractClientPlayer, f);
        }
        if (this.afterRenderSpecialHeadArmorHooks != null) {
            for (n = 0; n < this.afterRenderSpecialHeadArmorHooks.length; ++n) {
                this.afterRenderSpecialHeadArmorHooks[n].afterRenderSpecialHeadArmor(abstractClientPlayer, f);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderSpecialHeadArmor(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderSpecialHeadArmorHooks.length; ++i) {
            if (this.overrideRenderSpecialHeadArmorHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderSpecialHeadArmorHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderSpecialHeadEars(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, float f) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderSpecialHeadEars(abstractClientPlayer, f);
        } else {
            renderPlayer.localRenderSpecialHeadEars(abstractClientPlayer, f);
        }
    }

    private void renderSpecialHeadEars(AbstractClientPlayer abstractClientPlayer, float f) {
        int n;
        if (this.beforeRenderSpecialHeadEarsHooks != null) {
            for (n = this.beforeRenderSpecialHeadEarsHooks.length - 1; n >= 0; --n) {
                this.beforeRenderSpecialHeadEarsHooks[n].beforeRenderSpecialHeadEars(abstractClientPlayer, f);
            }
        }
        if (this.overrideRenderSpecialHeadEarsHooks != null) {
            this.overrideRenderSpecialHeadEarsHooks[this.overrideRenderSpecialHeadEarsHooks.length - 1].renderSpecialHeadEars(abstractClientPlayer, f);
        } else {
            this.renderPlayer.localRenderSpecialHeadEars(abstractClientPlayer, f);
        }
        if (this.afterRenderSpecialHeadEarsHooks != null) {
            for (n = 0; n < this.afterRenderSpecialHeadEarsHooks.length; ++n) {
                this.afterRenderSpecialHeadEarsHooks[n].afterRenderSpecialHeadEars(abstractClientPlayer, f);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderSpecialHeadEars(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderSpecialHeadEarsHooks.length; ++i) {
            if (this.overrideRenderSpecialHeadEarsHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderSpecialHeadEarsHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderSpecialCloak(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, float f) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderSpecialCloak(abstractClientPlayer, f);
        } else {
            renderPlayer.localRenderSpecialCloak(abstractClientPlayer, f);
        }
    }

    private void renderSpecialCloak(AbstractClientPlayer abstractClientPlayer, float f) {
        int n;
        if (this.beforeRenderSpecialCloakHooks != null) {
            for (n = this.beforeRenderSpecialCloakHooks.length - 1; n >= 0; --n) {
                this.beforeRenderSpecialCloakHooks[n].beforeRenderSpecialCloak(abstractClientPlayer, f);
            }
        }
        if (this.overrideRenderSpecialCloakHooks != null) {
            this.overrideRenderSpecialCloakHooks[this.overrideRenderSpecialCloakHooks.length - 1].renderSpecialCloak(abstractClientPlayer, f);
        } else {
            this.renderPlayer.localRenderSpecialCloak(abstractClientPlayer, f);
        }
        if (this.afterRenderSpecialCloakHooks != null) {
            for (n = 0; n < this.afterRenderSpecialCloakHooks.length; ++n) {
                this.afterRenderSpecialCloakHooks[n].afterRenderSpecialCloak(abstractClientPlayer, f);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderSpecialCloak(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderSpecialCloakHooks.length; ++i) {
            if (this.overrideRenderSpecialCloakHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderSpecialCloakHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void renderSpecialItemInHand(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, float f) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.renderSpecialItemInHand(abstractClientPlayer, f);
        } else {
            renderPlayer.localRenderSpecialItemInHand(abstractClientPlayer, f);
        }
    }

    private void renderSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f) {
        int n;
        if (this.beforeRenderSpecialItemInHandHooks != null) {
            for (n = this.beforeRenderSpecialItemInHandHooks.length - 1; n >= 0; --n) {
                this.beforeRenderSpecialItemInHandHooks[n].beforeRenderSpecialItemInHand(abstractClientPlayer, f);
            }
        }
        if (this.overrideRenderSpecialItemInHandHooks != null) {
            this.overrideRenderSpecialItemInHandHooks[this.overrideRenderSpecialItemInHandHooks.length - 1].renderSpecialItemInHand(abstractClientPlayer, f);
        } else {
            this.renderPlayer.localRenderSpecialItemInHand(abstractClientPlayer, f);
        }
        if (this.afterRenderSpecialItemInHandHooks != null) {
            for (n = 0; n < this.afterRenderSpecialItemInHandHooks.length; ++n) {
                this.afterRenderSpecialItemInHandHooks[n].afterRenderSpecialItemInHand(abstractClientPlayer, f);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderSpecialItemInHand(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overrideRenderSpecialItemInHandHooks.length; ++i) {
            if (this.overrideRenderSpecialItemInHandHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderSpecialItemInHandHooks[i - 1];
        }
        return renderPlayerBase;
    }

    public static void positionSpecialItemInHand(RenderPlayer renderPlayer, AbstractClientPlayer abstractClientPlayer, float f, EnumAction enumAction, ItemStack itemStack) {
        if (renderPlayer.renderPlayerAPI != null) {
            renderPlayer.renderPlayerAPI.positionSpecialItemInHand(abstractClientPlayer, f, enumAction, itemStack);
        } else {
            renderPlayer.localPositionSpecialItemInHand(abstractClientPlayer, f, enumAction, itemStack);
        }
    }

    private void positionSpecialItemInHand(AbstractClientPlayer abstractClientPlayer, float f, EnumAction enumAction, ItemStack itemStack) {
        int n;
        if (this.beforePositionSpecialItemInHandHooks != null) {
            for (n = this.beforePositionSpecialItemInHandHooks.length - 1; n >= 0; --n) {
                this.beforePositionSpecialItemInHandHooks[n].beforePositionSpecialItemInHand(abstractClientPlayer, f, enumAction, itemStack);
            }
        }
        if (this.overridePositionSpecialItemInHandHooks != null) {
            this.overridePositionSpecialItemInHandHooks[this.overridePositionSpecialItemInHandHooks.length - 1].positionSpecialItemInHand(abstractClientPlayer, f, enumAction, itemStack);
        } else {
            this.renderPlayer.localPositionSpecialItemInHand(abstractClientPlayer, f, enumAction, itemStack);
        }
        if (this.afterPositionSpecialItemInHandHooks != null) {
            for (n = 0; n < this.afterPositionSpecialItemInHandHooks.length; ++n) {
                this.afterPositionSpecialItemInHandHooks[n].afterPositionSpecialItemInHand(abstractClientPlayer, f, enumAction, itemStack);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenPositionSpecialItemInHand(RenderPlayerBase renderPlayerBase) {
        for (int i = 0; i < this.overridePositionSpecialItemInHandHooks.length; ++i) {
            if (this.overridePositionSpecialItemInHandHooks[i] != renderPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overridePositionSpecialItemInHandHooks[i - 1];
        }
        return renderPlayerBase;
    }

    static {
        logger = Logger.getLogger("RenderPlayerAPI");
        EmptySortMap = Collections.unmodifiableMap(new HashMap());
        initializer = new Object[]{null};
        initializers = new Object[]{null, null};
        beforeDoRenderLabelHookTypes = new LinkedList<String>();
        overrideDoRenderLabelHookTypes = new LinkedList<String>();
        afterDoRenderLabelHookTypes = new LinkedList<String>();
        allBaseBeforeDoRenderLabelSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDoRenderLabelInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDoRenderLabelSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDoRenderLabelInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDoRenderLabelSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDoRenderLabelInferiors = new Hashtable<String, String[]>(0);
        beforeDoRenderShadowAndFireHookTypes = new LinkedList<String>();
        overrideDoRenderShadowAndFireHookTypes = new LinkedList<String>();
        afterDoRenderShadowAndFireHookTypes = new LinkedList<String>();
        allBaseBeforeDoRenderShadowAndFireSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeDoRenderShadowAndFireInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDoRenderShadowAndFireSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideDoRenderShadowAndFireInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterDoRenderShadowAndFireSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterDoRenderShadowAndFireInferiors = new Hashtable<String, String[]>(0);
        beforeGetColorMultiplierHookTypes = new LinkedList<String>();
        overrideGetColorMultiplierHookTypes = new LinkedList<String>();
        afterGetColorMultiplierHookTypes = new LinkedList<String>();
        allBaseBeforeGetColorMultiplierSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetColorMultiplierInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetColorMultiplierSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetColorMultiplierInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetColorMultiplierSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetColorMultiplierInferiors = new Hashtable<String, String[]>(0);
        beforeGetDeathMaxRotationHookTypes = new LinkedList<String>();
        overrideGetDeathMaxRotationHookTypes = new LinkedList<String>();
        afterGetDeathMaxRotationHookTypes = new LinkedList<String>();
        allBaseBeforeGetDeathMaxRotationSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetDeathMaxRotationInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetDeathMaxRotationSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetDeathMaxRotationInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetDeathMaxRotationSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetDeathMaxRotationInferiors = new Hashtable<String, String[]>(0);
        beforeGetFontRendererFromRenderManagerHookTypes = new LinkedList<String>();
        overrideGetFontRendererFromRenderManagerHookTypes = new LinkedList<String>();
        afterGetFontRendererFromRenderManagerHookTypes = new LinkedList<String>();
        allBaseBeforeGetFontRendererFromRenderManagerSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetFontRendererFromRenderManagerInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetFontRendererFromRenderManagerSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetFontRendererFromRenderManagerInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetFontRendererFromRenderManagerSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetFontRendererFromRenderManagerInferiors = new Hashtable<String, String[]>(0);
        beforeGetResourceLocationFromPlayerHookTypes = new LinkedList<String>();
        overrideGetResourceLocationFromPlayerHookTypes = new LinkedList<String>();
        afterGetResourceLocationFromPlayerHookTypes = new LinkedList<String>();
        allBaseBeforeGetResourceLocationFromPlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetResourceLocationFromPlayerInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetResourceLocationFromPlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetResourceLocationFromPlayerInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetResourceLocationFromPlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetResourceLocationFromPlayerInferiors = new Hashtable<String, String[]>(0);
        beforeHandleRotationFloatHookTypes = new LinkedList<String>();
        overrideHandleRotationFloatHookTypes = new LinkedList<String>();
        afterHandleRotationFloatHookTypes = new LinkedList<String>();
        allBaseBeforeHandleRotationFloatSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeHandleRotationFloatInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideHandleRotationFloatSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideHandleRotationFloatInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterHandleRotationFloatSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterHandleRotationFloatInferiors = new Hashtable<String, String[]>(0);
        beforeInheritRenderPassHookTypes = new LinkedList<String>();
        overrideInheritRenderPassHookTypes = new LinkedList<String>();
        afterInheritRenderPassHookTypes = new LinkedList<String>();
        allBaseBeforeInheritRenderPassSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeInheritRenderPassInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideInheritRenderPassSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideInheritRenderPassInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterInheritRenderPassSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterInheritRenderPassInferiors = new Hashtable<String, String[]>(0);
        beforeLoadTextureHookTypes = new LinkedList<String>();
        overrideLoadTextureHookTypes = new LinkedList<String>();
        afterLoadTextureHookTypes = new LinkedList<String>();
        allBaseBeforeLoadTextureSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeLoadTextureInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideLoadTextureSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideLoadTextureInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterLoadTextureSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterLoadTextureInferiors = new Hashtable<String, String[]>(0);
        beforeLoadTextureOfEntityHookTypes = new LinkedList<String>();
        overrideLoadTextureOfEntityHookTypes = new LinkedList<String>();
        afterLoadTextureOfEntityHookTypes = new LinkedList<String>();
        allBaseBeforeLoadTextureOfEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeLoadTextureOfEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideLoadTextureOfEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideLoadTextureOfEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterLoadTextureOfEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterLoadTextureOfEntityInferiors = new Hashtable<String, String[]>(0);
        beforePassSpecialRenderHookTypes = new LinkedList<String>();
        overridePassSpecialRenderHookTypes = new LinkedList<String>();
        afterPassSpecialRenderHookTypes = new LinkedList<String>();
        allBaseBeforePassSpecialRenderSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforePassSpecialRenderInferiors = new Hashtable<String, String[]>(0);
        allBaseOverridePassSpecialRenderSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverridePassSpecialRenderInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterPassSpecialRenderSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterPassSpecialRenderInferiors = new Hashtable<String, String[]>(0);
        beforeRenderArrowsStuckInEntityHookTypes = new LinkedList<String>();
        overrideRenderArrowsStuckInEntityHookTypes = new LinkedList<String>();
        afterRenderArrowsStuckInEntityHookTypes = new LinkedList<String>();
        allBaseBeforeRenderArrowsStuckInEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderArrowsStuckInEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderArrowsStuckInEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderArrowsStuckInEntityInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderArrowsStuckInEntitySuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderArrowsStuckInEntityInferiors = new Hashtable<String, String[]>(0);
        beforeRenderFirstPersonArmHookTypes = new LinkedList<String>();
        overrideRenderFirstPersonArmHookTypes = new LinkedList<String>();
        afterRenderFirstPersonArmHookTypes = new LinkedList<String>();
        allBaseBeforeRenderFirstPersonArmSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderFirstPersonArmInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderFirstPersonArmSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderFirstPersonArmInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderFirstPersonArmSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderFirstPersonArmInferiors = new Hashtable<String, String[]>(0);
        beforeRenderLivingLabelHookTypes = new LinkedList<String>();
        overrideRenderLivingLabelHookTypes = new LinkedList<String>();
        afterRenderLivingLabelHookTypes = new LinkedList<String>();
        allBaseBeforeRenderLivingLabelSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderLivingLabelInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderLivingLabelSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderLivingLabelInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderLivingLabelSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderLivingLabelInferiors = new Hashtable<String, String[]>(0);
        beforeRenderModelHookTypes = new LinkedList<String>();
        overrideRenderModelHookTypes = new LinkedList<String>();
        afterRenderModelHookTypes = new LinkedList<String>();
        allBaseBeforeRenderModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderModelInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderModelInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderModelInferiors = new Hashtable<String, String[]>(0);
        beforeRenderPlayerHookTypes = new LinkedList<String>();
        overrideRenderPlayerHookTypes = new LinkedList<String>();
        afterRenderPlayerHookTypes = new LinkedList<String>();
        allBaseBeforeRenderPlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderPlayerInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderPlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderPlayerInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderPlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderPlayerInferiors = new Hashtable<String, String[]>(0);
        beforeRenderPlayerNameAndScoreLabelHookTypes = new LinkedList<String>();
        overrideRenderPlayerNameAndScoreLabelHookTypes = new LinkedList<String>();
        afterRenderPlayerNameAndScoreLabelHookTypes = new LinkedList<String>();
        allBaseBeforeRenderPlayerNameAndScoreLabelSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderPlayerNameAndScoreLabelInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderPlayerNameAndScoreLabelSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderPlayerNameAndScoreLabelInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderPlayerNameAndScoreLabelSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderPlayerNameAndScoreLabelInferiors = new Hashtable<String, String[]>(0);
        beforeRenderPlayerScaleHookTypes = new LinkedList<String>();
        overrideRenderPlayerScaleHookTypes = new LinkedList<String>();
        afterRenderPlayerScaleHookTypes = new LinkedList<String>();
        allBaseBeforeRenderPlayerScaleSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderPlayerScaleInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderPlayerScaleSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderPlayerScaleInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderPlayerScaleSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderPlayerScaleInferiors = new Hashtable<String, String[]>(0);
        beforeRenderPlayerSleepHookTypes = new LinkedList<String>();
        overrideRenderPlayerSleepHookTypes = new LinkedList<String>();
        afterRenderPlayerSleepHookTypes = new LinkedList<String>();
        allBaseBeforeRenderPlayerSleepSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderPlayerSleepInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderPlayerSleepSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderPlayerSleepInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderPlayerSleepSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderPlayerSleepInferiors = new Hashtable<String, String[]>(0);
        beforeRenderSpecialsHookTypes = new LinkedList<String>();
        overrideRenderSpecialsHookTypes = new LinkedList<String>();
        afterRenderSpecialsHookTypes = new LinkedList<String>();
        allBaseBeforeRenderSpecialsSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderSpecialsInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSpecialsSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSpecialsInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSpecialsSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSpecialsInferiors = new Hashtable<String, String[]>(0);
        beforeRenderSwingProgressHookTypes = new LinkedList<String>();
        overrideRenderSwingProgressHookTypes = new LinkedList<String>();
        afterRenderSwingProgressHookTypes = new LinkedList<String>();
        allBaseBeforeRenderSwingProgressSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderSwingProgressInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSwingProgressSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSwingProgressInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSwingProgressSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSwingProgressInferiors = new Hashtable<String, String[]>(0);
        beforeRotatePlayerHookTypes = new LinkedList<String>();
        overrideRotatePlayerHookTypes = new LinkedList<String>();
        afterRotatePlayerHookTypes = new LinkedList<String>();
        allBaseBeforeRotatePlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRotatePlayerInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRotatePlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRotatePlayerInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRotatePlayerSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRotatePlayerInferiors = new Hashtable<String, String[]>(0);
        beforeSetArmorModelHookTypes = new LinkedList<String>();
        overrideSetArmorModelHookTypes = new LinkedList<String>();
        afterSetArmorModelHookTypes = new LinkedList<String>();
        allBaseBeforeSetArmorModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetArmorModelInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetArmorModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetArmorModelInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetArmorModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetArmorModelInferiors = new Hashtable<String, String[]>(0);
        beforeSetPassArmorModelHookTypes = new LinkedList<String>();
        overrideSetPassArmorModelHookTypes = new LinkedList<String>();
        afterSetPassArmorModelHookTypes = new LinkedList<String>();
        allBaseBeforeSetPassArmorModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetPassArmorModelInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetPassArmorModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetPassArmorModelInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetPassArmorModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetPassArmorModelInferiors = new Hashtable<String, String[]>(0);
        beforeSetRenderManagerHookTypes = new LinkedList<String>();
        overrideSetRenderManagerHookTypes = new LinkedList<String>();
        afterSetRenderManagerHookTypes = new LinkedList<String>();
        allBaseBeforeSetRenderManagerSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetRenderManagerInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetRenderManagerSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetRenderManagerInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetRenderManagerSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetRenderManagerInferiors = new Hashtable<String, String[]>(0);
        beforeSetRenderPassModelHookTypes = new LinkedList<String>();
        overrideSetRenderPassModelHookTypes = new LinkedList<String>();
        afterSetRenderPassModelHookTypes = new LinkedList<String>();
        allBaseBeforeSetRenderPassModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetRenderPassModelInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetRenderPassModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetRenderPassModelInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetRenderPassModelSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetRenderPassModelInferiors = new Hashtable<String, String[]>(0);
        beforeUpdateIconsHookTypes = new LinkedList<String>();
        overrideUpdateIconsHookTypes = new LinkedList<String>();
        afterUpdateIconsHookTypes = new LinkedList<String>();
        allBaseBeforeUpdateIconsSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeUpdateIconsInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideUpdateIconsSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideUpdateIconsInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterUpdateIconsSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterUpdateIconsInferiors = new Hashtable<String, String[]>(0);
        beforeRenderSpecialHeadArmorHookTypes = new LinkedList<String>();
        overrideRenderSpecialHeadArmorHookTypes = new LinkedList<String>();
        afterRenderSpecialHeadArmorHookTypes = new LinkedList<String>();
        allBaseBeforeRenderSpecialHeadArmorSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderSpecialHeadArmorInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSpecialHeadArmorSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSpecialHeadArmorInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSpecialHeadArmorSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSpecialHeadArmorInferiors = new Hashtable<String, String[]>(0);
        beforeRenderSpecialHeadEarsHookTypes = new LinkedList<String>();
        overrideRenderSpecialHeadEarsHookTypes = new LinkedList<String>();
        afterRenderSpecialHeadEarsHookTypes = new LinkedList<String>();
        allBaseBeforeRenderSpecialHeadEarsSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderSpecialHeadEarsInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSpecialHeadEarsSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSpecialHeadEarsInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSpecialHeadEarsSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSpecialHeadEarsInferiors = new Hashtable<String, String[]>(0);
        beforeRenderSpecialCloakHookTypes = new LinkedList<String>();
        overrideRenderSpecialCloakHookTypes = new LinkedList<String>();
        afterRenderSpecialCloakHookTypes = new LinkedList<String>();
        allBaseBeforeRenderSpecialCloakSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderSpecialCloakInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSpecialCloakSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSpecialCloakInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSpecialCloakSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSpecialCloakInferiors = new Hashtable<String, String[]>(0);
        beforeRenderSpecialItemInHandHookTypes = new LinkedList<String>();
        overrideRenderSpecialItemInHandHookTypes = new LinkedList<String>();
        afterRenderSpecialItemInHandHookTypes = new LinkedList<String>();
        allBaseBeforeRenderSpecialItemInHandSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderSpecialItemInHandInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSpecialItemInHandSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSpecialItemInHandInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSpecialItemInHandSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSpecialItemInHandInferiors = new Hashtable<String, String[]>(0);
        beforePositionSpecialItemInHandHookTypes = new LinkedList<String>();
        overridePositionSpecialItemInHandHookTypes = new LinkedList<String>();
        afterPositionSpecialItemInHandHookTypes = new LinkedList<String>();
        allBaseBeforePositionSpecialItemInHandSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforePositionSpecialItemInHandInferiors = new Hashtable<String, String[]>(0);
        allBaseOverridePositionSpecialItemInHandSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverridePositionSpecialItemInHandInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterPositionSpecialItemInHandSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterPositionSpecialItemInHandInferiors = new Hashtable<String, String[]>(0);
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

