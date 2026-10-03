/*
 * Decompiled with CFR 0.152.
 */
class it
extends Thread {
    final is a;

    it(is par1DedicatedServer) {
        this.a = par1DedicatedServer;
        this.setDaemon(true);
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (true) {
                    Thread.sleep(Integer.MAX_VALUE);
                }
            }
            catch (InterruptedException interruptedException) {
                continue;
            }
            break;
        }
    }
}

