/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfo;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedSimpleFunctionDescriptor
extends SimpleFunctionDescriptorImpl
implements DeserializedCallableMemberDescriptor {
    @NotNull
    private final ProtoBuf.Function proto;
    @NotNull
    private final NameResolver nameResolver;
    @NotNull
    private final TypeTable typeTable;
    @NotNull
    private final SinceKotlinInfoTable sinceKotlinInfoTable;
    @Nullable
    private final DeserializedContainerSource containerSource;

    @Override
    @NotNull
    protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name newName, @NotNull Annotations annotations2, @NotNull SourceElement source) {
        Intrinsics.checkParameterIsNotNull(newOwner, "newOwner");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(source, "source");
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor)original;
        Name name2 = newName;
        if (name2 == null) {
            Name name3 = this.getName();
            name2 = name3;
            Intrinsics.checkExpressionValueIsNotNull(name3, "name");
        }
        return new DeserializedSimpleFunctionDescriptor(newOwner, simpleFunctionDescriptor, annotations2, name2, kind, this.getProto(), this.getNameResolver(), this.getTypeTable(), this.getSinceKotlinInfoTable(), this.getContainerSource(), source);
    }

    @Override
    @NotNull
    public ProtoBuf.Function getProto() {
        return this.proto;
    }

    @Override
    @NotNull
    public NameResolver getNameResolver() {
        return this.nameResolver;
    }

    @Override
    @NotNull
    public TypeTable getTypeTable() {
        return this.typeTable;
    }

    @Override
    @NotNull
    public SinceKotlinInfoTable getSinceKotlinInfoTable() {
        return this.sinceKotlinInfoTable;
    }

    @Override
    @Nullable
    public DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public DeserializedSimpleFunctionDescriptor(@NotNull DeclarationDescriptor containingDeclaration, @Nullable SimpleFunctionDescriptor original, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull ProtoBuf.Function proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull SinceKotlinInfoTable sinceKotlinInfoTable, @Nullable DeserializedContainerSource containerSource, @Nullable SourceElement source) {
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        Intrinsics.checkParameterIsNotNull(sinceKotlinInfoTable, "sinceKotlinInfoTable");
        SourceElement sourceElement = source;
        if (sourceElement == null) {
            sourceElement = SourceElement.NO_SOURCE;
        }
        super(containingDeclaration, original, annotations2, name2, kind, sourceElement);
        this.proto = proto;
        this.nameResolver = nameResolver;
        this.typeTable = typeTable;
        this.sinceKotlinInfoTable = sinceKotlinInfoTable;
        this.containerSource = containerSource;
    }

    public /* synthetic */ DeserializedSimpleFunctionDescriptor(DeclarationDescriptor declarationDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, Annotations annotations2, Name name2, CallableMemberDescriptor.Kind kind, ProtoBuf.Function function, NameResolver nameResolver, TypeTable typeTable, SinceKotlinInfoTable sinceKotlinInfoTable, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x400) != 0) {
            sourceElement = null;
        }
        this(declarationDescriptor, simpleFunctionDescriptor, annotations2, name2, kind, function, nameResolver, typeTable, sinceKotlinInfoTable, deserializedContainerSource, sourceElement);
    }

    @Override
    @Nullable
    public SinceKotlinInfo getSinceKotlinInfo() {
        return DeserializedCallableMemberDescriptor.DefaultImpls.getSinceKotlinInfo(this);
    }
}

