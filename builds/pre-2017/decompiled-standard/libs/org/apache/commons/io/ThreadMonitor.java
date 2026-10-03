/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io;

class ThreadMonitor
implements Runnable {
    private final Thread thread;
    private final long timeout;

    public static Thread start(long timeout) {
        return ThreadMonitor.start(Thread.currentThread(), timeout);
    }

    public static Thread start(Thread thread2, long timeout) {
        Thread monitor = null;
        if (timeout > 0L) {
            ThreadMonitor timout = new ThreadMonitor(thread2, timeout);
            monitor = new Thread((Runnable)timout, ThreadMonitor.class.getSimpleName());
            monitor.setDaemon(true);
            monitor.start();
        }
        return monitor;
    }

    public static void stop(Thread thread2) {
        if (thread2 != null) {
            thread2.interrupt();
        }
    }

    private ThreadMonitor(Thread thread2, long timeout) {
        this.thread = thread2;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.timeout);
            this.thread.interrupt();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }
}

