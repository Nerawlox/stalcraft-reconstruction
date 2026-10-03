/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorNonRootImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractTypeAliasDescriptor
extends DeclarationDescriptorNonRootImpl
implements TypeAliasDescriptor {
    private List<? extends TypeParameterDescriptor> declaredTypeParametersImpl;
    private final typeConstructor.1 typeConstructor;
    private final Visibility visibilityImpl;

    public final void initialize(@NotNull List<? extends TypeParameterDescriptor> declaredTypeParameters) {
        Intrinsics.checkParameterIsNotNull(declaredTypeParameters, "declaredTypeParameters");
        this.declaredTypeParametersImpl = declaredTypeParameters;
    }

    @Override
    public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
        Intrinsics.checkParameterIsNotNull(visitor2, "visitor");
        return visitor2.visitTypeAliasDescriptor(this, data2);
    }

    @Override
    public boolean isInner() {
        return TypeUtils.contains((KotlinType)this.getUnderlyingType(), new Function1<UnwrappedType, Boolean>(this){
            final /* synthetic */ AbstractTypeAliasDescriptor this$0;

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final boolean invoke(UnwrappedType it) {
                AbstractTypeAliasDescriptor abstractTypeAliasDescriptor;
                if (it.isError()) return false;
                AbstractTypeAliasDescriptor $receiver = abstractTypeAliasDescriptor = this.this$0;
                ClassifierDescriptor constructorDescriptor = it.getConstructor().getDeclarationDescriptor();
                if (!(constructorDescriptor instanceof TypeParameterDescriptor)) return false;
                if (!(Intrinsics.areEqual(((TypeParameterDescriptor)constructorDescriptor).getContainingDeclaration(), this.this$0) ^ true)) return false;
                return true;
            }
            {
                this.this$0 = abstractTypeAliasDescriptor;
                super(1);
            }
        });
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> list = this.declaredTypeParametersImpl;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
        }
        return list;
    }

    @Override
    @NotNull
    public Modality getModality() {
        return Modality.FINAL;
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        return this.visibilityImpl;
    }

    @Override
    public boolean isHeader() {
        return false;
    }

    @Override
    public boolean isImpl() {
        return false;
    }

    @Override
    public boolean isExternal() {
        return false;
    }

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor() {
        return this.typeConstructor;
    }

    @Override
    @NotNull
    public String toString() {
        return "typealias " + this.getName().asString();
    }

    @Override
    @NotNull
    public TypeAliasDescriptor getOriginal() {
        DeclarationDescriptorWithSource declarationDescriptorWithSource = super.getOriginal();
        if (declarationDescriptorWithSource == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
        }
        return (TypeAliasDescriptor)declarationDescriptorWithSource;
    }

    @NotNull
    protected abstract List<TypeParameterDescriptor> getTypeConstructorTypeParameters();

    @NotNull
    protected final SimpleType computeDefaultType() {
        ClassifierDescriptor classifierDescriptor = this;
        Object object = this.getClassDescriptor();
        if (object == null || (object = object.getUnsubstitutedMemberScope()) == null) {
            object = MemberScope.Empty.INSTANCE;
        }
        SimpleType simpleType2 = TypeUtils.makeUnsubstitutedType(classifierDescriptor, (MemberScope)object);
        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "TypeUtils.makeUnsubstitu\u2026ope ?: MemberScope.Empty)");
        return simpleType2;
    }

    public AbstractTypeAliasDescriptor(@NotNull DeclarationDescriptor containingDeclaration, @NotNull Annotations annotations2, @NotNull Name name2, @NotNull SourceElement sourceElement, @NotNull Visibility visibilityImpl) {
        Intrinsics.checkParameterIsNotNull(containingDeclaration, "containingDeclaration");
        Intrinsics.checkParameterIsNotNull(annotations2, "annotations");
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(sourceElement, "sourceElement");
        Intrinsics.checkParameterIsNotNull(visibilityImpl, "visibilityImpl");
        super(containingDeclaration, annotations2, name2, sourceElement);
        this.visibilityImpl = visibilityImpl;
        this.typeConstructor = new TypeConstructor(this){
            final /* synthetic */ AbstractTypeAliasDescriptor this$0;

            @NotNull
            public TypeAliasDescriptor getDeclarationDescriptor() {
                return this.this$0;
            }

            @NotNull
            public List<TypeParameterDescriptor> getParameters() {
                return this.this$0.getTypeConstructorTypeParameters();
            }

            @NotNull
            public Collection<KotlinType> getSupertypes() {
                Collection<KotlinType> collection = this.getDeclarationDescriptor().getUnderlyingType().getConstructor().getSupertypes();
                Intrinsics.checkExpressionValueIsNotNull(collection, "declarationDescriptor.un\u2026pe.constructor.supertypes");
                return collection;
            }

            public boolean isFinal() {
                return this.getDeclarationDescriptor().getUnderlyingType().getConstructor().isFinal();
            }

            public boolean isDenotable() {
                return true;
            }

            @NotNull
            public KotlinBuiltIns getBuiltIns() {
                return DescriptorUtilsKt.getBuiltIns(this.getDeclarationDescriptor());
            }

            @NotNull
            public String toString() {
                return "[typealias " + this.getDeclarationDescriptor().getName().asString() + "]";
            }
            {
                this.this$0 = $outer;
            }
        };
    }
}

