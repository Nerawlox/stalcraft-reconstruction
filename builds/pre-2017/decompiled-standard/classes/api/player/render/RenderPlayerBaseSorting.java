/*
 * Decompiled with CFR 0.152.
 */
package api.player.render;

import java.util.HashMap;
import java.util.Map;

public final class RenderPlayerBaseSorting {
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
    private String[] beforeDoRenderLabelSuperiors = null;
    private String[] beforeDoRenderLabelInferiors = null;
    private String[] overrideDoRenderLabelSuperiors = null;
    private String[] overrideDoRenderLabelInferiors = null;
    private String[] afterDoRenderLabelSuperiors = null;
    private String[] afterDoRenderLabelInferiors = null;
    private String[] beforeDoRenderShadowAndFireSuperiors = null;
    private String[] beforeDoRenderShadowAndFireInferiors = null;
    private String[] overrideDoRenderShadowAndFireSuperiors = null;
    private String[] overrideDoRenderShadowAndFireInferiors = null;
    private String[] afterDoRenderShadowAndFireSuperiors = null;
    private String[] afterDoRenderShadowAndFireInferiors = null;
    private String[] beforeGetColorMultiplierSuperiors = null;
    private String[] beforeGetColorMultiplierInferiors = null;
    private String[] overrideGetColorMultiplierSuperiors = null;
    private String[] overrideGetColorMultiplierInferiors = null;
    private String[] afterGetColorMultiplierSuperiors = null;
    private String[] afterGetColorMultiplierInferiors = null;
    private String[] beforeGetDeathMaxRotationSuperiors = null;
    private String[] beforeGetDeathMaxRotationInferiors = null;
    private String[] overrideGetDeathMaxRotationSuperiors = null;
    private String[] overrideGetDeathMaxRotationInferiors = null;
    private String[] afterGetDeathMaxRotationSuperiors = null;
    private String[] afterGetDeathMaxRotationInferiors = null;
    private String[] beforeGetFontRendererFromRenderManagerSuperiors = null;
    private String[] beforeGetFontRendererFromRenderManagerInferiors = null;
    private String[] overrideGetFontRendererFromRenderManagerSuperiors = null;
    private String[] overrideGetFontRendererFromRenderManagerInferiors = null;
    private String[] afterGetFontRendererFromRenderManagerSuperiors = null;
    private String[] afterGetFontRendererFromRenderManagerInferiors = null;
    private String[] beforeGetResourceLocationFromPlayerSuperiors = null;
    private String[] beforeGetResourceLocationFromPlayerInferiors = null;
    private String[] overrideGetResourceLocationFromPlayerSuperiors = null;
    private String[] overrideGetResourceLocationFromPlayerInferiors = null;
    private String[] afterGetResourceLocationFromPlayerSuperiors = null;
    private String[] afterGetResourceLocationFromPlayerInferiors = null;
    private String[] beforeHandleRotationFloatSuperiors = null;
    private String[] beforeHandleRotationFloatInferiors = null;
    private String[] overrideHandleRotationFloatSuperiors = null;
    private String[] overrideHandleRotationFloatInferiors = null;
    private String[] afterHandleRotationFloatSuperiors = null;
    private String[] afterHandleRotationFloatInferiors = null;
    private String[] beforeInheritRenderPassSuperiors = null;
    private String[] beforeInheritRenderPassInferiors = null;
    private String[] overrideInheritRenderPassSuperiors = null;
    private String[] overrideInheritRenderPassInferiors = null;
    private String[] afterInheritRenderPassSuperiors = null;
    private String[] afterInheritRenderPassInferiors = null;
    private String[] beforeLoadTextureSuperiors = null;
    private String[] beforeLoadTextureInferiors = null;
    private String[] overrideLoadTextureSuperiors = null;
    private String[] overrideLoadTextureInferiors = null;
    private String[] afterLoadTextureSuperiors = null;
    private String[] afterLoadTextureInferiors = null;
    private String[] beforeLoadTextureOfEntitySuperiors = null;
    private String[] beforeLoadTextureOfEntityInferiors = null;
    private String[] overrideLoadTextureOfEntitySuperiors = null;
    private String[] overrideLoadTextureOfEntityInferiors = null;
    private String[] afterLoadTextureOfEntitySuperiors = null;
    private String[] afterLoadTextureOfEntityInferiors = null;
    private String[] beforePassSpecialRenderSuperiors = null;
    private String[] beforePassSpecialRenderInferiors = null;
    private String[] overridePassSpecialRenderSuperiors = null;
    private String[] overridePassSpecialRenderInferiors = null;
    private String[] afterPassSpecialRenderSuperiors = null;
    private String[] afterPassSpecialRenderInferiors = null;
    private String[] beforeRenderArrowsStuckInEntitySuperiors = null;
    private String[] beforeRenderArrowsStuckInEntityInferiors = null;
    private String[] overrideRenderArrowsStuckInEntitySuperiors = null;
    private String[] overrideRenderArrowsStuckInEntityInferiors = null;
    private String[] afterRenderArrowsStuckInEntitySuperiors = null;
    private String[] afterRenderArrowsStuckInEntityInferiors = null;
    private String[] beforeRenderFirstPersonArmSuperiors = null;
    private String[] beforeRenderFirstPersonArmInferiors = null;
    private String[] overrideRenderFirstPersonArmSuperiors = null;
    private String[] overrideRenderFirstPersonArmInferiors = null;
    private String[] afterRenderFirstPersonArmSuperiors = null;
    private String[] afterRenderFirstPersonArmInferiors = null;
    private String[] beforeRenderLivingLabelSuperiors = null;
    private String[] beforeRenderLivingLabelInferiors = null;
    private String[] overrideRenderLivingLabelSuperiors = null;
    private String[] overrideRenderLivingLabelInferiors = null;
    private String[] afterRenderLivingLabelSuperiors = null;
    private String[] afterRenderLivingLabelInferiors = null;
    private String[] beforeRenderModelSuperiors = null;
    private String[] beforeRenderModelInferiors = null;
    private String[] overrideRenderModelSuperiors = null;
    private String[] overrideRenderModelInferiors = null;
    private String[] afterRenderModelSuperiors = null;
    private String[] afterRenderModelInferiors = null;
    private String[] beforeRenderPlayerSuperiors = null;
    private String[] beforeRenderPlayerInferiors = null;
    private String[] overrideRenderPlayerSuperiors = null;
    private String[] overrideRenderPlayerInferiors = null;
    private String[] afterRenderPlayerSuperiors = null;
    private String[] afterRenderPlayerInferiors = null;
    private String[] beforeRenderPlayerNameAndScoreLabelSuperiors = null;
    private String[] beforeRenderPlayerNameAndScoreLabelInferiors = null;
    private String[] overrideRenderPlayerNameAndScoreLabelSuperiors = null;
    private String[] overrideRenderPlayerNameAndScoreLabelInferiors = null;
    private String[] afterRenderPlayerNameAndScoreLabelSuperiors = null;
    private String[] afterRenderPlayerNameAndScoreLabelInferiors = null;
    private String[] beforeRenderPlayerScaleSuperiors = null;
    private String[] beforeRenderPlayerScaleInferiors = null;
    private String[] overrideRenderPlayerScaleSuperiors = null;
    private String[] overrideRenderPlayerScaleInferiors = null;
    private String[] afterRenderPlayerScaleSuperiors = null;
    private String[] afterRenderPlayerScaleInferiors = null;
    private String[] beforeRenderPlayerSleepSuperiors = null;
    private String[] beforeRenderPlayerSleepInferiors = null;
    private String[] overrideRenderPlayerSleepSuperiors = null;
    private String[] overrideRenderPlayerSleepInferiors = null;
    private String[] afterRenderPlayerSleepSuperiors = null;
    private String[] afterRenderPlayerSleepInferiors = null;
    private String[] beforeRenderSpecialsSuperiors = null;
    private String[] beforeRenderSpecialsInferiors = null;
    private String[] overrideRenderSpecialsSuperiors = null;
    private String[] overrideRenderSpecialsInferiors = null;
    private String[] afterRenderSpecialsSuperiors = null;
    private String[] afterRenderSpecialsInferiors = null;
    private String[] beforeRenderSwingProgressSuperiors = null;
    private String[] beforeRenderSwingProgressInferiors = null;
    private String[] overrideRenderSwingProgressSuperiors = null;
    private String[] overrideRenderSwingProgressInferiors = null;
    private String[] afterRenderSwingProgressSuperiors = null;
    private String[] afterRenderSwingProgressInferiors = null;
    private String[] beforeRotatePlayerSuperiors = null;
    private String[] beforeRotatePlayerInferiors = null;
    private String[] overrideRotatePlayerSuperiors = null;
    private String[] overrideRotatePlayerInferiors = null;
    private String[] afterRotatePlayerSuperiors = null;
    private String[] afterRotatePlayerInferiors = null;
    private String[] beforeSetArmorModelSuperiors = null;
    private String[] beforeSetArmorModelInferiors = null;
    private String[] overrideSetArmorModelSuperiors = null;
    private String[] overrideSetArmorModelInferiors = null;
    private String[] afterSetArmorModelSuperiors = null;
    private String[] afterSetArmorModelInferiors = null;
    private String[] beforeSetPassArmorModelSuperiors = null;
    private String[] beforeSetPassArmorModelInferiors = null;
    private String[] overrideSetPassArmorModelSuperiors = null;
    private String[] overrideSetPassArmorModelInferiors = null;
    private String[] afterSetPassArmorModelSuperiors = null;
    private String[] afterSetPassArmorModelInferiors = null;
    private String[] beforeSetRenderManagerSuperiors = null;
    private String[] beforeSetRenderManagerInferiors = null;
    private String[] overrideSetRenderManagerSuperiors = null;
    private String[] overrideSetRenderManagerInferiors = null;
    private String[] afterSetRenderManagerSuperiors = null;
    private String[] afterSetRenderManagerInferiors = null;
    private String[] beforeSetRenderPassModelSuperiors = null;
    private String[] beforeSetRenderPassModelInferiors = null;
    private String[] overrideSetRenderPassModelSuperiors = null;
    private String[] overrideSetRenderPassModelInferiors = null;
    private String[] afterSetRenderPassModelSuperiors = null;
    private String[] afterSetRenderPassModelInferiors = null;
    private String[] beforeUpdateIconsSuperiors = null;
    private String[] beforeUpdateIconsInferiors = null;
    private String[] overrideUpdateIconsSuperiors = null;
    private String[] overrideUpdateIconsInferiors = null;
    private String[] afterUpdateIconsSuperiors = null;
    private String[] afterUpdateIconsInferiors = null;
    private String[] beforeRenderSpecialHeadArmorSuperiors = null;
    private String[] beforeRenderSpecialHeadArmorInferiors = null;
    private String[] overrideRenderSpecialHeadArmorSuperiors = null;
    private String[] overrideRenderSpecialHeadArmorInferiors = null;
    private String[] afterRenderSpecialHeadArmorSuperiors = null;
    private String[] afterRenderSpecialHeadArmorInferiors = null;
    private String[] beforeRenderSpecialHeadEarsSuperiors = null;
    private String[] beforeRenderSpecialHeadEarsInferiors = null;
    private String[] overrideRenderSpecialHeadEarsSuperiors = null;
    private String[] overrideRenderSpecialHeadEarsInferiors = null;
    private String[] afterRenderSpecialHeadEarsSuperiors = null;
    private String[] afterRenderSpecialHeadEarsInferiors = null;
    private String[] beforeRenderSpecialCloakSuperiors = null;
    private String[] beforeRenderSpecialCloakInferiors = null;
    private String[] overrideRenderSpecialCloakSuperiors = null;
    private String[] overrideRenderSpecialCloakInferiors = null;
    private String[] afterRenderSpecialCloakSuperiors = null;
    private String[] afterRenderSpecialCloakInferiors = null;
    private String[] beforeRenderSpecialItemInHandSuperiors = null;
    private String[] beforeRenderSpecialItemInHandInferiors = null;
    private String[] overrideRenderSpecialItemInHandSuperiors = null;
    private String[] overrideRenderSpecialItemInHandInferiors = null;
    private String[] afterRenderSpecialItemInHandSuperiors = null;
    private String[] afterRenderSpecialItemInHandInferiors = null;
    private String[] beforePositionSpecialItemInHandSuperiors = null;
    private String[] beforePositionSpecialItemInHandInferiors = null;
    private String[] overridePositionSpecialItemInHandSuperiors = null;
    private String[] overridePositionSpecialItemInHandInferiors = null;
    private String[] afterPositionSpecialItemInHandSuperiors = null;
    private String[] afterPositionSpecialItemInHandInferiors = null;

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

