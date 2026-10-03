/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceKind;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorSimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ErrorUtils {
    private static final ModuleDescriptor ERROR_MODULE = new ModuleDescriptor(){

        @Override
        @NotNull
        public SourceKind getSourceKind() {
            SourceKind sourceKind = SourceKind.NONE;
            if (sourceKind == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getSourceKind"));
            }
            return sourceKind;
        }

        @Override
        @Nullable
        public <T> T getCapability(@NotNull ModuleDescriptor.Capability<T> capability) {
            if (capability == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "capability", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getCapability"));
            }
            return null;
        }

        @Override
        @NotNull
        public Annotations getAnnotations() {
            Annotations annotations2 = Annotations.Companion.getEMPTY();
            if (annotations2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getAnnotations"));
            }
            return annotations2;
        }

        @Override
        @NotNull
        public Collection<FqName> getSubPackagesOf(@NotNull FqName fqName2, @NotNull Function1<? super Name, Boolean> nameFilter) {
            if (fqName2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getSubPackagesOf"));
            }
            if (nameFilter == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "nameFilter", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getSubPackagesOf"));
            }
            List<FqName> list = CollectionsKt.emptyList();
            if (list == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getSubPackagesOf"));
            }
            return list;
        }

        @Override
        @NotNull
        public Name getName() {
            Name name2 = Name.special("<ERROR MODULE>");
            if (name2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getName"));
            }
            return name2;
        }

        @Override
        @NotNull
        public PackageViewDescriptor getPackage(@NotNull FqName fqName2) {
            if (fqName2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fqName", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getPackage"));
            }
            throw new IllegalStateException("Should not be called!");
        }

        @Override
        @NotNull
        public List<ModuleDescriptor> getAllDependencyModules() {
            List<ModuleDescriptor> list = CollectionsKt.emptyList();
            if (list == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getAllDependencyModules"));
            }
            return list;
        }

        @Override
        @NotNull
        public Set<ModuleDescriptor> getAllImplementingModules() {
            Set<ModuleDescriptor> set = Collections.emptySet();
            if (set == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getAllImplementingModules"));
            }
            return set;
        }

        @Override
        public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> visitor2, D data2) {
            if (visitor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visitor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "accept"));
            }
            return null;
        }

        @Override
        public void acceptVoid(DeclarationDescriptorVisitor<Void, Void> visitor2) {
        }

        @Override
        @NotNull
        public ModuleDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
            if (substitutor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitutor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "substitute"));
            }
            1 v0 = this;
            if (v0 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "substitute"));
            }
            return v0;
        }

        @Override
        public boolean shouldSeeInternalsOf(@NotNull ModuleDescriptor targetModule) {
            if (targetModule == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "targetModule", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "shouldSeeInternalsOf"));
            }
            return false;
        }

        @Override
        @NotNull
        public DeclarationDescriptor getOriginal() {
            1 v0 = this;
            if (v0 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getOriginal"));
            }
            return v0;
        }

        @Override
        @Nullable
        public DeclarationDescriptor getContainingDeclaration() {
            return null;
        }

        @Override
        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            DefaultBuiltIns defaultBuiltIns = DefaultBuiltIns.getInstance();
            if (defaultBuiltIns == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1", "getBuiltIns"));
            }
            return defaultBuiltIns;
        }
    };
    private static final ErrorClassDescriptor ERROR_CLASS = new ErrorClassDescriptor(null);
    public static final SimpleType ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES = ErrorUtils.createErrorType("<LOOP IN SUPERTYPES>");
    private static final KotlinType ERROR_PROPERTY_TYPE = ErrorUtils.createErrorType("<ERROR PROPERTY TYPE>");
    private static final PropertyDescriptor ERROR_PROPERTY = ErrorUtils.createErrorProperty();
    private static final Set<PropertyDescriptor> ERROR_PROPERTY_GROUP = Collections.singleton(ERROR_PROPERTY);

    public static boolean containsErrorType(@NotNull CallableDescriptor callableDescriptor) {
        if (callableDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "callableDescriptor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "containsErrorType"));
        }
        if (callableDescriptor instanceof FunctionDescriptor) {
            return ErrorUtils.containsErrorType((FunctionDescriptor)callableDescriptor);
        }
        return ErrorUtils.containsErrorType(callableDescriptor.getReturnType());
    }

    public static boolean containsErrorType(@NotNull FunctionDescriptor function) {
        if (function == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "function", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "containsErrorType"));
        }
        if (ErrorUtils.containsErrorType(function.getReturnType())) {
            return true;
        }
        ReceiverParameterDescriptor receiverParameter = function.getExtensionReceiverParameter();
        if (receiverParameter != null && ErrorUtils.containsErrorType(receiverParameter.getType())) {
            return true;
        }
        for (ValueParameterDescriptor valueParameterDescriptor : function.getValueParameters()) {
            if (!ErrorUtils.containsErrorType(valueParameterDescriptor.getType())) continue;
            return true;
        }
        for (TypeParameterDescriptor typeParameterDescriptor : function.getTypeParameters()) {
            for (KotlinType upperBound : typeParameterDescriptor.getUpperBounds()) {
                if (!ErrorUtils.containsErrorType(upperBound)) continue;
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static ClassDescriptor createErrorClass(@NotNull String debugMessage) {
        if (debugMessage == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorClass"));
        }
        ErrorClassDescriptor errorClassDescriptor = new ErrorClassDescriptor(debugMessage);
        if (errorClassDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorClass"));
        }
        return errorClassDescriptor;
    }

    @NotNull
    public static MemberScope createErrorScope(@NotNull String debugMessage) {
        if (debugMessage == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorScope"));
        }
        MemberScope memberScope2 = ErrorUtils.createErrorScope(debugMessage, false);
        if (memberScope2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorScope"));
        }
        return memberScope2;
    }

    @NotNull
    public static MemberScope createErrorScope(@NotNull String debugMessage, boolean throwExceptions) {
        if (debugMessage == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorScope"));
        }
        if (throwExceptions) {
            ThrowingScope throwingScope = new ThrowingScope(debugMessage);
            if (throwingScope == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorScope"));
            }
            return throwingScope;
        }
        ErrorScope errorScope = new ErrorScope(debugMessage);
        if (errorScope == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorScope"));
        }
        return errorScope;
    }

    @NotNull
    private static PropertyDescriptorImpl createErrorProperty() {
        PropertyDescriptorImpl descriptor2 = PropertyDescriptorImpl.create(ERROR_CLASS, Annotations.Companion.getEMPTY(), Modality.OPEN, Visibilities.PUBLIC, true, Name.special("<ERROR PROPERTY>"), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE, false, false, false, false, false, false);
        descriptor2.setType(ERROR_PROPERTY_TYPE, Collections.emptyList(), null, (KotlinType)null);
        PropertyDescriptorImpl propertyDescriptorImpl = descriptor2;
        if (propertyDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorProperty"));
        }
        return propertyDescriptorImpl;
    }

    @NotNull
    private static SimpleFunctionDescriptor createErrorFunction(@NotNull ErrorScope ownerScope) {
        if (ownerScope == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "ownerScope", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorFunction"));
        }
        ErrorSimpleFunctionDescriptorImpl function = new ErrorSimpleFunctionDescriptorImpl(ERROR_CLASS, ownerScope);
        function.initialize((KotlinType)null, (ReceiverParameterDescriptor)null, Collections.emptyList(), Collections.emptyList(), (KotlinType)ErrorUtils.createErrorType("<ERROR FUNCTION RETURN TYPE>"), Modality.OPEN, Visibilities.PUBLIC);
        ErrorSimpleFunctionDescriptorImpl errorSimpleFunctionDescriptorImpl = function;
        if (errorSimpleFunctionDescriptorImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorFunction"));
        }
        return errorSimpleFunctionDescriptorImpl;
    }

    @NotNull
    public static SimpleType createErrorType(@NotNull String debugMessage) {
        if (debugMessage == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorType"));
        }
        SimpleType simpleType2 = ErrorUtils.createErrorTypeWithArguments(debugMessage, Collections.<TypeProjection>emptyList());
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorType"));
        }
        return simpleType2;
    }

    @NotNull
    public static SimpleType createErrorTypeWithCustomDebugName(@NotNull String debugName) {
        if (debugName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugName", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithCustomDebugName"));
        }
        SimpleType simpleType2 = ErrorUtils.createErrorTypeWithCustomConstructor(debugName, ErrorUtils.createErrorTypeConstructorWithCustomDebugName(debugName));
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithCustomDebugName"));
        }
        return simpleType2;
    }

    @NotNull
    public static SimpleType createErrorTypeWithCustomConstructor(@NotNull String debugName, @NotNull TypeConstructor typeConstructor2) {
        if (debugName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugName", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithCustomConstructor"));
        }
        if (typeConstructor2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeConstructor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithCustomConstructor"));
        }
        ErrorTypeImpl errorTypeImpl = new ErrorTypeImpl(typeConstructor2, ErrorUtils.createErrorScope(debugName));
        if (errorTypeImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithCustomConstructor"));
        }
        return errorTypeImpl;
    }

    @NotNull
    public static SimpleType createErrorTypeWithArguments(@NotNull String debugMessage, @NotNull List<TypeProjection> arguments2) {
        if (debugMessage == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithArguments"));
        }
        if (arguments2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "arguments", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithArguments"));
        }
        ErrorTypeImpl errorTypeImpl = new ErrorTypeImpl(ErrorUtils.createErrorTypeConstructor(debugMessage), ErrorUtils.createErrorScope(debugMessage), arguments2, false);
        if (errorTypeImpl == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeWithArguments"));
        }
        return errorTypeImpl;
    }

    @NotNull
    public static TypeConstructor createErrorTypeConstructor(@NotNull String debugMessage) {
        if (debugMessage == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeConstructor"));
        }
        TypeConstructor typeConstructor2 = ErrorUtils.createErrorTypeConstructorWithCustomDebugName("[ERROR : " + debugMessage + "]", ERROR_CLASS);
        if (typeConstructor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeConstructor"));
        }
        return typeConstructor2;
    }

    @NotNull
    public static TypeConstructor createErrorTypeConstructorWithCustomDebugName(@NotNull String debugName) {
        if (debugName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugName", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeConstructorWithCustomDebugName"));
        }
        TypeConstructor typeConstructor2 = ErrorUtils.createErrorTypeConstructorWithCustomDebugName(debugName, ERROR_CLASS);
        if (typeConstructor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeConstructorWithCustomDebugName"));
        }
        return typeConstructor2;
    }

    @NotNull
    private static TypeConstructor createErrorTypeConstructorWithCustomDebugName(final @NotNull String debugName, final @NotNull ErrorClassDescriptor errorClass) {
        if (debugName == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugName", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeConstructorWithCustomDebugName"));
        }
        if (errorClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "errorClass", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeConstructorWithCustomDebugName"));
        }
        TypeConstructor typeConstructor2 = new TypeConstructor(){

            @Override
            @NotNull
            public List<TypeParameterDescriptor> getParameters() {
                List<TypeParameterDescriptor> list = CollectionsKt.emptyList();
                if (list == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2", "getParameters"));
                }
                return list;
            }

            @Override
            @NotNull
            public Collection<KotlinType> getSupertypes() {
                List<KotlinType> list = CollectionsKt.emptyList();
                if (list == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2", "getSupertypes"));
                }
                return list;
            }

            @Override
            public boolean isFinal() {
                return false;
            }

            @Override
            public boolean isDenotable() {
                return false;
            }

            @Override
            @Nullable
            public ClassifierDescriptor getDeclarationDescriptor() {
                return errorClass;
            }

            @Override
            @NotNull
            public KotlinBuiltIns getBuiltIns() {
                DefaultBuiltIns defaultBuiltIns = DefaultBuiltIns.getInstance();
                if (defaultBuiltIns == null) {
                    throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2", "getBuiltIns"));
                }
                return defaultBuiltIns;
            }

            public String toString() {
                return debugName;
            }
        };
        if (typeConstructor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createErrorTypeConstructorWithCustomDebugName"));
        }
        return typeConstructor2;
    }

    public static boolean containsErrorType(@Nullable KotlinType type2) {
        if (type2 == null) {
            return false;
        }
        if (type2.isError()) {
            return true;
        }
        for (TypeProjection projection : type2.getArguments()) {
            if (projection.isStarProjection() || !ErrorUtils.containsErrorType(projection.getType())) continue;
            return true;
        }
        return false;
    }

    public static boolean isError(@Nullable DeclarationDescriptor candidate) {
        if (candidate == null) {
            return false;
        }
        return ErrorUtils.isErrorClass(candidate) || ErrorUtils.isErrorClass(candidate.getContainingDeclaration()) || candidate == ERROR_MODULE;
    }

    private static boolean isErrorClass(@Nullable DeclarationDescriptor candidate) {
        return candidate instanceof ErrorClassDescriptor;
    }

    @NotNull
    public static ModuleDescriptor getErrorModule() {
        ModuleDescriptor moduleDescriptor = ERROR_MODULE;
        if (moduleDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "getErrorModule"));
        }
        return moduleDescriptor;
    }

    public static boolean isUninferredParameter(@Nullable KotlinType type2) {
        return type2 != null && type2.getConstructor() instanceof UninferredParameterTypeConstructor;
    }

    public static boolean containsUninferredParameter(@Nullable KotlinType type2) {
        return TypeUtils.contains(type2, new Function1<UnwrappedType, Boolean>(){

            @Override
            public Boolean invoke(UnwrappedType argumentType) {
                return ErrorUtils.isUninferredParameter(argumentType);
            }
        });
    }

    @NotNull
    public static KotlinType createUninferredParameterType(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeParameterDescriptor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createUninferredParameterType"));
        }
        SimpleType simpleType2 = ErrorUtils.createErrorTypeWithCustomConstructor("Scope for error type for not inferred parameter: " + typeParameterDescriptor.getName(), new UninferredParameterTypeConstructor(typeParameterDescriptor));
        if (simpleType2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils", "createUninferredParameterType"));
        }
        return simpleType2;
    }

    private ErrorUtils() {
    }

    public static class UninferredParameterTypeConstructor
    implements TypeConstructor {
        private final TypeParameterDescriptor typeParameterDescriptor;
        private final TypeConstructor errorTypeConstructor;

        private UninferredParameterTypeConstructor(@NotNull TypeParameterDescriptor descriptor2) {
            if (descriptor2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor", "<init>"));
            }
            this.typeParameterDescriptor = descriptor2;
            this.errorTypeConstructor = ErrorUtils.createErrorTypeConstructorWithCustomDebugName("CANT_INFER_TYPE_PARAMETER: " + descriptor2.getName());
        }

        @NotNull
        public TypeParameterDescriptor getTypeParameterDescriptor() {
            TypeParameterDescriptor typeParameterDescriptor = this.typeParameterDescriptor;
            if (typeParameterDescriptor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor", "getTypeParameterDescriptor"));
            }
            return typeParameterDescriptor;
        }

        @Override
        @NotNull
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> list = this.errorTypeConstructor.getParameters();
            if (list == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor", "getParameters"));
            }
            return list;
        }

        @Override
        @NotNull
        public Collection<KotlinType> getSupertypes() {
            Collection<KotlinType> collection = this.errorTypeConstructor.getSupertypes();
            if (collection == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor", "getSupertypes"));
            }
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

        @Override
        @NotNull
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns kotlinBuiltIns = DescriptorUtilsKt.getBuiltIns(this.typeParameterDescriptor);
            if (kotlinBuiltIns == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor", "getBuiltIns"));
            }
            return kotlinBuiltIns;
        }
    }

    private static class ErrorTypeImpl
    extends SimpleType {
        private final TypeConstructor constructor;
        private final MemberScope memberScope;
        private final List<TypeProjection> arguments;
        private final boolean nullability;

        private ErrorTypeImpl(@NotNull TypeConstructor constructor, @NotNull MemberScope memberScope2, @NotNull List<TypeProjection> arguments2, boolean nullability) {
            if (constructor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "constructor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "<init>"));
            }
            if (memberScope2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "memberScope", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "<init>"));
            }
            if (arguments2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "arguments", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "<init>"));
            }
            this.constructor = constructor;
            this.memberScope = memberScope2;
            this.arguments = arguments2;
            this.nullability = nullability;
        }

        private ErrorTypeImpl(@NotNull TypeConstructor constructor, @NotNull MemberScope memberScope2) {
            if (constructor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "constructor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "<init>"));
            }
            if (memberScope2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "memberScope", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "<init>"));
            }
            this(constructor, memberScope2, Collections.emptyList(), false);
        }

        @Override
        @NotNull
        public TypeConstructor getConstructor() {
            TypeConstructor typeConstructor2 = this.constructor;
            if (typeConstructor2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "getConstructor"));
            }
            return typeConstructor2;
        }

        @Override
        @NotNull
        public List<TypeProjection> getArguments() {
            List<TypeProjection> list = this.arguments;
            if (list == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "getArguments"));
            }
            return list;
        }

        @Override
        public boolean isMarkedNullable() {
            return this.nullability;
        }

        @Override
        @NotNull
        public MemberScope getMemberScope() {
            MemberScope memberScope2 = this.memberScope;
            if (memberScope2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "getMemberScope"));
            }
            return memberScope2;
        }

        @Override
        public boolean isError() {
            return true;
        }

        @Override
        @NotNull
        public Annotations getAnnotations() {
            Annotations annotations2 = Annotations.Companion.getEMPTY();
            if (annotations2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "getAnnotations"));
            }
            return annotations2;
        }

        @Override
        public String toString() {
            return this.constructor.toString() + (this.arguments.isEmpty() ? "" : CollectionsKt.joinToString(this.arguments, ", ", "<", ">", -1, "...", null));
        }

        @Override
        @NotNull
        public SimpleType replaceAnnotations(@NotNull Annotations newAnnotations) {
            if (newAnnotations == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "newAnnotations", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "replaceAnnotations"));
            }
            ErrorTypeImpl errorTypeImpl = this;
            if (errorTypeImpl == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "replaceAnnotations"));
            }
            return errorTypeImpl;
        }

        @Override
        @NotNull
        public SimpleType makeNullableAsSpecified(boolean newNullability) {
            ErrorTypeImpl errorTypeImpl = new ErrorTypeImpl(this.constructor, this.memberScope, this.arguments, newNullability);
            if (errorTypeImpl == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorTypeImpl", "makeNullableAsSpecified"));
            }
            return errorTypeImpl;
        }
    }

    private static class ErrorClassDescriptor
    extends ClassDescriptorImpl {
        public ErrorClassDescriptor(@Nullable String name2) {
            super(ErrorUtils.getErrorModule(), Name.special(name2 == null ? "<ERROR CLASS>" : "<ERROR CLASS: " + name2 + ">"), Modality.OPEN, ClassKind.CLASS, Collections.<KotlinType>emptyList(), SourceElement.NO_SOURCE, false);
            ClassConstructorDescriptorImpl errorConstructor = ClassConstructorDescriptorImpl.create(this, Annotations.Companion.getEMPTY(), true, SourceElement.NO_SOURCE);
            errorConstructor.initialize(Collections.<ValueParameterDescriptor>emptyList(), Visibilities.INTERNAL);
            MemberScope memberScope2 = ErrorUtils.createErrorScope(this.getName().asString());
            errorConstructor.setReturnType(new ErrorTypeImpl(ErrorUtils.createErrorTypeConstructorWithCustomDebugName("<ERROR>", this), memberScope2));
            this.initialize(memberScope2, Collections.singleton(errorConstructor), errorConstructor);
        }

        @Override
        @NotNull
        public ClassDescriptor substitute(@NotNull TypeSubstitutor substitutor) {
            if (substitutor == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "substitutor", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "substitute"));
            }
            ErrorClassDescriptor errorClassDescriptor = this;
            if (errorClassDescriptor == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "substitute"));
            }
            return errorClassDescriptor;
        }

        @Override
        public String toString() {
            return this.getName().asString();
        }

        @Override
        @NotNull
        public MemberScope getMemberScope(@NotNull List<? extends TypeProjection> typeArguments) {
            if (typeArguments == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeArguments", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "getMemberScope"));
            }
            MemberScope memberScope2 = ErrorUtils.createErrorScope("Error scope for class " + this.getName() + " with arguments: " + typeArguments);
            if (memberScope2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "getMemberScope"));
            }
            return memberScope2;
        }

        @Override
        @NotNull
        public MemberScope getMemberScope(@NotNull TypeSubstitution typeSubstitution) {
            if (typeSubstitution == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "typeSubstitution", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "getMemberScope"));
            }
            MemberScope memberScope2 = ErrorUtils.createErrorScope("Error scope for class " + this.getName() + " with arguments: " + typeSubstitution);
            if (memberScope2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor", "getMemberScope"));
            }
            return memberScope2;
        }
    }

    private static class ThrowingScope
    implements MemberScope {
        private final String debugMessage;

        private ThrowingScope(@NotNull String message) {
            if (message == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "message", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "<init>"));
            }
            this.debugMessage = message;
        }

        @Override
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedClassifier"));
            }
            if (location == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedClassifier"));
            }
            throw new IllegalStateException();
        }

        @NotNull
        public Collection getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedVariables"));
            }
            if (location == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedVariables"));
            }
            throw new IllegalStateException();
        }

        @NotNull
        public Collection getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedFunctions"));
            }
            if (location == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedFunctions"));
            }
            throw new IllegalStateException();
        }

        @Override
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
            if (kindFilter == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kindFilter", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedDescriptors"));
            }
            if (nameFilter == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "nameFilter", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "getContributedDescriptors"));
            }
            throw new IllegalStateException();
        }

        @Override
        @NotNull
        public Set<Name> getFunctionNames() {
            throw new IllegalStateException();
        }

        @Override
        @NotNull
        public Set<Name> getVariableNames() {
            throw new IllegalStateException();
        }

        public String toString() {
            return "ThrowingScope{" + this.debugMessage + '}';
        }

        @Override
        public void printScopeStructure(@NotNull Printer p) {
            if (p == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "p", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope", "printScopeStructure"));
            }
            p.println(this.getClass().getSimpleName(), ": ", this.debugMessage);
        }
    }

    public static class ErrorScope
    implements MemberScope {
        private final String debugMessage;

        private ErrorScope(@NotNull String debugMessage) {
            if (debugMessage == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "debugMessage", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "<init>"));
            }
            this.debugMessage = debugMessage;
        }

        @Override
        @Nullable
        public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedClassifier"));
            }
            if (location == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedClassifier"));
            }
            return ErrorUtils.createErrorClass(name2.asString());
        }

        @NotNull
        public Set getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedVariables"));
            }
            if (location == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedVariables"));
            }
            Set set = ERROR_PROPERTY_GROUP;
            if (set == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedVariables"));
            }
            return set;
        }

        @NotNull
        public Set getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedFunctions"));
            }
            if (location == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "location", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedFunctions"));
            }
            Set<SimpleFunctionDescriptor> set = Collections.singleton(ErrorUtils.createErrorFunction(this));
            if (set == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedFunctions"));
            }
            return set;
        }

        @Override
        @NotNull
        public Set<Name> getFunctionNames() {
            Set<Name> set = Collections.emptySet();
            if (set == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getFunctionNames"));
            }
            return set;
        }

        @Override
        @NotNull
        public Set<Name> getVariableNames() {
            Set<Name> set = Collections.emptySet();
            if (set == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getVariableNames"));
            }
            return set;
        }

        @Override
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
            if (kindFilter == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kindFilter", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedDescriptors"));
            }
            if (nameFilter == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "nameFilter", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedDescriptors"));
            }
            List<DeclarationDescriptor> list = Collections.emptyList();
            if (list == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "getContributedDescriptors"));
            }
            return list;
        }

        public String toString() {
            return "ErrorScope{" + this.debugMessage + '}';
        }

        @Override
        public void printScopeStructure(@NotNull Printer p) {
            if (p == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "p", "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope", "printScopeStructure"));
            }
            p.println(this.getClass().getSimpleName(), ": ", this.debugMessage);
        }
    }
}

