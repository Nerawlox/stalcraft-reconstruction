/*
 * Decompiled with CFR 0.152.
 */
package api.player.model;

import java.util.HashMap;
import java.util.Map;

public final class ModelPlayerBaseSorting {
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
    private String[] beforeGetRandomModelBoxSuperiors = null;
    private String[] beforeGetRandomModelBoxInferiors = null;
    private String[] overrideGetRandomModelBoxSuperiors = null;
    private String[] overrideGetRandomModelBoxInferiors = null;
    private String[] afterGetRandomModelBoxSuperiors = null;
    private String[] afterGetRandomModelBoxInferiors = null;
    private String[] beforeGetTextureOffsetSuperiors = null;
    private String[] beforeGetTextureOffsetInferiors = null;
    private String[] overrideGetTextureOffsetSuperiors = null;
    private String[] overrideGetTextureOffsetInferiors = null;
    private String[] afterGetTextureOffsetSuperiors = null;
    private String[] afterGetTextureOffsetInferiors = null;
    private String[] beforeRenderSuperiors = null;
    private String[] beforeRenderInferiors = null;
    private String[] overrideRenderSuperiors = null;
    private String[] overrideRenderInferiors = null;
    private String[] afterRenderSuperiors = null;
    private String[] afterRenderInferiors = null;
    private String[] beforeRenderCloakSuperiors = null;
    private String[] beforeRenderCloakInferiors = null;
    private String[] overrideRenderCloakSuperiors = null;
    private String[] overrideRenderCloakInferiors = null;
    private String[] afterRenderCloakSuperiors = null;
    private String[] afterRenderCloakInferiors = null;
    private String[] beforeRenderEarsSuperiors = null;
    private String[] beforeRenderEarsInferiors = null;
    private String[] overrideRenderEarsSuperiors = null;
    private String[] overrideRenderEarsInferiors = null;
    private String[] afterRenderEarsSuperiors = null;
    private String[] afterRenderEarsInferiors = null;
    private String[] beforeSetLivingAnimationsSuperiors = null;
    private String[] beforeSetLivingAnimationsInferiors = null;
    private String[] overrideSetLivingAnimationsSuperiors = null;
    private String[] overrideSetLivingAnimationsInferiors = null;
    private String[] afterSetLivingAnimationsSuperiors = null;
    private String[] afterSetLivingAnimationsInferiors = null;
    private String[] beforeSetRotationAnglesSuperiors = null;
    private String[] beforeSetRotationAnglesInferiors = null;
    private String[] overrideSetRotationAnglesSuperiors = null;
    private String[] overrideSetRotationAnglesInferiors = null;
    private String[] afterSetRotationAnglesSuperiors = null;
    private String[] afterSetRotationAnglesInferiors = null;
    private String[] beforeSetTextureOffsetSuperiors = null;
    private String[] beforeSetTextureOffsetInferiors = null;
    private String[] overrideSetTextureOffsetSuperiors = null;
    private String[] overrideSetTextureOffsetInferiors = null;
    private String[] afterSetTextureOffsetSuperiors = null;
    private String[] afterSetTextureOffsetInferiors = null;

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

    public String[] getBeforeGetRandomModelBoxSuperiors() {
        return this.beforeGetRandomModelBoxSuperiors;
    }

    public String[] getBeforeGetRandomModelBoxInferiors() {
        return this.beforeGetRandomModelBoxInferiors;
    }

    public String[] getOverrideGetRandomModelBoxSuperiors() {
        return this.overrideGetRandomModelBoxSuperiors;
    }

    public String[] getOverrideGetRandomModelBoxInferiors() {
        return this.overrideGetRandomModelBoxInferiors;
    }

    public String[] getAfterGetRandomModelBoxSuperiors() {
        return this.afterGetRandomModelBoxSuperiors;
    }

    public String[] getAfterGetRandomModelBoxInferiors() {
        return this.afterGetRandomModelBoxInferiors;
    }

