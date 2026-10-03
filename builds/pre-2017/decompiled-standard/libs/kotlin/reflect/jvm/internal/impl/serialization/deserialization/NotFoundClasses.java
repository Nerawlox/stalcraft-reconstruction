/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassOrPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClassesKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NotFoundClasses {
    private final MemoizedFunctionToNotNull<FqName, PackageFragmentDescriptor> packageFragments;
    private final MemoizedFunctionToNotNull<ClassRequest, ClassDescriptor> classes;
    private final MemoizedFunctionToNotNull<ClassRequest, TypeAliasDescriptor> typeAliases;
    private final StorageManager storageManager;
    private final ModuleDescriptor module;

    /*
     * WARNING - void declaration
     */
    private final <D> D computeClassifier(ClassRequest request, Function4<? super DeclarationDescriptor, ? super Name, ? super Boolean, ? super Integer, ? extends D> constructor) {
        ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor;
        void typeParametersCount2;
        void classId;
        ClassRequest classRequest = request;
        ClassId classId2 = classRequest.component1();
        List<Integer> list = classRequest.component2();
        classRequest = null;
        if (classId.isLocal()) {
            throw (Throwable)new UnsupportedOperationException("Unresolved local class: " + classId);
        }
        if (classId.isNestedClass()) {
            ClassId classId3 = classId.getOuterClassId();
            Intrinsics.checkExpressionValueIsNotNull(classId3, "classId.outerClassId");
            classOrPackageFragmentDescriptor = this.getOrCreateClass(classId3, CollectionsKt.drop((Iterable)typeParametersCount2, 1));
        } else {
            FqName fqName2 = classId.getPackageFqName();
            Intrinsics.checkExpressionValueIsNotNull(fqName2, "classId.packageFqName");
            classOrPackageFragmentDescriptor = (ClassOrPackageFragmentDescriptor)this.packageFragments.invoke(fqName2);
        }
        ClassOrPackageFragmentDescriptor container = classOrPackageFragmentDescriptor;
        boolean isInner2 = classId.isNestedClass();
        Name name2 = classId.getShortClassName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "classId.shortClassName");
        Integer n = (Integer)CollectionsKt.firstOrNull(typeParametersCount2);
        return constructor.invoke(container, name2, isInner2, n != null ? n : 0);
    }

    private final ClassDescriptor getOrCreateClass(ClassId classId, List<Integer> typeParametersCount2) {
        return (ClassDescriptor)this.classes.invoke(new ClassRequest(classId, typeParametersCount2));
    }

    @NotNull
    public final TypeConstructor getClass(@NotNull ProtoBuf.Type proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
        ClassId classId;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        ClassId classId2 = classId = nameResolver.getClassId(proto.getClassName());
        Intrinsics.checkExpressionValueIsNotNull(classId2, "classId");
        ClassId classId3 = classId;
        Intrinsics.checkExpressionValueIsNotNull(classId3, "classId");
        TypeConstructor typeConstructor2 = this.getOrCreateClass(classId2, NotFoundClassesKt.access$computeTypeParametersCount(classId3, proto, typeTable)).getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "getOrCreateClass(classId\u2026peTable)).typeConstructor");
        return typeConstructor2;
    }

    @NotNull
    public final TypeConstructor getClass(@NotNull ClassId classId, @NotNull List<Integer> typeParametersCount2) {
        Intrinsics.checkParameterIsNotNull(classId, "classId");
        Intrinsics.checkParameterIsNotNull(typeParametersCount2, "typeParametersCount");
        TypeConstructor typeConstructor2 = this.getOrCreateClass(classId, typeParametersCount2).getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "getOrCreateClass(classId\u2026ersCount).typeConstructor");
        return typeConstructor2;
    }

    @NotNull
    public final TypeConstructor getTypeAlias(@NotNull ProtoBuf.Type proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
        ClassId classId;
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        ClassId classId2 = classId = nameResolver.getClassId(proto.getTypeAliasName());
        Intrinsics.checkExpressionValueIsNotNull(classId2, "classId");
        ClassId classId3 = classId;
        Intrinsics.checkExpressionValueIsNotNull(classId3, "classId");
        TypeConstructor typeConstructor2 = ((TypeAliasDescriptor)this.typeAliases.invoke(new ClassRequest(classId2, NotFoundClassesKt.access$computeTypeParametersCount(classId3, proto, typeTable)))).getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "typeAliases(ClassRequest\u2026eTable))).typeConstructor");
        return typeConstructor2;
    }

    public NotFoundClasses(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor module) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(module, "module");
        this.storageManager = storageManager;
        this.module = module;
        this.packageFragments = this.storageManager.createMemoizedFunction((Function1)new Function1<FqName, EmptyPackageFragmentDescriptor>(this){
            final /* synthetic */ NotFoundClasses this$0;

            @NotNull
            public final EmptyPackageFragmentDescriptor invoke(@NotNull FqName fqName2) {
                Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
                return new EmptyPackageFragmentDescriptor(NotFoundClasses.access$getModule$p(this.this$0), fqName2);
            }
            {
                this.this$0 = notFoundClasses;
                super(1);
            }
        });
        this.classes = this.storageManager.createMemoizedFunction((Function1)new Function1<ClassRequest, MockClassDescriptor>(this){
            final /* synthetic */ NotFoundClasses this$0;

            @NotNull
            public final MockClassDescriptor invoke(@NotNull ClassRequest request) {
                Intrinsics.checkParameterIsNotNull(request, "request");
                return (MockClassDescriptor)NotFoundClasses.access$computeClassifier(this.this$0, request, new Function4<DeclarationDescriptor, Name, Boolean, Integer, MockClassDescriptor>(this){
                    final /* synthetic */ classes.1 this$0;

                    @NotNull
                    public final MockClassDescriptor invoke(@NotNull DeclarationDescriptor owner, @NotNull Name name2, boolean isInner2, int numberOfTypeParametersCount) {
                        Intrinsics.checkParameterIsNotNull(owner, "owner");
                        Intrinsics.checkParameterIsNotNull(name2, "name");
                        return new MockClassDescriptor(NotFoundClasses.access$getStorageManager$p(this.this$0.this$0), owner, name2, isInner2, numberOfTypeParametersCount);
                    }
                    {
                        this.this$0 = var1_1;
                        super(4);
                    }
                });
            }
            {
                this.this$0 = notFoundClasses;
                super(1);
            }
        });
        this.typeAliases = this.storageManager.createMemoizedFunction((Function1)new Function1<ClassRequest, MockTypeAliasDescriptor>(this){
            final /* synthetic */ NotFoundClasses this$0;

            @NotNull
            public final MockTypeAliasDescriptor invoke(@NotNull ClassRequest request) {
                Intrinsics.checkParameterIsNotNull(request, "request");
                return (MockTypeAliasDescriptor)NotFoundClasses.access$computeClassifier(this.this$0, request, new Function4<DeclarationDescriptor, Name, Boolean, Integer, MockTypeAliasDescriptor>(this){
                    final /* synthetic */ typeAliases.1 this$0;

                    @NotNull
                    public final MockTypeAliasDescriptor invoke(@NotNull DeclarationDescriptor owner, @NotNull Name name2, boolean isInner2, int numberOfTypeParametersCount) {
                        Intrinsics.checkParameterIsNotNull(owner, "owner");
                        Intrinsics.checkParameterIsNotNull(name2, "name");
                        return new MockTypeAliasDescriptor(NotFoundClasses.access$getStorageManager$p(this.this$0.this$0), owner, name2, isInner2, numberOfTypeParametersCount);
                    }
                    {
                        this.this$0 = var1_1;
                        super(4);
                    }
                });
            }
            {
                this.this$0 = notFoundClasses;
                super(1);
            }
        });
    }

    @NotNull
    public static final /* synthetic */ ModuleDescriptor access$getModule$p(NotFoundClasses $this) {
        return $this.module;
    }

    public static final /* synthetic */ Object access$computeClassifier(NotFoundClasses $this, @NotNull ClassRequest request, @NotNull Function4 constructor) {
        return $this.computeClassifier(request, constructor);
    }

    @NotNull
    public static final /* synthetic */ StorageManager access$getStorageManager$p(NotFoundClasses $this) {
        return $this.storageManager;
    }

    private static final class ClassRequest {
        @NotNull
        private final ClassId classId;
        @NotNull
        private final List<Integer> typeParametersCount;

        @NotNull
        public final ClassId getClassId() {
            return this.classId;
        }

        @NotNull
        public final List<Integer> getTypeParametersCount() {
            return this.typeParametersCount;
        }

        public ClassRequest(@NotNull ClassId classId, @NotNull List<Integer> typeParametersCount2) {
            Intrinsics.checkParameterIsNotNull(classId, "classId");
            Intrinsics.checkParameterIsNotNull(typeParametersCount2, "typeParametersCount");
            this.classId = classId;
            this.typeParametersCount = typeParametersCount2;
        }

        @NotNull
        public final ClassId component1() {
            return this.classId;
        }

        @NotNull
        public final List<Integer> component2() {
            return this.typeParametersCount;
        }

        @NotNull
        public final ClassRequest copy(@NotNull ClassId classId, @NotNull List<Integer> typeParametersCount2) {
            Intrinsics.checkParameterIsNotNull(classId, "classId");
            Intrinsics.checkParameterIsNotNull(typeParametersCount2, "typeParametersCount");
            return new ClassRequest(classId, typeParametersCount2);
        }

        @NotNull
        public static /* bridge */ /* synthetic */ ClassRequest copy$default(ClassRequest classRequest, ClassId classId, List list, int n, Object object) {
            if ((n & 1) != 0) {
                classId = classRequest.classId;
            }
            if ((n & 2) != 0) {
                list = classRequest.typeParametersCount;
            }
            return classRequest.copy(classId, list);
        }

        public String toString() {
            return "ClassRequest(classId=" + this.classId + ", typeParametersCount=" + this.typeParametersCount + ")";
        }

        public int hashCode() {
            ClassId classId = this.classId;
            List<Integer> list = this.typeParametersCount;
            return (classId != null ? ((Object)classId).hashCode() : 0) * 31 + (list != null ? ((Object)list).hashCode() : 0);
        }

        public boolean equals(Object object) {
            block3: {
                block2: {
                    if (this == object) break block2;
                    if (!(object instanceof ClassRequest)) break block3;
                    ClassRequest classRequest = (ClassRequest)object;
                    if (!Intrinsics.areEqual(this.classId, classRequest.classId) || !Intrinsics.areEqual(this.typeParametersCount, classRequest.typeParametersCount)) break block3;
                }
                return true;
            }
            return false;
        }
    }

    public static final class MockClassDescriptor
    extends ClassDescriptorBase {
        private final List<TypeParameterDescriptor> typeParameters;
        private final ClassTypeConstructorImpl typeConstructor;
        private final boolean isInner;

        @Override
        @NotNull
        public ClassKind getKind() {
            return ClassKind.CLASS;
        }

        @Override
        @NotNull
        public Modality getModality() {
            return Modality.FINAL;
        }

        @Override
        @NotNull
        public Visibility getVisibility() {
            return Visibilities.PUBLIC;
        }

        @Override
        @NotNull
        public ClassTypeConstructorImpl getTypeConstructor() {
            return this.typeConstructor;
        }

        @Override
        @NotNull
        public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
            return this.typeParameters;
        }

        @Override
        public boolean isInner() {
            return this.isInner;
        }

        @Override
        public boolean isCompanionObject() {
            return false;
        }

        @Override
        public boolean isData() {
            return false;
        }

        @Override
        public boolean isHeader() {
            return false;
        }

        @Override
        public boolean isImpl() {
            return false;
        }

        @Override
        public boolean isExternal() {
            return false;
        }

        @Override
        @NotNull
        public Annotations getAnnotations() {
            return Annotations.Companion.getEMPTY();
        }

        @Override
        @NotNull
        public MemberScope.Empty getUnsubstitutedMemberScope() {
            return MemberScope.Empty.INSTANCE;
        }

        @Override
        @NotNull
        public MemberScope.Empty getStaticScope() {
            return MemberScope.Empty.INSTANCE;
        }

        @Override
        @NotNull
        public Collection<ClassConstructorDescriptor> getConstructors() {
            return SetsKt.emptySet();
        }

        @Override
        @Nullable
        public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override
        @Nullable
        public ClassDescriptor getCompanionObjectDescriptor() {
            return null;
        }

        @Override
        @NotNull
        public Collection<ClassDescriptor> getSealedSubclasses() {
            return CollectionsKt.emptyList();
        }

        @NotNull
        public String toString() {
            return "class " + this.getName() + " (not found)";
        }

        public MockClassDescriptor(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor container, @NotNull Name name2, boolean isInner2, int numberOfDeclaredTypeParameters) {
            Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
            Intrinsics.checkParameterIsNotNull(container, "container");
            Intrinsics.checkParameterIsNotNull(name2, "name");
            super(storageManager, container, name2, SourceElement.NO_SOURCE, false);
            this.isInner = isInner2;
            this.typeParameters = NotFoundClassesKt.access$createTypeParameters(this, numberOfDeclaredTypeParameters);
            this.typeConstructor = new ClassTypeConstructorImpl(this, true, this.typeParameters, (Collection<KotlinType>)SetsKt.setOf(DescriptorUtilsKt.getModule(this).getBuiltIns().getAnyType()));
        }
    }

    private static final class MockTypeAliasDescriptor
    extends AbstractTypeAliasDescriptor {
        private final NotNullLazyValue constructorTypeParameters$delegate;
        private final boolean isInner;
        static final /* synthetic */ KProperty[] $$delegatedProperties;

        private final List<TypeParameterDescriptor> getConstructorTypeParameters() {
            return (List)StorageKt.getValue(this.constructorTypeParameters$delegate, (Object)this, $$delegatedProperties[0]);
        }

        @Override
        @NotNull
        protected List<TypeParameterDescriptor> getTypeConstructorTypeParameters() {
            return this.getConstructorTypeParameters();
        }

        @Override
        @NotNull
        public SimpleType getUnderlyingType() {
            SimpleType simpleType2 = DescriptorUtilsKt.getBuiltIns(this).getNullableAnyType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "builtIns.nullableAnyType");
            return simpleType2;
        }

        @Override
        @NotNull
        public SimpleType getExpandedType() {
            SimpleType simpleType2 = DescriptorUtilsKt.getBuiltIns(this).getNullableAnyType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "builtIns.nullableAnyType");
            return simpleType2;
        }

        @Override
        @NotNull
        public SimpleType getDefaultType() {
            SimpleType simpleType2 = DescriptorUtilsKt.getBuiltIns(this).getNullableAnyType();
            Intrinsics.checkExpressionValueIsNotNull(simpleType2, "builtIns.nullableAnyType");
            return simpleType2;
        }

        @Override
        @Nullable
        public ClassDescriptor getClassDescriptor() {
            ClassifierDescriptor classifierDescriptor = this.getExpandedType().getConstructor().getDeclarationDescriptor();
            if (!(classifierDescriptor instanceof ClassDescriptor)) {
                classifierDescriptor = null;
            }
            return (ClassDescriptor)classifierDescriptor;
        }

        @Override
        public boolean isInner() {
            return this.isInner;
        }

        @Override
        @NotNull
        public MockTypeAliasDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
            Intrinsics.checkParameterIsNotNull(substitutor, "substitutor");
            return this;
        }

        @Override
        @NotNull
        public String toString() {
            return "MockTypeAliasDescriptor[" + DescriptorUtilsKt.getFqNameUnsafe(this) + "]";
        }

        public MockTypeAliasDescriptor(@NotNull StorageManager storageManager, @NotNull DeclarationDescriptor containingDeclaration, @NotNull Name name2, boolean isInner2, int numberOfDeclaredTypeParameters) {
            Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
            Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Annotations annotations2 = Annotations.Companion.getEMPTY();
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
            Visibility visibility = Visibilities.PUBLIC;
            Intrinsics.checkExpressionValueIsNotNull(visibility, "Visibilities.PUBLIC");
            super(containingDeclaration, annotations2, name2, sourceElement, visibility);
            this.isInner = isInner2;
            this.initialize(NotFoundClassesKt.access$createTypeParameters(this, numberOfDeclaredTypeParameters));
            this.constructorTypeParameters$delegate = storageManager.createLazyValue((Function0)new Function0<List<? extends TypeParameterDescriptor>>(this){
                final /* synthetic */ MockTypeAliasDescriptor this$0;

                @NotNull
                public final List<TypeParameterDescriptor> invoke() {
                    return TypeParameterUtilsKt.computeConstructorTypeParameters(this.this$0);
                }
                {
                    this.this$0 = mockTypeAliasDescriptor;
                    super(0);
                }
            });
        }

        static {
            $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(MockTypeAliasDescriptor.class), "constructorTypeParameters", "getConstructorTypeParameters()Ljava/util/List;"))};
        }
    }
}

