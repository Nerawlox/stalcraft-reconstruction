/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.full;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 5}, bv={1, 0, 1}, k=2, d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0001H\u0007\u00a8\u0006\u0007"}, d2={"isSubtypeOf", "", "Lkotlin/reflect/KType;", "other", "isSupertypeOf", "withNullability", "nullable", "kotlin-reflection"})
@JvmName(name="KTypes")
public final class KTypes {
    @SinceKotlin(version="1.1")
    @NotNull
    public static final KType withNullability(@NotNull KType $receiver, boolean nullable) {
        KType kType;
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        if ($receiver.isMarkedNullable()) {
            KType kType2;
            if (nullable) {
                kType2 = $receiver;
            } else {
                KType kType3 = $receiver;
                if (kType3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                }
                KotlinType kotlinType = TypeUtils.makeNotNullable(((KTypeImpl)kType3).getType());
                Intrinsics.checkExpressionValueIsNotNull(kotlinType, "TypeUtils.makeNotNullabl\u2026(this as KTypeImpl).type)");
                kType2 = new KTypeImpl(kotlinType, (Function0<? extends Type>)new Function0<Type>($receiver){
                    final /* synthetic */ KType receiver$0;

                    @NotNull
                    public final Type invoke() {
                        return ((KTypeImpl)this.receiver$0).getJavaType$kotlin_reflection();
                    }
                    {
                        this.receiver$0 = kType;
                        super(0);
                    }
                });
            }
            return kType2;
        }
        KType kType4 = $receiver;
        if (kType4 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        }
        KotlinType kotlinType = ((KTypeImpl)kType4).getType();
        if (FlexibleTypesKt.isFlexible(kotlinType)) {
            KotlinType kotlinType2 = TypeUtils.makeNullableAsSpecified(kotlinType, nullable);
            Intrinsics.checkExpressionValueIsNotNull(kotlinType2, "TypeUtils.makeNullableAs\u2026ied(kotlinType, nullable)");
            return new KTypeImpl(kotlinType2, (Function0<? extends Type>)new Function0<Type>($receiver){
                final /* synthetic */ KType receiver$0;

                @NotNull
                public final Type invoke() {
                    return ((KTypeImpl)this.receiver$0).getJavaType$kotlin_reflection();
                }
                {
                    this.receiver$0 = kType;
                    super(0);
                }
            });
        }
        if (!nullable) {
            kType = $receiver;
        } else {
            KotlinType kotlinType3 = TypeUtils.makeNullable(kotlinType);
            Intrinsics.checkExpressionValueIsNotNull(kotlinType3, "TypeUtils.makeNullable(kotlinType)");
            kType = new KTypeImpl(kotlinType3, (Function0<? extends Type>)new Function0<Type>($receiver){
                final /* synthetic */ KType receiver$0;

                @NotNull
                public final Type invoke() {
                    return ((KTypeImpl)this.receiver$0).getJavaType$kotlin_reflection();
                }
                {
                    this.receiver$0 = kType;
                    super(0);
                }
            });
        }
        return kType;
    }

    @SinceKotlin(version="1.1")
    public static final boolean isSubtypeOf(@NotNull KType $receiver, @NotNull KType other) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(other, "other");
        KType kType = $receiver;
        if (kType == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        }
        KType kType2 = other;
        if (kType2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
        }
        return TypeUtilsKt.isSubtypeOf(((KTypeImpl)kType).getType(), ((KTypeImpl)kType2).getType());
    }

    @SinceKotlin(version="1.1")
    public static final boolean isSupertypeOf(@NotNull KType $receiver, @NotNull KType other) {
        Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return KTypes.isSubtypeOf(other, $receiver);
    }
}

