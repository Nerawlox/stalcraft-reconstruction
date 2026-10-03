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

    public void setBeforeLocalConstructingSuperiors(String[] var1) {
        this.beforeLocalConstructingSuperiors = var1;
    }

    public void setBeforeLocalConstructingInferiors(String[] var1) {
        this.beforeLocalConstructingInferiors = var1;
    }

    public void setAfterLocalConstructingSuperiors(String[] var1) {
        this.afterLocalConstructingSuperiors = var1;
    }

    public void setAfterLocalConstructingInferiors(String[] var1) {
        this.afterLocalConstructingInferiors = var1;
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

    public void setDynamicBeforeSuperiors(String var1, String[] var2) {
        this.dynamicBeforeSuperiors = this.setDynamic(var1, var2, this.dynamicBeforeSuperiors);
    }

    public void setDynamicBeforeInferiors(String var1, String[] var2) {
        this.dynamicBeforeInferiors = this.setDynamic(var1, var2, this.dynamicBeforeInferiors);
    }

    public void setDynamicOverrideSuperiors(String var1, String[] var2) {
        this.dynamicOverrideSuperiors = this.setDynamic(var1, var2, this.dynamicOverrideSuperiors);
    }

    public void setDynamicOverrideInferiors(String var1, String[] var2) {
        this.dynamicOverrideInferiors = this.setDynamic(var1, var2, this.dynamicOverrideInferiors);
    }

    public void setDynamicAfterSuperiors(String var1, String[] var2) {
        this.dynamicAfterSuperiors = this.setDynamic(var1, var2, this.dynamicAfterSuperiors);
    }

    public void setDynamicAfterInferiors(String var1, String[] var2) {
        this.dynamicAfterInferiors = this.setDynamic(var1, var2, this.dynamicAfterInferiors);
    }

    private Map<String, String[]> setDynamic(String var1, String[] var2, Map<String, String[]> var3) {
        if (var1 == null) {
            throw new IllegalArgumentException("Parameter 'name' may not be null");
        }
        if (var2 == null) {
            if (var3 != null) {
                var3.remove(var1);
            }
            return var3;
        }
        if (var3 == null) {
            var3 = new HashMap<String, String[]>();
        }
        var3.put(var1, var2);
        return var3;
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

    public void setBeforeDoRenderLabelSuperiors(String[] var1) {
        this.beforeDoRenderLabelSuperiors = var1;
    }

    public void setBeforeDoRenderLabelInferiors(String[] var1) {
        this.beforeDoRenderLabelInferiors = var1;
    }

    public void setOverrideDoRenderLabelSuperiors(String[] var1) {
        this.overrideDoRenderLabelSuperiors = var1;
    }

    public void setOverrideDoRenderLabelInferiors(String[] var1) {
        this.overrideDoRenderLabelInferiors = var1;
    }

    public void setAfterDoRenderLabelSuperiors(String[] var1) {
        this.afterDoRenderLabelSuperiors = var1;
    }

    public void setAfterDoRenderLabelInferiors(String[] var1) {
        this.afterDoRenderLabelInferiors = var1;
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

    public void setBeforeDoRenderShadowAndFireSuperiors(String[] var1) {
        this.beforeDoRenderShadowAndFireSuperiors = var1;
    }

    public void setBeforeDoRenderShadowAndFireInferiors(String[] var1) {
        this.beforeDoRenderShadowAndFireInferiors = var1;
    }

    public void setOverrideDoRenderShadowAndFireSuperiors(String[] var1) {
        this.overrideDoRenderShadowAndFireSuperiors = var1;
    }

    public void setOverrideDoRenderShadowAndFireInferiors(String[] var1) {
        this.overrideDoRenderShadowAndFireInferiors = var1;
    }

    public void setAfterDoRenderShadowAndFireSuperiors(String[] var1) {
        this.afterDoRenderShadowAndFireSuperiors = var1;
    }

    public void setAfterDoRenderShadowAndFireInferiors(String[] var1) {
        this.afterDoRenderShadowAndFireInferiors = var1;
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

    public void setBeforeGetColorMultiplierSuperiors(String[] var1) {
        this.beforeGetColorMultiplierSuperiors = var1;
    }

    public void setBeforeGetColorMultiplierInferiors(String[] var1) {
        this.beforeGetColorMultiplierInferiors = var1;
    }

    public void setOverrideGetColorMultiplierSuperiors(String[] var1) {
        this.overrideGetColorMultiplierSuperiors = var1;
    }

    public void setOverrideGetColorMultiplierInferiors(String[] var1) {
        this.overrideGetColorMultiplierInferiors = var1;
    }

    public void setAfterGetColorMultiplierSuperiors(String[] var1) {
        this.afterGetColorMultiplierSuperiors = var1;
    }

    public void setAfterGetColorMultiplierInferiors(String[] var1) {
        this.afterGetColorMultiplierInferiors = var1;
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

    public void setBeforeGetDeathMaxRotationSuperiors(String[] var1) {
        this.beforeGetDeathMaxRotationSuperiors = var1;
    }

    public void setBeforeGetDeathMaxRotationInferiors(String[] var1) {
        this.beforeGetDeathMaxRotationInferiors = var1;
    }

    public void setOverrideGetDeathMaxRotationSuperiors(String[] var1) {
        this.overrideGetDeathMaxRotationSuperiors = var1;
    }

    public void setOverrideGetDeathMaxRotationInferiors(String[] var1) {
        this.overrideGetDeathMaxRotationInferiors = var1;
    }

    public void setAfterGetDeathMaxRotationSuperiors(String[] var1) {
        this.afterGetDeathMaxRotationSuperiors = var1;
    }

    public void setAfterGetDeathMaxRotationInferiors(String[] var1) {
        this.afterGetDeathMaxRotationInferiors = var1;
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

    public void setBeforeGetFontRendererFromRenderManagerSuperiors(String[] var1) {
        this.beforeGetFontRendererFromRenderManagerSuperiors = var1;
    }

    public void setBeforeGetFontRendererFromRenderManagerInferiors(String[] var1) {
        this.beforeGetFontRendererFromRenderManagerInferiors = var1;
    }

    public void setOverrideGetFontRendererFromRenderManagerSuperiors(String[] var1) {
        this.overrideGetFontRendererFromRenderManagerSuperiors = var1;
    }

    public void setOverrideGetFontRendererFromRenderManagerInferiors(String[] var1) {
        this.overrideGetFontRendererFromRenderManagerInferiors = var1;
    }

    public void setAfterGetFontRendererFromRenderManagerSuperiors(String[] var1) {
        this.afterGetFontRendererFromRenderManagerSuperiors = var1;
    }

    public void setAfterGetFontRendererFromRenderManagerInferiors(String[] var1) {
        this.afterGetFontRendererFromRenderManagerInferiors = var1;
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

    public void setBeforeGetResourceLocationFromPlayerSuperiors(String[] var1) {
        this.beforeGetResourceLocationFromPlayerSuperiors = var1;
    }

    public void setBeforeGetResourceLocationFromPlayerInferiors(String[] var1) {
        this.beforeGetResourceLocationFromPlayerInferiors = var1;
    }

    public void setOverrideGetResourceLocationFromPlayerSuperiors(String[] var1) {
        this.overrideGetResourceLocationFromPlayerSuperiors = var1;
    }

    public void setOverrideGetResourceLocationFromPlayerInferiors(String[] var1) {
        this.overrideGetResourceLocationFromPlayerInferiors = var1;
    }

    public void setAfterGetResourceLocationFromPlayerSuperiors(String[] var1) {
        this.afterGetResourceLocationFromPlayerSuperiors = var1;
    }

    public void setAfterGetResourceLocationFromPlayerInferiors(String[] var1) {
        this.afterGetResourceLocationFromPlayerInferiors = var1;
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

    public void setBeforeHandleRotationFloatSuperiors(String[] var1) {
        this.beforeHandleRotationFloatSuperiors = var1;
    }

    public void setBeforeHandleRotationFloatInferiors(String[] var1) {
        this.beforeHandleRotationFloatInferiors = var1;
    }

    public void setOverrideHandleRotationFloatSuperiors(String[] var1) {
        this.overrideHandleRotationFloatSuperiors = var1;
    }

    public void setOverrideHandleRotationFloatInferiors(String[] var1) {
        this.overrideHandleRotationFloatInferiors = var1;
    }

    public void setAfterHandleRotationFloatSuperiors(String[] var1) {
        this.afterHandleRotationFloatSuperiors = var1;
    }

    public void setAfterHandleRotationFloatInferiors(String[] var1) {
        this.afterHandleRotationFloatInferiors = var1;
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

    public void setBeforeInheritRenderPassSuperiors(String[] var1) {
        this.beforeInheritRenderPassSuperiors = var1;
    }

    public void setBeforeInheritRenderPassInferiors(String[] var1) {
        this.beforeInheritRenderPassInferiors = var1;
    }

    public void setOverrideInheritRenderPassSuperiors(String[] var1) {
        this.overrideInheritRenderPassSuperiors = var1;
    }

    public void setOverrideInheritRenderPassInferiors(String[] var1) {
        this.overrideInheritRenderPassInferiors = var1;
    }

    public void setAfterInheritRenderPassSuperiors(String[] var1) {
        this.afterInheritRenderPassSuperiors = var1;
    }

    public void setAfterInheritRenderPassInferiors(String[] var1) {
        this.afterInheritRenderPassInferiors = var1;
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

    public void setBeforeLoadTextureSuperiors(String[] var1) {
        this.beforeLoadTextureSuperiors = var1;
    }

    public void setBeforeLoadTextureInferiors(String[] var1) {
        this.beforeLoadTextureInferiors = var1;
    }

    public void setOverrideLoadTextureSuperiors(String[] var1) {
        this.overrideLoadTextureSuperiors = var1;
    }

    public void setOverrideLoadTextureInferiors(String[] var1) {
        this.overrideLoadTextureInferiors = var1;
    }

    public void setAfterLoadTextureSuperiors(String[] var1) {
        this.afterLoadTextureSuperiors = var1;
    }

    public void setAfterLoadTextureInferiors(String[] var1) {
        this.afterLoadTextureInferiors = var1;
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

    public void setBeforeLoadTextureOfEntitySuperiors(String[] var1) {
        this.beforeLoadTextureOfEntitySuperiors = var1;
    }

    public void setBeforeLoadTextureOfEntityInferiors(String[] var1) {
        this.beforeLoadTextureOfEntityInferiors = var1;
    }

    public void setOverrideLoadTextureOfEntitySuperiors(String[] var1) {
        this.overrideLoadTextureOfEntitySuperiors = var1;
    }

    public void setOverrideLoadTextureOfEntityInferiors(String[] var1) {
        this.overrideLoadTextureOfEntityInferiors = var1;
    }

    public void setAfterLoadTextureOfEntitySuperiors(String[] var1) {
        this.afterLoadTextureOfEntitySuperiors = var1;
    }

    public void setAfterLoadTextureOfEntityInferiors(String[] var1) {
        this.afterLoadTextureOfEntityInferiors = var1;
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

    public void setBeforePassSpecialRenderSuperiors(String[] var1) {
        this.beforePassSpecialRenderSuperiors = var1;
    }

    public void setBeforePassSpecialRenderInferiors(String[] var1) {
        this.beforePassSpecialRenderInferiors = var1;
    }

    public void setOverridePassSpecialRenderSuperiors(String[] var1) {
        this.overridePassSpecialRenderSuperiors = var1;
    }

    public void setOverridePassSpecialRenderInferiors(String[] var1) {
        this.overridePassSpecialRenderInferiors = var1;
    }

    public void setAfterPassSpecialRenderSuperiors(String[] var1) {
        this.afterPassSpecialRenderSuperiors = var1;
    }

    public void setAfterPassSpecialRenderInferiors(String[] var1) {
        this.afterPassSpecialRenderInferiors = var1;
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

    public void setBeforeRenderArrowsStuckInEntitySuperiors(String[] var1) {
        this.beforeRenderArrowsStuckInEntitySuperiors = var1;
    }

    public void setBeforeRenderArrowsStuckInEntityInferiors(String[] var1) {
        this.beforeRenderArrowsStuckInEntityInferiors = var1;
    }

    public void setOverrideRenderArrowsStuckInEntitySuperiors(String[] var1) {
        this.overrideRenderArrowsStuckInEntitySuperiors = var1;
    }

    public void setOverrideRenderArrowsStuckInEntityInferiors(String[] var1) {
        this.overrideRenderArrowsStuckInEntityInferiors = var1;
    }

    public void setAfterRenderArrowsStuckInEntitySuperiors(String[] var1) {
        this.afterRenderArrowsStuckInEntitySuperiors = var1;
    }

    public void setAfterRenderArrowsStuckInEntityInferiors(String[] var1) {
        this.afterRenderArrowsStuckInEntityInferiors = var1;
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

    public void setBeforeRenderFirstPersonArmSuperiors(String[] var1) {
        this.beforeRenderFirstPersonArmSuperiors = var1;
    }

    public void setBeforeRenderFirstPersonArmInferiors(String[] var1) {
        this.beforeRenderFirstPersonArmInferiors = var1;
    }

    public void setOverrideRenderFirstPersonArmSuperiors(String[] var1) {
        this.overrideRenderFirstPersonArmSuperiors = var1;
    }

    public void setOverrideRenderFirstPersonArmInferiors(String[] var1) {
        this.overrideRenderFirstPersonArmInferiors = var1;
    }

    public void setAfterRenderFirstPersonArmSuperiors(String[] var1) {
        this.afterRenderFirstPersonArmSuperiors = var1;
    }

    public void setAfterRenderFirstPersonArmInferiors(String[] var1) {
        this.afterRenderFirstPersonArmInferiors = var1;
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

    public void setBeforeRenderLivingLabelSuperiors(String[] var1) {
        this.beforeRenderLivingLabelSuperiors = var1;
    }

    public void setBeforeRenderLivingLabelInferiors(String[] var1) {
        this.beforeRenderLivingLabelInferiors = var1;
    }

    public void setOverrideRenderLivingLabelSuperiors(String[] var1) {
        this.overrideRenderLivingLabelSuperiors = var1;
    }

    public void setOverrideRenderLivingLabelInferiors(String[] var1) {
        this.overrideRenderLivingLabelInferiors = var1;
    }

    public void setAfterRenderLivingLabelSuperiors(String[] var1) {
        this.afterRenderLivingLabelSuperiors = var1;
    }

    public void setAfterRenderLivingLabelInferiors(String[] var1) {
        this.afterRenderLivingLabelInferiors = var1;
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

    public void setBeforeRenderModelSuperiors(String[] var1) {
        this.beforeRenderModelSuperiors = var1;
    }

    public void setBeforeRenderModelInferiors(String[] var1) {
        this.beforeRenderModelInferiors = var1;
    }

    public void setOverrideRenderModelSuperiors(String[] var1) {
        this.overrideRenderModelSuperiors = var1;
    }

    public void setOverrideRenderModelInferiors(String[] var1) {
        this.overrideRenderModelInferiors = var1;
    }

    public void setAfterRenderModelSuperiors(String[] var1) {
        this.afterRenderModelSuperiors = var1;
    }

    public void setAfterRenderModelInferiors(String[] var1) {
        this.afterRenderModelInferiors = var1;
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

    public void setBeforeRenderPlayerSuperiors(String[] var1) {
        this.beforeRenderPlayerSuperiors = var1;
    }

    public void setBeforeRenderPlayerInferiors(String[] var1) {
        this.beforeRenderPlayerInferiors = var1;
    }

    public void setOverrideRenderPlayerSuperiors(String[] var1) {
        this.overrideRenderPlayerSuperiors = var1;
    }

    public void setOverrideRenderPlayerInferiors(String[] var1) {
        this.overrideRenderPlayerInferiors = var1;
    }

    public void setAfterRenderPlayerSuperiors(String[] var1) {
        this.afterRenderPlayerSuperiors = var1;
    }

    public void setAfterRenderPlayerInferiors(String[] var1) {
        this.afterRenderPlayerInferiors = var1;
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

    public void setBeforeRenderPlayerNameAndScoreLabelSuperiors(String[] var1) {
        this.beforeRenderPlayerNameAndScoreLabelSuperiors = var1;
    }

    public void setBeforeRenderPlayerNameAndScoreLabelInferiors(String[] var1) {
        this.beforeRenderPlayerNameAndScoreLabelInferiors = var1;
    }

    public void setOverrideRenderPlayerNameAndScoreLabelSuperiors(String[] var1) {
        this.overrideRenderPlayerNameAndScoreLabelSuperiors = var1;
    }

    public void setOverrideRenderPlayerNameAndScoreLabelInferiors(String[] var1) {
        this.overrideRenderPlayerNameAndScoreLabelInferiors = var1;
    }

    public void setAfterRenderPlayerNameAndScoreLabelSuperiors(String[] var1) {
        this.afterRenderPlayerNameAndScoreLabelSuperiors = var1;
    }

    public void setAfterRenderPlayerNameAndScoreLabelInferiors(String[] var1) {
        this.afterRenderPlayerNameAndScoreLabelInferiors = var1;
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

    public void setBeforeRenderPlayerScaleSuperiors(String[] var1) {
        this.beforeRenderPlayerScaleSuperiors = var1;
    }

    public void setBeforeRenderPlayerScaleInferiors(String[] var1) {
        this.beforeRenderPlayerScaleInferiors = var1;
    }

    public void setOverrideRenderPlayerScaleSuperiors(String[] var1) {
        this.overrideRenderPlayerScaleSuperiors = var1;
    }

    public void setOverrideRenderPlayerScaleInferiors(String[] var1) {
        this.overrideRenderPlayerScaleInferiors = var1;
    }

    public void setAfterRenderPlayerScaleSuperiors(String[] var1) {
        this.afterRenderPlayerScaleSuperiors = var1;
    }

    public void setAfterRenderPlayerScaleInferiors(String[] var1) {
        this.afterRenderPlayerScaleInferiors = var1;
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

    public void setBeforeRenderPlayerSleepSuperiors(String[] var1) {
        this.beforeRenderPlayerSleepSuperiors = var1;
    }

    public void setBeforeRenderPlayerSleepInferiors(String[] var1) {
        this.beforeRenderPlayerSleepInferiors = var1;
    }

    public void setOverrideRenderPlayerSleepSuperiors(String[] var1) {
        this.overrideRenderPlayerSleepSuperiors = var1;
    }

    public void setOverrideRenderPlayerSleepInferiors(String[] var1) {
        this.overrideRenderPlayerSleepInferiors = var1;
    }

    public void setAfterRenderPlayerSleepSuperiors(String[] var1) {
        this.afterRenderPlayerSleepSuperiors = var1;
    }

    public void setAfterRenderPlayerSleepInferiors(String[] var1) {
        this.afterRenderPlayerSleepInferiors = var1;
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

    public void setBeforeRenderSpecialsSuperiors(String[] var1) {
        this.beforeRenderSpecialsSuperiors = var1;
    }

    public void setBeforeRenderSpecialsInferiors(String[] var1) {
        this.beforeRenderSpecialsInferiors = var1;
    }

    public void setOverrideRenderSpecialsSuperiors(String[] var1) {
        this.overrideRenderSpecialsSuperiors = var1;
    }

    public void setOverrideRenderSpecialsInferiors(String[] var1) {
        this.overrideRenderSpecialsInferiors = var1;
    }

    public void setAfterRenderSpecialsSuperiors(String[] var1) {
        this.afterRenderSpecialsSuperiors = var1;
    }

    public void setAfterRenderSpecialsInferiors(String[] var1) {
        this.afterRenderSpecialsInferiors = var1;
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

    public void setBeforeRenderSwingProgressSuperiors(String[] var1) {
        this.beforeRenderSwingProgressSuperiors = var1;
    }

    public void setBeforeRenderSwingProgressInferiors(String[] var1) {
        this.beforeRenderSwingProgressInferiors = var1;
    }

    public void setOverrideRenderSwingProgressSuperiors(String[] var1) {
        this.overrideRenderSwingProgressSuperiors = var1;
    }

    public void setOverrideRenderSwingProgressInferiors(String[] var1) {
        this.overrideRenderSwingProgressInferiors = var1;
    }

    public void setAfterRenderSwingProgressSuperiors(String[] var1) {
        this.afterRenderSwingProgressSuperiors = var1;
    }

    public void setAfterRenderSwingProgressInferiors(String[] var1) {
        this.afterRenderSwingProgressInferiors = var1;
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

    public void setBeforeRotatePlayerSuperiors(String[] var1) {
        this.beforeRotatePlayerSuperiors = var1;
    }

    public void setBeforeRotatePlayerInferiors(String[] var1) {
        this.beforeRotatePlayerInferiors = var1;
    }

    public void setOverrideRotatePlayerSuperiors(String[] var1) {
        this.overrideRotatePlayerSuperiors = var1;
    }

    public void setOverrideRotatePlayerInferiors(String[] var1) {
        this.overrideRotatePlayerInferiors = var1;
    }

    public void setAfterRotatePlayerSuperiors(String[] var1) {
        this.afterRotatePlayerSuperiors = var1;
    }

    public void setAfterRotatePlayerInferiors(String[] var1) {
        this.afterRotatePlayerInferiors = var1;
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

    public void setBeforeSetArmorModelSuperiors(String[] var1) {
        this.beforeSetArmorModelSuperiors = var1;
    }

    public void setBeforeSetArmorModelInferiors(String[] var1) {
        this.beforeSetArmorModelInferiors = var1;
    }

    public void setOverrideSetArmorModelSuperiors(String[] var1) {
        this.overrideSetArmorModelSuperiors = var1;
    }

    public void setOverrideSetArmorModelInferiors(String[] var1) {
        this.overrideSetArmorModelInferiors = var1;
    }

    public void setAfterSetArmorModelSuperiors(String[] var1) {
        this.afterSetArmorModelSuperiors = var1;
    }

    public void setAfterSetArmorModelInferiors(String[] var1) {
        this.afterSetArmorModelInferiors = var1;
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

    public void setBeforeSetPassArmorModelSuperiors(String[] var1) {
        this.beforeSetPassArmorModelSuperiors = var1;
    }

    public void setBeforeSetPassArmorModelInferiors(String[] var1) {
        this.beforeSetPassArmorModelInferiors = var1;
    }

    public void setOverrideSetPassArmorModelSuperiors(String[] var1) {
        this.overrideSetPassArmorModelSuperiors = var1;
    }

    public void setOverrideSetPassArmorModelInferiors(String[] var1) {
        this.overrideSetPassArmorModelInferiors = var1;
    }

    public void setAfterSetPassArmorModelSuperiors(String[] var1) {
        this.afterSetPassArmorModelSuperiors = var1;
    }

    public void setAfterSetPassArmorModelInferiors(String[] var1) {
        this.afterSetPassArmorModelInferiors = var1;
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

    public void setBeforeSetRenderManagerSuperiors(String[] var1) {
        this.beforeSetRenderManagerSuperiors = var1;
    }

    public void setBeforeSetRenderManagerInferiors(String[] var1) {
        this.beforeSetRenderManagerInferiors = var1;
    }

    public void setOverrideSetRenderManagerSuperiors(String[] var1) {
        this.overrideSetRenderManagerSuperiors = var1;
    }

    public void setOverrideSetRenderManagerInferiors(String[] var1) {
        this.overrideSetRenderManagerInferiors = var1;
    }

    public void setAfterSetRenderManagerSuperiors(String[] var1) {
        this.afterSetRenderManagerSuperiors = var1;
    }

    public void setAfterSetRenderManagerInferiors(String[] var1) {
        this.afterSetRenderManagerInferiors = var1;
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

    public void setBeforeSetRenderPassModelSuperiors(String[] var1) {
        this.beforeSetRenderPassModelSuperiors = var1;
    }

    public void setBeforeSetRenderPassModelInferiors(String[] var1) {
        this.beforeSetRenderPassModelInferiors = var1;
    }

    public void setOverrideSetRenderPassModelSuperiors(String[] var1) {
        this.overrideSetRenderPassModelSuperiors = var1;
    }

    public void setOverrideSetRenderPassModelInferiors(String[] var1) {
        this.overrideSetRenderPassModelInferiors = var1;
    }

    public void setAfterSetRenderPassModelSuperiors(String[] var1) {
        this.afterSetRenderPassModelSuperiors = var1;
    }

    public void setAfterSetRenderPassModelInferiors(String[] var1) {
        this.afterSetRenderPassModelInferiors = var1;
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

    public void setBeforeUpdateIconsSuperiors(String[] var1) {
        this.beforeUpdateIconsSuperiors = var1;
    }

    public void setBeforeUpdateIconsInferiors(String[] var1) {
        this.beforeUpdateIconsInferiors = var1;
    }

    public void setOverrideUpdateIconsSuperiors(String[] var1) {
        this.overrideUpdateIconsSuperiors = var1;
    }

    public void setOverrideUpdateIconsInferiors(String[] var1) {
        this.overrideUpdateIconsInferiors = var1;
    }

    public void setAfterUpdateIconsSuperiors(String[] var1) {
        this.afterUpdateIconsSuperiors = var1;
    }

    public void setAfterUpdateIconsInferiors(String[] var1) {
        this.afterUpdateIconsInferiors = var1;
    }
}

