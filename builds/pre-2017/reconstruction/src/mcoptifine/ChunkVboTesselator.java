/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import gloomyfolken.mods.ktcore.VecExtensionsKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mcoptifine.ChunkTesselationParams;
import net.minecraft.util.Vec3;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J>\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003J\u001e\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0011J\u0006\u0010'\u001a\u00020\u001aJ\u0006\u0010(\u001a\u00020\u0003J\u000e\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\nJ\u0010\u0010.\u001a\u00020/2\u0006\u0010!\u001a\u00020\u0003H\u0002J\u0010\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u001cH\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u001cH\u0002J\u0010\u00105\u001a\u0002032\u0006\u00106\u001a\u00020\u001cH\u0002J\b\u00107\u001a\u00020\u001aH\u0002J\u0006\u00108\u001a\u00020\u001aJ\u0006\u00109\u001a\u00020\u001aR\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R!\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00110\u00110\u0010\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0003X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2={"Lmcoptifine/ChunkVboTesselator;", "", "capacity", "", "chunkTesselationParams", "Lmcoptifine/ChunkTesselationParams;", "(ILmcoptifine/ChunkTesselationParams;)V", "bufferIndex", "bufferSize", "byteBuffer", "Ljava/nio/ByteBuffer;", "kotlin.jvm.PlatformType", "getChunkTesselationParams", "()Lmcoptifine/ChunkTesselationParams;", "directBuffer", "quadVertices", "", "Lnet/minecraft/util/Vec3;", "getQuadVertices", "()[Lnet/minecraft/util/Vec3;", "[Lnet/minecraft/util/Vec3;", "uploadAvailable", "", "vertexSizeBytes", "verticesDrawn", "addVertex", "", "x", "", "y", "z", "u", "v", "brightness", "color", "calcNormal", "v0", "v1", "v2", "finishChunkTesselating", "getBytesDrawn", "loadDirectly", "glBuffer", "Lgloomyfolken/mods/effects/client/loaders/GlBuffer;", "mapData", "mappedBuffer", "packBrightnessToByte", "", "packNormalToByte", "n", "packPosToShort", "", "pos", "packUvToShort", "uv", "prepareUpload", "recomputeNormals", "reset", "minecraft"})
public final class ChunkVboTesselator {
    private final int vertexSizeBytes = 16;
    private int bufferSize;
    private ByteBuffer byteBuffer;
    private int bufferIndex;
    private int verticesDrawn;
    private boolean uploadAvailable;
    private ByteBuffer directBuffer;
    @NotNull
    private final Vec3[] quadVertices;
    @NotNull
    private final ChunkTesselationParams chunkTesselationParams;

    private final byte packNormalToByte(float f) {
        return (byte)(f * (float)ChunkTesselationParams.QUANTIZATION_NORMAL_SCALE);
    }

    private final short packPosToShort(float f) {
        return (short)(f * (float)ChunkTesselationParams.QUANTIZATION_POS_SCALE);
    }

    private final short packUvToShort(float f) {
        return (short)(f * (float)ChunkTesselationParams.QUANTIZATION_UV_SCALE);
    }

    private final byte packBrightnessToByte(int n) {
        int n2 = n & 0xFF;
        int n3 = n >> 16 & 0xFF;
        return (byte)(n3 / 16 << 4 | n2 / 16);
    }

    public final void reset() {
        this.bufferIndex = 0;
        this.verticesDrawn = 0;
        this.uploadAvailable = false;
        this.byteBuffer.clear();
    }

    @NotNull
    public final Vec3[] getQuadVertices() {
        return this.quadVertices;
    }

