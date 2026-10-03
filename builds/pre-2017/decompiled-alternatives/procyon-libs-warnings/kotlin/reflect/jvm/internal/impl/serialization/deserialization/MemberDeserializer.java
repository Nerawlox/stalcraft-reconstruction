// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import org.jetbrains.annotations.Nullable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotationsWithPossibleTargets;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassConstructorDescriptor;
import kotlin.TypeCastException;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$TypeAlias;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedSimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$ValueParameter;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertySetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyGetterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$MemberKind;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Visibility;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Modality;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf$Property;

public final class MemberDeserializer
{
    private final AnnotationDeserializer annotationDeserializer;
    private final DeserializationContext c;
    
    @NotNull
    public final PropertyDescriptor loadProperty(@NotNull final ProtoBuf$Property proto) {
        Intrinsics.checkParameterIsNotNull((Object)proto, "proto");
        final int flags = proto.hasFlags() ? proto.getFlags() : this.loadOldFlags(proto.getOldFlags());
        final DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        final PropertyDescriptor propertyDescriptor = null;
        final Annotations annotations = this.getAnnotations((MessageLite)proto, flags, AnnotatedCallableKind.PROPERTY);
        final Modality modality = Deserialization.modality((ProtoBuf$Modality)Flags.MODALITY.get(flags));
        final Visibility visibility = Deserialization.visibility((ProtoBuf$Visibility)Flags.VISIBILITY.get(flags));
        Intrinsics.checkExpressionValueIsNotNull((Object)visibility, "Deserialization.visibili\u2026gs.VISIBILITY.get(flags))");
        final Boolean value = Flags.IS_VAR.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value, "Flags.IS_VAR.get(flags)");
        final boolean booleanValue = value;
        final Name name = this.c.getNameResolver().getName(proto.getName());
        Intrinsics.checkExpressionValueIsNotNull((Object)name, "c.nameResolver.getName(proto.name)");
        final CallableMemberDescriptor$Kind memberKind = Deserialization.memberKind((ProtoBuf$MemberKind)Flags.MEMBER_KIND.get(flags));
        final Boolean value2 = Flags.IS_LATEINIT.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value2, "Flags.IS_LATEINIT.get(flags)");
        final boolean booleanValue2 = value2;
        final Boolean value3 = Flags.IS_CONST.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value3, "Flags.IS_CONST.get(flags)");
        final boolean booleanValue3 = value3;
        final Boolean value4 = Flags.IS_EXTERNAL_PROPERTY.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value4, "Flags.IS_EXTERNAL_PROPERTY.get(flags)");
        final boolean booleanValue4 = value4;
        final Boolean value5 = Flags.IS_DELEGATED.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value5, "Flags.IS_DELEGATED.get(flags)");
        final DeserializedPropertyDescriptor property = new DeserializedPropertyDescriptor(containingDeclaration, propertyDescriptor, annotations, modality, visibility, booleanValue, name, memberKind, booleanValue2, booleanValue3, booleanValue4, (boolean)value5, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getSinceKotlinInfoTable(), this.c.getContainerSource());
        final DeserializationContext c = this.c;
        final DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor)property;
        final List typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkExpressionValueIsNotNull((Object)typeParameterList, "proto.typeParameterList");
        final DeserializationContext local = DeserializationContext.childContext$default(c, declarationDescriptor, typeParameterList, (NameResolver)null, (TypeTable)null, 12, (Object)null);
        final Boolean value6;
        final Boolean hasGetter = value6 = Flags.HAS_GETTER.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value6, "hasGetter");
        final Annotations receiverAnnotations = (value6 && ProtoTypeTableUtilKt.hasReceiver(proto)) ? getReceiverParameterAnnotations$default(this, (MessageLite)proto, AnnotatedCallableKind.PROPERTY_GETTER, (AnnotatedCallableKind)null, 4, (Object)null) : Annotations.Companion.getEMPTY();
        final DeserializedPropertyDescriptor deserializedPropertyDescriptor = property;
        final KotlinType type$default = TypeDeserializer.type$default(local.getTypeDeserializer(), ProtoTypeTableUtilKt.returnType(proto, this.c.getTypeTable()), (Annotations)null, 2, (Object)null);
        final List ownTypeParameters = local.getTypeDeserializer().getOwnTypeParameters();
        final ReceiverParameterDescriptor dispatchReceiverParameter = this.getDispatchReceiverParameter();
        final ProtoBuf$Type receiverType = ProtoTypeTableUtilKt.receiverType(proto, this.c.getTypeTable());
        KotlinType kotlinType;
        if (receiverType != null) {
            final ProtoBuf$Type it = receiverType;
            kotlinType = local.getTypeDeserializer().type(it, receiverAnnotations);
        }
        else {
            kotlinType = null;
        }
        deserializedPropertyDescriptor.setType(type$default, ownTypeParameters, dispatchReceiverParameter, kotlinType);
        final Boolean b = hasGetter;
        Intrinsics.checkExpressionValueIsNotNull((Object)b, "hasGetter");
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
        if (b) {
            final int getterFlags = proto.getGetterFlags();
            boolean b2 = false;
            Label_0471: {
                if (proto.hasGetterFlags()) {
                    final Boolean value7 = Flags.IS_NOT_DEFAULT.get(getterFlags);
                    Intrinsics.checkExpressionValueIsNotNull((Object)value7, "Flags.IS_NOT_DEFAULT.get(getterFlags)");
                    if (value7) {
                        b2 = true;
                        break Label_0471;
                    }
                }
                b2 = false;
            }
            final boolean isNotDefault = b2;
            boolean b3 = false;
            Label_0506: {
                if (proto.hasGetterFlags()) {
                    final Boolean value8 = Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags);
                    Intrinsics.checkExpressionValueIsNotNull((Object)value8, "Flags.IS_EXTERNAL_ACCESSOR.get(getterFlags)");
                    if (value8) {
                        b3 = true;
                        break Label_0506;
                    }
                }
                b3 = false;
            }
            final boolean isExternal = b3;
            boolean b4 = false;
            Label_0541: {
                if (proto.hasGetterFlags()) {
                    final Boolean value9 = Flags.IS_INLINE_ACCESSOR.get(getterFlags);
                    Intrinsics.checkExpressionValueIsNotNull((Object)value9, "Flags.IS_INLINE_ACCESSOR.get(getterFlags)");
                    if (value9) {
                        b4 = true;
                        break Label_0541;
                    }
                }
                b4 = false;
            }
            final boolean isInline = b4;
            PropertyGetterDescriptorImpl defaultGetter;
            if (isNotDefault) {
                defaultGetter = new PropertyGetterDescriptorImpl((PropertyDescriptor)property, this.getAnnotations((MessageLite)proto, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER), Deserialization.modality((ProtoBuf$Modality)Flags.MODALITY.get(getterFlags)), Deserialization.visibility((ProtoBuf$Visibility)Flags.VISIBILITY.get(getterFlags)), !isNotDefault, isExternal, isInline, property.getKind(), (PropertyGetterDescriptor)null, SourceElement.NO_SOURCE);
            }
            else {
                Intrinsics.checkExpressionValueIsNotNull((Object)(defaultGetter = DescriptorFactory.createDefaultGetter((PropertyDescriptor)property, Annotations.Companion.getEMPTY())), "DescriptorFactory.create\u2026perty, Annotations.EMPTY)");
            }
            final PropertyGetterDescriptorImpl getter = defaultGetter;
            getter.initialize(property.getReturnType());
            propertyGetterDescriptorImpl = getter;
        }
        else {
            propertyGetterDescriptorImpl = null;
        }
        final PropertyGetterDescriptorImpl getter2 = propertyGetterDescriptorImpl;
        final Boolean value10 = Flags.HAS_SETTER.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value10, "Flags.HAS_SETTER.get(flags)");
        PropertySetterDescriptorImpl defaultSetter;
        if (value10) {
            final int setterFlags = proto.getSetterFlags();
            boolean b5 = false;
            Label_0723: {
                if (proto.hasSetterFlags()) {
                    final Boolean value11 = Flags.IS_NOT_DEFAULT.get(setterFlags);
                    Intrinsics.checkExpressionValueIsNotNull((Object)value11, "Flags.IS_NOT_DEFAULT.get(setterFlags)");
                    if (value11) {
                        b5 = true;
                        break Label_0723;
                    }
                }
                b5 = false;
            }
            final boolean isNotDefault2 = b5;
            boolean b6 = false;
            Label_0758: {
                if (proto.hasSetterFlags()) {
                    final Boolean value12 = Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags);
                    Intrinsics.checkExpressionValueIsNotNull((Object)value12, "Flags.IS_EXTERNAL_ACCESSOR.get(setterFlags)");
                    if (value12) {
                        b6 = true;
                        break Label_0758;
                    }
                }
                b6 = false;
            }
            final boolean isExternal2 = b6;
            boolean b7 = false;
            Label_0793: {
                if (proto.hasGetterFlags()) {
                    final Boolean value13 = Flags.IS_INLINE_ACCESSOR.get(setterFlags);
                    Intrinsics.checkExpressionValueIsNotNull((Object)value13, "Flags.IS_INLINE_ACCESSOR.get(setterFlags)");
                    if (value13) {
                        b7 = true;
                        break Label_0793;
                    }
                }
                b7 = false;
            }
            final boolean isInline2 = b7;
            if (isNotDefault2) {
                final PropertySetterDescriptorImpl setter = new PropertySetterDescriptorImpl((PropertyDescriptor)property, this.getAnnotations((MessageLite)proto, setterFlags, AnnotatedCallableKind.PROPERTY_SETTER), Deserialization.modality((ProtoBuf$Modality)Flags.MODALITY.get(setterFlags)), Deserialization.visibility((ProtoBuf$Visibility)Flags.VISIBILITY.get(setterFlags)), !isNotDefault2, isExternal2, isInline2, property.getKind(), (PropertySetterDescriptor)null, SourceElement.NO_SOURCE);
                final DeserializationContext setterLocal = DeserializationContext.childContext$default(local, (DeclarationDescriptor)setter, CollectionsKt.emptyList(), (NameResolver)null, (TypeTable)null, 12, (Object)null);
                final List valueParameters = setterLocal.getMemberDeserializer().valueParameters(CollectionsKt.listOf((Object)proto.getSetterValueParameter()), (MessageLite)proto, AnnotatedCallableKind.PROPERTY_SETTER);
                setter.initialize((ValueParameterDescriptor)CollectionsKt.single(valueParameters));
                defaultSetter = setter;
            }
            else {
                Intrinsics.checkExpressionValueIsNotNull((Object)(defaultSetter = DescriptorFactory.createDefaultSetter((PropertyDescriptor)property, Annotations.Companion.getEMPTY())), "DescriptorFactory.create\u2026perty, Annotations.EMPTY)");
            }
        }
        else {
            defaultSetter = null;
        }
        final PropertySetterDescriptorImpl setter2 = defaultSetter;
        final Boolean value14 = Flags.HAS_CONSTANT.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value14, "Flags.HAS_CONSTANT.get(flags)");
        if (value14) {
            property.setCompileTimeInitializer(this.c.getStorageManager().createNullableLazyValue((Function0)new MemberDeserializer$loadProperty.MemberDeserializer$loadProperty$2(this, proto, property)));
        }
        property.initialize(getter2, (PropertySetterDescriptor)setter2);
        return (PropertyDescriptor)property;
    }
    
    private final int loadOldFlags(final int oldFlags) {
        final int lowSixBits = oldFlags & 0x3F;
        final int rest = oldFlags >> 8 << 6;
        return lowSixBits + rest;
    }
    
    @NotNull
    public final SimpleFunctionDescriptor loadFunction(@NotNull final ProtoBuf$Function proto) {
        Intrinsics.checkParameterIsNotNull((Object)proto, "proto");
        final int flags = proto.hasFlags() ? proto.getFlags() : this.loadOldFlags(proto.getOldFlags());
        final Annotations annotations = this.getAnnotations((MessageLite)proto, flags, AnnotatedCallableKind.FUNCTION);
        final Annotations receiverAnnotations = ProtoTypeTableUtilKt.hasReceiver(proto) ? getReceiverParameterAnnotations$default(this, (MessageLite)proto, AnnotatedCallableKind.FUNCTION, (AnnotatedCallableKind)null, 4, (Object)null) : Annotations.Companion.getEMPTY();
        final DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        final SimpleFunctionDescriptor simpleFunctionDescriptor = null;
        final Annotations annotations2 = annotations;
        final Name name = this.c.getNameResolver().getName(proto.getName());
        Intrinsics.checkExpressionValueIsNotNull((Object)name, "c.nameResolver.getName(proto.name)");
        final DeserializedSimpleFunctionDescriptor function = new DeserializedSimpleFunctionDescriptor(containingDeclaration, simpleFunctionDescriptor, annotations2, name, Deserialization.memberKind((ProtoBuf$MemberKind)Flags.MEMBER_KIND.get(flags)), proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getSinceKotlinInfoTable(), this.c.getContainerSource(), (SourceElement)null, 1024, (DefaultConstructorMarker)null);
        final DeserializationContext c = this.c;
        final DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor)function;
        final List typeParameterList = proto.getTypeParameterList();
        Intrinsics.checkExpressionValueIsNotNull((Object)typeParameterList, "proto.typeParameterList");
        final DeserializationContext local = DeserializationContext.childContext$default(c, declarationDescriptor, typeParameterList, (NameResolver)null, (TypeTable)null, 12, (Object)null);
        final DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor = function;
        final ProtoBuf$Type receiverType = ProtoTypeTableUtilKt.receiverType(proto, this.c.getTypeTable());
        KotlinType kotlinType;
        if (receiverType != null) {
            final ProtoBuf$Type it = receiverType;
            kotlinType = local.getTypeDeserializer().type(it, receiverAnnotations);
        }
        else {
            kotlinType = null;
        }
        final ReceiverParameterDescriptor dispatchReceiverParameter = this.getDispatchReceiverParameter();
        final List ownTypeParameters = local.getTypeDeserializer().getOwnTypeParameters();
        final MemberDeserializer memberDeserializer = local.getMemberDeserializer();
        final List valueParameterList = proto.getValueParameterList();
        Intrinsics.checkExpressionValueIsNotNull((Object)valueParameterList, "proto.valueParameterList");
        deserializedSimpleFunctionDescriptor.initialize(kotlinType, dispatchReceiverParameter, ownTypeParameters, (List)memberDeserializer.valueParameters(valueParameterList, (MessageLite)proto, AnnotatedCallableKind.FUNCTION), TypeDeserializer.type$default(local.getTypeDeserializer(), ProtoTypeTableUtilKt.returnType(proto, this.c.getTypeTable()), (Annotations)null, 2, (Object)null), Deserialization.modality((ProtoBuf$Modality)Flags.MODALITY.get(flags)), Deserialization.visibility((ProtoBuf$Visibility)Flags.VISIBILITY.get(flags)));
        final DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor2 = function;
        final Boolean value = Flags.IS_OPERATOR.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value, "Flags.IS_OPERATOR.get(flags)");
        deserializedSimpleFunctionDescriptor2.setOperator((boolean)value);
        final DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor3 = function;
        final Boolean value2 = Flags.IS_INFIX.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value2, "Flags.IS_INFIX.get(flags)");
        deserializedSimpleFunctionDescriptor3.setInfix((boolean)value2);
        final DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor4 = function;
        final Boolean value3 = Flags.IS_EXTERNAL_FUNCTION.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value3, "Flags.IS_EXTERNAL_FUNCTION.get(flags)");
        deserializedSimpleFunctionDescriptor4.setExternal((boolean)value3);
        final DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor5 = function;
        final Boolean value4 = Flags.IS_INLINE.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value4, "Flags.IS_INLINE.get(flags)");
        deserializedSimpleFunctionDescriptor5.setInline((boolean)value4);
        final DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor6 = function;
        final Boolean value5 = Flags.IS_TAILREC.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value5, "Flags.IS_TAILREC.get(flags)");
        deserializedSimpleFunctionDescriptor6.setTailrec((boolean)value5);
        final DeserializedSimpleFunctionDescriptor deserializedSimpleFunctionDescriptor7 = function;
        final Boolean value6 = Flags.IS_SUSPEND.get(flags);
        Intrinsics.checkExpressionValueIsNotNull((Object)value6, "Flags.IS_SUSPEND.get(flags)");
        deserializedSimpleFunctionDescriptor7.setSuspend((boolean)value6);
        return (SimpleFunctionDescriptor)function;
    }
    
    @NotNull
    public final TypeAliasDescriptor loadTypeAlias(@NotNull final ProtoBuf$TypeAlias proto) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "proto"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: new             Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationsImpl;
        //     9: dup            
        //    10: aload_1         /* proto */
        //    11: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$TypeAlias.getAnnotationList:()Ljava/util/List;
        //    14: checkcast       Ljava/lang/Iterable;
        //    17: astore_2       
        //    18: astore_3       
        //    19: astore          4
        //    21: aload_2         /* $receiver$iv */
        //    22: astore          5
        //    24: new             Ljava/util/ArrayList;
        //    27: dup            
        //    28: aload_2         /* $receiver$iv */
        //    29: bipush          10
        //    31: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    34: invokespecial   java/util/ArrayList.<init>:(I)V
        //    37: checkcast       Ljava/util/Collection;
        //    40: astore          destination$iv$iv
        //    42: aload           $receiver$iv$iv
        //    44: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    49: astore          7
        //    51: aload           7
        //    53: invokeinterface java/util/Iterator.hasNext:()Z
        //    58: ifeq            119
        //    61: aload           7
        //    63: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    68: astore          item$iv$iv
        //    70: aload           destination$iv$iv
        //    72: aload           item$iv$iv
        //    74: checkcast       Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation;
        //    77: astore          9
        //    79: astore          10
        //    81: aload_0         /* this */
        //    82: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.annotationDeserializer:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer;
        //    85: aload           it
        //    87: dup            
        //    88: ldc_w           "it"
        //    91: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    94: aload_0         /* this */
        //    95: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //    98: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getNameResolver:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;
        //   101: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotationDeserializer.deserializeAnnotation:(Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Annotation;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;)Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;
        //   104: astore          11
        //   106: aload           10
        //   108: aload           11
        //   110: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   115: pop            
        //   116: goto            51
        //   119: aload           destination$iv$iv
        //   121: checkcast       Ljava/util/List;
        //   124: astore          10
        //   126: aload           4
        //   128: aload_3        
        //   129: aload           10
        //   131: invokespecial   kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationsImpl.<init>:(Ljava/util/List;)V
        //   134: astore          annotations
        //   136: getstatic       kotlin/reflect/jvm/internal/impl/serialization/Flags.VISIBILITY:Lkotlin/reflect/jvm/internal/impl/serialization/Flags$FlagField;
        //   139: aload_1         /* proto */
        //   140: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$TypeAlias.getFlags:()I
        //   143: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/Flags$FlagField.get:(I)Ljava/lang/Object;
        //   146: checkcast       Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Visibility;
        //   149: invokestatic    kotlin/reflect/jvm/internal/impl/serialization/deserialization/Deserialization.visibility:(Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Visibility;)Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;
        //   152: astore_2        /* visibility */
        //   153: new             Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedTypeAliasDescriptor;
        //   156: dup            
        //   157: aload_0         /* this */
        //   158: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   161: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getContainingDeclaration:()Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //   164: aload           annotations
        //   166: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;
        //   169: aload_0         /* this */
        //   170: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   173: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getNameResolver:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;
        //   176: aload_1         /* proto */
        //   177: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$TypeAlias.getName:()I
        //   180: invokeinterface kotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver.getName:(I)Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   185: dup            
        //   186: ldc             "c.nameResolver.getName(proto.name)"
        //   188: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   191: aload_2         /* visibility */
        //   192: dup            
        //   193: ldc_w           "visibility"
        //   196: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   199: aload_1         /* proto */
        //   200: aload_0         /* this */
        //   201: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   204: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getNameResolver:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;
        //   207: aload_0         /* this */
        //   208: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   211: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getTypeTable:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeTable;
        //   214: aload_0         /* this */
        //   215: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   218: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getSinceKotlinInfoTable:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/SinceKotlinInfoTable;
        //   221: aload_0         /* this */
        //   222: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   225: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getContainerSource:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedContainerSource;
        //   228: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedTypeAliasDescriptor.<init>:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;Lkotlin/reflect/jvm/internal/impl/name/Name;Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$TypeAlias;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeTable;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/SinceKotlinInfoTable;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedContainerSource;)V
        //   231: astore          typeAlias
        //   233: aload_0         /* this */
        //   234: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   237: aload           typeAlias
        //   239: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //   242: aload_1         /* proto */
        //   243: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$TypeAlias.getTypeParameterList:()Ljava/util/List;
        //   246: dup            
        //   247: ldc             "proto.typeParameterList"
        //   249: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   252: aconst_null    
        //   253: aconst_null    
        //   254: bipush          12
        //   256: aconst_null    
        //   257: invokestatic    kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.childContext$default:(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;Ljava/util/List;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeTable;ILjava/lang/Object;)Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   260: astore          local
        //   262: aload           typeAlias
        //   264: aload           local
        //   266: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getTypeDeserializer:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer;
        //   269: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer.getOwnTypeParameters:()Ljava/util/List;
        //   272: aload           local
        //   274: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getTypeDeserializer:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer;
        //   277: aload_1         /* proto */
        //   278: aload_0         /* this */
        //   279: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   282: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getTypeTable:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeTable;
        //   285: invokestatic    kotlin/reflect/jvm/internal/impl/serialization/deserialization/ProtoTypeTableUtilKt.underlyingType:(Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$TypeAlias;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeTable;)Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Type;
        //   288: aconst_null    
        //   289: iconst_2       
        //   290: aconst_null    
        //   291: invokestatic    kotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer.simpleType$default:(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer;Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Type;Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;ILjava/lang/Object;)Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   294: aload           local
        //   296: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getTypeDeserializer:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer;
        //   299: aload_1         /* proto */
        //   300: aload_0         /* this */
        //   301: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   304: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getTypeTable:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeTable;
        //   307: invokestatic    kotlin/reflect/jvm/internal/impl/serialization/deserialization/ProtoTypeTableUtilKt.expandedType:(Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$TypeAlias;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeTable;)Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Type;
        //   310: aconst_null    
        //   311: iconst_2       
        //   312: aconst_null    
        //   313: invokestatic    kotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer.simpleType$default:(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer;Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Type;Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;ILjava/lang/Object;)Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   316: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedTypeAliasDescriptor.initialize:(Ljava/util/List;Lkotlin/reflect/jvm/internal/impl/types/SimpleType;Lkotlin/reflect/jvm/internal/impl/types/SimpleType;)V
        //   319: aload           typeAlias
        //   321: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/TypeAliasDescriptor;
        //   324: areturn        
        //    StackMapTable: 00 02 FF 00 33 00 08 07 00 02 07 02 0D 07 02 12 08 00 06 08 00 06 07 02 12 07 02 1D 07 02 23 00 00 FB 00 43
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2945)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2501)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final ReceiverParameterDescriptor getDispatchReceiverParameter() {
        Object containingDeclaration;
        if (!((containingDeclaration = this.c.getContainingDeclaration()) instanceof ClassDescriptor)) {
            containingDeclaration = null;
        }
        final ClassDescriptor classDescriptor = (ClassDescriptor)containingDeclaration;
        return (classDescriptor != null) ? classDescriptor.getThisAsReceiverParameter() : null;
    }
    
    @NotNull
    public final ClassConstructorDescriptor loadConstructor(@NotNull final ProtoBuf$Constructor proto, final boolean isPrimary) {
        Intrinsics.checkParameterIsNotNull((Object)proto, "proto");
        final DeclarationDescriptor containingDeclaration = this.c.getContainingDeclaration();
        if (containingDeclaration == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        final ClassDescriptor classDescriptor = (ClassDescriptor)containingDeclaration;
        final DeserializedClassConstructorDescriptor descriptor = new DeserializedClassConstructorDescriptor(classDescriptor, (ConstructorDescriptor)null, this.getAnnotations((MessageLite)proto, proto.getFlags(), AnnotatedCallableKind.FUNCTION), isPrimary, CallableMemberDescriptor$Kind.DECLARATION, proto, this.c.getNameResolver(), this.c.getTypeTable(), this.c.getSinceKotlinInfoTable(), this.c.getContainerSource(), (SourceElement)null, 1024, (DefaultConstructorMarker)null);
        final DeserializationContext local = DeserializationContext.childContext$default(this.c, (DeclarationDescriptor)descriptor, CollectionsKt.emptyList(), (NameResolver)null, (TypeTable)null, 12, (Object)null);
        final DeserializedClassConstructorDescriptor deserializedClassConstructorDescriptor = descriptor;
        final MemberDeserializer memberDeserializer = local.getMemberDeserializer();
        final List valueParameterList = proto.getValueParameterList();
        Intrinsics.checkExpressionValueIsNotNull((Object)valueParameterList, "proto.valueParameterList");
        deserializedClassConstructorDescriptor.initialize((List)memberDeserializer.valueParameters(valueParameterList, (MessageLite)proto, AnnotatedCallableKind.FUNCTION), Deserialization.visibility((ProtoBuf$Visibility)Flags.VISIBILITY.get(proto.getFlags())));
        descriptor.setReturnType((KotlinType)classDescriptor.getDefaultType());
        return (ClassConstructorDescriptor)descriptor;
    }
    
    private final Annotations getAnnotations(final MessageLite proto, final int flags, final AnnotatedCallableKind kind) {
        if (!Flags.HAS_ANNOTATIONS.get(flags)) {
            return Annotations.Companion.getEMPTY();
        }
        return (Annotations)new DeserializedAnnotationsWithPossibleTargets(this.c.getStorageManager(), (Function0)new MemberDeserializer$getAnnotations.MemberDeserializer$getAnnotations$1(this, proto, kind));
    }
    
    private final Annotations getReceiverParameterAnnotations(final MessageLite proto, final AnnotatedCallableKind kind, final AnnotatedCallableKind receiverTargetedKind) {
        return (Annotations)new DeserializedAnnotationsWithPossibleTargets(this.c.getStorageManager(), (Function0)new MemberDeserializer$getReceiverParameterAnnotations.MemberDeserializer$getReceiverParameterAnnotations$1(this, proto, receiverTargetedKind));
    }
    
    private final List<ValueParameterDescriptor> valueParameters(final List<ProtoBuf$ValueParameter> valueParameters, final MessageLite callable, final AnnotatedCallableKind kind) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //     4: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getContainingDeclaration:()Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //     7: dup            
        //     8: ifnonnull       22
        //    11: new             Lkotlin/TypeCastException;
        //    14: dup            
        //    15: ldc_w           "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor"
        //    18: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //    21: athrow         
        //    22: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;
        //    25: astore          callableDescriptor
        //    27: aload_0         /* this */
        //    28: aload           callableDescriptor
        //    30: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor.getContainingDeclaration:()Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //    35: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.asProtoContainer:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/ProtoContainer;
        //    38: astore          containerOfCallable
        //    40: aload_1         /* valueParameters */
        //    41: checkcast       Ljava/lang/Iterable;
        //    44: astore          $receiver$iv
        //    46: aload           $receiver$iv
        //    48: astore          7
        //    50: new             Ljava/util/ArrayList;
        //    53: dup            
        //    54: aload           $receiver$iv
        //    56: bipush          10
        //    58: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //    61: invokespecial   java/util/ArrayList.<init>:(I)V
        //    64: checkcast       Ljava/util/Collection;
        //    67: astore          destination$iv$iv
        //    69: iconst_0       
        //    70: istore          index$iv$iv
        //    72: aload           $receiver$iv$iv
        //    74: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    79: astore          10
        //    81: aload           10
        //    83: invokeinterface java/util/Iterator.hasNext:()Z
        //    88: ifeq            464
        //    91: aload           10
        //    93: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    98: astore          item$iv$iv
        //   100: aload           destination$iv$iv
        //   102: iload           index$iv$iv
        //   104: iinc            index$iv$iv, 1
        //   107: aload           item$iv$iv
        //   109: checkcast       Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$ValueParameter;
        //   112: astore          12
        //   114: istore          13
        //   116: astore          14
        //   118: aload           proto
        //   120: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$ValueParameter.hasFlags:()Z
        //   123: ifeq            134
        //   126: aload           proto
        //   128: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$ValueParameter.getFlags:()I
        //   131: goto            135
        //   134: iconst_0       
        //   135: istore          flags
        //   137: new             Lkotlin/reflect/jvm/internal/impl/descriptors/impl/ValueParameterDescriptorImpl;
        //   140: dup            
        //   141: aload           callableDescriptor
        //   143: aconst_null    
        //   144: iload           i
        //   146: aload           containerOfCallable
        //   148: dup            
        //   149: ifnull          231
        //   152: astore          16
        //   154: istore          17
        //   156: astore          18
        //   158: astore          19
        //   160: astore          20
        //   162: astore          21
        //   164: aload           16
        //   166: checkcast       Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/ProtoContainer;
        //   169: astore          container
        //   171: new             Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedAnnotations;
        //   174: dup            
        //   175: aload_0         /* this */
        //   176: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   179: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getStorageManager:()Lkotlin/reflect/jvm/internal/impl/storage/StorageManager;
        //   182: new             Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1;
        //   185: dup            
        //   186: aload           container
        //   188: iload           i
        //   190: aload           proto
        //   192: aload_0         /* this */
        //   193: aload           callableDescriptor
        //   195: aload           containerOfCallable
        //   197: aload_2         /* callable */
        //   198: aload_3         /* kind */
        //   199: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1.<init>:(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/ProtoContainer;ILkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$ValueParameter;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/ProtoContainer;Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotatedCallableKind;)V
        //   202: checkcast       Lkotlin/jvm/functions/Function0;
        //   205: invokespecial   kotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedAnnotations.<init>:(Lkotlin/reflect/jvm/internal/impl/storage/StorageManager;Lkotlin/jvm/functions/Function0;)V
        //   208: astore          23
        //   210: aload           21
        //   212: aload           20
        //   214: aload           19
        //   216: aload           18
        //   218: iload           17
        //   220: aload           23
        //   222: checkcast       Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedAnnotations;
        //   225: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;
        //   228: goto            238
        //   231: pop            
        //   232: getstatic       kotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations.Companion:Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations$Companion;
        //   235: invokevirtual   kotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations$Companion.getEMPTY:()Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;
        //   238: aload_0         /* this */
        //   239: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   242: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getNameResolver:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;
        //   245: aload           proto
        //   247: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$ValueParameter.getName:()I
        //   250: invokeinterface kotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver.getName:(I)Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   255: dup            
        //   256: ldc             "c.nameResolver.getName(proto.name)"
        //   258: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   261: aload_0         /* this */
        //   262: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   265: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getTypeDeserializer:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer;
        //   268: aload           proto
        //   270: aload_0         /* this */
        //   271: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   274: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getTypeTable:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeTable;
        //   277: invokestatic    kotlin/reflect/jvm/internal/impl/serialization/deserialization/ProtoTypeTableUtilKt.type:(Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$ValueParameter;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeTable;)Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Type;
        //   280: aconst_null    
        //   281: iconst_2       
        //   282: aconst_null    
        //   283: invokestatic    kotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer.type$default:(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer;Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Type;Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;ILjava/lang/Object;)Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   286: getstatic       kotlin/reflect/jvm/internal/impl/serialization/Flags.DECLARES_DEFAULT_VALUE:Lkotlin/reflect/jvm/internal/impl/serialization/Flags$BooleanFlagField;
        //   289: iload           flags
        //   291: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/Flags$BooleanFlagField.get:(I)Ljava/lang/Boolean;
        //   294: dup            
        //   295: ldc_w           "Flags.DECLARES_DEFAULT_VALUE.get(flags)"
        //   298: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   301: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   304: getstatic       kotlin/reflect/jvm/internal/impl/serialization/Flags.IS_CROSSINLINE:Lkotlin/reflect/jvm/internal/impl/serialization/Flags$BooleanFlagField;
        //   307: iload           flags
        //   309: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/Flags$BooleanFlagField.get:(I)Ljava/lang/Boolean;
        //   312: dup            
        //   313: ldc_w           "Flags.IS_CROSSINLINE.get(flags)"
        //   316: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   319: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   322: getstatic       kotlin/reflect/jvm/internal/impl/serialization/Flags.IS_NOINLINE:Lkotlin/reflect/jvm/internal/impl/serialization/Flags$BooleanFlagField;
        //   325: iload           flags
        //   327: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/Flags$BooleanFlagField.get:(I)Ljava/lang/Boolean;
        //   330: dup            
        //   331: ldc_w           "Flags.IS_NOINLINE.get(flags)"
        //   334: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   337: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   340: aload           proto
        //   342: aload_0         /* this */
        //   343: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   346: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getTypeTable:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeTable;
        //   349: invokestatic    kotlin/reflect/jvm/internal/impl/serialization/deserialization/ProtoTypeTableUtilKt.varargElementType:(Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$ValueParameter;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeTable;)Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Type;
        //   352: dup            
        //   353: ifnull          434
        //   356: astore          16
        //   358: istore          24
        //   360: istore          25
        //   362: istore          26
        //   364: astore          27
        //   366: astore          28
        //   368: astore          23
        //   370: istore          17
        //   372: astore          18
        //   374: astore          19
        //   376: astore          20
        //   378: astore          21
        //   380: aload           16
        //   382: checkcast       Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Type;
        //   385: astore          it
        //   387: aload_0         /* this */
        //   388: getfield        kotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer.c:Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //   391: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getTypeDeserializer:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer;
        //   394: aload           it
        //   396: aconst_null    
        //   397: iconst_2       
        //   398: aconst_null    
        //   399: invokestatic    kotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer.type$default:(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/TypeDeserializer;Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Type;Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;ILjava/lang/Object;)Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   402: astore          29
        //   404: aload           21
        //   406: aload           20
        //   408: aload           19
        //   410: aload           18
        //   412: iload           17
        //   414: aload           23
        //   416: aload           28
        //   418: aload           27
        //   420: iload           26
        //   422: iload           25
        //   424: iload           24
        //   426: aload           29
        //   428: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   431: goto            436
        //   434: pop            
        //   435: aconst_null    
        //   436: getstatic       kotlin/reflect/jvm/internal/impl/descriptors/SourceElement.NO_SOURCE:Lkotlin/reflect/jvm/internal/impl/descriptors/SourceElement;
        //   439: dup            
        //   440: ldc_w           "SourceElement.NO_SOURCE"
        //   443: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   446: invokespecial   kotlin/reflect/jvm/internal/impl/descriptors/impl/ValueParameterDescriptorImpl.<init>:(Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;ILkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;Lkotlin/reflect/jvm/internal/impl/name/Name;Lkotlin/reflect/jvm/internal/impl/types/KotlinType;ZZZLkotlin/reflect/jvm/internal/impl/types/KotlinType;Lkotlin/reflect/jvm/internal/impl/descriptors/SourceElement;)V
        //   449: astore          30
        //   451: aload           14
        //   453: aload           30
        //   455: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   460: pop            
        //   461: goto            81
        //   464: aload           destination$iv$iv
        //   466: checkcast       Ljava/util/List;
        //   469: checkcast       Ljava/util/Collection;
        //   472: invokestatic    kotlin/reflect/jvm/internal/impl/utils/CollectionsKt.toReadOnlyList:(Ljava/util/Collection;)Ljava/util/List;
        //   475: areturn        
        //    Signature:
        //  (Ljava/util/List<Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$ValueParameter;>;Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/AnnotatedCallableKind;)Ljava/util/List<Lkotlin/reflect/jvm/internal/impl/descriptors/ValueParameterDescriptor;>;
        //    StackMapTable: 00 09 56 07 00 B0 FF 00 3A 00 0B 07 00 02 07 00 FA 07 00 37 07 00 39 07 02 AB 07 02 B2 07 02 12 07 02 12 07 02 1D 01 07 02 23 00 00 FF 00 34 00 0F 07 00 02 07 00 FA 07 00 37 07 00 39 07 02 AB 07 02 B2 07 02 12 07 02 12 07 02 1D 01 07 02 23 07 00 04 07 02 B4 01 07 02 1D 00 00 40 01 FF 00 5F 00 10 07 00 02 07 00 FA 07 00 37 07 00 39 07 02 AB 07 02 B2 07 02 12 07 02 12 07 02 1D 01 07 02 23 07 00 04 07 02 B4 01 07 02 1D 01 00 06 08 00 89 08 00 89 07 02 AB 05 01 07 02 B2 FF 00 06 00 10 07 00 02 07 00 FA 07 00 37 07 00 39 07 02 AB 07 02 B2 07 02 12 07 02 12 07 02 1D 01 07 02 23 07 00 04 07 02 B4 01 07 02 1D 01 00 06 08 00 89 08 00 89 07 02 AB 05 01 07 00 CE FF 00 C3 00 10 07 00 02 07 00 FA 07 00 37 07 00 39 07 02 AB 07 02 B2 07 02 12 07 02 12 07 02 1D 01 07 02 23 07 00 04 07 02 B4 01 07 02 1D 01 00 0C 08 00 89 08 00 89 07 02 AB 05 01 07 00 CE 07 02 D8 07 00 F8 01 01 01 07 00 F2 FF 00 01 00 10 07 00 02 07 00 FA 07 00 37 07 00 39 07 02 AB 07 02 B2 07 02 12 07 02 12 07 02 1D 01 07 02 23 07 00 04 07 02 B4 01 07 02 1D 01 00 0C 08 00 89 08 00 89 07 02 AB 05 01 07 00 CE 07 02 D8 07 00 F8 01 01 01 07 00 F8 FF 00 1B 00 0B 07 00 02 07 00 FA 07 00 37 07 00 39 07 02 AB 07 02 B2 07 02 12 07 02 12 07 02 1D 01 07 02 23 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2945)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2501)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final ProtoContainer asProtoContainer(@NotNull final DeclarationDescriptor $receiver) {
        return ($receiver instanceof PackageFragmentDescriptor) ? new ProtoContainer$Package(((PackageFragmentDescriptor)$receiver).getFqName(), this.c.getNameResolver(), this.c.getTypeTable(), (SourceElement)this.c.getContainerSource()) : (($receiver instanceof DeserializedClassDescriptor) ? ((DeserializedClassDescriptor)$receiver).getThisAsProtoContainer$kotlin_core() : null);
    }
    
    public MemberDeserializer(@NotNull final DeserializationContext c) {
        Intrinsics.checkParameterIsNotNull((Object)c, "c");
        this.c = c;
        this.annotationDeserializer = new AnnotationDeserializer(this.c.getComponents().getModuleDescriptor(), this.c.getComponents().getNotFoundClasses());
    }
}
