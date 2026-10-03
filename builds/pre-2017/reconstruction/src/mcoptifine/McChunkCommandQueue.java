/*
 * Decompiled with CFR 0.152.
 */
package mcoptifine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class McChunkCommandQueue {
    private static final Object lock = new Object();
    private static final List<Runnable> runnables = new ArrayList<Runnable>();
    private static final List<Runnable> runnablesToExecute = new ArrayList<Runnable>();
    public static boolean allowChunkTessellation = false;
    public static int workingTessellators = 0;

    private McChunkCommandQueue() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void postTask(Runnable runnable) {
        Object object = lock;
        synchronized (object) {
            runnables.add(runnable);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void runTasks() {
        assert (McChunkCommandQueue.isMinecraftThread());
        Iterator<Runnable> iterator2 = lock;
        synchronized (iterator2) {
            runnablesToExecute.clear();
            runnablesToExecute.addAll(runnables);
            runnables.clear();
        }
        for (Runnable runnable : runnablesToExecute) {
            runnable.run();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void setAllowTesselation(boolean bl) {
        assert (McChunkCommandQueue.isMinecraftThread());
        Object object = lock;
        synchronized (object) {
            allowChunkTessellation = bl;
            lock.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void waitTessellationsFinish() {
        assert (McChunkCommandQueue.isMinecraftThread());
        Object object = lock;
        synchronized (object) {
            lock.notifyAll();
            while (workingTessellators > 0) {
                try {
                    lock.wait();
                }
                catch (InterruptedException interruptedException) {}
            }
        }
    }

    public static boolean isMinecraftThread() {
        return Thread.currentThread().getName().contains("Minecraft");
    }
}

