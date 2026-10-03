/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public final class ConstUtil {
    public static final ConstUtil INSTANCE;

    @JvmStatic
    public static final boolean canBeUsedForConstVal(@NotNull KotlinType type2) {
        Intrinsics.checkParameterIsNotNull(type2, "type");
        return ConstUtilKt.canBeUsedForConstVal(type2);
    }

    private ConstUtil() {
        INSTANCE = this;
    }

    static {
        new ConstUtil();
    }
}

