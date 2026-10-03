/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.ModelRenderer
 *  net.minecraft.client.model.TextureOffset
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 */
package api.player.model;

import api.player.model.IModelPlayerAPI;
import api.player.model.ModelPlayer;
import api.player.model.ModelPlayerBase;
import api.player.model.ModelPlayerBaseSorter;
import api.player.model.ModelPlayerBaseSorting;
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
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public final class ModelPlayerAPI {
    private static final Class<?>[] Class = new Class[]{ModelPlayerAPI.class};
    private static final Class<?>[] Classes = new Class[]{ModelPlayerAPI.class, String.class};
    private static boolean isCreated;
    private static final Logger logger;
    private static List<IModelPlayerAPI> allInstances;
    private static final Map<String, String[]> EmptySortMap;
    private static final List<String> beforeGetRandomModelBoxHookTypes;
    private static final List<String> overrideGetRandomModelBoxHookTypes;
    private static final List<String> afterGetRandomModelBoxHookTypes;
    private ModelPlayerBase[] beforeGetRandomModelBoxHooks;
    private ModelPlayerBase[] overrideGetRandomModelBoxHooks;
    private ModelPlayerBase[] afterGetRandomModelBoxHooks;
    public boolean isGetRandomModelBoxModded;
    private static final Map<String, String[]> allBaseBeforeGetRandomModelBoxSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetRandomModelBoxInferiors;
    private static final Map<String, String[]> allBaseOverrideGetRandomModelBoxSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetRandomModelBoxInferiors;
    private static final Map<String, String[]> allBaseAfterGetRandomModelBoxSuperiors;
    private static final Map<String, String[]> allBaseAfterGetRandomModelBoxInferiors;
    private static final List<String> beforeGetTextureOffsetHookTypes;
    private static final List<String> overrideGetTextureOffsetHookTypes;
    private static final List<String> afterGetTextureOffsetHookTypes;
    private ModelPlayerBase[] beforeGetTextureOffsetHooks;
    private ModelPlayerBase[] overrideGetTextureOffsetHooks;
    private ModelPlayerBase[] afterGetTextureOffsetHooks;
    public boolean isGetTextureOffsetModded;
    private static final Map<String, String[]> allBaseBeforeGetTextureOffsetSuperiors;
    private static final Map<String, String[]> allBaseBeforeGetTextureOffsetInferiors;
    private static final Map<String, String[]> allBaseOverrideGetTextureOffsetSuperiors;
    private static final Map<String, String[]> allBaseOverrideGetTextureOffsetInferiors;
    private static final Map<String, String[]> allBaseAfterGetTextureOffsetSuperiors;
    private static final Map<String, String[]> allBaseAfterGetTextureOffsetInferiors;
    private static final List<String> beforeRenderHookTypes;
    private static final List<String> overrideRenderHookTypes;
    private static final List<String> afterRenderHookTypes;
    private ModelPlayerBase[] beforeRenderHooks;
    private ModelPlayerBase[] overrideRenderHooks;
    private ModelPlayerBase[] afterRenderHooks;
    public boolean isRenderModded;
    private static final Map<String, String[]> allBaseBeforeRenderSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderInferiors;
    private static final Map<String, String[]> allBaseAfterRenderSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderInferiors;
    private static final List<String> beforeRenderCloakHookTypes;
    private static final List<String> overrideRenderCloakHookTypes;
    private static final List<String> afterRenderCloakHookTypes;
    private ModelPlayerBase[] beforeRenderCloakHooks;
    private ModelPlayerBase[] overrideRenderCloakHooks;
    private ModelPlayerBase[] afterRenderCloakHooks;
    public boolean isRenderCloakModded;
    private static final Map<String, String[]> allBaseBeforeRenderCloakSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderCloakInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderCloakSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderCloakInferiors;
    private static final Map<String, String[]> allBaseAfterRenderCloakSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderCloakInferiors;
    private static final List<String> beforeRenderEarsHookTypes;
    private static final List<String> overrideRenderEarsHookTypes;
    private static final List<String> afterRenderEarsHookTypes;
    private ModelPlayerBase[] beforeRenderEarsHooks;
    private ModelPlayerBase[] overrideRenderEarsHooks;
    private ModelPlayerBase[] afterRenderEarsHooks;
    public boolean isRenderEarsModded;
    private static final Map<String, String[]> allBaseBeforeRenderEarsSuperiors;
    private static final Map<String, String[]> allBaseBeforeRenderEarsInferiors;
    private static final Map<String, String[]> allBaseOverrideRenderEarsSuperiors;
    private static final Map<String, String[]> allBaseOverrideRenderEarsInferiors;
    private static final Map<String, String[]> allBaseAfterRenderEarsSuperiors;
    private static final Map<String, String[]> allBaseAfterRenderEarsInferiors;
    private static final List<String> beforeSetLivingAnimationsHookTypes;
    private static final List<String> overrideSetLivingAnimationsHookTypes;
    private static final List<String> afterSetLivingAnimationsHookTypes;
    private ModelPlayerBase[] beforeSetLivingAnimationsHooks;
    private ModelPlayerBase[] overrideSetLivingAnimationsHooks;
    private ModelPlayerBase[] afterSetLivingAnimationsHooks;
    public boolean isSetLivingAnimationsModded;
    private static final Map<String, String[]> allBaseBeforeSetLivingAnimationsSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetLivingAnimationsInferiors;
    private static final Map<String, String[]> allBaseOverrideSetLivingAnimationsSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetLivingAnimationsInferiors;
    private static final Map<String, String[]> allBaseAfterSetLivingAnimationsSuperiors;
    private static final Map<String, String[]> allBaseAfterSetLivingAnimationsInferiors;
    private static final List<String> beforeSetRotationAnglesHookTypes;
    private static final List<String> overrideSetRotationAnglesHookTypes;
    private static final List<String> afterSetRotationAnglesHookTypes;
    private ModelPlayerBase[] beforeSetRotationAnglesHooks;
    private ModelPlayerBase[] overrideSetRotationAnglesHooks;
    private ModelPlayerBase[] afterSetRotationAnglesHooks;
    public boolean isSetRotationAnglesModded;
    private static final Map<String, String[]> allBaseBeforeSetRotationAnglesSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetRotationAnglesInferiors;
    private static final Map<String, String[]> allBaseOverrideSetRotationAnglesSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetRotationAnglesInferiors;
    private static final Map<String, String[]> allBaseAfterSetRotationAnglesSuperiors;
    private static final Map<String, String[]> allBaseAfterSetRotationAnglesInferiors;
    private static final List<String> beforeSetTextureOffsetHookTypes;
    private static final List<String> overrideSetTextureOffsetHookTypes;
    private static final List<String> afterSetTextureOffsetHookTypes;
    private ModelPlayerBase[] beforeSetTextureOffsetHooks;
    private ModelPlayerBase[] overrideSetTextureOffsetHooks;
    private ModelPlayerBase[] afterSetTextureOffsetHooks;
    public boolean isSetTextureOffsetModded;
    private static final Map<String, String[]> allBaseBeforeSetTextureOffsetSuperiors;
    private static final Map<String, String[]> allBaseBeforeSetTextureOffsetInferiors;
    private static final Map<String, String[]> allBaseOverrideSetTextureOffsetSuperiors;
    private static final Map<String, String[]> allBaseOverrideSetTextureOffsetInferiors;
    private static final Map<String, String[]> allBaseAfterSetTextureOffsetSuperiors;
    private static final Map<String, String[]> allBaseAfterSetTextureOffsetInferiors;
    protected final IModelPlayerAPI modelPlayer;
    private final float paramFloat;
    private final String type;
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
    private ModelPlayerBase[] beforeLocalConstructingHooks;
    private ModelPlayerBase[] afterLocalConstructingHooks;
    private final Map<ModelPlayerBase, String> baseObjectsToId = new Hashtable<ModelPlayerBase, String>();
    private final Map<String, ModelPlayerBase> allBaseObjects = new Hashtable<String, ModelPlayerBase>();
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
        ModelPlayerAPI.register(var0, var1, (ModelPlayerBaseSorting)null);
    }

    public static void register(String var0, Class<?> var1, ModelPlayerBaseSorting var2) {
        try {
            ModelPlayerAPI.register(var1, var0, var2);
        }
        catch (RuntimeException var4) {
            if (var0 != null) {
                ModelPlayerAPI.log("Model Player: failed to register id '" + var0 + "'");
            } else {
                ModelPlayerAPI.log("Model Player: failed to register ModelPlayerBase");
            }
            throw var4;
        }
    }

    private static void register(Class<?> var0, String var1, ModelPlayerBaseSorting var2) {
        Constructor<?> var18;
        if (!isCreated) {
            try {
                Method var3 = ModelPlayer.class.getMethod("getModelPlayerBase", String.class);
                if (var3.getReturnType() != ModelPlayerBase.class) {
                    throw new NoSuchMethodException(ModelPlayerBase.class.getName() + " " + ModelPlayer.class.getName() + ".getModelPlayerBase(" + String.class.getName() + ")");
                }
            }
            catch (NoSuchMethodException var16) {
                String var12;
                int var11;
                String[] var4 = new String[]{"========================================", "The API \"Model Player\" version 1.1 of the mod \"Render Player API core 1.1\" can not be created!", "----------------------------------------", "Mandatory member method \"{0} getModelPlayerBase({3})\" not found in class \"{1}\".", "There are three scenarios this can happen:", "* Minecraft Forge is missing a Render Player API core which Minecraft version matches its own.", "  Download and install the latest Render Player API core for the Minecraft version you were trying to run.", "* The code of the class \"{2}\" of Render Player API core has been modified beyond recognition by another Minecraft Forge coremod.", "  Try temporary deinstallation of other core mods to find the culprit and deinstall it permanently to fix this specific problem.", "* Render Player API core has not been installed correctly.", "  Deinstall Render Player API core and install it again following the installation instructions in the readme file.", "========================================"};
                String var5 = ModelPlayerBase.class.getName();
                String var6 = ModelPlayer.class.getName();
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
            ModelPlayerAPI.log("Model Player 1.1 Created");
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
                throw new IllegalArgumentException("Can not find necessary constructor with one argument of type '" + ModelPlayerAPI.class.getName() + "' and eventually a second argument of type 'String' in the class '" + var0.getName() + "'", var15);
            }
        }
        allBaseConstructors.put(var1, var18);
        if (var2 != null) {
            ModelPlayerAPI.addSorting(var1, allBaseBeforeLocalConstructingSuperiors, var2.getBeforeLocalConstructingSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeLocalConstructingInferiors, var2.getBeforeLocalConstructingInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterLocalConstructingSuperiors, var2.getAfterLocalConstructingSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterLocalConstructingInferiors, var2.getAfterLocalConstructingInferiors());
            ModelPlayerAPI.addDynamicSorting(var1, allBaseBeforeDynamicSuperiors, var2.getDynamicBeforeSuperiors());
            ModelPlayerAPI.addDynamicSorting(var1, allBaseBeforeDynamicInferiors, var2.getDynamicBeforeInferiors());
            ModelPlayerAPI.addDynamicSorting(var1, allBaseOverrideDynamicSuperiors, var2.getDynamicOverrideSuperiors());
            ModelPlayerAPI.addDynamicSorting(var1, allBaseOverrideDynamicInferiors, var2.getDynamicOverrideInferiors());
            ModelPlayerAPI.addDynamicSorting(var1, allBaseAfterDynamicSuperiors, var2.getDynamicAfterSuperiors());
            ModelPlayerAPI.addDynamicSorting(var1, allBaseAfterDynamicInferiors, var2.getDynamicAfterInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeGetRandomModelBoxSuperiors, var2.getBeforeGetRandomModelBoxSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeGetRandomModelBoxInferiors, var2.getBeforeGetRandomModelBoxInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideGetRandomModelBoxSuperiors, var2.getOverrideGetRandomModelBoxSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideGetRandomModelBoxInferiors, var2.getOverrideGetRandomModelBoxInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterGetRandomModelBoxSuperiors, var2.getAfterGetRandomModelBoxSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterGetRandomModelBoxInferiors, var2.getAfterGetRandomModelBoxInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeGetTextureOffsetSuperiors, var2.getBeforeGetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeGetTextureOffsetInferiors, var2.getBeforeGetTextureOffsetInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideGetTextureOffsetSuperiors, var2.getOverrideGetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideGetTextureOffsetInferiors, var2.getOverrideGetTextureOffsetInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterGetTextureOffsetSuperiors, var2.getAfterGetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterGetTextureOffsetInferiors, var2.getAfterGetTextureOffsetInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeRenderSuperiors, var2.getBeforeRenderSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeRenderInferiors, var2.getBeforeRenderInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideRenderSuperiors, var2.getOverrideRenderSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideRenderInferiors, var2.getOverrideRenderInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterRenderSuperiors, var2.getAfterRenderSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterRenderInferiors, var2.getAfterRenderInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeRenderCloakSuperiors, var2.getBeforeRenderCloakSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeRenderCloakInferiors, var2.getBeforeRenderCloakInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideRenderCloakSuperiors, var2.getOverrideRenderCloakSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideRenderCloakInferiors, var2.getOverrideRenderCloakInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterRenderCloakSuperiors, var2.getAfterRenderCloakSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterRenderCloakInferiors, var2.getAfterRenderCloakInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeRenderEarsSuperiors, var2.getBeforeRenderEarsSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeRenderEarsInferiors, var2.getBeforeRenderEarsInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideRenderEarsSuperiors, var2.getOverrideRenderEarsSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideRenderEarsInferiors, var2.getOverrideRenderEarsInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterRenderEarsSuperiors, var2.getAfterRenderEarsSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterRenderEarsInferiors, var2.getAfterRenderEarsInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeSetLivingAnimationsSuperiors, var2.getBeforeSetLivingAnimationsSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeSetLivingAnimationsInferiors, var2.getBeforeSetLivingAnimationsInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideSetLivingAnimationsSuperiors, var2.getOverrideSetLivingAnimationsSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideSetLivingAnimationsInferiors, var2.getOverrideSetLivingAnimationsInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterSetLivingAnimationsSuperiors, var2.getAfterSetLivingAnimationsSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterSetLivingAnimationsInferiors, var2.getAfterSetLivingAnimationsInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeSetRotationAnglesSuperiors, var2.getBeforeSetRotationAnglesSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeSetRotationAnglesInferiors, var2.getBeforeSetRotationAnglesInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideSetRotationAnglesSuperiors, var2.getOverrideSetRotationAnglesSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideSetRotationAnglesInferiors, var2.getOverrideSetRotationAnglesInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterSetRotationAnglesSuperiors, var2.getAfterSetRotationAnglesSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterSetRotationAnglesInferiors, var2.getAfterSetRotationAnglesInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeSetTextureOffsetSuperiors, var2.getBeforeSetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseBeforeSetTextureOffsetInferiors, var2.getBeforeSetTextureOffsetInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideSetTextureOffsetSuperiors, var2.getOverrideSetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseOverrideSetTextureOffsetInferiors, var2.getOverrideSetTextureOffsetInferiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterSetTextureOffsetSuperiors, var2.getAfterSetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(var1, allBaseAfterSetTextureOffsetInferiors, var2.getAfterSetTextureOffsetInferiors());
        }
        ModelPlayerAPI.addMethod(var1, var0, beforeLocalConstructingHookTypes, "beforeLocalConstructing", Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, afterLocalConstructingHookTypes, "afterLocalConstructing", Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, beforeGetRandomModelBoxHookTypes, "beforeGetRandomModelBox", Random.class);
        ModelPlayerAPI.addMethod(var1, var0, overrideGetRandomModelBoxHookTypes, "getRandomModelBox", Random.class);
        ModelPlayerAPI.addMethod(var1, var0, afterGetRandomModelBoxHookTypes, "afterGetRandomModelBox", Random.class);
        ModelPlayerAPI.addMethod(var1, var0, beforeGetTextureOffsetHookTypes, "beforeGetTextureOffset", String.class);
        ModelPlayerAPI.addMethod(var1, var0, overrideGetTextureOffsetHookTypes, "getTextureOffset", String.class);
        ModelPlayerAPI.addMethod(var1, var0, afterGetTextureOffsetHookTypes, "afterGetTextureOffset", String.class);
        ModelPlayerAPI.addMethod(var1, var0, beforeRenderHookTypes, "beforeRender", Entity.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, overrideRenderHookTypes, "render", Entity.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, afterRenderHookTypes, "afterRender", Entity.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, beforeRenderCloakHookTypes, "beforeRenderCloak", Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, overrideRenderCloakHookTypes, "renderCloak", Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, afterRenderCloakHookTypes, "afterRenderCloak", Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, beforeRenderEarsHookTypes, "beforeRenderEars", Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, overrideRenderEarsHookTypes, "renderEars", Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, afterRenderEarsHookTypes, "afterRenderEars", Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, beforeSetLivingAnimationsHookTypes, "beforeSetLivingAnimations", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, overrideSetLivingAnimationsHookTypes, "setLivingAnimations", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, afterSetLivingAnimationsHookTypes, "afterSetLivingAnimations", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, beforeSetRotationAnglesHookTypes, "beforeSetRotationAngles", Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Entity.class);
        ModelPlayerAPI.addMethod(var1, var0, overrideSetRotationAnglesHookTypes, "setRotationAngles", Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Entity.class);
        ModelPlayerAPI.addMethod(var1, var0, afterSetRotationAnglesHookTypes, "afterSetRotationAngles", Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Entity.class);
        ModelPlayerAPI.addMethod(var1, var0, beforeSetTextureOffsetHookTypes, "beforeSetTextureOffset", String.class, Integer.TYPE, Integer.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, overrideSetTextureOffsetHookTypes, "setTextureOffset", String.class, Integer.TYPE, Integer.TYPE);
        ModelPlayerAPI.addMethod(var1, var0, afterSetTextureOffsetHookTypes, "afterSetTextureOffset", String.class, Integer.TYPE, Integer.TYPE);
        ModelPlayerAPI.addDynamicMethods(var1, var0);
        ModelPlayerAPI.addDynamicKeys(var1, var0, beforeDynamicHookMethods, beforeDynamicHookTypes);
        ModelPlayerAPI.addDynamicKeys(var1, var0, overrideDynamicHookMethods, overrideDynamicHookTypes);
        ModelPlayerAPI.addDynamicKeys(var1, var0, afterDynamicHookMethods, afterDynamicHookTypes);
        ModelPlayerAPI.initialize();
        for (IModelPlayerAPI var20 : allInstances) {
            var20.getModelPlayerAPI().attachModelPlayerBase(var1);
        }
        System.out.println("Model Player: registered " + var1);
        logger.fine("Model Player: registered class '" + var0.getName() + "' with id '" + var1 + "'");
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
        for (IModelPlayerAPI var3 : allInstances) {
            var3.getModelPlayerAPI().detachModelPlayerBase(var0);
        }
        beforeLocalConstructingHookTypes.remove(var0);
        afterLocalConstructingHookTypes.remove(var0);
        allBaseBeforeGetRandomModelBoxSuperiors.remove(var0);
        allBaseBeforeGetRandomModelBoxInferiors.remove(var0);
        allBaseOverrideGetRandomModelBoxSuperiors.remove(var0);
        allBaseOverrideGetRandomModelBoxInferiors.remove(var0);
        allBaseAfterGetRandomModelBoxSuperiors.remove(var0);
        allBaseAfterGetRandomModelBoxInferiors.remove(var0);
        beforeGetRandomModelBoxHookTypes.remove(var0);
        overrideGetRandomModelBoxHookTypes.remove(var0);
        afterGetRandomModelBoxHookTypes.remove(var0);
        allBaseBeforeGetTextureOffsetSuperiors.remove(var0);
        allBaseBeforeGetTextureOffsetInferiors.remove(var0);
        allBaseOverrideGetTextureOffsetSuperiors.remove(var0);
        allBaseOverrideGetTextureOffsetInferiors.remove(var0);
        allBaseAfterGetTextureOffsetSuperiors.remove(var0);
        allBaseAfterGetTextureOffsetInferiors.remove(var0);
        beforeGetTextureOffsetHookTypes.remove(var0);
        overrideGetTextureOffsetHookTypes.remove(var0);
        afterGetTextureOffsetHookTypes.remove(var0);
        allBaseBeforeRenderSuperiors.remove(var0);
        allBaseBeforeRenderInferiors.remove(var0);
        allBaseOverrideRenderSuperiors.remove(var0);
        allBaseOverrideRenderInferiors.remove(var0);
        allBaseAfterRenderSuperiors.remove(var0);
        allBaseAfterRenderInferiors.remove(var0);
        beforeRenderHookTypes.remove(var0);
        overrideRenderHookTypes.remove(var0);
        afterRenderHookTypes.remove(var0);
        allBaseBeforeRenderCloakSuperiors.remove(var0);
        allBaseBeforeRenderCloakInferiors.remove(var0);
        allBaseOverrideRenderCloakSuperiors.remove(var0);
        allBaseOverrideRenderCloakInferiors.remove(var0);
        allBaseAfterRenderCloakSuperiors.remove(var0);
        allBaseAfterRenderCloakInferiors.remove(var0);
        beforeRenderCloakHookTypes.remove(var0);
        overrideRenderCloakHookTypes.remove(var0);
        afterRenderCloakHookTypes.remove(var0);
        allBaseBeforeRenderEarsSuperiors.remove(var0);
        allBaseBeforeRenderEarsInferiors.remove(var0);
        allBaseOverrideRenderEarsSuperiors.remove(var0);
        allBaseOverrideRenderEarsInferiors.remove(var0);
        allBaseAfterRenderEarsSuperiors.remove(var0);
        allBaseAfterRenderEarsInferiors.remove(var0);
        beforeRenderEarsHookTypes.remove(var0);
        overrideRenderEarsHookTypes.remove(var0);
        afterRenderEarsHookTypes.remove(var0);
        allBaseBeforeSetLivingAnimationsSuperiors.remove(var0);
        allBaseBeforeSetLivingAnimationsInferiors.remove(var0);
        allBaseOverrideSetLivingAnimationsSuperiors.remove(var0);
        allBaseOverrideSetLivingAnimationsInferiors.remove(var0);
        allBaseAfterSetLivingAnimationsSuperiors.remove(var0);
        allBaseAfterSetLivingAnimationsInferiors.remove(var0);
        beforeSetLivingAnimationsHookTypes.remove(var0);
        overrideSetLivingAnimationsHookTypes.remove(var0);
        afterSetLivingAnimationsHookTypes.remove(var0);
        allBaseBeforeSetRotationAnglesSuperiors.remove(var0);
        allBaseBeforeSetRotationAnglesInferiors.remove(var0);
        allBaseOverrideSetRotationAnglesSuperiors.remove(var0);
        allBaseOverrideSetRotationAnglesInferiors.remove(var0);
        allBaseAfterSetRotationAnglesSuperiors.remove(var0);
        allBaseAfterSetRotationAnglesInferiors.remove(var0);
        beforeSetRotationAnglesHookTypes.remove(var0);
        overrideSetRotationAnglesHookTypes.remove(var0);
        afterSetRotationAnglesHookTypes.remove(var0);
        allBaseBeforeSetTextureOffsetSuperiors.remove(var0);
        allBaseBeforeSetTextureOffsetInferiors.remove(var0);
        allBaseOverrideSetTextureOffsetSuperiors.remove(var0);
        allBaseOverrideSetTextureOffsetInferiors.remove(var0);
        allBaseAfterSetTextureOffsetSuperiors.remove(var0);
        allBaseAfterSetTextureOffsetInferiors.remove(var0);
        beforeSetTextureOffsetHookTypes.remove(var0);
        overrideSetTextureOffsetHookTypes.remove(var0);
        afterSetTextureOffsetHookTypes.remove(var0);
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
        ModelPlayerAPI.removeDynamicHookTypes(var0, beforeDynamicHookTypes);
        ModelPlayerAPI.removeDynamicHookTypes(var0, overrideDynamicHookTypes);
        ModelPlayerAPI.removeDynamicHookTypes(var0, afterDynamicHookTypes);
        allBaseBeforeDynamicSuperiors.remove(var0);
        allBaseBeforeDynamicInferiors.remove(var0);
        allBaseOverrideDynamicSuperiors.remove(var0);
        allBaseOverrideDynamicInferiors.remove(var0);
        allBaseAfterDynamicSuperiors.remove(var0);
        allBaseAfterDynamicInferiors.remove(var0);
        ModelPlayerAPI.log("ModelPlayerAPI: unregistered id '" + var0 + "'");
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
            boolean bl2 = var6 = var5.getDeclaringClass() != ModelPlayerBase.class;
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
                    var2 = ModelPlayerAPI.addDynamicMethod(var10, var8, var2);
                    continue;
                }
                if (var11) {
                    var3 = ModelPlayerAPI.addDynamicMethod(var10, var8, var3);
                    continue;
                }
                if (var14) {
                    var5 = ModelPlayerAPI.addDynamicMethod(var10, var8, var5);
                    continue;
                }
                var4 = ModelPlayerAPI.addDynamicMethod(var10, var8, var4);
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

    public static ModelPlayerAPI create(IModelPlayerAPI var0, float var1, String var2) {
        if (allBaseConstructors.size() > 0 && !initialized) {
            ModelPlayerAPI.initialize();
        }
        return new ModelPlayerAPI(var0, var1, var2);
    }

    private static void initialize() {
        ModelPlayerAPI.sortBases(beforeLocalConstructingHookTypes, allBaseBeforeLocalConstructingSuperiors, allBaseBeforeLocalConstructingInferiors, "beforeLocalConstructing");
        ModelPlayerAPI.sortBases(afterLocalConstructingHookTypes, allBaseAfterLocalConstructingSuperiors, allBaseAfterLocalConstructingInferiors, "afterLocalConstructing");
        for (String var1 : keys) {
            ModelPlayerAPI.sortDynamicBases(beforeDynamicHookTypes, allBaseBeforeDynamicSuperiors, allBaseBeforeDynamicInferiors, var1);
            ModelPlayerAPI.sortDynamicBases(overrideDynamicHookTypes, allBaseOverrideDynamicSuperiors, allBaseOverrideDynamicInferiors, var1);
            ModelPlayerAPI.sortDynamicBases(afterDynamicHookTypes, allBaseAfterDynamicSuperiors, allBaseAfterDynamicInferiors, var1);
        }
        ModelPlayerAPI.sortBases(beforeGetRandomModelBoxHookTypes, allBaseBeforeGetRandomModelBoxSuperiors, allBaseBeforeGetRandomModelBoxInferiors, "beforeGetRandomModelBox");
        ModelPlayerAPI.sortBases(overrideGetRandomModelBoxHookTypes, allBaseOverrideGetRandomModelBoxSuperiors, allBaseOverrideGetRandomModelBoxInferiors, "overrideGetRandomModelBox");
        ModelPlayerAPI.sortBases(afterGetRandomModelBoxHookTypes, allBaseAfterGetRandomModelBoxSuperiors, allBaseAfterGetRandomModelBoxInferiors, "afterGetRandomModelBox");
        ModelPlayerAPI.sortBases(beforeGetTextureOffsetHookTypes, allBaseBeforeGetTextureOffsetSuperiors, allBaseBeforeGetTextureOffsetInferiors, "beforeGetTextureOffset");
        ModelPlayerAPI.sortBases(overrideGetTextureOffsetHookTypes, allBaseOverrideGetTextureOffsetSuperiors, allBaseOverrideGetTextureOffsetInferiors, "overrideGetTextureOffset");
        ModelPlayerAPI.sortBases(afterGetTextureOffsetHookTypes, allBaseAfterGetTextureOffsetSuperiors, allBaseAfterGetTextureOffsetInferiors, "afterGetTextureOffset");
        ModelPlayerAPI.sortBases(beforeRenderHookTypes, allBaseBeforeRenderSuperiors, allBaseBeforeRenderInferiors, "beforeRender");
        ModelPlayerAPI.sortBases(overrideRenderHookTypes, allBaseOverrideRenderSuperiors, allBaseOverrideRenderInferiors, "overrideRender");
        ModelPlayerAPI.sortBases(afterRenderHookTypes, allBaseAfterRenderSuperiors, allBaseAfterRenderInferiors, "afterRender");
        ModelPlayerAPI.sortBases(beforeRenderCloakHookTypes, allBaseBeforeRenderCloakSuperiors, allBaseBeforeRenderCloakInferiors, "beforeRenderCloak");
        ModelPlayerAPI.sortBases(overrideRenderCloakHookTypes, allBaseOverrideRenderCloakSuperiors, allBaseOverrideRenderCloakInferiors, "overrideRenderCloak");
        ModelPlayerAPI.sortBases(afterRenderCloakHookTypes, allBaseAfterRenderCloakSuperiors, allBaseAfterRenderCloakInferiors, "afterRenderCloak");
        ModelPlayerAPI.sortBases(beforeRenderEarsHookTypes, allBaseBeforeRenderEarsSuperiors, allBaseBeforeRenderEarsInferiors, "beforeRenderEars");
        ModelPlayerAPI.sortBases(overrideRenderEarsHookTypes, allBaseOverrideRenderEarsSuperiors, allBaseOverrideRenderEarsInferiors, "overrideRenderEars");
        ModelPlayerAPI.sortBases(afterRenderEarsHookTypes, allBaseAfterRenderEarsSuperiors, allBaseAfterRenderEarsInferiors, "afterRenderEars");
        ModelPlayerAPI.sortBases(beforeSetLivingAnimationsHookTypes, allBaseBeforeSetLivingAnimationsSuperiors, allBaseBeforeSetLivingAnimationsInferiors, "beforeSetLivingAnimations");
        ModelPlayerAPI.sortBases(overrideSetLivingAnimationsHookTypes, allBaseOverrideSetLivingAnimationsSuperiors, allBaseOverrideSetLivingAnimationsInferiors, "overrideSetLivingAnimations");
        ModelPlayerAPI.sortBases(afterSetLivingAnimationsHookTypes, allBaseAfterSetLivingAnimationsSuperiors, allBaseAfterSetLivingAnimationsInferiors, "afterSetLivingAnimations");
        ModelPlayerAPI.sortBases(beforeSetRotationAnglesHookTypes, allBaseBeforeSetRotationAnglesSuperiors, allBaseBeforeSetRotationAnglesInferiors, "beforeSetRotationAngles");
        ModelPlayerAPI.sortBases(overrideSetRotationAnglesHookTypes, allBaseOverrideSetRotationAnglesSuperiors, allBaseOverrideSetRotationAnglesInferiors, "overrideSetRotationAngles");
        ModelPlayerAPI.sortBases(afterSetRotationAnglesHookTypes, allBaseAfterSetRotationAnglesSuperiors, allBaseAfterSetRotationAnglesInferiors, "afterSetRotationAngles");
        ModelPlayerAPI.sortBases(beforeSetTextureOffsetHookTypes, allBaseBeforeSetTextureOffsetSuperiors, allBaseBeforeSetTextureOffsetInferiors, "beforeSetTextureOffset");
        ModelPlayerAPI.sortBases(overrideSetTextureOffsetHookTypes, allBaseOverrideSetTextureOffsetSuperiors, allBaseOverrideSetTextureOffsetInferiors, "overrideSetTextureOffset");
        ModelPlayerAPI.sortBases(afterSetTextureOffsetHookTypes, allBaseAfterSetTextureOffsetSuperiors, allBaseAfterSetTextureOffsetInferiors, "afterSetTextureOffset");
        initialized = true;
    }

    public static ModelPlayer[] getAllInstances() {
        return allInstances.toArray(new ModelPlayer[allInstances.size()]);
    }

    public static void beforeLocalConstructing(IModelPlayerAPI var0, float var1) {
        ModelPlayerAPI var2 = var0.getModelPlayerAPI();
        if (var2 != null) {
            var2.load();
        }
        allInstances.add(var0);
        if (var2 != null) {
            var2.beforeLocalConstructing(var1);
        }
    }

    public static void afterLocalConstructing(IModelPlayerAPI var0, float var1) {
        ModelPlayerAPI var2 = var0.getModelPlayerAPI();
        if (var2 != null) {
            var2.afterLocalConstructing(var1);
        }
    }

    public static ModelPlayerBase getModelPlayerBase(IModelPlayerAPI var0, String var1) {
        ModelPlayerAPI var2 = var0.getModelPlayerAPI();
        return var2 != null ? var2.getModelPlayerBase(var1) : null;
    }

    public static Set<String> getModelPlayerBaseIds(IModelPlayerAPI var0) {
        ModelPlayerAPI var1 = var0.getModelPlayerAPI();
        Set<String> var2 = null;
        var2 = var1 != null ? var1.getModelPlayerBaseIds() : Collections.emptySet();
        return var2;
    }

    public static float getExpandParameter(IModelPlayerAPI var0) {
        ModelPlayerAPI var1 = var0.getModelPlayerAPI();
        return var1 != null ? var1.paramFloat : 0.0f;
    }

    public static String getModelPlayerType(IModelPlayerAPI var0) {
        ModelPlayerAPI var1 = var0.getModelPlayerAPI();
        return var1 != null && var1.type != null ? var1.type : "other";
    }

    public static Object dynamic(IModelPlayerAPI var0, String var1, Object[] var2) {
        ModelPlayerAPI var3 = var0.getModelPlayerAPI();
        return var3 != null ? var3.dynamic(var1, var2) : null;
    }

    private static void sortBases(List<String> var0, Map<String, String[]> var1, Map<String, String[]> var2, String var3) {
        new ModelPlayerBaseSorter(var0, var1, var2, var3).Sort();
    }

    private static void sortDynamicBases(Map<String, List<String>> var0, Map<String, Map<String, String[]>> var1, Map<String, Map<String, String[]>> var2, String var3) {
        List<String> var4 = var0.get(var3);
        if (var4 != null && var4.size() > 1) {
            ModelPlayerAPI.sortBases(var4, ModelPlayerAPI.getDynamicSorters(var3, var4, var1), ModelPlayerAPI.getDynamicSorters(var3, var4, var2), var3);
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

    private ModelPlayerAPI(IModelPlayerAPI var1, float var2, String var3) {
        this.modelPlayer = var1;
        this.paramFloat = var2;
        this.type = var3;
    }

    private void load() {
        for (String var2 : allBaseConstructors.keySet()) {
            ModelPlayerBase var3 = this.createModelPlayerBase(var2);
            var3.beforeBaseAttach(false);
            this.allBaseObjects.put(var2, var3);
            this.baseObjectsToId.put(var3, var2);
        }
        this.beforeLocalConstructingHooks = this.create(beforeLocalConstructingHookTypes);
        this.afterLocalConstructingHooks = this.create(afterLocalConstructingHookTypes);
        this.updateModelPlayerBases();
        Iterator<String> var1 = this.allBaseObjects.keySet().iterator();
        while (var1.hasNext()) {
            this.allBaseObjects.get(var1.next()).afterBaseAttach(false);
        }
    }

    private ModelPlayerBase createModelPlayerBase(String var1) {
        Constructor<?> var2 = allBaseConstructors.get(var1);
        try {
            ModelPlayerBase var3 = var2.getParameterTypes().length == 1 ? (ModelPlayerBase)var2.newInstance(this) : (ModelPlayerBase)var2.newInstance(this, var1);
            return var3;
        }
        catch (Exception var5) {
            throw new RuntimeException("Exception while creating a ModelPlayerBase of type '" + var2.getDeclaringClass() + "'", var5);
        }
    }

    private void updateModelPlayerBases() {
        this.beforeGetRandomModelBoxHooks = this.create(beforeGetRandomModelBoxHookTypes);
        this.overrideGetRandomModelBoxHooks = this.create(overrideGetRandomModelBoxHookTypes);
        this.afterGetRandomModelBoxHooks = this.create(afterGetRandomModelBoxHookTypes);
        this.isGetRandomModelBoxModded = this.beforeGetRandomModelBoxHooks != null || this.overrideGetRandomModelBoxHooks != null || this.afterGetRandomModelBoxHooks != null;
        this.beforeGetTextureOffsetHooks = this.create(beforeGetTextureOffsetHookTypes);
        this.overrideGetTextureOffsetHooks = this.create(overrideGetTextureOffsetHookTypes);
        this.afterGetTextureOffsetHooks = this.create(afterGetTextureOffsetHookTypes);
        this.isGetTextureOffsetModded = this.beforeGetTextureOffsetHooks != null || this.overrideGetTextureOffsetHooks != null || this.afterGetTextureOffsetHooks != null;
        this.beforeRenderHooks = this.create(beforeRenderHookTypes);
        this.overrideRenderHooks = this.create(overrideRenderHookTypes);
        this.afterRenderHooks = this.create(afterRenderHookTypes);
        this.isRenderModded = this.beforeRenderHooks != null || this.overrideRenderHooks != null || this.afterRenderHooks != null;
        this.beforeRenderCloakHooks = this.create(beforeRenderCloakHookTypes);
        this.overrideRenderCloakHooks = this.create(overrideRenderCloakHookTypes);
        this.afterRenderCloakHooks = this.create(afterRenderCloakHookTypes);
        this.isRenderCloakModded = this.beforeRenderCloakHooks != null || this.overrideRenderCloakHooks != null || this.afterRenderCloakHooks != null;
        this.beforeRenderEarsHooks = this.create(beforeRenderEarsHookTypes);
        this.overrideRenderEarsHooks = this.create(overrideRenderEarsHookTypes);
        this.afterRenderEarsHooks = this.create(afterRenderEarsHookTypes);
        this.isRenderEarsModded = this.beforeRenderEarsHooks != null || this.overrideRenderEarsHooks != null || this.afterRenderEarsHooks != null;
        this.beforeSetLivingAnimationsHooks = this.create(beforeSetLivingAnimationsHookTypes);
        this.overrideSetLivingAnimationsHooks = this.create(overrideSetLivingAnimationsHookTypes);
        this.afterSetLivingAnimationsHooks = this.create(afterSetLivingAnimationsHookTypes);
        this.isSetLivingAnimationsModded = this.beforeSetLivingAnimationsHooks != null || this.overrideSetLivingAnimationsHooks != null || this.afterSetLivingAnimationsHooks != null;
        this.beforeSetRotationAnglesHooks = this.create(beforeSetRotationAnglesHookTypes);
        this.overrideSetRotationAnglesHooks = this.create(overrideSetRotationAnglesHookTypes);
        this.afterSetRotationAnglesHooks = this.create(afterSetRotationAnglesHookTypes);
        this.isSetRotationAnglesModded = this.beforeSetRotationAnglesHooks != null || this.overrideSetRotationAnglesHooks != null || this.afterSetRotationAnglesHooks != null;
        this.beforeSetTextureOffsetHooks = this.create(beforeSetTextureOffsetHookTypes);
        this.overrideSetTextureOffsetHooks = this.create(overrideSetTextureOffsetHookTypes);
        this.afterSetTextureOffsetHooks = this.create(afterSetTextureOffsetHookTypes);
        this.isSetTextureOffsetModded = this.beforeSetTextureOffsetHooks != null || this.overrideSetTextureOffsetHooks != null || this.afterSetTextureOffsetHooks != null;
    }

    private void attachModelPlayerBase(String var1) {
        ModelPlayerBase var2 = this.createModelPlayerBase(var1);
        var2.beforeBaseAttach(true);
        this.allBaseObjects.put(var1, var2);
        this.updateModelPlayerBases();
        var2.afterBaseAttach(true);
    }

    private void detachModelPlayerBase(String var1) {
        ModelPlayerBase var2 = this.allBaseObjects.get(var1);
        var2.beforeBaseDetach(true);
        this.allBaseObjects.remove(var1);
        this.updateModelPlayerBases();
        var2.afterBaseDetach(true);
    }

    private ModelPlayerBase[] create(List<String> var1) {
        if (var1.isEmpty()) {
            return null;
        }
        ModelPlayerBase[] var2 = new ModelPlayerBase[var1.size()];
        for (int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = this.getModelPlayerBase(var1.get(var3));
        }
        return var2;
    }

    private void beforeLocalConstructing(float var1) {
        if (this.beforeLocalConstructingHooks != null) {
            for (int var2 = this.beforeLocalConstructingHooks.length - 1; var2 >= 0; --var2) {
                this.beforeLocalConstructingHooks[var2].beforeLocalConstructing(var1);
            }
        }
        this.beforeLocalConstructingHooks = null;
    }

    private void afterLocalConstructing(float var1) {
        if (this.afterLocalConstructingHooks != null) {
            for (int var2 = 0; var2 < this.afterLocalConstructingHooks.length; ++var2) {
                this.afterLocalConstructingHooks[var2].afterLocalConstructing(var1);
            }
        }
        this.afterLocalConstructingHooks = null;
    }

    public ModelPlayerBase getModelPlayerBase(String var1) {
        return this.allBaseObjects.get(var1);
    }

    public Set<String> getModelPlayerBaseIds() {
        return this.unmodifiableAllBaseIds;
    }

    public Object dynamic(String var1, Object[] var2) {
        var1 = var1.replace('.', '_').replace(' ', '_');
        this.executeAll(var1, var2, beforeDynamicHookTypes, beforeDynamicHookMethods, true);
        Object var3 = this.dynamicOverwritten(var1, var2, null);
        this.executeAll(var1, var2, afterDynamicHookTypes, afterDynamicHookMethods, false);
        return var3;
    }

    public Object dynamicOverwritten(String var1, Object[] var2, ModelPlayerBase var3) {
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
        return var7 == null ? null : this.execute(this.getModelPlayerBase(var5), var8, var2);
    }

    private void executeAll(String var1, Object[] var2, Map<String, List<String>> var3, Map<Class<?>, Map<String, Method>> var4, boolean var5) {
        List<String> var6 = var3.get(var1);
        if (var6 != null) {
            int var7;
            int n = var7 = var5 ? var6.size() - 1 : 0;
            while (!(!var5 ? var7 >= var6.size() : var7 < 0)) {
                Method var12;
                String var8 = var6.get(var7);
                ModelPlayerBase var9 = this.getModelPlayerBase(var8);
                Class<?> var10 = var9.getClass();
                Map<String, Method> var11 = var4.get(var10);
                if (var11 != null && (var12 = var11.get(var1)) != null) {
                    this.execute(var9, var12, var2);
                }
                var7 += var5 ? -1 : 1;
            }
        }
    }

    private Object execute(ModelPlayerBase var1, Method var2, Object[] var3) {
        try {
            return var2.invoke(var1, var3);
        }
        catch (Exception var5) {
            throw new RuntimeException("Exception while invoking dynamic method", var5);
        }
    }

    public static ModelRenderer getRandomModelBox(IModelPlayerAPI var0, Random var1) {
        ModelPlayerAPI var3 = var0.getModelPlayerAPI();
        ModelRenderer var2 = var3 != null && var3.isGetRandomModelBoxModded ? var3.getRandomModelBox(var1) : var0.localGetRandomModelBox(var1);
        return var2;
    }

    private ModelRenderer getRandomModelBox(Random var1) {
        if (this.beforeGetRandomModelBoxHooks != null) {
            for (int var2 = this.beforeGetRandomModelBoxHooks.length - 1; var2 >= 0; --var2) {
                this.beforeGetRandomModelBoxHooks[var2].beforeGetRandomModelBox(var1);
            }
        }
        ModelRenderer var4 = this.overrideGetRandomModelBoxHooks != null ? this.overrideGetRandomModelBoxHooks[this.overrideGetRandomModelBoxHooks.length - 1].getRandomModelBox(var1) : this.modelPlayer.localGetRandomModelBox(var1);
        if (this.afterGetRandomModelBoxHooks != null) {
            for (int var3 = 0; var3 < this.afterGetRandomModelBoxHooks.length; ++var3) {
                this.afterGetRandomModelBoxHooks[var3].afterGetRandomModelBox(var1);
            }
        }
        return var4;
    }

    protected ModelPlayerBase GetOverwrittenGetRandomModelBox(ModelPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideGetRandomModelBoxHooks.length; ++var2) {
            if (this.overrideGetRandomModelBoxHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideGetRandomModelBoxHooks[var2 - 1];
        }
        return var1;
    }

    public static TextureOffset getTextureOffset(IModelPlayerAPI var0, String var1) {
        ModelPlayerAPI var3 = var0.getModelPlayerAPI();
        TextureOffset var2 = var3 != null && var3.isGetTextureOffsetModded ? var3.getTextureOffset(var1) : var0.localGetTextureOffset(var1);
        return var2;
    }

    private TextureOffset getTextureOffset(String var1) {
        if (this.beforeGetTextureOffsetHooks != null) {
            for (int var2 = this.beforeGetTextureOffsetHooks.length - 1; var2 >= 0; --var2) {
                this.beforeGetTextureOffsetHooks[var2].beforeGetTextureOffset(var1);
            }
        }
        TextureOffset var4 = this.overrideGetTextureOffsetHooks != null ? this.overrideGetTextureOffsetHooks[this.overrideGetTextureOffsetHooks.length - 1].getTextureOffset(var1) : this.modelPlayer.localGetTextureOffset(var1);
        if (this.afterGetTextureOffsetHooks != null) {
            for (int var3 = 0; var3 < this.afterGetTextureOffsetHooks.length; ++var3) {
                this.afterGetTextureOffsetHooks[var3].afterGetTextureOffset(var1);
            }
        }
        return var4;
    }

    protected ModelPlayerBase GetOverwrittenGetTextureOffset(ModelPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideGetTextureOffsetHooks.length; ++var2) {
            if (this.overrideGetTextureOffsetHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideGetTextureOffsetHooks[var2 - 1];
        }
        return var1;
    }

    public static void render(IModelPlayerAPI var0, Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        ModelPlayerAPI var8 = var0.getModelPlayerAPI();
        if (var8 != null && var8.isRenderModded) {
            var8.render(var1, var2, var3, var4, var5, var6, var7);
        } else {
            var0.localRender(var1, var2, var3, var4, var5, var6, var7);
        }
    }

    private void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
        int var8;
        if (this.beforeRenderHooks != null) {
            for (var8 = this.beforeRenderHooks.length - 1; var8 >= 0; --var8) {
                this.beforeRenderHooks[var8].beforeRender(var1, var2, var3, var4, var5, var6, var7);
            }
        }
        if (this.overrideRenderHooks != null) {
            this.overrideRenderHooks[this.overrideRenderHooks.length - 1].render(var1, var2, var3, var4, var5, var6, var7);
        } else {
            this.modelPlayer.localRender(var1, var2, var3, var4, var5, var6, var7);
        }
        if (this.afterRenderHooks != null) {
            for (var8 = 0; var8 < this.afterRenderHooks.length; ++var8) {
                this.afterRenderHooks[var8].afterRender(var1, var2, var3, var4, var5, var6, var7);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenRender(ModelPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderHooks.length; ++var2) {
            if (this.overrideRenderHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderHooks[var2 - 1];
        }
        return var1;
    }

    public static void renderCloak(IModelPlayerAPI var0, float var1) {
        ModelPlayerAPI var2 = var0.getModelPlayerAPI();
        if (var2 != null && var2.isRenderCloakModded) {
            var2.renderCloak(var1);
        } else {
            var0.localRenderCloak(var1);
        }
    }

    private void renderCloak(float var1) {
        int var2;
        if (this.beforeRenderCloakHooks != null) {
            for (var2 = this.beforeRenderCloakHooks.length - 1; var2 >= 0; --var2) {
                this.beforeRenderCloakHooks[var2].beforeRenderCloak(var1);
            }
        }
        if (this.overrideRenderCloakHooks != null) {
            this.overrideRenderCloakHooks[this.overrideRenderCloakHooks.length - 1].renderCloak(var1);
        } else {
            this.modelPlayer.localRenderCloak(var1);
        }
        if (this.afterRenderCloakHooks != null) {
            for (var2 = 0; var2 < this.afterRenderCloakHooks.length; ++var2) {
                this.afterRenderCloakHooks[var2].afterRenderCloak(var1);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenRenderCloak(ModelPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderCloakHooks.length; ++var2) {
            if (this.overrideRenderCloakHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderCloakHooks[var2 - 1];
        }
        return var1;
    }

    public static void renderEars(IModelPlayerAPI var0, float var1) {
        ModelPlayerAPI var2 = var0.getModelPlayerAPI();
        if (var2 != null && var2.isRenderEarsModded) {
            var2.renderEars(var1);
        } else {
            var0.localRenderEars(var1);
        }
    }

    private void renderEars(float var1) {
        int var2;
        if (this.beforeRenderEarsHooks != null) {
            for (var2 = this.beforeRenderEarsHooks.length - 1; var2 >= 0; --var2) {
                this.beforeRenderEarsHooks[var2].beforeRenderEars(var1);
            }
        }
        if (this.overrideRenderEarsHooks != null) {
            this.overrideRenderEarsHooks[this.overrideRenderEarsHooks.length - 1].renderEars(var1);
        } else {
            this.modelPlayer.localRenderEars(var1);
        }
        if (this.afterRenderEarsHooks != null) {
            for (var2 = 0; var2 < this.afterRenderEarsHooks.length; ++var2) {
                this.afterRenderEarsHooks[var2].afterRenderEars(var1);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenRenderEars(ModelPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideRenderEarsHooks.length; ++var2) {
            if (this.overrideRenderEarsHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideRenderEarsHooks[var2 - 1];
        }
        return var1;
    }

    public static void setLivingAnimations(IModelPlayerAPI var0, EntityLivingBase var1, float var2, float var3, float var4) {
        ModelPlayerAPI var5 = var0.getModelPlayerAPI();
        if (var5 != null && var5.isSetLivingAnimationsModded) {
            var5.setLivingAnimations(var1, var2, var3, var4);
        } else {
            var0.localSetLivingAnimations(var1, var2, var3, var4);
        }
    }

    private void setLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4) {
        int var5;
        if (this.beforeSetLivingAnimationsHooks != null) {
            for (var5 = this.beforeSetLivingAnimationsHooks.length - 1; var5 >= 0; --var5) {
                this.beforeSetLivingAnimationsHooks[var5].beforeSetLivingAnimations(var1, var2, var3, var4);
            }
        }
        if (this.overrideSetLivingAnimationsHooks != null) {
            this.overrideSetLivingAnimationsHooks[this.overrideSetLivingAnimationsHooks.length - 1].setLivingAnimations(var1, var2, var3, var4);
        } else {
            this.modelPlayer.localSetLivingAnimations(var1, var2, var3, var4);
        }
        if (this.afterSetLivingAnimationsHooks != null) {
            for (var5 = 0; var5 < this.afterSetLivingAnimationsHooks.length; ++var5) {
                this.afterSetLivingAnimationsHooks[var5].afterSetLivingAnimations(var1, var2, var3, var4);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenSetLivingAnimations(ModelPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideSetLivingAnimationsHooks.length; ++var2) {
            if (this.overrideSetLivingAnimationsHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideSetLivingAnimationsHooks[var2 - 1];
        }
        return var1;
    }

    public static void setRotationAngles(IModelPlayerAPI var0, float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
        ModelPlayerAPI var8 = var0.getModelPlayerAPI();
        if (var8 != null && var8.isSetRotationAnglesModded) {
            var8.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
        } else {
            var0.localSetRotationAngles(var1, var2, var3, var4, var5, var6, var7);
        }
    }

    private void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
        int var8;
        if (this.beforeSetRotationAnglesHooks != null) {
            for (var8 = this.beforeSetRotationAnglesHooks.length - 1; var8 >= 0; --var8) {
                this.beforeSetRotationAnglesHooks[var8].beforeSetRotationAngles(var1, var2, var3, var4, var5, var6, var7);
            }
        }
        if (this.overrideSetRotationAnglesHooks != null) {
            this.overrideSetRotationAnglesHooks[this.overrideSetRotationAnglesHooks.length - 1].setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
        } else {
            this.modelPlayer.localSetRotationAngles(var1, var2, var3, var4, var5, var6, var7);
        }
        if (this.afterSetRotationAnglesHooks != null) {
            for (var8 = 0; var8 < this.afterSetRotationAnglesHooks.length; ++var8) {
                this.afterSetRotationAnglesHooks[var8].afterSetRotationAngles(var1, var2, var3, var4, var5, var6, var7);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenSetRotationAngles(ModelPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideSetRotationAnglesHooks.length; ++var2) {
            if (this.overrideSetRotationAnglesHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideSetRotationAnglesHooks[var2 - 1];
        }
        return var1;
    }

    public static void setTextureOffset(IModelPlayerAPI var0, String var1, int var2, int var3) {
        ModelPlayerAPI var4 = var0.getModelPlayerAPI();
        if (var4 != null && var4.isSetTextureOffsetModded) {
            var4.setTextureOffset(var1, var2, var3);
        } else {
            var0.localSetTextureOffset(var1, var2, var3);
        }
    }

    private void setTextureOffset(String var1, int var2, int var3) {
        int var4;
        if (this.beforeSetTextureOffsetHooks != null) {
            for (var4 = this.beforeSetTextureOffsetHooks.length - 1; var4 >= 0; --var4) {
                this.beforeSetTextureOffsetHooks[var4].beforeSetTextureOffset(var1, var2, var3);
            }
        }
        if (this.overrideSetTextureOffsetHooks != null) {
            this.overrideSetTextureOffsetHooks[this.overrideSetTextureOffsetHooks.length - 1].setTextureOffset(var1, var2, var3);
        } else {
            this.modelPlayer.localSetTextureOffset(var1, var2, var3);
        }
        if (this.afterSetTextureOffsetHooks != null) {
            for (var4 = 0; var4 < this.afterSetTextureOffsetHooks.length; ++var4) {
                this.afterSetTextureOffsetHooks[var4].afterSetTextureOffset(var1, var2, var3);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenSetTextureOffset(ModelPlayerBase var1) {
        for (int var2 = 0; var2 < this.overrideSetTextureOffsetHooks.length; ++var2) {
            if (this.overrideSetTextureOffsetHooks[var2] != var1) continue;
            if (var2 == 0) {
                return null;
            }
            return this.overrideSetTextureOffsetHooks[var2 - 1];
        }
        return var1;
    }

    static {
        logger = Logger.getLogger("ModelPlayerAPI");
        allInstances = new ArrayList<IModelPlayerAPI>();
        EmptySortMap = Collections.unmodifiableMap(new HashMap());
        beforeGetRandomModelBoxHookTypes = new LinkedList<String>();
        overrideGetRandomModelBoxHookTypes = new LinkedList<String>();
        afterGetRandomModelBoxHookTypes = new LinkedList<String>();
        allBaseBeforeGetRandomModelBoxSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetRandomModelBoxInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetRandomModelBoxSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetRandomModelBoxInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetRandomModelBoxSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetRandomModelBoxInferiors = new Hashtable<String, String[]>(0);
        beforeGetTextureOffsetHookTypes = new LinkedList<String>();
        overrideGetTextureOffsetHookTypes = new LinkedList<String>();
        afterGetTextureOffsetHookTypes = new LinkedList<String>();
        allBaseBeforeGetTextureOffsetSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeGetTextureOffsetInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetTextureOffsetSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideGetTextureOffsetInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetTextureOffsetSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterGetTextureOffsetInferiors = new Hashtable<String, String[]>(0);
        beforeRenderHookTypes = new LinkedList<String>();
        overrideRenderHookTypes = new LinkedList<String>();
        afterRenderHookTypes = new LinkedList<String>();
        allBaseBeforeRenderSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderInferiors = new Hashtable<String, String[]>(0);
        beforeRenderCloakHookTypes = new LinkedList<String>();
        overrideRenderCloakHookTypes = new LinkedList<String>();
        afterRenderCloakHookTypes = new LinkedList<String>();
        allBaseBeforeRenderCloakSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderCloakInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderCloakSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderCloakInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderCloakSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderCloakInferiors = new Hashtable<String, String[]>(0);
        beforeRenderEarsHookTypes = new LinkedList<String>();
        overrideRenderEarsHookTypes = new LinkedList<String>();
        afterRenderEarsHookTypes = new LinkedList<String>();
        allBaseBeforeRenderEarsSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeRenderEarsInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderEarsSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideRenderEarsInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderEarsSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterRenderEarsInferiors = new Hashtable<String, String[]>(0);
        beforeSetLivingAnimationsHookTypes = new LinkedList<String>();
        overrideSetLivingAnimationsHookTypes = new LinkedList<String>();
        afterSetLivingAnimationsHookTypes = new LinkedList<String>();
        allBaseBeforeSetLivingAnimationsSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetLivingAnimationsInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetLivingAnimationsSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetLivingAnimationsInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetLivingAnimationsSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetLivingAnimationsInferiors = new Hashtable<String, String[]>(0);
        beforeSetRotationAnglesHookTypes = new LinkedList<String>();
        overrideSetRotationAnglesHookTypes = new LinkedList<String>();
        afterSetRotationAnglesHookTypes = new LinkedList<String>();
        allBaseBeforeSetRotationAnglesSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetRotationAnglesInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetRotationAnglesSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetRotationAnglesInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetRotationAnglesSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetRotationAnglesInferiors = new Hashtable<String, String[]>(0);
        beforeSetTextureOffsetHookTypes = new LinkedList<String>();
        overrideSetTextureOffsetHookTypes = new LinkedList<String>();
        afterSetTextureOffsetHookTypes = new LinkedList<String>();
        allBaseBeforeSetTextureOffsetSuperiors = new Hashtable<String, String[]>(0);
        allBaseBeforeSetTextureOffsetInferiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetTextureOffsetSuperiors = new Hashtable<String, String[]>(0);
        allBaseOverrideSetTextureOffsetInferiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetTextureOffsetSuperiors = new Hashtable<String, String[]>(0);
        allBaseAfterSetTextureOffsetInferiors = new Hashtable<String, String[]>(0);
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

