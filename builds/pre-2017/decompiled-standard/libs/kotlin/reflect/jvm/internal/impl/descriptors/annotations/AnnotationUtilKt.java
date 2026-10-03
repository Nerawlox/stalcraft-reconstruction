/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class AnnotationUtilKt {
    private static final FqName INLINE_ONLY_ANNOTATION_FQ_NAME = new FqName("kotlin.internal.InlineOnly");

    @NotNull
    public static final AnnotationDescriptor createDeprecatedAnnotation(@NotNull KotlinBuiltIns $receiver, @NotNull String message, @NotNull String replaceWith, @NotNull String level) {
        AnnotationDescriptorImpl annotationDescriptorImpl;
        EnumValue enumValue;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(replaceWith, "replaceWith");
        Intrinsics.checkParameterIsNotNull(level, "level");
        ClassDescriptor deprecatedAnnotation = $receiver.getDeprecatedAnnotation();
        ClassConstructorDescriptor classConstructorDescriptor = deprecatedAnnotation.getUnsubstitutedPrimaryConstructor();
        if (classConstructorDescriptor == null) {
            Intrinsics.throwNpe();
        }
        List<ValueParameterDescriptor> parameters2 = classConstructorDescriptor.getValueParameters();
        ClassDescriptor replaceWithClass = $receiver.getBuiltInClassByName(Name.identifier("ReplaceWith"));
        ClassConstructorDescriptor classConstructorDescriptor2 = replaceWithClass.getUnsubstitutedPrimaryConstructor();
        if (classConstructorDescriptor2 == null) {
            Intrinsics.throwNpe();
        }
        List<ValueParameterDescriptor> replaceWithParameters = classConstructorDescriptor2.getValueParameters();
        KotlinType kotlinType = deprecatedAnnotation.getDefaultType();
        Pair[] pairArray = new Pair[3];
        pairArray[0] = TuplesKt.to(AnnotationUtilKt.get((Collection<? extends ValueParameterDescriptor>)parameters2, "message"), new StringValue(message, $receiver));
        ValueParameterDescriptor valueParameterDescriptor = AnnotationUtilKt.get((Collection<? extends ValueParameterDescriptor>)parameters2, "replaceWith");
        KotlinType kotlinType2 = replaceWithClass.getDefaultType();
        Pair[] pairArray2 = new Pair[2];
        pairArray2[0] = TuplesKt.to(AnnotationUtilKt.get((Collection<? extends ValueParameterDescriptor>)replaceWithParameters, "expression"), new StringValue(replaceWith, $receiver));
        ValueParameterDescriptor valueParameterDescriptor2 = AnnotationUtilKt.get((Collection<? extends ValueParameterDescriptor>)replaceWithParameters, "imports");
        List list = CollectionsKt.emptyList();
        SimpleType simpleType2 = $receiver.getArrayType(Variance.INVARIANT, $receiver.getStringType());
        Intrinsics.checkExpressionValueIsNotNull(simpleType2, "getArrayType(Variance.INVARIANT, stringType)");
        pairArray2[1] = TuplesKt.to(valueParameterDescriptor2, new ArrayValue(list, simpleType2, $receiver));
        pairArray[1] = TuplesKt.to(valueParameterDescriptor, new AnnotationValue(new AnnotationDescriptorImpl(kotlinType2, MapsKt.mapOf(pairArray2), SourceElement.NO_SOURCE)));
        ValueParameterDescriptor valueParameterDescriptor3 = AnnotationUtilKt.get((Collection<? extends ValueParameterDescriptor>)parameters2, "level");
        ClassDescriptor classDescriptor = $receiver.getDeprecationLevelEnumEntry(level);
        if (classDescriptor == null) {
            String string = "Deprecation level " + level + " not found";
            EnumValue enumValue2 = enumValue;
            EnumValue enumValue3 = enumValue;
            ValueParameterDescriptor valueParameterDescriptor4 = valueParameterDescriptor3;
            int n = 2;
            Pair[] pairArray3 = pairArray;
            Pair[] pairArray4 = pairArray;
            KotlinType kotlinType3 = kotlinType;
            AnnotationDescriptorImpl annotationDescriptorImpl2 = annotationDescriptorImpl;
            AnnotationDescriptorImpl annotationDescriptorImpl3 = annotationDescriptorImpl;
            throw (Throwable)new IllegalStateException(string.toString());
        }
        enumValue = new EnumValue(classDescriptor);
        pairArray[2] = TuplesKt.to(valueParameterDescriptor3, enumValue);
        annotationDescriptorImpl = new AnnotationDescriptorImpl(kotlinType, MapsKt.mapOf(pairArray), SourceElement.NO_SOURCE);
        return annotationDescriptorImpl;
    }

    @NotNull
    public static /* bridge */ /* synthetic */ AnnotationDescriptor createDeprecatedAnnotation$default(KotlinBuiltIns kotlinBuiltIns, String string, String string2, String string3, int n, Object object) {
        if ((n & 2) != 0) {
            string2 = "";
        }
        if ((n & 4) != 0) {
            string3 = "WARNING";
        }
        return AnnotationUtilKt.createDeprecatedAnnotation(kotlinBuiltIns, string, string2, string3);
    }

    @NotNull
    public static final AnnotationDescriptor createUnsafeVarianceAnnotation(@NotNull KotlinBuiltIns $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        ClassDescriptor unsafeVarianceAnnotation = $receiver.getBuiltInClassByFqName(KotlinBuiltIns.FQ_NAMES.unsafeVariance);
        return new AnnotationDescriptorImpl(unsafeVarianceAnnotation.getDefaultType(), MapsKt.<ValueParameterDescriptor, ConstantValue<?>>emptyMap(), SourceElement.NO_SOURCE);
    }

    private static final ValueParameterDescriptor get(@NotNull Collection<? extends ValueParameterDescriptor> $receiver, String parameterName) {
        Iterable $receiver$iv = $receiver;
        Object single$iv = null;
        boolean found$iv = false;
        for (Object element$iv : $receiver$iv) {
            ValueParameterDescriptor it = (ValueParameterDescriptor)element$iv;
            if (!Intrinsics.areEqual(it.getName().asString(), parameterName)) continue;
            if (found$iv) {
                throw (Throwable)new IllegalArgumentException("Collection contains more than one matching element.");
            }
            single$iv = element$iv;
            found$iv = true;
        }
        if (!found$iv) {
            throw (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        return (ValueParameterDescriptor)((Object)single$iv);
    }

    public static final boolean isInlineOnlyOrReifiable(@NotNull MemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        return $receiver instanceof CallableMemberDescriptor && (AnnotationUtilKt.isReifiable((CallableMemberDescriptor)$receiver) || AnnotationUtilKt.isReifiable(DescriptorUtils.getDirectMember((CallableMemberDescriptor)$receiver)) || AnnotationUtilKt.isInlineOnly($receiver));
    }

    public static final boolean isInlineOnly(@NotNull MemberDescriptor $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if (!($receiver instanceof FunctionDescriptor) || !AnnotationUtilKt.hasInlineOnlyAnnotation((CallableMemberDescriptor)$receiver) && !AnnotationUtilKt.hasInlineOnlyAnnotation(DescriptorUtils.getDirectMember((CallableMemberDescriptor)$receiver))) {
            return false;
        }
        boolean bl = ((FunctionDescriptor)$receiver).isInline();
        if (_Assertions.ENABLED && !bl) {
            String string = "Function is not inline: " + $receiver;
            throw (Throwable)((Object)new AssertionError((Object)string));
        }
        return true;
    }

    private static final boolean isReifiable(@NotNull CallableMemberDescriptor $receiver) {
        boolean bl;
        block1: {
            Iterable $receiver$iv = $receiver.getTypeParameters();
            for (Object element$iv : $receiver$iv) {
                TypeParameterDescriptor it = (TypeParameterDescriptor)element$iv;
                if (!it.isReified()) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl;
    }

    private static final boolean hasInlineOnlyAnnotation(@NotNull CallableMemberDescriptor $receiver) {
        return $receiver.getAnnotations().hasAnnotation(INLINE_ONLY_ANNOTATION_FQ_NAME);
    }
}

