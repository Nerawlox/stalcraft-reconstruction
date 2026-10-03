/*
 * Decompiled with CFR 0.152.
 */
package net.minecraftforge.client.model;

import java.net.URL;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.ModelFormatException;

public interface IModelCustomLoader {
    public String getType();

    public String[] getSuffixes();

    public IModelCustom loadInstance(String var1, URL var2) throws ModelFormatException;
}

