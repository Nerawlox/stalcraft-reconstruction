/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.IndexedParametersSubstitution;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TypeConstructorSubstitution
extends TypeSubstitution {
    public static final Companion Companion = new Companion(null);

    @Override
    @Nullable
    public TypeProjection get(@NotNull KotlinType key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return this.get(key.getConstructor());
    }

    @Nullable
    public abstract TypeProjection get(@NotNull TypeConstructor var1);

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map2, boolean approximateCapturedTypes2) {
        Intrinsics.checkParameterIsNotNull(map2, "map");
        return Companion.createByConstructorsMap(map2, approximateCapturedTypes2);
    }

    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map2) {
        return kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution$Companion.createByConstructorsMap$default(Companion, map2, false, 2, null);
    }

    @JvmStatic
    @NotNull
    public static final TypeConstructorSubstitution createByParametersMap(@NotNull Map<TypeParameterDescriptor, ? extends TypeProjection> map2) {
        Intrinsics.checkParameterIsNotNull(map2, "map");
        return Companion.createByParametersMap(map2);
    }

    @JvmStatic
    @NotNull
    public static final TypeSubstitution create(@NotNull KotlinType kotlinType) {
        Intrinsics.checkParameterIsNotNull(kotlinType, "kotlinType");
        return Companion.create(kotlinType);
    }

    @JvmStatic
    @NotNull
    public static final TypeSubstitution create(@NotNull TypeConstructor typeConstructor2, @NotNull List<? extends TypeProjection> arguments2) {
        Intrinsics.checkParameterIsNotNull(typeConstructor2, "typeConstructor");
        Intrinsics.checkParameterIsNotNull(arguments2, "arguments");
        return Companion.create(typeConstructor2, arguments2);
    }

    public static final class Companion {
        @JvmStatic
        @JvmOverloads
        @NotNull
        public final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map2, boolean approximateCapturedTypes2) {
            Intrinsics.checkParameterIsNotNull(map2, "map");
            return new TypeConstructorSubstitution(map2, approximateCapturedTypes2){
                final /* synthetic */ Map $map;
                final /* synthetic */ boolean $approximateCapturedTypes;

                @Nullable
                public TypeProjection get(@NotNull TypeConstructor key) {
                    Intrinsics.checkParameterIsNotNull(key, "key");
                    return (TypeProjection)this.$map.get(key);
                }

                public boolean isEmpty() {
                    return this.$map.isEmpty();
                }

                public boolean approximateCapturedTypes() {
                    return this.$approximateCapturedTypes;
                }
                {
                    this.$map = $captured_local_variable$0;
                    this.$approximateCapturedTypes = $captured_local_variable$1;
                }
            };
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public static /* bridge */ /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion companion, Map map2, boolean bl, int n, Object object) {
            if ((n & 2) != 0) {
                bl = false;
            }
            return companion.createByConstructorsMap(map2, bl);
        }

        @JvmStatic
        @JvmOverloads
        @NotNull
        public final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> map2) {
            return kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution$Companion.createByConstructorsMap$default(this, map2, false, 2, null);
        }

        @JvmStatic
        @NotNull
        public final TypeConstructorSubstitution createByParametersMap(@NotNull Map<TypeParameterDescriptor, ? extends TypeProjection> map2) {
            Intrinsics.checkParameterIsNotNull(map2, "map");
            return new TypeConstructorSubstitution(map2){
                final /* synthetic */ Map $map;

                @Nullable
                public TypeProjection get(@NotNull TypeConstructor key) {
                    Intrinsics.checkParameterIsNotNull(key, "key");
                    Map map2 = this.$map;
                    ClassifierDescriptor classifierDescriptor = key.getDeclarationDescriptor();
                    Map map3 = map2;
                    if (map3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
                    }
                    return (TypeProjection)map3.get(classifierDescriptor);
                }

                public boolean isEmpty() {
                    return this.$map.isEmpty();
                }
                {
                    this.$map = $captured_local_variable$0;
                }
            };
        }

        @JvmStatic
        @NotNull
        public final TypeSubstitution create(@NotNull KotlinType kotlinType) {
            Intrinsics.checkParameterIsNotNull(kotlinType, "kotlinType");
            return this.create(kotlinType.getConstructor(), kotlinType.getArguments());
        }

        /*
         * WARNING - void declaration
         */
        @JvmStatic
        @NotNull
        public final TypeSubstitution create(@NotNull TypeConstructor typeConstructor2, @NotNull List<? extends TypeProjection> arguments2) {
            Intrinsics.checkParameterIsNotNull(typeConstructor2, "typeConstructor");
            Intrinsics.checkParameterIsNotNull(arguments2, "arguments");
            List<TypeParameterDescriptor> parameters2 = typeConstructor2.getParameters();
            TypeParameterDescriptor typeParameterDescriptor = CollectionsKt.lastOrNull(parameters2);
            if (typeParameterDescriptor != null ? typeParameterDescriptor.isCapturedFromOuterDeclaration() : false) {
                Collection<TypeConstructor> collection;
                void $receiver$iv$iv;
                void $receiver$iv;
                Iterable iterable = typeConstructor2.getParameters();
                Companion companion = this;
                void var6_6 = $receiver$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (Object item$iv$iv : $receiver$iv$iv) {
                    void it;
                    TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor)item$iv$iv;
                    collection = destination$iv$iv;
                    TypeConstructor typeConstructor3 = it.getTypeConstructor();
                    collection.add(typeConstructor3);
                }
                collection = (List)destination$iv$iv;
                return kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution$Companion.createByConstructorsMap$default(companion, MapsKt.toMap(CollectionsKt.zip((Iterable)collection, (Iterable)arguments2)), false, 2, null);
            }
            List<TypeParameterDescriptor> list = parameters2;
            Intrinsics.checkExpressionValueIsNotNull(list, "parameters");
            return new IndexedParametersSubstitution(list, arguments2);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

