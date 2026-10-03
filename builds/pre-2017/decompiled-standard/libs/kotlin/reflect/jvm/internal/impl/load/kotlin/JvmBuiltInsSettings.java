/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.CloneableClassScope;
import kotlin.reflect.jvm.internal.impl.builtins.JvmBuiltInClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope;
import kotlin.reflect.jvm.internal.impl.load.kotlin.FallbackBuiltIns;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettings$WhenMappings;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmBuiltInsSettingsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.load.kotlin.UnsafeVarianceTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.platform.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilterKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class JvmBuiltInsSettings
implements AdditionalClassPartsProvider,
PlatformDependentDeclarationFilter {
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
        Lazy lazy = this.ownerModuleDescriptor$delegate;
        JvmBuiltInsSettings jvmBuiltInsSettings = this;
        KProperty kProperty = $$delegatedProperties[0];
        return (ModuleDescriptor)lazy.getValue();
    }

    private final boolean isAdditionalBuiltInsFeatureSupported() {
        Lazy lazy = this.isAdditionalBuiltInsFeatureSupported$delegate;
        JvmBuiltInsSettings jvmBuiltInsSettings = this;
        KProperty kProperty = $$delegatedProperties[1];
        return (Boolean)lazy.getValue();
    }

    private final SimpleType getCloneableType() {
        return (SimpleType)StorageKt.getValue(this.cloneableType$delegate, (Object)this, $$delegatedProperties[2]);
    }

    private final AnnotationsImpl getNotConsideredDeprecation() {
        return (AnnotationsImpl)StorageKt.getValue(this.notConsideredDeprecation$delegate, (Object)this, $$delegatedProperties[3]);
    }

    private final KotlinType createMockJavaIoSerializableType(@NotNull StorageManager $receiver) {
        PackageFragmentDescriptorImpl mockJavaIoPackageFragment2 = new PackageFragmentDescriptorImpl(this, this.moduleDescriptor, new FqName("java.io")){
            final /* synthetic */ JvmBuiltInsSettings this$0;

            @NotNull
            public MemberScope.Empty getMemberScope() {
                return MemberScope.Empty.INSTANCE;
            }
            {
                this.this$0 = $outer;
                super($super_call_param$1, $super_call_param$2);
            }
        };
        List<LazyWrappedType> superTypes2 = CollectionsKt.listOf(new LazyWrappedType($receiver, (Function0<? extends KotlinType>)new Function0<SimpleType>(this){
            final /* synthetic */ JvmBuiltInsSettings this$0;

            @NotNull
            public final SimpleType invoke() {
                SimpleType simpleType2 = JvmBuiltInsSettings.access$getModuleDescriptor$p(this.this$0).getBuiltIns().getAnyType();
                Intrinsics.checkExpressionValueIsNotNull(simpleType2, "moduleDescriptor.builtIns.anyType");
                return simpleType2;
            }
            {
                this.this$0 = jvmBuiltInsSettings;
                super(0);
            }
        }));
        ClassDescriptorImpl mockSerializableClass = new ClassDescriptorImpl(mockJavaIoPackageFragment2, Name.identifier("Serializable"), Modality.ABSTRACT, ClassKind.INTERFACE, (Collection<KotlinType>)superTypes2, SourceElement.NO_SOURCE, false);
        mockSerializableClass.initialize(MemberScope.Empty.INSTANCE, SetsKt.<ClassConstructorDescriptor>emptySet(), null);
        SimpleType simpleType2 = mockSerializableClass.getDefaultType();
        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "mockSerializableClass.defaultType");
        return simpleType2;
    }

    @Override
    @NotNull
    public Collection<KotlinType> getSupertypes(@NotNull DeserializedClassDescriptor classDescriptor) {
        Collection collection;
        Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
        FqNameUnsafe fqName2 = DescriptorUtilsKt.getFqNameUnsafe(classDescriptor);
        if (JvmBuiltInsSettings.Companion.isArrayOrPrimitiveArray(fqName2)) {
            KotlinType[] kotlinTypeArray = new KotlinType[2];
            SimpleType simpleType2 = this.getCloneableType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "cloneableType");
            kotlinTypeArray[0] = simpleType2;
            kotlinTypeArray[1] = this.mockSerializableType;
            collection = CollectionsKt.listOf(kotlinTypeArray);
        } else {
            collection = Companion.isSerializableInJava(fqName2) ? (Collection)CollectionsKt.listOf(this.mockSerializableType) : (Collection)CollectionsKt.emptyList();
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getFunctions(@NotNull Name name2, @NotNull DeserializedClassDescriptor classDescriptor) {
        void $receiver$iv$iv;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
        if (Intrinsics.areEqual(name2, CloneableClassScope.Companion.getCLONE_NAME$kotlin_core()) && KotlinBuiltIns.isArrayOrPrimitiveArray(classDescriptor)) {
            boolean bl;
            block17: {
                Iterable $receiver$iv = classDescriptor.getClassProto().getFunctionList();
                for (Object element$iv : $receiver$iv) {
                    ProtoBuf.Function functionProto = (ProtoBuf.Function)element$iv;
                    if (!Intrinsics.areEqual(classDescriptor.getC().getNameResolver().getName(functionProto.getName()), CloneableClassScope.Companion.getCLONE_NAME$kotlin_core())) continue;
                    bl = true;
                    break block17;
                }
                bl = false;
            }
            if (bl) {
                return CollectionsKt.emptyList();
            }
            return CollectionsKt.listOf(this.createCloneForArray(classDescriptor, (SimpleFunctionDescriptor)CollectionsKt.single((Iterable)this.getCloneableType().getMemberScope().getContributedFunctions(name2, NoLookupLocation.FROM_BUILTINS))));
        }
        if (!this.isAdditionalBuiltInsFeatureSupported()) {
            return CollectionsKt.emptyList();
        }
        Iterable $receiver$iv = this.getAdditionalFunctions(classDescriptor, (Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>>)new Function1<MemberScope, Collection<? extends SimpleFunctionDescriptor>>(name2){
            final /* synthetic */ Name $name;

            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull MemberScope it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.getContributedFunctions(this.$name, NoLookupLocation.FROM_BUILTINS);
            }
            {
                this.$name = name2;
                super(1);
            }
        });
        Iterable iterable = $receiver$iv;
        Collection destination$iv$iv = new ArrayList();
        void $receiver$iv$iv$iv = $receiver$iv$iv;
        Iterator iterator2 = $receiver$iv$iv$iv.iterator();
        while (true) {
            SimpleFunctionDescriptor simpleFunctionDescriptor;
            SimpleFunctionDescriptor simpleFunctionDescriptor2;
            block18: {
                FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> copyBuilder;
                Object element$iv$iv$iv;
                if (!iterator2.hasNext()) {
                    return (List)destination$iv$iv;
                }
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                SimpleFunctionDescriptor additionalMember = (SimpleFunctionDescriptor)element$iv$iv;
                DeclarationDescriptor declarationDescriptor = additionalMember.getContainingDeclaration();
                if (declarationDescriptor == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                }
                FunctionDescriptor functionDescriptor = additionalMember.substitute(MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor)declarationDescriptor, classDescriptor).buildSubstitutor());
                if (functionDescriptor == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
                }
                SimpleFunctionDescriptor substitutedWithKotlinTypeParameters = (SimpleFunctionDescriptor)functionDescriptor;
                FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> $receiver = copyBuilder = substitutedWithKotlinTypeParameters.newCopyBuilder();
                $receiver.setOwner(classDescriptor);
                $receiver.setDispatchReceiverParameter(classDescriptor.getThisAsReceiverParameter());
                $receiver.setPreserveSourceElement();
                $receiver.setSubstitution(new UnsafeVarianceTypeSubstitution(this.moduleDescriptor.getBuiltIns()));
                JDKMemberStatus memberStatus = this.getJdkMethodStatus(additionalMember);
                switch (JvmBuiltInsSettings$WhenMappings.$EnumSwitchMapping$0[memberStatus.ordinal()]) {
                    case 1: {
                        if (ModalityKt.isFinalClass(classDescriptor)) {
                            simpleFunctionDescriptor2 = null;
                            break block18;
                        } else {
                            Intrinsics.checkExpressionValueIsNotNull($receiver.setHiddenForResolutionEverywhereBesideSupercalls(), "setHiddenForResolutionEverywhereBesideSupercalls()");
                            break;
                        }
                    }
                    case 2: {
                        Intrinsics.checkExpressionValueIsNotNull($receiver.setAdditionalAnnotations(this.getNotConsideredDeprecation()), "setAdditionalAnnotations(notConsideredDeprecation)");
                        break;
                    }
                    case 3: {
                        simpleFunctionDescriptor2 = null;
                        break block18;
                    }
                    case 4: {
                    }
                }
                SimpleFunctionDescriptor simpleFunctionDescriptor3 = copyBuilder.build();
                if (simpleFunctionDescriptor3 == null) {
                    Intrinsics.throwNpe();
                }
                simpleFunctionDescriptor2 = simpleFunctionDescriptor3;
            }
            if (simpleFunctionDescriptor2 == null) continue;
            SimpleFunctionDescriptor it$iv$iv = simpleFunctionDescriptor = simpleFunctionDescriptor2;
            destination$iv$iv.add(it$iv$iv);
        }
    }

    @NotNull
    public Set<Name> getFunctionsNames(@NotNull DeserializedClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
        if (!this.isAdditionalBuiltInsFeatureSupported()) {
            return SetsKt.emptySet();
        }
        Object object = this.getJavaAnalogue(classDescriptor);
        if (object == null || (object = ((LazyJavaClassDescriptor)object).getUnsubstitutedMemberScope()) == null || (object = ((LazyJavaScope)object).getFunctionNames()) == null) {
            object = SetsKt.emptySet();
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    private final Collection<SimpleFunctionDescriptor> getAdditionalFunctions(DeserializedClassDescriptor classDescriptor, Function1<? super MemberScope, ? extends Collection<? extends SimpleFunctionDescriptor>> functionsByScope) {
        void $receiver$iv$iv;
        void $receiver$iv;
        MemberScope scope;
        Collection<FqName> collection;
        Object item$iv$iv2;
        void $receiver$iv$iv2;
        void $receiver$iv2;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.getJavaAnalogue(classDescriptor);
        if (lazyJavaClassDescriptor == null) {
            return CollectionsKt.emptyList();
        }
        LazyJavaClassDescriptor javaAnalogueDescriptor = lazyJavaClassDescriptor;
        Collection<ClassDescriptor> kotlinClassDescriptors = this.j2kClassMap.mapPlatformClass(DescriptorUtilsKt.getFqNameSafe(javaAnalogueDescriptor), FallbackBuiltIns.Companion.getInstance());
        ClassDescriptor classDescriptor2 = (ClassDescriptor)CollectionsKt.lastOrNull((Iterable)kotlinClassDescriptors);
        if (classDescriptor2 == null) {
            return CollectionsKt.emptyList();
        }
        ClassDescriptor kotlinMutableClassIfContainer = classDescriptor2;
        Iterable iterable = kotlinClassDescriptors;
        SmartSet.Companion companion = SmartSet.Companion;
        void var8_9 = $receiver$iv2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
        for (Object item$iv$iv2 : $receiver$iv$iv2) {
            void it;
            ClassDescriptor classDescriptor3 = (ClassDescriptor)item$iv$iv2;
            collection = destination$iv$iv;
            FqName fqName2 = DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)it);
            collection.add(fqName2);
        }
        collection = (List)destination$iv$iv;
        SmartSet kotlinVersions = companion.create((Collection)collection);
        boolean isMutable = this.j2kClassMap.isMutable(classDescriptor);
        ClassDescriptor fakeJavaClassDescriptor2 = this.javaAnalogueClassesWithCustomSupertypeCache.computeIfAbsent(DescriptorUtilsKt.getFqNameSafe(javaAnalogueDescriptor), (Function0<ClassDescriptor>)new Function0<LazyJavaClassDescriptor>(javaAnalogueDescriptor, kotlinMutableClassIfContainer){
            final /* synthetic */ LazyJavaClassDescriptor $javaAnalogueDescriptor;
            final /* synthetic */ ClassDescriptor $kotlinMutableClassIfContainer;

            @NotNull
            public final LazyJavaClassDescriptor invoke() {
                JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
                Intrinsics.checkExpressionValueIsNotNull(javaResolverCache, "JavaResolverCache.EMPTY");
                return this.$javaAnalogueDescriptor.copy$kotlin_core(javaResolverCache, this.$kotlinMutableClassIfContainer);
            }
            {
                this.$javaAnalogueDescriptor = lazyJavaClassDescriptor;
                this.$kotlinMutableClassIfContainer = classDescriptor;
                super(0);
            }
        });
        MemberScope memberScope2 = scope = fakeJavaClassDescriptor2.getUnsubstitutedMemberScope();
        Intrinsics.checkExpressionValueIsNotNull(memberScope2, "scope");
        Iterable iterable2 = functionsByScope.invoke(memberScope2);
        item$iv$iv2 = $receiver$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            boolean bl;
            SimpleFunctionDescriptor analogueMember = (SimpleFunctionDescriptor)element$iv$iv;
            if (Intrinsics.areEqual((Object)analogueMember.getKind(), (Object)CallableMemberDescriptor.Kind.DECLARATION) ^ true) {
                bl = false;
            } else if (!analogueMember.getVisibility().isPublicAPI()) {
                bl = false;
            } else if (KotlinBuiltIns.isDeprecated(analogueMember)) {
                bl = false;
            } else {
                boolean bl2;
                block11: {
                    Iterable $receiver$iv3 = analogueMember.getOverriddenDescriptors();
                    for (Object element$iv : $receiver$iv3) {
                        FunctionDescriptor it = (FunctionDescriptor)element$iv;
                        if (!kotlinVersions.contains(DescriptorUtilsKt.getFqNameSafe(it.getContainingDeclaration()))) continue;
                        bl2 = true;
                        break block11;
                    }
                    bl2 = false;
                }
                bl = bl2 ? false : !this.isMutabilityViolation(analogueMember, isMutable);
            }
            if (!bl) continue;
            destination$iv$iv2.add(element$iv$iv);
        }
        return (List)destination$iv$iv2;
    }

    private final SimpleFunctionDescriptor createCloneForArray(DeserializedClassDescriptor arrayClassDescriptor, SimpleFunctionDescriptor cloneFromCloneable) {
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> copyBuilder;
        FunctionDescriptor.CopyBuilder<? extends SimpleFunctionDescriptor> $receiver = copyBuilder = cloneFromCloneable.newCopyBuilder();
        $receiver.setOwner(arrayClassDescriptor);
        $receiver.setVisibility(Visibilities.PUBLIC);
        $receiver.setReturnType(arrayClassDescriptor.getDefaultType());
        $receiver.setDispatchReceiverParameter(arrayClassDescriptor.getThisAsReceiverParameter());
        SimpleFunctionDescriptor simpleFunctionDescriptor = copyBuilder.build();
        if (simpleFunctionDescriptor == null) {
            Intrinsics.throwNpe();
        }
        return simpleFunctionDescriptor;
    }

    private final boolean isMutabilityViolation(@NotNull SimpleFunctionDescriptor $receiver, boolean isMutable) {
        DeclarationDescriptor declarationDescriptor = $receiver.getContainingDeclaration();
        if (declarationDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        ClassDescriptor owner = (ClassDescriptor)declarationDescriptor;
        String jvmDescriptor2 = MethodSignatureMappingKt.computeJvmDescriptor$default($receiver, false, 1, null);
        Set<String> set = Companion.getMUTABLE_METHOD_SIGNATURES();
        String string = jvmDescriptor2;
        Intrinsics.checkExpressionValueIsNotNull(string, "jvmDescriptor");
        if (set.contains(SignatureBuildingComponents.INSTANCE.signature(owner, string)) ^ isMutable) {
            return true;
        }
        Boolean bl = DFS.ifAny((Collection)CollectionsKt.listOf($receiver), isMutabilityViolation.1.INSTANCE, (Function1)new Function1<CallableMemberDescriptor, Boolean>(this){
            final /* synthetic */ JvmBuiltInsSettings this$0;

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final boolean invoke(CallableMemberDescriptor overridden) {
                if (!Intrinsics.areEqual((Object)((Object)overridden.getKind()), (Object)((Object)CallableMemberDescriptor.Kind.DECLARATION))) return false;
                DeclarationDescriptor declarationDescriptor = overridden.getContainingDeclaration();
                if (declarationDescriptor == null) {
                    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                }
                if (!JvmBuiltInsSettings.access$getJ2kClassMap$p(this.this$0).isMutable((ClassDescriptor)declarationDescriptor)) return false;
                return true;
            }
            {
                this.this$0 = jvmBuiltInsSettings;
                super(1);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(bl, "DFS.ifAny<CallableMember\u2026lassDescriptor)\n        }");
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    private final JDKMemberStatus getJdkMethodStatus(@NotNull FunctionDescriptor $receiver) {
        void result2;
        DeclarationDescriptor declarationDescriptor = $receiver.getContainingDeclaration();
        if (declarationDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        ClassDescriptor owner = (ClassDescriptor)declarationDescriptor;
        String jvmDescriptor2 = MethodSignatureMappingKt.computeJvmDescriptor$default($receiver, false, 1, null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        Object r = DFS.dfs((Collection)CollectionsKt.listOf(owner), new DFS.Neighbors<N>(this){
            final /* synthetic */ JvmBuiltInsSettings this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<LazyJavaClassDescriptor> getNeighbors(ClassDescriptor it) {
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)it.getTypeConstructor().getSupertypes();
                Collection destination$iv$iv = new ArrayList<E>();
                void $receiver$iv$iv$iv = $receiver$iv$iv;
                Iterator<T> iterator2 = $receiver$iv$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    LazyJavaClassDescriptor lazyJavaClassDescriptor;
                    T element$iv$iv$iv;
                    T element$iv$iv = element$iv$iv$iv = iterator2.next();
                    KotlinType it2 = (KotlinType)element$iv$iv;
                    ClassifierDescriptor classifierDescriptor = it2.getConstructor().getDeclarationDescriptor();
                    ClassifierDescriptor classifierDescriptor2 = classifierDescriptor != null ? classifierDescriptor.getOriginal() : null;
                    if (!(classifierDescriptor2 instanceof ClassDescriptor)) {
                        classifierDescriptor2 = null;
                    }
                    ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor2;
                    LazyJavaClassDescriptor lazyJavaClassDescriptor2 = classDescriptor != null ? JvmBuiltInsSettings.access$getJavaAnalogue(this.this$0, classDescriptor) : null;
                    if (lazyJavaClassDescriptor2 == null) continue;
                    LazyJavaClassDescriptor it$iv$iv = lazyJavaClassDescriptor = lazyJavaClassDescriptor2;
                    destination$iv$iv.add(it$iv$iv);
                }
                return (List)destination$iv$iv;
            }
            {
                this.this$0 = jvmBuiltInsSettings;
            }
        }, new DFS.AbstractNodeHandler<ClassDescriptor, JDKMemberStatus>(jvmDescriptor2, (Ref.ObjectRef)result2){
            final /* synthetic */ String $jvmDescriptor;
            final /* synthetic */ Ref.ObjectRef $result;

            public boolean beforeChildren(@NotNull ClassDescriptor javaClassDescriptor) {
                String signature2;
                Intrinsics.checkParameterIsNotNull(javaClassDescriptor, "javaClassDescriptor");
                String string = this.$jvmDescriptor;
                Intrinsics.checkExpressionValueIsNotNull(string, "jvmDescriptor");
                String string2 = signature2 = SignatureBuildingComponents.INSTANCE.signature(javaClassDescriptor, string);
                if (JvmBuiltInsSettings.Companion.getBLACK_LIST_METHOD_SIGNATURES().contains(string2)) {
                    this.$result.element = JDKMemberStatus.BLACK_LIST;
                } else if (JvmBuiltInsSettings.Companion.getWHITE_LIST_METHOD_SIGNATURES().contains(string2)) {
                    this.$result.element = JDKMemberStatus.WHITE_LIST;
                } else if (JvmBuiltInsSettings.Companion.getDROP_LIST_METHOD_SIGNATURES().contains(string2)) {
                    this.$result.element = JDKMemberStatus.DROP;
                }
                return (JDKMemberStatus)((Object)this.$result.element) == null;
            }

            @NotNull
            public JDKMemberStatus result() {
                JDKMemberStatus jDKMemberStatus = (JDKMemberStatus)((Object)this.$result.element);
                if (jDKMemberStatus == null) {
                    jDKMemberStatus = JDKMemberStatus.NOT_CONSIDERED;
                }
                return jDKMemberStatus;
            }
            {
                this.$jvmDescriptor = $captured_local_variable$0;
                this.$result = $captured_local_variable$1;
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(r, "DFS.dfs<ClassDescriptor,\u2026IDERED\n                })");
        return (JDKMemberStatus)((Object)r);
    }

    private final LazyJavaClassDescriptor getJavaAnalogue(@NotNull ClassDescriptor $receiver) {
        if (JvmBuiltInsSettingsKt.access$isAny$p($receiver)) {
            return null;
        }
        Object object = AddToStdlibKt.check(DescriptorUtilsKt.getFqNameUnsafe($receiver), getJavaAnalogue.fqName.1.INSTANCE);
        if (object == null || (object = ((FqNameUnsafe)object).toSafe()) == null) {
            return null;
        }
        Object fqName2 = object;
        Object object2 = this.j2kClassMap.mapKotlinToJava(((FqName)fqName2).toUnsafe());
        if (object2 == null || (object2 = ((ClassId)object2).asSingleFqName()) == null) {
            return null;
        }
        Object javaAnalogueFqName = object2;
        ModuleDescriptor moduleDescriptor = this.getOwnerModuleDescriptor();
        Object object3 = javaAnalogueFqName;
        Intrinsics.checkExpressionValueIsNotNull(object3, "javaAnalogueFqName");
        ClassDescriptor classDescriptor = DescriptorUtilKt.resolveClassByFqName(moduleDescriptor, (FqName)object3, NoLookupLocation.FROM_BUILTINS);
        if (!(classDescriptor instanceof LazyJavaClassDescriptor)) {
            classDescriptor = null;
        }
        return (LazyJavaClassDescriptor)classDescriptor;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors(@NotNull DeserializedClassDescriptor classDescriptor) {
        Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
        if (Intrinsics.areEqual((Object)classDescriptor.getKind(), (Object)ClassKind.CLASS) ^ true || !this.isAdditionalBuiltInsFeatureSupported()) {
            return CollectionsKt.emptyList();
        }
        v0 = this.getJavaAnalogue(classDescriptor);
        if (v0 == null) {
            return CollectionsKt.emptyList();
        }
        javaAnalogueDescriptor = v0;
        v1 = this.j2kClassMap.mapJavaToKotlin(DescriptorUtilsKt.getFqNameSafe(javaAnalogueDescriptor), FallbackBuiltIns.Companion.getInstance());
        if (v1 == null) {
            return CollectionsKt.emptyList();
        }
        v2 = defaultKotlinVersion = v1;
        Intrinsics.checkExpressionValueIsNotNull(v2, "defaultKotlinVersion");
        substitutor = MappingUtilKt.createMappedTypeParametersSubstitution(v2, javaAnalogueDescriptor).buildSubstitutor();
        isEffectivelyTheSameAs$ = new Function2<ConstructorDescriptor, ConstructorDescriptor, Boolean>(substitutor){
            final /* synthetic */ TypeSubstitutor $substitutor;

            public final boolean invoke(@NotNull ConstructorDescriptor $receiver, @NotNull ConstructorDescriptor javaConstructor) {
                Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
                Intrinsics.checkParameterIsNotNull(javaConstructor, "javaConstructor");
                return Intrinsics.areEqual((Object)((Object)OverridingUtil.getBothWaysOverridability($receiver, javaConstructor.substitute(this.$substitutor))), (Object)((Object)OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE));
            }
            {
                this.$substitutor = typeSubstitutor2;
                super(2);
            }
        };
        var7_7 = $receiver$iv = (Iterable)javaAnalogueDescriptor.getConstructors();
        destination$iv$iv = new ArrayList<E>();
        for (T element$iv$iv : $receiver$iv$iv) {
            block10: {
                javaConstructor = (ClassConstructorDescriptor)element$iv$iv;
                if (!javaConstructor.getVisibility().isPublicAPI()) ** GOTO lbl-1000
                $receiver$iv = defaultKotlinVersion.getConstructors();
                for (T element$iv : $receiver$iv) {
                    it = (ClassConstructorDescriptor)element$iv;
                    v3 = it;
                    v4 = javaConstructor;
                    Intrinsics.checkExpressionValueIsNotNull(v4, "javaConstructor");
                    if (!isEffectivelyTheSameAs$.invoke(v3, (ConstructorDescriptor)v4)) continue;
                    v5 = false;
                    break block10;
                }
                v5 = true;
            }
            if (!v5 || this.isTrivialCopyConstructorFor(javaConstructor, classDescriptor) || KotlinBuiltIns.isDeprecated(javaConstructor)) ** GOTO lbl-1000
            v6 = JvmBuiltInsSettings.Companion.getBLACK_LIST_CONSTRUCTOR_SIGNATURES();
            v7 = javaAnalogueDescriptor;
            v8 = MethodSignatureMappingKt.computeJvmDescriptor$default(javaConstructor, false, 1, null);
            Intrinsics.checkExpressionValueIsNotNull(v8, "javaConstructor.computeJvmDescriptor()");
            if (v6.contains(SignatureBuildingComponents.INSTANCE.signature(v7, v8)) ^ true) {
                v9 = true;
            } else lbl-1000:
            // 3 sources

            {
                v9 = false;
            }
            if (!v9) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (T item$iv$iv : $receiver$iv$iv) {
            javaConstructor = (ClassConstructorDescriptor)item$iv$iv;
            var16_16 = destination$iv$iv;
            $receiver = var12_12 = javaConstructor.newCopyBuilder();
            $receiver.setOwner(classDescriptor);
            $receiver.setReturnType(classDescriptor.getDefaultType());
            $receiver.setPreserveSourceElement();
            $receiver.setSubstitution(substitutor.getSubstitution());
            v10 = JvmBuiltInsSettings.Companion.getWHITE_LIST_CONSTRUCTOR_SIGNATURES();
            v11 = javaAnalogueDescriptor;
            v12 = MethodSignatureMappingKt.computeJvmDescriptor$default(javaConstructor, false, 1, null);
            Intrinsics.checkExpressionValueIsNotNull(v12, "javaConstructor.computeJvmDescriptor()");
            if (v10.contains(SignatureBuildingComponents.INSTANCE.signature(v11, v12)) ^ true) {
                $receiver.setAdditionalAnnotations(this.getNotConsideredDeprecation());
            }
            v13 = var12_12.build();
            if (v13 == null) {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
            }
            var17_17 = (ClassConstructorDescriptor)v13;
            var16_16.add(var17_17);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean isFunctionAvailable(@NotNull DeserializedClassDescriptor classDescriptor, @NotNull SimpleFunctionDescriptor functionDescriptor) {
        boolean bl;
        block4: {
            void $receiver$iv;
            Intrinsics.checkParameterIsNotNull(classDescriptor, "classDescriptor");
            Intrinsics.checkParameterIsNotNull(functionDescriptor, "functionDescriptor");
            if (!functionDescriptor.getAnnotations().hasAnnotation(PlatformDependentDeclarationFilterKt.getPLATFORM_DEPENDENT_ANNOTATION_FQ_NAME())) {
                return true;
            }
            if (!this.isAdditionalBuiltInsFeatureSupported()) {
                return false;
            }
            LazyJavaClassDescriptor lazyJavaClassDescriptor = this.getJavaAnalogue(classDescriptor);
            if (lazyJavaClassDescriptor == null) {
                return true;
            }
            LazyJavaClassDescriptor javaAnalogueClassDescriptor = lazyJavaClassDescriptor;
            String jvmDescriptor2 = MethodSignatureMappingKt.computeJvmDescriptor$default(functionDescriptor, false, 1, null);
            LazyJavaClassMemberScope lazyJavaClassMemberScope = javaAnalogueClassDescriptor.getUnsubstitutedMemberScope();
            Name name2 = functionDescriptor.getName();
            Intrinsics.checkExpressionValueIsNotNull(name2, "functionDescriptor.name");
            Iterable iterable = lazyJavaClassMemberScope.getContributedFunctions(name2, NoLookupLocation.FROM_BUILTINS);
            for (Object element$iv : $receiver$iv) {
                SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv;
                if (!Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmDescriptor$default(it, false, 1, null), jvmDescriptor2)) continue;
                bl = true;
                break block4;
            }
            bl = false;
        }
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isTrivialCopyConstructorFor(@NotNull ConstructorDescriptor $receiver, DeserializedClassDescriptor classDescriptor) {
        if ($receiver.getValueParameters().size() != 1) return false;
        ClassifierDescriptor classifierDescriptor = CollectionsKt.single($receiver.getValueParameters()).getType().getConstructor().getDeclarationDescriptor();
        if (!Intrinsics.areEqual(classifierDescriptor != null ? DescriptorUtilsKt.getFqNameUnsafe(classifierDescriptor) : null, DescriptorUtilsKt.getFqNameUnsafe(classDescriptor))) return false;
        return true;
    }

    public JvmBuiltInsSettings(@NotNull ModuleDescriptor moduleDescriptor, @NotNull StorageManager storageManager, @NotNull Function0<? extends ModuleDescriptor> deferredOwnerModuleDescriptor, @NotNull Function0<Boolean> isAdditionalBuiltInsFeatureSupported) {
        Intrinsics.checkParameterIsNotNull(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(deferredOwnerModuleDescriptor, "deferredOwnerModuleDescriptor");
        Intrinsics.checkParameterIsNotNull(isAdditionalBuiltInsFeatureSupported, "isAdditionalBuiltInsFeatureSupported");
        this.moduleDescriptor = moduleDescriptor;
        this.j2kClassMap = JavaToKotlinClassMap.INSTANCE;
        this.ownerModuleDescriptor$delegate = LazyKt.lazy(deferredOwnerModuleDescriptor);
        this.isAdditionalBuiltInsFeatureSupported$delegate = LazyKt.lazy(isAdditionalBuiltInsFeatureSupported);
        this.mockSerializableType = this.createMockJavaIoSerializableType(storageManager);
        this.cloneableType$delegate = storageManager.createLazyValue((Function0)new Function0<SimpleType>(this, storageManager){
            final /* synthetic */ JvmBuiltInsSettings this$0;
            final /* synthetic */ StorageManager $storageManager;

            @NotNull
            public final SimpleType invoke() {
                ModuleDescriptor moduleDescriptor = JvmBuiltInsSettings.access$getOwnerModuleDescriptor$p(this.this$0);
                ClassId classId = JvmBuiltInClassDescriptorFactory.Companion.getCLONEABLE_CLASS_ID();
                Intrinsics.checkExpressionValueIsNotNull(classId, "JvmBuiltInClassDescripto\u2026actory.CLONEABLE_CLASS_ID");
                return FindClassInModuleKt.findNonGenericClassAcrossDependencies(moduleDescriptor, classId, new NotFoundClasses(this.$storageManager, JvmBuiltInsSettings.access$getOwnerModuleDescriptor$p(this.this$0))).getDefaultType();
            }
            {
                this.this$0 = jvmBuiltInsSettings;
                this.$storageManager = storageManager;
                super(0);
            }
        });
        this.javaAnalogueClassesWithCustomSupertypeCache = storageManager.createCacheWithNotNullValues();
        this.notConsideredDeprecation$delegate = storageManager.createLazyValue((Function0)new Function0<AnnotationsImpl>(this){
            final /* synthetic */ JvmBuiltInsSettings this$0;

            @NotNull
            public final AnnotationsImpl invoke() {
                AnnotationDescriptor annotationDescriptor;
                AnnotationDescriptor it = annotationDescriptor = AnnotationUtilKt.createDeprecatedAnnotation$default(JvmBuiltInsSettings.access$getModuleDescriptor$p(this.this$0).getBuiltIns(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null);
                return new AnnotationsImpl(CollectionsKt.listOf(it));
            }
            {
                this.this$0 = jvmBuiltInsSettings;
                super(0);
            }
        });
    }

    static {
        SignatureBuildingComponents signatureBuildingComponents;
        Companion = new Companion(null);
        DROP_LIST_METHOD_SIGNATURES = SetsKt.plus((Set)SignatureBuildingComponents.INSTANCE.inJavaUtil("Collection", "toArray()[Ljava/lang/Object;", "toArray([Ljava/lang/Object;)[Ljava/lang/Object;"), "java/lang/annotation/Annotation.annotationType()Ljava/lang/Class;");
        SignatureBuildingComponents $receiver = signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        BLACK_LIST_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(JvmBuiltInsSettings.Companion.buildPrimitiveValueMethodsSet(), (Iterable)$receiver.inJavaUtil("List", "sort(Ljava/util/Comparator;)V")), (Iterable)$receiver.inJavaLang("String", "codePointAt(I)I", "codePointBefore(I)I", "codePointCount(II)I", "compareToIgnoreCase(Ljava/lang/String;)I", "concat(Ljava/lang/String;)Ljava/lang/String;", "contains(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/CharSequence;)Z", "contentEquals(Ljava/lang/StringBuffer;)Z", "endsWith(Ljava/lang/String;)Z", "equalsIgnoreCase(Ljava/lang/String;)Z", "getBytes()[B", "getBytes(II[BI)V", "getBytes(Ljava/lang/String;)[B", "getBytes(Ljava/nio/charset/Charset;)[B", "getChars(II[CI)V", "indexOf(I)I", "indexOf(II)I", "indexOf(Ljava/lang/String;)I", "indexOf(Ljava/lang/String;I)I", "intern()Ljava/lang/String;", "isEmpty()Z", "lastIndexOf(I)I", "lastIndexOf(II)I", "lastIndexOf(Ljava/lang/String;)I", "lastIndexOf(Ljava/lang/String;I)I", "matches(Ljava/lang/String;)Z", "offsetByCodePoints(II)I", "regionMatches(ILjava/lang/String;II)Z", "regionMatches(ZILjava/lang/String;II)Z", "replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(CC)Ljava/lang/String;", "replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "split(Ljava/lang/String;I)[Ljava/lang/String;", "split(Ljava/lang/String;)[Ljava/lang/String;", "startsWith(Ljava/lang/String;I)Z", "startsWith(Ljava/lang/String;)Z", "substring(II)Ljava/lang/String;", "substring(I)Ljava/lang/String;", "toCharArray()[C", "toLowerCase()Ljava/lang/String;", "toLowerCase(Ljava/util/Locale;)Ljava/lang/String;", "toUpperCase()Ljava/lang/String;", "toUpperCase(Ljava/util/Locale;)Ljava/lang/String;", "trim()Ljava/lang/String;")), (Iterable)$receiver.inJavaLang("Double", "isInfinite()Z", "isNaN()Z")), (Iterable)$receiver.inJavaLang("Float", "isInfinite()Z", "isNaN()Z")), (Iterable)$receiver.inJavaLang("Enum", "getDeclaringClass()Ljava/lang/Class;", "finalize()V"));
        $receiver = signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        WHITE_LIST_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus(SetsKt.plus((Set)$receiver.inJavaLang("CharSequence", "codePoints()Ljava/util/stream/IntStream;", "chars()Ljava/util/stream/IntStream;"), (Iterable)$receiver.inJavaUtil("Iterator", "forEachRemaining(Ljava/util/function/Consumer;)V")), (Iterable)$receiver.inJavaLang("Iterable", "forEach(Ljava/util/function/Consumer;)V", "spliterator()Ljava/util/Spliterator;")), (Iterable)$receiver.inJavaLang("Throwable", "setStackTrace([Ljava/lang/StackTraceElement;)V", "fillInStackTrace()Ljava/lang/Throwable;", "getLocalizedMessage()Ljava/lang/String;", "printStackTrace()V", "printStackTrace(Ljava/io/PrintStream;)V", "printStackTrace(Ljava/io/PrintWriter;)V", "getStackTrace()[Ljava/lang/StackTraceElement;", "initCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "getSuppressed()[Ljava/lang/Throwable;", "addSuppressed(Ljava/lang/Throwable;)V")), (Iterable)$receiver.inJavaUtil("Collection", "spliterator()Ljava/util/Spliterator;", "parallelStream()Ljava/util/stream/Stream;", "stream()Ljava/util/stream/Stream;", "removeIf(Ljava/util/function/Predicate;)Z")), (Iterable)$receiver.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V")), (Iterable)$receiver.inJavaUtil("Map", "getOrDefault(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "forEach(Ljava/util/function/BiConsumer;)V", "replaceAll(Ljava/util/function/BiFunction;)V", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;"));
        $receiver = signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        MUTABLE_METHOD_SIGNATURES = SetsKt.plus(SetsKt.plus((Set)$receiver.inJavaUtil("Collection", "removeIf(Ljava/util/function/Predicate;)Z"), (Iterable)$receiver.inJavaUtil("List", "replaceAll(Ljava/util/function/UnaryOperator;)V", "sort(Ljava/util/Comparator;)V")), (Iterable)$receiver.inJavaUtil("Map", "computeIfAbsent(Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;", "computeIfPresent(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "compute(Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "merge(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;", "putIfAbsent(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove(Ljava/lang/Object;Ljava/lang/Object;)Z", "replaceAll(Ljava/util/function/BiFunction;)V", "replace(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "replace(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z"));
        $receiver = signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String[] stringArray = $receiver.constructors("D");
        String[] stringArray2 = $receiver.constructors("[C", "[CII", "[III", "[BIILjava/lang/String;", "[BIILjava/nio/charset/Charset;", "[BLjava/lang/String;", "[BLjava/nio/charset/Charset;", "[BII", "[B", "Ljava/lang/StringBuffer;", "Ljava/lang/StringBuilder;");
        BLACK_LIST_CONSTRUCTOR_SIGNATURES = SetsKt.plus(SetsKt.plus(JvmBuiltInsSettings.Companion.buildPrimitiveStringConstructorsSet(), (Iterable)$receiver.inJavaLang("Float", Arrays.copyOf(stringArray, stringArray.length))), (Iterable)$receiver.inJavaLang("String", Arrays.copyOf(stringArray2, stringArray2.length)));
        $receiver = signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        String[] stringArray3 = $receiver.constructors("Ljava/lang/String;Ljava/lang/Throwable;ZZ");
        WHITE_LIST_CONSTRUCTOR_SIGNATURES = $receiver.inJavaLang("Throwable", Arrays.copyOf(stringArray3, stringArray3.length));
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsSettings.class), "ownerModuleDescriptor", "getOwnerModuleDescriptor()Lorg/jetbrains/kotlin/descriptors/ModuleDescriptor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsSettings.class), "isAdditionalBuiltInsFeatureSupported", "isAdditionalBuiltInsFeatureSupported()Z")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsSettings.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltInsSettings.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/AnnotationsImpl;"))};
    }

    @NotNull
    public static final /* synthetic */ ModuleDescriptor access$getModuleDescriptor$p(JvmBuiltInsSettings $this) {
        return $this.moduleDescriptor;
    }

    public static final /* synthetic */ JavaToKotlinClassMap access$getJ2kClassMap$p(JvmBuiltInsSettings $this) {
        return $this.j2kClassMap;
    }

    @Nullable
    public static final /* synthetic */ LazyJavaClassDescriptor access$getJavaAnalogue(JvmBuiltInsSettings $this, @NotNull ClassDescriptor $receiver) {
        return $this.getJavaAnalogue($receiver);
    }

    @NotNull
    public static final /* synthetic */ ModuleDescriptor access$getOwnerModuleDescriptor$p(JvmBuiltInsSettings $this) {
        return $this.getOwnerModuleDescriptor();
    }

    private static final class JDKMemberStatus
    extends Enum<JDKMemberStatus> {
        public static final /* enum */ JDKMemberStatus BLACK_LIST;
        public static final /* enum */ JDKMemberStatus WHITE_LIST;
        public static final /* enum */ JDKMemberStatus NOT_CONSIDERED;
        public static final /* enum */ JDKMemberStatus DROP;
        private static final /* synthetic */ JDKMemberStatus[] $VALUES;

        static {
            JDKMemberStatus[] jDKMemberStatusArray = new JDKMemberStatus[4];
            JDKMemberStatus[] jDKMemberStatusArray2 = jDKMemberStatusArray;
            jDKMemberStatusArray[0] = BLACK_LIST = new JDKMemberStatus();
            jDKMemberStatusArray[1] = WHITE_LIST = new JDKMemberStatus();
            jDKMemberStatusArray[2] = NOT_CONSIDERED = new JDKMemberStatus();
            jDKMemberStatusArray[3] = DROP = new JDKMemberStatus();
            $VALUES = jDKMemberStatusArray;
        }

        public static JDKMemberStatus[] values() {
            return (JDKMemberStatus[])$VALUES.clone();
        }

        public static JDKMemberStatus valueOf(String string) {
            return Enum.valueOf(JDKMemberStatus.class, string);
        }
    }

    public static final class Companion {
        public final boolean isSerializableInJava(@NotNull FqNameUnsafe fqName2) {
            Class<?> clazz;
            Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
            if (this.isArrayOrPrimitiveArray(fqName2)) {
                return true;
            }
            ClassId classId = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(fqName2);
            if (classId == null) {
                return false;
            }
            ClassId javaClassId = classId;
            try {
                clazz = Class.forName(javaClassId.asSingleFqName().asString());
            }
            catch (ClassNotFoundException e) {
                return false;
            }
            Class<?> classViaReflection = clazz;
            return Serializable.class.isAssignableFrom(classViaReflection);
        }

        private final boolean isArrayOrPrimitiveArray(FqNameUnsafe fqName2) {
            return Intrinsics.areEqual(fqName2, KotlinBuiltIns.FQ_NAMES.array) || KotlinBuiltIns.isPrimitiveArray(fqName2);
        }

        @NotNull
        public final Set<String> getDROP_LIST_METHOD_SIGNATURES() {
            return DROP_LIST_METHOD_SIGNATURES;
        }

        @NotNull
        public final Set<String> getBLACK_LIST_METHOD_SIGNATURES() {
            return BLACK_LIST_METHOD_SIGNATURES;
        }

        /*
         * WARNING - void declaration
         */
        private final Set<String> buildPrimitiveValueMethodsSet() {
            void $receiver$iv;
            SignatureBuildingComponents signatureBuildingComponents;
            SignatureBuildingComponents $receiver = signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            Iterable iterable = CollectionsKt.listOf(new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.CHAR});
            Collection destination$iv = new LinkedHashSet();
            for (Object element$iv : $receiver$iv) {
                JvmPrimitiveType it = (JvmPrimitiveType)((Object)element$iv);
                String string = it.getWrapperFqName().shortName().asString();
                Intrinsics.checkExpressionValueIsNotNull(string, "it.wrapperFqName.shortName().asString()");
                Iterable list$iv = $receiver.inJavaLang(string, it.getJavaKeywordName() + "Value()" + it.getDesc());
                CollectionsKt.addAll(destination$iv, list$iv);
            }
            return (LinkedHashSet)destination$iv;
        }

        @NotNull
        public final Set<String> getWHITE_LIST_METHOD_SIGNATURES() {
            return WHITE_LIST_METHOD_SIGNATURES;
        }

        @NotNull
        public final Set<String> getMUTABLE_METHOD_SIGNATURES() {
            return MUTABLE_METHOD_SIGNATURES;
        }

        @NotNull
        public final Set<String> getBLACK_LIST_CONSTRUCTOR_SIGNATURES() {
            return BLACK_LIST_CONSTRUCTOR_SIGNATURES;
        }

        @NotNull
        public final Set<String> getWHITE_LIST_CONSTRUCTOR_SIGNATURES() {
            return WHITE_LIST_CONSTRUCTOR_SIGNATURES;
        }

        /*
         * WARNING - void declaration
         */
        private final Set<String> buildPrimitiveStringConstructorsSet() {
            void destination$iv;
            void $receiver$iv;
            SignatureBuildingComponents signatureBuildingComponents;
            SignatureBuildingComponents $receiver = signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
            Iterable iterable = CollectionsKt.listOf(new JvmPrimitiveType[]{JvmPrimitiveType.BOOLEAN, JvmPrimitiveType.BYTE, JvmPrimitiveType.DOUBLE, JvmPrimitiveType.FLOAT, JvmPrimitiveType.BYTE, JvmPrimitiveType.INT, JvmPrimitiveType.LONG, JvmPrimitiveType.SHORT});
            Collection collection = new LinkedHashSet();
            for (Object element$iv : $receiver$iv) {
                JvmPrimitiveType it = (JvmPrimitiveType)((Object)element$iv);
                String string = it.getWrapperFqName().shortName().asString();
                Intrinsics.checkExpressionValueIsNotNull(string, "it.wrapperFqName.shortName().asString()");
                String[] stringArray = $receiver.constructors("Ljava/lang/String;");
                Iterable list$iv = $receiver.inJavaLang(string, Arrays.copyOf(stringArray, stringArray.length));
                CollectionsKt.addAll(destination$iv, list$iv);
            }
            return (LinkedHashSet)destination$iv;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

