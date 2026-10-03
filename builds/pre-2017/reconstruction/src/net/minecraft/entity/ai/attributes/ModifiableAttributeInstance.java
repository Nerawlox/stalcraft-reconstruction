/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai.attributes;

import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;

public class ModifiableAttributeInstance
implements hubf {
    public final BaseAttributeMap _a;
    public final Attribute _b;
    public final Map _c = Maps.newHashMap();
    public final Map _d = Maps.newHashMap();
    public final Map _e = Maps.newHashMap();
    public double _f;
    public boolean _g = true;
    public double _h;

    public ModifiableAttributeInstance(BaseAttributeMap baseAttributeMap, Attribute attribute) {
        this._a = baseAttributeMap;
        this._b = attribute;
        this._f = attribute._b();
        for (int i = 0; i < 3; ++i) {
            this._c.put(i, new HashSet());
        }
    }

    @Override
    public Attribute _a() {
        return this._b;
    }

    @Override
    public double _b() {
        return this._f;
    }

    @Override
    public void _a(double d) {
        if (d == this._b()) {
            return;
        }
        this._f = d;
        this._f();
    }

    public Collection _a(int n) {
        return (Collection)this._c.get(n);
    }

    @Override
    public Collection _c() {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < 3; ++i) {
            hashSet.addAll(this._a(i));
        }
        return hashSet;
    }

    @Override
    public AttributeModifier _a(UUID uUID) {
        return (AttributeModifier)this._e.get(uUID);
    }

    @Override
    public void _a(AttributeModifier attributeModifier) {
        if (this._a(attributeModifier._a()) != null) {
            throw new IllegalArgumentException("Modifier is already applied on this attribute!");
        }
        HashSet<AttributeModifier> hashSet = (HashSet<AttributeModifier>)this._d.get(attributeModifier._b());
        if (hashSet == null) {
            hashSet = new HashSet<AttributeModifier>();
            this._d.put(attributeModifier._b(), hashSet);
        }
        ((Set)this._c.get(attributeModifier._c())).add(attributeModifier);
        hashSet.add(attributeModifier);
        this._e.put(attributeModifier._a(), attributeModifier);
        this._f();
    }

    public void _f() {
        this._g = true;
        this._a._a(this);
    }

    @Override
    public void _b(AttributeModifier attributeModifier) {
        for (int i = 0; i < 3; ++i) {
            Set set = (Set)this._c.get(i);
            set.remove(attributeModifier);
        }
        Set set = (Set)this._d.get(attributeModifier._b());
        if (set != null) {
            set.remove(attributeModifier);
            if (set.isEmpty()) {
                this._d.remove(attributeModifier._b());
            }
        }
        this._e.remove(attributeModifier._a());
        this._f();
    }

    @Override
    public void _d() {
        ArrayList arrayList = this._c();
        if (arrayList == null) {
            return;
        }
        arrayList = new ArrayList(arrayList);
        for (AttributeModifier attributeModifier : arrayList) {
            this._b(attributeModifier);
        }
    }

    @Override
    public double _e() {
        if (this._g) {
            this._h = this._g();
            this._g = false;
        }
        return this._h;
    }

    public double _g() {
        double d = this._b();
        for (AttributeModifier attributeModifier : this._a(0)) {
            d += attributeModifier._d();
        }
        double d2 = d;
        for (AttributeModifier attributeModifier : this._a(1)) {
            d2 += d * attributeModifier._d();
        }
        for (AttributeModifier attributeModifier : this._a(2)) {
            d2 *= 1.0 + attributeModifier._d();
        }
        return this._b._a(d2);
    }
}

