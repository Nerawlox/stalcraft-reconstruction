/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;

class cq
extends Thread {
    final co a;

    cq(co par1TcpConnection, String par2Str) {
        super(par2Str);
        this.a = par1TcpConnection;
    }

    @Override
    public void run() {
        block12: {
            co.b.getAndIncrement();
            block7: while (true) {
                while (co.a(this.a)) {
                    boolean flag = false;
                    while (co.d(this.a)) {
                        flag = true;
                    }
                    try {
                        if (flag && co.e(this.a) != null) {
                            co.e(this.a).flush();
                        }
                    }
                    catch (IOException ioexception) {
                        if (!co.f(this.a)) {
                            co.a(this.a, ioexception);
                        }
                        ioexception.printStackTrace();
                    }
                    try {
                        cq.sleep(2L);
                        continue block7;
                    }
                    catch (InterruptedException interruptedException) {
                    }
                }
                break block12;
                {
                    continue block7;
                    break;
                }
                break;
            }
            finally {
                co.b.getAndDecrement();
            }
        }
    }
}