    public String[] getBeforeDoRenderLabelSuperiors() {
        return this.beforeDoRenderLabelSuperiors;
    }

    public String[] getBeforeDoRenderLabelInferiors() {
        return this.beforeDoRenderLabelInferiors;
    }

    public String[] getOverrideDoRenderLabelSuperiors() {
        return this.overrideDoRenderLabelSuperiors;
    }

    public String[] getOverrideDoRenderLabelInferiors() {
        return this.overrideDoRenderLabelInferiors;
    }

    public String[] getAfterDoRenderLabelSuperiors() {
        return this.afterDoRenderLabelSuperiors;
    }

    public String[] getAfterDoRenderLabelInferiors() {
        return this.afterDoRenderLabelInferiors;
    }

    public void setBeforeDoRenderLabelSuperiors(String[] stringArray) {
        this.beforeDoRenderLabelSuperiors = stringArray;
    }

    public void setBeforeDoRenderLabelInferiors(String[] stringArray) {
        this.beforeDoRenderLabelInferiors = stringArray;
    }

    public void setOverrideDoRenderLabelSuperiors(String[] stringArray) {
        this.overrideDoRenderLabelSuperiors = stringArray;
    }

    public void setOverrideDoRenderLabelInferiors(String[] stringArray) {
        this.overrideDoRenderLabelInferiors = stringArray;
    }

    public void setAfterDoRenderLabelSuperiors(String[] stringArray) {
        this.afterDoRenderLabelSuperiors = stringArray;
    }

    public void setAfterDoRenderLabelInferiors(String[] stringArray) {
        this.afterDoRenderLabelInferiors = stringArray;
    }

    public String[] getBeforeDoRenderShadowAndFireSuperiors() {
        return this.beforeDoRenderShadowAndFireSuperiors;
    }

    public String[] getBeforeDoRenderShadowAndFireInferiors() {
        return this.beforeDoRenderShadowAndFireInferiors;
    }

    public String[] getOverrideDoRenderShadowAndFireSuperiors() {
        return this.overrideDoRenderShadowAndFireSuperiors;
    }

    public String[] getOverrideDoRenderShadowAndFireInferiors() {
        return this.overrideDoRenderShadowAndFireInferiors;
    }

    public String[] getAfterDoRenderShadowAndFireSuperiors() {
        return this.afterDoRenderShadowAndFireSuperiors;
    }

    public String[] getAfterDoRenderShadowAndFireInferiors() {
        return this.afterDoRenderShadowAndFireInferiors;
    }

    public void setBeforeDoRenderShadowAndFireSuperiors(String[] stringArray) {
        this.beforeDoRenderShadowAndFireSuperiors = stringArray;
    }

    public void setBeforeDoRenderShadowAndFireInferiors(String[] stringArray) {
        this.beforeDoRenderShadowAndFireInferiors = stringArray;
    }

    public void setOverrideDoRenderShadowAndFireSuperiors(String[] stringArray) {
        this.overrideDoRenderShadowAndFireSuperiors = stringArray;
    }

    public void setOverrideDoRenderShadowAndFireInferiors(String[] stringArray) {
        this.overrideDoRenderShadowAndFireInferiors = stringArray;
    }

    public void setAfterDoRenderShadowAndFireSuperiors(String[] stringArray) {
        this.afterDoRenderShadowAndFireSuperiors = stringArray;
    }

    public void setAfterDoRenderShadowAndFireInferiors(String[] stringArray) {
        this.afterDoRenderShadowAndFireInferiors = stringArray;
    }

    public String[] getBeforeGetColorMultiplierSuperiors() {
        return this.beforeGetColorMultiplierSuperiors;
    }

    public String[] getBeforeGetColorMultiplierInferiors() {
        return this.beforeGetColorMultiplierInferiors;
    }

    public String[] getOverrideGetColorMultiplierSuperiors() {
        return this.overrideGetColorMultiplierSuperiors;
    }

    public String[] getOverrideGetColorMultiplierInferiors() {
        return this.overrideGetColorMultiplierInferiors;
    }

    public String[] getAfterGetColorMultiplierSuperiors() {
        return this.afterGetColorMultiplierSuperiors;
    }

    public String[] getAfterGetColorMultiplierInferiors() {
        return this.afterGetColorMultiplierInferiors;
    }

