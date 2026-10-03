/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializationContext {
    @NotNull
    private final TypeDeserializer typeDeserializer;
    @NotNull
    private final MemberDeserializer memberDeserializer;
    @NotNull
    private final DeserializationComponents components;
    @NotNull
    private final NameResolver nameResolver;
    @NotNull
    private final DeclarationDescriptor containingDeclaration;
    @NotNull
    private final TypeTable typeTable;
    @NotNull
    private final SinceKotlinInfoTable sinceKotlinInfoTable;
    @Nullable
    private final DeserializedContainerSource containerSource;

    @NotNull
    public final TypeDeserializer getTypeDeserializer() {
        return this.typeDeserializer;
    }

    @NotNull
    public final MemberDeserializer getMemberDeserializer() {
        return this.memberDeserializer;
    }

    @NotNull
    public final StorageManager getStorageManager() {
        return this.components.getStorageManager();
    }

    @NotNull
    public final DeserializationContext childContext(@NotNull DeclarationDescriptor descriptor2, @NotNull List<ProtoBuf.TypeParameter> typeParameterProtos, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable) {
        Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
        Intrinsics.checkParameterIsNotNull(typeParameterProtos, "typeParameterProtos");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        return new DeserializationContext(this.components, nameResolver, descriptor2, typeTable, this.sinceKotlinInfoTable, this.containerSource, this.typeDeserializer, typeParameterProtos);
    }

    @NotNull
    public static /* bridge */ /* synthetic */ DeserializationContext childContext$default(DeserializationContext deserializationContext, DeclarationDescriptor declarationDescriptor, List list, NameResolver nameResolver, TypeTable typeTable, int n, Object object) {
        if ((n & 4) != 0) {
            nameResolver = deserializationContext.nameResolver;
        }
        if ((n & 8) != 0) {
            typeTable = deserializationContext.typeTable;
        }
        return deserializationContext.childContext(declarationDescriptor, list, nameResolver, typeTable);
    }

    @NotNull
    public final DeserializationComponents getComponents() {
        return this.components;
    }

    @NotNull
    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    @NotNull
    public final DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    @NotNull
    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    @NotNull
    public final SinceKotlinInfoTable getSinceKotlinInfoTable() {
        return this.sinceKotlinInfoTable;
    }

    @Nullable
    public final DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public DeserializationContext(@NotNull DeserializationComponents components, @NotNull NameResolver nameResolver, @NotNull DeclarationDescriptor containingDeclaration, @NotNull TypeTable typeTable, @NotNull SinceKotlinInfoTable sinceKotlinInfoTable, @Nullable DeserializedContainerSource containerSource, @Nullable TypeDeserializer parentTypeDeserializer, @NotNull List<ProtoBuf.TypeParameter> typeParameters2) {
        Intrinsics.checkParameterIsNotNull(components, "components");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        Intrinsics.checkParameterIsNotNull(sinceKotlinInfoTable, "sinceKotlinInfoTable");
        Intrinsics.checkParameterIsNotNull(typeParameters2, "typeParameters");
        this.components = components;
        this.nameResolver = nameResolver;
        this.containingDeclaration = containingDeclaration;
        this.typeTable = typeTable;
        this.sinceKotlinInfoTable = sinceKotlinInfoTable;
        this.containerSource = containerSource;
        this.typeDeserializer = new TypeDeserializer(this, parentTypeDeserializer, typeParameters2, "Deserializer for " + this.containingDeclaration.getName());
        this.memberDeserializer = new MemberDeserializer(this);
    }
}

