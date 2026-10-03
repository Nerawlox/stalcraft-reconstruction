/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition$WhenMappings;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ErasedOverridabilityCondition
implements ExternalOverridabilityCondition {
    @Override
    @NotNull
    public ExternalOverridabilityCondition.Result isOverridable(@NotNull CallableDescriptor superDescriptor, @NotNull CallableDescriptor subDescriptor, @Nullable ClassDescriptor subClassDescriptor) {
        ExternalOverridabilityCondition.Result result2;
        boolean bl;
        Object object;
        block11: {
            Sequence<KotlinType> signatureTypes2;
            OverridingUtil.OverrideCompatibilityInfo.Result basicOverridability;
            Collection collection;
            Intrinsics.checkParameterIsNotNull(superDescriptor, "superDescriptor");
            Intrinsics.checkParameterIsNotNull(subDescriptor, "subDescriptor");
            if (!(subDescriptor instanceof JavaMethodDescriptor) || !(collection = (Collection)((JavaMethodDescriptor)subDescriptor).getTypeParameters()).isEmpty()) {
                return ExternalOverridabilityCondition.Result.UNKNOWN;
            }
            OverridingUtil.OverrideCompatibilityInfo overrideCompatibilityInfo = OverridingUtil.getBasicOverridabilityProblem(superDescriptor, subDescriptor);
            OverridingUtil.OverrideCompatibilityInfo.Result result3 = basicOverridability = overrideCompatibilityInfo != null ? overrideCompatibilityInfo.getResult() : null;
            if (basicOverridability != null) {
                return ExternalOverridabilityCondition.Result.UNKNOWN;
            }
            Sequence sequence = SequencesKt.map(CollectionsKt.asSequence((Iterable)((JavaMethodDescriptor)subDescriptor).getValueParameters()), isOverridable.signatureTypes.1.INSTANCE);
            KotlinType kotlinType = ((JavaMethodDescriptor)subDescriptor).getReturnType();
            if (kotlinType == null) {
                Intrinsics.throwNpe();
            }
            ReceiverParameterDescriptor receiverParameterDescriptor = ((JavaMethodDescriptor)subDescriptor).getExtensionReceiverParameter();
            Sequence<KotlinType> $receiver$iv = signatureTypes2 = SequencesKt.plus(SequencesKt.plus(sequence, kotlinType), (Iterable)kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.singletonOrEmptyList(receiverParameterDescriptor != null ? receiverParameterDescriptor.getType() : null));
            object = $receiver$iv.iterator();
            while (object.hasNext()) {
                KotlinType element$iv = object.next();
                KotlinType it = element$iv;
                Collection collection2 = it.getArguments();
                if (!(!collection2.isEmpty() && !(it.unwrap() instanceof RawTypeImpl))) continue;
                bl = true;
                break block11;
            }
            bl = false;
        }
        if (bl) {
            return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        CallableDescriptor callableDescriptor = superDescriptor.substitute(RawSubstitution.INSTANCE.buildSubstitutor());
        if (callableDescriptor == null) {
            return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        CallableDescriptor erasedSuper = callableDescriptor;
        if (erasedSuper instanceof SimpleFunctionDescriptor && !(object = (Collection)((SimpleFunctionDescriptor)erasedSuper).getTypeParameters()).isEmpty()) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = ((SimpleFunctionDescriptor)erasedSuper).newCopyBuilder().setTypeParameters(CollectionsKt.<TypeParameterDescriptor>emptyList()).build();
            if (simpleFunctionDescriptor == null) {
                Intrinsics.throwNpe();
            }
            erasedSuper = simpleFunctionDescriptor;
        }
        OverridingUtil.OverrideCompatibilityInfo.Result overridabilityResult = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).getResult();
        switch (ErasedOverridabilityCondition$WhenMappings.$EnumSwitchMapping$0[overridabilityResult.ordinal()]) {
            case 1: {
                result2 = ExternalOverridabilityCondition.Result.OVERRIDABLE;
                break;
            }
            default: {
                result2 = ExternalOverridabilityCondition.Result.UNKNOWN;
            }
        }
        return result2;
    }

    @Override
    @NotNull
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
    }
}

