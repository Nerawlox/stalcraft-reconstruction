/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SubpackagesScope;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyPackageViewDescriptorImpl
extends DeclarationDescriptorImpl
implements PackageViewDescriptor {
    @NotNull
    private final NotNullLazyValue fragments$delegate;
    @NotNull
    private final MemberScope memberScope;
    @NotNull
    private final ModuleDescriptorImpl module;
    @NotNull
    private final FqName fqName;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    @Override
    @NotNull
    public List<PackageFragmentDescriptor> getFragments() {
        return (List)StorageKt.getValue(this.fragments$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    @Override
    @Nullable
    public PackageViewDescriptor getContainingDeclaration() {
        PackageViewDescriptor packageViewDescriptor;
        if (this.getFqName().isRoot()) {
            packageViewDescriptor = null;
        } else {
            ModuleDescriptorImpl moduleDescriptorImpl = this.getModule();
            FqName fqName2 = this.getFqName().parent();
            Intrinsics.checkExpressionValueIsNotNull(fqName2, "fqName.parent()");
            packageViewDescriptor = moduleDescriptorImpl.getPackage(fqName2);
        }
        return packageViewDescriptor;
    }

    public boolean equals(@Nullable Object other) {
        Object object = other;
        if (!(object instanceof PackageViewDescriptor)) {
            object = null;
        }
        PackageViewDescriptor packageViewDescriptor = (PackageViewDescriptor)object;
        if (packageViewDescriptor == null) {
            return false;
        }
        PackageViewDescriptor that = packageViewDescriptor;
        return Intrinsics.areEqual(this.getFqName(), that.getFqName()) && Intrinsics.areEqual(this.getModule(), that.getModule());
    }

    public int hashCode() {
        int result2 = this.getModule().hashCode();
        result2 = 31 * result2 + this.getFqName().hashCode();
        return result2;
    }

    @Override
    @Nullable
    public DeclarationDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        Intrinsics.checkParameterIsNotNull(substitutor, "substitutor");
        return this;
    }

    @Override
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        return visitor2.visitPackageViewDescriptor(this, data2);
    }

    @Override
    @NotNull
    public ModuleDescriptorImpl getModule() {
        return this.module;
    }

    @Override
    @NotNull
    public FqName getFqName() {
        return this.fqName;
    }

    public LazyPackageViewDescriptorImpl(@NotNull ModuleDescriptorImpl module, @NotNull FqName fqName2, @NotNull StorageManager storageManager) {
        Intrinsics.checkParameterIsNotNull(module, "module");
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        super(Annotations.Companion.getEMPTY(), fqName2.shortNameOrSpecial());
        this.module = module;
        this.fqName = fqName2;
        this.fragments$delegate = storageManager.createLazyValue((Function0)new Function0<List<? extends PackageFragmentDescriptor>>(this){
            final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

            @NotNull
            public final List<PackageFragmentDescriptor> invoke() {
                return this.this$0.getModule().getPackageFragmentProvider().getPackageFragments(this.this$0.getFqName());
            }
            {
                this.this$0 = lazyPackageViewDescriptorImpl;
                super(0);
            }
        });
        this.memberScope = new LazyScopeAdapter(storageManager.createLazyValue((Function0)new Function0<MemberScope>(this){
            final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final MemberScope invoke() {
                MemberScope memberScope2;
                if (this.this$0.getFragments().isEmpty()) {
                    memberScope2 = MemberScope.Empty.INSTANCE;
                } else {
                    void var3_3;
                    void $receiver$iv$iv;
                    Iterable $receiver$iv;
                    Iterable iterable = $receiver$iv = (Iterable)this.this$0.getFragments();
                    Collection destination$iv$iv = new ArrayList<E>(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
                    for (T item$iv$iv : $receiver$iv$iv) {
                        void it;
                        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor)item$iv$iv;
                        Collection collection = destination$iv$iv;
                        MemberScope memberScope3 = it.getMemberScope();
                        collection.add(memberScope3);
                    }
                    List<SubpackagesScope> scopes = CollectionsKt.plus((Collection)((List)var3_3), new SubpackagesScope(this.this$0.getModule(), this.this$0.getFqName()));
                    memberScope2 = new ChainedMemberScope("package view scope for " + this.this$0.getFqName() + " in " + this.this$0.getModule().getName(), scopes);
                }
                return memberScope2;
            }
            {
                this.this$0 = lazyPackageViewDescriptorImpl;
                super(0);
            }
        }));
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(LazyPackageViewDescriptorImpl.class), "fragments", "getFragments()Ljava/util/List;"))};
    }

    @Override
    public boolean isEmpty() {
        return PackageViewDescriptor.DefaultImpls.isEmpty(this);
    }
}

