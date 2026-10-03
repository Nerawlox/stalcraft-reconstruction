/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.LocalVariableReference;
import kotlin.reflect.KProperty0;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=3)
final class AnnotationConstructorCallerKt$createAnnotationInstance$toString$1
extends LocalVariableReference {
    public static final KProperty0 INSTANCE = new AnnotationConstructorCallerKt$createAnnotationInstance$toString$1();

    AnnotationConstructorCallerKt$createAnnotationInstance$toString$1() {
    }

    @Override
    public String getName() {
        return "toString";
    }

    @Override
    public String getSignature() {
        return "<get-toString>()Ljava/lang/String;";
    }
}

