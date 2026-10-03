/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.KClassImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"jvmName", "", "Lkotlin/reflect/KClass;", "getJvmName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "kotlin-reflection"})
@JvmName(name="KClassesJvm")
public final class KClassesJvm {
    @NotNull
    public static final String getJvmName(@NotNull KClass<?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KClass<?> kClass = $receiver;
        if (kClass == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<out kotlin.Any>");
        }
        String string = ((KClassImpl)kClass).getJClass().getName();
        Intrinsics.checkExpressionValueIsNotNull(string, "(this as KClassImpl).jClass.name");
        return string;
    }
}

