/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import gloomyfolken.mods.asm.GloomyHooks;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import mcoptifine.ChunkVboRenderer;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import org.lwjgl.opengl.GL11;

public class WorldRenderer {
    public World worldObj;
    public static volatile int chunksUpdated = 0;
    public int posX;
    public int posY;
    public int posZ;
    public int posXMinus;
    public int posYMinus;
    public int posZMinus;
    public int posXClip;
    public int posYClip;
    public int posZClip;
    public boolean isInFrustum = false;
    public boolean[] skipRenderPass = new boolean[2];
    public int posXPlus;
    public int posYPlus;
    public int posZPlus;
    public volatile boolean needsUpdate;
    public AxisAlignedBB rendererBoundingBox;
    public int chunkIndex;
    public boolean isVisible = true;
    public boolean isWaitingOnOcclusionQuery;
    public int glOcclusionQuery;
    public boolean isChunkLit;
    public boolean isInitialized = false;
    public List tileEntityRenderers = new ArrayList();
    public List tileEntities;
    public int bytesDrawn;
    public boolean isVisibleFromPosition = false;
    public double visibleFromX;
    public double visibleFromY;
    public double visibleFromZ;
    public boolean isInFrustrumFully = false;
    public boolean needsBoxUpdate = false;
    public volatile boolean isUpdating = false;
    public long lastTickUpdated = -1L;
    public boolean wasAddedToLoadedList;
    public boolean skipAllRenderPasses;
    public tvlz[] vboBuffers;

    public WorldRenderer(World world, List list2, int n, int n2, int n3, int n4) {
        this.worldObj = world;
        this.tileEntities = list2;
        this.posX = -999;
        this.setPosition(n, n2, n3);
        this.needsUpdate = false;
        this.vboBuffers = new tvlz[2];
    }

    public void setPosition(int n, int n2, int n3) {
        if (n != this.posX || n2 != this.posY || n3 != this.posZ) {
            this.setDontDraw();
            this.posX = n;
            this.posY = n2;
            this.posZ = n3;
            this.posXPlus = n + 8;
            this.posYPlus = n2 + 8;
            this.posZPlus = n3 + 8;
            this.posXClip = n & 0x3FF;
            this.posYClip = n2;
            this.posZClip = n3 & 0x3FF;
            this.posXMinus = n - this.posXClip;
            this.posYMinus = n2 - this.posYClip;
            this.posZMinus = n3 - this.posZClip;
            float f = 0.0f;
            this.rendererBoundingBox = AxisAlignedBB._a((float)n - f, (float)n2 - f, (float)n3 - f, (float)(n + 16) + f, (float)(n2 + 16) + f, (float)(n3 + 16) + f);
            this.needsBoxUpdate = true;
            this.markDirty();
            this.isVisibleFromPosition = false;
        }
    }

    public void deleteAllBuffers() {
        if (this.vboBuffers != null) {
            for (int i = 0; i < 2; ++i) {
                tvlz tvlz2 = this.vboBuffers[i];
                if (tvlz2 == null) continue;
                tvlz2._e();
                this.vboBuffers[i] = null;
            }
        }
    }

    public void setupGLTranslation() {
        GL11.glTranslatef(this.posXClip, this.posYClip, this.posZClip);
    }

