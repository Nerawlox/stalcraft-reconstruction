/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.StrictEqualityTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class KotlinType
implements Annotated {
    @NotNull
    public abstract TypeConstructor getConstructor();

    @NotNull
    public abstract List<TypeProjection> getArguments();

    public abstract boolean isMarkedNullable();

    @NotNull
    public abstract MemberScope getMemberScope();

    public abstract boolean isError();

    @NotNull
    public abstract UnwrappedType unwrap();

    public final int hashCode() {
        if (this.isError()) {
            return super.hashCode();
        }
        int result2 = this.getConstructor().hashCode();
        result2 = 31 * result2 + ((Object)this.getArguments()).hashCode();
        result2 = 31 * result2 + (this.isMarkedNullable() ? 1 : 0);
        return result2;
    }

    public final boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KotlinType)) {
            return false;
        }
        return this.isMarkedNullable() == ((KotlinType)other).isMarkedNullable() && StrictEqualityTypeChecker.INSTANCE.strictEqualTypes(this.unwrap(), ((KotlinType)other).unwrap());
    }

    private KotlinType() {
    }

    public /* synthetic */ KotlinType(DefaultConstructorMarker $constructor_marker) {
        this();
    }
}

