/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract class MultiTargetPlatform
implements Comparable<MultiTargetPlatform> {
    @JvmField
    @NotNull
    public static final ModuleDescriptor.Capability<MultiTargetPlatform> CAPABILITY;
    public static final Companion Companion;

    private MultiTargetPlatform() {
    }

    static {
        Companion = new Companion(null);
        CAPABILITY = new ModuleDescriptor.Capability("MULTI_TARGET_PLATFORM");
    }

    public /* synthetic */ MultiTargetPlatform(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    public static final class Common
    extends MultiTargetPlatform {
        public static final Common INSTANCE;

        @Override
        public int compareTo(@NotNull MultiTargetPlatform other) {
            Intrinsics.checkParameterIsNotNull(other, "other");
            return other instanceof Common ? 0 : -1;
        }

        private Common() {
            super(null);
            INSTANCE = this;
        }

        static {
            new Common();
        }
    }

    public static final class Specific
    extends MultiTargetPlatform {
        @NotNull
        private final String platform;

        @Override
        public int compareTo(@NotNull MultiTargetPlatform other) {
            int n;
            Intrinsics.checkParameterIsNotNull(other, "other");
            MultiTargetPlatform multiTargetPlatform = other;
            if (multiTargetPlatform instanceof Common) {
                n = 1;
            } else if (multiTargetPlatform instanceof Specific) {
                n = this.platform.compareTo(((Specific)other).platform);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return n;
        }

        @NotNull
        public final String getPlatform() {
            return this.platform;
        }

        public Specific(@NotNull String platform) {
            Intrinsics.checkParameterIsNotNull(platform, "platform");
            super(null);
            this.platform = platform;
        }

        @NotNull
        public final String component1() {
            return this.platform;
        }

        @NotNull
        public final Specific copy(@NotNull String platform) {
            Intrinsics.checkParameterIsNotNull(platform, "platform");
            return new Specific(platform);
        }

        @NotNull
        public static /* bridge */ /* synthetic */ Specific copy$default(Specific specific, String string, int n, Object object) {
            if ((n & 1) != 0) {
                string = specific.platform;
            }
            return specific.copy(string);
        }

        public String toString() {
            return "Specific(platform=" + this.platform + ")";
        }

        public int hashCode() {
            String string = this.platform;
            return string != null ? string.hashCode() : 0;
        }

        public boolean equals(Object object) {
            block3: {
                block2: {
                    if (this == object) break block2;
                    if (!(object instanceof Specific)) break block3;
                    Specific specific = (Specific)object;
                    if (!Intrinsics.areEqual(this.platform, specific.platform)) break block3;
                }
                return true;
            }
            return false;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

