/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CapturedTypeConstructor
implements TypeConstructor {
    @Nullable
    private NewCapturedTypeConstructor newTypeConstructor;
    @NotNull
    private final TypeProjection typeProjection;

    @Nullable
    public final NewCapturedTypeConstructor getNewTypeConstructor() {
        return this.newTypeConstructor;
    }

    public final void setNewTypeConstructor(@Nullable NewCapturedTypeConstructor newCapturedTypeConstructor) {
        this.newTypeConstructor = newCapturedTypeConstructor;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public Collection<KotlinType> getSupertypes() {
        KotlinType kotlinType;
        if (Intrinsics.areEqual((Object)this.typeProjection.getProjectionKind(), (Object)Variance.OUT_VARIANCE)) {
            KotlinType kotlinType2 = this.typeProjection.getType();
            kotlinType = kotlinType2;
            Intrinsics.checkExpressionValueIsNotNull(kotlinType2, "typeProjection.type");
        } else {
            SimpleType simpleType2 = this.getBuiltIns().getNullableAnyType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "builtIns.nullableAnyType");
            kotlinType = simpleType2;
        }
        KotlinType superType = kotlinType;
        return CollectionsKt.listOf(superType);
    }

    @Override
    public boolean isFinal() {
        return true;
    }

    @Override
    public boolean isDenotable() {
        return false;
    }

    @Nullable
    public Void getDeclarationDescriptor() {
        return null;
    }

    @NotNull
    public String toString() {
        return "CapturedTypeConstructor(" + this.typeProjection + ")";
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns kotlinBuiltIns = this.typeProjection.getType().getConstructor().getBuiltIns();
        Intrinsics.checkExpressionValueIsNotNull(kotlinBuiltIns, "typeProjection.type.constructor.builtIns");
        return kotlinBuiltIns;
    }

    @NotNull
    public final TypeProjection getTypeProjection() {
        return this.typeProjection;
    }

    public CapturedTypeConstructor(@NotNull TypeProjection typeProjection) {
        Intrinsics.checkParameterIsNotNull(typeProjection, "typeProjection");
        this.typeProjection = typeProjection;
        boolean bl = Intrinsics.areEqual((Object)this.typeProjection.getProjectionKind(), (Object)Variance.INVARIANT) ^ true;
        if (_Assertions.ENABLED && !bl) {
            String string = "Only nontrivial projections can be captured, not: " + this.typeProjection;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
    }
}

