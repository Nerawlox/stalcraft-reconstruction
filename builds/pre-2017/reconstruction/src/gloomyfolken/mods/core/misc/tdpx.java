/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.core.misc;

import java.util.List;
import net.minecraft.util.ResourceLocation;

public class tdpx {
    public static List<String> _a(ResourceLocation resourceLocation) {
        return srxe._a("/assets/" + resourceLocation.getResourceDomain() + "/" + resourceLocation.getResourcePath());
    }

    public static String _b(ResourceLocation resourceLocation) {
        return srxe._b("/assets/" + resourceLocation.getResourceDomain() + "/" + resourceLocation.getResourcePath());
    }
}

