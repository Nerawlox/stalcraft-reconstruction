/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;

public abstract class GivenFunctionsMemberScope
extends MemberScopeImpl {
    private final NotNullLazyValue allDescriptors$delegate;
    @NotNull
    private final ClassDescriptor containingClass;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    private final List<DeclarationDescriptor> getAllDescriptors() {
        return (List)StorageKt.getValue(this.allDescriptors$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @NotNull
    protected abstract List<FunctionDescriptor> computeDeclaredFunctions();

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        if (!kindFilter.acceptsKinds(DescriptorKindFilter.CALLABLES.getKindMask())) {
            return CollectionsKt.emptyList();
        }
        return this.getAllDescriptors();
    }

    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        Iterable iterable = $receiver$iv = (Iterable)this.getAllDescriptors();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            if (!(element$iv$iv instanceof SimpleFunctionDescriptor)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            SimpleFunctionDescriptor it = (SimpleFunctionDescriptor)element$iv$iv;
            if (!Intrinsics.areEqual(it.getName(), name2)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
        Iterable $receiver$iv$iv;
        Iterable $receiver$iv;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        Iterable iterable = $receiver$iv = (Iterable)this.getAllDescriptors();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            if (!(element$iv$iv instanceof PropertyDescriptor)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        $receiver$iv = (List)destination$iv$iv;
        $receiver$iv$iv = $receiver$iv;
        destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            PropertyDescriptor it = (PropertyDescriptor)element$iv$iv;
            if (!Intrinsics.areEqual(it.getName(), name2)) continue;
            destination$iv$iv.add(element$iv$iv);
        }
        return (List)destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private final List<DeclarationDescriptor> createFakeOverrides(List<? extends FunctionDescriptor> functionsFromCurrent) {
        Object key$iv$iv;
        Object it;
        void $receiver$iv$iv;
        Object $receiver$iv;
        void $receiver$iv$iv2;
        Iterable $receiver$iv$iv22;
        ArrayList result2 = new ArrayList(3);
        Iterable $receiver$iv2 = this.containingClass.getTypeConstructor().getSupertypes();
        Object object = $receiver$iv2;
        Collection destination$iv$iv = new ArrayList();
        for (Object entry22 : $receiver$iv$iv22) {
            KotlinType it2 = (KotlinType)entry22;
            Iterable list$iv$iv = ResolutionScope.DefaultImpls.getContributedDescriptors$default(it2.getMemberScope(), null, null, 3, null);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterable $receiver$iv3 = (List)destination$iv$iv;
        $receiver$iv$iv22 = $receiver$iv3;
        destination$iv$iv = new ArrayList();
        for (Object t : $receiver$iv$iv2) {
            if (!(t instanceof CallableMemberDescriptor)) continue;
            destination$iv$iv.add(t);
        }
        List allSuperDescriptors = (List)destination$iv$iv;
        Object object2 = $receiver$iv = (Iterable)allSuperDescriptors;
        Map map2 = new LinkedHashMap();
        Iterator<Object> iterator2 = $receiver$iv$iv.iterator();
        while (iterator2.hasNext()) {
            Object object3;
            Map $receiver$iv$iv$iv = map2;
            Object element$iv$iv = iterator2.next();
            it = (CallableMemberDescriptor)element$iv$iv;
            key$iv$iv = it.getName();
            Object value$iv$iv$iv = $receiver$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                ArrayList answer$iv$iv$iv = new ArrayList();
                $receiver$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                object3 = answer$iv$iv$iv;
            } else {
                object3 = value$iv$iv$iv;
            }
            List list$iv$iv = (List)object3;
            list$iv$iv.add(element$iv$iv);
        }
        $receiver$iv = map2;
        object = $receiver$iv.entrySet().iterator();
        while (object.hasNext()) {
            void $receiver$iv$iv3;
            Object $receiver$iv32;
            Map.Entry entry;
            Map.Entry entry2 = entry = (Map.Entry)object.next();
            Name name2 = (Name)entry2.getKey();
            Map.Entry entry3 = entry;
            List group = (List)entry3.getValue();
            it = $receiver$iv32 = (Iterable)group;
            Object destination$iv$iv3 = new LinkedHashMap();
            key$iv$iv = $receiver$iv$iv3.iterator();
            while (key$iv$iv.hasNext()) {
                Object object4;
                Object $receiver$iv$iv$iv = destination$iv$iv3;
                Object element$iv$iv = key$iv$iv.next();
                CallableMemberDescriptor it3 = (CallableMemberDescriptor)element$iv$iv;
                Boolean key$iv$iv2 = it3 instanceof FunctionDescriptor;
                Object value$iv$iv$iv = $receiver$iv$iv$iv.get(key$iv$iv2);
                if (value$iv$iv$iv == null) {
                    ArrayList answer$iv$iv$iv = new ArrayList();
                    $receiver$iv$iv$iv.put(key$iv$iv2, answer$iv$iv$iv);
                    object4 = answer$iv$iv$iv;
                } else {
                    object4 = value$iv$iv$iv;
                }
                List list$iv$iv = (List)object4;
                list$iv$iv.add(element$iv$iv);
            }
            $receiver$iv32 = destination$iv$iv3;
            for (Map.Entry entry4 : $receiver$iv32.entrySet()) {
                List list;
                Collection collection;
                Name name3;
                List list2;
                Name name4;
                Collection collection2;
                destination$iv$iv3 = entry4;
                boolean isFunction = (Boolean)destination$iv$iv3.getKey();
                destination$iv$iv3 = entry4;
                List descriptors = (List)destination$iv$iv3.getValue();
                if (isFunction) {
                    void $receiver$iv$iv4;
                    void $receiver$iv4;
                    destination$iv$iv3 = functionsFromCurrent;
                    collection2 = descriptors;
                    name4 = name2;
                    key$iv$iv = $receiver$iv4;
                    Collection destination$iv$iv4 = new ArrayList();
                    for (Object element$iv$iv : $receiver$iv$iv4) {
                        FunctionDescriptor it4 = (FunctionDescriptor)element$iv$iv;
                        if (!Intrinsics.areEqual(it4.getName(), name2)) continue;
                        destination$iv$iv4.add(element$iv$iv);
                    }
                    list2 = (List)destination$iv$iv4;
                    name3 = name4;
                    collection = collection2;
                    list = list2;
                } else {
                    list2 = CollectionsKt.emptyList();
                    name3 = name4;
                    collection = collection2;
                    list = list2;
                }
                OverridingUtil.generateOverridesInFunctionGroup(name3, collection, list, this.containingClass, new NonReportingOverrideStrategy(this, result2){
                    final /* synthetic */ GivenFunctionsMemberScope this$0;
                    final /* synthetic */ ArrayList $result;

                    public void addFakeOverride(@NotNull CallableMemberDescriptor fakeOverride) {
                        Intrinsics.checkParameterIsNotNull(fakeOverride, "fakeOverride");
                        OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, null);
                        this.$result.add(fakeOverride);
                    }

                    protected void conflict(@NotNull CallableMemberDescriptor fromSuper, @NotNull CallableMemberDescriptor fromCurrent) {
                        Intrinsics.checkParameterIsNotNull(fromSuper, "fromSuper");
                        Intrinsics.checkParameterIsNotNull(fromCurrent, "fromCurrent");
                        String string = "Conflict in scope of " + this.this$0.getContainingClass() + ": " + fromSuper + " vs " + fromCurrent;
                        throw (Throwable)new IllegalStateException(string.toString());
                    }
                    {
                        this.this$0 = $outer;
                        this.$result = $captured_local_variable$1;
                    }
                });
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compactIfPossible(result2);
    }

    @Override
    public void printScopeStructure(@NotNull Printer p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        p.println("Scope of class: " + this.containingClass);
    }

    @NotNull
    protected final ClassDescriptor getContainingClass() {
        return this.containingClass;
    }

    public GivenFunctionsMemberScope(@NotNull StorageManager storageManager, @NotNull ClassDescriptor containingClass) {
        Intrinsics.checkParameterIsNotNull(storageManager, "storageManager");
        Intrinsics.checkParameterIsNotNull(containingClass, "containingClass");
        this.containingClass = containingClass;
        this.allDescriptors$delegate = storageManager.createLazyValue((Function0)new Function0<List<? extends DeclarationDescriptor>>(this){
            final /* synthetic */ GivenFunctionsMemberScope this$0;

            @NotNull
            public final List<DeclarationDescriptor> invoke() {
                List<FunctionDescriptor> fromCurrent = this.this$0.computeDeclaredFunctions();
                return CollectionsKt.plus((Collection)fromCurrent, (Iterable)GivenFunctionsMemberScope.access$createFakeOverrides(this.this$0, fromCurrent));
            }
            {
                this.this$0 = givenFunctionsMemberScope;
                super(0);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    }

    @NotNull
    public static final /* synthetic */ List access$createFakeOverrides(GivenFunctionsMemberScope $this, @NotNull List functionsFromCurrent) {
        return $this.createFakeOverrides(functionsFromCurrent);
    }
}

