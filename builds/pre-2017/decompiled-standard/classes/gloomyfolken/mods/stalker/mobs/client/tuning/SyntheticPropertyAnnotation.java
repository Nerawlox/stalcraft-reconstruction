/*
 * Decompiled with CFR 0.152.
 */
package gloomyfolken.mods.stalker.mobs.client.tuning;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u0011"}, d2={"Lgloomyfolken/mods/stalker/mobs/client/tuning/SyntheticPropertyAnnotation;", "", "name", "", "min", "max", "show", "", "special", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getMax", "()Ljava/lang/String;", "getMin", "getName", "getShow", "()Z", "getSpecial", "minecraft"})
public final class SyntheticPropertyAnnotation {
    @NotNull
    private final String name;
    @NotNull
    private final String min;
    @NotNull
    private final String max;
    private final boolean show;
    @NotNull
    private final String special;

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getMin() {
        return this.min;
    }

    @NotNull
    public final String getMax() {
        return this.max;
    }

    public final boolean getShow() {
        return this.show;
    }

    @NotNull
    public final String getSpecial() {
        return this.special;
    }

    public SyntheticPropertyAnnotation(@NotNull String string, @NotNull String string2, @NotNull String string3, boolean bl, @NotNull String string4) {
        Intrinsics.checkParameterIsNotNull(string, "name");
        Intrinsics.checkParameterIsNotNull(string2, "min");
        Intrinsics.checkParameterIsNotNull(string3, "max");
        Intrinsics.checkParameterIsNotNull(string4, "special");
        this.name = string;
        this.min = string2;
        this.max = string3;
        this.show = bl;
        this.special = string4;
    }
}

