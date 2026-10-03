/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.checker.IntersectionTypeKt;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker$WhenMappings;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerKt;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.StrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import org.jetbrains.annotations.NotNull;

public final class NewKotlinTypeChecker
implements KotlinTypeChecker {
    public static final NewKotlinTypeChecker INSTANCE;

    @Override
    public boolean isSubtypeOf(@NotNull KotlinType subtype, @NotNull KotlinType supertype) {
        TypeCheckerContext typeCheckerContext;
        Intrinsics.checkParameterIsNotNull(subtype, "subtype");
        Intrinsics.checkParameterIsNotNull(supertype, "supertype");
        TypeCheckerContext $receiver = typeCheckerContext = new TypeCheckerContext(true);
        return INSTANCE.isSubtypeOf($receiver, subtype.unwrap(), supertype.unwrap());
    }

    @Override
    public boolean equalTypes(@NotNull KotlinType a, @NotNull KotlinType b) {
        TypeCheckerContext typeCheckerContext;
        Intrinsics.checkParameterIsNotNull(a, "a");
        Intrinsics.checkParameterIsNotNull(b, "b");
        TypeCheckerContext $receiver = typeCheckerContext = new TypeCheckerContext(false);
        return INSTANCE.equalTypes($receiver, a.unwrap(), b.unwrap());
    }

    public final boolean equalTypes(@NotNull TypeCheckerContext $receiver, @NotNull UnwrappedType a, @NotNull UnwrappedType b) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(a, "a");
        Intrinsics.checkParameterIsNotNull(b, "b");
        if (a == b) {
            return true;
        }
        return this.isSubtypeOf($receiver, a, b) && this.isSubtypeOf($receiver, b, a);
    }

    public final boolean isSubtypeOf(@NotNull TypeCheckerContext $receiver, @NotNull UnwrappedType subType, @NotNull UnwrappedType superType) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(subType, "subType");
        Intrinsics.checkParameterIsNotNull(superType, "superType");
        UnwrappedType newSubType = this.transformToNewType(subType);
        UnwrappedType newSuperType = this.transformToNewType(superType);
        Boolean bl = this.checkSubtypeForSpecialCases($receiver, FlexibleTypesKt.lowerIfFlexible(newSubType), FlexibleTypesKt.upperIfFlexible(newSuperType));
        if (bl != null) {
            Boolean bl2 = bl;
            boolean it = bl2;
            return it;
        }
        Boolean bl3 = $receiver.addSubtypeConstraint(newSubType, newSuperType);
        if (bl3 != null) {
            Boolean bl4 = bl3;
            boolean it = bl4;
            return it;
        }
        return this.isSubtypeOfForSingleClassifierType($receiver, FlexibleTypesKt.lowerIfFlexible(newSubType), FlexibleTypesKt.upperIfFlexible(newSuperType));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final SimpleType transformToNewType(@NotNull SimpleType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        if (type2 instanceof CapturedType) {
            UnwrappedType lowerType2;
            Object object = AddToStdlibKt.check(((CapturedType)type2).getTypeProjection(), transformToNewType.lowerType.1.INSTANCE);
            UnwrappedType unwrappedType = object != null && (object = object.getType()) != null ? ((KotlinType)object).unwrap() : (lowerType2 = null);
            if (((CapturedType)type2).getConstructor().getNewTypeConstructor() == null) {
                Collection<UnwrappedType> collection;
                void $receiver$iv$iv;
                void $receiver$iv;
                NewCapturedTypeConstructor newCapturedTypeConstructor;
                Iterable iterable = ((CapturedType)type2).getConstructor().getSupertypes();
                TypeProjection typeProjection = ((CapturedType)type2).getTypeProjection();
                NewCapturedTypeConstructor newCapturedTypeConstructor2 = newCapturedTypeConstructor;
                NewCapturedTypeConstructor newCapturedTypeConstructor3 = newCapturedTypeConstructor;
                CapturedTypeConstructor capturedTypeConstructor = ((CapturedType)type2).getConstructor();
                void var8_19 = $receiver$iv;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (Object item$iv$iv : $receiver$iv$iv) {
                    void it;
                    KotlinType kotlinType = (KotlinType)item$iv$iv;
                    collection = destination$iv$iv;
                    UnwrappedType unwrappedType2 = it.unwrap();
                    collection.add(unwrappedType2);
                }
                collection = (List)destination$iv$iv;
                newCapturedTypeConstructor2(typeProjection, (List<? extends UnwrappedType>)collection);
                capturedTypeConstructor.setNewTypeConstructor(newCapturedTypeConstructor3);
            }
            NewCapturedTypeConstructor newCapturedTypeConstructor = ((CapturedType)type2).getConstructor().getNewTypeConstructor();
            if (newCapturedTypeConstructor == null) {
                Intrinsics.throwNpe();
            }
            NewCapturedType newCapturedType = new NewCapturedType(CaptureStatus.FOR_SUBTYPING, newCapturedTypeConstructor, lowerType2, type2.getAnnotations(), type2.isMarkedNullable());
            return newCapturedType;
        }
        if (type2.getConstructor() instanceof IntersectionTypeConstructor && type2.isMarkedNullable()) {
            Object object;
            Iterable iterable;
            Iterable $receiver$iv;
            Iterable $receiver$iv$iv = $receiver$iv = (Iterable)type2.getConstructor().getSupertypes();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                KotlinType it = (KotlinType)item$iv$iv;
                iterable = destination$iv$iv;
                object = TypeUtilsKt.makeNullable(it);
                iterable.add(object);
            }
            List newSuperTypes = (List)destination$iv$iv;
            IntersectionTypeConstructor newConstructor = new IntersectionTypeConstructor(newSuperTypes);
            object = newConstructor;
            iterable = type2.getAnnotations();
            List list = CollectionsKt.emptyList();
            MemberScope memberScope2 = newConstructor.createScopeForKotlinType();
            Intrinsics.checkExpressionValueIsNotNull(memberScope2, "newConstructor.createScopeForKotlinType()");
            return KotlinTypeFactory.simpleType((Annotations)iterable, (TypeConstructor)object, list, false, memberScope2);
        }
        if (type2.getConstructor() instanceof IntegerValueTypeConstructor) {
            Collection<KotlinType> collection;
            void $receiver$iv;
            IntersectionTypeConstructor intersectionTypeConstructor;
            Iterable newConstructor = type2.getConstructor().getSupertypes();
            TypeConstructor typeConstructor2 = intersectionTypeConstructor;
            Object object = intersectionTypeConstructor;
            void $receiver$iv$iv = $receiver$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                KotlinType it = (KotlinType)item$iv$iv;
                collection = destination$iv$iv;
                KotlinType kotlinType = TypeUtils.makeNullableAsSpecified(it, type2.isMarkedNullable());
                collection.add(kotlinType);
            }
            collection = (List)destination$iv$iv;
            typeConstructor2(collection);
            IntersectionTypeConstructor newConstructor2 = object;
            typeConstructor2 = newConstructor2;
            object = type2.getAnnotations();
            collection = CollectionsKt.emptyList();
            return KotlinTypeFactory.simpleType((Annotations)object, typeConstructor2, collection, false, type2.getMemberScope());
        }
        return type2;
    }

    @NotNull
    public final UnwrappedType transformToNewType(@NotNull UnwrappedType type2) {
        UnwrappedType unwrappedType;
        Intrinsics.checkParameterIsNotNull(type2, "type");
        UnwrappedType unwrappedType2 = type2;
        if (unwrappedType2 instanceof SimpleType) {
            unwrappedType = this.transformToNewType((SimpleType)type2);
        } else if (unwrappedType2 instanceof FlexibleType) {
            SimpleType newLower = this.transformToNewType(((FlexibleType)type2).getLowerBound());
            SimpleType newUpper = this.transformToNewType(((FlexibleType)type2).getUpperBound());
            unwrappedType = newLower != ((FlexibleType)type2).getLowerBound() || newUpper != ((FlexibleType)type2).getUpperBound() ? KotlinTypeFactory.flexibleType(newLower, newUpper) : type2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return unwrappedType;
    }

    private final Boolean checkSubtypeForSpecialCases(@NotNull TypeCheckerContext $receiver, SimpleType subType, SimpleType superType) {
        if (subType.isError() || superType.isError()) {
            if ($receiver.getErrorTypeEqualsToAnything()) {
                return true;
            }
            if (subType.isMarkedNullable() && !superType.isMarkedNullable()) {
                return false;
            }
            return StrictEqualityTypeChecker.INSTANCE.strictEqualTypes(subType.makeNullableAsSpecified(false), superType.makeNullableAsSpecified(false));
        }
        if (superType instanceof NewCapturedType && ((NewCapturedType)superType).getLowerType() != null && this.isSubtypeOf($receiver, subType, ((NewCapturedType)superType).getLowerType())) {
            return true;
        }
        TypeConstructor typeConstructor2 = superType.getConstructor();
        if (!(typeConstructor2 instanceof IntersectionTypeConstructor)) {
            typeConstructor2 = null;
        }
        IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor)typeConstructor2;
        if (intersectionTypeConstructor != null) {
            boolean bl;
            block8: {
                boolean bl2;
                IntersectionTypeConstructor intersectionTypeConstructor2;
                IntersectionTypeConstructor it = intersectionTypeConstructor2 = intersectionTypeConstructor;
                boolean bl3 = bl2 = !superType.isMarkedNullable();
                if (_Assertions.ENABLED && !bl2) {
                    String string = "Intersection type should not be marked nullable!: " + superType;
                    throw (Throwable)((Object)new AssertionError((Object)string));
                }
                Iterable $receiver$iv = it.getSupertypes();
                for (Object element$iv : $receiver$iv) {
                    KotlinType it2 = (KotlinType)element$iv;
                    if (INSTANCE.isSubtypeOf($receiver, subType, it2.unwrap())) continue;
                    bl = false;
                    break block8;
                }
                bl = true;
            }
            return bl;
        }
        return null;
    }

    private final boolean hasNothingSupertype(@NotNull TypeCheckerContext $receiver, SimpleType type2) {
        return $receiver.anySupertype$kotlin_core(type2, hasNothingSupertype.1.INSTANCE, hasNothingSupertype.2.INSTANCE);
    }

    /*
     * WARNING - void declaration
     */
    private final boolean isSubtypeOfForSingleClassifierType(@NotNull TypeCheckerContext $receiver, SimpleType subType, SimpleType superType) {
        void $receiver$iv$iv;
        boolean bl;
        Object element$iv2;
        List<SimpleType> supertypesWithSameConstructor;
        TypeConstructor superConstructor;
        block12: {
            boolean bl2;
            boolean bl3 = bl2 = NewKotlinTypeCheckerKt.access$isSingleClassifierType$p(subType) || NewKotlinTypeCheckerKt.access$isIntersectionType$p(subType);
            if (_Assertions.ENABLED && !bl2) {
                String string = "Not singleClassifierType and not intersection subType: " + subType;
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            bl2 = NewKotlinTypeCheckerKt.access$isSingleClassifierType$p(superType);
            if (_Assertions.ENABLED && !bl2) {
                String string = "Not singleClassifierType superType: " + superType;
                throw (Throwable)((Object)new AssertionError((Object)string));
            }
            if (!NullabilityChecker.INSTANCE.isPossibleSubtype($receiver, subType, superType)) {
                return false;
            }
            superConstructor = superType.getConstructor();
            supertypesWithSameConstructor = this.findCorrespondingSupertypes($receiver, subType, superConstructor);
            switch (supertypesWithSameConstructor.size()) {
                case 0: {
                    return this.hasNothingSupertype($receiver, subType);
                }
                case 1: {
                    return this.isSubtypeForSameConstructor($receiver, CollectionsKt.first(supertypesWithSameConstructor).getArguments(), superType);
                }
            }
            Iterable $receiver$iv = supertypesWithSameConstructor;
            for (Object element$iv2 : $receiver$iv) {
                SimpleType it = (SimpleType)element$iv2;
                if (!INSTANCE.isSubtypeForSameConstructor($receiver, it.getArguments(), superType)) continue;
                bl = true;
                break block12;
            }
            bl = false;
        }
        if (bl) {
            return true;
        }
        Iterable $receiver$iv = superConstructor.getParameters();
        element$iv2 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $receiver$iv$iv) {
            void $receiver$iv$iv2;
            Iterable $receiver$iv2;
            int n = index$iv$iv++;
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
            int n2 = n;
            Collection collection = destination$iv$iv;
            Iterable iterable = $receiver$iv2 = (Iterable)supertypesWithSameConstructor;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
            for (Object item$iv$iv2 : $receiver$iv$iv2) {
                void index;
                void it;
                SimpleType simpleType2 = (SimpleType)item$iv$iv2;
                Collection collection2 = destination$iv$iv2;
                Object object = CollectionsKt.getOrNull(it.getArguments(), (int)index);
                if (object == null || (object = AddToStdlibKt.check(object, isSubtypeOfForSingleClassifierType.newArguments.1.allProjections.1.1.INSTANCE)) == null || (object = object.getType()) == null || (object = ((KotlinType)object).unwrap()) == null) {
                    String string = "Incorrect type: " + it + ", subType: " + subType + ", superType: " + superType;
                    throw (Throwable)new IllegalStateException(string.toString());
                }
                Object object2 = object;
                collection2.add(object2);
            }
            List allProjections2 = (List)destination$iv$iv2;
            TypeProjection typeProjection = TypeUtilsKt.asTypeProjection(IntersectionTypeKt.intersectTypes(allProjections2));
            collection.add(typeProjection);
        }
        List newArguments2 = (List)destination$iv$iv;
        return this.isSubtypeForSameConstructor($receiver, newArguments2, superType);
    }

    /*
     * WARNING - void declaration
     */
    private final List<SimpleType> findCorrespondingSupertypes(@NotNull TypeCheckerContext $receiver, SimpleType baseType, TypeConstructor constructor) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        findCorrespondingSupertypes.1 collectAndFilter$ = findCorrespondingSupertypes.1.INSTANCE;
        if (NewKotlinTypeCheckerKt.access$isClassType$p(baseType)) {
            return collectAndFilter$.invoke($receiver, baseType, constructor);
        }
        if (!(constructor instanceof ClassDescriptor)) {
            return this.collectAllSupertypesWithGivenTypeConstructor($receiver, baseType, constructor);
        }
        SmartList classTypeSupertypes = new SmartList();
        $receiver.anySupertype$kotlin_core(baseType, findCorrespondingSupertypes.2.INSTANCE, (Function1<? super SimpleType, ? extends TypeCheckerContext.SupertypesPolicy>)new Function1<SimpleType, TypeCheckerContext.SupertypesPolicy>(classTypeSupertypes){
            final /* synthetic */ SmartList $classTypeSupertypes;

            @NotNull
            public final TypeCheckerContext.SupertypesPolicy invoke(@NotNull SimpleType it) {
                TypeCheckerContext.SupertypesPolicy supertypesPolicy;
                Intrinsics.checkParameterIsNotNull(it, "it");
                if (NewKotlinTypeCheckerKt.access$isClassType$p(it)) {
                    this.$classTypeSupertypes.add(it);
                    supertypesPolicy = TypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                } else {
                    supertypesPolicy = TypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                }
                return supertypesPolicy;
            }
            {
                this.$classTypeSupertypes = smartList;
                super(1);
            }
        });
        Iterable iterable = $receiver$iv = (Iterable)classTypeSupertypes;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            SimpleType it;
            SimpleType simpleType2 = it = (SimpleType)element$iv$iv;
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "it");
            Iterable list$iv$iv = findCorrespondingSupertypes.1.INSTANCE.invoke($receiver, simpleType2, constructor);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private final List<SimpleType> collectAllSupertypesWithGivenTypeConstructor(@NotNull TypeCheckerContext $receiver, SimpleType baseType, TypeConstructor constructor) {
        void result2;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        $receiver.anySupertype$kotlin_core(baseType, collectAllSupertypesWithGivenTypeConstructor.1.INSTANCE, (Function1<? super SimpleType, ? extends TypeCheckerContext.SupertypesPolicy>)new Function1<SimpleType, TypeCheckerContext.SupertypesPolicy>(constructor, (Ref.ObjectRef)result2){
            final /* synthetic */ TypeConstructor $constructor;
            final /* synthetic */ Ref.ObjectRef $result;

            @NotNull
            public final TypeCheckerContext.SupertypesPolicy invoke(@NotNull SimpleType it) {
                TypeCheckerContext.SupertypesPolicy supertypesPolicy;
                Intrinsics.checkParameterIsNotNull(it, "it");
                SimpleType current = NewCapturedTypeKt.captureFromArguments$default(it, CaptureStatus.FOR_SUBTYPING, null, 4, null);
                if (Intrinsics.areEqual(current.getConstructor(), this.$constructor)) {
                    if ((List)this.$result.element == null) {
                        this.$result.element = new SmartList<E>();
                    }
                    List list = (List)this.$result.element;
                    if (list == null) {
                        Intrinsics.throwNpe();
                    }
                    list.add(current);
                    supertypesPolicy = TypeCheckerContext.SupertypesPolicy.None.INSTANCE;
                } else {
                    supertypesPolicy = current.getArguments().isEmpty() ? (TypeCheckerContext.SupertypesPolicy)TypeCheckerContext.SupertypesPolicy.LowerIfFlexible.INSTANCE : (TypeCheckerContext.SupertypesPolicy)new TypeCheckerContext.SupertypesPolicy.LowerIfFlexibleWithCustomSubstitutor(TypeConstructorSubstitution.Companion.create(current).buildSubstitutor());
                }
                return supertypesPolicy;
            }
            {
                this.$constructor = typeConstructor2;
                this.$result = objectRef;
                super(1);
            }
        });
        List list = (List)result2.element;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    /*
     * WARNING - void declaration
     */
    private final List<SimpleType> selectOnlyPureKotlinSupertypes(List<? extends SimpleType> supertypes2) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        if (supertypes2.size() < 2) {
            return supertypes2;
        }
        Iterable iterable = $receiver$iv = (Iterable)supertypes2;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            boolean bl;
            block4: {
                SimpleType it = (SimpleType)element$iv$iv;
                Iterable $receiver$iv2 = it.getArguments();
                for (Object element$iv : $receiver$iv2) {
                    TypeProjection it2 = (TypeProjection)element$iv;
                    if (!FlexibleTypesKt.isFlexible(it2.getType())) continue;
                    bl = false;
                    break block4;
                }
                bl = true;
            }
            if (!bl) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        List allPureSupertypes = (List)destination$iv$iv;
        Collection collection = allPureSupertypes;
        if (!collection.isEmpty()) {
            return allPureSupertypes;
        }
        return supertypes2;
    }

    private final Variance effectiveVariance(Variance declared, Variance useSite) {
        if (Intrinsics.areEqual((Object)declared, (Object)Variance.INVARIANT)) {
            return useSite;
        }
        if (Intrinsics.areEqual((Object)useSite, (Object)Variance.INVARIANT)) {
            return declared;
        }
        if (Intrinsics.areEqual((Object)declared, (Object)useSite)) {
            return declared;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    private final boolean isSubtypeForSameConstructor(@NotNull TypeCheckerContext $receiver, List<? extends TypeProjection> capturedSubArguments, SimpleType superType) {
        int n = 0;
        List<TypeParameterDescriptor> parameters2 = superType.getConstructor().getParameters();
        int n2 = ((Collection)parameters2).size() - 1;
        if (n <= n2) {
            while (true) {
                void index;
                TypeProjection superProjection;
                if (!(superProjection = superType.getArguments().get((int)index)).isStarProjection()) {
                    boolean bl;
                    Variance variance;
                    TypeProjection typeProjection;
                    UnwrappedType superArgumentType = superProjection.getType().unwrap();
                    TypeProjection it = typeProjection = capturedSubArguments.get((int)index);
                    boolean bl2 = Intrinsics.areEqual((Object)it.getProjectionKind(), (Object)Variance.INVARIANT);
                    if (_Assertions.ENABLED && !bl2) {
                        String string = "Incorrect sub argument: " + it;
                        throw (Throwable)((Object)new AssertionError((Object)string));
                    }
                    UnwrappedType subArgumentType = it.getType().unwrap();
                    Variance variance2 = parameters2.get((int)index).getVariance();
                    Intrinsics.checkExpressionValueIsNotNull((Object)variance2, "parameters[index].variance");
                    Variance variance3 = superProjection.getProjectionKind();
                    Intrinsics.checkExpressionValueIsNotNull((Object)variance3, "superProjection.projectionKind");
                    if (this.effectiveVariance(variance2, variance3) == null) {
                        return $receiver.getErrorTypeEqualsToAnything();
                    }
                    TypeCheckerContext this_$iv = $receiver;
                    if (TypeCheckerContext.access$getArgumentsDepth$p(this_$iv) > 100) {
                        String string = "Arguments depth is too high. Some related argument: " + subArgumentType;
                        throw (Throwable)new IllegalStateException(string.toString());
                    }
                    TypeCheckerContext typeCheckerContext = this_$iv;
                    int n3 = TypeCheckerContext.access$getArgumentsDepth$p(typeCheckerContext);
                    TypeCheckerContext.access$setArgumentsDepth$p(typeCheckerContext, n3 + 1);
                    TypeCheckerContext $receiver2 = this_$iv;
                    switch (NewKotlinTypeChecker$WhenMappings.$EnumSwitchMapping$0[variance.ordinal()]) {
                        case 1: {
                            bl = INSTANCE.equalTypes($receiver2, subArgumentType, superArgumentType);
                            break;
                        }
                        case 2: {
                            bl = INSTANCE.isSubtypeOf($receiver2, subArgumentType, superArgumentType);
                            break;
                        }
                        case 3: {
                            bl = INSTANCE.isSubtypeOf($receiver2, superArgumentType, subArgumentType);
                            break;
                        }
                        default: {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    boolean result$iv = bl;
                    TypeCheckerContext typeCheckerContext2 = this_$iv;
                    int n4 = TypeCheckerContext.access$getArgumentsDepth$p(typeCheckerContext2);
                    TypeCheckerContext.access$setArgumentsDepth$p(typeCheckerContext2, n4 + -1);
                    boolean correctArgument = result$iv;
                    if (!correctArgument) {
                        return false;
                    }
                }
                if (index == n2) break;
                ++index;
            }
        }
        return true;
    }

    private NewKotlinTypeChecker() {
        INSTANCE = this;
    }

    static {
        new NewKotlinTypeChecker();
    }

    @NotNull
    public static final /* synthetic */ List access$selectOnlyPureKotlinSupertypes(NewKotlinTypeChecker $this, @NotNull List supertypes2) {
        return $this.selectOnlyPureKotlinSupertypes(supertypes2);
    }

    @NotNull
    public static final /* synthetic */ List access$collectAllSupertypesWithGivenTypeConstructor(NewKotlinTypeChecker $this, @NotNull TypeCheckerContext $receiver, @NotNull SimpleType baseType, @NotNull TypeConstructor constructor) {
        return $this.collectAllSupertypesWithGivenTypeConstructor($receiver, baseType, constructor);
    }
}

