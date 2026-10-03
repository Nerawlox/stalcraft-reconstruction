/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class ReflectKotlinClassFinderKt {
    private static final String toRuntimeFqName(@NotNull ClassId $receiver) {
        String className = StringsKt.replace$default($receiver.getRelativeClassName().asString(), '.', '$', false, 4, null);
        return $receiver.getPackageFqName().isRoot() ? className : $receiver.getPackageFqName() + "." + className;
    }

    @NotNull
    public static final /* synthetic */ String access$toRuntimeFqName(@NotNull ClassId $receiver) {
        return ReflectKotlinClassFinderKt.toRuntimeFqName($receiver);
    }
}

