/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.TypeHolder;
import kotlin.reflect.jvm.internal.impl.types.TypeHolderArgument;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.VarianceCheckerKt;
import kotlin.reflect.jvm.internal.impl.types.VarianceCheckerKt$WhenMappings;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckingProcedure;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import org.jetbrains.annotations.NotNull;

public final class VarianceCheckerKt {
    public static final <D extends TypeHolder<? extends D>> boolean checkTypePosition(@NotNull D $receiver, @NotNull Variance position, @NotNull Function3<? super TypeParameterDescriptor, ? super D, ? super Variance, Unit> reportError, @NotNull Function1<? super TypeParameterDescriptor, ? extends Variance> customVariance) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull((Object)position, "position");
        Intrinsics.checkParameterIsNotNull(reportError, "reportError");
        Intrinsics.checkParameterIsNotNull(customVariance, "customVariance");
        Pair<D, D> pair = $receiver.getFlexibleBounds();
        if (pair != null) {
            Pair<D, D> pair2;
            Pair<D, D> it = pair2 = pair;
            return VarianceCheckerKt.checkTypePosition((TypeHolder)it.getFirst(), position, reportError, customVariance) & VarianceCheckerKt.checkTypePosition((TypeHolder)it.getSecond(), position, reportError, customVariance);
        }
        ClassifierDescriptor classifierDescriptor = $receiver.getType().getConstructor().getDeclarationDescriptor();
        if (classifierDescriptor instanceof TypeParameterDescriptor) {
            Variance variance = customVariance.invoke((TypeParameterDescriptor)classifierDescriptor);
            if (variance == null) {
                Variance variance2 = ((TypeParameterDescriptor)classifierDescriptor).getVariance();
                variance = variance2;
                Intrinsics.checkExpressionValueIsNotNull((Object)variance2, "classifierDescriptor.variance");
            }
            Variance declarationVariance = variance;
            if (!declarationVariance.allowsPosition(position)) {
                Annotations annotations2 = $receiver.getType().getAnnotations();
                FqName fqName2 = KotlinBuiltIns.FQ_NAMES.unsafeVariance;
                Intrinsics.checkExpressionValueIsNotNull(fqName2, "org.jetbrains.kotlin.bui\u2026s.FQ_NAMES.unsafeVariance");
                if (!annotations2.hasAnnotation(fqName2)) {
                    reportError.invoke((TypeParameterDescriptor)classifierDescriptor, $receiver, position);
                }
            }
            return declarationVariance.allowsPosition(position);
        }
        boolean noError = true;
        for (TypeHolderArgument<D> argument : $receiver.getArguments()) {
            Variance newPosition;
            Variance variance;
            TypeCheckingProcedure.EnrichedProjectionKind projectionKind;
            if (argument == null || argument.getTypeParameter() == null || argument.getProjection().isStarProjection()) continue;
            TypeParameterDescriptor typeParameterDescriptor = argument.getTypeParameter();
            if (typeParameterDescriptor == null) {
                Intrinsics.throwNpe();
            }
            if (TypeCheckingProcedure.getEffectiveProjectionKind(typeParameterDescriptor, argument.getProjection()) == null) {
                Intrinsics.throwNpe();
            }
            switch (VarianceCheckerKt$WhenMappings.$EnumSwitchMapping$0[projectionKind.ordinal()]) {
                case 1: {
                    variance = position;
                    break;
                }
                case 2: {
                    variance = position.opposite();
                    break;
                }
                case 3: {
                    variance = Variance.INVARIANT;
                    break;
                }
                case 4: {
                    variance = null;
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            if ((newPosition = variance) == null) continue;
            noError &= VarianceCheckerKt.checkTypePosition(argument.getHolder(), newPosition, reportError, customVariance);
        }
        return noError;
    }

    public static /* bridge */ /* synthetic */ boolean checkTypePosition$default(TypeHolder typeHolder, Variance variance, Function3 function3, Function1 function1, int n, Object object) {
        if ((n & 2) != 0) {
            function3 = FunctionsKt.getDO_NOTHING_3();
        }
        if ((n & 4) != 0) {
            function1 = checkTypePosition.1.INSTANCE;
        }
        return VarianceCheckerKt.checkTypePosition(typeHolder, variance, function3, function1);
    }
}

