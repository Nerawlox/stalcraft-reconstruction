/*
 * Decompiled with CFR 0.152.
 */
package mods.sound.client;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SoundStarterThread
extends Thread {
    private final Object tasksLock = new Object();
    private Queue<Runnable> soundTasks = new ConcurrentLinkedQueue<Runnable>();
    private boolean stopped = false;

    @Override
    public void run() {
        while (!this.stopped) {
            this.runNextTask();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void runNextTask() {
        Runnable runnable;
        Object object = this.tasksLock;
        synchronized (object) {
            if (this.soundTasks.isEmpty()) {
                try {
                    this.tasksLock.wait();
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            runnable = this.soundTasks.poll();
        }
        if (runnable != null) {
            try {
                runnable.run();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public void stopThread() {
        this.stopped = true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addTask(Runnable runnable) {
        Object object = this.tasksLock;
        synchronized (object) {
            this.soundTasks.offer(runnable);
            this.tasksLock.notify();
        }
    }
}