    public void setBeforeGetColorMultiplierSuperiors(String[] stringArray) {
        this.beforeGetColorMultiplierSuperiors = stringArray;
    }

    public void setBeforeGetColorMultiplierInferiors(String[] stringArray) {
        this.beforeGetColorMultiplierInferiors = stringArray;
    }

    public void setOverrideGetColorMultiplierSuperiors(String[] stringArray) {
        this.overrideGetColorMultiplierSuperiors = stringArray;
    }

    public void setOverrideGetColorMultiplierInferiors(String[] stringArray) {
        this.overrideGetColorMultiplierInferiors = stringArray;
    }

    public void setAfterGetColorMultiplierSuperiors(String[] stringArray) {
        this.afterGetColorMultiplierSuperiors = stringArray;
    }

    public void setAfterGetColorMultiplierInferiors(String[] stringArray) {
        this.afterGetColorMultiplierInferiors = stringArray;
    }

    public String[] getBeforeGetDeathMaxRotationSuperiors() {
        return this.beforeGetDeathMaxRotationSuperiors;
    }

    public String[] getBeforeGetDeathMaxRotationInferiors() {
        return this.beforeGetDeathMaxRotationInferiors;
    }

    public String[] getOverrideGetDeathMaxRotationSuperiors() {
        return this.overrideGetDeathMaxRotationSuperiors;
    }

    public String[] getOverrideGetDeathMaxRotationInferiors() {
        return this.overrideGetDeathMaxRotationInferiors;
    }

    public String[] getAfterGetDeathMaxRotationSuperiors() {
        return this.afterGetDeathMaxRotationSuperiors;
    }

    public String[] getAfterGetDeathMaxRotationInferiors() {
        return this.afterGetDeathMaxRotationInferiors;
    }

    public void setBeforeGetDeathMaxRotationSuperiors(String[] stringArray) {
        this.beforeGetDeathMaxRotationSuperiors = stringArray;
    }

    public void setBeforeGetDeathMaxRotationInferiors(String[] stringArray) {
        this.beforeGetDeathMaxRotationInferiors = stringArray;
    }

    public void setOverrideGetDeathMaxRotationSuperiors(String[] stringArray) {
        this.overrideGetDeathMaxRotationSuperiors = stringArray;
    }

    public void setOverrideGetDeathMaxRotationInferiors(String[] stringArray) {
        this.overrideGetDeathMaxRotationInferiors = stringArray;
    }

    public void setAfterGetDeathMaxRotationSuperiors(String[] stringArray) {
        this.afterGetDeathMaxRotationSuperiors = stringArray;
    }

    public void setAfterGetDeathMaxRotationInferiors(String[] stringArray) {
        this.afterGetDeathMaxRotationInferiors = stringArray;
    }

    public String[] getBeforeGetFontRendererFromRenderManagerSuperiors() {
        return this.beforeGetFontRendererFromRenderManagerSuperiors;
    }

    public String[] getBeforeGetFontRendererFromRenderManagerInferiors() {
        return this.beforeGetFontRendererFromRenderManagerInferiors;
    }

    public String[] getOverrideGetFontRendererFromRenderManagerSuperiors() {
        return this.overrideGetFontRendererFromRenderManagerSuperiors;
    }

    public String[] getOverrideGetFontRendererFromRenderManagerInferiors() {
        return this.overrideGetFontRendererFromRenderManagerInferiors;
    }

    public String[] getAfterGetFontRendererFromRenderManagerSuperiors() {
        return this.afterGetFontRendererFromRenderManagerSuperiors;
    }

    public String[] getAfterGetFontRendererFromRenderManagerInferiors() {
        return this.afterGetFontRendererFromRenderManagerInferiors;
    }

    public void setBeforeGetFontRendererFromRenderManagerSuperiors(String[] stringArray) {
        this.beforeGetFontRendererFromRenderManagerSuperiors = stringArray;
    }

    public void setBeforeGetFontRendererFromRenderManagerInferiors(String[] stringArray) {
        this.beforeGetFontRendererFromRenderManagerInferiors = stringArray;
    }

    public void setOverrideGetFontRendererFromRenderManagerSuperiors(String[] stringArray) {
        this.overrideGetFontRendererFromRenderManagerSuperiors = stringArray;
    }

    public void setOverrideGetFontRendererFromRenderManagerInferiors(String[] stringArray) {
        this.overrideGetFontRendererFromRenderManagerInferiors = stringArray;
    }

    public void setAfterGetFontRendererFromRenderManagerSuperiors(String[] stringArray) {
        this.afterGetFontRendererFromRenderManagerSuperiors = stringArray;
    }

    public void setAfterGetFontRendererFromRenderManagerInferiors(String[] stringArray) {
        this.afterGetFontRendererFromRenderManagerInferiors = stringArray;
    }

    public String[] getBeforeGetResourceLocationFromPlayerSuperiors() {
        return this.beforeGetResourceLocationFromPlayerSuperiors;
    }

    public String[] getBeforeGetResourceLocationFromPlayerInferiors() {
        return this.beforeGetResourceLocationFromPlayerInferiors;
    }

    public String[] getOverrideGetResourceLocationFromPlayerSuperiors() {
        return this.overrideGetResourceLocationFromPlayerSuperiors;
    }

    public String[] getOverrideGetResourceLocationFromPlayerInferiors() {
        return this.overrideGetResourceLocationFromPlayerInferiors;
    }

    public String[] getAfterGetResourceLocationFromPlayerSuperiors() {
        return this.afterGetResourceLocationFromPlayerSuperiors;
    }

    public String[] getAfterGetResourceLocationFromPlayerInferiors() {
        return this.afterGetResourceLocationFromPlayerInferiors;
    }

    public void setBeforeGetResourceLocationFromPlayerSuperiors(String[] stringArray) {
        this.beforeGetResourceLocationFromPlayerSuperiors = stringArray;
    }

    public void setBeforeGetResourceLocationFromPlayerInferiors(String[] stringArray) {
        this.beforeGetResourceLocationFromPlayerInferiors = stringArray;
    }

    public void setOverrideGetResourceLocationFromPlayerSuperiors(String[] stringArray) {
        this.overrideGetResourceLocationFromPlayerSuperiors = stringArray;
    }

    public void setOverrideGetResourceLocationFromPlayerInferiors(String[] stringArray) {
        this.overrideGetResourceLocationFromPlayerInferiors = stringArray;
    }

    public void setAfterGetResourceLocationFromPlayerSuperiors(String[] stringArray) {
        this.afterGetResourceLocationFromPlayerSuperiors = stringArray;
    }

    public void setAfterGetResourceLocationFromPlayerInferiors(String[] stringArray) {
        this.afterGetResourceLocationFromPlayerInferiors = stringArray;
    }

    public String[] getBeforeHandleRotationFloatSuperiors() {
        return this.beforeHandleRotationFloatSuperiors;
    }

    public String[] getBeforeHandleRotationFloatInferiors() {
        return this.beforeHandleRotationFloatInferiors;
    }

    public String[] getOverrideHandleRotationFloatSuperiors() {
        return this.overrideHandleRotationFloatSuperiors;
    }

    public String[] getOverrideHandleRotationFloatInferiors() {
        return this.overrideHandleRotationFloatInferiors;
    }

    public String[] getAfterHandleRotationFloatSuperiors() {
        return this.afterHandleRotationFloatSuperiors;
    }

    public String[] getAfterHandleRotationFloatInferiors() {
        return this.afterHandleRotationFloatInferiors;
    }

    public void setBeforeHandleRotationFloatSuperiors(String[] stringArray) {
        this.beforeHandleRotationFloatSuperiors = stringArray;
    }

    public void setBeforeHandleRotationFloatInferiors(String[] stringArray) {
        this.beforeHandleRotationFloatInferiors = stringArray;
    }

    public void setOverrideHandleRotationFloatSuperiors(String[] stringArray) {
        this.overrideHandleRotationFloatSuperiors = stringArray;
    }

    public void setOverrideHandleRotationFloatInferiors(String[] stringArray) {
        this.overrideHandleRotationFloatInferiors = stringArray;
    }

    public void setAfterHandleRotationFloatSuperiors(String[] stringArray) {
        this.afterHandleRotationFloatSuperiors = stringArray;
    }

    public void setAfterHandleRotationFloatInferiors(String[] stringArray) {
        this.afterHandleRotationFloatInferiors = stringArray;
    }

    public String[] getBeforeInheritRenderPassSuperiors() {
        return this.beforeInheritRenderPassSuperiors;
    }

