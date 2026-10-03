/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.Deserialization;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotationsWithPossibleTargets;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MemberDeserializer {
    private final AnnotationDeserializer annotationDeserializer;
    private final DeserializationContext c;

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @NotNull
    public final PropertyDescriptor loadProperty(@NotNull ProtoBuf.Property proto) {
        block22: {
            block21: {
                block20: {
                    block19: {
                        Intrinsics.checkParameterIsNotNull(proto, "proto");
                        flags = proto.hasFlags() != false ? proto.getFlags() : this.loadOldFlags(proto.getOldFlags());
                        v0 = this.c.getContainingDeclaration();
                        v1 = this.getAnnotations(proto, flags, AnnotatedCallableKind.PROPERTY);
                        v2 = Deserialization.modality(Flags.MODALITY.get(flags));
                        v3 = Deserialization.visibility(Flags.VISIBILITY.get(flags));
                        Intrinsics.checkExpressionValueIsNotNull(v3, "Deserialization.visibili\u2026gs.VISIBILITY.get(flags))");
                        v4 = Flags.IS_VAR.get(flags);
                        Intrinsics.checkExpressionValueIsNotNull(v4, "Flags.IS_VAR.get(flags)");
                        v5 = v4;
                        v6 = this.c.getNameResolver().getName(proto.getName());
                        Intrinsics.checkExpressionValueIsNotNull(v6, "c.nameResolver.getName(proto.name)");
                        v7 = Deserialization.memberKind(Flags.MEMBER_KIND.get(flags));
                        v8 = Flags.IS_LATEINIT.get(flags);
                        Intrinsics.checkExpressionValueIsNotNull(v8, "Flags.IS_LATEINIT.get(flags)");
                        v9 = v8;
                        v10 = Flags.IS_CONST.get(flags);
                        Intrinsics.checkExpressionValueIsNotNull(v10, "Flags.IS_CONST.get(flags)");
                        v11 = v10;
                        v12 = Flags.IS_EXTERNAL_PROPERTY.get(flags);
                        Intrinsics.checkExpressionValueIsNotNull(v12, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
                        v13 = v12;
                        v14 = Flags.IS_DELEGATED.get(flags);
                        Intrinsics.checkExpressionValueIsNotNull(v14, "Flags.IS_DELEGATED.get(flags)");
                        property = new DeserializedPropertyDescriptor(v0, null, v1, v2, v3, v5, v6, v7, v9, v11, v13, v14, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getSinceKotlinInfoTable(), this.c.getContainerSource());
                        v15 = property;
                        v16 = proto.getTypeParameterList();
                        Intrinsics.checkExpressionValueIsNotNull(v16, "proto.typeParameterList");
                        local = DeserializationContext.childContext$default(this.c, v15, v16, null, null, 12, null);
                        v17 = hasGetter = Flags.HAS_GETTER.get(flags);
                        Intrinsics.checkExpressionValueIsNotNull(v17, "hasGetter");
                        receiverAnnotations = v17 != false && ProtoTypeTableUtilKt.hasReceiver(proto) != false ? MemberDeserializer.getReceiverParameterAnnotations$default(this, proto, AnnotatedCallableKind.PROPERTY_GETTER, null, 4, null) : Annotations.Companion.getEMPTY();
                        v18 = property;
                        v19 = TypeDeserializer.type$default(local.getTypeDeserializer(), ProtoTypeTableUtilKt.returnType(proto, this.c.getTypeTable()), null, 2, null);
                        v20 = local.getTypeDeserializer().getOwnTypeParameters();
                        v21 = this.getDispatchReceiverParameter();
                        v22 = ProtoTypeTableUtilKt.receiverType(proto, this.c.getTypeTable());
                        if (v22 != null) {
                            var7_7 = v22;
                            var8_8 = v21;
                            var9_9 /* !! */  = v20;
                            var10_10 /* !! */  = v19;
                            var11_11 = v18;
                            it = var7_7;
                            var13_15 = local.getTypeDeserializer().type(it, receiverAnnotations);
                            v18 = var11_11;
                            v19 = var10_10 /* !! */ ;
                            v20 = var9_9 /* !! */ ;
                            v21 = var8_8;
                            v23 = var13_15;
                        } else {
                            v23 = null;
                        }
                        v18.setType(v19, v20, v21, v23);
                        v24 = hasGetter;
                        Intrinsics.checkExpressionValueIsNotNull(v24, "hasGetter");
                        if (!v24.booleanValue()) break block19;
                        getterFlags = proto.getGetterFlags();
                        if (!proto.hasGetterFlags()) ** GOTO lbl-1000
                        v25 = Flags.IS_NOT_DEFAULT.get(getterFlags);
                        Intrinsics.checkExpressionValueIsNotNull(v25, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
                        if (v25.booleanValue()) {
                            v26 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            v26 = isNotDefault = false;
                        }
                        if (!proto.hasGetterFlags()) ** GOTO lbl-1000
                        v27 = Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags);
                        Intrinsics.checkExpressionValueIsNotNull(v27, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
                        if (v27.booleanValue()) {
                            v28 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            v28 = isExternal = false;
                        }
                        if (!proto.hasGetterFlags()) ** GOTO lbl-1000
                        v29 = Flags.IS_INLINE_ACCESSOR.get(getterFlags);
                        Intrinsics.checkExpressionValueIsNotNull(v29, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
                        if (v29.booleanValue()) {
                            v30 = true;
                        } else lbl-1000:
                        // 2 sources

                        {
                            v30 = isInline = false;
                        }
                        if (isNotDefault) {
                            v31 = new PropertyGetterDescriptorImpl(property, this.getAnnotations(proto, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER), Deserialization.modality(Flags.MODALITY.get(getterFlags)), Deserialization.visibility(Flags.VISIBILITY.get(getterFlags)), isNotDefault == false, isExternal, isInline, property.getKind(), null, SourceElement.NO_SOURCE);
                        } else {
                            v32 = DescriptorFactory.createDefaultGetter(property, Annotations.Companion.getEMPTY());
                            v31 = v32;
                            Intrinsics.checkExpressionValueIsNotNull(v32, "DescriptorFactory.create\u2026perty, Annotations.EMPTY)");
                        }
                        getter = v31;
                        getter.initialize(property.getReturnType());
                        v33 = getter;
                        break block20;
                    }
                    v33 = null;
                }
                getter = v33;
                v34 = Flags.HAS_SETTER.get(flags);
                Intrinsics.checkExpressionValueIsNotNull(v34, "Flags.HAS_SETTER.get(flags)");
                if (!v34.booleanValue()) break block21;
                setterFlags = proto.getSetterFlags();
                if (!proto.hasSetterFlags()) ** GOTO lbl-1000
                v35 = Flags.IS_NOT_DEFAULT.get(setterFlags);
                Intrinsics.checkExpressionValueIsNotNull(v35, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
                if (v35.booleanValue()) {
                    v36 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v36 = isNotDefault = false;
                }
                if (!proto.hasSetterFlags()) ** GOTO lbl-1000
                v37 = Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags);
                Intrinsics.checkExpressionValueIsNotNull(v37, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
                if (v37.booleanValue()) {
                    v38 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v38 = isExternal = false;
                }
                if (!proto.hasGetterFlags()) ** GOTO lbl-1000
                v39 = Flags.IS_INLINE_ACCESSOR.get(setterFlags);
                Intrinsics.checkExpressionValueIsNotNull(v39, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
                if (v39.booleanValue()) {
                    v40 = true;
                } else lbl-1000:
                // 2 sources

                {
                    v40 = isInline = false;
                }
                if (isNotDefault) {
                    setter = new PropertySetterDescriptorImpl(property, this.getAnnotations(proto, setterFlags, AnnotatedCallableKind.PROPERTY_SETTER), Deserialization.modality(Flags.MODALITY.get(setterFlags)), Deserialization.visibility(Flags.VISIBILITY.get(setterFlags)), isNotDefault == false, isExternal, isInline, property.getKind(), null, SourceElement.NO_SOURCE);
                    var10_10 /* !! */  = setter;
                    var11_11 = local;
                    var9_9 /* !! */  = CollectionsKt.emptyList();
                    setterLocal = DeserializationContext.childContext$default((DeserializationContext)var11_11, (DeclarationDescriptor)var10_10 /* !! */ , var9_9 /* !! */ , null, null, 12, null);
                    valueParameters = setterLocal.getMemberDeserializer().valueParameters(CollectionsKt.listOf(proto.getSetterValueParameter()), proto, AnnotatedCallableKind.PROPERTY_SETTER);
                    setter.initialize(CollectionsKt.single(valueParameters));
                    v41 = setter;
                } else {
                    v42 = DescriptorFactory.createDefaultSetter(property, Annotations.Companion.getEMPTY());
                    v41 = v42;
                    Intrinsics.checkExpressionValueIsNotNull(v42, "DescriptorFactory.create\u2026perty, Annotations.EMPTY)");
                }
                break block22;
            }
            v41 = null;
        }
        setter = v41;
        v43 = Flags.HAS_CONSTANT.get(flags);
        Intrinsics.checkExpressionValueIsNotNull(v43, "Flags.HAS_CONSTANT.get(flags)");
        if (v43.booleanValue()) {
            property.setCompileTimeInitializer(this.c.getStorageManager().createNullableLazyValue((Function0)new Function0<ConstantValue<?>>(this, proto, property){
                final /* synthetic */ MemberDeserializer this$0;
                final /* synthetic */ ProtoBuf.Property $proto;
                final /* synthetic */ DeserializedPropertyDescriptor $property;

                @Nullable
                public final ConstantValue<?> invoke() {
                    ProtoContainer protoContainer = MemberDeserializer.access$asProtoContainer(this.this$0, MemberDeserializer.access$getC$p(this.this$0).getContainingDeclaration());
                    if (protoContainer == null) {
                        Intrinsics.throwNpe();
                    }
                    ProtoContainer container = protoContainer;
                    AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>, AnnotationWithTarget> annotationAndConstantLoader = MemberDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader();
                    KotlinType kotlinType = this.$property.getReturnType();
                    Intrinsics.checkExpressionValueIsNotNull(kotlinType, "property.returnType");
                    return annotationAndConstantLoader.loadPropertyConstant(container, this.$proto, kotlinType);
                }
                {
                    this.this$0 = memberDeserializer;
                    this.$proto = property;
                    this.$property = deserializedPropertyDescriptor;
                    super(0);
                }
            }));
        }
        property.initialize(getter, setter);
        return property;
    }

    private final int loadOldFlags(int oldFlags) {
        int lowSixBits = oldFlags & 0x3F;
        int rest = oldFlags >> 8 << 6;
        return lowSixBits + rest;
    }

    @NotNull
    public final SimpleFunctionDescriptor loadFunction(@NotNull ProtoBuf.Function proto) {
        KotlinType kotlinType;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : this.loadOldFlags(proto.getOldFlags());
        Annotations annotations2 = this.getAnnotations(proto, flags, AnnotatedCallableKind.FUNCTION);
        Annotations receiverAnnotations = ProtoTypeTableUtilKt.hasReceiver(proto) ? MemberDeserializer.getReceiverParameterAnnotations$default(this, proto, AnnotatedCallableKind.FUNCTION, null, 4, null) : Annotations.Companion.getEMPTY();
        DeclarationDescriptor declarationDescriptor = this.c.getContainingDeclaration();
        Name name2 = this.c.getNameResolver().getName(proto.getName());
        Intrinsics.checkExpressionValueIsNotNull(name2, "c.nameResolver.getName(proto.name)");
        DeserializedSimpleFunctionDescriptor function = new DeserializedSimpleFunctionDescriptor(declarationDescriptor, null, annotations2, name2, Deserialization.memberKind(Flags.MEMBER_KIND.get(flags)), proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getSinceKotlinInfoTable(), this.c.getContainerSource(), null, 1024, null);
        DeclarationDescriptor declarationDescriptor2 = function;
        List<ProtoBuf.TypeParameter> list = proto.getTypeParameterList();
        Intrinsics.checkExpressionValueIsNotNull(list, "proto.typeParameterList");
        DeserializationContext local = DeserializationContext.childContext$default(this.c, declarationDescriptor2, list, null, null, 12, null);
        DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = function;
        ProtoBuf.Type type2 = ProtoTypeTableUtilKt.receiverType(proto, this.c.getTypeTable());
        if (type2 != null) {
            ProtoBuf.Type type3 = type2;
            DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor2 = deserializedSimpleFunctionDescriptor;
            ProtoBuf.Type it = type3;
            KotlinType kotlinType2 = local.getTypeDeserializer().type(it, receiverAnnotations);
            deserializedSimpleFunctionDescriptor = deserializedSimpleFunctionDescriptor2;
            kotlinType = kotlinType2;
        } else {
            kotlinType = null;
        }
        ReceiverParameterDescriptor receiverParameterDescriptor = this.getDispatchReceiverParameter();
        List<TypeParameterDescriptor> list2 = local.getTypeDeserializer().getOwnTypeParameters();
        MemberDeserializer memberDeserializer = local.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> list3 = proto.getValueParameterList();
        Intrinsics.checkExpressionValueIsNotNull(list3, "proto.valueParameterList");
        deserializedSimpleFunctionDescriptor.initialize(kotlinType, receiverParameterDescriptor, list2, (List)memberDeserializer.valueParameters(list3, proto, AnnotatedCallableKind.FUNCTION), TypeDeserializer.type$default(local.getTypeDeserializer(), ProtoTypeTableUtilKt.returnType(proto, this.c.getTypeTable()), null, 2, null), Deserialization.modality(Flags.MODALITY.get(flags)), Deserialization.visibility(Flags.VISIBILITY.get(flags)));
        Boolean bl = Flags.IS_OPERATOR.get(flags);
        Intrinsics.checkExpressionValueIsNotNull(bl, "Flags.IS_OPERATOR.get(flags)");
        function.setOperator(bl);
        Boolean bl2 = Flags.IS_INFIX.get(flags);
        Intrinsics.checkExpressionValueIsNotNull(bl2, "Flags.IS_INFIX.get(flags)");
        function.setInfix(bl2);
        Boolean bl3 = Flags.IS_EXTERNAL_FUNCTION.get(flags);
        Intrinsics.checkExpressionValueIsNotNull(bl3, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
        function.setExternal(bl3);
        Boolean bl4 = Flags.IS_INLINE.get(flags);
        Intrinsics.checkExpressionValueIsNotNull(bl4, "Flags.IS_INLINE.get(flags)");
        function.setInline(bl4);
        Boolean bl5 = Flags.IS_TAILREC.get(flags);
        Intrinsics.checkExpressionValueIsNotNull(bl5, "Flags.IS_TAILREC.get(flags)");
        function.setTailrec(bl5);
        Boolean bl6 = Flags.IS_SUSPEND.get(flags);
        Intrinsics.checkExpressionValueIsNotNull(bl6, "Flags.IS_SUSPEND.get(flags)");
        function.setSuspend(bl6);
        return function;
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public final TypeAliasDescriptor loadTypeAlias(@NotNull ProtoBuf.TypeAlias proto) {
        Collection<AnnotationDescriptor> collection;
        void $receiver$iv$iv;
        void $receiver$iv;
        AnnotationsImpl annotationsImpl;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Iterable iterable = proto.getAnnotationList();
        AnnotationsImpl annotationsImpl2 = annotationsImpl;
        AnnotationsImpl annotationsImpl3 = annotationsImpl;
        void var5_5 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            ProtoBuf.Annotation annotation = (ProtoBuf.Annotation)item$iv$iv;
            collection = destination$iv$iv;
            void v1 = it;
            Intrinsics.checkExpressionValueIsNotNull(v1, "it");
            AnnotationDescriptor annotationDescriptor = this.annotationDeserializer.deserializeAnnotation((ProtoBuf.Annotation)v1, this.c.getNameResolver());
            collection.add(annotationDescriptor);
        }
        collection = (List)destination$iv$iv;
        annotationsImpl2((List<? extends AnnotationDescriptor>)collection);
        AnnotationsImpl annotations2 = annotationsImpl3;
        Visibility visibility = Deserialization.visibility(Flags.VISIBILITY.get(proto.getFlags()));
        DeclarationDescriptor declarationDescriptor = this.c.getContainingDeclaration();
        Annotations annotations3 = annotations2;
        Name name2 = this.c.getNameResolver().getName(proto.getName());
        Intrinsics.checkExpressionValueIsNotNull(name2, "c.nameResolver.getName(proto.name)");
        Visibility visibility2 = visibility;
        Intrinsics.checkExpressionValueIsNotNull(visibility2, "visibility");
        DeserializedTypeAliasDescriptor typeAlias = new DeserializedTypeAliasDescriptor(declarationDescriptor, annotations3, name2, visibility2, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getSinceKotlinInfoTable(), this.c.getContainerSource());
        DeclarationDescriptor declarationDescriptor2 = typeAlias;
        List<ProtoBuf.TypeParameter> list = proto.getTypeParameterList();
        Intrinsics.checkExpressionValueIsNotNull(list, "proto.typeParameterList");
        DeserializationContext local = DeserializationContext.childContext$default(this.c, declarationDescriptor2, list, null, null, 12, null);
        typeAlias.initialize(local.getTypeDeserializer().getOwnTypeParameters(), TypeDeserializer.simpleType$default(local.getTypeDeserializer(), ProtoTypeTableUtilKt.underlyingType(proto, this.c.getTypeTable()), null, 2, null), TypeDeserializer.simpleType$default(local.getTypeDeserializer(), ProtoTypeTableUtilKt.expandedType(proto, this.c.getTypeTable()), null, 2, null));
        return typeAlias;
    }

    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        DeclarationDescriptor declarationDescriptor = this.c.getContainingDeclaration();
        if (!(declarationDescriptor instanceof ClassDescriptor)) {
            declarationDescriptor = null;
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)declarationDescriptor;
        return classDescriptor != null ? classDescriptor.getThisAsReceiverParameter() : null;
    }

    @NotNull
    public final ClassConstructorDescriptor loadConstructor(@NotNull ProtoBuf.Constructor proto, boolean isPrimary) {
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        DeclarationDescriptor declarationDescriptor = this.c.getContainingDeclaration();
        if (declarationDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        ClassDescriptor classDescriptor = (ClassDescriptor)declarationDescriptor;
        DeserializedClassConstructorDescriptor descriptor2 = new DeserializedClassConstructorDescriptor(classDescriptor, null, this.getAnnotations(proto, proto.getFlags(), AnnotatedCallableKind.FUNCTION), isPrimary, CallableMemberDescriptor.Kind.DECLARATION, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getSinceKotlinInfoTable(), this.c.getContainerSource(), null, 1024, null);
        DeclarationDescriptor declarationDescriptor2 = descriptor2;
        DeserializationContext deserializationContext = this.c;
        List list = CollectionsKt.emptyList();
        DeserializationContext local = DeserializationContext.childContext$default(deserializationContext, declarationDescriptor2, list, null, null, 12, null);
        MemberDeserializer memberDeserializer = local.getMemberDeserializer();
        List<ProtoBuf.ValueParameter> list2 = proto.getValueParameterList();
        Intrinsics.checkExpressionValueIsNotNull(list2, "proto.valueParameterList");
        descriptor2.initialize(memberDeserializer.valueParameters(list2, proto, AnnotatedCallableKind.FUNCTION), Deserialization.visibility(Flags.VISIBILITY.get(proto.getFlags())));
        descriptor2.setReturnType(classDescriptor.getDefaultType());
        return descriptor2;
    }

    private final Annotations getAnnotations(MessageLite proto, int flags, AnnotatedCallableKind kind) {
        if (!Flags.HAS_ANNOTATIONS.get(flags).booleanValue()) {
            return Annotations.Companion.getEMPTY();
        }
        return new DeserializedAnnotationsWithPossibleTargets(this.c.getStorageManager(), (Function0<? extends List<AnnotationWithTarget>>)new Function0<List<? extends AnnotationWithTarget>>(this, proto, kind){
            final /* synthetic */ MemberDeserializer this$0;
            final /* synthetic */ MessageLite $proto;
            final /* synthetic */ AnnotatedCallableKind $kind;

            @NotNull
            public final List<AnnotationWithTarget> invoke() {
                Object object;
                List<AnnotationWithTarget> list;
                ProtoContainer protoContainer;
                ProtoContainer protoContainer2 = MemberDeserializer.access$asProtoContainer(this.this$0, MemberDeserializer.access$getC$p(this.this$0).getContainingDeclaration());
                if (protoContainer2 != null) {
                    ProtoContainer it = protoContainer = protoContainer2;
                    list = MemberDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(it, this.$proto, this.$kind);
                } else {
                    list = null;
                }
                if ((object = (protoContainer = list)) == null) {
                    object = CollectionsKt.emptyList();
                }
                return object;
            }
            {
                this.this$0 = memberDeserializer;
                this.$proto = messageLite;
                this.$kind = annotatedCallableKind;
                super(0);
            }
        });
    }

    private final Annotations getReceiverParameterAnnotations(MessageLite proto, AnnotatedCallableKind kind, AnnotatedCallableKind receiverTargetedKind) {
        return new DeserializedAnnotationsWithPossibleTargets(this.c.getStorageManager(), (Function0<? extends List<AnnotationWithTarget>>)new Function0<List<? extends AnnotationWithTarget>>(this, proto, receiverTargetedKind){
            final /* synthetic */ MemberDeserializer this$0;
            final /* synthetic */ MessageLite $proto;
            final /* synthetic */ AnnotatedCallableKind $receiverTargetedKind;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<AnnotationWithTarget> invoke() {
                Object object;
                List list;
                ProtoContainer protoContainer;
                ProtoContainer protoContainer2 = MemberDeserializer.access$asProtoContainer(this.this$0, MemberDeserializer.access$getC$p(this.this$0).getContainingDeclaration());
                if (protoContainer2 != null) {
                    void $receiver$iv$iv;
                    ProtoContainer it = protoContainer = protoContainer2;
                    Iterable $receiver$iv = MemberDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations(it, this.$proto, this.$receiverTargetedKind);
                    Iterable iterable = $receiver$iv;
                    Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                    for (T item$iv$iv : $receiver$iv$iv) {
                        void it2;
                        AnnotationDescriptor annotationDescriptor = (AnnotationDescriptor)item$iv$iv;
                        Collection collection = destination$iv$iv;
                        AnnotationWithTarget annotationWithTarget = new AnnotationWithTarget((AnnotationDescriptor)it2, AnnotationUseSiteTarget.RECEIVER);
                        collection.add(annotationWithTarget);
                    }
                    list = (List)destination$iv$iv;
                } else {
                    list = null;
                }
                if ((object = (protoContainer = list)) == null) {
                    object = CollectionsKt.emptyList();
                }
                return object;
            }
            {
                this.this$0 = memberDeserializer;
                this.$proto = messageLite;
                this.$receiverTargetedKind = annotatedCallableKind;
                super(0);
            }
        });
    }

    static /* bridge */ /* synthetic */ Annotations getReceiverParameterAnnotations$default(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, AnnotatedCallableKind annotatedCallableKind2, int n, Object object) {
        if ((n & 4) != 0) {
            annotatedCallableKind2 = annotatedCallableKind;
        }
        return memberDeserializer.getReceiverParameterAnnotations(messageLite, annotatedCallableKind, annotatedCallableKind2);
    }

    /*
     * WARNING - void declaration
     */
    private final List<ValueParameterDescriptor> valueParameters(List<ProtoBuf.ValueParameter> valueParameters, MessageLite callable, AnnotatedCallableKind kind) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        DeclarationDescriptor declarationDescriptor = this.c.getContainingDeclaration();
        if (declarationDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        }
        CallableDescriptor callableDescriptor = (CallableDescriptor)declarationDescriptor;
        ProtoContainer containerOfCallable = this.asProtoContainer(callableDescriptor.getContainingDeclaration());
        Iterable iterable = $receiver$iv = (Iterable)valueParameters;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $receiver$iv$iv) {
            KotlinType kotlinType;
            Annotations annotations2;
            Annotations annotations3;
            Object object;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl2;
            CallableDescriptor callableDescriptor2;
            ValueParameterDescriptor valueParameterDescriptor;
            void var17_17;
            void i;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl3;
            void proto;
            int n = index$iv$iv++;
            ProtoBuf.ValueParameter valueParameter = (ProtoBuf.ValueParameter)item$iv$iv;
            int n2 = n;
            Collection collection = destination$iv$iv;
            int flags = proto.hasFlags() ? proto.getFlags() : 0;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl4 = valueParameterDescriptorImpl3;
            ValueParameterDescriptorImpl valueParameterDescriptorImpl5 = valueParameterDescriptorImpl3;
            CallableDescriptor callableDescriptor3 = callableDescriptor;
            ValueParameterDescriptor valueParameterDescriptor2 = null;
            void v7 = i;
            if (containerOfCallable != null) {
                var17_17 = v7;
                valueParameterDescriptor = valueParameterDescriptor2;
                callableDescriptor2 = callableDescriptor3;
                valueParameterDescriptorImpl2 = valueParameterDescriptorImpl4;
                valueParameterDescriptorImpl = valueParameterDescriptorImpl5;
                ProtoContainer container = object;
                annotations3 = new DeserializedAnnotations(this.c.getStorageManager(), (Function0<? extends List<? extends AnnotationDescriptor>>)new Function0<List<? extends AnnotationDescriptor>>(container, (int)i, (ProtoBuf.ValueParameter)proto, this, callableDescriptor, containerOfCallable, callable, kind){
                    final /* synthetic */ ProtoContainer $container;
                    final /* synthetic */ int $i$inlined;
                    final /* synthetic */ ProtoBuf.ValueParameter $proto$inlined;
                    final /* synthetic */ MemberDeserializer this$0;
                    final /* synthetic */ CallableDescriptor $callableDescriptor$inlined;
                    final /* synthetic */ ProtoContainer $containerOfCallable$inlined;
                    final /* synthetic */ MessageLite $callable$inlined;
                    final /* synthetic */ AnnotatedCallableKind $kind$inlined;
                    {
                        this.$container = protoContainer;
                        this.$i$inlined = n;
                        this.$proto$inlined = valueParameter;
                        this.this$0 = memberDeserializer;
                        this.$callableDescriptor$inlined = callableDescriptor;
                        this.$containerOfCallable$inlined = protoContainer2;
                        this.$callable$inlined = messageLite;
                        this.$kind$inlined = annotatedCallableKind;
                        super(0);
                    }

                    public final List<AnnotationDescriptor> invoke() {
                        return MemberDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(this.$container, this.$callable$inlined, this.$kind$inlined, this.$i$inlined, this.$proto$inlined);
                    }
                });
                valueParameterDescriptorImpl5 = valueParameterDescriptorImpl;
                valueParameterDescriptorImpl4 = valueParameterDescriptorImpl2;
                callableDescriptor3 = callableDescriptor2;
                valueParameterDescriptor2 = valueParameterDescriptor;
                v7 = var17_17;
                annotations2 = annotations3;
            } else {
                annotations2 = Annotations.Companion.getEMPTY();
            }
            Name name2 = this.c.getNameResolver().getName(proto.getName());
            Name name3 = name2;
            Intrinsics.checkExpressionValueIsNotNull(name2, "c.nameResolver.getName(proto.name)");
            KotlinType kotlinType2 = TypeDeserializer.type$default(this.c.getTypeDeserializer(), ProtoTypeTableUtilKt.type((ProtoBuf.ValueParameter)proto, this.c.getTypeTable()), null, 2, null);
            Boolean bl = Flags.DECLARES_DEFAULT_VALUE.get(flags);
            Intrinsics.checkExpressionValueIsNotNull(bl, "Flags.DECLARES_DEFAULT_VALUE.get(flags)");
            boolean bl2 = bl;
            Boolean bl3 = Flags.IS_CROSSINLINE.get(flags);
            Intrinsics.checkExpressionValueIsNotNull(bl3, "Flags.IS_CROSSINLINE.get(flags)");
            boolean bl4 = bl3;
            Boolean bl5 = Flags.IS_NOINLINE.get(flags);
            Intrinsics.checkExpressionValueIsNotNull(bl5, "Flags.IS_NOINLINE.get(flags)");
            boolean bl6 = bl5;
            if (ProtoTypeTableUtilKt.varargElementType((ProtoBuf.ValueParameter)proto, this.c.getTypeTable()) != null) {
                boolean bl7 = bl6;
                boolean bl8 = bl4;
                boolean bl9 = bl2;
                KotlinType kotlinType3 = kotlinType2;
                Name name4 = name3;
                annotations3 = annotations2;
                var17_17 = v7;
                valueParameterDescriptor = valueParameterDescriptor2;
                callableDescriptor2 = callableDescriptor3;
                valueParameterDescriptorImpl2 = valueParameterDescriptorImpl4;
                valueParameterDescriptorImpl = valueParameterDescriptorImpl5;
                ProtoBuf.Type it = (ProtoBuf.Type)object;
                KotlinType kotlinType4 = TypeDeserializer.type$default(this.c.getTypeDeserializer(), it, null, 2, null);
                valueParameterDescriptorImpl5 = valueParameterDescriptorImpl;
                valueParameterDescriptorImpl4 = valueParameterDescriptorImpl2;
                callableDescriptor3 = callableDescriptor2;
                valueParameterDescriptor2 = valueParameterDescriptor;
                v7 = var17_17;
                annotations2 = annotations3;
                name3 = name4;
                kotlinType2 = kotlinType3;
                bl2 = bl9;
                bl4 = bl8;
                bl6 = bl7;
                kotlinType = kotlinType4;
            } else {
                kotlinType = null;
            }
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
            valueParameterDescriptorImpl4(callableDescriptor3, valueParameterDescriptor2, (int)v7, annotations2, name3, kotlinType2, bl2, bl4, bl6, kotlinType, sourceElement);
            ValueParameterDescriptorImpl valueParameterDescriptorImpl6 = valueParameterDescriptorImpl5;
            collection.add(valueParameterDescriptorImpl6);
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((List)destination$iv$iv);
    }

    private final ProtoContainer asProtoContainer(@NotNull DeclarationDescriptor $receiver) {
        DeclarationDescriptor declarationDescriptor = $receiver;
        return declarationDescriptor instanceof PackageFragmentDescriptor ? (ProtoContainer)new ProtoContainer.Package(((PackageFragmentDescriptor)$receiver).getFqName(), this.c.getNameResolver(), this.c.getTypeTable(), this.c.getContainerSource()) : (declarationDescriptor instanceof DeserializedClassDescriptor ? (ProtoContainer)((DeserializedClassDescriptor)$receiver).getThisAsProtoContainer$kotlin_core() : null);
    }

    public MemberDeserializer(@NotNull DeserializationContext c) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        this.c = c;
        this.annotationDeserializer = new AnnotationDeserializer(this.c.getComponents().getModuleDescriptor(), this.c.getComponents().getNotFoundClasses());
    }

    @Nullable
    public static final /* synthetic */ ProtoContainer access$asProtoContainer(MemberDeserializer $this, @NotNull DeclarationDescriptor $receiver) {
        return $this.asProtoContainer($receiver);
    }

    @NotNull
    public static final /* synthetic */ DeserializationContext access$getC$p(MemberDeserializer $this) {
        return $this.c;
    }
}