    public void setBeforeGetRandomModelBoxSuperiors(String[] var1) {
        this.beforeGetRandomModelBoxSuperiors = var1;
    }

    public void setBeforeGetRandomModelBoxInferiors(String[] var1) {
        this.beforeGetRandomModelBoxInferiors = var1;
    }

    public void setOverrideGetRandomModelBoxSuperiors(String[] var1) {
        this.overrideGetRandomModelBoxSuperiors = var1;
    }

    public void setOverrideGetRandomModelBoxInferiors(String[] var1) {
        this.overrideGetRandomModelBoxInferiors = var1;
    }

    public void setAfterGetRandomModelBoxSuperiors(String[] var1) {
        this.afterGetRandomModelBoxSuperiors = var1;
    }

    public void setAfterGetRandomModelBoxInferiors(String[] var1) {
        this.afterGetRandomModelBoxInferiors = var1;
    }

    public String[] getBeforeGetTextureOffsetSuperiors() {
        return this.beforeGetTextureOffsetSuperiors;
    }

    public String[] getBeforeGetTextureOffsetInferiors() {
        return this.beforeGetTextureOffsetInferiors;
    }

    public String[] getOverrideGetTextureOffsetSuperiors() {
        return this.overrideGetTextureOffsetSuperiors;
    }

    public String[] getOverrideGetTextureOffsetInferiors() {
        return this.overrideGetTextureOffsetInferiors;
    }

    public String[] getAfterGetTextureOffsetSuperiors() {
        return this.afterGetTextureOffsetSuperiors;
    }

    public String[] getAfterGetTextureOffsetInferiors() {
        return this.afterGetTextureOffsetInferiors;
    }

    public void setBeforeGetTextureOffsetSuperiors(String[] var1) {
        this.beforeGetTextureOffsetSuperiors = var1;
    }

    public void setBeforeGetTextureOffsetInferiors(String[] var1) {
        this.beforeGetTextureOffsetInferiors = var1;
    }

    public void setOverrideGetTextureOffsetSuperiors(String[] var1) {
        this.overrideGetTextureOffsetSuperiors = var1;
    }

    public void setOverrideGetTextureOffsetInferiors(String[] var1) {
        this.overrideGetTextureOffsetInferiors = var1;
    }

    public void setAfterGetTextureOffsetSuperiors(String[] var1) {
        this.afterGetTextureOffsetSuperiors = var1;
    }

    public void setAfterGetTextureOffsetInferiors(String[] var1) {
        this.afterGetTextureOffsetInferiors = var1;
    }

    public String[] getBeforeRenderSuperiors() {
        return this.beforeRenderSuperiors;
    }

    public String[] getBeforeRenderInferiors() {
        return this.beforeRenderInferiors;
    }

    public String[] getOverrideRenderSuperiors() {
        return this.overrideRenderSuperiors;
    }

    public String[] getOverrideRenderInferiors() {
        return this.overrideRenderInferiors;
    }

    public String[] getAfterRenderSuperiors() {
        return this.afterRenderSuperiors;
    }

    public String[] getAfterRenderInferiors() {
        return this.afterRenderInferiors;
    }

    public void setBeforeRenderSuperiors(String[] var1) {
        this.beforeRenderSuperiors = var1;
    }

    public void setBeforeRenderInferiors(String[] var1) {
        this.beforeRenderInferiors = var1;
    }

    public void setOverrideRenderSuperiors(String[] var1) {
        this.overrideRenderSuperiors = var1;
    }

    public void setOverrideRenderInferiors(String[] var1) {
        this.overrideRenderInferiors = var1;
    }

    public void setAfterRenderSuperiors(String[] var1) {
        this.afterRenderSuperiors = var1;
    }

    public void setAfterRenderInferiors(String[] var1) {
        this.afterRenderInferiors = var1;
    }

    public String[] getBeforeRenderCloakSuperiors() {
        return this.beforeRenderCloakSuperiors;
    }

