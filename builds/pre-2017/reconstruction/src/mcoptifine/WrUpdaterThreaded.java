/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.util.List;
import mcoptifine.Config;
import mcoptifine.IWrUpdater;
import mcoptifine.WorldRendererThreaded;
import mcoptifine.WrUpdateThread;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class WrUpdaterThreaded
implements IWrUpdater {
    private WrUpdateThread updateThread = null;
    private float timePerUpdateMs = 10.0f;
    private long updateStartTimeNs = 0L;
    private boolean firstUpdate = true;
    private int updateTargetNum = 0;

    @Override
    public void terminate() {
        if (this.updateThread != null) {
            this.updateThread.terminate();
            this.updateThread.unpauseToEndOfUpdate();
        }
    }

    @Override
    public void initialize() {
    }

    private void delayedInit() {
        if (this.updateThread == null) {
            this.createUpdateThread();
        }
    }

    @Override
    public WorldRenderer makeWorldRenderer(World world, List list, int n, int n2, int n3, int n4) {
        return new WorldRendererThreaded(world, list, n, n2, n3, n4);
    }

    public WrUpdateThread createUpdateThread() {
        if (this.updateThread != null) {
            throw new IllegalStateException("UpdateThread is already existing");
        }
        try {
            this.updateThread = new WrUpdateThread();
            this.updateThread.setPriority(1);
            this.updateThread.start();
            this.updateThread.pause();
            return this.updateThread;
        }
        catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public boolean isUpdateThread() {
        return Thread.currentThread() == this.updateThread;
    }

    public static boolean isBackgroundChunkLoading() {
        return true;
    }

    @Override
    public void preRender(cvgz cvgz2, EntityLivingBase entityLivingBase) {
        this.updateTargetNum = 0;
        if (this.updateThread != null) {
            if (this.updateStartTimeNs == 0L) {
                this.updateStartTimeNs = System.nanoTime();
            }
            if (this.updateThread.hasWorkToDo()) {
                this.updateTargetNum = Config.getUpdatesPerFrame();
                if (Config.isDynamicUpdates() && !cvgz2._a(entityLivingBase)) {
                    this.updateTargetNum *= 3;
                }
                this.updateTargetNum = Math.min(this.updateTargetNum, this.updateThread.getPendingUpdatesCount());
                if (this.updateTargetNum > 0) {
                    this.updateThread.unpause();
                }
            }
        }
    }

    @Override
    public void postRender() {
        if (this.updateThread != null) {
            float f = 0.0f;
            if (this.updateTargetNum > 0) {
                long l = System.nanoTime() - this.updateStartTimeNs;
                float f2 = this.timePerUpdateMs * (1.0f + (float)(this.updateTargetNum - 1) / 2.0f);
                if (f2 > 0.0f) {
                    int n = (int)f2;
                    Config.sleep(n);
                }
                this.updateThread.pause();
            }
            float f3 = 0.2f;
            if (this.updateTargetNum > 0) {
                int n = this.updateThread.resetUpdateCount();
                if (n < this.updateTargetNum) {
                    this.timePerUpdateMs += f3;
                }
                if (n > this.updateTargetNum) {
                    this.timePerUpdateMs -= f3;
                }
                if (n == this.updateTargetNum) {
                    this.timePerUpdateMs -= f3;
                }
            } else {
                this.timePerUpdateMs -= f3 / 5.0f;
            }
            if (this.timePerUpdateMs < 0.0f) {
                this.timePerUpdateMs = 0.0f;
            }
            this.updateStartTimeNs = System.nanoTime();
        }
    }

    @Override
    public boolean updateRenderers(cvgz cvgz2, EntityLivingBase entityLivingBase, boolean bl) {
        int n;
        float f;
        int n2;
        this.delayedInit();
        if (cvgz2._h.size() <= 0) {
            return true;
        }
        int n3 = 0;
        int n4 = 4;
        int n5 = 0;
        WorldRenderer worldRenderer = null;
        float f2 = Float.MAX_VALUE;
        int n6 = -1;
        for (n2 = 0; n2 < cvgz2._h.size(); ++n2) {
            WorldRenderer worldRenderer2 = (WorldRenderer)cvgz2._h.get(n2);
            if (worldRenderer2 == null) continue;
            ++n5;
            if (worldRenderer2.isUpdating) continue;
            if (!worldRenderer2.needsUpdate) {
                cvgz2._h.set(n2, null);
                continue;
            }
            f = worldRenderer2.distanceToEntitySquared(entityLivingBase);
            if (!cvgz2._a(worldRenderer2)) continue;
            if (f < 512.0f) {
                if (f < 256.0f && cvgz2._i() && worldRenderer2.isInFrustum || this.firstUpdate) {
                    if (this.updateThread != null) {
                        // empty if block
                    }
                    this.updateRenderer(worldRenderer2, true);
                    cvgz2._h.set(n2, null);
                    ++n3;
                    continue;
                }
                if (this.updateThread != null) {
                    this.updateThread.addRendererToUpdate(worldRenderer2, true);
                    worldRenderer2.needsUpdate = false;
                    cvgz2._h.set(n2, null);
                    ++n3;
                    continue;
                }
            }
            if (!worldRenderer2.isInFrustum) {
                f *= (float)n4;
            }
            if (worldRenderer == null) {
                worldRenderer = worldRenderer2;
                f2 = f;
                n6 = n2;
                continue;
            }
            if (!(f < f2)) continue;
            worldRenderer = worldRenderer2;
            f2 = f;
            n6 = n2;
        }
        n2 = Config.getUpdatesPerFrame();
        boolean bl2 = false;
        if (Config.isDynamicUpdates() && !cvgz2._a(entityLivingBase)) {
            n2 *= 3;
            bl2 = true;
        }
        if (this.updateThread != null && (n2 = this.updateThread.getUpdateCapacity()) <= 0) {
            return true;
        }
        if (worldRenderer != null) {
            this.updateRenderer(worldRenderer);
            cvgz2._h.set(n6, null);
            ++n3;
            f = f2 / 5.0f;
            for (n = 0; n < cvgz2._h.size() && n3 < n2; ++n) {
                float f3;
                WorldRenderer worldRenderer3 = (WorldRenderer)cvgz2._h.get(n);
                if (worldRenderer3 == null || worldRenderer3.isUpdating || !cvgz2._a(worldRenderer3)) continue;
                float f4 = worldRenderer3.distanceToEntitySquared(entityLivingBase);
                if (!worldRenderer3.isInFrustum) {
                    f4 *= (float)n4;
                }
                if (!((f3 = Math.abs(f4 - f2)) < f)) continue;
                this.updateRenderer(worldRenderer3);
                cvgz2._h.set(n, null);
                ++n3;
            }
        }
        if (n5 == 0) {
            cvgz2._h.clear();
        }
        if (cvgz2._h.size() > 100 && n5 < cvgz2._h.size() * 4 / 5) {
            int n7 = 0;
            for (n = 0; n < cvgz2._h.size(); ++n) {
                Object object = cvgz2._h.get(n);
                if (object == null) continue;
                if (n != n7) {
                    cvgz2._h.set(n7, object);
                }
                ++n7;
            }
            for (n = cvgz2._h.size() - 1; n >= n7; --n) {
                cvgz2._h.remove(n);
            }
        }
        this.firstUpdate = false;
        return true;
    }

    private void updateRenderer(WorldRenderer worldRenderer) {
        this.updateRenderer(worldRenderer, false);
    }

    private void updateRenderer(WorldRenderer worldRenderer, boolean bl) {
        WrUpdateThread wrUpdateThread = this.updateThread;
        if (wrUpdateThread != null) {
            wrUpdateThread.addRendererToUpdate(worldRenderer, bl);
            worldRenderer.needsUpdate = false;
        } else {
            worldRenderer.updateRenderer();
            worldRenderer.needsUpdate = false;
            worldRenderer.isUpdating = false;
        }
    }

    @Override
    public void finishCurrentUpdate() {
        if (this.updateThread != null) {
            this.updateThread.unpauseToEndOfUpdate();
        }
    }

    @Override
    public void resumeBackgroundUpdates() {
        if (this.updateThread != null) {
            this.updateThread.unpause();
        }
    }

    @Override
    public void pauseBackgroundUpdates() {
        if (this.updateThread != null) {
            this.updateThread.pause();
        }
    }
}

