/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.UnsafeVarianceTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeHolder;
import kotlin.reflect.jvm.internal.impl.types.TypeHolderArgument;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.VarianceCheckerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UnsafeVarianceTypeSubstitution
extends TypeSubstitution {
    private final AnnotationsImpl unsafeVarianceAnnotations;

    @Nullable
    public Void get(@NotNull KotlinType key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return null;
    }

    @Override
    @NotNull
    public KotlinType prepareTopLevelType(@NotNull KotlinType topLevelType, @NotNull Variance position) {
        Intrinsics.checkParameterIsNotNull(topLevelType, "topLevelType");
        Intrinsics.checkParameterIsNotNull((Object)position, "position");
        List unsafeVariancePaths = new ArrayList();
        VarianceCheckerKt.checkTypePosition((TypeHolder)new IndexedTypeHolder(topLevelType, null, 2, null), position, (Function3)new Function3<TypeParameterDescriptor, IndexedTypeHolder, Variance, Unit>(unsafeVariancePaths){
            final /* synthetic */ List $unsafeVariancePaths;

            public final void invoke(@NotNull TypeParameterDescriptor typeParameter, @NotNull IndexedTypeHolder indexedTypeHolder, @NotNull Variance errorPosition) {
                Intrinsics.checkParameterIsNotNull(typeParameter, "typeParameter");
                Intrinsics.checkParameterIsNotNull(indexedTypeHolder, "indexedTypeHolder");
                Intrinsics.checkParameterIsNotNull((Object)((Object)errorPosition), "errorPosition");
                this.$unsafeVariancePaths.add(indexedTypeHolder.getArgumentIndices());
            }
            {
                this.$unsafeVariancePaths = list;
                super(3);
            }
        }, prepareTopLevelType.2.INSTANCE);
        return this.annotatePartsWithUnsafeVariance(topLevelType.unwrap(), (Collection<? extends List<Integer>>)unsafeVariancePaths);
    }

    private final UnwrappedType annotatePartsWithUnsafeVariance(@NotNull UnwrappedType $receiver, Collection<? extends List<Integer>> unsafeVariancePaths) {
        UnwrappedType unwrappedType;
        if (unsafeVariancePaths.isEmpty()) {
            return $receiver;
        }
        UnwrappedType unwrappedType2 = $receiver;
        if (unwrappedType2 instanceof FlexibleType) {
            unwrappedType = KotlinTypeFactory.flexibleType(this.annotatePartsWithUnsafeVariance(((FlexibleType)$receiver).getLowerBound(), (Collection<? extends List<Integer>>)this.subPathsWithIndex(unsafeVariancePaths, 0)), this.annotatePartsWithUnsafeVariance(((FlexibleType)$receiver).getUpperBound(), (Collection<? extends List<Integer>>)this.subPathsWithIndex(unsafeVariancePaths, 1)));
        } else if (unwrappedType2 instanceof SimpleType) {
            unwrappedType = this.annotatePartsWithUnsafeVariance((SimpleType)$receiver, unsafeVariancePaths);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return unwrappedType;
    }

    /*
     * WARNING - void declaration
     */
    private final SimpleType annotatePartsWithUnsafeVariance(@NotNull SimpleType $receiver, Collection<? extends List<Integer>> unsafeVariancePaths) {
        Collection<void> collection;
        void $receiver$iv$iv;
        void $receiver$iv;
        if (unsafeVariancePaths.isEmpty()) {
            return $receiver;
        }
        if (unsafeVariancePaths.contains(CollectionsKt.emptyList())) {
            return $receiver.replaceAnnotations(AnnotationsKt.composeAnnotations($receiver.getAnnotations(), this.unsafeVarianceAnnotations));
        }
        Iterable iterable = CollectionsKt.withIndex((Iterable)$receiver.getArguments());
        SimpleType simpleType2 = $receiver;
        void var5_5 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void index;
            void argument;
            void it;
            IndexedValue indexedValue = (IndexedValue)item$iv$iv;
            collection = destination$iv$iv;
            Object var11_11 = it;
            int n = var11_11.component1();
            TypeProjection typeProjection = (TypeProjection)var11_11.component2();
            var11_11 = null;
            void var14_14 = argument.isStarProjection() ? argument : (TypeProjection)new TypeProjectionImpl(argument.getProjectionKind(), this.annotatePartsWithUnsafeVariance(argument.getType().unwrap(), (Collection<? extends List<Integer>>)this.subPathsWithIndex(unsafeVariancePaths, (int)index)));
            collection.add(var14_14);
        }
        collection = (List)destination$iv$iv;
        return TypeSubstitutionKt.replace$default(simpleType2, (List)collection, null, 2, null);
    }

    private final List<List<Integer>> subPathsWithIndex(Collection<? extends List<Integer>> paths, int index) {
        List it;
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)paths;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            it = (List)element$iv$iv;
            if (!(((Number)it.get(0)).intValue() == index)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            it = (List)item$iv$iv;
            Collection collection = destination$iv$iv;
            List list = it.subList(1, it.size());
            collection.add(list);
        }
        return (List)destination$iv$iv;
    }

    public UnsafeVarianceTypeSubstitution(@NotNull KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.checkParameterIsNotNull(kotlinBuiltIns, "kotlinBuiltIns");
        this.unsafeVarianceAnnotations = new AnnotationsImpl(CollectionsKt.listOf(AnnotationUtilKt.createUnsafeVarianceAnnotation(kotlinBuiltIns)));
    }

    private static final class IndexedTypeHolder
    implements TypeHolder<IndexedTypeHolder> {
        @NotNull
        private final KotlinType type;
        @NotNull
        private final List<Integer> argumentIndices;

        @Override
        @Nullable
        public Pair<IndexedTypeHolder, IndexedTypeHolder> getFlexibleBounds() {
            return FlexibleTypesKt.isFlexible(this.getType()) ? new Pair<IndexedTypeHolder, IndexedTypeHolder>(new IndexedTypeHolder(FlexibleTypesKt.lowerIfFlexible(this.getType()), CollectionsKt.plus((Collection)this.argumentIndices, Integer.valueOf(0))), new IndexedTypeHolder(FlexibleTypesKt.upperIfFlexible(this.getType()), CollectionsKt.plus((Collection)this.argumentIndices, Integer.valueOf(1)))) : null;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        public List<TypeHolderArgument<IndexedTypeHolder>> getArguments() {
            void var3_3;
            void $receiver$iv$iv;
            Iterable $receiver$iv;
            Iterable iterable = $receiver$iv = CollectionsKt.withIndex((Iterable)this.getType().getArguments());
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void index;
                void projection;
                void projectionWithIndex;
                IndexedValue indexedValue = (IndexedValue)item$iv$iv;
                Collection collection = destination$iv$iv;
                Object var8_8 = projectionWithIndex;
                int n = var8_8.component1();
                TypeProjection typeProjection = (TypeProjection)var8_8.component2();
                var8_8 = null;
                TypeHolderArgument<IndexedTypeHolder> typeHolderArgument = new TypeHolderArgument<IndexedTypeHolder>((TypeProjection)projection, (int)index, this){
                    final /* synthetic */ TypeProjection $projection;
                    final /* synthetic */ int $index;
                    final /* synthetic */ IndexedTypeHolder this$0;
                    {
                        this.$projection = $captured_local_variable$1;
                        this.$index = $captured_local_variable$2;
                        this.this$0 = indexedTypeHolder;
                    }

                    public TypeProjection getProjection() {
                        return this.$projection;
                    }

                    public TypeParameterDescriptor getTypeParameter() {
                        return this.this$0.getType().getConstructor().getParameters().get(this.$index);
                    }

                    public IndexedTypeHolder getHolder() {
                        KotlinType kotlinType = this.$projection.getType();
                        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "projection.type");
                        return new IndexedTypeHolder(kotlinType, CollectionsKt.plus((Collection)this.this$0.getArgumentIndices(), Integer.valueOf(this.$index)));
                    }
                };
                collection.add(typeHolderArgument);
            }
            return (List)var3_3;
        }

        @Override
        @NotNull
        public KotlinType getType() {
            return this.type;
        }

        @NotNull
        public final List<Integer> getArgumentIndices() {
            return this.argumentIndices;
        }

        public IndexedTypeHolder(@NotNull KotlinType type2, @NotNull List<Integer> argumentIndices) {
            Intrinsics.checkParameterIsNotNull(type2, "type");
            Intrinsics.checkParameterIsNotNull(argumentIndices, "argumentIndices");
            this.type = type2;
            this.argumentIndices = argumentIndices;
        }

        public /* synthetic */ IndexedTypeHolder(KotlinType kotlinType, List list, int n, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            this(kotlinType, list);
        }
    }
}