    public String[] getBeforeInheritRenderPassInferiors() {
        return this.beforeInheritRenderPassInferiors;
    }

    public String[] getOverrideInheritRenderPassSuperiors() {
        return this.overrideInheritRenderPassSuperiors;
    }

    public String[] getOverrideInheritRenderPassInferiors() {
        return this.overrideInheritRenderPassInferiors;
    }

    public String[] getAfterInheritRenderPassSuperiors() {
        return this.afterInheritRenderPassSuperiors;
    }

    public String[] getAfterInheritRenderPassInferiors() {
        return this.afterInheritRenderPassInferiors;
    }

    public void setBeforeInheritRenderPassSuperiors(String[] stringArray) {
        this.beforeInheritRenderPassSuperiors = stringArray;
    }

    public void setBeforeInheritRenderPassInferiors(String[] stringArray) {
        this.beforeInheritRenderPassInferiors = stringArray;
    }

    public void setOverrideInheritRenderPassSuperiors(String[] stringArray) {
        this.overrideInheritRenderPassSuperiors = stringArray;
    }

    public void setOverrideInheritRenderPassInferiors(String[] stringArray) {
        this.overrideInheritRenderPassInferiors = stringArray;
    }

    public void setAfterInheritRenderPassSuperiors(String[] stringArray) {
        this.afterInheritRenderPassSuperiors = stringArray;
    }

    public void setAfterInheritRenderPassInferiors(String[] stringArray) {
        this.afterInheritRenderPassInferiors = stringArray;
    }

    public String[] getBeforeLoadTextureSuperiors() {
        return this.beforeLoadTextureSuperiors;
    }

    public String[] getBeforeLoadTextureInferiors() {
        return this.beforeLoadTextureInferiors;
    }

    public String[] getOverrideLoadTextureSuperiors() {
        return this.overrideLoadTextureSuperiors;
    }

    public String[] getOverrideLoadTextureInferiors() {
        return this.overrideLoadTextureInferiors;
    }

    public String[] getAfterLoadTextureSuperiors() {
        return this.afterLoadTextureSuperiors;
    }

    public String[] getAfterLoadTextureInferiors() {
        return this.afterLoadTextureInferiors;
    }

    public void setBeforeLoadTextureSuperiors(String[] stringArray) {
        this.beforeLoadTextureSuperiors = stringArray;
    }

    public void setBeforeLoadTextureInferiors(String[] stringArray) {
        this.beforeLoadTextureInferiors = stringArray;
    }

    public void setOverrideLoadTextureSuperiors(String[] stringArray) {
        this.overrideLoadTextureSuperiors = stringArray;
    }

    public void setOverrideLoadTextureInferiors(String[] stringArray) {
        this.overrideLoadTextureInferiors = stringArray;
    }

    public void setAfterLoadTextureSuperiors(String[] stringArray) {
        this.afterLoadTextureSuperiors = stringArray;
    }

    public void setAfterLoadTextureInferiors(String[] stringArray) {
        this.afterLoadTextureInferiors = stringArray;
    }

    public String[] getBeforeLoadTextureOfEntitySuperiors() {
        return this.beforeLoadTextureOfEntitySuperiors;
    }

    public String[] getBeforeLoadTextureOfEntityInferiors() {
        return this.beforeLoadTextureOfEntityInferiors;
    }

    public String[] getOverrideLoadTextureOfEntitySuperiors() {
        return this.overrideLoadTextureOfEntitySuperiors;
    }

    public String[] getOverrideLoadTextureOfEntityInferiors() {
        return this.overrideLoadTextureOfEntityInferiors;
    }

    public String[] getAfterLoadTextureOfEntitySuperiors() {
        return this.afterLoadTextureOfEntitySuperiors;
    }

    public String[] getAfterLoadTextureOfEntityInferiors() {
        return this.afterLoadTextureOfEntityInferiors;
    }

    public void setBeforeLoadTextureOfEntitySuperiors(String[] stringArray) {
        this.beforeLoadTextureOfEntitySuperiors = stringArray;
    }

    public void setBeforeLoadTextureOfEntityInferiors(String[] stringArray) {
        this.beforeLoadTextureOfEntityInferiors = stringArray;
    }

    public void setOverrideLoadTextureOfEntitySuperiors(String[] stringArray) {
        this.overrideLoadTextureOfEntitySuperiors = stringArray;
    }

    public void setOverrideLoadTextureOfEntityInferiors(String[] stringArray) {
        this.overrideLoadTextureOfEntityInferiors = stringArray;
    }

    public void setAfterLoadTextureOfEntitySuperiors(String[] stringArray) {
        this.afterLoadTextureOfEntitySuperiors = stringArray;
    }

    public void setAfterLoadTextureOfEntityInferiors(String[] stringArray) {
        this.afterLoadTextureOfEntityInferiors = stringArray;
    }

    public String[] getBeforePassSpecialRenderSuperiors() {
        return this.beforePassSpecialRenderSuperiors;
    }

    public String[] getBeforePassSpecialRenderInferiors() {
        return this.beforePassSpecialRenderInferiors;
    }

    public String[] getOverridePassSpecialRenderSuperiors() {
        return this.overridePassSpecialRenderSuperiors;
    }

    public String[] getOverridePassSpecialRenderInferiors() {
        return this.overridePassSpecialRenderInferiors;
    }

    public String[] getAfterPassSpecialRenderSuperiors() {
        return this.afterPassSpecialRenderSuperiors;
    }

    public String[] getAfterPassSpecialRenderInferiors() {
        return this.afterPassSpecialRenderInferiors;
    }

    public void setBeforePassSpecialRenderSuperiors(String[] stringArray) {
        this.beforePassSpecialRenderSuperiors = stringArray;
    }

    public void setBeforePassSpecialRenderInferiors(String[] stringArray) {
        this.beforePassSpecialRenderInferiors = stringArray;
    }

    public void setOverridePassSpecialRenderSuperiors(String[] stringArray) {
        this.overridePassSpecialRenderSuperiors = stringArray;
    }

    public void setOverridePassSpecialRenderInferiors(String[] stringArray) {
        this.overridePassSpecialRenderInferiors = stringArray;
    }

    public void setAfterPassSpecialRenderSuperiors(String[] stringArray) {
        this.afterPassSpecialRenderSuperiors = stringArray;
    }

    public void setAfterPassSpecialRenderInferiors(String[] stringArray) {
        this.afterPassSpecialRenderInferiors = stringArray;
    }

    public String[] getBeforeRenderArrowsStuckInEntitySuperiors() {
        return this.beforeRenderArrowsStuckInEntitySuperiors;
    }

    public String[] getBeforeRenderArrowsStuckInEntityInferiors() {
        return this.beforeRenderArrowsStuckInEntityInferiors;
    }

    public String[] getOverrideRenderArrowsStuckInEntitySuperiors() {
        return this.overrideRenderArrowsStuckInEntitySuperiors;
    }

    public String[] getOverrideRenderArrowsStuckInEntityInferiors() {
        return this.overrideRenderArrowsStuckInEntityInferiors;
    }

    public String[] getAfterRenderArrowsStuckInEntitySuperiors() {
        return this.afterRenderArrowsStuckInEntitySuperiors;
    }

    public String[] getAfterRenderArrowsStuckInEntityInferiors() {
        return this.afterRenderArrowsStuckInEntityInferiors;
    }

    public void setBeforeRenderArrowsStuckInEntitySuperiors(String[] stringArray) {
        this.beforeRenderArrowsStuckInEntitySuperiors = stringArray;
    }

    public void setBeforeRenderArrowsStuckInEntityInferiors(String[] stringArray) {
        this.beforeRenderArrowsStuckInEntityInferiors = stringArray;
    }

    public void setOverrideRenderArrowsStuckInEntitySuperiors(String[] stringArray) {
        this.overrideRenderArrowsStuckInEntitySuperiors = stringArray;
    }

    public void setOverrideRenderArrowsStuckInEntityInferiors(String[] stringArray) {
        this.overrideRenderArrowsStuckInEntityInferiors = stringArray;
    }

    public void setAfterRenderArrowsStuckInEntitySuperiors(String[] stringArray) {
        this.afterRenderArrowsStuckInEntitySuperiors = stringArray;
    }

    public void setAfterRenderArrowsStuckInEntityInferiors(String[] stringArray) {
        this.afterRenderArrowsStuckInEntityInferiors = stringArray;
    }

    public String[] getBeforeRenderFirstPersonArmSuperiors() {
        return this.beforeRenderFirstPersonArmSuperiors;
    }

