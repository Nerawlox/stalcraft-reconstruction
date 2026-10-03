/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.Deserialization;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfo;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedClassDescriptor
extends AbstractClassDescriptor {
    private final ClassId classId;
    private final Modality modality;
    private final Visibility visibility;
    private final ClassKind kind;
    @NotNull
    private final DeserializationContext c;
    private final MemberScopeImpl staticScope;
    private final DeserializedClassTypeConstructor typeConstructor;
    private final DeserializedClassMemberScope memberScope;
    private final EnumEntryClassDescriptors enumEntries;
    private final DeclarationDescriptor containingDeclaration;
    private final NullableLazyValue<ClassConstructorDescriptor> primaryConstructor;
    private final NotNullLazyValue<Collection<ClassConstructorDescriptor>> constructors;
    private final NullableLazyValue<ClassDescriptor> companionObjectDescriptor;
    private final NotNullLazyValue<Collection<ClassDescriptor>> sealedSubclasses;
    @NotNull
    private final ProtoContainer.Class thisAsProtoContainer;
    @NotNull
    private final Annotations annotations;
    @NotNull
    private final ProtoBuf.Class classProto;
    private final SourceElement sourceElement;

    @NotNull
    public final DeserializationContext getC() {
        return this.c;
    }

    @NotNull
    public final ProtoContainer.Class getThisAsProtoContainer$kotlin_core() {
        return this.thisAsProtoContainer;
    }

    @Nullable
    public final SinceKotlinInfo getSinceKotlinInfo() {
        return SinceKotlinInfo.Companion.create(this.classProto, this.c.getNameResolver(), this.c.getSinceKotlinInfoTable());
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return this.annotations;
    }

    @Override
    @NotNull
    public DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override
    @NotNull
    public ClassKind getKind() {
        return this.kind;
    }

    @Override
    @NotNull
    public Modality getModality() {
        return this.modality;
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        return this.visibility;
    }

    @NotNull
    public Boolean isInner() {
        return Flags.IS_INNER.get(this.classProto.getFlags());
    }

    @NotNull
    public Boolean isData() {
        return Flags.IS_DATA.get(this.classProto.getFlags());
    }

    @Override
    public boolean isHeader() {
        return false;
    }

    @Override
    public boolean isImpl() {
        return false;
    }

    @NotNull
    public Boolean isExternal() {
        return Flags.IS_EXTERNAL_CLASS.get(this.classProto.getFlags());
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedMemberScope() {
        return this.memberScope;
    }

    @Override
    @NotNull
    public MemberScopeImpl getStaticScope() {
        return this.staticScope;
    }

    @Override
    public boolean isCompanionObject() {
        return Intrinsics.areEqual(Flags.CLASS_KIND.get(this.classProto.getFlags()), ProtoBuf.Class.Kind.COMPANION_OBJECT);
    }

    private final ClassConstructorDescriptor computePrimaryConstructor() {
        ClassConstructorDescriptor classConstructorDescriptor;
        Object v0;
        block4: {
            if (this.kind.isSingleton()) {
                ClassConstructorDescriptorImpl classConstructorDescriptorImpl;
                ClassConstructorDescriptorImpl $receiver = classConstructorDescriptorImpl = DescriptorFactory.createPrimaryConstructorForObject(this, SourceElement.NO_SOURCE);
                $receiver.setReturnType(this.getDefaultType());
                return classConstructorDescriptorImpl;
            }
            Iterable $receiver$iv = this.classProto.getConstructorList();
            for (Object element$iv : $receiver$iv) {
                ProtoBuf.Constructor it = (ProtoBuf.Constructor)element$iv;
                if (!(Flags.IS_SECONDARY.get(it.getFlags()) == false)) continue;
                v0 = element$iv;
                break block4;
            }
            v0 = null;
        }
        ProtoBuf.Constructor constructor = v0;
        if (constructor != null) {
            ProtoBuf.Constructor constructor2;
            ProtoBuf.Constructor constructorProto = constructor2 = constructor;
            classConstructorDescriptor = this.c.getMemberDeserializer().loadConstructor(constructorProto, true);
        } else {
            classConstructorDescriptor = null;
        }
        return classConstructorDescriptor;
    }

    @Override
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return (ClassConstructorDescriptor)this.primaryConstructor.invoke();
    }

    private final Collection<ClassConstructorDescriptor> computeConstructors() {
        return CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)this.computeSecondaryConstructors(), (Iterable)kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.singletonOrEmptyList(this.getUnsubstitutedPrimaryConstructor())), (Iterable)this.c.getComponents().getAdditionalClassPartsProvider().getConstructors(this));
    }

    /*
     * WARNING - void declaration
     */
    private final List<ClassConstructorDescriptor> computeSecondaryConstructors() {
        void var3_3;
        ProtoBuf.Constructor it;
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)this.classProto.getConstructorList();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            it = (ProtoBuf.Constructor)element$iv$iv;
            Boolean bl = Flags.IS_SECONDARY.get(it.getFlags());
            Intrinsics.checkExpressionValueIsNotNull(bl, "Flags.IS_SECONDARY.get(it.flags)");
            if (!bl.booleanValue()) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            it = (ProtoBuf.Constructor)item$iv$iv;
            Collection collection = destination$iv$iv;
            MemberDeserializer memberDeserializer = this.c.getMemberDeserializer();
            ProtoBuf.Constructor constructor = it;
            Intrinsics.checkExpressionValueIsNotNull(constructor, "it");
            ClassConstructorDescriptor classConstructorDescriptor = memberDeserializer.loadConstructor(constructor, false);
            collection.add(classConstructorDescriptor);
        }
        return (List)var3_3;
    }

    @Override
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        return (Collection)this.constructors.invoke();
    }

    private final ClassDescriptor computeCompanionObjectDescriptor() {
        Name companionObjectName;
        if (!this.classProto.hasCompanionObjectName()) {
            return null;
        }
        Name name2 = companionObjectName = this.c.getNameResolver().getName(this.classProto.getCompanionObjectName());
        Intrinsics.checkExpressionValueIsNotNull(name2, "companionObjectName");
        ClassifierDescriptor classifierDescriptor = this.memberScope.getContributedClassifier(name2, NoLookupLocation.FROM_DESERIALIZATION);
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            classifierDescriptor = null;
        }
        return (ClassDescriptor)classifierDescriptor;
    }

    @Override
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return (ClassDescriptor)this.companionObjectDescriptor.invoke();
    }

    public final boolean hasNestedClass$kotlin_core(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return this.memberScope.getClassNames$kotlin_core().contains(name2);
    }

    /*
     * WARNING - void declaration
     */
    private final Collection<ClassDescriptor> computeSubclassesForSealedClass() {
        if (Intrinsics.areEqual((Object)this.modality, (Object)Modality.SEALED) ^ true) {
            return CollectionsKt.emptyList();
        }
        List<Integer> fqNames = this.classProto.getSealedSubclassFqNameList();
        Collection collection = fqNames;
        if (!collection.isEmpty()) {
            void $receiver$iv$iv;
            Iterable $receiver$iv;
            Iterable iterable = $receiver$iv = (Iterable)fqNames;
            Collection destination$iv$iv = new ArrayList();
            void $receiver$iv$iv$iv = $receiver$iv$iv;
            Iterator iterator2 = $receiver$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                ClassDescriptor classDescriptor;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                Integer index = (Integer)element$iv$iv;
                DeserializationComponents deserializationComponents = this.c.getComponents();
                NameResolver nameResolver = this.c.getNameResolver();
                Integer n = index;
                Intrinsics.checkExpressionValueIsNotNull(n, "index");
                ClassId classId = nameResolver.getClassId(n);
                Intrinsics.checkExpressionValueIsNotNull(classId, "c.nameResolver.getClassId(index)");
                if (deserializationComponents.deserializeClass(classId) == null) continue;
                ClassDescriptor it$iv$iv = classDescriptor;
                destination$iv$iv.add(it$iv$iv);
            }
            return (List)destination$iv$iv;
        }
        return DescriptorUtilsKt.computeSealedSubclasses(this);
    }

    @Override
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        return (Collection)this.sealedSubclasses.invoke();
    }

    @NotNull
    public String toString() {
        return "deserialized class " + this.getName();
    }

    @Override
    @NotNull
    public SourceElement getSource() {
        return this.sourceElement;
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.c.getTypeDeserializer().getOwnTypeParameters();
    }

    @NotNull
    public final ProtoBuf.Class getClassProto() {
        return this.classProto;
    }

    public DeserializedClassDescriptor(@NotNull DeserializationContext outerContext, @NotNull ProtoBuf.Class classProto, @NotNull NameResolver nameResolver, @NotNull SourceElement sourceElement) {
        Intrinsics.checkParameterIsNotNull(outerContext, "outerContext");
        Intrinsics.checkParameterIsNotNull(classProto, "classProto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(sourceElement, "sourceElement");
        super(outerContext.getStorageManager(), nameResolver.getClassId(classProto.getFqName()).getShortClassName());
        this.classProto = classProto;
        this.sourceElement = sourceElement;
        this.classId = nameResolver.getClassId(this.classProto.getFqName());
        this.modality = Deserialization.modality(Flags.MODALITY.get(this.classProto.getFlags()));
        this.visibility = Deserialization.visibility(Flags.VISIBILITY.get(this.classProto.getFlags()));
        this.kind = Deserialization.classKind(Flags.CLASS_KIND.get(this.classProto.getFlags()));
        DeclarationDescriptor declarationDescriptor = this;
        List<ProtoBuf.TypeParameter> list = this.classProto.getTypeParameterList();
        Intrinsics.checkExpressionValueIsNotNull(list, "classProto.typeParameterList");
        ProtoBuf.TypeTable typeTable = this.classProto.getTypeTable();
        Intrinsics.checkExpressionValueIsNotNull(typeTable, "classProto.typeTable");
        this.c = outerContext.childContext(declarationDescriptor, list, nameResolver, new TypeTable(typeTable));
        this.staticScope = Intrinsics.areEqual((Object)this.kind, (Object)ClassKind.ENUM_CLASS) ? (MemberScopeImpl)new StaticScopeForKotlinEnum(this.c.getStorageManager(), this) : (MemberScopeImpl)MemberScope.Empty.INSTANCE;
        this.typeConstructor = new DeserializedClassTypeConstructor();
        this.memberScope = new DeserializedClassMemberScope();
        this.enumEntries = Intrinsics.areEqual((Object)this.kind, (Object)ClassKind.ENUM_CLASS) ? new EnumEntryClassDescriptors() : null;
        this.containingDeclaration = outerContext.getContainingDeclaration();
        this.primaryConstructor = this.c.getStorageManager().createNullableLazyValue((Function0)new Function0<ClassConstructorDescriptor>(this){
            final /* synthetic */ DeserializedClassDescriptor this$0;

            @Nullable
            public final ClassConstructorDescriptor invoke() {
                return DeserializedClassDescriptor.access$computePrimaryConstructor(this.this$0);
            }
            {
                this.this$0 = deserializedClassDescriptor;
                super(0);
            }
        });
        this.constructors = this.c.getStorageManager().createLazyValue((Function0)new Function0<Collection<? extends ClassConstructorDescriptor>>(this){
            final /* synthetic */ DeserializedClassDescriptor this$0;

            @NotNull
            public final Collection<ClassConstructorDescriptor> invoke() {
                return DeserializedClassDescriptor.access$computeConstructors(this.this$0);
            }
            {
                this.this$0 = deserializedClassDescriptor;
                super(0);
            }
        });
        this.companionObjectDescriptor = this.c.getStorageManager().createNullableLazyValue((Function0)new Function0<ClassDescriptor>(this){
            final /* synthetic */ DeserializedClassDescriptor this$0;

            @Nullable
            public final ClassDescriptor invoke() {
                return DeserializedClassDescriptor.access$computeCompanionObjectDescriptor(this.this$0);
            }
            {
                this.this$0 = deserializedClassDescriptor;
                super(0);
            }
        });
        this.sealedSubclasses = this.c.getStorageManager().createLazyValue((Function0)new Function0<Collection<? extends ClassDescriptor>>(this){
            final /* synthetic */ DeserializedClassDescriptor this$0;

            @NotNull
            public final Collection<ClassDescriptor> invoke() {
                return DeserializedClassDescriptor.access$computeSubclassesForSealedClass(this.this$0);
            }
            {
                this.this$0 = deserializedClassDescriptor;
                super(0);
            }
        });
        NameResolver nameResolver2 = this.c.getNameResolver();
        TypeTable typeTable2 = this.c.getTypeTable();
        DeclarationDescriptor declarationDescriptor2 = this.containingDeclaration;
        if (!(declarationDescriptor2 instanceof DeserializedClassDescriptor)) {
            declarationDescriptor2 = null;
        }
        DeserializedClassDescriptor deserializedClassDescriptor = (DeserializedClassDescriptor)declarationDescriptor2;
        this.thisAsProtoContainer = new ProtoContainer.Class(this.classProto, nameResolver2, typeTable2, this.sourceElement, deserializedClassDescriptor != null ? deserializedClassDescriptor.thisAsProtoContainer : null);
        this.annotations = Flags.HAS_ANNOTATIONS.get(this.classProto.getFlags()) == false ? Annotations.Companion.getEMPTY() : (Annotations)new DeserializedAnnotations(this.c.getStorageManager(), (Function0<? extends List<? extends AnnotationDescriptor>>)new Function0<List<? extends AnnotationDescriptor>>(this){
            final /* synthetic */ DeserializedClassDescriptor this$0;

            @NotNull
            public final List<AnnotationDescriptor> invoke() {
                return this.this$0.getC().getComponents().getAnnotationAndConstantLoader().loadClassAnnotations(this.this$0.getThisAsProtoContainer$kotlin_core());
            }
            {
                this.this$0 = deserializedClassDescriptor;
                super(0);
            }
        });
    }

    @Nullable
    public static final /* synthetic */ ClassConstructorDescriptor access$computePrimaryConstructor(DeserializedClassDescriptor $this) {
        return $this.computePrimaryConstructor();
    }

    @NotNull
    public static final /* synthetic */ Collection access$computeConstructors(DeserializedClassDescriptor $this) {
        return $this.computeConstructors();
    }

    @Nullable
    public static final /* synthetic */ ClassDescriptor access$computeCompanionObjectDescriptor(DeserializedClassDescriptor $this) {
        return $this.computeCompanionObjectDescriptor();
    }

    @NotNull
    public static final /* synthetic */ Collection access$computeSubclassesForSealedClass(DeserializedClassDescriptor $this) {
        return $this.computeSubclassesForSealedClass();
    }

    private final class DeserializedClassTypeConstructor
    extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        protected Collection<KotlinType> computeSupertypes() {
            Iterable $receiver$iv$iv;
            Annotated annotated;
            Object object;
            void $receiver$iv$iv2;
            Iterable $receiver$iv;
            Iterable iterable = $receiver$iv = (Iterable)ProtoTypeTableUtilKt.supertypes(DeserializedClassDescriptor.this.getClassProto(), DeserializedClassDescriptor.this.getC().getTypeTable());
            Iterable destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv2) {
                Iterator supertypeProto;
                ProtoBuf.Type type2 = (ProtoBuf.Type)item$iv$iv;
                object = destination$iv$iv;
                annotated = TypeDeserializer.type$default(DeserializedClassDescriptor.this.getC().getTypeDeserializer(), (ProtoBuf.Type)((Object)supertypeProto), null, 2, null);
                object.add(annotated);
            }
            List result2 = CollectionsKt.plus((Collection)((List)destination$iv$iv), (Iterable)DeserializedClassDescriptor.this.getC().getComponents().getAdditionalClassPartsProvider().getSupertypes(DeserializedClassDescriptor.this));
            Iterable $receiver$iv2 = result2;
            destination$iv$iv = $receiver$iv2;
            Collection destination$iv$iv2 = new ArrayList();
            void $receiver$iv$iv$iv = $receiver$iv$iv;
            for (Object element$iv$iv$iv : $receiver$iv$iv$iv) {
                NotFoundClasses.MockClassDescriptor mockClassDescriptor;
                Object element$iv$iv = element$iv$iv$iv;
                KotlinType supertype = (KotlinType)element$iv$iv;
                ClassifierDescriptor classifierDescriptor = supertype.getConstructor().getDeclarationDescriptor();
                if (!(classifierDescriptor instanceof NotFoundClasses.MockClassDescriptor)) {
                    classifierDescriptor = null;
                }
                if ((NotFoundClasses.MockClassDescriptor)classifierDescriptor == null) continue;
                NotFoundClasses.MockClassDescriptor it$iv$iv = mockClassDescriptor;
                destination$iv$iv2.add(it$iv$iv);
            }
            List unresolved = (List)destination$iv$iv2;
            $receiver$iv2 = unresolved;
            if (!$receiver$iv2.isEmpty()) {
                Collection<Object> collection;
                $receiver$iv2 = unresolved;
                annotated = DeserializedClassDescriptor.this;
                object = DeserializedClassDescriptor.this.getC().getComponents().getErrorReporter();
                $receiver$iv$iv = $receiver$iv2;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
                for (Object item$iv$iv : $receiver$iv$iv) {
                    void it;
                    Object element$iv$iv$iv;
                    element$iv$iv$iv = (NotFoundClasses.MockClassDescriptor)item$iv$iv;
                    collection = destination$iv$iv2;
                    Object object2 = DescriptorUtilsKt.getClassId((ClassifierDescriptorWithTypeParameters)it);
                    if (object2 == null || (object2 = ((ClassId)object2).asSingleFqName()) == null || (object2 = ((FqName)object2).asString()) == null) {
                        object2 = it.getName().asString();
                    }
                    Object object3 = object2;
                    collection.add(object3);
                }
                collection = (List)destination$iv$iv2;
                object.reportIncompleteHierarchy((ClassDescriptor)annotated, (List<String>)collection);
            }
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList(result2);
        }

        @Override
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return (List)this.parameters.invoke();
        }

        @Override
        public boolean isFinal() {
            return ModalityKt.isFinalClass(DeserializedClassDescriptor.this);
        }

        @Override
        public boolean isDenotable() {
            return true;
        }

        @Override
        @NotNull
        public DeserializedClassDescriptor getDeclarationDescriptor() {
            return DeserializedClassDescriptor.this;
        }

        @NotNull
        public String toString() {
            return DeserializedClassDescriptor.this.getName().toString();
        }

        @Override
        @NotNull
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }

        public DeserializedClassTypeConstructor() {
            super(DeserializedClassDescriptor.this.getC().getStorageManager());
            this.parameters = DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue((Function0)new Function0<List<? extends TypeParameterDescriptor>>(this){
                final /* synthetic */ DeserializedClassTypeConstructor this$0;

                @NotNull
                public final List<TypeParameterDescriptor> invoke() {
                    return TypeParameterUtilsKt.computeConstructorTypeParameters(this.this$0.DeserializedClassDescriptor.this);
                }
                {
                    this.this$0 = deserializedClassTypeConstructor;
                    super(0);
                }
            });
        }
    }

    private final class DeserializedClassMemberScope
    extends DeserializedMemberScope {
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;

        private final DeserializedClassDescriptor getClassDescriptor() {
            return DeserializedClassDescriptor.this;
        }

        @Override
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
            Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
            Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
            return (Collection)this.allDescriptors.invoke();
        }

        @Override
        @NotNull
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(location, "location");
            this.recordLookup(name2, location);
            return super.getContributedFunctions(name2, location);
        }

        @Override
        @NotNull
        public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(location, "location");
            this.recordLookup(name2, location);
            return super.getContributedVariables(name2, location);
        }

        @Override
        protected void computeNonDeclaredFunctions(@NotNull Name name2, @NotNull Collection<SimpleFunctionDescriptor> functions2) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(functions2, "functions");
            ArrayList<SimpleFunctionDescriptor> fromSupertypes = new ArrayList<SimpleFunctionDescriptor>();
            for (KotlinType supertype : this.getClassDescriptor().getTypeConstructor().getSupertypes()) {
                fromSupertypes.addAll(supertype.getMemberScope().getContributedFunctions(name2, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            CollectionsKt.retainAll((Iterable)functions2, (Function1)new Function1<SimpleFunctionDescriptor, Boolean>(this){
                final /* synthetic */ DeserializedClassMemberScope this$0;

                public final boolean invoke(@NotNull SimpleFunctionDescriptor it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    return this.this$0.getC().getComponents().getPlatformDependentDeclarationFilter().isFunctionAvailable(this.this$0.DeserializedClassDescriptor.this, it);
                }
                {
                    this.this$0 = deserializedClassMemberScope;
                    super(1);
                }
            });
            functions2.addAll(this.getC().getComponents().getAdditionalClassPartsProvider().getFunctions(name2, DeserializedClassDescriptor.this));
            this.generateFakeOverrides(name2, (Collection)fromSupertypes, functions2);
        }

        @Override
        protected void computeNonDeclaredProperties(@NotNull Name name2, @NotNull Collection<PropertyDescriptor> descriptors) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(descriptors, "descriptors");
            ArrayList<PropertyDescriptor> fromSupertypes = new ArrayList<PropertyDescriptor>();
            for (KotlinType supertype : this.getClassDescriptor().getTypeConstructor().getSupertypes()) {
                fromSupertypes.addAll(supertype.getMemberScope().getContributedVariables(name2, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            this.generateFakeOverrides(name2, (Collection)fromSupertypes, descriptors);
        }

        private final <D extends CallableMemberDescriptor> void generateFakeOverrides(Name name2, Collection<? extends D> fromSupertypes, Collection<D> result2) {
            ArrayList<D> fromCurrent = new ArrayList<D>(result2);
            OverridingUtil.generateOverridesInFunctionGroup(name2, fromSupertypes, (Collection<? extends CallableMemberDescriptor>)fromCurrent, this.getClassDescriptor(), new NonReportingOverrideStrategy(result2){
                final /* synthetic */ Collection $result;

                public void addFakeOverride(@NotNull CallableMemberDescriptor fakeOverride) {
                    Intrinsics.checkParameterIsNotNull(fakeOverride, "fakeOverride");
                    OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, null);
                    CallableMemberDescriptor callableMemberDescriptor = fakeOverride;
                    if (callableMemberDescriptor == null) {
                        throw new TypeCastException("null cannot be cast to non-null type D");
                    }
                    this.$result.add(callableMemberDescriptor);
                }

                protected void conflict(@NotNull CallableMemberDescriptor fromSuper, @NotNull CallableMemberDescriptor fromCurrent) {
                    Intrinsics.checkParameterIsNotNull(fromSuper, "fromSuper");
                    Intrinsics.checkParameterIsNotNull(fromCurrent, "fromCurrent");
                }
                {
                    this.$result = $captured_local_variable$0;
                }
            });
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        protected Set<Name> getNonDeclaredFunctionNames() {
            void $receiver$iv;
            Iterable iterable = this.getClassDescriptor().typeConstructor.getSupertypes();
            Collection destination$iv = new LinkedHashSet();
            for (Object element$iv : $receiver$iv) {
                KotlinType it = (KotlinType)element$iv;
                Iterable list$iv = it.getMemberScope().getFunctionNames();
                CollectionsKt.addAll(destination$iv, list$iv);
            }
            iterable = destination$iv;
            LinkedHashSet $receiver = (LinkedHashSet)iterable;
            $receiver.addAll(this.getC().getComponents().getAdditionalClassPartsProvider().getFunctionsNames(DeserializedClassDescriptor.this));
            return (Set)iterable;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        protected Set<Name> getNonDeclaredVariableNames() {
            void var2_2;
            void $receiver$iv;
            Iterable iterable = this.getClassDescriptor().typeConstructor.getSupertypes();
            Collection destination$iv = new LinkedHashSet();
            for (Object element$iv : $receiver$iv) {
                KotlinType it = (KotlinType)element$iv;
                Iterable list$iv = it.getMemberScope().getVariableNames();
                CollectionsKt.addAll(destination$iv, list$iv);
            }
            return (Set)var2_2;
        }

        @Override
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(location, "location");
            this.recordLookup(name2, location);
            Object object = this.getClassDescriptor().enumEntries;
            if (object != null && (object = ((EnumEntryClassDescriptors)object).findEnumEntry(name2)) != null) {
                Object object2 = object;
                ClassDescriptor it = (ClassDescriptor)object2;
                return it;
            }
            return super.getContributedClassifier(name2, location);
        }

        @Override
        @NotNull
        protected ClassId createClassId(@NotNull Name name2) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            return DeserializedClassDescriptor.this.classId.createNestedClassId(name2);
        }

        @Override
        protected void addEnumEntryDescriptors(@NotNull Collection<DeclarationDescriptor> result2, @NotNull Function1<? super Name, Boolean> nameFilter) {
            Intrinsics.checkParameterIsNotNull(result2, "result");
            Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
            EnumEntryClassDescriptors enumEntryClassDescriptors = this.getClassDescriptor().enumEntries;
            Collection collection = enumEntryClassDescriptors != null ? enumEntryClassDescriptors.all() : null;
            Collection<DeclarationDescriptor> collection2 = result2;
            Collection collection3 = collection;
            if (collection3 == null) {
                collection3 = CollectionsKt.emptyList();
            }
            Collection collection4 = collection3;
            collection2.addAll(collection4);
        }

        private final void recordLookup(Name name2, LookupLocation from) {
            UtilsKt.record(this.getC().getComponents().getLookupTracker(), from, this.getClassDescriptor(), name2);
        }

        /*
         * WARNING - void declaration
         */
        public DeserializedClassMemberScope() {
            Object object;
            void $receiver$iv$iv;
            void $receiver$iv;
            DeserializationContext deserializationContext = DeserializedClassDescriptor.this.getC();
            List<ProtoBuf.Function> list = DeserializedClassDescriptor.this.getClassProto().getFunctionList();
            Intrinsics.checkExpressionValueIsNotNull(list, "classProto.functionList");
            Collection collection = list;
            List<ProtoBuf.Property> list2 = DeserializedClassDescriptor.this.getClassProto().getPropertyList();
            Intrinsics.checkExpressionValueIsNotNull(list2, "classProto.propertyList");
            Collection collection2 = list2;
            List<ProtoBuf.TypeAlias> list3 = DeserializedClassDescriptor.this.getClassProto().getTypeAliasList();
            Intrinsics.checkExpressionValueIsNotNull(list3, "classProto.typeAliasList");
            Iterable iterable = DeserializedClassDescriptor.this.getClassProto().getNestedClassNameList();
            NameResolver nameResolver = DeserializedClassDescriptor.this.getC().getNameResolver();
            Collection collection3 = list3;
            Collection collection4 = collection2;
            Collection collection5 = collection;
            DeserializationContext deserializationContext2 = deserializationContext;
            DeserializedClassMemberScope deserializedClassMemberScope = this;
            void var9_9 = $receiver$iv;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
            for (Object item$iv$iv : $receiver$iv$iv) {
                void p1;
                int n = ((Number)item$iv$iv).intValue();
                object = destination$iv$iv;
                Name name2 = nameResolver.getName((int)p1);
                object.add(name2);
            }
            object = (List)destination$iv$iv;
            iterable = object;
            List it = (List)iterable;
            object = new Function0<List<? extends Name>>(it){
                final /* synthetic */ List $it;

                @NotNull
                public final List<Name> invoke() {
                    return this.$it;
                }
                {
                    this.$it = list;
                    super(0);
                }
            };
            super(deserializationContext2, collection5, collection4, collection3, (Function0)object);
            this.allDescriptors = this.getC().getStorageManager().createLazyValue((Function0)new Function0<Collection<? extends DeclarationDescriptor>>(this){
                final /* synthetic */ DeserializedClassMemberScope this$0;

                @NotNull
                public final Collection<DeclarationDescriptor> invoke() {
                    return this.this$0.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                }
                {
                    this.this$0 = deserializedClassMemberScope;
                    super(0);
                }
            });
        }
    }

    private final class EnumEntryClassDescriptors {
        private final Map<Name, ProtoBuf.EnumEntry> enumEntryProtos;
        private final MemoizedFunctionToNullable<Name, ClassDescriptor> enumEntryByName;
        private final NotNullLazyValue<Set<Name>> enumMemberNames;

        @Nullable
        public final ClassDescriptor findEnumEntry(@NotNull Name name2) {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            return (ClassDescriptor)this.enumEntryByName.invoke(name2);
        }

        private final Set<Name> computeEnumMemberNames() {
            Object object;
            ProtoBuf.Property it;
            Collection collection;
            HashSet<Name> result2 = new HashSet<Name>();
            for (KotlinType supertype : DeserializedClassDescriptor.this.getTypeConstructor().getSupertypes()) {
                for (DeclarationDescriptor descriptor2 : ResolutionScope.DefaultImpls.getContributedDescriptors$default(supertype.getMemberScope(), null, null, 3, null)) {
                    if (!(descriptor2 instanceof SimpleFunctionDescriptor) && !(descriptor2 instanceof PropertyDescriptor)) continue;
                    result2.add(descriptor2.getName());
                }
            }
            Iterable $receiver$iv = DeserializedClassDescriptor.this.getClassProto().getFunctionList();
            for (KotlinType item$iv : $receiver$iv) {
                ProtoBuf.Function function = (ProtoBuf.Function)((Object)item$iv);
                collection = result2;
                Intrinsics.checkExpressionValueIsNotNull(DeserializedClassDescriptor.this.getC().getNameResolver().getName(((ProtoBuf.Function)((Object)it)).getName()), "c.nameResolver.getName(it.name)");
                collection.add(object);
            }
            $receiver$iv = DeserializedClassDescriptor.this.getClassProto().getPropertyList();
            collection = (Set)((Collection)result2);
            for (KotlinType item$iv : $receiver$iv) {
                Name name2;
                it = (ProtoBuf.Property)((Object)item$iv);
                object = result2;
                Intrinsics.checkExpressionValueIsNotNull(DeserializedClassDescriptor.this.getC().getNameResolver().getName(it.getName()), "c.nameResolver.getName(it.name)");
                object.add(name2);
            }
            object = result2;
            return SetsKt.plus(collection, (Iterable)object);
        }

        /*
         * WARNING - void declaration
         */
        @NotNull
        public final Collection<ClassDescriptor> all() {
            void var3_3;
            void $receiver$iv$iv;
            Iterable $receiver$iv;
            Iterable iterable = $receiver$iv = (Iterable)this.enumEntryProtos.keySet();
            Collection destination$iv$iv = new ArrayList();
            void $receiver$iv$iv$iv = $receiver$iv$iv;
            Iterator iterator2 = $receiver$iv$iv$iv.iterator();
            while (iterator2.hasNext()) {
                ClassDescriptor classDescriptor;
                Name name2;
                Object element$iv$iv$iv;
                Object element$iv$iv = element$iv$iv$iv = iterator2.next();
                Name name3 = name2 = (Name)element$iv$iv;
                Intrinsics.checkExpressionValueIsNotNull(name3, "name");
                if (this.findEnumEntry(name3) == null) continue;
                ClassDescriptor it$iv$iv = classDescriptor;
                destination$iv$iv.add(it$iv$iv);
            }
            return (List)var3_3;
        }

        /*
         * WARNING - void declaration
         */
        public EnumEntryClassDescriptors() {
            Map map2;
            void $receiver$iv$iv;
            Iterable $receiver$iv = DeserializedClassDescriptor.this.getClassProto().getEnumEntryList();
            EnumEntryClassDescriptors enumEntryClassDescriptors = this;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10)), 16);
            Iterable iterable = $receiver$iv;
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (Object element$iv$iv : $receiver$iv$iv) {
                void it;
                ProtoBuf.EnumEntry enumEntry = (ProtoBuf.EnumEntry)element$iv$iv;
                map2 = destination$iv$iv;
                Name name2 = DeserializedClassDescriptor.this.getC().getNameResolver().getName(it.getName());
                map2.put(name2, element$iv$iv);
            }
            enumEntryClassDescriptors.enumEntryProtos = map2 = destination$iv$iv;
            this.enumEntryByName = DeserializedClassDescriptor.this.getC().getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new Function1<Name, EnumEntrySyntheticClassDescriptor>(this){
                final /* synthetic */ EnumEntryClassDescriptors this$0;

                @Nullable
                public final EnumEntrySyntheticClassDescriptor invoke(@NotNull Name name2) {
                    EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor;
                    Intrinsics.checkParameterIsNotNull(name2, "name");
                    ProtoBuf.EnumEntry enumEntry = (ProtoBuf.EnumEntry)EnumEntryClassDescriptors.access$getEnumEntryProtos$p(this.this$0).get(name2);
                    if (enumEntry != null) {
                        ProtoBuf.EnumEntry enumEntry2;
                        ProtoBuf.EnumEntry proto = enumEntry2 = enumEntry;
                        enumEntrySyntheticClassDescriptor = EnumEntrySyntheticClassDescriptor.create(this.this$0.DeserializedClassDescriptor.this.getC().getStorageManager(), this.this$0.DeserializedClassDescriptor.this, name2, EnumEntryClassDescriptors.access$getEnumMemberNames$p(this.this$0), new DeserializedAnnotations(this.this$0.DeserializedClassDescriptor.this.getC().getStorageManager(), (Function0<? extends List<? extends AnnotationDescriptor>>)new Function0<List<? extends AnnotationDescriptor>>(proto, this, name2){
                            final /* synthetic */ ProtoBuf.EnumEntry $proto;
                            final /* synthetic */ enumEntryByName.1 this$0;
                            final /* synthetic */ Name $name$inlined;
                            {
                                this.$proto = enumEntry;
                                this.this$0 = var2_2;
                                this.$name$inlined = name2;
                                super(0);
                            }

                            public final List<AnnotationDescriptor> invoke() {
                                return this.this$0.this$0.DeserializedClassDescriptor.this.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(this.this$0.this$0.DeserializedClassDescriptor.this.getThisAsProtoContainer$kotlin_core(), this.$proto);
                            }
                        }), SourceElement.NO_SOURCE);
                    } else {
                        enumEntrySyntheticClassDescriptor = null;
                    }
                    return enumEntrySyntheticClassDescriptor;
                }
                {
                    this.this$0 = enumEntryClassDescriptors;
                    super(1);
                }
            });
            this.enumMemberNames = DeserializedClassDescriptor.this.getC().getStorageManager().createLazyValue((Function0)new Function0<Set<? extends Name>>(this){
                final /* synthetic */ EnumEntryClassDescriptors this$0;

                @NotNull
                public final Set<Name> invoke() {
                    return EnumEntryClassDescriptors.access$computeEnumMemberNames(this.this$0);
                }
                {
                    this.this$0 = enumEntryClassDescriptors;
                    super(0);
                }
            });
        }

        @NotNull
        public static final /* synthetic */ Map access$getEnumEntryProtos$p(EnumEntryClassDescriptors $this) {
            return $this.enumEntryProtos;
        }

        @NotNull
        public static final /* synthetic */ NotNullLazyValue access$getEnumMemberNames$p(EnumEntryClassDescriptors $this) {
            return $this.enumMemberNames;
        }

        @NotNull
        public static final /* synthetic */ Set access$computeEnumMemberNames(EnumEntryClassDescriptors $this) {
            return $this.computeEnumMemberNames();
        }
    }
}

