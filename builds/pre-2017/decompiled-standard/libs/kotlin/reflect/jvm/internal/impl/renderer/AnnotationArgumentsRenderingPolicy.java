/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class AnnotationArgumentsRenderingPolicy
extends Enum<AnnotationArgumentsRenderingPolicy> {
    public static final /* enum */ AnnotationArgumentsRenderingPolicy NO_ARGUMENTS;
    public static final /* enum */ AnnotationArgumentsRenderingPolicy UNLESS_EMPTY;
    public static final /* enum */ AnnotationArgumentsRenderingPolicy ALWAYS_PARENTHESIZED;
    private static final /* synthetic */ AnnotationArgumentsRenderingPolicy[] $VALUES;
    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;

    static {
        AnnotationArgumentsRenderingPolicy[] annotationArgumentsRenderingPolicyArray = new AnnotationArgumentsRenderingPolicy[3];
        AnnotationArgumentsRenderingPolicy[] annotationArgumentsRenderingPolicyArray2 = annotationArgumentsRenderingPolicyArray;
        annotationArgumentsRenderingPolicyArray[0] = NO_ARGUMENTS = new AnnotationArgumentsRenderingPolicy("NO_ARGUMENTS", 0, false, false, 3, null);
        annotationArgumentsRenderingPolicyArray[1] = UNLESS_EMPTY = new AnnotationArgumentsRenderingPolicy("UNLESS_EMPTY", 1, true, false, 2, null);
        annotationArgumentsRenderingPolicyArray[2] = ALWAYS_PARENTHESIZED = new AnnotationArgumentsRenderingPolicy(true, true);
        $VALUES = annotationArgumentsRenderingPolicyArray;
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }

    protected AnnotationArgumentsRenderingPolicy(boolean includeAnnotationArguments, boolean includeEmptyAnnotationArguments) {
        this.includeAnnotationArguments = includeAnnotationArguments;
        this.includeEmptyAnnotationArguments = includeEmptyAnnotationArguments;
    }

    /* synthetic */ AnnotationArgumentsRenderingPolicy(String string, int n, boolean bl, boolean bl2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            bl = false;
        }
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        this(bl, bl2);
    }

    public static AnnotationArgumentsRenderingPolicy[] values() {
        return (AnnotationArgumentsRenderingPolicy[])$VALUES.clone();
    }

    public static AnnotationArgumentsRenderingPolicy valueOf(String string) {
        return Enum.valueOf(AnnotationArgumentsRenderingPolicy.class, string);
    }
}

