/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model.techne;

import java.net.URL;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.IModelCustomLoader;
import net.minecraftforge.client.model.ModelFormatException;
import net.minecraftforge.client.model.techne.TechneModel;

public class TechneModelLoader
implements IModelCustomLoader {
    private static final String[] types = new String[]{"tcn"};

    @Override
    public String getType() {
        return "Techne model";
    }

    @Override
    public String[] getSuffixes() {
        return types;
    }

    @Override
    public IModelCustom loadInstance(String string, URL uRL) throws ModelFormatException {
        return new TechneModel(string, uRL);
    }
}

