/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

public final class PackageFragmentProviderImpl
implements PackageFragmentProvider {
    private final Collection<PackageFragmentDescriptor> packageFragments;

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName fqName2) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        Iterable iterable = $receiver$iv = (Iterable)this.packageFragments;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            PackageFragmentDescriptor it = (PackageFragmentDescriptor)element$iv$iv;
            if (!Intrinsics.areEqual(it.getFqName(), fqName2)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @Override
    @NotNull
    public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName2, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        return SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable)this.packageFragments), getSubPackagesOf.1.INSTANCE), (Function1)new Function1<FqName, Boolean>(fqName2){
            final /* synthetic */ FqName $fqName;

            public final boolean invoke(@NotNull FqName it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return !it.isRoot() && Intrinsics.areEqual(it.parent(), this.$fqName);
            }
            {
                this.$fqName = fqName2;
                super(1);
            }
        }));
    }

    public PackageFragmentProviderImpl(@NotNull Collection<? extends PackageFragmentDescriptor> packageFragments2) {
        Intrinsics.checkParameterIsNotNull(packageFragments2, "packageFragments");
        this.packageFragments = packageFragments2;
    }
}

