/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.FakePureImplementationsProvider;
import kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.platform.MappingUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.InnerClassesScopeWrapper;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.addToStdlib.AddToStdlibKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaClassDescriptor
extends ClassDescriptorBase
implements JavaClassDescriptor {
    private final LazyJavaResolverContext c;
    private final ClassKind kind;
    private final Modality modality;
    private final Visibility visibility;
    private final boolean isInner;
    private final NotNullLazyValue<LazyJavaClassTypeConstructor> typeConstructor;
    private final LazyJavaClassMemberScope unsubstitutedMemberScope;
    private final InnerClassesScopeWrapper innerClassesScope;
    private final LazyJavaStaticClassScope staticScope;
    @NotNull
    private final NotNullLazyValue annotations$delegate;
    private final NotNullLazyValue<List<TypeParameterDescriptor>> declaredParameters;
    @NotNull
    private final LazyJavaResolverContext outerContext;
    private final JavaClass jClass;
    private final ClassDescriptor additionalSupertypeClassDescriptor;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

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
        return Intrinsics.areEqual(this.visibility, Visibilities.PRIVATE) && this.jClass.getOuterClass() == null ? JavaVisibilities.PACKAGE_VISIBILITY : this.visibility;
    }

    @Override
    public boolean isInner() {
        return this.isInner;
    }

    @Override
    public boolean isData() {
        return false;
    }

    @Override
    public boolean isCompanionObject() {
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
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return (TypeConstructor)this.typeConstructor.invoke();
    }

    @Override
    @NotNull
    public LazyJavaClassMemberScope getUnsubstitutedMemberScope() {
        return this.unsubstitutedMemberScope;
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedInnerClassesScope() {
        return this.innerClassesScope;
    }

    @Override
    @NotNull
    public MemberScope getStaticScope() {
        return this.staticScope;
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

    @NotNull
    public List<ClassConstructorDescriptor> getConstructors() {
        return (List)this.unsubstitutedMemberScope.getConstructors$kotlin_core().invoke();
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        return (Annotations)StorageKt.getValue(this.annotations$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return (List)this.declaredParameters.invoke();
    }

    @Override
    @Nullable
    public SimpleType getFunctionTypeForSamInterface() {
        return this.c.getComponents().getSamConversionResolver().resolveFunctionTypeIfSamInterface(this);
    }

    @Override
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        return CollectionsKt.emptyList();
    }

    @NotNull
    public String toString() {
        return "Lazy Java class " + DescriptorUtilsKt.getFqNameUnsafe(this);
    }

    @NotNull
    public final LazyJavaClassDescriptor copy$kotlin_core(@NotNull JavaResolverCache javaResolverCache, @Nullable ClassDescriptor additionalSupertypeClassDescriptor) {
        Intrinsics.checkParameterIsNotNull(javaResolverCache, "javaResolverCache");
        LazyJavaResolverContext lazyJavaResolverContext = ContextKt.replaceComponents(this.c, this.c.getComponents().replace(javaResolverCache));
        DeclarationDescriptor declarationDescriptor = this.getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(declarationDescriptor, "containingDeclaration");
        return new LazyJavaClassDescriptor(lazyJavaResolverContext, declarationDescriptor, this.jClass, additionalSupertypeClassDescriptor);
    }

    @NotNull
    public final LazyJavaResolverContext getOuterContext() {
        return this.outerContext;
    }

    public LazyJavaClassDescriptor(@NotNull LazyJavaResolverContext outerContext, @NotNull DeclarationDescriptor containingDeclaration, @NotNull JavaClass jClass, @Nullable ClassDescriptor additionalSupertypeClassDescriptor) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(outerContext, "outerContext");
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(jClass, "jClass");
        super(outerContext.getStorageManager(), containingDeclaration, jClass.getName(), outerContext.getComponents().getSourceElementFactory().source(jClass), false);
        this.outerContext = outerContext;
        this.jClass = jClass;
        this.additionalSupertypeClassDescriptor = additionalSupertypeClassDescriptor;
        this.c = ContextKt.child$default(this.outerContext, this, this.jClass, 0, 4, null);
        this.c.getComponents().getJavaResolverCache().recordClass(this.jClass, this);
        boolean bl2 = bl = this.jClass.getLightClassOriginKind() == null;
        if (_Assertions.ENABLED && !bl) {
            String string = "Creating LazyJavaClassDescriptor for light class " + this.jClass;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        ClassKind classKind = this.jClass.isAnnotationType() ? ClassKind.ANNOTATION_CLASS : (this.jClass.isInterface() ? ClassKind.INTERFACE : (this.kind = this.jClass.isEnum() ? ClassKind.ENUM_CLASS : ClassKind.CLASS));
        this.modality = this.jClass.isAnnotationType() ? Modality.FINAL : Modality.Companion.convertFromFlags(this.jClass.isAbstract() || this.jClass.isInterface(), !this.jClass.isFinal());
        this.visibility = this.jClass.getVisibility();
        this.isInner = this.jClass.getOuterClass() != null && !this.jClass.isStatic();
        this.typeConstructor = this.c.getStorageManager().createLazyValue((Function0)new Function0<LazyJavaClassTypeConstructor>(this){
            final /* synthetic */ LazyJavaClassDescriptor this$0;

            @NotNull
            public final LazyJavaClassTypeConstructor invoke() {
                return this.this$0.new LazyJavaClassTypeConstructor();
            }
            {
                this.this$0 = lazyJavaClassDescriptor;
                super(0);
            }
        });
        this.unsubstitutedMemberScope = new LazyJavaClassMemberScope(this.c, this, this.jClass);
        this.innerClassesScope = new InnerClassesScopeWrapper(this.getUnsubstitutedMemberScope());
        this.staticScope = new LazyJavaStaticClassScope(this.c, this.jClass, this);
        this.annotations$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<Annotations>(this){
            final /* synthetic */ LazyJavaClassDescriptor this$0;

            @NotNull
            public final Annotations invoke() {
                return LazyJavaAnnotationsKt.resolveAnnotations(LazyJavaClassDescriptor.access$getC$p(this.this$0), LazyJavaClassDescriptor.access$getJClass$p(this.this$0));
            }
            {
                this.this$0 = lazyJavaClassDescriptor;
                super(0);
            }
        });
        this.declaredParameters = this.c.getStorageManager().createLazyValue((Function0)new Function0<List<? extends TypeParameterDescriptor>>(this){
            final /* synthetic */ LazyJavaClassDescriptor this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<TypeParameterDescriptor> invoke() {
                void var3_3;
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)LazyJavaClassDescriptor.access$getJClass$p(this.this$0).getTypeParameters();
                Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (T item$iv$iv : $receiver$iv$iv) {
                    TypeParameterDescriptor typeParameterDescriptor;
                    void p;
                    JavaTypeParameter javaTypeParameter = (JavaTypeParameter)item$iv$iv;
                    Collection collection = destination$iv$iv;
                    if (LazyJavaClassDescriptor.access$getC$p(this.this$0).getTypeParameterResolver().resolveTypeParameter((JavaTypeParameter)p) == null) {
                        throw (Throwable)((Object)new AssertionError((Object)("Parameter " + p + " surely belongs to class " + LazyJavaClassDescriptor.access$getJClass$p(this.this$0) + ", so it must be resolved")));
                    }
                    collection.add(typeParameterDescriptor);
                }
                return (List)var3_3;
            }
            {
                this.this$0 = lazyJavaClassDescriptor;
                super(0);
            }
        });
    }

    public /* synthetic */ LazyJavaClassDescriptor(LazyJavaResolverContext lazyJavaResolverContext, DeclarationDescriptor declarationDescriptor, JavaClass javaClass, ClassDescriptor classDescriptor, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            classDescriptor = null;
        }
        this(lazyJavaResolverContext, declarationDescriptor, javaClass, classDescriptor);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyJavaClassDescriptor.class), "annotations", "getAnnotations()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};
    }

    private final class LazyJavaClassTypeConstructor
    extends AbstractClassTypeConstructor {
        private final NotNullLazyValue<List<TypeParameterDescriptor>> parameters;

        @Override
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return (List)this.parameters.invoke();
        }

        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        protected Collection<KotlinType> computeSupertypes() {
            Collection collection;
            KotlinType kotlinType;
            Annotated annotated;
            Object it;
            Object object;
            Collection<JavaClassifierType> javaTypes = LazyJavaClassDescriptor.this.jClass.getSupertypes();
            ArrayList<KotlinType> result2 = new ArrayList<KotlinType>(javaTypes.size());
            ArrayList<JavaClassifierType> incomplete = new ArrayList<JavaClassifierType>(0);
            KotlinType purelyImplementedSupertype = this.getPurelyImplementedSupertype();
            for (JavaClassifierType collection2 : javaTypes) {
                KotlinType kotlinType2 = LazyJavaClassDescriptor.this.c.getTypeResolver().transformJavaType(collection2, JavaTypeResolverKt.toAttributes$default(TypeUsage.SUPERTYPE, false, false, null, 7, null));
                if (kotlinType2.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor) {
                    incomplete.add(collection2);
                }
                KotlinType kotlinType3 = purelyImplementedSupertype;
                if (Intrinsics.areEqual(kotlinType2.getConstructor(), kotlinType3 != null ? kotlinType3.getConstructor() : null) || KotlinBuiltIns.isAnyOrNullableAny(kotlinType2)) continue;
                result2.add(kotlinType2);
            }
            Collection collection3 = result2;
            ClassDescriptor classDescriptor = LazyJavaClassDescriptor.this.additionalSupertypeClassDescriptor;
            if (classDescriptor != null) {
                ClassDescriptor classDescriptor2 = classDescriptor;
                object = collection3;
                it = classDescriptor2;
                annotated = MappingUtilKt.createMappedTypeParametersSubstitution((ClassDescriptor)it, LazyJavaClassDescriptor.this).buildSubstitutor().substitute(it.getDefaultType(), Variance.INVARIANT);
                collection3 = object;
                kotlinType = annotated;
            } else {
                kotlinType = null;
            }
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(collection3, kotlinType);
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull((Collection)result2, purelyImplementedSupertype);
            Collection collection4 = incomplete;
            if (!collection4.isEmpty()) {
                Collection<String> collection5;
                void $receiver$iv$iv;
                Iterable iterable = incomplete;
                annotated = this.getDeclarationDescriptor();
                object = LazyJavaClassDescriptor.this.c.getComponents().getErrorReporter();
                it = iterable;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Object item$iv$iv : $receiver$iv$iv) {
                    void javaType3;
                    JavaType javaType = (JavaType)item$iv$iv;
                    collection5 = destination$iv$iv;
                    void v4 = javaType3;
                    if (v4 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.JavaClassifierType");
                    }
                    String string = ((JavaClassifierType)v4).getPresentableText();
                    collection5.add(string);
                }
                collection5 = (List)destination$iv$iv;
                object.reportIncompleteHierarchy((ClassDescriptor)annotated, (List<String>)collection5);
            }
            return !(collection = (Collection)result2).isEmpty() ? (Collection)kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((Collection)result2) : (Collection)CollectionsKt.listOf(LazyJavaClassDescriptor.this.c.getModule().getBuiltIns().getAnyType());
        }

        /*
         * WARNING - void declaration
         */
        private final KotlinType getPurelyImplementedSupertype() {
            List list;
            TypeProjectionImpl typeProjectionImpl;
            Collection collection;
            Iterable destination$iv$iv;
            FqName fqName2 = this.getPurelyImplementsFqNameFromAnnotation();
            FqName annotatedPurelyImplementedFqName2 = fqName2 != null ? AddToStdlibKt.check(fqName2, getPurelyImplementedSupertype.annotatedPurelyImplementedFqName.1.INSTANCE) : null;
            FqName fqName3 = annotatedPurelyImplementedFqName2;
            if (fqName3 == null) {
                fqName3 = FakePureImplementationsProvider.INSTANCE.getPurelyImplementedInterface(DescriptorUtilsKt.getFqNameSafe(LazyJavaClassDescriptor.this));
            }
            if (fqName3 == null) {
                return null;
            }
            FqName purelyImplementedFqName = fqName3;
            ClassDescriptor classDescriptor = DescriptorUtilsKt.resolveTopLevelClass(LazyJavaClassDescriptor.this.c.getModule(), purelyImplementedFqName, NoLookupLocation.FROM_JAVA_LOADER);
            if (classDescriptor == null) {
                return null;
            }
            ClassDescriptor classDescriptor2 = classDescriptor;
            int supertypeParameterCount = classDescriptor2.getTypeConstructor().getParameters().size();
            List<TypeParameterDescriptor> typeParameters2 = LazyJavaClassDescriptor.this.getTypeConstructor().getParameters();
            int typeParameterCount = typeParameters2.size();
            if (typeParameterCount == supertypeParameterCount) {
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)typeParameters2;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                for (Object item$iv$iv : $receiver$iv$iv) {
                    void parameter;
                    TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
                    collection = destination$iv$iv;
                    typeProjectionImpl = new TypeProjectionImpl(Variance.INVARIANT, parameter.getDefaultType());
                    collection.add(typeProjectionImpl);
                }
                list = (List)destination$iv$iv;
            } else if (typeParameterCount == 1 && supertypeParameterCount > 1 && annotatedPurelyImplementedFqName2 == null) {
                void $receiver$iv$iv;
                TypeProjectionImpl parameter = new TypeProjectionImpl(Variance.INVARIANT, CollectionsKt.single(typeParameters2).getDefaultType());
                Iterable $receiver$iv = new IntRange(1, supertypeParameterCount);
                destination$iv$iv = $receiver$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                Iterator iterator2 = $receiver$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    int item$iv$iv;
                    int $i$a$1$map = item$iv$iv = ((IntIterator)iterator2).nextInt();
                    collection = destination$iv$iv2;
                    typeProjectionImpl = parameter;
                    collection.add(typeProjectionImpl);
                }
                list = (List)destination$iv$iv2;
            } else {
                return null;
            }
            List parametersAsTypeProjections = list;
            return KotlinTypeFactory.simpleNotNullType(Annotations.Companion.getEMPTY(), classDescriptor2, parametersAsTypeProjections);
        }

        private final FqName getPurelyImplementsFqNameFromAnnotation() {
            Object object;
            Annotations annotations2 = LazyJavaClassDescriptor.this.getAnnotations();
            FqName fqName2 = JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION;
            Intrinsics.checkExpressionValueIsNotNull(fqName2, "JvmAnnotationNames.PURELY_IMPLEMENTS_ANNOTATION");
            AnnotationDescriptor annotationDescriptor = annotations2.findAnnotation(fqName2);
            if (annotationDescriptor == null) {
                return null;
            }
            AnnotationDescriptor annotation = annotationDescriptor;
            Object t = CollectionsKt.singleOrNull((Iterable)annotation.getAllValueArguments().values());
            if (!(t instanceof StringValue)) {
                t = null;
            }
            if ((object = (StringValue)t) == null || (object = (String)((ConstantValue)object).getValue()) == null) {
                return null;
            }
            Object fqNameString = object;
            if (!FqNamesUtilKt.isValidJavaFqName((String)fqNameString)) {
                return null;
            }
            return new FqName((String)fqNameString);
        }

        @Override
        @NotNull
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return LazyJavaClassDescriptor.this.c.getComponents().getSupertypeLoopChecker();
        }

        @Override
        public boolean isFinal() {
            return ModalityKt.isFinalClass(LazyJavaClassDescriptor.this);
        }

        @Override
        public boolean isDenotable() {
            return true;
        }

        @Override
        @NotNull
        public LazyJavaClassDescriptor getDeclarationDescriptor() {
            return LazyJavaClassDescriptor.this;
        }

        @NotNull
        public String toString() {
            String string = LazyJavaClassDescriptor.this.getName().asString();
            Intrinsics.checkExpressionValueIsNotNull(string, "getName().asString()");
            return string;
        }

        public LazyJavaClassTypeConstructor() {
            super(LazyJavaClassDescriptor.this.c.getStorageManager());
            this.parameters = LazyJavaClassDescriptor.this.c.getStorageManager().createLazyValue((Function0)new Function0<List<? extends TypeParameterDescriptor>>(this){
                final /* synthetic */ LazyJavaClassTypeConstructor this$0;

                @NotNull
                public final List<TypeParameterDescriptor> invoke() {
                    return TypeParameterUtilsKt.computeConstructorTypeParameters(this.this$0.LazyJavaClassDescriptor.this);
                }
                {
                    this.this$0 = lazyJavaClassTypeConstructor;
                    super(0);
                }
            });
        }
    }
}

