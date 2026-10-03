/*
 * Decompiled with CFR 0.152.
 */
package poersch.minecraft.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.client.resources.ResourceManager;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;
import poersch.minecraft.util.texture.ITextureEditingCallback;
import poersch.minecraft.util.texture.ITextureLoadingCallback;
import poersch.minecraft.util.texture.TextureAtlasSpriteEditingCallback;
import poersch.minecraft.util.texture.TextureAtlasSpriteLoadingCallback;

public class ResourceHelper {
    private static ResourceManager resourceManager;
    private static pknz resourcepackRepository;

    public static String getCurrentResourcepack() {
        if (resourcepackRepository == null) {
            resourcepackRepository = Minecraft._E()._T();
        }
        return resourcepackRepository._f();
    }

    public static htyg getResource(String string, String string2) {
        if (resourceManager == null) {
            resourceManager = Minecraft._E()._S();
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

    public static Icon registerIcon(IconRegister iconRegister, String string, String string2, String string3) {
        return ResourceHelper.resourceExists(string, string2 + string3 + ".png") ? iconRegister._b(string + ":" + string3) : null;
    }

    public static Icon registerIcon(IconRegister iconRegister, String[] stringArray, String string, String string2) {
        for (int i = 0; i < stringArray.length; ++i) {
            Icon icon = ResourceHelper.registerIcon(iconRegister, stringArray[i], string, string2);
            if (icon == null) continue;
            return icon;
        }
        return null;
    }

    public static Icon[] registerIcons(IconRegister iconRegister, String string, String string2, String string3) {
        if (ResourceHelper.resourceExists(string, string2 + string3 + ".png")) {
            return new Icon[]{iconRegister._b(string + ":" + string3)};
        }
        int n = 0;
        while (ResourceHelper.resourceExists(string, string2 + string3 + "_" + n + ".png")) {
            ++n;
        }
        if (n == 0) {
            return null;
        }
        Icon[] iconArray = new Icon[n];
        for (int i = 0; i < n; ++i) {
            iconArray[i] = iconRegister._b(string + ":" + string3 + "_" + i);
        }
        return iconArray;
    }

    public static Icon[] registerIcons(IconRegister iconRegister, String[] stringArray, String string, String string2) {
        for (int i = 0; i < stringArray.length; ++i) {
            Icon[] iconArray = ResourceHelper.registerIcons(iconRegister, stringArray[i], string, string2);
            if (iconArray == null) continue;
            return iconArray;
        }
        return null;
    }

    public static Icon registerIconOrCallback(IconRegister iconRegister, String string, String string2, String string3, String string4, String string5, ITextureLoadingCallback iTextureLoadingCallback) {
        Icon icon = null;
        icon = ResourceHelper.registerIcon(iconRegister, string, string2, string3);
        return icon == null && (icon = ResourceHelper.registerIconCallback(iconRegister, string, string2, string3, string, string4, string5, iTextureLoadingCallback)) == null ? null : icon;
    }

    public static Icon registerIconOrCallback(IconRegister iconRegister, String[] stringArray, String string, String string2, String string3, String string4, ITextureLoadingCallback iTextureLoadingCallback) {
        Icon icon = null;
        for (int i = 0; i < stringArray.length; ++i) {
            icon = ResourceHelper.registerIconOrCallback(iconRegister, stringArray[i], string, string2, string3, string4, iTextureLoadingCallback);
            if (icon == null) continue;
            return icon;
        }
        return null;
    }

    public static Icon[] registerIconsOrCallback(IconRegister iconRegister, String string, String string2, String string3, String string4, String string5, ITextureLoadingCallback iTextureLoadingCallback) {
        Icon[] iconArray = null;
        iconArray = ResourceHelper.registerIcons(iconRegister, string, string2, string3);
        return iconArray == null && (iconArray = ResourceHelper.registerIconsCallback(iconRegister, string, string2, string3, string, string4, string5, iTextureLoadingCallback)) == null ? null : iconArray;
    }

    public static Icon[] registerIconsOrCallback(IconRegister iconRegister, String[] stringArray, String string, String string2, String string3, String string4, ITextureLoadingCallback iTextureLoadingCallback) {
        Icon[] iconArray = null;
        for (int i = 0; i < stringArray.length; ++i) {
            iconArray = ResourceHelper.registerIconsOrCallback(iconRegister, stringArray[i], string, string2, string3, string4, iTextureLoadingCallback);
            if (iconArray == null) continue;
            return iconArray;
        }
        return null;
    }

    private static Icon registerIconCallbackInternal(IconRegister iconRegister, String string, String string2, String string3, String string4, String string5, String string6, ITextureLoadingCallback iTextureLoadingCallback) {
        TextureAtlasSpriteLoadingCallback textureAtlasSpriteLoadingCallback = new TextureAtlasSpriteLoadingCallback(string3, string4 + ":" + string5 + string6 + ".png", iTextureLoadingCallback);
        return ((sctd)iconRegister)._a(string3, textureAtlasSpriteLoadingCallback) ? textureAtlasSpriteLoadingCallback : null;
    }

    public static Icon registerIconCallback(IconRegister iconRegister, String string, String string2, String string3, String string4, String string5, String string6, ITextureLoadingCallback iTextureLoadingCallback) {
        return ResourceHelper.resourceExists(string4, string5 + string6 + ".png") ? ResourceHelper.registerIconCallbackInternal(iconRegister, string, string2, string3, string4, string5, string6, iTextureLoadingCallback) : null;
    }

    public static Icon registerIconCallback(IconRegister iconRegister, String[] stringArray, String string, String string2, String string3, String string4, ITextureLoadingCallback iTextureLoadingCallback) {
        Icon icon = null;
        for (int i = 0; i < stringArray.length; ++i) {
            icon = ResourceHelper.registerIconCallback(iconRegister, stringArray[i], string, string2, stringArray[i], string3, string4, iTextureLoadingCallback);
            if (icon == null) continue;
            return icon;
        }
        return null;
    }

    public static Icon[] registerIconsCallback(IconRegister iconRegister, String string, String string2, String string3, String string4, String string5, String string6, ITextureLoadingCallback iTextureLoadingCallback) {
        if (ResourceHelper.resourceExists(string4, string5 + string6 + ".png")) {
            return new Icon[]{ResourceHelper.registerIconCallbackInternal(iconRegister, string, string2, string3, string4, string5, string6, iTextureLoadingCallback)};
        }
        int n = 0;
        while (ResourceHelper.resourceExists(string4, string5 + string6 + "_" + n + ".png")) {
            ++n;
        }
        if (n == 0) {
            return null;
        }
        Icon[] iconArray = new Icon[n];
        for (int i = 0; i < n; ++i) {
            iconArray[i] = ResourceHelper.registerIconCallbackInternal(iconRegister, string, string2, string3 + "_" + i, string4, string5, string6 + "_" + i, iTextureLoadingCallback);
        }
        return iconArray;
    }

    public static Icon[] registerIconsCallback(IconRegister iconRegister, String[] stringArray, String string, String string2, String string3, String string4, ITextureLoadingCallback iTextureLoadingCallback) {
        for (int i = 0; i < stringArray.length; ++i) {
            Icon[] iconArray = ResourceHelper.registerIconsCallback(iconRegister, stringArray[i], string, string2, stringArray[i], string3, string4, iTextureLoadingCallback);
            if (iconArray == null) continue;
            return iconArray;
        }
        return null;
    }

    public static Icon registerIconEditingCallback(IconRegister iconRegister, String string, String string2, String string3, ITextureEditingCallback iTextureEditingCallback) {
        TextureAtlasSpriteEditingCallback textureAtlasSpriteEditingCallback;
        if (ResourceHelper.resourceExists(string, string2 + string3 + ".png") && ((sctd)iconRegister)._a(string3, textureAtlasSpriteEditingCallback = new TextureAtlasSpriteEditingCallback(string + ":" + string2 + string3 + ".png", iTextureEditingCallback))) {
            return textureAtlasSpriteEditingCallback;
        }
        return null;
    }
}

