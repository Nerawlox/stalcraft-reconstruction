/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;

public abstract class TypeProjectionBase
implements TypeProjection {
    public String toString() {
        if (this.isStarProjection()) {
            return "*";
        }
        if (this.getProjectionKind() == Variance.INVARIANT) {
            return this.getType().toString();
        }
        return (Object)((Object)this.getProjectionKind()) + " " + this.getType();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TypeProjection)) {
            return false;
        }
        TypeProjection that = (TypeProjection)o;
        if (this.isStarProjection() != that.isStarProjection()) {
            return false;
        }
        if (this.getProjectionKind() != that.getProjectionKind()) {
            return false;
        }
        return this.getType().equals(that.getType());
    }

    public int hashCode() {
        int result2 = this.getProjectionKind().hashCode();
        result2 = 31 * result2 + (this.isStarProjection() ? 17 : this.getType().hashCode());
        return result2;
    }
}

