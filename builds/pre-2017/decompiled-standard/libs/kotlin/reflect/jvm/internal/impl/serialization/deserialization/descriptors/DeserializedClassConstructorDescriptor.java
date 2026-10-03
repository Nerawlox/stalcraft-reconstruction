/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
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

public final class DeserializedClassConstructorDescriptor
extends ClassConstructorDescriptorImpl
implements DeserializedCallableMemberDescriptor {
    @NotNull
    private final ProtoBuf.Constructor proto;
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
    protected DeserializedClassConstructorDescriptor createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor original, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name newName, @NotNull Annotations annotations2, @NotNull SourceElement source) {
        Intrinsics.checkParameterIsNotNull(newOwner, "newOwner");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(source, "source");
        DeclarationDescriptor declarationDescriptor = newOwner;
        if (declarationDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
        return new DeserializedClassConstructorDescriptor((ClassDescriptor)declarationDescriptor, (ConstructorDescriptor)original, annotations2, this.isPrimary, kind, this.getProto(), this.getNameResolver(), this.getTypeTable(), this.getSinceKotlinInfoTable(), this.getContainerSource(), source);
    }

    @Override
    public boolean isExternal() {
        return false;
    }

    @Override
    public boolean isInline() {
        return false;
    }

    @Override
    public boolean isTailrec() {
        return false;
    }

    @Override
    public boolean isSuspend() {
        return false;
    }

    @Override
    @NotNull
    public ProtoBuf.Constructor getProto() {
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

    public DeserializedClassConstructorDescriptor(@NotNull ClassDescriptor containingDeclaration, @Nullable ConstructorDescriptor original, @NotNull Annotations annotations2, boolean isPrimary, @NotNull CallableMemberDescriptor.Kind kind, @NotNull ProtoBuf.Constructor proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull SinceKotlinInfoTable sinceKotlinInfoTable, @Nullable DeserializedContainerSource containerSource, @Nullable SourceElement source) {
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        Intrinsics.checkParameterIsNotNull(sinceKotlinInfoTable, "sinceKotlinInfoTable");
        SourceElement sourceElement = source;
        if (sourceElement == null) {
            sourceElement = SourceElement.NO_SOURCE;
        }
        super(containingDeclaration, original, annotations2, isPrimary, kind, sourceElement);
        this.proto = proto;
        this.nameResolver = nameResolver;
        this.typeTable = typeTable;
        this.sinceKotlinInfoTable = sinceKotlinInfoTable;
        this.containerSource = containerSource;
    }

    public /* synthetic */ DeserializedClassConstructorDescriptor(ClassDescriptor classDescriptor, ConstructorDescriptor constructorDescriptor, Annotations annotations2, boolean bl, CallableMemberDescriptor.Kind kind, ProtoBuf.Constructor constructor, NameResolver nameResolver, TypeTable typeTable, SinceKotlinInfoTable sinceKotlinInfoTable, DeserializedContainerSource deserializedContainerSource, SourceElement sourceElement, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 0x400) != 0) {
            sourceElement = null;
        }
        this(classDescriptor, constructorDescriptor, annotations2, bl, kind, constructor, nameResolver, typeTable, sinceKotlinInfoTable, deserializedContainerSource, sourceElement);
    }

    @Override
    @Nullable
    public SinceKotlinInfo getSinceKotlinInfo() {
        return DeserializedCallableMemberDescriptor.DefaultImpls.getSinceKotlinInfo(this);
    }
}