    public String[] getBeforeRenderCloakInferiors() {
        return this.beforeRenderCloakInferiors;
    }

    public String[] getOverrideRenderCloakSuperiors() {
        return this.overrideRenderCloakSuperiors;
    }

    public String[] getOverrideRenderCloakInferiors() {
        return this.overrideRenderCloakInferiors;
    }

    public String[] getAfterRenderCloakSuperiors() {
        return this.afterRenderCloakSuperiors;
    }

    public String[] getAfterRenderCloakInferiors() {
        return this.afterRenderCloakInferiors;
    }

    public void setBeforeRenderCloakSuperiors(String[] var1) {
        this.beforeRenderCloakSuperiors = var1;
    }

    public void setBeforeRenderCloakInferiors(String[] var1) {
        this.beforeRenderCloakInferiors = var1;
    }

    public void setOverrideRenderCloakSuperiors(String[] var1) {
        this.overrideRenderCloakSuperiors = var1;
    }

    public void setOverrideRenderCloakInferiors(String[] var1) {
        this.overrideRenderCloakInferiors = var1;
    }

    public void setAfterRenderCloakSuperiors(String[] var1) {
        this.afterRenderCloakSuperiors = var1;
    }

    public void setAfterRenderCloakInferiors(String[] var1) {
        this.afterRenderCloakInferiors = var1;
    }

    public String[] getBeforeRenderEarsSuperiors() {
        return this.beforeRenderEarsSuperiors;
    }

    public String[] getBeforeRenderEarsInferiors() {
        return this.beforeRenderEarsInferiors;
    }

    public String[] getOverrideRenderEarsSuperiors() {
        return this.overrideRenderEarsSuperiors;
    }

    public String[] getOverrideRenderEarsInferiors() {
        return this.overrideRenderEarsInferiors;
    }

    public String[] getAfterRenderEarsSuperiors() {
        return this.afterRenderEarsSuperiors;
    }

    public String[] getAfterRenderEarsInferiors() {
        return this.afterRenderEarsInferiors;
    }

    public void setBeforeRenderEarsSuperiors(String[] var1) {
        this.beforeRenderEarsSuperiors = var1;
    }

    public void setBeforeRenderEarsInferiors(String[] var1) {
        this.beforeRenderEarsInferiors = var1;
    }

    public void setOverrideRenderEarsSuperiors(String[] var1) {
        this.overrideRenderEarsSuperiors = var1;
    }

    public void setOverrideRenderEarsInferiors(String[] var1) {
        this.overrideRenderEarsInferiors = var1;
    }

    public void setAfterRenderEarsSuperiors(String[] var1) {
        this.afterRenderEarsSuperiors = var1;
    }

    public void setAfterRenderEarsInferiors(String[] var1) {
        this.afterRenderEarsInferiors = var1;
    }

    public String[] getBeforeSetLivingAnimationsSuperiors() {
        return this.beforeSetLivingAnimationsSuperiors;
    }

    public String[] getBeforeSetLivingAnimationsInferiors() {
        return this.beforeSetLivingAnimationsInferiors;
    }

    public String[] getOverrideSetLivingAnimationsSuperiors() {
        return this.overrideSetLivingAnimationsSuperiors;
    }

    public String[] getOverrideSetLivingAnimationsInferiors() {
        return this.overrideSetLivingAnimationsInferiors;
    }

    public String[] getAfterSetLivingAnimationsSuperiors() {
        return this.afterSetLivingAnimationsSuperiors;
    }

    public String[] getAfterSetLivingAnimationsInferiors() {
        return this.afterSetLivingAnimationsInferiors;
    }

    public void setBeforeSetLivingAnimationsSuperiors(String[] var1) {
        this.beforeSetLivingAnimationsSuperiors = var1;
    }

    public void setBeforeSetLivingAnimationsInferiors(String[] var1) {
        this.beforeSetLivingAnimationsInferiors = var1;
    }

