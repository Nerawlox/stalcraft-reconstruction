/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mcoptifine.Config;
import mcoptifine.DirectBufferPool;
import mcoptifine.IWrUpdateControl;
import mcoptifine.IWrUpdateListener;
import mcoptifine.WorldRendererThreaded;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import org.lwjgl.opengl.Pbuffer;

public class WrUpdateThread
extends Thread {
    private Pbuffer pbuffer = null;
    private Object lock = new Object();
    private List updateList = new LinkedList();
    private List updatedList = new LinkedList();
    private int updateCount = 0;
    private Tessellator threadTessellator = new Tessellator(0x200000);
    private boolean working = false;
    private WorldRendererThreaded currentRenderer = null;
    private boolean canWork = false;
    private boolean canWorkToEndOfUpdate = false;
    private boolean terminated = false;
    private static final int MAX_UPDATE_CAPACITY = 10;
    private ThreadUpdateListener updateListener;

    public WrUpdateThread() {
        super("WrUpdateThread");
    }

    @Override
    public void run() {
        this.updateListener = new ThreadUpdateListener(null);
        while (!Thread.interrupted() && !this.terminated) {
            try {
                WorldRendererThreaded worldRendererThreaded = this.getRendererToUpdate();
                if (worldRendererThreaded == null) {
                    return;
                }
                this.checkCanWork(null);
                this.currentRenderer = worldRendererThreaded;
                worldRendererThreaded.updateRenderer(this.updateListener);
                this.rendererUpdated(worldRendererThreaded);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                if (this.currentRenderer != null) {
                    this.currentRenderer.isUpdating = false;
                    this.currentRenderer.needsUpdate = true;
                }
                this.currentRenderer = null;
                this.working = false;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addRendererToUpdate(WorldRenderer worldRenderer, boolean bl) {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            if (worldRenderer.isUpdating) {
                throw new IllegalArgumentException("Renderer already updating");
            }
            if (bl) {
                this.updateList.add(0, worldRenderer);
            } else {
                this.updateList.add(worldRenderer);
            }
            worldRenderer.isUpdating = true;
            this.lock.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private WorldRendererThreaded getRendererToUpdate() {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            while (this.updateList.size() <= 0 || DirectBufferPool.buffersRemaining() < 2) {
                try {
                    this.lock.wait(100L);
                    this.lock.notifyAll();
                    if (!this.terminated) continue;
                    Object var3_4 = null;
                    return var3_4;
                }
                catch (InterruptedException interruptedException) {
                }
            }
            WorldRendererThreaded worldRendererThreaded = (WorldRendererThreaded)this.updateList.remove(0);
            this.lock.notifyAll();
            return worldRendererThreaded;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean hasWorkToDo() {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            return this.updateList.size() > 0 ? true : (this.currentRenderer != null ? true : this.working);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getUpdateCapacity() {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            return this.updateList.size() > 10 ? 0 : 10 - this.updateList.size();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void rendererUpdated(WorldRenderer worldRenderer) {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            this.updatedList.add(worldRenderer);
            ++this.updateCount;
            this.currentRenderer = null;
            this.working = false;
            this.lock.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void finishUpdatedRenderers() {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            Iterator iterator2 = this.updatedList.iterator();
            while (iterator2.hasNext()) {
                WorldRendererThreaded worldRendererThreaded = (WorldRendererThreaded)iterator2.next();
                worldRendererThreaded.isUpdating = false;
                iterator2.remove();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void pause() {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            this.canWork = false;
            this.canWorkToEndOfUpdate = false;
            this.lock.notifyAll();
            while (this.working) {
                try {
                    this.lock.wait();
                }
                catch (InterruptedException interruptedException) {}
            }
            this.finishUpdatedRenderers();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unpause() {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            if (this.working) {
                Config.warn("UpdateThread still working in unpause()!!!");
            }
            this.canWork = true;
            this.canWorkToEndOfUpdate = false;
            this.lock.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unpauseToEndOfUpdate() {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            if (this.working) {
                Config.warn("UpdateThread still working in unpause()!!!");
            }
            if (this.currentRenderer != null) {
                while (this.currentRenderer != null) {
                    this.canWork = false;
                    this.canWorkToEndOfUpdate = true;
                    this.lock.notifyAll();
                    try {
                        this.lock.wait();
                    }
                    catch (InterruptedException interruptedException) {}
                }
                this.pause();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkCanWork(IWrUpdateControl iWrUpdateControl) {
        Thread.yield();
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            while (!(this.canWork || this.canWorkToEndOfUpdate && this.currentRenderer != null)) {
                if (iWrUpdateControl != null) {
                    iWrUpdateControl.pause();
                }
                this.working = false;
                this.lock.notifyAll();
                try {
                    this.lock.wait();
                }
                catch (InterruptedException interruptedException) {}
            }
            this.working = true;
            if (iWrUpdateControl != null) {
                iWrUpdateControl.resume();
            }
            this.lock.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void clearAllUpdates() {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            this.unpauseToEndOfUpdate();
            this.updateList.clear();
            this.lock.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getPendingUpdatesCount() {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            int n = this.updateList.size();
            if (this.currentRenderer != null) {
                ++n;
            }
            return n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int resetUpdateCount() {
        Object object = this.lock;
        Object object2 = this.lock;
        synchronized (object2) {
            int n = this.updateCount;
            this.updateCount = 0;
            return n;
        }
    }

    public void terminate() {
        this.terminated = true;
    }

    private class ThreadUpdateControl
    implements IWrUpdateControl {
        private IWrUpdateControl updateControl = null;
        private boolean paused = false;

        private ThreadUpdateControl() {
        }

        @Override
        public void pause() {
            if (!this.paused) {
                this.paused = true;
                this.updateControl.pause();
            }
        }

        @Override
        public void resume() {
            if (this.paused) {
                this.paused = false;
                this.updateControl.resume();
            }
        }

        public void setUpdateControl(IWrUpdateControl iWrUpdateControl) {
            this.updateControl = iWrUpdateControl;
        }

        ThreadUpdateControl(NamelessClass1229731432 namelessClass1229731432) {
            this();
        }
    }

    private class ThreadUpdateListener
    implements IWrUpdateListener {
        private ThreadUpdateControl tuc;

        private ThreadUpdateListener() {
            WrUpdateThread wrUpdateThread2 = WrUpdateThread.this;
            wrUpdateThread2.getClass();
            this.tuc = wrUpdateThread2.new ThreadUpdateControl(null);
        }

        @Override
        public boolean letMinecraftWork(IWrUpdateControl iWrUpdateControl) {
            this.tuc.setUpdateControl(iWrUpdateControl);
            WrUpdateThread.this.checkCanWork(this.tuc);
            return !WrUpdateThread.this.terminated;
        }

        ThreadUpdateListener(NamelessClass1229731432 namelessClass1229731432) {
            this();
        }
    }

    static class NamelessClass1229731432 {
        NamelessClass1229731432() {
        }
    }
}

