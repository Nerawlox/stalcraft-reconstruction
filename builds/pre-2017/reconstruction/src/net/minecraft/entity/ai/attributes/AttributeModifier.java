/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.entity.ai.attributes;

import java.util.UUID;
import org.apache.commons.lang3.Validate;

public class AttributeModifier {
    public final double _a;
    public final int _b;
    public final String _c;
    public final UUID _d;
    public boolean _e = true;

    public AttributeModifier(String string, double d, int n) {
        this(UUID.randomUUID(), string, d, n);
    }

    public AttributeModifier(UUID uUID, String string, double d, int n) {
        this._d = uUID;
        this._c = string;
        this._a = d;
        this._b = n;
        Validate.notEmpty(string, "Modifier name cannot be empty", new Object[0]);
        Validate.inclusiveBetween(0, 2, Integer.valueOf(n), "Invalid operation", new Object[0]);
    }

    public UUID _a() {
        return this._d;
    }

    public String _b() {
        return this._c;
    }

    public int _c() {
        return this._b;
    }

    public double _d() {
        return this._a;
    }

    public boolean _e() {
        return this._e;
    }

    public AttributeModifier _a(boolean bl) {
        this._e = bl;
        return this;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        AttributeModifier attributeModifier = (AttributeModifier)object;
        return !(this._d != null ? !this._d.equals(attributeModifier._d) : attributeModifier._d != null);
    }

    public int hashCode() {
        return this._d != null ? this._d.hashCode() : 0;
    }

    public String toString() {
        return "AttributeModifier{amount=" + this._a + ", operation=" + this._b + ", name='" + this._c + '\'' + ", id=" + this._d + ", serialize=" + this._e + '}';
    }
}

