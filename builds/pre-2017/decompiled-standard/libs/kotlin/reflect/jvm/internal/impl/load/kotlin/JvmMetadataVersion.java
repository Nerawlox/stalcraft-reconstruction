/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.BinaryVersion;
import org.jetbrains.annotations.NotNull;

public final class JvmMetadataVersion
extends BinaryVersion {
    private static boolean skipCheck;
    @JvmField
    @NotNull
    public static final JvmMetadataVersion INSTANCE;
    @JvmField
    @NotNull
    public static final JvmMetadataVersion INVALID_VERSION;
    public static final Companion Companion;

    @Override
    public boolean isCompatible() {
        return Companion.getSkipCheck() || this.getMajor() == 1 && this.getMinor() == 1;
    }

    public JvmMetadataVersion(int ... numbers) {
        Intrinsics.checkParameterIsNotNull(numbers, "numbers");
        super(Arrays.copyOf(numbers, numbers.length));
    }

    static {
        Companion = new Companion(null);
        INSTANCE = new JvmMetadataVersion(1, 1, 5);
        INVALID_VERSION = new JvmMetadataVersion(new int[0]);
    }

    public static final class Companion {
        public final boolean getSkipCheck() {
            return skipCheck;
        }

        public final void setSkipCheck(boolean bl) {
            skipCheck = bl;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

