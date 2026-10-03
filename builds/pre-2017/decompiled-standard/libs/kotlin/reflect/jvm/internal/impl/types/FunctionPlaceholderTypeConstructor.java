/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FunctionPlaceholderTypeConstructor
implements TypeConstructor {
    private final TypeConstructor errorTypeConstructor;
    @NotNull
    private final List<KotlinType> argumentTypes;
    private final boolean hasDeclaredArguments;
    private final KotlinBuiltIns kotlinBuiltIns;

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getParameters() {
        List<TypeParameterDescriptor> list = this.errorTypeConstructor.getParameters();
        Intrinsics.checkExpressionValueIsNotNull(list, "errorTypeConstructor.parameters");
        return list;
    }

    @Override
    @NotNull
    public Collection<KotlinType> getSupertypes() {
        Collection<KotlinType> collection = this.errorTypeConstructor.getSupertypes();
        Intrinsics.checkExpressionValueIsNotNull(collection, "errorTypeConstructor.supertypes");
        return collection;
    }

    @Override
    public boolean isFinal() {
        return this.errorTypeConstructor.isFinal();
    }

    @Override
    public boolean isDenotable() {
        return this.errorTypeConstructor.isDenotable();
    }

    @Override
    @Nullable
    public ClassifierDescriptor getDeclarationDescriptor() {
        return this.errorTypeConstructor.getDeclarationDescriptor();
    }

    @NotNull
    public String toString() {
        return this.errorTypeConstructor.toString();
    }

    @Override
    @NotNull
    public KotlinBuiltIns getBuiltIns() {
        return this.kotlinBuiltIns;
    }

    @NotNull
    public final List<KotlinType> getArgumentTypes() {
        return this.argumentTypes;
    }

    public final boolean getHasDeclaredArguments() {
        return this.hasDeclaredArguments;
    }

    public FunctionPlaceholderTypeConstructor(@NotNull List<? extends KotlinType> argumentTypes, boolean hasDeclaredArguments, @NotNull KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.checkParameterIsNotNull(argumentTypes, "argumentTypes");
        Intrinsics.checkParameterIsNotNull(kotlinBuiltIns, "kotlinBuiltIns");
        this.argumentTypes = argumentTypes;
        this.hasDeclaredArguments = hasDeclaredArguments;
        this.kotlinBuiltIns = kotlinBuiltIns;
        TypeConstructor typeConstructor2 = ErrorUtils.createErrorTypeConstructorWithCustomDebugName("PLACEHOLDER_FUNCTION_TYPE" + this.argumentTypes);
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor2, "ErrorUtils.createErrorTy\u2026ON_TYPE\" + argumentTypes)");
        this.errorTypeConstructor = typeConstructor2;
    }
}

