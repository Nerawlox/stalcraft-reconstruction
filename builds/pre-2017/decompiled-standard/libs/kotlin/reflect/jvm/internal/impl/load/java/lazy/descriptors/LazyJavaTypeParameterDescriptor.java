/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaTypeParameterDescriptor
extends AbstractLazyTypeParameterDescriptor {
    @NotNull
    private final LazyJavaAnnotations annotations;
    private final LazyJavaResolverContext c;
    @NotNull
    private final JavaTypeParameter javaTypeParameter;

    @Override
    @NotNull
    public LazyJavaAnnotations getAnnotations() {
        return this.annotations;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    protected List<KotlinType> resolveUpperBounds() {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Collection<JavaClassifierType> bounds = this.javaTypeParameter.getUpperBounds();
        if (bounds.isEmpty()) {
            SimpleType simpleType2 = this.c.getModule().getBuiltIns().getAnyType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "c.module.builtIns.anyType");
            SimpleType simpleType3 = this.c.getModule().getBuiltIns().getNullableAnyType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType3, "c.module.builtIns.nullableAnyType");
            return CollectionsKt.listOf(KotlinTypeFactory.flexibleType(simpleType2, simpleType3));
        }
        Iterable iterable = $receiver$iv = (Iterable)bounds;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            JavaClassifierType javaClassifierType = (JavaClassifierType)item$iv$iv;
            Collection collection = destination$iv$iv;
            KotlinType kotlinType = this.c.getTypeResolver().transformJavaType((JavaType)it, JavaTypeResolverKt.toAttributes$default(TypeUsage.UPPER_BOUND, false, false, this, 3, null));
            collection.add(kotlinType);
        }
        return (List)destination$iv$iv;
    }

    @Override
    protected void reportSupertypeLoopError(@NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
    }

    @NotNull
    public final JavaTypeParameter getJavaTypeParameter() {
        return this.javaTypeParameter;
    }

    public LazyJavaTypeParameterDescriptor(@NotNull LazyJavaResolverContext c, @NotNull JavaTypeParameter javaTypeParameter, int index, @NotNull DeclarationDescriptor containingDeclaration) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(javaTypeParameter, "javaTypeParameter");
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        super(c.getStorageManager(), containingDeclaration, javaTypeParameter.getName(), Variance.INVARIANT, false, index, SourceElement.NO_SOURCE, c.getComponents().getSupertypeLoopChecker());
        this.c = c;
        this.javaTypeParameter = javaTypeParameter;
        this.annotations = new LazyJavaAnnotations(this.c, this.javaTypeParameter);
    }
}

