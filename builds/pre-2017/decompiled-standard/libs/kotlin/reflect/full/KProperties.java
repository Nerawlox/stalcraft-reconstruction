/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0007\u001a/\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0003*\u0010\u0012\u0004\u0012\u0002H\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\u0007\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2={"getExtensionDelegate", "", "Lkotlin/reflect/KProperty1;", "D", "Lkotlin/reflect/KProperty2;", "receiver", "(Lkotlin/reflect/KProperty2;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"})
@JvmName(name="KProperties")
public final class KProperties {
    @SinceKotlin(version="1.1")
    @Nullable
    public static final Object getExtensionDelegate(@NotNull KProperty1<?, ?> $receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KProperty1<?, ?> kProperty1 = $receiver;
        if (kProperty1 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Any?, *>");
        }
        return kProperty1.getDelegate(KPropertyImpl.Companion.getEXTENSION_PROPERTY_DELEGATE());
    }

    @SinceKotlin(version="1.1")
    @Nullable
    public static final <D> Object getExtensionDelegate(@NotNull KProperty2<D, ?, ?> $receiver, D receiver) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        KProperty2<D, ?, ?> kProperty2 = $receiver;
        if (kProperty2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KProperty2<D, kotlin.Any?, *>");
        }
        return kProperty2.getDelegate(receiver, KPropertyImpl.Companion.getEXTENSION_PROPERTY_DELEGATE());
    }
}

