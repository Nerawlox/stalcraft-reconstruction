/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfo;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedTypeAliasDescriptor
extends AbstractTypeAliasDescriptor
implements DeserializedMemberDescriptor {
    @NotNull
    private SimpleType underlyingType;
    @NotNull
    private SimpleType expandedType;
    private List<? extends TypeParameterDescriptor> typeConstructorParameters;
    private SimpleType defaultTypeImpl;
    @NotNull
    private final ProtoBuf.TypeAlias proto;
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
    public SimpleType getUnderlyingType() {
        SimpleType simpleType2 = this.underlyingType;
        if (simpleType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("underlyingType");
        }
        return simpleType2;
    }

    private void setUnderlyingType(SimpleType simpleType2) {
        this.underlyingType = simpleType2;
    }

    @Override
    @NotNull
    public SimpleType getExpandedType() {
        SimpleType simpleType2 = this.expandedType;
        if (simpleType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("expandedType");
        }
        return simpleType2;
    }

    private void setExpandedType(SimpleType simpleType2) {
        this.expandedType = simpleType2;
    }

    public final void initialize(@NotNull List<? extends TypeParameterDescriptor> declaredTypeParameters, @NotNull SimpleType underlyingType, @NotNull SimpleType expandedType) {
        Intrinsics.checkParameterIsNotNull(declaredTypeParameters, "declaredTypeParameters");
        Intrinsics.checkParameterIsNotNull(underlyingType, "underlyingType");
        Intrinsics.checkParameterIsNotNull(expandedType, "expandedType");
        this.initialize(declaredTypeParameters);
        this.setUnderlyingType(underlyingType);
        this.setExpandedType(expandedType);
        this.typeConstructorParameters = TypeParameterUtilsKt.computeConstructorTypeParameters(this);
        this.defaultTypeImpl = this.computeDefaultType();
    }

    @Override
    @Nullable
    public ClassDescriptor getClassDescriptor() {
        ClassDescriptor classDescriptor;
        if (this.getExpandedType().isError()) {
            classDescriptor = null;
        } else {
            ClassifierDescriptor classifierDescriptor = this.getExpandedType().getConstructor().getDeclarationDescriptor();
            if (!(classifierDescriptor instanceof ClassDescriptor)) {
                classifierDescriptor = null;
            }
            classDescriptor = (ClassDescriptor)classifierDescriptor;
        }
        return classDescriptor;
    }

    @Override
    @NotNull
    public SimpleType getDefaultType() {
        SimpleType simpleType2 = this.defaultTypeImpl;
        if (simpleType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultTypeImpl");
        }
        return simpleType2;
    }

    @Override
    @NotNull
    public TypeAliasDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
        Intrinsics.checkParameterIsNotNull(substitutor, "substitutor");
        if (substitutor.isEmpty()) {
            return this;
        }
        DeclarationDescriptor declarationDescriptor = this.getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(declarationDescriptor, "containingDeclaration");
        Annotations annotations2 = this.getAnnotations();
        Intrinsics.checkExpressionValueIsNotNull(annotations2, "annotations");
        Name name2 = this.getName();
        Intrinsics.checkExpressionValueIsNotNull(name2, "name");
        DeserializedTypeAliasDescriptor substituted = new DeserializedTypeAliasDescriptor(declarationDescriptor, annotations2, name2, this.getVisibility(), this.getProto(), this.getNameResolver(), this.getTypeTable(), this.getSinceKotlinInfoTable(), this.getContainerSource());
        substituted.initialize(this.getDeclaredTypeParameters(), TypeSubstitutionKt.asSimpleType(substitutor.safeSubstitute(this.getUnderlyingType(), Variance.INVARIANT)), TypeSubstitutionKt.asSimpleType(substitutor.safeSubstitute(this.getExpandedType(), Variance.INVARIANT)));
        return substituted;
    }

    @Override
    @NotNull
    protected List<TypeParameterDescriptor> getTypeConstructorTypeParameters() {
        List<TypeParameterDescriptor> list = this.typeConstructorParameters;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeConstructorParameters");
        }
        return list;
    }

    @Override
    @NotNull
    public ProtoBuf.TypeAlias getProto() {
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

    public DeserializedTypeAliasDescriptor(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull Visibility visibility, @NotNull ProtoBuf.TypeAlias proto, @NotNull NameResolver nameResolver, @NotNull TypeTable typeTable, @NotNull SinceKotlinInfoTable sinceKotlinInfoTable, @Nullable DeserializedContainerSource containerSource) {
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(visibility, "visibility");
        Intrinsics.checkParameterIsNotNull(proto, "proto");
        Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
        Intrinsics.checkParameterIsNotNull(typeTable, "typeTable");
        Intrinsics.checkParameterIsNotNull(sinceKotlinInfoTable, "sinceKotlinInfoTable");
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkExpressionValueIsNotNull(sourceElement, "SourceElement.NO_SOURCE");
        super(containingDeclaration, annotations2, name2, sourceElement, visibility);
        this.proto = proto;
        this.nameResolver = nameResolver;
        this.typeTable = typeTable;
        this.sinceKotlinInfoTable = sinceKotlinInfoTable;
        this.containerSource = containerSource;
    }

    @Override
    @Nullable
    public SinceKotlinInfo getSinceKotlinInfo() {
        return DeserializedMemberDescriptor.DefaultImpls.getSinceKotlinInfo(this);
    }
}

