/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CapturedTypeConstructorKt {
    @NotNull
    public static final KotlinType createCapturedType(@NotNull TypeProjection typeProjection) {
        Intrinsics.checkParameterIsNotNull(typeProjection, "typeProjection");
        return new CapturedType(typeProjection, null, false, null, 14, null);
    }

    public static final boolean isCaptured(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.getConstructor() instanceof CapturedTypeConstructor;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final TypeSubstitution wrapWithCapturingSubstitution(@NotNull TypeSubstitution $receiver, boolean needApproximation) {
        TypeSubstitution typeSubstitution;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver instanceof IndexedParametersSubstitution) {
            Collection<TypeProjection> collection;
            void $receiver$iv$iv;
            Collection $receiver$iv;
            IndexedParametersSubstitution indexedParametersSubstitution;
            Iterable iterable = ArraysKt.zip((Object[])((IndexedParametersSubstitution)$receiver).getArguments(), (Object[])((IndexedParametersSubstitution)$receiver).getParameters());
            TypeParameterDescriptor[] typeParameterDescriptorArray = ((IndexedParametersSubstitution)$receiver).getParameters();
            IndexedParametersSubstitution indexedParametersSubstitution2 = indexedParametersSubstitution;
            IndexedParametersSubstitution indexedParametersSubstitution3 = indexedParametersSubstitution;
            void var6_6 = $receiver$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void it;
                Pair pair = (Pair)item$iv$iv;
                collection = destination$iv$iv;
                TypeProjection typeProjection = CapturedTypeConstructorKt.createCapturedIfNeeded((TypeProjection)it.getFirst(), (TypeParameterDescriptor)it.getSecond());
                collection.add(typeProjection);
            }
            collection = (List)destination$iv$iv;
            Collection thisCollection$iv = $receiver$iv = (Collection)collection;
            TypeProjection[] typeProjectionArray = thisCollection$iv.toArray(new TypeProjection[thisCollection$iv.size()]);
            if (typeProjectionArray == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            collection = typeProjectionArray;
            indexedParametersSubstitution2(typeParameterDescriptorArray, (TypeProjection[])collection, needApproximation);
            typeSubstitution = indexedParametersSubstitution3;
        } else {
            typeSubstitution = new DelegatedTypeSubstitution($receiver, needApproximation, $receiver){
                final /* synthetic */ TypeSubstitution receiver$0;
                final /* synthetic */ boolean $needApproximation;

                public boolean approximateContravariantCapturedTypes() {
                    return this.$needApproximation;
                }

                @Nullable
                public TypeProjection get(@NotNull KotlinType key) {
                    TypeProjection typeProjection;
                    Intrinsics.checkParameterIsNotNull(key, "key");
                    TypeProjection typeProjection2 = super.get(key);
                    if (typeProjection2 != null) {
                        ClassifierDescriptor classifierDescriptor = key.getConstructor().getDeclarationDescriptor();
                        if (!(classifierDescriptor instanceof TypeParameterDescriptor)) {
                            classifierDescriptor = null;
                        }
                        typeProjection = CapturedTypeConstructorKt.access$createCapturedIfNeeded(typeProjection2, (TypeParameterDescriptor)classifierDescriptor);
                    } else {
                        typeProjection = null;
                    }
                    return typeProjection;
                }
                {
                    this.receiver$0 = $receiver;
                    this.$needApproximation = $captured_local_variable$1;
                    super($super_call_param$2);
                }
            };
        }
        return typeSubstitution;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ TypeSubstitution wrapWithCapturingSubstitution$default(TypeSubstitution typeSubstitution, boolean bl, int n, Object object) {
        if ((n & 1) != 0) {
            bl = true;
        }
        return CapturedTypeConstructorKt.wrapWithCapturingSubstitution(typeSubstitution, bl);
    }

    private static final TypeProjection createCapturedIfNeeded(@NotNull TypeProjection $receiver, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || Intrinsics.areEqual((Object)$receiver.getProjectionKind(), (Object)Variance.INVARIANT)) {
            return $receiver;
        }
        if (Intrinsics.areEqual((Object)typeParameterDescriptor.getVariance(), (Object)$receiver.getProjectionKind())) {
            TypeProjection typeProjection;
            if ($receiver.isStarProjection()) {
                StorageManager storageManager = LockBasedStorageManager.NO_LOCKS;
                Intrinsics.checkExpressionValueIsNotNull(storageManager, "LockBasedStorageManager.NO_LOCKS");
                typeProjection = new TypeProjectionImpl(new LazyWrappedType(storageManager, (Function0<? extends KotlinType>)new Function0<KotlinType>($receiver){
                    final /* synthetic */ TypeProjection receiver$0;

                    @NotNull
                    public final KotlinType invoke() {
                        KotlinType kotlinType = this.receiver$0.getType();
                        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "this@createCapturedIfNeeded.type");
                        return kotlinType;
                    }
                    {
                        this.receiver$0 = typeProjection;
                        super(0);
                    }
                }));
            } else {
                typeProjection = new TypeProjectionImpl($receiver.getType());
            }
            return typeProjection;
        }
        return new TypeProjectionImpl(CapturedTypeConstructorKt.createCapturedType($receiver));
    }

    @NotNull
    public static final /* synthetic */ TypeProjection access$createCapturedIfNeeded(@NotNull TypeProjection $receiver, @Nullable TypeParameterDescriptor typeParameterDescriptor) {
        return CapturedTypeConstructorKt.createCapturedIfNeeded($receiver, typeParameterDescriptor);
    }
}

