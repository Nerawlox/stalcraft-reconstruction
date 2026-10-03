/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfo$Companion$WhenMappings;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.SinceKotlinInfoTable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SinceKotlinInfo {
    @NotNull
    private final Version version;
    @NotNull
    private final DeprecationLevel level;
    @Nullable
    private final Integer errorCode;
    @Nullable
    private final String message;
    public static final Companion Companion = new Companion(null);

    @NotNull
    public String toString() {
        return "since " + this.version + " " + (Object)((Object)this.level) + (this.errorCode != null ? " error " + this.errorCode : "") + (this.message != null ? ": " + this.message : "");
    }

    @NotNull
    public final Version getVersion() {
        return this.version;
    }

    @NotNull
    public final DeprecationLevel getLevel() {
        return this.level;
    }

    @Nullable
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public SinceKotlinInfo(@NotNull Version version, @NotNull DeprecationLevel level, @Nullable Integer errorCode, @Nullable String message) {
        Intrinsics.checkParameterIsNotNull(version, "version");
        Intrinsics.checkParameterIsNotNull((Object)level, "level");
        this.version = version;
        this.level = level;
        this.errorCode = errorCode;
        this.message = message;
    }

    public static final class Version {
        private final int major;
        private final int minor;
        private final int patch;
        @JvmField
        @NotNull
        public static final Version INFINITY;
        private static final int MAJOR_BITS = 3;
        private static final int MINOR_BITS = 4;
        private static final int PATCH_BITS = 7;
        private static final int MAJOR_MASK = 7;
        private static final int MINOR_MASK = 15;
        private static final int PATCH_MASK = 127;
        public static final Companion Companion;

        @NotNull
        public final String asString() {
            return this.patch == 0 ? this.major + "." + this.minor : this.major + "." + this.minor + "." + this.patch;
        }

        public final void encode(@NotNull Function1<? super Integer, Unit> writeVersion, @NotNull Function1<? super Integer, Unit> writeVersionFull) {
            Intrinsics.checkParameterIsNotNull(writeVersion, "writeVersion");
            Intrinsics.checkParameterIsNotNull(writeVersionFull, "writeVersionFull");
            if (!Intrinsics.areEqual(this, INFINITY)) {
                if (this.major > 7 || this.minor > 15 || this.patch > 127) {
                    writeVersionFull.invoke((Integer)(this.major | this.minor << 8 | this.patch << 16));
                } else {
                    writeVersion.invoke((Integer)(this.major | this.minor << 3 | this.patch << 7));
                }
            }
        }

        @NotNull
        public String toString() {
            return this.asString();
        }

        public final int getMajor() {
            return this.major;
        }

        public final int getMinor() {
            return this.minor;
        }

        public final int getPatch() {
            return this.patch;
        }

        public Version(int major, int minor, int patch) {
            this.major = major;
            this.minor = minor;
            this.patch = patch;
        }

        public /* synthetic */ Version(int n, int n2, int n3, int n4, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n4 & 4) != 0) {
                n3 = 0;
            }
            this(n, n2, n3);
        }

        static {
            Companion = new Companion(null);
            INFINITY = new Version(256, 256, 256);
        }

        public final int component1() {
            return this.major;
        }

        public final int component2() {
            return this.minor;
        }

        public final int component3() {
            return this.patch;
        }

        @NotNull
        public final Version copy(int major, int minor, int patch) {
            return new Version(major, minor, patch);
        }

        @NotNull
        public static /* bridge */ /* synthetic */ Version copy$default(Version version, int n, int n2, int n3, int n4, Object object) {
            if ((n4 & 1) != 0) {
                n = version.major;
            }
            if ((n4 & 2) != 0) {
                n2 = version.minor;
            }
            if ((n4 & 4) != 0) {
                n3 = version.patch;
            }
            return version.copy(n, n2, n3);
        }

        public int hashCode() {
            return (this.major * 31 + this.minor) * 31 + this.patch;
        }

        public boolean equals(Object object) {
            block3: {
                block2: {
                    if (this == object) break block2;
                    if (!(object instanceof Version)) break block3;
                    Version version = (Version)object;
                    if (!(this.major == version.major) || !(this.minor == version.minor) || !(this.patch == version.patch)) break block3;
                }
                return true;
            }
            return false;
        }

        public static final class Companion {
            @NotNull
            public final Version decode(@Nullable Integer version, @Nullable Integer versionFull) {
                return versionFull != null ? new Version((int)(versionFull & 0xFF), versionFull >> 8 & 0xFF, versionFull >> 16 & 0xFF) : (version != null ? new Version(version & 7, version >> 3 & 0xF, version >> 7 & 0x7F) : INFINITY);
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    public static final class Companion {
        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Nullable
        public final SinceKotlinInfo create(@NotNull MessageLite proto, @NotNull NameResolver nameResolver, @NotNull SinceKotlinInfoTable table) {
            DeprecationLevel deprecationLevel;
            int n;
            Intrinsics.checkParameterIsNotNull(proto, "proto");
            Intrinsics.checkParameterIsNotNull(nameResolver, "nameResolver");
            Intrinsics.checkParameterIsNotNull(table, "table");
            MessageLite messageLite = proto;
            if (messageLite instanceof ProtoBuf.Class) {
                if (!((ProtoBuf.Class)proto).hasSinceKotlinInfo()) return null;
                n = ((ProtoBuf.Class)proto).getSinceKotlinInfo();
            } else if (messageLite instanceof ProtoBuf.Constructor) {
                if (!((ProtoBuf.Constructor)proto).hasSinceKotlinInfo()) return null;
                n = ((ProtoBuf.Constructor)proto).getSinceKotlinInfo();
            } else if (messageLite instanceof ProtoBuf.Function) {
                if (!((ProtoBuf.Function)proto).hasSinceKotlinInfo()) return null;
                n = ((ProtoBuf.Function)proto).getSinceKotlinInfo();
            } else if (messageLite instanceof ProtoBuf.Property) {
                if (!((ProtoBuf.Property)proto).hasSinceKotlinInfo()) return null;
                n = ((ProtoBuf.Property)proto).getSinceKotlinInfo();
            } else {
                if (!(messageLite instanceof ProtoBuf.TypeAlias)) throw (Throwable)new IllegalStateException("Unexpected declaration: " + proto.getClass());
                if (!((ProtoBuf.TypeAlias)proto).hasSinceKotlinInfo()) return null;
                n = ((ProtoBuf.TypeAlias)proto).getSinceKotlinInfo();
            }
            int id = n;
            ProtoBuf.SinceKotlinInfo sinceKotlinInfo = table.get(id);
            if (sinceKotlinInfo == null) {
                return null;
            }
            ProtoBuf.SinceKotlinInfo info = sinceKotlinInfo;
            Version version = Version.Companion.decode(info.hasVersion() ? Integer.valueOf(info.getVersion()) : null, info.hasVersionFull() ? Integer.valueOf(info.getVersionFull()) : null);
            ProtoBuf.SinceKotlinInfo.Level level = info.getLevel();
            if (level == null) {
                Intrinsics.throwNpe();
            }
            switch (SinceKotlinInfo$Companion$WhenMappings.$EnumSwitchMapping$0[level.ordinal()]) {
                case 1: {
                    deprecationLevel = DeprecationLevel.WARNING;
                    break;
                }
                case 2: {
                    deprecationLevel = DeprecationLevel.ERROR;
                    break;
                }
                case 3: {
                    deprecationLevel = DeprecationLevel.HIDDEN;
                    break;
                }
                default: {
                    throw new NoWhenBranchMatchedException();
                }
            }
            DeprecationLevel level2 = deprecationLevel;
            Integer errorCode = info.hasErrorCode() ? Integer.valueOf(info.getErrorCode()) : null;
            String message = info.hasMessage() ? nameResolver.getString(info.getMessage()) : null;
            return new SinceKotlinInfo(version, level2, errorCode, message);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

