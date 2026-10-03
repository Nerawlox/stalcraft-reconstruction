// 
// Decompiled by Procyon v0.6.0
// 

package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import java.io.Serializable;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.reflect.KDeclarationContainer;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.LazyKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors;
import kotlin.TypeCastException;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor$CopyBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.collections.SetsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope$Empty;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.Lazy;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider;

public class JvmBuiltInsSettings implements AdditionalClassPartsProvider, PlatformDependentDeclarationFilter
{
    private final JavaToKotlinClassMap j2kClassMap;
    private final Lazy ownerModuleDescriptor$delegate;
    private final Lazy isAdditionalBuiltInsFeatureSupported$delegate;
    private final KotlinType mockSerializableType;
    private final NotNullLazyValue cloneableType$delegate;
    private final CacheWithNotNullValues<FqName, ClassDescriptor> javaAnalogueClassesWithCustomSupertypeCache;
    private final NotNullLazyValue notConsideredDeprecation$delegate;
    private final ModuleDescriptor moduleDescriptor;
    @NotNull
    private static final Set<String> DROP_LIST_METHOD_SIGNATURES;
    @NotNull
    private static final Set<String> BLACK_LIST_METHOD_SIGNATURES;
    @NotNull
    private static final Set<String> WHITE_LIST_METHOD_SIGNATURES;
    @NotNull
    private static final Set<String> MUTABLE_METHOD_SIGNATURES;
    @NotNull
    private static final Set<String> BLACK_LIST_CONSTRUCTOR_SIGNATURES;
    @NotNull
    private static final Set<String> WHITE_LIST_CONSTRUCTOR_SIGNATURES;
    static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final Companion Companion;
    
    private final ModuleDescriptor getOwnerModuleDescriptor() {
        final Lazy ownerModuleDescriptor$delegate = this.ownerModuleDescriptor$delegate;
        final KProperty kProperty = JvmBuiltInsSettings.$$delegatedProperties[0];
        return (ModuleDescriptor)ownerModuleDescriptor$delegate.getValue();
    }
    
    private final boolean isAdditionalBuiltInsFeatureSupported() {
        final Lazy isAdditionalBuiltInsFeatureSupported$delegate = this.isAdditionalBuiltInsFeatureSupported$delegate;
        final KProperty kProperty = JvmBuiltInsSettings.$$delegatedProperties[1];
        return (boolean)isAdditionalBuiltInsFeatureSupported$delegate.getValue();
    }
    
    private final SimpleType getCloneableType() {
        return (SimpleType)StorageKt.getValue(this.cloneableType$delegate, (Object)this, JvmBuiltInsSettings.$$delegatedProperties[2]);
    }
    
    private final AnnotationsImpl getNotConsideredDeprecation() {
        return (AnnotationsImpl)StorageKt.getValue(this.notConsideredDeprecation$delegate, (Object)this, JvmBuiltInsSettings.$$delegatedProperties[3]);
    }
    
    private final KotlinType createMockJavaIoSerializableType(@NotNull final StorageManager $receiver) {
        final JvmBuiltInsSettings$createMockJavaIoSerializableType$mockJavaIoPackageFragment.JvmBuiltInsSettings$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1 mockJavaIoPackageFragment = new JvmBuiltInsSettings$createMockJavaIoSerializableType$mockJavaIoPackageFragment.JvmBuiltInsSettings$createMockJavaIoSerializableType$mockJavaIoPackageFragment$1(this, this.moduleDescriptor, new FqName("java.io"));
        final List superTypes = CollectionsKt.listOf((Object)new LazyWrappedType($receiver, (Function0)new JvmBuiltInsSettings$createMockJavaIoSerializableType$superTypes.JvmBuiltInsSettings$createMockJavaIoSerializableType$superTypes$1(this)));
        final ClassDescriptorImpl mockSerializableClass = new ClassDescriptorImpl((DeclarationDescriptor)mockJavaIoPackageFragment, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, (Collection)superTypes, SourceElement.NO_SOURCE, false);
        mockSerializableClass.initialize((MemberScope)MemberScope$Empty.INSTANCE, SetsKt.emptySet(), (ClassConstructorDescriptor)null);
        final SimpleType defaultType = mockSerializableClass.getDefaultType();
        Intrinsics.checkExpressionValueIsNotNull((Object)defaultType, "mockSerializableClass.defaultType");
        return (KotlinType)defaultType;
    }
    
    @NotNull
    public Collection<KotlinType> getSupertypes(@NotNull final DeserializedClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull((Object)classDescriptor, "classDescriptor");
        final FqNameUnsafe fqName = DescriptorUtilsKt.getFqNameUnsafe((DeclarationDescriptor)classDescriptor);
        Collection collection;
        if (JvmBuiltInsSettings.Companion.isArrayOrPrimitiveArray(fqName)) {
            final KotlinType[] array = new KotlinType[2];
            final int n = 0;
            final SimpleType cloneableType = this.getCloneableType();
            Intrinsics.checkExpressionValueIsNotNull((Object)cloneableType, "cloneableType");
            array[n] = (KotlinType)cloneableType;
            array[1] = this.mockSerializableType;
            collection = CollectionsKt.listOf((Object[])array);
        }
        else {
            collection = (JvmBuiltInsSettings.Companion.isSerializableInJava(fqName) ? CollectionsKt.listOf((Object)this.mockSerializableType) : ((Collection)CollectionsKt.emptyList()));
        }
        return collection;
    }
    
