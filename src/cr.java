/*
 * Decompiled with CFR 0.152.
 */
class cr
extends Thread {
    final co a;

    cr(co par1TcpConnection) {
        this.a = par1TcpConnection;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000L);
            if (co.g(this.a).isAlive()) {
                try {
                    co.g(this.a).stop();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (co.h(this.a).isAlive()) {
                try {
                    co.h(this.a).stop();
                }
                catch (Throwable throwable) {}
            }
        }
        catch (InterruptedException interruptedexception) {
            interruptedexception.printStackTrace();
        }
    }
}

