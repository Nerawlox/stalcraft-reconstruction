/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.components.ExternalAnnotationResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.RuntimeErrorReporter;
import kotlin.reflect.jvm.internal.impl.load.java.components.RuntimeSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.components.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.reflect.ReflectJavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.BinaryClassAnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializationComponentsForJava;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JavaClassDataFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.RuntimePackagePartProvider;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class RuntimeModuleData {
    @NotNull
    private final DeserializationComponents deserialization;
    @NotNull
    private final RuntimePackagePartProvider packageFacadeProvider;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final ModuleDescriptor getModule() {
        return this.deserialization.getModuleDescriptor();
    }

    @NotNull
    public final DeserializationComponents getDeserialization() {
        return this.deserialization;
    }

    @NotNull
    public final RuntimePackagePartProvider getPackageFacadeProvider() {
        return this.packageFacadeProvider;
    }

    private RuntimeModuleData(DeserializationComponents deserialization, RuntimePackagePartProvider packageFacadeProvider) {
        this.deserialization = deserialization;
        this.packageFacadeProvider = packageFacadeProvider;
    }

    public /* synthetic */ RuntimeModuleData(@NotNull DeserializationComponents deserialization, @NotNull RuntimePackagePartProvider packageFacadeProvider, DefaultConstructorMarker $constructor_marker) {
        this(deserialization, packageFacadeProvider);
    }

    public static final class Companion {
        @NotNull
        public final RuntimeModuleData create(@NotNull ClassLoader classLoader) {
            Intrinsics.checkParameterIsNotNull(classLoader, "classLoader");
            LockBasedStorageManager storageManager = new LockBasedStorageManager();
            JvmBuiltIns builtIns = new JvmBuiltIns(storageManager, false, 2, null);
            Name name2 = Name.special("<runtime module for " + classLoader + ">");
            Intrinsics.checkExpressionValueIsNotNull(name2, "Name.special(\"<runtime module for $classLoader>\")");
            ModuleDescriptorImpl module = new ModuleDescriptorImpl(name2, storageManager, builtIns, null, null, null, 56, null);
            ReflectKotlinClassFinder reflectKotlinClassFinder = new ReflectKotlinClassFinder(classLoader);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            SingleModuleClassResolver singleModuleClassResolver = new SingleModuleClassResolver();
            RuntimePackagePartProvider runtimePackageFacadeProvider = new RuntimePackagePartProvider(classLoader);
            JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
            StorageManager storageManager2 = storageManager;
            JavaClassFinder javaClassFinder = new ReflectJavaClassFinder(classLoader);
            KotlinClassFinder kotlinClassFinder = reflectKotlinClassFinder;
            ExternalAnnotationResolver externalAnnotationResolver = ExternalAnnotationResolver.EMPTY;
            Intrinsics.checkExpressionValueIsNotNull(externalAnnotationResolver, "ExternalAnnotationResolver.EMPTY");
            SignaturePropagator signaturePropagator = SignaturePropagator.DO_NOTHING;
            Intrinsics.checkExpressionValueIsNotNull(signaturePropagator, "SignaturePropagator.DO_NOTHING");
            ErrorReporter errorReporter = RuntimeErrorReporter.INSTANCE;
            JavaResolverCache javaResolverCache2 = javaResolverCache;
            Intrinsics.checkExpressionValueIsNotNull(javaResolverCache2, "javaResolverCache");
            JavaResolverComponents globalJavaResolverContext = new JavaResolverComponents(storageManager2, javaClassFinder, kotlinClassFinder, deserializedDescriptorResolver, externalAnnotationResolver, signaturePropagator, errorReporter, javaResolverCache2, JavaPropertyInitializerEvaluator.DoNothing.INSTANCE, SamConversionResolver.EMPTY, RuntimeSourceElementFactory.INSTANCE, singleModuleClassResolver, runtimePackageFacadeProvider, SupertypeLoopChecker.EMPTY.INSTANCE, LookupTracker.Companion.getDO_NOTHING(), module, new ReflectionTypes(module));
            LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider = new LazyJavaPackageFragmentProvider(globalJavaResolverContext);
            builtIns.initialize(module, true);
            JavaResolverCache javaResolverCache3 = javaResolverCache;
            Intrinsics.checkExpressionValueIsNotNull(javaResolverCache3, "javaResolverCache");
            JavaDescriptorResolver javaDescriptorResolver = new JavaDescriptorResolver(lazyJavaPackageFragmentProvider, javaResolverCache3);
            JavaClassDataFinder javaClassDataFinder = new JavaClassDataFinder(reflectKotlinClassFinder, deserializedDescriptorResolver);
            NotFoundClasses notFoundClasses = new NotFoundClasses(storageManager, module);
            BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoader = new BinaryClassAnnotationAndConstantLoaderImpl(module, notFoundClasses, storageManager, reflectKotlinClassFinder);
            DeserializationComponentsForJava deserializationComponentsForJava = new DeserializationComponentsForJava(storageManager, module, DeserializationConfiguration.Default.INSTANCE, javaClassDataFinder, binaryClassAnnotationAndConstantLoader, lazyJavaPackageFragmentProvider, notFoundClasses, RuntimeErrorReporter.INSTANCE, LookupTracker.Companion.getDO_NOTHING());
            singleModuleClassResolver.setResolver(javaDescriptorResolver);
            deserializedDescriptorResolver.setComponents(deserializationComponentsForJava);
            ModuleDescriptorImpl[] moduleDescriptorImplArray = new ModuleDescriptorImpl[2];
            moduleDescriptorImplArray[0] = module;
            ModuleDescriptorImpl moduleDescriptorImpl = builtIns.getBuiltInsModule();
            Intrinsics.checkExpressionValueIsNotNull(moduleDescriptorImpl, "builtIns.builtInsModule");
            moduleDescriptorImplArray[1] = moduleDescriptorImpl;
            module.setDependencies(moduleDescriptorImplArray);
            module.initialize(javaDescriptorResolver.getPackageFragmentProvider());
            return new RuntimeModuleData(deserializationComponentsForJava.getComponents(), runtimePackageFacadeProvider, null);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

