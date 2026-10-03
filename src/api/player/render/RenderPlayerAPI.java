/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.AbstractClientPlayer
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.model.ModelBase
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.client.renderer.entity.RenderPlayer
 *  net.minecraft.client.renderer.texture.IconRegister
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.ResourceLocation
 */
package api.player.render;

import api.player.render.IRenderPlayerAPI;
import api.player.render.RenderPlayerBase;
import api.player.render.RenderPlayerBaseSorter;
import api.player.render.RenderPlayerBaseSorting;
import java.io.File;
import java.lang.reflect.Constructor;
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
import net.minecraft.util.ResourceLocation;

public final class RenderPlayerAPI {
    private static final Class<?>[] Class = new Class[]{RenderPlayerAPI.class};
    private static final Class<?>[] Classes = new Class[]{RenderPlayerAPI.class, String.class};
    private static boolean isCreated;
    private static final Logger logger;
    private static List<IRenderPlayerAPI> allInstances;
    private static final Map<String, String[]> EmptySortMap;
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
    protected final IRenderPlayerAPI renderPlayer;
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

    private static void log(String var0) {
        System.out.println(var0);
        logger.fine(var0);
    }

    public static void register(String var0, Class<?> var1) {
        RenderPlayerAPI.register(var0, var1, (RenderPlayerBaseSorting)null);
    }

    public static void register(String var0, Class<?> var1, RenderPlayerBaseSorting var2) {
        try {
            RenderPlayerAPI.register(var1, var0, var2);
        }
        catch (RuntimeException var4) {
            if (var0 != null) {
                RenderPlayerAPI.log("Render Player: failed to register id '" + var0 + "'");
            } else {
                RenderPlayerAPI.log("Render Player: failed to register RenderPlayerBase");
            }
            throw var4;
        }
    }

