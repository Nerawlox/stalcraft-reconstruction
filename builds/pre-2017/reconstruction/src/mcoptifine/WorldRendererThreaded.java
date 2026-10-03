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
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import org.jetbrains.annotations.NotNull;

public class WorldRendererThreaded
extends WorldRenderer {
    private tvlz[] vboBuffersToRender = new tvlz[2];
    private volatile boolean terminating = false;
    private static ExecutorService uploader = Executors.newFixedThreadPool(2);

    public WorldRendererThreaded(World world, List list2, int n, int n2, int n3, int n4) {
        super(world, list2, n, n2, n3, n4);
    }

    @Override
    public void updateRenderer() {
        if (this.worldObj != null) {
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
    public void setDontDraw() {
        for (int i = 0; i < 2; ++i) {
            this.skipRenderPass[i] = true;
        }
        this.isInFrustum = false;
        this.isInitialized = false;
        this.skipAllRenderPasses = true;
        this.deleteBuffers(this.vboBuffersToRender);
    }

    @Override
    public void stopRendering() {
        this.terminating = true;
        this.deleteBuffers(this.vboBuffers);
        super.stopRendering();
    }

    public void updateRenderer(IWrUpdateListener iWrUpdateListener) {
        if (this.worldObj != null) {
            this.needsUpdate = false;
            int n = this.posX;
            int n2 = this.posY;
            int n3 = this.posZ;
            int n4 = this.posX + 16;
            int n5 = this.posY + 16;
            int n6 = this.posZ + 16;
            if (this.posY == 0) {
                n2 = 1;
            }
            Chunk._a = false;
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.tileEntityRenderers);
            this.tileEntityRenderers.clear();
            boolean bl = true;
            if (iWrUpdateListener != null) {
                this.parallelUpdate(iWrUpdateListener);
                HashSet hashSet2 = new HashSet();
                hashSet2.addAll(this.tileEntityRenderers);
                hashSet2.removeAll(hashSet);
                this.tileEntities.addAll(hashSet2);
                hashSet.removeAll(this.tileEntityRenderers);
                this.tileEntities.removeAll(hashSet);
                this.isChunkLit = Chunk._a;
                this.isInitialized = true;
                this.isVisible = true;
                this.isVisibleFromPosition = false;
            } else {
                super.updateRenderer();
            }
        }
    }

    private void parallelUpdate(@NotNull IWrUpdateListener iWrUpdateListener) {
        block20: {
            if (iWrUpdateListener == null) {
                WorldRendererThreaded.$$$reportNull$$$0(0);
            }
            this.needsUpdate = false;
            int n = this.posX;
            int n2 = this.posY;
            int n3 = this.posZ;
            int n4 = this.posX + 16;
            int n5 = this.posY + 16;
            int n6 = this.posZ + 16;
            if (this.posY == 0) {
                n2 = 1;
            }
            int n7 = 1;
            ++WorldRenderer.chunksUpdated;
            ChunkRendererPooled chunkRendererPooled = ChunkRendererPooled.pop();
            Tessellator tessellator = chunkRendererPooled.getTessellator();
            try {
                zzie zzie2 = new zzie(this.worldObj, n - n7, n2 - n7, n3 - n7, n4 + n7, n5 + n7, n6 + n7, n7);
                if (zzie2.extendedLevelsInChunkCache()) break block20;
                WrUpdateControl wrUpdateControl = new WrUpdateControl();
                RenderBlocks renderBlocks = new RenderBlocks(zzie2);
                renderBlocks.__aF = tessellator;
                tessellator.setOwnerThread(Thread.currentThread());
                boolean[] blArray = new boolean[2];
                this.bytesDrawn = 0;
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
                                TileEntity tileEntity;
                                int n11 = zzie2.getBlockId(j, n9, n8);
                                if (n11 <= 0) continue;
                                if (!bl3) {
                                    bl3 = true;
                                    tessellator.setRenderingChunk(true);
                                    tessellator.startDrawingQuads();
                                    tessellator.setTranslation(-this.posX, -this.posY, -this.posZ);
                                }
                                Block block = Block.blocksList[n11];
                                if (i == 0 && block.hasTileEntity() && TileEntityRenderer._b._a(tileEntity = zzie2.getBlockTileEntity(j, n9, n8))) {
                                    this.tileEntityRenderers.add(tileEntity);
                                }
                                if ((n10 = block.getRenderBlockPass()) != i) {
                                    bl = true;
                                }
                                if (!(bl4 = block.canRenderInPass(i))) continue;
                                bl2 |= renderBlocks._b(block, j, n9, n8);
                            }
                        }
                    }
                    n9 = i;
                    blArray[i] = true;
                    if (bl3) {
                        iWrUpdateListener.letMinecraftWork(wrUpdateControl);
                        n8 = tessellator.draw();
                        if (bl2 && n8 > 0 && tessellator.vboTesselator != null) {
                            this.bytesDrawn += n8;
                            blArray[i] = false;
                            ByteBuffer byteBuffer = DirectBufferPool.popCapableOf(n8);
                            while (byteBuffer == null) {
                                byteBuffer = DirectBufferPool.popCapableOf(n8);
                                Thread.yield();
                            }
                            ByteBuffer byteBuffer2 = byteBuffer;
                            tessellator.vboTesselator.mapData(byteBuffer2);
                            McChunkCommandQueue.postTask(() -> this.uploadPass(byteBuffer2, n9, n8));
                        }
                        tessellator.setRenderingChunk(false);
                        tessellator.setTranslation(0.0, 0.0, 0.0);
                    }
                    if (blArray[i]) {
                        McChunkCommandQueue.postTask(() -> {
                            this.skipRenderPass[n] = true;
                            this.updateSkipRenderPasses();
                            this.deleteBuffer(this.vboBuffersToRender, n9);
                        });
                    }
                    if (bl || i != 0) continue;
                    McChunkCommandQueue.postTask(() -> {
                        this.skipRenderPass[n + 1] = true;
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
                if (tessellator != null && tessellator.isDrawing) {
                    tessellator.draw();
                    tessellator.setRenderingChunk(false);
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
                this.skipRenderPass[n] = false;
                this.updateSkipRenderPasses();
                if (this.terminating) {
                    this.stopRendering();
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

