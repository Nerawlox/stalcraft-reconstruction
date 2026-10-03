/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model;

import com.google.common.collect.Maps;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.net.URL;
import java.util.Collection;
import java.util.Map;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.IModelCustomLoader;
import net.minecraftforge.client.model.ModelFormatException;
import net.minecraftforge.client.model.obj.ObjModelLoader;
import net.minecraftforge.client.model.techne.TechneModelLoader;

@SideOnly(value=Side.CLIENT)
public class AdvancedModelLoader {
    private static Map<String, IModelCustomLoader> instances = Maps.newHashMap();

    public static void registerModelHandler(IModelCustomLoader iModelCustomLoader) {
        for (String string : iModelCustomLoader.getSuffixes()) {
            instances.put(string, iModelCustomLoader);
        }
    }

    public static IModelCustom loadModel(String string) throws IllegalArgumentException, ModelFormatException {
        int n = string.lastIndexOf(46);
        if (n == -1) {
            FMLLog.severe("The resource name %s is not valid", string);
            throw new IllegalArgumentException("The resource name is not valid");
        }
        String string2 = string.substring(n + 1);
        IModelCustomLoader iModelCustomLoader = instances.get(string2);
        if (iModelCustomLoader == null) {
            FMLLog.severe("The resource name %s is not supported", string);
            throw new IllegalArgumentException("The resource name is not supported");
        }
        URL uRL = AdvancedModelLoader.class.getResource(string);
        if (uRL == null) {
            FMLLog.severe("The resource name %s could not be found", string);
            throw new IllegalArgumentException("The resource name could not be found");
        }
        return iModelCustomLoader.loadInstance(string, uRL);
    }

    public static Collection<String> getSupportedSuffixes() {
        return instances.keySet();
    }

    static {
        AdvancedModelLoader.registerModelHandler(new ObjModelLoader());
        AdvancedModelLoader.registerModelHandler(new TechneModelLoader());
    }
}