    public void updateRenderer() {
        if (this.worldObj != null && this.needsUpdate) {
            Object object;
            this.isVisible = true;
            this.isVisibleFromPosition = false;
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
            for (int i = 0; i < 2; ++i) {
                this.skipRenderPass[i] = true;
            }
            this.deleteAllBuffers();
            Chunk._a = false;
            HashSet hashSet = new HashSet();
            hashSet.addAll(this.tileEntityRenderers);
            this.tileEntityRenderers.clear();
            int n7 = 1;
            zzie zzie2 = new zzie(this.worldObj, n - n7, n2 - n7, n3 - n7, n4 + n7, n5 + n7, n6 + n7, n7);
            if (!zzie2.extendedLevelsInChunkCache()) {
                ++chunksUpdated;
                object = new RenderBlocks(zzie2);
                this.bytesDrawn = 0;
                Tessellator tessellator = ((RenderBlocks)object).__aF;
                for (int i = 0; i < 2; ++i) {
                    int n8;
                    boolean bl = false;
                    boolean bl2 = false;
                    boolean bl3 = false;
                    for (n8 = n2; n8 < n5; ++n8) {
                        for (int j = n3; j < n6; ++j) {
                            for (int k = n; k < n4; ++k) {
                                boolean bl4;
                                int n9;
                                TileEntity tileEntity;
                                Block block;
                                int n10 = zzie2.getBlockId(k, n8, j);
                                if (n10 <= 0) continue;
                                if (!bl3) {
                                    bl3 = true;
                                    tessellator.setRenderingChunk(true);
                                    tessellator.startDrawingQuads();
                                    tessellator.setTranslation(-this.posX, -this.posY, -this.posZ);
                                }
                                if ((block = Block.blocksList[n10]) == null) continue;
                                if (i == 0 && block.hasTileEntity() && TileEntityRenderer._b._a(tileEntity = zzie2.getBlockTileEntity(k, n8, j))) {
                                    this.tileEntityRenderers.add(tileEntity);
                                }
                                if ((n9 = block.getRenderBlockPass()) != i) {
                                    bl = true;
                                }
                                if (!(bl4 = block.canRenderInPass(i))) continue;
                                bl2 |= ((RenderBlocks)object)._b(block, k, n8, j);
                            }
                        }
                    }
                    if (bl3) {
                        n8 = tessellator.draw();
                        if (bl2 && n8 > 0) {
                            this.bytesDrawn += n8;
                            tvlz tvlz2 = new tvlz(34962, 35044, n8);
                            if (tessellator.vboTesselator != null) {
                                tessellator.vboTesselator.loadDirectly(tvlz2);
                            }
                            this.vboBuffers[i] = tvlz2;
                        }
                        tessellator.setRenderingChunk(false);
                        tessellator.setTranslation(0.0, 0.0, 0.0);
                    } else {
                        bl2 = false;
                    }
                    if (bl2) {
                        this.lastTickUpdated = this.worldObj.worldInfo._h;
                        this.skipRenderPass[i] = false;
                    }
                    if (!bl) break;
                }
            }
            object = new HashSet();
            ((AbstractCollection)object).addAll(this.tileEntityRenderers);
            ((AbstractSet)object).removeAll(hashSet);
            this.tileEntities.addAll(object);
            hashSet.removeAll(this.tileEntityRenderers);
            this.tileEntities.removeAll(hashSet);
            this.isChunkLit = Chunk._a;
            this.isInitialized = true;
            this.updateSkipRenderPasses();
        }
    }

    public void updateSkipRenderPasses() {
        boolean bl;
        this.skipAllRenderPasses = this.skipRenderPass[0] && this.skipRenderPass[1];
        boolean bl2 = bl = !this.skipAllRenderPasses;
        if (bl != this.wasAddedToLoadedList) {
            if (this.skipAllRenderPasses) {
                Minecraft._E()._s._m.add(this);
            } else {
                Minecraft._E()._s._l.add(this);
            }
        }
        this.wasAddedToLoadedList = bl;
    }

    public float distanceToEntitySquared(Entity entity) {
        float f = (float)(entity.posX - (double)this.posXPlus);
        float f2 = (float)(entity.posY - (double)this.posYPlus);
        float f3 = (float)(entity.posZ - (double)this.posZPlus);
        return f * f + f2 * f2 + f3 * f3;
    }

    public void setDontDraw() {
        for (int i = 0; i < 2; ++i) {
            this.skipRenderPass[i] = true;
        }
        this.isInFrustum = false;
        this.isInitialized = false;
        this.skipAllRenderPasses = true;
        this.deleteAllBuffers();
    }

    public void stopRendering() {
        this.setDontDraw();
        this.worldObj = null;
    }

    public void updateInFrustum(lpai lpai2) {
        this.isInFrustum = lpai2._a(this.rendererBoundingBox);
    }

    public int callForRenderPass(int n) {
        tvlz tvlz2 = this.vboBuffers[n];
        if (tvlz2 != null) {
            this.drawVboBuffer(tvlz2);
        }
        return -1;
    }

    public void drawVboBuffer(tvlz tvlz2) {
        ChunkVboRenderer.enableVertexAttribsDirectly(tvlz2);
        if (tvlz2._c <= 0) {
            throw new IllegalStateException("wtf, zero-sized VBO for chunk renderer at: x=" + this.posX + ", y=" + this.posY + ", z=" + this.posZ);
        }
        try {
            GL11.glDrawArrays(7, 0, tvlz2._c / 16);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }
    }

    public void drawOcclusionQueryAABB() {
        float f = 0.0f;
        RenderItem.renderAABB(AxisAlignedBB._a()._a((float)this.posXClip - f, (float)this.posYClip - f, (float)this.posZClip - f, (float)(this.posXClip + 16) + f, (float)(this.posYClip + 16) + f, (float)(this.posZClip + 16) + f));
    }

    public boolean skipAllRenderPasses() {
        if (GloomyHooks.isRendererHidden(this)) {
            return true;
        }
        return this.skipAllRenderPasses;
    }

    public void markDirty() {
        this.needsUpdate = true;
    }
}

