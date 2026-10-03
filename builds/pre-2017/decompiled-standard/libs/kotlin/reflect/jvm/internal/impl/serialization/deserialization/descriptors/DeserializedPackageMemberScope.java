/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DeserializedPackageMemberScope
extends DeserializedMemberScope {
    private final FqName packageFqName;

    /*
     * WARNING - void declaration
     */
    @NotNull
    public List<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        void $receiver$iv$iv;
        void $receiver$iv;
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        Iterable<ClassDescriptorFactory> iterable = this.getC().getComponents().getFictitiousClassDescriptorFactories();
        Collection<DeclarationDescriptor> collection = this.computeDescriptors(kindFilter, nameFilter, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        void var5_5 = $receiver$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $receiver$iv$iv) {
            ClassDescriptorFactory it = (ClassDescriptorFactory)element$iv$iv;
            Iterable list$iv$iv = it.getAllContributedClassesIfPossible(this.packageFqName);
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        List list = (List)destination$iv$iv;
        return CollectionsKt.plus(collection, (Iterable)list);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected boolean hasClass(@NotNull Name name2) {
        ClassDescriptorFactory element$iv;
        ClassDescriptorFactory it;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        if (super.hasClass(name2)) return true;
        Iterable<ClassDescriptorFactory> $receiver$iv = this.getC().getComponents().getFictitiousClassDescriptorFactories();
        Iterator<ClassDescriptorFactory> iterator2 = $receiver$iv.iterator();
        do {
            if (!iterator2.hasNext()) return false;
        } while (!(it = (element$iv = iterator2.next())).shouldCreateClass(this.packageFqName, name2));
        return true;
    }

    @Override
    @NotNull
    protected ClassId createClassId(@NotNull Name name2) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        return new ClassId(this.packageFqName, name2);
    }

    @Override
    @NotNull
    protected Set<Name> getNonDeclaredFunctionNames() {
        return SetsKt.emptySet();
    }

    @Override
    @NotNull
    protected Set<Name> getNonDeclaredVariableNames() {
        return SetsKt.emptySet();
    }

    @Override
    protected void addEnumEntryDescriptors(@NotNull Collection<DeclarationDescriptor> result2, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(result2, "result");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
    }

    public DeserializedPackageMemberScope(@NotNull PackageFragmentDescriptor packageDescriptor, @NotNull ProtoBuf.Package proto, @NotNull NameResolver nameResolver, @Nullable DeserializedContainerSource containerSource, @NotNull DeserializationComponents components, @NotNull Function0<? extends Collection<Name>> classNames2) {
        Intrinsics.checkParameterIsNotNull(packageDescriptor, "packageDescriptor");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(components, "components");
        Intrinsics.checkParameterIsNotNull(classNames2, "classNames");
        ProtoBuf.TypeTable typeTable = proto.getTypeTable();
        Intrinsics.checkExpressionValueIsNotNull(typeTable, "proto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        ProtoBuf.SinceKotlinInfoTable sinceKotlinInfoTable = proto.getSinceKotlinInfoTable();
        Intrinsics.checkExpressionValueIsNotNull(sinceKotlinInfoTable, "proto.sinceKotlinInfoTable");
        DeserializationContext deserializationContext = components.createContext(packageDescriptor, nameResolver, typeTable2, SinceKotlinInfoTable.Companion.create(sinceKotlinInfoTable), containerSource);
        List<ProtoBuf.Function> list = proto.getFunctionList();
        Intrinsics.checkExpressionValueIsNotNull(list, "proto.functionList");
        Collection collection = list;
        List<ProtoBuf.Property> list2 = proto.getPropertyList();
        Intrinsics.checkExpressionValueIsNotNull(list2, "proto.propertyList");
        Collection collection2 = list2;
        List<ProtoBuf.TypeAlias> list3 = proto.getTypeAliasList();
        Intrinsics.checkExpressionValueIsNotNull(list3, "proto.typeAliasList");
        super(deserializationContext, collection, collection2, (Collection<ProtoBuf.TypeAlias>)list3, classNames2);
        this.packageFqName = packageDescriptor.getFqName();
    }
}

