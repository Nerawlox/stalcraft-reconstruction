/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model.obj;

import java.net.URL;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.IModelCustomLoader;
import net.minecraftforge.client.model.ModelFormatException;
import net.minecraftforge.client.model.obj.WavefrontObject;

public class ObjModelLoader
implements IModelCustomLoader {
    private static final String[] types = new String[]{"obj"};

    @Override
    public String getType() {
        return "OBJ model";
    }

    @Override
    public String[] getSuffixes() {
        return types;
    }

    @Override
    public IModelCustom loadInstance(String string, URL uRL) throws ModelFormatException {
        return new WavefrontObject(string, uRL);
    }
}

