/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai.attributes;

import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.server.management.LowerStringMap;

public abstract class BaseAttributeMap {
    public final Map _a = new HashMap();
    public final Map _b = new LowerStringMap();

    public hubf _a(Attribute attribute) {
        return (hubf)this._a.get(attribute);
    }

    public hubf _a(String string) {
        return (hubf)this._b.get(string);
    }

    public abstract hubf _b(Attribute var1);

    public Collection _a() {
        return this._b.values();
    }

    public void _a(ModifiableAttributeInstance modifiableAttributeInstance) {
    }

    public void _a(Multimap multimap) {
        for (Map.Entry entry : multimap.entries()) {
            hubf hubf2 = this._a((String)entry.getKey());
            if (hubf2 == null) continue;
            hubf2._b((AttributeModifier)entry.getValue());
        }
    }

    public void _b(Multimap multimap) {
        for (Map.Entry entry : multimap.entries()) {
            hubf hubf2 = this._a((String)entry.getKey());
            if (hubf2 == null) continue;
            hubf2._b((AttributeModifier)entry.getValue());
            hubf2._a((AttributeModifier)entry.getValue());
        }
    }
}

