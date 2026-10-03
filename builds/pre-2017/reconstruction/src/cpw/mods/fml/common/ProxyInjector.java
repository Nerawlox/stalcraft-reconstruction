/*
 * Decompiled with CFR 0.152.
 */
package cpw.mods.fml.common;

import com.google.common.base.Strings;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ILanguageAdapter;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.common.ModContainer;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.relauncher.Side;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.logging.Level;

public class ProxyInjector {
    public static void inject(ModContainer modContainer, ASMDataTable aSMDataTable, Side side, ILanguageAdapter iLanguageAdapter) {
        FMLLog.fine("Attempting to inject @SidedProxy classes into %s", modContainer.getModId());
        Set<ASMDataTable.ASMData> set = aSMDataTable.getAnnotationsFor(modContainer).get(SidedProxy.class.getName());
        ClassLoader classLoader = Loader.instance().getModClassLoader();
        for (ASMDataTable.ASMData aSMData : set) {
            try {
                Class<?> clazz = Class.forName(aSMData.getClassName(), true, classLoader);
                Field field = clazz.getDeclaredField(aSMData.getObjectName());
                if (field == null) {
                    FMLLog.severe("Attempted to load a proxy type into %s.%s but the field was not found", aSMData.getClassName(), aSMData.getObjectName());
                    throw new LoaderException();
                }
                SidedProxy sidedProxy = field.getAnnotation(SidedProxy.class);
                if (!Strings.isNullOrEmpty(sidedProxy.modId()) && !sidedProxy.modId().equals(modContainer.getModId())) {
                    FMLLog.fine("Skipping proxy injection for %s.%s since it is not for mod %s", aSMData.getClassName(), aSMData.getObjectName(), modContainer.getModId());
                    continue;
                }
                String string = side.isClient() ? sidedProxy.clientSide() : sidedProxy.serverSide();
                Object obj = Class.forName(string, true, classLoader).newInstance();
                if (iLanguageAdapter.supportsStatics() && (field.getModifiers() & 8) == 0) {
                    FMLLog.severe("Attempted to load a proxy type %s into %s.%s, but the field is not static", string, aSMData.getClassName(), aSMData.getObjectName());
                    throw new LoaderException();
                }
                if (!field.getType().isAssignableFrom(obj.getClass())) {
                    FMLLog.severe("Attempted to load a proxy type %s into %s.%s, but the types don't match", string, aSMData.getClassName(), aSMData.getObjectName());
                    throw new LoaderException();
                }
                iLanguageAdapter.setProxy(field, clazz, obj);
            }
            catch (Exception exception) {
                FMLLog.log(Level.SEVERE, exception, "An error occured trying to load a proxy into %s.%s", aSMData.getAnnotationInfo(), aSMData.getClassName(), aSMData.getObjectName());
                throw new LoaderException(exception);
            }
        }
        iLanguageAdapter.setInternalProxies(modContainer, side, classLoader);
    }
}

