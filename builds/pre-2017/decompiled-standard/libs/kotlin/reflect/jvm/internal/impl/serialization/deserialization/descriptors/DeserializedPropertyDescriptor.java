/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfo;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedPropertyDescriptor
extends PropertyDescriptorImpl
implements DeserializedCallableMemberDescriptor {
    @NotNull
    private final ProtoBuf.Property proto;
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
    protected PropertyDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @NotNull Modality newModality, @NotNull Visibility newVisibility, @Nullable PropertyDescriptor original, @NotNull CallableMemberDescriptor.Kind kind) {
        Intrinsics.checkParameterIsNotNull(newOwner, "newOwner");
        Intrinsics.checkParameterIsNotNull((Object)newModality, "newModality");
        Intrinsics.checkParameterIsNotNull(newVisibility, "newVisibility");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Annotations annotations2 = this.getAnnotations();
        boolean bl = this.isVar();
        Name name2 = this.getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "name");
        boolean bl2 = this.isLateInit();
        boolean bl3 = this.isConst();
        Boolean bl4 = this.isExternal();
        Intrinsics.checkExpressionValueIsNotNull(bl4, "isExternal");
        return new DeserializedPropertyDescriptor(newOwner, original, annotations2, newModality, newVisibility, bl, name2, kind, bl2, bl3, bl4, this.isDelegated(), this.getProto(), this.getNameResolver(), this.getTypeTable(), this.getSinceKotlinInfoTable(), this.getContainerSource());
    }

    @NotNull
    public Boolean isExternal() {
        return Flags.IS_EXTERNAL_PROPERTY.get(this.getProto().getFlags());
    }

    @Override
    @NotNull
    public ProtoBuf.Property getProto() {
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

    public DeserializedPropertyDescriptor(@NotNull DeclarationDescriptor containingDeclaration, @Nullable PropertyDescriptor original, @NotNull Annotations annotations2, @NotNull Modality modality, @NotNull Visibility visibility, boolean isVar, @NotNull Name name2, @NotNull CallableMemberDescriptor.Kind kind, boolean isLateInit, boolean isConst, boolean isExternal, boolean isDelegated, @NotNull ProtoBuf.Property proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull SinceKotlinInfoTable sinceKotlinInfoTable, @Nullable DeserializedContainerSource containerSource) {
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull((Object)modality, "modality");
        Intrinsics.checkParameterIsNotNull(visibility, "visibility");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        Intrinsics.checkParameterIsNotNull(sinceKotlinInfoTable, "sinceKotlinInfoTable");
        super(containingDeclaration, original, annotations2, modality, visibility, isVar, name2, kind, SourceElement.NO_SOURCE, isLateInit, isConst, false, false, isExternal, isDelegated);
        this.proto = proto;
        this.nameResolver = nameResolver;
        this.typeTable = typeTable;
        this.sinceKotlinInfoTable = sinceKotlinInfoTable;
        this.containerSource = containerSource;
    }

    @Override
    @Nullable
    public SinceKotlinInfo getSinceKotlinInfo() {
        return DeserializedCallableMemberDescriptor.DefaultImpls.getSinceKotlinInfo(this);
    }
}

