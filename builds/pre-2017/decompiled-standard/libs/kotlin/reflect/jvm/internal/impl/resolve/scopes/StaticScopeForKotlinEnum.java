/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StaticScopeForKotlinEnum
extends MemberScopeImpl {
    private final NotNullLazyValue functions$delegate;
    private final ClassDescriptor containingClass;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    @Nullable
    public Void getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return null;
    }

    private final List<SimpleFunctionDescriptor> getFunctions() {
        return (List)StorageKt.getValue(this.functions$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @NotNull
    public List<SimpleFunctionDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        return this.getFunctions();
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public ArrayList<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        Iterable iterable = this.getFunctions();
        Collection destination$iv = new ArrayList(1);
        for (Object element$iv : $receiver$iv) {
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv;
            if (!Intrinsics.areEqual(it.getName(), name2)) continue;
            destination$iv.add(element$iv);
        }
        return (ArrayList)destination$iv;
    }

    @Override
    public void printScopeStructure(@NotNull Printer p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        p.println("Static scope for " + this.containingClass);
    }

    public StaticScopeForKotlinEnum(@NotNull StorageManager storageManager, @NotNull ClassDescriptor containingClass) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(containingClass, "containingClass");
        this.containingClass = containingClass;
        boolean bl = Intrinsics.areEqual((Object)this.containingClass.getKind(), (Object)ClassKind.ENUM_CLASS);
        if (_Assertions.ENABLED && !bl) {
            String string = "Class should be an enum: " + this.containingClass;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        this.functions$delegate = storageManager.createLazyValue((Function0)new Function0<List<? extends SimpleFunctionDescriptor>>(this){
            final /* synthetic */ StaticScopeForKotlinEnum this$0;

            @NotNull
            public final List<SimpleFunctionDescriptor> invoke() {
                return CollectionsKt.listOf(new SimpleFunctionDescriptor[]{DescriptorFactory.createEnumValueOfMethod(StaticScopeForKotlinEnum.access$getContainingClass$p(this.this$0)), DescriptorFactory.createEnumValuesMethod(StaticScopeForKotlinEnum.access$getContainingClass$p(this.this$0))});
            }
            {
                this.this$0 = staticScopeForKotlinEnum;
                super(0);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(StaticScopeForKotlinEnum.class), "functions", "getFunctions()Ljava/util/List;"))};
    }

    @NotNull
    public static final /* synthetic */ ClassDescriptor access$getContainingClass$p(StaticScopeForKotlinEnum $this) {
        return $this.containingClass;
    }
}

