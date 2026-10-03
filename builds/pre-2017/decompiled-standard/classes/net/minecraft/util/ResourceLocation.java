/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import gloomyfolken.mods.asm.PathModifier;
import org.apache.commons.lang3.Validate;

public class ResourceLocation {
    public final String field_110626_a;
    public final String field_110625_b;

    public ResourceLocation(String string, String string2) {
        Validate.notNull(string2);
        this.field_110626_a = string != null && string.length() != 0 ? string : "minecraft";
        this.field_110625_b = PathModifier.modifyPath(string2, this.field_110626_a);
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
        this.field_110626_a = string2.toLowerCase();
        this.field_110625_b = PathModifier.modifyPath(string3, string2);
    }

    public String func_110623_a() {
        return this.field_110625_b;
    }

    public String func_110624_b() {
        return this.field_110626_a;
    }

    public String toString() {
        return this.field_110626_a + ":" + this.field_110625_b;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ResourceLocation)) {
            return false;
        }
        ResourceLocation resourceLocation = (ResourceLocation)object;
        return this.field_110626_a.equals(resourceLocation.field_110626_a) && this.field_110625_b.equals(resourceLocation.field_110625_b);
    }

    public int hashCode() {
        return 31 * this.field_110626_a.hashCode() + this.field_110625_b.hashCode();
    }
}

