/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassScope;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractClassTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FunctionClassDescriptor
extends AbstractClassDescriptor {
    private final FunctionTypeConstructor typeConstructor;
    private final FunctionClassScope memberScope;
    private final List<TypeParameterDescriptor> parameters;
    private final StorageManager storageManager;
    private final PackageFragmentDescriptor containingDeclaration;
    @NotNull
    private final Kind functionKind;
    private final int arity;

    @Override
    @NotNull
    public PackageFragmentDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @Override
    @NotNull
    public MemberScope.Empty getStaticScope() {
        return MemberScope.Empty.INSTANCE;
    }

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override
    @NotNull
    public FunctionClassScope getUnsubstitutedMemberScope() {
        return this.memberScope;
    }

    @Nullable
    public Void getCompanionObjectDescriptor() {
        return null;
    }

    @NotNull
    public List<ClassConstructorDescriptor> getConstructors() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public ClassKind getKind() {
        return ClassKind.INTERFACE;
    }

    @Override
    @NotNull
    public Modality getModality() {
        return Modality.ABSTRACT;
    }

    @Nullable
    public Void getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        return Visibilities.PUBLIC;
    }

    @Override
    public boolean isCompanionObject() {
        return false;
    }

    @Override
    public boolean isInner() {
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
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
        return sourceElement;
    }

    @NotNull
    public List<ClassDescriptor> getSealedSubclasses() {
        return CollectionsKt.emptyList();
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        return this.parameters;
    }

    @NotNull
    public String toString() {
        return this.getName().asString();
    }

    @NotNull
    public final Kind getFunctionKind() {
        return this.functionKind;
    }

    public final int getArity() {
        return this.arity;
    }

    /*
     * WARNING - void declaration
     */
    public FunctionClassDescriptor(@NotNull StorageManager storageManager, @NotNull PackageFragmentDescriptor containingDeclaration, @NotNull Kind functionKind, int arity) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull((Object)functionKind, "functionKind");
        super(storageManager, functionKind.numberedClassName(arity));
        this.storageManager = storageManager;
        this.containingDeclaration = containingDeclaration;
        this.functionKind = functionKind;
        this.arity = arity;
        this.typeConstructor = new FunctionTypeConstructor();
        this.memberScope = new FunctionClassScope(this.storageManager, this);
        final ArrayList result2 = new ArrayList();
        Function2<Variance, String, Unit> typeParameter$ = new Function2<Variance, String, Unit>(){

            @Override
            public final void invoke(@NotNull Variance variance, @NotNull String name2) {
                Intrinsics.checkParameterIsNotNull((Object)variance, "variance");
                Intrinsics.checkParameterIsNotNull(name2, "name");
                result2.add(TypeParameterDescriptorImpl.createWithDefaultBound(this, Annotations.Companion.getEMPTY(), false, variance, Name.identifier(name2), result2.size()));
            }
        };
        Iterable iterable = $receiver$iv = (Iterable)new IntRange(1, this.arity);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        Iterator iterator2 = $receiver$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void i;
            int item$iv$iv;
            int n = item$iv$iv = ((IntIterator)iterator2).nextInt();
            Collection collection = destination$iv$iv;
            typeParameter$.invoke(Variance.IN_VARIANCE, "P" + (int)i);
            Unit unit = Unit.INSTANCE;
            collection.add(unit);
        }
        List cfr_ignored_0 = (List)destination$iv$iv;
        typeParameter$.invoke(Variance.OUT_VARIANCE, "R");
        this.parameters = kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList(result2);
    }

    public static final class Kind
    extends Enum<Kind> {
        public static final /* enum */ Kind Function;
        public static final /* enum */ Kind SuspendFunction;
        public static final /* enum */ Kind KFunction;
        private static final /* synthetic */ Kind[] $VALUES;
        @NotNull
        private final FqName packageFqName;
        @NotNull
        private final String classNamePrefix;
        public static final Companion Companion;

        static {
            Kind[] kindArray = new Kind[3];
            Kind[] kindArray2 = kindArray;
            FqName fqName2 = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
            Intrinsics.checkExpressionValueIsNotNull(fqName2, "BUILT_INS_PACKAGE_FQ_NAME");
            kindArray[0] = Function = new Kind(fqName2, "Function");
            FqName fqName3 = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
            Intrinsics.checkExpressionValueIsNotNull(fqName3, "BUILT_INS_PACKAGE_FQ_NAME");
            kindArray[1] = SuspendFunction = new Kind(fqName3, "SuspendFunction");
            kindArray[2] = KFunction = new Kind(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), "KFunction");
            $VALUES = kindArray;
            Companion = new Companion(null);
        }

        @NotNull
        public final Name numberedClassName(int arity) {
            return Name.identifier(this.classNamePrefix + arity);
        }

        @NotNull
        public final FqName getPackageFqName() {
            return this.packageFqName;
        }

        @NotNull
        public final String getClassNamePrefix() {
            return this.classNamePrefix;
        }

        protected Kind(FqName packageFqName, String classNamePrefix) {
            Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
            Intrinsics.checkParameterIsNotNull(classNamePrefix, "classNamePrefix");
            this.packageFqName = packageFqName;
            this.classNamePrefix = classNamePrefix;
        }

        public static Kind[] values() {
            return (Kind[])$VALUES.clone();
        }

        public static Kind valueOf(String string) {
            return Enum.valueOf(Kind.class, string);
        }

        public static final class Companion {
            @Nullable
            public final Kind byClassNamePrefix(@NotNull FqName packageFqName, @NotNull String className) {
                Object object;
                block1: {
                    Intrinsics.checkParameterIsNotNull(packageFqName, "packageFqName");
                    Intrinsics.checkParameterIsNotNull(className, "className");
                    Object[] $receiver$iv = (Object[])Kind.values();
                    for (int i = 0; i < $receiver$iv.length; ++i) {
                        Object element$iv = $receiver$iv[i];
                        Kind it = (Kind)((Object)element$iv);
                        if (!(Intrinsics.areEqual(it.getPackageFqName(), packageFqName) && StringsKt.startsWith$default(className, it.getClassNamePrefix(), false, 2, null))) continue;
                        object = element$iv;
                        break block1;
                    }
                    object = null;
                }
                return (Kind)((Object)object);
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    private final class FunctionTypeConstructor
    extends AbstractClassTypeConstructor {
        /*
         * WARNING - void declaration
         */
        @Override
        @NotNull
        protected Collection<KotlinType> computeSupertypes() {
            ArrayList<SimpleType> result2 = new ArrayList<SimpleType>(2);
            Function2<PackageFragmentDescriptor, Name, Unit> add$ = new Function2<PackageFragmentDescriptor, Name, Unit>(this, result2){
                final /* synthetic */ FunctionTypeConstructor this$0;
                final /* synthetic */ ArrayList $result;

                /*
                 * WARNING - void declaration
                 */
                public final void invoke(@NotNull PackageFragmentDescriptor packageFragment, @NotNull Name name2) {
                    void $receiver$iv$iv;
                    Iterable $receiver$iv;
                    Intrinsics.checkParameterIsNotNull(packageFragment, "packageFragment");
                    Intrinsics.checkParameterIsNotNull(name2, "name");
                    ClassifierDescriptor classifierDescriptor = packageFragment.getMemberScope().getContributedClassifier(name2, NoLookupLocation.FROM_BUILTINS);
                    if (!(classifierDescriptor instanceof ClassDescriptor)) {
                        classifierDescriptor = null;
                    }
                    ClassDescriptor classDescriptor = (ClassDescriptor)classifierDescriptor;
                    if (classDescriptor == null) {
                        String string = "Class " + name2 + " not found in " + packageFragment;
                        throw (Throwable)new IllegalStateException(string.toString());
                    }
                    ClassDescriptor descriptor2 = classDescriptor;
                    TypeConstructor typeConstructor2 = descriptor2.getTypeConstructor();
                    Iterable iterable = $receiver$iv = (Iterable)CollectionsKt.takeLast(this.this$0.getParameters(), typeConstructor2.getParameters().size());
                    Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                    for (T item$iv$iv : $receiver$iv$iv) {
                        void it;
                        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor)item$iv$iv;
                        Collection collection = destination$iv$iv;
                        TypeProjectionImpl typeProjectionImpl = new TypeProjectionImpl(it.getDefaultType());
                        collection.add(typeProjectionImpl);
                    }
                    List arguments2 = (List)destination$iv$iv;
                    this.$result.add(KotlinTypeFactory.simpleNotNullType(Annotations.Companion.getEMPTY(), descriptor2, arguments2));
                }
                {
                    this.this$0 = functionTypeConstructor;
                    this.$result = arrayList;
                    super(2);
                }
            };
            if (Intrinsics.areEqual((Object)FunctionClassDescriptor.this.getFunctionKind(), (Object)Kind.SuspendFunction)) {
                result2.add(DescriptorUtilsKt.getBuiltIns(FunctionClassDescriptor.this.containingDeclaration).getAnyType());
            } else {
                PackageFragmentDescriptor packageFragmentDescriptor = FunctionClassDescriptor.this.containingDeclaration;
                Name name2 = Name.identifier(FunctionClassDescriptor.this.getFunctionKind().getClassNamePrefix());
                Intrinsics.checkExpressionValueIsNotNull(name2, "Name.identifier(functionKind.classNamePrefix)");
                add$.invoke(packageFragmentDescriptor, name2);
            }
            if (Intrinsics.areEqual((Object)FunctionClassDescriptor.this.getFunctionKind(), (Object)Kind.KFunction)) {
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                ModuleDescriptor moduleDescriptor = FunctionClassDescriptor.this.containingDeclaration.getContainingDeclaration();
                FqName fqName2 = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
                Intrinsics.checkExpressionValueIsNotNull(fqName2, "BUILT_INS_PACKAGE_FQ_NAME");
                PackageViewDescriptor packageView = moduleDescriptor.getPackage(fqName2);
                Iterable iterable = $receiver$iv = (Iterable)packageView.getFragments();
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $receiver$iv$iv) {
                    if (!(element$iv$iv instanceof BuiltInsPackageFragment)) continue;
                    destination$iv$iv.add(element$iv$iv);
                }
                BuiltInsPackageFragment kotlinPackageFragment = (BuiltInsPackageFragment)CollectionsKt.first((List)destination$iv$iv);
                PackageFragmentDescriptor packageFragmentDescriptor = kotlinPackageFragment;
                Name name3 = Kind.Function.numberedClassName(FunctionClassDescriptor.this.getArity());
                Intrinsics.checkExpressionValueIsNotNull(name3, "Kind.Function.numberedClassName(arity)");
                add$.invoke(packageFragmentDescriptor, name3);
            }
            return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((Collection)result2);
        }

        @Override
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            return FunctionClassDescriptor.this.parameters;
        }

        @Override
        @NotNull
        public FunctionClassDescriptor getDeclarationDescriptor() {
            return FunctionClassDescriptor.this;
        }

        @Override
        public boolean isDenotable() {
            return true;
        }

        @Override
        public boolean isFinal() {
            return false;
        }

        @NotNull
        public String toString() {
            return this.getDeclarationDescriptor().toString();
        }

        @Override
        @NotNull
        protected SupertypeLoopChecker getSupertypeLoopChecker() {
            return SupertypeLoopChecker.EMPTY.INSTANCE;
        }

        public FunctionTypeConstructor() {
            super(FunctionClassDescriptor.this.storageManager);
        }
    }
}

