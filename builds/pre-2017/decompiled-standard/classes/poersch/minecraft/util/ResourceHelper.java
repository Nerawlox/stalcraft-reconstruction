/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util;

import net.minecraft.client.xpzm;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.dwan;
import poersch.minecraft.util.texture.ITextureEditingCallback;
import poersch.minecraft.util.texture.ITextureLoadingCallback;
import poersch.minecraft.util.texture.TextureAtlasSpriteEditingCallback;
import poersch.minecraft.util.texture.TextureAtlasSpriteLoadingCallback;

public class ResourceHelper {
    private static xsfs resourceManager;
    private static pknz resourcepackRepository;

    public static String getCurrentResourcepack() {
        if (resourcepackRepository == null) {
            resourcepackRepository = xpzm._E()._T();
        }
        return resourcepackRepository._f();
    }

    public static htyg getResource(String string, String string2) {
        if (resourceManager == null) {
            resourceManager = xpzm._E()._S();
        }
        try {
            return resourceManager._a(new ResourceLocation(string, string2));
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static boolean resourceExists(String string, String string2) {
        return ResourceHelper.getResource(string, string2) != null;
    }

    public static dwan registerIcon(nege nege2, String string, String string2, String string3) {
        return ResourceHelper.resourceExists(string, string2 + string3 + ".png") ? nege2._b(string + ":" + string3) : null;
    }

    public static dwan registerIcon(nege nege2, String[] stringArray, String string, String string2) {
        for (int i = 0; i < stringArray.length; ++i) {
            dwan dwan2 = ResourceHelper.registerIcon(nege2, stringArray[i], string, string2);
            if (dwan2 == null) continue;
            return dwan2;
        }
        return null;
    }

    public static dwan[] registerIcons(nege nege2, String string, String string2, String string3) {
        if (ResourceHelper.resourceExists(string, string2 + string3 + ".png")) {
            return new dwan[]{nege2._b(string + ":" + string3)};
        }
        int n = 0;
        while (ResourceHelper.resourceExists(string, string2 + string3 + "_" + n + ".png")) {
            ++n;
        }
        if (n == 0) {
            return null;
        }
        dwan[] dwanArray = new dwan[n];
        for (int i = 0; i < n; ++i) {
            dwanArray[i] = nege2._b(string + ":" + string3 + "_" + i);
        }
        return dwanArray;
    }

    public static dwan[] registerIcons(nege nege2, String[] stringArray, String string, String string2) {
        for (int i = 0; i < stringArray.length; ++i) {
            dwan[] dwanArray = ResourceHelper.registerIcons(nege2, stringArray[i], string, string2);
            if (dwanArray == null) continue;
            return dwanArray;
        }
        return null;
    }

    public static dwan registerIconOrCallback(nege nege2, String string, String string2, String string3, String string4, String string5, ITextureLoadingCallback iTextureLoadingCallback) {
        dwan dwan2 = null;
        dwan2 = ResourceHelper.registerIcon(nege2, string, string2, string3);
        return dwan2 == null && (dwan2 = ResourceHelper.registerIconCallback(nege2, string, string2, string3, string, string4, string5, iTextureLoadingCallback)) == null ? null : dwan2;
    }

    public static dwan registerIconOrCallback(nege nege2, String[] stringArray, String string, String string2, String string3, String string4, ITextureLoadingCallback iTextureLoadingCallback) {
        dwan dwan2 = null;
        for (int i = 0; i < stringArray.length; ++i) {
            dwan2 = ResourceHelper.registerIconOrCallback(nege2, stringArray[i], string, string2, string3, string4, iTextureLoadingCallback);
            if (dwan2 == null) continue;
            return dwan2;
        }
        return null;
    }

    public static dwan[] registerIconsOrCallback(nege nege2, String string, String string2, String string3, String string4, String string5, ITextureLoadingCallback iTextureLoadingCallback) {
        dwan[] dwanArray = null;
        dwanArray = ResourceHelper.registerIcons(nege2, string, string2, string3);
        return dwanArray == null && (dwanArray = ResourceHelper.registerIconsCallback(nege2, string, string2, string3, string, string4, string5, iTextureLoadingCallback)) == null ? null : dwanArray;
    }

    public static dwan[] registerIconsOrCallback(nege nege2, String[] stringArray, String string, String string2, String string3, String string4, ITextureLoadingCallback iTextureLoadingCallback) {
        dwan[] dwanArray = null;
        for (int i = 0; i < stringArray.length; ++i) {
            dwanArray = ResourceHelper.registerIconsOrCallback(nege2, stringArray[i], string, string2, string3, string4, iTextureLoadingCallback);
            if (dwanArray == null) continue;
            return dwanArray;
        }
        return null;
    }

    private static dwan registerIconCallbackInternal(nege nege2, String string, String string2, String string3, String string4, String string5, String string6, ITextureLoadingCallback iTextureLoadingCallback) {
        TextureAtlasSpriteLoadingCallback textureAtlasSpriteLoadingCallback = new TextureAtlasSpriteLoadingCallback(string3, string4 + ":" + string5 + string6 + ".png", iTextureLoadingCallback);
        return ((sctd)nege2)._a(string3, textureAtlasSpriteLoadingCallback) ? textureAtlasSpriteLoadingCallback : null;
    }

    public static dwan registerIconCallback(nege nege2, String string, String string2, String string3, String string4, String string5, String string6, ITextureLoadingCallback iTextureLoadingCallback) {
        return ResourceHelper.resourceExists(string4, string5 + string6 + ".png") ? ResourceHelper.registerIconCallbackInternal(nege2, string, string2, string3, string4, string5, string6, iTextureLoadingCallback) : null;
    }

    public static dwan registerIconCallback(nege nege2, String[] stringArray, String string, String string2, String string3, String string4, ITextureLoadingCallback iTextureLoadingCallback) {
        dwan dwan2 = null;
        for (int i = 0; i < stringArray.length; ++i) {
            dwan2 = ResourceHelper.registerIconCallback(nege2, stringArray[i], string, string2, stringArray[i], string3, string4, iTextureLoadingCallback);
            if (dwan2 == null) continue;
            return dwan2;
        }
        return null;
    }

    public static dwan[] registerIconsCallback(nege nege2, String string, String string2, String string3, String string4, String string5, String string6, ITextureLoadingCallback iTextureLoadingCallback) {
        if (ResourceHelper.resourceExists(string4, string5 + string6 + ".png")) {
            return new dwan[]{ResourceHelper.registerIconCallbackInternal(nege2, string, string2, string3, string4, string5, string6, iTextureLoadingCallback)};
        }
        int n = 0;
        while (ResourceHelper.resourceExists(string4, string5 + string6 + "_" + n + ".png")) {
            ++n;
        }
        if (n == 0) {
            return null;
        }
        dwan[] dwanArray = new dwan[n];
        for (int i = 0; i < n; ++i) {
            dwanArray[i] = ResourceHelper.registerIconCallbackInternal(nege2, string, string2, string3 + "_" + i, string4, string5, string6 + "_" + i, iTextureLoadingCallback);
        }
        return dwanArray;
    }

    public static dwan[] registerIconsCallback(nege nege2, String[] stringArray, String string, String string2, String string3, String string4, ITextureLoadingCallback iTextureLoadingCallback) {
        for (int i = 0; i < stringArray.length; ++i) {
            dwan[] dwanArray = ResourceHelper.registerIconsCallback(nege2, stringArray[i], string, string2, stringArray[i], string3, string4, iTextureLoadingCallback);
            if (dwanArray == null) continue;
            return dwanArray;
        }
        return null;
    }

    public static dwan registerIconEditingCallback(nege nege2, String string, String string2, String string3, ITextureEditingCallback iTextureEditingCallback) {
        TextureAtlasSpriteEditingCallback textureAtlasSpriteEditingCallback;
        if (ResourceHelper.resourceExists(string, string2 + string3 + ".png") && ((sctd)nege2)._a(string3, textureAtlasSpriteEditingCallback = new TextureAtlasSpriteEditingCallback(string + ":" + string2 + string3 + ".png", iTextureEditingCallback))) {
            return textureAtlasSpriteEditingCallback;
        }
        return null;
    }
}

