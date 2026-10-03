/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInSerializerProtocol;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public final class BuiltInsPackageFragmentProviderKt {
    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final PackageFragmentProvider createBuiltInPackageFragmentProvider(@NotNull StorageManager storageManager, @NotNull ModuleDescriptor module, @NotNull Set<FqName> packageFqNames, @NotNull Iterable<? extends ClassDescriptorFactory> classDescriptorFactories, @NotNull PlatformDependentDeclarationFilter platformDependentDeclarationFilter, @NotNull AdditionalClassPartsProvider additionalClassPartsProvider, @NotNull Function1<? super String, ? extends InputStream> loadResource) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(packageFqNames, "packageFqNames");
        Intrinsics.checkParameterIsNotNull(classDescriptorFactories, "classDescriptorFactories");
        Intrinsics.checkParameterIsNotNull(platformDependentDeclarationFilter, "platformDependentDeclarationFilter");
        Intrinsics.checkParameterIsNotNull(additionalClassPartsProvider, "additionalClassPartsProvider");
        Intrinsics.checkParameterIsNotNull(loadResource, "loadResource");
        Iterable iterable = $receiver$iv = (Iterable)packageFqNames;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            InputStream inputStream;
            void fqName2;
            FqName fqName3 = (FqName)item$iv$iv;
            Collection collection = destination$iv$iv;
            String resourcePath = BuiltInSerializerProtocol.INSTANCE.getBuiltInsFilePath((FqName)fqName2);
            if (loadResource.invoke(resourcePath) == null) {
                throw (Throwable)new IllegalStateException("Resource not found in classpath: " + resourcePath);
            }
            BuiltInsPackageFragment builtInsPackageFragment = new BuiltInsPackageFragment((FqName)fqName2, storageManager, module, inputStream);
            collection.add(builtInsPackageFragment);
        }
        List packageFragments2 = (List)destination$iv$iv;
        PackageFragmentProviderImpl provider = new PackageFragmentProviderImpl(packageFragments2);
        NotFoundClasses notFoundClasses = new NotFoundClasses(storageManager, module);
        DeserializationConfiguration deserializationConfiguration = DeserializationConfiguration.Default.INSTANCE;
        ClassDataFinder classDataFinder2 = new DeserializedClassDataFinder(provider);
        AnnotationAndConstantLoader annotationAndConstantLoader = new AnnotationAndConstantLoaderImpl(module, notFoundClasses, BuiltInSerializerProtocol.INSTANCE);
        PackageFragmentProvider packageFragmentProvider = provider;
        LocalClassifierTypeSettings localClassifierTypeSettings = LocalClassifierTypeSettings.Default.INSTANCE;
        ErrorReporter errorReporter = ErrorReporter.DO_NOTHING;
        Intrinsics.checkExpressionValueIsNotNull(errorReporter, "ErrorReporter.DO_NOTHING");
        DeserializationComponents components = new DeserializationComponents(storageManager, module, deserializationConfiguration, classDataFinder2, annotationAndConstantLoader, packageFragmentProvider, localClassifierTypeSettings, errorReporter, LookupTracker.Companion.getDO_NOTHING(), FlexibleTypeDeserializer.ThrowException.INSTANCE, classDescriptorFactories, notFoundClasses, additionalClassPartsProvider, platformDependentDeclarationFilter);
        for (BuiltInsPackageFragment packageFragment : packageFragments2) {
            packageFragment.setComponents(components);
        }
        return provider;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ PackageFragmentProvider createBuiltInPackageFragmentProvider$default(StorageManager storageManager, ModuleDescriptor moduleDescriptor, Set set, Iterable iterable, PlatformDependentDeclarationFilter platformDependentDeclarationFilter, AdditionalClassPartsProvider additionalClassPartsProvider, Function1 function1, int n, Object object) {
        if ((n & 0x20) != 0) {
            additionalClassPartsProvider = AdditionalClassPartsProvider.None.INSTANCE;
        }
        return BuiltInsPackageFragmentProviderKt.createBuiltInPackageFragmentProvider(storageManager, moduleDescriptor, set, iterable, platformDependentDeclarationFilter, additionalClassPartsProvider, function1);
    }
}

