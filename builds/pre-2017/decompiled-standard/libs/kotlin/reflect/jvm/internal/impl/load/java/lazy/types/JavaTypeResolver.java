/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeFlexibility;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.NotFoundClassesKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawBound;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeResolver {
    private final LazyJavaResolverContext c;
    private final TypeParameterResolver typeParameterResolver;

    @NotNull
    public final KotlinType transformJavaType(@NotNull JavaType javaType, @NotNull JavaTypeAttributes attr) {
        Object object;
        Intrinsics.checkParameterIsNotNull(javaType, "javaType");
        Intrinsics.checkParameterIsNotNull(attr, "attr");
        JavaType javaType2 = javaType;
        if (javaType2 instanceof JavaPrimitiveType) {
            PrimitiveType primitiveType = ((JavaPrimitiveType)javaType).getType();
            SimpleType simpleType2 = primitiveType != null ? this.c.getModule().getBuiltIns().getPrimitiveKotlinType(primitiveType) : this.c.getModule().getBuiltIns().getUnitType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "if (primitiveType != nul\u2026.module.builtIns.unitType");
            object = simpleType2;
        } else if (javaType2 instanceof JavaClassifierType) {
            object = this.transformJavaClassifierType((JavaClassifierType)javaType, attr);
        } else if (javaType2 instanceof JavaArrayType) {
            object = JavaTypeResolver.transformArrayType$default(this, (JavaArrayType)javaType, attr, false, 4, null);
        } else if (javaType2 instanceof JavaWildcardType) {
            Object object2;
            JavaType it;
            object = ((JavaWildcardType)javaType).getBound();
            if (object == null || (object = this.transformJavaType(it = (JavaType)(object2 = object), attr)) == null) {
                SimpleType simpleType3 = this.c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkExpressionValueIsNotNull(simpleType3, "c.module.builtIns.defaultBound");
                object = simpleType3;
            }
        } else {
            throw (Throwable)new UnsupportedOperationException("Unsupported type: " + javaType);
        }
        return object;
    }

    @NotNull
    public final KotlinType transformArrayType(@NotNull JavaArrayType arrayType, @NotNull JavaTypeAttributes attr, boolean isVararg) {
        UnwrappedType unwrappedType;
        PrimitiveType primitiveType;
        JavaTypeResolver javaTypeResolver;
        Intrinsics.checkParameterIsNotNull(arrayType, "arrayType");
        Intrinsics.checkParameterIsNotNull(attr, "attr");
        JavaTypeResolver $receiver = javaTypeResolver = this;
        JavaType javaComponentType = arrayType.getComponentType();
        JavaType javaType = javaComponentType;
        if (!(javaType instanceof JavaPrimitiveType)) {
            javaType = null;
        }
        JavaPrimitiveType javaPrimitiveType = (JavaPrimitiveType)javaType;
        PrimitiveType primitiveType2 = primitiveType = javaPrimitiveType != null ? javaPrimitiveType.getType() : null;
        if (primitiveType != null) {
            SimpleType jetType = $receiver.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(primitiveType);
            if (attr.getAllowFlexible()) {
                SimpleType simpleType2 = jetType;
                Intrinsics.checkExpressionValueIsNotNull(simpleType2, "jetType");
                unwrappedType = KotlinTypeFactory.flexibleType(simpleType2, jetType.makeNullableAsSpecified(true));
            } else {
                unwrappedType = jetType.makeNullableAsSpecified(!attr.isMarkedNotNull());
            }
        } else {
            KotlinType componentType = $receiver.transformJavaType(javaComponentType, JavaTypeResolverKt.toAttributes$default(TypeUsage.TYPE_ARGUMENT, attr.getAllowFlexible(), attr.isForAnnotationParameter(), null, 4, null));
            if (attr.getAllowFlexible()) {
                SimpleType simpleType3 = $receiver.c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, componentType);
                Intrinsics.checkExpressionValueIsNotNull(simpleType3, "c.module.builtIns.getArr\u2026INVARIANT, componentType)");
                unwrappedType = KotlinTypeFactory.flexibleType(simpleType3, $receiver.c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, componentType).makeNullableAsSpecified(true));
            } else {
                Variance projectionKind = Intrinsics.areEqual((Object)attr.getHowThisTypeIsUsed(), (Object)TypeUsage.MEMBER_SIGNATURE_CONTRAVARIANT) || isVararg ? Variance.OUT_VARIANCE : Variance.INVARIANT;
                SimpleType result2 = $receiver.c.getModule().getBuiltIns().getArrayType(projectionKind, componentType);
                unwrappedType = result2.makeNullableAsSpecified(!attr.isMarkedNotNull());
            }
        }
        return unwrappedType.replaceAnnotations(attr.getTypeAnnotations());
    }

    @NotNull
    public static /* bridge */ /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, bl);
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType javaType, JavaTypeAttributes attr) {
        Function0<SimpleType> errorType$ = new Function0<SimpleType>(javaType){
            final /* synthetic */ JavaClassifierType $javaType;

            @NotNull
            public final SimpleType invoke() {
                return ErrorUtils.createErrorType("Unresolved java class " + this.$javaType.getPresentableText());
            }
            {
                this.$javaType = javaClassifierType;
                super(0);
            }
        };
        boolean allowFlexible = attr.getAllowFlexible() && Intrinsics.areEqual((Object)attr.getHowThisTypeIsUsed(), (Object)TypeUsage.SUPERTYPE) ^ true;
        boolean isRaw = javaType.isRaw();
        if (!javaType.isRaw() && !allowFlexible) {
            KotlinType kotlinType;
            SimpleType simpleType2 = this.computeSimpleJavaClassifierType(javaType, attr);
            if (simpleType2 != null) {
                kotlinType = simpleType2;
            } else {
                Object object = errorType$.invoke();
                Intrinsics.checkExpressionValueIsNotNull(object, "errorType()");
                kotlinType = (KotlinType)object;
            }
            return kotlinType;
        }
        Function1<Boolean, SimpleType> computeBound$ = new Function1<Boolean, SimpleType>(this, javaType, attr, allowFlexible, isRaw){
            final /* synthetic */ JavaTypeResolver this$0;
            final /* synthetic */ JavaClassifierType $javaType;
            final /* synthetic */ JavaTypeAttributes $attr;
            final /* synthetic */ boolean $allowFlexible;
            final /* synthetic */ boolean $isRaw;

            @Nullable
            public final SimpleType invoke(boolean lower) {
                return JavaTypeResolver.access$computeSimpleJavaClassifierType(this.this$0, this.$javaType, JavaTypeResolverKt.computeAttributes(this.$attr, this.$allowFlexible, this.$isRaw, lower));
            }
            {
                this.this$0 = javaTypeResolver;
                this.$javaType = javaClassifierType;
                this.$attr = javaTypeAttributes;
                this.$allowFlexible = bl;
                this.$isRaw = bl2;
                super(1);
            }
        };
        SimpleType simpleType3 = computeBound$.invoke(true);
        if (simpleType3 == null) {
            Object object = errorType$.invoke();
            Intrinsics.checkExpressionValueIsNotNull(object, "errorType()");
            return (KotlinType)object;
        }
        SimpleType lower = simpleType3;
        SimpleType simpleType4 = computeBound$.invoke(false);
        if (simpleType4 == null) {
            Object object = errorType$.invoke();
            Intrinsics.checkExpressionValueIsNotNull(object, "errorType()");
            return (KotlinType)object;
        }
        SimpleType upper = simpleType4;
        return javaType.isRaw() ? (KotlinType)new RawTypeImpl(lower, upper) : (KotlinType)KotlinTypeFactory.flexibleType(lower, upper);
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaType, JavaTypeAttributes attr) {
        CompositeAnnotations annotations2 = new CompositeAnnotations(CollectionsKt.listOf(new Annotations[]{new LazyJavaAnnotations(this.c, javaType), attr.getTypeAnnotations()}));
        TypeConstructor typeConstructor2 = this.computeTypeConstructor(javaType, attr);
        if (typeConstructor2 == null) {
            return null;
        }
        TypeConstructor constructor = typeConstructor2;
        List<TypeProjection> arguments2 = this.computeArguments(javaType, attr, constructor);
        boolean isNullable = this.isNullable(javaType, attr);
        return KotlinTypeFactory.simpleType$default(annotations2, constructor, arguments2, isNullable, null, 16, null);
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaType, JavaTypeAttributes attr) {
        Object object;
        JavaClassifier classifier2;
        JavaClassifier javaClassifier = javaType.getClassifier();
        if (javaClassifier == null) {
            return this.createNotFoundClass(javaType);
        }
        JavaClassifier javaClassifier2 = classifier2 = javaClassifier;
        if (javaClassifier2 instanceof JavaClass) {
            ClassDescriptor classData;
            FqName $receiver$iv;
            FqName fqName2 = $receiver$iv = ((JavaClass)classifier2).getFqName();
            if (fqName2 == null) {
                AssertionError assertionError;
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = assertionError;
                String string = "Class type should have a FQ name: " + classifier2;
                assertionError2((Object)string);
                throw (Throwable)((Object)assertionError3);
            }
            FqName fqName3 = fqName2;
            ClassDescriptor classDescriptor = this.mapKotlinClass(javaType, attr, fqName3);
            if (classDescriptor == null) {
                classDescriptor = this.c.getComponents().getModuleClassResolver().resolveClass((JavaClass)classifier2);
            }
            if ((object = (classData = classDescriptor)) == null || (object = object.getTypeConstructor()) == null) {
                object = this.createNotFoundClass(javaType);
            }
        } else if (javaClassifier2 instanceof JavaTypeParameter) {
            TypeParameterDescriptor typeParameterDescriptor = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter)classifier2);
            object = typeParameterDescriptor != null ? typeParameterDescriptor.getTypeConstructor() : null;
        } else {
            throw (Throwable)new IllegalStateException("Unknown classifier kind: " + classifier2);
        }
        return object;
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaType) {
        ClassId classId = NotFoundClassesKt.parseCanonicalFqNameIgnoringTypeArguments(javaType.getCanonicalText());
        return this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsKt.listOf(Integer.valueOf(0)));
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaType, JavaTypeAttributes attr, FqName fqName2) {
        ClassDescriptor kotlinDescriptor;
        block5: {
            JavaToKotlinClassMap javaToKotlin;
            block6: {
                if (attr.isForAnnotationParameter() && Intrinsics.areEqual(fqName2, JavaTypeResolverKt.access$getJAVA_LANG_CLASS_FQ_NAME$p())) {
                    return this.c.getComponents().getReflectionTypes().getKClass();
                }
                javaToKotlin = JavaToKotlinClassMap.INSTANCE;
                TypeUsage howThisTypeIsUsedEffectively = Intrinsics.areEqual((Object)attr.getFlexibility(), (Object)JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND) ? TypeUsage.MEMBER_SIGNATURE_COVARIANT : (Intrinsics.areEqual((Object)attr.getFlexibility(), (Object)JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND) ? TypeUsage.MEMBER_SIGNATURE_CONTRAVARIANT : (!javaToKotlin.isJavaPlatformClass(fqName2) ? attr.getHowThisTypeIsUsed() : attr.getHowThisTypeIsUsedAccordingToAnnotations()));
                ClassDescriptor classDescriptor = javaToKotlin.mapJavaToKotlin(fqName2, this.c.getModule().getBuiltIns());
                if (classDescriptor == null) {
                    return null;
                }
                kotlinDescriptor = classDescriptor;
                if (!javaToKotlin.isReadOnly(kotlinDescriptor)) break block5;
                if (Intrinsics.areEqual((Object)howThisTypeIsUsedEffectively, (Object)TypeUsage.MEMBER_SIGNATURE_COVARIANT) || Intrinsics.areEqual((Object)howThisTypeIsUsedEffectively, (Object)TypeUsage.SUPERTYPE)) break block6;
                ClassDescriptor classDescriptor2 = kotlinDescriptor;
                Intrinsics.checkExpressionValueIsNotNull(classDescriptor2, "kotlinDescriptor");
                if (!this.argumentsMakeSenseOnlyForMutableContainer(javaType, classDescriptor2)) break block5;
            }
            return javaToKotlin.convertReadOnlyToMutable(kotlinDescriptor);
        }
        return kotlinDescriptor;
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(@NotNull JavaClassifierType $receiver, ClassDescriptor readOnlyContainer) {
        argumentsMakeSenseOnlyForMutableContainer.1 isSuperWildcard$ = argumentsMakeSenseOnlyForMutableContainer.1.INSTANCE;
        if (!isSuperWildcard$.invoke(CollectionsKt.lastOrNull($receiver.getTypeArguments()))) {
            return false;
        }
        Object object = CollectionsKt.lastOrNull(JavaToKotlinClassMap.INSTANCE.convertReadOnlyToMutable(readOnlyContainer).getTypeConstructor().getParameters());
        if (object == null || (object = object.getVariance()) == null) {
            return false;
        }
        Object mutableLastParameterVariance = object;
        return Intrinsics.areEqual(mutableLastParameterVariance, (Object)Variance.OUT_VARIANCE) ^ true;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final List<TypeProjection> computeArguments(@NotNull JavaClassifierType javaType, @NotNull JavaTypeAttributes attr, @NotNull TypeConstructor constructor) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable $receiver$iv2;
        JavaTypeResolver javaTypeResolver;
        Intrinsics.checkParameterIsNotNull(javaType, "javaType");
        Intrinsics.checkParameterIsNotNull(attr, "attr");
        Intrinsics.checkParameterIsNotNull(constructor, "constructor");
        JavaTypeResolver $receiver = javaTypeResolver = this;
        boolean eraseTypeParameters = Intrinsics.areEqual((Object)attr.getRawBound(), (Object)RawBound.NOT_RAW) ^ true ? true : javaType.getTypeArguments().isEmpty() && !constructor.getParameters().isEmpty();
        List<TypeParameterDescriptor> typeParameters2 = constructor.getParameters();
        if (eraseTypeParameters) {
            void $receiver$iv$iv2;
            Iterable $i$a$1$run = $receiver$iv2 = (Iterable)typeParameters2;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
            for (Object item$iv$iv : $receiver$iv$iv2) {
                void parameter;
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv;
                KotlinType erasedUpperBound = JavaTypeResolverKt.getErasedUpperBound((TypeParameterDescriptor)parameter, attr.getUpperBoundOfTypeParameter(), (Function0<? extends KotlinType>)new Function0<KotlinType>(attr, constructor){
                    final /* synthetic */ JavaTypeAttributes $attr$inlined;
                    final /* synthetic */ TypeConstructor $constructor$inlined;
                    {
                        this.$attr$inlined = javaTypeAttributes;
                        this.$constructor$inlined = typeConstructor2;
                        super(0);
                    }

                    public final KotlinType invoke() {
                        ClassifierDescriptor classifierDescriptor = this.$constructor$inlined.getDeclarationDescriptor();
                        if (classifierDescriptor == null) {
                            Intrinsics.throwNpe();
                        }
                        return TypeUtilsKt.replaceArgumentsWithStarProjections((KotlinType)classifierDescriptor.getDefaultType());
                    }
                });
                void v0 = parameter;
                Intrinsics.checkExpressionValueIsNotNull(v0, "parameter");
                TypeProjection typeProjection = RawSubstitution.INSTANCE.computeProjection((TypeParameterDescriptor)v0, attr, erasedUpperBound);
                collection.add(typeProjection);
            }
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((List)destination$iv$iv);
        }
        if (typeParameters2.size() != javaType.getTypeArguments().size()) {
            Iterable $receiver$iv$iv2 = $receiver$iv2 = (Iterable)typeParameters2;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
            for (Object item$iv$iv : $receiver$iv$iv2) {
                void p;
                TypeParameterDescriptor parameter = (TypeParameterDescriptor)item$iv$iv;
                Collection collection = destination$iv$iv;
                TypeProjectionImpl typeProjectionImpl = new TypeProjectionImpl(ErrorUtils.createErrorType(p.getName().asString()));
                collection.add(typeProjectionImpl);
            }
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((List)destination$iv$iv);
        }
        TypeUsage howTheProjectionIsUsed = Intrinsics.areEqual((Object)attr.getHowThisTypeIsUsed(), (Object)TypeUsage.SUPERTYPE) ? TypeUsage.SUPERTYPE_ARGUMENT : TypeUsage.TYPE_ARGUMENT;
        Iterable destination$iv$iv = $receiver$iv = CollectionsKt.withIndex((Iterable)javaType.getTypeArguments());
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void javaTypeArgument;
            void i;
            void indexedArgument;
            IndexedValue $i$a$2$map = (IndexedValue)item$iv$iv;
            Collection collection = destination$iv$iv2;
            Object $i$f$mapTo = indexedArgument;
            int $i$f$map = $i$f$mapTo.component1();
            JavaType $i$f$map2 = (JavaType)$i$f$mapTo.component2();
            $i$f$mapTo = null;
            boolean bl = $i$f$mapTo = i < typeParameters2.size();
            if (_Assertions.ENABLED && !$i$f$mapTo) {
                String string = "Argument index should be less then type parameters count, but " + (int)i + " > " + typeParameters2.size();
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            TypeParameterDescriptor parameter = typeParameters2.get((int)i);
            JavaTypeAttributes javaTypeAttributes = JavaTypeResolverKt.toAttributes$default(howTheProjectionIsUsed, false, false, null, 7, null);
            TypeParameterDescriptor typeParameterDescriptor = parameter;
            Intrinsics.checkExpressionValueIsNotNull(typeParameterDescriptor, "parameter");
            TypeProjection typeProjection = this.transformToTypeProjection((JavaType)javaTypeArgument, javaTypeAttributes, typeParameterDescriptor);
            collection.add(typeProjection);
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((List)destination$iv$iv2);
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes attr, TypeParameterDescriptor typeParameter) {
        TypeProjection typeProjection;
        JavaType javaType2 = javaType;
        if (javaType2 instanceof JavaWildcardType) {
            Variance projectionKind;
            JavaType bound = ((JavaWildcardType)javaType).getBound();
            Variance variance = projectionKind = ((JavaWildcardType)javaType).isExtends() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
            typeProjection = bound == null || this.isConflictingArgumentFor(projectionKind, typeParameter) ? JavaTypeResolverKt.makeStarProjection(typeParameter, attr) : TypeUtilsKt.createProjection(this.transformJavaType(bound, JavaTypeResolverKt.toAttributes$default(TypeUsage.UPPER_BOUND, false, false, null, 7, null)), projectionKind, typeParameter);
        } else {
            typeProjection = new TypeProjectionImpl(Variance.INVARIANT, this.transformJavaType(javaType, attr));
        }
        return typeProjection;
    }

    private final boolean isConflictingArgumentFor(@NotNull Variance $receiver, TypeParameterDescriptor typeParameter) {
        if (Intrinsics.areEqual((Object)typeParameter.getVariance(), (Object)Variance.INVARIANT)) {
            return false;
        }
        return Intrinsics.areEqual((Object)$receiver, (Object)typeParameter.getVariance()) ^ true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isNullable(JavaClassifierType javaType, JavaTypeAttributes attr) {
        boolean bl;
        if (Intrinsics.areEqual((Object)attr.getFlexibility(), (Object)JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND)) {
            return false;
        }
        if (Intrinsics.areEqual((Object)attr.getFlexibility(), (Object)JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND)) {
            return true;
        }
        if (attr.isMarkedNotNull()) return false;
        JavaClassifier javaClassifier = javaType.getClassifier();
        if (javaClassifier instanceof JavaTypeParameter) {
            bl = SetsKt.setOf(new TypeUsage[]{TypeUsage.TYPE_ARGUMENT, TypeUsage.UPPER_BOUND, TypeUsage.SUPERTYPE_ARGUMENT, TypeUsage.SUPERTYPE}).contains((Object)attr.getHowThisTypeIsUsed()) ^ true;
        } else if (javaClassifier instanceof JavaClass || Intrinsics.areEqual(javaClassifier, null)) {
            bl = SetsKt.setOf(new TypeUsage[]{TypeUsage.TYPE_ARGUMENT, TypeUsage.SUPERTYPE_ARGUMENT, TypeUsage.SUPERTYPE}).contains((Object)attr.getHowThisTypeIsUsed()) ^ true;
        } else {
            String string = "Unknown classifier: " + javaType.getClassifier();
            throw (Throwable)new IllegalStateException(string.toString());
        }
        if (!bl) return false;
        return true;
    }

    public JavaTypeResolver(@NotNull LazyJavaResolverContext c, @NotNull TypeParameterResolver typeParameterResolver) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(typeParameterResolver, "typeParameterResolver");
        this.c = c;
        this.typeParameterResolver = typeParameterResolver;
    }

    @Nullable
    public static final /* synthetic */ SimpleType access$computeSimpleJavaClassifierType(JavaTypeResolver $this, @NotNull JavaClassifierType javaType, @NotNull JavaTypeAttributes attr) {
        return $this.computeSimpleJavaClassifierType(javaType, attr);
    }
}

