/*
 * Decompiled with CFR 0.152.
 */
package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SinceKotlinInfoTable {
    private final List<ProtoBuf.SinceKotlinInfo> infos;
    @NotNull
    private static final SinceKotlinInfoTable EMPTY;
    public static final Companion Companion;

    @Nullable
    public final ProtoBuf.SinceKotlinInfo get(int id) {
        return CollectionsKt.getOrNull(this.infos, id);
    }

    private SinceKotlinInfoTable(List<ProtoBuf.SinceKotlinInfo> infos) {
        this.infos = infos;
    }

    static {
        Companion = new Companion(null);
        EMPTY = new SinceKotlinInfoTable(CollectionsKt.<ProtoBuf.SinceKotlinInfo>emptyList());
    }

    public /* synthetic */ SinceKotlinInfoTable(@NotNull List infos, DefaultConstructorMarker $constructor_marker) {
        this(infos);
    }

    public static final class Companion {
        @NotNull
        public final SinceKotlinInfoTable getEMPTY() {
            return EMPTY;
        }

        @NotNull
        public final SinceKotlinInfoTable create(@NotNull ProtoBuf.SinceKotlinInfoTable table) {
            SinceKotlinInfoTable sinceKotlinInfoTable;
            Intrinsics.checkParameterIsNotNull(table, "table");
            if (table.getInfoCount() == 0) {
                sinceKotlinInfoTable = this.getEMPTY();
            } else {
                List<ProtoBuf.SinceKotlinInfo> list = table.getInfoList();
                Intrinsics.checkExpressionValueIsNotNull(list, "table.infoList");
                sinceKotlinInfoTable = new SinceKotlinInfoTable(list, null);
            }
            return sinceKotlinInfoTable;
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

