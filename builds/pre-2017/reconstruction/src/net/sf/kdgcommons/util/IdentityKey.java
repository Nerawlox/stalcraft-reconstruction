/*
 * Decompiled with CFR 0.152.
 */
package net.sf.kdgcommons.util;

public final class IdentityKey {
    Object _realKey;

    public IdentityKey(Object object) {
        this._realKey = object;
    }

    public boolean equals(Object object) {
        if (object instanceof IdentityKey) {
            return this._realKey == ((IdentityKey)object)._realKey;
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this._realKey);
    }
}

