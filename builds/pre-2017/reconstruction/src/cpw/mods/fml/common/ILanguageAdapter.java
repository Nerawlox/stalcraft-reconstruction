/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.FMLModContainer;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.relauncher.Side;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;

public interface ILanguageAdapter {
    public Object getNewInstance(FMLModContainer var1, Class<?> var2, ClassLoader var3, Method var4) throws Exception;

    public boolean supportsStatics();

    public void setProxy(Field var1, Class<?> var2, Object var3) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException;

    public void setInternalProxies(ModContainer var1, Side var2, ClassLoader var3);

    public static class JavaAdapter
    implements ILanguageAdapter {
        @Override
        public Object getNewInstance(FMLModContainer fMLModContainer, Class<?> clazz, ClassLoader classLoader, Method method) throws Exception {
            if (method != null) {
                return method.invoke(null, new Object[0]);
            }
            return clazz.newInstance();
        }

        @Override
        public boolean supportsStatics() {
            return true;
        }

        @Override
        public void setProxy(Field field, Class<?> clazz, Object object) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
            field.set(null, object);
        }

        @Override
        public void setInternalProxies(ModContainer modContainer, Side side, ClassLoader classLoader) {
        }
    }

    public static class ScalaAdapter
    implements ILanguageAdapter {
        @Override
        public Object getNewInstance(FMLModContainer fMLModContainer, Class<?> clazz, ClassLoader classLoader, Method method) throws Exception {
            Class<?> clazz2 = Class.forName(clazz.getName() + "$", true, classLoader);
            return clazz2.getField("MODULE$").get(null);
        }

        @Override
        public boolean supportsStatics() {
            return false;
        }

        @Override
        public void setProxy(Field field, Class<?> clazz, Object object) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
            try {
                if (!clazz.getName().endsWith("$")) {
                    clazz = Class.forName(clazz.getName() + "$", true, clazz.getClassLoader());
                }
            }
            catch (ClassNotFoundException classNotFoundException) {
                FMLLog.log(Level.INFO, classNotFoundException, "An error occured trying to load a proxy into %s.%s. Did you declare your mod as 'class' instead of 'object'?", clazz.getSimpleName(), field.getName());
                return;
            }
            Object object2 = clazz.getField("MODULE$").get(null);
            try {
                String string = field.getName() + "_$eq";
                for (Method method : clazz.getMethods()) {
                    Class<?>[] classArray = method.getParameterTypes();
                    if (!string.equals(method.getName()) || classArray.length != 1 || !classArray[0].isAssignableFrom(object.getClass())) continue;
                    method.invoke(object2, object);
                    return;
                }
            }
            catch (InvocationTargetException invocationTargetException) {
                FMLLog.log(Level.SEVERE, invocationTargetException, "An error occured trying to load a proxy into %s.%s", clazz.getSimpleName(), field.getName());
                throw new LoaderException(invocationTargetException);
            }
            FMLLog.severe("Failed loading proxy into %s.%s, could not find setter function. Did you declare the field with 'val' instead of 'var'?", clazz.getSimpleName(), field.getName());
            throw new LoaderException();
        }

        @Override
        public void setInternalProxies(ModContainer modContainer, Side side, ClassLoader classLoader) {
            Class<?> clazz = modContainer.getMod().getClass();
            if (clazz.getName().endsWith("$")) {
                for (Field field : clazz.getDeclaredFields()) {
                    if (field.getAnnotation(SidedProxy.class) == null) continue;
                    String string = side.isClient() ? field.getAnnotation(SidedProxy.class).clientSide() : field.getAnnotation(SidedProxy.class).serverSide();
                    try {
                        Object obj = Class.forName(string, true, classLoader).newInstance();
                        if (!field.getType().isAssignableFrom(obj.getClass())) {
                            FMLLog.severe("Attempted to load a proxy type %s into %s.%s, but the types don't match", string, clazz.getSimpleName(), field.getName());
                            throw new LoaderException();
                        }
                        this.setProxy(field, clazz, obj);
                    }
                    catch (Exception exception) {
                        FMLLog.log(Level.SEVERE, exception, "An error occured trying to load a proxy into %s.%s", clazz.getSimpleName(), field.getName());
                        throw new LoaderException(exception);
                    }
                }
            } else {
                FMLLog.finer("Mod does not appear to be a singleton.", new Object[0]);
            }
        }
    }
}

