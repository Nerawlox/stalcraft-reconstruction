/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

public final class JvmBytecodeBinaryVersion
extends BinaryVersion {
    @JvmField
    @NotNull
    public static final JvmBytecodeBinaryVersion INSTANCE;
    @JvmField
    @NotNull
    public static final JvmBytecodeBinaryVersion INVALID_VERSION;
    public static final Companion Companion;

    @Override
    public boolean isCompatible() {
        return this.isCompatibleTo(INSTANCE);
    }

    public JvmBytecodeBinaryVersion(int ... numbers) {
        Intrinsics.checkParameterIsNotNull(numbers, "numbers");
        super(Arrays.copyOf(numbers, numbers.length));
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new JvmBytecodeBinaryVersion(1, 0, 1);
        INVALID_VERSION = new JvmBytecodeBinaryVersion(new int[0]);
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

