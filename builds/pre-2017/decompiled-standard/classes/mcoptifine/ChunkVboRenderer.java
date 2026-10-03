/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mcoptifine.ChunkTesselationParams;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\b\u0010\u0007\u001a\u00020\u0004H\u0007J0\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u00a8\u0006\u0013"}, d2={"Lmcoptifine/ChunkVboRenderer;", "", "()V", "disableVertexAttrib", "", "index", "", "disableVertexAttribsDirectly", "enableVertexAttrib", "size", "type", "normalized", "", "offset", "", "enableVertexAttribsDirectly", "vbo", "Lgloomyfolken/mods/effects/client/loaders/GlBuffer;", "genVao", "minecraft"})
public final class ChunkVboRenderer {
    public static final ChunkVboRenderer INSTANCE;

    @JvmStatic
    public static final int genVao(@NotNull tvlz tvlz2) {
        Intrinsics.checkParameterIsNotNull(tvlz2, "vbo");
        int n = GL30.glGenVertexArrays();
        GL30.glBindVertexArray(n);
        ChunkVboRenderer.enableVertexAttribsDirectly(tvlz2);
        GL30.glBindVertexArray(0);
        GL15.glBindBuffer(34962, 0);
        return n;
    }

    @JvmStatic
    public static final void enableVertexAttribsDirectly(@NotNull tvlz tvlz2) {
        Intrinsics.checkParameterIsNotNull(tvlz2, "vbo");
        tvlz2._a();
        ChunkVboRenderer.enableVertexAttrib(tfsl.getPosLightLoc(), 4, 5122, false, 0L);
        ChunkVboRenderer.enableVertexAttrib(tfsl.getColorLoc(), 4, 5121, true, 8L);
        ChunkVboRenderer.enableVertexAttrib(tfsl.getUvLoc(), 2, 5122, false, 12L);
    }

    @JvmStatic
    public static final void disableVertexAttribsDirectly() {
        ChunkVboRenderer.disableVertexAttrib(tfsl.getPosLightLoc());
        ChunkVboRenderer.disableVertexAttrib(tfsl.getColorLoc());
        ChunkVboRenderer.disableVertexAttrib(tfsl.getUvLoc());
    }

    @JvmStatic
    public static final void enableVertexAttrib(int n, int n2, int n3, boolean bl, long l) {
        if (n >= 0) {
            GL20.glVertexAttribPointer(n, n2, n3, bl, ChunkTesselationParams.CHUNK_VERTEX_SIZE, l);
            GL20.glEnableVertexAttribArray(n);
        }
    }

    @JvmStatic
    private static final void disableVertexAttrib(int n) {
        if (n >= 0) {
            GL20.glDisableVertexAttribArray(n);
        }
    }

    private ChunkVboRenderer() {
        INSTANCE = this;
    }

    static {
        new ChunkVboRenderer();
    }
}

