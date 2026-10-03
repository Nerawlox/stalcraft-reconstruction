/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaDescriptorResolver {
    @NotNull
    private final LazyJavaPackageFragmentProvider packageFragmentProvider;
    private final JavaResolverCache javaResolverCache;

    @Nullable
    public final ClassDescriptor resolveClass(@NotNull JavaClass javaClass) {
        Intrinsics.checkParameterIsNotNull(javaClass, "javaClass");
        FqName fqName2 = javaClass.getFqName();
        if (fqName2 != null && Intrinsics.areEqual((Object)javaClass.getLightClassOriginKind(), (Object)LightClassOriginKind.SOURCE)) {
            return this.javaResolverCache.getClassResolvedFromSource(fqName2);
        }
        JavaClass javaClass2 = javaClass.getOuterClass();
        if (javaClass2 != null) {
            MemberScope outerClassScope;
            JavaClass javaClass3;
            JavaClass outerClass = javaClass3 = javaClass2;
            ClassDescriptor classDescriptor = this.resolveClass(outerClass);
            MemberScope memberScope2 = outerClassScope = classDescriptor != null ? classDescriptor.getUnsubstitutedInnerClassesScope() : null;
            ClassifierDescriptor classifierDescriptor = memberScope2 != null ? memberScope2.getContributedClassifier(javaClass.getName(), NoLookupLocation.FROM_JAVA_LOADER) : null;
            if (!(classifierDescriptor instanceof ClassDescriptor)) {
                classifierDescriptor = null;
            }
            return (ClassDescriptor)classifierDescriptor;
        }
        if (fqName2 == null) {
            return null;
        }
        FqName fqName3 = fqName2.parent();
        Intrinsics.checkExpressionValueIsNotNull(fqName3, "fqName.parent()");
        LazyJavaPackageFragment lazyJavaPackageFragment = CollectionsKt.firstOrNull(this.packageFragmentProvider.getPackageFragments(fqName3));
        return lazyJavaPackageFragment != null ? lazyJavaPackageFragment.findClassifierByJavaClass$kotlin_core(javaClass) : null;
    }

    @NotNull
    public final LazyJavaPackageFragmentProvider getPackageFragmentProvider() {
        return this.packageFragmentProvider;
    }

    public JavaDescriptorResolver(@NotNull LazyJavaPackageFragmentProvider packageFragmentProvider, @NotNull JavaResolverCache javaResolverCache) {
        Intrinsics.checkParameterIsNotNull(packageFragmentProvider, "packageFragmentProvider");
        Intrinsics.checkParameterIsNotNull(javaResolverCache, "javaResolverCache");
        this.packageFragmentProvider = packageFragmentProvider;
        this.javaResolverCache = javaResolverCache;
    }
}