    public String[] getBeforeRenderFirstPersonArmInferiors() {
        return this.beforeRenderFirstPersonArmInferiors;
    }

    public String[] getOverrideRenderFirstPersonArmSuperiors() {
        return this.overrideRenderFirstPersonArmSuperiors;
    }

    public String[] getOverrideRenderFirstPersonArmInferiors() {
        return this.overrideRenderFirstPersonArmInferiors;
    }

    public String[] getAfterRenderFirstPersonArmSuperiors() {
        return this.afterRenderFirstPersonArmSuperiors;
    }

    public String[] getAfterRenderFirstPersonArmInferiors() {
        return this.afterRenderFirstPersonArmInferiors;
    }

    public void setBeforeRenderFirstPersonArmSuperiors(String[] stringArray) {
        this.beforeRenderFirstPersonArmSuperiors = stringArray;
    }

    public void setBeforeRenderFirstPersonArmInferiors(String[] stringArray) {
        this.beforeRenderFirstPersonArmInferiors = stringArray;
    }

    public void setOverrideRenderFirstPersonArmSuperiors(String[] stringArray) {
        this.overrideRenderFirstPersonArmSuperiors = stringArray;
    }

    public void setOverrideRenderFirstPersonArmInferiors(String[] stringArray) {
        this.overrideRenderFirstPersonArmInferiors = stringArray;
    }

    public void setAfterRenderFirstPersonArmSuperiors(String[] stringArray) {
        this.afterRenderFirstPersonArmSuperiors = stringArray;
    }

    public void setAfterRenderFirstPersonArmInferiors(String[] stringArray) {
        this.afterRenderFirstPersonArmInferiors = stringArray;
    }

    public String[] getBeforeRenderLivingLabelSuperiors() {
        return this.beforeRenderLivingLabelSuperiors;
    }

    public String[] getBeforeRenderLivingLabelInferiors() {
        return this.beforeRenderLivingLabelInferiors;
    }

    public String[] getOverrideRenderLivingLabelSuperiors() {
        return this.overrideRenderLivingLabelSuperiors;
    }

    public String[] getOverrideRenderLivingLabelInferiors() {
        return this.overrideRenderLivingLabelInferiors;
    }

    public String[] getAfterRenderLivingLabelSuperiors() {
        return this.afterRenderLivingLabelSuperiors;
    }

    public String[] getAfterRenderLivingLabelInferiors() {
        return this.afterRenderLivingLabelInferiors;
    }

    public void setBeforeRenderLivingLabelSuperiors(String[] stringArray) {
        this.beforeRenderLivingLabelSuperiors = stringArray;
    }

    public void setBeforeRenderLivingLabelInferiors(String[] stringArray) {
        this.beforeRenderLivingLabelInferiors = stringArray;
    }

    public void setOverrideRenderLivingLabelSuperiors(String[] stringArray) {
        this.overrideRenderLivingLabelSuperiors = stringArray;
    }

    public void setOverrideRenderLivingLabelInferiors(String[] stringArray) {
        this.overrideRenderLivingLabelInferiors = stringArray;
    }

    public void setAfterRenderLivingLabelSuperiors(String[] stringArray) {
        this.afterRenderLivingLabelSuperiors = stringArray;
    }

    public void setAfterRenderLivingLabelInferiors(String[] stringArray) {
        this.afterRenderLivingLabelInferiors = stringArray;
    }

    public String[] getBeforeRenderModelSuperiors() {
        return this.beforeRenderModelSuperiors;
    }

    public String[] getBeforeRenderModelInferiors() {
        return this.beforeRenderModelInferiors;
    }

    public String[] getOverrideRenderModelSuperiors() {
        return this.overrideRenderModelSuperiors;
    }

    public String[] getOverrideRenderModelInferiors() {
        return this.overrideRenderModelInferiors;
    }

    public String[] getAfterRenderModelSuperiors() {
        return this.afterRenderModelSuperiors;
    }

    public String[] getAfterRenderModelInferiors() {
        return this.afterRenderModelInferiors;
    }

    public void setBeforeRenderModelSuperiors(String[] stringArray) {
        this.beforeRenderModelSuperiors = stringArray;
    }

    public void setBeforeRenderModelInferiors(String[] stringArray) {
        this.beforeRenderModelInferiors = stringArray;
    }

    public void setOverrideRenderModelSuperiors(String[] stringArray) {
        this.overrideRenderModelSuperiors = stringArray;
    }

    public void setOverrideRenderModelInferiors(String[] stringArray) {
        this.overrideRenderModelInferiors = stringArray;
    }

    public void setAfterRenderModelSuperiors(String[] stringArray) {
        this.afterRenderModelSuperiors = stringArray;
    }

    public void setAfterRenderModelInferiors(String[] stringArray) {
        this.afterRenderModelInferiors = stringArray;
    }

    public String[] getBeforeRenderPlayerSuperiors() {
        return this.beforeRenderPlayerSuperiors;
    }

    public String[] getBeforeRenderPlayerInferiors() {
        return this.beforeRenderPlayerInferiors;
    }

    public String[] getOverrideRenderPlayerSuperiors() {
        return this.overrideRenderPlayerSuperiors;
    }

    public String[] getOverrideRenderPlayerInferiors() {
        return this.overrideRenderPlayerInferiors;
    }

    public String[] getAfterRenderPlayerSuperiors() {
        return this.afterRenderPlayerSuperiors;
    }

    public String[] getAfterRenderPlayerInferiors() {
        return this.afterRenderPlayerInferiors;
    }

    public void setBeforeRenderPlayerSuperiors(String[] stringArray) {
        this.beforeRenderPlayerSuperiors = stringArray;
    }

    public void setBeforeRenderPlayerInferiors(String[] stringArray) {
        this.beforeRenderPlayerInferiors = stringArray;
    }

    public void setOverrideRenderPlayerSuperiors(String[] stringArray) {
        this.overrideRenderPlayerSuperiors = stringArray;
    }

    public void setOverrideRenderPlayerInferiors(String[] stringArray) {
        this.overrideRenderPlayerInferiors = stringArray;
    }

    public void setAfterRenderPlayerSuperiors(String[] stringArray) {
        this.afterRenderPlayerSuperiors = stringArray;
    }

    public void setAfterRenderPlayerInferiors(String[] stringArray) {
        this.afterRenderPlayerInferiors = stringArray;
    }

    public String[] getBeforeRenderPlayerNameAndScoreLabelSuperiors() {
        return this.beforeRenderPlayerNameAndScoreLabelSuperiors;
    }

    public String[] getBeforeRenderPlayerNameAndScoreLabelInferiors() {
        return this.beforeRenderPlayerNameAndScoreLabelInferiors;
    }

    public String[] getOverrideRenderPlayerNameAndScoreLabelSuperiors() {
        return this.overrideRenderPlayerNameAndScoreLabelSuperiors;
    }

    public String[] getOverrideRenderPlayerNameAndScoreLabelInferiors() {
        return this.overrideRenderPlayerNameAndScoreLabelInferiors;
    }

    public String[] getAfterRenderPlayerNameAndScoreLabelSuperiors() {
        return this.afterRenderPlayerNameAndScoreLabelSuperiors;
    }

    public String[] getAfterRenderPlayerNameAndScoreLabelInferiors() {
        return this.afterRenderPlayerNameAndScoreLabelInferiors;
    }

    public void setBeforeRenderPlayerNameAndScoreLabelSuperiors(String[] stringArray) {
        this.beforeRenderPlayerNameAndScoreLabelSuperiors = stringArray;
    }

    public void setBeforeRenderPlayerNameAndScoreLabelInferiors(String[] stringArray) {
        this.beforeRenderPlayerNameAndScoreLabelInferiors = stringArray;
    }

    public void setOverrideRenderPlayerNameAndScoreLabelSuperiors(String[] stringArray) {
        this.overrideRenderPlayerNameAndScoreLabelSuperiors = stringArray;
    }

    public void setOverrideRenderPlayerNameAndScoreLabelInferiors(String[] stringArray) {
        this.overrideRenderPlayerNameAndScoreLabelInferiors = stringArray;
    }

    public void setAfterRenderPlayerNameAndScoreLabelSuperiors(String[] stringArray) {
        this.afterRenderPlayerNameAndScoreLabelSuperiors = stringArray;
    }

    public void setAfterRenderPlayerNameAndScoreLabelInferiors(String[] stringArray) {
        this.afterRenderPlayerNameAndScoreLabelInferiors = stringArray;
    }

    public String[] getBeforeRenderPlayerScaleSuperiors() {
        return this.beforeRenderPlayerScaleSuperiors;
    }

