/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependencies;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDependenciesImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.MultiTargetPlatform;
import kotlin.reflect.jvm.internal.impl.resolve.MultiTargetPlatformKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ModuleDescriptorImpl
extends DeclarationDescriptorImpl
implements ModuleDescriptor {
    private final Map<ModuleDescriptor.Capability<? extends Object>, Object> capabilities;
    private ModuleDependencies dependencies;
    private PackageFragmentProvider packageFragmentProviderForModuleContent;
    private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;
    @NotNull
    private final Set<ModuleDescriptor> allImplementingModules;
    private final Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;
    private final StorageManager storageManager;
    @NotNull
    private final KotlinBuiltIns builtIns;
    @NotNull
    private final SourceKind sourceKind;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    @Deprecated(message="This method is not going to be supported. Please do not use it")
    private static /* synthetic */ void testOnly_AllDependentModules$annotations() {
    }

    @NotNull
    public final List<ModuleDescriptorImpl> getTestOnly_AllDependentModules() {
        ModuleDependencies moduleDependencies = this.dependencies;
        if (moduleDependencies == null) {
            Intrinsics.throwNpe();
        }
        return moduleDependencies.getAllDependencies();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<ModuleDescriptor> getAllDependencyModules() {
        void $receiver$iv$iv;
        Object $receiver$iv = this.dependencies;
        ModuleDependencies moduleDependencies = $receiver$iv;
        if (moduleDependencies == null) {
            AssertionError assertionError;
            AssertionError assertionError2 = assertionError;
            AssertionError assertionError3 = assertionError;
            String string = "Dependencies of module " + this.getId() + " were not set";
            assertionError2((Object)string);
            throw (Throwable)((Object)assertionError3);
        }
        Object $i$a$1$sure = $receiver$iv = (Iterable)moduleDependencies.getAllDependencies();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            ModuleDescriptorImpl it = (ModuleDescriptorImpl)element$iv$iv;
            if (!(Intrinsics.areEqual(it, this) ^ true)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @Override
    @NotNull
    public Set<ModuleDescriptor> getAllImplementingModules() {
        return this.allImplementingModules;
    }

    @Override
    @NotNull
    public PackageViewDescriptor getPackage(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return (PackageViewDescriptor)this.packages.invoke(fqName2);
    }

    @Override
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName2, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        return this.getPackageFragmentProvider().getSubPackagesOf(fqName2, nameFilter);
    }

    private final CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies() {
        Lazy lazy = this.packageFragmentProviderForWholeModuleWithDependencies$delegate;
        ModuleDescriptorImpl moduleDescriptorImpl = this;
        KProperty kProperty = $$delegatedProperties[0];
        return (CompositePackageFragmentProvider)lazy.getValue();
    }

    private final boolean isInitialized() {
        return this.packageFragmentProviderForModuleContent != null;
    }

    public final void setDependencies(@NotNull ModuleDependencies dependencies) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(dependencies, "dependencies");
        boolean bl2 = bl = this.dependencies == null;
        if (_Assertions.ENABLED && !bl) {
            String string = "Dependencies of " + this.getId() + " were already set";
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        this.dependencies = dependencies;
        if (Intrinsics.areEqual(MultiTargetPlatformKt.getMultiTargetPlatform(this), MultiTargetPlatform.Common.INSTANCE)) {
            return;
        }
        for (ModuleDescriptor dependencyModule : this.getAllDependencyModules()) {
            Object object;
            if (Intrinsics.areEqual(MultiTargetPlatformKt.getMultiTargetPlatform(dependencyModule), MultiTargetPlatform.Common.INSTANCE) ^ true || Intrinsics.areEqual((Object)dependencyModule.getSourceKind(), (Object)this.getSourceKind()) ^ true) continue;
            ModuleDescriptor moduleDescriptor = dependencyModule;
            if (!(moduleDescriptor instanceof ModuleDescriptorImpl)) {
                moduleDescriptor = null;
            }
            if ((object = (ModuleDescriptorImpl)moduleDescriptor) == null || (object = ((ModuleDescriptorImpl)object).getAllImplementingModules()) == null) continue;
            object.add(this);
        }
    }

    public final void setDependencies(ModuleDescriptorImpl ... descriptors) {
        Intrinsics.checkParameterIsNotNull(descriptors, "descriptors");
        this.setDependencies(ArraysKt.toList((Object[])descriptors));
    }

    public final void setDependencies(@NotNull List<ModuleDescriptorImpl> descriptors) {
        Intrinsics.checkParameterIsNotNull(descriptors, "descriptors");
        this.setDependencies(new ModuleDependenciesImpl(descriptors, SetsKt.<ModuleDescriptorImpl>emptySet()));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor targetModule) {
        Intrinsics.checkParameterIsNotNull(targetModule, "targetModule");
        if (Intrinsics.areEqual(this, targetModule)) return true;
        ModuleDependencies moduleDependencies = this.dependencies;
        if (moduleDependencies == null) {
            Intrinsics.throwNpe();
        }
        if (!CollectionsKt.contains((Iterable)moduleDependencies.getModulesWhoseInternalsAreVisible(), targetModule)) return false;
        return true;
    }

    private final String getId() {
        String string = this.getName().toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "name.toString()");
        return string;
    }

    public final void initialize(@NotNull PackageFragmentProvider providerForModuleContent) {
        boolean bl;
        Intrinsics.checkParameterIsNotNull(providerForModuleContent, "providerForModuleContent");
        boolean bl2 = bl = !this.isInitialized();
        if (_Assertions.ENABLED && !bl) {
            String string = "Attempt to initialize module " + this.getId() + " twice";
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        this.packageFragmentProviderForModuleContent = providerForModuleContent;
    }

    @NotNull
    public final PackageFragmentProvider getPackageFragmentProvider() {
        return this.getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    @Override
    @Nullable
    public <T> T getCapability(@NotNull ModuleDescriptor.Capability<T> capability) {
        Intrinsics.checkParameterIsNotNull(capability, "capability");
        Object object = this.capabilities.get(capability);
        if (!(object instanceof Object)) {
            object = null;
        }
        return (T)object;
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    @Override
    @NotNull
    public SourceKind getSourceKind() {
        return this.sourceKind;
    }

    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name moduleName, @NotNull StorageManager storageManager, @NotNull KotlinBuiltIns builtIns, @Nullable MultiTargetPlatform multiTargetPlatform, @NotNull SourceKind sourceKind, @NotNull Map<ModuleDescriptor.Capability<?>, ? extends Object> capabilities) {
        ModuleDescriptorImpl moduleDescriptorImpl;
        Object object;
        Map<ModuleDescriptor.Capability<MultiTargetPlatform>, MultiTargetPlatform> map2;
        Map<ModuleDescriptor.Capability<?>, Object> map3;
        block5: {
            block4: {
                Intrinsics.checkParameterIsNotNull(moduleName, "moduleName");
                Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
                Intrinsics.checkParameterIsNotNull(builtIns, "builtIns");
                Intrinsics.checkParameterIsNotNull((Object)sourceKind, "sourceKind");
                Intrinsics.checkParameterIsNotNull(capabilities, "capabilities");
                super(Annotations.Companion.getEMPTY(), moduleName);
                this.storageManager = storageManager;
                this.builtIns = builtIns;
                this.sourceKind = sourceKind;
                if (!moduleName.isSpecial()) {
                    throw (Throwable)new IllegalArgumentException("Module name must be special: " + moduleName);
                }
                ModuleDescriptorImpl moduleDescriptorImpl2 = this;
                map3 = capabilities;
                map2 = multiTargetPlatform;
                if (map2 == null) break block4;
                MultiTargetPlatform multiTargetPlatform2 = map2;
                object = map3;
                moduleDescriptorImpl = moduleDescriptorImpl2;
                MultiTargetPlatform it = multiTargetPlatform2;
                Map<ModuleDescriptor.Capability<MultiTargetPlatform>, MultiTargetPlatform> map4 = MapsKt.mapOf(TuplesKt.to(MultiTargetPlatform.CAPABILITY, it));
                moduleDescriptorImpl2 = moduleDescriptorImpl;
                map3 = object;
                map2 = map4;
                if (map2 != null) break block5;
            }
            map2 = MapsKt.emptyMap();
        }
        moduleDescriptorImpl2.capabilities = MapsKt.plus(map3, map2);
        this.packages = this.storageManager.createMemoizedFunction((Function1)new Function1<FqName, LazyPackageViewDescriptorImpl>(this){
            final /* synthetic */ ModuleDescriptorImpl this$0;

            @NotNull
            public final LazyPackageViewDescriptorImpl invoke(@NotNull FqName fqName2) {
                Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
                return new LazyPackageViewDescriptorImpl(this.this$0, fqName2, ModuleDescriptorImpl.access$getStorageManager$p(this.this$0));
            }
            {
                this.this$0 = moduleDescriptorImpl;
                super(1);
            }
        });
        moduleDescriptorImpl = this;
        moduleDescriptorImpl.allImplementingModules = object = (Set)new LinkedHashSet();
        this.packageFragmentProviderForWholeModuleWithDependencies$delegate = LazyKt.lazy((Function0)new Function0<CompositePackageFragmentProvider>(this){
            final /* synthetic */ ModuleDescriptorImpl this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final CompositePackageFragmentProvider invoke() {
                Collection<PackageFragmentProvider> collection;
                void $receiver$iv$iv;
                CompositePackageFragmentProvider compositePackageFragmentProvider;
                ModuleDependencies $receiver$iv;
                ModuleDependencies moduleDependencies = $receiver$iv = ModuleDescriptorImpl.access$getDependencies$p(this.this$0);
                if (moduleDependencies == null) {
                    AssertionError assertionError;
                    AssertionError assertionError2 = assertionError;
                    AssertionError assertionError3 = assertionError;
                    String string = "Dependencies of module " + ModuleDescriptorImpl.access$getId$p(this.this$0) + " were not set before querying module content";
                    assertionError2((Object)string);
                    throw (Throwable)((Object)assertionError3);
                }
                ModuleDependencies moduleDependencies2 = moduleDependencies;
                List<ModuleDescriptorImpl> dependenciesDescriptors = moduleDependencies2.getAllDependencies();
                boolean $i$a$1$sure = dependenciesDescriptors.contains(this.this$0);
                if (_Assertions.ENABLED && !$i$a$1$sure) {
                    String string = "Module " + ModuleDescriptorImpl.access$getId$p(this.this$0) + " is not contained in his own dependencies, this is probably a misconfiguration";
                    throw (Throwable)((Object)new AssertionError((Object)string));
                }
                Iterable $receiver$iv2 = dependenciesDescriptors;
                for (T element$iv : $receiver$iv2) {
                    ModuleDescriptorImpl dependency = (ModuleDescriptorImpl)element$iv;
                    boolean bl = ModuleDescriptorImpl.access$isInitialized$p(dependency);
                    if (!_Assertions.ENABLED || bl) continue;
                    String string = "Dependency module " + ModuleDescriptorImpl.access$getId$p(dependency) + " was not initialized by the time contents of dependent module " + ModuleDescriptorImpl.access$getId$p(this.this$0) + " were queried";
                    throw (Throwable)((Object)new AssertionError((Object)string));
                }
                $receiver$iv2 = dependenciesDescriptors;
                CompositePackageFragmentProvider compositePackageFragmentProvider2 = compositePackageFragmentProvider;
                CompositePackageFragmentProvider compositePackageFragmentProvider3 = compositePackageFragmentProvider;
                Iterable $i$a$1$assert = $receiver$iv2;
                Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv2, 10));
                for (T item$iv$iv : $receiver$iv$iv) {
                    PackageFragmentProvider packageFragmentProvider;
                    void it;
                    ModuleDescriptorImpl moduleDescriptorImpl = (ModuleDescriptorImpl)item$iv$iv;
                    collection = destination$iv$iv;
                    if (ModuleDescriptorImpl.access$getPackageFragmentProviderForModuleContent$p((ModuleDescriptorImpl)it) == null) {
                        Intrinsics.throwNpe();
                    }
                    collection.add(packageFragmentProvider);
                }
                collection = (List)destination$iv$iv;
                compositePackageFragmentProvider2((List<? extends PackageFragmentProvider>)collection);
                return compositePackageFragmentProvider3;
            }
            {
                this.this$0 = moduleDescriptorImpl;
                super(0);
            }
        });
    }

    @JvmOverloads
    public /* synthetic */ ModuleDescriptorImpl(Name name2, StorageManager storageManager, KotlinBuiltIns kotlinBuiltIns, MultiTargetPlatform multiTargetPlatform, SourceKind sourceKind, Map map2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 8) != 0) {
            multiTargetPlatform = null;
        }
        if ((n & 0x10) != 0) {
            sourceKind = SourceKind.NONE;
        }
        if ((n & 0x20) != 0) {
            map2 = MapsKt.emptyMap();
        }
        this(name2, storageManager, kotlinBuiltIns, multiTargetPlatform, sourceKind, map2);
    }

    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name moduleName, @NotNull StorageManager storageManager, @NotNull KotlinBuiltIns builtIns, @Nullable MultiTargetPlatform multiTargetPlatform, @NotNull SourceKind sourceKind) {
        this(moduleName, storageManager, builtIns, multiTargetPlatform, sourceKind, null, 32, null);
    }

    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name moduleName, @NotNull StorageManager storageManager, @NotNull KotlinBuiltIns builtIns, @Nullable MultiTargetPlatform multiTargetPlatform) {
        this(moduleName, storageManager, builtIns, multiTargetPlatform, null, null, 48, null);
    }

    @JvmOverloads
    public ModuleDescriptorImpl(@NotNull Name moduleName, @NotNull StorageManager storageManager, @NotNull KotlinBuiltIns builtIns) {
        this(moduleName, storageManager, builtIns, null, null, null, 56, null);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ModuleDescriptorImpl.class), "packageFragmentProviderForWholeModuleWithDependencies", "getPackageFragmentProviderForWholeModuleWithDependencies()Lorg/jetbrains/kotlin/descriptors/impl/CompositePackageFragmentProvider;"))};
    }

    @Override
    @Nullable
    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    @Override
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        return ModuleDescriptor.DefaultImpls.accept(this, visitor2, data2);
    }

    @Override
    @NotNull
    public ModuleDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        Intrinsics.checkParameterIsNotNull(substitutor, "substitutor");
        return ModuleDescriptor.DefaultImpls.substitute(this, substitutor);
    }

    @NotNull
    public static final /* synthetic */ StorageManager access$getStorageManager$p(ModuleDescriptorImpl $this) {
        return $this.storageManager;
    }

    @Nullable
    public static final /* synthetic */ ModuleDependencies access$getDependencies$p(ModuleDescriptorImpl $this) {
        return $this.dependencies;
    }

    public static final /* synthetic */ void access$setDependencies$p(ModuleDescriptorImpl $this, @Nullable ModuleDependencies moduleDependencies) {
        $this.dependencies = moduleDependencies;
    }

    @NotNull
    public static final /* synthetic */ String access$getId$p(ModuleDescriptorImpl $this) {
        return $this.getId();
    }

    public static final /* synthetic */ boolean access$isInitialized$p(ModuleDescriptorImpl $this) {
        return $this.isInitialized();
    }

    @Nullable
    public static final /* synthetic */ PackageFragmentProvider access$getPackageFragmentProviderForModuleContent$p(ModuleDescriptorImpl $this) {
        return $this.packageFragmentProviderForModuleContent;
    }

    public static final /* synthetic */ void access$setPackageFragmentProviderForModuleContent$p(ModuleDescriptorImpl $this, @Nullable PackageFragmentProvider packageFragmentProvider) {
        $this.packageFragmentProviderForModuleContent = packageFragmentProvider;
    }
}