    @NotNull
    public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull final Name name, @NotNull final DeserializedClassDescriptor classDescriptor) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "name"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_2         /* classDescriptor */
        //     8: ldc             "classDescriptor"
        //    10: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    13: aload_1         /* name */
        //    14: getstatic       kotlin/reflect/jvm/internal/impl/builtins/CloneableClassScope.Companion:Lkotlin/reflect/jvm/internal/impl/builtins/CloneableClassScope$Companion;
        //    17: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/CloneableClassScope$Companion.getCLONE_NAME$kotlin_core:()Lkotlin/reflect/jvm/internal/impl/name/Name;
        //    20: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    23: ifeq            168
        //    26: aload_2         /* classDescriptor */
        //    27: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //    30: invokestatic    kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.isArrayOrPrimitiveArray:(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Z
        //    33: ifeq            168
        //    36: aload_2         /* classDescriptor */
        //    37: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedClassDescriptor.getClassProto:()Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Class;
        //    40: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Class.getFunctionList:()Ljava/util/List;
        //    43: checkcast       Ljava/lang/Iterable;
        //    46: astore_3        /* $receiver$iv */
        //    47: aload_3         /* $receiver$iv */
        //    48: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    53: astore          4
        //    55: aload           4
        //    57: invokeinterface java/util/Iterator.hasNext:()Z
        //    62: ifeq            117
        //    65: aload           4
        //    67: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    72: astore          element$iv
        //    74: aload           element$iv
        //    76: checkcast       Lkotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Function;
        //    79: astore          functionProto
        //    81: aload_2         /* classDescriptor */
        //    82: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedClassDescriptor.getC:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext;
        //    85: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/DeserializationContext.getNameResolver:()Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver;
        //    88: aload           functionProto
        //    90: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/ProtoBuf$Function.getName:()I
        //    93: invokeinterface kotlin/reflect/jvm/internal/impl/serialization/deserialization/NameResolver.getName:(I)Lkotlin/reflect/jvm/internal/impl/name/Name;
        //    98: getstatic       kotlin/reflect/jvm/internal/impl/builtins/CloneableClassScope.Companion:Lkotlin/reflect/jvm/internal/impl/builtins/CloneableClassScope$Companion;
        //   101: invokevirtual   kotlin/reflect/jvm/internal/impl/builtins/CloneableClassScope$Companion.getCLONE_NAME$kotlin_core:()Lkotlin/reflect/jvm/internal/impl/name/Name;
        //   104: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   107: ifeq            114
        //   110: iconst_1       
        //   111: goto            118
        //   114: goto            55
        //   117: iconst_0       
        //   118: ifeq            128
        //   121: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   124: checkcast       Ljava/util/Collection;
        //   127: areturn        
        //   128: aload_0         /* this */
        //   129: aload_2         /* classDescriptor */
        //   130: aload_0         /* this */
        //   131: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.getCloneableType:()Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   134: invokevirtual   kotlin/reflect/jvm/internal/impl/types/SimpleType.getMemberScope:()Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;
        //   137: aload_1         /* name */
        //   138: getstatic       kotlin/reflect/jvm/internal/impl/incremental/components/NoLookupLocation.FROM_BUILTINS:Lkotlin/reflect/jvm/internal/impl/incremental/components/NoLookupLocation;
        //   141: checkcast       Lkotlin/reflect/jvm/internal/impl/incremental/components/LookupLocation;
        //   144: invokeinterface kotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope.getContributedFunctions:(Lkotlin/reflect/jvm/internal/impl/name/Name;Lkotlin/reflect/jvm/internal/impl/incremental/components/LookupLocation;)Ljava/util/Collection;
        //   149: checkcast       Ljava/lang/Iterable;
        //   152: invokestatic    kotlin/collections/CollectionsKt.single:(Ljava/lang/Iterable;)Ljava/lang/Object;
        //   155: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;
        //   158: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.createCloneForArray:(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;)Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;
        //   161: invokestatic    kotlin/collections/CollectionsKt.listOf:(Ljava/lang/Object;)Ljava/util/List;
        //   164: checkcast       Ljava/util/Collection;
        //   167: areturn        
        //   168: aload_0         /* this */
        //   169: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.isAdditionalBuiltInsFeatureSupported:()Z
        //   172: ifne            182
        //   175: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //   178: checkcast       Ljava/util/Collection;
        //   181: areturn        
        //   182: aload_0         /* this */
        //   183: aload_2         /* classDescriptor */
        //   184: new             Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$getFunctions$2;
        //   187: dup            
        //   188: aload_1         /* name */
        //   189: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$getFunctions$2.<init>:(Lkotlin/reflect/jvm/internal/impl/name/Name;)V
        //   192: checkcast       Lkotlin/jvm/functions/Function1;
        //   195: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.getAdditionalFunctions:(Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;
        //   198: checkcast       Ljava/lang/Iterable;
        //   201: astore_3       
        //   202: nop            
        //   203: aload_3         /* $receiver$iv */
        //   204: astore          4
        //   206: new             Ljava/util/ArrayList;
        //   209: dup            
        //   210: invokespecial   java/util/ArrayList.<init>:()V
        //   213: checkcast       Ljava/util/Collection;
        //   216: astore          destination$iv$iv
        //   218: aload           $receiver$iv$iv
        //   220: astore          $receiver$iv$iv$iv
        //   222: aload           $receiver$iv$iv$iv
        //   224: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   229: astore          7
        //   231: aload           7
        //   233: invokeinterface java/util/Iterator.hasNext:()Z
        //   238: ifeq            558
        //   241: aload           7
        //   243: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   248: astore          element$iv$iv$iv
        //   250: aload           element$iv$iv$iv
        //   252: astore          element$iv$iv
        //   254: aload           element$iv$iv
        //   256: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;
        //   259: astore          additionalMember
        //   261: aload           additionalMember
        //   263: aload           additionalMember
        //   265: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor.getContainingDeclaration:()Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //   270: dup            
        //   271: ifnonnull       285
        //   274: new             Lkotlin/TypeCastException;
        //   277: dup            
        //   278: ldc_w           "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
        //   281: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //   284: athrow         
        //   285: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //   288: aload_2         /* classDescriptor */
        //   289: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //   292: invokestatic    kotlin/reflect/jvm/internal/impl/platform/MappingUtilKt.createMappedTypeParametersSubstitution:(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Lkotlin/reflect/jvm/internal/impl/types/TypeConstructorSubstitution;
        //   295: invokevirtual   kotlin/reflect/jvm/internal/impl/types/TypeConstructorSubstitution.buildSubstitutor:()Lkotlin/reflect/jvm/internal/impl/types/TypeSubstitutor;
        //   298: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor.substitute:(Lkotlin/reflect/jvm/internal/impl/types/TypeSubstitutor;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   303: dup            
        //   304: ifnonnull       318
        //   307: new             Lkotlin/TypeCastException;
        //   310: dup            
        //   311: ldc_w           "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor"
        //   314: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //   317: athrow         
        //   318: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;
        //   321: astore          substitutedWithKotlinTypeParameters
        //   323: aload           substitutedWithKotlinTypeParameters
        //   325: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor.newCopyBuilder:()Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   330: astore          12
        //   332: aload           12
        //   334: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   337: astore          $receiver
        //   339: aload           $receiver
        //   341: aload_2         /* classDescriptor */
        //   342: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //   345: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.setOwner:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   350: pop            
        //   351: aload           $receiver
        //   353: aload_2         /* classDescriptor */
        //   354: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedClassDescriptor.getThisAsReceiverParameter:()Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;
        //   357: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.setDispatchReceiverParameter:(Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   362: pop            
        //   363: aload           $receiver
        //   365: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.setPreserveSourceElement:()Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   370: pop            
        //   371: aload           $receiver
        //   373: new             Lkotlin/reflect/jvm/internal/impl/load/kotlin/UnsafeVarianceTypeSubstitution;
        //   376: dup            
        //   377: aload_0         /* this */
        //   378: getfield        kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.moduleDescriptor:Lkotlin/reflect/jvm/internal/impl/descriptors/ModuleDescriptor;
        //   381: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ModuleDescriptor.getBuiltIns:()Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;
        //   386: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/UnsafeVarianceTypeSubstitution.<init>:(Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;)V
        //   389: checkcast       Lkotlin/reflect/jvm/internal/impl/types/TypeSubstitution;
        //   392: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.setSubstitution:(Lkotlin/reflect/jvm/internal/impl/types/TypeSubstitution;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   397: pop            
        //   398: aload_0         /* this */
        //   399: aload           additionalMember
        //   401: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   404: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.getJdkMethodStatus:(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;)Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$JDKMemberStatus;
        //   407: astore          memberStatus
        //   409: aload           memberStatus
        //   411: getstatic       kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$WhenMappings.$EnumSwitchMapping$0:[I
        //   414: swap           
        //   415: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$JDKMemberStatus.ordinal:()I
        //   418: iaload         
        //   419: tableswitch {
        //                2: 448
        //                3: 480
        //                4: 505
        //                5: 509
        //          default: 510
        //        }
        //   448: aload_2         /* classDescriptor */
        //   449: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //   452: invokestatic    kotlin/reflect/jvm/internal/impl/descriptors/ModalityKt.isFinalClass:(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Z
        //   455: ifeq            462
        //   458: aconst_null    
        //   459: goto            531
        //   462: aload           $receiver
        //   464: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.setHiddenForResolutionEverywhereBesideSupercalls:()Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   469: dup            
        //   470: ldc_w           "setHiddenForResolutionEverywhereBesideSupercalls()"
        //   473: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   476: pop            
        //   477: goto            510
        //   480: aload           $receiver
        //   482: aload_0         /* this */
        //   483: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.getNotConsideredDeprecation:()Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationsImpl;
        //   486: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;
        //   489: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.setAdditionalAnnotations:(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   494: dup            
        //   495: ldc_w           "setAdditionalAnnotations(notConsideredDeprecation)"
        //   498: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   501: pop            
        //   502: goto            510
        //   505: aconst_null    
        //   506: goto            531
        //   509: nop            
        //   510: nop            
        //   511: aload           12
        //   513: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   516: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.build:()Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   521: dup            
        //   522: ifnonnull       528
        //   525: invokestatic    kotlin/jvm/internal/Intrinsics.throwNpe:()V
        //   528: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;
        //   531: dup            
        //   532: ifnull          554
        //   535: astore          15
        //   537: aload           15
        //   539: astore          it$iv$iv
        //   541: aload           destination$iv$iv
        //   543: aload           it$iv$iv
        //   545: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   550: pop            
        //   551: goto            555
        //   554: pop            
        //   555: goto            231
        //   558: aload           destination$iv$iv
        //   560: checkcast       Ljava/util/List;
        //   563: checkcast       Ljava/util/Collection;
        //   566: areturn        
        //    Signature:
        //  (Lkotlin/reflect/jvm/internal/impl/name/Name;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedClassDescriptor;)Ljava/util/Collection<Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;>;
        //    StackMapTable: 00 15 FD 00 37 07 01 26 07 01 2C FD 00 3A 07 00 04 07 01 34 F9 00 02 40 01 09 F9 00 27 0D FF 00 30 00 08 07 00 02 07 00 93 07 01 1B 07 01 26 07 01 26 07 00 A5 07 01 26 07 01 2C 00 00 FF 00 35 00 0B 07 00 02 07 00 93 07 01 1B 07 01 26 07 01 26 07 00 A5 07 01 26 07 01 2C 07 00 04 07 00 04 07 01 5D 00 02 07 01 5D 07 00 8F 60 07 01 8E FF 00 81 00 0F 07 00 02 07 00 93 07 01 1B 07 01 26 07 01 26 07 00 A5 07 01 26 07 01 2C 07 00 04 07 00 04 07 01 5D 07 01 5D 07 01 94 07 01 94 07 00 0B 00 00 0D 11 18 03 00 51 07 01 8E 42 07 01 5D 56 07 01 5D 00 FF 00 02 00 08 07 00 02 07 00 93 07 01 1B 07 01 26 07 01 26 07 00 A5 07 01 26 07 01 2C 00 00
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
    
    @NotNull
    public Set<Name> getFunctionsNames(@NotNull final DeserializedClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull((Object)classDescriptor, "classDescriptor");
        if (!this.isAdditionalBuiltInsFeatureSupported()) {
            return SetsKt.emptySet();
        }
        final LazyJavaClassDescriptor javaAnalogue = this.getJavaAnalogue((ClassDescriptor)classDescriptor);
        if (javaAnalogue != null) {
            final LazyJavaClassMemberScope unsubstitutedMemberScope = javaAnalogue.getUnsubstitutedMemberScope();
            final Set set;
            if (unsubstitutedMemberScope != null && (set = unsubstitutedMemberScope.getFunctionNames()) != null) {
                return set;
            }
        }
        return SetsKt.emptySet();
    }
    
    private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(final DeserializedClassDescriptor classDescriptor, final Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> functionsByScope) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* classDescriptor */
        //     2: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //     5: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.getJavaAnalogue:(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Lkotlin/reflect/jvm/internal/impl/load/java/lazy/descriptors/LazyJavaClassDescriptor;
        //     8: dup            
        //     9: ifnull          15
        //    12: goto            23
        //    15: pop            
        //    16: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //    19: checkcast       Ljava/util/Collection;
        //    22: areturn        
        //    23: astore_3        /* javaAnalogueDescriptor */
        //    24: aload_0         /* this */
        //    25: getfield        kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.j2kClassMap:Lkotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap;
        //    28: aload_3         /* javaAnalogueDescriptor */
        //    29: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //    32: invokestatic    kotlin/reflect/jvm/internal/impl/resolve/descriptorUtil/DescriptorUtilsKt.getFqNameSafe:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Lkotlin/reflect/jvm/internal/impl/name/FqName;
        //    35: getstatic       kotlin/reflect/jvm/internal/impl/load/kotlin/FallbackBuiltIns.Companion:Lkotlin/reflect/jvm/internal/impl/load/kotlin/FallbackBuiltIns$Companion;
        //    38: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/FallbackBuiltIns$Companion.getInstance:()Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;
        //    41: invokevirtual   kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap.mapPlatformClass:(Lkotlin/reflect/jvm/internal/impl/name/FqName;Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;)Ljava/util/Collection;
        //    44: astore          kotlinClassDescriptors
        //    46: aload           kotlinClassDescriptors
        //    48: checkcast       Ljava/lang/Iterable;
        //    51: invokestatic    kotlin/collections/CollectionsKt.lastOrNull:(Ljava/lang/Iterable;)Ljava/lang/Object;
        //    54: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //    57: dup            
        //    58: ifnull          64
        //    61: goto            72
        //    64: pop            
        //    65: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //    68: checkcast       Ljava/util/Collection;
        //    71: areturn        
        //    72: astore          kotlinMutableClassIfContainer
        //    74: getstatic       kotlin/reflect/jvm/internal/impl/utils/SmartSet.Companion:Lkotlin/reflect/jvm/internal/impl/utils/SmartSet$Companion;
        //    77: aload           kotlinClassDescriptors
        //    79: checkcast       Ljava/lang/Iterable;
        //    82: astore          6
        //    84: astore          7
        //    86: aload           $receiver$iv
        //    88: astore          8
        //    90: new             Ljava/util/ArrayList;
        //    93: dup            
        //    94: aload           $receiver$iv
        //    96: bipush          10
        //    98: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   101: invokespecial   java/util/ArrayList.<init>:(I)V
        //   104: checkcast       Ljava/util/Collection;
        //   107: astore          destination$iv$iv
        //   109: aload           $receiver$iv$iv
        //   111: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   116: astore          10
        //   118: aload           10
        //   120: invokeinterface java/util/Iterator.hasNext:()Z
        //   125: ifeq            171
        //   128: aload           10
        //   130: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   135: astore          item$iv$iv
        //   137: aload           destination$iv$iv
        //   139: aload           item$iv$iv
        //   141: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //   144: astore          12
        //   146: astore          13
        //   148: aload           it
        //   150: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //   153: invokestatic    kotlin/reflect/jvm/internal/impl/resolve/descriptorUtil/DescriptorUtilsKt.getFqNameSafe:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Lkotlin/reflect/jvm/internal/impl/name/FqName;
        //   156: astore          14
        //   158: aload           13
        //   160: aload           14
        //   162: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   167: pop            
        //   168: goto            118
        //   171: aload           destination$iv$iv
        //   173: checkcast       Ljava/util/List;
        //   176: astore          13
        //   178: aload           7
        //   180: aload           13
        //   182: checkcast       Ljava/util/Collection;
        //   185: invokevirtual   kotlin/reflect/jvm/internal/impl/utils/SmartSet$Companion.create:(Ljava/util/Collection;)Lkotlin/reflect/jvm/internal/impl/utils/SmartSet;
        //   188: astore          kotlinVersions
        //   190: aload_0         /* this */
        //   191: getfield        kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.j2kClassMap:Lkotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap;
        //   194: aload_1         /* classDescriptor */
        //   195: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //   198: invokevirtual   kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap.isMutable:(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Z
        //   201: istore          isMutable
        //   203: aload_0         /* this */
        //   204: getfield        kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.javaAnalogueClassesWithCustomSupertypeCache:Lkotlin/reflect/jvm/internal/impl/storage/CacheWithNotNullValues;
        //   207: aload_3         /* javaAnalogueDescriptor */
        //   208: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //   211: invokestatic    kotlin/reflect/jvm/internal/impl/resolve/descriptorUtil/DescriptorUtilsKt.getFqNameSafe:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Lkotlin/reflect/jvm/internal/impl/name/FqName;
        //   214: new             Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$getAdditionalFunctions$fakeJavaClassDescriptor$1;
        //   217: dup            
        //   218: aload_3         /* javaAnalogueDescriptor */
        //   219: aload           kotlinMutableClassIfContainer
        //   221: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$getAdditionalFunctions$fakeJavaClassDescriptor$1.<init>:(Lkotlin/reflect/jvm/internal/impl/load/java/lazy/descriptors/LazyJavaClassDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)V
        //   224: checkcast       Lkotlin/jvm/functions/Function0;
        //   227: invokeinterface kotlin/reflect/jvm/internal/impl/storage/CacheWithNotNullValues.computeIfAbsent:(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;
        //   232: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //   235: astore          fakeJavaClassDescriptor
        //   237: aload           fakeJavaClassDescriptor
        //   239: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor.getUnsubstitutedMemberScope:()Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;
        //   244: astore          scope
        //   246: aload_2         /* functionsByScope */
        //   247: aload           scope
        //   249: dup            
        //   250: ldc_w           "scope"
        //   253: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   256: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   261: checkcast       Ljava/lang/Iterable;
        //   264: astore          10
        //   266: nop            
        //   267: aload           $receiver$iv
        //   269: astore          11
        //   271: new             Ljava/util/ArrayList;
        //   274: dup            
        //   275: invokespecial   java/util/ArrayList.<init>:()V
        //   278: checkcast       Ljava/util/Collection;
        //   281: astore          destination$iv$iv
        //   283: aload           $receiver$iv$iv
        //   285: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   290: astore          16
        //   292: aload           16
        //   294: invokeinterface java/util/Iterator.hasNext:()Z
        //   299: ifeq            484
        //   302: aload           16
        //   304: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   309: astore          element$iv$iv
        //   311: aload           element$iv$iv
        //   313: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;
        //   316: astore          analogueMember
        //   318: aload           analogueMember
        //   320: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor.getKind:()Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor$Kind;
        //   325: getstatic       kotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor$Kind.DECLARATION:Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor$Kind;
        //   328: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   331: iconst_1       
        //   332: ixor           
        //   333: ifeq            340
        //   336: iconst_0       
        //   337: goto            468
        //   340: aload           analogueMember
        //   342: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor.getVisibility:()Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;
        //   347: invokevirtual   kotlin/reflect/jvm/internal/impl/descriptors/Visibility.isPublicAPI:()Z
        //   350: ifne            357
        //   353: iconst_0       
        //   354: goto            468
        //   357: aload           analogueMember
        //   359: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //   362: invokestatic    kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.isDeprecated:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Z
        //   365: ifeq            372
        //   368: iconst_0       
        //   369: goto            468
        //   372: aload           analogueMember
        //   374: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor.getOverriddenDescriptors:()Ljava/util/Collection;
        //   379: checkcast       Ljava/lang/Iterable;
        //   382: astore          $receiver$iv
        //   384: aload           $receiver$iv
        //   386: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   391: astore          20
        //   393: aload           20
        //   395: invokeinterface java/util/Iterator.hasNext:()Z
        //   400: ifeq            444
        //   403: aload           20
        //   405: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   410: astore          element$iv
        //   412: aload           element$iv
        //   414: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   417: astore          it
        //   419: aload           kotlinVersions
        //   421: aload           it
        //   423: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor.getContainingDeclaration:()Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //   428: invokestatic    kotlin/reflect/jvm/internal/impl/resolve/descriptorUtil/DescriptorUtilsKt.getFqNameSafe:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Lkotlin/reflect/jvm/internal/impl/name/FqName;
        //   431: invokevirtual   kotlin/reflect/jvm/internal/impl/utils/SmartSet.contains:(Ljava/lang/Object;)Z
        //   434: ifeq            441
        //   437: iconst_1       
        //   438: goto            445
        //   441: goto            393
        //   444: iconst_0       
        //   445: ifeq            452
        //   448: iconst_0       
        //   449: goto            468
        //   452: aload_0         /* this */
        //   453: aload           analogueMember
        //   455: iload           isMutable
        //   457: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.isMutabilityViolation:(Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;Z)Z
        //   460: ifne            467
        //   463: iconst_1       
        //   464: goto            468
        //   467: iconst_0       
        //   468: ifeq            481
        //   471: aload           destination$iv$iv
        //   473: aload           element$iv$iv
        //   475: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   480: pop            
        //   481: goto            292
        //   484: aload           destination$iv$iv
        //   486: checkcast       Ljava/util/List;
        //   489: checkcast       Ljava/util/Collection;
        //   492: areturn        
        //    Signature:
        //  (Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lkotlin/jvm/functions/Function1<-Lkotlin/reflect/jvm/internal/impl/resolve/scopes/MemberScope;+Ljava/util/Collection<+Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;>;>;)Ljava/util/Collection<Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;>;
        //    StackMapTable: 00 13 4F 07 02 06 47 07 02 06 FF 00 28 00 05 07 00 02 07 01 1B 07 01 68 07 02 06 07 00 A5 00 01 07 01 13 47 07 01 13 FF 00 2D 00 0B 07 00 02 07 01 1B 07 01 68 07 02 06 07 00 A5 07 01 13 07 01 26 07 02 3A 07 01 26 07 00 A5 07 01 2C 00 00 34 FF 00 78 00 11 07 00 02 07 01 1B 07 01 68 07 02 06 07 00 A5 07 01 13 01 07 02 3A 07 01 13 07 00 B6 07 01 26 07 01 26 07 00 A5 07 01 E0 00 07 02 2E 07 01 2C 00 00 FD 00 2F 07 00 04 07 01 5D 10 0E FD 00 14 07 01 26 07 01 2C FD 00 2F 07 00 04 07 01 8E F9 00 02 40 01 06 0E FF 00 00 00 13 07 00 02 07 01 1B 07 01 68 07 02 06 07 00 A5 07 01 13 01 07 02 3A 07 01 13 07 00 B6 07 01 26 07 01 26 07 00 A5 07 01 E0 00 07 02 2E 07 01 2C 07 00 04 07 01 5D 00 01 01 0C F9 00 02
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
    
    private final SimpleFunctionDescriptor createCloneForArray(final DeserializedClassDescriptor arrayClassDescriptor, final SimpleFunctionDescriptor cloneFromCloneable) {
        final FunctionDescriptor$CopyBuilder copyBuilder = cloneFromCloneable.newCopyBuilder();
        final FunctionDescriptor$CopyBuilder $receiver = copyBuilder;
        $receiver.setOwner((DeclarationDescriptor)arrayClassDescriptor);
        $receiver.setVisibility(Visibilities.PUBLIC);
        $receiver.setReturnType((KotlinType)arrayClassDescriptor.getDefaultType());
        $receiver.setDispatchReceiverParameter(arrayClassDescriptor.getThisAsReceiverParameter());
        final FunctionDescriptor build = copyBuilder.build();
        if (build == null) {
            Intrinsics.throwNpe();
        }
        return (SimpleFunctionDescriptor)build;
    }
    
    private final boolean isMutabilityViolation(@NotNull final SimpleFunctionDescriptor $receiver, final boolean isMutable) {
        final DeclarationDescriptor containingDeclaration = $receiver.getContainingDeclaration();
        if (containingDeclaration == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        final ClassDescriptor owner = (ClassDescriptor)containingDeclaration;
        final String jvmDescriptor = MethodSignatureMappingKt.computeJvmDescriptor$default((FunctionDescriptor)$receiver, false, 1, (Object)null);
        final Set<String> mutable_METHOD_SIGNATURES = JvmBuiltInsSettings.Companion.getMUTABLE_METHOD_SIGNATURES();
        final SignatureBuildingComponents instance = SignatureBuildingComponents.INSTANCE;
        final ClassDescriptor classDescriptor = owner;
        final String s = jvmDescriptor;
        Intrinsics.checkExpressionValueIsNotNull((Object)s, "jvmDescriptor");
        if (mutable_METHOD_SIGNATURES.contains(instance.signature(classDescriptor, s)) ^ isMutable) {
            return true;
        }
        final Boolean ifAny = DFS.ifAny((Collection)CollectionsKt.listOf((Object)$receiver), (DFS$Neighbors)JvmBuiltInsSettings$isMutabilityViolation.JvmBuiltInsSettings$isMutabilityViolation$1.INSTANCE, (Function1)new JvmBuiltInsSettings$isMutabilityViolation.JvmBuiltInsSettings$isMutabilityViolation$2(this));
        Intrinsics.checkExpressionValueIsNotNull((Object)ifAny, "DFS.ifAny<CallableMember\u2026lassDescriptor)\n        }");
        return ifAny;
    }
    
    private final JDKMemberStatus getJdkMethodStatus(@NotNull final FunctionDescriptor $receiver) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor.getContainingDeclaration:()Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //     6: dup            
        //     7: ifnonnull       21
        //    10: new             Lkotlin/TypeCastException;
        //    13: dup            
        //    14: ldc_w           "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
        //    17: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //    20: athrow         
        //    21: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //    24: astore_2        /* owner */
        //    25: aload_1         /* $receiver */
        //    26: iconst_0       
        //    27: iconst_1       
        //    28: aconst_null    
        //    29: invokestatic    kotlin/reflect/jvm/internal/impl/load/kotlin/MethodSignatureMappingKt.computeJvmDescriptor$default:(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;ZILjava/lang/Object;)Ljava/lang/String;
        //    32: astore_3        /* jvmDescriptor */
        //    33: new             Lkotlin/jvm/internal/Ref$ObjectRef;
        //    36: dup            
        //    37: invokespecial   kotlin/jvm/internal/Ref$ObjectRef.<init>:()V
        //    40: astore          4
        //    42: aload           4
        //    44: aconst_null    
        //    45: checkcast       Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$JDKMemberStatus;
        //    48: putfield        kotlin/jvm/internal/Ref$ObjectRef.element:Ljava/lang/Object;
        //    51: aload_2         /* owner */
        //    52: invokestatic    kotlin/collections/CollectionsKt.listOf:(Ljava/lang/Object;)Ljava/util/List;
        //    55: checkcast       Ljava/util/Collection;
        //    58: new             Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$getJdkMethodStatus$1;
        //    61: dup            
        //    62: aload_0         /* this */
        //    63: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$getJdkMethodStatus$1.<init>:(Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings;)V
        //    66: checkcast       Lkotlin/reflect/jvm/internal/impl/utils/DFS$Neighbors;
        //    69: new             Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$getJdkMethodStatus$2;
        //    72: dup            
        //    73: aload_3         /* jvmDescriptor */
        //    74: aload           result
        //    76: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$getJdkMethodStatus$2.<init>:(Ljava/lang/String;Lkotlin/jvm/internal/Ref$ObjectRef;)V
        //    79: checkcast       Lkotlin/reflect/jvm/internal/impl/utils/DFS$NodeHandler;
        //    82: invokestatic    kotlin/reflect/jvm/internal/impl/utils/DFS.dfs:(Ljava/util/Collection;Lkotlin/reflect/jvm/internal/impl/utils/DFS$Neighbors;Lkotlin/reflect/jvm/internal/impl/utils/DFS$NodeHandler;)Ljava/lang/Object;
        //    85: dup            
        //    86: ldc_w           "DFS.dfs<ClassDescriptor,\u2026IDERED\n                })"
        //    89: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    92: checkcast       Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$JDKMemberStatus;
        //    95: areturn        
        //    StackMapTable: 00 01 55 07 00 8F
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
    
    private final LazyJavaClassDescriptor getJavaAnalogue(@NotNull final ClassDescriptor $receiver) {
        if (JvmBuiltInsSettingsKt.access$isAny$p($receiver)) {
            return null;
        }
        final FqNameUnsafe fqNameUnsafe = (FqNameUnsafe)AddToStdlibKt.check((Object)DescriptorUtilsKt.getFqNameUnsafe((DeclarationDescriptor)$receiver), (Function1)JvmBuiltInsSettings$getJavaAnalogue$fqName.JvmBuiltInsSettings$getJavaAnalogue$fqName$1.INSTANCE);
        if (fqNameUnsafe != null) {
            final FqName safe = fqNameUnsafe.toSafe();
            if (safe != null) {
                final FqName fqName = safe;
                final ClassId mapKotlinToJava = this.j2kClassMap.mapKotlinToJava(fqName.toUnsafe());
                if (mapKotlinToJava != null) {
                    final FqName singleFqName = mapKotlinToJava.asSingleFqName();
                    if (singleFqName != null) {
                        final FqName javaAnalogueFqName = singleFqName;
                        final ModuleDescriptor ownerModuleDescriptor = this.getOwnerModuleDescriptor();
                        final FqName fqName2 = javaAnalogueFqName;
                        Intrinsics.checkExpressionValueIsNotNull((Object)fqName2, "javaAnalogueFqName");
                        ClassDescriptor resolveClassByFqName;
                        if (!((resolveClassByFqName = DescriptorUtilKt.resolveClassByFqName(ownerModuleDescriptor, fqName2, (LookupLocation)NoLookupLocation.FROM_BUILTINS)) instanceof LazyJavaClassDescriptor)) {
                            resolveClassByFqName = null;
                        }
                        return (LazyJavaClassDescriptor)resolveClassByFqName;
                    }
                }
                return null;
            }
        }
        return null;
    }
    
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors(@NotNull final DeserializedClassDescriptor classDescriptor) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "classDescriptor"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* classDescriptor */
        //     7: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedClassDescriptor.getKind:()Lkotlin/reflect/jvm/internal/impl/descriptors/ClassKind;
        //    10: getstatic       kotlin/reflect/jvm/internal/impl/descriptors/ClassKind.CLASS:Lkotlin/reflect/jvm/internal/impl/descriptors/ClassKind;
        //    13: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    16: iconst_1       
        //    17: ixor           
        //    18: ifne            28
        //    21: aload_0         /* this */
        //    22: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.isAdditionalBuiltInsFeatureSupported:()Z
        //    25: ifne            35
        //    28: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //    31: checkcast       Ljava/util/Collection;
        //    34: areturn        
        //    35: aload_0         /* this */
        //    36: aload_1         /* classDescriptor */
        //    37: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //    40: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.getJavaAnalogue:(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Lkotlin/reflect/jvm/internal/impl/load/java/lazy/descriptors/LazyJavaClassDescriptor;
        //    43: dup            
        //    44: ifnull          50
        //    47: goto            58
        //    50: pop            
        //    51: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //    54: checkcast       Ljava/util/Collection;
        //    57: areturn        
        //    58: astore_2        /* javaAnalogueDescriptor */
        //    59: aload_0         /* this */
        //    60: getfield        kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.j2kClassMap:Lkotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap;
        //    63: aload_2         /* javaAnalogueDescriptor */
        //    64: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //    67: invokestatic    kotlin/reflect/jvm/internal/impl/resolve/descriptorUtil/DescriptorUtilsKt.getFqNameSafe:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Lkotlin/reflect/jvm/internal/impl/name/FqName;
        //    70: getstatic       kotlin/reflect/jvm/internal/impl/load/kotlin/FallbackBuiltIns.Companion:Lkotlin/reflect/jvm/internal/impl/load/kotlin/FallbackBuiltIns$Companion;
        //    73: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/FallbackBuiltIns$Companion.getInstance:()Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;
        //    76: invokevirtual   kotlin/reflect/jvm/internal/impl/platform/JavaToKotlinClassMap.mapJavaToKotlin:(Lkotlin/reflect/jvm/internal/impl/name/FqName;Lkotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns;)Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //    79: dup            
        //    80: ifnull          86
        //    83: goto            94
        //    86: pop            
        //    87: invokestatic    kotlin/collections/CollectionsKt.emptyList:()Ljava/util/List;
        //    90: checkcast       Ljava/util/Collection;
        //    93: areturn        
        //    94: astore_3        /* defaultKotlinVersion */
        //    95: aload_3         /* defaultKotlinVersion */
        //    96: dup            
        //    97: ldc_w           "defaultKotlinVersion"
        //   100: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   103: aload_2         /* javaAnalogueDescriptor */
        //   104: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //   107: invokestatic    kotlin/reflect/jvm/internal/impl/platform/MappingUtilKt.createMappedTypeParametersSubstitution:(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Lkotlin/reflect/jvm/internal/impl/types/TypeConstructorSubstitution;
        //   110: invokevirtual   kotlin/reflect/jvm/internal/impl/types/TypeConstructorSubstitution.buildSubstitutor:()Lkotlin/reflect/jvm/internal/impl/types/TypeSubstitutor;
        //   113: astore          substitutor
        //   115: new             Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$getConstructors$1;
        //   118: dup            
        //   119: aload           substitutor
        //   121: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$getConstructors$1.<init>:(Lkotlin/reflect/jvm/internal/impl/types/TypeSubstitutor;)V
        //   124: astore          isEffectivelyTheSameAs$
        //   126: aload_2         /* javaAnalogueDescriptor */
        //   127: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/lazy/descriptors/LazyJavaClassDescriptor.getConstructors:()Ljava/util/List;
        //   130: checkcast       Ljava/lang/Iterable;
        //   133: astore          $receiver$iv
        //   135: aload           $receiver$iv
        //   137: astore          7
        //   139: new             Ljava/util/ArrayList;
        //   142: dup            
        //   143: invokespecial   java/util/ArrayList.<init>:()V
        //   146: checkcast       Ljava/util/Collection;
        //   149: astore          destination$iv$iv
        //   151: aload           $receiver$iv$iv
        //   153: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   158: astore          9
        //   160: aload           9
        //   162: invokeinterface java/util/Iterator.hasNext:()Z
        //   167: ifeq            370
        //   170: aload           9
        //   172: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   177: astore          element$iv$iv
        //   179: aload           element$iv$iv
        //   181: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor;
        //   184: astore          javaConstructor
        //   186: aload           javaConstructor
        //   188: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor.getVisibility:()Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;
        //   193: invokevirtual   kotlin/reflect/jvm/internal/impl/descriptors/Visibility.isPublicAPI:()Z
        //   196: ifeq            353
        //   199: aload_3         /* defaultKotlinVersion */
        //   200: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor.getConstructors:()Ljava/util/Collection;
        //   205: checkcast       Ljava/lang/Iterable;
        //   208: astore          $receiver$iv
        //   210: aload           $receiver$iv
        //   212: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   217: astore          13
        //   219: aload           13
        //   221: invokeinterface java/util/Iterator.hasNext:()Z
        //   226: ifeq            277
        //   229: aload           13
        //   231: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   236: astore          element$iv
        //   238: aload           element$iv
        //   240: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor;
        //   243: astore          it
        //   245: aload           isEffectivelyTheSameAs$
        //   247: aload           it
        //   249: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;
        //   252: aload           javaConstructor
        //   254: dup            
        //   255: ldc_w           "javaConstructor"
        //   258: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   261: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;
        //   264: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$getConstructors$1.invoke:(Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;)Z
        //   267: ifeq            274
        //   270: iconst_0       
        //   271: goto            278
        //   274: goto            219
        //   277: iconst_1       
        //   278: ifeq            353
        //   281: aload_0         /* this */
        //   282: aload           javaConstructor
        //   284: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;
        //   287: aload_1         /* classDescriptor */
        //   288: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.isTrivialCopyConstructorFor:(Lkotlin/reflect/jvm/internal/impl/descriptors/ConstructorDescriptor;Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedClassDescriptor;)Z
        //   291: ifne            353
        //   294: aload           javaConstructor
        //   296: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //   299: invokestatic    kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns.isDeprecated:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Z
        //   302: ifne            353
        //   305: getstatic       kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.Companion:Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$Companion;
        //   308: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$Companion.getBLACK_LIST_CONSTRUCTOR_SIGNATURES:()Ljava/util/Set;
        //   311: getstatic       kotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents.INSTANCE:Lkotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents;
        //   314: aload_2         /* javaAnalogueDescriptor */
        //   315: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //   318: aload           javaConstructor
        //   320: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   323: iconst_0       
        //   324: iconst_1       
        //   325: aconst_null    
        //   326: invokestatic    kotlin/reflect/jvm/internal/impl/load/kotlin/MethodSignatureMappingKt.computeJvmDescriptor$default:(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;ZILjava/lang/Object;)Ljava/lang/String;
        //   329: dup            
        //   330: ldc_w           "javaConstructor.computeJvmDescriptor()"
        //   333: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   336: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents.signature:(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;Ljava/lang/String;)Ljava/lang/String;
        //   339: invokeinterface java/util/Set.contains:(Ljava/lang/Object;)Z
        //   344: iconst_1       
        //   345: ixor           
        //   346: ifeq            353
        //   349: iconst_1       
        //   350: goto            354
        //   353: iconst_0       
        //   354: ifeq            367
        //   357: aload           destination$iv$iv
        //   359: aload           element$iv$iv
        //   361: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   366: pop            
        //   367: goto            160
        //   370: aload           destination$iv$iv
        //   372: checkcast       Ljava/util/List;
        //   375: checkcast       Ljava/lang/Iterable;
        //   378: astore          6
        //   380: nop            
        //   381: aload           $receiver$iv
        //   383: astore          7
        //   385: new             Ljava/util/ArrayList;
        //   388: dup            
        //   389: aload           $receiver$iv
        //   391: bipush          10
        //   393: invokestatic    kotlin/collections/CollectionsKt.collectionSizeOrDefault:(Ljava/lang/Iterable;I)I
        //   396: invokespecial   java/util/ArrayList.<init>:(I)V
        //   399: checkcast       Ljava/util/Collection;
        //   402: astore          destination$iv$iv
        //   404: aload           $receiver$iv$iv
        //   406: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   411: astore          9
        //   413: aload           9
        //   415: invokeinterface java/util/Iterator.hasNext:()Z
        //   420: ifeq            610
        //   423: aload           9
        //   425: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   430: astore          item$iv$iv
        //   432: aload           destination$iv$iv
        //   434: aload           item$iv$iv
        //   436: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor;
        //   439: astore          11
        //   441: astore          16
        //   443: aload           javaConstructor
        //   445: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor.newCopyBuilder:()Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   450: astore          12
        //   452: aload           12
        //   454: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   457: astore          $receiver
        //   459: aload           $receiver
        //   461: aload_1         /* classDescriptor */
        //   462: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;
        //   465: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.setOwner:(Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   470: pop            
        //   471: aload           $receiver
        //   473: aload_1         /* classDescriptor */
        //   474: invokevirtual   kotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedClassDescriptor.getDefaultType:()Lkotlin/reflect/jvm/internal/impl/types/SimpleType;
        //   477: checkcast       Lkotlin/reflect/jvm/internal/impl/types/KotlinType;
        //   480: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.setReturnType:(Lkotlin/reflect/jvm/internal/impl/types/KotlinType;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   485: pop            
        //   486: aload           $receiver
        //   488: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.setPreserveSourceElement:()Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   493: pop            
        //   494: aload           $receiver
        //   496: aload           substitutor
        //   498: invokevirtual   kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor.getSubstitution:()Lkotlin/reflect/jvm/internal/impl/types/TypeSubstitution;
        //   501: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.setSubstitution:(Lkotlin/reflect/jvm/internal/impl/types/TypeSubstitution;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   506: pop            
        //   507: getstatic       kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.Companion:Lkotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$Companion;
        //   510: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings$Companion.getWHITE_LIST_CONSTRUCTOR_SIGNATURES:()Ljava/util/Set;
        //   513: getstatic       kotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents.INSTANCE:Lkotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents;
        //   516: aload_2         /* javaAnalogueDescriptor */
        //   517: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //   520: aload           javaConstructor
        //   522: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   525: iconst_0       
        //   526: iconst_1       
        //   527: aconst_null    
        //   528: invokestatic    kotlin/reflect/jvm/internal/impl/load/kotlin/MethodSignatureMappingKt.computeJvmDescriptor$default:(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;ZILjava/lang/Object;)Ljava/lang/String;
        //   531: dup            
        //   532: ldc_w           "javaConstructor.computeJvmDescriptor()"
        //   535: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //   538: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents.signature:(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;Ljava/lang/String;)Ljava/lang/String;
        //   541: invokeinterface java/util/Set.contains:(Ljava/lang/Object;)Z
        //   546: iconst_1       
        //   547: ixor           
        //   548: ifeq            566
        //   551: aload           $receiver
        //   553: aload_0         /* this */
        //   554: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.getNotConsideredDeprecation:()Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationsImpl;
        //   557: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;
        //   560: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.setAdditionalAnnotations:(Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;)Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   565: pop            
        //   566: nop            
        //   567: aload           12
        //   569: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder;
        //   572: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor$CopyBuilder.build:()Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   577: dup            
        //   578: ifnonnull       592
        //   581: new             Lkotlin/TypeCastException;
        //   584: dup            
        //   585: ldc_w           "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor"
        //   588: invokespecial   kotlin/TypeCastException.<init>:(Ljava/lang/String;)V
        //   591: athrow         
        //   592: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor;
        //   595: astore          17
        //   597: aload           16
        //   599: aload           17
        //   601: invokeinterface java/util/Collection.add:(Ljava/lang/Object;)Z
        //   606: pop            
        //   607: goto            413
        //   610: aload           destination$iv$iv
        //   612: checkcast       Ljava/util/List;
        //   615: checkcast       Ljava/util/Collection;
        //   618: areturn        
        //    Signature:
        //  (Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedClassDescriptor;)Ljava/util/Collection<Lkotlin/reflect/jvm/internal/impl/descriptors/ClassConstructorDescriptor;>;
        //    StackMapTable: 00 13 1C 06 4E 07 02 06 47 07 02 06 FF 00 1B 00 03 07 00 02 07 01 1B 07 02 06 00 01 07 01 13 47 07 01 13 FF 00 41 00 0A 07 00 02 07 01 1B 07 02 06 07 01 13 07 03 17 07 00 20 07 01 26 07 01 26 07 00 A5 07 01 2C 00 00 FF 00 3A 00 0E 07 00 02 07 01 1B 07 02 06 07 01 13 07 03 17 07 00 20 07 01 26 07 01 26 07 00 A5 07 01 2C 07 00 04 07 03 19 07 01 26 07 01 2C 00 00 FD 00 36 07 00 04 07 03 19 F9 00 02 40 01 F9 00 4A 40 01 0C F9 00 02 2A FF 00 98 00 11 07 00 02 07 01 1B 07 02 06 07 01 13 07 03 17 07 00 20 07 01 26 07 01 26 07 00 A5 07 01 2C 07 00 04 07 03 19 07 01 94 07 01 94 00 00 07 00 A5 00 00 59 07 01 8E FF 00 11 00 0A 07 00 02 07 01 1B 07 02 06 07 01 13 07 03 17 07 00 20 07 01 26 07 01 26 07 00 A5 07 01 2C 00 00
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
    
    public boolean isFunctionAvailable(@NotNull final DeserializedClassDescriptor classDescriptor, @NotNull final SimpleFunctionDescriptor functionDescriptor) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "classDescriptor"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_2         /* functionDescriptor */
        //     7: ldc_w           "functionDescriptor"
        //    10: invokestatic    kotlin/jvm/internal/Intrinsics.checkParameterIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    13: aload_2         /* functionDescriptor */
        //    14: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor.getAnnotations:()Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;
        //    19: invokestatic    kotlin/reflect/jvm/internal/impl/serialization/deserialization/PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME:()Lkotlin/reflect/jvm/internal/impl/name/FqName;
        //    22: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations.hasAnnotation:(Lkotlin/reflect/jvm/internal/impl/name/FqName;)Z
        //    27: ifne            32
        //    30: iconst_1       
        //    31: ireturn        
        //    32: aload_0         /* this */
        //    33: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.isAdditionalBuiltInsFeatureSupported:()Z
        //    36: ifne            41
        //    39: iconst_0       
        //    40: ireturn        
        //    41: aload_0         /* this */
        //    42: aload_1         /* classDescriptor */
        //    43: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;
        //    46: invokespecial   kotlin/reflect/jvm/internal/impl/load/kotlin/JvmBuiltInsSettings.getJavaAnalogue:(Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;)Lkotlin/reflect/jvm/internal/impl/load/java/lazy/descriptors/LazyJavaClassDescriptor;
        //    49: dup            
        //    50: ifnull          56
        //    53: goto            59
        //    56: pop            
        //    57: iconst_1       
        //    58: ireturn        
        //    59: astore_3        /* javaAnalogueClassDescriptor */
        //    60: aload_2         /* functionDescriptor */
        //    61: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //    64: iconst_0       
        //    65: iconst_1       
        //    66: aconst_null    
        //    67: invokestatic    kotlin/reflect/jvm/internal/impl/load/kotlin/MethodSignatureMappingKt.computeJvmDescriptor$default:(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;ZILjava/lang/Object;)Ljava/lang/String;
        //    70: astore          jvmDescriptor
        //    72: aload_3         /* javaAnalogueClassDescriptor */
        //    73: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/lazy/descriptors/LazyJavaClassDescriptor.getUnsubstitutedMemberScope:()Lkotlin/reflect/jvm/internal/impl/load/java/lazy/descriptors/LazyJavaClassMemberScope;
        //    76: aload_2         /* functionDescriptor */
        //    77: invokeinterface kotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor.getName:()Lkotlin/reflect/jvm/internal/impl/name/Name;
        //    82: dup            
        //    83: ldc_w           "functionDescriptor.name"
        //    86: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
        //    89: getstatic       kotlin/reflect/jvm/internal/impl/incremental/components/NoLookupLocation.FROM_BUILTINS:Lkotlin/reflect/jvm/internal/impl/incremental/components/NoLookupLocation;
        //    92: checkcast       Lkotlin/reflect/jvm/internal/impl/incremental/components/LookupLocation;
        //    95: invokevirtual   kotlin/reflect/jvm/internal/impl/load/java/lazy/descriptors/LazyJavaClassMemberScope.getContributedFunctions:(Lkotlin/reflect/jvm/internal/impl/name/Name;Lkotlin/reflect/jvm/internal/impl/incremental/components/LookupLocation;)Ljava/util/Collection;
        //    98: checkcast       Ljava/lang/Iterable;
        //   101: astore          5
        //   103: nop            
        //   104: aload           $receiver$iv
        //   106: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   111: astore          6
        //   113: aload           6
        //   115: invokeinterface java/util/Iterator.hasNext:()Z
        //   120: ifeq            165
        //   123: aload           6
        //   125: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   130: astore          element$iv
        //   132: aload           element$iv
        //   134: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;
        //   137: astore          it
        //   139: aload           it
        //   141: checkcast       Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;
        //   144: iconst_0       
        //   145: iconst_1       
        //   146: aconst_null    
        //   147: invokestatic    kotlin/reflect/jvm/internal/impl/load/kotlin/MethodSignatureMappingKt.computeJvmDescriptor$default:(Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;ZILjava/lang/Object;)Ljava/lang/String;
        //   150: aload           jvmDescriptor
        //   152: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   155: ifeq            162
        //   158: iconst_1       
        //   159: goto            166
        //   162: goto            113
        //   165: iconst_0       
        //   166: ireturn        
        //    StackMapTable: 00 08 20 08 4E 07 02 06 42 07 02 06 FF 00 35 00 07 07 00 02 07 01 1B 07 01 5D 07 02 06 07 02 B5 07 01 26 07 01 2C 00 00 FD 00 30 07 00 04 07 01 5D F9 00 02 40 01
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
    
    private final boolean isTrivialCopyConstructorFor(@NotNull final ConstructorDescriptor $receiver, final DeserializedClassDescriptor classDescriptor) {
        if ($receiver.getValueParameters().size() == 1) {
            final ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor)CollectionsKt.single($receiver.getValueParameters())).getType().getConstructor().getDeclarationDescriptor();
            if (Intrinsics.areEqual((Object)((declarationDescriptor != null) ? DescriptorUtilsKt.getFqNameUnsafe((DeclarationDescriptor)declarationDescriptor) : null), (Object)DescriptorUtilsKt.getFqNameUnsafe((DeclarationDescriptor)classDescriptor))) {
                return true;
            }
        }
        return false;
    }
    
    public JvmBuiltInsSettings(@NotNull final ModuleDescriptor moduleDescriptor, @NotNull final StorageManager storageManager, @NotNull final Function0<? extends ModuleDescriptor> deferredOwnerModuleDescriptor, @NotNull final Function0<Boolean> isAdditionalBuiltInsFeatureSupported) {
        Intrinsics.checkParameterIsNotNull((Object)moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkParameterIsNotNull((Object)storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull((Object)deferredOwnerModuleDescriptor, "deferredOwnerModuleDescriptor");
        Intrinsics.checkParameterIsNotNull((Object)isAdditionalBuiltInsFeatureSupported, "isAdditionalBuiltInsFeatureSupported");
        this.moduleDescriptor = moduleDescriptor;
        this.j2kClassMap = JavaToKotlinClassMap.INSTANCE;
        this.ownerModuleDescriptor$delegate = LazyKt.lazy((Function0)deferredOwnerModuleDescriptor);
        this.isAdditionalBuiltInsFeatureSupported$delegate = LazyKt.lazy((Function0)isAdditionalBuiltInsFeatureSupported);
        this.mockSerializableType = this.createMockJavaIoSerializableType(storageManager);
        this.cloneableType$delegate = storageManager.createLazyValue((Function0)new JvmBuiltInsSettings$cloneableType.JvmBuiltInsSettings$cloneableType$2(this, storageManager));
        this.javaAnalogueClassesWithCustomSupertypeCache = (CacheWithNotNullValues<FqName, ClassDescriptor>)storageManager.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = storageManager.createLazyValue((Function0)new JvmBuiltInsSettings$notConsideredDeprecation.JvmBuiltInsSettings$notConsideredDeprecation$2(this));
    }
    
    static {
        Companion = new Companion(null);
        DROP_LIST_METHOD_SIGNATURES = SetsKt.plus((Set)SignatureBuildingComponents.INSTANCE.inJavaUtil("Collection", new String[] { "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;" }), (Object)"java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        SignatureBuildingComponents $receiver = SignatureBuildingComponents.INSTANCE;
        BLACK_LIST_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(JvmBuiltInsSettings.Companion.buildPrimitiveValueMethodsSet(), (Iterable)$receiver.inJavaUtil("List", new String[] { "sort(Ljava/util/Comparator;)V" })), (Iterable)$receiver.inJavaLang("String", new String[] { "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;" })), (Iterable)$receiver.inJavaLang("Double", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)$receiver.inJavaLang("Float", new String[] { "isInfinite()Z", "isNaN()Z" })), (Iterable)$receiver.inJavaLang("Enum", new String[] { "getDeclaringClass()Ljava/lang/Class;", "finalize()V" }));
        $receiver = SignatureBuildingComponents.INSTANCE;
        WHITE_LIST_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus((Set)$receiver.inJavaLang("CharSequence", new String[] { "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;" }), (Iterable)$receiver.inJavaUtil("Iterator", new String[] { "forEachRemaining(Ljava/util/function/Consumer;)V" })), (Iterable)$receiver.inJavaLang("Iterable", new String[] { "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;" })), (Iterable)$receiver.inJavaLang("Throwable", new String[] { "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V" })), (Iterable)$receiver.inJavaUtil("Collection", new String[] { "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z" })), (Iterable)$receiver.inJavaUtil("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V" })), (Iterable)$receiver.inJavaUtil("Map", new String[] { "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;" }));
        $receiver = SignatureBuildingComponents.INSTANCE;
        MUTABLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus((Set)$receiver.inJavaUtil("Collection", new String[] { "removeIf(Ljava/util/function/Predicate;)Z" }), (Iterable)$receiver.inJavaUtil("List", new String[] { "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V" })), (Iterable)$receiver.inJavaUtil("Map", new String[] { "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z" }));
        $receiver = SignatureBuildingComponents.INSTANCE;
        final Set access$buildPrimitiveStringConstructorsSet = JvmBuiltInsSettings.Companion.buildPrimitiveStringConstructorsSet();
        final SignatureBuildingComponents signatureBuildingComponents = $receiver;
        final String s = "Float";
        final String[] constructors = $receiver.constructors(new String[] { "D" });
        final Set plus = SetsKt.plus(access$buildPrimitiveStringConstructorsSet, (Iterable)signatureBuildingComponents.inJavaLang(s, (String[])Arrays.copyOf(constructors, constructors.length)));
        final SignatureBuildingComponents signatureBuildingComponents2 = $receiver;
        final String s2 = "String";
        final String[] constructors2 = $receiver.constructors(new String[] { "[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;" });
        BLACK_LIST_CONSTRUCTOR_SIGNATURES = SetsKt.plus(plus, (Iterable)signatureBuildingComponents2.inJavaLang(s2, (String[])Arrays.copyOf(constructors2, constructors2.length)));
        final SignatureBuildingComponents signatureBuildingComponents3;
        $receiver = (signatureBuildingComponents3 = SignatureBuildingComponents.INSTANCE);
        final String s3 = "Throwable";
        final String[] constructors3 = $receiver.constructors(new String[] { "Ljava/lang/String;Ljava/lang/Throwable;ZZ" });
        WHITE_LIST_CONSTRUCTOR_SIGNATURES = signatureBuildingComponents3.inJavaLang(s3, (String[])Arrays.copyOf(constructors3, constructors3.length));
        $$delegatedProperties = new KProperty[] { (KProperty)Reflection.property1((PropertyReference1)new PropertyReference1Impl((KDeclarationContainer)Reflection.getOrCreateKotlinClass((Class)JvmBuiltInsSettings.class), "ownerModuleDescriptor", "getOwnerModuleDescriptor()Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;")), (KProperty)Reflection.property1((PropertyReference1)new PropertyReference1Impl((KDeclarationContainer)Reflection.getOrCreateKotlinClass((Class)JvmBuiltInsSettings.class), "isAdditionalBuiltInsFeatureSupported", "isAdditionalBuiltInsFeatureSupported()Z")), (KProperty)Reflection.property1((PropertyReference1)new PropertyReference1Impl((KDeclarationContainer)Reflection.getOrCreateKotlinClass((Class)JvmBuiltInsSettings.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), (KProperty)Reflection.property1((PropertyReference1)new PropertyReference1Impl((KDeclarationContainer)Reflection.getOrCreateKotlinClass((Class)JvmBuiltInsSettings.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationsImpl;")) };
    }
    
    @NotNull
    public static final /* synthetic */ Set access$getDROP_LIST_METHOD_SIGNATURES$cp() {
        return JvmBuiltInsSettings.DROP_LIST_METHOD_SIGNATURES;
    }
    
    @NotNull
    public static final /* synthetic */ Set access$getBLACK_LIST_METHOD_SIGNATURES$cp() {
        return JvmBuiltInsSettings.BLACK_LIST_METHOD_SIGNATURES;
    }
    
    @NotNull
    public static final /* synthetic */ Set access$getWHITE_LIST_METHOD_SIGNATURES$cp() {
        return JvmBuiltInsSettings.WHITE_LIST_METHOD_SIGNATURES;
    }
    
    @NotNull
    public static final /* synthetic */ Set access$getMUTABLE_METHOD_SIGNATURES$cp() {
        return JvmBuiltInsSettings.MUTABLE_METHOD_SIGNATURES;
    }
    
    @NotNull
    public static final /* synthetic */ Set access$getBLACK_LIST_CONSTRUCTOR_SIGNATURES$cp() {
        return JvmBuiltInsSettings.BLACK_LIST_CONSTRUCTOR_SIGNATURES;
    }
    
    @NotNull
    public static final /* synthetic */ Set access$getWHITE_LIST_CONSTRUCTOR_SIGNATURES$cp() {
        return JvmBuiltInsSettings.WHITE_LIST_CONSTRUCTOR_SIGNATURES;
    }
    
    private enum JDKMemberStatus
    {
        BLACK_LIST, 
        WHITE_LIST, 
        NOT_CONSIDERED, 
        DROP;
    }
    
    public static final class Companion
    {
        public final boolean isSerializableInJava(@NotNull final FqNameUnsafe fqName) {
            Intrinsics.checkParameterIsNotNull((Object)fqName, "fqName");
            if (this.isArrayOrPrimitiveArray(fqName)) {
                return true;
            }
            final ClassId mapKotlinToJava = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqName);
            if (mapKotlinToJava != null) {
                final ClassId javaClassId = mapKotlinToJava;
                Class<?> forName;
                try {
                    forName = Class.forName(javaClassId.asSingleFqName().asString());
                }
                catch (final ClassNotFoundException e) {
                    return false;
                }
                final Class classViaReflection = forName;
                return Serializable.class.isAssignableFrom(classViaReflection);
            }
            return false;
        }
        
        private final boolean isArrayOrPrimitiveArray(final FqNameUnsafe fqName) {
            return Intrinsics.areEqual((Object)fqName, (Object)KotlinBuiltIns.FQ_NAMES.array) || KotlinBuiltIns.isPrimitiveArray(fqName);
        }
        
        @NotNull
        public final Set<String> getDROP_LIST_METHOD_SIGNATURES() {
            return JvmBuiltInsSettings.access$getDROP_LIST_METHOD_SIGNATURES$cp();
        }
        
        @NotNull
        public final Set<String> getBLACK_LIST_METHOD_SIGNATURES() {
            return JvmBuiltInsSettings.access$getBLACK_LIST_METHOD_SIGNATURES$cp();
        }
        
        private final Set<String> buildPrimitiveValueMethodsSet() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getstatic       kotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents.INSTANCE:Lkotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents;
            //     4: astore_1       
            //     5: aload_1        
            //     6: checkcast       Lkotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents;
            //     9: astore_2        /* $receiver */
            //    10: iconst_2       
            //    11: anewarray       Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    14: dup            
            //    15: iconst_0       
            //    16: getstatic       kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.BOOLEAN:Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    19: aastore        
            //    20: dup            
            //    21: iconst_1       
            //    22: getstatic       kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.CHAR:Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    25: aastore        
            //    26: invokestatic    kotlin/collections/CollectionsKt.listOf:([Ljava/lang/Object;)Ljava/util/List;
            //    29: checkcast       Ljava/lang/Iterable;
            //    32: astore_3       
            //    33: new             Ljava/util/LinkedHashSet;
            //    36: dup            
            //    37: invokespecial   java/util/LinkedHashSet.<init>:()V
            //    40: checkcast       Ljava/util/Collection;
            //    43: astore          destination$iv
            //    45: aload_3         /* $receiver$iv */
            //    46: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
            //    51: astore          5
            //    53: aload           5
            //    55: invokeinterface java/util/Iterator.hasNext:()Z
            //    60: ifeq            154
            //    63: aload           5
            //    65: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
            //    70: astore          element$iv
            //    72: aload           element$iv
            //    74: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    77: astore          it
            //    79: aload_2         /* $receiver */
            //    80: aload           it
            //    82: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.getWrapperFqName:()Lkotlin/reflect/jvm/internal/impl/name/FqName;
            //    85: invokevirtual   kotlin/reflect/jvm/internal/impl/name/FqName.shortName:()Lkotlin/reflect/jvm/internal/impl/name/Name;
            //    88: invokevirtual   kotlin/reflect/jvm/internal/impl/name/Name.asString:()Ljava/lang/String;
            //    91: dup            
            //    92: ldc             "it.wrapperFqName.shortName().asString()"
            //    94: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
            //    97: iconst_1       
            //    98: anewarray       Ljava/lang/String;
            //   101: dup            
            //   102: iconst_0       
            //   103: new             Ljava/lang/StringBuilder;
            //   106: dup            
            //   107: invokespecial   java/lang/StringBuilder.<init>:()V
            //   110: aload           it
            //   112: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.getJavaKeywordName:()Ljava/lang/String;
            //   115: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   118: ldc             "Value()"
            //   120: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   123: aload           it
            //   125: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.getDesc:()Ljava/lang/String;
            //   128: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   131: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   134: aastore        
            //   135: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents.inJavaLang:(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/LinkedHashSet;
            //   138: checkcast       Ljava/lang/Iterable;
            //   141: astore          list$iv
            //   143: aload           destination$iv
            //   145: aload           list$iv
            //   147: invokestatic    kotlin/collections/CollectionsKt.addAll:(Ljava/util/Collection;Ljava/lang/Iterable;)Z
            //   150: pop            
            //   151: goto            53
            //   154: aload           destination$iv
            //   156: checkcast       Ljava/util/LinkedHashSet;
            //   159: checkcast       Ljava/util/Set;
            //   162: areturn        
            //    Signature:
            //  ()Ljava/util/Set<Ljava/lang/String;>;
            //    StackMapTable: 00 02 FF 00 35 00 06 07 00 02 07 00 63 07 00 63 07 00 77 07 00 7F 07 00 85 00 00 FB 00 64
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:662)
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
        
        @NotNull
        public final Set<String> getWHITE_LIST_METHOD_SIGNATURES() {
            return JvmBuiltInsSettings.access$getWHITE_LIST_METHOD_SIGNATURES$cp();
        }
        
        @NotNull
        public final Set<String> getMUTABLE_METHOD_SIGNATURES() {
            return JvmBuiltInsSettings.access$getMUTABLE_METHOD_SIGNATURES$cp();
        }
        
        @NotNull
        public final Set<String> getBLACK_LIST_CONSTRUCTOR_SIGNATURES() {
            return JvmBuiltInsSettings.access$getBLACK_LIST_CONSTRUCTOR_SIGNATURES$cp();
        }
        
        @NotNull
        public final Set<String> getWHITE_LIST_CONSTRUCTOR_SIGNATURES() {
            return JvmBuiltInsSettings.access$getWHITE_LIST_CONSTRUCTOR_SIGNATURES$cp();
        }
        
        private final Set<String> buildPrimitiveStringConstructorsSet() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getstatic       kotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents.INSTANCE:Lkotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents;
            //     4: astore_1       
            //     5: aload_1        
            //     6: checkcast       Lkotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents;
            //     9: astore_2        /* $receiver */
            //    10: bipush          8
            //    12: anewarray       Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    15: dup            
            //    16: iconst_0       
            //    17: getstatic       kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.BOOLEAN:Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    20: aastore        
            //    21: dup            
            //    22: iconst_1       
            //    23: getstatic       kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.BYTE:Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    26: aastore        
            //    27: dup            
            //    28: iconst_2       
            //    29: getstatic       kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.DOUBLE:Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    32: aastore        
            //    33: dup            
            //    34: iconst_3       
            //    35: getstatic       kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.FLOAT:Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    38: aastore        
            //    39: dup            
            //    40: iconst_4       
            //    41: getstatic       kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.BYTE:Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    44: aastore        
            //    45: dup            
            //    46: iconst_5       
            //    47: getstatic       kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.INT:Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    50: aastore        
            //    51: dup            
            //    52: bipush          6
            //    54: getstatic       kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.LONG:Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    57: aastore        
            //    58: dup            
            //    59: bipush          7
            //    61: getstatic       kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.SHORT:Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //    64: aastore        
            //    65: invokestatic    kotlin/collections/CollectionsKt.listOf:([Ljava/lang/Object;)Ljava/util/List;
            //    68: checkcast       Ljava/lang/Iterable;
            //    71: astore_3       
            //    72: new             Ljava/util/LinkedHashSet;
            //    75: dup            
            //    76: invokespecial   java/util/LinkedHashSet.<init>:()V
            //    79: checkcast       Ljava/util/Collection;
            //    82: astore          4
            //    84: nop            
            //    85: aload_3         /* $receiver$iv */
            //    86: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
            //    91: astore          5
            //    93: aload           5
            //    95: invokeinterface java/util/Iterator.hasNext:()Z
            //   100: ifeq            177
            //   103: aload           5
            //   105: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
            //   110: astore          element$iv
            //   112: aload           element$iv
            //   114: checkcast       Lkotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType;
            //   117: astore          it
            //   119: aload_2         /* $receiver */
            //   120: aload           it
            //   122: invokevirtual   kotlin/reflect/jvm/internal/impl/resolve/jvm/JvmPrimitiveType.getWrapperFqName:()Lkotlin/reflect/jvm/internal/impl/name/FqName;
            //   125: invokevirtual   kotlin/reflect/jvm/internal/impl/name/FqName.shortName:()Lkotlin/reflect/jvm/internal/impl/name/Name;
            //   128: invokevirtual   kotlin/reflect/jvm/internal/impl/name/Name.asString:()Ljava/lang/String;
            //   131: dup            
            //   132: ldc             "it.wrapperFqName.shortName().asString()"
            //   134: invokestatic    kotlin/jvm/internal/Intrinsics.checkExpressionValueIsNotNull:(Ljava/lang/Object;Ljava/lang/String;)V
            //   137: aload_2         /* $receiver */
            //   138: iconst_1       
            //   139: anewarray       Ljava/lang/String;
            //   142: dup            
            //   143: iconst_0       
            //   144: ldc             "Ljava/lang/String;"
            //   146: aastore        
            //   147: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents.constructors:([Ljava/lang/String;)[Ljava/lang/String;
            //   150: dup            
            //   151: arraylength    
            //   152: invokestatic    java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
            //   155: checkcast       [Ljava/lang/String;
            //   158: invokevirtual   kotlin/reflect/jvm/internal/impl/load/kotlin/SignatureBuildingComponents.inJavaLang:(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/LinkedHashSet;
            //   161: checkcast       Ljava/lang/Iterable;
            //   164: astore          list$iv
            //   166: aload           destination$iv
            //   168: aload           list$iv
            //   170: invokestatic    kotlin/collections/CollectionsKt.addAll:(Ljava/util/Collection;Ljava/lang/Iterable;)Z
            //   173: pop            
            //   174: goto            93
            //   177: aload           destination$iv
            //   179: checkcast       Ljava/util/LinkedHashSet;
            //   182: checkcast       Ljava/util/Set;
            //   185: areturn        
            //    Signature:
            //  ()Ljava/util/Set<Ljava/lang/String;>;
            //    StackMapTable: 00 02 FF 00 5D 00 06 07 00 02 07 00 63 07 00 63 07 00 77 07 00 7F 07 00 85 00 00 FB 00 53
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:662)
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
        
        private Companion() {
        }
    }
}