    public final void addVertex(float f, float f2, float f3, float f4, float f5, int n, int n2) {
        if (this.bufferIndex >= this.bufferSize - this.vertexSizeBytes * 2) {
            this.bufferSize *= 2;
            ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.clear();
            this.byteBuffer = ByteBuffer.allocate(this.bufferSize).order(ByteOrder.nativeOrder());
            this.byteBuffer.put(byteBuffer);
            this.byteBuffer.position(this.bufferIndex);
            this.byteBuffer.limit(this.bufferSize);
            hspu._a(this.directBuffer);
            this.directBuffer = BufferUtils.createByteBuffer(this.bufferSize);
        }
        VecExtensionsKt.set(this.quadVertices[this.verticesDrawn % 4], owkq._r(f), owkq._r(f2), owkq._r(f3));
        this.byteBuffer.putShort(this.packPosToShort(f));
        this.byteBuffer.putShort(this.packPosToShort(f2));
        this.byteBuffer.putShort(this.packPosToShort(f3));
        this.byteBuffer.putShort((short)(n & 0xFF));
        this.byteBuffer.put((byte)(n2 & 0xFF));
        this.byteBuffer.put((byte)(n2 >> 8 & 0xFF));
        this.byteBuffer.put((byte)(n2 >> 16 & 0xFF));
        this.byteBuffer.put((byte)(n >> 16 & 0xFF));
        this.byteBuffer.putShort(this.packUvToShort(f4));
        this.byteBuffer.putShort(this.packUvToShort(f5));
        this.bufferIndex = this.byteBuffer.position();
        this.uploadAvailable = true;
        int n3 = this.verticesDrawn;
        this.verticesDrawn = n3 + 1;
    }

    @NotNull
    public final Vec3 calcNormal(@NotNull Vec3 vec3, @NotNull Vec3 vec32, @NotNull Vec3 vec33) {
        Intrinsics.checkParameterIsNotNull(vec3, "v0");
        Intrinsics.checkParameterIsNotNull(vec32, "v1");
        Intrinsics.checkParameterIsNotNull(vec33, "v2");
        Vec3 vec34 = VecExtensionsKt.subVector(vec32, vec3);
        Vec3 vec35 = VecExtensionsKt.subVector(vec33, vec3);
        Vec3 vec36 = vec34._c(vec35);
        Intrinsics.checkExpressionValueIsNotNull(vec36, "d1.crossProduct(d2)");
        return vec36;
    }

    public final void recomputeNormals() {
        this.chunkTesselationParams.getHasNormals();
        throw (Throwable)new IllegalStateException("Not implemented");
    }

    public final void finishChunkTesselating() {
    }

    private final void prepareUpload() {
        if (!this.uploadAvailable) {
            boolean bl = false;
        }
        this.byteBuffer.clear();
        this.byteBuffer.limit(this.getBytesDrawn());
    }

    public final void loadDirectly(@NotNull tvlz tvlz2) {
        Intrinsics.checkParameterIsNotNull(tvlz2, "glBuffer");
        this.prepareUpload();
        this.directBuffer.clear();
        this.directBuffer.limit(this.getBytesDrawn());
        this.directBuffer.put(this.byteBuffer);
        this.directBuffer.flip();
        tvlz2._a();
        GL15.glBufferData(34962, this.directBuffer, 35044);
        tvlz2._b();
    }

    public final void mapData(@NotNull ByteBuffer byteBuffer) {
        Intrinsics.checkParameterIsNotNull(byteBuffer, "mappedBuffer");
        this.prepareUpload();
        byteBuffer.put(this.byteBuffer);
    }

    public final int getBytesDrawn() {
        return this.bufferIndex;
    }

    @NotNull
    public final ChunkTesselationParams getChunkTesselationParams() {
        return this.chunkTesselationParams;
    }

    public ChunkVboTesselator(int n, @NotNull ChunkTesselationParams chunkTesselationParams) {
        Vec3[] vec3Array;
        Intrinsics.checkParameterIsNotNull((Object)chunkTesselationParams, "chunkTesselationParams");
        this.chunkTesselationParams = chunkTesselationParams;
        this.vertexSizeBytes = ChunkTesselationParams.CHUNK_VERTEX_SIZE;
        this.bufferSize = n;
        this.byteBuffer = ByteBuffer.allocate(this.bufferSize).order(ByteOrder.nativeOrder());
        this.directBuffer = BufferUtils.createByteBuffer(this.bufferSize);
        this.byteBuffer.limit(this.bufferSize);
        int n2 = 4;
        ChunkVboTesselator chunkVboTesselator = this;
        Vec3[] vec3Array2 = new Vec3[n2];
        int n3 = 0;
        int n4 = n2 - 1;
        if (n3 <= n4) {
            do {
                Vec3 vec3;
                int n5 = ++n3;
                int n6 = n3;
                vec3Array = vec3Array2;
                vec3Array[n6] = vec3 = VecExtensionsKt.vec3();
            } while (n3 != n4);
        }
        vec3Array = vec3Array2;
        chunkVboTesselator.quadVertices = vec3Array;
    }
}

