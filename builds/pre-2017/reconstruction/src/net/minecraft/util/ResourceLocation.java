/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import gloomyfolken.mods.asm.PathModifier;
import org.apache.commons.lang3.Validate;

public class ResourceLocation {
    public final String resourceDomain;
    public final String resourcePath;

    public ResourceLocation(String string, String string2) {
        Validate.notNull(string2);
        this.resourceDomain = string != null && string.length() != 0 ? string : "minecraft";
        this.resourcePath = PathModifier.modifyPath(string2, this.resourceDomain);
    }

    public ResourceLocation(String string) {
        String string2 = "minecraft";
        String string3 = string;
        int n = string.indexOf(58);
        if (n >= 0) {
            string3 = string.substring(n + 1, string.length());
            if (n > 1) {
                string2 = string.substring(0, n);
            }
        }
        this.resourceDomain = string2.toLowerCase();
        this.resourcePath = PathModifier.modifyPath(string3, string2);
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public String getResourceDomain() {
        return this.resourceDomain;
    }

    public String toString() {
        return this.resourceDomain + ":" + this.resourcePath;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ResourceLocation)) {
            return false;
        }
        ResourceLocation resourceLocation = (ResourceLocation)object;
        return this.resourceDomain.equals(resourceLocation.resourceDomain) && this.resourcePath.equals(resourceLocation.resourcePath);
    }

    public int hashCode() {
        return 31 * this.resourceDomain.hashCode() + this.resourcePath.hashCode();
    }
}

