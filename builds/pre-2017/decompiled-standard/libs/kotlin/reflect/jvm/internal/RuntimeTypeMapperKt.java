/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.RuntimeTypeMapperKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"})
public final class RuntimeTypeMapperKt {
    private static final String getSignature(@NotNull Method $receiver) {
        return $receiver.getName() + ArraysKt.joinToString$default($receiver.getParameterTypes(), (CharSequence)"", (CharSequence)"(", (CharSequence)")", 0, null, (Function1)signature.1.INSTANCE, 24, null) + ReflectClassUtilKt.getDesc($receiver.getReturnType());
    }

    @NotNull
    public static final /* synthetic */ String access$getSignature$p(@NotNull Method $receiver) {
        return RuntimeTypeMapperKt.getSignature($receiver);
    }
}

