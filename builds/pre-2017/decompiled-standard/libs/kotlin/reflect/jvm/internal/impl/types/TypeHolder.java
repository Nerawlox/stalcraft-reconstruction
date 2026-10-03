/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeHolderArgument;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface TypeHolder<D extends TypeHolder<? extends D>> {
    @NotNull
    public KotlinType getType();

    @NotNull
    public List<TypeHolderArgument<D>> getArguments();

    @Nullable
    public Pair<D, D> getFlexibleBounds();

    public static final class DefaultImpls {
        @Nullable
        public static <D extends TypeHolder<? extends D>> Pair<D, D> getFlexibleBounds(TypeHolder<? extends D> $this) {
            return null;
        }
    }
}

