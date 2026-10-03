/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BinaryVersion {
    private final int major;
    private final int minor;
    private final int patch;
    @NotNull
    private final List<Integer> rest;
    @NotNull
    private final int[] numbers;
    private static final int UNKNOWN = -1;
    public static final Companion Companion = new Companion(null);

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    @NotNull
    public final List<Integer> getRest() {
        return this.rest;
    }

    public abstract boolean isCompatible();

    @NotNull
    public final int[] toArray() {
        return this.numbers;
    }

    protected final boolean isCompatibleTo(@NotNull BinaryVersion ourVersion) {
        Intrinsics.checkParameterIsNotNull(ourVersion, "ourVersion");
        return this.major == 0 ? ourVersion.major == 0 && this.minor == ourVersion.minor : this.major == ourVersion.major && this.minor <= ourVersion.minor;
    }

    @NotNull
    public String toString() {
        int item$iv;
        int it;
        int[] $receiver$iv = this.toArray();
        ArrayList<Integer> list$iv = new ArrayList<Integer>();
        for (int i = 0; i < $receiver$iv.length && (it = (item$iv = $receiver$iv[i])) != BinaryVersion.Companion.getUNKNOWN(); ++i) {
            list$iv.add(item$iv);
        }
        List versions = list$iv;
        return versions.isEmpty() ? "unknown" : CollectionsKt.joinToString$default(versions, ".", null, null, 0, null, null, 62, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(@Nullable Object other) {
        Object object = other;
        if (!Intrinsics.areEqual(this.getClass(), object != null ? object.getClass() : null)) return false;
        Object object2 = other;
        if (object2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.BinaryVersion");
        }
        if (this.major != ((BinaryVersion)object2).major) return false;
        if (this.minor != ((BinaryVersion)other).minor) return false;
        if (this.patch != ((BinaryVersion)other).patch) return false;
        if (!Intrinsics.areEqual(this.rest, ((BinaryVersion)other).rest)) return false;
        return true;
    }

    public int hashCode() {
        int result2 = this.major;
        result2 += 31 * result2 + this.minor;
        result2 += 31 * result2 + this.patch;
        result2 += 31 * result2 + ((Object)this.rest).hashCode();
        return result2;
    }

    @NotNull
    public final int[] getNumbers() {
        return this.numbers;
    }

    public BinaryVersion(int ... numbers) {
        Intrinsics.checkParameterIsNotNull(numbers, "numbers");
        this.numbers = numbers;
        Integer n = ArraysKt.getOrNull(this.numbers, 0);
        this.major = n != null ? n : BinaryVersion.Companion.getUNKNOWN();
        Integer n2 = ArraysKt.getOrNull(this.numbers, 1);
        this.minor = n2 != null ? n2 : BinaryVersion.Companion.getUNKNOWN();
        Integer n3 = ArraysKt.getOrNull(this.numbers, 2);
        this.patch = n3 != null ? n3 : BinaryVersion.Companion.getUNKNOWN();
        this.rest = this.numbers.length > 3 ? CollectionsKt.toList((Iterable)ArraysKt.asList(this.numbers).subList(3, this.numbers.length)) : CollectionsKt.emptyList();
    }

    static {
        UNKNOWN = -1;
    }

    public static final class Companion {
        private final int getUNKNOWN() {
            return UNKNOWN;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

