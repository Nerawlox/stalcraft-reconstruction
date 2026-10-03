/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorEquivalenceForOverrides {
    public static final DescriptorEquivalenceForOverrides INSTANCE;

    public final boolean areEquivalent(@Nullable DeclarationDescriptor a, @Nullable DeclarationDescriptor b) {
        return a instanceof ClassDescriptor && b instanceof ClassDescriptor ? this.areClassesEquivalent((ClassDescriptor)a, (ClassDescriptor)b) : (a instanceof TypeParameterDescriptor && b instanceof TypeParameterDescriptor ? DescriptorEquivalenceForOverrides.areTypeParametersEquivalent$default(this, (TypeParameterDescriptor)a, (TypeParameterDescriptor)b, null, 4, null) : (a instanceof CallableDescriptor && b instanceof CallableDescriptor ? DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent$default(this, (CallableDescriptor)a, (CallableDescriptor)b, false, 4, null) : (a instanceof PackageFragmentDescriptor && b instanceof PackageFragmentDescriptor ? Intrinsics.areEqual(((PackageFragmentDescriptor)a).getFqName(), ((PackageFragmentDescriptor)b).getFqName()) : Intrinsics.areEqual(a, b))));
    }

    private final boolean areClassesEquivalent(ClassDescriptor a, ClassDescriptor b) {
        return Intrinsics.areEqual(a.getTypeConstructor(), b.getTypeConstructor());
    }

    private final boolean areTypeParametersEquivalent(TypeParameterDescriptor a, TypeParameterDescriptor b, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> equivalentCallables) {
        if (Intrinsics.areEqual(a, b)) {
            return true;
        }
        if (Intrinsics.areEqual(a.getContainingDeclaration(), b.getContainingDeclaration())) {
            return false;
        }
        if (!this.ownersEquivalent(a, b, equivalentCallables)) {
            return false;
        }
        return a.getIndex() == b.getIndex();
    }

    static /* bridge */ /* synthetic */ boolean areTypeParametersEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function2 function2, int n, Object object) {
        if ((n & 4) != 0) {
            function2 = areTypeParametersEquivalent.1.INSTANCE;
        }
        return descriptorEquivalenceForOverrides.areTypeParametersEquivalent(typeParameterDescriptor, typeParameterDescriptor2, function2);
    }

    public final boolean areCallableDescriptorsEquivalent(@NotNull CallableDescriptor a, @NotNull CallableDescriptor b, boolean ignoreReturnType) {
        Intrinsics.checkParameterIsNotNull(a, "a");
        Intrinsics.checkParameterIsNotNull(b, "b");
        if (Intrinsics.areEqual(a, b)) {
            return true;
        }
        if (Intrinsics.areEqual(a.getName(), b.getName()) ^ true) {
            return false;
        }
        if (Intrinsics.areEqual(a.getContainingDeclaration(), b.getContainingDeclaration())) {
            return false;
        }
        if (DescriptorUtils.isLocal(a) || DescriptorUtils.isLocal(b)) {
            return false;
        }
        if (!this.ownersEquivalent(a, b, areCallableDescriptorsEquivalent.1.INSTANCE)) {
            return false;
        }
        OverridingUtil overridingUtil2 = OverridingUtil.createWithEqualityAxioms(new KotlinTypeChecker.TypeConstructorEquality(a, b){
            final /* synthetic */ CallableDescriptor $a;
            final /* synthetic */ CallableDescriptor $b;

            public final boolean invoke(@NotNull TypeConstructor c1, @NotNull TypeConstructor c2) {
                Intrinsics.checkParameterIsNotNull(c1, "c1");
                Intrinsics.checkParameterIsNotNull(c2, "c2");
                if (Intrinsics.areEqual(c1, c2)) {
                    return true;
                }
                ClassifierDescriptor d1 = c1.getDeclarationDescriptor();
                ClassifierDescriptor d2 = c2.getDeclarationDescriptor();
                if (!(d1 instanceof TypeParameterDescriptor) || !(d2 instanceof TypeParameterDescriptor)) {
                    return false;
                }
                return DescriptorEquivalenceForOverrides.access$areTypeParametersEquivalent(DescriptorEquivalenceForOverrides.INSTANCE, (TypeParameterDescriptor)d1, (TypeParameterDescriptor)d2, new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>(this){
                    final /* synthetic */ areCallableDescriptorsEquivalent.overridingUtil.1 this$0;

                    public final boolean invoke(@Nullable DeclarationDescriptor x, @Nullable DeclarationDescriptor y) {
                        return Intrinsics.areEqual(x, this.this$0.$a) && Intrinsics.areEqual(y, this.this$0.$b);
                    }
                    {
                        this.this$0 = var1_1;
                        super(2);
                    }
                });
            }
            {
                this.$a = callableDescriptor;
                this.$b = callableDescriptor2;
            }
        });
        return Intrinsics.areEqual((Object)overridingUtil2.isOverridableBy(a, b, null, !ignoreReturnType).getResult(), (Object)OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) && Intrinsics.areEqual((Object)overridingUtil2.isOverridableBy(b, a, null, !ignoreReturnType).getResult(), (Object)OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE);
    }

    public static /* bridge */ /* synthetic */ boolean areCallableDescriptorsEquivalent$default(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        return descriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent(callableDescriptor, callableDescriptor2, bl);
    }

    private final boolean ownersEquivalent(DeclarationDescriptor a, DeclarationDescriptor b, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> equivalentCallables) {
        DeclarationDescriptor aOwner = a.getContainingDeclaration();
        DeclarationDescriptor bOwner = b.getContainingDeclaration();
        if (aOwner instanceof CallableMemberDescriptor || bOwner instanceof CallableMemberDescriptor) {
            return equivalentCallables.invoke(aOwner, bOwner);
        }
        return this.areEquivalent(aOwner, bOwner);
    }

    private DescriptorEquivalenceForOverrides() {
        INSTANCE = this;
    }

    static {
        new DescriptorEquivalenceForOverrides();
    }

    public static final /* synthetic */ boolean access$areTypeParametersEquivalent(DescriptorEquivalenceForOverrides $this, @NotNull TypeParameterDescriptor a, @NotNull TypeParameterDescriptor b, @NotNull Function2 equivalentCallables) {
        return $this.areTypeParametersEquivalent(a, b, equivalentCallables);
    }
}

