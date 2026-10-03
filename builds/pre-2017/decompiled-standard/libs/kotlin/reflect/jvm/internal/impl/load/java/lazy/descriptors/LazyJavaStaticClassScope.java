/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.SamConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class LazyJavaStaticClassScope
extends LazyJavaStaticScope {
    private final JavaClass jClass;
    @NotNull
    private final LazyJavaClassDescriptor ownerDescriptor;

    @Override
    @NotNull
    protected ClassDeclaredMemberIndex computeMemberIndex() {
        return new ClassDeclaredMemberIndex(this.jClass, computeMemberIndex.1.INSTANCE);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    @NotNull
    protected Set<Name> computeFunctionNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        void $receiver$iv$iv;
        void $receiver$iv;
        Set<Name> set;
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Set<Name> $receiver = set = CollectionsKt.toMutableSet((Iterable)((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).getMethodNames());
        LazyJavaStaticClassScope lazyJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(this.getOwnerDescriptor());
        Iterable<Name> iterable = lazyJavaStaticClassScope != null ? lazyJavaStaticClassScope.getFunctionNames() : null;
        Set<Name> set2 = $receiver;
        Set<Name> set3 = iterable;
        if (set3 == null) {
            set3 = SetsKt.emptySet();
        }
        Collection<Name> collection = set3;
        set2.addAll(collection);
        if (this.jClass.isEnum()) {
            $receiver.addAll((Collection)CollectionsKt.listOf(new Name[]{DescriptorUtils.ENUM_VALUE_OF, DescriptorUtils.ENUM_VALUES}));
        }
        iterable = this.jClass.getInnerClasses();
        set2 = $receiver;
        void var8_8 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        Iterator iterator2 = $receiver$iv$iv.iterator();
        while (iterator2.hasNext()) {
            void receiver;
            Object item$iv$iv;
            Object t = item$iv$iv = iterator2.next();
            collection = destination$iv$iv;
            Name name2 = ((JavaClass)receiver).getName();
            collection.add(name2);
        }
        collection = (List)destination$iv$iv;
        set2.addAll(collection);
        return set;
    }

    @Override
    @NotNull
    protected Set<Name> computePropertyNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Set<Name> set;
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Set<Name> $receiver = set = CollectionsKt.toMutableSet((Iterable)((DeclaredMemberIndex)this.getDeclaredMemberIndex().invoke()).getFieldNames());
        this.flatMapJavaStaticSupertypesScopes(this.getOwnerDescriptor(), $receiver, computePropertyNames.1.1.INSTANCE);
        return set;
    }

    @Override
    @NotNull
    protected Set<Name> computeClassNames(@NotNull DescriptorKindFilter kindFilter, @Nullable Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        return SetsKt.emptySet();
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return null;
    }

    @Override
    protected void computeNonDeclaredFunctions(@NotNull Collection<SimpleFunctionDescriptor> result2, @NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(result2, "result");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        SamConstructorDescriptor samConstructorDescriptor = this.getC().getComponents().getSamConversionResolver().resolveSamConstructor(this.getOwnerDescriptor(), (Function0<? extends ClassifierDescriptor>)new Function0<ClassifierDescriptor>(this, name2){
            final /* synthetic */ LazyJavaStaticClassScope this$0;
            final /* synthetic */ Name $name;

            @Nullable
            public final ClassifierDescriptor invoke() {
                return this.this$0.getOwnerDescriptor().getUnsubstitutedInnerClassesScope().getContributedClassifier(this.$name, NoLookupLocation.FOR_ALREADY_TRACKED);
            }
            {
                this.this$0 = lazyJavaStaticClassScope;
                this.$name = name2;
                super(0);
            }
        });
        if (samConstructorDescriptor != null) {
            SamConstructorDescriptor samConstructorDescriptor2;
            SamConstructorDescriptor it = samConstructorDescriptor2 = samConstructorDescriptor;
            result2.add(it);
        }
        Set<SimpleFunctionDescriptor> functionsFromSupertypes = this.getStaticFunctionsFromJavaSuperClasses(name2, this.getOwnerDescriptor());
        Collection<SimpleFunctionDescriptor> collection = DescriptorResolverUtils.resolveOverridesForStaticMembers(name2, (Collection)functionsFromSupertypes, result2, this.getOwnerDescriptor(), this.getC().getComponents().getErrorReporter());
        Intrinsics.checkExpressionValueIsNotNull(collection, "resolveOverridesForStati\u2026components.errorReporter)");
        result2.addAll(collection);
        if (this.jClass.isEnum()) {
            Name name3 = name2;
            if (Intrinsics.areEqual(name3, DescriptorUtils.ENUM_VALUE_OF)) {
                SimpleFunctionDescriptor simpleFunctionDescriptor = DescriptorFactory.createEnumValueOfMethod(this.getOwnerDescriptor());
                Intrinsics.checkExpressionValueIsNotNull(simpleFunctionDescriptor, "createEnumValueOfMethod(ownerDescriptor)");
                result2.add(simpleFunctionDescriptor);
            } else if (Intrinsics.areEqual(name3, DescriptorUtils.ENUM_VALUES)) {
                SimpleFunctionDescriptor simpleFunctionDescriptor = DescriptorFactory.createEnumValuesMethod(this.getOwnerDescriptor());
                Intrinsics.checkExpressionValueIsNotNull(simpleFunctionDescriptor, "createEnumValuesMethod(ownerDescriptor)");
                result2.add(simpleFunctionDescriptor);
            }
        }
    }

    @Override
    protected void computeNonDeclaredProperties(@NotNull Name name2, @NotNull Collection<PropertyDescriptor> result2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(result2, "result");
        Object object = this.getOwnerDescriptor();
        Object object2 = this;
        Set set = new LinkedHashSet();
        Set propertiesFromSupertypes2 = ((LazyJavaStaticClassScope)object2).flatMapJavaStaticSupertypesScopes((ClassDescriptor)object, set, (Function1)new Function1<MemberScope, Collection<? extends PropertyDescriptor>>(name2){
            final /* synthetic */ Name $name;

            @NotNull
            public final Collection<PropertyDescriptor> invoke(@NotNull MemberScope it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return it.getContributedVariables(this.$name, NoLookupLocation.WHEN_GET_SUPER_MEMBERS);
            }
            {
                this.$name = name2;
                super(1);
            }
        });
        Iterable<PropertyDescriptor> iterable = result2;
        if (!iterable.isEmpty()) {
            Collection<PropertyDescriptor> collection = DescriptorResolverUtils.resolveOverridesForStaticMembers(name2, propertiesFromSupertypes2, result2, this.getOwnerDescriptor(), this.getC().getComponents().getErrorReporter());
            Intrinsics.checkExpressionValueIsNotNull(collection, "resolveOverridesForStati\u2026rorReporter\n            )");
            result2.addAll(collection);
        } else {
            Object $receiver$iv$iv;
            Object $receiver$iv;
            iterable = propertiesFromSupertypes2;
            object2 = result2;
            void var8_8 = $receiver$iv;
            Object destination$iv$iv = new LinkedHashMap();
            Object object3 = $receiver$iv$iv.iterator();
            while (object3.hasNext()) {
                Object object4;
                Object $receiver$iv$iv$iv = destination$iv$iv;
                Object element$iv$iv = object3.next();
                PropertyDescriptor it = (PropertyDescriptor)element$iv$iv;
                PropertyDescriptor key$iv$iv = this.getRealOriginal(it);
                Object value$iv$iv$iv = $receiver$iv$iv$iv.get(key$iv$iv);
                if (value$iv$iv$iv == null) {
                    ArrayList answer$iv$iv$iv = new ArrayList();
                    $receiver$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                    object4 = answer$iv$iv$iv;
                } else {
                    object4 = value$iv$iv$iv;
                }
                List list$iv$iv = (List)object4;
                list$iv$iv.add(element$iv$iv);
            }
            $receiver$iv$iv = $receiver$iv = (object = destination$iv$iv);
            destination$iv$iv = new ArrayList();
            object3 = $receiver$iv$iv;
            Iterator iterator2 = object3.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry element$iv$iv;
                Map.Entry it = element$iv$iv = iterator2.next();
                Iterable list$iv$iv = DescriptorResolverUtils.resolveOverridesForStaticMembers(name2, (Collection)it.getValue(), result2, this.getOwnerDescriptor(), this.getC().getComponents().getErrorReporter());
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            object = (List)destination$iv$iv;
            object2.addAll((Collection)object);
        }
    }

    private final Set<SimpleFunctionDescriptor> getStaticFunctionsFromJavaSuperClasses(Name name2, ClassDescriptor descriptor2) {
        LazyJavaStaticClassScope lazyJavaStaticClassScope = UtilKt.getParentJavaStaticClassScope(descriptor2);
        if (lazyJavaStaticClassScope == null) {
            return SetsKt.emptySet();
        }
        LazyJavaStaticClassScope staticScope = lazyJavaStaticClassScope;
        return CollectionsKt.toSet((Iterable)staticScope.getContributedFunctions(name2, NoLookupLocation.WHEN_GET_SUPER_MEMBERS));
    }

    private final <R> Set<R> flatMapJavaStaticSupertypesScopes(ClassDescriptor root, Set<R> result2, Function1<? super MemberScope, ? extends Collection<? extends R>> onJavaStaticScope) {
        DFS.dfs((Collection)CollectionsKt.listOf(root), flatMapJavaStaticSupertypesScopes.1.INSTANCE, new DFS.AbstractNodeHandler<ClassDescriptor, Unit>(root, result2, onJavaStaticScope){
            final /* synthetic */ ClassDescriptor $root;
            final /* synthetic */ Set $result;
            final /* synthetic */ Function1 $onJavaStaticScope;

            public boolean beforeChildren(@NotNull ClassDescriptor current) {
                Intrinsics.checkParameterIsNotNull(current, "current");
                if (current == this.$root) {
                    return true;
                }
                MemberScope staticScope = current.getStaticScope();
                if (staticScope instanceof LazyJavaStaticScope) {
                    MemberScope memberScope2 = staticScope;
                    Intrinsics.checkExpressionValueIsNotNull(memberScope2, "staticScope");
                    this.$result.addAll((Collection)this.$onJavaStaticScope.invoke(memberScope2));
                    return false;
                }
                return true;
            }

            public void result() {
            }
            {
                this.$root = $captured_local_variable$0;
                this.$result = $captured_local_variable$1;
                this.$onJavaStaticScope = $captured_local_variable$2;
            }
        });
        return result2;
    }

    /*
     * WARNING - void declaration
     */
    private final PropertyDescriptor getRealOriginal(@NotNull PropertyDescriptor $receiver) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        if ($receiver.getKind().isReal()) {
            return $receiver;
        }
        Iterable iterable = $receiver$iv = (Iterable)$receiver.getOverriddenDescriptors();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($receiver$iv, 10));
        for (Object item$iv$iv : $receiver$iv$iv) {
            void it;
            PropertyDescriptor propertyDescriptor = (PropertyDescriptor)item$iv$iv;
            Collection collection = destination$iv$iv;
            PropertyDescriptor propertyDescriptor2 = this.getRealOriginal((PropertyDescriptor)it);
            collection.add(propertyDescriptor2);
        }
        return (PropertyDescriptor)CollectionsKt.single(CollectionsKt.distinct((List)destination$iv$iv));
    }

    @Override
    @NotNull
    protected LazyJavaClassDescriptor getOwnerDescriptor() {
        return this.ownerDescriptor;
    }

    public LazyJavaStaticClassScope(@NotNull LazyJavaResolverContext c, @NotNull JavaClass jClass, @NotNull LazyJavaClassDescriptor ownerDescriptor) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(jClass, "jClass");
        Intrinsics.checkParameterIsNotNull(ownerDescriptor, "ownerDescriptor");
        super(c);
        this.jClass = jClass;
        this.ownerDescriptor = ownerDescriptor;
    }
}

