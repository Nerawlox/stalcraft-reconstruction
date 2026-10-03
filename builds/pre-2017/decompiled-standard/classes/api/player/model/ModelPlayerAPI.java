/*
 * Decompiled with CFR 0.152.
 */
package api.player.model;

import api.player.model.ModelPlayer;
import api.player.model.ModelPlayerBase;
import api.player.model.ModelPlayerBaseSorter;
import api.player.model.ModelPlayerBaseSorting;
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
    private static ModelPlayer[] allInstances;
    private static final Map<String, String[]> EmptySortMap;
    private static final Object[] initializer;
    private static final Object[] initializers;
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
    protected final ModelPlayer modelPlayer;
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

    private static void log(String string) {
        System.out.println(string);
        logger.fine(string);
    }

    private static String error(String string) {
        logger.severe(string);
        return string;
    }

    public static void register(String string, Class<?> clazz) {
        ModelPlayerAPI.register(string, clazz, null);
    }

    public static void register(String string, Class<?> clazz, ModelPlayerBaseSorting modelPlayerBaseSorting) {
        try {
            ModelPlayerAPI.register(clazz, string, modelPlayerBaseSorting);
        }
        catch (RuntimeException runtimeException) {
            if (string != null) {
                ModelPlayerAPI.log("Model Player: failed to register id '" + string + "'");
            } else {
                ModelPlayerAPI.log("Model Player: failed to register ModelPlayerBase");
            }
            throw runtimeException;
        }
    }

    /*
     * WARNING - void declaration
     */
    private static void register(Class<?> clazz, String string, ModelPlayerBaseSorting modelPlayerBaseSorting) {
        Constructor<?> constructor;
        Executable executable;
        if (!isCreated) {
            try {
                executable = ModelPlayer.class.getMethod("getModelPlayerBase", String.class);
                if (((Method)executable).getReturnType() != ModelPlayerBase.class) {
                    throw new NoSuchMethodException(ModelPlayerBase.class.getName() + " " + ModelPlayer.class.getName() + ".getModelPlayerBase(" + String.class.getName() + ")");
                }
            }
            catch (NoSuchMethodException noSuchMethodException) {
                void var9_22;
                void object;
                String[] stringArray = new String[]{"========================================", "The API \"Model Player\" version 1.0 of the mod \"Render Player API forge 1.0\" can not be created!", "----------------------------------------", "Mandatory member method \"{0} getModelPlayerBase({3})\" not found in class \"{1}\".", "There are three scenarios this can happen:", "* Minecraft Forge is missing a Render Player API forge which Minecraft version matches its own.", "  Download and install the latest Render Player API forge for the Minecraft version you were trying to run.", "* The code of the class \"{2}\" of Render Player API forge has been modified beyond recognition by another Minecraft Forge coremod.", "  Try temporary deinstallation of other core mods to find the culprit and deinstall it permanently to fix this specific problem.", "* Render Player API forge has not been installed correctly.", "  Deinstall Render Player API forge and install it again following the installation instructions in the readme file.", "========================================"};
                String string2 = ModelPlayerBase.class.getName();
                String string3 = ModelPlayer.class.getName();
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
            ModelPlayerAPI.log("Model Player 1.0 Created");
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
                throw new IllegalArgumentException("Can not find necessary constructor with one argument of type '" + ModelPlayerAPI.class.getName() + "' and eventually a second argument of type 'String' in the class '" + clazz.getName() + "'", throwable);
            }
        }
        allBaseConstructors.put(string, constructor);
        if (modelPlayerBaseSorting != null) {
            ModelPlayerAPI.addSorting(string, allBaseBeforeLocalConstructingSuperiors, modelPlayerBaseSorting.getBeforeLocalConstructingSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeLocalConstructingInferiors, modelPlayerBaseSorting.getBeforeLocalConstructingInferiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterLocalConstructingSuperiors, modelPlayerBaseSorting.getAfterLocalConstructingSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterLocalConstructingInferiors, modelPlayerBaseSorting.getAfterLocalConstructingInferiors());
            ModelPlayerAPI.addDynamicSorting(string, allBaseBeforeDynamicSuperiors, modelPlayerBaseSorting.getDynamicBeforeSuperiors());
            ModelPlayerAPI.addDynamicSorting(string, allBaseBeforeDynamicInferiors, modelPlayerBaseSorting.getDynamicBeforeInferiors());
            ModelPlayerAPI.addDynamicSorting(string, allBaseOverrideDynamicSuperiors, modelPlayerBaseSorting.getDynamicOverrideSuperiors());
            ModelPlayerAPI.addDynamicSorting(string, allBaseOverrideDynamicInferiors, modelPlayerBaseSorting.getDynamicOverrideInferiors());
            ModelPlayerAPI.addDynamicSorting(string, allBaseAfterDynamicSuperiors, modelPlayerBaseSorting.getDynamicAfterSuperiors());
            ModelPlayerAPI.addDynamicSorting(string, allBaseAfterDynamicInferiors, modelPlayerBaseSorting.getDynamicAfterInferiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeGetRandomModelBoxSuperiors, modelPlayerBaseSorting.getBeforeGetRandomModelBoxSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeGetRandomModelBoxInferiors, modelPlayerBaseSorting.getBeforeGetRandomModelBoxInferiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideGetRandomModelBoxSuperiors, modelPlayerBaseSorting.getOverrideGetRandomModelBoxSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideGetRandomModelBoxInferiors, modelPlayerBaseSorting.getOverrideGetRandomModelBoxInferiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterGetRandomModelBoxSuperiors, modelPlayerBaseSorting.getAfterGetRandomModelBoxSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterGetRandomModelBoxInferiors, modelPlayerBaseSorting.getAfterGetRandomModelBoxInferiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeGetTextureOffsetSuperiors, modelPlayerBaseSorting.getBeforeGetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeGetTextureOffsetInferiors, modelPlayerBaseSorting.getBeforeGetTextureOffsetInferiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideGetTextureOffsetSuperiors, modelPlayerBaseSorting.getOverrideGetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideGetTextureOffsetInferiors, modelPlayerBaseSorting.getOverrideGetTextureOffsetInferiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterGetTextureOffsetSuperiors, modelPlayerBaseSorting.getAfterGetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterGetTextureOffsetInferiors, modelPlayerBaseSorting.getAfterGetTextureOffsetInferiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeRenderSuperiors, modelPlayerBaseSorting.getBeforeRenderSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeRenderInferiors, modelPlayerBaseSorting.getBeforeRenderInferiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideRenderSuperiors, modelPlayerBaseSorting.getOverrideRenderSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideRenderInferiors, modelPlayerBaseSorting.getOverrideRenderInferiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterRenderSuperiors, modelPlayerBaseSorting.getAfterRenderSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterRenderInferiors, modelPlayerBaseSorting.getAfterRenderInferiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeRenderCloakSuperiors, modelPlayerBaseSorting.getBeforeRenderCloakSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeRenderCloakInferiors, modelPlayerBaseSorting.getBeforeRenderCloakInferiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideRenderCloakSuperiors, modelPlayerBaseSorting.getOverrideRenderCloakSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideRenderCloakInferiors, modelPlayerBaseSorting.getOverrideRenderCloakInferiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterRenderCloakSuperiors, modelPlayerBaseSorting.getAfterRenderCloakSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterRenderCloakInferiors, modelPlayerBaseSorting.getAfterRenderCloakInferiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeRenderEarsSuperiors, modelPlayerBaseSorting.getBeforeRenderEarsSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeRenderEarsInferiors, modelPlayerBaseSorting.getBeforeRenderEarsInferiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideRenderEarsSuperiors, modelPlayerBaseSorting.getOverrideRenderEarsSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideRenderEarsInferiors, modelPlayerBaseSorting.getOverrideRenderEarsInferiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterRenderEarsSuperiors, modelPlayerBaseSorting.getAfterRenderEarsSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterRenderEarsInferiors, modelPlayerBaseSorting.getAfterRenderEarsInferiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeSetLivingAnimationsSuperiors, modelPlayerBaseSorting.getBeforeSetLivingAnimationsSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeSetLivingAnimationsInferiors, modelPlayerBaseSorting.getBeforeSetLivingAnimationsInferiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideSetLivingAnimationsSuperiors, modelPlayerBaseSorting.getOverrideSetLivingAnimationsSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideSetLivingAnimationsInferiors, modelPlayerBaseSorting.getOverrideSetLivingAnimationsInferiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterSetLivingAnimationsSuperiors, modelPlayerBaseSorting.getAfterSetLivingAnimationsSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterSetLivingAnimationsInferiors, modelPlayerBaseSorting.getAfterSetLivingAnimationsInferiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeSetRotationAnglesSuperiors, modelPlayerBaseSorting.getBeforeSetRotationAnglesSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeSetRotationAnglesInferiors, modelPlayerBaseSorting.getBeforeSetRotationAnglesInferiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideSetRotationAnglesSuperiors, modelPlayerBaseSorting.getOverrideSetRotationAnglesSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideSetRotationAnglesInferiors, modelPlayerBaseSorting.getOverrideSetRotationAnglesInferiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterSetRotationAnglesSuperiors, modelPlayerBaseSorting.getAfterSetRotationAnglesSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterSetRotationAnglesInferiors, modelPlayerBaseSorting.getAfterSetRotationAnglesInferiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeSetTextureOffsetSuperiors, modelPlayerBaseSorting.getBeforeSetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseBeforeSetTextureOffsetInferiors, modelPlayerBaseSorting.getBeforeSetTextureOffsetInferiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideSetTextureOffsetSuperiors, modelPlayerBaseSorting.getOverrideSetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseOverrideSetTextureOffsetInferiors, modelPlayerBaseSorting.getOverrideSetTextureOffsetInferiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterSetTextureOffsetSuperiors, modelPlayerBaseSorting.getAfterSetTextureOffsetSuperiors());
            ModelPlayerAPI.addSorting(string, allBaseAfterSetTextureOffsetInferiors, modelPlayerBaseSorting.getAfterSetTextureOffsetInferiors());
        }
        ModelPlayerAPI.addMethod(string, clazz, beforeLocalConstructingHookTypes, "beforeLocalConstructing", Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, afterLocalConstructingHookTypes, "afterLocalConstructing", Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, beforeGetRandomModelBoxHookTypes, "beforeGetRandomModelBox", Random.class);
        ModelPlayerAPI.addMethod(string, clazz, overrideGetRandomModelBoxHookTypes, "getRandomModelBox", Random.class);
        ModelPlayerAPI.addMethod(string, clazz, afterGetRandomModelBoxHookTypes, "afterGetRandomModelBox", Random.class);
        ModelPlayerAPI.addMethod(string, clazz, beforeGetTextureOffsetHookTypes, "beforeGetTextureOffset", String.class);
        ModelPlayerAPI.addMethod(string, clazz, overrideGetTextureOffsetHookTypes, "getTextureOffset", String.class);
        ModelPlayerAPI.addMethod(string, clazz, afterGetTextureOffsetHookTypes, "afterGetTextureOffset", String.class);
        ModelPlayerAPI.addMethod(string, clazz, beforeRenderHookTypes, "beforeRender", Entity.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, overrideRenderHookTypes, "render", Entity.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, afterRenderHookTypes, "afterRender", Entity.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, beforeRenderCloakHookTypes, "beforeRenderCloak", Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, overrideRenderCloakHookTypes, "renderCloak", Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, afterRenderCloakHookTypes, "afterRenderCloak", Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, beforeRenderEarsHookTypes, "beforeRenderEars", Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, overrideRenderEarsHookTypes, "renderEars", Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, afterRenderEarsHookTypes, "afterRenderEars", Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, beforeSetLivingAnimationsHookTypes, "beforeSetLivingAnimations", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, overrideSetLivingAnimationsHookTypes, "setLivingAnimations", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, afterSetLivingAnimationsHookTypes, "afterSetLivingAnimations", EntityLivingBase.class, Float.TYPE, Float.TYPE, Float.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, beforeSetRotationAnglesHookTypes, "beforeSetRotationAngles", Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Entity.class);
        ModelPlayerAPI.addMethod(string, clazz, overrideSetRotationAnglesHookTypes, "setRotationAngles", Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Entity.class);
        ModelPlayerAPI.addMethod(string, clazz, afterSetRotationAnglesHookTypes, "afterSetRotationAngles", Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Entity.class);
        ModelPlayerAPI.addMethod(string, clazz, beforeSetTextureOffsetHookTypes, "beforeSetTextureOffset", String.class, Integer.TYPE, Integer.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, overrideSetTextureOffsetHookTypes, "setTextureOffset", String.class, Integer.TYPE, Integer.TYPE);
        ModelPlayerAPI.addMethod(string, clazz, afterSetTextureOffsetHookTypes, "afterSetTextureOffset", String.class, Integer.TYPE, Integer.TYPE);
        ModelPlayerAPI.addDynamicMethods(string, clazz);
        ModelPlayerAPI.addDynamicKeys(string, clazz, beforeDynamicHookMethods, beforeDynamicHookTypes);
        ModelPlayerAPI.addDynamicKeys(string, clazz, overrideDynamicHookMethods, overrideDynamicHookTypes);
        ModelPlayerAPI.addDynamicKeys(string, clazz, afterDynamicHookMethods, afterDynamicHookTypes);
        ModelPlayerAPI.initialize();
        for (ModelPlayer modelPlayer : ModelPlayerAPI.getAllInstances()) {
            modelPlayer.modelPlayerAPI.attachModelPlayerBase(string);
        }
        System.out.println("Model Player: registered " + string);
        logger.fine("Model Player: registered class '" + clazz.getName() + "' with id '" + string + "'");
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
        for (ModelPlayer object : ModelPlayerAPI.getAllInstances()) {
            object.modelPlayerAPI.detachModelPlayerBase(string);
        }
        beforeLocalConstructingHookTypes.remove(string);
        afterLocalConstructingHookTypes.remove(string);
        allBaseBeforeGetRandomModelBoxSuperiors.remove(string);
        allBaseBeforeGetRandomModelBoxInferiors.remove(string);
        allBaseOverrideGetRandomModelBoxSuperiors.remove(string);
        allBaseOverrideGetRandomModelBoxInferiors.remove(string);
        allBaseAfterGetRandomModelBoxSuperiors.remove(string);
        allBaseAfterGetRandomModelBoxInferiors.remove(string);
        beforeGetRandomModelBoxHookTypes.remove(string);
        overrideGetRandomModelBoxHookTypes.remove(string);
        afterGetRandomModelBoxHookTypes.remove(string);
        allBaseBeforeGetTextureOffsetSuperiors.remove(string);
        allBaseBeforeGetTextureOffsetInferiors.remove(string);
        allBaseOverrideGetTextureOffsetSuperiors.remove(string);
        allBaseOverrideGetTextureOffsetInferiors.remove(string);
        allBaseAfterGetTextureOffsetSuperiors.remove(string);
        allBaseAfterGetTextureOffsetInferiors.remove(string);
        beforeGetTextureOffsetHookTypes.remove(string);
        overrideGetTextureOffsetHookTypes.remove(string);
        afterGetTextureOffsetHookTypes.remove(string);
        allBaseBeforeRenderSuperiors.remove(string);
        allBaseBeforeRenderInferiors.remove(string);
        allBaseOverrideRenderSuperiors.remove(string);
        allBaseOverrideRenderInferiors.remove(string);
        allBaseAfterRenderSuperiors.remove(string);
        allBaseAfterRenderInferiors.remove(string);
        beforeRenderHookTypes.remove(string);
        overrideRenderHookTypes.remove(string);
        afterRenderHookTypes.remove(string);
        allBaseBeforeRenderCloakSuperiors.remove(string);
        allBaseBeforeRenderCloakInferiors.remove(string);
        allBaseOverrideRenderCloakSuperiors.remove(string);
        allBaseOverrideRenderCloakInferiors.remove(string);
        allBaseAfterRenderCloakSuperiors.remove(string);
        allBaseAfterRenderCloakInferiors.remove(string);
        beforeRenderCloakHookTypes.remove(string);
        overrideRenderCloakHookTypes.remove(string);
        afterRenderCloakHookTypes.remove(string);
        allBaseBeforeRenderEarsSuperiors.remove(string);
        allBaseBeforeRenderEarsInferiors.remove(string);
        allBaseOverrideRenderEarsSuperiors.remove(string);
        allBaseOverrideRenderEarsInferiors.remove(string);
        allBaseAfterRenderEarsSuperiors.remove(string);
        allBaseAfterRenderEarsInferiors.remove(string);
        beforeRenderEarsHookTypes.remove(string);
        overrideRenderEarsHookTypes.remove(string);
        afterRenderEarsHookTypes.remove(string);
        allBaseBeforeSetLivingAnimationsSuperiors.remove(string);
        allBaseBeforeSetLivingAnimationsInferiors.remove(string);
        allBaseOverrideSetLivingAnimationsSuperiors.remove(string);
        allBaseOverrideSetLivingAnimationsInferiors.remove(string);
        allBaseAfterSetLivingAnimationsSuperiors.remove(string);
        allBaseAfterSetLivingAnimationsInferiors.remove(string);
        beforeSetLivingAnimationsHookTypes.remove(string);
        overrideSetLivingAnimationsHookTypes.remove(string);
        afterSetLivingAnimationsHookTypes.remove(string);
        allBaseBeforeSetRotationAnglesSuperiors.remove(string);
        allBaseBeforeSetRotationAnglesInferiors.remove(string);
        allBaseOverrideSetRotationAnglesSuperiors.remove(string);
        allBaseOverrideSetRotationAnglesInferiors.remove(string);
        allBaseAfterSetRotationAnglesSuperiors.remove(string);
        allBaseAfterSetRotationAnglesInferiors.remove(string);
        beforeSetRotationAnglesHookTypes.remove(string);
        overrideSetRotationAnglesHookTypes.remove(string);
        afterSetRotationAnglesHookTypes.remove(string);
        allBaseBeforeSetTextureOffsetSuperiors.remove(string);
        allBaseBeforeSetTextureOffsetInferiors.remove(string);
        allBaseOverrideSetTextureOffsetSuperiors.remove(string);
        allBaseOverrideSetTextureOffsetInferiors.remove(string);
        allBaseAfterSetTextureOffsetSuperiors.remove(string);
        allBaseAfterSetTextureOffsetInferiors.remove(string);
        beforeSetTextureOffsetHookTypes.remove(string);
        overrideSetTextureOffsetHookTypes.remove(string);
        afterSetTextureOffsetHookTypes.remove(string);
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
        ModelPlayerAPI.removeDynamicHookTypes(string, beforeDynamicHookTypes);
        ModelPlayerAPI.removeDynamicHookTypes(string, overrideDynamicHookTypes);
        ModelPlayerAPI.removeDynamicHookTypes(string, afterDynamicHookTypes);
        allBaseBeforeDynamicSuperiors.remove(string);
        allBaseBeforeDynamicInferiors.remove(string);
        allBaseOverrideDynamicSuperiors.remove(string);
        allBaseOverrideDynamicInferiors.remove(string);
        allBaseAfterDynamicSuperiors.remove(string);
        allBaseAfterDynamicInferiors.remove(string);
        ModelPlayerAPI.log("ModelPlayerAPI: unregistered id '" + string + "'");
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
            boolean bl2 = bl = method.getDeclaringClass() != ModelPlayerBase.class;
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
                map = ModelPlayerAPI.addDynamicMethod(string2, method, map);
                continue;
            }
            if (bl) {
                map2 = ModelPlayerAPI.addDynamicMethod(string2, method, map2);
                continue;
            }
            if (bl4) {
                map4 = ModelPlayerAPI.addDynamicMethod(string2, method, map4);
                continue;
            }
            map3 = ModelPlayerAPI.addDynamicMethod(string2, method, map3);
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

    public static ModelPlayerAPI create(ModelPlayer modelPlayer) {
        if (allBaseConstructors.size() > 0 && !initialized) {
            ModelPlayerAPI.initialize();
        }
        return new ModelPlayerAPI(modelPlayer);
    }

    private static void initialize() {
        ModelPlayerAPI.sortBases(beforeLocalConstructingHookTypes, allBaseBeforeLocalConstructingSuperiors, allBaseBeforeLocalConstructingInferiors, "beforeLocalConstructing");
        ModelPlayerAPI.sortBases(afterLocalConstructingHookTypes, allBaseAfterLocalConstructingSuperiors, allBaseAfterLocalConstructingInferiors, "afterLocalConstructing");
        for (String string : keys) {
            ModelPlayerAPI.sortDynamicBases(beforeDynamicHookTypes, allBaseBeforeDynamicSuperiors, allBaseBeforeDynamicInferiors, string);
            ModelPlayerAPI.sortDynamicBases(overrideDynamicHookTypes, allBaseOverrideDynamicSuperiors, allBaseOverrideDynamicInferiors, string);
            ModelPlayerAPI.sortDynamicBases(afterDynamicHookTypes, allBaseAfterDynamicSuperiors, allBaseAfterDynamicInferiors, string);
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
        return allInstances;
    }

    public static void beforeLocalConstructing(ModelPlayer modelPlayer, float f) {
        ModelPlayer[] modelPlayerArray = new ModelPlayer[allInstances.length + 1];
        for (int i = 0; i < allInstances.length; ++i) {
            modelPlayerArray[i] = allInstances[i];
        }
        modelPlayerArray[ModelPlayerAPI.allInstances.length] = modelPlayer;
        allInstances = modelPlayerArray;
        if (modelPlayer.modelPlayerAPI != null) {
            modelPlayer.modelPlayerAPI.beforeLocalConstructing(f);
        }
    }

    public static void afterLocalConstructing(ModelPlayer modelPlayer, float f) {
        if (modelPlayer.modelPlayerAPI != null) {
            modelPlayer.modelPlayerAPI.afterLocalConstructing(f);
        }
    }

    private static void sortBases(List<String> list2, Map<String, String[]> map, Map<String, String[]> map2, String string) {
        new ModelPlayerBaseSorter(list2, map, map2, string).Sort();
    }

    private static void sortDynamicBases(Map<String, List<String>> map, Map<String, Map<String, String[]>> map2, Map<String, Map<String, String[]>> map3, String string) {
        List<String> list2 = map.get(string);
        if (list2 != null && list2.size() > 1) {
            ModelPlayerAPI.sortBases(list2, ModelPlayerAPI.getDynamicSorters(string, list2, map2), ModelPlayerAPI.getDynamicSorters(string, list2, map3), string);
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

    private ModelPlayerAPI(ModelPlayer modelPlayer) {
        this.modelPlayer = modelPlayer;
        ModelPlayerAPI.initializer[0] = this;
        ModelPlayerAPI.initializers[0] = this;
        for (String string : allBaseConstructors.keySet()) {
            ModelPlayerBase modelPlayerBase = this.createModelPlayerBase(string);
            modelPlayerBase.beforeBaseAttach(false);
            this.allBaseObjects.put(string, modelPlayerBase);
            this.baseObjectsToId.put(modelPlayerBase, string);
        }
        this.beforeLocalConstructingHooks = this.create(beforeLocalConstructingHookTypes);
        this.afterLocalConstructingHooks = this.create(afterLocalConstructingHookTypes);
        this.updateModelPlayerBases();
        Iterator<String> iterator2 = this.allBaseObjects.keySet().iterator();
        while (iterator2.hasNext()) {
            this.allBaseObjects.get(iterator2.next()).afterBaseAttach(false);
        }
    }

    private ModelPlayerBase createModelPlayerBase(String string) {
        ModelPlayerBase modelPlayerBase;
        Constructor<?> constructor = allBaseConstructors.get(string);
        ModelPlayerAPI.initializers[1] = string;
        try {
            modelPlayerBase = constructor.getParameterTypes().length == 1 ? (ModelPlayerBase)constructor.newInstance(initializer) : (ModelPlayerBase)constructor.newInstance(initializers);
        }
        catch (Exception exception) {
            throw new RuntimeException("Exception while creating a ModelPlayerBase of type '" + constructor.getDeclaringClass() + "'", exception);
        }
        return modelPlayerBase;
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

    private void attachModelPlayerBase(String string) {
        ModelPlayerAPI.initializer[0] = this;
        ModelPlayerAPI.initializers[0] = this;
        ModelPlayerBase modelPlayerBase = this.createModelPlayerBase(string);
        modelPlayerBase.beforeBaseAttach(true);
        this.allBaseObjects.put(string, modelPlayerBase);
        this.updateModelPlayerBases();
        modelPlayerBase.afterBaseAttach(true);
    }

    private void detachModelPlayerBase(String string) {
        ModelPlayerBase modelPlayerBase = this.allBaseObjects.get(string);
        modelPlayerBase.beforeBaseDetach(true);
        this.allBaseObjects.remove(string);
        this.updateModelPlayerBases();
        modelPlayerBase.afterBaseDetach(true);
    }

    private ModelPlayerBase[] create(List<String> list2) {
        if (list2.isEmpty()) {
            return null;
        }
        ModelPlayerBase[] modelPlayerBaseArray = new ModelPlayerBase[list2.size()];
        for (int i = 0; i < modelPlayerBaseArray.length; ++i) {
            modelPlayerBaseArray[i] = this.getModelPlayerBase(list2.get(i));
        }
        return modelPlayerBaseArray;
    }

    private void beforeLocalConstructing(float f) {
        if (this.beforeLocalConstructingHooks != null) {
            for (int i = this.beforeLocalConstructingHooks.length - 1; i >= 0; --i) {
                this.beforeLocalConstructingHooks[i].beforeLocalConstructing(f);
            }
        }
        this.beforeLocalConstructingHooks = null;
    }

    private void afterLocalConstructing(float f) {
        if (this.afterLocalConstructingHooks != null) {
            for (int i = 0; i < this.afterLocalConstructingHooks.length; ++i) {
                this.afterLocalConstructingHooks[i].afterLocalConstructing(f);
            }
        }
        this.afterLocalConstructingHooks = null;
    }

    public ModelPlayerBase getModelPlayerBase(String string) {
        return this.allBaseObjects.get(string);
    }

    public Set<String> getModelPlayerBaseIds() {
        return this.unmodifiableAllBaseIds;
    }

    public Object dynamic(String string, Object[] objectArray) {
        string = string.replace('.', '_').replace(' ', '_');
        this.executeAll(string, objectArray, beforeDynamicHookTypes, beforeDynamicHookMethods, true);
        Object object = this.dynamicOverwritten(string, objectArray, null);
        this.executeAll(string, objectArray, afterDynamicHookTypes, afterDynamicHookMethods, false);
        return object;
    }

    public Object dynamicOverwritten(String string, Object[] objectArray, ModelPlayerBase modelPlayerBase) {
        Map<Class<?>, Map<String, Method>> map;
        List<String> list2 = overrideDynamicHookTypes.get(string);
        String string2 = null;
        if (list2 != null) {
            if (modelPlayerBase != null) {
                string2 = this.baseObjectsToId.get(modelPlayerBase);
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
        return this.execute(this.getModelPlayerBase(string2), method, objectArray);
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
            ModelPlayerBase modelPlayerBase = this.getModelPlayerBase(string2);
            Class<?> clazz = modelPlayerBase.getClass();
            Map<String, Method> map3 = map2.get(clazz);
            if (map3 != null && (method = map3.get(string)) != null) {
                this.execute(modelPlayerBase, method, objectArray);
            }
            n += bl ? -1 : 1;
        }
    }

    private Object execute(ModelPlayerBase modelPlayerBase, Method method, Object[] objectArray) {
        try {
            return method.invoke(modelPlayerBase, objectArray);
        }
        catch (Exception exception) {
            throw new RuntimeException("Exception while invoking dynamic method", exception);
        }
    }

    public static ModelRenderer getRandomModelBox(ModelPlayer modelPlayer, Random random) {
        ModelRenderer modelRenderer = modelPlayer.modelPlayerAPI != null ? modelPlayer.modelPlayerAPI.getRandomModelBox(random) : modelPlayer.localGetRandomModelBox(random);
        return modelRenderer;
    }

    private ModelRenderer getRandomModelBox(Random random) {
        if (this.beforeGetRandomModelBoxHooks != null) {
            for (int i = this.beforeGetRandomModelBoxHooks.length - 1; i >= 0; --i) {
                this.beforeGetRandomModelBoxHooks[i].beforeGetRandomModelBox(random);
            }
        }
        ModelRenderer modelRenderer = this.overrideGetRandomModelBoxHooks != null ? this.overrideGetRandomModelBoxHooks[this.overrideGetRandomModelBoxHooks.length - 1].getRandomModelBox(random) : this.modelPlayer.localGetRandomModelBox(random);
        if (this.afterGetRandomModelBoxHooks != null) {
            for (int i = 0; i < this.afterGetRandomModelBoxHooks.length; ++i) {
                this.afterGetRandomModelBoxHooks[i].afterGetRandomModelBox(random);
            }
        }
        return modelRenderer;
    }

    protected ModelPlayerBase GetOverwrittenGetRandomModelBox(ModelPlayerBase modelPlayerBase) {
        for (int i = 0; i < this.overrideGetRandomModelBoxHooks.length; ++i) {
            if (this.overrideGetRandomModelBoxHooks[i] != modelPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetRandomModelBoxHooks[i - 1];
        }
        return modelPlayerBase;
    }

    public static TextureOffset getTextureOffset(ModelPlayer modelPlayer, String string) {
        TextureOffset textureOffset = modelPlayer.modelPlayerAPI != null ? modelPlayer.modelPlayerAPI.getTextureOffset(string) : modelPlayer.localGetTextureOffset(string);
        return textureOffset;
    }

    private TextureOffset getTextureOffset(String string) {
        if (this.beforeGetTextureOffsetHooks != null) {
            for (int i = this.beforeGetTextureOffsetHooks.length - 1; i >= 0; --i) {
                this.beforeGetTextureOffsetHooks[i].beforeGetTextureOffset(string);
            }
        }
        TextureOffset textureOffset = this.overrideGetTextureOffsetHooks != null ? this.overrideGetTextureOffsetHooks[this.overrideGetTextureOffsetHooks.length - 1].getTextureOffset(string) : this.modelPlayer.localGetTextureOffset(string);
        if (this.afterGetTextureOffsetHooks != null) {
            for (int i = 0; i < this.afterGetTextureOffsetHooks.length; ++i) {
                this.afterGetTextureOffsetHooks[i].afterGetTextureOffset(string);
            }
        }
        return textureOffset;
    }

    protected ModelPlayerBase GetOverwrittenGetTextureOffset(ModelPlayerBase modelPlayerBase) {
        for (int i = 0; i < this.overrideGetTextureOffsetHooks.length; ++i) {
            if (this.overrideGetTextureOffsetHooks[i] != modelPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideGetTextureOffsetHooks[i - 1];
        }
        return modelPlayerBase;
    }

    public static void render(ModelPlayer modelPlayer, Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        if (modelPlayer.modelPlayerAPI != null) {
            modelPlayer.modelPlayerAPI.render(entity, f, f2, f3, f4, f5, f6);
        } else {
            modelPlayer.localRender(entity, f, f2, f3, f4, f5, f6);
        }
    }

    private void render(Entity entity, float f, float f2, float f3, float f4, float f5, float f6) {
        int n;
        if (this.beforeRenderHooks != null) {
            for (n = this.beforeRenderHooks.length - 1; n >= 0; --n) {
                this.beforeRenderHooks[n].beforeRender(entity, f, f2, f3, f4, f5, f6);
            }
        }
        if (this.overrideRenderHooks != null) {
            this.overrideRenderHooks[this.overrideRenderHooks.length - 1].render(entity, f, f2, f3, f4, f5, f6);
        } else {
            this.modelPlayer.localRender(entity, f, f2, f3, f4, f5, f6);
        }
        if (this.afterRenderHooks != null) {
            for (n = 0; n < this.afterRenderHooks.length; ++n) {
                this.afterRenderHooks[n].afterRender(entity, f, f2, f3, f4, f5, f6);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenRender(ModelPlayerBase modelPlayerBase) {
        for (int i = 0; i < this.overrideRenderHooks.length; ++i) {
            if (this.overrideRenderHooks[i] != modelPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderHooks[i - 1];
        }
        return modelPlayerBase;
    }

    public static void renderCloak(ModelPlayer modelPlayer, float f) {
        if (modelPlayer.modelPlayerAPI != null) {
            modelPlayer.modelPlayerAPI.renderCloak(f);
        } else {
            modelPlayer.localRenderCloak(f);
        }
    }

    private void renderCloak(float f) {
        int n;
        if (this.beforeRenderCloakHooks != null) {
            for (n = this.beforeRenderCloakHooks.length - 1; n >= 0; --n) {
                this.beforeRenderCloakHooks[n].beforeRenderCloak(f);
            }
        }
        if (this.overrideRenderCloakHooks != null) {
            this.overrideRenderCloakHooks[this.overrideRenderCloakHooks.length - 1].renderCloak(f);
        } else {
            this.modelPlayer.localRenderCloak(f);
        }
        if (this.afterRenderCloakHooks != null) {
            for (n = 0; n < this.afterRenderCloakHooks.length; ++n) {
                this.afterRenderCloakHooks[n].afterRenderCloak(f);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenRenderCloak(ModelPlayerBase modelPlayerBase) {
        for (int i = 0; i < this.overrideRenderCloakHooks.length; ++i) {
            if (this.overrideRenderCloakHooks[i] != modelPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderCloakHooks[i - 1];
        }
        return modelPlayerBase;
    }

    public static void renderEars(ModelPlayer modelPlayer, float f) {
        if (modelPlayer.modelPlayerAPI != null) {
            modelPlayer.modelPlayerAPI.renderEars(f);
        } else {
            modelPlayer.localRenderEars(f);
        }
    }

    private void renderEars(float f) {
        int n;
        if (this.beforeRenderEarsHooks != null) {
            for (n = this.beforeRenderEarsHooks.length - 1; n >= 0; --n) {
                this.beforeRenderEarsHooks[n].beforeRenderEars(f);
            }
        }
        if (this.overrideRenderEarsHooks != null) {
            this.overrideRenderEarsHooks[this.overrideRenderEarsHooks.length - 1].renderEars(f);
        } else {
            this.modelPlayer.localRenderEars(f);
        }
        if (this.afterRenderEarsHooks != null) {
            for (n = 0; n < this.afterRenderEarsHooks.length; ++n) {
                this.afterRenderEarsHooks[n].afterRenderEars(f);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenRenderEars(ModelPlayerBase modelPlayerBase) {
        for (int i = 0; i < this.overrideRenderEarsHooks.length; ++i) {
            if (this.overrideRenderEarsHooks[i] != modelPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideRenderEarsHooks[i - 1];
        }
        return modelPlayerBase;
    }

    public static void setLivingAnimations(ModelPlayer modelPlayer, EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        if (modelPlayer.modelPlayerAPI != null) {
            modelPlayer.modelPlayerAPI.setLivingAnimations(entityLivingBase, f, f2, f3);
        } else {
            modelPlayer.localSetLivingAnimations(entityLivingBase, f, f2, f3);
        }
    }

    private void setLivingAnimations(EntityLivingBase entityLivingBase, float f, float f2, float f3) {
        int n;
        if (this.beforeSetLivingAnimationsHooks != null) {
            for (n = this.beforeSetLivingAnimationsHooks.length - 1; n >= 0; --n) {
                this.beforeSetLivingAnimationsHooks[n].beforeSetLivingAnimations(entityLivingBase, f, f2, f3);
            }
        }
        if (this.overrideSetLivingAnimationsHooks != null) {
            this.overrideSetLivingAnimationsHooks[this.overrideSetLivingAnimationsHooks.length - 1].setLivingAnimations(entityLivingBase, f, f2, f3);
        } else {
            this.modelPlayer.localSetLivingAnimations(entityLivingBase, f, f2, f3);
        }
        if (this.afterSetLivingAnimationsHooks != null) {
            for (n = 0; n < this.afterSetLivingAnimationsHooks.length; ++n) {
                this.afterSetLivingAnimationsHooks[n].afterSetLivingAnimations(entityLivingBase, f, f2, f3);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenSetLivingAnimations(ModelPlayerBase modelPlayerBase) {
        for (int i = 0; i < this.overrideSetLivingAnimationsHooks.length; ++i) {
            if (this.overrideSetLivingAnimationsHooks[i] != modelPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetLivingAnimationsHooks[i - 1];
        }
        return modelPlayerBase;
    }

    public static void setRotationAngles(ModelPlayer modelPlayer, float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        if (modelPlayer.modelPlayerAPI != null) {
            modelPlayer.modelPlayerAPI.setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        } else {
            modelPlayer.localSetRotationAngles(f, f2, f3, f4, f5, f6, entity);
        }
    }

    private void setRotationAngles(float f, float f2, float f3, float f4, float f5, float f6, Entity entity) {
        int n;
        if (this.beforeSetRotationAnglesHooks != null) {
            for (n = this.beforeSetRotationAnglesHooks.length - 1; n >= 0; --n) {
                this.beforeSetRotationAnglesHooks[n].beforeSetRotationAngles(f, f2, f3, f4, f5, f6, entity);
            }
        }
        if (this.overrideSetRotationAnglesHooks != null) {
            this.overrideSetRotationAnglesHooks[this.overrideSetRotationAnglesHooks.length - 1].setRotationAngles(f, f2, f3, f4, f5, f6, entity);
        } else {
            this.modelPlayer.localSetRotationAngles(f, f2, f3, f4, f5, f6, entity);
        }
        if (this.afterSetRotationAnglesHooks != null) {
            for (n = 0; n < this.afterSetRotationAnglesHooks.length; ++n) {
                this.afterSetRotationAnglesHooks[n].afterSetRotationAngles(f, f2, f3, f4, f5, f6, entity);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenSetRotationAngles(ModelPlayerBase modelPlayerBase) {
        for (int i = 0; i < this.overrideSetRotationAnglesHooks.length; ++i) {
            if (this.overrideSetRotationAnglesHooks[i] != modelPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetRotationAnglesHooks[i - 1];
        }
        return modelPlayerBase;
    }

    public static void setTextureOffset(ModelPlayer modelPlayer, String string, int n, int n2) {
        if (modelPlayer.modelPlayerAPI != null) {
            modelPlayer.modelPlayerAPI.setTextureOffset(string, n, n2);
        } else {
            modelPlayer.localSetTextureOffset(string, n, n2);
        }
    }

    private void setTextureOffset(String string, int n, int n2) {
        int n3;
        if (this.beforeSetTextureOffsetHooks != null) {
            for (n3 = this.beforeSetTextureOffsetHooks.length - 1; n3 >= 0; --n3) {
                this.beforeSetTextureOffsetHooks[n3].beforeSetTextureOffset(string, n, n2);
            }
        }
        if (this.overrideSetTextureOffsetHooks != null) {
            this.overrideSetTextureOffsetHooks[this.overrideSetTextureOffsetHooks.length - 1].setTextureOffset(string, n, n2);
        } else {
            this.modelPlayer.localSetTextureOffset(string, n, n2);
        }
        if (this.afterSetTextureOffsetHooks != null) {
            for (n3 = 0; n3 < this.afterSetTextureOffsetHooks.length; ++n3) {
                this.afterSetTextureOffsetHooks[n3].afterSetTextureOffset(string, n, n2);
            }
        }
    }

    protected ModelPlayerBase GetOverwrittenSetTextureOffset(ModelPlayerBase modelPlayerBase) {
        for (int i = 0; i < this.overrideSetTextureOffsetHooks.length; ++i) {
            if (this.overrideSetTextureOffsetHooks[i] != modelPlayerBase) continue;
            if (i == 0) {
                return null;
            }
            return this.overrideSetTextureOffsetHooks[i - 1];
        }
        return modelPlayerBase;
    }

    static {
        logger = Logger.getLogger("ModelPlayerAPI");
        allInstances = new ModelPlayer[0];
        EmptySortMap = Collections.unmodifiableMap(new HashMap());
        initializer = new Object[]{null};
        initializers = new Object[]{null, null};
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