    public void setOverrideSetLivingAnimationsSuperiors(String[] var1) {
        this.overrideSetLivingAnimationsSuperiors = var1;
    }

    public void setOverrideSetLivingAnimationsInferiors(String[] var1) {
        this.overrideSetLivingAnimationsInferiors = var1;
    }

    public void setAfterSetLivingAnimationsSuperiors(String[] var1) {
        this.afterSetLivingAnimationsSuperiors = var1;
    }

    public void setAfterSetLivingAnimationsInferiors(String[] var1) {
        this.afterSetLivingAnimationsInferiors = var1;
    }

    public String[] getBeforeSetRotationAnglesSuperiors() {
        return this.beforeSetRotationAnglesSuperiors;
    }

    public String[] getBeforeSetRotationAnglesInferiors() {
        return this.beforeSetRotationAnglesInferiors;
    }

    public String[] getOverrideSetRotationAnglesSuperiors() {
        return this.overrideSetRotationAnglesSuperiors;
    }

    public String[] getOverrideSetRotationAnglesInferiors() {
        return this.overrideSetRotationAnglesInferiors;
    }

    public String[] getAfterSetRotationAnglesSuperiors() {
        return this.afterSetRotationAnglesSuperiors;
    }

    public String[] getAfterSetRotationAnglesInferiors() {
        return this.afterSetRotationAnglesInferiors;
    }

    public void setBeforeSetRotationAnglesSuperiors(String[] var1) {
        this.beforeSetRotationAnglesSuperiors = var1;
    }

    public void setBeforeSetRotationAnglesInferiors(String[] var1) {
        this.beforeSetRotationAnglesInferiors = var1;
    }

    public void setOverrideSetRotationAnglesSuperiors(String[] var1) {
        this.overrideSetRotationAnglesSuperiors = var1;
    }

    public void setOverrideSetRotationAnglesInferiors(String[] var1) {
        this.overrideSetRotationAnglesInferiors = var1;
    }

    public void setAfterSetRotationAnglesSuperiors(String[] var1) {
        this.afterSetRotationAnglesSuperiors = var1;
    }

    public void setAfterSetRotationAnglesInferiors(String[] var1) {
        this.afterSetRotationAnglesInferiors = var1;
    }

    public String[] getBeforeSetTextureOffsetSuperiors() {
        return this.beforeSetTextureOffsetSuperiors;
    }

    public String[] getBeforeSetTextureOffsetInferiors() {
        return this.beforeSetTextureOffsetInferiors;
    }

    public String[] getOverrideSetTextureOffsetSuperiors() {
        return this.overrideSetTextureOffsetSuperiors;
    }

    public String[] getOverrideSetTextureOffsetInferiors() {
        return this.overrideSetTextureOffsetInferiors;
    }

    public String[] getAfterSetTextureOffsetSuperiors() {
        return this.afterSetTextureOffsetSuperiors;
    }

    public String[] getAfterSetTextureOffsetInferiors() {
        return this.afterSetTextureOffsetInferiors;
    }

    public void setBeforeSetTextureOffsetSuperiors(String[] var1) {
        this.beforeSetTextureOffsetSuperiors = var1;
    }

    public void setBeforeSetTextureOffsetInferiors(String[] var1) {
        this.beforeSetTextureOffsetInferiors = var1;
    }

    public void setOverrideSetTextureOffsetSuperiors(String[] var1) {
        this.overrideSetTextureOffsetSuperiors = var1;
    }

    public void setOverrideSetTextureOffsetInferiors(String[] var1) {
        this.overrideSetTextureOffsetInferiors = var1;
    }

    public void setAfterSetTextureOffsetSuperiors(String[] var1) {
        this.afterSetTextureOffsetSuperiors = var1;
    }

    public void setAfterSetTextureOffsetInferiors(String[] var1) {
        this.afterSetTextureOffsetInferiors = var1;
    }
}

