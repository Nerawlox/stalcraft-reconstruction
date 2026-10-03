/*
 * Decompiled with CFR 0.152.
 */
class cp
extends Thread {
    final co a;

    cp(co par1TcpConnection, String par2Str) {
        super(par2Str);
        this.a = par1TcpConnection;
    }

    @Override
    public void run() {
        co.a.getAndIncrement();
        try {
            if (co.a(this.a) && !co.b(this.a)) {
                while (true) {
                    if (co.c(this.a)) {
                        continue;
                    }
                    try {
                        cp.sleep(2L);
                    }
                    catch (InterruptedException interruptedException) {}
                }
            }
        }
        finally {
            co.a.getAndDecrement();
        }
    }
}

