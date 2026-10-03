/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.Deserialization;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotationsWithPossibleTargets;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeBasedStarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeDeserializer {
    private final Function1<Integer, ClassDescriptor> classDescriptors;
    private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
    private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;
    private final DeserializationContext c;
    private final TypeDeserializer parent;
    private final String debugName;

    @NotNull
    public final List<TypeParameterDescriptor> getOwnTypeParameters() {
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList(this.typeParameterDescriptors.values());
    }

    @NotNull
    public final KotlinType type(@NotNull ProtoBuf.Type proto, @NotNull Annotations additionalAnnotations) {
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(additionalAnnotations, "additionalAnnotations");
        if (proto.hasFlexibleTypeCapabilitiesId()) {
            String id = this.c.getNameResolver().getString(proto.getFlexibleTypeCapabilitiesId());
            SimpleType lowerBound = this.simpleType(proto, additionalAnnotations);
            ProtoBuf.Type type2 = ProtoTypeTableUtilKt.flexibleUpperBound(proto, this.c.getTypeTable());
            if (type2 == null) {
                Intrinsics.throwNpe();
            }
            SimpleType upperBound = this.simpleType(type2, additionalAnnotations);
            FlexibleTypeDeserializer flexibleTypeDeserializer = this.c.getComponents().getFlexibleTypeDeserializer();
            String string = id;
            Intrinsics.checkExpressionValueIsNotNull(string, "id");
            return flexibleTypeDeserializer.create(proto, string, lowerBound, upperBound);
        }
        return this.simpleType(proto, additionalAnnotations);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ KotlinType type$default(TypeDeserializer typeDeserializer, ProtoBuf.Type type2, Annotations annotations2, int n, Object object) {
        if ((n & 2) != 0) {
            annotations2 = Annotations.Companion.getEMPTY();
        }
        return typeDeserializer.type(type2, annotations2);
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final SimpleType simpleType(@NotNull ProtoBuf.Type proto, @NotNull Annotations additionalAnnotations) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        SimpleType localClassifierType;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(additionalAnnotations, "additionalAnnotations");
        SimpleType simpleType2 = proto.hasClassName() ? this.computeLocalClassifierReplacementType(proto.getClassName()) : (localClassifierType = proto.hasTypeAliasName() ? this.computeLocalClassifierReplacementType(proto.getTypeAliasName()) : null);
        if (localClassifierType != null) {
            return localClassifierType;
        }
        TypeConstructor constructor = this.typeConstructor(proto);
        if (ErrorUtils.isError(constructor.getDeclarationDescriptor())) {
            SimpleType simpleType3 = ErrorUtils.createErrorTypeWithCustomConstructor(constructor.toString(), constructor);
            Intrinsics.checkExpressionValueIsNotNull(simpleType3, "ErrorUtils.createErrorTy\u2026.toString(), constructor)");
            return simpleType3;
        }
        DeserializedAnnotationsWithPossibleTargets annotations2 = new DeserializedAnnotationsWithPossibleTargets(this.c.getStorageManager(), (Function0<? extends List<AnnotationWithTarget>>)new Function0<List<? extends AnnotationWithTarget>>(this, proto, additionalAnnotations){
            final /* synthetic */ TypeDeserializer this$0;
            final /* synthetic */ ProtoBuf.Type $proto;
            final /* synthetic */ Annotations $additionalAnnotations;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<AnnotationWithTarget> invoke() {
                void var3_3;
                void $receiver$iv$iv;
                Iterable $receiver$iv = TypeDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations(this.$proto, TypeDeserializer.access$getC$p(this.this$0).getNameResolver());
                Iterable iterable = $receiver$iv;
                Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (T item$iv$iv : $receiver$iv$iv) {
                    void it;
                    AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    AnnotationWithTarget annotationWithTarget = new AnnotationWithTarget((AnnotationDescriptor)it, null);
                    collection.add(annotationWithTarget);
                }
                return CollectionsKt.plus((Collection)((List)var3_3), (Iterable)this.$additionalAnnotations.getAllAnnotations());
            }
            {
                this.this$0 = typeDeserializer;
                this.$proto = type2;
                this.$additionalAnnotations = annotations2;
                super(0);
            }
        });
        Function1<ProtoBuf.Type, List<? extends ProtoBuf.Type.Argument>> collectAllArguments$ = new Function1<ProtoBuf.Type, List<? extends ProtoBuf.Type.Argument>>(this){
            final /* synthetic */ TypeDeserializer this$0;

            @NotNull
            public final List<ProtoBuf.Type.Argument> invoke(@NotNull ProtoBuf.Type $receiver) {
                Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
                ProtoBuf.Type type2 = ProtoTypeTableUtilKt.outerType($receiver, TypeDeserializer.access$getC$p(this.this$0).getTypeTable());
                List<ProtoBuf.Type.Argument> list = type2 != null ? this.invoke(type2) : null;
                Collection collection = $receiver.getArgumentList();
                List<ProtoBuf.Type.Argument> list2 = list;
                if (list2 == null) {
                    list2 = CollectionsKt.emptyList();
                }
                List<ProtoBuf.Type.Argument> list3 = list2;
                return CollectionsKt.plus(collection, (Iterable)list3);
            }
            {
                this.this$0 = typeDeserializer;
                super(1);
            }
        };
        Iterable iterable = $receiver$iv = (Iterable)collectAllArguments$.invoke(proto);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $receiver$iv$iv) {
            void proto2;
            void index;
            int n = index$iv$iv++;
            ProtoBuf.Type.Argument argument = (ProtoBuf.Type.Argument)item$iv$iv;
            int n2 = n;
            Collection collection = destination$iv$iv;
            TypeProjection typeProjection = this.typeArgument(CollectionsKt.getOrNull(constructor.getParameters(), (int)index), (ProtoBuf.Type.Argument)proto2);
            collection.add(typeProjection);
        }
        List arguments2 = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((List)destination$iv$iv);
        Boolean bl = Flags.SUSPEND_TYPE.get(proto.getFlags());
        Intrinsics.checkExpressionValueIsNotNull(bl, "Flags.SUSPEND_TYPE.get(proto.flags)");
        SimpleType simpleType4 = bl != false ? this.createSuspendFunctionType(annotations2, constructor, arguments2, proto.getNullable()) : KotlinTypeFactory.simpleType$default(annotations2, constructor, arguments2, proto.getNullable(), null, 16, null);
        ProtoBuf.Type type2 = ProtoTypeTableUtilKt.abbreviatedType(proto, this.c.getTypeTable());
        if (type2 == null) {
            return simpleType4;
        }
        ProtoBuf.Type abbreviatedTypeProto = type2;
        return SpecialTypesKt.withAbbreviation(simpleType4, this.simpleType(abbreviatedTypeProto, additionalAnnotations));
    }

    @NotNull
    public static /* bridge */ /* synthetic */ SimpleType simpleType$default(TypeDeserializer typeDeserializer, ProtoBuf.Type type2, Annotations annotations2, int n, Object object) {
        if ((n & 2) != 0) {
            annotations2 = Annotations.Companion.getEMPTY();
        }
        return typeDeserializer.simpleType(type2, annotations2);
    }

    private final TypeConstructor typeConstructor(ProtoBuf.Type proto) {
        Object object;
        if (proto.hasClassName()) {
            object = this.classDescriptors.invoke(proto.getClassName());
            if (object == null || (object = object.getTypeConstructor()) == null) {
                object = this.c.getComponents().getNotFoundClasses().getClass(proto, this.c.getNameResolver(), this.c.getTypeTable());
            }
        } else if (proto.hasTypeParameter()) {
            object = this.typeParameterTypeConstructor(proto.getTypeParameter());
            if (object == null) {
                TypeConstructor typeConstructor2 = ErrorUtils.createErrorTypeConstructor("Unknown type parameter " + proto.getTypeParameter());
                object = typeConstructor2;
                Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "ErrorUtils.createErrorTy\u2026 ${proto.typeParameter}\")");
            }
        } else if (proto.hasTypeParameterName()) {
            TypeParameterDescriptor parameter;
            Object v2;
            String name2;
            DeclarationDescriptor container;
            block13: {
                Iterable iterable;
                container = this.c.getContainingDeclaration();
                name2 = this.c.getNameResolver().getString(proto.getTypeParameterName());
                Iterable iterable2 = iterable = (Iterable)this.getOwnTypeParameters();
                for (Object t : iterable2) {
                    TypeParameterDescriptor it = (TypeParameterDescriptor)t;
                    if (!Intrinsics.areEqual(it.getName().asString(), name2)) continue;
                    v2 = t;
                    break block13;
                }
                v2 = null;
            }
            if ((object = (parameter = (TypeParameterDescriptor)v2)) == null || (object = object.getTypeConstructor()) == null) {
                TypeConstructor typeConstructor3 = ErrorUtils.createErrorTypeConstructor("Deserialized type parameter " + name2 + " in " + container);
                object = typeConstructor3;
                Intrinsics.checkExpressionValueIsNotNull(typeConstructor3, "ErrorUtils.createErrorTy\u2026ter $name in $container\")");
            }
        } else if (proto.hasTypeAliasName()) {
            object = this.typeAliasDescriptors.invoke(proto.getTypeAliasName());
            if (object == null || (object = object.getTypeConstructor()) == null) {
                object = this.c.getComponents().getNotFoundClasses().getTypeAlias(proto, this.c.getNameResolver(), this.c.getTypeTable());
            }
        } else {
            TypeConstructor typeConstructor4 = ErrorUtils.createErrorTypeConstructor("Unknown type");
            object = typeConstructor4;
            Intrinsics.checkExpressionValueIsNotNull(typeConstructor4, "ErrorUtils.createErrorTy\u2026nstructor(\"Unknown type\")");
        }
        return object;
    }

    private final SimpleType createSuspendFunctionType(Annotations annotations2, TypeConstructor functionTypeConstructor, List<? extends TypeProjection> arguments2, boolean nullable) {
        SimpleType result2;
        SimpleType simpleType2;
        SimpleType simpleType3;
        switch (functionTypeConstructor.getParameters().size() - arguments2.size()) {
            case 0: {
                SimpleType functionType = KotlinTypeFactory.simpleType$default(annotations2, functionTypeConstructor, arguments2, nullable, null, 16, null);
                SimpleType simpleType4 = AddToStdlibKt.check(functionType, createSuspendFunctionType.result.1.INSTANCE);
                if (simpleType4 != null) {
                    SimpleType simpleType5 = simpleType4;
                    KotlinType p1 = simpleType5;
                    simpleType3 = SuspendFunctionTypesKt.transformRuntimeFunctionTypeToSuspendFunction(p1);
                    break;
                }
                simpleType3 = null;
                break;
            }
            case 1: {
                int arity = arguments2.size() - 1;
                if (arity >= 0) {
                    TypeConstructor typeConstructor2 = functionTypeConstructor.getBuiltIns().getSuspendFunction(arity).getTypeConstructor();
                    Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "functionTypeConstructor.\u2026on(arity).typeConstructor");
                    simpleType3 = KotlinTypeFactory.simpleType$default(annotations2, typeConstructor2, arguments2, nullable, null, 16, null);
                    break;
                }
                simpleType3 = null;
                break;
            }
            default: {
                simpleType3 = null;
            }
        }
        if ((simpleType2 = (result2 = simpleType3)) == null) {
            SimpleType simpleType6 = ErrorUtils.createErrorTypeWithArguments("Bad suspend function in metadata with constructor: " + functionTypeConstructor, arguments2);
            simpleType2 = simpleType6;
            Intrinsics.checkExpressionValueIsNotNull(simpleType6, "ErrorUtils.createErrorTy\u2026eConstructor\", arguments)");
        }
        return simpleType2;
    }

    private final TypeConstructor typeParameterTypeConstructor(int typeParameterId) {
        Object object = this.typeParameterDescriptors.get(typeParameterId);
        if (object == null || (object = object.getTypeConstructor()) == null) {
            TypeDeserializer typeDeserializer = this.parent;
            object = typeDeserializer != null ? typeDeserializer.typeParameterTypeConstructor(typeParameterId) : null;
        }
        return object;
    }

    private final ClassDescriptor computeClassDescriptor(int fqNameIndex) {
        ClassId id = this.c.getNameResolver().getClassId(fqNameIndex);
        if (id.isLocal()) {
            DeserializationComponents deserializationComponents = this.c.getComponents();
            ClassId classId = id;
            Intrinsics.checkExpressionValueIsNotNull(classId, "id");
            return deserializationComponents.deserializeClass(classId);
        }
        ModuleDescriptor moduleDescriptor = this.c.getComponents().getModuleDescriptor();
        ClassId classId = id;
        Intrinsics.checkExpressionValueIsNotNull(classId, "id");
        return FindClassInModuleKt.findClassAcrossModuleDependencies(moduleDescriptor, classId);
    }

    private final SimpleType computeLocalClassifierReplacementType(int className) {
        if (this.c.getNameResolver().getClassId(className).isLocal()) {
            return this.c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
        }
        return null;
    }

    private final ClassifierDescriptor computeTypeAliasDescriptor(int fqNameIndex) {
        ClassId id = this.c.getNameResolver().getClassId(fqNameIndex);
        if (id.isLocal()) {
            return null;
        }
        ModuleDescriptor moduleDescriptor = this.c.getComponents().getModuleDescriptor();
        ClassId classId = id;
        Intrinsics.checkExpressionValueIsNotNull(classId, "id");
        return FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(moduleDescriptor, classId);
    }

    private final TypeProjection typeArgument(TypeParameterDescriptor parameter, ProtoBuf.Type.Argument typeArgumentProto) {
        if (Intrinsics.areEqual(typeArgumentProto.getProjection(), ProtoBuf.Type.Argument.Projection.STAR)) {
            TypeProjection typeProjection;
            if (parameter == null) {
                SimpleType simpleType2 = this.c.getComponents().getModuleDescriptor().getBuiltIns().getNullableAnyType();
                Intrinsics.checkExpressionValueIsNotNull(simpleType2, "c.components.moduleDescr\u2026.builtIns.nullableAnyType");
                typeProjection = new TypeBasedStarProjectionImpl(simpleType2);
            } else {
                typeProjection = new StarProjectionImpl(parameter);
            }
            return typeProjection;
        }
        ProtoBuf.Type.Argument.Projection projection = typeArgumentProto.getProjection();
        Intrinsics.checkExpressionValueIsNotNull(projection, "typeArgumentProto.projection");
        Variance variance = Deserialization.variance(projection);
        ProtoBuf.Type type2 = ProtoTypeTableUtilKt.type(typeArgumentProto, this.c.getTypeTable());
        if (type2 == null) {
            return new TypeProjectionImpl(ErrorUtils.createErrorType("No type recorded"));
        }
        ProtoBuf.Type type3 = type2;
        return new TypeProjectionImpl(variance, TypeDeserializer.type$default(this, type3, null, 2, null));
    }

    @NotNull
    public String toString() {
        return this.debugName + (this.parent == null ? "" : ". Child of " + this.parent.debugName);
    }

    public TypeDeserializer(@NotNull DeserializationContext c, @Nullable TypeDeserializer parent, @NotNull List<ProtoBuf.TypeParameter> typeParameterProtos, @NotNull String debugName) {
        Map map2;
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(typeParameterProtos, "typeParameterProtos");
        Intrinsics.checkParameterIsNotNull(debugName, "debugName");
        this.c = c;
        this.parent = parent;
        this.debugName = debugName;
        this.classDescriptors = this.c.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new Function1<Integer, ClassDescriptor>(this){
            final /* synthetic */ TypeDeserializer this$0;

            @Nullable
            public final ClassDescriptor invoke(int fqNameIndex) {
                return TypeDeserializer.access$computeClassDescriptor(this.this$0, fqNameIndex);
            }
            {
                this.this$0 = typeDeserializer;
                super(1);
            }
        });
        this.typeAliasDescriptors = this.c.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new Function1<Integer, ClassifierDescriptor>(this){
            final /* synthetic */ TypeDeserializer this$0;

            @Nullable
            public final ClassifierDescriptor invoke(int fqNameIndex) {
                return TypeDeserializer.access$computeTypeAliasDescriptor(this.this$0, fqNameIndex);
            }
            {
                this.this$0 = typeDeserializer;
                super(1);
            }
        });
        TypeDeserializer typeDeserializer = this;
        if (typeParameterProtos.isEmpty()) {
            TypeDeserializer typeDeserializer2 = typeDeserializer;
            Map map3 = MapsKt.emptyMap();
            typeDeserializer = typeDeserializer2;
            map2 = map3;
        } else {
            LinkedHashMap result2 = new LinkedHashMap();
            for (IndexedValue indexedValue : CollectionsKt.withIndex((Iterable)typeParameterProtos)) {
                int index = indexedValue.component1();
                ProtoBuf.TypeParameter proto = (ProtoBuf.TypeParameter)indexedValue.component2();
                Map map4 = result2;
                Integer n = proto.getId();
                DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor = new DeserializedTypeParameterDescriptor(this.c, proto, index);
                TypeDeserializer typeDeserializer3 = typeDeserializer;
                map4.put(n, deserializedTypeParameterDescriptor);
                TypeDeserializer typeDeserializer4 = typeDeserializer3;
            }
            map2 = result2;
        }
        typeDeserializer.typeParameterDescriptors = map2;
    }

    @NotNull
    public static final /* synthetic */ DeserializationContext access$getC$p(TypeDeserializer $this) {
        return $this.c;
    }

    @Nullable
    public static final /* synthetic */ ClassDescriptor access$computeClassDescriptor(TypeDeserializer $this, int fqNameIndex) {
        return $this.computeClassDescriptor(fqNameIndex);
    }

    @Nullable
    public static final /* synthetic */ ClassifierDescriptor access$computeTypeAliasDescriptor(TypeDeserializer $this, int fqNameIndex) {
        return $this.computeTypeAliasDescriptor(fqNameIndex);
    }
}

