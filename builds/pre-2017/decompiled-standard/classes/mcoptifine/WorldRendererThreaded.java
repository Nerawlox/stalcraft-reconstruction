/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import gloomyfolken.mods.asm.Logger;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mcoptifine.ChunkRendererPooled;
import mcoptifine.DirectBufferPool;
import mcoptifine.IWrUpdateListener;
import mcoptifine.McChunkCommandQueue;
import mcoptifine.WrUpdateControl;
import org.jetbrains.annotations.NotNull;

public class WorldRendererThreaded
extends nvgj {
    private tvlz[] vboBuffersToRender = new tvlz[2];
    private volatile boolean terminating = false;
    private static ExecutorService uploader = Executors.newFixedThreadPool(2);

    public WorldRendererThreaded(ozlu ozlu2, List list2, int n, int n2, int n3, int n4) {
        super(ozlu2, list2, n, n2, n3, n4);
    }

    @Override
    public void func_78907_a() {
        if (this.field_78924_a != null) {
            this.updateRenderer(null);
            Logger.info("finishing update from main thread: " + this, new Object[0]);
        }
    }

    private void deleteBuffers(tvlz[] tvlzArray) {
        for (int i = 0; i < 2; ++i) {
            this.deleteBuffer(tvlzArray, i);
        }
    }

    private void deleteBuffer(tvlz[] tvlzArray, int n) {
        tvlz tvlz2;
        assert (WorldRendererThreaded.isMinecraftThread());
        if (tvlzArray != null && (tvlz2 = tvlzArray[n]) != null) {
            if (tvlz2._c()) {
                McChunkCommandQueue.postTask(() -> this.deleteBuffer(tvlzArray, n));
            } else {
                tvlz2._e();
                tvlzArray[n] = null;
            }
        }
    }

    @Override
    public void func_78910_b() {
        for (int i = 0; i < 2; ++i) {
            this.field_78928_m[i] = true;
        }
        this.field_78927_l = false;
        this.field_78915_A = false;
        this.skipAllRenderPasses = true;
        this.deleteBuffers(this.vboBuffersToRender);
    }

    @Override
    public void func_78911_c() {
        this.terminating = true;
        this.deleteBuffers(this.vboBuffers);
        super.func_78911_c();
    }

    public void updateRenderer(IWrUpdateListener iWrUpdateListener) {
        if (this.field_78924_a != null) {
            this.field_78939_q = false;
            int n = this.field_78923_c;
            int n2 = this.field_78920_d;
            int n3 = this.field_78921_e;
            int n4 = this.field_78923_c + 16;
            int n5 = this.field_78920_d + 16;
            int n6 = this.field_78921_e + 16;
            if (this.field_78920_d == 0) {
                n2 = 1;
            }
            ixzi._a = false;
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.field_78943_x);
            this.field_78943_x.clear();
            boolean bl = true;
            if (iWrUpdateListener != null) {
                this.parallelUpdate(iWrUpdateListener);
                HashSet hashSet2 = new HashSet();
                hashSet2.addAll(this.field_78943_x);
                hashSet2.removeAll(hashSet);
                this.field_78916_B.addAll(hashSet2);
                hashSet.removeAll(this.field_78943_x);
                this.field_78916_B.removeAll(hashSet);
                this.field_78933_w = ixzi._a;
                this.field_78915_A = true;
                this.field_78936_t = true;
                this.isVisibleFromPosition = false;
            } else {
                super.func_78907_a();
            }
        }
    }

    private void parallelUpdate(@NotNull IWrUpdateListener iWrUpdateListener) {
        block20: {
            if (iWrUpdateListener == null) {
                WorldRendererThreaded.$$$reportNull$$$0(0);
            }
            this.field_78939_q = false;
            int n = this.field_78923_c;
            int n2 = this.field_78920_d;
            int n3 = this.field_78921_e;
            int n4 = this.field_78923_c + 16;
            int n5 = this.field_78920_d + 16;
            int n6 = this.field_78921_e + 16;
            if (this.field_78920_d == 0) {
                n2 = 1;
            }
            int n7 = 1;
            ++nvgj.field_78922_b;
            ChunkRendererPooled chunkRendererPooled = ChunkRendererPooled.pop();
            htvf htvf2 = chunkRendererPooled.getTessellator();
            try {
                zzie zzie2 = new zzie(this.field_78924_a, n - n7, n2 - n7, n3 - n7, n4 + n7, n5 + n7, n6 + n7, n7);
                if (zzie2.func_72806_N()) break block20;
                WrUpdateControl wrUpdateControl = new WrUpdateControl();
                htvc htvc2 = new htvc(zzie2);
                htvc2.__aF = htvf2;
                htvf2.setOwnerThread(Thread.currentThread());
                boolean[] blArray = new boolean[2];
                this.field_78917_C = 0;
                for (int i = 0; i < 2; ++i) {
                    int n8;
                    int n9;
                    boolean bl = false;
                    boolean bl2 = false;
                    boolean bl3 = false;
                    for (n9 = n2; n9 < n5; ++n9) {
                        if (bl2) {
                            iWrUpdateListener.letMinecraftWork(wrUpdateControl);
                        }
                        for (n8 = n3; n8 < n6; ++n8) {
                            for (int j = n; j < n4; ++j) {
                                boolean bl4;
                                int n10;
                                hurg hurg2;
                                int n11 = zzie2.func_72798_a(j, n9, n8);
                                if (n11 <= 0) continue;
                                if (!bl3) {
                                    bl3 = true;
                                    htvf2.setRenderingChunk(true);
                                    htvf2.func_78382_b();
                                    htvf2.func_78373_b(-this.field_78923_c, -this.field_78920_d, -this.field_78921_e);
                                }
                                twgu twgu2 = twgu.field_71973_m[n11];
                                if (i == 0 && twgu2.func_71887_s() && cekh._b._a(hurg2 = zzie2.func_72796_p(j, n9, n8))) {
                                    this.field_78943_x.add(hurg2);
                                }
                                if ((n10 = twgu2.func_71856_s_()) != i) {
                                    bl = true;
                                }
                                if (!(bl4 = twgu2.canRenderInPass(i))) continue;
                                bl2 |= htvc2._b(twgu2, j, n9, n8);
                            }
                        }
                    }
                    n9 = i;
                    blArray[i] = true;
                    if (bl3) {
                        iWrUpdateListener.letMinecraftWork(wrUpdateControl);
                        n8 = htvf2.func_78381_a();
                        if (bl2 && n8 > 0 && htvf2.vboTesselator != null) {
                            this.field_78917_C += n8;
                            blArray[i] = false;
                            ByteBuffer byteBuffer = DirectBufferPool.popCapableOf(n8);
                            while (byteBuffer == null) {
                                byteBuffer = DirectBufferPool.popCapableOf(n8);
                                Thread.yield();
                            }
                            ByteBuffer byteBuffer2 = byteBuffer;
                            htvf2.vboTesselator.mapData(byteBuffer2);
                            McChunkCommandQueue.postTask(() -> this.uploadPass(byteBuffer2, n9, n8));
                        }
                        htvf2.setRenderingChunk(false);
                        htvf2.func_78373_b(0.0, 0.0, 0.0);
                    }
                    if (blArray[i]) {
                        McChunkCommandQueue.postTask(() -> {
                            this.field_78928_m[n] = true;
                            this.updateSkipRenderPasses();
                            this.deleteBuffer(this.vboBuffersToRender, n9);
                        });
                    }
                    if (bl || i != 0) continue;
                    McChunkCommandQueue.postTask(() -> {
                        this.field_78928_m[n + 1] = true;
                        this.updateSkipRenderPasses();
                        this.deleteBuffer(this.vboBuffersToRender, n9 + 1);
                    });
                    break;
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
                throw exception;
            }
            finally {
                if (htvf2 != null && htvf2.field_78415_z) {
                    htvf2.func_78381_a();
                    htvf2.setRenderingChunk(false);
                }
                ChunkRendererPooled.release(chunkRendererPooled);
            }
        }
    }

    private void uploadPass(ByteBuffer byteBuffer, int n, int n2) {
        assert (WorldRendererThreaded.isMinecraftThread());
        if (this.vboBuffers[n] != null && this.vboBuffers[n]._c()) {
            System.out.println("waiting buffer to upload");
            McChunkCommandQueue.postTask(() -> this.uploadPass(byteBuffer, n, n2));
            return;
        }
        tvlz tvlz2 = this.createGlBuffer(n, n2);
        ByteBuffer byteBuffer2 = tvlz2._a(0, n2, false, false);
        tvlz2._b();
        uploader.execute(() -> {
            byteBuffer.clear();
            byteBuffer.limit(n2);
            byteBuffer2.clear();
            byteBuffer2.limit(n2);
            byteBuffer2.put(byteBuffer);
            DirectBufferPool.release(byteBuffer);
            McChunkCommandQueue.postTask(() -> {
                tvlz2._d();
                tvlz2._b();
                this.swapBuffersAndClear(n);
                this.field_78928_m[n] = false;
                this.updateSkipRenderPasses();
                if (this.terminating) {
                    this.func_78911_c();
                    this.updateSkipRenderPasses();
                }
            });
        });
    }

    private tvlz createGlBuffer(int n, int n2) {
        assert (WorldRendererThreaded.isMinecraftThread());
        this.deleteBuffer(this.vboBuffers, n);
        this.vboBuffers[n] = new tvlz(34962, 35044, n2);
        return this.vboBuffers[n];
    }

    private void swapBuffersAndClear(int n) {
        assert (WorldRendererThreaded.isMinecraftThread());
        tvlz tvlz2 = this.vboBuffers[n];
        this.vboBuffers[n] = this.vboBuffersToRender[n];
        this.vboBuffersToRender[n] = tvlz2;
        this.clearWorkingBuffers(n);
    }

    private void clearWorkingBuffers(int n) {
        assert (WorldRendererThreaded.isMinecraftThread());
        this.deleteBuffer(this.vboBuffers, n);
    }

    @Override
    public int callForRenderPass(int n) {
        if (this.vboBuffersToRender[n] != null) {
            this.vboBuffersToRender[n]._f();
            this.drawVboBuffer(this.vboBuffersToRender[n]);
        }
        return -1;
    }

    private static boolean isMinecraftThread() {
        return Thread.currentThread().getName().contains("Minecraft");
    }

    private static /* synthetic */ void $$$reportNull$$$0(int n) {
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "updateListener", "mcoptifine/WorldRendererThreaded", "parallelUpdate"));
    }
}

