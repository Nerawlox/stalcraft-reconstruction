/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai.attributes;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.server.management.LowerStringMap;

public class ServersideAttributeMap
extends BaseAttributeMap {
    public final Set _c = Sets.newHashSet();
    public final Map _d = new LowerStringMap();

    public ModifiableAttributeInstance _c(Attribute attribute) {
        return (ModifiableAttributeInstance)super._a(attribute);
    }

    public ModifiableAttributeInstance _b(String string) {
        hubf hubf2 = super._a(string);
        if (hubf2 == null) {
            hubf2 = (hubf)this._d.get(string);
        }
        return (ModifiableAttributeInstance)hubf2;
    }

    @Override
    public hubf _b(Attribute attribute) {
        if (this._b.containsKey(attribute._a())) {
            throw new IllegalArgumentException("Attribute is already registered!");
        }
        ModifiableAttributeInstance modifiableAttributeInstance = new ModifiableAttributeInstance(this, attribute);
        this._b.put(attribute._a(), modifiableAttributeInstance);
        if (attribute instanceof RangedAttribute && ((RangedAttribute)attribute)._d() != null) {
            this._d.put(((RangedAttribute)attribute)._d(), modifiableAttributeInstance);
        }
        this._a.put(attribute, modifiableAttributeInstance);
        return modifiableAttributeInstance;
    }

    @Override
    public void _a(ModifiableAttributeInstance modifiableAttributeInstance) {
        if (modifiableAttributeInstance._a()._c()) {
            this._c.add(modifiableAttributeInstance);
        }
    }

    public Set _b() {
        return this._c;
    }

    public Collection _c() {
        HashSet<hubf> hashSet = Sets.newHashSet();
        for (hubf hubf2 : this._a()) {
            if (!hubf2._a()._c()) continue;
            hashSet.add(hubf2);
        }
        return hashSet;
    }

    @Override
    public /* synthetic */ hubf _a(String string) {
        return this._b(string);
    }

    @Override
    public /* synthetic */ hubf _a(Attribute attribute) {
        return this._c(attribute);
    }
}

