/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DeserializedMemberScope
extends MemberScopeImpl {
    private final NotNullLazyValue functionProtos$delegate;
    private final NotNullLazyValue propertyProtos$delegate;
    private final NotNullLazyValue typeAliasProtos$delegate;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
    private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
    private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> typeAliasByName;
    private final NotNullLazyValue functionNamesLazy$delegate;
    private final NotNullLazyValue variableNamesLazy$delegate;
    @NotNull
    private final NotNullLazyValue classNames$delegate;
    @NotNull
    private final DeserializationContext c;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    private final Map<Name, List<ProtoBuf.Function>> getFunctionProtos() {
        return (Map)StorageKt.getValue(this.functionProtos$delegate, (Object)this, $$delegatedProperties[0]);
    }

    private final Map<Name, List<ProtoBuf.Property>> getPropertyProtos() {
        return (Map)StorageKt.getValue(this.propertyProtos$delegate, (Object)this, $$delegatedProperties[1]);
    }

    private final Map<Name, List<ProtoBuf.TypeAlias>> getTypeAliasProtos() {
        return (Map)StorageKt.getValue(this.typeAliasProtos$delegate, (Object)this, $$delegatedProperties[2]);
    }

    private final Set<Name> getFunctionNamesLazy() {
        return (Set)StorageKt.getValue(this.functionNamesLazy$delegate, (Object)this, $$delegatedProperties[3]);
    }

    private final Set<Name> getVariableNamesLazy() {
        return (Set)StorageKt.getValue(this.variableNamesLazy$delegate, (Object)this, $$delegatedProperties[4]);
    }

    private final Set<Name> getTypeAliasNames() {
        return this.getTypeAliasProtos().keySet();
    }

    @NotNull
    public final Set<Name> getClassNames$kotlin_core() {
        return (Set)StorageKt.getValue(this.classNames$delegate, (Object)this, $$delegatedProperties[5]);
    }

    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        return this.getFunctionNamesLazy();
    }

    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        return this.getVariableNamesLazy();
    }

    /*
     * WARNING - void declaration
     */
    private final <M extends MessageLite> Map<Name, List<M>> groupByName(@NotNull Collection<? extends M> $receiver, Function1<? super M, Integer> getNameIndex) {
        void $receiver$iv$iv;
        Iterable $receiver$iv;
        Iterable iterable = $receiver$iv = (Iterable)$receiver;
        Map destination$iv$iv = new LinkedHashMap();
        for (Object element$iv$iv : $receiver$iv$iv) {
            Object object;
            MessageLite it = (MessageLite)element$iv$iv;
            Map $receiver$iv$iv$iv = destination$iv$iv;
            Name key$iv$iv = this.c.getNameResolver().getName(((Number)getNameIndex.invoke(it)).intValue());
            Object value$iv$iv$iv = $receiver$iv$iv$iv.get(key$iv$iv);
            if (value$iv$iv$iv == null) {
                ArrayList answer$iv$iv$iv = new ArrayList();
                $receiver$iv$iv$iv.put(key$iv$iv, answer$iv$iv$iv);
                object = answer$iv$iv$iv;
            } else {
                object = value$iv$iv$iv;
            }
            List list$iv$iv = (List)object;
            list$iv$iv.add(element$iv$iv);
        }
        return destination$iv$iv;
    }

    /*
     * WARNING - void declaration
     */
    private final Collection<SimpleFunctionDescriptor> computeFunctions(Name name2) {
        Collection it;
        void $receiver$iv$iv;
        DeserializedMemberScope deserializedMemberScope = this;
        Map<Name, List<ProtoBuf.Function>> protosByName$iv = this.getFunctionProtos();
        Collection collection = protosByName$iv.get(name2);
        Collection collection2 = collection;
        if (collection2 == null) {
            collection2 = CollectionsKt.emptyList();
        }
        Collection protos$iv = collection2;
        Iterable iterable = protos$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object item$iv$iv : $receiver$iv$iv) {
            ProtoBuf.Function function = (ProtoBuf.Function)item$iv$iv;
            Collection collection3 = destination$iv$iv;
            SimpleFunctionDescriptor simpleFunctionDescriptor = this.c.getMemberDeserializer().loadFunction((ProtoBuf.Function)((Object)it));
            collection3.add(simpleFunctionDescriptor);
        }
        ArrayList descriptors$iv = (ArrayList)destination$iv$iv;
        it = descriptors$iv;
        this.computeNonDeclaredFunctions(name2, it);
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compactIfPossible(descriptors$iv);
    }

    /*
     * WARNING - void declaration
     */
    private final <M extends MessageLite, D extends DeclarationDescriptor> Collection<D> computeDescriptors(Name name2, Map<Name, ? extends Collection<? extends M>> protosByName, Function1<? super M, ? extends D> factory, Function1<? super Collection<D>, Unit> computeNonDeclared) {
        void $receiver$iv;
        Collection collection = protosByName.get(name2);
        Collection collection2 = collection;
        if (collection2 == null) {
            collection2 = CollectionsKt.emptyList();
        }
        Collection protos = collection2;
        Iterable iterable = protos;
        Collection destination$iv = new ArrayList();
        for (Object item$iv : $receiver$iv) {
            destination$iv.add(factory.invoke(item$iv));
        }
        ArrayList descriptors = (ArrayList)destination$iv;
        computeNonDeclared.invoke(descriptors);
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compactIfPossible(descriptors);
    }

    protected void computeNonDeclaredFunctions(@NotNull Name name2, @NotNull Collection<SimpleFunctionDescriptor> functions2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(functions2, "functions");
    }

    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        if (this.getFunctionNames().contains(name2) ^ true) {
            return CollectionsKt.emptyList();
        }
        return (Collection)this.functions.invoke(name2);
    }

    /*
     * WARNING - void declaration
     */
    private final Collection<PropertyDescriptor> computeProperties(Name name2) {
        Collection it;
        void $receiver$iv$iv;
        DeserializedMemberScope deserializedMemberScope = this;
        Map<Name, List<ProtoBuf.Property>> protosByName$iv = this.getPropertyProtos();
        Collection collection = protosByName$iv.get(name2);
        Collection collection2 = collection;
        if (collection2 == null) {
            collection2 = CollectionsKt.emptyList();
        }
        Collection protos$iv = collection2;
        Iterable iterable = protos$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object item$iv$iv : $receiver$iv$iv) {
            ProtoBuf.Property property = (ProtoBuf.Property)item$iv$iv;
            Collection collection3 = destination$iv$iv;
            PropertyDescriptor propertyDescriptor = this.c.getMemberDeserializer().loadProperty((ProtoBuf.Property)((Object)it));
            collection3.add(propertyDescriptor);
        }
        ArrayList descriptors$iv = (ArrayList)destination$iv$iv;
        it = descriptors$iv;
        this.computeNonDeclaredProperties(name2, it);
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compactIfPossible(descriptors$iv);
    }

    protected void computeNonDeclaredProperties(@NotNull Name name2, @NotNull Collection<PropertyDescriptor> descriptors) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(descriptors, "descriptors");
    }

    private final TypeAliasDescriptor createTypeAlias(Name name2) {
        TypeAliasDescriptor typeAliasDescriptor;
        List<ProtoBuf.TypeAlias> list = this.getTypeAliasProtos().get(name2);
        if (list != null && (list = CollectionsKt.singleOrNull(list)) != null) {
            List<ProtoBuf.TypeAlias> list2 = list;
            ProtoBuf.TypeAlias it = (ProtoBuf.TypeAlias)((Object)list2);
            typeAliasDescriptor = this.c.getMemberDeserializer().loadTypeAlias(it);
        } else {
            typeAliasDescriptor = null;
        }
        return typeAliasDescriptor;
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        if (this.getVariableNames().contains(name2) ^ true) {
            return CollectionsKt.emptyList();
        }
        return (Collection)this.properties.invoke(name2);
    }

    @NotNull
    protected final Collection<DeclarationDescriptor> computeDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        Intrinsics.checkParameterIsNotNull(location, "location");
        ArrayList result2 = new ArrayList(0);
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getSINGLETON_CLASSIFIERS_MASK())) {
            this.addEnumEntryDescriptors(result2, nameFilter);
        }
        this.addFunctionsAndProperties(result2, kindFilter, nameFilter, location);
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK())) {
            for (Name className : this.getClassNames$kotlin_core()) {
                if (!nameFilter.invoke(className).booleanValue()) continue;
                kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result2, this.deserializeClass(className));
            }
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getTYPE_ALIASES_MASK())) {
            for (Name typeAliasName : this.getTypeAliasNames()) {
                if (!nameFilter.invoke(typeAliasName).booleanValue()) continue;
                kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(result2, this.typeAliasByName.invoke(typeAliasName));
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.compactIfPossible(result2);
    }

    private final void addFunctionsAndProperties(Collection<DeclarationDescriptor> result2, DescriptorKindFilter kindFilter, Function1<? super Name, Boolean> nameFilter, LookupLocation location) {
        Collection<CallableMemberDescriptor> collection;
        Name it;
        ArrayList<PropertyDescriptor> arrayList;
        ArrayList<PropertyDescriptor> subResult$iv;
        Collection names$iv;
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getVARIABLES_MASK())) {
            DeserializedMemberScope deserializedMemberScope = this;
            names$iv = this.getVariableNames();
            subResult$iv = new ArrayList<PropertyDescriptor>();
            for (Name name$iv : names$iv) {
                if (!nameFilter.invoke(name$iv).booleanValue()) continue;
                Name name2 = name$iv;
                arrayList = subResult$iv;
                collection = this.getContributedVariables(it, location);
                arrayList.addAll(collection);
            }
            List list = subResult$iv;
            MemberComparator memberComparator = MemberComparator.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(memberComparator, "MemberComparator.INSTANCE");
            CollectionsKt.sortWith(list, memberComparator);
            result2.addAll((Collection<DeclarationDescriptor>)subResult$iv);
        }
        if (kindFilter.acceptsKinds(DescriptorKindFilter.Companion.getFUNCTIONS_MASK())) {
            DeserializedMemberScope this_$iv = this;
            names$iv = this.getFunctionNames();
            subResult$iv = new ArrayList();
            for (Name name$iv : names$iv) {
                if (!nameFilter.invoke(name$iv).booleanValue()) continue;
                it = name$iv;
                arrayList = subResult$iv;
                collection = this.getContributedFunctions(it, location);
                arrayList.addAll(collection);
            }
            List list = subResult$iv;
            MemberComparator memberComparator = MemberComparator.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(memberComparator, "MemberComparator.INSTANCE");
            CollectionsKt.sortWith(list, memberComparator);
            result2.addAll((Collection<DeclarationDescriptor>)subResult$iv);
        }
    }

    private final void addMembers(Collection<Name> names, Function1<? super Name, Boolean> nameFilter, Collection<DeclarationDescriptor> result2, Function1<? super Name, ? extends Collection<? extends DeclarationDescriptor>> descriptorsByName) {
        ArrayList<? extends DeclarationDescriptor> subResult = new ArrayList<DeclarationDescriptor>();
        for (Name name2 : names) {
            if (!nameFilter.invoke(name2).booleanValue()) continue;
            subResult.addAll(descriptorsByName.invoke(name2));
        }
        List list = subResult;
        MemberComparator memberComparator = MemberComparator.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(memberComparator, "MemberComparator.INSTANCE");
        CollectionsKt.sortWith(list, memberComparator);
        result2.addAll((Collection<DeclarationDescriptor>)subResult);
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return this.hasClass(name2) ? (ClassifierDescriptor)this.deserializeClass(name2) : (this.getTypeAliasNames().contains(name2) ? (ClassifierDescriptor)this.typeAliasByName.invoke(name2) : null);
    }

    private final ClassDescriptor deserializeClass(Name name2) {
        return this.c.getComponents().deserializeClass(this.createClassId(name2));
    }

    protected boolean hasClass(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return this.getClassNames$kotlin_core().contains(name2);
    }

    @NotNull
    protected abstract ClassId createClassId(@NotNull Name var1);

    @NotNull
    protected abstract Set<Name> getNonDeclaredFunctionNames();

    @NotNull
    protected abstract Set<Name> getNonDeclaredVariableNames();

    protected abstract void addEnumEntryDescriptors(@NotNull Collection<DeclarationDescriptor> var1, @NotNull Function1<? super Name, Boolean> var2);

    @Override
    public void printScopeStructure(@NotNull Printer p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        p.println(this.getClass().getSimpleName(), " {");
        p.pushIndent();
        p.println("containingDeclaration = " + this.c.getContainingDeclaration());
        p.popIndent();
        p.println("}");
    }

    @NotNull
    protected final DeserializationContext getC() {
        return this.c;
    }

    protected DeserializedMemberScope(@NotNull DeserializationContext c, @NotNull Collection<ProtoBuf.Function> functionList, @NotNull Collection<ProtoBuf.Property> propertyList, @NotNull Collection<ProtoBuf.TypeAlias> typeAliasList, @NotNull Function0<? extends Collection<Name>> classNames2) {
        Intrinsics.checkParameterIsNotNull(c, "c");
        Intrinsics.checkParameterIsNotNull(functionList, "functionList");
        Intrinsics.checkParameterIsNotNull(propertyList, "propertyList");
        Intrinsics.checkParameterIsNotNull(typeAliasList, "typeAliasList");
        Intrinsics.checkParameterIsNotNull(classNames2, "classNames");
        this.c = c;
        this.functionProtos$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<Map<Name, ? extends List<? extends ProtoBuf.Function>>>(this, functionList){
            final /* synthetic */ DeserializedMemberScope this$0;
            final /* synthetic */ Collection $functionList;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final Map<Name, List<ProtoBuf.Function>> invoke() {
                void $receiver$iv$iv$iv;
                Iterable $receiver$iv$iv;
                Collection $receiver$iv = this.$functionList;
                DeserializedMemberScope this_$iv = this.this$0;
                Iterable iterable = $receiver$iv$iv = (Iterable)$receiver$iv;
                Map destination$iv$iv$iv = new LinkedHashMap<K, V>();
                for (T element$iv$iv$iv : $receiver$iv$iv$iv) {
                    Object object;
                    void it;
                    int n;
                    MessageLite it$iv = (MessageLite)element$iv$iv$iv;
                    ProtoBuf.Function function = (ProtoBuf.Function)it$iv;
                    Map $receiver$iv$iv$iv$iv = destination$iv$iv$iv;
                    NameResolver nameResolver = DeserializedMemberScope.access$getC$p(this_$iv).getNameResolver();
                    Name key$iv$iv$iv = nameResolver.getName(n = it.getName());
                    V value$iv$iv$iv$iv = $receiver$iv$iv$iv$iv.get(key$iv$iv$iv);
                    if (value$iv$iv$iv$iv == null) {
                        ArrayList<E> answer$iv$iv$iv$iv = new ArrayList<E>();
                        $receiver$iv$iv$iv$iv.put(key$iv$iv$iv, answer$iv$iv$iv$iv);
                        object = answer$iv$iv$iv$iv;
                    } else {
                        object = value$iv$iv$iv$iv;
                    }
                    List list$iv$iv$iv = (List)object;
                    list$iv$iv$iv.add(element$iv$iv$iv);
                }
                return destination$iv$iv$iv;
            }
            {
                this.this$0 = deserializedMemberScope;
                this.$functionList = collection;
                super(0);
            }
        });
        this.propertyProtos$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<Map<Name, ? extends List<? extends ProtoBuf.Property>>>(this, propertyList){
            final /* synthetic */ DeserializedMemberScope this$0;
            final /* synthetic */ Collection $propertyList;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final Map<Name, List<ProtoBuf.Property>> invoke() {
                void $receiver$iv$iv$iv;
                Iterable $receiver$iv$iv;
                Collection $receiver$iv = this.$propertyList;
                DeserializedMemberScope this_$iv = this.this$0;
                Iterable iterable = $receiver$iv$iv = (Iterable)$receiver$iv;
                Map destination$iv$iv$iv = new LinkedHashMap<K, V>();
                for (T element$iv$iv$iv : $receiver$iv$iv$iv) {
                    Object object;
                    void it;
                    int n;
                    MessageLite it$iv = (MessageLite)element$iv$iv$iv;
                    ProtoBuf.Property property = (ProtoBuf.Property)it$iv;
                    Map $receiver$iv$iv$iv$iv = destination$iv$iv$iv;
                    NameResolver nameResolver = DeserializedMemberScope.access$getC$p(this_$iv).getNameResolver();
                    Name key$iv$iv$iv = nameResolver.getName(n = it.getName());
                    V value$iv$iv$iv$iv = $receiver$iv$iv$iv$iv.get(key$iv$iv$iv);
                    if (value$iv$iv$iv$iv == null) {
                        ArrayList<E> answer$iv$iv$iv$iv = new ArrayList<E>();
                        $receiver$iv$iv$iv$iv.put(key$iv$iv$iv, answer$iv$iv$iv$iv);
                        object = answer$iv$iv$iv$iv;
                    } else {
                        object = value$iv$iv$iv$iv;
                    }
                    List list$iv$iv$iv = (List)object;
                    list$iv$iv$iv.add(element$iv$iv$iv);
                }
                return destination$iv$iv$iv;
            }
            {
                this.this$0 = deserializedMemberScope;
                this.$propertyList = collection;
                super(0);
            }
        });
        this.typeAliasProtos$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<Map<Name, ? extends List<? extends ProtoBuf.TypeAlias>>>(this, typeAliasList){
            final /* synthetic */ DeserializedMemberScope this$0;
            final /* synthetic */ Collection $typeAliasList;

            /*
             * WARNING - void declaration
             */
            @NotNull
            public final Map<Name, List<ProtoBuf.TypeAlias>> invoke() {
                Map map2;
                if (this.this$0.getC().getComponents().getConfiguration().getTypeAliasesAllowed()) {
                    void $receiver$iv$iv$iv;
                    Iterable $receiver$iv$iv;
                    Collection $receiver$iv = this.$typeAliasList;
                    DeserializedMemberScope this_$iv = this.this$0;
                    Iterable iterable = $receiver$iv$iv = (Iterable)$receiver$iv;
                    Map destination$iv$iv$iv = new LinkedHashMap<K, V>();
                    for (T element$iv$iv$iv : $receiver$iv$iv$iv) {
                        Object object;
                        void it;
                        int n;
                        MessageLite it$iv = (MessageLite)element$iv$iv$iv;
                        ProtoBuf.TypeAlias typeAlias = (ProtoBuf.TypeAlias)it$iv;
                        Map $receiver$iv$iv$iv$iv = destination$iv$iv$iv;
                        NameResolver nameResolver = DeserializedMemberScope.access$getC$p(this_$iv).getNameResolver();
                        Name key$iv$iv$iv = nameResolver.getName(n = it.getName());
                        V value$iv$iv$iv$iv = $receiver$iv$iv$iv$iv.get(key$iv$iv$iv);
                        if (value$iv$iv$iv$iv == null) {
                            ArrayList<E> answer$iv$iv$iv$iv = new ArrayList<E>();
                            $receiver$iv$iv$iv$iv.put(key$iv$iv$iv, answer$iv$iv$iv$iv);
                            object = answer$iv$iv$iv$iv;
                        } else {
                            object = value$iv$iv$iv$iv;
                        }
                        List list$iv$iv$iv = (List)object;
                        list$iv$iv$iv.add(element$iv$iv$iv);
                    }
                    map2 = destination$iv$iv$iv;
                } else {
                    map2 = MapsKt.emptyMap();
                }
                return map2;
            }
            {
                this.this$0 = deserializedMemberScope;
                this.$typeAliasList = collection;
                super(0);
            }
        });
        this.functions = this.c.getStorageManager().createMemoizedFunction((Function1)new Function1<Name, Collection<? extends SimpleFunctionDescriptor>>(this){
            final /* synthetic */ DeserializedMemberScope this$0;

            @NotNull
            public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return DeserializedMemberScope.access$computeFunctions(this.this$0, it);
            }
            {
                this.this$0 = deserializedMemberScope;
                super(1);
            }
        });
        this.properties = this.c.getStorageManager().createMemoizedFunction((Function1)new Function1<Name, Collection<? extends PropertyDescriptor>>(this){
            final /* synthetic */ DeserializedMemberScope this$0;

            @NotNull
            public final Collection<PropertyDescriptor> invoke(@NotNull Name it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return DeserializedMemberScope.access$computeProperties(this.this$0, it);
            }
            {
                this.this$0 = deserializedMemberScope;
                super(1);
            }
        });
        this.typeAliasByName = this.c.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new Function1<Name, TypeAliasDescriptor>(this){
            final /* synthetic */ DeserializedMemberScope this$0;

            @Nullable
            public final TypeAliasDescriptor invoke(@NotNull Name it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return DeserializedMemberScope.access$createTypeAlias(this.this$0, it);
            }
            {
                this.this$0 = deserializedMemberScope;
                super(1);
            }
        });
        this.functionNamesLazy$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<Set<? extends Name>>(this){
            final /* synthetic */ DeserializedMemberScope this$0;

            @NotNull
            public final Set<Name> invoke() {
                return SetsKt.plus(DeserializedMemberScope.access$getFunctionProtos$p(this.this$0).keySet(), (Iterable)this.this$0.getNonDeclaredFunctionNames());
            }
            {
                this.this$0 = deserializedMemberScope;
                super(0);
            }
        });
        this.variableNamesLazy$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<Set<? extends Name>>(this){
            final /* synthetic */ DeserializedMemberScope this$0;

            @NotNull
            public final Set<Name> invoke() {
                return SetsKt.plus(DeserializedMemberScope.access$getPropertyProtos$p(this.this$0).keySet(), (Iterable)this.this$0.getNonDeclaredVariableNames());
            }
            {
                this.this$0 = deserializedMemberScope;
                super(0);
            }
        });
        this.classNames$delegate = this.c.getStorageManager().createLazyValue((Function0)new Function0<Set<? extends Name>>(classNames2){
            final /* synthetic */ Function0 $classNames;

            @NotNull
            public final Set<Name> invoke() {
                return CollectionsKt.toSet((Iterable)this.$classNames.invoke());
            }
            {
                this.$classNames = function0;
                super(0);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "functionProtos", "getFunctionProtos()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "propertyProtos", "getPropertyProtos()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "typeAliasProtos", "getTypeAliasProtos()Ljava/util/Map;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "variableNamesLazy", "getVariableNamesLazy()Ljava/util/Set;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeserializedMemberScope.class), "classNames", "getClassNames$kotlin_core()Ljava/util/Set;"))};
    }

    @NotNull
    public static final /* synthetic */ Map access$groupByName(DeserializedMemberScope $this, @NotNull Collection $receiver, @NotNull Function1 getNameIndex) {
        return $this.groupByName($receiver, getNameIndex);
    }

    @NotNull
    public static final /* synthetic */ Collection access$computeFunctions(DeserializedMemberScope $this, @NotNull Name name2) {
        return $this.computeFunctions(name2);
    }

    @NotNull
    public static final /* synthetic */ Collection access$computeProperties(DeserializedMemberScope $this, @NotNull Name name2) {
        return $this.computeProperties(name2);
    }

    @Nullable
    public static final /* synthetic */ TypeAliasDescriptor access$createTypeAlias(DeserializedMemberScope $this, @NotNull Name name2) {
        return $this.createTypeAlias(name2);
    }

    @NotNull
    public static final /* synthetic */ Map access$getFunctionProtos$p(DeserializedMemberScope $this) {
        return $this.getFunctionProtos();
    }

    @NotNull
    public static final /* synthetic */ Map access$getPropertyProtos$p(DeserializedMemberScope $this) {
        return $this.getPropertyProtos();
    }
}

