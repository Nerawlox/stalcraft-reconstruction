/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmMetadataVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinClassHeader {
    @NotNull
    private final Kind kind;
    @NotNull
    private final JvmMetadataVersion metadataVersion;
    @NotNull
    private final JvmBytecodeBinaryVersion bytecodeVersion;
    @Nullable
    private final String[] data;
    @Nullable
    private final String[] incompatibleData;
    @Nullable
    private final String[] strings;
    @Nullable
    private final String extraString;
    private final int extraInt;

    @Nullable
    public final String getMultifileClassName() {
        return Intrinsics.areEqual((Object)this.kind, (Object)Kind.MULTIFILE_CLASS_PART) ? this.extraString : null;
    }

    @Nullable
    public final MultifileClassKind getMultifileClassKind() {
        return Intrinsics.areEqual((Object)this.kind, (Object)Kind.MULTIFILE_CLASS) || Intrinsics.areEqual((Object)this.kind, (Object)Kind.MULTIFILE_CLASS_PART) ? ((this.extraInt & 1) != 0 ? MultifileClassKind.INHERITING : MultifileClassKind.DELEGATING) : null;
    }

    public final boolean isPreRelease() {
        return (this.extraInt & 2) != 0;
    }

    public final boolean isScript() {
        return (this.extraInt & 4) != 0;
    }

    @NotNull
    public String toString() {
        return (Object)((Object)this.kind) + " version=" + this.metadataVersion;
    }

    @NotNull
    public final Kind getKind() {
        return this.kind;
    }

    @NotNull
    public final JvmMetadataVersion getMetadataVersion() {
        return this.metadataVersion;
    }

    @NotNull
    public final JvmBytecodeBinaryVersion getBytecodeVersion() {
        return this.bytecodeVersion;
    }

    @Nullable
    public final String[] getData() {
        return this.data;
    }

    @Nullable
    public final String[] getIncompatibleData() {
        return this.incompatibleData;
    }

    @Nullable
    public final String[] getStrings() {
        return this.strings;
    }

    @Nullable
    public final String getExtraString() {
        return this.extraString;
    }

    public final int getExtraInt() {
        return this.extraInt;
    }

    public KotlinClassHeader(@NotNull Kind kind, @NotNull JvmMetadataVersion metadataVersion, @NotNull JvmBytecodeBinaryVersion bytecodeVersion, @Nullable String[] data2, @Nullable String[] incompatibleData, @Nullable String[] strings, @Nullable String extraString, int extraInt) {
        Intrinsics.checkParameterIsNotNull((Object)kind, "kind");
        Intrinsics.checkParameterIsNotNull(metadataVersion, "metadataVersion");
        Intrinsics.checkParameterIsNotNull(bytecodeVersion, "bytecodeVersion");
        this.kind = kind;
        this.metadataVersion = metadataVersion;
        this.bytecodeVersion = bytecodeVersion;
        this.data = data2;
        this.incompatibleData = incompatibleData;
        this.strings = strings;
        this.extraString = extraString;
        this.extraInt = extraInt;
    }

    public static final class Kind
    extends Enum<Kind> {
        public static final /* enum */ Kind UNKNOWN;
        public static final /* enum */ Kind CLASS;
        public static final /* enum */ Kind FILE_FACADE;
        public static final /* enum */ Kind SYNTHETIC_CLASS;
        public static final /* enum */ Kind MULTIFILE_CLASS;
        public static final /* enum */ Kind MULTIFILE_CLASS_PART;
        private static final /* synthetic */ Kind[] $VALUES;
        private final int id;
        private static final Map<Integer, Kind> entryById;
        public static final Companion Companion;

        /*
         * WARNING - void declaration
         */
        static {
            Map map2;
            void $receiver$iv$iv;
            UNKNOWN = new Kind(0);
            CLASS = new Kind(1);
            FILE_FACADE = new Kind(2);
            SYNTHETIC_CLASS = new Kind(3);
            MULTIFILE_CLASS = new Kind(4);
            MULTIFILE_CLASS_PART = new Kind(5);
            $VALUES = new Kind[]{UNKNOWN, CLASS, FILE_FACADE, SYNTHETIC_CLASS, MULTIFILE_CLASS, MULTIFILE_CLASS_PART};
            Companion = new Companion(null);
            Object[] $receiver$iv = (Object[])Kind.values();
            Kind[] kindArray = $VALUES;
            int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity($receiver$iv.length), 16);
            Object[] objectArray = $receiver$iv;
            Map destination$iv$iv = new LinkedHashMap(capacity$iv);
            for (int i = 0; i < ((void)$receiver$iv$iv).length; ++i) {
                void receiver;
                void element$iv$iv;
                void var7_7 = element$iv$iv = $receiver$iv$iv[i];
                map2 = destination$iv$iv;
                Integer n = ((Kind)receiver).id;
                map2.put(n, element$iv$iv);
            }
            map2 = destination$iv$iv;
            Kind[] kindArray2 = kindArray;
            entryById = map2;
        }

        public final int getId() {
            return this.id;
        }

        protected Kind(int id) {
            this.id = id;
        }

        public static Kind[] values() {
            return (Kind[])$VALUES.clone();
        }

        public static Kind valueOf(String string) {
            return Enum.valueOf(Kind.class, string);
        }

        @JvmStatic
        @NotNull
        public static final Kind getById(int id) {
            return Companion.getById(id);
        }

        public static final class Companion {
            private final Map<Integer, Kind> getEntryById() {
                return entryById;
            }

            @JvmStatic
            @NotNull
            public final Kind getById(int id) {
                Kind kind = this.getEntryById().get(id);
                if (kind == null) {
                    kind = UNKNOWN;
                }
                return kind;
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }
        }
    }

    public static final class MultifileClassKind
    extends Enum<MultifileClassKind> {
        public static final /* enum */ MultifileClassKind DELEGATING;
        public static final /* enum */ MultifileClassKind INHERITING;
        private static final /* synthetic */ MultifileClassKind[] $VALUES;

        static {
            MultifileClassKind[] multifileClassKindArray = new MultifileClassKind[2];
            MultifileClassKind[] multifileClassKindArray2 = multifileClassKindArray;
            multifileClassKindArray[0] = DELEGATING = new MultifileClassKind();
            multifileClassKindArray[1] = INHERITING = new MultifileClassKind();
            $VALUES = multifileClassKindArray;
        }

        public static MultifileClassKind[] values() {
            return (MultifileClassKind[])$VALUES.clone();
        }

        public static MultifileClassKind valueOf(String string) {
            return Enum.valueOf(MultifileClassKind.class, string);
        }
    }
}

