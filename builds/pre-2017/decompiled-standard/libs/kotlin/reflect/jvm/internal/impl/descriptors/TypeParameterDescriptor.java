/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public interface TypeParameterDescriptor
extends ClassifierDescriptor {
    public boolean isReified();

    @NotNull
    public Variance getVariance();

    @NotNull
    public List<KotlinType> getUpperBounds();

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor();

    @Override
    @Deprecated
    @NotNull
    public TypeParameterDescriptor substitute(@NotNull TypeSubstitutor var1);

    @Override
    @NotNull
    public TypeParameterDescriptor getOriginal();

    public int getIndex();

    public boolean isCapturedFromOuterDeclaration();
}

