/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.io.InputStream;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class KotlinBuiltIns {
    public static final Name BUILT_INS_PACKAGE_NAME = Name.identifier("kotlin");
    public static final FqName BUILT_INS_PACKAGE_FQ_NAME = FqName.topLevel(BUILT_INS_PACKAGE_NAME);
    private static final FqName ANNOTATION_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier("annotation"));
    public static final FqName COLLECTIONS_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier("collections"));
    public static final FqName RANGES_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier("ranges"));
    public static final FqName TEXT_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier("text"));
    public static final Set<FqName> BUILT_INS_PACKAGE_FQ_NAMES = SetsKt.setOf(new FqName[]{BUILT_INS_PACKAGE_FQ_NAME, COLLECTIONS_PACKAGE_FQ_NAME, RANGES_PACKAGE_FQ_NAME, ANNOTATION_PACKAGE_FQ_NAME, ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier("internal"))});
    private ModuleDescriptorImpl builtInsModule;
    private final NotNullLazyValue<Primitives> primitives;
    private final NotNullLazyValue<PackageFragments> packageFragments;
    private final MemoizedFunctionToNotNull<Integer, ClassDescriptor> suspendFunctionClasses;
    private final StorageManager storageManager;
    public static final FqNames FQ_NAMES = new FqNames();
    public static final Name BUILTINS_MODULE_NAME = Name.special("<built-ins module>");

    protected KotlinBuiltIns(@NotNull StorageManager storageManager) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "<init>"));
        }
        this.storageManager = storageManager;
        this.packageFragments = storageManager.createLazyValue(new Function0<PackageFragments>(){

            @Override
            public PackageFragments invoke() {
                PackageFragmentProvider provider = KotlinBuiltIns.this.builtInsModule.getPackageFragmentProvider();
                LinkedHashMap nameToFragment = new LinkedHashMap();
                PackageFragmentDescriptor kotlin = KotlinBuiltIns.this.createPackage(provider, nameToFragment, BUILT_INS_PACKAGE_FQ_NAME);
                PackageFragmentDescriptor kotlinCollections = KotlinBuiltIns.this.createPackage(provider, nameToFragment, COLLECTIONS_PACKAGE_FQ_NAME);
                KotlinBuiltIns.this.createPackage(provider, nameToFragment, RANGES_PACKAGE_FQ_NAME);
                PackageFragmentDescriptor kotlinAnnotation = KotlinBuiltIns.this.createPackage(provider, nameToFragment, ANNOTATION_PACKAGE_FQ_NAME);
                LinkedHashSet allImportedByDefault = new LinkedHashSet(nameToFragment.values());
                return new PackageFragments(kotlin, kotlinCollections, kotlinAnnotation, allImportedByDefault);
            }
        });
        this.primitives = storageManager.createLazyValue(new Function0<Primitives>(){

            @Override
            public Primitives invoke() {
                EnumMap<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType = new EnumMap<PrimitiveType, SimpleType>(PrimitiveType.class);
                HashMap<SimpleType, SimpleType> primitiveKotlinTypeToKotlinArrayType = new HashMap<SimpleType, SimpleType>();
                HashMap<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType = new HashMap<SimpleType, SimpleType>();
                for (PrimitiveType primitive : PrimitiveType.values()) {
                    SimpleType type2 = KotlinBuiltIns.this.getBuiltInTypeByClassName(primitive.getTypeName().asString());
                    SimpleType arrayType = KotlinBuiltIns.this.getBuiltInTypeByClassName(primitive.getArrayTypeName().asString());
                    primitiveTypeToArrayKotlinType.put(primitive, arrayType);
                    primitiveKotlinTypeToKotlinArrayType.put(type2, arrayType);
                    kotlinArrayTypeToPrimitiveKotlinType.put(arrayType, type2);
                }
                return new Primitives(primitiveTypeToArrayKotlinType, primitiveKotlinTypeToKotlinArrayType, kotlinArrayTypeToPrimitiveKotlinType);
            }
        });
        this.suspendFunctionClasses = storageManager.createMemoizedFunction(new Function1<Integer, ClassDescriptor>(){

            @Override
            public ClassDescriptor invoke(Integer arity) {
                return new FunctionClassDescriptor(KotlinBuiltIns.this.getStorageManager(), ((PackageFragments)((KotlinBuiltIns)KotlinBuiltIns.this).packageFragments.invoke()).builtInsPackageFragment, FunctionClassDescriptor.Kind.SuspendFunction, arity);
            }
        });
    }

    protected void createBuiltInsModule() {
        this.builtInsModule = new ModuleDescriptorImpl(BUILTINS_MODULE_NAME, this.storageManager, this, null);
        PackageFragmentProvider packageFragmentProvider = BuiltInsPackageFragmentProviderKt.createBuiltInPackageFragmentProvider(this.storageManager, this.builtInsModule, BUILT_INS_PACKAGE_FQ_NAMES, this.getClassDescriptorFactories(), this.getPlatformDependentDeclarationFilter(), this.getAdditionalClassPartsProvider(), (Function1<? super String, ? extends InputStream>)new Function1<String, InputStream>(){

            @Override
            public InputStream invoke(String path) {
                ClassLoader classLoader = KotlinBuiltIns.class.getClassLoader();
                return classLoader != null ? classLoader.getResourceAsStream(path) : ClassLoader.getSystemResourceAsStream(path);
            }
        });
        this.builtInsModule.initialize(packageFragmentProvider);
        this.builtInsModule.setDependencies(this.builtInsModule);
    }

    public void setBuiltInsModule(final @NotNull ModuleDescriptorImpl module) {
        if (module == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "module", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "setBuiltInsModule"));
        }
        this.storageManager.compute(new Function0<Void>(){

            @Override
            public Void invoke() {
                if (KotlinBuiltIns.this.builtInsModule != null) {
                    throw new AssertionError((Object)("Built-ins module is already set: " + KotlinBuiltIns.this.builtInsModule + " (attempting to reset to " + module + ")"));
                }
                KotlinBuiltIns.this.builtInsModule = module;
                return null;
            }
        });
    }

    @NotNull
    protected AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        AdditionalClassPartsProvider.None none = AdditionalClassPartsProvider.None.INSTANCE;
        if (none == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAdditionalClassPartsProvider"));
        }
        return none;
    }

    @NotNull
    protected PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        PlatformDependentDeclarationFilter.NoPlatformDependent noPlatformDependent = PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE;
        if (noPlatformDependent == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPlatformDependentDeclarationFilter"));
        }
        return noPlatformDependent;
    }

    @NotNull
    protected Iterable<ClassDescriptorFactory> getClassDescriptorFactories() {
        List<ClassDescriptorFactory> list = Collections.singletonList(new BuiltInFictitiousFunctionClassFactory(this.storageManager, this.builtInsModule));
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getClassDescriptorFactories"));
        }
        return list;
    }

    @NotNull
    private PackageFragmentDescriptor createPackage(@NotNull PackageFragmentProvider fragmentProvider, @Nullable Map<FqName, PackageFragmentDescriptor> packageNameToPackageFragment, final @NotNull FqName packageFqName) {
        PackageFragmentDescriptorImpl result2;
        if (fragmentProvider == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fragmentProvider", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "createPackage"));
        }
        if (packageFqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "packageFqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "createPackage"));
        }
        final List<PackageFragmentDescriptor> packageFragments2 = fragmentProvider.getPackageFragments(packageFqName);
        PackageFragmentDescriptor packageFragmentDescriptor = packageFragments2.isEmpty() ? new EmptyPackageFragmentDescriptor(this.builtInsModule, packageFqName) : (result2 = packageFragments2.size() == 1 ? packageFragments2.iterator().next() : new PackageFragmentDescriptorImpl(this.builtInsModule, packageFqName){

            @Override
            @NotNull
            public MemberScope getMemberScope() {
                ChainedMemberScope chainedMemberScope = new ChainedMemberScope("built-in package " + packageFqName, CollectionsKt.map(packageFragments2, new Function1<PackageFragmentDescriptor, MemberScope>(){

                    @Override
                    public MemberScope invoke(PackageFragmentDescriptor descriptor2) {
                        return descriptor2.getMemberScope();
                    }
                }));
                if (chainedMemberScope == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$6", "getMemberScope"));
                }
                return chainedMemberScope;
            }
        });
        if (packageNameToPackageFragment != null) {
            packageNameToPackageFragment.put(packageFqName, result2);
        }
        PackageFragmentDescriptorImpl packageFragmentDescriptorImpl = result2;
        if (packageFragmentDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "createPackage"));
        }
        return packageFragmentDescriptorImpl;
    }

    @NotNull
    protected StorageManager getStorageManager() {
        StorageManager storageManager = this.storageManager;
        if (storageManager == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getStorageManager"));
        }
        return storageManager;
    }

    @NotNull
    public ModuleDescriptorImpl getBuiltInsModule() {
        ModuleDescriptorImpl moduleDescriptorImpl = this.builtInsModule;
        if (moduleDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInsModule"));
        }
        return moduleDescriptorImpl;
    }

    @NotNull
    public Set<PackageFragmentDescriptor> getBuiltInsPackageFragmentsImportedByDefault() {
        Set<PackageFragmentDescriptor> set = ((PackageFragments)this.packageFragments.invoke()).allImportedByDefaultBuiltInsPackageFragments;
        if (set == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInsPackageFragmentsImportedByDefault"));
        }
        return set;
    }

    @NotNull
    public PackageFragmentDescriptor getBuiltInsPackageFragment() {
        PackageFragmentDescriptor packageFragmentDescriptor = ((PackageFragments)this.packageFragments.invoke()).builtInsPackageFragment;
        if (packageFragmentDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInsPackageFragment"));
        }
        return packageFragmentDescriptor;
    }

    public static boolean isBuiltIn(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isBuiltIn"));
        }
        return DescriptorUtils.getParentOfType(descriptor2, BuiltInsPackageFragment.class, false) != null;
    }

    @NotNull
    public MemberScope getBuiltInsPackageScope() {
        MemberScope memberScope2 = ((PackageFragments)this.packageFragments.invoke()).builtInsPackageFragment.getMemberScope();
        if (memberScope2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInsPackageScope"));
        }
        return memberScope2;
    }

    @NotNull
    private ClassDescriptor getAnnotationClassByName(@NotNull Name simpleName2) {
        if (simpleName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAnnotationClassByName"));
        }
        ClassDescriptor classDescriptor = KotlinBuiltIns.getBuiltInClassByName(simpleName2, ((PackageFragments)this.packageFragments.invoke()).annotationPackageFragment);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAnnotationClassByName"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getBuiltInClassByName(@NotNull Name simpleName2) {
        if (simpleName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"));
        }
        ClassDescriptor classDescriptor = KotlinBuiltIns.getBuiltInClassByName(simpleName2, this.getBuiltInsPackageFragment());
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"));
        }
        return classDescriptor;
    }

    @NotNull
    private static ClassDescriptor getBuiltInClassByName(@NotNull Name simpleName2, @NotNull PackageFragmentDescriptor packageFragment) {
        if (simpleName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"));
        }
        if (packageFragment == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "packageFragment", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"));
        }
        ClassDescriptor classDescriptor = KotlinBuiltIns.getBuiltInClassByNameNullable(simpleName2, packageFragment);
        if (classDescriptor == null) {
            throw new AssertionError((Object)("Built-in class " + packageFragment.getFqName().child(simpleName2).asString() + " is not found"));
        }
        ClassDescriptor classDescriptor2 = classDescriptor;
        if (classDescriptor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"));
        }
        return classDescriptor2;
    }

    @Nullable
    public ClassDescriptor getBuiltInClassByNameNullable(@NotNull Name simpleName2) {
        if (simpleName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByNameNullable"));
        }
        return KotlinBuiltIns.getBuiltInClassByNameNullable(simpleName2, this.getBuiltInsPackageFragment());
    }

    @Nullable
    public ClassDescriptor getBuiltInClassByFqNameNullable(@NotNull FqName fqName2) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByFqNameNullable"));
        }
        return DescriptorUtilKt.resolveClassByFqName(this.builtInsModule, fqName2, NoLookupLocation.FROM_BUILTINS);
    }

    @NotNull
    public ClassDescriptor getBuiltInClassByFqName(@NotNull FqName fqName2) {
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByFqName"));
        }
        ClassDescriptor descriptor2 = this.getBuiltInClassByFqNameNullable(fqName2);
        assert (descriptor2 != null) : "Can't find built-in class " + fqName2;
        ClassDescriptor classDescriptor = descriptor2;
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByFqName"));
        }
        return classDescriptor;
    }

    @Nullable
    private static ClassDescriptor getBuiltInClassByNameNullable(@NotNull Name simpleName2, @NotNull PackageFragmentDescriptor packageFragment) {
        if (simpleName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByNameNullable"));
        }
        if (packageFragment == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "packageFragment", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByNameNullable"));
        }
        ClassifierDescriptor classifier2 = packageFragment.getMemberScope().getContributedClassifier(simpleName2, NoLookupLocation.FROM_BUILTINS);
        assert (classifier2 == null || classifier2 instanceof ClassDescriptor) : "Must be a class descriptor " + simpleName2 + ", but was " + classifier2;
        return (ClassDescriptor)classifier2;
    }

    @NotNull
    private ClassDescriptor getBuiltInClassByName(@NotNull String simpleName2) {
        if (simpleName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"));
        }
        ClassDescriptor classDescriptor = this.getBuiltInClassByName(Name.identifier(simpleName2));
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"));
        }
        return classDescriptor;
    }

    @NotNull
    private static ClassDescriptor getBuiltInClassByName(@NotNull String simpleName2, PackageFragmentDescriptor packageFragment) {
        if (simpleName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"));
        }
        ClassDescriptor classDescriptor = KotlinBuiltIns.getBuiltInClassByName(Name.identifier(simpleName2), packageFragment);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInClassByName"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getAny() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName("Any");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAny"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getNothing() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName("Nothing");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getNothing"));
        }
        return classDescriptor;
    }

    @NotNull
    private ClassDescriptor getPrimitiveClassDescriptor(@NotNull PrimitiveType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveClassDescriptor"));
        }
        ClassDescriptor classDescriptor = this.getBuiltInClassByName(type2.getTypeName().asString());
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveClassDescriptor"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getByte() {
        ClassDescriptor classDescriptor = this.getPrimitiveClassDescriptor(PrimitiveType.BYTE);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getByte"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getShort() {
        ClassDescriptor classDescriptor = this.getPrimitiveClassDescriptor(PrimitiveType.SHORT);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getShort"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getInt() {
        ClassDescriptor classDescriptor = this.getPrimitiveClassDescriptor(PrimitiveType.INT);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getInt"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getLong() {
        ClassDescriptor classDescriptor = this.getPrimitiveClassDescriptor(PrimitiveType.LONG);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getLong"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getFloat() {
        ClassDescriptor classDescriptor = this.getPrimitiveClassDescriptor(PrimitiveType.FLOAT);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getFloat"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getDouble() {
        ClassDescriptor classDescriptor = this.getPrimitiveClassDescriptor(PrimitiveType.DOUBLE);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getDouble"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getChar() {
        ClassDescriptor classDescriptor = this.getPrimitiveClassDescriptor(PrimitiveType.CHAR);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getChar"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getBoolean() {
        ClassDescriptor classDescriptor = this.getPrimitiveClassDescriptor(PrimitiveType.BOOLEAN);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBoolean"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getArray() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName("Array");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArray"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getPrimitiveArrayClassDescriptor(@NotNull PrimitiveType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveArrayClassDescriptor"));
        }
        ClassDescriptor classDescriptor = this.getBuiltInClassByName(type2.getArrayTypeName().asString());
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveArrayClassDescriptor"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getNumber() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName("Number");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getNumber"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getUnit() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName("Unit");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getUnit"));
        }
        return classDescriptor;
    }

    @NotNull
    public static String getFunctionName(int parameterCount) {
        String string = "Function" + parameterCount;
        if (string == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getFunctionName"));
        }
        return string;
    }

    @NotNull
    public static ClassId getFunctionClassId(int parameterCount) {
        ClassId classId = new ClassId(BUILT_INS_PACKAGE_FQ_NAME, Name.identifier(KotlinBuiltIns.getFunctionName(parameterCount)));
        if (classId == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getFunctionClassId"));
        }
        return classId;
    }

    @NotNull
    public ClassDescriptor getFunction(int parameterCount) {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName(KotlinBuiltIns.getFunctionName(parameterCount));
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getFunction"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getSuspendFunction(int parameterCount) {
        ClassDescriptor classDescriptor = (ClassDescriptor)this.suspendFunctionClasses.invoke(parameterCount);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getSuspendFunction"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getThrowable() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName("Throwable");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getThrowable"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getDeprecatedAnnotation() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName(KotlinBuiltIns.FQ_NAMES.deprecated.shortName());
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getDeprecatedAnnotation"));
        }
        return classDescriptor;
    }

    @Nullable
    private static ClassDescriptor getEnumEntry(@NotNull ClassDescriptor enumDescriptor, @NotNull String entryName) {
        if (enumDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumDescriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getEnumEntry"));
        }
        if (entryName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "entryName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getEnumEntry"));
        }
        ClassifierDescriptor result2 = enumDescriptor.getUnsubstitutedInnerClassesScope().getContributedClassifier(Name.identifier(entryName), NoLookupLocation.FROM_BUILTINS);
        return result2 instanceof ClassDescriptor ? (ClassDescriptor)result2 : null;
    }

    @Nullable
    public ClassDescriptor getDeprecationLevelEnumEntry(@NotNull String level) {
        if (level == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "level", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getDeprecationLevelEnumEntry"));
        }
        return KotlinBuiltIns.getEnumEntry(this.getBuiltInClassByName(KotlinBuiltIns.FQ_NAMES.deprecationLevel.shortName()), level);
    }

    @NotNull
    public ClassDescriptor getTargetAnnotation() {
        ClassDescriptor classDescriptor = this.getAnnotationClassByName(KotlinBuiltIns.FQ_NAMES.target.shortName());
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getTargetAnnotation"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getRetentionAnnotation() {
        ClassDescriptor classDescriptor = this.getAnnotationClassByName(KotlinBuiltIns.FQ_NAMES.retention.shortName());
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getRetentionAnnotation"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getRepeatableAnnotation() {
        ClassDescriptor classDescriptor = this.getAnnotationClassByName(KotlinBuiltIns.FQ_NAMES.repeatable.shortName());
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getRepeatableAnnotation"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getMustBeDocumentedAnnotation() {
        ClassDescriptor classDescriptor = this.getAnnotationClassByName(KotlinBuiltIns.FQ_NAMES.mustBeDocumented.shortName());
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMustBeDocumentedAnnotation"));
        }
        return classDescriptor;
    }

    @Nullable
    public ClassDescriptor getAnnotationTargetEnumEntry(@NotNull KotlinTarget target) {
        if (target == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "target", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAnnotationTargetEnumEntry"));
        }
        return KotlinBuiltIns.getEnumEntry(this.getAnnotationClassByName(KotlinBuiltIns.FQ_NAMES.annotationTarget.shortName()), target.name());
    }

    @Nullable
    public ClassDescriptor getAnnotationRetentionEnumEntry(@NotNull KotlinRetention retention) {
        if (retention == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "retention", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAnnotationRetentionEnumEntry"));
        }
        return KotlinBuiltIns.getEnumEntry(this.getAnnotationClassByName(KotlinBuiltIns.FQ_NAMES.annotationRetention.shortName()), retention.name());
    }

    @NotNull
    public ClassDescriptor getString() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName("String");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getString"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getComparable() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName("Comparable");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getComparable"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getEnum() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName("Enum");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getEnum"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getAnnotation() {
        ClassDescriptor classDescriptor = this.getBuiltInClassByName("Annotation");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAnnotation"));
        }
        return classDescriptor;
    }

    @NotNull
    private ClassDescriptor getCollectionClassByName(@NotNull String simpleName2) {
        if (simpleName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getCollectionClassByName"));
        }
        ClassDescriptor classDescriptor = KotlinBuiltIns.getBuiltInClassByName(simpleName2, ((PackageFragments)this.packageFragments.invoke()).collectionsPackageFragment);
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getCollectionClassByName"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getIterator() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("Iterator");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getIterator"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getIterable() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("Iterable");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getIterable"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getMutableIterable() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("MutableIterable");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMutableIterable"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getMutableIterator() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("MutableIterator");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMutableIterator"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getCollection() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("Collection");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getCollection"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getMutableCollection() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("MutableCollection");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMutableCollection"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getList() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("List");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getList"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getMutableList() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("MutableList");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMutableList"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getSet() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("Set");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getSet"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getMutableSet() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("MutableSet");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMutableSet"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getMap() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("Map");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMap"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getMutableMap() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("MutableMap");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMutableMap"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getMapEntry() {
        ClassDescriptor classDescriptor = DescriptorUtils.getInnerClassByName(this.getMap(), "Entry", NoLookupLocation.FROM_BUILTINS);
        assert (classDescriptor != null) : "Can't find Map.Entry";
        ClassDescriptor classDescriptor2 = classDescriptor;
        if (classDescriptor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMapEntry"));
        }
        return classDescriptor2;
    }

    @NotNull
    public ClassDescriptor getMutableMapEntry() {
        ClassDescriptor classDescriptor = DescriptorUtils.getInnerClassByName(this.getMutableMap(), "MutableEntry", NoLookupLocation.FROM_BUILTINS);
        assert (classDescriptor != null) : "Can't find MutableMap.MutableEntry";
        ClassDescriptor classDescriptor2 = classDescriptor;
        if (classDescriptor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMutableMapEntry"));
        }
        return classDescriptor2;
    }

    @NotNull
    public ClassDescriptor getListIterator() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("ListIterator");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getListIterator"));
        }
        return classDescriptor;
    }

    @NotNull
    public ClassDescriptor getMutableListIterator() {
        ClassDescriptor classDescriptor = this.getCollectionClassByName("MutableListIterator");
        if (classDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMutableListIterator"));
        }
        return classDescriptor;
    }

    @NotNull
    private SimpleType getBuiltInTypeByClassName(@NotNull String classSimpleName) {
        if (classSimpleName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classSimpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInTypeByClassName"));
        }
        SimpleType simpleType2 = this.getBuiltInClassByName(classSimpleName).getDefaultType();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBuiltInTypeByClassName"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getNothingType() {
        SimpleType simpleType2 = this.getNothing().getDefaultType();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getNothingType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getNullableNothingType() {
        SimpleType simpleType2 = this.getNothingType().makeNullableAsSpecified(true);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getNullableNothingType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getAnyType() {
        SimpleType simpleType2 = this.getAny().getDefaultType();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAnyType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getNullableAnyType() {
        SimpleType simpleType2 = this.getAnyType().makeNullableAsSpecified(true);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getNullableAnyType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getDefaultBound() {
        SimpleType simpleType2 = this.getNullableAnyType();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getDefaultBound"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getPrimitiveKotlinType(@NotNull PrimitiveType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveKotlinType"));
        }
        SimpleType simpleType2 = this.getPrimitiveClassDescriptor(type2).getDefaultType();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveKotlinType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getByteType() {
        SimpleType simpleType2 = this.getPrimitiveKotlinType(PrimitiveType.BYTE);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getByteType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getShortType() {
        SimpleType simpleType2 = this.getPrimitiveKotlinType(PrimitiveType.SHORT);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getShortType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getIntType() {
        SimpleType simpleType2 = this.getPrimitiveKotlinType(PrimitiveType.INT);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getIntType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getLongType() {
        SimpleType simpleType2 = this.getPrimitiveKotlinType(PrimitiveType.LONG);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getLongType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getFloatType() {
        SimpleType simpleType2 = this.getPrimitiveKotlinType(PrimitiveType.FLOAT);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getFloatType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getDoubleType() {
        SimpleType simpleType2 = this.getPrimitiveKotlinType(PrimitiveType.DOUBLE);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getDoubleType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getCharType() {
        SimpleType simpleType2 = this.getPrimitiveKotlinType(PrimitiveType.CHAR);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getCharType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getBooleanType() {
        SimpleType simpleType2 = this.getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getBooleanType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getUnitType() {
        SimpleType simpleType2 = this.getUnit().getDefaultType();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getUnitType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getStringType() {
        SimpleType simpleType2 = this.getString().getDefaultType();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getStringType"));
        }
        return simpleType2;
    }

    @NotNull
    public KotlinType getIterableType() {
        SimpleType simpleType2 = this.getIterable().getDefaultType();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getIterableType"));
        }
        return simpleType2;
    }

    @NotNull
    public KotlinType getArrayElementType(@NotNull KotlinType arrayType) {
        if (arrayType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "arrayType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArrayElementType"));
        }
        if (KotlinBuiltIns.isArray(arrayType)) {
            if (arrayType.getArguments().size() != 1) {
                throw new IllegalStateException();
            }
            KotlinType kotlinType = arrayType.getArguments().get(0).getType();
            if (kotlinType == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArrayElementType"));
            }
            return kotlinType;
        }
        KotlinType primitiveType = ((Primitives)this.primitives.invoke()).kotlinArrayTypeToPrimitiveKotlinType.get(TypeUtils.makeNotNullable(arrayType));
        if (primitiveType == null) {
            throw new IllegalStateException("not array: " + arrayType);
        }
        KotlinType kotlinType = primitiveType;
        if (kotlinType == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArrayElementType"));
        }
        return kotlinType;
    }

    @NotNull
    public SimpleType getPrimitiveArrayKotlinType(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "primitiveType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveArrayKotlinType"));
        }
        SimpleType simpleType2 = ((Primitives)this.primitives.invoke()).primitiveTypeToArrayKotlinType.get((Object)primitiveType);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveArrayKotlinType"));
        }
        return simpleType2;
    }

    @Nullable
    public SimpleType getPrimitiveArrayKotlinTypeByPrimitiveKotlinType(@NotNull KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kotlinType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType"));
        }
        return ((Primitives)this.primitives.invoke()).primitiveKotlinTypeToKotlinArrayType.get(kotlinType);
    }

    public static boolean isPrimitiveArray(@NotNull FqNameUnsafe arrayFqName) {
        if (arrayFqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "arrayFqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isPrimitiveArray"));
        }
        return KotlinBuiltIns.getPrimitiveTypeByArrayClassFqName(arrayFqName) != null;
    }

    @Nullable
    public static PrimitiveType getPrimitiveTypeByFqName(@NotNull FqNameUnsafe primitiveClassFqName) {
        if (primitiveClassFqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "primitiveClassFqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveTypeByFqName"));
        }
        return KotlinBuiltIns.FQ_NAMES.fqNameToPrimitiveType.get(primitiveClassFqName);
    }

    @Nullable
    public static PrimitiveType getPrimitiveTypeByArrayClassFqName(@NotNull FqNameUnsafe primitiveArrayClassFqName) {
        if (primitiveArrayClassFqName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "primitiveArrayClassFqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveTypeByArrayClassFqName"));
        }
        return KotlinBuiltIns.FQ_NAMES.arrayClassFqNameToPrimitiveType.get(primitiveArrayClassFqName);
    }

    @NotNull
    public SimpleType getArrayType(@NotNull Variance projectionType, @NotNull KotlinType argument) {
        if (projectionType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "projectionType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArrayType"));
        }
        if (argument == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "argument", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArrayType"));
        }
        List<TypeProjectionImpl> types = Collections.singletonList(new TypeProjectionImpl(projectionType, argument));
        SimpleType simpleType2 = KotlinTypeFactory.simpleNotNullType(Annotations.Companion.getEMPTY(), this.getArray(), types);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getArrayType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getEnumType(@NotNull SimpleType argument) {
        if (argument == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "argument", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getEnumType"));
        }
        Variance projectionType = Variance.INVARIANT;
        List<TypeProjectionImpl> types = Collections.singletonList(new TypeProjectionImpl(projectionType, argument));
        SimpleType simpleType2 = KotlinTypeFactory.simpleNotNullType(Annotations.Companion.getEMPTY(), this.getEnum(), types);
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getEnumType"));
        }
        return simpleType2;
    }

    @NotNull
    public SimpleType getAnnotationType() {
        SimpleType simpleType2 = this.getAnnotation().getDefaultType();
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getAnnotationType"));
        }
        return simpleType2;
    }

    public static boolean isArray(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isArray"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.array);
    }

    public static boolean isArrayOrPrimitiveArray(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isArrayOrPrimitiveArray"));
        }
        return KotlinBuiltIns.classFqNameEquals(descriptor2, KotlinBuiltIns.FQ_NAMES.array) || KotlinBuiltIns.getPrimitiveTypeByArrayClassFqName(DescriptorUtils.getFqName(descriptor2)) != null;
    }

    public static boolean isPrimitiveArray(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isPrimitiveArray"));
        }
        ClassifierDescriptor descriptor2 = type2.getConstructor().getDeclarationDescriptor();
        return descriptor2 != null && KotlinBuiltIns.getPrimitiveTypeByArrayClassFqName(DescriptorUtils.getFqName(descriptor2)) != null;
    }

    public static boolean isPrimitiveType(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isPrimitiveType"));
        }
        ClassifierDescriptor descriptor2 = type2.getConstructor().getDeclarationDescriptor();
        return !type2.isMarkedNullable() && descriptor2 instanceof ClassDescriptor && KotlinBuiltIns.isPrimitiveClass((ClassDescriptor)descriptor2);
    }

    public static boolean isPrimitiveClass(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isPrimitiveClass"));
        }
        return KotlinBuiltIns.getPrimitiveTypeByFqName(DescriptorUtils.getFqName(descriptor2)) != null;
    }

    public static boolean isConstructedFromGivenClass(@NotNull KotlinType type2, @NotNull FqNameUnsafe fqName2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isConstructedFromGivenClass"));
        }
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isConstructedFromGivenClass"));
        }
        ClassifierDescriptor descriptor2 = type2.getConstructor().getDeclarationDescriptor();
        return descriptor2 instanceof ClassDescriptor && KotlinBuiltIns.classFqNameEquals(descriptor2, fqName2);
    }

    public static boolean isConstructedFromGivenClass(@NotNull KotlinType type2, @NotNull FqName fqName2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isConstructedFromGivenClass"));
        }
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isConstructedFromGivenClass"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, fqName2.toUnsafe());
    }

    private static boolean classFqNameEquals(@NotNull ClassifierDescriptor descriptor2, @NotNull FqNameUnsafe fqName2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "classFqNameEquals"));
        }
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "classFqNameEquals"));
        }
        return descriptor2.getName().equals(fqName2.shortName()) && fqName2.equals(DescriptorUtils.getFqName(descriptor2));
    }

    private static boolean isNotNullConstructedFromGivenClass(@NotNull KotlinType type2, @NotNull FqNameUnsafe fqName2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNotNullConstructedFromGivenClass"));
        }
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNotNullConstructedFromGivenClass"));
        }
        return !type2.isMarkedNullable() && KotlinBuiltIns.isConstructedFromGivenClass(type2, fqName2);
    }

    public static boolean isSpecialClassWithNoSupertypes(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isSpecialClassWithNoSupertypes"));
        }
        return KotlinBuiltIns.classFqNameEquals(descriptor2, KotlinBuiltIns.FQ_NAMES.any) || KotlinBuiltIns.classFqNameEquals(descriptor2, KotlinBuiltIns.FQ_NAMES.nothing);
    }

    public static boolean isAny(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isAny"));
        }
        return KotlinBuiltIns.classFqNameEquals(descriptor2, KotlinBuiltIns.FQ_NAMES.any);
    }

    public static boolean isAny(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isAny"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type2, KotlinBuiltIns.FQ_NAMES.any);
    }

    public static boolean isBoolean(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isBoolean"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type2, KotlinBuiltIns.FQ_NAMES._boolean);
    }

    public static boolean isBooleanOrNullableBoolean(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isBooleanOrNullableBoolean"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES._boolean);
    }

    public static boolean isBoolean(@NotNull ClassDescriptor classDescriptor) {
        if (classDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "classDescriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isBoolean"));
        }
        return KotlinBuiltIns.classFqNameEquals(classDescriptor, KotlinBuiltIns.FQ_NAMES._boolean);
    }

    public static boolean isChar(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isChar"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type2, KotlinBuiltIns.FQ_NAMES._char);
    }

    public static boolean isCharOrNullableChar(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isCharOrNullableChar"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES._char);
    }

    public static boolean isInt(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isInt"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type2, KotlinBuiltIns.FQ_NAMES._int);
    }

    public static boolean isByte(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isByte"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type2, KotlinBuiltIns.FQ_NAMES._byte);
    }

    public static boolean isLong(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isLong"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type2, KotlinBuiltIns.FQ_NAMES._long);
    }

    public static boolean isShort(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isShort"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClassAndNotNullable(type2, KotlinBuiltIns.FQ_NAMES._short);
    }

    public static boolean isFloat(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isFloat"));
        }
        return KotlinBuiltIns.isFloatOrNullableFloat(type2) && !type2.isMarkedNullable();
    }

    public static boolean isFloatOrNullableFloat(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isFloatOrNullableFloat"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES._float);
    }

    public static boolean isDouble(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isDouble"));
        }
        return KotlinBuiltIns.isDoubleOrNullableDouble(type2) && !type2.isMarkedNullable();
    }

    public static boolean isDoubleOrNullableDouble(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isDoubleOrNullableDouble"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES._double);
    }

    private static boolean isConstructedFromGivenClassAndNotNullable(@NotNull KotlinType type2, @NotNull FqNameUnsafe fqName2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isConstructedFromGivenClassAndNotNullable"));
        }
        if (fqName2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isConstructedFromGivenClassAndNotNullable"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, fqName2) && !type2.isMarkedNullable();
    }

    public static boolean isNothing(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNothing"));
        }
        return KotlinBuiltIns.isNothingOrNullableNothing(type2) && !type2.isMarkedNullable();
    }

    public static boolean isNullableNothing(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNullableNothing"));
        }
        return KotlinBuiltIns.isNothingOrNullableNothing(type2) && type2.isMarkedNullable();
    }

    public static boolean isNothingOrNullableNothing(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNothingOrNullableNothing"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.nothing);
    }

    public static boolean isAnyOrNullableAny(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isAnyOrNullableAny"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.any);
    }

    public static boolean isNullableAny(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNullableAny"));
        }
        return KotlinBuiltIns.isAnyOrNullableAny(type2) && type2.isMarkedNullable();
    }

    public static boolean isDefaultBound(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isDefaultBound"));
        }
        return KotlinBuiltIns.isNullableAny(type2);
    }

    public static boolean isUnit(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isUnit"));
        }
        return KotlinBuiltIns.isNotNullConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.unit);
    }

    public static boolean isUnitOrNullableUnit(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isUnitOrNullableUnit"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.unit);
    }

    public boolean isBooleanOrSubtype(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isBooleanOrSubtype"));
        }
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(type2, this.getBooleanType());
    }

    public boolean isMemberOfAny(@NotNull DeclarationDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isMemberOfAny"));
        }
        return descriptor2.getContainingDeclaration() == this.getAny();
    }

    public static boolean isString(@Nullable KotlinType type2) {
        return type2 != null && KotlinBuiltIns.isNotNullConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.string);
    }

    public static boolean isCharSequenceOrNullableCharSequence(@Nullable KotlinType type2) {
        return type2 != null && KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.charSequence);
    }

    public static boolean isStringOrNullableString(@Nullable KotlinType type2) {
        return type2 != null && KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.string);
    }

    public static boolean isCollectionOrNullableCollection(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isCollectionOrNullableCollection"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.collection);
    }

    public static boolean isListOrNullableList(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isListOrNullableList"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.list);
    }

    public static boolean isSetOrNullableSet(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isSetOrNullableSet"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.set);
    }

    public static boolean isMapOrNullableMap(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isMapOrNullableMap"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.map);
    }

    public static boolean isIterableOrNullableIterable(@NotNull KotlinType type2) {
        if (type2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "type", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isIterableOrNullableIterable"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(type2, KotlinBuiltIns.FQ_NAMES.iterable);
    }

    public static boolean isKClass(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isKClass"));
        }
        return KotlinBuiltIns.classFqNameEquals(descriptor2, KotlinBuiltIns.FQ_NAMES.kClass);
    }

    public static boolean isNonPrimitiveArray(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isNonPrimitiveArray"));
        }
        return KotlinBuiltIns.classFqNameEquals(descriptor2, KotlinBuiltIns.FQ_NAMES.array);
    }

    public static boolean isCloneable(@NotNull ClassDescriptor descriptor2) {
        if (descriptor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isCloneable"));
        }
        return KotlinBuiltIns.classFqNameEquals(descriptor2, KotlinBuiltIns.FQ_NAMES.cloneable);
    }

    public static boolean isDeprecated(@NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "declarationDescriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isDeprecated"));
        }
        if (KotlinBuiltIns.containsAnnotation(declarationDescriptor, KotlinBuiltIns.FQ_NAMES.deprecated)) {
            return true;
        }
        if (declarationDescriptor instanceof PropertyDescriptor) {
            boolean isVar = ((PropertyDescriptor)declarationDescriptor).isVar();
            PropertyGetterDescriptor getter = ((PropertyDescriptor)declarationDescriptor).getGetter();
            PropertySetterDescriptor setter = ((PropertyDescriptor)declarationDescriptor).getSetter();
            return getter != null && KotlinBuiltIns.isDeprecated(getter) && (!isVar || setter != null && KotlinBuiltIns.isDeprecated(setter));
        }
        return false;
    }

    public static FqName getPrimitiveFqName(@NotNull PrimitiveType primitiveType) {
        if (primitiveType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "primitiveType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getPrimitiveFqName"));
        }
        return BUILT_INS_PACKAGE_FQ_NAME.child(primitiveType.getTypeName());
    }

    public static boolean isSuppressAnnotation(@NotNull AnnotationDescriptor annotationDescriptor) {
        if (annotationDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotationDescriptor", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "isSuppressAnnotation"));
        }
        return KotlinBuiltIns.isConstructedFromGivenClass(annotationDescriptor.getType(), KotlinBuiltIns.FQ_NAMES.suppress);
    }

    private static boolean containsAnnotation(DeclarationDescriptor descriptor2, FqName annotationClassFqName) {
        DeclarationDescriptor original = descriptor2.getOriginal();
        Annotations annotations2 = original.getAnnotations();
        if (annotations2.findAnnotation(annotationClassFqName) != null) {
            return true;
        }
        AnnotationUseSiteTarget associatedUseSiteTarget = AnnotationUseSiteTarget.Companion.getAssociatedUseSiteTarget(descriptor2);
        return associatedUseSiteTarget != null && Annotations.Companion.findUseSiteTargetedAnnotation(annotations2, associatedUseSiteTarget, annotationClassFqName) != null;
    }

    public static class FqNames {
        public final FqNameUnsafe any = FqNames.fqNameUnsafe("Any");
        public final FqNameUnsafe nothing = FqNames.fqNameUnsafe("Nothing");
        public final FqNameUnsafe cloneable = FqNames.fqNameUnsafe("Cloneable");
        public final FqNameUnsafe suppress = FqNames.fqNameUnsafe("Suppress");
        public final FqNameUnsafe unit = FqNames.fqNameUnsafe("Unit");
        public final FqNameUnsafe charSequence = FqNames.fqNameUnsafe("CharSequence");
        public final FqNameUnsafe string = FqNames.fqNameUnsafe("String");
        public final FqNameUnsafe array = FqNames.fqNameUnsafe("Array");
        public final FqNameUnsafe _boolean = FqNames.fqNameUnsafe("Boolean");
        public final FqNameUnsafe _char = FqNames.fqNameUnsafe("Char");
        public final FqNameUnsafe _byte = FqNames.fqNameUnsafe("Byte");
        public final FqNameUnsafe _short = FqNames.fqNameUnsafe("Short");
        public final FqNameUnsafe _int = FqNames.fqNameUnsafe("Int");
        public final FqNameUnsafe _long = FqNames.fqNameUnsafe("Long");
        public final FqNameUnsafe _float = FqNames.fqNameUnsafe("Float");
        public final FqNameUnsafe _double = FqNames.fqNameUnsafe("Double");
        public final FqNameUnsafe number = FqNames.fqNameUnsafe("Number");
        public final FqNameUnsafe _enum = FqNames.fqNameUnsafe("Enum");
        public final FqName throwable = FqNames.fqName("Throwable");
        public final FqName comparable = FqNames.fqName("Comparable");
        public final FqNameUnsafe charRange = FqNames.rangesFqName("CharRange");
        public final FqNameUnsafe intRange = FqNames.rangesFqName("IntRange");
        public final FqNameUnsafe longRange = FqNames.rangesFqName("LongRange");
        public final FqName deprecated = FqNames.fqName("Deprecated");
        public final FqName deprecationLevel = FqNames.fqName("DeprecationLevel");
        public final FqName extensionFunctionType = FqNames.fqName("ExtensionFunctionType");
        public final FqName parameterName = FqNames.fqName("ParameterName");
        public final FqName annotation = FqNames.fqName("Annotation");
        public final FqName target = FqNames.annotationName("Target");
        public final FqName annotationTarget = FqNames.annotationName("AnnotationTarget");
        public final FqName annotationRetention = FqNames.annotationName("AnnotationRetention");
        public final FqName retention = FqNames.annotationName("Retention");
        public final FqName repeatable = FqNames.annotationName("Repeatable");
        public final FqName mustBeDocumented = FqNames.annotationName("MustBeDocumented");
        public final FqName unsafeVariance = FqNames.fqName("UnsafeVariance");
        public final FqName publishedApi = FqNames.fqName("PublishedApi");
        public final FqName iterator = FqNames.collectionsFqName("Iterator");
        public final FqName iterable = FqNames.collectionsFqName("Iterable");
        public final FqName collection = FqNames.collectionsFqName("Collection");
        public final FqName list = FqNames.collectionsFqName("List");
        public final FqName listIterator = FqNames.collectionsFqName("ListIterator");
        public final FqName set = FqNames.collectionsFqName("Set");
        public final FqName map = FqNames.collectionsFqName("Map");
        public final FqName mapEntry = this.map.child(Name.identifier("Entry"));
        public final FqName mutableIterator = FqNames.collectionsFqName("MutableIterator");
        public final FqName mutableIterable = FqNames.collectionsFqName("MutableIterable");
        public final FqName mutableCollection = FqNames.collectionsFqName("MutableCollection");
        public final FqName mutableList = FqNames.collectionsFqName("MutableList");
        public final FqName mutableListIterator = FqNames.collectionsFqName("MutableListIterator");
        public final FqName mutableSet = FqNames.collectionsFqName("MutableSet");
        public final FqName mutableMap = FqNames.collectionsFqName("MutableMap");
        public final FqName mutableMapEntry = this.mutableMap.child(Name.identifier("MutableEntry"));
        public final FqNameUnsafe kClass = FqNames.reflect("KClass");
        public final FqNameUnsafe kCallable = FqNames.reflect("KCallable");
        public final FqNameUnsafe kProperty0 = FqNames.reflect("KProperty0");
        public final FqNameUnsafe kProperty1 = FqNames.reflect("KProperty1");
        public final FqNameUnsafe kProperty2 = FqNames.reflect("KProperty2");
        public final FqNameUnsafe kMutableProperty0 = FqNames.reflect("KMutableProperty0");
        public final FqNameUnsafe kMutableProperty1 = FqNames.reflect("KMutableProperty1");
        public final FqNameUnsafe kMutableProperty2 = FqNames.reflect("KMutableProperty2");
        public final ClassId kProperty = ClassId.topLevel(FqNames.reflect("KProperty").toSafe());
        public final Map<FqNameUnsafe, PrimitiveType> fqNameToPrimitiveType = new HashMap<FqNameUnsafe, PrimitiveType>(0);
        public final Map<FqNameUnsafe, PrimitiveType> arrayClassFqNameToPrimitiveType = new HashMap<FqNameUnsafe, PrimitiveType>(0);

        public FqNames() {
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                this.fqNameToPrimitiveType.put(FqNames.fqNameUnsafe(primitiveType.getTypeName().asString()), primitiveType);
                this.arrayClassFqNameToPrimitiveType.put(FqNames.fqNameUnsafe(primitiveType.getArrayTypeName().asString()), primitiveType);
            }
        }

        @NotNull
        private static FqNameUnsafe fqNameUnsafe(@NotNull String simpleName2) {
            if (simpleName2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "fqNameUnsafe"));
            }
            FqNameUnsafe fqNameUnsafe = FqNames.fqName(simpleName2).toUnsafe();
            if (fqNameUnsafe == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "fqNameUnsafe"));
            }
            return fqNameUnsafe;
        }

        @NotNull
        private static FqName fqName(@NotNull String simpleName2) {
            if (simpleName2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "fqName"));
            }
            FqName fqName2 = BUILT_INS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName2));
            if (fqName2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "fqName"));
            }
            return fqName2;
        }

        @NotNull
        private static FqName collectionsFqName(@NotNull String simpleName2) {
            if (simpleName2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "collectionsFqName"));
            }
            FqName fqName2 = COLLECTIONS_PACKAGE_FQ_NAME.child(Name.identifier(simpleName2));
            if (fqName2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "collectionsFqName"));
            }
            return fqName2;
        }

        @NotNull
        private static FqNameUnsafe rangesFqName(@NotNull String simpleName2) {
            if (simpleName2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "rangesFqName"));
            }
            FqNameUnsafe fqNameUnsafe = RANGES_PACKAGE_FQ_NAME.child(Name.identifier(simpleName2)).toUnsafe();
            if (fqNameUnsafe == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "rangesFqName"));
            }
            return fqNameUnsafe;
        }

        @NotNull
        private static FqNameUnsafe reflect(@NotNull String simpleName2) {
            if (simpleName2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "reflect"));
            }
            FqNameUnsafe fqNameUnsafe = ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME().child(Name.identifier(simpleName2)).toUnsafe();
            if (fqNameUnsafe == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "reflect"));
            }
            return fqNameUnsafe;
        }

        @NotNull
        private static FqName annotationName(@NotNull String simpleName2) {
            if (simpleName2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "simpleName", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "annotationName"));
            }
            FqName fqName2 = ANNOTATION_PACKAGE_FQ_NAME.child(Name.identifier(simpleName2));
            if (fqName2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$FqNames", "annotationName"));
            }
            return fqName2;
        }
    }

    private static class PackageFragments {
        public final PackageFragmentDescriptor builtInsPackageFragment;
        public final PackageFragmentDescriptor collectionsPackageFragment;
        public final PackageFragmentDescriptor annotationPackageFragment;
        public final Set<PackageFragmentDescriptor> allImportedByDefaultBuiltInsPackageFragments;

        private PackageFragments(@NotNull PackageFragmentDescriptor builtInsPackageFragment, @NotNull PackageFragmentDescriptor collectionsPackageFragment, @NotNull PackageFragmentDescriptor annotationPackageFragment, @NotNull Set<PackageFragmentDescriptor> allImportedByDefaultBuiltInsPackageFragments) {
            if (builtInsPackageFragment == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "builtInsPackageFragment", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$PackageFragments", "<init>"));
            }
            if (collectionsPackageFragment == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "collectionsPackageFragment", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$PackageFragments", "<init>"));
            }
            if (annotationPackageFragment == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotationPackageFragment", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$PackageFragments", "<init>"));
            }
            if (allImportedByDefaultBuiltInsPackageFragments == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "allImportedByDefaultBuiltInsPackageFragments", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$PackageFragments", "<init>"));
            }
            this.builtInsPackageFragment = builtInsPackageFragment;
            this.collectionsPackageFragment = collectionsPackageFragment;
            this.annotationPackageFragment = annotationPackageFragment;
            this.allImportedByDefaultBuiltInsPackageFragments = allImportedByDefaultBuiltInsPackageFragments;
        }
    }

    private static class Primitives {
        public final Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType;
        public final Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType;
        public final Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType;

        private Primitives(@NotNull Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType, @NotNull Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType, @NotNull Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType) {
            if (primitiveTypeToArrayKotlinType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "primitiveTypeToArrayKotlinType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives", "<init>"));
            }
            if (primitiveKotlinTypeToKotlinArrayType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "primitiveKotlinTypeToKotlinArrayType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives", "<init>"));
            }
            if (kotlinArrayTypeToPrimitiveKotlinType == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kotlinArrayTypeToPrimitiveKotlinType", "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives", "<init>"));
            }
            this.primitiveTypeToArrayKotlinType = primitiveTypeToArrayKotlinType;
            this.primitiveKotlinTypeToKotlinArrayType = primitiveKotlinTypeToKotlinArrayType;
            this.kotlinArrayTypeToPrimitiveKotlinType = kotlinArrayTypeToPrimitiveKotlinType;
        }
    }
}

