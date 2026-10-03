/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.javax.inject.Inject;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

public abstract class DeserializedPackageFragment
extends PackageFragmentDescriptorImpl {
    @NotNull
    public DeserializationComponents components;
    private final NotNullLazyValue<MemberScope> memberScope;
    @NotNull
    private final StorageManager storageManager;

    @NotNull
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents == null) {
            Intrinsics.throwUninitializedPropertyAccessException("components");
        }
        return deserializationComponents;
    }

    @Inject
    public final void setComponents(@NotNull DeserializationComponents deserializationComponents) {
        Intrinsics.checkParameterIsNotNull(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    @NotNull
    public abstract ClassDataFinder getClassDataFinder();

    @NotNull
    protected abstract MemberScope computeMemberScope();

    @Override
    @NotNull
    public MemberScope getMemberScope() {
        return (MemberScope)this.memberScope.invoke();
    }

    public boolean hasTopLevelClass(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        MemberScope scope = this.getMemberScope();
        return scope instanceof DeserializedMemberScope && ((DeserializedMemberScope)scope).getClassNames$kotlin_core().contains(name2);
    }

    @NotNull
    protected final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public DeserializedPackageFragment(@NotNull FqName fqName2, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor module) {
        Intrinsics.checkParameterIsNotNull(fqName2, "fqName");
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(module, "module");
        super(module, fqName2);
        this.storageManager = storageManager;
        this.memberScope = this.storageManager.createLazyValue((Function0)new Function0<MemberScope>(this){
            final /* synthetic */ DeserializedPackageFragment this$0;

            @NotNull
            public final MemberScope invoke() {
                return this.this$0.computeMemberScope();
            }
            {
                this.this$0 = deserializedPackageFragment;
                super(0);
            }
        });
    }
}

