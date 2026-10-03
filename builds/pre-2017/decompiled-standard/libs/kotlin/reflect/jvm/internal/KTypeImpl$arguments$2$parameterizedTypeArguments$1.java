/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.LocalVariableReference;
import kotlin.reflect.KProperty0;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=3)
final class KTypeImpl$arguments$2$parameterizedTypeArguments$1
extends LocalVariableReference {
    public static final KProperty0 INSTANCE = new KTypeImpl$arguments$2$parameterizedTypeArguments$1();

    KTypeImpl$arguments$2$parameterizedTypeArguments$1() {
    }

    @Override
    public String getName() {
        return "parameterizedTypeArguments";
    }

    @Override
    public String getSignature() {
        return "<get-parameterizedTypeArguments>()Ljava/util/List;";
    }
}

