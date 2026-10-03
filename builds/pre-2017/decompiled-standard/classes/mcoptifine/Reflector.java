/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import mcoptifine.Config;
import mcoptifine.ReflectorClass;
import mcoptifine.ReflectorConstructor;
import mcoptifine.ReflectorField;
import mcoptifine.ReflectorMethod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;

public class Reflector {
    public static ReflectorClass ModLoader = new ReflectorClass("ModLoader");
    public static ReflectorMethod ModLoader_renderWorldBlock = new ReflectorMethod(ModLoader, "renderWorldBlock");
    public static ReflectorMethod ModLoader_renderInvBlock = new ReflectorMethod(ModLoader, "renderInvBlock");
    public static ReflectorMethod ModLoader_renderBlockIsItemFull3D = new ReflectorMethod(ModLoader, "renderBlockIsItemFull3D");
    public static ReflectorMethod ModLoader_registerServer = new ReflectorMethod(ModLoader, "registerServer");
    public static ReflectorMethod ModLoader_getCustomAnimationLogic = new ReflectorMethod(ModLoader, "getCustomAnimationLogic");
    public static ReflectorClass FMLRenderAccessLibrary = new ReflectorClass("FMLRenderAccessLibrary");
    public static ReflectorMethod FMLRenderAccessLibrary_renderWorldBlock = new ReflectorMethod(FMLRenderAccessLibrary, "renderWorldBlock");
    public static ReflectorMethod FMLRenderAccessLibrary_renderInventoryBlock = new ReflectorMethod(FMLRenderAccessLibrary, "renderInventoryBlock");
    public static ReflectorMethod FMLRenderAccessLibrary_renderItemAsFull3DBlock = new ReflectorMethod(FMLRenderAccessLibrary, "renderItemAsFull3DBlock");
    public static ReflectorClass BlockCoord = new ReflectorClass("BlockCoord");
    public static ReflectorMethod BlockCoord_resetPool = new ReflectorMethod(BlockCoord, "resetPool");
    public static ReflectorClass MinecraftForge = new ReflectorClass("net.minecraftforge.common.MinecraftForge");
    public static ReflectorField MinecraftForge_EVENT_BUS = new ReflectorField(MinecraftForge, "EVENT_BUS");
    public static ReflectorClass ForgeHooks = new ReflectorClass("net.minecraftforge.common.ForgeHooks");
    public static ReflectorMethod ForgeHooks_onLivingSetAttackTarget = new ReflectorMethod(ForgeHooks, "onLivingSetAttackTarget");
    public static ReflectorMethod ForgeHooks_onLivingUpdate = new ReflectorMethod(ForgeHooks, "onLivingUpdate");
    public static ReflectorMethod ForgeHooks_onLivingAttack = new ReflectorMethod(ForgeHooks, "onLivingAttack");
    public static ReflectorMethod ForgeHooks_onLivingHurt = new ReflectorMethod(ForgeHooks, "onLivingHurt");
    public static ReflectorMethod ForgeHooks_onLivingDeath = new ReflectorMethod(ForgeHooks, "onLivingDeath");
    public static ReflectorMethod ForgeHooks_onLivingDrops = new ReflectorMethod(ForgeHooks, "onLivingDrops");
    public static ReflectorMethod ForgeHooks_onLivingFall = new ReflectorMethod(ForgeHooks, "onLivingFall");
    public static ReflectorMethod ForgeHooks_onLivingJump = new ReflectorMethod(ForgeHooks, "onLivingJump");
    public static ReflectorClass MinecraftForgeClient = new ReflectorClass("net.minecraftforge.client.MinecraftForgeClient");
    public static ReflectorMethod MinecraftForgeClient_getRenderPass = new ReflectorMethod(MinecraftForgeClient, "getRenderPass");
    public static ReflectorMethod MinecraftForgeClient_getItemRenderer = new ReflectorMethod(MinecraftForgeClient, "getItemRenderer");
    public static ReflectorClass ForgeHooksClient = new ReflectorClass("net.minecraftforge.client.ForgeHooksClient");
    public static ReflectorMethod ForgeHooksClient_onDrawBlockHighlight = new ReflectorMethod(ForgeHooksClient, "onDrawBlockHighlight");
    public static ReflectorMethod ForgeHooksClient_orientBedCamera = new ReflectorMethod(ForgeHooksClient, "orientBedCamera");
    public static ReflectorMethod ForgeHooksClient_renderEquippedItem = new ReflectorMethod(ForgeHooksClient, "renderEquippedItem");
    public static ReflectorMethod ForgeHooksClient_dispatchRenderLast = new ReflectorMethod(ForgeHooksClient, "dispatchRenderLast");
    public static ReflectorMethod ForgeHooksClient_onTextureLoadPre = new ReflectorMethod(ForgeHooksClient, "onTextureLoadPre");
    public static ReflectorMethod ForgeHooksClient_setRenderPass = new ReflectorMethod(ForgeHooksClient, "setRenderPass");
    public static ReflectorMethod ForgeHooksClient_onTextureStitchedPre = new ReflectorMethod(ForgeHooksClient, "onTextureStitchedPre");
    public static ReflectorMethod ForgeHooksClient_onTextureStitchedPost = new ReflectorMethod(ForgeHooksClient, "onTextureStitchedPost");
    public static ReflectorClass FMLCommonHandler = new ReflectorClass("cpw.mods.fml.common.FMLCommonHandler");
    public static ReflectorMethod FMLCommonHandler_instance = new ReflectorMethod(FMLCommonHandler, "instance");
    public static ReflectorMethod FMLCommonHandler_handleServerStarting = new ReflectorMethod(FMLCommonHandler, "handleServerStarting");
    public static ReflectorMethod FMLCommonHandler_handleServerAboutToStart = new ReflectorMethod(FMLCommonHandler, "handleServerAboutToStart");
    public static ReflectorClass FMLClientHandler = new ReflectorClass("cpw.mods.fml.client.FMLClientHandler");
    public static ReflectorMethod FMLClientHandler_instance = new ReflectorMethod(FMLClientHandler, "instance");
    public static ReflectorMethod FMLClientHandler_isLoading = new ReflectorMethod(FMLClientHandler, "isLoading");
    public static ReflectorClass ItemRenderType = new ReflectorClass("net.minecraftforge.client.IItemRenderer$ItemRenderType");
    public static ReflectorField ItemRenderType_EQUIPPED = new ReflectorField(ItemRenderType, "EQUIPPED");
    public static ReflectorClass ForgeWorldProvider = new ReflectorClass(rrte.class);
    public static ReflectorMethod ForgeWorldProvider_getSkyRenderer = new ReflectorMethod(ForgeWorldProvider, "getSkyRenderer");
    public static ReflectorMethod ForgeWorldProvider_getCloudRenderer = new ReflectorMethod(ForgeWorldProvider, "getCloudRenderer");
    public static ReflectorClass IRenderHandler = new ReflectorClass("net.minecraftforge.client.IRenderHandler");
    public static ReflectorMethod IRenderHandler_render = new ReflectorMethod(IRenderHandler, "render");
    public static ReflectorClass DimensionManager = new ReflectorClass("net.minecraftforge.common.DimensionManager");
    public static ReflectorMethod DimensionManager_getStaticDimensionIDs = new ReflectorMethod(DimensionManager, "getStaticDimensionIDs");
    public static ReflectorClass WorldEvent_Load = new ReflectorClass("net.minecraftforge.event.world.WorldEvent$Load");
    public static ReflectorConstructor WorldEvent_Load_Constructor = new ReflectorConstructor(WorldEvent_Load, new Class[]{ozlu.class});
    public static ReflectorClass EventBus = new ReflectorClass("net.minecraftforge.event.EventBus");
    public static ReflectorMethod EventBus_post = new ReflectorMethod(EventBus, "post");
    public static ReflectorClass ChunkWatchEvent_UnWatch = new ReflectorClass("net.minecraftforge.event.world.ChunkWatchEvent$UnWatch");
    public static ReflectorConstructor ChunkWatchEvent_UnWatch_Constructor = new ReflectorConstructor(ChunkWatchEvent_UnWatch, new Class[]{jjym.class, EntityPlayerMP.class});
    public static ReflectorClass ForgeBlock = new ReflectorClass(twgu.class);
    public static ReflectorMethod ForgeBlock_getBedDirection = new ReflectorMethod(ForgeBlock, "getBedDirection");
    public static ReflectorMethod ForgeBlock_isBedFoot = new ReflectorMethod(ForgeBlock, "isBedFoot");
    public static ReflectorClass ForgeEntity = new ReflectorClass(Entity.class);
    public static ReflectorField ForgeEntity_captureDrops = new ReflectorField(ForgeEntity, "captureDrops");
    public static ReflectorField ForgeEntity_capturedDrops = new ReflectorField(ForgeEntity, "capturedDrops");
    public static ReflectorMethod ForgeEntity_shouldRenderInPass = new ReflectorMethod(ForgeEntity, "shouldRenderInPass");
    public static ReflectorClass ForgeTileEntity = new ReflectorClass(hurg.class);
    public static ReflectorMethod ForgeTileEntity_shouldRenderInPass = new ReflectorMethod(ForgeTileEntity, "shouldRenderInPass");
    public static ReflectorClass ForgeItem = new ReflectorClass(tgdv.class);
    public static ReflectorMethod ForgeItem_onEntitySwing = new ReflectorMethod(ForgeItem, "onEntitySwing");
    public static ReflectorClass ForgePotionEffect = new ReflectorClass(supr.class);
    public static ReflectorMethod ForgePotionEffect_isCurativeItem = new ReflectorMethod(ForgePotionEffect, "isCurativeItem");
    public static ReflectorClass ForgeItemStack = new ReflectorClass(cvzo.class);
    public static ReflectorMethod ForgeItemStack_hasEffect = new ReflectorMethod(ForgeItemStack, "hasEffect", new Class[]{Integer.TYPE});

