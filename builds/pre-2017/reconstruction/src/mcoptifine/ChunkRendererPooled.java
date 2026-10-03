/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.renderer.Tessellator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2={"Lmcoptifine/ChunkRendererPooled;", "", "tessellator", "Lnet/minecraft/client/renderer/Tessellator;", "(Lnet/minecraft/client/renderer/Tessellator;)V", "getTessellator", "()Lnet/minecraft/client/renderer/Tessellator;", "Companion", "minecraft"})
public final class ChunkRendererPooled {
    @NotNull
    private final Tessellator tessellator;
    @JvmField
    public static final int RENDERERS_COUNT = 1;
    private static final Object lock;
    private static final ArrayList<ChunkRendererPooled> renderers;
    public static final Companion Companion;

    @NotNull
    public final Tessellator getTessellator() {
        return this.tessellator;
    }

    public ChunkRendererPooled(@NotNull Tessellator tessellator) {
        Intrinsics.checkParameterIsNotNull(tessellator, "tessellator");
        this.tessellator = tessellator;
    }

    static {
        Companion = new Companion(null);
        RENDERERS_COUNT = 1;
        lock = new Object();
        renderers = new ArrayList();
        int n = 0;
        int n2 = RENDERERS_COUNT - 1;
        if (n <= n2) {
            while (true) {
                ChunkRendererPooled.Companion.getRenderers().add(new ChunkRendererPooled(new Tessellator(0x200000)));
                if (n == n2) break;
                ++n;
            }
        }
    }

    @JvmStatic
    @Nullable
    public static final ChunkRendererPooled pop() {
        return Companion.pop();
    }

    @JvmStatic
    public static final void release(@NotNull ChunkRendererPooled chunkRendererPooled) {
        Intrinsics.checkParameterIsNotNull(chunkRendererPooled, "rendererPooled");
        Companion.release(chunkRendererPooled);
    }

    @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=1, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2={"Lmcoptifine/ChunkRendererPooled$Companion;", "", "()V", "RENDERERS_COUNT", "", "lock", "getLock", "()Ljava/lang/Object;", "renderers", "Ljava/util/ArrayList;", "Lmcoptifine/ChunkRendererPooled;", "Lkotlin/collections/ArrayList;", "getRenderers", "()Ljava/util/ArrayList;", "pop", "release", "", "rendererPooled", "minecraft"})
    public static final class Companion {
        private final Object getLock() {
            return lock;
        }

        private final ArrayList<ChunkRendererPooled> getRenderers() {
            return renderers;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @JvmStatic
        @Nullable
        public final ChunkRendererPooled pop() {
            Object object = this.getLock();
            synchronized (object) {
                ChunkRendererPooled chunkRendererPooled;
                block4: {
                    if ((ChunkRendererPooled)CollectionsKt.firstOrNull((List)Companion.getRenderers()) != null) break block4;
                    ChunkRendererPooled chunkRendererPooled2 = null;
                    return chunkRendererPooled2;
                }
                ChunkRendererPooled chunkRendererPooled3 = chunkRendererPooled;
                Companion.getRenderers().remove(chunkRendererPooled3);
                ChunkRendererPooled chunkRendererPooled4 = chunkRendererPooled3;
                return chunkRendererPooled4;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @JvmStatic
        public final void release(@NotNull ChunkRendererPooled chunkRendererPooled) {
            Intrinsics.checkParameterIsNotNull(chunkRendererPooled, "rendererPooled");
            Object object = this.getLock();
            synchronized (object) {
                boolean bl = Companion.getRenderers().add(chunkRendererPooled);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