    public String[] getBeforeRenderPlayerScaleInferiors() {
        return this.beforeRenderPlayerScaleInferiors;
    }

    public String[] getOverrideRenderPlayerScaleSuperiors() {
        return this.overrideRenderPlayerScaleSuperiors;
    }

    public String[] getOverrideRenderPlayerScaleInferiors() {
        return this.overrideRenderPlayerScaleInferiors;
    }

    public String[] getAfterRenderPlayerScaleSuperiors() {
        return this.afterRenderPlayerScaleSuperiors;
    }

    public String[] getAfterRenderPlayerScaleInferiors() {
        return this.afterRenderPlayerScaleInferiors;
    }

    public void setBeforeRenderPlayerScaleSuperiors(String[] stringArray) {
        this.beforeRenderPlayerScaleSuperiors = stringArray;
    }

    public void setBeforeRenderPlayerScaleInferiors(String[] stringArray) {
        this.beforeRenderPlayerScaleInferiors = stringArray;
    }

    public void setOverrideRenderPlayerScaleSuperiors(String[] stringArray) {
        this.overrideRenderPlayerScaleSuperiors = stringArray;
    }

    public void setOverrideRenderPlayerScaleInferiors(String[] stringArray) {
        this.overrideRenderPlayerScaleInferiors = stringArray;
    }

    public void setAfterRenderPlayerScaleSuperiors(String[] stringArray) {
        this.afterRenderPlayerScaleSuperiors = stringArray;
    }

    public void setAfterRenderPlayerScaleInferiors(String[] stringArray) {
        this.afterRenderPlayerScaleInferiors = stringArray;
    }

    public String[] getBeforeRenderPlayerSleepSuperiors() {
        return this.beforeRenderPlayerSleepSuperiors;
    }

    public String[] getBeforeRenderPlayerSleepInferiors() {
        return this.beforeRenderPlayerSleepInferiors;
    }

    public String[] getOverrideRenderPlayerSleepSuperiors() {
        return this.overrideRenderPlayerSleepSuperiors;
    }

    public String[] getOverrideRenderPlayerSleepInferiors() {
        return this.overrideRenderPlayerSleepInferiors;
    }

    public String[] getAfterRenderPlayerSleepSuperiors() {
        return this.afterRenderPlayerSleepSuperiors;
    }

    public String[] getAfterRenderPlayerSleepInferiors() {
        return this.afterRenderPlayerSleepInferiors;
    }

    public void setBeforeRenderPlayerSleepSuperiors(String[] stringArray) {
        this.beforeRenderPlayerSleepSuperiors = stringArray;
    }

    public void setBeforeRenderPlayerSleepInferiors(String[] stringArray) {
        this.beforeRenderPlayerSleepInferiors = stringArray;
    }

    public void setOverrideRenderPlayerSleepSuperiors(String[] stringArray) {
        this.overrideRenderPlayerSleepSuperiors = stringArray;
    }

    public void setOverrideRenderPlayerSleepInferiors(String[] stringArray) {
        this.overrideRenderPlayerSleepInferiors = stringArray;
    }

    public void setAfterRenderPlayerSleepSuperiors(String[] stringArray) {
        this.afterRenderPlayerSleepSuperiors = stringArray;
    }

    public void setAfterRenderPlayerSleepInferiors(String[] stringArray) {
        this.afterRenderPlayerSleepInferiors = stringArray;
    }

    public String[] getBeforeRenderSpecialsSuperiors() {
        return this.beforeRenderSpecialsSuperiors;
    }

    public String[] getBeforeRenderSpecialsInferiors() {
        return this.beforeRenderSpecialsInferiors;
    }

    public String[] getOverrideRenderSpecialsSuperiors() {
        return this.overrideRenderSpecialsSuperiors;
    }

    public String[] getOverrideRenderSpecialsInferiors() {
        return this.overrideRenderSpecialsInferiors;
    }

    public String[] getAfterRenderSpecialsSuperiors() {
        return this.afterRenderSpecialsSuperiors;
    }

    public String[] getAfterRenderSpecialsInferiors() {
        return this.afterRenderSpecialsInferiors;
    }

    public void setBeforeRenderSpecialsSuperiors(String[] stringArray) {
        this.beforeRenderSpecialsSuperiors = stringArray;
    }

    public void setBeforeRenderSpecialsInferiors(String[] stringArray) {
        this.beforeRenderSpecialsInferiors = stringArray;
    }

    public void setOverrideRenderSpecialsSuperiors(String[] stringArray) {
        this.overrideRenderSpecialsSuperiors = stringArray;
    }

    public void setOverrideRenderSpecialsInferiors(String[] stringArray) {
        this.overrideRenderSpecialsInferiors = stringArray;
    }

    public void setAfterRenderSpecialsSuperiors(String[] stringArray) {
        this.afterRenderSpecialsSuperiors = stringArray;
    }

    public void setAfterRenderSpecialsInferiors(String[] stringArray) {
        this.afterRenderSpecialsInferiors = stringArray;
    }

    public String[] getBeforeRenderSwingProgressSuperiors() {
        return this.beforeRenderSwingProgressSuperiors;
    }

    public String[] getBeforeRenderSwingProgressInferiors() {
        return this.beforeRenderSwingProgressInferiors;
    }

    public String[] getOverrideRenderSwingProgressSuperiors() {
        return this.overrideRenderSwingProgressSuperiors;
    }

    public String[] getOverrideRenderSwingProgressInferiors() {
        return this.overrideRenderSwingProgressInferiors;
    }

    public String[] getAfterRenderSwingProgressSuperiors() {
        return this.afterRenderSwingProgressSuperiors;
    }

    public String[] getAfterRenderSwingProgressInferiors() {
        return this.afterRenderSwingProgressInferiors;
    }

    public void setBeforeRenderSwingProgressSuperiors(String[] stringArray) {
        this.beforeRenderSwingProgressSuperiors = stringArray;
    }

    public void setBeforeRenderSwingProgressInferiors(String[] stringArray) {
        this.beforeRenderSwingProgressInferiors = stringArray;
    }

    public void setOverrideRenderSwingProgressSuperiors(String[] stringArray) {
        this.overrideRenderSwingProgressSuperiors = stringArray;
    }

    public void setOverrideRenderSwingProgressInferiors(String[] stringArray) {
        this.overrideRenderSwingProgressInferiors = stringArray;
    }

    public void setAfterRenderSwingProgressSuperiors(String[] stringArray) {
        this.afterRenderSwingProgressSuperiors = stringArray;
    }

    public void setAfterRenderSwingProgressInferiors(String[] stringArray) {
        this.afterRenderSwingProgressInferiors = stringArray;
    }

    public String[] getBeforeRotatePlayerSuperiors() {
        return this.beforeRotatePlayerSuperiors;
    }

    public String[] getBeforeRotatePlayerInferiors() {
        return this.beforeRotatePlayerInferiors;
    }

    public String[] getOverrideRotatePlayerSuperiors() {
        return this.overrideRotatePlayerSuperiors;
    }

    public String[] getOverrideRotatePlayerInferiors() {
        return this.overrideRotatePlayerInferiors;
    }

    public String[] getAfterRotatePlayerSuperiors() {
        return this.afterRotatePlayerSuperiors;
    }

    public String[] getAfterRotatePlayerInferiors() {
        return this.afterRotatePlayerInferiors;
    }

    public void setBeforeRotatePlayerSuperiors(String[] stringArray) {
        this.beforeRotatePlayerSuperiors = stringArray;
    }

    public void setBeforeRotatePlayerInferiors(String[] stringArray) {
        this.beforeRotatePlayerInferiors = stringArray;
    }

    public void setOverrideRotatePlayerSuperiors(String[] stringArray) {
        this.overrideRotatePlayerSuperiors = stringArray;
    }

    public void setOverrideRotatePlayerInferiors(String[] stringArray) {
        this.overrideRotatePlayerInferiors = stringArray;
    }

    public void setAfterRotatePlayerSuperiors(String[] stringArray) {
        this.afterRotatePlayerSuperiors = stringArray;
    }

    public void setAfterRotatePlayerInferiors(String[] stringArray) {
        this.afterRotatePlayerInferiors = stringArray;
    }

    public String[] getBeforeSetArmorModelSuperiors() {
        return this.beforeSetArmorModelSuperiors;
    }

    public String[] getBeforeSetArmorModelInferiors() {
        return this.beforeSetArmorModelInferiors;
    }

