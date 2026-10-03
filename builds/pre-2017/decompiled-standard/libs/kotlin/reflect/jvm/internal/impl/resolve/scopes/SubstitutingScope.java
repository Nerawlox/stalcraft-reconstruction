/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.utils.Printer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SubstitutingScope
implements MemberScope {
    private final TypeSubstitutor substitutor;
    private Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
    private final Lazy _allDescriptors$delegate;
    private final MemberScope workerScope;
    static final /* synthetic */ KProperty[] $$delegatedProperties;

    private final Collection<DeclarationDescriptor> get_allDescriptors() {
        Lazy lazy = this._allDescriptors$delegate;
        SubstitutingScope substitutingScope = this;
        KProperty kProperty = $$delegatedProperties[0];
        return (Collection)lazy.getValue();
    }

    /*
     * WARNING - void declaration
     */
    private final <D extends DeclarationDescriptor> D substitute(D descriptor2) {
        DeclarationDescriptor substituted;
        DeclarationDescriptor declarationDescriptor;
        Map<DeclarationDescriptor, DeclarationDescriptor> $receiver$iv;
        DeclarationDescriptor value$iv;
        if (this.substitutor.isEmpty()) {
            return descriptor2;
        }
        if (this.substitutedDescriptors == null) {
            this.substitutedDescriptors = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map2 = this.substitutedDescriptors;
        if (map2 == null) {
            Intrinsics.throwNpe();
        }
        if ((value$iv = ($receiver$iv = map2).get(descriptor2)) == null) {
            DeclarationDescriptor $receiver$iv2;
            DeclarationDescriptor declarationDescriptor2 = $receiver$iv2 = descriptor2.substitute(this.substitutor);
            if (declarationDescriptor2 == null) {
                AssertionError assertionError;
                AssertionError assertionError2 = assertionError;
                AssertionError assertionError3 = assertionError;
                String string = "We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, " + ("but " + descriptor2 + " substitution fails");
                assertionError2((Object)string);
                throw (Throwable)((Object)assertionError3);
            }
            Intrinsics.checkExpressionValueIsNotNull(declarationDescriptor2, "descriptor.substitute(su\u2026tion fails\"\n            }");
            DeclarationDescriptor answer$iv = declarationDescriptor2;
            $receiver$iv.put(descriptor2, answer$iv);
            declarationDescriptor = answer$iv;
        } else {
            void var3_3;
            declarationDescriptor = var3_3;
        }
        DeclarationDescriptor declarationDescriptor3 = substituted = (DeclarationDescriptor)declarationDescriptor;
        if (declarationDescriptor3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type D");
        }
        return (D)declarationDescriptor3;
    }

    private final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> descriptors) {
        if (this.substitutor.isEmpty()) {
            return descriptors;
        }
        if (descriptors.isEmpty()) {
            return descriptors;
        }
        HashSet<DeclarationDescriptor> result2 = CollectionsKt.newHashSetWithExpectedSize(descriptors.size());
        for (DeclarationDescriptor descriptor2 : descriptors) {
            DeclarationDescriptor substitute = this.substitute(descriptor2);
            result2.add(substitute);
        }
        return result2;
    }

    @Override
    @NotNull
    public Collection<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return this.substitute(this.workerScope.getContributedVariables(name2, location));
    }

    @Override
    @Nullable
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation location) {
        ClassifierDescriptor classifierDescriptor;
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        ClassifierDescriptor classifierDescriptor2 = this.workerScope.getContributedClassifier(name2, location);
        if (classifierDescriptor2 != null) {
            ClassifierDescriptor classifierDescriptor3;
            ClassifierDescriptor it = classifierDescriptor3 = classifierDescriptor2;
            classifierDescriptor = (ClassifierDescriptor)this.substitute((DeclarationDescriptor)it);
        } else {
            classifierDescriptor = null;
        }
        return classifierDescriptor;
    }

    @Override
    @NotNull
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation location) {
        Intrinsics.checkParameterIsNotNull(name2, "name");
        Intrinsics.checkParameterIsNotNull(location, "location");
        return this.substitute(this.workerScope.getContributedFunctions(name2, location));
    }

    @Override
    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter kindFilter, @NotNull Function1<? super Name, Boolean> nameFilter) {
        Intrinsics.checkParameterIsNotNull(kindFilter, "kindFilter");
        Intrinsics.checkParameterIsNotNull(nameFilter, "nameFilter");
        return this.get_allDescriptors();
    }

    @Override
    @NotNull
    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    @Override
    @NotNull
    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    @Override
    public void printScopeStructure(@NotNull Printer p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        p.println(this.getClass().getSimpleName(), " {");
        p.pushIndent();
        p.println("substitutor = ");
        p.pushIndent();
        p.println(this.substitutor);
        p.popIndent();
        p.print("workerScope = ");
        Printer printer = p.withholdIndentOnce();
        Intrinsics.checkExpressionValueIsNotNull(printer, "p.withholdIndentOnce()");
        this.workerScope.printScopeStructure(printer);
        p.popIndent();
        p.println("}");
    }

    public SubstitutingScope(@NotNull MemberScope workerScope, @NotNull TypeSubstitutor givenSubstitutor) {
        Intrinsics.checkParameterIsNotNull(workerScope, "workerScope");
        Intrinsics.checkParameterIsNotNull(givenSubstitutor, "givenSubstitutor");
        this.workerScope = workerScope;
        this.substitutor = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(givenSubstitutor.getSubstitution(), false, 1, null).buildSubstitutor();
        this._allDescriptors$delegate = LazyKt.lazy((Function0)new Function0<Collection<? extends DeclarationDescriptor>>(this){
            final /* synthetic */ SubstitutingScope this$0;

            @NotNull
            public final Collection<DeclarationDescriptor> invoke() {
                return SubstitutingScope.access$substitute(this.this$0, ResolutionScope.DefaultImpls.getContributedDescriptors$default(SubstitutingScope.access$getWorkerScope$p(this.this$0), null, null, 3, null));
            }
            {
                this.this$0 = substitutingScope;
                super(0);
            }
        });
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(SubstitutingScope.class), "_allDescriptors", "get_allDescriptors()Ljava/util/Collection;"))};
    }

    @NotNull
    public static final /* synthetic */ Collection access$substitute(SubstitutingScope $this, @NotNull Collection descriptors) {
        return $this.substitute(descriptors);
    }

    @NotNull
    public static final /* synthetic */ MemberScope access$getWorkerScope$p(SubstitutingScope $this) {
        return $this.workerScope;
    }
}

