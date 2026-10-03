/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KTypeImpl$WhenMappings;
import kotlin.reflect.jvm.internal.KTypeImpl$arguments$2$parameterizedTypeArguments$1;
import kotlin.reflect.jvm.internal.KTypeParameterImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=1, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00068@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006%"}, d2={"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lorg/jetbrains/kotlin/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "getArguments", "()Ljava/util/List;", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflection", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflection"})
public final class KTypeImpl
implements KType {
    @NotNull
    private final ReflectProperties.LazySoftVal javaType$delegate;
    @Nullable
    private final ReflectProperties.LazySoftVal classifier$delegate;
    @NotNull
    private final ReflectProperties.LazySoftVal arguments$delegate;
    @NotNull
    private final KotlinType type;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    @NotNull
    public final Type getJavaType$kotlin_reflection() {
        return (Type)this.javaType$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override
    @Nullable
    public KClassifier getClassifier() {
        return (KClassifier)this.classifier$delegate.getValue(this, $$delegatedProperties[1]);
    }

    private final KClassifier convert(KotlinType type2) {
        ClassifierDescriptor descriptor2 = type2.getConstructor().getDeclarationDescriptor();
        ClassifierDescriptor classifierDescriptor = descriptor2;
        if (classifierDescriptor instanceof ClassDescriptor) {
            Class<?> clazz = UtilKt.toJavaClass((ClassDescriptor)descriptor2);
            if (clazz == null) {
                return null;
            }
            Class<?> jClass = clazz;
            if (jClass.isArray()) {
                Object argument;
                Object object = CollectionsKt.singleOrNull(type2.getArguments());
                if (object == null || (object = object.getType()) == null) {
                    return new KClassImpl(jClass);
                }
                Object object2 = argument = object;
                Intrinsics.checkExpressionValueIsNotNull(object2, "argument");
                KClassifier kClassifier = this.convert((KotlinType)object2);
                if (kClassifier == null) {
                    throw (Throwable)new KotlinReflectionInternalError("Cannot determine classifier for array element type: " + this);
                }
                KClassifier elementClassifier = kClassifier;
                return new KClassImpl(ReflectClassUtilKt.createArrayType(JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(elementClassifier))));
            }
            if (!TypeUtils.isNullableType(type2)) {
                Class<?> clazz2 = ReflectClassUtilKt.getPrimitiveByWrapper(jClass);
                if (clazz2 == null) {
                    clazz2 = jClass;
                }
                return new KClassImpl(clazz2);
            }
            return new KClassImpl(jClass);
        }
        if (classifierDescriptor instanceof TypeParameterDescriptor) {
            return new KTypeParameterImpl((TypeParameterDescriptor)descriptor2);
        }
        if (classifierDescriptor instanceof TypeAliasDescriptor) {
            String string = "Type alias classifiers are not yet supported";
            throw (Throwable)new NotImplementedError("An operation is not implemented: " + string);
        }
        return null;
    }

    @Override
    @NotNull
    public List<KTypeProjection> getArguments() {
        return (List)this.arguments$delegate.getValue(this, $$delegatedProperties[2]);
    }

    @Override
    public boolean isMarkedNullable() {
        return this.type.isMarkedNullable();
    }

    public boolean equals(@Nullable Object other) {
        return other instanceof KTypeImpl && Intrinsics.areEqual(this.type, ((KTypeImpl)other).type);
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderType(this.type);
    }

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }

    public KTypeImpl(@NotNull KotlinType type2, @NotNull Function0<? extends Type> computeJavaType) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        Intrinsics.checkParameterIsNotNull(computeJavaType, "computeJavaType");
        this.type = type2;
        this.javaType$delegate = ReflectProperties.lazySoft(computeJavaType);
        this.classifier$delegate = ReflectProperties.lazySoft((Function0)new Function0<KClassifier>(this){
            final /* synthetic */ KTypeImpl this$0;

            @Nullable
            public final KClassifier invoke() {
                return KTypeImpl.access$convert(this.this$0, this.this$0.getType());
            }
            {
                this.this$0 = kTypeImpl;
                super(0);
            }
        });
        this.arguments$delegate = ReflectProperties.lazySoft((Function0)new Function0<List<? extends KTypeProjection>>(this){
            final /* synthetic */ KTypeImpl this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<KTypeProjection> invoke() {
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                List<TypeProjection> typeArguments = this.this$0.getType().getArguments();
                if (typeArguments.isEmpty()) {
                    return CollectionsKt.emptyList();
                }
                KProperty kProperty = KTypeImpl$arguments$2$parameterizedTypeArguments$1.INSTANCE;
                Lazy<T> parameterizedTypeArguments2 = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new Function0<List<? extends Type>>(this){
                    final /* synthetic */ arguments.2 this$0;

                    @NotNull
                    public final List<Type> invoke() {
                        return ReflectClassUtilKt.getParameterizedTypeArguments(this.this$0.this$0.getJavaType$kotlin_reflection());
                    }
                    {
                        this.this$0 = var1_1;
                        super(0);
                    }
                });
                Iterable iterable = $receiver$iv = (Iterable)typeArguments;
                Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                int index$iv$iv = 0;
                for (T item$iv$iv : $receiver$iv$iv) {
                    KTypeProjection kTypeProjection;
                    void typeProjection;
                    int n = index$iv$iv++;
                    TypeProjection typeProjection2 = (TypeProjection)item$iv$iv;
                    int n2 = n;
                    Collection collection = destination$iv$iv;
                    if (typeProjection.isStarProjection()) {
                        kTypeProjection = KTypeProjection.Companion.getSTAR();
                    } else {
                        void i;
                        KotlinType kotlinType = typeProjection.getType();
                        Intrinsics.checkExpressionValueIsNotNull(kotlinType, "typeProjection.type");
                        KTypeImpl type2 = new KTypeImpl(kotlinType, (Function0<? extends Type>)new Function0<Type>((int)i, this, parameterizedTypeArguments2, kProperty){
                            final /* synthetic */ int $i;
                            final /* synthetic */ arguments.2 this$0;
                            final /* synthetic */ Lazy $parameterizedTypeArguments$inlined;
                            final /* synthetic */ KProperty $parameterizedTypeArguments$metadata$inlined;
                            {
                                this.$i = n;
                                this.this$0 = var2_2;
                                this.$parameterizedTypeArguments$inlined = lazy;
                                this.$parameterizedTypeArguments$metadata$inlined = kProperty;
                                super(0);
                            }

                            public final Type invoke() {
                                Type type2;
                                Type javaType = this.this$0.this$0.getJavaType$kotlin_reflection();
                                Type type3 = javaType;
                                if (type3 instanceof Class) {
                                    Class clazz = ((Class)javaType).isArray() ? ((Class)javaType).getComponentType() : Object.class;
                                    Intrinsics.checkExpressionValueIsNotNull(clazz, "if (javaType.isArray) ja\u2026Type else Any::class.java");
                                    type2 = (Type)((Object)clazz);
                                } else if (type3 instanceof GenericArrayType) {
                                    if (this.$i != 0) {
                                        throw (Throwable)new KotlinReflectionInternalError("Array type has been queried for a non-0th argument: " + this.this$0.this$0);
                                    }
                                    Type type4 = ((GenericArrayType)javaType).getGenericComponentType();
                                    type2 = type4;
                                    Intrinsics.checkExpressionValueIsNotNull(type4, "javaType.genericComponentType");
                                } else if (type3 instanceof ParameterizedType) {
                                    Type type5;
                                    Lazy lazy = this.$parameterizedTypeArguments$inlined;
                                    Object var4_4 = null;
                                    KProperty kProperty = this.$parameterizedTypeArguments$metadata$inlined;
                                    Type argument = (Type)((List)lazy.getValue()).get(this.$i);
                                    if (!(argument instanceof WildcardType)) {
                                        type5 = argument;
                                    } else {
                                        type5 = (Type)ArraysKt.firstOrNull((Object[])((WildcardType)argument).getLowerBounds());
                                        if (type5 == null) {
                                            type5 = (Type)ArraysKt.first((Object[])((WildcardType)argument).getUpperBounds());
                                        }
                                    }
                                    type2 = type5;
                                    Intrinsics.checkExpressionValueIsNotNull(type5, "if (argument !is Wildcar\u2026ument.upperBounds.first()");
                                } else {
                                    throw (Throwable)new KotlinReflectionInternalError("Non-generic type has been queried for arguments: " + this.this$0.this$0);
                                }
                                return type2;
                            }
                        });
                        switch (KTypeImpl$WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()]) {
                            case 1: {
                                kTypeProjection = KTypeProjection.Companion.invariant(type2);
                                break;
                            }
                            case 2: {
                                kTypeProjection = KTypeProjection.Companion.contravariant(type2);
                                break;
                            }
                            case 3: {
                                kTypeProjection = KTypeProjection.Companion.covariant(type2);
                                break;
                            }
                            default: {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    }
                    KTypeProjection kTypeProjection2 = kTypeProjection;
                    collection.add(kTypeProjection2);
                }
                return (List)destination$iv$iv;
            }
            {
                this.this$0 = kTypeImpl;
                super(0);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeImpl.class), "javaType", "getJavaType$kotlin_reflection()Ljava/lang/reflect/Type;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};
    }

    @Nullable
    public static final /* synthetic */ KClassifier access$convert(KTypeImpl $this, @NotNull KotlinType type2) {
        return $this.convert(type2);
    }
}

