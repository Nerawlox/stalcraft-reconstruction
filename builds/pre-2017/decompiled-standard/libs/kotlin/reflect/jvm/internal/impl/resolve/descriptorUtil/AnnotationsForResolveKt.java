/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.AnnotationsWithOnly;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class AnnotationsForResolveKt {
    private static final FqName NO_INFER_ANNOTATION_FQ_NAME = new FqName("kotlin.internal.NoInfer");
    private static final FqName EXACT_ANNOTATION_FQ_NAME = new FqName("kotlin.internal.Exact");
    private static final FqName LOW_PRIORITY_IN_OVERLOAD_RESOLUTION_FQ_NAME = new FqName("kotlin.internal.LowPriorityInOverloadResolution");
    private static final FqName HIDES_MEMBERS_ANNOTATION_FQ_NAME = new FqName("kotlin.internal.HidesMembers");
    private static final FqName ONLY_INPUT_TYPES_FQ_NAME = new FqName("kotlin.internal.OnlyInputTypes");
    private static final FqName DYNAMIC_EXTENSION_FQ_NAME = new FqName("kotlin.internal.DynamicExtension");
    private static final FqName RESTRICTS_SUSPENSION_FQ_NAME = DescriptorUtils.COROUTINES_PACKAGE_FQ_NAME.child(Name.identifier("RestrictsSuspension"));
    @NotNull
    private static final Set<Name> HIDES_MEMBERS_NAME_LIST = SetsKt.setOf(Name.identifier("forEach"));

    @NotNull
    public static final Set<Name> getHIDES_MEMBERS_NAME_LIST() {
        return HIDES_MEMBERS_NAME_LIST;
    }

    public static final boolean hasNoInferAnnotation(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.getAnnotations().hasAnnotation(NO_INFER_ANNOTATION_FQ_NAME);
    }

    public static final boolean hasExactAnnotation(@NotNull KotlinType $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.getAnnotations().hasAnnotation(EXACT_ANNOTATION_FQ_NAME);
    }

    public static final boolean hasInternalAnnotationForResolve(@NotNull Annotations $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.hasAnnotation(NO_INFER_ANNOTATION_FQ_NAME) || $receiver.hasAnnotation(EXACT_ANNOTATION_FQ_NAME);
    }

    public static final boolean isInternalAnnotationForResolve(@NotNull FqName $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return Intrinsics.areEqual($receiver, NO_INFER_ANNOTATION_FQ_NAME) || Intrinsics.areEqual($receiver, EXACT_ANNOTATION_FQ_NAME);
    }

    public static final boolean hasLowPriorityInOverloadResolution(@NotNull CallableDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.getAnnotations().hasAnnotation(LOW_PRIORITY_IN_OVERLOAD_RESOLUTION_FQ_NAME);
    }

    public static final boolean hasHidesMembersAnnotation(@NotNull CallableDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.getAnnotations().hasAnnotation(HIDES_MEMBERS_ANNOTATION_FQ_NAME);
    }

    public static final boolean hasDynamicExtensionAnnotation(@NotNull CallableDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.getAnnotations().hasAnnotation(DYNAMIC_EXTENSION_FQ_NAME);
    }

    public static final boolean hasRestrictsSuspensionAnnotation(@NotNull ClassifierDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Annotations annotations2 = $receiver.getAnnotations();
        FqName fqName2 = RESTRICTS_SUSPENSION_FQ_NAME;
        Intrinsics.checkExpressionValueIsNotNull(fqName2, "RESTRICTS_SUSPENSION_FQ_NAME");
        return annotations2.hasAnnotation(fqName2);
    }

    public static final boolean hasOnlyInputTypesAnnotation(@NotNull TypeParameterDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver.getAnnotations().hasAnnotation(ONLY_INPUT_TYPES_FQ_NAME);
    }

    @NotNull
    public static final Annotations getExactInAnnotations() {
        return new AnnotationsWithOnly(EXACT_ANNOTATION_FQ_NAME);
    }
}

