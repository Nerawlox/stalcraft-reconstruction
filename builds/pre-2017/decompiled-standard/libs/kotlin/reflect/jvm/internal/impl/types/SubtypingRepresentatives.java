/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

public interface SubtypingRepresentatives {
    @NotNull
    public KotlinType getSubTypeRepresentative();

    @NotNull
    public KotlinType getSuperTypeRepresentative();

    public boolean sameTypeConstructor(@NotNull KotlinType var1);
}

