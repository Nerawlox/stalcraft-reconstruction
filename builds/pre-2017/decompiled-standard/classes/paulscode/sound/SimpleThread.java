/*
 * Decompiled with CFR 0.152.
 */
package paulscode.sound;

public class SimpleThread
extends Thread {
    private static final boolean GET = false;
    private static final boolean SET = true;
    private static final boolean XXX = false;
    private boolean alive = true;
    private boolean kill = false;

    protected void cleanup() {
        this.kill(true, true);
        this.alive(true, false);
    }

    @Override
    public void run() {
        this.cleanup();
    }

    public void restart() {
        new Thread(){

            @Override
            public void run() {
                SimpleThread.this.rerun();
            }
        }.start();
    }

    private void rerun() {
        this.kill(true, true);
        while (this.alive(false, false)) {
            this.snooze(100L);
        }
        this.alive(true, true);
        this.kill(true, false);
        this.run();
    }

    public boolean alive() {
        return this.alive(false, false);
    }

    public void kill() {
        this.kill(true, true);
    }

    protected boolean dying() {
        return this.kill(false, false);
    }

    private synchronized boolean alive(boolean bl, boolean bl2) {
        if (bl) {
            this.alive = bl2;
        }
        return this.alive;
    }

    private synchronized boolean kill(boolean bl, boolean bl2) {
        if (bl) {
            this.kill = bl2;
        }
        return this.kill;
    }

    protected void snooze(long l) {
        try {
            Thread.sleep(l);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }
}

