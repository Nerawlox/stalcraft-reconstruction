/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SubtypingRepresentatives;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

public abstract class FlexibleType
extends UnwrappedType
implements SubtypingRepresentatives {
    @NotNull
    private final SimpleType lowerBound;
    @NotNull
    private final SimpleType upperBound;

    @NotNull
    public abstract SimpleType getDelegate();

    @Override
    @NotNull
    public KotlinType getSubTypeRepresentative() {
        return this.lowerBound;
    }

    @Override
    @NotNull
    public KotlinType getSuperTypeRepresentative() {
        return this.upperBound;
    }

    @Override
    public boolean sameTypeConstructor(@NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        return false;
    }

    @NotNull
    public abstract String render(@NotNull DescriptorRenderer var1, @NotNull DescriptorRendererOptions var2);

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return this.getDelegate().getAnnotations();
    }

    @Override
    @NotNull
    public TypeConstructor getConstructor() {
        return this.getDelegate().getConstructor();
    }

    @Override
    @NotNull
    public List<TypeProjection> getArguments() {
        return this.getDelegate().getArguments();
    }

    @Override
    public boolean isMarkedNullable() {
        return this.getDelegate().isMarkedNullable();
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        return this.getDelegate().getMemberScope();
    }

    @Override
    public boolean isError() {
        return this.getDelegate().isError();
    }

    @NotNull
    public String toString() {
        return DescriptorRenderer.DEBUG_TEXT.renderType(this);
    }

    @NotNull
    public final SimpleType getLowerBound() {
        return this.lowerBound;
    }

    @NotNull
    public final SimpleType getUpperBound() {
        return this.upperBound;
    }

    public FlexibleType(@NotNull SimpleType lowerBound, @NotNull SimpleType upperBound) {
        Intrinsics.checkParameterIsNotNull(lowerBound, "lowerBound");
        Intrinsics.checkParameterIsNotNull(upperBound, "upperBound");
        super(null);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
}

