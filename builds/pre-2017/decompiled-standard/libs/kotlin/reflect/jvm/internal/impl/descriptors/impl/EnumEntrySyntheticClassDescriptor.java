/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EnumEntrySyntheticClassDescriptor
extends ClassDescriptorBase {
    private final TypeConstructor typeConstructor;
    private final ClassConstructorDescriptor primaryConstructor;
    private final MemberScope scope;
    private final NotNullLazyValue<Set<Name>> enumMemberNames;
    private final Annotations annotations;

    @NotNull
    public static EnumEntrySyntheticClassDescriptor create(@NotNull StorageManager storageManager, @NotNull ClassDescriptor enumClass, @NotNull Name name2, @NotNull NotNullLazyValue<Set<Name>> enumMemberNames2, @NotNull Annotations annotations2, @NotNull SourceElement source) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"));
        }
        if (enumClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumClass", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"));
        }
        if (enumMemberNames2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumMemberNames", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"));
        }
        SimpleType enumType = enumClass.getDefaultType();
        EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor = new EnumEntrySyntheticClassDescriptor(storageManager, enumClass, enumType, name2, enumMemberNames2, annotations2, source);
        if (enumEntrySyntheticClassDescriptor == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "create"));
        }
        return enumEntrySyntheticClassDescriptor;
    }

    private EnumEntrySyntheticClassDescriptor(@NotNull StorageManager storageManager, @NotNull ClassDescriptor containingClass, @NotNull KotlinType supertype, @NotNull Name name2, @NotNull NotNullLazyValue<Set<Name>> enumMemberNames2, @NotNull Annotations annotations2, @NotNull SourceElement source) {
        if (storageManager == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"));
        }
        if (containingClass == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "containingClass", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"));
        }
        if (supertype == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "supertype", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"));
        }
        if (name2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"));
        }
        if (enumMemberNames2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumMemberNames", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"));
        }
        if (annotations2 == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "annotations", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"));
        }
        if (source == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "source", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "<init>"));
        }
        super(storageManager, containingClass, name2, source, false);
        assert (containingClass.getKind() == ClassKind.ENUM_CLASS);
        this.annotations = annotations2;
        this.typeConstructor = new ClassTypeConstructorImpl(this, true, Collections.emptyList(), Collections.singleton(supertype));
        this.scope = new EnumEntryScope(storageManager);
        this.enumMemberNames = enumMemberNames2;
        ClassConstructorDescriptorImpl primaryConstructor2 = DescriptorFactory.createPrimaryConstructorForObject(this, source);
        primaryConstructor2.setReturnType(this.getDefaultType());
        this.primaryConstructor = primaryConstructor2;
    }

    @Override
    @NotNull
    public MemberScope getUnsubstitutedMemberScope() {
        MemberScope memberScope2 = this.scope;
        if (memberScope2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getUnsubstitutedMemberScope"));
        }
        return memberScope2;
    }

    @Override
    @NotNull
    public MemberScope getStaticScope() {
        MemberScope.Empty empty = MemberScope.Empty.INSTANCE;
        if (empty == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getStaticScope"));
        }
        return empty;
    }

    @Override
    @NotNull
    public Collection<ClassConstructorDescriptor> getConstructors() {
        Set<ClassConstructorDescriptor> set = Collections.singleton(this.primaryConstructor);
        if (set == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getConstructors"));
        }
        return set;
    }

    @Override
    @NotNull
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor2 = this.typeConstructor;
        if (typeConstructor2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getTypeConstructor"));
        }
        return typeConstructor2;
    }

    @Override
    @Nullable
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override
    @NotNull
    public ClassKind getKind() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getKind"));
        }
        return classKind;
    }

    @Override
    @NotNull
    public Modality getModality() {
        Modality modality = Modality.FINAL;
        if (modality == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getModality"));
        }
        return modality;
    }

    @Override
    @NotNull
    public Visibility getVisibility() {
        Visibility visibility = Visibilities.PUBLIC;
        if (visibility == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getVisibility"));
        }
        return visibility;
    }

    @Override
    public boolean isInner() {
        return false;
    }

    @Override
    public boolean isData() {
        return false;
    }

    @Override
    public boolean isCompanionObject() {
        return false;
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
    @Nullable
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return this.primaryConstructor;
    }

    @Override
    @NotNull
    public Annotations getAnnotations() {
        Annotations annotations2 = this.annotations;
        if (annotations2 == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getAnnotations"));
        }
        return annotations2;
    }

    public String toString() {
        return "enum entry " + this.getName();
    }

    @Override
    @NotNull
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> list = Collections.emptyList();
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getDeclaredTypeParameters"));
        }
        return list;
    }

    @Override
    @NotNull
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List<ClassDescriptor> list = Collections.emptyList();
        if (list == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor", "getSealedSubclasses"));
        }
        return list;
    }

    private class EnumEntryScope
    extends MemberScopeImpl {
        private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> functions;
        private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> properties;
        private final NotNullLazyValue<Collection<DeclarationDescriptor>> allDescriptors;

        public EnumEntryScope(StorageManager storageManager) {
            if (storageManager == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "storageManager", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "<init>"));
            }
            this.functions = storageManager.createMemoizedFunction(new Function1<Name, Collection<SimpleFunctionDescriptor>>(){

                @Override
                public Collection<SimpleFunctionDescriptor> invoke(Name name2) {
                    return EnumEntryScope.this.computeFunctions(name2);
                }
            });
            this.properties = storageManager.createMemoizedFunction(new Function1<Name, Collection<PropertyDescriptor>>(){

                @Override
                public Collection<PropertyDescriptor> invoke(Name name2) {
                    return EnumEntryScope.this.computeProperties(name2);
                }
            });
            this.allDescriptors = storageManager.createLazyValue(new Function0<Collection<DeclarationDescriptor>>(){

                @Override
                public Collection<DeclarationDescriptor> invoke() {
                    return EnumEntryScope.this.computeAllDeclarations();
                }
            });
        }

        @NotNull
        public Collection getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedVariables"));
            }
            if (location == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "location", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedVariables"));
            }
            Collection collection = (Collection)this.properties.invoke(name2);
            if (collection == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedVariables"));
            }
            return collection;
        }

        @NotNull
        private Collection<PropertyDescriptor> computeProperties(@NotNull Name name2) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "computeProperties"));
            }
            Collection<PropertyDescriptor> collection = this.resolveFakeOverrides(name2, this.getSupertypeScope().getContributedVariables(name2, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
            if (collection == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "computeProperties"));
            }
            return collection;
        }

        @NotNull
        public Collection getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedFunctions"));
            }
            if (location == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "location", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedFunctions"));
            }
            Collection collection = (Collection)this.functions.invoke(name2);
            if (collection == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedFunctions"));
            }
            return collection;
        }

        @NotNull
        private Collection<SimpleFunctionDescriptor> computeFunctions(@NotNull Name name2) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "computeFunctions"));
            }
            Collection<SimpleFunctionDescriptor> collection = this.resolveFakeOverrides(name2, this.getSupertypeScope().getContributedFunctions(name2, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
            if (collection == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "computeFunctions"));
            }
            return collection;
        }

        @NotNull
        private MemberScope getSupertypeScope() {
            Collection<KotlinType> supertype = EnumEntrySyntheticClassDescriptor.this.getTypeConstructor().getSupertypes();
            assert (supertype.size() == 1) : "Enum entry and its companion object both should have exactly one supertype: " + supertype;
            MemberScope memberScope2 = supertype.iterator().next().getMemberScope();
            if (memberScope2 == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getSupertypeScope"));
            }
            return memberScope2;
        }

        @NotNull
        private <D extends CallableMemberDescriptor> Collection<D> resolveFakeOverrides(@NotNull Name name2, @NotNull Collection<D> fromSupertypes) {
            if (name2 == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "resolveFakeOverrides"));
            }
            if (fromSupertypes == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fromSupertypes", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "resolveFakeOverrides"));
            }
            final LinkedHashSet result2 = new LinkedHashSet();
            OverridingUtil.generateOverridesInFunctionGroup(name2, fromSupertypes, Collections.emptySet(), EnumEntrySyntheticClassDescriptor.this, new NonReportingOverrideStrategy(){

                @Override
                public void addFakeOverride(@NotNull CallableMemberDescriptor fakeOverride) {
                    if (fakeOverride == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fakeOverride", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4", "addFakeOverride"));
                    }
                    OverridingUtil.resolveUnknownVisibilityForMember(fakeOverride, null);
                    result2.add(fakeOverride);
                }

                @Override
                protected void conflict(@NotNull CallableMemberDescriptor fromSuper, @NotNull CallableMemberDescriptor fromCurrent) {
                    if (fromSuper == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fromSuper", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4", "conflict"));
                    }
                    if (fromCurrent == null) {
                        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "fromCurrent", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4", "conflict"));
                    }
                }
            });
            LinkedHashSet linkedHashSet = result2;
            if (linkedHashSet == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "resolveFakeOverrides"));
            }
            return linkedHashSet;
        }

        @Override
        @NotNull
        public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
            if (kindFilter == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "kindFilter", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedDescriptors"));
            }
            if (nameFilter == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "nameFilter", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedDescriptors"));
            }
            Collection collection = (Collection)this.allDescriptors.invoke();
            if (collection == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getContributedDescriptors"));
            }
            return collection;
        }

        @NotNull
        private Collection<DeclarationDescriptor> computeAllDeclarations() {
            HashSet<DeclarationDescriptor> result2 = new HashSet<DeclarationDescriptor>();
            for (Name name2 : (Set)EnumEntrySyntheticClassDescriptor.this.enumMemberNames.invoke()) {
                result2.addAll(this.getContributedFunctions(name2, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
                result2.addAll(this.getContributedVariables(name2, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
            }
            HashSet<DeclarationDescriptor> hashSet = result2;
            if (hashSet == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "computeAllDeclarations"));
            }
            return hashSet;
        }

        @Override
        @NotNull
        public Set<Name> getFunctionNames() {
            Set set = (Set)EnumEntrySyntheticClassDescriptor.this.enumMemberNames.invoke();
            if (set == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getFunctionNames"));
            }
            return set;
        }

        @Override
        @NotNull
        public Set<Name> getVariableNames() {
            Set set = (Set)EnumEntrySyntheticClassDescriptor.this.enumMemberNames.invoke();
            if (set == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "getVariableNames"));
            }
            return set;
        }

        @Override
        public void printScopeStructure(@NotNull Printer p) {
            if (p == null) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "p", "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope", "printScopeStructure"));
            }
            p.println("enum entry scope for " + EnumEntrySyntheticClassDescriptor.this);
        }
    }
}

