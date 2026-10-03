/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u0011\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007\u00a8\u0006\t"}, d2={"Lmcoptifine/ChunkTesselationParams;", "", "hasNormals", "", "(Ljava/lang/String;IZ)V", "getHasNormals", "()Z", "DEFAULT", "Companion", "minecraft"})
public final class ChunkTesselationParams
extends Enum<ChunkTesselationParams> {
    public static final /* enum */ ChunkTesselationParams DEFAULT;
    private static final /* synthetic */ ChunkTesselationParams[] $VALUES;
    private final boolean hasNormals;
    @JvmField
    public static final int QUANTIZATION_POS_SCALE = 1024;
    @JvmField
    public static final int QUANTIZATION_UV_SCALE = 16384;
    @JvmField
    public static final int QUANTIZATION_NORMAL_SCALE = 127;
    @JvmField
    public static final int CHUNK_VERTEX_SIZE = 16;
    @JvmField
    public static final boolean USE_TRIANGLES = false;
    public static final Companion Companion;

    static {
        ChunkTesselationParams[] chunkTesselationParamsArray = new ChunkTesselationParams[1];
        ChunkTesselationParams[] chunkTesselationParamsArray2 = chunkTesselationParamsArray;
        chunkTesselationParamsArray[0] = DEFAULT = new ChunkTesselationParams(false);
        $VALUES = chunkTesselationParamsArray;
        Companion = new Companion(null);
        QUANTIZATION_POS_SCALE = 1024;
        QUANTIZATION_UV_SCALE = 16384;
        QUANTIZATION_NORMAL_SCALE = 127;
        CHUNK_VERTEX_SIZE = 16;
    }

    public final boolean getHasNormals() {
        return this.hasNormals;
    }

    protected ChunkTesselationParams(boolean bl) {
        this.hasNormals = bl;
    }

    /* synthetic */ ChunkTesselationParams(String string, int n, boolean bl, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            bl = false;
        }
        this(bl);
    }

    public static ChunkTesselationParams[] values() {
        return (ChunkTesselationParams[])$VALUES.clone();
    }

    public static ChunkTesselationParams valueOf(String string) {
        return Enum.valueOf(ChunkTesselationParams.class, string);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2={"Lmcoptifine/ChunkTesselationParams$Companion;", "", "()V", "CHUNK_VERTEX_SIZE", "", "QUANTIZATION_NORMAL_SCALE", "QUANTIZATION_POS_SCALE", "QUANTIZATION_UV_SCALE", "USE_TRIANGLES", "", "minecraft"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

