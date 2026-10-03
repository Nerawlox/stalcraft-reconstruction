/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

final class SimpleTypeImpl
extends SimpleType {
    @NotNull
    private final Annotations annotations;
    @NotNull
    private final TypeConstructor constructor;
    @NotNull
    private final List<TypeProjection> arguments;
    private final boolean isMarkedNullable;
    @NotNull
    private final MemberScope memberScope;

    @Override
    @NotNull
    public SimpleTypeImpl replaceAnnotations(@NotNull Annotations newAnnotations) {
        Intrinsics.checkParameterIsNotNull(newAnnotations, "newAnnotations");
        return new SimpleTypeImpl(newAnnotations, this.getConstructor(), this.getArguments(), this.isMarkedNullable(), this.getMemberScope());
    }

    @Override
    @NotNull
    public SimpleTypeImpl makeNullableAsSpecified(boolean newNullability) {
        return new SimpleTypeImpl(this.getAnnotations(), this.getConstructor(), this.getArguments(), newNullability, this.getMemberScope());
    }

    @Override
    public boolean isError() {
        return false;
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override
    @NotNull
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @Override
    @NotNull
    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @Override
    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public SimpleTypeImpl(@NotNull Annotations annotations2, @NotNull TypeConstructor constructor, @NotNull List<? extends TypeProjection> arguments2, boolean isMarkedNullable, @NotNull MemberScope memberScope2) {
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(constructor, "constructor");
        Intrinsics.checkParameterIsNotNull(arguments2, "arguments");
        Intrinsics.checkParameterIsNotNull(memberScope2, "memberScope");
        this.annotations = annotations2;
        this.constructor = constructor;
        this.arguments = arguments2;
        this.isMarkedNullable = isMarkedNullable;
        this.memberScope = memberScope2;
        if (this.getMemberScope() instanceof ErrorUtils.ErrorScope) {
            throw (Throwable)new IllegalStateException("SimpleTypeImpl should not be created for error type: " + this.getMemberScope() + "\n" + this.getConstructor());
        }
    }
}

