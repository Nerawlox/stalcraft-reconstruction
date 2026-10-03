/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaPackageFragmentProvider
implements PackageFragmentProvider {
    private final LazyJavaResolverContext c;
    private final MemoizedFunctionToNullable<FqName, LazyJavaPackageFragment> packageFragments;

    private final LazyJavaPackageFragment getPackageFragment(FqName fqName2) {
        return (LazyJavaPackageFragment)this.packageFragments.invoke(fqName2);
    }

    @NotNull
    public List<LazyJavaPackageFragment> getPackageFragments(@NotNull FqName fqName2) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        return CollectionsKt.emptyOrSingletonList(this.getPackageFragment(fqName2));
    }

    @NotNull
    public List<FqName> getSubPackagesOf(@NotNull FqName fqName2, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        LazyJavaPackageFragment lazyJavaPackageFragment = this.getPackageFragment(fqName2);
        List<FqName> list = lazyJavaPackageFragment != null ? lazyJavaPackageFragment.getSubPackageFqNames$kotlin_core() : null;
        List<FqName> list2 = list;
        if (list2 == null) {
            list2 = kotlin.collections.CollectionsKt.emptyList();
        }
        return list2;
    }

    public LazyJavaPackageFragmentProvider(@NotNull JavaResolverComponents components) {
        Intrinsics.checkParameterIsNotNull(components, "components");
        this.c = new LazyJavaResolverContext(components, TypeParameterResolver.EMPTY.INSTANCE);
        this.packageFragments = this.c.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new Function1<FqName, LazyJavaPackageFragment>(this){
            final /* synthetic */ LazyJavaPackageFragmentProvider this$0;

            @Nullable
            public final LazyJavaPackageFragment invoke(@NotNull FqName fqName2) {
                Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
                JavaPackage jPackage = LazyJavaPackageFragmentProvider.access$getC$p(this.this$0).getComponents().getFinder().findPackage(fqName2);
                return jPackage != null ? new LazyJavaPackageFragment(LazyJavaPackageFragmentProvider.access$getC$p(this.this$0), jPackage) : null;
            }
            {
                this.this$0 = lazyJavaPackageFragmentProvider;
                super(1);
            }
        });
    }

    @NotNull
    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(LazyJavaPackageFragmentProvider $this) {
        return $this.c;
    }
}

