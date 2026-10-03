/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.model.IModelCustom
 *  net.minecraftforge.client.model.IModelCustomLoader
 *  net.minecraftforge.client.model.ModelFormatException
 */
package ru.stalcraft.client.loaders;

import java.net.URL;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.IModelCustomLoader;
import net.minecraftforge.client.model.ModelFormatException;
import ru.stalcraft.client.loaders.StalkerWavefrontObject;

public class StalkerObjModelLoader
implements IModelCustomLoader {
    private static final String[] types = new String[]{"suck"};

    public String getType() {
        return "suck model";
    }

    public String[] getSuffixes() {
        return types;
    }

    public IModelCustom loadInstance(String resourceName, URL resource) throws ModelFormatException {
        return new StalkerWavefrontObject(resourceName, resource);
    }
}

