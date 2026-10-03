/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JvmPackageScope
implements MemberScope {
    @NotNull
    private final LazyJavaPackageScope javaScope;
    private final NotNullLazyValue kotlinScopes$delegate;
    private final LazyJavaResolverContext c;
    private final LazyJavaPackageFragment packageFragment;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    @NotNull
    public final LazyJavaPackageScope getJavaScope$kotlin_core() {
        return this.javaScope;
    }

    private final List<MemberScope> getKotlinScopes() {
        return (List)StorageKt.getValue(this.kotlinScopes$delegate, (Object)this, $$delegatedProperties[0]);
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
        ClassifierDescriptor classifierDescriptor;
        block3: {
            Intrinsics.checkParameterIsNotNull(name2, "name");
            Intrinsics.checkParameterIsNotNull(location, "location");
            this.recordLookup(location, name2);
            ClassDescriptor javaClassifier = this.javaScope.getContributedClassifier(name2, location);
            if (javaClassifier != null) {
                return javaClassifier;
            }
            List<MemberScope> scopes$iv = this.getKotlinScopes();
            ClassifierDescriptor result$iv = null;
            for (MemberScope scope$iv : scopes$iv) {
                MemberScope it = scope$iv;
                ClassifierDescriptor newResult$iv = it.getContributedClassifier(name2, location);
                if (newResult$iv == null) continue;
                if (newResult$iv instanceof ClassifierDescriptorWithTypeParameters && ((ClassifierDescriptorWithTypeParameters)newResult$iv).isHeader()) {
                    if (result$iv != null) continue;
                    result$iv = newResult$iv;
                    continue;
                }
                classifierDescriptor = newResult$iv;
                break block3;
            }
            classifierDescriptor = result$iv;
        }
        return classifierDescriptor;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
        void firstScope$iv;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        this.recordLookup(location, name2);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        List<MemberScope> restScopes$iv = this.getKotlinScopes();
        MemberScope it = (MemberScope)firstScope$iv;
        Collection<PropertyDescriptor> result$iv = it.getContributedVariables(name2, location);
        Iterator<MemberScope> iterator2 = restScopes$iv.iterator();
        while (iterator2.hasNext()) {
            void it2;
            MemberScope scope$iv;
            MemberScope $i$a$1$getFromAllScopes = scope$iv = iterator2.next();
            Collection<PropertyDescriptor> collection = result$iv;
            Collection<PropertyDescriptor> collection2 = it2.getContributedVariables(name2, location);
            result$iv = ScopeUtilsKt.concat(collection, collection2);
        }
        Collection<PropertyDescriptor> collection = result$iv;
        if (collection == null) {
            collection = SetsKt.emptySet();
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
        void firstScope$iv;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        this.recordLookup(location, name2);
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        List<MemberScope> restScopes$iv = this.getKotlinScopes();
        MemberScope it = (MemberScope)firstScope$iv;
        Collection<SimpleFunctionDescriptor> result$iv = it.getContributedFunctions(name2, location);
        Iterator<MemberScope> iterator2 = restScopes$iv.iterator();
        while (iterator2.hasNext()) {
            void it2;
            MemberScope scope$iv;
            MemberScope $i$a$1$getFromAllScopes = scope$iv = iterator2.next();
            Collection<SimpleFunctionDescriptor> collection = result$iv;
            Collection<SimpleFunctionDescriptor> collection2 = it2.getContributedFunctions(name2, location);
            result$iv = ScopeUtilsKt.concat(collection, collection2);
        }
        Collection<SimpleFunctionDescriptor> collection = result$iv;
        if (collection == null) {
            collection = SetsKt.emptySet();
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        void firstScope$iv;
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        LazyJavaPackageScope lazyJavaPackageScope = this.javaScope;
        List<MemberScope> restScopes$iv = this.getKotlinScopes();
        MemberScope it = (MemberScope)firstScope$iv;
        Collection<DeclarationDescriptor> result$iv = it.getContributedDescriptors(kindFilter, nameFilter);
        Iterator<MemberScope> iterator2 = restScopes$iv.iterator();
        while (iterator2.hasNext()) {
            void it2;
            MemberScope scope$iv;
            MemberScope $i$a$1$getFromAllScopes = scope$iv = iterator2.next();
            Collection<DeclarationDescriptor> collection = result$iv;
            Collection<DeclarationDescriptor> collection2 = it2.getContributedDescriptors(kindFilter, nameFilter);
            result$iv = ScopeUtilsKt.concat(collection, collection2);
        }
        Collection<DeclarationDescriptor> collection = result$iv;
        if (collection == null) {
            collection = SetsKt.emptySet();
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        void $receiver$iv;
        Iterable iterable = this.getKotlinScopes();
        Collection destination$iv = new LinkedHashSet();
        for (Object element$iv : $receiver$iv) {
            MemberScope it = (MemberScope)element$iv;
            Iterable list$iv = it.getFunctionNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        iterable = destination$iv;
        Set $receiver = (Set)iterable;
        $receiver.addAll((Collection)this.javaScope.getFunctionNames());
        return (Set)iterable;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        void $receiver$iv;
        Iterable iterable = this.getKotlinScopes();
        Collection destination$iv = new LinkedHashSet();
        for (Object element$iv : $receiver$iv) {
            MemberScope it = (MemberScope)element$iv;
            Iterable list$iv = it.getVariableNames();
            CollectionsKt.addAll(destination$iv, list$iv);
        }
        iterable = destination$iv;
        Set $receiver = (Set)iterable;
        $receiver.addAll((Collection)this.javaScope.getVariableNames());
        return (Set)iterable;
    }

    @Override
    public void printScopeStructure(@NotNull Printer p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        p.println(this.getClass().getSimpleName(), " {");
        p.pushIndent();
        p.println("containingDeclaration: " + this.packageFragment);
        this.javaScope.printScopeStructure(p);
        for (MemberScope kotlinScope : this.getKotlinScopes()) {
            kotlinScope.printScopeStructure(p);
        }
        p.popIndent();
        p.println("}");
    }

    private final void recordLookup(LookupLocation location, Name name2) {
        UtilsKt.record(this.c.getComponents().getLookupTracker(), location, this.packageFragment, name2);
    }

    public JvmPackageScope(@NotNull LazyJavaResolverContext c, @NotNull JavaPackage jPackage, @NotNull LazyJavaPackageFragment packageFragment) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(jPackage, "jPackage");
        Intrinsics.checkParameterIsNotNull(packageFragment, "packageFragment");
        this.c = c;
        this.packageFragment = packageFragment;
        this.javaScope = new LazyJavaPackageScope(this.c, jPackage, this.packageFragment);
        this.kotlinScopes$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<List<? extends MemberScope>>(this){
            final /* synthetic */ JvmPackageScope this$0;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final List<MemberScope> invoke() {
                void var3_3;
                void $receiver$iv$iv;
                Iterable $receiver$iv;
                Iterable iterable = $receiver$iv = (Iterable)JvmPackageScope.access$getPackageFragment$p(this.this$0).getBinaryClasses$kotlin_core().values();
                Collection destination$iv$iv = new ArrayList<E>();
                void $receiver$iv$iv$iv = $receiver$iv$iv;
                Iterator<T> iterator2 = $receiver$iv$iv$iv.iterator();
                while (iterator2.hasNext()) {
                    MemberScope memberScope2;
                    T element$iv$iv$iv;
                    T element$iv$iv = element$iv$iv$iv = iterator2.next();
                    KotlinJvmBinaryClass partClass = (KotlinJvmBinaryClass)element$iv$iv;
                    if (JvmPackageScope.access$getC$p(this.this$0).getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope(JvmPackageScope.access$getPackageFragment$p(this.this$0), partClass) == null) continue;
                    MemberScope it$iv$iv = memberScope2;
                    destination$iv$iv.add(it$iv$iv);
                }
                return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.toReadOnlyList((List)var3_3);
            }
            {
                this.this$0 = jvmPackageScope;
                super(0);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;"))};
    }

    @NotNull
    public static final /* synthetic */ LazyJavaPackageFragment access$getPackageFragment$p(JvmPackageScope $this) {
        return $this.packageFragment;
    }

    @NotNull
    public static final /* synthetic */ LazyJavaResolverContext access$getC$p(JvmPackageScope $this) {
        return $this.c;
    }
}

