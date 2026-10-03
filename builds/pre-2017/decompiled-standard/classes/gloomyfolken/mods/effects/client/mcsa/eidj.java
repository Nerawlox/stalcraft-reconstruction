/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.effects.client.mcsa;

import gloomyfolken.mods.effects.client.mcsa.kjui;
import java.net.URL;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.IModelCustomLoader;
import net.minecraftforge.client.model.ModelFormatException;

public class eidj
implements IModelCustomLoader {
    private static final String[] _a = new String[]{"mcsa"};

    @Override
    public String getType() {
        return "MCSA model";
    }

    @Override
    public String[] getSuffixes() {
        return _a;
    }

    public kjui _a(String string, URL uRL) throws ModelFormatException {
        ResourceLocation resourceLocation = uyvo._a(string);
        return new kjui(resourceLocation);
    }

    @Override
    public /* synthetic */ IModelCustom loadInstance(String string, URL uRL) throws ModelFormatException {
        return this._a(string, uRL);
    }
}