    public static void callVoid(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return;
            }
            method.invoke(null, objectArray);
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
        }
    }

    public static boolean callBoolean(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return false;
            }
            Boolean bl = (Boolean)method.invoke(null, objectArray);
            return bl;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
            return false;
        }
    }

    public static int callInt(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return 0;
            }
            Integer n = (Integer)method.invoke(null, objectArray);
            return n;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
            return 0;
        }
    }

    public static float callFloat(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return 0.0f;
            }
            Float f = (Float)method.invoke(null, objectArray);
            return f.floatValue();
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
            return 0.0f;
        }
    }

    public static String callString(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return null;
            }
            String string = (String)method.invoke(null, objectArray);
            return string;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
            return null;
        }
    }

    public static Object call(ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return null;
            }
            Object object = method.invoke(null, objectArray);
            return object;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, null, reflectorMethod, objectArray);
            return null;
        }
    }

    public static void callVoid(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            if (object == null) {
                return;
            }
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return;
            }
            method.invoke(object, objectArray);
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
        }
    }

    public static boolean callBoolean(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return false;
            }
            Boolean bl = (Boolean)method.invoke(object, objectArray);
            return bl;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
            return false;
        }
    }

    public static int callInt(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return 0;
            }
            Integer n = (Integer)method.invoke(object, objectArray);
            return n;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
            return 0;
        }
    }

    public static float callFloat(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return 0.0f;
            }
            Float f = (Float)method.invoke(object, objectArray);
            return f.floatValue();
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
            return 0.0f;
        }
    }

    public static String callString(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return null;
            }
            String string = (String)method.invoke(object, objectArray);
            return string;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
            return null;
        }
    }

    public static Object call(Object object, ReflectorMethod reflectorMethod, Object ... objectArray) {
        try {
            Method method = reflectorMethod.getTargetMethod();
            if (method == null) {
                return null;
            }
            Object object2 = method.invoke(object, objectArray);
            return object2;
        }
        catch (Throwable throwable) {
            Reflector.handleException(throwable, object, reflectorMethod, objectArray);
            return null;
        }
    }

    public static Object getFieldValue(ReflectorField reflectorField) {
        return Reflector.getFieldValue(null, reflectorField);
    }

    public static Object getFieldValue(Object object, ReflectorField reflectorField) {
        try {
            Field field = reflectorField.getTargetField();
            if (field == null) {
                return null;
            }
            Object object2 = field.get(object);
            return object2;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    public static void setFieldValue(ReflectorField reflectorField, Object object) {
        Reflector.setFieldValue(null, reflectorField, object);
    }

    public static void setFieldValue(Object object, ReflectorField reflectorField, Object object2) {
        try {
            Field field = reflectorField.getTargetField();
            if (field == null) {
                return;
            }
            field.set(object, object2);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void postForgeBusEvent(ReflectorConstructor reflectorConstructor, Object ... objectArray) {
        try {
            Object object = Reflector.getFieldValue(MinecraftForge_EVENT_BUS);
            if (object == null) {
                return;
            }
            Constructor constructor = reflectorConstructor.getTargetConstructor();
            if (constructor == null) {
                return;
            }
            Object t = constructor.newInstance(objectArray);
            Reflector.callVoid(object, EventBus_post, t);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static boolean matchesTypes(Class[] classArray, Class[] classArray2) {
        if (classArray.length != classArray2.length) {
            return false;
        }
        for (int i = 0; i < classArray2.length; ++i) {
            Class clazz = classArray[i];
            Class clazz2 = classArray2[i];
            if (clazz == clazz2) continue;
            return false;
        }
        return true;
    }

    private static void dbgCall(boolean bl, String string, ReflectorMethod reflectorMethod, Object[] objectArray, Object object) {
        String string2 = reflectorMethod.getTargetMethod().getDeclaringClass().getName();
        String string3 = reflectorMethod.getTargetMethod().getName();
        String string4 = "";
        if (bl) {
            string4 = " static";
        }
        Config.dbg(string + string4 + " " + string2 + "." + string3 + "(" + Config.arrayToString(objectArray) + ") => " + object);
    }

    private static void dbgCallVoid(boolean bl, String string, ReflectorMethod reflectorMethod, Object[] objectArray) {
        String string2 = reflectorMethod.getTargetMethod().getDeclaringClass().getName();
        String string3 = reflectorMethod.getTargetMethod().getName();
        String string4 = "";
        if (bl) {
            string4 = " static";
        }
        Config.dbg(string + string4 + " " + string2 + "." + string3 + "(" + Config.arrayToString(objectArray) + ")");
    }

    private static void dbgFieldValue(boolean bl, String string, ReflectorField reflectorField, Object object) {
        String string2 = reflectorField.getTargetField().getDeclaringClass().getName();
        String string3 = reflectorField.getTargetField().getName();
        String string4 = "";
        if (bl) {
            string4 = " static";
        }
        Config.dbg(string + string4 + " " + string2 + "." + string3 + " => " + object);
    }

    private static void handleException(Throwable throwable, Object object, ReflectorMethod reflectorMethod, Object[] objectArray) {
        if (throwable instanceof InvocationTargetException) {
            throwable.printStackTrace();
        } else {
            if (throwable instanceof IllegalArgumentException) {
                Config.warn("*** IllegalArgumentException ***");
                Config.warn("Method: " + reflectorMethod.getTargetMethod());
                Config.warn("Object: " + object);
                Config.warn("Parameter classes: " + Config.arrayToString(Reflector.getClasses(objectArray)));
                Config.warn("Parameters: " + Config.arrayToString(objectArray));
            }
            Config.warn("*** Exception outside of method ***");
            Config.warn("Method deactivated: " + reflectorMethod.getTargetMethod());
            reflectorMethod.deactivate();
            throwable.printStackTrace();
        }
    }

    private static Object[] getClasses(Object[] objectArray) {
        if (objectArray == null) {
            return new Class[0];
        }
        Object[] objectArray2 = new Class[objectArray.length];
        for (int i = 0; i < objectArray2.length; ++i) {
            Object object = objectArray[i];
            if (object == null) continue;
            objectArray2[i] = object.getClass();
        }
        return objectArray2;
    }

    public static Field getFieldByType(Class clazz, Class clazz2) {
        try {
            Field[] fieldArray = clazz.getDeclaredFields();
            for (int i = 0; i < fieldArray.length; ++i) {
                Field field = fieldArray[i];
                if (field.getType() != clazz2) continue;
                field.setAccessible(true);
                return field;
            }
            return null;
        }
        catch (Exception exception) {
            return null;
        }
    }
}

