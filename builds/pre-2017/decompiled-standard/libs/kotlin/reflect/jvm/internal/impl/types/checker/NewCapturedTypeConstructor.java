/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NewCapturedTypeConstructor
implements TypeConstructor {
    @NotNull
    private final TypeProjection projection;
    private List<? extends UnwrappedType> supertypes;

    public final void initializeSupertypes(@NotNull List<? extends UnwrappedType> supertypes2) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(supertypes2, "supertypes");
        boolean bl2 = bl = this.supertypes == null;
        if (_Assertions.ENABLED && !bl) {
            String string = "Already initialized! oldValue = " + this.supertypes + ", newValue = " + supertypes2;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        this.supertypes = supertypes2;
    }

    @NotNull
    public List<UnwrappedType> getSupertypes() {
        List<UnwrappedType> list = this.supertypes;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    @Override
    public boolean isDenotable() {
        return false;
    }

    @Override
    @Nullable
    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return TypeUtilsKt.getBuiltIns(this.projection.getType());
    }

    @NotNull
    public String toString() {
        return "CapturedType(" + this.projection + ")";
    }

    @NotNull
    public final TypeProjection getProjection() {
        return this.projection;
    }

    public NewCapturedTypeConstructor(@NotNull TypeProjection projection, @Nullable List<? extends UnwrappedType> supertypes2) {
        Intrinsics.checkParameterIsNotNull(projection, "projection");
        this.projection = projection;
        this.supertypes = supertypes2;
    }

    public /* synthetic */ NewCapturedTypeConstructor(TypeProjection typeProjection, List list, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            list = null;
        }
        this(typeProjection, list);
    }
}

