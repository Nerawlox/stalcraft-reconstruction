/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AnnotationUseSiteTarget
extends Enum<AnnotationUseSiteTarget> {
    public static final /* enum */ AnnotationUseSiteTarget FIELD;
    public static final /* enum */ AnnotationUseSiteTarget FILE;
    public static final /* enum */ AnnotationUseSiteTarget PROPERTY;
    public static final /* enum */ AnnotationUseSiteTarget PROPERTY_GETTER;
    public static final /* enum */ AnnotationUseSiteTarget PROPERTY_SETTER;
    public static final /* enum */ AnnotationUseSiteTarget RECEIVER;
    public static final /* enum */ AnnotationUseSiteTarget CONSTRUCTOR_PARAMETER;
    public static final /* enum */ AnnotationUseSiteTarget SETTER_PARAMETER;
    public static final /* enum */ AnnotationUseSiteTarget PROPERTY_DELEGATE_FIELD;
    private static final /* synthetic */ AnnotationUseSiteTarget[] $VALUES;
    @NotNull
    private final String renderName;
    public static final Companion Companion;

    static {
        AnnotationUseSiteTarget[] annotationUseSiteTargetArray = new AnnotationUseSiteTarget[9];
        AnnotationUseSiteTarget[] annotationUseSiteTargetArray2 = annotationUseSiteTargetArray;
        annotationUseSiteTargetArray[0] = FIELD = new AnnotationUseSiteTarget("FIELD", 0, null, 1, null);
        annotationUseSiteTargetArray[1] = FILE = new AnnotationUseSiteTarget("FILE", 1, null, 1, null);
        annotationUseSiteTargetArray[2] = PROPERTY = new AnnotationUseSiteTarget("PROPERTY", 2, null, 1, null);
        annotationUseSiteTargetArray[3] = PROPERTY_GETTER = new AnnotationUseSiteTarget("get");
        annotationUseSiteTargetArray[4] = PROPERTY_SETTER = new AnnotationUseSiteTarget("set");
        annotationUseSiteTargetArray[5] = RECEIVER = new AnnotationUseSiteTarget("RECEIVER", 5, null, 1, null);
        annotationUseSiteTargetArray[6] = CONSTRUCTOR_PARAMETER = new AnnotationUseSiteTarget("param");
        annotationUseSiteTargetArray[7] = SETTER_PARAMETER = new AnnotationUseSiteTarget("setparam");
        annotationUseSiteTargetArray[8] = PROPERTY_DELEGATE_FIELD = new AnnotationUseSiteTarget("delegate");
        $VALUES = annotationUseSiteTargetArray;
        Companion = new Companion(null);
    }

    @NotNull
    public final String getRenderName() {
        return this.renderName;
    }

    protected AnnotationUseSiteTarget(String renderName) {
        AnnotationUseSiteTarget annotationUseSiteTarget = this;
        String string = renderName;
        if (string == null) {
            String string2 = this.name();
            AnnotationUseSiteTarget annotationUseSiteTarget2 = annotationUseSiteTarget;
            String string3 = string2;
            if (string3 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String string4 = string3.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(string4, "(this as java.lang.String).toLowerCase()");
            String string5 = string4;
            annotationUseSiteTarget = annotationUseSiteTarget2;
            string = string5;
        }
        annotationUseSiteTarget.renderName = string;
    }

    /* synthetic */ AnnotationUseSiteTarget(String string, int n, String string2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            string2 = null;
        }
        this(string2);
    }

    public static AnnotationUseSiteTarget[] values() {
        return (AnnotationUseSiteTarget[])$VALUES.clone();
    }

    public static AnnotationUseSiteTarget valueOf(String string) {
        return Enum.valueOf(AnnotationUseSiteTarget.class, string);
    }

    public static final class Companion {
        @Nullable
        public final AnnotationUseSiteTarget getAssociatedUseSiteTarget(@NotNull DeclarationDescriptor descriptor2) {
            Intrinsics.checkParameterIsNotNull(descriptor2, "descriptor");
            DeclarationDescriptor declarationDescriptor = descriptor2;
            return declarationDescriptor instanceof PropertyDescriptor ? PROPERTY : (declarationDescriptor instanceof ValueParameterDescriptor ? CONSTRUCTOR_PARAMETER : (declarationDescriptor instanceof PropertyGetterDescriptor ? PROPERTY_GETTER : (declarationDescriptor instanceof PropertySetterDescriptor ? PROPERTY_SETTER : null)));
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

