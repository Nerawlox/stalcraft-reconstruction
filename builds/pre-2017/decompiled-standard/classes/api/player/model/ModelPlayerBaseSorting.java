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

    public void setBeforeGetRandomModelBoxSuperiors(String[] stringArray) {
        this.beforeGetRandomModelBoxSuperiors = stringArray;
    }

    public void setBeforeGetRandomModelBoxInferiors(String[] stringArray) {
        this.beforeGetRandomModelBoxInferiors = stringArray;
    }

    public void setOverrideGetRandomModelBoxSuperiors(String[] stringArray) {
        this.overrideGetRandomModelBoxSuperiors = stringArray;
    }

    public void setOverrideGetRandomModelBoxInferiors(String[] stringArray) {
        this.overrideGetRandomModelBoxInferiors = stringArray;
    }

    public void setAfterGetRandomModelBoxSuperiors(String[] stringArray) {
        this.afterGetRandomModelBoxSuperiors = stringArray;
    }

    public void setAfterGetRandomModelBoxInferiors(String[] stringArray) {
        this.afterGetRandomModelBoxInferiors = stringArray;
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

    public void setBeforeGetTextureOffsetSuperiors(String[] stringArray) {
        this.beforeGetTextureOffsetSuperiors = stringArray;
    }

    public void setBeforeGetTextureOffsetInferiors(String[] stringArray) {
        this.beforeGetTextureOffsetInferiors = stringArray;
    }

    public void setOverrideGetTextureOffsetSuperiors(String[] stringArray) {
        this.overrideGetTextureOffsetSuperiors = stringArray;
    }

    public void setOverrideGetTextureOffsetInferiors(String[] stringArray) {
        this.overrideGetTextureOffsetInferiors = stringArray;
    }

    public void setAfterGetTextureOffsetSuperiors(String[] stringArray) {
        this.afterGetTextureOffsetSuperiors = stringArray;
    }

    public void setAfterGetTextureOffsetInferiors(String[] stringArray) {
        this.afterGetTextureOffsetInferiors = stringArray;
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

    public void setBeforeRenderSuperiors(String[] stringArray) {
        this.beforeRenderSuperiors = stringArray;
    }

    public void setBeforeRenderInferiors(String[] stringArray) {
        this.beforeRenderInferiors = stringArray;
    }

    public void setOverrideRenderSuperiors(String[] stringArray) {
        this.overrideRenderSuperiors = stringArray;
    }

    public void setOverrideRenderInferiors(String[] stringArray) {
        this.overrideRenderInferiors = stringArray;
    }

    public void setAfterRenderSuperiors(String[] stringArray) {
        this.afterRenderSuperiors = stringArray;
    }

    public void setAfterRenderInferiors(String[] stringArray) {
        this.afterRenderInferiors = stringArray;
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

    public void setBeforeRenderCloakSuperiors(String[] stringArray) {
        this.beforeRenderCloakSuperiors = stringArray;
    }

    public void setBeforeRenderCloakInferiors(String[] stringArray) {
        this.beforeRenderCloakInferiors = stringArray;
    }

    public void setOverrideRenderCloakSuperiors(String[] stringArray) {
        this.overrideRenderCloakSuperiors = stringArray;
    }

    public void setOverrideRenderCloakInferiors(String[] stringArray) {
        this.overrideRenderCloakInferiors = stringArray;
    }

    public void setAfterRenderCloakSuperiors(String[] stringArray) {
        this.afterRenderCloakSuperiors = stringArray;
    }

    public void setAfterRenderCloakInferiors(String[] stringArray) {
        this.afterRenderCloakInferiors = stringArray;
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

    public void setBeforeRenderEarsSuperiors(String[] stringArray) {
        this.beforeRenderEarsSuperiors = stringArray;
    }

    public void setBeforeRenderEarsInferiors(String[] stringArray) {
        this.beforeRenderEarsInferiors = stringArray;
    }

    public void setOverrideRenderEarsSuperiors(String[] stringArray) {
        this.overrideRenderEarsSuperiors = stringArray;
    }

    public void setOverrideRenderEarsInferiors(String[] stringArray) {
        this.overrideRenderEarsInferiors = stringArray;
    }

    public void setAfterRenderEarsSuperiors(String[] stringArray) {
        this.afterRenderEarsSuperiors = stringArray;
    }

    public void setAfterRenderEarsInferiors(String[] stringArray) {
        this.afterRenderEarsInferiors = stringArray;
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

    public void setBeforeSetLivingAnimationsSuperiors(String[] stringArray) {
        this.beforeSetLivingAnimationsSuperiors = stringArray;
    }

    public void setBeforeSetLivingAnimationsInferiors(String[] stringArray) {
        this.beforeSetLivingAnimationsInferiors = stringArray;
    }

    public void setOverrideSetLivingAnimationsSuperiors(String[] stringArray) {
        this.overrideSetLivingAnimationsSuperiors = stringArray;
    }

    public void setOverrideSetLivingAnimationsInferiors(String[] stringArray) {
        this.overrideSetLivingAnimationsInferiors = stringArray;
    }

    public void setAfterSetLivingAnimationsSuperiors(String[] stringArray) {
        this.afterSetLivingAnimationsSuperiors = stringArray;
    }

    public void setAfterSetLivingAnimationsInferiors(String[] stringArray) {
        this.afterSetLivingAnimationsInferiors = stringArray;
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

    public void setBeforeSetRotationAnglesSuperiors(String[] stringArray) {
        this.beforeSetRotationAnglesSuperiors = stringArray;
    }

    public void setBeforeSetRotationAnglesInferiors(String[] stringArray) {
        this.beforeSetRotationAnglesInferiors = stringArray;
    }

    public void setOverrideSetRotationAnglesSuperiors(String[] stringArray) {
        this.overrideSetRotationAnglesSuperiors = stringArray;
    }

    public void setOverrideSetRotationAnglesInferiors(String[] stringArray) {
        this.overrideSetRotationAnglesInferiors = stringArray;
    }

    public void setAfterSetRotationAnglesSuperiors(String[] stringArray) {
        this.afterSetRotationAnglesSuperiors = stringArray;
    }

    public void setAfterSetRotationAnglesInferiors(String[] stringArray) {
        this.afterSetRotationAnglesInferiors = stringArray;
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

    public void setBeforeSetTextureOffsetSuperiors(String[] stringArray) {
        this.beforeSetTextureOffsetSuperiors = stringArray;
    }

    public void setBeforeSetTextureOffsetInferiors(String[] stringArray) {
        this.beforeSetTextureOffsetInferiors = stringArray;
    }

    public void setOverrideSetTextureOffsetSuperiors(String[] stringArray) {
        this.overrideSetTextureOffsetSuperiors = stringArray;
    }

    public void setOverrideSetTextureOffsetInferiors(String[] stringArray) {
        this.overrideSetTextureOffsetInferiors = stringArray;
    }

    public void setAfterSetTextureOffsetSuperiors(String[] stringArray) {
        this.afterSetTextureOffsetSuperiors = stringArray;
    }

    public void setAfterSetTextureOffsetInferiors(String[] stringArray) {
        this.afterSetTextureOffsetInferiors = stringArray;
    }
}