    public String[] getOverrideSetArmorModelSuperiors() {
        return this.overrideSetArmorModelSuperiors;
    }

    public String[] getOverrideSetArmorModelInferiors() {
        return this.overrideSetArmorModelInferiors;
    }

    public String[] getAfterSetArmorModelSuperiors() {
        return this.afterSetArmorModelSuperiors;
    }

    public String[] getAfterSetArmorModelInferiors() {
        return this.afterSetArmorModelInferiors;
    }

    public void setBeforeSetArmorModelSuperiors(String[] stringArray) {
        this.beforeSetArmorModelSuperiors = stringArray;
    }

    public void setBeforeSetArmorModelInferiors(String[] stringArray) {
        this.beforeSetArmorModelInferiors = stringArray;
    }

    public void setOverrideSetArmorModelSuperiors(String[] stringArray) {
        this.overrideSetArmorModelSuperiors = stringArray;
    }

    public void setOverrideSetArmorModelInferiors(String[] stringArray) {
        this.overrideSetArmorModelInferiors = stringArray;
    }

    public void setAfterSetArmorModelSuperiors(String[] stringArray) {
        this.afterSetArmorModelSuperiors = stringArray;
    }

    public void setAfterSetArmorModelInferiors(String[] stringArray) {
        this.afterSetArmorModelInferiors = stringArray;
    }

    public String[] getBeforeSetPassArmorModelSuperiors() {
        return this.beforeSetPassArmorModelSuperiors;
    }

    public String[] getBeforeSetPassArmorModelInferiors() {
        return this.beforeSetPassArmorModelInferiors;
    }

    public String[] getOverrideSetPassArmorModelSuperiors() {
        return this.overrideSetPassArmorModelSuperiors;
    }

    public String[] getOverrideSetPassArmorModelInferiors() {
        return this.overrideSetPassArmorModelInferiors;
    }

    public String[] getAfterSetPassArmorModelSuperiors() {
        return this.afterSetPassArmorModelSuperiors;
    }

    public String[] getAfterSetPassArmorModelInferiors() {
        return this.afterSetPassArmorModelInferiors;
    }

    public void setBeforeSetPassArmorModelSuperiors(String[] stringArray) {
        this.beforeSetPassArmorModelSuperiors = stringArray;
    }

    public void setBeforeSetPassArmorModelInferiors(String[] stringArray) {
        this.beforeSetPassArmorModelInferiors = stringArray;
    }

    public void setOverrideSetPassArmorModelSuperiors(String[] stringArray) {
        this.overrideSetPassArmorModelSuperiors = stringArray;
    }

    public void setOverrideSetPassArmorModelInferiors(String[] stringArray) {
        this.overrideSetPassArmorModelInferiors = stringArray;
    }

    public void setAfterSetPassArmorModelSuperiors(String[] stringArray) {
        this.afterSetPassArmorModelSuperiors = stringArray;
    }

    public void setAfterSetPassArmorModelInferiors(String[] stringArray) {
        this.afterSetPassArmorModelInferiors = stringArray;
    }

    public String[] getBeforeSetRenderManagerSuperiors() {
        return this.beforeSetRenderManagerSuperiors;
    }

    public String[] getBeforeSetRenderManagerInferiors() {
        return this.beforeSetRenderManagerInferiors;
    }

    public String[] getOverrideSetRenderManagerSuperiors() {
        return this.overrideSetRenderManagerSuperiors;
    }

    public String[] getOverrideSetRenderManagerInferiors() {
        return this.overrideSetRenderManagerInferiors;
    }

    public String[] getAfterSetRenderManagerSuperiors() {
        return this.afterSetRenderManagerSuperiors;
    }

    public String[] getAfterSetRenderManagerInferiors() {
        return this.afterSetRenderManagerInferiors;
    }

    public void setBeforeSetRenderManagerSuperiors(String[] stringArray) {
        this.beforeSetRenderManagerSuperiors = stringArray;
    }

    public void setBeforeSetRenderManagerInferiors(String[] stringArray) {
        this.beforeSetRenderManagerInferiors = stringArray;
    }

    public void setOverrideSetRenderManagerSuperiors(String[] stringArray) {
        this.overrideSetRenderManagerSuperiors = stringArray;
    }

    public void setOverrideSetRenderManagerInferiors(String[] stringArray) {
        this.overrideSetRenderManagerInferiors = stringArray;
    }

    public void setAfterSetRenderManagerSuperiors(String[] stringArray) {
        this.afterSetRenderManagerSuperiors = stringArray;
    }

    public void setAfterSetRenderManagerInferiors(String[] stringArray) {
        this.afterSetRenderManagerInferiors = stringArray;
    }

    public String[] getBeforeSetRenderPassModelSuperiors() {
        return this.beforeSetRenderPassModelSuperiors;
    }

    public String[] getBeforeSetRenderPassModelInferiors() {
        return this.beforeSetRenderPassModelInferiors;
    }

    public String[] getOverrideSetRenderPassModelSuperiors() {
        return this.overrideSetRenderPassModelSuperiors;
    }

    public String[] getOverrideSetRenderPassModelInferiors() {
        return this.overrideSetRenderPassModelInferiors;
    }

    public String[] getAfterSetRenderPassModelSuperiors() {
        return this.afterSetRenderPassModelSuperiors;
    }

    public String[] getAfterSetRenderPassModelInferiors() {
        return this.afterSetRenderPassModelInferiors;
    }

    public void setBeforeSetRenderPassModelSuperiors(String[] stringArray) {
        this.beforeSetRenderPassModelSuperiors = stringArray;
    }

    public void setBeforeSetRenderPassModelInferiors(String[] stringArray) {
        this.beforeSetRenderPassModelInferiors = stringArray;
    }

    public void setOverrideSetRenderPassModelSuperiors(String[] stringArray) {
        this.overrideSetRenderPassModelSuperiors = stringArray;
    }

    public void setOverrideSetRenderPassModelInferiors(String[] stringArray) {
        this.overrideSetRenderPassModelInferiors = stringArray;
    }

    public void setAfterSetRenderPassModelSuperiors(String[] stringArray) {
        this.afterSetRenderPassModelSuperiors = stringArray;
    }

    public void setAfterSetRenderPassModelInferiors(String[] stringArray) {
        this.afterSetRenderPassModelInferiors = stringArray;
    }

    public String[] getBeforeUpdateIconsSuperiors() {
        return this.beforeUpdateIconsSuperiors;
    }

    public String[] getBeforeUpdateIconsInferiors() {
        return this.beforeUpdateIconsInferiors;
    }

    public String[] getOverrideUpdateIconsSuperiors() {
        return this.overrideUpdateIconsSuperiors;
    }

    public String[] getOverrideUpdateIconsInferiors() {
        return this.overrideUpdateIconsInferiors;
    }

    public String[] getAfterUpdateIconsSuperiors() {
        return this.afterUpdateIconsSuperiors;
    }

    public String[] getAfterUpdateIconsInferiors() {
        return this.afterUpdateIconsInferiors;
    }

    public void setBeforeUpdateIconsSuperiors(String[] stringArray) {
        this.beforeUpdateIconsSuperiors = stringArray;
    }

    public void setBeforeUpdateIconsInferiors(String[] stringArray) {
        this.beforeUpdateIconsInferiors = stringArray;
    }

    public void setOverrideUpdateIconsSuperiors(String[] stringArray) {
        this.overrideUpdateIconsSuperiors = stringArray;
    }

    public void setOverrideUpdateIconsInferiors(String[] stringArray) {
        this.overrideUpdateIconsInferiors = stringArray;
    }

    public void setAfterUpdateIconsSuperiors(String[] stringArray) {
        this.afterUpdateIconsSuperiors = stringArray;
    }

    public void setAfterUpdateIconsInferiors(String[] stringArray) {
        this.afterUpdateIconsInferiors = stringArray;
    }

    public String[] getBeforeRenderSpecialHeadArmorSuperiors() {
        return this.beforeRenderSpecialHeadArmorSuperiors;
    }

    public String[] getBeforeRenderSpecialHeadArmorInferiors() {
        return this.beforeRenderSpecialHeadArmorInferiors;
    }

    public String[] getOverrideRenderSpecialHeadArmorSuperiors() {
        return this.overrideRenderSpecialHeadArmorSuperiors;
    }

    public String[] getOverrideRenderSpecialHeadArmorInferiors() {
        return this.overrideRenderSpecialHeadArmorInferiors;
    }

    public String[] getAfterRenderSpecialHeadArmorSuperiors() {
        return this.afterRenderSpecialHeadArmorSuperiors;
    }