    private static void register(Class<?> var0, String var1, RenderPlayerBaseSorting var2) {
        Constructor<?> var18;
        if (!isCreated) {
            try {
                Method var3 = RenderPlayer.class.getMethod("getRenderPlayerBase", String.class);
                if (var3.getReturnType() != RenderPlayerBase.class) {
                    throw new NoSuchMethodException(RenderPlayerBase.class.getName() + " " + RenderPlayer.class.getName() + ".getRenderPlayerBase(" + String.class.getName() + ")");
                }
            }
            catch (NoSuchMethodException var16) {
                String var12;
                int var11;
                String[] var4 = new String[]{"========================================", "The API \"Render Player\" version 1.1 of the mod \"Render Player API core 1.1\" can not be created!", "----------------------------------------", "Mandatory member method \"{0} getRenderPlayerBase({3})\" not found in class \"{1}\".", "There are three scenarios this can happen:", "* Minecraft Forge is missing a Render Player API core which Minecraft version matches its own.", "  Download and install the latest Render Player API core for the Minecraft version you were trying to run.", "* The code of the class \"{2}\" of Render Player API core has been modified beyond recognition by another Minecraft Forge coremod.", "  Try temporary deinstallation of other core mods to find the culprit and deinstall it permanently to fix this specific problem.", "* Render Player API core has not been installed correctly.", "  Deinstall Render Player API core and install it again following the installation instructions in the readme file.", "========================================"};
                String var5 = RenderPlayerBase.class.getName();
                String var6 = RenderPlayer.class.getName();
                String var7 = var6.replace(".", File.separator);
                String var8 = String.class.getName();
                for (int var9 = 0; var9 < var4.length; ++var9) {
                    var4[var9] = MessageFormat.format(var4[var9], var5, var6, var7, var8);
                }
                String[] var21 = var4;
                int var10 = var4.length;
                for (var11 = 0; var11 < var10; ++var11) {
                    var12 = var21[var11];
                    logger.severe(var12);
                }
                var21 = var4;
                var10 = var4.length;
                for (var11 = 0; var11 < var10; ++var11) {
                    var12 = var21[var11];
                    System.err.println(var12);
                }
                String var22 = "\n\n";
                String[] var23 = var4;
                var11 = var4.length;
                for (int var24 = 0; var24 < var11; ++var24) {
                    String var13 = var23[var24];
                    var22 = var22 + "\t" + var13 + "\n";
                }
                throw new RuntimeException(var22, var16);
            }
            RenderPlayerAPI.log("Render Player 1.1 Created");
            isCreated = true;
        }
        if (var1 == null) {
            throw new NullPointerException("Argument 'id' can not be null");
        }
        if (var0 == null) {
            throw new NullPointerException("Argument 'baseClass' can not be null");
        }
        Constructor<?> var17 = allBaseConstructors.get(var1);
        if (var17 != null) {
            throw new IllegalArgumentException("The class '" + var0.getName() + "' can not be registered with the id '" + var1 + "' because the class '" + var17.getDeclaringClass().getName() + "' has allready been registered with the same id");
        }
        try {
            var18 = var0.getDeclaredConstructor(Classes);
        }
        catch (Throwable var15) {
            try {
                var18 = var0.getDeclaredConstructor(Class);
            }
            catch (Throwable var14) {
                throw new IllegalArgumentException("Can not find necessary constructor with one argument of type '" + RenderPlayerAPI.class.getName() + "' and eventually a second argument of type 'String' in the class '" + var0.getName() + "'", var15);
            }
        }
        allBaseConstructors.put(var1, var18);
        if (var2 != null) {
            RenderPlayerAPI.addSorting(var1, allBaseBeforeLocalConstructingSuperiors, var2.getBeforeLocalConstructingSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeLocalConstructingInferiors, var2.getBeforeLocalConstructingInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterLocalConstructingSuperiors, var2.getAfterLocalConstructingSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterLocalConstructingInferiors, var2.getAfterLocalConstructingInferiors());
            RenderPlayerAPI.addDynamicSorting(var1, allBaseBeforeDynamicSuperiors, var2.getDynamicBeforeSuperiors());
            RenderPlayerAPI.addDynamicSorting(var1, allBaseBeforeDynamicInferiors, var2.getDynamicBeforeInferiors());
            RenderPlayerAPI.addDynamicSorting(var1, allBaseOverrideDynamicSuperiors, var2.getDynamicOverrideSuperiors());
            RenderPlayerAPI.addDynamicSorting(var1, allBaseOverrideDynamicInferiors, var2.getDynamicOverrideInferiors());
            RenderPlayerAPI.addDynamicSorting(var1, allBaseAfterDynamicSuperiors, var2.getDynamicAfterSuperiors());
            RenderPlayerAPI.addDynamicSorting(var1, allBaseAfterDynamicInferiors, var2.getDynamicAfterInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeDoRenderLabelSuperiors, var2.getBeforeDoRenderLabelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeDoRenderLabelInferiors, var2.getBeforeDoRenderLabelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideDoRenderLabelSuperiors, var2.getOverrideDoRenderLabelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideDoRenderLabelInferiors, var2.getOverrideDoRenderLabelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterDoRenderLabelSuperiors, var2.getAfterDoRenderLabelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterDoRenderLabelInferiors, var2.getAfterDoRenderLabelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeDoRenderShadowAndFireSuperiors, var2.getBeforeDoRenderShadowAndFireSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeDoRenderShadowAndFireInferiors, var2.getBeforeDoRenderShadowAndFireInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideDoRenderShadowAndFireSuperiors, var2.getOverrideDoRenderShadowAndFireSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideDoRenderShadowAndFireInferiors, var2.getOverrideDoRenderShadowAndFireInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterDoRenderShadowAndFireSuperiors, var2.getAfterDoRenderShadowAndFireSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterDoRenderShadowAndFireInferiors, var2.getAfterDoRenderShadowAndFireInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeGetColorMultiplierSuperiors, var2.getBeforeGetColorMultiplierSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeGetColorMultiplierInferiors, var2.getBeforeGetColorMultiplierInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideGetColorMultiplierSuperiors, var2.getOverrideGetColorMultiplierSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideGetColorMultiplierInferiors, var2.getOverrideGetColorMultiplierInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterGetColorMultiplierSuperiors, var2.getAfterGetColorMultiplierSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterGetColorMultiplierInferiors, var2.getAfterGetColorMultiplierInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeGetDeathMaxRotationSuperiors, var2.getBeforeGetDeathMaxRotationSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeGetDeathMaxRotationInferiors, var2.getBeforeGetDeathMaxRotationInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideGetDeathMaxRotationSuperiors, var2.getOverrideGetDeathMaxRotationSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideGetDeathMaxRotationInferiors, var2.getOverrideGetDeathMaxRotationInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterGetDeathMaxRotationSuperiors, var2.getAfterGetDeathMaxRotationSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterGetDeathMaxRotationInferiors, var2.getAfterGetDeathMaxRotationInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeGetFontRendererFromRenderManagerSuperiors, var2.getBeforeGetFontRendererFromRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeGetFontRendererFromRenderManagerInferiors, var2.getBeforeGetFontRendererFromRenderManagerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideGetFontRendererFromRenderManagerSuperiors, var2.getOverrideGetFontRendererFromRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideGetFontRendererFromRenderManagerInferiors, var2.getOverrideGetFontRendererFromRenderManagerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterGetFontRendererFromRenderManagerSuperiors, var2.getAfterGetFontRendererFromRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterGetFontRendererFromRenderManagerInferiors, var2.getAfterGetFontRendererFromRenderManagerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeGetResourceLocationFromPlayerSuperiors, var2.getBeforeGetResourceLocationFromPlayerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeGetResourceLocationFromPlayerInferiors, var2.getBeforeGetResourceLocationFromPlayerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideGetResourceLocationFromPlayerSuperiors, var2.getOverrideGetResourceLocationFromPlayerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideGetResourceLocationFromPlayerInferiors, var2.getOverrideGetResourceLocationFromPlayerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterGetResourceLocationFromPlayerSuperiors, var2.getAfterGetResourceLocationFromPlayerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterGetResourceLocationFromPlayerInferiors, var2.getAfterGetResourceLocationFromPlayerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeHandleRotationFloatSuperiors, var2.getBeforeHandleRotationFloatSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeHandleRotationFloatInferiors, var2.getBeforeHandleRotationFloatInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideHandleRotationFloatSuperiors, var2.getOverrideHandleRotationFloatSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideHandleRotationFloatInferiors, var2.getOverrideHandleRotationFloatInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterHandleRotationFloatSuperiors, var2.getAfterHandleRotationFloatSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterHandleRotationFloatInferiors, var2.getAfterHandleRotationFloatInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeInheritRenderPassSuperiors, var2.getBeforeInheritRenderPassSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeInheritRenderPassInferiors, var2.getBeforeInheritRenderPassInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideInheritRenderPassSuperiors, var2.getOverrideInheritRenderPassSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideInheritRenderPassInferiors, var2.getOverrideInheritRenderPassInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterInheritRenderPassSuperiors, var2.getAfterInheritRenderPassSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterInheritRenderPassInferiors, var2.getAfterInheritRenderPassInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeLoadTextureSuperiors, var2.getBeforeLoadTextureSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeLoadTextureInferiors, var2.getBeforeLoadTextureInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideLoadTextureSuperiors, var2.getOverrideLoadTextureSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideLoadTextureInferiors, var2.getOverrideLoadTextureInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterLoadTextureSuperiors, var2.getAfterLoadTextureSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterLoadTextureInferiors, var2.getAfterLoadTextureInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeLoadTextureOfEntitySuperiors, var2.getBeforeLoadTextureOfEntitySuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeLoadTextureOfEntityInferiors, var2.getBeforeLoadTextureOfEntityInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideLoadTextureOfEntitySuperiors, var2.getOverrideLoadTextureOfEntitySuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideLoadTextureOfEntityInferiors, var2.getOverrideLoadTextureOfEntityInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterLoadTextureOfEntitySuperiors, var2.getAfterLoadTextureOfEntitySuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterLoadTextureOfEntityInferiors, var2.getAfterLoadTextureOfEntityInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforePassSpecialRenderSuperiors, var2.getBeforePassSpecialRenderSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforePassSpecialRenderInferiors, var2.getBeforePassSpecialRenderInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverridePassSpecialRenderSuperiors, var2.getOverridePassSpecialRenderSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverridePassSpecialRenderInferiors, var2.getOverridePassSpecialRenderInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterPassSpecialRenderSuperiors, var2.getAfterPassSpecialRenderSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterPassSpecialRenderInferiors, var2.getAfterPassSpecialRenderInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderArrowsStuckInEntitySuperiors, var2.getBeforeRenderArrowsStuckInEntitySuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderArrowsStuckInEntityInferiors, var2.getBeforeRenderArrowsStuckInEntityInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderArrowsStuckInEntitySuperiors, var2.getOverrideRenderArrowsStuckInEntitySuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderArrowsStuckInEntityInferiors, var2.getOverrideRenderArrowsStuckInEntityInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderArrowsStuckInEntitySuperiors, var2.getAfterRenderArrowsStuckInEntitySuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderArrowsStuckInEntityInferiors, var2.getAfterRenderArrowsStuckInEntityInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderFirstPersonArmSuperiors, var2.getBeforeRenderFirstPersonArmSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderFirstPersonArmInferiors, var2.getBeforeRenderFirstPersonArmInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderFirstPersonArmSuperiors, var2.getOverrideRenderFirstPersonArmSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderFirstPersonArmInferiors, var2.getOverrideRenderFirstPersonArmInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderFirstPersonArmSuperiors, var2.getAfterRenderFirstPersonArmSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderFirstPersonArmInferiors, var2.getAfterRenderFirstPersonArmInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderLivingLabelSuperiors, var2.getBeforeRenderLivingLabelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderLivingLabelInferiors, var2.getBeforeRenderLivingLabelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderLivingLabelSuperiors, var2.getOverrideRenderLivingLabelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderLivingLabelInferiors, var2.getOverrideRenderLivingLabelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderLivingLabelSuperiors, var2.getAfterRenderLivingLabelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderLivingLabelInferiors, var2.getAfterRenderLivingLabelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderModelSuperiors, var2.getBeforeRenderModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderModelInferiors, var2.getBeforeRenderModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderModelSuperiors, var2.getOverrideRenderModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderModelInferiors, var2.getOverrideRenderModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderModelSuperiors, var2.getAfterRenderModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderModelInferiors, var2.getAfterRenderModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderPlayerSuperiors, var2.getBeforeRenderPlayerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderPlayerInferiors, var2.getBeforeRenderPlayerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderPlayerSuperiors, var2.getOverrideRenderPlayerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderPlayerInferiors, var2.getOverrideRenderPlayerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderPlayerSuperiors, var2.getAfterRenderPlayerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderPlayerInferiors, var2.getAfterRenderPlayerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderPlayerNameAndScoreLabelSuperiors, var2.getBeforeRenderPlayerNameAndScoreLabelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderPlayerNameAndScoreLabelInferiors, var2.getBeforeRenderPlayerNameAndScoreLabelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderPlayerNameAndScoreLabelSuperiors, var2.getOverrideRenderPlayerNameAndScoreLabelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderPlayerNameAndScoreLabelInferiors, var2.getOverrideRenderPlayerNameAndScoreLabelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderPlayerNameAndScoreLabelSuperiors, var2.getAfterRenderPlayerNameAndScoreLabelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderPlayerNameAndScoreLabelInferiors, var2.getAfterRenderPlayerNameAndScoreLabelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderPlayerScaleSuperiors, var2.getBeforeRenderPlayerScaleSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderPlayerScaleInferiors, var2.getBeforeRenderPlayerScaleInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderPlayerScaleSuperiors, var2.getOverrideRenderPlayerScaleSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderPlayerScaleInferiors, var2.getOverrideRenderPlayerScaleInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderPlayerScaleSuperiors, var2.getAfterRenderPlayerScaleSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderPlayerScaleInferiors, var2.getAfterRenderPlayerScaleInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderPlayerSleepSuperiors, var2.getBeforeRenderPlayerSleepSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderPlayerSleepInferiors, var2.getBeforeRenderPlayerSleepInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderPlayerSleepSuperiors, var2.getOverrideRenderPlayerSleepSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderPlayerSleepInferiors, var2.getOverrideRenderPlayerSleepInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderPlayerSleepSuperiors, var2.getAfterRenderPlayerSleepSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderPlayerSleepInferiors, var2.getAfterRenderPlayerSleepInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderSpecialsSuperiors, var2.getBeforeRenderSpecialsSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderSpecialsInferiors, var2.getBeforeRenderSpecialsInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderSpecialsSuperiors, var2.getOverrideRenderSpecialsSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderSpecialsInferiors, var2.getOverrideRenderSpecialsInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderSpecialsSuperiors, var2.getAfterRenderSpecialsSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderSpecialsInferiors, var2.getAfterRenderSpecialsInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderSwingProgressSuperiors, var2.getBeforeRenderSwingProgressSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRenderSwingProgressInferiors, var2.getBeforeRenderSwingProgressInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderSwingProgressSuperiors, var2.getOverrideRenderSwingProgressSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRenderSwingProgressInferiors, var2.getOverrideRenderSwingProgressInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderSwingProgressSuperiors, var2.getAfterRenderSwingProgressSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRenderSwingProgressInferiors, var2.getAfterRenderSwingProgressInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRotatePlayerSuperiors, var2.getBeforeRotatePlayerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeRotatePlayerInferiors, var2.getBeforeRotatePlayerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRotatePlayerSuperiors, var2.getOverrideRotatePlayerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideRotatePlayerInferiors, var2.getOverrideRotatePlayerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRotatePlayerSuperiors, var2.getAfterRotatePlayerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterRotatePlayerInferiors, var2.getAfterRotatePlayerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeSetArmorModelSuperiors, var2.getBeforeSetArmorModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeSetArmorModelInferiors, var2.getBeforeSetArmorModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideSetArmorModelSuperiors, var2.getOverrideSetArmorModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideSetArmorModelInferiors, var2.getOverrideSetArmorModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterSetArmorModelSuperiors, var2.getAfterSetArmorModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterSetArmorModelInferiors, var2.getAfterSetArmorModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeSetPassArmorModelSuperiors, var2.getBeforeSetPassArmorModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeSetPassArmorModelInferiors, var2.getBeforeSetPassArmorModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideSetPassArmorModelSuperiors, var2.getOverrideSetPassArmorModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideSetPassArmorModelInferiors, var2.getOverrideSetPassArmorModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterSetPassArmorModelSuperiors, var2.getAfterSetPassArmorModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterSetPassArmorModelInferiors, var2.getAfterSetPassArmorModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeSetRenderManagerSuperiors, var2.getBeforeSetRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeSetRenderManagerInferiors, var2.getBeforeSetRenderManagerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideSetRenderManagerSuperiors, var2.getOverrideSetRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideSetRenderManagerInferiors, var2.getOverrideSetRenderManagerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterSetRenderManagerSuperiors, var2.getAfterSetRenderManagerSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterSetRenderManagerInferiors, var2.getAfterSetRenderManagerInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeSetRenderPassModelSuperiors, var2.getBeforeSetRenderPassModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeSetRenderPassModelInferiors, var2.getBeforeSetRenderPassModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideSetRenderPassModelSuperiors, var2.getOverrideSetRenderPassModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideSetRenderPassModelInferiors, var2.getOverrideSetRenderPassModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterSetRenderPassModelSuperiors, var2.getAfterSetRenderPassModelSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterSetRenderPassModelInferiors, var2.getAfterSetRenderPassModelInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeUpdateIconsSuperiors, var2.getBeforeUpdateIconsSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseBeforeUpdateIconsInferiors, var2.getBeforeUpdateIconsInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideUpdateIconsSuperiors, var2.getOverrideUpdateIconsSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseOverrideUpdateIconsInferiors, var2.getOverrideUpdateIconsInferiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterUpdateIconsSuperiors, var2.getAfterUpdateIconsSuperiors());
            RenderPlayerAPI.addSorting(var1, allBaseAfterUpdateIconsInferiors, var2.getAfterUpdateIconsInferiors());
        }
        RenderPlayerAPI.addMethod(var1, var0, beforeLocalConstructingHookTypes, "beforeLocalConstructing", new Class[0]);
        RenderPlayerAPI.addMethod(var1, var0, afterLocalConstructingHookTypes, "afterLocalConstructing", new Class[0]);
        RenderPlayerAPI.addMethod(var1, var0, beforeDoRenderLabelHookTypes, "beforeDoRenderLabel", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(var1, var0, overrideDoRenderLabelHookTypes, "doRenderLabel", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(var1, var0, afterDoRenderLabelHookTypes, "afterDoRenderLabel", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(var1, var0, beforeDoRenderShadowAndFireHookTypes, "beforeDoRenderShadowAndFire", Entity.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideDoRenderShadowAndFireHookTypes, "doRenderShadowAndFire", Entity.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterDoRenderShadowAndFireHookTypes, "afterDoRenderShadowAndFire", Entity.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeGetColorMultiplierHookTypes, "beforeGetColorMultiplier", EntityLivingBase.class, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideGetColorMultiplierHookTypes, "getColorMultiplier", EntityLivingBase.class, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterGetColorMultiplierHookTypes, "afterGetColorMultiplier", EntityLivingBase.class, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeGetDeathMaxRotationHookTypes, "beforeGetDeathMaxRotation", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(var1, var0, overrideGetDeathMaxRotationHookTypes, "getDeathMaxRotation", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(var1, var0, afterGetDeathMaxRotationHookTypes, "afterGetDeathMaxRotation", EntityLivingBase.class);
        RenderPlayerAPI.addMethod(var1, var0, beforeGetFontRendererFromRenderManagerHookTypes, "beforeGetFontRendererFromRenderManager", new Class[0]);
        RenderPlayerAPI.addMethod(var1, var0, overrideGetFontRendererFromRenderManagerHookTypes, "getFontRendererFromRenderManager", new Class[0]);
        RenderPlayerAPI.addMethod(var1, var0, afterGetFontRendererFromRenderManagerHookTypes, "afterGetFontRendererFromRenderManager", new Class[0]);
        RenderPlayerAPI.addMethod(var1, var0, beforeGetResourceLocationFromPlayerHookTypes, "beforeGetResourceLocationFromPlayer", AbstractClientPlayer.class);
        RenderPlayerAPI.addMethod(var1, var0, overrideGetResourceLocationFromPlayerHookTypes, "getResourceLocationFromPlayer", AbstractClientPlayer.class);
        RenderPlayerAPI.addMethod(var1, var0, afterGetResourceLocationFromPlayerHookTypes, "afterGetResourceLocationFromPlayer", AbstractClientPlayer.class);
        RenderPlayerAPI.addMethod(var1, var0, beforeHandleRotationFloatHookTypes, "beforeHandleRotationFloat", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideHandleRotationFloatHookTypes, "handleRotationFloat", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterHandleRotationFloatHookTypes, "afterHandleRotationFloat", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeInheritRenderPassHookTypes, "beforeInheritRenderPass", EntityLivingBase.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideInheritRenderPassHookTypes, "inheritRenderPass", EntityLivingBase.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterInheritRenderPassHookTypes, "afterInheritRenderPass", EntityLivingBase.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeLoadTextureHookTypes, "beforeLoadTexture", ResourceLocation.class);
        RenderPlayerAPI.addMethod(var1, var0, overrideLoadTextureHookTypes, "loadTexture", ResourceLocation.class);
        RenderPlayerAPI.addMethod(var1, var0, afterLoadTextureHookTypes, "afterLoadTexture", ResourceLocation.class);
        RenderPlayerAPI.addMethod(var1, var0, beforeLoadTextureOfEntityHookTypes, "beforeLoadTextureOfEntity", Entity.class);
        RenderPlayerAPI.addMethod(var1, var0, overrideLoadTextureOfEntityHookTypes, "loadTextureOfEntity", Entity.class);
        RenderPlayerAPI.addMethod(var1, var0, afterLoadTextureOfEntityHookTypes, "afterLoadTextureOfEntity", Entity.class);
        RenderPlayerAPI.addMethod(var1, var0, beforePassSpecialRenderHookTypes, "beforePassSpecialRender", EntityLivingBase.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overridePassSpecialRenderHookTypes, "passSpecialRender", EntityLivingBase.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterPassSpecialRenderHookTypes, "afterPassSpecialRender", EntityLivingBase.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeRenderArrowsStuckInEntityHookTypes, "beforeRenderArrowsStuckInEntity", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideRenderArrowsStuckInEntityHookTypes, "renderArrowsStuckInEntity", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterRenderArrowsStuckInEntityHookTypes, "afterRenderArrowsStuckInEntity", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeRenderFirstPersonArmHookTypes, "beforeRenderFirstPersonArm", EntityPlayer.class);
        RenderPlayerAPI.addMethod(var1, var0, overrideRenderFirstPersonArmHookTypes, "renderFirstPersonArm", EntityPlayer.class);
        RenderPlayerAPI.addMethod(var1, var0, afterRenderFirstPersonArmHookTypes, "afterRenderFirstPersonArm", EntityPlayer.class);
        RenderPlayerAPI.addMethod(var1, var0, beforeRenderLivingLabelHookTypes, "beforeRenderLivingLabel", EntityLivingBase.class, String.class, Double.TYPE, Double.TYPE, Double.TYPE, Integer.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideRenderLivingLabelHookTypes, "renderLivingLabel", EntityLivingBase.class, String.class, Double.TYPE, Double.TYPE, Double.TYPE, Integer.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterRenderLivingLabelHookTypes, "afterRenderLivingLabel", EntityLivingBase.class, String.class, Double.TYPE, Double.TYPE, Double.TYPE, Integer.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeRenderModelHookTypes, "beforeRenderModel", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideRenderModelHookTypes, "renderModel", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterRenderModelHookTypes, "afterRenderModel", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeRenderPlayerHookTypes, "beforeRenderPlayer", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideRenderPlayerHookTypes, "renderPlayer", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterRenderPlayerHookTypes, "afterRenderPlayer", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeRenderPlayerNameAndScoreLabelHookTypes, "beforeRenderPlayerNameAndScoreLabel", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, String.class, Float.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideRenderPlayerNameAndScoreLabelHookTypes, "renderPlayerNameAndScoreLabel", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, String.class, Float.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterRenderPlayerNameAndScoreLabelHookTypes, "afterRenderPlayerNameAndScoreLabel", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE, String.class, Float.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeRenderPlayerScaleHookTypes, "beforeRenderPlayerScale", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideRenderPlayerScaleHookTypes, "renderPlayerScale", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterRenderPlayerScaleHookTypes, "afterRenderPlayerScale", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeRenderPlayerSleepHookTypes, "beforeRenderPlayerSleep", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideRenderPlayerSleepHookTypes, "renderPlayerSleep", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterRenderPlayerSleepHookTypes, "afterRenderPlayerSleep", AbstractClientPlayer.class, Double.TYPE, Double.TYPE, Double.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeRenderSpecialsHookTypes, "beforeRenderSpecials", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideRenderSpecialsHookTypes, "renderSpecials", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterRenderSpecialsHookTypes, "afterRenderSpecials", AbstractClientPlayer.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeRenderSwingProgressHookTypes, "beforeRenderSwingProgress", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideRenderSwingProgressHookTypes, "renderSwingProgress", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterRenderSwingProgressHookTypes, "afterRenderSwingProgress", EntityLivingBase.class, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeRotatePlayerHookTypes, "beforeRotatePlayer", AbstractClientPlayer.class, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideRotatePlayerHookTypes, "rotatePlayer", AbstractClientPlayer.class, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterRotatePlayerHookTypes, "afterRotatePlayer", AbstractClientPlayer.class, Float.TYPE, Float.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeSetArmorModelHookTypes, "beforeSetArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideSetArmorModelHookTypes, "setArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterSetArmorModelHookTypes, "afterSetArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeSetPassArmorModelHookTypes, "beforeSetPassArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, overrideSetPassArmorModelHookTypes, "setPassArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, afterSetPassArmorModelHookTypes, "afterSetPassArmorModel", AbstractClientPlayer.class, Integer.TYPE, Float.TYPE);
        RenderPlayerAPI.addMethod(var1, var0, beforeSetRenderManagerHookTypes, "beforeSetRenderManager", RenderManager.class);
        RenderPlayerAPI.addMethod(var1, var0, overrideSetRenderManagerHookTypes, "setRenderManager", RenderManager.class);
        RenderPlayerAPI.addMethod(var1, var0, afterSetRenderManagerHookTypes, "afterSetRenderManager", RenderManager.class);
        RenderPlayerAPI.addMethod(var1, var0, beforeSetRenderPassModelHookTypes, "beforeSetRenderPassModel", ModelBase.class);
        RenderPlayerAPI.addMethod(var1, var0, overrideSetRenderPassModelHookTypes, "setRenderPassModel", ModelBase.class);
        RenderPlayerAPI.addMethod(var1, var0, afterSetRenderPassModelHookTypes, "afterSetRenderPassModel", ModelBase.class);
        RenderPlayerAPI.addMethod(var1, var0, beforeUpdateIconsHookTypes, "beforeUpdateIcons", IconRegister.class);
        RenderPlayerAPI.addMethod(var1, var0, overrideUpdateIconsHookTypes, "updateIcons", IconRegister.class);
        RenderPlayerAPI.addMethod(var1, var0, afterUpdateIconsHookTypes, "afterUpdateIcons", IconRegister.class);
        RenderPlayerAPI.addDynamicMethods(var1, var0);
        RenderPlayerAPI.addDynamicKeys(var1, var0, beforeDynamicHookMethods, beforeDynamicHookTypes);
        RenderPlayerAPI.addDynamicKeys(var1, var0, overrideDynamicHookMethods, overrideDynamicHookTypes);
        RenderPlayerAPI.addDynamicKeys(var1, var0, afterDynamicHookMethods, afterDynamicHookTypes);
        RenderPlayerAPI.initialize();
        for (IRenderPlayerAPI var20 : allInstances) {
            var20.getRenderPlayerAPI().attachRenderPlayerBase(var1);
        }
        System.out.println("Render Player: registered " + var1);
        logger.fine("Render Player: registered class '" + var0.getName() + "' with id '" + var1 + "'");
        initialized = false;
    }

    public static boolean unregister(String var0) {
        if (var0 == null) {
            return false;
        }
        Constructor<?> var1 = allBaseConstructors.remove(var0);
        if (var1 == null) {
            return false;
        }
        for (IRenderPlayerAPI var3 : allInstances) {
            var3.getRenderPlayerAPI().detachRenderPlayerBase(var0);
        }
        beforeLocalConstructingHookTypes.remove(var0);
        afterLocalConstructingHookTypes.remove(var0);
        allBaseBeforeDoRenderLabelSuperiors.remove(var0);
        allBaseBeforeDoRenderLabelInferiors.remove(var0);
        allBaseOverrideDoRenderLabelSuperiors.remove(var0);
        allBaseOverrideDoRenderLabelInferiors.remove(var0);
        allBaseAfterDoRenderLabelSuperiors.remove(var0);
        allBaseAfterDoRenderLabelInferiors.remove(var0);
        beforeDoRenderLabelHookTypes.remove(var0);
        overrideDoRenderLabelHookTypes.remove(var0);
        afterDoRenderLabelHookTypes.remove(var0);
        allBaseBeforeDoRenderShadowAndFireSuperiors.remove(var0);
        allBaseBeforeDoRenderShadowAndFireInferiors.remove(var0);
        allBaseOverrideDoRenderShadowAndFireSuperiors.remove(var0);
        allBaseOverrideDoRenderShadowAndFireInferiors.remove(var0);
        allBaseAfterDoRenderShadowAndFireSuperiors.remove(var0);
        allBaseAfterDoRenderShadowAndFireInferiors.remove(var0);
        beforeDoRenderShadowAndFireHookTypes.remove(var0);
        overrideDoRenderShadowAndFireHookTypes.remove(var0);
        afterDoRenderShadowAndFireHookTypes.remove(var0);
        allBaseBeforeGetColorMultiplierSuperiors.remove(var0);
        allBaseBeforeGetColorMultiplierInferiors.remove(var0);
        allBaseOverrideGetColorMultiplierSuperiors.remove(var0);
        allBaseOverrideGetColorMultiplierInferiors.remove(var0);
        allBaseAfterGetColorMultiplierSuperiors.remove(var0);
        allBaseAfterGetColorMultiplierInferiors.remove(var0);
        beforeGetColorMultiplierHookTypes.remove(var0);
        overrideGetColorMultiplierHookTypes.remove(var0);
        afterGetColorMultiplierHookTypes.remove(var0);
        allBaseBeforeGetDeathMaxRotationSuperiors.remove(var0);
        allBaseBeforeGetDeathMaxRotationInferiors.remove(var0);
        allBaseOverrideGetDeathMaxRotationSuperiors.remove(var0);
        allBaseOverrideGetDeathMaxRotationInferiors.remove(var0);
        allBaseAfterGetDeathMaxRotationSuperiors.remove(var0);
        allBaseAfterGetDeathMaxRotationInferiors.remove(var0);
        beforeGetDeathMaxRotationHookTypes.remove(var0);
        overrideGetDeathMaxRotationHookTypes.remove(var0);
        afterGetDeathMaxRotationHookTypes.remove(var0);
        allBaseBeforeGetFontRendererFromRenderManagerSuperiors.remove(var0);
        allBaseBeforeGetFontRendererFromRenderManagerInferiors.remove(var0);
        allBaseOverrideGetFontRendererFromRenderManagerSuperiors.remove(var0);
        allBaseOverrideGetFontRendererFromRenderManagerInferiors.remove(var0);
        allBaseAfterGetFontRendererFromRenderManagerSuperiors.remove(var0);
        allBaseAfterGetFontRendererFromRenderManagerInferiors.remove(var0);
        beforeGetFontRendererFromRenderManagerHookTypes.remove(var0);
        overrideGetFontRendererFromRenderManagerHookTypes.remove(var0);
        afterGetFontRendererFromRenderManagerHookTypes.remove(var0);
        allBaseBeforeGetResourceLocationFromPlayerSuperiors.remove(var0);
        allBaseBeforeGetResourceLocationFromPlayerInferiors.remove(var0);
        allBaseOverrideGetResourceLocationFromPlayerSuperiors.remove(var0);
        allBaseOverrideGetResourceLocationFromPlayerInferiors.remove(var0);
        allBaseAfterGetResourceLocationFromPlayerSuperiors.remove(var0);
        allBaseAfterGetResourceLocationFromPlayerInferiors.remove(var0);
        beforeGetResourceLocationFromPlayerHookTypes.remove(var0);
        overrideGetResourceLocationFromPlayerHookTypes.remove(var0);
        afterGetResourceLocationFromPlayerHookTypes.remove(var0);
        allBaseBeforeHandleRotationFloatSuperiors.remove(var0);
        allBaseBeforeHandleRotationFloatInferiors.remove(var0);
        allBaseOverrideHandleRotationFloatSuperiors.remove(var0);
        allBaseOverrideHandleRotationFloatInferiors.remove(var0);
        allBaseAfterHandleRotationFloatSuperiors.remove(var0);
        allBaseAfterHandleRotationFloatInferiors.remove(var0);
        beforeHandleRotationFloatHookTypes.remove(var0);
        overrideHandleRotationFloatHookTypes.remove(var0);
        afterHandleRotationFloatHookTypes.remove(var0);
        allBaseBeforeInheritRenderPassSuperiors.remove(var0);
        allBaseBeforeInheritRenderPassInferiors.remove(var0);
        allBaseOverrideInheritRenderPassSuperiors.remove(var0);
        allBaseOverrideInheritRenderPassInferiors.remove(var0);
        allBaseAfterInheritRenderPassSuperiors.remove(var0);
        allBaseAfterInheritRenderPassInferiors.remove(var0);
        beforeInheritRenderPassHookTypes.remove(var0);
        overrideInheritRenderPassHookTypes.remove(var0);
        afterInheritRenderPassHookTypes.remove(var0);
        allBaseBeforeLoadTextureSuperiors.remove(var0);
        allBaseBeforeLoadTextureInferiors.remove(var0);
        allBaseOverrideLoadTextureSuperiors.remove(var0);
        allBaseOverrideLoadTextureInferiors.remove(var0);
        allBaseAfterLoadTextureSuperiors.remove(var0);
        allBaseAfterLoadTextureInferiors.remove(var0);
        beforeLoadTextureHookTypes.remove(var0);
        overrideLoadTextureHookTypes.remove(var0);
        afterLoadTextureHookTypes.remove(var0);
        allBaseBeforeLoadTextureOfEntitySuperiors.remove(var0);
        allBaseBeforeLoadTextureOfEntityInferiors.remove(var0);
        allBaseOverrideLoadTextureOfEntitySuperiors.remove(var0);
        allBaseOverrideLoadTextureOfEntityInferiors.remove(var0);
        allBaseAfterLoadTextureOfEntitySuperiors.remove(var0);
        allBaseAfterLoadTextureOfEntityInferiors.remove(var0);
        beforeLoadTextureOfEntityHookTypes.remove(var0);
        overrideLoadTextureOfEntityHookTypes.remove(var0);
        afterLoadTextureOfEntityHookTypes.remove(var0);
        allBaseBeforePassSpecialRenderSuperiors.remove(var0);
        allBaseBeforePassSpecialRenderInferiors.remove(var0);
        allBaseOverridePassSpecialRenderSuperiors.remove(var0);
        allBaseOverridePassSpecialRenderInferiors.remove(var0);
        allBaseAfterPassSpecialRenderSuperiors.remove(var0);
        allBaseAfterPassSpecialRenderInferiors.remove(var0);
        beforePassSpecialRenderHookTypes.remove(var0);
        overridePassSpecialRenderHookTypes.remove(var0);
        afterPassSpecialRenderHookTypes.remove(var0);
        allBaseBeforeRenderArrowsStuckInEntitySuperiors.remove(var0);
        allBaseBeforeRenderArrowsStuckInEntityInferiors.remove(var0);
        allBaseOverrideRenderArrowsStuckInEntitySuperiors.remove(var0);
        allBaseOverrideRenderArrowsStuckInEntityInferiors.remove(var0);
        allBaseAfterRenderArrowsStuckInEntitySuperiors.remove(var0);
        allBaseAfterRenderArrowsStuckInEntityInferiors.remove(var0);
        beforeRenderArrowsStuckInEntityHookTypes.remove(var0);
        overrideRenderArrowsStuckInEntityHookTypes.remove(var0);
        afterRenderArrowsStuckInEntityHookTypes.remove(var0);
        allBaseBeforeRenderFirstPersonArmSuperiors.remove(var0);
        allBaseBeforeRenderFirstPersonArmInferiors.remove(var0);
        allBaseOverrideRenderFirstPersonArmSuperiors.remove(var0);
        allBaseOverrideRenderFirstPersonArmInferiors.remove(var0);
        allBaseAfterRenderFirstPersonArmSuperiors.remove(var0);
        allBaseAfterRenderFirstPersonArmInferiors.remove(var0);
        beforeRenderFirstPersonArmHookTypes.remove(var0);
        overrideRenderFirstPersonArmHookTypes.remove(var0);
        afterRenderFirstPersonArmHookTypes.remove(var0);
        allBaseBeforeRenderLivingLabelSuperiors.remove(var0);
        allBaseBeforeRenderLivingLabelInferiors.remove(var0);
        allBaseOverrideRenderLivingLabelSuperiors.remove(var0);
        allBaseOverrideRenderLivingLabelInferiors.remove(var0);
        allBaseAfterRenderLivingLabelSuperiors.remove(var0);
        allBaseAfterRenderLivingLabelInferiors.remove(var0);
        beforeRenderLivingLabelHookTypes.remove(var0);
        overrideRenderLivingLabelHookTypes.remove(var0);
        afterRenderLivingLabelHookTypes.remove(var0);
        allBaseBeforeRenderModelSuperiors.remove(var0);
        allBaseBeforeRenderModelInferiors.remove(var0);
        allBaseOverrideRenderModelSuperiors.remove(var0);
        allBaseOverrideRenderModelInferiors.remove(var0);
        allBaseAfterRenderModelSuperiors.remove(var0);
        allBaseAfterRenderModelInferiors.remove(var0);
        beforeRenderModelHookTypes.remove(var0);
        overrideRenderModelHookTypes.remove(var0);
        afterRenderModelHookTypes.remove(var0);
        allBaseBeforeRenderPlayerSuperiors.remove(var0);
        allBaseBeforeRenderPlayerInferiors.remove(var0);
        allBaseOverrideRenderPlayerSuperiors.remove(var0);
        allBaseOverrideRenderPlayerInferiors.remove(var0);
        allBaseAfterRenderPlayerSuperiors.remove(var0);
        allBaseAfterRenderPlayerInferiors.remove(var0);
        beforeRenderPlayerHookTypes.remove(var0);
        overrideRenderPlayerHookTypes.remove(var0);
        afterRenderPlayerHookTypes.remove(var0);
        allBaseBeforeRenderPlayerNameAndScoreLabelSuperiors.remove(var0);
        allBaseBeforeRenderPlayerNameAndScoreLabelInferiors.remove(var0);
        allBaseOverrideRenderPlayerNameAndScoreLabelSuperiors.remove(var0);
        allBaseOverrideRenderPlayerNameAndScoreLabelInferiors.remove(var0);
        allBaseAfterRenderPlayerNameAndScoreLabelSuperiors.remove(var0);
        allBaseAfterRenderPlayerNameAndScoreLabelInferiors.remove(var0);
        beforeRenderPlayerNameAndScoreLabelHookTypes.remove(var0);
        overrideRenderPlayerNameAndScoreLabelHookTypes.remove(var0);
        afterRenderPlayerNameAndScoreLabelHookTypes.remove(var0);
        allBaseBeforeRenderPlayerScaleSuperiors.remove(var0);
        allBaseBeforeRenderPlayerScaleInferiors.remove(var0);
        allBaseOverrideRenderPlayerScaleSuperiors.remove(var0);
        allBaseOverrideRenderPlayerScaleInferiors.remove(var0);
        allBaseAfterRenderPlayerScaleSuperiors.remove(var0);
        allBaseAfterRenderPlayerScaleInferiors.remove(var0);
        beforeRenderPlayerScaleHookTypes.remove(var0);
        overrideRenderPlayerScaleHookTypes.remove(var0);
        afterRenderPlayerScaleHookTypes.remove(var0);
        allBaseBeforeRenderPlayerSleepSuperiors.remove(var0);
        allBaseBeforeRenderPlayerSleepInferiors.remove(var0);
        allBaseOverrideRenderPlayerSleepSuperiors.remove(var0);
        allBaseOverrideRenderPlayerSleepInferiors.remove(var0);
        allBaseAfterRenderPlayerSleepSuperiors.remove(var0);
        allBaseAfterRenderPlayerSleepInferiors.remove(var0);
        beforeRenderPlayerSleepHookTypes.remove(var0);
        overrideRenderPlayerSleepHookTypes.remove(var0);
        afterRenderPlayerSleepHookTypes.remove(var0);
        allBaseBeforeRenderSpecialsSuperiors.remove(var0);
        allBaseBeforeRenderSpecialsInferiors.remove(var0);
        allBaseOverrideRenderSpecialsSuperiors.remove(var0);
        allBaseOverrideRenderSpecialsInferiors.remove(var0);
        allBaseAfterRenderSpecialsSuperiors.remove(var0);
        allBaseAfterRenderSpecialsInferiors.remove(var0);
        beforeRenderSpecialsHookTypes.remove(var0);
        overrideRenderSpecialsHookTypes.remove(var0);
        afterRenderSpecialsHookTypes.remove(var0);
        allBaseBeforeRenderSwingProgressSuperiors.remove(var0);
        allBaseBeforeRenderSwingProgressInferiors.remove(var0);
        allBaseOverrideRenderSwingProgressSuperiors.remove(var0);
        allBaseOverrideRenderSwingProgressInferiors.remove(var0);
        allBaseAfterRenderSwingProgressSuperiors.remove(var0);
        allBaseAfterRenderSwingProgressInferiors.remove(var0);
        beforeRenderSwingProgressHookTypes.remove(var0);
        overrideRenderSwingProgressHookTypes.remove(var0);
        afterRenderSwingProgressHookTypes.remove(var0);
        allBaseBeforeRotatePlayerSuperiors.remove(var0);
        allBaseBeforeRotatePlayerInferiors.remove(var0);
        allBaseOverrideRotatePlayerSuperiors.remove(var0);
        allBaseOverrideRotatePlayerInferiors.remove(var0);
        allBaseAfterRotatePlayerSuperiors.remove(var0);
        allBaseAfterRotatePlayerInferiors.remove(var0);
        beforeRotatePlayerHookTypes.remove(var0);
        overrideRotatePlayerHookTypes.remove(var0);
        afterRotatePlayerHookTypes.remove(var0);
        allBaseBeforeSetArmorModelSuperiors.remove(var0);
        allBaseBeforeSetArmorModelInferiors.remove(var0);
        allBaseOverrideSetArmorModelSuperiors.remove(var0);
        allBaseOverrideSetArmorModelInferiors.remove(var0);
        allBaseAfterSetArmorModelSuperiors.remove(var0);
        allBaseAfterSetArmorModelInferiors.remove(var0);
        beforeSetArmorModelHookTypes.remove(var0);
        overrideSetArmorModelHookTypes.remove(var0);
        afterSetArmorModelHookTypes.remove(var0);
        allBaseBeforeSetPassArmorModelSuperiors.remove(var0);
        allBaseBeforeSetPassArmorModelInferiors.remove(var0);
        allBaseOverrideSetPassArmorModelSuperiors.remove(var0);
        allBaseOverrideSetPassArmorModelInferiors.remove(var0);
        allBaseAfterSetPassArmorModelSuperiors.remove(var0);
        allBaseAfterSetPassArmorModelInferiors.remove(var0);
        beforeSetPassArmorModelHookTypes.remove(var0);
        overrideSetPassArmorModelHookTypes.remove(var0);
        afterSetPassArmorModelHookTypes.remove(var0);
        allBaseBeforeSetRenderManagerSuperiors.remove(var0);
        allBaseBeforeSetRenderManagerInferiors.remove(var0);
        allBaseOverrideSetRenderManagerSuperiors.remove(var0);
        allBaseOverrideSetRenderManagerInferiors.remove(var0);
        allBaseAfterSetRenderManagerSuperiors.remove(var0);
        allBaseAfterSetRenderManagerInferiors.remove(var0);
        beforeSetRenderManagerHookTypes.remove(var0);
        overrideSetRenderManagerHookTypes.remove(var0);
        afterSetRenderManagerHookTypes.remove(var0);
        allBaseBeforeSetRenderPassModelSuperiors.remove(var0);
        allBaseBeforeSetRenderPassModelInferiors.remove(var0);
        allBaseOverrideSetRenderPassModelSuperiors.remove(var0);
        allBaseOverrideSetRenderPassModelInferiors.remove(var0);
        allBaseAfterSetRenderPassModelSuperiors.remove(var0);
        allBaseAfterSetRenderPassModelInferiors.remove(var0);
        beforeSetRenderPassModelHookTypes.remove(var0);
        overrideSetRenderPassModelHookTypes.remove(var0);
        afterSetRenderPassModelHookTypes.remove(var0);
        allBaseBeforeUpdateIconsSuperiors.remove(var0);
        allBaseBeforeUpdateIconsInferiors.remove(var0);
        allBaseOverrideUpdateIconsSuperiors.remove(var0);
        allBaseOverrideUpdateIconsInferiors.remove(var0);
        allBaseAfterUpdateIconsSuperiors.remove(var0);
        allBaseAfterUpdateIconsInferiors.remove(var0);
        beforeUpdateIconsHookTypes.remove(var0);
        overrideUpdateIconsHookTypes.remove(var0);
        afterUpdateIconsHookTypes.remove(var0);
        for (String var7 : keysToVirtualIds.keySet()) {
            if (!keysToVirtualIds.get(var7).equals(var0)) continue;
            keysToVirtualIds.remove(var7);
        }
        boolean var8 = false;
        Class<?> var4 = var1.getDeclaringClass();
        for (String var5 : allBaseConstructors.keySet()) {
            Class<?> var6 = allBaseConstructors.get(var5).getDeclaringClass();
            if (var5.equals(var0) || !var6.equals(var4)) continue;
            var8 = true;
            break;
        }
        if (!var8) {
            dynamicTypes.remove(var4);
            virtualDynamicHookMethods.remove(var4);
            beforeDynamicHookMethods.remove(var4);
            overrideDynamicHookMethods.remove(var4);
            afterDynamicHookMethods.remove(var4);
        }
        RenderPlayerAPI.removeDynamicHookTypes(var0, beforeDynamicHookTypes);
        RenderPlayerAPI.removeDynamicHookTypes(var0, overrideDynamicHookTypes);
        RenderPlayerAPI.removeDynamicHookTypes(var0, afterDynamicHookTypes);
        allBaseBeforeDynamicSuperiors.remove(var0);
        allBaseBeforeDynamicInferiors.remove(var0);
        allBaseOverrideDynamicSuperiors.remove(var0);
        allBaseOverrideDynamicInferiors.remove(var0);
        allBaseAfterDynamicSuperiors.remove(var0);
        allBaseAfterDynamicInferiors.remove(var0);
        RenderPlayerAPI.log("RenderPlayerAPI: unregistered id '" + var0 + "'");
        return true;
    }

    public static void removeDynamicHookTypes(String var0, Map<String, List<String>> var1) {
        Iterator<String> var2 = var1.keySet().iterator();
        while (var2.hasNext()) {
            var1.get(var2.next()).remove(var0);
        }
    }

    public static Set<String> getRegisteredIds() {
        return unmodifiableAllIds;
    }

    private static void addSorting(String var0, Map<String, String[]> var1, String[] var2) {
        if (var2 != null && var2.length > 0) {
            var1.put(var0, var2);
        }
    }

    private static void addDynamicSorting(String var0, Map<String, Map<String, String[]>> var1, Map<String, String[]> var2) {
        if (var2 != null && var2.size() > 0) {
            var1.put(var0, var2);
        }
    }

    private static boolean addMethod(String var0, Class<?> var1, List<String> var2, String var3, Class<?> ... var4) {
        try {
            boolean var6;
            Method var5 = var1.getMethod(var3, var4);
            boolean bl2 = var6 = var5.getDeclaringClass() != RenderPlayerBase.class;
            if (var6) {
                var2.add(var0);
            }
            return var6;
        }
        catch (Exception var7) {
            throw new RuntimeException("Can not reflect method '" + var3 + "' of class '" + var1.getName() + "'", var7);
        }
    }

    private static void addDynamicMethods(String var0, Class<?> var1) {
        if (dynamicTypes.add(var1)) {
            Map<String, Method> var2 = null;
            Map<String, Method> var3 = null;
            Map<String, Method> var4 = null;
            Map<String, Method> var5 = null;
            Method[] var6 = var1.getDeclaredMethods();
            for (int var7 = 0; var7 < var6.length; ++var7) {
                String var10;
                int var9;
                Method var8 = var6[var7];
                if (var8.getDeclaringClass() != var1 || Modifier.isAbstract(var9 = var8.getModifiers()) || Modifier.isStatic(var9) || (var10 = var8.getName()).length() < 7 || !var10.substring(0, 7).equalsIgnoreCase("dynamic")) continue;
                var10 = var10.substring(7);
                while (var10.charAt(0) == '_') {
                    var10 = var10.substring(1);
                }
                boolean var11 = false;
                boolean var12 = false;
                boolean var13 = false;
                boolean var14 = false;
                if (var10.substring(0, 7).equalsIgnoreCase("virtual")) {
                    var12 = true;
                    var10 = var10.substring(7);
                } else if (var10.length() >= 8 && var10.substring(0, 8).equalsIgnoreCase("override")) {
                    var10 = var10.substring(8);
                    var13 = true;
                } else if (var10.length() >= 6 && var10.substring(0, 6).equalsIgnoreCase("before")) {
                    var11 = true;
                    var10 = var10.substring(6);
                } else if (var10.length() >= 5 && var10.substring(0, 5).equalsIgnoreCase("after")) {
                    var14 = true;
                    var10 = var10.substring(5);
                }
                if (var10.length() >= 1 && (var11 || var12 || var13 || var14)) {
                    var10 = var10.substring(0, 1).toLowerCase() + var10.substring(1);
                }
                while (var10.charAt(0) == '_') {
                    var10 = var10.substring(1);
                }
                if (var10.length() == 0) {
                    throw new RuntimeException("Can not process dynamic hook method with no key");
                }
                keys.add(var10);
                if (var12) {
                    if (keysToVirtualIds.containsKey(var10)) {
                        throw new RuntimeException("Can not process more than one dynamic virtual method");
                    }
                    keysToVirtualIds.put(var10, var0);
                    var2 = RenderPlayerAPI.addDynamicMethod(var10, var8, var2);
                    continue;
                }
                if (var11) {
                    var3 = RenderPlayerAPI.addDynamicMethod(var10, var8, var3);
                    continue;
                }
                if (var14) {
                    var5 = RenderPlayerAPI.addDynamicMethod(var10, var8, var5);
                    continue;
                }
                var4 = RenderPlayerAPI.addDynamicMethod(var10, var8, var4);
            }
            if (var2 != null) {
                virtualDynamicHookMethods.put(var1, var2);
            }
            if (var3 != null) {
                beforeDynamicHookMethods.put(var1, var3);
            }
            if (var4 != null) {
                overrideDynamicHookMethods.put(var1, var4);
            }
            if (var5 != null) {
                afterDynamicHookMethods.put(var1, var5);
            }
        }
    }

    private static void addDynamicKeys(String var0, Class<?> var1, Map<Class<?>, Map<String, Method>> var2, Map<String, List<String>> var3) {
        Map<String, Method> var4 = var2.get(var1);
        if (var4 != null && var4.size() != 0) {
            for (String var6 : var4.keySet()) {
                if (!var3.containsKey(var6)) {
                    var3.put(var6, new ArrayList(1));
                }
                var3.get(var6).add(var0);
            }
        }
    }

    private static Map<String, Method> addDynamicMethod(String var0, Method var1, Map<String, Method> var2) {
        if (var2 == null) {
            var2 = new HashMap<String, Method>();
        }
        if (var2.containsKey(var0)) {
            throw new RuntimeException("method with key '" + var0 + "' allready exists");
        }
        var2.put(var0, var1);
        return var2;
    }

    public static RenderPlayerAPI create(IRenderPlayerAPI var0) {
        if (allBaseConstructors.size() > 0 && !initialized) {
            RenderPlayerAPI.initialize();
        }
        return new RenderPlayerAPI(var0);
    }

    private static void initialize() {
        RenderPlayerAPI.sortBases(beforeLocalConstructingHookTypes, allBaseBeforeLocalConstructingSuperiors, allBaseBeforeLocalConstructingInferiors, "beforeLocalConstructing");
        RenderPlayerAPI.sortBases(afterLocalConstructingHookTypes, allBaseAfterLocalConstructingSuperiors, allBaseAfterLocalConstructingInferiors, "afterLocalConstructing");
        for (String var1 : keys) {
            RenderPlayerAPI.sortDynamicBases(beforeDynamicHookTypes, allBaseBeforeDynamicSuperiors, allBaseBeforeDynamicInferiors, var1);
            RenderPlayerAPI.sortDynamicBases(overrideDynamicHookTypes, allBaseOverrideDynamicSuperiors, allBaseOverrideDynamicInferiors, var1);
            RenderPlayerAPI.sortDynamicBases(afterDynamicHookTypes, allBaseAfterDynamicSuperiors, allBaseAfterDynamicInferiors, var1);
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
        initialized = true;
    }

    public static RenderPlayer[] getAllInstances() {
        return allInstances.toArray(new RenderPlayer[allInstances.size()]);
    }

    public static void beforeLocalConstructing(IRenderPlayerAPI var0) {
        RenderPlayerAPI var1 = var0.getRenderPlayerAPI();
        if (var1 != null) {
            var1.load();
        }
        allInstances.add(var0);
        if (var1 != null) {
            var1.beforeLocalConstructing();
        }
    }

    public static void afterLocalConstructing(IRenderPlayerAPI var0) {
        RenderPlayerAPI var1 = var0.getRenderPlayerAPI();
        if (var1 != null) {
            var1.afterLocalConstructing();
        }
    }

    public static RenderPlayerBase getRenderPlayerBase(IRenderPlayerAPI var0, String var1) {
        RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
        return var2 != null ? var2.getRenderPlayerBase(var1) : null;
    }

    public static Set<String> getRenderPlayerBaseIds(IRenderPlayerAPI var0) {
        RenderPlayerAPI var1 = var0.getRenderPlayerAPI();
        Set<String> var2 = null;
        var2 = var1 != null ? var1.getRenderPlayerBaseIds() : Collections.emptySet();
        return var2;
    }

    public static Object dynamic(IRenderPlayerAPI var0, String var1, Object[] var2) {
        RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
        return var3 != null ? var3.dynamic(var1, var2) : null;
    }

    private static void sortBases(List<String> var0, Map<String, String[]> var1, Map<String, String[]> var2, String var3) {
        new RenderPlayerBaseSorter(var0, var1, var2, var3).Sort();
    }

    private static void sortDynamicBases(Map<String, List<String>> var0, Map<String, Map<String, String[]>> var1, Map<String, Map<String, String[]>> var2, String var3) {
        List<String> var4 = var0.get(var3);
        if (var4 != null && var4.size() > 1) {
            RenderPlayerAPI.sortBases(var4, RenderPlayerAPI.getDynamicSorters(var3, var4, var1), RenderPlayerAPI.getDynamicSorters(var3, var4, var2), var3);
        }
    }

    private static Map<String, String[]> getDynamicSorters(String var0, List<String> var1, Map<String, Map<String, String[]>> var2) {
        Map<String, String[]> var3 = null;
        for (String var5 : var1) {
            String[] var7;
            Map<String, String[]> var6 = var2.get(var5);
            if (var6 == null || (var7 = var6.get(var0)) == null || var7.length <= 0) continue;
            if (var3 == null) {
                var3 = new HashMap<String, String[]>(1);
            }
            ((HashMap)var3).put(var5, var7);
        }
        return var3 != null ? var3 : EmptySortMap;
    }

    private RenderPlayerAPI(IRenderPlayerAPI var1) {
        this.renderPlayer = var1;
    }

    private void load() {
        for (String var2 : allBaseConstructors.keySet()) {
            RenderPlayerBase var3 = this.createRenderPlayerBase(var2);
            var3.beforeBaseAttach(false);
            this.allBaseObjects.put(var2, var3);
            this.baseObjectsToId.put(var3, var2);
        }
        this.beforeLocalConstructingHooks = this.create(beforeLocalConstructingHookTypes);
        this.afterLocalConstructingHooks = this.create(afterLocalConstructingHookTypes);
        this.updateRenderPlayerBases();
        Iterator<String> var1 = this.allBaseObjects.keySet().iterator();
        while (var1.hasNext()) {
            this.allBaseObjects.get(var1.next()).afterBaseAttach(false);
        }
    }

    private RenderPlayerBase createRenderPlayerBase(String var1) {
        Constructor<?> var2 = allBaseConstructors.get(var1);
        try {
            RenderPlayerBase var3 = var2.getParameterTypes().length == 1 ? (RenderPlayerBase)var2.newInstance(this) : (RenderPlayerBase)var2.newInstance(this, var1);
            return var3;
        }
        catch (Exception var5) {
            throw new RuntimeException("Exception while creating a RenderPlayerBase of type '" + var2.getDeclaringClass() + "'", var5);
        }
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
    }

    private void attachRenderPlayerBase(String var1) {
        RenderPlayerBase var2 = this.createRenderPlayerBase(var1);
        var2.beforeBaseAttach(true);
        this.allBaseObjects.put(var1, var2);
        this.updateRenderPlayerBases();
        var2.afterBaseAttach(true);
    }

    private void detachRenderPlayerBase(String var1) {
        RenderPlayerBase var2 = this.allBaseObjects.get(var1);
        var2.beforeBaseDetach(true);
        this.allBaseObjects.remove(var1);
        this.updateRenderPlayerBases();
        var2.afterBaseDetach(true);
    }

    private RenderPlayerBase[] create(List<String> var1) {
        if (var1.isEmpty()) {
            return null;
        }
        RenderPlayerBase[] var2 = new RenderPlayerBase[var1.size()];
        for (int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = this.getRenderPlayerBase(var1.get(var3));
        }
        return var2;
    }

    private void beforeLocalConstructing() {
        if (this.beforeLocalConstructingHooks != null) {
            for (int var1 = this.beforeLocalConstructingHooks.length - 1; var1 >= 0; --var1) {
                this.beforeLocalConstructingHooks[var1].beforeLocalConstructing();
            }
        }
        this.beforeLocalConstructingHooks = null;
    }

    private void afterLocalConstructing() {
        if (this.afterLocalConstructingHooks != null) {
            for (int var1 = 0; var1 < this.afterLocalConstructingHooks.length; ++var1) {
                this.afterLocalConstructingHooks[var1].afterLocalConstructing();
            }
        }
        this.afterLocalConstructingHooks = null;
    }

    public RenderPlayerBase getRenderPlayerBase(String var1) {
        return this.allBaseObjects.get(var1);
    }

    public Set<String> getRenderPlayerBaseIds() {
        return this.unmodifiableAllBaseIds;
    }

    public Object dynamic(String var1, Object[] var2) {
        var1 = var1.replace('.', '_').replace(' ', '_');
        this.executeAll(var1, var2, beforeDynamicHookTypes, beforeDynamicHookMethods, true);
        Object var3 = this.dynamicOverwritten(var1, var2, null);
        this.executeAll(var1, var2, afterDynamicHookTypes, afterDynamicHookMethods, false);
        return var3;
    }

    public Object dynamicOverwritten(String var1, Object[] var2, RenderPlayerBase var3) {
        Map<Class<?>, Map<String, Method>> var9;
        List<String> var4 = overrideDynamicHookTypes.get(var1);
        String var5 = null;
        if (var4 != null) {
            if (var3 != null) {
                var5 = this.baseObjectsToId.get(var3);
                int var6 = var4.indexOf(var5);
                var5 = var6 > 0 ? var4.get(var6 - 1) : null;
            } else if (var4.size() > 0) {
                var5 = var4.get(var4.size() - 1);
            }
        }
        if (var5 == null) {
            var5 = keysToVirtualIds.get(var1);
            if (var5 == null) {
                return null;
            }
            var9 = virtualDynamicHookMethods;
        } else {
            var9 = overrideDynamicHookMethods;
        }
        Map<String, Method> var7 = var9.get(allBaseConstructors.get(var5).getDeclaringClass());
        if (var7 == null) {
            return null;
        }
        Method var8 = var7.get(var1);
        return var7 == null ? null : this.execute(this.getRenderPlayerBase(var5), var8, var2);
    }

    private void executeAll(String var1, Object[] var2, Map<String, List<String>> var3, Map<Class<?>, Map<String, Method>> var4, boolean var5) {
        List<String> var6 = var3.get(var1);
        if (var6 != null) {
            int var7;
            int n = var7 = var5 ? var6.size() - 1 : 0;
            while (!(!var5 ? var7 >= var6.size() : var7 < 0)) {
                Method var12;
                String var8 = var6.get(var7);
                RenderPlayerBase var9 = this.getRenderPlayerBase(var8);
                Class<?> var10 = var9.getClass();
                Map<String, Method> var11 = var4.get(var10);
                if (var11 != null && (var12 = var11.get(var1)) != null) {
                    this.execute(var9, var12, var2);
                }
                var7 += var5 ? -1 : 1;
            }
        }
    }

    private Object execute(RenderPlayerBase var1, Method var2, Object[] var3) {
        try {
            return var2.invoke(var1, var3);
        }
        catch (Exception var5) {
            throw new RuntimeException("Exception while invoking dynamic method", var5);
        }
    }

    public static boolean doRenderLabel(IRenderPlayerAPI var0, EntityLivingBase var1) {
        RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
        boolean var2 = var3 != null && var3.isDoRenderLabelModded ? var3.doRenderLabel(var1) : var0.localDoRenderLabel(var1);
        return var2;
    }

    private boolean doRenderLabel(EntityLivingBase var1) {
        if (this.beforeDoRenderLabelHooks != null) {
            for (int var2 = this.beforeDoRenderLabelHooks.length - 1; var2 >= 0; --var2) {
                this.beforeDoRenderLabelHooks[var2].beforeDoRenderLabel(var1);
            }
        }
        boolean var4 = this.overrideDoRenderLabelHooks != null ? this.overrideDoRenderLabelHooks[this.overrideDoRenderLabelHooks.length - 1].doRenderLabel(var1) : this.renderPlayer.localDoRenderLabel(var1);
        if (this.afterDoRenderLabelHooks != null) {
            for (int var3 = 0; var3 < this.afterDoRenderLabelHooks.length; ++var3) {
                this.afterDoRenderLabelHooks[var3].afterDoRenderLabel(var1);
            }
        }
        return var4;
    }

    protected RenderPlayerBase GetOverwrittenDoRenderLabel(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideDoRenderLabelHooks.length; ++var2) {
            if (this.overrideDoRenderLabelHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideDoRenderLabelHooks[var2 - 1];
        }
        return var1;
    }

    public static void doRenderShadowAndFire(IRenderPlayerAPI var0, Entity var1, double var2, double var4, double var6, float var8, float var9) {
        RenderPlayerAPI var10 = var0.getRenderPlayerAPI();
        if (var10 != null && var10.isDoRenderShadowAndFireModded) {
            var10.doRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
        } else {
            var0.localDoRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
        }
    }

    private void doRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9) {
        int var10;
        if (this.beforeDoRenderShadowAndFireHooks != null) {
            for (var10 = this.beforeDoRenderShadowAndFireHooks.length - 1; var10 >= 0; --var10) {
                this.beforeDoRenderShadowAndFireHooks[var10].beforeDoRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
            }
        }
        if (this.overrideDoRenderShadowAndFireHooks != null) {
            this.overrideDoRenderShadowAndFireHooks[this.overrideDoRenderShadowAndFireHooks.length - 1].doRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
        } else {
            this.renderPlayer.localDoRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
        }
        if (this.afterDoRenderShadowAndFireHooks != null) {
            for (var10 = 0; var10 < this.afterDoRenderShadowAndFireHooks.length; ++var10) {
                this.afterDoRenderShadowAndFireHooks[var10].afterDoRenderShadowAndFire(var1, var2, var4, var6, var8, var9);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenDoRenderShadowAndFire(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideDoRenderShadowAndFireHooks.length; ++var2) {
            if (this.overrideDoRenderShadowAndFireHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideDoRenderShadowAndFireHooks[var2 - 1];
        }
        return var1;
    }

    public static int getColorMultiplier(IRenderPlayerAPI var0, EntityLivingBase var1, float var2, float var3) {
        RenderPlayerAPI var5 = var0.getRenderPlayerAPI();
        int var4 = var5 != null && var5.isGetColorMultiplierModded ? var5.getColorMultiplier(var1, var2, var3) : var0.localGetColorMultiplier(var1, var2, var3);
        return var4;
    }

    private int getColorMultiplier(EntityLivingBase var1, float var2, float var3) {
        int var4;
        if (this.beforeGetColorMultiplierHooks != null) {
            for (var4 = this.beforeGetColorMultiplierHooks.length - 1; var4 >= 0; --var4) {
                this.beforeGetColorMultiplierHooks[var4].beforeGetColorMultiplier(var1, var2, var3);
            }
        }
        var4 = this.overrideGetColorMultiplierHooks != null ? this.overrideGetColorMultiplierHooks[this.overrideGetColorMultiplierHooks.length - 1].getColorMultiplier(var1, var2, var3) : this.renderPlayer.localGetColorMultiplier(var1, var2, var3);
        if (this.afterGetColorMultiplierHooks != null) {
            for (int var5 = 0; var5 < this.afterGetColorMultiplierHooks.length; ++var5) {
                this.afterGetColorMultiplierHooks[var5].afterGetColorMultiplier(var1, var2, var3);
            }
        }
        return var4;
    }

    protected RenderPlayerBase GetOverwrittenGetColorMultiplier(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideGetColorMultiplierHooks.length; ++var2) {
            if (this.overrideGetColorMultiplierHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideGetColorMultiplierHooks[var2 - 1];
        }
        return var1;
    }

    public static float getDeathMaxRotation(IRenderPlayerAPI var0, EntityLivingBase var1) {
        RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
        float var2 = var3 != null && var3.isGetDeathMaxRotationModded ? var3.getDeathMaxRotation(var1) : var0.localGetDeathMaxRotation(var1);
        return var2;
    }

    private float getDeathMaxRotation(EntityLivingBase var1) {
        if (this.beforeGetDeathMaxRotationHooks != null) {
            for (int var2 = this.beforeGetDeathMaxRotationHooks.length - 1; var2 >= 0; --var2) {
                this.beforeGetDeathMaxRotationHooks[var2].beforeGetDeathMaxRotation(var1);
            }
        }
        float var4 = this.overrideGetDeathMaxRotationHooks != null ? this.overrideGetDeathMaxRotationHooks[this.overrideGetDeathMaxRotationHooks.length - 1].getDeathMaxRotation(var1) : this.renderPlayer.localGetDeathMaxRotation(var1);
        if (this.afterGetDeathMaxRotationHooks != null) {
            for (int var3 = 0; var3 < this.afterGetDeathMaxRotationHooks.length; ++var3) {
                this.afterGetDeathMaxRotationHooks[var3].afterGetDeathMaxRotation(var1);
            }
        }
        return var4;
    }

    protected RenderPlayerBase GetOverwrittenGetDeathMaxRotation(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideGetDeathMaxRotationHooks.length; ++var2) {
            if (this.overrideGetDeathMaxRotationHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideGetDeathMaxRotationHooks[var2 - 1];
        }
        return var1;
    }

    public static FontRenderer getFontRendererFromRenderManager(IRenderPlayerAPI var0) {
        RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
        FontRenderer var1 = var2 != null && var2.isGetFontRendererFromRenderManagerModded ? var2.getFontRendererFromRenderManager() : var0.localGetFontRendererFromRenderManager();
        return var1;
    }

    private FontRenderer getFontRendererFromRenderManager() {
        if (this.beforeGetFontRendererFromRenderManagerHooks != null) {
            for (int var1 = this.beforeGetFontRendererFromRenderManagerHooks.length - 1; var1 >= 0; --var1) {
                this.beforeGetFontRendererFromRenderManagerHooks[var1].beforeGetFontRendererFromRenderManager();
            }
        }
        FontRenderer var3 = this.overrideGetFontRendererFromRenderManagerHooks != null ? this.overrideGetFontRendererFromRenderManagerHooks[this.overrideGetFontRendererFromRenderManagerHooks.length - 1].getFontRendererFromRenderManager() : this.renderPlayer.localGetFontRendererFromRenderManager();
        if (this.afterGetFontRendererFromRenderManagerHooks != null) {
            for (int var2 = 0; var2 < this.afterGetFontRendererFromRenderManagerHooks.length; ++var2) {
                this.afterGetFontRendererFromRenderManagerHooks[var2].afterGetFontRendererFromRenderManager();
            }
        }
        return var3;
    }

    protected RenderPlayerBase GetOverwrittenGetFontRendererFromRenderManager(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideGetFontRendererFromRenderManagerHooks.length; ++var2) {
            if (this.overrideGetFontRendererFromRenderManagerHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideGetFontRendererFromRenderManagerHooks[var2 - 1];
        }
        return var1;
    }

    public static ResourceLocation getResourceLocationFromPlayer(IRenderPlayerAPI var0, AbstractClientPlayer var1) {
        RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
        ResourceLocation var2 = var3 != null && var3.isGetResourceLocationFromPlayerModded ? var3.getResourceLocationFromPlayer(var1) : var0.localGetResourceLocationFromPlayer(var1);
        return var2;
    }

    private ResourceLocation getResourceLocationFromPlayer(AbstractClientPlayer var1) {
        if (this.beforeGetResourceLocationFromPlayerHooks != null) {
            for (int var2 = this.beforeGetResourceLocationFromPlayerHooks.length - 1; var2 >= 0; --var2) {
                this.beforeGetResourceLocationFromPlayerHooks[var2].beforeGetResourceLocationFromPlayer(var1);
            }
        }
        ResourceLocation var4 = this.overrideGetResourceLocationFromPlayerHooks != null ? this.overrideGetResourceLocationFromPlayerHooks[this.overrideGetResourceLocationFromPlayerHooks.length - 1].getResourceLocationFromPlayer(var1) : this.renderPlayer.localGetResourceLocationFromPlayer(var1);
        if (this.afterGetResourceLocationFromPlayerHooks != null) {
            for (int var3 = 0; var3 < this.afterGetResourceLocationFromPlayerHooks.length; ++var3) {
                this.afterGetResourceLocationFromPlayerHooks[var3].afterGetResourceLocationFromPlayer(var1);
            }
        }
        return var4;
    }

    protected RenderPlayerBase GetOverwrittenGetResourceLocationFromPlayer(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideGetResourceLocationFromPlayerHooks.length; ++var2) {
            if (this.overrideGetResourceLocationFromPlayerHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideGetResourceLocationFromPlayerHooks[var2 - 1];
        }
        return var1;
    }

    public static float handleRotationFloat(IRenderPlayerAPI var0, EntityLivingBase var1, float var2) {
        RenderPlayerAPI var4 = var0.getRenderPlayerAPI();
        float var3 = var4 != null && var4.isHandleRotationFloatModded ? var4.handleRotationFloat(var1, var2) : var0.localHandleRotationFloat(var1, var2);
        return var3;
    }

    private float handleRotationFloat(EntityLivingBase var1, float var2) {
        if (this.beforeHandleRotationFloatHooks != null) {
            for (int var3 = this.beforeHandleRotationFloatHooks.length - 1; var3 >= 0; --var3) {
                this.beforeHandleRotationFloatHooks[var3].beforeHandleRotationFloat(var1, var2);
            }
        }
        float var5 = this.overrideHandleRotationFloatHooks != null ? this.overrideHandleRotationFloatHooks[this.overrideHandleRotationFloatHooks.length - 1].handleRotationFloat(var1, var2) : this.renderPlayer.localHandleRotationFloat(var1, var2);
        if (this.afterHandleRotationFloatHooks != null) {
            for (int var4 = 0; var4 < this.afterHandleRotationFloatHooks.length; ++var4) {
                this.afterHandleRotationFloatHooks[var4].afterHandleRotationFloat(var1, var2);
            }
        }
        return var5;
    }

    protected RenderPlayerBase GetOverwrittenHandleRotationFloat(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideHandleRotationFloatHooks.length; ++var2) {
            if (this.overrideHandleRotationFloatHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideHandleRotationFloatHooks[var2 - 1];
        }
        return var1;
    }

    public static int inheritRenderPass(IRenderPlayerAPI var0, EntityLivingBase var1, int var2, float var3) {
        RenderPlayerAPI var5 = var0.getRenderPlayerAPI();
        int var4 = var5 != null && var5.isInheritRenderPassModded ? var5.inheritRenderPass(var1, var2, var3) : var0.localInheritRenderPass(var1, var2, var3);
        return var4;
    }

    private int inheritRenderPass(EntityLivingBase var1, int var2, float var3) {
        int var4;
        if (this.beforeInheritRenderPassHooks != null) {
            for (var4 = this.beforeInheritRenderPassHooks.length - 1; var4 >= 0; --var4) {
                this.beforeInheritRenderPassHooks[var4].beforeInheritRenderPass(var1, var2, var3);
            }
        }
        var4 = this.overrideInheritRenderPassHooks != null ? this.overrideInheritRenderPassHooks[this.overrideInheritRenderPassHooks.length - 1].inheritRenderPass(var1, var2, var3) : this.renderPlayer.localInheritRenderPass(var1, var2, var3);
        if (this.afterInheritRenderPassHooks != null) {
            for (int var5 = 0; var5 < this.afterInheritRenderPassHooks.length; ++var5) {
                this.afterInheritRenderPassHooks[var5].afterInheritRenderPass(var1, var2, var3);
            }
        }
        return var4;
    }

    protected RenderPlayerBase GetOverwrittenInheritRenderPass(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideInheritRenderPassHooks.length; ++var2) {
            if (this.overrideInheritRenderPassHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideInheritRenderPassHooks[var2 - 1];
        }
        return var1;
    }

    public static void loadTexture(IRenderPlayerAPI var0, ResourceLocation var1) {
        RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
        if (var2 != null && var2.isLoadTextureModded) {
            var2.loadTexture(var1);
        } else {
            var0.localLoadTexture(var1);
        }
    }

    private void loadTexture(ResourceLocation var1) {
        int var2;
        if (this.beforeLoadTextureHooks != null) {
            for (var2 = this.beforeLoadTextureHooks.length - 1; var2 >= 0; --var2) {
                this.beforeLoadTextureHooks[var2].beforeLoadTexture(var1);
            }
        }
        if (this.overrideLoadTextureHooks != null) {
            this.overrideLoadTextureHooks[this.overrideLoadTextureHooks.length - 1].loadTexture(var1);
        } else {
            this.renderPlayer.localLoadTexture(var1);
        }
        if (this.afterLoadTextureHooks != null) {
            for (var2 = 0; var2 < this.afterLoadTextureHooks.length; ++var2) {
                this.afterLoadTextureHooks[var2].afterLoadTexture(var1);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenLoadTexture(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideLoadTextureHooks.length; ++var2) {
            if (this.overrideLoadTextureHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideLoadTextureHooks[var2 - 1];
        }
        return var1;
    }

    public static void loadTextureOfEntity(IRenderPlayerAPI var0, Entity var1) {
        RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
        if (var2 != null && var2.isLoadTextureOfEntityModded) {
            var2.loadTextureOfEntity(var1);
        } else {
            var0.localLoadTextureOfEntity(var1);
        }
    }

    private void loadTextureOfEntity(Entity var1) {
        int var2;
        if (this.beforeLoadTextureOfEntityHooks != null) {
            for (var2 = this.beforeLoadTextureOfEntityHooks.length - 1; var2 >= 0; --var2) {
                this.beforeLoadTextureOfEntityHooks[var2].beforeLoadTextureOfEntity(var1);
            }
        }
        if (this.overrideLoadTextureOfEntityHooks != null) {
            this.overrideLoadTextureOfEntityHooks[this.overrideLoadTextureOfEntityHooks.length - 1].loadTextureOfEntity(var1);
        } else {
            this.renderPlayer.localLoadTextureOfEntity(var1);
        }
        if (this.afterLoadTextureOfEntityHooks != null) {
            for (var2 = 0; var2 < this.afterLoadTextureOfEntityHooks.length; ++var2) {
                this.afterLoadTextureOfEntityHooks[var2].afterLoadTextureOfEntity(var1);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenLoadTextureOfEntity(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideLoadTextureOfEntityHooks.length; ++var2) {
            if (this.overrideLoadTextureOfEntityHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideLoadTextureOfEntityHooks[var2 - 1];
        }
        return var1;
    }

    public static void passSpecialRender(IRenderPlayerAPI var0, EntityLivingBase var1, double var2, double var4, double var6) {
        RenderPlayerAPI var8 = var0.getRenderPlayerAPI();
        if (var8 != null && var8.isPassSpecialRenderModded) {
            var8.passSpecialRender(var1, var2, var4, var6);
        } else {
            var0.localPassSpecialRender(var1, var2, var4, var6);
        }
    }

    private void passSpecialRender(EntityLivingBase var1, double var2, double var4, double var6) {
        int var8;
        if (this.beforePassSpecialRenderHooks != null) {
            for (var8 = this.beforePassSpecialRenderHooks.length - 1; var8 >= 0; --var8) {
                this.beforePassSpecialRenderHooks[var8].beforePassSpecialRender(var1, var2, var4, var6);
            }
        }
        if (this.overridePassSpecialRenderHooks != null) {
            this.overridePassSpecialRenderHooks[this.overridePassSpecialRenderHooks.length - 1].passSpecialRender(var1, var2, var4, var6);
        } else {
            this.renderPlayer.localPassSpecialRender(var1, var2, var4, var6);
        }
        if (this.afterPassSpecialRenderHooks != null) {
            for (var8 = 0; var8 < this.afterPassSpecialRenderHooks.length; ++var8) {
                this.afterPassSpecialRenderHooks[var8].afterPassSpecialRender(var1, var2, var4, var6);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenPassSpecialRender(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overridePassSpecialRenderHooks.length; ++var2) {
            if (this.overridePassSpecialRenderHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overridePassSpecialRenderHooks[var2 - 1];
        }
        return var1;
    }

    public static void renderArrowsStuckInEntity(IRenderPlayerAPI var0, EntityLivingBase var1, float var2) {
        RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
        if (var3 != null && var3.isRenderArrowsStuckInEntityModded) {
            var3.renderArrowsStuckInEntity(var1, var2);
        } else {
            var0.localRenderArrowsStuckInEntity(var1, var2);
        }
    }

    private void renderArrowsStuckInEntity(EntityLivingBase var1, float var2) {
        int var3;
        if (this.beforeRenderArrowsStuckInEntityHooks != null) {
            for (var3 = this.beforeRenderArrowsStuckInEntityHooks.length - 1; var3 >= 0; --var3) {
                this.beforeRenderArrowsStuckInEntityHooks[var3].beforeRenderArrowsStuckInEntity(var1, var2);
            }
        }
        if (this.overrideRenderArrowsStuckInEntityHooks != null) {
            this.overrideRenderArrowsStuckInEntityHooks[this.overrideRenderArrowsStuckInEntityHooks.length - 1].renderArrowsStuckInEntity(var1, var2);
        } else {
            this.renderPlayer.localRenderArrowsStuckInEntity(var1, var2);
        }
        if (this.afterRenderArrowsStuckInEntityHooks != null) {
            for (var3 = 0; var3 < this.afterRenderArrowsStuckInEntityHooks.length; ++var3) {
                this.afterRenderArrowsStuckInEntityHooks[var3].afterRenderArrowsStuckInEntity(var1, var2);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderArrowsStuckInEntity(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderArrowsStuckInEntityHooks.length; ++var2) {
            if (this.overrideRenderArrowsStuckInEntityHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderArrowsStuckInEntityHooks[var2 - 1];
        }
        return var1;
    }

    public static void renderFirstPersonArm(IRenderPlayerAPI var0, EntityPlayer var1) {
        RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
        if (var2 != null && var2.isRenderFirstPersonArmModded) {
            var2.renderFirstPersonArm(var1);
        } else {
            var0.localRenderFirstPersonArm(var1);
        }
    }

    private void renderFirstPersonArm(EntityPlayer var1) {
        int var2;
        if (this.beforeRenderFirstPersonArmHooks != null) {
            for (var2 = this.beforeRenderFirstPersonArmHooks.length - 1; var2 >= 0; --var2) {
                this.beforeRenderFirstPersonArmHooks[var2].beforeRenderFirstPersonArm(var1);
            }
        }
        if (this.overrideRenderFirstPersonArmHooks != null) {
            this.overrideRenderFirstPersonArmHooks[this.overrideRenderFirstPersonArmHooks.length - 1].renderFirstPersonArm(var1);
        } else {
            this.renderPlayer.localRenderFirstPersonArm(var1);
        }
        if (this.afterRenderFirstPersonArmHooks != null) {
            for (var2 = 0; var2 < this.afterRenderFirstPersonArmHooks.length; ++var2) {
                this.afterRenderFirstPersonArmHooks[var2].afterRenderFirstPersonArm(var1);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderFirstPersonArm(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderFirstPersonArmHooks.length; ++var2) {
            if (this.overrideRenderFirstPersonArmHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderFirstPersonArmHooks[var2 - 1];
        }
        return var1;
    }

    public static void renderLivingLabel(IRenderPlayerAPI var0, EntityLivingBase var1, String var2, double var3, double var5, double var7, int var9) {
        RenderPlayerAPI var10 = var0.getRenderPlayerAPI();
        if (var10 != null && var10.isRenderLivingLabelModded) {
            var10.renderLivingLabel(var1, var2, var3, var5, var7, var9);
        } else {
            var0.localRenderLivingLabel(var1, var2, var3, var5, var7, var9);
        }
    }

    private void renderLivingLabel(EntityLivingBase var1, String var2, double var3, double var5, double var7, int var9) {
        int var10;
        if (this.beforeRenderLivingLabelHooks != null) {
            for (var10 = this.beforeRenderLivingLabelHooks.length - 1; var10 >= 0; --var10) {
                this.beforeRenderLivingLabelHooks[var10].beforeRenderLivingLabel(var1, var2, var3, var5, var7, var9);
            }
        }
        if (this.overrideRenderLivingLabelHooks != null) {
            this.overrideRenderLivingLabelHooks[this.overrideRenderLivingLabelHooks.length - 1].renderLivingLabel(var1, var2, var3, var5, var7, var9);
        } else {
            this.renderPlayer.localRenderLivingLabel(var1, var2, var3, var5, var7, var9);
        }
        if (this.afterRenderLivingLabelHooks != null) {
            for (var10 = 0; var10 < this.afterRenderLivingLabelHooks.length; ++var10) {
                this.afterRenderLivingLabelHooks[var10].afterRenderLivingLabel(var1, var2, var3, var5, var7, var9);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderLivingLabel(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderLivingLabelHooks.length; ++var2) {
            if (this.overrideRenderLivingLabelHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderLivingLabelHooks[var2 - 1];
        }
        return var1;
    }

    public static void renderModel(IRenderPlayerAPI var0, EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        RenderPlayerAPI var8 = var0.getRenderPlayerAPI();
        if (var8 != null && var8.isRenderModelModded) {
            var8.renderModel(var1, var2, var3, var4, var5, var6, var7);
        } else {
            var0.localRenderModel(var1, var2, var3, var4, var5, var6, var7);
        }
    }

    private void renderModel(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        int var8;
        if (this.beforeRenderModelHooks != null) {
            for (var8 = this.beforeRenderModelHooks.length - 1; var8 >= 0; --var8) {
                this.beforeRenderModelHooks[var8].beforeRenderModel(var1, var2, var3, var4, var5, var6, var7);
            }
        }
        if (this.overrideRenderModelHooks != null) {
            this.overrideRenderModelHooks[this.overrideRenderModelHooks.length - 1].renderModel(var1, var2, var3, var4, var5, var6, var7);
        } else {
            this.renderPlayer.localRenderModel(var1, var2, var3, var4, var5, var6, var7);
        }
        if (this.afterRenderModelHooks != null) {
            for (var8 = 0; var8 < this.afterRenderModelHooks.length; ++var8) {
                this.afterRenderModelHooks[var8].afterRenderModel(var1, var2, var3, var4, var5, var6, var7);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderModel(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderModelHooks.length; ++var2) {
            if (this.overrideRenderModelHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderModelHooks[var2 - 1];
        }
        return var1;
    }

    public static void renderPlayer(IRenderPlayerAPI var0, AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9) {
        RenderPlayerAPI var10 = var0.getRenderPlayerAPI();
        if (var10 != null && var10.isRenderPlayerModded) {
            var10.renderPlayer(var1, var2, var4, var6, var8, var9);
        } else {
            var0.localRenderPlayer(var1, var2, var4, var6, var8, var9);
        }
    }

    private void renderPlayer(AbstractClientPlayer var1, double var2, double var4, double var6, float var8, float var9) {
        int var10;
        if (this.beforeRenderPlayerHooks != null) {
            for (var10 = this.beforeRenderPlayerHooks.length - 1; var10 >= 0; --var10) {
                this.beforeRenderPlayerHooks[var10].beforeRenderPlayer(var1, var2, var4, var6, var8, var9);
            }
        }
        if (this.overrideRenderPlayerHooks != null) {
            this.overrideRenderPlayerHooks[this.overrideRenderPlayerHooks.length - 1].renderPlayer(var1, var2, var4, var6, var8, var9);
        } else {
            this.renderPlayer.localRenderPlayer(var1, var2, var4, var6, var8, var9);
        }
        if (this.afterRenderPlayerHooks != null) {
            for (var10 = 0; var10 < this.afterRenderPlayerHooks.length; ++var10) {
                this.afterRenderPlayerHooks[var10].afterRenderPlayer(var1, var2, var4, var6, var8, var9);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderPlayer(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderPlayerHooks.length; ++var2) {
            if (this.overrideRenderPlayerHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderPlayerHooks[var2 - 1];
        }
        return var1;
    }

    public static void renderPlayerNameAndScoreLabel(IRenderPlayerAPI var0, AbstractClientPlayer var1, double var2, double var4, double var6, String var8, float var9, double var10) {
        RenderPlayerAPI var12 = var0.getRenderPlayerAPI();
        if (var12 != null && var12.isRenderPlayerNameAndScoreLabelModded) {
            var12.renderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
        } else {
            var0.localRenderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
        }
    }

    private void renderPlayerNameAndScoreLabel(AbstractClientPlayer var1, double var2, double var4, double var6, String var8, float var9, double var10) {
        int var12;
        if (this.beforeRenderPlayerNameAndScoreLabelHooks != null) {
            for (var12 = this.beforeRenderPlayerNameAndScoreLabelHooks.length - 1; var12 >= 0; --var12) {
                this.beforeRenderPlayerNameAndScoreLabelHooks[var12].beforeRenderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
            }
        }
        if (this.overrideRenderPlayerNameAndScoreLabelHooks != null) {
            this.overrideRenderPlayerNameAndScoreLabelHooks[this.overrideRenderPlayerNameAndScoreLabelHooks.length - 1].renderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
        } else {
            this.renderPlayer.localRenderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
        }
        if (this.afterRenderPlayerNameAndScoreLabelHooks != null) {
            for (var12 = 0; var12 < this.afterRenderPlayerNameAndScoreLabelHooks.length; ++var12) {
                this.afterRenderPlayerNameAndScoreLabelHooks[var12].afterRenderPlayerNameAndScoreLabel(var1, var2, var4, var6, var8, var9, var10);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderPlayerNameAndScoreLabel(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderPlayerNameAndScoreLabelHooks.length; ++var2) {
            if (this.overrideRenderPlayerNameAndScoreLabelHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderPlayerNameAndScoreLabelHooks[var2 - 1];
        }
        return var1;
    }

    public static void renderPlayerScale(IRenderPlayerAPI var0, AbstractClientPlayer var1, float var2) {
        RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
        if (var3 != null && var3.isRenderPlayerScaleModded) {
            var3.renderPlayerScale(var1, var2);
        } else {
            var0.localRenderPlayerScale(var1, var2);
        }
    }

    private void renderPlayerScale(AbstractClientPlayer var1, float var2) {
        int var3;
        if (this.beforeRenderPlayerScaleHooks != null) {
            for (var3 = this.beforeRenderPlayerScaleHooks.length - 1; var3 >= 0; --var3) {
                this.beforeRenderPlayerScaleHooks[var3].beforeRenderPlayerScale(var1, var2);
            }
        }
        if (this.overrideRenderPlayerScaleHooks != null) {
            this.overrideRenderPlayerScaleHooks[this.overrideRenderPlayerScaleHooks.length - 1].renderPlayerScale(var1, var2);
        } else {
            this.renderPlayer.localRenderPlayerScale(var1, var2);
        }
        if (this.afterRenderPlayerScaleHooks != null) {
            for (var3 = 0; var3 < this.afterRenderPlayerScaleHooks.length; ++var3) {
                this.afterRenderPlayerScaleHooks[var3].afterRenderPlayerScale(var1, var2);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderPlayerScale(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderPlayerScaleHooks.length; ++var2) {
            if (this.overrideRenderPlayerScaleHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderPlayerScaleHooks[var2 - 1];
        }
        return var1;
    }

    public static void renderPlayerSleep(IRenderPlayerAPI var0, AbstractClientPlayer var1, double var2, double var4, double var6) {
        RenderPlayerAPI var8 = var0.getRenderPlayerAPI();
        if (var8 != null && var8.isRenderPlayerSleepModded) {
            var8.renderPlayerSleep(var1, var2, var4, var6);
        } else {
            var0.localRenderPlayerSleep(var1, var2, var4, var6);
        }
    }

    private void renderPlayerSleep(AbstractClientPlayer var1, double var2, double var4, double var6) {
        int var8;
        if (this.beforeRenderPlayerSleepHooks != null) {
            for (var8 = this.beforeRenderPlayerSleepHooks.length - 1; var8 >= 0; --var8) {
                this.beforeRenderPlayerSleepHooks[var8].beforeRenderPlayerSleep(var1, var2, var4, var6);
            }
        }
        if (this.overrideRenderPlayerSleepHooks != null) {
            this.overrideRenderPlayerSleepHooks[this.overrideRenderPlayerSleepHooks.length - 1].renderPlayerSleep(var1, var2, var4, var6);
        } else {
            this.renderPlayer.localRenderPlayerSleep(var1, var2, var4, var6);
        }
        if (this.afterRenderPlayerSleepHooks != null) {
            for (var8 = 0; var8 < this.afterRenderPlayerSleepHooks.length; ++var8) {
                this.afterRenderPlayerSleepHooks[var8].afterRenderPlayerSleep(var1, var2, var4, var6);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderPlayerSleep(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderPlayerSleepHooks.length; ++var2) {
            if (this.overrideRenderPlayerSleepHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderPlayerSleepHooks[var2 - 1];
        }
        return var1;
    }

    public static void renderSpecials(IRenderPlayerAPI var0, AbstractClientPlayer var1, float var2) {
        RenderPlayerAPI var3 = var0.getRenderPlayerAPI();
        if (var3 != null && var3.isRenderSpecialsModded) {
            var3.renderSpecials(var1, var2);
        } else {
            var0.localRenderSpecials(var1, var2);
        }
    }

    private void renderSpecials(AbstractClientPlayer var1, float var2) {
        int var3;
        if (this.beforeRenderSpecialsHooks != null) {
            for (var3 = this.beforeRenderSpecialsHooks.length - 1; var3 >= 0; --var3) {
                this.beforeRenderSpecialsHooks[var3].beforeRenderSpecials(var1, var2);
            }
        }
        if (this.overrideRenderSpecialsHooks != null) {
            this.overrideRenderSpecialsHooks[this.overrideRenderSpecialsHooks.length - 1].renderSpecials(var1, var2);
        } else {
            this.renderPlayer.localRenderSpecials(var1, var2);
        }
        if (this.afterRenderSpecialsHooks != null) {
            for (var3 = 0; var3 < this.afterRenderSpecialsHooks.length; ++var3) {
                this.afterRenderSpecialsHooks[var3].afterRenderSpecials(var1, var2);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRenderSpecials(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderSpecialsHooks.length; ++var2) {
            if (this.overrideRenderSpecialsHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderSpecialsHooks[var2 - 1];
        }
        return var1;
    }

    public static float renderSwingProgress(IRenderPlayerAPI var0, EntityLivingBase var1, float var2) {
        RenderPlayerAPI var4 = var0.getRenderPlayerAPI();
        float var3 = var4 != null && var4.isRenderSwingProgressModded ? var4.renderSwingProgress(var1, var2) : var0.localRenderSwingProgress(var1, var2);
        return var3;
    }

    private float renderSwingProgress(EntityLivingBase var1, float var2) {
        if (this.beforeRenderSwingProgressHooks != null) {
            for (int var3 = this.beforeRenderSwingProgressHooks.length - 1; var3 >= 0; --var3) {
                this.beforeRenderSwingProgressHooks[var3].beforeRenderSwingProgress(var1, var2);
            }
        }
        float var5 = this.overrideRenderSwingProgressHooks != null ? this.overrideRenderSwingProgressHooks[this.overrideRenderSwingProgressHooks.length - 1].renderSwingProgress(var1, var2) : this.renderPlayer.localRenderSwingProgress(var1, var2);
        if (this.afterRenderSwingProgressHooks != null) {
            for (int var4 = 0; var4 < this.afterRenderSwingProgressHooks.length; ++var4) {
                this.afterRenderSwingProgressHooks[var4].afterRenderSwingProgress(var1, var2);
            }
        }
        return var5;
    }

    protected RenderPlayerBase GetOverwrittenRenderSwingProgress(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderSwingProgressHooks.length; ++var2) {
            if (this.overrideRenderSwingProgressHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderSwingProgressHooks[var2 - 1];
        }
        return var1;
    }

    public static void rotatePlayer(IRenderPlayerAPI var0, AbstractClientPlayer var1, float var2, float var3, float var4) {
        RenderPlayerAPI var5 = var0.getRenderPlayerAPI();
        if (var5 != null && var5.isRotatePlayerModded) {
            var5.rotatePlayer(var1, var2, var3, var4);
        } else {
            var0.localRotatePlayer(var1, var2, var3, var4);
        }
    }

    private void rotatePlayer(AbstractClientPlayer var1, float var2, float var3, float var4) {
        int var5;
        if (this.beforeRotatePlayerHooks != null) {
            for (var5 = this.beforeRotatePlayerHooks.length - 1; var5 >= 0; --var5) {
                this.beforeRotatePlayerHooks[var5].beforeRotatePlayer(var1, var2, var3, var4);
            }
        }
        if (this.overrideRotatePlayerHooks != null) {
            this.overrideRotatePlayerHooks[this.overrideRotatePlayerHooks.length - 1].rotatePlayer(var1, var2, var3, var4);
        } else {
            this.renderPlayer.localRotatePlayer(var1, var2, var3, var4);
        }
        if (this.afterRotatePlayerHooks != null) {
            for (var5 = 0; var5 < this.afterRotatePlayerHooks.length; ++var5) {
                this.afterRotatePlayerHooks[var5].afterRotatePlayer(var1, var2, var3, var4);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenRotatePlayer(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRotatePlayerHooks.length; ++var2) {
            if (this.overrideRotatePlayerHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRotatePlayerHooks[var2 - 1];
        }
        return var1;
    }

    public static int setArmorModel(IRenderPlayerAPI var0, AbstractClientPlayer var1, int var2, float var3) {
        RenderPlayerAPI var5 = var0.getRenderPlayerAPI();
        int var4 = var5 != null && var5.isSetArmorModelModded ? var5.setArmorModel(var1, var2, var3) : var0.localSetArmorModel(var1, var2, var3);
        return var4;
    }

    private int setArmorModel(AbstractClientPlayer var1, int var2, float var3) {
        int var4;
        if (this.beforeSetArmorModelHooks != null) {
            for (var4 = this.beforeSetArmorModelHooks.length - 1; var4 >= 0; --var4) {
                this.beforeSetArmorModelHooks[var4].beforeSetArmorModel(var1, var2, var3);
            }
        }
        var4 = this.overrideSetArmorModelHooks != null ? this.overrideSetArmorModelHooks[this.overrideSetArmorModelHooks.length - 1].setArmorModel(var1, var2, var3) : this.renderPlayer.localSetArmorModel(var1, var2, var3);
        if (this.afterSetArmorModelHooks != null) {
            for (int var5 = 0; var5 < this.afterSetArmorModelHooks.length; ++var5) {
                this.afterSetArmorModelHooks[var5].afterSetArmorModel(var1, var2, var3);
            }
        }
        return var4;
    }

    protected RenderPlayerBase GetOverwrittenSetArmorModel(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideSetArmorModelHooks.length; ++var2) {
            if (this.overrideSetArmorModelHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideSetArmorModelHooks[var2 - 1];
        }
        return var1;
    }

    public static void setPassArmorModel(IRenderPlayerAPI var0, AbstractClientPlayer var1, int var2, float var3) {
        RenderPlayerAPI var4 = var0.getRenderPlayerAPI();
        if (var4 != null && var4.isSetPassArmorModelModded) {
            var4.setPassArmorModel(var1, var2, var3);
        } else {
            var0.localSetPassArmorModel(var1, var2, var3);
        }
    }

    private void setPassArmorModel(AbstractClientPlayer var1, int var2, float var3) {
        int var4;
        if (this.beforeSetPassArmorModelHooks != null) {
            for (var4 = this.beforeSetPassArmorModelHooks.length - 1; var4 >= 0; --var4) {
                this.beforeSetPassArmorModelHooks[var4].beforeSetPassArmorModel(var1, var2, var3);
            }
        }
        if (this.overrideSetPassArmorModelHooks != null) {
            this.overrideSetPassArmorModelHooks[this.overrideSetPassArmorModelHooks.length - 1].setPassArmorModel(var1, var2, var3);
        } else {
            this.renderPlayer.localSetPassArmorModel(var1, var2, var3);
        }
        if (this.afterSetPassArmorModelHooks != null) {
            for (var4 = 0; var4 < this.afterSetPassArmorModelHooks.length; ++var4) {
                this.afterSetPassArmorModelHooks[var4].afterSetPassArmorModel(var1, var2, var3);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenSetPassArmorModel(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideSetPassArmorModelHooks.length; ++var2) {
            if (this.overrideSetPassArmorModelHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideSetPassArmorModelHooks[var2 - 1];
        }
        return var1;
    }

    public static void setRenderManager(IRenderPlayerAPI var0, RenderManager var1) {
        RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
        if (var2 != null && var2.isSetRenderManagerModded) {
            var2.setRenderManager(var1);
        } else {
            var0.localSetRenderManager(var1);
        }
    }

    private void setRenderManager(RenderManager var1) {
        int var2;
        if (this.beforeSetRenderManagerHooks != null) {
            for (var2 = this.beforeSetRenderManagerHooks.length - 1; var2 >= 0; --var2) {
                this.beforeSetRenderManagerHooks[var2].beforeSetRenderManager(var1);
            }
        }
        if (this.overrideSetRenderManagerHooks != null) {
            this.overrideSetRenderManagerHooks[this.overrideSetRenderManagerHooks.length - 1].setRenderManager(var1);
        } else {
            this.renderPlayer.localSetRenderManager(var1);
        }
        if (this.afterSetRenderManagerHooks != null) {
            for (var2 = 0; var2 < this.afterSetRenderManagerHooks.length; ++var2) {
                this.afterSetRenderManagerHooks[var2].afterSetRenderManager(var1);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenSetRenderManager(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideSetRenderManagerHooks.length; ++var2) {
            if (this.overrideSetRenderManagerHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideSetRenderManagerHooks[var2 - 1];
        }
        return var1;
    }

    public static void setRenderPassModel(IRenderPlayerAPI var0, ModelBase var1) {
        RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
        if (var2 != null && var2.isSetRenderPassModelModded) {
            var2.setRenderPassModel(var1);
        } else {
            var0.localSetRenderPassModel(var1);
        }
    }

    private void setRenderPassModel(ModelBase var1) {
        int var2;
        if (this.beforeSetRenderPassModelHooks != null) {
            for (var2 = this.beforeSetRenderPassModelHooks.length - 1; var2 >= 0; --var2) {
                this.beforeSetRenderPassModelHooks[var2].beforeSetRenderPassModel(var1);
            }
        }
        if (this.overrideSetRenderPassModelHooks != null) {
            this.overrideSetRenderPassModelHooks[this.overrideSetRenderPassModelHooks.length - 1].setRenderPassModel(var1);
        } else {
            this.renderPlayer.localSetRenderPassModel(var1);
        }
        if (this.afterSetRenderPassModelHooks != null) {
            for (var2 = 0; var2 < this.afterSetRenderPassModelHooks.length; ++var2) {
                this.afterSetRenderPassModelHooks[var2].afterSetRenderPassModel(var1);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenSetRenderPassModel(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideSetRenderPassModelHooks.length; ++var2) {
            if (this.overrideSetRenderPassModelHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideSetRenderPassModelHooks[var2 - 1];
        }
        return var1;
    }

    public static void updateIcons(IRenderPlayerAPI var0, IconRegister var1) {
        RenderPlayerAPI var2 = var0.getRenderPlayerAPI();
        if (var2 != null && var2.isUpdateIconsModded) {
            var2.updateIcons(var1);
        } else {
            var0.localUpdateIcons(var1);
        }
    }

    private void updateIcons(IconRegister var1) {
        int var2;
        if (this.beforeUpdateIconsHooks != null) {
            for (var2 = this.beforeUpdateIconsHooks.length - 1; var2 >= 0; --var2) {
                this.beforeUpdateIconsHooks[var2].beforeUpdateIcons(var1);
            }
        }
        if (this.overrideUpdateIconsHooks != null) {
            this.overrideUpdateIconsHooks[this.overrideUpdateIconsHooks.length - 1].updateIcons(var1);
        } else {
            this.renderPlayer.localUpdateIcons(var1);
        }
        if (this.afterUpdateIconsHooks != null) {
            for (var2 = 0; var2 < this.afterUpdateIconsHooks.length; ++var2) {
                this.afterUpdateIconsHooks[var2].afterUpdateIcons(var1);
            }
        }
    }

    protected RenderPlayerBase GetOverwrittenUpdateIcons(RenderPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideUpdateIconsHooks.length; ++var2) {
            if (this.overrideUpdateIconsHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideUpdateIconsHooks[var2 - 1];
        }
        return var1;
    }

    static {
        logger = Logger.getLogger("RenderPlayerAPI");
        allInstances = new ArrayList<IRenderPlayerAPI>();
        EmptySortMap = Collections.unmodifiableMap(new HashMap());
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