    public String[] getAfterRenderSpecialHeadArmorInferiors() {
        return this.afterRenderSpecialHeadArmorInferiors;
    }

    public void setBeforeRenderSpecialHeadArmorSuperiors(String[] stringArray) {
        this.beforeRenderSpecialHeadArmorSuperiors = stringArray;
    }

    public void setBeforeRenderSpecialHeadArmorInferiors(String[] stringArray) {
        this.beforeRenderSpecialHeadArmorInferiors = stringArray;
    }

    public void setOverrideRenderSpecialHeadArmorSuperiors(String[] stringArray) {
        this.overrideRenderSpecialHeadArmorSuperiors = stringArray;
    }

    public void setOverrideRenderSpecialHeadArmorInferiors(String[] stringArray) {
        this.overrideRenderSpecialHeadArmorInferiors = stringArray;
    }

    public void setAfterRenderSpecialHeadArmorSuperiors(String[] stringArray) {
        this.afterRenderSpecialHeadArmorSuperiors = stringArray;
    }

    public void setAfterRenderSpecialHeadArmorInferiors(String[] stringArray) {
        this.afterRenderSpecialHeadArmorInferiors = stringArray;
    }

    public String[] getBeforeRenderSpecialHeadEarsSuperiors() {
        return this.beforeRenderSpecialHeadEarsSuperiors;
    }

    public String[] getBeforeRenderSpecialHeadEarsInferiors() {
        return this.beforeRenderSpecialHeadEarsInferiors;
    }

    public String[] getOverrideRenderSpecialHeadEarsSuperiors() {
        return this.overrideRenderSpecialHeadEarsSuperiors;
    }

    public String[] getOverrideRenderSpecialHeadEarsInferiors() {
        return this.overrideRenderSpecialHeadEarsInferiors;
    }

    public String[] getAfterRenderSpecialHeadEarsSuperiors() {
        return this.afterRenderSpecialHeadEarsSuperiors;
    }

    public String[] getAfterRenderSpecialHeadEarsInferiors() {
        return this.afterRenderSpecialHeadEarsInferiors;
    }

    public void setBeforeRenderSpecialHeadEarsSuperiors(String[] stringArray) {
        this.beforeRenderSpecialHeadEarsSuperiors = stringArray;
    }

    public void setBeforeRenderSpecialHeadEarsInferiors(String[] stringArray) {
        this.beforeRenderSpecialHeadEarsInferiors = stringArray;
    }

    public void setOverrideRenderSpecialHeadEarsSuperiors(String[] stringArray) {
        this.overrideRenderSpecialHeadEarsSuperiors = stringArray;
    }

    public void setOverrideRenderSpecialHeadEarsInferiors(String[] stringArray) {
        this.overrideRenderSpecialHeadEarsInferiors = stringArray;
    }

    public void setAfterRenderSpecialHeadEarsSuperiors(String[] stringArray) {
        this.afterRenderSpecialHeadEarsSuperiors = stringArray;
    }

    public void setAfterRenderSpecialHeadEarsInferiors(String[] stringArray) {
        this.afterRenderSpecialHeadEarsInferiors = stringArray;
    }

    public String[] getBeforeRenderSpecialCloakSuperiors() {
        return this.beforeRenderSpecialCloakSuperiors;
    }

    public String[] getBeforeRenderSpecialCloakInferiors() {
        return this.beforeRenderSpecialCloakInferiors;
    }

    public String[] getOverrideRenderSpecialCloakSuperiors() {
        return this.overrideRenderSpecialCloakSuperiors;
    }

    public String[] getOverrideRenderSpecialCloakInferiors() {
        return this.overrideRenderSpecialCloakInferiors;
    }

    public String[] getAfterRenderSpecialCloakSuperiors() {
        return this.afterRenderSpecialCloakSuperiors;
    }

    public String[] getAfterRenderSpecialCloakInferiors() {
        return this.afterRenderSpecialCloakInferiors;
    }

    public void setBeforeRenderSpecialCloakSuperiors(String[] stringArray) {
        this.beforeRenderSpecialCloakSuperiors = stringArray;
    }

    public void setBeforeRenderSpecialCloakInferiors(String[] stringArray) {
        this.beforeRenderSpecialCloakInferiors = stringArray;
    }

    public void setOverrideRenderSpecialCloakSuperiors(String[] stringArray) {
        this.overrideRenderSpecialCloakSuperiors = stringArray;
    }

    public void setOverrideRenderSpecialCloakInferiors(String[] stringArray) {
        this.overrideRenderSpecialCloakInferiors = stringArray;
    }

    public void setAfterRenderSpecialCloakSuperiors(String[] stringArray) {
        this.afterRenderSpecialCloakSuperiors = stringArray;
    }

    public void setAfterRenderSpecialCloakInferiors(String[] stringArray) {
        this.afterRenderSpecialCloakInferiors = stringArray;
    }

    public String[] getBeforeRenderSpecialItemInHandSuperiors() {
        return this.beforeRenderSpecialItemInHandSuperiors;
    }

    public String[] getBeforeRenderSpecialItemInHandInferiors() {
        return this.beforeRenderSpecialItemInHandInferiors;
    }

    public String[] getOverrideRenderSpecialItemInHandSuperiors() {
        return this.overrideRenderSpecialItemInHandSuperiors;
    }

    public String[] getOverrideRenderSpecialItemInHandInferiors() {
        return this.overrideRenderSpecialItemInHandInferiors;
    }

    public String[] getAfterRenderSpecialItemInHandSuperiors() {
        return this.afterRenderSpecialItemInHandSuperiors;
    }

    public String[] getAfterRenderSpecialItemInHandInferiors() {
        return this.afterRenderSpecialItemInHandInferiors;
    }

    public void setBeforeRenderSpecialItemInHandSuperiors(String[] stringArray) {
        this.beforeRenderSpecialItemInHandSuperiors = stringArray;
    }

    public void setBeforeRenderSpecialItemInHandInferiors(String[] stringArray) {
        this.beforeRenderSpecialItemInHandInferiors = stringArray;
    }

    public void setOverrideRenderSpecialItemInHandSuperiors(String[] stringArray) {
        this.overrideRenderSpecialItemInHandSuperiors = stringArray;
    }

    public void setOverrideRenderSpecialItemInHandInferiors(String[] stringArray) {
        this.overrideRenderSpecialItemInHandInferiors = stringArray;
    }

    public void setAfterRenderSpecialItemInHandSuperiors(String[] stringArray) {
        this.afterRenderSpecialItemInHandSuperiors = stringArray;
    }

    public void setAfterRenderSpecialItemInHandInferiors(String[] stringArray) {
        this.afterRenderSpecialItemInHandInferiors = stringArray;
    }

    public String[] getBeforePositionSpecialItemInHandSuperiors() {
        return this.beforePositionSpecialItemInHandSuperiors;
    }

    public String[] getBeforePositionSpecialItemInHandInferiors() {
        return this.beforePositionSpecialItemInHandInferiors;
    }

    public String[] getOverridePositionSpecialItemInHandSuperiors() {
        return this.overridePositionSpecialItemInHandSuperiors;
    }

    public String[] getOverridePositionSpecialItemInHandInferiors() {
        return this.overridePositionSpecialItemInHandInferiors;
    }

    public String[] getAfterPositionSpecialItemInHandSuperiors() {
        return this.afterPositionSpecialItemInHandSuperiors;
    }

    public String[] getAfterPositionSpecialItemInHandInferiors() {
        return this.afterPositionSpecialItemInHandInferiors;
    }

    public void setBeforePositionSpecialItemInHandSuperiors(String[] stringArray) {
        this.beforePositionSpecialItemInHandSuperiors = stringArray;
    }

    public void setBeforePositionSpecialItemInHandInferiors(String[] stringArray) {
        this.beforePositionSpecialItemInHandInferiors = stringArray;
    }

    public void setOverridePositionSpecialItemInHandSuperiors(String[] stringArray) {
        this.overridePositionSpecialItemInHandSuperiors = stringArray;
    }

    public void setOverridePositionSpecialItemInHandInferiors(String[] stringArray) {
        this.overridePositionSpecialItemInHandInferiors = stringArray;
    }

    public void setAfterPositionSpecialItemInHandSuperiors(String[] stringArray) {
        this.afterPositionSpecialItemInHandSuperiors = stringArray;
    }

    public void setAfterPositionSpecialItemInHandInferiors(String[] stringArray) {
        this.afterPositionSpecialItemInHandInferiors = stringArray;
    }
}

